/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0032.jsp
*@FileTitle  : Inquire/Edit Supply & Slot-swap By VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
    /**
     * @extends 
     * @class ESM_BSA_0032 : business script for ESM_BSA_0032
     */
	var sheet_selno=""; 
	var JOINT_OPERATING="";
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet_height=20; // sheet의 height
    var comboObjects=new Array();
    var comboCnt=0;
    var loadingMode=false;
    var sheet_height1=20; //  height of sheet1
	var sheet_height2=20; //  height of sheet2
	var ZOOM_IN = "Zoom in(+)";
	var ZOOM_OUT = "Zoom out(-)";
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick() {
//    	var sheet1=sheetObjects[0];
//    	var sheetObject2=sheetObjects[1];    	
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":    				
    				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    				sheetObject2.RemoveAll();
    				break;
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    				//doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
    				break;
    			case "btn_downexcel2":
    				doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
    				//doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
    				break;
    			case "btn_zoom_in":
					if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
//						sheet_height1 = ComGetSheetViewRows(sheet1,"MAX",1);
////						sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, sheet_height1));
//						sheet1.SetSheetHeight(1000);
//						
//					 //in case of 2nd sheet
//						sheet_height2 = ComGetSheetViewRows(sheet2,"MAX",1);
////						sheet2.SetSheetHeight(ComGetSheetHeight(sheet2, sheet_height2));
//						sheet2.SetSheetHeight(1000);						
						
						var rowcount = sheet1.RowCount(); // 시트의 열 개수
						var totalrowheight = 0; // 총 열 높이의 합 초기화												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet1.GetRowHeight(y); // 모든 열의 높이의 합 구하기
						}			
						if(totalrowheight+150 > 430){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet1.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
							sheet2.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정
						}
						
						zoomFlag1="open";
						zoomFlag2="open";
					}
					set_Zoom();
					break;
				case "btn_zoom_out":
					if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
						sheet_height1 = ComGetSheetViewRows(sheet1,"MIN", 0);
						sheet1.SetSheetHeight(430);
						zoomFlag1="close";
				 //in case of 2nd sheet
						sheet_height2 = ComGetSheetViewRows(sheet2,"MIN", 0);
						sheet2.SetSheetHeight(430);
						zoomFlag2="close";
					}
					set_Zoom();
					resizeSheet();
					break;
    			case "btng_reset":
    				doActionIBSheet(sheet1,formObject,IBRESET);
    				sheetObject2.RemoveAll();
    				break;
    			case "btng_portadd":
    				if (sheet1.GetSelectRow()> 0 && sheet1.RowCount()> 0) {
    					doActionIBSheet2(sheetObject2,formObject,IBINSERT);
    				}
    				break;
    			case "btng_save":
    				doActionIBSheet2(sheetObject2,formObject,IBSAVE);
    				break;
    			case "btng_save1":
    				doActionIBSheet(sheet1,formObject,IBSAVE);
    				break;
    			case "btn_skdinquiry":
    				var classId="COM_ENS_0B1";
    				var vvd_cd="";  
    				if (sheet1.GetSelectRow()> 0 && sheet1.RowCount()> 0) {
						var vsl_cd=sheet1.GetCellValue(sheet1.GetSelectRow(), 'vsl_cd');
						var skd_voy_no=sheet1.GetCellValue(sheet1.GetSelectRow(), 'skd_voy_no');
						var skd_dir_cd=sheet1.GetCellValue(sheet1.GetSelectRow(), 'skd_dir_cd');
    					vvd_cd=vsl_cd + skd_voy_no + skd_dir_cd;
    				}
       				if (vvd_cd == "") { vvd_cd="ABCD1234E"; }
    				var param="?vvd_cd=" + vvd_cd + "&classId=" + classId;
    				ComOpenPopup("/opuscntr/"+classId+".do"+param, 620, 450, "", "0,0,1,1,1,1,1,1,1,1", false);
    				break;
    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
	/**
	 * Description : registering IBSheet Object as list <br>
	 *         adding process for list in case of needing batch processing with other items<br>
	 *         defining list on the top of source<br>
	 * <b>Example : </b>
	 * <pre>
	 *    setComboObject(sheet_obj)
	 *    </pre>
	 * @param {object}	sheet_obj - Sheet Object
	 * @see 
	 * @author 
	 * @version 2009.01.01
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Description : registering IBCombo Object as list <br>
	 *          adding process for list in case of needing batch processing with other items<br>
	 *          defining list on the top of source<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     setComboObject(combo_obj)
	 * </pre>
	 * @param {object}	combo_obj - Combo Object
	 * @see 
	 * @author
	 * @version 2009.01.01
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
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	// Handling multi combo
		loadingMode=true;
		loadCombo();
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
	    // initial setting
	    comboObjects[4].SetSelectCode(ConstantMgr.getCompanyCode());
		loadingMode=false;
    }
    /**
 	 * Description :  Combo basic setting and initialization <br>
 	 * <br><b>Example : </b>
 	 * <pre>
 	 *     loadCombo()
 	 * </pre>
 	 * @see 
 	 * @author
 	 * @version 2009.01.01
 	 */
 	function loadCombo() {
 		var formObj=document.form;
 		var sXml=formObj.sXml.value;
 		var arrXml=sXml.split("|$$|");
 		comboXml=arrXml;
 		if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], cobTrade, "code", "code");
 		if (arrXml.length > 1)
 			ComXml2ComboItem(arrXml[1], cobLane, "code", "code");
 		if (arrXml.length > 2)
 			ComXml2ComboItem(arrXml[2], cobDir, "code", "code");
 		if (arrXml.length > 3)
 			ComXml2ComboItem(arrXml[3], cobIOC, "code", "code");
		if (arrXml.length > 4){
			ComXml2ComboItem(arrXml[4], cobCarrier, "code", "code");
//			2014.10.24 김용습 - Carrier 콤보박스 높이 넓힘
			cobCarrier.SetDropHeight(300);
			
//			2014.10.24 김용습 - 콤보박스에 영 대문자만 들어가게 설정
			cobCarrier.ValidChar(2);
			
		}
 		document.form.sXml.value="";
 	}
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
    	var cnt=0;
    	switch(sheetNo) {
    		case 1:      //sheet1 init
    		    with(sheetObj){
    	      var HeadTitle="STS|YYYY-WW|Trade|Sub Trade|S.Lane|Lane|☆|Type|Vessel|Voy.|BND|OPR|BSA Capa.|Flag|C.Flag|Company|Option|Crr";

    	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:1, DataRowMerge:0 } );
    	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
    	      InitHeaders(headers, info);

    	      var cols = [ {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrwk",         KeyField:0,   CalcLogic:"",   Format:"####-##",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bsa_op_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_op_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"bsa_capa",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"stup_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"port_bsa_cfm_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"port_bsa_capa",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bsa_op_jb_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"crr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
    	       
    	      InitColumns(cols);
    	      SetEditable(1);
//    	      SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height1)); 
    	      SetSheetHeight(430); 
    	      resizeSheet();
    	      
    	      SetEditArrowBehavior(3); 
    	      
    	      }


                break;
    		case 2:      //sheet1 init
    		    with(sheetObj){
    	      var HeadTitle="Del.|STS|Trade|Lane|Vessel|Voy.|BND|OP-JB|Crr|SEQ|Port|BSA";

    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

    	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
    	      InitHeaders(headers, info);

    	      var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"", HeaderCheck:0 },
    	             {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bsa_op_jb_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crr_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//    	             2014.11.25 김용습 - seq에 숫자만 들어가도록 Type을 Text에서 Int로 변경합니다
    	             {Type:"Int",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"port_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"port_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
    	             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"port_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
    	       
    	      InitColumns(cols);
    	      SetEditable(1);
//    	      SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height1)); 
    	      SetSheetHeight(430);
    	      resizeSheet();
    	      
//  		  2014.08.19 김용습 - Port에 영어 대문자 자동 전환  기능 설정 (영 대문자가 아니면 유효하지 않은 코드라는 오류가 뜸)
  			  var info2 = {AcceptKeys:"N|E" , InputCaseSensitive:1};		//20151209.MOD : AcceptKeys E->N,E
  			  	SetColProperty(0 ,"port_cd" , info2);
  			  	
  			  SetEditArrowBehavior(3); 
    	      }


        		break;
    	}
    }
 	/**
 	 * Description :  Combo basic setting <br>
 	 * <br><b>Example : </b>
 	 * <pre>
 	 *     initCombo(comboObj,comboNo)
 	 * </pre>
 	 * @param {object}	comboObj - Combo Object
 	 * @param {Number}	comboNo  - Combo Number
 	 * @see 
 	 * @author
 	 * @version 2009.01.01
 	 */
  	function initCombo (comboObj, comboNo) {
  		
  		if(comboObj != cobCarrier){
  		
 		with (comboObj) {
	  		SetDropHeight(300);
	  		
		  	comboObj.InsertItem(0, "ALL" ,""); 
		  	
		  	Index=0; 
		  	SetSelectIndex(0); 
		  	cobCarrier.SetSelectIndex(1);	
		  	
		  	ValidChar(2,1);
		  	
 		}
 		
  		}
  	} 	
 	
//  	function sheet1_OnDownFinish(sheetObj , downloadType, result) {
//  		sheet2.SetWaitImageVisible(0);
//		 switch (excelTypeGubun) {
//	     case "AY":
//  		    	if (sheet2.RowCount()> 0) {
//  		    		sheet2.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
//                }
//	         break;
//	     case "DY":  		    	
//				if (sheet2.RowCount()> 0) {
//					sheet2.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
//				}
//	         break;
//	     case "AN":  		    	
//				if (sheet2.RowCount()> 0) {
//					sheet2.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
//				}
//	         break;
//	     case "DN":  		    	
//				if (sheet2.RowCount()> 0) {
//					sheet2.Down2Excel( {HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
//				}
//	         break;
//		 }  
//  		 sheet2.SetWaitImageVisible(1);
//  	}
  	
  	
//  2014.12.30 김용습 - 왼쪽 시트 다운엑셀용
  	var excelTypeGubun = "";
  	function callBackExcelMethod(excelType){
  		excelTypeGubun = excelType;
  		var formObject=document.form;
  		var sheetObject1=sheetObjects[0];
  		var sheetObject2=sheetObjects[1];  		
        
        switch (excelType) {
            case "AY":
//            	sheetObject1.Down2Excel({ HiddenColumn:0, Merge:1, CheckBoxOnValue:"Y", CheckBoxOffValue:" " });  
            	sheetObject1.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1 });  
                break;
            case "DY":
