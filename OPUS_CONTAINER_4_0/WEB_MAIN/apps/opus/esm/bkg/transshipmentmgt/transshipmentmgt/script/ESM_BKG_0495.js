/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0495.js
*@FileTitle  : T/S List by 1st VSL & 2nd VSL T/S Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* developer's work*/
	// global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
//	var rdObjects=new Array();
	var rdCnt=0;
	var sheetCnt=0;
	var prefix1="t1sheet1_";
	var prefix2="t2sheet1_";
	var prefix3="t3sheet1_";
	var iterator="|$$|";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         var sheetObject3=sheetObjects[2];
         var sheetObject4=sheetObjects[3];
         var rdObject=viewer;
         /*******************************************************/
         var formObject=document.form;
         if (tabObjects[0].selectedIndex == 0) {
 			sheetObj=sheetObjects[0];
 		}
 		else if (tabObjects[0].selectedIndex == 1) {
 			sheetObj=sheetObjects[1];
 		}
         var param="";
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn_Retrieve":
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						if ( beforetab == 0 ) {	  //searching at the first tab
							//sheetObjects[1].RemoveAll();
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
						} else if ( beforetab == 1 ) {	//searching at the first tab
							//sheetObjects[0].RemoveAll();
							doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
						}   
					}
                	break;
            	case "btn_New":
					initForm();
				    ComClearObject(formObject.vps_etd_dt);
					ComClearObject(formObject.dur_from);
					ComClearObject(formObject.dur_to);
                	break; 
            	case "btn_DownExcel":
					if ( beforetab == 0 ) {	  //searching at the first tab
						doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
					} else if ( beforetab == 1 ) {	//searching at the first tab
						doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
					}  
                	break;
            	case "btn_Print":
            		if ( (beforetab == 0 && sheetObjects[0].RowCount() ==0)||(beforetab == 1 && sheetObjects[1].RowCount() ==0) ) {	  //searching at the first tab
						ComShowCodeMessage("BKG00155");
					}else{   
						if ( beforetab == 0 ) {	  
							if (CheckGrid(sheetObjects[0],prefix1)){ 
								param=RdParam(sheetObjects[0],prefix1);
								rdOpen(viewer, document.form,param );
							} 
						}else if ( beforetab == 1 ) {
							if (CheckGrid(sheetObjects[1],prefix2)){
								param=RdParam(sheetObjects[1],prefix2);
								rdOpen(viewer, document.form,param);
							}
						}
					}
                	break; 
            	case "btn_Fax":
					if (ComIsEmpty(formObject.faxmail)){
						return false;
					}
					if (ComIsEmailAddr(formObject.faxmail)||!ComIsContainsCharsOnly(formObject.faxmail,"1234567890-")){
						ComSetFocus(formObject.faxmail);
						ComShowCodeMessage("BKG00246");
						return false;
					}
					if ( (beforetab == 0 && sheetObjects[0].RowCount() ==0)||(beforetab == 1 && sheetObjects[1].RowCount() ==0) ) {	  //searching at the first tab
						ComShowCodeMessage("BKG00155");
					}else{  
						if ( beforetab == 0 ) {	   
							if (CheckGrid(sheetObjects[0],prefix1)){
								formObject.arrblno.value=CheckBlNo(sheetObjects[0],prefix1); 
								formObject.param.value=RdParam(sheetObjects[0],prefix1);
								var iCheckRow=sheetObjects[0].FindCheckedRow(prefix1+"chk");
								var arrRow=iCheckRow.split("|");
								formObject.rdtitle.value=sheetObjects[0].GetCellValue(arrRow[0],prefix1+"vs_nm")+" T/S Loading List";
								doActionIBSheet(sheetObjects[0],formObject,COMMAND02);
							}
						} else if ( beforetab == 1 ) {
							 if (CheckGrid(sheetObjects[1],prefix2)){
								 formObject.arrblno.value=CheckBlNo(sheetObjects[1],prefix2);
								 formObject.param.value=RdParam(sheetObjects[1],prefix2);
								 var iCheckRow=sheetObjects[1].FindCheckedRow(prefix2+"chk");
								 var arrRow=iCheckRow.split("|");
								 formObject.rdtitle.value=sheetObjects[1].GetCellValue(arrRow[0],prefix2+"vs_nm")+" T/S Loading List";
								 doActionIBSheet(sheetObjects[1],formObject,COMMAND02);
							 }
						} 
					}
					break;
            	case "btn_EMail": 
					if (ComIsEmpty(formObject.faxmail)){
						return false;
					}
					if (!ComIsEmailAddr(formObject.faxmail)){
						ComSetFocus(formObject.faxmail);
						ComShowCodeMessage("BKG00245");
						return false;
					}
					if ( (beforetab == 0 && sheetObjects[0].RowCount() ==0)||(beforetab == 1 && sheetObjects[1].RowCount() ==0) ) {	  //searching at the first tab
						ComShowCodeMessage("BKG00155");
					}else{ 
						if ( beforetab == 0 ) {
							if (CheckGrid(sheetObjects[0],prefix1)){
								formObject.arrblno.value=CheckBlNo(sheetObjects[0],prefix1); 
								formObject.param.value=RdParam(sheetObjects[0],prefix1);
								var iCheckRow=sheetObjects[0].FindCheckedRow(prefix1+"chk");
								var arrRow=iCheckRow.split("|");
                                //formObject.rdtitle.value = sheetObjects[0].CellValue(arrRow[0],prefix1+"vs_nm")+"T/S Loading List"; 
								doActionIBSheet(sheetObjects[0],formObject,COMMAND03);
							}
						} else if ( beforetab == 1 ) {
							if (CheckGrid(sheetObjects[1],prefix2)){
								formObject.arrblno.value=CheckBlNo(sheetObjects[1],prefix2);
								formObject.param.value=RdParam(sheetObjects[1],prefix2);
								var iCheckRow=sheetObjects[1].FindCheckedRow(prefix2+"chk");
								var arrRow=iCheckRow.split("|");
                                //formObject.rdtitle.value = sheetObjects[1].CellValue(arrRow[0],prefix2+"vs_nm")+"T/S Loading List"; 
								doActionIBSheet(sheetObjects[1],formObject,COMMAND03);
							}
						} 
					}
					break;
				case "btn_CheckAll":
					ComSetDisplay("btn_CheckAll",false);
					ComSetDisplay("btn_UnCheckAll",true);
					if ( beforetab == 0 ) {	  //searching at the first tab					     
						//CellCheckAll(sheetObjects[0],true,prefix1+"chk");
						for(iRow=sheetObjects[0].HeaderRows();iRow<sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount();iRow++){
							if(sheetObjects[0].GetCellProperty(iRow, prefix1+"chk", "Type")=="CheckBox"){
								sheetObjects[0].SetCellValue(iRow,prefix1+"chk",1);
							}
						}
					} else if ( beforetab == 1 ) {	//searching at the second tab
						//CellCheckAll(sheetObjects[1],true,prefix2+"chk");
						for(iRow=sheetObjects[1].HeaderRows();iRow<sheetObjects[1].HeaderRows()+sheetObjects[1].RowCount();iRow++){
							if(sheetObjects[1].GetCellProperty(iRow, prefix2+"chk", "Type")=="CheckBox"){
								sheetObjects[1].SetCellValue(iRow,prefix2+"chk",1);
							}
						}
					}  
					break;  
				case "btn_UnCheckAll":
					ComSetDisplay("btn_CheckAll",true);
					ComSetDisplay("btn_UnCheckAll",false);
					if ( beforetab == 0 ) {	  //searching at the first tab
						//CellCheckAll(sheetObjects[0],false,prefix1+"chk");
						for(iRow=sheetObjects[0].HeaderRows();iRow<sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount();iRow++){
							if(sheetObjects[0].GetCellProperty(iRow, prefix1+"chk", "Type")=="CheckBox"){
								sheetObjects[0].SetCellValue(iRow,prefix1+"chk",0);
							}
						}
					} else if ( beforetab == 1 ) {	//searching at the second tab 
						//CellCheckAll(sheetObjects[1],false,prefix2+"chk");
						for(iRow=sheetObjects[1].HeaderRows();iRow<sheetObjects[1].HeaderRows()+sheetObjects[1].RowCount();iRow++){
							if(sheetObjects[1].GetCellProperty(iRow, prefix2+"chk", "Type")=="CheckBox"){
								sheetObjects[1].SetCellValue(iRow,prefix2+"chk",0);
							}
						}
					}  
					break;  
				case "btn_calendar":
					var cal=new ComCalendar();
	                 cal.select(formObject.vps_etd_dt, 'yyyy-MM-dd');

				    break;
				case "btn_Ts_Summary": 
					var param="?loc_cd="+formObject.loc_cd.value+"&loc_yd_cd="+formObject.loc_yd_cd.value;
				    param+="&search_kind_cd="+ComGetObjValue(formObject.search_kind_cd)+"&disc_load_cd="+ComGetObjValue(formObject.disc_load_cd); 
					param+="&vps_etd_dt="+ComGetObjValue(formObject.vps_etd_dt)+"&vvd="+ComGetObjValue(formObject.vvd);
					param+="&pol_cd="+ComGetObjValue(formObject.pol_cd)+"&pod_cd="+ComGetObjValue(formObject.pod_cd);
					param+="&dur_from="+ComGetObjValue(formObject.dur_from)+"&dur_to="+ComGetObjValue(formObject.dur_to);
					param+="&op_cd="+ComGetObjValue(formObject.op_cd)+"&special="+ComGetObjValue(formObject.special);
					param+="&pgmNo=ESM_BKG_0925";					
					if(ComIsEmpty(formObject.loc_cd)){
						ComShowCodeMessage("BKG00757"); 
					}else if (((ComGetObjValue(formObject.search_kind_cd)=="E" || ComGetObjValue(formObject.search_kind_cd)=="A") && ComIsEmpty(formObject.vps_etd_dt))
						|| (ComGetObjValue(formObject.search_kind_cd)=="D" && (ComIsEmpty(formObject.dur_from)||ComIsEmpty(formObject.dur_to)))
						|| !formObject.search_kind_cd[0].checked && !formObject.search_kind_cd[1].checked && !formObject.search_kind_cd[2].checked){
						ComShowCodeMessage("BKG00758");
					}else{
						ComOpenWindowCenter("/opuscntr/ESM_BKG_0925.do"+param, "myWin", 750, 430, true);
					}
					break;
				case "btn_Duration":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.dur_from, formObject.dur_to,'yyyy-MM-dd');
					break;
				case "search_kind_cd":
					bkg0495_Click();
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**    
     * registering the created IBCombo Object at page as comboObjects list
     */
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
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
				//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
