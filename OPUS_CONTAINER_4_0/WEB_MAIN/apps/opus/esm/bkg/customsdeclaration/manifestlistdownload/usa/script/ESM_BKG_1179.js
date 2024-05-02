/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1179.jsp
*@FileTitle : Manual BDR
*Open Issues :
*Change history :
*@LastModifyDate : * 2014.06.02
*@LastModifier : 신규정
*@LastVersion : 1.0
* 2014.06.02 신규정
* 1.0 Creation 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 개발자 작업 */
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var searchCount=0;    // 최초조회인지 알기위하여 사용됨
var saveCount=0;    // 저장여부를 알기위하여 사용됨
var orgHndlOfcCd="";
var isRetrieved=false;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var shtObj=sheetObjects[0];
	var formObj=document.form;
	var hndlOfcCd=formObj.frm_hndl_ofc_cd.value.toUpperCase();
	orgHndlOfcCd=hndlOfcCd;
	var srcName=ComGetEvent("name");
	switch (srcName) {
		case "btn_retrieve":
			if(hndlOfcCd == null || hndlOfcCd.length == 0){
				ComShowCodeMessage('BKG00880','Mandatory retrieval condition is missing (Handling Office)');
				formObj.frm_hndl_ofc_cd.focus();
			} else if(hndlOfcCd.length < 5){
				ComShowCodeMessage('BKG00881','Please Enter a Min 5/Max 6-digit code in the Handling Office field)');
				formObj.frm_hndl_ofc_cd.focus();
			} else {
    			doActionIBSheet(shtObj,document.form,IBSEARCH);
    		}
		break;
		case "btn_save":
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}
        	if (isChangedSearchKeyword() == false) {
        		ComShowCodeMessage("BKG03053");
	    	    break;
        	}
			doActionIBSheet(shtObj, document.form, IBSAVE);
		break;
	} // end switch
}
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(shtObj) {
	sheetObjects[sheetCnt++]=shtObj;
}
/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tabObj){
	tabObjects[tabCnt++]=tabObj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    for(var i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }       
	for (var k=0; k<tabObjects.length; k++){
		initTab(tabObjects[k], k+1);
		tabObjects[k].SetSelectedIndex(0);
	}
	document.form.frm_hndl_ofc_cd.focus();
	axon_event.addListener("keydown","ComKeyEnter", "frm_hndl_ofc_cd");
}
/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {

	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( " 1R ", "");
			InsertItem( " 1S ", "");
		}
		break;
	}
}

/**
 * 시트 초기설정값, 헤더 정의<br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * 
 * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
 * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
 * @return 없슴
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
    var sheetID = sheetObj.id;

    switch (sheetID) {
    case "sheet1": //sheet1 init
        with(sheetObj){
        
        if (location.hostname != "")
        var HeadTitle1="|hndl_ofc_cd|auto_snd_flg_radio|auto_snd_flg|hndl_ofc_addr|hndl_ofc_eml|ntc_msg_tp_cd_1r|cstms_ntc_msg_1r|ntc_msg_tp_cd_1s|cstms_ntc_msg_1s";
        var headCount=ComCountHeadTitle(HeadTitle1);

        SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );

        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        InitHeaders(headers, info);

        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hndl_ofc_cd" },
                     {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"auto_snd_flg_radio" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"auto_snd_flg" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hndl_ofc_addr" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hndl_ofc_eml" },
                     {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"ntc_msg_tp_cd_1r" },
                     {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cstms_ntc_msg_1r" },
                     {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"ntc_msg_tp_cd_1s" },
                     {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cstms_ntc_msg_1s" } ];
        
        InitColumns(cols);
        }
        break;
    }
}
    
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	switch (sAction) {
	case COMMAND02 :
		if (!validateForm(sheetObj, formObj, sAction))	return;
		break;
		case IBSEARCH:    // 조회
			ComOpenWait(true);//대기창
			formObj.f_cmd.value=SEARCH;
			//sheetObj.DoSearch("ESM_BKG_1179GS.do", FormQueryString(formObj));
			formObj.hndl_ofc_cd.value=formObj.frm_hndl_ofc_cd.value.toUpperCase(); 
			var sXml=sheetObj.GetSearchData("ESM_BKG_1179GS.do", FormQueryString(formObj));
            sheetObj.LoadSearchData(sXml,{Sync:1} );
			IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
			if (document.form.frm_hndl_ofc_cd.value.length == 0) {
				ComShowCodeMessage("BKG00889", "No data found."); 
			}				
			document.form.frm_hndl_ofc_cd.value=orgHndlOfcCd;
			ComOpenWait(false);//대기창 사라짐
		break;
		case IBSAVE:    // 저장
            formObj.f_cmd.value=MULTI;
			if ( formObj.frm_cstms_ntc_msg_1r.value.length > 3000 ) {
				ComShowCodeMessage("BKG43035", "1R" ,  3000 , formObj.frm_cstms_ntc_msg_1r.value.length );    // "{?msg1} must not be over {?msg2} characters long.\nYou Input {?msg3} Characters."
				break;
			} else if ( formObj.frm_cstms_ntc_msg_1s.value.length > 3000 ) {
				ComShowCodeMessage("BKG43035", "1S" ,  3000 , formObj.frm_cstms_ntc_msg_1s.value.length );    // "{?msg1} must not be over {?msg2} characters long.\nYou Input {?msg3} Characters."
				break;
			}
            formObj.frm_auto_snd_flg.value="Y";
            if ( formObj.frm_auto_snd_flg_radio[1].checked ) formObj.frm_auto_snd_flg.value="N";
            formObj.frm_ntc_msg_tp_cd_1r.value="1R"; 
            if ( formObj.frm_cstms_ntc_msg_1s.value.length > 0 ) formObj.frm_ntc_msg_tp_cd_1s.value="1S";
            formObj.frm_hndl_ofc_cd.value=formObj.frm_hndl_ofc_cd.value.toUpperCase();
        	sheetObj.DataInsert(1);
            IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
            sheetObj.DoSave("ESM_BKG_1179GS.do", FormQueryString(formObj));
            ComOpenWait(false);
		break;
	}
}
/**
 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param {shtObj} String : 해당 IBSheet Object
 * @param {ErrMsg} String : 조회 후 메시지
 */
function sheet1_OnSearchEnd(shtObj, ErrMsg) {
	isRetrieved=true;
	if (ErrMsg != "") return;
}
/**
 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
 * @param {shtObj} String : 해당 IBSheet Object
 * @param {ErrMsg} String : 저장 후 메시지
 */
function sheet1_OnSaveEnd(shtObj, ErrMsg) {
	if (ErrMsg != "") return;
	if (document.form.f_cmd.value == MULTI01) {
		ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
	}
	// 저장 후 재조회
	doActionIBSheet(shtObj, document.form, IBSEARCH);
}
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem){
    var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
    	beforetab=nItem;
   }

/**
 * 조회 조건 변경 여부를 반환한다.<br>
 * 
 * @return boolean true: 조회조건 변경 됨, false:조회조건 변경 없슴
*/ 
function isChangedSearchKeyword() {
	var formObj=document.form;
	if (orgHndlOfcCd != formObj.frm_hndl_ofc_cd.value) {
		return false;
	}
	return true;
}
/* 개발자 작업 끝 */
