/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0057.js
*@FileTitle  :  D/Dock Schedule Review
*@author     : CLT
*@version    : 1.0
*@since      :  2014/06/18
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_fms_0057 : esm_fms_0057 definition of biz script for creation screen
     */
//    function esm_fms_0057() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    //no support[check again]CLT 	this.sheet1_OnLoadFinish=sheet1_OnLoadFinish;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    	this.setFormYardName=setFormYardName;
//    }
	//  common global variables 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var queryStr="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name  */
    function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn_retrieve":
	             	if (!duration_change()) return;
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
				case "btn_new":
					ComResetAll();
					inputReadOnly("New");
                break;
				case "btn_DownExcel":
 					if(sheetObject.RowCount() < 1){//no data	
 						ComShowCodeMessage("COM132501");
 					}else{	
// 						sheetObject.Down2Excel({ HiddenColumn:0});
 						sheetObject.Down2Excel({ SheetDesign:1, HiddenColumn:1, Merge:1 });
 					}	
                break;
				case "btn_Print":
					if(validateForm(sheetObject,formObject)){
						//Generating required Parameter when clicking print button
						getPrintParam(formObject);
						rdOpen(formObject);
					}
                break;
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0022");
					break;
				case "btn_lanepop":
					ComOpenPopup("ESM_FMS_0036.do", 620, 430,"setLaneCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0036");
					break;
				case "btn_ownerpop":
					ComOpenPopup("ESM_FMS_0083.do", 500, 375,"setOwner", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0083");
					break;
				case "btn_yard":
     				ComOpenPopup("ESM_FMS_0082.do", 400, 340, "setFormYardName", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0082");
     				break;
     			case "btn_fr_duration":
     				var cal=new ComCalendar();
 					cal.setDisplayType('year');
					cal.select(form.fr_duration, 'yyyy');
					break;					
     			case "btn_to_duration":
     				var cal=new ComCalendar();
 					cal.setDisplayType('year');
					cal.select(form.to_duration, 'yyyy');
					break;
     			case "btn_ydClr":
     				form.shpYdNm.value="";
     				form.ydSeq.value="";
     				break;
     			case "btn_ownrclr":
     				form.ownr_nm.value="";
     				form.ownr_seq.value="";
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
     * Generating required Parameter when clicking print button <br>
     * @param {Form Object} formObject     	form name
     **/
    function getPrintParam(formObject) {
		formObject.flet_dck_svey_tp_nm.value=formObject.flet_dck_svey_tp_cd.options[formObject.flet_dck_svey_tp_cd.selectedIndex].text;
		formObject.reflection_nm.value=formObject.reflection_cd.options[formObject.reflection_cd.selectedIndex].text;
	}
    /**
     * Screen handling by Event <br>
     * @param {String} flag     	Event Separator
     **/
    function inputReadOnly(flag) {
    	var readOnly=true;
    	var cursor="default";
    	var img="no_";
    	if(flag == "New") {
    		readOnly=false;
    		cursor="hand";
    		img="";
    	}
    	form.vsl_cd.readOnly=readOnly;
    	form.lane_cd.readOnly=readOnly;
    	form.flet_ctrt_tp_cd.disabled=readOnly;
    	form.vsl_dznd_capa_fr.readOnly=readOnly;
    	form.vsl_dznd_capa_to.readOnly=readOnly;
    	form.flet_dck_svey_tp_cd.disabled=readOnly;
		form.fr_duration.readOnly=readOnly;
		form.to_duration.readOnly=readOnly;
    	form.reflection_cd.disabled=readOnly;
//    	document.images["btn_vslpop"].name=img+"btn_vslpop";
//    	document.images["btn_lanepop"].name=img+"btn_lanepop";
//    	document.images["btn_ownerpop"].name=img+"btn_ownerpop";
//    	document.images["btn_fr_duration"].name=img+"btn_fr_duration";
//    	document.images["btn_to_duration"].name=img+"btn_to_duration";
    	form.btn_vslpop.name=img+"btn_vslpop";
    	form.btn_lanepop.name=img+"btn_lanepop";
    	form.btn_ownerpop.name=img+"btn_ownerpop";
    	form.btn_fr_duration.name=img+"btn_fr_duration";
    	form.btn_to_duration.name=img+"btn_to_duration";
    	form.btn_vslpop.style.cursor=cursor;
    	form.btn_lanepop.style.cursor=cursor;
    	form.btn_ownerpop.style.cursor=cursor;
    	form.btn_fr_duration.style.cursor=cursor;
    	form.btn_to_duration.style.cursor=cursor;
    }
	/**
	 * Insering Vessel Code<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			
	}
    /**
	 * Inserting Lane Code<br>
	 * @param {arry} aryPopupData
	 */
	function setLaneCd(aryPopupData){
		form.lane_cd.value=aryPopupData[0][3];
	}
    /**
	 * Inserting Owner<br>
	 * @param {arry} aryPopupData
	 */
	function setOwner(aryPopupData){
		form.ownr_seq.value=aryPopupData[0][3];
		form.ownr_nm.value=aryPopupData[0][4];
        form.btn_ownrclr.checked=true;
	}
    /**
     * Only insert Numeric by onkeypress Event of HTML Control <br>
     **/
//    function obj_keypress(){
//    	switch(ComGetEvent().dataformat){
//			case "int":
//		        ComKeyOnlyNumber(ComGetEvent());
//				break;
//			case "float":
//		        ComKeyOnlyNumber(ComGetEvent(), ".");
//				break;
//			default:
//		        ComKeyOnlyNumber(ComGetEvent());
//    	}
//    }
    /**
     * Only insert English/Numeric by onkeypress Event of HTML Control <br>
     **/
//    function eng_keypress() {
//        ComKeyOnlyAlphabet('upper');
//    }
     /**
      * Only insert English/Numeric by onkeypress Event of HTML Control <br>
      **/
//     function engnum_keypress() {
//         ComKeyOnlyAlphabet('uppernum');
//     }
    /**
     * Getting Name when changing VslCd <br>
     **/
    function vsl_cd_change() {
    	form.vsl_eng_nm.value="";
    	if (form.vsl_cd.value != "" && form.vsl_cd.value.trim().length == 4) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vsl_cd');
    	}
    }
    /**
     * Checking Lane Code when LaneCd is changed <br>
     **/
    function lane_cd_change() {
    	if (form.lane_cd.value != "") {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'lane_cd');
    	}
    }
    /**
    * Registering IBSheet Object as Array
    * In case there is needs to do batch processing, process saving as Array can be added
    * defining array on the top of source
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();

		sheet1_OnLoadFinish(sheet1);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * Adding first-served function
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
        //Deleting TO of Contract Type
        removeContractTP();
		sheetObj.SetWaitImageVisible(1);
    }
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
        //Axon Event Handling1. Event catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- Code handling to OnBeforeDeactivate(blur) Event of All Controls
//        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- Code handling to onkeypress Event of All Controls having dateformat attribute
//        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd');			//- Input only Upper case English when inserting Veesel Code
        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');			//- Getting Name information after inserting Vessel Code
//        axon_event.addListener  ('keypress', 'eng_keypress' , 'lane_cd');			//- Only input Upper case English when inserting Lane Code
        axon_event.addListener  ('change'  , 'lane_cd_change', 'lane_cd');			//- Getting Name information after inserting Lane Code
        axon_event.addListener  ('change'  , 'vsl_size_change', 'vsl_dznd_capa_fr');	//- Comparing From-To after inserting Vessel Size
        axon_event.addListener  ('change'  , 'vsl_size_change', 'vsl_dznd_capa_to');	//- Comparing From-To after inserting Vessel Size
        axon_event.addListener  ('change'  , 'duration_change', 'fr_duration');			//- Comparing From-To after inserting Duration
        axon_event.addListener  ('change'  , 'duration_change', 'to_duration');			//- Comparing From-To after inserting Duration
        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
        //Deleting TO of Contract Type
        //removeContractTP();
    }
    /**
     * Checking Validation in onblur Event of HTML Control <br>
     **/
    function obj_deactivate(){
    	//if (ComGetEvent().getAttribute("required") != null) return;
    	switch(ComGetEvent("name")){
			case "fr_duration":
				ComChkObjValid(ComGetEvent(), true, false, false);
				break;
			case "to_duration":
				ComChkObjValid(ComGetEvent(), true, false, false);
				break;
			case "vsl_dznd_capa_fr":
				ComChkObjValid(ComGetEvent(), true, false, false);
				break;
			case "vsl_dznd_capa_to":
				ComChkObjValid(ComGetEvent(), true, false, false);
				break;
			default:
				//ComAddSeparator(ComGetEvent());
				ComChkObjValid(ComGetEvent());
    	}
    }
	/**
     * Comparing From-To after inserting Vessel Size
     **/
    function vsl_size_change() {
		var formObj=document.form;
		var vsl_dznd_capa_fr=formObj.vsl_dznd_capa_fr.value;
		var vsl_dznd_capa_to=formObj.vsl_dznd_capa_to.value;
		if (vsl_dznd_capa_fr != '' && vsl_dznd_capa_to != '') {
			if (parseFloat(vsl_dznd_capa_fr) > parseFloat(vsl_dznd_capa_to)) {
				ComAlertFocus(formObj.vsl_dznd_capa_fr, ComGetMsg('FMS01714'));
				formObj.vsl_dznd_capa_to.value='';
			}
		}
	}	
	/**
     * Comparing From-To after inserting Duration
     **/
    function duration_change() {
		var formObj=document.form;
		var fr_duration=formObj.fr_duration.value;
		var to_duration=formObj.to_duration.value;
		if (fr_duration != '' && to_duration != '') {
			if (parseFloat(fr_duration) > parseFloat(to_duration)) {
				ComAlertFocus(formObj.to_duration, ComGetMsg('FMS01715'));
				return false;
			}
		}
		return true;
	}	
	/**
     * Deleting TO of Contract Type
     **/
    function removeContractTP() {
		for (i=0;i<document.form.flet_ctrt_tp_cd.length;i++) {
			if (document.form.flet_ctrt_tp_cd.options[i].value == "TO") {
				document.form.flet_ctrt_tp_cd.remove(i);
				break;
			}
		}
	}	
  /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
		                
		              (15, 0, 0, true);
		              var HeadTitle1="Seq|TEU|Vessel\nCode|Last Dock Duration|Last Dock Duration|Last\nLOC|Last Ship Yard|Last Dock Type|Next Dock Duration|Next Dock Duration|Next\nLOC|Next Ship Yard|Next Dock Type|Class Recommendation|Class Recommendation";
		              var HeadTitle2="Seq|TEU|Vessel\nCode|From|To|Last\nLOC|Last Ship Yard|Last Dock Type|From|To|Next\nLOC|Next Ship Yard|Next Dock Type|From|To";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_dznd_capa",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"last_dck_fm_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"last_dck_to_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"last_dck_loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"last_ship_yard",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Combo",     Hidden:0, Width:127,  Align:"Left",    ColMerge:1,   SaveName:"last_flet_dck_svey_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"next_dck_fm_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"next_dck_to_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"next_dck_loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"next_ship_yard",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Combo",     Hidden:0, Width:127,  Align:"Left",    ColMerge:1,   SaveName:"next_flet_dck_svey_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rec_dck_fm_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rec_dck_to_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(0);
