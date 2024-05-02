/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0132.js
*@FileTitle  : Cargo Release Order_E-D/O inquiry _Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/25
=========================================================*/

/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                              MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
                              Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 
// public variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
       	try {
       		var srcName=ComGetEvent("name");
       		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;							
				case "btn_Retrieve2":
					doActionIBSheet(sheetObject3,document.form,SEARCH02);
				break;
				case "btn_downexcel":
             		if(sheetObject1.RowCount() < 1){//If there's no result
             			ComShowCodeMessage("BKG00109");
             		}else{
             			sheetObject1.Down2Excel({ HiddenColumn:true});
             		}
				break;
				case "btn_delete":
					doActionIBSheet(sheetObject1,document.form,IBDELETE);
					break;
				break;														
				case "btn_cargo":
					var curRow=sheetObject1.GetSelectRow();
             		var bkgNo="";
             		if (curRow > 1) {
             			bkgNo=sheetObject1.GetCellValue(curRow ,"sheet1_bkg_no");
             		} 
					var param="?bkg_no="+bkgNo+"&pgmNo=ESM_BKG_0682&mainPage=false";
					ComOpenWindowCenter("/opuscntr/ESM_BKG_0682_POP.do"+param, "ESM_BKG_0682", 1250, 768, false, 'yes');
				break;
				case "btn_do":
             		if(sheetObject1.RowCount() < 1){//If there's no result
             			ComShowCodeMessage("BKG00149");       
             			return false;
             		}
             		var curRow=sheetObject1.GetSelectRow();
             		var rqstNo=sheetObject1.GetCellValue(curRow ,"sheet1_edo_rqst_no");
	        		var tpCd="5JN";
	        		var rqstSeq5jn=sheetObject1.GetCellValue(curRow,"sheet1_edo_rqst_seq_5jn");
	        		var rqstSeq5jm=sheetObject1.GetCellValue(curRow,"sheet1_edo_rqst_seq_5jm");
	        		var rqstSeq5jk=sheetObject1.GetCellValue(curRow,"sheet1_edo_rqst_seq_5jk");
	        		if (rqstSeq5jn == "") {
	        			ComShowCodeMessage("BKG03055");	        			
             			return false;
	        		}
					var param="?edo_rqst_no="+rqstNo+"&edo_tp_cd="+tpCd;
				    param+="&edo_rqst_seq_5jn="+rqstSeq5jn+"&edo_rqst_seq_5jm="+rqstSeq5jm; 
					param+="&edo_rqst_seq_5jk="+rqstSeq5jk+"&pgmNo=ESM_BKG_0133";
					ComOpenWindow("/opuscntr/ESM_BKG_0133.do"+param, "myWin", "dialogWidth:940px;dialogHeight:720px;dialogLeft:0;dialogTop:0", false);
				break;																					
				case "btn_jaga":
					if(sheetObject1.RowCount() < 1){//If there's no result
             			ComShowCodeMessage("BKG00149");       
             			return false;
             		}
             		var curRow=sheetObject1.GetSelectRow();
             		var rqstNo=sheetObject1.GetCellValue(curRow ,"sheet1_edo_rqst_no");
	        		var tpCd="5JM";
	        		var rqstSeq5jn=sheetObject1.GetCellValue(curRow,"sheet1_edo_rqst_seq_5jn");
	        		var rqstSeq5jm=sheetObject1.GetCellValue(curRow,"sheet1_edo_rqst_seq_5jm");
	        		var rqstSeq5jk=sheetObject1.GetCellValue(curRow,"sheet1_edo_rqst_seq_5jk");
	        		if (rqstSeq5jm == "") {
	        			ComShowCodeMessage("BKG03055");
             			return false;
	        		}
					var param="?edo_rqst_no="+rqstNo+"&edo_tp_cd="+tpCd;
				    param+="&edo_rqst_seq_5jn="+rqstSeq5jn+"&edo_rqst_seq_5jm="+rqstSeq5jm; 
					param+="&edo_rqst_seq_5jk="+rqstSeq5jk+"&pgmNo=ESM_BKG_0136";
					ComOpenWindow("/opuscntr/ESM_BKG_0136.do"+param, "myWin", "scroll:auto;status:no;help:no;dialogWidth:960px;dialogHeight:670px;dialogLeft:0;dialogTop:0", false);
    			break;	
    			case "btn_bose":
					if(sheetObject1.RowCount() < 1){//If there's no result
             			ComShowCodeMessage("BKG00149");       
             			return false;
             		}
             		var curRow=sheetObject1.GetSelectRow();
             		var rqstNo=sheetObject1.GetCellValue(curRow ,"sheet1_edo_rqst_no");
	        		var tpCd="5JK";
	        		var rqstSeq5jn=sheetObject1.GetCellValue(curRow,"sheet1_edo_rqst_seq_5jn");
	        		var rqstSeq5jm=sheetObject1.GetCellValue(curRow,"sheet1_edo_rqst_seq_5jm");
	        		var rqstSeq5jk=sheetObject1.GetCellValue(curRow,"sheet1_edo_rqst_seq_5jk");
	        		if (rqstSeq5jk == "") {
	        			ComShowCodeMessage("BKG03055");
             			return false;
	        		}
					var param="?edo_rqst_no="+rqstNo+"&edo_tp_cd="+tpCd;
				    param+="&edo_rqst_seq_5jn="+rqstSeq5jn+"&edo_rqst_seq_5jm="+rqstSeq5jm; 
					param+="&edo_rqst_seq_5jk="+rqstSeq5jk+"&pgmNo=ESM_BKG_0135";
					ComOpenWindow("/opuscntr/ESM_BKG_0135.do"+param, "myWin", "scroll:auto;status:no;help:no;dialogWidth:960px;dialogHeight:670px;dialogLeft:0;dialogTop:0", false);
				break;
				case "btn_check":
             		var curRow=sheetObject1.GetSelectRow();
             		var blNo="";
             		if (curRow > 1) {
             			blNo=sheetObject1.GetCellValue(curRow ,"sheet1_bl_no");
             		} 
	        		var fromDt=document.form.edo_rqst_dt_s.value;
	        		var toDt=document.form.edo_rqst_dt_e.value;
					var param="?edo_rqst_dt_s="+fromDt+"&edo_rqst_dt_e="+toDt;
					param+="&bl_no="+blNo+"&pgmNo=ESM_BKG_0134";
					ComOpenWindowCenter("/opuscntr/ESM_BKG_0134_POP.do"+param, "myWin", 1000, 630, false);
				break;							
                case "btns_calendar2":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.elements["edo_rqst_dt_s"], formObject.elements["edo_rqst_dt_e"],'yyyy-MM-dd');
                break;   
                case "btn_Close":
					ComClosePopup();
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
		    initControl();
            if(document.getElementById("autoSearchFlg").value =='Y'){
                doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
            }
            
            //@ Test Code Start ----------
