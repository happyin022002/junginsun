/*=========================================================
*Copyright(c) 2009 CyberLogitec
* =========================================================
* History
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends Pri
     * @class ESM_PRI_2244 : ESM_PRI_2244 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2244() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.obj_keypress           = obj_keypress;
    	this.setComboObject 		= setComboObject;
    	this.obj_deactivate         = obj_deactivate;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/


    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.09.30
     */
    function processButtonClick () {
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /** **************************************************** */
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
    
            switch (srcName) {
                case "btn_Ok":
                	doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;
    
                case "btn_Close":
                    window.close();
                    break;
                case "btns_calendar": //달력버튼
                    var cal = new ComCalendarFromTo();    
                    cal.select(formObj.ctrt_eff_dt, formObj.ctrt_exp_dt, 'yyyy-MM-dd');
                    break;  
                case "btn_ctrt_cust":
                    var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?nmd_cust_flg=N&is_popup=true&cust_cnt_cd="+formObj.ctrt_cust_cnt_cd.value+"&cust_seq="+formObj.ctrt_cust_seq.value, "ESM_PRI_4014", 640, 455, true);
                    if (rtnVal != null && rtnVal.custCntCd != ''){  
                        formObj.ctrt_cust_cnt_cd.value = rtnVal.custCntCd;         
                        formObj.ctrt_cust_seq.value = rtnVal.custSeq;
                        formObj.ctrt_pty_nm.value = rtnVal.custNm;  
                        custNameFind();
                    }
                    break;   
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 문동규
     * @version 2009.09.30
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
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.09.30
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
     			initSheet(sheetObjects[i],i+1);
     			ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }

        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
        
        var formObj = document.form;
        var eff = formObj.ctrt_eff_dt;
        var exp = formObj.ctrt_exp_dt;
        
        
        if(copyFlg == "spot"){//M->B
        	exp.value= p_exp_dt;
        	var fromVal = p_eff_dt.replace(/-/g,'');
        	var gCurrDate = ComGetNowInfo('ymd', '-');//TODAY 생성
        	var today = gCurrDate.replace(/-/g,'');//TODAY에서 '-'제외
        	if(parseInt(fromVal,10) < parseInt(today,10)){//받아온 EFF_DT가 TODAY보다 이전이면
        		eff.value= gCurrDate;
        		fromVal = today;
        	}else{
        		eff.value= p_eff_dt;
        	}
        }else{//M->M
        	//Eff 초기값
        	var fromVal = p_eff_dt.replace(/-/g,'');//p_exp_dt ('YYYYMMDD')
        	var gCurrDate = ComGetNowInfo('ymd', '-');//TODAY 생성
        	var today = gCurrDate.replace(/-/g,'');//TODAY에서 '-'제외
        	if(parseInt(fromVal,10) < parseInt(today,10)){//받아온 EFF_DT가 TODAY보다 이전이면
        		eff.value= gCurrDate;//effDt = today
        		fromVal = today;
        	}else{//effDt = p_eff_dt
        		eff.value= p_eff_dt;
        	}
        		
        	//Exp 초기값	
            var newExp = ComGetDateAdd(fromVal, "D", 14, "", true);
            var ne_year = newExp.substr(0,4);
            var ne_month = newExp.substr(4,2);
            var ne_date = newExp.substr(6,2);
            exp.value = ne_year+"-"+ne_month+"-"+ne_date;
        }
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.09.30
     */
    function initSheet (sheetObj, sheetNo) {
    
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {
    
            case "sheet1":
            	with (sheetObj) {
    			// 높이 설정
    			style.height = 300;
    			// 전체 너비 설정
    			SheetWidth = mainTable.clientWidth;
    			
    			// Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "")
    				InitHostInfo(location.hostname, location.port, page_path);

    			// 전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msHeaderOnly;

    			// 전체Edit 허용 여부 [선택, Default false]
    			Editable = true;

    			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo(2, 1, 3, 100);

    			var HeadTitle1 = "|Sel.|Route\nID|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Origin|R Term|O.Via|D.Via|Dest|D Term|";
    			HeadTitle1 += "Direct\nCall|T/S\nPort|Lane|VVD|Prev Rate|Prev Rate|Prev Rate|Prev Rate|Prev Rate|Prev Rate|Current Rate|Current Rate|Current Rate|Current Rate|Current Rate|Current Rate|Charge\nTerm|";
    			HeadTitle1 += "Not Deleted Rows|Not Accepted Rows|note_dp_seq|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq|mst_rfa_no|mst_rout_id";
    			
    			var HeadTitle2 = "|Sel.|Route\nID|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Origin|R Term|O.Via|D.Via|Dest|D Term|";
    			HeadTitle2 += "Direct\nCall|T/S\nPort|Lane|VVD|D2|D4|D5|D2(DG)|D4(DG)|D5(DG)|D2|D4|D5|D2(DG)|D4(DG)|D5(DG)|Charge\nTerm|";
    			HeadTitle2 += "Not Deleted Rows|Not Accepted Rows|note_dp_seq|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq|mst_rfa_no|mst_rout_id";
    			
    			var headCount = ComCountHeadTitle(HeadTitle1);
    			
    			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(headCount, 0, 0, true);

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, true, true, false, false);

    			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle1, true);
    			InitHeadRow(1, HeadTitle2, true);

    			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
    			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, true, "chk");     
    			InitDataProperty(0, cnt++ , dtData,			50,	daCenter,  true,	"mst_rout_id",		false,	"",	dfNone, 			0,		false,	false);
//    			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "seq"); 
    			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", true, "", dfNone, 0, false, false);
    			
    			InitDataProperty(0, cnt++, dtData,		70,	daLeft,		true,	"org_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, true, 5);
    			InitDataProperty(0, cnt++ ,dtCombo,			60,	daCenter,	true,	"rcv_de_term_cd_ori",	true,	"", dfNone, 0, false, true);
    			InitDataProperty(0, cnt++, dtData,		70,	daLeft,		true,	"org_rout_via_port_def_cd", false, "", dfNone, 0, false, true, 5);
    			InitDataProperty(0, cnt++, dtData,		70,	daLeft,		true,	"dest_rout_via_port_def_cd", false, "", dfNone, 0, false, true, 5);
    			InitDataProperty(0, cnt++, dtData,		70,	daLeft,		true,	"dest_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, true, 5);
    			InitDataProperty(0, cnt++, dtCombo,			60,	daCenter,	true,	"rcv_de_term_cd_dest",	true,	"", dfNone, 0, false, true);
    			
                InitDataProperty(0, cnt++ , dtCombo,			45,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,		70,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     false,       true,	5);
                InitDataProperty(0, cnt++ , dtData,  	50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     false,       true,	3);
                InitDataProperty(0, cnt++ , dtData,		85,   daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     false,       true,	9);
                
                // Summary
                InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"prev_d2",		false,	"", dfNone, 0, false, false);
                InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"prev_d4",		false,	"", dfNone, 0, false, false);
                InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"prev_d5",		false,	"", dfNone, 0, false, false);
                
                InitDataProperty(0, cnt++ , dtData,  50,    daCenter,    true,      "prev_d2_dg",      false,  "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++ , dtData,  50,    daCenter,    true,      "prev_d4_dg",      false,  "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++ , dtData,  50,    daCenter,    true,      "prev_d5_dg",      false,  "", dfNone, 0, false, false);                
                
                InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"curr_d2",		false,	"", dfNone, 0, false, false);
                InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"curr_d4",		false,	"", dfNone, 0, false, false);
                InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"curr_d5",		false,	"", dfNone, 0, false, false);
                
                InitDataProperty(0, cnt++ , dtData,  50,    daCenter,    true,      "curr_d2_dg",      false,  "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++ , dtData,  50,    daCenter,    true,      "curr_d4_dg",      false,  "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++ , dtData,  50,    daCenter,    true,      "curr_d5_dg",      false,  "", dfNone, 0, false, false);
                
                
                InitDataProperty(0, cnt++ , dtData,	 50,	daLeft,	 true,		"note_conv_chg_cd",	false,	"", dfNone, 0, false, false); // Charge Term. mouse over tool tip
    			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "nd_cnt",									false, "", dfInteger, 0, false, false);
    			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "na_cnt",									false, "", dfInteger, 0, false, false);
    			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "note_dp_seq",						false, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq",			true, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "org_n1st_cmnc_amdt_seq",	true, "", dfNone, 0, false, false);
    			
                InitDataProperty(0, cnt++ , dtHidden,			85,	daCenter,  true,	"mst_rfa_no",		false,	"",	dfNone,			0,		false,	false);
                InitDataProperty(0, cnt++ , dtHidden,			85,	daCenter,  true,	"mst_rout_id",		false,	"",	dfNone, 			0,		false,	false);
    			
    			InitDataValid(0, "org_rout_pnt_loc_def_cd", vtEngUpOther, "1234567890");
    			InitDataValid(0, "org_rout_via_port_def_cd", vtEngUpOther, "1234567890");
    			InitDataValid(0, "dest_rout_via_port_def_cd", vtEngUpOther, "1234567890");
    			InitDataValid(0, "dest_rout_pnt_loc_def_cd", vtEngUpOther, "1234567890");
    			
    			InitDataCombo(0, "rcv_de_term_cd_ori", termOrgCdText, termOrgCdValue);
    			InitDataCombo(0, "rcv_de_term_cd_dest", termDestCdText, termDestCdValue);
    			
    			InitDataCombo(0, "bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
    			InitDataValid(0, "bkg_ts_port_def_cd", vtEngUpOther, "1234567890");
    			InitDataValid(0, "bkg_slan_cd", 			vtEngUpOnly);
    			InitDataValid(0, "bkg_vvd_cd", 				vtEngUpOther, "1234567890");
    			
    			SetMergeCell(1, 13, 0, 3); // Row : 1 Col : 13에서 시작해서 세로로 0개 가로로 3개를 머지하겠다. 
    			
                // 설정값 ScrollBar 
//              0  둘 다 없음 
//              1  수평스크롤만 허용 
//              2  수직스크롤만 허용 
//              3  모두 허용, Default 
    			ScrollBar = 3;
    			
    			ToolTipOption = "balloon:true;width:1000;icon:1;title:Route Note";
    			Ellipsis = true;
    			ShowButtonImage = 2;
//    			AutoRowHeight = false;
    			
    			
    		}
    		break;
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
     * @author 문동규
     * @version 2009.09.30
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
            case IBSEARCH: // 조회
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;
                var sXml = sheetObj.GetSearchXml("ESM_PRI_2244GS.do" , FormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                    sheetObjects[0].LoadSearchXml(arrXml[0]);
                ComOpenWait(false);
                break;
            case IBSAVE:
                ComOpenWait(true);
                if (!validateForm (sheetObjects[0], formObj, sAction)) {
                	ComOpenWait(false);
                    return;
                }
                if (!ComShowCodeConfirm('PRI00012')) {
                	ComOpenWait(false);
                    return;
                }
                for(var i=sheetObj.HeaderRows; i<=sheetObj.RowCount + sheetObj.HeaderRows; i++) {
                    if (sheetObjects[0].CellValue(i, "chk") == 1) {
                        sheetObjects[0].RowStatus(i) = "U";
                    } else {
                        sheetObjects[0].RowStatus(i) = "R";
                    }
                }
                
                formObj.eff_dt.value = formObj.ctrt_eff_dt.value;
                formObj.exp_dt.value = formObj.ctrt_exp_dt.value;
                formObj.f_cmd.value = MULTI01;
                
                var sParam = FormQueryString(formObj);
                var sParamSheet1 = sheetObjects[0].GetSaveString();
                sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                
                var sXml = sheetObj.GetSaveXml("ESM_PRI_2244GS.do", sParam);
                sheetObjects[0].LoadSaveXml(sXml);
                ComOpenWait(false);
            	break;
        }
    }



    function respb_srep_cd_OnChange(comboObj) {
        var formObj = document.form;
        var code = comboObj.Code;
        formObj.ctrt_cust_srep_nm.value = comboObj.GetText(code, 1);
    }
    
    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.09.30
     */
    function sheet1_OnChange (sheetObj, Row, Col, Value) {
    
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.09.30
     */
    function validateForm (sheetObj, formObj, sAction) {
        with (sheetObj) {
            switch (sAction) {
                case IBSAVE:
                	effDtObj = formObj.ctrt_eff_dt;
                	expDtObj = formObj.ctrt_exp_dt;
                	
                    if(effDtObj.value == "") {
                        ComShowCodeMessage("PRI00335", effDtObj.caption);
                        ComSetFocus(effDtObj);
                        return false;
                    }
                    if(ComGetDaysBetween(p_eff_dt, effDtObj) < 0) {
                    	ComShowCodeMessage("PRI01160"); // Retroactive Filing is not allowed
                    	return false;
                    }
                    if(ComGetDaysBetween(ComGetNowInfo('ymd', ''), effDtObj) < 0) {
                    	ComShowCodeMessage("PRI01160"); // Retroactive Filing is not allowed
                        return false;
                    }
                   
                    if(expDtObj.value == "") {
                        ComShowCodeMessage("PRI00335", expDtObj.caption);
                        ComSetFocus(expDtObj);
                        return false;
                    }
//                    if(!ComChkObjValid(effDtObj)) {return false;}
//                    if(!ComChkObjValid(expDtObj)) {return false;}
                    if(!chkEffDate()) {return false;}
                    
                    if(copyFlg=='spot'){                		
                    	ctrt_cust_cnt_cd = formObj.ctrt_cust_cnt_cd;
                    	ctrt_cust_seq = formObj.ctrt_cust_seq;
                    	respb_srep_cd = formObj.respb_srep_cd;
	                    if(ctrt_cust_cnt_cd.value == "") {
	                    	ComShowCodeMessage("PRI00335", ctrt_cust_cnt_cd.caption);
	                    	ComSetFocus(ctrt_cust_cnt_cd);
	                    	return false;
	                    }
	                    if(ctrt_cust_seq.value == "") {
	                    	ComShowCodeMessage("PRI00335", ctrt_cust_seq.caption);
	                    	ComSetFocus(ctrt_cust_seq);
	                    	return false;
	                    }
	                    if(respb_srep_cd.Code == "") {
	                    	ComShowCodeMessage("PRI00335", 'Sales Rep. Code');
	                    	ComSetFocus(respb_srep_cd);
	                    	return false;
	                    }
	                    if (comboObjects[0].Code == "" || comboObjects[0].Code == " ") { //[CHM-201323648] 빈 칸을 선택해도 validation 처리 되도록 함
	                        ComShowCodeMessage('PRI00316','Customer Sale Rep.'); 
	                        comboObjects[0].focus();
	                        return false;
	                    }
                    }
                    if (FindCheckedRow("chk") == "") {
                        ComShowCodeMessage('PRI00327'); // Please select more than 1 sequence to copy
                        return false;
                    }
                    
                    break;
            }
        }
        return true;
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 chkEffDate <br>
     */
    function chkEffDate() {
    	var form = document.form;
    	var effDt = form.ctrt_eff_dt;//EFF_DT
    	var expDt = form.ctrt_exp_dt;//EFF_DT
    	if(copyFlg != 'spot'){//M->M
		        var effValue = effDt.value.replace(/-/g,'');//YYYYMMDD
	            var effAfter14 = ComGetDateAdd(effValue, "D", 14, "", true);
	    		 //if(ComGetDaysBetween(effAfter14, expDt) > 0) {
	    		 if( PriCheckMonthBetween(effDt, expDt ,1) < 1 ){
	    		         
	    		     
	             	ComShowCodeMessage("PRI07060");
	                 return false;
	             }
    	}else{//M->B
    		 if(ComGetDaysBetween(p_exp_dt, expDt) > 0) {
             	ComShowCodeMessage("PRI01165");
                 return false;
             }
    	}
        return true;
    }

    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장 후 로직을 처리한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 문동규
     * @version 2009.09.30
     */
    function sheet1_OnSaveEnd (sheetObj, errMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            var newPropNo = sheetObj.EtcData("newPropNo");
            window.returnValue = newPropNo;
            window.close();
        }
    }

    /**
     * 입력한 Customer Sale Office 에 따른 Sales Rep을 조회하여 IBMulti Combo에 Setting한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		setCustSaleRep();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2009.05.07
     */   
    function setCustSaleRep(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if (formObj.ctrt_cust_cnt_cd.value != "" && formObj.ctrt_cust_seq.value != "") {
            formObj.f_cmd.value = SEARCHLIST;
            var sParam = FormQueryString(formObj) + "&etc2=" + formObj.ctrt_cust_cnt_cd.value
                       + "&etc3=" + ComParseInt(formObj.ctrt_cust_seq.value);
            sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
            ComPriXml2ComboItem(sXml, formObj.respb_srep_cd, "cd", "cd|nm|etc1");
            //첫줄 빈칸 추가
            comboObjects[0].InsertItem(0, " | | "," ");
        }
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
            case "engup":
                ComKeyOnlyAlphabet('upper');
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
     * @version 2009.08.12
     */ 
    function obj_deactivate() {
        var formObj = document.form;
        var srcName = event.srcElement.name;
        switch(srcName) {
            case "ctrt_cust_seq":
                if (formObj.ctrt_cust_seq.value.length < 6 && formObj.ctrt_cust_seq.value.length != 0 ){
                    formObj.ctrt_cust_seq.value = ComLpad(formObj.ctrt_cust_seq.value, 6, "0");
                }
                if (formObj.ctrt_cust_cnt_cd.value == "" || formObj.ctrt_cust_seq.value == "" || !ComIsNumber(formObj.ctrt_cust_seq.value)) { //[CHM-201323647] 숫자가 아닌 경우 clear
                	formObj.ctrt_cust_cnt_cd.value = '';         
                    formObj.ctrt_cust_seq.value = '';
                	formObj.ctrt_pty_nm.value = "";
        			formObj.prc_ctrt_cust_tp_nm.value = "";
        			formObj.ctrt_cust_val_sgm.value = "";
        			formObj.respb_sls_ofc_cd.value = "";
        			formObj.respb_srep_cd.Code = "";
        			formObj.ctrt_cust_srep_nm.value = "";
        		} 
                break;
            case "ctrt_exp_dt":
				ComChkObjValid(event.srcElement);
				break;
			case "ctrt_eff_dt":
				ComChkObjValid(event.srcElement);
				break;
            	 
        }

        switch(srcName) {
            case "ctrt_cust_cnt_cd":
            case "ctrt_cust_seq":
                custNameFind();
                break;
        }

    }
    /** 
     * customer name 조회하는 custNameFind 함수 <br>
     * 2003 메소드 참조. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function custNameFind(){
        var form = document.form;
        var ctrt_cust_cnt_cd = form.ctrt_cust_cnt_cd.value;  
        var ctrt_cust_seq = form.ctrt_cust_seq.value;
        if(ctrt_cust_cnt_cd != "" && ctrt_cust_seq !="") {
            var sParam = "f_cmd=" + SEARCH02 + "&cust_cnt_cd=" + ctrt_cust_cnt_cd + "&cust_seq=" + ctrt_cust_seq;
            var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2003GS.do", sParam);
            var arrText = ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_cust_val_sgm|respb_srep_cd|respb_sls_ofc_cd|ctrt_cust_srep_nm|prc_ctrt_cust_tp_nm|ctrt_cust_val_sgm_cd");
            if(arrText==undefined){
            	form.ctrt_cust_cnt_cd.value = "";
            	form.ctrt_cust_seq.value = "";
            	form.ctrt_pty_nm.value = "";
            	form.ctrt_cust_val_sgm.value = "";
            	form.respb_sls_ofc_cd.value = "";           
                comboObjects[0].Code = "";
                form.ctrt_cust_srep_nm.value = "";
                form.prc_ctrt_cust_tp_nm.value = "";
                form.prc_ctrt_cust_tp_cd.value = "";
                form.ctrt_cust_val_sgm_cd.value = "";  
            }else{    
            	setCustSaleRep();
            	form.prc_ctrt_cust_tp_cd.value = arrText[0][0];
            	form.ctrt_pty_nm.value = arrText[0][1];
            	form.ctrt_cust_val_sgm.value = arrText[0][2];
                form.ctrt_cust_val_sgm_cd.value = arrText[0][7];  
            	form.respb_sls_ofc_cd.value = arrText[0][4];  
                comboObjects[0].Code = arrText[0][3];
                form.ctrt_cust_srep_nm.value = arrText[0][5];
                form.prc_ctrt_cust_tp_nm.value = arrText[0][6];
            }
        }else{
        	form.prc_ctrt_cust_tp_cd.value = "";
        	form.ctrt_pty_nm.value = "";
        	form.ctrt_cust_val_sgm.value = "";
        	form.respb_sls_ofc_cd.value = "";           
            comboObjects[0].Code = "";
            form.ctrt_cust_srep_nm.value = "";
            form.prc_ctrt_cust_tp_nm.value = "";  
        }
    }   
    
 
    /* 개발자 작업  끝 */