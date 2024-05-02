/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0190.js
*@FileTitle  : Local Tariff File Import_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ees_mnr_0190 : ees_mnr_0190 - Defining a script used by screen
     */
/* Developer's task	*/
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var verifyCheck=false;
	var comboListGrid=new Array();
	var programId="";
	var opener = window.dialogArguments;
//	if(!opener) var opener = parent;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	var valFlg = "";
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
		        case "btn_new":
                    doActionIBSheet(sheetObject1, formObject, IBCLEAR);
                    break;
                case "btn_downExcel":
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
                    break;
                case "btn_loadExcel":
					doActionIBSheet(sheetObject1, formObject, IBLOADEXCEL);
                    break;
		        case "btn_ok":
					doActionIBSheet(sheetObject1, formObject, "doOK");
					break;
				case "btn_close":
					doActionIBSheet(sheetObject1, formObject, "doClose");
					break;
				//Verify
		        case "btn_Save":
                    doActionIBSheet(sheetObject1, formObject, IBSAVE);
                    break;
		        case "btn_RowAdd":
                    doActionIBSheet(sheetObject1, formObject, IBINSERT);
                    break;
		        case "btn_RowDel":
                    doActionIBSheet(sheetObject1, formObject, IBDELETE);
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
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
    	if (!opener) opener = parent;
    	//Setting button
    	MnrWaitControl(true);
		//set Opener Program Id
		programId=document.form.program_id.value;
		//set Title as Opener
		setTitle();
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+ 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//set SheetCombo
		setSheetCombo(sheetObjects[0]);
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
  	/**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     * @param	{IBSheet}	sheetObj	IBSheet object for initial setting
     * @param	{String}	sheetNo		Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
            case "sheet2":
                with(sheetObj){
			                
			              var HeadTitle1="|Sel|Del|Seq|Cost Group|Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Material|Component Group|Remark|Verify Result|Verify Code|Tariff No|DetailSeq";
			              var HeadTitle2="|Sel|Del|Seq|Cost Group|Component|Repair|Div|Description|Range Type|Type|QTY|SIZE|Min|Max|Man-Hour||Material|Component Group|Remark|Verify Result|Verify Code|Tariff No|DetailSeq";
			              
			
			              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );
			
			              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			              var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
			              InitHeaders(headers, info);
			              if(programId=="ees_mnr_0011") {
			              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"checkbox",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			                     {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_check",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                     {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"inp_msg17",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
			                     {Type:"ComboEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			                     {Type:"ComboEdit", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg6",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"inp_msg7",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 },
			                     {Type:"Combo",     Hidden:0, Width:75,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg10",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Combo",     Hidden:0, Width:65,   Align:"Left",    ColMerge:0,   SaveName:"inp_msg11",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Int",       Hidden:0,  Width:28,   Align:"Right",   ColMerge:0,   SaveName:"inp_msg12",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			                     {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"inp_msg13",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
			                     {Type:"Int",       Hidden:0,  Width:48,   Align:"Right",   ColMerge:0,   SaveName:"inp_msg8",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
			                     {Type:"Int",       Hidden:0,  Width:48,   Align:"Right",   ColMerge:0,   SaveName:"inp_msg9",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
			                     {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"inp_msg14",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inp_msg15",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			                     {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inp_msg19",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			                     {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"inp_msg23",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg16",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
			                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"inp_msg5",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];}
			                    else {
			                    	var cols = [];
			              cols.push({Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" });
			              cols.push({Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"checkbox",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			              cols.push({Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_check",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			              cols.push({Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" });
			              cols.push({Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"inp_msg17",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
			              cols.push({Type:"ComboEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 });
			              cols.push({Type:"ComboEdit", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 });
			              cols.push({Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg6",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 });
			              cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"inp_msg7",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 });
			              cols.push({Type:"Combo",     Hidden:0, Width:75,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg10",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			              cols.push({Type:"Combo",     Hidden:0, Width:65,   Align:"Left",    ColMerge:0,   SaveName:"inp_msg11",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			              cols.push({Type:"Int",       Hidden:0,  Width:28,   Align:"Right",   ColMerge:0,   SaveName:"inp_msg12",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
			              cols.push({Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"inp_msg13",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 });
			              cols.push({Type:"Int",       Hidden:0,  Width:48,   Align:"Right",   ColMerge:0,   SaveName:"inp_msg8",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
			              cols.push({Type:"Int",       Hidden:0,  Width:48,   Align:"Right",   ColMerge:0,   SaveName:"inp_msg9",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
			              cols.push({Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"inp_msg14",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
			              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inp_msg15",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 });
			              cols.push({Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inp_msg19",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 });
			              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"inp_msg23",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			              cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg16",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 });
			              cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"inp_msg5",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			              }
			              cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg4",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			              cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg18",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			              cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"inp_msg20",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			              cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg21",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			              cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg22",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			              cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg24",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			              cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg25",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			              cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg26",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			              cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg27",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			              cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"div_flag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			         
			              InitColumns(cols);
			
			              SetEditable(1);
			              SetEditableColorDiff(0);
			              SetCountPosition(0);
			              SetColProperty(0 ,"inp_msg1" , {AcceptKeys:"E" , InputCaseSensitive:1});	
			              SetColProperty(0 ,"inp_msg2" , {AcceptKeys:"E" , InputCaseSensitive:1});

			              //no support[check again]CLT 					MultiSelection=true;
			              SetSelectionMode(smSelectionRow);
			              //no support[implemented common]CLT 					SelectHighLight=false;
			              InitComboNoMatchText(true);
             
			              if(sheetObj.id=="sheet1") {
				              SetSheetHeight(350);
				              } else {
				              SetVisible(false);
				              }
			              SetRangeBackColor(1,0,1,14,"#555555");
            }

                break;

			default:
				break;
        }
    }
	/**
	 * Assigning array of IBSheet object
     * Array defined at the top of the source
	 * @param    {IBSheet}	sheet_obj        Registered as an array IBSheet Object
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
	 * Event handling of OnChange of sheet1
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
			//Component Code
			if(colname=='inp_msg1'){
				sheetObj.SetCellValue(Row,Col,Value.toUpperCase());
				checkIsComboValue(sheetObj,Row,Col,Value.toUpperCase(),0);	//Checking value
				if(valFlg == "Y"){
					setDescripton(sheetObj,Row);					//Setting description name
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
				}
				
			}
			//Repair Code
			else if(colname=='inp_msg2'){
				sheetObj.SetCellValue(Row,Col,Value.toUpperCase());
				checkIsComboValue(sheetObj,Row,Col,Value.toUpperCase(),1);  	//Checking value
				if(valFlg == "Y"){
					setDescripton(sheetObj,Row);					//Setting description name
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
				}
			}
			//Div Code
			else if(colname=='inp_msg6'){
				setDescripton(sheetObj,Row);					//Setting description name
			}
			//Range Type
			else if(colname=='inp_msg10'){
				checkRangeType(sheetObj,Row,Value);				//Checking range
			}
			//Volume Type Code
			else if(colname=='inp_msg11'){
				setEditableByVolumeType(sheetObj,Row);  		//Setting editalbe
			}
		}
	}
	/**
	 * Event handling of OnBeforeCheck of sheet1
	 * Sel checkBox:Edit  -> false
	 * All Column  :Edit  -> true
	 * Volume Type :Edit  -> setEditableByVolumeType()
	 * Verfy Column:Value -> null
	 * BackColor          -> Edit
	 * @param	{IBSheet}		sheetObj		sheet object
	 * @param 	{String} 			Row 		Row
	 * @param 	{String} 			Col 		Col
	 */
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){
		if(sheetObj.ColSaveName(Col) == 'checkbox') {
			if(sheetObj.GetCellValue(Row,Col) == 1){
				//set Verify Columns Value null
				sheetObj.SetCellValue(Row,"inp_msg4","");
				sheetObj.SetCellValue(Row,"inp_msg5","");
				//set All Columns Edit true without Sel-checkbox(false)
				sheetObj.SetCellEditable(Row, "checkbox",0);
				sheetObj.SetCellEditable(Row, "inp_msg17",1);
				sheetObj.SetCellEditable(Row, "inp_msg1",1);
				sheetObj.SetCellEditable(Row, "inp_msg2",1);
				sheetObj.SetCellEditable(Row, "inp_msg6",1);
				sheetObj.SetCellEditable(Row, "inp_msg7",1);
				sheetObj.SetCellEditable(Row, "inp_msg8",1);
				sheetObj.SetCellEditable(Row, "inp_msg9",1);
				sheetObj.SetCellEditable(Row, "inp_msg10",1);
				sheetObj.SetCellEditable(Row, "inp_msg11",1);
				sheetObj.SetCellEditable(Row, "inp_msg12",1);
				sheetObj.SetCellEditable(Row, "inp_msg13",1);
				sheetObj.SetCellEditable(Row, "inp_msg14",1);
				sheetObj.SetCellEditable(Row, "inp_msg15",1);
				sheetObj.SetCellEditable(Row, "inp_msg16",1);
				//set Edit by VolumeType
				setEditableByVolumeType(sheetObj,Row);
				//set BackColor
				sheetObj.SetRowBackColor(Row,"#FFFFFF");
			}
		}
	}
	/**
	 * Event handling of OnMouseDown of sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Button		Lett:1, Right:2
	 * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
	 * @param	{Long}		X			Value
	 * @param	{Long}		Y			Value
	 */
    function sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
		var Row=sheetObj.MouseRow();
		var Col=sheetObj.MouseCol();
		var ColSaveName=sheetObj.ColSaveName(Col);
		if(ColSaveName=="inp_msg6") { //Div Code
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			var successFlag=sheetObj.GetCellValue(Row, "inp_msg4");
			if(divFlag=="1"||successFlag=="SS") {return}
				setDivCombo(sheetObj,Row);
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
			//Initializing
			case IBCLEAR:
				//Setting for button and progress bar
				//sheetObj.WaitImageVisible = false;
				MnrWaitControl(true);
		    	sheetObj.RemoveAll();
				//Setting for button and progress bar
				MnrWaitControl(false);
				//Resetting format of sheet along calling parent screen
				setSheetFormatByOpener();
				//sheetObj.WaitImageVisible = true;
				break;
			//Load Excel
			case IBLOADEXCEL:
				//Local Tariff(Opener : ees_mnr_0011)
				if(programId=="ees_mnr_0011") {
 					var rtnLoad = sheetObjects[0].LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"1",EndRow:"0",WorkSheetName:"",Append:false,ColumnMapping:""});
					if(!rtnLoad) {return;}  //Cancel
				//Standard Tariff(Opener : ees_mnr_0014)
				} else {
 					var rtnLoad = sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"1",EndRow:"0",WorkSheetName:"",Append:false,ColumnMapping:""});
 					if(!rtnLoad) {return;}  //Cancel
 					
				}
				break;
			case IBDOWNEXCEL:
				//Local Tariff(Opener : ees_mnr_0011)
				if(programId=="ees_mnr_0011") {
					ComShowCodeMessage("MNR00288");
					for(var i = sheetObj.HeaderRows() ; i <= sheetObj.LastRow();i++ ){
						sheetObj.SetCellBackColor(i, "inp_msg19", "#FBFBBB");
					}
					sheetObj.Down2Excel({ HiddenColumn:false, DownCols:"3|4|5|6|7|8|9|10|11|12|13|14|15|17|18", SheetDesign:1 });
					for(var i = sheetObj.HeaderRows() ; i <= sheetObj.LastRow();i++ ){
						sheetObj.SetCellBackColor(i, "inp_msg19", "#FFFFFF");
					}
				//Standard Tariff(Opener : ees_mnr_0014)
				} else {
					var Row=sheetObj.DataInsert(-1);
 					sheetObj.Down2Excel({ HiddenColumn:1, Merge:1, SheetDesign:1, DownCols:"3|4|5|6|7|8|9|10|11|12|13|14|15|19"});
					sheetObj.SetCellValue(Row, "del_check","1");
					ComRowHideDelete(sheetObj, "del_check");
				}
			    break;
			//OK
			case "doOK":
				if(validateForm(sheetObj,formObj,sAction)) {
					comPopupOK_190(sheetObj);
				}
				break;
			//Close
			case "doClose":
				ComClosePopup(); 
				break;
			//Verify
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=MULTI;
					var sParam=sheetObj.GetSaveString(true, true);
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
 					var sXml=sheetObj.GetSaveData("EES_MNR_0190GS.do", sParam);
 				    sheetObj.LoadSaveData(sXml);
					verifyCheck=true;
					ComOpenWait(true,true);
					setNoMatchCombo(sheetObj); //Setting no match combo
					ComOpenWait(false,true);
				}
				break;
			//Adding row
			case IBINSERT:
				var Row=sheetObj.DataInsert(-1);
				//set Value init
				sheetObj.SetCellValue(Row, "inp_msg1","",0);//Component
				sheetObj.SetCellValue(Row, "inp_msg2","",0);//Repair
				sheetObj.SetCellValue(Row, "inp_msg6","",0);//Div
				sheetObj.SetCellValue(Row, "inp_msg23","",0);//Component 2nd
				//set Edit by Volume Type
				setEditableByVolumeType(sheetObj,Row);
				//set CheckBox(Sel) Edit(false)
				sheetObj.SetCellEditable(Row,"checkbox",0);
				//set Focus
				sheetObj.SelectCell(Row, "inp_msg17");
				break;
			//Deleting row
			case IBDELETE:
			    if(validateForm(sheetObj,formObj,sAction)) {
					//ComRowHideDelete(sheetObj, "del_check");
			    	MnrRowDelete(sheetObj, "del_check");
				}
				break;
			default:
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
			//In case of click of verify button
			if(sAction==IBSAVE) {
				//Checking duplicate
				var Row=sheetObj.ColValueDup("inp_msg1|inp_msg2|inp_msg6|inp_msg8|inp_msg9|inp_msg10|inp_msg11|inp_msg12|inp_msg17", false);
				if(Row>0){
					ComShowCodeMessage("MNR00006",sheetObj.GetCellValue(Row, "seq") + " row ");
					sheetObj.SelectCell(Row, "inp_msg1", true);
					return false;
				}
			}
			//In case of click of ok button
			else if(sAction=="doOK"){
				if(!verifyCheck){
					ComShowCodeMessage("MNR00157");
					return false;
				}
			    if(sheetObj.FindCheckedRow("checkbox") == ""){
					ComShowCodeMessage("MNR00038","SELECT ");
					return false;
				}
				for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
					var selCheck=sheetObj.GetCellValue(i, "checkbox");
					if(selCheck=="0") {
						ComShowCodeMessage("MNR00301");
						sheetObj.SelectCell(i, "checkbox");
						return false;
					}
				}
			}
			//In case of click of delete button
			else if(sAction==IBDELETE) {
				if(sheetObj.FindCheckedRow("del_check") == ""){
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;
				}
			}
		}
        return true;
    }
    
    function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
