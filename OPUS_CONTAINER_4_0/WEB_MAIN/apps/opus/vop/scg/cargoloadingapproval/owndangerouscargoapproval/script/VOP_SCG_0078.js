/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0078.jsp
 *@FileTitle : Time of SPCL CGO Request APVL
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
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0023 : business script for vop_scg_0023 
     */
   
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
	var comboCnt=0;
	var cgoTypeStrs="DG,RF,AK,BB,SS";
	var g_rTSumS2 = ""; 
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick() {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
    	try {    		
    		var eventObj=ComGetEvent();
    		var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Retrieve":
                	doActionIBSheet(sheetObj,formObj,IBSEARCH);                	
                    break;
                case "btn_new":                	
                	ComResetAll();
                	comboObjects[0].SetSelectIndex(0);
                	ComSetFocus(rgn_shp_opr_cd);   
                    setRqtDateForm(formObj, true, "fromto");
        			document.all.crr_cd[2].value="";                    
                    btnEnabled(sheetObj, false, 2);                	
                    break;
                case "btn_Detail":
                	doActionIBSheet(sheetObjects[1],formObj,IBDOWNEXCEL);                	
                	break;
                case "btn_downExcel":
                    var paramObj=new Object();
                    paramObj.title="Time of SPCL CGO Request APVL";
                    paramObj.columnwidth=ComScgGetExcelDown(sheetObj);
                    paramObj.cols=ComScgGetExcelDownCols(sheetObj);
                    var url=ComScgGetPgmTitle(sheetObj, paramObj);  
                    if(sheetObj.RowCount() < 1){//no data
                    	ComShowCodeMessage("COM132501");
                    }else{
                    	//sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
                    	//공통엑셀다운로드 - 상단타이틀적용
                    	var str = sheetObj.GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1,ReportXML:str, DownRows:"Visible"});                     	
                    }
