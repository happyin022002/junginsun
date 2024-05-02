/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1115.js
*@FileTitle  : Europe Advanced Manifest-Error Code Table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/18
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_1115 : business script for ESM_BKG_1115
     */
    function ESM_BKG_1115() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.sheet1_OnKeyUp=sheet1_OnKeyUp;
    }
	/* developer job	*/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var intervalId="";
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
	 * register combo Object to comboObjects array
	 * 
	 * @param combo_obj
	 * @return
	 */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++]=combo_obj; 
    }
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */             
    function loadPage() {
    	var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}
     function initControl() {
     	var formObject=document.form;
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- focus out
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- focus in
        axon_event.addListenerForm  ('change', 'bkg_change', formObject);
        axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate',  formObject); //-focus out
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- focus in
        axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- input key
        axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');
     }
 	/**
 	 * Combo basic setting
 	 */
   	function initCombo(comboObj, comboId) {
   	    var formObject=document.form
  			initComboEditable(comboObj, comboId)
   	}
	/**
	 * Combo basic setting
	 */
 	function initComboEditable(combo, comboId) {
 		with (combo) {
	 		if(comboId == "p_pofe" ){
	 			SetMultiSelect(0);
	 			SetUseEdit(0);
	 			//BackColor = "#CCFFFD";
	 		}
 		}
 	} 
/*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //Upper Case
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //num+"Upper Case"
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //num
	        ComKeyOnlyNumber(event.srcElement);
	        break;
	      case "custname":
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	      break;	            
	      default:
	      break;
	    }
	}  
	var preVvd;
	var prePodCd;
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_blur() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "p_vvd_cd":
				break;
	    	case "p_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "p_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
				default:
					break;
	    }
    }           
	function bkg_focus(){
	}       
    function bkg_change(){
    }
	// Event handler processing by button click event
 	document.onclick=processButtonClick;
	// Event handler processing by button name
     function processButtonClick(){
 	         var sheetObject1=sheetObjects[0];
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
            switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_Close":
 					ComClosePopup(); 
 					break;
 				default:
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
     // handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH : // retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return;
				//formObj.p_pofe.value = formObj.p_pofe_temp.text;
				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;
				sheetObj.RemoveAll();
 				var sXml=sheetObj.GetSearchData("ESM_BKG_1115GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.RenderSheet(1);
				sheetObj.SetWaitImageVisible(0);
				break;
			default:
				break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
	    	case IBSEARCH:
    			if (ComIsNull(formObj.cnt_cd)) {
    				ComShowCodeMessage('BKG00104','Country');
// 					formObj.p_bl_no.focus();
 					return false;    
    			}
				break;
	    }
        return true;
    }
    function obj_KeyUp() {
    }
    function obj_change() {
    }
    /**
     * handling retrieve event
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        with (sheetObj) {
        	SelectCell(FindText('error_code',form.p_error_code.value),"cnt_cd");
        	form.err_code.value=form.p_error_code.value;
        	form.err_desc.value=GetCellValue(FindText('error_code',form.p_error_code.value),"error_description");
        }
    }	
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
		     
		      var HeadTitle1="|Seq.|COUNTRY|ERROR\nCODE|ERROR DESCRIPTION|REMARK";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:4, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",             Wrap:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"error_code",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"error_description",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"remark",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
		       
		      InitColumns(cols);

		      SetEditable(0);
		      SetCountPosition(0);
		      SetShowButtonImage(0);
		      SetSheetHeight(250);
		      }

				break;
		}//end switch
 	}     
     /* end developers work */
