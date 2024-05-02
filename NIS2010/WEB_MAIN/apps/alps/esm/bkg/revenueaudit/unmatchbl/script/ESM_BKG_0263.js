/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0263.js
*@FileTitle : Self Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.31 김대호
* 1.0 Creation
===============================================================================
* History
* 2010.10.22 이일민 [CHM-201006493-01] Charge Save시 Self Audit 자동 실행 요청 - opener reload
* 2011.05.12 이일민 [CHM-201109862-01] [BKG/DOC] BKG Creation Charge화면의 Self Audit기능 Transaction Time 변경 요청
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
=========================================================*/
/**
 * @fileoverview Self Audit 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESM_BKG_0263:ESM_BKG_0263 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/**
 * @extends  
 * @class ESM_BKG_0263 : ESM_BKG_0263 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0263() {
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.obj_keypress           = obj_keypress;
	this.obj_deactivate         = obj_deactivate;
	this.processButtonClick		= processButtonClick;
	this.doActionIBSheet 		= doActionIBSheet;
}
    
//===================================================================================
//전역변수
//===================================================================================
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1;
var intervalId;
var intervalTime = 2000;
var processCnt = 0;
//업무전역변수
//컬럼변수

//===================================================================================
//페이지 초기화
//===================================================================================
/** 
* IBSheet Object를 sheetObjects 배열로 등록 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj IBSheet Object
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.29
*/ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
* body 태그의 onLoad 이벤트핸들러 구현 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.29
*/ 
function loadPage() {
	
	var form = document.form;
	
    //IBSheet 초기화
    sheet1 = sheetObjects[0];
    sheetCnt = sheetObjects.length ;
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
    }
    processCnt = 0;

    sheet1.WaitImageVisible = false;
	
    //html컨트롤 이벤트초기화    
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	
    window.attachEvent("onbeforeunload",reloadOpener);
    
    form.bl_no.value = form.bl_no_org.value;
    
    doActionIBSheet(sheet1, form, IBSEARCH);    
    
}

/** 
* Sheet 기본 설정 및 초기화 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param {IBSheet} sheetObj : 시트오브젝트
* @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.29
*/ 
function initSheet(sheetObj, sheetNo) {
	
	var cnt = 0;
	var sheetID = sheetObj.id;
   
	switch(sheetID) {
		case "sheet1":
	      	with (sheet1) {
	            //높이 설정
	            style.height = 560;
	            //전체 너비 설정
	            //gSheet1Width = mainTable.clientWidth;
	            //SheetWidth = gSheet1Width;
	            SheetWidth = mainTable.clientWidth;
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            //전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(1, 1, 3, 100);
				var HeadTitle1 = "Error\nKind|Description|Booking|Contract|mtch_umch_tp_cd|Audit Result";
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
	            //해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false, false);
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
               
				//데이터속성          ROW,COL    ,DATATYPE        ,WIDTH  ,DATAALIGN   ,COLMERGE ,SAVENAME            ,KEYFIELD ,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
				InitDataProperty(0, cnt++ ,dtData          ,45     ,daCenter    ,false    ,"umch_tp_cd"        ,false    ,""        ,dfNone    ,0         ,false     ,false );
				InitDataProperty(0, cnt++ ,dtData          ,130    ,daCenter    ,false    ,"umch_tp_desc"      ,false    ,""        ,dfNone    ,0         ,false     ,false );
				InitDataProperty(0, cnt++ ,dtData          ,385    ,daLeft      ,false    ,"bkg_itm_log"       ,false    ,""        ,dfNone    ,0         ,false     ,false );
				InitDataProperty(0, cnt++ ,dtData          ,385	   ,daLeft      ,false    ,"ctrt_itm_log"      ,false    ,""        ,dfNone    ,0         ,false     ,false );
				InitDataProperty(0, cnt++ ,dtHidden        ,40     ,daCenter    ,false    ,"mtch_umch_tp_cd"   ,false    ,""        ,dfNone    ,0         ,false     ,false );
				InitDataProperty(0, cnt++ ,dtHidden        ,80     ,daCenter    ,false    ,"mtch_umch_tp_desc" ,false    ,""        ,dfNone    ,0         ,false     ,false );
							
				//AutoRowHeight = true; 
                //WordWrap = true;
				
				//ExtendLastCol = true;
				//Ellipsis = true;
			
	      	}
	      	break;
	      	
	}
}

//===================================================================================
//버튼 이벤트 처리
//===================================================================================
document.onclick = processButtonClick;

/** 
* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.29
*/ 
function processButtonClick(){
	var form = document.form;
    try {
	    var srcName = window.event.srcElement.getAttribute("name");
	    switch(srcName) {
	    	case "btn_Retrieve":
	    		if (validateForm(sheet1, form, IBSEARCH)) {
	    			doActionIBSheet(sheet1, form, IBSEARCH);
	    		}
	    		break;
	    		
			case "btn_New":
				//alert("btn_New");
				//form.bl_no.value = form.bl_no_org.value;
				form.bl_no.value = "";
				form.audit_result.value = "";
				sheet1.RemoveAll();
				break;
				
			case "btn_Close":
				window.close();
				break;

	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e);
 		}
 	}
}