//    	if(result) {
    		if(programId!="ees_mnr_0011"){
	    		for(var i=sheetObjects[0].HeaderRows(); i<=sheetObj.LastRow(); i++){
					//Setting status editable of selected column
	    			sheetObjects[0].SetCellEditable(i,"checkbox",0);
					//Setting volume edit
					setEditableByVolumeType(sheetObjects[0],i);
				}
				//Setting no match combo
				setNoMatchCombo(sheetObjects[0]);
    		}
//    	} else {
//    		ComShowCodeMessage("MNR00001");
//    	}
    }

/* ********* User Functions ************* */
  	/**
     * @param	{IBSheet}	sheetObj	sheet object
     */
	function comPopupOK_190(sheetObj) {
		ComOpenWait(true,true);
		var frm=opener.document.form;
		var sPopUpColNm="ibflag|inp_msg1|inp_msg2|inp_msg6|inp_msg7|inp_msg8|inp_msg9|inp_msg10|inp_msg10|inp_msg11|inp_msg11|inp_msg12|inp_msg13|inp_msg14|inp_msg15|inp_msg16|inp_msg17|inp_msg18|inp_msg19|inp_msg20|inp_msg21|inp_msg22|inp_msg23|inp_msg24|inp_msg25|inp_msg26|inp_msg27";
		var sOpenerColNm="ibflag|eq_cmpo_cd|eq_rpr_cd|trf_div_cd|dtl_desc|fm_rng_sz_no|to_rng_sz_no|mnr_rng_tp_cd_view|mnr_rng_tp_cd|vol_tp_cd_view|vol_tp_cd|rpr_qty|rpr_sz_no|rpr_lbr_hrs|mtrl_reco_amt|dtl_rmk|cost_grp_cd|trf_no|mtrl_cost_amt|trf_dtl_seq|inch_size|cm_size|eq_cmpo_up_cd|inch_fm|cm_fm|inch_to|cm_to";
		var eqTypeCd=document.form.eq_knd_cd.value;
		var sDivider="";
		if(eqTypeCd=="U") {
			sDivider="MRDR|MRRF|MRRU|MRDS";
		} else if (eqTypeCd=="Z"){
			sDivider="MRZS";
		} else if (eqTypeCd=="G"){
			sDivider="MRGS";
		}
		sheetObj.RenderSheet(0);
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			sheetObj.SetCellValue(i,"inp_msg18",frm.trf_no.value,0);
			if(programId=="ees_mnr_0011") {
				sheetObj.SetCellValue(i,"inp_msg20",i - 1,0);
			}else{
				sheetObj.SetCellValue(i,"ibflag","I",0);
			}
		}
		sheetObj.RenderSheet(1);
 		var sXml=MnrMakeSearchXmls(sheetObj, "checkbox", sPopUpColNm, sOpenerColNm, "inp_msg17", sDivider);
		
		opener.setEES_MNR_190(sXml);
