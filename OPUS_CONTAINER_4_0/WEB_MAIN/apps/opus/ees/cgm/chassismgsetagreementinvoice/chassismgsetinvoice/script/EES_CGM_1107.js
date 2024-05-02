/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  EES_CGM_1107.js
*@FileTitle  : Chassis Estimate Expense
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_CGM_1107 : EES_CGM_1107 business script for
     */
    function EES_CGM_1107() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.setComboObject=setComboObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.validateForm=validateForm;
    	this.obj_change=obj_change;
    	this.obj_keypress=obj_keypress;
    	this.validateForm=validateForm;    	
    	this.sheet1_OnSort=sheet1_OnSort;
    	this.sheet1_OnDblClick=sheet1_OnDblClick;   
    }
   	/* developer job	*/
    //common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;    
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    function firstDayInPreviousMonth(yourDate) {
        var d=new Date(yourDate);
        d.setDate(1);
        d.setMonth(d.getMonth() - 1);
        return d;
    }
    function initControl() {
    	var formObj=document.form;
    	axon_event.addListenerForm('click','obj_click',formObj);         
    	axon_event.addListenerFormat('change','obj_change',formObj);      
//    	axon_event.addListenerFormat('keypress','obj_keypress',formObj); 
    	axon_event.addListenerFormat('blur','obj_blur',formObj);        
//    	axon_event.addListenerFormat('focus','obj_focus',formObj);      
//    	axon_event.addListener('keyup', 'enterFire', 'period_eddt');
    	axon_event.addListener('click', 'doc_type_change', 'doc_type');
    	//axon_event.addListener('change', 'div_change', 'div');			
    	var d=firstDayInPreviousMonth(new Date());
    	var y=d.getYear(); 
    	var m="";
    	var mtmp=d.getMonth()+1;
		if(mtmp<10)	m='0'+mtmp; 
		else m=''+ mtmp;
    	formObj.period_eddt.value=y+m;
    	formObj.doc_type[0].checked=true;
    	doc_type_change();
		ComBtnDisable("btn_save");
		div.SetSelectText("");
		formObj.rev_month.value="";
		div_change();
    }
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** use additional sheet var in case of more than 2 tap each sheet *****/
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcObj=window.event.srcElement;
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    		case "btn_calendar":
    			if ( srcObj.style.filter == "" ) {
    				var cal=new ComCalendar();
    				cal.setDisplayType('month');
    				cal.select(formObject.period_eddt, "yyyy-MM");
    				break;		
    			}
    			break;
    		case "btn_calendarRevMonth":
    			if ( srcObj.style.filter == "" ) {
    				var cal=new ComCalendar();
    				cal.setDisplayType('month');
    				cal.select(formObject.rev_month, "yyyy-MM");
    				break;		
    			}
    			break;    			
    		case "btn_Retrieve":
    			if ( srcObj.style.filter == "" ) {
    				sheetObjects[0].RemoveAll();
    				ComBtnDisable("btn_save");
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    					
    			}
    			break;
    		case "btn_DownExcel":
            	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                break;
    		case "btn_New":
    			initControl();
    			break;
    		case "btn_Calculation":
    			if ( srcObj.style.filter == "" ) {
    				sheetObjects[0].RemoveAll();
    				div.SetSelectIndex(-1,false);
    				document.form.rev_month.value="";
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);    				
    			}	
    			break;
    		case "btn_save":
    			if(ComIsBtnEnable("btn_save")){				
    				doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
    			}
    			break;	
			case "btn1_Report":
				Report();
				break;    			
    		} // end switch
    		tRoleApply();
        }catch(e) {
            if( e == "[object Error]") {
             ComShowMessage(OBJECT_ERROR);
            } else {
             ComShowMessage(e.message);
            }
        }
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
    * adding first-served functions after loading screen.
    */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		//
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		//
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    }
   /**
    * sheet setting and init in case of load finish <br>
    * @param  
    * @return 
    * @author 
    * @version 
    */     
	 function sheet1_OnLoadFinish(sheetObj) {
        sheetObj.SetWaitImageVisible(0);
        // Multi Combo reset
	 	comboObjects[comboCnt++]=div;
	  	for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k]);
	    }  
	  	//Group MultiCombo value reset
	  	var arrGroup=new Array();
	  	arrGroup[0]="LT|LT";
	  	arrGroup[1]="ST|ST";
	  	arrGroup[2]="CP|CP";
	  	arrGroup[3]="NP|NP";
	  	makeComboObject(div, arrGroup, 1, 0, 0);
        initControl();
    	ComBtnDisable("btn_save");
        doActionIBSheet(sheetObj,document.form,IBCLEAR);
        tRoleApply();
