/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0028.js
*@FileTitle  : Stock Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23 
=========================================================*/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var headCnt=0;
var tot_cntr_tpsz_cd="";
var obj_cntr_tpsz_cd="";
var comboObjects=new Array();
var comboCnt=0 ;
var IBSEARCH01=29;
var IBSEARCH02=30;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
    function processButtonClick(){
        var shtCnt=0;
        var sheet1=sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject=document.form;
        var yard_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"loc_cd");
        var cntr_tpsz_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_tpsz_cd");
        var loc_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"loc_cd");
        var lvl=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"lvl");
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheet1,formObject,IBSEARCH);
                    break;
                case "btn_downexcel":
                	//doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
                	if(sheetObjects[0].RowCount() < 1){//no data	
                		ComShowCodeMessage("COM132501");
                	}else{	
                		sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:0 });
                	}	
                    break;
                case "btn_new":
                    sheet1.RemoveAll();
                    formObject.reset();
                    comboObjects[0].SetSelectText("");
                    ComSetFocus(document.form.loc_cd);
                    
                    sheetObjects[0].SetCellText(0, "loc_cd", "Yard");
                    break;
                case "btn_cntrdata":
                	if ( sheetObjects[0].RowCount()> 0 ) {
                		if ( formObject.param_loc_type_code.value == '4' ) {	//yard
                			yard_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"loc_cd");
                		} else {
                			yard_cd='';
                		}
                		if ( yard_cd == 'Total' ) {
                			yard_cd='';
                		}
                		if ( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"lvl") == '10' ) {	//total
                			loc_cd=formObject.param_loc_cd.value;
                		} else if ( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"lvl") == '01' ) {	//sub total
                			cntr_tpsz_cd="";
                		} else {
                			loc_cd=loc_cd.substr(0,5);
                		}
                    	var param="loc_cd=" + loc_cd
                		   +"&loc_type_code=" + formObject.param_loc_type_code.value
                		   +"&cntr_tpsz_cd=" + cntr_tpsz_cd
                		   +"&fm_stk_jb_dt=" + formObject.param_fm_stk_jb_dt.value
                		   +"&to_stk_jb_dt=" + formObject.param_to_stk_jb_dt.value
                		   +"&yard_cd=" + yard_cd
                		   +"&lvl=" + lvl
                		   +"&obj_cntr_tpsz_cd=" + obj_cntr_tpsz_cd;
		 		 		ComOpenPopup("/opuscntr/EES_CIM_0029.do?"+ param, 710, 468, "", "1,0", true);
                	}
                    break; 
                case "btn_duedata":
                	if ( sheetObjects[0].RowCount()> 0 ) {
                		if ( formObject.param_loc_type_code.value == '4' ) {	//yard
                			yard_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"loc_cd");
                		} else {
                			yard_cd='';
                		}
                		if ( yard_cd == 'Total' ) {
                			yard_cd='';
                		}
                		if ( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"lvl") == '10' ) {	//total
                			loc_cd=formObject.param_loc_cd.value;
                		} else if ( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"lvl") == '01' ) {	//sub total
                			cntr_tpsz_cd="";
                		} else {
                			loc_cd=loc_cd.substr(0,5);
                		}
                    	var param="loc_cd=" + loc_cd
                		   +"&loc_type_code=" + formObject.param_loc_type_code.value
                		   +"&cntr_tpsz_cd=" + cntr_tpsz_cd
                		   +"&fm_stk_jb_dt=" + formObject.param_fm_stk_jb_dt.value
                		   +"&to_stk_jb_dt=" + formObject.param_to_stk_jb_dt.value
                		   +"&yard_cd=" + yard_cd
                		   +"&lvl=" + lvl
                		   +"&obj_cntr_tpsz_cd=" + obj_cntr_tpsz_cd;
                		ComOpenPopup("/opuscntr/EES_CIM_0030.do?"+ param,900, 445, "", "1,0", true);
                	}
	 		 		break;
                case "btn_detail":
                	if ( formObject.param_loc_type_code.value != '4' && sheetObjects[0].RowCount()> 0 ) {
                		if ( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"lvl") == '10' ) {
                			yard_cd="";
                			loc_cd=formObject.param_loc_cd.value;
                		} else if ( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"lvl") == '01' ) {
                			cntr_tpsz_cd="";
                		}
                    	var param="loc_cd=" + loc_cd
                		   +"&loc_type_code=" + formObject.param_loc_type_code.value
                		   +"&fm_stk_jb_dt=" + formObject.param_fm_stk_jb_dt.value
                		   +"&to_stk_jb_dt=" + formObject.param_to_stk_jb_dt.value
                		   +"&yard_cd=" + yard_cd
                		   +"&obj_cntr_tpsz_cd=" + obj_cntr_tpsz_cd; 
