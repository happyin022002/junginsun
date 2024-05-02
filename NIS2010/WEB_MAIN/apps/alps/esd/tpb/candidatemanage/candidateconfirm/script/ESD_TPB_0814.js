/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TPB_0814.js
*@FileTitle : Note on Non-TPB
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.11
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.11.11 박찬민
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
     [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
     기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// 공통전역변수
document.onclick = processButtonClick;
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var opener = window.dialogArguments;
var is_placeholder;
var str_placeholder;

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
  * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
  * @author 한진해운
  */

 /**
  * @extends 
  * @class ESD_TPB_0814 : ESD_TPB_0814 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
  */
 function ESD_TPB_0814() {
 	this.processButtonClick		= tprocessButtonClick;
 	this.setSheetObject 		= setSheetObject;
 	this.loadPage 				= loadPage;
 	this.initSheet 				= initSheet;
 	this.initControl            = initControl;
 	this.doActionIBSheet 		= doActionIBSheet;
 	this.setTabObject 			= setTabObject;
 	this.validateForm 			= validateForm;
 }
 
 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
 function loadPage() 
 {
 	for(i=0;i<sheetObjects.length;i++){
 			//khlee-시작 환경 설정 함수 이름 변경
 			ComConfigSheet(sheetObjects[i]);
 			initSheet(sheetObjects[i],i+1);
 			//khlee-마지막 환경 설정 함수 추가
 			ComEndConfigSheet(sheetObjects[i]);
 		}
  axon_event.addListenerForm("KeyDown","obj_KeyDown", document.form);
  var formObj = document.form;
  doActionIBSheet(sheetObjects[0], formObj, SEARCH);
 }
 
/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick()
{
 var formObj = document.form;
    
 try {
  var srcName = window.event.srcElement.getAttribute("name");
  switch(srcName) 
  {
   case "btn_Close":
    window.close();
   break;
   case "btn_Save":
	   if(is_placeholder) {
		   ComShowCodeMessage('TPB90104');
		   return;
	   }
	   
	   if(ComTrim(document.form.n3pty_non_cfm_rsn.value).length> 0){
	   var nowRow = sheetObjects[0].SelectRow;
     	   nowRow = sheetObjects[0].DataInsert(-1);
	   sheetObjects[0].CellValue(nowRow, "ots_dtl_seq") = document.form.ots_dtl_seq.value;
	   sheetObjects[0].CellValue(nowRow, "n3pty_non_cfm_rsn_cd") = document.form.pN3pty_non_cfm_rsn_cd.value;
	   sheetObjects[0].CellValue(nowRow, "n3pty_non_cfm_rsn") = document.form.n3pty_non_cfm_rsn.value;
	   sheetObjects[0].RowStatus(nowRow) = "I";
	   

//	   sheetObjects[0].DoSave("ESD_TPB_0814GS.do", tpbFrmQryStr(formObj));
	   doActionIBSheet(sheetObjects[0],document.form, MULTI);
	   
	   opener.sheetObjects[0].CellValue2(opener.sheetObjects[0].SelectRow,"non_cfm_rsn_flg") = 'Y';
	   self.close();
	   
	   } else {
		   ComShowCodeMessage('TPB90104');
//		   ComShowCodeMessage("BKG00391");
	   }
    
   break;
  }
 } catch(e) {
  if( e == "[object Error]") ComShowMessage(OBJECT_ERROR);
  else         ComShowMessage(e);
 }
}

	/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj, formObj, sAction) {
//  sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case SEARCH:			
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESD_TPB_0814GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			
			var rsn_cd = document.form.pN3pty_non_cfm_rsn_cd.value;
			
			if(rsn_cd == "CD") {
				str_placeholder = 'Please wirte down the correct TPB no. or INV no. as a proof of collection.';
			} else if (rsn_cd == "DE") {
				str_placeholder = 'Please explain in details.';
			} else if (rsn_cd == "WD") {
				str_placeholder = 'Please wirte down the correct TPB no.';
			} else {
				str_placeholder = '';
			}
			
			if (ComGetEtcData(sXml, "n3pty_non_cfm_rsn") == undefined) {
				var rsn_cd = document.form.pN3pty_non_cfm_rsn_cd.value;
				formObj.n3pty_non_cfm_rsn.value = str_placeholder;
				if(rsn_cd == "CD" || rsn_cd == "DE" || rsn_cd == "WD") {
					is_placeholder = true;
				} else {
					is_placeholder = false;
				}
			} else {
				formObj.n3pty_non_cfm_rsn.value = ComGetEtcData(sXml, "n3pty_non_cfm_rsn");
				is_placeholder = false;
			}
			
			break;
		 
       case MULTI:
    	   formObj.f_cmd.value = MULTI;
    	var sParam 	= sheetObjects[0].GetSaveString(false, true, "ibflag");
        var sXml 	= sheetObjects[0].GetSaveXml("ESD_TPB_0814GS.do", "f_cmd=" + MULTI + "&" + sParam);
    	 
    	 break;
      }
 }


	/**
	 * IBSheet Object를 배열로 등록
	 * comSheetObject(id)에서 호출한다
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
 	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  				with (sheetObj) {
  					var cnt = 0;
  					style.height = 0;
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msHeaderOnly;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 9);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(6, 10, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)
  					
  					//var HeadTitle1 = "Del.|STS|SEQ|Confirm|Confirm|Confirm|Confirm|Confirm|ots_dtl_seq|TPB No.|Exp. Type|Exp. Type|S/P Inv No.|3rd Party|3rd Party|EQ Type|EQ No|TP/SZ|BKG No.|B/L No.|VVD|Interfaced Amount|Interfaced Amount|Interfaced Amount|Interfaced\nRemark|Confirmed\nAmount|I/F Date|Interfaced by|Interfaced by|Interfaced by|Description|Reviewed by|Reviewed by|Reason for Non-TPB|CSR No.|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|ofc_cd";
  					//var HeadTitle2 = "Del.|STS|SEQ|I|G|N|R|D|ots_dtl_seq|TPB No.|Main|Sub|S/P Inv No.|Type|Code|EQ Type|EQ No|TP/SZ|BKG No.|B/L No.|VVD|LCL Cur|LCL Amt|USD(Equiv.)|Interfaced\nRemark|Confirmed\nAmount|I/F Date|Office|ID|Name|Description|Office|ID|Reason for Non-TPB|CSR No.|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|ofc_cd";
  					var HeadTitle1 = "Del.|STS|SEQ|A|B|C";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle1, true);

//                [ROW ,COL	  ,DATATYPE     ,WIDTH ,DATAALIGN ,COLMERGE ,SAVENAME                 ,KEYFIELD ,CALCULOGIC ,DATAFORMAT ,POINTCOUNT ,UPDATEEDIT ,INSERTEDIT ,EDITLEN ,FULLINPUT ,SORTENABLE ,TOOLTIP ,ALLCHECK ,SAVESTATUS ,FORMATFIX]
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,30    ,daLeft    ,true     ,""                       ,false    ,""         ,dfNone     ,0          ,true       ,true       ,1       ,false     ,false      ,""      ,false );
				  InitDataProperty(0   ,cnt++   ,dtStatus     ,30    ,daCenter  ,true     ,"ibflag" );
				  InitDataProperty(0   ,cnt++   ,dtSeq        ,30    ,daCenter  ,true     ,"seq" );
				  InitDataProperty(0   ,cnt++   ,dtData       ,70    ,daCenter  ,true     ,"ots_dtl_seq"             ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,70    ,daCenter  ,true     ,"n3pty_non_cfm_rsn_cd"             ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,70    ,daCenter  ,true     ,"n3pty_non_cfm_rsn"             ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  				}
  				break;
  		}
  	}
  	

function obj_KeyDown() 
{
// var srcName = window.event.srcElement.getAttribute("name").substring(10);
// var srcMaxLength = window.event.srcElement.getAttribute("1000");
// var srcValue = window.event.srcElement.getAttribute("value");
 fncTextareaMaxLine(window.event.srcElement, 10);
}

	// Textarea 최대행 10
function fncTextareaMaxLine(obj, maxLine) 
{
    var str_len = obj.value;
    line = str_len.split("\r\n");
    ln = line.length;
    if(ln == maxLine && event.keyCode == 13) 
    {    
     event.returnValue = false;
    }
}

	/**
	 * placeholder 구현 함수
	 * param : e ==> event
	 * 키보드를 누르는 순간 발생하는 이벤트로 placeholder가 있으면 없애고 입력내용으로 변경된다.
	 */
	function f_set_placeholder(e) {
		var code = e.keyCode
		var which = e.which;
		
		var reason_val = String.fromCharCode(code);
	
		if(is_placeholder) {
			is_placeholder = false;
			form.n3pty_non_cfm_rsn.value='';
		}
	}
