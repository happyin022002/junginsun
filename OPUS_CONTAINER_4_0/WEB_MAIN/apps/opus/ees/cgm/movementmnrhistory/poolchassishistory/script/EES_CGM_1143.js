/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1143.jsp
*@FileTitle  : Pool Chassis Expense Trend
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_CGM_1143 : EES_CGM_1143 business script for
     */
   	/* developer job	*/
 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1; 
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** use additional sheet var in case of more than 2 tap each sheet *****/
 		         var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
					case "btn_retrieve":
						 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
					break; 
					case "btn_new":
						 formObj.reset();
						 comboObjects[0].SetSelectCode(-1);
	                	 formObj.chss_pool_cd_text.value="";
	                	 sheetObject1.RemoveAll();
					break; 
					case "btn_downexcel":
						if(sheetObject1.RowCount() < 1){//no data
	                	 	ComShowCodeMessage("COM132501");
	                	 } else{
	                		 sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(						sheetObject1), SheetDesign:1,Merge:1 });
	                	 }
					break;
					case "btns_Calendar1" :		// Agreement Date (From Date)
		 				var cal=new ComCalendar();
	                    cal.setDisplayType('month');
		 				cal.select(formObject.mvmt_dt_fr, "yyyy-MM");
	 				break;  
					case "btns_Calendar2" :		// Agreement Date (From Date)
		 				var cal=new ComCalendar();
	                    cal.setDisplayType('month');
		 				cal.select(formObject.mvmt_dt_to, "yyyy-MM");
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         formObj=document.form;
    //     axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
    //     axon_event.addListenerFormat('beforeactivate',		'obj_activate',		formObj);
         comboObjects[0]=chss_pool_cd;
         for(var k=0;k<comboObjects.length;k++){
   	         initCombo(comboObjects[k]);
  	     }  
         sheet1_OnLoadFinish(sheet1);
     }
      /**
      * 
      * @param sheetObj
      * @return
      */
    function sheet1_OnLoadFinish(sheetObj) {
         sheetObj.SetWaitImageVisible(0);
 		 initControl(sheetObjects[0]);   
		 sheetObj.SetWaitImageVisible(1);
    }
      /**
      * init control of form <br>
      * @param  {object} sheetObj	
      * @return 
      * @author 
      * @version 
      */
     function initControl(sheetObj){
     	// Form object
     	formObj=document.form;
        // axon event 등록
     	// Lease Term Combo Control init setting
     	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
//     	formObj.chss_pool_cd_text.valule = formObj.chss_pool.value;
     	chss_pool_cd.SetSelectCode(formObj.chss_pool.value);
     	
     	if(formObj.prgId.value != ""){
     		doActionIBSheet(sheetObj,document.form,IBSEARCH); 
     	}
     }
      /** 
       * Object deactivate event handling  <br>
       * @param  
       * @return 
       * @author 
       * @version 
       */
      function obj_deactivate(){
     	 var formObj=document.form;
     	 obj=ComGetEvent();
     	   if(obj.name=="mvmt_dt_fr"  ){
     		 with(formObj){
     			 var creDtFr=ComReplaceStr(mvmt_dt_fr.value,"-","");
 	        }
 	        ComChkObjValid(obj);
     	   }
 	       if(obj.name=="mvmt_dt_to"  ){
 	     		 with(formObj){
 	     			 var creDtFr=ComReplaceStr(mvmt_dt_to.value,"-","");
 	 	        }
 	 	        ComChkObjValid(obj);
          }
     }
      /** 
       * Object  activate event handling  <br>
       * @param  
       * @return 
       * @author 
       * @version 
       */
      function obj_activate(){
    	  obj=ComGetEvent();
    	  ComClearSeparator(obj);
      } 
       /** 
        * Combo Object reset  <br>
        * @param  {object} comboObj	 Combo Object
        * @return 
        * @author 
        * @version 
        */ 
       function initCombo(comboObj) {
       	switch(comboObj.options.id) {
   	    	case "chss_pool_cd":
   	 	 		var cnt=0;
   	  	        with(comboObj) {
//   	  	        	Code="";
//   	  	            Text="";
   	  	            SetDropHeight(100);
   	  	            SetMultiSelect(1);
   	  	            SetMultiSeparator(",");
   	  	            SetMaxSelect(100);
   	  	            SetEnable(1);
   	  	        }
   	  	        break;
       	}
       }  
	function resizeSheet( ){
		ComResizeSheet( sheetObjects[0] );
	}
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) { 
             case 1:      //sheet1 init
        	    with(sheetObj){
	               var HeadTitle1="|Seq.|Pool Name|YYYYMM|Estimated Amount|Invoice Amount|Credit|Debit";
	
	               SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"HidStatus" },
	                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:265,  Align:"Center",  ColMerge:1,   SaveName:"chss_pool_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt",       KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"AutoSum",   Hidden:0, Width:140,  Align:"Right",   ColMerge:0,   SaveName:"est_amount",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"AutoSum",   Hidden:0, Width:140,  Align:"Right",   ColMerge:0,   SaveName:"inv_amount",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"AutoSum",   Hidden:0, Width:140,  Align:"Right",   ColMerge:0,   SaveName:"credit",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"debit",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
	                
	               InitColumns(cols);
	               SetEditable(0);
//	               SetSheetHeight(440);
	               resizeSheet( );
	               
	               ShowSubSum([{StdCol:2, SumCols:"4|5|6|7", Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"Sub Total"}]);
	             }
             break;         	
         }
     }
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)){
				   formObj.f_cmd.value=SEARCH;
				   queryString="f_cmd=" + SEARCH ;
 				   var params=FormQueryString(formObj);
 				   sheetObj.SetWaitImageVisible(0);
		 	       ComOpenWait(true);
		 	       sheetObj.DoSearch("EES_CGM_1143GS.do",  params );
		 	       sheetObj.SetSumText(0,1,"");
		 	       sheetObj.SetSumText(0,2,"Grand Total");
				   ComOpenWait(false);
				}
			break;
       	   case IBSEARCH_ASYNC01:	// CP Combo retrieve
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
				ss=ComCgmXml2ComboString(sXml, "TOTAL");
				var cols=ComCgmXml2ComboString(sXml, "code1", "desc1");
				//combo out of IBSHEET GRID 
				makeCPMultiCombo(chss_pool_cd, cols, 0, 0);
	 	  	break;
       	case IBRESET:
	 		var idx=0
	 		var sXml2=document.form2.sXml.value;
	 		var arrXml=sXml2.split("|$$|");
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1=new Array();
	 		for ( var i=0; i < vArrayListData.length; i++) {
	 		    vListData=vArrayListData[i];
	 		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		makeCPMultiCombo2(chss_pool_cd, arrStr1, 0, 0);     
	 		idx++;      
	 		break;
         }
     }
     function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
        	cmbObj.RemoveAll();
        	if(arrStr == undefined ){
        		cmbObj.SetSelectIndex("" ,false);
        	} else {
            	var arrCode=arrStr[0].split("|");
            	var arrCode2=arrStr[1].split("|");
            	cmbObj.InsertItem(0,"All","");
            	for (var i=1; i < arrCode.length+1;i++ ) {
	          		var arrCode3=arrCode[i-1].split("|");
	          		var arrCode4=arrCode2[i-1].split("|");
	          		cmbObj.InsertItem(i, arrCode3[codeCol], arrCode3[codeCol]);
	          	}
        	}
        } 
      function makeCPMultiCombo2(cmbObj, arrStr, txtCol, codeCol) {
    	  	cmbObj.RemoveAll();
         	if(arrStr == undefined ){
         		cmbObj.SetSelectIndex("" ,false);
         	} else {
             	cmbObj.InsertItem(0,"All","");
             	for (var i=1; i < arrStr.length+1;i++ ) {
             		var arrCode=arrStr[i-1].split("|");
              		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
 	          	}
         	}
         } 
    /** 
      * Object  Keypress event handling  <br>
      * inserting value check  <br>
      * @param  
      * @return 
      * @author 
      * @version 
      */ 
  /**
   * handling process for input validation
   */
  function validateForm(sheetObj,formObj,sAction){
 	     with(formObj){
              switch(sAction) {
              	case IBSEARCH:      //retrieve
                  	if(formObj.mvmt_dt_fr.value == ''){
           				ComShowCodeMessage('CGM10004','YYYYMM ');
           				return false;
           			}	
    		 		if(formObj.mvmt_dt_to.value == ''){
           				ComShowCodeMessage('CGM10004','YYYYMM ');
           				return false;
           			}
    		 		 var dt_str=ComReplaceStr(document.form.mvmt_dt_fr.value,"-","");
        			 var dt_end=ComReplaceStr(document.form.mvmt_dt_to.value,"-","");
    	    		if(dt_str != '' && dt_end != ''){
    	    			if(dt_end < dt_str){
    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
    	    				mvmt_dt_fr.value='';
    	    				return false;
    	    			}
    	    		}
    	    		if(document.form.chss_pool_cd_text.value == ''){
           				ComShowCodeMessage('CGM10004','Pool ');
           				return false;
           			}
              	    break;
              }
          }
          return true;
  }
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
 			
 		}
 	}
 	
// 	function chss_pool_cd_OnCheckClick(comboObj, index, code) {
// 		if(index == 0) {
// 	    	var bChk = comboObj.GetItemCheck(0);
// 			for(var i = 1 ; i < comboObj.GetItemCount(); i++) {
// 				comboObj.SetItemCheck(i, bChk);
// 	    	}
// 	    } else {
// 			comboObj.SetItemCheck(0, 0);
// 	    }
// 	}
//	function chss_pool_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
// 		document.form.chss_pool_cd_text.value = newCode;
// 	}
// 	function chss_pool_cd_OnBlur() {
// 		document.form.chss_pool_cd_text.value = chss_pool_cd.GetSelectCode();
// 	}
// 	
 	
 	 var selComboIndex, selComboCode;
 	 function chss_pool_cd_OnSelect(comboObj, index, text, code) {
	 	  selComboIndex = index;
	 	  selComboCode = code;
 	 }
 	 function chss_pool_cd_OnChange(comboObj) {
 	     ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
 	 }


	/* developer job end */