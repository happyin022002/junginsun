/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : something.js
*@FileTitle  : Some Title 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

// Global Variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var isSearch=false;
//Event handler processing by button click event
document.onclick=processButtonClick;

//Event handler processing by button name
	function processButtonClick(){
		 /***** Setting variable over two sheet at tab *****/
		 var sheetObject=sheetObjects[0];
		 var sheetObject1=sheetObjects[1];
		 /*******************************************************/
		 var formObject=document.form;
		 try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet1(sheetObject,formObject,IBSEARCH);
					doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_new":
					sheetObject.RemoveAll();
					sheetObject1.RemoveAll();
					formObject.grp_nm.value='';
					formObject.cs_grp_id.value='';
					formObject.cs_nm.value='';
					formObject.cs_cd.value='';
					formObject.cs_tp_id.value='';
					formObject.co_tp_id.value='';
					formObject.sc_no.value='';
					break;
				case "btn_downexcel":
				    if(beforetab == 0){
				    	if(sheetObject.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
//parameter changed[check again]CLT				    	
							sheetObject.Down2Excel();
						}
				    }
				    else if(beforetab == 1){
				    	if(sheetObject1.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
//parameter changed[check again]CLT
					    	sheetObject1.Down2Excel();
						}
				    }
				    else{
						if(sheetObject.RowCount() < 1 && sheetObject1.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
//parameter changed[check again]CLT							
							sheetObject.Down2Excel();
//parameter changed[check again]CLT
							sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
						}
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
		    //changing initializing function name
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//adding last function name
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
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
					var HeadTitle="SEQ|EDI Customer\nGroup Code|EDI Customer\nGroup Name|Customer\nTP ID|Company\nTP ID|Customer\nCode|Customer Name|S/C No.|S/C Effective\nFrom|S/C Effective\nTo";
					var prefix="sheet1_";

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rownum",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_grp_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_trd_prnr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"prov_trd_prnr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sc_eff_st_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sc_eff_end_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
		       
					InitColumns(cols);

					SetEditable(1);
//		            SetSheetHeight(260);
					resizeSheet(); 
		      	}
			    break;
			case 2:     //sheet2 init
			    with(sheetObj){
					var HeadTitle="Seq.|EDI Customer\nGroup Code|EDI Customer\nGroup Name|Customer\nTP ID|Company\nTP ID|Stadard EDI\nStatus Code|Status\nDescription| Sending Flag|Origin|Destination|Vessel|Event\nSequence|Interval\nHour|CNTR\nSending\nType|Customer\nEDI Status Code";
					var prefix="sheet2_";

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rownum",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_grp_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_trd_prnr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"prov_trd_prnr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_stnd_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix+"edi_sts_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_snd_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_org_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_dest_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_vsl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_evnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"EDI_SND_ITVAL_HRMNT", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"EDI_CNTR_SND_TP_CD",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_edi_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
		       
					InitColumns(cols);

					SetEditable(1);
		            var ComboText1="America|Asia|Europe|America+Asia|America+Europe|Asia+Europe|All";
		            SetSheetHeight(450);
				}
			    break;
		}
	}
	
	// handling process of Sheet
	function doActionIBSheet1(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		isSearch=true;
		switch(sAction) {
			case IBSEARCH:      //retrieving
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH01;
//method change[check again]CLT
					sheetObj.DoSearch("ESD_SCE_0032GS.do", FormQueryString(formObj)  + "&" + ComGetPrefixParam("sheet1_") );
				}else{
					isSearch=false;
				}
				break;
		}
	}
	
	//handling process of sheet
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		   case IBSEARCH:      //search
              if(isSearch){
            	  if(validateForm(sheetObj,formObj,sAction)){
            		  formObj.f_cmd.value=SEARCH02;
//method change[check again]CLT
    			      sheetObj.DoSearch("ESD_SCE_0032GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") );
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
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
	
	/**
	 * initializing Tab
	 * setting Tab items
	 */
	function initTab(tabObj , tabNo) {
		 switch(tabNo) {
			 case 1:
				with (tabObj) {
					var cnt=0 ;
					InsertItem( " Customer " , "");
					InsertItem( "EDI Status" , "");
				}
			 break;
		 }
	}
	
	/**
     * Event when clicking Tab
     * activating selected tab items
     */
	function tab1_OnChange(tabObj, nItem)
	{
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
		beforetab=nItem;
	}
	
	/**
     * handling process for input validation
     */
	function validateForm(sheetObj, formObj, sAction){
		var result=false ;
        if(
              !ComIsEmpty(formObj.cs_grp_id) ||
              !ComIsEmpty(formObj.cs_tp_id) ||
              !ComIsEmpty(formObj.co_tp_id) ||
              !ComIsEmpty(formObj.sc_no) ||
              !ComIsEmpty(formObj.cs_cd) 
        	){
            	result=true;      
        }else{
            ComShowMessage(ComGetMsg('COM12113',"EDI Customer Group"));
            result=false;
        }
        return result;
	}
	
	function onValueChange(selectName, formObj){
    	switch(selectName){
    	    case 'cs_grp_id' :
    	       formObj.grp_nm.value=formObj.cs_grp_id.value;
    	    break;
    	    case 'cs_tp_id' :
    	    break;
    	    case 'co_tp_id' :
    	    break;
    	    case 'cs_cd' :
    	       formObj.cs_nm.value=formObj.cs_cd.value;
    	    break;
    	    case 'sc_no' :
    	    break;
    	}
	}
	
	function onObjectFocusout(fromname, toname, fromObj){
		if(fromname == "grp_nm"){
			document.form.cs_grp_id.value=document.form.grp_nm.value;
			return;
		}
		if(fromname == "cs_nm"){
			document.form.cs_cd.value=document.form.cs_nm.value;
			return;
		}
    	document.getElementById(fromname).value=toUpperCase(document.getElementById(fromname).value);
    }
	
    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //lower character to upper character
        }  
        return str;      
    }
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    } 