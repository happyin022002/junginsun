/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1141.js
*@FileTitle  : Pool Chassis Comparison Summary
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
     * @class EES_CGM_1141 : EES_CGM_1141 business script for
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
          var sheetObject2=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
                 case "btn_retrieve":
                	 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                     break;
                 case "btn_downexcel":
                	 if(sheetObject1.RowCount() < 1){//no data
                	 	ComShowCodeMessage("COM132501");
                	 } else{
                		 sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
                	 }

                	 if(sheetObject2.RowCount() < 1){//no data
                	 	ComShowCodeMessage("COM132501");
                	 } else{
                		 sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
                	 }
					 break;
                 case "btn_new":
                	 // formObj.reset();
                	 formObj.chss_pool_co_cd_text.value = "";
                	 formObj.chss_pool_nm.value = "";
                	 formObj.pool_mgmt_co_nm.value = "";
                	 formObj.mvmt_dt.value = "";
                	 //
                	 formObj.chss_pool_co_cd.text="";
                	 sheetObject1.RemoveAll();
                	 sheetObject2.RemoveAll();
                	 chss_pool_co_cd.SetSelectIndex(-1);
                     break; 
                 case "btns_Calendar1" :		// Agreement Date (From Date)
	 				var cal=new ComCalendar();
                    cal.setDisplayType('month');
	 				cal.select(formObject.mvmt_dt, "yyyy-MM");
	 				break;  
                 case "btn_trend" :
                	 doActionPageMove(sheetObject1,formObject,srcName);
                	break;
                 case "btn_file" :
                	 doActionPageMove2();
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
      * Sheet setting and reset
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
         		//
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         		//
             //ComEndConfigSheet(sheetObjects[i]);
             sheetObjects[i].SetExtendLastCol(1);
             sheetObjects[i].SetVisible(1);
         }
         formObj=document.form;
//         axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
//         axon_event.addListenerFormat('beforeactivate',		'obj_activate',		formObj);
//         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
         comboObjects[0]=chss_pool_co_cd;
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
 		 chss_pool_co_cd.SetSelectIndex(-1);
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
         // axon event regist
     	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
     	 doActionIBSheet(sheetObjects[0], document.form, IBRESET);
