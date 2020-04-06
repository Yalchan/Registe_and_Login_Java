var i = 1;
var j = 1;
function addSocSkill() {
    var obj = document.getElementById('text-field');
    if(obj.value!==''){

        var container = document.getElementById('social-container');
        var chk = document.createElement('input');
        chk.setAttribute('type','text');
        chk.setAttribute('id','social'+i);
        chk.setAttribute('value',obj.value);
        chk.setAttribute('name','social');


        var block = document.createElement("div")

        block.appendChild(chk);

        container.appendChild(block);

                obj.value='';
        document.getElementById(obj.id).focus();
        i=i+1
    }
}

function addProSkill() {
    var obj = document.getElementById('text-field');
    if(obj.value!==''){

        var container = document.getElementById('prof-container');
        var chk = document.createElement('input');
        chk.setAttribute('type','text');
        chk.setAttribute('id','professional'+j);
        chk.setAttribute('value',obj.value);
        chk.setAttribute('name','professional');


        var block = document.createElement("div")

        block.appendChild(chk);
        container.appendChild(block);

        obj.value='';
        document.getElementById(obj.id).focus();
        j=j+1
    }
}