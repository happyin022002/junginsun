/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0072.js
*@FileTitle  : Rate Guideline Inquiry - Origin & Destination
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
//current selected Route Point's index 
 var currentSheet=1; 
 var enableFlag=true;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 var opener;
 
//다음의 화면들에서 호출됨
//ESM_PRI_0002_06
 
	/**
	 * Event handler processing by button name  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];          
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		
            switch(srcName) {
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
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.05.07
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
     * @version 2009.05.07
     */
     function loadPage() { 
    	 if (!opener) opener=window.opener;
    	 if (!opener) opener = parent;
         if (!opener) opener = parent;  	 
    	  //radio button event
         setSearchCondition();
    	 initControl();
    	  //Conditions from Main
    	 
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             sheetObjects[i].SetWaitImageVisible(0);
             ComEndConfigSheet(sheetObjects[i]);
         }         
         doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);   
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
     * @version 2009.05.07
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":   // visible sheet
                 with (sheetObj) {
                 var HeadTitle="|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|Term|Trans Mode";
                 var headCount=ComCountHeadTitle(HeadTitle);
                 (headCount, 0, 0, true);

                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                  {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Combo",     Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                  {Type:"Text",      Hidden:0, Width:190,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                  
                 InitColumns(cols);
                 SetEditable(0);
                 SetShowButtonImage(0);
                 SetSheetHeight(140);
                }
                 break;
             case "sheet2":	// Route Point Origin sheet
	             with (sheetObj) {
                 var HeadTitle="|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|Term|Trans Mode";
                 var headCount=ComCountHeadTitle(HeadTitle);
                 (headCount, 0, 0, true);
                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
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
	             with (sheetObj) {
                 var HeadTitle="|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description";
                 var headCount=ComCountHeadTitle(HeadTitle);
                 (headCount, 0, 0, true);

                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
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
	             with (sheetObj) {
                 var HeadTitle="|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description";
                 var headCount=ComCountHeadTitle(HeadTitle);
                 (headCount, 0, 0, true);

                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
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
	             with (sheetObj) {
                 var HeadTitle="|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|Term|Trans Mode";
                 var headCount=ComCountHeadTitle(HeadTitle);
                 (headCount, 0, 0, true);

                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
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
     * @version 2009.05.07
     */
      function doActionIBSheet(sheetObj,formObj,sAction) {
         try {
        	 if (window.event == null || ComGetEvent() == null || $(ComGetEvent()).attr('suppressWait') != "Y") {
                 ComOpenWait(true);
             }
	          sheetObj.ShowDebugMsg(false);
	          switch(sAction) {
	 			case IBCLEAR: 
	 				var sXml="";
	 				var radioObj=formObj.rt_pnt;
					//common - type
	 				sheetObjects[0].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE2[1] ,ComboCode:LOCATION_TYPE2[0]} );
	 				sheetObjects[1].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE2[1] ,ComboCode:LOCATION_TYPE2[0]} );
	 				sheetObjects[4].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE2[1] ,ComboCode:LOCATION_TYPE2[0]} );
	//				formObj.f_cmd.value = SEARCH19;
	//				formObj.cd.value="CD01718";
	//				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));			
	//				setIBCombo(sheetObj, sXml, "rout_pnt_loc_tp_cd", false, 0);	 			
	         		formObj.f_cmd.value=COMMAND13;
	         		// Common term, trans mode
	         		var param="";
	         		param="CD02138:N";//Origin
					if(radioObj[3].checked == true){
						param="CD02139:N";  //Destination
					}
					param += ":CD01720:N"
	         		formObj.cd.value=param;// "Y" When the name is code or desc          		
					sXml=sheetObj.GetSearchData("PRICommonGS.do" , FormQueryString(formObj));
	 				var arrXml=sXml.split("|$$|");
	 				if ( arrXml[0] != null)	setIBCombo(sheetObj,arrXml[0],"rcv_de_term_cd",true,0);				
	 				if ( arrXml[1] != null)	setIBCombo(sheetObj,arrXml[1],"prc_trsp_mod_cd",true,0);					
	//              //Common term
	//				formObj.f_cmd.value = SEARCH19;
	//				formObj.cd.value="CD02138"; //Origin
	//				if(radioObj[3].checked == true){ //Destination
	//					formObj.cd.value="CD02139";
	//				}				
	//				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	//				setIBCombo(sheetObj,sXml,"rcv_de_term_cd",true,0);
	//				
	//				//common trans mode
	//				formObj.f_cmd.value = SEARCH19;
	//				formObj.cd.value="CD01720";
	//				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	//				setIBCombo(sheetObj,sXml,"prc_trsp_mod_cd",true,0);					
	 				break;
				case IBSEARCH:      //Retrieving
					var sXml="";
					//Getting sheet data from main page
					for (i=4; i < 8; i++){
			            var sXml = opener.getSheetXml(i);
//						sXml=dialogArguments.getSheetXml(i);
	//					ComDebug("sheetcnt = "+i+"  "+sXml)
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
       * @version 2009.05.07
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
       * @version 2009.05.07
       */ 	 
  	function initControl() {
  	    // Process Axon Event No.1, Event Catch 
  	    axon_event.addListener('click', 'radio_click', 'rt_pnt');
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
    * @version 2009.05.07
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
     * @version 2009.05.07
     */ 	   
    function changeCombo(){
    	var radioObj=document.form.rt_pnt;
		// Term shall be different in Origin case and Destination case 
		if (radioObj[0].checked){
			document.form.cd.value="CD02138";
		}else if (radioObj[3].checked){
			document.form.cd.value="CD02139";
		}
		if (radioObj[0].checked || radioObj[3].checked){
			// Common term
			document.form.f_cmd.value=SEARCH19;
			var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(document.form));
			setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true, 0);	  	 		
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
		sheetObjects[0].SetColHidden("rcv_de_term_cd",hiddenVal);
		sheetObjects[0].SetColHidden("prc_trsp_mod_cd",hiddenVal);
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
 	    * @param {ibsheet} sheetObj mandatory IBSheet Object
 	    * @return void
 	    * @author 
 	    * @version 2009.05.07
 	    */   	 
 	function sheetGetRowHidden(sheetObj){
		for (i=sheetObj.RowCount(); i > 0; i-- ){
			if (sheetObj.GetCellValue( i, "ibflag") == "D" ){
				sheetObj.SetRowHidden(i,1);
			}
   		}
//		sheetObj.FitColWidth();
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
	    * @param  void
	    * @return {boolean}
        *          true  : sheet is modified<br>
        *          false : sheet is not modified<br>
	    * @author 
	    * @version 2009.05.07
	    */  		 
	function getSheetModify()
	{
		 if (sheetObjects[0].IsDataModified()== true || sheetObjects[1].IsDataModified()== true || sheetObjects[2].IsDataModified()== true || sheetObjects[3].IsDataModified()== true || sheetObjects[4].IsDataModified()== true ){
			 return true;
		 }
		 return false;
	}
     /**
     * Function to modify font of radio button<br>
     * Show BOLD if data exists<br>
     * <br><b>Example :</b>
     * <pre>
     * 	fontChange()
     * </pre>
     * @param  void
     * @return void
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
     	eleName="pnt" + (sheetNo-1);     	
  		if (row_count > 0) {
  			fontBold="bold";
  		}    	
     	document.getElementById(eleName).style.fontWeight=fontBold;
     }       
