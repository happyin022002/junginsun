/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0225.js
*@FileTitle  : Division Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends Mnr
     * @class EES_MNR_0225 : EES_MNR_0225 - Defining a script used by screen
     */

   	/* Developer's task	*/
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Office level by login user : HQ L1, RHQ L2, Office L3 (from MnrOfficeLevel function of CoMnr.js)
var strMnrOfficeLevel="";
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
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					setSaveBtnDisplay();
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
				case "btn_RowAdd":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;
				case "btn_RowDelete":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
					break;
				case "btn_RowCopy":
					doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
					break;
				case "btn_Excel1":
					//sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
					if(sheetObjects[0].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
						// {DownCols: makeHiddenSkipCol(		sheetObj), SheetDesign:1,Merge:1 }
					}
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
		// Retrieving and Setting for office level
		MnrOfficeLevel(currOfcCd, rhqOfcCd);
		MnrWaitControl(true);
		initControl();
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k + 1);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		setSaveBtnDisplay();
    }
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboNo) {
			   default :
		           with (comboObj) {
				       //SetColAlign("left");
					   //DropHeight = 160;
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
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with(sheetObj){              
          
              var HeadTitle1="|Sel|Seq.|Tariff Group|Component Code|Repair Code|Division Code|Man-Hour|Description";
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );    
              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                     {Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cost_grp_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, InputCaseSensitive:1 },
                     {Type:"Combo", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, InputCaseSensitive:1 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"to_rlt_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, InputCaseSensitive:1 },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"mnr_rlt_cd_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"fm_rlt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"eq_cedex_rlt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);
              SetEditable(1);
//              SetSheetHeight(402);  
              resizeSheet( sheetObj );
              }


                break;
        }
    }
    //Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //Retrieving
              	if(validateForm(sheetObj,formObj,sAction)){
			  		var f_query='';
					f_query += 'f_cmd' + '=' + SEARCH + '&';
					f_query += 'in_cost_grp_cd=' +  in_cost_grp_cd.GetSelectCode()+ '&';
					f_query += 'in_eq_cmpo_cd=' +  formObj.in_eq_cmpo_cd.value;
					sheetObj.DoSearch("EES_MNR_0225GS.do",f_query );
			  	}
                break;
			case IBSAVE:        //Saving
              	if(validateForm(sheetObj,formObj,sAction)){
              		if (!ComShowCodeConfirm("MNR00160","")){
              			return false;
              		}
			  		formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObj);
					//Checking mandatory input data
					if(sParam == "" && sheetObj.IsDataModified()){
						return;
					}
					 sParam += "&" + FormQueryString(formObj);
					 var sXml=sheetObj.GetSaveData("EES_MNR_0225GS.do", sParam);
					 sheetObjects[0].LoadSaveData(sXml);
			  	}
                break;
			case IBINSERT:      // Adding row
				var Row=sheetObj.DataInsert(-1);
				//set Value Init
				sheetObj.SetCellValue(Row, "eq_cedex_rlt_tp_cd","CTV",0);
				sheetObj.SetCellValue(Row, "eq_cmpo_cd","",0);
				sheetObj.SetCellValue(Row, "eq_rpr_cd","",0);
				sheetObj.SetTotalRows(Row);
                break;
			case IBDELETE:      // Deleting row
				ComRowHideDelete(sheetObj,  "del_chk");
                break;
			case IBCOPYROW:
				if(sheetObj.GetSelectRow()< 1){
					ComShowCodeMessage("MNR00282");
				} else {
					var Row=sheetObj.GetSelectRow();
					var costGrpCd=sheetObj.GetCellValue(Row,"cost_grp_cd");
					var eqCmpoCd=sheetObj.GetCellValue(Row,"eq_cmpo_cd");
					var eqRprCd=sheetObj.GetCellValue(Row,"eq_rpr_cd");
					var fmRltCd=sheetObj.GetCellValue(Row,"fm_rlt_cd");
					var newRow=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(newRow, "eq_cedex_rlt_tp_cd","CTV",0);
					sheetObj.SetCellValue(newRow, "eq_cmpo_cd",eqCmpoCd,0);
					sheetObj.SetCellValue(newRow, "eq_rpr_cd",eqRprCd,0);
					sheetObj.SetCellValue(newRow, "fm_rlt_cd",fmRltCd,0);
					sheetObj.SetCellValue(newRow, "to_rlt_cd","",0);
					sheetObj.SetCellValue(newRow, "mnr_rlt_cd_desc","",0);
					sheetObjects[0].SelectCell(newRow,"to_rlt_cd");
				}
				break;
			case IBCLEAR:
				MnrWaitControl(true);
				sheetObj.SetWaitImageVisible(0);
				//Initializing form
				formObj.reset();
				//Initializing sheet
				sheetObjects[0].RemoveAll();
				//Initializing combo
				for(var i=0; i < comboObjects.length;i++){
					if(i != 0 && i != 3){
						comboObjects[i].SetSelectCode("-1");
						comboObjects[i].RemoveAll();
					}
				}
				var sCondition=new Array (
					new Array("MnrGenCd","CC", "COMMON")
				)
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				//Tariff Type
				comboObjects[0].InsertItem(0,"ALL","ALL");
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						comboObjects[0].InsertItem(j + 1, tempText[1] ,tempText[0]);
					}
				}
				comboObjects[0].SetSelectCode("ALL");
				//Sheet Setting combo
				var sCondition=new Array (
					new Array("MnrGenCd","CC", "COMMON"),
					new Array("MnrCedexOthCd","RPR","COMMON"), 	//RPR
					new Array("MnrEqCmpoCd","3","COMMON")
				)
				var sheetComboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboDefault="";
				var comboSaveNames=new Array();
				comboSaveNames[0]="cost_grp_cd";
				comboSaveNames[1]="eq_rpr_cd";
				comboSaveNames[2]="eq_cmpo_cd";
				for(var i=0; i < sheetComboList.length;i++){
				 	if(sheetComboList[i] != null){
						//Initializing each combo of sheets
						sheetComboText="";
						sheetComboCode="";
						sheetComboCodeText="";
				 		for(var j=0; j < sheetComboList[i].length;j++){
							var tempText=sheetComboList[i][j].split("|");
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
						}
			   	     	sheetComboText=MnrDelLastDelim(sheetComboText);
				        sheetComboCode=MnrDelLastDelim(sheetComboCode);
				        sheetComboCodeText=MnrDelLastDelim(sheetComboCodeText);
						if(comboSaveNames[i] == "cost_grp_cd"){
							var arrCode = sheetComboCode.split("|")[0];
							sheetObjects[0].InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,arrCode);
						} else {
							sheetObjects[0].InitDataCombo (0, comboSaveNames[i], sheetComboCodeText, sheetComboCode ,"");
						}
					}
				}
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
				break;
			case IBSEARCH_ASYNC01:        //Checking Component Code
	            if(validateForm(sheetObj,formObj,sAction)){
					var checkComp=formObj.in_eq_cmpo_cd.value;
					retArray=MnrGeneralCodeCheck(sheetObj,"COMP",checkComp);
					if(retArray == null){
						ComShowCodeMessage("MNR00165",checkComp);
						ComSetObjValue(formObj.in_eq_cmpo_cd, "");
						ComSetObjValue(formObj.eq_cmpo_nm, "");
						ComSetFocus(in_eq_cmpo_cd);
					} else {
						var retValue=retArray[0].split("|");
						ComSetObjValue(formObj.eq_cmpo_nm,retValue[1]);
						return;
					}
				}
				break;
        }
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
				case IBSAVE:
					if (!ComChkValid(formObj)) return false;
					//duplicate checking When saving 
					for (var i=0; i<sheetObjects.length; i++){
						var Row=sheetObjects[i].ColValueDup( "cost_grp_cd|eq_cmpo_cd|eq_rpr_cd|to_rlt_cd");

						if(sheetObjects[i].IsDataModified()){
							if(Row>0){
									ComShowCodeMessage("MNR00006",i + 1 + "th sheet of " + Row + " row ");
									return false;
								}
							}
						else
							{
								ComShowCodeMessage("MNR00030","The data which to save");
								return false;
							}
						}
				 	break;
			}
        }
        return true;
    }
	function sheet1_OnChange(sheetObj, Row, Col, Value)
    {
		var formObject=document.form;
		if(sheetObj.ColSaveName(Col) == "eq_cmpo_cd" || sheetObj.ColSaveName(Col) == "eq_rpr_cd"){
			var msgTarget="";
			if(sheetObj.ColSaveName(Col) == "eq_cmpo_cd"){
				msgTarget="Component Code";
			} else {
				msgTarget="Repair Code";
			}
			var checkColNm=sheetObj.ColSaveName(Col);
			var checkCd=sheetObj.GetCellValue(Row,checkColNm);
			var isPossible=false;
			var sCode=sheetObj.GetComboInfo(Row,checkColNm,"Code");
			var arrCode=sCode.split("|");
			for(var i=0;i < arrCode.length;i ++){
				if(arrCode[i] == checkCd){
					isPossible=true;
				}
			}
			if(!isPossible){
				ComShowCodeMessage("MNR00010",msgTarget);
				sheetObj.SetCellValue(Row ,checkColNm,"",0);
				sheetObj.SelectCell(Row ,checkColNm);
				return;
			}
			sheetObj.SetCellValue(Row ,"fm_rlt_cd",sheetObj.GetCellValue(Row ,"eq_cmpo_cd") + sheetObj.GetCellValue(Row ,"eq_rpr_cd"),0);
		}
    }
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00023","Division Type Code ");
		}
	}
	function initControl() {
	    //Axon event handling 1. Catching event
		var formObject=document.form;
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);
	   // axon_event.addListenerFormat('focus',    'obj_activate',    formObject);	  
		axon_event.addListenerFormat('change',	 'obj_change',	formObject);
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
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "in_eq_cmpo_cd":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "in_eq_cmpo_cd":
					formObj.eq_cmpo_nm.value="";
				   	break;
			}
		}
	}
	
	/**
	 * Setting displayed of save button
	 * @return
	 */
	function setSaveBtnDisplay() {
		if(strMnrOfficeLevel=="L1") {
			ComBtnEnable("btn_Save");
		} else {
			ComBtnDisable("btn_Save");
		}
	}
	/* End of developer's task */
