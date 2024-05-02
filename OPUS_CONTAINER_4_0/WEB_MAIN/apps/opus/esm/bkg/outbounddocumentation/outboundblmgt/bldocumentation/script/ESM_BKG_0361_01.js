/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0361_01.js
*@FileTitle  :Export / Import Information (USA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /* developer job	*/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=0; 
var sheetObjects=new Array();
var sheetCnt=0;
var saveMsgFlg=true;
var isInquiry=false;
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name
    function processButtonClick(){
    	/*******************************************************/
    	var formObject=document.form;
    	var formObject2=document.form2;
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
					case "btn_save":
						 document.form4.tabclosechk.value="";
						 doActionIBSheet(sheetObject1, formObject, IBSAVE);
						 ComOpenWait(false);
						 sheetObject1.SetVisible(false);
                    break; 
					case "btn_close":	
						document.form4.tabclosechk.value="Y";
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
						if (saveMsgFlg) {
							if(document.form4.savechk.value==''){
								ComClosePopup(); 
							}
						} else {
							ComClosePopup();
						} 
                    break;
					case "btn_delete":
						if (!ComShowCodeConfirm("COM12188")) return;
						doActionIBSheet(sheetObject1, formObject, IBDELETE);
                    break; 
					case "btn_save2":
						document.form4.tabclosechk.value="";
						doActionIBSheet(sheetObject2, formObject2, IBSAVE);
                    break; 
					case "btn_close2":
						document.form4.tabclosechk.value="Y";
						doActionIBSheet(sheetObject2, formObject2, IBSAVE);
						if (saveMsgFlg) {
							if(document.form4.savechk.value==''){
								ComClosePopup(); 
							}
						} else {
							ComClosePopup();
						}
                    break;
					case "btn_delete2":
						if (!ComShowCodeConfirm("COM12188")) return;
						doActionIBSheet(sheetObject2, formObject2, IBDELETE);
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
	* initializing sheet
	* implementing onLoad event handler in body tag
	* adding first-served functions after loading screen.
	*/
    function loadPage() {
   		var localopener = (opener || parent);
   		isInquiry=localopener.document.form.isInquiry && "Y"==ComGetObjValue(localopener.document.form.isInquiry);
   		if(document.form.popUpTpCd.value=="E"||document.form.popUpTpCd.value=="S" || isInquiry){
    		ComBtnDisable("btn_save");
    		ComBtnDisable("btn_delete");
    		ComBtnDisable("btn_save2");
    		ComBtnDisable("btn_delete2");
    	}
    	if(document.form.popUpTpCd.value!="S"){
	        if(document.form3.bkg_no.value == ''){ 
	        	ComShowCodeMessage("COM12114","Booking Number");   
	        	ComClosePopup(); 
	        	return;
	        }
    	}
    	for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        for(var i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
        initControl();
        if(document.form3.get_io_bnd_cd.value != 'I') {
        	beforetab=0; 
        	tab1.SetSelectedIndex(0);
        	var ctxName="/opus";
        	if(document.form4.savechk.value==''){
	        	if(document.form3.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
					if (document.form3.pol_cd.value.substring(0,2)=='KR'){
						sendForm("ESM_BKG_0361_02.do","O","KR");
					}else if (document.form3.pol_cd.value.substring(0,2)=='BR'){
						sendForm("ESM_BKG_0361_03.do","O","BR");
					}else if (document.form3.pol_cd.value.substring(0,2)=='IN'){
						sendForm("ESM_BKG_0361_04.do","O","IN");
					}else if (document.form3.pol_cd.value.substring(0,2)=='ID'){
						sendForm("ESM_BKG_0361_05.do","O","ID");
					}else if (document.form3.pol_cd.value.substring(0,2)=='CA'){
						sendForm("ESM_BKG_0361_06.do","O","CA");
					}else if (document.form3.pol_cd.value.substring(0,2)=='MX'){
						sendForm("ESM_BKG_0361_07.do","O","MX");
					}else if (document.form3.pol_cd.value.substring(0,2)=='CO'){
						sendForm("ESM_BKG_0361_07.do","O","CO");
					}else if (document.form3.pol_cd.value.substring(0,2)=='EC'){
						sendForm("ESM_BKG_0361_07.do","O","EC");
					}else if (document.form3.pol_cd.value.substring(0,2)=='PE'){
						sendForm("ESM_BKG_0361_07.do","O","PE");
					}else if (document.form3.pol_cd.value.substring(0,2)=='AR'){
						sendForm("ESM_BKG_0361_07.do","O","AR");
					}else {
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
					}
				}else{
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
				}
        	}
        } else {
        	beforetab=1; 
        	tab1.SetSelectedIndex(1);
        	objs=document.all.item("tabLayer");
        	objs[1].style.display="Inline";
        	objs[0].style.display="none";        	
        	var ctxName="/opus";
        	if(document.form4.savechk.value==''){
	        	if(document.form3.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
	        		if (document.form3.pod_cd.value.substring(0,2)=='BR'){
						sendForm("ESM_BKG_0361_03.do","I","BR");
					}else if (document.form3.pod_cd.value.substring(0,2)=='IN'){
						sendForm("ESM_BKG_0361_04.do","I","IN");
					}else if (document.form3.pod_cd.value.substring(0,2)=='MX'){
						sendForm("ESM_BKG_0361_07.do","I","MX");
					}else if (document.form3.pod_cd.value.substring(0,2)=='ID'){
						sendForm("ESM_BKG_0361_05.do","I","ID");
					}else {
						sendForm("ESM_BKG_0361_03.do","I","BR");
					}
				}else{
					sendForm("ESM_BKG_0361_03.do","I","BR");
				}
        	}
        }
    }
    /**
    * register Tab Object to tabObjects array
    */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Basic setting Tab
     */
    function initTab(tabObj , tabNo) {
        with (tabObj) {
				InsertItem( "Export" , "");
				InsertItem( "Import" , "");
				SetSelectedIndex(0);
        }
    }
    function tab1_OnClick(tabObj, nItem){
    	var objs=document.all.item("tabLayer");
    	if(tab1.GetSelectedIndex()==0){
    		if(document.form4.savechk.value=='N'&&objs[0].style.display == "none"){ 
    			tab1_OnChange(tabObj , nItem)
       	    }
  	 	}else if(tab1.GetSelectedIndex()==1){
  	 		if(document.form4.savechk.value=='N'&&objs[1].style.display == "none"){
  	 			tab1_OnChange(tabObj , nItem)
       	    } 	 			
  	 	}  
    }
    /**
     *  Tab event
     */
    function tab1_OnChange(tabObj , nItem) {
    	if (nItem==beforetab) return;
    	
    	var objs=document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	objs[beforetab].style.display="none";
     	beforetab=nItem;
     	var ctxName="/opus";
   		var formObj=document.form3;
   		switch(nItem) {
   			case 0:	
   				document.form4.tabclosechk.value="Y";
   				doActionIBSheet(sheetObjects[1], document.form2, IBSAVE);
   				if (saveMsgFlg) {
	   				document.form.go_cnt_cd.value='';
	   				if( document.form4.savechk.value==''){
		   				if(formObj.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
		   				 	if (formObj.pol_cd.value.substring(0,2)=='KR'){
								sendForm("ESM_BKG_0361_02.do","O" ,"KR");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","O" , "BR");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='IN'){
								sendForm("ESM_BKG_0361_04.do","O" , "IN");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='ID'){
								sendForm("ESM_BKG_0361_05.do","O" , "ID");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='CA'){
								sendForm("ESM_BKG_0361_06.do","O" , "CA");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='MX'){
								sendForm("ESM_BKG_0361_07.do","O" , "MX");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='CO'){
								sendForm("ESM_BKG_0361_07.do","O" , "CO");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='EC'){
								sendForm("ESM_BKG_0361_07.do","O" , "EC");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='PE'){
								sendForm("ESM_BKG_0361_07.do","O" , "PE");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='AR'){
								sendForm("ESM_BKG_0361_07.do","O","AR");
							}else {
		   						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
		   					}
		   				}else{
		   					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
		   				}
	   				}
   				} else {
   	   				document.form4.tabclosechk.value="";
   	   				saveMsgFlg=true;
   				}
   				break;
   			case 1:
   				document.form4.tabclosechk.value="Y";
   				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
   				if (saveMsgFlg) {
	   				document.form.go_cnt_cd.value='';
	   				if( document.form4.savechk.value==''){
	   					
		   				if(formObj.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
		   					if (formObj.pod_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","I" , "BR");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='IN'){
								sendForm("ESM_BKG_0361_04.do","I" , "IN");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='MX'){
								sendForm("ESM_BKG_0361_07.do","I" , "MX");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='ID'){
								sendForm("ESM_BKG_0361_05.do","I" , "ID");
		   					}else {
		   						sendForm("ESM_BKG_0361_03.do","I" , "BR");
		   					}
		   				}else{
		   					sendForm("ESM_BKG_0361_03.do","I" , "BR");
		   				}
	   				}
   				} else {
   					if (formObj.pod_cd.value.substring(0,2)=='BR'){
						sendForm("ESM_BKG_0361_03.do","I" , "BR");
   					}else if (formObj.pod_cd.value.substring(0,2)=='IN'){
						sendForm("ESM_BKG_0361_04.do","I" , "IN");
   					}else if (formObj.pod_cd.value.substring(0,2)=='MX'){
						sendForm("ESM_BKG_0361_07.do","I" , "MX");
   					}else if (formObj.pod_cd.value.substring(0,2)=='ID'){
						sendForm("ESM_BKG_0361_05.do","I" , "ID");
   					}else {
   						sendForm("ESM_BKG_0361_03.do","I" , "BR");
   					}
   				}
   				break;   
   		}	
    }
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
 	function setSheetObject(sheet_obj){
 	   sheetObjects[sheetCnt++]=sheet_obj;
 	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
 	function initSheet(sheetObj,sheetNo) {
 		var cnt=0;
 		switch(sheetNo) {
 			case 1:      //sheet1 init
 			    with(sheetObj){
	 		      var HeadTitle="|Seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|aes_tp_cd|aes_inlnd_trns_no|aes_pta_no1|aes_pta_no2|aes_pta_dt|aes_ptu_no|aes_ptu_dt|aes_dwn_no|aes_dwn_dt|aes_expt_id|aes_expt_ctnt";
	
	 		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	 		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	 		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	 		      InitHeaders(headers, info);
	
	 		      var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	 		             {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	 		             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",             KeyField:1 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_inlnd_trns_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_pta_no1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_pta_no2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_pta_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_ptu_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_ptu_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_dwn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_dwn_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_expt_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_expt_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	 		       
	 		      InitColumns(cols);
	 		      SetVisible(false);
	 		      SetEditable(1);
 				}


 			break;
 			case 2:      //sheet1 init
 			    with(sheetObj){
	 		      var HeadTitle="|Seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|aes_tp_cd|aes_inlnd_trns_no|aes_pta_no1|aes_pta_no2|aes_pta_dt|aes_ptu_no|aes_ptu_dt|aes_dwn_no|aes_dwn_dt|aes_expt_id|aes_expt_ctnt";
	 		      var headCount=ComCountHeadTitle(HeadTitle);
	
	 		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	 		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	 		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	 		      InitHeaders(headers, info);
	
	 		      var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	 		             {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	 		             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",             KeyField:1 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_inlnd_trns_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_pta_no1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_pta_no2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_pta_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_ptu_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_ptu_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_dwn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_dwn_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_expt_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aes_expt_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	 		       
	 		      InitColumns(cols);
	 		      SetEditable(1);
	 		      SetVisible(false);
 		        }
 			break;
 		}
 	}
 	// handling of Sheet process
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		sheetObj.SetWaitImageVisible(0);
 		//sheetObj.ShowDebugMsg = false;
 		switch(sAction) {
 			case IBSEARCH:      // retrieve
 		 		ComOpenWait(true);
 				if(validateForm(sheetObj, formObj, sAction)) {
 					formObj.f_cmd.value=SEARCH;
 					//sheetObj.DoSearch("ESM_BKG_0361_01GS.do", FormQueryString(formObj));
 					var sXml=sheetObj.GetSearchData("ESM_BKG_0361_01GS.do", FormQueryString(formObj));
 					var arrXml=sXml.split("|$$|");
 					if (arrXml[0].length > 0) {
 						sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
 					}
 					if (arrXml[1].length > 0) {
 		                ComXml2ComboItem(arrXml[1], exp_aes_expt_id, "val", "name");
 		                ComXml2ComboItem(arrXml[1], imp_aes_expt_id, "val", "name");
 		               	if (1==sheetObj.RowCount()) {
 		               		exp_aes_expt_id.SetSelectCode(sheetObj.GetCellValue(1,"aes_expt_id"));
 		               	}
 					}
 				}
 		 		ComOpenWait(false);
 			break;
 			case IBSAVE:        // save
 				
//	 			if(document.form4.tabclosechk.value=="Y"){
//	 				if(formObj.name=="form"){
//		 				obj=formObj.exp_aes_tp_cd;	
//			 			for(var i=0; i<obj.length; i++){
//					        if(obj[i].checked==true){
//					        	switch(obj[i].value) {
//						        	case "AE": 
//						        		if(formObj.exp_aes_inlnd_trns_no.value==''){
//						        			if (!ComShowCodeConfirm("BKG00254")) return;
//						        		}
//				 						break;
//						        	case "PA": 
//						        		if(formObj.exp_aes_pta_no1.value==''){
//						        			if (!ComShowCodeConfirm("BKG00254")) return;
//						        		}
//						        		break;
//						        	case "PU": 
//						        		if(formObj.exp_aes_ptu_no.value==''){
//						        			if (!ComShowCodeConfirm("BKG00254")) return;
//						        		}
//							        	break;
//						        	case "DN": 
//						        		if(formObj.exp_aes_dwn_no.value==''){		
//						        			if (!ComShowCodeConfirm("BKG00254")) return;
//						        		}
//							        	break;
//						        	case "EX": 
//						        		if(exp_aes_expt_id.GetSelectCode()==''){
//						        			if (!ComShowCodeConfirm("BKG00254")) return;
//						        		}
//							        	break;
//					        	}
//					        }
//					    }
//	 				}
//	 			}
 				if(validateForm(sheetObj,formObj,sAction)) {
 					document.form4.savechk.value="";
 					var obj="";
 					if (sheetObj.RowCount()==0){
 						initSheetData(sheetObj);
 					} 
 					if(formObj.name=="form"){
 						IBS_CopyFormToRow(formObj,sheetObj, 1, "exp_");
 						obj=formObj.exp_aes_tp_cd;	
 						sheetObj.SetCellValue(1,"cnt_cd","US");
 						sheetObj.SetCellValue(1,"aes_expt_id",exp_aes_expt_id.GetSelectCode());
 					}else if(formObj.name=="form2"){
 						IBS_CopyFormToRow(formObj,sheetObj, 1, "imp_"); 					
 						obj=formObj.imp_aes_tp_cd;
 						sheetObj.SetCellValue(1,"cnt_cd","US");
 						sheetObj.SetCellValue(1,"aes_expt_id",imp_aes_expt_id.GetSelectCode());
 					}
				    for(var i=0; i<obj.length; i++){
				        if(obj[i].checked==true){
				        	sheetObj.SetCellValue(1,"aes_tp_cd",obj[i].value);
				        }
				    }
				    if (sheetObj.GetCellValue(1,"aes_tp_cd")=='0'){
 						sheetObj.SetCellValue(1,0,'D');
				    }

 					formObj.f_cmd.value=MULTI;
 					var SaveStr = sheetObj.GetSaveString();
 					if(document.form4.tabclosechk.value=="Y"){
	 					if (!sheetObj.IsDataModified() && SaveStr == "") return;
						if(confirm(ComGetMsg("BKG00962"))){
					 		ComOpenWait(true);
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_01GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
							sheetObj.LoadSaveData(rtnData); 	
					 		ComOpenWait(false);
						} 
 					}else{
	 					if (!sheetObj.IsDataModified() && SaveStr == ""){
							//There is no data to Save. Please check again.
							ComShowCodeMessage("BKG95053");
	 						return;
	 					}
						if(confirm(ComGetMsg("BKG00962"))){
					 		ComOpenWait(true);
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_01GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
							sheetObj.LoadSaveData(rtnData); 	
					 		ComOpenWait(false);
						} 
 					}
 				}
 			break;
 			case IBDELETE:      // insert
 				if(formObj.name=="form"){
	 				var obj=formObj.exp_aes_tp_cd;
		    		for(var i=0; i<obj.length; i++){      
				        obj[i].checked=false
				    }
		    		for(var i=0; i<obj.length; i++){      
		    			radioBtnSet(obj[i]);
		    		}
 				}else{
 					var obj2=formObj.imp_aes_tp_cd;
		    		for(var i=0; i<obj2.length; i++){      
		    			obj2[i].checked=false
				    }
		    		for(var i=0; i<obj2.length; i++){      
		    			radioBtnSet(obj2[i]);
		    		}
 				}
 				if(sheetObj.GetRowStatus(1) == "I"){
 					sheetObj.RowDelete(1 , 0);
 				} else {
 					sheetObj.SetCellValue(1,0,'D');
 				}
			break;	
 		}
 		ComOpenWait(false);
 	}
 	function setTab1(){
    	beforetab=0;
     	tab1.SetSelectedIndex(0);
		objs[0].style.display="Inline";
		objs[1].style.display="none"; 
		document.form4.savechk.value="N";
    }
    function setTab2(){
    	beforetab=1;
    	tab1.SetSelectedIndex(1);
		objs[0].style.display="none";
     	objs[1].style.display="Inline"; 	
     	document.form4.savechk.value="N";
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	if(sAction==undefined)	sAction='2';	//copyDesc 체크로직 추가(validateForm("",formObj))
    	
    	if(sAction=='2'){	
	 		if(formObj.name=="form"){
		 		size=formObj.exp_aes_tp_cd.length;	
				for(var i=0; i < size; i++) {
				  if(formObj.exp_aes_tp_cd[i].checked) {
					objs=document.all.item("tabLayer");
					if (formObj.exp_aes_tp_cd[i].value=="EX"&&exp_aes_expt_id.GetSelectCode()!=""&&formObj.exp_aes_expt_ctnt.value!=""){
						setTab1();		             	
		             	ComAlertFocus(exp_aes_expt_id, ComGetMsg("BKG00198"));
	        			saveMsgFlg=false;
						return false;
						break;
					}
					switch(formObj.exp_aes_tp_cd[i].value) {
				        case "AE":     
				        	 if(formObj.exp_aes_inlnd_trns_no.value==''){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_inlnd_trns_no, ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	 if (!ComIsAesNo(formObj.exp_aes_inlnd_trns_no.value)){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_inlnd_trns_no, ComGetMsg("COM12128","a valid format : ANNNNNNNNNNNNN"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }else{
				        		 var re=new RegExp('([A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
				        		 formObj.exp_aes_inlnd_trns_no.value=formObj.exp_aes_inlnd_trns_no.value.replace(re,'$1').toUpperCase();
				        	 }
				        	 break;
				        case "PA": 
				        	 if(formObj.exp_aes_pta_no1.value==''||formObj.exp_aes_pta_no1.value.length<9){
				        		 setTab1();
				             	 ComAlertFocus(formObj.exp_aes_pta_no1,  ComGetMsg("COM12114"));
				             	 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	 if(formObj.exp_aes_pta_no2.value==''||formObj.exp_aes_pta_no2.value.length<9){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_pta_no2,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false; 
				        		 break;
				        	 }
				        	 if(formObj.exp_aes_pta_dt.value==''){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_pta_dt,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }	
			        	 	sVal=ComTrimAll(formObj.exp_aes_pta_dt.value, "-", "/", ".");
		                    if (!ComIsDateMod(formObj.exp_aes_pta_dt.value)){
		                    	 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_pta_dt,  ComGetMsg("COM12187","MM-DD-YYYY"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
		                    }else{
		                    	var re=new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                    	formObj.exp_aes_pta_dt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                    }		                    
		                    break;
				        case "PU":
				        	 if(formObj.exp_aes_ptu_no.value==''||formObj.exp_aes_ptu_no.value.length<9){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_ptu_no,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	 if(formObj.exp_aes_ptu_dt.value==''){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_ptu_dt,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	 sVal=ComTrimAll(formObj.exp_aes_ptu_dt.value, "-", "/", ".");
			                    if (!ComIsDateMod(formObj.exp_aes_ptu_dt.value)){
			                    	setTab1();
					        		 ComAlertFocus(formObj.exp_aes_ptu_dt, ComGetMsg("COM12187","MM-DD-YYYY"));
					        		 saveMsgFlg=false;
					        		 return false;
					        		 break;
			                    }else{
			                    	var re=new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
			                    	formObj.exp_aes_ptu_dt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
			                    }		
				        	 break;
				        case "DN":				        	 
				        	if(formObj.exp_aes_dwn_no.value==''||formObj.exp_aes_dwn_no.value.length<9){
				        		setTab1();
				        		 ComAlertFocus(formObj.exp_aes_dwn_no,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	if(formObj.exp_aes_dwn_dt.value==''){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_dwn_dt,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	sVal=ComTrimAll(formObj.exp_aes_dwn_dt.value, "-", "/", ".");
		                    if (!ComIsDateMod(formObj.exp_aes_dwn_dt.value)){
		                    	 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_dwn_dt, ComGetMsg("COM12187","MM-DD-YYYY"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
		                    }else{
		                    	var re=new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                    	formObj.exp_aes_dwn_dt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                    }		
				        	break;
				        case "EX":
				        	if(exp_aes_expt_id.GetSelectCode()==''&&formObj.exp_aes_expt_ctnt.value==''){
				        		setTab1();
				        		 ComAlertFocus(exp_aes_expt_id,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	}
				        	break;
					 }
				  }
				}
	 		}else if(formObj.name=="form2"){
	 			size2=formObj.imp_aes_tp_cd.length;	
				for(var j=0; j < size2; j++) {
				  if(formObj.imp_aes_tp_cd[j].checked) {
					objs=document.all.item("tabLayer");
					if (formObj.imp_aes_tp_cd[j].value=="EX"&&imp_aes_expt_id.GetSelectCode()!=""&&formObj.imp_aes_expt_ctnt.value!=""){
						setTab2();
						ComAlertFocus(imp_aes_expt_id, ComGetMsg("BKG00198"));
						saveMsgFlg=false;
						return false;
						break;
					}
					switch(formObj.imp_aes_tp_cd[j].value) {
				        case "AE":
				        	 if(formObj.imp_aes_inlnd_trns_no.value==''){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_inlnd_trns_no, ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	 if (!ComIsAesNo(formObj.imp_aes_inlnd_trns_no.value)){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_inlnd_trns_no, ComGetMsg("COM12128","a valid format : ANNNNNNNNNNNNN"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }else{
				        		 var re=new RegExp('([A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
				        		 formObj.imp_aes_inlnd_trns_no.value=formObj.imp_aes_inlnd_trns_no.value.replace(re,'$1').toUpperCase();
				        	 }
				        	 break;
				        case "PA": 
				        	 if(formObj.imp_aes_pta_no1.value==''||formObj.imp_aes_pta_no1.value.length<9){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_pta_no1,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	 if(formObj.imp_aes_pta_no2.value==''||formObj.imp_aes_pta_no2.value.length<9){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_pta_no2,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	 if(formObj.imp_aes_pta_dt.value==''){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_pta_dt,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	 sVal=ComTrimAll(formObj.imp_aes_pta_dt.value, "-", "/", ".");
		                    if (!ComIsDateMod(formObj.imp_aes_pta_dt.value)){
		                    	 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_pta_dt, ComGetMsg("COM12187","MM-DD-YYYY"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
		                    }else{
		                    	var re=new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                    	formObj.imp_aes_pta_dt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                    }		
				        	 break;
				        case "PU":
				        	 if(formObj.imp_aes_ptu_no.value==''||formObj.imp_aes_ptu_no.value.length<9){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_ptu_no,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	 if(formObj.imp_aes_ptu_dt.value==''){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_ptu_dt,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	 sVal=ComTrimAll(formObj.imp_aes_ptu_dt.value, "-", "/", ".");
		                    if (!ComIsDateMod(formObj.imp_aes_ptu_dt.value)){
		                    	setTab2();
				        		 ComAlertFocus(formObj.imp_aes_ptu_dt, ComGetMsg("COM12187","MM-DD-YYYY"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
		                    }else{
		                    	var re=new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                    	formObj.imp_aes_ptu_dt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                    }		
				        	 break;
				        case "DN":				        	 
				        	if(formObj.imp_aes_dwn_no.value==''||formObj.imp_aes_dwn_no.value.length<9){
				        		setTab2();
				        		 ComAlertFocus(formObj.imp_aes_dwn_no,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	if(formObj.imp_aes_dwn_dt.value==''){
				        		setTab2();
				        		 ComAlertFocus(formObj.imp_aes_dwn_dt,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	 }
				        	 sVal=ComTrimAll(formObj.imp_aes_dwn_dt.value, "-", "/", ".");
		                    if (!ComIsDateMod(formObj.imp_aes_dwn_dt.value)){
		                    	setTab2();
				        		 ComAlertFocus(formObj.imp_aes_dwn_dt, ComGetMsg("COM12187","MM-DD-YYYY"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
		                    }else{
		                    	var re=new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                    	formObj.imp_aes_dwn_dt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                    }		
				        	break;
				        case "EX":
				        	if(imp_aes_expt_id.GetSelectCode()==''&&formObj.imp_aes_expt_ctnt.value==''){
				        		setTab2();
				        		 ComAlertFocus(imp_aes_expt_id,  ComGetMsg("COM12114"));
				        		 saveMsgFlg=false;
				        		 return false;
				        		 break;
				        	}
				        	break;
					 }
				  }
				}	 			
	 		}	 		
		} 
		return true;
    }
    function setOptionValue(comboObj, val) {
    	for(i=0;i<comboObj.length;i++) {
    		if(val == comboObj.options[i].value)  comboObj.options[i].selected=true;
    	}
    }
 // initialize Sheet Data
    function initSheetData(sheetObj) {
    	sheetObj.RemoveAll();
    	sheetObj.DataInsert(-1);
    }
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	formObj=document.form;
    	var obj=formObj.exp_aes_tp_cd;
    	if (sheetObj.RowCount()> 0){
    		IBS_CopyRowToForm(sheetObj,formObj, 1, "exp_"); 
    		for(var i=0; i<obj.length; i++){
    			if(obj[i].value==sheetObj.GetCellValue(1,"aes_tp_cd")){
 		        	obj[i].checked=true;
 		        }else{
 		        	obj[i].checked=false;
 		        }
 		    }
    	}/*else{
    		initSheetData(sheetObj);
            IBS_CopyFormToRow(formObj,sheetObj, 1, "exp_"); 
            for(var i=0; i<obj.length; i++){
		        if(obj[i].checked==true){
		        	sheetObj.SetCellValue(1,"aes_tp_cd",obj[i].value);
		        }
		    }
    	}*/
		for(var i=0; i<obj.length; i++){
			radioBtnSet(obj[i]);
		}
    	document.form3.get_io_bnd_cd.value="O";
    }
    function sheet2_OnSearchEnd(sheetObj,ErrMsg){
    	formObj=document.form2;
    	var obj=formObj.imp_aes_tp_cd;
    	if (sheetObj.RowCount()>0){
    		IBS_CopyRowToForm(sheetObj, formObj, 1, "imp_"); 
    		for(var i=0; i<obj.length; i++){
    			if(obj[i].value==sheetObj.GetCellValue(1,"aes_tp_cd")){
 		        	obj[i].checked=true;
 		        }else{
 		        	obj[i].checked=false;
 		        }
 		    }
    	}/*else{
    		initSheetData(sheetObj);
            IBS_CopyFormToRow(formObj,sheetObj, 1, "imp_"); 
            for(var i=0; i<obj.length; i++){
		        if(obj[i].checked==true){
		        	sheetObj.SetCellValue(1,"aes_tp_cd",obj[i].value);
		        }
		    }
    	}*/
		for(var i=0; i<obj.length; i++){
			radioBtnSet(obj[i]);
		}
    	document.form3.get_io_bnd_cd.value="I";
    }
    function sheet1_OnSaveEnd(sheetObj,code, ErrMsg){
    	if(code == 0)  saveMsgFlg = true;
    	else saveMsgFlg = false;
    	//saveMsgFlg=ComIsNull(ErrMsg);
		if (saveMsgFlg) {
			ComShowCodeMessage("BKG00166");  //Data Saved Successfully!!
		} else {
			ComShowCodeMessage("BKG00167");  //Data Save Action Failed!!
		}
        if(document.form4.tabclosechk.value==""){
        	doActionIBSheet(sheetObj, document.form, IBSEARCH);
        }
    }
    function sheet2_OnSaveEnd(sheetObj, code , ErrMsg){
    	if(code == 0)  saveMsgFlg = true;
    	else saveMsgFlg = false;
    	//saveMsgFlg=ComIsNull(ErrMsg);
		if (saveMsgFlg) {
			ComShowCodeMessage("BKG00166");  //Data Saved Successfully!!
		} else {
			ComShowCodeMessage("BKG00167");  //Data Save Action Failed!!
		}
    	if(document.form4.tabclosechk.value==""){
    		doActionIBSheet(sheetObj, document.form2, IBSEARCH);
    	}
    }
    function initControl() {    	

    }

    function ComClearSeparatorMod(obj,sFormat,sDelim)
    {
        try{
            if (typeof(obj) != "object" ) return;
            sFormat=getDataFormat(obj, sFormat);
            obj.value=ComTrimAll(obj.value,"-");            
            if (obj.type == 'text' && obj.value.length >=1 && obj.onfocus==null) obj.onfocus=new Function("this.select()");
			//event.returnValue=true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    function ComChkObjValidMod(obj, bMsg, bTrim, bMasked){
        try {
            var sTitle="";
            var sMsg="";
            var props=new Array("dataformat", "maxLength", "minlength");
            if (bMsg==undefined || bMsg==null)            bMsg=true;
            if (bTrim==undefined || bTrim==null)          bTrim=true;
            if (bMasked==undefined || bMasked==null)      bMasked=true;
            var sFormat="";
            var sVal="";
            var maskValue="";
            var iMaxLen=0, iMaxVal=null, iMinVal=null;
            sVal=ComGetObjValue(obj)            
            if(bTrim) sVal=ComTrim(sVal);
            maskValue=sVal;
            for(var j=0; j<props.length; j++){
                var attriVal=obj.getAttribute(props[j]);
                //ComDebug(props[j] + "=" + attriVal);
                if (attriVal == null) continue;
                switch(props[j]) {
                    case "dataformat":  
                        sFormat=attriVal;
                        if (sVal== "") continue;
                        maskValue=ComGetMaskedValueMod(obj, sFormat);
                        if (sVal != maskValue && sFormat.indexOf("eng")>=0) obj.value=maskValue;
                        if (maskValue!= "") continue;
                        switch(sFormat) {
                            case "mdy":     //mm-dd-yyyy
                                sMsg=ComGetMsg("COM12187","MM-DD-YYYY");
                            break;  
                            case "aesno":     //mm-dd-yyyy
                            	sMsg=ComGetMsg("COM12128","a valid format : ANNNNNNNNNNNNN");
                            break; 
                        }
                        break;
                    case "maxLength":   //max Length
	                    if (sVal== "") continue;
	                    iMaxLen=attriVal;
	                    //ComDebug("iMaxLen=" + iMaxLen);
	                    if(ComGetLenByByte(sVal) > iMaxLen) sMsg=ComGetMsg('COM12142', sTitle, attriVal);
                    break;
	                    case "minlength":   //min length
	                    if (sVal== "") continue;
	                    if(ComGetLenByByte(sVal) < attriVal) sMsg=ComGetMsg('COM12143', sTitle, attriVal);
                    break;
                }
                if (sMsg!="") {
                	if(event == null){
                		if (bMsg) ComShowMessage(sMsg);
 		                obj.focus(); 
		                obj.select(); 
                	}else{
	                	var canFocusOut=(event.srcElement == obj && (sVal=="" || obj.getAttribute("readOnly")==true));
                		if (bMsg && !canFocusOut) ComShowMessage(sMsg);
	                    try{                     	
	                    	if(canFocusOut) {
	                    		event.returnValue=true;
	                    	} else {
		                    	event.cancelBubble=true;
		                    	event.returnValue=false;
		                    	obj.focus(); 
		                    	obj.select();		                    	
		                    }
	                    } catch(ee) {;}
	                }
                	return false;                	
                }
            }
            if (bMasked && sFormat != "") {
            	obj.value=ComGetMaskedValueMod(obj, sFormat);
            }
        } catch(err) { ComFuncErrMsg(err.message); }
        return true;
    }
    function ComGetMaskedValueMod(obj, sFormat, sDelim) {
        try {
            var sVal=String(getArgValue(obj));
            if (ComIsEmpty(sVal)) return "";
            var sRegExp="";
            var sReplaceText="";
            var sResultVal="";
            var sDelim="-";
            switch(sFormat) {
                case "mdy":     //mm-dd-yyyy
                    sVal=ComTrimAll(sVal, "-", "/", ".");
                    if (!ComIsDateMod(sVal)) break;
                    var re=new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
                    sResultVal=sVal.replace(re,'$1' + sDelim + '$2' + sDelim + '$3');
                    break;
                case "aesno":   
	                sVal=ComTrimAll(sVal, "-");
	                if (!ComIsAesNo(sVal)) break;
	                var re=new RegExp('([A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
	                sResultVal=sVal.replace(re,'$1').toUpperCase();
	                break;
                case "int":     
                if (!ComIsNumber(sVal)) break;
	                sResultVal=sVal;
	                break;
                default :
                    return "";
            }
            return sResultVal;
        } catch(err) { ComFuncErrMsg(err.message); }
    } 
    function ComIsDateMod(obj, sFlag) {
        try {
            var sVal=getArgValue(obj);
            sVal=sVal.replace(/\/|\-|\./g,"");
            if (!ComIsNumber(sVal)) return false;
            if (sFlag==undefined || sFlag==null) sFlag="mdy";
            var year, month, day, week;
                if (sVal.length != 8) return false;
                year=sVal.substring(4,8);
                month=sVal.substring(0,2);
                day=sVal.substring(2,4);
                if((ComParseInt(year) < 1900)  || !ComIsMonth( month ) || !ComIsDay( year,month ,day)) return false;
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    function ComIsAesNo(obj, sFlag) {
        try {
            var sVal=getArgValue(obj);
            sVal=sVal.replace(/\/|\-|\./g,"");
            if (sVal.length != 15) return false;
            if (!ComIsNumber(sVal.substring(1,15))) return false;
            if (!isAlpha(sVal.substring(0,1))) return false;      
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    function isAlpha(str) {
        var pattern=/^[a-zA-Z]+$/;
        return (pattern.test(str)) ? true : false;
    }
    function radioBtnSet(obj){
    	var formObj=document.form;
    	var formObj2=document.form2;
    	if(obj.name=='exp_aes_tp_cd'&& obj.checked==true){ 
    		var obj2=formObj.exp_aes_tp_cd;
		    for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		            obj2[i].checked=false;
		        }
		    }
	    	switch(obj.value) {
		        case "AE":
		        	 formObj.exp_aes_inlnd_trns_no.focus();
		        	 formObj.exp_aes_inlnd_trns_no.readOnly=false;
		             formObj.exp_aes_pta_no1.value='';
		             formObj.exp_aes_pta_no1.readOnly=true;
		             formObj.exp_aes_pta_no2.value='';
		             formObj.exp_aes_pta_no2.readOnly=true;
		             formObj.exp_aes_pta_dt.value='';
		             formObj.exp_aes_pta_dt.readOnly=true;
		             formObj.exp_aes_ptu_no.value='';
		             formObj.exp_aes_ptu_no.readOnly=true;
		             formObj.exp_aes_ptu_dt.value='';
		             formObj.exp_aes_ptu_dt.readOnly=true;
		             formObj.exp_aes_dwn_no.value='';
		             formObj.exp_aes_dwn_no.readOnly=true;
		             formObj.exp_aes_dwn_dt.value='';
		             formObj.exp_aes_dwn_dt.readOnly=true;
		             exp_aes_expt_id.SetSelectCode( -1, true);
		             exp_aes_expt_id.SetEnable(0);
		             formObj.exp_aes_expt_ctnt.value='';
		             formObj.exp_aes_expt_ctnt.readOnly=true;
		             break;
		        case "PA": 
		        	 formObj.exp_aes_pta_no1.focus();
		             formObj.exp_aes_pta_no1.readOnly=false;
		             formObj.exp_aes_pta_no2.readOnly=false;
		             formObj.exp_aes_pta_dt.readOnly=false;
		             formObj.exp_aes_inlnd_trns_no.value='';
		        	 formObj.exp_aes_inlnd_trns_no.readOnly=true;
		             formObj.exp_aes_ptu_no.value='';
		             formObj.exp_aes_ptu_no.readOnly=true;
		             formObj.exp_aes_ptu_dt.value='';
		             formObj.exp_aes_ptu_dt.readOnly=true;
		             formObj.exp_aes_dwn_no.value='';
		             formObj.exp_aes_dwn_no.readOnly=true;
		             formObj.exp_aes_dwn_dt.value='';
		             formObj.exp_aes_dwn_dt.readOnly=true;
		             exp_aes_expt_id.SetSelectCode("", true);
		             exp_aes_expt_id.SetEnable(0);
		             formObj.exp_aes_expt_ctnt.value='';
		             formObj.exp_aes_expt_ctnt.readOnly=true;
		             break;
		        case "PU":
		        	 formObj.exp_aes_ptu_no.focus();
		             formObj.exp_aes_ptu_no.readOnly=false;
		             formObj.exp_aes_ptu_dt.readOnly=false;
		             formObj.exp_aes_inlnd_trns_no.value='';
		        	 formObj.exp_aes_inlnd_trns_no.readOnly=true;
		             formObj.exp_aes_pta_no1.value='';
		             formObj.exp_aes_pta_no1.readOnly=true;
		             formObj.exp_aes_pta_no2.value='';
		             formObj.exp_aes_pta_no2.readOnly=true;
		             formObj.exp_aes_pta_dt.value='';
		             formObj.exp_aes_pta_dt.readOnly=true;
		             formObj.exp_aes_dwn_no.value='';
		             formObj.exp_aes_dwn_no.readOnly=true;
		             formObj.exp_aes_dwn_dt.value='';
		             formObj.exp_aes_dwn_dt.readOnly=true;
		             exp_aes_expt_id.SetSelectCode("", true);
		             exp_aes_expt_id.SetEnable(0);
		             formObj.exp_aes_expt_ctnt.value='';	
		             formObj.exp_aes_expt_ctnt.readOnly=true;
		             break;
		        case "DN":
		        	 formObj.exp_aes_dwn_no.focus();
		             formObj.exp_aes_dwn_no.readOnly=false;
		             formObj.exp_aes_dwn_dt.readOnly=false;
		             formObj.exp_aes_inlnd_trns_no.value='';
		        	 formObj.exp_aes_inlnd_trns_no.readOnly=true;
		             formObj.exp_aes_pta_no1.value='';
		             formObj.exp_aes_pta_no1.readOnly=true;
		             formObj.exp_aes_pta_no2.value='';
		             formObj.exp_aes_pta_no2.readOnly=true;
		             formObj.exp_aes_pta_dt.value='';
		             formObj.exp_aes_pta_dt.readOnly=true;
		             formObj.exp_aes_ptu_no.value='';
		             formObj.exp_aes_ptu_no.readOnly=true;
		             formObj.exp_aes_ptu_dt.value='';
		             formObj.exp_aes_ptu_dt.readOnly=true;
		             exp_aes_expt_id.SetSelectCode("", true);
		             exp_aes_expt_id.SetEnable(0);
		             formObj.exp_aes_expt_ctnt.value='';
		             formObj.exp_aes_expt_ctnt.readOnly=true;
		             break;
		        case "EX":
		        	 exp_aes_expt_id.SetEnable(1);
		        	 //formObj.exp_aes_expt_id.focus();
		             formObj.exp_aes_expt_ctnt.readOnly=false;
		             formObj.exp_aes_inlnd_trns_no.value='';
		        	 formObj.exp_aes_inlnd_trns_no.readOnly=true;
		             formObj.exp_aes_pta_no1.value='';
		             formObj.exp_aes_pta_no1.readOnly=true;
		             formObj.exp_aes_pta_no2.value='';
		             formObj.exp_aes_pta_no2.readOnly=true;
		             formObj.exp_aes_pta_dt.value='';
		             formObj.exp_aes_pta_dt.readOnly=true;
		             formObj.exp_aes_ptu_no.value='';
		             formObj.exp_aes_ptu_no.readOnly=true;
		             formObj.exp_aes_ptu_dt.value='';
		             formObj.exp_aes_ptu_dt.readOnly=true;
		             formObj.exp_aes_dwn_no.value='';
		             formObj.exp_aes_dwn_no.readOnly=true;
		             formObj.exp_aes_dwn_dt.value='';
		             formObj.exp_aes_dwn_dt.readOnly=true;
		             break;
	    	}
    	}else if(obj.name=='imp_aes_tp_cd'&& obj.checked==true){
    		var obj2=formObj2.imp_aes_tp_cd;
		    for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		            obj2[i].checked=false;
		        }
		    }
    		switch(obj.value) {
    		case "AE":  
	        	 formObj2.imp_aes_inlnd_trns_no.focus();
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=false;
	             formObj2.imp_aes_pta_no1.value='';
	             formObj2.imp_aes_pta_no1.readOnly=true;
	             formObj2.imp_aes_pta_no2.value='';
	             formObj2.imp_aes_pta_no2.readOnly=true;
	             formObj2.imp_aes_pta_dt.value='';
	             formObj2.imp_aes_pta_dt.readOnly=true;
	             formObj2.imp_aes_ptu_no.value='';
	             formObj2.imp_aes_ptu_no.readOnly=true;
	             formObj2.imp_aes_ptu_dt.value='';
	             formObj2.imp_aes_ptu_dt.readOnly=true;
	             formObj2.imp_aes_dwn_no.value='';
	             formObj2.imp_aes_dwn_no.readOnly=true;
	             formObj2.imp_aes_dwn_dt.value='';
	             formObj2.imp_aes_dwn_dt.readOnly=true;
	             imp_aes_expt_id.SetSelectCode( -1, true);
	             imp_aes_expt_id.SetEnable(0);
	             formObj2.imp_aes_expt_ctnt.value='';
	             formObj2.imp_aes_expt_ctnt.readOnly=true;
	             break;
	        case "PA": 
	        	 formObj2.imp_aes_pta_no1.focus();
	             formObj2.imp_aes_pta_no1.readOnly=false;
	             formObj2.imp_aes_pta_no2.readOnly=false;
	             formObj2.imp_aes_pta_dt.readOnly=false;
	             formObj2.imp_aes_inlnd_trns_no.value='';
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=true;
	             formObj2.imp_aes_ptu_no.value='';
	             formObj2.imp_aes_ptu_no.readOnly=true;
	             formObj2.imp_aes_ptu_dt.value='';
	             formObj2.imp_aes_ptu_dt.readOnly=true;
	             formObj2.imp_aes_dwn_no.value='';
	             formObj2.imp_aes_dwn_no.readOnly=true;
	             formObj2.imp_aes_dwn_dt.value='';
	             formObj2.imp_aes_dwn_dt.readOnly=true;
	             imp_aes_expt_id.SetSelectCode( -1, true);
	             imp_aes_expt_id.SetEnable(0);
	             formObj2.imp_aes_expt_ctnt.value='';
	             formObj2.imp_aes_expt_ctnt.readOnly=true;
	             break;
	        case "PU":
	        	 formObj2.imp_aes_ptu_no.focus();
	             formObj2.imp_aes_ptu_no.readOnly=false;
	             formObj2.imp_aes_ptu_dt.readOnly=false;
	             formObj2.imp_aes_inlnd_trns_no.value='';
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=true;
	             formObj2.imp_aes_pta_no1.value='';
	             formObj2.imp_aes_pta_no1.readOnly=true;
	             formObj2.imp_aes_pta_no2.value='';
	             formObj2.imp_aes_pta_no2.readOnly=true;
	             formObj2.imp_aes_pta_dt.value='';
	             formObj2.imp_aes_pta_dt.readOnly=true;
	             formObj2.imp_aes_dwn_no.value='';
	             formObj2.imp_aes_dwn_no.readOnly=true;
	             formObj2.imp_aes_dwn_dt.value='';
	             formObj2.imp_aes_dwn_dt.readOnly=true;
	             imp_aes_expt_id.SetSelectCode( -1, true);
	             imp_aes_expt_id.SetEnable(0);
	             formObj2.imp_aes_expt_ctnt.value='';	
	             formObj2.imp_aes_expt_ctnt.readOnly=true;
	             break;
	        case "DN":
	        	 formObj2.imp_aes_dwn_no.focus();
	             formObj2.imp_aes_dwn_no.readOnly=false;
	             formObj2.imp_aes_dwn_dt.readOnly=false;
	             formObj2.imp_aes_inlnd_trns_no.value='';
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=true;
	             formObj2.imp_aes_pta_no1.value='';
	             formObj2.imp_aes_pta_no1.readOnly=true;
	             formObj2.imp_aes_pta_no2.value='';
	             formObj2.imp_aes_pta_no2.readOnly=true;
	             formObj2.imp_aes_pta_dt.value='';
	             formObj2.imp_aes_pta_dt.readOnly=true;
	             formObj2.imp_aes_ptu_no.value='';
	             formObj2.imp_aes_ptu_no.readOnly=true;
	             formObj2.imp_aes_ptu_dt.value='';
	             formObj2.imp_aes_ptu_dt.readOnly=true;
	             imp_aes_expt_id.SetSelectCode( -1, true);
	             imp_aes_expt_id.SetEnable(0);
	             formObj2.imp_aes_expt_ctnt.value='';
	             formObj2.imp_aes_expt_ctnt.readOnly=true;
	             break;
	        case "EX":
	        	 imp_aes_expt_id.SetEnable(1);
	             formObj2.imp_aes_expt_ctnt.readOnly=false;
	             formObj2.imp_aes_inlnd_trns_no.value='';
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=true;
	             formObj2.imp_aes_pta_no1.value='';
	             formObj2.imp_aes_pta_no1.readOnly=true;
	             formObj2.imp_aes_pta_no2.value='';
	             formObj2.imp_aes_pta_no2.readOnly=true;
	             formObj2.imp_aes_pta_dt.value='';
	             formObj2.imp_aes_pta_dt.readOnly=true;
	             formObj2.imp_aes_ptu_no.value='';
	             formObj2.imp_aes_ptu_no.readOnly=true;
	             formObj2.imp_aes_ptu_dt.value='';
	             formObj2.imp_aes_ptu_dt.readOnly=true;
	             formObj2.imp_aes_dwn_no.value='';
	             formObj2.imp_aes_dwn_no.readOnly=true;
	             formObj2.imp_aes_dwn_dt.value='';
	             formObj2.imp_aes_dwn_dt.readOnly=true;
	             break;
    		}
    	}
    	if(obj.name=='exp_aes_tp_cd'&& obj.checked==false){ 
    		var obj2=formObj.exp_aes_tp_cd;
    		var chkcnt=0
    		for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		        	if(obj2[i].checked == true){
		            	chkcnt++ ;
		            }
		        }
		    }
    		if(chkcnt==0){
    			 formObj.exp_aes_inlnd_trns_no.value='';
	        	 formObj.exp_aes_inlnd_trns_no.readOnly=true;
	             formObj.exp_aes_pta_no1.value='';
	             formObj.exp_aes_pta_no1.readOnly=true;
	             formObj.exp_aes_pta_no2.value='';
	             formObj.exp_aes_pta_no2.readOnly=true;
	             formObj.exp_aes_pta_dt.value='';
	             formObj.exp_aes_pta_dt.readOnly=true;
	             formObj.exp_aes_ptu_no.value='';
	             formObj.exp_aes_ptu_no.readOnly=true;
	             formObj.exp_aes_ptu_dt.value='';
	             formObj.exp_aes_ptu_dt.readOnly=true;
	             formObj.exp_aes_dwn_no.value='';
	             formObj.exp_aes_dwn_no.readOnly=true;
	             formObj.exp_aes_dwn_dt.value='';
	             formObj.exp_aes_dwn_dt.readOnly=true;
	             exp_aes_expt_id.SetSelectCode( -1, true);
	             exp_aes_expt_id.SetEnable(0);
	             formObj.exp_aes_expt_ctnt.value='';
	             formObj.exp_aes_expt_ctnt.readOnly=true;
    		}
    	}else if(obj.name=='imp_aes_tp_cd'&& obj.checked==false){ 
    		var obj2=formObj2.imp_aes_tp_cd; 
    		var chkcnt=0
    		for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){		            
		        	if(obj2[i].checked == true){
		            	chkcnt++ ;
		            }
		        }
		    }
    		if(chkcnt==0){
    			formObj2.imp_aes_inlnd_trns_no.value='';
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=true;
	             formObj2.imp_aes_pta_no1.value='';
	             formObj2.imp_aes_pta_no1.readOnly=true;
	             formObj2.imp_aes_pta_no2.value='';
	             formObj2.imp_aes_pta_no2.readOnly=true;
	             formObj2.imp_aes_pta_dt.value='';
	             formObj2.imp_aes_pta_dt.readOnly=true;
	             formObj2.imp_aes_ptu_no.value='';
	             formObj2.imp_aes_ptu_no.readOnly=true;
	             formObj2.imp_aes_ptu_dt.value='';
	             formObj2.imp_aes_ptu_dt.readOnly=true;
	             formObj2.imp_aes_dwn_no.value='';
	             formObj2.imp_aes_dwn_no.readOnly=true;
	             formObj2.imp_aes_dwn_dt.value='';
	             formObj2.imp_aes_dwn_dt.readOnly=true;
	             imp_aes_expt_id.SetSelectCode( -1, true);
	             imp_aes_expt_id.SetEnable(0);
	             formObj2.imp_aes_expt_ctnt.value='';
	             formObj2.imp_aes_expt_ctnt.readOnly=true;
    		}
    	}
    }
    function goCtnCd(obj){
    	var ctxName="/opus";
    	formObj=document.form;
    	formObj2=document.form2;
    	formObj3=document.form3;
    	
    	if(obj.name=='exp_cnt_cd'){
    		document.form4.tabclosechk.value="Y";
    		doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
    		if (saveMsgFlg) {
	    		if(document.form4.savechk.value==''){
		    		if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='KR'){
						sendForm("ESM_BKG_0361_02.do","O","KR");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='BR'){
						sendForm("ESM_BKG_0361_03.do","O","BR");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='IN'){
						sendForm("ESM_BKG_0361_04.do","O","IN");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='ID'){
						sendForm("ESM_BKG_0361_05.do","O","ID");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='CA'){
						sendForm("ESM_BKG_0361_06.do","O","CA");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='MX'){
						sendForm("ESM_BKG_0361_07.do","O","MX");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='CO'){
						sendForm("ESM_BKG_0361_07.do","O","CO");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='EC'){
						sendForm("ESM_BKG_0361_07.do","O","EC");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='PE'){
						sendForm("ESM_BKG_0361_07.do","O","PE");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='AR'){
						sendForm("ESM_BKG_0361_08.do","O","AR");
					}
	    		}else{
					formObj.exp_cnt_cd.value='US';
	   				document.form4.tabclosechk.value="";
	   				saveMsgFlg=true;
	    		}
			} else {
				formObj.exp_cnt_cd.value='US';
   				document.form4.tabclosechk.value="";
   				saveMsgFlg=true;
			}
    	}else if(obj.name=='imp_cnt_cd'){
    		document.form4.tabclosechk.value="Y";
    		doActionIBSheet(sheetObjects[1], formObj2, IBSAVE);
    		if (saveMsgFlg) {
	    		if(document.form4.savechk.value==''){
	    			if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='BR'){
						sendForm("ESM_BKG_0361_03.do","I","BR");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='IN'){
						sendForm("ESM_BKG_0361_04.do","I","IN");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='ID'){
						sendForm("ESM_BKG_0361_05.do","I","ID");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='MX'){
						sendForm("ESM_BKG_0361_07.do","I","MX");
					}
	    		}else{
					formObj2.imp_cnt_cd.value='US';
	   				document.form4.tabclosechk.value="";
	   				saveMsgFlg=true;
	    		}
			} else {
				formObj2.imp_cnt_cd.value='US';
   				document.form4.tabclosechk.value="";
   				saveMsgFlg=true;
			}
    	}
    }
    function makeSendForm(url) {
		var srcForm=document.form3;
   		var tgtForm=document.urlForm;
   		for (var i=0; i<tgtForm.elements.length; i++) {
   			tgtForm.elements[i].removeChild(true);
   		}
   		for (var i=0; i<srcForm.elements.length; i++) {
   			tgtForm.appendChild(srcForm.elements[i].cloneNode(true));
   		}
   		tgtForm.action=url;
    }
    function addFormElement(nm,vl) {
   		var tgtForm=document.urlForm;
   		var inp=document.createElement("input");
   		inp.type="hidden";
   		inp.name=nm;
   		inp.value=vl;
   		tgtForm.appendChild(inp);
    }
    function sendForm(url,io,nn) {
   		makeSendForm("/opuscntr/"+url);
   		addFormElement("io_bnd_cd",io);
   		if (nn) {
   			addFormElement("go_cnt_cd",nn);
   		}
   		//by kimtk. 2015.06.22. ESM_BKG_0361_07 국가명 출력(MEXICO, COLOMBIA, ECUADOR)
   		if (nn == "MX"){
   			addFormElement("go_cnt_nm","MEXICO");
   		}else if(nn == "CO"){
   			addFormElement("go_cnt_nm","COLOMBIA");
   		}else if(nn == "EC"){
   			addFormElement("go_cnt_nm","ECUADOR");
   		}else if(nn == "PE"){
   			addFormElement("go_cnt_nm","PERU");
   		}
    	document.urlForm.submit();
    }
    
    function copyToDesc(chkObj){
    	var formObj = document.form;
    	
    	if (!opener) opener=window.dialogArguments;
    	if(!opener) opener=parent;
    	
    	if(chkObj.checked==true){
    		if(!validateForm("",formObj)){
    			chkObj.checked=false;
    			return;
    		}
        	
    		var obj = formObj.exp_aes_tp_cd;
    		for(var i=0; i<obj.length; i++){
    			if(obj[i].checked){
    				switch(obj[i].value) {
    					case "AE":
    						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
																	"\n"+formObj.aes_inlnd_trns_pfx_ctnt.value+" "+formObj.exp_aes_inlnd_trns_no.value+"\n";
    						opener.document.form.dirty_flag.value="Y";
    					break;
    					case "PA":
    						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
																	"\n"+formObj.aes_pta_pfx_ctnt.value+" "+formObj.exp_aes_pta_no1.value+" "+formObj.exp_aes_pta_no2.value+"\n"+formObj.exp_aes_pta_dt.value+"\n";
    						opener.document.form.dirty_flag.value="Y";
    					break;
    					case "PU":
    						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
																	"\n"+formObj.aes_ptu_pfx_ctnt.value+" "+formObj.exp_aes_ptu_no.value+" "+formObj.exp_aes_ptu_dt.value+"\n";
    						opener.document.form.dirty_flag.value="Y";
    					break;
    					case "DN":
    						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
																	"\n"+formObj.aes_dwn_pfx_ctnt.value+" "+formObj.exp_aes_dwn_no.value+" "+formObj.exp_aes_dwn_dt.value+"\n";
    						opener.document.form.dirty_flag.value="Y";
    					break;
    					case "EX":
    						if(exp_aes_expt_id.GetSelectText() != ""){
        						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
                                "\n"+exp_aes_expt_id.GetSelectText()+"\n";
    						}else{
        						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
								"\n"+formObj.exp_aes_expt_ctnt.value+"\n ";
    						}
    						opener.document.form.modify_flag.value="Y";
    					break;
    				}
    			}
    		}
    	}
    }  
    
    function exp_aes_expt_id_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
    	if(comboObj.GetSelectCode()==""){
    		comboObj.SetEnable(0);
            formObj.exp_aes_expt_ctnt.value='';
            formObj.exp_aes_expt_ctnt.readOnly=false;
    	}else{
    		comboObj.SetEnable(1);
            formObj.exp_aes_expt_ctnt.value='';
            formObj.exp_aes_expt_ctnt.readOnly=true;
    	}
    }  
    
