/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_cim_0034.js
*@FileTitle  : EQ Availability
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
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
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * showing 'CM','CP','CI','CO','CD','CT' data in case Location by = 'US'
     */
    function viewUsData( usFlag) {
    	for ( var i=9; i<=15; i++ ) {
    		sheetObjects[0].SetColHidden("stay_days"+i,usFlag);
    	}
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
	                var HeadTitle1="Seq.|SCC|TP/SZ|CNTR No.|Term|F/M|Yard|MVMT|Event Date|Total\nS/Days|IC|ID|MT|OP|OC|TN|EN|TS|CI|CD|CM|CP|CO|CT|CE|BKG No.|DMG|DMG Flg DT|DMG Unflg DT|HRT|HBT|HBQ|DP|IM|UC|PF";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	//                (headCount, 0, 0, true);
	                sheetObj.FrozenCols=4;
	
	                SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"Seq" },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_loc_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                 KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",                 KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"full_flg",                KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",                 KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"stay_days",               KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days1",              KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days2",              KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days3",              KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days4",              KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days5",              KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days6",              KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days7",              KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days8",              KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days9",              KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days10",             KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days11",             KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days12",             KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days13",             KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days14",             KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"stay_days15",             KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                          {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"" },
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
	                SetSheetHeight(275);
	                //SetCountPosition(0);

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
//no support[check again]CLT 	  	        sheetObj.SpeedOption="NOPROGRESSTICK, NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT, NOMERGEROW, NOTRIM, NOTDTAG, NOCOMBO,NOFORMAT";
 		        sheetObj.DoSearchFx("EES_CIM_0041GS.do",FormQueryString(formObj) );
		        
                break;
			break;
	   		case IBDOWNEXCEL: 
	   			if(sheetObj.RowCount() < 1){//no data
	   				ComShowCodeMessage("COM132501");
   	       		}else{
   	       			sheetObj.Down2Excel({ HiddenColumn:true});
   	       		}
	   			break;
        }
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
        var loc_cd=document.form.loc_cd.value.substr(0,2);
        var usViewFlag=true;
        if ( loc_cd == 'US' ) {
        	usViewFlag=false;
        }
		viewUsData( usViewFlag ) ; //Location by US이면 'CM','CP','CI','CO','CD','CT' 데이타 보이고 안보이기
		ComOpenWait(false);
//no support[implemented common]CLT 		sheetObj.SelectHighLight=false;
	}
    /**
     * event when clicking cell
     * setting background color for selected row
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }	
