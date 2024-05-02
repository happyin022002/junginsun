/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CESD_SCE_0115.js
*@FileTitle  : Manual Container Mapping
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;

	//Event handler processing by button name */
    function processButtonClick(){
    	/***** Setting variable over two sheet at tab *****/
        var sheetObject2=sheetObjects[0];
        var sheetObject=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
    			case "dbtn_new":
    				sheetObject2.RemoveAll();
    				sheetObject.RemoveAll();
    				formObject.reset();
    				formObject.bkg_no.disabled=false;
    				break;
                case "dbtn_retrieve":
                    doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC01);
                    sheetObject.RemoveAll();
                    break;
        	    case "dbtn_save":
    	            doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC02);
        	        break;
				case "selection":
					// in case of BKG_NO
					if( formObject.selection[0].checked) {
						formObject.bkg_no.disabled=false;
				        formObject.cntr_no_txt.disabled=true;
				        formObject.cntr_no_txt.value="";
				        formObject.bkgcrt_fm_dt.disabled=true;
				        formObject.bkgcrt_fm_dt.value="";
				        formObject.bkgcrt_to_dt.disabled=true;
				        formObject.bkgcrt_to_dt.value="";
 				        sheetObject2.RemoveAll();
				        sheetObject.RemoveAll();
				   	// in case of container no.
					} else if( formObject.selection[1].checked) {
						formObject.cntr_no_txt.disabled=false;
						formObject.bkg_no.disabled=true;
						formObject.bkg_no.value="";
					  	formObject.bkgcrt_fm_dt.disabled=true;
					  	formObject.bkgcrt_fm_dt.value="";
					  	formObject.bkgcrt_to_dt.disabled=true;
					  	formObject.bkgcrt_to_dt.value="";
					  	sheetObject2.RemoveAll();
					  	sheetObject.RemoveAll();
					// in case of bkg creation date
					}else{
					  	formObject.bkgcrt_fm_dt.disabled=false;
					  	formObject.bkgcrt_to_dt.disabled=false;
						formObject.bkg_no.disabled=true;
						formObject.bkg_no.value="";
				        formObject.cntr_no_txt.disabled=true;
				        formObject.cntr_no_txt.value="";
				        sheetObject2.RemoveAll();
				        sheetObject.RemoveAll();
					}
					break;
				case "btn_bkg_calendar":
					if( formObject.selection[2].checked) {
					cal=new ComCalendarFromTo();
					cal.displayType="date";
					cal.select(formObject.bkgcrt_fm_dt, formObject.bkgcrt_to_dt,  'yyyy-MM-dd');
					}else{
						alert ( "Please Check 'Bkg Create Date' Button");
						return;
					}
					break ;
				case "btn_close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
				ComShowMessage(ComGetMsg('COM12111')) ;
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
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
        switch(sheetNo) {
        	case 2:      //IBSheet1 init
        		with(sheetObj){
        			var prefix='sheet1_';
        			var HeadTitle1="COP_NO|BKG_NO|CNTR_NO|CNTR TYPE SIZE|UPDATE DATE" ;

        			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        			InitHeaders(headers, info);

        			var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cop_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:300 },
        			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:500 },
        			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"upd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 } ];
               
        			InitColumns(cols);

        			SetEditable(1);
                    var nums="1234567890" ;
                    var spChars="!@#$%^&*()_+<>?,./'\" " ;
//        			SetSheetHeight(250 );
                    resizeSheet();
              	}
        		break;
            case 1:      //IBSheet1 init
            	with(sheetObj){
	            	var prefix='sheet2_';
	            	var HeadTitle1="|SEQ|BKG_NO|CNTR_NO|TPSZ_CD|BKG_CRE_DT" ;
	
	            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            	InitHeaders(headers, info);
	
	            	var cols = [ {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"delCheck",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:300 },
	            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:500 },
	            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bkg_cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	            	             {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cntr_vol_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	            	             {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cntr_rcv_term_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	            	             {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cntr_de_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	            	             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	           
	            	InitColumns(cols);
	
	            	SetEditable(1);
	                var nums="1234567890" ;
	                var spChars="!@#$%^&*()_+<>?,./'\" " ;
	            	SetSheetHeight(250 );
	          	}
	            break;
        }
    }
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            //changing initializing function name
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //adding last function name
            ComEndConfigSheet(sheetObjects[i]);
        }
        var formObject=document.form;
        formObject.cntr_no_txt.disabled=true;
        formObject.bkgcrt_fm_dt.disabled=true;
        formObject.bkgcrt_to_dt.disabled=true;
    }
    
	// handling process of sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH_ASYNC01:		//Retrieve
			if(validateSearch(sheetObj,formObj,sAction)){
                formObj.f_cmd.value=SEARCH01;
//method change[check again]CLT
                sheetObj.DoSearch("ESD_SCE_0115GS2.do", FormQueryString(formObj) );
              }
              break;
           case IBSEARCH_ASYNC02:		//Save
	         	var sheetObject=sheetObjects[1];
				if(validateForm(sheetObj,formObj,sAction)){
	                formObj.f_cmd.value=MULTI01;
					// showing data in case mapping id complete.
					var resultParam=sheetObj.GetSaveString( false, false)+"&f_cmd="+SEARCHLIST;
					if( sheetObj.DoSave("ESD_SCE_0115GS2.do", FormQueryString(formObj), -1, false)) {
		                formObj.f_cmd.value=SEARCH01;
//method change[check again]CLT
		                sheetObj.DoSearch("ESD_SCE_0115GS2.do", FormQueryString(formObj) );
		                formObj.f_cmd.value=SEARCHLIST;
//method change[check again]CLT
		                sheetObject.DoSearch("ESD_SCE_0115GS.do", resultParam  );
					}
				}
			break;
        }
    }
    
    /**
    * handling process for input validation
    */
	function validateForm(sheetObj,formObj,sAction){
		var row=null ;
		var chgRows2=sheetObj.FindCheckedRow("delCheck");
		var all_rowcnt=sheetObj.RowCount();
		if(all_rowcnt=="0"){
			return false;
		}
		if(chgRows2== ""){
			ComShowMessage('Please check the CheckBox!');
			return false;
		}
		return true;
	}
	
    /**
    * handling process for input validation
    */
	function validateSearch(sheetObj,formObj,sAction){
		var result=true;
		if( formObj.selection[0].checked) {
			if(ComIsEmpty(formObj.bkg_no)){
				ComShowMessage('Please input To Bkg No') ;
            	formObj.bkg_no.focus() ;
        		result=false ;
			}
		} else if( formObj.selection[1].checked) {
			if(ComIsEmpty(formObj.cntr_no_txt)){
				ComShowMessage('Please input To Container No') ;
            	formObj.cntr_no_txt.focus() ;
        		result=false ;
			}
		}else{
			if(ComIsEmpty(formObj.bkgcrt_fm_dt) || ComIsEmpty(formObj.bkgcrt_to_dt)){
				ComShowMessage('Please input To Bkg Create Date') ;
            	formObj.bkgcrt_fm_dt.focus() ;
        		result=false ;
			}
		}
		return result;
	}
	
	function resizeSheet(){
        ComResizeSheet(sheetObjects[1]);
    }