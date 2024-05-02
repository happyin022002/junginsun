/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0193.js
*@FileTitle  : EQ Component
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

   	/* Developer's task	*/
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//Saving status for clicked sheet
	var sheetClicks=new Array(0,0,0,0);
	// Defining event handler of button click
	document.onclick=processButtonClick;
	var opener = window.dialogArguments;
	/**
	 * Event handler to diverge process by button name
	 */
    function processButtonClick(){
    	/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
        var sheetObject=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		var sheetObject2=sheetObjects[2];
		var sheetObject3=sheetObjects[3];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
						doActionIBSheet(sheetObject, formObject, IBSEARCH)
						break;
				case "btn_New":
						doActionIBSheet(sheetObject, formObject, IBCLEAR)
						break;
				case "btn_Ok":
					var selRow = sheetObject3.FindCheckedRow("checkbox");
					//alert( sheetObject3.FindCheckedRow("checkbox") );
					var rtn = sheetObject3.GetCellText(selRow,2);
						if(sheetObject3.FindCheckedRow("checkbox") == ""){
							ComShowCodeMessage("MNR00038","SELECT ");
						} else {
							comPopupOK_mnr0193(sheetObject3);
//							ComPopUpReturnValue(sheetObject3.GetCellValue(selRow, 2));
						}
						break;
				case "btn_Close":
					ComClosePopup(); 
						break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
				ComFuncErrMsg(e);
    		} else {
				ComFuncErrMsg(e);
    		}
    	}
    }
    
    /**
     * Assigning array of IBSheet object
     * @param	{IBSheet}	sheet_obj
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
		MnrWaitControl(true);
		if (!opener) opener = parent;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
			//Initializing status
			sheetClicks[i]=0;
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
	           break;
			  case 2:
			  	with (comboObj) {
					SetTitle("Code|Desc");
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "200");
					SetDropHeight(160);
		    	}
			   break;
	     }
	}
	
   /**
     * Initializing variable for IBSheet and defining header
     * @param	{IBSheet}	sheetObj
	 * @param	{Number}	sheetNo		Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
            		var HeadTitle1="|Code|EQ Type|Description";
            		var headCount=ComCountHeadTitle(HeadTitle1);

            		SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_loc_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_loc_cd_lvl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_loc_prnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_less_20ft_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetEditableColorDiff(0);
            		SetCountPosition(0);
            		SetSelectionMode(smSelectionRow);
            		SetSheetHeight(302);
            	}
                break;
            case "sheet2":
                with(sheetObj){
            		var HeadTitle1="|Code|Description";
            		var headCount=ComCountHeadTitle(HeadTitle1);

            		SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_loc_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_loc_cd_lvl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_loc_prnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_less_20ft_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetEditableColorDiff(0);
            		SetCountPosition(0);
            		SetSelectionMode(smSelectionRow);
            		SetSheetHeight(302);
            	}
                break;
            case "sheet3":
                with(sheetObj){
            		var HeadTitle1="|Code|Less 20ft|Description";
            		var headCount=ComCountHeadTitle(HeadTitle1);

            		SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_less_20ft_flg",  KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 , TrueValue:"Y", FalseValue:"N"},
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_loc_nm",         KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_loc_cd_lvl",     KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_loc_prnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetEditableColorDiff(0);
            		SetCountPosition(0);
            	    SetSelectionMode(smSelectionRow);
            		SetSheetHeight(302);
            	}
                break;
            case "sheet4":
                with(sheetObj){
            		var HeadTitle1="|S|Code|Less 20ft|Description";
            		var headCount=ComCountHeadTitle(HeadTitle1);

            		SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            		             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_less_20ft_flg",  KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 , TrueValue:"Y", FalseValue:"N"},
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_loc_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_loc_cd_lvl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_loc_prnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetEditableColorDiff(0);
            		SetCountPosition(0);
            		SetSelectionMode(smSelectionRow);
            		SetSheetHeight(302);
            	}
                break;
        }
    }
    
	/**
	 * Sheet related process processing
	 * @param {IBSheet} sheetObj Used sheet object
	 * @param {Form}  formObj  Used form object
	 * @param {Number} sAction  Variable for diverge (Define from CoObject.js)
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
		    case IBSEARCH:    //Retrieving
	          		if (sheetObj.id == 'sheet1') {
						for(i=0;i<sheetObjects.length;i++){
			            	sheetObjects[i].RemoveAll();
			         	}
	          			formObj.f_cmd.value=SEARCH;
	          			formObj.f_type.value='grid';
						for(var i=0; i < sheetObjects.length; i++){
							sheetObjects[i].SetWaitImageVisible(0);
						}
//parameter changed[check again]CLT
						var sXml=sheetObj.GetSearchData("EES_MNR_0193GS.do", FormQueryString(formObj));
						var arrXml=sXml.split("|$$|");
						for(var i=0; i < arrXml.length; i++){
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
						}
						for(var i=1; i <= sheetObj.RowCount(); i++){
							sheetObj.SetRowHidden(i,0);
						}
	          		}
	          	break;
          	case IBCLEAR: //  Initializing all sheet and combo data
          		MnrWaitControl(true);
                sheetObj.SetWaitImageVisible(0);
	      	   	if (sheetObj.id == 'sheet1') {
					 //Initializing all sheet
					 for(i=0;i<sheetObjects.length;i++){
			            sheetObjects[i].RemoveAll();
						sheetClicks[i]=0;
			         }
				   	//Initializing combo data
					for(var i=0; i < comboObjects.length;i++){
				 		 comboObjects[i].RemoveAll();
					}
					var sheetComboText="";
					var sheetComboCode="";
					var sheetComboDefault="";
					var sCondition=new Array (
						new Array("MnrGenCd","", "CUSTOM9"),
						new Array("MnrEqLocCd","1","COMMON")
					)
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					eq_knd_cd.InsertItem(0,"ALL","ALL");
					if(comboList[0] != null){
						for(var j=0; j < comboList[0].length;j++){
							var tempText=comboList[0][j].split("|");
							sheetComboCode +=  tempText[0] + "|";
							sheetComboText +=  tempText[1] + "|";
							eq_knd_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);
							if(j == 0){
								sheetComboDefault=tempText[0];
							}
						}
						sheetObj.SetColProperty(0,"eq_knd_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
					}
					//Value setting of initialize
					if(MnrNullToBlank(formObj.rec_eq_knd_cd.value) == "A" || MnrNullToBlank(formObj.rec_eq_knd_cd.value) == ""){
						eq_knd_cd.SetSelectCode("ALL");
					} else {
						eq_knd_cd.SetSelectCode(formObj.rec_eq_knd_cd.value);
					}
					key_value.InsertItem(0, 'ALL|ALL retrieve' ,'ALL');
					if(comboList[1] != null){
						for(var j=0; j < comboList[1].length;j++){
							var tempText=comboList[1][j].split("|");
							key_value.InsertItem(j + 1, tempText[0] + '|' + tempText[1] ,tempText[0]);
						}
					}
					if(MnrNullToBlank(formObj.rec_key_value.value) == ""){
						key_value.SetSelectCode("ALL");
					} else {
						key_value.SetSelectCode(formObj.rec_key_value.value);
					}
	      	   	}
				MnrWaitControl(false);
                sheetObj.SetWaitImageVisible(1);
	      	   	break;
        }
    }
    
	/**
     * comPopupOK
     */
	function comPopupOK_mnr0193(sheetObj) {
		var formObj=document.form;
		var rArray=new Array();
	    var sRow=sheetObj.FindCheckedRow("checkbox");
	    var arrRow=sRow.split("|");
		var cArray=new Array();
	    for (idx=0; idx < arrRow.length; idx++){
	    	cArray[idx]=sheetObj.GetCellValue(arrRow[idx], "eq_loc_cd");
		}
		opener.setEES_MNR_0193(cArray);
		ComClosePopup(); 
	}
	
	/* ********* User Functions ************* */
	/**
	 * Filtering sheet when an event occurs
	 * @param	{Number}	sheetIdx		index of target sheet
	 * @param 	{String}  	keyValue  		Condition for filtering
	 * @param 	{Form}  	foreginKey  	Filtered column
	 */
	function MnrSheetFiltering(sheetIdx,keyValue,foreginKey){
		for (var idx=1; idx <= sheetObjects[sheetIdx].RowCount(); idx++){
			if(sheetObjects[sheetIdx].GetCellValue(idx,foreginKey) == keyValue && sheetObjects[sheetIdx].GetCellValue(idx,'ibflag') != 'D'){
				sheetObjects[sheetIdx].SetRowHidden(idx,0);
			} else {
				sheetObjects[sheetIdx].SetRowHidden(idx,1);
			}
		}
	}
	
	/**
	 * Hiding all sheet
	 * @param 	{IBSheet} 	sheetObj	Used sheet object
	 */
	function MnrAllSheetHidden(sheetObj){
		for (var idx=1; idx <= sheetObj.RowCount(); idx++){
			sheetObj.SetRowHidden(idx,1);
		}
	}
	
	/* ********* Event Functions ************* */
	function sheet4_OnClick(sheetObj,Row, Col, Value){
		var sRow=sheetObj.FindCheckedRow("checkbox");
		var arrRow=sRow.split("|");
		for (idx=0; idx < arrRow.length; idx++){
			sheetObj.SetCellValue(arrRow[idx],"checkbox",0);
			sheetObj.SetRowBackColor(arrRow[idx],"#FFFFFF");
		}
		sheetObj.SetCellValue(Row,"checkbox",1);
		sheetObj.SetRowBackColor(Row,"#F0FFFF");
	}
	
	/**
	 * sheet3 click event
	 * @param	{IBSheet}		sheetObj
	 * @param 	{Number} 		Row
	 * @param 	{Number} 		Col
	 * @param 	{String} 		Value
	 */
	function sheet3_OnClick(sheetObj,Row,Col,Value){
		sheetClicks[2]=Row;
		var keyValue=sheetObj.GetCellValue(Row,"eq_loc_cd");
		for(var i=3; i < sheetObjects.length; i++){
			MnrAllSheetHidden(sheetObjects[i]);
			sheetClicks[i]=0;
		}
		MnrSheetFiltering(3,keyValue,"eq_loc_prnt_cd");
	}
	
	/**
	 * sheet2 click event
	 * @param	{IBSheet}		sheetObj
	 * @param 	{Number} 		Row
	 * @param 	{Number} 		Col
	 * @param 	{String} 		Value
	 */
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		sheetClicks[1]=Row;
		var keyValue=sheetObj.GetCellValue(Row,"eq_loc_cd");
		for(var i=2; i < sheetObjects.length; i++){
			MnrAllSheetHidden(sheetObjects[i]);
			sheetClicks[i]=0;
		}
		MnrSheetFiltering(2,keyValue,"eq_loc_prnt_cd");
	}
	
	/**
	 * sheet1 click event
	 * @param	{IBSheet}		sheetObj
	 * @param 	{Number} 		Row
	 * @param 	{Number} 		Col
	 * @param 	{String} 		Value
	 */
	function sheet1_OnClick(sheetObj,Row,Col,Value){
		sheetClicks[0]=Row;
		var keyValue=sheetObj.GetCellValue(Row,"eq_loc_cd");
		for(var i=1; i < sheetObjects.length; i++){
			MnrAllSheetHidden(sheetObjects[i]);
			sheetClicks[i]=0;
		}
		MnrSheetFiltering(1,keyValue,"eq_loc_prnt_cd");
	}
	/* End of developer's task */
