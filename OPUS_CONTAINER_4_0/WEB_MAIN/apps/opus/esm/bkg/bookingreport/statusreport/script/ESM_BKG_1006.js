/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1006.js
*@FileTitle : 1006 Queue Detail Amend Reason Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class esm_bkg_1006 : business script for esm_bkg_1006
     */
    function esm_bkg_1006() {
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
    
   	
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 
 var sheetObjects = new Array();
 var sheetCnt = 0;

 var prefix = "sheet1_";
 
 var rowsPerPage = 50; 
 
 var grp_cd ="";
 var queueMap = new Array();
 
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
	
     
	//registering the created IBCombo Object at page as comboObjects list
	//ComComboObject is called from Constructor method  
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
			  // initializing MultiCombo 
	 	    for(var k=0;k<comboObjects.length;k++){
	 	        initCombo(comboObjects[k],comboObjects[k].id);
	 	    }
	 	    
		   // initControl();
		 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		    //form.p_vvd.focus();
		 		    
     }
     

	
	

    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- in case of typing keyboard
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
     * control onBlur of HTML Control
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
	 * checking validation at the onFocus event of HTML Control<br>
	 **/
	function bkg_activate(){
		//checking input Validation
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

			 			case IBSEARCH:      //retrieve
							if(!validateForm(sheetObj,formObj,sAction)) return;
			 				formObj.f_cmd.value = SEARCH;
			 				sheetObj.WaitImageVisible = false;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_1006GS.do", FormQueryString(formObj) +"&"+ ComGetPrefixParam(prefix));
							if(isNullEtcData(sXml)){
								break;
							}
							if(ComGetEtcData(sXml, "mis_typ") != '0') 	formObj.mis_typ.checked = true;
							if(ComGetEtcData(sXml, "mis_rat_sc") != '0') 	formObj.mis_rat_sc.checked = true;
							if(ComGetEtcData(sXml, "mis_rat_rfa") != '0') 	formObj.mis_rat_rfa.checked = true;
							if(ComGetEtcData(sXml, "wro_dat_inp") != '0') 	formObj.wro_dat_inp.checked = true;
							if(ComGetEtcData(sXml, "sal") != '0') 	formObj.sal.checked = true;
							if(ComGetEtcData(sXml, "fo_err") != '0') 	formObj.fo_err.checked = true;
							
							if(ComGetEtcData(sXml, "dat_mis") != '0') 	formObj.dat_mis.checked = true;
							if(ComGetEtcData(sXml, "unc_fax") != '0') 	formObj.unc_fax.checked = true;
							if(ComGetEtcData(sXml, "bl_dat_cha") != '0') 	formObj.bl_dat_cha.checked = true;
							if(ComGetEtcData(sXml, "cod") != '0') 	formObj.cod.checked = true;
							if(ComGetEtcData(sXml, "spl") != '0') 	formObj.spl.checked = true;
														
			 				break;				 			
			 			case SEARCH01:      // retrieve author
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH01;
							sheetObj.WaitImageVisible = false;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_1006GS.do", FormQueryString(formObj));
							grp_cd = ComGetEtcData(sXml, "grp_cd");
							formObj.grp_cd.value=grp_cd;				
							break;									
			    }
     }
     
     
     
     

     /*
      * init data is sheet header number.
      */ 
      var pagedMaxCnt=2; 
			/**
       * event handling after retrieve
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     }
   

   

     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
					if ( ComIsNull(formObj.bkg_no) ||  ComIsNull(formObj.sr_no)) {
	     					ComShowCodeMessage('BKG00626','BKG NO, S/R No');
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
      * @param sheetObj
      * @param sheetNo
      * @return 
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

                // setting Header Mode
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //Header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
								//Data attribute    [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
								InitDataProperty(0,		cnt++ , dtData,				30,		daCenter,	false,	prefix + "Seq",				false,		"",		dfNone,	0,		false,		false);
		
								CountPosition = 0;
		
 						}
 				
 					break;
         
         }
     }
    

	    