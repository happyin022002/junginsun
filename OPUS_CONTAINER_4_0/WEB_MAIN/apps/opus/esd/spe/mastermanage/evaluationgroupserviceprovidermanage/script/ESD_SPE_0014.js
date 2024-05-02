/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SPE_0014.js
*@FileTitle  : EG VS S/P
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_SPE_0014 : business script for ESD_SPE_0014 
     */
    function ESD_SPE_0014() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    /* The common global variables */
  //var calPop = new calendarPopupGrid();
  var curTab=1;
  var beforetab=0;
  var sheetObjects=new Array();
  var sheetCnt=0;
  	/**
	 * Initializing IBTab object
	 * Calling this function before calling loadPage() function in setupPage()
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
  	 * calling this function when occurring onchange event in tab1
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	/**
  	 * Showing the content of the clicked tab when clicking IBTab object.
  	 */
  	function ChangeTab(tabObj,nItem){
  		tabObj.SetBackColor("#FFFFFF");
  //no support[check again]CLT 		tabObj.TabBackColor(nItem)="146,174,230";
  		var objs=document.all.item("tabLayer");
  		objs[beforetab].style.display="none";
  		objs[nItem].style.display="Inline";
  		objs[beforetab].style.zIndex=0;
  		objs[nItem].style.zIndex=9;
  		beforetab=nItem;
  	}
  	/**
  	 * Registering IBSheet Object as list
  	 * Adding process for list in case of needing batch processing with other items
  	 * Defining list on the top of source
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
              ComConfigSheet(sheetObjects[i]);
              initSheet(sheetObjects[i],i+1);
              ComEndConfigSheet(sheetObjects[i]);
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
              case 1:      //IBSheet1 init
            	    with(sheetObj){
		                var HeadTitle="Del.|STS|||S/P ID|S/P Name|Remark||||" ;
		
		                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                var headers = [ { Text:HeadTitle, Align:"Center"} ];
		                InitHeaders(headers, info);
		
		                var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"eg_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"eg_id_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                       {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:0,  Width:350,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eng_vndr_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"eg_rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"eg_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"svc_cate_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"eg_id_etc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                 
		                InitColumns(cols);
		
		                SetEditable(1);
		                SetSheetHeight(260);
                	}
                  break;
          }
      }
  	/* Event handler processing by button click event */
  	document.onclick=processButtonClick;
  /* Event handler processing by button name */
      function processButtonClick(){
           var sheetObject=sheetObjects[0];
           var formObject=document.form;
      	try {
      		var srcName=ComGetEvent("name");
              switch(srcName) {
          	    case "btn_retrieve":
      	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
          	    case "btn_delete":
  					doActionIBSheet(sheetObject,formObject,IBDELETE);
  					break;
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_rowadd":
  					if(formObject.r_flg.value == ""){
  						ComShowCodeMessage("SPE10015","Retrieve","");
  					}else{
  						if(formObject.r_flg.value == "SUCCESS"){
  							doActionIBSheet(sheetObject,formObject,IBINSERT);
  						}else{
  							ComShowCodeMessage("SPE10002","EG Choicer","");
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
    // Handling the process about the sheet
      function doActionIBSheet(sheetObj,formObj,sAction) {
          sheetObj.ShowDebugMsg(false);
          switch(sAction) {
             	case IBSEARCH:      //retrieving
                  if(validateForm(sheetObj,formObj,sAction)){
                  //	if(!ComCheckRequiredField(formObj)) return;
                 		formObj.f_cmd.value=SEARCH;
                 	var param=speFormString(formObj,'f_cmd,eg_id,eg_rhq_cd,eg_cty_cd,svc_cate_cd');
                 	sheetObj.DoSearch("ESD_SPE_0014GS.do", param );
                  }
                  break;
  		  	case IBINSERT:      // Inserting
  			   	var Row=sheetObj.DataInsert(-1);
  		  		var eGid=formObj.eg_id.value;
  		  		var eGidSeq=eGid.substring(6,9);
  				//Setting the default value after creating
  		  		sheetObj.SetCellValue(Row,'eg_id',eGid.substring(0,5),0);
  		  		sheetObj.SetCellValue(Row,'eg_id_seq',eGidSeq,0);
  				break;
  			case IBSAVE:      	// Saving
  			 if(validateForm(sheetObj,formObj,sAction)){
  				formObj.f_cmd.value=MULTI;
  				formObj.eg_id_form.value=formObj.eg_id.value;
  				var param=speFormString(formObj,'f_cmd');
  				sheetObj.DoSave("ESD_SPE_0014GS.do", param);
  				break;
  			 }
  			case IBDELETE:	   	//Delete
  			ComRowHideDelete(sheetObj,"del_chk"); 
  				break;				
          }
      }
  	function sheet1_OnPopupClick(sheetObj, row, col){
  		if ( sheetObj.ColSaveName(col) == "vndr_seq" ){
  			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 420, 'getVendor', '1,0,1,1,1,1,1,1,1', true, false, row, col, 0);
  		}
  	}
  	/**
  	 * Calling this function in case of closing the popup
  	 *
  	 */
  	function getVendor(aryPopupData, row, col){
  		var sheetObj=sheetObjects[0];
  		var formObject=document.form;
  		var colArray=aryPopupData[0];
  		sheetObj.SetCellValue(row, 'vndr_seq',colArray[2] ,0);
  		sheetObj.SetCellValue(row, 'vndr_lgl_eng_nm',colArray[4],0);
  	}
       /**
     	 * Handling the process for the input validation
     	 */
     	function validateForm(sheetObj,formObj,sAction){
     		with(formObj){          			
     			 if(formObj.eg_id.value == null || formObj.eg_id.value == ""){
     			 	if((formObj.eg_rhq_cd.value != null && formObj.eg_rhq_cd.value != "")
     					&& (formObj.svc_cate_cd.value != null && formObj.svc_cate_cd.value != "")
     					&& (formObj.eg_cty_cd.value != null && formObj.eg_cty_cd.value != "")){
     					return true;
     				}else if((formObj.eg_rhq_cd.value == null || formObj.eg_rhq_cd.value == "")
     					&& (formObj.svc_cate_cd.value == null || formObj.svc_cate_cd.value == "")
     					&& (formObj.eg_cty_cd.value == null || formObj.eg_cty_cd.value == "")){ 
     					ComShowCodeMessage('COM12113','The conditions of retrieval');
     					return false;
     				}else if(formObj.eg_rhq_cd.value == null || formObj.eg_rhq_cd.value == ""){
     					ComShowCodeMessage('COM12113','LEVEL1');
     				 	return false;
     				}else if(formObj.eg_cty_cd.value == null || formObj.eg_cty_cd.value == ""){
     					ComShowCodeMessage('COM12113','LEVEL2');
     				 	return false;
     				}else if(formObj.svc_cate_cd.value == null || formObj.svc_cate_cd.value == ""){
     					ComShowCodeMessage('COM12113','LEVEL3');
     				 	return false;
     				}
     			 }else{
     				 var rowCnt=sheetObj.RowCount();
     				for ( var int=1; int < rowCnt +1; int++) {
     					if(sAction == '2' && (sheetObj.GetCellValue(int, 'vndr_seq') == "" || sheetObj.GetCellValue(int, 'vndr_seq') == null)){
         					ComShowCodeMessage('COM12113','S/P ID');	
         					return false;
         				}
					}	
     			 	return true;
     			 }
     		 }
     	}  
  	/**
  	 * Calling this function after finishing to retrieve the sheet
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		var formObject=document.form;
  		formObject.r_flg.value=sheetObj.GetEtcData("r_flg");
		var eg_id_sheet=sheetObj.GetCellValue(1,'eg_id_etc');
		var eg_rhq_cd_sheet=sheetObj.GetCellValue(1,'eg_rhq_cd');
		var eg_cty_cd_sheet=sheetObj.GetCellValue(1,'eg_cty_cd');
		var svc_cate_cd_sheet=sheetObj.GetCellValue(1,'svc_cate_cd');
  		if(eg_id_sheet == ''){
  			eg_id_sheet=sheetObj.GetEtcData("eg_id_db");
  			eg_rhq_cd_sheet=sheetObj.GetEtcData("eg_rhq_cd");
  			eg_cty_cd_sheet=sheetObj.GetEtcData("eg_cty_cd");
  			svc_cate_cd_sheet=sheetObj.GetEtcData("svc_cate_cd");
  		}
  		formObject.eg_id.value=eg_id_sheet;
  		formObject.eg_rhq_cd.value=eg_rhq_cd_sheet;
  		formObject.eg_cty_cd.value=eg_cty_cd_sheet;
  		formObject.svc_cate_cd.value=svc_cate_cd_sheet;
  	}
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		var result=sheetObj.GetEtcData("result");
  		if (result!='OK'){
  			ComShowMessage(result);
  		}
  	}
  	function sheet1_OnChange(sheet1,row,col){
  		if (sheet1.ColSaveName(col) == "vndr_seq" ){
  			var formObject=document.form;
  			formObject.f_cmd.value=SEARCH01;
  			formObject.vndr_seq.value=sheet1.GetCellValue(row,col);
  			var param=speFormString(formObject,'f_cmd,vndr_seq');
  			var sXml=sheet1.GetSearchData("ESD_SPE_0014GS.do", "row="+row+"&"+ param);
  			sheet1.SetCellValue(row, 'vndr_seq',ComXmlString(sXml, "vndr_seq"),0);
  			sheet1.SetCellValue(row, 'vndr_lgl_eng_nm',ComXmlString(sXml, "vndr_lgl_eng_nm"),0);
//  			alert(sXml)
//  			sheet1.LoadSearchXml(sXml,true,row,true);
  		}
  	}
