/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_5005.js
*@FileTitle  : Forecast Accuracy Review (By Week)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
	// common static variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var HeadTitleCnt=0;
	var IBSEARCH01=29;
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
		var sheetObject1=sheetObjects[shtCnt++];
		var sheetObject2=sheetObjects[shtCnt++];
		var sheetObject3=sheetObjects[shtCnt++];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":
					if ( beforetab == 0 ) {	  //retrieving at first tab
						formObject.search_flag.value='WEEK';
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					} else if ( beforetab == 1 ) {	//retrieving at second tab
						formObject.search_flag.value='FACTOR';
						formObject.view_flag[0].checked=true;
						doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
					}
					break;
				case "btn_new":
					formObject.reset();
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					break;
				case "btn_downexcel":
					if ( beforetab == 0 ) {	  //retrieving at first tab
 		    			sheetObjects[0].Down2Excel({ HiddenColumn:0,TreeLevel:false});
			            if(sheetObjects[1].RowCount()> 0){
 			            	sheetObjects[1].Down2Excel({ HiddenColumn:1,TreeLevel:false});
		    	        }
					} else if ( beforetab == 1 ) {	//retrieving at second tab
 						sheetObjects[2].Down2Excel( {DownCols: makeHiddenSkipCol(						sheetObjects[2]), SheetDesign:1,Merge:1 });
					}
					break;
				case "btn_loc_cd":	//calling pop-up for retrieving for Location
	    	        var cnt_cd="";
	    	        var loc_cd="";
		            cnt_cd=formObject.loc_tp_cd.value;
		            loc_cd=formObject.loc_cd.value;
		            if ( formObject.loc_tp_cd.value != '' ) {	
	        			var loc_code="";
	        			if ( form.loc_tp_cd.value == "" ) {
	        				loc_code="rcc_cd";
	        			} else if ( form.loc_tp_cd.value == "R" ) {
	        				loc_code="rcc_cd";
	        			} else if ( form.loc_tp_cd.value == "L" ) {
	        				loc_code="lcc_cd";
	        			} else if ( form.loc_tp_cd.value == "E" ) {
	        				loc_code="ecc_cd";
	        			}
						var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 470, loc_code+":loc_cd", "0,1,1,1,1,1", true);
		            }
					break;					
				case "btn_t1detail":
					ComOpenPopupWithTarget('/opuscntr/EES_EQR_5007.do', 550, 280,"", "0,1,1,1,1,1", true);
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
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
    /**
    * registering initial event 
    */
    function initControl() {
//    	axon_event.addListener('change', 'loc_tp_cd_onchange', 'loc_tp_cd');		//handling changing event at Location
//    	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');				//handling keyup event at LOC_CD 
//    	axon_event.addListener('keyup', 'fm_week_onkeyUp', 'fm_week');				//from_bse_dt keyup handling event
//    	axon_event.addListener('keyup', 'to_week_onkeyUp', 'to_week');				//to_week keyup handling event
//    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');					//handling enter key press event
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 		//handling activate event
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 	//handling deactivate event
    	axon_event.addListenerForm('blur', 'obj_blur', form); 						//handling blur event
//    	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);			//only upper case, numbers
    	axon_event.addListener('click', 'view_flag_click', 'view_flag');			//All   FCST   PFMC   Diff.Vol   Diff.(%)   Evaluation when clicked handling event
    }
    /**
     * in case of clicking view flag
     */
    function view_flag_click() {
        setTimeout(fnc_view_flag_click(),1);
    }
    /**
     * All   FCST   PFMC   Diff.Vol   Diff.(%)   Evaluation when clicked handling event
     * All   FCST   PFMC   Diff.Vol   Diff.(%)   Evaluation 조건별 retrieve.
     */ 
     function fnc_view_flag_click() {
    	 ComOpenWait(true);
    	 if ( sheetObjects[2].RowCount()> 0 ) {
    		 sheetObjects[2].RenderSheet(0);
	    	 var view_flag_value="";
	    	 if ( document.form.view_flag[0].checked ) {
	    		 view_flag_value=document.form.view_flag[0].value;
	    	 } else if ( document.form.view_flag[1].checked ) {
	    		 view_flag_value=document.form.view_flag[1].value;
	    	 } else if ( document.form.view_flag[2].checked ) {
	    		 view_flag_value=document.form.view_flag[2].value;
	    	 } else if ( document.form.view_flag[3].checked ) {
	    		 view_flag_value=document.form.view_flag[3].value;
	    	 } else if ( document.form.view_flag[4].checked ) {
	    		 view_flag_value=document.form.view_flag[4].value;
	    	 } else if ( document.form.view_flag[5].checked ) {
	    		 view_flag_value=document.form.view_flag[5].value;
	    	 }
	    	 var sxml=CimMakeHiddenXml(sheetObjects[2], view_flag_value, "bound|loc_cd|factor|yrwk|tot_qty|d2_qty|d4_qty|d5_qty|d7_qty|r2_qty|r5_qty|o2_qty|s2_qty|o4_qty|s4_qty|f2_qty|a2_qty|f4_qty|a4_qty|f5_qty|dp_seq");
 	    	 sheetObjects[2].LoadSearchData(sxml);
    		 for ( var i=1; i<=sheetObjects[2].RowCount(); i++) {
    			 for ( var j=0; j<HeadTitleCnt; j++ ) {
    				 if ( j >4 ) {
    					 if ( ComIsContainsChars(sheetObjects[2].GetCellValue(i,j), "-") ) {
     						 sheetObjects[2].SetCellFontColor(i,j,"#FF0000");
    					 }
    				 } 
    				 if ( j < 4 ) {
    					 sheetObjects[2].SetCellAlign(i,j,"CenterTop");
    				 }
    			 }
    		 }
    		 sheetObjects[2].RenderSheet(1);
    	 }
     }
     /**
      * fitering All   FCST   PFMC   Diff.Vol   Diff.(%)   Evaluation 
      */ 
     function CimMakeHiddenXml(sheet_obj, pMatch, saveColName)  {
         try {
             var allXml="";
             var sColSep="?";
             var sColOrder="";
             if (saveColName!=undefined && saveColName != null && saveColName!="") {
                 sColOrder=" COLORDER='" + saveColName + "' ";
             }
             allXml="<?xml version='1.0'  ?>\n"
                    + "<SHEET>\n"
             allXml += "  <DATA " + sColOrder + " COLseparator='"+sColSep+"'>\n";
             var aryTRs="";
             var sheetText=sheet_obj.GetRangeText(sheet_obj.HeaderRows(),0,sheet_obj.LastRow(),sheet_obj.LastCol(),sColSep,"^");
             var aryTRs=sheetText.split("^");
             for (var i in aryTRs) {
    			 var color='';
    			 if( sheet_obj.GetCellValue(parseInt(i)+sheet_obj.HeaderRows(), "yrwk") == 'Total' ) {
    				 if ( sheet_obj.GetCellValue(parseInt(i)+sheet_obj.HeaderRows(), "factor") == 'Evaluation' ) {
        				 color='247,225,236';
        			 } else {
        				 color='201, 213, 235';
        			 }
        		 }
            	 if ( pMatch == '' ) {
            		 aryTRs[i]="<TR BGCOLOR='"+color+"'><![CDATA["+aryTRs[i]+"]]></TR>";
            	 } else { 
            		 if(sheet_obj.GetCellValue(parseInt(i)+sheet_obj.HeaderRows(), "dp_seq") != pMatch) {
	               	 	aryTRs[i]="<TR HIDDEN=\"TRUE\" BGCOLOR='"+color+"'><![CDATA["+aryTRs[i]+"]]></TR>";
	                } else {
	               	 	aryTRs[i]="<TR BGCOLOR='"+color+"'><![CDATA["+aryTRs[i]+"]]></TR>";
	                }
            	 }
             }
             allXml += aryTRs.join("\n"); 
             allXml += "  </DATA>\n"
                    +  "</SHEET>";
             return allXml;
         } catch(err) { ComFuncErrMsg(err.message); }
     }         
    /**
     * handling keyup event at LOC_CD 
     */
