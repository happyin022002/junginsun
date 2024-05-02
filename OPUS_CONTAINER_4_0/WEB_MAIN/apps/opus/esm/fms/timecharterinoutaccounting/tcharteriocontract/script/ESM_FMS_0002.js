/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0002.js
*@FileTitle  : Agreement Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends FMS
     * @class Agreement Inquiry : Agreement Inquiry definition of biz script for creation screen
     */
    // common global variables 
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var uploadObjects=new Array();
	var uploadCnt=0;
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	 var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         var sheetObject3=sheetObjects[2];
         var sheetObject4=sheetObjects[3];
         var sheetObject5=sheetObjects[4];
         var sheetObject6=sheetObjects[5];
         var sheetObject7=sheetObjects[6];
		 var sheetObject8=sheetObjects[7];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_retrive":
					doActionIBSheet(sheetObject2,formObject,IBSEARCH);
					break;
				case "btn_new":
					clearAll();
					break;
				case "btn_t5E-mail":
            		ComOpenPopup("ESM_FMS_0084.do", 460, 370, "setEmail", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0084");					
					break;
				case "btn_t6E-mail":
            		ComOpenPopup("ESM_FMS_0084.do", 460, 370, "setEmail", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0084");					
					break;
				case "btn_vslpop" :
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0022");
					break;
				case "contract_no":
					 if(formObject.vsl_cd.value == "") {
						 ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01138'));
						 return;
					 }					
					 ComOpenPopup("ESM_FMS_0023.do?ctrtFlag=Y&vsl_cd=" + formObject.vsl_cd.value, 520, 415, "setContractNo", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0023");
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
     * Registering IBUpload Object generated on Page to uploadObjects Array <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++]=uploadObj;
	}
    /**
     * initializing sheet 
     * implementing onLoad event handler in body tag 
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        initControl();
    }
  /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        	case "sheet1":      //sheet1 init
        	    with(sheetObj){
					var prefix="oli_";
					var HeadTitle="Item Name|From Date|To Date|Cur|Amount";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:0 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ 
					 {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"acct_itm_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"otr_expn_amt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 } ];
					   
					InitColumns(cols);
					SetSheetHeight(120);
					SetEditable(0);
					FitColWidth("32|13|13|8|34");
        	}
              break;
            case "t1sheet1":      //t1sheet1 init
                with(sheetObj){
					var prefix="hir_";
					var HeadTitle="|Seq|From Date|To Date|Cur 1|Daily Hire|Cur 2|Daily Hire|Ori From Date|Ori To Date ";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
					 {Type:"Text",      Hidden:0,  Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hir_curr_n1st_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",     Hidden:0,  Width:134,  Align:"Right",   ColMerge:0,   SaveName:prefix+"hir_rt_n1st_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
					 {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hir_curr_n2nd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",     Hidden:0,  Width:134,  Align:"Right",   ColMerge:0,   SaveName:prefix+"hir_rt_n2nd_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
					 {Type:"Text",      Hidden:1, Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_exp_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(120);
					SetEditable(0);
					SetColProperty(prefix+"eff_dt", {Format:"####-##-## ##:##:##"} );
					SetColProperty(prefix+"exp_dt", {Format:"####-##-## ##:##:##"} );
					SetColProperty(prefix+"ori_eff_dt", {Format:"####-##-## ##:##:##"} );
					SetColProperty(prefix+"ori_exp_dt", {Format:"####-##-## ##:##:##"} );
              }
                break;
				case "t2sheet1":      //t2sheet1 init
				    with(sheetObj){
						var prefix="otr_";
						var HeadTitle="|Seq|Item Name|Account Code|From Date|To Date|Cur|Amount|Acct Itm Seq|Ori Account Code|Ori From Date|Ori To Date|Ori Acct Itm Seq";
						SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
						 {Type:"Text",      Hidden:0,  Width:252,  Align:"Left",    ColMerge:0,   SaveName:prefix+"acct_itm_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Date",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Date",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
						 {Type:"Float",     Hidden:0,  Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"otr_expn_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
						 {Type:"Text",      Hidden:1, Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_itm_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_acct_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_exp_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_acct_itm_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 } ];
						   
						InitColumns(cols);
						SetSheetHeight(120);
						SetEditable(0);
						SetShowButtonImage(1);
			      }
                break;
				case "t3sheet1":      //t3sheet1 init
				    with(sheetObj){
						var prefix="pay_";
						var HeadTitle="|Seq|Payment Term|From Date|To Date|Ori_From Date|Ori_To Date ";
						SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
						 {Type:"Text",      Hidden:0,  Width:419,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ctrt_pay_term_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:223,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:223,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_exp_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
						   
						InitColumns(cols);
						SetSheetHeight(120);
						SetEditable(0);
						SetColProperty(prefix+"eff_dt", {Format:"####-##-## ##:##:##"} );
						SetColProperty(prefix+"exp_dt", {Format:"####-##-## ##:##:##"} );
						SetColProperty(prefix+"ori_eff_dt", {Format:"####-##-## ##:##:##"} );
						SetColProperty(prefix+"ori_exp_dt", {Format:"####-##-## ##:##:##"} );
			      }
                break;
				case "t4sheet1":      //t4sheet1 init
				    with(sheetObj){
						var HeadTitle="|Period ( + - Option)|Redelivery Range|Redelivery Notice ";
						SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						 {Type:"Text",      Hidden:0,  Width:317,  Align:"Left",    ColMerge:0,   SaveName:"chtr_prd_opt_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:367,  Align:"Left",    ColMerge:0,   SaveName:"rde_rng_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:277,  Align:"Left",    ColMerge:0,   SaveName:"rde_ntc_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
						   
						InitColumns(cols);
						SetSheetHeight(120);
						SetEditable(0);
						SetShowButtonImage(1);
			      }
				    break;
				case "t5sheet1":      //t5sheet1 init
				    with(sheetObj){
						var prefix="cpf_";
						var HeadTitle="|Sel|CP File Upload|From|To|Contents|File Path|File Chtr Tp Cd|File Seq|File Download|File Sav Id ";
						SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
						 {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
						 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Combo",     Hidden:0, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_file_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
						   
						InitColumns(cols);
						SetSheetHeight(120);
						SetEditable(1);
						SetImageList(0,"/opuscntr/img/ico_attach.gif");
						SetColHidden(prefix + "flet_file_tp_cd",1);
						SetColProperty(prefix+"flet_file_tp_cd", {ComboText:"CP", ComboCode:"CP"} );
						SetShowButtonImage(1);
			      }
                break;
				case "t6sheet1":      //t6sheet1 init
				    with(sheetObj){
						var prefix="cef_";
						var HeadTitle="|Sel|Certi File Upload|From|To|Contents|File Path|File Chtr Tp Cd|File Seq|File Download|File Sav Id ";
						SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
						 {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
						 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Combo",     Hidden:0, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_file_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
						   
						InitColumns(cols);
						SetSheetHeight(120);
						SetEditable(1);
						SetImageList(0,"/opuscntr/img/ico_attach.gif");
						SetColHidden(prefix + "flet_file_tp_cd",1);
						SetColProperty(prefix+"flet_file_tp_cd", {ComboText:"CF", ComboCode:"CF"} );
						SetShowButtonImage(1);
			      }
                break;   
				case "t7sheet1":      //t7sheet1 init
				    with(sheetObj){
						var prefix="vsl_";
						var HeadTitle="|Vessel Code|Vessel Name|Accounting|Report|Ori Vessel Code|Ori Vessel Name";
						SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						 {Type:"Text",      Hidden:0,  Width:320,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:400,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"use_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_rpt_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:400,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_vsl_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:400,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_vsl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
						   
						InitColumns(cols);
						SetSheetHeight(120);
						SetEditable(0);
						SetShowButtonImage(1);
			      }
                break; 
        }
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/ 
    function doActionIBSheet(sheetObj,formObj,sAction,gubun,row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        case IBSEARCH:     
        	/*
        	if(formObj.vsl_cd.value == "") {
        		ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01138'));
	    		return;
        	}
        	*/
        	if(formObj.flet_ctrt_no.value == "") {
        		ComAlertFocus(formObj.flet_ctrt_no, ComGetMsg('FMS01052'));
	    		return;
        	}
        	formObj.contract_no.style.cursor="default";
			//document.images["contract_no"].name="no_contract_no";
			formObj.contract_no.style.cursor="hand";
        	formObj.f_cmd.value=SEARCH;
        	var aryPrefix=new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");
        	var sXml=sheetObj.GetSearchData("ESM_FMS_0002GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
   			//alert(sXml);
			var arrXml=sXml.split("|$$|");
			//UI성능개선(201408, 민정호)
			if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
			if (arrXml.length > 1) sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
			if (arrXml.length > 2) sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
			if (arrXml.length > 3) sheetObjects[4].LoadSearchData(arrXml[3],{Sync:1} );
			if (arrXml.length > 4) sheetObjects[5].LoadSearchData(arrXml[4],{Sync:1} );
			if (arrXml.length > 5) sheetObjects[6].LoadSearchData(arrXml[5],{Sync:1} );
			if (arrXml.length > 6) sheetObjects[7].LoadSearchData(arrXml[6],{Sync:1} );
			if (arrXml.length > 7) sheetObjects[0].LoadSearchData(arrXml[7],{Sync:1} );
			//*********** Getting data from CONTRACT Table(START) ***************//
			if(typeof sheetObjects[1].GetEtcData("fletCtrtNo") != "undefined") {
				tabObjects[0].SetSelectedIndex(0);
			}			
			ComEtcDataToForm2(formObj,sheetObjects[1],"",true);
			if(typeof sheetObjects[1].GetEtcData("declFlg") != "undefined") {
				if(sheetObjects[1].GetEtcData("declFlg") == "Y") {
					formObj.decl_flg.checked=true;
				} else {
					formObj.decl_flg.checked=false;
				}
			}
			if(sheetObjects[1].GetEtcData("fletCtrtTpCd") == "T/C Out") {
				if(typeof sheetObjects[1].GetEtcData("custSeq") != "undefined") {
					formObj.cust_seq.value=sheetObjects[1].GetEtcData("custSeq");
				}
			} else {
				if(typeof sheetObjects[1].GetEtcData("vndrSeq") != "undefined") {
					formObj.cust_seq.value=sheetObjects[1].GetEtcData("vndrSeq");
					formObj.cust_cnt_cd.value="";
				}
			}
			ComEtcDataToForm2(formObj,sheetObjects[1],"hir_",true);			
           break;
		case IBROWSEARCH:      
			if(gubun == "Vessel") {
		    	if(formObj.vsl_cd.value == "") {
		    		formObj.vsl_eng_nm.value="";
		    		return;
		    	}
		    	formObj.f_cmd.value=SEARCH01;
		    	var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
	   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
	   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
	   				formObj.vsl_eng_nm.value=vslEngNm;
	   				formObj.vsl_cd.readOnly=true;
	   				formObj.btn_vslpop.style.cursor="default";
	   				formObj.btn_vslpop.style.cursor="hand";
	   				//document.images["btn_vslpop"].name="no_btn_vslpop";
				} else {
					formObj.vsl_cd.value="";
					formObj.vsl_eng_nm.value="";
					ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
					return;
				}
			}
   			break;
        }
    }
    /**
     * Registering IBTab Object to Array
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Basic Tab Setting
     * Setting Tab Items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "Hire" , "");
					InsertItem( "Other Exp" , "");
					InsertItem( "Payment Term" , "");
					InsertItem( "Redelivery" , "");
					InsertItem( "CP File up" , "");
					InsertItem( "Certi File up" , "");
					InsertItem( "Original Vessel Code" , "");
                }
                sheetObjects[4].DataInsert();
             break;
         }
    }
    /**
     * Event when click Tab
     * Activiating elements of selected tab
     */
    function tab1_OnChange(tabObj , nItem) {
//        var objs=document.all.item("tabLayer");
//    	objs[nItem].style.display="Inline";
//    	objs[beforetab].style.display="none";
//    	//--------------- Important --------------------------//
//    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
//    	//------------------------------------------------------//
//    	beforetab=nItem;
    	var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	for(var i = 0; i<objs.length; i++){
    		if(i != nItem){
    			objs[i].style.display="none";
    			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    		}
    	}
    	beforetab=nItem;
    }
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     Action Code(Example:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL )
     **/
    function validateForm(sheetObj,formObj,sAction){
        if (!ComChkValid(formObj)) return false;
        return true;
    }
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="/";
        //Axon Event Handling1. Event Catch
    	//axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'); //- Input only Upper case English or Numeric when inserting Veesel Code
        axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');		//Getting Name information after inserting Vessel Code
    }
    //Axon Event Handling2. Event Handling Function --- start
    /**
     * Only insert Numeric by onkeypress Event of HTML Control <br>
     **/
    function obj_keypress(){
    	switch(ComGetEvent("dataformat")){
			case "int":
		        ComKeyOnlyNumber(ComGetEvent());
				break;
			case "float":
		        ComKeyOnlyNumber(ComGetEvent(), ".");
				break;
			default:
		        ComKeyOnlyNumber(ComGetEvent());
    	}
    }
    /**
     * Only insert English/Numeric by onkeypress Event of HTML Control <br>
     **/
    function eng_keypress() {
        ComKeyOnlyAlphabet('upper');
    }
     /**
      * Only insert English/Numeric by onkeypress Event of HTML Control <br>
      **/
     function engnum_keypress() {
         ComKeyOnlyAlphabet('uppernum');
     }
    /**
     * Checking Validation in onblur Event of HTML Control <br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	switch(ComGetEvent("name")){
	    	case "shp_spd_qty": 
	    	case "vsl_dznd_capa": 
	    	case "bse_14ton_vsl_capa": 
	    	case "rf_cntr_plg_qty": 
	    	case "ddwt_cgo_capa_qty": 
	    	case "grs_wgt": 
	    	case "nrt_wgt":
	    	case "cust_seq":
	    		//ComChkObjValid(obj, bMsg, bTrim, bMasked)
    			ComChkObjValid(event.srcElement, true, false, false);
    			break;
    			/*
	    	case "vsl_cd":
	    	case "ori_eff_dt":
	    	case "ori_exp_dt":
	    	case "vsl_cnt_cd":
    			break;
    			*/
    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
    }
    /**
     * Removing Mask Separator in onfocus Event of HTML Control <br>
     **/
    function obj_activate(){
        ComClearSeparator(ComGetEvent());
    }
    /**
     * Getting Name relevant to the CustSeq when CustSeq is changed <br>
     **/
    function cust_seq_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Owner');
    }
    /**
     * Getting Name relevant to the VslCd when VslCd is changed <br>
     **/
    function vsl_cd_change() {    	
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Vessel');
    }
    //Axon Event Handling2. Event Handling Function --- end
    /**
     * Setting value when CheckBox is selected <br>
     **/
    function declaration_click() {
    	if(form.decl_flg.checked) {
    		form.decl_flg.value='Y';
    	} else {
    		form.decl_flg.value='N';
    	}
    }
    /**
     * Setting value when Owner Code is changed <br>
     **/
	function setOwnerCode(val) {
		if(val == "TO") {
			form.cust_cnt_cd.readOnly=false;
		} else {
			form.cust_cnt_cd.readOnly=true;
			form.cust_cnt_cd.value="";
		}
		form.cust_seq.value="";
		form.vndr_lgl_eng_nm.value="";
		form.ownr_nm.value="";
	}
	/**
     * Initializing Screen <br>
     * @return none
     * @see #ComResetAll
     **/
	function clearAll() {
		ComResetAll();
		tabObjects[0].SetSelectedIndex(0);
		form.vsl_cd.readOnly=false;
		form.btn_vslpop.style.cursor="hand";
		//document.images["btn_vslpop"].name="btn_vslpop";
		form.contract_no.style.cursor="hand";
		//document.images["contract_no"].name="contract_no";
		sheetObjects[5].CheckAll("cpf_DelChk",0);
		sheetObjects[6].CheckAll("cef_DelChk",0);
	}
	/**
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix="oli_";
		//Control as width ratio
		sheetObj.FitColWidth("32|13|13|8|34");
		//Setting 2 Column Font Color to 1 Column Font Color
		//parameter changed[check again]CLT InitCellProperty(sheetObj, prefix,{ Type:"curr_cd",Align:"otr_expn_amt"} );
	}
    /**
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix="hir_";
    	//parameter changed[check again]CLT InitCellProperty(sheetObj, prefix );
	}
	/**
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix="otr_";
    	//parameter changed[check again]CLT InitCellProperty(sheetObj, prefix,{ Type:"curr_cd",Align:"otr_expn_amt"} );
	}
    /**
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
  	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg) {
  	}
    /**
     * Event occurring when clicking Cell <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string}  prefix     	variable seperator
     * @param {string}  curSaveName currency saveName
     * @param {string}  amtSaveName amt saveName
     **/
  	function setInitCellProperty(sheetObj, prefix, curSaveName, amtSaveName, col) {
    	if(curSaveName == null || curSaveName == "") {
	    	for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
	    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + "hir_curr_n1st_cd"))) {
//parameter changed[check again]CLT 					sheetObj.InitCellProperty(ir, 5,{ Type:"Null",Align:"Right",Format:"dfNullInteger"} );
				}
	    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + "hir_curr_n2nd_cd"))) {
//parameter changed[check again]CLT 					sheetObj.InitCellProperty(ir, 7,{ Type:"Null",Align:"Right",Format:"dfNullInteger"} );
				}
			}
    	} else {
    		for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
    			if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + curSaveName))) {
					if(col == null || col == "") {
//parameter changed[check again]CLT 						sheetObj.InitCellProperty(ir, 7,{ Type:"Null",Align:"Right",Format:"dfNullInteger"} );
					} else {
//parameter changed[check again]CLT 						sheetObj.InitCellProperty(ir, col,{ Type:"Null",Align:"Right",Format:"dfNullInteger"} );
					}
				}
			}
    	}
    }
	/**
     * Downloading File <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @param {String} 	Value     	File Name
     **/
	function t5sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix="cpf_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * Dowloading File <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @param {String} 	Value     	File Name
     **/
	function t6sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix="cef_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * Event occurred when mouse pointer is moving <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	Selected Button of sheetObj
     * @param {ibsheet} Shift     	Selected Shift of sheetObj
     * @param {int} 	X     		X Coordinate Value
     * @param {int} 	Y     		Y Coordinate Value
     **/
	function t5sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		changeGetMousePointer(sheetObj,"cpf_");
	}
	/**
     * Event occurred when mouse pointer is moving <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	Selected Button of sheetObj
     * @param {ibsheet} Shift     	Selected Shift of sheetObj
     * @param {int} 	X     		X Coordinate Value
     * @param {int} 	Y     		Y Coordinate Value
     **/
	function t6sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		changeGetMousePointer(sheetObj,"cef_");
	}
	/**
     * Event occurred when mouse pointer is moving <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	Selected Button of sheetObj
     * @param {ibsheet} Shift     	Selected Shift of sheetObj
     * @param {int} 	X     		X Coordinate Value
     * @param {int} 	Y     		Y Coordinate Value
     **/
	function t2sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		changeGetMousePointer(sheetObj,"otr_");
	}
	/**
     * Changing shape of mouse pointer <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	Variable Separator
     **/
