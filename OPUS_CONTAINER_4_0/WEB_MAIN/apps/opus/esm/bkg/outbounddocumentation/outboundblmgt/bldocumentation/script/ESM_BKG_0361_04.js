/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0361_04.js
*@FileTitle  :Export / Import Information (India)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=0; 
var sheetObjects=new Array();
var sheetCnt=0;
var saveMsgFlg=true;
var isInquiry=false;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
    	var formObject=document.form;
    	var formObject2=document.form2;
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	try {
    		var srcName=ComGetEvent("name");
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
    			ComShowMessage(e);
    		}
    	}
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen
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
        initControl();
        if(document.form3.get_io_bnd_cd.value != 'I') {
        	beforetab=0; 
        	tab1.SetSelectedIndex(0);
        	document.form.exp_cnt_cd.selectedIndex=2;
        	var ctxName="/opus";
        	if( document.form4.savechk.value==''){
	        	if(document.form3.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
					if (document.form3.pol_cd.value.substring(0,2)=='KR'){
						sendForm("ESM_BKG_0361_02.do","O","KR");
					}else if (document.form3.pol_cd.value.substring(0,2)=='BR'){
						sendForm("ESM_BKG_0361_03.do","O","BR");
					}else if (document.form3.pol_cd.value.substring(0,2)=='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
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
        	if( document.form4.savechk.value==''){
	        	if(document.form3.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
	        		if (document.form3.pod_cd.value.substring(0,2)=='BR'){
						sendForm("ESM_BKG_0361_03.do","I","BR");
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
     * initializing Tab
     * setting Tab items
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
     	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
     	beforetab=nItem;
     	var ctxName="/opus";
   		var formObj=document.form3;
   		switch(nItem) {
   			case 0:	
   				document.form4.tabclosechk.value="Y";
   				doActionIBSheet(sheetObjects[1], document.form2, IBSAVE);
   				
   				if (saveMsgFlg) {
	   				document.form.go_cnt_cd.value='';
	   				if(document.form4.savechk.value==''){
		   				if(formObj.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
		   					if (formObj.pol_cd.value.substring(0,2)=='KR'){
								sendForm("ESM_BKG_0361_02.do","O" ,"KR");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","O","BR");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='US'){
		   						sendForm("ESM_BKG_0361_01.do","O","US");
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
	   				if(document.form4.savechk.value==''){
		   				if(formObj.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
		   					if (formObj.pod_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","I","BR");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='ID'){
								sendForm("ESM_BKG_0361_05.do","I","ID");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='MX'){
								sendForm("ESM_BKG_0361_07.do","I","MX");
		   					}else {
		   						doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH) ;
		   					}
		   				}else{
		   					doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH) ;
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
 		switch(sheetNo) {
 			case 1:
	 	    	with(sheetObj){
			 	      var HeadTitle="|Seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|ida_iec_no";
			
			 	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			 	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			 	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			 	      InitHeaders(headers, info);
			
			 	      var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 	                   {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			 	                   {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",       KeyField:1 },
			 	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ida_iec_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 } ];
			 	       
			 	      InitColumns(cols);
			
			 	      SetEditable(1);
			 	      SetVisible(0);
 	        	}

 			break;
 			case 2:      //sheet1 init
 			    with(sheetObj){
 					var HeadTitle="|Seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|ida_iec_no";
	
 					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
 					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 					var headers = [ { Text:HeadTitle, Align:"Center"} ];
 					InitHeaders(headers, info);
	
 					var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
 					             {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
 					             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",       KeyField:1 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ida_iec_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 } ];
	 		       
 					InitColumns(cols);
	
 					SetEditable(1);
 					SetVisible(0);
 		       }


 			break;
 		}
 	}
  // handling sheet process
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		sheetObj.SetWaitImageVisible(0);
 		//sheetObj.ShowDebugMsg = false;
 		switch(sAction) {
 			case IBSEARCH:      
 		 		ComOpenWait(true);
 				if(validateForm(sheetObj, formObj, sAction)) {
 					formObj.f_cmd.value=SEARCH;
  					sheetObj.DoSearch("ESM_BKG_0361_04GS.do", FormQueryString(formObj) );
 				}
 		 		ComOpenWait(false);
 			break;
 			case IBSAVE:    
 				if(validateForm(sheetObj,formObj,sAction)) {
 					document.form4.savechk.value="";
 					var obj="";
 					if (sheetObj.RowCount()==0){
 						initSheetData(sheetObj);
 					} 
 					if(formObj.name=="form"){
 						IBS_CopyFormToRow(formObj,sheetObj, 1, "exp_"); 
 						sheetObj.SetCellValue(1,"cnt_cd","IN");
 					}else if(formObj.name=="form2"){
 						IBS_CopyFormToRow(formObj,sheetObj, 1, "imp_"); 
 						sheetObj.SetCellValue(1,"cnt_cd","IN");
 					}
 					if(sheetObj.GetCellValue(1,0)=='I'&&sheetObj.GetCellValue(1,"ida_iec_no")==''){
 						sheetObj.RowDelete(1, 0);
 						//sheetObj.SetCellValue(1,0,'D');
 					}
 					formObj.f_cmd.value=MULTI;
 					var SaveStr = sheetObj.GetSaveString();
 					if(document.form4.tabclosechk.value=="Y"){
						if (!sheetObj.IsDataModified() && SaveStr == "") return;
						if(confirm(ComGetMsg("BKG00962"))){
					 		ComOpenWait(true);
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_04GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
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
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_04GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
							sheetObj.LoadSaveData(rtnData); 	
					 		ComOpenWait(false);
						}
 					}
 				}
 			break;
 			case IBDELETE: 				
	 			if(formObj.name=="form"){
	 				formObj.exp_ida_iec_no.value='';
	 				formObj.exp_ida_iec_cpy_desc_flg.checked=false
	 			}else{	
	 				formObj.imp_ida_iec_no.value='';
	 	    		formObj.imp_ida_iec_cpy_desc_flg.checked=false
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
    	 if (!ComChkValid(formObj)) return false;
    	 with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
    	 if(sAction=='2'&&sheetObj.GetCellValue(1,"ibflag")!='D'){
	 		if(formObj.name=="form"){
	 			objs=document.all.item("tabLayer");
		 		if(formObj.exp_ida_iec_no.value!=''&&formObj.exp_ida_iec_no.value.length<10){
		 			setTab1();
		 			ComAlertFocus(formObj.exp_ida_iec_no, ComGetMsg("COM12174","10 ~ 11"));	  
		 			return false;
		 		}
	 		}else if(formObj.name=="form2"){
	 			objs=document.all.item("tabLayer");
	 			if(formObj.imp_ida_iec_no.value!=''&&formObj.imp_ida_iec_no.value.length<10){
	 				setTab2();
	             	ComAlertFocus(formObj.imp_ida_iec_no, ComGetMsg("COM12174","10 ~ 11"));
	             	return false;
		 		}
	 		}	 		
		} 
		document.form4.savechk.value==''
		return true;
    }
    function setOptionValue(comboObj, val) {
    	for(var i=0;i<comboObj.length;i++) {
    		if(val == comboObj.options[i].value)  comboObj.options[i].selected=true;
    	}
    }
 // initialize sheet data
    function initSheetData(sheetObj) {
    	sheetObj.RemoveAll();
    	sheetObj.DataInsert(-1);
    }
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	var formObj=document.form;
    	if (sheetObj.RowCount()>0){
    		IBS_CopyRowToForm(sheetObj,formObj, 1, "exp_");     		
    	}/*else{
    		initSheetData(sheetObj);
            IBS_CopyFormToRow(formObj,sheetObj, 1, "exp_"); 
    	}*/
    	document.form3.get_io_bnd_cd.value="O";
    }
    function sheet2_OnSearchEnd(sheetObj,ErrMsg){
    	var formObj=document.form2;
	    if (sheetObj.RowCount()>0){
    		IBS_CopyRowToForm(sheetObj, formObj, 1, "imp_");     		
    	}/*else{
    		initSheetData(sheetObj);
            IBS_CopyFormToRow(formObj,sheetObj, 1, "imp_"); 
    	}*/
    	document.form3.get_io_bnd_cd.value="I";
    }
    function sheet1_OnSaveEnd(sheetObj,code , ErrMsg){
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
    
    function goCtnCd(obj){
    	var ctxName="/opus";
    	var formObj=document.form;
    	var formObj2=document.form2;
    	var formObj3=document.form3;
    	if(obj.name=='exp_cnt_cd'){
    		document.form4.tabclosechk.value="Y";
    		doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
    		
    		if (saveMsgFlg) {
	    		if(document.form4.savechk.value==''){
		    		if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='KR'){
						sendForm("ESM_BKG_0361_02.do","O","KR");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='BR'){
						sendForm("ESM_BKG_0361_03.do","O","BR");
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
					formObj.exp_cnt_cd.value="IN";
	   				document.form4.tabclosechk.value="";
	   				saveMsgFlg=true;
	    		}
			} else {
				formObj.exp_cnt_cd.value="IN";
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
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='ID'){
						sendForm("ESM_BKG_0361_05.do","I","ID");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='MX'){
						sendForm("ESM_BKG_0361_07.do","I","MX");
					}
	    		}else{
					formObj2.imp_cnt_cd.value="IN";
	   				document.form4.tabclosechk.value="";
	   				saveMsgFlg=true;
	    		}
			} else {
				formObj2.imp_cnt_cd.value="IN";
   				document.form4.tabclosechk.value="";
   				saveMsgFlg=true;
			}
    	}
    }
    function copyToDesc(chkObj){
   		if (!opener) opener=window.dialogArguments;
   		if(!opener) opener=parent;
   		
   		var formObject=document.form;
   		var formObject2=document.form2;
   		var sheetObject1=sheetObjects[0];
   		var sheetObject2=sheetObjects[1];
   		var sAction = IBSAVE;
   		
   		
		if(chkObj.name=="exp_ida_iec_cpy_desc_flg"&&chkObj.checked==true){
			//check logic
	   		if(!validateForm(sheetObject1,formObject,sAction)) return;
			opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
			"\n IEC "+document.form.exp_ida_iec_no.value;	
		}
		if(chkObj.name=="imp_ida_iec_cpy_desc_flg"&&chkObj.checked==true){
			//check logic
	   		if(!validateForm(sheetObject2,formObject2,sAction)) return;
			opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
			"\n IEC "+document.form2.imp_ida_iec_no.value;	
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
