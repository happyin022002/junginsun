/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0157.js
*@FileTitle  : COD Status Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
     * @author 
     */
    /**
     * @extends 
     * @class ESM_BKG_0157 : business script for ESM_BKG_0157
     */
    
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var prefix1="sheet1_";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
					case "btn_retrieve":
						if (validateForm(sheetObject,formObject,IBSEARCH)){
							doActionIBSheet(sheetObject,formObject,IBSEARCH); 
						}
                    break; 
					case "btn_Duration":
						var cal=new ComCalendarFromTo();
						cal.select(formObject.dur_from, formObject.dur_to,'yyyy-MM-dd');
					break;
					case "btn_DownExcel":
						if(sheetObject.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
						}
						
					break;
					case "btn_CodInquiry":
						if(sheetObject.RowCount()>0)
							{
								if (!ComIsEmpty(sheetObject.GetCellValue(sheetObject.GetSelectRow(),prefix1+"bkg_no"))){
									bkg0156PopUp(sheetObject.GetCellValue(sheetObject.GetSelectRow(),prefix1+"bkg_no"),sheetObject.GetCellValue(sheetObject.GetSelectRow(),prefix1+"cod_rqst_seq"));
								}
							}
						else
							{
							if (!ComIsEmpty(sheetObject.GetCellValue(0,prefix1+"bkg_no"))){
								bkg0156PopUp(sheetObject.GetCellValue(0,prefix1+"bkg_no"),sheetObject.GetCellValue(0,prefix1+"cod_rqst_seq"));
									}
							}
						
					
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initDate(document.form);
//		axon_event.addListenerFormat('keydown',	'bkg0157_keydown', document.form); //- Key is pressed
//		axon_event.addListenerFormat('keypress','bkg0157_keypress',document.form); 
		axon_event.addListenerForm('beforedeactivate', 'bkg0157_obj_deactivate',  document.form); //- Focus Out
	    axon_event.addListenerFormat('beforeactivate',   'bkg0157_obj_activate',    document.form); //- Focus In
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetId=sheetObj.id;
		switch(sheetId) {
			case "sheet1":      //sheet1 init
			    with(sheetObj){
		      var HeadTitle1="|Seq.|Booking No.|R|OLD Booking Route|OLD Booking Route|OLD Booking Route|OLD Booking Route|OLD Booking Route|OLD Booking Route|OLD Booking Route|NEW Booking Route|NEW Booking Route|NEW Booking Route|NEW Booking Route|NEW Booking Route|NEW Booking Route|NEW Booking Route|CNTR\nQ'ty|Approval Result";
		      var HeadTitle2="|Seq.|Booking No.|R|POR|POL|POD|DEL|PRE|POST|T/VVD|POR|POL|POD|DEL|PRE|POST|T/VVD|CNTR\nQ'ty|Approval Result";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"cod_rqst_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"old_por",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"old_pol",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"old_pod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"old_del",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"old_pre",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"old_post",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"old_t_vvd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"new_por",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"new_pol",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"new_pod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"new_del",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"new_pre",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"new_post",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"new_t_vvd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"cntr_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"approval_result", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
//		      SetSheetHeight(380);
		      updateSheetSize(sheetObj);
		      SetRangeBackColor(1,3,1,17,"#555555");
		      ColumnSort(prefix1+"approval_result");
		      }
				break;
        }
    }
    

    $(window).resize(function() {
		if(this.resizeTO) {
			clearTimeout(this.resizeTO);
		}
		this.resizeTO = setTimeout(function() {
			$(this).trigger('resizeEnd');
		}, 300);
 });
 
 $(window).on('resizeEnd', function() {
	 updateSheetSize(sheetObjects[0]);
 });
 
 function updateSheetSize(sheetObj){
	 var obj = $("#" + sheetObj.id).offset();
	 var marginDefault = 20;
	 var marginHeight = obj.top + marginDefault;
    var height = $(window).height();

    with(sheetObj){
        SetSheetHeight(height - marginHeight);
    }
 }
 
  // Sheet handling process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		var arrPreFix=sheetObj.id+"_"; 
        switch(sAction) {
			 case IBSEARCH:      //Retrieve  
				formObj.f_cmd.value=SEARCH; 
				var sXml=sheetObj.GetSearchData("ESM_BKG_0157GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
					sheetObj.RenderSheet(0);
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					sheetObj.RenderSheet(1);
                break;
			 case IBSEARCHAPPEND:	//Retrieve(paging)
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_0157GS.do", CondParam+"&"+ "iPage="+ PageNo,{Append:true} );
				break;
			 case IBDOWNEXCEL:      // Excel download   
				 sheetObj.Down2Excel({ HiddenColumn:-1,TreeLevel:false, Merge:1});
				break;
		}   
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
       with(formObj){
         /*if (ComIsEmpty(dur_from)||ComIsEmpty(dur_to)){
			 ComShowCodeMessage("BKG00702");
			 return false;
         }else if(ComIsEmpty(bkg_ofc_cd)){
			  return false;
		 }*/
	   }
        return true;
    }
	/*
	* ESM_BKG_0156 Call
	*/
	function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH){
		with (sheetObj){
			if (!ComIsEmpty(GetCellValue(Row,prefix1+"bkg_no"))){
			bkg0156PopUp(GetCellValue(Row,prefix1+"bkg_no"),GetCellValue(Row,prefix1+"cod_rqst_seq"));
			}
		}
	}
	/**
	 * OnScrollNext Event Processing to Sheet.<br>
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRows
	 */
	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}
	 /**
      *  Screen Date input form initialization
      */
     function initDate(formObj){
    	 with(formObj){
    		 dur_from.value=ComGetDateAdd(ComGetNowInfo(),"D", -15);
    		 dur_to.value=ComGetNowInfo();
    	 }
     }
    /*
	 * KeyPress Event 
	 */
