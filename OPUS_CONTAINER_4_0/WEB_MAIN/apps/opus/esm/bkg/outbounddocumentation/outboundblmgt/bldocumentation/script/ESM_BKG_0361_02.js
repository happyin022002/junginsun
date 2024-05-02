/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0361_02.js
*@FileTitle  : Export / Import Information (Korea)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var tabObjects=new Array();
var tabCnt=0 ;
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
					case "btn_save":
						document.form4.tabclosechk.value="";
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
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
					case "btn_rowAdd":
						doActionIBSheet(sheetObject1, formObject, IBINSERT);
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
							document.form4.tabclosechk.value="";
							saveMsgFlg=true;
						}
                    break;
					case "btn_rowAdd2":
						doActionIBSheet(sheetObject2, formObject2, IBINSERT);
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
    		ComBtnDisable("btn_rowAdd");
    		ComBtnDisable("btn_rowAdd2");
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
        if(document.form3.get_io_bnd_cd.value != 'I'){
        	beforetab=0;
        	tab1.SetSelectedIndex(0);
        	document.form.exp_cnt_cd.selectedIndex=3;
        	var ctxName="/opus";
        	if(document.form4.savechk.value==''){
	        	if(document.form3.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
					if (document.form3.pol_cd.value.substring(0,2)=='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
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
						sendForm("ESM_BKG_0361_08.do","O","AR");
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
					}else if (document.form3.pod_cd.value.substring(0,2)=='ID'){
						sendForm("ESM_BKG_0361_05.do","I","ID");
					}else if (document.form3.pod_cd.value.substring(0,2)=='MX'){
						sendForm("ESM_BKG_0361_07.do","I","MX");
					}else {
						doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH) ;
					}
				}else{
					doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH) ;
				}
        	}
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
     * setting Tab 
     * setting item of Tab
     */
    function initTab(tabObj , tabNo) {
        with (tabObj) {
            var cnt=0 ;
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
     * activating selected tab items
     */
    function tab1_OnChange(tabObj , nItem) {
    	if (nItem==beforetab) return;     	
    	var objs=document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	objs[beforetab].style.display="none";
     	//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
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
		   					if (formObj.pol_cd.value.substring(0,2)=='US'){
		   						sendForm("ESM_BKG_0361_01.do","O","US");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","O","BR");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='IN'){
								sendForm("ESM_BKG_0361_04.do","O","IN");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='ID'){
								sendForm("ESM_BKG_0361_05.do","O","ID");
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
								sendForm("ESM_BKG_0361_08.do","O","AR");
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
								sendForm("ESM_BKG_0361_03.do","I","BR");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='IN'){
								sendForm("ESM_BKG_0361_04.do","I","IN");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='ID'){
								sendForm("ESM_BKG_0361_05.do","I","ID");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='MX'){
								sendForm("ESM_BKG_0361_07.do","I","MX");
		   					}else {
		   						sendForm("ESM_BKG_0361_03.do","I","BR");
		   					}
		   				}else{
		   					sendForm("ESM_BKG_0361_03.do","I","BR");
		   				}
	   				}
   				} else {
   					if (formObj.pod_cd.value.substring(0,2)=='BR'){
						sendForm("ESM_BKG_0361_03.do","I","BR");
   					}else if (formObj.pod_cd.value.substring(0,2)=='IN'){
						sendForm("ESM_BKG_0361_04.do","I","IN");
   					}else if (formObj.pod_cd.value.substring(0,2)=='ID'){
						sendForm("ESM_BKG_0361_05.do","I","ID");
   					}else if (formObj.pod_cd.value.substring(0,2)=='MX'){
						sendForm("ESM_BKG_0361_07.do","I","MX");
   					}else {
   						sendForm("ESM_BKG_0361_03.do","I","BR");
   					}
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
 		switch(sheetNo) {
 			case 1:      //sheet1 init
 			    with(sheetObj){
 				      var HeadTitle="|||||||Export License Numberd|Other Reference No.|Package|Package|Weight|Weight|DIV|SMP|SMP Package|SMP Package|UCR No.|UPD User|UPD Date(GMT)";

 				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

 				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
 				      InitHeaders(headers, info);

 				      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
 				             {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
 				             {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"Check",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:1 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:145,  Align:"Left",    ColMerge:0,   SaveName:"xpt_lic_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
 				             {Type:"Text",      Hidden:0,  Width:145,  Align:"Left",    ColMerge:0,   SaveName:"ts_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
 				             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",        KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"PopupEdit", Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"mf_wgt",         KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Combo",     Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"divd_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sam_pck_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"sam_pck_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"PopupEdit", Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"sam_pck_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"ucr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ,
 				            {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				           {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
 				       
 				      InitColumns(cols);

 				      SetEditable(1);
 				      SetColProperty("xpt_lic_no", {Format:"###-##-##-#######-#"} );
						SetColProperty(0, "wgt_ut_cd", {ComboText:"|KGS|LGB", ComboCode:"|KGS|LGB"} );
						SetColProperty(0, "divd_seq", {ComboText:"|1|2|3|4", ComboCode:"|1|2|3|4"} );
						SetColProperty(0, "sam_pck_id", {ComboText:"|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z", ComboCode:"|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z"} );
						SetSheetHeight(200);
						SetShowButtonImage(2);
 				}
 			break;
 			case 2:      //sheet1 init
 			    with(sheetObj){
 				      var HeadTitle="|||||||Export License Number|Other Reference No.|Package|Package|Weight|Weight|DIV|SMP|SMP Package|SMP Package|UCR No.";

 				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

 				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
 				      InitHeaders(headers, info);

 				      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
 				             {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
 				             {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"Check",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:1 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:145,  Align:"Left",    ColMerge:0,   SaveName:"xpt_lic_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
 				             {Type:"Text",      Hidden:0,  Width:145,  Align:"Left",    ColMerge:0,   SaveName:"ts_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
 				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",        KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"PopupEdit", Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"mf_wgt",         KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Combo",     Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"divd_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sam_pck_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"sam_pck_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"PopupEdit", Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"sam_pck_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"ucr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
 				       
 				      InitColumns(cols);

 				      SetEditable(1);
 				      SetColProperty("xpt_lic_no", {Format:"###-##-##-#######-#"} );
 				      SetColProperty(0, "wgt_ut_cd", {ComboText:"|KGS|LGB", ComboCode:"|KGS|LGB"} );
 	 				  SetColProperty(0, "divd_seq", {ComboText:"|1|2|3|4", ComboCode:"|1|2|3|4"} );
 	 				  SetColProperty(0, "sam_pck_id", {ComboText:"|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z", ComboCode:"|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z"} );
 	 				  SetSheetHeight(200);
 				      SetShowButtonImage(2);
 				}


 			break;
 		}
 	}
  // handling of Sheet 
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		sheetObj.SetWaitImageVisible(0);
 		//sheetObj.ShowDebugMsg = true;
 		switch(sAction) {
 			case IBSEARCH:      
 		 		ComOpenWait(true);
 				if(validateForm(sheetObj, formObj, sAction)) {
 					formObj.f_cmd.value=SEARCH;
  					test = sheetObj.DoSearch("ESM_BKG_0361_02GS.do", FormQueryString(formObj) );
 				}
 		 		ComOpenWait(false);
 			break;
 			case IBINSERT:      			
 				var newRow=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(newRow, "bkg_no",formObj.bkg_no.value);
				sheetObj.SetCellValue(newRow, "io_bnd_cd",formObj.io_bnd_cd.value);
				sheetObj.SetCellValue(newRow, "cnt_cd","KR");
				sheetObj.SetCellValue(newRow, "wgt_ut_cd","KGS");
				if( sheetObj.id=="sheet1"){
		    		sheetObj.SetCellValue(sheetObj.LastRow(), 1,"",0);
		    		sheetObj.SetCellValue(sheetObj.LastRow(), "ts_ref_no","TOTAL",0);
		    		sheetObj.SetCellAlign(sheetObj.LastRow(), "ts_ref_no","Center");
				}
			break;
 			case IBSAVE:       			
 				if(validateForm(sheetObj,formObj,sAction)) {
 					document.form4.savechk.value="";
 					formObj.f_cmd.value=MULTI;
 					var SaveStr = sheetObj.GetSaveString();
 					if(document.form4.tabclosechk.value=="Y"){
	 					if (!sheetObj.IsDataModified() && SaveStr == "") return;
						if(confirm(ComGetMsg("BKG00962"))){
					 		ComOpenWait(true);
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_02GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
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
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_02GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
							sheetObj.LoadSaveData(rtnData); 	
					 		ComOpenWait(false);
						} 
 					}
 				}
 			break;
 			case IBDELETE:     
	 			var rCnt=sheetObj.RowCount()+1;
 			    var chkCnt=0
				for(i=1;i<rCnt;i++){
					if(sheetObj.GetCellValue(i, "Check") == 1){
						chkCnt++	
					}
				}
 			    
 			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
 			   if(sheetObj.id=="sheet1"){
		 			var rCnt=sheetObj.RowCount()+1;
					for(i=1;i<rCnt;i++){
						if(sheetObj.GetCellValue(i, "Check") == 1){
							sheetObj.SetCellValue(i, "pck_qty",0,0);
							sheetObj.SetCellValue(i, "mf_wgt",0,0);
						}
					}
 			   }
				ComRowHideDelete(sheetObj, "Check");
 			break;	
 		}
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
    	 if (!ComChkValid(formObj)){
    		 saveMsgFlg=false;
    		 return false;
    	 }

        var Value="";
        var Value2="";
		var pkg="";
		var wgt="";
		var sumQty="";
		var pkgQty="";
		var wgtQty="";
		var sumQty2="";
	    if (sAction=='2'){
	    	pkgQty=document.form3.pkg_qty.value.replace(",","");
			wgtQty=document.form3.wgt_qty.value.replace(",","");
			sumQty2=parseFloat(pkgQty)+parseFloat(wgtQty);
			sumQty=0;
			pkg=0;
			wgt=0.000;
	    	for(var j=1;j<sheetObj.RowCount()+1;j++){
				ibflag=sheetObj.GetCellValue(j,"ibflag");
				Value=sheetObj.GetCellValue(j,"xpt_lic_no");
				Value2=sheetObj.GetCellValue(j,"ts_ref_no");
				var T=Number('1e'+1);
				if(ibflag!='D'){
					pkg += parseInt(sheetObj.GetCellValue(j,"pck_qty"));
					wgt += parseFloat(sheetObj.GetCellValue(j,"mf_wgt"));
				}
				sumQty=Math.round((pkg+wgt)* T) / T;;
				objs=document.all.item("tabLayer");
				if(ibflag=='I'||ibflag=='U'){
					if(Value==''&&Value2==''){
					    if(formObj.name=="form"){
					    	setTab1();
					    }else{
					    	setTab2();
					    }
		             	ComShowCodeMessage("COM12138","Export License Number","Other Reference No.");
						sheetObj.SelectCell(j, "xpt_lic_no");
						saveMsgFlg=false;
						return;
					}					
					if(Value.length > 0 &&Value.length < 14){
						if(formObj.name=="form"){
							setTab1();
					    }else{
					    	setTab2();
					    }
		             	document.form4.savechk.value="N";
						ComShowCodeMessage("BKG00257");
						sheetObj.SelectCell(j, "xpt_lic_no");
						saveMsgFlg=false;
						return;
					}else if(Value.length > 14){
						var total=0;
						for(var i=1; i < 15; i++){
							switch (i%3){
								case 1:
									total+=parseInt(((Value.substring(i-1,i)*7)%10));
								break;	
								case 2:
									total+=parseInt(((Value.substring(i-1,i)*3)%10));
			 				break;
								case 0:
									total+=parseInt((Value.substring(i-1,i)*1));
			 				break;
							}
						}     	
						chkDigit=((10-(total%10))%10);
						if(Value.length == 15){
				 			if(Value.substring(14,15)!=chkDigit){
				 				if(formObj.name=="form"){
				 					setTab1();
							    }else{
							    	setTab2();
							    }
				             	document.form4.savechk.value="N";
				             	ComShowCodeMessage("BKG00200",chkDigit,Value.substring(14,15));
				 				sheetObj.SetCellValue(j, "xpt_lic_no",Value.substring(0,14));
				 				saveMsgFlg=false;
				 				return;
				 			}
				 		}else{
				 			sheetObj.SetCellValue(j, "xpt_lic_no",Value+chkDigit,0);
				 		}	    			
					}					
				}
	    	}
	    	if(parseFloat(sumQty)!=parseFloat(sumQty2)&&sheetObj.IsDataModified()==true){
	    		var mText=new Array(pkgQty,wgtQty,pkg,wgt.toFixed(3));
			    if (!ComShowCodeConfirm2("BKG00199", mText)){
			    	saveMsgFlg=false;
			    	return;
			    }
	    	}
	    	if(sheetObj.RowCount()>= 2 ){
	    		var arr;
	    		for(var j=1;j<sheetObj.RowCount()+1;j++){
	    			arr=ComFindText(sheetObj,"xpt_lic_no",sheetObj.GetCellValue(j,"xpt_lic_no"));
	    			if (arr && 1<arr.length && sheetObj.GetCellValue(j,"xpt_lic_no") != "") {
	    				ComShowCodeMessage("BKG03056","Export License No");
	    				saveMsgFlg=false;
	    				return;
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
 //  initializing sheet data
    function initSheetData(sheetObj) {
    	sheetObj.RemoveAll();
    	sheetObj.DataInsert(-1);
    }
    function sheet1_OnSaveEnd(sheetObj,code ,ErrMsg){
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
    function sheet2_OnSaveEnd(sheetObj, code ,ErrMsg){
    	//saveMsgFlg=ComIsNull(ErrMsg);
    	if(code == 0)  saveMsgFlg = true;
    	else saveMsgFlg = false;
		if (saveMsgFlg) {
			ComShowCodeMessage("BKG00166");  //Data Saved Successfully!!
		} else {
			ComShowCodeMessage("BKG00167");  //Data Save Action Failed!!
		}
    	if(document.form4.tabclosechk.value==""){
    		doActionIBSheet(sheetObj, document.form2, IBSEARCH);
    	}
    }
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	formObj=document.form;
    	if (sheetObj.RowCount()>0){
    	}else{    		
    	}
    	document.form3.get_io_bnd_cd.value="O";
    	if (sheetObj.RowCount()> 0) {
    		sheetObj.SetCellValue(sheetObj.LastRow(), 1,"",0);
    		sheetObj.SetCellValue(sheetObj.LastRow(), "ts_ref_no","TOTAL",0);
    		sheetObj.SetCellAlign(sheetObj.LastRow(), "ts_ref_no","Center");
    	}
    }
    function sheet2_OnSearchEnd(sheetObj,ErrMsg){
    	formObj=document.form2;
    	if (sheetObj.RowCount()>0){
    	}else{           
    	}
    	document.form3.get_io_bnd_cd.value="I";
    }
    function initControl() {    	
    }
    function sheet1_OnPopupClick(sheetObj,Row,Col){
    	comBkgCallPop0696("setCallBack0696",sheetObj.GetCellValue(Row, Col));
    }
    function sheet2_OnPopupClick(sheetObj,Row,Col){
    	comBkgCallPop0696("setCallBack06962",sheetObj.GetCellValue(Row, Col));
    }
    function setCallBack0696(aryPopupData) {
    	var sheetObj=sheetObjects[0];
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),aryPopupData.cd);
    }
    function setCallBack06962(aryPopupData) {
    	var sheetObj=sheetObjects[1];
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),aryPopupData.cd);
    }
    function sheet1_OnChange(sheetObj,Row, Col, Value){    	
    	if(Col=='7'){
    		if(Value!=''&&Value.length < 14){
    			ComShowCodeMessage("BKG00257");
    			sheetObj.SelectCell(Row, Col);
    		}else{
    			var total=0;
    			for(var i=1; i < 15; i++){
    				switch (i%3){
    					case 1:
    						total+=parseInt(((Value.substring(i-1,i)*7)%10));
    					break;	
    					case 2:
    						total+=parseInt(((Value.substring(i-1,i)*3)%10));
        				break;
    					case 0:
    						total+=parseInt((Value.substring(i-1,i)*1));
        				break;
    				}
    			}     	
    			chkDigit=((10-(total%10))%10);
    			if(Value.length == 15){
        			if(Value.substring(14,15)!=chkDigit){
        				ComShowCodeMessage("BKG00200",chkDigit,Value.substring(14,15));
        				sheetObj.SetCellValue(Row, Col,Value.substring(0,14));
        				sheetObj.SelectCell(Row, Col);
        			}
        		}else if(Value.length == 14){
        			sheetObj.SetCellValue(Row, Col,Value+chkDigit,0);
        		}
    		}
    	}
    	if(Col=='8'||Col=='10'||Col=='16'){
    		sheetObj.SetCellValue(Row, Col,Value.toUpperCase(),0);
    	}
    }
    function sheet2_OnChange(sheetObj,Row, Col, Value){    	
    	if(Col=='7'){
    		if(Value!=''&&Value.length < 14){
    			ComShowCodeMessage("BKG00257");
    			sheetObj.SelectCell(Row, Col);
    		}else{
    			var total=0;
    			for(var i=1; i < 15; i++){
    				switch (i%3){
    					case 1:
    						total+=parseInt(((Value.substring(i-1,i)*7)%10));
    					break;	
    					case 2:
    						total+=parseInt(((Value.substring(i-1,i)*3)%10));
        				break;
    					case 0:
    						total+=parseInt((Value.substring(i-1,i)*1));
        				break;
    				}
    			}     	
    			chkDigit=((10-(total%10))%10);
    			if(Value.length == 15){
        			if(Value.substring(14,15)!=chkDigit){
        				ComShowCodeMessage("BKG00200",chkDigit,Value.substring(14,15));
        				sheetObj.SetCellValue(Row, Col,Value.substring(0,14));
        				sheetObj.SelectCell(Row, Col);
        			}
        		}else if(Value.length == 14){
        			sheetObj.SetCellValue(Row, Col,Value+chkDigit,0);
        		}
    		}
    	}
    	if(Col=='8'||Col=='10'||Col=='16'){
    		sheetObj.SetCellValue(Row, Col,Value.toUpperCase(),0);
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
		    		if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
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
					formObj.exp_cnt_cd.value="KR";
	   				document.form4.tabclosechk.value="";
	   				saveMsgFlg=true;
				}
			} else {
				formObj.exp_cnt_cd.value="KR";
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
					}else{
						sendForm("ESM_BKG_0361_03.do","I","BR");
					}
				}else{
					formObj2.imp_cnt_cd.value="KR";
	   				document.form4.tabclosechk.value="";
	   				saveMsgFlg=true;
				}
			} else {
				formObj2.imp_cnt_cd.value="KR";
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
