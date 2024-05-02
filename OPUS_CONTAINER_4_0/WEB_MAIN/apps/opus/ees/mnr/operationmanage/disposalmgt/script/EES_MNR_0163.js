/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0163.js
*@FileTitle  :  Disposal Invoice Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0163 : EES_MNR_0163 - Defining a script used by screen
     */
/* Developer's task	*/
// Common global variable
//Sheet
var sheetObjects=new Array();
var sheetCnt=0;
//Combo object
var comboObjects=new Array();
var comboCnt=0;
var selCheck=false;
//Default value of combo
var eqKnddefCode="";
var actionType="";
var initLoader=0;
// Defining event handler of button click */
document.onclick=processButtonClick;
// Event handler to diverge process by button name */
    function processButtonClick(){
         /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					case "btn_New":
						doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
					break;
					case "btn_Print":
						var rdParam='/rv inv_no[' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"inv_no") + '] user_nm[' + self_usr_nm + ']';
						formObject.com_mrdBodyTitle.value="Disposal Invoice";
						formObject.com_mrdPath.value="apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0185.mrd";
						formObject.com_mrdArguments.value=rdParam;
						var sFeatures="resizable=yes,width=800,height=600"
						ComOpenRDPopup(sFeatures);
						break;
					break;
					case "btn_Detail":
						doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC01);
					break;
					case "btn_Collection":
						doActionIBSheet(sheetObjects[2],formObject,IBSEARCH_ASYNC02);
					break;
					case "btn_DownExcel":
						if(sheetObjects[0].RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
							}
						//sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
					break;
					case "btn_DownExcelDtl":
						if(sheetObjects[1].GetVisible()==true){
							if(sheetObjects[1].RowCount() < 1){//no data
								ComShowCodeMessage("COM132501");
								}else{
									sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
								}
						}else{
							if(sheetObjects[2].RowCount() < 1){//no data
								ComShowCodeMessage("COM132501");
								}else{
									sheetObjects[2].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign:1,Merge:1 });
								}
						}
					break;
					case "btn_period":
						var cal=new ComCalendarFromTo();
						cal.select(formObject.from_dt,  formObject.to_dt,  'yyyy-MM-dd');
					break;
			        case "btn_t1_req_multy":
	                    rep_Multiful_inquiry("inv_no");
					break;
			        case "btn_t2_req_multy":
	                    rep_Multiful_inquiry("eq_no_list");
						break;
					case "btn_provider_popup":
				    	ComOpenPopup('/opuscntr/COM_ENS_041.do', 780, 520, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
		initControl();
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		for(k=0;k < comboObjects.length;k++){
            initCombo(comboObjects[k],k + 1);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
    function initCombo(comboObj, comboNo) {
    	switch(comboObj.options.id) {
            case "mnr_inv_sts_cd":
                with(comboObj) {
                    SetDropHeight(85);
                }
                break;
        }
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
	              var HeadTitle1="|Seq.|Invoice No.|Status|Settle|Buyer|Currency|Amount|Invoice Date|Remark(s)";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              (headCount + 1, 0, 0, true);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inv_stl_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"ttl_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"dp_prcs_knt",          KeyField:0,   CalcLogic:"",   Format:"",             PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	               
	              InitColumns(cols);
	              SetSheetHeight(122);
            }
			break;
            case "sheet2":
                with(sheetObj){
            		var HeadTitle1="|Seq.|Disposal No.|EQ No.|TP/SZ|Release No|Currency|Amount|Due Date|Request Date|Sold Date|Charge Code|Remark(S)";
            		var headCount=ComCountHeadTitle(HeadTitle1);
            		(headCount, 0, 0, true);
	
            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);
	
            		var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"disp_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"disp_rlse_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_due_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rqst_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"disp_sold_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"mnr_disp_dtl_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
            		InitColumns(cols);
//            		SetSheetHeight(222);
            		resizeSheet( sheetObj );
            }
			break;
           case "sheet3":
        	    with(sheetObj){
        	   		var HeadTitle1="|Seq.|Office|Currency|Invoice Amount|Invoice Tax Amount|Collection Amount|Collection Tax Amount|Balance Amount|Balance Tax Amount|Update Date";
        	   		var headCount=ComCountHeadTitle(HeadTitle1);
        	   		(headCount, 0, 0, true);

        	   		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

        	   		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	   		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        	   		InitHeaders(headers, info);

        	   		var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
                    {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_frt_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"inv_tax_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"clt_frt_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:140,  Align:"Right",   ColMerge:1,   SaveName:"clt_tax_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"bal_frt_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"bal_tax_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clt_lst_upd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
              
    	   		InitColumns(cols);
    	   		resizeSheet( sheetObj );
    	   		SetVisible(false);
           }
			break;
        }
    }
	function initControl() {
	    //Axon event handling 1. Catching event
		var formObject=document.form;
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);
	 //   axon_event.addListenerFormat('focus',    'obj_activate',    formObject);
		axon_event.addListenerFormat('change',	 'obj_change',		formObject);
	}
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
	 * Assigning array of IBCombo object
	 * @param	{IBMultiCombo}	combo_obj
	 * Array defined at the top of the source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
	//Axon event handling 2. Event handling function
	function obj_deactivate(){
	    ComChkObjValid(ComGetEvent());
	}
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if (ComTrim(obj.value) != "") {
			switch(ComGetEvent("name")) {
	    		case "disp_eml_flg_temp":
				   	break;
	    		case "cust_cd":
	    			MnrWaitControl(true);
	    			var CustCd=formObj.cust_cd.value.substring(0, 2);
	    			var CustSeq=formObj.cust_cd.value.substring(2);
	    			if(CustCd =="" || CustSeq =="" )
	    			{
	    				ComShowCodeMessage("MNR00005", formObj.cust_cd.value);
	    				formObj.cust_cd.value = "";
	    				formObj.vndr_lgl_eng_nm.value = "";
	    				MnrWaitControl(false);
	    				return;
	    			}
	    			var	sXml=MnrComCustomerInfoSearch(sheetObjects[0],CustCd,CustSeq);
	    			var arrResult=MnrXmlToArray(sXml);
	    			if(arrResult != null){
	    				for(var i=0; i < arrResult.length;i ++){
	    					formObj.vndr_lgl_eng_nm.value=arrResult[i][10];
	    					break;
	    				}
	    			}else{
	    				ComShowCodeMessage("MNR00005", formObj.cust_cd.value);
	    				formObj.cust_cd.value = "";
	    				formObj.vndr_lgl_eng_nm.value = "";
	    				ComSetFocus(formObj.cust_cd);
	    			}
	    			MnrWaitControl(false);
				   	break;
			}
	    }
	}
 //Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //Retrieving
				if(validateForm(sheetObj,formObj,sAction)){
					//Retrieving
					formObj.f_cmd.value=SEARCH;
				    sParam=FormQueryString(formObj);
				    var sXml=sheetObj.GetSaveData("EES_MNR_0163GS.do", sParam);
				    ComOpenWait(true);
				    sheetObjects[0].LoadSearchData(sXml,{Sync:0} );
				}
				break;
 			case IBSEARCH_ASYNC01:      //Invoice Detail
				if(validateForm(sheetObj,formObj,sAction)){
//					sheetObjects[1].SetSheetHeight(220);
//					sheetObjects[2].SetSheetHeight(90);
					sheetObjects[1].SetVisible(true);
					sheetObjects[2].SetVisible(false);
					var currPrcsKnt=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"dp_prcs_knt");
					if(currPrcsKnt=="0"){
						sheetObjects[1].InitCellProperty(0, 8 , dtData, 100, daRight, true, "inv_amt", false, "", dfInteger, 0, true, true);
					}else{
						sheetObjects[1].InitCellProperty(0, 8 , dtData, 100, daRight, true, "inv_amt", false, "", dfFloat, 2, true, true);
					}
					sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"ibflag","U");
					formObj.f_cmd.value=SEARCH01;
					var sParam=ComGetSaveString(sheetObjects[0]);
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
				    var sXml=sheetObj.GetSaveData("EES_MNR_0163GS.do", sParam);
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"ibflag","");
				}
				break;
			case IBSEARCH_ASYNC02:      //Collection Info
				if(validateForm(sheetObj,formObj,sAction)){
//					sheetObjects[1].SetSheetHeight(0);
					sheetObjects[2].SetSheetHeight(sheetObjects[1].GetSheetHeight());
					sheetObjects[1].SetVisible(false);
					sheetObjects[2].SetVisible(true);
					var currPrcsKnt=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"dp_prcs_knt");
					if(currPrcsKnt=="0"){
						sheetObjects[2].InitCellProperty(0, 4 , dtData,			100,	daRight,	true,		"inv_frt_amt",		false,	"",		dfInteger,			0,			true,		true);
						sheetObjects[2].InitCellProperty(0, 5 , dtData,			120,	daRight,	true,		"inv_tax_amt",		false,	"",		dfInteger,			0,			true,		true);
						sheetObjects[2].InitCellProperty(0, 6 , dtData,			120,	daRight,	true,		"clt_frt_amt",	    false,	"",		dfInteger,			0,			true,		true);
						sheetObjects[2].InitCellProperty(0, 7 , dtData,			140, 	daRight,	true,		"clt_tax_amt",	    false,	"",		dfInteger,			0,			true,		true);
						sheetObjects[2].InitCellProperty(0, 8 , dtData,			120,	daRight,	true,		"bal_frt_amt",		false,	"",		dfInteger,			0,			true,		true);
						sheetObjects[2].InitCellProperty(0, 9 , dtData,			130,	daRight,	true,		"bal_tax_amt",		false,	"",		dfInteger,			0,			true,		true);
					}else{
						sheetObjects[2].InitCellProperty(0, 4 , dtData,			100,	daRight,	true,		"inv_frt_amt",		false,	"",		dfFloat,			2,			true,		true);
						sheetObjects[2].InitCellProperty(0, 5 , dtData,			120,	daRight,	true,		"inv_tax_amt",		false,	"",		dfFloat,			2,			true,		true);
						sheetObjects[2].InitCellProperty(0, 6 , dtData,			120,	daRight,	true,		"clt_frt_amt",	    false,	"",		dfFloat,			2,			true,		true);
						sheetObjects[2].InitCellProperty(0, 7 , dtData,			140, 	daRight,	true,		"clt_tax_amt",	    false,	"",		dfFloat,			2,			true,		true);
						sheetObjects[2].InitCellProperty(0, 8 , dtData,			120,	daRight,	true,		"bal_frt_amt",		false,	"",		dfFloat,			2,			true,		true);
						sheetObjects[2].InitCellProperty(0, 9 , dtData,			130,	daRight,	true,		"bal_tax_amt",		false,	"",		dfFloat,			2,			true,		true);
					}
					sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"ibflag","U");
					formObj.f_cmd.value=SEARCH02;
					var sParam=ComGetSaveString(sheetObjects[0]);
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
				    var sXml=sheetObj.GetSaveData("EES_MNR_0163GS.do", sParam);
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"ibflag","");
				}
				break;
			case IBCLEAR:      // Initializing
				MnrWaitControl(true);
				sheetObj.WaitImageVisible = false;
				selCheck=false;
				actionType="";
				//Initializing sheet
				for(var i=0; i < sheetObjects.length;i++){
					sheetObjects[i].RemoveAll();
				}
				if(initLoader == 0){
					var sCondition=new Array (
						new Array("MnrGenCd","CD00081", "COMMON")	//Disposal Invoice Inquiry Status Code
					);
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					//Setting combo
					for(var i=0; i < comboList.length;i++){
						if(comboList[i] != null){
							//Initializing each combo of sheets
							sheetComboText="";
							sheetComboCode="";
							for(var j=0; j < comboList[i].length;j++){
								var tempText=comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								//Repair Invoice Search Type
								if(i==0) {
									comboObjects[0].InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){
										comboObjects[0].InsertItem(0, "ALL" ,"ALL");
										comboObjects[0].SetSelectCode("ALL");
									}
								}
							}
						}
					}
				}
				initLoader=1;
				comboObjects[0].SetSelectCode("ALL");
				formObj.from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -7);;
				formObj.to_dt.value=ComGetNowInfo("ymd");
				formObj.inv_no.value="";
				formObj.cust_cd.value="";
				formObj.vndr_lgl_eng_nm.value="";
				formObj.eq_no_list.value="";
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
				break;
        }
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(sAction==IBSEARCH_ASYNC02) { //Collection Info
				var stsVal=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"mnr_inv_sts_cd");
				if(stsVal!="SAR Interfaced"){
					ComShowCodeMessage("MNR00319");
					return false;
				}
			}
		}
        return true;
    }
	/**
	 * Getting rep_Multiful_inquiry
	 */
	function getMnr_Multi(rowArray,ret_val) {
		var formObj=document.form;
		var tempText="";
		//Initializing
		eval("document.form." + ret_val + ".value='';");
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//Removing last comma
		if (tempText != "")
	        tempText=tempText.substr(0, tempText.length - 1);
		tempText=tempText.toUpperCase();
		eval("document.form." + ret_val + ".value='" + tempText + "';");
	}
	/**
	 * (Service Provider) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param The object is sheet index in case of IBSheet
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.cust_cd.value=aryPopupData[0][3];
			formObj.vndr_lgl_eng_nm.value=aryPopupData[0][4];
		}
	}
	
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }
/* End of developer's task */
