/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0009.js
*@FileTitle : M&R Other Code
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ess_mnr_0009 : ess_mnr_0009 - Defining a script used by screen
     */
/* Developer's task	*/
/* ********* General Functions ************* */
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var comboValue="All";
	//Saving status for clicked sheet
	var sheetClicks=new Array(0,0,0);
	//Variable for saving status of clicked retrieve button
	var retrieveClick=0;
	// Office level by login user : HQ L1, RHQ L2, Office L3 (from MnrOfficeLevel function of CoMnr.js)
	var strMnrOfficeLevel="";
	// Defining event handler of button click */
	document.onclick=processButtonClick;
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
		// Retrieving and Setting for office level
		MnrOfficeLevel(currOfcCd, rhqOfcCd);
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
 	    //Initializing event
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		setSaveBtnDisplay();
		//set focus
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
					SetColWidth(0, "45");
					SetColWidth(1, "255");
					//SetBackColor("#D4F4FA");
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
              var HeadTitle1="|Sel|Code|Description|Dp";
              var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mnr_cd_id",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                     {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                     {Type:"Text",      Hidden:0,  Width:20,   Align:"Right",   ColMerge:1,   SaveName:"mnr_cd_dp_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_grp_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"pair_dp_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"prnt_cd_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_grp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_dp_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_ord_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"intg_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetColProperty(0 ,"mnr_cd_id" , {AcceptKeys:"E" , InputCaseSensitive:1});
              SetColProperty(0 ,"mnr_cd_dp_seq" , {AcceptKeys:"N"});
              SetColProperty(0 ,"mnr_cd_desc", {AcceptKeys:"E|N|[ .-/,()&_#]"});
                    //conversion of function[check again]CLT 					InitDataValid(0,  "mnr_cd_id", vtEngUpOther);
              //conversion of function[check again]CLT 					InitDataValid(0,  "mnr_cd_dp_seq", vtNumericOnly);
              SetSelectionMode(smSelectionRow);