//    function loc_cd_onkeyUp() {
//        var formObject=document.form;
//        if ( event.keyCode != 16 && event.keyCode != 46 && event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
//    	   document.getElementById("loc_cd").setAttribute("maxLength",5);
//    	   if ( formObject.loc_cd.value.length == 5 ) {
//    		   ComSetFocus(document.form.fm_week);
//    	   }
//        }
//    }    
    /**
     * blur handling event
     */
    function obj_blur() {
		var formObject=document.form;
		switch (event.srcElement.name) {
			case "fm_week":
				if ( ComReplaceStr(formObject.fm_week.value,"-","") != "" && !ComIsDate(formObject.fm_week.value, "yw") ) {
		  			ComShowMessage(msgs["EQR90056"]);
		  			formObject.fm_week.value="";
		  			formObject.fm_week.focus();
		  			return;
		  		}
				break;
			case "to_week":
				if ( ComReplaceStr(formObject.to_week.value,"-","") != "" && !ComIsDate(formObject.to_week.value, "yw") ) {
		  			ComShowMessage(msgs["EQR90056"]);
		  			formObject.to_week.value="";
		  			formObject.to_week.focus();
		  			return;
		  		}
				if( ComReplaceStr(formObject.to_week.value,"-","") != "") {
					if ( !fncCheckWeek() ) {
						formObject.to_week.value="";
						ComSetFocus(formObject.to_week);	
						return;
					}
				}
				break;
			case "loc_cd":
				if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH01) ) {	//checking Location
	     	        return false;
	     	    }				
				break;
		}
	}
    /**
     * handling keypress event
     */
