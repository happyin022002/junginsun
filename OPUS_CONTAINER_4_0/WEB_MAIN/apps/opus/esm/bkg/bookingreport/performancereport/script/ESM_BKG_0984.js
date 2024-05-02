/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0984.js
*@FileTitle : Queue Detail_Return to Return Message
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
					[Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


    /**
     * @fileoverview As a java script file that uses common on business, it has been defined about calendar-related functions.
     * @author 
     * @extends 
     * @class esm_bkg_0984  It defines business script that using screen for creation.
     */
    function esm_bkg_0984() {
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
    }
    
     /**
      * Registering IBSheet Object in to Array
      * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
      * The array is defined at upper part of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 // Common global variables
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var rowsPerPage = 50;
 
 var prefix = "sheet1_";//IBSheet Separator
 
 
 var grp_cd ="";//Global Variables for Current Queue inquiry  
 var queueMap = new Array();
 
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
	
     
	//Registering IBCombo Object in to comboObjects Array
	//Called from the ComComboObject constructor method
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	} 	
	


  	
	
 /*********************** EDTITABLE MULIT COMBO END********************/ 
 
     /**
      * Sheet basic setting & initializing
      * onLoad Event HandlerImplementation of body tag
      * After loading screen in the browser, add function in pre-processing
      */
	
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
		 			ComConfigSheet (sheetObjects[i] );
		 			initSheet(sheetObjects[i],i+1);
		 			ComEndConfigSheet(sheetObjects[i]);
		    }	
			 
			 checkInitData(form);
     }
   
   /**
    * Checking parameters when loading page<br>
    * Sending confirm message and hiding 'Return' button in case parameters are inaccurate.
    * */
    function checkInitData(formObj){
			if ( ComIsNull(formObj.src_cd) ||  ComIsNull(formObj.sr_no) ||  ComIsNull(formObj.bkg_no) || ComIsNull(formObj.sr_knd_cd) ) {
	     					//div_return.style.display = "none";
	     					btn_return_to_return_l.className ="btn2_left";
								btn_return_to_return_c.className ="btn2";
								btn_return_to_return_r.className ="btn2_right";
	     					ComShowCodeMessage('BKG00626','S/R CD, S/R No., BKG No., Amend Type CD');
			}    
    }
    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }        
    
    

 /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "engup":
	        //English capital letters
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //Inputting "Numbers+English capital letters"
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //Inputting Numbers
	        ComKeyOnlyNumber(event.srcElement);
	        break;	            
	      case "custname":
	        //Inputting Numbers
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	        break;	            
	      default:
	    }
	}  
	
	/**
     * Controlling onBlur of HTML Control.
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
	 * Checking Validation in onFocus event of HTML Control. <br>
	 **/
	function bkg_activate(){
		//Checking input validation
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

  
// Event Handler definition for Button Click event */
 		document.onclick  = processButtonClick;

 // Event Handler for branch processing by judging button name */
     function processButtonClick(){
          var sheetObject1 = sheetObjects[0];
					
          /*******************************************************/
          var formObject = document.form;

			try {
	     		
	     		var srcName = window.event.srcElement.getAttribute("name");
	     		
		 			switch(srcName) {
		 				case "btn_return_to_return": 				
		 					doActionIBSheet(sheetObject1,formObject,MODIFY01);
		 					opener.location.reload();
		 					break;	
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
 

   // Handling process about Sheet
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

						case MODIFY01:        //Save
				 				formObj.f_cmd.value = MODIFY01;

				 				if(!validateForm(sheetObj,formObj,sAction)) return;
				 				
				 				var sParam = "&"+ FormQueryString(formObj);
								var sXml = sheetObj.GetSaveXml("ESM_BKG_0984GS.do" , sParam);
								 if ( ComGetEtcData(sXml, "success_yn") =="Y"){
								 		ComShowCodeMessage('COM130102','Data');
 										self.close();
								 }else{
								 	ComShowCodeMessage('COM130103','Data');
								 }
			 				break;									
									
			    }
     }
     
     
     
     

     /*
      * After paging processing, a variables for processing as the number of inquiry
      * Initial value is a number of sheet header
      */ 
      var pagedMaxCnt=2;
	   
     /**
       * After retrieve, handling event.
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     }
   

     /**
      * Handling validity verification process about screen form input value.
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case MODIFY01:
    			if ( ComIsNull(formObj.src_cd) ||  ComIsNull(formObj.sr_no) ||  ComIsNull(formObj.bkg_no) || ComIsNull(formObj.sr_knd_cd) ) {
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
      * Definition for sheet initial setting value, header
      * param : sheetObj ==> sheet object, 
      * sheetNo ==> If the serial number ID tag attached to the sheet are many,
      * adding 'Case' clause as a number of sheets, configures initial module.
      */	 
	 
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

            case "sheet1":
              with (sheetObj) {
                 // setting height
                 style.height = 330;
                 
                 //setting width
                 SheetWidth = mainTable.clientWidth;

                 //setting Host information[mandatory][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //Kind of all Merge [optional, Default msNone]
                 MergeSheet = msHeaderOnly;

                //Whether to allow a all Edit[optional, Default false] 
                 Editable = true;

								//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
								InitRowInfo(1, 1, 3, rowsPerPage);

								var HeadTitle1 = "SEQ";

                 
                var headCount = ComCountHeadTitle(HeadTitle1);

                //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // Setting various functions that can be handled in Header
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
								//data attributes [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
								InitDataProperty(0,		cnt++ , dtData,				30,		daCenter,	false,	prefix + "Seq",				false,		"",		dfNone,	0,		false,		false);
								CountPosition = 0;
								
 						}
 				
 					break;
         
         }
     }