//                	sheetObj.SpeedDown2Excel(-1,false,false,"","",false,false,"Time of SPCL CGO Request APVL",false,"");                 	
                    
                    /*var paramObj = new Object();
                    paramObj.title = "Time of SPCL CGO Request APVL";
                    var url = ComScgGetPgmTitle(sheetObj, paramObj);  
                    sheetObj.SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );*/
                    break;


                case "btn_SlanCd":
	 				onPopupClick(srcName, "Lane");
	 				break;
                case "btn_VVDpop":
	 				onPopupClick(srcName, "VVD");
	 				break;
                case "btn_Carrier":
                	if(document.all.crr_cd[2].checked) onPopupClick(srcName, "Carrier");
	 				break;
                case "btn_Calendar":
                	var cal=new ComCalendarFromTo();                	
                	cal.select(formObj.from_rqst_dt, formObj.to_rqst_dt, 'yyyy-MM-dd');	                
	 				break;
                case "crr_cd":	
                	setCarrierForm();                	
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
    //set VSL OPR input form
    function setCarrierForm() {
    	var cgoOprCdObj=document.getElementById("cgo_opr_cd");
    	var carBtnObj=document.getElementById("btn_Carrier");
		if(document.all.crr_cd[2].checked) {
			cgoOprCdObj.disabled=false;
			cgoOprCdObj.className="input1";			
			cgoOprCdObj.setAttribute("required", "true");
			carBtnObj.className="input_seach_btn";
			ComSetFocus(cgoOprCdObj);
		} else {
			cgoOprCdObj.disabled=true;
			cgoOprCdObj.className="input2";			
			cgoOprCdObj.removeAttribute("required");
			carBtnObj.className="input_seach_btn";
		}
    }
    //set Period input form
    function setRqtDateForm(formObj, what, how) {
    	var form
    	if(what) {
    		if(how.indexOf("from") != -1) ComAddSeparator(formObj.from_rqst_dt);
    		if(how.indexOf("to") != -1) ComAddSeparator(formObj.to_rqst_dt);
    	} else {
    		if(how.indexOf("from") != -1) ComClearSeparator(formObj.from_rqst_dt);
    		if(how.indexOf("to") != -1) ComClearSeparator(formObj.to_rqst_dt);
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {    	
        for(i=0;i<sheetObjects.length;i++) {
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1,cgoTypeStrs);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //Initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
       	 	initCombo(comboObjects[k], k + 1);
        }
        sheet1_OnLoadFinish(sheetObjects[0]);
        initControl();
        setRqtDateForm(document.form, true, "fromto");
        setCarrierForm();
        //ComBtnEnable(btn_Carrier);
    }
    /**
     * button deactivate/activate
     */
    function btnEnabled(sheetObj, what, kind) {
    	with(sheetObj) {    		
	      	//Enable = what;
	      	if(what) {
	      		if(RowCount()!= 0) {
		      		ComBtnEnable("btn_downExcel");
		      		if(kind > 0) ComBtnEnable("btn_Detail");
		      		else ComBtnDisable("btn_Detail");
	      		}
	      	} else {
		      	ComBtnDisable("btn_downExcel");
		      	if(kind > 0) ComBtnDisable("btn_Detail");
	      	}
    	}
    }
    /**
     * Handling sheet1 OnLoadFinish Event 
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
     function sheet1_OnLoadFinish(sheetObj) {	
    	 btnEnabled(sheetObj, false, 2);
    	 doActionIBCombo(comboObjects[0], 1);
    }
    /**
     * Handling sheet1 OnSearchEnd Event 
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
         with (sheetObj) {	
 			if(RowCount()> 0) {
 				//1. Set RSO dummy field for sub sum.
 				var preRgnShpOprCd="";
 				var subSumYn=false;
 				for(var rowCt=HeaderRows(); rowCt<=LastRow(); rowCt++) {
 					SetCellValue(rowCt, "subSumCol3",GetCellValue(rowCt, "rgn_shp_opr_cd"),0);
 					if(preRgnShpOprCd == GetCellValue(rowCt, "rgn_shp_opr_cd")) subSumYn=true;
 					preRgnShpOprCd=GetCellValue(rowCt, "rgn_shp_opr_cd");
 				}
 				//2. Set sub sum field and calculated ratio field.
 				var sumStr="", ratioStr="", colNm="", splitStr="";
 				for(var colCt=SaveNameCol("term")+1; colCt<=LastCol(); colCt++) {
 					colNm=ColSaveName(colCt);
 					splitStr=colNm.split("_");
 					sumStr += colCt;
 					if(splitStr[0] != 'o') {	 					
	 					ratioStr += colNm+"=((|o_"+colNm+"|/|o_t_"+splitStr[1]+"|)*100);";
	 					
 					}
 					if(colCt != LastCol()) sumStr += "|";
 				}

//				as-is
// 				//3. 전체 소계와 비율 행을 구성한다.
// 				ShowSubSum("subSumCol1", sumStr, 2, false, false, SaveNameCol("term"), "term=Grand TTL");
// 				ShowSubSum("subSumCol2", sumStr, 2, false, false, SaveNameCol("term"), "term=G.TTL Ratio(%);"+ratioStr);  				
// 				
// 				//4. 부분 소계와 비율 행을 구성한다.
// 				if(subSumYn) {
//	 				ShowSubSum("rgn_shp_opr_cd", sumStr, -1, false, false, SaveNameCol("term"), "term=S. TTL Ratio;"+ratioStr); 
//	 				ShowSubSum("subSumCol3", sumStr, -1, false, false, SaveNameCol("term"), "term=Sub TTL");
// 				} 				
 				
				//to-be
 				//3. Set whole sum and ratio row.
 				//3. 전체 소계와 비율 행을 구성한다.
 				
 				/*sheetObj.ShowSubSum([{StdCol:"subSumCol1", SumCols:sumStr, Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("term"), CaptionText:"Grand TTL"}]);
 				sheetObj.ShowSubSum([{StdCol:"subSumCol2", SumCols:sumStr, Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("term"),CaptionText:"G.TTL Ratio(%)"}]);	//+ratioStr??
 				//4. Set sub sum and ratio row.
 				//3. 전체 소계와 비율 행을 구성한다.
 				if(subSumYn) {
 					sheetObj.ShowSubSum([{StdCol:"rgn_shp_opr_cd", SumCols:sumStr, Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("term"), CaptionText:"S. TTL Ratio"}]);
 					sheetObj.ShowSubSum([{StdCol:"subSumCol3", SumCols:sumStr, Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("term"), CaptionText:"Sub TTL"}]);
 				}*/
 				
 				if(subSumYn) {
					var rowSum = sheetObj.FindSubSumRow("rgn_shp_opr_cd");
					var rowSum2 = sheetObj.FindSubSumRow("subSumCol3");
					if(rowSum != ""){
						var cntRow = rowSum.split("|");
						for(var i=0; i <cntRow.length; i++){
							sheetObj.SetRowHidden(cntRow[i]*1, 1);
						}
					}
					if(rowSum2 != ""){
						var cntRow = rowSum2.split("|");
						for(var i=0; i <cntRow.length; i++){
							sheetObj.SetRowHidden(cntRow[i]*1, 1);
						}
					}
					
 				}
 				
  				//SetCellFont("FontBold", HeaderRows(), 0, LastRow(), 4,1);
 				
 				//5. Control detail list button according to request numbers.
 				//var detailCtRow = FindSubSumRow("subSumCol1").split("|")[0];
  				var detailCt=GetCellValue(LastRow()-1 , "t_total");
  				btnEnabled(sheetObj, true, detailCt);
  				//resizeSheet();
  			} else {
  				btnEnabled(sheetObj, false, 2);
  			}
    	 }
    }
 	/**
     * Handling sheet1 OnChange Event 
     * param : sheetObj ==> sheet object, changed Row ==> Row, changed Col ==> Col
     */
 	function sheet1_OnDblClick(sheetObj, Row, Col, Value){	
    	with(sheetObj) {
      	}
 		return;
 	}
    /**
     * Combo selecting related event
     * move focus
     */
 	 var selComboIndex, selComboCode;
 	 function scg_flg_OnSelect(comboObj ,index, text , code) {
 	  selComboIndex = index;
 	  selComboCode = code;
 	 }
 	 function scg_flg_OnChange(comboObj) {
 	     ComSetMultiCombo2(comboObj, selComboIndex, selComboCode);
 	 }
 	 
    /**
     * Combo selecting related event
     * move focus
     */
