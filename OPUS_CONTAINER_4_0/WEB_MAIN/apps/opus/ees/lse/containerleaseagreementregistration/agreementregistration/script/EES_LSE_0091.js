/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0091.js
*@FileTitle  : Agreement No. Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ees_lse_0091 : business script for ees_lse_0091
     */
   	/* developer job */
	// common global variables
	// Sheet Object Array
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	var strMultiChk = "";
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		/**********/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var comboObject1=comboObjects[0];
        var formObj=document.form;
        try {
        	var srcName=ComGetEvent("name");
        	switch(srcName) {
        		case "btn_OK":
        			if(strMultiChk == "Y") {
        				comPopOK(sheetObject1,formObj);
        			}else{
        				comPopupOK();
        			}
        			break;
        		case "btn_Close":
        			ComClosePopup(); 
        			break;
        		case "btn_New":
        			ComResetAll();
        			comboObjects[0].SetSelectText("ALL");// Initial Setting
        			break;
        		case "btn_Office":
        			openPopup("1");
        			break;
        		case "btn_Retrieve":
        			doActionIBSheet(sheetObject1,formObj,IBSEARCH);
        			break;
        	} // end switch
        } catch(e) {
        	if( e == "[object Error]") {
        		ComShowMessage(OBJECT_ERROR);
        	} else {
        		ComShowMessage(e.message);
        	}
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
     * registering IBMultiCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++]=combo_obj;
	}
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
	 */
	function loadPage() {
		strMultiChk = document.form.multi_chk.value;
		
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
			initCombo(comboObjects[k], k+1);
		}
		/* initializing IBSheet */
		for( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		/* Axon Control Setting*/
		initControl();
		ComSetFocus(document.form.agmt_seq);
		sheet1_OnLoadFinish(sheet1);
	 }
	//Aregistering initial event
	function initControl() {
		var formObj=document.form;
		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
		//axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
		//axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키보드 입력할때
		//axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
	}
	/**
	 * handling event in case of keyboard
	 **/
//	function obj_keypress() {
//		var obj=event.srcElement;
//		switch(obj.dataformat) {
//	        case "ymd":
//	        case "ym":
//	        case "hms":
//	        case "hm":
//	        case "jumin":
//	        case "saupja":
//	        case "int":
//	            ComKeyOnlyNumber(obj);
//	            break;
//	        case "float":
//	            ComKeyOnlyNumber(obj, "-.");
//	            break;
//	        case "eng":
//	        	if ( obj.name == "ref_no" ) {
//	        		ComKeyOnlyAlphabet('num');
//	        	} else {
//	        		ComKeyOnlyAlphabet();
//	        	}
//	            break;
//	        case "engup":
//	        	ComKeyOnlyAlphabet('upper');
//	            break;
//	        case "engdn":
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        default:
//	            ComKeyOnlyNumber(obj);
//	        	break;
//	    }
//	}
	/**
	 * handling Location blur event
	 **/
	function obj_blur(){
	    switch(ComGetEvent("name")){
	        case "agmt_seq":
	            //checking number
	            ComChkObjValid(ComGetEvent(), true, false, false);
	            break;
	        default:
	            //checking Validation
	            ComChkObjValid(ComGetEvent());
	    }
	}
	/**
	 *  handling event in case of focus
	 **/
//	function obj_focus(){
//	    //deleting data unit separator
//	    ComClearSeparator(ComGetEvent());
//	}
  	/**
   	 * handling event in case of Key-Down
   	 */
