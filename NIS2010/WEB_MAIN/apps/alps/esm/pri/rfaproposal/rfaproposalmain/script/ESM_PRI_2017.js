/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_2017.js
*@FileTitle : Basic RFA Auto Amendment Request
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 
*@LastVersion : 1.0
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
     * @class ESM_PRI_2017 : ESM_PRI_2017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2017() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }

    //  ===================================================================================
    //  전역변수
    //  ===================================================================================
    //  공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    //  ===================================================================================
    //  버튼 이벤트 처리
    //  ===================================================================================
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     */
    function processButtonClick(){
        var formObj = document.form;
        var sheetObject1 = sheetObjects[0];
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            	
                case "btn_OK":
                    if (validateForm(sheetObject1, formObj, IBSAVE)) {
                    	var rValue = doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    	
    	                if (!rValue){
    	                	return;
    	                }
    	                
    	                rData = "Y";
    	                window.returnValue = rData;
    	                window.close();
                    }
                    break;
                    
                case "btns_calendar": //달력버튼
                    var cal = new ComCalendarFromTo();    
                    cal.select(formObj.ctrt_eff_dt, formObj.ctrt_exp_dt, 'yyyy-MM-dd');
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
    

    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================
    /**
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     */
    function loadPage() {
        var formObj = document.form;
        sheetCnt = sheetObjects.length ;
        try {
        	// IBSheet 초기화
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] ); //시작 환경 설정 함수 이름 변경
     			initSheet(sheetObjects[i],i+1);
     			ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
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
        
        initControl();
        
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
     */
    function initSheet (sheetObj, sheetNo) {
    	
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {
        
	        case "sheet1":  // hidden Master RFA Information
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 0;
	                
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	                
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "")
	                    InitHostInfo(location.hostname, location.port, page_path);
	                
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	                
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	                
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 3, 100);
	                
	                var HeadTitle = "|rfa_no|prop_no|amdt_seq|svc_scp_cd|ctrt_eff_dt|ctrt_exp_dt";
	                var headCount = ComCountHeadTitle(HeadTitle);
	                
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false, false);
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30,  daCenter, false, "ibflag");
	                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rfa_no", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
	                WaitImageVisible = false;
	            }
	            break;
	            
        case "sheet2":
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
    			HeadTitle1 += "Not Deleted Rows|Not Accepted Rows|note_dp_seq|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq|mst_rfa_no|is_exists";
    			
    			var HeadTitle2 = "|Sel.|Route\nID|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Origin|R Term|O.Via|D.Via|Dest|D Term|";
    			HeadTitle2 += "Direct\nCall|T/S\nPort|Lane|VVD|D2|D4|D5|D2(DG)|D4(DG)|D5(DG)|D2|D4|D5|D2(DG)|D4(DG)|D5(DG)|Charge\nTerm|";
    			HeadTitle2 += "Not Deleted Rows|Not Accepted Rows|note_dp_seq|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq|mst_rfa_no|is_exists";
    			
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
    			InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck,   45,  daCenter, true, "chk",false,"",dfNone,0,true,false,1,false,false,"",false);

    			InitDataProperty(0, cnt++, dtData,				50,	daCenter,	true,	"mst_rout_id",		false,	"",	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++, dtHidden,			90,	daLeft,		false,	"prop_no",			true,	"",	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++, dtHidden,			90,	daLeft,		false,	"amdt_seq",			true,	"",	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++, dtHidden,			90,	daLeft,		false,	"svc_scp_cd",		true,	"",	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++, dtHidden,			90,	daLeft,		false,	"cmdt_hdr_seq",	true,	"",	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++, dtHidden,			90,	daLeft,		false,	"rout_seq",			true,	"",	dfNone,	0,	false,	false);
    			
    			InitDataProperty(0, cnt++, dtData,				70,	daLeft,		true,	"org_rout_pnt_loc_def_cd",		false,	"",	dfNone,	0,	false,	true,	5);
    			InitDataProperty(0, cnt++, dtCombo,			60,	daCenter,	true,	"rcv_de_term_cd_ori",				false,	"",	dfNone,	0,	false,	true);
    			InitDataProperty(0, cnt++, dtData,				70,	daLeft,		true,	"org_rout_via_port_def_cd",		false,	"",	dfNone,	0,	false,	true,	5);
    			InitDataProperty(0, cnt++, dtData,				70,	daLeft,		true,	"dest_rout_via_port_def_cd",	false,	"",	dfNone,	0,	false,	true,	5);
    			InitDataProperty(0, cnt++, dtData,				70,	daLeft,		true,	"dest_rout_pnt_loc_def_cd",		false,	"",	dfNone,	0,	false,	true,	5);
    			InitDataProperty(0, cnt++, dtCombo,			60,	daCenter,	true,	"rcv_de_term_cd_dest",			false,	"",	dfNone,	0,	false,	true);
    			
    			InitDataProperty(0, cnt++, dtCombo,			45,   daCenter,  true,	"bkg_dir_call_flg",				false,	"",	dfNone,		0,		false,	true);         
    			InitDataProperty(0, cnt++, dtData,				70,   daCenter,  true,	"bkg_ts_port_def_cd",		false,	"",	dfNone,		0,		false,	true,	5);
    			InitDataProperty(0, cnt++, dtData,  				50,   daCenter,  true,	"bkg_slan_cd",					false,	"",	dfNone,		0,		false,	true,	3);
    			InitDataProperty(0, cnt++, dtData,				85,   daCenter,  true,	"bkg_vvd_cd",					false,	"",	dfNone,		0,		false,	true,	9);
                
        		// Summary
        		InitDataProperty(0, cnt++, dtData,				40,	daCenter,	true,	"prev_d2",	false,	"",	dfNone,	0,	false,	false);
        		InitDataProperty(0, cnt++, dtData,				40,	daCenter,	true,	"prev_d4",	false,	"",	dfNone,	0,	false,	false);
        		InitDataProperty(0, cnt++, dtData,				40,	daCenter,	true,	"prev_d5",	false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++, dtData,              50, daCenter,   true,   "prev_d2_dg",  false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++, dtData,              50, daCenter,   true,   "prev_d4_dg",  false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++, dtData,              50, daCenter,   true,   "prev_d5_dg",  false,  "", dfNone, 0,  false,  false);
        		InitDataProperty(0, cnt++, dtData,				40,	daCenter,	true,	"curr_d2",		false,	"",	dfNone,	0,	false,	false);
        		InitDataProperty(0, cnt++, dtData,				40,	daCenter,	true,	"curr_d4",		false,	"",	dfNone,	0,	false,	false);
        		InitDataProperty(0, cnt++, dtData,				40,	daCenter,	true,	"curr_d5",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++, dtData,              50, daCenter,   true,   "curr_d2_dg",      false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++, dtData,              50, daCenter,   true,   "curr_d4_dg",      false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++, dtData,              50, daCenter,   true,   "curr_d5_dg",      false,  "", dfNone, 0,  false,  false);
                
        		InitDataProperty(0, cnt++, dtData,				50,	daLeft,		true,	"note_conv_chg_cd",				false,	"",	dfNone,	0,	false,	false); // Charge Term. mouse over tool tip
        		InitDataProperty(0, cnt++, dtHidden,			90,	daLeft,		false,	"nd_cnt",									false,	"",	dfNone,	0,	false,	false);
        		InitDataProperty(0, cnt++, dtHidden,			90,	daLeft,		false,	"na_cnt",									false,	"",	dfNone,	0,	false,	false);
        		InitDataProperty(0, cnt++, dtHidden,			90,	daLeft,		false,	"note_dp_seq",							false,	"",	dfNone,	0,	false,	false);
        		InitDataProperty(0, cnt++, dtHidden,			90,	daLeft,		false,	"n1st_cmnc_amdt_seq",			true,	"",	dfNone,	0,	false,	false);
        		InitDataProperty(0, cnt++, dtHidden,			90,	daLeft,		false,	"org_n1st_cmnc_amdt_seq",	true,	"",	dfNone,	0,	false,	false);
        		
    			InitDataProperty(0, cnt++, dtHidden,			85,	daCenter,	true,	"mst_rfa_no",		false,	"",	dfNone,			0,		false,	false);
                InitDataProperty(0, cnt++, dtHidden,              50, daLeft,     true,   "is_exists",             false,  "", dfNone, 0,  false,  false); // Charge Term. mouse over tool tip

    			InitDataCombo(0, "rcv_de_term_cd_ori", termOrgCdText, termOrgCdValue);
    			InitDataCombo(0, "rcv_de_term_cd_dest", termDestCdText, termDestCdValue);
    			InitDataCombo(0, "bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
    			
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
     * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
     * <br><b>Example :</b>
	* <pre>
	*     initControl()
	* </pre>
	* @param 없음
	* @return 없음
	* @author 공백진
	* @version 2009.04.17
	*/
    function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
    	axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
    }
    
    /**
     * OnBeforeActivate   event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */
    function obj_activate() {
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        ComClearSeparator (event.srcElement);
    }
    
    /**
     * OnKeyPress event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress();
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
     * @author 공백진
     * @version 2009.04.17
     */
    function obj_deactivate() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var eleName = event.srcElement.name;
        switch(eleName){
	        case "ctrt_eff_dt":
	        	ComChkObjValid(event.srcElement);
	        	if (checkAmdEffValidation() == false) {
	        		formObj.ctrt_eff_dt.focus();
	        		ComSetFocus(formObj.ctrt_eff_dt);
	        		return false;
	        	}
	        	break;
	        	
            case "ctrt_exp_dt":
                ComChkObjValid(event.srcElement);
                if (checkNewDurValidation() == false) {
                	  formObj.exp_dt.focus();
                	  formObj.exp_dt.select();
                	  return false;
                }
                break;
                
            default:
                ComChkObjValid(event.srcElement);
        }
    }
    
    
    //  ===================================================================================
    //  서버 조회/저장
    //  ===================================================================================
    /**
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
        try{
	    	switch(sAction) {
		    	case IBSEARCH: // 조회
		    		ComOpenWait(true);
		    		formObj.f_cmd.value = SEARCH;
		    		var sXml = sheetObj.GetSearchXml("ESM_PRI_2017GS.do" , FormQueryString(formObj));
		    		var arrXml = sXml.split("|$$|");
		    		
		    		for (var i = 0 , n = arrXml.length; i < n; i++) {
		    			sheetObjects[i].LoadSearchXml(arrXml[i]);
		    		}
		    		break;
		    	case IBSAVE:        //저장
		    		ComOpenWait(true); //->waiting->start
		    		formObj.f_cmd.value = MULTI;
		    		var newDurFlg = "Y";
		    		// Contract Exp Date를 변경하는가 여부
//		    		if (ComGetUnMaskedValue(formObj.pos_exp_dt.value,"ymd") == ComGetUnMaskedValue(formObj.ctrt_exp_dt.value,"ymd")) {
//		    			newDurFlg="N";
//		    		}
		    		var sheetObj2 = sheetObjects[1];
		    		
	                for(var i=sheetObj2.HeaderRows; i<=sheetObj2.RowCount + sheetObj2.HeaderRows; i++) {
	                    //alert(sheetObj2.CellValue(i, "chk"))
	                    if (sheetObj2.CellValue(i, "chk") == "1") {
	                        sheetObj2.RowStatus(i) = "U";
	                        //alert(i)
	                    } else {
	                        sheetObj2.RowStatus(i) = "R";
	                    }
	                }
	                
		    		formObj.eff_dt.value = formObj.ctrt_eff_dt.value;
		    		formObj.exp_dt.value = formObj.ctrt_exp_dt.value;
		    		var sParam = FormQueryString(formObj) + "&new_dur_flg="+ newDurFlg;
		    		
	                var sParamSheet1 = sheetObj2.GetSaveString();
	                //alert(sParamSheet1)
	                sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");		    		
	                //sParam += "&" +sParamSheet1;
	                //alert(sParam)
		    		var sXml = sheetObj.GetSaveXml("ESM_PRI_2017GS.do", sParam);
		    		sheetObj.LoadSaveXml(sXml);
		    		break;
	        }
	    	return true;
        } catch (e) {
          	if (e == "[object Error]") {
                  ComShowMessage(OBJECT_ERROR);
            } else {
                  ComShowMessage(e);
            }
        } finally {
	        ComOpenWait(false); //->waiting->End
        }
    }
    

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
     */
    function validateForm(sheetObj, formObj, sAction){
        var formObj = document.form; 
        var effDtObj = formObj.ctrt_eff_dt;
        var expDtObj = formObj.ctrt_exp_dt;
        
        switch (sAction) {
            case IBSAVE:
             	if(effDtObj.value == "") {
            		ComShowCodeMessage("COM130201","Amend Eff Date");
            		ComSetFocus(effDtObj);
            		return false;
//            	} else if(ComGetDaysBetween(ComGetNowInfo('ymd', ''), formObj.ctrt_eff_dt.value) < 0) {
//                	ComShowCodeMessage("PRI01160"); // Retroactive Filing is not allowed
//                	formObj.ctrt_eff_dt.value = getCtrtEffDate();
//                    return false;
                }
            	
            	if(expDtObj.value == "") {
            		ComShowCodeMessage("COM130201","Amend Duration Exp Date");
            		ComSetFocus(expDtObj);
            		return false;
            	}
            	//alert(1)
            	// Duration 기간 체크. 이전 eff date 이후의날이며 exp date 이전이어야 한다.
           		if (checkNewDurValidation() == false) {
           			return false;
           		}
            	//alert(2)
           		if (!checkAmdEffValidation()) {
                	return false;
                }
//alert(3)
           		if ( !ComPriConfirmSave()) {
 	                 return false;
 	            }
                
            	break;
        }
        return true;
    }
    
    /**
     * 사용자가 입력하는 Duration에 대한 validation을 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		checkNewDurValidation();
     * </pre>
     * @param  없음
     * @return bool  <br>
     * 			true  : 저장 가능
     * 			false : 저장 할 수 없음
     * @author 공백진
     * @version 2009.04.17
     */ 	  
    function checkNewDurValidation(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form; 

        var expDay = ComGetUnMaskedValue(formObj.mst_exp_dt.value,"ymd");
        var posEffDay = ComGetUnMaskedValue(formObj.pos_eff_dt.value,"ymd");
        
        //new duration은 Possible Effective Date보다 클수 없다.
        if (posEffDay > expDay && expDay !=""){
        	ComShowCodeMessage("PRI01089");
        	return false; 
        }
        
       	// 원본의 기간을 넘길 수 없다.
       	if(ComGetDaysBetween(sheetObj.CellValue(1, "exp_dt"), formObj.ctrt_exp_dt.value) > 0) {
       		ComShowCodeMessage("PRI01165");	// msgs['PRI01165'] = 'Duration cannot exceed the original duration for Basic RFA.';
       		formObj.ctrt_exp_dt.value = sheetObj.CellValue(1, "exp_dt");
       		return false;
       	}
        
        return true;
    }
    
    /**
    * 사용자가 입력하는 Amend Effective Date에 대한 validation을 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    * 		checkAmdEffValidation();
    * </pre>
    * @param  없음
    * @return bool  <br>
    * 			true  : 저장 가능
    * 			false : 저장 할 수 없음
    * @author 공백진
    * @version 2009.04.17
    */ 	 
    function checkAmdEffValidation() {
        var sheetObj = sheetObjects[0];
        var formObj = document.form; 
        
        var amdtDay = ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd");
        var posEffDay = ComGetUnMaskedValue(formObj.pos_eff_dt.value,"ymd");
        var posExpDay = ComGetUnMaskedValue(formObj.mst_exp_dt.value,"ymd");
        var msg = " ["+formObj.pos_eff_dt.value + " ~ " + formObj.mst_exp_dt.value +"]"
        
        //alert("amdtDay="+amdtDay+",posEffDay="+posEffDay+",posExpDay="+posExpDay)
         //Amend Date는 previous Effective Date 보다 크거나 입력한 Contract Expire Date 보다 작아야한다.
        if (amdtDay !="" && ( posEffDay > amdtDay || posExpDay < amdtDay) ){
        	ComShowCodeMessage("PRI01088",msg);
        	formObj.ctrt_eff_dt.value = getCtrtEffDate();
        	return false;
        }
       	
        return true;
    }
    
    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * sheet조회 후 sheet의 값을 Html Object의 값으로 setting 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 	sheet1_OnSearchEnd(sheetObj, errMsg)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 공백진
     * @version 2009.05.20
     */ 	
     function sheet1_OnSearchEnd(sheetObj, errMsg) {
     	var formObj = document.form;
     	
     	formObj.mst_amdt_seq.value = sheetObj.CellValue(1,"amdt_seq");
        formObj.mst_eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"eff_dt"),"ymd");
        formObj.mst_exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"exp_dt"),"ymd");
        formObj.svc_scp_cd.value = sheetObj.CellValue(1,"svc_scp_cd");
     	
        // Amend Duration
        formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"eff_dt"),"ymd");
        formObj.pos_eff_dt.value = getCtrtEffDate(); // 입력 가능한 시작일
        formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"exp_dt"),"ymd");
     }
     
     
     /**
      * OnSearchEnd 이벤트 발생시 호출되는 function <br>
      * sheet조회 후 sheet의 값을 Html Object의 값으로 setting 한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *  sheet2_OnSearchEnd(sheetObj, errMsg)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
      * @return 없음
      * @author 공백진
      * @version 2009.05.20
      */     
      function sheet2_OnSearchEnd(sheetObj, errMsg) {
         var formObj = document.form;
         
 
         for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
              if (  sheetObj.CellValue(i, "is_exists") == "Y") {
                  sheetObj.CellEditable(i, "chk") = false;
             }
 
         }
         
      }

    /**
     * Basic RFA의 New Duration Effective Date를 setting한다.<br>
     * 베껴올 Master의 Eff date가 오늘 이전이면 오늘 날짜를, 오늘 이후는 Master의 Eff date를 넣는다.<br>
     */
    function getCtrtEffDate() {
        var sheetObj = sheetObjects[0];
      	var formObj = document.form;
      	
        // Amend Duration
        var gCurrDate = ComGetNowInfo('ymd', '-');
        if(ComGetDaysBetween(ComGetNowInfo('ymd', ''), sheetObj.CellValue(1, "eff_dt")) < 0) {
         	return gCurrDate;
        } else {
        	return  ComGetMaskedValue(sheetObj.CellValue(1,"eff_dt"),"ymd");
        }
    }
    
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 수정 Flag에 Y 로 Setting 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
     	if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
     		rData ="Y";
     	}
 	}
