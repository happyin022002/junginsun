/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0668_07.js
*@FileTitle  :  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var t1beforetab=1;
    var t2beforetab=1;
    var t7sheet1_num=0;
    var t7sheet2_num=1;
    var t7sheet3_num=2;
    var comboFlg=null;
    var cntrQtySum=0;
    var chgFlag=null;
    var frt_term_cd=null;
    var t6previewSheet=1;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             /***** using extra sheet valuable if there are more 2 sheets *****/
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
        		
                switch(srcName) {
	                case "btn_t7TemplateAuto": //"btn_t7TemplateAuto"
	                	var param="&pgmNo=ESM_BKG_0411";
	                	ComOpenWindowCenter("/opuscntr/ESM_BKG_0411_POP.do?mainPage=false"+ param, "ESM_BKG_0411", 1024, 710, false);
	            		break;
	                case "btn_t7TemplateManual": //"btn_t7TemplateManual"
	                	var param="&pgmNo=ESM_BKG_1034";
	            		ComOpenWindowCenter("/opuscntr/ESM_BKG_1034_POP.do?mainPage=false"+ param, "ESM_BKG_1034", 1024, 650, false);
	                	break;
	                case "btn_t7SendManual": //"btn_t7SendManual"
	                	var bl_no=document.form.bl_no.value;
	                	var param="&pgmNo=ESM_BKG_1066&bl_no="+bl_no;
	                	ComOpenWindowCenter("/opuscntr/ESM_BKG_1066_POP.do?mainPage=false"+ param, "ESM_BKG_1066", 1100, 690, false);
	                	break;
	                case "btn_t7Preview": //"btn_t7Preview"
	                	fnPreview();
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
         * @param sheet_obj IBSheet Object
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
            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
			if (document.form.bkg_no.value != "") {
				fnSearch();
			}
        }
        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         * @param sheetObj sheet Object
         * @param sheetNo 
         */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "t7sheet1":      //t7sheet1 init
                with(sheetObj){
	              var HeadTitle="|Cust Cd|Cust Nm|Pod Cd|Del Cd|Cust Addr|Cust_Seq|bkg cust tp cd|cust cnt cd|pkup_yd_cd";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              var prefix="t7sheet1_";
	
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
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_cnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }, 
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
	              SetVisible(0);
                }

                break;
            case "t7sheet2":      //t7sheet2 init
                with(sheetObj){
	             var HeadTitle1="|Seq|Container No.|Type|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|A.NOTIFY|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|One Time Only|E_CD1|E_CD2|E_CD3|E_CD4|E_CD5|E_NM1|E_NM2|E_NM3|E_NM4|E_NM5|F_CD1|F_CD2|F_CD3|F_CD4|F_CD5|F_NM1|F_NM2|F_NM3|F_NM4|F_NM5|Result Date|E_GDT|Sent ID|Result Date|F_GDT|Sent ID|Remark|Bkg No";
	             var headCount=ComCountHeadTitle(HeadTitle1);
	             var prefix="t7sheet2_";
	
	             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	             var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	             InitHeaders(headers, info);
	
	             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pkup_ntc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_eml1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_eml2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_eml3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_eml4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_eml5",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_no1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_no2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_no3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_no4",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_no5",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_nm1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_nm2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_nm3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_nm4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_nm5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_nm1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_nm2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_nm3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_nm4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_nm5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_gdt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_gdt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	              
	             InitColumns(cols);
	
	             SetEditable(1);
	             SetCountPosition(0);
	             SetEllipsis(1);
	             SetSheetHeight(135);
            }
                break;
            case "t7sheet3":      //t7sheet3 init
                with(sheetObj){
		             var HeadTitle1="|Seq|Container No.|Type|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|A.NOTIFY|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|One Time Only|E_CD1|E_CD2|E_CD3|E_CD4|E_CD5|E_NM1|E_NM2|E_NM3|E_NM4|E_NM5|F_CD1|F_CD2|F_CD3|F_CD4|F_CD5|F_NM1|F_NM2|F_NM3|F_NM4|F_NM5|Result Date|E_GDT|Sent ID|Result Date|F_GDT|Sent ID|Remark|Bkg No";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		             var prefix="t7sheet3_";
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pkup_ntc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_eml1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_eml2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_eml3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_eml4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_eml5",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_no1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_no2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_no3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_no4",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_no5",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_nm1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_nm2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_nm3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_nm4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_rslt_nm5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_nm1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_nm2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_nm3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_nm4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_rslt_nm5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_gdt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_gdt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             InitColumns(cols);
		
		             SetEditable(1);
		             SetCountPosition(0);
		             SetEllipsis(1);
		             SetSheetHeight(135);
                  }


            break;
        }
    }
    /**
     * Sheet process handling
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            //sheetObj.ShowDebugMsg = false;
            switch(sAction) {
               case IBSEARCH:      //Retrieve
                	ComOpenWait(true);
           			sheetObjects[t7sheet1_num].SetWaitImageVisible(0);
           			formObj.f_cmd.value=SEARCH;
           			var aryPrefix=new Array("t7sheet1_", "t7sheet2_", "t7sheet3_");
                     var sXml=sheetObj.GetSearchData("ESM_BKG_0668_07GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	         		var arrXml=sXml.split("|$$|");
//         			sheetObjects[t7sheet1_num].RenderSheet(0);
         			sheetObjects[t7sheet1_num].SetWaitImageVisible(0);
         			sheetObjects[t7sheet1_num].LoadSearchData(arrXml[0],{Sync:1} );
         			//sheetObjects[t7sheet1_num].RenderSheet(1);
         			//sheetObjects[t7sheet2_num].RenderSheet(0);
         			sheetObjects[t7sheet2_num].SetWaitImageVisible(0);
         			sheetObjects[t7sheet2_num].LoadSearchData(arrXml[1],{Sync:1} );
         			//sheetObjects[t7sheet2_num].RenderSheet(1);
         			//sheetObjects[t7sheet3_num].RenderSheet(0);
         			sheetObjects[t7sheet3_num].SetWaitImageVisible(0);
         			sheetObjects[t7sheet3_num].LoadSearchData(arrXml[2],{Sync:1} );
         			//sheetObjects[t7sheet3_num].RenderSheet(1);
	         		sheetObjects[t7sheet1_num].SetWaitImageVisible(1);
	         		ComOpenWait(false);
                    break;
            }
        }
      
   
    function fnPickupClear() {
     	document.form.frm_t7sheet1_cust_cd_c.value="";
     	document.form.frm_t7sheet1_cust_nm_c.value="";
     	document.form.frm_t7sheet1_cust_addr_c.value="";
     	document.form.frm_t7sheet1_cust_cd_n.value="";
     	document.form.frm_t7sheet1_cust_nm_n.value="";
     	document.form.frm_t7sheet1_cust_addr_n.value="";
     	document.form.frm_t7sheet1_cust_cd_a.value="";
     	document.form.frm_t7sheet1_cust_nm_a.value="";
     	sheetObjects[t7sheet1_num].RemoveAll();
    	sheetObjects[t7sheet2_num].RemoveAll();
    	sheetObjects[t7sheet3_num].RemoveAll();
    }	 	   
    function fnSearch() {
		doActionIBSheet(sheetObjects[t7sheet1_num],document.form,IBSEARCH);
    }
    /**
 	 * handling process after ending t7sheet1 retrieve
 	 * 
 	 * @param sheetObj
 	 * @param ErrMsg
 	 * @return
 	 */
   function t7sheet1_OnSearchEnd(sheetObj, ErrMsg){
        cntrQtySum=0;
      	var maxRow=sheetObj.LastRow();
      	var prefix="t7sheet1_";
      	var cellValue="";
         if (ErrMsg == "") {
             if(sheetObj.RowCount()> 0){
          		for(i=1;i <= maxRow ; i++){
          			cellValue=sheetObj.GetCellValue( i,prefix + "bkg_cust_tp_cd");
          			if (cellValue == "C") {
          				document.form.frm_t7sheet1_cust_cd_c.value=sheetObj.GetCellValue(i, prefix + "cust_cd");
          				document.form.frm_t7sheet1_cust_nm_c.value=sheetObj.GetCellValue(i, prefix + "cust_nm");
          				document.form.frm_t7sheet1_cust_addr_c.value=sheetObj.GetCellValue(i, prefix + "cust_addr");
          			} else if (cellValue == "N") {
          				document.form.frm_t7sheet1_cust_cd_n.value=sheetObj.GetCellValue(i, prefix + "cust_cd");
          				document.form.frm_t7sheet1_cust_nm_n.value=sheetObj.GetCellValue(i, prefix + "cust_nm");
          				document.form.frm_t7sheet1_cust_addr_n.value=sheetObj.GetCellValue(i, prefix + "cust_addr");
          			} else if (cellValue == "A") {
          				document.form.frm_t7sheet1_cust_cd_a.value=sheetObj.GetCellValue(i, prefix + "cust_cd");
          				document.form.frm_t7sheet1_cust_nm_a.value=sheetObj.GetCellValue(i, prefix + "cust_nm");
          			}
          		}         	   
             }
         } else {
        	 fnPickupClear();
         }
   }        	  
   /**
	 * handling process after ending t7sheet2 retrieve
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
    function t7sheet2_OnSearchEnd(sheetObj, Code , ErrMsg){
        cntrQtySum=0;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
        		var maxRow=sheetObj.LastRow();
        		var cellValue="";
        		var prefix="t7sheet2_";
        		for(i=1;i <= maxRow ; i++){
         			//setting font color by status
         			for(var q=1;q<6;q++){
         				// EMAIL
         				// Success / Fail Code - EML_PROC_STS_CD
         				cellValue=sheetObj.GetCellValue( i,prefix + "eml_snd_rslt_cd"+q);
        				if(cellValue == "R"){  // Failure : RED
         					sheetObj.SetCellFontColor(i,prefix + "ntc_eml"+q,"#FF0000");
        				}else if(cellValue == "B"){  // Success : BLUE 
         					sheetObj.SetCellFontColor(i,prefix + "ntc_eml"+q,"#0000FF");
        				}else if(cellValue == "X"){  // BLACK
         					sheetObj.SetCellFontColor(i,prefix + "ntc_eml"+q,"#000000");
        				}else if(cellValue == "P"){  // Processing : PINK
         					sheetObj.SetCellFontColor(i,prefix + "ntc_eml"+q,"#FF00C0");
        				}
        				cellValue=sheetObj.GetCellValue( i,prefix + "eml_snd_rslt_nm"+q);
        				if(cellValue != "") {
        					sheetObj.SetToolTipText(i, prefix + "ntc_eml"+q,cellValue);
        				}
        				//FAX
        				cellValue=sheetObj.GetCellValue( i,prefix + "fax_snd_rslt_cd"+q);
        				if(cellValue == "R"){  // Failure : RED
         					sheetObj.SetCellFontColor(i,prefix + "fax_no"+q,"#FF0000");
        				}else if(cellValue == "B"){  // Success : BLUE 
         					sheetObj.SetCellFontColor(i,prefix + "fax_no"+q,"#0000FF");
        				}else if(cellValue == "X"){  // BLACK
         					sheetObj.SetCellFontColor(i,prefix + "fax_no"+q,"#000000");
        				}else if(cellValue == "P"){  // Processing : PINK
         					sheetObj.SetCellFontColor(i,prefix + "fax_no"+q,"#FF00C0");
        				}
        				cellValue=sheetObj.GetCellValue( i,prefix + "fax_snd_rslt_nm"+q);
        				if(cellValue != "") {
        					sheetObj.SetToolTipText(i, prefix + "fax_no"+q,cellValue);
        				}
         			}
         			cellValue=sheetObj.GetCellValue( i,prefix + "eml_snd_gdt");
            		if(cellValue != "") {
    					sheetObj.SetToolTipText(i, prefix + "eml_snd_dt",cellValue);
    				}
            		cellValue=sheetObj.GetCellValue(i,prefix + "fax_snd_gdt");
	        		if(cellValue != "") {
						sheetObj.SetToolTipText(i, prefix + "fax_snd_dt",cellValue);
					}
        		}
            }
        }
    }        
    /**
 	 * handling process after ending t7sheet3 retrieve
 	 * 
 	 * @param sheetObj
 	 * @param ErrMsg
 	 * @return
 	 */
    function t7sheet3_OnSearchEnd(sheetObj, Code , ErrMsg){
         cntrQtySum=0;
         if (ErrMsg == "") {
             if(sheetObj.RowCount()> 0){
         		var maxRow=sheetObj.LastRow();
         		var cellValue="";
         		var prefix="t7sheet2_";
         		for(i=1;i <= maxRow ; i++){
          			//setting font color by status 
          			for(var q=1;q<6;q++){
          				// EMAIL
          				// Success / Fail Code - EML_PROC_STS_CD
          				cellValue=sheetObj.GetCellValue( i,prefix + "eml_snd_rslt_cd"+q);
         				if(cellValue == "R"){  // Failure : RED
          					sheetObj.SetCellFontColor(i,prefix + "ntc_eml"+q,"#FF0000");
         				}else if(cellValue == "B"){  // Success : BLUE
          					sheetObj.SetCellFontColor(i,prefix + "ntc_eml"+q,"#0000FF");
         				}else if(cellValue == "X"){  // BLACK
          					sheetObj.SetCellFontColor(i,prefix + "ntc_eml"+q,"#000000");
         				}else if(cellValue == "P"){  // Processing : PINK
          					sheetObj.SetCellFontColor(i,prefix + "ntc_eml"+q,"#FF00C0");
         				}
         				cellValue=sheetObj.GetCellValue( i,prefix + "eml_snd_rslt_nm"+q);
         				if(cellValue != "") {
         					sheetObj.SetToolTipText(i, prefix + "ntc_eml"+q,cellValue);
         				}
         				//FAX
         				cellValue=sheetObj.GetCellValue( i,prefix + "fax_snd_rslt_cd"+q);
         				if(cellValue == "R"){  // Failure : RED
          					sheetObj.SetCellFontColor(i,prefix + "fax_no"+q,"#FF0000");
         				}else if(cellValue == "B"){  // Success : BLUE
          					sheetObj.SetCellFontColor(i,prefix + "fax_no"+q,"#0000FF");
         				}else if(cellValue == "X"){  // BLACK
          					sheetObj.SetCellFontColor(i,prefix + "fax_no"+q,"#000000");
         				}else if(cellValue == "P"){  // Processing : PINK
          					sheetObj.SetCellFontColor(i,prefix + "fax_no"+q,"#FF00C0");
         				}
         				cellValue=sheetObj.GetCellValue( i,prefix + "fax_snd_rslt_nm"+q);
         				if(cellValue != "") {
         					sheetObj.SetToolTipText(i, prefix + "fax_no"+q,cellValue);
         				}
          			}
          			cellValue=sheetObj.GetCellValue( i,prefix + "eml_snd_gdt");
             		if(cellValue != "") {
     					sheetObj.SetToolTipText(i, prefix + "eml_snd_dt",cellValue);
     				}
             		cellValue=sheetObj.GetCellValue(i,prefix + "fax_snd_gdt");
 	        		if(cellValue != "") {
 						sheetObj.SetToolTipText(i, prefix + "fax_snd_dt",cellValue);
 					}
         		}
             }
         }
    }        
    /**
  	 * setting tab object
  	 * @param tab_obj
  	 * @return
  	 */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
    /**
   	 * init tab object
   	 * @param tab_obj
   	 * @param tabNo
   	 * @return
   	 */
    function initTab(tabObj , tabNo) {
     	 switch(tabNo) {
              case 1:
                	 with (tabObj) {
                      var cnt=0 ;
                      InsertItem( "Fax" , "");
                      InsertItem( "E-mail" , "");
                      SetSelectedIndex(0);
                 }
                 break;
             case 2:
            	 with (tabObj) {
            		 var cnt=0 ;
            		 InsertItem( "Fax" , "");
            		 InsertItem( "E-mail" , "");
            		 SetSelectedIndex(0);
            	 }
            	 break;
          }
    }
    /**
     * tab1 change handling 
     * @param tabObj
     * @param nItem
     * @return
     */
    function t7tab1_OnChange(tabObj , nItem)
     {
    	 	var prefix="t7sheet2_";
    	 	var sheetObj=sheetObjects[t7sheet2_num];
			if(nItem == 0){//Fax
				sheetObj.SetColHidden(prefix + "ntc_eml1",1);
				sheetObj.SetColHidden(prefix + "ntc_eml2",1);
				sheetObj.SetColHidden(prefix + "ntc_eml3",1);
				sheetObj.SetColHidden(prefix + "ntc_eml4",1);
				sheetObj.SetColHidden(prefix + "ntc_eml5",1);
				sheetObj.SetColHidden(prefix + "eml_snd_dt",1);
				sheetObj.SetColHidden(prefix + "eml_snd_id",1);
				sheetObj.SetColHidden(prefix + "fax_no1",0);
				sheetObj.SetColHidden(prefix + "fax_no2",0);
				sheetObj.SetColHidden(prefix + "fax_no3",0);
				sheetObj.SetColHidden(prefix + "fax_no4",0);
				sheetObj.SetColHidden(prefix + "fax_no5",0);
				sheetObj.SetColHidden(prefix + "fax_snd_dt",0);
				sheetObj.SetColHidden(prefix + "fax_snd_id",0);
			}else if(nItem == 1){//E-Mail
				sheetObj.SetColHidden(prefix + "ntc_eml1",0);
				sheetObj.SetColHidden(prefix + "ntc_eml2",0);
				sheetObj.SetColHidden(prefix + "ntc_eml3",0);
				sheetObj.SetColHidden(prefix + "ntc_eml4",0);
				sheetObj.SetColHidden(prefix + "ntc_eml5",0);
				sheetObj.SetColHidden(prefix + "eml_snd_dt",0);
				sheetObj.SetColHidden(prefix + "eml_snd_id",0);
				sheetObj.SetColHidden(prefix + "fax_no1",1);
				sheetObj.SetColHidden(prefix + "fax_no2",1);
				sheetObj.SetColHidden(prefix + "fax_no3",1);
				sheetObj.SetColHidden(prefix + "fax_no4",1);
				sheetObj.SetColHidden(prefix + "fax_no5",1);
				sheetObj.SetColHidden(prefix + "fax_snd_dt",1);
				sheetObj.SetColHidden(prefix + "fax_snd_id",1);
			}
			t1beforetab=nItem;
     }     
    /**
     * tab2 change handling 
     * @param tabObj
     * @param nItem
     * @return
     */
     function t7tab2_OnChange(tabObj , nItem)
      {
	  	 	var prefix="t7sheet3_";
    	 	var sheetObj=sheetObjects[t7sheet3_num];
			if(nItem == 0){//Fax
				sheetObj.SetColHidden(prefix + "ntc_eml1",1);
				sheetObj.SetColHidden(prefix + "ntc_eml2",1);
				sheetObj.SetColHidden(prefix + "ntc_eml3",1);
				sheetObj.SetColHidden(prefix + "ntc_eml4",1);
				sheetObj.SetColHidden(prefix + "ntc_eml5",1);
				sheetObj.SetColHidden(prefix + "eml_snd_dt",1);
				sheetObj.SetColHidden(prefix + "eml_snd_id",1);
				sheetObj.SetColHidden(prefix + "fax_no1",0);
				sheetObj.SetColHidden(prefix + "fax_no2",0);
				sheetObj.SetColHidden(prefix + "fax_no3",0);
				sheetObj.SetColHidden(prefix + "fax_no4",0);
				sheetObj.SetColHidden(prefix + "fax_no5",0);
				sheetObj.SetColHidden(prefix + "fax_snd_dt",0);
				sheetObj.SetColHidden(prefix + "fax_snd_id",0);
			}else if(nItem == 1){//E-Mail
				sheetObj.SetColHidden(prefix + "ntc_eml1",0);
				sheetObj.SetColHidden(prefix + "ntc_eml2",0);
				sheetObj.SetColHidden(prefix + "ntc_eml3",0);
				sheetObj.SetColHidden(prefix + "ntc_eml4",0);
				sheetObj.SetColHidden(prefix + "ntc_eml5",0);
				sheetObj.SetColHidden(prefix + "eml_snd_dt",0);
				sheetObj.SetColHidden(prefix + "eml_snd_id",0);
				sheetObj.SetColHidden(prefix + "fax_no1",1);
				sheetObj.SetColHidden(prefix + "fax_no2",1);
				sheetObj.SetColHidden(prefix + "fax_no3",1);
				sheetObj.SetColHidden(prefix + "fax_no4",1);
				sheetObj.SetColHidden(prefix + "fax_no5",1);
				sheetObj.SetColHidden(prefix + "fax_snd_dt",1);
				sheetObj.SetColHidden(prefix + "fax_snd_id",1);
			}
			t2beforetab=nItem;
      }     
     /**
      * preview button click event handling
      */
    function fnPreview() {
    	var formObj=document.form;
    	if (sheetObjects[t7sheet1_num].RowCount()== 0) {
    		ComShowCodeMessage("BKG00395");
    		return;
    	}
		//RD 정보 구해오기
    	var bkg_no=document.form.bkg_no.value;
    	var ntc_seq="";
    	var usr_id=strUsr_id;
    	var ofc_cd=strOfc_cd;
    	
    	//Canada Pick up Notice 위한 값
    	var pkup_yd_cd= sheetObjects[t7sheet1_num].GetCellValue(1, "t7sheet1_pkup_yd_cd");
    	var pod_cd  =   sheetObjects[t7sheet1_num].GetCellValue(1, "t7sheet1_pod_cd");
    	var del_cd  =   sheetObjects[t7sheet1_num].GetCellValue(1, "t7sheet1_del_cd");
    	    	
		if(bkg_no == ""){
			ComShowCodeMessage("BKG00149");
			return;
		}
		formObj.com_mrdTitle.value="PickUp Notice";
        formObj.com_mrdBodyTitle.value="PickUp Notice";
        if((pkup_yd_cd != "" && pkup_yd_cd == "CAHAL01") || pod_cd.substring(0,2) == "CA" && del_cd.substring(0,2) =="CA"){
        formObj.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/ESM_BKG_5032.mrd";
        }else{
        formObj.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/ESM_BKG_5018.mrd";
        }
        formObj.com_mrdArguments.value="/rv bkg_no['" + bkg_no + "'] ntc_seq['" + ntc_seq + "'] usr_id['" + usr_id + "'] ofc_cd['" + ofc_cd + "']  form_ofcCd['" + strOfc_cd + "']" + 
        	                                 "p_pkup_ntc_fom_cd['EV1'] p_pkup_yd_cd[''] p_rtn_yd_cd[''] p_rmk[''] form_showPuFlg['1'] ";
        
//        ComOpenRDPopupModal();
        ComOpenRDPopup();
    }
    function fnQueryExec(bkg_no, bl_no) {
    	if (bkg_no != "") {
    		document.form.bkg_no.value=bkg_no;
    		document.form.bl_no.value=bl_no;
    		fnSearch();
        }     	
    }
