/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : VOP_VSK_0029.js
*@FileTitle : Delay&Skip Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // public variable
 var tabObjects=new Array();
 var tabClicks=new Array(3);//setting tab click state
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
var comboCnt=0;
 var tabLoad=new Array();
 tabLoad[0]=0;
 tabLoad[1]=0;
 tabLoad[2]=0;
 //Header Code of first tab
 var tab1HeadArr2=new Array();
 // count of Header Code of first tab
 var Cnt=0;
 //Header Title of first tab
 var tab1HeaderNm="";
 var tab2HeaderNm="";
 var tab3HeaderNm="";
 //User_Condition Tab Setting  
 var delayConData=null;
 var skipConData=null;
 var skipChangeConData=null;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
 function processButtonClick(){
  var sheetObject1=sheetObjects[0];
  var sheetObject2=sheetObjects[1];
  var sheetObject3=sheetObjects[2];
  /*******************************************************/
  var formObject=document.form;
  try {
	var srcName=ComGetEvent("name");
    //if (!ComIsBtnEnable(srcName)) return;  
    if(ComGetBtnDisable(srcName)) return false; 
		switch(srcName) {
				case "btn_Retrieve":
					if(checkPeriod(formObject)){
						doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					}else{
						ComShowCodeMessage("VSK00105", "1 year");
					}
					break;
				case "btn_VVDRMKs":
//					doActionIBSheet(sheetObject1, formObject, COMMAND01);
					var sUrl="/opuscntr/VOP_VSK_0232.do?vps_port_cd="+formObject.vps_port_cd.value;
                	ComOpenPopup(sUrl, 600, 380, "getVvdRemark()", "0,0", true);
					break;
				case "btn_DelayRSN":
					var sUrl="/opuscntr/VOP_VSK_0252.do?code_type=CD01830";
//					ComOpenPopupWithTarget(sUrl, 600, 406, "", "0,0", true);
					ComOpenPopup(sUrl, 600, 406, "getVvdRemark", "0,0", true);
					break;
				case "btn_GroupRegister":
						var sUrl="/opuscntr/VOP_VSK_0228.do";
						ComOpenPopup(sUrl, 606, 465, "", "0,0", true);
						break;
				case "btns_search":
					openLandCdHelp(sheetObject1);
					break;
				case "btns_search2":
					openVslCdHelp(sheetObject1);
					break;
				case "btns_search3":
					openPortCdHelp(sheetObject1);
					break;
				case "btns_search4":
					openCrrCdHelp(sheetObject1);
					break;	
				case "btns_calendar_s":
	            	var cal=new ComCalendar();
	            	cal.setDisplayType('month');
	            	cal.setEndFunction("setActInpFmDt");
		            cal.select(formObject.act_inp_fm_dt, "yyyy-MM");
	            	break;
	            case "btns_calendar_e":
	            	var cal=new ComCalendar();
	            	cal.setDisplayType('month');
	            	cal.setEndFunction("setActInpToDt");
	            	cal.select(formObject.act_inp_to_dt, "yyyy-MM");
	            	break;	
	            case "lane_grp":
					eventNav(formObject);
					break;	
 				case "btn_t1downexcel":
 					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
 					break;	
 				case "btn_t2downexcel":
 					doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL);
 					break;	
 				case "btn_t3downexcel":
 					doActionIBSheet(sheetObject3, formObject, IBDOWNEXCEL);
 					break;	 					
     } // end switch
	}catch(e) {
	if( e == "[object Error]") {
		ComShowCodeMessage('VSK00011');
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
 }
 /**
 * 
 * @param rtnObjs
 * @return
 */
function setActInpFmDt(rtnObjs){
	var formObj=document.form;
	var fmDt = formObj.act_inp_fm_dt.value;
	var toDt = formObj.act_inp_to_dt.value;
	if(fmDt > toDt){
		formObj.act_inp_fm_dt.value = toDt;
	}
	if(beforetab == 0){
		delayConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
	}
	else if(beforetab == 1){
		skipConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
	}
	else if(beforetab == 2){
		skipChangeConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
	}
}
/**
 * 
 * @param rtnObjs
 * @return
 */
function setActInpToDt(rtnObjs){
	var formObj=document.form;
	var fmDt = formObj.act_inp_fm_dt.value;
	var toDt = formObj.act_inp_to_dt.value;
	if(fmDt > toDt){
		formObj.act_inp_to_dt.value = formObj.act_inp_fm_dt.value;
	}
	if(beforetab == 0){
		delayConData.setActInpToDt(formObj.act_inp_to_dt.value);
	}
	else if(beforetab == 1){
		skipConData.setActInpToDt(formObj.act_inp_to_dt.value);
	}
	else if(beforetab == 2){
		skipChangeConData.setActInpToDt(formObj.act_inp_to_dt.value);
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
 * @param combo_obj
 * @return
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
	 var formObj=document.form;
     /*for(i=0;i<sheetObjects.length;i++){
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i++);
         ComEndConfigSheet(sheetObjects[i]);
     }*/
     for(k=0;k<tabObjects.length;k++){
         initTab(tabObjects[k],k+1);
         tabObjects[k].SetSelectedIndex(0);
     }
     for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
	 }
     var tab1HeadCol=formObj.headerVal.value;
     var tab1HeadCol1="";
     var tab1HeadCol2="";
     var tab1HeadArr=new Array();
     tab1HeadArr=tab1HeadCol.split("|");
     var tab1HeadCnt=tab1HeadArr.length;
     for(var i=0; i<tab1HeadCnt; i++){
    	 tab1HeadCol1 += "Exclusive delay count/hour and ratio "+"|";
    	 tab1HeadCol2 += tab1HeadArr[i]+"|";
     }
     //Total Header of first row
    // tab1HeadCol1 += "Exclusive Delay Reason (Ratio)"+"|";
     var obj=document.form.grp_flg[0].options;
     tab1HeaderNm=obj[0].text;
     var obj2=document.form.grp_flg[1].options;
     tab2HeaderNm=obj2[0].text;
     var obj3=document.form.grp_flg[2].options;
     tab3HeaderNm=obj3[0].text;
     
     ComConfigSheet (sheetObjects[0]);
     initSheet(sheetObjects[0], 1, tab1HeadCol1,tab1HeadCol2);
     ComEndConfigSheet(sheetObjects[0]);

     ComConfigSheet (sheetObjects[1]);
     initSheet(sheetObjects[1], 1, tab1HeadCol1,tab1HeadCol2);
     ComEndConfigSheet(sheetObjects[1]);

     ComConfigSheet (sheetObjects[2]);
     initSheet(sheetObjects[2], 1, tab1HeadCol1,tab1HeadCol2);
     ComEndConfigSheet(sheetObjects[2]);
     
     resizeSheet();
     
     formObj.vsl_slan_cd.focus();
 	 ComEnableObject(formObj.vsl_slan_cd, true);
 	 ComEnableObject(formObj.btns_search, true);
 	 lane_grp_nm.SetEnable(0);
 	 delayConData=new Usr_Condi_FormData();
 	 skipConData=new Usr_Condi_FormData();
 	 skipChangeConData=new Usr_Condi_FormData();
 	 initControl();
 }
 /**
 * setting combo initial values and header 
 * param : comboObj, comboNo
 * adding case as numbers of counting combos 
 */ 
function initCombo(comboObj, comboNo) {
    var formObj=document.form;
    switch(comboObj.id) {
    	case "lane_grp_nm":
    		with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColWidth(0, "100");
				SetBackColor("#CCFFFD");
				SetFontColor("#000000");
				SetColBackColor(0,"#CCFFFD");
				SetColFontColor(0,"#000000");
				SetDropHeight(160);
	    	}
    		break;
     }
}
 /**
  * registering initial event
  */
 function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('focus', "obj_activate", formObj);
	axon_event.addListenerForm('change', 'obj_change', formObj);
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
 	axon_event.addListenerFormat('beforedeactivate',  	'obj_blur',  	formObj);
