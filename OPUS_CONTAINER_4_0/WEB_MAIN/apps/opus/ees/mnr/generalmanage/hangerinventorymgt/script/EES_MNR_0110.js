/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0110.jsp
*@FileTitle  : Hanger Bar Inventory List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var initLoader=0;
var regionalHQ="";
var nowLoad=0;
// Office level of login user : HO level -> L1, RHQ level -> L2, Office level -> L3 (MnrOfficeLevel reference at CoMnr.js)
var strMnrOfficeLevel="";
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
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_save":
					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
				case "btn_Detail":
					var ofc_cd="";
					var reqStr=""
						ofc_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"ofc_cd")
					reqStr="ofc_cd=" + ofc_cd
					if(sheetObjects[0].RowCount()>0){
						ComOpenPopup('/opuscntr/EES_MNR_0224.do?'+ reqStr, 1024, 500, '', "0,1,1,1,1,1", true);
					}
					break;
				case "btn_RowAdd":
					doRowAdd(sheetObject1, formObject);
					break;
				case "btn_Delete":
					if(sheetObject1.FindCheckedRow("del_chk") == ""){
						ComShowCodeMessage("MNR00038","DELETE ");
						return false;
					}
					if(ComShowCodeConfirm("MNR00026")){
						ComRowHideDelete(sheetObjects[0], "del_chk");
					}
					break;
				case "btn_downexcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		MnrWaitControl(true);
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //initializing IBMultiCombo
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k + 1);
	    }
		MnrOfficeLevel(currOfcCd,rhqOfcCd);
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
    /**
	 * setting combo basic info
	 * @param	{IBMultiCombo}	combo_obj	ComboObject.
	 * @param	{Number}	comboNo		ComboObject tag serial number
	 * adding case as numbers of counting combos
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboNo) {
	        case 1:
	           	with (comboObj) {
				//MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
		    	}
	        	break;
	        case 2:
	           	with (comboObj) {
				//MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
		    	}
	        	break;
	     }
	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
	              var HeadTitle1="|Sel|Seq.|Regional\nH/Q|Office|Bar Type|Inventory|Purchase Qty|Supply Qty|Collection Qty|Collection Qty|Missing Qty|Missing Qty|G.TTL|Remark(s)|Update\nDate";
	              var HeadTitle2="|Sel|Seq.|Regional\nH/Q|Office|Bar Type|Inventory|Purchase Qty|Supply Qty|Sound|Damage|Missing|Disposal|G.TTL|Remark(s)|Update\nDate";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ar_hd_qtr_ofc_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mnr_hngr_bar_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"rcvr_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"pur_qty",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"csm_qty",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:"act_invt_qty",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_hngr_dmg_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_lost_hngr_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_disp_hngr_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"invt_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"invt_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"col_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	               
              	InitColumns(cols);

              	SetEditable(1);
                SetSelectionMode(smSelectionRow);

//                SetSheetHeight(396);
                resizeSheet( sheetObj );
              }
         break;
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
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject.
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
   /**
	 * handling in case of onChange combo event 
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */
	function comboOnChange(comboObj,Index_Code, Text){
		var formObj=document.form;
		combo2.RemoveAll();
		var sCondition=new Array (
			new Array("MdmOrganization","SEARCH",Index_Code)
		)
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		if(comboList[0] != null){
			for(var j=0; j < comboList[0].length;j++){
		   		var tempText=comboList[0][j].split("|");
		   		combo2.InsertItem(j,comboList[0][j] ,tempText[0]);
			}
		 	combo2.InsertItem(0, "ALL" , "A");
			combo2.SetSelectCode("A");
		}
	}
	/**
	 * combo1 Change event
	 * @param {IBMultiCombo}  comboObj ComboObject
	 * @param  {String}    Index_Code   Index or Code
	 * @param  {String}    Text
	 */
	//function combo1_OnChange(comboObj,Index_Code, Text){
	function combo1_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		var formObj=document.form;
		if(comboObj.GetSelectCode()=="A"){
			formObj.ar_hd_qtr_cd.value="";
		}else{
			formObj.ar_hd_qtr_cd.value=comboObj.GetSelectCode();
		}
		comboOnChange(comboObj,NewCode, NewText);
	}
	/**
	 * combo2 Change event
	 * @param {IBMultiCombo}  comboObj ComboObject
	 * @param  {String}    Index_Code   Index or Code
	 * @param  {String}    Text
	 */
	//function combo2_OnChange(comboObj,Index_Code, Text){
	function combo2_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		var formObj=document.form;
		if(comboObj.GetSelectCode()=="A"){
			formObj.ofc_cd.value="";
		}else{
			formObj.ofc_cd.value=comboObj.GetSelectCode();
		}
	}
   /**
    * handling process after ending sheet1 retrieve.
    * @param sheetObj
    * @param errMsg
    * @return
    */
     function sheet1_OnSearchEnd(sheetObj, errMsg) {
		if(sheetObjects[0].RowCount()>0){
	    	 for(i=sheetObjects[0].LastRow(); i > 1 ; i--){
				  sheetObj.SetRowStatus(i,"R");
			 }
		}
     }
   /**
    * loading message after saving
    * @param sheetObj
    * @param ErrMsg
    * @return
    */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	  	  if (ErrMsg == "") {
	  		  ComShowCodeMessage("MNR00023");
			  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	  	  } else {
	  		  ComShowCodeMessage("MNR00008",ErrMsg);
	  	  }
	}
   /**
    * handling OnChange event
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
    	if(nowLoad == 0){
		   	if(sheetObj.ColSaveName(Col) == "ar_hd_qtr_ofc_cd"){
				if(strMnrOfficeLevel=="L1"){
					cellSetItems(sheetObj, Row, "ofc_cd", Value);
				}else if(strMnrOfficeLevel=="L2"){
					cellSetItems(sheetObj, Row, "ofc_cd", Value);
				}else if(strMnrOfficeLevel=="L3"){
				   	sheetObj.SetCellValue(Row, "ar_hd_qtr_ofc_cd",currOfcCd,0);
				   	cellSetItems(sheetObj, Row, "ofc_cd", currOfcCd);
				}
		   	} else if(sheetObj.ColSaveName(Col) == "act_invt_qty" || sheetObj.ColSaveName(Col) == "mnr_hngr_dmg_qty"){
				//previous sum
		   		var collectionQty=parseInt(sheetObj.GetCellValue(Row, "col_qty"));
				if(sheetObj.ColSaveName(Col) == "act_invt_qty"){
					var soundQty=parseInt(Value);
					sheetObj.SetCellValue(Row, "mnr_hngr_dmg_qty",collectionQty - soundQty,0);
				} else {
					var dmgQty=parseInt(Value);
					sheetObj.SetCellValue(Row, "act_invt_qty",collectionQty - dmgQty,0);
				}
				setGTTL(sheetObj, Row);
		   	} else if(sheetObj.ColSaveName(Col) == "rcvr_qty"){
				setGTTL(sheetObj, Row);
			}
    	}
	}
	function sheet1_OnClick(sheetObj,Row, Col, Value){
    	
	}
  	/**
     * handling process sheet
     * @param	{IBSheet}	sheetObj	handling sheetObject
     * @param	{Form}		formObj		handling formObject
     * @param	{Number}	sAction		Action constants 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //retrieving
                if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id =="sheet1"){
						formObj.f_cmd.value=SEARCH;
						sheetObj.DoSearch("EES_MNR_0110GS.do",FormQueryString(formObj) );
					}
				}
                break;
			case IBCLEAR:        //initializing
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
				if(initLoader == 0){
					//initializing combo
					for(var i=0; i < comboObjects.length;i++){
						comboObjects[i].RemoveAll();
					}
				    regionalHQ="";
					//retrieving common combo.
					var sCondition=new Array (
						new Array("MnrGenCd","CD00022", "COMMON"),  //Hanger Bar Type
						new Array("MdmOrganization","RHQ","FALSE"),  //Regional HQ
						new Array("MdmOrganization","SEARCH","NOTHQ")
					);
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					//setting combo
					for(var i=0; i < comboList.length;i++){
						if(comboList[i] != null){
							//initializing sheetCombo
							sheetComboText="";
							sheetComboCode="";
							for(var j=0; j < comboList[i].length;j++){
								var tempText=comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								if(i==1){ //Regional HQ
									combo1.InsertItem(j, comboList[i][j] ,tempText[0]);
									regionalHQ=regionalHQ + tempText[0] + "|";
								}
							}
							
							sheetComboCode = sheetComboCode.replace(/\|$/, "");
							sheetComboText = sheetComboText.replace(/\|$/, "");
							//Hanger Bar Type
							if(i==0) {
								sheetObjects[0].SetColProperty(0,"mnr_hngr_bar_tp_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
							}else if(i==2){
								if(strMnrOfficeLevel=="L3"){
									sheetComboCode=currOfcCd ;
								}
							 	sheetObjects[0].SetColProperty(0,"ofc_cd", {ComboText:sheetComboCode, ComboCode:sheetComboCode} );
							}
						}
					}
					combo1.InsertItem(0, "ALL" ,"A" );
					if(strMnrOfficeLevel=="L1"){
						combo1.SetSelectCode("A");
					}else{
						combo1.SetEnable(0);
						combo1.SetSelectCode(rhqOfcCd);
						regionalHQ=rhqOfcCd ;
					}
					initLoader=1;
				}
				//initializing sheet
				for(i=0;i<sheetObjects.length;i++){
					sheetObjects[i].RemoveAll();
		        }
				
				if(strMnrOfficeLevel=="L3"){
					combo2.SetEnable(0);
					combo2.SetSelectCode(currOfcCd);
					formObj.ofc_cd.value=currOfcCd;
				}else if(strMnrOfficeLevel=="L2"){
					combo2.SetSelectCode("A");
					formObj.ofc_cd.value="";
				}else{
					combo2.SetSelectCode("A");
					formObj.ofc_cd.value="";
					regionalHQ = MnrDelLastDelim(regionalHQ);
				}
				sheetObjects[0].SetColProperty(0,"ar_hd_qtr_ofc_cd", {ComboText:regionalHQ, ComboCode:regionalHQ} );
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
                break;
			case IBSAVE:      // saving
			 	if(!validateForm(sheetObj,formObj,sAction)){
 		   			return;
 	   			}
				formObj.f_cmd.value=MULTI;
				var sParam=ComGetSaveString(sheetObj);
			    if (sParam == "") return;
			    sParam += "&" + FormQueryString(formObj);
			    var sXml=sheetObj.GetSaveData("EES_MNR_0110GS.do", sParam);
			    sheetObj.LoadSaveData(sXml);
				break;
			case IBDOWNEXCEL:
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol( sheetObj), SheetDesign:1,Merge:1 });
				break;
        }
    }
    /**
     * handling process for input validation
     * @param	{IBSheet}	sheetObj	checking sheetObject
     * @param	{Form}		formObj		checking comboObject
     * @param	{Number}	sAction		Action constants 
     */
	function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSAVE) {
				if (!ComChkValid(formObj))	return false;
				var Row=sheetObjects[0].ColValueDup( "ar_hd_qtr_ofc_cd|ofc_cd|mnr_hngr_bar_tp_cd");
				if(sheetObjects[0].IsDataModified()){
					if(Row > 0){
						ComShowCodeMessage("MNR00006", (Row - 1) + " row ");
						return false;
					}
				}
				for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].RowCount();i++)
				{
					if(sheetObjects[0].GetRowStatus(i) == "U"){
						var soundQty=parseInt(sheetObjects[0].GetCellValue(i, "act_invt_qty"));
						var dmgQty=parseInt(sheetObjects[0].GetCellValue(i, "mnr_hngr_dmg_qty"));
						if(soundQty < 0){
							ComShowCodeMessage("MNR00224");
							sheetObj.SelectCell(i, "act_invt_qty", true);
							return false;
						}
						if(dmgQty < 0){
							ComShowCodeMessage("MNR00224");
							sheetObj.SelectCell(i, "mnr_hngr_dmg_qty", true);
							return false;
						}
					}
				}
			}
        }
		return true;
	}
	 /**
	 * Total Calculation : Purchase Qty -Supply+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + previous Inventory
	 * @param {IBSheet}	sheetObj
	 * @param {Number}	Row
	 * @return
	 */
	function setGTTL(sheetObj, Row){
		//previous Quantity
		var rcvrQty=parseInt(sheetObj.GetCellValue(Row, "rcvr_qty"));
		// Purchase
		var purQty=parseInt(sheetObj.GetCellValue(Row, "pur_qty"));
		// Supply
		var csmQty=parseInt(sheetObj.GetCellValue(Row, "csm_qty"));
		// Sound
		var soundQty=parseInt(sheetObj.GetCellValue(Row, "act_invt_qty"));
		//Damage
		var dmgQty=parseInt(sheetObj.GetCellValue(Row, "mnr_hngr_dmg_qty"));
		//Missing
		var lostQty=parseInt(sheetObj.GetCellValue(Row, "mnr_lost_hngr_qty"));
		//Disposal
		var dispQty=parseInt(sheetObj.GetCellValue(Row, "mnr_disp_hngr_qty"));
		var ttlQty=purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
		sheetObj.SetCellValue(Row,  "invt_qty",ttlQty,0);
	}
   /**
     * //handling event in case of clicking row add button
     * @param sheetObj
     * @param formObj
     * @return
     */
	 function doRowAdd(sheetObj, formObj){
		    nowLoad=1;
		    var iRow=sheetObjects[0].DataInsert(-1);
			if(strMnrOfficeLevel=="L1"){
				if( combo1.GetSelectCode()== "A"){
					sheetObjects[0].SetCellValue(iRow,  "ar_hd_qtr_ofc_cd",rhqOfcCd,0);
				}else{
					sheetObjects[0].SetCellValue(iRow,  "ar_hd_qtr_ofc_cd",combo1.GetSelectCode(),0);
				}
				cellSetItems(sheetObjects[0], iRow, "ofc_cd", sheetObj.GetCellValue(iRow, "ar_hd_qtr_ofc_cd"));
			}else if(strMnrOfficeLevel=="L2"){
				if( combo1.GetSelectCode()== "A"){
					sheetObjects[0].SetCellValue(iRow,  "ar_hd_qtr_ofc_cd",rhqOfcCd,0);
				}else{
					sheetObjects[0].SetCellValue(iRow,  "ar_hd_qtr_ofc_cd",combo1.GetSelectCode(),0);
				}
				cellSetItems(sheetObjects[0], iRow, "ofc_cd", sheetObj.GetCellValue(iRow, "ar_hd_qtr_ofc_cd"));
			}else if(strMnrOfficeLevel=="L3"){
				sheetObjects[0].SetCellValue(iRow,  "ar_hd_qtr_ofc_cd",rhqOfcCd,0);
				sheetObjects[0].SetCellValue(iRow,  "ofc_cd",currOfcCd,0);
			}
			sheetObjects[0].SelectCell(iRow, "Seq") ;
			nowLoad=0;
	 }
	/**
    * setting combo of operation office.
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function cellSetItems(sheetObj, Row, Col, Value){
		var sCondition=new Array (
			new Array("MdmOrganization","SEARCH",Value)
		)
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		if(comboList[0] != null){
			sheetComboText="";
			sheetComboCode="";
			var tmp = "";
			for(var j=0; j < comboList[0].length;j++){
		   		var tempText=comboList[0][j].split("|");
				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
				if(j==0){
					tmp = tempText[0];
				}
			}
			
			sheetComboText = MnrDelLastDelim(sheetComboText);
			sheetComboCode = MnrDelLastDelim(sheetComboCode);
			sheetObjects[0].CellComboItem(Row,Col, {ComboText:sheetComboCode, ComboCode:sheetComboCode} );
			sheetObjects[0].SetCellValue(Row, Col, tmp, 0);
	 	}else{
	 		 ComShowCodeMessage("MNR00010", "Regional H/Q Office");
	 		 sheetObjects[0].SelectCell(Row, "ar_hd_qtr_ofc_cd");
		}
	}
	/* developer job */
