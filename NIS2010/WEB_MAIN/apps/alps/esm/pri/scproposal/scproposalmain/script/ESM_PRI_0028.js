/*===============================================================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0028.js
 *@FileTitle : S/C Download Record Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.09.18
 *@LastModifier : 현성길
 *@LastVersion : 1.0
 * 
 * 1.0 Creation 
 ===============================================================================================
 * History
 * 2015.09.18 최초생성 현성길 [CHM-201537788] SC 다운로드 보안 강화 _ 2차 개발
===============================================================================================*/

    /**
	 * @extends
	 * @class ESM_PRI_0028 : ESM_PRI_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
    function ESM_PRI_0028() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업 */
    // 공통전역변수
    var tabObjects = new Array();
    var sheetObjects = new Array();
    var sheetCnt = 0;    
    var comboObjects = new Array();
    var comboCnt = 0;
    var formObj = "";
    var gCurrDate;
    var sheet1;

	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    

    /**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * processButtonClick();
	 * </pre>
	 * 
	 * @return 없음
	 * @author 현성길
	 * @version 2015.09.18
	 */
    function processButtonClick() {
      
        var sheetObject = sheetObjects[0];
        var rdoDateObj = formObj.rdoDate;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch (srcName) {                    	
            case "btn_retrieve":
            	doActionIBSheet(sheetObject,formObj,IBSEARCH);
                break;
                
            case "btns_calendar1":
            	var cal = new ComCalendar();
            	cal.select(formObj.scrn_date_from, 'yyyy-MM-dd');
            	break;
            	
            case "btns_calendar2":
            	var cal = new ComCalendar();
            	cal.select(formObj.scrn_date_to, 'yyyy-MM-dd');
            	break;
            	
            case "btns_calendar3":
            	var cal = new ComCalendar();
            	cal.select(formObj.eff_date_from, 'yyyy-MM-dd');
            	break;
            	
            case "btns_calendar4":
            	var cal = new ComCalendar();
            	cal.select(formObj.eff_date_to, 'yyyy-MM-dd');
            	break;

            case "ComOpenPopupWithTarget":	// Office Code 가져오기 팝업
            	ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:prop_ofc_cd", "1,0,1,1,1,1,1,1", true);
            	break;
            	
            case "ComOpenPopupWithTarget1":	// Office Code 가져오기 팝업
            	ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:lgin_ofc", "1,0,1,1,1,1,1,1", true);
            	break;
            	
            case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;
            	
            case "btn_opensc":	
            case "btn_amdhistory":
            	sheet1 = sheetObjects[0];
                var currRow = sheet1.SelectRow;
                if(currRow < 1) return;
                var pgmNo = "ESM_PRI_0003";
                if(srcName == "btn_amdhistory") {
                    pgmNo = "ESM_PRI_0057";
                }
                var scNo = sheet1.CellValue(currRow, "sc_no"); 
                var popParams = "sc_no=" + scNo + "&sc_no_0062=" + scNo + "&prop_no=" + sheet1.CellValue(currRow, "prop_no") + "&amdt_seq=" + sheet1.CellValue(currRow, "amdt_seq");
                comCallPop(pgmNo, "ESM_PRI_0028", popParams, "");
                break;
            }
        }catch(e){
			if( e == "[object Error]") {
				errMsg = ComGetMsg("COM12111" );
				ComShowMessage(errMsg);
			} else {
				ComShowMessage(e);
			}
		}
    }

    /**
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * setSheetObject(sheetObj);
	 * </pre>
	 * 
	 * @param {ibsheet}
	 *            sheet_obj 필수 IBSheet Object
	 * @return 없음
	 * @author 현성길
	 * @version 2015.09.18
	 */    
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
    }
    

    /**
	 * IBMulti Combo Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * setComboObject(combo_obj);
	 * </pre>
	 * 
	 * @param {ibCombo}
	 *            combo_obj 필수 IBMulti Combo Object
	 * @return 없음
	 * @author 현성길
	 * @version 2015.09.18
	 */      
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * loadPage();
	 * </pre>
	 * 
	 * @return 없음
	 * @author 현성길
	 * @version 2015.09.18
	 */
    function loadPage() {
		formObj = document.form;													
		for(i=0;i<sheetObjects.length;i++){

			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);

			ComEndConfigSheet(sheetObjects[i]);
		}
		
		// IBMultiCombo 설정