// 	axon_event.addListenerForm('keypress', 'enter_keypress', formObj);
 	axon_event.addListenerForm ('keydown', 'ComKeyEnter', formObj);
 	setToday(document.form.act_inp_fm_dt, "ym");//Setting current year
	setToday(document.form.act_inp_to_dt, "ym");//Setting current year
 }
 
 /*****
 function obj_activate() {
	ComClearSeparator(event.srcElement);
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
 }
 ***/
 
 /**
  * Handling change event
  */
 function obj_change(){
 	var formObj=document.form;
    var sheetObject1=sheetObjects[0];
    var prefix1="sheet1_";
    var obj=event.srcElement;
     /*******************************************************/
 	try {
 		var srcName=ComGetEvent("name");
        switch(srcName) {
        	case "vsl_slan_cd":
	        	var cnt=formObj.vsl_slan_cd.value;
				cnt=cnt.length;
				if(cnt == 3){
					var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
					var checkLane=ComGetEtcData(sXml, "checkLane");
					if(checkLane == undefined){
						sheetObject1.LoadSearchData(sXml,{Sync:1} );
						formObj.vsl_slan_cd.value="";	
						formObj.vsl_slan_cd.focus();
					}else{
						if(beforetab == 0){
							delayConData.setVslSlanCd(formObj.vsl_slan_cd.value);
						}
						else if(beforetab == 1){
							skipConData.setVslSlanCd(formObj.vsl_slan_cd.value);
						}
						else if(beforetab == 2){
							skipChangeConData.setVslSlanCd(formObj.vsl_slan_cd.value);
						}
					}
				}
        	break;
        	case "vsl_cd":
        		var cnt=formObj.vsl_cd.value;
				cnt=cnt.length;
				if(cnt == 4){
					var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
					var vsl_eng_nm=ComGetEtcData(sXml, "vsl_eng_nm");
		    		if(!vsl_eng_nm){
		    			ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
		    			formObj.vsl_cd.value='';
		    			formObj.vsl_cd.focus();
		    		}else{
		    			if(beforetab == 0){
							delayConData.setVslCd(formObj.vsl_cd.value);
						}
						else if(beforetab == 1){
							skipConData.setVslCd(formObj.vsl_cd.value);
						}
						else if(beforetab == 2){
							skipChangeConData.setVslCd(formObj.vsl_cd.value);
						}
		    			ComSetNextFocus();
		    		}
				}
       		break;
        	case "vps_port_cd":
        		var cnt=formObj.vps_port_cd.value;
				cnt=cnt.length;
				if(cnt == 5){
					var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH04);
					var portNm=ComGetEtcData(sXml, "port_name");
					if(portNm != ""){
						if(beforetab == 0){
							delayConData.setVpsPortCd(formObj.vps_port_cd.value);
						}
						else if(beforetab == 1){
							skipConData.setVpsPortCd(formObj.vps_port_cd.value);
						}
						else if(beforetab == 2){
							skipChangeConData.setVpsPortCd(formObj.vps_port_cd.value);
						}
						formObj.act_inp_fm_dt.focus();
					}else{
						ComShowCodeMessage("VSK00029", formObj.vps_port_cd.value);
						formObj.vps_port_cd.value="";
					}
				}
        	break;
        	case "crr_cd":
        		if(ComChkLen(obj.value, 3)==2){
    				var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH06);
    				var crr_cd=ComGetEtcData(sXml, "crr_cd");
    				if(crr_cd==null){
    					ComShowCodeMessage('VSK00021', formObj.crr_cd.value);
    					formObj.crr_cd.value="";
    					formObj.crr_cd.focus();
    				}else{
    					if(beforetab == 0){
    						delayConData.setCrrCd(formObj.crr_cd.value);
    					}
    					else if(beforetab == 1){
    						skipConData.setCrrCd(formObj.crr_cd.value);
    					}
    					else if(beforetab == 2){
    						skipChangeConData.setCrrCd(formObj.crr_cd.value);
    					}
    				}
    			}
       		break;
        	case "ie_flg":
        		var ieFlg = formObj.ie_flg.value;
        		if(ieFlg == "I"){
        			sheetObjects[0].SetCellValue(1,"sheet1_arr_dep","Inclusive of Consecutive Delay");
        			sheetObjects[1].SetCellValue(1,"sheet2_arr_dep","Inclusive of Consecutive Delay");
        		}else{
        			sheetObjects[0].SetCellValue(1,"sheet1_arr_dep","Exclusive of Consecutive Delay");
        			sheetObjects[1].SetCellValue(1,"sheet2_arr_dep","Exclusive of Consecutive Delay");
        		}
        		sheetObjects[0].RemoveAll();
       		break;       		
        }
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowCodeMessage('VSK00011');
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
 } 
 /**
  * Handling key press event
  */
 function obj_keypress() {
     switch(event.srcElement.dataformat){
         case "float":
             ComKeyOnlyNumber(event.srcElement, ".");
             break;
         case "eng":
             ComKeyOnlyAlphabet();
             break;
         case "engdn":
             ComKeyOnlyAlphabet('lower');
             break;
         case "engup":
             ComKeyOnlyAlphabet('upper');
             break;
         case "uppernum":
             ComKeyOnlyAlphabet('uppernum');
             break;    
         default:
             ComKeyOnlyNumber(event.srcElement);
     }
 }
 /**
  * Handling onBlur event
  * @return
  */
 function obj_blur(){
	 var formObj=document.form;
   	 obj=event.srcElement;      	
   	 with(formObj){
   		 if(obj.name=="act_inp_fm_dt" || obj.name=="act_inp_to_dt"){
   			 var creDtFr=ComReplaceStr(act_inp_fm_dt.value,"-","");
   			 var creDtTo=ComReplaceStr(act_inp_to_dt.value,"-","");
   			 switch(ComGetEvent("name")) {
	    	    	case "act_inp_fm_dt":	// Agreement From Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				act_inp_fm_dt.value='';
	    	    				document.form.act_inp_fm_dt.focus();
	    	    				return false;
	    	    			}
	    	    		}
	    	    		formObj.act_inp_fm_dt.value=ComGetMaskedValue(formObj.act_inp_fm_dt.value, "ym");
	    	            break;
	    	    	case "act_inp_to_dt":	// Agreement To Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				act_inp_to_dt.value='';
	    	    				act_inp_to_dt.focus();
	    	    				return false;
	    	    			}
	    	    		}
	    	    		formObj.act_inp_to_dt.value=ComGetMaskedValue(formObj.act_inp_to_dt.value, "ym");
	    	           	break;	
	        	}
	   			if(beforetab == 0){
					delayConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
					delayConData.setActInpToDt(formObj.act_inp_to_dt.value);
				}
				else if(beforetab == 1){
					skipConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
					skipConData.setActInpToDt(formObj.act_inp_to_dt.value);
				}
				else if(beforetab == 2){
					skipChangeConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
					skipChangeConData.setActInpToDt(formObj.act_inp_to_dt.value);
				}
   		 	}
       }
       return true;	
 } 