//		              SetSheetHeight(400);
		              resizeSheet();
                    }
                break;
        }
    }
  	// Handling Sheet Process
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:     
       	   	  	if(validateForm(sheetObj,formObj,sAction)){
	        		formObj.f_cmd.value=SEARCH;
 	        	   	sheetObj.DoSearch("ESM_FMS_0057GS.do", FormQueryString(formObj) );
       	   	  		//inputReadOnly("Search");
	  	   	  	}	
                break;
			case IBROWSEARCH:   
				if (Col == "ComCd") {//Status, Dry Dock Type
					CoFmsGetCombo("FORM", formObj, sheetObj, "CD01748:CD01513","flet_dck_svey_tp_cd:flet_ctrt_tp_cd", "flet_dck_svey_tp_cdText:flet_ctrt_tp_cdText");
					getDockTPCombo(sheetObj);					
	    		} else if (Col == "vsl_cd") {
					formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value=vslEngNm;
					} else {
						formObj.vsl_cd.value="";
						formObj.vsl_eng_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01056"));
						return;
					}
	    		} else if (Col == "lane_cd") {
					formObj.f_cmd.value=SEARCH05;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var cdName=ComGetEtcData(sXml, "cdName");
		   			if(typeof cdName != "undefined" && cdName != "" ) {
					} else {
						formObj.lane_cd.value="";
						ComAlertFocus(formObj.lane_cd, ComGetMsg("FMS01237"));
						return;
					}
				}	
        }
    }
    /**
     * Handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        if (!ComChkValid(formObj)) return false;
        return true;
    }
	/**
     * Getting Combo information of D/Dock TP
     **/
    function getDockTPCombo(sheetObj) {
    	var obj=document.form.flet_dck_svey_tp_cd;
		var comboCode='';
		var comboText='';
		for (i=0;i<obj.length;i++) {
			if (obj.options[i].value != "") {
				comboCode += obj.options[i].value + "|"
				comboText += obj.options[i].text + "|"
			}
		}
        sheetObj.SetColProperty("last_flet_dck_svey_tp_cd", {ComboText:comboText.substring(0 ,comboText.length-1), ComboCode:comboCode.substring(0,comboCode.length-1)} );
        sheetObj.SetColProperty("next_flet_dck_svey_tp_cd", {ComboText:comboText.substring(0 ,comboText.length-1), ComboCode:comboCode.substring(0,comboCode.length-1)} );
	}	
    /**
	 * Setting Ship Yard Name and Sequence selected in Yard PopUp into Form item.<br>
	 * @param {arry} aryPopupData
	 */
	function setFormYardName(aryPopupData){
		form.ydSeq.value=aryPopupData[0][3];
		form.shpYdNm.value=aryPopupData[0][4];
		form.btn_ydClr.checked=true;
	}
    
	function rdOpen(formObject){
		var rdParam = '/rv '+ RD_FormQueryString(formObject,1);
		//var rdParam  = '/rv '+ rdParam;
         	rdParam += " sqlQuery["+getSqlQuery(formObject)+"]";
    
		var rdFile = "apps/opus/esm/fms/timecharterinoutfleetmanagement/tchariodockschedule/report/ESM_FMS_058.mrd";
		

		formObject.com_mrdPath.value = rdFile;
		formObject.com_mrdArguments.value = rdParam;
		ComOpenRDPopup();
	}
    /**
     * Generating required Parameter when clicking print button <br>
     * @param {Form Object} formObject     	form name
     **/
    function getSqlQuery(formObject) {
        var sqlStr="  select  vsl_cd,																																			            \n"
                   +  "          slan_cd,                                                                                                                                                       \n"
                   +  "          vsl_dznd_capa,                                                                                                                                                 \n"
                   +  "          last_dck_fm_dt,                                                                                                                                                \n"
                   +  "          last_dck_to_dt,                                                                                                                                                \n"
                   +  "          last_dck_loc_cd,                                                                                                                                               \n"
                   +  "          last_flet_dck_svey_tp_cd,                                                                                                                                      \n"
                   +  "          next_dck_fm_dt,                                                                                                                                                \n"
                   +  "          next_dck_to_dt,                                                                                                                                                \n"
                   +  "          next_dck_loc_cd,                                                                                                                                               \n"
                   +  "          next_flet_dck_svey_tp_cd,                                                                                                                                      \n"
                   +  "          rec_dck_fm_dt,                                                                                                                                                 \n"
                   +  "          rec_dck_to_dt                                                                                                                                                  \n"
                   +  "  from    (                                                                                                                                                              \n"
                   +  "          select a.vsl_cd,                                                                                                                                               \n"
                   +  "                  d.slan_cd,                                                                                                                                             \n"
                   +  "                  b.vsl_dznd_capa,                                                                                                                                       \n"
                   +  "                  a.dck_fm_dt last_dck_fm_dt,                                                                                                        \n"
                   +  "                  a.dck_to_dt last_dck_to_dt,                                                                                                        \n"
                   +  "                  a.dck_loc_cd last_dck_loc_cd,                                                                                                                          \n"
                   +  "                  cd1.intg_cd_val_dp_desc last_flet_dck_svey_tp_cd,                                                                                                      \n"
                   +  "                  na.next_dck_fm_dt next_dck_fm_dt,                                                                                                  \n"
                   +  "                  na.next_dck_to_dt next_dck_to_dt,                                                                                                  \n"
                   +  "                  na.next_dck_loc_cd,                                                                                                                                    \n"
                   +  "                  cd2.intg_cd_val_dp_desc next_flet_dck_svey_tp_cd,                                                                                                      \n"
                   +  "                  nc.dck_fm_dt rec_dck_fm_dt,                                                                                                        \n"
                   +  "                  nc.dck_to_dt rec_dck_to_dt                                                                                                         \n"
                   +  "           from 	 fms_dck_skd a, fms_contract b,                                                                                                                     	\n"
                   +  "                  (select vsl_cd, flet_ctrt_no                                                                                                                       	\n"
                   +  "                  from (                                                                                                                                             	\n"
                   +  "                          select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                     	\n"
                   +  "                          from fms_contract                                                                                                                          	\n"
                   +  "                          where flet_ctrt_tp_cd <> 'TO'                                                                                                              	\n"
                   +  "                      )                                                                                                                                              	\n"
                   +  "                  where row_num=1                                                                                                                                  	\n"
                   +  "                  union all                                                                                                                                          	\n"
                   +  "                  select vsl_cd, flet_ctrt_no                                                                                                                        	\n"
                   +  "                  from (                                                                                                                                             	\n"
                   +  "                          select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                     	\n"
                   +  "                          from fms_id_vsl a                                                                                                                          	\n"
                   +  "                          where not exists (select null from fms_contract where vsl_cd=a.vsl_cd)                                                                   	\n"
                   +  "                      )                                                                                                                                              	\n"
                   +  "                  where row_num=1                                                                                                                                  	\n"
                   +  "                  ) c,                                                                                                                                               	\n"
                   +  "                  (select vsl_cd, slan_cd                                                                                                                            	\n"
                   +  "                   from (                                                                                                                                            	\n"
                   +  "                      select vsl_cd, slan_cd, vps_eta_dt, row_number() over(partition by vsl_cd order by vps_eta_dt desc) lane_num                               		\n"
                   +  "                      from vsk_vsl_port_skd                                                                                                                      		\n"
                   +  "                      where vps_eta_dt between to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd') and to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd')                         		\n"
                   +  "                  )                                                                                                                                              		\n"
                   +  "                   where lane_num=1) d,                                                                                                                            	\n"
                   +  "                  (select a.vsl_cd, a.dck_fm_dt,                                                                                                                     	\n"
                   +  "                          b.dck_fm_dt next_dck_fm_dt, b.dck_to_dt next_dck_to_dt, b.dck_loc_cd next_dck_loc_cd, b.flet_dck_svey_tp_cd next_flet_dck_svey_tp_cd       	\n"
                   +  "                   from   (                                                                                                                                          	\n"
                   +  "                          select vsl_cd, dck_fm_dt, row_number() over(partition by vsl_cd order by dck_fm_dt asc) row_num                                            	\n"
                   +  "                          From fms_dck_skd                                                                                                                           	\n"
                   +  "                          where dck_sel_cd='E') a,                                                                                                                 	\n"
                   +  "                         (                                                                                                                                           	\n"
                   +  "                          select vsl_cd, dck_fm_dt, dck_to_dt, dck_loc_cd, flet_dck_svey_tp_cd,                                                                      	\n"
                   +  "                                  row_number() over(partition by vsl_cd order by dck_fm_dt asc) row_num                                                              	\n"
                   +  "                          From fms_dck_skd                                                                                                                           	\n"
                   +  "                          where dck_sel_cd='E') b                                                                                                                  	\n"
                   +  "                   where a.vsl_cd=b.vsl_cd                                                                                                                         	\n"
                   +  "                   and   a.row_num=b.row_num-1) na,                                                                                                                	\n"
                   +  "                  (select vsl_cd, dck_fm_dt, dck_to_dt                                                                                                               	\n"
                   +  "                   from   fms_dck_skd                                                                                                                                	\n"
                   +  "                   where dck_sel_cd='C') nc, com_intg_cd_dtl cd1, com_intg_cd_dtl cd2                                                                              	\n";
			if (formObject.ownr_seq.value != "") { 
				sqlStr += "			 ,(select vndr_seq from mdm_vendor                                                                                                                          \n"
						+ "			 	where flet_mgmt_ownr_vndr_seq="+formObject.ownr_seq.value+") e                                                                                        \n";
			} 
			sqlStr += "					where a.vsl_cd=c.vsl_cd(+)                                                                                                                            \n"
					+ "					and   a.vsl_cd=d.vsl_cd(+)                                                                                                                            \n"
					+ "					and   b.flet_ctrt_no(+)=c.flet_ctrt_no                                                                                                                \n"
                    + "                 and   a.vsl_cd=na.vsl_cd(+)                                                                                                                          	\n"
                    + "                 and   a.dck_fm_dt=na.dck_fm_dt(+)                                                                                                                    	\n"
                    + "                 and   a.vsl_cd=nc.vsl_cd(+)                                                                                                                          	\n"
                    + "                 and   a.flet_dck_svey_tp_cd=cd1.intg_cd_val_ctnt(+)                                                                                                  	\n"
                    + "                 and   na.next_flet_dck_svey_tp_cd=cd2.intg_cd_val_ctnt(+)                                                                                            	\n"
                    + "                 and   cd1.intg_cd_id='CD01748'                                                                                                                    	\n"
                    + "                 and   cd2.intg_cd_id(+)='CD01748'                                                                                                                 	\n";
			if (formObject.flet_ctrt_tp_cd.value != "") {
				sqlStr += "		and   b.flet_ctrt_tp_cd like '"+formObject.flet_ctrt_tp_cd.value+"'||'%'                                                                                        \n";
			}
			if (formObject.vsl_dznd_capa_fr.value != "") { 
				sqlStr += "		and   b.vsl_dznd_capa >= "+formObject.vsl_dznd_capa_fr.value+"                                                                                                  \n";
			}  
			if (formObject.vsl_dznd_capa_to.value != "") {
				sqlStr += "		and   b.vsl_dznd_capa <= "+formObject.vsl_dznd_capa_to.value+"                                                                                                  \n";
			}
			if (formObject.lane_cd.value != "") {  
				sqlStr += "		and   d.slan_cd like '"+formObject.lane_cd.value+"'||'%'                                                                                                        \n";
			} 
			if (formObject.ownr_seq.value != "") {
				sqlStr += "		and   b.vndr_seq=e.vndr_seq                                                                                                                                   \n";
			}
			sqlStr += "			and	  a.vsl_cd like '"+formObject.vsl_cd.value+"'||'%'                                                                                                          \n"
					+ "			and   a.dck_sel_cd='E'                                                                                                                                        \n"
					+ "			and   a.flet_dck_svey_tp_cd like '"+formObject.flet_dck_svey_tp_cd.value+"'||'%'                                                                                \n";
			if (formObject.reflection_cd.value == "I") { 
				sqlStr += "		and a.phs_out_dt <= '"+formObject.to_duration.value+"'||'1231' and a.phs_in_dt >= '"+formObject.fr_duration.value+"'                                          \n";
			} else {
				sqlStr += "		and a.dck_fm_dt <= to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd') and a.dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd')\n";
			}
            sqlStr += "          union all                                                                                                                                                      \n"
                    + "          select a.vsl_cd,                                                                                                                                               \n"
                    + "                 d.slan_cd,                                                                                                                                              \n"
                    + "                 b.vsl_dznd_capa,                                                                                                                                        \n"
                    + "                 null last_dck_fm_dt,                                                                                                                                    \n"
                    + "                 null last_dck_to_dt,                                                                                                                                    \n"
                    + "                 null last_dck_loc_cd,                                                                                                                                   \n"
                    + "                 null last_flet_dck_svey_tp_cd,                                                                                                                          \n"
                    + "                 null next_dck_fm_dt,                                                                                                                                    \n"
                    + "                 null next_dck_to_dt,                                                                                                                                    \n"
                    + "                 null next_dck_loc_cd,                                                                                                                                   \n"
                    + "                 null next_flet_dck_svey_tp_cd,                                                                                                                          \n"
                    + "                 a.dck_fm_dt rec_dck_fm_dt,                                                                                                          \n"
                    + "                 a.dck_to_dt rec_dck_to_dt                                                                                                           \n"
                    + "           from fms_dck_skd a, fms_contract b,                                                                                                                    		\n"
                    + "                (select vsl_cd, flet_ctrt_no                                                                                                                       		\n"
                    + "                 from (                                                                                                                                             		\n"
                    + "                         select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                     		\n"
                    + "                         from fms_contract                                                                                                                          		\n"
                    + "                         where flet_ctrt_tp_cd <> 'TO'                                                                                                              		\n"
                    + "                     )                                                                                                                                              		\n"
                    + "                 where row_num=1                                                                                                                                  		\n"
                    + "                 union all                                                                                                                                               \n"
                    + "                 select vsl_cd, flet_ctrt_no                                                                                                                             \n"
                    + "                 from (                                                                                                                                                  \n"
                    + "                              select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                     \n"
                    + "                              from fms_id_vsl a                                                                                                                          \n"
                    + "                              where not exists (select null from fms_contract where vsl_cd=a.vsl_cd)                                                                   \n"
                    + "                          )                                                                                                                                              \n"
                    + "                 where row_num=1                                                                                                                                  \n"
                    + "                 ) c,                                                                                                                                               \n"
                    + "                 (select vsl_cd, slan_cd                                                                                                                            \n"
                    + "                  from (                                                                                                                                            \n"
                    + "                              select vsl_cd, slan_cd, vps_eta_dt, row_number() over(partition by vsl_cd order by vps_eta_dt desc) lane_num                               \n"
                    + "                              from vsk_vsl_port_skd                                                                                                                      \n"
                    + "                              where vps_eta_dt between to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd') and to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd')                         \n"
                    + "                          )                                                                                                                                              \n"
                    + "                  where lane_num=1) d                                                                                                                             \n";
			if (formObject.ownr_seq.value != "") { 
				sqlStr += "			 ,(select vndr_seq from mdm_vendor                                                                                                                          \n"
						+ "				where flet_mgmt_ownr_vndr_seq="+formObject.ownr_seq.value+") e                                                                                        \n";
			} 
			sqlStr += "			where a.vsl_cd=c.vsl_cd(+)                                                                                                                                    \n"
					+ "			and   a.vsl_cd=d.vsl_cd(+)                                                                                                                                    \n"
					+ "			and   b.flet_ctrt_no(+)=c.flet_ctrt_no                                                                                                                        \n";
			if (formObject.flet_ctrt_tp_cd.value != "") {
				sqlStr += "		and   b.flet_ctrt_tp_cd like '"+formObject.flet_ctrt_tp_cd.value+"'||'%'                                                                                        \n";
			}
			if (formObject.vsl_dznd_capa_fr.value != "") { 
				sqlStr += "		and   b.vsl_dznd_capa >= "+formObject.vsl_dznd_capa_fr.value+"                                                                                                  \n";
			}  
			if (formObject.vsl_dznd_capa_to.value != "") {
				sqlStr += "		and   b.vsl_dznd_capa <= "+formObject.vsl_dznd_capa_to.value+"                                                                                                  \n";
			}
			if (formObject.lane_cd.value != "") {  
				sqlStr += "		and   d.slan_cd like '"+formObject.lane_cd.value+"'||'%'                                                                                                        \n";
			} 
			if (formObject.ownr_seq.value != "") {
				sqlStr += "		and   b.vndr_seq=e.vndr_seq                                                                                                                                   \n";
			}
			sqlStr += "			and	  a.vsl_cd like '"+formObject.vsl_cd.value+"'||'%'                                                                                                          	 \n"
					+ "			and   a.dck_sel_cd='C'                                                                                                                                        	 \n"
					+ "			and   a.flet_dck_svey_tp_cd like '"+formObject.flet_dck_svey_tp_cd.value+"'||'%'                                                                                	 \n"
                    + "         and   not exists (select null from fms_dck_skd where vsl_cd=a.vsl_cd and dck_sel_cd='E')                                                           				 \n"
                    + "         and   a.dck_fm_dt <= to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd') and a.dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd')\n"
                    + "  )     ";                                                                                                                                     
		return sqlStr;
	}
     /**
      * In case of clicking PopUp in IBSheep Object
      */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	
	}	

 	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	}
 	