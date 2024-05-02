/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESS_MNR_0002.js
*@FileTitle  : M&R Cedex Code
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
    /**
     * @extends
     * @class ess_mnr_0002 : ess_mnr_0002 - Defining a script used by screen
     */
/* Developer's task */
/* ********* General Functions ************* */
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var comboValue="All";
	//Variable for saving status of clicked sheet
	var sheetClicks=new Array(0,0,0);
	//Variable for saving status of clicked retrieve button
	var retrieveClick=0;
	// Defining event handler of button click */
	// Office level by login user : HQ L1, RHQ L2, Office L3 (from MnrOfficeLevel function of CoMnr.js)
	var strMnrOfficeLevel="";
	document.onclick=processButtonClick;
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
    	//Setting button
    	MnrWaitControl(true);
		//Initializing sheet
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
			//Initializing status
			sheetClicks[i]=0;
        }
   	 	//Initializing IBMultiCombo
 	    for(var k=0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
		// Retrieving and Setting for office level
		MnrOfficeLevel(currOfcCd, rhqOfcCd);
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        setSaveBtnDisplay();
		///comboObjects[0].focus();
    }
	/**
	 * Assigning array of IBCombo object
	 * @param    {IBCombo}	combo_obj        Registered as an array IBCombo Object
	 */
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	}
	/**
	 * Assigning array of IBSheet object
	 * @param    {IBSheet}	sheet_obj        Registered as an array IBSheet Object
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
  	/**
     * Initializing IBCombo
     * @param	{IBCombo}	comboObj	Object for initialized IBCombo
     * @param	{Number}	comboNo		Sequence number from combo object tag id
     */
    function initCombo(comboObj, comboNo) {
	    var cnt=0 ;
	    var formObject=document.form
	    switch(comboNo) {
	    	case 1:
	            with (comboObj) {
					SetColAlign(0, "left");
					SetColAlign(1, "left");
		        }
	            break;
	     }
	}
  	/**
     * Initializing variable for IBSheet and defining header
     * @param	{IBSheet}	sheetObj	IBSheet object for initial setting
     * @param	{String}	sheetNo		Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
	              var HeadTitle1="|Sel|Code|Name";
	              //var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_prnt_cmpo_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_prnt_cmpo_grp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_num_iso_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_grp_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"cntr_cmpo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"chss_cmpo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"mgst_cmpo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
	              SetColProperty(0 ,"eq_cmpo_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              //conversion of function[check again]CLT 					InitDataValid(0,  "eq_cmpo_cd", vtEngUpOther,"0123456789");
              //MultiSelection=false;
              //SetSelectionMode(smSelectionRow);
              //SelectHighLight=true;
              //SelectFontBold=false;
              //SelectBackColor="#NANNANNAN";
//              SetSheetHeight(510);
              resizeSheet( sheetObj );
              }
		    	break;
            case "sheet2":
                with(sheetObj){
	              var HeadTitle1="|Sel|Code|Name";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_prnt_cmpo_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_prnt_cmpo_grp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_num_iso_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_grp_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"cntr_cmpo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"chss_cmpo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"mgst_cmpo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
	              SetColProperty(0 ,"eq_cmpo_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                    //conversion of function[check again]CLT 					InitDataValid(0,  "eq_cmpo_cd", vtEngUpOther,"0123456789");
	              //MultiSelection=false;
	              //SetSelectionMode(smSelectionRow);
	              //SelectHighLight=true;
	              //SelectFontBold=false;
	              //SelectBackColor="#NANNANNAN";
//	              SetSheetHeight(510);
	              resizeSheet( sheetObj );
              }


                break;
            case "sheet3":
                with(sheetObj){
	              var HeadTitle1="|Sel|Code|ISO|Name|U|Z|G|Description";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"DummyCheck", Hidden:0, 	Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	                     {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",              	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                     {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_num_iso_cd",      	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
	                     {Type:"Text",      Hidden:0,  	Width:150,  Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_nm",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                     {Type:"CheckBox",  Hidden:0, 	Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cmpo_flg", 			TrueValue:"Y", FalseValue:"N"},
	                     {Type:"CheckBox",  Hidden:0, 	Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chss_cmpo_flg", 			TrueValue:"Y", FalseValue:"N"},
	                     {Type:"CheckBox",  Hidden:0, 	Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mgst_cmpo_flg", 			TrueValue:"Y", FalseValue:"N"},
	                     {Type:"Text",      Hidden:0,  	Width:100,  Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_desc",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                     {Type:"Text",      Hidden:1, 	Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_prnt_cmpo_cd",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, 	Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_prnt_cmpo_grp_tp_cd",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, 	Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_grp_tp_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
	              SetColProperty(0 ,"eq_cmpo_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	              SetColProperty(0 ,"eq_cmpo_num_iso_cd" , {AcceptKeys:"N"});
	              //conversion of function[check again]CLT 					InitDataValid(0,  "eq_cmpo_cd", vtEngUpOther,"0123456789");
	              //conversion of function[check again]CLT 					InitDataValid(0,  "eq_cmpo_num_iso_cd", vtNumericOnly);
	              //MultiSelection=false;
	              //SetSelectionMode(smSelectionRow);
	              //SelectHighLight=true;
	              //SelectFontBold=false;
	              //SelectBackColor="#NANNANNAN";
//	              SetSheetHeight(510);
	              resizeSheet( sheetObj );
              }


		        break;
        }
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
	/**
	 * Event handler to diverge process by button name
	 */
    function processButtonClick(){
         /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
         /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_Retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;
					case "btn_New":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						setSaveBtnDisplay();
						break;
					case "btn_Save":
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;
					case "btn_RowAdd1":
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
						break;
					case "btn_RowDel1":
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
						break;
					case "btn_Excel1":
						if(sheetObject1.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1, DownRows:"Visible" });
						}
						break;
					case "btn_RowAdd2":
						doActionIBSheet1(sheetObject2,formObject,IBINSERT);
						break;
					case "btn_RowDel2":
						doActionIBSheet1(sheetObject2,formObject,IBDELETE);
						break;
					case "btn_Excel2":
						if(sheetObject2.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1, DownRows:"Visible" });
						}
						break;
					case "btn_RowAdd3":
						doActionIBSheet2(sheetObject3,formObject,IBINSERT);
						break;
					case "btn_RowDel3":
						doActionIBSheet2(sheetObject3,formObject,IBDELETE);
						break;
					case "btn_Excel3":
						if(sheetObject3.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							sheetObject3.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject3), SheetDesign:1,Merge:1, DownRows:"Visible" });
						}
						break;
					case "btn_Grouping3":
						openPopup();
						break;
					default:
						break;
            }
    	}catch(e) {
    		if( e == "[object Error]") {
				ComFuncErrMsg(e);
    		} else {
				ComFuncErrMsg(e);
    		}
    	}
    }
  	/**
     * Sheet1 related process processing
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBCLEAR:      //Initializing
				//Setting for button and progress bar
				sheetObj.SetWaitImageVisible(0);
				MnrWaitControl(true);
	        	//Initializing combo data
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].RemoveAll();
				}
				//Retrieving combo data
				var sCondition=new Array (
					new Array("MnrEqCmpoCd","1","COMMON") //Component Code Level 1
				)
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				//Setting for combo data
				for(var i=0; i < comboList.length;i++){
					comboObjects[i].RemoveAll();
					comboObjects[i].InsertItem(0, 'All | All Retrieve' ,'0');
					if(comboList[i] != null){
						for(var j=0; j < comboList[i].length;j++){
							comboObjects[i].InsertItem(j + 1, comboList[i][j] ,j + 1 + '');
						}
					}
					comboObjects[i].SetSelectCode(0);
				}
				//Initializing all sheet
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll();
					sheetClicks[i]=0;
	            }
				//Initializing clicked status of retrieve button
				retrieveClick=0;
				//Setting for button and progress bar
				MnrWaitControl(false);
				sheetObj.SetWaitImageVisible(1);
				break;
			case IBSEARCH:      //Retrieving
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH01;
				formObj.f_type.value="grid";
				formObj.key_value.value=comboValue;
				
				if(validateForm(sheetObj,formObj,sAction)) {
					//Retrieving multi data
					ComOpenWait(true);
					setTimeout( function () {
						var sXml=sheetObj.GetSearchData("EES_MNR_0002GS.do", FormQueryString(formObj));
						var arrXml=sXml.split("|$$|");
						for(var i=0; i < arrXml.length; i++){
							///sheetObjects[i].RenderSheet(0);
							if(i > 0) {
								sheetObjects[i].SetWaitImageVisible(0);
							}
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
							///sheetObjects[i].RenderSheet(1);
							if(i != 0) {
								MnrAllSheetHidden(sheetObjects[i]);
							}
						}
						for(var i=1; i <= sheetObj.RowCount(); i++){
							sheetObj.SetRowHidden(i,0);
						}
						ComOpenWait(false);
					} , 100);
				}
				retrieveClick=1;
				
				break;
			case IBSAVE:        //Saving
	            if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObjects);
				    if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
				    var sXml=sheetObjects[0].GetSaveData("EES_MNR_0002GS.do", sParam);
				    sheetObjects[0].LoadSaveData(sXml);
				    sheetObjects[1].LoadSaveData(sXml);
				    sheetObjects[2].LoadSaveData(sXml);
				}
	            break;
			case IBINSERT:      //Inserting
			    if(validateForm(sheetObj,formObj,sAction)) {
				    var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row, "eq_cmpo_grp_tp_cd","1",0);
					sheetObj.SetCellValue(Row, "eq_prnt_cmpo_grp_tp_cd","N",0);
					sheetObj.SetCellValue(Row, "eq_prnt_cmpo_cd","N",0);
					sheetObj.SetCellValue(Row, "eq_cmpo_num_iso_cd","00000",0);
					//set Focus
					sheetObj.SelectCell(Row, "eq_cmpo_cd");
				}
				break;
			case IBDELETE:      //Deleting
			    if(validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == 'sheet1') {
						ComRowHideDelete(sheetObj, "del_chk");
			   	   	}
					for(var i=1; i < sheetObjects.length; i++){
						MnrAllSheetHidden(sheetObjects[i]);
					}
				}
				break;
        }
    }
  	/**
     * Sheet1 related process processing
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBINSERT:      //Inserting
				if(sheetClicks[0] == 0 || (sheetObjects[0].GetCellValue(sheetClicks[0],"eq_cmpo_cd") == '')){
					ComShowCodeMessage("MNR00143","EQ Component");
				} else {
				    var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row, "eq_cmpo_grp_tp_cd","2",0);
					sheetObj.SetCellValue(Row, "eq_prnt_cmpo_grp_tp_cd","1",0);
					sheetObj.SetCellValue(Row, "eq_prnt_cmpo_cd",sheetObjects[0].GetCellValue(sheetClicks[0], "eq_cmpo_cd"),0);
					sheetObj.SetCellValue(Row, "eq_cmpo_num_iso_cd",sheetObjects[0].GetCellValue(sheetClicks[0], "eq_cmpo_cd")+"000",0);
					//set Focus
					sheetObj.SelectCell(Row, "eq_cmpo_cd");
				}
				break;
			case IBDELETE:      //Deleting
			    if(validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == 'sheet2') {
						ComRowHideDelete(sheetObj, "del_chk");
			   	   	}
					for(var i=2; i < sheetObjects.length; i++){
						MnrAllSheetHidden(sheetObjects[i]);
					}
				}
				break;
        }
    }
  	/**
     * Sheet2 related process processing
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBINSERT:      //Inserting
				if(sheetClicks[1] == 0 || (sheetObjects[1].GetCellValue(sheetClicks[1], "eq_cmpo_cd") == '')){
					ComShowCodeMessage("MNR00143","EQ Component");
				} else {
				    var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row, "eq_cmpo_grp_tp_cd","3",0);
					sheetObj.SetCellValue(Row, "eq_prnt_cmpo_grp_tp_cd","2",0);
					sheetObj.SetCellValue(Row, "eq_prnt_cmpo_cd",sheetObjects[1].GetCellValue(sheetClicks[1], "eq_cmpo_cd"),0);
					//set Focus
					sheetObj.SelectCell(Row, "eq_cmpo_cd");
				}
				break;
			case IBDELETE:      //Deleting
				if(validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == 'sheet3') {
						ComRowHideDelete(sheetObj, "del_chk");
			   	   	}
				}
				break;
        }
    }
  	/**
     * Validating process for input form data
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			//Retrieving
			if (sAction==IBSEARCH) {
				for (var i=0; i<sheetObjects.length; i++){
					if(sheetObjects[i].IsDataModified()){
						if(!ComShowCodeConfirm("MNR00007")){return false;}
					}
				}
			}
			else if(sAction==IBSAVE) {
				//Duplicate checking when saving data
				for (var i=0; i<sheetObjects.length; i++){
					var Row=sheetObjects[i].ColValueDup("eq_cmpo_cd|eq_prnt_cmpo_cd|eq_cmpo_num_iso_cd");
					if(sheetObjects[i].IsDataModified()){
						if(Row>0){
							ComShowCodeMessage("MNR00006",i + 1 + "th sheet of " + Row + " row ");
							sheetObjects[i].SetCellValue(Row,"eq_cmpo_cd","",0);
							sheetObjects[i].SelectCell(Row, "eq_cmpo_cd", true);
							return false;
						}
					}
				}
			}
			else if(sAction==IBINSERT){
				//Checking retrieved status when inserting data
				if(retrieveClick==0){
					ComShowCodeMessage("MNR00147");
					return false;
				}
			}
			else if(sAction==IBDELETE){
				//Checking target row when deleting
				var checkRow=sheetObj.FindCheckedRow(1);
				if(checkRow=='') {
					ComShowCodeMessage("MNR00150");
					return false;
				}
			}
        }
        return true;
    }
/* ********* User Functions ************* */
	/**
	 * Hiding all sheet
	 * @param    {IBSheet}	sheetObj	Target sheet
	 */
	function MnrAllSheetHidden(sheetObj){
		for (var idx=1; idx <= sheetObj.RowCount(); idx++){
			sheetObj.SetRowHidden(idx,1);
		}
	}
	/**
	 * Filtering each sheet by clicked event
	 * @param	{Number}	sheetIdx
	 * @param	{String}	keyValue
	 * @param	{String}	foreginKey
	 */
	function MnrSheetFiltering(sheetIdx,keyValue,foreginKey){
		for (var idx=1; idx <= sheetObjects[sheetIdx].RowCount(); idx++){
			if(sheetObjects[sheetIdx].GetCellValue(idx,foreginKey) == keyValue){
				sheetObjects[sheetIdx].SetRowHidden(idx,0);
			} else {
				sheetObjects[sheetIdx].SetRowHidden(idx,1);
			}
		}
	}
	/**
	 * Calling pop-up by grouping button click of sheet3
	 */
    function openPopup() {
		var eqCmpoCd="";  //EQ Component Code
		var eqCmpoNm="";  //EQ Component Name
		var eqCmpoDesc="";  //Description
		eqCmpoCd=sheetObjects[2].GetCellValue(sheetClicks[2],"eq_cmpo_cd");
		eqCmpoNm=sheetObjects[2].GetCellValue(sheetClicks[2],"eq_cmpo_nm");
		eqCmpoDesc=sheetObjects[2].GetCellValue(sheetClicks[2],"eq_cmpo_desc");
		if((sheetClicks[2] == 0 || eqCmpoCd == '' )){
			ComShowCodeMessage("MNR00036","EQ Component");
			return;
		}
        ComPostOpenWindow('/opuscntr/EES_MNR_0145.do?eqCmpoCd='+eqCmpoCd+'&eqCmpoDesc='+eqCmpoDesc+'&eqCmpoNm='+eqCmpoNm+'&strMnrOfficeLevel='+strMnrOfficeLevel, 'win1', 'width=1300,height=520');
    }