// function enter_keypress(){
//		VskKeyEnter();
//}
function delayChange(){
	var formObj=document.form;
	var obj=formObj.grp_flg[0].options;
	var currPos=0;
	for(var i=0; i<obj.length; i++){
		if(obj[i].selected == true){
			currPos=i;
		}
	}
	sheetObjects[0].RemoveAll();
	var delayHeaderNm=obj[currPos].text;
	sheetObjects[0].SetCellValue(0,"sheet1_lane",delayHeaderNm);
	sheetObjects[0].SetCellValue(1,"sheet1_lane",delayHeaderNm);
	sheetObjects[0].SetCellValue(2,"sheet1_lane",delayHeaderNm);
}
function skipChange(){
	var formObj=document.form;
	var obj=formObj.grp_flg[1].options;
	var currPos=0;
	for(var i=0; i<obj.length; i++){
		if(obj[i].selected == true){
			currPos=i;
		}
	}
	sheetObjects[1].RemoveAll();
	var skipHeaderNm=obj[currPos].text;
    sheetObjects[1].SetCellValue(0,"sheet2_lane",skipHeaderNm);
	sheetObjects[1].SetCellValue(1,"sheet2_lane",skipHeaderNm);
	sheetObjects[1].SetCellValue(2,"sheet2_lane",skipHeaderNm);
}
function skipChangeStatus(){
	var formObj=document.form;
	var obj=formObj.grp_flg[2].options;
	var currPos=0;
	for(var i=0; i<obj.length; i++){
		if(obj[i].selected == true){
			currPos=i;
		}
	}
	sheetObjects[2].RemoveAll();
	var skipChangeHeaderNm=obj[currPos].text;
	sheetObjects[2].SetCellValue(0, "sheet3_group_flg", skipChangeHeaderNm);
}
   /**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo, tab1HeadCol1,tab1HeadCol2) {
     var cnt=0;
	 var sheetID=sheetObj.id;
     switch(sheetID) {
         case "t1sheet1":
        	    with(sheetObj){
             	   tab1HeadArr2=tab1HeadCol2.split("|");
                   tab1HeadArr2Cnt=tab1HeadArr2.length-1;
		           
		           var HeadTitle1="|"+tab1HeaderNm+"|CNT|"+tab1HeadCol1+"Total|On-time Ratio|On-time Ratio|On-time Ratio";
		           var HeadTitle2="|"+tab1HeaderNm+"|HRS|"+tab1HeadCol2+"Total|Inclusive of Consecutive Delay|Inclusive of Consecutive Delay|Inclusive of Consecutive Delay";
		           var HeadTitle3="|"+tab1HeaderNm+"|S.TTL|"+tab1HeadCol2+"Total|Kind|Calling|On-time";
		           var headCount=ComCountHeadTitle(HeadTitle1);
		           var prefix="sheet1_";
		
		           SetConfig( { SearchMode:0, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
		
		           var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		           var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"},{ Text:HeadTitle3, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag",   Wrap:1 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lane",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cnt_hrs",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 } ];
		                  for(var i=0; i<tab1HeadArr2Cnt; i++){
		                	 cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:prefix+tab1HeadArr2[i].toLowerCase(),   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 });
		                  }
		           cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ttl",                           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 });
		           cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_dep",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 });
		           cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix+"call_cnt",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 });
		           cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix+"ontm_cnt",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 });
		      
		           InitColumns(cols);
		
		           SetEditable(0);
		           SetCountPosition(0);
		           SetWaitImageVisible(0);
                 }


             break;
         case "t2sheet1":
        	    with(sheetObj){
        	 
	           tab1HeadArr2=tab1HeadCol2.split("|");
	           tab1HeadArr2Cnt=tab1HeadArr2.length-1;
	           var HeadTitle1="|"+tab2HeaderNm+"|"+tab2HeaderNm+"|"+tab1HeadCol1+"Total|Skip Ratio|Skip Ratio|Skip Ratio";
//	           var HeadTitle2="|"+tab2HeaderNm+"|"+tab2HeaderNm+"|"+tab1HeadCol2+"Total|Inclusive of Consecutive Delay|Inclusive of Consecutive Delay|Inclusive of Consecutive Delay";
	           var HeadTitle2="|"+tab2HeaderNm+"|"+tab2HeaderNm+"|"+tab1HeadCol2+"Total|Calling|Skip|Ratio";
	           var HeadTitle3="|"+tab2HeaderNm+"|"+tab2HeaderNm+"|"+tab1HeadCol2+"Total|Calling|Skip|Ratio";
	           var headCount=ComCountHeadTitle(HeadTitle1);
	           var prefix="sheet2_";
	
	           SetConfig( { SearchMode:0, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	           var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	           var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"},{ Text:HeadTitle3, Align:"Center"} ];
	           InitHeaders(headers, info);
	
	           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag",                        Wrap:1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lane",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
	                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cnt_hrs",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 } ];
	                 for(var i=0; i<tab1HeadArr2Cnt; i++){
	                	 cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:prefix+tab1HeadArr2[i].toLowerCase(),   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 });
	                 }
	                 cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ttl",                           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 });
	                 cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_dep",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 });
	                 cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix+"call_cnt",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 });
	                 cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix+"ontm_cnt",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 });

	           InitColumns(cols);

	           SetEditable(0);
	           SetCountPosition(0);
	           SetWaitImageVisible(0);
	           SetMergeCell(0,1,3,2);
           }
             break;
         case "t3sheet1":
        	    with(sheetObj){
             
	           var HeadTitle1="|"+tab3HeaderNm+"|VVD|Port1|State|Port2|State|Port3|State|Port4|State|Port5|State|Port6|State|Port7|State|Port8|State|Port9|State|Port10|State|Port11|State|Port12|State|Port13|State|Port14|State|Port15|State|Port16|State|Port17|State|Port18|State|Port19|State|Port20|State";
	           var headCount=ComCountHeadTitle(HeadTitle1);
	           var prefix="sheet3_";
	           var rowCnt=0;
	
	           SetConfig( { SearchMode:0, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	           var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	           var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	           InitHeaders(headers, info);
	
	           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"group_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:0 },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state3",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state4",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state5",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port6",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state6",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port7",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state7",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port8",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state8",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port9",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state9",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port10",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state10",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port11",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state11",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port12",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state12",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port13",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state13",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port14",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state14",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port15",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state15",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port16",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state16",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port17",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state17",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port18",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state18",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port19",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state19",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port20",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"state20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 } ];
	            
	           InitColumns(cols);
	
	           SetEditable(0);
	           SetCountPosition(0);
	           SetWaitImageVisible(0);
                 }
             break;
     }
 }
   // handling sheet process
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
        case IBSEARCH:      //Retrieve
        	/*
        	if ( sheetObj.id == "t1sheet1"){
        		formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT 		     	sheetObj.DoSearch("VOP_VSK_0029GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
		     	if(sheetObjects[0].RowCount()> 0){
		     		showSheetData(sheetObj,formObj);
		     	}
        	}else if(sheetObj.id == "t2sheet1"){
        		formObj.f_cmd.value=SEARCH03;
//parameter changed[check again]CLT 	     		sheetObj.DoSearch("VOP_VSK_0029GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") );
	     		if(sheetObjects[1].RowCount()> 0){
	     			alert(sheetObjects[1].RowCount());
		     		//showSheetData(sheetObj,formObj);
		     	}
        	}else if(sheetObj.id == "t3sheet1"){
        	}
        	*/
        	if(validateForm(sheetObj,formObj,sAction)){
	        	var curPos=0;
	        	for(var i=0; i<tabClicks.length; i++){
	        		if(tabClicks[i] == true){
	        			curPos=i;
	        		}
	        	}
	        	
	        	ComOpenWait(true);
	        	if(curPos == "0"){
	        		formObj.f_cmd.value=SEARCH;
	        		formObj.grp_flg_cd.value=formObj.grp_flg[0].value;
// 	        		sheetObjects[0].DoSearch("VOP_VSK_0029GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
 	        		
 	        		var sXml=sheetObj.GetSearchData("VOP_VSK_0029GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
 	        		sheetObj.LoadSearchData(sXml,{append:1} );
 	        		
	        	}else if(curPos == "1"){
	        		formObj.f_cmd.value=SEARCH03;
	        		formObj.grp_flg_cd.value=formObj.grp_flg[1].value;
 	        		sheetObjects[1].DoSearch("VOP_VSK_0029GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") );
	        	}else{
	        		formObj.f_cmd.value=SEARCH04;
	        		formObj.grp_flg_cd.value=formObj.grp_flg[2].value;
 	        		sheetObjects[2].DoSearch("VOP_VSK_0029GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_") );
	        	}
	        	ComOpenWait(false);
        	}
             break;
        case SEARCH02: //Lane Code
			//formObj.f_cmd.value = SEARCH02;
        	ComOpenWait(true);
        	formObj.f_cmd.value=COMMAND12;
			var sParam=FormQueryString(formObj);
			//var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op_=0202", sParam);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0202GS.do", sParam);
			ComOpenWait(false);
			return sXml;
			break;
        case SEARCH03: // Vessel Code Retrieve
        	ComOpenWait(true);
    		formObj.f_cmd.value=SEARCH;
    		var sParam=FormQueryString(formObj);
     		var sXml=sheetObj.GetSearchData("VOP_VSK_0044GS.do", sParam);
    		ComOpenWait(false);
    		return sXml;
    		break;
        case SEARCH04: // Port Code Retrieve
        	//formObj.f_cmd.value = SEARCH;
        	ComOpenWait(true);
        	formObj.f_cmd.value=COMMAND13;
			var sParam=FormQueryString(formObj);
			var locCd=formObj.vps_port_cd.value;
			//var sXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do?op_=0043&loc_cd="+locCd, sParam);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0043GS.do?loc_cd="+locCd, sParam);
			ComOpenWait(false);
			return sXml;
    		break;	
        case SEARCH05: // Group Code
        	lane_grp_nm.RemoveAll();
        	ComOpenWait(true);
        	formObj.f_cmd.value=SEARCH02;
			var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0029GS.do", sParam);
			var comboItems=ComGetEtcData(sXml, "grp_nm").split("|");
			addComboItem(lane_grp_nm,comboItems);	
			ComOpenWait(false);
    		break;		
        case SEARCH06: //CHECK CARRIER CD
        	ComOpenWait(true);
        	formObj.f_cmd.value=SEARCH;
			var sParam=FormQueryString(formObj);
			var code=formObj.crr_cd.value;
			//var sXml = sheetObj.GetSearchXml("VOP_VSK_0252GS.do?op_=0252&grd_nm=CD0XXXX&code="+code, sParam);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0252GS.do?grd_nm=CD0XXXX&code="+code, sParam);
			ComOpenWait(false);
			return sXml;
        	break;		
		case IBDOWNEXCEL:        	//excel download
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{					 
				 sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj),Merge:1,TreeLevel:false,SheetDesign:1 });	
			}
			break;        	
     }
 }
