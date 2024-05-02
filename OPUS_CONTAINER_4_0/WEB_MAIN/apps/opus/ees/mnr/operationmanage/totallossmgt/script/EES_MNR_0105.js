/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0105.js
*@FileTitle  : Total Loss Payment to Lessor Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0105 : EES_MNR_0105 - Defining a script used by screen
     */
  
   	/* Developer's task	*/
    // Common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
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
					case "btn_retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;
					case "btn_new":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						break;
					case "btn_downexcel":
						if(sheetObject1.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
						}
						
						break;
   					case "btn_calendar":
   						var cal=new ComCalendarFromTo();
   						cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
   						break;
   						//Multi inserting
   					case "eq_no_multi":
   					    rep_Multiful_inquiry("eq_no");
   						break;
   					case "tln_multi":
   					    rep_Multiful_inquiry("total_loss_no");
   						break;
   					case "btn_provider_popup":
   					    ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
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
		//Initializing IBMultiCombo
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k + 1);
	    }
   		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
    /**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboNo) {
	        case 1:
	           	with (comboObj) {
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "80");
					SetColWidth(1, "100");
				   	SetDropHeight(160);
					SetUseAutoComplete(1);
		    	}
	        	break;
	        case 2:
	           	with (comboObj) {
	        		SetColAlign(0, "left");
	        		SetColWidth(0, "130");
	        		SetDropHeight(160);
	        		SetUseAutoComplete(1);
		    	}
	        	break;
	     }
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
		           var HeadTitle1="|Seq.|Lessor Code|Lessor Name|EQ Type|EQ No.|TLL DT|Currency|D.V Value|Paid Amount|Paid Date|Status|CSR No|Status Date";
		           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		           var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		           var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		           InitHeaders(headers, info);
		           var cols = [  {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"iflag" },
						         {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
						         {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"lessor_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",    ColMerge:1,   SaveName:"lessor_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Combo",     Hidden:0, Width:75,   Align:"Left",    ColMerge:1,   SaveName:"eq_type",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tll_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//						         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"conv_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"dv_value",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pay_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"pay_sts",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"cr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		           InitColumns(cols);
		           SetEditable(0);
//		           SetSheetHeight(382);
		           resizeSheet( sheetObj );
                }
                break;
        }
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
    //Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //Retrieving
				if(validateForm(sheetObj,formObj,sAction))
					if (sheetObj.id == "sheet1"){
						formObj.f_cmd.value=SEARCH;
						sheetObj.DoSearch("EES_MNR_0105GS.do",FormQueryString(formObj) );
					}
				break;
			case IBCLEAR:        //Initializing
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
				if(initLoader == 0){
					//Initializing combo
					for(var i=0; i < comboObjects.length;i++){
						comboObjects[i].RemoveAll();
					}
					//Initializing
					combo_ttl_lss_sts_cd.SetSelectCode(-1,false);
					var sCondition=new Array (
							new Array("MnrGenCd",formObj.self_ofc_cd.value,"CUSTOM9")	//EQ Type
						   ,new Array("MnrGenCd","CD00039", "COMMON") 	//Status
					);
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					var sheetComboText="";
					var sheetComboCode="";
					var sheetComboCodeText="";
					var sheetComboDefault="";
					for(var i=0; i<comboList.length; i++)
					{
						sheetComboText="";
						sheetComboCode="";
						sheetComboCodeText="";
						sheetComboDefault="";
						if(comboList[i] != null)
						{
							for(var j=0; j < comboList[i].length;j++)
							{
								var xmlVal=comboList[i][j].split("|");
								if(i==0){
									combo_eq_type.InsertItem(j, xmlVal[1] ,xmlVal[0]);
									sheetComboText +=  xmlVal[1] + "|";
									sheetComboCode +=  xmlVal[0] + "|";
									sheetComboCodeText +=  xmlVal[0] + "\t" + xmlVal[1] + "|";
									if(j ==0){
										sheetComboDefault=xmlVal[0];
									}
								}else if(i==1){
									combo_ttl_lss_sts_cd.InsertItem(j, xmlVal[1] , xmlVal[0]);
								}
							}
							if(i==0){
								combo_eq_type.InsertItem(0, "ALL" ,"A" );
								combo_eq_type.SetSelectCode("A");
								formObj.eq_type.value=combo_eq_type.GetSelectCode();
								sheetObjects[0].InitDataCombo (0, "eq_type", sheetComboText, sheetComboCode ,sheetComboDefault);
							}else if(i==1){
						 		combo_ttl_lss_sts_cd.InsertItem(0, "ALL" ," " );
						 		combo_ttl_lss_sts_cd.SetSelectCode(" ");
						 		formObj.ttl_lss_sts_cd.value=combo_ttl_lss_sts_cd.GetSelectCode();
							}
						}
						else
						{
							if(i==0){
								ComShowCodeMessage("MNR00005", "EQ Type   ");
							}else if(i==1){
								ComShowCodeMessage("MNR00005", "Status    ");
							}
						}
					}
					initLoader=1;
				}
				//Initializing sheet
				for(i=0;i<sheetObjects.length;i++){
					sheetObjects[i].RemoveAll();
		        }
		 		combo_eq_type.SetSelectCode("A");
		 		combo_ttl_lss_sts_cd.SetSelectCode(" ");
		 		formObj.eq_no.value="";
		 		formObj.total_loss_no.value="";
		 		formObj.lessor.value="";
		 		formObj.vndr_lgl_eng_nm.value="";
				formObj.from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
				formObj.to_dt.value=ComGetNowInfo();
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
				break;
			case IBDOWNEXCEL:
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				break;
			case IBSEARCH_ASYNC01:	//Retrieving(sevice provider No. at inserting)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					//Retrieving service provider
					var sCondition=new Array (
						new Array("MdmVendor",formObj.lessor.value,"COMMON")
					)
					//Setting when returned data exist
					var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
					if(comboList[0] != null){
						var tempText=comboList[0][0].split("|");
						formObj.vndr_lgl_eng_nm.value=tempText[1];
					} else {
						ComShowCodeMessage("MNR00005", "Lessor");
						ComSetObjValue(formObj.vndr_lgl_eng_nm, "");
						ComSetObjValue(formObj.lessor, "");
						ComSetFocus(formObj.lessor);
					}
				}
				break;
        }
    }
	/**
	 * combo_eq_type : OnChange event
	 * @param {IBMultiCombo}  comboObj
	 * @param  {String}    Index_Code
	 * @param  {String}    Text
	 */
	function combo_eq_type_OnChange(comboObj,code ,oldindex, oldtext, oldcode , newindex, newtext , newcode)
	{
		var formObj=document.form;
		formObj.eq_type.value=comboObj.GetSelectCode();
	}
	/**
	 * combo_ttl_lss_sts_cd : OnChange event
	 * @param {IBMultiCombo}  comboObj
	 * @param  {String}    Index_Code
	 * @param  {String}    Text
	 */
	function combo_ttl_lss_sts_cd_OnChange(comboObj,code ,oldindex, oldtext, oldcode , newindex, newtext , newcode)
	{
		var formObj=document.form;
		formObj.ttl_lss_sts_cd.value=comboObj.GetSelectCode();
	}
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
				case IBSEARCH:
					if (!ComChkValid(formObj)) return false;
				 	break;
			}
		}
        return true;
    }
 	/**
 	 * Getting rep_Multiful_inquiry
 	 */
 	function getMnr_Multi(rowArray,return_val) {
 		var formObj=document.form;
 		var tempText="";
 		//Initializing
 		if(return_val == "eq_no"){
 			formObj.eq_no.value='';
 		}else{
 			formObj.total_loss_no.value='';
 		}
 		for(var i=0; i<rowArray.length; i++) {
 			var colArray=rowArray[i];
 			tempText +=  rowArray[i] + ',';
 		}
 		//Removing last comma
 		tempText=MnrDelLastDelim(tempText);
 		tempText=tempText.toUpperCase();
 		eval("document.form." + return_val + ".value='" + tempText + "';");
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
			formObj.lessor.value=aryPopupData[0][2];
			formObj.vndr_lgl_eng_nm.value=aryPopupData[0][4];
		}
	}
	function initControl() {
	    //Axon event handling 1. Catching event
		var formObject=document.form;
	    axon_event.addListenerForm  ('blur',     'obj_change',  formObject);
//	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);
//	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);
	    axon_event.addListenerFormat('change',	 'obj_change',		formObject);
	}
	//Axon event handling 2. Event handling function
