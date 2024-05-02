/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_024.js
*@FileTitle  : SPC Control J/O Slot Creation/Retrieve
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var aryNo1=0;      
var aryNo2=0;     
var sheet_height1=16; 
var sheet_height2=16; 
var first_load1=true;
var first_load2=true;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
var ZOOM_IN = "Zoom in(+)";
var ZOOM_OUT = "Zoom out(-)";
document.onclick=processButtonClick;
    /**
     * Event Handler to branch off from the process according to button name 
     */
    function processButtonClick(){
    	var sheetObject0 = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];

        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_new":
                	sheetObject0.RemoveAll();
                    formObject.reset();
                    break;
                case "btn_retrieve":
                    if(formObject.rdoOp_cd[0].checked){
                        doActionIBSheet(sheetObject0,formObject,IBSEARCH);
                    }else{
                        doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
                    }
                    break;
                case "btn_save":
                    if(formObject.rdoOp_cd[0].checked){
                        doActionIBSheet(sheetObject0,formObject,IBSAVE);
                    }else{
                        doActionIBSheet2(sheetObject1,formObject,IBSAVE);
                    }
                    break;
                case "btn_downexcel":
                	if(formObject.rdoOp_cd[0].checked){
    					doActionIBSheet(sheetObject0,formObject,IBDOWNEXCEL);	
    				}else if(formObject.rdoOp_cd[1].checked){							
    					doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
					}
					break;
                case "btns_calendar1":
                     var cal=new ComCalendar();
                     cal.select(formObject.txtSDate, 'yyyy-MM-dd');
                    break;
                case "btns_calendar2":
                     var cal=new ComCalendar();
                     cal.select(formObject.txtEDate, 'yyyy-MM-dd');
                    break;
                    
//				2014.10.21 김용습 - zoom 기능 수정(펼쳤을 때 시트의 높이가 모든 열의 높이의 합 + 150px이 되도록)
    			case "btn_zoom_in_1":
    			case "btn_zoom_in_2":
					if (document.form.rdoOp_cd[0].checked) {
						var rowcount = sheet1.RowCount(); // 시트의 열 개수
						var totalrowheight = 0; // 총 열 높이의 합 초기화												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet1.GetRowHeight(y); // 모든 열의 높이의 합 구하기
						}			
						if(totalrowheight+150 > 450){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet1.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						}
                    } else {
                    	var rowcount = sheet2.RowCount(); // 시트의 열 개수
						var totalrowheight = 0; // 총 열 높이의 합 초기화												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet2.GetRowHeight(y); // 모든 열의 높이의 합 구하기
						}						
						if(totalrowheight+150 > 450){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet2.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						}	
                    }
					setBtnZoom(ZOOM_IN);
					break;
    			case "btn_zoom_out_1":
				case "btn_zoom_out_2":