//        document.form.period_eddt.focus();
        //document.form.div.focus()
        sheetObj.SetWaitImageVisible(1);
    }    
    /** 
     * Combo Object reset  <br>
     * @param  {object} comboObj	Combo Object
     * @return 
     * @author 
     * @version
     */ 
    function initCombo(comboObj) {
    	switch(comboObj.options.id) {
    	/*
       	case "div":
    	 		var cnt=0;
     	        with(comboObj) {
     	        	Code="";
     	            Text="";
     	            SetDropHeight(100);
     	            SetMultiSelect(0);
     	            SetMaxSelect(1);
     	            SetEnable(1);
     	        }
     	        break;
     	*/
		case "div":
			var cnt=0;
			with(comboObj) {
				Code="";
				Text="";
				SetDropHeight(100);
				SetMultiSelect(1);
				SetMaxSelect(100);
				SetEnable(1);
				SetMaxLength(20);
			}     	  
			break;
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
	    	case "sheet1":      //sheet1 init  DETAIL
	    	with (sheetObj) {
	            var HeadTitle1="|SEQ|Execute Month|SYS Name|Cost Month|ACCT Code|AGMT NO|AGMT LSTM CD|CHSS POOL CD|INVO NO|COST VVD|||||REV VVD|Estimated Cost|Actual Cost|Accrual AMT|Charge Creation User|Charge Creation Date|Calculation Update User|Calculation Update Date";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                   {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exe_yrmon",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sys_src_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_pool_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"invo_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cost_vvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rev_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rev_vvd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"estm_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"act_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"accl_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            InitColumns(cols);
	            SetSheetHeight(402);
	            SetEditable(0);
	            SetEditableColorDiff(0);
	    	}
	    	sheet1_OnLoadFinish(sheetObj)
	    	break;
	    	case "sheet2":      //sheet1 init	SUMMARY
	    	with (sheetObj) {
	            var HeadTitle1="|SEQ|Execute Month|SYS Name|Cost Month|ACCT Code|COST VVD|||||Estimated Cost|Actual Cost|Accrual AMT|Charge Creation User|Charge Creation Date|Calculation Update User|Calculation Update Date";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                   {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exe_yrmon",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sys_src_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cost_vvd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rev_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"estm_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"act_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"accl_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	             
	            InitColumns(cols);
	            SetSheetHeight(402);
	            SetEditable(0);
	            SetEditableColorDiff(0);
	    	}
	    	break;	    	
    	}
    }
    //handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	var sheetObject1=sheetObjects[1];	//Summary
    	var sheetObject2=sheetObjects[0];	//Detail
    	switch(sAction) {
	    	case IBSEARCH:      //retrieve
	      		if(formObj.doc_type[0].checked==true) //DETAIL	  
	      		{
			    	if(validateForm(sheetObject2,formObj,sAction)){
		    			formObj.f_cmd.value=SEARCH;			
				 		sheetObj.SetWaitImageVisible(0);
				 		ComOpenWait(true);		    			
				 		sheetObject2.DoSearch("EES_CGM_1107GS.do",FormQueryString(formObj) );
				 		ComOpenWait(false);
			    	}	      			
	      		}else{  //SUMMARY	
	      			if(validateForm(sheetObject1,formObj,sAction)){
		    			formObj.f_cmd.value=SEARCH02;			
				 		sheetObj.SetWaitImageVisible(0);
				 		ComOpenWait(true);		    			
				 		sheetObject1.DoSearch("EES_CGM_1107GS.do",FormQueryString(formObj) );
				 		ComOpenWait(false);
	      			}
	      		}
		    	break;
	    	case IBSEARCH_ASYNC01:	
	      		if(formObj.doc_type[0].checked==true) //DETAIL	
	      		{
			    	if ( validateForm(sheetObject2, formObj, IBSEARCH) ) {    		
			    		formObj.f_cmd.value=SEARCH01;			
				 		sheetObj.SetWaitImageVisible(0);
				 		ComOpenWait(true);
				 		sheetObject2.DoSearch("EES_CGM_1107GS.do",FormQueryString(formObj) );
				 		ComOpenWait(false);
			    		if(sheetObject2.RowCount()> 0){
			    		    ComBtnEnable("btn_save");
			    		}
			    	}	      			
	      		}else{  //SUMMARY	    	
	      		}
		    	break;	
	    	case IBSAVE:        //saving
	      		if(formObj.doc_type[0].checked==true) //DETAIL
	      		{
			    	if(validateForm(sheetObject2,formObj,sAction)) {
		    			formObj.f_cmd.value=MULTI;			    		
		    			sheetObj.SetWaitImageVisible(0);
		    			ComOpenWait(true);
		    			var sParam=sheetObject2.GetSaveString(true);
		    			sParam += "&" + FormQueryString(formObj);
		    			var sXml=sheetObject2.GetSaveData("EES_CGM_1107GS.do", sParam);
		    			sheetObject2.LoadSaveData(sXml);
		    			ComOpenWait(false);	
			    	}	      			
	      		}else{ 	 //SUMMARY	    	
	      		}
		    	break;    	
	    	case IBDOWNEXCEL:        //down excel
	    		if(sheetObj.RowCount() < 1){//no data
         			ComShowCodeMessage("COM132501");
         		}else{
		      		if(formObj.doc_type[0].checked==true) //DETAIL
		      		{
		      			sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
		      		}else{ //SUMMARY	 
		      			sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
		      		}
         		}
				break;    	
    	}
    }
    /**
    * handling process for input validation
    */
    function validateForm(sheetObj,formObj,sAction){
    	with(sheetObj){
    		with(formObj){
    			switch(sAction) {
	    			case IBSEARCH:      //saving					      
		    			if ( formObj.period_eddt.value == "" ) {
		    				ComShowCodeMessage("CGM10004", "Period");
		    				ComSetFocus(formObj.period_eddt);
		    				return false;
		    			}
		    			if( formObj.period_eddt.value.length == 6 || formObj.period_eddt.value.length == 7) {
		    				//"200912" or "2009-12"
		    			}else
		    			{
		    				return false;
		    			}
	    			break;
    			}
    		}
    	}
    	return true;
    }		
    /**
    * Validation check in case of HTML Control focus out .
    */
    function obj_blur(){
    	var obj=event.srcElement;
    	switch(ComGetEvent("name")){
    	case "period_eddt":
    	case "rev_month":
    		ComChkObjValid(obj);
    		break;      
    	default:
    	break;
    	}
    }
    /**
    * format handling in case of HTML Control keboard event
    */
    function obj_keypress() {
    	var obj=event.srcElement;
    	switch(obj.dataformat) {
    	case "ymd":
    	case "ym":
    	case "hms":
    	case "hm":
    	case "jumin":
    	case "saupja":
    	case "int":
    		ComKeyOnlyNumber(obj);
    		break;
    	case "float":
    		ComKeyOnlyNumber(obj, "-.");
    		break;
    	case "eng":
    		ComKeyOnlyAlphabet();
    		break;
    	case "engup":     	
    		ComKeyOnlyAlphabet('upper'); 	        	
    		break; 
    	case "engdn":
    		ComKeyOnlyAlphabet('lower');
    		break;           
    	default:
    		ComKeyOnlyNumber(obj);
    	break;
    	}        
    } 	
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if ( ErrMsg == "" ) {
    		if(document.form.f_cmd.value == MULTI){
    			ComOpenWait(false);	
    			ComShowCodeMessage("CGM00003");
    		}
    	} else {
    		ComShowMessage(ErrMsg);
    	}
    }
    function obj_focus(){
    	var obj=event.srcElement;
    	if( obj.readOnly ) {
    		ComSetNextFocus(obj);
    	} else {
    		ComClearSeparator(event.srcElement);
    	}
    } 	
    /**
    * HTML Control Value change handling
    */
    function obj_change(){	 
    	var obj=event.srcElement;
    	var formObj=document.form;
    	//if ( ComTrim(ComGetObjValue(obj)) != "" ) {
    	switch(ComGetEvent("name")) {
    		case "period_eddt":		//Location Code
				break; 	
    	}
    //}
    }	
     function enterFire() {
  	   var formObj=document.form;
  	   var sheetObj=sheetObjects[0];
  	   if(event.keyCode == 13)
  	   {
  		   if(validateForm(sheetObj,formObj,IBSEARCH))
  		   {
  			   ComKeyEnter('search');
  		   }
  	   }
     }   
     /**
      * Sheet1  OnSearchEnd event handling <br>
      * @param  {object} sheetObj		 Sheet Object
      * @param  {string} ErrMsg		 String
      * @return 
      * @author 
      * @version
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
     	with(sheetObj)
     	{
     		for(var i=1; i<= RowCount(); i++)
     		{
     			SetCellValue(i,'cost_vvd',GetCellValue(i,'vsl_cd') + GetCellValue(i,'skd_voy_no') + GetCellValue(i,'skd_dir_cd') + GetCellValue(i, 'rev_dir_cd'));
     		}
     	}
     }     
	/**
	 * Sheet1  OnSearchEnd event handling <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {string} ErrMsg		 String
	 * @return 
	 * @author 
	 * @version
	 */ 
	function sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{
	    with(sheetObj)
	  	{
	  		for(var i=1; i<= RowCount(); i++)
	  		{
	  			SetCellValue(i,'cost_vvd',GetCellValue(i,'vsl_cd') + GetCellValue(i,'skd_voy_no') + GetCellValue(i,'skd_dir_cd') + GetCellValue(i, 'rev_dir_cd'));
	  		}
	  	}
	}
	function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
	 	cmbObj.RemoveAll();
	 	if(opt == 0) {
	 		for (var i=0; i < arrStr.length;i++ ) {
	 			var arrCode=arrStr[i].split("|");
	     		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
	         }
	 	} else if(opt == 1){
	 		cmbObj.InsertItem(0,"","");
	 		for (var i=0; i < arrStr.length;i++ ) {
	 			var arrCode=arrStr[i].split("|");
	     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
	         }
	 	}
	 	cmbObj.SetSelectIndex("" ,false);
	}   
    /** 
     * Summary/Detail Change <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */ 
    function doc_type_change() {
        var formObj=document.form;
    	document.getElementById('summaryLayer').style.display="none";
      	document.getElementById('detailLayer').style.display="none";
      	//Summary
      	if(formObj.doc_type[0].checked==true) //Detail
      	{
     		document.getElementById('detailLayer').style.display="";
      		//sheet reset
       		sheetObjects[0].RemoveAll();
       		sheetObjects[1].RemoveAll();
       		ComBtnEnable("btn_Calculation");
       		/*
       		formObj.div.SetEnable(0);
       		//REV MONTH DISABLE
       		formObj.rev_month.disabled=true;
       		var styleCursor="";
   			var styleFilter="progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";
    		var obj=document.getElementsByTagName("img");
    		for ( var i=0; i < obj.length; i++) {
    			if (obj[i].getAttribute("name") == "btn_calendarRevMonth" ) {
    				obj[i].className=styleCursor;
    				obj[i].disabled=true;
    				obj[i].style.filter=styleFilter;
    			}
    		} 
    		*/
      	}else 
      	{
      		document.getElementById('summaryLayer').style.display="";
      		//sheet reset
      		sheetObjects[0].RemoveAll();
      		sheetObjects[1].RemoveAll();
      		ComBtnDisable("btn_Calculation");
      		/*
      		formObj.div.SetEnable(1);
      		//REV MONTH ENABLE
      		formObj.rev_month.disabled=false;
   			var styleCursor="cursor"
			var styleFilter="";
    		var obj=document.getElementsByTagName("img");
    		for ( var i=0; i < obj.length; i++) {
    			if (obj[i].getAttribute("name") == "btn_calendarRevMonth" ) {
    				obj[i].className=styleCursor;
    				obj[i].disabled=false;
    				obj[i].style.filter=styleFilter;
    			}
    		}      	
    		*/	       		
        }
      	ComBtnDisable("btn_save");
    }         
	/**
	 * popup 
	 * @return
	 */
    function Report(){
   	  	var formObj=document.form;
    	var chss_pool_tp_cd="";
    	var year=document.form.period_eddt.value;
    	if(formObj.period_eddt.value == ''){
    		ComShowCodeMessage('CGM10004','Year');
//      		 formObj.period_eddt.focus();
      		 return false; 
		} else {
			chss_pool_tp_cd=div.GetSelectText();
			var param="?pgmNo=EES_CGM_1126";
   		   	param=param + "&f_cmd=" + SEARCH; 
   			param=param + "&chss_pool_tp_cd=" + chss_pool_tp_cd;           	
   		   	param=param + "&year=" + year;//.substring(0,4);
   		    ComOpenPopup('/opuscntr/EES_CGM_1126.do' + param, 800, 450, "", "1,0", true, false);
		}
     }     
 /** 
  * div change event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version 
  */
  function div_change(){
	  var formObj=document.form;
	  if(div.GetSelectText()!= "")
	  {
		  ComBtnEnable("btn1_Report");
	  }
	  else
	  {
		  ComBtnDisable("btn1_Report");
	  }
  }	 
  /**
   * function(ex:btn_save) role(trole) apply  <br>
   * @param  
   * @return 
   * @author 
   * @version
   */     
   function tRoleApply() {
// 	  var formObj=document.form;
// 	  if(formObj.trole.value == "Authenticated")
// 	  {
// 	  }else
// 	  {
// 		  ComBtnDisable("btn_save");
// 	  }
   } 
   /**
    * Location Multi-Combo OnChange event handling <br>
    * @param  {object} ComboObj	mandatory	 Sheet Object
    * @param  {int} 	Index_Code	mandatory
    * @param  {string} Text		mandatory
    * @return 
    * @version
    */ 
   function div_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	   div_change();
   }
	/* developer job end */