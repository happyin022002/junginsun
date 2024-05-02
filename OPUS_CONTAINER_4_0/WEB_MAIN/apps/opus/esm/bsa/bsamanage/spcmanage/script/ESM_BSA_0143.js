/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0143.js
*@FileTitle  : HSlot-info by VVD(VESSELS)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/

/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
    /**
     * @extends 
     * @class ESM_BSA_0143 : ESM_BSA_0143 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     * @class ESM_BSA_0143 : business script for ESM_BSA_0143
     */
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var loadingMode=false;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /*
    * Event handler processing by button name
    */
    function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
				case "btn_downexcel":
					//sheetObject.DataInsert();
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "bu_zoom_in":	
					var rowcount = sheetObject.RowCount(); // 시트의 열 개수
					var totalrowheight = 0; // 총 열 높이의 합 초기화												
					for(y=0; y<=rowcount; y++){
						totalrowheight = totalrowheight + sheetObject.GetRowHeight(y); // 모든 열의 높이의 합 구하기
					}			
					if(totalrowheight+150 > 405){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
						sheetObject.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
					}
//			          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
		            document.getElementById("bu_zoom_in").style.display="none";
		            document.getElementById("bu_zoom_out").style.display="inline";
//			    		bu_zoom_in.style.display="none";
//			    		bu_zoom_out.style.display="inline";
//			    		parent.syncHeight();
//			    	
					break;
			    case "bu_zoom_out":			    
			    		sheetObject.SetSheetHeight(405);
			    		
//				          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
			            document.getElementById("bu_zoom_out").style.display="none";
			            document.getElementById("bu_zoom_in").style.display="inline";
//						bu_zoom_out.style.display="none";
//						bu_zoom_in.style.display="inline";
//						parent.syncHeight();
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
		loadingMode=false;
	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    
//	    2014.11.10 김용습 - 페이지 첫 로딩 시 Week가 날짜로 계산되어 나오지 않던 현상 수정
	    var formObj = document.form   
	    setPeriod(formObj.txtToWeek);
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
			ComXml2ComboItem(arrXml[0],cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1],cobLane, "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2],cobDir, "code", "code");
		if (arrXml.length > 3)
			ComXml2ComboItem(arrXml[3],cobIOC, "code", "code");
		document.form.sXml.value="";
	}
    /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
    function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
	    switch(sheetNo) {
		    case 1:      //sheet1 init
		        with(sheetObj){
	         var HeadTitle="YYYY-WW|Trade|Sub\nTrade|S.Lane|Lane|Type|Vessel|Voy.|BD|OPR|BSA CAPA.|Carrier|BSA|"
	         +	"Weight\nPer TEU|TTL\nWeight|RF|D2|D3|D4|D5|D7" ;
	         var HeadTitle1="YYYY-WW|Trade|Sub\nTrade|S.Lane|Lane|Type|Vessel|Voy.|BD|OPR|BSA CAPA.|Carrier|BSA|"
	         + "Weight\nPer TEU|TTL\nWeight|RF|D2|D3|D4|D5|D7" ;

	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:12 } );

	         var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	         var headers = [ { Text:HeadTitle, Align:"Center"},
	                   { Text:HeadTitle1, Align:"Center"} ];
	         InitHeaders(headers, info);

	         var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrwk",       KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bsa_capa",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"bsa",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"weight_teu",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"weight_ttl",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rf",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"d2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"d3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"d4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"d5",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"d7",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
	          
	         InitColumns(cols);

	         SetEditable(0);//Editkind[option,Defaultfalse]
	         SetRangeBackColor(1, 13, 1, 14,"#DEFBF8");
