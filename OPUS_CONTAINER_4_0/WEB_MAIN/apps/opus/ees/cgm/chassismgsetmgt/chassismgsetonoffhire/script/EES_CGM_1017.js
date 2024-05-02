/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1017.jsp
*@FileTitle  : 분실 또는 되찾은 Chassis Status를 Creation 하는 화면
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_1017 : ees_cgm_1017 business script for
     */
	/* developer job	*/
 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1; 
 var sheetObjects=new Array();
 var sheetCnt=0;
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
                 case "btn_new":
                	 objectClear();
                     break; 
                 case "btn_save":
 					 doActionIBSheet(sheetObject1,formObject,IBSAVE);
                     break;
                 case "btns_Calendar1" :		// Agreement Date (From Date)
	                 if(formObj.yardChk[0].checked == true){
	                	 var cal=new ComCalendar();
	                	 cal.setEndFunction("processEndCal");  
	 	 				 cal.select(formObject.l_evnt_dt, "yyyy-MM-dd");
	                 }
                 	break;	
	 			 case "btns_Calendar2" :		// Agreement Date (To Date)
	 	    		if(formObj.yardChk[1].checked == true){
	                	 var cal=new ComCalendar();
	                	 cal.setEndFunction("processEndCal");  
	 	 				 cal.select(formObject.f_evnt_dt, "yyyy-MM-dd");
	                 }
	 			 	break;         
	 			case "ComOpenPopupWithTargetYard1":
	 				if(formObj.yardChk[0].checked == true){
	 					ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 540, "3:l_evnt_yd_cd", "1,0,1,1,1,1,1", true);
//	 					Matched_Chk('Yard');
	                }
          			break;
	 			case "ComOpenPopupWithTargetYard2":
          			if(formObj.yardChk[1].checked == true){
	 					ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 540, "3:f_evnt_yd_cd", "1,0,1,1,1,1,1", true);
//	 					Matched_Chk('Yard');
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
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
    	  for(i=0;i<sheetObjects.length;i++){
       		//
           ComConfigSheet (sheetObjects[i] );
           initSheet(sheetObjects[i],i+1);
         //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
       }
     	  var formObj=document.form;
//     	  axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
     	  axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
//     	  axon_event.addListenerFormat('beforeactivate',	  'obj_activate',		formObj);
     	//  axon_event.addListener('change', 'obj_change' , 'l_evnt_yd_cd','f_evnt_yd_cd','eq_no' ); 
     	  axon_event.addListenerForm('change', 'obj_change' ,formObj ); 
