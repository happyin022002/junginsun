/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0190.js
*@FileTitle  : Actual Customer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
 // Common global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var prefix="sheet1_";//IBSheet Delimiter
 /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
 	var comboObjects=new Array();
 /*********************** EDTITABLE MULIT COMBO END ********************/
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
		    initControl();
		    //for multi combo gives 0.1 seconds for the delay
		    //setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,SEARCH01); },100);
		 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		    //form.p_vvd.focus();
     }
    function initControl() {
    	var formObject=document.form;
//        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- When typing the keyboard
        axon_event.addListenerForm  ('beforedeactivate', 'bkg_deactivate',  formObject); //- out  focus 
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- in  focus 
//        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }        
 /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //English uppercase characters
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //the number + English capital letter
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "engdnnum":
	        //the number + English capital letter
	      	ComKeyOnlyAlphabet('lowernum');
	        break;
	      case "num":
	        //Numeric input
	        ComKeyOnlyNumber(event.srcElement);
	        break;	            
	      default:
	    }
	}  
	  /**
     * HTML Control  onBlur Event.
     **/
    function bkg_deactivate() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "app_dt":
	    		ComAddSeparator(event.srcElement);
					break;
				default:
					break;
	    }
    }        
	/**
	 * The onFocus event in HTML Control Validation Check. <br>
	 **/
	function bkg_activate(){
			var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "app_dt":
	    		ComClearSeparator(event.srcElement);
					break;
				default:
					break;
	    }
	}  
/*********************** KEY EVENT END ********************/
// Event handler processing by button click event */
 		document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
          var sheetObject1=sheetObjects[0];
					var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	     	try {
	     		var srcName=ComGetEvent("name");
		 			switch(srcName) {
		 				case "btn_RowAdd":
		 					doActionIBSheet(sheetObject1,formObject,IBINSERT);
		 					break;
		 				case "btn_RowDelete":
		 					ComRowHideDelete(sheetObject1,"sheet1_del_chk");
		 					break;
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_New":
		 					location.reload(true);
		 					break;
		 				case "btn_DownExcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					break;
		 				case "btn_Select":
		 					comPopupOK();
							//setActualCustomer(sheetObject1);
		 					break;
		 				case "btn_Close":
		 					ComClosePopup(); 
		 					break;
		 				case "btn_Print":
		 					alert('Print - Under Construction~~');
		 					//RdParam(sheetObject1,prefix);
		 					break;
		 				case "btn_app_dt":
		 					var cal=new ComCalendar();
	 	        	cal.select(formObject.app_dt, 'yyyy-MM-dd');
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
   // Sheet handling process
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			 			case IBSEARCH:      //Retrieve
				 				if(!validateForm(sheetObj,formObj,sAction)) return;
	//			 				debug.innerHTML=FormQueryString(formObj);
				 				//alert(FormQueryString(formObj));
				 				//break;
				 				formObj.f_cmd.value=SEARCH;
				 				var sXml=sheetObj.GetSearchData("ESM_BKG_0190GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
								sheetObjects[0].SetWaitImageVisible(0);
								sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
							if(ComGetTotalRows(sXml)=="0"){
								break;
							}
							formObj.from_dt.value=ComGetEtcData(sXml, "from_dt") == undefined ? "": ComGetEtcData(sXml, "from_dt") ;
							formObj.to_dt.value=ComGetEtcData(sXml, "to_dt") == undefined ? "": ComGetEtcData(sXml, "to_dt") ;
			 				break;
			 			case SEARCH01:      //Retrieve
							break;
						case IBINSERT:    
							sheetObj.DataInsert(-1);
							break;
						case IBDOWNEXCEL:   // Excel download
							sheetObj.Down2Excel({ HiddenColumn:1});
							break;
			    }
     }
		function setActualCustomer(sheet){
							if(sheet.GetTotalRows()== 0) return;
		 				  var sColStr=sheet.GetSelectionRows();
	 				    var arrRows=sColStr.split("|");				    	
//		 				  alert(sheet.CellValue(arrRows[0],prefix + "cust_cnt_cd")+":" +sheet.CellValue(arrRows[0],prefix + "cust_seq"));
							try{
								opener.setActualCustomer(sheet.GetCellValue(arrRows[0],prefix + "cust_cnt_cd"), sheet.GetCellValue(arrRows[0],prefix + "cust_seq"));
							}catch(e){
								ComShowCodeMessage("BKG01036","setActualCustomer");
							}
		}      
			/**
       * Changes the font color
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     }
     function setCelColor(flag, obj,idx,celName,color){
     	if(flag =="N")
     		obj.SetCellFontColor(idx,celName,color);
     }
/*
		 *  Search Option or Item Option Modify
		 * */
     function sheet1_OnClick(sheetObj,rowIdx,colIdx,val) {
				sheetObj.SetCellValue(rowIdx, "radio",1);
     }	      
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
	    		if (ComIsNull(formObj.sc_no) && ComIsNull(formObj.rfa_no)) {
	     					ComShowCodeMessage('BKG00016');
	     					return false;
			  	}
	    		if (ComIsNull(formObj.svc_scp_cd)) {
	     					ComShowCodeMessage('BKG01034');
	     					return false;
			  	}
					if(ComIsNull(formObj.bkg_no)){
						ComShowCodeMessage('BKG00626','BKG No.');
						return false;	  		
					}
					if(ComIsNull(formObj.app_dt)){
						ComShowCodeMessage('BKG00626','Applicable Date');
     				formObj.app_dt.focus();
						return false;	  		
					}
	  			break;
    	 }
         return true;
     }
     /**
      * Check yyyyMMd date
      */
     function dateCheck(dateobj){
     	if(dateobj.value =="") return true;
      return ComIsDate(dateobj.value);
     }	
//    function isNullEtcData(xmlStr){
//    	var rtn=false;
//    	var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
//        xmlDoc.loadXML(xmlStr);
//        var xmlRoot=xmlDoc.documentElement;
//        if(xmlRoot == null) return true;
//        var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
//        if(etcDataNode == null) return true;
//        var etcNodes=etcDataNode.childNodes;
//        if(etcNodes == null) return true;
//        if(etcNodes.length == 0) rtn=true;
//        return rtn;
//    }
 /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetObj.id) {
            case "sheet1":
              with (sheetObj) {
                var HeadTitle1=" | |Sel.|Seq.|Code|Actual Customer Name ";
                var headCount=ComCountHeadTitle(HeadTitle1);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_cnt_cd" },
                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_seq" },
                       {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"radio" },
                       {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
                       {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:prefix+"code",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cust_lgl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);

                SetEditable(1);
                SetSheetHeight(162);
			}
			break;
         }
     }
