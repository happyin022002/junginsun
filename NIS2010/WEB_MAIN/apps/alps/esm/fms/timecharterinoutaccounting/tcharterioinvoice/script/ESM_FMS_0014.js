/*=========================================================
* Copyright(c) 2009 CyberLogitec
* @FileName : ESM_FMS_0014.js
* @FileTitle : Off-Hire Expenses
* Open Issues :
* Change history :
* @LastModifyDate : 2009.05.20
* @LastModifier : 정윤태
* @LastVersion : 1.0
* 2009.05.20 정윤태
* 1.0 최초 생성
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
* 
* 2012-03-05 김영오
* Row_add 버튼 클릭 시 "Description"값 셋팅 하는 로직 제거
* 2013.06.10 이영두 [CHM-201325103] Off-Hire Expenses에서 생성 번호가 2자리일 경우 저장되게 보완
* 
* --------------------------------------------------------------------------------
* 2016.02.01 손진환 [CHM-201639985] Inquiry 화면 불필요 Validation정리 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview Off-Hire Expenses 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     * @author 한진해운
     */

    /**
     * @extends FMS
     * @class Off-Hire Expenses : 용/대선료 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0014() {
    	this.initControl        = initControl;
        this.declaration_click  = declaration_click;
        this.validateForm       = validateForm;
        this.eng_keypress		= eng_keypress;
        this.cust_seq_change	= cust_seq_change;
        this.obj_deactivate		= obj_deactivate;
        this.obj_activate		= obj_activate;
        this.obj_keypress		= obj_keypress;
        this.setOwnerCode		= setOwnerCode;
        this.clearAll			= clearAll;
        this.t1sheet1_OnChange	= t1sheet1_OnChange;
        this.setSheetObject		= setSheetObject;
        this.processButtonClick	= processButtonClick;
        this.setComboObject		= setComboObject;
        this.loadPage			= loadPage;
        this.sheet2_OnLoadFinish= sheet2_OnLoadFinish;
        this.initCombo			= initCombo;
        this.initSheet			= initSheet;
        this.doActionIBSheet	= doActionIBSheet;
        this.setTabObject		= setTabObject;
        this.initTab			= initTab;
        this.vsl_cd_change		= vsl_cd_change;
        this.contract_no_change	= contract_no_change;
        this.inv_usd_dys_change	= inv_usd_dys_change;
        this.tab1_OnChange		= tab1_OnChange;
        this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
        this.sheet2_OnSearchEnd	= sheet2_OnSearchEnd;
        this.sheet2_OnChangeSum	= sheet2_OnChangeSum;
        this.setInitCellProperty= setInitCellProperty;
        this.getMaxInvDtlSeq	= getMaxInvDtlSeq;
        this.rowRemove			= rowRemove;
        this.setCondition		= setCondition;
        this.setVslCd			= setVslCd;
        this.setContractNo		= setContractNo;
        this.setCombo			= setCombo;
        this.getInvUsdDys		= getInvUsdDys;
        this.durationDayCheck	= durationDayCheck;
        this.setDurationReadOnly= setDurationReadOnly;
        this.delConfirm			= delConfirm;
        this.controlScrollBar	= controlScrollBar;
        this.setDuration		= setDuration;
        this.comboReset			= comboReset;
        this.checkDuration		= checkDuration;
        this.durationReset		= durationReset;
        this.gridReset			= gridReset;
        this.bunker_vvd_click	= bunker_vvd_click;
        this.setVmsDuration		= setVmsDuration;
        this.sheet2_OnValidation= sheet2_OnValidation;
        this.sheet2_OnChange	= sheet2_OnChange;
        this.invAmtOnChange		= invAmtOnChange;
        this.currencyOnChange	= currencyOnChange;
        this.initConfirm		= initConfirm;
        this.setBunkerVvd		= setBunkerVvd;
        this.setProgramNo		= setProgramNo;
        this.sheet2_OnPopupClick= sheet2_OnPopupClick;
        this.gridDataCount		= gridDataCount;
        this.setPrintBtn		= setPrintBtn;
        this.initPreDuration    = initPreDuration;
        this.rdOpen				= rdOpen;
    }
    
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var bunker_vvd = "";
    var effDt = "";
	var expDt = "";
	
	//이전 From 값
	var preEffDt = "";
	
	//이전 To 값
	var preExpDt = "";

	//RD 관련 변수 선언
	var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
	            case "btn_execute":
	            	doActionIBSheet(sheetObject2,formObject,IBSEARCH);
	                break;
	            
	            case "btn_add":
	            	
	            	if(form.search_yn.value != "Y") return;
	            	
	            	var bunker_vvd = formObject.bunker_vvd[formObject.bunker_vvd.selectedIndex].value.substring(0,9);

	            	var eff_dt = formObject.eff_dt.value;
	            	var exp_dt = formObject.exp_dt.value;
	            	var to_time = formObject.to_time.value;
	            	
	            	if(to_time == "00:00") {
	            		exp_dt = ComGetDateAdd(exp_dt, 'D', -1);
	            	}
					
					var row = sheetObject2.DataInsert(-1);
					
					sheetObject2.DataLinkMouse("inv_acct_itm_nm") = true;
					
					sheetObject2.CellEditable(row, "inv_curr_cd")  = true;
					sheetObject2.CellEditable(row, "inv_inv_amt2") = false;
					sheetObject2.CellEditable(row, "inv_inv_desc") = true;
					
					sheetObject2.CellText(row,"inv_flet_ctrt_no") = formObject.flet_ctrt_no.value;
					sheetObject2.CellText(row,"inv_slp_tp_cd") = "N";			
					sheetObject2.CellText(row,"inv_inv_seq") = formObject.inv_seq.value;
					
					//2012-03-05 Row_add 버튼 클릭 시 "Description"값 셋팅 하는 로직 제거 
					//sheetObject2.CellText(row,"inv_inv_desc") = "Off-hire "+bunker_vvd+" ("+eff_dt+" ~ "+exp_dt+")";
					
					var inv_dtl_seq = getMaxInvDtlSeq(sheetObject2);
					
					if(inv_dtl_seq == "") {
						inv_dtl_seq = 1;
					} else {
						inv_dtl_seq = parseInt(inv_dtl_seq) + 1;
					}

					sheetObject2.CellText(row,"inv_inv_dtl_seq") = inv_dtl_seq;
					
                    break;
                    
	            case "btn_del":
	            	if(checkBoxCheckYn(sheetObject2, "inv_DelChk")) {
	            		rowRemove(sheetObject2, "inv_");
	            	}
                    break;
                    
                case "btn_delete":
                	rowRemove(sheetObject2, "inv_");
                    break;

				case "btn_new":
					if(!initConfirm()) return;
					
					clearAll("NEW");
					
					durationReset();
					
					setPrintBtn("H");
                    break;

				case "btn_save":
					doActionIBSheet(sheetObject2,formObject,IBSAVE);
                    break;

				case "btn_delete2":
					doActionIBSheet(sheetObject2,formObject,IBDELETE);
                    break;

				case "btn_print":
					//RD Open
					rdOpen(rdObjects[0],formObject);
                    break;
                
				case "btn_vslpop" :
					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0022");
            		break;
            		
				case "contract_no":
					if(formObject.vsl_cd.value == "") {
						ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01138'));
						return;
					}
					 
					ComOpenPopup("ESM_FMS_0023.do?typeFlag=TI&vsl_cd=" + formObject.vsl_cd.value, 520, 405,"setContractNo", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0023");

					 break;
					 
				case "duration":
					if(!formObject.condition[2].checked) return;
					
					if(formObject.vsl_cd.value == "") {
						ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01138'));
						return;
					} else if(formObject.flet_ctrt_no.value == "") {
						ComShowMessage(ComGetMsg('FMS01154'));
						return;
					}
					
					if(formObject.inv_seq.value != "") {
						if(formObject.eff_dt.value == "") {
							comboReset();
						}
						gridReset();
						document.all.totalAmount.style.display = "none";
						document.all.btn_print.style.display = "none";
					}
					
					ComOpenPopup("ESM_FMS_0078.do?flet_ctrt_no=" + formObject.flet_ctrt_no.value, 500, 375, "setDuration", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0078");

					 break;
					 
				case "ef_dt": 
					var cal = new ComCalendar();
					cal.select(form.eff_dt, 'yyyy-MM-dd');
				 break;
				 
				case "ex_dt":
					var cal = new ComCalendar();
					cal.select(form.exp_dt, 'yyyy-MM-dd');	
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
     * 페이지에 생성된 IBMultiCombo Object를 comboObjects 배열에 등록한다. <br>
     * comboObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComComboObject} 함수에 의해서 IBMultiCombo Object가 생성되면서 자동 호출된다. <br>
     * @param {ibmulticombo} combo_obj    IBMultiCombo Object
     **/
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
            ComConfigSheet (sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
            
            //마지막 컬럼을 전체 너비에 맞춘다.
            sheetObjects[i].ExtendLastCol = false;
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        //html컨트롤 이벤트초기화
        initControl();

		//RD
		initRdConfig(rdObjects[0]);
    }
     
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet2_OnLoadFinish(sheetObj) {   
    	sheetObj.WaitImageVisible = false;   
  
		CoFmsGetCombo('FORM', document.form, sheetObj, 'CD01523', 'flet_offh_rsn_cd', 'flet_offh_rsn_nm');
		
		sheetObj.WaitImageVisible = true;   
    }

	/**
     * 페이지에 있는 RD Object를 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
     * @param {rdObject} rdObject    RD Object
     **/
	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
	    
		//Rdviewer.AutoAdjust = true;
		//Rdviewer.ViewShowMode(0);
		Rdviewer.style.height = 0;
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
    
    /**
     * 페이지에 있는 IBMultiCombo Object를 초기화 한다. <br>
     * IBMultiCombo가 여러개일 경우 개수만큼 case를 추가하여 IBMultiCombo 초기화 모듈을 구성한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBMultiCombo Object를 초기화 한다. <br>
     * @param {ibmulticombo}    comboObj      IBTab Object
     * @param {int}             comboNo       comboObjects 배열에서 순번
     **/
    function initCombo(comboObj, comboNo) {

        switch(comboObj.id) {
            case "boo_rcv_term_cd1":    //R/D Term
            case "pay_hir_no": 
                var i=0;
                comboObj.InsertItem(i++, "Y|CY",            "Y");
                comboObj.InsertItem(i++, "D|Door",          "D");
                comboObj.InsertItem(i++, "S|CFS",           "S");
                comboObj.InsertItem(i++, "H|C' Haul on CY", "H");
                comboObj.InsertItem(i++, "T|Tackle",        "T");
                comboObj.InsertItem(i++, "I|Free In",       "I");
                comboObj.InsertItem(i++, "M|Mixed",         "M");
                comboObj.Code = "Y";
                break;            
            case "boo_usa_cstms_file_cd":   //Filer
            case "boo_cnd_cstms_file_cd":
                var i=0;
                comboObj.InsertItem(i++, "1|Carrier Filing NVO", "1");
                comboObj.InsertItem(i++, "2|Self Filing NVO", "2");
                comboObj.InsertItem(i++, "3|Not Application", "3");
                comboObj.Code = "1";
                break;
        }
        
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case 를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetObj.id) {
        case "sheet1":      //sheet1 init
    		with (sheetObj) {
            	var prefix = "oli_";
            	
            	//AutoSizeMode=false;
                // 높이 설정
                style.height = 120;
                //전체 너비 설정
                //SheetWidth = mainTable.clientWidth;
            	SheetWidth = 665;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 5, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(5, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)

                var HeadTitle = "Item Name|From Date|To Date|Cur|Amount";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    	[ROW, COL,  DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  	   			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,      	134,   daLeft,    false,    prefix + "acct_itm_nm",		false,          "",      	dfNone,      0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,    prefix + "eff_dt",    		false,          "",      	dfDateYmd,   0,     false,      true);
				InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,    prefix + "exp_dt",     		false,          "",      	dfDateYmd,   0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,    prefix + "curr_cd",     	false,          "",      	dfEngUpKey,  0,     true,       true,	3);
				InitDataProperty(0, cnt++ , dtData,      	240,   daRight,   false,    prefix + "otr_expn_amt",	false,          "",      	dfNullFloat, 2,     true,       true,	13);
				
				CountPosition = 0;
				FitColWidth("32|13|13|8|34");
				//날짜구분자를 설정한다.
				//DateFormatChar = "/";

           }
            break;
            
            case "sheet2":      //t1sheet1 init
                with (sheetObj) {
                	var prefix = "inv_";
                	
                    // 높이 설정
                    style.height = 160;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    //InitColumnInfo(13, 0, 0, true);
                    InitColumnInfo(24, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //var HeadTitle = "|Seq|Sel|Item Name|Account Code|From Date|To Date|Cur 1|Amount|Cur 2|Amount|Approval|Description";
                    var HeadTitle = "|Sel|Seq|Item Name|Account Code|Cur 1|Amount|Cur 2|Amount|Approval|Description|FletCtrtNo|FletIssTpCd|InvSeq|InvDtlSeq|AcctItmSeq|Ori Amount|Ori Amount2|From Date|To Date|Inv Usd Dys|Sort Key|Fir Amount|Fir Amount2";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  true,      prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   40,    daCenter,  false,     prefix + "DelChk");
                    InitDataProperty(0, cnt++ , dtSeq,    		33,    daCenter,  true,      prefix + "Seq");
                    InitDataProperty(0, cnt++ , dtPopup,      	203,   daLeft,    false,     prefix + "acct_itm_nm",     	true,           "",      dfNone,      0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      	93,    daCenter,  false,     prefix + "acct_cd",     		false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	45,    daCenter,  false,     prefix + "curr_cd",			false,          "",      dfEngUpKey,  0,     false,       false, 3);
					InitDataProperty(0, cnt++ , dtData,         99,    daRight,   false,     prefix + "inv_amt", 			false,          "",      dfNullFloat, 2,     true,        true,  15);
					InitDataProperty(0, cnt++ , dtData,      	45,    daCenter,  false,     prefix + "curr_cd2",			false,          "",      dfNone,      0,     false,       false, 3);
					InitDataProperty(0, cnt++ , dtData,         99,    daRight,   false,     prefix + "inv_amt2", 			false,          "",      dfNullFloat, 2,     true,        true,  15);
					InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,  false,     prefix + "slp_tp_cd",     		false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	247,   daLeft,    false,     prefix + "inv_desc",     	    false,          "",      dfNone,      0,     false,       false, 50);
					
					InitDataProperty(0, cnt++ , dtHidden,      	62,    daCenter,  false,     prefix + "flet_ctrt_no",     	false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	62,    daCenter,  false,     prefix + "flet_iss_tp_cd",     false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	62,    daCenter,  false,     prefix + "inv_seq",     		false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	62,    daCenter,  false,     prefix + "inv_dtl_seq",     	false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	62,    daCenter,  false,     prefix + "acct_itm_seq",     	false,          "",      dfNone,      0,     false,       false);
					
					InitDataProperty(0, cnt++ , dtHidden,      	99,    daRight,   false,     prefix + "ori_inv_amt", 		false,          "",      dfNullFloat, 2,     true,        true);
					InitDataProperty(0, cnt++ , dtHidden,      	99,    daRight,   false,     prefix + "ori_inv_amt2", 		false,          "",      dfNullFloat, 2,     true,        true);
					
					InitDataProperty(0, cnt++ , dtHidden,      	99,    daCenter,  false,     prefix + "eff_dt",     		false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	99,    daCenter,  false,     prefix + "exp_dt",     		false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	99,    daCenter,  false,     prefix + "inv_usd_dys",     	false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	30,    daCenter,  false,     prefix + "sort_key",     		false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	99,    daRight,   false,     prefix + "fir_inv_amt", 		false,          "",      dfNullFloat, 2,     true,        true);
					InitDataProperty(0, cnt++ , dtHidden,      	99,    daRight,   false,     prefix + "fir_inv_amt2", 		false,          "",      dfNullFloat, 2,     true,        true);
					
					InitDataValid(0, prefix + "curr_cd", vtEngUpOnly); 
					
					ShowButtonImage = 1;

					MessageText("Sum") = "";
               }
                break;
        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     * @param {String}  gubun     	처리할 gubun 값
     **/
    function doActionIBSheet(sheetObj,formObj,sAction,kind,row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	
        	case IBSEARCH:      //조회

        		if(!validateForm(sheetObj,formObj,sAction))  return true;
        	   	
        	   	if(formObj.condition[2].checked) {
        	   		
        	   		formObj.f_cmd.value = SEARCH01;
 
        	   		var aryPrefix = new Array("inv_", "");
        	   	} else {
        	   		var length = form.bunker_vvd.options.length;
        	   		if(length < 1) {
        	   			ComShowMessage(ComGetMsg('FMS01155'));
        	   			return;
        	   		}
        	   		
        	   		document.all.btn_delete2.style.display = "none";
        	   		
        	   		declaration_click();
        	   		
        	   		formObj.f_cmd.value = SEARCH;
        	   		var aryPrefix = new Array("inv_", "");
        	   	}
      
        	   	var sXml = sheetObj.GetSearchXml("ESM_FMS_0014GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));

    			var arrXml = sXml.split("|$$|");
    			
    			if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);
				
    			if (arrXml.length > 0) {		
					
					var list = ComFmsSheetXml2ListMap(arrXml[1]);
					
					var totalAmtHtml = ComFmsMakeTotalAmtHtml(list);
					var arrTotalAmtHtml = totalAmtHtml.split("|$$|");
					
					if (arrTotalAmtHtml.length > 0) {
						document.all.totalAmount.style.display = "";
						document.all.totalAmount1.innerHTML = arrTotalAmtHtml[0];
						document.all.totalAmount2.innerHTML = arrTotalAmtHtml[1];
					}
			
				}
    			
    			/*
				if(   (typeof sheetObjects[1].EtcData("totalAmount1") != "undefined"
 				   && sheetObjects[1].EtcData("totalAmount1") != "") || 
 				   	  (typeof sheetObjects[1].EtcData("totalAmount2") != "undefined"
	 			   && sheetObjects[1].EtcData("totalAmount2") != "")) {
					document.all.totalAmount.style.display = "";
					document.all.totalAmount1.innerHTML = sheetObjects[1].EtcData("totalAmount1");
					document.all.totalAmount2.innerHTML = sheetObjects[1].EtcData("totalAmount2");
 				}
 				*/
    			
    			
    			/*
    			if(formObj.condition[0].checked) {
    				if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);
    				
    				if(   (typeof sheetObjects[1].EtcData("totalAmount1") != "undefined"
	 				   && sheetObjects[1].EtcData("totalAmount1") != "") || 
	 				   	  (typeof sheetObjects[1].EtcData("totalAmount2") != "undefined"
		 			   && sheetObjects[1].EtcData("totalAmount2") != "")) {
    					document.all.totalAmount.style.display = "";
    					document.all.totalAmount1.innerHTML = sheetObjects[1].EtcData("totalAmount1");
    					document.all.totalAmount2.innerHTML = sheetObjects[1].EtcData("totalAmount2");
	 				}
    				
    			} else {
    				if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);

	    			if(   (typeof sheetObjects[1].EtcData("totalAmount1") != "undefined"
	 				   && sheetObjects[1].EtcData("totalAmount1") != "") || 
	 				   	  (typeof sheetObjects[1].EtcData("totalAmount2") != "undefined"
		 			   && sheetObjects[1].EtcData("totalAmount2") != "")) {
    					document.all.totalAmount.style.display = "";
    					document.all.totalAmount1.innerHTML = sheetObjects[1].EtcData("totalAmount1");
    					document.all.totalAmount2.innerHTML = sheetObjects[1].EtcData("totalAmount2");
	 				}
    			}
    			*/
    			
    			formObj.search_yn.value = "Y";
    			
    			var val = "";
    			if(formObj.condition[2].checked) {
    				val = "I";
    				
    				setPrintBtn();
    			}
    			
    			setDurationReadOnly(val);
    			
    			controlScrollBar();

                break;

			case IBSAVE:        //저장

				if(!validateForm(sheetObj,formObj,sAction))  return true;
				
				var length = formObj.bunker_vvd.options.length;
    	   		if(length < 1) {
    	   			ComShowMessage(ComGetMsg('FMS01155'));
    	   			return;
    	   		}
    	   		
    	   		if(formObj.search_yn.value != "Y") {
					ComShowMessage(ComGetMsg('FMS01230'));
					return;
				}
    	   		
    	   		if(!formObj.condition[2].checked && !gridDataCount()) {
    	   			ComShowMessage(ComGetMsg('FMS01169'));
    	   			return;
    	   		}
				
				var fromDate = formObj.eff_dt.value.trimAll("-") + formObj.from_time.value.trimAll(":");
	        	var toDate = formObj.exp_dt.value.trimAll("-") + formObj.to_time.value.trimAll(":");
	        	
	        	formObj.ori_eff_dt.value = fromDate;
	            formObj.ori_exp_dt.value = toDate;
				
				formObj.f_cmd.value = MULTI;
				
				if(formObj.condition[2].checked) {

					formObj.ibflag.value = "U";

					if(bunker_vvd != formObj.bunker_vvd[formObj.bunker_vvd.selectedIndex].value) {
						for (var ir=1; ir<=sheetObj.LastRow; ir++){
							if(sheetObjects[1].RowStatus(ir) == "R") {
								sheetObjects[1].RowStatus(ir)= "U";
							}
						}
						
						var chg_bunker_vvd = formObj.bunker_vvd[formObj.bunker_vvd.selectedIndex].value;
						var eff_dt = formObj.eff_dt.value;
						var exp_dt = formObj.exp_dt.value;
						
						formObj.inv_desc.value = "Off-hire "+chg_bunker_vvd+" ("+eff_dt+" ~ "+exp_dt+")";
						
						//현재 변경된 항차로 변경해준다
						bunker_vvd = chg_bunker_vvd;
					}
					
				} else if(formObj.condition[1].checked) { 
					for (var ir=1; ir<=sheetObj.LastRow; ir++){
						if(sheetObj.RowHidden(ir)==false) {
							sheetObj.RowStatus(ir)= "I";
						}
					}
        		} else {
					if(formObj.ibflag.value == "I") {
						for (var ir=1; ir<=sheetObj.LastRow; ir++){
							if(sheetObj.RowHidden(ir)==false) {
								sheetObj.RowStatus(ir)= "I";
							}
						}
					}
				}
					
				var arrSheets = new Array(sheetObjects[1]);
				var sParam = ComGetSaveString(arrSheets);
				
				//var sParam = sheetObj.GetSaveString(); 
				if (sheetObj.IsDataModified && sParam == "") {
					return; 
				}
				 
				if(formObj.condition[2].checked) {
					var aryPrefix = new Array("inv_", "");
        	   	} else {
        	   		var aryPrefix = new Array("inv_", "");
        	   	}
					
				sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					 
				var sXml = sheetObj.GetSaveXml("ESM_FMS_0014GS.do", sParam);
				var arrXml = sXml.split("|$$|");
				 
				if(   formObj.condition[0].checked
				   || formObj.condition[1].checked) {
					if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]); 
					 
					if(typeof sheetObjects[1].EtcData("invSeq") != "undefined") {
						formObj.inv_seq.value = sheetObjects[1].EtcData("invSeq");
					}
					 
					if(typeof sheetObjects[1].EtcData("acmmFlg") != "undefined") {
						if(sheetObjects[1].EtcData("acmmFlg") == "Y") {
							formObj.acmm_flg.checked = true;
						} else {
							formObj.acmm_flg.checked = false;
						}
					}
	    			
					if(typeof sheetObjects[1].EtcData("brogFlg") != "undefined") {
						if(sheetObjects[1].EtcData("brogFlg") == "Y") {
							formObj.brog_flg.checked = true;
						} else {
							formObj.brog_flg.checked = false;
						}
					}
					
					if (arrXml.length > 0) {		
						
						var list = ComFmsSheetXml2ListMap(arrXml[1]);
						
						var totalAmtHtml = ComFmsMakeTotalAmtHtml(list);
						var arrTotalAmtHtml = totalAmtHtml.split("|$$|");
						
						if (arrTotalAmtHtml.length > 0) {
							document.all.totalAmount.style.display = "";
							document.all.totalAmount1.innerHTML = arrTotalAmtHtml[0];
							document.all.totalAmount2.innerHTML = arrTotalAmtHtml[1];
						}
				
					}
					
					/*
					if( (typeof sheetObjects[1].EtcData("totalAmount1") != "undefined"
					   && sheetObjects[1].EtcData("totalAmount1") != "") || 
			 			(typeof sheetObjects[1].EtcData("totalAmount2") != "undefined"
				 	   && sheetObjects[1].EtcData("totalAmount2") != "")) {
					    document.all.totalAmount.style.display = "";
		    			document.all.totalAmount1.innerHTML = sheetObjects[1].EtcData("totalAmount1");
		    			document.all.totalAmount2.innerHTML = sheetObjects[1].EtcData("totalAmount2");
			 		}
			 		*/
					 
				} else {
					if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]); 
					
					if (arrXml.length > 0) {		
						
						var list = ComFmsSheetXml2ListMap(arrXml[1]);	
						
						var totalAmtHtml = ComFmsMakeTotalAmtHtml(list);
						var arrTotalAmtHtml = totalAmtHtml.split("|$$|");
						
						if (arrTotalAmtHtml.length > 0) {
							document.all.totalAmount.style.display = "";
							document.all.totalAmount1.innerHTML = arrTotalAmtHtml[0];
							document.all.totalAmount2.innerHTML = arrTotalAmtHtml[1];
						}
				
					}
					
					/*
					if( (typeof sheetObjects[1].EtcData("totalAmount1") != "undefined"
					   && sheetObjects[1].EtcData("totalAmount1") != "") || 
		 				(typeof sheetObjects[1].EtcData("totalAmount2") != "undefined"
			 		   && sheetObjects[1].EtcData("totalAmount2") != "")) {
						document.all.totalAmount.style.display = "";
	    				document.all.totalAmount1.innerHTML = sheetObjects[1].EtcData("totalAmount1");
	    				document.all.totalAmount2.innerHTML = sheetObjects[1].EtcData("totalAmount2");
		 			}
		 			*/
				}
				 
			    //Creation/Creation From VMS 체크 후 저장 버튼 클릭 시(START)
				if(!formObj.condition[2].checked) {
					formObj.condition[0].checked = false;
					formObj.condition[1].checked = false;
					formObj.condition[2].checked = true;
					
					formObj.duration.style.cursor = "hand";
				    document.images["duration"].name = "duration";
				    
					formObj.bunker_vvd.disabled = false;
					formObj.flet_offh_rsn_cd.disabled = false;
				}
				 
				if(formObj.condition[1].checked) {
					formObj.eff_dt.readOnly    = true;
					formObj.from_time.readOnly = true;
					formObj.exp_dt.readOnly  = true;
					formObj.to_time.readOnly = true;

					formObj.acmm_flg.disabled = true;
					formObj.brog_flg.disabled = true;
					formObj.ef_dt.style.cursor = "default";
					formObj.ex_dt.style.cursor = "default";
					document.images["ef_dt"].name = "no_ef_dt";
					document.images["ex_dt"].name = "no_ex_dt";
    	        }
				 
				if(document.all.btn_delete2.style.display == "none") {
					document.all.btn_delete2.style.display = "";
				}
				
				setPrintBtn();
				 
			    //Creation체크 후 저장 버튼 클릭 시(END)
				 
				break;	 
			 case IBROWSEARCH:      //조회
				 	
				 	if(kind == "Vessel") {
				 		
		        		if(formObj.vsl_cd.value == "") {
				    		formObj.vsl_eng_nm.value = "";
				    		return;
				    	}
				    	
		        		sheetObj.WaitImageVisible = false;
		        		
				    	formObj.f_cmd.value = SEARCH01;
						
			   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
			
			   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
			   			
			   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
							formObj.vsl_eng_nm.value = vslEngNm;
							
//							formObj.vsl_cd.readOnly = true;
//			   				formObj.btn_vslpop.style.cursor = "default";
//			   				document.images["btn_vslpop"].name = "no_btn_vslpop";
			   				initDefaultContractNo(); //선박 대 계약 자동 매치
						} else {
							formObj.vsl_cd.value = "";
							formObj.vsl_eng_nm.value = "";
							ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
							return;
						}
			   			
			   			sheetObj.WaitImageVisible = true;
			   			
		        	} else if(kind == "Contract") {
		        		if(formObj.flet_ctrt_no.value == "") return;
		        		
		        		sheetObj.WaitImageVisible = false;
		        		
		        		var effDt 	= formObj.eff_dt.value;
		        		var fromTime= formObj.from_time.value;
		        		var expDt 	= formObj.exp_dt.value;
		        		var toTime 	= formObj.to_time.value;
		        		var invUsdDys = formObj.inv_usd_dys.value;
		        			
				    	formObj.f_cmd.value = SEARCH02;
						
				    	var aryPrefix = new Array("oli_");
				        
		        	   	var sXml = sheetObj.GetSearchXml("ESM_FMS_0001GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));

		    			var arrXml = sXml.split("|$$|");
		    			if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
		    			
		    			ComEtcDataToForm2(formObj,sheetObjects[0],"",true);
		    			ComEtcDataToForm2(formObj,sheetObjects[0],"hir_",true);
		    			
		    			formObj.eff_dt.value = "";
		    			formObj.exp_dt.value = "";
		    			
		    			if(typeof sheetObjects[0].EtcData("acmmFlg") != "undefined") {
							 if(sheetObjects[0].EtcData("acmmFlg") == "Y") {
								 formObj.acmm_flg.checked = true;
							 } else {
								 formObj.acmm_flg.checked = false;
							 }
						 }
		    			
						 if(typeof sheetObjects[0].EtcData("brogFlg") != "undefined") {
							 if(sheetObjects[0].EtcData("brogFlg") == "Y") {
								 formObj.brog_flg.checked = true;
							 } else {
								 formObj.brog_flg.checked = false;
							 }
						 }
		    			
		    			if(formObj.vsl_cd.value == "") {
		    				ComShowMessage(ComGetMsg('FMS01156'));
		    				clearAll();
		    				return;
	    				}
		    			
		    			formObj.ibflag.value = "I";
		    			
		    			//Contract TP값 세팅
		    			var fletCtrtTpCd = "";
		    			
		    			if(formObj.flet_ctrt_tp_cd.value == "T/C In") {
		    				fletCtrtTpCd = "TI"
		    			} else {
		    				fletCtrtTpCd = "TO"
		    			}
		    			
		    			formObj.flet_ctrt_tp_gb.value = fletCtrtTpCd;
		    			
		    			//Duration 정보 세팅
		    			formObj.eff_dt.value = effDt;
		        		formObj.from_time.value = fromTime;
		        		formObj.exp_dt.value = expDt;
		        		formObj.to_time.value = toTime;
		        		formObj.inv_usd_dys.value = invUsdDys;
		        		
		        		sheetObj.WaitImageVisible = true;

		        	} else if(kind == "Duration") {
		        		if(!validateForm(sheetObj,formObj,sAction,"D"))  return true;
		        		
		        		sheetObj.WaitImageVisible = false;
				    	
				    	formObj.f_cmd.value = SEARCH10;

			   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0014GS.do" , FormQueryString(formObj));

			   			var invUsdDys = ComGetEtcData(sXml, "invUsdDys");

			   			if(typeof invUsdDys != "undefined" && invUsdDys != "" ) {
							formObj.inv_usd_dys.value = invUsdDys;
						}	
			   			
			   			sheetObj.WaitImageVisible = true;
			   			
		        	} else if(kind == "currCd") {
		        		
		        		sheetObj.WaitImageVisible = false;
		        		
		        		formObj.f_cmd.value = SEARCH01;
		        		
		        		var sXml = sheetObj.GetSearchXml("ESM_FMS_0076GS.do" , FormQueryString(formObj));
		        		
			   			var currCd = ComGetEtcData(sXml, "currCd");
			   			
			   			if(typeof currCd == "undefined" || currCd == "") {
			   				ComShowMessage(ComGetMsg('FMS01142'));
			   				
			   				var prefix = "inv_";
		   					var currCdCol = sheetObj.SaveNameCol(prefix + "curr_cd");
		   					
		   					sheetObj.CellValue2(row,currCdCol) = "";
		   					sheetObj.SelectCell(row,currCdCol);
		   					
			   			} else {
		   					var prefix = "inv_";
		   					var currCd = sheetObj.CellValue(row, prefix + "curr_cd");
		   					
		   					ComFmsSetInitCellProperty(sheetObj, row, 6, "inv_amt", currCd, prefix, 2);
		   				}
			   			
			   			sheetObj.WaitImageVisible = true;
		        	}
					
		   			break;

			case IBINSERT:      // 입력
                break;
                
			case IBDELETE:      // 삭제
				
				if(!validateForm(sheetObj,formObj,sAction,"Y"))  return true;
			
				if(!(formObj.condition[2].checked && sheetObj.RowCount > 0)) return;
				
				if(!delConfirm()) return;
				 
				formObj.f_cmd.value = REMOVE;
				formObj.ibflag.value = "D";
				 
				var sFormParam = FormQueryString(formObj);
				var sParam = sFormParam;
				 
				var sXml = sheetObj.GetSaveXml("ESM_FMS_0014GS.do", sParam);
				 
				sheetObj.LoadSaveXml(sXml);
				 
				//화면 초기화
				clearAll("DEL");
				
				setPrintBtn("H");
				 
                break;
                
			case IBSEARCH_ASYNC02: //선박 대 계약 자동 매치
				if(formObj.vsl_cd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdTI; //TI Only
				
				var sXml = sheetObj.GetSearchXml("FMS_COMGS.do",f_query);

	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.flet_ctrt_no.value = varFletCtrtNo;
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
					return;
				}
				if(formObj.flet_ctrt_no.value != ""){
					contract_no_change();
				}
				break;    
        }
    }


    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {

                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Hire" , -1 );
                    InsertTab( cnt++ , "Other ExpB" , -1 );
                    InsertTab( cnt++ , "Payment Term" , -1 );
                    InsertTab( cnt++ , "Redelivery" , -1 );
                    InsertTab( cnt++ , "CP file up" , -1 );
                    InsertTab( cnt++ , "Certi File up" , -1 );

                }
             break;

         }
    }
    
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "-";
    	
        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListener  ('click', 'declaration_click', 'acmm_flg', 'brog_flg');    	//declaration 체크여부
        axon_event.addListener  ('click', 'bunker_vvd_click', 'bunker_vvd');    			//bunker_vvd 체크
        //2010.11.24 이상민 [CHM-201007233-01] vsl_cd 는 engnum_keypress로 변경
        axon_event.addListener  ('keypress', 'eng_keypress', 'cust_cnt_cd', 'vsl_cnt_cd', 'oa_rsv_curr_cd');
        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'); //- Vessel Code 입력 시 영문 대문자/숫자만 입력하기
        
        axon_event.addListener  ('change', 'cust_seq_change', 'cust_seq');		//Owner Code 입력 후 Name정보 가져오기
        axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기

        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        
        //CoFmsGetCombo('FORM', document.form, sheetObjects[0], 'CD01523', 'flet_offh_rsn_cd', 'flet_offh_rsn_nm');
    }
    //Axon 이벤트 처리2. 이벤트처리함수 --- start
    
    /**
     * Bunker Vvd 설정 <br>
     * @return {없음}
     **/
    function bunker_vvd_click() {
    	var fletCtrtNo = form.flet_ctrt_no.value;
    	var vslCd = form.vsl_cd.value;
    	
    	effDt = form.eff_dt.value;
    	expDt = form.exp_dt.value;

    	if(vslCd == "") {
    		ComAlertFocus(form.vsl_cd, ComGetMsg('FMS01138'));
    		return;
    	} else if(fletCtrtNo == "") {
    		ComShowMessage(ComGetMsg('FMS01154'));
    		return;
    	} else if(effDt.length < 10) {
    		ComAlertFocus(form.eff_dt, ComGetMsg('FMS01157'));
    		return;
    	} else if(expDt.length < 10) {
    		ComAlertFocus(form.exp_dt, ComGetMsg('FMS01157'));
    		return;
    	}
    	
    	setBunkerVvd();
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
     
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
         //영대문자 자동변환
         ComKeyOnlyAlphabet('uppernum');
     } 
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
	    	case "shp_spd_qty": 
	    	case "vsl_dznd_capa": 
	    	case "bse_14ton_vsl_capa": 
	    	case "rf_cntr_plg_qty": 
	    	case "ddwt_cgo_capa_qty": 
	    	case "grs_wgt": 
	    	case "nrt_wgt":
	    	case "cust_seq":
	    		//숫자이면서 천단위 구분을 하지 않는다.
	    		//ComChkObjValid(obj, bMsg, bTrim, bMasked)
    			ComChkObjValid(event.srcElement, true, false, false);
    			break;
    			
	    	case "eff_dt":
	    	case "exp_dt":
	    	case "from_time":
	    	case "to_time":
	    		ComChkObjValid(event.srcElement);
	    		
	    		if(!form.condition[0].checked) {
	    			setBunkerVvd('C');
	    		}
	    		
	    		getInvUsdDys();
    			break;
    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
    }

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        //마스크구분자 없애기
        ComClearSeparator(event.srcElement);
    }
    
    /**
     * CustSeq변경 시 해당 Name 을 가져온다. <br>
     **/
    function cust_seq_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Owner');
    }
    
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {
    	sheetObjects[1].RemoveAll();
    	
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Vessel');
    }
    
    /**
     * Contract No 선택 시 해당 Name 을 가져온다. <br>
     **/
    function contract_no_change() {
    	sheetObjects[1].RemoveAll();
    	
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Contract');
    }
    
    /**
     * Duration 일수를 가져온다. <br>
     **/
    function inv_usd_dys_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Duration');
    }
    //Axon 이벤트 처리2. 이벤트처리함수 --- end

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {

        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction,delYn){
    	//필수 입력 등 Validation 체크
    	if(delYn != "D") {	//Duration인 경우 통과
    		if (!ComChkValid(formObj)) return false;
    	}
    	
    	if(formObj.flet_ctrt_no.value == "") {
 		   ComAlertFocus(formObj.flet_ctrt_no, ComGetMsg('FMS01052'));
 		   return;
    	} 
    	
        if(formObj.condition[2].checked) {
        	if(form.eff_dt.value == "") {
        		ComOpenPopup("ESM_FMS_0078.do?flet_ctrt_no=" + formObj.flet_ctrt_no.value, 500, 375, "setDuration", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0078");
				//ComAlertFocus(form.eff_dt, ComGetMsg('FMS01159'));
				return;
        	}
        } else {
        	if(delYn != "Y") {
	        	if(   ComChkPeriod(form.eff_dt.value.trimAll("-"), form.exp_dt.value.trimAll("-")) < 1
	        	   || form.inv_usd_dys.value == "") {
	        		if(delYn == "D") {
	        			ComShowMessage(ComGetMsg('FMS01159'));
	        		} else {
	        			if(form.eff_dt.value == "") {
	        				ComAlertFocus(form.eff_dt, ComGetMsg('FMS01159'));
	        			} else if(form.from_time.value == "") {
	        				ComAlertFocus(form.from_time, ComGetMsg('FMS01159'));
	        			} else if(form.exp_dt.value == "") {
	        				ComAlertFocus(form.exp_dt, ComGetMsg('FMS01159'));
	        			} else {
	        				ComAlertFocus(form.to_time, ComGetMsg('FMS01159'));
	        			}
	        		}
	    			return;
	    		}
        	}
        	
        	//Duration 공수 체크(0 보다 커야한다)
        	if(parseFloat(form.inv_usd_dys.value) <= 0) {
        		ComAlertFocus(form.to_time, ComGetMsg('FMS01175'));
        		return;
        	}
        	
        	var fromDate = formObj.eff_dt.value.trimAll("-") + formObj.from_time.value.trimAll(":");
        	var toDate = formObj.exp_dt.value.trimAll("-") + formObj.to_time.value.trimAll(":");
        	
        	if(   formObj.eff_dt.value != "" 
               && formObj.from_time.value != "") {
        		formObj.ori_eff_dt.value = fromDate;
            }
             
            if(   formObj.exp_dt.value != "" 
               && formObj.to_time.value != "") {
            	formObj.ori_exp_dt.value = toDate;
            }
            
            if(fromDate > toDate) {
            	if(formObj.condition[0].checked) {
            		ComAlertFocus(form.eff_dt, ComGetMsg('FMS01157'));
            	} else if(formObj.condition[1].checked) {
            		ComShowMessage(ComGetMsg('FMS01159'));
            	}
        		return;
        	}
        }
        
        if(delYn == "Y") {
        	var prefix = "inv_";
    		
        	//if (sheetObj.SearchRows <=0) return;

        	for (var ir=1; ir<=sheetObj.LastRow; ir++){
        		if(sheetObj.CellValue(ir, prefix+"slp_tp_cd") == "Y") {
        			ComShowMessage(ComGetMsg('FMS01160'));
        			return;
        			break;
        		}
        	}
        }

        return true;
    }
     
    /**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix = "oli_";
    	
		//width 비율로 조정
		sheetObj.FitColWidth("32|13|13|8|34");
		
		//2컬럼 글자색을 1컬럼 글자색으로 설정한다.
		sheetObj.ColFontColor(0) = sheetObj.WebColor("#532FC3");
		
		setInitCellProperty(sheetObj, prefix, "curr_cd", "otr_expn_amt", 4);
	}
	
	/**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string}  prefix     	변수 구분자
     * @param {string}  curSaveName currency saveName
     * @param {string}  amtSaveName amt saveName
     **/
    function setInitCellProperty(sheetObj, prefix, curSaveName, amtSaveName, col) {
   
		for(var ir=1; ir<=sheetObj.LastRow; ir++) {
			if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, prefix + curSaveName))) {
				if(col == null || col == "") {
					sheetObj.InitCellProperty(ir, 8, dtNull, daRight, prefix+ amtSaveName, "", dfNullInteger);
				} else {
					sheetObj.InitCellProperty(ir, col, dtNull, daRight, prefix+ amtSaveName, "", dfNullInteger);
				}
			}
		}
    }
    
    /**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix = "inv_";
		
    	if (sheetObj.SearchRows <=0) return;

    	for (var ir=1; ir<=sheetObj.LastRow; ir++){
    		if(sheetObj.CellValue(ir, prefix+"curr_cd") == "" || sheetObj.CellValue(ir, prefix+"slp_tp_cd") == "Y") {
    			sheetObj.CellEditable(ir, prefix+"inv_amt") = false;
    		}
    		
    		if(sheetObj.CellValue(ir, prefix+"curr_cd2") == ""  || sheetObj.CellValue(ir, prefix+"slp_tp_cd") == "Y") {
    			sheetObj.CellEditable(ir, prefix+"inv_amt2") = false;
    		}
    		
    		if(sheetObj.CellValue(ir, prefix+"slp_tp_cd") == "Y") {
    			sheetObj.CellEditable(ir, prefix+"DelChk") = false;
    		}
    		
    		if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, prefix + "curr_cd"))) {
				sheetObj.InitCellProperty(ir, 6, dtNull, daRight, prefix+ "inv_amt", "", dfNullInteger);
			}
    		
    		if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, prefix + "curr_cd2"))) {
				sheetObj.InitCellProperty(ir, 8, dtNull, daRight, prefix+ "inv_amt2", "", dfNullInteger);
			}
    	}
	}
     
    /**
     * IBSheet Grid의 입력값 중 숨겨지지 않은 가장 큰 값을 찾는다. <br>
     * @param {ibsheet} 	sheetObj    IBSheet Object
     * @return {arrExpDt} 	arrExpDt	가장 큰 To Date
     **/ 
 	function getMaxInvDtlSeq(sheetObj){
 		var arrInvDtlSeq = new Array();
 		var i = 0;
 		
 		for (var ir=sheetObj.HeaderRows; ir<=sheetObj.LastRow; ir++){
 			arrInvDtlSeq[i++] = parseInt(sheetObj.CellText(ir,"inv_inv_dtl_seq"));
 		}
 		
 		for(var j=0; j<arrInvDtlSeq.length; j++) {
 			for(var k=j; k<arrInvDtlSeq.length; k++) {
 				if(arrInvDtlSeq[j]<arrInvDtlSeq[k]) {
 					var tmp = arrInvDtlSeq[j];
 					arrInvDtlSeq[j] = arrInvDtlSeq[k];
 					arrInvDtlSeq[k] = tmp;
 				}
 			}
 		}
 		return arrInvDtlSeq[0];
 	}
    
    /**
     * Grid 의 Sum 계산하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @return {없음}
     **/
	function sheet2_OnChangeSum(sheetObj, Row) {
		sheetObj.SumText(0,"acct_cd") = "Total Amount";
		sheetObj.CellAlign(sheetObj.LastRow,"acct_cd") = daCenter;
	}
	
	/**
     * 화면 초기화 <br>
     * @param {String} flag   이벤트 flag
     * @return {없음}
     **/
	function clearAll(flag) {
    	initPreDuration();
    	
		var val;
		if(form.condition[0].checked) {
			val = form.condition[0].value; 
		} else {
			val = form.condition[1].value; 
		}
		
		if(flag != "DEL") {
			flag = "ALL";
		}

		setCondition(val, flag);
		
		sheetObjects[1].CheckAll("inv_DelChk") = 0;
		
		form.vsl_cd.readOnly = false;
		form.btn_vslpop.style.cursor = "hand";
		document.images["btn_vslpop"].name = "btn_vslpop";
		
		form.contract_no.style.cursor = "hand";
	    document.images["contract_no"].name = "contract_no";
	    
	    if(flag == "ALL" && flag == "DEL") {
	    	form.duration.style.cursor = "hand";
	    	document.images["duration"].name = "duration";
	    }
	    
	    effDt = "";
	    expDt = "";
	    
	    form.bunker_vvd.disabled = false;
	    
	    form.flet_offh_rsn_cd.disabled = false;
	    
	    setBunkerVvd('C');
	    
	    document.all.btn_delete2.style.display = "none";
	    
	    controlScrollBar();
	}
	
	/**
     * row 삭제하기. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @return {없음}
     **/
	function rowRemove(sheetObj, prefix) {
		var sRow = sheetObj.FindCheckedRow(prefix + "DelChk");
		if (sRow == "") return;
		
		//가져온 행을 배열로 반든다.
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		for (var idx=arrRow.length-2; idx>=0; idx--){
			var row = arrRow[idx];
			if(sheetObj.CellValue(row, prefix+"slp_tp_cd") == "Y") {
				//ComShowMessage("row : ["+row+"] 이미 전표가 생성되었습니다.");
				ComShowMessage(ComGetMsg('FMS01160'));
				sheetObj.CheckAll(prefix+"DelChk") = 0;
			} else {
				sheetObj.RowHidden(row)= true;
				sheetObj.RowStatus(row)= "D";
			}
		}
	}
	
	/**
     * Condition 변경에 따른 설정 <br>
     * @param {String} val    Condition 값
     * @param {String} flag   이벤트 flag 값
     * @see #ComResetAll
     *      #setDurationReadOnly
     * @return {없음}
     **/
	function setCondition(val, flag) {
    	initPreDuration();
    	
    	setPrintBtn("H");

		bunker_vvd = "";
		
		form.offh_seq.value = "";

		if(flag == "ALL" || flag == "DEL") {
			document.all.totalAmount.style.display = "none";

			ComResetAll();
			
			if(flag == "DEL") {
				durationReset();
			}

		} else {
			gridReset();
			
			durationReset();
		}
		
		sheetObjects[1].CheckAll("inv_DelChk") = 0;
		
		document.all.btn_delete2.style.display = "";
		
		if(val == "C") {
			
			form.eff_dt.readOnly    = false;
			form.from_time.readOnly = false;
			form.exp_dt.readOnly  = false;
			form.to_time.readOnly = false;

			form.acmm_flg.disabled = false;
			form.brog_flg.disabled = false;
			form.ef_dt.disabled = false;
			form.ex_dt.disabled = false;
			
			document.images["ef_dt"].name = "ef_dt";
        	document.images["ex_dt"].name = "ex_dt";
        	
			form.ef_dt.style.cursor = "hand";
			form.ex_dt.style.cursor = "hand";
			
			form.eff_dt.className    = "input";
	    	form.from_time.className = "input";
	    	form.exp_dt.className  = "input";
	    	form.to_time.className = "input";

	    	form.duration.style.cursor = "default";
	    	document.images["duration"].name = "no_duration";
			
			document.all.totalAmount.style.display = "none";
			
			form.inv_seq.value = "";
			
			durationReset();
			
		} else {
			if(flag == "ALL" || flag == "DEL") {
				form.eff_dt.readOnly    = false;
				form.from_time.readOnly = false;
				form.exp_dt.readOnly  = false;
				form.to_time.readOnly = false;

				form.acmm_flg.disabled = false;
				form.brog_flg.disabled = false;
				form.ef_dt.disabled = false;
				form.ex_dt.disabled = false;
				
				document.images["ef_dt"].name = "ef_dt";
	        	document.images["ex_dt"].name = "ex_dt";
	        	
				form.ef_dt.style.cursor = "hand";
				form.ex_dt.style.cursor = "hand";
				
				form.eff_dt.className    = "input";
		    	form.from_time.className = "input";
		    	form.exp_dt.className  = "input";
		    	form.to_time.className = "input";
		    	
		    	form.duration.style.cursor = "default";
		    	document.images["duration"].name = "no_duration";
		    	
		    	document.all.totalAmount.style.display = "none";
			} else {
				
				setDurationReadOnly(val);
				
				document.all.totalAmount.style.display = "none";
			}
		}
	}
	
	/**
	  * Vessel Code 입력부분.<br>
	  * @param {arry} aryPopupData
	  */
	function setVslCd(aryPopupData){
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기

//		form.vsl_cd.readOnly = true;
//		form.btn_vslpop.style.cursor = "default";
//		document.images["btn_vslpop"].name = "no_btn_vslpop";
		
		//선박 대 계약 자동 매치
		if(form.vsl_cd.value != ""){
			vsl_cd_change();
		}
	}
	
	/**
	 * Contract No 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value = aryPopupData[0][3];
		contract_no_change();
	}
	
	/**
	  * Duration 입력부분.<br>
	  * @param {arry} aryPopupData
	  */
	function setDuration(aryPopupData){
		form.inv_seq.value = aryPopupData[0][5];
		
		form.eff_dt.value = aryPopupData[0][7];
		form.from_time.value = aryPopupData[0][9];
		form.exp_dt.value = aryPopupData[0][8];
		form.to_time.value = aryPopupData[0][10];
		form.inv_usd_dys.value = aryPopupData[0][11];

		bunker_vvd = aryPopupData[0][6];
		
		var length = form.bunker_vvd.options.length;
    	
		if(length > 0) {
		    for(var i=0; i<length; i++){ 
		    	form.bunker_vvd.options.remove(0); 
		    }
		}
	    	
		setBunkerVvd(bunker_vvd);
		
		var flet_offh_rsn_cd = aryPopupData[0][4];
		
		var length = form.flet_offh_rsn_cd.length;
		
		if(length > 0) {
			for(var i=0; i<length; i++) {
				if(form.flet_offh_rsn_cd.options[i].value == flet_offh_rsn_cd) {
					form.flet_offh_rsn_cd.selectedIndex = i;
					break;
				}
			}
		}
		
	}
	
	/**
	  * Duration 입력부분(Off-Hire Expenses from VMS)<br>
	  * @param {arry} aryPopupData
	  */
	function setVmsDuration(aryPopupData){
		form.offh_seq.value = aryPopupData[0][16];

		var eff_dt = aryPopupData[0][3];
		var from_time = aryPopupData[0][4];
		var exp_dt = aryPopupData[0][5];
		var to_time = aryPopupData[0][6];
		var inv_usd_dys = aryPopupData[0][7];
		
		form.eff_dt.value = eff_dt.substring(0,4)+"-"+eff_dt.substring(4,6)+"-"+eff_dt.substring(6,8);
		form.from_time.value = from_time.substring(0,2)+":"+from_time.substring(2,4);
		form.exp_dt.value = exp_dt.substring(0,4)+"-"+exp_dt.substring(4,6)+"-"+exp_dt.substring(6,8);
		form.to_time.value = to_time.substring(0,2)+":"+to_time.substring(2,4);
		
		getInvUsdDys();
		/*
		if(inv_usd_dys.indexOf(".") == -1) {
			inv_usd_dys = inv_usd_dys+".0000";
		} 
		
		form.inv_usd_dys.value = inv_usd_dys;
		*/
		
		setBunkerVvd();
	}
	
	/**
     * Address Comm / Brokerage 설정 <br>
     * @return {없음}
     **/
	function declaration_click() {
    	if(form.acmm_flg.checked) {
    		if(   form.acmm_rt_amt.value == "" 
    		   || form.acmm_rt_amt.value <= 0) {
    			ComAlertFocus(form.acmm_flg, ComGetMsg('FMS01161'));
    			form.acmm_flg.checked = false;
    		} else {
    			form.acmm_flg.value = 'Y';
    		}
    	} else {
    		form.acmm_flg.value = 'N';
    	}
    	
    	if(form.brog_flg.checked) {
    		if(   form.flet_brog_rt_amt.value == "" 
     		   || form.flet_brog_rt_amt.value <= 0) {
     			ComAlertFocus(form.brog_flg, ComGetMsg('FMS01162'));
     			form.brog_flg.checked = false;
     		} else {
     			form.brog_flg.value = 'Y';
     		}
    	} else {
    		form.brog_flg.value = 'N';
    	}
    }
	
	/**
     * Hire No를 세팅한다 <br>
     * @param {ibsheet} comboObj    IBSheet Object
     * @param {String} 	comboNo    	comboNo
     * @param {String} 	comboText   combo Html String 값
     * @return {없음}
     **/
	function setCombo(comboObj, comboNo, comboText) {
		
        switch(comboObj.id) {
            case "pay_hir_no":    //HireNo
            	
            	comboObj.RemoveAll(); 
            	
            	comboObj.DropHeight = 80;
            	
            	if(comboText != "" ) {
	            	var comboList = comboText.split("|");
	            	
	            	for(var i=0; i < comboList.length-1; i++) {
	            		comboObj.InsertItem(i, comboList[i], comboList[i]);
	            	}
	            	
	            	comboObj.Code = comboList[0];
            	}

                break;
        } 
    }
	
	/**
     * Duration의 일수를 계산한다 <br>
     * @param {String} sFromDate    From Date
     * @param {String} sToDate   	To Date
     * @return {없음}
     * @see #getArgValue
     * 		#getDateObj
     **/
	function getInvUsdDys(sFromDate, sToDate) {
		
		if(!durationDayCheck()) return;
		
		var sFromDate = form.eff_dt.value.trimAll("-") + form.from_time.value.trimAll(":");
		var sToDate   = form.exp_dt.value.trimAll("-") + form.to_time.value.trimAll(":");
		
		try {
			//문자열 또는 HTML태그(Object)인 경우 처리
			var sFromDate = getArgValue(sFromDate);
			var sToDate   = getArgValue(sToDate);
			
			if(sFromDate.length != sToDate.length) return NaN;

			var iFromTime = getDateObj(sFromDate);
			var iToTime   = getDateObj(sToDate);

			var differTime = (iToTime - iFromTime) / (60*60*24*1000);

			form.inv_usd_dys.value = differTime.toFixed(4);
			
			//Duration(YYYY-MM-DD) 변경시 항차 정보 초기화
			if(form.condition[0].checked) {
				if(preEffDt != "") {
					if(   preEffDt != form.eff_dt.value.trimAll("-") 
					   || preExpDt != form.exp_dt.value.trimAll("-")) {

						var length = form.bunker_vvd.options.length;
				    	
						if(length > 0) {
						    for(var i=0; i<length; i++){ 
						    	form.bunker_vvd.options.remove(0); 
						    }
						}
					}
				}
			}
			
			return;
			
		} catch(err) {ComFuncErrMsg(err.message);}
	}
	
	/**
     * Duration 기간 체크 <br>
     **/
	function durationDayCheck() {
		
		if(   form.eff_dt.value == "" 
		   || form.from_time.value == ""
		   || form.exp_dt.value == ""
		   || form.to_time.value == "") {
			form.inv_usd_dys.value = "";
			return;
		}
    	
    	if(ComChkPeriod(form.eff_dt.value.trimAll("-"), form.exp_dt.value.trimAll("-")) < 1) {
    		ComShowMessage(ComGetMsg('FMS01159'));
			return;
		}
    	
    	return true;
	}
	
	/**
     * Duration 설정 <br>
     **/
	function setDurationReadOnly(val) {
			
		form.eff_dt.readOnly    = true;
		form.from_time.readOnly = true;
		form.exp_dt.readOnly  = true;
		form.to_time.readOnly = true;
		
		if(val == "V") {
			form.acmm_flg.disabled = false;
			form.brog_flg.disabled = false;
			form.inv_seq.value = "";
		} else {
			form.acmm_flg.disabled = true;
			form.brog_flg.disabled = true;
		}
		
		form.ef_dt.style.cursor = "default";
		form.ex_dt.style.cursor = "default";
		form.duration.style.cursor = "default";
		
    	document.images["ef_dt"].name = "no_ef_dt";
    	document.images["ex_dt"].name = "no_ex_dt";
    	document.images["duration"].name = "no_duration";
    	
    	form.eff_dt.className    = "input2";
    	form.from_time.className = "input2";
    	form.exp_dt.className  = "input2";
    	form.to_time.className = "input2";
    	/*
    	if(form.search_yn.value == "Y") {
    		form.contract_no.style.cursor = "default";
    		document.images["contract_no"].name = "no_contract_no";
    	}
*/
	    if(val == "I") {
	    	document.images["duration"].name = "duration";
	    	form.duration.style.cursor = "hand";
	    	
	    	form.bunker_vvd.disabled = false;
	    	form.flet_offh_rsn_cd.disabled = false;
	    } else {
	    	if(val == "C") {
	    		form.bunker_vvd.disabled = true;
	    		form.flet_offh_rsn_cd.disabled = true;
	    		
	    	} else {
	    		if(form.vsl_cd.value == "") {
					ComAlertFocus(form.vsl_cd, ComGetMsg('FMS01138'));
					form.condition[1].checked = false;
					return;
				} else if(form.flet_ctrt_no.value == "") {
					ComShowMessage(ComGetMsg('FMS01052'));
					form.condition[1].checked = false;
					return;
				}

	    		if(val == "V" || form.search_yn.value == "") {
		    		var flet_ctrt_no = form.flet_ctrt_no.value;
		    		var vsl_cd = form.vsl_cd.value;
		    		var vsl_eng_nm = form.vsl_eng_nm.value;
		    		
		    		ComOpenPopup("ESM_FMS_0073.do?flet_ctrt_no=" + flet_ctrt_no + "&vsl_cd=" + vsl_cd + "&vsl_eng_nm=" + vsl_eng_nm, 920, 480, "setVmsDuration", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0073");
	    		}
	    	}
	    }
	}
	
	/**
     * Date삭제 여부 결정 <br>
     * @return {boolean} okYn 삭제 여부
     **/
	function delConfirm() {
		var okYn = confirm(ComGetMsg('FMS01076'));
		
		return okYn;
	}
	
	/**
     * 저장함수에서 저장직전에 Vlidation을 체크하기 위해 호출되는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
	function sheet2_OnValidation(sheetObj,row,col,value) {
		var prefix = "inv_";
		
		var acctItmNmCol = sheetObj.SaveNameCol(prefix + "acct_itm_nm");
		var acctItmNmValue = sheetObj.CellText(row,acctItmNmCol);
		
		var invDtlSeqCol = sheetObj.SaveNameCol(prefix + "inv_dtl_seq");
		var invDtlSeqValue = sheetObj.CellText(row,invDtlSeqCol);
		
		if(acctItmNmValue == "") {
			ComShowMessage(ComGetMsg('FMS01164'));
			sheetObj.SelectCell(row,prefix + "acct_itm_nm");
			sheetObj.ValidateFail = true;
			return;
			
		} else if(invDtlSeqValue == "") {
			var invAmtCol = sheetObj.SaveNameCol(prefix + "inv_amt");
			var invAmtValue = sheetObj.CellText(row,invAmtCol).trimAll(",");
			
			var currCdCol = sheetObj.SaveNameCol(prefix + "curr_cd");
			var currCdValue = sheetObj.CellText(row,currCdCol);

			if(currCdValue == "") {
				ComShowMessage(ComGetMsg('FMS01077'));
				sheetObj.SelectCell(row,prefix + "curr_cd");
				sheetObj.ValidateFail = true;
			} else if(invAmtValue == "" || invAmtValue <= 0) {
				ComShowMessage(ComGetMsg('FMS01163'));
				sheetObj.SelectCell(row,prefix + "inv_amt");
				sheetObj.ValidateFail = true;
			}
			
			return;
		} else if(invDtlSeqValue != "") {
			//var prefix = "inv_";
			if(sheetObj.ColSaveName(col)==prefix + "inv_amt") {
				var invAmtCol = sheetObj.SaveNameCol(prefix + "inv_amt");
				var invAmtValue = sheetObj.CellText(row,invAmtCol).trimAll(",");
				
				var currCdCol = sheetObj.SaveNameCol(prefix + "curr_cd");
				var currCdValue = sheetObj.CellText(row,currCdCol);
				
				var sortKeyCol = sheetObj.SaveNameCol(prefix + "sort_key");
				var sortKeyValue = sheetObj.CellText(row,sortKeyCol);
				
				var firInvAmtCol = sheetObj.SaveNameCol(prefix + "fir_inv_amt");
				var firInvAmtValue = sheetObj.CellText(row,firInvAmtCol).trimAll(",");
	
				if(currCdValue != "" && (invAmtValue == "" || invAmtValue <= 0)) {
					if(sortKeyValue != "3" && firInvAmtValue == "") {
						ComShowMessage(ComGetMsg('FMS01163'));
						sheetObj.SelectCell(row,col);
						sheetObj.ValidateFail = true;
					} else if(sortKeyValue == "" && firInvAmtValue > 0) {
						ComShowMessage(ComGetMsg('FMS01163'));
						sheetObj.SelectCell(row,col);
						sheetObj.ValidateFail = true;
					} else {
						if(invAmtValue == "" || invAmtValue == 0) {
							ComShowMessage(ComGetMsg('FMS01171'));
							sheetObj.SelectCell(row,col);
							sheetObj.ValidateFail = true;
						}
					}
				} else if(currCdValue != "" && (invAmtValue == "" || invAmtValue > 0)) {
					if((sortKeyValue == "3" || firInvAmtValue < 0) && invAmtValue > 0) {
						ComShowMessage(ComGetMsg('FMS01171'));
						sheetObj.SelectCell(row,col);
						sheetObj.ValidateFail = true;
					}
				}
			} else if(sheetObj.ColSaveName(col)==prefix + "inv_amt2") {
				var invAmt2Col = sheetObj.SaveNameCol(prefix + "inv_amt2");
				var invAmt2Value = sheetObj.CellText(row,invAmt2Col).trimAll(",");
				
				var currCd2Col = sheetObj.SaveNameCol(prefix + "curr_cd2");
				var currCd2Value = sheetObj.CellText(row,currCd2Col);
				
				var sortKeyCol = sheetObj.SaveNameCol(prefix + "sort_key");
				var sortKeyValue = sheetObj.CellText(row,sortKeyCol);
				
				var firInvAmt2Col = sheetObj.SaveNameCol(prefix + "fir_inv_amt2");
				var firInvAmt2Value = sheetObj.CellText(row,firInvAmt2Col).trimAll(",");
				
				if(currCd2Value != "" && (invAmt2Value == "" || invAmt2Value <= 0)) {
					if(sortKeyValue != "3" && firInvAmt2Value == "") {
						ComShowMessage(ComGetMsg('FMS01163'));
						sheetObj.SelectCell(row,col);
						sheetObj.ValidateFail = true;
					} else if(sortKeyValue == "" && firInvAmt2Value > 0) {
						ComShowMessage(ComGetMsg('FMS01163'));
						sheetObj.SelectCell(row,col);
						sheetObj.ValidateFail = true;
					} else {
						if(invAmt2Value == "" || invAmt2Value == 0) {
							ComShowMessage(ComGetMsg('FMS01171'));
							sheetObj.SelectCell(row,col);
							sheetObj.ValidateFail = true;
						}
					}
				} else if(currCd2Value != "" && (invAmt2Value == "" || invAmt2Value > 0)) {
					if((sortKeyValue == "3" || firInvAmt2Value < 0) && invAmt2Value > 0) {
						ComShowMessage(ComGetMsg('FMS01171'));
						sheetObj.SelectCell(row,col);
						sheetObj.ValidateFail = true;
					}
				}
				
				/*
				if(currCd2Value != "" && (invAmt2Value == "" || invAmt2Value <= 0)) {
					ComShowMessage(ComGetMsg('FMS01163'));
					sheetObj.SelectCell(row,col);
					sheetObj.ValidateFail = true;
				}
				*/
			}
		}
	}
	
	/**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String} value    	sheetObj의 입력값
     **/
	function sheet2_OnChange(sheetObj,row,col,value) {
		invAmtOnChange(sheetObj,row,col,value);
		currencyOnChange(sheetObj,row,col,value,"inv_");
	}
	
	/**
     * 셀의 값이 변경되었을때 발생하는 이벤트(합 계산) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String} value    	sheetObj의 입력값
     **/
	function invAmtOnChange(sheetObj,row,col,value) {
		//if (value=="") return;

		if(sheetObj.RowStatus(row) == "I") return;
		
		var prefix = "inv_";
		var colAlias = sheetObj.ColSaveName(col);
		
		if (colAlias==(prefix + "inv_amt")) {
			var oriInvAmtCol = sheetObj.SaveNameCol(prefix + "ori_inv_amt");
			var oriInvAmtValue = sheetObj.CellText(row,oriInvAmtCol).trimAll(",");

			var invAmtCol = sheetObj.SaveNameCol(prefix + "inv_amt");
			var invAmtValue = sheetObj.CellText(row,invAmtCol).trimAll(",");
			
			var sortKeyCol = sheetObj.SaveNameCol(prefix + "sort_key");
			var sortKeyValue = sheetObj.CellText(row,sortKeyCol);
			
			var firInvAmtCol = sheetObj.SaveNameCol(prefix + "fir_inv_amt");
			var firInvAmtValue = sheetObj.CellText(row,firInvAmtCol).trimAll(",");
			
			var invDtlSeqCol = sheetObj.SaveNameCol(prefix + "inv_dtl_seq");
			var invDtlSeqValue = sheetObj.CellText(row,invDtlSeqCol);
			
			if(sortKeyValue != "3" && (invAmtValue == "" || invAmtValue <= 0)) {
				if(firInvAmtValue == "" || firInvAmtValue > 0) {
					ComShowMessage(ComGetMsg('FMS01163'));
					sheetObj.SelectCell(row,col);
					return;
				}
				
			} else if(sortKeyValue != "3" && (invAmtValue == "" || invAmtValue > 0)) {
				if(firInvAmtValue < 0) {
					ComShowMessage(ComGetMsg('FMS01171'));
					sheetObj.SelectCell(row,col);
					return;
				}
				
			} else if(sortKeyValue == "3" && (invAmtValue == "" || invAmtValue >= 0)) {
				ComShowMessage(ComGetMsg('FMS01171'));
				sheetObj.SelectCell(row,col);
				return;
			}
			
			if(sheetObj.CellText(row, prefix + "acct_cd") != "512641") {
				var currCdCol = sheetObj.SaveNameCol(prefix + "curr_cd");
				var currCdValue = sheetObj.CellText(row,currCdCol).toLowerCase();
				
				var totalAmount = eval("form."+currCdValue+"_inv_amt").value.trimAll(",");

				var totalInvAmount = parseFloat(totalAmount)-parseFloat(oriInvAmtValue)+parseFloat(invAmtValue);
				
				totalInvAmount = ComAddComma(totalInvAmount.toFixed(2));
				
				if(totalInvAmount.indexOf(".") == -1) {
					totalInvAmount = totalInvAmount+".00";
				} else {
					var lastIndex = totalInvAmount.lastIndexOf(".");
					var floatVal = totalInvAmount.substring(lastIndex+1,totalInvAmount.length);
					if(floatVal.length == 1) {
						totalInvAmount = totalInvAmount+"0";
					}
				}

				if(ComFmsCheckCurrencyYn(sheetObj.CellValue(row, prefix + "curr_cd"))) {
					eval("form."+currCdValue+"_inv_amt").value = ComAddComma(parseInt(totalInvAmount.trimAll(",")));
				} else {
					eval("form."+currCdValue+"_inv_amt").value = totalInvAmount;
				}
				sheetObj.CellText(row,oriInvAmtCol) = invAmtValue;
			}

		} else {
			var oriInvAmt2Col = sheetObj.SaveNameCol(prefix + "ori_inv_amt2");
			var oriInvAmt2Value = sheetObj.CellText(row,oriInvAmt2Col).trimAll(",");

			var invAmt2Col = sheetObj.SaveNameCol(prefix + "inv_amt2");
			var invAmt2Value = sheetObj.CellText(row,invAmt2Col).trimAll(",");
			
			var sortKeyCol = sheetObj.SaveNameCol(prefix + "sort_key");
			var sortKeyValue = sheetObj.CellText(row,sortKeyCol);
			
			var firInvAmt2Col = sheetObj.SaveNameCol(prefix + "fir_inv_amt2");
			var firInvAmt2Value = sheetObj.CellText(row,firInvAmt2Col).trimAll(",");
			
			var invDtlSeqCol = sheetObj.SaveNameCol(prefix + "inv_dtl_seq");
			var invDtlSeqValue = sheetObj.CellText(row,invDtlSeqCol);
			
			if(sortKeyValue != "3" && (invAmt2Value == "" || invAmt2Value <= 0)) {
				if(firInvAmt2Value == "" || firInvAmt2Value > 0) {
					ComShowMessage(ComGetMsg('FMS01163'));
					sheetObj.SelectCell(row,col);
					return;
				}
				
			} else if(sortKeyValue != "3" && (invAmt2Value == "" || invAmt2Value > 0)) {
				if(firInvAmt2Value < 0) {
					ComShowMessage(ComGetMsg('FMS01171'));
					sheetObj.SelectCell(row,col);
					return;
				}
				
			} else if(sortKeyValue == "3" && (invAmt2Value == "" || invAmt2Value >= 0)) {
				ComShowMessage(ComGetMsg('FMS01171'));
				sheetObj.SelectCell(row,col);
				return;
			}
			
			if(sheetObj.CellText(row, prefix + "acct_cd") != "512641") {
				var currCd2Col = sheetObj.SaveNameCol(prefix + "curr_cd2");
				var currCd2Value = sheetObj.CellText(row,currCd2Col).toLowerCase();
				
				var totalAmount = eval("form."+currCd2Value+"_inv_amt2").value.trimAll(",");

				var totalInvAmount = parseFloat(totalAmount)-parseFloat(oriInvAmt2Value)+parseFloat(invAmt2Value);
				
				totalInvAmount = ComAddComma(totalInvAmount.toFixed(2));
				
				if(totalInvAmount.indexOf(".") == -1) {
					totalInvAmount = totalInvAmount+".00";
				} else {
					var lastIndex = totalInvAmount.lastIndexOf(".");
					var floatVal = totalInvAmount.substring(lastIndex+1,totalInvAmount.length);
					if(floatVal.length == 1) {
						totalInvAmount = totalInvAmount+"0";
					}
				}
				
				if(ComFmsCheckCurrencyYn(sheetObj.CellValue(row, prefix + "curr_cd2"))) {
					eval("form."+currCd2Value+"_inv_amt2").value = ComAddComma(parseInt(totalInvAmount.trimAll(",")));
				} else {
					eval("form."+currCd2Value+"_inv_amt2").value = totalInvAmount;
				}
				sheetObj.CellText(row,oriInvAmt2Col) = invAmt2Value;
			}
			
			/*
			if(invAmt2Value == "" || invAmt2Value <= 0) {
				ComShowMessage(ComGetMsg('FMS01163'));
				sheetObj.SelectCell(row,col);
				return;
			}
			
			var currCd2Col = sheetObj.SaveNameCol(prefix + "curr_cd2");
			var currCd2Value = sheetObj.CellText(row,currCd2Col).toLowerCase();
			
			var totalAmount = eval("form."+currCd2Value+"_inv_amt2").value.trimAll(",");
	
			var totalInvAmount = parseFloat(totalAmount)-parseFloat(oriInvAmt2Value)+parseFloat(invAmt2Value);

			totalInvAmount = ComAddComma(totalInvAmount.toFixed(2));

			if(totalInvAmount.indexOf(".") == -1) {
				totalInvAmount = totalInvAmount+".00";
			} else {
				var lastIndex = totalInvAmount.lastIndexOf(".");
				var floatVal = totalInvAmount.substring(lastIndex+1,totalInvAmount.length);
				if(floatVal.length == 1) {
					totalInvAmount = totalInvAmount+"0";
				}
			}

			eval("form."+currCd2Value+"_inv_amt2").value = totalInvAmount.toFixed(2);
			sheetObj.CellText(row,oriInvAmt2Col) = invAmt2Value;
			*/
		}
	}
	
	/**
     * IBSheet 입력값 중 Currency Code값의 존재 여부를 판단하다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String} 	value    	sheetObj의 입력값
     * @param {String} 	prefix   	변수 구분값
     * @return {없음}
     * @see #setCurrCd
     **/
    function currencyOnChange(sheetObj,row,col,value,prefix) {
			
    	if (sheetObj.ColSaveName(col)==(prefix + "curr_cd")) {
            var currCdCol = sheetObj.SaveNameCol(prefix + "curr_cd");
            var currCdValue = sheetObj.CellValue(row,currCdCol);
            
            if(currCdValue == "") return;
            
            if(currCdValue.length < 3) {
    			ComShowMessage(ComGetMsg('FMS01077'));
	    		sheetObj.CellValue2(row,currCdCol) = "";
				sheetObj.SelectCell(row,currCdCol);
				return;
    		}
    		
    		form.curr_cd.value = currCdValue;
    		
    		doActionIBSheet(sheetObjects[1], document.form, IBROWSEARCH, "currCd", row);
    	}
	}
	

	/**
     * 데이타 조회시 스크롤바를  자동으로 컨트롤한다 <br>
     **/
	function controlScrollBar() {
		try{
			top.syncHeight()
		} catch(err){ComFuncErrMsg(err.message);}
	}
	
	/**
     * 이벤트 발생시 실행여부 확인 <br>
     * @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
     **/
    function initConfirm() {
    	var okYn = true;

    	//if(sheetObjects[0].RowCount > 0 && rowChangeYn()) {
    	if(sheetObjects[1].isDataModified) {
    		
    		var okYn = confirm(ComGetMsg('FMS00002'));
    	}
    	
    	return okYn;
    }
    
    /**
     * 이벤트 발생시 항차 정보를 가져온다 <br>
     * @param {String} flag    	초기화 여부(I)
     * @see #CoFmsGetBizCombo
     **/
    function setBunkerVvd(flag) {
    	if(!checkDuration()) return;

    	var changeYn = "Y";
    	
    	var curEffDt = form.eff_dt.value;
    	var curExpDt = form.exp_dt.value;
    	
    	var length = form.bunker_vvd.options.length;

    	if(!form.condition[0].checked) {
    		if(curEffDt != "" && length != 0) return;
    	}
    	
    	if(curEffDt != "") {
	    	if(effDt == curEffDt && expDt == curExpDt) {
	    		changeYn = "N";
	    	}
    	}

    	//var length = form.bunker_vvd.options.length;
    	
    	if(flag == "C" && changeYn == "Y") {
	    	for(var i=0; i<length; i++){ 
	    		form.bunker_vvd.options.remove(0); 
	    	}
	    	return;
    	} else {
    		if(length > 0) return;
    	}
    	
    	CoFmsGetBizCombo('FORM', document.form, sheetObjects[0], 'bunker_vvd', 'bunker_vvd_text', '2', 'ESM_FMS_0014GS.do', 'FMS01232');
    	
    	//최초 Duration 값 세팅
    	if(form.condition[0].checked) {
    		preEffDt = form.eff_dt.value.trimAll("-");
        	preExpDt = form.exp_dt.value.trimAll("-");
    	}
    
    	if(typeof flag != "undefined") {

	    	if(flag.length == 10) {
	    		
    			for(var i=0; i<flag.length; i++) {
    				if(form.bunker_vvd.options[i].value == flag) {
    					form.bunker_vvd.selectedIndex = i;
    					break;
    				}
    			}
	    	}
    	}
    }
    
    /**
     * Popup호출하기(Item Name) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @see #setProgramNo
     **/
	function sheet2_OnPopupClick(sheetObj,Row,Col){
		if(sheetObj.RowStatus(Row) == "I") {
			ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=OF", 550, 455, "setProgramNo", "1,0,1,1,1,1", false, false, Row, Col, 0);
		} else {
			//ComShowMessage("Item Name은 변경할 수 없습니다");
			return;
		}
	}
	
	/**
	 * programNo 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setProgramNo(aryPopupData, row, col, sheetIdx){
		sheetObjects[1].CellValue2(row,col) = aryPopupData[0][2];
	    sheetObjects[1].Cellvalue2(row,"inv_acct_cd") = aryPopupData[0][3];
	    sheetObjects[1].Cellvalue2(row,"inv_acct_itm_seq") = aryPopupData[0][4];
	}
	
	/**
     * document 안에 있는 모든 Object의 값을 초기화한다. <br>
     * IBSheet.RemoveAll()처리한다.<br>
     * @return 없음
     * @see #ComClearManyObjects
     */
    function gridReset(){

        try {
        	sheetObjects[1].RemoveAll();
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * document 안에 있는 ComboBox를 초기화한다.(VVD CD/Accident Type)<br>
     * @return 없음
     * @see #ComClearManyObjects
     */
    function comboReset(){

        try {
        	var length = form.bunker_vvd.options.length;
        	
	    	for(var i=0; i<length; i++){ 
	    		form.bunker_vvd.options.remove(0); 
	    	}
    	    	
        	form.flet_offh_rsn_cd.selectedIndex = 0;
        	
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * document 안에 있는 Duration관련 Object의 값을 초기화한다. <br>
     * @return 없음
     */
    function durationReset() {
    	form.eff_dt.value = "";
    	form.from_time.value = "";
    	form.exp_dt.value = "";
    	form.to_time.value = "";
    	form.inv_usd_dys.value = "";
    	
    	var length = form.bunker_vvd.options.length;
  
    	for(var i=0; i<length; i++){ 
    		form.bunker_vvd.options.remove(0); 
    	}
	    	
    	form.flet_offh_rsn_cd.selectedIndex = 0;
    }
    
    /**
     * Duration 정보가 입력되었는지 체크 <br>
     * @return boolean true:입력, false:미입력
     */
    function checkDuration() {
    	if(form.inv_usd_dys.value != "") {
    		return true;
    	} else {
    		return false;
    	}
    }
     
    /**
     * 저장할 데이타가 있는지 체크 <br>
     * @return boolean true:존재, false:미존재
     */ 
    function gridDataCount() {
    	if(sheetObjects[1].RowCount > 0) {
    		for(var ir=1; ir<=sheetObjects[1].LastRow; ir++) {
				if(sheetObjects[1].RowHidden(ir)==false) {
					return true;
					break;
				}
			}
    		return false;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Print 버튼 Control하기 <br>
     */ 
    function setPrintBtn(flag) {
    	if(flag == "H") {
    		document.all.btn_print.style.display = "none";
    	} else {
	    	if(form.condition[2].checked && sheetObjects[1].RowCount > 0) {
	    		document.all.btn_print.style.display = "";
	    	}
    	}
    }
    
    /**
     * History Duration 정보 초기화 <br>
     */ 
    function initPreDuration() {
    	preEffDt = "";
    	preExpDt = "";
    }
    
    /**
     * RD 출력 <br>
     * @param  {ibsheet} rdObject    IBSheet Object
     * @param  {Object}  formObject  FormObject 값
     * @return {없음}
     **/
	function rdOpen(rdObject,formObject){
		var Rdviewer = rdObject ;

		//Accident Type
		formObject.flet_offh_rsn_nm.value = formObject.flet_offh_rsn_cd.options[formObject.flet_offh_rsn_cd.selectedIndex].text;

		queryStr = RD_FormQueryString(formObject,1);
		
		var rdParam = '/rv '+queryStr;

		var rdFile = 'ESM_FMS_015.mrd';

		// 열고자 하는 RD 파일을 지정한다.
	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioinvoice/report/'+rdFile, RDServer + rdParam + " /rop /rprintnexit ");
		
	}	
    
	//선박 대 계약 자동 매치
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }