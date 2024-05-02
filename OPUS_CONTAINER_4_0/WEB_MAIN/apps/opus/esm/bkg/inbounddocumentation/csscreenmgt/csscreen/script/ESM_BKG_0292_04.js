/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0292_04.js
*@FileTitle  : C/S Screen(Notice & B/L Copy)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                              MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
                              Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // public variable
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var t5sheet1 = 0;
    var t5sheet2 = 1;
    var t5sheet3 = 2;
    var comboFlg = null;
    var cntrQtySum = 0;
    var frt_term_cd = null;
    var previewSheet = 1;
    document.onclick = processButtonClick;
    /**
     * Event handler processing by button name<br>
     * @param {void}
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function processButtonClick(){
        var param=null;
        var sc_no=null;
        var cntr_no=null;
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(!ComIsBtnEnable(srcName)){
                return;
            }
            switch(srcName) {
                case "btn_t5Preview":
                	if (sheetObjects[0].RowCount()== 0) {
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
					if (previewSheet == 1) {
						strArg += " form_remarkCtnt['" + sheetObjects[1].GetCellValue(2,"t5sheet2_"+"diff_rmk") + "']";
						if (sheetObjects[1].GetCellValue(2,"t5sheet2_"+"chg_dp_flg") == "Y") {
							strArg += " form_chgDpFlg['1']";
						} else {
							strArg += " form_chgDpFlg['0']";
						}
					} else {
						strArg += " form_remarkCtnt['" + sheetObjects[2].GetCellValue(2,"t5sheet3_"+"diff_rmk") + "']";
						if (sheetObjects[2].GetCellValue(2,"t5sheet3_"+"chg_dp_flg") == "Y") {
							strArg += " form_chgDpFlg['1']";
						} else {
							strArg += " form_chgDpFlg['0']";
						}
					}
					formObject.com_mrdArguments.value=strArg;
					formObject.com_mrdTitle.value="Arrival Notice Send";
					formObject.com_mrdDisableToolbar.value="";
					formObject.com_mrdBodyTitle.value="Arrival Notice Send";
					ComOpenRDPopupModal();
                	break;
                case "btn_t5Master":
                	if (sheetObjects[0].RowCount()== 0) {
                		ComShowCodeMessage("BKG40060");
                		return;
                	}
                	//var cust_cnt_cd=sheetObjects[0].GetCellValue(1, "t5sheet1_cust_cnt_cd");
                	//var cust_seq=sheetObjects[0].GetCellValue(1, "t5sheet1_cust_seq");
                	var cust_cnt_cd=formObject.frm_t5sheet1_cust_cd_c.value.substring(0,2);
                	var cust_seq=formObject.frm_t5sheet1_cust_cd_c.value.substring(2);
                	
                	param="?pgmNo=ESM_BKG_0240&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq;
                	ComOpenWindowCenter("/opuscntr/ESM_BKG_0240_POP.do"+param, "ESM_BKG_0240", 1250, 670, false);
                	
                	break;
                case "btn_t5SendAn":
                	if (sheetObjects[0].RowCount()== 0) {
                		ComShowCodeMessage("BKG40060");
                		return;
                	}
                	var bl_no=document.form.bl_no.value;
                	param="?bl_no="+bl_no+ "&sch_tp=B&autoSearchFlg=Y"+ "&pgmNo=ESM_BKG_0381";
                	ComOpenWindowCenter("/opuscntr/ESM_BKG_0381_POP.do"+param, "ESM_BKG_0381", 1280, 670, false);
                    break;
                case "btn_t5AnTemplate": //btn_t5SendOBl
                	ComOpenWindowCenter("/opuscntr/ESM_BKG_0375_POP.do"+ "?pgmNo=ESM_BKG_0375", "ESM_BKG_0375", 1280, 470, false);
                	break;
                case "btn_t5SendOBl": 
                	if (sheetObjects[0].RowCount()== 0) {
                		ComShowCodeMessage("BKG40060");
                		return;
                	}
                	var bl_no=document.form.bl_no.value;
                	param="?bl_no="+bl_no+ "&pgmNo=ESM_BKG_0218_02";
                	ComOpenWindowCenter("/opuscntr/ESM_BKG_0218_02_POP.do"+param, "ESM_BKG_0218_02", 1250, 650, false);
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
      * registering IBSheet Object as list<br>
      * @param sheet_obj IBSheet Object
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
     /**
      * initializing sheet<br>
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      * @param {void}
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	if (sheetObjects[i].id == "t5sheet1") {
	            initSheet(sheetObjects[i],i+1);        		
        	} else {
	        	ComConfigSheet (sheetObjects[i] );
	            initSheet(sheetObjects[i],i+1);
	            ComEndConfigSheet(sheetObjects[i]);
        	}
        }
        if (document.form.bkg_no.value != "") {
        	fnSearch();
        }        
        resizeIfSheet();
    }
     /**
      * setting sheet initial values and header<br>
      * @param sheetObj IBSheet Object
      * @param sheetNo  IBSheet의 순서
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var prefix="";
        var sheetID=sheetObj.id;
        switch(sheetID) {        
            case "t5sheet1":      //t5sheet1 init
            	with(sheetObj){
	            	var HeadTitle="|Cust Cd|Cust Nm|Pod Cd|Del Cd|Cust Addr|Cust_Seq|bkg cust tp cd|cust cnt cd";
	            	var prefix="t5sheet1_";
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
	            	SetVisible(0);
            	}
                break;
            case "t5sheet2":      //t5sheet2 init
            	with(sheetObj){
	            	var HeadTitle1="|KIND|Charge|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY #2|CNEE/NTFY #2|BROKER #1|BROKER #1|BROKER #2|BROKER #2|One Time Only|One Time Only|Result Date|Remark(s)||1|2|3|4|5|6|7|8|9|0";
	            	var prefix="t5sheet2_";
	            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	            	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            	InitHeaders(headers, info);
	            	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				            	{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"kind_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				            	{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chg_dp_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				            	{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_flg1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N" },
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
	            	SetEllipsis(1);
	            	SetSheetHeight(150);
            	}
            	break;
            case "t5sheet3":      //t5sheet3 init
            	with(sheetObj){
	            	var HeadTitle1="|KIND|Charge|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY #2|CNEE/NTFY #2|BROKER #1|BROKER #1|BROKER #2|BROKER #2|One Time Only|One Time Only|Result Date|Remark(s)||1|2|3|4|5|6|7|8|9|0";
	            	var prefix="t5sheet3_";
	            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	            	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            	InitHeaders(headers, info);
	            	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			            	     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"kind_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
			            	     {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_no5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
	            	SetEllipsis(1);
	            	SetSheetHeight(150);
            	}
            break;
        }
    }
    /**
     * handling sheet process<br>
     * @param sheetObj IBSheet Object
     * @param formObj  Object
     * @param sAction  IBSEARCH - retrieve, COMMAND01, COMMAND02, COMMAND04
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //retrieve
            	ComOpenWait(true);
            	sheetObjects[0].SetWaitImageVisible(0);
            	formObj.f_cmd.value=SEARCH;
                var aryPrefix=new Array("t5sheet1_", "t5sheet2_", "t5sheet3_"); //prefix 문자열 배열
                var sXml=sheetObj.GetSearchData("ESM_BKG_0292_04GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                var arrXml=sXml.split("|$$|");
                sheetObjects[0].SetWaitImageVisible(0);
                sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
                sheetObjects[1].SetWaitImageVisible(0);
                sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
                sheetObjects[2].SetWaitImageVisible(0);
                sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
                
                var mrdId=ComGetEtcData(arrXml[0], "mrdId");
                var localLangFlg=ComGetEtcData(arrXml[0], "localLangFlg");
                document.form.h_mrd_id.value=mrdId;
                document.form.h_local_lang_flg.value=localLangFlg;
                sheetObjects[0].SetWaitImageVisible(1);
                ComOpenWait(false);
                break;
        }
    }
     /**
      * butoon disalbed
      * @param  void
      * @return void
      * @author
      * @version 2009.11.01
      **/
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
    /**
     *  control retrieve handling 
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnSearch() {
    	fnNoticeClear();
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
    }
    /**
    * check if it is Float 
    * @param  Object  fVal 
    * @return Boolean True - Float, False - not Float
    * @author
    * @version 2009.11.01
    **/
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
      * t5sheet1-  After finishing retrieve, setting value
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg   
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function t5sheet1_OnSearchEnd(sheetObj, ErrMsg){
        cntrQtySum=0;
    	var maxRow=sheetObj.LastRow();
    	var prefix="t5sheet1_";
    	var sValue="";
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
        		for(i=1;i <= maxRow ; i++){
        			sValue=sheetObj.GetCellValue( i,prefix + "bkg_cust_tp_cd");
        			if (sValue == "C") {
        				document.form.frm_t5sheet1_cust_cd_c.value=sheetObj.GetCellValue(i, prefix + "cust_cd");
        				document.form.frm_t5sheet1_cust_nm_c.value=sheetObj.GetCellValue(i, prefix + "cust_nm");
        				document.form.frm_t5sheet1_cust_addr_c.value=sheetObj.GetCellValue(i, prefix + "cust_addr");
        			} else if (sValue == "N") {
        				document.form.frm_t5sheet1_cust_cd_n.value=sheetObj.GetCellValue(i, prefix + "cust_cd");
        				document.form.frm_t5sheet1_cust_nm_n.value=sheetObj.GetCellValue(i, prefix + "cust_nm");
        				document.form.frm_t5sheet1_cust_addr_n.value=sheetObj.GetCellValue(i, prefix + "cust_addr");
        			} else if (sValue == "A") {
        				document.form.frm_t5sheet1_cust_cd_a.value=sheetObj.GetCellValue(i, prefix + "cust_cd");
        				document.form.frm_t5sheet1_cust_nm_a.value=sheetObj.GetCellValue(i, prefix + "cust_nm");
        			}
        		}         	   
            }
        } else {
     	   fnNoticeClear();
        }
    }        
     /**
      * t5sheet2-  After finishing retrieve, setting value
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg   
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function t5sheet2_OnSearchEnd(sheetObj, ErrMsg){
        cntrQtySum=0;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
        		var maxRow=sheetObj.LastRow();
        		var sValue="";
        		var prefix="t5sheet2_";
        		for(i=1;i <= maxRow ; i++){
        			for(var q=1;q<6;q++){
        				//FAX
        				sValue=sheetObj.GetCellValue( i,prefix + "snd_rslt_cd"+q);
        				if(sValue == "R"){  // fail,red
         					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#FF0000");
        				}else if(sValue == "B"){  // success,blue
         					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#0000FF");
        				}else if(sValue == "X"){  // black
         					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#000000");
        				}else if(sValue == "P"){  // proceed,pink
         					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#FF00C0");
        				}
        				sValue=sheetObj.GetCellValue( i,prefix + "snd_rslt_nm"+q);
        				if(sValue != "") {
        					sheetObj.SetToolTipText(i, prefix + "snd_no"+q,sValue);
        				}
        			}
        		}
        		sValue=sheetObj.GetCellValue( i,prefix + "snd_gdt");
         		if(sValue != "") {
    				sheetObj.SetToolTipText(i, prefix + "snd_dt",sValue);
    			}
            }
        }
    }        
     /**
      * t5sheet3-  After finishing retrieve, setting value
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg  
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function t5sheet3_OnSearchEnd(sheetObj, ErrMsg){
        cntrQtySum=0;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
        		var maxRow=sheetObj.LastRow();
        		var sValue="";
        		var prefix="t5sheet3_";
        		for(i=1;i <= maxRow ; i++){
        			for(var q=1;q<6;q++){
        				// EMAIL
        				// E-mail success / failure code- EML_PROC_STS_CD
        				sValue=sheetObj.GetCellValue( i,prefix + "snd_rslt_cd"+q);
        				if(sValue == "R"){  //  fail,red
         					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#FF0000");
        				}else if(sValue == "B"){//success,blue
         					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#0000FF");
        				}else if(sValue == "X"){  // black
         					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#000000");
        				}else if(sValue == "P"){  // proceed,pink
         					sheetObj.SetCellFontColor(i,prefix + "snd_no"+q,"#FF00C0");
        				}
        				sValue=sheetObj.GetCellValue( i,prefix + "snd_rslt_nm"+q);
       				    if(sValue != "") {
       					    sheetObj.SetToolTipText(i, prefix + "snd_no"+q,sValue);
       				    }
        			}
        			sValue=sheetObj.GetCellValue( i,prefix + "snd_gdt");
           		    if(sValue != "") {
    				    sheetObj.SetToolTipText(i, prefix + "snd_dt",sValue);
    			    }
        		}                
            }
        }
    }        
     /**
      * t5sheet2 list click event
      * @param Object  sheetObj IBSheet Object
      * @param Integer row     
      * @param Integer col      
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function t5sheet2_OnClick(sheetObj, Row, Col){        	 
        previewSheet=1;
    }
    /**
     * t5sheet3 list click event
     * @param Object  sheetObj IBSheet Object
     * @param Integer row     
     * @param Integer col     
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function t5sheet3_OnClick(sheetObj, Row, Col){        	 
        previewSheet=2;
    }
    function fnNoticeClear() {
    	document.form.frm_t5sheet1_cust_cd_c.value="";
    	document.form.frm_t5sheet1_cust_nm_c.value="";
    	document.form.frm_t5sheet1_cust_addr_c.value="";
    	document.form.frm_t5sheet1_cust_cd_n.value="";
    	document.form.frm_t5sheet1_cust_nm_n.value="";
    	document.form.frm_t5sheet1_cust_addr_n.value="";
    	document.form.frm_t5sheet1_cust_cd_a.value="";
    	document.form.frm_t5sheet1_cust_nm_a.value="";
    	for(i=0;i<sheetObjects.length;i++) sheetObjects[i].RemoveAll();
    }
    function fnQueryExec(bkg_no, bl_no) {
    	if (bkg_no != "") {         	
      		document.form.bkg_no.value=bkg_no;
      		document.form.bl_no.value=bl_no;
      		fnSearch();
        }     	
    }
    /**
    * double click event
    **/
    function t5sheet2_OnDblClick(sheetObj, Row, Col, Value){
        var colName=sheetObj.ColSaveName(Col);
        if( colName == "t5sheet2_" + "diff_rmk"){
            sheetObj.SetCellEditable(Row, colName,0);
            ComShowMemoPad(sheetObj, Row, colName, true, 200, 100 );
        }
    }
    /**
     * double click event
     **/
     function t5sheet3_OnDblClick(sheetObj, Row, Col, Value){
         var colName=sheetObj.ColSaveName(Col);
         if( colName == "t5sheet3_" + "diff_rmk"){
             sheetObj.SetCellEditable(Row, colName,0);
             ComShowMemoPad(sheetObj, Row, colName, true, 200, 100 );
         }
     }    

     function resizeIfSheet(){
         ComResizeSheet(sheetObjects[2], 70);
    } 