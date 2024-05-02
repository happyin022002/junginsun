/*=========================================================
 * Copyright(c) 2015 CyberLogitec
 *@FileName   : ESM_BKG_1703.js
 *@FileTitle  : Booking Loading Report
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2015/01/19
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/			 
	/* global variable */
	var sheetObjects=new Array();
	var sheetCnt=0;
	/*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
	var comboObjects=new Array();
	/*********************** EDTITABLE MULIT COMBO END ********************/
	var arrMultiCombo;// variable to set multi combo 
	var orderby=""; 
 
	/* init */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}	
    function loadPage() {  
		loadingMode=true;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		for (i=0; i < sheetObjects.length; i++) {			
		    ComConfigSheet(sheetObjects[i]);
		    initSheet(sheetObjects[i], i + 1);
		    ComEndConfigSheet(sheetObjects[i]);
		}			
		loadingMode=false;
		
		initControl();
    }
    function initCombo(comboObj, comboId) {
		with(comboObj) {
	    	switch(comboObj.options.id) {
	        	case "r_term":
	        	case "d_term":
	        	case "bkg_sts_cd":	
        			SetMultiSelect(1);
        			SetMultiSeparator(",");
	        		break;
	        	case "bkg_cgo_tp_cd":
	        		DeleteItem(1);	        		
	        		break;
	        	case "eq_type":
	        		InsertItem(0, "", "");	        		
	        		break;	        		
	        	case "report_type":	        		
	        		SetSelectIndex(0);
	        		break;	        		
	    	}			
            ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고				
		}
	} 	 	
 
/*********************** KEY EVENT START ********************/
    function initControl() {
    	axon_event.addListenerForm('keydown','bkg_keydown',document.form); 	//20150317.MOD
    }
    
    /** 20150317.ADD */
    function bkg_keydown() {
        var obj=event.srcElement;
        var vKeyCode=event.keyCode;
        if ( vKeyCode == 13 ) {
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }     
/*********************** KEY EVENT END ********************/
	
	// Event handler processing by button click event */
 		document.onclick=processButtonClick;		
 	// Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject1=sheetObjects[0];
		  var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	    	try {
	     		var srcName=ComGetEvent("name");
	     		 if(ComGetBtnDisable(srcName)) return false;
		 			switch(srcName) {	
		 				case "btn_Direct_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;			 			
		 				case "btn_Sort":
			 				ComOpenWindowCenter2("/opuscntr/ESM_BKG_0161.do?isPop=Y&codeGubun=", "OrderBy", 420,250,false,"scrollbars=no,resizable=yes");
		 				  break; 		 					
		 				case "btn_New":
		 					initAll(formObject);
		 					for(k=0;k<comboObjects.length;k++){
		 						initCombo(comboObjects[k],comboObjects[k].id);
		 					}
		 					break;
		 				case "btn_ReportTemplate":
	 						var retVal=ComOpenPopup('/opuscntr/ESM_BKG_0104.do?p_bkg_rpt_knd_cd='+formObject.p_bkg_rpt_knd_cd.value, 850, 500, 'TemplateSet', '1,0', false,false, 0, 0, 0,"fra_pop");
							break;	
						case "pol_local":
							if(formObject.pol_local.checked){
								formObject.pol_ts.checked=false;
							}
							break; 		
						case "pol_ts":
							if(formObject.pol_ts.checked){
								formObject.pol_local.checked=false;
							}
							break; 										
						case "pod_local":
							if(formObject.pod_local.checked){
								formObject.pod_ts.checked=false;
							}
							break; 		
						case "pod_ts":
							if(formObject.pod_ts.checked){
								formObject.pod_local.checked=false;
							}
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
	
	// handling of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        
		case IBCLEAR:	
			formObj.f_cmd.value=INIT;	
			var sXml=sheetObj.GetSearchData("ESM_BKG_1703GS.do", FormQueryString(formObj));
			arrMultiCombo=sXml.split("|$$|");	
			initAll(formObj);
			break;        
			
		case IBSEARCH:
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH01;
				formObj.orderby.value=orderby;
				formObj.target="_top";
	            formObj.action="ESM_BKG_1703DL.do?"+FormQueryString(formObj);
	            formObj.submit();
	            sheetObj.RemoveEtcData(); // Delete ETC data
			break;		
	    }
     }
			
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction) {
    		case IBSEARCH:
    			if (ComIsNull(formObj.vvd_cd)) {
    				ComShowCodeMessage('BKG00626','VVD');
 					formObj.vvd_cd.focus();
 					return false;  
    			}
	  			break;
    		case IBSAVE:
	  			break;
    	 }
         return true;
     }
/*############################# combo onchage start ########################*/
     /**
	 *  2015.03.02.MOD
	 */
	function report_type_OnChange(comboObj,oldindex, oldtext, oldcode , newindex, newtext , newcode){
		if(rptIdArr != null){
			document.form.rpt_id.value = rptIdArr[newindex];
		}
	}   	 
/*############################# combo onchage end ########################*/		
	/*
	 *  initializing all condition
	 * */
	var rptIdArr;
	function initAll(formObject){
		formObject.reset();
		ComXml2ComboItem(arrMultiCombo[0], report_type, 	"sql_ctnt_col_nm", "rpt_nm");
		var arr=ComBkgXml2Array(arrMultiCombo[0], "rpt_nm");
		if(arr == undefined) return;		
		var rptIdStr = ComXml2ComboString(arrMultiCombo[0], "rpt_id", "rpt_id")[0];
		rptIdArr = rptIdStr.split("|");
		
		ComXml2ComboItem(arrMultiCombo[1], dir_cd,      	"val", "val");
		ComXml2ComboItem(arrMultiCombo[2], r_term,      	"val", "val");
		ComXml2ComboItem(arrMultiCombo[3], d_term,      	"val", "val");
		ComBkgXml2ComboItem(arrMultiCombo[4], bkg_cgo_tp_cd,"val", "desc");
		ComXml2ComboItem(arrMultiCombo[5], eq_type,    		"cntr_tpsz_cd", "cntr_tpsz_cd");
		ComBkgXml2ComboItem(arrMultiCombo[6], bkg_sts_cd,  	"val", "name");		
		for (var i=0; i < sheetObjects.length; i++) {			
		    sheetObjects[i].RemoveAll();
		}
	}
	
	/**
      * initSheet
      */
    function initSheet(sheetObj,sheetNo,ColList) {
	    sheetObj.UseUtf8=true;
	    var cnt=0;
	    switch(sheetObj.id) {
	    	case "search_options":
		        with(sheetObj){			
					  var HeadTitle1="Search Options";
					  var headCount=ComCountHeadTitle(HeadTitle1);
					
					  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					  InitHeaders(headers, info);
					
					  var cols = [ {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"search_options" } ];
					   
					  InitColumns(cols);						
					  SetEditable(0);
					  SetCountPosition(0);//[1/3]page
					  SetSheetHeight(100);
		
                    }
				break;    	            
	    }
     }       
     
     /* setting Sort in POP-UP   * */
     function setOrderBy(val){    	 
    	 //orderby = val;
    	 orderby = "";				//@@@
     }
     
	/* the end of developer's work */    
