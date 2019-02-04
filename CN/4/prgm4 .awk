#!/usr/bin/awk
BEGIN {
pktrecvd=0;
throughput=0;
}
{
if(($1=="r")&&($3=="_3_")&&($4=="AGT")&&($7=="tcp")&&($8>1000))
{
pktrecvd++;
}
}
END{
 throughput=((pktrecvd*1000*8)/(95.0*1000000));
printf("throughput is %f",throughput);
}	