//     	  axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
//     	  axon_event.addListenerForm('focusout', 'obj_focusout',formObj);
          initControl(sheetObjects[0]);   
     }
      /**
       * registering IBSheet Object as list
       * adding process for list in case of needing batch processing with other items
       * defining list on the top of source
       */
      function setSheetObject(sheet_obj){
         sheetObjects[sheetCnt++]=sheet_obj;
      }
       function processEndCal(){
      	 var form=document.form;
      	 var dt=ComReplaceStr(form.form_day.value,"-","");
      	 var dt2="";
      	 var dt3=ComReplaceStr(form.sts_evnt_dt.value,"-","");
      	 var dt4=ComReplaceStr(form.mvmt_dt.value,"-","");
      	 if(form.l_evnt_dt.value !=""){
      		 dt2=ComReplaceStr(form.l_evnt_dt.value,"-","");
      		 if(dt2 > dt){
              	 form.l_evnt_dt.value="";
//              	 form.l_evnt_dt.focus();
              	 ComShowCodeMessage("CGM10058");
              	 return ;
       	    } 
      		if(dt2 < dt3){
            	 form.l_evnt_dt.value="";
//            	 form.l_evnt_dt.focus();
            	 ComShowCodeMessage("CGM10057");
            	 return ;
     	    } 
     		if(dt2 < dt4){
            	 form.l_evnt_dt.value="";
//            	 form.l_evnt_dt.focus();
            	 ComShowCodeMessage("CGM10057");
            	 return ;
     	    } 
      	 } else {
      		 dt2=ComReplaceStr(form.f_evnt_dt.value,"-","");
      		 if(dt2 > dt){
              	 form.f_evnt_dt.value="";
//              	 form.f_evnt_dt.focus();
              	 ComShowCodeMessage("CGM10058");
              	 return ;
       	    } 
      		if(dt2 < dt3){
      			 form.f_evnt_dt.value="";
//             	 form.f_evnt_dt.focus();
                 ComShowCodeMessage("CGM10055");
	           	 return ;
    	    } 
      	 }
       }
        // work javascript OnFocusOut event handling
        function obj_focusout() {
        	switch(event.srcElement.name){ 
        	case "l_evnt_dt":
        		 var form=document.form;
	          	 var dt=ComReplaceStr(form.form_day.value,"-","");
	          	 var dt2="";
	          	 var dt3=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
	          	 var dt4=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.mvmt_dt.value,"-",""),":","")," ","");
	          	 var dt5=ComReplaceStr(form.l_evnt_dt_hm.value,":","");
	          	 if(form.l_evnt_dt.value !="" && form.l_evnt_dt_hm.value !="" ){
	          		 dt2=ComReplaceStr(form.l_evnt_dt.value,"-","");
		  	       	 if(dt2  > dt){
		             	 form.l_evnt_dt.value="";
		             	 form.l_evnt_dt_hm.value="";
//		             	 form.l_evnt_dt.focus();
		             	 ComShowCodeMessage("CGM10058");
		             	 return ;
		      	     } 
	          		if(dt2 + dt5 <= dt3){
	                 	 form.l_evnt_dt.value="";
	                 	 form.l_evnt_dt_hm.value="";
//	                 	 form.l_evnt_dt.focus();
	                 	 ComShowCodeMessage("CGM10057");
	                 	 return ;
	          	    } 
	          		if(dt2+ dt5 <= dt4){
	                 	 form.l_evnt_dt.value="";
	                 	 form.l_evnt_dt_hm.value="";
//	                 	 form.l_evnt_dt.focus();
	                 	 ComShowCodeMessage("CGM10057");
	                 	 return ;
	          	    } 
	          	 }
	  	 		break;
        	case "l_evnt_dt_hm":
        		var form=document.form;
	          	 var dt=ComReplaceStr(form.form_day.value,"-","");
	          	 var dt2="";
	          	 var dt3=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
	          	 var dt4=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.mvmt_dt.value,"-",""),":","")," ","");
	          	 var dt5=ComReplaceStr(form.l_evnt_dt_hm.value,":","");
	          	 if(form.l_evnt_dt.value !="" && form.l_evnt_dt_hm.value !="" ){
	          		dt2=ComReplaceStr(form.l_evnt_dt.value,"-","");
		  	       	 if(dt2  > dt){
		             	 form.l_evnt_dt.value="";
		             	 form.l_evnt_dt_hm.value="";
//		             	 form.l_evnt_dt.focus();
		             	 ComShowCodeMessage("CGM10058");
		             	 return ;
		      	     } 
	          		if(dt2 + dt5 <= dt3){
	                 	 form.l_evnt_dt.value="";
	                 	 form.l_evnt_dt_hm.value="";
//	                 	 form.l_evnt_dt.focus();
	                 	 ComShowCodeMessage("CGM10057");
	                 	 return ;
	          	    } 
	          		if(dt2+ dt5 <= dt4){
	                 	 form.l_evnt_dt.value="";
	                 	 form.l_evnt_dt_hm.value="";
//	                 	 form.l_evnt_dt.focus();
	                 	 ComShowCodeMessage("CGM10057");
	                 	 return ;
	          	    } 
	          	 }
	  	 		break;
        	case "f_evnt_dt":
	       		 var form=document.form;
	  	       	 var dt=ComReplaceStr(form.form_day.value,"-","");
	  	       	 var dt2="";
	  	         var dt3=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
	  	         var dt5=ComReplaceStr(form.f_evnt_dt_hm.value,":","");
	  	       	 if(form.f_evnt_dt.value !="" && form.f_evnt_dt_hm.value !="" ){
	  	       		 dt2=ComReplaceStr(form.f_evnt_dt.value,"-","");
		  	       	 if(dt2 > dt){
		             	 form.f_evnt_dt.value="";
		             	 form.f_evnt_dt_hm.value="";
//		             	 form.f_evnt_dt.focus();
		             	 ComShowCodeMessage("CGM10058");
		             	 return ;
		      	     } 
	  	       		 if(dt2+dt5 <= dt3){
			           	 form.f_evnt_dt.value="";
		             	 form.f_evnt_dt_hm.value="";
//			           	 form.f_evnt_dt.focus();
			             ComShowCodeMessage("CGM10055");
			           	 return ;
	  	       		 } 
	  	       	 }
	  	 		 break;
        	case "f_evnt_dt_hm":
	       		 var form=document.form;
	  	       	 var dt=ComReplaceStr(form.form_day.value,"-","");
	  	       	 var dt2="";
	  	         var dt3=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
	  	         var dt5=ComReplaceStr(form.f_evnt_dt_hm.value,":","");
	  	       	 if(form.f_evnt_dt.value !="" && form.f_evnt_dt_hm.value !="" ){
	  	       		 dt2=ComReplaceStr(form.f_evnt_dt.value,"-","");
		  	       	 if(dt2 > dt){
		             	 form.f_evnt_dt.value="";
		             	 form.f_evnt_dt_hm.value="";
//		             	 form.f_evnt_dt.focus();
		             	 ComShowCodeMessage("CGM10058");
		             	 return ;
		      	     } 
	  	       		 if(dt2+dt5 <= dt3){
			           	 form.f_evnt_dt.value="";
		             	 form.f_evnt_dt_hm.value="";
//			           	 form.f_evnt_dt.focus();
			             ComShowCodeMessage("CGM10055");
			           	 return ;
	  	       		 } 
	  	       	 }
	  	 		 break;
    	 	case "l_evnt_yd_cd":
    	 		var formObj=document.form;
    	    	var sheetObj=sheetObjects[0];    	 		
	    	    var l_evnt_yd_cd;
    	    	l_evnt_yd_cd=formObj.l_evnt_yd_cd.value;
    	    	if (l_evnt_yd_cd.length == 7) {
    	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
    	    	}
    	    	break;	 	
    	 	case "f_evnt_yd_cd":
    	 		var formObj=document.form;
    	    	var sheetObj=sheetObjects[0];    	 		
	    	    var f_evnt_yd_cd;
    	    	f_evnt_yd_cd=formObj.f_evnt_yd_cd.value;
    	    	if (f_evnt_yd_cd.length == 7) {
    	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
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
		                var HeadTitle="|Location|Term|Lessor|Total|SF2|SL2|TA2|SF4|GN4|CB4|GN5|EG5|EG8|ZT4";
		                var headCount=ComCountHeadTitle(HeadTitle);
		
		                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                var headers = [ { Text:HeadTitle, Align:"Center"} ];
		                InitHeaders(headers, info);
		
		                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"agmt_lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"eq_aset_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"l_evnt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"f_evnt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"l_evnt_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"f_evnt_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"sts_evnt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"zt4",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                 
		                InitColumns(cols);
		                SetEditable(1);
//		                SetSheetHeight(170);
		                resizeSheet( sheetObj );
		                SetVisible(false);
                     }
                  break;
          }
      }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
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
         // 초기 focus
