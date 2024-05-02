/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0813.js
*@FileTitle : Select Staff
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
			  [Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
			  [Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /* Global Variables */
	  //var calPop = new calendarPopupGrid();
	  var curTab=1;
	  var beforetab=0;
	  var sheetObjects=new Array();
	  var sheetCnt=0;
    /**
	 * Setting IBTab Object Initial.
	 * Tab ID is tab1,tab2,...
	 * InitTab() function is called before the loadPage() function call from setupPage() function.
	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
				InsertItem( "Dry Index" , "");
				InsertItem( "Tanker Index" , "");
				InsertItem( "Time Charter" , "");
				InsertItem( "Bunker Price" , "");
				InsertItem( "Ship Price" , "");
				InsertItem( "FFA Index" , "");
  			}
  		}catch(e){
  			ComShowMessage(e.message);
  		}
  	}
  	/**
  	 * onChange event of tab1
  	 * Implementing defined function from IBSheetConfig.js
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	/**
  	 * Showing tab contents in case of clicking IBTab Object
  	 * ID of Grouped each tab DIV TAG defined "tabLayer"
  	 */
  	function ChangeTab(tabObj,nItem){
  		tabObj.SetBackColor("#FFFFFF");
  		var objs=document.all.item("tabLayer");
  		objs[beforetab].style.display="none";
  		objs[nItem].style.display="Inline";
  		//--------------- Notice --------------------------//
  		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
  		//Not a click button in case of zIndex under 2
  		objs[beforetab].style.zIndex=0;
  		objs[nItem].style.zIndex=9;
  		//------------------------------------------------------//
  		beforetab=nItem;
  	}
  	/**
  	 * Register as an IBSheet Object array
  	 * This is called from comSheetObject(id)
  	 * Process can add in case of future necessity to process other items
  	 * Array defined at the top of the source
  	 */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++]=sheet_obj;
  	}
  	/**
  	 * Initializing sheet
  	 * To implement onLoad event of body tag
  	 * Add functionality to after loading screen.
  	 */
  	function loadPage() {
  		for(i=0;i<sheetObjects.length;i++){
  		   //Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		getTPBGenCombo('s_if_rhq_cd','searchRHQList','F','','1');
  		document.form.s_if_rhq_cd.onchange=if_rhq_cd_OnChange;
  	}
  	/**
  	 * Initializing sheet. Defining header
  	 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
  	 * Composition a initial module in case of multi sheet
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8=true;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  			    with(sheetObj){
					var cnt=0;
					var HeadTitle="||RHQ|TPB Office|Office";
					
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0, Wrap:1 },
					             {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"select",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:124,  Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
					 {Type:"Text",      Hidden:0,  Width:124,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
					 {Type:"Text",      Hidden:0,  Width:124,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 } ];
					   
					InitColumns(cols);
					SetSheetHeight(250);
					SetEditable(1);
  		            }
  				break;
  		}
  	}
  	/* Event handler defined process to button click event */
  	document.onclick=processButtonClick;
  	/* Event handler is branch processing by name of button */
  	function processButtonClick(){
  		 /***** Assignment sheet in case of over 2 by tab****/
  		 var sheetObject=sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject=document.form;
  		 if(curTab == 2)
  			formObject=document.form2;
  		try {
  			var srcName=ComGetEvent("name");
  			switch(srcName) {
  				case "btn_ok": /// on ok button click
  				    var sRow="";
                      for(var i=1; i<=sheetObject.RowCount(); i++){
                    	  if ( sheetObject.GetCellValue(i, "select")=="1" ){
                              sRow=i.toString();
                              break;
                          }
                      }
      				var rtnValue="";
      				if(sRow == ""){
      					ComShowCodeMessage("COM12113","One(TPB Office)");
      					return;
      				}else{
      					rtnValue=sheetObject.GetCellValue(sRow, "n3pty_ofc_cd");
      				}
              		//ComPopUpReturnValue(rtnValue);
      				if(!opener) opener = parent;      				                            	 
      				opener.callback0813(rtnValue);
              		ComClosePopup(); 
  					break;
  				case "btn_downexcel":
  					if(sheetObj.RowCount() < 1){//no data
  						ComShowCodeMessage("COM132501");
  					}else{
  						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					}
  					break;
  				case "bttn_print":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_close":
  				    ComPopUpReturnValue(null);
  				    ComClosePopup(); 
  				    break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage("COM12111");
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
  	/* Processing Sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg(false);
  		switch(sAction) {
  		   case IBSEARCH:	  //조회
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=SEARCH;
  				sheetObj.DoSearch("ESD_TPB_0813GS.do", tpbFrmQryStr(formObj) );
  				break;
  		   case IBDOWNEXCEL:  //엑셀내려받기
  			   	sheetObj.Down2Excel(TPBDown2ExcelOptions);
				break;
  		}
  	}
  	/**
  	 * Checking validation of input value
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  		   if(!ComChkValid(formObj)) return false;
  		}
  		return true;
  	}
  	/**
  	 * Processing function in case of error to result of retrieve
  	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		//if(errMsg!=null){
  			//ComShowMessage(errMsg);
  		//}
  	}
  	/**
  	 * Processing function in case of error to result of retrieve
  	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowCodeMessage("COM12149","Data");
  		}
  	}
  	function sheet1_OnPopupClick(sheetObj,Row,Col){
  		var url="ESD_TPB_0914.do?f_cmd="+SEARCH+"&rhq_cd="+sheetObj.GetCellValue(Row, "rhq_cd");
  		var rtnValue =  ComOpenWindow(url,  window,  "scroll:no;status:no;help:no;dialogWidth:300px;dialogHeight:140px" , true);
  		if(rtnValue != undefined && rtnValue != ""){
  			sheetObj.SetCellValue(Row, sheetObj.ColSaveName(Col),rtnValue);
  		}		
  	}
  	function if_rhq_cd_OnChange(){
  		var f=document.form;
//  		if(f.s_office_level.value == "H" || f.s_office_level.value == "R"){ //Head Office, RHQ
  			getTPBGenCombo('s_if_ofc_cd','searchOfficeList','F','','1', new Array("s_if_rhq_cd"));
//  		}else if(f.s_office_level.value == "G" || f.s_office_level.value == ""){ //General Office
//  			ComClearCombo(f.s_if_ofc_cd);
//  			ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
//  		}
  	}
  	/* Finishing work */