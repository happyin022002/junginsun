/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1012.js
*@FileTitle : KPI Performance Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
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
     * @class ESD_SPE_1012 : ESD_SPE_1012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1012() {
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
    //공통전역변수
    var frm = null;
    var rhqXml = null;
    var ofcXml = null;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	// 조회여부 
	var hasSerched = false;
	var temYear = "";
	// HEADER ROW
	var HEADROWS = 2;
    /**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	 

	/**
     * IBMultiCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
    }
    
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;    

	 
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
	 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObj    = sheetObjects[0];

	 	/*******************************************************/
	 
	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {
		 		case "btn_audit_month":
					temYear = frm.s_ev_yr.value;
					var cal = new ComCalendar();
						cal.setDisplayType('year');
						cal.setEndFunction('calEndFunction');
						cal.select(frm.s_ev_yr, 'yyyy');
					break;         	
	 			case "btn_retrieve":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0], frm, IBSEARCH);	 				
//	 				if(validateForm(sheetObjects[0],frm,srcName)){
//	 				}
	 				break;
					 				
	 			case "btn_save":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	 				break;
	 				 			
	 			case "btn_downexcel":
					doActionIBSheet(sheetObjects[0],frm,IBDOWNEXCEL);
					break;
	 			case "btn_vndr_seq":
					rep_OnPopupClick("form");
			        break;
	 				
	 		} // end switch
	 	}catch(e) {
	  		if( e == "[object Error]") {
	      		ComShowMessage(OBJECT_ERROR);
	  		} else {
	      		ComShowMessage(e);
	  		}
	  	}
	 }

    // 달력에서 값이 변경되면 그리드를 초기화 한다.
	 function calEndFunction(){ 
		 if(temYear != frm.s_ev_yr.value){
			 sheetObjects[0].RemoveAll();
			 temYear = frm.s_ev_yr.value; 
		 }
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
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		frm = document.form;
		
	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
//	    
	     // combo 생성
	     doActionIBCombo(frm.s_eg_rhq_cd); // Level1
	     doActionIBCombo(frm.s_ev_svc_cate_cd); // Level3
	     //IBMultiCombo 설정
         for(var k = 0; k < comboObjects.length; k++){
        	 
       	  	 initCombo(comboObjects[k], k + 1);
         }
//         
         initControl();
         
         var today = new Date();
         var year = today.getYear();
         frm.s_ev_yr.value = year;
	}
	
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/	
	function initControl() {
		axon_event.addListenerForm('keypress',   'obj_keypress',      frm); //- 키 눌렸을때
		axon_event.addListenerForm( 'blur'   ,   'obj_blur'    ,      frm ); //- 포커스 나갈때
		axon_event.addListenerForm('change',     'obj_change', frm);		
		axon_event.addListener ('keydown', 'keydownEnter', 'form');
	}

	 /**
	  * HTML Control KeyDown 이벤트 호출
	  */
	 function keydownEnter() {
	 	if (event.keyCode != 13) {
	 		return;
	 	}
	 	doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
	 }
	 
	/**
	* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
	**/
	function obj_keypress(){
		switch (event.srcElement.name) {    
		    case "s_ev_yr":
		    	ComKeyOnlyNumber(event.srcElement);		    	
				break;
		}	
	}
	
	/**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
    	comboObj.ValidChar(2,0);
    	comboObj.UseAutoComplete = true;    	
    	switch(comboObj.id) {
   	  		case "s_eg_rhq_cd":
        		comboObj.DropHeight = 250;
        		comboObj.Index=0;
  			break;  
   	  		case "s_eg_ofc_cd":
   	  			comboObj.DropHeight = 250;
   	  			break;  
   	  		case "s_ev_svc_cate_cd":
   	  			comboObj.Index=0;
   	  			comboObj.DropHeight = 300;
   	  			break;    			
   	  	}
    	
    }
    
    /**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	 function initSheet(sheetObj,sheetNo) {
		 var cnt = 0;
		 switch(sheetNo) {
		 	case 1:      //sheet1 init
		    	with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(20);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = true;
				    
				    var HeadTitle1 = "ibflag||Year|EG ID|S/P Code|S/P Name|EG Name|KPI|KPI|Type Code|Type Code|Performance|Performance|Performance|Performance|Performance|Performance|Performance|Performance|Performance|Performance|Performance|Performance|Performance|Weight(%)|Score|SVC CD|SVC NM|SAVED|MODIFIY_YN";
					var HeadTitle2 = "ibflag||Year|EG ID|S/P Code|S/P Name|EG Name|KPI|KPI|Type Code|Type Code|Target|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC|Weight(%)|Score|SVC CD|SVC NM|SAVED|MODIFIY_YN";
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(HEADROWS, 1, 24, 100);
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 11, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
					InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	true,	"chk");
					InitDataProperty(0, cnt++ , dtData,         40,  	daCenter,   true,	"ev_yr",		false,   "",      dfNone,          0,          false,       false,   10);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,	"eg_id",        false,   "",      dfNone,          0,          false,       false,   10);
					
					InitDataProperty(0, cnt++ , dtData,         60,  	daLeft,     true,	"sp_seq",       false,   "",      dfNone,          0,          false,       false,   10);
					InitDataProperty(0, cnt++ , dtData,         80,  	daLeft,     true,	"sp_nm",        false,   "",      dfNone,          0,          false,       false,   10);
					
					InitDataProperty(0, cnt++ , dtData,         70,  	daLeft,     true,	"eg_nm",        false,   "",      dfNone,          0,          false,		false,   10);
					InitDataProperty(0, cnt++ , dtHidden,		50,  	daLeft,     true,   "sp_kpi_id",    false,   "",      dfNone,          0,          false,       false,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "sp_kpi_nm",    false,   "",      dfNone,          0,          false,       false,   10);
					InitDataProperty(0, cnt++ , dtHidden, 		100,  	daLeft,     true,   "sp_kpi_tp_cd",	false,   "",      dfNone,          0,          false,       false,   10);
					InitDataProperty(0, cnt++ , dtData, 		100,  	daLeft,     true,   "sp_kpi_tp_nm",	false,   "",      dfNone,          0,          false,       false,   10);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,	"kpi_tgt_rto",  false,   "",      dfNone,          0,          false,       false,   3);
					
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"jan_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"feb_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"mar_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"apr_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"may_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"jun_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"jul_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"aug_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"sep_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"oct_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"nov_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,   true,	"dec_rto",      false,   "",      dfFloat,          2,          true,       false,   5);
					
					InitDataProperty(0, cnt++ , dtData,		    80,  	daCenter,   true,  "kpi_wgt_rto",   false,   "",      dfInteger,        0,          false,      false,   3);
					InitDataProperty(0, cnt++ , dtData,  	    80,  	daCenter,   true,  "rslt_scre_rto",	false,   "",      dfFloat,          2,          false,      false,   5);
					
					InitDataProperty(0, cnt++ , dtHidden,	    80,  	daCenter,   true,  "ev_svc_cate_cd",false,   "",      dfNone,           0,          false,      false,   3);
					InitDataProperty(0, cnt++ , dtHidden,	    80,  	daCenter,   true,  "ev_svc_cate_nm",false,   "",      dfNone,           0,          false,      false,   3);
					InitDataProperty(0, cnt++ , dtHidden,	    80,  	daCenter,   true,  "has_saved",		false,   "",      dfNone,           0,          false,      false,   3);
					InitDataProperty(0, cnt++ , dtHidden,	    80,  	daCenter,   true,  "modifiy_yn",	false,   "",      dfNone,           0,          false,      false,   3);
			
				}
				break;
	    	
		 }//end of switch
	}//end of function
	 
    function obj_change(){
    	var obj = event.srcElement;
    	switch(obj.name) {
    		case "s_ev_yr":
				if(!ComChkObjValid(obj))obj.value="" ;
				sheetObjects[0].RemoveAll();
    			break;	
    		case "s_sp_seq":
				vender_change();
				sheetObjects[0].RemoveAll();
				break;
    	}
    }
    
	//SHEET 관련 프로세스 처리
	function doActionIBSheet(sheetObj, frm, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {		
			// SEARCH LOGIC
			case IBSEARCH:
				sheetObj.ShowDebugMsg = false;
				if(validateForm(sheetObj,frm,sAction)){
					sheetObjects[0].RemoveAll();
					frm.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(frm);
					var sXml = sheetObj.GetSearchXml("ESD_SPE_1012GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
				}
				hasSerched = true;
				break;
		
			// SAVE LOGIC
			case IBSAVE:
				if(!validateForm(sheetObj,frm,sAction)) return false;
				if (!ComShowCodeConfirm("SPE10015")) return; // Do you want to save {?msg1}?
				
            	frm.f_cmd.value = MULTI01;
				var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
		        var sXml = sheetObjects[0].GetSaveXml("ESD_SPE_1012GS.do", sParam);
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					ComShowCodeMessage('COM130103', 'Data');
					ComOpenWait(false);
					return false;
				} else if (State == "S") {
					ComShowCodeMessage('COM130102', 'Data');
					doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
				}
							
				break;
			case "IBSECRECYSAVE":
				frm.f_cmd.value = MULTI01;
				var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
				var sXml = sheetObjects[0].GetSaveXml("ESD_SPE_1012GS.do", sParam);

				
				break;
			case IBDOWNEXCEL :	// EXCEL DOWNLOAD
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
				break;
		}
	}


    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[1];
    	switch(comboObj.id) {
        case "s_eg_rhq_cd":  
	    	rhqXml = search03CommonCombo("CD03373",frm.s_eg_rhq_cd,sheetObj);
	    	comboObj.InsertItem(0, "", "");
	    	break;  
	    case "s_eg_ofc_cd":  
	    	frm.f_cmd.value = COMMAND02;    	
	    	var sXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
	    	frm.s_eg_ofc_cd.RemoveAll();
	    
	    	ComXml2ComboItem(sXml, frm.s_eg_ofc_cd, "eg_ofc_cd", "eg_ofc_cd");
//	    	frm.s_eg_ofc_cd.Index=0;
	    	comboObj.InsertItem(0, "", "");
	    	break;  
	  	case "s_ev_svc_cate_cd":  
	  		searchCommonCombo("CD03377",frm.s_ev_svc_cate_cd);
	  		comboObj.InsertItem(0, "", "");
			break;  	    	

        }
        sheetObj.WaitImageVisible = true;
    }
    
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,frm,sAction){
		switch(sAction) {
			case IBSEARCH :
				var evYr = frm.s_ev_yr.value;
				var spSeq = frm.s_sp_seq.value;
				
				if(evYr == ""){
					ComShowCodeMessage('COM130201', 'Year'); //년도 값을 입력하셔야 합니다
					return false;
				}
		 		 if(frm.s_eg_rhq_cd.Code  == ""){
		 			 ComShowCodeMessage('COM130201', 'Level 1'); //Level 1 값을 입력하셔야 합니다
		 			 return false;
		 		 }
		 		 if(frm.s_eg_ofc_cd.Code  == ""){
		 			 ComShowCodeMessage('COM130201', 'Level 2'); //Level 2 값을 입력하셔야 합니다
		 			 return false;
		 		 }
		 		 if(frm.s_ev_svc_cate_cd.Code  == ""){
		 			 ComShowCodeMessage('COM130201', 'Level 3'); //Level 3 값을 입력하셔야 합니다
		 			 return false;
		 		 }	 		 
				break;
			case IBSAVE :
				if(sheetObj.RowCount<1){
					ComShowCodeMessage('COM130201', 'Grid'); //Grid 값을 입력하셔야 합니다
					return false;
				}
				if(sheetObj.GetSaveString(false, true)==""){
					return false;
				}

				break;
			case IBDOWNEXCEL:
				//그리드 데이터 없을 경우
				if( sheetObj.RowCount < 1 ){
					return false;
				}
				break;
		} // end switch()
		return true;
	}	 

	/**
	* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	*/
	function vender_change(){
		// s/p 코드값이 변경되면 기존 저장값을 초기화 해야한다.
		if(frm.s_sp_seq.value =="" ){
			frm.s_sp_seq.value="";
			frm.s_sp_nm.value="";
			// DB 에 넘어갈 파라미터 정의
			frm.sp_seq.value="";
			return;
		}else {
			frm.f_cmd.value = COMMAND04;
			// DB 에 넘어갈 파라미터 정의
			frm.sp_seq.value=frm.s_sp_seq.value;
			var sXml=sheetObjects[0].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
			var vndrNm = SpeXmlString(sXml,"vndr_nm");
			if(vndrNm==0){
				ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
				frm.s_sp_seq.value="";
				frm.s_sp_nm.value="";
				// DB 에 넘어갈 파라미터 정의
				frm.sp_seq.value="";
				return;
			}else{
				frm.s_sp_nm.value = vndrNm;
			}
		}
	
	}
  
	/*
	* rep_commodity팝업호출
	*/
	function rep_OnPopupClick(callType) {
		var returnFun = "";
		if(callType == "grid"){
			returnFun = "getCOM_ENS_Rep_Gird";
		}else{
			returnFun = "getCOM_ENS_rep"
		}
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		
		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, returnFun, '1,0,1,1,1',true);
	}
	
	/**
	* S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
	*/
	function getCOM_ENS_rep(rowArray) {
		for(var i=0; i<rowArray.length; i++) 
		{
			var colArray = rowArray[0];
			var colArray2 = colArray[2];
			var colArray3 = colArray[3];
			var colArray4 = colArray[4];
			frm.s_sp_seq.value =colArray2;
			frm.s_sp_nm.value =colArray4;
			// DB 에 넘어갈 파라미터 정의
			frm.sp_seq.value =colArray2;
		}
	}	  
	/**
	 * S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
	 */
	function getCOM_ENS_Rep_Gird(rowArray) {
		var sheetObj = sheetObjects[0];
		for(var i=0; i<rowArray.length; i++) 
		{
			var colArray = rowArray[0];
			var colArray2 = colArray[2];
			var colArray3 = colArray[3];
			var colArray4 = colArray[4];
			sheetObj.CellValue2(sheetObj.SelectRow,"sp_seq") =colArray2;
			sheetObj.CellValue2(sheetObj.SelectRow,"sp_name") =colArray4;
		}
	}
	
	/**
	 * S/P별 정성평가 결과입력 Popup
	 * @param Row
	 * @param Col
	 */
	function ratio_OnPopupClick(sheetObj, Row, Col, evMon) {
		var egId = sheetObj.CellValue(Row,"eg_id");
		var evYr = sheetObj.CellValue(Row,"ev_yr");
		var spKpiId = sheetObj.CellValue(Row,"sp_kpi_id");
		var spSeq = sheetObj.CellValue(Row,"sp_seq");
		var spNm = sheetObj.CellValue(Row,"sp_nm");
		var evSvcCateCd = sheetObj.CellValue(Row,"ev_svc_cate_cd");
		var evSvcCateNm = sheetObj.CellValue(Row,"ev_svc_cate_nm");
//		var evMon = sheetObj.ColSaveName(Col);
//		evMon = evMon.substring(0,3);//앞 세자리만
		var score = sheetObj.CellValue(Row,"rslt_scre_rto");
		var param ="?EG_ID=" + egId;
		param += "&EV_YR=" + evYr;
		param += "&EV_MON=" + evMon;
		param += "&SP_KPI_ID=" + spKpiId;
		param += "&SP_SEQ=" + spSeq;
		param += "&SP_NM=" + spNm;
		param += "&EV_SVC_CATE_CD="+evSvcCateCd
		param += "&EV_SVC_CATE_NM="+evSvcCateNm;
		
		param += "&SCORE=" + score;
		ComOpenPopup('/hanjin/ESD_SPE_1017.do' + param, 980, 600, 'getESD_POPUP1017', '1,0,1,1,1',false, false, Row, Col, 0);
		
		
	}
	
	/**
	 * S/P별 정성평가 결과 callback 함수
	 * @param rowArray
	 */
