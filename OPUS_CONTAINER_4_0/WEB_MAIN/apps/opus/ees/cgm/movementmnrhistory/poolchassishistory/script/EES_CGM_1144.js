/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1144.js
*@FileTitle  : Pool Chassis M&R Performance
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
     * @class EES_CGM_1144 : EES_CGM_1144 business script for
     */
   	/* developer job	*/
 // common global variables
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
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;
 				case "btn_New":
 					formObj.reset();
               	    formObj.chss_pool_cd_text.value="";
 					sheetObject1.RemoveAll();
 					sort_OnChange();
 					chss_pool_cd.SetSelectIndex(-1);
 					break;
 				case "btn_DownExcel":
 					if(sheetObject1.RowCount() < 1){//no data
                	 	ComShowCodeMessage("COM132501");
                	 } else{
                		 sheetObject1.Down2Excel();
                	 }
 					break;
				case "btns_Calendar1" :		// Agreement Date (From Date)
	 				var cal=new ComCalendar();
				    if(document.form.sort.value == "1"){
		 				cal.select(formObject.mvmt_dt_fr, "yyyy-MM-dd");
				    } else {
				    	cal.setDisplayType('month');
		 				cal.select(formObject.mvmt_dt_fr, "yyyy-MM");
				    }
					break;  
				case "btns_Calendar2" :		// Agreement Date (From Date)
	 				var cal=new ComCalendar();
	 				 if(document.form.sort.value == "1"){
		 				cal.select(formObject.mvmt_dt_to, "yyyy-MM-dd");
				    } else {
				    	cal.setDisplayType('month');
		 				cal.select(formObject.mvmt_dt_to, "yyyy-MM");
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
         	//
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         	//
             ComEndConfigSheet(sheetObjects[i]);
         }
         formObj=document.form;
   //      axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
   //      axon_event.addListenerFormat('beforeactivate',		'obj_activate',		formObj);
//         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
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
 		 sort_OnChange();
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
         // axon event regist
      // Lease Term Combo Control에  init value  setting.
     	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
     	 doActionIBSheet(sheetObjects[0], document.form, IBRESET);