function showSheetData(sheetObj,formObj){
	var colCnt=tab1HeadArr2Cnt;
	var prefix="sheet1_";
	var grayColor="#NANNANNAN";
	for(var k=3; k<=t1sheet1.RowCount(); k++){
		if(t1sheet1.GetCellValue(k,prefix+"cnt_hrs") == ""){
			t1sheet1.SetCellValue(k,prefix+"cnt_hrs","S.TTL");
			//for(var i=1; i<=colCnt+2;i++){
				//t1sheet1.SetCellBackColor(k, i,grayColor);
			//}
		}
	}
	
	var rdIdx=t1sheet1.RowCount()+ t1sheet1.HeaderRows()-1;
	
	t1sheet1.SetCellValue(rdIdx,prefix+"cnt_hrs","G.TTL");
	//var pinkColor="#NANNANNAN";
	//for(var i=1; i<=colCnt+2;i++){
		//t1sheet1.SetCellBackColor(rdIdx, i,pinkColor);
	//}
	t1sheet1.SetRowBackColor(rdIdx,"#F7E1EC")
	t1sheet1.SetRowBackColor(rdIdx - 1,"#F7E1EC")
	t1sheet1.SetRowBackColor(rdIdx - 2,"#F7E1EC")

}
 /**
  * Adding data to Combo
  */	