function changeGetMousePointer(sheetObj, prefix){
		var Row=sheetObj.MouseRow();
		var Col=sheetObj.MouseCol();
		if (Row<sheetObj.HeaderRows()|| Col<0) return;
		var saveName=sheetObj.ColSaveName(Col);
		if(prefix == "otr_") {
			if (saveName!=prefix+"acct_itm_nm") return;
			var status=sheetObj.GetRowStatus(Row);
			if (saveName==prefix+"acct_itm_nm") {
				sheetObj.SetMousePointer((status=="I")?"Hand":"Default");
			}
		} else {
			if (saveName!=prefix+"file_nm" && saveName!=prefix+"file_download") return;
			var status=sheetObj.GetRowStatus(Row);
			if (saveName==prefix+"file_nm") {
				sheetObj.SetMousePointer((status=="I")?"Hand":"Default");
			} else if (saveName==prefix+"file_download") {
				sheetObj.SetMousePointer((status=="I")?"Default":"Hand");
			}
		}
	}
	/**
	 * Inserting programNo<br>
	 * @param {arry} aryPopupData
	 */
	function setProgramNo(aryPopupData, row, col, sheetIdx){
		sheetObjects[2].SetCellValue(row,col,aryPopupData[0][2],0);
	    sheetObjects[2].Cellvalue2(row,"otr_acct_cd")=aryPopupData[0][3];
	    sheetObjects[2].Cellvalue2(row,"otr_acct_itm_seq")=aryPopupData[0][4];
	    setOtrEffDt(row,"otr_");
	}
	/**
	 * Inserting Contract No <br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value=aryPopupData[0][3];
		if(form.vsl_cd.value.length != 4) {
			form.vsl_cd.value=form.flet_ctrt_no.value.substring(0,4);
			form.vsl_cd.readOnly=true;
			form.btn_vslpop.style.cursor="default";
			form.btn_vslpop.style.cursor="hand";
			//document.images["btn_vslpop"].name="no_btn_vslpop";
			vsl_cd_change();
		}
	}
	/**
	  * Inserting Vessel Code <br>
	  * @param {arry} aryPopupData
	  */
	function setVslCd(aryPopupData){
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');			//Getting Name information after inserting Vessel Code
		form.vsl_cd.readOnly=true;
		form.btn_vslpop.style.cursor="default";
		form.btn_vslpop.style.cursor="hand";
		//document.images["btn_vslpop"].name="no_btn_vslpop";
	}
	/**
     * Getting FileSaveId of attached File supposed to be sent by Email <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	Variable Separator
     * @return {String} fileKey     Attached File FileSaveId
     **/
	function checkAttachFile(sheetObj, prefix) {
		var fileKey="";
		var sRow=sheetObj.FindCheckedRow(prefix + "DelChk");
		if (sRow == "") {
			ComShowMessage(ComGetMsg('COM12189'));
			//ComShowMessage(ComGetMsg('FMS01153'));
			return fileKey;
		} else {
			var arrRow=sRow.split("|");
//			for (var idx=arrRow.length-2; idx>=0; idx--) {
			for (var idx=arrRow.length-1; idx>=0; idx--) {				
				var row=arrRow[idx];
				if(sheetObj.GetCellValue(row,prefix + "file_sav_id") == "") {
					ComShowMessage(ComGetMsg('FMS01148', row));
					//ComShowMessage("파일이 저장되지 않았습니다\n\n[저장되지않은 ROW : "+row+"]");
					return "";
					break;
				}
				fileKey += sheetObj.GetCellValue(row,prefix + "file_sav_id")+ "<" + sheetObj.GetCellValue(row,prefix + "file_nm") + ";";				
			}
		}
		fileKey=fileKey.substring(0,fileKey.length-1);
		return fileKey;
	}
	
	/**
	 * set [vsl_cd]
	 * @return
	 */
	function autowrite(){
		document.form.vsl_cd.value=document.form.vsl_cd.value.toUpperCase();
	}
	
	function setEmail(aryPopupData){
        var sheetObject6=sheetObjects[5];
        var sheetObject7=sheetObjects[6];
        var formObject=document.form;
        
		var fileKey = "";
		var vsl_eng_nm = "";
		var subject = "";		
		var fileNm = "";
		
		if(tabObjects[0].GetSelectedIndex() == 4){
			//btn_t5E-mail
			fileKey=checkAttachFile(sheetObject6, 'cpf_');
			if(fileKey == "") return;
			vsl_eng_nm=formObject.vsl_eng_nm.value;
			subject="Charter Party ("+vsl_eng_nm+")";			
		}else{
			//btn_t6E-mail
			fileKey=checkAttachFile(sheetObject7, 'cef_');
			if(fileKey == "") return;
			vsl_eng_nm=formObject.vsl_eng_nm.value;
			subject="Certificate ("+vsl_eng_nm+")";			
		}
		
		formObject.com_recipient.value="";
    	var com_recipient="";
    	var idx=0;
    	var chkCnt=aryPopupData.length;
        for(var i=0; i<aryPopupData.length; i++) {
        	idx++;
 		    var emailData=aryPopupData[i];
 		    if(chkCnt == 1) {
 		    	com_recipient=emailData.cntc_pson_eml;
 		    } else {
 		    	if(chkCnt == idx) {
 		    		com_recipient += emailData.cntc_pson_eml;
 		    	} else {
 		    		com_recipient += emailData.cntc_pson_eml+";";
 		    	}
 		    }
    	}
        
        formObject.com_recipient.value=com_recipient;       						
        formObject.com_subject.value = subject;
        formObject.com_fileKey.value = fileKey;        
                
        ComSendMail();		
	}	