//		initRdConfig(rdObjects[0]);
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		 for(var j=0; j<comboObjects.length; j++){
			initCombo(comboObjects[j]);
			tabObjects[j].SetSelectedIndex(0);
		}   
		//axon_event.addListenerFormat('keypress','bkg0495_keypress',document.form);   
		axon_event.addListenerForm('Click', 'bkg0495_Click', document.form);
		axon_event.addListenerForm('blur', 'bkg0495_blur', document.form);
		axon_event.addListenerForm('beforedeactivate', 'bkg0495_obj_deactivate',  document.form); //- out of focus
	    axon_event.addListenerFormat('beforeactivate',   'bkg0495_obj_activate',    document.form); //- focus in
	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		initForm();
		doActionIBSheet(sheetObjects[0],document.form,COMMAND05);
    }
	/*
	*  handling Sheet loading
	*/
    function t1sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.SetWaitImageVisible(0);
		doActionIBSheet(sheetObj,document.form,COMMAND05);   
		sheetObj.SetWaitImageVisible(1);
		doActionIBSheet(sheetObj,document.form,COMMAND01); 
	}    
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
				with(sheetObj){
					var HeadTitle="|CHK|RMK|OOP|LANE|First VSL|ETB|LANE|ETD|Terminal|Next VSL|B/L No.|Container No.|TP|Seal No.|Origin Yard|POL|POD|POD|DEL|Weight|BS|Special|Auth Result|Load|Commodity|1|2|3|4|5|6|Cntr. Vol|20FT|40FT|POL|POD|DEL";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0} );
					
					var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"op_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"firstlane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"firstvvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"firstetb",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"nextlane",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"nextetd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"terminal",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"nextvvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_seal_No", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"org_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pod_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix1+"wgt",          KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix1+"bs_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"special",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"auth",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"stwg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix1+"cmdt_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ts_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"vs_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"tot_20",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"tot_40",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"tot_wgt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix1+"cntr_vol",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"teu",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"feu",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pol_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pod_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"del_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(395);
					SetEditable(1);
					SetShowButtonImage(2);
				}
                break;
			case 2:      //t2sheet1 init
				with(sheetObj){
					var HeadTitle="|CHK|RMK|OOP|LANE|First VSL|ETB|LANE|ETD|Terminal|Next VSL|B/L No.|Container No.|TP|Seal No.|Origin Yard|POL|POD|POD|DEL|Weight|BS|Special|Auth Result|Load|Commodity|1|2|3|4|5|6|Cntr. Vol|20FT|40FT|POL|POD|DEL";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
					
					var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"ibflag" },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"op_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"firstlane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"firstvvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"firstetb",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"nextlane",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"nextetd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"terminal",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"nextvvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cntr_seal_No", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"org_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pod_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"wgt",          KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"bs_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix2+"special",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"auth",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"stwg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix2+"cmdt_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ts_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"vs_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"tot_20",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"tot_40",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"tot_wgt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"cntr_vol",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"teu",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"feu",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pol_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pod_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"del_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(395);
					SetEditable(1);
					SetShowButtonImage(2);
				}
                break;
			case 3:      //t3sheet1 init
				with(sheetObj){
					var HeadTitle="|CHK|RMK|OOP|LANE|First VSL|ETB|LANE|ETD|Terminal|Next VSL|B/L No.|Container No.|TP|Seal No.|Origin Yard|POL|POD|POD|DEL|Weight|BS|Special|Auth Result|Load|Commodity|1|2|3|4|5|6|Cntr. Vol|20FT|40FT|POL|POD|DEL";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
					var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"ibflag" },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"op_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"firstlane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"firstvvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"firstetb",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"nextlane",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"nextetd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"terminal",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"nextvvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"cntr_seal_No", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"org_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"pod_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"wgt",          KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"bs_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix3+"special",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"auth",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"stwg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix3+"cmdt_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"ts_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"vs_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"tot_20",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"tot_40",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"tot_wgt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"cntr_vol",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"teu",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"feu",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"pol_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"pod_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"del_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(350);
					SetEditable(1);
					SetShowButtonImage(2);
				}
                break;
        }
    }
    var arrSXml ;
    //handling of Sheet 
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		var arrPreFix=sheetObj.id+"_"; 
        switch(sAction) {
           case IBSEARCH:        
				formObj.f_cmd.value=SEARCH;
           		if (ComIsEmpty(formObj.vvd)) {
           			ComSetObjValue(formObj.vvd,formObj.vvdList.textContent);
           		}
           		var sXml=sheetObj.GetSearchData("ESM_BKG_0495GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
				sheetObj.RenderSheet(0);
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				sheetObj.RenderSheet(1);
				ComSetObjValue(formObj.chkport,ComGetObjValue(formObj.loc_cd));
				setRmkBackColor(sheetObj,arrPreFix);
				arrSXml=sXml.split(iterator);
                break;
			case IBDOWNEXCEL:      
				var cnt=0;
				if(beforetab == 0 ){
					sheetObjects[2].LoadSearchData(ComReplaceStr(arrSXml[0],{Sync:0} ));
				}else{
					sheetObjects[2].LoadSearchData(ComReplaceStr(arrSXml[0],{Sync:0} ));
				}
				break;
			case COMMAND01:			//VVD Combo
				formObj.f_cmd.value=COMMAND01; 
				var sXml=sheetObj.GetSearchData("ESM_BKG_0495GS.do", FormQueryString(formObj));
				ComBkgXml2ComboItem(sXml,vvdList,"val", "name");
				//var arrVal= ComXml2ComboString(sXml, "val", "name");  
				//ComboList(arrVal);
				break;
			case COMMAND02:			//Fax
				formObj.f_cmd.value=COMMAND02; 
				var sXml=sheetObj.GetSearchData("ESM_BKG_0495GS.do", FormQueryString(formObj));
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				if(State == "S"){
					ComShowCodeMessage("BKG00496");
				}else{
					ComShowMessage(ComResultMessage(sXml));
				}
				break;
			case COMMAND03:			//Mail
				formObj.f_cmd.value=COMMAND03; 
				var sXml=sheetObj.GetSearchData("ESM_BKG_0495GS.do", FormQueryString(formObj));
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				if(State == "S"){
					ComShowCodeMessage("BKG00497");
				}else{
					ComShowMessage(ComResultMessage(sXml));
				}
				break;
			case COMMAND05:			//Relay Port
				formObj.f_cmd.value=COMMAND05; 
				var params=FormQueryString(formObj);  
				var sXml=sheetObj.GetSaveData("ESM_BKG_0495GS.do", params);
				ComSetObjValue(formObj.loc_cd,ComGetEtcData(sXml,"relayPort")); 
				//formObj.relay_port.value=ComGetEtcData(sXml,"relayPort");
            	//formObj.baseRelayPort.value=ComGetEtcData(sXml,"relayPort");
				break;
        }
    }
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/*
	* setting MultiCombo 
	*/
	function initCombo(comboObj) {
     	comboObj.SetMultiSelect(0);
     	comboObj.SetColAlign(0, "left");
     	comboObj.SetColAlign(1, "left");
     	comboObj.SetMultiSeparator("|");
    }
    /**
     * setting Tab 
     * setting item of Tab
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
                    InsertItem( "Discharging" , "");
                    InsertItem( "Loading" , "");
                }
             break;
         }
    }
    /**
     * Event when clicking Tab
     * activating selected tab items
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer"); 
	    	objs[nItem].style.display="Inline";
	    	objs[beforetab].style.display="none"; 
	    	//--------------- important --------------------------//
	    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
	    	//------------------------------------------------------//
	    	beforetab=nItem; 
			if (beforetab ==0){
				document.form.search_kind_cd[0].checked=true;
				setSearchKindCd(document.form);
				document.form.disc_load_cd.value="D"; 
				//CellCheckAll(sheetObjects[0],false,prefix1+"chk");
				for(iRow=sheetObjects[0].HeaderRows();iRow<sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount();iRow++){
					if(sheetObjects[0].GetCellProperty(iRow, prefix1+"chk", "Type")=="CheckBox"){
						sheetObjects[0].SetCellValue(iRow,prefix1+"chk",0);
					}
				}
			}else if (beforetab ==1){
				document.form.search_kind_cd[1].checked=true;
				setSearchKindCd(document.form);
				document.form.disc_load_cd.value="L";
				//CellCheckAll(sheetObjects[1],false,prefix2+"chk");
				for(iRow=sheetObjects[1].HeaderRows();iRow<sheetObjects[1].HeaderRows()+sheetObjects[1].RowCount();iRow++){
					if(sheetObjects[1].GetCellProperty(iRow, prefix2+"chk", "Type")=="CheckBox"){
						sheetObjects[1].SetCellValue(iRow,prefix2+"chk",0);
					}
				}
			}
			//sheetObjects[0].RemoveAll();
			//sheetObjects[1].RemoveAll();
			ComSetDisplay("btn_CheckAll",true);
			ComSetDisplay("btn_UnCheckAll",false);
    }
	// Event which is called after searching 
 	function t1sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
        var formObj=document.form;
        if(sheetObj.RowCount() <= 0){
        	formObj.tot_20_1.value = "";
        	formObj.tot_40_1.value = "";
        	formObj.tot_weight_1.value = "";
        }else{
	        formObj.tot_20_1.value=ComAddComma(sheetObj.GetCellValue(sheetObj.LastRow(), "t1sheet1_tot_20"));
	        formObj.tot_40_1.value=ComAddComma(sheetObj.GetCellValue(sheetObj.LastRow(), "t1sheet1_tot_40"));
	        formObj.tot_weight_1.value=ComAddComma(sheetObj.GetCellValue(sheetObj.LastRow(), "t1sheet1_tot_wgt"));
        }
        for( i = sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
        	if(sheetObj.GetCellValue(i , "t1sheet1_chk") == 0 || sheetObj.GetCellValue(i , "t1sheet1_chk") == 1){
        		sheetObj.InitCellProperty ( i , "t1sheet1_chk" , {Type:"CheckBox"});
        		sheetObj.InitCellProperty ( i , "t1sheet1_rmk" , {Type:"CheckBox"});
        	}else if(sheetObj.GetCellValue(i , "t1sheet1_chk") == "SUB TOTAL"){
        		sheetObj.SetCellAlign ( i , "t1sheet1_bl_no" , "Right");
        		sheetObj.SetCellAlign ( i , "t1sheet1_cntr_tpsz_cd" , "Right");
        	}
        	sheetObj.InitCellProperty ( i , "t1sheet1_wgt" , {Type:"Int", Format:"Integer"});
        }
    } 
    //Event which is called after searching
 	function t2sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
        var formObj=document.form;
        if(sheetObj.RowCount() <= 0){
        	formObj.tot_20_1.value = "";
        	formObj.tot_40_1.value = "";
        	formObj.tot_weight_1.value = "";
        }else{
			formObj.tot_20_2.value=ComAddComma(sheetObj.GetCellValue(sheetObj.LastRow(), "t2sheet1_tot_20"));
			formObj.tot_40_2.value=ComAddComma(sheetObj.GetCellValue(sheetObj.LastRow(), "t2sheet1_tot_40"));
			formObj.tot_weight_2.value=ComAddComma(sheetObj.GetCellValue(sheetObj.LastRow(), "t2sheet1_tot_wgt"));
        }
        for( i = sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
        	if(sheetObj.GetCellValue(i , "t2sheet1_chk") == 0 || sheetObj.GetCellValue(i , "t2sheet1_chk") == 1){
        		sheetObj.InitCellProperty ( i , "t2sheet1_chk" , {Type:"CheckBox"});
        		sheetObj.InitCellProperty ( i , "t2sheet1_rmk" , {Type:"CheckBox"});
        	}else if(sheetObj.GetCellValue(i , "t1sheet1_chk") == "SUB TOTAL"){
        		sheetObj.SetCellAlign ( i , "t2sheet1_bl_no" , "Right");
        		sheetObj.SetCellAlign ( i , "t2sheet1_cntr_tpsz_cd" , "Right");
        	}
        	sheetObj.InitCellProperty ( i , "t2sheet1_wgt" , {Type:"Int", Format:"Integer"});
        }
    } 
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
        	switch (sAction) {
	    		case IBSEARCH: {
					if(ComGetObjText(formObj.vvdList) == ""){
						formObj.vvd.value=""; 
						formObj.chkvvd.value="";
					}
					ComSetDisplay("btn_CheckAll",true);
					ComSetDisplay("btn_UnCheckAll",false);
					if(ComIsEmpty(formObj.loc_cd)){ 
						ComShowCodeMessage("BKG00757"); 
						return false;
					}else if ( !ComIsEmpty(formObj.vps_etd_dt) && ComGetObjText(formObj.vvdList) ==""  ){
						ComSetFocus(formObj.vvdList);
						ComShowCodeMessage("BKG00104","VVD"); 
						return false;						
					}else if (ComGetObjValue(formObj.search_kind_cd)=="D") {
						if (ComIsEmpty(formObj.dur_from)||ComIsEmpty(formObj.dur_to)) {
							if(ComIsEmpty(formObj.dur_from)) {
								ComSetFocus(formObj.dur_from);
							} else {
								ComSetFocus(formObj.dur_to);
							}
							ComShowCodeMessage("BKG00758"); 
							return false;
						} else if (ComGetDaysBetween(dur_from.value, dur_to.value) > 30) {
							ComShowCodeMessage("BKG00756", "Duration", "30Days");
							dur_from.focus();
							return false;
						}
					}else if ( (ComGetObjValue(formObj.search_kind_cd)!="D" && ComIsEmpty(formObj.vps_etd_dt))  ){
						ComSetFocus(formObj.vps_etd_dt);
						ComShowCodeMessage("BKG00758"); 
						return false;
					//}else if (ComChkLen(vvd,9)!=2){
						//ComShowCodeMessage("BKG00051",vvd.value);
					}
					break;
				}
        	}
        }
        return true;
    }
    function t1sheet1_OnChange(sheetObj,Row,Col,Value){ 
		CheckSame(sheetObj,Row,Col,Value,prefix1+"chk",prefix1+"bl_no");
	} 
	 function t1sheet2_OnChange(sheetObj,Row,Col,Value){ 
		CheckSame(sheetObj,Row,Col,Value,prefix2+"chk",prefix2+"bl_no");
	} 
	function t1sheet1_OnDblClick(sheetObj, Row,Col){
		with(sheetObj)
		{
			var formObject=document.form;
			var sName=ColSaveName(Col);
			if(sName == prefix1+"rmk"){
				var param="?bkg_no="+GetCellValue(Row,prefix1+"bkg_no");
				param+="&relay_port="+ComGetObjValue(formObject.loc_cd);
				param+="&pgmNo=ESM_BKG_0903";	
				ComOpenWindowCenter("/opuscntr/ESM_BKG_0903.do"+param, "myWin", 500,278, true); 
			}
		}
	}
	function t2sheet1_OnDblClick(sheetObj, Row,Col){
		with(sheetObj)
		{
			var formObject=document.form;
			var sName=ColSaveName(Col);
			if(sName == prefix2+"rmk"){
				var param="?bkg_no="+GetCellValue(Row,prefix2+"bkg_no");
				param+="&relay_port="+ComGetObjValue(formObject.loc_cd);
				param+="&pgmNo=ESM_BKG_0903";	
				var obj=ComOpenWindowCenter("/opuscntr/ESM_BKG_0903.do"+param, "myWin", 500,278, true); 
				if(obj=="T") { 
					CheckSame(sheetObj,Row,Col,1,prefix2+"rmk",prefix2+"bl_no");
					sheetObj.SetRowBackColor(Row,"#CCFFFC");
				}
			}
		}
	}
	/*
	 * handling KeyPress Event 
	 */
    function bkg0495_keypress(){
		obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat; 
	    switch(obj.dataformat){ 
	        case "num": 
	        	ComKeyOnlyNumber(ComGetEvent());
	            break;	 
			 case "engup": 
				 ComKeyOnlyAlphabet('uppernum'); 
	            break; 
	    }
	}
	/*
	* handling Change Event
	*/
	function bkg0495_blur(){
		obj=ComGetEvent(); 
		var formObject=document.form; 
	    switch(ComGetEvent("name")){ 
	        case "vps_etd_dt": 	        	
				if ((ComGetObjValue(formObject.search_kind_cd)=="E" || ComGetObjValue(formObject.search_kind_cd)=="A") && ComIsEmpty(formObject.vps_etd_dt)){
					//ComShowCodeMessage("BKG00758");
					//ComSetFocus(formObject.loc_cd);
				}else if ((ComGetObjValue(formObject.search_kind_cd)=="E" || ComGetObjValue(formObject.search_kind_cd)=="A") && ComChkLen(ComTrim(formObject.loc_cd),5)==2){
					doActionIBSheet(sheetObjects[0],formObject,COMMAND01); 
				} 
	            break;
			case "loc_cd":
				if (((ComGetObjValue(formObject.search_kind_cd)=="E" || ComGetObjValue(formObject.search_kind_cd)=="A") && ComIsEmpty(formObject.vps_etd_dt))||ComChkLen(ComTrim(formObject.loc_cd),5)!=2){
					//ComShowCodeMessage("BKG00461");
					//ComSetFocus(formObject.loc_cd);
				}else if (ComChkLen(ComTrim(formObject.loc_cd),5)==2){
					doActionIBSheet(sheetObjects[0],formObject,COMMAND01); 
				} 
				break;
			case "loc_yd_cd": 
				if (!ComIsEmpty(formObject.loc_yd_cd)&&ComChkLen(ComTrim(formObject.loc_yd_cd),2)!=2){
					ComShowCodeMessage("BKG00269",ComGetObjValue(formObject.loc_yd_cd));
					ComSetFocus(formObject.loc_yd_cd);
				}  
				break; 
	    }
	}
   /*
   * multi combo( onChange event )
   */
   function vvdList_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){//value,text) {
	   var form=document.form;
	   form.vvdList.value=NewText; 
	   form.vvd.value=NewText; 
	   form.chkvvd.value=NewText; 
   }
	/*
	* handling Click Event
	*/
	function bkg0495_Click(){
		obj=ComGetEvent(); 
		var formObject=document.form; 
		 if (obj.name =="search_kind_cd"){
		 	if (ComGetObjValue(formObject.search_kind_cd) =="A"){
		 			tabObjects[0].SetSelectedIndex(0);//document.tab1.SetSelectedIndex(0);
			 	}else if (ComGetObjValue(formObject.search_kind_cd) =="E"){
			 		tabObjects[0].SetSelectedIndex(1);//document.tab1.SetSelectedIndex(1);
			 	}
			 	setSearchKindCd(formObject);
	    }
	}
	function setSearchKindCd(formObject){
		 //ComEnableObject(formObject.vvd,true);
		if (ComGetObjValue(formObject.search_kind_cd) =="E" || ComGetObjValue(formObject.search_kind_cd) =="A"){
			if (ComGetObjValue(formObject.search_kind_cd) =="E"){
				ComSetObjValue(formObject.vps_dt_flag,"E");
			}else{
				ComSetObjValue(formObject.vps_dt_flag,"A");
			}
			ComClearObject(formObject.dur_from);
			ComClearObject(formObject.dur_to);
			if (ComIsEmpty(formObject.vps_etd_dt)){
				//ComShowCodeMessage("BKG00758");
				//ComSetFocus(formObject.vps_etd_dt);
			}else if (ComChkLen(ComTrim(formObject.loc_cd),5)!=2){
				ComShowCodeMessage("BKG00461");
				ComSetFocus(formObject.loc_cd);
			}else if (!ComIsEmpty(formObject.loc_yd_cd)&&ComChkLen(ComTrim(formObject.loc_yd_cd),1)!=2){
				ComShowCodeMessage("BKG00269");
					ComSetFocus(formObject.loc_yd_cd);
				}else{
					doActionIBSheet(sheetObjects[0],formObject,COMMAND01); 
				}
			 }else{
				 //formObject.vvdList.RemoveAll();
				 ComClearObject(formObject.vps_dt_flag);
				 ComClearObject(formObject.vps_etd_dt);
				 //ComEnableObject(formObject.vvd,false);
		 } 				
	}	
	/*
	* creating combo box by searching data for VVD
	*/
    function ComboList(arrVal){
		 if(typeof(arrVal)=="undefined") return;
		 var objCbo=document.getElementById("vvdList");
		 ComClearCombo(objCbo);		 
		 var arr_value=arrVal[0].split("|"); 
		 if (arr_value.length >0)
		 {
			 var opt=document.createElement("option"); 
			 var arr_text="";   
			 opt.setAttribute("value", "");  
			 opt.innerHTML=arr_text;  
			 objCbo.appendChild(opt);
			 for(var i=0; i <= arr_value.length-1; i++) {
				opt=document.createElement("option"); 
				arr_text=arr_value[i];   
				opt.setAttribute("value", arr_text);  
				opt.innerHTML=arr_text;  
				objCbo.appendChild(opt);
			 }
		 }else{
			 //var opt = document.createElement("option"); 
			 //var arr_text = "All";   
			 //opt.setAttribute("value", arr_text);  
			 //opt.innerHTML=arr_text;  
			 //objCbo.appendChild(opt);
		 }
	}
	/*
	 *  function which get Location information
	 */
	function getCOM_ENS_061(rowArray){
		var formObject=document.form;
		var colArray=rowArray[0]; 
		formObject.loc_cd.value=colArray[3].substring(0,5);
        formObject.loc_yd_cd.value=colArray[3].substring(5); 
	}
	/*
	* initializing Form 
	*/
	function initForm(){
		var formObject=document.form;
		 formObject.vps_etd_dt.value=ComGetNowInfo();
		 //formObject.dur_from.value=ComGetNowInfo();
		 //formObject.dur_to.value=ComGetNowInfo();
		 //ComClearObject(formObject.loc_cd);
		 ComClearObject(formObject.loc_yd_cd);
		 ComClearObject(formObject.search_kind_cd[0]);
		 ComClearObject(formObject.search_kind_cd[1]);
		 ComClearObject(formObject.search_kind_cd[2]);
		 ComSetObjValue(formObject.vps_dt_flag,"A");
		 //formObject.vvdList.RemoveAll();
		 //formObject.vvdList.SetSelectText("");
		 formObject.vvd.value="";
		 ComClearObject(formObject.op_cd);
		 ComClearObject(formObject.faxmail);
		 //sheetObjects[0].RemoveAll();
		 //sheetObjects[1].RemoveAll();
		 ComSetDisplay("btn_CheckAll",true);
		 ComSetDisplay("btn_UnCheckAll",false);
		 formObject.special[7].checked=true;
		 formObject.search_kind_cd[0].checked=true
	}
	/*
	*setting Rd 
		*/
