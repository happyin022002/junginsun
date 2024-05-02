/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_MNR_0204.js
*@FileTitle : Tire Replacement Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_MNR_0204 : business script for EES_MNR_0204 .
     */
   	/* developer job	*/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    		case "btn_retrieve":
    			doActionIBSheet(sheetObject1,document.form,IBSEARCH);
    			break;
    		case "btn_new":
    			doActionIBSheet(sheetObject1,formObject,IBCLEAR);
    			break;
    		case "btn_downexcel":
    			doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    			break;
    		case "btn_ofc_cd":
    			ComOpenPopup("COM_ENS_071.do", 720, 470, 'setPopUpParam_COM_ENS_071', '1,0,1,1,1,1,1,1', true);
    			break;				
    		case "cre_dt_cal":
    			var cal=new ComCalendarFromTo();
    			cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
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
		initControl();
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}                 
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}
	function initControl() {       
		var formObject=document.form;       
		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
//		axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
//		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject);
	}             
	//handling Axon event
	function obj_deactivate(){      
		ComChkObjValid(ComGetEvent()); 
	} 
	function obj_activate(){   
		ComClearSeparator(ComGetEvent());
	}        
	function obj_change(){	     
		var obj=ComGetEvent(); 
		var formObj=document.form; 
		var sheetObj=sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {      
			case "ofc_cd":   
				doCheckOffice();
				break;   
			}       
		} 
	}    
	function obj_keypress(){   
		obj=ComGetEvent();    
		keys=event.keyCode;
		if(obj.dataformat == null) return; 
		window.defaultStatus=obj.dataformat;
		var formObj=document.form; 
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {      
			case "none":   
				break;   
			}       
		}				 			              
		switch(obj.dataformat) {   
		case "ymd":   
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
			ComKeyOnlyAlphabet('uppernum');           
			break; 
		}         
	}     
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj ==> sheetObject, sheetNo ==> sheetObject tag serial number
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      // sheet1 init
			    with(sheetObj){
						
					  var HeadTitle="|Seq.|RHQ|Office|Supplier|Purchase Q'ty|Used Q'ty|Differ Qty|Tire Purchase Amount";

					  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

					  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					  var headers = [ { Text:HeadTitle, Align:"Center"} ];
					  InitHeaders(headers, info);

					  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rhq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"vndr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:0,   SaveName:"p_qty",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:0,   SaveName:"u_qty",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:0,   SaveName:"df_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"p_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
					   
								InitColumns(cols);

								SetEditable(0);
//								SetSheetHeight(380);
								resizeSheet( sheetObj );
							}


			break;
		}
	}
	// handling Sheet reference
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBSEARCH:      //retrieving
			if(validateForm(sheetObj,formObj,sAction))
				if ( sheetObj.id == "sheet1"){
					formObj.f_cmd.value=SEARCH;     						
					sheetObj.DoSearch("EES_MNR_0204GS.do",FormQueryString(formObj) );
				}
			break;
		case IBCLEAR:        //initialzing
			MnrWaitControl(true);
			sheetObj.SetWaitImageVisible(0);
			// initializing Sheet
			for(i=0;i<sheetObjects.length;i++){   
				sheetObjects[i].RemoveAll();
			}  			    
			formObj.ofc_cd.value="";
			formObj.from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
			MnrSetFromDate(formObj.from_dt);
			formObj.to_dt.value=ComGetNowInfo();
			sheetObj.SetWaitImageVisible(1);
			MnrWaitControl(false);   			    
			break;
		case IBDOWNEXCEL:
			if(sheetObj.RowCount() < 1){//no data
				  ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(			sheetObj), SheetDesign:1,Merge:1 });
				}
			
			break;			    
		}
	}
	function doCheckOffice(){
		var checkOffice=document.form.ofc_cd.value;               
		retArray=MnrGeneralCodeCheck(sheetObjects[0],"OFC",checkOffice);      
		if(retArray == null){           
			ComShowCodeMessage("MNR00165",checkOffice,"OFFICE");       	
			document.form.ofc_cd.focus();
			document.form.ofc_cd.value="";                  
		}		
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(sAction==IBSEARCH) {	  	    
				if(!MnrChkFromDate(formObj.from_dt)) return false;
			}
		}
		return true;
	}
	function setPopUpParam_COM_ENS_071(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";	
		var arr=str.split(',');
		formObj.ofc_cd.value=arr[3];
	}   
