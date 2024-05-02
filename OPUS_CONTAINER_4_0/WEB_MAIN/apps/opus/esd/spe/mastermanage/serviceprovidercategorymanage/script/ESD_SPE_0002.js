/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SPE_002.js
*@FileTitle  : S/P Category 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_SPE_002 : business script for ESD_SPE_002
     */
    function ESD_SPE_002() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
 // The common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    	/****************************************************************************************
    	  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
    						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
    	 ***************************************************************************************/
    	/* Event handler processing by button name */
        function processButtonClick(){
             var sheetObject=sheetObjects[0];
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
            	    case "btn_retrieve":
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
            	    case "btn_apply":
            	        break;
            	    case "btng_delete":
            	        break;
    				case "btn_save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;
    				case "btn_sp":
    					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 420, 'getVendor', '1,0,1,1,1,1,1,1');
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
      	function initControl() {
      		var formObj=document.form;
    		axon_event.addListenerFormat('keydown',	'obj_keydown',	form); 
    		axon_event.addListener('keydown',	'ComKeyEnter',	    'form');
    		axon_event.addListenerFormat('keyup',	'obj_keyup',	form);
    		axon_event.addListenerFormat('keypress','obj_keypress',	form);
      	}       
        /**
         * Registering IBSheet Object as list
         * Adding process for list in case of needing batch processing with other items
         * Defining list on the top of source
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
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            initControl(); 
        }
       /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets 
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with(sheetObj){
		                  var HeadTitle=" ||S/P CODE|S/P Name|Regional\nH/Q|Control Office|Service Category|Service Category|Service Category|Service Category|Service Category|Service Category" ;
		                  var HeadTitle1=" ||S/P CODE|S/P Name|Regional\nH/Q|Control Office|Truck|Rail|ODCY|Terminal|Water|EQ M&R" ;
		
		                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                  var headers = [ { Text:HeadTitle, Align:"Center"},
		                              { Text:HeadTitle1, Align:"Center"} ];
		                  InitHeaders(headers, info);
		
		                  var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"delchk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Status",    Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",    ColMerge:1,   SaveName:"vndr_abbr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"reg_group",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                         {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_cate_trsp_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_cate_rail_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_cate_cy_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_cate_tml_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_cate_wtr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"svc_cate_eq_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                   
		                  InitColumns(cols);
		
		                  SetEditable(1);
		                  SetRangeBackColor(1, 4, 1, 11,"#555555");// ENIS
		                  SetSheetHeight(260 );
                	}
                break;
            }
        }
      // Handling the process about the sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
               	case IBSEARCH:      //Retrieving
                    if(validateForm(sheetObj,formObj,sAction)){
                    	if(!ComChkRequired(formObj)) return;
    	               	formObj.f_cmd.value=SEARCH;
    	               	var param=speFormString(formObj,'f_cmd,vndr_seq,vndr_abbr_nm,eg_rhq_cd,eg_cty_cd,mapped');
    	               	sheetObj.DoSearch("ESD_SPE_0002GS.do", param );
                    }
                    break;
    			case IBSAVE:		//Saving
    				formObj.f_cmd.value=MULTI;
    			 	var param=speFormString(formObj,'f_cmd');
    				sheetObj.DoSave("ESD_SPE_0002GS.do", param);
    				break;  
    			case IBSEARCHAPPEND:		//Retrieving VNDR name
    			 formObj.f_cmd.value=SEARCH01;
    			 var param=speFormString(formObj,'f_cmd,vndr_seq,vndr_abbr_nm');
    			 var sXml=sheetObj.GetSearchData("ESD_SPE_0002GS.do", param);
	       		 formObj.vndr_seq.value=ComXmlString(sXml, "vndr_seq");
	       		 formObj.vndr_abbr_nm.value=ComXmlString(sXml, "vndr_abbr_nm");
	       		 formObj.eg_rhq_cd.value="";
	       		var sen_nm=eval(document.form.eg_cty_cd);
	            while (0 < sen_nm.options.length){
	                sen_nm.options[0]=null;
	            }	       		 
				break;  
            }
        }
       /**
         * Handling the process for the input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            	switch(sAction) {
            		case IBSEARCH: 
            			if((formObj.vndr_seq.value == null || formObj.vndr_seq.value == "")
            				&& (formObj.eg_rhq_cd.value == null || formObj.eg_rhq_cd.value == "")
            				&& (formObj.eg_cty_cd.value == null || formObj.eg_cty_cd.value == "")){
            				ComShowCodeMessage('COM12113','The conditions of retrieval');
            				return false;
            			}
            		break;
            	}
            }
            return true;
        }
    	function fnChkForm(theForm) {
    		return true;
    	}
    	/**
    	 * calling this function in case of closing the popup
    	 *
    	 */
    	function getVendor(rArray){
    		var cArray=rArray[0];
    		document.all.vndr_seq.value=cArray[2];
    		document.all.vndr_abbr_nm.value=cArray[4];
    	}
    	 	/**
    	 	 * Handling the keydown event
    	 	 */
    		function obj_keydown() {
    			var obj=event.srcElement;
    			var vKeyCode=event.keyCode;
    			var formObj=document.form;
    			if (obj.name == "vndr_seq") {
    		  		if ( vKeyCode == 9 || vKeyCode == 13) {
    		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCHAPPEND);
    		  		}
    			} 
    		}
    	  	function obj_keyup() {
    	 		var obj=event.srcElement;
    	 		var vKeyCode=event.keyCode;
    	 		var formObj=document.form;
    	 		switch(ComGetEvent("name")) {
    	 			case "vndr_seq": 
    			  		if (formObj.vndr_seq.value.length == 6) {
    			  			if (vKeyCode != 8 && vKeyCode != 46 && vKeyCode != 32 && 
    			  				vKeyCode != 37 && vKeyCode != 38 && vKeyCode != 39 && vKeyCode != 40 && vKeyCode != 229){
    			  			   doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
    			  			}
    			  		}
    			  		break;
    	 		}
    	 	}  	 
    	 	function obj_keypress(){
    		    obj=event.srcElement;
    		    if(obj.dataformat == null) return;
    		    window.defaultStatus=obj.dataformat;
    		    switch(obj.dataformat) {
    		        case "engup":
    		            if(obj.name=="vndr_seq") ComKeyOnlyAlphabet('uppernum');
    		            break;
    		    }        
    		}
