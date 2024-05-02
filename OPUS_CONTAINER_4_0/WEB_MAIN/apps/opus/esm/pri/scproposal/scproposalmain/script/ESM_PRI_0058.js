/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0058.js
*@FileTitle  : Filing Date Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/    	
 // global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var returnData="N";
 var confirmFlag="N";
 //Event handler processing by button click event */
 document.onclick=processButtonClick; 
 /**
  * Event handler processing by button name  <br>
  */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];          
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
 				case "btn_Save":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
 					break;
 				case "btn_Close":
 					ComPopUpReturnValue(returnData);
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
      * registering IBSheet Object as list <br>
      * adding process for list in case of needing batch processing with other items  <br>
      * defining list on the top of source <br>
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		if (sheetObjects[0].RowCount()> 0){
 			sheetObjects[0].SelectCell(1, "file_dt");
 		}
     }
     /**
      * setting sheet initial values and header <br>
      * adding case as numbers of counting sheets <br>
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":      //t1sheet1 init
                 with(sheetObj){                 
			              var HeadTitle="|propno|amdtseq|Last Filing Date|New Filing Date|sysdate|pre eff date";
			              var headCount=ComCountHeadTitle(HeadTitle);
			              (headCount, 0, 0, true);
			              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			              var headers = [ { Text:HeadTitle, Align:"Center"} ];
			              InitHeaders(headers, info);
			              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                  {Type:"Date",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"last_file_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                  {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"file_dt",       KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"sys_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                  {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"pre_eff_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			               
			              InitColumns(cols);
			              SetEditable(1);
			              SetWaitImageVisible(0);
			              SetSheetHeight(120);
                       }
                 break;
         }
     }
     /**
      * Handling sheet process <br>
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         try{
        	 ComOpenWait(true); 
             switch(sAction) {
             case IBSEARCH:      
             	   if(validateForm(sheetObj,formObj,sAction)){
                 	  formObj.f_cmd.value=SEARCH;
                  	  sheetObj.DoSearch("ESM_PRI_0058GS.do", FormQueryString(formObj) );
                   }
                  break;
  			 case IBSAVE:       
  			 	  
  				  formObj.eff_dt_chg.value="";  
  			 	  if(validateForm(sheetObj,formObj,sAction)){
  			 		  
  			 		  if(confirmFlag == "Y") {
  			 			$("#confirmDialog").dialog(
  		                		{
  		                		title : "Filing Date Creation",
  		                		resizable: false,
  		                		height:230,
  		                		width :350,
  		                		buttons: [
  		                			{
  		                				text: "Yes(Y)",
  		                				click: function() {
  		                					formObj.eff_dt_chg.value="Y";
  		                					formObj.f_cmd.value=MULTI;             	     
  		                					sheetObj.DoAllSave("ESM_PRI_0058GS.do", FormQueryString(formObj)+"&ibflag="+formObj.change_dt.value);
  		                					$(this).dialog("close");
  		                				}
  		                			},
  		                			{
  		                				text: "No(N)",
  		                				click: function() {
  		                					formObj.eff_dt_chg.value="N";
  		                					formObj.f_cmd.value=MULTI;             	     
  		                					sheetObj.DoAllSave("ESM_PRI_0058GS.do", FormQueryString(formObj)+"&ibflag="+formObj.change_dt.value);
  		                					$(this).dialog("close");
  		                				}
  		                			},
  		                			{
  		                				text: "Cancel(Cancel)",
  		                				click: function() {
  		                					$(this).dialog("close");
  		                				}
  		                			}
  		                		]
  		                	}
  		                );
  			 		  } else {
  			 			formObj.f_cmd.value=MULTI;             	     
      					sheetObj.DoAllSave("ESM_PRI_0058GS.do", FormQueryString(formObj)+"&ibflag="+formObj.change_dt.value);
  			 		  }

                   }   
                   break;
          }        	 
         } catch (e) {
         	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         }finally{
         	ComOpenWait(false); //->waiting->End
         }
     }

     
     /**
      * checking validation process of inputed form data <br>
      */
    	function validateForm(sheetObj, formObj, sAction) {
    		switch (sAction) {
    		case IBSEARCH: // retrieve
    			if (formObj.prop_no.value == "" ) {
    				return false;
    			} else {
    				return true;
    			}
    			break;
    		case IBSAVE: // save
    			var effDtChg="";
    			if (formObj.prop_no.value == ""  ) {
    				return false;
    			}
    			//20100506 SCOPE EXPIRE 
				if (checkExpireDate() != "Y"){
					return false;
				}
				var lastFileDt=sheetObj.GetCellValue(1,"last_file_dt");
				var newFileDt=sheetObj.GetCellValue(1,"file_dt");
				var sysDt=sheetObj.GetCellValue(1,"sys_dt");
    			var effDt=formObj.eff_dt.value;
    			var preEffDt=sheetObj.GetCellValue(1, "pre_eff_dt");
    			if (lastFileDt >= newFileDt ){
    				ComShowCodeMessage("PRI01053");
    				sheetObj.SelectCell(1,"file_dt");
    				return false;
    			}
    			if (preEffDt >= newFileDt){
    				ComShowCodeMessage("PRI01119");
    				sheetObj.SelectCell(1,"file_dt");
    				return false;
    			}
    			//2009-12-15  eff_dt_chg Y or N		
	   			if (effDt <= newFileDt && ComGetDateAdd(effDt, "D", 9,"") >= newFileDt){
	   				effDtChg="Y";
    			}
	   			if (ComGetDateAdd(effDt, "D", 9,"")< newFileDt){
	   				if (!ComShowCodeConfirm("PRI01054")){
	   					sheetObj.SelectCell(1,"file_dt");
	   					return false;
	   				}else{
	   					effDtChg="Y";
	   				}
    			}
	   			if (effDt > newFileDt){
	   				confirmFlag = "Y"
	   			}
	   			formObj.eff_dt_chg.value=effDtChg;
    			return true;
    			break;
    		}
    	}
    /**
     * calling function when occurring OnSaveEnd event  <br>
     * setting modify Flag = "Y" after saving<br>
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
    		 ComPopUpReturnValue("Y");
		}
	}     	
     /**
     * checking filing date >= main,scope's exp_dt after filing<br>
     */    
    function checkExpireDate(){
       document.form.f_cmd.value=SEARCH01;
       var rValue="N"; 
       var sParam=FormQueryString(document.form)+"&"+sheetObjects[0].GetSaveString(true);
       var sXml=sheetObjects[0].GetSearchData("ESM_PRI_0058GS.do", sParam);
       var arrData=ComPriXml2Array(sXml, "svc_scp_cd|ctrt_eff_dt|ctrt_exp_dt|cnt");
       var msg=new Array();
       if (arrData != null && arrData.length > 0) {           
    	   if (arrData[0][3] == "1"){
               rValue="N";
               msg[0]=arrData[0][0];
               msg[1]=arrData[0][1];
               msg[2]=arrData[0][2];
           }else{                              
               rValue="Y";
           }           
       }else{
    	   rValue="Y";
       }
       if (rValue =="N"){
           ComShowCodeMessage('PRI01094',msg[0],msg[1],msg[2]);
       }
       return rValue;
    }     
