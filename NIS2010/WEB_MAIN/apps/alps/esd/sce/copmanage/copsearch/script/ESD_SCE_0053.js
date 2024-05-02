/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var formObj = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var dest_nod = "";
		var frm_nod = "";
		var opener = window.dialogArguments;
		switch(srcName) {
			case 'btn_ok':
				if( formObj.isnodchg.value == "Y" ) {  //Change Inland Dest Node checked Y
					if( doSepRemove(formObj.dest_nod.value, " ") == "" ) {
						formObj.dest_nod.value = "";
						ComShowMessage("Input Dest Nod");
						formObj.dest_nod.focus();
						return;
					}
					if(doSepRemove(formObj.dest_nod.value, " ").length < 7){ // [CHM-201216364] 개발-[SCEM] COP replan 시 S/O check validation 추가요청
						ComShowMessage(ComGetMsg('SCE90039'));
						formObj.dest_nod.focus();
						return;
					}
					dest_nod = formObj.dest_nod.value.toUpperCase();
				}
				if( formObj.isfrmchg.value == "Y" ) { //Change O/B Inland Origin checked Y
					if( doSepRemove(formObj.frm_nod.value, " ") == "" ) {
						if( formObj.bound_name.value == "O" ) {
							ComShowMessage("Input Origin Nod");
						}
						if( formObj.bound_name.value == "I" ) {
							ComShowMessage("Input Dest Nod");
						}
						formObj.frm_nod.value = "";
						formObj.frm_nod.focus();
						return;
					}
					if(doSepRemove(formObj.frm_nod.value, " ").length < 7 ){ // [CHM-201216364] 개발-[SCEM] COP replan 시 S/O check validation 추가요청
						ComShowMessage(ComGetMsg('SCE90039'));
						formObj.frm_nod.focus();
						return;
					}
					frm_nod = formObj.frm_nod.value.toUpperCase();
				}
			/*
				var doc_parm = "ESD_SCE_0009.do?pgmNo=ESD_SCE_0009&cop_no=" + formObj.cop_no.value + "&bound_name=" + formObj.bound_name.value 
				+ "&iscompled=" + formObj.iscompled.value + "&isnodchg=" + formObj.isnodchg.value + "&nodcd=" + dest_nod 
				+ "&isfrmchg=" + formObj.isfrmchg.value + "&frmcd=" + frm_nod
				+"&bkg_no="+formObj.bkg_no.value+"&cop_sts_cd="+formObj.cop_sts_cd.value;
				*/
				//window.opener.openESD009Screen(doc_parm);
				opener.openESD009Screen("ESD_SCE_0009.do", formObj.cop_no.value , formObj.bound_name.value, formObj.iscompled.value,
						formObj.isnodchg.value,dest_nod, formObj.isfrmchg.value,  frm_nod, formObj.bkg_no.value,formObj.cop_sts_cd.value );
				window.close();
				
			break;

			case 'btn_close':
				window.close();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]" ) {
			ComShowMessage(ComGetMsg('COM12111')) ;
		} else {
			ComShowMessage(e) ;
		}
	}
}

function selectCompleted() {
	var radioObj = document.form.comm_choice;
	var radSel1 = document.getElementById('radioSelect1');
	var radSel2 = document.getElementById('radioSelect2');
	var radSel3 = document.getElementById('radioSelect3');
	var radSel4 = document.getElementById('radioSelect4');

	document.form.isnodchg.value = "N";
	document.form.isfrmchg.value = "N";

	if( radioObj[0].checked == true ) {
		document.form.iscompled.value = 'N';
		radSel1.innerHTML =
		"<input type='checkbox' name='dest_nod_check' value='' class='trans' onClick='checktnod()'>Change Inland Dest Node";
		radSel2.innerHTML =
		"<input type='text' name='dest_nod' value='' class='input' disabled style='width:110; text-transform:uppercase;'> <img onClick='openNodPop()' class='cursor' src='/hanjin/img/button/btns_search.gif' width='19' height='20' border='0' align='absmiddle'>";
		radSel3.innerHTML = "";
		radSel4.innerHTML = "";
	} else if( radioObj[1].checked == true ) {
		document.form.iscompled.value = 'Y';
		radSel1.innerHTML = "<input type='radio' name='bound_choice' class='trans' onClick='selectBound()' Checked>Outbound";
		radSel2.innerHTML = "<input type='radio' name='bound_choice' class='trans' onClick='selectBound()'>Inbound";
		radSel3.innerHTML = "<input type='checkbox' name='frm_nod_check' value='' class='trans' onClick='checktFrmnod()'>Change O/B Inland Origin";
		radSel4.innerHTML =
		"<input type='text' name='frm_nod' disabled value = '' class='input' style='width:110; text-transform:uppercase;'> <img onClick='openFrmNodPop()' class='cursor' src='/hanjin/img/button/btns_search.gif' width='19' height='20' border='0' align='absmiddle'>";
	}
}

function openNodPop(){
	openNodePop(false,'dest_nod');
}

function openFrmNodPop(){
	openNodePop(false,'frm_nod');
}

/*
 * Planned Route Only -> Change Inland Dest Node -> dest_nod;
 */
function checktnod() {
	var radioObj = document.form.dest_nod_check;
	if( radioObj.checked == true ) {
		document.form.isnodchg.value = 'Y';
		document.form.dest_nod.disabled = false;
	} else {
		document.form.isnodchg.value = 'N';
		document.form.dest_nod.disabled = true;
		document.form.dest_nod.value = "";
	}
}

/*
 * Include Completed Route  -> OutBound/InBound -> frm_nod;
 */
function checktFrmnod() {
	var radioObj = document.form.frm_nod_check;
	if( radioObj.checked == true ) {
		document.form.isfrmchg.value = 'Y';
		document.form.frm_nod.disabled = false;
	} else {
		document.form.isfrmchg.value = 'N';
		document.form.frm_nod.disabled = true;
		document.form.frm_nod.value = "";
	}
}

function selectBound() {
	var radioObj = document.form.bound_choice;
	var radSel3 = document.getElementById('radioSelect3');
	var radSel4 = document.getElementById('radioSelect4');
	var innHtml = "<input type='text' disabled name='frm_nod' value = '' class='input' style='width:110; text-transform:uppercase;'> <img onClick='openFrmNodPop()' class='cursor' src='/hanjin/img/button/btns_search.gif' width='19' height='20' border='0' align='absmiddle'>";

	if( radioObj[0].checked == true ) {
		document.form.bound_name.value = 'O';
		radSel3.innerHTML = "<input type='checkbox' name='frm_nod_check' value='' class='trans' onClick='checktFrmnod()'>Change O/B Inland Origin";
		radSel4.innerHTML = innHtml;
	} else if( radioObj[1].checked == true ) {
		document.form.bound_name.value = 'I';
		radSel3.innerHTML = "<input type='checkbox' name='frm_nod_check' value='' class='trans' onClick='checktFrmnod()'>Change I/B Inland Dest";
		radSel4.innerHTML = innHtml;
	}
}

/**
 * sep에 해당하는 char를 제거하는 스크립트
 */
function doSepRemove(obj, sep) {
	var ch = "";
	var lvobj = "";
	for(var i=0; i<obj.length; i++) {
		if(obj.charAt(i) == sep) {
			ch = "";
		} else {
			ch = obj.charAt(i);
		}
		lvobj = lvobj + ch;
	}
	return lvobj;
}