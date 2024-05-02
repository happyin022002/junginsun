/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0361_05.js
*@FileTitle  :Export / Import Information (Indonesia)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
     * @author CLT
     */
// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=0; 
var sheetObjects=new Array();
var sheetCnt=0;
var saveMsgFlg=true;
var isInquiry=false;
// Event handler processing by button click event */
document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        /*******************************************************/
        var formObject=document.form;
        var formObject2=document.form2;
 		var sheetObject1=sheetObjects[0];
 		var sheetObject2=sheetObjects[1];
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
					case "btn_add":
		        		var row=sheetObject1.DataInsert(-1);
		        		sheetObject1.SetCellValue(row, "ibflag"     ,"I",0);
		        		sheetObject1.SetCellValue(row, "bkg_no"     ,formObject.elements["bkg_no"].value,0);
		        		sheetObject1.SetCellValue(row, "io_bnd_cd"  ,formObject.elements["io_bnd_cd"].value,0);
		        		sheetObject1.SetCellValue(row, "xpt_imp_seq",""==sheetObject1.GetCellValue(row, "xpt_imp_seq") ? ComGetMaxValue(sheetObject1, "xpt_imp_seq")+1 : sheetObject1.GetCellValue(row, "xpt_imp_seq"),0);
		        		sheetObject1.SetCellValue(row, "cnt_cd"     ,"ID",0);
                    break;
					case "btn_delete":
		            	ComRowDelete(sheetObject1, "sel", 1);
		            	sheetObject1.ReNumberSeq();
                    break;
					case "btn_save":
						document.form4.tabclosechk.value="";
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
                    break;
					case "btn_close":	
						document.form4.tabclosechk.value="Y";
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
						if (saveMsgFlg) {
							if(document.form4.savechk.value==""){
								ComClosePopup(); 
							}
						} else {
							ComClosePopup(); 
						} 
                    break;
                    ////////////////////////////////////////////////////////////////
					case "btn_add2":
						sheetObject2.DataInsert(-1);
						sheetObject2.SetCellValue(row, "ibflag","I",0);
						sheetObject2.SetCellValue(row, "bkg_no"     ,formObject2.elements["bkg_no"].value,0);
						sheetObject2.SetCellValue(row, "io_bnd_cd"  ,formObject2.elements["io_bnd_cd"].value,0);
						sheetObject2.SetCellValue(row, "xpt_imp_seq",""==sheetObject2.GetCellValue(row, "xpt_imp_seq") ? ComGetMaxValue(sheetObject2, "xpt_imp_seq")+1 : sheetObject2.GetCellValue(row, "xpt_imp_seq"),0);
						sheetObject2.SetCellValue(row, "cnt_cd"     ,"ID",0);
                    break;
					case "btn_delete2":
		            	ComRowDelete(sheetObject2, "sel", 1);
		            	sheetObject2.ReNumberSeq();
                    break;
					case "btn_save2":
						document.form4.tabclosechk.value="";
						doActionIBSheet(sheetObject2, formObject2, IBSAVE);
                    break;
					case "btn_close2":
						document.form4.tabclosechk.value="Y";
						doActionIBSheet(sheetObject2, formObject2, IBSAVE);
						if (saveMsgFlg) {
							if(document.form4.savechk.value==""){
								ComClosePopup(); 
							}
						} else {
							ComClosePopup(); 
						} 
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
   		if (!opener) opener=window.dialogArguments;
   		if(!opener) opener=parent;
   		isInquiry=opener.document.form.isInquiry && "Y"==ComGetObjValue(opener.document.form.isInquiry);
   		if(document.form.popUpTpCd.value=="E"||document.form.popUpTpCd.value=="S" || isInquiry){
    		ComBtnDisable("btn_add");
    		ComBtnDisable("btn_save");
    		ComBtnDisable("btn_delete");
    		ComBtnDisable("btn_add2");
    		ComBtnDisable("btn_save2");
    		ComBtnDisable("btn_delete2");
     	}
    	if(document.form.popUpTpCd.value!="S"){ 
	    	if(document.form3.bkg_no.value == ""){ 
	    		ComShowCodeMessage("COM12114","Booking Number");   
	    		ComClosePopup(); 
	        	return;
	        }
    	}
    	for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
        initControl();
        if(document.form3.get_io_bnd_cd.value != 'I') {
        	beforetab=0; 
        	tab1.SetSelectedIndex(0);
        	var ctxName="/opus";
        	if (document.form4.savechk.value=="") {
	        	if (document.form3.bkg_no.value != ""&& document.form.go_cnt_cd.value=="") {
					if (document.form3.pol_cd.value.substring(0,2)=='KR') {
						sendForm("ESM_BKG_0361_02.do","O" , "KR");
					}else if (document.form3.pol_cd.value.substring(0,2) =='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
					} else if (document.form3.pol_cd.value.substring(0,2)=='BR') {
						sendForm("ESM_BKG_0361_03.do","O" , "BR");
					} else if (document.form3.pol_cd.value.substring(0,2)=='IN') {
						sendForm("ESM_BKG_0361_04.do","O" , "IN");
					} else if (document.form3.pol_cd.value.substring(0,2)=='CA') {
						sendForm("ESM_BKG_0361_06.do","O" , "CA");
					} else if (document.form3.pol_cd.value.substring(0,2)=='MX') {
						sendForm("ESM_BKG_0361_07.do","O" ,"MX");
					}else if (document.form3.pol_cd.value.substring(0,2)=='CO'){
						sendForm("ESM_BKG_0361_07.do","O","CO");
					}else if (document.form3.pol_cd.value.substring(0,2)=='EC'){
						sendForm("ESM_BKG_0361_07.do","O","EC");
					}else if (document.form3.pol_cd.value.substring(0,2)=='PE'){
						sendForm("ESM_BKG_0361_07.do","O","PE");
					}else {
   						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
   					}
				} else{
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
        	if (document.form4.savechk.value=="") {
	        	if (document.form3.bkg_no.value != ""&& document.form.go_cnt_cd.value=="") {
	        		if (document.form3.pod_cd.value.substring(0,2)=='KR') {
						sendForm("ESM_BKG_0361_02.do","I" , "KR");
					}else if (document.form3.pod_cd.value.substring(0,2) =='US'){
						sendForm("ESM_BKG_0361_01.do","I","US");
					} else if (document.form3.pod_cd.value.substring(0,2)=='BR') {
						sendForm("ESM_BKG_0361_03.do","I" , "BR");
					} else if (document.form3.pod_cd.value.substring(0,2)=='IN') {
						sendForm("ESM_BKG_0361_04.do","I" , "IN");
					} else if (document.form3.pod_cd.value.substring(0,2)=='CA') {
						sendForm("ESM_BKG_0361_06.do","I" , "CA");
					} else if (document.form3.pod_cd.value.substring(0,2)=='MX') {
						sendForm("ESM_BKG_0361_07.do","I" ,"MX");
					}else{
	   					doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH) ;
	   				}
				} else{
					doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH) ;
				}
        	}
        }
	}
    /**
     * IBTab Object regist array
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * initializing Tab
     * Setting Tab items.
     */
    function initTab(tabObj , tabNo) {
        with (tabObj) {
            var cnt=0;
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
     * Event when clicking Tab
     * activating selected tab items.
     */
    function tab1_OnChange(tabObj , nItem) {
    	if (nItem==beforetab) return; 	
    	var objs=document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	objs[beforetab].style.display="none";
     	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1;
     	beforetab=nItem;
     	var ctxName="/opus";
   		var formObj=document.form3;
   		switch(nItem) {
   			case 0:	
   				document.form4.tabclosechk.value="Y";
   				doActionIBSheet(sheetObjects[1], document.form2, IBSAVE);
   				if (saveMsgFlg) {
	   				document.form.go_cnt_cd.value="";
	   				if(document.form4.savechk.value==""){
		   				if(formObj.bkg_no.value != ""&& document.form.go_cnt_cd.value==""){
		   					if (formObj.pol_cd.value.substring(0,2)=='KR'){
								sendForm("ESM_BKG_0361_02.do","O","KR");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","O","BR");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='IN'){
								sendForm("ESM_BKG_0361_04.do","O","IN");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='US'){
		   						sendForm("ESM_BKG_0361_01.do","O","US");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='CA'){
								sendForm("ESM_BKG_0361_06.do","O","CA");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='MX'){
								sendForm("ESM_BKG_0361_07.do","O","MX");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='CO'){
								sendForm("ESM_BKG_0361_07.do","O","CO");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='EC'){
								sendForm("ESM_BKG_0361_07.do","O","EC");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='PE'){
								sendForm("ESM_BKG_0361_07.do","O","PE");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='AR'){
								sendForm("ESM_BKG_0361_07.do","O","MX");
		   					}else {
		   						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		   					}
		   				}else{
		   					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
	   				document.form.go_cnt_cd.value="";
	   				if(document.form4.savechk.value==""){
	   					if(formObj.bkg_no.value != ""&& document.form.go_cnt_cd.value==""){
		   					if (formObj.pod_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","I","BR");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='IN'){
								sendForm("ESM_BKG_0361_04.do","I","IN");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='MX'){
								sendForm("ESM_BKG_0361_07.do","I","MX");
		   					}else {
		   						doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH);
		   					}
		   				}else{
		   					doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH);
		   				}
	   				}
				} else {
					document.form4.tabclosechk.value="";
					saveMsgFlg=true;
				} 
               break;   
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
 	 * setting sheet initial values and header
 	 * param : sheetObj, sheetNo
 	 * adding case as numbers of counting sheets
 	 */
 	function initSheet(sheetObj,sheetNo) {
 		var cnt=0;
		with (sheetObj) {
		    switch(sheetNo) {
		    	case 1:  //sheet1
		    
				    var HeadTitle="|Sel.|Seq.|PEB No.|PEB Issue Date|Customs Office|Qualifier||||";
				    var headCount=ComCountHeadTitle(HeadTitle);
		
				    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
				    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				    var headers = [ { Text:HeadTitle, Align:"Center"} ];
				    InitHeaders(headers, info);
		
				    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
				              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
				              {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"id_xpt_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				              {Type:"PopupEdit", Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"id_xpt_no_iss_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
				              {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"id_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"id_decl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"bkg_no" },
				              {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"io_bnd_cd" },
				              {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"xpt_imp_seq" },
				              {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cnt_cd" } ];
				     
				    InitColumns(cols);
		
				    SetEditable(1);
				    SetColProperty("id_ofc_cd", {ComboText:"|MESBA|JKTBA|SRGBA|SUBBA", ComboCode:"|010700|040300|060100|070100"} );
				    SetColProperty("id_decl_cd", {ComboText:"|PEB|PKB", ComboCode:"|E|K"} );
				    SetColProperty("id_xpt_no", {AcceptKeys:"N"} );
				    SetShowButtonImage(2);
				    SetSheetHeight(150);
				break;
	 			case 2:  //sheet2
	 				   var HeadTitle="|Chk.|Seq.|PEB No.|PEB Issue Date|Customs Office|Qualifier||||";
	 				   var headCount=ComCountHeadTitle(HeadTitle);

	 				   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	 				   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	 				   var headers = [ { Text:HeadTitle, Align:"Center"} ];
	 				   InitHeaders(headers, info);

	 				   var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
	 				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
	 				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	 				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"id_xpt_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	 				             {Type:"PopupEdit", Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"id_xpt_no_iss_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	 				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"id_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"id_decl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"bkg_no" },
	 				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"io_bnd_cd" },
	 				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"xpt_imp_seq" },
	 				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cnt_cd" } ];
	 				    
	 				   InitColumns(cols);

	 				   SetEditable(1);
	 				   SetColProperty("id_ofc_cd", {ComboText:"|BANBA|JKTBA|SRGBA|SUBBA", ComboCode:"|010700|040300|060100|070100"} );
	 				   SetColProperty("id_decl_cd", {ComboText:"|PEB|PKB", ComboCode:"|E|K"} );
	 				   SetColProperty("id_xpt_no", {AcceptKeys:"N"} );
	 				      //conversion of function[check again]CLT 					InitDataValid(0, cnt++, vtNumericOnly);
	 				   SetShowButtonImage(2);
		 			   SetSheetHeight(150);
	 				break;
 			}
 		}
 	}
 	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
 		sheetObj.SetWaitImageVisible(0);
 		//sheetObj.ShowDebugMsg = false;
 		switch(sAction) {
 			case IBSEARCH:  //Retrieve
 		 		ComOpenWait(true);
				if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("ESM_BKG_0361_05GS.do", FormQueryString(formObj) );
				}
		 		ComOpenWait(false);
			break;
 			case IBSAVE:  //save
 				if(validateForm(sheetObj,formObj,sAction)) {
 					document.form4.savechk.value="";
 		 			if (0<sheetObj.RowCount()) {
 						for (var row=1; row<=sheetObj.RowCount(); row++) {
		 					sheetObj.SetCellValue(row, "bkg_no"     ,formObj.elements["bkg_no"].value,0);
		 					sheetObj.SetCellValue(row, "io_bnd_cd"  ,formObj.elements["io_bnd_cd"].value,0);//O
		 					sheetObj.SetCellValue(row, "xpt_imp_seq",""==sheetObj.GetCellValue(row, "xpt_imp_seq") ? ComGetMaxValue(sheetObj, "xpt_imp_seq")+1 : sheetObj.GetCellValue(row, "xpt_imp_seq"),0);
		 					sheetObj.SetCellValue(row, "cnt_cd"     ,"ID",0);
		 					sheetObj.SetCellValue(row, "id_ofc_cd"  ,ComTrim(sheetObj.GetCellValue(row, "id_ofc_cd")),0);
		 					sheetObj.SetCellValue(row, "id_decl_cd" ,ComTrim(sheetObj.GetCellValue(row, "id_decl_cd")),0);
		 					if ("I"==sheetObj.GetCellValue(row, "ibflag") &&
		 							""==sheetObj.GetCellValue(row, "id_xpt_no") &&
		 							""==sheetObj.GetCellValue(row, "id_xpt_no_iss_dt") &&
		 							""==sheetObj.GetCellValue(row, "id_ofc_cd") &&
		 							""==sheetObj.GetCellValue(row, "id_decl_cd")) {
		 						//sheetObj.SetCellValue(row, "ibflag"     ,"D",0);
		 						sheetObj.RowDelete(row, 0);
		 					}
 						}
 					}
 					formObj.f_cmd.value=MULTI;
 					var SaveStr = sheetObj.GetSaveString();
 					if(document.form4.tabclosechk.value=="Y"){
	 					if (!sheetObj.IsDataModified() && SaveStr == "") return;
						if(confirm(ComGetMsg("BKG00962"))){
					 		ComOpenWait(true);
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_05GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
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
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_05GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
							sheetObj.LoadSaveData(rtnData); 	
					 		ComOpenWait(false);
						} 
 					}
 				}
 			break;
 		}
 	}
 	function setTab(idx) {
    	beforetab=idx;
     	tab1.SetSelectedIndex(idx);
		objs=document.all.item("tabLayer");
		objs[0].style.display=0==idx ? "inline" : "none";
		objs[1].style.display=0==idx ? "none" : "inline"; 
		document.form4.savechk.value="N";
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
		if (sAction==IBSAVE) {
			if (formObj.name=="form" || formObj.name=="form2") {
	 			var dataSheet=sheetObjects[formObj.name=="form" ? 0 : 1];
		 		var pebNo;
		 		var pebDt;
		 		if (dataSheet.IsDataModified()) {
					for (var row=1; row<=dataSheet.RowCount(); row++) {
						if ("D"!=dataSheet.GetCellValue(row, "ibflag")) {
			 				if (formObj.name=="form") {
			 					pebNo=dataSheet.GetCellValue(row, "id_xpt_no");
			 					pebDt=dataSheet.GetCellValue(row, "id_xpt_no_iss_dt");
			 				} else {
			 					pebNo=dataSheet.GetCellValue(row, "id_xpt_no");
			 					pebDt=dataSheet.GetCellValue(row, "id_xpt_no_iss_dt");
			 				}
			 				if (""!=pebNo && 6 > pebNo.length) {
			 					setTab(formObj.name=="form" ? 0 : 1);
			    				ComShowMessage(ComGetMsg("COM12174","6"));  //{?msg1} must be at least {?msg2} characters long.
			    				dataSheet.SelectCell(row, 3);
				             	return false;
			 				}
			 				if (""!=pebDt && !ComIsDate(pebDt)) {
					 			setTab(formObj.name=="form" ? 0 : 1);
			    				ComShowMessage(ComGetMsg("COM12132"));  //Please enter a valid date format: YYYY-MM-DD
			    				dataSheet.SelectCell(row, 4);
				             	return false;
			 				}
						}
		 			}
				} else {
					return true;
				}
			}
		} 
		document.form4.savechk.value="";
		return true;
    }
    function setOptionValue(comboObj, val) {
    	for(i=0;i<comboObj.length;i++) {
    		if(val == comboObj.options[i].value)  comboObj.options[i].selected=true;
    	}
    }
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	document.form3.get_io_bnd_cd.value="O";
    }
    function sheet2_OnSearchEnd(sheetObj,ErrMsg){
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
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	if ("id_xpt_no_iss_dt"==sheetObj.ColSaveName(Col)) {
    		new ComCalendarGrid().select(sheetObj, Row, Col, 'yyyy-MM-dd');
    	}
    }
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
    	if ("id_xpt_no_iss_dt"==sheetObj.ColSaveName(Col)) {
    		new ComCalendarGrid().select(sheetObj, Row, Col, 'yyyy-MM-dd');
    	}
    }
    function initControl() {    	
//    	document.getElementById("exp_cnt_cd").
//    	ocument.getElementById("exp_cnt_cd").options[0].selected = 'selected';
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
	    		if(document.form4.savechk.value==""){
		    		if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='KR'){
						sendForm("ESM_BKG_0361_02.do","O","KR");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='IN'){
						sendForm("ESM_BKG_0361_04.do","O","IN");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='BR'){
						sendForm("ESM_BKG_0361_03.do","O","BR");
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
					formObj.exp_cnt_cd.value="ID";
	   				document.form4.tabclosechk.value="";
	   				saveMsgFlg=true;
	    		}
			} else {
				formObj.exp_cnt_cd.value="ID";
   				document.form4.tabclosechk.value="";
   				saveMsgFlg=true;
			}
    	}else if(obj.name=='imp_cnt_cd'){
    		document.form4.tabclosechk.value="Y";
    		doActionIBSheet(sheetObjects[1], formObj2, IBSAVE);
    		if (saveMsgFlg) {
	    		if(document.form4.savechk.value==""){
		    		if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='IN'){
						sendForm("ESM_BKG_0361_04.do","I","IN");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='BR'){
						sendForm("ESM_BKG_0361_03.do","I","BR");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='MX'){
						sendForm("ESM_BKG_0361_07.do","I","MX");
					}
	    		}else{
					formObj2.imp_cnt_cd.value="ID";
	   				document.form4.tabclosechk.value="";
	   				saveMsgFlg=true;
	    		}
			} else {
				formObj2.imp_cnt_cd.value="ID";
   				document.form4.tabclosechk.value="";
   				saveMsgFlg=true;
			}
    	}
    }
    function makeSendForm(url) {
		var srcForm=document.form3;
   		var tgtForm=document.urlForm;
   		for (var i=0; i<tgtForm.elements.length; i++) {
   			tgtForm.elements[i].removeNode(true);
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