//	function getESD_POPUP1017(rowArray, rtnVal){
	function getESD_POPUP1017(rowArray, rtnVal, sheetIdx,row,col){	
		var sheetObj = sheetObjects[sheetIdx];
//		for(var i=0; i<rowArray.length; i++){
//			var colArray = rowArray[0];
//			var colArray1 = colArray[1];//egId
//			var colArray2 = colArray[2];//evYr
//			var colArray3 = colArray[3];//spSeq
//			var colArray4 = colArray[4];//cateCd
//			var colArray5 = colArray[5];//score
//			sheetObj.CellValue2(sheetObj.SelectRow,"score") = colArray5;
//		}
		sheetObj.CellValue2(row,col) = rtnVal;
		calScore(sheetObj,row,col);
		
		
		doActionIBSheet(sheetObjects[0],document.form,"IBSECRECYSAVE");
	}
	
	function calScore(sheetObj,row,col){
		
		    var colScore = sheetObj.CellValue(row,col);
		
//		for( var idx = parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow-1; idx++ ){
			var totalScore = 0;
			var kpiTgtRto = sheetObj.CellValue(row,"kpi_tgt_rto");
			var kpiWgtRto = sheetObj.CellValue(row,"kpi_wgt_rto");
			

			var jan = sheetObj.CellValue(row,"jan_rto");
			var feb = sheetObj.CellValue(row,"feb_rto");
			var mar = sheetObj.CellValue(row,"mar_rto");
			var apr = sheetObj.CellValue(row,"apr_rto");
			var may = sheetObj.CellValue(row,"may_rto");
			var jun = sheetObj.CellValue(row,"jun_rto");
			var jul = sheetObj.CellValue(row,"jul_rto");
			var aug = sheetObj.CellValue(row,"aug_rto");
			var sep = sheetObj.CellValue(row,"sep_rto");
			var oct = sheetObj.CellValue(row,"oct_rto");
			var nov = sheetObj.CellValue(row,"nov_rto");
			var dec = sheetObj.CellValue(row,"dec_rto");
			
			var janScore = ((jan*kpiWgtRto)/(1*kpiTgtRto));
                if(janScore>kpiWgtRto){
                	janScore = kpiWgtRto;
                }
			var febScore = ((feb*kpiWgtRto)/(1*kpiTgtRto));
		        if(febScore>kpiWgtRto){
		        	febScore = kpiWgtRto;
		    	}
			var marScore = ((mar*kpiWgtRto)/(1*kpiTgtRto));
                if(marScore>kpiWgtRto){
                	marScore = kpiWgtRto;
                }
			var aprScore = ((apr*kpiWgtRto)/(1*kpiTgtRto));
                if(aprScore>kpiWgtRto){
                	aprScore = kpiWgtRto;
                }
			var mayScore = ((may*kpiWgtRto)/(1*kpiTgtRto));
                if(mayScore>kpiWgtRto){
                	mayScore = kpiWgtRto;
                }
			var junScore = ((jun*kpiWgtRto)/(1*kpiTgtRto));
                if(junScore>kpiWgtRto){
                	junScore = kpiWgtRto;
                }
			var julScore = ((jul*kpiWgtRto)/(1*kpiTgtRto));
                if(julScore>kpiWgtRto){
                	julScore = kpiWgtRto;
                }
			var augScore = ((aug*kpiWgtRto)/(1*kpiTgtRto));
                if(augScore>kpiWgtRto){
            	    augScore = kpiWgtRto;
                }
			var sepScore = ((sep*kpiWgtRto)/(1*kpiTgtRto));
                if(sepScore>kpiWgtRto){
                	sepScore = kpiWgtRto;
                }
			var octScore = ((oct*kpiWgtRto)/(1*kpiTgtRto));
                if(octScore>kpiWgtRto){
                	octScore = kpiWgtRto;
                }
			var novScore = ((nov*kpiWgtRto)/(1*kpiTgtRto));
                if(novScore>kpiWgtRto){
                	novScore = kpiWgtRto;
                }
			var decScore = ((dec*kpiWgtRto)/(1*kpiTgtRto));
                if(decScore>kpiWgtRto){
                	decScore = kpiWgtRto;
                }		
			
			var inMonth=0;
			if(jan>0)inMonth = inMonth + 1;
			if(feb>0)inMonth = inMonth + 1;
			if(mar>0)inMonth = inMonth + 1;
			if(apr>0)inMonth = inMonth + 1;
			if(may>0)inMonth = inMonth + 1;
			if(jun>0)inMonth = inMonth + 1;
			if(jul>0)inMonth = inMonth + 1;
			if(aug>0)inMonth = inMonth + 1;
			if(sep>0)inMonth = inMonth + 1;
			if(oct>0)inMonth = inMonth + 1;
			if(nov>0)inMonth = inMonth + 1;
			if(dec>0)inMonth = inMonth + 1;
		
			totalScore = Number(totalScore)
				 		+ Number(janScore)
				 		+ Number(febScore)
				 		+ Number(marScore)
				 		+ Number(aprScore)
				 		+ Number(mayScore)
				 		+ Number(junScore)
				 		+ Number(julScore)
				        + Number(augScore)
				        + Number(sepScore)
				        + Number(octScore)
				        + Number(novScore)
			            + Number(decScore);
			
			//공식 = target / (12달의 입력값의 합 /  12) * 비중
            //	   = (1/taget) * (totalScore/12) * 비중
			//     = (totalScore*비중)/12target
			var rsltScreRto = 0;
			
			if(totalScore == 0){
				rsltScreRto = 0;
			}else{
				rsltScreRto = totalScore / inMonth;
			}
//			else{			
//				rsltScreRto =  ((totalScore*kpiWgtRto)/(inMonth*kpiTgtRto));
//				if(rsltScreRto>kpiWgtRto){
//					rsltScreRto = kpiWgtRto;
//				}
//			}
			sheetObj.CellValue2(row,"rslt_scre_rto") = rsltScreRto;
//		}
		
	}
	
	function s_eg_rhq_cd_OnChange(comboObj,Index_Code, Text){   
		doActionIBCombo(frm.s_eg_ofc_cd); // RHQ
	}
	// cate cd가 바뀌면 조회를 먼저 해야한다.
	function s_ev_svc_cate_cd_OnChange(comboObj,Index_Code, Text){
		hasSerched = false;
		sheetObjects[0].RemoveAll();
		initSheet(sheetObjects[0],1);		
	}
		  
    /**
	* sheet1의 OnPopupClick Event 처리부분.<br>
	* @param sheetObj
	* @param Row
	* @param Col
	*/
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName = ColSaveName(Col);
			var evMon = "";
			switch(sName) {
				case "sp_code":		//Yard Code No Pop-up
					rep_OnPopupClick() 
					break;
				case "jan_rto":
					evMon = "01";
					break;
				case "feb_rto":
					evMon = "02";
					break;
				case "mar_rto":
					evMon = "03";
					break;
				case "apr_rto":
					evMon = "04";
					break;
				case "may_rto":
					evMon = "05";
					break;
				case "jun_rto":
					evMon = "06";
					break;
				case "jul_rto":
					evMon = "07";
					break;
				case "aug_rto":
					evMon = "08";
					break;
				case "sep_rto":
					evMon = "09";
					break;
				case "oct_rto":
					evMon = "10";
					break;
				case "nov_rto":
					evMon = "11";
					break;
				case "dec_rto":
					evMon = "12";
					break;
			}
			
			if( evMon != ""){
				ratio_OnPopupClick(sheetObj, Row, Col, evMon);

				// KeyPerf가 저장되어 있는 경우에만 POPUP. hasSaved == 'Y'일 때만 Popup호출
//				var hasSaved = sheetObj.CellValue(Row,"has_saved");
//				if( hasSaved == "Y"){
//					ratio_OnPopupClick(sheetObj, Row, Col, evMon);
//				}else{
//					//정성평가는 저장후에 변경이 가능합니다.
//					alert("저장을 한 뒤에 팝업창을 열 수 있습니다.");
//				}
			}
 		}
    }	  
   

    /**
     * sheet1 편집처리후 이벤트
     * @param {long} row 해당 셀의 Row Index
     * @param {long} col 해당 셀의 Column Index
     * @param {string} col 해당 셀의 value 
     * 
     */
    function sheet1_OnChange(sheetObj, row, col ,value) {
//    	if (col == sheetObj.SaveNameCol("sp_code")) {
//    	}
    	calScore(sheetObj, row, col);
    }
    
    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 이벤트
     */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		if(sheetObj.Rowcount==0){
			ComShowCodeMessage('SPE10002', 'EG ID'); //EG ID 가 존재하지 않습니다.
			return;
		}		
		sheetObj.ShowSum();
		if (sheetObj.RowCount("R") > 0) {
			sheetObj.SumText(0, "ev_yr") = "Total Score";
		}
		
		// CELL format변경
		var modifiyYn = "";
		for( var idx = parseInt(sheetObj.HeaderRows); idx <= sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
			
			var kpiTpCd = sheetObj.CellValue(idx,"sp_kpi_tp_cd");
			var kpiTgtRto = sheetObj.CellValue(idx,"kpi_tgt_rto");
			
			

				setCellProperty(sheetObj, idx, "jan_rto", kpiTpCd);
				setCellProperty(sheetObj, idx, "feb_rto", kpiTpCd);
				setCellProperty(sheetObj, idx, "mar_rto", kpiTpCd);
				setCellProperty(sheetObj, idx, "apr_rto", kpiTpCd);
				setCellProperty(sheetObj, idx, "may_rto", kpiTpCd);
				setCellProperty(sheetObj, idx, "jun_rto", kpiTpCd);
				setCellProperty(sheetObj, idx, "jul_rto", kpiTpCd);
				setCellProperty(sheetObj, idx, "aug_rto", kpiTpCd);
				setCellProperty(sheetObj, idx, "sep_rto", kpiTpCd);
				setCellProperty(sheetObj, idx, "oct_rto", kpiTpCd);
				setCellProperty(sheetObj, idx, "nov_rto", kpiTpCd);
				setCellProperty(sheetObj, idx, "dec_rto", kpiTpCd);
				
				modifiyYn = sheetObj.CellValue(idx,"modifiy_yn");
				if(modifiyYn=="N" || kpiTgtRto==""){
					// Performance 관리자로 등록되지 않아 수정할수 없다.
					sheetObj.RowEditable(idx) = false; 
				}
		}

		sheetObj.ShowSubSum("sp_seq", "rslt_scre_rto", -1, false, false,0, "kpi_wgt_rto=Total Score");		

	}
	
	// 셀 속성 변경
	function setCellProperty(sheetObj, rowIdx, colNm, compareData){
		if( compareData == "O" || compareData == "P"){
			// 한번 값을 입력하면 다시 수정할수 없다.
			if(sheetObj.CellValue(rowIdx, colNm)>0){
				sheetObj.CellEditable(rowIdx, colNm) = false;
				
			}
		}else if( compareData == "S"){
			sheetObj.CellEditable(rowIdx, colNm) = true;
			sheetObj.InitCellProperty (rowIdx, colNm, dtPopup, daCenter, colNm, "", dfFloat, 2, 3);
		}
//		else{
//			//sheetObj.InitCellProperty (rowIdx, colNm, dtData, daCenter, colNm, "", dfNone, 0, 3);
//			sheetObj.CellEditable(rowIdx, colNm) = false;
//		}
		//	sheetObj.CellEditable(rowIdx, colNm) = true;
		//	sheetObj.InitCellProperty (rowIdx, colNm, dtPopup, daCenter, colNm, "", dfFloat, 0, 3);
		
	}
	
	/* 개발자 작업  끝 */