/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2077.js
*@FileTitle  : RFA Guideline Creation - Rate(Route Point)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
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
     * @class Commodity Group :business script for Commodity Group 
     */
    function ESM_PRI_2077() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	//this.onbeforeunload = onBeforeUnload;
    }
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
//current selected Route Point's index 
 var currentSheet=1; 
 var enableFlag=true;
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
  * @version 2009.08.10
  */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];          
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
	            case "btn_Ok":
	            	if (enableFlag && validateForm(sheetObject1,formObject,IBSAVE)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						//window.returnValue="O";
						//ComClosePopup();
						ComPopUpReturnValue("O");
	            	}	            	
	                break;
	            case "btn_Close":
	            	if (getSheetModify()){
	            		if(ComShowCodeConfirm("PRI00006")){
	            			if (enableFlag && validateForm(sheetObject1,formObject,IBSAVE)) {
	            				doActionIBSheet(sheetObject1,formObject,IBSAVE);
	            				//window.returnValue="O";
	            				//ComClosePopup();
	            				ComPopUpReturnValue("O");
	            			}else{
	            				return;
	            			}
	            		}
	            	}	
	            	ComClosePopup(); 
	                break;
	            case "btn_RowAdd":
					if (enableFlag && validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;
	            case "btn_RowDel":
					if (enableFlag && validateForm(sheetObject1,formObject,IBDELETE)) { 
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;
				case "rt_pnt":
					radio_click();
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
     * @version 2009.08.10
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
     * @version 2009.08.10
     */
     function loadPage() {    	 
    	 initControl();
    	 setSearchCondition()
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             sheetObjects[i].SetWaitImageVisible(0);
             ComEndConfigSheet(sheetObjects[i]);
         }         
         doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
 		if (document.form.isEditable.value == "false") {
			sheetObjects[0].SetEditable(0);
			disableButton("btn_RowAdd");
			disableButton("btn_RowDel");
		}
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
     * @version 2009.08.10
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
         case "sheet1":   // visible sheet
	         with(sheetObj){
	
			   var HeadTitle="|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|Term|Trans Mode";
			   var headCount=ComCountHeadTitle(HeadTitle);
			
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
			
			   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Combo",     Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			{Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			    
			   InitColumns(cols);
			
			   SetEditable(1);
			   //conversion of function[check again]CLT 	                InitDataValid(0,  "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");       // Uppercase characters Only
			   SetColProperty(0 ,"rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			   SetShowButtonImage(2);
			   resizeSheet(); //SetSheetHeight(180);
			   }
			   break;
         case "sheet2":	// Route Point Origin sheet
			   with(sheetObj){
			
			var HeadTitle="|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|Term|Trans Mode";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			resizeSheet(); //SetSheetHeight(100);
         	}
			break;

         case "sheet3":	// Route Point Origin Via sheet
			with(sheetObj){
			
			
			var HeadTitle="|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			resizeSheet(); //SetSheetHeight(100);
         	}
			break;

         case "sheet4":	// Route Point Destination Via sheet
			with(sheetObj){
			
			var HeadTitle="|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			resizeSheet(); //SetSheetHeight(100);
         	}
			break;

         case "sheet5":	// Route Point Destination sheet
			with(sheetObj){
			
			var HeadTitle="|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|Term|Trans Mode";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			resizeSheet(); //SetSheetHeight(100);
         	}
			break;
         }
     }
     
     function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
        ComResizeSheet(sheetObjects[1]);
        ComResizeSheet(sheetObjects[2]);
        ComResizeSheet(sheetObjects[3]);
        ComResizeSheet(sheetObjects[4]);
        
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
     * @version 2009.08.10
     */
      function doActionIBSheet(sheetObj,formObj,sAction) {
         try {
//             if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
//                 ComOpenWait(true);
//             }
	          sheetObj.ShowDebugMsg(false);
	          switch(sAction) {
	 			case IBCLEAR: 
	 				var sXml="";
	 				var radioObj=formObj.rt_pnt;
					//common - type
	 				sheetObj.SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE2[1] , ComboCode:LOCATION_TYPE2[0]} );
	         		formObj.f_cmd.value=COMMAND13;
	         		// Common term, trans mode
	         		var param="";
	         		param="CD02070:N";//Origin
					if(radioObj[3].checked == true){
						param="CD02071:N";  //Destination
					}
					param += ":CD01720:N"
	         		formObj.cd.value=param;// "Y" When the name is code or desc          		
 	 				sXml=sheetObj.GetSearchData("PRICommonGS.do" , FormQueryString(formObj));
	 				var arrXml=sXml.split("|$$|");
	 				if ( arrXml[0] != null)	setIBCombo(sheetObj,arrXml[0],"rcv_de_term_cd",false,0,"Y");
	 				if ( arrXml[1] != null)	setIBCombo(sheetObj,arrXml[1],"prc_trsp_mod_cd",true,0);			
	 				break;
				case IBSEARCH:      //Retrieving
					var sXml="";
					//Getting sheet data from main page
					for (var i=4; i < 8; i++){
						sXml=window.parent.getSheetXml(i);
						sheetObjects[i-3].LoadSearchData(sXml,{Sync:1} );
					}
					//Copying hidden sheet's tosheet on a screen            			
					if (sheetObjects[currentSheet].RowCount() != 0){
						sheetToSheet(sheetObjects[currentSheet],sheetObjects[0]);
					}				
					//Hiding column
					setGetColHidden();
		         	break; 				
	 			case IBINSERT:      // Insert
	 		        var idx=sheetObj.DataInsert();
					sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
					sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
					sheetObj.SetCellValue(idx, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
					sheetObj.SetCellValue(idx, "rout_seq",formObj.rout_seq.value);
					var radioObj=document.form.rt_pnt;
					var tpCd="O";
			  		//Selected radio button
			  		for (var i=0; i < 4 ; i++){
			  			if (radioObj[i].checked == true ){
			  				if (i == 2 || i == 3){
			  					tpCd="D";
			  				}
			  				
			  				if (i == 0 || i == 3){
			  					sheetObj.SetCellValue(idx, "rcv_de_term_cd", "CY");
			  				}
			  			}
			  		}
					sheetObj.SetCellValue(idx, "org_dest_tp_cd",tpCd);
					sheetObj.SetCellValue(idx, "rout_pnt_seq",parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1);
					sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd", false);
	 				break;
	 			case IBDELETE: // Delete
	 	        	if (sheetObj.CheckedRows("chk") <= 0) {
	 	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	 	        	}
	 				deleteRowCheck(sheetObj, "chk");
	 				break;
				case IBSAVE:        		
					var sXml="";
		      	  	sheetToSheet(sheetObjects[0],sheetObjects[currentSheet]);
					for (var i=1; i < 5; i++){
						//Transmitting data to main page after ordering
						if (i == 1 || i == 4){
							sheetObjects[i].ColumnSort("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd","ASC","ASC|ASC");
						} else {
							sheetObjects[i].ColumnSort("rout_via_port_tp_cd|rout_via_port_def_cd","ASC","ASC|ASC");
						}
						var sXml=ComPriSheet2Xml(sheetObjects[i]);
						window.parent.setSheetXml(sXml, i+3);
					}
		            break; 				
	          }
         } catch (e) {
             if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         } finally {
         	ComOpenWait(false);
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
       * @version 2009.08.10
       */
      function validateForm(sheetObj,formObj,sAction){
     	  switch (sAction) {
 	  		case IBSEARCH: // retrieving			
 				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				} else {
 					return true;
 				}
 				break;    	  
     	  	case IBSAVE: // Saving
 				if (sheetObjects[0].IsDataModified()) {
	 		  		var sParamSheet1=sheetObjects[0].GetSaveString();
	 		  		if (sParamSheet1 == ""){
	 		  			return ; 		  			
	 		  		} 					
 					var rowM=sheetObjects[0].ColValueDup("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rcv_de_term_cd|prc_trsp_mod_cd");
 					if (rowM >= 0) {
 						ComShowCodeMessage("PRI00303", "Sheet", rowM);
 					    return false;
 				    }
 				}
 				break;
     		case IBINSERT: // Row Add
     			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
     				return false;
     			} else {
     				return true;
     			}
     			break;
     		case IBDELETE: // Delete
     			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
     				return false;
     			} else {
     				return true;
     			}
     			break;
     	  }
          return true;
      }
      /**
       * Handling Axon event for radio butotn <br>
       * <br><b>Example :</b>
       * <pre>
       *     initControl()
       * </pre>
       * @param  void
       * @returns void
       * @author 
       * @version 2009.08.10
       */ 	 
  	function initControl() {
  	    // Process Axon Event No.1, Event Catch 
  	    //axon_event.addListener('click', 'radio_click', 'rt_pnt');
  	}
    /**
    * calling function in case of Clicking radio button <br>
    * <br><b>Example :</b>
    * <pre>
    *     
    * </pre>
    * @param  void
    * @returns void
    * @author 
    * @version 2009.08.10
    */ 	
  	function radio_click()
  	{
  		var radioObj=document.form.rt_pnt;
  		var hiddenVal=false;
  		var idx=1 ;
  		// Prohibiting from moving to other route point without validation
  		if(validateForm(sheetObjects[0],document.form,IBSAVE)!=true){
  			radioObj[currentSheet-1].checked=true;
  			return ;
  		}  	  		
  		//Setting data on current working screen to hidden sheet
  	  	sheetToSheet(sheetObjects[0],sheetObjects[currentSheet]);
  		//Selected radio button
  		for (i=0; i < 4 ; i++){
  			if (radioObj[i].checked == true ){
  				idx=i + 1;
  				currentSheet=idx;
  			}
  		}
  		//Showing or Not showing according to radio button
  		setGetColHidden();
  		//Load hieedn sheet's data to sheet on screen
  		changeCombo();
  		sheetToSheet(sheetObjects[idx],sheetObjects[0]);
  	}         
    /**
     * Function to modify term's combo by Route Point<br>
     * <br><b>Example :</b>
     * <pre>
     *     	changeCombo()
     * </pre>
     * @param  void
     * @returns void
     * @author 
     * @version 2009.08.10
     */ 	   
    function changeCombo(){
    	var radioObj=document.form.rt_pnt;
		// Term shall be different in Origin case and Destination case 
		if (radioObj[0].checked){
			document.form.cd.value="CD02070";
		}else if (radioObj[3].checked){
			document.form.cd.value="CD02071";
		}
		if (radioObj[0].checked || radioObj[3].checked){
			// Common term
			document.form.f_cmd.value=SEARCH19;
 			var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(document.form));
			setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true, 0, "Y");
		}
    }
     /**
      * calling function in case of clicking radio button<br>
      * showing or not showing sheet
      * <br><b>Example :</b>
      * <pre>
      *     	setColHidden()
      * </pre>
      * @param  void
      * @returns void
      * @author 
      * @version 2009.08.10
      */ 	   	 
   	function setGetColHidden()
   	{
   		var radioObj=document.form.rt_pnt;
   		var hiddenVal=false;
   		var idx=1;
  		//Selected radio button
  		for (i=0; i < 4 ; i++){
  			if (radioObj[i].checked == true ){
  				idx=i + 1;
  			}
  		}
  		if (idx == 2 || idx == 3){
  			hiddenVal=true;
  			//sheetObjects[0].InitDataProperty(0, 12, dtCombo, 90, daCenter, false, "rcv_de_term_cd",  false, "",	dfNone,	0,	true,	true);
  			//sheetObjects[0].SetColProperty("rcv_de_term_cd", {ComboText:"|"+vInitDataComboName, ComboCode:"|"+sVal} );
  		} else {
  			hiddenVal=false;
  			//sheetObjects[0].InitDataProperty(0, 12, dtCombo, 90, daCenter, false, "rcv_de_term_cd",  true, "",	dfNone,	0,	true,	true);
  			//sheetObjects[0].SetColProperty("rcv_de_term_cd", {ComboText:"|"+vInitDataComboName, ComboCode:"|"+sVal} );
  		}
		sheetObjects[0].SetColHidden("rcv_de_term_cd", hiddenVal);
		sheetObjects[0].SetColHidden("prc_trsp_mod_cd", hiddenVal);
   	}   	
     /**
	    * calling function in case of transmitting datas between sheets<br>
	    * Moving all data of sheet and deleting original sheet's data <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *		sheetToSheet (sheetObj1, sheetObj2)
	    * </pre>
	    * @param {ibsheet} sheetObj1 Mandatory, IBSheet Object to be transmitted  
	    * @param {ibsheet} sheetObj2 Mandatory ,IBSheet Object to be loaded(hidden)
	    * @return void
	    * @author 
	    * @version 2009.08.10
	    */  	 	 
   	function sheetToSheet (sheetObj1, sheetObj2){
   		//Making sheetObj1 data to RetrievingXML
   		if (sheetObj1.RowCount() != 0 ){
   	   		var sXml=ComMakeSearchXml(sheetObj1, true, "","",true)
   	   		//Load RetrievingXML to sheetObj2
   	   		if (sXml !=""){
   	   			sheetObj2.LoadSearchData(sXml,{Sync:1} );
   	   			if ( sheetObj2 == sheetObjects[0]){
   	   				sheetGetRowHidden(sheetObj2);
   	   			}
   	   		}	
   		}
   	}
 	 /**
 	    * Function which re-hiding sheet after transmitting deleted rows between sheets<br>
 	    * Transmitting data between sheet
 	    * <br><b>Example :</b>
 	    * <pre>
 	    * 		sheetRowHidden (sheetObj)
 	    * </pre>
 	    * @param {ibsheet} sheetObj mandatory IBSheet Object
 	    * @return void
 	    * @author 
 	    * @version 2009.08.10
 	    */   	 
 	function sheetGetRowHidden(sheetObj){
		for (i = sheetObj.RowCount(); i > 0; i-- ){
if (sheetObj.GetCellValue( i, "ibflag") == "D" ){
				sheetObj.SetRowHidden(i,1);
			}
   		}	
 	}
     /**
 	    * Calling Function in case of OnChange event <br>
 	    * showing Description<br>
 	    * <br><b>Example :</b>
 	    * <pre>
 	    *
 	    * </pre>
 	    * @param {ibsheet} sheetObj mandatory IBSheet Object
 	    * @param {int} Row mandatory Onclick ,Cell's Row Index
 	    * @param {int} Col mandatory Onclick ,Cell's Column Index
 	    * @param {string} Value Mandatory Value
 	    * @return void
 	    * @author 
 	    * @version 2009.08.10
 	    */  	    
     function sheet1_OnChange(sheetObj, Row, Col, Value)
     {
     	var colname=sheetObj.ColSaveName(Col);
     	var formObj=document.form
     	switch(colname)
     	{
 	    	case "rout_pnt_loc_def_cd":
 	    		if (Value.length == 5) {
 	    			formObj.f_cmd.value=SEARCH05; 	    			
 	    			formObj.cd.value=sheetObj.GetCellValue(Row,Col);
 	    			var param="&nm=rg&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.gline_seq.value;	
 			  		for (var i=0; i <= 3; i++) {
 			  			if (formObj.rt_pnt[i].checked == true) {
 			  				if (i == 0) {
 			  					param += "&etc4=O";
 			  				} else if (i == 3) {
 			  					param += "&etc4=D";
 			  				}
 			  			}
 			  		}
 	 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
	 				var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
	 				if (arrDesc != null && arrDesc.length > 0) {
	 					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm",arrDesc[0][1],0);
	 					sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","L" ,0);
	 				} else {	
	 					locationCellClear(sheetObj,Row);
	 				}
 	    		} else if (Value.length == 4) {
 	    			formObj.f_cmd.value=SEARCH11;
 	    			formObj.cd.value=sheetObj.GetCellValue(Row,Col);
 	    			var param="&nm=rg&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.gline_seq.value;	
 			  		for (var i=0; i <= 3; i++) {
 			  			if (formObj.rt_pnt[i].checked == true) {
 			  				if (i == 0) {
 			  					param += "&etc3=O";
 			  				} else if (i == 3) {
 			  					param += "&etc3=D";
 			  				}
 			  			}
 			  		}
  	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm"); 	  				
	 				if (arrData != null && arrData.length > 0) {
	 					if (arrData[1] != "") {
		 					sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm",arrData[1],0); 
		 					sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","G",0);
	 					} else {
	 						locationCellClear(sheetObj,Row);
	 					}
	 				}
 	    		} else {
 	    			locationCellClear(sheetObj,Row);
 	    		}
 	    		break;
 	    	case "rout_pnt_loc_tp_cd": 	    
 	    		locationCellClear(sheetObj,Row);
 	    		break;
     	}
     }  
   /**
    * Initializing sheet's specific cell value <br>
    * <br><b>Example :</b>
    * <pre>
    * 		locationCellClear(sheetObj,Row)
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} Row Mandatory ,Cell Row Index    
    * @return void
    * @author 
    * @version 2009.08.10
    */  	    
 	function locationCellClear(sheetObj,Row){
 		sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
 		sheetObj.SetCellValue(Row,"rout_pnt_loc_def_cd","",0);
 		sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd");
 	}
 /**
    * Function to check radio button on conditions from main<br>
    * <br><b>Example :</b>
    * <pre>
    * 		setSearchCondition()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.08.10
    */  	 
	function setSearchCondition()
	{
		 var formObj=document.form;
		 var radioSelect=formObj.org_dest_tp_cd.value + formObj.pnt_via_tp_cd.value;
	  	 var radioObj=document.form.rt_pnt;
		 switch (radioSelect){
			 case "OP":
				 currentSheet=1;				 
				 break;
			 case "OV":
				 currentSheet=2;
				 break;
			 case "DV":
				 currentSheet=3;
				 break;				 
			 case "DP":
				 currentSheet=4;
				 break;
		 }// end switch
		 radioObj[currentSheet - 1].checked=true;
	}		
	 /**
	    * Function to check whether modified data on sheet exists or not after clicking "close button"<br>
	    * <br><b>Example :</b>
	    * <pre>
	    * 		getSheetModify()
	    * </pre>
	    * @param  void
	    * @return {boolean}
        *          true  : sheet is modified<br>
        *          false : sheet is not modified<br>
	    * @author 
	    * @version 2009.08.10
	    */  		 
	function getSheetModify()
	{
		 if (sheetObjects[0].IsDataModified()== true || sheetObjects[1].IsDataModified()== true || sheetObjects[2].IsDataModified()== true || sheetObjects[3].IsDataModified()== true || sheetObjects[4].IsDataModified()== true ){
			 return true;
		 }
		 return false;
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
	    * @version 2009.08.10
	    */  	      	 
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		var tpCd="G";
		 _tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
		if (colName == "rout_pnt_loc_def_cd"){
			var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd=" + PRI_RG + "&location_cmd=LG&svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value;
			sUrl += "&loc_tp_cd=" + sheetObj.GetCellValue(Row, "rout_pnt_loc_tp_cd");
	  		for (var i=0; i <= 3; i++) {
	  			if (formObj.rt_pnt[i].checked == true) {
	  				if (i == 0) {
	  					sUrl += "&org_dest_cd=O";
	  				} else if (i == 3) {
	  					sUrl += "&org_dest_cd=D";
	  				}
	  			}
		  	}
			ComOpenPopup(sUrl, 700, 290, "findLocation", "1,0,1,1,1,1,1", false);
		}		
	}
    function findLocation(rtnVal) {
    	var tpCd="G";
    	_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd, 0);
		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col + 1, rtnVal.nm, 0);
		//Modifying location Type
		if (rtnVal.cd.length == 5) {
			tpCd="L";
		}
		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row,"rout_pnt_loc_tp_cd", tpCd, 0);
   }
