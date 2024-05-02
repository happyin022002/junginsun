/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0113.js
*@FileTitle :  Inland Transmode Comparison
*Open Issues :
*Change history :
*@LastModifyDate : 2013-12-18
*@LastModifier : 조인영
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
     * @class ESD_TRS_0113 : esd_trs_0113 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_trs_0113() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0; 

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0];
         
         /*******************************************************/
         var formObject = document.form;
 		 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "from_to_calendar": // From 달력버튼
	                	var cal = new ComCalendarFromTo();
	                	cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
		   	            break;
                    
					case "btn_retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;
						
					case "btn_new":
						fn_reset();
						break;

					case "btns_office":
						if( validation_check() ) {
							var ofc_cd = formObject.input_office.value;
							ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
						}  
						break;

					case "btn_down_excel":
						sheetObject1.SpeedDown2Excel(-1);
						break;
						
					case "btns_frmnode": //FromNode Popup창
						openHireYardPopup('getFromNode');
					break;

					case "btns_vianode": //ViaNode Popup창
						openHireYardPopup('getViaNode');
					break;

					case "btns_tonode": //ToNode Popup창
						openHireYardPopup('getToNode');
					break;

					case "btns_dorloc": //DoorLocation Popup창
						openHireYardPopup('getDorLoc');
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

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Combo Object를 배열로 등록
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
    	//From Date 날짜 세팅
    	set_from_date();
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,COMMAND01); 	
    }

    //From Date 날짜 세팅
    function set_from_date(){
    	var formObj = document.form;
    	var vNowDate = formObj.now_date.value;
    	var vlastDay = formObj.last_day.value;
    	formObj.from_date.value = ComGetDateAdd(vNowDate, "M", 0).substr(0, 8)+"01";
    	formObj.to_date.value = vlastDay.substr(0,4)+"-"+vlastDay.substr(4,2)+"-"+vlastDay.substr(6,2); 
    }

	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
					// 높이 설정
                    style.height = 400;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 9, 100);

					var HeadTitle1 = "Seq.|Comparison Result\n(SO vs BKG)|IHC P&L|S/O|S/O|S/O|S/O|S/O|S/O|S/O|S/O|S/O|W/O\nOffice|W/O No.|W/O\nIssue Date|CNTR No.|TP/SZ|BKG No.|S/O|S/O|S/O|S/O|S/O|TRO|TRO|TRO|BKG|BKG|BKG|BKG|BKG|BKG|BKG|BKG|BKG|BKG|BKG|BKG|BKG|RFA No.|SC No.|TAA No.|Reason of Trans Mode\n/ Node Change in S/O";
					var HeadTitle2 = "Seq.|Comparison Result\n(SO vs BKG)|IHC P&L|S/O No.|BND|Cost\nMode|From|Via|To|Door|S/O\nOffice|S/O\nC.Date|W/O\nOffice|W/O No.|W/O\nIssue Date|CNTR No.|TP/SZ|BKG No.|Trans\nMode|Cur.|Amount|Amount\n(USD)|Total AMT(USD)\nby BKG/Bound|Trans\nMode|Office|Confirm|Charge\nTrans Mode|Charge|Cur.|Rate|Rate\n(USD)|Rated\nAs|Per|Amount|Amount\n(USD)|Row\nCount|In|M|IHC Total AMT(USD)\nby BKG/Bound|RFA No.|SC No.|TAA No.|Reason of Trans Mode\n/ Node Change in S/O";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq, 	30,	    daCenter,	true,	prefix+"seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	108,	daCenter,	true,	prefix+"comp_result", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	90,		daCenter,	true,	prefix+"inland_pnl", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtPopup, 80,	    daCenter,	true,	prefix+"so_no", 	false, "", dfNone, 0, true, false);
					InitDataProperty(0, cnt++, dtData, 	30,		daCenter,	true,	prefix+"trsp_bnd_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	40,		daCenter,	true,	prefix+"trsp_cost_dtl_mod_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daCenter,	true,	prefix+"fm_nod_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daCenter,	true,	prefix+"via_nod_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daCenter,	true,	prefix+"to_nod_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daCenter,	true,	prefix+"dor_nod_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,		daCenter,	true,	prefix+"so_ofc_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,		daCenter,	true,	prefix+"so_cre_dt", 	false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,		daCenter,	true,	prefix+"wo_ofc_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daCenter,	true,	prefix+"wo_no", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,		daCenter,	true,	prefix+"wo_iss_dt", 	false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daCenter,	true,	prefix+"eq_no", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	40,		daCenter,	true,	prefix+"eq_tpsz_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtPopup, 	80,		daCenter,	true,	prefix+"bkg_no", 	false, "", dfNone, 0, true, false);
					InitDataProperty(0, cnt++, dtData, 	40,		daCenter,	true,	prefix+"so_trns_mod", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	40,		daCenter,	true,	prefix+"so_curr_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daRight,	true,	prefix+"so_tot_amt", 	false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daRight,	true,	prefix+"so_tot_amt_usd", 	false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtHidden, 	100,		daRight,	true,	prefix+"so_bkg_sum_usd", 	false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	40,		daCenter,	true,	prefix+"tro_trns_mod", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,		daCenter,	true,	prefix+"tro_ofc_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,		daCenter,	true,	prefix+"tro_cnfm", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	65,		daCenter,	true,	prefix+"chg_trns_mod", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	45,		daCenter,	true,	prefix+"chg_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	40,		daCenter,	true,	prefix+"chg_curr_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daRight,	true,	prefix+"chg_ut_amt", 	false, "", dfNullFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daRight,	true,	prefix+"chg_rt_usd", 	false, "", dfNullFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	40,		daRight,	true,	prefix+"rat_as_qty", 	false, "", dfNullFloat, 3, false, false);
					InitDataProperty(0, cnt++, dtData, 	30,		daCenter,	true,	prefix+"rat_ut_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daRight,	true,	prefix+"chg_amt", 	false, "", dfNullFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daRight,	true,	prefix+"chg_amt_usd", 	false, "", dfNullFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	35,		daCenter,	true,	prefix+"row_cnt", 	false, "", dfNullInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	30,		daCenter,	true,	prefix+"incl_oft_flg", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	30,		daCenter,	true,	prefix+"auto_rat_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 	120,		daRight,	true,	prefix+"ihc_sum_usd", 	false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,		daCenter,	true,	prefix+"rfa_no", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,		daCenter,	true,	prefix+"sc_no", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,		daCenter,	true,	prefix+"taa_no", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	180,		daCenter,	true,	prefix+"cng_rsn_desc", 	false, "", dfNone, 0, false, false);
					}
				break;
        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					
					var arr = new Array("sheet1_", "");
		        	var sParam = FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr);
					var sXml = sheetObj.GetSearchXml("ESD_TRS_0113GS.do", sParam);
					if(sXml.length>0){
						sheetObj.LoadSearchXml(sXml);
					}
				}	
				break;
				
		  	 case COMMAND01:
		  		 	formObj.f_cmd.value = COMMAND01;
				
		  		 	var sXml = sheetObj.GetSearchXml("ESD_TRS_0104GS.do", FormQueryString(formObj));
		  		 	var arrXml = sXml.split("|$$|");
		  		 	if (arrXml.length > 0) 
		  		 		ComXml2ComboItem(arrXml[2], formObj.sel_so_trns_mod, "val", "name");
		  		 		ComXml2ComboItem(arrXml[2], formObj.sel_bkg_trns_mod, "val", "name");
		  		 	
		  		 	formObj.sel_so_trns_mod.MultiSelect = true;
		  		 	formObj.sel_bkg_trns_mod.MultiSelect = true;
					formObj.sel_so_trns_mod.index = 0;						
					formObj.sel_bkg_trns_mod.index = 0;						
		  		 break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH:
				if(isNull(formObj.sel_bkg_no.value) && isNull(formObj.so_wo_no.value)){
					
					if(isNull(formObj.from_date.value)){
						ComShowCodeMessage("COM130201", "From to Date");
						formObj.from_date.focus();
						return false;
			      	}else if(isNull(formObj.to_date.value)){
						ComShowCodeMessage("COM130201", "From to Date");
						formObj.to_date.focus();
						return false;
			      	}else if(isNull(formObj.input_office.value)){
						ComShowCodeMessage("COM130201", "S/O Office Code");
						formObj.input_office.focus();
						return false;
			      	}
				}
				var days_between = ComGetDaysBetween(formObj.from_date , formObj.to_date) ;  // 조회 기간

				if( days_between   < 0) {
					ComShowCodeMessage("TRS90118");
					formObj.from_date.focus();
					return false;
				} 
				if ( days_between > 31 ) {
					ComShowMessage(" Possible inquiry period is limited to 1 month.");
					return false;
				}
				break;
		}
        return true;
    }

    /* initControl() */
    function initControl() {
 		axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
    	axon_event.addListenerFormat('focus', 'obj_activate', form);
    	axon_event.addListenerForm ('blur', 'obj_blur', form);
    }
    
    //업무 자바스크립트 OnFocus 이벤트 처리
    function obj_activate() {
       	//마스크 구분자 없애기
        //ComClearSeparator(event.srcElement);
           
       	switch(event.srcElement.name){ 	    	
       		case "from_date":
       			ComClearSeparator(event.srcElement);
       			event.srcElement.select();
       			break;
       		case "to_date":
       			ComClearSeparator(event.srcElement);
       			event.srcElement.select();
       			break;
       	}
    }

    /** 
     * 업무 자바스크립트 Onblur 이벤트 처리  <br>
     */    
    function obj_blur(){
    	obj = event.srcElement;
    	var formObj = document.form;

    	switch(obj.name) {
			case "from_date":
    			if( formObj.from_date.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("from_date", "");
                    	setFocus("from_date");
                    	return false;
                    }
                }
    			break;
    		case "to_date":
    			if( formObj.to_date.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("to_date", "");
                    	setFocus("to_date");
                    	return false;
                    }
                }
    			break;
    	}
    }
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		for(var i=sheetObj.HeaderRows ; i<=sheetObj.RowCount+1 ; i++){
			sheetObj.CellFont("FontBold", i,'sheet1_so_trns_mod') = true;
			sheetObj.CellFont("FontBold", i,'sheet1_so_tot_amt_usd') = true;
			sheetObj.CellFont("FontBold", i,'sheet1_chg_rt_usd') = true;
			sheetObj.CellFont("FontBold", i,'sheet1_chg_trns_mod') = true;
			
			if(sheetObj.CellValue(i,'sheet1_trsp_bnd_cd') == 'I' && sheetObj.CellValue(i,'sheet1_trsp_cost_dtl_mod_cd') == 'DR') {
				sheetObj.CellFont("FontBold", i,'sheet1_fm_nod_cd') = true;
				sheetObj.CellFont("FontBold", i,'sheet1_dor_nod_cd') = true;
			}else if(sheetObj.CellValue(i,'sheet1_trsp_bnd_cd') == 'I' && sheetObj.CellValue(i,'sheet1_trsp_cost_dtl_mod_cd') == 'CY') {
				sheetObj.CellFont("FontBold", i,'sheet1_fm_nod_cd') = true;
				sheetObj.CellFont("FontBold", i,'sheet1_to_nod_cd') = true;
			}else if(sheetObj.CellValue(i,'sheet1_trsp_bnd_cd') == 'O' && sheetObj.CellValue(i,'sheet1_trsp_cost_dtl_mod_cd') == 'DR') {
				sheetObj.CellFont("FontBold", i,'sheet1_dor_nod_cd') = true;
				sheetObj.CellFont("FontBold", i,'sheet1_to_nod_cd') = true;
			}else if(sheetObj.CellValue(i,'sheet1_trsp_bnd_cd') == 'O' && sheetObj.CellValue(i,'sheet1_trsp_cost_dtl_mod_cd') == 'CY') {
				sheetObj.CellFont("FontBold", i,'sheet1_fm_nod_cd') = true;
				sheetObj.CellFont("FontBold", i,'sheet1_to_nod_cd') = true;
			}

			if(sheetObj.CellValue(i,'sheet1_incl_oft_flg') == 'I') {
				sheetObj.CellFont("FontItalic", i,'sheet1_chg_cd') = true;
				sheetObj.CellFont("FontItalic", i,'sheet1_chg_curr_cd') = true;
				sheetObj.CellFont("FontItalic", i,'sheet1_chg_ut_amt') = true;
				sheetObj.CellFont("FontItalic", i,'sheet1_rat_as_qty') = true;
				sheetObj.CellFont("FontItalic", i,'sheet1_rat_ut_cd') = true;
				sheetObj.CellFont("FontItalic", i,'sheet1_chg_amt') = true;
				sheetObj.CellFont("FontItalic", i,'sheet1_chg_amt_usd') = true;
				sheetObj.CellFont("FontItalic", i,'sheet1_row_cnt') = true;
				sheetObj.CellFont("FontItalic", i,'sheet1_incl_oft_flg') = true;
				sheetObj.CellFont("FontItalic", i,'sheet1_auto_rat_cd') = true;
				sheetObj.CellFont("FontItalic", i,'sheet1_chg_rt_usd') = true;
			}
		}
	}

	/**
     * Get Object Value
     */
    function getObjValue(name) {
    	return ComGetObjValue(eval("document.form."+name));
    }
    
    /**
     * Set Object Value
     */
    function setObjValue(name, value) {
    	ComSetObjValue(eval("document.form."+name), value);
    }
    
    /**
     * Move Focus in Object
     */
    function setFocus(name) {
    	ComSetFocus(eval("document.form."+name));
    	eval("document.form."+name).select();
    }

	/**
	* 화면 폼입력값에 Null Check
	*/
	function isNull(itemValue){
	   if(itemValue==null || itemValue=="" || itemValue=="undefined"){
	   	return true;
	   }
	   else{
	   	return false;
	   }
	}