function addComboItem(comboObj, comboItems) {
	var selCode="";
	if(comboItems){
		if(comboItems.length > 0){
			var comboCnt=comboItems.length;
			for (var i=0; i<comboCnt; i++) {
		 		var comboItem=comboItems[i].split("|");
		 		comboObj.InsertItem(i, comboItem[0], comboItem[0]);
		 	}
			selCode=comboItem[0];
		}else{
			comboObj.InsertItem(0, "","");
		}
	}else{
		comboObj.InsertItem(0, "","");
	}
	comboObj.SetSelectCode(selCode,false);
}
 /*
 * =====================================================================
 * Combo Event
 * =====================================================================
 */
function lane_grp_nm_OnChange(comboObj, Index_Code, Text) {
	if(beforetab == 0){
		delayConData.setLaneGrpNm(Text);
	}
	else if(beforetab == 1){
		skipConData.setLaneGrpNm(Text);
	}
	else if(beforetab == 2){
		skipChangeConData.setLaneGrpNm(Text);
	}
}
 /**
  * Open Lane Code Help
  */  
 function openLandCdHelp(sheetObj){
    var targetObjList="sheet1_vsl_slan_cd:vsl_slan_cd";
    var v_display="0,0";
    var laneCd=document.form.vsl_slan_cd.value;
    var sUrl='/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd;
    
// 	ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);
 	
 	ComOpenPopup(sUrl, 564, 470, "getSlanCdData", "0,0", true);
 } 
 
  /**
  * Open Vessel Code Help
  */  
  function openVslCdHelp(sheetObj){
	  var formObj=document.form;
	  var vsl_cd=document.form.vsl_cd.value;
	  //var sUrl = "/opuscntr/VOP_VSK_0219.do?op_=0219&vsl_cd="+vsl_cd;
	  //var sUrl = "/opuscntr/VOP_VSK_0219.do?f_cmd=" + COMMAND16 + "&vsl_cd="+vsl_cd;
	  var sUrl="/opuscntr/VOP_VSK_0219.do?vsl_cd="+vsl_cd;
//	  var rVal=ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
//	  if(rVal){
//		  formObj.vsl_cd.value=rVal;
//	  }
	  ComOpenPopup(sUrl, 464, 500, "getVslCdData", "0,0", true);
  }  
 /**
  * Open Port Code Help
  */  
  function openPortCdHelp(sheetObj){
	  var formObj=document.form;
	  var port_cd=formObj.vps_port_cd.value;
	  //var sUrl = "/opuscntr/VOP_VSK_0043.do?op_=0043&port_cd="+port_cd;
	  var sUrl="/opuscntr/VOP_VSK_0043.do?port_cd="+port_cd;
//	  var rVal=ComOpenPopupWithTarget(sUrl, 428, 520, "", "0,0", true);
//	  if(rVal){
//		  formObj.vps_port_cd.value=rVal;
//	  }
	  ComOpenPopup(sUrl, 564, 550, "getPortCdData", "0,0", true);
  }
  
  /**
   * Open Carrier Code Help
   */  
   function openCrrCdHelp(sheetObj){
 	  var formObj=document.form;
 	  var crr_cd=formObj.crr_cd.value
 	  //var sUrl = "/opuscntr/VOP_VSK_0252.do?op_=0252&code_type=CD0XXXX&code_value="+crr_cd;
 	 var sUrl="/opuscntr/VOP_VSK_0252.do?code_type=CD0XXXX&code_value="+crr_cd+"&title=Carrier";
// 	  var rVal=ComOpenPopupWithTarget(sUrl, 500, 420, "", "0,0", true);
// 	  if(rVal){
// 		  formObj.crr_cd.value=rVal;
// 	  }
 	  
 	 ComOpenPopup(sUrl, 500, 420, "getCrrCdData", "0,0", true);
   }

   function getVslCdData(rtnObjs){
	   	var formObj=document.form;
		var rtnDatas=rtnObjs;
		
		if(rtnObjs[0][1].length > 0){
			formObj.vsl_cd.value=rtnObjs[0][1]; //vessel code
		}
	}

	function getSlanCdData(obj){
		if(obj){
			var rtnDatas=obj[0];
			
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_slan_cd.value= rtnDatas[1];
				}
			}
		}
	}

	function getPortCdData(rtnObjs){
	   	var formObj=document.form;
		var rtnDatas=rtnObjs;
		
		if(rtnObjs.length > 0){
			formObj.vps_port_cd.value=rtnObjs; //vessel code
		}
	}
	
	function getCrrCdData(rtnObjs){
	   	var formObj=document.form;
		var rtnDatas=rtnObjs;
		
		//if (rtnDatas =="") return;
		if(rtnDatas.length >= 3){
			formObj.crr_cd.value=rtnDatas; //vessel code
		}
	}
	
	