//	         SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
	         SetSheetHeight(405);
	         
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
 		with (comboObj) {
 			SetDropHeight(300);
 			comboObj.InsertItem(0, 'All' ,''); 
 			Index=0;
 			SetSelectIndex(0);
 		}
 	}
    /**
    * handling the process realated with sheet
    */
    function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
		    case IBSEARCH:      //Retrieve
			    if(!validateForm(sheetObj,formObj,sAction))return false;
			    formObj.f_cmd.value=SEARCHLIST;
 			    sheetObj.DoSearch("ESM_BSA_0143GS.do", bsaFormString(formObj,getParam2('ESM_BSA_0143')) );
			    break;
			case IBDOWNEXCEL:        //excel download
			    var excelType=selectDownExcelMethod(sheetObj);
			    break;
	    }
    }
    
    function callBackExcelMethod(excelType){
	   	 if(sheetObj.RowCount() < 1){//no data
	   	  ComShowCodeMessage("COM132501");
	   	  return;
	   	 }
	         switch (excelType) {
	         case "AY":
	         	if(sheetObj.RowCount() < 1){//no data
	         		ComShowCodeMessage("COM132501");
	         		}else{
	//         			sheetObj.Down2Excel({ HiddenColumn:0,Merge:true});
	         			sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	         		}      	
	             break;
	         case "DY":
	         	if(sheetObj.RowCount() < 1){//no data
	         		ComShowCodeMessage("COM132501");
	         		}else{
	//         			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
	         			sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	         		}      	
	             break;
	         case "AN":
	         	if(sheetObj.RowCount() < 1){//no data
	         		ComShowCodeMessage("COM132501");
	         		}else{
	//         			sheetObj.Down2Excel({ HiddenColumn:0});
	         			sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	         		}      	
	             break;
	         case "DN":
	         	if(sheetObj.RowCount() < 1){//no data
	         		ComShowCodeMessage("COM132501");
	         		}else{
	//         			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	         			sheetObj.Down2Excel( { HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' } );
	         		}      	
	             break;
	     }           
   }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
	    with(formObj){
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
	    	
		    if (chkPrd[1].checked && txtFmMonth.value != "" && txtToMonth.value != "") {
			    if(ComParseInt(txtFmMonth.value) > ComParseInt(txtToMonth.value)){
					ComAlertFocus(txtToMonth, ComGetMsg('BSA10011','Month','First Element','Second Element'));
					return false;
			    }
		    }
		    if (chkPrd[0].checked && txtFmWeek.value != "" && txtToWeek.value != "") {
		    	if(ComParseInt(txtFmWeek.value) > ComParseInt(txtToWeek.value)){
		    		ComAlertFocus(txtToWeek, ComGetMsg('BSA10011','Week','First Element','Second Element'));
		    		return false;
		    	}
		    }
	    }
	    return true;
    }
    /**
     * Changing period in case of changing month and week
     */
    function setPeriod(obj){
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
//		2014.11.26 김용습 - from 정보를 수정했을 때에도 화면에 날짜로 계산되어 보여지도록 하는 것이 더 옳다고 생각되어, 아래 부분 주석처리 합니다
//	    else { //Skipping it in case data exist when  focusing out from from_column.
//	    	if(obj.name == "txtFmMonth") return false;
//	    	if(obj.name == "txtFmWeek") return false;
//	    }
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
    * showing R.Lane with iframe
    */
    function cobTrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		if (loadingMode == true) return; 
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var param="";
		var trd_cd="";
		sheetObj.SetWaitImageVisible(0);
		if(comboObj.GetSelectText()!= ""){
			trd_cd=comboObj.GetSelectCode();
			param="f_cmd="+SEARCHLIST01;
			param=param+"&trd_cd="+trd_cd;
			param=param+"&code=rLane";
 			var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0],cobLane, "code", "code");
			cobLane.SetSelectIndex(0);
		}
		sheetObj.SetWaitImageVisible(1);
    }
    /**
    * Checking mandatory input in case of searching
    */
    function chkValidSearch(){
    	var formObj=document.form;
    	with(formObj){
    		if (txtYear.value == "") {
    			ComShowMessage(ComGetMsg("COM12114", "Year", ""));
    			txtYear.focus();
    			return false;
    		}
    		if (txtFmMonth.value != "" && txtToMonth.value == "") {
    			ComShowMessage(ComGetMsg("COM12114", "month", ""))
    			txtToMonth.focus();
    			return false;
    		}
    		if (txtFmMonth.value == "" && txtToMonth.value != "") {
    			ComShowMessage(ComGetMsg("COM12114", "month", ""));
    			txtFmMonth.focus();
    			return false;
    		}
//        			if (txtFmMonth.value != "" && txtToMonth.value != "") { 
//        			    if(txtFmMonth.value > txtToMonth.value){
//        			        ComShowMessage(ComGetMsg("COM12133","from Month"," to Month","smaller"));
//        			        txtFmMonth.value = "";
//        			        txtToMonth.value = "";
//        			        txtFmMonth.focus();
//        			        return false;
//        			    }
//        			}
    		if (txtFmWeek.value != "" && txtToWeek.value == ""){
    			ComShowMessage(ComGetMsg("COM12114", "week", ""));
    			txtToWeek.focus();
    			return false;
    		}
    		if (txtFmWeek.value == "" && txtToWeek.value != ""){
    			ComShowMessage(ComGetMsg("COM12114", "week", ""));
    			txtFmWeek.focus();
    			return false;
    		}
    		if(txtFmMonth.value == "" && txtFmWeek.value == ""){
    			//ComShowMessage(ComGetMsg("COM12138", "month", "week"));
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
