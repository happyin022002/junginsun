/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0001.js
*@FileTitle : Expense Accrual Batch Main
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

	/**
	 * @extends 
	 * @class ESD_LEA_0001 : business script for ESD_LEA_0001 
	 */

	function ESD_LEA_0001() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
    
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	/* Event handler processing by button click event */
	document.onclick = processButtonClick;

	/* Event handler processing by button name */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		/**********************************************************************/
		
		var formObject = document.form;
 
		try {
				var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":     		
						lea_retrieve(sheetObject,formObject);        	            
						break;

					case "btn_batchstart":
						if(sheetObject.CellValue(1, "cond_cfm_flg") != "Y"){
							//ComShowMessage("Please check conditions before starting batch.");
							ComShowMessage(ComGetMsg("LEA90007"));
						  return false;
						}
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
        	            //ComShowMessage(ComGetMsg("LEA90025"));
            	        break;

            	    case "btng_confirm":
        	    		if(!(sheetObject.CellValue(1, "ap_clz_flg" ) == "Y" &&
							sheetObject.CellValue(1, "rev_vvd_if_flg" ) == "Y" &&
							sheetObject.CellValue(1, "mon_avg_xch_rt_if_flg" ) == "Y")){
							//ComShowMessage("Please check conditions before starting batch.");
							ComShowMessage(ComGetMsg("LEA90007"));
							return false;
        	    		}
        	    		doActionIBSheet(sheetObject,formObject,IBSAVE);
        	    		break;

            	    case "btns_rev_vvd_search":
						var url_str = "ESD_LEA_0902.do";
						url_str += "?exe_yrmon="	+formObject.frm_exe_yrmon.value;
						url_str += "&rev_yrmon="	+formObject.frm_exe_yrmon.value;
						window.showModalDialog(url_str, window, "dialogWidth:600px; dialogHeight:480px; help:no; status:no; resizable:yes;");
						//ComOpenWindow(url_str, "RevVVD", "statebar = no , width= 600 , height=500" );
						break;
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
			ComConfigSheet(sheetObjects[i]);
			
			initSheet(sheetObjects[i],i+1);
			
			ComEndConfigSheet(sheetObjects[i]);
		} 
		
		lea_enterRetrieve();
		
	}

	
	
       /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets 
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with (sheetObj) {
                        //Setting width
                        //SheetWidth = mainTable.clientWidth;
    										SheetWidth = 400;
                        //Setting the Host information[Required][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //Kind of merge [Optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //Edit kind [Optional, Default false]
                        Editable = true;

                        //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 9, 100);

                        //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(22, 0, 0, true);

                        // Setting function handling header
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle = "SEQ|Checking Items|Status" ;

                        //The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++,  dtStatus,    30,    daCenter,  true,    "ibflag");
                        InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  false,    ""												 ,        false,          "",       dfNone,   	0,     true,        true);
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "exe_yrmon"								 ,        false,          "",       dfNone,   	0,     false,        false);  	                                                             														
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "ap_clz_flg"               ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "ap_clz_flg_nm"            ,        false,          "",       dfNone,   	0,     false,        false);                                        
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "rev_vvd_if_flg"           ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "rev_vvd_if_flg_nm"        ,        false,          "",       dfNone,   	0,     false,        false);                                    
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "rev_vvd_if_knt"           ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mon_avg_xch_rt_if_flg"    ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mon_avg_xch_rt_if_flg_nm" ,        false,          "",       dfNone,   	0,     false,        false);                             
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mon_avg_xch_rt_if_knt"    ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mon_avg_xch_rt_if_flg_desc",        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "cond_cfm_flg"             ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "cond_cfm_flg_nm"          ,        false,          "",       dfNone,   	0,     false,        false);                                      
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mnl_inp_flg"              ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mnl_inp_flg_nm"           ,        false,          "",       dfNone,   	0,     false,        false);                                       
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "erp_if_flg"               ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "erp_if_flg_nm"            ,        false,          "",       dfNone,   	0,     false,        false);                                        
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "erp_if_flg_desc"          ,        false,          "",       dfNone,   	0,     false,        false);  
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "erp_if_dt"                ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "rev_vvd_if_desc"          ,        false,          "",       dfNone,   	0,     false,        false);                                                                          

                        style.height = GetSheetHeight(11) ;
                   }
                    break;

            }
        }

      // Handling the process about the sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

               case IBSEARCH:      //Retrieving
               		if (!lea_fnChkSearchForm(formObj)) return false;
            	            
    				    	formObj.f_cmd.value = SEARCH;
    				    	
    						 //var searchXml = sheetObj.GetSearchXml("ESD_LEA_0001GS.do", FormQueryString(formObj));
    				    	
    				    	var searchXml = sheetObj.GetSearchXml("ESD_LEA_0001GS.do",leaFormQueryString(formObj));
    				    	
    					    //ComShowMessage(searchXml);
    						  
    					    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
    					   
                    break;
                    
			case IBSAVE:  //Saving
				if (!lea_validateForm(sheetObj,formObj,sAction))return false;				
				formObj.f_cmd.value = MULTI01;
				//var savexml = sheetObj.GetSaveXml("ESD_LEA_0001GS.do", FormQueryString(formObj));
				
				var savexml = sheetObj.GetSaveXml("ESD_LEA_0001GS.do", leaFormQueryString(formObj));
				
				if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
				break;
			
				
			case IBSEARCH_ASYNC01: //Batch Start
			    if (!lea_validateForm(sheetObj,formObj,sAction))return false;
			    formObj.f_cmd.value = MULTI02;
			    
			    //var savexml = sheetObj.GetSaveXml("ESD_LEA_0001GS.do", FormQueryString(formObj));
			    
			    var savexml = sheetObj.GetSaveXml("ESD_LEA_0001GS.do", leaFormQueryString(formObj));
			    
			    
			    if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
			    ComShowMessage(sheetObj.EtcData("BATCH_EXE_RESULT"));
			    break;

			    

		}
	}
       
	
	/*
	 * Calling this function after saving the Sheet data
	 */
	function t1sheet1_OnSaveEnd(t1sheet1, ErrMsg) {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		//if (ErrMsg == null || ErrMsg == ""){
		lea_enterRetrieve();
		//}   
	} 
	
	
	/**
	 * Handling the retrieving process
	 */
	function lea_retrieve(sheetObj,formObj){
		sheetObj.RemoveAll();		
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
		lea_setSheetToForm(sheetObj,formObj);
	}    

	
	/**
	* Handling the retrieving process when pressed Enter key Event
	*/
	function lea_enterRetrieve(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;		 
		lea_retrieve(sheetObject,formObject);	
	}
    		

	/**
	* Handling the process for the input validation
	*/
	function lea_validateForm(sheetObj,formObj,sAction){
		return true;
	}
        

	/**
	 * Handling the process for the input validation
	 */
	function lea_fnChkSearchForm(formObj){
		if(!lea_comm_fnChkEmptyObj(formObj.frm_exe_yrmon)) return false;
		return true;
	}
      
	
	/**
	 *  Copy the sheet value to form one.
	 */
	function lea_setSheetToForm(sheetObj,formObj){
		if (sheetObj.RowCount > 0){
			formObj.frm_ap_clz_flg_nm.value = sheetObj.CellValue(1, "ap_clz_flg_nm"  );
			formObj.frm_rev_vvd_if_flg_nm.value = sheetObj.CellValue(1, "rev_vvd_if_desc" );
			formObj.frm_mon_avg_xch_rt_if_flg_nm.value = sheetObj.CellValue(1, "mon_avg_xch_rt_if_flg_desc");
			//formObj.frm_rev_vvd_if_knt.value = sheetObj.CellValue(1, "rev_vvd_if_knt" );
			formObj.frm_erp_if_flg_desc .value = sheetObj.CellValue(1, "erp_if_flg_desc" );

			//Activating confirm button by the condition.
			if( sheetObj.CellValue(1, "ap_clz_flg" ) == "Y" &&
				sheetObj.CellValue(1, "rev_vvd_if_flg"  			) == "Y" &&
				sheetObj.CellValue(1, "mon_avg_xch_rt_if_flg") == "Y"){
				//set_ButtonImageVisiable(formObj.btng_confirm,	true);
			}else{
				//set_ButtonImageVisiable(formObj.btng_confirm,	true);
				//set_ButtonImageVisiable(document.form.btng_confirm,	false);
			}
		}
	}
	
	
