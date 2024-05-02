/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0042.js
*@FileTitle  : TDR Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var selFrameId;
var iframeMap = new HashMap();
var iframeAddHeight = 0;

/*------------------For JSDoc ------------------*/
    /**
     * @extends  
     * @class vop_opf_0036 : vop_opf_0036 business script for
     */
   	/* Developer performance	*/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var marrTabTitle=new Array("SKD & COND", "Port Log", "Disch. Vol.", "Load Vol.", "COD", "R/H", "Mishandle", "Slot", "Temp. STWG", "Remark(s)");
var enableButton=new Array("btn_ExcludefromTPR","btn_Mail", "btn_Print");
//items related VVD CD
var strVVDOptions="vsl_cd|skd_voy_no|skd_dir_cd";
var bRetrive=false;
var bFirst=true;
var bFirstTdrSearch=true;
var sheetCheckEdit=null;
//crane Info
var beforeCraneCnt=0;
var arrPreCond=new Array("", "", "", "");
var sheetSplit="|$$|";
var totColor="#CCFFFD";		
var titColor="#E5EAFF";		
var oldLoseTime="";
var autoCalcuCheck=false;
var popupSheet=null;		
var popupPrefix="";
var popupColNm="";
var mCheckValue=false;
var checkyDcDFlg=false;	
//InitCombo Val
var mPodCode="";
var mPodName="";
var mLoadPodCode="";
var mLoadPodName="";
var mSztpCode="";
var mSztpName="";
var mReasonCode="";
var mReasonName="";
var multiSearchCheck=false;	
var arrClptIndSeq=new Array();

// Event handler processing by button click event */
document.onclick=processButtonClick;
    function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
    //	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btns_searchVvd":
					var vslcd=getObjValue("vsl_cd");
					var sUrl="";
					if(vslcd == ""){
						sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
						ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
					}else{
						sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslcd;
						ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
					}
					break;
				case "btn_Retrieve":
					doActionIBSheet(beforetab, formObject, IBSEARCH);
					break;
				case "btn_New":
					tdrScreenNew(formObject, true);
					break;
				case "btn_Delete":
					doActionIBSheet(beforetab, formObject, IBDELETE);
					break;
                case "btn_ExcludefromTPR":
                    var btnObj=window.event.srcElement;
                    formObject.authbtn.value="R";
                    formObject.clpt_ind_seq.value=sheetTdrH.GetCellValue(sheetTdrH.GetSelectRow(), "sheetTdrH_call_ind");
                    var param=FormQueryString(document.form);
                    param="f_cmd="+formObject.f_cmd.value;
                    param += "&vsl_cd="+formObject.vsl_cd.value;
                    param += "&skd_dir_cd="+formObject.dir_cd.value;
                    param += "&skd_voy_no="+formObject.voy_no.value;
                    param += "&port_cd="+formObject.port_cd.value;
                    param += "&clpt_ind_seq="+formObject.clpt_ind_seq.value;
                    param += "&authbtn=R";
                    ComOpenPopup("/opuscntr/VOP_OPF_0037.do?"+param, 610, 540, "setCallBackPort", "0,1,1,1,1,1,1", true);
                    break;
				case "btn_Save":
					doActionIBSheet(beforetab, formObject, IBSAVE);
					break;
				case "btn_t1ActualInfo":
					formObject.f_cmd.value=SEARCH01;
					var prefix="t1sheet1_";
					var sXml=sheetObjects[0].GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObject) + "&" + ComGetPrefixParam(prefix));
					sheetObjects[0].SetWaitImageVisible(0);
					sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
					//ComReplaceStr(sheetObj.CellValue(Row,  prefix + "loc_cd")
					//input value in column
					if(sheetObjects[0].RowCount()> 0){
						for(var idxCol=1; idxCol <= sheetObjects[0].LastCol(); idxCol++){
							var objName=ComReplaceStr(sheetObjects[0].ColSaveName(idxCol), prefix, "");
							setObjValue(objName, sheetObjects[0].GetCellText(1, idxCol));
						}
					}
					break;
				case "btn_Print":
					var rdParam="/rp ["+(formObject.vsl_cd.value)+"]"					// 1.Vessel Code
								   + " ["+(formObject.skd_voy_no.value)+"]"					// 2.Voyage Nu
								   + " ["+(formObject.skd_dir_cd.value)+"]"					// 3.Direction            
								   + " ["+(formObject.port_cd.value)+"]"				// 4.Port Code
//								   + " ["+(formObject.yd_cd.GetSelectCode())+"]" 					// 5.Yard Code
	   							+ " ["+(formObject.yd_cd.value)+"]"	
                                   + " ["+(formObject.clpt_ind_seq.value)+"]";
				     formObject.com_mrdArguments.value=rdParam;
                    //searchVvdMailInfo();
    	    		//ComOpenRDPopup();
				     ComOpenRDPopupModal();
					break;
				case "btn_Mail":
                    var rdParam="/rp ["+(formObject.vsl_cd.value)+"]"                 // 1.Vessel Code
                                    + " ["+(formObject.skd_voy_no.value)+"]"                 // 2.Voyage Nu
                                    + " ["+(formObject.skd_dir_cd.value)+"]"                 // 3.Direction            
                                    + " ["+(formObject.port_cd.value)+"]"                // 4.Port Code
//                                    + " ["+(formObject.yd_cd.GetSelectCode())+"]"                   // 5.Yard Code
                                	+ " ["+(formObject.yd_cd.value)+"]"	
                                    + " ["+(formObject.clpt_ind_seq.value)+"]";
							//	   + " ["+(formObject.sys_create.value)+"]"        
					formObject.com_templateMrdArguments.value=rdParam;
					searchVvdMailInfo();
					//ComSendMail();
					
					//mail receive delivery 2014.11.13
					searchReceiveInfo();
					
					ComSendMailModal();
					break;
				//Disch Vol Tab Change
				case "chk_DischVol":
					disChargTabChange();
					break;
				//Disch Vol Tab Change
				case "chk_LoadVol":
					disLoadTabChange();
					break;
				//Disch Vol Tab Change
				case "chk_Slot":
						disSlotTabChange();
						break;
				case "btn_Close":
					ComClosePopup(); 
					break;