//              SetSheetHeight(530);
              resizeSheet( sheetObj );
              }


		    	break;
            case "sheet2":
                with(sheetObj){
              var HeadTitle1="|Sel|Code|Description|DpDesc|Dp|AgmtFlg|OrdTp";
              var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"mnr_cd_id",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
                     {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                     {Type:"Text",      Hidden:0,  Width:115,  Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_dp_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"mnr_cd_dp_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                     {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"agmt_use_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, TrueValue:"Y", FalseValue:"N" },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_ord_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_grp_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"pair_dp_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"prnt_cd_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_grp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"intg_flg", 		   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetColProperty(0 ,"mnr_cd_id" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
              SetColProperty(0 ,"mnr_cd_dp_seq" , {AcceptKeys:"N", InputCaseSensitive:1});
              SetColProperty(0 ,"mnr_cd_desc", {AcceptKeys:"E|N|[.-/,() &_#]"});
              SetColProperty(0 ,"mnr_cd_dp_desc", {AcceptKeys:"E|N|[.-/,() &_#]"});
                    //conversion of function[check again]CLT 					InitDataValid(0,  "mnr_cd_id", vtEngUpOther,"0123456789");
              //conversion of function[check again]CLT                     InitDataValid(0,  "mnr_cd_dp_seq", vtNumericOnly);
              SetSelectionMode(smSelectionRow);

//              SetSheetHeight(530);
              resizeSheet( sheetObj );
              }


                break;
            case "sheet3":
                with(sheetObj){
              var HeadTitle1="|Sel|Code|Description|DpDesc|Max|Account|Shipment|Agmt Exist|Agmt Rate|Dp";
              var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mnr_cd_id",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
                     {Type:"Text",      Hidden:0,  Width:115,  Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                     {Type:"Text",      Hidden:0,  Width:115,  Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_dp_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                     {Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mnr_cd_dflt_pnt_no",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:1,   SaveName:"acct_cd",      		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"cost_shp_srch_patt_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_val_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, TrueValue:"Y", FalseValue:"N" },
                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_rt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, TrueValue:"Y", FalseValue:"N" },
                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"mnr_cd_dp_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_grp_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"pair_dp_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"delt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"prnt_cd_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"mnr_cd_grp_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"mnr_ord_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"intg_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetColProperty(0 ,"mnr_cd_id" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
              SetColProperty(0 ,"mnr_cd_dp_seq" , {AcceptKeys:"N", InputCaseSensitive:1});
              SetColProperty(0 ,"mnr_cd_desc", {AcceptKeys:"E|N|[.-/,() &_#]"});
              SetColProperty(0 ,"mnr_cd_dp_desc", {AcceptKeys:"E|N|[.-/,() &_#]"});
              
              //conversion of function[check again]CLT 					InitDataValid(0,  "mnr_cd_id", vtEngUpOther,"0123456789");
              //conversion of function[check again]CLT 					InitDataValid(0,  "mnr_cd_dp_seq", vtNumericOnly);
              SetSelectionMode(smSelectionRow);

//              SetSheetHeight(530);
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
				switch(srcName) {
					case "btn_Retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;
					case "btn_New":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						setSaveBtnDisplay();
						break;
					case "btn_Save":
						if(ComGetBtnDisable("btn_Save")){return false;}
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
							sheetObject3.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject3), SheetDesign:1, Merge:1, DownRows:"Visible" });
						}
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
     * Sheet related process processing
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
					new Array("MnrGenCd","1", "CUSTOM1") 		//GenCode Level 1
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
			    //Combo setting of sheet
			    setSheetCombo(sheetObj);
			    setCostShpCombo(sheetObj, "");
				//Initializing clicked status of retrieve button
				retrieveClick=0;
				//Initializing hidden column
				sheetObjects[2].SetColHidden("mnr_cd_dflt_pnt_no",1);
				sheetObjects[2].SetColHidden("acct_cd",1);
				//Setting for button and progress bar
				MnrWaitControl(false);
				sheetObj.SetWaitImageVisible(1);
				break;
			case IBSEARCH:      //Retrieving
				//ComOpenWait(true);
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH01;
				formObj.mnr_cd_id.value=comboValue;
				if(validateForm(sheetObj,formObj,sAction)) {
					//Retrieving multi data
					var sXml=sheetObj.GetSearchData("EES_MNR_0009GS.do", FormQueryString(formObj));
//					var arrXml=sXml.split("|$$|");
//					for(var i=0; i < arrXml.length; i++){
//						///sheetObjects[i].RenderSheet(0);
//						if(i > 0) {
//							sheetObjects[i].SetWaitImageVisible(0);
//						}
//						sheetObjects[i].LoadSearchData(arrXml[i], {Sync:1});
//						///sheetObjects[i].RenderSheet(1);
//					}
					sheetObjects[0].LoadSearchData(sXml, {Sync:1});
					
//					for(var i=1; i <= sheetObj.RowCount(); i++){
//						sheetObj.SetRowHidden(i,0);
//					}
//					//Clicked event of sheet1 and the same logic processing
//					sheetClicks[0]=1;
					var keyValue=sheetObj.GetCellValue(1,"mnr_cd_id");
//					for(var i=1; i < sheetObjects.length; i++){
//						MnrAllSheetHidden(sheetObjects[i]);
//						sheetClicks[i]=0;
//					}
					MnrSheetFiltering(1,keyValue,"prnt_cd_id");
					//Setting column display (AgmtFlg)
					setSheet2Column(keyValue);
				}
				retrieveClick=1;
				break;
			case IBSAVE:        //Saving
	            if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObjects);
				    if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
				    var sXml=sheetObjects[0].GetSaveData("EES_MNR_0009GS.do", sParam);
				    sheetObjects[0].LoadSaveData(sXml);
				    sheetObjects[1].LoadSaveData(sXml);
				    sheetObjects[2].LoadSaveData(sXml);
				}
	            break;
			case IBINSERT:      //Inserting
			    if(validateForm(sheetObj,formObj,sAction)) {
				    var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row, "mnr_cd_grp_no","1",0);//GroupLevel: 1
					sheetObj.SetCellValue(Row, "mnr_cd_dp_seq",MnrGetViewRowCnt(sheetObj),0);//Display Sequence: 1