/* ********* Event Functions ************* */
	/**
	 * Showing result message after saving
	 * @param	{IBSheet}	sheetObj	target object
	 * @param	{String}	ErrMsg
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00023",'');
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
	/**
	 * SHEET1 click event
	 * @param	{IBSheet}	sheetObj	Clicked the sheet object
	 * @param	{Number}	Row			Clicked the sheet row
	 * @param	{String}	Col			Clicked the sheet column
	 */
	function sheet1_OnClick(sheetObj,Row,Col){
		sheetClicks[0]=Row;
		var keyValue=sheetObj.GetCellValue(Row,"eq_cmpo_cd");
		for(var i=1; i < sheetObjects.length; i++){
			MnrAllSheetHidden(sheetObjects[i]);
			sheetClicks[i]=0;
		}
		MnrSheetFiltering(1,keyValue,"eq_prnt_cmpo_cd");
	}
	/**
	 * SHEET2 click event
	 * @param	{IBSheet}	sheetObj	Clicked the sheet object
	 * @param	{Number}	Row			Clicked the sheet row
	 * @param	{String}	Col			Clicked the sheet column
	 */
	function sheet2_OnClick(sheetObj,Row,Col){
		sheetClicks[1]=Row;
		var keyValue=sheetObj.GetCellValue(Row,"eq_cmpo_cd");
		for(var i=2; i < sheetObjects.length; i++){
			MnrAllSheetHidden(sheetObjects[i]);
			sheetClicks[i]=0;
		}
		MnrSheetFiltering(2,keyValue,"eq_prnt_cmpo_cd");
	}
	/**
	 * SHEET3 click event
	 * @param	{IBSheet}	sheetObj	Clicked the sheet object
	 * @param	{Number}	Row			Clicked the sheet row
	 * @param	{String}	Col			Clicked the sheet column
	 */
	function sheet3_OnClick(sheetObj,Row,Col){
		sheetClicks[2]=Row;
	}
	/**
	 * Event handling of Onchange of combo
	 * @param	{IBMultiCombo}	comboObj	Changed combo object
	 * @param	{Number}		Index_Code	Changed combo code
	 * @param	{String}		Text		Changed combo value
	 */
	//function combo1_OnChange(comboObj,Index_Code, Text){
	function combo1_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		comboValue=comboObj.GetText(NewCode,0);
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
