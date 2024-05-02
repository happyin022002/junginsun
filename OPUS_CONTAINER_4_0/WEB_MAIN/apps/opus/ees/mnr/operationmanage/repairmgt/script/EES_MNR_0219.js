/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0219.js
*@FileTitle  : M&R Simple WO File Import Pop_Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
	//common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;  
	var verifyCheck=false;      
	var retComboVal="";  
	var opener;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
	//	var sheetObject2 = sheetObjects[1];
	//	var sheetObject3 = sheetObjects[2];
	//	var sheetObject4 = sheetObjects[3];
	//	var sheetObject5 = sheetObjects[4];
	//	var sheetObject6 = sheetObjects[5];
	//	var sheetObject7 = sheetObjects[6];
	//	var sheetObject8 = sheetObjects[7];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_FileImport": 
//				sheetObject.LoadExcel({ Mode:"NoHeader",WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:"",Append:false,ColumnMapping:"1=>4|2=>5|3=>6"});
				sheetObject.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"1",EndRow:"0",WorkSheetName:"",Append:false,ColumnMapping:"||||1|2|3"});
				                  
				break;     
			case "btn_new":
				doActionIBSheet(sheetObjects[0],formObject,IBCLEAR)
				break;
			case "btn_ok":
				if(sheetObject.FindCheckedRow("checkbox") == ""){
					ComShowCodeMessage("MNR00038","SELECT ");             	   
				} else if(!verifyCheck){  
					ComShowCodeMessage("MNR00157");          		 	  
				} else {     
					comPopupOK_219(sheetObject,formObject); 	
				}                                   
				break; 
			case "btn_Save":    
				doActionIBSheet(sheetObject, formObject, IBSAVE); 
				break;        
			case "btn_RowAdd":                  
				doActionIBSheet(sheetObject, formObject, IBINSERT);        
				break; 
			case "btn_RowDel":                     
				doActionIBSheet(sheetObject, formObject, IBDELETE);        
				break;        
			case "btn_close":    
				ComClosePopup(); 
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
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject. 
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj){     
		comboObjects[comboCnt++]=combo_obj;  
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
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * setting return value to parent form.
	 */
	function comPopupOK_219(sheetObj,formObject) {
		var formObject=document.form; 
		if(combo_cost_dtl_cd.GetSelectIndex()== "-1"){
			ComShowCodeMessage("MNR00036","Cost Detail Code");    
			ComSetFocus(combo_cost_dtl_cd);     
			return false;
		}
		var rArray=new Array(); //list containing row data
		var ret_val=new Array(); 
		ret_val[0]=combo_cost_dtl_cd.GetSelectCode();
	//	ret_val[1] =  ComGetObjValue(formObject.dmg_flag); 
		var sRow=sheetObj.FindCheckedRow("checkbox");
		//setting row as list.          
		var arrRow=sRow.split("|");   
		for (idx=0; idx < arrRow.length; idx++){     
			var cArray=new Array(); // list containing col data
			cArray[0]=sheetObj.GetCellValue(arrRow[idx], "inp_msg1");
			cArray[1]=sheetObj.GetCellValue(arrRow[idx], "inp_msg2");
			cArray[2]=sheetObj.GetCellValue(arrRow[idx], "inp_msg3");
			cArray[3]=sheetObj.GetCellValue(arrRow[idx], "inp_msg6");
			cArray[4]=sheetObj.GetCellValue(arrRow[idx], "inp_msg7");
			cArray[5]=sheetObj.GetCellValue(arrRow[idx], "inp_msg8");
			rArray[idx]=cArray;                           
		}                   
		opener.setPopUpParam_EES_MNR_0219(rArray,ret_val);   
		ComClosePopup(); 
	}   
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		var formObject=document.form;
		opener = window.dialogArguments;
		if (!opener)
			opener = parent;
		if(opener != undefined)
		{
			//hidden Text Setting
			if(opener.document.form.mnr_grp_tp_cd!=undefined)
			{
				formObject.mnr_grp_tp_cd.value=opener.document.form.mnr_grp_tp_cd.value;
			}
			if(opener.document.form.mnr_wo_tp_cd!=undefined)
			{
				formObject.mnr_wo_tp_cd.value=opener.document.form.mnr_wo_tp_cd.value;
			}
			if(opener.document.form.agmt_ofc_cty_cd!=undefined)
			{
				formObject.agmt_ofc_cty_cd.value=opener.document.form.agmt_ofc_cty_cd.value;
			}
			if(opener.document.form.agmt_seq!=undefined)
			{
				formObject.agmt_seq.value=opener.document.form.agmt_seq.value;
			}
			if(opener.document.form.agmt_ver_no!=undefined)
			{
				formObject.agmt_ver_no.value=opener.document.form.agmt_ver_no.value;
			}     
			if(opener.document.form.cost_ofc_cd!=undefined)
			{
				formObject.cost_ofc_cd.value=opener.document.form.cost_ofc_cd.value;
			}
			//Text Setting        	
			if(typeof(opener.combo_eq_knd_cd)!="undefined")
			{
				formObject.eq_knd_cd_text.value=opener.combo_eq_knd_cd.GetSelectText();
				formObject.eq_knd_cd.value=opener.combo_eq_knd_cd.GetSelectCode();
				formObject.eq_type.value=opener.combo_eq_knd_cd.GetSelectCode();
			}
			if(typeof(opener.form.combo_cost_cd)!="undefined")
			{
				formObject.cost_cd_text.value=opener.combo_cost_cd.GetSelectText();
				formObject.cost_cd.value=opener.combo_cost_cd.GetSelectCode();
			}
			if(typeof(opener.combo_vndr_seq)!="undefined")
			{
				formObject.vndr_seq.value=opener.combo_vndr_seq.GetSelectCode();
			}
		}
		MnrWaitControl(true); 
		for(i=0;i<sheetObjects.length;i++){
			//
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			//
			ComEndConfigSheet(sheetObjects[i]);
			//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k + 1);
		}   
		doActionIBSheet(sheetObj,document.form,IBCLEAR);
	}
	function initCombo() {
		var formObject=document.form
		with (combo_cost_dtl_cd) {
			SetMultiSeparator("|");
			//	SetTitle("Code|Name");
			//MultiSelect = false;
			SetColAlign(0, "left");
			SetColWidth(0, "180");
			SetDropHeight(160);
		}
		if(opener!=undefined)
		{
			if(opener.combo_cost_cd!=undefined)
			{
				var costtype=opener.combo_cost_cd.GetSelectCode();
				var formObj=document.form;
				combo_cost_dtl_cd.RemoveAll();
				//retrieving Combo
				var sheetObj=sheetObjects[0];
				var sCondition=new Array (
						new Array("MnrGenCd",costtype, "COMMON") //Extra Expense Type Combo 	
				);
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				//setting sheet
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboCodeText="";
				var sheetComboDefault="";
				for(var i=0; i < comboList.length;i++){
					//initializing sheetCombo
					sheetComboText="";
					sheetComboCode="";
					sheetComboCodeText="";
					sheetComboDefault=""; 
					if(comboList[i] != null){
						for(var j=0; j < comboList[i].length;j++){ 
							var tempText=comboList[i][j].split("|");   
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
							if(j ==0){	
								sheetComboDefault=tempText[0];      	
							}
							if(i==0) {
								combo_cost_dtl_cd.InsertItem(j, tempText[1] ,tempText[0]);
							}
						}
					}
				}
			}
		}
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      //t1sheet1 init
		with (sheetObj) { 
            var HeadTitle="|Sel|Del|Seq|EQ No.|Yard|Work Date|System Verify Result||||||";

            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_check",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",        KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg1",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg2",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
             {Type:"Date",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"inp_msg3",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"inp_msg5",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg4",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg6",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg7",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg8",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg9",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
            InitColumns(cols);

			SetEditable(1);
			SetEditableColorDiff(0);
			SetColProperty(0 ,"inp_msg1" , {AcceptKeys:"E|N" , InputCaseSensitive:1});		
			SetColProperty(0 ,"inp_msg2" , {AcceptKeys:"E|N" , InputCaseSensitive:1});		
            SetSelectionMode(smSelectionRow);
            SetSheetHeight(282);
            //no support[implemented common]CLT 			SelectHighLight=false;
		}
		break;  
		}  
	}
	// handling process for sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBSAVE:        //saving
		if(!validateForm(sheetObj,formObj,sAction))return;
		formObj.f_cmd.value=MULTI;   
		formObj.cost_dtl_cd.value=combo_cost_dtl_cd.GetSelectCode();
		for(var i=1; i <= sheetObj.RowCount(); i++){
			sheetObj.SetRowStatus(i,"I");
		}          
		var sParam=sheetObj.GetSaveString(false, true);
		if (sParam == "") return;
		sParam += "&" + FormQueryString(formObj);  
		var sXml=sheetObj.GetSaveData("EES_MNR_0219GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
		for(var i=1; i <= sheetObj.RowCount(); i++){
			if(sheetObj.GetCellValue(i,"checkbox") == 1){
				sheetObj.SetRowBackColor(i,"#F0FFFF");
				sheetObj.SetCellEditable(i,"inp_msg1",0);
				sheetObj.SetCellEditable(i,"inp_msg2",0);
				sheetObj.SetCellEditable(i,"inp_msg3",0);
			} else {                 
				sheetObj.SetRowBackColor(i,"#F7E5EB");
				sheetObj.SetCellEditable(i,"checkbox",0);
			}                          
		}         
		verifyCheck=true;
		break;      
		case IBINSERT:  // ROWADD                   
		var Row=sheetObj.DataInsert(-1);
		sheetObj.SetCellValue(Row,"inp_msg3",ComGetNowInfo("ymd"),0);
		sheetObj.SetCellEditable(Row,"checkbox",0);
		verifyCheck=false;                       
		break; 
		case IBDELETE:  // ROWDELETE   
		for(var i=sheetObj.RowCount(); i > 0; i--){
			if(sheetObj.GetCellValue(i,"del_check") == 1){
				sheetObj.RowDelete(i, false);
			}     	
		}           
		break;
		case IBCLEAR: //  retrieving Combo Data and initializing sheet 
		MnrWaitControl(true);
		sheetObj.SetWaitImageVisible(0);
		//initializing Combo Data  
		for(var i=0; i < comboObjects.length;i++){ 
			comboObjects[i].RemoveAll();
		}     
		initCombo();							 
		//initializing sheet
		sheetObj.RemoveAll();
		verifyCheck=false;  
		sheetObj.SetWaitImageVisible(1);
		MnrWaitControl(false);  
		break; 			
		}
	}
	/**
	 * Event when clicking Tab
	 * activating selected tab items.
	 */
	function tab1_OnChange(tabObj , nItem)
	{
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		//---------------  --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab=nItem;
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		if(sAction==IBSAVE)
		{
			if(combo_cost_dtl_cd.GetSelectIndex()== "-1"){
				ComShowCodeMessage("MNR00036","Service Sub Type");
				ComSetFocus(combo_cost_dtl_cd);
				return false;
			}
		}
		return true;
	}
	/**  
	 * combo1 Checkbox event      
	 * @param	{IBSheet}		sheetObj	ComboObject  
	 * @param 	{String} 			Row 		Row 
	 * @param 	{String} 			Col 		Col 
	 */  
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){  
		if(sheetObj.ColSaveName(Col) == 'checkbox')
		{
			if(sheetObj.GetCellValue(Row,Col) != 1){
				sheetObj.SetRowBackColor(Row,"#F0FFFF");
			} else {                            
				sheetObj.SetRowBackColor(Row,"#FFFFFF");
				sheetObj.SetCellValue(Row,"inp_msg5","",0);
				sheetObj.SetCellEditable(Row,"checkbox",0);
				sheetObj.SetCellEditable(Row,"inp_msg1",1);
				sheetObj.SetCellEditable(Row,"inp_msg2",1);
				sheetObj.SetCellEditable(Row,"inp_msg3",1);
				verifyCheck=false;        
			} 
		}				
	} 
	//showing message after saving
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){ 
		if (ErrMsg == "") {   
			ComShowCodeMessage("MNR00158");         
		} else { 
			ComShowCodeMessage("MNR00159",ErrMsg);   
		}       
	}
	
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
		for(var i=1; i <= sheetObj.RowCount(); i++){
			sheetObj.SetRowStatus(i,"R");
			sheetObj.SetCellEditable(i,"checkbox",0);
		}
	}
