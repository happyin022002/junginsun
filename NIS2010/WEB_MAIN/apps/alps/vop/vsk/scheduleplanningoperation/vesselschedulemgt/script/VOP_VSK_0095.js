/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VOP_VSK_0095.js
*@FileTitle : VVD SKD Interface To ERP
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.12.10 김상수
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
     * @class VOP_VSK_0095 : VOP_VSK_0095 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0095() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.initControl        = initControl;
        this.doActionIBSheet    = doActionIBSheet;
        this.setTabObject       = setTabObject;
        this.validateForm       = validateForm;
    }

/* 개발자 작업 */


    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj = sheetObjects[0];
        var frmObj = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {
                case "btn_lane_popup":    // (Popup) Lane Code
                    // ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, bModal, sScroll)
                    ComOpenPopupWithTarget("VOP_VSK_0202.do.do", 428, 470, "sheet1_vsl_slan_cd:vsl_slan_cd", "0,0", true, false);
                    break;

                case "btn_vvd_popup":    // (Popup) VVD
                    var vslCd = frmObj.vsl_cd.value;
                    if (vslCd == "") {
                        // ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, bModal, sScroll)
                        ComOpenPopupWithTarget("VOP_VSK_0219.do?inc_del_vsl_pop=Y", 460, 500, "vsl_cd:vsl_cd", "0,0", true, false);
                    } else {
                        // ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, bModal, sScroll)
                        ComOpenPopupWithTarget("VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd=" + vslCd, 340, 420, "skd_voy_no:skd_voy_no|skd_dir_cd:skd_dir_cd", "0,0",  true, false);
                    }
                    break;

                case "btn_calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    }
                    break;
                    
                case "btn_calendar2":
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.first_port_etb_fm, frmObj.first_port_etb_to, "yyyy-MM-dd");
                    }
                    break;                    

                case "btn_retrieve":    // Retrieve
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;

                case "btn_new":    		// New
                    ComResetAll();
                    break;

                case "btn_erp":    		// I/F to ERP
                    doActionIBSheet(shtObj, frmObj, IBCREATE);
                    break;

                case "btn_downexcel":   // Down Excel
                    ComOpenWait(true);
                    shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "chk|ibflag");
                    ComOpenWait(false);
                    break;
                    
                case "rdo_vvd":
                	//alert(document.form.rdo_vvd[0].checked);
                	fnGridControl();

            } // end switch

