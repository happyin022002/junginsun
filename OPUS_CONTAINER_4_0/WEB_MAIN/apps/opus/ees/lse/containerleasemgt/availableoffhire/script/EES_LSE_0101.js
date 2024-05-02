/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0101.jsp
*@FileTitle  : Available Yard Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_LSE_0101 : business script for EES_LSE_0101
     */
   	/* developer job */
	// common global variables
	// Sheet Object Array
	var sheetObjects=new Array();
	var sheetCnt=0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		/**********/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
        try {
        	var srcName=ComGetEvent("name");
        	switch(srcName) {
        		case "btn_OK":
        			comPopupOK();
        			break;
        		case "btn_Close":
        			ComClosePopup(); 
        			break;
        		case "btn_New":
        			ComResetAll();
        			ComSetFocus(formObj.ofc_cd);
        			break;
        		case "btn_Retrieve":
        			doActionIBSheet(sheetObject1,formObj,IBSEARCH);
        			break;
        		case "btns_search":		//Office Code
	 				ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 755, 635, "ofc_cd:ofc_cd", "1,0,1,1,1,1,1,1", false);
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		/* Axon Control Setting*/
		initControl();
		ComSetFocus(document.form.ofc_cd);
	 }
	// registering initial event
	function initControl() {
		var formObj=document.form;
		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
//		axon_event.addListenerFormat('keydown',		'obj_keydown',	formObj); 
//		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj);
//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
		axon_event.addListenerFormat('change',   	'obj_change',  	formObj); 
	}
	/**
	 * handling event in case of Change
	 */
	function obj_change() {
		var obj=ComGetEvent();
		var formObj=document.form;
  		switch(ComGetEvent("name")) {
			case "ofc_cd":			//Office Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
				break;
		}
	}
	/**
	 * handling event in case of Key-Press
	 **/
	function obj_keypress() {
		var obj=ComGetEvent();
		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	        	ComKeyOnlyAlphabet();
	            break;
	        case "engup":
	        	if(obj.name == "yd_cd") {
		        	ComKeyOnlyAlphabet('uppernum');
	        	} else {
					ComKeyOnlyAlphabet('upper');
	        	}
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
	}
	/**
  	 * handling event in case of Key-Up
  	 */
  	function obj_keyup() {
  		var obj=ComGetEvent();
  		switch(ComGetEvent("name")) {
  			/*
  			case "yd_cd":
				if ( ComTrim(obj.value).length >= 2 ) {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
  			*/
  			default :
			  	ComKeyEnter('LengthNextFocus');
			  	break;
  		}
  	}
	/**
	 * handling Location blur event
	 **/
	function obj_blur(){
		var obj=ComGetEvent();
	    switch(ComGetEvent("name")){
	    	case "ofc_cd" :
				ComChkObjValid(obj, true);
	    		break;
	        default:
	            //checking Validation
	            ComChkObjValid(obj);
	            break;
	    }
	}
	/**
	 * handling event in case of focus
	 **/
	function obj_focus(){
	    //deleting data unit separator
	    ComClearSeparator(ComGetEvent());
	}
  	/**
   	 * handling event in case of Key-Down
   	 */
  	function obj_keydown() {
  		var obj=ComGetEvent();
  		var vKeyCode=event.keyCode;
  		var formObj=document.form;
  		if ( vKeyCode == 13 && obj.name != "ofc_cd" ) {
  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
  			ComSetFocus(formObj.ofc_cd);
  		}
	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
 		var sheetID=sheetObj.id;
 		switch(sheetID) {
 			case "sheet1":
 			    with(sheetObj){
	 		      if (location.hostname != "")
//	 		      var HeadTitle1="||Seq.|Handler|Office|STS|Description|Working Period|Working Period|Working Period|Date|User";
	 		     var HeadTitle1 = " | |Seq|Yard\nType|Node Code|Node Name|CTRL\nOffice|Vendor\nCode|Vendor Name|Yard Address|Inter.\nPhone|Phone No.|Fax No.|PIC Name|Email ADDR|Created by|Date|Updated by|Date";

	 				
	 		      var headCount=ComCountHeadTitle(HeadTitle1);
	
	 		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	 		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	 		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	 		      InitHeaders(headers, info);
	
                 var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                         {Type:"Radio",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"radio",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	 		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"yard_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:220,   Align:"Center",  ColMerge:1,   SaveName:"yd_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Date",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:220,   Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:340,   Align:"Center",  ColMerge:1,   SaveName:"yd_addr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intl_phn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"phn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"fax_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:130,   Align:"Center",  ColMerge:1,   SaveName:"yd_pic_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:220,   Align:"Center",  ColMerge:1,   SaveName:"yd_eml",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:80,    Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0,  Width:80,    Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	 		       
                 cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });

	 		      InitColumns(cols);
//	 		      SetEditable(0);
	 		      SetSheetHeight(462);
	 		      //ComResizeSheet(sheetObj);
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
         	case IBSEARCH:
         		if(validateForm(sheetObj, formObj, sAction)) {
	         		if ( sheetObj.id == "sheet1") {
	         			formObj.f_cmd.value=SEARCH;
 	         			sheetObj.DoSearch("EES_LSE_0101GS.do",FormQueryString(formObj) );
	         		}
         		}
         		break;
         	case IBSEARCH_ASYNC01:
				if(validateForm(sheetObj,formObj,sAction)) {
		        	var param="f_cmd="+SEARCH16+"&ofc_cd="+ComGetObjValue(formObj.ofc_cd);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "ofc_cd") != undefined ) {
							if ( ComGetEtcData(sXml, "ofc_cd") != "" ) {
								formObj.ofc_cd.value=ComGetEtcData(sXml, "ofc_cd") ;
								ComSetNextFocus(formObj.ofc_cd);
							}else{
								ComShowCodeMessage("LSE01035");
								formObj.ofc_cd.value="";
								ComSetFocus(formObj.ofc_cd);
							}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							formObj.ofc_cd.value="";
							ComSetFocus(formObj.ofc_cd);
						}
					}
				}
	        	break;
         }
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction) {
		switch (sAction) {
			case IBSEARCH:
				with(formObj) {
					/*
					if ( ComTrim(yd_cd.value).length < 2) {
						ComShowCodeMessage("LSE01006");
		                return false;
		            }
		            */
		            return ComChkValid(formObj);
				}
	            break;
		}
		return true;
	}
	/* end of developer job */
