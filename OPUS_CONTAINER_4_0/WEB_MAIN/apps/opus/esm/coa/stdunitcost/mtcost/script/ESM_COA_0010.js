/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0010.js
*@FileTitle  : MT CNTR MVMT History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
   /**
     * @fileoverview 
    */
    /**
     * @extends 
     * @class ESM_COA_0010 : ESM_COA_0010 Business script for the UI
     */
    /* Grobal Variable */
  //var calPop = new calendarPopupGrid();
  var curTab=1;
  var beforetab=0;
  var sheetObjects=new Array();
  var sheetCnt=0;
  /* Event handler processing by button click event */
  document.onclick=processButtonClick;
  /* Event handler processing by button name */
  	function processButtonClick(){
  			/***** Specify additional sheet variable in case of using more than two sheet per tab *****/
  			var sheetObject=sheetObjects[0];
  			var sheetObject1=sheetObjects[1];
  			/*******************************************************/
  			var formObject=document.form;
  		try {
  			var srcName=ComGetEvent("name");
  			 if(ComGetBtnDisable(srcName)) return false;
  			switch(srcName) {
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_DownExcel":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_Close":
  					ComClosePopup(); 
  					break;
  			} // end switch
  		}catch(e) {
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg(OBJECT_ERROR));
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
			//Sheet configuration setting function(start)
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//Sheet configuration setting function(end)
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
  			case 1:		//sheet2 init
  			    with(sheetObj){
  		      var HeadTitle="ECC|Flag|ECC Pair|ID|Origin Yard|TP/SZ|Vol|MT Steve AMT|MT Trans AMT|Total AMT|MT Steve U/C|MT Trans U/C" ;

  		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

  		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
  		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
  		      InitHeaders(headers, info);

  		      var cols = [ {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ecc_cd" },
  		             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ori_dest" },
  		             {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"frm_to_ecc" },
  		             {Type:"Text",     Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"frm_to_seq" },
  		             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"frm_yard" },
  		             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },
  		             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"mcntr_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"steve_ttl_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
  		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"trsp_ttl_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
  		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"total_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
  		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"steve_unit_cost",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
  		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"trsp_unit_cost",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 } ];
  		       
  		      InitColumns(cols);

  		      SetEditable(0);//Editkind[optional,Defaultfalse]
  		      SetHeaderRowHeight(10);
  		      SetAutoSumPosition(1);
//  		      SetSheetHeight(ComGetSheetHeight(sheetObj, 23))
			  resizeSheet();
  		      
  		      }
		      //Display subtotal2 total
	  		var tmpTxt="(Dest Total)";
	  		if(document.form.f_ori_dest.value=='0') tmpTxt="(Origin Total)";
	  		sheetObj.SetSubSumBackColor("#D7CFDF");
	  		sheetObj.ShowSubSum([{StdCol:"ori_dest", SumCols:"7|8|9", Sort:true, ShowCumulate:false, CaptionCol:4, CaptionText:tmpTxt}, {StdCol:"frm_to_seq", SumCols:"7|8|9", Sort:true, ShowCumulate:false, CaptionCol:4, CaptionText:"(Sub-Total)", AvgCols:"6"}]);
	  		//Display subtotal1 sub-total
//	  		sheetObj.SetSubSumBackColor("#E2D9EA");
//  		sheetObj.ShowSubSum([{StdCol:"frm_to_seq", SumCols:"7|8|9", Sort:true, ShowCumulate:false, CaptionCol:4, CaptionText:"(Sub-Total)", AvgCols:"6"}]);


  				break;
  		}
  	}
  	/*To retrieve when the screen is loaded */
  	function setRetrieveAction(){
  		sheetObject=sheetObjects[0];
  		formObject=document.form;
  		doActionIBSheet(sheetObject,formObject,IBSEARCH);
  	}
  	/**
  	* Handling subtotal <br>
  	*/
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
//  		//Display subtotal2 total
//  		var tmpTxt="4=(Dest Total)";
//  		if(document.form.f_ori_dest.value=='0') tmpTxt="4=(Origin Total)";
//  		sheetObj.SetSubSumBackColor("#D7CFDF");
//  		sheetObj.ShowSubSum([{StdCol:"ori_dest", SumCols:"7|8|9", Sort:true, ShowCumulate:false, CaptionCol:4, CaptionText:tmpTxt}]);
//  		//Display subtotal1 sub-total
//  		sheetObj.SetSubSumBackColor("#E2D9EA");
//  		sheetObj.ShowSubSum([{StdCol:"frm_to_seq", SumCols:"7|8|9", Sort:true, ShowCumulate:false, CaptionCol:4, CaptionText:"4=(Sub-Total)", AvgCols:"6"}]);
  		//Total vol
  		var tmpRowArr1=sheetObj.FindSubSumRow("frm_to_seq").split('|');
  		var volSum=0;
  		for(var k=0; k<tmpRowArr1.length-1; k++){
  			volSum=volSum + parseInt(sheetObj.GetCellValue(parseInt(tmpRowArr1[k]), 6));
  		}
  		var tmpRowArr=sheetObj.FindSubSumRow("ori_dest").split('|');
  		//sheetObj.RangeFontBold(parseInt(tmpRowArr[0]), 1, parseInt(tmpRowArr[0]), 12)=true;
  		//sheetObj.CellValue2(tmpRowArr[0], "mcntr_qty") = volSum;
  		//sheetObj.CellAlign(tmpRowArr[0], "mcntr_qty") = daCenter;
  	}
  	// Handling process about the sheet object
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg(false);
  		switch(sAction) {
  			case IBSEARCH:		//Inquiry
  				if(validateForm(sheetObj,formObj,sAction))
  					// Prohibit button click when a business transaction is processing 
					sheetObj.SetWaitImageVisible(0);
  					ComOpenWait(true);
  					formObj.f_cmd.value=SEARCH;
   					sheetObj.DoSearch("ESM_COA_0010GS.do", coaFormQueryString(formObj) );
  					ComOpenWait(false);
  				break;
  			case IBDOWNEXCEL:			// Excell download
  				var excelType=selectDownExcelMethod(sheetObj);
  				break;
  		}
  	}
  	
  	function callBackExcelMethod(excelType){
  		var sheetObj = sheetObjects[0];
  		 switch (excelType) {
  		    case "AY":
  		        sheetObj.Down2Excel({ HiddenColumn:0,Merge:true, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
  		        break;
  		    case "DY":
  		   	    sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
  		        break;
  		    case "AN":
  		        sheetObj.Down2Excel({ HiddenColumn:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
  		        break;
  		    case "DN":
  		   	    sheetObj.Down2Excel( { HiddenColumn:1, SheetDesign:1,Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
  		        break;
  		 }
  	}
  	
  	/**
  	* Handling process for form object input validation
  	*/
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  		}
  		return true;
  	}

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
	/* Developer's task ends */