//		frm.sheetObjects[0].LoadSearchData(sXml[0],{Sync:1} );
//		frm.sheetObjects[1].LoadSearchData(sXml[1],{Sync:1} );
//		frm.sheetObjects[2].LoadSearchData(sXml[2],{Sync:1} );
//		frm.sheetObjects[3].LoadSearchData(sXml[3],{Sync:1} );
		ComOpenWait(false,true);
		ComClosePopup(); 
	}
	/**
	 * Checking inputted data of combo of sheet
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	Combo sequence
	 */
	function checkIsComboValue(sheetObj,Row,Col,Value,comboSeq){
 		for(var j=0; j < comboListGrid[comboSeq].length;j++){
			var tempText=comboListGrid[comboSeq][j].split("|");
			if(tempText[0]==Value) {
				valFlg = "Y";
				return ;
			}
		}
		ComShowCodeMessage("MNR00165",Value);
		sheetObj.SetCellValue(Row,Col,"",0);
		sheetObj.SelectCell(Row,Col, 1);
		valFlg = "";
	}
	/**
	 * Setting description
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 */
	function setDescripton(sheetObj,Row) {
		var componentCode=sheetObj.GetCellValue(Row,"inp_msg1");
		var componentDesc=getDescription(componentCode,0);
		var repairCode=sheetObj.GetCellValue(Row,"inp_msg2");
		var repairDesc=getDescription(repairCode,1);
		var divCode=sheetObj.GetCellValue(Row,"inp_msg6");
		var divDesc="";
		sheetObj.SetCellValue(Row, "inp_msg7","["+componentCode+"]"+componentDesc +" - ["+repairCode+"]"+ repairDesc+" - ["+divCode+"]",0);
	}
	/**
	 * Returning combo code
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	Combo sequence
	 * @return  {String}    tempDesc    CodeName
	 */
	function getDescription(Value,comboSeq){
		var tempDesc="";
 		for(var j=0; j < comboListGrid[comboSeq].length;j++){
			var tempText=comboListGrid[comboSeq][j].split("|");
			if(tempText[0]==Value) {
				tempDesc=tempText[1];
				return tempDesc;
			}
		}
		return tempDesc;
	}
	/**
	 * Checking range type
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	Combo sequence
	 */
	function checkRangeType(sheetObj,Row,Value) {
		if(Value!='F') {
			var rowEqCmpoCd=sheetObj.GetCellValue(Row,"inp_msg1");	//Component
			var rowEqRprCd=sheetObj.GetCellValue(Row,"inp_msg2");	//Repair
			var rowTrfDivCd=sheetObj.GetCellValue(Row,"inp_msg6");	//Option Div
			var rowFmRngSzNo=sheetObj.GetCellValue(Row,"inp_msg8");	//Size Section Fm
			var rowToRngSzNo=sheetObj.GetCellValue(Row,"inp_msg9");	//Size Section To
			var rowCostGrpCd=sheetObj.GetCellValue(Row,"inp_msg17");	//Cost Group Code
			var rowSpec=rowEqCmpoCd + rowEqRprCd + rowTrfDivCd + rowFmRngSzNo + rowToRngSzNo + rowCostGrpCd;
			for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
				if(Row!=i){
					var iEqCmpoCd=sheetObj.GetCellValue(i,"inp_msg1");		//Component
					var iEqRprCd=sheetObj.GetCellValue(i,"inp_msg2");		//Repair
					var iTrfDivCd=sheetObj.GetCellValue(i,"inp_msg6");		//Option Div
					var iFmRngSzNo=sheetObj.GetCellValue(i,"inp_msg8");		//Size Section Fm
					var iToRngSzNo=sheetObj.GetCellValue(i,"inp_msg9");		//Size Section To
					var iCostGrpCd=sheetObj.GetCellValue(i,"inp_msg17");	//Cost Group Code
					var iSpec=iEqCmpoCd + iEqRprCd + iTrfDivCd + iFmRngSzNo + iToRngSzNo +iCostGrpCd;
					if(rowSpec==iSpec) {
						var iMnrRngTpCd=sheetObj.GetCellValue(i,"inp_msg10");
						if(iMnrRngTpCd=='F') {
							return;
						}
					}
				}
			}
			ComShowCodeMessage("MNR00176");
			sheetObj.SetCellValue(Row,"inp_msg10","F",0);
			sheetObj.SelectCell(Row, "inp_msg10");
		}
	}
	/**
	 * Volume Type:Q -> Size/Square=0, 		Volume Type:S -> Q'ty=0
	 * Volume Type:Q -> Q'ty=Edit,			Volume Type:S -> Size/Square=Edit
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Val			Value
	 */
    function setEditableByVolumeType(sheetObj,Row){
var volTpCd=sheetObj.GetCellValue(Row, "inp_msg11");	//Volume Type
		//Q'ty
		if(volTpCd=='Q'){
			sheetObj.SetCellValue(Row, "inp_msg13","",0);//Size
			sheetObj.SetCellEditable(Row, "inp_msg13",0);//Size
			sheetObj.SetCellEditable(Row, "inp_msg12",1);//Qty
			sheetObj.ReturnCellData(Row, "inp_msg12");			//Qty
		//Size/Square
		} else {
			sheetObj.SetCellValue(Row, "inp_msg12","",0);//Qty
			sheetObj.SetCellEditable(Row, "inp_msg12",0);//Qty
			sheetObj.SetCellEditable(Row, "inp_msg13",1);//Size
			sheetObj.ReturnCellData(Row, "inp_msg13");			//Size
		}
	}
    /**
     * Resetting format of sheet along calling parent screen
     *
     *   In case of ees_mnr_0011(Local Tariff)
     *   : Button disable   - verify, RowAdd, RowDel
     *     Hiding column    - VerifyResult column
     *     Getting data     - ees_mnr_0011' screen
     *     Resetting status of modifiable column   - Excluding Remark, Material column
     *
     *   In case of ees_mnr_0014(Standard Tariff)
     *   : Button Disalbe   - Templete Down Excel
     *   : Hiding column    - Material, Tariff No, DetailSeq
     */
	function setSheetFormatByOpener() {
		//Opener programdId : ees_mnr_0011
		if(programId=="ees_mnr_0011") {
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_RowDel");
			sheetObjects[0].SetColHidden("inp_msg18",1);//Tariff No
			sheetObjects[0].SetColHidden("inp_msg19",0);//Material
			//get Opener(ees_mnr_0011) Data
			//-----------------------------
			getOpenerData();
			//-----------------------------
		//Opener programdId : ees_mnr_0014
		} else {
			//hidden Column
			sheetObjects[0].SetColHidden("inp_msg19",1);//Material
			sheetObjects[0].SetColHidden("inp_msg20",1);//detail_seq
		}
	}
	/**
	 * Getting opener data
	 */
	function getOpenerData() {
		//get Opener Sheets
		var frm=opener;
		var thisObjects=new Array();
		if(programId=="ees_mnr_0011"){
			thisObjects[0]=frm.sheetObjects[1];
			thisObjects[1]=frm.sheetObjects[2];
			thisObjects[2]=frm.sheetObjects[3];
			thisObjects[3]=frm.sheetObjects[4];
		}else{
			thisObjects[0]=frm.sheetObjects[0];
			thisObjects[1]=frm.sheetObjects[1];
			thisObjects[2]=frm.sheetObjects[2];
			thisObjects[3]=frm.sheetObjects[3];
		}	
		var eqTypeCd=document.form.eq_knd_cd.value; //EQ Type
		//Container
		if(eqTypeCd=="U") {
			var cnt=0;
			var openerSheetObjects=new Array();
			for (var i=0; i<thisObjects.length; i++) {
				//Only get Sheets with RowCount>0
				if(thisObjects[i].RowCount()>0) {
					openerSheetObjects[cnt++]=thisObjects[i]
				}
			}
		//Chassis,MGSet
		} else {
//			var openerSheetObjects=new Array(frm.t1sheet1);
			var openerSheetObjects=new Array(thisObjects[0]);
		}
		var sTime1=new Date();
		//get Opener Data by MnrMakeSearchXml()
		var saveName="ibflag|seq|inp_msg17|inp_msg1|inp_msg2|inp_msg6|inp_msg7|inp_msg10|inp_msg11|inp_msg12|inp_msg13|inp_msg8|inp_msg9|inp_msg14|inp_msg15|inp_msg19|inp_msg23|inp_msg16|inp_msg18|inp_msg20|inp_msg21|inp_msg22|inp_msg24|inp_msg25|inp_msg26|inp_msg27";
		//---------------------------------------------------------------
 		var sXml=MnrMakeSearchXml(openerSheetObjects, saveName, false);
		//---------------------------------------------------------------
		sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
	}
	/**
	 * Changing title along parent screen
	 *
	 * 	In case of called ees_mnr_0011 - Local Tariff
	 *  In case of called ees_mnr_0014 - Standard Tariff
	 */
	function setTitle() {
	    if(programId=="ees_mnr_0011") {
			document.title="Local Tariff File Import_Pop Up";
			document.getElementById("title1").innerHTML="Local Tariff File Import";
			document.getElementById("title2").innerHTML="Local Tariff File Format";
			document.getElementById("materialName").style.display="block";
			document.getElementById("materialValue").style.display="block";
		} else {
			document.title="Standard Tariff File Import_Pop Up";
			document.getElementById("title1").innerHTML="Standard Tariff File Import";
			document.getElementById("title2").innerHTML="Standard Tariff File Format";
			document.getElementById("materialName").style.display="none";
			document.getElementById("materialValue").style.display="none";
		}
	}
	/**
	 * Sheet combo data retrieving and setting
	 * @param	{IBSheet}	sheetObj	sheet object
	 */
	function setSheetCombo(sheetObj){
		//Retrieving data of combo of sheet
		var eqTypeCd=document.form.eq_knd_cd.value;
		var sCondition=new Array (
			new Array("MnrEqCmpoCd","3","COMMON"), 			//Component
			new Array("MnrCedexOthCd","RPR","COMMON"), 		//Repair
			new Array("MnrGenCd","CD00012", "COMMON"),		//RangeType
			new Array("MnrGenCd","CD00013", "COMMON"),		//Type
			new Array("MnrGenCd","CC"+eqTypeCd, "CUSTOM2")  //CostGroup
		)
		comboListGrid=MnrComSearchCombo(sheetObj,sCondition);
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboCodeText="";
		var sheetComboTextCode="";
		var sheetComboDefault="";
		//combo of sheet SAVE_NAME
		var comboSaveNames=new Array();
		comboSaveNames[0]="inp_msg1";		//Component
		comboSaveNames[1]="inp_msg2";		//Repair
		comboSaveNames[2]="inp_msg10";	//RangeType
		comboSaveNames[3]="inp_msg11";	//Type
		comboSaveNames[4]="inp_msg17";	//CostGroup
		for(var i=0; i < comboListGrid.length;i++){
		 	if(comboListGrid[i] != null){
				//Initializing each combo of sheets
				sheetComboText="";
				sheetComboCode="";
				sheetComboCodeText="";
				sheetComboTextCode="";
				sheetComboDefault="";
		 		for(var j=0; j < comboListGrid[i].length;j++){
					var tempText=comboListGrid[i][j].split("|");
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					sheetComboTextCode +=  tempText[1] + "\t" + tempText[0] + "|";
					if(j ==0){
						sheetComboDefault=tempText[0];
					}
				}
				//Sheet Setting combo
				//[NAME][CODE]:CostGroup,RangeType,Type
				if(i==4 || i==2 ||i==3 ) {
					sheetObj.InitDataCombo (0, comboSaveNames[i], sheetComboTextCode, sheetComboCode, sheetComboDefault);
				}
				//[CODE][NAME]:,Component,Repair
				else if(i==0 || i==1) {
					sheetObj.InitDataCombo (0, comboSaveNames[i], sheetComboCodeText, sheetComboCode, sheetComboDefault);
				}
			}
		}
		if (sheetComboText != "") {
	        sheetComboText=sheetComboText.substr(0, sheetComboText.length - 1);
		}
		if (sheetComboCode != "") {
	        sheetComboCode=sheetComboCode.substr(0, sheetComboCode.length - 1);
		}
	}
	/**
	 * Setting combo of Div sheet
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 */
	function setDivCombo(sheetObj,Row) {
		var eqCmpoCd=sheetObj.GetCellValue(Row, "inp_msg1");
		var eqRprCd=sheetObj.GetCellValue(Row, "inp_msg2");
		var divCd=sheetObj.GetCellValue(Row, "inp_msg6");
		var costGrpCd=sheetObj.GetCellValue(Row, "inp_msg17");
		var prefixCostGrpCd=costGrpCd.substring(0,3);
		if(eqCmpoCd != "" && eqRprCd != "") {
			var compRprJoinStr=ComTrimAll(eqCmpoCd) + ComTrimAll(eqRprCd);
			var sCondition=new Array (
			 	new Array("MnrDivCd",compRprJoinStr +','+ prefixCostGrpCd, "COMMON1")
			)
			var comboList=MnrComSearchCombo(sheetObj,sCondition);
			var lbComboText="";
			var lbComboCode="";
			var sheetComboCodeText="";
			var selectComboCodeText="";
			
			//TS type combo
			if(comboList[0] != null){
				for(var j=0; j < comboList[0].length;j++){
					var tempText=comboList[0][j].split("|");
					lbComboText +=  tempText[1] + "|";
					lbComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(j == 1){
						selectComboCodeText = tempText[0];
					}
				}
			}
			lbComboCode=MnrDelLastDelim(lbComboCode);
			lbComboText=MnrDelLastDelim(lbComboText);
			sheetComboCodeText=MnrDelLastDelim(sheetComboCodeText);
			
			var origin_trf_div_cd = sheetObj.GetCellValue(Row, "inp_msg6");
			var info = {"ComboCode":lbComboCode, "ComboText":sheetComboCodeText};
			var info1 = {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg6",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 };

			sheetObj.InitCellProperty(Row, "inp_msg6", info1);
			sheetObj.SetCellValue(Row, "inp_msg6", origin_trf_div_cd);
			sheetObj.SetCellText(Row, "inp_msg6", origin_trf_div_cd);
			sheetObj.CellComboItem (Row, "inp_msg6", info); 
			
			
			sheetObj.SetCellValue(Row,"inp_msg6",origin_trf_div_cd);

		//	sheetObj.InitDataCombo (0, "inp_msg6",sheetComboCodeText , lbComboCode, "");
			
			sheetObj.SetCellValue(Row, "div_flag","1");
		}
	}
	/**
	 * Setting no match combo
	 * @param	{IBSheet}	sheetObj	sheet object
	 */
	function setNoMatchCombo(sheetObj) {
		sheetObj.RenderSheet(0);
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			//Setting no match combo
			var eqCmpoCd=sheetObj.GetCellValue(i, "inp_msg1");
			var eqRprCd=sheetObj.GetCellValue(i, "inp_msg2");
			var divCd=sheetObj.GetCellValue(i, "inp_msg6");
			if(eqCmpoCd=="") {
				eqCmpoCd=sheetObj.GetCellText(i,"inp_msg1");
				sheetObj.SetCellValue(i,"inp_msg1",eqCmpoCd,0);
			}
			if(eqRprCd=="") {
				eqRprCd=sheetObj.GetCellText(i,"inp_msg2");
				sheetObj.SetCellValue(i,"inp_msg2",eqRprCd,0);
			}
			if(divCd=="") {
				divCd=sheetObj.GetCellText(i,"inp_msg6");
				sheetObj.SetCellValue(i,"inp_msg6",divCd,0);
			}
		}
		sheetObj.RenderSheet(1);
	}
