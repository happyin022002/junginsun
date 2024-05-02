/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0117.jsp
*@FileTitle  : Status Summary - Aging
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
/****************************************************************************************
  Event code : 	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : 	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TPB_0117 : business script for ESD_TPB_0117
     */
    /* Global Variables */
  //var calPop = new calendarPopupGrid();
  var curTab=1;
  var beforetab=0;
  var sheetObjects=new Array();
  var sheetCnt=0;
  var currentRetrieveSheet="S";
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
  		   //Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		//document.form.s_ofc_cd_for_rhq.value = "SELCOL";
  		document.form.s_ofc_cd_for_rhq.value=OfficeCodeMgr.getOfficeCodeList('000004', 'TPB')[0];
  		document.form.s_office_level.value="H";
  		getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2', new Array("s_ofc_cd_for_rhq","s_office_level"));
  		document.form.s_if_rhq_cd.onchange=if_rhq_cd_OnChange;
  		document.form.s_if_ctrl_cd.onchange=if_ctrl_cd_OnChange;
  	}
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8=true;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  	            with(sheetObj){
  					  var cnt=0;
			          var HeadTitle1="RHQ|Office|Initial Confirmation|Initial Confirmation|Cancellation Invoice|Cancellation Invoice|Invoice Issued|Invoice Issued|Balance remained (AR I/F)|Balance remained (AR I/F)|Adjustment Requested|Adjustment Requested|Adjustment Rejected|Adjustment Rejected|Collection Agency & Legal Action|Collection Agency & Legal Action|Total|Total";
			          var HeadTitle2="RHQ|Office|Count|Amount|Count|Amount|Count|Amount|Count|Amount|Count|Amount|Count|Amount|Count|Amount|Count|Amount";
			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:1 } );
			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"if_rhq_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"if_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_a",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_a",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_b",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_b",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_c",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_c",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_d",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_d",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_e",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_e",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_f",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_f",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_g",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_g",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_tot",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_tot",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
			          InitColumns(cols);
			          SetEditable(0);
			          SetSheetHeight(430);
			          
                    }
  				break;
  			case 2:	  //IBSheet1 init
  			    with(sheetObj){
	  		        var cnt=0;
	  		        var HeadTitle1="RHQ|Office|TES|TES|TRS|TRS|MNR|MNR|Total|Total";
	  		        var HeadTitle2="RHQ|Office|Count|Amount|Count|Amount|Count|Amount|Count|Amount";
	  		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:1 } );
	  		        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	  		        var headers = [ { Text:HeadTitle1, Align:"Center"},
	  		                  { Text:HeadTitle2, Align:"Center"} ];
	  		        InitHeaders(headers, info);
	  		        var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"if_rhq_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	  		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"if_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_a",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_a",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_b",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_b",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_c",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_c",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_tot",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_tot",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
	  		      InitColumns(cols);
	  		      SetEditable(0);
	  		      SetSheetHeight(430);
	            }
  				break;
  			case 3:	  //IBSheet1 init
  			    with(sheetObj){
  		        var cnt=0;
  		     	var HeadTitle1="RHQ|Office|Within 30days|Within 30days|31-60 days|31-60 days|61-90 days|61-90 days|91-180 days|91-180 days|Over 180 days|Over 180 days|Total|Total";
  		     	var HeadTitle2="RHQ|Office|Count|Amount|Count|Amount|Count|Amount|Count|Amount|Count|Amount|Count|Amount";
  		     	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:1 } );
  		     	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
  		     	var headers = [ { Text:HeadTitle1, Align:"Center"},
  		                  { Text:HeadTitle2, Align:"Center"} ];
  		     	InitHeaders(headers, info);
  		     	var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"if_rhq_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"if_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_a",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_a",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_b",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_b",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_c",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_c",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_d",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_d",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_e",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_e",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_tot",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_tot",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
  		       
  		     	InitColumns(cols);
  		     	SetEditable(0);
  		     	SetSheetHeight(430);
  			}
  				break;
  			case 4:	  //IBSheet1 init
  			    with(sheetObj){
  		        var cnt=0;
  		        var HeadTitle1="RHQ|Office|Open|Open|Closed|Closed|Closed|Closed|Closed|Closed|Closed|Closed|Closed|Closed";
  		        var HeadTitle2="RHQ|Office|Count|Amount|AR I/F|AR I/F|Write-off|Write-off|ROC|ROC|Process Close|Process Close|Closed Total|Closed Total";
  		        var HeadTitle3="RHQ|Office|Count|Amount|Count|Amount|Count|Amount|Count|Amount|Count|Amount|Count|Amount";
  		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:1 } );
  		        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
  		        var headers = [ { Text:HeadTitle1, Align:"Center"},
  		                  { Text:HeadTitle2, Align:"Center"},
  		                  { Text:HeadTitle3, Align:"Center"} ];
  		        InitHeaders(headers, info);
  		        var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"if_rhq_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"if_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_a",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_a",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_b",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_b",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_c",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_c",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_d",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_d",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_e",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_e",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_tot",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_tot",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
  		        InitColumns(cols);
  		        SetEditable(0);
  		        SetSheetHeight(430);
	            }
  				break;
  		}
  	}
  	/* Event handler defined process to button click event */
  	document.onclick=processButtonClick;
  	/* Event handler is branch processing by name of button */
  	function processButtonClick(){
  		 /***** Assignment sheet in case of over 2 by tab ****/
  		 var sheetObject=sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject=document.form;
  		 if(curTab == 2)
  			formObject=document.form2;
  		try {
  			var srcName=ComGetEvent("name");
  			switch(srcName) {
  				case "bttn_add":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "bttn_cancel":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "bttn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "bttn_remove":
  					break;
  				case "bttn_preview":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_downexcel": 
  				    var arr=new Array();
  				    arr["S"]=0;
  				    arr["E"]=1;
  				    arr["A"]=2;
  				    arr["C"]=3;
     				doActionIBSheet(sheetObjects[arr[currentRetrieveSheet]],formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  				    var s_status=document.all.s_status.value; 
  				    resetResultAll(s_status);
  				    var arr=new Array();
  				    arr["S"]=0;
  				    arr["E"]=1;
  				    arr["A"]=2;
  				    arr["C"]=3;
     					doActionIBSheet(sheetObjects[arr[s_status]],formObject,IBSEARCH);
  					break;
  				case "btn_new":
  					formObject.reset();
  					resetResultAll("S");
  					break;
  				case "btn_3rdParty":
  					get3rdPartyToSearch( formObject.s_vndr_cust_div_cd.value );
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg('COM12111'));
  			} else {
  				//ComShowMessage(e.message);
  			}
  		}
  	}
  	/* Processing Sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg(false);
  		switch(sAction) {
  		   case IBSEARCH:	  //Retrieve
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=SEARCH;
   				sheetObj.DoSearch("ESD_TPB_0117GS.do", tpbFrmQryStr(formObj) );
  				break;
  			case IBSAVE:		//Save
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=MULTI;
  				sheetObj.DoSave("ESD_TPB_0117GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBINSERT:	  //Insert
  				var Row=sheetObj.DataInsert();
  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //Excel download
   				if(sheetObj.RowCount() < 1){//no data
   					ComShowCodeMessage("COM132501");
   				}else{
   					sheetObj.Down2Excel(TPBDown2ExcelOptions);
   				}
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
     * handling process after ending sheet1 retrieve
     */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		if(errMsg!=0){
  			ComShowMessage(errMsg);
  		}
  		currentRetrieveSheet=document.all.s_status.value;
  	}
  	/**
     * handling process after ending sheet2 retrieve
     */
  	function sheet2_OnSearchEnd(sheetObj,errMsg){
  		if(errMsg!=0){
  			ComShowMessage(errMsg);
  		}
  		currentRetrieveSheet=document.all.s_status.value;
  	}
  	/**
     * handling process after ending sheet3 retrieve
     */
  	function sheet3_OnSearchEnd(sheetObj,errMsg){
  		if(errMsg!=0){
  			ComShowMessage(errMsg);
  		}
  		currentRetrieveSheet=document.all.s_status.value;
  	}
  	/**
     * handling process after ending sheet4 retrieve
     */
  	function sheet4_OnSearchEnd(sheetObj,errMsg){
  		if(errMsg!=0){
  			ComShowMessage(errMsg);
  		}
  		currentRetrieveSheet=document.all.s_status.value;
  	}
  	function if_rhq_cd_OnChange(){
  		var f=document.form;
  		if(f.s_office_level.value == "H"){ // HO
  			ComClearCombo(f.s_if_ctrl_cd);
  			getTPBGenCombo('s_if_ctrl_cd','searchControlOfficeList','F','','2', new Array("s_if_rhq_cd","s_office_level"));
  			ComClearCombo(f.s_if_ofc_cd);
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("",""));
  		} else if(f.s_office_level.value == "R"){ //RHQ
  			getTPBGenCombo('s_if_ctrl_cd','searchControlOfficeList','F','','2', new Array("s_if_rhq_cd","s_office_level"));
  		}else if(f.s_office_level.value == "T" || f.s_office_level.value == ""){ //General Office
  			ComClearCombo(f.s_if_ofc_cd);
  			ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
  		}
  	}
  	function if_ctrl_cd_OnChange(){
  		var f=document.form;
  		if(f.s_office_level.value == "H"){ // HO
  			ComClearCombo(f.s_if_ofc_cd);
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("s_if_ctrl_cd","s_office_level"));
  		} else if(f.s_office_level.value == "R"){ //RHQ
  			ComClearCombo(f.s_if_ofc_cd);
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("s_if_ctrl_cd","s_office_level"));
  		} else if(f.s_office_level.value == "C"){ //CTRL
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("s_if_ctrl_cd","s_office_level"));
  		}else if(f.s_office_level.value == "T" || f.s_office_level.value == ""){ //General Office
  			ComClearCombo(f.s_if_ofc_cd);
  			ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
  		}
  	}
  	function changeTitle(val){
  	}
  	function resetResultAll(s_status){
  	   sheetObjects[0].RemoveAll();
  	   sheetObjects[1].RemoveAll();
  	   sheetObjects[2].RemoveAll();
  	   sheetObjects[3].RemoveAll();
  	   document.all.tr_title1.style.display="none";
  	   document.all.tr_title2.style.display="none";
  	   document.all.tr_title3.style.display="none";
  	   document.all.tr_title4.style.display="none";
  	   document.all.tr_sheet1.style.display="none";
  	   document.all.tr_sheet2.style.display="none";
  	   document.all.tr_sheet3.style.display="none";
  	   document.all.tr_sheet4.style.display="none";
  	   if ( s_status=="S"){
      	   document.all.tr_title1.style.display="";
      	   document.all.tr_sheet1.style.display="";
  	   } else if ( s_status=="E"){
      	   document.all.tr_title2.style.display="";
      	   document.all.tr_sheet2.style.display="";
  	   } else if ( s_status=="A"){
      	   document.all.tr_title3.style.display="";
      	   document.all.tr_sheet3.style.display="";
  	   } else if ( s_status=="C"){
      	   document.all.tr_title4.style.display="";
      	   document.all.tr_sheet4.style.display="";
         }
  	}
	/* Finishing work */
