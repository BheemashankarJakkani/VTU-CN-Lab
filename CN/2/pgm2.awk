#!/usr/bin/awk -f
BEGIN {
pingDrop=0;
}
{
 if (($1 == "d")) 
{
 pingDrop++;
}
}
END {
    printf("NO of ping packets Dropped %d \n",pingDrop);
}