//					sheetObj.SetCellValue(Row, "pair_dp_seq","0",0);//Display Sequence: 0
					sheetObj.SetCellValue(Row, "delt_flg","N",0);//Delete Flag: N
					sheetObj.SetCellValue(Row, "mnr_cd_grp_tp_cd","OT",0);//General Code Type(CC:Cost Code, OT:Other Code)
					sheetObj.SetCellValue(Row, "mnr_cd_dp_desc"," ",0);//DpDesc
					//set Focus
					sheetObj.SelectCell(Row, "mnr_cd_id");
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
     * Sheet2 related process processing
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBINSERT:      //Inserting
				if(sheetClicks[0] == 0 || (sheetObjects[0].GetCellValue(sheetClicks[0],"mnr_cd_id") == '')){
					ComShowCodeMessage("MNR00143","Class Code");
				} else {
				    var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row, "mnr_cd_grp_no","2",0);//GroupLevel: 2
					sheetObj.SetCellValue(Row, "mnr_cd_dp_seq",MnrGetViewRowCnt(sheetObj),0);;  //Display Sequence
//					sheetObj.SetCellValue(Row, "pair_dp_seq","1",0);//PairDisplay Sequence: 1
					sheetObj.SetCellValue(Row, "delt_flg","N",0);//Delete Flag: N
					sheetObj.SetCellValue(Row, "mnr_cd_grp_tp_cd","OT",0);//General Code Type(CC:Cost Code, OT:Other Code)
					sheetObj.SetCellValue(Row, "mnr_cd_dp_desc"," ",0);//DpDesc
					//Enter the parent code
					sheetObj.SetCellValue(Row, "prnt_cd_id",sheetObjects[0].GetCellValue(sheetClicks[0], "mnr_cd_id"),0);
					//set Focus
					sheetObj.SelectCell(Row, "mnr_cd_id");
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
				if(sheetClicks[1] == 0 || (sheetObjects[1].GetCellValue(sheetClicks[1], "mnr_cd_id") == '')){
					ComShowCodeMessage("MNR00143","Class Code");
				} else {
				    var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row, "mnr_cd_grp_no","3",0);//GroupLevel: 3
					sheetObj.SetCellValue(Row, "mnr_cd_dp_seq",MnrGetViewRowCnt(sheetObj),0);//Display Sequence
