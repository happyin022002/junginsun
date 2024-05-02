/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4024.js
*@FileTitle  : Exchange Rate Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_4024 : business script for ESM_PRI_4024  
     */
    // global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_Close":
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
    	 for (i=0; i < sheetObjects.length; i++) {
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i], i + 1);
  			ComEndConfigSheet(sheetObjects[i]);
  		}
    	 pageOnLoadFinish();
    }
    /**
     * calling function when Page Loading <br>
     */
    function pageOnLoadFinish() {
    	initControl();
    	document.form.from_acct_xch_rt_yrmon.value=ComGetNowInfo("ym");
	}
    /**
	 * loading HTML Control event in the page <br>
	 * initializing IBSheet Object calling from {@link #loadPage} function <br>
	 **/
	function initControl() {
		//DATE_SEPARATOR = "/";
		//Axon event handling 1. event catch
		//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		//axon_event.addListenerForm('blur', 'obj_blur', form);
		//axon_event.addListenerForm('focus', 'obj_focus', form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form'	);
	}
	/**
     * calling function when occurring OnKeyPress event <br>
     */
//	function obj_keypress(){
//		switch(ComGetEvent().dataformat){
//			case "int":
//		        //number only
//		        ComKeyOnlyNumber(ComGetEvent());
//				break;
//			case "float":
//		        //number + "."
//		        ComKeyOnlyNumber(ComGetEvent(), ".");
//				break;
//			case "eng":
//		        //english only
//	            ComKeyOnlyAlphabet("upper");
//	            break;
//			default:
//		        //number only
//		        ComKeyOnlyNumber(ComGetEvent());
//		}
//	}
	/**
     * calling function when occurring OnBlur event <br>
     */
  	function obj_blur() {
  		var obj=ComGetEvent();
  		 switch(ComGetEvent("name")) {
 			case "from_acct_xch_rt_yrmon":
 				ComChkObjValid(obj);
 				//ComGetEvent("dataformat")=ComGetMaskedValue(ComGetEvent("dataformat"), "ym");
 				break;
 			case "to_acct_xch_rt_yrmon":
 				ComChkObjValid(obj);
 				//ComGetEvent("dataformat")=ComGetMaskedValue(ComGetEvent("dataformat"), "ym");
 				break;
 			case "curr_cd":
 				var formObj=document.form;
 				formObj.f_cmd.value=COMMAND16; 	    			
 				var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+formObj.curr_cd.value);
 				var arrDesc=ComPriXml2Array(sXml, "cd|nm");
 				if (arrDesc == null) {
 					formObj.curr_cd.value="";
 				}
 				break;	
 		} 
  	}
  	/**
     * calling event when occurring OnFocus event <br>
     */
   	function obj_focus() {
   		srcName=ComGetEvent();
  		srcValue=ComGetEvent();
  		switch(srcName) {
  			case "from_acct_xch_rt_yrmon":
  				ComClearSeparator(ComGetEvent(), "ym");
  				ComGetEvent().select();
  				break;
  			case "to_acct_xch_rt_yrmon":
  				ComClearSeparator(ComGetEvent(), "ym");
  				ComGetEvent().select();
  				break;
  		} 
   	}
   	
   	/**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with(sheetObj){
               
              var HeadTitle1="Seq.|Year/Month|Cur. Code|Description|Account Rate|Account Rate|Account Rate|Creation\nDate|Updated\nDate";
              var HeadTitle2="Seq.|Year/Month|Cur. Code|Description|USD(LOCAL)|LOCAL(KRW)|USD(KRW)|Creation\nDate|Updated\nDate";
              (9, 0, 0, true);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   Sort:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"acct_xch_rt_yrmon",  KeyField:0,   CalcLogic:"",   Format:"ym",          PointCount:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"curr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"usd_locl_xch_rt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4 },
                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"locl_krw_xch_rt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4 },
                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"usd_krw_xch_rt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4 },
                     {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
                     {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 } ];
               
              InitColumns(cols);
              resizeSheet();//SetSheetHeight(440);
              SetEditable(0);
              SetWaitImageVisible(0);
              SetAutoRowHeight(0);
              }
			break;
        case "sheet2":
            with(sheetObj){
        	 sheetObj.SetVisible(false);
        }
//          var HeadTitle="";
//          }
//          SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
//          var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
//          var headers = [ { Text:HeadTitle, Align:"Center"} ];
//          InitHeaders(headers, info);
//          var cols = [  ];         
//          InitColumns(cols);
//           break;
        }
    }
    function resizeSheet(){ ComResizeSheet(sheetObjects[0]); }
    
    function sheet1_OnSort(sheetObj ,Col, SortArrow){
    	sheetObj.ReNumberSeq();   
    	 }
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:
        		ComOpenWait(true);
        		if (!validateForm(sheetObj, formObj, sAction)) {
        			ComOpenWait(false);
        			return false;
	      		}
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_PRI_4024GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
				break;
        }
    }
    /**
     * checking validation process of inputed form data <br>
     */
	function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	if(!ComChkRequired(formObj)) return false;
        	if(!ComIsNull(to_acct_xch_rt_yrmon.value) && from_acct_xch_rt_yrmon.value > to_acct_xch_rt_yrmon.value) {
        		ComShowCodeMessage('PRI00305','Year/Month');
        		return false;
        	}
        }
        return true;
    }
