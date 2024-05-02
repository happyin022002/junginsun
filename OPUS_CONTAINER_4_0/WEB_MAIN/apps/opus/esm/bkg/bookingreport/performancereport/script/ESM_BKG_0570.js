/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0570.js
*@FileTitle  : B/L Inquery 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_0570 : business script for ESM_BKG_0570
     */
    function ESM_BKG_0570() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          var sheetObject3=sheetObjects[2];
          var sheetObject4=sheetObjects[3];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 				case "btn_Retrieve":
 				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 				break;
 				case "btn_close":
 					ComClosePopup();
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
    	 for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
 				
         }
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
         }
         
         initControl();
         document.form.bl_no.focus();
     }
      /**
       * loading HTML Control event <br>
       * initializing IBSheet Object
       * @param sheetObj IBSheet Object
       * @param sheetNo sheetObjects 배열에서 순번
       */
      function initControl() {
      	var formObject=document.form;
      	//Axon event handling1. event catch
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- focus out
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- focus in
       //   axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- in case of typing keyboard
        //  axon_event.addListener ('keydown', 'ComKeyEnter', 'form');//Enter key handling
         // axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
      }
     /**
	 * control keyboard input at onkeypress event of HTML Control
	 **/
//     function obj_keypress(){
//		switch(event.srcElement.dataformat){
//	    	case "int":
//		        ComKeyOnlyNumber(event.srcElement);
//		        break;
//	        case "float":
//	            ComKeyOnlyNumber(event.srcElement, ".");
//	            break;
//	        case "eng":
//	            ComKeyOnlyAlphabet();
//	            break;
//	        case "engdn":
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        case "engup":
//	            ComKeyOnlyAlphabet('upper');
//	            break;
//	        case "engupnum":
//	            ComKeyOnlyAlphabet('uppernum');
//	            break;
//	        default:
//	            ComKeyOnlyNumber(event.srcElement);
//	    }
//	} 
	 /**
	  * setting sheet initial values and header
	  * @param sheetObj
	  * @param sheetNo
	  * @return
	  */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //sheet1 init
            	    with(sheetObj){
                
               var HeadTitle="||||||||||||||||";

               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"corr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cust_ref_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"frt_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"obl_iss_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eta",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"op_cntr_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pck_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"act_wgt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"meas_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cmdt_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);
               SetVisible(false);
               SetEditable(1);
                     }


                 break;
             case 2:      //sheet1 init
                 with(sheetObj){
              var HeadTitle="|||||||||||||||||";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_cust_tp_cd" },
                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd" },
                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_seq" },
                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_nm" },
                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_addr" },
                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_tel" },
                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_fax_no" } ];
               
              InitColumns(cols);
              SetVisible(false);
              SetEditable(1);
                       }


             break;
             case 3:      //sheet1 init
            	    with(sheetObj){
               
               var HeadTitle="|Seq.|Container No.|Type|Seal No.|Partial|R|D|Empty / Full|Remark(s)";

               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mk_seq" },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"loc_ts" },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mk_desc" },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cmdt_desc" } ];
                
               InitColumns(cols);
               SetVisible(false);
               SetEditable(1);
                     }


             break;
             case 4:      //sheet1 init
                 with(sheetObj){
		              var HeadTitle="Seq.|Container No.|Type|Seal No.|Partial|R|D|Empty / Full|Remark(s)";
		             
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                  {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"ComboEdit", Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"com_seal_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_prt_flg",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no" } ];
		               
		              InitColumns(cols);
		              SetSheetHeight(300);
		              SetEditable(1);
             }
             break;
         }
     }
     /**
      * handling sheet process
      * @param sheetObj
      * @param formObj
      * @param sAction
      * @return void
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case IBSEARCH:      //retrieve
         		if(validateForm(sheetObj,formObj,sAction))
        		sheetObj.SetWaitImageVisible(0);
 				ComOpenWait(true);
         		formObj.f_cmd.value=SEARCH;   
         		var searchXml=sheetObj.GetSearchData("ESM_BKG_0570GS.do", FormQueryString(formObj));
				var sXml=searchXml.split("|$$|");
				sheetObjects[0].LoadSearchData(sXml[0],{Sync:1} );
				sheetObjects[1].LoadSearchData(sXml[1],{Sync:1} );
				sheetObjects[2].LoadSearchData(sXml[2],{Sync:1} );
				sheetObjects[3].LoadSearchData(sXml[3],{Sync:1} );
				setBlInq();
				ComOpenWait(false);
         	break;
         }
     }
     /**
      * registering IBTab Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
     /**
      * Tab option
      * setting tab list
      */
     function initTab(tabObj , tabNo) {
    	  switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt=0 ;
					InsertItem( "Customer" , "");
					InsertItem( "Marks & Desc." , "");
					InsertItem( "CNTR Inquiry" , "");
                 }
              break;
          }
     }
     /**
      * event in case of clicking tab
      * activating selected tab
      */
     function tab1_OnChange(tabObj , nItem)
     {
      var objs=document.all.item("tabLayer");
      objs[nItem].style.display="Inline";
      for(var i = 0; i<objs.length; i++){
       if(i != nItem){
        objs[i].style.display="none";
        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
       }
      }
      //---------------important --------------------------//
      beforetab=nItem;
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if (formObj.bl_no.value == ''){
         	ComShowCodeMessage("BKG00609");//Please, Check BL No !	  
         	formObj.bl_no.focus();    		  
   	   		return false;
    	 }
         return true;
     }
    // occurring event after retrieve
  	function setBlInq()
  	{
  		var formObj=document.form;
  		var sheet1=sheetObjects[0];
  		var sheet2=sheetObjects[1];
  		var sheet3=sheetObjects[2];
  		var sheet4=sheetObjects[3];
  		var lastRow1=sheet1.LastRow();
  		var lastRow2=sheet2.LastRow();
  		var lastRow3=sheet3.LastRow();
  		var lastRow4=sheet4.LastRow();
  	    //MAIN SETTING >>>>>>> Start
		if (sheet1.GetCellValue(lastRow1, "corr_no").indexOf("There is no data") == -1)
		formObj.corr_no.value=sheet1.GetCellValue(lastRow1, "corr_no");
		formObj.cust_ref_no.value=sheet1.GetCellValue(lastRow1, "cust_ref_no");
		formObj.obl_iss_flg.value=sheet1.GetCellValue(lastRow1, "obl_iss_flg");
		formObj.frt_term_cd.value=sheet1.GetCellValue(lastRow1, "frt_term_cd");
		formObj.vvd.value=sheet1.GetCellValue(lastRow1, "vvd");
		formObj.vsl_eng_nm.value=sheet1.GetCellValue(lastRow1, "vsl_eng_nm");
		formObj.pod_cd.value=sheet1.GetCellValue(lastRow1, "pod_cd");
		formObj.eta.value=sheet1.GetCellValue(lastRow1, "eta");
		formObj.pol_cd.value=sheet1.GetCellValue(lastRow1, "pol_cd");
		formObj.por_cd.value=sheet1.GetCellValue(lastRow1, "por_cd");
		formObj.del_cd.value=sheet1.GetCellValue(lastRow1, "del_cd");
  		//formObj.op_cntr_qty.value 	= sheet1.CellValue(lastRow1, "op_cntr_qty");
		formObj.pck_qty.value=sheet1.GetCellValue(lastRow1, "pck_qty");
		formObj.pck_tp_cd.value=sheet1.GetCellValue(lastRow1, "pck_tp_cd");
		formObj.act_wgt.value=sheet1.GetCellValue(lastRow1, "act_wgt");
		formObj.wgt_ut_cd.value=sheet1.GetCellValue(lastRow1, "wgt_ut_cd");
		formObj.meas_ut_cd.value=sheet1.GetCellValue(lastRow1, "meas_ut_cd");
		formObj.meas_qty.value=sheet1.GetCellValue(lastRow1, "meas_qty");
		//  		formObj.cust_ref_no.value 	= sheet1.CellValue(lastRow1, "mk_desc");
		formObj.cus_desc.value=sheet1.GetCellValue(lastRow1, "cmdt_desc");
		if (sheet1.GetCellValue(lastRow1, "bkg_cgo_tp_cd") == "P"){
  			formObj.empty.checked=true;
  		}  		
  		//MAIN SETTING >>>>>>> End
  		//CUSTOMER INFO. SETTING >>>>>>>>>>>> Start
  		if (sheet2.RowCount()> 0){
	  		for (var i=1 ; i <= lastRow2 ; i++){
					if (sheet2.GetCellValue(i, "bkg_cust_tp_cd") == "S"){
					formObj.s_cnt_cd.value=sheet2.GetCellValue(i, "cust_cnt_cd");
					formObj.s_seq.value=sheet2.GetCellValue(i, "cust_seq");
					formObj.s_nm.value=sheet2.GetCellValue(i, "cust_nm");
					formObj.s_addr.value=sheet2.GetCellValue(i, "cust_addr");
					formObj.s_fax.value=sheet2.GetCellValue(i, "cust_fax_no");
					}else if (sheet2.GetCellValue(i, "bkg_cust_tp_cd") == "C"){
					formObj.c_cnt_cd.value=sheet2.GetCellValue(i, "cust_cnt_cd");
					formObj.c_seq.value=sheet2.GetCellValue(i, "cust_seq");
					formObj.c_nm.value=sheet2.GetCellValue(i, "cust_nm");
					formObj.c_addr.value=sheet2.GetCellValue(i, "cust_addr");
					formObj.c_fax.value=sheet2.GetCellValue(i, "cust_fax_no");
					}else if (sheet2.GetCellValue(i, "bkg_cust_tp_cd") == "N"){
					formObj.n_cnt_cd.value=sheet2.GetCellValue(i, "cust_cnt_cd");
					formObj.n_seq.value=sheet2.GetCellValue(i, "cust_seq");
					formObj.n_nm.value=sheet2.GetCellValue(i, "cust_nm");
					formObj.n_addr.value=sheet2.GetCellValue(i, "cust_addr");
					formObj.n_fax.value=sheet2.GetCellValue(i, "cust_fax_no");
	  			}
	  		}
  		}
  		//CUSTOMER INFO. SETTING >>>>>>>>>>>> End
  		//MARKS&DESC INFO. SETTING >>>>>>>>>>>> Start
  		if (sheet3.RowCount()> 0){
	  		for (var i=1 ; i <= lastRow3 ; i++){
	  			ComClearCombo(formObj.mk_seq);
	  			ComAddComboItem(formObj.mk_seq, sheet3.GetCellValue(i, "mk_seq"), sheet3.GetCellValue(i, "mk_seq"));
	  			if (i == 1){
				formObj.loc_ts.value=sheet3.GetCellValue(i, "loc_ts");
				formObj.mk_desc.value=sheet3.GetCellValue(i, "mk_desc");
				formObj.cmdt_desc.value=sheet3.GetCellValue(i, "cmdt_desc");
	  			}
			}  		
  		}
  		//MARKS&DESC INFO. SETTING >>>>>>>>>>>> End
  		//CNTR Inquiry INFO. SETTING >>>>>>>>>>>> Start
  		if (sheet4.RowCount()> 0){
  			var sealNo="";
	  		for (var i=1 ; i <= lastRow4 ; i++){
	  			sealNo=ComReplaceStr(sheet4.GetCellValue(i, "cntr_seal_no"), ",", "|");
	  			sheet4.CellComboItem(i,"com_seal_no", {ComboText:sealNo, ComboCode:sealNo},0 );
	  			
	  		}
	  		
  		}  		
  		//CNTR Inquiry INFO. SETTING >>>>>>>>>>>> End
  	}
  	/*
  	 * Mark Seq Change
  	 */
  	function changeMkSeq(){
  		var formObj=document.form;
  		var sheet3=sheetObjects[2];
  		var idx=formObj.mk_seq.selectedIndex;
    	var mkSeq=formObj.mk_seq.options[idx].value;
    	for (var i=1 ; i <= sheet3.LastRow(); i++){
		if (sheet3.GetCellValue(i, "mk_seq") == mkSeq){
		formObj.loc_ts.value=sheet3.GetCellValue(i, "loc_ts");
		formObj.mk_desc.value=sheet3.GetCellValue(i, "mk_desc");
		formObj.cmdt_desc.value=sheet3.GetCellValue(i, "cmdt_desc");
    		}
    		break;
    	}
  	}
