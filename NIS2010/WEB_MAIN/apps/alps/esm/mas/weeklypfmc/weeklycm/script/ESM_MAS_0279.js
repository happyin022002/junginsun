/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_MAS_0279.js
*@FileTitle : DEM/DET Cost Report by BKG (Detail)
*Open Issues :
*@LastModifyDate : 2015-03-17
*@LastModifier : Je Ryang Yoo
*@LastVersion :
*  2015-03-17 Je Ryang Yoo
*  1.0 최초 생성
*  
*  History
*  2016.03.08 조회조건 추가
=========================================================*/

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @extends 
	 * @class ESM_MAS_0279 : ESM_MAS_0279 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_MAS_0279() {
	    this.processButtonClick    = processButtonClick;
	    this.loadPage              = loadPage          ;
	    this.initSheet             = initSheet         ;
    	this.initCombo 			   = initCombo         ;
    	this.initControl           = initControl       ;
	    this.setSheetObject        = setSheetObject    ;
	    this.doActionIBSheet       = doActionIBSheet   ;
	    this.validateForm          = validateForm      ;
	}

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var loadingMode = false;
	
	var EXCEL_LOAD_FLG = false;	//엑셀 로드 실행체크
	var sRow = 0;
	
	/** 
	 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  
	 */
	document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
	           	case "btns_calendar": //달력 버튼
					var cal = new ComCalendarFromTo();
					cal.select(formObject.f_fmyearmonth, formObject.f_toyearmonth, 'yyyy-MM-dd');
					break;
				
                case "btn_Retrieve":
                	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                    
                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;
                    
                case "btn_close":
					window.close();
					break;
                case "f_bkgno" :
                case "f_cntrno" :
                case "btns_multisearch1":
//                case "f_bnd_cd" :
//                case "f_cntr_tpsz_cd" :
//                case "f_cntr_sts" :
                case "f_items" :
	                	resetDtArea();
	                break;

                case "f_fmyearmonth" :
                case "f_toyearmonth" :