//  	function obj_keydown() {
//  		var obj=event.srcElement;
//  		var vKeyCode=event.keyCode;
//  		var formObj=document.form;
//  		if ( vKeyCode == 13 ) {
//  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//  			formObj.agmt_seq.focus();
//  		}
//	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
 		var sheetID=sheetObj.id;
 		var strHeaderCheck = 0;
 		var strType = "Radio";
 		switch(sheetID) {
 			case "sheet1":
 			    with(sheetObj){
 				if(strMultiChk == "Y") {
 					strHeaderCheck = 1;
 					strType = "DummyCheck";
 				}
 		      var HeadTitle1=" | |AGMT NO.|OLD AGMT NO.|||Ref. No.|Term|Lessor|Lessor Name|Effective Date|Effective Date||||Contract No.|Created by|Date|Updated by|Date";
 		      var HeadTitle2=" | |AGMT NO.|OLD AGMT NO.|||Ref. No.|Term|Lessor|Lessor Name|From|To||||Contract No.|Created by|Date|Updated by|Date";
 		      var headCount=ComCountHeadTitle(HeadTitle1);

 		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

 		      var info    = { Sort:1, ColMove:1, HeaderCheck:strHeaderCheck, ColResize:1 };
 		      var headers = [ { Text:HeadTitle1, Align:"Center"},
 		                  { Text:HeadTitle2, Align:"Center"} ];
 		      InitHeaders(headers, info);

 		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
 		             {Type:strType,     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"radio",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		            {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"old_agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lse_free_dys",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"vndr_abbr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"lse_ctrt_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
 		       
 		      InitColumns(cols);
 		      //SetSheetHeight(270);
 		      ComResizeSheet(sheetObj);
 		      SetEditable(1);
 		   	  SetCountFormat("[SELECTDATAROW / TOTALROWS]");
 		      }
 				break;
 		}
	}
	/**
     * initializing IBMultiCombo
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "combo1":
	        	with(comboObj) {
	            	//BackColor = "cyan";
	            	SetDropHeight(250);
	            	SetMultiSelect(0);
	            	//MaxSelect = 1;
	            	SetUseAutoComplete(1);
	            	ValidChar(2,0);
	            }
	        	break;
	    }
	}
	/**
	 * handling process for Sheet
	 */
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg(false);
         switch(sAction) {
	         case IBCREATE:		//Lease Term Form Combo Item Setting
	         	sheetObj.SetWaitImageVisible(0);
	         	formObj.f_cmd.value=SEARCH01;
	 	         	var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
	            if ( sXml != "" ) {
	            	// "ALL" Item Insert
		            comboObjects[0].InsertItem(0,"ALL"," ");
		            LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		            comboObjects[0].SetSelectText("ALL");// Initial Setting
	            }
		        sheetObj.SetWaitImageVisible(1);
	            break;
         	case IBSEARCH:
         		if ( sheetObj.id == "sheet1") {
         			formObj.f_cmd.value=SEARCH;
         			ComOpenWait(true);
          			sheetObj.DoSearch("EES_LSE_0091GS.do",FormQueryString(formObj) );
         			ComOpenWait(false);
         		}
         		break;
            case IBSEARCHAPPEND:
         		if ( sheetObj.id == "sheet1") {
	            	formObj.f_cmd.value=SEARCH;
	            	ComOpenWait(true);
 	                sheetObj.DoSearch("EES_LSE_0091GS.do", CondParam+"&"+ "iPage=" + PageNo,{Append:true} );
 	               ComOpenWait(false);
         		}
                break;
         }
	}
	 	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		var vActFlg=formObj.h_agmt_act_flg.value;
		ComSetObjValue(formObj.agmt_act_flg, vActFlg);
		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}
	/**
	 * sheet1_OnScrollNext
	 */
 	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}
	/**
	 * combo1_OnChange
	 */
	function combo1_OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
		formObj.lstm_cd.value=comboObj.GetSelectCode();
	}
     /**
      * handing process Pop-up<br>
      * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
      * @param object
      * @param Row index
      */	
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		var formObj=document.form;
    		var sUrl='/opuscntr/COM_ENS_071.do';
			var iWidth=822;
			var iHeight=480;
			var sTargetObjList="ofc_cd:ofc_cd";
			var sDisplay="1,0,1,1,1,1,1,1";
			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
    	}
    }
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction) {
		return true;
	}
	
	
	function comPopOK(sheetObj,formObject) {
		var formObject=document.form;
		var checkRows;
		var rArray=null; //list containing row data
		var cArray=null; // list containing col data
		
		var hRow=sheetObj.HeaderRows();
		var checkYN ="N";
		var checkRows = 0;
		
		for (var row=hRow; row <= sheetObj.RowCount()+hRow; row++) {
			if(sheetObjects[0].GetCellValue(row,"radio") == 1){
				checkYN = "Y";
				checkRows += 1;
			}					
		}    
		
		if(checkYN == "N") {
			ComShowCodeMessage("MST00010"); 
			return;
		} else {
			var idx=0;
			var chkval="";
			rArray=new Array(checkRows);
			for(var i=hRow; i <= sheetObj.RowCount()+hRow; i++) {
				if(sheetObj.GetCellValue(i, "radio") == 1) {
					
					chkval=sheetObj.GetCellValue(i, 'agmt_no');
					
					rArray[idx++]=chkval;
					
				}
			}
		}
		
		parent.setPopData_MultiAgreement(rArray);  //호출하는 부모js에 getLse_Multi 붙여넣으면됩니다.
		ComClosePopup(); 
	}   
	/* end of developer job */