//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.input_office.value = obj;
}
	
//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}
	
//Include Check Bok를 Click했을 때
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text

	if(doc_office.checked == true){
		document.form.incl_sub_ofc_flg.value="Y";
	}else{
		document.form.incl_sub_ofc_flg.value="N";
	}
	
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.input_office.value = "";
		ComShowCodeMessage("TRS90522");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.input_office.value = document.form.old_ofc_cd.value;
	}
}

//Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.input_office.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

//Office-PopUp Validation Checked
function validation_check() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text
	var aoffice = prm_office.split(",");
	if( prm_office == "" ) {
		document.form.input_office.value = "";
		ComShowCodeMessage("TRS90522");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowCodeMessage("TRS90523");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;		
		} else {
			ComShowCodeMessage("TRS90523");
			return false;
		}
	}
}

/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset(){

	var formObject = document.form;	

	sheetObjects[0].RemoveAll();  //Master sheet
	formObject.reset();

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
	formObject.search_fm_node.value = node;
}

/**
 * Via Node 팝업에 대한 리턴값
 */
function getViaNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	formObject.search_via_node.value = node;
}

/**
 * To Node 팝업에 대한 리턴값
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	formObject.search_to_node.value = node;
}

/**
 * Door Location 팝업에 대한 리턴값
 */
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	formObject.search_door_node.value = node;
}

