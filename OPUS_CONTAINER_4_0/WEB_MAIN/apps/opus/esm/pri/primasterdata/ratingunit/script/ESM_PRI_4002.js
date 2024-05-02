/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4002.js
*@FileTitle  : Rating Unit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/

/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    // common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
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
     * @version 2009.08.12
     */
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
					break;
				case "btn_new":
					removeAll(document.form);
					comboObjects[0].SetSelectCode(-1);
					break;
				case "btn_downexcel":
					//sheetObjects[1].Down2Excel({ HiddenColumn:-1});
					if(sheetObject2.RowCount() < 1){//no data						
						ComShowCodeMessage("COM132501");
					}else{
						//sheetObject2.SetHeaderBackColor("#CCCCCC");
						sheetObject2.Down2Excel( {SheetDesign:1,Merge:1,CheckBoxOnValue:"Y",CheckBoxOffValue:"N" });
						//sheetObject2.SetHeaderBackColor("#333333");	
					}
                    break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
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
     * @version 2009.08.12
     */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
     * registering IBMultiCombo Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj Mandatory IBMultiCombo Object
     * @return void
     * @author 
     * @version 2009.08.12
     */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;		
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
     * @version 2009.08.12
     */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//Modify Environment Setting Function's name
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//Add Environment Setting Function
			ComEndConfigSheet(sheetObjects[i]);
		}
		// IBMultiCombo Initialize
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		pageOnLoadFinish();
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
     * @version 2009.08.12
     */
	 function initSheet(sheetObj,sheetNo) {
		 var cnt=0;
		 var sheetID=sheetObj.id;
		 switch(sheetID) {
		 case "sheet0":      //hidden 
			 with (sheetObj) {
	 		//setting Host information[Mandatory][HostIp, Port, PagePath]
		 		}
	 		break; 
	     case "sheet1":
	    	 with(sheetObj){
        	       var HeadTitle="Seq.|Unit|Description|Character|Size|SC/RFA Rate Only|Creation Date|Update Date|Delete Mark";

        	       SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

        	       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	       var headers = [ { Text:HeadTitle, Align:"Center"} ];
        	       InitHeaders(headers, info);

        	       var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
        	              {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd" },
        	              {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"rat_ut_desc" },
        	              {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_grp_cd" },
        	              {Type:"Combo",     Hidden:0, Width:250,  Align:"Center",  ColMerge:0,   SaveName:"cntr_sz_cd" },
        	              {Type:"CheckBox",  Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_use_ony_flg" },
        	              {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt" },
        	              {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt" },
        	              {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg" } ];
        	        
        	       	InitColumns(cols);
        	       	SetEditable(0);
        	       	SetWaitImageVisible(0);
        	       	//SetAutoRowHeight(0);
        	       	SetColProperty("rat_ut_grp_cd", {ComboText:ratUtGrpCdText, ComboCode:ratUtGrpCdValue} );
        	       	SetColProperty("cntr_sz_cd", {ComboText:cntrSzCdText, ComboCode:cntrSzCdValue} );
        	       	resizeSheet();//SetSheetHeight(462);
	         	}
                break;
         }
    }
	 function resizeSheet(){ ComResizeSheet(sheetObjects[1]); }
    /**
     * setting intial combo value <br>
     * adding case as numbers of counting combo<br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {int} comboNo Mandatory IBMultiCombo Object ,Serial no for Tag's ID
     * @return void
     * @author 
     * @version 2009.08.12
     */ 
	function initCombo(comboObj, comboNo) {
		switch (comboObj.options.id) {
	 		case "rat_ut_grp_cd":
	 			var i=0;
	 			with (comboObj) {
	 				//BackColor = "cyan";
	 				SetDropHeight(200);
	 				SetMultiSelect(0);
	 				SetMaxSelect(1);
	 				SetUseAutoComplete(1); 				
 			}
			break;
	  	}
	}
    /**
     * Setting retrieved items to IBMultiCombo<br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return void
     * @author 
     * @version 2009.08.12
     */
    function initIBComboItem() {
        ComPriTextCode2ComboItem(ratUtGrpComboValue, ratUtGrpComboText, getComboObject(comboObjects, 'rat_ut_grp_cd'),"|","\t");
    }
	/**
	 * Loading HTML control's event on page dynamically<br>
	 * <br><b>Example :</b>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return void
     * @author 
     * @version 2009.08.12
	 **/
	function initControl() {
		//** Date delimiter **/
		DATE_SEPARATOR="/";
		axon_event.addListenerForm('keypress', 'obj_keypress', form);
		//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	/**
     * calling function in case of OnKeyPress event <br>
     * Only specified characters could input on onkeypress event of HTML Control. <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.08.12
     */
	function obj_keypress() {
//		 switch (event.srcElement.name) {
//			case "rat_ut_cd":
//				ComKeyOnlyAlphabet('uppernum');
//				break;
//		}
		
		switch (ComGetEvent("dataformat")) {
	        case "engup":
	            if (ComGetEvent("name") == "rat_ut_cd") {
	                ComKeyOnlyAlphabet('uppernum');
	            } 
	            break;
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
     * @version 2009.08.12
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:
        	   ComOpenWait(true);
        	   formObj.f_cmd.value=SEARCH;
        	   sheetObj.DoSearch("ESM_PRI_4002GS.do", FormQueryString(formObj) );
        	   ComOpenWait(false);
        	   break;
         }
    }
 	/**
     * Reset Whole objects in screen <br>
     * <br><b>Example :</b>
     * <pre>
     *    removeAll(document.form)
     * </pre>
     * @param {object} formObj Mandatory Form Object
     * @return void
     * @author 
     * @version 2009.08.12
     */
 	function removeAll(formObj) {
		formObj.reset();
 		sheetObjects[1].RemoveAll();
	}
    /**
     * Running funciton when loading page<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @return void
     * @author 
     * @version 2009.08.12
     */ 
    //지원안함[확인요망]HANJIN: 
 	function pageOnLoadFinish() {
    	initControl();
    	initIBComboItem();  // Setting item to IBCombo
    }