//	function initRdConfig(rdObject){
//		var Rdviewer=rdObject;
//		Rdviewer.AutoAdjust=true;
//		Rdviewer.ViewShowMode(0); 
//		Rdviewer.IsShowDlg=0;
//		Rdviewer.SetBackgroundColor(128,128,128);
//		Rdviewer.ApplyLicense("0.0.0.0");
//		Rdviewer.SetPageLineColor(128,128,128);
//		Rdviewer.style.height = 0;
//	}
	function CheckGrid(sheetObject,prefix){
		//var iCheckRow=sheetObject.FindCheckedRow(prefix + "chk");
		var iCheckRow = 0;
		for(iRow=sheetObject.HeaderRows();iRow<sheetObject.HeaderRows()+sheetObject.RowCount();iRow++){
			if(sheetObject.GetCellProperty(iRow, prefix+"chk", "Type")=="CheckBox"){
				if(sheetObject.GetCellValue(iRow,prefix+"chk")==1){
					iCheckRow++;
				}
			}
		}
		if (iCheckRow <= 0) {
			ComShowCodeMessage("BKG00249");
			return false;
		}
		return true;
	}
	/*
	* Rd 
	*/
	function RdParam(sheetObject,prefix) { 
		var strResult=""; 
		var inStr="";
		//var title ="0";
		var vsNM="";
		var tabflag="";
		var iCheckRow=sheetObject.FindCheckedRow(prefix + "chk");
		var arrRow=iCheckRow.split("|"); 
		for (idx=0; idx<arrRow.length; idx++) {			
			if(sheetObject.GetCellValue(arrRow[idx],prefix+"chk")==1){
				if (inStr.length>1){
					//inStr+=","+"('"+sheetObject.CellValue(arrRow[idx],prefix+"bl_no").substring(0,10)+"','"+sheetObject.CellValue(arrRow[idx],prefix+"bl_no").substring(10,11)+"','"+sheetObject.CellValue(arrRow[idx],prefix+"bl_no").substring(11,12)+"')";
					inStr+=",'"+sheetObject.GetCellValue(arrRow[idx],prefix+"bl_no")+"'";
				}else{
					//inStr="('"+sheetObject.CellValue(arrRow[idx],prefix+"bl_no").substring(0,10)+"','"+sheetObject.CellValue(arrRow[idx],prefix+"bl_no").substring(10,11)+"','"+sheetObject.CellValue(arrRow[idx],prefix+"bl_no").substring(11,12)+"')";
					inStr="'"+sheetObject.GetCellValue(arrRow[idx],prefix+"bl_no")+"'";
				}
				/*if (idx ==0){
					vsNM=sheetObject.GetCellValue(arrRow[idx],prefix+"vs_nm");
				}
				if(vsNM !=sheetObject.GetCellValue(arrRow[idx],prefix+"vs_nm")){
					title="1";
				}*/
			}
		}
		if (document.form.disc_load_cd.value=="D"){
			tabflag="'D'";
		}else{
			tabflag="";
		}
		var strParam=tabflag+"~";
		if (ComIsNull(document.form.chkvvd)){
			strParam+="~";
		}else{
			strParam+="'"+ComGetObjValue(document.form.chkvvd)+"'"+"~";
		}
		if (ComIsNull(document.form.chkport)){
			strParam+="~";
		}else{
			strParam+="'"+ComGetObjValue(document.form.chkport)+"'"+"~";
		}
		if (ComIsNull(document.form.loc_yd_cd)){
			strParam+="~";
		}else{
			strParam+="'"+ComGetObjValue(document.form.loc_yd_cd)+"'"+"~";
		}
		strParam+=inStr;
		strResult=rdParamSet(strParam);	
		//ComDebug(strResult);
		//strResult= rdParamSet("'"+tabflag+"'"+"~"+"'"+ComGetObjValue(document.form.vvd)+"'"+"~"+"'"+ComGetObjValue(document.form.loc_cd)+"'"+"~"+"'"+ComGetObjValue(document.form.loc_yd_cd)+"'"+"~"+inStr);		 
		return strResult; 
	}
	/*
	*  oppen Rd 
	*/
	function rdOpen(viewer, formObject, param){
		var Rdviewer=viewer;
		// /rp [" + param + "] /riprnmargin /rprncenteropt [1] /rwait
		//var rdParam = "/rp [" + param + "] /riprnmargin /rwait";
		var rdParam="/rp " + param + " /riprnmargin /rwait";
		// setting RD file 
		var strPath=RD_path+"apps/opus/esm/bkg/transshipmentmgt/transshipmentmgt/report/ESM_BKG_0877.mrd";
		//ComDebug(rdParam + "\n\n" + strPath);
//		Rdviewer.openFile(strPath, RDServer + rdParam,{timeout:3000}); 
//		viewer.print({isServerSide:true});
		
		var appendReport = [];
		var mrdPath = RD_path+"apps/opus/esm/bkg/transshipmentmgt/transshipmentmgt/report/ESM_BKG_0877.mrd";
		var mrdParam = RDServer + rdParam;
		appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
		directReportDownload(appendReport);
	}
	/*
	* Bl/NO 
	*/
	function CheckBlNo(sheetObj,prefix){
		var inStr="";
		var blnoTmp="";
		for(i=0;i<sheetObj.RowCount();i++){ 
			if(sheetObj.GetCellValue(i,prefix+"chk")==1){
				if(blnoTmp !=sheetObj.GetCellValue(i,prefix+"bl_no")){
					inStr+=sheetObj.GetCellValue(i,prefix+"bl_no")+"|";
					blnoTmp=sheetObj.GetCellValue(i,prefix+"bl_no");
				}
			}
		}
		return inStr;
	}
	/*
	 * handling Activate Event 
	 */
	function bkg0495_obj_activate(){
			var formObject=document.form; 
    	// checking validation
    	switch(ComGetEvent("name")){
	    	case "vps_etd_dt":
	    		ComClearObject(form.dur_from);
	    		ComClearObject(form.dur_to);
					if (ComGetObjValue(formObject.search_kind_cd) =="D"){
						document.form.search_kind_cd[0].checked=true;
						document.tab1.SetSelectedIndex(0);
					 	setSearchKindCd(formObject);
			 		}
	    		ComClearSeparator(ComGetEvent());
    			break;
	    	case "dur_from":
	    		if (ComGetObjValue(formObject.search_kind_cd) !="D"){
						document.form.search_kind_cd[2].checked=true;
			 		}
	    		ComClearObject(form.vps_etd_dt);
	    		ComClearSeparator(ComGetEvent());
    			break; 
			case "dur_to":
					if (ComGetObjValue(formObject.search_kind_cd) !="D"){
						document.form.search_kind_cd[2].checked=true;
			 		}
	    		ComClearObject(form.vps_etd_dt);
	    		ComClearSeparator(ComGetEvent());
    			break; 
    		default:
    			break;
    	}
    }
	/*
	 * Deactivate Event 
	 */
    function bkg0495_obj_deactivate(){ 
    	switch(ComGetEvent("name")){ 
	    	case "vps_etd_dt":
	    		ComAddSeparator(ComGetEvent());
    			break;
	    	case "dur_from":
	    		ComAddSeparator(ComGetEvent());
    			break; 
			case "dur_to":
	    		ComAddSeparator(ComGetEvent());
    			break; 
    		default:
    			break; 
    	}
    }
	/*
	*  setting color of Remark cell 
	*/
	function setRmkBackColor(sheetObj,prefix){		
		var sRow=sheetObj.FindCheckedRow(prefix+"rmk");
		if(sRow.length==0) return;
		var arrRow=sRow.split("|");  
		for(var idx=0;idx<arrRow.length-1;idx++){  
			if (sheetObj.GetCellValue(arrRow[idx],prefix+"rmk")==1){
				sheetObj.SetRowBackColor(arrRow[idx],"#CCFFFC");
			} 
		}
	} 
	/*
	*  selecting all check box when CheckBox and DataType are together
	*/
