/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_027.js
*@FileTitle : Cost Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*/
/*  global variable ------------------------------------------------------------- */
var comboObjects=new Array();
var comboCnt=0;
var sheetObjects=new Array();
var sheetCnt=0;
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 * @param {ibsheet} sheet_obj 	IBSheet Object
	 * @return
	 */     
	function setSheetObject(sheet_obj){	
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * IBCombo Object adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 * @param {combo}	combo_obj	combo object
	 * @return
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
	 * @return
	 */
	function loadPage() {
	    for(i=0;i<sheetObjects.length;i++){
	    	ComConfigSheet (sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
        for(i=0;i< comboObjects.length;i++){
            initCombo (comboObjects[i],i+1);
        }
        document.form.lgs_cost_cd.focus();
	    tes_getComboItem('acct_cd', 1, SEARCHLIST06, '', '');
	    
	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	/****************************************************************************************
	  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
						[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
						character constant  COMMAND01=11; ~ COMMAND20=30;
	***************************************************************************************/
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	function processButtonClick(){
//		try {
			var srcName=ComGetEvent("name");
			with(document.form) {
				switch (srcName) {
					case "btn_retrieve":
						if(fnChkForm()){					
							retrieve();
						}
						break;
					case "btn_new":
						fncNew();
						break;
					case "btng_delete":
						deleteOk()
						break;
					case "btng_save":		
						if(fnChkForm(document.form.gb.value)){
							addOk();
//							if(document.form.gb.value=="ADD"){
//								addOk()
//								break;
//							} else if(document.form.gb.value=="MODIFY"){
//								modifyOk()
//								break;
//							}
						}											
						break;
//					case "btng_modify":										
//						if(document.form.lgs_cost_full_nm.value == null || document.form.lgs_cost_full_nm.value == "") {
//							ComShowMessage("Input cost abbr nm.");
//							document.form.lgs_cost_full_nm.focus();
//							return false;
//						}
//									
//						if(document.form.lgs_cost_abbr_nm.value == null || document.form.lgs_cost_abbr_nm.value == "") {
//							ComShowMessage("Input cost code.");
//							document.form.lgs_cost_abbr_nm.focus();
//							return false;
//						}
//
//						if(document.form.lgs_cost_opt_no.value == null || document.form.lgs_cost_opt_no.value == "") {
//							ComShowMessage("Input cost opt no.");
//							document.form.lgs_cost_opt_no.focus();
//							return false;
//						}				
//						
//						if (!ComIsNumber(document.form.lgs_cost_opt_no)){
//					 		  	ComShowMessage(ComGetMsg('TES15009'));
//					 		  	document.form.lgs_cost_opt_no.value="";
//					 		  	document.form.lgs_cost_opt_no.focus();
//					 		  	return false;				   					
//						}						
//					
//						if(fnChkForm()){
//							//openWindow("ESD_TES_9090.do?gb=MODIFY", "userpassword", "width=300,height=150,menubar=0,status=0,scrollbars=0,resizable=0");								
//							window.showModalDialog("ESD_TES_9090.do?openerUIName=027&gb=MODIFY", window, "dialogWidth:308px; dialogHeight:170px; help:no; status:no; resizable:no;");
//						}												
//						break;						
				} // end switch
			}// end with
//		} catch(e) {
//			if( e = "[object Error]") {
//				ComShowMessage(ComGetMsg('TES21025'));
//			} else {
//				ComShowMessage(e);
//			}
//		}
	}
	/**
	 * setting sheet initial values and header
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {int} sheetNo 	 
	 * 							adding case as numbers of counting sheets
	 * @return
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
        case 1: 
            with(sheetObj){
                      
          var HeadTitle="status|lgs_cost_cd|lgs_cost_full_nm|lgs_cost_subj_cd|lgs_cost_dtl_cd|lgs_cost_cd_clss_lvl|lgs_cost_opt_no|lgs_cost_abbr_nm|acct_cd|lgs_cost_rmk|thrp_flg|crr_acct_cd|delt_flg|cre_usr_id|cre_dt|upd_usr_id|upd_dt";

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"" },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_full_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_subj_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_dtl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd_clss_lvl",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_opt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"acct_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"thrp_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"crr_acct_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"delt_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);

          SetEditable(1);
          SetSheetHeight(240);
                }
        break;
        }
	 }
	/**
	 * set combo list
	 * @param {combo}	comboObj	combo object
	 * @param {int}		comboNo		combo index
	 * @param {array}	keyArr		key array
	 * @param {array}	valueArr	value array
	 * @return
	 */
	function initCombo( comboObj, comboNo, keyArr, valueArr ) {
		var cnt=0;
		switch (comboNo) {
		case 1:
			with (comboObj) {
			SetColAlign(0, "center");
			SetColWidth(0, "90");
				SetDropHeight(150);
				var key='';
				var val='';
				for ( var i=0; keyArr != undefined && keyArr != null && i < keyArr.length; i++) {
					if( keyArr[i]!=undefined && keyArr[i]!=null ) key=keyArr[i];
					else  key='';
					if( valueArr[i]!=undefined && valueArr[i]!=null ) val=valueArr[i];
					else  val='';
					InsertItem( cnt++, new String(key), new String(key) );
				}
			}
			break;
		}
	}	 
	/**
	 * Retrieve button click event
	 * @param 
	 * @return
	 */
	function retrieve(){
		var formObj=document.form;
		doActionSheet(sheetObjects[0], formObj, IBSEARCH);	
	}
	/**
	 * handling sheet process
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}		sAction		
	 * @return
	 */
	 function doActionSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg(false);
       switch(sAction) {
          case IBSEARCH:      //Retrieve
		    formObj.f_cmd.value=SEARCH;
//          	sheetObj.DoSearch4Post("ESD_TES_0027.do", tesFrmQryStr(formObj));
           	var arrXml=sheetObj.GetSearchData("ESD_TES_0027GS.do", tesFrmQryStr(formObj)).split("|$$|");
			for (var i=0; arrXml!=null && i<arrXml.length; i++) {
				sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
			}
//		    ComDebug(arrXml);		
		    break;
      }
   }
	 /**
	  * search end event
	  * @param {sheet}	sheet		ibsheet
	  * @param {string}	ErrMsg			error message
	  * @return
	  */
	function sheet_OnSearchEnd(sheet, ErrMsg) {
		var formObj=document.form;
		if (sheet.RowCount()== 1) {
			formObj.lgs_cost_cd.value=sheet.GetCellValue(1, "lgs_cost_cd");
			formObj.lgs_cost_cd.readOnly=true;
			formObj.lgs_cost_full_nm.value=sheet.GetCellValue(1, "lgs_cost_full_nm");
			formObj.lgs_cost_abbr_nm.value=sheet.GetCellValue(1, "lgs_cost_abbr_nm");
			formObj.lgs_cost_opt_no.value=sheet.GetCellValue(1, "lgs_cost_opt_no");
			acct_cd.SetSelectText(sheet.GetCellValue(1, "acct_cd"));
			formObj.crr_acct_cd.value=sheet.GetCellValue(1, "crr_acct_cd");
			formObj.lgs_cost_rmk.value=sheet.GetCellValue(1, "lgs_cost_rmk");
			formObj.lgs_cost_cd_clss_lvl.value=sheet.GetCellValue(1, "lgs_cost_cd_clss_lvl");
			formObj.lgs_cost_subj_cd.value=sheet.GetCellValue(1, "lgs_cost_subj_cd");
			formObj.lgs_cost_dtl_cd.value=sheet.GetCellValue(1, "lgs_cost_dtl_cd");
			formObj.cre_usr_id.value=sheet.GetCellValue(1, "cre_usr_id");
			formObj.cre_dt.value=sheet.GetCellValue(1, "cre_dt");
			formObj.upd_dt.value=sheet.GetCellValue(1, "upd_dt");
			formObj.gb.value='MODIFY';
		} else if (sheet.RowCount()< 1) {
			ComShowMessage(ComGetMsg('TES21017'));
			fncNew();
		}
	}
	/**
	 * main hidden sheet save end event
	 * @param {ibsheet}	sheet		sheet
	 * @param {string}	ErrMsg		error message
	 * @return
	 */	
	function sheet_OnSaveEnd(sheet, ErrMsg) {	
		if (sheet.RowCount()< 1) {
			fncNew();
		}
	}
	/**
	 * Validation check
	 * @param theForm
	 * @return
	*/
	function fnChkForm(tp) {
		if( tp == 'ADD' ){
			if(document.form.lgs_cost_cd.value == null || document.form.lgs_cost_cd.value == "") {
				ComShowMessage(ComGetMsg('TES15004'));
				document.form.lgs_cost_cd.focus();
				return false;
			}		
			if(document.form.lgs_cost_cd.value.length == 1 || document.form.lgs_cost_cd.value.length == 3 || document.form.lgs_cost_cd.value.length == 5) {							
				ComShowMessage(ComGetMsg('TES15005'));
				document.form.lgs_cost_cd.focus();
				return false;
			}	
			var chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        for (var inx=0; inx < document.form.lgs_cost_cd.value.length; inx++) {
	           if (chars.indexOf(document.form.lgs_cost_cd.value.charAt(inx)) == -1) {
	            	ComShowMessage(ComGetMsg('TES15003'));
	            	document.form.lgs_cost_cd.value="";
	            	document.form.lgs_cost_cd.focus();
	               return false;
	           } // end if
	        } // end for						 
			if(document.form.lgs_cost_full_nm.value == null || document.form.lgs_cost_full_nm.value == "") {
				ComShowMessage(ComGetMsg('TES15006'));
				document.form.lgs_cost_full_nm.focus();
				return false;
			}
			if(document.form.lgs_cost_abbr_nm.value == null || document.form.lgs_cost_abbr_nm.value == "") {
				ComShowMessage(ComGetMsg('TES15007'));
				document.form.lgs_cost_abbr_nm.focus();
				return false;
			}
			if(document.form.lgs_cost_opt_no.value == null || document.form.lgs_cost_opt_no.value == "") {
				ComShowMessage(ComGetMsg('TES15008'));
				document.form.lgs_cost_opt_no.focus();
				return false;
			}		
			if (!ComIsNumber(document.form.lgs_cost_opt_no)){
		 		  	ComShowMessage(ComGetMsg('TES15009'));
		 		  	document.form.lgs_cost_opt_no.value="";
		 		  	document.form.lgs_cost_opt_no.focus();
		 		  	return false;				   					
			}	
		} else if( tp == 'MODIFY') {
			if(document.form.lgs_cost_full_nm.value == null || document.form.lgs_cost_full_nm.value == "") {
				ComShowMessage("Input cost abbr nm.");
				document.form.lgs_cost_full_nm.focus();
				return false;
			}
			if(document.form.lgs_cost_abbr_nm.value == null || document.form.lgs_cost_abbr_nm.value == "") {
				ComShowMessage("Input cost code.");
				document.form.lgs_cost_abbr_nm.focus();
				return false;
			}
			if(document.form.lgs_cost_opt_no.value == null || document.form.lgs_cost_opt_no.value == "") {
				ComShowMessage("Input cost opt no.");
				document.form.lgs_cost_opt_no.focus();
				return false;
			}				
			if (!ComIsNumber(document.form.lgs_cost_opt_no)){
	 		  	ComShowMessage(ComGetMsg('TES15009'));
	 		  	document.form.lgs_cost_opt_no.value="";
	 		  	document.form.lgs_cost_opt_no.focus();
	 		  	return false;				   					
			}				
		} else if( tp =='REMOVE') {
			if(document.form.lgs_cost_cd.value == null || document.form.lgs_cost_cd.value == "") {
				ComShowMessage(ComGetMsg('TES15001'));
				document.form.lgs_cost_cd.focus();
				return false;
			}
			if(document.form.lgs_cost_cd.value.length == 1 || document.form.lgs_cost_cd.value.length == 3 || document.form.lgs_cost_cd.value.length == 5) {							
				ComShowMessage(ComGetMsg('TES15002'));
				document.form.lgs_cost_cd.focus();
				return false;
			}	
			var chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        for (var inx=0; inx < document.form.lgs_cost_cd.value.length; inx++) {
	           if (chars.indexOf(document.form.lgs_cost_cd.value.charAt(inx)) == -1) {
	            	ComShowMessage(ComGetMsg('TES15003'));
	            	document.form.lgs_cost_cd.value="";
	            	document.form.lgs_cost_cd.focus();
	               return false;
	           } // end if
	        } // end for	
		} else {	//Retrieve
			if(document.form.lgs_cost_cd.value == null || document.form.lgs_cost_cd.value == "") {
				ComShowMessage(ComGetMsg('TES15004'));
				document.form.lgs_cost_cd.focus();
				return false;
			}			
		}
		return true;
	}
	/**
	 * delete
	 * @return
	 */
	function deleteOk(){	
		var formObj=document.form;
		formObj.f_cmd.value=REMOVE;
 		var sSaveXml=sheetObjects[0].GetSaveData( "ESD_TES_0027GS.do", sheetObjects[0].GetSaveString(false, false) + '&' + tesFrmQryStr(formObj));
 		sheetObjects[0].LoadSaveData(sSaveXml);
		fncNew();		
	}
	/**
	 * Input
	 * @return
	 */
	function addOk(){	
		var formObj=document.form;
		formObj.f_cmd.value=ADD;
 		var sXml=sheetObjects[0].GetSaveData( "ESD_TES_0027GS.do", tesFrmQryStr(formObj) + '&' + sheetObjects[0].GetSaveString(false, false));
		var arrXml=sXml.split("|$$|"); 
		for (var i=0; arrXml!=null && i<arrXml.length; i++) {
			sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
		}			
	}
	/**
	 * @return
	 */
	function addNo(){	
		document.form.lgs_cost_cd.value="";
		document.form.lgs_cost_cd.focus();
		ComShowMessage(ComGetMsg('TES90101'));		
	}	
	/**
	 * Update
	 * @return
	 */
	function modifyOk(){
		var formObj=document.form;
		formObj.f_cmd.value=MODIFY;
 		var sXml=sheetObjects[0].GetSaveData( "ESD_TES_0027GS.do", sheetObjects[0].GetSaveString(false, false) + '&' + tesFrmQryStr(formObj));
		var arrXml=sXml.split("|$$|"); 
		for (var i=0; arrXml!=null && i<arrXml.length; i++) {
			sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
		}		
	}
	/**
	 * set [Cost Class], [Subject Code], [Detail Code]
	 * @return
	 */
	function autowrite(){
		document.form.lgs_cost_cd.value=document.form.lgs_cost_cd.value.toUpperCase();
		document.form.lgs_cost_subj_cd.value=document.form.lgs_cost_cd.value.substring(0,2).toUpperCase();
		document.form.lgs_cost_dtl_cd.value=document.form.lgs_cost_cd.value.substring(0,4).toUpperCase();
		var cost_cd_len=0;
		cost_cd_len=document.form.lgs_cost_cd.value.length;
		if(cost_cd_len==2){
			document.form.lgs_cost_cd_clss_lvl.value="S";
		}
		else if(cost_cd_len==4) {
			document.form.lgs_cost_cd_clss_lvl.value="D";
		}
		else if(cost_cd_len==6){
			document.form.lgs_cost_cd_clss_lvl.value="A";
		}
		else{
			document.form.lgs_cost_cd_clss_lvl.value="";
		}		
		sheetObjects[0].SetCellValue(2,"lgs_cost_cd",document.form.lgs_cost_cd.value,0);
	}
	/**
	 * Sync sheet data
	 * @param {object} obj	text box
	 * @return
	 */
	function syncData(obj){
		//eval( "sheetObjects[0].SetCellValue(1,'"+obj.name+"','"+obj.value+"'" ),0);
		sheetObjects[0].SetCellValue(1, obj.nam, obj.value);
	}
	/**
	 * Sync sheet data
	 * @param {object} obj	text area
	 * @return
	 */
	function syncDataRmk(obj){
		sheetObjects[0].SetCellValue(1,"lgs_cost_rmk",obj.value,0);
	}
	/**
	 * acct cd change event
	 * @param {int}		Index_Code	index
	 * @param {string}	Text		code value
	 * @return
	 */
	function acct_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
		var formObj=document.form;
		var sheet=sheetObjects[0];
		if (sheet.RowCount()== 1) {
			sheet.SetCellValue(1,"acct_cd",acct_cd.GetSelectCode(),0);
		}
	}
	 /**
	  * @return
	  */
	function fncNew(){
		sheetObjects[0].RemoveAll();
		document.form.reset();
		document.form.lgs_cost_cd.readOnly=false;
		document.form.lgs_cost_cd.focus();
		tes_getComboItem('acct_cd', 1, SEARCHLIST06, '', '');
	}
