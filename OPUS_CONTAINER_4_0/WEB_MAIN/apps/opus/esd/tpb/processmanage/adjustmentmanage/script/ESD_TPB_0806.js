/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0806.js
*@FileTitle  : Adjustment Approval Review Message
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
/****************************************************************************************
  Event code : 	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : 	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/* Global Variables */
	//var calPop = new calendarPopupGrid();
	var curTab=1;
	var beforetab=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var processCloseCase="0";
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
  				with (sheetObj) {
  					var cnt=0;
  					SheetWidth=mainTable.clientWidth;
  					MergeSheet=msNone;
  					SetEditable(1);
  					InitRowInfo( 1, 1, 10);
  		            switch (processCloseCase){
                       case "1" : 
                           var HeadTitle="Booking No.|C/A No.|Charge Code|Note";
                           SetConfig( { SearchMode:2, DataRowMerge:1 } );
                           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                           var headers = [ { Text:HeadTitle, Align:"Center"} ];
                           InitHeaders(headers, info);

                           var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
                                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ca_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                                  {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                                  {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"note",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 } ];
                            
                           InitColumns(cols);
                           break; 		                
                       case "2" : 
                           var HeadTitle="Credit Note No.|CSR No.|Note";

                           SetConfig( { SearchMode:2, DataRowMerge:1 } );

                           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                           var headers = [ { Text:HeadTitle, Align:"Center"} ];
                           InitHeaders(headers, info);

                           var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cn_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                                  {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                                  {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"note",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 } ];
                            
                           InitColumns(cols);
                           break; 		                
                       case "3" : 
                           var HeadTitle="TTL INV No.|Disposal INV No.|Credit Note No.|CSR No.|Note";

                           SetConfig( { SearchMode:2, DataRowMerge:1 } );

                           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                           var headers = [ { Text:HeadTitle, Align:"Center"} ];
                           InitHeaders(headers, info);

                           var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_inv_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dps_inv_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cn_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                                  {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                                  {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"note",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 } ];
                            
                           InitColumns(cols);
                           break; 		                
  		            }
  		            SetSheetHeight(180);
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
  				case "btn_add":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_save":
  				    var rtnVal=new Array(3);
  				    rtnVal[0]=document.form.s_file_no.value;
  				    rtnVal[1]=document.form.s_ra_rmk.value;
                      if ( rtnVal==null || rtnVal.length==0){
                          ComShowMessage(ComGetMsg("TPB90045"));
                          return;
                      } else {
                          ComPopUpReturnValue(rtnVal);
                      }
  					break;					
  				case "btn_ok": /// on ok button click
  					break;
  				case "btn_downexcel":
  //no support[check again]CLT 					sheetObject.ExcelPrint="";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
  //no support[check again]CLT 					sheetObject.ExcelPrint="PrintOnly";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_close":
  				    //window.returnValue=null;
  				    ComClosePopup(); 
  				    break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg("COM12111"));
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
  	/* Processing Sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg(false);
  		switch(sAction) {
  			case IBINSERT:	  //Insert
  				var Row=sheetObj.DataInsert(-1);
  				break;
  		   case IBSEARCH:	  //Retrieve
  				break;
  		}
  	}
  	/**
  	 * Checking validation of input value
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  		   if(!checkTPBForm(formObj)) return false;
  		}
  		return true;
  	}
      function makeMessageArray(sheetObj){
          var HeadTitleArr=null;
          var saveNameArr=null;
          var colon=":";
          var comma=", ";
          var tempRowVal="";
          var tempRowStr="";
          var tempStr="";
          var validRowCount=0;
          var returnValArr=new Array();
  		for(var i=1;i<=sheetObj.RowCount();i++){
              tempRowStr="";
  		    for(var k=0; k<HeadTitleArr.length; k++){
  		    	tempStr=sheetObj.GetCellValue(i, k);
  			    if (trim(tempStr).length > 0){
      		        if ( tempRowStr.length > 0){
      		            tempRowStr += comma;
      		        }
  		            tempRowStr += HeadTitleArr[k] + colon + tempStr; 
  		        }
  		    }
  		    if ( tempRowStr.length > 0 ){
  		         returnValArr[returnValArr.length]=tempRowStr;
  		    }
  		    // showErrMessage(tempRowStr);
  		}
          // showErrMessage(returnValArr.length);
          return returnValArr;
      }
  	function getFileNo(fileNoReceive){
  		document.form.s_file_no.value=fileNoReceive;
//  		ifr.document.location.href = "TPBFileDownload.do?fileNo="+document.form.s_file_no.value+"&f_cmd="+SEARCH+"&downloadLink=Y&col=1";
  	}