//         formObj.eq_no.focus();
//         formObj.l_evnt_dt.disabled = true;
//         formObj.f_evnt_dt.disabled = false;
         yard_Chk();
     }
      /**
       * Form  Date yard control
       * @return
       * @author 
       * @version 
       */
      function yard_Chk(){
    	  formObj=document.form;
    	  var l_chk ,f_chk;
    	  var l_cName,f_cName;
    	  if(formObj.yardChk[0].checked == true){
    		  l_chk=false;
    		  f_chk=true;
    		  l_cName="input1";
    		  f_cName="input2";
    	  } else {
       		  l_chk=true;
    		  f_chk=false;
    		  l_cName="input2";
    		  f_cName="input1";
    	  }
    	  formObj.l_evnt_dt.readOnly=l_chk;
          formObj.l_evnt_yd_cd.readOnly=l_chk;
          formObj.l_evnt_dt_hm.readOnly=l_chk;
          formObj.f_evnt_dt.readOnly=f_chk;
          formObj.f_evnt_yd_cd.readOnly=f_chk;
          formObj.f_evnt_dt_hm.readOnly=f_chk;
          formObj.l_evnt_dt.value="";
          formObj.l_evnt_yd_cd.value="";
          formObj.l_evnt_dt_hm.value="";
          formObj.f_evnt_dt.value="";
          formObj.f_evnt_yd_cd.value="";
          formObj.f_evnt_dt_hm.value="";
          ComEnableObject(formObj.btns_Calendar1, f_chk);
          ComEnableObject(formObj.btns_Calendar2, l_chk);
          ComEnableObject(formObj.ComOpenPopupWithTargetYard1, f_chk);
          ComEnableObject(formObj.ComOpenPopupWithTargetYard2, l_chk);
          formObj.l_evnt_dt.className=l_cName;
          formObj.l_evnt_yd_cd.className=l_cName;
          formObj.l_evnt_dt_hm.className=l_cName;
          formObj.f_evnt_dt.className=f_cName;
          formObj.f_evnt_yd_cd.className=f_cName;
          formObj.f_evnt_dt_hm.className=f_cName;
      }
       /** 
        * Object deactivate event handling  <br>
        * @param  
        * @return 
        * @author 
        * @version 2009.05.20
        */
       function obj_deactivate(){
      	 var formObj=document.form;
      	 obj=event.srcElement;
      	 if(obj.name=="l_evnt_dt"  ){
      		 with(formObj){
      			 var creDtFr=ComReplaceStr(l_evnt_dt.value,"-","");
   	        }
   	        ComChkObjValid(event.srcElement);
          }
        	if(obj.name=="f_evnt_dt"  ){
     		 with(formObj){
     			 var creDtFr=ComReplaceStr(l_evnt_dt.value,"-","");
   	        }
   	        ComChkObjValid(event.srcElement);
         }
        	if(obj.name=="l_evnt_dt_hm"  ){
         		 with(formObj){
         			 var creDtFr=ComReplaceStr(l_evnt_dt_hm.value,":","");
      	        }
         		 ComChkObjValid(event.srcElement);
            }
        	if(obj.name=="f_evnt_dt_hm"  ){
         		 with(formObj){
         			 var creDtFr=ComReplaceStr(f_evnt_dt_hm.value,":","");
      	        }
         		 ComChkObjValid(event.srcElement);
            }
       }
       /** 
        * Object deactivate event handling  <br>
        * @param  
        * @return 
        * @author 
        * @version 2009.05.20
        */
        function domFunFocusDel(a)
        {
        	var formObj=document.form;
          	 obj=event.srcElement;
          	if(obj.name=="l_evnt_dt"  ){
          		document.form.l_evnt_dt.value=ComReplaceStr(document.form.l_evnt_dt.value,"-","");
              }
            if(obj.name=="f_evnt_dt"  ){
            		document.form.f_evnt_dt.value=ComReplaceStr(document.form.l_evnt_dt.value,"-","");
             }
           //ComShowMessage("domFunFocusDel");
        }
      	/** 
         * Object Keypress event handling  <br>
         * @param  
         * @return 
         * @author 
         * @version 
         */ 
        function obj_keypress(){
	       	 obj=ComGetEvent();
	       	 if(obj.dataformat == null) return;
	       	 window.defaultStatus=obj.dataformat;
	       	 switch(obj.dataformat) {
	       	 	case "ymd":
	       	 		ComKeyOnlyNumber(obj);
	       	        break;
        	 	case "hm":
        	 		ComKeyOnlyNumber(obj);
        	        break;
	       	    case "eng":
	       	    	if(obj.name=="l_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
	       	        else ComKeyOnlyAlphabet('upper');
	       	        break;
	       	    case "engup":
	       	        if(obj.name=="f_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
	       	        else ComKeyOnlyAlphabet('upper');
	       	        break;
	       	    case "engup2":	       	    	
	       	        if(obj.name=="eq_no") ComKeyOnlyAlphabet('uppernum')
	       	        else ComKeyOnlyAlphabet('upper');
	       	        break;
	       	 }
        }
         /**
          *  init object 
          */
         function objectClear(){
  	       	var formObj=document.form;
  	       	formObj.eq_no.value="";
  	       	formObj.eq_tpsz_cd.value="";
  	        formObj.agmt_lstm_cd.value="";
  	       	formObj.vndr_seq.value="";
  	  	    formObj.vndr_lgl_eng_nm.value="";
  	  	    formObj.eq_aset_sts_cd.value="";
	  	    formObj.chss_mvmt_sts_cd.value="";
	  	    formObj.sts_evnt_dt.value="";
	  	    formObj.mvmt_dt.value="";
	  	    yard_Chk();
         }
             /** 
     * Object change event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */  
    function obj_change(){
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0]; 
    	 obj=event.srcElement;
    	 switch(ComGetEvent("name")){
    	 case "eq_no":
  		   if(formObj.eq_no.value != ''){
 	 			doActionIBSheet(sheetObj, formObj, IBSEARCH);
 	 			break;
 	 		}
    	 case "l_evnt_dt":
    		 var form=document.form;
          	 var dt=ComReplaceStr(form.form_day.value,"-","");
          	 var dt2="";
          	 var dt3=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
          	 var dt4=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.mvmt_dt.value,"-",""),":","")," ","");
          	 var dt5=ComReplaceStr(form.l_evnt_dt_hm.value,":","");
          	 if(form.l_evnt_dt.value !="" && form.l_evnt_dt_hm.value !="" ){
          		 dt2=ComReplaceStr(form.l_evnt_dt.value,"-","");
	  	       	 if(dt2  > dt){
	             	 form.l_evnt_dt.value="";
	             	 form.l_evnt_dt_hm.value="";
//	             	 form.l_evnt_dt.focus();
	             	 ComShowCodeMessage("CGM10058");
	             	 return ;
	      	     } 
          		if(dt2 + dt5 <= dt3){
                 	 form.l_evnt_dt.value="";
                 	 form.l_evnt_dt_hm.value="";
//                 	 form.l_evnt_dt.focus();
                 	 ComShowCodeMessage("CGM10057");
                 	 return ;
          	    } 
          		if(dt2+ dt5 <= dt4){
                 	 form.l_evnt_dt.value="";
                 	 form.l_evnt_dt_hm.value="";
//                 	 form.l_evnt_dt.focus();
                 	 ComShowCodeMessage("CGM10057");
                 	 return ;
          	    } 
          	 }
  	 		break;
    	case "l_evnt_dt_hm":
    		var form=document.form;
          	 var dt=ComReplaceStr(form.form_day.value,"-","");
          	 var dt2="";
          	 var dt3=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
          	 var dt4=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.mvmt_dt.value,"-",""),":","")," ","");
          	 var dt5=ComReplaceStr(form.l_evnt_dt_hm.value,":","");
          	 if(form.l_evnt_dt.value !="" && form.l_evnt_dt_hm.value !="" ){
          		dt2=ComReplaceStr(form.l_evnt_dt.value,"-","");
	  	       	 if(dt2  > dt){
	             	 form.l_evnt_dt.value="";
	             	 form.l_evnt_dt_hm.value="";
//	             	 form.l_evnt_dt.focus();
	             	 ComShowCodeMessage("CGM10058");
	             	 return ;
	      	     } 
          		if(dt2 + dt5 <= dt3){
                 	 form.l_evnt_dt.value="";
                 	 form.l_evnt_dt_hm.value="";
//                 	 form.l_evnt_dt.focus();
                 	 ComShowCodeMessage("CGM10057");
                 	 return ;
          	    } 
          		if(dt2+ dt5 <= dt4){
                 	 form.l_evnt_dt.value="";
                 	 form.l_evnt_dt_hm.value="";
//                 	 form.l_evnt_dt.focus();
                 	 ComShowCodeMessage("CGM10057");
                 	 return ;
          	    } 
          	 }
  	 		break;
    	case "f_evnt_dt":
       		 var form=document.form;
  	       	 var dt=ComReplaceStr(form.form_day.value,"-","");
  	       	 var dt2="";
  	         var dt3=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
  	         var dt5=ComReplaceStr(form.f_evnt_dt_hm.value,":","");
  	       	 if(form.f_evnt_dt.value !="" && form.f_evnt_dt_hm.value !="" ){
  	       		 dt2=ComReplaceStr(form.f_evnt_dt.value,"-","");
	  	       	 if(dt2 > dt){
	             	 form.f_evnt_dt.value="";
	             	 form.f_evnt_dt_hm.value="";
//	             	 form.f_evnt_dt.focus();
	             	 ComShowCodeMessage("CGM10058");
	             	 return ;
	      	     } 
  	       		 if(dt2+dt5 <= dt3){
		           	 form.f_evnt_dt.value="";
	             	 form.f_evnt_dt_hm.value="";
//		           	 form.f_evnt_dt.focus();
		             ComShowCodeMessage("CGM10055");
		           	 return ;
  	       		 } 
  	       	 }
  	 		 break;
    	case "f_evnt_dt_hm":
       		 var form=document.form;
  	       	 var dt=ComReplaceStr(form.form_day.value,"-","");
  	       	 var dt2="";
  	         var dt3=ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
  	         var dt5=ComReplaceStr(form.f_evnt_dt_hm.value,":","");
  	       	 if(form.f_evnt_dt.value !="" && form.f_evnt_dt_hm.value !="" ){
  	       		 dt2=ComReplaceStr(form.f_evnt_dt.value,"-","");
	  	       	 if(dt2 > dt){
	             	 form.f_evnt_dt.value="";
	             	 form.f_evnt_dt_hm.value="";
//	             	 form.f_evnt_dt.focus();
	             	 ComShowCodeMessage("CGM10058");
	             	 return ;
	      	     } 
  	       		 if(dt2+dt5 <= dt3){
		           	 form.f_evnt_dt.value="";
	             	 form.f_evnt_dt_hm.value="";
//		           	 form.f_evnt_dt.focus();
		             ComShowCodeMessage("CGM10055");
		           	 return ;
  	       		 } 
  	       	 }
  	 		 break;
	 	case "l_evnt_yd_cd":
	 		var formObj=document.form;
	    	var sheetObj=sheetObjects[0];    	 		
    	    var l_evnt_yd_cd;
	    	l_evnt_yd_cd=formObj.l_evnt_yd_cd.value;
	    	if (l_evnt_yd_cd.length == 7) {
	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    	}
	    	break;	 	
	 	case "f_evnt_yd_cd":
	 		var formObj=document.form;
	    	var sheetObj=sheetObjects[0];    	 		
    	    var f_evnt_yd_cd;
	    	f_evnt_yd_cd=formObj.f_evnt_yd_cd.value;
	    	if (f_evnt_yd_cd.length == 7) {
	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
	    	}
	    	break;
    	 }   
    	 var sheetObj=sheetObjects[0];
    }
      /**
      * YA_CD value check
      * @return
      */
     function obj_keyup(){
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0];
    	 obj=event.srcElement;
    	 switch(ComGetEvent("name")){
    	 	case "l_evnt_yd_cd":
    		    //ComKeyEnter('lengthnextfocus'); 
    	 		var l_evnt_yd_cd;
    	    	l_evnt_yd_cd=formObj.l_evnt_yd_cd.value;
    	    	if (l_evnt_yd_cd.length == 7) {
    	    		//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
//    	    		formObj.f_evnt_dt.focus();
    	    	}
    	    	break;
    	 	case "f_evnt_yd_cd":
    		    //ComKeyEnter('lengthnextfocus'); 
	    	    var f_evnt_yd_cd;
    	    	f_evnt_yd_cd=formObj.f_evnt_yd_cd.value;
    	    	if (f_evnt_yd_cd.length == 7) {
    	    		//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
//    	    		formObj.eq_no.focus();
    	    	}
    	    	break;
    	 }
    }
     /**
      * chass enter control
      * @return
      */
     function keychk(){
    	 if(event.keyCode==13)
    	 {
    		 var formObj=document.form;
        	 var sheetObj=sheetObjects[0]; 
      		   if(formObj.eq_no.value != ''){
      			    sheetObj.SetWaitImageVisible(0);
 		 	        ComOpenWait(true);
     	 			doActionIBSheet(sheetObj, formObj, IBSEARCH);
     	 			ComOpenWait(false);
      		   }
    	 }
     }
 // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var sheetObj=sheetObjects[0];
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	 	   case IBSEARCH:	// Office Code  Validation check 
			   	formObj.f_cmd.value=SEARCH;