//    function obj_keypress() {
//		var formObject=document.form;
//		switch (event.srcElement.name) {
//			case "loc_cd":
//				ComKeyOnlyAlphabet('upper');// only upper case, numbers
//				break;
//			case "fm_week":
//				ComKeyOnlyNumber(event.srcElement);
//				break;
//			case "to_week":
//				ComKeyOnlyNumber(event.srcElement);
//				break;
//		}
//	}
    /**
     * handling changing event at Location
     */
    function loc_tp_cd_onchange() {
    	var formObject=document.form;
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);  
    }
    /**
     * checking week
     * Max : 53
     * range : +12 week
     */    
    function fncCheckWeek() {
    	var formObj=document.form;
	  	if(formObj.fm_week.value != "" && formObj.to_week.value != "") {
	  		if(formObj.fm_week.value.trimAll("-") > formObj.to_week.value.trimAll("-")) {
	  			ComShowMessage(ComGetMsg("EQR90070","FM"));
	  			formObj.fm_week.focus();
	  			return false;
	  		}
	  		var input1=ComReplaceStr(formObj.fm_week.value,"-","");
	  		var input2=ComReplaceStr(formObj.to_week.value,"-","");
	  		var date1=new Date(input1.substr(0,4),input1.substr(4,2)-1);
	  		var date2=new Date(input2.substr(0,4),input2.substr(4,2)-1);
	  		var interval=date2 - date1;
	  		var day=1000*60*60*24;
	  		var month=day*30;
	  		var year=month*12;
	  		var fromTo=52;  // (01-53)
  			var fm_week_yyyy=input1.substr(0,4);
  			var fm_week_mm=input1.substr(4,2);
  			var to_week_yyyy=input2.substr(0,4);
  			var to_week_mm=input2.substr(4,2);
  			if ( fm_week_yyyy == to_week_yyyy ) {
  				month=eval(to_week_mm) - eval(fm_week_mm) + 1;
  			} else {
  				betwMonth=fromTo - eval(fm_week_mm) + eval(to_week_mm) + 1;
  				if ( (eval(to_week_yyyy) - eval(fm_week_yyyy) ) == 1 ) {	
  					month=betwMonth;
  				} else {	//ex:2009-08 ~ 2011-19
  					month=(eval(to_week_yyyy) - eval(fm_week_yyyy) -1 ) * fromTo + betwMonth;
  				}
  			}
  			if ( month > 12 ) {
  				ComShowMessage(msgs["EQR70007"]);	
  				return false;
  			}
  			return true;
	  	}
    }
    /**
     * handling beforeactivate  event at Period FM  
     */    
 	function obj_activate() {
 		ComClearseparator(event.srcElement);
 	}
     /**
 	* Period to  beforedeactivate handling event
 	* Period to  beforedeactivate YYYY-MM 포멧 처리
 	*/	
 	function obj_deactivate() {
 		ComClearseparator(event.srcElement);
 		obj=event.srcElement;
		if (obj.name == "fm_week") {
			var fm_week=document.form.fm_week.value.substr(0,4)+"-"+document.form.fm_week.value.substr(4,6);
			if ( fm_week == '-' )  {
				document.form.fm_week.value="";
			} else {
				document.form.fm_week.value=fm_week;
			}
		} else if (obj.name == "to_week") {
			var to_week=document.form.to_week.value.substr(0,4)+"-"+document.form.to_week.value.substr(4,6);
			if ( to_week == '-' )  {
				document.form.to_week.value="";
			} else {
				document.form.to_week.value=to_week;
			}
		} 		
 	}
    /**
     * handling keyup event at Week FM 
     */
