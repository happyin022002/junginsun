/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_5001.js
*@FileTitle  : MTY Balance Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
/**
 * @extends 
 * @class EES_EQR_5001 : business script for EES_EQR_5001
 */
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var IBSEARCH01=29;
    var IBSEARCH02=30;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var HeadTitleCnt=0;
    var yyyyMm="";
    var focFlag1=true;	//for handling scroll
    var focFlag2=true;
    var mainXml="";
    
    var strHidTpSz = "";
	
	var hidD2YN = 0;
    var hidD4YN = 0;
    var hidD5YN = 0;
    var hidD7YN = 0;
    var hidR2YN = 0;
    var hidR5YN = 0;
    var hidO2YN = 0;
    var hidS2YN = 0;
    var hidO4YN = 0;
    var hidS4YN = 0;
    var hidF2YN = 0;
    var hidA2YN = 0;
    var hidF4YN = 0;
    var hidA4YN = 0;
    var hidF5YN = 0;
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var shtCnt=0;
    	var sheet1=sheetObjects[shtCnt];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
			case "btn_new":		
				formObject.reset();
				viewFlag_chk(sheetObjects[0])		  //in case of checking DRY,SPLC(RF, OT, FR), ALL, defining handling event
				viewFlag_chk(sheetObjects[1])		  //in case of checking DRY,SPLC(RF, OT, FR), ALL, defining handling event
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				document.form.init_flag.value="INIT";
	            InitHeadColumn(leftHeader1, sheetObjects[0]);
	            InitHeadColumn(rightHeader1, sheetObjects[1]);
				ComSetFocus(document.form.loc_cd);
				break;
    		case "btn_Retrieve":
    			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    			break;
    		case "btn_save":
    			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
    			break;
    		case "btn_downExcel":
    			sheetObjects[0].DataMove(sheetObjects[0].LastRow()+1, 9);
    			sheetObjects[0].DataMove(sheetObjects[0].LastRow()+1, 4);
    			sheetObjects[0].Down2ExcelBuffer(1);
    			sheetObjects[0].Down2Excel({FileName:"excel",HiddenColumn:0,Merge:true,TreeLevel:false});
	            if(sheetObjects[1].RowCount()> 0){
	    			sheetObjects[1].Down2Excel({FileName:"excel",HiddenColumn:1,Merge:true,TreeLevel:false});
	            }
	            sheetObjects[0].Down2ExcelBuffer(0);
    			sheetObjects[0].DataMove(4, sheetObjects[0].LastRow());
    			sheetObjects[0].DataMove(9, sheetObjects[0].LastRow());
    			break;
			case "btn_loc_cd":	//calling pop-up for retrieving for Location
				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "ecc_cd:loc_cd", "1,0,1,1,1,1,1,1", true);
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
     * sheet2 when clicked handling event
     */
    function sheet2_OnClick(sheetObj, row, col, value) {
    	var formObject=document.form;
    	if ( document.form.init_flag.value != 'INIT' ) {
	    	if ( sheetObj.ColSaveName(col) == "title" || sheetObj.ColSaveName(col) == "item" ) {
	    		if ( row == 1  ) {
	        		document.form.search_flag.value="1";
	        		doActionIBSheet(sheetObj,formObject,IBSEARCH01);
	    		} else if ( row == 3 ) {
	        		document.form.search_flag.value="2";
	        		doActionIBSheet(sheetObj,formObject,IBSEARCH01);
	    		} else if ( row == 10 ) {
	        		document.form.search_flag.value="3";
	        		doActionIBSheet(sheetObj,formObject,IBSEARCH01);
	    		}
	    	}
    	}
    }
    /**
     * registering initial event 
     */
    function initControl() {
//     	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');							//handling keyup event at LOC_CD 
//     	axon_event.addListener('keyup', 'from_bse_dt_onkeyUp', 'from_bse_dt');					//from_bse_dt keyup handling event
     	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 					//handling activate event
     	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 				//handling deactivate event
//     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');								//handling enter key press event
     	axon_event.addListenerForm('click', 'viewFlag_click', form);							//in case of checking DRY,SPLC(RF, OT, FR), ALL, defining handling event
     	axon_event.addListener('blur', 'obj_blur', 'loc_cd');									//Location  blur handling event
//     	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);						//only upper case, numbers
    }    

	/**
	 * handling blur event
	 */	
	function obj_blur() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
	}
	
	
    /**
     * in case of checking DRY,SPLC(RF, OT, FR), ALL, defining handling event     
     */
    function viewFlag_click(sheetObj) {
		switch (ComGetEvent("name")) {
		case "viewFlag":
			if ( document.form.viewFlag[0].checked ) {
				sheetObjects[0].SelectCell(0, "d2_fcast_qty", true);
				sheetObjects[1].SelectCell(0, "d2_fcast_qty", true);
				//sheetObjects[0].FrozenCols=2;
				//sheetObjects[1].FrozenCols=2;
				setCellHidden(sheetObjects[0],false,true);
				setCellHidden(sheetObjects[1],false,true);
			} else if ( document.form.viewFlag[1].checked ) {
				sheetObjects[0].SelectCell(0, "r2_fcast_qty", true);
				sheetObjects[1].SelectCell(0, "r2_fcast_qty", true);
				//sheetObjects[0].FrozenCols=7;
				//sheetObjects[1].FrozenCols=7;
				setCellHidden(sheetObjects[0],true,false);
				setCellHidden(sheetObjects[1],true,false);
			} else if ( document.form.viewFlag[2].checked ) {
				sheetObjects[0].SelectCell(0, "d2_fcast_qty", true);
				sheetObjects[1].SelectCell(0, "d2_fcast_qty", true);
				//sheetObjects[0].FrozenCols=1;
				//sheetObjects[1].FrozenCols=1;
				setCellHidden(sheetObjects[0],false,false);
				setCellHidden(sheetObjects[1],false,false);
			}
			break;
		}
    }
    
    
    /**
     * in case of checking DRY,SPLC(RF, OT, FR), ALL, defining handling event     
     */
    function viewFlag_chk(sheetObj) {
		if ( document.form.viewFlag[0].checked ) {
			setCellHidden(sheetObj,false,true);
		} else if ( document.form.viewFlag[1].checked ) {
			setCellHidden(sheetObj,true,false);
		} else if ( document.form.viewFlag[2].checked ) {
			setCellHidden(sheetObj,false,false);
		}
    }
    
    
    /**
     * checking flag
     */    
    function chkFlag_chk(sheetObj) {
		if ( document.form.viewFlag[0].checked ) {
			return  "DRY";
		} else if ( document.form.viewFlag[1].checked ) {
			return  "SPCL";
		} else if ( document.form.viewFlag[2].checked ) {
			return  "ALL";
		}
    }
    
    
    /**
     * 관리대상 EQ TP/SZ를 결정
     */
    function setCellHidden(sheetObj,showFlag1,showFlag2) {
    	sheetObj.RenderSheet(0);
    	if ( showFlag1==false && showFlag2==false ) {
    		sheetObj.SetColHidden("g_total",0);
    		sheetObj.SetColWidth("d7_fcast_qty", 65);
    	} else {
    		sheetObj.SetColHidden("g_total",1);
    	}
		if ( showFlag1==false && showFlag2==false ) {
			sheetObj.SetColHidden("d_total",1);
		} else {
			sheetObj.SetColHidden("d_total",showFlag1);
		}
		sheetObj.SetColHidden("d2_fcast_qty",showFlag1);
		sheetObj.SetColHidden("d4_fcast_qty",showFlag1);
		sheetObj.SetColHidden("d5_fcast_qty",showFlag1);
		sheetObj.SetColHidden("d7_fcast_qty",showFlag1);
		if ( showFlag1==false && showFlag2==false ) {
			sheetObj.SetColHidden("s_total",1);
		} else {
			sheetObj.SetColHidden("s_total",showFlag2);
		}
		sheetObj.SetColHidden("r2_fcast_qty",showFlag2);
		sheetObj.SetColHidden("r5_fcast_qty",showFlag2);
		sheetObj.SetColHidden("o2_fcast_qty",showFlag2);
		sheetObj.SetColHidden("s2_fcast_qty",showFlag2);
		sheetObj.SetColHidden("o4_fcast_qty",showFlag2);
		sheetObj.SetColHidden("s4_fcast_qty",showFlag2);
		sheetObj.SetColHidden("f2_fcast_qty",showFlag2);
		sheetObj.SetColHidden("a2_fcast_qty",showFlag2);
		sheetObj.SetColHidden("f4_fcast_qty",showFlag2);
		sheetObj.SetColHidden("a4_fcast_qty",showFlag2);
		sheetObj.SetColHidden("f5_fcast_qty",showFlag2);
    	sheetObj.RenderSheet(1);
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
     * handling keyup event on LOC_CD
     * upper case 
     */
	function loc_cd_onkeyUp() {
		var formObject=document.form;
		document.getElementById("loc_cd").setAttribute("maxLength",5);
		if ( formObject.loc_cd.value.length == 5 ) { 
			if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
				ComSetFocus(document.form.fcast_yrwk);
			}
		}
	}
    /**
     * handling beforeactivate event on Balance Report ID
     */    
	function obj_activate() {
		ComClearseparator(ComGetEvent());
	}
	/**
	 * handling beforedeactivate event on Balance Report ID
	 */	
	function obj_deactivate() {
		ComClearseparator(ComGetEvent());
		obj=ComGetEvent();
		if (obj.name == "fcast_yrwk") {
			if ( document.form.fcast_yrwk.value !='' ) {
				ComAddseparator(ComGetEvent());
			}
		}
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		
		strHidTpSz = hidtpszallCode;
    	
    	if(strHidTpSz.indexOf("D2") > -1) { hidD2YN = 1; }
	    if(strHidTpSz.indexOf("D4") > -1) { hidD4YN = 1; }
	    if(strHidTpSz.indexOf("D5") > -1) { hidD5YN = 1; }
	    if(strHidTpSz.indexOf("D7") > -1) { hidD7YN = 1; }
	    if(strHidTpSz.indexOf("R2") > -1) { hidR2YN = 1; }
	    if(strHidTpSz.indexOf("R5") > -1) { hidR5YN = 1; }
	    if(strHidTpSz.indexOf("O2") > -1) { hidO2YN = 1; }
	    if(strHidTpSz.indexOf("S2") > -1) { hidS2YN = 1; }
	    if(strHidTpSz.indexOf("O4") > -1) { hidO4YN = 1; }
	    if(strHidTpSz.indexOf("S4") > -1) { hidS4YN = 1; }
	    if(strHidTpSz.indexOf("F2") > -1) { hidF2YN = 1; }
	    if(strHidTpSz.indexOf("A2") > -1) { hidA2YN = 1; }
	    if(strHidTpSz.indexOf("F4") > -1) { hidF4YN = 1; }
	    if(strHidTpSz.indexOf("A4") > -1) { hidA4YN = 1; }
	    if(strHidTpSz.indexOf("F5") > -1) { hidF5YN = 1; }
	    
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            sheetObjects[i].SetVisible(1);
        }
        initControl();
        document.form.init_flag.value='INIT';
        ComSetFocus(document.form.loc_cd);
        
        sheet1_OnLoadFinish(sheetObjects[0]);
	}
	
	
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	var leftHeader1 = [{Text:"yyyy_ww|yyyy_ww|yyyy_ww|Supply|Supply|Supply|Supply|Demand|Demand|Demand|Demand|Demand|MTY Balance|YYYY-MM|Estimated Sound MT|Supply|Supply|Supply|Supply|Demand|Demand|Demand|Demand|MTY Balance|YYYY-MM|Estimated Sound MT|Supply|Supply|Supply|Supply|Demand|Demand|Demand|Demand|MTY Balance", Align:"Left"}];
	var rightHeader1 = [{Text:"Sound MT|Damage MT|I/B PFMC|I/B Remaining(F~S)|COP I/B|COP I/B|COP I/B1|Repo. In|+ Others|O/B PFMC|O/B Remaining(F~S)|Cumulative OP|Repo. Out|- Others", Align:"Left"}];
    //var leftHeader2 = [{Text:"Sound MT|Damage MT|I/B FCST|I/B Remaining (F~S)|Repo In|OW&On-hire|+ Others|O/B FCST|O/B Remaining (F~S)|Repo Out|Off-hire|- Others|MTY Balance|YYYY-MM|Estimated Sound MT|I/B FCST|Repo In|OW&On-hire|+ Others|O/B FCST|Repo Out|Off-hire|- Others|MTY Balance|YYYY-MM|Estimated Sound MT|I/B FCST|Repo In|OW&On-hire|+ Others|O/B FCST|Repo Out|Off-hire|- Others", Align:"Left"}];
    //var leftHeader3 = [{Text:"Sound MT|Damage MT|Supply|Supply|Supply|Supply|Supply|Demand|Demand|Demand|Demand|Demand|MTY Balance|YYYY-MM|Estimated Sound MT|Supply|Supply|Supply|Supply|Demand|Demand|Demand|Demand|MTY Balance|YYYY-MM|Estimated Sound MT|Supply|Supply|Supply|Supply|Demand|Demand|Demand|Demand|MTY Balance", Align:"Left"}];
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
	    var shtID=sheetObj.id;
	    switch(shtID) {
	    	case "sheet1":      //sheet1 init
	    	    with(sheetObj){
			          headTitle="Week|Title|Title|Title|G.TTL|D.TTL|D2|D4|D5|D7|S.TTL|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||||||";
			          var headCnt=headTitle.split("|").length;
			          HeadTitleCnt=headCnt;
			          SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:7, Page:20, DataRowMerge:0 } );
			          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
			          var headers = [ { Text:headTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ 
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"yyyy_ww",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"title",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"item",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"PopupEdit", Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"image_button",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"g_total",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"d_total",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:hidD2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"d2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidD4YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"d4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidD5YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"d5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidD7YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"d7_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"s_total",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:hidR2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"r2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidR5YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"r5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidO2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"o2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidS2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"s2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidO4YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"o4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidS4YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"s4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidF2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"f2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidA2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"a2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidF4YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"f4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidA4YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"a4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Int",       Hidden:hidF5YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"f5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Text",      Hidden:1,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"dp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"inp_yrwk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"fcast_yrwk0",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
			          InitColumns(cols);
			          SetEditable(1);
			          //SetShowButtonImage(2);
			          //SetImageList(0,"img/btns_search_off.gif");
			          //SetImageList(1,"img/btns_search.gif");
			          InitHeadColumn(leftHeader1, sheetObj);
			          //InitHeadColumn(leftHeader2, sheetObj);
			          //InitHeadColumn(leftHeader3, sheetObj);
			          sheetObj.SetHeaderRowHeight(23);
			          //SetRowHeightMin(10);
			          viewFlag_chk(sheetObj)		  //in case of checking DRY,SPLC(RF, OT, FR), ALL, defining handling event
			          SetHeaderFontBold(1);
			          //SetAutoRowHeight(0);//높이를  automatically 으로 조정하지 않고, 1줄 높이로 고정한다
//			          SetSheetHeight(465);
			          resizeSheet( sheetObj );
	    			}
	    		break;
            case "sheet2":      //sheet1 init
                with(sheetObj){
		              HeadTitle="Reference|Reference|G.TTL|D.TTL|D2|D4|D5|D7|S.TTL|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
		              SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"title",         KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"item",          KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Int",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"g_total",       KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"d_total",       KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidD2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"d2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidD4YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"d4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidD5YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"d5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidD7YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"d7_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"s_total",       KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidR2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"r2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidR5YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"r5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidO2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"o2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidS2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"s2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidO4YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"o4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidS4YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"s4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidF2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"f2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidA2YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"a2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidF4YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"f4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidA4YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"a4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",      Hidden:hidF5YN,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"f5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" } ];
		              for(idx=0; idx < 15; idx++) {
		            	  SetRowMerge(idx,1);
		              }
		              InitColumns(cols);
		              SetVisible(1);
		              SetEditable(0);
		              // @Dung.Nguyen - 8/7/2014 (S)
			          InitHeadColumn(rightHeader1, sheetObj);