//             form.edo_rqst_dt_s.value ='2013-10-01';
//             form.edo_rqst_dt_e.value ='2013-10-10';
			//@ Test Code End   ----------
		}
		/**
		 * set event and initial value of screen controlset event and initial value of screen control
		 */
		function initControl() {
			var formObject=document.form;
			axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
			formObject.edo_rqst_dt_s.value=ComGetNowInfo("ymd", "");	//set today
			formObject.edo_rqst_dt_e.value=ComGetNowInfo("ymd", "");	//set today
			//axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 
			//axon_event.addListenerForm  ('beforeactivate',   'obj_activate',    form);
			//axon_event.addListenerFormat('keypress',         'obj_keypress',    form); 
			ComBtnDisable("btn_Retrieve2");
			//axon_event.addListener("change","obj_change", "edo_tp_cd"); //Doc.Type
		}
	    function resizeSheet(){
	        ComResizeSheet(sheetObjects[0]);
	    }
		
        /**
         * setting sheet initial values and header
         * 
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
    		var sheetID=sheetObj.id;
            switch(sheetID) {
                case "sheet1":      //sheet1 init
                    with(sheetObj){                    
                  var HeadTitle1="| |No|B/L No|Consignee|POD|DEL|Warehouse|D/O request|D/O request|D/O request|D/O issue|D/O issue|self transportation|self transportation|transportation|transportation|ARRIVAL VESSEL|ARRIVAL VESSEL|Delete ID|EDO_RQST_SEQ_5JN|EDO_RQST_SEQ_5JM|EDO_RQST_SEQ_5JK|EDO_RQST_NO|EDO_TP_CD|BKG_NO";
                  var HeadTitle2="| |No|B/L No|Consignee|POD|DEL|Warehouse|H.Sts|Request Date|The place of receipt|Approval Date|H.OFC|H.Sts|Request Date|H.Sts|Request Date|VVD|DATE|Delete ID|EDO_RQST_SEQ_5JN|EDO_RQST_SEQ_5JM|EDO_RQST_SEQ_5JK|EDO_RQST_NO|EDO_TP_CD|BKG_NO";
                  var prefix="sheet1_";

                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );

                  var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"},
                              { Text:HeadTitle2, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"pty_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"wh_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"do_edo_ack_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"do_edo_rct_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"do_edo_rct_loc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rqst_edo_iss_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hndl_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"selt_edo_ack_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"selt_edo_rct_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibdt_edo_ack_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ibdt_edo_rct_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_arr_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"delt_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rqst_seq_5jn" },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rqst_seq_5jm" },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rqst_seq_5jk" },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rqst_no" },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_tp_cd" },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no" } ];
                   
                  InitColumns(cols);

                  SetEditable(1);
                  SetColProperty(prefix+"do_edo_rct_dt", {Format:"####-##-####:##"} );
                  SetColProperty(prefix+"rqst_edo_iss_dt", {Format:"####-##-####:##"} );
                  SetColProperty(prefix+"selt_edo_rct_dt", {Format:"####-##-####:##"} );
                  SetColProperty(prefix+"ibdt_edo_rct_dt", {Format:"####-##-####:##"} );
                  SetColProperty(prefix+"vsl_arr_dt", {Format:"####-##-##"} );
                  SetRangeBackColor(1, 2, 1, 36,"#777777");
//                  SetSheetHeight(402);
                  resizeSheet();
                }
                break;
                case "sheet2":      //sheetHidden init
                    with(sheetObj){                    
                  var HeadTitle=" |EDO_RQST_NO|EDO_TP_CD|DEL_CHK";
                  var prefix="sheet2_";

                  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"edo_rqst_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"edo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                   
                  InitColumns(cols);
                  SetEditable(1);
                  SetVisible(0);
                }
                break;
                case "sheet3":      //sheet3 init
                    with(sheetObj){
                    
                  //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                  var HeadTitle1="| |No|B/L No|POD|DEL|Warehouse|D/O 신청|D/O 신청|D/O 신청|D/O 발급|D/O 발급|Self transportation|Self transportation|transportation|transportation|ARRIVAL VESSEL|ARRIVAL VESSEL|Delete ID|EDO_RQST_SEQ_5JN|EDO_RQST_SEQ_5JM|EDO_RQST_SEQ_5JK|EDO_RQST_NO|EDO_TP_CD|BKG_NO|신청업체명|신청업체연락처|실화주명|실화주연락처|컨테이너타입|컨테이너QTY";
                  var HeadTitle2="| |No|B/L No|POD|DEL|Warehouse|H.Sts|Request Date|접수지|Approval Date|H.OFC|H.Sts|Request Date|H.Sts|Request Date|VVD|DATE|Delete ID|EDO_RQST_SEQ_5JN|EDO_RQST_SEQ_5JM|EDO_RQST_SEQ_5JK|EDO_RQST_NO|EDO_TP_CD|BKG_NO|신청업체명|신청업체연락처|실화주명|실화주연락처|컨테이너타입|컨테이너QTY";
                  var prefix="sheet3_";

                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );

                  var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"},
                              { Text:HeadTitle2, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"wh_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"do_edo_ack_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"do_edo_rct_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"do_edo_rct_loc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rqst_edo_iss_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hndl_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"selt_edo_ack_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"selt_edo_rct_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibdt_edo_ack_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ibdt_edo_rct_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_arr_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"delt_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rqst_seq_5jn" },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rqst_seq_5jm" },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rqst_seq_5jk" },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rqst_no" },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_tp_cd" },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no" },
                         {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"pty_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"phn_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"pty_as_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"phn_as_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"op_cntr_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                   
                  InitColumns(cols);

                  SetEditable(1);
                  SetColProperty(prefix+"do_edo_rct_dt", {Format:"####-##-####:##"} );
                  SetColProperty(prefix+"rqst_edo_iss_dt", {Format:"####-##-####:##"} );
                  SetColProperty(prefix+"selt_edo_rct_dt", {Format:"####-##-####:##"} );
                  SetColProperty(prefix+"ibdt_edo_rct_dt", {Format:"####-##-####:##"} );
                  SetColProperty(prefix+"vsl_arr_dt", {Format:"####-##-##"} );
                  
                  SetVisible(0);
                }
                break;                    
            }
        }
		/**
		 * handling sheet process
		 */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            switch(sAction) {
				case IBSEARCH:      //retrieve
					if(!validateForm(sheetObj,formObj,sAction)) return false;
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_BKG_0132GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
	                
				break;
				case SEARCH02:      //retrieve
					formObj.f_cmd.value=SEARCH02;
					sheetObj.DoSearch("ESM_BKG_0132GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_") );
					sheetObj.Down2Excel({ HiddenColumn:-1});
				break;
				case IBDELETE:        //delete
					if(!validateForm(sheetObj,formObj,sAction)) return false;
					if(!ComShowCodeConfirm('BKG43029')){
	                    return false;
	                }					
					formObj.f_cmd.value=REMOVE;
					var prefix="sheet1_";
					var saveString=sheetObj.GetSaveString(false, true, prefix + "del_chk");
	                var sParam=FormQueryString(formObj) + "&" + saveString;	                        
	                sheetObj.DoSave("ESM_BKG_0132GS.do", sParam,-1,0);
				break;    					
            }
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
     		switch(sAction) {       	 
				case IBSEARCH:
	                if(ComIsEmpty(formObj.edo_rqst_dt_s.value) && ComIsEmpty(formObj.edo_rqst_dt_e.value)){
	                    ComShowCodeMessage('BKG00545');
	                    formObj.edo_rqst_dt_s.focus();
	                    return false;
	                }
                    var v_sdate=formObj.edo_rqst_dt_s.value;//Start date
                    var v_edate=formObj.edo_rqst_dt_e.value;//end date
                    if(!ComIsDate(v_sdate, 'yyyy-MM-dd') || !ComIsDate(v_edate, 'yyyy-MM-dd')){
                        ComShowCodeMessage("BKG00421");
                        formObj.edo_rqst_dt_s.focus();
                        return false;
                    }
                    if(ComGetDaysBetween(v_edate, v_sdate) > 0){
                    	ComShowCodeMessage("BKG00421");
                        formObj.edo_rqst_dt_s.focus();
                        return false;
                    }
	                return true;
		    		break;
		    	case IBDELETE:
		    		var prefix="sheet1_";
		    	    if(document.form.delt_flg.value == "Y"){
		    	        return false;
		    	    }
		    	    if(sheetObj.RowCount()== 0){
		    	    	ComShowCodeMessage("BKG00546");
		    	        return false;
		    	    }
		    	    var sDel=sheetObj.GetSaveString(false, true, prefix + "del_chk");
		    	    if (sDel == "") {
		    	    	ComShowCodeMessage("BKG00546");
		    	    	return false;
		    	    }
			        break; 
     		}
            return true;
        }
        /**
         * task javascript OnFocus event handling
         */
        function obj_activate() {
            var objName=event.srcElement.name;
            var formObj=document.form;
            switch(objName) {
                case "edo_rqst_dt_s":
                    formObj.edo_rqst_dt_s.value=formObj.edo_rqst_dt_s.value.replace(eval("/-/gi"), "");
                    break;
                case "edo_rqst_dt_e":
                    formObj.edo_rqst_dt_e.value=formObj.edo_rqst_dt_e.value.replace(eval("/-/gi"), "");
                    break;
            }
        }
        /**
        *  Blur event handling
        */
        function obj_deactivate(){
            //입력Validation 확인 및 마스킹 처리
            ComChkObjValid(event.srcElement);
        }
        /**
         * control keyboard input  onkeypress event of HTML Control
         **/
        function obj_keypress(){
            switch(event.srcElement.dataformat){
                case "float":
                    ComKeyOnlyNumber(event.srcElement, ".");
                    break;
                case "eng":                    
                    ComKeyOnlyAlphabet('uppernum', '8|32');
                    break;
                case "engdn":
                    ComKeyOnlyAlphabet('lower', '8|32');
                    break;
                case "engup":
                    ComKeyOnlyAlphabet('upper', '8|32');
                    break;
                default:	
                    ComKeyOnlyNumber(event.srcElement);
            }
        }
        /**
         * handling After Hidden IBSheet retrieve
         */
        function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        	var formObj=document.form;
            if (ErrMsg == "") {
                if(sheetObj.RowCount()> 0){
                	formObj.frm_sheet2_edo_rqst_no.value=sheetObj.GetCellValue(2,"sheet1_edo_rqst_no");
                	formObj.frm_sheet2_edo_tp_cd.value=sheetObj.GetCellValue(2,"sheet1_edo_tp_cd");
                }
            } else {
                ComShowMessage(ErrMsg);
            }
            buttonControl();
         }
        /**
         * IBSheet Object mouse click
         */
        function sheet1_OnClick(sheetObj, Row, Col, Value) {
        	var formObj=document.form;
        	if (Row > 1) {
        		if (Col == 1) {
        			if (sheetObj.GetCellValue(Row,"sheet1_del_chk") == true) {
	        			sheetObj.SetRowStatus(Row,"");
	        		} else {
	        			sheetObj.SetRowStatus(Row,"U");
	        		}
        		}
        	}
        }    
        /**
         * sheet1를 저장하고 나서 처리할 사항
         */
        function sheet1_OnSaveEnd(sheetObj, ErrMsg){
            if (ErrMsg == "") {
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                ComBkgSaveCompleted();  //서버메세지 처리
            }
        }         
        /**
        * control button
        */
        function buttonControl(){
           	if (document.form.delt_flg.value == "Y") {
          		ComBtnDisable("btn_delete");
          	} else {
          		ComBtnEnable("btn_delete");
          	}
        }
         /**
          * Retrieve the Enter key when performing a function call
          */
        function enterKeySearch(){
            var keyCode=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            var formObject=document.form;
            var srcName=ComGetEvent("name");
            if(ComIsEmpty(srcName)){
                return;
            }
            // Enter key (13),
            if (keyCode == 13) {
	            if(ComIsEmpty(formObject.edo_rqst_dt_s.value) && ComIsEmpty(formObject.edo_rqst_dt_e.value)){
	            	ComShowCodeMessage('BKG00545');
	                formObject.edo_rqst_dt_s.focus();
	                return false;
	            }
                var v_sdate=formObject.edo_rqst_dt_s.value;//시작일
                var v_edate=formObject.edo_rqst_dt_e.value;//종료일
                if(!ComIsDate(v_sdate, 'yyyy-MM-dd') || !ComIsDate(v_edate, 'yyyy-MM-dd')){
                	ComShowCodeMessage("BKG00421");
                    formObject.edo_rqst_dt_s.focus();
                    return false;
                }
                if(ComGetDaysBetween(v_edate, v_sdate) > 0){
                	ComShowCodeMessage("BKG00421");
                    formObject.edo_rqst_dt_s.focus();
                    return false;
                }
                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
            } // end if
        }               
          /**
           * Change event handling.<br>
           * @return 
           */
          function obj_change() {
        	  var form=document.form;
         	    switch(event.srcElement.name) {
                  case "edo_tp_cd":
					if(form.edo_tp_cd[1].selected) {	
						ComBtnEnable("btn_Retrieve2");
					}
					else
					{
						ComBtnDisable("btn_Retrieve2");
					}
                  	break;
         	    }
          }
 