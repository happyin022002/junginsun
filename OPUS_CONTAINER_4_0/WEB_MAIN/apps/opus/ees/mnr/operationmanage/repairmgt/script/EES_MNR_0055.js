/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0055.js
 *@FileTitle : Reefer Spare Part Summary List
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
	/****************************************************************************************
				  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
									MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
									COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_mnr_0055 : ees_mnr_0055 - Defining a script used by screen
	 */
	/* Developer's task	*/
	//Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
// Defining event handler of button click */
document.onclick=processButtonClick;
// Event handler to diverge process by button name */
    function processButtonClick(){
         /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_DownExcel":
					if(sheetObjects[0].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObjects[0].Down2Excel();
					}
					break;
				case "btn_cost_ofc_cd":
					ComOpenPopup("COM_ENS_071.do", 720, 450, 'setPopUpParam_COM_ENS_071', '0,0', true);
					break;
				case "btn_calendar":
					var cal=new ComCalendarFromTo();
				    cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
				    break;
				case "btn_vessel":
					ComOpenPopup("COM_ENS_0A1.do", 620, 550, 'setPopUpParam_COM_ENS_0A1', '0,0', true);
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
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
	    MnrWaitControl(true);
	    initControl();
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			ComEndConfigSheet(sheetObjects[i]);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
	              var HeadTitle1="|Seq.|Office|Type|VVD|W/O Issue\n Date|Unit Type|Part No.|Part Name|Q'ty|Curr.|Unit Cost|Amount|W/O No.";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="sheet1_";
	
	              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:3, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ord_iss_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_prt_spl_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_ut_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_prt_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"spr_prt_uc_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"total_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(0);
//	              SetImageList(0,"img/btns_detail.gif");
                    SetShowButtonImage(2);
//                    SetSheetHeight(430);
                    resizeSheet( sheetObj );
              }


				break;
        }
    }
 	function initControl() {
 		//Axon event handling 1. Catching event
 		var formObject=document.form;
// 		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);
// 		axon_event.addListenerFormat('focus',    'obj_activate',    formObject);
 		//axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);
 		axon_event.addListenerFormat('change',	 'obj_change',	formObject);
 	}
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
 	//Axon event handling 2. Event handling function
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
 			case "empty":
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
 			case "empty":
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
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		MnrWaitControl(false);
		nowLoad=0;
	}
     //Sheet processing-related processes
       function doActionIBSheet(sheetObj,formObj,sAction) {
           sheetObj.ShowDebugMsg(false);
           switch(sAction) {
   			case IBCLEAR:  //NEW
   				MnrWaitControl(true);
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboDefault="";
				var sCondition=new Array (
					new Array("MnrGenCd","CD00037", "COMMON")
				)
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				if(comboList[0] != null){
			 		for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						if(j ==0){
							sheetComboDefault=tempText[0];
						}
					}
				}
				sheetComboText=MnrDelLastDelim(sheetComboText);
				sheetComboCode=MnrDelLastDelim(sheetComboCode);
				sheetObjects[0].InitDataCombo (0, "sheet1_spr_prt_spl_tp_cd", sheetComboText, sheetComboCode,sheetComboDefault);
   				formObj.cost_ofc_cd.value=currOfcCd;
				formObj.tocal.value=ComGetNowInfo();
				formObj.fromcal.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -90);
   				formObj.vsl_cd.value="";
   				sheetObjects[0].RemoveAll();
   				MnrWaitControl(false);
   				break;
   			case IBSEARCH:      //Retrieving
	   			if(!validateForm(sheetObj,formObj,sAction))return;
	   			MnrWaitControl(true);
	   			nowLoad=1;
	   			sheetObjects[0].RemoveAll();
	   			formObj.f_cmd.value=SEARCH;
	   			var sParam="";
	   			var aryPrefix=new Array("sheet1_");
	   			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
	   			var sXml=sheetObj.GetSearchData("EES_MNR_0055GS.do", sParam);
	   			arrDataSearchDbXml=sXml.split("|$$|");
	   			for ( var i=0; i < arrDataSearchDbXml.length; i++) {
	   				///sheetObjects[i].RenderSheet(0);
	   				sheetObjects[i].SetWaitImageVisible(0);
	   				sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
	   				///sheetObjects[i].RenderSheet(1);
	   			}
	            break;
           }
       }
   /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
 		with(formObj){
 			//At retrieving
 			if(sAction==IBSEARCH)
 			{
 				if(formObj.cost_ofc_cd.value == ""){
 					ComShowCodeMessage("MNR00172","C. Office");
 					ComSetFocus(formObj.cost_ofc_cd);
 					return false;
 				}
 				if(Number(formObj.fromcal.value.length) < 10){
 					ComShowCodeMessage("MNR00036","W/O Issue Date");
 					ComSetFocus(formObj.fromcal);
 					return false;
 				}
 				if(Number(formObj.tocal.value.length) < 10){
 					ComShowCodeMessage("MNR00036","W/O Issue Date");
 					ComSetFocus(formObj.tocal);
 					return false;
 				}
 			}
 			return true;
 		}
    }
    function setPopUpParam_COM_ENS_071(array) {
    	if(array == null)return;
    	var formObj=document.form;
    	var str=array + "";
    	var arr=str.split(',');
    	formObj.cost_ofc_cd.value=arr[3];
    }
