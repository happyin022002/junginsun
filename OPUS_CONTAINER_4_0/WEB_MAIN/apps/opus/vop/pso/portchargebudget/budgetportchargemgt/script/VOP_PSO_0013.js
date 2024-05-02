/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : vop_pso_0013.js
*@FileTitle : Monthly Estimation Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var isShift=false;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
        switch(srcName) {
	        case "btns_calendar_s0":
	        	var cal=new ComCalendar();
	        	cal.setDisplayType('month');
	            cal.select(form.exe_yrmon, "yyyy-MM");
	        	break;
            case "btns_calendar_s":
            	var cal=new ComCalendar();
            	cal.setDisplayType('month');
	            cal.select(form.txtsdate, "yyyy-MM");
            	break;
            case "btns_calendar_e":
            	var cal=new ComCalendar();
            	cal.setDisplayType('month');
            	cal.select(form.txtedate, "yyyy-MM");
            	break;
            case "btn_Retrieve":
//					alert(srcName);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
            case "btn_New":
//	            	alert(srcName);
				clearCondition(formObject);
            	break;
			case "btn_Detail":
//					alert(srcName);
//					alert(sheetObject1.CellValue(sheetObject1.SelectRow , "sheet1_acct_cd"));
//					alert(sheetObject1.SelectRow);				
//				if(sheetObject1.GetSelectRow() == -1 ) break;
				var turl="/opuscntr/VOP_PSO_0207.do?";
				turl += "exe_yrmon="+formObject.exe_yrmon.value;
				turl += "&sdt="+formObject.txtsdate.value;
				turl += "&edt="+formObject.txtedate.value;	
				turl += "&xxx="   +(sheetObject1.GetCellText(sheetObject1.GetSelectRow(), "sheet1_act_dt")==-1 ? "" : sheetObject1.GetCellText(sheetObject1.GetSelectRow(), "sheet1_act_dt"));
				turl += "&acct_cd="+(sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_acct_cd") == -1 ? "":sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_acct_cd"));
				turl += "&cost_cd="+(sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_cost_cd") == -1 ? "":sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_cost_cd"));
				//turl += "&acctCd="+sheetObject1.GetCellValue(selectRow, "sheet1_acct_cd");
				ComOpenPopup( turl , 1150, 700, '', '0,0', true, true); 
				break;
			case "btn_creation":
				doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
				break;
			case "btn_Excel":
				if(sheetObject1.RowCount() < 1){//no data
           		 	ComShowCodeMessage("COM132501");
   	       		}else{       
   	       			sheetObject1.Down2Excel({ HiddenColumn:1 , Merge:1, SheetDesign:1, SheetName : "Monthly Estimation"});
		        }
				break;
            case "btn_DtlExcel":
                //doActionIBSheet(sheetObjects[1],document.form,IBDOWNEXCEL);
                doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC02); //BackEndJob
                
                break;
			default : break;
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
     * Clearing Conditions
     * @param formObj
     * @return
     */
    function clearCondition(formObj){
    	form.exe_yrmon.value="";
    	form.txtsdate.value="";
    	form.txtedate.value="";
    	sheetObjects[0].RemoveAll();
     	document.form.exe_yrmon.value=ComGetDateAdd(ComGetNowInfo("ym")+"01","M",-1,"-").substring(0,7);
    	//setToday(document.form.exe_yrmon, "ym");//Setting current year
    	//setToday(document.form.txtsdate, "ym");//Setting current year
    	//setToday(document.form.txtedate, "ym");//Setting current year
    	//form.txtsdate.focus();
     	ComEnableObject(document.form.btn_DtlExcel, false);
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
     * adding first-served functions after loading screen
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		initControl();
		ComEnableObject(document.form.btn_DtlExcel, false);
		sheet1_OnLoadFinish(sheet1);
    }
    
    function sheet1_OnLoadFinish(sheetObj){ 
		var formObj=document.form;
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);	//Check Running Batch
	}
	/*
	 * registering initial event
	 */
	function initControl(){
		axon_event.addListener ('keydown', 'obj_keydown', 'form');
		//axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
		//axon_event.addListenerForm('keyup', 'obj_keyup', form);
		//axon_event.addListenerFormat('beforeactivate', 	'obj_focus',    	form);
     	axon_event.addListenerFormat('blur',  	'obj_blur',  	form);
    	//setToday(document.form.txtsdate, "ym");//Setting current year
    	//setToday(document.form.txtedate, "ym");//Setting current year
    	//setToday(document.form.exe_yrmon, "ym");//Setting current year
     	document.form.exe_yrmon.value=ComGetDateAdd(ComGetNowInfo("ym")+"01","M",-1,"-").substring(0,7);
     	document.form.txtsdate.focus();
	}
	function obj_keydown(){
	       	isShift=event.shiftKey ? true : false;
	   	if(event.keyCode ==13 && checkPeriod()) 
	       		ComKeyEnter();
	}
	function checkPeriod(){
		 var formObj=document.form;
	   	 obj=ComGetEvent();      	
	   	 with(formObj){
	   		 if(obj.name=="txtsdate" || obj.name=="txtedate" || obj.name == "btn_Retrieve"){
	   			 var creDtFr=ComReplaceStr(txtsdate.value,"-","");
	   			 var creDtTo=ComReplaceStr(txtedate.value,"-","");
	   			 switch(ComGetEvent("name")) {
		    	    	case "txtsdate":	// Agreement From Date
		    	    		if(creDtFr != '' && creDtTo != ''){
		    	    			if(creDtFr > creDtTo){
		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
		    	    				txtsdate.value='';
		    	    				document.form.txtsdate.focus();
		    	    				return false;
		    	    			}
		    	    		}
		    	            break;
		    	    	case "txtedate":	// Agreement To Date
		    	    		if(creDtFr != '' && creDtTo != ''){
		    	    			if(creDtFr > creDtTo){
		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
		    	    				txtedate.value='';
		    	    				txtedate.focus();
		    	    				return false;
		    	    			}
		    	    		}
		    	           	break;	
		        	}
	   		 }
	       }
	       return true;	
	}
     /**
      * Handling onBlur Event
      * @return
      */
     function obj_blur(){
    	 var formObj=document.form;
	   	 obj=event.srcElement;      	
	   	 with(formObj){
	   		 if(obj.name=="txtsdate" || obj.name=="txtedate" || obj.name =="exe_yrmon"){
	   			 var creDtFr=ComReplaceStr(txtsdate.value,"-","");
	   			 var creDtTo=ComReplaceStr(txtedate.value,"-","");
	   			 switch(ComGetEvent("name")) {
		    	    	case "txtsdate":	// Agreement From Date
		    	    		if(creDtFr != '' && creDtTo != ''){
		    	    			if(creDtFr > creDtTo){
		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
		    	    				txtsdate.value='';
		    	    				document.form.txtsdate.focus();
		    	    				return false;
		    	    			}
		    	    		}
		    	            break;
		    	    	case "txtedate":	// Agreement To Date
		    	    		if(creDtFr != '' && creDtTo != ''){
		    	    			if(creDtFr > creDtTo){
		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
		    	    				txtedate.value='';
		    	    				txtedate.focus();
		    	    				return false;
		    	    			}
		    	    		}
		    	           	break;	
		        	}
	   			ComChkObjValid(obj);
	   		 }
	       }
	       return true;	
     }
     /**
      * Handling onFocus Event 
      * @return
      */
     function obj_focus(){
         ComClearSeparator(ComGetEvent());
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
    			            			      
    				        var HeadTitle1="|Seq.|Activity Month\n(ATD/ETD)|Account Code|Cost Code/Description|Cost Code/Description|Estimate Cost|Actual Cost|Accrual Cost";
    				        var headCount=ComCountHeadTitle(HeadTitle1);
    				        var prefix="sheet1_";
    
    				        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
    
    				        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    				        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    				        InitHeaders(headers, info);
    
            			    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
            			             {Type:"Seq",      Hidden:0, 	Width:50,   Align:"Center",		ColMerge:0,   SaveName:"seq" },
            			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"act_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cost_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            			             {Type:"Float",     Hidden:0,  Width:190,  Align:"Right",   ColMerge:1,   SaveName:prefix+"estm_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
            			             {Type:"Float",     Hidden:0,  Width:190,  Align:"Right",   ColMerge:1,   SaveName:prefix+"act_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
            			             {Type:"Float",     Hidden:0,  Width:190,  Align:"Right",   ColMerge:1,   SaveName:prefix+"accl_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
            			       
            			    InitColumns(cols);
            			    SetEditable(0);
            			    SetColProperty(0,prefix+"act_dt", {Format:"####-##"} );
            			    //SetSheetHeight(445);
            			    resizeSheet(sheetObj);
		                }
					break;

    			    case "sheet2":
    			        with (sheetObj) {
    			            var HeadTitle1 = "||Seq.|Activity Date\n(ATD/ETD)|Account\nCode|Cost\nCode|Revenue\nlane|Conti.|Port|Port\nSeq.|Revenue VVD|Cur.|Estimate Cost|Actual Cost|Accrual Cost|Update\nFlag|Update\nUser|Update\nDate|SYS_SRC_ID|ESTM_SEQ_NO|EXE YRMON|REV YRMON";
    			            var headCount = ComCountHeadTitle(HeadTitle1);
    	                    var prefix="sheet2_";    			            

    			            SetConfig({SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1});

    			            var info = {Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1};
    			            var headers = [ { Text : HeadTitle1, Align : "Center"} ];
    			            InitHeaders(headers, info);

    			            var cols = [ 
    			                         {Type:"Status",    Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
    			                         {Type:"CheckBox",  Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Seq",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
    			                         {Type:"Text",      Hidden:0,  Width:85,  Align:"Center",  ColMerge:1,   SaveName:prefix+"act_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rev_lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"conti_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_ind_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rev_vvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"estm_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    			                         {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"act_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"accl_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sys_src_id" },
    			                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"estm_seq_no" },
    			                         {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"exe_yrmon"},
    			                         {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"rev_yrmon"} ];

    			            InitColumns(cols);
    			            SetColProperty(0, prefix + "act_dt", {Format : "####-##-##"});
    			            SetEditable(1);
    			            //SetSheetHeight(390);
    			            //resizeSheet(sheetObj);
    			        }

    			        break;					
            }
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        switch (sAction) {
			case IBSEARCH: //Retrieving
				if (validateForm(sheetObj, formObj, sAction)) {
					if (sheetObj.id == "sheet1") {
//						ComOpenWait(true);
//						formObj.f_cmd.value = SEARCH;
//						sheetObj.DoSearch("VOP_PSO_0013GS.do", FormQueryString(formObj)
//								+ "&" + ComGetPrefixParam("sheet1_"));
//						ComOpenWait(false);
						sheetObjects[0].SetWaitImageVisible(0);
						formObj.f_cmd.value=SEARCH;
 		                var sXml=sheetObj.GetSearchData("VOP_PSO_0013GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
		                var isRunning=ComGetEtcData(sXml, "IS_RUNNING");
		                formObj.status.value=isRunning == "true" ? "Processing" : "";
		                sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
					}
				}
				break;
			case IBCREATE: //Creation
				if (validateForm(sheetObj, formObj, sAction)) {
					if(!ComShowCodeConfirm("PSO00041", "create accrual amount")){
						break;
					}
					if (sheetObj.id == "sheet1") {
						ComOpenWait(true);
						//formObj.f_cmd.value = COMMAND02;	//[2010.05.12:jmh]
						formObj.f_cmd.value=ADD;
 						var sXml=sheetObj.GetSearchData("VOP_PSO_0013GS.do", FormQueryString(formObj)
								+ "&" + ComGetPrefixParam("sheet1_"));
						var statusCode=ComGetEtcData(sXml, "BatchStatus" );
//						alert(statusCode);
						sheetObj.RemoveAll();
						ComOpenWait(false);
						switch(statusCode){
//						case "0": // H/C
						case "4":	//Completed
							ComShowCodeMessage("COM12116", "Monthly Estimation Creation");
							break;
						case "5":	//failed
							ComShowCodeMessage("COM12151", "Monthly Estimation Creation");
							break;
						case "6":	//Processing
							formObj.status.value="Processing";
							ComShowCodeMessage("PSO00038", "Monthly Estimation Creation");
							break;
						default: break;		
						}
					}
				break;
				}
         	case IBSEARCH_ASYNC01:      //OPEN (Check Running Batch)
     			var aryPrefix=new Array("sheet1_");
     			formObj.f_cmd.value=COMMAND02;
     			sheetObjects[0].SetWaitImageVisible(0);
      			var sXml=sheetObj.GetSearchData("VOP_PSO_0013GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
     			var isRunning=ComGetEtcData(sXml, "IS_RUNNING");
     			formObj.status.value=isRunning == "true" ? "Processing" : "";
//     			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
             	break;	
             	
             	
            case IBDOWNEXCEL:      //Detail Down Excel
                var aryPrefix=new Array("sheet2_");
                formObj.f_cmd.value=SEARCH02;
                sheetObj.RemoveAll();
                //sheetObjects[0].SetWaitImageVisible(0);
                //ComOpenWait(true);
                ComOpenWait(true);
                
                setTimeout( function () {
                    var sXml=sheetObj.GetSearchData("VOP_PSO_0013GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                    
                    var transResultKey   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");//2016.01.13 NYK Add.
                    if(!ComIsEmpty(transResultKey) && transResultKey == "F"){
                        //ComOpenWait(false);                    
                    }else{
                        var isRunning=ComGetEtcData(sXml, "IS_RUNNING");
                        formObj.status.value=isRunning == "true" ? "Processing" : "";
                        sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
                        //ComOpenWait(false);
                    }
                    ComOpenWait(false);
                    
                    if(sheetObjects[1].RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                    }else{       
                        sheetObjects[1].Down2Excel({ HiddenColumn:1 , Merge:1, SheetDesign:1, SheetName : "Monthly Detail Estimation"});
                    }
                    
                } , 100);
                //sheetObjects[0].SetWaitImageVisible(1);
                    
                break; 

            case IBSEARCH_ASYNC02: //BackEndJob Start - process 1.
                var aryPrefix=new Array("sheet2_");
                formObj.f_cmd.value=SEARCH03;
                var sXml=sheetObj.GetSearchData("VOP_PSO_0013GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                
                var transResultKey   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");//2016.01.13 NYK Add.
                if(!ComIsEmpty(transResultKey) && transResultKey == "F"){
                    //ComOpenWait(false);                    
                }else{
                    var isRunning=ComGetEtcData(sXml, "IS_RUNNING");
                    formObj.status.value=isRunning == "true" ? "Processing" : "";
                    
                    var key=ComGetEtcData(sXml,"key");
                    if (key.length > 0) {
                        formObj.key.value=key;
                        sheetObj.SetWaitImageVisible(0);
                        ComOpenWait(true);
                        sheetObj.SetWaitTimeOut(10000);
                        timer = setInterval(getBackEndJobStatus, 3000); // action getBackEndJobStatus function after 3 seconds.
                    }
                    
                }
                
                break; 
                
            case IBSEARCH_ASYNC03:  //BackEndJob Status - process 2.  
                var aryPrefix=new Array("sheet2_");      
                formObj.f_cmd.value=SEARCH04;
                var sXml=sheetObj.GetSearchData("VOP_PSO_0013GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                var jobState=ComGetEtcData(sXml, "jb_sts_flg")+"";
                // 2 : processing, 3:success , 4:fail
                if (jobState == "3") {//success
                    //ComOpenWait(false);
                    clearInterval(timer);
                    //ComShowCodeMessage("JOO00160"); //Success to execute
                    //ComShowMessage("Success to execute.");
                    //if (gRefresh)
                    getBackEndJobLoadFile();
                    //doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
                } else if (jobState == "4") {
                    ComOpenWait(false);
                    clearInterval(timer);
                    ComShowMessage("Fail to retrieve.");
                } else if (jobState == "5") {
                    ComOpenWait(false);
                    clearInterval(timer);
                    ComShowMessage("Read result file aleady.");
                }
                break;
                                
            case IBSEARCH_ASYNC04://BackEndJob result - process 3. 
                var aryPrefix=new Array("sheet2_");          
                
                //sheetObj.SetWaitImageVisible(0);
                formObj.f_cmd.value=SEARCH05;
                var sXml=sheetObj.GetSearchData("VOP_PSO_0013GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
                ComOpenWait(false);
                if(sheetObjects[1].RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{       
                    sheetObjects[1].Down2Excel({ HiddenColumn:1 , Merge:1, SheetDesign:1, SheetName : "Monthly Detail Estimation"});
                }
                ComOpenWait(false);
                break;
                
			default:
				break;
		}
    }

    function getBackEndJobStatus() {
        //alert("UF_getBackEndJobStatus");
        doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC03);
    }
    
    function getBackEndJobLoadFile() {
        document.form.f_cmd.value = SEARCH05;
        document.form.action = "VOP_PSO_0013DL.do";
        document.form.submit();
        ComOpenWait(false);
    }

    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        if(sheetObj.RowCount() < 1){//no data
            ComEnableObject(document.form.btn_DtlExcel, false);
        }else{       
            ComEnableObject(document.form.btn_DtlExcel, true);
        }
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    
    	if(formObj.exe_yrmon.value == "" || formObj.exe_yrmon.value.length != 7){
    		ComShowCodeMessage("PSO00022", "[Accrual Month]");
    		ComSetFocus(formObj.exe_yrmon);
    		return false;
    	}
    	//check mandatory input
    	/*if(formObj.txtsdate.value =="" || formObj.txtsdate.value =="undefined"){
    		 ComShowCodeMessage("PSO00003", "From Activity Month");
    		 formObj.txtsdate.focus();
    		 return false;
    	}
    	else if(formObj.txtedate.value =="" || formObj.txtsdate.value =="undefined"){
    		 ComShowCodeMessage("PSO00003", "To Activity Month");
    		 formObj.txtedate.focus();
    		 return false;
    	}*/
    	return true;
    }
    

    function resizeSheet(){
    	for (var i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }
    