//===================================================================================
//Axson Event Handler
//===================================================================================
/** 
* Object 의 Keypress 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.29
*/ 
function obj_keypress(){
	var obj = event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus = obj.dataformat;
	switch(obj.dataformat){
	 	case "ymd": //날짜 입력하기
 	 		ComKeyOnlyNumber(obj,"-"); 
	 		break;
        case "int": //숫자만 입력
        case "number": //숫자만 입력
        	ComKeyOnlyNumber(obj);
        	break;
        case "engup":
        	ComKeyOnlyAlphabet('upper');
        	break;
     	case "uppernum":
     		ComKeyOnlyAlphabet('uppernum');
     		break;
		default:
			//ComKeyOnlyNumber(obj);
			break;
	}
}

/** 
* Object 의 Onbeforedeactivate 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.29
*/ 
function obj_deactivate() {
	var formObj = event.srcElement;
    var srcName = formObj.getAttribute("name");
    switch(srcName) {
    	case "bl_no":
			break;
		default :
			ComChkObjValid(formObj);
			break;
	}
}

//===================================================================================
//UI Object Event Handler
//===================================================================================
/** 
* sheet1 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.29
*/ 
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var form = document.form;

	sheet1.SheetFontName = "Arial";
	sheet1.ColFontColor("bkg_itm_log") = sheet1.RgbColor(255, 0, 0);
	if (errMsg == "") {
    	if(sheet1.RowCount > 0) {
    		
    		var cellFont = "Courier New";
    		var cellFontSize = 8;
    	    var startRow = sheet1.HeaderRows;
    		var endRow = sheet1.HeaderRows + sheet1.RowCount;
    		var tmpStr = "";
    		
    		for(var i = startRow; i < endRow; i++) {
    			
    			sheet1.RowHeight(i) = 0;
    			
    			tmpStr = "";
    			tmpStr = sheet1.CellValue(i, "bkg_itm_log") + "\n";
    			sheet1.CellValue(i, "bkg_itm_log") = tmpStr;     			
    			
    			tmpStr = "";
    			tmpStr = sheet1.CellValue(i, "ctrt_itm_log") + "\n";
    			sheet1.CellValue(i, "ctrt_itm_log") = tmpStr;     			
    			
    			sheet1.CellFont("FontName", i, "bkg_itm_log") = cellFont;
    			sheet1.CellFont("FontName", i, "ctrt_itm_log" ) = cellFont;
    			sheet1.CellFont("FontSize", i, "bkg_itm_log") = cellFontSize;
    			sheet1.CellFont("FontSize", i, "ctrt_itm_log") = cellFontSize;
    			
    		}
    		
    	}
    }
}   

//===================================================================================
//서버 조회/저장
//===================================================================================
/** 
* 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.29
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {

	//var form = document.form;
	sheet1.ShowDebugMsg = false;
         
	switch(sAction) {
        case IBSEARCH: // 조회
        
        	var params = "f_cmd=" + SEARCH + "&bl_no=" + formObj.bl_no.value + "&ca_flg=" + formObj.ca_flg.value ;
        
	    	ComOpenWait(true);
	    	sheet1.WaitImageVisible = false;
			var sXml = sheet1.GetSearchXml("ESM_BKG_0263GS.do?", params);

			if (ComGetEtcData(sXml, "jobID")) {
				ComSetObjValue(formObj.key, ComGetEtcData(sXml, "jobID"));
	            intervalId = setInterval(callIntervalBackEndJob, intervalTime);
			} else {
				ComOpenWait(false);
			}
			break;
			
    	case SEARCH01: // BackEndJob 결과 조회
	    	ComSetObjValue(formObj.f_cmd,SEARCH01);
	    	params = FormQueryString(formObj);
	    	var sXml = sheet1.GetSearchXml("ESM_BKG_0263GS.do", params);
			if (ComGetEtcData(sXml, "result") || ComGetEtcData(sXml, "auditResultNm")) {
		    	if (ComGetEtcData(sXml, "auditResultNm")) {
					ComSetObjValue(formObj.audit_result, ComGetEtcData(sXml, "auditResultNm"));
				}
				if (ComGetEtcData(sXml, "result")) {
					ComShowMessage(ComGetEtcData(sXml, "result"));
				}
				sheet1.LoadSearchXml(sXml);
        		clearInterval(intervalId);
				ComOpenWait(false);
			}
		    break;
	}
}

//BackEndJob 결과 조회용 루프 함수
function callIntervalBackEndJob() {
	if (300==processCnt++) {  //intervalTime(2초) * 300 = 10분
		clearInterval(intervalId);
		ComOpenWait(false);
	}
    doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
}

/** 
* 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.29
*/ 
function validateForm(sheetObj, formObj, sAction){
	
	var form = document.form;
	
	var blNoObj = form.bl_no;
	var blNoCaption = blNoObj.caption;
	var blNoVal = blNoObj.value; 
	
	switch (sAction) {
	    case IBSEARCH: //조회
	    	if(blNoVal.length < blNoObj.maxLength) {
				ComShowCodeMessage("BKG95018", blNoCaption, blNoObj.maxLength);
				ComSetFocus(blNoObj);
				return false;
	    	}
	    	break;
    }

    return true;
    
}

function reloadOpener() {
	if (opener && opener.document && opener.document.getElementById("btn_t10retrieve")) {
		opener.document.getElementById("btn_t10retrieve").fireEvent("onclick");
	}
}
