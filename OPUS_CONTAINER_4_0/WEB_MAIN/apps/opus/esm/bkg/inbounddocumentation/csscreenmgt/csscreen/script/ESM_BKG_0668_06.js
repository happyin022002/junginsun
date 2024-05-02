/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0668_06.js
*@FileTitle  :  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var t6sheet1_num=0;
    var t6sheet2_num=1;
    var t6sheet3_num=2;
    var comboFlg=null;
    var cntrQtySum=0;
    var chgFlag=null;
    var frt_term_cd=null;
    var t6previewSheet=1;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
    				case "btn_t6Preview":
    					if (sheetObjects[t6sheet1_num].RowCount()== 0) {
                    		ComShowCodeMessage("BKG40060");
                    		return;
                    	}
    					var bkg_no=document.form.bkg_no.value;
                    	var mrdId=formObject.h_mrd_id.value;
    					var loclLangFlg=formObject.h_local_lang_flg.value;
    					if(mrdId == ""){
    						ComShowCodeMessage("BKG40050");
    						return;
    					}
    					if(bkg_no == ""){
    						ComShowCodeMessage("BKG00149");
    						return;
    					}
    					formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/"
    						+ mrdId
    						+ ".mrd";
    					var strArg="/rv ";
    					strArg += " form_bkgNo['" + bkg_no + "']";
    					strArg += " form_usrId['" + strUsr_id + "']";
    					strArg += " form_tsFlg['N']";
    					strArg += " form_loclFlg['" + loclLangFlg + "']";
    					strArg += " form_ofcCd['" + lginOfcCd + "']";
    					if (t6previewSheet == 1) {
    						strArg += " form_remarkCtnt['" + sheetObjects[t6sheet2_num].GetCellValue(2,"t6sheet2_"+"diff_rmk") + "']";
    						if (sheetObjects[t6sheet2_num].GetCellValue(2,"t6sheet2_"+"chg_dp_flg") == "Y") {
    							strArg += " form_chgDpFlg['1']";
    						} else {
    							strArg += " form_chgDpFlg['0']";
    						}
    						
    						if (sheetObjects[t6sheet2_num].GetCellValue(1,"t6sheet2_"+"show_pu_flg") == "1"||sheetObjects[t6sheet2_num].GetCellValue(2,"t6sheet2_"+"show_pu_flg") == "1") {
							strArg += " form_showPuFlg['1']";
						     } else {
							strArg += " form_showPuFlg['0']";
						     } 
    						
    					} else {
    						strArg += " form_remarkCtnt['" + sheetObjects[t6sheet3_num].GetCellValue(2,"t6sheet3_"+"diff_rmk") + "']";
    						if (sheetObjects[t6sheet3_num].GetCellValue(2,"t6sheet3_"+"chg_dp_flg") == "Y") {
    							strArg += " form_chgDpFlg['1']";
    						} else {
    							strArg += " form_chgDpFlg['0']";
    						}
    						
    						if (sheetObjects[t6sheet3_num].GetCellValue(1,"t6sheet3_"+"show_pu_flg") == "1"||sheetObjects[t6sheet3_num].GetCellValue(2,"t6sheet3_"+"show_pu_flg") == "1") {
							strArg += " form_showPuFlg['1']";
						     } else {
							strArg += " form_showPuFlg['0']";
						     }
    						
    					}	
    					formObject.com_mrdArguments.value=strArg;
    					formObject.com_mrdTitle.value="Arrival Notice Send";
    					formObject.com_mrdDisableToolbar.value="";
    					formObject.com_mrdBodyTitle.value="Arrival Notice Send";
    					ComOpenRDPopupModal();
                    	break;
                    case "btn_t6Master":
                    	if (sheetObjects[t6sheet1_num].RowCount()== 0) {
                    		ComShowCodeMessage("BKG40060");
                    		return;
                    	}
                    	param="?pgmNo=ESM_BKG_0240";
                    	ComOpenWindowCenter("/opuscntr/ESM_BKG_0240_POP.do"+param, "ESM_BKG_0240", 1024, 670, false);
                    	break;
                    case "btn_t6SendAn":
                    	if (sheetObjects[t6sheet1_num].RowCount()== 0) {
                    		ComShowCodeMessage("BKG40060");
                    		return;
                    	}
                    	var bl_no=document.form.bl_no.value;
                    	param="?bl_no="+bl_no+ "&sch_tp=B&autoSearchFlg=Y" + "&pgmNo=ESM_BKG_0381";
                    	ComOpenWindowCenter("/opuscntr/ESM_BKG_0381_POP.do"+param, "ESM_BKG_0381", 1024, 670, false);
                    	break;                        
                    case "btn_t6AnTemplate": //btn_t6AnTemplate
                    	ComOpenWindowCenter("/opuscntr/ESM_BKG_0375_POP.do" + "?pgmNo=ESM_BKG_0375", "ESM_BKG_0375", 1024, 650, false);
                    	break;
                    case "btn_t6SendOBl": 
                    	if (sheetObjects[t6sheet1_num].RowCount()== 0) {
                    		ComShowCodeMessage("BKG40060");
                    		return;
                    	}                    	
                    	var bl_no=document.form.bl_no.value;
                    	param="?bl_no="+bl_no+ "&pgmNo=ESM_BKG_0218_02";
                    	
                    	ComOpenWindowCenter("/opuscntr/ESM_BKG_0218_02_POP.do"+param, "ESM_BKG_0218_02", 1124, 650, false);
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
         * adding first-served functions after loading screen
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){
	            	ComConfigSheet (sheetObjects[i] );
	                initSheet(sheetObjects[i],i+1);
	                ComEndConfigSheet(sheetObjects[i]);
            }
			if (document.form.bkg_no.value != "") {
				fnSearch();
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
        	case "t6sheet1":      //t6sheet1 init
        	    with(sheetObj){
	              var HeadTitle="|Cust Cd|Cust Nm|Pod Cd|Del Cd|Cust Addr|Cust_Seq|bkg cust tp cd|cust cnt cd";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              var prefix="t6sheet1_";
	
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_addr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_cust_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_cnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
	              SetVisible(0);
                }
            break;
        case "t6sheet2":      //t6sheet2 init
            with(sheetObj){
	          var HeadTitle1="|KIND|Show PU#|Charge|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY #2|CNEE/NTFY #2|BROKER #1|BROKER #1|BROKER #2|BROKER #2|One Time Only|One Time Only|Result Date|Remark(s)||1|2|3|4|5|6|7|8|9|0";
	          var headCount=ComCountHeadTitle(HeadTitle1);
	          var prefix="t6sheet2_";
	
	          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	          var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"kind_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"CheckBox",  Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"show_pu_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chg_dp_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_flg1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"snd_no1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_flg2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"snd_no2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_flg3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"snd_no3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_flg4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"snd_no4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_flg5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"snd_no5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"diff_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_gdt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_nm1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_nm2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_nm3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_nm4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_nm5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	           
	          InitColumns(cols);
	
	          SetEditable(1);
	          SetCountPosition(0);
	          SetEllipsis(1);
	                //no support[implemented common]CLT ScrollBar=3;
	          SetAutoRowHeight(0);
	          SetSheetHeight(150);
          }


            break;
        case "t6sheet3":      //t6sheet3 init
            with(sheetObj){
	         var HeadTitle1="|KIND|Show PU#|Charge|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY #2|CNEE/NTFY #2|BROKER #1|BROKER #1|BROKER #2|BROKER #2|One Time Only|One Time Only|Result Date|Remark(s)||1|2|3|4|5|6|7|8|9|0";
	         var headCount=ComCountHeadTitle(HeadTitle1);
	         var prefix="t6sheet3_";
	
	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	         var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	         InitHeaders(headers, info);
	
	         var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"kind_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"show_pu_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chg_dp_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_flg1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"snd_no1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_flg2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"snd_no2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_flg3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"snd_no3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_flg4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"snd_no4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_flg5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"snd_no5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"diff_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_gdt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_nm1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_nm2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_nm3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_nm4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_rslt_nm5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	          
	         InitColumns(cols);
	
	         SetEditable(1);
	         SetCountPosition(0);
	         SetEllipsis(1);
	                  //no support[implemented common]CLT ScrollBar=3;
	         SetAutoRowHeight(0);
	         SetSheetHeight(150);
         }


            break;
        }
    }
      // handling sheet process
        function doActionIBSheet(sheetObj,formObj,sAction) {
            //sheetObj.ShowDebugMsg = false;
            switch(sAction) {
               case IBSEARCH:   
                	ComOpenWait(true);
           			sheetObjects[t6sheet1_num].SetWaitImageVisible(0);
           			formObj.f_cmd.value=SEARCH;
           			var aryPrefix=new Array("t6sheet1_", "t6sheet2_", "t6sheet3_"); //prefix string array
                    var sXml=sheetObj.GetSearchData("ESM_BKG_0668_06GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	         		var arrXml=sXml.split("|$$|");
         			//sheetObjects[t6sheet1_num].RenderSheet(0);
         			sheetObjects[t6sheet1_num].SetWaitImageVisible(0);
         			sheetObjects[t6sheet1_num].LoadSearchData(arrXml[0],{Sync:1} );
         			//sheetObjects[t6sheet1_num].RenderSheet(1);
         			//sheetObjects[t6sheet2_num].RenderSheet(0);
         			sheetObjects[t6sheet2_num].SetWaitImageVisible(0);
         			sheetObjects[t6sheet2_num].LoadSearchData(arrXml[1],{Sync:1} );
         			//sheetObjects[t6sheet2_num].RenderSheet(1);
         			//sheetObjects[t6sheet3_num].RenderSheet(0);
         			sheetObjects[t6sheet3_num].SetWaitImageVisible(0);
         			sheetObjects[t6sheet3_num].LoadSearchData(arrXml[2],{Sync:1} );
         			//sheetObjects[t6sheet3_num].RenderSheet(1);
                    var mrdId=ComGetEtcData(arrXml[0], "mrdId");
                    var localLangFlg=ComGetEtcData(arrXml[0], "localLangFlg");
                    document.form.h_mrd_id.value=mrdId;
                    document.form.h_local_lang_flg.value=localLangFlg;
	         		sheetObjects[t6sheet1_num].SetWaitImageVisible(1);
         			ComOpenWait(false);
                    break;
            }
        }
        /** 
         * isFloat(str) :  check float, '.' include
         */ 
         function isFloat(fVal) {
         	var temp=0;
         	var sVal=null;
         	var sIdx=fVal.toString().indexOf(".");
         	if (sIdx > 0) {
 	        	var sTemp=fVal.toString();
         		sVal=sTemp.substring(parseInt(sIdx) + 1);
 	        	if (parseInt(sVal) > 0 ) {
 	        		return true;
 	        	} else {
 	        		return false;
 	        	}
         	} else {
         		return false;
         	}
         }
     /**
     * buttons set disabled in screen
     */
    function buttonColorSet(btn_name, color){
	   	var tds=document.getElementsByTagName("td");
	   	var curFlag=null;
	   	if (color == 'red') {
	   		curFlag="hand";
	   	} else {
	   		curFlag="default";
	   	}
        for(var i=0; i < tds.length; i++) {
            var td=tds[i];
            if(td.name == '•' + btn_name){
           	 td.style.color=color;
           	 td.style.cursor=curFlag;
           	 if (btn_name == "btn_split") {
           		 document.form.h_split.value=color;
           	 }
                break;
            }else if(td.name == btn_name){
           	 td.style.color=color;
           	 td.style.cursor=curFlag;
           	 if (btn_name == "btn_split") {
           		 document.form.h_split.value=color;
           	 }
                break;
            }else{
           	 continue;
            }
        }
    }
     function fnNoticeClear() {
     	document.form.frm_t6sheet1_cust_cd_c.value="";
     	document.form.frm_t6sheet1_cust_nm_c.value="";
     	document.form.frm_t6sheet1_cust_addr_c.value="";
     	document.form.frm_t6sheet1_cust_cd_n.value="";
     	document.form.frm_t6sheet1_cust_nm_n.value="";
     	document.form.frm_t6sheet1_cust_addr_n.value="";
     	document.form.frm_t6sheet1_cust_cd_a.value="";
     	document.form.frm_t6sheet1_cust_nm_a.value="";
     	sheetObjects[t6sheet1_num].RemoveAll();
     	sheetObjects[t6sheet2_num].RemoveAll();
     	sheetObjects[t6sheet3_num].RemoveAll();
//     	sheetObjects[sheetObjects.length-1].RemoveAll();
     }
    //search function
    function fnSearch() {
		doActionIBSheet(sheetObjects[t6sheet1_num],document.form,IBSEARCH);
    }
    /**
     * t6sheet1_OnSearchEnd check logic
     */
   function t6sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
        cntrQtySum=0;
     	var maxRow=sheetObj.LastRow();
     	var prefix="t6sheet1_";
     	var cellValue="";
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
         		for(i=1;i <= maxRow ; i++){
         			cellValue=sheetObj.GetCellValue( i,prefix + "bkg_cust_tp_cd");
         			if (cellValue == "C") {
         				document.form.frm_t6sheet1_cust_cd_c.value=sheetObj.GetCellValue(i, prefix + "cust_cd");
         				document.form.frm_t6sheet1_cust_nm_c.value=sheetObj.GetCellValue(i, prefix + "cust_nm");
         				document.form.frm_t6sheet1_cust_addr_c.value=sheetObj.GetCellValue(i, prefix + "cust_addr");
         			} else if (cellValue == "N") {
         				document.form.frm_t6sheet1_cust_cd_n.value=sheetObj.GetCellValue(i, prefix + "cust_cd");
         				document.form.frm_t6sheet1_cust_nm_n.value=sheetObj.GetCellValue(i, prefix + "cust_nm");
         				document.form.frm_t6sheet1_cust_addr_n.value=sheetObj.GetCellValue(i, prefix + "cust_addr");
         			} else if (cellValue == "A") {
         				document.form.frm_t6sheet1_cust_cd_a.value=sheetObj.GetCellValue(i, prefix + "cust_cd");
         				document.form.frm_t6sheet1_cust_nm_a.value=sheetObj.GetCellValue(i, prefix + "cust_nm");
         			}
         		}         	   
            }
        } else {
      	   	fnNoticeClear();
        }
    }        	  
     /**
     * setting value after t6sheet2 retrieve complete
     * @param Object sheetObj 
     * @param Object ErrMsg   
     * @return void
     * @author
     * @version 2009.11.01
     **/
   function t6sheet2_OnSearchEnd(sheetObj, Code, ErrMsg){
       cntrQtySum=0;
       if (ErrMsg == "") {
           if(sheetObj.RowCount()> 0){
       		var maxRow=sheetObj.LastRow();
       		var cellValue="";
       		var prefix="t6sheet2_";
       		sheetObj.CheckAll(prefix + "show_pu_flg",1);
         	
       		for(i=1;i <= maxRow ; i++){
       			//set font color 
       			for(var q=1;q<6;q++){
       				//FAX
       				cellValue=sheetObj.GetCellValue( i,prefix + "snd_rslt_cd"+q);
       				if(cellValue == "R"){  // fail, red
        					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#FF0000");
       				}else if(cellValue == "B"){  //success, blue
        					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#0000FF");
       				}else if(cellValue == "X"){  // black
        					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#000000");
       				}else if(cellValue == "P"){  // ing, pink
        					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#FF00C0");
       				}
       				cellValue=sheetObj.GetCellValue( i,prefix + "snd_rslt_nm"+q);
       				if(cellValue != "") {
       					sheetObj.SetToolTipText(i, prefix + "snd_no"+q,cellValue);
       				}
       			}
       		}
       		cellValue=sheetObj.GetCellValue( i,prefix + "snd_gdt");
        		if(cellValue != "") {
   				sheetObj.SetToolTipText(i, prefix + "snd_dt",cellValue);
   			}
           }
       }
   }        
    /**
     * setting value after t6sheet2 retrieve complete
     * @param Object sheetObj 
     * @param Object ErrMsg   
     * @return void
     * @author
     * @version 2009.11.01
     **/
   function t6sheet3_OnSearchEnd(sheetObj, Code , ErrMsg){
       cntrQtySum=0;
       if (ErrMsg == "") {
           if(sheetObj.RowCount()> 0){
       		var maxRow=sheetObj.LastRow();
       		var cellValue="";
       		var prefix="t6sheet3_";
       		sheetObj.CheckAll(prefix + "show_pu_flg",1);
       		for(i=1;i <= maxRow ; i++){
       			//set font color
       			for(var q=1;q<6;q++){
       				// EMAIL
       				// mail send success/fail code - EML_PROC_STS_CD
       				cellValue=sheetObj.GetCellValue( i,prefix + "snd_rslt_cd"+q);
       				if(cellValue == "R"){  // fail, red
        					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#FF0000");
       				}else if(cellValue == "B"){//success, blue
         					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#0000FF");
       				}else if(cellValue == "X"){  // black
         					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#000000");
       				}else if(cellValue == "P"){  // ing, pink
         					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#FF00C0");
       				}
       				cellValue=sheetObj.GetCellValue( i,prefix + "snd_rslt_nm"+q);
      				    if(cellValue != "") {
      					    sheetObj.SetToolTipText(i, prefix + "snd_no"+q,cellValue);
      				    }
       			}
       			cellValue=sheetObj.GetCellValue( i,prefix + "snd_gdt");
          		    if(cellValue != "") {
   				    sheetObj.SetToolTipText(i, prefix + "snd_dt",cellValue);
   			    }
       		}                
           }
       }
    }        
    function t6sheet2_OnClick(sheetObj, Row, Col){        	 
    	t6previewSheet=1;
    }
    function t6sheet3_OnClick(sheetObj, Row, Col){        	 
    	t6previewSheet=2;
    }
    function fnQueryExec(bkg_no, bl_no) {
    	if (bkg_no != "") {
    		document.form.bkg_no.value=bkg_no;
    		document.form.bl_no.value=bl_no;
    		fnSearch();
        }     	
    }
    /**
    * in case of  double click
    **/
    function t6sheet2_OnDblClick(sheetObj, Row, Col, Value){
        var colName=sheetObj.ColSaveName(Col);
        if( colName == "t6sheet2_" + "diff_rmk"){
            sheetObj.SetCellEditable(Row, colName,0);
            ComShowMemoPad(sheetObj, Row, colName, true, 200, 100 );
        }
    }
    /**
     * in case of double click
     **/
     function t6sheet3_OnDblClick(sheetObj, Row, Col, Value){
         var colName=sheetObj.ColSaveName(Col);
         if( colName == "t6sheet3_" + "diff_rmk"){
             sheetObj.SetCellEditable(Row, colName,0);
             ComShowMemoPad(sheetObj, Row, colName, true, 200, 100 );
         }
     }        
