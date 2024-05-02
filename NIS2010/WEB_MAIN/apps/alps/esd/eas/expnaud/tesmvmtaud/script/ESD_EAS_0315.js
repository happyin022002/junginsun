/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_EAS_0315.js
*@FileTitle : Contianer Movement - Reefer
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015-02-02 9014613 			1.0	최초 생성
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
     * @class ESD_EAS_0315 : ESD_EAS_0315 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0315() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    /* 공통전역변수 */
  //var calPop = new calendarPopupGrid();  
  var sheetObjects = new Array();
  var sheetCnt = 0;

  /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

  	/**
  	 * IBSheet Object를 배열로 등록
  	 * ComSheetObject(id)에서 호출한다
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++] = sheet_obj;
  		// 1-1. jsp에서 선언된 sheet Object들을 배열화 한다.(sheet Object가 여러개일수 있으므로)
  	}
  	
  	function ComAddComboItem2(obj, pText, pValue) {  	  		
		if(obj != null )
		{ 
			var optionItem   = document.createElement("option");
			optionItem.text  = pText;
			optionItem.value = pValue;
			 
			obj.add(optionItem);
			return obj.length;
		}
		return 0;		
	}
  	
  	/*
  	 * 외부 콤보박스의 리스트 가져오기
  	 */
  	function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
  		var formObj = document.form;
  		var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
  		var charval = "Y";
  		obj.value = lvobj;

  		for (var i = 0; i < lvobj.length; i++) {
  			var oneChar = lvobj.charAt(i)
  			if (oneChar != "") {
  				if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" )    ){
  				}else {
  					charval ="N";
  					break;
  				}
  			} else {
  				charval ="N";
  				break;
  			}
  		}
  		if(charval!="Y") {
  			var errMessage = ComGetMsg('COM12130','Location','Node Code','');  
  			ComShowMessage(errMessage);
  			obj.value = "";
  			obj.focus();
  			return false;
  		}
  		if( lvobj == "" ) {
  			obj.value = "";
  			if(obj.name == 'search_fm_loc') yard_obj = document.search_fm_yard;
  			else if(obj.name == 'search_via_loc') yard_obj = document.search_to_yard;
  			else if(obj.name == 'search_to_loc') yard_obj = document.search_to_yard;
  			else if(obj.name == 'search_door_loc') yard_obj = document.search_door_yard;

  			var locValue = obj.value;
  			if(ComTrim(locValue) == ''){
  				yard_obj.RemoveAll();
  				return;
  			}
  		}else{
  			if( sep == 'F' ) {
  				lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
  			}else if( sep == 'V' ){
  				lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
  			}else if( sep == 'T' ){
  				lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
  			}else if( sep == 'D' ){
  				lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
  			}else{
  			}
  			comObj.focus();
  		}
  	}
  	
  	/**
  	 * 공통 Node popup
  	 */
  	function openHireYardPopup(objName) {
  		var formObject = document.form;
  		var cmdt_cd_val ="";   //향후 사용가능 예정변수
  		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
  		var cmdt_desc_val ="";   //향후 사용가능 예정변수
  		var classId = objName;
  		var xx1 = ""; //CONTI
  		var xx2 = ""; //SUB CONTI
  		var xx3 = ""; //COUNTRY
  		var xx4 = ""; //STATE
  		var xx5 = ""; //CONTROL OFFIC
  		var xx6 = ""; //LOC CODE
  		var xx7 = ""; //LOC NAME
  		var xx8 = "";
  		var xx9 = "";
  		if( objName == "getDorLoc" ) {
  			v6 = "zone"
  		} else {
  			v6 = "yard";
  		}
  		
  		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
  		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
  	}
  	
  	/**
  	 * From Node 팝업에 대한 리턴값
  	 */
  	function getFromNode(rowArray) {
  		var formObject = document.form;
  		var colArray = rowArray[0];
  		var node = colArray[3];
  		var lvLoc = node.substring(0, 5);
  		var lvYard = node.substring(5, 7);
  		formObject.search_fm_loc.value = lvLoc;
  		getYardCombo(document.search_fm_yard, sheetObjects[0], formObject, lvLoc);
  		document.search_fm_yard.CODE = lvYard;
  	}
  	

  	/**
  	 * Sheet 기본 설정 및 초기화 
  	 * body 태그의 onLoad 이벤트핸들러 구현
  	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  	 */
  	function loadPage() {
  		for(i=0;i<sheetObjects.length;i++){
  		   //khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		initControl();
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
  					
  					style.height = 400;
  					
  					//전체 너비 설정
  					//SheetWidth = 785;
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msAll;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;

  					var HeadTitle1 = "|SEQ|CNTR No.|Type/Size|Origin Yard|Bound|MVMT Leg|From date|To date|Days|IN VVD|OUT VVD|BKG No.|B/L No.|Manufacture Date|Reefer Dry";
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 10);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
  		
  					// 해더에서 처리할 수 있는 각종 기능을 설정한다[SortEnable, ColumnMove, AllCheckEnable, UserResize, RowMove, Head3D]
  					InitHeadMode(true, true, false, true, false, false)
 					
  					  					
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle1, true);  					
  		
  					//데이터속성	[   ROW,   COL,	DATATYPE, 	  WIDTH,	DATAALIGN,  COLMERGE,	SAVENAME,   	   KEYFIELD,	CALCULOGIC,   DATAFORMAT,  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty( 0, cnt++,	dtHiddenStatus,	40,		daCenter,	   	false,	"ibflag");
  					InitDataProperty( 0, cnt++, dtDataSeq,      30,     daCenter,    	false,  "seq"				,	false,    "",     dfNone,    		0,    	false,    	false);
  					InitDataProperty( 0, cnt++, dtData, 		110, 	daCenter,	    false, 	"cntr_no"   		,   false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		65, 	daCenter,	    false, 	"cntr_tpsz_cd"      , 	false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		75, 	daCenter,	    false, 	"org_yd_cd"			,	false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		50, 	daCenter,	    false, 	"bnd_cd"    		, 	false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		65, 	daCenter,	    false, 	"mvmt_sts_cd"      	, 	false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		115, 	daCenter,	   	false, 	"fm_cnmv_evnt_dt"   ,	false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		115, 	daCenter ,	   	false, 	"to_cnmv_evnt_dt"   ,	false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		45, 	daCenter,	   	false, 	"days"   			, 	false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		75, 	daCenter,	   	false, 	"in_vvd"       	    ,   false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		75, 	daCenter,	   	false, 	"out_vvd"      		,   false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		90, 	daCenter,	   	false, 	"bkg_no"        	,   false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		90, 	daCenter,	   	false, 	"bl_no"    			,	false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		120, 	daCenter,	   	false, 	"mft_dt"    			,	false, 	"", 			dfDateYmd, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		70, 	daCenter,	   	false, 	"rd_cgo_flg"  		,	false, 	"", 			dfNone, 			0, 		false, 		false );
  					
  				}
  				break;
  		}
  	}

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 var sheetObject = sheetObjects[0];
  		 var formObject = document.form;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");
  	
  			switch(srcName) {
	  			case "btns_frmnode": //FromNode Popup창
					openHireYardPopup('getFromNode');
					break;
  				case "btns_calendar1":  					
	  				var cal = new ComCalendar();
	  				cal.setDisplayType('date');
	  				cal.select(formObject.fm_dt,'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":  					
	  				var cal = new ComCalendar();
	  				cal.setDisplayType('date');
	  				cal.select(formObject.to_dt,'yyyy-MM-dd');  					
  					break;  				
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_new":
  					doActionIBSheet(sheetObject,formObject,IBCLEAR);
  					break;
    			case "btn_bkg_no":
    				popUpMultiSelectWin("bkg_no")
    				break;
    			case "btn_cntr_no":
    				popUpMultiSelectWin("cntr_no")
    				break;
    			case "btn_vvd":	
	        	  	var param = "";
	        	  	param += "vvd_cd="+ComGetObjValue(formObject.vvd_cd);
	        	  	param += "&lane_cd="+"";
	        	  	param += "&loc_cd="+"";  
	        	  	ComOpenPopup('/hanjin/COM_ENS_0B2.do?'+param , 780, 465, 'getVVD', '1,0,1,1,1,1,1,1', true);
	        	  	break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg('COM12111'));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
  	
  	function initControl() {
		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
		axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
		axon_event.addListenerFormat( 'keypress','obj_keypress', document.form); //- 키보드 입력할때
	}
  	
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "int":
	            if(obj.name=="s_vndr_seq") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
			case "uppernum":
				// 영문 대문자만 입력하기, 영문대+숫자/ '44' = ',' <- 예외 입력문자
				ComKeyOnlyAlphabet('uppernum','44');
				break;
			case "upper":
				// 영문 대문자만 입력하기
				ComKeyOnlyAlphabet('upper');
				break;
        	case "ymd":
        		ComKeyOnlyNumber(event.srcElement);
            	break;
        	case "float":
        		ComKeyOnlyNumber(event.srcElement, "-.");
            	break;
	    }
	}
	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {			
			case "fm_dt":
			case "to_dt":
				if(!ComChkObjValid(obj)){
					obj.value = "";
					obj.focus();
				};
			break;
		}
	} 	
	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "fm_dt":
			getMonthBetween(obj);
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "to_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		}
	}
	
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "fm_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "to_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}
	
	//월에 더하기를 한다.
	function getMonthBetween(obj) {
		var formObj = document.form;
		if(obj.value.length >= 8) {
			formObj.to_dt.value = ComGetDateAdd(obj.value,"D", 30, "-");
		}else{
			formObj.to_dt.value = "";
		}
	}
  	
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  	
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
		   case IBSEARCH:	  //조회
			   	if(!validateForm(sheetObj,formObj,sAction)) {
 					return false;
 				}
				formObj.f_cmd.value = SEARCHLIST01;
				var _tmp_val = document.search_fm_yard.CODE;
				formObj.org_yd_cd.value = formObj.search_fm_loc.value + _tmp_val;
				sheetObj.DoSearch("ESD_EAS_0315GS.do", FormQueryString(formObj));
				break;
  			case IBCLEAR:	   //Clear
  				document.search_fm_yard.RemoveAll();
  				sheetObj.RemoveAll();
  				formObj.reset();  				
  				break;
  			case IBDOWNEXCEL:  //엑셀내려받기
  				sheetObj.SpeedDown2Excel(true);
  				break;
  		}
  	}
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		
  		with(formObj){
  			if(!ComChkValid(formObj)) return false;
  			
  			if (ComTrim(document.search_fm_yard.CODE)=="") {
                var sTitle = "Origin Yard";
                ComShowMessage("'" + sTitle + "' " + Msg_Required);
                try{ document.search_fm_yard.focus(); } catch(ee) {;}
                return false;
            }
  			
  			if(ComIsEmpty(formObj.fm_dt) && ComIsEmpty(formObj.to_dt) && ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.cntr_no) ){
  				ComShowMessage("At least one option needs to be input. (Period, BKG NO, CNTR NO)");
  				return false;
  			}
  			
  			
  		}
  		switch(sAction) {
		case IBSEARCH:      //조회			
			if (ComGetDaysBetween(formObj.to_dt.value, ComGetDateAdd(formObj.fm_dt.value, "M", 1)) < 0) {
                ComShowCodeMessage("COM12133", "The start and end date", "1 Month", "less");    // {?msg1} must be {?msg3} than {?msg2}.
                return false;
            }	
			break;
    	}
		return true;
  		
  		
  		
  	}
  	
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet_OnSearchEnd(sheetObj,errMsg){
  		//if(errMsg!=null){
  		//	ComShowMessage(errMsg);
  		//}
  	}
  	
  	function sheet1_OnClick(sheetObj, Row,Col,Value){
  		if ( sheetObj.ColSaveName(Col) == "blahblah" ) { 
  		
  		}
  	}
  	
	/*
	 * 각 공통팝업창 호출 함수 
	 */
	function popUpMultiSelectWin(rtnValBoxNm) {
		
		var returntitle = '';
		var flag = ComReplaceStr(rtnValBoxNm,"s_","");
		
			if(flag == 'bkg_no')
				returntitle = 'BKG No.';
			else if(flag == 'cntr_no')
				returntitle = 'CNTR No.';
			
			var param = "?returnval=" + rtnValBoxNm + "&returntitle=" + returntitle;
			ComOpenPopup('ESD_EAS_MULTI.do'+param, 400, 380, 'getEas_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
			
		
//			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
//			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
	}

    /*
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getEas_Multi(rArray, return_val) {
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
    }
    
    /**
     * VVD Popup 창에서 VVD 값을 받음. BOOKING.T/VVD, callBack0019 함수 참조 <br>
     * <br><b>Example :</b>
     * @param Popup에서 전달받은 값
     */
    function getVVD(rArray){    	
    	var formObj = document.form;
    	    	
	    if(rArray != null){
	    	ComSetObjValue(formObj.vvd_cd,rArray[0][7]);
    	}    	
    }    
	/* 개발자 작업  끝 */