function eventNav(formObj){
	if(formObj.lane_grp[0].checked){
		ComEnableObject(formObj.vsl_slan_cd, true);
		ComEnableObject(formObj.btns_search, true);
		lane_grp_nm.SetEnable(0);
//		formObj.lane_grp_nm.value = "";
		getComboObject("lane_grp_nm").SetSelectCode("",false);
	}else{
		ComEnableObject(formObj.vsl_slan_cd, false);
		ComEnableObject(formObj.btns_search, false);
		lane_grp_nm.SetEnable(1);
		formObj.vsl_slan_cd.value="";
		if(beforetab == 0){
			delayConData.setVslSlanCd(formObj.vsl_slan_cd.value);
		}
		else if(beforetab == 1){
			skipConData.setVslSlanCd(formObj.vsl_slan_cd.value);
		}
		else if(beforetab == 2){
			skipChangeConData.setVslSlanCd(formObj.vsl_slan_cd.value);
		}
		doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
	}
//	if(beforetab == 0){
//		delayConData.setLaneGrp(ComGetObjValue(formObj.lane_grp));
//	}
//	else if(beforetab == 1){
//		skipConData.setLaneGrp(ComGetObjValue(formObj.lane_grp));
//	}
//	else if(beforetab == 2){
//		skipChangeConData.setLaneGrp(ComGetObjValue(formObj.lane_grp));
//	}
	delayConData.setLaneGrp(ComGetObjValue(formObj.lane_grp));
	delayConData.setLaneGrpNm(formObj.lane_grp_nm.value);
	skipConData.setLaneGrp(ComGetObjValue(formObj.lane_grp));
	skipConData.setLaneGrpNm(formObj.lane_grp_nm.value);
	skipChangeConData.setLaneGrp(ComGetObjValue(formObj.lane_grp));
	skipChangeConData.setLaneGrpNm(formObj.lane_grp_nm.value);
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
  * initializing Tab
  * setting Tab items
  */
 function initTab(tabObj , tabNo) {
      switch(tabNo) {
          case 1:
             with (tabObj) {
                 var cnt=0 ;
                 tabClicks[cnt]=false;
                 InsertItem( "Delay Status" , "");
                 tabClicks[cnt]=false;
                 InsertItem( "Skip Status" , "");
                 tabClicks[cnt]=false;
                 InsertItem( "Skip Change Status" , "");
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
	 var formObj=document.form;
     var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    	//alert('nItem:='+nItem);
    	//alert(tabClicks[nItem]);
    	//if( (nItem === 1 || nItem === 2) && tabClicks[nItem]==false )
    	//	doActionIBSheet(sheetObjects[nItem],document.form, IBSEARCH, nItem);
    	for(var i=0; i<tabClicks.length; i++){
    		if(nItem == i){
    			tabClicks[i]=true;
    		}else{
    			tabClicks[i]=false;
    		}
    	}    	
    	resizeSheet();

    	if(nItem == 2){
    		ComBtnDisable("btn_VVDRMKs");
    	}else{
    		ComBtnEnable("btn_VVDRMKs");
    	}
    	setConditionData(formObj, nItem);
 }
 /**
 * Setting Conditions when tab change
 * 
 * @param formObj
 * @param nItem
 * @return
 */
function setConditionData(formObj, nItem){
	switch(nItem) {
		case 0://tab1
			if(delayConData != null){
				delayConData.setAllFormData();
				if(ComIsNull(formObj.act_inp_fm_dt)){
					setToday(document.form.act_inp_fm_dt, "ym");//Setting current year
				}
				if(ComIsNull(formObj.act_inp_to_dt)){
					setToday(document.form.act_inp_to_dt, "ym");//Setting current year
				}
			}
			break;
		case 1:      //tab2
			if(skipConData != null){
				skipConData.setAllFormData();
				if(ComIsNull(formObj.act_inp_fm_dt)){
					setToday(document.form.act_inp_fm_dt, "ym");//Setting current year
				}
				if(ComIsNull(formObj.act_inp_to_dt)){
					setToday(document.form.act_inp_to_dt, "ym");//Setting current year
				}
			}
			break;
		case 2:      //tab3
			if(skipChangeConData != null){
				skipChangeConData.setAllFormData();
				if(ComIsNull(formObj.act_inp_fm_dt)){
					setToday(document.form.act_inp_fm_dt, "ym");//Setting current year
				}
				if(ComIsNull(formObj.act_inp_to_dt)){
					setToday(document.form.act_inp_to_dt, "ym");//Setting current year
				}
			}
			break;
	}
}
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
	 switch(sAction) {
	 	case IBSEARCH:      //Retrieve
	 		with(formObj){
	   			 var creDtFr=ComReplaceStr(act_inp_fm_dt.value,"-","");
	   			 var creDtTo=ComReplaceStr(act_inp_to_dt.value,"-","");
	   			 if(creDtFr =="" || creDtTo == ""){
	   				ComShowCodeMessage('VSK00069');
	   			     return false;
	   			 }
		 		break;	
	 		}
     }
     return true;
 }
 		function t1sheet1_OnChangeSum(sheetObj, Row)
 		{
 			with(sheetObj)
 			{
 			}
 		}
 		function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
 		{
 			with(sheetObj)
 			{
 				if(sheetObjects[0].RowCount()> 0){
		     		showSheetData(sheetObj,document.form);
		     	}
// 				for(var r = 0; r <= 3; r ++)
// 				{
// 					SumText(r, "Lane1") = "Total";
// 					SumText(r, "Blank") = "TTL";
// 					CellAlign(LastRow - 3, "Blank") = daCenter;
//
// 					for(var c = 0; c <= LastCol; c ++)
// 					{
// 						if (0 == SumText(r, c))
// 							SumText(r, c) = "";
// 					}
//
// 				}
// 				SumText(1, "Lane2") = "%";
// 				SumText(3, "Lane2") = "%";
 			}
 		}
 		function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
 		{
// 			with(sheetObj)
// 			{
// 				CellBackColor(1, "Lane1") = "#C9CAEB";
// 				RowHidden(6) = true;
// 				RowHidden(LastRow) = true;
//
// 				for(var r = 0; r <= 3; r ++)
// 				{
// 					SumText(r, "Lane1") = "Total";
//
// 					for(var c = 0; c <= LastCol; c ++)
// 					{
// 						if (0 == SumText(r, c))
// 							SumText(r, c) = "";
// 					}
//
// 				}
//
//
// 			}
 			if(t2sheet1.RowCount() > 0){
 				var rdIdx=t2sheet1.RowCount()+ t2sheet1.HeaderRows() - 1;
 	 			t2sheet1.SetRowBackColor(rdIdx,  "#F7E1EC")
 	 			t2sheet1.SetRowBackColor(rdIdx - 1,  "#F7E1EC")	
 			}
 			
 		}
 		function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
 		{
// 			with(sheetObj)
// 			{
// 				var color1 = "#CCFFFD";
// 				var color2 = "#C9FFB9";
// 				
// 				ColBackColor("Lane") = color1;
// 				ColBackColor("VVD") = color1;
// 				ColBackColor("State1") = color2;
// 				
// 			}
 		}
 	    /**
 	     * Setting data from VVD & Remark(s) Help (Pop-Up)
 	     * @param rtnObjs
 	     * @return
 	     */
 		function getVvdRemark(rtnObjs){
 	    	if(rtnObjs){
 				var rtnDatas=rtnObjs[0];
 				if(rtnDatas){
 					if(rtnDatas.length > 0){
// 						document.form.skd_voy_no.value = rtnDatas[2];
// 						document.form.skd_dir_cd.value = rtnDatas[3];
 					}
 				}
 	    	}
 	    }
/**
 * Returning comboObject with combo id
 * @param comboId
 * @return
 */
function getComboObject(comboId){
	var cnt=comboObjects.length;
	if(cnt > 0){
		for(var i=0; i<cnt; i++){
			if(comboObjects[i].options.id== comboId){
				return comboObjects[i];
			}
		}
	}
	return null;
} 		
/*
 * =====================================================================
 * Form Condition Elements Getter/Setter
 * =====================================================================
 */
function Usr_Condi_FormData(){
	this.laneGrp="";
	this.vslSlanCd="";
	this.laneGrpNm="";
	this.vslCd="";
	this.vpsPortCd="";
	this.actInpFmDt="";
	this.actInpToDt="";
	this.crrCd="";
}
//Usr_Condi_FormData.Getter()
Usr_Condi_FormData.prototype.getLaneGrp=function(){
	return this.laneGrp;
}
Usr_Condi_FormData.prototype.getVslSlanCd=function(){
	return this.vslSlanCd;
}
Usr_Condi_FormData.prototype.getLaneGrpNm=function(){
	return this.laneGrpNm;
}
Usr_Condi_FormData.prototype.getVslCd=function(){
	return this.vslCd;
}
Usr_Condi_FormData.prototype.getVpsPortCd=function(){
	return this.vpsPortCd;
}
Usr_Condi_FormData.prototype.getActInpFmDt=function(){
	return this.actInpFmDt;
}
Usr_Condi_FormData.prototype.getActInpToDt=function(){
	return this.actInpToDt;
}
Usr_Condi_FormData.prototype.getCrrCd=function(){
	return this.crrCd;
}
//Usr_Condi_FormData.Setter()
Usr_Condi_FormData.prototype.setLaneGrp=function(sLaneGrp){
	this.laneGrp=sLaneGrp;
}
Usr_Condi_FormData.prototype.setVslSlanCd=function(sVslSlanCd){
	this.vslSlanCd=sVslSlanCd;
}
Usr_Condi_FormData.prototype.setLaneGrpNm=function(sLaneGrpNm){
	this.laneGrpNm=sLaneGrpNm;
}
Usr_Condi_FormData.prototype.setVslCd=function(sVslCd){
	this.vslCd=sVslCd;
}
Usr_Condi_FormData.prototype.setVpsPortCd=function(sVpsPortCd){
	this.vpsPortCd=sVpsPortCd;
}
Usr_Condi_FormData.prototype.setActInpFmDt=function(sActInpFmDt){
	this.actInpFmDt=sActInpFmDt;
}
Usr_Condi_FormData.prototype.setActInpToDt=function(sActInpToDt){
	this.actInpToDt=sActInpToDt;
}
Usr_Condi_FormData.prototype.setCrrCd=function(sCrrCd){
	this.crrCd=sCrrCd;
}
Usr_Condi_FormData.prototype.setAllFormData=function(){
	var formObj=document.form;
	ComSetObjValue(formObj.lane_grp, this.getLaneGrp());
	formObj.vsl_slan_cd.value=this.getVslSlanCd();
	formObj.vsl_cd.value=this.getVslCd();
	formObj.vps_port_cd.value=this.getVpsPortCd();
	if(ComIsNull(this.getLaneGrpNm())){
		getComboObject("lane_grp_nm").SetSelectCode("",false);
	}else{
		getComboObject("lane_grp_nm").SetSelectCode(this.getLaneGrpNm(),false);
	}
	formObj.act_inp_fm_dt.value=this.getActInpFmDt();
	formObj.act_inp_to_dt.value=this.getActInpToDt();
	formObj.crr_cd.value=this.getCrrCd();
} 		
function checkPeriod(formObj){
	var fmDt=ComReplaceStr(formObj.act_inp_fm_dt.value, "-", "");
	var toDt=ComReplaceStr(formObj.act_inp_to_dt.value, "-", "");
	fmDt=fmDt + "01";
	toDt=toDt + ComGetLastDay(toDt.substring(0, 4).parseInt(), toDt.substring(4, 6).parseInt());
	var tmpDt=ComGetDateAdd(fmDt, "Y", 1);
	if(ComChkPeriod(toDt, tmpDt)==1){
		return true;
	}else{
		return false;
	}
}
function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}

