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
    		ComBtnDisable("btn_rowAdd");
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
        	var ctxName="/opus";
        	if(document.form4.savechk.value==''){
	        	if(document.form3.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
					if (document.form3.pol_cd.value.substring(0,2)=='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
					}else if (document.form3.pol_cd.value.substring(0,2)=='KR'){
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
						sendForm("ESM_BKG_0361_03.do","I","BR");
					}
				}else{
					sendForm("ESM_BKG_0361_03.do","I","BR");
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
		   					}else if (formObj.pol_cd.value.substring(0,2)=='KR'){
								sendForm("ESM_BKG_0361_02.do","O","KR");
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
		   					}else{
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
   					}else{
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
 					var HeadTitle="|||Export License Number";

 					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

 				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
 				      InitHeaders(headers, info);

 				      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
 				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
 				             {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"Check",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:0, Width:145,  Align:"Left",    ColMerge:0,   SaveName:"xpt_lic_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , EditLen:50 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:1 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
 				      
 				      
 				      InitColumns(cols);
 				      SetEditable(1);
 				      SetSheetHeight(200);
 				}
 			break;
 		}
 	}
  // handling of Sheet 
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		switch(sAction) {
 			case IBSEARCH:      
 		 		ComOpenWait(true);
// 				if(validateForm(sheetObj, formObj, sAction)) {
 					formObj.f_cmd.value=SEARCH;
  					sheetObj.DoSearch("ESM_BKG_0361_08GS.do", FormQueryString(formObj) );
// 				}
		 		ComOpenWait(false);
 			break;
 			case IBINSERT:
 				if(validateForm(sheetObj,formObj,sAction)){
	 				var newRow=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(newRow, "bkg_no",formObj.bkg_no.value);
					sheetObj.SetCellValue(newRow, "io_bnd_cd",formObj.io_bnd_cd.value);
					sheetObj.SetCellValue(newRow, "xpt_imp_seq","0");	//신규
					sheetObj.SetCellValue(newRow, "cnt_cd","AR");
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
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_08GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
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
	 						var rtnData = sheetObj.GetSaveData("ESM_BKG_0361_08GS.do", FormQueryString(formObj)+"&"+SaveStr ,"");
							sheetObj.LoadSaveData(rtnData); 	
					 		ComOpenWait(false);
						} 
 					}
 				}
 			break;
 			case IBDELETE:     
	 			var rCnt=sheetObj.RowCount()+1;
 			    var chkCnt=0
				for(var i=1;i<rCnt;i++){
					if(sheetObj.GetCellValue(i, "Check") == 1){
						chkCnt++	
					}
				}
 			    
 			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
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
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBINSERT:
				var totalCnt = sheetObj.RowCount() - sheetObj.RowCount("D");
				if(totalCnt==15){
					setTab1();
					ComShowCodeMessage("BKG00651","15 ROWS");
					return false;
				}
			break;
    	}
    	document.form4.savechk.value="";
		return true;
    }

 //  initializing sheet data
    function initSheetData(sheetObj) {
    	sheetObj.RemoveAll();
    	sheetObj.DataInsert(-1);
    }
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	document.form3.get_io_bnd_cd.value="O";
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


    function initControl() {    	
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
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='KR'){
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
					}
				}else{
					formObj.exp_cnt_cd.value='AR';
	   				document.form4.tabclosechk.value="";
	   				saveMsgFlg=true;
				}
			} else {
				formObj.exp_cnt_cd.value='AR';
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