//     function fm_week_onkeyUp() {
//    	 if ( event.keyCode != 16 && event.keyCode != 46 && event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
//	        var formObject=document.form;
//	        var fm_week=formObject.fm_week.value.replace(/\/|\-|\./g, "");
//	        if ( fm_week.length == 6 ) {
//	        	formObject.fm_week.value=fm_week.substr(0,4)+"-"+fm_week.substr(4,6);
//	        	formObject.to_week.focus();
//	        }
//    	 }
//     }  
     /**
     * handling keyup event at Week TO  
     */
//     function to_week_onkeyUp() {
//    	 if ( event.keyCode != 16 && event.keyCode != 46 && event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
//	        var formObject=document.form;
//	        var to_week=formObject.to_week.value.replace(/\/|\-|\./g, "");
//	        if ( to_week.length == 6 ) {
//	        	formObject.to_week.value=to_week.substr(0,4)+"-"+to_week.substr(4,6);
//	        	formObject.bound.focus();
//	  	   	}
//    	 }
//     }   	
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
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        initControl();
        ComSetFocus(document.form.loc_cd);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "t1sheet1":      //sheet1 init
                with(sheetObj){
		              var HeadTitle1="Bound|Week|ECC|Evaluation|Factor|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              HeadTitleCnt=headCount;
		              (headCount, 6, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0, PrevColumnMergeMode:0} );
		
		              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bound",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"yrwk",     KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eval",     KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"factor",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"tot_qty",  KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD4YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d4_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD5YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d5_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD7YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d7_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidR2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidR5YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r5_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidO2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"o2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidS2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"s2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidO4YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"o4_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidS4YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"s4_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidF2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidA2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"a2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidF4YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f4_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidA4YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"a4_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidF5YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f5_qty",   KeyField:0,   CalcLogic:"",   Format:"" } ];
		               
		              InitColumns(cols);
		
		              SetEditable(0);
		              SetSheetHeight(330);
                    }
                break;
            case "t1sheet2":      //sheet1 init
                with(sheetObj){
		              var HeadTitle1="Bound|ECC|Factor|Week|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5|";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              HeadTitleCnt=headCount;
		              (headCount, 5, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:2, Page:200, DataRowMerge:0, PrevColumnMergeMode:0} );  
		
		              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		              
		              
		
		              var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bound",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"factor",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"yrwk",     KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"tot_qty",  KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD4YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d4_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD5YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d5_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD7YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d7_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidR2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidR5YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r5_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidO2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"o2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidS2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"s2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidO4YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"o4_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidS4YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"s4_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidF2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidA2YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"a2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidF4YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f4_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidA4YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"a4_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidF5YN,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f5_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dp_seq",   KeyField:0,   CalcLogic:"",   Format:"" } ];
		               
		              InitColumns(cols);
		
		              SetEditable(0);
		              SetSheetHeight(388);
                }
            	break;
            case "t2sheet1":      //sheet1 init
                with(sheetObj){
		              var HeadTitle1="FCST|Top|2nd|3rd|4th|5th|6th|7th|8th|9th|10th";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bound",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"yrwk",     KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"eval",     KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"factor",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"tot_qty",  KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD2YN,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"d2_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD4YN,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"d4_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD5YN,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"d5_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidD7YN,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"d7_qty",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:hidR2YN,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"r2_qty",   KeyField:0,   CalcLogic:"",   Format:"" } ];
		               
		              InitColumns(cols);
		
		              SetEditable(0);
