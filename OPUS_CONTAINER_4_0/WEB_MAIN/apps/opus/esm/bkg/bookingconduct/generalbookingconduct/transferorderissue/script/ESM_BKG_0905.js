/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0905.js
*@FileTitle  : TRO-Actual Customer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/11
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var bInitfalg=true; 
	// Event handler processing by button click event  */
	document.onclick=processButtonClick;
 	// Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
 			switch(srcName) {
 				case "btn_RowAdd": 
 					doActionIBSheet(sheetObject2, formObject, IBINSERT);  
 					break; 					
 				case "btn_RowDelete":
 					ComRowHideDelete(sheetObject2, "del_chk"); 
 					break;
				case "btn_Retrieve":
					if (tabObjects[0].GetSelectedIndex()== 1) {
						doActionIBSheet(sheetObject3, formObject, IBSEARCH);
					} else {
						doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					}
					break; 
				case "btn_Save":
						doActionIBSheet(sheetObject2, formObject, IBSAVE);
					break;
 				case "btn_Select":
					var sRow=sheetObject2.FindCheckedRow("del_chk");
			        // ACTIVE 버젼처럼 추가해준다.
 			        if(sRow.length >0 ) {
 			        	sRow = sRow +"|";
 			        	var arrRow=sRow.split("|");
	 			        if (arrRow.length < 2) {
	 			        	ComShowCodeMessage("BKG08040");
	 			        } else {
	 			        	pre_comPopupOK(sheetObject2, arrRow[0]);	
	 			        } 	
 			        }else{
 			        	ComShowCodeMessage("BKG04019");
 			        }
 					break;
 				case "btn_Close":
 					ComClosePopup(); 
 					break;
             } // end switch
     	}catch(e) {
     		ComShowMessage(e);
     	}
     }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     * @param sheet_obj IBSheet Object
     */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * setting tab object
      * @param tab_obj
      * @return
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {    	 
         initParam();   
         for(var i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);             
             ComEndConfigSheet(sheetObjects[i]);
         }
         for(var k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         } 
         
         var type=nullToBlank(document.form.type.value);
 		if(type=="A" || type =="B"){
 			sheetObjects[1].SetColHidden("act_shpr_addr",0);
 		}else if(type=="C"){
 			sheetObjects[1].SetColHidden("act_shpr_addr1",0);
 			sheetObjects[1].SetColHidden("act_shpr_addr2",0);
 			sheetObjects[1].SetColHidden("act_shpr_addr3",0);
 		}
         
         //check Init per Tab
	     setDefaultTab();
	     bInitfalg=false;
	     var formObj = document.form;
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			
     }
    /**
     * initializing Parameter 
     */
	function initParam()
	{
		var formObj=document.form;
		var tro_act_cust_knd_cd=""; 
		var conti_cd=nullToBlank(formObj.conti_cd.value);
		var cnt_cd=nullToBlank(formObj.cnt_cd.value);
		var bkg_no=nullToBlank(formObj.bkg_no.value);
		var act_shpr_cnt_cd=nullToBlank(formObj.act_shpr_cnt_cd.value);
		var act_shpr_seq=nullToBlank(formObj.act_shpr_seq.value);
		var act_shpr_nm=nullToBlank(formObj.act_shpr_nm.value);
		
	    tro_act_cust_knd_cd="C"; 
		formObj.tro_act_cust_knd_cd.value=tro_act_cust_knd_cd; 
		//------------------------------------------->
		//opener input value check 
		//1) exist    -> Default setting
		//2) not-exit -> retrieve and setting Default
		if (act_shpr_cnt_cd != "" && act_shpr_seq != "") {
			formObj.cust_cnt_cd.value=act_shpr_cnt_cd; 
			formObj.cust_seq.value=act_shpr_seq; 
		}
//		if (act_shpr_nm != "") {
//			formObj.tro_act_rep_nm.value=act_shpr_nm; 
//		}
		//<-------------------------------------------		
	}
    /**
     * setting default tab 
     */
 	function setDefaultTab()
 	{
 		var formObject=document.form;
		var objs=document.all.item("tabLayer");

		tabObjects[0].SetSelectedIndex(0);  //Cust
     	objs.style.display="Inline";
 	}
 	
  
   	/**
     * handling process for KeyUp
     */
   	function obj_keyup() {
   		var formObj=document.form;
   		with (formObj) {
   			if ( ComGetEvent("keycode") == 13 ) {   				 
				 if (tro_act_cust_knd_cd.value == "C")
				 {
					 doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				 } 
			}
   		}
   	}
   	/**
   	* setting sheet initial values and header
   	* param : sheetObj, sheetNo
   	* adding case as numbers of counting sheets
   	* @param sheetObj sheet Object
   	* @param sheetNo 
   	*/
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;        
		switch(sheetObj.id) {
			case "t1sheet1":      //t1sheet1 init
			    with(sheetObj){
			      var HeadTitle=" |Seq.|Customer Code|Customer Code||Name|S/OFC";
			      var headCount=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                   {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"displayno" },
			                   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                   {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"nvocc_co_scac_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                   {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"cust_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                   {Type:"Text",      Hidden:0, Width:230,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                   {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
			      SetCountPosition(0);
			      SetSheetHeight(82);
		      }


				break; 		
 			case "t1sheet2":      //t1sheet2 init
 			    with(sheetObj){
		 		      var HeadTitle="Sel.||Location|Zone|Factory Name (Actual Customer)|Contact Person|Tel.|Mobile|Address|Address1|Address2|Address3|Zip|Remark| | | | | ";
		 		      var headCount=ComCountHeadTitle(HeadTitle);
		
		 		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		 		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		 		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		 		      InitHeaders(headers, info);
		
		 		      var cols = [ {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		 		             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		 		             {Type:"PopupEdit", Hidden:0, Width:81,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		 		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"zn_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		 		             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		 		             {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		 		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntc_phn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		 		             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cntc_mphn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		 		             {Type:"Text",      Hidden:1, Width:190,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:150 },
		 		             {Type:"Text",      Hidden:1, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		 		             {Type:"Text",      Hidden:1, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		 		             {Type:"Text",      Hidden:1, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		 		             {Type:"Text",      Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"dor_zip_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		 		             {Type:"Text",      Hidden:0, Width:318,  Align:"Left",    ColMerge:0,   SaveName:"diff_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
		 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"tro_act_cust_knd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"tro_vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cnt_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cust_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
		 		       
		 		      InitColumns(cols);
		
		 		      SetEditable(1);
 		            //conversion of function[check again]CLT  					InitDataValid(0, "cntc_phn_no",  vtNumericOther, "-");
		 		     SetColProperty("cntc_phn_no", {AcceptKeys : "N|[-]"} );
		 		     //conversion of function[check again]CLT  					InitDataValid(0, "cntc_mphn_no", vtNumericOther, "-");
		 		    SetColProperty("cntc_mphn_no", {AcceptKeys : "N|[-]"} );
		 		    //no support[check again]CLT 					PopupImage="img/btns_search.gif";
				      SetColProperty("loc_cd", {AcceptKeys : "E", InputCaseSensitive :1} );
				      SetColProperty("zn_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );

				      
				      SetColBackColor("diff_rmk", "FFFFFF");
				      
		 		      SetShowButtonImage(2);
		 		      SetSheetHeight(190);
 		      }


 				break;
		
			case "h1sheet2":      //hidden sheet2
			    with(sheetObj){
			      var HeadTitle="||||||||||||||||||||||";
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Radio",     Hidden:0, Width:21,   Align:"Center",  ColMerge:0,   SaveName:"radio",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , TrueValue:"Y", FalseValue:"N"},
			             {Type:"Text",      Hidden:0,  Width:61,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"zn_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntc_phn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntc_mphn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
			             {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
			             {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
			             {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"dor_zip_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	 		             {Type:"Text",      Hidden:0, Width:318,   Align:"Left",    ColMerge:0,   SaveName:"diff_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntc_fax_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntc_eml",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"tro_act_cust_knd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"tro_vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cnt_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cust_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"tro_act_rep_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
			      SetVisible(0);
	            }
		        break; 
 		}
 	}
    function pre_comPopupOK(sheetObj_org, nSRow) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[2];
    	//var sheetObj_org = null;
        sheetObj.RemoveAll();                //grid init
        var nRow=sheetObj.DataInsert(-1);  //new row

		//2) Cust
		//sheetObj_org = sheetObjects[1];
		sheetObj.SetCellValue(nRow, "loc_cd",sheetObj_org.GetCellValue(nSRow, "loc_cd"),0);
		sheetObj.SetCellValue(nRow, "zn_cd",sheetObj_org.GetCellValue(nSRow, "zn_cd"),0);
		sheetObj.SetCellValue(nRow, "act_shpr_nm",sheetObj_org.GetCellValue(nSRow, "act_shpr_nm"),0);
		sheetObj.SetCellValue(nRow, "cntc_pson_nm",sheetObj_org.GetCellValue(nSRow, "cntc_pson_nm"),0);
		sheetObj.SetCellValue(nRow, "cntc_phn_no",sheetObj_org.GetCellValue(nSRow, "cntc_phn_no"),0);
		sheetObj.SetCellValue(nRow, "cntc_mphn_no",sheetObj_org.GetCellValue(nSRow, "cntc_mphn_no"),0);
		sheetObj.SetCellValue(nRow, "act_shpr_addr",sheetObj_org.GetCellValue(nSRow, "act_shpr_addr"),0);
		sheetObj.SetCellValue(nRow, "act_shpr_addr1",sheetObj_org.GetCellValue(nSRow, "act_shpr_addr1"),0);
		sheetObj.SetCellValue(nRow, "act_shpr_addr2",sheetObj_org.GetCellValue(nSRow, "act_shpr_addr2"),0);
		sheetObj.SetCellValue(nRow, "act_shpr_addr3",sheetObj_org.GetCellValue(nSRow, "act_shpr_addr3"),0);
		sheetObj.SetCellValue(nRow, "dor_zip_id",sheetObj_org.GetCellValue(nSRow, "dor_zip_id"),0);
		sheetObj.SetCellValue(nRow, "diff_rmk",sheetObj_org.GetCellValue(nSRow, "diff_rmk"),0);
		sheetObj.SetCellValue(nRow, "tro_act_cust_knd_cd",sheetObj_org.GetCellValue(nSRow, "tro_act_cust_knd_cd"),0);
		sheetObj.SetCellValue(nRow, "tro_vndr_seq",sheetObj_org.GetCellValue(nSRow, "tro_vndr_seq"),0);
		sheetObj.SetCellValue(nRow, "cnt_cd",sheetObj_org.GetCellValue(nSRow, "cnt_cd"),0);
		sheetObj.SetCellValue(nRow, "cust_seq",sheetObj_org.GetCellValue(nSRow, "cust_seq"),0);
		sheetObj.SetCellValue(nRow, "ofc_cd",sheetObj_org.GetCellValue(nSRow, "ofc_cd"),0);
		sheetObj.SetCellValue(nRow, "radio","Y",0);
    	comPopupOK();
    }
     /**
      * initializing tab
      */
     function initTab(tabObj, tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt=0 ;
					InsertItem( "By Customer Code" , "");
//					InsertItem( "By E/Q Office(USA Region)" , "");
                 }
              break;
          }
     }
     /**
      * Sheet process handling
      * @param sheetObj
      * @param formObj
      * @param sAction
      * @return
      */
     function doActionIBSheet(sheetObj, formObj, sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
           	case IBSEARCH:      //Retrieve	
 	          	if(!validateForm(sheetObj,formObj,sAction)) return;
 	          	if (sheetObj.id=="t1sheet1"){
 	          		formObj.f_cmd.value=SEARCH;
  	          		sheetObj.DoSearch("ESM_BKG_0905GS.do", FormQueryString(formObj) );
 	          	} 
                break;
 	 		case IBSAVE:        //Save
 	          	if(!validateForm(sheetObj,formObj,sAction)){
 	          		return false;
 	          	}
 	          	if (sheetObj.id=="t1sheet2"){
 	          	    formObj.f_cmd.value=MULTI; 
 	          		sheetObj.DoSave("ESM_BKG_0905GS.do", FormQueryString(formObj));
 	          	}
                break;
 			case IBINSERT:      // Input
 		    	var mstSheetObj=sheetObjects[0];
 		    	var nRow = sheetObj.DataInsert(-1);
				setDefaultInsertRow(sheetObj, nRow);
				sheetObj.FitColWidth();
                break;
         }
     }
     /**
      * Detail Sheet process handling
      * @param sheetObj
      * @param sFormQueryString
      * @param sAction
      * @return
      */
     //function doActionIBSheet2(sheetObj,formObj,sAction) {
     function doActionIBSheet2(sheetObj, sFormQueryString, sAction) { 
         sheetObj.ShowDebugMsg(false);
         var formObj=document.form;
         switch(sAction) {
           	case IBSEARCH:      //Retrieve	
 	          	if (sheetObj.id=="t1sheet2"){   
 	          		formObj.f_cmd.value=SEARCH01;     		
  	          		sheetObj.DoSearch("ESM_BKG_0905GS.do", FormQueryString(formObj)+"&"+sFormQueryString );
 	          	}
                break;
         }
     }
     /**
      * handling process for input validation
      * @param sheetObj sheet Object
      * @param formObj  form Object
      * @param sAction 
      */
     function validateForm(sheetObj,formObj,sAction){
    	 //1. Basic Validation 
    	 if (!ComChkValid(formObj)) return false;
    	 //2. Business Validation 
    	 with(formObj) {
	         switch (sAction) {
	             case IBSEARCH: // Retrieve
	            	 if (tro_act_cust_knd_cd.value == "C")
	            	 {
						 if (cust_cnt_cd.value == "") {
							 ComBkgNessMessage(cust_cnt_cd);  //ComShowCodeMessage('BKG00104');
							 return false;
						 }
	            	 } 
	                 break;
	             case IBSAVE: // Save
	            	 if (tro_act_cust_knd_cd.value == "C")
	            	 {
	            		 var sheetObj=sheetObjects[1]; 
	            		 for (var i=1; i<=sheetObj.RowCount(); i++) {
	            			 if (sheetObj.GetCellValue(i, "act_shpr_nm") == "") {
								 ComShowCodeMessage("COM12200", i+" row: Factory Name(Actual Customer)");
								 sheetObj.SelectCell(i, "act_shpr_nm");
								 return false;
							 }
	            			 if (sheetObj.GetCellValue(i, "zn_cd") != "" && sheetObj.GetCellValue(i, "loc_cd") == "") {
								 ComShowCodeMessage("COM12200", i+" row: Location");
								 sheetObj.SelectCell(i, "loc_cd");
								 return false;
							 }
	            		 }
	            	 } 
	            	 break;
	         }
         }
         return true;
     }
     /**
      * search Detail
      * @param sheetObj
      * @param Row
      * @return
      */
     function searchDetail(sheetObj, Row){ 	
         var param="";
         if (sheetObj.id=="t1sheet1") {   
        	//wnen no data
             if (sheetObj.RowCount()== 0) {
            	 sheetObjects[1].RemoveAll();   //t1 detail Init
             }        	 
			param += "f_cnt_cd="   +sheetObj.GetCellValue(Row, "cust_cnt_cd");
			param += "&f_cust_seq="+sheetObj.GetCellValue(Row, "cust_seq");
			param += "&f_ofc_cd="  +sheetObj.GetCellValue(Row, "ofc_cd");
	         doActionIBSheet2(sheetObjects[1], param, IBSEARCH);
         }

     }     
     /**
      * handling obj hidden by selectedIndex value
      * @param nTabIdx
      * @return
      */
     function setHiddenValTabIdx(nTabIdx)
     {
    	 if (bInitfalg == false)
    	 {
          	 if (nTabIdx == 0) {
          		 document.form.tro_act_cust_knd_cd.value="C";
          	 } 
    	 }
     }
     /**
      * setting default value to insert row
      * @param sheetObj
      * @param nRow
      * @return
      */
     function setDefaultInsertRow(sheetObj, nRow) {
    	 var mstSheetObj=sheetObjects[0];
    	 var mstSheetObj_t2=sheetObjects[2];
    	 //new row setting 
    	 if (sheetObj.id=="t1sheet2") {   
    		 sheetObj.SetCellValue(nRow, "tro_act_cust_knd_cd",document.form.tro_act_cust_knd_cd.value,0);
    		 sheetObj.SetCellValue(nRow, "cnt_cd",mstSheetObj.GetCellValue(mstSheetObj.GetSelectRow(), "cust_cnt_cd"),0);
    		 sheetObj.SetCellValue(nRow, "cust_seq",mstSheetObj.GetCellValue(mstSheetObj.GetSelectRow(), "cust_seq"),0);
    		 sheetObj.SetCellValue(nRow, "ofc_cd",mstSheetObj.GetCellValue(mstSheetObj.GetSelectRow(), "ofc_cd"),0);
    	 }
     }
     
     /**
      * handling process after ending h1sheet1 retrieve
      * @param sheetObj
      * @param ErrMsg
      * @return
      */
     function h1sheet1_OnSearchEnd(sheetObj, ErrMsg) {

     }
     /**
      * handling process after ending t1sheet1 retrieve
      * @param sheetObj
      * @param ErrMsg
      * @return
      */
     function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {	 
     	if (sheetObj.RowCount()>0) {
     //no support[check again]CLT 		sheetObj.SetCellBackColor(1,"factory",sheetObj.WebColor("CCFFFD"));
     	}	
        searchDetail(sheetObj, sheetObj.GetSelectRow()); //Detail grid Retrieve
        sheetObj.SetSelectRow(1);
     }    
     /**
      * handling process after ending t1sheet2 save
      * @param sheetObj
      * @param ErrMsg
      * @return
      */
     function t1sheet2_OnSaveEnd(sheetObj, ErrMsg) {	 
 	 	 if (ErrMsg == "") {
  	 		ComBkgSaveCompleted();  //Server Msg transaction
  	 		searchDetail(sheetObjects[0], sheetObjects[0].GetSelectRow());   //detail grid Retrieve
  		 } 	
      }
     
 	function t1sheet2_OnDblClick(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var temp="";
		if (colName == "diff_rmk") {
			ComShowMemoPad(sheetObj, Row, colName, false, 200, 150, 200);
		}
	}     

  	 /**
  	  * t1Sheet1 click event handling
  	  * @param sheetObj
  	  * @param Row
  	  * @param Col
  	  * @param Value
  	  * @return
  	  */
     function t1sheet1_OnClick(sheetObj, Row, Col, Value) { 
    	 searchDetail(sheetObj, Row);  //detail grid Retrieve
     }
    /**
     * t1Sheet2 LOC popup click event handling
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */
    function t1sheet2_OnPopupClick(sheetObj, row, col){
    	if (sheetObj.ColSaveName(col) == "loc_cd") {
    		var locCd=sheetObj.GetCellValue(row, "loc_cd");
    		comBkgCallPop0083('callBack0083_sheet','', locCd, "", "", row, col, 1);
        }
    }   
    /**
     * call Node Search Popup
     * @param callback_func
     * @param locTp
     * @param locCd
     * @param ydCd
     * @param rdTerm
     * @param nRow
     * @param nCol
     * @param sheetIdx
     * @return
     */
    function comBkgCallPop0083(callback_func, locTp, locCd, ydCd, rdTerm, nRow, nCol, sheetIdx){    	
    	ComOpenPopup("ESM_BKG_0083.do?pgmNo=ESM_BKG_0083&loc_tp="+locTp+"&loc_cd="+locCd+"&yd_cd="+ydCd+"&rd_term="+rdTerm, 990, 450, callback_func,"1,0,1,1,1", true, false, nRow, nCol, sheetIdx);    	
    }      
    /**
     * save data from Node Search Popup
     * @param locTp
     * @param tab
     * @param rArray
     * @param row
     * @param col
     * @param sheetIdx
     * @return
     */
     function callBack0083_sheet(locTp, tab, rArray, row, col, sheetIdx){      
    	var formObj=document.form;
     	if(rArray != null){
     		if(tab == 1){
     			sheetObjects[sheetIdx].SetCellValue(row, col,rArray[0][2],0);
     		}	
     	}
    }     
