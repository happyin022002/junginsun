﻿// /*=========================================================
// *Copyright(c) 2006 CyberLogitec
// *@FileName : ESD_SCE_0035.jsp
// *@FileTitle : COP POPUP
// *Open Issues :
// *@author : CLT
// *@version : 1.0
// *@since : 2014/07/31
// =========================================================*/
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
function processButtonClick(){
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		var dest_nod="";
		var frm_nod="";
		var opener=window.dialogArguments;
		if (!opener) opener=window.opener;  // 이 코드 추가할것
		if (!opener) opener=parent; // 이 코드 추가할것
		switch(srcName) {
			case 'btn_ok':
				if( formObj.isnodchg.value == "Y" ) {  // Change Inland Dest Node checked Y
					if( doSepRemove(formObj.dest_nod.value, " ") == "" ) {
						formObj.dest_nod.value="";
						ComShowMessage("Input Dest Nod");
						return;
					}
					dest_nod=formObj.dest_nod.value.toUpperCase();
				}
				if( formObj.isfrmchg.value == "Y" ) { // Change O/B Inland Origin checked Y
					if( doSepRemove(formObj.frm_nod.value, " ") == "" ) {
						if( formObj.bound_name.value == "O" ) {
							ComShowMessage("Input Origin Nod");
						}
						if( formObj.bound_name.value == "I" ) {
							ComShowMessage("Input Dest Nod");
						}
						formObj.frm_nod.value="";
						return;
					}
					frm_nod=formObj.frm_nod.value.toUpperCase();
				}
				openOK("ESD_SCE_0009.do", formObj.cop_no.value , formObj.bound_name.value, formObj.iscompled.value, formObj.isnodchg.value,dest_nod, formObj.isfrmchg.value,  frm_nod, formObj.bkg_no.value,formObj.cop_sts_cd.value );
			break;
			case 'btn_close':
				ComClosePopup(); 
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]" ) {
			ComShowMessage(ComGetMsg('COM12111')) ;
		} else {
			ComShowMessage(e.message);
		}
	}
}

function openOK(url, copNo, boundName, iscompled, isnodchg, nodcd, isfrmchg, frmcd, bkg_no, cop_sts_cd){
	var paramUrl="pgmNo=ESD_SCE_0009&cop_no="+copNo+"&bound_name="+boundName+"&iscompled="+iscompled+"&isnodchg="+isnodchg+"&nodcd="+nodcd+
					"&isfrmchg="+isfrmchg+"&frmcd="+frmcd+"&bkg_no="+bkg_no+"&cop_sts_cd="+cop_sts_cd;
	ComOpenPopup('/opuscntr/ESD_SCE_0009.do?' + paramUrl, 916, 730, 'findCopChange', '0,1,1,1,1,1,1,1', false); 
}

/**
 * remove this function not used
 * 
 * @deprecated
 */
function selectCompleted() {
	var radioObj=document.form.comm_choice;
	document.form.isnodchg.value="N";
	document.form.isfrmchg.value="N";
	
	if (radioObj[0].checked){
		$('#boundArea').hide();
	} else if (radioObj[4].checked) {
		$('#boundArea').show();
		document.form.bound_choice[0].checked = true;
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
	var radioObj=document.form.dest_nod_check;
	if( radioObj.checked == true ) {
		document.form.isnodchg.value='Y';
		document.form.dest_nod.disabled=false;
	} else {
		document.form.isnodchg.value='N';
		document.form.dest_nod.disabled=true;
		document.form.dest_nod.value="";
	}
}
/*
 * Include Completed Route -> OutBound/InBound -> frm_nod;
 */
function checktFrmnod() {
	var radioObj=document.form.frm_nod_check;
	if( radioObj.checked == true ) {
		document.form.isfrmchg.value='Y';
		document.form.frm_nod.disabled=false;
	} else {
		document.form.isfrmchg.value='N';
		document.form.frm_nod.disabled=true;
		document.form.frm_nod.value="";
	}
}

function selectBound(obj) {
	var radioObj = document.form.bound_choice;
	var radioValue = obj.value;
	switch (radioValue) {
		case "O":
			document.form.bound_name.value = 'O';
			$('#lblDest').html("Change O/B Inland Origin");
			break;
		case "I":
			document.form.bound_name.value = 'I';
			$('#lblDest').html("Change I/B Inland Dest");
			break;
	}
}
/**
 * sep에 해당하는 char를 제거하는 스크립트
 */
function doSepRemove(obj, sep) {
	var ch="";
	var lvobj="";
	for(var i=0; i<obj.length; i++) {
		if(obj.charAt(i) == sep) {
			ch="";
		} else {
			ch=obj.charAt(i);
		}
		lvobj=lvobj + ch;
	}
	return lvobj;
}


/**
 * COP CHANGE MAIN RESEARCH
 */
function findCopChange(rtnVal) {
	var opener=window.dialogArguments;

	if (!opener)  opener=window.opener;
	if (!opener) opener=parent; 
	
	opener.researchScreen();
	ComClosePopup();
}		