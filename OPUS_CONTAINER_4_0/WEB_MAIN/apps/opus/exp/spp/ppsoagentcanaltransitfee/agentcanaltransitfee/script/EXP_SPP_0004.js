/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0004.js
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class EXP_SPP_0004 : business script for EXP_SPP_0004 
     */
    function EXP_SPP_0004() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setTabObject 			= setTabObject;
    	this.initTab 				= initTab;
    	this.tab1_OnChange          = tab1_OnChange;
    	this.loadPage 				= loadPage;
    	this.initControl 			= initControl;
    	this.obj_deactivate 		= obj_deactivate;
    	this.obj_activate 			= obj_activate;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.setBtnEnable 			= setBtnEnable;
    	this.computeEndBal 			= computeEndBal;
    	this.t1sheet1_OnAfterEdit 	= t1sheet1_OnAfterEdit;
    	this.t1sheet1_OnChange 		= t1sheet1_OnChange;
    	this.t1sheet1_OnSelectCell 	= t1sheet1_OnSelectCell;
    	this.setCountReCalc 		= setCountReCalc;
    	
    }
    
    // The common global variables
    var tabObjects = new Array();
    var tabClicks  = new Array(3); 
    var tabCnt = 0 ;
    var beforetab = 1;			    
    var ROWMARK = "|";
    var FIELDMARK = ",";
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
        function processButtonClick(){

             var sheetObject1 = sheetObjects[0];
             var sheetObject2 = sheetObjects[1];
             var sheetObject3 = sheetObjects[2];

             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

	            switch(srcName) {
	              case "btn_DownExcel":
  	        	        if(sheetObject1.RowCount <= 0){  //RowCount : The total row count(not included total row but subtotal one) 
		        	        ComCodeMsgByNoRelatedData();  // There is no related data!
		        	        return;
	        	        }else{
		        	        if(sheetObject1.RowCount > 0){  //RowCount : The total row count(not included total row but subtotal one)
		        	        	sheetObject1.Down2Excel(-1,true,true,true,"","",false,false,"Requested MSA BALANCE"); 
		        	        }
	        	        } 
	        	        break;
	        	        
	              case "btn_DownExcel2":
	        	        if(sheetObject2.RowCount <= 0){  //RowCount : The total row count(not included total row but subtotal one) 
		        	        ComCodeMsgByNoRelatedData();  // There is no related data!
		        	        return;
	        	        }else{
		        	        if(sheetObject2.RowCount > 0){  //RowCount : //RowCount : The total row count(not included total row but subtotal one)
		        	        	sheetObject2.Down2Excel(-1,true,true,true,"","",false,false,"Requested MSA REMITTANCE");  //
		        	        }
	        	        } 
	        	        break;
	        	        
	              case "btn_DownExcel3":
	        	        if(sheetObject3.RowCount <= 0){  //RowCount : //RowCount : The total row count(not included total row but subtotal one) 
		        	        ComCodeMsgByNoRelatedData();  // There is no related data!
		        	        return;
	        	        }else{
		        	        if(sheetObject3.RowCount > 0){  //RowCount : //RowCount : The total row count(not included total row but subtotal one)
		        	        	sheetObject3.Down2Excel(-1,true,true,true,"","",false,false,"Requested MSA DISBURSEMENT"); 
		        	        }
	        	        } 
	        	        break;	        	        
	
				  case "btn_Request":
					  	var procSts = formObject.pso_msa_sts_cd.value.trim();
					    if(procSts!="R") break;  //not requesting in case of not being Ready status
		          	 	if(ComIsEmpty(formObject.rev_yrmon.value)){
		         	 		ComCodeMsgByEmptyData("Working Month");  //[{?msg1}] Value is Empty.
		         	 		return false;
		         	 	}
					    doActionIBSheet(sheetObject1,formObject,COMMAND01);
						break;
						
				  case "btn_Save":
					    var procSts = formObject.pso_msa_sts_cd.value.trim();
					    if(procSts!="" && procSts!="R") break;  //not saving in case of not being Ready status
		          	 	if(ComIsEmpty(formObject.rev_yrmon.value)){
		         	 		ComCodeMsgByEmptyData("Working Month");  //[{?msg1}] Value is Empty.
		         	 		return false;
		         	 	}
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;
	    				
	            } // end switch
            
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("SPP01003");
        		} else {
        			ComShowMessage(e);
        		}
        	}
        }

        /**
         * Registering IBSheet Object as list
         * Adding process for list in case of needing batch processing with other items
         * Defining list on the top of source
         */
        function setSheetObject(sheet_obj){

           sheetObjects[sheetCnt++] = sheet_obj;

        }
         
        /**
         * Registering IBTab Object as list
         * Adding process for list in case of needing batch processing with other items
         * Defining list on the top of source
         */
        function setTabObject(tab_obj){
             tabObjects[tabCnt++] = tab_obj;
        }

         /**
          * initializing Tab
          * setting Tab items
          */
         function initTab(tabObj , tabNo) {
              switch(tabNo) {
                  case 1:
                     with (tabObj) {
                         var cnt  = 0 ;
                         tabClicks[cnt]=false;
                         InsertTab( cnt++ , " (A)STATEMENT OF BALANCE" , -1 );
                         tabClicks[cnt]=false;
                         InsertTab( cnt++ , " (B)DETAILS OF REMITTANCE" , -1 );
                         tabClicks[cnt]=false;
                         InsertTab( cnt++ , " (C)DETAILS OF DISBURSEMENT" , -1 );
                     }
                  break;
              }
         }  
          
          /**
          * Calling this function in case of occurring onChange event in tab1
          * activating selected tab
          */
         function tab1_OnChange(tabObj, nItem){  //nItem -> 0, 1, 2
            var objs = document.all.item("tabLayer");

         	//Checking whether the clicked tab is matched the showing layer or not
 	    	objs[nItem].style.display = "Inline";
 	    	objs[beforetab].style.display = "none";

 	    	//Changing the zIndex value of the layer
 	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
 	    	beforetab= nItem;
 	    	
 	    	//Retrieving the page info in case of never clicking the tab when clicking first or second tab
 	    	if((nItem === 1 || nItem === 2) && tabClicks[nItem] == false){
 	    		doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);
 	    	}
 	    	
 	    	//Saving that the tab is clicked
 	    	tabClicks[nItem] = true;
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

            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
            initControl();
            
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         }
         
         /**
         * Adding some occurring events to form. 
         */
         function initControl() {
        	 // handling the occurring blur event to the all fields that contain dataformat attribute        	 
			 axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form); 
			 // handling the occurring focus event to the form in case of contain dataformat attribute
			 axon_event.addListenerFormat('focus', 	'obj_activate',    	form);
		 	// handling the occurring keyup event to the form in case of contain dataformat attribute
			 axon_event.addListenerFormat('keypress', 'obj_keypress',   form);			 

			 //focusSetting
			 document.form.rev_yrmon.focus();
			 document.form.rev_yrmon.blur();
      	 } 
         
         /*
          * Handling the code when occurring blur event.
          */
         function obj_deactivate(){
      	     obj = event.srcElement;
             ComChkObjValid(event.srcElement);             
         }
         
         /*
          * Handling the code when occurring focus event
          */
         function obj_activate(){
        	 obj = event.srcElement;
             ComClearSeparator(event.srcElement);   
         }
          
         /*
          * Handling the code when occurring keypress event
          */
          function obj_keypress(){
              switch(event.srcElement.dataformat){
          	      case "ym":
          	        //Being able to input number only
          	        ComKeyOnlyNumber(event.srcElement);          	        
          	        break;
          	        
          	      default:
          	    	//Being able to input number only
          	        ComKeyOnlyNumber(event.srcElement);
          	        break;
              }
          }          

        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets 
         */
        function initSheet(sheetObj,sheetNo) {

          var cnt = 0;
    	  var sheetid = sheetObj.id;
    	  var onepagerows = document.form.pagerows.value;
          switch(sheetid) {

    				case "t1sheet1":
    					with (sheetObj) {
    							// Setting height
    							style.height = 340;
    							//Setting width
    							SheetWidth = mainTable.clientWidth;

    							//Setting the Host information[Required][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//Kind of merge [Optional, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//Edit kind [Optional, Default false]
    							Editable = true;

    							//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(2, 1, 3, onepagerows);

    							var HeadTitle1 = "|Seq.|Hidden5|Hidden4|ITEM|Amount|Amount|Remark|Hidden1|Hidden2|Hidden3|Hidden6";
    							var HeadTitle2 = "|Seq.|Hidden5|Hidden4|ITEM|Debit|Credit|Remark|Hidden1|Hidden2|Hidden3|Hidden6";							
    							
    							var headCount = ComCountHeadTitle(HeadTitle1); 
    							

    							//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// Setting function handling header
    							InitHeadMode(false, true, false, true, false,false);

    							//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							InitHeadRow(1, HeadTitle2, true);

    							var prefix = "t1sheet1_";
    							//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtDataSeq,		60,		daCenter,	true,	prefix+"seq");
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	prefix+"msa_seq");
    							InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		true,	prefix+"pso_msa_amt_tp_cd",		false,	"",	dfNone,	0,	true,	true);
    							InitDataProperty(0, cnt++ , dtData,			250,	daLeft,		true,	prefix+"item",			false,	"",	dfNone,			0,	false,	false);
    							InitDataProperty(0, cnt++ , dtAutoSum,		160,	daRight,	true,	prefix+"amount_debit",	false,	"",	dfNullFloat,	2,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtAutoSum,		160,	daRight,	true,	prefix+"amount_credit",	false,	"",	dfNullFloat,	2,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtData,			170,	daLeft,		true,	prefix+"diff_rmk",		false,	"",	dfEngKey,		0,	true,	true, 50);
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"rev_yrmon");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"vndr_seq");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"pso_msa_sts_cd");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"exist");
    							
    							InitDataValid(0, prefix+"diff_rmk", vtEngOther, "1234567890!@#$%^&*()_-+=[{]}|\\;:\"\'<,>.?/~` ");
    					}
    					break;


    				case "t2sheet1":
    					with (sheetObj) {
    							// Setting height
    							style.height = 260;
    							//Setting width
    							SheetWidth = mainTable.clientWidth;

    							//Setting the Host information[Required][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//Kind of merge [Optional, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//Edit kind [Optional, Default false]
    							Editable = true;

    							//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(1, 1, 3, onepagerows);

    							var HeadTitle1 = "|Seq.|Date|Vessel/Voyage/Direction|Amount";						
    							
    							var headCount = ComCountHeadTitle(HeadTitle1); 
    							

    							//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// Setting function handling header
    							InitHeadMode(true, true, false, true, false,false);

    							//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							InitHeadRow(1, HeadTitle2, true);
    							var prefix = "t2sheet1_";
    							//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtDataSeq,		70,		daCenter,	true,	"Seq");
    							InitDataProperty(0, cnt++ , dtData,			270,	daCenter,	true,	prefix+"trns_dt",	false,	"",	dfDateYmd,	0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			270,	daCenter,	true,	prefix+"vvd",		false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			270,	daRight,	true,	prefix+"amount",	false,	"",	dfNullFloat,2,	false,	false, 18);

    					}
    					break;


    				case "t3sheet1":
    					with (sheetObj) {
    							// Setting height
    							style.height = 280;
    							//Setting width
    							SheetWidth = mainTable.clientWidth;

    							//Setting the Host information[Required][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//Kind of merge [Optional, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//Edit kind [Optional, Default false]
    							Editable = true;

    							//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(1, 1, 3, onepagerows);

    							var HeadTitle1 = "|Seq.|Date|Vessel/Voyage/Direction|Amount";
    							
    							var headCount = ComCountHeadTitle(HeadTitle1); 
    							

    							//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// Setting function handling header
    							InitHeadMode(true, true, false, true, false,false);

    							//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							InitHeadRow(1, HeadTitle2, true);

    							var prefix = "t3sheet1_";
    							//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtDataSeq,		70,		daCenter,	true,	"Seq");
    							InitDataProperty(0, cnt++ , dtData,			270,	daCenter,	true,	prefix+"trns_dt",	false,	"",	dfDateYmd,	0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			270,	daCenter,	true,	prefix+"vvd",		false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			270,	daRight,	true,	prefix+"amount",	false,	"",	dfNullFloat,2,	false,	false, 18);

    					}
    					break;
    						
    						
          }
        }

        /*
         * Handling the process about the sheet
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

             case IBSEARCH:  //Search
		       	if(validateForm(sheetObj,formObj,sAction)){
					if ( sheetObj.id == "t1sheet1"){
						var prefix = "t1sheet1_";
			       		formObj.f_cmd.value = SEARCH;
			       		ComClearFormSeparator(formObj);  
    					sheetObj.DoSearch("EXP_SPP_0004GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
    					ComSetFormSeparator(formObj);  
    					
    					if(sheetObj.TotalRows==0) break;  

    					//Getting the subtotal
    					var sumCols = prefix+"amount_debit"+"|"+prefix+"amount_credit";
    					var otherColText = prefix+"seq="+(sheetObj.TotalRows+1)+";"+prefix+"item=Total";
    					var captionCol = sheetObj.SaveNameCol(prefix+"item");
    					sheetObj.ShowSubSum(prefix+"vndr_seq", sumCols, true, false, false, captionCol, otherColText); 
    					
    					//Ending Balance
    					computeEndBal(sheetObj);
    					
    					//Changing editable to the Others item. 
    					var tmpRow = sheetObj.findText(prefix+"pso_msa_amt_tp_cd","O");
    					sheetObj.CellEditable(tmpRow, prefix+"amount_debit") = true;
    					sheetObj.CellEditable(tmpRow, prefix+"amount_credit") = true;
    					
    					//Changing the row status when MSA value does not exist(For saving all data at the first time)
    					if(sheetObj.CellValue(sheetObj.TopRow, prefix+"exist")=='N'){
    						for(ix=sheetObj.TopRow;ix<=sheetObj.RowCount;ix++){  //RowCount : The total row count(not included total row but subtotal one) 
    							sheetObj.RowStatus(ix) = 'I';
    						}
    					}
    					
    					formObj.pso_msa_sts_cd.value = sheetObj.CellValue(sheetObj.TopRow, prefix+"pso_msa_sts_cd");    					
						//Handling that the Request and Save buttons are activating/deactivating 
						setBtnEnable(formObj.pso_msa_sts_cd.value.trim());
						
						setCountReCalc(sheetObj);
					}
					
					else if ( sheetObj.id == "t2sheet1"){
						var prefix = "t2sheet1_";
			       		formObj.f_cmd.value = SEARCH02;
			       		ComClearFormSeparator(formObj); 
						sheetObj.DoSearch("EXP_SPP_0004GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						ComSetFormSeparator(formObj);  

    					if(sheetObj.TotalRows==0) break;  
					}
					
				    else if ( sheetObj.id == "t3sheet1"){
				    	var prefix = "t3sheet1_";
			       		formObj.f_cmd.value = SEARCH03;
			       		ComClearFormSeparator(formObj);       		
					  	sheetObj.DoSearch("EXP_SPP_0004GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						ComSetFormSeparator(formObj);  				  	

    					if(sheetObj.TotalRows==0) break;  
				    }
					
		       	}
				break;
			
			 case IBSAVE:  //Save		 
		       	if(validateForm(sheetObj,formObj,sAction)){
  					if (!sheetObj.IsDataModified) {	//There is no data to save.	
  						ComCodeMsgByNoContentsSave();
  						return; 
  					} 
  					
  					//Handling the multi data
  	    		  	formObj.f_cmd.value = MULTI;
  	    		  	formObj.pso_msa_sts_cd.value = "R";
  	    		  	
  	    		    ComClearFormSeparator(formObj);
  					var sParam = FormQueryStringOrg(formObj);
  					ComSetFormSeparator(formObj);
  					
  					var sParam1 = sheetObj.GetSaveString();
  					
  					if (sParam1 == "") {
  						ComCodeMsgByNoContentsSave();
  						return; 
  					}
  					
  	    			if(!ComCodeMsgBySave()) return;   
  	    		  	
  					sParam = sParam + "&" + sParam1;  //Ready
  	    		  	
  	    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0004GS.do", sParam);
  	    			//sheetObj.ShowDebugMsg = false;
  	    			sheetObj.LoadSaveXml(sXml);  
  	    			
                	if(ComSaveXml2ScssTF(sXml, "TR-ALL", 0)){
                		formObj.pso_msa_sts_cd.value = "R";
                		//Handling that the Request and Save buttons are activating/deactivating 
						setBtnEnable(formObj.pso_msa_sts_cd.value.trim());	 
						
		    			//Returning msa value to the opener window
		            	var strRslt = formObj.pso_msa_sts_cd.value;
		            	strRslt += ROWMARK;
						window.returnValue = strRslt;
                	}
		       	}
	            break;
	              
			 case COMMAND01:  //Request
				if (sheetObj.IsDataModified) {	//There is some data to save				
					ComShowCodeMessage("SPP01008");  //There is contents to save. First, save contents!
					return; 
				}

				//Handling multi data
				formObj.f_cmd.value 		 = COMMAND01;
				formObj.pso_msa_sts_cd.value ='Q';

				ComClearFormSeparator(formObj); 
				var sParam = FormQueryStringOrg(formObj);
				ComSetFormSeparator(formObj);
				
	 		  	//Do you want to request contents finally?
	 			if(!ComShowCodeConfirm('SPP01009')) return;
	 			
				//sheetObj.ShowDebugMsg = true;
    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0004GS.do", sParam);
    			
    			ComShowMessage(ComSaveXml2Message(sXml, "MESSAGE", 0)); 
            	if(!ComSaveXml2IsTagExist(sXml, "ERROR")){  //There is no error tag
            		formObj.pso_msa_sts_cd.value = "Q";
            		//Handling that the Request and Save buttons are activating/deactivating  
					setBtnEnable(formObj.pso_msa_sts_cd.value.trim());	            		
    			
	    			//Returning msa value to opener window
	            	var strRslt = formObj.pso_msa_sts_cd.value;
	            	strRslt += ROWMARK;
					window.returnValue = strRslt;
					self.close();
            	}	 			
			    
				break;
            }
        }
        
        /**
         * Handling the process for the input validation
         */
        function validateForm(sheetObj,formObj,sAction){
           switch(sAction){
		       	 case IBSEARCH:	
			  	 	if(ComIsEmpty(formObj.vndr_seq.value)){
			  	 		ComCodeMsgByEmptyData("vndr_seq");
			  	 		return false;
			  	 	}  
			  	 	if(ComIsEmpty(formObj.rev_yrmon.value)){
			  	 		ComCodeMsgByEmptyData("rev_yrmon");
			  	 		return false;
			  	 	}          	 	
			  	 	break;
			  	 	
		       	 case IBSAVE:  //SAVE
			  	 	if(ComIsEmpty(formObj.vndr_seq.value)){
			  	 		ComCodeMsgByEmptyData("vndr_seq");
			  	 		return false;
			  	 	}  
			  	 	if(ComIsEmpty(formObj.rev_yrmon.value)){
			  	 		ComCodeMsgByEmptyData("rev_yrmon");
			  	 		return false;
			  	 	} 		       	 
		       	    break;
			  	 	
	             default:
		            break;			  	 	
           }
           return true;
        }
         
         /**
          * Handling that the Request and Save buttons are activating/deactivating 
          */        
          function setBtnEnable(procSts){
  			//activating/deactivating Request button 
  		    if(procSts!="R"){  //The status is not 'Ready'				
  				btn_Request.disabled = true;
  		    }else{
  		    	btn_Request.disabled = false;
  		    }
  			
  		    //activating/deactivating Save button
  		    if(procSts!="" && procSts!="R"){  //The status is not 'Ready' or it is not never been to save
  		    	btn_Save.disabled = true; 
  		    }else{
  		    	btn_Save.disabled = false;
  		    }        	
          }         
        
        /**
         * Getting Ending Balance
         */
        function computeEndBal(sheetObj){
        	var prefix = "t1sheet1_";
			var arrRowNo = sheetObj.FindSubSumRow().split(ROWMARK);  //Returning the subtotal row
			var tmpCreditVal = sheetObj.CellValue(arrRowNo[0],prefix+"amount_credit");  //getting the subtotal value
			var tmpDebitVal = sheetObj.CellValue(arrRowNo[0],prefix+"amount_debit");  //getting the subtotal value
			var tmpEndingVal = ComParseInt(tmpCreditVal) - ComParseInt(tmpDebitVal);  //credit-debit

			//RowCount : The total row count(not included total row but subtotal one)
			sheetObj.SumText(0, prefix+"seq") = (sheetObj.RowCount+1) + ""; 
			sheetObj.SumText(0, prefix+"item") = "Ending Balance";			
			if(tmpEndingVal<0){
				sheetObj.SumValue(0, prefix+"amount_debit") = Math.abs(tmpEndingVal);
				sheetObj.SumValue(0, prefix+"amount_credit") = 0;
			}else{
				sheetObj.SumValue(0, prefix+"amount_debit") = 0;
				sheetObj.SumValue(0, prefix+"amount_credit") = Math.abs(tmpEndingVal);
			}
        }
         
         /**
          * Calling this function when occurring onAfterEdit event in t1sheet1
          */
         function t1sheet1_OnAfterEdit(sheetObj, Row, Col){
        	var prefix = "t1sheet1_";
        	var tmpMsaClassCd = sheetObj.CellValue(Row, prefix+"pso_msa_amt_tp_cd");
        	var colId = sheetObj.ColSaveName(Col);
        	if(tmpMsaClassCd=="O" && (colId==prefix+"amount_debit" || colId==prefix+"amount_credit")){
        		//Getting the total
            	var arrRowNo = sheetObj.FindSubSumRow().split(ROWMARK);  //Getting the subtotal row        
            	//RowCount : The total row count(not included total row but subtotal one)
        		//TopRow : The index at the top of the data row
        		//LastRow : The index at the bottom of the data row(included the subtotal and total row)
        		sheetObj.CellValue2(arrRowNo[0], Col) = sheetObj.ComputeSum("|" + Col + "|", sheetObj.TopRow, sheetObj.LastRow-2);  
        		
	        	//Getting Ending Balance value 
	        	computeEndBal(sheetObj);
        	}
         	return;
         }
          
        /*
         * Calling this function when occurring onChange event in t1sheet1
         */
        function t1sheet1_OnChange(sheetObj, Row, Col, Value){
         	var prefix = "sheet1_";        	 
        	var colId = sheetObj.ColSaveName(Col);
        	switch(colId){
        	    case prefix+"amount_debit":
        	    case prefix+"amount_credit":
					break;
					
				default:

		        	computeEndBal(sheetObj);					
					break;
        	}
        } 
         
         /*
          * Calling this function when occurring OnSelectCell event in t1sheet1
          */         
        function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
        	setCountReCalc(sheetObj);
        }
        
        /*
         * Recalculating t1sheet1
         */         
        function setCountReCalc(sheetObj){
 			sheetObj.CountFormat = "[SELECTDATAROW / "+(sheetObj.RowCount-1)+"]";
        }
        
        
      
