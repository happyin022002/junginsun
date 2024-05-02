/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0801.js
*@FileTitle  : TPB Duplication Check
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
	
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;
  
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
					//no support[check again]CLT 				TabBackColor(0)="146,174,230";
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
  //no support[check again]CLT 		tabObj.TabBackColor(nItem)="146,174,230";
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
  		   //khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
  		    
  		      var HeadTitle="||Office|TPB No.|Source|EQ No.|BKG No.|Billing Case|Currency|Amount";

  		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

  		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
  		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
  		      InitHeaders(headers, info);

  		      var cols = [ {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"status",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"status_detail",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_sub_sys_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"if_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"if_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
  		       
  		      InitColumns(cols);
  		      SetSheetHeight(250);
  		      SetEditable(0);
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
  				case "btn_save": /// on save button click
//              		window.returnValue = true;
  					returnButtonSheetData();
              		ComClosePopup();
  					break;
  				case "btn_close":
  				    window.returnValue = false;
  				    ComClosePopup(); 
  				    break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg('COM12111'));
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
  	/*
  	* returning selected sheet value to parent screen <br>
  	*/
  	function returnButtonSheetData() {
  		var obj=new Object();
  		var Row=0;
  		
  		obj.duplicationFlag = true;
  		parent.saveTPBMenual(obj);
//  		ComPopUpReturnValue(obj);
  		 
  	}
  	/* Processing Sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg(false);
  		switch(sAction) {
  		   case IBSEARCH:	  //Retrieve
  				formObj.f_cmd.value=SEARCH;
   				sheetObj.DoSearch("ESD_TPB_0801GS.do", tpbFrmQryStr(formObj) );
  				break;
  		}
  	}
  	/**
  	 * Processing function in case of error to result of retrieve
  	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
  	 */
  	function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
  		ComOpenWait(false);
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj, code, errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowCodeMessage('COM12149','Data','','');
  		}
  	}