//		              SetSheetHeight(160);
		              resizeSheet( sheetObj );
                    }
                break;    
        }
    }

	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
    // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //retrieve
    			if(!validateForm(sheetObj,formObj,sAction)) return;
    			//sheetObj.SetWaitImageVisible(0);
    			ComOpenWait(true); 
	    		formObj.f_cmd.value=SEARCH;
	     		sheetObj.DoSearch("EES_EQR_5005GS.do",FormQueryString(formObj));
                break;
			case IBSEARCH01: //location focusOut
				var inquiryLevel="";
				if ( formObj.loc_tp_cd.value == 'E' ) {
					inquiryLevel="E";
				} else if ( formObj.loc_tp_cd.value == 'L' ) {
					inquiryLevel="L";
				} else if  ( formObj.loc_tp_cd.value == 'R' ) {
					inquiryLevel="R";
				}
				formObj.inquiryLevel.value=inquiryLevel;
				formObj.location.value=formObj.loc_cd.value;
				formObj.f_cmd.value=SEARCH01;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
 				var sXml=sheetObj.GetSearchData("EES_EQR_5005GS.do",FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						if ( formObj.loc_tp_cd.value == 'E' ) {
							ComShowCodeMessage("EQR90203");
						} else if ( formObj.loc_tp_cd.value == 'L' ) {
							ComShowCodeMessage("EQR90202");
						} else if  ( formObj.loc_tp_cd.value == 'R' ) {
							ComShowCodeMessage("EQR90201");
						}
						document.form.loc_cd.value="";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						return true;
					}
				} else {
					ComSetFocus(document.form.fm_week);
				}
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
    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
    	switch(tabNo) {
    		case 1:
    			with (tabObj) {
    				var cnt=0 ;
    				InsertItem( "By Week" , "");
    				InsertItem( "By Factor" , "");
    			}
    			break;
    		case 2:
    			with (tabObj) {
    				var cnt=0 ;
    				InsertItem( "Accuracy Ranking" , "");
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
    	resizeSheet(sheetObjects[2]);
    	//--------------- Important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
    /**
     * Event when clicking Tab
     * retriving for data of selected tab
     */
     function tab1_OnClick(tabObj , nItem)
     {
     	if ( nItem == 0 ) {
			document.form.search_flag.value='WEEK';
 		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     	} else if ( nItem == 1 ) {
     		document.form.search_flag.value='FACTOR';
     		document.form.view_flag[0].checked=true;
 			doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
     	} 
     }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH01) ) {	//checking Location
				 ComSetFocus(document.form.loc_cd);
     	        return false;
    	  	} else {
    	  		if (!ComChkValid(formObj)) return false;
    	  		if (!fncCheckWeek()) return false;
    	  	}
        }
        return true;
    }
    /**
     * Tab1 end of retrieving
     */
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
    	if ( sheetObj.RowCount()> 0 ) {
    		sheetObjects[1].RemoveAll();
	    	var focRow=1;
	    		    	
	    	if ( document.form.bound.value == 'A' ) { // retriving with Forecast="ALL"(adding 2 rows on Accuracy Ranking sheet)
	    		sheetObjects[1].DataInsert();
	    		sheetObjects[1].DataInsert();
	    		var lastPrevRow = parseInt(sheetObj.RowCount())-1;
	    		var lastRow     = parseInt(sheetObj.RowCount());

		    	//for ( var i=sheetObj.LastRow()-1; i<=sheetObj.LastRow(); i++) {
	    		//sheetObjects[2].SetRedrawSum(0);
		    	for ( var i=lastPrevRow; i<=lastRow; i++) {
		    		for ( var j=0; j<HeadTitleCnt; j++ ) {
		    			//alert("sheetObj.GetCellValue("+i+", "+j+") : " + sheetObj.GetCellValue(i, j));
		    			sheetObjects[1].SetCellValue(focRow,j,sheetObj.GetCellValue(i, j),0);
		    			sheetObjects[1].SetCellAlign(focRow,j,"Center");
		    		}
		    		focRow++;
		    	}
		    	//sheetObjects[2].SetRedrawSum(1);
		    	
		    	sheetObj.RowDelete(sheetObj.LastRow()-1, false);  // removing last row -1 on SHEET1
		    	sheetObj.RowDelete(sheetObj.LastRow(), false);    // removing last row on SHEET1
	    	} else {  //selecting which I/B or O/B(adding 1 row)
	    		sheetObjects[1].DataInsert();
	    		for ( var i=0; i<HeadTitleCnt; i++ ) {
	    			sheetObjects[1].SetCellValue(1,i,sheetObj.GetCellValue(sheetObj.LastRow(), i),0);
	    			sheetObjects[1].SetCellAlign(1,i,"Center");
	    		}
		    	sheetObj.RowDelete(sheetObj.LastRow(), false);  // removing last row on SHEET1
	    	}
    	}
		ComOpenWait(false);
   }
    /**
     * Tab2 end of retrieving
     */
	function t1sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{
		ComOpenWait(false);
		//sheetObj.RenderSheet(1);
	}