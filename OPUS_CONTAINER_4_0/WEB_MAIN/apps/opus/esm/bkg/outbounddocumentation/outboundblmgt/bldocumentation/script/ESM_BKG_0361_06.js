/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0361_06.js
*@FileTitle  :Export / Import Information (Canada)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=0; 
var returntabFlg=true;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var saveMsgFlg=true;
var isInquiry=false;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
    	/* */
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
   		if (!opener) opener=window.dialogArguments;
   		if(!opener) opener=parent;
   		isInquiry=opener.document.form.isInquiry && "Y"==ComGetObjValue(opener.document.form.isInquiry);
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
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}        
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);           
        }
        initControl();
        if(document.form3.get_io_bnd_cd.value != 'I'){				
        	beforetab=0; 
        	tab1.SetSelectedIndex(0);
        	document.form.exp_cnt_cd.selectedIndex=1;
        	objs=document.all.item("tabLayer");
        	objs[0].style.display="Inline";
        	objs[1].style.display="none";      
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
					}else if (document.form3.pol_cd.value.substring(0,2)=='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
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
     * Tab Info Setting
     */
    function initTab(tabObj , tabNo) {
        with (tabObj) {
			InsertItem( "Export" , "");
			InsertItem( "Import" , "");
			SetSelectedIndex(0);
        }
    }
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
    }

    function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "imp_ndr_ref_id": 
	            var i=0;	            
	            comboObj.InsertItem(i++, "NDR1|Goods exported for consumption in the United States.",            "NDR1");
	            comboObj.InsertItem(i++, "NDR2|Commercial goods having a value of less than CAN$2,000",          "NDR2");
	            comboObj.InsertItem(i++, "NDR3|Personal and household effects, other than those of an emigrant, that are not for resale or commercial use",           "NDR3");
	            comboObj.InsertItem(i++, "NDR4|Conveyances that would, if they were imported, be classified at the time of importation under any of tariff|NDR4", "NDR4");
	            comboObj.InsertItem(i++, "|item Nos. 9801.10.00, 9801.20.00 or 9801.30.00 in the List of Tariff Provisions set out in the schedule to the|NDR4", "NDR4");
	            comboObj.InsertItem(i++, "|Customs Tariff|NDR4", "NDR4");
	            comboObj.InsertItem(i++, "NDR5|Cargo containers that would, if they were imported, be classified at the time of importation under tariff item No.|NDR5", "NDR5");
	            comboObj.InsertItem(i++, "|980l.10.00 in the List of Tariff Provisions set out in the schedule to the Customs Tariff|NDR5", "NDR5");
	            comboObj.InsertItem(i++, "NDR6|Reusable skids, drums, pallets, straps and similar goods used by a carrier in the international|NDR6", "NDR6");
	            comboObj.InsertItem(i++, "|commercial transportation of goods|NDR6", "NDR6");
	            comboObj.InsertItem(i++, "NDR7|Goods exported by diplomatic embassy or mission personnel for their personal or official use",         "NDR7");
	            comboObj.InsertItem(i++, "NDR8|Personal gifts and donations of goods, excluding conveyances",         "NDR8");
	            comboObj.InsertItem(i++, "NDR9|Goods that were imported into Canada and are exported from Canada after being transported in transit|NDR9", "NDR9"); 
	            comboObj.InsertItem(i++, "|through Canada en route to a non-Canadian destination|NDR9", "NDR9"); 
	            comboObj.InsertItem(i++, "NDR10|Goods that were manufactured or produced in Canada and that are exported from Canada for the purpose|NDR10", "NDR10"); 
	            comboObj.InsertItem(i++, "|of being transshipped through another country to another Canadian destination|NDR10", "NDR10"); 
	            comboObj.InsertItem(i++, "NDR11|Goods exported for repair or warranty repair that will be returned to Canada",         "NDR11");
	            comboObj.InsertItem(i++, "NDR12|Goods for use as ships' stores by a Canadian carrier",         "NDR12");
	            comboObj.InsertItem(i++, "NDR13|Goods manufactured or produced outside Canada and removed for export|NDR13", "NDR13");
	            comboObj.InsertItem(i++, "|from a bonded warehouse or sufferance warehouse|NDR13", "NDR13");
	            comboObj.InsertItem(i++, "NDR14|Goods, other than goods exported for further processing, that will be returned|NDR14", "NDR14");
	            comboObj.InsertItem(i++, "|to Canada within 12 months after the date of exportation|NDR14", "NDR14");
	            comboObj.InsertItem(i++, "NDR15|Goods being exported on behalf of Department of National Defense or due to|NDR15", "NDR15");
	            comboObj.InsertItem(i++, "|an emergency will report orally according to section 15 of the export regulations|NDR15", "NDR15");
	            comboObj.InsertItem(i++, "NDR16|Goods reported on a Form E15 Certificate of Destruction/Exportation for temporary export",         "NDR16");
	            comboObj.SetColWidth(0, "50");
	            comboObj.SetColWidth(1, "550");
	            comboObj.SetColWidth(2, "0");
	            comboObj.SetDropHeight(350);
	            comboObj.SetColBackColor(0,"#eeeeee");
	            break; 
	        case "exp_ndr_ref_id": 
	        	var i=0;	            
	        	comboObj.InsertItem(i++, "NDR1|Goods exported for consumption in the United States.|NDR1",            "NDR1");
	            comboObj.InsertItem(i++, "NDR2|Commercial goods having a value of less than CAN$2,000|NDR2",          "NDR2");
	            comboObj.InsertItem(i++, "NDR3|Personal and household effects, other than those of an emigrant, that are not for resale or|NDR3 ",           "NDR3");
	            comboObj.InsertItem(i++, "|commercial use|NDR3",           "NDR3");
	            comboObj.InsertItem(i++, "NDR4|Conveyances that would, if they were imported, be classified at the time of importation under |NDR4", "NDR4");
	            comboObj.InsertItem(i++, "|any of tariff item Nos. 9801.10.00, 9801.20.00 or 9801.30.00 in the List of Tariff Provisions set|NDR4", "NDR4");
	            comboObj.InsertItem(i++, "|out in the schedule to the Customs Tariff|NDR4", "NDR4");
	            comboObj.InsertItem(i++, "NDR5|Cargo containers that would, if they were imported, be classified at the time of importation|NDR5",        "NDR5");
	            comboObj.InsertItem(i++, "|under tariff item No. 980l.10.00 in the List of Tariff Provisions set out in the schedule to the|NDR5",        "NDR5");
	            comboObj.InsertItem(i++, "|to the Customs Tariff|NDR5",        "NDR5");
	            comboObj.InsertItem(i++, "NDR6|Reusable skids, drums, pallets, straps and similar goods used by a carrier in the international|NDR6",       "NDR6");
	            comboObj.InsertItem(i++, "|commercial transportation of goods|NDR6",       "NDR6");
	            comboObj.InsertItem(i++, "NDR7|Goods exported by diplomatic embassy or mission personnel for their personal or official use|NDR7",         "NDR7");
	            comboObj.InsertItem(i++, "NDR8|Personal gifts and donations of goods, excluding conveyances|NDR8",         "NDR8");
	            comboObj.InsertItem(i++, "NDR9|Goods that were imported into Canada and are exported from Canada after being transported|NDR9",         "NDR9");
	            comboObj.InsertItem(i++, "|in transit through Canada en route to a non-Canadian destination|NDR9",         "NDR9");
	            comboObj.InsertItem(i++, "NDR10|Goods that were manufactured or produced in Canada and that are exported from Canada for|NDR10",         "NDR10");
	            comboObj.InsertItem(i++, "|the purpose of being transshipped through another country to another Canadian destination|NDR10",         "NDR10");
	            comboObj.InsertItem(i++, "NDR11|Goods exported for repair or warranty repair that will be returned to Canada|NDR11",         "NDR11");
	            comboObj.InsertItem(i++, "NDR12|Goods for use as ships' stores by a Canadian carrier|NDR12",         "NDR12");
	            comboObj.InsertItem(i++, "NDR13|Goods manufactured or produced outside Canada and removed for export from a bonded|NDR13",         "NDR13");
	            comboObj.InsertItem(i++, "|warehouse or sufferance warehouse|NDR13",         "NDR13");
	            comboObj.InsertItem(i++, "NDR14|Goods, other than goods exported for further processing, that will be returned to Canada within|NDR14",         "NDR14");
	            comboObj.InsertItem(i++, "|12 months after the date of exportation|NDR14",         "NDR14");
	            comboObj.InsertItem(i++, "NDR15|Goods being exported on behalf of Department of National Defense or due to an emergency|NDR15",         "NDR15");
	            comboObj.InsertItem(i++, "|will report orally according to section 15 of the export regulations|NDR15",         "NDR15");
	            comboObj.InsertItem(i++, "NDR16|Goods reported on a Form E15 Certificate of Destruction/Exportation for temporary export|NDR16",         "NDR16");
	            comboObj.SetSelectCode("");
	            comboObj.SetColWidth(0, "50");
	            comboObj.SetColWidth(1, "550");
	            comboObj.SetColWidth(2, "0");
	            comboObj.SetDropHeight(350);
	            comboObj.SetColBackColor(0,"#eeeeee");
	            break; 
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
     * Tab click Event
     */
    function tab1_OnChange(tabObj , nItem) {
    	if (nItem==beforetab) return;   
    	var objs=document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	objs[beforetab].style.display="none";
     	
     	if(nItem==0)	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
     	
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
								sendForm("ESM_BKG_0361_02.do","O","KR");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","O","BR");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='IN'){
								sendForm("ESM_BKG_0361_04.do","O","IN");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='ID'){
								sendForm("ESM_BKG_0361_05.do","O","ID");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='CA'){
		   						sendForm("ESM_BKG_0361_01.do","O","CA");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='MX'){
								sendForm("ESM_BKG_0361_07.do","O","MX");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='CO'){
								sendForm("ESM_BKG_0361_07.do","O","MX");
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
					sendForm("ESM_BKG_0361_03.do","I","BR");
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
 					var HeadTitle="|Seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|caed_tp_cd|caed_no1|caed_no2|caed_no3|g7_edi_no1|g7_edi_no2|mf_smry_rpt_no|b13a_xpt_dt|b13a_xpt_no1|b13a_xpt_no2|cgo_ctrl_no|ndr_ref_id|ndr_ref_ctnt";
	
 					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0} );
	
 					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 					var headers = [ { Text:HeadTitle, Align:"Center"} ];
 					InitHeaders(headers, info);
	
 					var cols = [ {Type:"Status",    Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
 					             {Type:"Seq",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
 					             {Type:"Text",		Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:1 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"caed_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"caed_no1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"caed_no2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"caed_no3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"g7_edi_no1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"g7_edi_no2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mf_smry_rpt_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"b13a_xpt_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"b13a_xpt_no1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"b13a_xpt_no2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cgo_ctrl_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ndr_ref_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ndr_ref_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	 		       
 					InitColumns(cols);
	
 					SetEditable(1);
 					SetVisible(0);
	            }


 			break;
 			case 2:      //sheet1 init
 			    with(sheetObj){
 					var HeadTitle="|Seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|caed_tp_cd|caed_no1|caed_no2|caed_no3|g7_edi_no1|g7_edi_no2|mf_smry_rpt_no|b13a_xpt_dt|b13a_xpt_no1|b13a_xpt_no2|cgo_ctrl_no|ndr_ref_id|ndr_ref_ctnt";
	
 					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
 					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 					var headers = [ { Text:HeadTitle, Align:"Center"} ];
 					InitHeaders(headers, info);
	
 					var cols = [ {Type:"Status",    Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
 					             {Type:"Seq",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
 					             {Type:"Text",		Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:1 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"caed_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"caed_no1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"caed_no2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"caed_no3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"g7_edi_no1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"g7_edi_no2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mf_smry_rpt_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"b13a_xpt_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"b13a_xpt_no1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"b13a_xpt_no2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cgo_ctrl_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ndr_ref_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ndr_ref_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	 		       
 					InitColumns(cols);
	
 					SetEditable(1);
 					SetVisible(0);
 				}


 			break;
 		}
 	}
  // handling process for Sheet
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		sheetObj.SetWaitImageVisible(0);
 		switch(sAction) {
 			case IBSEARCH:      //retrieve
 		 		ComOpenWait(true);
 				if(validateForm(sheetObj, formObj, sAction)) {
 					formObj.f_cmd.value=SEARCH;
  					sheetObj.DoSearch("ESM_BKG_0361_06GS.do", FormQueryString(formObj) );
 				}
 		 		ComOpenWait(false);
 			break;
 			case IBSAVE:        //Save
//	 			if(document.form4.tabclosechk.value=="Y"){
//	 				obj=document.getElementsByName("exp_caed_tp_cd");	
//		 			for(var i=0; i<obj.length; i++){
//				        if(obj[i].checked==true){
//				        	
//				        	switch(obj[i].value) {
//					        	case "CE": 
//					        		if(formObj.caed_no.value!=''){
//					        			if (!ComShowCodeConfirm("BKG00254")) return;
//					        		}
//			 						break;
//					        	case "G7": 
//					        		if(formObj.g7_edi_no.value!=''){
//					        			if (!ComShowCodeConfirm("BKG00254")) return;
//					        		}
//					        		break;
//					        	case "SM": 
//					        		if(formObj.exp_mf_smry_rpt_no.value!=''){
//					        			if (!ComShowCodeConfirm("BKG00254")) return;
//					        		}
//						        	break;
//					        	case "EX": 
//					        		if(formObj.b13a_xpt_no.value!=''){		
//					        			if (!ComShowCodeConfirm("BKG00254")) return;
//					        		}
//						        	break;
//					        	case "IT": 
//					        		if(formObj.exp_cgo_ctrl_no.value!=''){	
//					        			if (!ComShowCodeConfirm("BKG00254")) return;
//					        		}
//						        	break;
//					        	case "ND": 
//					        		if(comboObjects[0].GetSelectCode()!=''){
//					        			if (!ComShowCodeConfirm("BKG00254")) return;
//					        		}
//						        	break;
//				        	}
//				        }
//				    }
//	 			}
 				if(validateForm(sheetObj,formObj,sAction)) {
 					document.form4.savechk.value="";
 					var obj="";
 					if (sheetObj.RowCount()==0){
 						initSheetData(sheetObj);
 					} 
 					if(formObj.name=="form"){
 						IBS_CopyFormToRow(formObj,sheetObj, 1, "exp_"); 					
 						obj=document.getElementsByName("exp_caed_tp_cd");	
 						sheetObj.SetCellValue(1,"cnt_cd","CA");
 						sheetObj.SetCellValue(1,"ndr_ref_id",ComGetObjValue(comboObjects[0]));
 					}else if(formObj.name=="form2"){
 						IBS_CopyFormToRow(formObj,sheetObj, 1, "imp_"); 					
 						obj=document.getElementsByName("imp_caed_tp_cd");
 						sheetObj.SetCellValue(1,"cnt_cd","CA");
 						sheetObj.SetCellValue(1,"ndr_ref_id",ComGetObjValue(comboObjects[1]));
 					}
				    for(var i=0; i<obj.length; i++){
				        if(obj[i].checked==true){
				        	sheetObj.SetCellValue(1,"caed_tp_cd",obj[i].value);
				        	var reVal="";
				        	switch(obj[i].value) {
					        	case "CE": 
					        		reVal=ComTrimAll(formObj.caed_no.value, "-", "/", ":"," ");				        		
						        	sheetObj.SetCellValue(1,"caed_no1",reVal.substring(0,6));
			 						sheetObj.SetCellValue(1,"caed_no2",reVal.substring(6,12));
			 						sheetObj.SetCellValue(1,"caed_no3",reVal.substring(12,23));
			 						break;
					        	case "G7": 
					        		reVal=ComTrimAll(formObj.g7_edi_no.value, "-", "/", ":"," ");		
					        		sheetObj.SetCellValue(1,"g7_edi_no1",reVal.substring(0,6));
			 						sheetObj.SetCellValue(1,"g7_edi_no2",reVal.substring(6,17));
					        		break;
					        	case "EX": 
					        		reVal=ComTrimAll(formObj.b13a_xpt_no.value, "-", "/", ":"," ");
					        		sheetObj.SetCellValue(1,"b13a_xpt_dt","");
					        		sheetObj.SetCellValue(1,"b13a_xpt_no1",reVal.substring(0,10));
			 						sheetObj.SetCellValue(1,"b13a_xpt_no2",reVal.substring(10,21));
						        	break;
				        	}
				        }
				    }
				    if (sheetObj.GetCellValue(1,"caed_tp_cd")=='0'){
//				    	sheetObj.RowDelete(1, 0);
 						sheetObj.SetCellValue(1,0,'D');
				    }
 					formObj.f_cmd.value=MULTI;
					var SaveStr = sheetObj.GetSaveString();
 					
 					if(document.form4.tabclosechk.value=="Y"){
						
						if (!sheetObj.IsDataModified() && SaveStr == "") return;
						if(confirm(ComGetMsg("BKG00962"))){
					 		ComOpenWait(true);
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_06GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
							sheetObj.LoadSaveData(rtnData); 	
					 		ComOpenWait(false);
						}
 					}else{
						if (!sheetObj.IsDataModified() && SaveStr == ""){
							//BKG95053
							//There is no data to Save. Please check again.
							ComShowCodeMessage("BKG95053");
							return;
						}

						if(confirm(ComGetMsg("BKG00962"))){
					 		ComOpenWait(true);
					 		
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_06GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
							sheetObj.LoadSaveData(rtnData); 	
					 		ComOpenWait(false);
						}
 						
 					}
 				}
 			break;
 			case IBDELETE:      // Insert
 				if(formObj.name=="form"){
	 				var obj=document.getElementsByName("exp_caed_tp_cd");
		    		for(var i=0; i<obj.length; i++){      
				        obj[i].checked=false
				        radioBtnSet(obj[i]);
				    }
 				}else{
 					var obj2=document.getElementsByName("imp_caed_tp_cd");
		    		for(var i=0; i<obj2.length; i++){      
		    			obj2[i].checked=false
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
    	
//    	if(sAction==undefined)	sAction='2';	//copyDesc 체크로직 추가(validateForm("",formObj))
    	// if (!ComChkValid(formObj)) return false;
    	with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
		if(sAction=='2'){	
	 		if(formObj.name=="form"){
		 		var size=formObj.exp_caed_tp_cd.length;	
		 		
				for(var i=0; i < size; i++) {
					if(formObj.exp_caed_tp_cd[i].checked) {
						objs=document.all.item("tabLayer");
				 		
						switch(formObj.exp_caed_tp_cd[i].value) {
				        	case "CE":     
				        		if(formObj.caed_no.value==''){
				        			setTab1();
				        			ComAlertFocus(formObj.caed_no, ComGetMsg("COM12114"));
				        			saveMsgFlg=false;
				        			return false;
				        			break;
				        		}
				        		sVal=formObj.caed_no.value;
				        		var val_len = sVal.length;
				        		if(val_len < 23){
				        			setTab1();
				        			ComAlertFocus(formObj.caed_no, ComGetMsg("BKG95018","CAED No.","23"));	
				        			saveMsgFlg=false;
				        			return false;
				        			break;
				        		}else{
				        			
					        		formObj.caed_no.value=sVal.toUpperCase();
				        		}
				        		
//				        		sVal=ComTrimAll(formObj.caed_no.value, "-", "/", ".");
//				        		if (!ComIsCaedNo(sVal)){
//				        			setTab1();
////				        			ComAlertFocus(formObj.caed_no, ComGetMsg("COM12128","a valid format : NNANNN(6) - AANNNN(6) - NNNNNNNNNNN(11)"));				        		 
//				        			ComAlertFocus(formObj.caed_no, ComGetMsg("COM12128","a valid format : NNANNNAANNNNNNNNNNNNNNN"));
//				        			saveMsgFlg=false;
//				        			return false;
//				        			break;
//				        		}else{
//				        			var re=new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([A-Z][A-Z][0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
////				        			formObj.caed_no.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3').toUpperCase();
//				        			formObj.caed_no.value=sVal.toUpperCase();
//				        		}
				        		break;
				        	case "G7": 
				        		if(formObj.g7_edi_no.value==''){
				        			setTab1();
				        			ComAlertFocus(formObj.g7_edi_no,  ComGetMsg("COM12114"));
				        			saveMsgFlg=false;
				        			return false;
				        			break;
				        		}
				        		sVal=ComTrimAll(formObj.g7_edi_no.value, "-", "/", ".");
				        		if (!ComIsG7EdiNo(sVal)){
				        			setTab1();
//				        			ComAlertFocus(formObj.g7_edi_no, ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));				        		 
				        			ComAlertFocus(formObj.g7_edi_no, ComGetMsg("COM12128","a valid format : NNANNNNNNNNNNNNNN"));
				        			saveMsgFlg=false;
				        			return false;
				        			break;
				        		}else{
				        			var re=new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
//				        			formObj.g7_edi_no.value=sVal.replace(re,'$1' + "-" + '$2');
				        			formObj.g7_edi_no.value=sVal;
				        		}		                    
				        		break;
				        	case "SM":
				        		if(formObj.exp_mf_smry_rpt_no.value==''){
				        			setTab1();
				        			ComAlertFocus(formObj.exp_mf_smry_rpt_no,  ComGetMsg("COM12114"));
				        			saveMsgFlg=false;
				        			return false;
				        			break;
				        		}
				        		if(formObj.exp_mf_smry_rpt_no.value.length<4){
				        			setTab1();
				        			ComAlertFocus(formObj.exp_mf_smry_rpt_no,  ComGetMsg("COM12114"));
				        			saveMsgFlg=false;
				        			return false;
				        			break; 
				        		}
				        		break;
				        	case "EX":				        	 
				        		if(formObj.b13a_xpt_no.value==''){				        		
					        		setTab1();
					        		ComAlertFocus(formObj.b13a_xpt_no,  ComGetMsg("COM12114"));
				        			saveMsgFlg=false;
					        		return false;
					        		break;
				        		}
				        		sVal=formObj.b13a_xpt_no.value;
				        		var val_len = sVal.length;
				        		if(val_len < 21){
				        			setTab1();
				        			ComAlertFocus(formObj.b13a_xpt_no, ComGetMsg("BKG95018","EXD (Form B13A)","21"));	
				        			saveMsgFlg=false;
				        			return false;
				        			break;
				        		}else{
				        			formObj.b13a_xpt_no.value=sVal.toUpperCase();
				        		}
				        		
//				        		sVal=ComTrimAll(formObj.b13a_xpt_no.value, "-", "/", " ",":");
//				        		if (!ComIsB13aXptNo(sVal)){
//				        			setTab1();
////				        			ComAlertFocus(formObj.b13a_xpt_no, ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));
//				        			ComAlertFocus(formObj.b13a_xpt_no, ComGetMsg("COM12128","a valid format : YYYYMMDDHHMINNNNNNNNN"));	
//				        			saveMsgFlg=false;
//				        			return false;
//				        			break;
//				        		}else{
//				        			var re=new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9])');
////				        			formObj.b13a_xpt_no.value=sVal.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
//				        			formObj.b13a_xpt_no.value=sVal;
//				        		}		
				        		break;
				        	case "IT":
				        		if(formObj.exp_cgo_ctrl_no.value==''){				        		 
					        		setTab1();
					        		ComAlertFocus(formObj.exp_cgo_ctrl_no,  ComGetMsg("COM12114"));
				        			saveMsgFlg=false;
					        		return false;
					        		break;
				        		}
				        		break;
				        	case "ND":
				        		if(comboObjects[0].GetSelectCode()==''){
				        			setTab1();
				        			ComAlertFocus(exp_ndr_ref_id,  ComGetMsg("COM12114"));
				        			saveMsgFlg=false;
				        			return false;
				        			break;
				        		}
				        		break;
						}
					}
				}
	 		}else if(formObj.name=="form2"){
	 			var size2=formObj.imp_caed_tp_cd.length;	
				for(var j=0; j < size2; j++) {
					if(formObj.imp_caed_tp_cd[j].checked) {
						objs=document.all.item("tabLayer");
						switch(formObj.imp_caed_tp_cd[j].value) {
							case "CE":     
								if(formObj.caed_no.value==''){
									setTab2();
									ComAlertFocus(formObj.caed_no, ComGetMsg("COM12114"));
									return false;
									break;
								}
								sVal=ComTrimAll(formObj.caed_no.value, "-", "/", ".");
								if (!ComIsCaedNo(sVal)){
									setTab2();
									ComAlertFocus(formObj.caed_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - AANNNN(6) - NNNNNNNNNNN(11)"));
									saveMsgFlg=false;
									return false;
									break;
								}else{
									var re=new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([A-Z][A-Z][0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
									formObj.caed_no.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3').toUpperCase();
								}
								break;
							case "G7": 
								if(formObj.g7_edi_no.value==''){
									setTab2();
									ComAlertFocus(formObj.g7_edi_no,  ComGetMsg("COM12114"));
									saveMsgFlg=false;
									return false;
									break;
								}
								sVal=ComTrimAll(formObj.g7_edi_no.value, "-", "/", ".");
								if (!ComIsG7EdiNo(sVal)){
									setTab2();
									ComAlertFocus(formObj.g7_edi_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));
									saveMsgFlg=false;
									return false;
									break;
								}else{
									var re=new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
									formObj.g7_edi_no.value=sVal.replace(re,'$1' + "-" + '$2');
								}		                    
								break;
							case "SM":
								if(formObj.imp_mf_smry_rpt_no.value==''||formObj.imp_mf_smry_rpt_no.value.length<4){
									setTab2();
									ComAlertFocus(formObj.imp_mf_smry_rpt_no,  ComGetMsg("COM12114"));
									saveMsgFlg=false;
									return false;
									break;
								}	
								break;
							case "EX":				        	 
								if(formObj.b13a_xpt_no.value==''){
									setTab2();
									ComAlertFocus(formObj.b13a_xpt_no,  ComGetMsg("COM12114"));
									saveMsgFlg=false;
									return false;
									break;
								}
								sVal=ComTrimAll(formObj.b13a_xpt_no.value, "-", "/", " ",":");
								if (!ComIsB13aXptNo(sVal)){
									setTab2();
									ComAlertFocus(formObj.b13a_xpt_no,  ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));
									saveMsgFlg=false;
									return false;
									break;
								}else{
									var re=new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9])');
									formObj.b13a_xpt_no.value=sVal.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
								}		
								break;
							case "IT":
								if(formObj.imp_cgo_ctrl_no.value==''){
									setTab2();
									ComAlertFocus(formObj.imp_cgo_ctrl_no,  ComGetMsg("COM12114"));
									saveMsgFlg=false;
									return false;
									break;
								}
								break;
							case "ND":
								if(comboObjects[1].GetSelectCode()==''){
									setTab2();
									ComAlertFocus(imp_ndr_ref_id,  ComGetMsg("COM12114"));
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
 // Initialize the sheet
    function initSheetData(sheetObj) {
    	sheetObj.RemoveAll();
    	sheetObj.DataInsert(-1);
    }
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	formObj=document.form;
    	var obj=document.getElementsByName("exp_caed_tp_cd");
    	
    	//1.checked 처리
    	if (sheetObj.RowCount()>0){
    		for(var i=0; i<obj.length; i++){
    			if(obj[i].value==sheetObj.GetCellValue(1,"caed_tp_cd")){
 		        	obj[i].checked=true;
 		        }else{
 		        	obj[i].checked=false;
 		        }
				radioBtnSet(obj[i]);
 		    }
    	}
    	//2.form value setting
    	if (sheetObj.RowCount()>0){
    		IBS_CopyRowToForm(sheetObj,formObj, 1, "exp_"); 
    		formObj.caed_no.value=sheetObj.GetCellValue(1,"caed_no1")+sheetObj.GetCellValue(1,"caed_no2")+sheetObj.GetCellValue(1,"caed_no3");
    		formObj.g7_edi_no.value=sheetObj.GetCellValue(1,"g7_edi_no1")+sheetObj.GetCellValue(1,"g7_edi_no2");
    		formObj.b13a_xpt_no.value=sheetObj.GetCellValue(1,"b13a_xpt_dt")+sheetObj.GetCellValue(1,"b13a_xpt_no1")+sheetObj.GetCellValue(1,"b13a_xpt_no2");
//    		if(sheetObj.GetCellValue(1,"caed_no1")!=''){
//    			formObj.caed_no.value=sheetObj.GetCellValue(1,"caed_no1")+"-"+sheetObj.GetCellValue(1,"caed_no2")+"-"+sheetObj.GetCellValue(1,"caed_no3");
//    		}
//    		if(sheetObj.GetCellValue(1,"g7_edi_no1")!=''){
//    			formObj.g7_edi_no.value=sheetObj.GetCellValue(1,"g7_edi_no1")+"-"+sheetObj.GetCellValue(1,"g7_edi_no2");
//    		}
//    		if(sheetObj.GetCellValue(1,"b13a_xpt_dt")!=''){
//    			formObj.b13a_xpt_no.value=sheetObj.GetCellValue(1,"b13a_xpt_dt")+" "+sheetObj.GetCellValue(1,"b13a_xpt_no1")+"-"+sheetObj.GetCellValue(1,"b13a_xpt_no2");
//    		}
    		if(sheetObj.GetCellValue(1,"ndr_ref_id")!=''){
    			comboObjects[0].SetSelectCode(sheetObj.GetCellValue(1,"ndr_ref_id"));
    		}
    	}
    	
    	if (sheetObj.RowCount()<1){
    		//sheet init
    		initSheetData(sheetObj);
    		//form init
    		for(var i=0; i<obj.length; i++){      
		        obj[i].checked=false
		        radioBtnSet(obj[i]);
		    }
   		
    		IBS_CopyFormToRow(formObj,sheetObj, 1, "exp_"); 
    		
    		for(var i=0; i<obj.length; i++){
		        if(obj[i].checked==true){
		        	sheetObj.SetCellValue(1,"caed_tp_cd",obj[i].value);
		        }
				radioBtnSet(obj[i]);
    		}
    	}
    	
    	document.form3.get_io_bnd_cd.value="O";

    }
    function sheet2_OnSearchEnd(sheetObj,ErrMsg){
    	formObj=document.form2;
    	var obj=document.getElementsByName("imp_caed_tp_cd");
    	if (sheetObj.RowCount()>0){
    		IBS_CopyRowToForm(sheetObj, formObj, 1, "imp_"); 
    		for(var i=0; i<obj.length; i++){
    			if(obj[i].value==sheetObj.GetCellValue(1,"caed_tp_cd")){
 		        	obj[i].checked=true;
 		        }else{
 		        	obj[i].checked=false;
 		        }
				radioBtnSet(obj[i]);
 		    }
    		formObj.caed_no.value=sheetObj.GetCellValue(1,"caed_no1")+sheetObj.GetCellValue(1,"caed_no2")+sheetObj.GetCellValue(1,"caed_no3");
    		formObj.g7_edi_no.value=sheetObj.GetCellValue(1,"g7_edi_no1")+sheetObj.GetCellValue(1,"g7_edi_no2");
    		formObj.b13a_xpt_no.value=sheetObj.GetCellValue(1,"b13a_xpt_dt")+sheetObj.GetCellValue(1,"b13a_xpt_no1")+sheetObj.GetCellValue(1,"b13a_xpt_no2");
//    		if(sheetObj.GetCellValue(1,"caed_no1")!=''){
//    			formObj.caed_no.value=sheetObj.GetCellValue(1,"caed_no1")+"-"+sheetObj.GetCellValue(1,"caed_no2")+"-"+sheetObj.GetCellValue(1,"caed_no3");
//    		}
//    		if(sheetObj.GetCellValue(1,"g7_edi_no1")!=''){
//    			formObj.g7_edi_no.value=sheetObj.GetCellValue(1,"g7_edi_no1")+"-"+sheetObj.GetCellValue(1,"g7_edi_no2");
//    		}
//    		if(sheetObj.GetCellValue(1,"b13a_xpt_dt")!=''){
//    			formObj.b13a_xpt_no.value=sheetObj.GetCellValue(1,"b13a_xpt_dt")+" "+sheetObj.GetCellValue(1,"b13a_xpt_no1")+"-"+sheetObj.GetCellValue(1,"b13a_xpt_no2");
//    		}
    		if(sheetObj.GetCellValue(1,"ndr_ref_id")!=''){
    			comboObjects[1].SetSelectCode(sheetObj.GetCellValue(1,"ndr_ref_id"));
    		}
    	}/*else{
    		initSheetData(sheetObj);
            IBS_CopyFormToRow(formObj,sheetObj, 1, "imp_"); 
            for(var i=0; i<obj.length; i++){
		        if(obj[i].checked==true){
		        	sheetObj.SetCellValue(1,"caed_tp_cd",obj[i].value);
		        }
				radioBtnSet(obj[i]);
		    }
    	}*/
    	document.form3.get_io_bnd_cd.value="I";
    }
    function sheet1_OnSaveEnd(sheetObj, code, ErrMsg){
    	ComOpenWait(false);
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
    	ComOpenWait(false);
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
            obj.value=ComTrimAll(obj.value, "-", "/", ":"," ");
            if (obj.type == 'text' && obj.value.length >=1 && obj.onfocus==null) obj.onfocus=new Function("this.select()");
			event.returnValue=true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    function ComIsCaedNo(obj, sFlag) {
        try {
            var sVal=getArgValue(obj);
            sVal=sVal.replace(/\/|\-|\./g,"");
            if (sVal.length != 23) return false;
            if (!ComIsNumber(sVal.substring(0,2))) return false;
            if (!isAlpha(sVal.substring(2,3))) return false;      
            if (!ComIsNumber(sVal.substring(3,6))) return false;
            if (!isAlpha(sVal.substring(6,8))) return false;  
            if (!ComIsNumber(sVal.substring(8,23))) return false;
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    function ChkComIsCaedNo(obj){
    	if(obj.form.name=='form'){
	    	var size=document.form.exp_caed_tp_cd.length;	
	    	var j=0
			for(var i=0; i < size; i++) {
				if(document.form.exp_caed_tp_cd[i].checked) {
					if(document.form.exp_caed_tp_cd[i].value!='CE') return false;
					j++
				}				
			}
	    	if(j<1) return false;
    	}else{		
			var size=document.form2.imp_caed_tp_cd.length;	
			var j=0
			for(var i=0; i < size; i++) {
				if(document.form2.imp_caed_tp_cd[i].checked) {
					if(document.form2.imp_caed_tp_cd[i].value!='CE') return false;
					j++
				}				
			}
			if(j<1) return false;
    	}
    	if (!ComIsCaedNo(obj.value)){
    		 if(obj.form.name=='form'){
    			 //ComAlertFocus(document.form.caed_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - AANNNN(6) - NNNNNNNNNNN(11)"));
    		 }else{
    			 //ComAlertFocus(document.form2.caed_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - AANNNN(6) - NNNNNNNNNNN(11)"));
    		 }
    		 return false;
	   	}else{
	   		var re=new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([A-Z][A-Z][0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
	   		sVal=obj.value.toUpperCase()
	   		if(obj.form.name=='form'){
//	   			document.form.caed_no.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
	   			document.form.caed_no.value=sVal;
	   		}else{
//	   			document.form2.caed_no.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
	   			document.form2.caed_no.value=sVal;
	   		}
	   	}
    }
    function ComIsG7EdiNo(obj, sFlag) {
        try {
            var sVal=getArgValue(obj);
            sVal=sVal.replace(/\/|\-|\./g,"");
            if (sVal.length != 17) return false;
            if (!ComIsNumber(sVal.substring(0,2))) return false;
            if (!isAlpha(sVal.substring(2,3))) return false;      
            if (!ComIsNumber(sVal.substring(3,17))) return false;
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    function ChkComIsG7EdiNo(obj){
    	if(obj.form.name=='form'){
	    	var size=document.form.exp_caed_tp_cd.length;	
	    	var j=0
			for(var i=0; i < size; i++) {
				if(document.form.exp_caed_tp_cd[i].checked) {
					if(document.form.exp_caed_tp_cd[i].value!='G7') return false;
					j++
				}				
			}
	    	if(j<1) return false;
    	}else{		
			var size=document.form2.imp_caed_tp_cd.length;	
			var j=0
			for(var i=0; i < size; i++) {
				if(document.form2.imp_caed_tp_cd[i].checked) {
					if(document.form2.imp_caed_tp_cd[i].value!='G7') return false;
					j++
				}				
			}
			if(j<1) return false;
    	}
    	if (!ComIsG7EdiNo(obj.value)){
			 if(obj.form.name=='form'){
				 //ComAlertFocus(document.form.g7_edi_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));
			 }else{
				 //ComAlertFocus(document.form2.g7_edi_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));
			 }
	   	}else{
	   		var re=new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
	   		sVal=obj.value.toUpperCase();
	   		if(obj.form.name=='form'){
//	   			document.form.g7_edi_no.value=sVal.replace(re,'$1' + "-" + '$2').toUpperCase();
	   			document.form.g7_edi_no.value=sVal;
	   		}else{
//	   			document.form2.g7_edi_no.value=sVal.replace(re,'$1' + "-" + '$2').toUpperCase();
	   			document.form.g7_edi_no.value=sVal;
	   		}
	   	}
    }
    function ComIsB13aXptNo(obj, sFlag) {
        try {
            var sVal=getArgValue(obj);
            sVal=sVal.replace(/\/|\-|\./g," ");
            if (sVal.length != 21) return false;
            if (!ComIsNumber(sVal)) return false;
            var year, month, day, week;
            year=sVal.substring(0,4);
            month=sVal.substring(4,6);
            day=sVal.substring(6,8);
            hm=sVal.substring(8,12);
            if((ComParseInt(year) < 1900)  || !ComIsMonth( month ) || !ComIsDay( year,month ,day)|| !ComIsTime(hm, "hm")) return false;
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    function ChkComIsB13aXptNo(obj){
    	if(obj.form.name=='form'){
	    	var size=document.form.exp_caed_tp_cd.length;	
	    	var j=0
			for(var i=0; i < size; i++) {				
				if(document.form.exp_caed_tp_cd[i].checked) {
					if(document.form.exp_caed_tp_cd[i].value!='EX') return false;
					j++
				}
			}
	    	if(j<1) return false;
    	}else{		
			var size=document.form2.imp_caed_tp_cd.length;	
			var j=0
			for(var i=0; i < size; i++) {
				if(document.form2.imp_caed_tp_cd[i].checked) {
					if(document.form2.imp_caed_tp_cd[i].value!='EX') return false;
					j++
				}				
			}
			if(j<1) return false;
    	}
    	if (!ComIsB13aXptNo(obj.value)){
			 if(obj.form.name=='form'){
				 //ComAlertFocus(document.form.b13a_xpt_no,  ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));
			 }else{
				 //ComAlertFocus(document.form2.b13a_xpt_no,  ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));
			 }
	   	}else{
	   		var re=new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9])');
        	if(obj.form.name=='form'){
//	   			document.form.b13a_xpt_no.value=obj.value.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
        		document.form.b13a_xpt_no.value=obj.value;
	   		}else{
//	   			document.form2.b13a_xpt_no.value=obj.value.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
        		document.form2.b13a_xpt_no.value=obj.value;
	   		}
	   	}
    }
    function isAlpha(str) {
        var pattern=/^[a-zA-Z]+$/;
        return (pattern.test(str)) ? true : false;
    }
    function radioBtnSet(obj){
    	formObj=document.form;
    	formObj2=document.form2;
    	if(obj.name=='exp_caed_tp_cd'&& obj.checked==true){
    		var obj2=document.getElementsByName("exp_caed_tp_cd");
		    for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		            obj2[i].checked=false;
		        }
		    }
	    	switch(obj.value) {
		        case "CE":  
		        	formObj.caed_no.readOnly=false;
		        	formObj.g7_edi_no.value='';
		        	formObj.g7_edi_no.readOnly=true;
		            formObj.exp_mf_smry_rpt_no.value='';
		            formObj.exp_mf_smry_rpt_no.readOnly=true;
		            formObj.b13a_xpt_no.value='';
		            formObj.b13a_xpt_no.readOnly=true;
		            formObj.exp_cgo_ctrl_no.value='';
		            formObj.exp_cgo_ctrl_no.readOnly=true;
		            exp_ndr_ref_id.SetSelectCode( -1, true);
		            exp_ndr_ref_id.SetEnable(0);
		            formObj.exp_ndr_ref_ctnt.value='';
		            formObj.exp_ndr_ref_ctnt.readOnly=true;
		            break;
		        case "G7": 
		        	formObj.caed_no.value='';
		        	formObj.caed_no.readOnly=true;
		            formObj.g7_edi_no.readOnly=false;
		            formObj.exp_mf_smry_rpt_no.value='';
		            formObj.exp_mf_smry_rpt_no.readOnly=true;
		            formObj.b13a_xpt_no.value='';
		            formObj.b13a_xpt_no.readOnly=true;
		            formObj.exp_cgo_ctrl_no.value='';
		            formObj.exp_cgo_ctrl_no.readOnly=true;
		            exp_ndr_ref_id.SetSelectCode( -1, true);
		            exp_ndr_ref_id.SetEnable(0);
		            formObj.exp_ndr_ref_ctnt.value='';
		            formObj.exp_ndr_ref_ctnt.readOnly=true;
		            break;
		        case "SM":
		        	formObj.caed_no.value='';
		        	formObj.caed_no.readOnly=true;
		            formObj.g7_edi_no.value='';
		            formObj.g7_edi_no.readOnly=true;
		            formObj.exp_mf_smry_rpt_no.readOnly=false;
		            formObj.b13a_xpt_no.value='';
		            formObj.b13a_xpt_no.readOnly=true;
		            formObj.exp_cgo_ctrl_no.value='';
		            formObj.exp_cgo_ctrl_no.readOnly=true;
		            exp_ndr_ref_id.SetSelectCode( -1, true);
		            exp_ndr_ref_id.SetEnable(0);
		            formObj.exp_ndr_ref_ctnt.value='';
		            formObj.exp_ndr_ref_ctnt.readOnly=true;
		            break;
		        case "EX":
		        	formObj.caed_no.value='';
		        	formObj.caed_no.readOnly=true;
		            formObj.g7_edi_no.value='';
		            formObj.g7_edi_no.readOnly=true;
		            formObj.exp_mf_smry_rpt_no.value='';
		            formObj.exp_mf_smry_rpt_no.readOnly=true;
		            formObj.b13a_xpt_no.readOnly=false;
		            formObj.exp_cgo_ctrl_no.value='';
		            formObj.exp_cgo_ctrl_no.readOnly=true;
		            exp_ndr_ref_id.SetSelectCode( -1, true);
		            exp_ndr_ref_id.SetEnable(0);
		            formObj.exp_ndr_ref_ctnt.value='';
		            formObj.exp_ndr_ref_ctnt.readOnly=true;
		            break;
		        case "IT":
		        	formObj.caed_no.value='';
		        	formObj.caed_no.readOnly=true;
		            formObj.g7_edi_no.value='';
		            formObj.g7_edi_no.readOnly=true;
		            formObj.exp_mf_smry_rpt_no.value='';
		            formObj.exp_mf_smry_rpt_no.readOnly=true;
		            formObj.b13a_xpt_no.value='';
		            formObj.b13a_xpt_no.readOnly=true;
		            formObj.exp_cgo_ctrl_no.readOnly=false;
		            exp_ndr_ref_id.SetSelectCode( -1, true);
		            exp_ndr_ref_id.SetEnable(0);
		            formObj.exp_ndr_ref_ctnt.value='';
		            formObj.exp_ndr_ref_ctnt.readOnly=true;
		            break;
		        case "ND":
		        	formObj.caed_no.value='';
		        	formObj.caed_no.readOnly=true;
		            formObj.g7_edi_no.value='';
		            formObj.g7_edi_no.readOnly=true;
		            formObj.exp_mf_smry_rpt_no.value='';
		            formObj.exp_mf_smry_rpt_no.readOnly=true;
		            formObj.b13a_xpt_no.value='';
		            formObj.b13a_xpt_no.readOnly=true;
		            formObj.exp_cgo_ctrl_no.value=''
		            formObj.exp_cgo_ctrl_no.readOnly=true;
		            exp_ndr_ref_id.SetEnable(1);
		            formObj.exp_ndr_ref_ctnt.readOnly=false;
		            break;
	    	}
    	}else if(obj.name=='imp_caed_tp_cd'&& obj.checked==true){
    		var obj2=document.getElementsByName("imp_caed_tp_cd");
		    for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		        	obj2[i].checked=false;
		        }
		    }
    		switch(obj.value) {
	    		case "CE":  
		        	formObj2.caed_no.readOnly=false;
		            formObj2.g7_edi_no.value='';
		            formObj2.g7_edi_no.readOnly=true;
		            formObj2.imp_mf_smry_rpt_no.value='';
		            formObj2.imp_mf_smry_rpt_no.readOnly=true;
		            formObj2.b13a_xpt_no.value='';
		            formObj2.b13a_xpt_no.readOnly=true;
		            formObj2.imp_cgo_ctrl_no.value='';
		            formObj2.imp_cgo_ctrl_no.readOnly=true;
		            imp_ndr_ref_id.SetSelectCode( -1, true);
		            imp_ndr_ref_id.SetEnable(0);
		            break;
		        case "G7": 
		        	formObj2.caed_no.value='';
		        	formObj2.caed_no.readOnly=true;
		            formObj2.g7_edi_no.readOnly=false;
		            formObj2.imp_mf_smry_rpt_no.value='';
		            formObj2.imp_mf_smry_rpt_no.readOnly=true;
		            formObj2.b13a_xpt_no.value='';
		            formObj2.b13a_xpt_no.readOnly=true;
		            formObj2.imp_cgo_ctrl_no.value='';
		            formObj2.imp_cgo_ctrl_no.readOnly=true;
		            imp_ndr_ref_id.SetSelectCode( -1, true);
		            imp_ndr_ref_id.SetEnable(0);
		            break;
		        case "SM":
		        	formObj2.caed_no.value='';
		        	formObj2.caed_no.readOnly=true;
		            formObj2.g7_edi_no.value='';
		            formObj2.g7_edi_no.readOnly=true;
		            formObj2.imp_mf_smry_rpt_no.readOnly=false;
		            formObj2.b13a_xpt_no.value='';
		            formObj2.b13a_xpt_no.readOnly=true;
		            formObj2.imp_cgo_ctrl_no.value='';
		            formObj2.imp_cgo_ctrl_no.readOnly=true;
		            imp_ndr_ref_id.SetSelectCode( -1, true);
		            imp_ndr_ref_id.SetEnable(0);
		            break;
		        case "EX":
		        	formObj2.caed_no.value='';
		        	formObj2.caed_no.readOnly=true;
		            formObj2.g7_edi_no.value='';
		            formObj2.g7_edi_no.readOnly=true;
		            formObj2.imp_mf_smry_rpt_no.value='';
		            formObj2.imp_mf_smry_rpt_no.readOnly=true;
		            formObj2.b13a_xpt_no.readOnly=false;
		            formObj2.imp_cgo_ctrl_no.value='';
		            formObj2.imp_cgo_ctrl_no.readOnly=true;
		            imp_ndr_ref_id.SetSelectCode( -1, true);
		            imp_ndr_ref_id.SetEnable(0);
		            break;
		        case "IT":
		        	formObj2.caed_no.value='';
		        	formObj2.caed_no.readOnly=true;
		            formObj2.g7_edi_no.value='';
		            formObj2.g7_edi_no.readOnly=true;
		            formObj2.imp_mf_smry_rpt_no.value='';
		            formObj2.imp_mf_smry_rpt_no.readOnly=true;
		            formObj2.b13a_xpt_no.value='';
		            formObj2.b13a_xpt_no.readOnly=true;
		            formObj2.imp_cgo_ctrl_no.readOnly=false;
		            imp_ndr_ref_id.SetSelectCode( -1, true);
		            imp_ndr_ref_id.SetEnable(0);
		            break;
		        case "ND":
		        	formObj2.caed_no.value='';
		        	formObj2.caed_no.readOnly=true;
		            formObj2.g7_edi_no.value='';
		            formObj2.g7_edi_no.readOnly=true;
		            formObj2.imp_mf_smry_rpt_no.value='';
		            formObj2.imp_mf_smry_rpt_no.readOnly=true;
		            formObj2.b13a_xpt_no.value='';
		            formObj2.b13a_xpt_no.readOnly=true;
		            formObj2.imp_cgo_ctrl_no.value=''
		            formObj2.imp_cgo_ctrl_no.readOnly=true;
		            imp_ndr_ref_id.SetEnable(1);
		        	break;
    		}
    	}
    	if(obj.name=='exp_caed_tp_cd'&& obj.checked==false){ 
    		var obj2=document.getElementsByName("exp_caed_tp_cd");
    		var chkcnt=0
    		for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){		            
		        	if(obj2[i].checked == true){
		            	chkcnt++ ;
		            }
		        }
		    }
    		if(chkcnt==0){
    			formObj.caed_no.value='';
	        	formObj.caed_no.readOnly=true;
	            formObj.g7_edi_no.value='';
	            formObj.g7_edi_no.readOnly=true;
	            formObj.exp_mf_smry_rpt_no.value='';
	            formObj.exp_mf_smry_rpt_no.readOnly=true;
	            formObj.b13a_xpt_no.value='';
	            formObj.b13a_xpt_no.readOnly=true;
	            formObj.exp_cgo_ctrl_no.value=''
	            formObj.exp_cgo_ctrl_no.readOnly=true;
	            exp_ndr_ref_id.SetSelectCode( -1, true);
	            exp_ndr_ref_id.SetEnable(0);
	            formObj.exp_ndr_ref_ctnt.value='';
	            formObj.exp_ndr_ref_ctnt.readOnly=true;
    		}
    	}else if(obj.name=='imp_caed_tp_cd'&& obj.checked==false){ 
    		var obj2=document.getElementsByName("imp_caed_tp_cd"); 
    		var chkcnt=0
    		for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){		            
		        	if(obj2[i].checked == true){
		            	chkcnt++ ;
		            }
		        }
		    }
    		if(chkcnt==0){
    			formObj2.caed_no.value='';
	        	formObj2.caed_no.readOnly=true;
	            formObj2.g7_edi_no.value='';
	            formObj2.g7_edi_no.readOnly=true;
	            formObj2.imp_mf_smry_rpt_no.value='';
	            formObj2.imp_mf_smry_rpt_no.readOnly=true;
	            formObj2.b13a_xpt_no.value='';
	            formObj2.b13a_xpt_no.readOnly=true;
	            formObj2.imp_cgo_ctrl_no.value=''
	            formObj2.imp_cgo_ctrl_no.readOnly=true;
	            imp_ndr_ref_id.SetSelectCode( -1, true);
	            imp_ndr_ref_id.SetEnable(1);
	            formObj2.imp_ndr_ref_ctnt.value='';
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
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='MX'){
						sendForm("ESM_BKG_0361_07.do","O","MX");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='CO'){
						sendForm("ESM_BKG_0361_07.do","O","CO");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='EC'){
						sendForm("ESM_BKG_0361_07.do","O","EC");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='PE'){
						sendForm("ESM_BKG_0361_07.do","O","PE");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='AR'){
						sendForm("ESM_BKG_0361_08.do","O","AR");
					}
	    		}else{
					formObj.exp_cnt_cd.value="CA";
					document.form4.tabclosechk.value="";
					saveMsgFlg=true;
	    		}
			} else {
				formObj.exp_cnt_cd.value="CA";
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
	    			formObj.imp_cnt_cd.value="CA";
					document.form4.tabclosechk.value="";
					saveMsgFlg=true;
	    		}
			} else {
				formObj.imp_cnt_cd.value="CA";
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
    
    function exp_ndr_ref_id_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
    	if(comboObj.GetSelectCode()==""){
    		comboObj.SetEnable(0);
            formObj.exp_ndr_ref_ctnt.value='';
            formObj.exp_ndr_ref_ctnt.readOnly=false;
    	}else{
    		comboObj.SetEnable(1);
            formObj.exp_ndr_ref_ctnt.value='';
            formObj.exp_ndr_ref_ctnt.readOnly=true;
    	}
    } 
    
//    function copyToDesc(chkObj){
//    	var formObj = document.form;
//    	
//    	if (!opener) opener=window.dialogArguments;
//    	if(!opener) opener=parent;
//    	
//    	if(chkObj.checked==true){
//    		if(!validateForm("",formObj)){
//    			chkObj.checked=false;
//    			return;
//    		}
//        	
//    		var obj = formObj.exp_caed_tp_cd;		//CE, G7, SM, EX, IT, ND
//    		for(var i=0; i<obj.length; i++){
//    			if(obj[i].checked){
//    				switch(obj[i].value) {
//    				case "CE":
//						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
//																"\n"+formObj.caed_pfx_ctnt.value+" "+formObj.caed_no.value+"\n";
//						opener.document.form.dirty_flag.value="Y";
//
//					break;
//					case "G7":
//						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
//																"\n"+formObj.g7_edi__pfx_ctnt.value+" "+formObj.g7_edi_no.value+"\n";
//						opener.document.form.dirty_flag.value="Y";
//					break;
//					case "SM":
//						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
//																"\n"+formObj.mf_smry_rpt_pfx_ctnt.value+" "+formObj.exp_mf_smry_rpt_no.value+"\n";
//						opener.document.form.dirty_flag.value="Y";
//					break;
//					case "EX":
//						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
//																"\n"+formObj.b13a_xpt_pfx_ctnt.value+" "+formObj.b13a_xpt_no.value+"\n";
//						opener.document.form.dirty_flag.value="Y";
//					break;
//					case "IT":
//						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
//																"\n"+formObj.cgo_ctrl_pfx_ctnt.value+" "+formObj.exp_cgo_ctrl_no.value+"\n";
//						opener.document.form.dirty_flag.value="Y";
//					break;
//					case "ND":
//						if(exp_ndr_ref_id.GetSelectText() != ""){
//    						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
//                            "\n"+formObj.ndr_ref_pfx_ctnt.value + " " + exp_ndr_ref_id.GetSelectText()+"\n";
//						}else{
//    						opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
//							"\n"+formObj.exp_ndr_ref_ctnt.value+"\n";
//						}
//						opener.document.form.modify_flag.value="Y";
//					break;
//    				}
//    			}
//    		}
//    	}
//    }      
