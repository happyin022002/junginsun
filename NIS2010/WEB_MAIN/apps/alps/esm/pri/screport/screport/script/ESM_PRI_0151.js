/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_0151.js
*@FileTitle : Korea MOF Filing (Formatted)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
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
     * @class ESM_PRI_0151 : ESM_PRI_0151 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0151() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 			= setSheetObject;
    	this.loadPage 					= loadPage;
    	this.initSheet 					= initSheet;
    	this.initCombo 				= initCombo;
    	this.obj_keypress				= obj_keypress;
    	this.initControl					= initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/
    //  ===================================================================================
    //  전역변수
    //  ===================================================================================
    //  공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sheet1;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    //  업무전역변수
    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
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
     * @author 
     * @version 2016.05.25
     */ 
    function loadPage() {
        var form = document.form;	
        sheet1 = sheetObjects[0];
        sheetCnt = sheetObjects.length;
        
        //IBSheet 초기화
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
        }
        
        //IBMultiCombo 초기화
        comboCnt = comboObjects.length;
        for(var k=0;k<comboCnt;k++) {
            initCombo(comboObjects[k],k+1);
        }
        
        axon_event.addListenerForm('click', 'obj_click', document.form);
	   	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	   	axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
	   	axon_event.addListenerFormat('keydown', 'obj_keydown', document.form);
		 
		// 당일 날짜로 default setting
		gCurrDate = ComGetDateAdd(null, "D", 0);
		form.f_eff_dt.value = gCurrDate;
	    form.f_exp_dt.value = gCurrDate;
	    
	    form.f_ctrt_tp.text = 'S/C,RFA(B/A/C)';
	    form.prop_ofc_cd_multi.text = 'SELSC,PUSSC,PUSBS';
	    sheet1.WaitImageVisible = false;
    }
   
    /**
     * IBMultiCombo 기본 설정 및 초기화 <br>
     */
    function initCombo(comboObj, comboNo) {
        switch (comboObj.id) {
	        case "f_ctrt_tp":
				with(comboObj) {
					MultiSelect = true;
					UseAutoComplete = true;
					SetColAlign("left");
					SetColWidth("230");
					DropHeight = 200;
					
//	            	InsertItem(0, "" , "");
					InsertItem(0, "S/C" , "S");
					InsertItem(1, "RFA(B/A/C)" , "R");
	            }
				break;
	            
			case "prop_ofc_cd_multi":
				with(comboObj) {
					MultiSelect = true;
					UseAutoComplete = true;
					SetColAlign("left");
					SetColWidth("230");
					DropHeight = 200;
					
					InsertItem(0, "SELSC" , "SELSC");
					InsertItem(1, "PUSSC" , "PUSSC");
					InsertItem(2, "PUSBS" , "PUSBS");
    			}
				break;
				
            case "prop_srep_cd_multi":
				with(comboObj) {
					DropHeight = 200;
					MultiSelect = true;
					UseAutoComplete = true;
				}
				
				break; 
        }
    }
    
	/**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * prop_ofc_cd 콤보에서 값을 변경하면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} value 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 김재연
     * @version 2009.06.04
     */
	function prop_ofc_cd_multi_OnChange(comboObj, value, text) {
		var formObj = document.form;
		
		formObj.f_cmd.value = SEARCH34;
		var sParam = FormQueryString(formObj);
		
		if(value != null) {
			var ofc_cd_arr = value.split(",");
			formObj.prop_ofc_cd.value = "'"+(ComReplaceStr(ofc_cd_arr.toString(), ",", "', '"))+"'";
		}
		sParam += "&etc1=" + formObj.prop_ofc_cd.value;
		
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", sParam);
		ComPriXml2ComboItem(sXml, formObj.prop_srep_cd_multi, "cd", "cd|nm");
		
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
     * @version 2009.08.12
     */ 
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    //높이 설정
                    style.height = 395;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    
                    // Header Title
                    var HeadTitle1 = "Seq.|계약번호|계약상대자|항로|수출입|적하항|양하항|컨테이너\n종류|컨테이너\n규격|물량\n(TEU)|O/F|BAF|BAF|CAF|CAF|O/THC|O/THC|D/THC|D/THC|기타부대운임|기타부대운임|기타부대운임|계약발효일|계약종료일|비고|AMD\nNo.|Bullet|EFF Date|SML Scope| APVL OFC|R.OFC";
                    var HeadTitle2 = "Seq.|계약번호|계약상대자|항로|수출입|적하항|양하항|컨테이너\n종류|컨테이너\n규격|물량\n(TEU)|금액(USD)|화폐|금액|화폐|금액|화폐|금액|화폐|금액|화폐|금액|설명|계약발효일|계약종료일|비고|AMD\nNo.|Bullet|EFF Date|SML Scope| APVL OFC|R.OFC";
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle2), 0, 0, false);
                    
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
//                  데이터속성       ROW , COL   ,DATATYPE   ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME	,KEYFIELD,CALCULOGIC,DATAFORMAT    ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0,		cnt++,	dtSeq,			40,	daCenter,		true,	"seq");
                    InitDataProperty(0,		cnt++,  dtData,			80,	daCenter,		true,	"ctrt_no",						false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			90,	daCenter,		true,	"cust_nm",					false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			40,	daCenter,		true,	"mof_lane_cd",				false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			50,	daCenter,		true,	"in_out",						false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			60,	daCenter,		true,	"mof_org_loc_cd",		false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			60,	daCenter,		true,	"mof_dest_loc_cd",		false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			65,	daCenter,		true,	"type_cd",						false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			65,	daCenter,		true,	"size_cd",						false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			45,	daCenter,		true,	"qty",							false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			80,	daRight,		false,	"oft_amt",					false,	"",	dfNullFloat,	2,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			40,	daCenter,		false,	"baf_curr",					false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			60,	daRight,		false,	"baf_amt",					false,	"",	dfNullFloat,	2,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			40,	daCenter,		false,	"caf_curr",					false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			60,	daRight,		false,	"caf_amt",					false,	"",	dfNullFloat,	2,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			40,	daCenter,		false,	"oth_curr",					false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			60,	daRight,		false,	"oth_amt",					false,	"",	dfNullFloat,	2,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			40,	daCenter,		false,	"dth_curr",					false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			60,	daRight,		false,	"dth_amt",					false,	"",	dfNullFloat,	2,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			40,	daCenter,		false,	"etc_curr",					false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			60,	daRight,		false,	"etc_amt",					false,	"",	dfNullFloat,	2,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			60,	daRight,		false,	"etc_cmnt",					false,	"",	dfNullFloat,	2,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			90,	daCenter,		true,	"eff_dt",				false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			90,	daCenter,		true,	"ctrt_exp_dt",				false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtData,			80,	daCenter,		true,	"cmnt",							false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtHidden,		40,	daCenter,		true,	"amdt_seq",					false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtHidden,		40,	daCenter,		true,	"blet_dp_seq",				false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtHidden,		80,	daCenter,		true,	"eff_dt",						false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtHidden,		80,	daCenter,		true,	"svc_scp_cd",				false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtHidden,		80,	daCenter,		true,	"prop_apro_ofc_cd",		false,	"",	dfNone,		0,	false,	false );
                    InitDataProperty(0,		cnt++,  dtHidden,		60,	daCenter,		true,	"prop_ofc_cd",				false,	"",	dfNone,		0,	false,	false );
