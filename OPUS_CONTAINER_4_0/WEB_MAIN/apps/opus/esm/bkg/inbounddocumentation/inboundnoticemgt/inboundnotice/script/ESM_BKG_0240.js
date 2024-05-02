/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0240.js
*@FileTitle  : Integrated Customer Data Management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/* developer's work*/
	// global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// tab prefix
	var prefixArr=new Array(6);
	prefixArr[0]="ge_";
	prefixArr[1]="dr_";
	prefixArr[2]="cy_";
	prefixArr[3]="cf_";
	prefixArr[4]="sp_";
	prefixArr[5]="e1_";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
	    /***** using extra sheet valuable if there are more 2 sheets *****/
	    var sheetObject1=sheetObjects[0];
	    var sheetObject2=sheetObjects[1];
	    var sheetObject3=sheetObjects[2];
	    var sheetObject4=sheetObjects[3];
	    var sheetObject5=sheetObjects[4];//TRO
	    /*******************************************************/
	    var formObject=document.form;
	    var srcName=ComGetEvent("name");
	    //prohibiting to use when it is prohibited button
	    if(!ComIsBtnEnable(srcName)){
	        return;
	    }
	    switch(srcName) {
	        case "btn_Retrieve":
	            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	            break;
	        case "btn_DownExcel":
	        	if(sheetObject1.RowCount() < 1){//no data
	        	     ComShowCodeMessage("COM132501");
	        	    }else{
	        	    	sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
	        	    }
	            break;
	        case "btn_Save":
	            if(sheetObject2.IsDataModified()== true){//according to modify
	            	if(validateForm(sheetObject2,formObject,IBSAVE)){
	                	doActionIBSheet(sheetObject2,formObject,IBSAVE);
	                    //ComShowCodeMessage("COM12156");
	                    }
	            }else{
	                ComShowCodeMessage("BKG00233");
	            }
	            break;
	        case "btn_Del":
	            dataFlagToIBSheet(sheetObject1, "D");
	            doActionIBSheet(sheetObject1,formObject,IBDELETE);
	            break;
	        case "t1btn_RowAdd":
	            var row=sheetObject2.DataInsert(-1);
	            sheetObject2.SetCellValue(row,3,formObject.login_ofc_cd.value);
	            break;
	        case "t1btn_RowCopy":
	            sheetObject2.DataCopy();
	            break;
	        case "t1btn_Delete":
	            fncTab1RowDelete(sheetObject2,"t1sheet_delChk");
	            break;
	        case "t1btn_SettingAN":
	            var goUrl="ESM_BKG_0672_POP.do?1=1";
	            var param="&pgmNo=ESM_BKG_0672-01";
	            param +="&mainPage=false";
	            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0672",1024,600,true);
	            break;
	        case "btn_Retrieve_Ib":
	            doActionIBSheet_Search(sheetObject2,formObject,IBSEARCH);
	            break;
	        case "btn_FullUpdatedHistory":
	            var formObj=document.form;
	            var param="";            
	            param += "cust_cnt_cd="+formObj.cust_cnt_cd_ib.value;
	            param += "&cust_seq="+formObj.cust_seq_ib.value;
	            param += "&cust_nm="+encodeURI(formObj.cust_lgl_eng_nm_ib.value);
	            param += "&ofc_cd="+formObj.ofc_cd_ib.value;
	            if(formObj.cust_cnt_cd_ib.value == "" || formObj.cust_seq_ib.value == ""){
	                return;
	            }
	            var goUrl="/opuscntr/ESM_BKG_0764.do?"+param;
	            ComOpenWindowCenter(goUrl,"ESM_BKG_0764",1024,510,true);
	            //}
	            break;
	        case "btn_CustomersClearanceType":
	            if(param != "")
	            {
	                var formObj=document.form;
	                var goUrl="/opuscntr/ESM_BKG_0540_POP.do?";
	                var param="";
	                param += "cust_cnt_cd="+formObj.cust_cnt_cd_ib.value;
	                param += "&cust_seq="+formObj.cust_seq_ib.value;
	                //param += "&cust_nm="+formObj.cust_lgl_eng_nm_ib.value;
	                param += "&ofc_cd="+formObj.login_ofc_cd.value;
	                param += "&pid=ESM_BKG_M046&pgmNo=ESM_BKG_0540";
	                ComOpenWindowCenter(goUrl+encodeURI(param),"ESM_BKG_0540",1024,700,true);
	            }
	            break;
	        case "btn_ConcernedParty":
	            if(param != "")
	            {
	                var formObj=document.form;
	                var goUrl="/opuscntr/ESM_BKG_1044.do?";
	                var param="";
	                param += "cust_cnt_cd="+formObj.cust_cnt_cd_ib.value;
	                param += "&cust_seq="+formObj.cust_seq_ib.value;
	                param += "&cust_nm="+formObj.cust_lgl_eng_nm_ib.value;
	                param += "&ofc_cd="+formObj.ofc_cd_ib.value;
	                ComOpenWindowCenter(goUrl+encodeURI(param),"ESM_BKG_1044",800,380,true);
	            }
	            break;
	        case "btn_UpdateSetup":
	            if(param != "")
	            {
	                var formObj=document.form;
	                var goUrl="/opuscntr/ESM_BKG_1099.do?";
	                var param="";
	                param += "&ofc_cd="+formObj.ofc_cd_ib.value;
	                ComOpenWindowCenter(goUrl+encodeURI(param),"ESM_BKG_1099",550,190, true);
	            }
	            break;   
	        case "btn_Close":
	        	ComClosePopup();
	        	break;
	    } // end switch
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
	    var formObj=document.form;
	    fnInSetComboBox(formObj.cust_sts_cd, evtStatusCode, evtStatusValue, "|", null, null, true, "A");
	    ComBtnSetInquiry();
	    for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	    for(k=0;k<tabObjects.length;k++){
	        initTab(tabObjects[k],k+1);
	    }
	    for(i=0;i<sheetObjects.length;i++){
	    }
	    initControl();
	    // deactivating  IB Sheet button
	    ComBtnDisable("t2btn_SettingAN");
	    ComBtnDisable("t3btn_SettingAN");
	    ComBtnDisable("t4btn_SettingAN");
	    fncSelRadioChange();
	    ComBtnDisable("btn_CustomersClearanceType");
	    ComBtnDisable("btn_ConcernedParty");
		form.ofc_cd_ib.value=sessOfcCd;
		
		formObj.cust_sts_cd.value="A";
		
	    if(document.form.cust_cnt_cd.value != ""
	        && document.form.cust_seq.value != ""
	        && autoSearchFlg == "Y"){
	        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    }
	}
	
    function resizeSheet(){
        ComResizeSheet(sheetObjects[1]);
        ComResizeSheet(sheetObjects[2]);
        ComResizeSheet(sheetObjects[3]);
        ComResizeSheet(sheetObjects[4]);
    }

	/**
	     * setting sheet initial values and header
	     * param : sheetObj, sheetNo
	     * adding case as numbers of counting sheets
	     */
	function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
	    switch(sheetNo) {
	        case 1:      // sheet1 init
	            with(sheetObj){
		          var HeadTitle="|Seq.|Code|Name|Country|Address|Tel.|Fax|E-mail|Status|Blacklisted|Create Date|Primary Sale Rep|S/Office";
		          var sheetName="sheet1_";
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"hdnStatus" },
		                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"Seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"cust_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:125,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"cust_lgl_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:290,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"bzet_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"phn_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"fax_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"cust_eml",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",     Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"cust_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"booking_alert_to_date", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"srep_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetWaitImageVisible(0);
		          SetSheetHeight(170);
	            }
	        break;
	        
	        case 2:      // t1sheet init
	            with(sheetObj){
		          var HeadTitle="|Seq.|Check|OFC|Concern Party|Do Not\nSend|Fax|Do Not\nSend|E-mail|Tel.|Mobile|Updated|Update ID|User Name|Remark(s)|cust_cnt_cd|cust_seq|Fax_org|E-Mail_org";
		          var sheetName="t1sheet_";
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:sheetName+"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"Seq" },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"delChk" },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		                 {Type:"Combo",     Hidden:0, Width:195,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"cust_cntc_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"fax_snd_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"fax_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"eml_snd_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"cntc_eml",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
		                 {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"phn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"mphn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"cntc_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:sheetName+"cust_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:sheetName+"cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:115,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"fax_no_org",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"cntc_eml_org",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
		                 {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"fax_snd_flg_org", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
		                 {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"eml_snd_flg_org", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"ib_cmdt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetWaitImageVisible(0);
		          SetColHidden(2,1);
		          SetColProperty(sheetName+"upd_dt", {Format:"####-##-####:##"} );
		          SetColProperty(sheetName+"cust_cntc_tp_cd", {ComboText:evtValue, ComboCode:evtCode} );
		          SetColProperty(0 ,sheetName+"fax_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		          SetColProperty(0 ,sheetName+"phn_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
//		          SetSheetHeight(207);
		          resizeSheet();
	          }
	        break;
	        
	        case 3:      // t2sheet1 init
	            with(sheetObj){
		          var HeadTitle="|Seq.|Name|Address|Tel. No.|Fax. No.|Attention|City|State|Zip Code|E-mail|Remark";
		          var sheetName="t2sheet_";
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"Status" },
		                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"Seq" },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"cust_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:195,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"cust_addr",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"cust_phn_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"cust_fax_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"Attention",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"cust_cty_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"cust_ste_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"cust_zip_cd", KeyField:0,   CalcLogic:"",   Format:"PostNo",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"cust_eml",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"tmplt_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		          SetEditable(1);
		          SetWaitImageVisible(0);
//		          SetSheetHeight(207);
		          resizeSheet();
		        }
	        break;
	        
	        case 4:      // t3sheet1 init
	            with(sheetObj){
		          var HeadTitle="|Seq.|Actual Payer Code|O/B E-mail|I/B E-mail|Local Name|Local Address #1|Local Address #2|Customer Type|I/B OFC|Local Zip Code|Local TEL No.|Local Fax No.|Remark";
		          var sheetName="t3sheet_";
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"Seq" },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"act_cust_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"ob_eml",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"ib_eml",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"locl_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"addr1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"addr2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"cr_cust_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"kr_ib_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"locl_zip_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"phn_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"fax_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"cr_cust_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetWaitImageVisible(0);
//		          SetSheetHeight(207);
		          resizeSheet();
	            }
	        break;
	        
	        case 5:      // t4sheet1 init
	            with(sheetObj){
		          var HeadTitle="|Seq.|Location|Zone|Factory Name (Actual Customer)|Contact Person|Telephone|Mobile|Address|Zip|Remark";
		          var sheetName="t4sheet_";
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"Status" },
		                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"Seq" },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"zn_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"act_shpr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"cntc_pson_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"cntc_phn_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"cntc_mphn_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"act_shpr_addr", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:sheetName+"dor_zip_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"diff_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetWaitImageVisible(0);
		          //SetSheetHeight(207);
		          resizeSheet();
		        }
	       break;
	    }
	}
	// handling of Sheet 
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    switch(sAction) {
	        case IBSEARCH:      //search
	            doActionIBSheet_Search(sheetObj,formObj,sAction);
	            break;
	        case IBSAVE:        //save
	            doActionIBSheet_Save(sheetObj,formObj,sAction);
	            //doActionIBSheet(sheetObjects[beforetab+1],formObj,IBSEARCH);
	            break;
	        case IBINSERT:      // insert
	            break;
	    }
	}
	
	// handling of Sheet (search)
	function doActionIBSheet_Search(sheetObj,formObj,sAction){
	    if(validateForm(sheetObj,formObj,sAction))
	        //----------------------------
	        // Master grid search
	        //----------------------------
	        if(sheetObj.id == "sheet1"){
	            formObj.f_cmd.value=SEARCH01;
	            //multiple searching
	            var anyPrefix=new Array("sheet1_","t1sheet_"); //prefix string list, (as many as the number of sheet)
	            var param=ComGetPrefixParam(anyPrefix);
				ComOpenWait(true);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0240GS.do", FormQueryString(formObj) + "&" + param);
	            var arrXml=sXml.split("|$$|");
	            for(var i=0; i < arrXml.length; i++){
	                sheetObjects[i].RenderSheet(0);
	                if(i > 0) {
	                    sheetObjects[i].SetWaitImageVisible(0);
	                }
	                sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
	                sheetObjects[i].RenderSheet(1);
	            }
	        //----------------------------
	        // searching I/B 
	        //----------------------------
	        } else if ( sheetObj.id == "t1sheet"){
	            formObj.f_cmd.value=SEARCH02;
	            ComOpenWait(true);
	            sheetObj.DoSearch("ESM_BKG_0240GS.do" ,FormQueryString(formObj)  + "&"  + ComGetPrefixParam("t1sheet_"));
	        //----------------------------
	        // searching O/B 
	        //----------------------------
	        } else if ( sheetObj.id == "t2sheet"){
	            formObj.f_cmd.value=SEARCH03;
	            var addParam="&cust_cnt_cd="+formObj.cust_cnt_cd_ob.value+"&cust_seq="+formObj.cust_seq_ob.value;
				ComOpenWait(true);
				sheetObj.DoSearch("ESM_BKG_0240GS.do" ,FormQueryString(formObj) + "&" + ComGetPrefixParam("t2sheet_"));
	        } else if ( sheetObj.id == "t3sheet"){
	            formObj.f_cmd.value=SEARCH04;
	            var addParam="&cust_cnt_cd="+formObj.cust_cnt_cd_invoice.value+"&cust_seq="+formObj.cust_seq_invoice.value;
				ComOpenWait(true);
				sheetObj.DoSearch("ESM_BKG_0240GS.do" ,FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet_"));
	        } else if ( sheetObj.id == "t4sheet"){
	            formObj.f_cmd.value=SEARCH05;
	            var addParam="&cust_cnt_cd="+formObj.cust_cnt_cd_tro.value+"&cust_seq="+formObj.cust_seq_tro.value;
				ComOpenWait(true);
				sheetObj.DoSearch("ESM_BKG_0240GS.do" ,FormQueryString(formObj) + "&" + ComGetPrefixParam("t4sheet_"));
	        }
	}
	// handling of Sheet (saving)
	function doActionIBSheet_Save(sheetObj,formObj,sAction){
	    //----------------------------
	    // saving I/B 
	    //----------------------------
	    if ( sheetObj.id == "t1sheet"){
	        formObj.f_cmd.value=MULTI01;
	        var addParam="&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
	        if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
	            sheetObj.DoSave("ESM_BKG_0240GS.do", FormQueryString(formObj)+addParam);
	            ComOpenWait(false);
	        }
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
	     * setting Tab 
	     * setting item of Tab
	     */
	function initTab(tabObj , tabNo) {
	    switch(tabNo) {
	        case 1:
	            with (tabObj) {
	                var cnt=0 ;
	                InsertItem( "I/B" , "");
	                InsertItem( "O/B" , "");
	                InsertItem( "Invoice" , "");
	                InsertItem( "TRO(Warehouse)" , "");
	            }
	        break;
	    }
	    tabObj.SetSelectedIndex(0);
	}
	/**
	     * Event when clicking Tab
	     * activating selected tab items
	     */
	function tab1_OnChange(tabObj , nItem)
	{
		formObject = document.form;
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		for(var i = 0; i< objs.length; i++){
	       	  if(i != nItem){
	        	   objs[i].style.display="none";
	        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	       	  }
		}
		beforetab=nItem;
	    // I/B
	    if(nItem == 0){
	        ComBtnEnable("btn_DownExcel");
	        ComBtnEnable("btn_Save");
	        ComBtnDisable("t4btn_RowAdd");
	        ComBtnDisable("t4btn_RowDelete");
	        ComBtnEnable("t1btn_SettingAN");
	    }else{
	        ComBtnDisable("btn_DownExcel");
	        ComBtnDisable("btn_Save");
	        ComBtnDisable("t1btn_SettingAN");
	        ComBtnDisable("t2btn_SettingAN");
	        ComBtnDisable("t3btn_SettingAN");
	        ComBtnDisable("t4btn_SettingAN");
	    }
	    resizeSheet();
	    // O/B
	    if(nItem == 1){
	        doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
	    }
	    // Invoice
	    if(nItem == 2){
	        doActionIBSheet(sheetObjects[3],formObject,IBSEARCH);
	    }
	    // TRO
	    if(nItem == 3){
	        doActionIBSheet(sheetObjects[4],formObject,IBSEARCH);
	    }
	    
	}
	/**
	     * handling process for input validation
	     */
	function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
	        case IBSEARCH:      //searching
	            with(formObj){
	                //---------------------------------------
	                //Cusotmer Code
	                //---------------------------------------
	                if(sel_radio[0].checked){
	                    if(cust_cnt_cd.value == ""){
	                        ComShowCodeMessage("BKG40012");
	                        cust_cnt_cd.focus();
	                        return false;
	                    }
	                    if(cust_seq.value == ""){
	                        ComShowCodeMessage("BKG40012");
	                        cust_seq.focus();
	                        return false;
	                    }
		        		if(!ComIsNull(formObj.cust_seq)&&!ComIsNumber(formObj.cust_seq.value)){
		        			ComShowCodeMessage("BKG00340");
		        			ComSetFocus(formObj.cust_seq);
		        			return false;
		        		}
	                    cust_lgl_eng_nm.value="";
	                    cust_cnt_cd_ext.value="";
	                //---------------------------------------
	                //Cusotmer Name
	                //---------------------------------------
	                }else if(sel_radio[1].checked){
	                    if(cust_lgl_eng_nm.value == ""){
	                        ComShowCodeMessage("BKG40012");
	                        cust_lgl_eng_nm.className="input1";
	                        cust_lgl_eng_nm.focus();
	                        return false;
	                    }
	                    // more than 2 digit
	                    if(cust_lgl_eng_nm.value.length < 2){
	                        ComShowCodeMessage("BKG04017");
	                        cust_lgl_eng_nm.className="input1";
	                        cust_lgl_eng_nm.focus();
	                        return false;
	                    }
	                    cust_cnt_cd.value="";
	                    cust_seq.value="";
	                }
	                }
	            break;
	        case IBSAVE: 
	            //data duplication
	        	for(var i=1 ; i < sheetObj.LastRow() ; i++){
		            if(sheetObj.GetCellValue(i,"t1sheet_cntc_eml")!=""){
		                if(!BkgIsEmailAddr(sheetObj.GetCellValue(i,"t1sheet_cntc_eml"))){
		                	ComShowCodeMessage("BKG00366");
		                    sheetObj.SelectCell(i, "t1sheet_cntc_eml");
		                    return false;
		                }
		             }
	            }
	            
	          //데이터 중복                
	            return fncDupCheck(sheetObj);
	            
	            break;
	    }
	    return true;
	}
	
	function fncDupCheck(sheetObj){
	    var faxStr=new Array();
	    var emlStr=new Array();
	    for(var i=0 ; i < sheetObj.LastRow() ; i++){
	    	faxStr[i]=sheetObj.GetCellValue(i,"t1sheet_fax_no");
	    	emlStr[i]=sheetObj.GetCellValue(i,"t1sheet_cntc_eml");
	    }
	    for(var j=0;j<faxStr.length;j++){
	        for(var k=0;k < faxStr.length;k++){
	            if(j != k && faxStr[j] != "" && faxStr[k] != "" && faxStr[j] == faxStr[k]){
	                ComShowCodeMessage("BKG40104");
	                return false;
	            }
	        }
	    }
	    for(var j=0;j<emlStr.length;j++){
	        for(var k=0;k < emlStr.length;k++){
	            if(j != k && emlStr[j] != "" && emlStr[k] != "" && emlStr[j] == emlStr[k]){
	                ComShowCodeMessage("BKG40104");
	                return false;
	            }
	        }
	    }
	    return true;
	}
	/**
	     * finishing to search Master 
	     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
	    formObj=document.form;
	    with(sheetObj){
	        SetColFontColor(2,"#0000FF");
	        SetColFontUnderline(2,1);
	        //setting with Black List 
	        for(var b=1;b<=RowCount();b++){
	            //setting with Black List
	        	var txt=GetCellValue(b,"sheet1_booking_alert_to_date");
	            //alert(txt);
	            if(txt == "Yes"){
	            	SetCellFontColor(b,"sheet1_booking_alert_to_date","#FF0000");
	            }else if(txt == "No"){
	            	SetCellFontColor(b,"sheet1_booking_alert_to_date","#0000FF");
	            }
	        }
	        // inserting value to I/B,O/B, after searching 
	        if(RowCount() == 1){
	            setDetailSearchCondition(sheetObj,1,2);
	            doActionIBSheet(sheetObjects[beforetab + 1],formObj,IBSEARCH);
	        }
	        //inserting common code to Combo in a Sheet 
	        formObj.f_cmd.value=SEARCH19;
	        var param="&cd=CD02129";
	        var sXml=sheetObj.GetSearchData("ESM_BKG_0240GS.do", FormQueryString(formObj) + param);
	        var arrData=ComBkgXml2ComboString(sXml, "intg_cd_val_ctnt", "intg_cd_val_dp_desc");
	        ComSetIBCombo(sheetObjects[1],sXml,"t1sheet_cust_cntc_tp_cd",false,"","","","cd");
	        // moving into tab1 when it finish searching
	        }
	}
	/**
	     *  searching Detail when Master is clicked(I/B)
	     */
	function sheet1_OnDblClick(sheetObj,row,col){
	    formObj=document.form;
	    with(sheetObj)
	    {
	        setDetailSearchCondition(sheetObj,row,2);
	        doActionIBSheet(sheetObjects[beforetab+1],formObj,IBSEARCH);
	    }
	}
	var clickSheet;
	var clickRow=1;
	var clickCol;
	/**
	     *  handling event when I/B Detail is clicked 
	     */
	function t1sheet_OnClick(sheetObj,row,col,value)
	{
	    clickSheet=sheetObj;
	    clickRow=row;
	    clickCol=col;
	}
	
	// setting each condition to each tab
	function setDetailSearchCondition(sheetObj,row,col){
	    with(sheetObj)
	    {
	    	formObj.cust_cnt_cd.value=GetCellValue(row,col).substr(0,2);
	    	formObj.cust_seq.value=GetCellValue(row,col).substr(2);
	        //formObj.ofc_cd.value = CellValue(row,13); // S/Office
	        //IB
	    	formObj.cust_cnt_cd_ib.value=GetCellValue(row,col).substr(0,2);
	    	formObj.cust_seq_ib.value=GetCellValue(row,col).substr(2);
	    	formObj.cust_lgl_eng_nm_ib.value=GetCellValue(row,col+1);
	        formObj.ofc_cd_ib.value=sessOfcCd;
	        //OB
	        formObj.cust_cnt_cd_ob.value=GetCellValue(row,col).substr(0,2);
	        formObj.cust_seq_ob.value=GetCellValue(row,col).substr(2);
	        formObj.cust_lgl_eng_nm_ob.value=GetCellValue(row,col+1);
	        //Invoice
	        formObj.cust_cnt_cd_invoice.value=GetCellValue(row,col).substr(0,2);
	        formObj.cust_seq_invoice.value=GetCellValue(row,col).substr(2);
	        formObj.cust_lgl_eng_nm_invoice.value=GetCellValue(row,col+1);
	        //TRO
	        formObj.cust_cnt_cd_tro.value=GetCellValue(row,col).substr(0,2);
	        formObj.cust_seq_tro.value=GetCellValue(row,col).substr(2);
	        formObj.cust_lgl_eng_nm_tro.value=GetCellValue(row,col+1);
	    }
	}
	//OnKeyDown event  Catch
	function initControl() {
	//Axon handling event1. event catch
	//axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	//axon_event.addListener ('keypress', 'engnum_keypress', 'cust_cnt_cd');
	//axon_event.addListener ('keypress', 'engnum_keypress', 'ofc_cd');
	//axon_event.addListener ('keypress', 'engnum_keypress', 'cust_lgl_eng_nm');
	//axon_event.addListenerFormat ('keypress', 'obj_KeyPress', form);
	}
	//handling OnKeyPress 
