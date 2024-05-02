/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0358.js
*@FileTitle  : MRN Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
/**
 * JSDOC 생성을 위한 함수정의
 */

//공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
		case "btn_DownExcel":
			var exceptLines="";
			var chkCnt=0;
			// 체크 안된 데이터들 묶음
			for(var i=1; i <= sheetObjects[0].RowCount(); i++) {
				if (sheetObjects[0].GetCellValue(i, "Sel")==0)
					exceptLines=exceptLines + "|" + i;
				else
					chkCnt++;
			}			
			if (chkCnt > 0) {				
				sheetObjects[0].RenderSheet(0);
 				sheetObjects[0].Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
				sheetObjects[0].RenderSheet(1);
			}else {
				ComShowCodeMessage('BKG00394');
			}
			break;
		case "btn_select":
			doActionIBSheet(sheetObjects[0],formObject,COMMAND01);
			break;
		case "btn_calendar1":
			var cal=new ComCalendar();
			cal.select(formObject.from_dt, 'yyyy-MM-dd');
			break;
		case "btn_calendar2":
			var cal=new ComCalendar();
			cal.select(formObject.to_dt, 'yyyy-MM-dd');
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj=document.form;
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	sheet1_OnLoadFinish(sheetObjects[0]);
}
/**
 * Sheet1 로드 완료 후 처리
 * @param sheetObj
 * @return
 */
 function sheet1_OnLoadFinish(sheetObj) {
	var form=document.form;
//	axon_event.addListenerFormat('keypress', 'obj_KeyPress', form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	// MRN 년도 2자리 셋팅
	form.mrn1.value=ComGetNowInfo("yy").substring(2,4);
	// MRN 이나 VVD 등이 존재하면 필드 셋팅후 자동 조회 처리
	if (form.mrn_no.value.length + form.vvd.value.length + form.port_cd.value.length > 0) {
		// MRN 셋팅
		if (form.mrn_no.value.length > 1) {
			form.mrn1.value=form.mrn_no.value.substring(0,2);
		}
		if (form.mrn_no.value.length > 5) {
			form.mrn2.value=form.mrn_no.value.substring(2,6);
		}
		if (form.mrn_no.value.length > 9) {
			form.mrn3.value=form.mrn_no.value.substring(6,10);
		}
		// 자동 조회
		if (form.vvd.value.length > 8) doActionIBSheet(sheetObjects[0], form,IBSEARCH);
	}
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      //sheet1 init
	with (sheetObj) {
       
        var HeadTitle="Sel.|MRN|MRN|Port|Bound|VVD|Call Sign|ETA|ETD";

        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        InitHeaders(headers, info);

        var cols = [ {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Sel" },
               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"mrn_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mrn_chk_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"call_sgn_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Date",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"vps_etd_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
         
        InitColumns(cols);
        SetEditable(1);
        ComResizeSheet(sheetObj);
        //SetCountPosition(0);
        
	}
	break;
	}
}
/**
 * 클릭시 선택 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col) {
	//sheetObj.CellValue(Row, "Sel") = -1;
}
/**
 * 더블 클릭 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	select(sheetObj, Row, Col);
}
//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
 			var sXml=sheetObj.GetSearchData("ESM_BKG_0358GS.do", FormQueryString(formObj));
			sheetObjects[0].RenderSheet(0);
  			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
  			sheetObjects[0].RenderSheet(1);
  			ComOpenWait(false);
		}
		break;
	case COMMAND01:    //SELECT
		select(sheetObj, sheetObj.GetSelectRow(), '');
		break;
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		// VVD 분해
		vsl_cd.value='';
		skd_voy_no.value='';
		skd_dir_cd.value='';
		if (vvd.value.length > 0 && vvd.value.length < 4) vvd.value='';
		if (vvd.value.length > 3) vsl_cd.value=vvd.value.substring(0,4);
		if (vvd.value.length > 7) skd_voy_no.value=vvd.value.substring(4,8);  
		if (vvd.value.length > 8) skd_dir_cd.value=vvd.value.substring(8,9);  
		if (mrn1.value.length < 2) {
			ComShowCodeMessage('BKG00689');
			mrn1.focus();
			return false;
		}
		// MRN 조립
		mrn_no.value=mrn1.value + mrn2.value + mrn3.value + mrn4.value;
	}
	return true;
}
/**
 * Bound 변경시 ETA, ETD 문자열 처리
 * @return
 */ 
function ioBndCd_onChange()
{
	var formObj=document.form;
	var timeStr=document.all.timeStr;
	with(formObj) {
		if (io_bnd_cd.value=='O') {
			timeStr.innerHTML='ETD';
		}else {
			timeStr.innerHTML='ETA';
		}
	}
}
/**
 * select 버튼 클릭시
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function select(sheetObj,Row,Col) {
	if(window.name!=''){
		if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'mrn_no').length < 1) {
		// 조회선택된것이 없는 경우 패스
	}else {
		try{    	
			var obj=new Object(); 
			obj.mrn_no=sheetObj.GetCellValue(Row, "mrn_no");
			obj.vvd=sheetObj.GetCellValue(Row, "vvd_cd");
			obj.port_cd=sheetObj.GetCellValue(Row, "port_cd");
			obj.mrn_chk_no=sheetObj.GetCellValue(Row, "mrn_chk_no");
			ComPopUpReturnValue(obj)
//			window.returnValue=obj;
//			ComPopUpReturnValue(obj);
			ComClosePopup(); 
		}catch(e){}
	}
	}
} 