//                case "f_sc_no" :
//                case "f_rfa_no" :
//                case "f_por_no" :
//                case "f_del_no" :
	                	resetBkgArea();
	                break;
              /*
				case "btn_New":
                    doActionIBSheet(sheetObject,formObject,IBRESET);
                    break;
                    
                case "btn_Save":    	
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                    
                case "btn_Loadexcel":
                    doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                    break;
                    
                case "btn_Rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
        	        
                case "btn_Rowdelete":
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;
                       
				case "btn_rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;
                    
                case "btn_Rowdelete":
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;
                
                case "btng_copyfrompast":
                    break;
                                        
                case "btn_Loadexcel":
                    doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                    break;

                case "btn_Create":
                    doActionIBSheet(sheetObject,formObject,IBCREATE);
                    break;
                    
                case "btn_rowadd":                	     
                	sheetObject.DataInsert(-1);
                    break;
                    
                case "btn_rowdel":                	   
					if(sheetObject.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObject,"del_chk");
					} else {
						ComShowCodeMessage("MNR00150");
					}
                    break;*/           
        
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
        	ComOpenWait(false);
        }        
    }
    
    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 CATCH 한다. <br>
     */
    function initControl() {
        //Axon 이벤트 처리1. 이벤트 catch
        axon_event.addListenerForm('focus', 'obj_focus', form);
    }
    
    function chk_WM(param1, param2) {
    	var formObj = document.form;
    	if (formObj.f_chkprd[1].checked) {
    		formObj.f_chkbkg.checked = false;
    		formObj.f_node.className = "input1";
    		formObj.f_por_no.className = "input1";
    		formObj.f_del_no.className = "input1";
    		formObj.f_bkgno.className = "input";  
    	} else if (formObj.f_chkprd[0].checked) {
    		formObj.f_chkbkg.checked = false;
    		formObj.f_node.className = "input";
    		formObj.f_por_no.className = "input";
    		formObj.f_del_no.className = "input";
    		formObj.f_bkgno.className = "input";  
    	}
    	if (param1 == 'W') {
            document.all.div_week.style.display = "inline";
            document.all.div_month.style.display = "none";
            document.all.div_from.style.display="none";
            document.all.div_mw.style.display="inline";
            document.all.f_to_wk.style.display = "inline"; //setPeriod(document.form.f_to_wk);
            document.all.f_fm_wk.style.display="inline";
            setPeriod(document.form.f_to_wk);
    	}else if (param1 == 'F') {
            document.all.div_week.style.display = "none";
            document.all.div_month.style.display = "none";
            document.all.div_from.style.display="inline";
            document.all.div_mw.style.display="none";
            document.all.f_to_wk.style.display = "none"; //setPeriod(document.form.f_to_wk);
            document.all.f_fm_wk.style.display="none";
            document.all.f_to_mon.style.display = "none";
        } else {
            document.all.div_week.style.display = "none";
            document.all.div_month.style.display = "inline";
            document.all.div_mw.style.display="inline";
            document.all.div_from.style.display="none";
            document.all.f_to_wk.style.display = "none"; //setPeriod(document.form.f_to_wk);
            document.all.f_fm_wk.style.display="none";
            if (param2 == '1') {
                setPeriod(document.form.f_to_mon);
            	//setPeriod(document.form.f_fm_mon);
            } else {
                setPeriod(document.form.f_mon);
            }
        }  	
    }
    
    /**
     * OnFocus 이벤트 발생시 호출되는 function
     */
   	function obj_focus() {
   		var formObj = document.form;
   		if (event.srcElement.name == "f_year" || event.srcElement.name == "f_fm_mon" || 
   				event.srcElement.name == "f_fm_wk" || event.srcElement.name == "f_to_wk") {
   	        formObj.f_bkgno.className = "input";
   	        formObj.f_fmyearmonth.className = "input";
	        formObj.f_toyearmonth.className = "input";
	        formObj.f_fmyearmonth.value = "";
	        formObj.f_toyearmonth.value = "";
   	        formObj.f_year.className    = "input1";
   	        formObj.f_fm_mon.className  = "input1";
   	        //formObj.f_to_mon.className  = "input1";
   	        formObj.f_fm_wk.className   = "input1";
   	        formObj.f_to_wk.className   = "input1";
   	    	if (formObj.f_chkprd[1].checked) {
   	    		formObj.f_node.className   = "input1";
   	    		formObj.f_por_no.className = "input1";
   	    		formObj.f_del_no.className = "input1";
   	    	} else if (formObj.f_chkprd[0].checked) {
   	    		formObj.f_node.className   = "input";
   	    		formObj.f_por_no.className = "input";
   	    		formObj.f_del_no.className = "input";
   	    	}
   		} else if (event.srcElement.name == "f_bkgno") {
   			formObj.f_bkgno.className  = "input1";
   			formObj.f_year.className   = "input";
   	        formObj.f_fm_mon.className = "input";
   	        //formObj.f_to_mon.className = "input";
   	        formObj.f_fm_wk.className  = "input";
   	        formObj.f_to_wk.className  = "input";
   	        formObj.f_node.className   = "input";
   	        formObj.f_por_no.className = "input";
    		formObj.f_del_no.className = "input";
   	        formObj.f_fmyearmonth.className = "input";
   	        formObj.f_toyearmonth.className = "input";
   	        formObj.f_year.value = "";
	        formObj.f_fm_mon.value = "";
	        formObj.f_to_mon.value = "";
	        formObj.f_fm_wk.value = "";
	        formObj.f_to_wk.value = "";
	        //formObj.f_fmyearmonth.value = "";
	        //formObj.f_toyearmonth.value = "";
	        document.getElementById("div_period").innerHTML = "";
   		} else if (event.srcElement.name == "f_fmyearmonth"  || event.srcElement.name == "f_toyearmonth") {
   			formObj.f_fmyearmonth.className = "input1";
   	        formObj.f_toyearmonth.className = "input1";
   			formObj.f_bkgno.className  = "input";
   			formObj.f_year.className   = "input";
   	        formObj.f_fm_mon.className = "input";
   	        //formObj.f_to_mon.className = "input";
   	        formObj.f_fm_wk.className  = "input";
   	        formObj.f_to_wk.className  = "input";
   	        formObj.f_node.className   = "input";
   	        formObj.f_por_no.className = "input";
   	        formObj.f_del_no.className = "input";
   	        //formObj.f_bkgno.value = "";
   	        formObj.f_year.value = "";
	        formObj.f_fm_mon.value = "";
	        formObj.f_to_mon.value = "";
	        formObj.f_fm_wk.value = "";
	        formObj.f_to_wk.value = "";
	        document.getElementById("div_period").innerHTML = "";
   		}
   	}

    /**
     * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
     */
    function setPeriod(obj) {
    	ComMasSetPeriod0279(obj);
    }

    function changeCostYrmon(val){
        //if(val != '') chgOffice(document.form.f_ofc_lvl);
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
    	loadingMode = true;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
        
        //loadingMode = false;
        
        //ComSetFocus(document.form.f_bkgno);
        //initControl();
        //formObj.f_bkgno.className = "input1";
        
        var popMode = formObj.popMode.value;
        if(popMode == "Y"){
        	var fTpsz = formObj.f_tpsz.value;
        	var fStatus = formObj.f_status.value;
        	//alert(fTpsz + ", " + fStatus);
        	for(k=0;k<comboObjects.length;k++){
            	initCombo(comboObjects[k],comboObjects[k].id, fTpsz, fStatus);
        	}
        	
        	var pChkprd = formObj.p_chkprd.value;
            var pYear   = formObj.p_year.value;
            var pFm_mon = formObj.p_fm_mon.value;
            //var pTo_mon = formObj.p_to_mon.value;
            var pFm_wk  = formObj.p_fm_wk.value;
            var pTo_wk  = formObj.p_to_wk.value;
            //alert(pChkprd + " " + pYear + " " + pFm_mon + " " + pTo_mon + " " + pFm_wk + " " + pTo_wk);
        	if(pChkprd == "M"){
        		formObj.f_chkprd[1].checked = true;
        		chk_WM('M','1');
        		formObj.f_year.value        = pYear;
        		formObj.f_fm_mon.value      = pFm_mon;
        		//formObj.f_to_mon.value      = pTo_mon;
        		setPeriod(this);
        		//changeCostYrmon(this.value);
        	} else {
        		chk_WM('W','1');
        		formObj.f_chkprd[0].checked = true;
        		formObj.f_year.value        = pYear;
        		formObj.f_fm_wk.value      = pFm_wk;
        		formObj.f_to_wk.value      = pTo_wk;
        		setPeriod(this);
        		//changeCostYrmon(this.value);
        	}        	
        	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
        } else {
        	for(k=0;k<comboObjects.length;k++){
            	initCombo(comboObjects[k],comboObjects[k].id, fTpsz, fStatus);
        	}
        }
        
        initControl();
        loadingMode = false;
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
            		//style.height = 202;
                    SheetWidth = sheetTable.clientWidth; //전체 너비 설정
            		//SheetWidth = 400; //전체 너비 설정
                    
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 2, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    
                    var HeadTitle1  = "|STS|R.Month|WK|BKG|CNTR|TPSZ|Div|Item_Name|Item|Tariff|Fm Yard|To Yard|From MVMT|To MVMT|From Date|To Date|Status|F/T End Date|Incurred Rev|Billable Rev|Invoiced Rev|Staying Day|PDM|Cost within\nF/T|Cost after\nF/T|Cost Total|CHZ Term|BKG POR|BKG DEL|S/C|S/C Cust Name|RFA|RFA Cust Name|R.TERM|D.TERM";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 10, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false); 
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(0, HeadTitle1, true);    				
                    
                    //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtHidden,       30,     daCenter,   true,    "");
                    InitDataProperty(0,     cnt++,  dtHiddenStatus, 30,     daCenter,   false,   "ibflag");                    
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,    "cost_yrmon",       	false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         40,     daCenter,   true,    "cost_wk",      	    false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         90,     daCenter,   true,    "bkg_no",       		false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,    "cntr_no",       		false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         40,     daCenter,   true,    "cntr_tpsz_cd",       	false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         60,     daLeft,   true,      "div_nm",       		false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtHidden,       70,     daCenter,   true,    "itm_nm",       		false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,        150,     daLeft,   true,      "itm_desc",       		false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daLeft,   true,      "trf_cd",       		false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         60,     daCenter,   true,    "cntr_fm_nod_cd",      false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         60,     daCenter,   true,    "cntr_to_nod_cd",      false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         70,     daCenter,   true,    "cntr_fm_mvmt_sts_cd", false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         60,     daCenter,   true,    "cntr_to_mvmt_sts_cd", false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         70,     daCenter,   true,    "cntr_fm_dt",       	false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         70,     daCenter,   true,    "cntr_to_dt",       	false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         70,     daCenter,   true,    "cntr_sts",       	    false,   "",   dfNone,     0,  true,  true);
//                    InitDataProperty(0,     cnt++,  dtData,         60,     daCenter,   true,    "ft_dys",       		false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         90,     daCenter,   true,    "ft_end_dt",       	false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daRight,    true,    "org_chg_amt",       	false,   "",   dfInteger,  0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daRight,    true,    "bil_amt",       		false,   "",   dfInteger,  0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daRight,    true,    "inv_chg_amt",       	false,   "",   dfInteger,  0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daRight,   true,     "stay_dys",       		false,   "",   dfFloat,     3,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         40,     daRight,   true,     "pd_rt_amt",       	false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         70,     daRight,   true,     "cost_wthn_ft_amt",    false,   "",   dfFloat,     4,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         70,     daRight,   true,     "cost_aft_ft_amt",     false,   "",   dfFloat,     4,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         70,     daRight,   true,     "cost_ttl_amt",        false,   "",   dfFloat,     4,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         70,     daCenter,   true,    "chss_term_cd",        false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         55,     daCenter,   true,    "por_cd",       		false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         55,     daCenter,   true,    "del_cd",       		false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         75,     daCenter,   true,    "sc_no",       		false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,    "sc_cust_nm",       	false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         75,     daCenter,   true,    "rfa_no",       		false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,    "rfa_cust_nm",       	false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         50,     daCenter,   true,    "rcv_term_cd",       	false,   "",   dfNone,     0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,         50,     daCenter,   true,    "de_term_cd",       	false,   "",   dfNone,     0,  true,  true);
                    
                    /*InitDataValid(0, "bkg_no",    vtEngUpOther, "1234567890");
                    InitDataValid(0, "cntr_no",   vtEngUpOther, "1234567890");
                    InitDataValid(0, "tpsz_cd",   vtEngUpOther, "1234567890");
                    InitDataValid(0, "term_cd",   vtEngUpOther, "1234567890");
                    InitDataValid(0, "mvmt_cd",   vtEngUpOther, "1234567890");
                    //InitDataValid(0, "onh_dt",    vtNumericOnly);
                    InitDataValid(0, "onh_yd_cd", vtEngUpOther, "1234567890");
                    //InitDataValid(0, "offh_dt",   vtNumericOnly);
                    InitDataValid(0, "offh_yd_cd",vtEngUpOther, "1234567890");*/
                    
                    CountPosition = 0;
                    
                    sheetObj.style.height = 390; //sheetObj.GetSheetHeight(13);                    
                    //Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시 (업로드시)
                    EditableColorDiff = true;
                    WaitImageVisible = false;
                }
                break;
        }
    }
    
    /**
     * 콤보 항목을 설정한다. 
     */
    function initCombo (comboObj, comboId, fTpsz, fStatus) {
    	var formObj = document.form;
    	var popMode = formObj.popMode.value;
    	
    	with (comboObj) {
    		switch(comboObj.id) {
				case "f_cntr_tpsz_cd":
					DropHeight = 430;
					SetColWidth("50");
					ValidChar(2, 1);	//영문대문자+숫자
					InsertItem(0, "All");
					MaxLength = 2;
					if(popMode == "Y"){
						comboObj.Code = fTpsz;
					} else {
						Index = 0;
					}					
					break;
				
				case "f_cntr_sts":
					SetColWidth("70");
					InsertItem(0, "All", "A");
					InsertItem(1, "Finish", "F");
					InsertItem(2, "Unfinish", "U");
					/*if(popMode == "Y"){
						comboObj.Code = fStatus;
					} else {
						Index = 0;
					}*/
					Index = 0;
					break;
					
				case "f_bnd_cd":
					SetColWidth("70");
					InsertItem(0, "All");
					InsertItem(1, "I/B", "I");
					InsertItem(2, "O/B", "O");
					/*if(popMode == "Y"){
						comboObj.Code = fStatus;
					} else {
						Index = 0;
					}*/
					Index = 0;
					break;

				case "f_items":
					DropHeight = 150;
					SetColWidth("170");
					InsertItem(0, "All");
					InsertItem(1, "Rail Storage", "RAIL_STO");
					InsertItem(2, "Marine Storage", "MRN_STO");
					InsertItem(3, "Container EQ Cost", "CNTR_EQ");
					InsertItem(4, "RF Handling Charge", "RF_HNDL");
					InsertItem(5, "Chassis EQ Cost (On Street)", "CHSS_ST");
					InsertItem(6, "Chassis EQ Cost (Common)", "CHSS_COM");
					InsertItem(7, "DEMDET Revenue", "REV");
					/*if(popMode == "Y"){
						comboObj.Code = fStatus;
					} else {
						Index = 0;
					}*/
					Index = 0;
					break;
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
     * 
     */
    /*function sheet1_OnChange(sheetObj, row, col, value){
        var formObj = document.form;
        
        if(sheetObj.ColSavename(col) == "nod_cd"){
            if(sheetObj.CellValue(row,"nod_cd") != ""){
//           	var param = "f_cmd="+COMMAND02;
//         		param = param + "&f_slan_cd="+value;
//				var sXml = sheetObj.GetSearchXml("ESM_MAS_0279GS.do", param);
//				var arrXml = sXml.split("|$$|");
//				isValidSlane(row,ComMasGetEtcData(arrXml[0], "rtnValue"));
				
				formObj.f_cmd.value = COMMAND02;                        
				formObj.nod_cd.value = sheetObj.CellValue(row, "nod_cd");
	        	var sXml = sheetObj.GetSearchXml("ESM_MAS_0279GS.do","",masFormQueryString(formObj),true);
	        	var etcNodNm = ComGetEtcData(sXml, "etcNodNm"); 
	        	var etcCtrlOfcCd = ComGetEtcData(sXml, "etcCtrlOfcCd");        	
	        	sheetObj.CellValue(row, "nod_nm") = etcNodNm;
	        	sheetObj.CellValue(row, "ctrl_ofc_cd") = etcCtrlOfcCd;
            }
        } 
    }*/
    
    /*function sheet1_OnSearchEnd(sheetObj, errMsg){
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,"cost_yrmon") = "TOTAL";        
    }*/

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var popMode = formObj.popMode.value;
        
        switch(sAction) {         
			case IBCLEAR:          //조회
				formObj.f_year.value   = ComGetNowInfo("yy");
		        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.Redraw = false; 
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0279GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");				
				formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
		        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_cntr_tpsz_cd, "code", "code");
				
				sheetObj.Redraw = true;
				ComOpenWait(false);
				break;
				
			case IBSEARCH:              //조회
				formObj.f_cmd.value = SEARCH;
				if(popMode == "Y"){
					//var fC_ofc = formObj.f_c_ofc.value;
		            //var fPor   = formObj.f_por.value;
		            //var fDel   = formObj.f_del.value;		            
					//formObj.f_cntr_sts.value = formObj.f_status.value;
					//formObj.f_por_no.value   = formObj.f_por.value;
					//formObj.f_del_no.value   = formObj.f_del.value;
					//alert(formObj.f_cntr_sts.value + ", " + formObj.f_por_no.value + ", " + formObj.f_del_no.value);
				} else {
					if(!validateForm(sheetObj,formObj,sAction)) return false;
				}
                // 업무처리중 버튼사용 금지 처리
                ComOpenWait(true);
                sheetObj.Redraw = false;
                //formObj.f_cmd.value = SEARCH;
                //alert(masFormQueryString(formObj));
                sheetObj.DoSearch("ESM_MAS_0279GS.do", masFormQueryString(formObj));
                sheetObj.Redraw = true;
                ComOpenWait(false);
                break;
                
			/*case IBRESET: // RESET
                formObj.f_nod_cd.value = "";
				formObj.f_nod_nm.value = "";
				formObj.f_ctrl_ofc_cd.value = "";
				formObj.chk_office.checked = false;
	    		ComSetObjValue(document.form.f_rdodelflg,"");
	    		sheetObj.RemoveAll();
    			break;*/
                
            case IBSAVE:                //저장
            	/*if(!validateForm(sheetObj,formObj,sAction)) {
                	return false;
                }*/
            	sheetObj.Redraw = false;
                ComOpenWait(true);
                formObj.f_cmd.value = MULTI;                
                sheetObj.DoSave("ESM_MAS_0279GS.do", masFormQueryString(formObj,'f_cmd',true), -1, true);
                
                ComOpenWait(false);
                sheetObj.Redraw = true;
                break;
            
            case IBINSERT:      // 입력
              //sheetObj.DataCopy(); //행복사
				sheetObj.DataInsert(-1); // 마지막행에 행삽입
			  //sheetObj.CellValue2(sheetObj.LastRow, "mas_uc_flg") = "N";
			  //sheetObj.CellValue2(sheetObj.LastRow, "delt_flg") = "N";
			  //sheetObj.CellValue2(sheetObj.LastRow, "delt_flg") = "N";
			  //sheetObj.CellValue2(sheetObj.LastRow, "stup_flg") = "0";
			  /*sheetObj.SumText(0,1) = "";
                sheetObj.SumText(0,2) = "Total";*/
                break;

            case IBDELETE:      // 입력
            	//sheetObj.RowDelete(sheetObj.SelectRow, false);
            	var checkRow = sheetObj.FindCheckedRow("del_chk");            	
            	var checkRowArr = checkRow.split("|");
            	//alert(checkRowArr);
            	//alert(checkRowArr.length);
 	    		if(checkRow!=null && checkRowArr.length>1){
 	    			for(var i=checkRowArr.length-2;i>-1;i--){
	 	    			//alert(i);
 	    				//alert(checkRowArr[i]);
	 	    			sheetObj.RowHidden(checkRowArr[i]) = true;	 	    		
	 	    		}
//	 	    		for(var i=0;i<checkRowArr.length-1;i++){
//	 	    			alert(checkRowArr[i]);
//	 	    			sheetObj.RowDelete(checkRowArr[i], false);
//	 	    			/*if(checkRowArr[i]!=Row){
//	 	    				sheetObjects[0].CellValue2(checkRowArr[i],"del_chk") = 0;
//	 	    			}*/
//	 	    		}
 	    		}            	
                break;
            
            case IBDOWNEXCEL:           //엑셀 다운로드
                //sheetObj.SpeedDown2Excel(-1);
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }               
                break;
             	
        	case IBLOADEXCEL:
        		sheetObj.Redraw = false;
        		ComOpenWait(true);
	        	sheetObj.RemoveAll();	
	        	sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", false);
	        	//EXCEL_LOAD_FLG = sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", false);
//	        	if(EXCEL_LOAD_FLG) {
//	        		ComShowObject(document.getElementById("btn_Rowdelete"),  true);
//	        	}
	        	ComOpenWait(false);
	        	sheetObj.Redraw = true;
				break;	

            case IBCREATE:
            	if(!validateForm(sheetObj,formObj,sAction)) {
                	return false;
                }
            	            	
            	if (!ComShowCodeConfirm("MAS10020")) {
            		return false;
            	}
            	
                ComOpenWait(true);
                sheetObj.Redraw = false;
                
                formObj.f_cmd.value = COMMAND02;                
                sheetObj.DoSearch("ESM_MAS_0279GS.do", FormQueryString(formObj));          
                doActionIBSheet(sheetObj, formObj, IBSEARCH);                 
                sheetObj.Redraw = true;
                break;    
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//버튼별 체크
        switch (sAction) {
	        case IBSEARCH: // 조회
	        	formObj.f_to_mon.value = formObj.f_fm_mon.value;
	        	//2016.03.08 검색 조건 추가
	        	if ( formObj.f_chkbkg.checked == true && ( formObj.f_bkgno.value == "" && formObj.f_cntrno.value == "") ) {
        			ComShowCodeMessage('MAS10002','bkg no or cntr no');
        			return false;
        		}
	        	else if (formObj.f_year == undefined && (formObj.f_year.value != "" || formObj.f_fm_mon.value != "") ||
	        		formObj.f_fm_wk.value != "" || formObj.f_to_wk.value != "") {
	        		if(!chkValidSearch()) {
		 				return false;
		 			}
	        		if (formObj.f_year.value != "") {
	      				if (formObj.f_chkprd[1].checked && formObj.f_node.value == "" && formObj.f_cmd.value == SEARCH) {
	      					ComShowCodeMessage("COM12114", "Fm Location");
	      					formObj.f_node.focus();
	      	 				checkFlg = false;
	      	 				//f_cmd.value = SEARCH;
	      	 				return false;
	      				}
	      			}
	        		if (formObj.f_year.value != "") {
	      				if (formObj.f_chkprd[1].checked && formObj.f_por_no.value == "" && formObj.f_cmd.value == SEARCH) {
	      					ComShowCodeMessage("COM12114", "POR");
	      					formObj.f_por_no.focus();
	      	 				checkFlg = false;
	      	 				return false;
	      				}
	      			}
	        		if (formObj.f_year.value != "") {
	      				if (formObj.f_chkprd[1].checked && formObj.f_del_no.value == "" && formObj.f_cmd.value == SEARCH) {
	      					ComShowCodeMessage("COM12114", "DEL");
	      					formObj.f_del_no.focus();
	      	 				checkFlg = false;
	      	 				return false;
	      				}
	      			}
	        	} else if (formObj.f_bkgno.value != "" || formObj.f_cntrno.value != "") {
	        		if (formObj.f_fmyearmonth.value != "" && formObj.f_toyearmonth.value == "") {
	        			ComShowCodeMessage('MAS10002','correct date.\nFormat: Date : yyyymmdd ~ yyyymmdd');
						return false;
	        		} else if (formObj.f_fmyearmonth.value == "" && formObj.f_toyearmonth.value != "") {
	        			ComShowCodeMessage('MAS10002','correct date.\nFormat: Date : yyyymmdd ~ yyyymmdd');
	        			return false;
	        		} else if (formObj.f_fmyearmonth.value != "" && formObj.f_toyearmonth.value != "") {
	        			if (!ComIsDate(formObj.f_fmyearmonth.value,"ymd")) {
	        				ComShowCodeMessage('MAS10002','correct date.\nFormat: yyyymmdd');
	        				formObj.f_fmyearmonth.value = "";
	        				return false;
	        			} else if (!ComIsDate(formObj.f_toyearmonth.value,"ymd")) {
	        				ComShowCodeMessage('MAS10002','correct date.\nFormat: yyyymmdd');
	        				formObj.f_toyearmonth.value = "";
	        				return false;
	        			}
	        		}
	        	} else if (formObj.f_bkgno.value == "" && formObj.f_fmyearmonth.value != "" && formObj.f_toyearmonth.value != "") {
	        		if (formObj.f_fmyearmonth.value != "" && formObj.f_toyearmonth.value == "") {
	        			ComShowCodeMessage('MAS10002','correct date.\nFormat: Date : yyyymmdd ~ yyyymmdd');
						return false;
	        		} else if (formObj.f_fmyearmonth.value == "" && formObj.f_toyearmonth.value != "") {
	        			ComShowCodeMessage('MAS10002','correct date.\nFormat: Date : yyyymmdd ~ yyyymmdd');
	        			return false;
	        		} else if (formObj.f_fmyearmonth.value != "" && formObj.f_toyearmonth.value != "") {
	        			if (!ComIsDate(formObj.f_fmyearmonth.value,"ymd")) {
	        				ComShowCodeMessage('MAS10002','correct date.\nFormat: yyyymmdd');
	        				formObj.f_fmyearmonth.value = "";
	        				return false;
	        			} else if (!ComIsDate(formObj.f_toyearmonth.value,"ymd")) {
	        				ComShowCodeMessage('MAS10002','correct date.\nFormat: yyyymmdd');
	        				formObj.f_toyearmonth.value = "";
	        				return false;
	        			}
	        		}
	        	} else {
	        		ComShowCodeMessage('MAS10002','W/M or BKG or From Date');
	        		return false;
	        	} 
				break;
		
        	case IBSAVE:
	  			if(EXCEL_LOAD_FLG) {
//	  				if(!checkValidationAllData(sheetObj)) {  					
//	  					return false;
//	  				}
	  			}    	  			
				break;
	  	
	  		case IBCREATE:
	  			if ( formObj.f_yrtype[0].checked ) {
	  				ComShowCodeMessage('MAS10003','Creation','YYYY-WW');
	  				return false;
	  			}
				break;
				
	  		case IBDELETE:
	  			if(sheetObj.RowCount < 1) {
	  				return false;
	  			}
				break;
        }
        
        return true;
    }
    
    /**
     * 검색시 필수입력사항 체크  <br>
     * <br><b>Example :</b>
     * <pre>
     *     chkValidSearch()
     * </pre>
     */
	function chkValidSearch(){
		var formObj = document.form;
		var checkFlg = true;

 		with(formObj){
 			if (f_year.value == "") {
 				if (f_bkg_no.value == "") {
 					ComShowCodeMessage("COM12114", "Year");
 	 			    f_year.focus();
 	 			    checkFlg = false;
 				}
 			} else if(!ComIsDate(f_year, "yyyy")){
  		    	ComShowCodeMessage("MAS10009", "Year", "YYYY");
 			    f_year.focus();
 			    checkFlg = false;
  		    } else if (f_chkprd[0].checked){
     			if (f_fm_wk.value == ""){
     				//ComShowCodeMessage("COM12114", "Week");
     			    f_fm_wk.focus();
     			    checkFlg = false;
     			} else if (f_to_wk.value == ""){
     				ComShowCodeMessage("COM12114", "Week");
     				f_to_wk.focus();
     			    checkFlg = false;
     			} else if(!ComIsWeek(f_fm_wk)){
      		    	//Please enter Week correctly.\n\n Format : WW
     				ComShowCodeMessage('MAS10009', 'Week', 'WW');
     				f_fm_wk.focus();
     			    checkFlg = false;
     			} else if(!ComIsWeek(f_to_wk)) {
      		    	//Please enter Week correctly.\n\n Format : WW
     				ComShowCodeMessage('MAS10009', 'Week', 'WW');
     				f_to_wk.focus();
     			    checkFlg = false;
     			} else if (f_fm_wk.value > f_to_wk.value) {
     			    //Month의 From는(은) To보다 적거나 같아야 합니다.
     				ComShowCodeMessage("MAS10011", "Week", "From", "To");
     			    f_to_wk.focus();
     			    checkFlg = false;
     			} else if ((f_to_wk.value - f_fm_wk.value) > 3) {
     			    //Week의 The difference는(은) 4보다 적거나 같아야 합니다.
     				ComShowCodeMessage("MAS10011", "Week", "The difference", "4");
     				//ComShowCodeMessage("The difference of Week should be less than 4.");
     				f_to_wk.focus();
     			    checkFlg = false;
     			}
 			} else if (f_chkprd[1].checked){
     			if (f_fm_mon.value == ""){
     				ComShowCodeMessage("MAS12114", "Month");
     			    f_fm_mon.focus();
     			    checkFlg = false;
     			} else if(!ComIsMonth(f_fm_mon)){
     				//Please enter Month correctly.\n\n Format : MM
     				ComShowCodeMessage('MAS10009', 'Month', 'MM');
     				f_fm_mon.focus();
     			    checkFlg = false;
     			}
 			}
 			/*if (formObj.f_year.value != "") {
  				if (formObj.f_chkprd[1].checked && formObj.f_node.value == "" && formObj.f_cmd.value == SEARCH) {
  					ComShowCodeMessage("COM12114", "Fm Location");
  					formObj.f_node.focus();
  	 				checkFlg = false;
  	 				//f_cmd.value = SEARCH;
  	 				return false;
  				}
  			}
    		if (formObj.f_year.value != "") {
  				if (formObj.f_chkprd[1].checked && formObj.f_por_no.value == "" && formObj.f_cmd.value == SEARCH) {
  					ComShowCodeMessage("COM12114", "POR");
  					formObj.f_por_no.focus();
  	 				checkFlg = false;
  	 				return false;
  				}
  			}
    		if (formObj.f_year.value != "") {
  				if (formObj.f_chkprd[1].checked && formObj.f_del_no.value == "" && formObj.f_cmd.value == SEARCH) {
  					ComShowCodeMessage("COM12114", "DEL");
  					formObj.f_del_no.focus();
  	 				checkFlg = false;
  	 				return false;
  				}
  			}*/
 		}
 		return checkFlg;
     }
    
    function fbkgnoInputChange(obj,value,text) {    	
        var formObj = document.form;
        formObj.f_bkgno.className = "input1";
        formObj.f_fmyearmonth.className = "input";
        formObj.f_toyearmonth.className = "input";
        
    }   
    
    function fyearmonthInputChange(obj,value,text) {    	
    	var formObj = document.form;
        formObj.f_bkgno.className = "input";
        formObj.f_fmyearmonth.className = "input1";
        formObj.f_toyearmonth.className = "input1";        
    } 

	function fnYearSet(obj){
	    obj.value = ComGetMaskedValue(obj.value,"ymd");
	}
	
	function ComMasSetPeriod0279(obj){
        var formObj = document.form;
        formObj.f_to_mon.value = formObj.f_fm_mon.value;
        if(obj == null){
            return;
        }
        if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            /*if(obj.name == "f_to_mon" ){
                formObj.f_fm_mon.value = "";
            } else if (obj.name == "f_to_wk"){
                formObj.f_fm_wk.value = "";
            }*/
            if (obj.name == "f_to_wk"){
                formObj.f_fm_wk.value = "";
            }
            return false;
        } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if(obj.name == "f_fm_mon") return false;
            if(obj.name == "f_fm_wk") return false;
        }

        if(chkValidSearch()){
            var sheetObj = sheetObjects[0];
        	formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("initPeriodGS.do", FormQueryString(formObj));			            
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
        }
    }
	
	function changeTomon(){
//		var formObj = document.form;
//        formObj.f_to_mon.value = formObj.f_fm_mon.value;        
        setPeriod(formObj.f_to_mon.value);
	}
	
	// 0 : BKG Search , 1 : From Date
	var searchType = 1;
	
	//2016.03.08 조회조건 추가	
	function chk_BKG(){ //f_chkbkg
		resetDtArea();
		searchType = 0;
	}
	
	//2016.03.08 조회조건 추가	
	function chk_DT(){ //f_chkdt
		resetBkgArea();
		searchType = 1;		
	}
	
	//2016.03.08 조회조건 추가	 searchType에 따른 입력항목 세팅
	function setSearchItem(){
		var formObj = document.form;
	
		if( searchType == 0 ) {
			//BKG / CNTR 중 하나는 반드시 입력해야 함
			if( formObj.f_bkgno.value == "" && formObj.f_cntrno.value == "" ) {
				ComShowCodeMessage("COM12114", "BKG No or Container No");
				return false;
			}
		} else if( searchType == 1 ) {
			//From Date 입력 해야 함.
			if( formObj.f_fmyearmonth.value == "" && formObj.f_toyearmonth.value == "" ) {
				ComShowCodeMessage("COM12114", "From date and To date");
				return false;
			}
		}
		return true;
	}
	
	/* 2016.03.08 조회조건 추가	
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function doProcessPopup(srcName, arg) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		
  		with(sheetObj) {
	  		switch(srcName) {
	  			case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
	  				return;
					break;
				
	  			case 'svc_provdr':	// Service Provider Popup
	  				ComOpenPopup('COM_ENS_0C1.do', 700, 450, "getSvcProvdr", "1,0,1,1,1,1,0", true);
	  				return;
					break;
					
	  			case 'm_bkg_no':		// BKG No. 멀티입력 팝업 호출
	  			case 'm_bl_no':			// B/L No. 멀티입력 팝업 호출
	  			case 'm_cntr_no':		// CNTR No. 멀티입력 팝업 호출
	  				var flag = ComReplaceStr(srcName,"m_","");
	  			
			  		// 멀티입력 팝업 타이틀 세부 내용 지정
	  				var returntitle = '';
	  				if(flag == 'bkg_no')
	  					returntitle = 'BKG No.';
	  				else if(flag == 'bl_no')
	  					returntitle = 'B/L No.';
	  				else if(flag == 'cntr_no')
	  					returntitle = 'CNTR No.';
	  				
	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('ESM_MAS_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	  				return;
					break;
             	
	  			case 'btn_ByBKG':
	  				var chkRow = SelectRow;
	  				
		  			var bkgNo		= CellValue(chkRow , "bkg_no");
		  			var blNo		= CellValue(chkRow , "bl_no");
		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
		  			var chgStsCd	= CellValue(chkRow , "dmdt_chg_sts_cd");
		  			var paramVal	= "?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=" + chgStsCd;
		  			
		  			if(ComGetObjValue(formObj.role_permit) == 'Y') {
		  				// Calculation 화면
		  				sUrl = 'EES_DMT_3002P.do' + paramVal;
		  			} else {
		  				// Inquiry 화면
		  				sUrl = 'EES_DMT_3005P.do' + paramVal;
		  			}
		  			
	  				sWidth	= '1010';
	          		sHeight	= '680';
	  				break;
	  			
	  			case 'btn_ByCNTR':
	  				var chkRow = SelectRow;
		  			
		  			var svrId		= CellValue(chkRow , "svr_id");
		  			var cntrNo		= CellValue(chkRow , "cntr_no");
		  			var cntrCycNo	= CellValue(chkRow , "cntr_cyc_no");
		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
		  			var chgLocDivCd	= CellValue(chkRow , "dmdt_chg_loc_div_cd");
		  			var chgSeq		= CellValue(chkRow , "chg_seq");
		  			var paramVal	= "?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
		  			
		  			if(ComGetObjValue(formObj.role_permit) == 'Y') {
		  				// Calculation 화면
		  				sUrl = 'EES_DMT_3003P.do' + paramVal;
		  			} else {
		  				// Inquiry 화면
		  				sUrl = 'EES_DMT_3006P.do' + paramVal;
		  			}
		  			
	  				sWidth	= '1010';
	          		sHeight	= '680';
	  				break;
	  				
	  			case 'btn_MVMTInq':
	  				if(SearchRows == 0) {
	         			ComShowCodeMessage('COM12114', 'CNTR');  //DMT06001
	         			return;
	         		}
	  				
	  				var inqRow = 0;
	  				if(CheckedRows("chk") > 0) {
	  					var chkRows = FindCheckedRow("chk").split("|");
	  					inqRow = chkRows[0];
	  				} else if(SelectRow > 0) {
	  					inqRow = SelectRow;
	  				}
	  				
	  				var cntrNo = CellValue(inqRow , "cntr_no");
	  				var cntrTpszCd = CellValue(inqRow , "cntr_tpsz_cd");
	  				var paramVal =	"?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10) +
	                        		"&check_digit=" + cntrNo.substring(10,11) +
			                        "&ctnr_tpsz_cd=" + cntrTpszCd;
					sUrl	= 'EES_CTM_0408.do' + paramVal;
					sWidth	= '1020';
					sHeight	= '690';
	  				break;
	  				
	  		} // switch-end
  		} // with-end
  		
		var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
		ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  	}
  	
  	/* 2016.03.08 조회조건 추가	
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getMas_Multi(rArray, return_val) {
    	var targObj = eval("document.form.f_" + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	if( return_val == "bkg_no" )
    		document.form.f_bkgno.value = retStr;
    	else if( return_val == "cntr_no" )
    		document.form.f_cntrno.value = retStr;
//    	ComSetObjValue(targObj, retStr);
    }
    
    //2016.03.08 조회조건 추가,
    function resetDtArea() {
    	var fObj	= document.form;
    	fObj.f_chkprd[2].checked=false;
    	fObj.f_chkprd[1].checked=false;
    	fObj.f_chkprd[0].checked=false;
    	fObj.f_chkbkg.checked = true;
    	fObj.f_year.value="";
    	fObj.f_fm_wk.value="";
    	fObj.f_to_wk.value="";
    	fObj.f_fmyearmonth.value = "";
    	fObj.f_toyearmonth.value = "";
    	fObj.f_fm_mon.value = "";
    	fObj.f_to_mon.value = "";    	
//    	fObj.f_sc_no.value = "";
//    	fObj.f_rfa_no.value = "";
//    	fObj.f_por_no.value = "";
//    	fObj.f_del_no.value = "";
    	chk_WM('W','1');
    	changeCostYrmon(this.value);
    	fObj.f_por_no.className = "input";
    	fObj.f_del_no.className = "input";
    	fObj.f_node.className = "input";
    	fObj.f_year.className = "input";
    	fObj.f_fm_mon.className = "input";
    	fObj.f_fm_wk.className = "input";
    	fObj.f_to_wk.className = "input";
    	fObj.f_bkgno.className = "input1";  
    }

    //2016.03.08 조회조건 추가	
    function resetBkgArea() {
    	var fObj	= document.form;
    	fObj.f_chkbkg.checked = false;
//    	fObj.f_chkdt.checked = true;
    	fObj.f_bkgno.value = "";
    	fObj.f_cntrno.value = "";
//    	comboObjects[0].index = "0";
//    	comboObjects[1].index = "0";
//    	comboObjects[2].index = "0";
    	fObj.f_items.value = "";
    	fObj.f_bkgno.className = "input";
    }