/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0107.js
*@FileTitle  : Allocation Result(Internal Pricing)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/26
*SJH.20150106.MOD : 전반수정
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
   /**
     * @fileoverview 
     */
    /**
     * @extends 
     * @class ESM_COA_0107 : ESM_COA_0107 Business script for the UI
     */
   	/* Developer's task	*/
	//Grobal Variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var loadingMode=false;
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":		//Retrieve
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_Create":			//Create
					doActionIBSheet(sheetObject,formObject,IBCREATE);
					break;
				case "btn_Applytopl":	    //Apply To PL
					doActionIBSheet(sheetObject,formObject,IBBATCH);
					break;
				case "btn_Downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
			}
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", ""));
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	function loadPage(){
		for(i=0;i<sheetObjects.length;i++){
			//Sheet configuration setting function(start)
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//Sheet configuration setting function(end)
			ComEndConfigSheet(sheetObjects[i]);
		}
		loadingMode=true;
	    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	    for(k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
	    loadingMode=false;
	}
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:		//sheet1 init
			    with(sheetObj){
		       // (11, 0, 0, true);
		      var HeadTitle="STS|From.Trade|From.IOC|From.Lane|From.VVD|Internal Exp|To.Trade|To.IOC|To.Lane|To.VVD|Internal Exp";
		      var cnt=0;

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_ioc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_lane_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"fx_cost_dtrb_amt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_ioc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_lane_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"fx_cost_dtrb_amt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
			  resizeSheet();
		            }
				break;
		}
	}
	/**
	 * Setting multicombo items
	 * SJH.20150106.MOD
	 */
	function initCombo(comboObj, comboId) {
	    with(comboObj) {
	    	
	        SetDropHeight(300);
	        SetMultiSelect(0);
	        SetMaxSelect(1);
	        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	        SetSelectIndex(0);
	        
	        switch(comboObj.options.id) {
	        case "f_seltrade":
	                SetMaxLength(3);
	            break;
	        case "f_selrlane":
	                SetMaxLength(5);
	            break;   
	        }        
	    }
	}
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:          //SJH.20150106.MOD
        		//SJH.20150106.ADD/MOD
	        	formObj.f_yearM.value=ComGetNowInfo("yy");
	            formObj.f_year.value=ComGetNowInfo("yy");            
	            formObj.f_fm_mon.value=ComGetNowInfo("mm").lpad(2, "0");
	            formObj.f_to_mon.value=ComGetNowInfo("mm").lpad(2, "0");
	            
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
 				var sXml=sheetObj.GetSearchData("ESM_COA_0107GS2.do", coaFormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				
	          	//SJH.20150106.ADD/MOD
	            formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
	            formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
	            formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
	            formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW"); 
	            document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";  
				
				if (0 < arrXml.length) 
					ComXml2ComboItem(arrXml[0], f_seltrade, "code", "name");
				if (1 < arrXml.length)
					ComXml2ComboItem(arrXml[1], f_selrlane, "code", "name");
				if (3 < arrXml.length)
					ComXml2ComboItem(arrXml[3], f_selcost, "code", "name");
				
				ComOpenWait(false);
				break;
			case IBSEARCH:      //Inquiry
	          if(!validateForm(sheetObj,formObj,sAction)) return false;
	          // Prohibit button click when a business transaction is processing 
	          sheetObj.SetWaitImageVisible(0);
	          ComOpenWait(true);
	          if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value=fillZero(formObj.f_fm_mon.value, 2, '0','left');
	          if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value=fillZero(formObj.f_to_mon.value, 2, '0','left');
	          if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value=fillZero(formObj.f_fm_wk.value, 2, '0','left');
	          if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value=fillZero(formObj.f_to_wk.value, 2, '0','left');
	          formObj.f_cmd.value=SEARCHLIST;
 	          sheetObj.DoSearch("ESM_COA_0107GS.do", coaFormQueryString(formObj) );
//	          ComOpenWait(false);
	          break;
	        case IBCREATE:      //SJH.20150106.MOD
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
				if (sheetObj.RowCount()> 0) {
                    if (ComShowConfirm(ComGetMsg('COA10020')) == true) { 
                        ComOpenWait(true);                       
                                                
                        setTimeout( function () {
                        	formObj.f_cmd.value=MULTI01;
	                        var sParam = sheetObj.GetSaveString(1);
	                        if (sheetObj.IsDataModified() && sParam == "") return;
	                        sParam = sParam + "&" + FormQueryString(formObj);
	                        var sXml = sheetObj.GetSaveData("ESM_COA_0107GS.do", sParam );
	        	            sheetObj.LoadSaveData(sXml, {Sync:1});
	                        
	                        var err_cd = ComGetEtcData(sXml, "err_cd");
	                        var err_msg = ComGetEtcData(sXml, "err_msg");	                        
	        	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
	        	                return false;
	        	            }	                
	                        if (err_cd == "00000") {
	                            ComShowMessage(ComGetMsg('COA10018','CREATION')); 
	                        } else {
	                            ComShowMessage("["+err_cd+"]:"+err_msg);
	                        }
	                        sheetObj.SetEtcData("err_cd","");
	                        sheetObj.SetEtcData("err_msg","");
	                        
	                        ComOpenWait(false);
                        }, 100);
                    }
                } else {
                    ComShowMessage(ComGetMsg('COA10017'));
                }
				break;
	      case IBBATCH:      //SJH.20150106.MOD
	          if(!validateForm(sheetObj,formObj,sAction)) return false;
	          
	          if (sheetObj.RowCount()> 0) {
                  if (ComShowConfirm(ComGetMsg('COA10020')) == true) { 
                      ComOpenWait(true);                       
                      
                      setTimeout( function () {
                      		formObj.f_cmd.value=MULTI02;
	                        var sParam = sheetObj.GetSaveString(1);
	                        if (sheetObj.IsDataModified() && sParam == "") return;
	                        sParam = sParam + "&" + FormQueryString(formObj);
	                        var sXml = sheetObj.GetSaveData("ESM_COA_0107GS.do", sParam );
	        	            sheetObj.LoadSaveData(sXml, {Sync:1});
	                        
	                        var err_cd = ComGetEtcData(sXml, "err_cd");
	                        var err_msg = ComGetEtcData(sXml, "err_msg");	                        
	        	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
	        	                return false;
	        	            }	                
	                        if (err_cd == "00000") {
	                            ComShowMessage(ComGetMsg('COA10018','Apply to P/L Chart')); 
	                        } else {
	                            ComShowMessage("["+err_cd+"]:"+err_msg);
	                        }
	                        sheetObj.SetEtcData("err_cd","");
	                        sheetObj.SetEtcData("err_msg","");
	                        
	                        ComOpenWait(false);
                      }, 100);
                  }
              } else {
                  ComShowMessage(ComGetMsg('COA10017'));
              }
	          break;
	      case IBDOWNEXCEL:   // Excell download
	          var excelType=selectDownExcelMethod(sheetObj, "0");	  
              break;
		}
	}
	
	/**
	* Download Excel
	*/
	function callBackExcelMethod(excelType){    	
    	callBackExcelMethod2(excelType[0], excelType[1]);
   	}
	
	function callBackExcelMethod2(excelType, shtNo){
	    var sheetObj = sheetObjects[shtNo];
	    switch (excelType) {
	        case "AY":
	            sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	            break;
	        case "AN":
		    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	break;
	        case "DY":
	        	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	        	break;
	        case "DN":
		    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;		
		}
   	}

    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
		ComOpenWait(false);
    }			
	
	/**
	 * Change the period when the year, month, week is changed
	 */
	function setPeriod(obj) {
		ComCoaSetPeriod(obj);
	}
	/**
     * Reflash the rLane list when a trade code is changed
     */
 	function f_seltrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=SEARCHLIST01;
		var sXml=sheetObj.GetSearchData("ESM_COA_0107GS2.do", coaFormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], f_selrlane, "code", "name");
		f_selrlane.SetSelectIndex(0);
	}
	/**
	 * Handling process for form object input validation
	 * SJH.20150106.MOD
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
	      if(!chkValidSearch()) return false;
	   	}
	    return true;
	}

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
	/* Developer's task ends */
