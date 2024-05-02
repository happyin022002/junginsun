/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8002.js
*@FileTitle : Awkward & Break Bulk Cargo Quotation List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 1.0 Creation
=========================================================
* History
* 2013.06.26 이혜민 [CHM-201325215] Special cargo Quotation System 수정 요청 - Service Scope 조회 조건 및 결과Grid 상에 추가
* 2014.03.20 송호진 [CHM-201429287] POR, DEL 조회 조건 및 결과 리스트 항목 추가. POR, POL 지정시 Break Bulk 는 조회 되지 않도록 함
* 2014.09.11 송호진 [CHM-201431718] SCQ System 기능 추가 개발 요청 - Actual Customer란
* 2015.01.20 송호진 [CHM-201432778] SCQ AWK/BB Cargo application에서 Approval Office 선택에 대한 제한 설정
* 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
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
     * @class ESM_PRI_8002 : ESM_PRI_8002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_8002() {
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

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;    

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

        var sheetObj = sheetObjects[0];
//        var formObj = document.form;
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Calendar1":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObj.fmperiod, formObj.toperiod, 'yyyy-MM-dd');
                    break;

                case "btn_retrieve":
                	document.getElementById("akSheet").style.display = "none";
	     			document.getElementById("bbSheet").style.display = "none";
                    doActionIBSheet(sheetObj, formObj, IBSEARCH);
                    break;

                case "btn_new":
                    ComResetAll();
                    formObj.svc_scp_cd.text = "ALL";
                    break;
                
                case "btn_newapplication":
                	
        			if(ComShowConfirm(ComGetMsg("PRI09006", ""))) {                	   	                				                    
	                    var sUrl = "/hanjin/ESM_PRI_8003.do?";
	                    sUrl += "pop_mode=Y";
	                    ComPriOpenWindowCenter(sUrl, "", 1020, 682, true);
        			} else {
                    	var sUrl = "/hanjin/ESM_PRI_8005.do?";
                    	sUrl += "pop_mode=Y";
                    	ComPriOpenWindowCenter(sUrl, "", 1020, 682, true);
        			}
                	
                    break;    
                
                case "btn_download":
                	sheetObj.SpeedDown2Excel();
                    break;
                    
                case "btn_open":
					if (sheetObj.CellValue(sheetObj.SelectRow, 'tp_cd') == "AK") {
	                	if (validateForm(sheetObj, formObj)) {
	                    	var sUrl = "/hanjin/ESM_PRI_8003.do?";
			                    sUrl += "pop_mode=Y";
		                        sUrl += "&p_rqstno="+sheetObj.CellValue(sheetObj.SelectRow, 'scq_rqst_no');
		                        sUrl += "&p_verno="+sheetObj.CellValue(sheetObj.SelectRow, 'scq_ver_no');
		                    ComPriOpenWindowCenter(sUrl, "", 1020, 682, true);
	                    }
					} else if (sheetObj.CellValue(sheetObj.SelectRow, 'tp_cd') == "BB") {
	                	if (validateForm(sheetObj, formObj)) {
	                    	var sUrl = "/hanjin/ESM_PRI_8005.do?";
			                    sUrl += "pop_mode=Y";
		                        sUrl += "&p_rqstno="+sheetObj.CellValue(sheetObj.SelectRow, 'scq_rqst_no');
		                        sUrl += "&p_verno="+sheetObj.CellValue(sheetObj.SelectRow, 'scq_ver_no');
		                    ComPriOpenWindowCenter(sUrl, "", 1020, 705, true);
	                    }
					}
                    break;
                
                case "btn_por_cd": 
                case "btn_pol_cd": 
                case "btn_pod_cd":
                case "btn_del_cd":
                    var sUrl = "/hanjin/ESM_PRI_4026.do?";
                    sUrl += "group_cmd=" + PRI_SP_SCP;
                    sUrl += "&location_cmd=L";
                    var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 300, true);
                    if (rtnVal != null){
                        if(srcName == "btn_por_cd"){
                            form.por_cd.value = rtnVal.cd;
                        }else if(srcName == "btn_pol_cd"){
                            form.pol_cd.value = rtnVal.cd;
                        }else if(srcName == "btn_pod_cd"){
                            form.pod_cd.value = rtnVal.cd;
                        }else if(srcName == "btn_del_cd"){
                            form.del_cd.value = rtnVal.cd;
                        }
                    }

                    break;
				
				case "btn_apro_cd":
					var sUrl = "/hanjin/ESM_PRI_8104.do?";
                    var rtnVal = ComPriOpenWindowCenter(sUrl, "", 450, 520, true);
                    if ( rtnVal != null && rtnVal.length > 0 ) {
                    	formObj.apro_ofc_cd.value = rtnVal;
                    }
                    break;	
				
                case "btn_customer":
	                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_8105.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.cust_cnt_cd.value+"&cust_seq="+formObj.cust_seq.value, "", 640, 465, true);
	            	if (rtnVal != null){
	            		formObj.cust_cnt_cd.value = rtnVal.custCntCd;
	            		formObj.cust_seq.value = rtnVal.custSeq;	                    
	                }
	
	                break;
	                
                case "btn_cmdt_cd":
                	var sUrl = "/hanjin/ESM_PRI_8103.do?grp_cd="+ PRI_RG+"&commodity_cmd=CR";
            		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_8103", 600, 304, true);
	            	if (rtnVal != null){
	            		formObj.cmdt_cd.value = rtnVal.cd;	                    
	                }
	
	                break;                  
	            	
	            case "btn_ofc_hierarchy":
                	var sUrl = "/hanjin/ESM_PRI_8104.do?";
                    var rtnVal = ComPriOpenWindowCenter(sUrl, "", 450, 520, true);
                    if ( rtnVal != null && rtnVal.length > 0 ) {
                    	formObj.rqst_ofc_cd.value = rtnVal;
                    }
                    searchSrepCd();
                    break;		
	                
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
    
     /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBMulti Combo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */      
     function setComboObject(combo_obj){
         comboObjects[comboCnt++] = combo_obj;
     }
     
	/**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		
	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
	    
	    doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               

        ComPriTextCode2ComboItem(prcScqAproOfcCdValue, prcScqAproOfcCdText, getComboObject(comboObjects, 'apro_ofc_cd') ,"|","\t" );
       // 페이지 로딩시 focus
//        document.form.p_cntrno.focus();
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var len_unit = "";
        var wgt_unit = "";
        var meas_sys_cd = "";
        if ( sheetObjects.length > 0 && sheetObjects[0].RowCount > 0 && sheetObjects[0].SelectRow > 0 ) {
        	meas_sys_cd = sheetObjects[0].CellValue ( sheetObjects[0].SelectRow, "meas_sys_cd");
        }

        if ( meas_sys_cd == "M" || meas_sys_cd == "" ) {
        	len_unit = "cm";
        	wgt_unit = "kgs";
        } else if ( meas_sys_cd == "I") {
        	len_unit = "inch";
        	wgt_unit = "lbs";        	
        }

        switch(sheetNo) {
             case 1:      // list sheet
                with (sheetObj) {

                    // 높이 설정
                    style.height = 200;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle = "|Seq.|Request No.|Type|Ver No.|Status|Customer|A.Cust|Commodity|POR|POL|POD|DEL|SVC Scope|APRO OFC|Date|Requester|Request Date|Approver|Approve Date|meas_sys_cd";
					
					var headCount = ComCountHeadTitle(HeadTitle);
					
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
					
                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtHiddenStatus, 30,   daLeft,	     false,    "ibflag");
                    InitDataProperty(0, cnt++,    dtSeq,    	40,     daCenter,    true,     "seq",             false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	110,    daCenter,    true,     "scq_rqst_no",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	40,     daCenter,    true,     "tp_cd",           false,    "",    dfNone,    0,    true,    true);
                    
                    InitDataProperty(0, cnt++,    dtData,    	50,     daCenter,    true,     "scq_ver_no",      false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	120,    daCenter,    false,    "sts_cd",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	110,    daLeft,    	 false,    "cust_nm",         false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	110,    daLeft,    	 false,    "act_cust_nm",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	110,    daLeft,      false,    "cmdt_nm",         false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	60,     daCenter,    false,    "por_cd",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	60,     daCenter,    false,    "pol_cd",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	60,     daCenter,    false,    "pod_cd",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	60,     daCenter,    false,    "del_cd",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	70,     daCenter,    false,    "svc_scp_cd",      false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	70,     daCenter,    false,    "apro_ofc_cd",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	100,    daCenter,    false,    "prog_dt",     	  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	90,     daCenter,    false,    "rqst_usr_nm",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	100,    daCenter,    false,    "rqst_dt",         false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	90,     daCenter,    false,    "apro_usr_nm",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    	100,    daCenter,    false,    "apro_dt",     	  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,    	100,    daCenter,    false,    "meas_sys_cd",     false,    "",    dfNone,    0,    true,    true);
                    
                    //CountPosition = 0;
                }
                break;

             case 2:      // awkward detail sheet
                with (sheetObj) {

                    // 높이 설정
                    style.height = 180;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(18, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "No.|TPSZ|Q'ty|Commodity|Overall("+len_unit+")|Overall("+len_unit+")|Overall("+len_unit+")|Over Dimension("+len_unit+")|Over Dimension("+len_unit+")|Over Dimension("+len_unit+")|Over Dimension("+len_unit+")|Over Dimension("+len_unit+")|"
										+"Gross\nWeight\n("+wgt_unit+")|Void\n(Q'ty)\n(Q2/Q4)|Proposal Rate\n(USD)|Proposal Rate\n(USD)|Approval Rate\n(USD)|Approval Rate\n(USD)|";
					var HeadTitle2 = "No.|TPSZ|Q'ty|Commodity|L|W|H|FWD|AFT|Left|Right|Hight|"
										+"Gross\nWeight\n("+wgt_unit+")|Void\n(Q'ty)\n(Q2/Q4)|Basic\n(Per Box)|Void\n(Per Box)|Basic\n(Per Box)|Void\n(Per Box)|";
                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtSeq,     30,     daCenter,    true,     "no",                false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    true,     "cntr_tpsz_cd",      false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,     "cntr_qty",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    160,    daCenter,    true,     "cmdt_nm",           false,    "",    dfNone,    0,    true,    true);
                    
                    
                    if ( meas_sys_cd == "M" || meas_sys_cd == "" ) {
                        InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ttl_dim_len",       false,    "",    dfNone,    0,    true,    true);                    
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ttl_dim_wdt",       false,    "",    dfNone,    0,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ttl_dim_hgt",       false,    "",    dfNone,    0,    true,    true);
	                    
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ovr_fwrd_len",      false,    "",    dfNone,    0,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ovr_bkwd_len",      false,    "",    dfNone,    0,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ovr_lf_len",        false,    "",    dfNone,    0,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ovr_rt_len",        false,    "",    dfNone,    0,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ovr_hgt",           false,    "",    dfNone,    0,    true,    true);
	                    
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    true,     "grs_wgt",           false,    "",    dfNone,    0,    true,    true);
                    } else if ( meas_sys_cd == "I") {
                        InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ttl_dim_len",       false,    "",    dfNullFloat,    2,    true,    true);                    
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ttl_dim_wdt",       false,    "",    dfNullFloat,    2,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ttl_dim_hgt",       false,    "",    dfNullFloat,    2,    true,    true);
	                    
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ovr_fwrd_len",      false,    "",    dfNullFloat,    2,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ovr_bkwd_len",      false,    "",    dfNullFloat,    2,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ovr_lf_len",        false,    "",    dfNullFloat,    2,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ovr_rt_len",        false,    "",    dfNullFloat,    2,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "ovr_hgt",           false,    "",    dfNullFloat,    2,    true,    true);
	                    
	                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    true,     "grs_wgt",           false,    "",    dfNullFloat,    2,    true,    true);
                    }
                    
                    
                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    true,     "ovr_void_slt_qty",  false,    "",    dfNone,    0,    true,    true);

                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "prop_bsrt_amt",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "prop_void_rt_amt",  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    50,     daCenter,    false,    "apro_bsrt_amt",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    false,    "apro_void_rt_amt",  false,    "",    dfNone,    0,    true,    true);
                   
                    CountPosition = 0;
                    
                    WaitImageVisible = false;
                    SelectHighLight = false;
                    
                    RowHeight(0) = 28;
                    RowHeight(1) = 28;
                }
                break;
			case 3:      // breakbulk detail cargo sheet
                with (sheetObj) {

                    // 높이 설정
                    style.height = 180;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "No.|Cargo Dimension ("+len_unit+")|Cargo Dimension ("+len_unit+")|Cargo Dimension ("+len_unit+")|Gross Weight\n("+wgt_unit+")|";
					var HeadTitle2 = "No.|L|W|H|Gross Weight\n("+wgt_unit+")|";
					
                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;
					
                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtSeq,     30,     daCenter,    true,    "no",             false,    "",    dfNone,    0,    true,    true);
                    if ( meas_sys_cd == "M" || meas_sys_cd == "" ) {
	                    InitDataProperty(0, cnt++,    dtData,    85,     daCenter,    true,    "ttl_dim_len",    false,    "",    dfNone,    0,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    85,     daCenter,    true,    "ttl_dim_wdt",    false,    "",    dfNone,    0,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    85,     daCenter,    true,    "ttl_dim_hgt",    false,    "",    dfNone,    0,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    85,     daCenter,    true,    "grs_wgt",        false,    "",    dfNone,    0,    true,    true);
                    } else if ( meas_sys_cd == "I" ) {
	                    InitDataProperty(0, cnt++,    dtData,    85,     daCenter,    true,    "ttl_dim_len",    false,    "",    dfNullFloat,    2,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    85,     daCenter,    true,    "ttl_dim_wdt",    false,    "",    dfNullFloat,    2,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    85,     daCenter,    true,    "ttl_dim_hgt",    false,    "",    dfNullFloat,    2,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    85,     daCenter,    true,    "grs_wgt",        false,    "",    dfNullFloat,    2,    true,    true);
                    }
                                        
                    RowHeight(0) = 20;
                    RowHeight(1) = 20;
                    
                    CountPosition = 0;
                    SelectHighLight = false;
                    WaitImageVisible = false;
                }
                break; 
                
                case 4:      // breakbulk detail cntr sheet
                with (sheetObj) {

                    // 높이 설정
                    style.height = 180;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "No.|Container Type & Q'ty|Container Type & Q'ty|";
					var HeadTitle2 = "No.|Type|Q'ty|";
					
                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtSeq,     30,     daCenter,   true,    "no",             false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    true,     "cntr_tpsz_cd",  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    true,    "cntr_qty",       false,    "",    dfNone,    0,    true,    true);
                    
                    RowHeight(0) = 20;
                    RowHeight(1) = 20;
                    
                    CountPosition = 0;
                    SelectHighLight = false;
                    WaitImageVisible = false;
                }
                break;
                
                case 5:      // breakbulk detail sheet
                with (sheetObj) {

                    // 높이 설정
                    style.height = 180;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "Handling Cost (USD)|Handling Cost (USD)|Proposal\nRate (USD)|Approval\nRate (USD)|";
					var HeadTitle2 = "POL|POD|Proposal\nRate (USD)|Approval\nRate (USD)|";
					
                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;
                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtData,    85,     daCenter,   true,    "pol_sum",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    85,     daCenter,    true,     "pod_sum",         false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    true,    "prop_rt",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    true,    "apro_rt",          false,    "",    dfNone,    0,    true,    true);
                    
                    RowHeight(0) = 20;
                    RowHeight(1) = 20;
                    
                    CountPosition = 0;
                    SelectHighLight = false;
                    WaitImageVisible = false;
                }
                break;
        }
    }	

     /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     * @param {CellX} Long : 해당셀의 X좌표
     * @param {CellY} Long : 해당셀의 Y좌표
     * @param {CellW} Long : 해당셀의 가로 넓이값
     * @param {CellH} Long : 해당셀의 세로 높이값
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    	
    	var formObj = document.form;
        with (sheetObj) {
        	doActionIBSheet(sheetObjects[1], formObj, SEARCH02);
        }
    }
     
     /**
      * Sheet관련 프로세스 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @param {int} sAction 필수 프로세스 플래그 상수
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
     function doActionIBSheet(sheetObj, formObj, sAction) {
     	sheetObj.ShowDebugMsg = false;
     	switch (sAction) {
     	
     	case IBCLEAR:
    		// 온로딩시 sales rep combo 조회
    		formObj.f_cmd.value = SEARCH15;

    		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
    		ComPriXml2ComboItem(sXml, formObj.rqst_srep_cd, "cd", "cd|nm");
    		formObj.rqst_srep_cd.InsertItem(0,'ALL','');
    	   break;	
    		
     	case IBSEARCH_ASYNC01: // office 입력 후  srep combo LIST
     		 formObj.rqst_srep_cd.RemoveAll();
     		 formObj.f_cmd.value = SEARCH15;     		 
     		 formObj.etc1.value = formObj.rqst_ofc_cd.value;
     		 sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do",FormQueryString(formObj));
             ComPriXml2ComboItem(sXml, formObj.rqst_srep_cd, "cd", "cd|nm");
             formObj.rqst_srep_cd.InsertItem(0,'ALL','');
     		break;    
     		
     	case IBSEARCH_ASYNC02:
    		// 온로딩시 SVC Scope combo 조회
    		formObj.f_cmd.value = SEARCH01;

    		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
    		ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");
    		
    		formObj.svc_scp_cd.InsertItem(0,'ALL','');
    		formObj.svc_scp_cd.text = "ALL";
    	   break;
     		
     	case SEARCH02:
     		formObj.f_cmd.value = SEARCH02;
     		
     		var tpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tp_cd");
     		
			sParam="&scq_rqst_no=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "scq_rqst_no");
			sParam+="&scq_ver_no=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "scq_ver_no");
			sParam+="&tp_cd=" + tpCd;
			sParam+="&" + FormQueryString(formObj);

     		var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_8001GS.do", sParam);

//     		if (ComBkgErrMessage(sheetObj, sXml)) {     			
     			
	     		if(tpCd == "AK") {
	     			initSheet ( sheetObjects[1], 2);
	     			sheetObjects[1].LoadSearchXml(sXml);
	     			sheetObjects[2].RemoveAll();
	     			sheetObjects[3].RemoveAll();
	     			sheetObjects[4].RemoveAll();
	     			document.getElementById("akSheet").style.display = "inline";
	     			document.getElementById("bbSheet").style.display = "none";
	     			
	     		} else if(tpCd == "BB"){
	     			document.getElementById("akSheet").style.display = "none";
	     			var arrXml = sXml.split("|$$|");
	     			initSheet ( sheetObjects[2], 3);
	     			sheetObjects[2].LoadSearchXml(arrXml[0]);
	     			sheetObjects[3].LoadSearchXml(arrXml[1]);
	     			sheetObjects[4].LoadSearchXml(arrXml[2]);
	     			sheetObjects[1].RemoveAll();		
	     			document.getElementById("bbSheet").style.display = "inline";
	     		}
     		
//     		}
 			
     		break;
     		
     	case IBSEARCH:      //조회
     		formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_8001GS.do", FormQueryString(formObj));
 			sheetObjects[0].LoadSearchXml(sXml);
 			
 			break;
 		}
 	}


     
     /**
      * Office OnBlur 시 호출된다.<br>
      * rqst_ofc_cd 따른 rqst_srep_cd 콤보를 조회한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *     searchSrepCd()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
     function searchSrepCd(type) {
     	 if(type == undefined ){
     		 type="2";
     	 }
     	if(ComIsEmpty(document.form.rqst_ofc_cd)) {
     		document.form.rqst_srep_cd.Enable = false;
     	} else {
     		document.form.rqst_srep_cd.Enable = true;
     	}    	 
     	if( type != "1"){
      		if(ComIsEmpty(document.form.rqst_ofc_cd)) {
     			document.form.rqst_srep_cd.RemoveAll();
      		} else {
      			document.form.rqst_ofc_cd.value =  document.form.rqst_ofc_cd.value.toUpperCase();
      			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
      		}
     	}
     }
     
     /**
      * Onbeforedeactivate  event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_deactivate()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
     function obj_deactivate() {
         var formObj = document.form;
         var sheetObj = sheetObjects[0]; 
         var sheetObj1 = sheetObjects[0];    
         var eleName = event.srcElement.name;

         switch(eleName){
             case "rqst_ofc_cd":
             	searchSrepCd();
             	break;                
             default:
                 ComChkObjValid(event.srcElement);       
         }         
     }    
    
      /**
       * OnKeyPress event를 처리한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_keypress()
       * </pre>
       * @param 없음
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */     
     function obj_keypress() {
         switch (event.srcElement.dataformat) {
             case "ymd":
             	ComKeyOnlyNumber(event.srcElement, "-");
                 break;
             default:
         }
     }    
      /**
       * LoadFinish 이벤트 시 발생한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *     
       * </pre>
       * @param 없음
       * @return 없음
       * @author 이승준
       * @version 2009.04.17
       */
      function loadComboList() {
      	sheetObjects[1].WaitImageVisible = false; 
      	doActionIBSheet(sheetObjects[1], document.form, IBCLEAR);
      	document.form.rqst_srep_cd.RemoveAll();
      	document.form.rqst_srep_cd.Enable = false;
      	toggleButtons("");
      	document.form.qttn_no.focus();
         	sheetObjects[1].WaitImageVisible = true; 
      } 
      
      /**
       * srep combo 변경시 활성화됨<br>
       * <br><b>Example :</b>
       * <pre>
       * 		
       * </pre>
       * @param {comboObj} comboObj    필수,comboObj Object
       * @param {String} code    
       * @param {String} text 
       * @return 없음   
       * @author 이승준
       * @version 2009.06.10
       */ 
      function rqst_srep_cd_OnChange(comboObj, code, text) {
      	
      	if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
       			
      		var formObj = document.form;
      		 
      		var arrText = text.split("|");
      		
      		if (arrText[1] != null && arrText[1] != "undefined" && arrText[1].length > 1) {
      			
      			formObj.qttn_srep_nm.value = formObj.rqst_srep_cd.GetText(code,1);
      			
      			formObj.qttn_srep_nm.focus();
      		}else{
      			formObj.qttn_srep_nm.value = "";
      		}
      		
      	}	
      }
      
      /**
       * srep combo 초기화시 동작함<br>
       * <br><b>Example :</b>
       * <pre>
       * 		
       * </pre>
       * @param {comboObj} comboObj 
       * @return 없음   
       * @author 이승준
       * @version 2009.06.10
       */
      function rqst_srep_cd_OnClear(comboObj) {
      	var formObject = document.form;
      	formObject.qttn_srep_nm.value = "";
      	
      	comboObj.Index2 = -1;
      }
      
      /**
       * srep combo 포커스 아웃시 동작함<br>
       * <br><b>Example :</b>
       * <pre>
       * 		
       * </pre>
       * @param {comboObj} comboObj 
       * @return 없음   
       * @author 이승준
       * @version 2009.06.10
       */
      function rqst_srep_cd_OnBlur(comboObj) {
      	
      	var formObj = document.form;
      		
      	var code = comboObj.FindIndex(comboObj.Code, 0);

      	if (code != null && code != "") {
      		
      		var text = comboObj.GetText(code, 1);
      		
      		if (text != null && text != "" && text != formObj.qttn_srep_nm.value) {
      			
      			formObj.qttn_srep_nm.value = comboObj.GetText(code, 1);
      			
      			formObj.qttn_srep_nm.focus();
      		}
      	}
      }
      
      /**
       * IBSHEET COMBO를 LOAD하는 함수<br>
       * <br><b>Example :</b>
       * <pre>
       * 		initCombo(comboObj, comboNo)
       * </pre>
       * @return 없음
       * @author 이승준
       * @version 2009.06.10
       */ 
      function initCombo(comboObj, comboNo) {
          switch(comboObj.id) {
              
              case "rqst_srep_cd":
                  with(comboObj) {
                  	DropHeight = 260;
                  	MultiSelect = false;
                  	MaxSelect = 1;
                  	UseAutoComplete = true;
                  	ValidChar(2, 1);
                      MaxLength = 5;      // 5자리만 입력
                  	
                  	SetColWidth("80|100|0");
                  }
                  break;
                  
              case "svc_scp_cd":
              	var i=0;
                  with(comboObj) {
                      DropHeight = 200;
                      MultiSelect = false;
                      MaxSelect = 1;
                      IMEMode = 0;
                      UseAutoComplete = true;
                      ValidChar(1, 1);
                      MaxLength = 5;
                      SetColWidth("70|0");
                  }
                  break;    
              case "apro_ofc_cd":
                	var i=0;
                    with(comboObj) {
                        DropHeight = 200;
                        MultiSelect = false;
                        MaxSelect = 1;
                        IMEMode = 0;
                        UseAutoComplete = true;
                        ValidChar(1, 1);
                        MaxLength = 6;
                        SetColWidth("70|0");
                        
                    }
                    break;    
          }
       }
       
      /**
       * 화면 폼입력값에 대한 유효성검증 프로세스 처리
       * @param(ibsheet) 	sheetObj 		IBSheet Object
       * @param(formObj) 	form			form object
       * @param(string) 	sAction			action 값  
       */
      function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){

          }
          return true;
      }   
      
	/* 개발자 작업  끝 */