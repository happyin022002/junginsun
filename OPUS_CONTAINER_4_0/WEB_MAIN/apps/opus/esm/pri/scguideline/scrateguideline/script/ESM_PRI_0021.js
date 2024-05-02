/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0021.js
*@FileTitle  : Rate Guideline Creation - Route Point
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/

/*
 * 
 * 
 * 
 * 공통팝업입니다.
 * 수정하지 마세요.
 * Parent 파일을 수정하여 사용하시기 바랍니다.
 * 2014.09.02 김은진
 * 
 * 
 * 
 * 
 */

 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 //current selected Route Point's index
 var currentSheet=1; 
 var enableFlag=true;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 
//다음의 화면들에서 호출됨
//ESM_PRI_0001_06
 
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
						ComPopUpReturnValue("O");
	            	}	            	
	                break;
	            case "btn_Close":
	            	if (getSheetModify()){
	            		if(ComShowCodeConfirm("PRI00006")){
	            			if (enableFlag && validateForm(sheetObject1,formObject,IBSAVE)) {
	            				doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return 
     * @author 
     * @version 2009.05.07
     */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
     * initializing sheet</b>
     * implementing onLoad event handler in body tag</b>
     * adding first-served functions after loading screen.</b>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 
     * @author 
     * @version 2009.05.07
     */
     function loadPage() {    	 
    	 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
    	 
    	  //radio button event
    	 initControl();
    	  //Conditions from Main
    	 setSearchCondition()
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }         
         doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);   
         if (document.form.isEditable.value == "false") {
        	 sheetObjects[0].SetEditable(0);
        	 sheetObjects[1].SetEditable(0);
        	 sheetObjects[2].SetEditable(0);
        	 sheetObjects[3].SetEditable(0);
        	 sheetObjects[4].SetEditable(0);
        	 disableButton("btn_RowAdd");
        	 disableButton("btn_RowDel");
         }
     }
     /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory ,Serial No for IBSheet Object Tag's ID
     * @return 
     * @author 
     * @version 2009.05.07
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":	// visible sheet
                 with(sheetObj){                 
	              var HeadTitle="|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|Term|Trans Mode";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              (headCount, 0, 0, true);
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                  {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                  {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Combo",     Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                  {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];	               
	              InitColumns(cols);
	              SetEditable(1);
	              SetShowButtonImage(2);
	              SetSheetHeight(140);
                }
                 break;
             case "sheet2":	// Route Point Origin sheet
            	    with(sheetObj){                
		               var HeadTitle="|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|Term|Trans Mode";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               (headCount, 0, 0, true);
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
		               SetSheetHeight(100);
                     }
	             break;
             case "sheet3":	// Route Point Origin Via sheet
            	    with(sheetObj){                
		               var HeadTitle="|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               (headCount, 0, 0, true);
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                
		               InitColumns(cols);
		               SetEditable(1);
		               SetSheetHeight(100);
                     }
	             break;
             case "sheet4":	// Route Point Destination Via sheet
            	    with(sheetObj){                 
		               var HeadTitle="|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               (headCount, 0, 0, true);
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                
		               InitColumns(cols);
		               SetEditable(1);
		               SetSheetHeight(100);
                     }
	             break;
             case "sheet5":	// Route Point Destination sheet
                 with(sheetObj){                 
		              var HeadTitle="|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|Term|Trans Mode";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                  {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
		              SetSheetHeight(100);
                     }
	             break;            
         }
     }
     /**
     * Handling sheet Process <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,Process Contant value
     * @return 
     * @author 
     * @version 2009.05.07
     */
      function doActionIBSheet(sheetObj,formObj,sAction) {
          sheetObj.ShowDebugMsg(false);
          switch(sAction) {
 			case IBCLEAR: // When loading a screen
 				var sXml="";
 				var radioObj=formObj.rt_pnt;
				//common - type
 				sheetObj.InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				//common trans mode
				sheetObj.InitDataCombo(0,"prc_trsp_mod_cd", transCdComboText, transCdComboValue);
				if(radioObj[0].checked == true){
					sheetObj.InitDataCombo(0,"rcv_de_term_cd", termOrgCdComboText, termOrgCdComboValue);
				}else if(radioObj[3].checked == true){
					sheetObj.InitDataCombo(0,"rcv_de_term_cd", termDesCdComboText, termDesCdComboValue);
				}
							
 				break;
			case IBSEARCH:      //Retrieving
				var sXml="";
				//Getting sheet data from main page
				for (i=4; i < 8; i++){
					//sXml=dialogArguments.getSheetXml(i);
					var sXml = opener.getSheetXml(i);
					sheetObjects[i-3].LoadSearchData(sXml,{Sync:1} );
					fontChange(sheetObjects[i-3]);
				}
				//Copying hidden sheet's tosheet on a screen			
				if (sheetObjects[currentSheet].RowCount()!= 0){
					sheetToSheet(sheetObjects[currentSheet],sheetObjects[0]);
				}				
				//Hiding column
				setGetColHidden();
	         	break; 				
 			case IBINSERT:      // Insert
 		        var idx=sheetObj.DataInsert();
				sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
				sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
				sheetObj.SetCellValue(idx, "prc_cust_tp_cd",formObj.prc_cust_tp_cd.value);
				sheetObj.SetCellValue(idx, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
				sheetObj.SetCellValue(idx, "rout_seq",formObj.rout_seq.value);
				var radioObj=document.form.rt_pnt;
				var tpCd="O";
		  		//Selected radio button
		  		for (i=0; i < 4 ; i++){
		  			if (radioObj[i].checked == true ){
		  				if (i == 2 || i == 3){
		  					tpCd="D";
		  				}
		  			}
		  		}
				sheetObj.SetCellValue(idx, "org_dest_tp_cd",tpCd);
				sheetObj.SetCellValue(idx, "rout_pnt_seq",parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1);
				sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");
 				break;
 			case IBDELETE: // Delete
 				deleteRowCheck(sheetObj, "chk" ,true);
 				break;			
			case IBSAVE:        //saving		
				var sXml="";
	      	  	sheetToSheet(sheetObjects[0],sheetObjects[currentSheet]);
//				* How to return sheet data to opener screen
				for (i=1; i < 5; i++){
					//Transmitting data to main page after ordering
					if (i == 1 || i == 4){
						sheetObjects[i].ColumnSort("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd","ASC","ASC|ASC");
					}else{
						sheetObjects[i].ColumnSort("rout_via_port_tp_cd|rout_via_port_def_cd","ASC","ASC|ASC");
					}
					var sXml=ComPriSheet2Xml(sheetObjects[i]);
					opener.setSheetXml(sXml, i+3);
					//dialogArguments.setSheetXml(sXml, i+3);
				}
	            break; 				
          }
      }
      /**
       * handling process for input validation <br>
       * <br><b>Example :</b>
       * <pre>
       *     if (validateForm(sheetObj,document.form,IBSAVE)) {
       *         Handling logic;
       *     }
       * </pre>
       * @param {ibsheet} sheetObj Mandatory IBSheet Object
       * @param {form} formObj Mandatory html form object
       * @param {int} sAction Mandatory ,Process Flag Contant value
       * @returns bool <br>
       *          true  : in case of valid of form's value<br>
       *          false : in case of invalid of form's value<br>
       * @author 
       * @version 2009.05.07
       */
      function validateForm(sheetObj,formObj,sAction){
     	  switch (sAction) {
 	  		case IBSEARCH: // Retrieving			
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
	 		  		if (sParamSheet1==""){
	 		  			return ; 		  			
	 		  		} 					
 					var rowM=sheetObjects[0].ColValueDup("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rcv_de_term_cd|prc_trsp_mod_cd", false);
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
       * @param 
       * @returns 
       * @author 
       * @version 2009.05.07
       */ 	 
  	function initControl() {
//  	    axon_event.addListener('click', 'radio_click', 'rt_pnt');
  	    axon_event.addListenerForm('click', 'obj_click', document.form);
  	}
    /**
    * calling function in case of Clicking radio button <br>
    * <br><b>Example :</b>
    * <pre>
    *     
    * </pre>
    * @param 
    * @returns 
    * @author 
    * @version 2009.05.07
    */ 	
  	function obj_click() {
  		
  		if (event.srcElement.name == "rt_pnt") {
	  		var radioObj=document.form.rt_pnt;
	  		var hiddenVal=false;
	  		var idx=1 ; //Selected Route Point's index
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
  	}         
    /**
     * Function to modify term's combo by Route Point<br>
     * <br><b>Example :</b>
     * <pre>
     *     	changeCombo()
     * </pre>
     * @param 
     * @returns 
     * @author 
     * @version 2009.05.07
     */ 	   
    function changeCombo(){
    	var radioObj=document.form.rt_pnt;
    	var sheetObj=sheetObjects[0];
		// Term shall be different in Origin case and Destination case 
		if(radioObj[0].checked){
			sheetObj.InitDataCombo(0,"rcv_de_term_cd", termOrgCdComboText, termOrgCdComboValue);
		}else if(radioObj[3].checked){
			sheetObj.InitDataCombo(0,"rcv_de_term_cd", termDesCdComboText, termDesCdComboValue);
		}
    }
     /**
      * calling function in case of clicking radio button<br>
      * showing or not showing sheet
      * <br><b>Example :</b>
      * <pre>
      *     	setColHidden()
      * </pre>
      * @param 
      * @returns 
      * @author 
      * @version 2009.05.07
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
    * @return 
    * @author 
    * @version 2009.05.07
    */  	 	 
   	function sheetToSheet (sheetObj1, sheetObj2){
   		//Making sheetObj1 data to RetrievingXML
   		if (sheetObj1.RowCount()!= 0 ){
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
 	    * @param {ibsheet} sheetObj Mandatory IBSheet Object
 	    * @return 
 	    * @author 
 	    * @version 2009.05.07
 	    */   	 
 	function sheetGetRowHidden(sheetObj){
		for (i=sheetObj.RowCount(); i > 0; i-- ){
			if (sheetObj.GetCellValue( i, "ibflag") == "D" ){
				sheetObj.SetRowHidden(i,1);
			}
   		}	
 	}
     /**
 	    * calling function in case of OnChange event <br>
 	    * Showing Description of seleted Multi ComboBox  <br>
 	    * <br><b>Example :</b>
 	    * <pre>
 	    *
 	    * </pre>
 	    * @param {ibsheet} sheetObj Mandatory IBSheet Object
 	    * @param {int} Row Mandatory Onclick ,Cell's  Row Index
 	    * @param {int} Col Mandatory Onclick ,Cell's Column Index
 	    * @param {string} Value Mandatory ,Cell's Value
 	    * @return 
 	    * @author 
 	    * @version 2009.05.07
 	    */  	    
     function sheet1_OnChange(sheetObj, Row, Col, Value)
     {
     	var colname=sheetObj.ColSaveName(Col);
     	var formObj=document.form
     	switch(colname)
     	{
 	    	case "rout_pnt_loc_def_cd":
 	    		sheetObj.SetCellValue(Row,"rout_pnt_loc_def_cd", sheetObj.GetCellValue(Row,"rout_pnt_loc_def_cd").toUpperCase(), 0);
 	    		if (Value.length==5){
 	    			//location name
 	    			formObj.f_cmd.value=SEARCH05; 	    			
 	    			formObj.cd.value=sheetObj.GetCellValue(Row,Col);
	 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	 				var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
	 				if (arrDesc != null && arrDesc.length > 0) {
	 					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm",arrDesc[0][1],0);
	 					sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","L" ,0);
	 				}else{	
	 					locationCellClear(sheetObj,Row);
	 				}
 	    		}else if (Value.length==4){
 	    			formObj.f_cmd.value=SEARCH11;
 	    			formObj.cd.value=sheetObj.GetCellValue(Row,Col);  	  
 	    			var param="&etc1="+formObj.svc_scp_cd.value+"&etc2="+formObj.gline_seq.value;	
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm"); 	  				
	 				if (arrData != null && arrData.length > 0) {
	 					if (arrData[1]!=""){
		 					sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm", arrData[1], 0); 
		 					sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd", "G", 0);
	 					}else{
	 						locationCellClear(sheetObj,Row);
	 					}
	 				}
 	    		}else{
 	    			locationCellClear(sheetObj,Row);
 	    		}
 	    		break;
 	    	case "rout_pnt_loc_tp_cd": 	    
 	    		locationCellClear(sheetObj,Row);
 	    		break;
     	}
     }  
   /**
    * Initializing function to set specific cell's value of sheet<br>
    * <br><b>Example :</b>
    * <pre>
    * 		locationCellClear(sheetObj,Row)
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory ,Cell Row Index  
    * @return 
    * @author 
    * @version 2009.05.07
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
    * @param 
    * @return 
    * @author 
    * @version 2009.05.07
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
	    * @param 
	    * @return {boolean}
        *          true  : sheet is modified<br>
        *          false : sheet is not modified<br>
	    * @author 
	    * @version 2009.05.07
	    */  		 
	function getSheetModify() {
		
		 if (sheetObjects[0].IsDataModified()== true || sheetObjects[1].IsDataModified()== true || sheetObjects[2].IsDataModified()== true || sheetObjects[3].IsDataModified()== true || sheetObjects[4].IsDataModified()== true ){
			 return true;
		 }
		 return false;
	}	 
    /**
    * Calling function in case of OnPopupClick event<br>
    * Calling Location PopUp <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
    * @param {int} Col Mandatory OnPopupClick 'Cell's Column Index
    * @return 
    * @author 
    * @version 2009.05.07
    */  	      	
	var popupRow=0;
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		var colName=sheetObj.ColSaveName(Col);
		popupRow=Row;
		var formObj=document.form;
		var locTpCd=sheetObj.GetCellValue(Row,"rout_pnt_loc_tp_cd");
		if (colName == "rout_pnt_loc_def_cd"){
			var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SG+ "&loc_tp_cd="+ locTpCd  + "&location_cmd=LG&svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value;
			ComOpenPopup(sUrl, 600, 290, "set_rout_pnt_loc_tp_cd", "1,0,1,1,1,1,1", false);
			
		}		
	}
	
	function set_rout_pnt_loc_tp_cd (rtnVal) {
		var tpCd="G";
		if (rtnVal != null){
			sheet1.SetCellValue(popupRow, "rout_pnt_loc_def_cd", rtnVal.cd);
			sheet1.SetCellValue(popupRow, "rout_pnt_loc_def_nm", rtnVal.nm);
			if (rtnVal.cd.length == 5){
				tpCd="L";
			}
			sheetObj.SetCellValue(popupRow,"rout_pnt_loc_tp_cd", tpCd);
		}
	}
	
     /**
     * Function to modify font of radio button<br>
     * Show BOLD if data exists<br>
     * <br><b>Example :</b>
     * <pre>
     * 	fontChange()
     * </pre>
     * @param 
     * @return 
     * @author 
     * @version 2009.04.17
     */ 	     
     function fontChange(sheetObj){
     	//SHEET ROW COUNT
 		var row_count = getValidRowCount(sheetObj);
     	var formObj=document.form;
 		var fontBold="";
     	var eleName="";
     	var sheetNo=sheetObj.id.substr(5,1);
     	eleName="rt_pnt" + (sheetNo-1);     	
  		if (row_count > 0) {
  			fontBold="bold";
  		}    	
     	document.getElementById(eleName).style.fontWeight=fontBold;
     }       
