/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057_12.js
 *@FileTitle  : Amendment History Inquiry - Special Note
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @
     * @author 
     */
    /**
     * @extends 
     * @class ESM_PRI_0057_12 : Business Script for ESM_PRI_0057_12
     */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	var sChgCdVisiable="";
	var delTotal=false;//flag for deleting last row of DETAIL
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.28
     */
	function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
  /**
	* registering IBSheet Object as list <br>
	* adding process for list in case of needing batch processing with other items<br>
	* defining list on the top of source <br>
	* <br><b>Example :</b>
	* <pre>
	*     setSheetObject(sheetObj);
	* </pre>
	* @param {ibsheet} sheet_obj mandatory IBSheet Object
	* @return void
	* @author 
	* @version 2009.10.28
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
   /**
    * initializing sheet <br>
    * implementing onLoad event handler in body tag <br>
    * adding first-served functions after loading screen. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return void
    * @author 
    * @version 2009.05.17
    */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//Modify Environment Setting Function's name
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//Add Environment Setting Function
			ComEndConfigSheet(sheetObjects[i]);
		}
		resizeSheet();
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
        loadSts=true;
        parent.loadTabPage();
	}
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
     * @author 
     * @version 2009.05.22
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
				with(sheetObj){					
					var HeadTitle="|Sel.|Seq.|dp_seq|Item|Title|note_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq|||";
//					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq" },
					 {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"note_clss_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:700,  Align:"Left",    ColMerge:0,   SaveName:"note_tit_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
					   
					InitColumns(cols);
					SetSheetHeight(120);
					SetEditable(1);
					SetWaitImageVisible(0);
					SetColProperty("note_clss_cd", {ComboText:noteClssCdComboText, ComboCode:noteClssCdComboValue} );
					//SetAutoRowHeight(0);
				}
				break;
             case "sheet2":
				with(sheetObj){
					var HeadTitle="|Sel.|dp_seq|Seq.|Surcharge|Content|Conversion|Conversion|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date" + "|note_seq|note_ctnt_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq|note_conv_mapg_id|note_chg_tp_cd|n1st_cmnc_amdt_seq";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
					  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq" },
					  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
					  {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"DummyCheck", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
					  {Type:"Popup",     Hidden:0, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"note_conv_mapg_id_pop",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_ctnt_seq" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_tp_cd" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_chg_tp_cd" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
					    
					InitColumns(cols);
//					SetSheetHeight(160);
					resizeSheet();
					SetEditable(1);
					SetWaitImageVisible(0);
					SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
					SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
					SetColHidden("chg_cd",1);
					//SetAutoRowHeight(0);
					SetShowButtonImage(2);
				}
                break;
         }
     }
	
	function resizeSheet() {
	    ComResizeSheet(sheetObjects[1]);
	}

     /**
      * Calling function in case of clicking SHEET's ROW<br>
      * Retrieving child-sheet by selected row<br>
      * <br><b>Example :</b>
      * <pre>
      *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
      * </pre>
      * @param {ibsheet} sheetM Mandatory HTMLtag(Object) Object
      * @param {ibsheet} sheetD Mandatory HTMLtag(Object) Object
      * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
      * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
      * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
      * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
      * @param {string} appendRow Mandatory SHEET Row Add Option
      * @return void
      * @author 
      * @version 2009.05.19
      */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (OldRow != NewRow) {			
			formObj.note_seq.value=sheetM.GetCellValue(adjNewRow, "note_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
		}	
	}
    /**
    * Handling sheet's processes <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {form} formObj mandatory html form object
    * @param {int} sAction mandatory,Constant Variable
    * @return void
    * @author 
    * @version 2009.05.22
    */
  	function doActionIBSheet(sheetObj, formObj, sAction) {
  		try {
	  		sheetObj.ShowDebugMsg(false);
	  		switch (sAction) {
	  			case IBSEARCH: // retrieving
	  				ComOpenWait(true);
					formObj.f_cmd.value=SEARCH01;
					formObj.note_tp_cd.value="P";
					// Call CONVERSION CHECK at main
					//formObj.con_chk.value = parent.getConversionValue(); 
					if(formObj.amdt_seq.value == 0 && formObj.con_chk.value == "0") {
						sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						return false;
					}
					sheetObj.DoSearch("ESM_PRI_0057_12GS.do", FormQueryString(formObj), {Sync:2}  );
	  				break;
	  			case IBSEARCHAPPEND: // Retrieving
	  				ComOpenWait(true);
	  				formObj.f_cmd.value=SEARCH02;
	  				formObj.note_tp_cd.value="P";
	  				sheetObj.DoSearch("ESM_PRI_0057_12GS.do", FormQueryString(formObj) , {Sync:2} );
					manageMasterChange(sheetObjects[0], sheetObjects[0].GetSelectRow(), null);
	  				break;  		
	  		}
  		}catch(e){
  			if (e == "[object Error]") {
  				ComShowMessage(OBJECT_ERROR);
  			} else {
  				ComShowMessage(e.message);
  			}
  		}finally {
  			 ComOpenWait(false);
  		}
  	}
    /**
    * Calling function in case of Onclick event <br>
    * Highlighting selected row<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @return void
    * @author 
    * @version 2009.05.19
    */		
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if (OldRow != NewRow) {

		}
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}
    /**
     * calling function in case of OnSelectCell event <br>
     * Displaying different highlight color at Amend Row<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, ,Previous selected cell's Row Index
     * @param {int} OldCol Mandatory, ,Previous selected cell's Column Index
     * @param {int} NewRow Mandatory, ,current selected cell's Row Index
     * @param {int} NewCol Mandatory, ,current selected cell's Column Index
     * @return void
     * @author 
     * @version 2009.04.17
     */         
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {

        }
    } 
    /**
     * Calling function in case of Onclick event <br>
     * Showing memopad for address inputting<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value without Value Mandatory Format when saving 
     * @return void
     * @author 
     * @version 2009.06.18
     */
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
 	    //Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
 	    var formObj=document.form;
 	    var colname=sheetObj.ColSaveName(Col);
      	switch(colname)
      	{
      		case "note_ctnt":
	    		ComShowMemoPad(sheetObj, Row, Col, true, 350);
	    		break;      	
      	}
	} 
     
     function SheetObject(sheet, row, col){
  		this.sheet = sheet;
  		this.row = row;
  		this.col = col;
  	}
  	var _tmp_sheetObject;
  	
     /**
      * Calling function in case of OnPopupClick event<br>
      * Calling Location PopUp <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
      * @param {int} Col Mandatory OnPopupClick 'Cell's Column Index
      * @return void
      * @author 
      * @version 2009.05.07
      */ 
  	function sheet2_OnPopupClick(sheetObj, Row, Col) {
  		var colName=sheetObj.ColSaveName(Col);
  		var formObj=document.form;
  		_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
  		//var ctrtExpDt = parent.getCtrtExpDate();
  		if (colName == "note_conv_mapg_id_pop") {	
  			if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_clss_cd") == "D") {
  				ComPriOpenPopup('EES_DMT_2001.do?prop_no=' + formObj.prop_no.value + '&caller=2007',  1280, 800, 'findCustomer', '1,0,1,1,1,1,1', false);
  			} else {
  				if(!ComIsNull(sheetObj.GetCellValue(Row, "note_conv_mapg_id"))) {
  					var sParam="";
  					sParam += "svc_scp_cd=" + formObj.svc_scp_cd.value;
  					sParam += "&prop_no=" + formObj.prop_no.value;
  					sParam += "&amdt_seq=" + formObj.amdt_seq.value;
					sParam += "&note_conv_mapg_id=" + sheetObj.GetCellValue(Row, "note_conv_mapg_id");
					sParam += "&note_seq=" + sheetObj.GetCellValue( Row, "note_seq");
					sParam += "&note_ctnt_seq=" + sheetObj.GetCellValue( Row, "note_ctnt_seq");
					sParam += "&note_tp_cd=" + sheetObj.GetCellValue( Row, "note_tp_cd");
					sParam += "&eff_dt=" + sheetObj.GetCellValue( Row, "eff_dt");
  					//sParam += "&exp_dt=" + sheetObj.CellValue( Row, "exp_dt");
  					//sParam += "&exp_dt=" + ctrtExpDt;
  					sParam += "&master_seq=" + sheetObjects[0].GetSelectRow();
  					sParam += "&detail_seq=" + sheetObjects[1].GetSelectRow();
  					sParam += "&con_chk=" + formObj.con_chk.value; 
  					var sUrl="/opuscntr/ESM_PRI_0102.do?"+sParam;			
  					ComOpenPopup(sUrl, 1040, 590, "ESM_PRI_0102_returnVal", "1,0", false);
  				} else {
  					ComShowCodeMessage("PRI08015");
  				}
  			}
  		}
      }
  	
  	function ESM_PRI_0102_returnVal(rtnVal) {
  		if(rtnVal != null && rtnVal.length > 0) {
			//Using "for" because possible to save by contents on CONVERSION scrreen
			for(var i=0; i < rtnVal.length; i++) {
				//Using "for" because possible to modify the selected row on CONVERSION scrreen
				for(var j=_tmp_sheetObject.sheet.HeaderRows(); j <= _tmp_sheetObject.sheet.LastRow(); j++) {
					if(_tmp_sheetObject.sheet.GetCellValue(j, "note_seq") == rtnVal[i].master_seq
							&& _tmp_sheetObject.sheet.GetCellValue(j, "note_ctnt_seq") == rtnVal[i].detail_seq
							&& _tmp_sheetObject.sheet.GetCellValue(j, "amdt_seq") == rtnVal[i].amdt_seq ) {
						_tmp_sheetObject.sheet.SetCellValue(j, "note_conv_flg",rtnVal[i].note_conv_flg,0);
						_tmp_sheetObject.sheet.SetCellValue(j, "note_chg_tp_cd",rtnVal[i].note_chg_tp_cd,0);
					}
				}
			}
		}
  	}
 	/**
 	 * Calling Function in case of OnSearchEnd event <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj mandatory IBSheet Object
 	 * @param {string} ErrMsg mandatory from server
 	 * @return void
 	 * @author 
 	 * @version 2009.05.20
 	 */ 
 	function sheet2_OnSearchEnd(sheetObj, errMsg){
 		 manageGetCellEditable(sheetObj);
 	 }
 	/**
 	 * Calling Function in case of OnSearchEnd event <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj mandatory IBSheet Object
 	 * @param {string} ErrMsg mandatory from server
 	 * @return void
 	 * @author 
 	 * @version 2009.05.20
 	 */ 
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		var formObj=document.form;
 		var sLgcyIfFlg=formObj.lgcy_if_flg.value;
		//Handling color at master in case all detail's row source is AD		
		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if(sheetObj.GetCellValue(i,"amdt_seq") > 0 && sLgcyIfFlg != "Y") {
				if(sheetObj.GetCellValue(i,"src_info_cd") == 'AD') {
					sheetObj.SetCellFont("FontStrike", i, "chk", i, sheetObj.LastCol(),1);
					sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
				} else if(sheetObj.GetCellValue(i,"src_info_cd") == 'AM' || sheetObj.GetCellValue(i,"src_info_cd") == 'NW') {
					sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
				} 
			}
		}
 	}
 	/**
      * Setting sheet's cell editable<br>
      * 
      * <br><b>Example :</b>
      * <pre>
      * 	manageCellEditable (sheetObj);
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @return void
      * @author 
      * @version 2009.04.17
      */
      function manageGetCellEditable(sheetObj) {
     	 var formObj=document.form;
     	 var amdtSeq=formObj.amdt_seq.value;
    	 var sLgcyIfFlg=formObj.lgcy_if_flg.value;
    	 var noteClssCd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_clss_cd");
     	 for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
     		  // diable in case of not same AMDT_SEQ
     		 if(sheetObj.GetCellValue(i,"amdt_seq") != amdtSeq){
     			 sheetObj.SetCellFont("FontStrike", i, "chk", i, sheetObj.LastCol(),1);
     			  sheetObj.SetCellEditable(i,"note_conv_mapg_id_pop",0);
     		  } else {
     			  sheetObj.SetCellEditable(i,"note_conv_mapg_id_pop",1);
     		  }
     		 if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq && sLgcyIfFlg != "Y"){
     			 sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
     		  }     		  
     		  sheetObj.SetCellEditable(i,"note_conv_flg",0);
     	 }
      } 	 
		/**
	     * Handling detail screen when selecing master's row<br>
	     * <br><b>Example :</b>
	     * <pre>
	     * manageMasterChange(sheetObj, Row, Col);
	     * </pre>
	     * @param {ibsheet} sheetObj mandatory IBSheet Object
	     * @param {int} Row mandatory Onclick ,Cell's Row Index
	     * @param {int} Col mandatory Onclick ,Cell's Column Index
	     * @return void
	     * @author 
	     * @version 2009.05.20
	     */ 
	    function manageMasterChange(sheetObj, Row, Col) {
	    	var noteClssCd=sheetObj.GetCellValue(Row, "note_clss_cd");
			if(noteClssCd == "S") {
				sheetObjects[1].SetColHidden("chg_cd",0);
			} else {
				sheetObjects[1].SetColHidden("chg_cd",1);
			}
		}
     /**
      * handling process for input validation <br>
      * <br><b>Example :</b>
      * <pre>
      *     if (validateForm(sheetObj,document.form,IBSAVE)) {
      *        handling logic
      *     }
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {form} formObj mandatory html form object
      * @param {int} sAction mandatory,Constant Variable
      * @returns bool <br>
      *          true  : valid<br>
      *          false : inValid
      * @author 
      * @version 2009.04.17
      */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // retrieving
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		case IBSEARCHAPPEND: // Retrieving
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		}
		 return true;
	}
	 /**
	  * Calling function in case of clicking tabl on parent screen <br>
	  * It shows screen and process retrieve <br>
	  * <br><b>Example :</b>
	  * <pre>
	  * tabLoadSheet("ACE", "1")
	  * </pre>
	  * @param {string} sPropNo Mandatory prop_no 
	  * @param {string} sAmdtSeq Mandatory amdt_seq 
	  * @param {string} sSvcScpCd Mandatory svc_scp_cd 
	  * @param {string} sConChk Mandatory Conversion check 
	  * @return void
	  * @author 
	  * @version 2009.05.21
	  */ 
	 function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
	 	var formObject=document.form;
	 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
	 		formObject.prop_no.value=sPropNo;
	 		formObject.amdt_seq.value=sAmdtSeq;
	 		formObject.svc_scp_cd.value=sSvcScpCd;
	 		formObject.con_chk.value=sConChk;
 			formObject.lgcy_if_flg .value=sLgcyIfFlg ;
	 		doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
	 	}
	 }
	/**
     * Function to clear control of tab screen on parent <br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.05.20
     */ 
	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	}
	var enableFlag=true;
	/**
     * Calling function from main<br>
     * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from Main screen
     * @return void
     * @author 
     * @version 2009.04.17
     */
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
	}
  /**
    * Loading SHEET's data to XML
    * <br><b>Example :</b>
    * <pre>
    *	getSheetXml(sheetObj);
    * </pre>
    * @param {int} sheetNo Mandatory IBSheet Object index
    * @return {string} sXml Mandatory xml format
    * @author 
    * @version 2009.07.02
    */	   
    function getSheetXml(sheetNo) {
    	var sXml=ComPriSheet2Xml(sheetObjects[sheetNo]);
        return sXml;
    }
    var loadSts=false;
    /**
     * Calling function from main<br>
     *  <br>
     * <br><b>Example :</b>
     * <pre>
     *loadFinishCheck()
     * </pre>
     * @return void
     * @author 
     * @version 2009.05.19
     */
    function loadFinishCheck(){
        return loadSts;
    }        