//    function rgn_shp_opr_cd_OnChange(comboObj , Index_Code, Text) {
//          if(Text != '') ComSetFocus(document.form.option_pending[0]);
//    }
   	function rgn_shp_opr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
  		//@@document.form.rgn_shp_opr_cde_text.value 콤보 텍스트 객체명을 인식못함
    	document.form.rgn_shp_opr_cd_text.value = rgn_shp_opr_cd.GetSelectCode();
    }
    function rgn_shp_opr_cd_OnBlur() {
    	document.form.rgn_shp_opr_cd_text.value = rgn_shp_opr_cd.GetSelectText();
    }
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo, cgoType) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
        	case "sheet1":      
        		with (sheetObj) {
                    //setting height
        			
                    //setting width
//                    SheetWidth=mainTable.clientWidth;
                    //setting Host information[compulsory][HostIp, Port, PagePath]
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //Merge kind [optional, Default msNone]
//                    MergeSheet=msPrevColumnMerge + msHeaderOnly;
                    //Edit kind [optional, Default false]
//                    SetEditable(0);
                    //setting Row information[compulsory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    InitRowInfo( 2, 1, 3, 100);
                    //setting function handling header
//                    InitHeadMode(false, false, false, true, false,false);
                    SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );

                    var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                    //1. Set Cargo type
                    cgoType=ComTrim(cgoType);
                    var cTarr=cgoType.split(",");
                    if(cTarr.length<=1) cTarr=cgoType.split("|");
                    var cTarrSize=cTarr.length;
                    //2. Set dynamic header
                    var procHour=ComGetObjValue(document.form.proc_hour);
                    var HeadTitle1="|||RSO|Term";
                    for(var hCt1=0; hCt1<cTarrSize; hCt1++) {
                    	cgoType=cTarr[hCt1];
                    	HeadTitle1 += "||||"+cgoType+"|"+cgoType+"|"+cgoType;
                    }
                    HeadTitle1 += "||||Total|Total|Total";
                    var HeadTitle2="|||RSO|Term";
                    for(var hCt2=0; hCt2<cTarrSize; hCt2++) {
                    	HeadTitle2 += "||||TTL No.\nof Requested|Processing Time\n(within "+procHour+" hrs)|Processing Time\n(over "+procHour+" hrs)";  
                    }
                    HeadTitle2 += "||||TTL No.\nof Requested|Processing Time\n(within "+procHour+" hrs)|Processing Time\n(over "+procHour+" hrs)";
                    var headCount=ComCountHeadTitle(HeadTitle1);
                    //setting Column information[compulsory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    //(headCount, 5, 0, true);
                    //header row info[compulsory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle1, true);