//					if (document.form.rdoOp_cd[0].checked) {
//						sheet_height1 = ComGetSheetViewRows(sheet1,"MIN", 0);
////						sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, 26));
//						sheet1.SetSheetHeight(450);
//                    } else {
//                    	sheet_height2 = ComGetSheetViewRows(sheet2,"MIN", 0);
////						sheet2.SetSheetHeight(ComGetSheetHeight(sheet2, 26));
//                    	sheet2.SetSheetHeight(450);
//                    }
					setBtnZoom(ZOOM_OUT);
					resizeSheet();
					break;
				case "rdoOp_cd":
					if (formObject.rdoOp_cd[0].checked) { //JO �좏깮��
						document.getElementById("rdoLayer1").style.display="inline";
						document.getElementById("rdoLayer2").style.display="none";
//						2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
						setBtnZoom(ZOOM_OUT);
					} else if (formObject.rdoOp_cd[1].checked) { //SC �좏깮��
						document.getElementById("rdoLayer1").style.display="none";
						document.getElementById("rdoLayer2").style.display="inline";
//						2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
						setBtnZoom(ZOOM_OUT);
					}
					resizeSheet();
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
     * Registering IBSheet Object as Array
     * The process using array can be added in case of needing to handling the others at once
     * Defining the array at the top of the source
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Registering IBCombo Object as Array
     * The process using array can be added in case of needing to handling the others at once
     * Defining the array at the top of the source
     */
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	}
    /**
     * Sheet basic setting and initialization
     * Setting on Load event handler of body tag
     * Adding the function for preceding process after loading 
     */
    function loadPage(jHeader, sHeader) {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            
//          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
//          rdoLayer1.style.display="inline";
//          rdoLayer2.style.display="inline";
            document.getElementById("rdoLayer1").style.display="inline";
            document.getElementById("rdoLayer2").style.display="inline";
            
            initSheet(sheetObjects[i],i+1, jHeader, sHeader);
            
//          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
//          rdoLayer2.style.display="none";
            document.getElementById("rdoLayer2").style.display="none";
            
            ComEndConfigSheet(sheetObjects[i]);
        }
        loadingMode=true;
		loadCombo();
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		loadingMode=false;
		resizeSheet();
    }
 	function loadCombo() {
     	var formObj=document.form;
  		var sXml=formObj.sXml.value;
  		var arrXml=sXml.split("|$$|");
 		var rtnArr=null;
 		var bsaKind="";
 		var codeArr=null;
 		var nameArr=null;
 		var checked="";
 		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], cobLane, "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], cobDir, "code", "code");
		// JO/SC CheckBox Setting
		if (arrXml.length > 3){
			rtnArr=ComXml2ComboString(arrXml[3], "code", "name");
			codeArr=rtnArr[0].split("|");
			nameArr=rtnArr[1].split("|");
			for(var i=0; i<codeArr.length; i++){
				if (i == 0)
					checked="checked";
				else
					checked="";
				bsaKind += "\n";
				bsaKind += "<input type=\"radio\" name=\"rdoOp_cd\" id=\"rdoOp_cd"+[i]+"\" value=\""+codeArr[i]+"\" class=\"trans\""+checked+">"+nameArr[i]+"</input>";
				if(i < codeArr.length)
					bsaKind += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			}
			document.getElementById("div_bsaKind").innerHTML="<div id=\"div_bsaKind\">"+ bsaKind +"</div>";
		}
  		document.form.sXml.value="";
      }
 	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo, jHeader, sHeader) {
        var cnt=0;
        var aryNM="";
        var colNo=0;
        var formObj=document.form;
        var selOp_jb_cd="";
        for(k=0; k<formObj.rdoOp_jb_cd.length; k++){
            if(formObj.rdoOp_jb_cd[k].checked) selOp_jb_cd=formObj.rdoOp_jb_cd[k].value;
        }
        switch(sheetNo) {
            case 1:      //sheet1 init
                if(jHeader != ""){ 
                     aryNM=jHeader.split("|");
                } else {
                     aryNM="crr|crr|crr|crr|crr".split("|");
                }
                aryNo1=aryNM.length;
                colNo=aryNo1 + 17;
                with (sheet1) {
                    var txtTitle="Other Carrier's Final BSA after Slot Swap for SPC Control"
                    var HeadTitle0="STS|SEL|BSA\nSEQ|From|To|Trade|R.Lane|Dir.|OPR|VVD|VSL\nCapa.|vsl_capa|BSA\nCapa.|Own Vsl\nWeight|Final\nCompany BSA";
                    for(j = 0; j < aryNo1; j++){
                    	HeadTitle0 = HeadTitle0 + "|" + txtTitle;
                    }
                    HeadTitle0 = HeadTitle0 + "|Others' Swap\nNotice|compare";
                    
//                  2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
                    HeadTitle0 = HeadTitle0 + "| |";
                    
                    j=0;
                    var HeadTitle1="STS|SEL|BSA\nSEQ|From|To|Trade|R.Lane|Dir.|OPR|VVD|VSL\nCapa.|vsl_capa|BSA\nCapa.|Own Vsl\nWeight|Final\nCompany BSA"
                    for(j=0; j<aryNo1; j++){
                    	HeadTitle1=HeadTitle1 + "|" + aryNM[j];
                    }
                    HeadTitle1=HeadTitle1 + "|Others' Swap\nNotice|compare";
                    
//                  2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
                    HeadTitle1 = HeadTitle1 + "| |";

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:15, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle0, Align:"Center"},
                                	{ Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chkBox" },
						         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bsa_seq",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bsa_fm_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bsa_to_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vsl_capa",                      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"bsa_capa",                      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    if(selOp_jb_cd == "009"){
                    	cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"ownr_vsl_wgt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
                    }else{
                    	cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"ownr_vsl_wgt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                    }
                    cols.push({Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:1,   SaveName:ConstantMgr.getCompanyCode(),    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
                    for(j = 0; j < aryNo1; j++) {
                    	cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:aryNM[j],    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
                    }
                    	
                    cols.push({Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"swapYN",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                    cols.push({Type:"Text",      Hidden:1, Width:300,  Align:"Center",  ColMerge:1,   SaveName:"compare",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                    
//                  2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
                    cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                    
                    InitColumns(cols);
                    SetHeaderRowHeight(10);

                    SetEditable(1);//Editkind
                    if (first_load1 == true) {
			    	  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height1));
                    }
                	first_load1=false;
//                	SetRangeBackColor(1, 14, 1, 14 + aryNo1, "#D3DBFF");
//                	SetSheetHeight(450);
                	
//                  2014.10.23 김용습 - 헤더 툴팁 적용
                	for(z=0; z<=cols.length; z++){    					   					
    					if(GetCellValue(0,z) == "Other Carrier's Final BSA after Slot Swap for SPC Control"){
    						SetToolTipText(0, z, "Other Carrier's Final BSA after Slot Swap for SPC Control");
    					}	
    				}
                	
                	SetEditArrowBehavior(3); 
                }
                break;
            case 2:      //sheet1 init
                if(sHeader != ""){ 
                     aryNM=sHeader.split("|");
                } else {
                     aryNM="crr|crr|crr|crr|crr".split("|");
                }
                aryNo2=aryNM.length;
                colNo=aryNo2 + 11;
                
                with (sheet2) {
                    var txtTitle="Other Carrier's Final BSA after Slot Swap for SPC Control"
                    var HeadTitle0="STS|BSA\nSEQ|From|To|Trade|R.Lane|Dir.|VVD|Vessel|V.Seq|Final\nCompany BSA";
                    for(j=0; j<aryNo2; j++){
                    	HeadTitle0=HeadTitle0 + "|" + txtTitle;
                    }
                    
//                  2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
                    HeadTitle0 = HeadTitle0 + "| |";
                    
                    j=0;
                    var HeadTitle1="STS|BSA\nSEQ|From|To|Trade|R.Lane|Dir.|VVD|Vessel|V.Seq|Final\nCompany BSA";
                    for(j=0; j<aryNo2; j++){
                    	HeadTitle1=HeadTitle1 + "|" + aryNM[j];
                    }
                    
//                  2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
                    HeadTitle1 = HeadTitle1 + "| |";

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:11, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle0, Align:"Center"},
                                    { Text:HeadTitle1, Align:"Center"} ];
                    
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bsa_seq",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bsa_fm_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bsa_to_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_seq",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"AutoSum",   Hidden:0, Width:65,  Align:"Right",   ColMerge:1,   SaveName:ConstantMgr.getCompanyCode(),    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                    
                    for(j = 0; j < aryNo2; j++) {
                    	cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:aryNM[j], KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
                    }
                    
//                  2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
                    cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

                    InitColumns(cols);
                    
                    SetHeaderRowHeight(10);
//                    SetRangeBackColor(1, 10, 1, 10 + aryNo2, "#D3DBFF");

                    SetEditable(1);//Editkind[option,Defaultfalse]
                    if (first_load2 == true) { 
			    	  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height2)); 
                    }
                    first_load2=false;
                    
//                    SetSheetHeight(450);
                    
//                    2014.10.23 김용습 - 헤더 툴팁 적용
                    for(z=0; z<=cols.length; z++){    					   					
    					if(GetCellValue(0,z) == "Other Carrier's Final BSA after Slot Swap for SPC Control"){
    						SetToolTipText(0, z, "Other Carrier's Final BSA after Slot Swap for SPC Control");
    					}	
    				}
                    
                    SetEditArrowBehavior(3); 
                }
                break;
        }
    }
    /**
 	 * Setting combo 
 	 */
    function initCombo (comboObj, comboNo) {
 		with (comboObj) {
 			SetDropHeight(300);
 			comboObj.InsertItem(0, 'All' ,''); 
 			SetSelectIndex(0);
 			ValidChar(2,1);
 		}
 	}
    
    function callBackExcelMethod(excelType){
    	//sheetObj.SpeedDown2Excel(-1);
        //var excelType=selectDownExcelMethod(sheet1);        
        var sheetObj ;
		var formObject=document.form;
		if(formObject.rdoOp_cd[0].checked){
			sheetObj = sheet1;
		} else if(formObject.rdoOp_cd[1].checked){
			sheetObj = sheet2;				
		}
        switch (excelType) {
   	 case "AY":
         sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1});
         break;
	 case "AN":
         sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0});
         break;
	 case "DY":
         sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
         break;
	 case "DN":
         sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0 });
         break;
        }               
    }
    
    /**
     * Handling the process realated with sheet
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheet1.ShowDebugMsg(false);
        var sheet2=sheetObjects[1];
        formObj.target="";
        switch(sAction) {
            case IBSEARCH:      
                if(!validateForm(sheet1,formObj,sAction)) return false;
                formObj.f_cmd.value=SEARCHLIST01;
                sheet1.DoSearch("ESM_BSA_0024GS.do", bsaFormString(formObj, getParam(curPgmNo)));
                ComOpenWait(false);
                break;
            case IBSAVE:        
                if(!validateForm(sheet1,formObj,sAction))return false;
                formObj.f_cmd.value=MULTI01;
                sheet1.DoSave("ESM_BSA_0024GS.do", bsaFormString(formObj, getParam(curPgmNo,'S')), -1, true);
                
//				2015.06.06 김용습 - 저장 완료 메시지 추가
//				ComShowCodeMessage("BSA10047");
				
                break;
            case IBCREATE:     
                if(!validateForm(sheet1, formObj, sAction)) return false;
                formObj.f_cmd.value=COMMAND01;
                sheet1.DoSearch("ESM_BSA_0024GS.do", bsaFormString(formObj, getParam(curPgmNo,{Append:S})));
                break;
            case IBDOWNEXCEL:    
//            	2014.12.29 김용습 - sheetObj가 아니라 sheet 번호를 담아 보내야 라디오 버튼을 변경하였을 시에도 엑셀 다운 기능이 정상적으로 작동함
//            	var excelType=selectDownExcelMethod(sheetObj);
            	var excelType=selectDownExcelMethod(sheet1);
//            	selectDownExcelMethod(sheetObj); 	           
				break;                
        }
    }
    /**
     *  Handling the process realated with sheet
     */
    function doActionIBSheet2(sheetObj, formObj, sAction) {
        sheet2.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:          
                if(!validateForm(sheet2, formObj, sAction)) return false;
                formObj.f_cmd.value=SEARCHLIST03;
                sheet2.DoSearch("ESM_BSA_0024GS2.do", bsaFormString(formObj, getParam(curPgmNo)));
                ComOpenWait(false);
                break;
            case IBSAVE:           
                if(!validateForm(sheet2, formObj, sAction)) return false;
                formObj.f_cmd.value=MULTI03;
                sheet2.DoSave("ESM_BSA_0024GS2.do", bsaFormString(formObj, getParam(curPgmNo,'S')), -1, true);
                
//				2015.06.06 김용습 - 저장 완료 메시지 추가
//				ComShowCodeMessage("BSA10047");
				
                break;
            case IBDOWNEXCEL:  
//            	2014.12.29 김용습 - sheetObj가 아니라 sheet 번호를 담아 보내야 라디오 버튼을 변경하였을 시에도 엑셀 다운 기능이 정상적으로 작동함
//            	var excelType=selectDownExcelMethod(sheetObj);
            	var excelType=selectDownExcelMethod(sheet2);	           
				break;
        }
    }
    /**
     * Other Carrier's Slot Swap PopUp page Open
     */
    function sheet1_OnDblClick(sheetObj , row, col , value) {
        var formObj=document.form;
        var findRows="";
        //var findStr = "";
        var pBsa_seq="";
        var pTrd_cd="";
        var pRlane_cd="";
        var pDir_cd="";
        var pVop_cd="";
        var pVsl_capa="";
        var pBsa_op_cd="";
        var pBsa_op_jb_cd="";
        var pBsa_fm_dt="";
        var pBsa_to_dt="";
        var selRow="";
        var param="";
        // showing Pop up in case of joint operating
        //------------------------------------------------------------------------
        if(formObj.rdoOp_jb_cd[0].checked && sheetObj.ColSaveName(col)== "swapYN"){
            //Double Clicked row is selected as default
            //----------------------------------------------------
            sheetObj.SetCellValue(row, "chkBox",1);
            // convering the information of seleted into string
            //----------------------------------------------------------------
			pBsa_seq=sheetObj.GetCellValue(row, "bsa_seq");
			pTrd_cd=sheetObj.GetCellValue(row, "trd_cd");
			pRlane_cd=sheetObj.GetCellValue(row, "rlane_cd");
			pDir_cd=sheetObj.GetCellValue(row, "dir_cd");
			pVop_cd=sheetObj.GetCellValue(row, "vop_cd");
			pVsl_capa=sheetObj.GetCellValue(row, "vsl_capa");
			pBsa_fm_dt=sheetObj.GetCellValue(row, "bsa_fm_dt");
			pBsa_to_dt=sheetObj.GetCellValue(row, "bsa_to_dt");
            pBsa_op_cd="J";
            pBsa_op_jb_cd="";
            for(i=0; i<formObj.rdoOp_jb_cd.length; i++){
                if(formObj.rdoOp_jb_cd[i].checked){
                  pBsa_op_jb_cd=formObj.rdoOp_jb_cd[i].value;
                }
            }
            // Making specific value of selected row xml-string.
            //-----------------------------------------------------------------
//            var sXml = ComMakeSearchXml(sheetObj, false, "chkBox","ibflag|bsa_seq|trd_cd|rlane_cd|dir_cd|vop_cd|vsl_capa|bsa_fm_dt|bsa_to_dt");
//            formObj.sXml.value= sXml;
            param="?pBsa_seq="+pBsa_seq
                       +"&pTrd_cd="+pTrd_cd
                       +"&pRlane_cd="+pRlane_cd
                       +"&pDir_cd="+pDir_cd
                       +"&pVop_cd="+pVop_cd
                       +"&pVsl_capa="+pVsl_capa
                       +"&pBsa_op_cd="+pBsa_op_cd
                       +"&pBsa_op_jb_cd="+pBsa_op_jb_cd
                       +"&pBsa_fm_dt="+pBsa_fm_dt
                       +"&pBsa_to_dt="+pBsa_to_dt
                       +"&f_cmd="+SEARCH
                       +"&sRow="+row;
//                       +"&sXml="+sXml;
            formObj.f_cmd.value=SEARCH;
//            ComOpenWindow('ESM_BSA_0122.do'+param, '', 'width=685,height=450,menubar=0,status=0,scrollbars=0,resizable=0',true);
            ComOpenWindowCenter('ESM_BSA_0122.do'+param, '', 605,360,true);
        }
     }
    /**
     * retrieve after SLOT SWAP
     */
    function retrieve(){
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        doActionIBSheet(sheetObj,formObj,IBSEARCH);
    }
    function checkFalse(){
        var sheetObj=sheetObjects[0];
        sheetObj.CheckAll("chkBox",0);
    }
    /**
     * in case of changing sheet data
     */
    function sheet1_OnChange(sheetObj, row, col, value){
        var formObj=document.form;
        var selOp_jb_cd="";
        for(k=0; k<formObj.rdoOp_jb_cd.length; k++){
            if(formObj.rdoOp_jb_cd[k].checked) selOp_jb_cd=formObj.rdoOp_jb_cd[k].value;
        }
        // 009
        //----------------------------------------------------
        if(selOp_jb_cd == "009") {
            // Colculating Company Info
            // Own Vessel Weight - SUM(Carrier)
            //------------------------------------------------------------------------
            if( !ConstantMgr.isCompanyCode(sheetObj.ColSaveName(col)) ){
                var aryNM=formObj.jHeader.value.split("|");
                var aryNo=aryNM.length;
                var sumCrr="0";
                if(sheetObj.GetCellValue(row, "ownr_vsl_wgt") == "0"){
                	// Checking not to changing company by changing other carrier in case own vessel weight = 0
                    //----------------------------------------------------------------
                    if(sheetObj.ColSaveName(col) == "ownr_vsl_wgt"){
//                        sheetObj.CellValue(row, ConstantMgr.getCompanyCode()) = "0";
                    	sheetObj.SetCellValue(row, ConstantMgr.getCompanyCode(),"0");
                    }
                    //----------------------------------------------------------------
                } else {
                    //
                    for(j=0; j<aryNo; j++){
                    	sumCrr=parseFloat(sumCrr) + parseFloat(sheetObj.GetCellValue(row, aryNM[j]));
                    }
                    sheetObj.SetCellValue(row, ConstantMgr.getCompanyCode(),parseFloat(sheetObj.GetCellValue(row, "ownr_vsl_wgt")) - parseFloat(sumCrr));
                }
            }
        }
    }
    /**
     *
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var rows=sheetObj.RowCount();
        var formObj = document.form;
        
        for ( var i = 1; i < rows + 1; i++){
        	sheetObj.SetCellFontUnderline(i, "a", 1);
        }
        //sheetObj.SetSumText(0,0,"");
        //sheetObj.SetSumText(0,1,"");
        //sheetObj.SetSumText(0,2,"");
        sheetObj.SetSumText("bsa_to_dt","TOTAL" );
        //isExcludZero媛�泥댄겕 ��寃쎌슦 total媛믪씠 0�몄뺄�쇱� Hidden�쒗궓��
        //Making the column hidden in case isExcludZero is checked and total value is zero.
        
        if(document.form.isExcludZero.checked) {
        	
//        	sheetObj.SetFrozenCol(1);
    		sheetObj.RenderSheet(0);
    		var count = 0;
    		
//    		2014.12.05 김용습 - only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//    		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
    		var sum = 0;  
    		for(var k=0; k<=sheetObj.LastCol()-3; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    		    			  			
    			if(k >= 14){ // 2014.12.23 김용습 - 14번째 컬럼이 선사들이 나오기 시작하는 컬럼
    				sum = sum + sheetObj.GetSumValue(0,k);
    			}    			    			
            }
        	
//    		2014.12.05 김용습
    		if(sum==0){
    			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
    		}else{
    			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
    		}
    		
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경, 히든인 12번째 컬럼(vsl_capa)의 히든 설정이 풀리지 않게 k가 13부터 시작되게 함
            for(var k=13; k<=sheetObj.LastCol()-3; k++) {
            	
//            	2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
            	sheetObj.SetColHidden(k,0);
            	
                //if(k >= 12 && sheetObj.ColSaveName(k) != "swapYN" && sheetObj.ColSaveName(k) != "compare"){
                if(k >= 14 && sheetObj.ColSaveName(k) != "swapYN" && sheetObj.ColSaveName(k) != "compare"){
                	//if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
                	if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
                        sheetObj.SetColHidden(k,1);
                        
                        sheetObj.SetColWidth(k,0);
                    }else {
        				sheetObj.SetColHidden(k, 0);
        				
//        	    	    2014.12.10 김용습 - 12번째 이후의 컬럼만 width 65가 강제 세팅 되도록 함
        				if(k>12){
        					sheetObj.SetColWidth(k,65);
        				}
        				
        				count = k ;
        			}
                }                
            }
            sheetObj.RenderSheet(1);
            
            if(formObj.rdoOp_jb_cd[0].checked){  
            	if(count > 15){
        			sheetObj.SetFrozenCol(15);
        		}  
            }else{
            	
            	if(count > 14){
        			sheetObj.SetFrozenCol(14);
        		}
            }
            
        } else {
        	if(formObj.rdoOp_jb_cd[0].checked){   
            	sheetObj.SetFrozenCol(15);
            }else{
        		sheetObj.SetFrozenCol(14);
            }
        	
    		sheetObj.RenderSheet(0);
    		
//        	2014.12.05 김용습 - only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
        	sheetObj.SetColHidden(sheetObj.LastCol(),1);
        	
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
            for(var k=0; k<=sheetObj.LastCol()-3; k++) {
                if(k >= 14 && sheetObj.ColSaveName(k) != "swapYN" && sheetObj.ColSaveName(k) != "compare"){
                	//if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
                	if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
                        sheetObj.SetColHidden(k,0);                        
                    }
//                	2014.12.01 김용습 - 12번째 이후의 열만 width가 65로 강제 세팅 되도록 함
    				if(k>12){
    					sheetObj.SetColWidth(k,65);
    				}
                }
            }	
            sheetObj.RenderSheet(1);
        }
    }
    
    /**
     *
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){    	
    	//sheetObj.SetSumText(0,0,"");
    	//sheetObj.SetSumText(0,1,"");
    	sheetObj.SetSumText("bsa_to_dt","TOTAL");
       //Making the column hidden in case isExcludZero is checked and total value is zero.

        if(document.form.isExcludZero.checked) {
        	
//        	sheetObj.SetFrozenCol(1);
    		sheetObj.RenderSheet(0);
    		var count = 0;
    		
//    		2014.12.05 김용습 - only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//    		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
    		var sum = 0;  
    		for(var k=0; k<=sheetObj.LastCol()-1; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    		    			  			
    			if(k >= 10){ 
    				sum = sum + sheetObj.GetSumValue(0,k);
    			}    			    			
            }
    		
//    		2014.12.05 김용습
    		if(sum==0){
    			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
    		}else{
    			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
    		}
    		
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
            for(var k=0; k<=sheetObj.LastCol()-1; k++) {
            	
//            	2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
            	sheetObj.SetColHidden(k,0);
            	
                if(k >= 10){ 
                	//if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
                	if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
                        sheetObj.SetColHidden(k,1);
                        sheetObj.SetColWidth(k,0);
                    } else
                    {
//                    	2014.12.01 김용습 - 8번째 이후 컬럼의 width만 65로 강제 설정되도록 함
                    	if(k>8){
                    		sheetObj.SetColWidth(k,65);
                    	}
                    	
                    	count = k ;	
                    }
                }
            }
            sheetObj.RenderSheet(1);
            
            if(count > 11){
//            	2014.12.08 김용습 - BSA 라디오 버튼 선택해 놓았을 때만 SetFrozenCol(11) 적용되게 함
            	if(String(sheetObj.GetCellValue(0,11)) == "Final\nCompany BSA"){
            		sheetObj.SetFrozenCol(11);
            	}
        	} 
            
        } else {
        	
//        	2014.12.08 김용습 - BSA 라디오 버튼 선택해 놓았을 때만 SetFrozenCol(11) 적용되게 함
        	if(String(sheetObj.GetCellValue(0,11)) == "Final\nCompany BSA"){
        		sheetObj.SetFrozenCol(11);
        	}
        	
        	sheetObj.RenderSheet(0);
        	
//        	2014.12.05 김용습 - only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
        	sheetObj.SetColHidden(sheetObj.LastCol(),1);
        	
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
            for(var k=0; k<=sheetObj.LastCol()-1; k++) {
                if(k >= 9){ 
                    sheetObj.SetColHidden(k, 0);
//                	2014.12.01 김용습 - 8번째 이후 컬럼의 width만 65로 강제 설정되도록 함
                	if(k>8){
                		sheetObj.SetColWidth(k,65);
                	}
                }
            }
            sheetObj.RenderSheet(1);
        }
    }
    /**
     * Refreshing rlane list in case of changing trade code
     */
    function cobTrade_OnChange(obj){
		if (loadingMode == true) return; 
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var param="";
		var trd_cd="";
		sheetObj.SetWaitImageVisible(0);
		if(obj.GetSelectText()!= ""){
			trd_cd=obj.GetSelectCode();
			param="f_cmd="+SEARCHLIST01;
			param=param+"&trd_cd="+trd_cd;
			param=param+"&code=rLane";
			var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], cobLane, "code", "code");
			cobLane.SetSelectIndex(0);
		}
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * Handling script in case of changing basa_op_jb_cd
     * showing others swap item in case it's BSA
     * No modification carrier capa in case it's TTL Weight   
     */
    function chgBsaOpJb(values, title){
        var formObj=document.form;
        var sheetObj;
        if(formObj.rdoOp_cd[0].checked){
            sheetObj=sheetObjects[0];
        }else{
            sheetObj=sheetObjects[1];
        }
        // Showing different Final Company Info according to  BSA or op_jb_cd
        // Handling  otheros Swap in case of it's Joint Operation BSA
        //------------------------------------------------------------------------------
        if(formObj.rdoOp_cd[0].checked){
    		//----------------------------------------------
    		sheet1.SetVisible(0);
    		sheet1.RenderSheet(0);
    		//sheet1.RemoveAll();
//    		sheet1.Reset();
    		sheet1 = sheet1.Reset();					//SJH.20150512.공통변경에 따른 수정
    		sheetObjects[0] = sheet1;					//SJH.20150512.공통변경에 따른 수정
    		ComConfigSheet(sheet1);
    		initSheet(sheet1, 1, formObj.jHeader.value,"");
    	    ComEndConfigSheet(sheet1);
    		sheet1.RenderSheet(1);
    		sheet1.SetVisible(1);
    		//----------------------------------------------
		   if(values == "007"){
			   sheet1.SetCellText(0, ConstantMgr.getCompanyCode(), "Final\nCompany BSA");
			   sheet1.SetCellText(1, ConstantMgr.getCompanyCode(), "Final\nCompany BSA");
                //for(j=0; j<aryNo; j++) sheetObj.CellText(0,12+j)=title;
//			   sheet1.SetCellBackColor(1, ConstantMgr.getCompanyCode(), "#AAB9FF");
			   sheet1.SetFrozenCol(14);
			   //sheet1.SetColHidden("swapYN", 1);
            }else{
                for(j = 0; j < aryNo1+1; j++) 
                	sheet1.SetCellText(0, 14 + j, title);
	                sheet1.SetCellText(1, ConstantMgr.getCompanyCode(), ConstantMgr.getCompanyCode());
	//                sheet1.SetCellBackColor(1,ConstantMgr.getCompanyCode(), "#AAB9FF");
	                sheet1.SetFrozenCol(14);
	                sheet1.SetColHidden("swapYN", 1);
	            }
	        } else {
    		//----------------------------------------------
        	sheet2.SetVisible(0);
        	sheet2.RenderSheet(0);
//        	sheet2.RemoveAll();
//        	sheet2.Reset();
        	sheet2 = sheet2.Reset();					//SJH.20150512.공통변경에 따른 수정
        	sheetObjects[1] = sheet2;					//SJH.20150512.공통변경에 따른 수정
//    		ComConfigSheet(sheet2);
    		initSheet(sheet2, 2, "", formObj.sHeader.value);
    	    ComEndConfigSheet(sheet2);
    		sheet2.RenderSheet(1);
    		sheet2.SetVisible(1);
    		//----------------------------------------------
		   if(values == "007"){
			   sheet2.SetCellText(0,ConstantMgr.getCompanyCode(), "Final\nCompany BSA");
			   sheet2.SetCellText(1,ConstantMgr.getCompanyCode(), "Final\nCompany BSA");
                //for(j=0; j<aryNo; j++) sheetObj.CellText(0,12+j)=title;
//			   sheet2.SetCellBackColor(1, ConstantMgr.getCompanyCode(),"#AAB9FF");
			   sheet2.SetFrozenCol(11);
			   //sheet2.SetColHidden("swapYN",1);
            }else{
                for(j = 0; j < aryNo2 + 1; j++) {
                	sheet2.SetCellText(0, 10 + j, title);
                } 
                sheet2.SetCellText(1, ConstantMgr.getCompanyCode() ,ConstantMgr.getCompanyCode());
//                sheet2.SetCellBackColor(1, ConstantMgr.getCompanyCode(), "#AAB9FF");
                sheet2.SetFrozenCol(10);
                sheet2.SetColHidden("swapYN",1);
            }
        }
        //------------------------------------------------------------------------------
        if(formObj.rdoOp_cd[0].checked){
            if(formObj.txtSDate.value != "") doActionIBSheet(sheet1, formObj, IBSEARCH);
        }else{
            if(formObj.txtSDate.value != "") doActionIBSheet2(sheet2, formObj,IBSEARCH);
        }
        //------------------------------------------------------------------------------
        resizeSheet();
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if (formObj.txtSDate.value == "") {
                ComShowMessage(ComGetMsg("COM12114","Period"));
                return false;
            }
            if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
                if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
                    //ComShowMessage(ComGetMsg('BSA10011','Period','First Element','Second Element')); 
//                    //txtEDate.focus();
                    ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Using in case of Excel Dowload
     * 
     *
     * @param sheetObj : sheet
     * @return String
     *         NODATA = Not Found Data
     *         AY = Down2Excel(0, false, false, true);
     *         DY = Down2Excel(-1, false, false, true);
     *         AN = SpeedDown2Excel(0, false, false);
     *         DN = SpeedDown2Excel(-1, false, false);
     *         CANCEL = Cancel + Window Close
     */
    /*function selectDownExcelMethod(sheetObj){
    	if(sheetObj.RowCount() == 0){
    		sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
    		return "NODATA";
    	}
    	var sFeature="";
    	sFeature=sFeature + "dialogHeight:200px;"
    	sFeature=sFeature + "dialogWidth:350px;"
    	sFeature=sFeature + "center:yes;"
    	sFeature=sFeature + "resizable:no;"
    	sFeature=sFeature + "scroll:no;"
    	sFeature=sFeature + "status:no;"
    	var rtn =  ComOpenWindow("ESM_BSA_3002.do",  "",  sFeature , true);
    	return rtn;
    }*/
	function setBtnZoom(type) {
		if (type == undefined)
			return;
		var subfix = document.form.rdoOp_cd[0].checked ? "_1" : "_2";
		var btnNm = "";
		switch (type) {
			case ZOOM_IN:
				btnNm = "#btn_zoom_in";
				$(btnNm + subfix).removeClass('btn_down').addClass('btn_up').prop('id', 'btn_zoom_out' + subfix).prop('name', 'btn_zoom_out' + subfix).prop('title', ZOOM_OUT);
				break;
			case ZOOM_OUT:
				btnNm = "#btn_zoom_out";
				$(btnNm + subfix).removeClass('btn_up').addClass('btn_down').prop('id', 'btn_zoom_in' + subfix).prop('name', 'btn_zoom_in' + subfix).prop('title', ZOOM_IN);
				break;
		}
	}
	
	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	} 
