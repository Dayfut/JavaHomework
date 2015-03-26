#!usr/bin/perl
use strict;
use warnings;

sub create_list{
    return undef;
}

sub access_item {
    my $list = shift;
    my $nth = shift;
    
    for (my $i = 0; $i < $nth; $i++){
        $list = $list->[1];
    }
    
    return $list->[0];
}

sub insert_item {
    my $list = $_[0];
    my $insert = $_[1];
    my $pos = $_[2];
    
    if ($pos == 0) {
        return [$insert, $list];
    } else {
        for (my $i = 0; $i < $pos - 1; $i++){
            $list = $list->[1];
        }
        
        $list->[1] = [$insert, $list->[1]]; 
    }
    return $_[0];
}

sub remove_item{
    my $list = $_[0];
    my $pos = $_[1];
    
    if ($pos == 0) {            #if specificed position is 0, return the next reference
        return $list->[1];
    }else {
        for (my $i = 0; $i < $pos - 1; $i++){   #finds the position to be deleted
            $list = $list->[1];
        }   
    }
    $list->[1]= $list->[1]->[1];        #sets reference to the position to point to the reference after
    return $_[0]
}

sub print_list {
    my $list = shift;
    
    if (defined $list->[0]) {
        print "$list->[0] -> \n";
        print_list($list->[1]);
    }
}


#my $test = ['a',['b',['c', []]]];
my $test = create_list();
$test = insert_item($test, 'a', 0);
$test = insert_item($test, 'b', 1);
$test = insert_item($test, 'c', 2);
print "BEFORE INSERT\n";
print_list($test);
my $after_insert = insert_item($test, 'hi', 1);
print "AFTER INSERT\n";
print_list($after_insert);
print "INSERT INTO 0th\n";
$after_insert = insert_item($after_insert, 'begin', 0);
print_list($after_insert);
my $after_delete = remove_item($after_insert, 1);
print "AFTER DELETING INDEX 1\n";
print_list($after_delete);
print "AFTER REMOVING 0th index\n";
$after_delete = remove_item($after_delete,0);
print_list($after_delete)