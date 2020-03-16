//question part 1
node = function(data) {
    this.data = data;
    this.pointer = null;
}

singleLinkList = function() {
    this.header = null;
    this.length = 0;

    this.addNode = function(value) {
        var newNode = new node(value);
        this.length += 1;
        if (this.header == null)
            this.header = newNode;
        else {
            var curr = this.header;
            while (curr.pointer != null)
                curr = curr.pointer;
            curr.pointer = newNode;
        }
    }

    this.deleteAtIndex = function(position) {
        if (this.length < position)
            console.log("index is not present");
        else {
            var curr = this.header;
            while (position > 1) {
                prev = curr;
                curr = curr.pointer;
                position--;
            }
            prev.pointer = curr.pointer;
        }
    }

    this.deleteAtfirst = function() {
        if (this.length < 1)
            console.log("index is not present");
        else {
            this.header = this.header.pointer;
        }
    }

    this.display = function() {
        var curr = this.header;
        while (curr != null) {
            console.log(curr.data);
            curr = curr.pointer;
        }
    }
}

singlelist = new singleLinkList();
singlelist.addNode(2);
singlelist.addNode(3);
singlelist.addNode(5);
singlelist.addNode(8);
singlelist.display();
console.log(singlelist.length);
singlelist.deleteAtIndex(8);
singlelist.display();
singlelist.deleteAtfirst();
singlelist.display();

//question part 2
doubleNode = function(data) {
    this.data = data;
    this.next = null;
    this.prev = null;
}

doublyLinkList = function() {
    this.header = null;
    this.length = 0;

    this.addNode = function(value) {
        var newNode = new doubleNode(value);
        this.length += 1;
        if (this.header == null)
            this.header = newNode;
        else {
            var curr = this.header;
            while (curr.next != null)
                curr = curr.next;
            curr.next = newNode;
            newNode.prev = curr;
        }
    }

    this.deleteAtIndex = function(position) {
        if (this.length < position)
            console.log("index is not present");
        else {
            var curr = this.header;
            while (position > 1) {
                prev = curr;
                curr = curr.next;
                position--;
            }
            prev.next = curr.next;
            curr.prev = null;
        }
    }

    this.deleteAtfirst = function() {
        if (this.length < 1)
            console.log("list is empty");
        else {
            this.header = this.header.next;
            this.header.prev = null;
        }
    }

    this.display = function() {
        var curr = this.header;
        while (curr != null) {
            console.log(curr.data);
            curr = curr.next;
        }
    }
}
doublylist = new doublyLinkList();
doublylist.addNode(2);
doublylist.addNode(3);
doublylist.addNode(5);
doublylist.addNode(8);
doublylist.display();
console.log(doublylist.length);
doublylist.deleteAtIndex(3);
doublylist.display();
doublylist.deleteAtfirst();
doublylist.display();

//question 2
function stringOperation(inputString) {
    var str = "";
    for (var i = 0; i < inputString.length - 1; i++)
        if (inputString[i] == inputString[i + 1]) {
            str += inputString.substring(0, i);
            str += inputString.substring(i + 2, inputString.length);
            console.log(str);
            return stringOperation(str);
        }
    return inputString;
}

console.log(stringOperation("eeabcddcbfgf"));

//question 3
function queue() {
    this.queue = [];

    this.enqueue = function(element) {
        this.queue.push(element);
    }

    this.dequeue = function() {
        this.queue.reverse().pop();
    }
}

book = new queue();
book.enqueue("c");
book.enqueue("c++");
console.log(book.queue);
book.dequeue();
book.enqueue("java");
console.log(book.queue);

//question 4
function stack() {
    this.stack = [];

    this.push = function(element) {
        this.stack.push(element);
    }

    this.pop = function() {
        this.stack.pop();
    }
}

book = new stack();
book.push("c");
book.push("c++");
console.log(book.stack);
book.pop();
book.push("java");
console.log(book.stack);

//question 5
String.prototype.repeatify = function(num) {
    var inputString = this,
        str = "";
    for (var i = 0; i < num; i++)
        str += inputString;
    return str;
}
var inputString = new String('Hello');
console.log(inputString.repeatify(7));