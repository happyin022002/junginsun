/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2016.js
*@FileTitle  : M.G.Set Attach/Detach Creation
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
     * @class EES_CGM_2016 : EES_CGM_2016 business script for
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
          var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
                 case "Delete":
                	 doActionIBSheet(sheetObject,formObject,REMOVE);
 					break;
 				case "btn_Save":
 					doActionIBSheet(sheetObject, formObject, IBSAVE);
 					break;
                 case "btn_New":
                	 sheetObject.RemoveAll();
                	 formObject.reset();
//                	 formObject.acth_dt.value = ComGetNowInfo();
//                	 formObject.acth_dt_hm.value = ComGetNowInfo("hm" );
 					 break;
                 case "Row_Add":
                	 sheetObject.DataInsert();
 					break;
                 case "ComOpenPopupWithTargetYard":
           			ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 800, 530, "3:sts_evnt_yd_cd", "1,0,1,1,1,1,1", true);
           			break;
 	 		     case "btns_Calendar1" :		// Agreement Date (From Date)
 	 				var cal=new ComCalendar();
 	 		        cal.setEndFunction("processEndCal");
	 	 			cal.select(formObject.acth_dt, "yyyy-MM-dd");
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
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }

         setLocalTime();
//         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
//         axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
//         axon_event.addListenerFormat('beforeactivate',		'obj_activate',		formObj);
         //axon_event.addListener('focusout', 'obj_focusout',  'acth_dt','acth_dt_hm');
//         axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
     }
     
     function setLocalTime(){
    	 var formObj=document.form;
    	 var sXml2=document.form2.sXml.value;
    	 
    	 var local = ComGetEtcData(sXml2, "Local_Time");
    	 
    	 var localDate = local.substring(0,10);
    	 var localTime = local.substring(11, 16);
    	 
    	 formObj.acth_dt.value = localDate;
    	 formObj.acth_dt_hm.value = localTime;
// 		var sDay = val.substring(2,4);
     }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {
                 var HeadTitle="||Seq|M.G.Set No.|Type|AT/DT|Container/Chassis No.|Status||AT/DT Time||||";
                 var headCount=ComCountHeadTitle(HeadTitle);
                 SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"Seq",           KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                        {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"at",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:280,  Align:"Center",  ColMerge:0,   SaveName:"Status",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"atch_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"dtch_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"atch_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"aciac_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                  
                 InitColumns(cols);
//                 SetSheetHeight(530);
                 SetEditable(1);
                 SetColProperty(0, "at", {ComboText:"|AT|DT", ComboCode:"|AT|DT"} );
                 SetColProperty(0 ,"eq_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                 SetColProperty(0 ,"cntr_no1" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                 SetSelectionMode(smSelectionFree);
                 resizeSheet();
                }
                 break;
         }
     }
     function resizeSheet(){
         ComResizeSheet(sheetObjects[0]);
     }
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 			case IBSAVE:        //saving
			    var actionFlag=false;
 			    var chkFlag=false;