/** (Tab) [ Remark ] (E) **/
			} // end switch
    }
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		//Disable Button;
		// initializing IBMultiCombo
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        resizeSheet();
        
		initControl();
		initComboSzTp();
		formReadonly(true);
		document.form.vsl_cd.focus();
		for( var k=0; k < enableButton.length; k++){
			ComBtnDisable(enableButton[k]);
		}
		
		
		
		// document.all("btn_ExcludefromTPR").style.color = "#514747";
    }
    
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
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
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
	// handling work javascript OnKeyUp event
	function obj_keyup() {
		switch(event.srcElement.name){ 
			case "skd_dir_cd":
				if(getObjValue("skd_dir_cd") != ""){
					searchVVDInfo();
				}
				break;
			default:
				obj_nextfocus(event.srcElement);
				break;     
		}
	}  
	// change focus to next HTML Tag(object) of HTML Tag(object) received as factor
	function obj_nextfocus(obj) {
		var objMaxLength=obj.getAttribute("maxlength");
		var objValue=obj.value;
		if (ComChkLen(objValue, objMaxLength) == 2) {
			ComSetNextFocus(obj);
		}
	}
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetObj.id){
			case "t1sheet1":
				with (sheetObj) {
	                var HeadTitle1="";
	                for(var idxCol=0; idxCol < 38; idxCol++){
	                HeadTitle1 += "|";
	                }
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                var prefix="t1sheet1_";
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"first_pilot_on",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"anchorage_arr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"berth",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eta_next_port",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eta_next_date",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"unberth",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"anchorage_dep",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"last_pilot_off",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_draft_fwd",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_draft_aft",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_draft_fwd",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_draft_aft",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_ballast",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_ballast",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_rob_fo",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_rob_do",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_rob_fw",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_rob_fo",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_rob_do",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_rob_fw",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_low_sul_fo",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_low_sul_do",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_low_sul_fo",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_low_sul_do",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_slp_fo",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_slp_do",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_slp_fw",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_low_sul_fo_wgt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_low_sul_do_wgt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_dwt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_displt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_dwt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_displ",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_gm",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_gm",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_tugboat",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_tugboat",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                for(var rowIdx=1; rowIdx <= SaveNameCol(prefix + "last_pilot_off"); rowIdx++){
		                	if(ColSaveName(rowIdx) != prefix + "eta_next_port"){
		                		SetColProperty(rowIdx, {Format:"####-##-## ##:##.#"} );
								}
							}
		         		InitColumns(cols);
                		SetEditable(1);
		                SetSheetHeight(100);
				}
				break;
				
            case "t2sheet1":
                with (sheetObj) {
	                var HeadTitle1="||Work Commenced|Work Completed|Break Down|Meal|Weather|Other|Total|work|crane_no";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                var prefix="t2sheet1_";
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
								{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"crane_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"work_comm",  KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"work_comp",  KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"break_down", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"meal",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"weather",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"other",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"total",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"work",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"crane_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetColProperty(prefix+"work_comm", {Format:"####-##-## ##:##"} );
	                SetColProperty(prefix+"work_comp", {Format:"####-##-## ##:##"} );
	                SetColProperty(prefix+"break_down", {Format:"###:##"} );
	                SetColProperty(prefix+"meal", {Format:"###:##"} );
	                SetColProperty(prefix+"weather", {Format:"###:##"} );
	                SetColProperty(prefix+"other", {Format:"###:##"} );
	                SetColProperty(prefix+"total", {Format:"###:##"} );
	                SetColProperty(prefix+"work", {Format:"###:##"} );
	                totColor="#CCFFFD";
	                titColor="#E5EAFF";
	                //FrozenRows=2;
	                SetSheetHeight(230);
				}
				break;
				
			case "sheetTdrH":
                with (sheetObj) {
					var HeadTitle1="|VSL_CD|VOY_NO|DIR_CD|PORT_CD|CALL_IND|TML_CD|TDR_DATE|TDR_USER|COMMENCE|COMPLETE|GROSS_WORK|NET_WORK|LOSE_HR|GROSS_GANG|NET_GANG|MVS|NET_TML|GROSS_TML|NET_GC|GROSS_GC|REMARK|HATCH|CON|PILOT_ARR|PILOT_DEP|ANCHOR_ARR|ANCHOR_DEP|BERTH|UNBERTH|DRAFT_FWD_ARR|DRAFT_FWD_DEP|DRAFT_AFT_ARR|DRAFT_AFT_DEP|BALLAST_ARR|BALLAST_DEP|ROB_FO_ARR|ROB_FO_DEP|ROB_DO_ARR|ROB_DO_DEP|ROB_FW_ARR|ROB_FW_DEP|BUNKER_FO_ARR|BUNKER_FO_DEP|BUNKER_DO_ARR|BUNKER_DO_DEP|BUNKER_FW_ARR|BUNKER_FW_DEP|DWT_ARR|DWT_DEP|DISPL_ARR|DISPL_DEP|GM_ARR|GM_DEP|TUG_ARR|TUG_DEP|ETA|ETA_CANAL|INFO|UPDATE_USER|UPDATE_TIME|SULPHUR_FO_ARR|SULPHUR_FO_DEP|SULPHUR_DO_ARR|SULPHUR_DO_DEP|SUPPLY_SULPHUR_FO|SUPPLY_SULPHUR_DO|NEXT_PORT|NEXT_PORT_DT|NEXT_CANAL|NEXT_CANAL_DT|EXISTS_TML_DEP_RPT_DTL";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="sheetTdrH_";	
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );	
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);	
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"voy_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"port_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"call_ind",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tdr_date",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tdr_user",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"commence",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"complete",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gross_work",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"net_work",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"lose_hr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gross_gang",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"net_gang",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mvs",                    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"net_tml",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gross_tml",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"net_gc",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gross_gc",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"remark",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"hatch",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"con",                    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pilot_arr",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pilot_dep",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"anchor_arr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"anchor_dep",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"berth",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"unberth",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"draft_fwd_arr",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"draft_fwd_dep",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"draft_aft_arr",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"draft_aft_dep",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ballast_arr",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ballast_dep",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_fo_arr",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_fo_dep",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_do_arr",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_do_dep",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_fw_arr",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_fw_dep",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_fo_arr",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_fo_dep",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_do_arr",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_do_dep",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_fw_arr",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_fw_dep",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dwt_arr",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dwt_dep",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"displ_arr",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"displ_dep",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gm_arr",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gm_dep",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tug_arr",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tug_dep",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eta",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eta_canal",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"info",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sulphur_fo_arr",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sulphur_fo_dep",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sulphur_do_arr",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sulphur_do_dep",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"supply_sulphur_fo",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"supply_sulphur_do",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"next_port",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"next_port_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"next_canal",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"next_canal_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"used_crane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"avg_crane",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exists_tml_dep_rpt_dtl", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
//					for(var rowIdx=SaveNameCol(prefix + "pilot_arr"); rowIdx <= SaveNameCol(prefix + "unberth"); rowIdx++){
//						SetColProperty(rowIdx, {Format:"####-##-####:##"} );
//					}
					InitColumns(cols);
					
					SetColProperty(prefix + "pilot_arr", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix + "pilot_dep", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix + "anchor_arr", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix + "anchor_dep", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix + "berth", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix + "unberth", {Format:"####-##-## ##:##"} );
					
					SetColProperty(prefix+"next_port_dt", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"eta", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"eta_canal", {Format:"####-##-## ##:##"} );
					
					SetEditable(0);
					SetSheetHeight(102);
				}
				break;
		}
	}
	/**
	* initialize IBCOMBO. <br>
	**/
	function sheetInitTotal(sheetObj){
		var cnt=0;
		with (sheetObj) {
	        var cellCol="";
	        var prefix="";
	        var HeadTitle1="";
	        var HeadTitle2="";
	        var HeadTitle3="";
	        var subTitle1=(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2" ? "Outbound" : "Inbound");
	        if(sheetObj.id == "t3sheet1"){
	        	cellCol="full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|full_ts_20|full_ts_2h|full_ts_40|full_ts_4h|full_ts_45|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|et_ts_20|et_ts_2h|et_ts_40|et_ts_4h|et_ts_45|wt_20|wt_2h|wt_40|wt_4h|wt_45";
	        }else{
	        	cellCol="full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|wt_20|wt_2h|wt_40|wt_4h|wt_45";
	        }
	        prefix=sheetObj.id + "_";
	        if(sheetObj.id == "t3sheet1"){
		        HeadTitle1="|Operator|POD|idx_Sheet|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight|Weight|Weight|Weight|Weight";
		        HeadTitle2="|Operator|POD|idx_Sheet|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo| | | | |";
		        HeadTitle3="|Operator|POD|idx_Sheet|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'";
	        }else{
		        HeadTitle1="|Operator|POD|idx_Sheet|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight|Weight|Weight|Weight|Weight";
		        HeadTitle2="|Operator|POD|idx_Sheet|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'";
	        }
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        if(sheetObj.id == "t3sheet1"){
	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, Page:20, DataRowMerge:1 } );	       
	        	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"},{ Text:HeadTitle3, Align:"Center"}];
		        sheetObj.InitHeaders(headers, info);
	        }else{
	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, Page:20, DataRowMerge:1 } );	       
	        	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [{ Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"}];
		        sheetObj.InitHeaders(headers, info);
	        }
	        var cols = [ {Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 } ];
	        if(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2"){
	        		cols.push({Type:"ComboEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 });
	        }else{
	        		cols.push({Type:"Text",      Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	        	}
	        cols.push({Type:"Text",      Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"idx_sheet",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	        var arrCol=cellCol.split("|");
	        if(sheetObj.id == "t3sheet1"){
	        	for(var idxCol=0; idxCol < arrCol.length; idxCol++){
	        			if(arrCol[idxCol].length == 5)
	        				cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	        			else
	        				cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	        		}
	        	}else{
	        		for(var idxCol=0; idxCol < arrCol.length; idxCol++){
	        			if(arrCol[idxCol].length == 5)
	        				cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	        			else
	        				cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	        		}
	   
	        }
	        sheetObj.InitColumns(cols);
	        sheetObj.SetEditable(0);
	        sheetObj.SetSheetHeight(380);
		}
	}
	
	function sheetInitSC(sheetObj){
		var cnt=0;
		with (sheetObj) {
				var HeadTitle1="|Operator|POD|idx_sheet|DG Cargo|DG Cargo|DG Cargo|DG Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo";
				var HeadTitle2="|Operator|POD|idx_sheet|Quantity|Quantity|Weight|Weight|Quantity|Quantity|Weight|Weight|Quantity|Quantity|Weight|Weight";
				var HeadTitle3="|Operator|POD|idx_sheet|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var cellCol="dg_20_qty|dg_40_qty|dg_20_wgt|dg_40_wgt|rf_20_qty|rf_40_qty|rf_20_wgt|rf_40_wgt|ak_20_qty|ak_40_qty|ak_20_wgt|ak_40_wgt";
				var prefix=sheetObj.id + "_";
		
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},
				                { Text:HeadTitle2, Align:"Center"},
				                { Text:HeadTitle3, Align:"Center"} ];
				InitHeaders(headers, info);
		
				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 } ];
				if(id == "t3sheet2")
				cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 });
				else
				cols.push({Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 });
				cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"idx_sheet",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				var arrCol=cellCol.split("|");
				for(var idxCol=0; idxCol < arrCol.length; idxCol++){
				if(arrCol[idxCol].indexOf("wgt") == -1 ){//
				cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
				}else{
				cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
				}
			}
				 
			InitColumns(cols);
			SetEditable(0);
			SetSheetHeight(380);
		}
	}
	
	function sheetInitBreakBulk(sheetObj){
		var cnt=0;
		with (sheetObj) {
			var HeadTitle1="|POD|Dimension (L X W X H)|Dimension (L X W X H)|Dimension (L X W X H)|Slot|Weight (Ton)|Crane Type|Working Time|Working Time|Operator|Container No.|cod_chk";
			var headCount=ComCountHeadTitle(HeadTitle1);
			var prefix=sheetObj.id + "_";

			SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dml",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dmb",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dmh",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:prefix+"slot",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"weight",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
			             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"crane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"commence", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"complete", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"opr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"cod_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			 
			InitColumns(cols);

			SetEditable(0);
			SetColProperty(prefix+"crane", {ComboText:"G/Crane|F/Crane", ComboCode:"G|F"} );
			SetColProperty(prefix+"commence", {Format:"####-##-## ##:##.#"} );
			SetColProperty(prefix+"complete", {Format:"####-##-## ##:##.#"} );
			SetColProperty(prefix + "cntr_no", vtEngUpOther, "1234567890");
			SetSheetHeight(380);
		}
	}
	
	function slotPortDep(sheetObj){
		var cnt=0;
		with (sheetObj) {
            var HeadTitle1="";
            var HeadTitle2="";
            if(sheetObj.id == "t8sheet3"){
            HeadTitle1="|Operator|Status|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|Grand TTL Used Slot|Grand TTL Used Slot";
            HeadTitle2="|Operator|Status|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)";
            }else if(sheetObj.id == "t8sheet4"){
            HeadTitle1="|Operator|Status|Bsa Type|Teu|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Add Slot\n(HC/45)|Sub TTL Used Slot|Sub TTL Used Slot|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Add Slot\n(HC/45)|Sub TTL Used Slot|Sub TTL Used Slot|Grand TTL Used Slot|Grand TTL Used Slot|BSA\n(+ Slot Swap)|BSA\n(+ Slot Swap)|Over Used Slot|Over Used Slot|Over Slot Settlement|Over Slot Settlement";
            HeadTitle2="|Operator|Status|Bsa Type|Teu|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Add Slot\n(HC/45)|Slot\n(TEU)|Slot\n(Ton)|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Add Slot\n(HC/45)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)|Slot(TEU)|By";
            }
            var headCount=ComCountHeadTitle(HeadTitle1);
            var cellCol="";
            if(sheetObj.id == "t8sheet3")
            cellCol="trade_full|trade_mt|trade_ab|trade_sub_slot|trade_sub_wgt|inter_full|inter_mt|inter_ab|inter_sub_slot|inter_sub_wgt|grand_ttl_slot|grand_ttl_wgt";
            else if(sheetObj.id == "t8sheet4")
            cellCol="trade_full|trade_mt|trade_ab|trade_45|trade_sub_slot|trade_sub_wgt|inter_full|inter_mt|inter_ab|inter_45|inter_sub_slot|inter_sub_wgt|grand_ttl_slot|grand_ttl_wgt|bsa_slot|bsa_wgt|over_slot|over_wgt|over_settle|over_settle_by";
            var prefix=sheetObj.id + "_";

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"},
                            { Text:HeadTitle2, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                         {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
                         {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"status",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 } ];
                                                                                          
            	if(sheetObj.id == "t8sheet4"){
            		cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bsa_type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 });
            		cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"teu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
            	}
            	var arrCol=cellCol.split("|");
            	for(var idxCol=0; idxCol < arrCol.length; idxCol++){
            		if(arrCol[idxCol] == "trade_sub_wgt" || arrCol[idxCol] == "inter_sub_wgt")
            			cols.push({Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
            		else if(arrCol[idxCol] == "trade_sub_slot" || arrCol[idxCol] == "inter_sub_slot" || arrCol[idxCol] == "grand_ttl_slot" || arrCol[idxCol] == "bsa_slot" || arrCol[idxCol] == "over_slot")	//Integer고 작성불가능.
            			cols.push({Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
            		else if(arrCol[idxCol] == "grand_ttl_wgt" || arrCol[idxCol] == "bsa_wgt" || arrCol[idxCol] == "over_wgt" || arrCol[idxCol] == "over_settle")					//Float고 작성불가능.
            			cols.push({Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
            		else if(arrCol[idxCol] == "over_settle_by")
            			cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            		else
            			cols.push({Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
            	}
            	if(sheetObj.id == "t8sheet4")
            		SetColProperty(prefix+"over_settle_by", {ComboText:"|Slot|Weight|Fixed", ComboCode:"|S|W|F"} );
            	InitColumns(cols);
            	SetColProperty(0, prefix + "opr_cd", vtEngUpOnly);
            	SetEditable(0);
            	SetSheetHeight(380);
		}
	}
	
	/**
	* initialize IBCOMBO. <br>
	**/
	function initCombo(comboObj, comboNo) {
		switch(comboObj.options.id) {
			case "yd_cd":
				var i=0;
				with(comboObj) {
//					comboObj.SetBackColor("#CCFFFF");
					comboObj.SetBackColor("#CCFFFD");
					comboObj.SetDropHeight(200);
					comboObj.SetMultiSelect(0);
					comboObj.SetMaxSelect(1);
					comboObj.SetUseAutoComplete(1);
                    //no support[check again]CLT ValidChar(2,0);
				}
				break;
		}
	} 
	
	/**
     * Setting Tab
     * Set item of Tab
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
			case 1:
                with (tabObj) {
                    var cnt=0 ;
					for(; cnt < marrTabTitle.length; cnt++){
						InsertItem( marrTabTitle[cnt], "");
					}
			}
            break;
        }
        tabObj.SetSelectedIndex(0);
    }
    
    /**
     * In case of clicking Tab event relation
     * activate element of Tab chosen
     */
    function tabTdr_OnChange(tabObj , nItem){
		if(bFirst){
			var objs=document.all.item("tabLayer");
			objs[nItem].style.display="Inline";
			objs[beforetab].style.display="none";
			//--------------- important --------------------------//
			objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
			//------------------------------------------------------//
			beforetab=nItem;
			
			resizeSheet();
		}
		bFirst=false;
    }
    
    /**
     * In case of clicking Tab event relation
     * activate element of Tab chosen
	 */
    function tabTdr_OnClick(tabObj , nItem){
		var formObject=document.form;
		if(nItem == beforetab){
			return;
		}
		if(bFirst){
			sheetRemoveAll();
		}
		var objs = document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		for (var i = 0; i < objs.length; i ++) {
		if (i != nItem) {
			objs[i].style.display = "none";
			objs[i].style.zIndex=objs[nItem].style.zIndex -1 ;
			}
		}
		beforetab=nItem;
		switch(marrTabTitle[nItem]) {
			case "Disch. Vol.":
				var frame=document.getElementById("t3frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_3.do?btnDis=N";
					return;
				}
				break;
			case "Load Vol.":
				var frame=document.getElementById("t4frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_4.do?btnDis=N";
					return;
				}
				break;
			case "COD":
				var frame=document.getElementById("t5frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_5.do?btnDis=N";
					return;
				}
				break;
			case "R/H":
				var frame=document.getElementById("t6frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_6.do?btnDis=N";
					return;
				}
				break;
			case "Mishandle":
				var frame=document.getElementById("t7frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_7.do?btnDis=N";
					return;
				}
				break;
			case "Slot":
				var frame=document.getElementById("t8frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_8.do?btnDis=N";
					return;
				}
				break;
			case "Temp. STWG":
				var frame=document.getElementById("t9frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_9.do?btnDis=N";
					return;
				}
				break;
		}
		if(bRetrive){
			if(marrTabTitle[beforetab] == "Disch. Vol." || marrTabTitle[beforetab] == "Load Vol." || marrTabTitle[beforetab] == "Slot"){
				if(marrTabTitle[beforetab] == "Disch. Vol."){
					t3frame.document.form.chk_DischVol[0].checked=true;
					if(t3frame.beforeDistchVolTab != 0)
						t3frame.disChargTabChange();
				}else if(marrTabTitle[beforetab] == "Load Vol."){
					t4frame.document.form.chk_LoadVol[0].checked=true;
					if(t4frame.beforeLoadVolTab != 0)
						t4frame.disLoadTabChange();
				}else if(marrTabTitle[beforetab] == "Slot"){
					t8frame.document.form.chk_Slot[0].checked=true;
					if(t8frame.beforeSlotTab != 0){
						t8frame.disSlotTabChange();
					}
				}
				doActionIBSheetMulti(beforetab, document.form);
			}else{
				doActionIBSheet(beforetab, document.form, IBSEARCH);
			}
		}
		topSync();
		iframeResize(false);
    }
    
	function topSync(){
		if(!bRetrive){
			document.form.vsl_cd.focus();
		}
		top.height;
	}
	
    /**
    * setting initial event
    */
    function initControl() {
//		axon_event.addListenerForm  ('blur',			'obj_deactivate',	form);
//		axon_event.addListenerForm	("keyup",			'obj_keyup',		form);	
//        axon_event.addListenerFormat('focus',			'obj_activate',		form); 
//        axon_event.addListenerFormat('keypress',        'obj_keypress', 	form); 
//		axon_event.addListener('keypress', 'slan_cd_onkeypress', 'slan_cd');		// kiem tra lai co function ko	
//    	axon_event.addListener('keyup', 'slan_cd_onkeyup', 'slan_cd');				// kiem tra lai co function ko
//    	axon_event.addListener('blur', 'used_crane_onblur', 'used_crane');			
//    	axon_event.addListener('blur', 'tdr_info_onchange', 'tdr_info');
		//ssss
//    	axon_event.addListener('change', 'vsl_cd_onchange', 'vsl_cd');				
//    	axon_event.addListener('change', 'skd_voy_no_onchange', 'skd_voy_no');				
    }
    
	function initComboSzTp(){
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH09;
		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
		var arrCombo=ComXml2ComboString(sXml, "val", "name");
		mSztpCode=" |" + arrCombo[0];
		mSztpName=" |" + arrCombo[1];
		formObj.f_cmd.value=SEARCH10;
		formObj.comboCd.value="CD02153";
		sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
		arrCombo=ComXml2ComboString(sXml, "val", "name");
		mReasonCode=" |" + arrCombo[0];
		mReasonName=" |" + arrCombo[1];
	}
	
    /**
     * delete mask separator in onfocus event of HTML Control <br>
     **/
    function obj_activate(){
        //ComClearSeparator(event.srcElement);
		event.srcElement.select();
    }
    
    /**
     * checking validation and saving mask separator  in onfocusevent of HTML Control
     **/
	function obj_deactivate(){
		if(event.srcElement.dataformat == "ymdhm"){
		}
		/*var objName=event.srcElement.name;
		if(sheetObjects[0].SaveNameCol("t1sheet1_" + objName) > 0){
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "t1sheet1_" + objName,event.srcElement.value);
		}*/
	}
	
	/**
	/**
	 * retrieve VVD info <br>
	 **/
	function searchVVDInfo() {
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH06;
 		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
        //Setting item related VVD Info
 		setVVDInfo(formObj, sXml);
	}
	
    function searchVvdMailInfo(){
        var formObj=document.form;
        formObj.f_cmd.value=SEARCH06;
        var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
        var dataColNm="vsl_slan_cd|vsl_eng_nm|skd_voy_no|skd_dir_cd";
        var vvdInfoData=ComOpfXml2Array(sXml, dataColNm);
        var aVvdInfoData=vvdInfoData[0];
//        var s="["+aVvdInfoData[0]+" TDR] M/V "+aVvdInfoData[1]+" "+aVvdInfoData[2]+aVvdInfoData[3]+", "+formObj.yd_cd.GetSelectCode();
        var s="["+aVvdInfoData[0]+" TDR] M/V "+aVvdInfoData[1]+" "+aVvdInfoData[2]+aVvdInfoData[3]+", "+formObj.yd_cd.value;
        formObj.com_subject.value=s;
    }
    
	/**
	 * Setting item related VVD Info : VVD, Lane, Vessel Operator
	 */
	function setVVDInfo(formObj, s2Xml) { 	 
		var vvdData=ComOpfXml2Array(s2Xml, strVVDOptions);
		if(vvdData == null) {
			ComShowCodeMessage("COM132201", "VVD CD");
			initObjs("form", formObj, strVVDOptions, 0, "");
		}else{
			if(vvdData.length < 1) {
				ComShowCodeMessage("COM132201", "VVD CD");
				initObjs("form", formObj, strVVDOptions, 0, "");
			} else {
				setYardCombo(formObj);
			}
		}
	}
	
	function setYardCombo(formObj) {
		formObj.yd_nm.value = "";
		formObj.f_cmd.value=SEARCH05;
        var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        ComXml2ComboItem(arrXml[0], yd_cd, "val", "name");
        
        var sClptIndSeq=ComGetEtcData(sXml, "strClptIndSeq");
        arrClptIndSeq=sClptIndSeq.split("|"); 
        //sheetObjects[0].SetSelectIndex(1);
        ComSetFocus(document.all.item("yd_cd"));
	}
	
	/**
	 * Get Object Value
	 */
	function getObjValue(name) {
		return ComGetObjValue(eval("document.form."+name));
	}
	
	/**
	 * Set Object Value
	 */
	function setObjValue(name, value) {
		ComSetObjValue(eval("document.form."+name), value);
	}
	
	/**
	 * change focus and initialize Object chose 
	 */
	function initObjs(type, sheetObj, nameVars, focusIdx, etcVal) {
		var nameArrs=nameVars.split("|");
		for(var objIdx=0; objIdx<nameArrs.length; objIdx++) {
			if(type == 'sheet') 
				sheetObj.SetCellValue(etcVal, prefixs[0]+nameArrs[objIdx],"",0);
			else 
				ComClearObject(eval("document.form." + nameArrs[objIdx]));
			if(focusIdx == objIdx) {
				if(type == 'sheet') 
					sheetObj.SelectCell(etcVal, focusIdx);
				else 
					ComSetFocus(document.all.item(nameArrs[objIdx]));
			}
		}
	}
	
    function doActionIBSheet(tabIdx, formObj, sAction) {
        switch(sAction) {
			case IBSEARCH:		//Retrieve
				if(validateForm(formObj,sAction)){
					if(sheetTdrH.RowCount()< 1){
						tdrHeaderSearch(formObj);
					}
					switch(marrTabTitle[tabIdx]){
						case "SKD & COND":
							if(sheetTdrH.RowCount()> 0){
								getTdrHeaderVal(formObj, sheetTdrH);
							}else{
								return;
							}
							break;
							
						case "Port Log":
							var sheetObj=t2sheet1;
							var prefix="t2sheet1_";
							
							with(sheetObj){
								formObj.f_cmd.value=SEARCH02;
								var sXml=GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t2sheet1_"));
								if(ComGetEtcData(sXml, "used_crane") != null && ComGetEtcData(sXml, "used_crane") != "undefined"){
									setObjValue("used_crane", 		ComGetEtcData(sXml, "used_crane")); 		
									setObjValue("avg_crane", 		ComGetEtcData(sXml, "avg_crane")); 		
									setObjValue("gross_work", 		ComGetEtcData(sXml, "gross_work")); 		
									setObjValue("net_work", 		ComGetEtcData(sXml, "net_work")); 		
									setObjValue("lost_time", 		ComGetEtcData(sXml, "lost_time")); 		
									setObjValue("gross_gang", 		ComGetEtcData(sXml, "gross_gang")); 		
									setObjValue("net_gang", 		ComGetEtcData(sXml, "net_gang")); 		
									setObjValue("hatch_handl", 		ComGetEtcData(sXml, "hatch_handl")); 	    
									setObjValue("gear_handl", 		ComGetEtcData(sXml, "gear_handl")); 		
									setObjValue("move_handl", 		ComGetEtcData(sXml, "move_handl")); 		
									setObjValue("tmnl_gross", 		ComGetEtcData(sXml, "tmnl_gross")); 		
									setObjValue("tmnl_net", 		ComGetEtcData(sXml, "tmnl_net")); 		
									setObjValue("per_gang_gross", 	ComGetEtcData(sXml, "per_gang_gross")); 	
									setObjValue("per_gan_net", 		ComGetEtcData(sXml, "per_gan_net")); 	    
								}
								SetWaitImageVisible(0);
								LoadSearchData(sXml,{Sync:1} );
								DataInsert(0);
								for(var idxRow=HeaderRows(); idxRow <= LastRow(); idxRow++){
									if(idxRow == HeaderRows()){
										SetCellValue(idxRow, prefix + "crane_desc","Terminal Working Time");
//										SetCellValue(idxRow, prefix + "work_comm",ComGetEtcData(sXml, "commence"));
//										SetCellValue(idxRow, prefix + "work_comp",ComGetEtcData(sXml, "complete"));
										SetCellValue(idxRow, prefix + "work_comm",ComGetEtcData(sXml, "commence").substring(0, 16),0);
										SetCellValue(idxRow, prefix + "work_comp",ComGetEtcData(sXml, "complete").substring(0, 16),0);
										
										SetCellEditable(idxRow, prefix + "work_comm",0);
										SetCellEditable(idxRow, prefix + "work_comp",0);
										SetCellEditable(idxRow, prefix + "break_down",0);
										SetCellEditable(idxRow, prefix + "meal",0);
										SetCellEditable(idxRow, prefix + "weather",0);
										SetCellEditable(idxRow, prefix + "other",0);
										SetCellEditable(idxRow, prefix + "total",0);
									}else{
										SetCellValue(idxRow, prefix + "crane_desc","1G/Crane");
										SetCellBackColor(idxRow, prefix + "work",titColor);
										
										////SetCellValue(idxRow, prefix + "work_comm",ComGetEtcData(sXml, "commence").substring(0, 16),0);
										////SetCellValue(idxRow, prefix + "work_comp",ComGetEtcData(sXml, "complete").substring(0, 16),0);										
									}
									SetCellBackColor(idxRow, prefix + "crane_desc",totColor);
									SetRowStatus(idxRow,"R");
								}
								beforeCraneCnt=RowCount()- 1;
							}
							break;
							
						case "Disch. Vol.":
							if(t3frame.beforeDistchVolTab == 0){
								formObj.f_cmd.value=SEARCH03;
								formObj.status1.value="LM";
								formObj.status2.value="";
							}else if(t3frame.beforeDistchVolTab == 1){
								formObj.f_cmd.value=SEARCH04;
								formObj.sc_status1.value="DS";
								formObj.sc_status2.value="DG";
								formObj.sc_status3.value="";
							}else if(t3frame.beforeDistchVolTab == 2){
								formObj.f_cmd.value=SEARCH05;
								formObj.sc_status1.value="DS";
								formObj.sc_status2.value="DG";
								formObj.sc_status3.value="";
							}
							if(multiSearchCheck){
								var sheetObj=t3frame.sheetObjCur(); //t3frame.document.all.item("t3sheet" + (t3frame.beforeDistchVolTab + 1));
								var prefix="t3sheet" + (t3frame.beforeDistchVolTab + 1) + "_"
								var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
								sheetObj.SetWaitImageVisible(0);
								sheetObj.LoadSearchData(sXml,{Sync:1} );
								if(t3frame.beforeDistchVolTab == 0){
									importDischTotal=false;
								}else if(t3frame.beforeDistchVolTab == 1){
									importDischSC=false;
								}else if(t3frame.beforeDistchVolTab == 2){
									importDischBB=false;
								}
							}else{
								doActionIBSheetMulti(tabIdx, formObj);
							}
							break;
							
						case "Load Vol.":
							if(t4frame.beforeLoadVolTab == 0){
								formObj.f_cmd.value=SEARCH06;
								formObj.status1.value="LM";
								formObj.status2.value="OT";
							}else if(t4frame.beforeLoadVolTab == 1){
								formObj.f_cmd.value=SEARCH06;
								formObj.status1.value="LI";
								formObj.status2.value="LT";
							}else if(t4frame.beforeLoadVolTab == 2){
								//if(document.form.sys_create.value.substring(0, 2) == "In"){
								
								//:2016-09-23://formObj.f_cmd.value=SEARCH04;
								formObj.f_cmd.value=SEARCH15;
								formObj.sc_status1.value="LS";
								formObj.sc_status2.value="ST";
								formObj.sc_status3.value="";
								
								//}else{
								//	formObj.f_cmd.value=SEARCH15;
								//	formObj.sc_status1.value="LS";
								//	formObj.sc_status2.value="ST";
								//}
							}else if(t4frame.beforeLoadVolTab == 3){
								formObj.f_cmd.value=SEARCH05;
								formObj.sc_status1.value="LS";
								formObj.sc_status2.value="";
								formObj.sc_status3.value="";
							}
							if(multiSearchCheck){
								var sheetObj=t4frame.sheetObjCur();  //t4frame.document.all.item("t4sheet" + (t3frame.beforeDistchVolTab + 1));
								var prefix="t4sheet" + (t4frame.beforeLoadVolTab + 1) + "_"
								var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
								sheetObj.SetWaitImageVisible(0);
								sheetObj.LoadSearchData(sXml,{Sync:0} );
								if(t4frame.beforeLoadVolTab == 0){
									importLoadTotalOc=false;
								}else if(t4frame.beforeLoadVolTab == 1){
									importLoadTotalIn=false;
								}else if(t4frame.beforeLoadVolTab == 2){
									importLoadSC=false;
								}else if(t4frame.beforeLoadVolTab == 3){
									importLoadBB=false;
								}
							}else{
								doActionIBSheetMulti(tabIdx, formObj);
							}
							break;
							
						case "COD":
							formObj.f_cmd.value=SEARCH07;
							var sheetObj=t5frame.t5sheet1;
							var prefix="t5sheet1_";
							var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
							sheetObj.SetWaitImageVisible(0);
							sheetObj.LoadSearchData(sXml,{Sync:0} );
							break;
							
						case "R/H":
							formObj.f_cmd.value=SEARCH08;
							var sheetObj=t6frame.t6sheet1;
							var prefix="t6sheet1_";
							var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
							sheetObj.SetWaitImageVisible(0);
							sheetObj.LoadSearchData(sXml,{Sync:0} );
							break;
							
						case "Mishandle":
							formObj.f_cmd.value=SEARCH09;
							var sheetObj=t7frame.t7sheet1;
							var prefix="t7sheet1_";
							var mishandlechk=formObj.misHandleChk.value;
                            var pParam=FormQueryString(formObj)+"&mishandlechk="+mishandlechk+"&"+ ComGetPrefixParam(prefix);
                            var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", pParam  );
							sheetObj.SetWaitImageVisible(0);
							sheetObj.LoadSearchData(sXml,{Sync:0} );
							filterMishandle(sheetObj, formObj.misHandleChk.value);
                            for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
                                if( !sheetObj.GetRowHidden(idxRow)  ){
                                    sheetObj.SetSelectRow(idxRow);
                                    break;
                                }                   
                            }
							break;
							
						case "Slot":
							if(t8frame.beforeSlotTab == 0){
								formObj.f_cmd.value=SEARCH10;
							}else if(t8frame.beforeSlotTab == 1){
								formObj.f_cmd.value=SEARCH11;
							}else if(t8frame.beforeSlotTab == 2){
								formObj.f_cmd.value=SEARCH12;
								formObj.sl_status1.value="OM";
								formObj.sl_status2.value="OI";
							}else if(t8frame.beforeSlotTab == 3){
								formObj.f_cmd.value=SEARCH14;
								formObj.sl_status1.value="SM";
								formObj.sl_status2.value="SI";
							}
							if(multiSearchCheck){
								var sheetObj=t8frame.sheetObjCur(); //document.all.item("t8sheet" + (t4frame.beforeSlotTab + 1));
								var prefix="t8sheet" + (t8frame.beforeSlotTab + 1) + "_";
								var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
								sheetObj.SetWaitImageVisible(0);
								sheetObj.LoadSearchData(sXml,{Sync:0} );
							}else{
								doActionIBSheetMulti(tabIdx, formObj);
							}
							break;
							
						case "Temp. STWG":
							formObj.f_cmd.value=SEARCH13;
							var sheetObj=t9frame.t9sheet1;
							var prefix="t9sheet1_";
							var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
							sheetObj.SetWaitImageVisible(0);
							sheetObj.LoadSearchData(sXml,{Sync:0} );
							break;
							
						case "Remark(s)":
							if(sheetTdrH.RowCount()> 0){
								document.form.tdr_info.value=sheetTdrH.GetCellValue(sheetTdrH.GetSelectRow(), "sheetTdrH_info");
							}
							break;
					}
					arrPreCond[0]=document.form.vsl_cd.value;
					arrPreCond[1]=document.form.skd_voy_no.value;
					arrPreCond[2]=document.form.skd_dir_cd.value;
//					arrPreCond[3]=document.form.yd_cd.GetSelectCode();
					arrPreCond[3]=document.form.yd_cd.value;
					multiSearchCheck=true;
				}
				break;
		}
	}
	function doActionIBSheetMulti(tabIdx, formObj){
		var multiSheet=new Array();
		var sXml="";
		if(marrTabTitle[tabIdx] == "Disch. Vol."){
			formObj.f_cmd.value=SEARCHLIST01;
			multiSheet[0]=t3frame.t3sheet1;
			multiSheet[1]=t3frame.t3sheet2;
			multiSheet[2]=t3frame.t3sheet3;
			var arrPrefix=new Array("t3sheet1_", "t3sheet2_", "t3sheet3_");
			sXml=multiSheet[0].GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
		}else if(marrTabTitle[tabIdx] == "Load Vol."){
			formObj.f_cmd.value=SEARCHLIST02;
			multiSheet[0]=t4frame.t4sheet1;
			multiSheet[1]=t4frame.t4sheet2;
			multiSheet[2]=t4frame.t4sheet3;
			multiSheet[3]=t4frame.t4sheet4;
			var arrPrefix=new Array("t4sheet1_", "t4sheet2_", "t4sheet3_", "t4sheet4_");
			sXml=multiSheet[0].GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
		}else if(marrTabTitle[tabIdx] == "Slot"){
			formObj.f_cmd.value=SEARCHLIST03;
			multiSheet[0]=t8frame.t8sheet1;
			multiSheet[1]=t8frame.t8sheet2;
			multiSheet[2]=t8frame.t8sheet3;
			multiSheet[3]=t8frame.t8sheet4;
			var arrPrefix=new Array("t8sheet1_", "t8sheet2_", "t8sheet3_", "t8sheet4_");
			sXml=multiSheet[0].GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
		}
		var arrXml=sXml.split(sheetSplit);
		for(var cnt=0; cnt < multiSheet.length; cnt++){
			multiSheet[cnt].LoadSearchData(arrXml[cnt],{Sync:0} );
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
				if(!ComChkObjValid(formObj.vsl_cd)){ 	
					return false;
				}
				if(!ComChkObjValid(formObj.skd_voy_no)){
					return false;
				}
				if(!ComChkObjValid(formObj.skd_dir_cd)){
					return false;
				}
				if(document.all.item("yd_cd").value== ""){
					ComShowCodeMessage("COM130404", "YARD");
					ComSetFocus(document.all.item("yd_cd"));
					return false;
				}
				return true;
				break;
			case IBSAVE:
				if(!ComChkObjValid(formObj.vsl_cd)) 	return false;
				if(!ComChkObjValid(formObj.skd_voy_no)) return false;
				if(!ComChkObjValid(formObj.skd_dir_cd)) return false;
				if(!ComChkObjValid(formObj.yd_cd)) return false;
				return true;
				break;
		}
	}
	function checkCondiChange(){
		if(arrPreCond[0] != document.form.vsl_cd.value)
			return true;
		if(arrPreCond[1] != document.form.skd_voy_no.value)
			return true;
		if(arrPreCond[2] != document.form.skd_dir_cd.value)
			return true;
		if(arrPreCond[3] != document.form.yd_cd.GetSelectCode())
			return true;
		return false;
	}
	/**
	 * start window control
	 */
	function vsl_cd_onchange(){
		if(bRetrive){
			resetFormNsheet(document.form.vsl_cd);
		}
	}
	function skd_voy_no_onchange(){
		if(bRetrive){
			resetFormNsheet(document.form.skd_voy_no);
		}
	}
	function skd_dir_cd_onchange(){
		var formObj = document.form;
		
		//VVD가 유효한지 체크
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH06;
 		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
		if(ComGetTotalRows(sXml) > 0) {
			setYardCombo(formObj);
			if(bRetrive){
				resetFormNsheet(formObj.skd_dir_cd);
			}
		}else {
			ComShowCodeMessage("COM132201", "VVD CD");
			initObjs("form", formObj, strVVDOptions, 0, "");
		}
	}

	function yd_cd_OnChange( comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
		
		if(comboObj.GetText(newindex, "2") != ""){
			ComShowCodeMessage('OPF50030', code + " [" + comboObj.GetText(newindex, "2") + "]");
			comboObj.SetSelectIndex("",false);
			document.form.yd_nm.value="";
			return;
		}
        var formObj=document.form;
        formObj.yd_nm.value=comboObj.GetText(code, 1);
		if(comboObjects[0].GetSelectCode()!= ""){
			document.form.yd_nm.value=comboObj.GetText(newindex, "1");
//			resetFormNsheet(document.form.port_cd);
		}else{
			return;
		}
        document.form.clpt_ind_seq.value=arrClptIndSeq[newindex];
        $("#yd_cd").val(code);
		formObj.f_cmd.value=SEARCH08;
		formObj.port_cd.value=formObj.yd_cd.value.substring(0, 5);
		var unKnownPortName="|XXXXX\tUnkown";
		var unKnownPortCode="|XXXXX";
		//"", "", 
		var arrPre=new Array("", "");
		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPre));
		var arrXml=sXml.split(sheetSplit);
		var arrCombo=ComXml2ComboString(arrXml[0], "val", "name");
		mPodCode=" |" + arrCombo[0] + unKnownPortCode;
		mPodName=" |" + arrCombo[1] + unKnownPortName;
		arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
		if(arrCombo != null){
			mLoadPodCode=" |" + arrCombo[0] + unKnownPortCode;
			mLoadPodName=" |" + arrCombo[1] + unKnownPortName;
		}
		var frame=document.getElementById("t4frame");
		if(frame.src != ""){
			t4frame.podComboInit();
		}
		var frame=document.getElementById("t5frame");
		if(frame.src != ""){
			t5frame.podComboInit();
		}
//		var frame=document.getElementById("t6frame");
//		if(frame.src != ""){
//			t6frame.podComboInit();
//		}
		var frame=document.getElementById("t7frame");
		if(frame.src != ""){
			t7frame.podComboInit();
		}
		var frame=document.getElementById("t9frame");
		if(frame.src != ""){
			t9frame.podComboInit();
		}
	}
	function hhMMCheck(objText){
		if(objText.value != ""){
			if(objText.value.indexOf(":") > -1){
				var arrTxt=objText.value.split(":");
				if(parseInt(arrTxt[1]) > 59){
					objText.value=( parseInt(arrTxt[1] / 60) + 
									  parseInt(arrTxt[0] == "" ? "0" : arrTxt[0]) 
						            ) + ":" + (arrTxt[1] % 60);
				}else if(arrTxt[0] == ""){
					objText.value="0" + objText.value;
				}
			}else{
				if(parseInt(objText.value) > 59){
					objText.value=parseInt(objText.value / 60) + ":" + (objText.value % 60);
				}else{
					objText.value="0:" + objText.value;
				}
			}
		}
	}
	function used_crane_onblur(){
		var sheetObj=t2sheet1;
		var prefix="t2sheet1_";
        var formObj=document.form;
		if(beforeCraneCnt < parseInt(document.form.used_crane.value)){		
			for(var crtRow=1; crtRow <= parseInt(document.form.used_crane.value) - beforeCraneCnt; crtRow++){
				var Row=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(Row, prefix + "work_comm",sheetObj.GetCellValue(1, prefix + "work_comm"));
				sheetObj.SetCellValue(Row, prefix + "work_comp",sheetObj.GetCellValue(1, prefix + "work_comp"));
				sheetObj.SetCellValue(Row, prefix + "break_down","000:00");
				sheetObj.SetCellValue(Row, prefix + "meal","000:00");
				sheetObj.SetCellValue(Row, prefix + "weather","000:00");
				sheetObj.SetCellValue(Row, prefix + "other","000:00");
				sheetObj.SetCellValue(Row, prefix + "total","000:00");
				sheetObj.SetCellBackColor(Row, prefix + "work",titColor);
				sheetObj.SetCellBackColor(Row, prefix + "crane_desc",totColor);
			}
		}else{
			for(var crtRow=1; crtRow <= beforeCraneCnt - parseInt(document.form.used_crane.value); crtRow++){
				sheetObj.RowDelete(sheetObj.LastRow(), false);
			}
		}
		beforeCraneCnt=parseInt(document.form.used_crane.value);
	}
	function tdr_info_onchange(){
		sheetTdrH.SetCellValue(sheetTdrH.GetSelectRow(), "sheetTdrH_info",document.form.tdr_info.value);
	}
	/**
	 * End window control
	 */
	/**
	 *	in case of retrieve TDR info
	 */
	function tdrHeaderSearch(formObj){
		var sheetObj=sheetTdrH;
		var prefix="sheetTdrH_";
		document.form.f_cmd.value=SEARCHLIST05;
		document.form.port_cd.value=document.form.yd_cd.value.substring(0, 5);
		document.form.voy_no.value=document.form.skd_voy_no.value;
		document.form.dir_cd.value=document.form.skd_dir_cd.value;
		var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheetTdrH_"));
		sheetObj.SetWaitImageVisible(0);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		if(sheetObj.RowCount()> 0){
				formReadonly(true);
			getTdrHeaderVal(formObj, sheetTdrH);
			opentScreen();
			for( var k=0; k < enableButton.length; k++){
				ComBtnEnable(enableButton[k]);
			}
			if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix + "exists_tml_dep_rpt_dtl") == "Y"){
                document.all("btn_ExcludefromTPR").style.color="#e41010";
            }else{
                document.all("btn_ExcludefromTPR").style.color="#514747";
            }
		}else{
			//ComShowCodeMessage('COM132201', "TDR"); 
            formObj.sys_create.value="Internally Produced";			
			formReadonly(true);
            document.all("btn_ExcludefromTPR").style.color="#514747";
			for( var k=0; k < enableButton.length; k++){
				ComBtnDisable(enableButton[k]);
			}
		}
	}
	function opentScreen(){
		bRetrive=true;
		for(var cnt=0; cnt < sheetObjects.length - 1; cnt++){
			sheetObjects[cnt].RemoveAll();
		}
	}
	function closeScreen(){
		bRetrive=false;
		for(var cnt=0; cnt < sheetObjects.length; cnt++){
			sheetObjects[cnt].RemoveAll();
		}
        document.all("btn_ExcludefromTPR").style.color="#514747";
		frameSheetRemove();
		formReadonly(true);
		bFirstTdrSearch=true;
	}
	function frameSheetRemove(){
		var frame=document.getElementById("t3frame");
		if(frame.src != ""){
			for(var idx=0; idx < t3frame.sheetObjects.length; idx++){
				t3frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t4frame");
		if(frame.src != ""){
			for(var idx=0; idx < t4frame.sheetObjects.length; idx++){
				t4frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t5frame");
		if(frame.src != ""){
			for(var idx=0; idx < t5frame.sheetObjects.length; idx++){
				t5frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t6frame");
		if(frame.src != ""){
			for(var idx=0; idx < t6frame.sheetObjects.length; idx++){
				t6frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t7frame");
		if(frame.src != ""){
			for(var idx=0; idx < t7frame.sheetObjects.length; idx++){
				t7frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t8frame");
		if(frame.src != ""){
			for(var idx=0; idx < t8frame.sheetObjects.length; idx++){
				t8frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t9frame");
		if(frame.src != ""){
			for(var idx=0; idx < t9frame.sheetObjects.length; idx++){
				t9frame.sheetObjects[idx].RemoveAll();
			}
		}
	}
	function resetFormNsheet(objText){
		var tmpMenu=new Array();
		var shearchCon=strVVDOptions.split("|");
		var tmpYdNm="";
		if(objText.name == "vsl_cd"){
			setObjValue("skd_voy_no", "");
			setObjValue("skd_dir_cd", "");
			setObjValue("yd_cd", "");
		}else if(objText.name == "skd_voy_no"){
			setObjValue("skd_dir_cd", "");
			setObjValue("yd_cd", "");
		}else{
			tmpYdNm=getObjValue("yd_nm");
		}
		for(var cnt=0; cnt < shearchCon.length; cnt++){
			tmpMenu[cnt]=getObjValue(shearchCon[cnt]);
		}
		document.form.reset();
		for(var cnt=0; cnt < shearchCon.length; cnt++){
			setObjValue(shearchCon[cnt], tmpMenu[cnt]);
		}
		if(tmpYdNm != "")
			setObjValue("yd_nm", tmpYdNm);
		closeScreen();
	}
	function clearSkdCondi(formObj, sheetObj){
		var prefix="sheetTdrH_";
		formObj.first_pilot_on.value="";		//	First Pilot On                        	//	PILOT_ARR    
		formObj.anchorage_arr.value="";		//	Anchorage                               //	ANCHOR_ARR   
		formObj.berth.value="";		//	Berth                                   //	BERTH        
		formObj.eta_next_port.value="";		//	ETA Next Port                           //	REMARK       
		formObj.eta_next_date.value="";		//	ETA Next Port                           //	REMARK       
		formObj.unberth.value="";		//	Unberth                                 //	UNBERTH      
		formObj.anchorage_dep.value="";		//	Anchorage                               //	ANCHOR_DEP   
		formObj.last_pilot_off.value="";		//	Last Pilot Off                          //	PILOT_DEP    
		formObj.eta_next_port.value="";		//	ETA Next Port                           //	REMARK       
		formObj.eta_next_date.value="";		//	ETA Next Port                           //	REMARK       
		formObj.arr_draft_fwd.value="";		//	Arrival Draft (CM) FWD                  //	DRAFT_FWD_ARR
		formObj.arr_draft_aft.value="";		//	Arrival Draft (CM) AFT                  //	DRAFT_AFT_ARR
		formObj.dep_draft_fwd.value="";		//	Departure Draft (CM) FWD                //	DRAFT_FWD_DEP
		formObj.dep_draft_aft.value="";		//	Departure Draft (CM) AFT                //	DRAFT_AFT_DEP
		formObj.arr_ballast.value="";		//	Arrival Ballast (MT)                    //	BALLAST_ARR  
		formObj.dep_ballast.value="";		//	Departure Ballast (MT)                  //	BALLAST_DEP  
		formObj.arr_rob_fo.value="";		//	Arrival ROB (MT) F.O                    //	ROB_FO_ARR   
		formObj.arr_rob_do.value="";		//	Arrival ROB (MT) D.O                    //	ROB_DO_ARR   
		formObj.arr_rob_fw.value="";		//	Arrival ROB (MT) F.W                    //	ROB_FW_ARR   
		formObj.dep_rob_fo.value="";		//	Departure ROB (MT) F.O                  //	ROB_FO_DEP   
		formObj.dep_rob_do.value="";		//	Departure ROB (MT) D.O                  //	ROB_DO_DEP   
		formObj.dep_rob_fw.value="";		//	Departure ROB (MT) F.W                  //	ROB_FW_DEP   
		formObj.arr_low_sul_fo.value="";		//	Arrival Low Sulphur (MT) F.O            //	             
		formObj.arr_low_sul_do.value="";		//	Arrival Low Sulphur (MT) D.O            //	             
		formObj.dep_low_sul_fo.value="";		//	Departure Low Sulphur (MT) F.O          //	             
		formObj.dep_low_sul_do.value="";		//	Departure Low Sulphur (MT) D.O          //	             
		formObj.dep_slp_fo.value="";		//	Departure Supply (MT) F.O               //	BUNKER_FO_ARR
		formObj.dep_slp_do.value="";		//	Departure Supply (MT) D.O               //	BUNKER_FO_DEP
		formObj.dep_slp_fw.value="";		//	Departure Supply (MT) F.W               //	BUNKER_FW_ARR
		formObj.dep_low_sul_fo_wgt.value="";		//	Departure Supply Low Sulphur (MT) F.O   //	BUNKER_FW_DEP
		formObj.dep_low_sul_do_wgt.value="";		//	Departure Supply Low Sulphur (MT)  D.O  //	BUNKER_DO_DEP
		formObj.arr_dwt.value="";		//	Arrival DWT/Displ. (MT)                 //	DWT_ARR      
		formObj.arr_displt.value="";		//	Departure DWT/Displ. (MT)               //	DWT_DEP      
		formObj.dep_dwt.value="";		//	 DWT/Displ. (MT)                        //	DWT_ARR      
		formObj.dep_displ.value="";		//	Departure DWT/Displ. (MT)               //	DWT_DEP      
		formObj.arr_gm.value="";		//	Arrival GM (CM)                         //	GM_ARR       
		formObj.dep_gm.value="";		//	Departure GM (CM)                       //	GM_DEP       
		formObj.arr_tugboat.value="";		//	Arrival Tugboat                         //	TUG_ARR      
		formObj.dep_tugboat.value="";		//	Departure Tugboat                       //	TUG_DEP      
		sheetCheckEdit[0].RemoveAll();
	}
	function getTdrHeaderVal(formObj, sheetObj){
		var prefix="sheetTdrH_";
		formObj.first_pilot_on.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "pilot_arr");					//	First Pilot On                        	//	PILOT_ARR
		formObj.anchorage_arr.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "anchor_arr");					//	Anchorage                               //	ANCHOR_ARR
		formObj.berth.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "berth");						//	Berth                                   //	BERTH
		formObj.eta_next_port.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "next_port");					//	ETA Next Port                           //	REMARK
		formObj.eta_next_date.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "next_port_dt");					//	ETA Next Port                           //	REMARK
		formObj.unberth.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "unberth");						//	Unberth                                 //	UNBERTH
		formObj.anchorage_dep.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "anchor_dep");					//	Anchorage                               //	ANCHOR_DEP
		formObj.last_pilot_off.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "pilot_dep");					//	Last Pilot Off                          //	PILOT_DEP
		formObj.eta_next_date.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "eta");							//	ETA Next Port                           //	REMARK
		formObj.eta_next_port.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "next_port");					//	ETA Next Port                           //	REMARK
		formObj.eta_canal.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "eta_canal");					//	ETA Next Canal                          //	REMARK
		formObj.next_canal.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "next_canal");					//	Next Canal								//	REMARK
		//formObj.arr_draft_fwd.value         =	ComAddComma(sheetObj.CellText(sheetObj.SelectRow, prefix + "draft_fwd_arr"));	//	Arrival Draft (CM) FWD                  //	DRAFT_FWD_ARR
        formObj.arr_draft_fwd.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "draft_fwd_arr" )) );  //  Arrival Draft (CM) FWD                  //  DRAFT_FWD_ARR
        formObj.arr_draft_aft.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "draft_aft_arr" )) ); //  Arrival Draft (CM) AFT                  //  DRAFT_AFT_ARR
        formObj.dep_draft_fwd.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "draft_fwd_dep" )) ); //  Departure Draft (CM) FWD                //  DRAFT_FWD_DEP
        formObj.dep_draft_aft.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "draft_aft_dep" )) ); //  Departure Draft (CM) AFT                //  DRAFT_AFT_DEP
        formObj.arr_ballast.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "ballast_arr"   )) );     //  Arrival Ballast (MT)                    //  BALLAST_ARR
        formObj.dep_ballast.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "ballast_dep"   )) );     //  Departure Ballast (MT)                  //  BALLAST_DEP
        formObj.arr_rob_fo.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_fo_arr"    )) );     //  Arrival ROB (MT) F.O                    //  ROB_FO_ARR
        formObj.arr_rob_do.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_do_arr"    )) );     //  Arrival ROB (MT) D.O                    //  ROB_DO_ARR
        formObj.arr_rob_fw.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_fw_arr"    )) );     //  Arrival ROB (MT) F.W                    //  ROB_FW_ARR
        formObj.dep_rob_fo.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_fo_dep"    )) );     //  Departure ROB (MT) F.O                  //  ROB_FO_DEP
        formObj.dep_rob_do.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_do_dep"    )) );     //  Departure ROB (MT) D.O                  //  ROB_DO_DEP
        formObj.dep_rob_fw.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_fw_dep"    )) );     //  Departure ROB (MT) F.W                  //  ROB_FW_DEP
        formObj.arr_low_sul_fo.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "sulphur_fo_arr")) );  // Arrival Low Sulphur (MT) F.O            //
        formObj.arr_low_sul_do.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "sulphur_do_arr")) );  // Arrival Low Sulphur (MT) D.O            //
        formObj.dep_low_sul_fo.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "sulphur_fo_dep")) );  // Departure Low Sulphur (MT) F.O          //
        formObj.dep_low_sul_do.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "sulphur_do_dep")) ); //  Departure Low Sulphur (MT) D.O          //
        formObj.dep_slp_fo.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "bunker_fo_dep") ));   //  Departure Supply (MT) F.O               //  BUNKER_FO_ARR
        formObj.dep_slp_do.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "bunker_do_dep") ));   //  Departure Supply (MT) D.O               //  BUNKER_FO_DEP
        formObj.dep_slp_fw.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "bunker_fw_dep") ));   //  Departure Supply (MT) F.W               //  BUNKER_FW_ARR
        formObj.dep_low_sul_fo_wgt.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "bunker_fw_dep") )); //  Departure Supply Low Sulphur (MT) F.O   //  BUNKER_FW_DEP
        formObj.dep_low_sul_do_wgt.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "bunker_do_dep") )); //  Departure Supply Low Sulphur (MT)  D.O  //  BUNKER_DO_DEP
        formObj.arr_dwt.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "dwt_arr")) );           //  Arrival DWT/Displ. (MT)                 //  DWT_ARR
        formObj.arr_displt.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "dwt_arr")) );           //  Departure DWT/Displ. (MT)               //  DWT_DEP
        formObj.dep_dwt.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "dwt_dep")) );           //   DWT/Displ. (MT)                        //  DWT_ARR
        formObj.dep_displ.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "dwt_dep")) );           //  Departure DWT/Displ. (MT)               //  DWT_DEP
        formObj.arr_gm.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "gm_arr" )) );           //  Arrival GM (CM)                         //  GM_ARR
        formObj.dep_gm.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "gm_dep" )) );           //  Departure GM (CM)                       //  GM_DEP
        formObj.arr_tugboat.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "tug_arr")) );           //  Arrival Tugboat                         //  TUG_ARR
        formObj.dep_tugboat.value=ComAddComma( tdr0Null( sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "tug_dep")) );           //  Departure Tugboat                       //  TUG_DEP
          //  Departure Tugboat                       //  TUG_DEP      
	}
	function setTdrHeaderVal(formObj, sheetObj){
		var prefix="sheetTdrH_";
		/*
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "next_port",formObj.eta_next_port.value);//	ETA Next Port                           //	REMARK
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "next_port_dt",formObj.eta_next_date.value);//	ETA Next Port                           //	REMARK
		*/
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "pilot_arr",formObj.first_pilot_on.value);//	First Pilot On                        	//	PILOT_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "anchor_arr",formObj.anchorage_arr.value);//	Anchorage                               //	ANCHOR_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "berth",formObj.berth.value);//	Berth                                   //	BERTH
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "unberth",formObj.unberth.value);//	Unberth                                 //	UNBERTH
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "anchor_dep",formObj.anchorage_dep.value);//	Anchorage                               //	ANCHOR_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "pilot_dep",formObj.last_pilot_off.value);//	Last Pilot Off                          //	PILOT_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "draft_fwd_arr",formObj.arr_draft_fwd.value);//	Arrival Draft (CM) FWD                  //	DRAFT_FWD_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "draft_aft_arr",formObj.arr_draft_aft.value);//	Arrival Draft (CM) AFT                  //	DRAFT_AFT_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "draft_fwd_dep",formObj.dep_draft_fwd.value);//	Departure Draft (CM) FWD                //	DRAFT_FWD_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "draft_aft_dep",formObj.dep_draft_aft.value);//	Departure Draft (CM) AFT                //	DRAFT_AFT_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "ballast_arr",formObj.arr_ballast.value);//	Arrival Ballast (MT)                    //	BALLAST_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "ballast_dep",formObj.dep_ballast.value);//	Departure Ballast (MT)                  //	BALLAST_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_fo_arr",formObj.arr_rob_fo.value);//	Arrival ROB (MT) F.O                    //	ROB_FO_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_do_arr",formObj.arr_rob_do.value);//	Arrival ROB (MT) D.O                    //	ROB_DO_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_fw_arr",formObj.arr_rob_fw.value);//	Arrival ROB (MT) F.W                    //	ROB_FW_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_fo_dep",formObj.dep_rob_fo.value);//	Departure ROB (MT) F.O                  //	ROB_FO_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_do_dep",formObj.dep_rob_do.value);//	Departure ROB (MT) D.O                  //	ROB_DO_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_fw_dep",formObj.dep_rob_fw.value);//	Departure ROB (MT) F.W                  //	ROB_FW_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "sulphur_fo_arr",formObj.arr_low_sul_fo.value);//	Arrival Low Sulphur (MT) F.O            //
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "sulphur_do_arr",formObj.arr_low_sul_do.value);//	Arrival Low Sulphur (MT) D.O            //
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "sulphur_fo_dep",formObj.dep_low_sul_fo.value);//	Departure Low Sulphur (MT) F.O          //
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "sulphur_do_dep",formObj.dep_low_sul_do.value);//	Departure Low Sulphur (MT) D.O          //
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "bunker_fo_arr",formObj.dep_slp_fo.value);//	Departure Supply (MT) F.O               //	BUNKER_FO_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "bunker_fo_dep",formObj.dep_slp_fo.value);//	Departure Supply (MT) D.O               //	BUNKER_FO_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "bunker_fw_arr",formObj.dep_slp_fw.value);//	Departure Supply (MT) F.W               //	BUNKER_FW_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "bunker_fw_dep",formObj.dep_low_sul_fo_wgt.value);//	Departure Supply Low Sulphur (MT) F.O   //	BUNKER_FW_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "bunker_do_dep",formObj.dep_low_sul_do_wgt.value);//	Departure Supply Low Sulphur (MT)  D.O  //	BUNKER_DO_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "dwt_arr",formObj.arr_dwt.value);//	Arrival DWT/Displ. (MT)                 //	DWT_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "dwt_arr",formObj.arr_displt.value);//	Departure DWT/Displ. (MT)               //	DWT_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "dwt_dep",formObj.dep_dwt.value);//	 DWT/Displ. (MT)                        //	DWT_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "dwt_dep",formObj.dep_displ.value);//	Departure DWT/Displ. (MT)               //	DWT_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gm_arr",formObj.arr_gm.value);//	Arrival GM (CM)                         //	GM_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gm_dep",formObj.dep_gm.value);//	Departure GM (CM)                       //	GM_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "tug_arr",formObj.arr_tugboat.value);//	Arrival Tugboat                         //	TUG_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "tug_dep",formObj.dep_tugboat.value);//	Departure Tugboat                       //	TUG_DEP
	}
	function setTdrHeaderVal2(formObj, sheetObj){
		var prefix="sheetTdrH_";
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gross_work",formObj.gross_work.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "net_work",formObj.net_work.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "lose_hr",formObj.lost_time.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gross_gang",formObj.gross_gang.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "net_gang",formObj.net_gang.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "hatch",formObj.hatch_handl.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "con",formObj.gear_handl.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "mvs",formObj.move_handl.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gross_tml",formObj.tmnl_gross.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "net_tml",formObj.tmnl_net.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gross_gc",formObj.per_gang_gross.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "net_gc",formObj.per_gan_net.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "commence",t2sheet1.GetCellValue(t2sheet1.HeaderRows(), "t2sheet1_work_comm"));//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "complete",t2sheet1.GetCellValue(t2sheet1.HeaderRows(), "t2sheet1_work_comp"));//	Departure Tugboat                       //	TUG_DEP
	}	
	function setCraneSheet(){
		var sheetObj=t2sheet1;
		sheetObj.SetRowStatus(sheetObj.HeaderRows(),"R");
		for(var idxRow=sheetObj.HeaderRows()+ 1; idxRow < sheetObj.LastRow(); idxRow++){
			sheetObj.SetRowStatus(idxRow,"I");
		}
	}
	function formReadonly(readonly){
		var frmObj=document.getElementsByTagName("form"); 
		var fObj=frmObj.item(0); 
		for( var k=0; k < enableButton.length; k++){
			if(readonly){
	            ComBtnDisable(enableButton[k]);
			}else{
                ComBtnEnable(enableButton[k]);
			}
		}
		for(var idxObj=0; idxObj < fObj.length; idxObj++){
//			var objText=fObj.item(idxObj);
			var objText=frmObj.item(0)[idxObj];
			if(objText.type == "text" && (	objText.name != "vsl_cd" && 
											objText.name != "skd_voy_no" && 
											objText.name != "skd_dir_cd" && 
											objText.name != "yd_nm" && 
											objText.name != "eta_next_port" && 
											objText.name != "eta_next_date")
			){
				objText.readOnly=readonly;
				//@@objText.className=(readonly ? "input2" : "input");
			}
		}
		for(var idx=0; idx < sheetObjects.length - 1; idx++)
			sheetObjects[idx].SetEditable((readonly ? 0 : 1));
		
//		comboObjects[0].readonly = false;
//		comboObjects[0].className = "input1";
//		initCombo(comboObjects[0], 1);
	} 
	function calenderCall(srcName){
		if(document.form.sys_create.value.substring(0, 2) == "In"){
			var objName=srcName.substring(4);
			var cal=new ComCalendar();
			cal.select(document.form.item(objName), 'yyyy-MM-dd');
			document.form.item(objName).value=document.form.item(objName).value;
		}
	}
	function fillZero(str){
		if(parseInt(str) < 10){
			str="0" + str;
		}
		return str;
	}
	function jshUseVal(formObj){
		formObj.vsl_cd.value="HJMU";
		formObj.skd_voy_no.value="0009";
		formObj.skd_dir_cd.value="E";
		searchVVDInfo();
		document.form.yd_cd.SetSelectCode("SGSINKA");
		//doActionIBSheet(beforetab, formObj, IBSEARCH);
	}
	/**
	 * End window control
	 */
	 /**
	  * Call BAck Start in case of clicking PopUp
	  */
	function setCallBackVSL(rtnObjs) {
		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("vsl_cd", rtnDatas[1]);
					obj_nextfocus(document.form.vsl_cd);
				}
			}
		}
	} 
	function setCallBackVVD(obj) {
		if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
				setObjValue("skd_voy_no", rtnDatas[2]);
				setObjValue("skd_dir_cd", rtnDatas[3]);
				}
			}
		}
		searchVVDInfo();
	} 
	function setCallBackPort(rtnObjs){
		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("eta_next_port", rtnDatas[3]);
				}
			}
		}
	}
	function filterMishandle(sheetObj, misHandleChk){
		for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
			if(sheetObj.GetCellValue(idxRow, "t7sheet1_mishandle_chk") == misHandleChk){
				sheetObj.SetRowHidden(idxRow,0);
			}else{
	            if( sheetObj.RowCount()!= 0 ){
				    sheetObj.SetRowHidden(idxRow,1);
	            }
			}
		}
	}
	function setCallBackOprCd(rtnObjs){
		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					popupSheet.SetCellValue(popupSheet.GetSelectRow(), popupPrefix + popupColNm,rtnDatas[3]);
				}
			}
		}
		mCheckValue=false;
	}
    function tdrRound(obj, posN){
        if (posN==undefined || posN==null ) posN=2;
        var rstFloat=ComRound(obj, posN);
        var strFloat=rstFloat + "";
        var flt="";
        if(strFloat.indexOf(".") == -1){
            for(var cnt=0; cnt < posN; cnt++){
                flt=flt + "0";
            }
            strFloat=strFloat + "." +  flt;
        }else{
            var arrFloat=strFloat.split(".");
            if(arrFloat[1].length < posN){
                for(var cnt=arrFloat[1].length; cnt < posN; cnt++){
                    flt=flt + "0";
                }
                strFloat=strFloat + flt;
            }
        }
        return strFloat;
    }
    function tdrRoundNull(obj, posN){
        if (posN==undefined || posN==null ) posN=2;
        if(obj == "" || obj == "0"){
            return "";
        }
        var rstFloat=ComRound(obj, posN);
        var strFloat=rstFloat + "";
        var flt="";
        if(strFloat.indexOf(".") == -1){
            for(var cnt=0; cnt < posN; cnt++){
                flt=flt + "0";
            }
            strFloat=strFloat + "." +  flt;
        }else{
            var arrFloat=strFloat.split(".");
            if(arrFloat[1].length < posN){
                for(var cnt=arrFloat[1].length; cnt < posN; cnt++){
                    flt=flt + "0";
                }
                strFloat=strFloat + flt;
            }
        }
        return strFloat;
    }
	/**
     * Screen New
	 */
	function tdrScreenNew(formObject, checkFlag){
		var changeSheet2=false;
		formObject.vsl_cd.value="";
		resetFormNsheet(formObject.vsl_cd);
		formObject.vsl_cd.focus();
		for( var k=0; k < enableButton.length; k++){
			ComBtnDisable(enableButton[k]);
		}
        document.all.btn_ExcludefromTPR.style.color="#514747";
	}
     function tdr0Null(obj){
         obj=ComReplaceStr(obj, ",","");
         if( eval( obj ) ==  0 )return "";
         return obj;
     }
	function setTabEditSheet(){
	}
	function frameButtonSheet(objFrame, readonly){
	}
	function readonlStatus(){
		return true;
	}
	/**
	 * @param objFrame
	 * @param subTabNo
	 */
	function frameButtonSheetSub(objFrame, subTabNo){
		gSubTabNo=subTabNo;
		var readOnly=true;
		readOnly=false;
		//Main Button Handing
		for( var k=0; k < enableButton.length; k++){
			if(readOnly){
				ComBtnDisable(enableButton[k]);
			}else{
				ComBtnEnable(enableButton[k]);
			}
		}
		//Button Enable
		for( var k=0; k < objFrame.enableButton.length; k++){
			if(readOnly){
				objFrame.ComBtnDisable(objFrame.enableButton[k]);
			}else{
				objFrame.ComBtnEnable(objFrame.enableButton[k]);
			}
		}
		for(var idx=0; idx < objFrame.sheetObjects.length; idx++){
			objFrame.sheetObjects[idx].SetEditable((readOnly ? 0 : 1));
		}
	}
	
	$(window).resize(function() {
 		if(this.resizeTO) {
 			clearTimeout(this.resizeTO);
 		}
 		this.resizeTO = setTimeout(function() {
 			$(this).trigger('resizeEnd');
 		}, 300);
    });
     
    $(window).on('resizeEnd', function() {
   	  iframeResize(true);
    });

    function iframeResize(onloadYn){     
    	/*if(beforetab == 1){
     		//  resizeSheet();
    		ComResizeSheet(sheetObjects[1]);
        }*/
   	  // 선택된 tab의 index를 통해서 iframe 이름을 구합니다.
   	  // beforetab은 tabIndex(현재 선택된 tab)이며 전역변수로 설정되어 있어서 booking의 경우 beforetab를 사용
   	  // 다른 화면도 유사한 코딩으로 되어있을 것으로 판단되며 그렇지 않은 경우는 지원요망.
   	  var ifrId = $('#'+selFrameId);      	  
   	  var height = $(window).height();
   	  var ifrOffset = $(ifrId).offset();
   	  var onloadYnIframe = false;
   	  if(onloadYn) {
   	   iframeMap.put(selFrameId, "Y");
   	  }
   	   
   	  onloadYnIframe = iframeMap.get(selFrameId);   	  
   	  //alert(beforetab);
   	  // 탭에서 Sheet Resizing을 원하는 것만 골라서 변경(ex. Tab 1,2,5,6)
   	  // 단, 해당 탭(Iframe에 해당하는 파일)에 updateSheetSize 라는 함수(공통)가 정의되어 있어야 합니다.
   	  if(beforetab == 2 || beforetab == 3 || beforetab == 4 || beforetab == 5 || beforetab == 6 || beforetab == 7 || beforetab == 8) {
	   	   $(ifrId).height(height - ifrOffset.top - iframeAddHeight);      	   
	   	   if(onloadYnIframe == "Y") {	   		   
	   		   $(ifrId)[0].contentWindow.updateSheetSize();	   		  	   		   
	   	   }
   	  }
    }
    
    /**
     * 2014.11.13 added function mai receiver delivery
     */
    function searchReceiveInfo(){
    	var formObj=document.form;
    	
    	formObj.f_cmd.value=SEARCH;
		
		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_0042GS.do", FormQueryString(formObj));
		var tmp = ComGetEtcData(sXml, "CNTC_PSON_EML_CTNT");
		//com_recipient
		formObj.com_recipient.value = tmp;
    }
	/* Developer performance  end */
