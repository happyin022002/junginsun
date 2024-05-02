/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0404.js
*@FileTitle  : Vessel Entry Status View
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* 개발자 작업	*/
	// common global variables 
	var sheetObjects=new Array(); 
	var sheetCnt=0;
   	var prefix="sheet_";
	var popupType;
	//IBMultiCombo
	var comboObjects=new Array();
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Retrieve":
	             	if(!CoCniInitConfirm(sheetObject1)) return;
	             	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break; 
                case "btn_New":
	             	if(!CoCniInitConfirm(sheetObject1)) return;
					ComResetAll();
					combo_insur_period.SetSelectCode("INS_IN");
                    break; 
               	case "btn_Print":
					if (sheetObject1.RowCount()<= 0 ) {
						ComShowCodeMessage("CNI00024");
						return;
					}
					var vParam="/rp ";
//					var insurPeriod=formObject.insur_period.value;
					var insurPeriod=formObject.combo_insur_period_text.value;
					if (insurPeriod == "INS_IN") {
						vParam=vParam + "[ AND	A.INSUR_EFF_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					} else if (insurPeriod == "INS_IN") {
						vParam=vParam + "[ AND	A.INSUR_EXP_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					} else if (insurPeriod == "INS_IN") {
						vParam=vParam + "[ AND	A.VSL_OSHP_EFF_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					} else {
						vParam=vParam + "[ AND	A.VSL_OSHP_EXP_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					}
					vParam=vParam + "[" + combo_insur_period.GetSelectText()+ "] ";
					vParam=vParam + "[" + formObject.insur_eff_dt.value + "] ";
					vParam=vParam + "[" + formObject.insur_exp_dt.value + "] ";
					vParam=vParam + "[" + formObject.insur_cvrg_cd.value + "] ";
					vParam=vParam + "[" + formObject.insur_clm_pty_no.value + "] ";
					vParam=vParam + "[" + formObject.insur_clm_pty_nm.value + "] ";
					vParam=vParam + "[" + formObject.vsl_eng_nm.value + "] ";
					vParam=vParam + "[" + formObject.vsl_cd.value + "] ";
					vParam=vParam + "[" + formObject.insur_vsl_tp_cd.value + "] ";
					vParam=vParam + "[" + formObject.insur_vsl_oshp_cd.value + "] ";
					vParam=vParam + "[" + formObject.insur_tp_cd.value + "] ";
					ComSetObjValue(formObject.com_mrdPath,"apps/opus/cps/cni/insurance/vesselstatus/report/CPS_CNI_0405.mrd");
					ComSetObjValue(formObject.com_mrdArguments, vParam); 
					ComSetObjValue(formObject.com_mrdTitle,"Entry Status");
					ComOpenRDPopup('resizable=yes');
                    break; 
                case "cal_insur_eff_dt":
					var cal=new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.insur_eff_dt, 'yyyy-MM-dd');
                    break; 
                case "cal_insur_exp_dt":
					var cal=new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.insur_exp_dt, 'yyyy-MM-dd');
                    break; 
               	case "pop_insur_clm_pty_nm":
               		popupType=srcName;
					popupMainCodeInquiry();
                    break; 
                case "btn_Row_Add":
	          		if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var row=sheetObject1.DataInsert(-1);
					break;
                case "btn_Row_Insert":
	          		if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var row=sheetObject1.DataInsert();
                    break; 
                case "btn_Row_Delete":
					if(ComCniCheckBoxCheckYn(sheetObject1, prefix+"DelChk")) { 
						ComRowHideDelete(sheetObject1, prefix+"DelChk"); 
					}
                    break;
				case "btn_DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						var strColSkipList=prefix + "ibflag|" + prefix + "DelChk";
						sheetObject1.Down2Excel({ HiddenColumn:0,TreeLevel:false});
					}
                    break; 
                
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. If the problem persists, please contact your system administrator.");
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;	
    }
	/**
	* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
	**/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].SetExtendLastCol(0);
        //html컨트롤 이벤트initializing
        initControl();
        sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * Sheet의 Load가 끝났을때 발생되는 이벤트
     */
    function sheet1_OnLoadFinish(sheetObj) {
		sheetObj.SetWaitImageVisible(0);
		initMiscCode(sheetObj);   
		//Sheet의 콤보는 text가 아니라 code가 보이도록 처리
    	sheetObj.SetColProperty(0,prefix+"insur_vsl_tp_cd", {ComboText:"|"+sheetObj.GetComboInfo(0 ,prefix+"insur_vsl_tp_cd"), ComboCode:"Code"+"|"+sheetObj.GetComboInfo(0)});
    	sheetObj.SetColProperty(0,prefix+"insur_vsl_clss_nm", {ComboText:"|"+sheetObj.GetComboInfo(0 ,prefix+"insur_vsl_clss_nm"), ComboCode:"Code"+"|"+sheetObj.GetComboInfo(0)} );
    	sheetObj.SetColProperty(0,prefix+"insur_vsl_oshp_cd", {ComboText:"|"+sheetObj.GetComboInfo(0 ,prefix+"insur_vsl_oshp_cd"), ComboCode:"Code"+"|"+sheetObj.GetComboInfo(0)} );
    	sheetObj.SetColProperty(0,prefix+"insur_tp_cd", {ComboText:"|"+sheetObj.GetComboInfo(0 ,prefix+"insur_tp_cd"), ComboCode:"Code"+"|"+sheetObj.GetComboInfo(0)} );
    	sheetObj.SetColProperty(0,prefix+"insur_cvrg_cd", {ComboText:sheetObj.GetComboInfo(0 ,prefix+"insur_cvrg_cd"), ComboCode:"Code"+"|"+sheetObj.GetComboInfo(0)} );
		sheetObj.SetWaitImageVisible(1);
    } 
	/**
	* 콤보 Miscellaneous 코드값 가져오기
    * @param {ibsheet} sheetObj    IBSheet Object
	*/
    function initMiscCode(sheetObj) {
		sheetObj.SetWaitImageVisible(0);
		// IBMultiComboinitializing
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k]);
		}
		//MISCELLANEOUS 코드 정보를 가져온다
		doActionIBSheet(sheetObj,document.form,IBROWSEARCH, "ComCd");
	//	combo_insur_period.DeleteItem("");
		combo_insur_period.SetSelectCode("INS_IN");
		sheetObj.SetWaitImageVisible(1);
		 
    } 
	/**
	* 콤보 초기설정값
	* @param {IBMultiCombo} comboObj  comboObj
	*/
	function initCombo(comboObj) {
		comboObj.SetMultiSelect(0);
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator(",");
		comboObj.SetDropHeight(190);
	}
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 initializing 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('blur'	, 'obj_deactivate', form); 							//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        //axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 				//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    //	axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'  , form);
        //axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
        //axon_event.addListener  ('keypress', 'obj_keypress' , form);							//- form 전체 컨트롤 중 keypress 이벤트 발생시
        //axon_event.addListener  ('change'  , 'party_change', 'insur_clm_pty_nm');				//- Party name 삭제시 party no 삭제
    }
 	//focus in
 	function obj_activate(){
 		obj=event.srcElement;
 		if (obj.getAttribute("readOnly")) return;
 		ComClearSeparator(obj);
 	} 
    /**
     * checking validation
     **/
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }
    /**
     * only numbers
     **/