/*
 * Compact 체크박스 선택 시
 */
function chkCompactOption(){
	if(document.form.chk_compact.checked == true){
		sheetObjects[0].ColHidden("sheet1_wo_ofc_cd") = true;
		sheetObjects[0].ColHidden("sheet1_wo_no") = true;
		sheetObjects[0].ColHidden("sheet1_wo_iss_dt") = true;
		sheetObjects[0].ColHidden("sheet1_eq_no") = true;
		sheetObjects[0].ColHidden("sheet1_eq_tpsz_cd") = true;
		sheetObjects[0].ColHidden("sheet1_tro_trns_mod") = true;
		sheetObjects[0].ColHidden("sheet1_tro_ofc_cd") = true;
		sheetObjects[0].ColHidden("sheet1_tro_cnfm") = true;
		sheetObjects[0].ColHidden("sheet1_rfa_no") = true;
		sheetObjects[0].ColHidden("sheet1_sc_no") = true;
		sheetObjects[0].ColHidden("sheet1_taa_no") = true;
		sheetObjects[0].ColHidden("sheet1_cng_rsn_desc") = true;
	} else {
		sheetObjects[0].ColHidden("sheet1_wo_ofc_cd") = false;
		sheetObjects[0].ColHidden("sheet1_wo_no") = false;
		sheetObjects[0].ColHidden("sheet1_wo_iss_dt") = false;
		sheetObjects[0].ColHidden("sheet1_eq_no") = false;
		sheetObjects[0].ColHidden("sheet1_eq_tpsz_cd") = false;
		sheetObjects[0].ColHidden("sheet1_tro_trns_mod") = false;
		sheetObjects[0].ColHidden("sheet1_tro_ofc_cd") = false;
		sheetObjects[0].ColHidden("sheet1_tro_cnfm") = false;
		sheetObjects[0].ColHidden("sheet1_rfa_no") = false;
		sheetObjects[0].ColHidden("sheet1_sc_no") = false;
		sheetObjects[0].ColHidden("sheet1_taa_no") = false;
		sheetObjects[0].ColHidden("sheet1_cng_rsn_desc") = false;  
	}
}

