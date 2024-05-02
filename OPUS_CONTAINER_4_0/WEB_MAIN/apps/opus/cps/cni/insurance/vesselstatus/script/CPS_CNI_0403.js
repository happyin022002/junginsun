/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CPS_CNI_0403.jsp
 *@FileTitle : Entry Status
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class CPS_CNI_0403 : CPS_CNI_0403 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
 
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
					//alert(srcName);
            switch(srcName) {
                case "btn_Retrieve":
	             	if(!CoCniInitConfirm(sheetObject1)) return;
	             	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break; 
                case "btn_New":
	             	if(!CoCniInitConfirm(sheetObject1)) return;
					ComResetAll();
					eval("combo_insur_period").SetSelectCode("INS_IN");
                    break; 
                case "btn_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break; 
               	case "btn_Print":
					if (sheetObject1.RowCount()<= 0 ) {
						ComShowCodeMessage("CNI00024");
						return;
					}
					var vParam="/rp ";
					var insurPeriod=formObject.insur_period.value;
					if (insurPeriod == "INS_IN") {
						vParam=vParam + "[ AND	A.INSUR_EFF_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					} else if (insurPeriod == "INSOUT") {
						vParam=vParam + "[ AND	A.INSUR_EXP_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					} else if (insurPeriod == "TOOIN") {
						vParam=vParam + "[ AND	A.VSL_OSHP_EFF_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					} else {
						vParam=vParam + "[ AND	A.VSL_OSHP_EXP_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					}
					vParam=vParam + "[" + eval("combo_insur_period").GetSelectText()+ "] ";
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
                case "btn_Row_Copy":
                	var index=sheetObjects[0].DataCopy();
                	/*
	          		if(sheetObject1.GetSelectRow()> 0) {
	          			var selRow=sheetObject1.GetSelectRow();
						var row=sheetObject1.DataInsert();
	                    sheetObject1.Copy2SheetCol(sheetObject1,"","",selRow,selRow,2);
                	}
                	*/
                    break; 
                case "btn_Row_Delete":
					if(ComCniCheckBoxCheckYn(sheetObject1, prefix+"DelChk")) { 
						ComRowHideDelete(sheetObject1, prefix+"DelChk"); 
					}
                    break;
				case "btn_DownExcel":
					var strColSkipList=prefix + "ibflag|" + prefix + "DelChk";
 					sheetObject1.Down2Excel({ HiddenColumn:0,TreeLevel:false});
                    break; 
				case "btn_LoadExcel":
	          		if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
 					sheetObject1.LoadExcel({ Mode:"HeaderMatch"});
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
        //권한
		setRollBtnCtlIns("btn_Save,btn_Row_Add,btn_Row_Insert,btn_Row_Copy,btn_Row_Delete,btn_LoadExcel");
		var sheetObj = sheetObjects[0];
    
    /**
     * Sheet의 Load가 끝났을때 발생되는 이벤트
     */
		initMiscCode(sheetObjects[0]);   
		//Sheet의 콤보는 text가 아니라 code가 보이도록 처리
    	sheetObj.SetColProperty(0, prefix+"insur_vsl_tp_cd", {ComboText:"|"+sheetObj.GetComboInfo(0, prefix+"insur_vsl_tp_cd", "Code"), ComboCode:"|"+sheetObj.GetComboInfo(0, prefix+"insur_vsl_tp_cd", "Code")} );
    	//yangjrm
    	//sheetObj.InitDataCombo(0, prefix+"insur_vsl_clss_nm", " |"+sheetObj.GetComboInfo(0,prefix+"insur_vsl_clss_nm", "Code"), " |"+sheetObj.GetComboInfo(0,prefix+"insur_vsl_clss_nm", "Code"));
    	sheetObj.SetColProperty(0, prefix+"insur_vsl_oshp_cd", {ComboText:"|"+sheetObj.GetComboInfo(0,prefix+"insur_vsl_oshp_cd", "Code"), ComboCode:"|"+sheetObj.GetComboInfo(0,prefix+"insur_vsl_oshp_cd", "Code")} );
    	sheetObj.SetColProperty(0, prefix+"insur_tp_cd", {ComboText:"|"+sheetObj.GetComboInfo(0,prefix+"insur_tp_cd", "Code"), ComboCode:"|"+sheetObj.GetComboInfo(0,prefix+"insur_tp_cd", "Code")} );
    	sheetObj.SetColProperty(0, prefix+"insur_cvrg_cd", {ComboText:"|"+sheetObj.GetComboInfo(0,prefix+"insur_cvrg_cd", "Code"), ComboCode:"|"+sheetObj.GetComboInfo(0,prefix+"insur_cvrg_cd", "Code")} );
		sheetObj.SetWaitImageVisible(1);
		
//		eval("combo_insur_period").SetSelectCode("INS_IN");
//		combo_insur_period.SetSelectCode("INS_IN");
    } 
	/**
	* 콤보 Miscellaneous 코드값 가져오기
    * @param {ibsheet} sheetObj    IBSheet Object
	*/
    function initMiscCode(sheetObj) {
		sheetObj.SetWaitImageVisible(0);
		// IBMultiComboinitializing
		for(var k=0; k< comboObjects.length; k++){
			initCombo(comboObjects[k]);
		}
		//MISCELLANEOUS 코드 정보를 가져온다
		doActionIBSheet(sheetObj,document.form,IBROWSEARCH, "ComCd");
// 		eval("combo_insur_period").DeleteItem("");
//		eval("combo_insur_period").SetSelectCode("INS_IN");
//		eval("combo_insur_period").SetColWidth(0, "70");
//		eval("combo_insur_period").SetColWidth(1, "200");
//		combo_insur_period.DeleteItem("");
		combo_insur_period.SetSelectCode("INS_IN");
		combo_insur_period.SetColWidth(0, "70");
		combo_insur_period.SetColWidth(1, "200");
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
//        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 				//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
//    	axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'  , form);
//        axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
//        axon_event.addListener  ('keypress', 'obj_keypress' , form);							//- form 전체 컨트롤 중 keypress 이벤트 발생시
        axon_event.addListener  ('change'  , 'party_change', 'insur_clm_pty_nm');				//- Party name 삭제시 party no 삭제
        
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
//        ComChkObjValid(ComGetEvent());
    }
    /**
     * only numbers
     **/
    function obj_keypress(){
    	switch(ComGetEvent("name")){
	        case "vsl_cd":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "insur_clm_pty_nm":
	        	if (event.keyCode > 0) event.returnValue=false;;
	            break;
			default:
		        //only numbers
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
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
                with (sheetObj) {
		           // setting height
	            	
	            	var HeadTitle1="|Sel.|Seq.|Name of Vessel|Code|TOV|TOI|Coverage|Insurer|Insurer|INS In|INS Out|PY|Deductible|Deductible|Deductible|Deductible|Updater|Updated|Built|Flag|Flag|Class|GRT|DWT|TOO|TOO In|TOO Out|Remark(s)";
	            	var HeadTitle2="|Sel.|Seq.|Name of Vessel|Code|TOV|TOI|Coverage|Insurer|Insurer|INS In|INS Out|PY|Cargo|Crew|DTH|Others|Updater|Updated|Built|Flag|Flag|Class|GRT|DWT|TOO|TOO In|TOO Out|Remark(s)";
	            	var headCount=ComCountHeadTitle(HeadTitle1);
	            	(headCount, 5, 0, true);
	
	            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"},
	            	                { Text:HeadTitle2, Align:"Center"} ];
	            	InitHeaders(headers, info);
	
	            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	            	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"DelChk" },
	            	             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	            	             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_eng_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	            	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_vsl_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_cvrg_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_clm_pty_no",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Popup",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_clm_pty_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_eff_dt",      KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_exp_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_plcy_yr",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	            	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ddct_cgo_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	            	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ddct_crw_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	            	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ddct_dmg_hl_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	            	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ddct_otr_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_bld_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	            	             {Type:"PopupEdit", Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_rgst_cnt_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cnt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_vsl_clss_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
	            	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"grs_rgst_tong_wgt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	            	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dwt_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"insur_vsl_oshp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_oshp_eff_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_oshp_exp_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:1,   SaveName:prefix+"insur_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            	 
	            	InitColumns(cols);
	            	SetSheetHeight(380);
	            	SetEditable(1);
	            	SetImageList(0,"img/btns_note.gif");
	            	SetDataLinkMouse(prefix + "vsl_cd",1);
	            	SetDataLinkMouse(prefix + "vsl_rgst_cnt_cd",1);
	            	SetDataLinkMouse(prefix + "insur_clm_pty_nm",1);
	            	SetDataLinkMouse(prefix + "insur_rmk",1);
	            	
	            	SetColProperty(0, prefix +"vsl_cd" , {AcceptKeys:"E|N", InputCaseSensitive:1});
	            	
//	            	SetColProperty(prefix + "insur_vsl_tp_cd", {ComboText:comboText, ComboCode:comboCode} );
	            	SetShowButtonImage(2);
	            	SetAutoRowHeight(0);//메모장을 이용해 줄바뀜이 되어 내용이 길어져도 Row의 높이가 늘어나지 않게 함.
	            	SetMergeCell(0, 20, 2, 2);
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
	        	formObj.combo_insur_period_text.value;
	        	formObj.insur_tp_cd.value = formObj.combo_insur_tp_cd.value;
	        	formObj.insur_cvrg_cd.value = formObj.combo_insur_cvrg_cd.value;
	        	formObj.insur_vsl_tp_cd.value = formObj.combo_insur_vsl_tp_cd.value;
	        	formObj.insur_vsl_oshp_cd.value = formObj.combo_insur_vsl_oshp_cd.value;
	        	formObj.insur_period.value = formObj.combo_insur_period_text.value;

 	   			var sXml=sheetObj.GetSearchData("CPS_CNI_0403GS.do" , FormQueryString(formObj) +"&" + ComGetPrefixParam(aryPrefix));
	   			sheetObj.LoadSearchData(sXml,{Sync:1} );
			break;
           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			formObj.f_cmd.value=MULTI;
	        	var aryPrefix=new Array("sheet_");
				var arrSheets=new Array(sheetObj);
				var sParam=ComGetSaveString(arrSheets, true);
				//필수 입력과 같은 확인이 이루어짐
				if (!sheetObj.IsDataModified()|| sParam == "") return;
 	 			var sXml=sheetObj.GetSaveData("CPS_CNI_0403GS.do", FormQueryString(formObj) +"&" + sParam +"&" + ComGetPrefixParam(aryPrefix), true);
	   			var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
 	   			sheetObj.LoadSaveData(sXml);
                break;
			case IBROWSEARCH: 
				if (Col == "ComCd") {//코드 조회
					CoCniGetCombo(formObj, sheetObjects[0], "GRID:MULTI:MULTI:MULTI:MULTI:MULTI:GRID:GRID:GRID:GRID", "27:27:29:31:33:34:35:31:33:34",
					prefix + "insur_tp_cd:"+"insur_tp_cd:"+"insur_period:"+"insur_cvrg_cd:"+"insur_vsl_tp_cd:"+"insur_vsl_oshp_cd:"+
					prefix + "insur_vsl_clss_nm:"+prefix + "insur_cvrg_cd:"+prefix + "insur_vsl_tp_cd:"+prefix + "insur_vsl_oshp_cd", 
					prefix + "insur_tp_cdText:"+"insur_tp_cdText:"+"insur_periodText:"+"insur_cvrg_cdText:"+"insur_vsl_tp_cdText:"+"insur_vsl_oshp_cdText:"+
					prefix + "insur_vsl_clss_nmText:"+prefix + "insur_cvrg_cdText:"+prefix + "insur_vsl_tp_cdText:"+
					prefix + "insur_vsl_oshp_cdText");
				} else if (Col == prefix + "vsl_cd") {//Vessel Code
 		   			var sXml=sheetObj.GetSearchData("CPS_CNI_0403GS.do" , "&f_cmd="+SEARCH01+"&vsl_cd="+sheetObj.GetCellValue(Row,Col));
		   			var result=ComGetEtcData(sXml, "vsl_eng_nm");
		   			if (typeof result == "undefined" || result == "" ) {
						ComShowMessage(ComGetEtcData(sXml, "errMsg"));
		    			sheetObj.SetCellValue(Row, prefix + "vsl_eng_nm","",0);
						sheetObj.SetCellValue(Row,Col,"",0);
		 				sheetObj.SelectCell(Row, Col);
						return;
					} else {
						sheetObj.SetCellValue(Row,prefix + "vsl_eng_nm",result,0);
						//Vessel 정보 조회하기
						doActionIBSheet(sheetObj, document.form, IBROWSEARCH, prefix+"vsl_data", Row);
					} 
				} else if (Col == prefix + "vsl_data") {//Vessel 정보 조회하기
 		   			var sXml=sheetObj.GetSearchData("CPS_CNI_0403GS.do" , "&f_cmd="+SEARCH03+"&vsl_cd="+sheetObj.GetCellValue(Row,prefix + "vsl_cd"));
		   			if (ComGetEtcData(sXml, "Retrieve") == "Y") {
						sheetObj.SetCellValue(Row,prefix + "vsl_bld_yr",ComGetEtcData(sXml, "vsl_lnch_dt"),0);
						sheetObj.SetCellValue(Row,prefix + "vsl_rgst_cnt_cd",ComGetEtcData(sXml, "cnt_cd"),0);
						sheetObj.SetCellValue(Row,prefix + "cnt_nm",ComGetEtcData(sXml, "cnt_nm"),0);
						sheetObj.SetCellValue(Row,prefix + "grs_rgst_tong_wgt",ComGetEtcData(sXml, "grs_rgst_tong_wgt"),0);
						sheetObj.SetCellValue(Row,prefix + "dwt_wgt",ComGetEtcData(sXml, "dwt_wgt"),0);
						sheetObj.SetCellValue(Row,prefix + "insur_vsl_clss_nm",ComGetEtcData(sXml, "clss_no_rgst_area_nm"),0);
						sheetObj.SetCellValue(Row,prefix + "vsl_oshp_eff_dt",ComGetEtcData(sXml, "vsl_de_dt"),0);
					} else {
						ComShowMessage(ComGetEtcData(sXml, "errMsg"));
						return;
					} 
				} else if (Col == prefix + "vsl_rgst_cnt_cd") {//Country Code
 		   			var sXml=sheetObj.GetSearchData("CPS_CNI_0403GS.do" , "&f_cmd="+SEARCH02+"&flag="+sheetObj.GetCellValue(Row,Col));
		   			var result=ComGetEtcData(sXml, "cnt_nm");
		   			if (typeof result == "undefined" || result == "" ) {
						ComShowMessage(ComGetEtcData(sXml, "errMsg"));
		    			sheetObj.SetCellValue(Row, prefix + "cnt_nm","",0);
						sheetObj.SetCellValue(Row,Col,"",0);
		 				sheetObj.SelectCell(Row, Col);
						return;
					} else {
						sheetObj.SetCellValue(Row,prefix + "cnt_nm",result,0);
					}
				}
			break;
        }
    }
     /**
      * IBSheet Object에서 팝업을 클릭시
      */
 	var popupRow=0;
 	function sheet1_OnPopupClick(sheetObj, Row,Col) {
		if (sheetObj.ColSaveName(Col) == prefix + "vsl_cd") {
			popupRow=Row;
			var url="CPS_CNI_0308.do";
			var winName="CPS_CNI_0308";
			var reqWin=openWinCenter(url,winName,800,400);	
		} else if (sheetObj.ColSaveName(Col) == prefix + "vsl_rgst_cnt_cd") {
			ComOpenPopup("COM_ENS_0M1.do", 565, 440, "setCntCd", "1,0,1,1,1,1", true, false, Row, Col, 0, "COM_ENS_0M1");
		} else if (sheetObj.ColSaveName(Col) == prefix + "insur_clm_pty_nm") {
			popupType="sheet_insur_clm_pty_nm";
			popupRow=Row;
			popupMainCodeInquiry();
		}
	}
	/**
	* Vessel Code/Name 입력부분.<br>
	* @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	*/
	function setVslCd(vslVo){
		sheetObjects[0].SetCellValue(popupRow, prefix+"vsl_cd",vslVo.vsl_cd,0);
		sheetObjects[0].SetCellValue(popupRow, prefix+"vsl_eng_nm",vslVo.vsl_eng_nm,0);
		sheetObjects[0].SelectCell(popupRow, prefix+"insur_vsl_tp_cd");
		//Vessel 정보 조회하기
		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, prefix+"vsl_data", popupRow);
	}
	/**
	* Country Code/Name 입력부분.<br>
	* @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	*/
	function setCntCd(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[0].SetCellValue(Row, Col,aryPopupData[0][3],0);
		sheetObjects[0].SetCellValue(Row, prefix+"cnt_nm",aryPopupData[0][4],0);
		sheetObjects[0].SelectCell(Row, prefix+"insur_vsl_clss_nm");
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
            case "sheet_insur_clm_pty_nm":
				sheetObjects[0].SetCellValue(popupRow, prefix + "insur_clm_pty_no",partyVo.clm_pty_no,0);
				sheetObjects[0].SetCellValue(popupRow, prefix + "insur_clm_pty_nm",partyVo.clm_pty_abbr_nm,0);
                break;
        }
    }
     /**
      * IBSheet Object에서 Cell을 클릭시
      */         
    function sheet1_OnClick(sheetObj, Row, Col, value) {
 		if (sheetObj.ColSaveName(Col) == prefix + "insur_rmk") {
			ComShowMemoPad(sheetObj, Row, Col, false, 400, 400, 4000);
		}
 	} 
     /**
      * Remark Image Setting
      */         
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
 			for (var i=1 ; i <= sheetObj.LastRow(); i ++)
 	 		{ 
//conversion of function[check again]CLT  				SetCellImage(i, prefix + "insur_rmk",0);
 	 		}
 		}
 	} 
     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) == prefix + "vsl_cd") {
    		if (Value == '') {
    			sheetObj.SetCellValue(Row, prefix + "vsl_eng_nm","",0);
    		} else {
    			doActionIBSheet(sheetObj, document.form, IBROWSEARCH, sheetObj.ColSaveName(Col), Row);
    		}	
		} else if (sheetObj.ColSaveName(Col) == prefix + "vsl_rgst_cnt_cd") {
    		if (Value == '') {
    			sheetObj.SetCellValue(Row, prefix + "cnt_nm","",0);
    		} else {
    			doActionIBSheet(sheetObj, document.form, IBROWSEARCH, sheetObj.ColSaveName(Col), Row);
    		}	
    	} else if (sheetObj.ColSaveName(Col) == prefix + "insur_eff_dt" || sheetObj.ColSaveName(Col) == prefix + "insur_exp_dt") {
    		var fromDt=sheetObj.GetCellValue(Row, prefix + "insur_eff_dt");
    		var toDt=sheetObj.GetCellValue(Row, prefix + "insur_exp_dt");
			if (fromDt != "" && toDt != "" && fromDt > toDt) {
				ComShowCodeMessage("CNI09058");
				sheetObj.SetCellValue(Row, Col,"",0);
				sheetObj.SelectCell(Row, Col);
				return;
			}
			//TOI가 P&I인 경우에 INS In의 년도를 PY에 자동 세팅
			if (sheetObj.ColSaveName(Col) == prefix + "insur_eff_dt" && sheetObj.GetCellValue(Row, prefix + "insur_tp_cd") == "P&I") {
				if (Value.length > 4) {
					sheetObj.SetCellValue(Row, prefix + "insur_plcy_yr",Value.substring(0,4));
				}
			}
    	} else if (sheetObj.ColSaveName(Col) == prefix + "vsl_oshp_eff_dt" || sheetObj.ColSaveName(Col) == prefix + "vsl_oshp_exp_dt") {
    		var fromDt=sheetObj.GetCellValue(Row, prefix + "vsl_oshp_eff_dt");
    		var toDt=sheetObj.GetCellValue(Row, prefix + "vsl_oshp_exp_dt");
			if (fromDt != "" && toDt != "" && fromDt > toDt) {
				ComShowCodeMessage("CNI09058");
				sheetObj.SetCellValue(Row, Col,"",0);
				sheetObj.SelectCell(Row, Col);
				return;
			}
		//TOI가 P&I인 경우에 INS In의 년도를 PY에 자동 세팅
    	} else if (sheetObj.ColSaveName(Col) == prefix + "insur_tp_cd") {
    		if (Value == "P&I" && sheetObj.GetCellValue(Row, prefix + "insur_eff_dt").length > 4) {
    			sheetObj.SetCellValue(Row, prefix + "insur_plcy_yr",sheetObj.GetCellValue(Row, prefix + "insur_eff_dt").substring(0,4),0);
    		}
    	}
 	}		
     /**
      * IBSheet Object에서 셀에 포커스가 있는 상태에서 키보드를 누르거나, Edit 상태에서 키보드를 누른 경우 Event가 발생한다
      */
 	function sheet1_OnKeyDown(sheetObj,Row, Col, KeyCode,Shift) {
		if (KeyCode ==13 && sheetObj.ColSaveName(Col) == prefix + "insur_rmk") {
			//ComShowMemoPad(sheetObj, Row, Col, false, 400, 400, 4000);
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
	function combo_insur_period_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_period.value=index_cd;
	}
	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_tp_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_tp_cd.value=index_cd;
	}
	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_cvrg_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_cvrg_cd.value=index_cd;
	}
	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_vsl_tp_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_vsl_tp_cd.value=index_cd;
	}
	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_vsl_oshp_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_vsl_oshp_cd.value=index_cd;
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
            var xmlDoc=new ComGetXmlDoc(xmlStr);
//            xmlDoc.async="false";
//            xmlDoc.loadXML(xmlStr);
			/* get message */
            xmlData=xmlDoc.documentElement.getElementsByTagName(dataNode).item(0).text;
        } catch(err) {
            xmlData='';
        }
		return xmlData;
  	}
  	
  	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
        if(isExceedMaxRow(msg))return;
    }