//	 	        queryString = "f_cmd=" + SEARCHLIST ;
			   	var sXml=sheetObj.GetSearchData("EES_CGM_1017GS.do",  FormQueryString(formObj));
	 	        eqNo_set(sXml,formObj);
			   	break;
    	   case IBSEARCH_ASYNC03:	// Office Code  Validation check 
			   	formObj.f_cmd.value=COMMAND01;
			   	formObj.yd_cd.value=formObj.l_evnt_yd_cd.value;
			   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		formObj.l_evnt_yd_cd.value="";
//			   		formObj.l_evnt_yd_cd.focus();
			   	} else {
			   		Matched_Chk('Yard');
			   	}
			   	break;
    	  case IBSEARCH_ASYNC04:	// Term Code Combo retrieve
    	  		formObj.f_cmd.value=COMMAND01;
			   	formObj.yd_cd.value=formObj.f_evnt_yd_cd.value;
			   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		formObj.f_evnt_yd_cd.value="";
//			   		formObj.f_evnt_yd_cd.focus();
			   	} else {
			   		Matched_Chk('Yard');
			   	}
			   	break;
		  case IBSAVE:      // saving
		  	    if(formObj.yardChk[0].checked == true)
		  	    {
		  	    	formObj.f_cmd.value=MULTI01;
		  	    }
		  	    else
		  	    {
		  	    	formObj.f_cmd.value=MULTI02;
		  	    }