//     	formObj.chss_pool_co_cd.focus();
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
     	 obj=event.srcElement;
     	 if(obj.name=="mvmt_dt"  ){
     		 with(formObj){
     			 var creDtFr=ComReplaceStr(mvmt_dt.value,"-","");
 	        }
 	        ComChkObjValid(event.srcElement);
         }
     }
      /** 
       * Object activate event handling  <br>
       * @param  
       * @return 
       * @author 
       * @version 
       */
      function obj_activate(){
        	ComClearSeparator(event.srcElement);
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
		               var HeadTitle="|Company Division|EQ Divison|CNTR / CHSS|CHSS Units|Used Days|Rate (USD)|Total Amount (USD)|CHSS_OWNR_CO_CD|CNTR_OWNR_CO_CD";
		
		               SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"HidStatus" },
		                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"com_division",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"divison",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cntr_chss",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",  ColMerge:0,   SaveName:"chss_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",  ColMerge:0,   SaveName:"own_chss_usd_dys",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",  ColMerge:0,   SaveName:"rate",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",  ColMerge:0,   SaveName:"total",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                            {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"chss_ownr_co_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_ownr_co_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
		                            ];
		                
		               InitColumns(cols);
		               SetEditable(0);
		               SetSheetHeight(210);
               	}
                break;
              case 2:      //sheet2 init
            	  with(sheetObj){
		                var HeadTitle1="| |EQ Divison|CNTR / CHSS|CHSS Units|CHSS Units|Used Days|Used Days|CHSS_OWNR_CO_CD|CNTR_OWNR_CO_CD";
		                var HeadTitle2="| |EQ Divison|CNTR / CHSS|Matching|Unmatching|Matching|Unmatching|CHSS_OWNR_CO_CD|CNTR_OWNR_CO_CD";
		
		                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		                var headers = [ { Text:HeadTitle1, Align:"Center"},
		                            { Text:HeadTitle2, Align:"Center"} ];
		                InitHeaders(headers, info);
		
		                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
		                             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"com_division",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"divison",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cntr_chss",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                             {Type:"Text",   Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"matching",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                             {Type:"Text",   Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"unmatching",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                             {Type:"Text",   Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"matching_day",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                             {Type:"Text",       Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"unmatching_day",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"chss_ownr_co_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_ownr_co_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                 
		                InitColumns(cols);
		                SetEditable(0);
		                //SetSheetHeight(200);
		                resizeSheet();
		            }
                 break;
         }
     }
     
     function resizeSheet(){
    		ComResizeSheet( sheetObjects[1] );
     }    
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
           case IBSEARCH:      //retrieve
 	            if(validateForm(sheetObj,formObj,sAction)){
 	        	   formObj.f_cmd.value=SEARCH;
 	        	   formObj.chss_pool_cd.value=chss_pool_co_cd.GetSelectCode();
 	        	   sheetObj.SetWaitImageVisible(0);
 			 	   ComOpenWait(true);
 			 	   var sXml=sheetObj.GetSearchData("EES_CGM_1141GS.do" , FormQueryString(formObj));
 	   		       var arrXml=sXml.split("|$$|");
 	         	   sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
 	         	 //  sheetObjects[0].CellBackColor(1,"com_division") = "#E7FAF9";
 	         	 //  sheetObjects[0].CellBackColor(1,"com_division") = "#E7FAF9";
 	         	   sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
 	         	   ComOpenWait(false);
 	            }
	         	break;
       	   case IBSEARCH_ASYNC01:	// CP Combo retrieve
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
				ss=ComCgmXml2ComboString(sXml, "TOTAL");
				var cols=ComCgmXml2ComboString(sXml, "code1", "desc1");
				//IBSHEET GRID outer combo
				makeCPMultiCombo(formObj.chss_pool_co_cd, cols, 0, 0);
		 	  	break;
       	 case IBSEARCH_ASYNC02:	// CP Combo retrieve
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("CGM_CHSS_POOLGS.do?chss_pool_cd="+chss_pool_co_cd.GetSelectCode(), FormQueryString(formObj));
				// data count
			    var dataCount=ComGetTotalRows(sXml);
			    // data existing
			    if(dataCount > 0){
			    	formObj.chss_pool_nm.value=DomXml2String(sXml,"chss_pool_nm");
			    	formObj.pool_mgmt_co_nm.value=DomXml2String(sXml,"pool_mgmt_co_nm");
			    } else {
			    	formObj.chss_pool_nm.value="";
			    }
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
 	 		// combo control, result string, Text Index, Code Index
 	 		makeCPMultiCombo2(chss_pool_co_cd, arrStr1, 0, 0);     
 	 		idx++;        
         }
     }
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 for(var i=1; i<sheetObj.RowCount(); i++){
			sheetObj.SetCellBackColor(i,"com_division","#E7FAF9");
			sheetObj.SetCellBackColor(i,"divison","#E7FAF9");
			sheetObj.SetCellBackColor(i,"cntr_chss","#E7FAF9");
		}
     	with(sheetObj)
     	{
     		if(comboObjects[0].GetSelectText()!= ''){
     			ShowSubSum([{StdCol:"com_division", SumCols:"4|5|7", Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:"com_division=Total", AvgCols:"6"}]);
     		}
     	}
     }
     function sheet2_OnSearchEnd(sheetObj) {
    	 for(var i=1; i<sheetObj.RowCount(); i++){
 			sheetObj.SetCellBackColor(i,"com_division","#E7FAF9");
 			sheetObj.SetCellBackColor(i,"divison","#E7FAF9");
 			sheetObj.SetCellBackColor(i,"cntr_chss","#E7FAF9");
 		}
      }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	     with(formObj){
                 switch(sAction) {
                 	case IBSEARCH:      //retrieve
                 	     if(formObj.chss_pool_co_cd.text==""  ){
                 	    	 ComShowCodeMessage('CGM10009','Pool');
//                 	    	 formObj.chss_pool_co_cd.focus();
                 	    	 return false;
                 	     }
    	             	 if(formObj.mvmt_dt.value==""  ){
    	        	    	 ComShowCodeMessage('CGM10009','Month');
//    	        	    	 formObj.mvmt_dt.focus();
    	        	    	 return false;
    	        	     }
                 	     break;
                 }
             }
             return true;
     }
         /** 
          * Combo Object reset  <br>
          * @param  {object} comboObj	Combo Object
          * @return 
          * @author 
          * @version
          */ 
         function initCombo(comboObj) {
         	switch(comboObj.options.id) {
     	    	case "chss_pool_co_cd":
     	 	 		var cnt=0;
     	  	        with(comboObj) {
     	  	        	Code="";
     	  	            Text="";
     	  	            SetDropHeight(100);
     	  	            SetMultiSelect(0);
     	  	            SetMaxSelect(1);
     	  	            SetEnable(1);
     		            SetMaxLength(20);
     	  	            comboObj.SetUseAutoComplete(1);
     	  	        }
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
             	for (var i=0; i < arrCode.length;i++ ) {
	          		var arrCode3=arrCode[i].split("|");
	          		var arrCode4=arrCode2[i].split("|");
	          		cmbObj.InsertItem(i, arrCode3[codeCol], arrCode3[codeCol]);
	          	}
         	}
         } 
      /** 
       * add combo(POOL COMBO)
       */ 
      function makeCPMultiCombo2(cmbObj, arrStr, txtCol, codeCol) {
    	   cmbObj.RemoveAll();
//            	//ComShowMessage(arrCode2);
        	for (var i=0; i < arrStr.length;i++ ) {
          		var arrCode=arrStr[i].split("|");
          		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
      	    }
       }
    function sheet2_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
 	   if(Col>3 && Col<=7){
 		    var mvmt_dt=document.form.mvmt_dt.value;
 	    	var chss_pool_cd=chss_pool_co_cd.GetSelectCode();
			var chss_ownr_co_cd=sheetObj.GetCellValue(Row, "chss_ownr_co_cd");
			var cntr_ownr_co_cd=sheetObj.GetCellValue(Row, "cntr_ownr_co_cd");
 	    	var chss_pool_nm=document.form.chss_pool_nm.value;
 	    	var pool_mgmt_co_nm=document.form.pool_mgmt_co_nm.value;
 	    	var gubun="";
 	    	if(Col == 4 || Col == 6){
 	    		gubun="M";
 	    	} else {
 	    		gubun="U";
 	    	}
 		    var param="?&mvmt_dt=" + mvmt_dt;           	
 		   	param=param + "&chss_pool_cd=" + chss_pool_cd;
 		   	param=param + "&chss_ownr_co_cd=" + chss_ownr_co_cd;
 		   	param=param + "&cntr_ownr_co_cd=" + cntr_ownr_co_cd;
 		    param=param + "&chss_pool_nm=" + chss_pool_nm;
		   	param=param + "&pool_mgmt_co_nm=" + pool_mgmt_co_nm;
 		    param=param + "&gubun=" + gubun; 
 		    ComOpenPopup('/opuscntr/EES_CGM_1142.do' + param, 900, 530, "", "1,0", true, false);
 	   }
    }
   	/** 
     * Object Keypress event handling  <br>
     * 
     * @param  
     * @return 
     * @author 
     * @version
     */ 
    function obj_keypress(){
   	 obj=event.srcElement;
   	 if(obj.dataformat == null) return;
   	 window.defaultStatus=obj.dataformat;
   	 switch(obj.dataformat) {
   	 	case "ym":
   	 		ComKeyOnlyNumber(obj);
   	        break;
   	 }
    }
     /**
      * Group3 Multi-Combo OnChange event handling <br>
      * @param  {object} ComboObj	mandatory	 Sheet Object
      * @param  {int} 	Index_Code	mandatory
      * @param  {string} Text		mandatory
      * @return 
      * @version
      */ 
     function chss_pool_co_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
    	 document.form.chss_pool_co_cd_text.value = newCode;
     }
      function doActionPageMove(sheetObj, formObj, btnName){
          formObj.f_cmd.value="";
          formObj.method="POST";
          formObj.chss_pool.value=chss_pool_co_cd.GetSelectCode();
          formObj.target="";
          var parentPgmNo = formObj.parent_pgm_no.value;
           if(validateForm(sheetObj,formObj,IBSEARCH)){
        	  formObj.action="EES_CGM_1143.do?pgmNo=EES_CGM_1143&parentPgmNo="+parentPgmNo;
          	  formObj.submit();
          }
      }
       /**
        *  1145 file inserting page open 
        * @return
        */
       function doActionPageMove2(){
    	   var formObj = document.form;
        	if(chss_pool_co_cd.GetSelectCode()==""  ){
    	    	 ComShowCodeMessage('CGM10009','Pool');
//    	    	 formObj.chss_pool_co_cd.focus();
    	    	 return false;
    	     }
        	if(formObj.mvmt_dt.value==""  ){
	   	    	 ComShowCodeMessage('CGM10009','Month');
//	   	    	 formObj.mvmt_dt.focus();
	   	    	 return false;
   	        }
		    var mvmt_dt=document.form.mvmt_dt.value;
 	    	var chss_pool_cd=chss_pool_co_cd.GetSelectCode();
 	    	var pool_mgmt_co_nm=document.form.pool_mgmt_co_nm.value;
    	    var param="?pgmNo=EES_CGM_1145&program_id=1145";
		   	param=param + "&f_cmd=" + SEARCH; 
			param=param + "&mvmt_dt=" + mvmt_dt;           	
		   	param=param + "&chss_pool_co_cd=" + chss_pool_cd;
		   	param=param + "&pool_mgmt_co_nm=" + pool_mgmt_co_nm;
   		    ComOpenPopup('/opuscntr/EES_CGM_1145.do' + param, 700, 490, "", "1,0", true, false);
        }
	/* developer job end */