//            	sheetObject1.Down2Excel({ HiddenColumn:1, Merge:1, CheckBoxOnValue:"Y", CheckBoxOffValue:" " });     
            	sheetObject1.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0 });    
                break;
            case "AN":
//            	sheetObject1.Down2Excel({ HiddenColumn:0, CheckBoxOnValue:"Y", CheckBoxOffValue:" " });       
            	sheetObject1.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1, Merge:1 });  
                break;
            case "DN":
//            	sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });  
//            	sheetObject1.Down2Excel( {HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:"Y", CheckBoxOffValue:" " });
            	sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:0, Merge:0 });
                break;
        } 
  	}
  	
  	
//	2014.12.30 김용습 - 오른쪽 시트 다운엑셀용
  	var excelTypeGubun = "";
  	function callBackExcelMethod2(excelType){
  		excelTypeGubun = excelType;
  		var formObject=document.form;
  		var sheetObject1=sheetObjects[0];
  		var sheetObject2=sheetObjects[1];  		
        
        switch (excelType) {
            case "AY":
//            	sheetObject1.Down2Excel({ HiddenColumn:0, Merge:1, CheckBoxOnValue:"Y", CheckBoxOffValue:" " });  
            	sheetObject2.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1 });  
                break;
            case "DY":
//            	sheetObject1.Down2Excel({ HiddenColumn:1, Merge:1, CheckBoxOnValue:"Y", CheckBoxOffValue:" " });     
            	sheetObject2.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0 });    
                break;
            case "AN":
//            	sheetObject1.Down2Excel({ HiddenColumn:0, CheckBoxOnValue:"Y", CheckBoxOffValue:" " });       
            	sheetObject2.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1, Merge:1 });  
                break;
            case "DN":