//	        queryString = "f_cmd=" + SEARCHLIST ;
//	        	var sXml = sheetObj.GetSearchXml("EES_CGM_1017GS.do",  FormQueryString(formObj));
		  		if(validateForm(sheetObj,formObj,sAction)){
		  			for(i=sheetObj.rowCount; i>0; i--){
		  				sheetObj.RowDelete(i, false);
			  		 }
			  		sheetObj.DataInsert(-1);
			  		sheetObj.SetCellValue(1, "eq_no",formObj.eq_no.value);
			  		sheetObj.SetCellValue(1, "ofc_cd",formObj.ofc_cd.value);
			  		sheetObj.SetCellValue(1, "eq_tpsz_cd",formObj.eq_tpsz_cd.value);
			  		sheetObj.SetCellValue(1, "agmt_lstm_cd",formObj.agmt_lstm_cd.value);
			  		sheetObj.SetCellValue(1, "vndr_seq",formObj.vndr_seq.value);
			  		sheetObj.SetCellValue(1, "eq_aset_sts_cd",formObj.eq_aset_sts_cd.value);
			  		sheetObj.SetCellValue(1, "l_evnt_dt",formObj.l_evnt_dt.value);
			  		sheetObj.SetCellValue(1, "f_evnt_dt",formObj.f_evnt_dt.value);
			  		sheetObj.SetCellValue(1, "l_evnt_yd_cd",formObj.l_evnt_yd_cd.value);
			  		sheetObj.SetCellValue(1, "f_evnt_yd_cd",formObj.f_evnt_yd_cd.value);
			  		sheetObj.SetRowStatus(1,"U");
	//                ComShowMessage(sheetObj.rowCount);
	//                ComShowMessage("ibflag=="+sheetObj.CellValue(1, "ibflag"));
//			  		sheetObj.DoSave("EES_CGM_1017GS.do",queryString + "&" + params);
//			  	    ComShowMessage(FormQueryString(formObj));
			  		sheetObj.SetWaitImageVisible(0);
			 	    ComOpenWait(true);
			  		if(sheetObj.DoSave("EES_CGM_1017GS.do", FormQueryString(formObj)))
			  		{
			  		}
			  		//sheetObj.DoSave("EES_CGM_1017GS.do", FormQueryString(formObj));
			  		ComOpenWait(false);
		        }
                break;
        }
    }
 // saving, retrieve 
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	if(errMsg =='') {   
    		if(formObj.yardChk[0].checked == true){
  				ComShowCodeMessage('CGM00002','LOST');
  			}else
  			{
  				ComShowCodeMessage('CGM00002','FOUND');
  			}
    		form_clear();
		}
    }   
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
   		 switch(sAction) {
   		 	case IBSAVE:
   		 		if(formObj.eq_no.value == ''){
          				ComShowCodeMessage('CGM10004','Chassis No. ');
//          				formObj.eq_no.focus();
          				return false;
          		}	
   		 		if(formObj.yardChk[0].checked == true){
   		 			if(formObj.l_evnt_dt.value=='')
   		 			{
	   		 			ComShowCodeMessage('CGM10004','Lost Date ');
//	   		 		    formObj.l_evnt_dt.focus();
	      				return false;
   		 			}
   		 		    if(formObj.l_evnt_dt_hm.value=='')
		 			{
	   		 			ComShowCodeMessage('CGM10004','Lost Date ');
//	   		 		    formObj.l_evnt_dt_hm.focus();
	      				return false;
		 			}
   		 			if(formObj.l_evnt_yd_cd.value=='')
		 			{
	   		 			ComShowCodeMessage('CGM10004','Lost Yard ');
//	   		 		    formObj.l_evnt_yd_cd.focus();
	      				return false;
		 			}
	   		 		if(formObj.l_evnt_yd_cd.value.length !=7){
			 			ComShowCodeMessage('CGM10044','Lost Yard (7)');
//			 			formObj.l_evnt_yd_cd.focus();
	       				return false;
	       			}
          		} else {
          			if(formObj.f_evnt_dt.value=='')
   		 			{
	   		 			ComShowCodeMessage('CGM10004','Found Date ');
//	   		 		    formObj.f_evnt_dt.focus();
	      				return false;
   		 			}
          			if(formObj.f_evnt_dt_hm.value=='')
   		 			{
	   		 			ComShowCodeMessage('CGM10004','Found Date ');
//	   		 		    formObj.f_evnt_dt_hm.focus();
	      				return false;
   		 			}
   		 			if(formObj.f_evnt_yd_cd.value=='')
		 			{
	   		 			ComShowCodeMessage('CGM10004','Found Yard ');
//	   		 		    formObj.f_evnt_yd_cd.focus();
	      				return false;
		 			}
   			 		if(formObj.f_evnt_yd_cd.value.length !=7){
			 			ComShowCodeMessage('CGM10044','Found Yard (7)');
//			 			formObj.f_evnt_yd_cd.focus();
	       				return false;
	       			}
          		}
          		break;
   		 }      
   	 }
        return true;
    }
    /**
     * eq_no info retrieve 
     * @param sXml
     * @param formObj
     * @return
     */
    function eqNo_set(sXml,formObj){
    	if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
        	// check message out
        	ComShowCodeMessage('CGM20003');
//        	ComShowCodeMessage("CGM10004", "Equipment is not found");
        	// Setting Cell value to Null
        	form_clear();
    	} else if(DomXml2String(sXml, "prestatus") =="X"){
    		var status=DomXml2String(sXml,  "eq_aset_sts_cd");
    		ComShowCodeMessage('CGM20015',status);
//    		EQ_ASET_STS_CD
    		//ComShowCodeMessage("CGM10004", "Equipment ");
    		form_clear();
		} else {
			formObj.eq_tpsz_cd.value=DomXml2String(sXml, "eq_tpsz_cd");
			formObj.agmt_lstm_cd.value=DomXml2String(sXml, "agmt_lstm_cd");
 			formObj.aciac_div_cd.value=DomXml2String(sXml, "aciac_div_cd");
 			formObj.vndr_seq.value=DomXml2String(sXml, "vndr_seq");
 			formObj.vndr_lgl_eng_nm.value=DomXml2String(sXml, "vndr_lgl_eng_nm");
 			formObj.eq_aset_sts_cd.value=DomXml2String(sXml, "eq_aset_sts_cd");
 			formObj.chss_mvmt_sts_cd.value=DomXml2String(sXml, "chss_mvmt_sts_cd");
 			formObj.mvmt_dt.value=DomXml2String(sXml, "mvmt_dt");
 			formObj.sts_evnt_dt.value=DomXml2String(sXml, "sts_evnt_dt");
// 			formObj.prestatus.value        = prestatus;
 			if(DomXml2String(sXml, "aciac_div_cd") == "I"){
 				formObj.yardChk[0].checked=false;
 				formObj.yardChk[1].checked=true;
 			}else {
 				formObj.yardChk[1].checked=false;
 				formObj.yardChk[0].checked=true;
 			}
 			yard_Chk();
		}
    }
    function form_clear(){
    	var formObj=document.form;
    	formObj.eq_no.value="";
    	formObj.eq_tpsz_cd.value="";
    	formObj.aciac_div_cd.value="";
		formObj.vndr_seq.value="";
		formObj.vndr_lgl_eng_nm.value="";
		formObj.eq_aset_sts_cd.value="";
		formObj.chss_mvmt_sts_cd.value="";
		formObj.agmt_lstm_cd.value="";
		formObj.mvmt_dt.value="";
		formObj.sts_evnt_dt.value="";
        formObj.l_evnt_dt.value="";
        formObj.l_evnt_dt_hm.value="";
        formObj.l_evnt_yd_cd.value="";
        formObj.f_evnt_dt.value="";
        formObj.f_evnt_yd_cd.value="";
        formObj.f_evnt_dt_hm.value="";
    }
      /** 
      * AXON event handling
      */
     function obj_activate(){
         ComClearSeparator(event.srcElement);
     }
      /**
       * yard and office check
       * @param chk
       * @return
       */
      function Matched_Chk(chk){
     	 formObj=document.form;
     	 var sheetObj=sheetObjects[0];
     	 if(formObj.l_evnt_yd_cd.value != ""  ){
     		    formObj.f_cmd.value=SEARCH01;
     		    formObj.loc_cd.value=formObj.l_evnt_yd_cd.value.substr(0,5);
     		    var sXml=sheetObj.GetSearchData("cgm_Check_LocationGS.do", FormQueryString(formObj));
     		    if(DomXml2String(sXml, "chk")!="OK"){
     				ComShowCodeMessage("CGM10028");
     					formObj.l_evnt_yd_cd.value="";
//     					formObj.l_evnt_yd_cd.focus();
     				return;
     		    }
     	 }
     	if(formObj.f_evnt_yd_cd.value != ""  ){
 		    formObj.f_cmd.value=SEARCH01;
 		    formObj.loc_cd.value=formObj.f_evnt_yd_cd.value.substr(0,5);
 		    var sXml=sheetObj.GetSearchData("cgm_Check_LocationGS.do", FormQueryString(formObj));
 		    if(DomXml2String(sXml, "chk")!="OK"){
 				ComShowCodeMessage("CGM10028");
 					formObj.f_evnt_yd_cd.value="";
// 					formObj.f_evnt_yd_cd.focus();
 				return;
 		    }
 	    }
      }
	/* developer job end */