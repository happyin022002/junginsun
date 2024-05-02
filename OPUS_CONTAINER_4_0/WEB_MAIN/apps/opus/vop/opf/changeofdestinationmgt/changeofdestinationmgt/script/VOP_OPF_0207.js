/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0207.jsp
*@FileTitle  : COD Tariff Registration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class VOP_OPF_0207 : VOP_OPF_0207 business script for
     */
   	/* Developer performance	*/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sheet1_Editable_Flg=true;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		　
		var sheetObject1=sheetObjects[0];   //sheet1
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_close":
					ComClosePopup(); 
					break;
				case "btn_ok":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
			//change start configuration method name 
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//add last configuration method 
			ComEndConfigSheet(sheetObjects[i]);
		}
		//Retrieve COD Request Information 
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		initControl();
		sheet2_OnLoadFinish(sheet2);
	}
	/**
     * Sheet1 OnLoadFinish Event 
     * param : sheetObj
     * 
     */
 	function sheet2_OnLoadFinish(sheetObj) {	
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    /**
     * Loading event of HTML Control in page dynamically <br>
     * initializing IBSheet by calling {@link #loadPage}Method <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 
     **/
    function initControl(){
        axon_event.addListenerFormat('focus',     'obj_activate',   form); 
        axon_event.addListenerFormat('keypress',  'obj_keypress',   form); 
    }
    /**
     * delete mask separator in onfocus event of HTML Control <br>
     **/
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
    /**
     * Input only number in onkeypress event of HTML Control <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
    		case "numonly":
    			ComKeyOnlyNumber(event.srcElement);	//inputting number
    			break;
    		default:    	    	
    			ComKeyOnlyAlphabet("num");					//common standard: recognization only number, english
	    		break;
    	}
    }
    /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
 		 var formObject=document.form;
         switch(sheetID) {
             case "sheet1":      // sheet1 init
            	    with(sheetObj){
                 
//               (4, 0, 0, true);
		               var HeadTitle="|conti_cd|dvs_fee_tp_cd|dvs_fee_amt";
		               var prefix="sheet1_";
		
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"conti_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dvs_fee_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dvs_fee_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                
		               InitColumns(cols);
		
		               SetEditable(1); 
		              // SetGetCountPosition()(0);
		               SetSheetHeight(200);
		               SetHighlightAfterSort(0);
                     }


                 break;                 
             case "sheet2":      // sheet1 init
            	    with(sheetObj){
                
//			               if(formObject.isPop.value == "R"){
//			               }else{
//			               }
			               var HeadTitle1="||Region|COD MIN. Tariff|COD MIN. Tariff|COD MIN. Tariff|COD MIN. Tariff";
			               var HeadTitle2="||Region|20Ft|40Ft|Inter Port|Per B/L";
			               var headCount=ComCountHeadTitle(HeadTitle1);
			             //  (headCount, 0, 0, true);
			               var prefix="sheet2_";
			
			               SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
			
			               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			               var headers = [ { Text:HeadTitle1, Align:"Center"},
			                           { Text:HeadTitle2, Align:"Center"} ];
			               InitHeaders(headers, info);
			
			               var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			                      {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"conti_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"conti_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"t20ft",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"t40ft",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"tport",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"tbl",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];
			                
			               InitColumns(cols);
			
//			               SetEditable(0);
			               SetEditable(1);
		            	   if(formObject.isPop.value == "R"){
		            		   SetEditable(0);
		            	   }
			              // SetGetCountPosition()(0);
			               SetSheetHeight(200);
			               SetHighlightAfterSort(0);
                     }


                 break;                 
         }
     }
   // handling process related Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      //Retrieve
				if ( sheetObj.id == "sheet1"){
					formObj.f_cmd.value=SEARCH;
					var arr=new Array("sheet1_", "sheet2_");
 					var sXml=sheetObj.GetSearchData("VOP_OPF_0207GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
					var arrXml=sXml.split("|$$|");
					for(var i=0; i<arrXml.length; i++){ 
						sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
					}
					break;				
				}
			case IBSAVE:        //save
				formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("VOP_OPF_0207GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"),-1,false,true);
				break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }
 	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount()> 0){
			sheetObj.SetCellEditable(2, "sheet2_tbl",0);
			sheetObj.SetCellEditable(3, "sheet2_tbl",0);
			sheetObj.SetCellEditable(4, "sheet2_t20ft",0);
			sheetObj.SetCellEditable(4, "sheet2_t40ft",0);
			sheetObj.SetCellEditable(4, "sheet2_tport",0);
		}
 	}
 	// change sheet1 by changing sheet2
 	function sheet2_OnChange(sheetObj, Row, Col, Value){
 		if(Row == 2){ //Asia
 			if(Col == sheetObj.SaveNameCol("sheet2_t20ft"))
 				sheetObjects[0].SetCellValue(1, "sheet1_dvs_fee_amt",Value);
 			if(Col == sheetObj.SaveNameCol("sheet2_t40ft"))
 				sheetObjects[0].SetCellValue(2, "sheet1_dvs_fee_amt",Value);
 			if(Col == sheetObj.SaveNameCol("sheet2_tport"))
 				sheetObjects[0].SetCellValue(3, "sheet1_dvs_fee_amt",Value);
 		}else if(Row == 3){ //Europe
 			if(Col == sheetObj.SaveNameCol("sheet2_t20ft"))
 				sheetObjects[0].SetCellValue(4, "sheet1_dvs_fee_amt",Value);
 			if(Col == sheetObj.SaveNameCol("sheet2_t40ft"))
 				sheetObjects[0].SetCellValue(5, "sheet1_dvs_fee_amt",Value);
 			if(Col == sheetObj.SaveNameCol("sheet2_tport"))
 				sheetObjects[0].SetCellValue(6, "sheet1_dvs_fee_amt",Value);
 		}else if(Row == 4){ //USA
 			if(Col == sheetObj.SaveNameCol("sheet2_tbl"))
 				sheetObjects[0].SetCellValue(7, "sheet1_dvs_fee_amt",Value);
 		}
 	}
 	function sheet1_OnSaveEnd(ErrMsg){
  ComClosePopup(); 
 	}
	/* Developer performance  end */