//		              InitHeadColumn("title", "Sound MT|Damage MT|I/B PFMC|I/B Remaining(F~S)|COP I/B|COP I/B|COP I/B1|Repo. In|+ Others|O/B PFMC|O/B Remaining(F~S)|Cumulative OP|Repo. Out|- Others", daCenter);
//		              InitHeadColumn("item", "Sound MT|Damage MT|I/B PFMC|I/B Remaining(F~S)|WK01|WK02|WK03|Repo. In|+ Others|O/B PFMC|O/B Remaining(F~S)|Cumulative OP|Repo. Out|- Others" , daCenter);
		              // @Dung.Nguyen - 8/7/2014 (S)
		              FrozenCols=2;
		              SetHeaderRowHeight(23);
		              viewFlag_chk(sheetObj)	//in case of checking DRY,SPLC(RF, OT, FR), ALL, defining handling event
		              RowDelete(sheetObjects[1].LastRow(), false);
			          SetHeaderFontBold(1);
//		              initSheet2(sheetObj);
//		              SetSheetHeight(350);
			          resizeSheet( sheetObj );
            		}
                break;
	    }
	}
	
	
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
	
	
	function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
		sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	       case IBSEARCH:      //retrieve
	    	   if(!validateForm(sheetObj,formObj,sAction)) return;
	    	   if ( !ComIsDate(formObj.fcast_yrwk.value, "yw") ) {
	    		   ComShowMessage(msgs["CIM30003"]);
	    		   return;
	    	   }
	    	   //sheetObjects[1].RemoveAll();
	    	   formObj.f_cmd.value=SEARCH;
	    	   formObj.init_flag.value="search";
	    	   //sheetObj.SetWaitImageVisible(0);
	    	   ComOpenWait(true); 
	    	   setTimeout( function () {
		    	   sheetObjects[1].RenderSheet(0);
		    	   initSheet2(sheetObjects[1]);
		    	   sheetObjects[1].RenderSheet(1);
		    	   mainXml=sheetObj.GetSearchData("EES_EQR_5001GS.do" , FormQueryString(form));
	        	   sheetObj.LoadSearchData(mainXml,{Sync:1} );
	        	   yyyyMm=ComGetEtcData(mainXml,"yyyyMm");
		    	   yyyyMm=yyyyMm.split("|");
		    	   for ( var i=0; i<=sheetObj.RowCount(); i++ ) {
		    		   if ( i > 0 && i <= 13) {
		    			   sheetObj.SetCellValue(i,"yyyy_ww",document.form.fcast_yrwk.value,0);
		    		   } else if ( i >= 15 && i <= 24) {
		    			   sheetObj.SetCellValue(i,"yyyy_ww",ComGetMaskedValue(yyyyMm[0],'yw'),0);
		    		   } else if  ( i >= 26) {
		    			   sheetObj.SetCellValue(i,"yyyy_ww",ComGetMaskedValue(yyyyMm[1],'yw'),0);
		    		   }
		    	   }
		    	   ComOpenWait(false); 
	    	   } , 100);
	    	   break;
	       case IBSEARCH01:      //retrieve
	    	   if(!validateForm(sheetObj,formObj,sAction)) return;
	    	   sheetObj.SetWaitImageVisible(0);
	    	   ComOpenWait(true); 
	    	   formObj.f_cmd.value=SEARCH01;
	    	   var sXML=sheetObj.GetSearchData("EES_EQR_5001GS.do",FormQueryString(formObj));
	           var msg=EqrGetMsgText(sXML);
	           //if ( typeof(msg) != 'undefined') {	
	           if ( msg != 'undefined' && msg != '') {	
		           ComShowMessage(msg);
		           return;
	           }
	           var focRow=0;
	           if ( document.form.search_flag.value == '1' ) {
	        	  focRow=1;
	           } else if  ( document.form.search_flag.value == '2' ) {
	        	   focRow=3;
	           } else if  ( document.form.search_flag.value == '3' ) {
	        	   focRow=10;
	           }
	           EqrXml2SheetRows(sXML, sheetObj, focRow);
	           //setting date form
	           for ( var i=1; i<=sheetObj.RowCount(); i++ ) {
	        	   for ( var j=0; j<HeadTitleCnt; j++ ) {
	        		   if  ( document.form.search_flag.value == '2' ) {
	        			   if ( i ==5 || i ==6 ||i ==7 ) {
	        				   if ( j == 1 ) {
	        					   sheetObj.SetCellValue(i,j,ComGetMaskedValue(sheetObj.GetCellValue(i, j),'yw'),0);
	        				   } else {
	        					   sheetObj.SetCellValue(i,j,sheetObj.GetCellValue(i, j),0);
	        				   }
	        				   if ( i==7 && j == 0) {
	        					   sheetObj.SetCellValue(i,j,'COP I/B1',0);
	        				   }
	        			   } 
	        			   else {
	        				   sheetObj.SetCellValue(i,j,sheetObj.GetCellValue(i, j),0);
	        			   }
	        		   }
	        	   }
	           }
	    	   ComOpenWait(false); 
	    	   break;
			case IBSEARCH02: //location focusOut
				var flag=false;
				formObj.inquiryLevel.value="E";
				formObj.location.value=formObj.loc_cd.value;
				formObj.f_cmd.value=SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_EQR_5001GS.do",FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("EQR90203");
						document.form.loc_cd.value="";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						ComSetFocus(document.form.loc_cd);
						return true;
					}
				} else {
					ComSetFocus(document.form.fcast_yrwk);
				}				
				break;		    	   
	       case IBSAVE:        //saving
	    	   if(validateForm(sheetObj,formObj,sAction))
    		   if (!ComShowCodeConfirm("COM130101")) return;
	    	   formObj.f_cmd.value=MULTI;
	    	   for ( var i=0; i<=sheetObj.RowCount(); i++ ) {
	    		   if ( i != 3 && i != 4  && i != 8 && i != 9 && i != 16 && i != 20 && i != 27 && i != 31) {
	    			   sheetObj.SetRowStatus(i,"R");
	    		   }	    	   
	    	   }
	    	   sheetObj.RenderSheet(0);
	    	   if ( sheetObj.GetSaveString() == '' ) {
	    	   } else {
	    		   sheetObj.DoSave("EES_EQR_5001GS.do",FormQueryString(formObj),"ibflag",false);
	    	   }
	    	   sheetObj.RenderSheet(1);
	    	   break;
	    }
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction) {
		with(formObj){
			if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//checking Location 
    		   return false;
			} else {			
				if (!ComChkValid(formObj)) return false;	
				return true;		
			}
	    }
	    return true;
	}
	/**
	 * handling key up event on sheet
	 */	
    function sheet1_OnKeyUp(sheetObject, Row, Col, Value) {
    	if ( document.form.init_flag.value != 'INIT' ) {
	    	if (Col !=3) {	//image_button 아닐때
	    		if(sheetObject.GetCellText(Row,Col) == '' ) {
		    		sheetObject.SetCellValue(Row,Col,0,0);
		    	}
	    	}
    	}
    }
    /**
     * initailizing sheet2
     */
	function initSheet2(sheetObj) {
		sheetObj.RenderSheet(0);
		for ( var i=1; i<=sheetObj.RowCount(); i++ ) { 
			if ( i==1 ) {
				sheetObj.SetCellValue(i,"title","Sound MT",0);
				sheetObj.SetCellValue(i,"item","Sound MT",0);
			}
			if ( i==2 ) {
				sheetObj.SetCellValue(i,"title","Damage MT",0);
				sheetObj.SetCellValue(i,"item","Damage MT",0);
			}
			if ( i==3 || i==16 || i==27 ) {
				sheetObj.SetCellValue(i,"title","I/B PFMC",0);
				sheetObj.SetCellValue(i,"item","I/B PFMC",0);
			}
			if ( i==4) {
				sheetObj.SetCellValue(i,"title","I/B Remaining (F~S)",0);
				sheetObj.SetCellValue(i,"item","I/B Remaining (F~S)",0);
				sheetObj.SetRowHidden(i,1);
			}
			if ( i==5) {
				sheetObj.SetCellValue(i,"title","COP I/B",0);
				sheetObj.SetCellValue(i,"item","WK01",0);
			}
			if ( i==6) {
				sheetObj.SetCellValue(i,"title","COP I/B",0);
				sheetObj.SetCellValue(i,"item","WK02",0);
			}
			if ( i==7) {
				sheetObj.SetCellValue(i,"title","COP I/B1",0);
				sheetObj.SetCellValue(i,"item","WK03",0);
				sheetObj.SetRowHidden(i,1);
			}
			if ( i==8) {
				sheetObj.SetCellValue(i,"title","Repo. In",0);
				sheetObj.SetCellValue(i,"item","Repo. In",0);
			}
			if ( i==9) {
				sheetObj.SetCellValue(i,"title","+ Others",0);
				sheetObj.SetCellValue(i,"item","+ Others",0);
			}
			if ( i==10) { 
				sheetObj.SetCellValue(i,"title","O/B PFMC",0);
				sheetObj.SetCellValue(i,"item","O/B PFMC",0);
			}
			if ( i==11) {
				sheetObj.SetCellValue(i,"title","O/B Remaining (F~S)",0);
				sheetObj.SetCellValue(i,"item","O/B Remaining (F~S)",0);
				sheetObj.SetRowHidden(i,1);
			}
			if ( i==12) {
				sheetObj.SetCellValue(i,"title","Cumulative OP",0);
				sheetObj.SetCellValue(i,"item","Cumulative OP",0);
			}
			if ( i==13) {
				sheetObj.SetCellValue(i,"title","Repo. Out",0);
				sheetObj.SetCellValue(i,"item","Repo. Out",0);
			}			
			if ( i==14) {
				sheetObj.SetCellValue(i,"title","- Others",0);
				sheetObj.SetCellValue(i,"item","- Others",0);
			}
			if ( i!= 5 && i!= 6) {
				sheetObj.SetMergeCell(i, 0, 1, 2);
			}
	   		//sheetObj.SetRowMerge(i,1);
	   		sheetObj.SetRowHeight(i,20);
	   	}
		sheetObj.SetMergeCell(5, 0, 2, 1);

		for ( var i=0; i<=sheetObj.RowCount(); i++ ) {
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
	     		if ( i>0 && i <= 2 ) {
	     			sheetObj.SetCellFontColor(i,j,"#000001");
	     			sheetObj.SetCellBackColor(i,j,"#FFFFFF");
	     		} else if ( i>2 && i <= 9 ) {
	     			sheetObj.SetCellFontColor(i,j,"#000001");
	     			sheetObj.SetCellBackColor(i,j,"#F6FAFB");
	     		} else if ( i>9 ) {
	     			sheetObj.SetCellFontColor(i,j,"#000001");
	     			sheetObj.SetCellBackColor(i,j,"#FFEAEA");
	     		}
		   	}
	    }
   		setRightFontColor(sheetObj);
		sheetObj.RenderSheet(1);
	}
    /**
     * setting font color
     */
	function setRightFontColor(sheetObj) {
		for ( var i=0; i<=sheetObj.RowCount(); i++ ) {
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
		   		if ( j ==0 || j ==1) {
			   		sheetObj.SetCellAlign(i,j,"Center");
			   		sheetObj.SetCellFont("FontBold", i,j,i,j,1);
		   		}
		   	}
	   		if ( i ==1 || i ==3  || i ==10) {
		   		sheetObj.SetCellFont("FontUnderline", i,0,i,0,1);
	   		}
		}
	}
	
	
    /**
     * initailizing sheet1
     */
	function initSheet1(sheetObj) {
		sheetObj.RenderSheet(0);
		for ( var i=1; i<=sheetObj.RowCount(); i++ ) { 
			if ( i==1 ) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","Sound MT",0);
				sheetObj.SetCellValue(i,"item","Sound MT",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}
			if ( i==2 ) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","Damage MT",0);
				sheetObj.SetCellValue(i,"item","Damage MT",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}
			if ( i==3 || i==16 || i==27 ) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","I/B FCST",0);
				sheetObj.SetCellValue(i,"item","I/B FCST",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}
			if ( i==4) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","I/B Remaining (F~S)",0);
				sheetObj.SetCellValue(i,"item","I/B Remaining (F~S)",0);
				sheetObj.SetRowHidden(i,1);//hiding I/B Remaining (F~S)
				sheetObj.SetCellEditable(i, "item", 0);
			}
			if ( i==5 || i==17 || i==28) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","Repo In",0);
				sheetObj.SetCellValue(i,"item","Repo In",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}
			if ( i==6 || i==18 || i==29) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","OW&On-hire",0);
				sheetObj.SetCellValue(i,"item","OW&On-hire",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}
			if ( i==7 || i==19 || i==30) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","+ Others",0);
				sheetObj.SetCellValue(i,"item","+ Others",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}
			if ( i==8 || i==20 || i==31) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","O/B FCST",0);
				sheetObj.SetCellValue(i,"item","O/B FCST",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}
			if ( i==9) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","O/B Remaining (F~S)",0);
				sheetObj.SetCellValue(i,"item","O/B Remaining (F~S)",0);
				sheetObj.SetRowHidden(i,1);//hiding O/B Remaining (F~S)
				sheetObj.SetCellEditable(i, "item", 0);
			}
			if ( i==10 || i==21 || i==32) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","Repo Out",0);
				sheetObj.SetCellValue(i,"item","Repo Out",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}			
			if ( i==11 || i==22 || i==33) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","Off-hire",0);
				sheetObj.SetCellValue(i,"item","Off-hire",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}			
			if ( i==12 || i==23 || i==34) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","- Others",0);
				sheetObj.SetCellValue(i,"item","- Others",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}			
			if ( i==13 || i==24 || i==35) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","MTY Balance",0);
				sheetObj.SetCellValue(i,"item","MTY Balance",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}			
			if ( i==14 || i==25  ) {
				sheetObj.SetCellValue(i,"yyyy_ww","");
				sheetObj.SetCellValue(i,"title","");
				sheetObj.SetCellValue(i,"item","");
				sheetObj.SetCellEditable(i, "item", 0);
			}
			if ( i==15 || i==26 ) {
				sheetObj.SetCellValue(i,"yyyy_ww","YYYY-WW",0);
				sheetObj.SetCellValue(i,"title","Estimated Sound MT",0);
				sheetObj.SetCellValue(i,"item","Estimated Sound MT",0);
				sheetObj.SetCellEditable(i, "item", 0);
			}			
			/*sheetObj.SetMergeCell(i, 2, 1, 3);
	   		sheetObj.SetRowMerge(i,1);
	   		sheetObj.SetRowHeight(i,20);*/
	   	}
		//sheetObj.SetMergeCell(1, 2, 1, 3);
		sheetObj.SetMergeCell(1, 0, 13, 1);
		sheetObj.SetMergeCell(15, 0, 10, 1);
		sheetObj.SetMergeCell(26, 0, 10, 1);
		sheetObj.SetMergeCell(14, 0, 1, 34);
   		setLeftFontColor(sheetObj);
		chgBackColor(sheetObj)
		sheetObj.SetRowHeight(14,10);
		sheetObj.SetRowHeight(25,10);
		sheetObj.RenderSheet(1);
	}
	
	
    /**
     * setting font color
     */
	function setLeftFontColor(sheetObj) {
		for ( var i=0; i<=sheetObj.RowCount(); i++ ) {
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
		   		if ( j ==0 || j ==1  || j ==2) {
			   		sheetObj.SetCellAlign(i,j,"Center");
			   		sheetObj.SetCellFont("FontBold", i,j,i,j,1);
		   		}
		   		//sheetObj.SetCellEditable(i,j,0);
		   	}
		}
	}
    /**
     * changing background color on sheet
     */
	function chgBackColor(sheetObj) {
	   	for ( var i=1; i<=sheetObj.RowCount(); i++ ) {
	   		sheetObj.SetRowStatus(i,"R");
	   		sheetObj.SetCellEditable(i,"g_total",0);
	   		sheetObj.SetCellEditable(i,"d_total",0);
	   		sheetObj.SetCellEditable(i,"s_total",0);
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
		   		if ( i != 14  && i !=25 ) {
			   		if ( j !=0 ) {
				   		if ( i>=3 && i <=7 || i>=16 && i <=19 || i>=27 && i <=30 ) {
			     			sheetObj.SetCellFontColor(i,j,"#000001");
			     			sheetObj.SetCellBackColor(i,j,"#F6FAFB");
				   		} else if  ( i>=8 && i <=12 || i>=20 && i <=23 || i>=31 && i <=34 ) { 
			     			sheetObj.SetCellFontColor(i,j,"#000001");
			     			sheetObj.SetCellBackColor(i,j,"#FFEAEA");
				   		} else if  ( i==13 || i==24  || i==35 ) { 
			     			sheetObj.SetCellFontColor(i,j,"#000001");
			     			sheetObj.SetCellBackColor(i,j,"#D0EC7F");
				   		} else {
			     			sheetObj.SetCellFontColor(i,j,"#000001");
				   			sheetObj.SetCellBackColor(i,j,"#FFFFFF");
				   		}
			   		} else {
			   			sheetObj.SetCellFontColor(i,"yyyy_ww","#000001");
			   			sheetObj.SetCellBackColor(i,"yyyy_ww","#FFFFFF");
			   		}
		   		} else {
		   			sheetObj.SetCellBackColor(i,j,sheetObj.GetHeaderBackColor());
		   		}
		   		
		   	}
 	   	}
	}
    /**
     * handling mouse move event on sheet
     */
	function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y) {
	    var col=sheetObj.MouseCol();
	    var row=sheetObj.MouseRow();
	    if ( document.form.init_flag.value != 'INIT' ) {
			if ( sheetObj.ColSaveName(col) == "image_button" && row >= sheetObj.HeaderRows()) {
				if ( row ==5 || row ==6 ||row ==7 ||row ==10 ||row ==12 ||row ==17 ||row ==18 ||row ==19 ||row ==23 ||row ==28 ||row ==29 ||row ==30 ||row ==32 ||row ==34 ) {
					sheetObj.SetMousePointer("Hand");
				}
			}
	    }
	}
    /**
     * handling mouse move event on sheet
     */	
	function sheet2_OnMouseMove(sheetObj,Button, Shift, X, Y) {
	    var col=sheetObj.MouseCol();
	    var row=sheetObj.MouseRow();
	    if ( document.form.init_flag.value != 'INIT' ) {
			if ( sheetObj.ColSaveName(col) == "title" && row >= sheetObj.HeaderRows()) {
				if ( row ==1 || row ==3 ||row ==10 ) {
					sheetObj.SetMousePointer("Hand");
				}
			}
	    }
	}	
    /**
     * handling search end event on sheet
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if (sheetObj.RowCount() < 1) {
			initSheet1(sheetObjects[0]);
		} else {
			initSheet1(sheetObjects[0]);
		}
		
		//sheetObj.SetEditableColor("#000000");
		if (document.form.init_flag.value!='INIT') {
			sheetObjects[0].SetShowButtonImage(2);
			sheetObjects[0].SetColHidden(3,0);
			for ( var i=0; i<=sheetObj.RowCount(); i++ ) {
				if (  i == 14 || i == 25  || i == 36 ) {
					sheetObj.SetRowMerge(i,1);
				}
				if ( i==13 || i==24 || i==35) {
					sheetObj.SetMergeCell(i, 1, 1, 3);
				}				
				if ( i==15 || i==26 ) {
					sheetObj.SetCellValue(i,"title","Estimated Sound MT",0);
					sheetObj.SetCellValue(i,"item","Estimated Sound MT",0);
					sheetObj.SetMergeCell(i, 1, 1, 3);
				}			
				if ( i != 3 && i != 4  && i != 8 && i != 9 && i != 16 && i != 20 && i != 27 && i != 31) {
					sheetObj.SetRowEditable(i,0);
				} else {
					sheetObj.SetCellEditable(i,"title",0);
					sheetObj.SetCellEditable(i,"item",0);
					sheetObj.SetCellEditable(i,"g_total",0);
					sheetObj.SetCellEditable(i,"d_total",0);
					sheetObj.SetCellEditable(i,"s_total",0);
					sheetObj.SetCellFontColor(i,"title","#0000FF");
				}
				if ( i == 14  || i ==25 ) {
				   	for ( var j=0; j<HeadTitleCnt; j++ ) {
				   		sheetObj.SetCellValue(i,j,"");
				   		sheetObj.SetCellBackColor(i,j,sheetObj.GetHeaderBackColor());
//v				   		if ( j !=0 && j !=1  && j !=2  && j !=3) {
//v				   			sheetObj.SetCellValue(i,j,sheetObj.GetCellValue(0, j),0);
//v							sheetObj.SetCellAlign(i,j,"Center");
//v							sheetObj.SetCellFont("FontBold", i,j,1);
//v							sheetObj.SetCellFont("FontSize", i,j,8);
//v				   		} else {
//v							sheetObj.SetCellAlign(i,j,"Center");
//v							sheetObj.SetCellFont("FontBold", i,j,1);
//v							sheetObj.SetCellFont("FontSize", i,j,8);
//v				   		}
				   	}
				} 
				if ( i == 5  || i ==6 || i ==7 || i ==10 || i ==12 || i ==17 || i ==18 || i ==19 || i ==21 || i ==23 || i ==28 || i ==29 || i ==30 || i ==32 || i ==34) {
				}
				sheetObj.SetRowHeight(i,20);
				sheetObj.SetCellEditable(i,"image_button",1);
			}
			
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
		   		if ( j !=0 && j !=1  && j !=2  && j !=3  && j !=4 && j !=5  && j !=10  && j !=22 && j !=23 && j !=24 && j !=25 && j !=26 && j !=27 ) {
					setCaluValue(sheetObj.ColSaveName(j).substring(0,2),sheetObj);	   //calculation MTY Balance
		   		}
		   	}
	   		sheetObj.SetMergeCell(1, 1, 1, 3);
	   		sheetObj.SetCellEditable(1, 1, 1, 3);
	   		sheetObj.SetMergeCell(2, 1, 1, 3);
	   		sheetObj.SetMergeCell(3, 1, 1, 3);
	   		sheetObj.SetMergeCell(8, 1, 1, 3);
	   		sheetObj.SetMergeCell(11, 1, 1, 3);
	   		sheetObj.SetMergeCell(13, 1, 1, 3);
	   		sheetObj.SetMergeCell(14, 1, 1, 3);
	   		sheetObj.SetMergeCell(15, 1, 1, 3);
	   		sheetObj.SetMergeCell(16, 1, 1, 3);
	   		sheetObj.SetMergeCell(20, 1, 1, 3);
	   		sheetObj.SetMergeCell(22, 1, 1, 3);
	   		sheetObj.SetMergeCell(25, 1, 1, 3);
	   		sheetObj.SetMergeCell(26, 1, 1, 3);
	   		sheetObj.SetMergeCell(27, 1, 1, 3);
	   		sheetObj.SetMergeCell(31, 1, 1, 3);
	   		sheetObj.SetMergeCell(33, 1, 1, 3);
	   		sheetObj.SetMergeCell(35, 1, 1, 3);
			sheetObj.SetRowHeight(14,10);
			sheetObj.SetRowHeight(25,10);
	   		viewFlag_chk(sheetObj);	   //in case of DRY,SPLC(RF, OT, FR), ALL checked
			chgBackColor(sheetObj)
	   		sheetObj.RenderSheet(1);
	   		sheetObj.SetWaitImageVisible(0);
		}
	}	
	
	//MTY Balancecalculation
	function setCaluValue(tpsz,sheetObj,totalFlag) {
		var supplySum1=0;
		var demandSum1=0;
		var supplySum2=0;
		var demandSum2=0;
		var supplySum3=0;
		var demandSum3=0;
		var sumGSupply1=0;
		var sumGdemand1=0;
		var sumGSupply2=0;
		var sumGDemand2=0;
		var sumGSupply3=0;
		var sumGDemand3=0;
		var sumDSupply1=0;
		var sumDdemand1=0;
		var sumDSupply2=0;
		var sumDDemand2=0;
		var sumDSupply3=0;
		var sumDDemand3=0;
		var sumSSupply1=0;
		var sumSdemand1=0;
		var sumSSupply2=0;
		var sumSDemand2=0;
		var sumSSupply3=0;
		var sumSDemand3=0;
		for ( var i=1; i<=12; i++ ) {
			//calculation MTY Balance
			if ( i == 1 || i == 3 ||  i == 4 || i == 5 || i == 6 || i == 7 ) {
				if ( sheetObj.GetCellText(i, tpsz+"_fcast_qty") !="" ) {
					supplySum1=supplySum1 + eval(ComReplaceStr(sheetObj.GetCellValue(i, tpsz+"_fcast_qty"),",",""));
				}
				if ( sheetObj.GetCellText(i, "g_total") !="" ) {
					sumGSupply1=sumGSupply1 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "g_total"),",",""));
				}
				if ( sheetObj.GetCellText(i, "d_total") !="" ) {
					sumDSupply1=sumDSupply1 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "d_total"),",",""));
				}
				if ( sheetObj.GetCellText(i, "s_total") !="" ) {
					sumSSupply1=sumSSupply1 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "s_total"),",",""));
				}
			}
			if ( i == 8 ||  i == 9 || i == 10 || i == 11 || i == 12 ) {
				if ( sheetObj.GetCellText(i, tpsz+"_fcast_qty") !="" ) {
					demandSum1=demandSum1 + eval(ComReplaceStr(sheetObj.GetCellValue(i, tpsz+"_fcast_qty"),",",""));
				}
				if ( sheetObj.GetCellText(i, "g_total") !="" ) {
					sumGdemand1=sumGdemand1 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "g_total"),",",""));
				}
				if ( sheetObj.GetCellText(i, "d_total") !="" ) {
					sumDdemand1=sumDdemand1 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "d_total"),",",""));
				}
				if ( sheetObj.GetCellText(i, "s_total") !="" ) {
					sumSdemand1=sumSdemand1 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "s_total"),",",""));
				}
			}
		}
		sheetObj.SetCellValue(13,tpsz+"_fcast_qty",ComAddComma(supplySum1-demandSum1),0);
		sheetObj.SetCellValue(15,tpsz+"_fcast_qty",ComAddComma(supplySum1-demandSum1),0);
		sheetObj.SetCellValue(13,"g_total",ComAddComma(sumGSupply1-sumGdemand1),0);
		sheetObj.SetCellValue(15,"g_total",ComAddComma(sumGSupply1-sumGdemand1),0);
		sheetObj.SetCellValue(13,"d_total",ComAddComma(sumDSupply1-sumDdemand1),0);
		sheetObj.SetCellValue(15,"d_total",ComAddComma(sumDSupply1-sumDdemand1),0);
		sheetObj.SetCellValue(13,"s_total",ComAddComma(sumSSupply1-sumSdemand1),0);
		sheetObj.SetCellValue(15,"s_total",ComAddComma(sumSSupply1-sumSdemand1),0);
		for ( var i=15; i<=23; i++ ) {
			if ( i == 15 ||  i == 16 || i == 17 || i == 18 || i == 19 ) {
				if ( sheetObj.GetCellText(i, tpsz+"_fcast_qty") !="" ) {
					supplySum2=supplySum2 + eval(ComReplaceStr(sheetObj.GetCellValue(i, tpsz+"_fcast_qty"),",",""));
				}
				if ( sheetObj.GetCellText(i, "g_total") !="" ) {
					sumGSupply2=sumGSupply2 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "g_total"),",",""));
				}
				if ( sheetObj.GetCellText(i, "d_total") !="" ) {
					sumDSupply2=sumDSupply2 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "d_total"),",",""));
				}
				if ( sheetObj.GetCellText(i, "s_total") !="" ) {
					sumSSupply2=sumSSupply2 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "s_total"),",",""));
				}
			}
			if ( i == 20 ||  i == 21 || i == 22 || i == 23 ) {
				if ( sheetObj.GetCellText(i, tpsz+"_fcast_qty") !="" ) {
					demandSum2=demandSum2 + eval(ComReplaceStr(sheetObj.GetCellValue(i, tpsz+"_fcast_qty"),",",""));
				}
				if ( sheetObj.GetCellText(i, "g_total") !="" ) {
					sumGDemand2=sumGDemand2 + eval(sheetObj.GetCellValue(i, "g_total"));
				}
				if ( sheetObj.GetCellText(i, "d_total") !="" ) {
					sumDDemand2=sumDDemand2 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "d_total"),",",""));
				}
				if ( sheetObj.GetCellText(i, "s_total") !="" ) {
					sumSDemand2=sumSDemand2 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "s_total"),",",""));
				}
			}
		}
		sheetObj.SetCellValue(24,tpsz+"_fcast_qty",ComAddComma(supplySum2-demandSum2),0);
		sheetObj.SetCellValue(26,tpsz+"_fcast_qty",ComAddComma(supplySum2-demandSum2),0);
		sheetObj.SetCellValue(24,"g_total",ComAddComma(sumGSupply2-sumGDemand2),0);
		sheetObj.SetCellValue(26,"g_total",ComAddComma(sumGSupply2-sumGDemand2),0);
		sheetObj.SetCellValue(24,"d_total",ComAddComma(sumDSupply2-sumDDemand2),0);
		sheetObj.SetCellValue(26,"d_total",ComAddComma(sumDSupply2-sumDDemand2),0);
		sheetObj.SetCellValue(24,"s_total",ComAddComma(sumSSupply2-sumSDemand2),0);
		sheetObj.SetCellValue(26,"s_total",ComAddComma(sumSSupply2-sumSDemand2),0);
		for ( var i=26; i<=34; i++ ) {
			if ( i == 26 || i == 27 ||  i == 28 || i == 29 || i == 30 ) {
				if ( sheetObj.GetCellText(i, tpsz+"_fcast_qty") !="" ) {
					supplySum3=supplySum3 + eval(ComReplaceStr(sheetObj.GetCellValue(i, tpsz+"_fcast_qty"),",",""));
				}
				if ( sheetObj.GetCellText(i, "g_total") !="" ) {
					sumGSupply3=sumGSupply3 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "g_total"),",",""));
				}
				if ( sheetObj.GetCellText(i, "d_total") !="" ) {
					sumDSupply3=sumDSupply3 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "d_total"),",",""));
				}
				if ( sheetObj.GetCellText(i, "s_total") !="" ) {
					sumSSupply3=sumSSupply3 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "s_total"),",",""));
				}
			}
			if ( i == 31 ||  i == 32 || i == 33 || i == 34 ) {
				if ( sheetObj.GetCellText(i, tpsz+"_fcast_qty") !="" ) {
					demandSum3=demandSum3 + eval(ComReplaceStr(sheetObj.GetCellValue(i, tpsz+"_fcast_qty"),",",""));
				}
				if ( sheetObj.GetCellText(i, "g_total") !="" ) {
					sumGDemand3=sumGDemand3 + eval(sheetObj.GetCellValue(i, "g_total"));
				}
				if ( sheetObj.GetCellText(i, "d_total") !="" ) {
					sumDDemand3=sumDDemand3 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "d_total"),",",""));
				}
				if ( sheetObj.GetCellText(i, "s_total") !="" ) {
					sumSDemand3=sumSDemand3 + eval(ComReplaceStr(sheetObj.GetCellValue(i, "s_total"),",",""));
				}
			}
		}
		sheetObj.SetCellValue(35,tpsz+"_fcast_qty",ComAddComma(supplySum3-demandSum3),0);
		sheetObj.SetCellValue(35,"g_total",ComAddComma(sumGSupply3-sumGDemand3),0);
		sheetObj.SetCellValue(35,"d_total",ComAddComma(sumDSupply3-sumDDemand3),0);
		sheetObj.SetCellValue(35,"s_total",ComAddComma(sumSSupply3-sumSDemand3),0);
		sheetObj.SetCellValue(13,"g_total",ComAddComma(sheetObj.GetCellValue(13,"g_total")),0);
		sheetObj.SetCellValue(15,"g_total",ComAddComma(sheetObj.GetCellValue(15,"g_total")),0);
		sheetObj.SetCellValue(24,"g_total",ComAddComma(sheetObj.GetCellValue(24,"g_total")),0);
		sheetObj.SetCellValue(26,"g_total",ComAddComma(sheetObj.GetCellValue(26,"g_total")),0);
		sheetObj.SetCellValue(35,"g_total",ComAddComma(sheetObj.GetCellValue(35,"g_total")),0);
		sheetObj.SetCellValue(13,"d_total",ComAddComma(sheetObj.GetCellValue(13,"d_total")),0);
		sheetObj.SetCellValue(15,"d_total",ComAddComma(sheetObj.GetCellValue(15,"d_total")),0);
		sheetObj.SetCellValue(24,"d_total",ComAddComma(sheetObj.GetCellValue(24,"d_total")),0);
		sheetObj.SetCellValue(26,"d_total",ComAddComma(sheetObj.GetCellValue(26,"d_total")),0);
		sheetObj.SetCellValue(35,"d_total",ComAddComma(sheetObj.GetCellValue(35,"d_total")),0);
		sheetObj.SetCellValue(13,"s_total",ComAddComma(sheetObj.GetCellValue(13,"s_total")),0);
		sheetObj.SetCellValue(15,"s_total",ComAddComma(sheetObj.GetCellValue(15,"s_total")),0);
		sheetObj.SetCellValue(24,"s_total",ComAddComma(sheetObj.GetCellValue(24,"s_total")),0);
		sheetObj.SetCellValue(26,"s_total",ComAddComma(sheetObj.GetCellValue(26,"s_total")),0);
		sheetObj.SetCellValue(35,"s_total",ComAddComma(sheetObj.GetCellValue(35,"s_total")),0);
		sheetObj.SetCellValue(13,tpsz+"_fcast_qty",ComAddComma(sheetObj.GetCellValue(13,tpsz+"_fcast_qty")),0);
		sheetObj.SetCellValue(15,tpsz+"_fcast_qty",ComAddComma(sheetObj.GetCellValue(15,tpsz+"_fcast_qty")),0);
		sheetObj.SetCellValue(24,tpsz+"_fcast_qty",ComAddComma(sheetObj.GetCellValue(24,tpsz+"_fcast_qty")),0);
		sheetObj.SetCellValue(26,tpsz+"_fcast_qty",ComAddComma(sheetObj.GetCellValue(26,tpsz+"_fcast_qty")),0);
		sheetObj.SetCellValue(35,tpsz+"_fcast_qty",ComAddComma(sheetObj.GetCellValue(35,tpsz+"_fcast_qty")),0);
		//setting calculation G.TTL,D.TTL,S.TTL
		var colGtotal=0;
		var colDtotal=0;
		var colStotal=0;
        for ( var j=0; j<HeadTitleCnt; j++ ) { 
            if ( j !=0 && j !=1  && j !=2  && j !=3  && j !=4 && j !=5  && j !=10  && j !=22 && j !=23 && j !=24 && j !=25 && j !=26 && j !=27) {
            	if ( sheetObj.GetCellText(j, sheetObj.ColSaveName(j)) !="" ) {
	        		if ( sheetObj.ColSaveName(j).substring(0,1) == 'd' ) {
	        			colDtotal=colDtotal + eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sheetObj.ColSaveName(j)),",",""));
	        		} 
	        		if ( sheetObj.ColSaveName(j).substring(0,1) != 'd' ) {
	        			colStotal=colStotal + eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sheetObj.ColSaveName(j)),",",""));
	        		}
    			}
        	}
        }
        colGtotal=colDtotal+colStotal;
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"g_total",ComAddComma(colGtotal),0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"d_total",ComAddComma(colDtotal),0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"s_total",ComAddComma(colStotal),0);
		if ( totalFlag == 'total' ) {
			for ( var i=0; i<=sheetObj.RowCount(); i++ ) {
				colGtotal=0;
				colDtotal=0;
				colStotal=0;
				if ( i == 13 || i == 15 || i == 24 || i == 26 || i == 35 ) {
			        for ( var j=0; j<HeadTitleCnt; j++ ) { 
			            if ( j !=0 && j !=1  && j !=2  && j !=3  && j !=4 && j !=5  && j !=10  && j !=22 && j !=23 && j !=24 && j !=25 && j !=26 && j !=27) {
			            	if ( sheetObj.GetCellText(i, sheetObj.ColSaveName(j)) !="" ) {
				        		if ( sheetObj.ColSaveName(j).substring(0,1) == 'd' ) {	//DRY
				        			colDtotal=colDtotal + eval(ComReplaceStr(sheetObj.GetCellValue(i, sheetObj.ColSaveName(j)),",",""));
				        		} 
				        		if ( sheetObj.ColSaveName(j).substring(0,1) != 'd' ) {	//SPCL(RF, OT, FR)
				        			colStotal=colStotal + eval(ComReplaceStr(sheetObj.GetCellValue(i, sheetObj.ColSaveName(j)),",",""));
				        		}
			    			}
			        	}
			        }
			        colGtotal=colDtotal+colStotal;
					sheetObj.SetCellValue(i,"g_total",ComAddComma(colGtotal),0);
					sheetObj.SetCellValue(i,"d_total",ComAddComma(colDtotal),0);
					sheetObj.SetCellValue(i,"s_total",ComAddComma(colStotal),0);
				}
			}
		}
		//changing backgroud color on 13,24,35th Row
		for ( var i=0; i<=sheetObj.RowCount(); i++ ) {
			if ( i == 13 || i == 24 || i == 35 ) {
				if ( eval(ComReplaceStr(sheetObj.GetCellText(i,"g_total"),",","")) >= 0 ) {
					sheetObj.SetCellFontColor(i,"g_total","#0000FF");
				} else {
					sheetObj.SetCellFontColor(i,"g_total","#FF0000");
				}
				if ( eval(ComReplaceStr(sheetObj.GetCellText(i,"d_total"),",","")) >= 0 ) {
					sheetObj.SetCellFontColor(i,"d_total","#0000FF");
				} else {
					sheetObj.SetCellFontColor(i,"d_total","#FF0000");
				}
				if ( eval(ComReplaceStr(sheetObj.GetCellText(i,"s_total"),",","")) >= 0 ) {
					sheetObj.SetCellFontColor(i,"s_total","#0000FF");
				} else {
					sheetObj.SetCellFontColor(i,"s_total","#FF0000");
				}
				if ( eval(ComReplaceStr(sheetObj.GetCellText(i,tpsz+"_fcast_qty"),",","")) >= 0 ) {
					sheetObj.SetCellFontColor(i,tpsz+"_fcast_qty","#0000FF");
				} else {
					sheetObj.SetCellFontColor(i,tpsz+"_fcast_qty","#FF0000");
				}
			}
		}		
	}
    /**
     * Setting selected value from Location by loc_cd
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
       var sheetObject=sheetObjects[0];
       var formObject=document.form;
       formObject.loc_cd.value=aryPopupData[0][3] 
    }
    /**
     * handling click event on sheet <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	selected Row
     * @param {ibsheet} col     	selected Col
     **/
	function sheet1_OnPopupClick(Row, Col) {
		alert("popup");
	}	
    function sheet1_OnPopupClick(sheetObj, row, col) {
//   function sheet1_OnClick(sheetObj, row, col, value) {
    	var dp_seq=sheetObj.GetCellValue(row,"dp_seq");
 		if ( document.form.init_flag.value != 'INIT' ) {
 	    	switch (sheetObj.ColSaveName(col)) {
 	    		case "image_button" :   			
 	    			if ( dp_seq == 5 || dp_seq == 10 || dp_seq == 17 || dp_seq == 21 || dp_seq == 28 || dp_seq == 32) {    //Repo. In,Repo. Out
 	    				var repo_flag="OUT";
 	    				if ( dp_seq == 5 || dp_seq == 17 || dp_seq == 28 ) {    //Repo. In
 	    					repo_flag="IN";
 	    				} 
 	    		 		var param="loc_cd=" + document.form.loc_cd.value
 	    		 		+"&fcast_yrwk=" + sheetObj.GetCellValue(row,"yyyy_ww")
 	    		 		+"&tp_cd=" + sheetObj.GetCellValue(row,"tp_cd")
				 				   +"&inp_yrwk=" + ComTrimAll(document.form.fcast_yrwk.value, "-", "") 
				 				   +"&repo_pln_yrwk=" + ComTrimAll(sheetObj.GetCellValue(1,"yyyy_ww"), "-", "")
				 				   +"&repo_flag=" + repo_flag;
	    		 		ComOpenPopup("/opuscntr/EES_EQR_5002.do?"+ param,1000, 700, "setOwOnHireValue", "0,0", true);
 	    			} else if ( dp_seq == 6  || dp_seq == 18 || dp_seq == 29) {	  //OW&On-hire
 	    		 		var param="loc_cd=" + document.form.loc_cd.value
 	    		 		+"&fcast_yrwk=" + sheetObj.GetCellValue(row,"yyyy_ww")
 	    		 		+"&tp_cd=" + sheetObj.GetCellValue(row,"tp_cd")
 	    		 		+"&inp_yrwk=" + sheetObj.GetCellValue(row,"inp_yrwk");
						ComOpenPopup("/opuscntr/EES_EQR_5004.do?"+ param,750, 490, "", "0,0", true);
 	    			} else if ( dp_seq == 7  || dp_seq == 12 || dp_seq == 19 || dp_seq == 23 || dp_seq == 30 || dp_seq == 34) {	  //+ Others,- Others
 	    				var repo_flag="MINUS";
 	    				if ( dp_seq == 7  || dp_seq == 19  ||dp_seq == 30 ) {
 	    					repo_flag="PLUS";
 	    				}
 	    		 		var param="loc_cd=" + document.form.loc_cd.value
 	    		 		+ "&fcast_yrwk=" + sheetObj.GetCellValue(row,"yyyy_ww")
 	    		 		+ "&tp_cd=" + sheetObj.GetCellValue(row,"tp_cd")
 	    		 		+ "&inp_yrwk=" + sheetObj.GetCellValue(row,"inp_yrwk")
 	    		 		+ "&repo_flag=" + repo_flag; 
 	    		 		ComOpenPopup("/opuscntr/EES_EQR_5003.do?"+ param,700, 490, "", "0,0", true);
 	    			}
 	       			break;
 	    	}
     	} 
    }
    /**
     * handling after edit event on sheet <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	seleted Row
     * @param {ibsheet} col     	seleted Col
     **/
    function sheet1_OnAfterEdit(sheetObj, Row, Col) {
    	if ( document.form.init_flag.value != 'INIT' ) {
	    	if (Col !=3) {	//in case of not image_button
	    		if ( sheetObj.GetCellText(Row,Col) == '' ) {
		    		sheetObj.SetCellValue(Row,Col,0,0);
		    	}
	    	}
  	    	switch (sheetObj.ColSaveName(Col)) {
  	    		case "d2_fcast_qty":
  	    			setCaluValue("d2",sheetObj,'total');
  	       			break;
  	    		case "d4_fcast_qty":
  	    			setCaluValue("d4",sheetObj,'total');
  	       			break;
  	    		case "d5_fcast_qty":
  	    			setCaluValue("d5",sheetObj,'total');
  	       			break;
  	    		case "d7_fcast_qty":
  	    			setCaluValue("d7",sheetObj,'total');
  	       			break;
  	    		case "r2_fcast_qty":
  	    			setCaluValue("r2",sheetObj,'total');
  	       			break;
  	    		case "r5_fcast_qty":
  	    			setCaluValue("r5",sheetObj,'total');
  	       			break;
  	    		case "o2_fcast_qty":
  	    			setCaluValue("o2",sheetObj,'total');
  	       			break;
  	    		case "s2_fcast_qty":
  	    			setCaluValue("s2",sheetObj,'total');
  	       			break;
  	    		case "o4_fcast_qty":
  	    			setCaluValue("o4",sheetObj,'total');
  	       			break;
  	    		case "s4_fcast_qty":
  	    			setCaluValue("s4",sheetObj,'total');
  	       			break;
  	    		case "f2_fcast_qty":
  	    			setCaluValue("f2",sheetObj,'total');
  	       			break;
  	    		case "a2_fcast_qty":
  	    			setCaluValue("a2",sheetObj,'total');
  	       			break;
  	    		case "f4_fcast_qty":
  	    			setCaluValue("f4",sheetObj,'total');
  	       			break;
  	    		case "a4_fcast_qty":
  	    			setCaluValue("a4",sheetObj,'total');
  	       			break;
  	    		case "f5_fcast_qty":
  	    			setCaluValue("f5",sheetObj,'total');
  	       			break;
  	    	}
    	} 
    }
    /**
     * handling save end event on sheet
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
   		sheetObj.SetMergeCell(14, 1, 1, 3);
   		sheetObj.SetMergeCell(1, 1, 1, 3);
   		sheetObj.SetMergeCell(2, 1, 1, 3);
   		sheetObj.SetMergeCell(13, 1, 1, 3);
   		sheetObj.SetMergeCell(15, 1, 1, 3);
    	if ( ErrMsg == '' ) {	//success
    		ComShowMessage(ComGetMsg("COM130102", "Data"));
    	} else {	//setting init data when error occured
    		sheetObj.LoadSearchData(mainXml,{Sync:1} );
    	}
    	sheetObj.RenderSheet(1);
    	sheetObj.SetShowMsgMode(0);
    }
    /**
     * setting selected OW&On-hire total value form pop-up
    */
    function setOwOnHireValue(saveName,value){
        for ( var j=0; j<HeadTitleCnt; j++ ) {
        	if ( sheetObjects[0].ColSaveName(j) == saveName ) {
        		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),saveName,ComAddComma(value),0);
        	}
        }
    }
    /**
     * setting selected data from pop-up
    */
    function popupCloseEnd() {
	   	for ( var j=0; j<HeadTitleCnt; j++ ) {
	   		if ( j !=0 && j !=1  && j !=2  && j !=21 && j !=22 && j !=23 && j !=24 && j !=25 && j !=26 ) {
				setCaluValue(sheetObjects[0].ColSaveName(j).substring(0,2),sheetObjects[0]);	   //calculation MTY Balance
	   		}
	   	}
    }
    /**
     * handling scroll event on sheet
    */
    function sheet1_OnScroll(sheetObj, OlGetTopRow, OldLeftCol, NewGetTopRow, NewLeftCol) {
    	if (OldGetHighLeftCol()!= NewGetHighLeftCol()) {
	    	if ( focFlag1 ) {
		    	focFlag2=false;
		    	var colName=sheetObj.ColSaveName(NewGetHighLeftCol())
		    	if ( colName == 'a2_fcast_qty' ) {
		        	sheetObjects[1].SelectCell(0,eval(NewGetHighLeftCol())+1, true);
		    	} else {
		        	sheetObjects[1].SelectCell(0,eval(NewGetHighLeftCol())+2, true);
		    	}
		    	sheetObjects[1].SelectCell(0,colName, true);
		    	focFlag2=true;
	    	}
    	}
    }
    
    /**
     * handling scroll event on sheet
    */
    function sheet2_OnScroll(sheetObj, OlGetTopRow, OldLeftCol, NewGetTopRow, NewLeftCol) {
    	if (OldGetHighLeftCol()!= NewGetHighLeftCol()) {
	    	if ( focFlag2 ) {
	        	focFlag1=false;
		    	var colName=sheetObj.ColSaveName(NewGetHighLeftCol())
		    	if ( colName == 'a2_fcast_qty' ) {
		        	sheetObjects[0].SelectCell(0,eval(NewGetHighLeftCol()+5), true);
		    	} else {
		        	sheetObjects[0].SelectCell(0,eval(NewGetHighLeftCol()+6), true);
		    	}
		    	sheetObjects[0].SelectCell(0,colName, true);
	        	focFlag1=true;
	    	}
    	}
    }  
    
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		if (sheetObj.RowCount() < 1) {
			initSheet2(sheetObjects[1]);
		} else {
			initSheet2(sheetObjects[1]);
		}
		sheetObj.SetEditable(1);
	}	
	
	
	function sheet1_OnLoadFinish(sheetObj){
		
	}
   