//		for(var k = 0; k < comboObjects.length; k++){
//			initCombo(comboObjects[k], k + 1);
//		}
		
		// dataformat vaildation
		axon_event.addListenerForm('click', 'obj_click', form);	 
		axon_event.addListenerForm('keypress', 'obj_keypress', form);
		//choi
        axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
		
		ComEnableObject(formObj.eff_date_from, false); // access date disabled
		ComEnableObject(formObj.eff_date_to, false); // access date disabled
        gCurrDate = ComGetNowInfo('ymd', '-');
        form.scrn_date_from.value = gCurrDate;
        form.scrn_date_to.value = gCurrDate;
		
		
		getPriIbComboList(formObj.s_scrn_prog_cd , s_scrn_prog_cdCode , s_scrn_prog_cdText , 'ALL'); // Screen Code
		getPriIbComboList(formObj.s_cust_tp_cd , s_cust_tp_cdCode , s_cust_tp_cdText , 'ALL'); // Customer Type CD
		getPriIbComboList(formObj.s_cur_tp_cd , 'KO|NY|SH|SI|HA' , 'KST(KOREA)|EST(NYC)|SHA|SIN|HAM' , 'ALL'); // Screen Open Date 화폐 타입
		formObj.s_cur_tp_cd.code2 = 'KO';
		//initPage();
	//	initControl();
	}
    
    
    
    
    function initPage(){
		formObj = document.form;
		
		// 오늘날짜 데이터 세팅
		var d = new Date(); 
		var month = d.getMonth()+1;
		var date = d.getDate();
		
		if(month <10){
			month = "0"+ month;
		}
		
		if(date <10){
			date = "0"+ date;
		}
		
		var today = d.getFullYear()+ "-" + month + "-" +date;
		 
		formObj.scrn_date_from.value = today;
		formObj.scrn_date_to.value = today;
	}
     
      
    
    
    /**
	 * 시트 초기설정값, 헤더 정의 <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * initSheet(sheetObj, 1);
	 * </pre>
	 * 
	 * @param {ibsheet}
	 *            sheetObj 필수 IBSheet Object
	 * @param {int}
	 *            sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 현성길
	 * @version 2015.09.18
	 */
    function initSheet(sheetObj, sheetNo) {
	 	var cnt = 0;
	 	switch(sheetNo) {
	    	case 1:      // sheet1 init
		    	with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(20);
					// 전체 너비 설정
//					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    // 전체Edit 허용 여부 [선택, Default false]
				    Editable = true;
				    
				    Ellipsis = true; 
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 14, 10);


					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle  = "|SEQ|S/C NO.|AMD\nSEQ|Prop No|Customer|Real\nCustomer|C.OFC|Customer\nType|Status\n(I/R/A/F/Rt)|Filed EFF DT\n(EST)|Log in\nID|User\nName|Log In\nOffice|User S.Rep\nCode|IP Address|Download\nScreen|Screen Open|Save Time|Close Time";
					var HeadCount = ComCountHeadTitle(HeadTitle);
					InitColumnInfo(HeadCount, 0, 0, true);
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
						InitDataProperty(0, cnt++ , dtSeq,          40,  	daCenter,   true,   "seq");
		                InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "sc_no", false, "", dfNone, 0, false, false);
		                InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "amdt_seq", false, "", dfNone, 0, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
		                InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "cust_nm", false, "", dfNone, 0, false, false);
		                InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "real_cust_nm", false, "", dfNone, 0, false, false);                              
		                InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "prop_ofc_cd", false, "", dfNone, 0, false, false);                              
		                InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cust_tp_cd", false, "", dfNone, 0, false, false);                              
		                InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "status", false, "", dfNone, 0, false, false);
		                InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "file_dt", false, "", dfDateYmd, 0, false, false);
		                InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "lgin_id", false, "", dfNone, 0, false, false);                             
		                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "usr_nm", false, "", dfNone, 0, false, false);
		                InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "lgin_ofc", false, "", dfNone, 0, false, false);
		                InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "srep_cd", false, "", dfNone, 0, false, false);
		                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "ip_addr", false, "", dfNone, 0, false, false);                               
		                InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "dl_scrn", false, "", dfNone, 0, false, false);
		                InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "open_time", false, "",  dfNone, 0, false, false);                
		                InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "save_time", false, "", dfNone, 0, false, false);              
		                InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "close_time", false, "", dfNone, 0, false, false);  
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
     * @author 현성길
     * @version 2015.09.18
     */    
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        try{
            switch (sAction) {            
            case IBSEARCH: // 조회
            	if(validateForm(sheetObj,formObj,sAction)) {
	            	sheetObj = sheetObjects[0];
	            	sheetObjects[0].RemoveAll();
					formObj.f_cmd.value = SEARCH;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("ESM_PRI_0028GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
	            }       
            	break;
        	case IBDOWNEXCEL:  // EXCEL
				sheetObj.SpeedDown2Excel(true);
				break;
            } 
         
    }
        catch(e){}
    }
    
    /**
	 * Combo 기본 설정, Combo의 항목을 설정한다. <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * initCombo(comboObj, 1);
	 * </pre>
	 * 
	 * @param {IBMultiCombo}
	 *            comboObj 필수 IBMultiCombo Object
	 * @param {int}
	 *            comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 현성길
	 * @version 2015.09.18
	 */        
    function initCombo(comboObj, comboNo) {
    	switch(comboObj.id) {
//        case "s_cur_tp_cd":
//        	formObj.s_cur_tp_cd.code2= 03;
//        	break;
            }
   }
    
    
    
   /**
     * Object 의 Onclick 이벤트핸들러 <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 현성길
     * @version 2015.09.18
     */
    function obj_click(){
        var obj = event.srcElement;
        var objScrnDtFrom = formObj.scrn_date_from;
        var objScrnDtTo = formObj.scrn_date_to;
        var objEffDtFrom = formObj.eff_date_from;
        var objEffDtTo = formObj.eff_date_to;
        var objCurTpCd = formObj.s_cur_tp_cd;
        var tmpDt;
        switch(obj.name){
            case "rdoDate":
                if(obj.value == "1") {
                    tmpDt = objEffDtFrom.value;
                    objScrnDtTo.value = "";
                    objScrnDtFrom.value = "";
                    formObj.s_cur_tp_cd.code2 = '';
                    
                    ComEnableObject(objScrnDtFrom, false);
                    ComEnableObject(objScrnDtTo, false);
                    objCurTpCd.Enable = false;
                    ComEnableObject(objEffDtFrom, true);
                    ComEnableObject(objEffDtTo, true);
                    objEffDtFrom.className = "input1";
                    objEffDtTo.className = "input1";
                    
                    if(tmpDt.length >= 8) {
                        objEffDtFrom.value = tmpDt;
                        objEffDtTo.value = tmpDt;
                    }else{
                        objEffDtFrom.value = gCurrDate;
                        objEffDtTo.value = gCurrDate;
                    }
                }else{
                    tmpDt = objEffDtFrom.value;
                    objEffDtFrom.value = "";
                    objEffDtTo.value = "";
                    formObj.s_cur_tp_cd.code2 = 'KO';
                    
                    ComEnableObject(objScrnDtFrom, true);
                    ComEnableObject(objScrnDtTo, true);
                    objCurTpCd.Enable = true;
                    ComEnableObject(objEffDtFrom, false);
                    ComEnableObject(objEffDtTo, false);
                    objScrnDtFrom.className = "input1";
                    objScrnDtTo.className = "input1";
                    
                    if(tmpDt.length >= 8) {
                    	objScrnDtFrom.value = tmpDt;
                    	objScrnDtTo.value = tmpDt;
                    }else{
                    	objScrnDtFrom.value = gCurrDate;
                    	objScrnDtTo.value = gCurrDate;
                    }
                }
                break;
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
     * @author 현성길
     * @version 2015.09.18
     */ 
    function obj_keypress(){
        var obj = event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;
        var except_chr = "32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|58|59|60|61|62|63|64|91|92|93|94|95|96|123|124|125|126";
        switch(obj.dataformat){
            case "ymd": //날짜 입력하기
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "int": //숫자만 입력
            case "number": //숫자만 입력        
                ComKeyOnlyNumber(obj);
                break;
            case "engup":
            	if (event.srcElement.name == "sc_no") {
                    ComKeyOnlyAlphabet('uppernum');
                } else if (event.srcElement.name == "cust_nm") {
                	ComKeyOnlyAlphabet('uppernum',except_chr);
                } else if (event.srcElement.name == "act_cust_nm") {
                	ComKeyOnlyAlphabet('uppernum',except_chr);	
                } else {
                ComKeyOnlyAlphabet('upper');
                }
                break;
            default:
                //ComKeyOnlyNumber(obj);
                break;
        }
    }
    
    
    
    function validateForm(sheetObj,formObj,sAction){
        var form = document.form;
        switch (sAction) {
            case IBSEARCH: //조회
                var rdoDateObj = form.rdoDate;
                if(rdoDateObj[0].checked) {
                    if(!ComChkObjValid(form.scrn_date_from)) {return false;}
                    if(!ComChkObjValid(form.scrn_date_to)) {return false;}
                }else{
                	if(!ComChkObjValid(form.eff_date_from)) {return false;}
                    if(!ComChkObjValid(form.eff_date_to)) {return false;}
                }
                break;
        }

        return true;
        
//        
//    	var rtn = true;
//    	var cnt = 0;
//    	var a = formObj.scrn_date_from.value.split('-');
//    	var b = formObj.scrn_date_to.value.split('-');
//    	var c = formObj.eff_date_from.value.split('-');
//    	var d = formObj.eff_date_to.value.split('-');
//    	
//        with(formObj){
//        	
//        	if(formObj.elements['rdoDate'][0].checked == true){
//        		if ( formObj.scrn_date_from.value =='' || formObj.scrn_date_to.value == '') {
//            		ComShowCodeMessage("PRI01042", "Log Time");
//            		ComSetFocus(formObj.scrn_date_from);
//            		rtn = false;		
//            }
//        	else {
//	    		for(var i=0; i < a.length; i++){
//	        		if(b[i] - a[i] < 0){
//	        			cnt = 1;
//	        		}
//	        	}
//	    		rtn = true;
//	    	}
//        	}else{
//        		if ( formObj.eff_date_from.value =='' || formObj.eff_date_to.value == '') {
//            		ComShowCodeMessage("PRI01042", "Effective Time");
//            		ComSetFocus(formObj.eff_date_from);
//            		rtn = false;		
//        		}
//        		else {
//        			for(var i=0; i < c.length; i++){
//        				if(d[i] - c[i] < 0){
//        					cnt = 1;
//        				}
//	        	}
//	    		rtn = true;
//	    	}
//        	}
//        	
//           }
//    	
//    	if(cnt == 1){
//    		ComShowCodeMessage("PRI00321", "To_Date" , "From_Date");
//    		rtn = false;
//    	}
//        return rtn;
    }
    
    
    // 추가~~~
    /**
     * OnBeforeActivate event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param 없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2010.02.26
     */
    function obj_activate() {
        ComClearSeparator (event.srcElement);
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
        var formObj = event.srcElement;
        var srcName = formObj.getAttribute("name");
        switch(srcName) {
            default :
                ComChkObjValid(formObj);
        }
    }    
  
     /* 개발자 작업 끝 */