//	function obj_deactivate(){
//	    ComChkObjValid(ComGetEvent());
//	}
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "lessor":
					formObj.lessor.value=ComLpad(formObj.lessor.value,6,"0");
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
				
	    		case "curr_cd":
	    			if(sheetObj.RowCount() > 0){
	    				doActionIBSheet(sheetObj,formObj,IBSEARCH);
	    			}
	    			break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "lessor":
					ComSetObjValue(formObj.vndr_lgl_eng_nm,"")
				   	break;
	    		case "curr_cd":
	    			if(sheetObj.RowCount() > 0){
	    				doActionIBSheet(sheetObj,formObj,IBSEARCH);
	    			}
	    			break;
			}
		}
	}
//	function obj_keypress(){
//	    obj=ComGetEvent();
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "ymd":
//	        case "int":
//				ComKeyOnlyNumber(obj);
//	            break;
//	        case "float":
//	            ComKeyOnlyNumber(obj, "-.");
//	            break;
//	        case "eng":
//	            ComKeyOnlyAlphabet();
//				break;
//	        case "engup":
//				if(obj.name == "lessor"){
//					ComKeyOnlyAlphabet('uppernum');
//				} else {
//					ComKeyOnlyAlphabet('uppernum','44');
//				}
//	            break;
//	    }
//	}
	/* End of developer's task */