//    function obj_keypress(){
//    	switch(event.srcElement.name){
//	        case "vsl_cd":
//	            ComKeyOnlyAlphabet('upper');
//	            break;
//	        case "insur_clm_pty_nm":
//	        	if (event.keyCode > 0) event.returnValue=false;;
//	            break;
//			default:
//		        //only numbers
//		        ComKeyOnlyNumber(event.srcElement);
//    	}
//    }
    /**
     * Party name 삭제시 party no 삭제. <br>
     **/
    function party_change() {
    	var obj=ComGetEvent();
    	if (obj.value == "") {
			eval("form."+obj.name.substring(0,obj.name.length-1)+"o").value='';
    	}
    }
  /**
     * setting sheet initial values and header
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
	              var HeadTitle1="|Seq.|Name of Vessel|Code|TOV|TOI|Coverage|Insurer|Insurer|INS In|INS Out|PY|Deductible|Deductible|Deductible|Deductible|Updater|Updated|Built|Flag|Flag|Class|GRT|DWT|TOO|TOO In|TOO Out|Remark(s)";
	              var HeadTitle2="|Seq.|Name of Vessel|Code|TOV|TOI|Coverage|Insurer|Insurer|INS In|INS Out|PY|Cargo|Crew|DTH|Others|Updater|Updated|Built|Flag|Flag|Class|GRT|DWT|TOO|TOO In|TOO Out|Remark(s)";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              (headCount, 5, 0, true);
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_eng_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_vsl_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_cvrg_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_clm_pty_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_clm_pty_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_eff_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_exp_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_plcy_yr",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ddct_cgo_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ddct_crw_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ddct_dmg_hl_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ddct_otr_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_bld_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	                     {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_rgst_cnt_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cnt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_vsl_clss_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"grs_rgst_tong_wgt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dwt_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_vsl_oshp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_oshp_eff_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_oshp_exp_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:1,   SaveName:prefix+"insur_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	              SetEditable(0);
	              SetSheetHeight(400);
	              SetAutoRowHeight(0);//메모장을 이용해 줄바뀜이 되어 내용이 길어져도 Row의 높이가 늘어나지 않게 함.
              }
                break;
        }
    }
	// Handling Sheet's process
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH;
	        	var aryPrefix=new Array("sheet_");
	        	formObj.insur_tp_cd.value = formObj.combo_insur_tp_cd.value;
	        	formObj.insur_cvrg_cd.value = formObj.combo_insur_cvrg_cd.value;
	        	formObj.insur_vsl_tp_cd.value = formObj.combo_insur_vsl_tp_cd.value;
	        	formObj.insur_vsl_oshp_cd.value = formObj.combo_insur_vsl_oshp_cd.value;
	        	formObj.insur_period.value = formObj.combo_insur_period_text.value;
	        	var sXml=sheetObj.GetSearchData("CPS_CNI_0403GS.do" , FormQueryString(formObj) +"&" + ComGetPrefixParam(aryPrefix));
	   			sheetObj.LoadSearchData(sXml,{Sync:1} );
			break;
			case IBROWSEARCH: 
				if (Col == "ComCd") {//코드 조회
					CoCniGetCombo(formObj, sheetObj, "MULTI:MULTI:MULTI:MULTI:MULTI", "29:27:31:33:34",
					"insur_period:"+"insur_tp_cd:"+"insur_cvrg_cd:"+"insur_vsl_tp_cd:"+"insur_vsl_oshp_cd:", 
					"insur_periodText:"+"insur_tp_cdText:"+"insur_cvrg_cdText:"+"insur_vsl_tp_cdText:"+"insur_vsl_oshp_cdText:");
				}
			break;
        }
    }
    /**
     * Party popup에서 선택시 Party Name을 세팅한다.
     */
    function setMainCodeInquiry(partyVo) {
        switch(popupType) {
            case "pop_insur_clm_pty_nm":
				form.insur_clm_pty_no.value=partyVo.clm_pty_no;
				form.insur_clm_pty_nm.value=partyVo.clm_pty_abbr_nm;    
                break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if (!ComChkValid(formObj)) return false;
            if (sAction == IBSEARCH) {
            	var fromDt=ComReplaceStr(form.insur_eff_dt.value.trim(),"-","");
            	var toDt=ComReplaceStr(form.insur_exp_dt.value.trim(),"-","");
   				if (fromDt != "" && toDt != "" && fromDt > toDt) {
					ComAlertFocus(form.to_dt, ComGetMsg("CNI09058"));
					return;
   				}
			}
        }
        return true;
    }
	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
    function combo_insur_period_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_period.value=newIndex;
	}
	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_tp_cd.value=newIndex;
	}
	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_cvrg_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_cvrg_cd.value=newIndex;
	}

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_vsl_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_vsl_tp_cd.value=newIndex;
	}
	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_vsl_oshp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_vsl_oshp_cd.value=newIndex;
	}
    /**
     * IBSheet XML에서 XML 문자열을 파싱하여 그 안의 파라미터 항목 값을 리턴한다 <br>
     * @param {string} xmlStr    IBSheet를 통해 받아온 xml 문자열
     * @param {string} dataNode  파싱할 항목
     * @return {string} xmlValue
     **/
  	function GetXMLData(xmlStr, dataNode) {
  		var xmlData='';
        try {
            /* XML Parsing */
            var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.async="false";
            xmlDoc.loadXML(xmlStr);
			/* get message */
            xmlData=xmlDoc.documentElement.getElementsByTagName(dataNode).item(0).text
        } catch(err) {
            xmlData='';
        }
		return xmlData;
  	}
