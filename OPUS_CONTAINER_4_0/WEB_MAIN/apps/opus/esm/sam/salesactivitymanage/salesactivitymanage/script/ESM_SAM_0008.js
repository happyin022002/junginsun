/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0008.js
*@FileTitle  : Sales Activity Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */
/**
 * @extends 
 * @class ESM_SAM_0008 : ESM_SAM_0008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업	*/
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var Save_Param="";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1=sheetObjects[0]; // Tab1 : Sales Report, Tab2 : Report Text
    var sheetObject2=sheetObjects[1]; // Tab3 : Cust. SatisFaction
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			//달력열기
			case "btn_calendar":  
	    	    var cal=new ComCalendar();
	    	    cal.select(document.form.sls_act_act_dt, 'yyyy-MM-dd');
		    break;
			case "btn_Retrieve":  
				doActionIBSheet(sheetObjects[0], document.form, SEARCH01); // 조회
				break;
            case "btn_New":
            	initControl();
            	break;
            case "btn_Save":
            	doActionIBSheet(sheetObjects[0], document.form, MULTI01);    // 저장
            	break;
            case "btn_ComEns041Pop": // com customer pop-up
	            var custCntCdSeq=formObject.cust_cd.value;
				var custNm=formObject.cust_lgl_eng_nm.value;
	    		ComOpenPopup("/opuscntr/COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd="+custCntCdSeq+"&cust_lgl_eng_nm="+custNm, 770, 490, "callBackComEns041", '0,1,1,1,1,1,1', true);
	    		break;
            case "btn_act":  //activity_no
            	var input_cust=formObject.cust_cd.value;
            	ComOpenPopupWithTarget('/opuscntr/ESM_SAM_0901.do?pgmNo=ESM_SAM_0901&customer_cd="+input_cust', 980, 670, '', "1,0,1,1,1,1,1,1", true);
            	break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("COM12111");
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++]=tab_obj;
}
/**  
 * IBCombo Object를 배열로 등록
 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj){	     
	comboObjects[comboCnt++]=combo_obj;  
}
/**
* Tab 기본 설정
* 탭의 항목을 설정한다.
*/
function initTab(tabObj , tabNo) {
   switch(tabNo) {
       case 1:
           with (tabObj) {
               var cnt=0 ;
				InsertItem( "Sales Report" , "");
				InsertItem( "Report Text" , "");
				InsertItem( "Cust. Satisfaction" , "");
           }
       break;
   }
}
/**
* Tab 클릭시 이벤트 관련
* 선택한 탭의 요소가 활성화 된다.
*/
function tab1_OnChange(tabObj , nItem)
{
   var objs=document.all.item("tabLayer");
   objs[nItem].style.display="Inline";
   //--------------- 요기가 중요 --------------------------//
   for(var i = 0; i<objs.length; i++){
	   if(i != nItem){
	    objs[i].style.display="none";
	    objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	   }
	 }  
   //------------------------------------------------------//
   beforetab=nItem;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj=document.form;	
	 for(k=0; k < tabObjects.length; k++){
        initTab(tabObjects[k], k+1);
        tabObjects[k].SetSelectedIndex(0);
	 }
	for (i=0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	doActionIBCombo(sheetObjects[0], formObj, SEARCH);
	if (formObj.cust_cd.value != null && formObj.cust_cd.value != ''){
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
		if (formObj.srep_cd.value != null && formObj.srep_cd.value != ''){	
			doActionIBSheet(sheetObjects[0], document.form, SEARCH04);				
			doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		}
	}		
}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	 	var formObj=document.form;
		formObj.reset();
 	    t1sheet1.RemoveAll();
 	    t3sheet1.RemoveAll();
		t1sheet1.DataInsert(-1); // 정보를 입력 받을 숨겨진 Sheet에 row 추가
		t3sheet1.DataInsert(-1); // 정보를 입력 받을 숨겨진 Sheet에 row 추가
//	    axon_event.addListenerFormat("keypress","obj_Keypress", document.form);     // uppereng
		axon_event.addListenerForm('change', 'obj_change', document.form); // change
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	    ComClearSeparator (formObj.cust_cd,"eng"); //한글 변환 키 막기
	    ComClearSeparator (formObj.sls_act_seq,"eng"); //한글 변환 키 막기
	    ComBtnEnable("btn_Save");
	    
//	    2014.08.12 김용습 - 엔터키로 조회
	    axon_event.addListenerForm('change', 'obj_change', form);
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "t1sheet1":
		    with(sheetObj){
				var HeadTitle1="|Cust_cd|Cust_seq|Cust_nm|Act_no|Visit Date|Sales Rep_cd|Sales Rep_nm|Contact Person|Class|Summary|Problem(Class)|Problem|Suggestion(Class)|Suggestion|Next Plan(Class)|Next Plan|Visit Place|Give Away|Areas|Report";
				var headCount=ComCountHeadTitle(HeadTitle1);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cust_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sls_act_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sls_act_act_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"srep_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"srep_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sls_rpt_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sls_rpt_smry_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prb_clss_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prb_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"sgs_clss_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"sgs_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"nxt_pln_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"nxt_pln_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vst_plc_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sls_prmt_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"biz_area_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"free_rpt_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
				InitColumns(cols);

				SetEditable(1);
				SetVisible(true);
		}
		break;
		case "t3sheet1":
            with(sheetObj){
				var HeadTitle1="|cust_cnt_cd|cust_seq|srep_cd|sls_act_seq|ses|scr|eqs|cah|sep|rel|usf|boc|dob|ats|clh|qur|cun|src|ses_rsn|scr_rsn|eqs_rsn|cah_rsn|sep_rsn|rel_rsn|usf_rsn|boc_rsn|dob_rsn|ats_rsn|clh_rsn|qur_rsn|cun_rsn|wsi_rsn|cur_rsn|src_rsn";
				var headCount=ComCountHeadTitle(HeadTitle1);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"srep_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sls_act_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:1,   SaveName:"ses",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:15,  Align:"Center",  ColMerge:1,   SaveName:"scr",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  width:15,   Align:"Center",  ColMerge:1,   SaveName:"eqs",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  width:15,   Align:"Center",  ColMerge:1,   SaveName:"cah",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:15,  Align:"Center",  ColMerge:1,   SaveName:"sep",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:15,  Align:"Center",  ColMerge:1,   SaveName:"rel",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:15,  Align:"Center",  ColMerge:1,   SaveName:"usf",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:15,  Align:"Center",  ColMerge:1,   SaveName:"boc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  width:15,   Align:"Center",  ColMerge:1,   SaveName:"dob",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  width:15,   Align:"Center",  ColMerge:1,   SaveName:"ats",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:15,  Align:"Center",  ColMerge:1,   SaveName:"clh",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:15,  Align:"Center",  ColMerge:1,   SaveName:"qur",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:15,  Align:"Center",  ColMerge:1,   SaveName:"cun",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:15,  Align:"Center",  ColMerge:1,   SaveName:"src",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:1,   SaveName:"ses_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:1,   SaveName:"scr_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"eqs_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"cah_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:1,   SaveName:"sep_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rel_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"usf_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"boc_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"dob_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"ats_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"clh_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"qur_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cun_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  width:50,   Align:"Center",  ColMerge:1,   SaveName:"wsi_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cur_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"src_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
       
				InitColumns(cols);

				SetEditable(1);
				SetVisible(true);
            }
		break;
    }
}
 /**
  * 모든 콤보 박스 조회
  * 공통 부분 완성되면 추가 작업 요
  */
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
		switch (sAction) {
			case SEARCH: // load page 시
			    var param="f_cmd="+SEARCH+"&scr_no="+"0008";
 	     		var sXml=sheetObj.GetSearchData("ESM_SAM_COMGS.do",param);
	     		var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) ComXml2ComboItem(arrXml[0],sls_rpt_clss_cd, "cd", "cd|cd_desc");
			break;
		}
	}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case SEARCH01: // 조회
	        	if (!validateForm(sheetObj,document.form,sAction)) {
	        		return false;
	        	}
				sheetObjects[0].SetWaitImageVisible(0);
	            ComOpenWait(true);
	            formObj.f_cmd.value=SEARCH01;	
	            formObj.cust_cnt_cd.value=formObj.cust_cd.value.substring(0,2);	
				formObj.cust_seq.value=formObj.cust_cd.value.substring(2,formObj.cust_cd.value.length);
				var sParam=FormQueryString(formObj);		
 				var xml=sheetObj.GetSearchData("ESM_SAM_0008GS.do", sParam);
	            sheetObjects[0].LoadSearchData(xml,{Sync:1} );
	            sheetObjects[0].SetWaitImageVisible(1);
	            ComOpenWait(false);
				doActionIBSheet(sheetObjects[1], document.form, SEARCH02); // 조회
	            break;
		case SEARCH02: // 조회
				// 3번째 탭의 값이 있던 기존 화면에서 3번째 탭의 값이 없는 화면을 조회하는 경우에 폼 비워주기
				formObj.satsfc_cd_ses[0].checked=true;
				formObj.satsfc_cd_scr[0].checked=true;
				formObj.satsfc_cd_eqs[0].checked=true;
				formObj.satsfc_cd_cah[0].checked=true;
				formObj.satsfc_cd_sep[0].checked=true;
				formObj.satsfc_cd_rel[0].checked=true;
				formObj.satsfc_cd_usf[0].checked=true;
				formObj.satsfc_cd_boc[0].checked=true;
				formObj.satsfc_cd_dob[0].checked=true;
				formObj.satsfc_cd_ats[0].checked=true;
				formObj.satsfc_cd_clh[0].checked=true;
				formObj.satsfc_cd_qur[0].checked=true;
				formObj.satsfc_cd_cun[0].checked=true;
				ComClearObject(formObj.satsfc_cd_ses_rsn);
				ComClearObject(formObj.satsfc_cd_scr_rsn);
				ComClearObject(formObj.satsfc_cd_eqs_rsn);
				ComClearObject(formObj.satsfc_cd_cah_rsn);
				ComClearObject(formObj.satsfc_cd_sep_rsn);
				ComClearObject(formObj.satsfc_cd_rel_rsn);
				ComClearObject(formObj.satsfc_cd_usf_rsn);
				ComClearObject(formObj.satsfc_cd_boc_rsn);
				ComClearObject(formObj.satsfc_cd_dob_rsn);
				ComClearObject(formObj.satsfc_cd_ats_rsn);
				ComClearObject(formObj.satsfc_cd_clh_rsn);
				ComClearObject(formObj.satsfc_cd_qur_rsn);
				ComClearObject(formObj.satsfc_cd_cun_rsn);
				ComClearObject(formObj.satsfc_cd_wh_imp);	
				ComClearObject(formObj.satsfc_cd_recom);
				ComClearObject(formObj.satsfc_cd_rsn);
				formObj.satsfc_cd_rep_comp.value="Y";
				sheetObjects[1].SetWaitImageVisible(0);
	            ComOpenWait(true);
	            formObj.f_cmd.value=SEARCH02;	
	            formObj.cust_cnt_cd.value=formObj.cust_cd.value.substring(0,2);	
				formObj.cust_seq.value=formObj.cust_cd.value.substring(2,formObj.cust_cd.value.length);
	            var sParam=FormQueryString(formObj);
 	            var xml=sheetObj.GetSearchData("ESM_SAM_0008GS.do", sParam);
	            sheetObjects[1].LoadSearchData(xml,{Sync:1} );
	            sheetObjects[1].SetWaitImageVisible(1);
	            ComOpenWait(false);
	            break;
		case SEARCH03:	  // Customer Code 입력시 cust_lgl_eng_nm 조회
			formObj.f_cmd.value=SEARCH03;
			var sParam=FormQueryString(formObj);
 	        var xml=sheetObj.GetSearchData("ESM_SAM_0008GS.do", sParam);
		    var retVal=(ComGetEtcData(xml, "result") == undefined) ? "" : ComGetEtcData(xml, "result");
		    var retVal_cd=(ComGetEtcData(xml, "result_cd") == undefined) ? "" : ComGetEtcData(xml, "result_cd");
			sheetObj.RemoveAll();
			if(retVal == "") {
				ComShowCodeMessage("COM130402", "Customer Code");
			    document.form.cust_lgl_eng_nm.value="";
				document.form.cust_cd.value="";
			}else{
				document.form.cust_lgl_eng_nm.value=retVal;
				document.form.cust_cd.value=retVal_cd;
	    	}	
			break;
		case SEARCH04: // Sales Rep 이름 조회
			formObj.f_cmd.value=SEARCH04;
 			var sXml=sheetObj.GetSearchData("ESM_SAM_0008GS.do", FormQueryString(formObj));
			var srep_nm=(ComGetEtcData(sXml, "srep_nm") == undefined) ? "" : ComGetEtcData(sXml, "srep_nm");
			sheetObj.SetWaitImageVisible(0);
			document.form.srep_nm.value=srep_nm;
			if(srep_nm == "") {
				ComShowCodeMessage("COM130402", "S.Rep Code");
				formObj.srep_cd.value="";
				formObj.srep_nm.value="";
			}else{
				document.form.srep_nm.value=srep_nm;
			}			
			break;
		case MULTI01:         // Save	
			if (!validateForm(sheetObj,formObj,sAction)) {	
				return false;
			}

			ComOpenWait(true); //->waiting->start
			sheetObj.RemoveEtcData();
			// data 가 없을 경우에는 row 를 추가해서 insert 를 태운다.
			if (sheetObjects[0].IsDataModified() != 0 && sheetObj.RowCount()== 0){
				sheetObjects[0].DataInsert(-1);
			}
			formObj.f_cmd.value=MULTI01;
			formObj.cust_cnt_cd.value=formObj.cust_cd.value.substring(0,2);
			formObj.cust_seq.value=formObj.cust_cd.value.substring(2,formObj.cust_cd.value.length);
			var temp=ComGetUnMaskedValue(formObj.sls_act_act_dt.value, "ymd");
			formObj.sls_act_act_dt.value=temp;
			// Sales Report 탭의 입력된 정보를  sheet 로 옮겨서 저장 시 파라미터로 전송
			sheetObj.SetCellValue(1, "cust_cnt_cd",formObj.cust_cd.value.substring(0,2));
			sheetObj.SetCellValue(1, "cust_seq",parseInt(formObj.cust_cd.value.substring(2, formObj.cust_cd.value.length)));
			sheetObj.SetCellValue(1, "srep_cd",formObj.srep_cd.value);
			sheetObj.SetCellValue(1, "sls_act_seq",formObj.sls_act_seq.value);
			sheetObj.SetCellValue(1, "sls_act_act_dt",ComGetUnMaskedValue(formObj.sls_act_act_dt.value, "ymd"));
			sheetObj.SetCellValue(1, "cntc_pson_nm",formObj.cntc_pson_nm.value);
			sheetObj.SetCellValue(1, "sls_rpt_clss_cd",sls_rpt_clss_cd.GetSelectCode());
			sheetObj.SetCellValue(1, "sls_rpt_smry_desc",formObj.sls_rpt_smry_desc.value);
			sheetObj.SetCellValue(1, "prb_clss_cd",formObj.prb_clss_cd.value);
			sheetObj.SetCellValue(1, "prb_desc",formObj.prb_desc.value);
			sheetObj.SetCellValue(1, "sgs_clss_cd",formObj.sgs_clss_cd.value);
			sheetObj.SetCellValue(1, "sgs_desc",formObj.sgs_desc.value);
			sheetObj.SetCellValue(1, "nxt_pln_clss_cd",formObj.nxt_pln_clss_cd.value);
			sheetObj.SetCellValue(1, "nxt_pln_desc",formObj.nxt_pln_desc.value);
			sheetObj.SetCellValue(1, "vst_plc_ctnt",formObj.vst_plc_ctnt.value);
			sheetObj.SetCellValue(1, "sls_prmt_desc",formObj.sls_prmt_desc.value);
			// Report Text 탭의 입력된 정보를  sheet 로 옮겨서 저장 시 파라미터로 전송
			sheetObj.SetCellValue(1, "free_rpt_ctnt",formObj.free_rpt_ctnt.value);
			// Area 선택을 위한 라디오 버튼 값 입력
			for ( var i=0; i < formObj.biz_area_cd.length; i++) {
				if (formObj.biz_area_cd[i].checked == true) {
					sheetObj.SetCellValue(1,"biz_area_cd",formObj.biz_area_cd[i].value);
					break;
				}
			}		
			
			Save_Param=sheetObj.GetSaveString(false, true, "ibflag");	
			
 			var sXml=sheetObj.GetSaveData("ESM_SAM_0008GS.do", "f_cmd=" + MULTI01 + "&" + Save_Param);
			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			ComOpenWait(false);	
			
			doActionIBSheet(sheetObjects[1], document.form, MULTI02);
			break;
		case MULTI02:         // Save		
				// data 가 없을 경우에는 row 를 추가해서 insert 를 태운다.
				if (sheetObjects[1].IsDataModified() != 0 && sheetObj.RowCount()== 0){
					sheetObj.DataInsert(-1);
				}
				sheetObj.RemoveEtcData();
				
				sheetObj.SetCellValue(1,"ses_rsn",formObj.satsfc_cd_ses_rsn.value);
				sheetObj.SetCellValue(1,"scr_rsn",formObj.satsfc_cd_scr_rsn.value);
				sheetObj.SetCellValue(1,"eqs_rsn",formObj.satsfc_cd_eqs_rsn.value);
				sheetObj.SetCellValue(1,"cah_rsn",formObj.satsfc_cd_cah_rsn.value);
				sheetObj.SetCellValue(1,"sep_rsn",formObj.satsfc_cd_sep_rsn.value);
				sheetObj.SetCellValue(1,"rel_rsn",formObj.satsfc_cd_rel_rsn.value);
				sheetObj.SetCellValue(1,"usf_rsn",formObj.satsfc_cd_usf_rsn.value);
				sheetObj.SetCellValue(1,"boc_rsn",formObj.satsfc_cd_boc_rsn.value);
				sheetObj.SetCellValue(1,"dob_rsn",formObj.satsfc_cd_dob_rsn.value);
				sheetObj.SetCellValue(1,"ats_rsn",formObj.satsfc_cd_ats_rsn.value);
				sheetObj.SetCellValue(1,"clh_rsn",formObj.satsfc_cd_clh_rsn.value);
				sheetObj.SetCellValue(1,"qur_rsn",formObj.satsfc_cd_qur_rsn.value);
				sheetObj.SetCellValue(1,"cun_rsn",formObj.satsfc_cd_cun_rsn.value);
				sheetObj.SetCellValue(1,"wsi_rsn",formObj.satsfc_cd_wh_imp.value);
				sheetObj.SetCellValue(1,"cur_rsn",formObj.satsfc_cd_recom.value);
				sheetObj.SetCellValue(1,"src_rsn",formObj.satsfc_cd_rsn.value);
				sheetObj.SetCellValue(1,"src",formObj.satsfc_cd_rep_comp.value);
				// Service Scope 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_ses.length; i++) {
					if (formObj.satsfc_cd_ses[i].checked == true) {
						sheetObj.SetCellValue(1,"ses",formObj.satsfc_cd_ses[i].value);
						break;
					}
				}
				// Schedule Reliability 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_scr.length; i++) {
					if (formObj.satsfc_cd_scr[i].checked == true) {
						sheetObj.SetCellValue(1,"scr",formObj.satsfc_cd_scr[i].value);
						break;
					}
				}
				// Equipment Supply 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_eqs.length; i++) {
					if (formObj.satsfc_cd_eqs[i].checked == true) {
						sheetObj.SetCellValue(1,"eqs",formObj.satsfc_cd_eqs[i].value);
						break;
					}
				}
				// Carrier Haulage 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_cah.length; i++) {
					if (formObj.satsfc_cd_cah[i].checked == true) {
						sheetObj.SetCellValue(1,"cah",formObj.satsfc_cd_cah[i].value);
						break;
					}
				}
				// Services Provided 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_sep.length; i++) {
					if (formObj.satsfc_cd_sep[i].checked == true) {
						sheetObj.SetCellValue(1,"sep",formObj.satsfc_cd_sep[i].value);
						break;
					}
				}
				// Reliability 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_rel.length; i++) {
					if (formObj.satsfc_cd_rel[i].checked == true) {
						sheetObj.SetCellValue(1,"rel",formObj.satsfc_cd_rel[i].value);
						break;
					}
				}
				// User Friendliness 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_usf.length; i++) {
					if (formObj.satsfc_cd_usf[i].checked == true) {
						sheetObj.SetCellValue(1,"usf",formObj.satsfc_cd_usf[i].value);
						break;
					}
				}
				// Booking Confirmation 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_boc.length; i++) {
					if (formObj.satsfc_cd_boc[i].checked == true) {
						sheetObj.SetCellValue(1,"boc",formObj.satsfc_cd_boc[i].value);
						break;
					}
				}
				// Documentation and Billing 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_dob.length; i++) {
					if (formObj.satsfc_cd_dob[i].checked == true) {
						sheetObj.SetCellValue(1,"dob",formObj.satsfc_cd_dob[i].value);
						break;
					}
				}
				// Attitude of Staff 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_ats.length; i++) {
					if (formObj.satsfc_cd_ats[i].checked == true) {
						sheetObj.SetCellValue(1,"ats",formObj.satsfc_cd_ats[i].value);
						break;
					}
				}
				// Claims handling 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_clh.length; i++) {
					if (formObj.satsfc_cd_clh[i].checked == true) {
						sheetObj.SetCellValue(1,"clh",formObj.satsfc_cd_clh[i].value);
						break;
					}
				}
				// Quotations and Rate Request 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_qur.length; i++) {
					if (formObj.satsfc_cd_qur[i].checked == true) {
						sheetObj.SetCellValue(1,"qur",formObj.satsfc_cd_qur[i].value);
						break;
					}
				}
				// Consultancy 선택을 위한 라디오 버튼 값 체크
				for ( var i=0; i < formObj.satsfc_cd_cun.length; i++) {
					if (formObj.satsfc_cd_cun[i].checked == true) {
						sheetObj.SetCellValue(1,"cun",formObj.satsfc_cd_cun[i].value);
						break;
					}
				}	
				
				Save_Param = sheetObj.GetSaveString(true);
								
 				var sXml=sheetObj.GetSaveData("ESM_SAM_0008GS.do", "f_cmd=" + MULTI02 + "&" + Save_Param);
				var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				ComOpenWait(false);	
				
				if (sheetObjects[0].IsDataModified() == 0 && sheetObjects[1].IsDataModified() == 0)
					{
						ComShowCodeMessage("COM12114", "the data. There is no data to save.");
						break;
					}						
						
				if(sav != "F"){
				ComShowCodeMessage("COM130102", "Data");
	            doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
	            doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
				}				
	            break;
	}
 }