/*function CellCheckAll(sheetObj,flag,prefix){
//no support[check again]CLT 		for(i=0;i<sheetObj.Rows;i++){ 
if(typeof(sheetObj.GetCellValue(i,prefix+"chk").length) =="undefined"
&& typeof(sheetObj.GetCellValue(i,prefix+"rmk").length) =="undefined"){
				if (flag){
					sheetObj.SetCellValue(i,prefix+"chk",1);
				}else{
					sheetObj.SetCellValue(i,prefix+"chk",0);
				}	 
			}
		}
	}*/
	
	
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var rowSkip="";
		for(var i=1;i<sheetObjects[2].RowCount();i++){
			if (typeof(sheetObjects[2].GetCellValue(i,prefix3+"chk").length) !="undefined"){
				if (i==sheetObjects[2].RowCount()-1){
					rowSkip+=i;
				}else{
					rowSkip+=i+"|";
				}
			}
		}
		sheetObjects[2].MoveColumnPos(prefix3+"op_cd"            ,1 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"firstlane"        ,2 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"firstvvd"         ,3 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"firstetb"         ,4 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"org_yd_cd"        ,5 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"nextlane"         ,6 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"nextvvd"          ,7 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"nextetd"          ,8 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"terminal"         ,9 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"bl_no"        	,10 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"cntr_no"         ,11 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"cntr_tpsz_cd"    ,12 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"cntr_seal_No"    ,13 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"pol_cd"          ,14 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"pol_nm"          ,15 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"pod_cd"          ,16 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"pod_nod_cd"      ,17 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"pod_nm"          ,18 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"del_cd"          ,19 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"del_nm"          ,20 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"wgt"             ,21 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"bs_cd"           ,22 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"special"         ,23 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"auth"            ,24 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"stwg_cd"         ,25 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"cmdt_nm"         ,26 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"cntr_vol"        ,27 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"teu"             ,28 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"feu"             ,29 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"chk"             ,30 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"rmk"             ,31 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"ts_rmk"          ,32 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"bkg_no"          ,33 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"vs_nm"           ,34 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"tot_20"          ,35 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"tot_40"          ,36 ,false);
		sheetObjects[2].MoveColumnPos(prefix3+"tot_wgt"         ,37 ,false);
		sheetObjects[2].Down2Excel({ HiddenColumn:1,TreeLevel:false});
	}
	/* the end of developer's work */
