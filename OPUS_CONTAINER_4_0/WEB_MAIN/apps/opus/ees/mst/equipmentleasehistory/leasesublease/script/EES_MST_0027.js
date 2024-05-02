/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0027.js
*@FileTitle  : Container Status Report 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 /**
 * @fileoverview 
 * @author 
 */
/**
 * @extends 
 * @class EES_MST_0027 : business script for EES_MST_0027
 */
    function EES_MST_0027() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	 // common static variable
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
	 // Event handler processing by button name */
     function processButtonClick(){
 		  var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
          try {
     		var srcName = ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
             	case "btns_calendar1": 
             	    if (!formObject.ls_flg.checked){
						var cal=new ComCalendar();
						cal.setDisplayType('month');
						cal.select(formObject.evnt_dt11, 'yyyy-MM');           	 
	             	 	break;
             	    }
             	case "btns_calendar2": 
         	    	if (!formObject.ls_flg.checked){
						var cal=new ComCalendar();
						cal.setDisplayType('month');
						cal.select(formObject.evnt_dt22, 'yyyy-MM');
         	    	}
          	 	break;    
				case "ComOpenPopupWithTargetLoc":
					var tmp=formObject.loc_tp_cd.value;
					if(tmp == "R")
					{
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 470,"rcc_cd:loc_cd", "0,0,1,1,1,1,1", true);
					}else if(tmp == "L")
					{
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 470,"lcc_cd:loc_cd", "0,0,1,1,1,1,1", true);
					}else if(tmp == "S")
					{
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 470,"scc_cd:loc_cd", "0,0,1,1,1,1,1", true);
					}
				break;
				case "Retrieve":
					formObject.evnt_dt1.value=ComReplaceStr(formObject.evnt_dt11.value, "-", "");
					formObject.evnt_dt2.value=ComReplaceStr(formObject.evnt_dt22.value, "-", "");
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				case "New":
					ComSetFocus(formObj.evnt_dt11);					
					formObj.loc_cd.className="input2";					
			        formObj.loc_cd.readOnly=true;
			        formObj.ComOpenPopupWithTargetLoc.enable = false;
				    ComResetAll();
					sheetObject1.RemoveAll();
					obj_change();
					//formObj.ComOpenPopupWithTargetLoc.SetEnable(0);
	    			formObj.loc_cd.value='';
	    		    formObj.loc_cd.readOnly=true;
					formObj.evnt_dt11.className="input1";
	    		    formObj.evnt_dt22.className="input1";
	    		    formObj.loc_tp_cd.readOnly=true; 
		  			 formObj.loc_tp_cd.disabled=false;
	    		    formObj.loc_tp_cd.className="input1";	
				break;
				case "Down_Excel":
					if(sheetObject1.RowCount() < 1){
						ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	sheetObject1.Down2Excel();
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
      * registering IBsheet Object as list
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
    	 formObj=document.form;
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet(sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
     	ComSetFocus(formObj.evnt_dt11);
        document.getElementById("loc_cd").className="input2";         
        formObj.loc_cd.readOnly=true;
        formObj.ComOpenPopupWithTargetLoc.enable = false;
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);   
        axon_event.addListener('change', 'obj_change' , 'loc_tp_cd');     
    	axon_event.addListener('click', 'obj_click' , 'ls_flg');
     }
     
    /** 
     * handling event deactivate of Object <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
    function obj_deactivate(){
       var formObj=document.form;
       obj= ComGetEvent();
       if(obj.name=="evnt_dt11"  ){        			
          with(formObj){ 	        			
             var creDtFr=ComReplaceStr(evnt_dt11.value,"-","");
          } 	        	
 	      ComChkObjValid(ComGetEvent());
       }
       if(obj.name=="evnt_dt22"  ){ 			
          with(formObj){ 	        			
             var creDtFr=ComReplaceStr(evnt_dt22.value,"-","");
 	      } 	        	
 	      ComChkObjValid(ComGetEvent());
       }        	
    }
    /** 
     * handling event change of Object  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */  
    function obj_change(){
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0]; 
    	 obj= ComGetEvent();
    	 switch(ComGetEvent("name")){
    	   case "loc_tp_cd":
    		   if(formObj.loc_tp_cd.value == 'A'){    			   
    			   formObj.ComOpenPopupWithTargetLoc.SetEnable(0);
    			   formObj.loc_cd.value='';
    		       formObj.loc_cd.readOnly=true;
				   document.getElementById("loc_cd").className="input2";    		       
    		   }else{
    		       formObj.loc_cd.readOnly=false;    			   
    			   formObj.ComOpenPopupWithTargetLoc.SetEnable(1);
				   document.getElementById("loc_cd").className="input";    			   
    		   }
    		   break;
    	 }   
    } 
    function obj_click(){
	   	 var formObj=document.form;
		 obj= ComGetEvent();
    	 switch(ComGetEvent("name")){
	  	   case "ls_flg":
	  		   if(formObj.ls_flg.checked){
	  			 document.getElementById("loc_tp_cd").className="input";
	  			 document.getElementById("evnt_dt11").className="input";
	  			 document.getElementById("evnt_dt22").className="input";
	  			 formObj.ls_flg.value="Y";
	  			 formObj.evnt_dt11.value="";
	  			 formObj.evnt_dt22.value="";
	  			 formObj.loc_tp_cd.value="A";
	  			 formObj.loc_tp_cd.readOnly=false; 
	  			 formObj.loc_tp_cd.disabled=true;
	  			 formObj.evnt_dt11.readOnly=false;
	  			 formObj.evnt_dt11.disabled=true;
	  			 formObj.evnt_dt22.readOnly=false;
	  			 formObj.evnt_dt22.disabled=true;
	  		   } else {
	  			 document.getElementById("loc_tp_cd").className="input1";  
	  			 document.getElementById("evnt_dt11").className="input1";
	  			 document.getElementById("evnt_dt22").className="input1";	  		
	  			 formObj.ls_flg.value="N";
	  			 formObj.loc_tp_cd.readOnly=true; 
	  			 formObj.loc_tp_cd.disabled=false;
	  			 formObj.evnt_dt11.readOnly=true;
	  			 formObj.evnt_dt11.disabled=false;
	  			 formObj.evnt_dt22.readOnly=true;
	  			 formObj.evnt_dt22.disabled=false;
	  		   }
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
       switch(sheetNo) {
          case 1:      //sheet1 init
        	    with(sheetObj){
		            var HeadTitle="TP|CNTR No.|TP/SZ|Term|AGMT No.|Contract No.|Lessor|Lessor Name|F/M|Pre\nMovement|Lost Date|Lost\nYard|Found Date|Found\nYard|Days";
		            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		            var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
		            var cols = [
                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },     
		                   {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tp_sz",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"term",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"container_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"lessor",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"lessor_name",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"f_m",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pre_movemert",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"lst_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"lst_yd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"fnd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"fnd_yd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Int",       Hidden:0,  Width:20,   Align:"Right",   ColMerge:0,   SaveName:"days",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		            InitColumns(cols);
		            SetEditable(0);
		           // SetSheetHeight(410);
		            resizeSheet();
                  }
             break;
         }
     }
     // handling process for sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) { 					
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);					
					formObj.f_cmd.value=SEARCH;
	 				var xml="";					
	 				xml=sheetObj.GetSearchData("EES_MST_0027GS.do", FormQueryString(formObj));
	 				sheetObj.LoadSearchData(xml,{Sync:0} );
	 				ComOpenWait(false);
				}
			break; 					
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){
     		 switch(sAction) {
     		 	case IBSEARCH:
     		 		if (!formObj.ls_flg.checked){
	     		 		if(evnt_dt11.value == ''){
	            				ComShowCodeMessage('MST00001','Period ');
	            				evnt_dt11.focus();
	            				return false;
	            		}	
	     		 		if(evnt_dt22.value == ''){
	            				ComShowCodeMessage('MST00001','Period ');
	            				evnt_dt22.focus();
	            				return false;
	            		}
	     		 		var dt1=ComReplaceStr(evnt_dt11.value,"-","");
	         			var dt2=ComReplaceStr(evnt_dt22.value,"-","");
						if(dt1 != '' && dt2 != ''){
	     	    			if(dt2 < dt1){
	     	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	     	    				evnt_dt11.value='';
	     	    				evnt_dt11.focus();
	     	    				return false;
	     	    			}
	     	    		}
     		 		}
					if(loc_tp_cd.value != 'A'){
						if(loc_cd.value == ''){
								ComShowCodeMessage('MST00001','Location');
								loc_cd.focus();								
								return false;
						}
	        		    if(loc_cd.value.trim().length > 0){
	        			   if(loc_cd.value.trim().length < 5){
	        				   ComShowCodeMessage('MST01019','Location');
							   loc_cd.focus();	        				   
	        				   return false;
	        			   }
	        		    }																
					}
           		   break;
			 }
		  }
		  return true;
	 }
      /** 
      * handling event deactivate of Object <br>
      * @param  
      * @return 
      * @author 
      * @version 
      */
      function domFunFocusDel(a)
      {
      	var formObj=document.form;
        	 obj= ComGetEvent();
        	if(obj.name=="evnt_dt11"  ){
        		document.form.evnt_dt11.value=ComReplaceStr(document.form.evnt_dt11.value,"-","");
            }
          if(obj.name=="evnt_dt22"  ){
          		document.form.evnt_dt22.value=ComReplaceStr(document.form.evnt_dt22.value,"-","");
           }
      }      

  	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	}