//     	formObj.chss_pool_cd.focus();
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
		               var HeadTitle1="|Seq.|S. Provider Name|S. Provider Location (FV-Office)|Invoice No.|Invoice Date|Chassis No.|MST chk|Repair Request Date|Repair Complete Date|Component|Location|Damage|Repair Type|Repair Inspection Type|Supplied Comp.|Hours|Labor Cost|Material Cost|Tax Amount|Total Cost";
		
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:5, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq",               KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Text",     Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"vndr_nm" },
		                      {Type:"Text",     Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"vndr_loc_nm" },
		                      {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_no" },
		                      {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_cre_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                      {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_no" },
		                      {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"mst_chk" },
		                      {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                      {Type:"Date",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"rpr_cmpl_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                      {Type:"Text",     Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"chss_cmpo_nm" },
		                      {Type:"Text",     Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"chss_loc_nm" },
		                      {Type:"Text",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"dmg_desc" },
		                      {Type:"Text",     Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"rpr_desc" },
		                      {Type:"Text",     Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"rpr_insp_tp_desc" },
		                      {Type:"Text",     Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"spl_cmpo_tp_cd" },
		                      {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rpr_hrs",           KeyField:0,   CalcLogic:"",   Format:"Float" },
		                      {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"lbr_cost_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		                      {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"mtrl_cost_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"tax_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cost_ttl_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 } ];
		                
		               InitColumns(cols);
		               SetEditable(0);
//		               SetSheetHeight(335);
		               resizeSheet( );
		          	}
         		break;
         }
     }
	function resizeSheet( ){
		ComResizeSheet( sheetObjects[0] );
	}
   	// handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 			case IBSEARCH:      //retrieve
 				if(!validateForm(sheetObj,formObj,sAction)) return;
	 			    formObj.f_cmd.value=SEARCH;
	 			    sheetObj.SetWaitImageVisible(0);
			 	    ComOpenWait(true);
			 	    var sXml=sheetObj.GetSearchData("EES_CGM_1144GS.do" , FormQueryString(formObj));
	  		        var arrXml=sXml.split("|$$|");
	  		        var Xml=(arrXml[0]);
	  		        Summary_set(Xml,formObj);
	  		        //alert(Xml);
	        	    sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
	        	    ComOpenWait(false);
 				break;
	       case IBSEARCH_ASYNC01:	// CP Combo retrieve
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
				ss=ComCgmXml2ComboString(sXml, "TOTAL");
				var cols=ComCgmXml2ComboString(sXml, "code1", "desc1");
				//IBSHEET GRID outer combo
				makeCPMultiCombo(chss_pool_cd, cols, 0, 0);
	 	  	break;
	       	case IBSEARCH_ASYNC02:	// CP Combo retrieve
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("CGM_CHSS_POOLGS.do?chss_Pool_Cd="+formObj.chss_pool_cd_text.value, FormQueryString(formObj));
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
			 		makeCPMultiCombo2(chss_pool_cd, arrStr1, 0, 0);     
			 		idx++;      
//				  	
			 		break;
         }
     }
     /**
      * Summary setting 
      * @param sXml
      * @param formObj
      * @return
      */
     function Summary_set(Xml,formObj){
//    	 formObj.chss_cnt.value  =    ComAddComma2(DomXml2String(Xml, "chss_cnt")+'', "#,###.00"); 
    	 formObj.chss_cnt.value=DomXml2String(Xml, "chss_cnt"); 	
    	 formObj.chss_lbr.value=DomXml2String(Xml, "chss_lbr");
    	 formObj.chss_mtrl.value=DomXml2String(Xml, "chss_mtrl");
    	 formObj.chss_amt.value=DomXml2String(Xml, "chss_amt"); 
    	 formObj.chss_ttl.value=DomXml2String(Xml, "chss_ttl"); 
    	 formObj.chss_cost.value=DomXml2String(Xml, "chss_cost");
    	 formObj.un_chss_cnt.value=DomXml2String(Xml, "un_chss_cnt"); 
    	 formObj.un_chss_lbr.value=DomXml2String(Xml, "un_chss_lbr");  
    	 formObj.un_chss_mtrl.value=DomXml2String(Xml, "un_chss_mtrl"); 
    	 formObj.un_chss_amt.value=DomXml2String(Xml, "un_chss_amt");  
    	 formObj.un_chss_ttl.value=DomXml2String(Xml, "un_chss_ttl");  
    	 formObj.un_chss_cost.value=DomXml2String(Xml, "un_chss_cost"); 
    	 //alert(ComAddComma(formObj.chss_cnt.value));
//    	 formObj.chss_cnt.value  =    ComAddComma(formObj.chss_cnt.value);
//      	 formObj.chss_lbr.value  =    ComAddComma2(DomXml2String(Xml, "chss_lbr")+'', "#,###.00");
//    	 formObj.chss_mtrl.value =    ComAddComma2(DomXml2String(Xml, "chss_mtrl")+'', "#,###.00");
//    	 formObj.chss_amt.value  =    ComAddComma2(DomXml2String(Xml, "chss_amt")+'', "#,###.00"); 
//    	 formObj.chss_ttl.value  =    ComAddComma2(DomXml2String(Xml, "chss_ttl")+'', "#,###.00"); 
//    	 formObj.chss_cost.value =    ComAddComma2(DomXml2String(Xml, "chss_cost")+'', "#,###.00");
//    	 
//    	 formObj.un_chss_cnt.value  =    ComAddComma2(DomXml2String(Xml, "un_chss_cnt")+'', "#,###.00");  
//    	 formObj.un_chss_cnt.value  =    DomXml2String(Xml, "un_chss_cnt"); 
//    	 formObj.un_chss_cnt.value  =    ComAddComma(formObj.un_chss_cnt.value);
//    	 formObj.un_chss_lbr.value  =    ComAddComma2(DomXml2String(Xml, "un_chss_lbr")+'', "#,###.00");  
//    	 formObj.un_chss_mtrl.value =    ComAddComma2(DomXml2String(Xml, "un_chss_mtrl")+'', "#,###.00"); 
//    	 formObj.un_chss_amt.value  =    ComAddComma2(DomXml2String(Xml, "un_chss_amt")+'', "#,###.00");  
//    	 formObj.un_chss_ttl.value  =    ComAddComma2(DomXml2String(Xml, "un_chss_ttl")+'', "#,###.00");  
//    	 formObj.un_chss_cost.value =    ComAddComma2(DomXml2String(Xml, "un_chss_cost")+'', "#,###.00"); 
     }
      /**
       * handling process for input validation
       */
      function validateForm(sheetObj,formObj,sAction){
     	     with(formObj){
                  switch(sAction) {
                  	case IBSEARCH:      //retrieve
	                  	if(document.form.chss_pool_cd_text.value == ''){
	           				ComShowCodeMessage('CGM10004','Pool ');
//	           				formObj.chss_pool_cd.focus();
	           				return false;
	           			}
	                  	if(formObj.mvmt_dt_fr.value == ''){
	           				ComShowCodeMessage('CGM10004','Period ');
//	           				formObj.mvmt_dt_fr.focus();
	           				return false;
	           			}	
	    		 		if(formObj.mvmt_dt_to.value == ''){
	           				ComShowCodeMessage('CGM10004','Period ');
//	           				formObj.mvmt_dt_to.focus();
	           				return false;
	           			}
	    		 		 var dt_str=ComReplaceStr(document.form.mvmt_dt_fr.value,"-","");
	        			 var dt_end=ComReplaceStr(document.form.mvmt_dt_to.value,"-","");
	    	    		if(dt_str != '' && dt_end != ''){
	    	    			if(dt_end < dt_str){
	    	    				ComShowCodeMessage('COM12133','To date','From date','Period');
	    	    				mvmt_dt_fr.value='';
//	    	    				formObj.mvmt_dt_fr.focus();
	    	    				return false;
	    	    			}
	    	    		}
                  	    break;
                  }
              }
              return true;
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
        	   if(obj.name=="mvmt_dt_fr"  ){
        		 with(formObj){
        			 var creDtFr=ComReplaceStr(mvmt_dt_fr.value,"-","");
    	        }
    	        ComChkObjValid(event.srcElement);
        	   }
    	       if(obj.name=="mvmt_dt_to"  ){
    	     		 with(formObj){
    	     			 var creDtFr=ComReplaceStr(mvmt_dt_to.value,"-","");
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
           * Combo Object reset  <br>
           * @param  {object} comboObj	Combo Object
           * @return 
           * @author 
           * @version
           */ 
          function initCombo(comboObj) {
          	switch(comboObj.options.id) {
      	    	case "chss_pool_cd":
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
         function makeCPMultiCombo2(cmbObj, arrStr, txtCol, codeCol) {
            	cmbObj.RemoveAll();
            	if(arrStr == undefined ){
            		cmbObj.SetSelectIndex("" ,false);
            	} else {
                	for (var i=0; i < arrStr.length;i++ ) {
                		var arrCode=arrStr[i].split("|");
                  		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
    	          	}
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
	function chss_pool_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
		document.form.chss_pool_cd_text.value = newCode;
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
    	 	case "ymd":
    	 		ComKeyOnlyNumber(obj);
    	        break;
    	 }
     }
      function sort_OnChange(){
    	  document.form.mvmt_dt_fr.value="";
    	  document.form.mvmt_dt_to.value="";
       	  if(document.form.sort.value == "1"){
       		  document.getElementById("mvmt_dt_fr").setAttribute("maxLength", 8);
       		  document.getElementById("mvmt_dt_fr").setAttribute("dataformat", "ymd");
       	      document.getElementById("mvmt_dt_to").setAttribute("maxLength", 8);
       	      document.getElementById("mvmt_dt_to").setAttribute("dataformat", "ymd");
       	  } else {
       		  document.getElementById("mvmt_dt_fr").setAttribute("maxLength", 6);
       		  document.getElementById("mvmt_dt_fr").setAttribute("dataformat", "ym");
     	      document.getElementById("mvmt_dt_to").setAttribute("maxLength", 6);
     	      document.getElementById("mvmt_dt_to").setAttribute("dataformat", "ym");
       	  }
      }
	/* developer job end */