//                		ComOpenPopup("/opuscntr/EES_CIM_0031.do?"+ param,930, 410, "", "1,0,1,1,1,1,1,1", true);
                    	ComOpenPopup("/opuscntr/EES_CIM_0031.do?"+ param,930, 410, "", "1,0", true);
                	}
                    break;
    			case "btn_loc_cd":	//retrieving Location popup
    		    	var loc_code="";
    		      	if ( document.form.loc_type_code[0].checked ) {
    		      		loc_code='rcc_cd';
    		      	} else if ( document.form.loc_type_code[1].checked ) {
    		      		loc_code='lcc_cd';
    		      	} else if ( document.form.loc_type_code[2].checked ) {
    		      		loc_code='ecc_cd';
    		      	} else if ( document.form.loc_type_code[3].checked ) {
    		      		loc_code='scc_cd';
    		      	}
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, loc_code+":loc_cd", "0,1,1,1,1,1", true);
    				break;
    			case "btns_calendarfm":
					var cal=new ComCalendar();
					cal.select(formObject.fm_stk_jb_dt, 'yyyy-MM-dd');
    				break;	
    			case "btns_calendarto":
					var cal=new ComCalendar();
					cal.select(formObject.to_stk_jb_dt, 'yyyy-MM-dd');
    				break;	
        		case "btn_save":
        			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
        }
	    for(p=0;p< comboObjects.length;p++){
	    	initCombo (comboObjects[p],p+1);
	    }
        initControl();
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * caliin event after end of loading 
     * getting TP/SZ data
     */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
    }        
     /**
      * registering IBCombo Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setComboObject(combo_obj){
         comboObjects[comboCnt++]=combo_obj;
     }
     /**
      * initializing Tab
      * setting Tab items
      */
     function initCombo (comboObj, comboNo) {
     }    
    /**
     * registering initial event 
     */
    function initControl() {
     	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 					
     	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 				
     	axon_event.addListenerFormat('blur', 'obj_blur', form);
    } 
    /**
     * registering TP/SZ click event
     */
    function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
	/**
	 * handling Location  blur event
	 * validating Location code
	 */	
	function obj_blur() {
		switch (ComGetEvent("name")) {
			case "loc_cd":
				if ( document.form.loc_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
				}
				break;
		}
	}
    /**
     * handling Period FM  beforeactivate event
     */    
	function obj_activate() {
		ComClearSeparator(ComGetEvent());
	}
    /**
	* handling Period to  beforedeactivate event
	* YYYY-MM format
	*/	
	function obj_deactivate() {
		ComClearSeparator(ComGetEvent());
		obj=event.srcElement;
		if (obj.name == "fm_stk_jb_dt") {
			ComAddSeparator(ComGetEvent());
		} else if (obj.name == "to_stk_jb_dt") {
			ComAddSeparator(ComGetEvent());
		}
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id ; 
        switch(sheetID) {
             case "sheet1":      //sheet1 init
                with (sheetObj) {
            	    var HeadTitle1="Yard|TP/SZ|Available|Sound|Damage|Total|Due Out|Due In|Optimum|Variance";
            	    headCnt=HeadTitle1.split("|").length;
            	    SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
                    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
            	    
            	    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	    InitHeaders(headers, info);
            	    var cols = [ 
            	              {Type:"Text",   Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
            	              {Type:"Int",       Hidden:0,  Width:150,   Align:"Right",   ColMerge:1,   SaveName:"aval_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Int",       Hidden:0,  Width:150,   Align:"Right",   ColMerge:1,   SaveName:"snd_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Int",       Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"dmg_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Int",       Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"tot_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Int",       Hidden:0,  Width:150,   Align:"Right",   ColMerge:1,   SaveName:"due_out_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Int",       Hidden:0,  Width:150,   Align:"Right",   ColMerge:1,   SaveName:"due_in_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Text",      Hidden:0,  Width:150,   Align:"Right",   ColMerge:1,   SaveName:"cntr_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
            	              {Type:"Int",       Hidden:0,  Width:150,   Align:"Right",   ColMerge:1,   SaveName:"vari_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Text",      Hidden:1, Width:0,   Align:"Right",   ColMerge:1,   SaveName:"lvl",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            	              {Type:"Status",    Hidden:1, Width:0,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	              {Type:"AutoSum",   Hidden:1, Width:0,  Align:"Left",    ColMerge:1},
            	              ];
            	    InitColumns(cols);
            	    //SetSheetHeight(422);
            	    resizeSheet();
            	    SetEditable(1);
                }
                break; 
        }
    }
    // Sheet의 높이 자동으로 변경
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:   
	    	   if(!validateForm(sheetObj,formObj,sAction)) return;
	    	  	if(formObj.fm_stk_jb_dt.value != "" && formObj.to_stk_jb_dt.value != "") {
	    	  		if(ComReplaceStr(formObj.fm_stk_jb_dt.value,"-","") > ComReplaceStr(formObj.to_stk_jb_dt.value,"-","")) {
	    	  			ComShowMessage(ComGetMsg("CIM30020", "To", "FM", "greater"));
	    	  			formObj.to_stk_jb_dt.focus();
	    	  			return false;
	    	  		}
	    	  	}
	    	  	if ( eval(ComGetDaysBetween(formObj.chk_date.value, formObj.fm_stk_jb_dt.value)) < 0 ) {	//시스템날짜 기준 90일 이전이라면
	    	  		if ( formObj.to_stk_jb_dt.value == "" ) {	//to는 필수
	    	  			ComShowMessage(ComGetMsg("CIM30014", "To"));
	    	  			ComSetFocus(formObj.to_stk_jb_dt);
	    	  			return false;
	    	  		} else {
	    	  			if ( eval(ComGetDaysBetween(formObj.fm_stk_jb_dt.value, formObj.to_stk_jb_dt.value)) > 100 ) {	//from ~ to 기간이 100일 이상이라면
	    	  				ComShowMessage(ComGetMsg("COM132001","Period","100 Day"));
	    	  				ComSetFocus(formObj.fm_stk_jb_dt);
	    	  				return false;
	    	  			}
	    	  		}
	    	  	}
	    	   sheetObj.SetWaitImageVisible(0);
	    	   ComOpenWait(true); 
	    	   formObj.f_cmd.value=SEARCH;
 	    	   sheetObj.DoSearch("EES_CIM_0028GS.do",FormQueryString(formObj) );
	    	   ComOpenWait(false); 
	    	   break;
           case IBSEARCH01:   
        	   sheetObj.SetWaitImageVisible(0);
        	   form.f_cmd.value=SEARCH01;
         	   var sXml=sheetObj.GetSearchData("EES_CIM_0028GS.do" , FormQueryString(form));
        	   var v_cntr_tpsz_cd=ComGetEtcData(sXml,"cntr_tpsz_cd");	   //retrieving TP/SZ
        	   tot_cntr_tpsz_cd=v_cntr_tpsz_cd;
        	   obj_cntr_tpsz_cd=v_cntr_tpsz_cd;
        	   var strCntrTpszCd=v_cntr_tpsz_cd.split("|");
        	   //initializing multi Combo
        	   with (cntr_tpsz_cd) {
        		   SetMultiSelect(1);
        		   SetMultiSeparator(",");
        		   SetDropHeight(330);
        		   InsertItem(0 , 'ALL','');
        		   for ( var i=1; i<=v_cntr_tpsz_cd.split("|").length; i++) {
        			   InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
        		   }
        	   }    
        	   ComSetFocus(document.form.loc_cd);
	    	   break;
	       	case IBSEARCH02:      //validating location cd
				var inquiryLevel="";
		      	if ( document.form.loc_type_code[0].checked ) {
		      		inquiryLevel='R';
		      	} else if ( document.form.loc_type_code[1].checked ) {
		      		inquiryLevel='L';
		      	} else if ( document.form.loc_type_code[2].checked ) {
		      		inquiryLevel='E';
		      	} else if ( document.form.loc_type_code[3].checked ) {
		      		inquiryLevel='S';
		      	}
				formObj.inquiryLevel.value=inquiryLevel;
				formObj.location.value=formObj.loc_cd.value;
				formObj.f_cmd.value=SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
 				var sXml=sheetObj.GetSearchData("EES_CIM_0028GS.do",FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("CIM30017");
						document.form.loc_cd.value="";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						ComSetFocus(document.form.loc_cd);
						return true;
					}
				} else {
					ComSetFocus(document.form.cntr_tpsz_cd);
				}
				break;	    		    	   
           case IBSAVE:     
	    	   if ( document.form.param_loc_type_code.value != '4' ) {	//yard
	    		   ComShowCodeMessage("CIM30018");
	    		   return;
	    	   }
	    	   if(validateForm(sheetObj,formObj,sAction))
	    	   formObj.f_cmd.value=MULTI;
	    	   sheetObj.DoSave("EES_CIM_0028GS.do",FormQueryString(formObj),"ibflag",true);
		       break;
   		case IBDOWNEXCEL:    
   			if(sheetObj.RowCount() < 1){//no data
      			ComShowCodeMessage("COM132501");
      		}else{
    			sheetObj.Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
      		}
			break;		       
        }
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
            	return false;
            }
        	if (!ComChkValid(formObj)) return false;
        }
        return true;
    }
    /**
     * end of retrieving Tab1 
     * calling event after retrieving Tab1
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObject=document.form;
      	if ( sheetObj.RowCount()> 0 ) {
		   	for ( var j=0; j<headCnt; j++ ) {
		   		sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-1, j),0);
		   		if ( eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.LastRow(),"cntr_qty"),",","")) >= 0 ) {
 					sheetObj.SetCellFontColor(sheetObj.LastRow(),"cntr_qty","#0000FF");
				} else {
 					sheetObj.SetCellFontColor(sheetObj.LastRow(),"cntr_qty","#FF0000");
				}
		   		if ( eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.LastRow(),"vari_qty"),",","")) >= 0 ) {
 					sheetObj.SetCellFontColor(sheetObj.LastRow(),"vari_qty","#0000FF");
				} else {
 					sheetObj.SetCellFontColor(sheetObj.LastRow(),"vari_qty","#FF0000");
				}
		   		sheetObj.SetRowHidden(sheetObj.LastRow(),1);
			}
	    	sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
	    	sheetObj.RowDelete(sheetObj.LastRow()-1, false);
//	    	sheetObj.SetCellValue(sheetObj.LastRow()-1,"loc_cd",'');
	      	sheetObj.SetCellValue(sheetObj.LastRow(), 0, "G.Total");
	      	sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
	    	var param_loc_type_code="";
	      	if ( document.form.loc_type_code[0].checked ) {
	      		sheetObj.SetCellValue(0,"loc_cd",'LCC');
	      		param_loc_type_code="1";
	      	} else if ( document.form.loc_type_code[1].checked ) {
	      		sheetObj.SetCellValue(0,"loc_cd",'ECC');
	      		param_loc_type_code="2";
	      	} else if ( document.form.loc_type_code[2].checked ) {
	      		sheetObj.SetCellValue(0,"loc_cd",'SCC');
	      		param_loc_type_code="3";
	      	} else if ( document.form.loc_type_code[3].checked ) {
	      		sheetObj.SetCellValue(0,"loc_cd",'Yard');
	      		param_loc_type_code="4";
	      	}
	      	formObject.param_loc_cd.value=formObject.loc_cd.value; 
	      	formObject.param_loc_type_code.value=param_loc_type_code; 
	      	formObject.param_cntr_tpsz_cd.value=comboObjects[0].GetSelectCode();
	      	formObject.param_fm_stk_jb_dt.value=formObject.fm_stk_jb_dt.value; 
	      	formObject.param_to_stk_jb_dt.value=formObject.to_stk_jb_dt.value;
	      	if ( param_loc_type_code == '4') { 
	      		ComBtnDisable('btn_detail');
	      	} else {
	      		ComBtnEnable('btn_detail');
	      	}
      	}
      //no support[implemented common]CLT 	sheetObj.SelectHighLight=false;
    }
    /**
     * setting values from Location by loc_cd popup
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
       var sheetObject=sheetObjects[0];
       var formObject=document.form;
       formObject.loc_cd.value=aryPopupData[0][3] 
    }
    /**
     * event when inputting key in cell>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	
     * @param {ibsheet} col     	
     **/
    function sheet1_OnAfterEdit(sheetObj, Row, Col) {
    	switch (sheetObj.ColSaveName(Col)) {
    		case "cntr_qty":
    			setCaluValue(sheetObj, Row, Col);
    			break;
    	}
    }
    /**
     * Variance = Available - applying Optimum calculation logic
    */    
	function setCaluValue(sheetObj, Row, Col) {
		sheetObj.SetCellValue(Row, "vari_qty",sheetObj.GetCellValue(Row, "aval_qty") - sheetObj.GetCellValue(Row, "cntr_qty"),0);
		var tot_pos_cntr_qty=0;	//Total by Yard 
		var tot_row_cntr_qty=0;	
		var tot_cntr_qty=0;
		var tot_pos_vari_qty=0;	//Total by Yard 
		var tot_fos_tpsz_row=0;
		var tot_row_vari_row=0;
		var tot_fos_tpsz_row=0;
		var tot_vari_qty=0;
		for ( var i=1; i<=sheetObj.RowCount(); i++ ) {
			if ( sheetObj.GetCellValue(i, "loc_cd") == sheetObj.GetCellValue(Row, "loc_cd") && sheetObj.GetCellValue(i, "lvl") != "01"  ) {
				tot_pos_cntr_qty=tot_pos_cntr_qty + eval(ComReplaceStr(sheetObj.GetCellValue(i, "cntr_qty"),",",""));
				tot_pos_vari_qty=tot_pos_vari_qty + eval(ComReplaceStr(sheetObj.GetCellValue(i, "vari_qty"),",",""));
			}
			if ( sheetObj.GetCellValue(i, "loc_cd") == sheetObj.GetCellValue(Row, "loc_cd") && sheetObj.GetCellValue(i, "lvl") == "01"  ) {
				tot_row_cntr_qty=i;
			}
			if ( sheetObj.GetCellValue(i, "cntr_tpsz_cd") == sheetObj.GetCellValue(Row, "cntr_tpsz_cd") && sheetObj.GetCellValue(i, "lvl") == "00" ) {
				tot_fos_tpsz_row=tot_fos_tpsz_row + eval(ComReplaceStr(sheetObj.GetCellValue(i, "cntr_qty"),",",""));
				tot_row_vari_row=tot_row_vari_row + eval(ComReplaceStr(sheetObj.GetCellValue(i, "vari_qty"),",",""));
			}
			if ( sheetObj.GetCellValue(i, "cntr_tpsz_cd") == sheetObj.GetCellValue(Row, "cntr_tpsz_cd") && sheetObj.GetCellValue(i, "lvl") == "10" ) {
				tot_row_tpsz_row=i;
			}
		}
		sheetObj.SetCellValue(tot_row_cntr_qty, "cntr_qty",tot_pos_cntr_qty,0);
		sheetObj.SetCellValue(tot_row_tpsz_row, "cntr_qty",tot_fos_tpsz_row,0);
		sheetObj.SetCellValue(tot_row_cntr_qty, "vari_qty",tot_pos_vari_qty,0);
		sheetObj.SetCellValue(tot_row_tpsz_row, "vari_qty",tot_row_vari_row,0);
		sheetObj.SetRowStatus(tot_row_cntr_qty,"R");
		sheetObj.SetRowStatus(tot_row_tpsz_row,"R");
		for ( var i=1; i<=sheetObj.RowCount(); i++ ) {
			if ( sheetObj.GetCellValue(i, "lvl") == "10"  ) {
				tot_cntr_qty=tot_cntr_qty + eval(ComReplaceStr(sheetObj.GetCellValue(i, "cntr_qty"),",",""));
				tot_vari_qty=tot_vari_qty + eval(ComReplaceStr(sheetObj.GetCellValue(i, "vari_qty"),",",""));
			}
		}
		sheetObj.SetCellValue(sheetObj.LastRow(), "cntr_qty",tot_cntr_qty,0);
		sheetObj.SetCellValue(sheetObj.LastRow(), "vari_qty",tot_vari_qty,0);
		if ( eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.LastRow(),"cntr_qty"),",","")) >= 0 ) {
 			sheetObj.SetCellFontColor(sheetObj.LastRow(),"cntr_qty","#0000FF");
		} else {
 			sheetObj.SetCellFontColor(sheetObj.LastRow(),"cntr_qty","#FF0000");
		}
		if ( eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.LastRow(),"vari_qty"),",","")) >= 0 ) {
 			sheetObj.SetCellFontColor(sheetObj.LastRow(),"vari_qty","#0000FF");
		} else {
 			sheetObj.SetCellFontColor(sheetObj.LastRow(),"vari_qty","#FF0000");
		}
		sheetObj.SetCellValue(sheetObj.LastRow(), "loc_cd","G.Total",0);
		sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
		if ( eval(sheetObj.GetCellValue(Row, "vari_qty")) >= 0 ) {
 			sheetObj.SetCellFontColor(Row,"vari_qty","#0000FF");
		} else {
 			sheetObj.SetCellFontColor(Row,"vari_qty","#FF0000");
		}
	}
    /**
     * handling after saving
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
      	sheetObj.SetCellValue(sheetObj.LastRow(), "loc_cd","G.Total",0);
      	sheetObj.SetCellValue(sheetObj.LastRow(), "cntr_tpsz_cd","G.Total",0);
      	sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
      	sheetObj.RenderSheet(1);
    }
    /**
     * retrieving again
     */    
	function popupCloseEnd() {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	/**
	 * converting data to 0 in case of null
	 */	
    function sheet1_OnKeyUp(sheetObject, Row, Col, Value) {
    	if (Col ==8) {	//image_button 아닐때
    		if ( sheetObject.GetCellValue(Row,Col) == '' ) {	//data format int형 널 방지
	    		sheetObject.SetCellValue(Row,Col,0,0);
	    	}
    	}
    }    