function sel_so_trns_mod_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
} 

function sel_bkg_trns_mod_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
} 


function sheet1_OnPopupClick (sheetObj , row , col )
{
	var colName = sheetObj.ColSaveName(col);
	var value = sheetObj.CellValue(row, colName);

	switch(colName)
	{

		case('sheet1_so_no'):
			goSoInquiry(sheetObj, row, col);
		break;

		case('sheet1_bkg_no'):
			goBkgInquiry(sheetObj, row, col);
		break;
	}
}

/**
 * S/O Inquiry popup
 **/
function goSoInquiry(sheetObj, row, col){

	var param = "?sowonumber="+sheetObj.CellValue(row, 'sheet1_so_no');
	var option = "scroll:yes,status:yes,help:no,width=1000,Height=680,resizable=yes";

	window.open('/hanjin/ESD_TRS_0019.do'+param, 'popupSo'+row, option);

}

/**
 * BKG Inquiry popup
 **/
function goBkgInquiry(sheetObj, row, col){

	var param = "?openTab=B8&bkg_no="+sheetObj.CellValue(row, 'sheet1_bkg_no');
	var option = "scroll:no,status:yes,help:no,width=1005,Height=680,resizable=yes";

	window.open('/hanjin/ESM_BKG_0079_Q.do'+param, 'popupBkg'+row, option);

}

function doSearch() {
	var sheetObject = sheetObjects[0];
	var formObject  = document.form;
	doActionIBSheet(sheetObject,formObject,IBSEARCH);
}

function doSearchEnter() {
	if( event.keyCode == 13 ) {
		doSearch();
	}
}
	/* 개발자 작업  끝 */