//        } catch(e) {
//            if (e == "[object Error]") {
//                ComShowMessage(OBJECT_ERROR);
//            } else {
//                ComShowMessage(e);
//            }
//        }
    }

    /**
     * grid control function
     */
    function fnGridControl(){
    	 
    	 //alert('fnGridControl');
    	 
    	 var frmObj	= document.form;
    	 sheetObjects[0].RemoveAll();
    	 
        /***** 2013.06.17 Live, Deleted Radio Button 추가 *****/
        if(frmObj.rdo_vvd[0].checked == true){			//Live
        
        	frmObj.vvd_deleted_yn.value		= "N";
        
    		//frmObj.date_fm.value			= frmObj.init_date_fm.value;
    		//frmObj.date_to.value			= frmObj.init_date_to.value; 
			frmObj.date_fm.value			= "";
			frmObj.date_to.value			= "";        
    		frmObj.first_port_etb_fm.value	= "";
    		frmObj.first_port_etb_to.value	= "";     		
    		
    		frmObj.date_fm.className 			= "input1";
    		frmObj.date_to.className 			= "input1";
    		frmObj.first_port_etb_fm.className 	= "input";
    		frmObj.first_port_etb_to.className 	= "input";    		
        
	        sheetObjects[0].ColHidden("vps_eta_dt") = false;
	        sheetObjects[0].ColHidden("vps_etb_dt") = false;
	        sheetObjects[0].ColHidden("vps_etd_dt") = false;   
	        sheetObjects[0].ColHidden("upd_dt") 	= false;
	        
	        sheetObjects[0].ColHidden("delt_dt") 	= true;
	        
	        /////////////// COL. WIDTH /////////////////////	
	        sheetObjects[0].ColWidth("vvd")			= 80;
	        sheetObjects[0].ColWidth("vps_port_cd")	= 70;
	        sheetObjects[0].ColWidth("cre_dt")		= 105;
	        sheetObjects[0].ColWidth("delt_dt")		= 105;
	        sheetObjects[0].ColWidth("if_dt")		= 105;
	    	
        }else if(frmObj.rdo_vvd[1].checked == true){	//Deleted
        	
        	frmObj.vvd_deleted_yn.value		= "Y";
        
        	frmObj.date_fm.value			= "";
        	frmObj.date_to.value			= "";
    		frmObj.first_port_etb_fm.value	= "";
    		frmObj.first_port_etb_to.value	= "";          	
    		//frmObj.first_port_etb_fm.value	= frmObj.init_date_fm.value;
    		//frmObj.first_port_etb_to.value	= frmObj.init_date_to.value; 
        	
        	frmObj.date_fm.className 			= "input";
        	frmObj.date_to.className 			= "input";    
    		frmObj.first_port_etb_fm.className 	= "input1";
    		frmObj.first_port_etb_to.className 	= "input1";         	

        	sheetObjects[0].ColHidden("vps_eta_dt") = true;
	        sheetObjects[0].ColHidden("vps_etb_dt") = true;
	        sheetObjects[0].ColHidden("vps_etd_dt") = true; 
	        sheetObjects[0].ColHidden("upd_dt") 	= true;
	        
	        sheetObjects[0].ColHidden("delt_dt") 	= false;
	        
	        /////////////// COL. WIDTH /////////////////////	
	        sheetObjects[0].ColWidth("vvd")			= 150;
	        sheetObjects[0].ColWidth("vps_port_cd")	= 150;
	        sheetObjects[0].ColWidth("cre_dt")		= 150;
	        sheetObjects[0].ColWidth("delt_dt")		= 150;
	        sheetObjects[0].ColWidth("if_dt")		= 150;
	        
        }else{
        	frmObj.vvd_deleted_yn.value	= "";
        }
        /*****************************************************/ 
        

    	
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(shtObj) {
       sheetObjects[sheetCnt++] = shtObj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        initControl();
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        var cnt = 0;
        		
        with (shtObj) {

            // 높이 설정
            style.height = GetSheetHeight(20);

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
            InitRowInfo(1, 1, 13, 500);
            document.form.pagerows.value = 500;

            // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
            InitHeadMode(true, false, true, true, false, false);

            // 컬럼 헤더타이틀
            var HeadTitle  = "|Sel|No.|Del.VVD|DIR|LANE|VVD|Creation Date|Start Port|ETA|ETB|ETD|Update Date|Delete Date|I/F Date||";

            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";


            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag"		);    // [필수]
            InitDataProperty(0, cnt++, dtDummyCheck,   40,     daCenter,    false,    "chk"			);
            InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    false,    "seq"			);

            InitDataProperty(0, cnt++, dtHidden,         40,     daCenter,    false,    "deleted_vvd_yn",     false,     "",    dfNone,    0,    false,     false);
            
            InitDataProperty(0, cnt++, dtData,         40,     daCenter,    false,    "skd_dir_cd",     false,     "",    dfNone,    0,    false,     false);
            InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "vsl_slan_cd",    false,     "",    dfNone,    0,    false,     false);
            InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "vvd"			);
            InitDataProperty(0, cnt++, dtData,         105,    daCenter,    false,    "cre_dt"		);
            InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,    "vps_port_cd",    false,     "",    dfNone,    0,    false,     false);
            InitDataProperty(0, cnt++, dtData,         110,    daCenter,    false,    "vps_eta_dt",     false,     "",    dfNone,    0,    false,     false);
            InitDataProperty(0, cnt++, dtData,         110,    daCenter,    false,    "vps_etb_dt",     false,     "",    dfNone,    0,    false,     false);
            InitDataProperty(0, cnt++, dtData,         110,    daCenter,    false,    "vps_etd_dt",     false,     "",    dfNone,    0,    false,     false);
            InitDataProperty(0, cnt++, dtData,         105,    daCenter,    false,    "upd_dt",         false,     "",    dfNone,    0,    false,     false);
            InitDataProperty(0, cnt++, dtHidden,       105,    daCenter,    false,    "delt_dt",         false,     "",    dfNone,    0,    false,     false);
            
            InitDataProperty(0, cnt++, dtData,         105,    daCenter,    false,    "if_dt",          false,     "",    dfNone,    0,    false,     false);
            // Hidden
            InitDataProperty(0, cnt++, dtHidden,       50,     daCenter,    false,    "vsl_cd"		);
            InitDataProperty(0, cnt++, dtHidden,       50,     daCenter,    false,    "skd_voy_no"	);


            // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
            EditableColorDiff = false;

            WaitImageVisible = false;
        }        		
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 입력시 이벤트
        ////::jsk:2013-06-26:abnornal operated:://axon_event.addListenerForm	("beforedeactivate"	, "frmObj_OnBeforeDeactivate"	, document.form		);
        ////::jsk:2013-06-26:abnornal operated:://axon_event.addListenerFormat("beforeactivate"	, "frmObj_OnBeforeActivate"		, document.form		);
        axon_event.addListenerFormat("keypress"			, "frmObj_OnKeyPress"			, document.form		);

        // OnKeyUp 이벤트
        axon_event.addListener		("keyup"			, "frmObj_OnKeyUp"				, "vsl_cd"			); 
        axon_event.addListener		("keyup"			, "frmObj_OnKeyUp"				, "skd_dir_cd"		);
        axon_event.addListener		("keyup"			, "frmObj_OnKeyUp"				, "skd_voy_no"		); 
        
        // OnChange 이벤트
        axon_event.addListener		("change"			, "frmObj_OnChange"				, "skd_dir_combo"	);
        
        axon_event.addListenerForm	('blur'				, 'obj_blur'					, document.form		);
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:
                if (!validateForm(shtObj, frmObj, sAction)) return;
                
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                
                //shtObj.showDebugMsg = true;
                shtObj.DoSearch("VOP_VSK_0095GS.do", FormQueryString(frmObj));
                //shtObj.showDebugMsg = false;
                
                ComOpenWait(false);
                break;

            case IBCREATE:
                if (shtObj.CheckedRows("chk") < 1){
                    ComShowCodeMessage("COM12189");    // Nothing selected
                    return;
                } else {
                    if (ComShowCodeConfirm("COM130602", "I/F", "ERP")) {    // Do you want to transmit {?msg1} to {?msg2}?
                        ComOpenWait(true);
                        frmObj.f_cmd.value = MULTI;
                        shtObj.DoSave("VOP_VSK_0095GS.do", FormQueryString(frmObj), "chk", false);
                        ComOpenWait(false);
                    }
                }

                break;
        }
    }


    /**
     * Form Element의  OnBeforeDeactivate 이벤트
     * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeDeactivate 이벤트에 코드 처리
     */
    function frmObj_OnBeforeDeactivate() {
        ComChkObjValid(window.event.srcElement);
    }


    /**
     * Form Element의 OnBeforeActivate 이벤트
     * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate 이벤트에 코드 처리
     */
    function frmObj_OnBeforeActivate() {
        ComClearSeparator(window.event.srcElement);
    }


    /**
     * Form Element의 OnKeyPress 이벤트
     * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyPress 이벤트에 코드 처리
     */
    function frmObj_OnKeyPress() {
        var obj = window.event.srcElement;
        if (obj.dataformat == null) return;
        
        switch (obj.dataformat) {
            case "ymd":
            case "ym":
            case "hms":
            case "hm":
                ComKeyOnlyNumber(obj);
                break;
            case "int":
                ComKeyOnlyNumber(obj, "-");
                break;
            case "float":
                ComKeyOnlyNumber(obj, "-.");
                break;
            case "eng":
                ComKeyOnlyAlphabet("num", "32|64|~");
                break;
            case "engup":
                ComKeyOnlyAlphabet("uppernum");
                break;
            case "engdn":
                ComKeyOnlyAlphabet("lowernum");
                break;
        }
    }


    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnKeyUp() {
        var elementName = window.event.srcElement.getAttribute("name");
        
        with (document.form) {
            switch (elementName) {
     			case "vsl_cd":
     				if(vsl_cd.value != "" && skd_dir_cd.value != "" && skd_voy_no.value != "" && vsl_cd.value != null && skd_dir_cd.value != null && skd_voy_no.value != null){
     					date_fm.value	= "";
     					date_to.value	= "";
     				}    
     				if(vsl_cd.value.length 		== 4)	skd_voy_no.focus();
     				break;
     				
         		case "skd_voy_no":
         			if(vsl_cd.value != "" && skd_dir_cd.value != "" && skd_voy_no.value != "" && vsl_cd.value != null && skd_dir_cd.value != null && skd_voy_no.value != null){
         				date_fm.value	= "";
         				date_to.value	= "";
         			}  
         			if(skd_voy_no.value.length 	== 4)	skd_dir_cd.focus();
         			break;
         			
     			case "skd_dir_cd":
                    if (skd_dir_cd.value != "") {
                        skd_dir_combo.value = "";
                    }
         			if(vsl_cd.value != "" && skd_dir_cd.value != "" && skd_voy_no.value != "" && vsl_cd.value != null && skd_dir_cd.value != null && skd_voy_no.value != null){
         				date_fm.value	= "";
         				date_to.value	= "";
         			}  
         			if(skd_dir_cd.value.length 	== 1)	date_fm.focus();                    
                    break;
                    

            }
        }
    }


	function obj_blur(){
		var srcName = event.srcElement.name;
		var frmObj	= document.form;
		
		switch(srcName){
			case "date_fm":
				if(!ComIsDate(frmObj.date_fm.value))
				{
					frmObj.date_fm.value	= "";
					return false;
				}
				frmObj.date_fm.value		= ComGetMaskedValue(frmObj.date_fm.value, "ymd");				
				break;
				
			case "date_to":
				if(!ComIsDate(frmObj.date_to.value))
				{
					frmObj.date_to.value	= "";
					return false;
				}
				frmObj.date_to.value		= ComGetMaskedValue(frmObj.date_to.value, "ymd");				
				break;
				
			case "first_port_etb_fm":
				if(!ComIsDate(frmObj.first_port_etb_fm.value))
				{
					frmObj.first_port_etb_fm.value	= "";
					return false;
				}
				frmObj.first_port_etb_fm.value		= ComGetMaskedValue(frmObj.first_port_etb_fm.value, "ymd");				
				break;
				
			case "first_port_etb_to":
				if(!ComIsDate(frmObj.first_port_etb_to.value))
				{
					frmObj.first_port_etb_to.value	= "";
					return false;
				}
				frmObj.first_port_etb_to.value		= ComGetMaskedValue(frmObj.first_port_etb_to.value, "ymd");				
				break;				

				
		}
	}     
     
     
    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        with (document.form) {
            switch (elementName) {

                case "skd_dir_combo":
                    if (skd_dir_combo.value != "") {
                        skd_dir_cd.value = "";
                    }
                    break;
            }
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(shtObj, frmObj, sAction) {
    	 
    	var vvdDeletedYn	= frmObj.vvd_deleted_yn.value;
    	var frmObj			= document.form;
    	 
        with (frmObj) {
            switch (sAction) {

                case IBSEARCH:

            		///////////////////////////////////////////////////////////////////////
            		if(frmObj.date_fm.value != "" && frmObj.date_to.value != "")
            		{
        				// fm_dt to_dt보다 앞선일자가 아니면 오류
        				if(!checkPeriod(date_fm, date_to)){
        					ComShowCodeMessage("VSK00025", "End date", "start date");
        					return false;
        				}
            		}
            		
            		if(first_port_etb_fm.value != "" && first_port_etb_to.value != "")
            		{
        				// fm_dt to_dt보다 앞선일자가 아니면 오류
        				if(!checkPeriod(first_port_etb_fm, first_port_etb_to)){
        					ComShowCodeMessage("VSK00025", "End date", "start date");
        					return false;
        				}
            		}    
            		///////////////////////////////////////////////////////////////////////                	
                	
                	if(vvdDeletedYn == "N"){
                		
                    	if (vsl_cd.value != "" && skd_voy_no.value != "" && skd_dir_cd.value != "" && vsl_cd.value != null && skd_voy_no.value != null && skd_dir_cd.value != null) {
                    		return true;
                		} else if (vsl_slan_cd.value == "" && vsl_cd.value == "" && skd_voy_no.value == "" && skd_dir_cd.value == "") {
                            if (date_fm.value == "" && date_to.value == "") {
                                ComShowCodeMessage("VSK00027", "Lane Code) or (VVD) or (Creation Date");    // {?msg1}) Mandatory field is missing. Please try again.
                                return false;
                            }else{ 
                            	if (ComGetDaysBetween(frmObj.date_fm.value, frmObj.date_to.value) > 7) {
                            		// Lane Code나 VVD에 값이 없을 경우는 7일로 기간 제한
                            		ComShowCodeMessage("COM12133", "The start and end date", "8 days", "less");    // {?msg1} must be {?msg3} than {?msg2}.
                            		return false;
                            	}
                            }
                		} else if(vsl_slan_cd.value != "" && ((vsl_cd.value == "" && skd_voy_no.value == "" && skd_dir_cd.value == "") && (date_fm.value == "" || date_to.value == "")) ){
                    		ComShowCodeMessage("VSK00027", "VVD or Creation Date");
                			return false;                			
                        } else {
                        	
                        	if(date_fm.value == "" || date_fm.value == null || date_to.value == "" || date_to.value == null){
                        		ComShowCodeMessage("VSK00027", "Creation Date");
                        		return false;
                        	}
                        	
                            if (ComGetDaysBetween(frmObj.date_to.value, ComGetDateAdd(frmObj.date_fm.value, "M", 1)) < 0) {
                                // Lane Code나 VVD에 값이 있을 경우는 1달로 기간 제한
                                ComShowCodeMessage("COM12133", "The start and end date", "1 Month", "less");    // {?msg1} must be {?msg3} than {?msg2}.
                                return false;
                            }
                        }
                        break;                		
                		
                		
                	}else if(vvdDeletedYn == "Y"){
                		
                    	/////////////////////////////////////////////////////////////////////////////

                		if(vsl_cd.value == "" && vsl_slan_cd.value == ""){
                			ComShowCodeMessage("VSK00027", "Lane Code) or (Vessel Code");    // {?msg1}) Mandatory field is missing. Please try again.
                			return false;
                		}
                		
                		///////////////////////////////////////////////////////////////////////////// 
                	}
                	
            }
        }
        return true;
    }

 	function checkPeriod(fromDate, toDate){
		var fmDt = ComReplaceStr(fromDate.value, "-", "");
		var toDt = ComReplaceStr(toDate.value, "-", "");
		if(ComChkPeriod(fmDt, toDt) < 1){
			return false;
		}else{
			return true;
		}
	}     

    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }


/* 개발자 작업 끝 */
