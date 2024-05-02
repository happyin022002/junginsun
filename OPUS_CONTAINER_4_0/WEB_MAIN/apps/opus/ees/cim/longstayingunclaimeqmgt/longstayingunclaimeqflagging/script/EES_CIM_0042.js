/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0042.js
*@FileTitle  : Total S/Days (Detail)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var appendPageNo = 1;
var appendCondParam = "";
var rtv_total = 0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         var shtCnt=0;
         var sheetObject=sheetObjects[shtCnt++];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
					break;
				case "btn_more":
	                doActionIBSheet1(sheetObjects[0], formObject, IBSEARCHAPPEND, appendCondParam, appendPageNo);
	                break;
				case "btn_Close":
					ComClosePopup(); 
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
        ComBtnDisable("btn_more");
        sheet1_OnLoadFinish(sheetObjects[0]);
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
				var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
	                var HeadTitle1="Seq.|SCC|TP/SZ|CNTR No.|Term|Lessor Code|Lessor Name|Agreement No.|F/M|Initial Status|Initial Status|Initial Status|Current Status|Current Status|Current Status|Current Status|Total\nS/Days|BKG No.|Trade|Revenue Lane|Service Scope|DMG|DMG Flg DT|DMG Unflg DT|HRT|HBT|HBQ|DP|IM|UC|PF";
	                var HeadTitle2="Seq.|SCC|TP/SZ|CNTR No.|Term|Lessor Code|Lessor Name|Agreement No.|F/M|Yard|MVMT|Event Date|Yard|MVMT|Event Date|S.Days|Total\nS/Days|BKG No.|Trade|Revenue Lane|Service Scope|DMG|DMG Flg DT|DMG Unflg DT|HRT|HBT|HBQ|DP|IM|UC|PF";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, FrozenCol:9, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                              { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"Seq" },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_loc_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                 KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",                 KeyField:0,   CalcLogic:"",   Format:"" },
	                          
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_nm",             KeyField:0,   CalcLogic:"",   Format:"" },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",             KeyField:0,   CalcLogic:"",   Format:"" },
			                     
	                          {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"full_flg",                KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"org_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_evnt_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",                 KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"stay_days",               KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"tot_days",                KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"" },
	                          
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sln_cd",                  KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sln_lane_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
			                     
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmg_flg",                 KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmg_flg_dt",              KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmg_unflg_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
	                          
	                          
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mnr_hngr_bar_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"cntr_hngr_bar_atch_knt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"disp_flg",                KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdt_ext_flg",            KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"uclm_ls_flg",             KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"plst_flr_flg",            KeyField:0,   CalcLogic:"",   Format:"" } ];
	                 
	                InitColumns(cols);
	                SetEditable(0);
	                SetSheetHeight(287);
	                SetRangeBackColor(1,6,1,12,"#555555")
                }
                break;
        }
    }
    /**
     * handling process for Sheet
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:    
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true); 							
                formObj.f_cmd.value=SEARCH;
                rowTotal = 0;
				rtv_total=rowTotal;					
				if(Number(rowTotal) > formObj.pagerows.value) {
					ComBtnEnable("btn_more");
				}else{
					ComBtnDisable("btn_more");
				}
				
				appendPageNo=1;
				appendCondParam = FormQueryString(formObj);	
                sheetObj.DoSearchFx("EES_CIM_0042GS.do",FormQueryString(formObj) );
                						
                break;
	   		case IBDOWNEXCEL:     
	   			if(sheetObj.RowCount() < 1){//no data
	   				ComShowCodeMessage("COM132501");
	   			}else{
	   				sheetObj.Down2Excel({ Merge:1, HiddenColumn:true, TreeLevel:false});
	   			}
	   			break;
	   		case IBSEARCH_ASYNC08:
				formObj.f_cmd.value=SEARCH01;
				var intgCdId='CD30029';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:1} );
				   return;
			    } 
				if (xml != "") {
					var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
					var arrStr=sCntrMtrlCdNm.split("@");					
					var arrCode=arrStr[0].split("|");
					formObj.pagerows.value=arrCode[0];
				}
				break;
        }
    }
    
    /**
	 * handling event in case of OnLoadFinish sheet1
	 */
    function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC08); //페이징 갯수 가져오기
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
    /**
     * handling process after retrieving screen
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		var formObj = document.form;
		var lstTotal = sheetObj.GetEtcData("rtv_total");
    	if (sheetObj.RowCount()< lstTotal) {
            // setting page number for APPEND retrieving
            appendPageNo=Math.ceil(sheetObj.RowCount()/ formObj.pagerows.value) + 1;
            ComBtnEnable("btn_more");
        } else {
        	appendPageNo = 1;
            ComBtnDisable("btn_more");
        }		
		ComOpenWait(false); 	
	}
	
	/**
     * handling process for Sheet
     */    
    function doActionIBSheet1(sheetObj, formObj, sAction, CondParam, PageNo) {
    	switch(sAction) {
    	case IBSEARCHAPPEND:
    		if(!validateForm(sheetObj,formObj,sAction)) return;
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);     	
			sheetObj.SetWaitImageVisible(0);		
			sheetObj.DoSearchFx("EES_CIM_0042GS.do", CondParam+"&"+ "iPage="+ appendPageNo,{Append:true} );  	   
 			
	        
			break;
    	}
    }
    
	/**
     * event when clicking cell
     * setting background color for selected row
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }	
