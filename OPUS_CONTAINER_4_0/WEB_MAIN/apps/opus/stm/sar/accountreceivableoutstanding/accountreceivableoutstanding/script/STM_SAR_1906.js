/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sar_1006.js // 수정
*@FileTitle  : Payment Request Letter by Customer by customer Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
//var rdObjects=new Array();
//var rdCnt=0;
// Event handler processing by button click event */
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// Event handler processing by button name */
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */   
function processButtonClick() {
	/***** setting sheet object *****/
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/    
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	var rdObject=viewer;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_close":
			ComClosePopup(); 
			break;
		case "btng_print":
			//rdObject.print();
			viewer.print({isServerSide:true});
			break;
			} // end switch
	} catch (e) {
		/*
        자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
        물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
        */
		if (e == "[object Error]") {
			ComShowCodeMessage('SAP00001');
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
/**
 * Sheet 기본 설정 및 초기화 
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	rdOpen();
}
function rdOpen(){
    var formObj=document.form;
    //rdObjects[0].ApplyLicense("0.0.0.0");
    queryStr="";
//    if( !setQueryStr() ){
//        return;
//    }
// /rp [66][N][DE000309][49-60213439150][somiyo@cyberlogitec.com][HAM01][7424]
  if (formObj.ots_smry_cd.value == "INV") {
	  var rdParam='/rp ['+formObj.eml_seq.value+']';
	  rdParam +=     '[N]';
	  rdParam +=     '['+formObj.cust_code.value+']';
	  rdParam +=     '['+formObj.fax.value+']';
	  rdParam +=     '['+formObj.email.value+']';
	  rdParam +=     '[]';
	  rdParam +=     '[]';
	  alert(rdParam);
   var strPath="apps/opus/stm/sar/accountreceivableoutstanding/accountreceivableoutstanding/report/STM_SAR_1007.mrd";
   // Rdviewer.FileOpen( strPath, RDServerBAT + rdParam);
//   formObj.com_mrdPath.value = strPath;
//   formObj.com_mrdArguments.value = rdParam;
//   ComOpenRDPopup();
   viewer.openFile(RD_path + "apps/opus/stm/sar/accountreceivableoutstanding/accountreceivableoutstanding/report/STM_SAR_1007.mrd", rdParam, {timeout:3000});
  } else {
	  var rdParam='/rp ['+formObj.eml_seq.value+']';
		  rdParam +=     '[N]';
		  rdParam +=     '['+formObj.cust_code.value+']';
		  rdParam +=     '['+formObj.fax.value+']';
		  rdParam +=     '['+formObj.email.value+']';
		  rdParam +=     '[]';
		  rdParam +=     '[]';
		  alert(rdParam);
	   if(formObj.ar_ofc_cd.value == "SAOBB"){
		   var strPath="apps/opus/stm/sar/accountreceivableoutstanding/accountreceivableoutstanding/report/STM_SAR_1008.mrd";
		   // Rdviewer.FileOpen( strPath, RDServerBAT + rdParam);
		//   formObj.com_mrdPath.value = strPath;
		//   formObj.com_mrdArguments.value = rdParam;
		//   ComOpenRDPopup();
		   viewer.openFile(RD_path + "apps/opus/stm/sar/accountreceivableoutstanding/accountreceivableoutstanding/report/STM_SAR_1008.mrd", rdParam, {timeout:3000});
	   } else {
		   var strPath="apps/opus/stm/sar/accountreceivableoutstanding/accountreceivableoutstanding/report/STM_SAR_1006.mrd";
		   // Rdviewer.FileOpen( strPath, RDServerBAT + rdParam);
		//   formObj.com_mrdPath.value = strPath;
		//   formObj.com_mrdArguments.value = rdParam;
		//   ComOpenRDPopup();
		   viewer.openFile(RD_path + "apps/opus/stm/sar/accountreceivableoutstanding/accountreceivableoutstanding/report/STM_SAR_1006.mrd", rdParam, {timeout:3000});
	   }
  }
}