//    function bkg0157_keypress(){
//		obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat; 
//	    switch(obj.dataformat){ 
//	        case "num": 
//	        	ComKeyOnlyNumber(event.srcElement);
//	            break;	 
//			 case "engup": 
//				 ComKeyOnlyAlphabet('uppernum'); 
//	            break; 
//	    }
//	}
// 	function bkg0157_keydown() {
// 		var obj=event.srcElement;
// 		var vKeyCode=event.keyCode;
// 		var formObj=document.form;
// 		if ( vKeyCode == 13 ) {
//			if (validateForm(sheetObjects[0],formObj,IBSEARCH)){
//				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH); 
//			}
// 		}
// 	}
	 /*
	 * Activate Event 
	 */
	function bkg0157_obj_activate(){
    	//Input Validation 
    	switch(ComGetEvent("name")){
	    	case "dur_from":
	    		ComClearSeparator(ComGetEvent());
    			break; 
			case "dur_to":
	    		ComClearSeparator(ComGetEvent());
    			break; 
    		default:
    			break;
    	}
    }
	/*
	 * Deactivate Event 
	 */
    function bkg0157_obj_deactivate(){ 
    	switch(ComGetEvent("name")){ 
	    	case "dur_from":
	    		ComAddSeparator(ComGetEvent());
    			break; 
			case "dur_to":
	    		ComAddSeparator(ComGetEvent());
    			break; 
    		default:
    			break; 
    	}
    }
	/*
	* ESM_BKG_0156 Screen call
	*/
	function bkg0156PopUp(bkgNo,codRqstSeq){
		var param="?mainPage=false&bkg_no="+bkgNo;
		param+="&cod_rqst_seq="+codRqstSeq;
		param+="&popFlg=S";
		param+="&pgmNo=ESM_BKG_0156_Q";
 		ComOpenWindowCenter("/opuscntr/ESM_BKG_0156_P.do"+param, "ESM_BKG_0156", 1024, 730, true, "yes");
	}

	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
//	    if (sheetObj.RowCount() <= 0)
//	     ComShowCodeMessage("BKG00095");
	   }