//					sheetObj.SetCellValue(Row, "pair_dp_seq","2",0);//Pair Display Sequence: 2
					sheetObj.SetCellValue(Row, "delt_flg","N",0);//Delete Flag: N
					sheetObj.SetCellValue(Row, "mnr_cd_grp_tp_cd","OT",0);//General Code Type(CC:Cost Code, OT:Other Code)
					//Enter the parent code
					sheetObj.SetCellValue(Row, "prnt_cd_id",sheetObjects[1].GetCellValue(sheetClicks[1], "mnr_cd_id"),0);
					//set Focus
					sheetObj.SelectCell(Row, "mnr_cd_id");
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
			//At retrieving
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
					var Row=0;
					//First sheet
					if(i==0){
						Row=sheetObjects[i].ColValueDup("mnr_cd_id|mnr_cd_grp_no");
					//Other sheet
					} else {
						Row=sheetObjects[i].ColValueDup("mnr_cd_id|mnr_cd_grp_no|prnt_cd_id");
					}
					if(sheetObjects[i].IsDataModified()){
						if(Row>0){
							ComShowCodeMessage("MNR00006",i + 1 + "th sheet of " + Row + " row ");
							sheetObjects[i].SetCellValue(Row,"mnr_cd_id","",0);
							sheetObjects[i].SelectCell(Row, "mnr_cd_id", true);
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

    function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		ComOpenWait(false);
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00023",'');
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
	
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    	sheetObj.SetSelectRow(1);
    }

    function MnrAllSheetHidden(sheetObj){
		for (var idx=1; idx <= sheetObj.RowCount(); idx++){
			sheetObj.SetRowHidden(idx,1);
		}
	}

    function MnrSheetFiltering(sheetIdx,keyValue,foreginKey){
    	var formObj = document.form;
    	formObj.f_cmd.value=SEARCH02;
    	formObj.mnr_cd_grp_no.value = sheetIdx+1;
    	formObj.mnr_cd_id.value = keyValue;
    	
    	var sXml=sheetObjects[sheetIdx].GetSearchData("EES_MNR_0009GS.do", FormQueryString(formObj));
    	sheetObjects[sheetIdx].LoadSearchData(sXml);
    	
//		for (var idx=1; idx <= sheetObjects[sheetIdx].RowCount(); idx++){
//			if(sheetObjects[sheetIdx].GetCellValue(idx,foreginKey) == keyValue){
//				sheetObjects[sheetIdx].SetRowHidden(idx,0);
////				if(sheetObjects[sheetIdx].GetCellValue(idx, "mnr_cd_id") == "MRRUSP"){
////					sheetObjects[sheetIdx].SetCellEditable(idx, "agmt_use_flg", 0);
////				}else{
////					sheetObjects[sheetIdx].SetCellEditable(idx, "agmt_use_flg", 1);
////				}
//			} else {
//				sheetObjects[sheetIdx].SetRowHidden(idx,1);
//			}
//		}
	}
	/**
	 * @param keyValueType
	 * @return
	 */
	function setSheet2Column(keyValue) {
		var keyValueType=keyValue.substring(1);
		if(keyValueType == "G") {
			sheetObjects[1].SetColHidden("agmt_use_flg",0);
			sheetObjects[1].SetColHidden("mnr_ord_tp_cd",0);
			sheetObjects[2].SetColHidden("cost_shp_srch_patt_nm",0);
			sheetObjects[2].SetColHidden("agmt_val_flg",0);
			sheetObjects[2].SetColHidden("agmt_rt_flg",0);
			sheetObjects[1].SetColWidth("mnr_cd_desc",140);
			sheetObjects[1].SetColWidth("mnr_cd_dp_seq",35);
			setCostShpCombo(sheetObjects[1], keyValue);
			sheetObjects[2].SetColHidden("acct_cd",0);
		} else {
			sheetObjects[1].SetColHidden("agmt_use_flg",1);
			sheetObjects[1].SetColHidden("mnr_ord_tp_cd",1);
			sheetObjects[2].SetColHidden("cost_shp_srch_patt_nm",1);
			sheetObjects[2].SetColHidden("agmt_val_flg",1);
			sheetObjects[2].SetColHidden("agmt_rt_flg",1);
			sheetObjects[1].SetColWidth("mnr_cd_desc",205);
			sheetObjects[1].SetColWidth("mnr_cd_dp_seq",30);
			sheetObjects[2].SetColHidden("acct_cd",1);
		}
	}
/* ********* Event Functions ************* */
	/**
	 * SHEET1 click event
	 * @param	{IBSheet}	sheetObj	Clicked the sheet object
	 * @param	{Number}	Row			Clicked the sheet row
	 * @param	{String}	Col			Clicked the sheet column
	 */
	function sheet1_OnClick(sheetObj,Row,Col){
		sheetClicks[0]=Row;
		var keyValue=sheetObj.GetCellValue(Row,"mnr_cd_id");
		for(var i=1; i < sheetObjects.length; i++){
//			MnrAllSheetHidden(sheetObjects[i]);
//			sheetClicks[i]=0;
			sheetObjects[i].RemoveAll();
		}
			
		MnrSheetFiltering(1,keyValue,"prnt_cd_id");
		//Setting column display (AgmtFlg)
		setSheet2Column(keyValue);
		sheetObj.SelectCell(Row, Col, 1);
		
	}
	/**
	 * SHEET2 click event
	 * @param	{IBSheet}	sheetObj	Clicked the sheet object
	 * @param	{Number}	Row			Clicked the sheet row
	 * @param	{String}	Col			Clicked the sheet column
	 */
	function sheet2_OnClick(sheetObj,Row,Col){
		sheetClicks[1]=Row;
		
		var keyValue=sheetObj.GetCellValue(Row,"mnr_cd_id");
		for(var i=2; i < sheetObjects.length; i++){
//			MnrAllSheetHidden(sheetObjects[i]);
//			sheetClicks[i]=0;
			sheetObjects[i].RemoveAll();
		}
		MnrSheetFiltering(2,keyValue,"prnt_cd_id");
			
		if(sheetObj.GetCellValue(Row, "intg_flg")=="Y"){
			ComBtnDisable("btn_RowDel2");
			ComBtnDisable("btn_RowDel3");
			ComBtnDisable("btn_RowAdd3");
		}else{
			ComBtnEnable("btn_RowDel2");
			ComBtnEnable("btn_RowDel3");
			ComBtnEnable("btn_RowAdd3");
		}
			
		if(keyValue=='CD00003') {
			sheetObjects[2].SetColHidden("mnr_cd_dflt_pnt_no",0);
			sheetObjects[2].SetColWidth("mnr_cd_desc","100");
			sheetObjects[2].SetColWidth("mnr_cd_dp_desc","100");
		} else {
			sheetObjects[2].SetColHidden("mnr_cd_dflt_pnt_no",1);
			sheetObjects[2].SetColWidth("mnr_cd_desc","115");
			sheetObjects[2].SetColWidth("mnr_cd_dp_desc","115");
		}
		sheetObj.SelectCell(Row, Col, 1);
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
	 * Setting sheet combo
	 * @param	{IBSheet}	sheetObj
	 */
	function setSheetCombo(sheetObj) {
		var sCondition=new Array (
			new Array("MnrGenCd","CD00077", "COMMON")	//Order Type Code
		)
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboDefault="";
		var comboSaveNames=new Array();
		comboSaveNames[0]="mnr_ord_tp_cd";
		for(var i=0; i < comboList.length;i++){
		 	if(comboList[i] != null){
				sheetComboText="";
				sheetComboCode="";
				sheetComboDefault="";
		 		for(var j=0; j < comboList[i].length;j++){
					var tempText=comboList[i][j].split("|");
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
				}
		 		sheetComboText = MnrDelLastDelim(sheetComboText);
		 		sheetComboCode = MnrDelLastDelim(sheetComboCode);
				sheetObjects[1].InitDataCombo (0, "mnr_ord_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
			}
		}
	}
	
	/**
	 * Setting sheet combo
	 * @param	{IBSheet}	sheetObj
	 */
	function setCostShpCombo(sheetObj, eqType) {
		var sCondition=new Array (
			new Array("MnrGenCd",eqType, "CUSTOM10")	//Order Type Code
		)
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboDefault="";
		var comboSaveNames=new Array();
		comboSaveNames[0]="cost_shp_srch_patt_nm";
		for(var i=0; i < comboList.length;i++){
		 	if(comboList[i] != null){
				sheetComboText="";
				sheetComboCode="";
				sheetComboDefault="";
		 		for(var j=0; j < comboList[i].length;j++){
					var tempText=comboList[i][j].split("|");
					sheetComboText +=  "|" +tempText[1];
					sheetComboCode +=  "|" +tempText[0] ;
				}
//		 		sheetComboText = MnrDelLastDelim(sheetComboText);
//		 		sheetComboCode = MnrDelLastDelim(sheetComboCode);
				sheetObjects[2].SetColProperty (0, "cost_shp_srch_patt_nm", {ComboText:sheetComboCode, ComboCode:sheetComboCode});
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
	
	function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		for(var i=1; i <= sheetObj.RowCount(); i++){
			if(sheetObj.GetCellValue(i, "intg_flg")=="Y"){
				sheetObj.SetRowEditable(i, 0);
			}
		}
    }
	
	function sheet3_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		for(var i=1; i <= sheetObj.RowCount(); i++){
			if(sheetObj.GetCellValue(i, "intg_flg")=="Y"){
				sheetObj.SetRowEditable(i, 0);
			}
		}
    }
/* End of developer's task */
