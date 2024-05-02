/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0051.js
*@FileTitle  : Representative Charge
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author CLT
 */
/**
 * @extends
 * @class BCM_CCD_0051 : BCM_CCD_0051 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/* 개발자 작업 */
// 공통전역변수
var sheetObjects=new Array(); 
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var saveRows=new Array();
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObj=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	var prefix="sheet1_";	
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_DownExcel":
			if (sheetObj.RowCount> 0 ) {
				sheetObj.SpeedDown2Excel(1);
				//sheetObj.Down2Excel( {FileName : "BCM_CCD_0051DL.xls", DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			}
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;
		case "btn_New":
			sheetObj.RemoveAll();
			formObj.ofc_kind_cd.Code ="";
			formObj.reset();
			break;
		case "btn_com_ens_071_ofc_cd": 	
  			var formObj=document.form;
         	var sUrl="COM_ENS_071.do?ofc_cd=" + formObj.ofc_cd.value +"&main_page=false"+"&mdm_yn=Y";
         	var rVal=ComOpenPopup(sUrl, 800, 450, "getCOM_ENS_071_ofc_cd", "0,0", true);
   		break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	doActionIBCombo(sheetObjects[0], formObj, SEARCH);       // 콤보박스 생성
}
function initPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // sheet1 init
	    with(sheetObj){
    	// 높이 설정
        style.height = 380;
        //Host정보 설정[필수][HostIp, Port, PagePath]
        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        
        //전체Edit 허용 여부 [선택, Default false]
        Editable = true;

    	InitRowInfo( 1, 1, 5, 100);
        InitColumnInfo(16, 0, 0, true);
        FocusEditMode = -1;

        // 해더에서 처리할 수 있는 각종 기능을 설정한다
        InitHeadMode(false, true, true, false, false, false);
        var prefix = "sheet1_";
        
		  var HeadTitle="|Seq.|Office|Office\nLevel|LEVEL1|LEVEL2|LEVEL3|LEVEL4|LEVEL5|LEVEL6|Office Name|Status|Create User|Create Date/Time|Last Update User|Last Update Date/Time";
          //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          InitHeadRow(0, HeadTitle, true);
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
          InitDataProperty(0, cnt++ , dtHiddenStatus, 23,    daCenter,  false, prefix +"ibflag");
          InitDataProperty(0, cnt++ , dtSeq,    		30,    daCenter,  true,   prefix +"seq", 					false,         "",          dfNone,     0,     true,       true);
          InitDataProperty(0, cnt++ , dtData,      	60,   daCenter,   true,     prefix +"ofc_cd", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	45,   daCenter,   true,     prefix +"ofc_lvl", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	60,   daCenter,   true,     prefix +"ho", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	60,   daCenter,   true,     prefix +"rhq", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	60,   daCenter,   true,     prefix +"bb_aa", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	60,   daCenter,   true,     prefix +"sub_bb", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	60,   daCenter,   true,     prefix +"bb_aa3", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	60,   daCenter,   true,     prefix +"bb_aa4", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	250,   daCenter,   true,     prefix +"ofc_eng_nm", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	50,   daCenter,   true,     prefix +"status", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	80,   daCenter,   true,     prefix +"cre_usr_id", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	120,   daCenter,   true,     prefix +"cre_dt", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	105,   daCenter,   true,     prefix +"upd_usr_id", 		false,          "",      	dfNone, 0,     false,       false);
          InitDataProperty(0, cnt++ , dtData,      	140,   daCenter,   true,     prefix +"upd_dt", 		false,          "",      	dfNone, 0,     false,       false);

		}
		break;
	}
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: // 조회
		formObj.f_cmd.value=SEARCH01;
		//sheetObj.RenderSheet(0);
		var sXml=sheetObj.GetSearchXml("BCM_CCD_0051GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
		var arrXml = sXml.split("|$$|"); 
		sheetObj.LoadSearchXml(sXml);
		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchXml(arrXml[0]);
		}
		ComOpenWait(false);
		break;
	}
}
function rep_chg_cd_OnChange() {
	var sheetObj=sheetObjects[0];
    var formObj=document.form;
    doActionIBSheet(sheetObj, formObj, IBSEARCH);
    // 데이터 없을시 Insert 모드
    if(sheetObj.RowCount()==0){
    	sheetObj.SetCellValue(1,'sheet1_ibflag',"I");
    	sheetObj.DataInsert(-1);
    }
}
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);
	axon_event.addListenerForm('keypress', 'obj_KeyPress', form);
//	axon_event.addListenerForm('focus',      'obj_activate',   formObj);
//	axon_event.addListenerFormat('keypress', 'obj_keypress',   formObj);
}
function obj_activate(){
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/**
 * HTML Control의 포커스를 잃었을때 발생하는 이벤트를 처리한다.
 */
function obj_deactivate() {
	var formObj=document.form;
	var obj=event.srcElement;
}
/**
 * sheet1 OnChange 이벤트 처리
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	var colNm=sheetObj.ColSaveName(col);
	if(colNm == "sheet1_delt_flg") {
		if(value == "Y") {
			if(!ComShowCodeConfirm("COM130301", "data")) sheetObj.SetCellValue(row, col,"N",0);
		}
	}
}
 /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
 * @author 서미진
 * @version 2011.02.19
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	} 	
	/**
	* IBCombo Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setComboObject(comboObj);
	* </pre>
	* @param {ibcombo} combo_obj 필수 IBCombo Object
	* @return 없음
    * @author 서미진
    * @version 2011.02.19
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}	
 /**
  * 공통 콤보 박스 조회
  */
  /**
   * 모든 콤보 박스 조회
   * 공통 부분 완성되면 추가 작업 요
   */
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
		switch (sAction) {
			case SEARCH: // load page 시
				var sXml=sheetObj.GetSearchXml("BCM_CCD_0051GS.do", "f_cmd=" + SEARCH);
				var rtnValue=sXml.split("|$$|");
				for(var i=0; i<rtnValue.length; i++){
					var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
					var cdName=comboXml[0].split("|");
					var cdValue=comboXml[1].split("|");
					for (var j=0; j < cdName.length; j++) {
						comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);
					}
				}
				break;
   	}
}	
   /**
    * Html Object의 값을 변경할 때 숨겨진 Sheet에 변경된 값을 반영한다.<br>
    * 숨겨진 sheet를 이용하여 값을 저장한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *   com_change_sheet( sheetObj, colNm );
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {string} colNm 필수 Html Object의 name
    * @return 없음
    * @author 김민아
 	* @version 2010.10.13
    */  
    function com_change_sheet( sheetObj, colNm ){
    	var formObj=document.form;
        var eleValue="";
        if(document.getElementById(colNm).type=="text"){
            switch(colNm){
                default:
                    eleValue=document.getElementById(colNm).value;    
                    break;                  
            }           
            sheetObj.SetCellValue(1,colNm,eleValue);
        }else{
            sheetObj.SetCellValue(1,colNm,document.getElementById(colNm).GetSelectCode());
        }
    }   
  /**
   * COM_ENS_071 : 팝업에서 선택한 값 한개 받기 
   * @author 서미진
	 * @version 2011.02.21
   */
  function getCOM_ENS_071_ofc_cd(rowArray) {   
  	var formObj=document.form;
  	var colArray=rowArray[0];	
  	formObj.ofc_cd.value=colArray[1];		
	//com_change_sheet( sheetObjects[0], "ofc_cd" );	
  }
