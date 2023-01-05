// Contributed by - Anuj Das (Gurucharan College, Silchar - @Department of Computer Science)

// 9. Write a JavaScript to read 'n' intergers and count the number of positive integers, negative integers and zeroes in the list.

let positive = 0;
let negative = 0;
let zeroes = 0;
let list = [];

let n = parseInt(prompt(`Enter the size of the List:  `));

for(let i = 0; i < n; i++) {
let num = parseInt(prompt(`Enter Element-${i+1}: `));
list.push(num);
}

list.forEach(x => {
    if( x < 0 ) {
        negative++;
    } else if( x > 0) {
        positive++;
    } else {
        zeroes++;
    }
});

console.log(list);
console.log(`There are ${positive} Positive Integers in the List.`);
console.log(`There are ${negative} Negative Integers in the List.`);
console.log(`There are ${zeroes} Zeroes in the List.`);
