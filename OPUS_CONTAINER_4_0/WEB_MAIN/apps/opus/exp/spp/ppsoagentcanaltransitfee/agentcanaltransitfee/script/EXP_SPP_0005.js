/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0005.js
*@FileTitle : Canal booking status for Panama
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
     * @class vop_pso_0013 : business script for vop_pso_0013 
     */
    function vop_pso_0013() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initControl 			= initControl;
    	this.obj_deactivate         = obj_deactivate;
    	this.obj_activate 			= obj_activate;
    	this.obj_keyup 				= obj_keyup;
    	this.obj_keypress 			= obj_keypress;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnScrollNext 	= sheet1_OnScrollNext;
    	this.sheet1_OnMouseMove 	= sheet1_OnMouseMove;
    	this.sheet1_OnChange 		= sheet1_OnChange;
    	this.sheet1_OnMouseDown 	= sheet1_OnMouseDown;
    	this.noDataUnCheckedHeader 	= noDataUnCheckedHeader;
    	this.setChecking 			= setChecking;
    }
    
    // The common global variables
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
        function processButtonClick(){

             var sheetObject1 = sheetObjects[0];

             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
	            case "btn_DownExcel":
	        	    if(sheetObject1.RowCount <= 0){
	        	        ComCodeMsgByNoRelatedData();  // There is no related data!
	        	        return;
	        	    }else{
	        	        if(sheetObject1.RowCount > 0){
	        	        	sheetObject1.Down2Excel(-1,true,true,true,"","",false,false,"Canal booking status for Panama");
	        	        }
	        	    } 
	        	    break;            
            	
	            case "btns_Calendar":
	            	var cal = new ComCalendarFromTo();
	            	cal.select(formObject.str_dt,  formObject.end_dt,  'yyyy-MM-dd');
	            	break;

	            case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
	            case "btn_Save":
	            	doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
	            	break;
	            	
				default : break;
				
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

        }
        
        /**
         * Adding some occurring events to form. 
         */
         function initControl() {
			 axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form); 
			// handling the occurring focus event to the all fields that contain dataformat attribute  
			 axon_event.addListenerFormat('focus', 	'obj_activate',    	form);
			// handling the occurring keyup event to the form in case of contain dataformat attribute
			 axon_event.addListenerFormat('keyup',  'obj_keyup',    	form); 	
			// handling the occurring keypress event to the form in case of contain dataformat attribute
			 axon_event.addListenerFormat('keypress', 'obj_keypress',   form);
			   
	         setToday(document.form.str_dt, "ymd"); 

	         document.form.end_dt.value = ComGetDateAdd(document.form.str_dt.value, "M", 1);

	         document.form.end_dt.focus();
	         document.form.str_dt.focus();
	         
			 sheetObjects[0].CellBackColor(1, "sheet1_"+"b_sts_cd") = sheetObjects[0].CellBackColor(0, 0);
			 sheetObjects[0].CellBackColor(1, "sheet1_"+"c_sts_cd") = sheetObjects[0].CellBackColor(0, 0);
			 sheetObjects[0].CellBackColor(1, "sheet1_"+"a_sts_cd") = sheetObjects[0].CellBackColor(0, 0);
      	 }  
         
         /*
         *  Handling the code when occurring blur event.
         */
         function obj_deactivate(){
     	     obj = event.srcElement;
             if(!ComChkObjValid(event.srcElement)) return;
             
             var formObj = document.form;
             var srcName = obj.getAttribute("name");
             switch(srcName){
                 case "str_dt":
                 case "end_dt":
                	 if(formObj.str_dt.value=="" || formObj.end_dt.value=="") break;
                	//validating the inputted from date and to date. The from date is more previous date than the to one.
                	 checkFromTo(formObj.str_dt, formObj.end_dt);
                	 break;
                	 
                 default:
                	 break;
             }
         }
        
         /*
         * Handling the code when occurring focus event.
         */
         function obj_activate(){
       	     obj = event.srcElement;
             ComClearSeparator(event.srcElement);    
             ComShowFocusCursor(obj); 
         }  
         
         /*
          * Handling the code when occurring keyup event.
          */ 
         function obj_keyup(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
    	           case "str_dt":
        	    	   ComKeyEnter('LengthNextFocus');
        		       break;
        		   default:
        			   break;
        	   }
         }
          
         /*
          * Handling occurring keypress event.
          */
          function obj_keypress(){
         	  obj = event.srcElement;
           	  var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
         	    
           	  if(obj.dataformat == null) return;
         	    
         	  if(keyValue == 13 ){
         	    	var formObj = document.form;
             	  	
			  	 	if(ComIsEmpty(formObj.str_dt.value)){
			  	 		ComCodeMsgByEmptyData("str_dt");
			  	 		formObj.str_dt.focus();
			  	 		return;
			  	 	}  
			  	 	if(ComIsEmpty(formObj.end_dt.value)){
			  	 		ComCodeMsgByEmptyData("end_dt");
			  	 		formObj.end_dt.focus();
			  	 		return;
			  	 	}              	  	
             	  	
             	  	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            	  	
         	    	return true;
         	  }
         	    
           	  window.defaultStatus = obj.dataformat;        	  
        	  
              switch(event.srcElement.dataformat){
          	      case "ymd":
          	        ComKeyOnlyNumber(event.srcElement);          	        
          	        break;
          	        
          	      default:
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

    				case "sheet1":
    					with (sheetObj) {
    							// Setting height
    							style.height = 360;
    							//Setting width
    							SheetWidth = mainTable.clientWidth;

    							//Setting Host information[Required][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//Kind of merge [Optional, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//Edit kind [Optional, Default false]
    							Editable = true;

    							//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(2, 1, 3, onepagerows);  //100 - 

    							var HeadTitle1 = "|VVD|Lane|Vessel Name|Coastal Schedule|Coastal Schedule|Coastal Schedule|Booking |Cancel |Auction |Hidden1|Hidden2|Hidden3|Hidden4";
    							var HeadTitle2 = "|VVD|Lane|Vessel Name|ETA|ETB|ETD|Booking|Cancel|Auction|Hidden1|Hidden2|Hidden3|Hidden4";	  
    							
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// Setting function handling header. [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
    							InitHeadMode(true, true, true, true, false, false);

    							//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							InitHeadRow(1, HeadTitle2, true);

    							var prefix = "sheet1_";
    							//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"vvd",		false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"vsl_slan_cd",false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			128,	daCenter,	true,	prefix+"vsl_nm",	false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			98,		daCenter,	true,	prefix+"vps_eta_dt",false,	"",	dfNone,		0,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtData,			98,		daCenter,	true,	prefix+"vps_etb_dt",false,	"",	dfNone,		0,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtData,			98,		daCenter,	true,	prefix+"vps_etd_dt",false,	"",	dfNone,		0,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtCheckBox,		66,		daCenter,	true,	prefix+"b_sts_cd",	false,	"",	dfNone,		0,	true,	true);
    							InitDataProperty(0, cnt++ , dtCheckBox,		57,		daCenter,	true,	prefix+"c_sts_cd",	false,	"",	dfNone,		0,	true,	true);
    							InitDataProperty(0, cnt++ , dtCheckBox,		63,		daCenter,	true,	prefix+"a_sts_cd",	false,	"",	dfNone,		0,	true,	true);
    							
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"pso_bztp_cd");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"vsl_cd");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"skd_voy_no");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"skd_dir_cd");

    							CountFormat = "[SELECTDATAROW / TOTALROWS]";  747
    						}
    						break;
    						
            }
        }

        /*
         * Handling the process about the sheet 
         */
        function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

              case IBSEARCH:     
              	if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id == "sheet1"){
						var prefix = "sheet1_";
						formObj.f_cmd.value = SEARCH;
						ComClearFormSeparator(formObj);  
						var CondParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
						var PageParam = "i_page=1";
						
    					sheetObj.CheckAll2(prefix+"b_sts_cd") = 0;
    					sheetObj.CheckAll2(prefix+"c_sts_cd") = 0;
    					sheetObj.CheckAll2(prefix+"a_sts_cd") = 0;
    					
						sheetObj.DoSearch4Post("EXP_SPP_0005GS.do", CondParam, PageParam);
						ComSetFormSeparator(formObj);  
						
  
    					if(sheetObj.TotalRows==0) break;  

					}
              	}
    		    break;
    		    
              case IBSEARCHAPPEND:  
                if(validateForm(sheetObj,formObj,IBSEARCH)){            	  
	           		if(sheetObj.id == "sheet1"){
	           			var prefix = "sheet1_";
	  	            	formObj.f_cmd.value = SEARCH;
	  	            	ComClearFormSeparator(formObj);  
	  	            	var PageParam = "i_page=" + PageNo;
	  	                sheetObj.DoSearch4Post("EXP_SPP_0005GS.do", CondParam, PageParam, true);
	  	                ComSetFormSeparator(formObj);
	  	              
	  	                if(sheetObj.TotalRows==0) break;	  	

	           		}
                }
                  break;    		    

    		  case IBSAVE:        
                if(validateForm(sheetObj,formObj,sAction)){
	           		if(sheetObj.id == "sheet1"){
	           			var prefix = "sheet1_";
	           			
	  					if (!sheetObj.IsDataModified) {				
	  						ComCodeMsgByNoContentsSave();
	  						return; 
	  					}
	           			
	  	            	formObj.f_cmd.value = MULTI;
	  	            	
	  	    		    ComClearFormSeparator(formObj); 
	  					var sParam = FormQueryStringOrg(formObj);
	  					ComSetFormSeparator(formObj);
	  					
	  					var sParam1 = sheetObj.GetSaveString();
	  					
	  					if (sParam1 == "") {
	  						ComCodeMsgByNoContentsSave();
	  						return; 
	  					}
	  	    		
	  	    			if(!ComCodeMsgBySave()) return;   
	  	    		  	
	  					sParam = sParam + "&" + sParam1;
	  					
	  	    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0005GS.do", sParam);
	  	    			//sheetObj.ShowDebugMsg = false;
	  	    			sheetObj.LoadSaveXml(sXml);  //Applying the saving data in the sheet before occurring onSaveEnd event.
	  	    										 //Need not to retrieve after saving
	  	    			
	  	    			//Running after occurring onSaveEnd event
	                	if(ComSaveXml2ScssTF(sXml, "TR-ALL", 0)){
	                		
	                	}	  					
	           		}
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
			  	 	if(ComIsEmpty(formObj.str_dt.value)){
			  	 		ComCodeMsgByEmptyData("str_dt");
			  	 		return false;
			  	 	}  
			  	 	if(ComIsEmpty(formObj.end_dt.value)){
			  	 		ComCodeMsgByEmptyData("end_dt");
			  	 		return false;
			  	 	}          	 	
			  	 	break;
			  	 	
		       	 case IBSAVE:  
			  	 	if(ComIsEmpty(formObj.str_dt.value)){
			  	 		ComCodeMsgByEmptyData("str_dt");
			  	 		return false;
			  	 	}  
			  	 	if(ComIsEmpty(formObj.end_dt.value)){
			  	 		ComCodeMsgByEmptyData("end_dt");
			  	 		return false;
			  	 	} 		       	 
		       	    break;
			  	 	
	             default:
		            break;			  	 	
             }
             return true;
        }
         
        /**
     	 * Calling this function in case of occurring onScrollNext event in sheet1 
     	 */
     	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
     		//OnePageRows - Being set the row count per page in InitRowInfo. same as document.form.pagerows.value
     		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
     	}
     	
     	/**
     	* Calling this function in case of occurring onMouseMove event in sheet1 
     	*/
     	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {	
      		var prefix = "sheet1_";
      		var Row = sheetObj.MouseRow;
      		var Col = sheetObj.MouseCol;
      		var colId = sheetObj.ColSaveName(Col);
     		if (Row>=sheetObj.TopRow && colId==prefix+"vsl_nm"){
     			sheetObj.MouseToolTipText = sheetObj.CellText(Row, Col);		   
     		} else {
     			sheetObj.MouseToolTipText = "";
     		}      
     	}     	 
     	 
        /**
      	 * Calling this function in case of occurring onChange event in sheet1 
      	 */
      	function sheet1_OnChange(sheetObj, Row, Col, Value) {
      		if(Value==0) return;
      		
      		var prefix = "sheet1_";
      		var colId = sheetObj.ColSaveName(Col);
  			switch(colId){
				case prefix+"b_sts_cd":
						//sheetObj.CellValue2(Row, prefix+"b_sts_cd") = 1;
						sheetObj.CellValue2(Row, prefix+"c_sts_cd") = 0;
						sheetObj.CellValue2(Row, prefix+"a_sts_cd") = 0;
					break;
				case prefix+"c_sts_cd":
						sheetObj.CellValue2(Row, prefix+"b_sts_cd") = 0;
						//sheetObj.CellValue2(Row, prefix+"c_sts_cd") = 1;
						sheetObj.CellValue2(Row, prefix+"a_sts_cd") = 0;
					break;
				case prefix+"a_sts_cd":
						sheetObj.CellValue2(Row, prefix+"b_sts_cd") = 0;
						sheetObj.CellValue2(Row, prefix+"c_sts_cd") = 0;
						//sheetObj.CellValue2(Row, prefix+"a_sts_cd") = 1;
					break;
					
				default:
					break;
			}      		
      	}  
      	
        /**
      	 * Calling this function in case of occurring onMouseDown event in sheet1 
    	 * @param : sheetObj, Button, Shift, X, Y
      	 */
      	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) { 
      		//alert(sheetObj.MouseRow +"/"+ sheetObj.MouseCol);
      		var prefix = "sheet1_";
      		var Row = sheetObj.MouseRow;
      		var Col = sheetObj.MouseCol;
      		var colId = sheetObj.ColSaveName(Col);
      		
      		//When the smaller header area of the top of the data row occurs event
      		if(Row>=0 && Row<sheetObj.TopRow){
      			switch(colId){
      				case prefix+"b_sts_cd":
      				    //Handling unchecked the check box of the header when there is no data.
      					if(noDataUnCheckedHeader(sheetObj, prefix+"b_sts_cd")) break;
      					break;
      					
      				case prefix+"c_sts_cd":
      				    //Handling unchecked the check box of the header when there is no data.
      					if(noDataUnCheckedHeader(sheetObj, prefix+"c_sts_cd")) break;
      					break;
      					
      				case prefix+"a_sts_cd":
      				    //Handling unchecked the check box of the header when there is no data.
      					if(noDataUnCheckedHeader(sheetObj, prefix+"a_sts_cd")) break;
      					break;
      					
      				default:
      					break;
      			}
      		}//
      		
      		//when the data row occurs event
      		else if(Row>=sheetObj.TopRow){
      			
          		var prefix = "sheet1_";
          		var colId = sheetObj.ColSaveName(Col);
      			switch(colId){
    				case prefix+"b_sts_cd":
    				case prefix+"c_sts_cd":
    				case prefix+"a_sts_cd":
    					
    					//Not to be able to check when Coastal Schedule value is not existed 
    	           		if(   sheetObj.CellValue(Row, prefix+"vps_eta_dt")!=''
    	           		   && sheetObj.CellValue(Row, prefix+"vps_etb_dt")!=''
    	           		   && sheetObj.CellValue(Row, prefix+"vps_etd_dt")!=''){
    	           			break; 
    	           		}
    	           		
    					sheetObj.RowEditable(Row) = false;

    					sheetObj.CellBackColor(Row, prefix+"b_sts_cd") = sheetObj.EditableColor;
    					sheetObj.CellBackColor(Row, prefix+"c_sts_cd") = sheetObj.EditableColor;
    					sheetObj.CellBackColor(Row, prefix+"a_sts_cd") = sheetObj.EditableColor;
    					break;
    					
    				default:
    					break;
      			}
      		}//
      		
      		
      	}
      	
      	/**
      	 * Handling unchecked the check box of the header when there is no data.
      	 */ 
      	function noDataUnCheckedHeader(sheetObj, colId){
			if(sheetObj.RowCount==0){
					sheetObj.CheckAll2(colId) = 2;
					return true;
			}
			return false;
      	}
      	
        /**
       	 * Reading the checked row number.
       	 * Releasing the check of the header
       	 * Getting the checked row number and resetting the check
       	 */
      	function setChecking(sheetObj, colId){
       	    sheetObj.Redraw = false;       		 
      		//Reading the checked row number.
			var iCheckRows = sheetObj.FindCheckedRow(colId);  
			//Releasing the check of the header
			sheetObj.CheckAll2(colId) = 0;
			//Resetting the check
      	    var arrRow = iCheckRows.split("|");
      	    var intArrLen = arrRow.length-1;
      	    for (idx=0; idx<intArrLen; idx++){
      	    	sheetObj.CellValue2(arrRow[idx], colId) = 1;
      	    }
      	    sheetObj.Redraw = true;
      	}

      	
      	

