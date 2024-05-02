/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0111.jsp
*@FileTitle  : Hanger Rack/Bar History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ees_mnr_0111 : business script for ees_mnr_0111.
     */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var uTpSz=new Array();
var gTpSz=new Array();
var zTpSz=new Array();
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
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_downexcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}
					break;
		        case "eq_no_multi":
                    rep_Multiful_inquiry("eq_list");
                    break;
				case "cre_dt_cal":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
					break;
				case "btns_search":	//Form Location. retrieving popup
					if(p_loc_tp.GetSelectCode()!= "ALL"){
						openPopup("1");
					}
 					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		MnrWaitControl(true);
		initControl()
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
		MnrOfficeLevel(currOfcCd,rhqOfcCd);
		setTpSzArray(sheetObjects[0]);
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
    /**
	 * setting combo basic info
	 * @param	{IBMultiCombo}	combo_obj	ComboObject.
	 * @param	{Number}	comboNo		ComboObject tag serial number
	 * adding case as numbers of counting combos
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboNo) {
	        case 1,2:
	           	with (comboObj) {
					SetColAlign(0, "left");
					SetColAlign(1, "left");
			   		SetDropHeight(160);
					SetUseAutoComplete(1);
		    	}
	        	break;
			case 3:
			    with (comboObj) {
					SetMultiSelect(1);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "130");
					SetDropHeight(200);
			    }
	        	break;
	       case 4:
			   with (comboObj) {
	    	   		SetColAlign(0, "left");
			   		SetDropHeight(160);
					SetUseAutoComplete(1);
		    	}
	        	break;
	       case 5:
			   with (comboObj) {
	    	   		SetColAlign(0, "left");
			   		SetDropHeight(160);
					SetUseAutoComplete(1);
		    	}
	        	break;
	       case 6:
			   with (comboObj) {
	    	   		SetColAlign(0, "left");
			   		SetDropHeight(160);
					SetUseAutoComplete(1);
		    	}
	        	break;
	       case 7:
			   with (comboObj) {
	    	   		SetColAlign(0, "left");
			   		SetDropHeight(160);
					SetUseAutoComplete(1);
		    	}
	        	break;
	     }
	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
              var HeadTitle1="|SEQ|EQ No.|TP/SZ|MVMT|Yard|Type|Amend Type|Hanger Rack Type|Hanger Bar Type|Tariff Type|Tariff Desc|Current\nBar Qty|Installation\nBar Qty|Collection Qty|Collection Qty|Missing Qty|Missing Qty|Related W/O|Flag DT|Remark";
              var HeadTitle2="|SEQ|EQ No.|TP/SZ|MVMT|Yard|Type|Amend Type|Hanger Rack Type|Hanger Bar Type|Tariff Type|Tariff Desc|Current\nBar Qty|Installation\nBar Qty|Sound|Repair|Missing|disposal|Related W/O|Flag DT|Remark";
              var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"eq_tpsz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mnr_flg_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"mnr_sts_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"mnr_flg_inp_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"mnr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"mnr_hngr_bar_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"mnr_hngr_trf_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"mnr_hngr_trf_otr_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"hngr_bar_ttl_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"hngr_bar_amd_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"act_invt_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"mnr_hngr_dmg_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_lost_hngr_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_disp_hngr_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wo_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mnr_flg_inp_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"mnr_flg_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
                    SetSelectionMode(smSelectionRow);
                    SelectHighLight=true;
                    SelectFontBold=false;
                    SelectBackColor="#NANNANNAN";
//                    SetSheetHeight(396);
                    resizeSheet( sheetObj );
              }


         break;
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
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject.
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
	/**
     * handling process sheet
     * @param	{IBSheet}	sheetObj	handling sheetObject
     * @param	{Form}		formObj		handling formObject
     * @param	{Number}	sAction		Action constants 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //retrieving
                if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id =="sheet1"){
						formObj.f_cmd.value=SEARCH;
						sheetObj.DoSearch("EES_MNR_0111GS.do",FormQueryString(formObj) );
					}
				}
                break;
			case IBCLEAR:        //initializing
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
				//initializing sheet
				for(i=0;i < sheetObjects.length;i++){
					sheetObjects[i].RemoveAll();
		        }
				//initializing combo
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].SetSelectCode("-1");
					comboObjects[i].RemoveAll();
				}
				//setting combo value
				var sCondition=new Array (
					//MULTICOMBO
					new Array("MnrGenCd","CD00061", "COMMON"),   //Location By
					new Array("MnrGenCd","","CUSTOM9"),		     //EQ_TYPE
					new Array("MnrGenCd","CD00093", "COMMON"),   //Search Bound Type
					//MULTICOMBO  + SHEETCOMBO
					new Array("MnrGenCd","CD00092", "COMMON"),   //Tariff Type
					new Array("MnrGenCd","CD00021", "COMMON"),   //Hanger Rack Type
					new Array("MnrGenCd","CD00022", "COMMON"),   //Hanger Bar Type
					new Array("MnrGenCd","CD00023", "COMMON")    //Amend Type
				)
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				//*** Location By
				var comboDefValue="";
				if(comboList[0] != null){
					p_loc_tp.InsertItem(0, 'ALL' ,'ALL');
					for(var j=1; j < comboList[0].length + 1;j++){
						var tempText=comboList[0][j - 1].split("|");
						p_loc_tp.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				p_loc_tp.SetSelectCode("ALL");
				//*** EQ_TYPE
				if(comboList[1] != null){
					eq_knd_cd.InsertItem(0, 'ALL' ,'ALL');
					for(var j=1; j < comboList[1].length + 1;j++){
						var tempText=comboList[1][j - 1].split("|");
						eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				eq_knd_cd.SetSelectCode('ALL');
				//*** Search Bound Type
				if(comboList[2] != null){
					bound_tp_cd.InsertItem(0, 'ALL' ,'ALL');
					for(var j=1; j < comboList[2].length + 1;j++){
						var tempText=comboList[2][j - 1].split("|");
						bound_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				bound_tp_cd.SetSelectCode("ALL");
				//*** Tariff Type
				if(comboList[3] != null){
					mnr_hngr_trf_cd.InsertItem(0, 'ALL' ,'ALL');
					for(var j=1; j < comboList[3].length + 1;j++){
						var tempText=comboList[3][j - 1].split("|");
						mnr_hngr_trf_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				mnr_hngr_trf_cd.SetSelectCode("ALL");
				//*** Hanger Rack Type
				if(comboList[4] != null){
					mnr_hngr_rck_cd.InsertItem(0, 'ALL' ,'ALL');
					for(var j=1; j < comboList[4].length + 1;j++){
						var tempText=comboList[4][j - 1].split("|");
						mnr_hngr_rck_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				mnr_hngr_rck_cd.SetSelectCode("ALL");
				//*** Hanger Bar Type
				if(comboList[5] != null){
					mnr_hngr_bar_tp_cd.InsertItem(0, 'ALL' ,'ALL');
					for(var j=1; j < comboList[5].length + 1;j++){
						var tempText=comboList[5][j - 1].split("|");
						mnr_hngr_bar_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				mnr_hngr_bar_tp_cd.SetSelectCode("ALL");
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboDefault=new Array();
				var comboSaveNames=new Array();
				comboSaveNames[0]="mnr_hngr_trf_cd";
				comboSaveNames[1]="mnr_hngr_rck_cd";
				comboSaveNames[2]="mnr_hngr_bar_tp_cd";
				comboSaveNames[3]="mnr_flg_inp_tp_cd";
				for(var i=3; i < comboList.length;i++){
				 	if(comboList[i] != null){
						sheetComboText="";
						sheetComboCode="";
						sheetComboDefault="";
				 		for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							if(j == 0){
								sheetComboDefault[i - 3]=tempText[0];
							}
						}
						sheetComboCode=MnrDelLastDelim(sheetComboCode);
				     	sheetComboText=MnrDelLastDelim(sheetComboText);
						sheetObjects[0].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);
					}
				}
				//setting default value
				formObj.eq_list.value="";
				formObj.from_date.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
				formObj.to_date.value=ComGetNowInfo();
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
                break;
			case IBDOWNEXCEL:
			    //sheetObj.Down2Excel(-1);
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol( sheetObj), SheetDesign:1,Merge:1 });
				break;
        }
    }
	 /**
     * handling process for input validation
     * @param	{IBSheet}	sheetObj	checking sheetObject
     * @param	{Form}		formObj		checking comboObject
     * @param	{Number}	sAction		Action constants 
     */
	function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSEARCH) {
				if (!ComChkValid(formObj)) return false;
				if (formObj.p_loc_cd.value == "" && formObj.eq_list.value == ""){
					ComShowCodeMessage("MNR00215");
					return false;
				}
			}
        }
		return true;
	}
   /**
    * handling process after ending sheet1 retrieve.
    * @param sheetObj
    * @param errMsg
    * @return
    */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	if(sheetObj.RowCount()>0){
	    	 for(i=sheetObj.LastRow(); i > 0 ; i--){
	    		 if(sheetObj.GetCellValue(i,  "mnr_hngr_flg")=="1"){
					sheetObj.SetCellEditable(i, "mnr_hngr_rck_cd",1);
					sheetObj.SetCellEditable(i, "hngr_bar_atch_knt",1);
					sheetObj.SetCellEditable(i, "mnr_hngr_bar_tp_cd",1);
					sheetObj.SetCellEditable(i, "mnr_hngr_flg_dt",1);
					sheetObj.SetCellBackColor(i, "mnr_hngr_rck_cd","#F0FFFF");
					sheetObj.SetCellBackColor(i, "hngr_bar_atch_knt","#F0FFFF");
					sheetObj.SetCellBackColor(i, "mnr_hngr_bar_tp_cd","#F0FFFF");
					sheetObj.SetCellBackColor(i, "mnr_hngr_flg_dt","#F0FFFF");
				}else{
					sheetObj.SetCellEditable(i, "mnr_hngr_rck_cd",0);
					sheetObj.SetCellEditable(i, "hngr_bar_atch_knt",0);
					sheetObj.SetCellEditable(i, "mnr_hngr_bar_tp_cd",0);
					sheetObj.SetCellEditable(i, "mnr_hngr_flg_dt",0);
					sheetObj.SetCellBackColor(i, "mnr_hngr_rck_cd","#FFFFFF");
					sheetObj.SetCellBackColor(i, "hngr_bar_atch_knt","#FFFFFF");
					sheetObj.SetCellBackColor(i, "mnr_hngr_bar_tp_cd","#FFFFFF");
					sheetObj.SetCellBackColor(i, "mnr_hngr_flg_dt","#FFFFFF");
				}
	    		 if(sheetObj.GetCellValue(i,  "mnr_hngr_rck_cd")=="O"){
					sheetObj.SetCellEditable(i, "mnr_hngr_flg",0);
					sheetObj.SetCellEditable(i, "mnr_hngr_rck_cd",0);
					sheetObj.SetCellBackColor(i, "mnr_hngr_flg","#FFFFFF");
					sheetObj.SetCellBackColor(i, "mnr_hngr_rck_cd","#FFFFFF");
				}
	    		 if(sheetObj.GetCellValue(i,  "hngr_bar_atch_knt")=="")	{
					sheetObj.SetCellValue(i,  "recent_hngr_bar_atch_knt","0",0);
				}else{
					sheetObj.SetCellValue(i,  "recent_hngr_bar_atch_knt",sheetObj.GetCellValue(i,  "hngr_bar_atch_knt"),0);
				}
			 sheetObj.SetCellValue(i, "bar_if_chk",1,0);
			 sheetObj.SetCellValue(i, "mnr_org_hngr_bar_tp_cd",sheetObj.GetCellValue(i, "mnr_hngr_bar_tp_cd") ,0);
			 sheetObj.SetRowStatus(i,"R");
	    	 }
		}
     }
   /**
    * handling AfterEdit event on sheet1.
    * @param sheetObj
    * @param Row
    * @param Col
    * @return
    */
	function sheet1_OnAfterEdit(sheetObj,Row, Col){
		if (sheetObj.ColSaveName(Col) == "hngr_bar_atch_knt"){
			if (sheetObj.GetCellValue(Row,  "hngr_bar_atch_knt")=="0"){
				ComShowCodeMessage("MNR00284");
				sheetObjects[0].SetCellValue(Row,  "mnr_hngr_bar_tp_cd","",0);
			}
		}
		if (sheetObj.ColSaveName(Col) == "mnr_hngr_rck_cd"){
			if(sheetObj.GetCellValue(Row,  "mnr_hngr_rck_cd")=="O"){
				ComShowCodeMessage("MNR00331");
				sheetObjects[0].SetCellValue(Row,  "mnr_hngr_rck_cd","R",0);
			}
		}
	}
	/**
	 * eq_knd_cd Change event
	 * @param	{IBMultiCombo}		comboObj	comboObject
	 * @param 	{Number} 			Index_Code 	selected row
	 * @param 	{String} 			Text 		selected Text
	 */
	function eq_knd_cd_OnChange(comboObj,Index_Code, Text){
		var formObj=document.form;
		var comboValue=comboObj.GetSelectCode();
		eq_tpsz_cd.RemoveAll();
		var selTpSz=new Array();
		if(comboValue == "ALL"){
			eq_tpsz_cd.SetEnable(0);
		} else {
			eq_tpsz_cd.SetEnable(1);
			if(comboValue == "U"){
				selTpSz=uTpSz;
			} else if(comboValue == "G"){
				selTpSz=gTpSz;
			} else {
				selTpSz=zTpSz;
			}
			//setting default 'ALL'
			eq_tpsz_cd.InsertItem(0,"ALL","ALL");
			for(var i=1;i < (selTpSz.length + 1);i++){
				eq_tpsz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]);
			}
		}
	}
	/**
	 * p_loc_tp Change event
	 * @param	{IBMultiCombo}		comboObj	comboObject
	 * @param 	{Number} 			Index_Code 	selected row
	 * @param 	{String} 			Text 		selected Text
	 */
	function p_loc_tp_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){
		var formObj=document.form;
		formObj.p_loc_cd.value="";
		document.all["p_loc_cd"].maxLength = "5";
		if(newtext == "ALL") {
			MnrFormSetReadOnly(formObj,true,"p_loc_cd");
		} else {
			if(newtext == "Yard") {
				document.all["p_loc_cd"].maxLength = "7";
			}
			MnrFormSetReadOnly(formObj,false,"p_loc_cd");
			ComSetFocus(formObj.p_loc_cd);
		}
	}
	//eq_tpsz_cd multicombo click event
	function eq_tpsz_cd_OnCheckClick(comboObj, index, code) {
		MnrAllChkMultiCombo(comboObj,index);
	}
	function setTpSzArray(sheetObj){
		var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind");
		if(arrXml != null){
		    for(var i=0; i < arrXml.length; i++){
				if(i == 0){
					uTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 1){
					zTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 2){
					gTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				}
		    }
		}
	}
	/**
	 * getting rep_Multiful_inquiry
	 * 
	 * Location : in case of Single choice
	 */
	function getMnr_Multi(rowArray,ret_val) {
		var formObj=document.form;
		var tempText="";
		//initializing
		formObj.eq_list.value='';
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//clearing comma(,)
		tempText=MnrDelLastDelim(tempText);
		tempText=tempText.toUpperCase();
		eval("document.form." + ret_val + ".value='" + tempText + "';");
	}
	/**
     * Pop-up Open<br>
     * @param type 1:Location Code, 2:Currency Code
     * @param Row IBSheet Row index
     * @param Col IBSheet Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		switch(p_loc_tp.GetSelectCode()) {
    			case "RCC" :	//RCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 610,"rcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "LCC" :	//LCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 610,"lcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "SCC" :	//SCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 610,"scc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}
    	}
    	return;
    }
	//Axon handling event1. event catch
	function initControl() {
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  	
//	    axon_event.addListenerFormat('focus',   'obj_activate',    form);           
//	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);          
		axon_event.addListenerFormat('change',	 'obj_change',	form); 				
	}
	//Axon handling event. activatehandling event
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	//Axon handling event. deactivatehandling event
	function obj_deactivate(){
	    ComChkObjValid(ComGetEvent());
	}
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
				//do nothing
			}
	    }
	}
	//Axon handling event. keypresshandling event
	function obj_keypress(){
	    obj=ComGetEvent();
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
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
	         	if(obj.name == "eq_list"){
					ComKeyOnlyAlphabet('uppernum','44');
				} else {
					ComKeyOnlyAlphabet('uppernum');
				}
	            break;
	    }
	}
	/* developer job */