/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case SEARCH01: //조회
				if (formObj.cust_cd.value == "" || formObj.cust_cd.value == null ){
					ComShowCodeMessage("COM130403", "Customer Code");
					ComSetFocus(document.form.cust_cd);
					return false;
				} 
				if ( formObj.sls_act_seq.value == "" || formObj.sls_act_seq.value == null){
					ComShowCodeMessage("COM130403", "Activity No");
					ComSetFocus(document.form.sls_act_seq);
					return false;
				}
				break;
			case MULTI01: // 저장			
				if ( formObj.sls_act_act_dt.value == "" ){
					ComShowCodeMessage("COM130403", "Customer Code");
    				ComSetFocus(document.form.sls_act_act_dt);
					return false;
				}
				
				var visit_date = new Date(formObj.sls_act_act_dt.value);
				var today = new Date(formObj.now_date.value);
				
				if (visit_date > today){
    				ComShowCodeMessage("COM12133", "Visit Date", "current date", "earlier"); 
    				ComSetFocus(document.form.sls_act_act_dt);
					return false;
				}				
				break;
		}
	return true;
}
function t1sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	var formObj=document.form;
	if (sheetObj.RowCount()> 0) {
			// sheet 에 입력된 값을  Sales Report 탭의 폼에 할당
		formObj.cust_cd.value=sheetObj.GetCellValue(1,"cust_cnt_cd")+ComLpad(sheetObj.GetCellValue(1,"cust_seq"),6,"0");
		formObj.cust_lgl_eng_nm.value=sheetObj.GetCellValue(1,"cust_lgl_eng_nm");
		formObj.sls_act_seq.value=sheetObj.GetCellValue(1,"sls_act_seq");
		formObj.sls_act_act_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"sls_act_act_dt"), "ymd") ;
		formObj.srep_cd.value=sheetObj.GetCellValue(1,"srep_cd");
		formObj.srep_nm.value=sheetObj.GetCellValue(1,"srep_nm");
		formObj.cntc_pson_nm.value=sheetObj.GetCellValue(1,"cntc_pson_nm");
	  //formObj.sls_rpt_clss_cd.text=sheetObj.GetCellValue(1,"sls_rpt_clss_cd");
		ComSetObjValue(sls_rpt_clss_cd, sheetObj.GetCellValue(1,"sls_rpt_clss_cd"));
		formObj.sls_rpt_smry_desc.value=sheetObj.GetCellValue(1,"sls_rpt_smry_desc");
		formObj.prb_clss_cd.value=sheetObj.GetCellValue(1,"prb_clss_cd");
		formObj.prb_desc.value=sheetObj.GetCellValue(1,"prb_desc");
		formObj.sgs_clss_cd.value=sheetObj.GetCellValue(1,"sgs_clss_cd");
		formObj.sgs_desc.value=sheetObj.GetCellValue(1,"sgs_desc");
		formObj.nxt_pln_clss_cd.value=sheetObj.GetCellValue(1,"nxt_pln_clss_cd");
		formObj.nxt_pln_desc.value=sheetObj.GetCellValue(1,"nxt_pln_desc");
		formObj.vst_plc_ctnt.value=sheetObj.GetCellValue(1,"vst_plc_ctnt");
		formObj.sls_prmt_desc.value=sheetObj.GetCellValue(1,"sls_prmt_desc");
			// sheet 에 입력된 값을  Report Text 탭의 폼에 할당
		formObj.free_rpt_ctnt.value=sheetObj.GetCellValue(1,"free_rpt_ctnt");
			// Area 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.biz_area_cd.length; i++) {
				if (formObj.biz_area_cd[i].value == sheetObj.GetCellValue(1,"biz_area_cd")) {
					formObj.biz_area_cd[i].checked=true;
					break;
				}
			}
	} else {
		var temp_cust=formObj.cust_cd.value;
		var temp_name=formObj.cust_lgl_eng_nm.value;
		var temp_act=formObj.sls_act_seq.value;
		var temp_srep=formObj.srep_cd.value;
		var temp_srep_nm=formObj.srep_nm.value;
		ComResetAll(); // 데이터 조회 후 없는 값이면 폼에 남아 있는 기존 값들을 지워줌
		formObj.cust_cd.value=temp_cust;
		formObj.cust_lgl_eng_nm.value=temp_name;
		formObj.sls_act_seq.value=temp_act;
		formObj.srep_cd.value=temp_srep;
		formObj.srep_nm.value=temp_srep_nm;		
	}
}
function t3sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	if (sheetObj.RowCount()> 0) {
		var formObj=document.form;
		if (0<sheetObj.RowCount()) {
			// Service Scope 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_ses.length; i++) {
				if (formObj.satsfc_cd_ses[i].value == sheetObj.GetCellValue(1,"ses")) {
					formObj.satsfc_cd_ses[i].checked=true;
					break;
				}
			}
			// Schedule Reliability 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_scr.length; i++) {
				if (formObj.satsfc_cd_scr[i].value == sheetObj.GetCellValue(1,"scr")) {
					formObj.satsfc_cd_scr[i].checked=true;
					break;
				}
			}
			// Equipment Supply 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_eqs.length; i++) {
				if (formObj.satsfc_cd_eqs[i].value == sheetObj.GetCellValue(1,"eqs")) {
					formObj.satsfc_cd_eqs[i].checked=true;
					break;
				}
			}
			// Carrier Haulage 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_cah.length; i++) {
				if (formObj.satsfc_cd_cah[i].value == sheetObj.GetCellValue(1,"cah")) {
					formObj.satsfc_cd_cah[i].checked=true;
					break;
				}
			}
			// Services Provided 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_sep.length; i++) {
				if (formObj.satsfc_cd_sep[i].value == sheetObj.GetCellValue(1,"sep")) {
					formObj.satsfc_cd_sep[i].checked=true;
					break;
				}
			}
			// Reliability 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_rel.length; i++) {
				if (formObj.satsfc_cd_rel[i].value == sheetObj.GetCellValue(1,"rel")) {
					formObj.satsfc_cd_rel[i].checked=true;
					break;
				}
			}
			// User Friendliness 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_usf.length; i++) {
				if (formObj.satsfc_cd_usf[i].value == sheetObj.GetCellValue(1,"usf")) {
					formObj.satsfc_cd_usf[i].checked=true;
					break;
				}
			}
			// Booking Confirmation 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_boc.length; i++) {
				if (formObj.satsfc_cd_boc[i].value == sheetObj.GetCellValue(1,"boc")) {
					formObj.satsfc_cd_boc[i].checked=true;
					break;
				}
			}
			// Documentation and Billing 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_dob.length; i++) {
				if (formObj.satsfc_cd_dob[i].value == sheetObj.GetCellValue(1,"dob")) {
					formObj.satsfc_cd_dob[i].checked=true;
					break;
				}
			}
			// Attitude of Staff 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_ats.length; i++) {
				if (formObj.satsfc_cd_ats[i].value == sheetObj.GetCellValue(1,"ats")) {
					formObj.satsfc_cd_ats[i].checked=true;
					break;
				}
			}
			// Claims handling 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_clh.length; i++) {
				if (formObj.satsfc_cd_clh[i].value == sheetObj.GetCellValue(1,"clh")) {
					formObj.satsfc_cd_clh[i].checked=true;
					break;
				}
			}
			// Quotations and Rate Request 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_qur.length; i++) {
				if (formObj.satsfc_cd_qur[i].value == sheetObj.GetCellValue(1,"qur")) {
					formObj.satsfc_cd_qur[i].checked=true;
					break;
				}
			}
			// Consultancy 선택을 위한 라디오 버튼 값 체크
			for ( var i=0; i < formObj.satsfc_cd_cun.length; i++) {
				if (formObj.satsfc_cd_cun[i].value == sheetObj.GetCellValue(1,"cun")) {
					formObj.satsfc_cd_cun[i].checked=true;
					break;
				}
			}
			// sheet 에 입력된 값을  Customer SatisFaction 탭의 폼에 할당
			formObj.satsfc_cd_ses_rsn.value=sheetObj.GetCellValue(1,"ses_rsn");
			formObj.satsfc_cd_scr_rsn.value=sheetObj.GetCellValue(1,"scr_rsn");
			formObj.satsfc_cd_eqs_rsn.value=sheetObj.GetCellValue(1,"eqs_rsn");
			formObj.satsfc_cd_cah_rsn.value=sheetObj.GetCellValue(1,"cah_rsn");
			formObj.satsfc_cd_sep_rsn.value=sheetObj.GetCellValue(1,"sep_rsn");
			formObj.satsfc_cd_rel_rsn.value=sheetObj.GetCellValue(1,"rel_rsn");
			formObj.satsfc_cd_usf_rsn.value=sheetObj.GetCellValue(1,"usf_rsn");
			formObj.satsfc_cd_boc_rsn.value=sheetObj.GetCellValue(1,"boc_rsn");
			formObj.satsfc_cd_dob_rsn.value=sheetObj.GetCellValue(1,"dob_rsn");
			formObj.satsfc_cd_ats_rsn.value=sheetObj.GetCellValue(1,"ats_rsn");
			formObj.satsfc_cd_clh_rsn.value=sheetObj.GetCellValue(1,"clh_rsn");
			formObj.satsfc_cd_qur_rsn.value=sheetObj.GetCellValue(1,"qur_rsn");
			formObj.satsfc_cd_cun_rsn.value=sheetObj.GetCellValue(1,"cun_rsn");
			formObj.satsfc_cd_wh_imp.value=sheetObj.GetCellValue(1,"wsi_rsn");
			formObj.satsfc_cd_recom.value=sheetObj.GetCellValue(1,"cur_rsn");
			formObj.satsfc_cd_rsn.value=sheetObj.GetCellValue(1,"src_rsn");
			formObj.satsfc_cd_rep_comp.value=sheetObj.GetCellValue(1,"src");
		} 
	}
}
/**
* Customer Inquiry(공통Popup) 호출후 Return받는 함수. <br>
* callBackComEns041(arrBal);
* @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
*/    	
function callBackComEns041(rArray){
		var formObj=document.form;
		if(rArray != null){
			ComSetObjValue(formObj.cust_cd, ComLpad(rArray[0][3],6,"0"));
			ComSetObjValue(formObj.cust_lgl_eng_nm, rArray[0][4]);    		    			   			
		}
}
/**
 * activity_no 값을 불러오기 위한 함수 
 * @param rowArray
 * @return 
 */
