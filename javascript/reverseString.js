function revStr(str) {
    if(str === '') return '';
    return revStr(str.substr(1)) + str[0];
}

/*
This function will reverse a string passed into it.
*/