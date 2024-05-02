/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1006.js
*@FileTitle : 1007 Queue Detail Return Reason
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------The following code is added to make a good JSDoc ------------------*/
    /**
     * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
     * @extends 
     * @class esm_bkg_1007  business script.
     */
    function esm_bkg_1007() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick     = sheet1_OnClick;
    	this.sheet1_OnKeyUp     = sheet1_OnKeyUp;
    	this.setComboObject 		= setComboObject;
    }
    
   	/* Developer Work	*/
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 // global variable
 var sheetObjects = new Array();
 var sheetCnt = 0;

 var prefix = "sheet1_";
 
 var rowsPerPage = 50; 
 
 var grp_cd ="";//global parameter for Current Queue retrieve  
 var queueMap = new Array();
 
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
	
     
	//Set IBCombo Object In comboObjects array
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	} 	
	


  	
	
 /*********************** EDTITABLE MULIT COMBO END********************/ 
 
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
			  //MultiCombo 
	 	    for(var k=0;k<comboObjects.length;k++){
	 	        initCombo(comboObjects[k],comboObjects[k].id);
	 	    }
	 	    
		   // initControl();
		 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		    //form.p_vvd.focus();
		 		    
     }
     

	
	

    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); 
        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- focus out     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- focus in
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }        
    
    

 /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "engup":
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        ComKeyOnlyNumber(event.srcElement);
	        break;	            
	      case "custname":
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	        break;	            
	      default:
	    }
	}  
	
	  /**
     * onBlur control.
     **/
    function bkg_deactivate() {
    	
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "dura_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;
	    	case "dura_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
    		
				default:
					break;
	    }
    }        

	/**
	 * onFocus event Validation check. <br>
	 **/
	function bkg_activate(){
		//input Validation check
		switch(event.srcElement.name){	
	    	case "dura_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "dura_to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}  

/*********************** KEY EVENT END ********************/

  
// Event handler processing by button click event */
 		document.onclick  = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject1 = sheetObjects[0];
					
					var comboObject1 = comboObjects[0]; 
          /*******************************************************/
          var formObject = document.form;

	     	try {
	     		
	     		var srcName = window.event.srcElement.getAttribute("name");
	     		
		 			switch(srcName) {
		 				case "btn_Close":
		 						self.close();
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
 

   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case IBSEARCH:      //Retrieve
							if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH;
							sheetObj.WaitImageVisible = false;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0985GS.do", FormQueryString(formObj));
							if(isNullEtcData(sXml)){
								break;
							}
							
							if(ComGetEtcData(sXml, "rsn_bkg_mn_flg") == "Y") form.rsn_bkg_mn_flg.checked = true;
							if(ComGetEtcData(sXml, "rsn_cust_info_flg") == "Y") form.rsn_cust_info_flg.checked = true;
							if(ComGetEtcData(sXml, "rsn_frt_chg_flg") == "Y") form.rsn_frt_chg_flg.checked = true;
							if(ComGetEtcData(sXml, "rsn_cntr_flg") == "Y") form.rsn_cntr_flg.checked = true;
							if(ComGetEtcData(sXml, "rsn_cntr_mf_flg") == "Y") form.rsn_cntr_mf_flg.checked = true;
							
							if(ComGetEtcData(sXml, "rsn_dcgo_flg") == "Y") form.rsn_dcgo_flg.checked = true;
							if(ComGetEtcData(sXml, "rsn_awk_cgo_flg") == "Y") form.rsn_awk_cgo_flg.checked = true;
							if(ComGetEtcData(sXml, "rsn_rc_flg") == "Y") form.rsn_rc_flg.checked = true;
							if(ComGetEtcData(sXml, "rsn_bb_cgo_flg") == "Y") form.rsn_bb_cgo_flg.checked = true;
							if(ComGetEtcData(sXml, "rsn_rly_port_flg") == "Y") form.rsn_rly_port_flg.checked = true;
							
							if(ComGetEtcData(sXml, "rsn_new_bkg_flg") == "Y") form.rsn_new_bkg_flg.checked = true;
							if(ComGetEtcData(sXml, "rsn_split_flg") == "Y") form.rsn_split_flg.checked = true;
							if(ComGetEtcData(sXml, "rsn_bl_info_flg") == "Y") form.rsn_bl_info_flg.checked = true;
							if(ComGetEtcData(sXml, "rsn_hbl_flg") == "Y") form.rsn_hbl_flg.checked = true;
							if(ComGetEtcData(sXml, "cust_verif_flg") == "Y") form.cust_verif_flg.checked = true;					
														
			 				break;				 			
			 			case SEARCH01:      //Permissions retrieve
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH01;
							sheetObj.WaitImageVisible = false;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_1007GS.do", FormQueryString(formObj));
							grp_cd = ComGetEtcData(sXml, "grp_cd");
							formObj.grp_cd.value=grp_cd;				
							break;									
			    }
     }
     
     
     
     

     /*
      *  After processing the paging to handle as many variables for hadling
      */ 
      var pagedMaxCnt=2; 
			/**
       * after retrieve, event handling
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     }
   

   

     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
					if ( ComIsNull(formObj.bkg_no) ||  ComIsNull(formObj.sr_no) ||  ComIsNull(formObj.sr_knd_cd)) {
	     					ComShowCodeMessage('BKG00626','BKG NO, S/R No, S/R Kind Cd');
	     					return false;
			  	}	  		
					
	  			break;
    	 }
         return true;
     }
    
    function isNullEtcData(xmlStr){
    	var rtn = false;
    	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return true;

        var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;

        var etcNodes = etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn = true;
        
        return rtn;
    }
    

 /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

            case "sheet1":
              with (sheetObj) {
                 // setting height
                 style.height = 50;
                 
                 //setting width
                 SheetWidth = mainTable.clientWidth;

                 //setting Host information[mandatory][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //Kind of Merge [Option, Default msNone]
                 MergeSheet = msHeaderOnly;

                //Edit  [Option, Default false]
                 Editable = true;

								//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
								InitRowInfo(1, 1, 3, rowsPerPage);

								var HeadTitle1 = "SEQ";

                 
                var headCount = ComCountHeadTitle(HeadTitle1);

                //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // setting function handling header
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //Header information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
								//Data  attribute    [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
								InitDataProperty(0,		cnt++ , dtData,				30,		daCenter,	false,	prefix + "Seq",				false,		"",		dfNone,	0,		false,		false);
		
								CountPosition = 0;
		
 						}
 				
 					break;
         
         }
     }
    

	/* Developer Work End */    