//function activity_no(rowArray) {
//alert("액티비티 받았다 !")
//	var colArray = rowArray[0];
//	document.form.sls_act_seq.value = colArray[1];
//	if(document.form.sls_act_seq.value != ""){
//		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
//		doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
//	}
//}
/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어
 */
function obj_Keypress(){
	 var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
     var srcName=ComGetEvent("name");
     var srcValue=event.srcElement.getAttribute("value");
     switch(event.srcElement.dataformat) {
     	case "engupnum":// 숫자+"영문대분자"입력하기
         	  ComKeyOnlyAlphabet('uppernum'); 
         	  break;
     	case "ymd":
     		//YYYY-MM-DD
         	  ComKeyOnlyNumber(event.srcElement);
           	  if (srcValue.length == 6) {
           		document.form.elements[srcName].value=srcValue.substring(0,4) + "-" + srcValue.substring(4,6) + "-"
           	  }
           	  break; 	  
        default:     // 영문 + 숫자
             ComKeyOnlyAlphabet('uppernum'); 
        	 break;
     }
}
/**
 * 폼 필드 변경시 이벤트
 */
function obj_change() {
 	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (srcName == "cust_cd")  {
		if(formObject.cust_cd.value.length>0){
  			if(!ComIsNumber(formObject.cust_cd.value.substring(2,formObject.cust_cd.value.length))){
  				formObject.cust_cd.value="";
	        	ComShowCodeMessage("COM130402", "Customer Code"); 	
	        	ComSetFocus(document.form.cust_cd);	
	        	return false;
  			}
  			doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
  			sheetObjects[0].DataInsert(-1);
  			sheetObjects[1].DataInsert(-1);
         }
	}
	if (srcName == "srep_cd")  {
		if(formObject.srep_cd.value.length>0){
			doActionIBSheet(sheetObjects[0],document.form,SEARCH04);		
		}
	}
	if (srcName == "sls_act_seq")  {	
	 	 if(formObject.in_usr_srep_cd.value != formObject.sls_act_seq.value.substring(0,5)){
	 		 ComBtnDisable("btn_Save");
	 	 }else{
	 		 ComBtnEnable("btn_Save");
	 	 }
	}
}
 /**
  * Activity 생성 Sales Rep과 로그인 Sales Rep을 비교하여 Save 버튼 컨트롤
  * @return 없음
  * @author 서미진
  * @version 2012.03.07
  */
  function checkUserCodeName() {  
 	 var formObj=document.form;
 	 if(formObj.pSrep_cd.value != formObj.sls_act_seq.value.substring(0,5)){
 		 ComBtnDisable("btn_Save");
 	 }else{
 		 ComBtnEnable("btn_Save");
 	 }
// 	 var sheetObj = sheetObjects[0];
// 	 
// 	 if(formObj.usr_id.value.length>0){
// 		 var userAuth = checkUserAuth(formObj, sheetObj);
// 		 if(userAuth != ''){	
// 			 ComBtnEnable("btn_Save");
// 			 formObj.srep_cd.readOnly =  false;
// 			 formObj.srep_cd.setAttribute("className","input1");
//
// 		 } else{
// 			 formObj.srep_cd.readOnly =  true;
// 			 formObj.srep_cd.setAttribute("className","input2"); 	
// 			 if(formObj.in_usr_srep_cd.value != ""){
//	 			 formObj.srep_cd.value 	 =  formObj.in_usr_srep_cd.value;
//	 			 formObj.srep_nm.value 	 =  formObj.user_name.value;
// 			 }
// 		 }
// 	 }
  }
/* 개발자 작업  끝 */
  
//2014.12.26 김용습 - Customer satisfaction 탭에서 Unchecked 라디오 버튼을 탓을 때 타는 펑션. Unchecked를 선택하면 세이브가 되지 않으므로, Unchecked는 선택 불가능하게 설정함
  function OnChangeRadioButton() {
	  ComShowCodeMessage("COM12114", "one on a scale of 1 to 5.\nYou have tried to select a radio button which is not allowed to selected.");
	  
  	  doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
      doActionIBSheet(sheetObjects[1], document.form, SEARCH02);	  
  }

