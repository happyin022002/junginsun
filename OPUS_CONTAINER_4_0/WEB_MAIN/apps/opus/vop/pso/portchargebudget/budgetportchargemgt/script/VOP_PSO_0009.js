/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0009.js
*@FileTitle : Estimate VVD Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // public variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var isShift=false;
    var gSetHeaderRowHeight = 30;//Head Row Height
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
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
    function loadPage(){
    	//initSheet(sheetObjects[0],1);
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	} 
    	initControl();
    	sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
      var cnt=0;
	  var sheetid=sheetObj.id;
      switch(sheetid) {
	  	case "sheet1":
	  	    with(sheetObj){
	      
	      var HeadTitle1="|Rev Month|Target VVD|Rev Dir|Rev Lane|Type|Estimate Creation ID|Estimate Creation Date";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	      var prefix="sheet1_";

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rev_yrmon",      KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rev_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rlane_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"estm_vvd_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);

	      SetEditable(0);
	      SetShowButtonImage(1);
	      //SetHeaderRowHeight(gGetHeaderRowHeight);
	      //SetSheetHeight(440);
	      resizeSheet(sheetObj);
	      }


			break;
        }
    }
    /**
     * registering initial event 
     */
    function initControl(){
    	//setToday(document.form.rev_yrmon, "ym");//current month
    	document.form.rev_yrmon.value=ComGetDateAdd(ComGetNowInfo("ym")+"01","M",-1,"-").substring(0,7);
    	//axon_event.addListener ('keydown', 'obj_keydown', 'form');
    	//axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
    	//axon_event.addListenerForm('keyup', 'obj_keyup', form);
    	axon_event.addListenerFormat('beforedeactivate',  	'obj_blur',  	form);
    }
     function obj_keydown(){
        	isShift=event.shiftKey ? true : false;
//        	ComKeyEnter();
        }
    /**
     * Handling onBlur event
     * @return
     */
    function obj_blur(){
        ComChkObjValid(event.srcElement);
    }
    // Event handler processing by button name */
        function processButtonClick(){
             var sheetObject1=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
	                case "btns_calendar_s":
	                	var cal=new ComCalendar();
	                	cal.setDisplayType('month');
	    	            cal.select(form.rev_yrmon, "yyyy-MM");
	                	break;
                	case "btn_creation":
    					if(!ComShowCodeConfirm("PSO00041", "create data")){
    						break;
    					}
                		ComOpenWait(true);
                		doActionIBSheet(sheetObject1,formObject,IBCREATE);
                		ComOpenWait(false);                		
    					break;
                	case "btn_retrieve":
                		ComOpenWait(true);
                		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                		ComOpenWait(false);                		
                		break;
		            case "btns_search": //slane code button click
			        	  openLaneCode();
			            break;
		            case "btn_down_excel":						 
						 if(sheetObjects[0].RowCount() < 1){
							ComShowCodeMessage("COM132501");
						}else{
							 sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(	 sheetObjects[0]), SheetDesign:1,Merge:1 });
						}
						
						break;			            
		            default : break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowMessage(OBJECT_ERROR);
        		} else {
        			ComShowMessage(e);
        		}
        	}
        }
        /**
         *  handling sheet process
         */ 
        function doActionIBSheet(sheetObj,formObj,sAction) {
             sheetObj.ShowDebugMsg(false);
             sheetObj.SetWaitImageVisible(0);
             switch(sAction) {
             	case IBCREATE://Creation Button Click
             		if ( sheetObj.id == "sheet1"){
						formObj.f_cmd.value=ADD;
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("VOP_PSO_0009GS.do", FormQueryString(formObj));
						sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
						var statusCode=ComGetEtcData(sXml, "BatchStatus" );
						ComOpenWait(false);
						switch(statusCode){
//							case "0": // H/C
							case "4":	//Completed
								ComShowCodeMessage("COM12116", "Estimate VVD Creation Excution");
								break;
							case "5":	//failed
								ComShowCodeMessage("COM12151", "Estimate VVD Creation Excution");
								break;
							case "6":	//Processing
								formObj.status.value="Processing";
								ComShowCodeMessage("PSO00038", "Estimate VVD Creation");
								break;
							default: break;							
						}
             		}
             		break;
             	case IBSEARCH:      //Retrieving
 					if(validateForm(sheetObj,formObj,sAction)){
 						if ( sheetObj.id == "sheet1"){
 							var aryPrefix=new Array("sheet1_");
 							formObj.f_cmd.value=SEARCH;
 			                sheetObjects[0].SetWaitImageVisible(0);
 			                var sXml=sheetObj.GetSearchData("VOP_PSO_0009GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
 			                var isRunning=ComGetEtcData(sXml, "IS_RUNNING");
 			                formObj.status.value=isRunning == "true" ? "Processing" : "";
 			                sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
 						}
 					}
 					break;
             	case IBSEARCH_ASYNC01:      //OPEN (Check Running Batch)
         			var aryPrefix=new Array("sheet1_");
         			formObj.f_cmd.value=COMMAND02;
         			sheetObjects[0].SetWaitImageVisible(0);
         			var sXml=sheetObj.GetSearchData("VOP_PSO_0009GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
         			var isRunning=ComGetEtcData(sXml, "IS_RUNNING");
         			formObj.status.value=isRunning == "true" ? "Processing" : "";
         			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
	             	break;
             }
         }
        
        function sheet1_OnLoadFinish(sheetObj){ 
			var formObj=document.form;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);	//Check Running Batch
		}         
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            	switch(sAction){
	        		case IBSEARCH:
			        	if(rev_yrmon.value == "" || rev_yrmon.value.length != 7){
			        		ComShowCodeMessage("PSO00022", "[Accrual Month]");
			        		ComSetFocus(rev_yrmon);
			        		return false;
			        	}
			        	break;
            	}	
            }
            return true;
        }

        function resizeSheet(){
        	for (var i=0; i<sheetObjects.length; i++){
                ComResizeSheet(sheetObjects[i]);
            }
        }