var i = 1;
var j = 1;
function createSocialCheckBox() {
    var obj = document.getElementById('text-field');
    if(obj.value!==''){

        var container = document.getElementById('social-container');
        var chk = document.createElement('input');
        chk.setAttribute('type','checkbox');
        chk.setAttribute('id','social'+i);
        chk.setAttribute('value',obj.value);
        chk.setAttribute('name','social');

        var lbl = document.createElement('label');
        lbl.setAttribute('for','social'+i);

        lbl.appendChild(document.createTextNode(obj.value));

        var block = document.createElement("div")

        block.appendChild(chk);
        block.appendChild(lbl);
        container.appendChild(block);

                obj.value='';
        document.getElementById(obj.id).focus();
        i=i+1
    }
}

function createProfessionalCheckBox() {
    var obj = document.getElementById('text-field');
    if(obj.value!==''){

        var container = document.getElementById('prof-container');
        var chk = document.createElement('input');
        chk.setAttribute('type','checkbox');
        chk.setAttribute('id','professional'+j);
        chk.setAttribute('value',obj.value);
        chk.setAttribute('name','professional');

        var lbl = document.createElement('label');
        lbl.setAttribute('for','professional'+j);

        lbl.appendChild(document.createTextNode(obj.value));

        var block = document.createElement("div")

        block.appendChild(chk);
        block.appendChild(lbl);
        container.appendChild(block);

        obj.value='';
        document.getElementById(obj.id).focus();
        j=j+1
    }
}