//            	sheetObject1.Down2Excel( {HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:"Y", CheckBoxOffValue:" " });
            	sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:0, Merge:0 });
                break;
        } 
  	}
  	
    // handling the process realated with sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	var sheetObject2=sheetObjects[1];
    	switch(sAction) {
    		case IBSEARCH:      //Retrieve
    			//ComOpenWait(true);	
    			setTimeout( function(){
	    			if (validateCond(formObj,sAction)) {
	    				formObj.f_cmd.value=SEARCHLIST01;
	    				sheetObj.DoSearch("ESM_BSA_0032GS.do", bsaFormString(formObj,getParam2(curPgmNo)) );
	    			}
	    			//ComOpenWait(false);
    			}, 100);
    			break;
    		case IBSAVE:      //save
    			if (validateCond(formObj,sAction)) {
    				formObj.f_cmd.value=MULTI01;
    				sheetObj.DoSave("ESM_BSA_0032GS.do", bsaFormString(formObj,getParam2(curPgmNo,'S')), -1, true);			//SJ.20150210.MOD
    			}
    			break;
    		case IBDOWNEXCEL:   //excel download
    			if(sheetObj == sheetObjects[0]){
    				var excelType=selectDownExcelMethod(sheetObj);  
    			}else if(sheetObj == sheetObjects[1]){
    				var excelType=selectDownExcelMethod2(sheetObj);    
    			}    			
    			break;
    		case IBRESET:      //initialize creation data
    			if (validateCond(formObj,sAction)) {
    				if (ComShowConfirm(ComGetMsg('BSA10021')) == true) { //Do you want to reset data?
    					formObj.f_cmd.value=INIT;
    					sheetObj.DoSearch("ESM_BSA_0032GS.do", bsaFormString(formObj+"&"+getParam2(curPgmNo,{Append:S})));
    					var err_cd=sheetObj.GetEtcData("err_cd");
    					var err_msg=sheetObj.GetEtcData("err_msg");
    					if (err_cd == "00000") {
    					  ComShowMessage(ComGetMsg('BSA10018','RESET')); //msg1 + ' process has been completed normally.'
    					}
    				}
    			}
    			break;
    	}
    }
    // handling the process realated with sheet
    function doActionIBSheet2(sheetObj,formObj,sAction) {
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      //Retrieve (Detail)
    			//ComOpenWait(true);
    			//setTimeout( function(){
	    			if (sheetObj.GetSelectRow()> 0) {
	    				formObj.f_cmd.value=SEARCHLIST02;
						var trd_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'trd_cd');
						var rlane_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'rlane_cd');
						var vsl_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'vsl_cd');
						var skd_voy_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'skd_voy_no');
						var skd_dir_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'skd_dir_cd');
						var bsa_op_jb_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'bsa_op_jb_cd');
						var crr_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'crr_cd');
	    				var param="&trd_cd=" +trd_cd+ "&rlane_cd=" +rlane_cd+ "&vsl_cd=" +vsl_cd
	    				          + "&skd_voy_no=" +skd_voy_no+ "&skd_dir_cd=" +skd_dir_cd
	    				          + "&bsa_op_jb_cd=" +bsa_op_jb_cd+ "&crr_cd=" +crr_cd;
				        //var sheetObject2=sheetObjects[1];
				        //formObj.f_cmd.value=SEARCHLIST02;
				        //ComShowMessage(FormQueryString(formObj) + param);
				        //sheetObject2.DoSearch("ESM_BSA_0032GS2.do", bsaFormString(formObj, getParam(curPgmNo,{Append:S})));
	    				sheetObject2.DoSearch("ESM_BSA_0032GS2.do", bsaFormString(formObj, getParam(curPgmNo)) +'&'+ param );
	    			}
	    			//ComOpenWait(false);
    			//}, 100);
    		    break;
    		case IBINSERT:      
    			var sheetObject=sheetObjects[0];
    		    var Row=sheetObj.DataInsert();
					sheetObj.SetCellValue(Row, "trd_cd",sheetObject.GetCellValue(sheetObject.GetSelectRow(), "trd_cd"),0);
					sheetObj.SetCellValue(Row, "rlane_cd",sheetObject.GetCellValue(sheetObject.GetSelectRow(), "rlane_cd"),0);
					sheetObj.SetCellValue(Row, "vsl_cd",sheetObject.GetCellValue(sheetObject.GetSelectRow(), "vsl_cd"),0);
					sheetObj.SetCellValue(Row, "skd_voy_no",sheetObject.GetCellValue(sheetObject.GetSelectRow(), "skd_voy_no"),0);
					sheetObj.SetCellValue(Row, "skd_dir_cd",sheetObject.GetCellValue(sheetObject.GetSelectRow(), "skd_dir_cd"),0);
					sheetObj.SetCellValue(Row, "bsa_op_jb_cd",sheetObject.GetCellValue(sheetObject.GetSelectRow(), "bsa_op_jb_cd"),0);
					sheetObj.SetCellValue(Row, "crr_cd",sheetObject.GetCellValue(sheetObject.GetSelectRow(), "crr_cd"),0);
            	break;
    		case IBSAVE:        
    		    if (validateSheet(sheetObj)) {
    				if (sheetObj.RowCount()> 0) {
    				    formObj.f_cmd.value=MULTI02;
    					sheetObj.DoAllSave("ESM_BSA_0032GS2.do", bsaFormString(formObj,getParam2(curPgmNo,'S')));		//SJH.20150210.MOD
    				}
    			}				
    			break;
    	}
    }
    /**
     * Retrieve detail data of sheet2 by double-clicking sheet1
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
    	var formObject=document.form;
    	doActionIBSheet2(sheetObj,formObject,IBSEARCH);
    }
    var selRow=0;
    var selValue="";
    function isValidLocation(result) {
    	var sheetObject2=sheetObjects[1];
    	if(!result){
    		ComShowMessage(ComGetMsg('BSA10004',selValue));  //msg1 + ' is invalid PORT.'
    		sheetObject2.SelectCell(selRow,"port_cd",true);
    	}
    }
    function sheet2_OnChange(sheetObj,Row,Col,Value) {
    	var formObj=document.form;
    	var param;
    	if (sheetObj.ColSaveName(Col) == "port_cd") {
    		selRow=Row;
    		selValue=Value;
    		param="f_cmd="+SEARCHLIST02;
    		param=param+"&port_cd="+sheetObj.GetCellValue(Row,Col);
    		param=param+"&code=locCd";
    		var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
    		var locCd=GetEtcDataForExceptional(sXml, "locCd", "0");
    		isValidLocation(locCd);
    	}
    }
    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {    	
    	sheetObj.SetSumText(0,0,"");
    	sheetObj.SetSumText(0,"cost_yrwk","TOTAL");
    }
    function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
      sheetObj.SumText(0,0) = "";
      sheetObj.SumText(0,1) = "";
      sheetObj.SumText(0,2) = "";
//    sheetObj.SumText(0,"port_seq") = "TOTAL";
      sheetObj.SumText(0,"port_seq","TOTAL");
    }
    /**
     * handling process for input validation
     */
    function validateSheet(sheetObj) {
    	with(sheetObj){
    	}
    	return true;
    }
    /**
     * handling process for retrieve validation
     */
    function validateCond(formObj,sAction) {
    	with(formObj) {
//	    	2014.10.24 김용습 - validation 잘 작동하지 않아 다시 작성
	    	//year 체크
	    	if (formObj.txtYear.value == "") {
    			ComShowCodeMessage("COM12138", "year, month", "week");
				return false;			
				}	    	
	    	
	    	//month 또는  week 체크
	    	if (formObj.chkPrd[1].checked) {
			    if(formObj.txtFmMonth.value == ""||formObj.txtToMonth.value == ""){
			    	ComShowCodeMessage("COM12138", "year, month", "week");
					return false;
			    }			    
		    }else if (formObj.chkPrd[0].checked) {
		    	if(formObj.txtFmWeek.value == ""||formObj.txtToWeek.value == ""){
		    		ComShowCodeMessage("COM12138", "year, month", "week");
					return false;
		    	}
		    }	 
    		
    		if (ComTrim(txtYear.value) == "") {
        		//ComShowMessage(ComGetMsg('COM12114','Year'));
        		//txtYear.focus();
        		ComAlertFocus(txtYear, ComGetMsg('COM12114','Year'));
        		return false;
    		}
    		if (sAction == IBSEARCH) { //Checking in case of only Retrieve
        		if (ComTrim(txtFmMonth.value) == "" && ComTrim(txtFmWeek.value) == "") {
        			//ComShowCodeMessage('COM12138','Month','Week');
        			//txtFmMonth.focus();
        			ComAlertFocus(txtFmMonth, ComGetMsg('COM12138','Month','Week'));
        			return false;
        		}
        		if (ComTrim(txtFmMonth.value) != "" && ComTrim(txtToMonth.value) == "") {
        			//ComShowCodeMessage('COM12130','Month','Second Element');
        			//txtToMonth.focus();
        			ComAlertFocus(txtToMonth, ComGetMsg('COM12130','Month','Second Element'));
        			return false;
        		}
        		if (ComTrim(txtFmWeek.value) != "" && ComTrim(txtToWeek.value) == "") {
        			//ComShowCodeMessage('COM12130','Week','Second Element');
        			//txtToWeek.focus();
        			ComAlertFocus(txtToWeek, ComGetMsg('COM12130','Week','Second Element'));
        			return false;
        		}
        	}
    		if (ComTrim(txtFmMonth.value) != "" && ComTrim(txtToMonth.value) != "") {
        		if(parseInt(txtFmMonth.value) > parseInt(txtToMonth.value)){
            		//ComShowCodeMessage('BSA10011','Month','First Element','Second Element');
            		//txtFmMonth.focus();
            		ComAlertFocus(txtFmMonth, ComGetMsg('BSA10011','Month','First Element','Second Element'));
            		return false;
        		}
    		}
    		if (ComTrim(txtFmWeek.value) != "" && ComTrim(txtToWeek.value) != "") {
        		if(parseInt(txtFmWeek.value) > parseInt(txtToWeek.value)){
            		//ComShowCodeMessage('BSA10011','Week','First Element','Second Element');
            		//txtFmWeek.focus();
            		ComAlertFocus(txtFmWeek, ComGetMsg('BSA10011','Week','First Element','Second Element'));
            		return false;
        		}
    		}
//    		if(formObj.cobTrade.value == "" ){  
//	            ComAlertFocus(cobTrade, ComGetMsg('COM12113','Trade'));
//	            return false;
//	        }
//	        
//            if(formObj.cobLane.value == "" ){
//                ComAlertFocus(cobLane, ComGetMsg('COM12113','Lane'));
//                return false;
//            }
    	}
    	return true;
    }
    //Carrier Combo Change
    function cobCarrier_OnChange(obj) {
    	var sheetObject=sheetObjects[0];
    	var formObject=document.form;
    	sheetObject.SetCellValue(0,"port_bsa_capa",obj.GetSelectCode(),0);
    }
    function rdoCode_onClick(param){
        var sheetObj=sheetObjects[1];
        sheetObj.RemoveAll();
        sheetObj.SetCellValue(0, "port_bsa_capa", param);
    }
    /**
     * showing R.Lane with iframe
     */
    function cobTrade_OnChange(obj) {
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
         * modifying period in case of modifying month and week.
         */
        function setPeriod(obj) {
             var formObj=document.form;
             var sheetObj=sheetObjects[0];
             var param="";
             var gubun="";
             var fm_mon="";
             var to_mon="";
             var fm_wk="";
             var to_wk="";
            if(obj.value == ""){// Clearing from-data in case to-data is empty.
                if(obj.name == "txtToMonth" ){
                    formObj.txtFmMonth.value="";
                } else if (obj.name == "txtToWeek"){
                    formObj.txtFmWeek.value="";
                }
                return false;
            }
//    		2014.11.26 김용습 - from 정보를 수정했을 때에도 화면에 날짜로 계산되어 보여지도록 하는 것이 더 옳다고 생각되어, 아래 부분 주석처리 합니다
//            else { //Skipping it in case data exist when  focusing out from from_column.
//                if(obj.name == "txtFmMonth") return false;
//                if(obj.name == "txtFmWeek") return false;
//            }
            if(chkValidSearch()){
                if(formObj.txtFmMonth.value != "" && formObj.txtFmWeek.value != ""){
                	gubun="5";
                } else if(formObj.txtFmMonth.value == "" && formObj.txtFmWeek.value != "") {
                	gubun="4";
                } else if(formObj.txtFmMonth.value != "" && formObj.txtFmWeek.value == "") {
                	gubun="3";
                }
                formObj.param2.value=formObj.txtYear.value;
                if(formObj.chkPrd[0].checked){
                    fm_mon="";
                    to_mon="";
                    fm_wk=formObj.txtFmWeek.value;
                    to_wk=formObj.txtToWeek.value;
                } else {
                    fm_mon=formObj.txtFmMonth.value;
                    to_mon=formObj.txtToMonth.value;
                    fm_wk="";
                    to_wk="";
                }
                param=param+"f_cmd="+SEARCHLIST02;
    			param=param+"&gubun="+gubun;
    			param=param+"&fm_mon="+fm_mon;
    			param=param+"&to_mon="+to_mon;
    			param=param+"&fm_wk="+fm_wk;
    			param=param+"&to_wk="+to_wk;
    			param=param+"&year="+eval(formObj.txtYear.value);
    			param=param+"&code=period";
    			var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
    			var period=GetEtcDataForExceptional(sXml, "period", "0");
    			document.getElementById("div_period").innerHTML="<div id=\"div_period\">("+ period +")</div>";
            }
        }
        /**
         * Checking mandatory input in case of searching
         */
        function chkValidSearch(){
            var formObj=document.form;
    		with(formObj){
    			if (txtYear.value == "") {
    				ComShowCodeMessage("COM12114", "Year", "");
    			    txtYear.focus();
    				return false;
    			}
    			if (txtFmMonth.value != "" && txtToMonth.value == "") {
    				ComShowCodeMessage("COM12114", "month", "")
    			    txtToMonth.focus();
    			    return false;
    			}
    			if (txtFmMonth.value == "" && txtToMonth.value != "") {
    				ComShowCodeMessage("COM12114", "month", "");
    			    txtFmMonth.focus();
    			    return false;
    			}
//    			if (txtFmMonth.value != "" && txtToMonth.value != "") { 
//    			    if(ComParseInt (txtFmMonth.value) > ComParseInt (txtToMonth.value)){
//    			    	ComShowCodeMessage("COM12133","from Month"," to Month","smaller");
//    			        txtFmMonth.value = "";
//    			        txtToMonth.value = "";
//    			        txtFmMonth.focus();
//    			        return false;
//    			    }
//    			}
    			if (txtFmWeek.value != "" && txtToWeek.value == ""){
    				ComShowCodeMessage("COM12114", "week", "");
    			    txtToWeek.focus();
    			    return false;
    			}
    			if (txtFmWeek.value == "" && txtToWeek.value != ""){
    				ComShowCodeMessage("COM12114", "week", "");
    			    txtFmWeek.focus();
    			    return false;
    			}
    			if(txtFmMonth.value == "" && txtFmWeek.value == ""){
//    			    ComShowCodeMessage("COM12138", "month", "week"); 
    			    return false;
    			}
    		    if(!isValidYear(txtYear,false,true)) return false;
    			if(!isValidMonth(txtFmMonth,false,true)) return false;
    			if(!isValidMonth(txtToMonth,false,true)) return false;
    			if(!isValidWeek(txtFmWeek,false,true)) return false;
    			if(!isValidWeek(txtToWeek,false,true)) return false;
    		}
    		return true;
        }
        function set_Zoom() {
//    		if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
//    			if (zoomFlag1 == "open") {
//    				div_zoom_in1.style.display="none";  
//    				div_zoom_out1.style.display="inline";
//    			} else if (zoomFlag1 == "close") {
//    				div_zoom_in1.style.display="inline"; 
//    				div_zoom_out1.style.display="none";
//    			}
//    			div_zoom_in2.style.display="none";
//    			div_zoom_out2.style.display="none";
//    		} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
//    			div_zoom_in1.style.display="none";
//    			div_zoom_out1.style.display="none";
//    			if (zoomFlag2 == "open") {
//    				div_zoom_in2.style.display="none";  
//    				div_zoom_out2.style.display="inline";
//    			} else if (zoomFlag2 == "close") {
//    				div_zoom_in2.style.display="inline"; 
//    				div_zoom_out2.style.display="none";
//    			}		
//    		}
    		switch (sheet_selno) {
    			case JOINT_OPERATING:
    				setBtnZoom(zoomFlag1 == "open" ? ZOOM_IN : ZOOM_OUT);
    				break;
    			case SPACE_CHARTERING:
    				setBtnZoom(zoomFlag2 == "open" ? ZOOM_IN : ZOOM_OUT);
    				break;
    		}
    	}
        function setBtnZoom(type) {
    		if (type == undefined)
    			return;
    		switch (type) {
    			case ZOOM_IN:
    				$('#btn_zoom_in').removeClass('btn_down').addClass('btn_up').prop('id', 'btn_zoom_out').prop('name', 'btn_zoom_out').prop('title', ZOOM_OUT);
    				break;
    			case ZOOM_OUT:
    				$('#btn_zoom_out').removeClass('btn_up').addClass('btn_down').prop('id', 'btn_zoom_in').prop('name', 'btn_zoom_in').prop('title', ZOOM_IN);
    				break;
    		}
    	}
        
        function resizeSheet(){
            ComResizeSheet(sheetObjects[0]);
            ComResizeSheet(sheetObjects[1]);
        }