//	function engnum_keypress() {
//	    //only alphabet upper case
//	    ComKeyOnlyAlphabet('uppernum');
//	}
	// in case of changing the value of IB sheet
	function t1sheet_OnChange(sheetObj,row,col,value){
	    var formObj=document.form;
	    if(col < 3){//  prohibiting modification of check 
	        return;
	    }
	    //if there is no ofc_cd, make flag to insert
	if(sheetObj.GetCellValue(row,3).trim() != formObj.login_ofc_cd.value){
	        sheetObj.SetRowStatus(row,"I");
	    }
	}
	/**
		 * showing checked item which is deleted 
		 * @return
		 */
	function fncTab1RowDelete(sheetObj,col){
	    var sRow=sheetObj.FindCheckedRow(col);
	    var startCol=5;//sequence of starting number to delete
	    var endCol=19-3;//sequence of the last column number to delete(remaining the last Org data)
	    if (sRow == "") return 0;
	    //making row to array
	    var arrRow=sRow.split("|"); //result : "1|3|5|"
	    sheetObj.SetRenderSheetSum(0);//don't calculating total, preparing to existence of dtAutoSumEx
	    //Hiding if DataType is dtDelCheck, changing transaction and hiding if DataType is not dtDelCheck
	    if (sheetObj.GetCellProperty(0, col, dpDataType) == dtDelCheck) {
	        //deleting to inverse order(handling inverse order, because there is row which is status of inserting in the middle row.)
	        for (var idx=arrRow.length-2; idx>=0; idx--){
	        	var row=arrRow[idx];
	        	fncGetCellValueClear(sheetObj,row,startCol,endCol);
	        }
	    } else {
	        //deleting to inverse order(handling inverse order, because there is row which is status of inserting in the middle row.)
	        for (var idx=arrRow.length-2; idx>=0; idx--){
	            var row=arrRow[idx];
	            sheetObj.SetCellValue(row, col,0,0);//1.deleting check box (for other handling of checked data )
	            //sheetObj.RowHidden(row)= true;		//2.hiding row
	            fncGetCellValueClear(sheetObj,row,startCol,endCol);
	            sheetObj.SetRowStatus(row,"D");//3.make transaction status to "deleting"
	        }
	    }
	    sheetObj.SetRenderSheetSum(1);//calculating total value
	    return arrRow.length-1;
	}
	/**
		 * deleting cellvalue 
		 * @return
		 */
	function fncGetCellValueClear(sheetObj,row,startCol,endCol){
	    for(var i=startCol;i <= endCol;i++){
	        sheetObj.SetCellValue(row,i,"",0);//don't call event
	    }
	}
	/**
		 * radio activating/deactivating
		 * @return
		 */
	function fncSelRadioChange(){
	    var formObj=document.form;
	    var obj=formObj.sel_radio;
	    if(obj[0].checked){
	        ComEnableObject(formObj.cust_lgl_eng_nm,false);
	        ComEnableObject(formObj.cust_cnt_cd,true);
	        ComEnableObject(formObj.cust_seq,true);
//	        formObj.cust_cnt_cd.className="input1";
//	        formObj.cust_seq.className="input1";
	    } else if(obj[1].checked){
	        ComEnableObject(formObj.cust_lgl_eng_nm,true);
//	        formObj.cust_lgl_eng_nm.className="input1";
	        ComEnableObject(formObj.cust_cnt_cd,false);
	        ComEnableObject(formObj.cust_seq,false);
	    }
	    $(formObj.cust_cnt_cd).prop('required', obj[0].checked);
        $(formObj.cust_seq).prop('required', obj[0].checked);
        $(formObj.cust_lgl_eng_nm).prop('required', obj[1].checked);
	}
	/**
		 * out of focus in seq 
		 * make the number 6digit by inserting 0 forward
		 * @param obj
		 * @return
		 */
	function fncCustSeqBlur(obj){
	    var orgV=obj.value;
	    if(orgV.length < 1){
	        obj.value="";
	    }else{
	        obj.value=fncSeqTo6(orgV);
	    }
	}
	/**
		 * make the number 6digit by inserting 0 forward
		 * @param str
		 * @return
		 */
	function fncSeqTo6(str){
	    var currentObjLen=str.length;
	    var retStr="";
	    for(var i=0;i<6-currentObjLen;i++){
	        retStr += "0";
	    }
	    return retStr + str;
	}
	/**
		* handling event when t1sheet is retrieved
		**/
	function t1sheet_OnSearchEnd(sheetObj, ErrMsg){
	    var formObj=document.form;
	    if(sheetObj.RowCount()== 5){
	        ComBtnEnable("btn_CustomersClearanceType");
	        ComBtnEnable("btn_ConcernedParty");
	        t1sheet_OnClick(sheetObj,1,1,"");
	        if(parseInt(sheetObj.GetCellValue(1,"t1sheet_" + "ib_cmdt_flg")) > 0){
	            //bold
	        	$("#btn_ConcernedParty").attr('class','btn_etc_red');
	        } else{
	            //originally
	        	$("#btn_ConcernedParty").attr('class','btn_etc_blue');
	        }
	    } else{
	        ComBtnDisable("btn_CustomersClearanceType");
	        ComBtnDisable("btn_ConcernedParty");
	    }
	    ComOpenWait(false);
	}
	
	function t1sheet_OnSaveEnd(sheetObj, ErrMsg){
		doActionIBSheet(sheetObjects[beforetab+1],formObj,IBSEARCH);
		ComOpenWait(false);
	}
	function t2sheet_OnSearchEnd(sheetObj, ErrMsg){
	    ComOpenWait(false);
	}
	function t3sheet_OnSearchEnd(sheetObj, ErrMsg){
	    ComOpenWait(false);
	}
	function t4sheet_OnSearchEnd(sheetObj, ErrMsg){
	    ComOpenWait(false);
	}
	/**
		*  handling event in case of changing the sheet
		**/
	function t1sheet_OnChange(sheetObj, Row, Col, Value) {
	    var colName=sheetObj.ColSaveName(Col);
	    var prefix="t1sheet_";
	    // Email : Focus Out, Email format to check Validation ( only there is value)
/* 입력 시 e-mail 체크하지 않도록 수정
	    if(colName == prefix + "cntc_eml"){
	    	if(!ComIsEmailAddr(sheetObj.GetCellValue(Row,Col))){
	            ComShowCodeMessage("BKG00366");
	            sheetObj.SelectCell(Row, Col);
	            return;
	        }
	    }
*/	    
	}
	/**
		* searching IB tab in case of clicking Enter key
		**/
	function fncSearchIb(){
	    var sheetObj=sheetObjects[1];
	    var formObj=document.form;
	    doActionIBSheet_Search(sheetObj,formObj,IBSEARCH);
	}
		/* the end of developer's work */ 