//                    InitDataProperty(0,		cnt++,	dtHidden,		40,	daCenter,		true,	"rout_scg_tp",				false,	"",	dfNone,		0,	false,	false );
                    
                    Ellipsis = true;
//                    WaitImageVisible = false;
            }
                break;
                
			break;
        }
    }
    
    //  ===================================================================================
    //  버튼 이벤트 처리
    //  ===================================================================================
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
     * @version 2009.09.04
     */ 
    function processButtonClick(){
        var form = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_Retrieve":
                	if (validateForm(sheetObjects[0], form, IBSEARCH)) {
                		doActionIBSheet(sheetObjects[0], form, IBSEARCH);
                	}
                    break;
                    
                case "btn_new":
                	form.date_by_rdo[0].checked = 'checked'; //Date By
                	
                	//날짜 초기화
            		gCurrDate = ComGetDateAdd(null, "D", 0);
            		form.f_eff_dt.value = gCurrDate;
            	    form.f_exp_dt.value = gCurrDate;
            	    
            	    //Ctrt Type 초기화
            	    form.f_ctrt_tp.text = 'S/C,RFA(B/A/C)';
            	    form.prop_ofc_cd_multi.text = 'SELSC,PUSSC,PUSBS';
            	    
            	    //Apvl Ofc 초기화
            	    form.apvl_ofc.value='';
            	    
            	    //Sheet 초기화
                	doActionIBSheet(sheetObjects[0], form,IBCREATE);
                	break;

                case "btn_Downlist":
                    doActionIBSheet(sheetObjects[0], form, IBDOWNEXCEL);
                    break;

                case "btns_calendar": 
       		    	var cal = new ComCalendarFromTo();
                    cal.select(form.f_eff_dt, form.f_exp_dt, 'yyyy-MM-dd');
                    break;
                    
                case "ComOpenPopupWithTarget":	//Approval Office Code 가져오기 팝업
                    var rtnValues = new Object();
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:apvl_ofc", "1,0,1,1,1,1,1,1", true);
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
     * @version 2009.09.04
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction, queryString) {
    	sheetObj.ShowDebugMsg = false;
    	
        switch(sAction) {
        	
            case IBSEARCH: //조회
            	
                try {
                	formObj.jb_id.value = "";
                	sheetObj.WaitImageVisible = false;
                	ComOpenWait(true);
                	
                	setParam(formObj);
                	formObj.f_cmd.value = COMMAND01;
                	
                	var sXml = sheetObj.GetSearchXml("ESM_PRI_0151GS.do", FormQueryString(formObj));
                	var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
                	
                	if (backendJobKey.length > 0) {
                		formObj.jb_id.value = backendJobKey;
                		sheetObj.RequestTimeOut = 10000;
                		timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에
                	} else {
                		ComOpenWait(false);
                	}
                	
                }catch(e){
                	ComShowMessage(e);
                	ComOpenWait(false);
                }
                break;
                
            case IBCREATE:
                sheetObj.RemoveAll();
                break;
                
            case IBDOWNEXCEL:
            	if ( sheetObj.rowCount <= 0) return;
            	
            	// 파일명
            	var fileName = getFileName();
            	var saveFileName = sheetObj.SaveFileDialog("ExcelDown", fileName, "C:\\","엑셀파일(*.xls)|*.xls" );
            	
            	if (saveFileName == '' || saveFileName == "<USER_CANCEL>") {
            		return;
            	} else {
            		ComOpenWait(true);
            		sheetObj.DoSearch4Fx("ESM_PRI_0151GS.do", queryString + "&f_cmd=" + IBDOWNEXCEL);
            		sheetObj.SpeedDown2Excel(1, false, false, saveFileName);
            		ComOpenWait(false);
            	}
            	
                break;
                
        }
    }
    
    function setParam(formObj){
    	formObj.prop_ofc_cd.value = "";
    	formObj.date_by.value = "";
    	
    	formObj.date_by.value = ComGetObjValue ( formObj.date_by_rdo );
    	
    	if(formObj.prop_ofc_cd_multi.text != ""){
    		var prop_scp_ofc_cd_arr = formObj.prop_ofc_cd_multi.text.split(",");
    		formObj.prop_ofc_cd.value = "'"+(ComReplaceStr(prop_scp_ofc_cd_arr.toString(), ",", "', '"))+"'";
    	}
    	
    	if(formObj.prop_srep_cd_multi.text != ""){
    		var prop_srep_cd_arr = formObj.prop_srep_cd_multi.text.split(",");
    		formObj.prop_srep_cd.value = "'"+(ComReplaceStr(prop_srep_cd_arr.toString(), ",", "', '"))+"'";
    	} else {
    		formObj.prop_srep_cd.value = "";
    	}
    	
    }
    
    /** 
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
     * 
     * <br><b>Example :</b>
     * <pre>
     *      Webmail 전송 후 전송 완료되면 완료 메세지 출력
     * </pre>
     * 
     * @return 없음
     */
    function getBackEndJobStatus() {
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	var jobStatus = null;
    	
    	try{
    		formObj.f_cmd.value = SEARCH;
        	var sXml = sheetObj.GetSearchXml("ESM_PRI_0151GS.do", FormQueryString(formObj));
        	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
        	
            if (jobState == "3") {
                getBackEndJobLoadFile();
                clearInterval(timer);
            } else if (jobState == "4") { // BackEndJob을 실패 하였습니다.
                ComShowCodeMessage("PRI00338"); //msgs['PRI00338'] = 'Failed to download. Please try again.';
                clearInterval(timer);
                ComOpenWait(false);
            } else if (jobState == "5") {
                ComShowCodeMessage("PRI00339"); //msgs['PRI00339'] = 'Data was downloaded successfully.';
                clearInterval(timer);
                ComOpenWait(false);
            }
    	
    	}catch(e){
    		ComShowMessage(e);
    		ComOpenWait(false);
    	}
    	
    }
    
    /**
     * BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital) <br>
     */
    function getBackEndJobLoadFile() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	try {
    		formObj.f_cmd.value = SEARCHLIST;
    		var sXml = sheetObj.GetSearchXml("ESM_PRI_0151GS.do", FormQueryString(formObj));
    		sheetObj.LoadSearchXml(sXml);
    		ComOpenWait(false);
    	}catch(e){
    		ComOpenWait(false);
    	}
    }
    
    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.06.04
     */
    function obj_click() {
    	var sheetObj = sheetObjects[0];
    	
    	if (event.srcElement.name == "hidden_use_flg") {
    		if(form.hidden_use_flg.checked) {
    			sheetObj.ColHidden("amdt_seq") = false;
    			sheetObj.ColHidden("blet_dp_seq") = false;
    			sheetObj.ColHidden("eff_dt") = false;
    			sheetObj.ColHidden("svc_scp_cd") = false;
    			sheetObj.ColHidden("prop_ofc_cd") = false;
    			sheetObj.ColHidden("prop_apro_ofc_cd") = false;
    		} else {
    			sheetObj.ColHidden("amdt_seq") = true;
    			sheetObj.ColHidden("blet_dp_seq") = true;
    			sheetObj.ColHidden("eff_dt") = true;
    			sheetObj.ColHidden("svc_scp_cd") = true;
    			sheetObj.ColHidden("prop_ofc_cd") = true;
    			sheetObj.ColHidden("prop_apro_ofc_cd") = true;
    		}
    	}
    }
    
    /**
     * 다운 클릭 시 엑셀 파일명을 생성한다. <br>
     * <br><b>▶ 예 : (Filed_Approved) 2016-06-27~2016-06-27 _ 2016-07-27_14.45 _ Hye-In Ahn</b>
     * 
     */
    function getFileName() {
    	var formObj = document.form;
    	var fileName = "";
    	
    	if(ComGetObjValue ( formObj.date_by_rdo ) == 1) {
    		fileName += "(Filed_Approved) ";
    	} else {
    		fileName += "(Effective) ";
    	}
    	
    	fileName += formObj.f_eff_dt.value + "~" + formObj.f_exp_dt.value + "_";
    	fileName += ComGetNowInfo('ymd', '') + "_" + ComGetNowInfo('hm', '').replace(/:/g,'.') + "_" + formObj.strUsr_nm.value + ".xls";
    	
    	return fileName;
    }
    
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
     * @version 2009.08.12
     */ 
    function obj_keypress(){
        var obj = event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;
        switch(obj.dataformat){
            case "ymd": //날짜 입력하기
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "engup":
            	ComKeyOnlyAlphabet('upper');
                break;
            default:
                //ComKeyOnlyNumber(obj);
                break;
        }
    }
    
    /**
     * OnKeyDown event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param 없음
     * @return 없음
     * @author 강효진
     * @version 2010.04.26
     */       
    function obj_keydown(){
       //enter key조회
       var eleName = event.srcElement.name;
       if (eleName == "f_eff_dt" || eleName == "f_exp_dt"){
           var keyValue = null;
           if(event == undefined || event == null) {
        	   keyValue = 13;
           }else{
        	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
           }
           if (keyValue == 13){
           	if (validateForm(sheetObjects[0], form, IBSEARCH)) {
           		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
           	}
           }
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
     * @author 강효진
     * @version 2010.04.23
     */ 
    function obj_deactivate() {
        var form = document.form;
        var formObj = event.srcElement;
        var eleName = event.srcElement.name;
        
        switch (eleName) {
	        case "f_eff_dt":
	        case "f_exp_dt":
	            // 입력Validation 확인 및 마스킹 처리
	            ComChkObjValid(event.srcElement);
            	break;
        }
    }
    
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction) {
		var frFileDt = form.f_eff_dt;
		var toFileDt = form.f_exp_dt;
		var ctrtTp = form.f_ctrt_tp;
		
		switch (sAction) {
			case IBSEARCH: //조회
			
			//Filing Date 입력했는지 mandatory validation
			if(frFileDt.value == "") {
				ComShowCodeMessage("PRI00335", frFileDt.caption);
				ComSetFocus(frFileDt);
				return false;
			}
			if(toFileDt.value == "") {
				ComShowCodeMessage("PRI00335", toFileDt.caption);
				ComSetFocus(toFileDt);
				return false;
			}
			if(ctrtTp.Code == "") {
				ComShowCodeMessage("PRI00335", 'Contract Type');
				ComSetFocus(ctrtTp);
				return false;
			}
			
			// from date가 to date보다 큰지 validation
			if(!ComChkObjValid(frFileDt)) { return false; }
			if(!ComChkObjValid(toFileDt)) { return false; }
			
			// msgs['PRI07055'] = 'Please check effective date (91 day validation)';
			var ret = ComGetDaysBetween(frFileDt, toFileDt);
			
			if(ret > 90) {
				ComShowCodeMessage("PRI07057", "90");
				ComSetFocus(frFileDt);
				return false;
			}
			break;
			
		}
	
		return true;
	}
	
	function chkEffDate(formObj) {
		var form = document.form;
		var effDt = form.f_eff_dt;
		var expDt = form.f_exp_dt;
		var fromVal = effDt.value.replace(/-/g,'');
		var toVal = expDt.value.replace(/-/g,'');
		var fromAddM = ComGetDateAdd(ComGetDateAdd(fromVal, "M", 3, "", true), "D", -1, "", true);
		
		if( parseInt(toVal,10) > parseInt(fromAddM,10) ) {
			ComShowCodeMessage("PRI00308", "check the date range!.", " Maximum date range is 3 months");
			ComSetFocus(formObj);
			return false;
		}
		return true;
	}