//                    InitHeadRow(1, HeadTitle2, true);
//                    //data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtHidden,       50,    daCenter,  true,     "subSumCol1",     	    false,          "1",     dfNone ,      0,      false,     false);
//                    InitDataProperty(0, cnt++ , dtHidden,       50,    daCenter,  true,     "subSumCol2",     	    false,          "1",     dfNone ,      0,      false,     false);
//                    InitDataProperty(0, cnt++ , dtHidden,       50,    daCenter,  true,     "subSumCol3",     	    false,          "",      dfNone ,      0,      false,     false);
//                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,     "rgn_shp_opr_cd",     	false,          "",      dfNone ,      0,      false,     false);
//                    InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  true,     "term",     			false,          "",      dfNone ,      0,      false,     false);
//                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},
                                  { Text:HeadTitle2, Align:"Center"},];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"subSumCol1",      KeyField:0,   CalcLogic:"1",  Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"subSumCol2",      KeyField:0,   CalcLogic:"1",  Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"subSumCol3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_shp_opr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"term",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    //3. Set dynamic column              
                    for(var cCt=0; cCt<cTarrSize; cCt++) {
                    	cgoType=cTarr[cCt].toLowerCase();
//                    	InitDataProperty(0, cnt++ , dtHidden,      	100,   daRight,   true,     "o_t_"+cgoType,     	false,          "|t_"+cgoType+"|",  	 dfInteger ,      0,      false,     false);
//                    	InitDataProperty(0, cnt++ , dtHidden,      	100,   daRight,   true,     "o_in_"+cgoType,     	false,          "|in_"+cgoType+"|",   	 dfInteger ,      0,      false,     false);
//						InitDataProperty(0, cnt++ , dtHidden,      	100,   daRight,   true,     "o_out_"+cgoType,     	false,          "|out_"+cgoType+"|",     dfInteger ,      0,      false,     false);
//                    	InitDataProperty(0, cnt++ , dtData,      	100,   daRight,   true,     "t_"+cgoType,     		false,          "",      				 dfInteger ,      0,      false,     false);
//						InitDataProperty(0, cnt++ , dtData,      	100,   daRight,   true,     "in_"+cgoType,     		false,          "",      				 dfInteger ,      0,      false,     false);
//						InitDataProperty(0, cnt++ , dtData,      	100,   daRight,   true,     "out_"+cgoType,     	false,          "",      				 dfInteger ,      0,      false,     false);
                    	cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"o_t_"+cgoType,   KeyField:0,   CalcLogic:"|t_"+cgoType+"|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"o_in_"+cgoType,  KeyField:0,   CalcLogic:"|in_"+cgoType+"|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"o_out_"+cgoType, KeyField:0,   CalcLogic:"|out_"+cgoType+"|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"t_"+cgoType,     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"in_"+cgoType,    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"out_"+cgoType,   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } );
                    }
                    var rTSumS1="";
                    var rTSumS2="";
                    var rISumS1="";
                    var rISumS2="";
                    var rOSumS1="";
                    var rOSumS2="";
                    for(var colCt=4; colCt<cols.length-1 - cTarrSize * 2;) {
//                    var lastColNum = cols.length - cTarrSize;
//                    for(var colCt=SaveNameCol("term"); colCt<lastColNum;) {
                    	rTSumS1  += "|"+(++colCt)+"|+";
                        rISumS1  += "|"+(++colCt)+"|+";
                        rOSumS1  += "|"+(++colCt)+"|+";
                        rTSumS2  += "|"+(++colCt)+"|+";
                        rISumS2  += "|"+(++colCt)+"|+";
                        rOSumS2  += "|"+(++colCt)+"|+";
//                        if(colCt != lastColNum) rOSumS2 += "+";
                    }
                	rTSumS1 = rTSumS1.replace(/\+$/gi,"");
                	rISumS1 = rISumS1.replace(/\+$/gi,"");
                	rOSumS1 = rOSumS1.replace(/\+$/gi,"");
                	rTSumS2 = rTSumS2.replace(/\+$/gi,"");
                	rISumS2 = rISumS2.replace(/\+$/gi,"");
                	rOSumS2 = rOSumS2.replace(/\+$/gi,"");
                	
                    cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"o_t_total",    KeyField:0,   CalcLogic:rTSumS1, Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"o_in_total",   KeyField:0,   CalcLogic:rISumS1,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"o_out_total",  KeyField:0,   CalcLogic:rOSumS1,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"t_total",      KeyField:0,   CalcLogic:rTSumS2, Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"in_total",     KeyField:0,   CalcLogic:rISumS2, Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"out_total",    KeyField:0,   CalcLogic:rOSumS2, Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } );
                    
                    InitColumns(cols);
                    //SetSheetHeight(368);
                    resizeSheet();
                    SetEditable(0);

                    var sumStr="", ratioStr="", colNm="", splitStr="";
     				for(var colCt=SaveNameCol("term")+1; colCt<=LastCol(); colCt++) {
     					colNm=ColSaveName(colCt);
     					splitStr=colNm.split("_");
     					sumStr += colCt;
     					if(splitStr[0] != 'o') {	 					
    	 					ratioStr += colNm+"=((|o_"+colNm+"|/|o_t_"+splitStr[1]+"|)*100);";	 					
     					} 
     					if(colCt != LastCol()) sumStr += "|";
     				}
                    
     				//ShowSubSum([{StdCol:"subSumCol1", SumCols:sumStr, Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("term"), CaptionText:"Grand TTL"},
     				  //         {StdCol:"subSumCol2", SumCols:sumStr, Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("term"),OtherColText:"G.TTL Ratio(%);"+ratioStr}]);
     					//+ratioStr??
     				//to-be
     				//3. Set whole sum and ratio row.
     				//3. 전체 소계와 비율 행을 구성한다.
     				sheetObj.ShowSubSum([//{StdCol:"subSumCol2", SumCols:sumStr, Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("term"),CaptionText:"G.TTL Ratio(%)", OtherColText:ratioStr},
     				                     {StdCol:"subSumCol1", SumCols:sumStr, Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("term"), CaptionText:"Grand TTL"}
     	                                // {StdCol:"subSumCol3", SumCols:sumStr, Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("term"), CaptionText:"Sub TTL"},
     	                               //  {StdCol:"rgn_shp_opr_cd", SumCols:sumStr, Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("term"), CaptionText:"S. TTL Ratio"}
     	                 ]);
     				
                    
        		}
                break;
			case "sheet2" :      
				with (sheetObj) {
					var HeadTitle = "No|Lane|VVD|Pre/Trunk/Post|BKG No.|Type|REQ Seq|REQ Date|REQ ID|APVL IND|APVL Date|APVL ID|Time(hrs)";
					var headCount = ComCountHeadTitle(HeadTitle);
					(headCount, 0, 0, true);
					SetConfig({SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1});

					var info = {Sort:0, ColMove:0, HeaderCheck:0, ColResize:1};
					var headers = [{ Text:HeadTitle, Align:"Center"}];
					InitHeaders(headers, info);

					var cols = [
						{Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_pre_pst_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_apro_rqst_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rqst_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rqst_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"auth_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"auth_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"auth_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tret_gap",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
					];

					InitColumns(cols);
					SetVisible(0);
					SetEditable(0);
				}
				break;
        }
    }
    function resizeSheet(){
   	 	ComResizeSheet(sheetObjects[0]);
    }
    // event Catch Listener
    function initControl() {
         // Axon event handling1. event catch
//         axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
//         axon_event.addListenerFormat ('focus',    'obj_focus',      form);
         axon_event.addListenerFormat ('blur',     'obj_focusout',   form);
//         axon_event.addListenerForm   ('keyup',    'obj_keyup',      form);
//         axon_event.addListener       ('keydown',  'ComKeyEnter',   'form');
         axon_event.addListenerForm   ('change',   'obj_change', 	 form);
    }
    // Handling business javascript OnFocus event
    function obj_focus() {
    	switch(ComGetEvent("name")){ 
	    	case "from_rqst_dt": case "to_rqst_dt":	
	    		ComClearSeparator(ComGetEvent());
	        	break;
    	}
    }
    // Handling business javascript OnFocusOut event
    function obj_focusout() {
    	pastEventNum=0;
    	var formObj=document.form;
    	with(ComGetEvent()) {
	    	switch(name) {
		    	case "slan_cd":
		    		searchLaneCheck();						//Lane Check
		        	break;
		    	case "skd_dir_cd":	
		    		if(value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {
		    			searchVVDCheck();					//VVD Check
		    		}
		        	break;
		    	case "cgo_opr_cd":
		    		searchCarrierCheck(ComGetEvent());	//Carrier Check
		        	break;
		    	case "from_rqst_dt":	case "to_rqst_dt":	
		    		ComAddSeparator(ComGetEvent());
		    		//prohibiting retrieve period
		    		var fromDt=ComGetObjValue(formObj.from_rqst_dt);
		    		var toDt=ComGetObjValue(formObj.to_rqst_dt);
		    		if(fromDt != '' && toDt != '') {
		    			if(ComGetDaysBetween(fromDt, toDt) > 365) {
		    				ComShowCodeMessage('SCG50032', 'year');
		    				value="";
		    	 			ComSetFocus(ComGetEvent());
		    			}
		    		}
		        	break;
	    	}
	    }
    } 
    // Handling business javascript OnKeyPress event
//    function obj_keypress() {
//    	switch(ComGetEvent().dataformat){
//    	    case "engup":
//    	    	switch(ComGetEvent("name")){
//	    	    	case "proc_hour":	
//	    	    		ComKeyOnlyNumber(ComGetEvent(), '.');
//	    	    		if(event.keyCode == 46) {
//	    	    			if(ComGetEvent().value.indexOf('.') != -1 || ComGetEvent().value.length == 0) event.returnValue=false;
//	    	    		}
//	    	        	break;
//	    	    	case "slan_cd":	
//	    	        	ComKeyOnlyAlphabet('uppernum');
//	    	        	break;
//	    	    	case "vsl_cd":	
//	    	        	ComKeyOnlyAlphabet('uppernum');
//	    	        	break;
//	    	        case "skd_voy_no":	
//	        	    	ComKeyOnlyNumber(ComGetEvent());
//	    	        	break;
//	    	        case "skd_dir_cd":	
//	    	        	ComKeyOnlyAlphabet('upper');
//	    	        	break;
//	    	        case "cgo_opr_cd":	
//	    	        	ComKeyOnlyAlphabet('upper');
//	    	        	break;
//    	    	}
//    	    	break;
//    	    default:
//    	    	//common standard: English,number only
//    	    	ComKeyOnlyAlphabet("num");
//    	    	break;     
//    	}
//    }  
    // Handling business javascript OnKeyUp event
    function obj_keyup() {
    	if(event.keyCode != 9) obj_nextfocus(ComGetEvent());
    } 
    // move focus - recieved parameter HTML tag(Object)'s next HTML tag(Object)
    function obj_nextfocus(obj) {
    	var formObj=document.form;
    	var objMaxLength=obj.getAttribute("maxlength");
    	var objValue=obj.getAttribute("value");
    	if (ComChkLen(objValue, objMaxLength) == 2) {
    		if(obj.name == 'from_rqst_dt' || obj.name == 'to_rqst_dt') {
    			//only numbers - prohibiting mouse keyup
    			if(event.keyCode >= 48 && event.keyCode <=57 ) ComSetNextFocus(obj);
	    	} else {
	    		ComSetNextFocus(obj);
	    	}
    		if(obj.name == 'vsl_cd') formObj.skd_voy_no.select();
    		else if(obj.name == 'skd_voy_no') formObj.skd_dir_cd.select();
    	}
    }
    // Handling business javascript OnChange event
    function obj_change() {
    	var formObj=document.form;
    	with(ComGetEvent()) {
	    	switch(name){
		    	case "vsl_cd":		
		    		ComSetObjValue(formObj.skd_voy_no, "");
	    			ComSetObjValue(formObj.skd_dir_cd, "");
		        	break;
		    	case "skd_voy_no":		
	    			ComSetObjValue(formObj.skd_dir_cd, "");
		        	break;
		    	case "cgo_opr_cd":		
	    			formObj.crr_cd[2].value=ComGetObjValue(formObj.cgo_opr_cd);
		        	break;
	    	}
    	}
    }

	// Sheet related process handling
	function doActionIBSheet(sheetObj, formObj, sAction, source) {
		// sheetObj.ShowDebugMsg(false);
		setRqtDateForm(formObj, false, "fromto");

		switch(sAction) {        
		case IBSEARCH : // retrieve
			if (!validateForm(sheetObj,formObj,sAction)) {
				setRqtDateForm(formObj, true, "fromto");
				return;
			}
			if (ComGetObjValue(formObj.proc_hour) == '.') ComSetObjValue(formObj.proc_hour, '0.');
			// if (!validateForm(sheetObj,formObj,sAction)) return;
			sheetObj.RemoveAll();

			if (comboObjects[0].GetSelectIndex() == 0) { // All
				formObj.rgn_shp_opr_cd.value = "";
			}
/*
				with(sheetObj){
					var rTSumS1="";
					var rTSumS2="";
					var rISumS1="";
					var rISumS2="";
					var rOSumS1="";
					var rOSumS2="";
                    for(var colCt=SaveNameCol("term"); colCt<LastCol() - 4 * 2;) {
                      	rTSumS1  += "|"+ColSaveName(++colCt)+"|+";
                          rISumS1  += "|"+ColSaveName(++colCt)+"|+";
                          rOSumS1  += "|"+ColSaveName(++colCt)+"|+";
                          rTSumS2  += "|"+ColSaveName(++colCt)+"|+";
                          rISumS2  += "|"+ColSaveName(++colCt)+"|+";
                          rOSumS2  += "|"+ColSaveName(++colCt)+"|+";
//                          if(colCt != lastColNum) rOSumS2 += "+";
                      }
                      if(LastCol() > 0) {
                      	rTSumS1 = rTSumS1.replace(/\+$/gi,"");
                      	rISumS1 = rISumS1.replace(/\+$/gi,"");
                      	rOSumS1 = rOSumS1.replace(/\+$/gi,"");
                      	rTSumS2 = rTSumS2.replace(/\+$/gi,"");
                      	rISumS2 = rISumS2.replace(/\+$/gi,"");
                      	rOSumS2 = rOSumS2.replace(/\+$/gi,"");
                      }
                      g_rTSumS2 = rTSumS2;
                      //g_rTSumS2 = "|t_dg|+|t_rf|+|t_ak|+|t_bb|";
           		}
*/                  
			// Form the headers of sheet1
			sheetObjects[0] = sheetObjects[0].Reset();
			sheetObj = sheetObjects[0]; 
			initSheet(sheetObj, 1, ComGetObjValue(scg_flg));
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchData("VOP_SCG_0078GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml, {Sync:1});
			break;
		case IBDOWNEXCEL : // Detail
			var detailCt = sheetObjects[0].GetCellValue(sheetObjects[0].LastRow()-1, "t_total");
			if (parseInt(detailCt) > 20000) {
				ComShowCodeMessage('SCG50030');	//'In view of personal computer memory, possible numbers of exporting to excel will be limited to 20000.'
				break;
			}
			formObj.f_cmd.value = SEARCH01;
//			var saveFileName = sheetObj.SaveFileDialog("ExcelDown", "book1", "C:\\","엑셀파일(*.xls)|*.xls");
//			if (saveFileName == '' || saveFileName == "<USER_CANCEL>") {
//				return;
//			} else {
				ComOpenWait(true);
				// sheetObj.DoSearch("VOP_SCG_0078GS.do", FormQueryString(formObj));
				var sXml = sheetObj.GetSearchData("VOP_SCG_0078GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml, {Sync:1});
				sheetObj.Down2Excel({"DownCols":makeHiddenSkipCol(sheetObj), "SheetDesign":1, "Merge":1});
				ComOpenWait(false);
//			}
			break;
        }

		setRqtDateForm(formObj, true, "fromto");
	}

    // Combo related process handling
    function doActionIBCombo(comboObj, comboNo) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
        sheetObj.ShowDebugMsg(false);
        switch(comboNo) {
	  		case 1:    
//	  			formObj.f_cmd.value=SEARCH01;
//	  			sheetObj.SetWaitImageVisible(0);
//         		var sXml=sheetObj.GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
//        		sheetObj.SetWaitImageVisible(1);
//        		ComXml2ComboItem(sXml, rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
//        		//var initSelTxt = comboObj.FindIndex("ASR", 0);
//        		//comboObj.Text = initSelTxt;
//        		ComSetFocus(rgn_shp_opr_cd);
         		sheetObj.SetWaitImageVisible(0);
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");	
				
				comboObj.InsertItem(0, "All", "All");
				comboObj.SetSelectIndex(0);
	  			break; 
        }
    }
    /**
     * Lane Check
     */
    function searchLaneCheck() {
     	var formObj=document.form;
     	var sheetObj=sheetObjects[0];
     	var slan_cd=ComGetObjValue(formObj.slan_cd);
     	if(slan_cd != '') {
	     	var sParam=Array();
	 	  	sParam[0]="vsl_slan_cd="+slan_cd;
	 	  	sParam[3]="f_cmd="+SEARCH02;
	 	  	sheetObj.SetWaitImageVisible(0);
 	     	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
	     	sheetObj.SetWaitImageVisible(1);
	     	var vsl_slan_cd=ComScgXml2Array(sXml, "vsl_slan_cd");
	  	   	if(vsl_slan_cd == null) {
	  	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'	  		    
	  		    ComSetFocus(formObj.slan_cd);
	  	   	}
     	}
    }
    /**
     * Vessel Name retrieve
     */
    function searchVVDCheck() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var sParam=Array();
	  	sParam[0]="vsl_cd="+ComGetObjValue(formObj.vsl_cd);
	  	sParam[1]="skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
	  	sParam[2]="skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
	  	sParam[3]="f_cmd="+SEARCH05;
	  	if(sParam.join("").length > 38) {
	  		sheetObj.SetWaitImageVisible(0);
 	    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
	    	sheetObj.SetWaitImageVisible(1);
	    	var vsl_eng_nm=ComScgXml2Array(sXml, "vsl_eng_nm");
	 	   	if(vsl_eng_nm == null) {
	 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	 		    ComSetObjValue(formObj.skd_dir_cd, "");
	 		    ComSetObjValue(formObj.skd_voy_no, "");
	 		    ComSetObjValue(formObj.vsl_cd, "");
	 		    ComSetFocus(formObj.vsl_cd);
	 	   	}
	  	}
    }
    /**
     * Carrier Validation
     */
    function searchCarrierCheck(obj) {
     	var formObj=document.form;
     	var sheetObj=sheetObjects[0];
     	var sParam=Array();
 	  	sParam[0]="crr_cd="+obj.value;
 	  	sParam[3]="f_cmd="+SEARCH01;
 	  	if(sParam.join("").length > 17) {
 	  		sheetObj.SetWaitImageVisible(0);
  	    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
 	    	sheetObj.SetWaitImageVisible(1);
 	    	var crrData=ComScgXml2Array(sXml, "crr_cd");
 		   	if(crrData == null) {
 			    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 			    ComSetObjValue(obj, ""); 	 		    
	 		    ComSetFocus(obj);
 		   	} else {
 	 	   		ComSetNextFocus(obj);
 	 	   	}
 	  	}
    }
    /**
     * register IBCombo Object created in page as comboObjects list
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * Initializing Combo 
     * param : comboObj ==> combo object, comboNo ==> combo
     * adding case as numbers of counting combo 
     */ 
    function initCombo(comboObj, comboNo) {
    	switch(comboObj.options.id) {
    		case "rgn_shp_opr_cd":  
    			with(comboObj) {
					SetColAlign(0, "center");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "150");
	  				SetTitle("Code|Description");
	  				SetDropHeight(200);
    				doActionIBCombo(comboObj,comboNo);
    			}
    			break;  
	  		case "term":  
	  			addComboItem(comboObj, "M|Q|H|Y", "Monthly|Quarterly|Half-Yearly|Yearly");
	  			comboObj.SetColWidth(0, "85");
	  			comboObj.SetSelectIndex(1);
	  			break;  
	  		case "scg_flg": 
	  			var aCgoType=cgoTypeStrs.split(",");
	  			comboObj.InsertItem(0, "All", cgoTypeStrs);
	  			for (var i=1; i<=aCgoType.length; i++){
	  	     		comboObj.InsertItem(i, aCgoType[i-1], aCgoType[i-1]);    	
	  	        }
	  			comboObj.SetColWidth(0, "50");
	  			comboObj.SetMultiSeparator("|");
	  			comboObj.SetDropHeight(150);
	  			comboObj.SetMultiSelect(1);
	  			comboObj.SetUseAutoComplete(0);
	  			comboObj.SetSelectIndex(0);
	  			break; 
	  	}
    }
    /**
     * Add Combo 
     */	
    function addComboItem(comboObj, itemValStr, itemTxtStr) {
     	var itemValArr=itemValStr.split("|");
        var itemTxtArr=itemTxtStr.split("|");
     	for (var i=0; i<itemValArr.length; i++) {
     		comboObj.InsertItem(i, itemTxtArr[i], itemValArr[i]);    	
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
    	 switch(sAction) {
	    	case IBSEARCH:
	    		//Check requirement
		    	if(ComGetObjValue(document.all.from_rqst_dt) == '') {
    	 			ComShowCodeMessage('SCG50007', 'Period');
    	 			ComSetFocus(formObj.from_rqst_dt);
    	 			return;
		    	}
		    	if(ComGetObjValue(document.all.to_rqst_dt) == '') {
    	 			ComShowCodeMessage('SCG50007', 'Period');
    	 			ComSetFocus(formObj.to_rqst_dt);
    	 			return;
		    	}
		    	if(!ComChkValid(formObj, true, false, false)) 
		    		return false;
	    		break;
		}
	    return true;
    }
    /**
     * Clicing popup in retrieve condition
     */
    function onPopupClick(srcName, srcType){
    	if (srcType == "Lane") {
   		 	ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0202.do', 426, 470, "sheet1_vsl_slan_cd:slan_cd", "0,0", true);
   	 	} else if (srcType == "VVD") {
			var vsl_cd=ComGetObjValue(document.form.vsl_cd);
        	var sUrl="";
        	if(vsl_cd == ""){
        		sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
        		ComOpenPopupWithTarget(sUrl, 463, 500, "vsl_cd:vsl_cd", "0,0", true);
        	}else{
        		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
        		ComOpenPopupWithTarget(sUrl, 335, 420, "skd_voy_no:skd_voy_no|skd_dir_cd:skd_dir_cd", "0,0", true);
        	}
   	 	} else if (srcType == "Carrier") {
	 		ComOpenPopupWithTarget('/opuscntr/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.cgo_opr_cd), 423, 450, "crr_cd:cgo_opr_cd", "0,0,1,1,1", true);
   	 	}
    }
