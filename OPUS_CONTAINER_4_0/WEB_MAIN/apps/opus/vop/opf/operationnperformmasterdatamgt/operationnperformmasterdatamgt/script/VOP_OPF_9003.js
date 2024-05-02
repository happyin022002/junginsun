/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_9003.js
*@FileTitle  : COD Diversion Fee Cdoe
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11

=========================================================*/
/****************************************************************************************
  Events demarcation code: [Initialization]INIT=0; [Input]ADD=1; [Inquiry]SEARCH=2; [Display List]SEARCHLIST=3;
					[Modified]MODIFY=4; [Delete]REMOVE=5; [Delete the list]REMOVELIST=6 [Multi-Processing]MULTI=7
					Other extra literal  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code added code to create a good JSDoc------------------*/
   /**
     * @fileoverview Commonly used JavaScript file for calendar-related functions have been defined
     * @author 
     */
    /**
     * @extends 
     * @class VOP_OPF_9003 : VOP_OPF_9003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
   	/* Developer's task	*/
    // Common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var gComboContiCd = "Asia|Europe|America|Africa";
    var gComboContiNm = "A|E|M|F";
    var gComboDvsFeeTpCd = "Per B/L";
    var gComboDvsFeeTpNm = "P";
    // Click the button to define an event handler that receives and processes events */
    document.onclick=processButtonClick;
    // Separated by the name of the button event handler to handle the process */
    function processButtonClick(){
         /***** Case more than two additional sheets sheet variables are used to specify *****/
	         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_RowAdd":
					var row=sheetObject1.DataInsert(-1);
					sheetObject1.SetCellText(row, "delt_flg" ,"N");
					//sheetObject1.CellComboItem(row, "dvs_fee_tp_cd", {ComboText:"20 Feet|40 Feet|Inter Port", ComboCode:"2|4|I"} );
					sheetObject1.SelectCell(row,"conti_cd",true);
					sheetObject1.SetTotalRows(row);
					break;
				case "btn_RowInsert":
					var row=sheetObject1.DataInsert();
					sheetObject1.SetCellText(row, "delt_flg" ,"N");
					//sheetObject1.CellComboItem(row, "dvs_fee_tp_cd", {ComboText:"20 Feet|40 Feet|Inter Port", ComboCode:"2|4|I"} );
					sheetObject1.SelectCell(row,"conti_cd",true);
					sheetObject1.SetTotalRows(row);
					break;
				case "btn_RowCopy":
					sheetObject1.DataCopy();
					break;
				case "btn_RowDelete":
					ComRowHideDelete(sheetObject1,"del_chk");
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_close":
					ComClosePopup(); 
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
     * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet default settings and initialization
     * Implementation of the body tag's onLoad event handler
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
			for(i=0;i<sheetObjects.length;i++){
	        //khlee- Preferences change the name of the function to start
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
	        //khlee-The final configuration functions added
				ComEndConfigSheet(sheetObjects[i]);
			}
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
      /**
         * Sheet, the initial setting, the header definition
         * param : sheetObj ==> sheet Object, sheetNo ==> Sheet object ID of the tag attached to the serial number
         * If you have multiple sheets sheets sheets by adding the number of case should initialize the module configuration
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
    		var sheetID=sheetObj.id;
            switch(sheetID) {
                case "sheet1":
                    with (sheetObj) {

	                    var HeadTitle="|Sel.|No.|Continent Code|Diversion Fee Type Code|Diversion Fee(USD) Amount|";
	                    var headCount=ComCountHeadTitle(HeadTitle);
	                    (headCount, 0, 0, true);
	
	                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                    InitHeaders(headers, info);
	
	                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                        {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
	                        {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
//	                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"conti_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1, AcceptKeys:"E", InputCaseSensitive:1 },
//	                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"dvs_fee_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                        {Type:"Combo",     Hidden:0, Width:150,   Align:"Center",  ColMerge:1,   SaveName:"conti_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0},
	                        {Type:"Combo",     Hidden:0, Width:200,   Align:"Center",  ColMerge:1,   SaveName:"dvs_fee_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0 },
	                        {Type:"Int",       Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"dvs_fee_amt",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15, AcceptKeys:"N" },
	                        {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                     
	                    InitColumns(cols);
	
	                    SetEditable(1);	
	                    //SetSheetHeight(480);
	                    SetColProperty("conti_cd",      {ComboText:gComboContiCd, ComboCode:gComboContiNm} );
	                    SetColProperty("dvs_fee_tp_cd", {ComboText:gComboDvsFeeTpCd, ComboCode:gComboDvsFeeTpNm} );
	                    resizeSheet();
					}
                    break;
            }
        }
        
        function resizeSheet(){
            ComResizeSheet(sheetObjects[0]);
        }

        function doActionIBSheet(sheetObj,formObj,sAction,row, col) {
        	sheetObj.ShowDebugMsg(false);
    	    switch(sAction) {
    	      case IBSEARCH:      //search
    	        formObj.f_cmd.value=SEARCH;
    	        sheetObj.DoSearch("VOP_OPF_9003GS.do", FormQueryString(formObj) );
    	        break;
    	      case IBSAVE:        //save
    	    	  if(!validateForm(sheetObj,formObj,sAction)){
    	    		  return false;
    	    	  }
    	        formObj.f_cmd.value=MULTI;
    	        sheetObj.DoSave("VOP_OPF_9003GS.do", FormQueryString(formObj), -1, false);
    	        break;
//// 2015.05.14 [conti_cd]text -> Combo
//    	      case SEARCH01:  
//    	    	  formObj.f_cmd.value=SEARCH01;
//    	    	  var sXml=sheetObj.GetSearchData("VOP_OPF_9003GS.do", FormQueryString(formObj));
//    	    	  var result=ComGetEtcData(sXml, "RESULT");
//    	    	  if(result =="0" || result == undefined){
//    	    		  ComShowCodeMessage("COM132202", "Conti Code");
//    	    		  sheetObj.SelectCell(row,"conti_cd",true,"");
//    	    		  sheetObj.SetCellValue(row,"conti_cd", "");
//    	    		  return false;
//    	    	  }
//    	    	  break;
     	    }
    	}
        /**
         * Code Data Validation Check.
         */
        function sheet1_OnChange(sheetObj, row, col, value){
        	if(sheetObj.ColSaveName(col)=="conti_cd"){
//// 2015.05.14 [conti_cd]text -> Combo
//        		var conti_cd=sheetObj.GetCellValue(row, "conti_cd");
//        		if(conti_cd.length=="1"){
//	        		ComSetObjValue(document.form.conti_cd, value);
//	        		doActionIBSheet(sheetObj, document.form, SEARCH01,row, col);
//        		}
        	    /* conti_cd선택시 dvs_fee_tp_cd가 해당 conti_cd에 유효한 내용으로 변경 */
        		var conti_cd = sheetObj.GetCellValue(row, "conti_cd");
        		sheetObj.SetCellValue(row, "dvs_fee_tp_cd", "P");
        		/*if(conti_cd == 'M') {
        			sheetObj.CellComboItem(row, "dvs_fee_tp_cd", {ComboText:"Per B/L", ComboCode:"P"} );
        			sheetObj.SetCellValue(row, "dvs_fee_tp_cd", "P");
        		} else {
        			sheetObj.CellComboItem(row, "dvs_fee_tp_cd", {ComboText:"20 Feet|40 Feet|Inter Port", ComboCode:"2|4|I"} );
        			sheetObj.SetCellValue(row, "dvs_fee_tp_cd", "2");
        		}*/
        	}
        }
        /**
         * Screen input form validation process for handling
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            	if(sheetObj.RowCount()>0){
            		
            		for(var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
            			if(sheetObj.GetRowStatus(i) != 'D') {
            				sheetObj.SetRowFontColor(i,"#000000");
            			}
            		}
            		
            		var Rows = sheetObj.ColValueDupRows("conti_cd|dvs_fee_tp_cd", 0);

            		var arr_rows=null;
    	        	if (Rows!=null && Rows.trim()!=''){
    	        		arr_rows=Rows.split(',');
    	        	}
    	        	for (var i=0; arr_rows!=null && i<arr_rows.length; i++){
    	                sheetObj.SetRowFontColor(arr_rows[i],"#FF0000");
    	            }
    	        	if (Rows!=null && Rows.trim()!=''){
    	        		ComShowCodeMessage("OPF50005", "Data");
        				return false;
    	            }else{
    	                return true;
    	            }
            		
            		/*
            		// Reject Reason Code Data Duplicate check.
            		for(var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
//// 2015.05.14 [conti_cd]text -> Combo
//            			if(sheetObj.GetCellValue(i,"conti_cd").length!=1){
//                    		ComShowCodeMessage("OPF50007", "Conti Code","1");
//                    		sheetObj.SelectCell(i,"conti_cd",true);
//                    		return false;
//                    	}
//// 2015.05.14 [dvs_fee_tp_cd]text -> Combo
//            			if(sheetObj.GetCellValue(i,"dvs_fee_tp_cd").length!=1){
//                    		ComShowCodeMessage("OPF50007", "DVS Fee Tp Code","1");
//                    		sheetObj.SelectCell(i,"dvs_fee_tp_cd",true);
//                    		return false;
//                    	}
            			if(sheetObj.GetRowStatus(i) != 'D') {
            				var iDupChkCount = 0;
            				var iDupRow = "";
	            			for(var j=sheetObj.HeaderRows(); j<= sheetObj.LastRow(); j++){
	            				if(sheetObj.GetRowStatus(j) != 'D') {
	            					var tgtContiCd = sheetObj.GetCellValue(i,"conti_cd");
	            					var srcContiCd = sheetObj.GetCellValue(j,"conti_cd");
	            					var srcContiNm = sheetObj.GetCellText(j,"conti_cd");
	            					
	            					if(tgtContiCd != null && srcContiCd != null && tgtContiCd == srcContiCd){
	            						iDupChkCount ++;
	            						
	            						if(iDupChkCount > 1){
	            							iDupRow = j+" "+ srcContiNm;
	            							break;
	            						}
	            					}
	            					
		            				if(sheetObj.GetCellValue(i,"conti_cd") != null
		            						&& sheetObj.GetCellValue(i,"dvs_fee_tp_cd") != null
		            						&& sheetObj.GetCellValue(i,"conti_cd") != ""
		            							&& sheetObj.GetCellValue(i,"dvs_fee_tp_cd") != ""
		            								&& sheetObj.GetCellValue(i,"conti_cd")==sheetObj.GetCellValue(j,"conti_cd")
		            								&& sheetObj.GetCellValue(i,"dvs_fee_tp_cd")==sheetObj.GetCellValue(j,"dvs_fee_tp_cd"))
			            			{
			            				//ComShowMessage("Reject Reason Code is already exist.");
			            				ComShowCodeMessage("OPF50005", "Data");
			            				if(sheetObj.GetRowStatus(i)=="I"){
			            					sheetObj.SelectCell(i,"conti_cd",true);
			            				}else{
			            					sheetObj.SelectCell(j,"conti_cd",true);
			            				}
					    				return false;
			            			}
	            				}
	            			}
	            			
	            			if(iDupChkCount > 1){
	            				ComShowCodeMessage("OPF50005", "["+iDupRow+"]Row Data");
	            				return false;
	            			}
	            			
	            			
            			}
            		}*/
            	}
            }
            return true;
        }
    function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg) {
    	 ComOpenWait(false);// always exist at first line
//    	 if(Code == 0){
//    	  ComShowCodeMessage("COM132601");
//    	}
	}
	/* End developers work */
    /**
     * 조회row의 경우 Dvs Fee Amount만 수정 가능
     */
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    	for(i=1; i< (sheetObj.RowCount()+1); i++){
    		if(sheetObj.GetCellValue(i,"ibflag") == 'R') {
    			sheetObj.SetCellEditable(i, "conti_cd", 0);
    			sheetObj.SetCellEditable(i, "dvs_fee_tp_cd", 0);
    		} 
    	}
    }