//       		if(validateForm(sheetObj,formObj,sAction))
	            if(formObj.acth_dt.value==""){
	            	ComShowCodeMessage('CGM10004','Date. ');
					//formObj.acth_dt.focus();
					return false;
	            }
	 			 if(formObj.acth_dt_hm.value==""){
	             	ComShowCodeMessage('CGM10004','Time. ');
					//formObj.acth_dt_hm.focus();
					return false;
	             }
	 			 if(formObj.sts_evnt_yd_cd.value==""){
		             	ComShowCodeMessage('CGM10004','Yard. ');
						//formObj.sts_evnt_yd_cd.focus();
						return false;
		         }
	 			if(formObj.sts_evnt_yd_cd.value!='' && formObj.sts_evnt_yd_cd.value.length !=7){
		 			 ComShowCodeMessage('CGM10044','Yard (7)');
		 			//formObj.sts_evnt_yd_cd.focus();
      				 return false;
      			}
	       		formObj.f_cmd.value=MODIFY;
				queryString="f_cmd=" + MODIFY ;
				  for(i=1;i<sheetObj.LastRow()+1;i++)
	              {
					  sheetObj.SetCellValue(i, "atch_yd_cd",formObj.sts_evnt_yd_cd.value);
					  if(sheetObj.GetCellValue(i, "at") == "AT"){
						  sheetObj.SetCellValue(i, "atch_dt",formObj.acth_dt.value + " " +formObj.acth_dt_hm.value);
						  if(sheetObj.GetCellValue(i, "cntr_no1") == ""){
							  chkFlag=true;
						  }
					  } else {
						  sheetObj.SetCellValue(i, "dtch_dt",formObj.acth_dt.value + " " +formObj.acth_dt_hm.value);
					  }
					  sheetObj.SetCellValue(i, "atch_yd_cd",formObj.sts_evnt_yd_cd.value);
					  if(sheetObj.GetCellValue(i, "del_chk") == "1" && sheetObj.GetCellValue(i, "Status")!= 'OK'){
	//					 sheetObj.CellValue(i, "del_chk") = "0";
	//					 sheetObj.RowStatus(i) = "R";
						 actionFlag=true;
					  } else if (sheetObj.GetCellValue(i, "del_chk") == "0") {
						 sheetObj.SetRowStatus(i,"R");
					  }
	              }
				  if(actionFlag){
			        	ComShowCodeMessage("CGM10007");
					    return false;
				  } else if(chkFlag){
					    ComShowCodeMessage("CGM10009"," Container/Chassis No.");
					    return false;
				  } else {
						if(sheetObj.DoSave("EES_CGM_2016GS.do",queryString + "&" + ComGetPrefixParam("")),'del_chk')
						{
						} else {
							 for(i=1;i<sheetObj.LastRow()+1;i++)
							 {
								 sheetObj.SetRowStatus(i,"I");
							 }
						}
				  }
				  var params=sheetObj.GetSaveString(true);
                break;
            case REMOVE: 	   // deleting
				for(i=sheetObj.RowCount(); i>0; i--){
					if(sheetObj.GetCellValue(i, "del_chk") != "0" ) {
		   				sheetObj.RowDelete(i, false);
		   			}
		   		 }
				 break;
 			case IBSEARCH_ASYNC01:	// Office Code  Validation check
			   	formObj.f_cmd.value=COMMAND01;
			   	formObj.yd_cd.value=formObj.sts_evnt_yd_cd.value;
 			   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult=ComGetEtcData(sXml,"checkResult");
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		formObj.sts_evnt_yd_cd.value="";
			   		//formObj.sts_evnt_yd_cd.focus();
			   	}
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
	 /**

	 /**
      * Object deactivate event handling  <br>
      * @param  
      * @return 
      * @author 
      * @version
      */
     function obj_deactivate(){
    	 var formObj=document.form;
    	 var obj=ComGetEvent();
//    	 $(obj).atrr('name')
    	    if(obj.name=="acth_dt"  ){
        		 with(formObj){
        			 var creDtFr=ComReplaceStr(acth_dt.value,"-","");
     	        }
     	        ComChkObjValid(ComGetEvent());
          }
    	   if(obj.name=="acth_dt_hm"  ){
         		 with(formObj){
         			 var creDtFr=ComReplaceStr(acth_dt.value,":","");
      	        }
         		 ComChkObjValid(ComGetEvent());
          }
     }
      /**
       * AXON event handling
       */
      function obj_activate(){
          ComClearSeparator(ComGetEvent());
      }
   /**
     * Object obj_focusout event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */
    function obj_focusout(){
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0];
    	 obj=ComGetEvent();
    	 switch(ComGetEvent("name")){
//    	 	case "sts_evnt_yd_cd":
//    	 		if(formObj.sts_evnt_yd_cd.value != ''){
//    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
//    	 			break;
//    	 		}
    	 	case "acth_dt":
    	 		 var dt=ComReplaceStr(form.form_day.value,"-","");
    	 		 var dt2=ComReplaceStr(form.acth_dt.value,"-","");;
	   	         if(form.acth_dt.value!="" &&  dt2 > dt){
	   	        	 form.acth_dt.value="";
	   	        	 form.acth_dt.focus();
	   	        	 ComShowCodeMessage('CGM10059');
	   	        	 return;
	   	 	    }
    	 		 for(i=1;i<sheetObj.LastRow()+1;i++)
				 {
    	 			 if((formObj.acth_dt.value + " "+ formObj.acth_dt_hm.value+":00") < sheetObj.GetCellValue(i, "atch_dt")   ){
    	 				sheetObj.SetCellValue(i, "Status","check date/time",0);
			    	} else {
			    		sheetObj.SetCellValue(i, "Status","",0);
			    		sheetObj.SetCellEditable(i, "at",1);
			    	}
				 }
    	 		break;
    	 	case "acth_dt_hm":
    	 		 for(i=1;i<sheetObj.LastRow()+1;i++)
				 {
    	 			 if((formObj.acth_dt.value + " "+ formObj.acth_dt_hm.value+":00") < sheetObj.GetCellValue(i, "atch_dt")   ){
    	 				sheetObj.SetCellValue(i, "Status","check date/time",0);
			    	} else {
			    		sheetObj.SetCellValue(i, "Status","",0);
			    		sheetObj.SetCellEditable(i, "at",1);
			    	}
				 }
    	 		break;
    	 }
    }
     function processEndCal(){
    	 var form=document.form;
    	 var dt=ComReplaceStr(form.form_day.value,"-","");
 		 var dt2=ComReplaceStr(form.acth_dt.value,"-","");;
         if(form.acth_dt.value!="" &&  dt2 > dt){
        	 form.acth_dt.value="";
        	 form.acth_dt.focus();
        	 ComShowCodeMessage('CGM10059');
        	 return;
 	    }
     }
         /**
          * YA_CD value check
          * @return
          */
         function obj_keyup(){
    		 var formObj=document.form;
    		 var sheetObj=sheetObjects[0];
    		 obj=ComGetEvent();
    		 switch(ComGetEvent("name")){
    		 	case "sts_evnt_yd_cd":
    	    	    var sts_evnt_yd_cd;
    		    	frmObj=document.form;
    		    	//alert("sss");
    		    	sts_evnt_yd_cd=frmObj.sts_evnt_yd_cd.value;
    		    	if (sts_evnt_yd_cd.length == 7) {
    		    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    		    	}
    		    	break;
    		 }
    	}
 	function sheet1_OnChange(sheetObj, Row, Col){
       var formObj=document.form;
       var chk=true;
    	  switch (sheetObj.ColSaveName(Col)) {
          case "eq_no" :
     	        formObj.f_cmd.value=SEARCH;
     	        formObj.eq_no.value=sheetObj.GetCellValue(Row, "eq_no");
			   	var cellValue=sheetObj.GetCellValue(Row, Col);
			   	if(sheetObj.GetCellValue(Row, "eq_no")!="")
			   	{
	 			   	if(Row >1)
	 				{
	 					// chassis no check
	 					for(i=1; i<sheetObj.RowCount(); i++){
	 						if(sheetObj.GetCellValue(i, "eq_no")== cellValue && Row != i )
		 					{
		 						chk=false;
		 					}
		 				}
	 				}
	 			    if(chk == true)
					{
 	 			   		var sXml=sheetObj.GetSearchData("EES_CGM_2016GS.do", FormQueryString(formObj));
	 				    // data count
	 				    var dataCount=ComGetTotalRows(sXml);
	 				    // data existing
	 				    if(dataCount > 0){
 				    		if((formObj.acth_dt.value + " "+ formObj.acth_dt_hm.value+":00") > DomXml2String(sXml,"atch_dt")){
 				    			if( DomXml2String(sXml,"aciac_div_cd")=="I"){
		 				    		sheetObj.SetCellValue(Row, "Status","Inputted M.G.Set No. is not active",0);
		 				    		sheetObj.SetCellEditable(Row, "at",0);
		 				    	} else {
		 				    		sheetObj.SetCellValue(Row, "Status","",0);
		 				    		sheetObj.SetCellEditable(Row, "at",1);
		 				    	}
	 				    	} else {
	 				    		sheetObj.SetCellValue(Row, "Status","check date/time",0);
	 				    		sheetObj.SetCellEditable(Row, "at",0);
	 				    	}

 				    		var cntrno = DomXml2String(sXml,"cntr_no1");
	 				    	sheetObj.SetCellValue(Row, "eq_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"),0);
	 				    	sheetObj.SetCellValue(Row, "at","",0);
	 				    	sheetObj.SetCellValue(Row, "cntr_no1",DomXml2String(sXml,"cntr_no1"),0);
	 				    	sheetObj.SetCellValue(Row, "cntr_tpsz_cd",DomXml2String(sXml,"cntr_tpsz_cd"),0);
	 				    	sheetObj.SetCellValue(Row, "atch_dt",DomXml2String(sXml,"atch_dt"),0);
	 				    	sheetObj.SetCellValue(Row, "cntr_no2",DomXml2String(sXml,"cntr_no2"),0);
	 				    	sheetObj.SetCellValue(Row, "aciac_div_cd",DomXml2String(sXml,"aciac_div_cd"),0);
	 				    	sheetObj.SetCellValue(Row, "del_chk","1",0);
//	 				    	sheet1_edit(Row,true);
	 				   	} else {
	 				   		ComShowCodeMessage('CGM10009','M.G.Set No.');
	 				     	sheetObj.SetCellValue(Row, "eq_no","",0);
	 				   		sheetObj.SetCellValue(Row, "eq_tpsz_cd","");
	 				     	sheetObj.SetCellValue(Row, "cntr_no1","",0);
					    	sheetObj.SetCellValue(Row, "at","",0);
					    	sheetObj.SetCellValue(Row, "cntr_tpsz_cd","",0);
					    	sheetObj.SetCellValue(Row, "Status","",0);
					    	sheetObj.SetCellValue(Row, "del_chk","0",0);
					    	sheetObj.SetCellValue(Row, "atch_dt","",0);
					    	sheetObj.SetCellEditable(Row, "at",0);
//					    	sheet1_edit(Row,false);
	 				   	}
					}
					else
					{
			        	ComShowCodeMessage("CGM10017","  M.G.Set No.");
			        	// Setting Cell value to Null
						sheetObj.SetCellValue(i, "eq_no","");
					}
			   	}
			    break;
        	case "at" :
        		if((formObj.acth_dt.value + " "+ formObj.acth_dt_hm.value+":00") < sheetObj.GetCellValue(Row, "atch_dt")   ){
	 				sheetObj.SetCellValue(Row, "Status","check date/time",0);
	 				return false ;
		    	} else {
		    		sheetObj.SetCellValue(Row, "Status","",0);
		    	}
        		if(sheetObj.GetCellValue(Row, "at") ==""  ){
        			sheetObj.SetCellValue(Row, "Status","");
        			sheetObj.SetCellValue(Row, "cntr_no1",sheetObj.GetCellValue(Row, "cntr_no2") ,0);
        		}
        		if(sheetObj.GetCellValue(Row, "at") =="DT"  ){
        			if(sheetObj.GetCellValue(Row, "cntr_no2") ==""){
	           			ComShowCodeMessage("CGM10045");
	           			sheetObj.SetCellValue(Row, "Status","Error");
	           			return false;
        			} else {
        				sheetObj.SetCellValue(Row, "cntr_no1","");
//        				sheetObj.CellValue(Row, "cntr_no2")           = "";
        				sheetObj.SetCellValue(Row, "Status","OK");
        			}
        		}
        		if(sheetObj.GetCellValue(Row, "at") =="AT"  ){
        			sheetObj.SetCellValue(Row, "cntr_no1",sheetObj.GetCellValue(Row, "cntr_no2") ,0);
        			if(sheetObj.GetCellValue(Row, "cntr_no1") ==""){
        				sheetObj.SetCellValue(Row, "Status","");
        			} else {
        				sheetObj.SetCellValue(Row, "Status","Error");
        				return false;
        			}
//
        		}
        		if(sheetObj.GetCellValue(Row, "at") =="AT" && sheetObj.GetCellValue(Row, "Status") != "Error" ){
        			if(sheetObj.GetCellEditable(Row, "cntr_no1")  == ""){
        				sheetObj.SetCellEditable(Row, "cntr_no1",1);
        			}
        			if(sheetObj.GetCellValue(Row, "eq_tpsz_cd")== "CB4" || sheetObj.GetCellValue(Row, "eq_tpsz_cd")== "SF4" ){
        				sheetObj.SetCellEditable(Row, "cntr_no2",1);
        			}
        		} else {
        			sheetObj.SetCellEditable(Row, "cntr_no1",0);
        			sheetObj.SetCellEditable(Row, "cntr_no2",0);
        		}
        		if(sheetObj.GetCellValue(Row, "at") ==""  ){
        			sheetObj.SetCellValue(Row, "Status","");
        		}
        		break;
        	case "cntr_no1" :
        		var cntr_no1_Value=sheetObj.GetCellValue(Row, Col);
           		if(cntr_no1_Value!=""){
           			for(icntr=1; icntr<sheetObj.RowCount(); icntr++){
           				if(sheetObj.GetCellValue(icntr, "cntr_no1")== cntr_no1_Value && Row != icntr)
	 					{
							ComShowCodeMessage("CGM10017"," CNTR No.");
 							sheetObj.GetCellValue(Row, Col)="";
	 					}
	 				}
           		}
           		if(sheetObj.GetCellValue(Row, "cntr_no1")!="")
			   	{
        			    formObj.f_cmd.value=SEARCH;
        			    if(sheetObj.GetCellValue(Row, "eq_tpsz_cd") == "CLG"){
         			    	var sXml=sheetObj.GetSearchData("CGM_MST_CONTAINERGS.do?cntr_no="+sheetObj.GetCellValue(Row, "cntr_no1"), FormQueryString(formObj));
    	 				    // data count
    	 				    var dataCount=ComGetTotalRows(sXml);
    	 				    // data existing
    	 				    if(dataCount > 0){
    	 				    	if(DomXml2String(sXml,"disp_flg")=='DT'){
    	 				    		sheetObj.SetCellValue(Row, "cntr_no1",DomXml2String(sXml,"cntr_no"));
        	 				    	sheetObj.SetCellValue(Row, "cntr_tpsz_cd",DomXml2String(sXml,"cntr_tpsz_cd"));
        	 				    	sheetObj.SetCellValue(Row, "Status","OK");
    	 				    	} else {
    	 				    		if(DomXml2String(sXml,"eq_knd_cd")=='Z'){ 
        	 				    		sheetObj.SetCellValue(Row, "cntr_no1",DomXml2String(sXml,"cntr_no"));
            	 				    	sheetObj.SetCellValue(Row, "cntr_tpsz_cd",DomXml2String(sXml,"cntr_tpsz_cd"));
            	 				    	sheetObj.SetCellValue(Row, "Status","OK");
    	 				    		} else {
    	 				    		ComShowCodeMessage('CGM20035',DomXml2String(sXml,"eq_no"));
        		 				   	sheetObj.SetCellValue(Row, "cntr_no1","");
        		 				    sheetObj.SetCellValue(Row, "cntr_tpsz_cd","");
    	 				    		}
    	 				    	}
    	 				   	} else {
    	 				   		ComShowCodeMessage('CGM10009','Container/Chassis No.');
    		 				   	sheetObj.SetCellValue(Row, "cntr_no1","");
    		 				    sheetObj.SetCellValue(Row, "cntr_tpsz_cd","");
    	 				   	}
        			    } else if(sheetObj.GetCellValue(Row, "eq_tpsz_cd") == "UMG") {
         			    	var sXml=sheetObj.GetSearchData("CGM_CHS_MASTERGS.do?eq_knd_cd=Z&eq_no="+sheetObj.GetCellValue(Row, "cntr_no1"), FormQueryString(formObj));
        			    	// data count
    	 				    var dataCount=ComGetTotalRows(sXml);
    	 				    // data existing
    	 				    if(dataCount > 0){
    	 				    	sheetObj.SetCellValue(Row, "cntr_no1",DomXml2String(sXml,"eq_no"));
    	 				    	sheetObj.SetCellValue(Row, "cntr_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"));
    	 				    	sheetObj.SetCellValue(Row, "Status","OK");
    	 				   	} else {
    	 				   		ComShowCodeMessage('CGM10009','Container/Chassis No.');
    		 				   	sheetObj.SetCellValue(Row, "cntr_no1","");
    		 				    sheetObj.SetCellValue(Row, "cntr_tpsz_cd","");
    	 				   	}
        			    } else {
        			    	var sXml1=sheetObj.GetSearchData("CGM_MST_CONTAINERGS.do?cntr_no="+sheetObj.GetCellValue(Row, "cntr_no1"), FormQueryString(formObj));
        			    	var sXml2=sheetObj.GetSearchData("CGM_CHS_MASTERGS.do?eq_knd_cd=Z&eq_no="+sheetObj.GetCellValue(Row, "cntr_no1"), FormQueryString(formObj));
        			    	// data count
    	 				    var dataCount1=ComGetTotalRows(sXml1);
    	 				    var dataCount2=ComGetTotalRows(sXml2);
    	 				    // data existing
    	 				    if(dataCount1 > 0){
    	 				    	if(DomXml2String(sXml1,"disp_flg")=='DT'){
    	 				    		sheetObj.SetCellValue(Row, "cntr_no1",DomXml2String(sXml1,"cntr_no"));
        	 				    	sheetObj.SetCellValue(Row, "cntr_tpsz_cd",DomXml2String(sXml1,"cntr_tpsz_cd"));
        	 				    	sheetObj.SetCellValue(Row, "Status","OK");
    	 				    	} else {
    	 				    		if(DomXml2String(sXml1,"eq_knd_cd")=='Z'){ 
        	 				    		sheetObj.SetCellValue(Row, "cntr_no1",DomXml2String(sXml1,"cntr_no"));
            	 				    	sheetObj.SetCellValue(Row, "cntr_tpsz_cd",DomXml2String(sXml1,"cntr_tpsz_cd"));
            	 				    	sheetObj.SetCellValue(Row, "Status","OK");
    	 				    		} else {
    	 				    		ComShowCodeMessage('CGM20035',DomXml2String(sXml1,"eq_no"));
        		 				   	sheetObj.SetCellValue(Row, "cntr_no1","");
        		 				    sheetObj.SetCellValue(Row, "cntr_tpsz_cd","");
    	 				    		}
    	 				    	}
    	 				   	}else if(dataCount2 > 0){
	    	 				   	sheetObj.SetCellValue(Row, "cntr_no1",DomXml2String(sXml2,"eq_no"));
		 				    	sheetObj.SetCellValue(Row, "cntr_tpsz_cd",DomXml2String(sXml2,"eq_tpsz_cd"));
		 				    	sheetObj.SetCellValue(Row, "Status","OK");
    	 				   	}else {
    	 				   		ComShowCodeMessage('CGM10009','Container/Chassis No.');
    		 				   	sheetObj.SetCellValue(Row, "cntr_no1","");
    		 				    sheetObj.SetCellValue(Row, "cntr_tpsz_cd","");
    	 				   	}
        			    }
					}
				 break;
			   	}
   }
 	//saving, retrieve 
 	  function sheet1_OnSaveEnd(sheetObj, errMsg) {
 		 if(errMsg =='') {
 			ComShowCodeMessage('CGM00003');
     		for(i=sheetObj.LastRow(); i>0; i--){
     			if(sheetObj.GetCellValue(i, "del_chk") == "1" ){
 					  sheetObj.RowDelete(i, false);
 				  }
 				}
 		}
 	  }
	/* developer job end */
