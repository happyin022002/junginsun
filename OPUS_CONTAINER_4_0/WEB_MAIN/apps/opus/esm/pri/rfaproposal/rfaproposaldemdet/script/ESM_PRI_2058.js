/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2058.js
*@FileTitle  : RFA Proposal Creation [Amend] (DEM&DET)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
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
     * @class ESM_PRI_2058 : Business Script for ESM_PRI_2058
     */
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var rtnValue="N";
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
     * @version 2009.08.18
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
	    		case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
	    		case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
	    		case "btn_amend":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
					break;
				case "btn_amendcancel":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
					break;
				case "btn_accept":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
					break;
				case "btn_acceptcancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY02);
					break;
				case "btn_close":
//					window.returnValue = rtnValue;
//					ComClosePopup(); 
					ComPopUpReturnValue(rtnValue);
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
     * @version 2009.08.18
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
     * @version 2009.08.18
     */
    function loadPage() {
    	 for(i=0;i<sheetObjects.length;i++){
     		//Modify Environment Setting Function's name
     		ComConfigSheet (sheetObjects[i] );
     		initSheet(sheetObjects[i],i+1);
     		//Add Environment Setting Function
     		ComEndConfigSheet(sheetObjects[i]);
     	}
         pageOnLoadFinish(); 
    }
    /**
     * Handling body tag's unonLoad event handler <br>
     * adding the functions when screen is closing.<br>
     * <br><b>Example :</b>
     * <pre>
     *     unloadPage();
     * </pre>
     * @return void
     * @author 
     * @version 2009.08.17
     */      
    function unloadPage(){
    	window.returnValue=rtnValue;
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
     * @version 2009.08.18
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetId=sheetObj.id;
    	switch(sheetId) {
    		case "sheet1":
    			with (sheetObj) {
              
	                var HeadTitle="Flag|prop_no|amdt_seq|n1st_cmnc_amdt_seq|Free Time|Effective Date|Expiration Date|Source|Status";
	                var headCount=ComCountHeadTitle(HeadTitle);
	//                (headCount, 0, 0, true);
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                 {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Combo",     Hidden:0, Width:220,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_ft_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                resizeSheet(); //SetSheetHeight(120);
	                SetWaitImageVisible(0);
	                SetColProperty("dmdt_ft_tp_cd", {ComboText:dmdtFtTpCdText, ComboCode:dmdtFtTpCdValue} );
	                SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
	                SetColProperty("prc_prog_sts_cd", {ComboText:PrcProgStsCdText, ComboCode:PrcProgStsCdValue} );
	                //SetAutoRowHeight(0);
    			}
    			break;
    	}
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
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
     * @version 2009.08.18
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
	    	case IBSEARCH:
	    		ComOpenWait(true);	
	    		if(!validateForm(sheetObj,formObj,sAction)) {
	    			ComOpenWait(false);
	    			return false;
	      		}
	    		formObj.f_cmd.value=SEARCH01;
 				sheetObj.DoSearch("ESM_PRI_2058GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
	    		break;
	    	case IBSAVE:
	    		ComOpenWait(true);
	    		if(!validateForm(sheetObj,formObj,sAction)) {
	    			ComOpenWait(false);
	    			return false;
	      		}
	    		formObj.f_cmd.value=MULTI01;
				sheetObj.DoSave("ESM_PRI_2058GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
	    		break;
	    	case MODIFY01:	//Accept
	    		ComOpenWait(true);
	    		if (!validateForm(sheetObj, document.form, sAction)) {
	    			ComOpenWait(false);
	    			return false;
				}
				formObj.f_cmd.value=MULTI02;
				acceptRows(sheetObjects[0], document.form );
				ComOpenWait(false);
				break;
			case MODIFY02:	//Accept Cancel
				ComOpenWait(true);
				if (!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI03;
				acceptCancelRows(sheetObjects[0], document.form);
				ComOpenWait(false);
				break;
			case COMMAND01:	//Amend
				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
				if(chkArr.length > 0){
					if(chkArr.length > 1){					
						ComShowCodeMessage("PRI00310");
					}else{
						amendRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M", "dmdt_ft_tp_cd");
					}
				} else { 
					amendRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M", "dmdt_ft_tp_cd");
				}
				break;
			case COMMAND02: // Amend Cancel
				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
				if(chkArr.length > 0) {
					if(chkArr.length > 1){					
						ComShowCodeMessage("PRI00310");
					}else{
						amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M", "dmdt_ft_tp_cd");
					}
				}else{ 
					amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M", "dmdt_ft_tp_cd");
				}
				break;		
    	}
    }
    /**
     * Accepting checked row or selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptRows(sheetObjects[0], document.form )
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.08.18
     */
 	function acceptRows(sheetObj,formObj ) {
     	var propStsCd=formObj.prop_sts_cd.value;
 		var effDt=formObj.eff_dt.value;
 		var amdtSeq=formObj.amdt_seq.value;
 		if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") != amdtSeq) {
			ComShowCodeMessage("PRI00313");
			return false;
		}
 		if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd") == "A") {
 			ComShowCodeMessage("PRI01037");
			return false;
 		}
 		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd","A");
  		sheetObj.DoSave("ESM_PRI_2058GS.do", FormQueryString(formObj), -1, false);
  		return;
 	}
 	/**
     * Canceling acceptance of checked row or selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptCancelRows(sheetObjects[0], document.form, "ESM_PRI_0003_04GS.do")
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param (string) sUrl Mandatory
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.08.18
     */
 	function acceptCancelRows(sheetObj, formObj) {
    	var propStsCd=formObj.prop_sts_cd.value;
  		var effDt=formObj.eff_dt.value;
  		var amdtSeq=formObj.amdt_seq.value;
  		if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq") != amdtSeq) {
  			ComShowCodeMessage("PRI00313");
  			return false;
  		}
  		if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd") != "A") {
  			ComShowCodeMessage("PRI01038");
			return false;
  		}
  		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd","I");
   		sheetObj.DoSave("ESM_PRI_2058GS.do", FormQueryString(formObj), -1, false);
   		return;
 	}
 	/**
     * Amending selected row <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendRow(sheetObjects[0], document.form, Row, "M", "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param (int) sRow Mandatory row index
     * @param (string) sAction Mandatory  Whether amend or delete amend
     * @param (string) sCols Mandatory column index
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.08.18
     */
    function amendRow(sheetObj,formObj,sRow,sAction,sCols) {
		var prop_no=formObj.prop_no.value;
		var amdt_seq=formObj.amdt_seq.value;
		var pre_amdt_seq=formObj.pre_amdt_seq.value;
		var eff_dt=formObj.eff_dt.value;
		var exp_dt=formObj.exp_dt.value;
		var pre_exp_dt=formObj.pre_exp_dt.value;
		var arrCols=sCols.split("|");
		var dur_dup_flg=formObj.dur_dup_flg.value;
			// except already amended row
		if(sheetObj.GetCellValue(sRow,"amdt_seq") != amdt_seq || sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq") == amdt_seq) {
			ComShowCodeMessage("PRI01011");
		 	return false;
		}
		// Setting sRow to set base row for DataCopy/ Insert
		sheetObj.SetSelectRow(sRow);
		var idx=sheetObj.DataCopy();     // New row
		var idx2=idx-1;                  // Current (Old) row
		// Add, Modify, Delete Common New Row Creation
		if(sheetObj.GetCellValue(idx2, "dmdt_ft_tp_cd") == "E") {
			sheetObj.SetCellValue(idx,"dmdt_ft_tp_cd","T",0);
		} else {
			sheetObj.SetCellValue(idx,"dmdt_ft_tp_cd","E",0);
		}
		sheetObj.SetCellValue(idx,"eff_dt",eff_dt,0);
		sheetObj.SetCellValue(idx,"n1st_cmnc_amdt_seq",amdt_seq,0);
		sheetObj.SetCellValue(idx,"prc_prog_sts_cd","I",0);
		sheetObj.SetCellValue(idx,"src_info_cd","AM",0);
//		sheetObj.CellValue2(idx,"ibflag") = "U";
		sheetObj.SetRowStatus(idx,"U");
		sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
 		sheetObj.SetCellFont("FontStrike", idx2, 1, idx2, sheetObj.LastCol(),1);
		sheetObj.SetCellValue(idx2,"amdt_seq",pre_amdt_seq,0);
		if(dur_dup_flg=="Y"){
            sheetObj.SetCellValue(idx2,"exp_dt",pre_exp_dt,0);
        }
//		sheetObj.CellValue2(idx2,"ibflag") = "R";
		sheetObj.SetRowStatus(idx2,"R");
		sheetObj.SetRowEditable(idx2,0);
		// Delete, Add Case, New Row Update
		if(sAction == "D") {
			sheetObj.SetCellValue(idx,"src_info_cd","AD",0);
			for(z=0;z<arrCols.length;z++){
				sheetObj.SetCellEditable(idx,arrCols[z],0);
			}			
		}
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
		return true;
	}
    /**
     * Canceling amendment of selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendCancelRow(sheetObjects[0], document.form, Row, "M", "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param (int) sRow Mandatory row index
     * @param (string) sAction Mandatory  Whether amend or delete amend
     * @param (string) sCols Mandatory column index
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.08.18
     */
	function amendCancelRow(sheetObj,formObj,sRow,sAction, sCols) {
		var eff_dt=formObj.eff_dt.value;
		var exp_dt=formObj.exp_dt.value;
		var arrCols=sCols.split("|");		
		var pre_amdt_seq=formObj.pre_amdt_seq.value;
		var amdt_seq=formObj.amdt_seq.value;
		var dur_dup_flg=formObj.dur_dup_flg.value;
		// handling in case of  n1st_cmnc_amdt_seq == amdt_seq in A/M/D
		if(sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq")!= amdt_seq){
			ComShowCodeMessage("PRI01012");
		 	return false;
		}
		var idx=sRow-1;
		var idx2=sRow;
		if(sAction=="A"&&(sheetObj.GetCellValue(sRow,"src_info_cd")=="NW"||sheetObj.GetCellValue(sRow,"src_info_cd")=="GM"||sheetObj.GetCellValue(sRow,"src_info_cd")=="GC")){
//			sheetObj.CellValue(sRow,"ibflag")="D";
			sheetObj.SetRowStatus(sRow,"D");
			sheetObj.SetRowEditable(sRow,0);
			sheetObj.SetRowHidden(sRow,1);
			return false;
		} else {
			if(sheetObj.GetCellValue(sRow,"src_info_cd")!="AD"&&sheetObj.GetCellValue(sRow,"src_info_cd")!="AM"){
				ComShowCodeMessage("PRI01002");		
			 	return false;
			}
			if(dur_dup_flg=="Y"){
            	sheetObj.SetCellValue(idx,"exp_dt",exp_dt,0);
            }
			//sheetObj.CellValue2(idx,"exp_dt") = sheetObj.CellValue(idx2,"exp_dt");
 			sheetObj.SetCellFont("FontStrike", idx, 1, idx, sheetObj.LastCol(),0);
			sheetObj.SetCellFont("FontItalic", idx, 1, idx, sheetObj.LastCol(),0);
			sheetObj.SetCellValue(idx,"amdt_seq",sheetObj.GetCellValue(idx2, "amdt_seq"),0);
//			sheetObj.CellValue2(idx,"ibflag") = "U";
			sheetObj.SetRowStatus(idx,"U");
			//sheetObj.RowEditable(idx) = true;
			sheetObj.SetCellValue(idx2,"amdt_seq",pre_amdt_seq,0);
//			sheetObj.CellValue(idx2,"ibflag") = "R";
			sheetObj.SetRowStatus(idx2,"R");
			sheetObj.SetRowEditable(idx2,0);
			//sheetObj.RowHidden(idx2) = true;
			sheetObj.RowDelete(idx2, false);
			//sheetObj.SelectCell(idx,"chk");
		}
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
		return true;
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
     * @version 2009.08.18
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
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
     * @version 2009.08.18
     */
  	function sheet1_OnSearchEnd(sheetObj, errMsg) {
  		if (errMsg == "") {
  			var formObj=document.form;
 			setSheetDisplay(sheetObj);
// 			rtnValue = sheetObj.CellValue(sheetObj.LastRow, "dmdt_ft_tp_cd");
 		}
 	}   
	/**
     * calling function when occurring OnSaveEnd event <br>
     * Showing saving confirmation message <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.08.18
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			var formObj=document.form;
			setSheetDisplay(sheetObj);
			if(!opener) opener = parent;
			opener.comUpdateProposalStatusSummary("08", "");
			rtnValue="Y";
		}
	}
    /**
     * Running funciton when loading page<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns void
     * @author 
     * @version 2009.08.18
     */ 
     function pageOnLoadFinish() {
     	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     	buttonControl();
    }
    /**
     * setting sheet's attribute function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.08.18
     */ 
    function setSheetDisplay(sheetObj) {
 		var formObj=document.form;
 		var amdtSeq=formObj.amdt_seq.value;
 		var effDt=formObj.eff_dt.value;
 		var propStsCd=formObj.prop_sts_cd.value;
 		var aproUsrFlg=form.apro_usr_flg.value;
 		var rCnt=sheetObj.RowCount();
 		if(amdtSeq == 0) {
 			return;
 		}
 		for(var i=1 ; i<=rCnt; i++) {
 			if(sheetObj.GetCellValue(i ,"amdt_seq") != amdtSeq) { // Strikeout, not editable
  				sheetObj.SetCellFont("FontStrike", i, "dmdt_ft_tp_cd", i, "src_info_cd",1);
 				continue;
 			}
 			if(sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") != amdtSeq) { //Not Amended row is Non-Editable, but Checkable
 				sheetObj.SetRowEditable(i,0);
 				continue;
 			}
  			sheetObj.SetCellFont("FontColor", i, "dmdt_ft_tp_cd", i, sheetObj.LastCol(),"#FF0000");// RED
 		}
 	}
	/**
	 * Controlling button's authority<br>
	 * controlling buttons <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		buttonControl()
	 * </pre>
	 * @return void
	 * @author 
	 * @version 2009.08.18
	*/
	function buttonControl(){
		var formObj=document.form;
		var req_usr_flg=formObj.req_usr_flg.value;
		var apro_usr_flg=formObj.apro_usr_flg.value;
		var amdt_seq_Count=formObj.amdt_seq.value;
		var sts=formObj.prop_sts_cd.value;
		var rCnt=sheetObjects[0].RowCount();
		try {			
			ComBtnEnable("btn_retrieve");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_amend");
			ComBtnDisable("btn_amendcancel");
			ComBtnDisable("btn_accept");
			ComBtnDisable("btn_acceptcancel");
			if(amdt_seq_Count > 0){
				showButton("btn_amend");
				showButton("btn_amendcancel");
				ComBtnDisable("btn_amendcancel");
				ComBtnDisable("btn_amend");
			} else {
//				hiddenButton("btn_amend");
//				hiddenButton("btn_amendcancel");
			}
			//alert("apro_usr_flg : "+apro_usr_flg+" | req_usr_flg : "+req_usr_flg);
			switch (sts) {
				case 'I':   // Initial
					if(apro_usr_flg == "true" || req_usr_flg == "true" ) {
						ComBtnEnable("btn_save");
						ComBtnEnable("btn_amend");
						ComBtnEnable("btn_amendcancel");
					}					
					break;
				case 'Q':   // Requested
					if(apro_usr_flg == "true" ){
						ComBtnDisable("btn_save");
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
						ComBtnDisable("btn_amend");
						ComBtnDisable("btn_amendcancel");
					}
					break;
				case 'R':   // Returned
					if(apro_usr_flg == "true") {
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
					} else if(req_usr_flg == "true") {
						ComBtnEnable("btn_accept");
					}
					ComBtnDisable("btn_amend");
					ComBtnDisable("btn_amendcancel");
					break;
				case 'P':   // Approved
				case 'F':   // Filed
				case 'C':   // Canceled
					break;		
			}	
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (object) formObj Mandatory Form Object
     * @param (string) sAction Mandatory  
     * @return void
     * @author 
     * @version 2009.08.18
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	    	case IBSEARCH: // retrieving			
				if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				}
				return true;
				break;
			case MODIFY01:	//Accept
	    		if(!ComShowCodeConfirm('PRI00008')) {
					return false;
				}
				return true;
				break;
			case MODIFY02:	//Accept Cancel
	    		if(!ComShowCodeConfirm('PRI00009')) {
					return false;
				}
				return true;
				break;
    	}	
		return true;
   	}
