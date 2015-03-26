#!/usr/bin/perl -w
use strict;
use warnings;

open(my $fh, '>', 'output.txt') or die "file not created";
print $fh "this is the output of the perl script\nhihihi\nwheeeeeeeee\n=\)\n";

if (@ARGV){
    foreach (@ARGV){
        print $fh "$_ \n"
    }
}

close $fh;