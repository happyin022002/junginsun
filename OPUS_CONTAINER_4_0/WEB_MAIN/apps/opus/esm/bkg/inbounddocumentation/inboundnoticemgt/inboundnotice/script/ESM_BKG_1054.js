/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1054.js
*@FileTitle  : Arrival Notice Customer Code Validate Open
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/*******************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
/**
 * @fileoverview Arrival Notice - Script define about Customer Code Validate.
 * @author
 */
/**
 * @extends
 * @class esm_bkg_1054 : esm_bkg_1054 business script.
 */
function esm_bkg_1054() {
    this.processButtonClick=tprocessButtonClick;
    this.setSheetObject=setSheetObject;
    this.loadPage=loadPage;
    this.initSheet=initSheet;
    this.initControl=initControl;
    this.doActionIBSheet=doActionIBSheet;
    this.setTabObject=setTabObject;
    this.validateForm=validateForm;
    this.obj_keypress=obj_keypress;
}
   /* Developer Work */
// global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sheetNames=new Array("t1sheet1", "t2sheet1", "t1excel", "t2excel");
	var sheetInits=new Array(     false,      false,     false,     false);
	// screen global variable
	var unMatchGrpCntU=0; 
	var delCntM=0;  // match delete count
	var currPageM=1; // match page number
	var pageResetM=true;
	/* javascript interval identifier */
	var intervalId;
	/* customer code Popup called row */
	var popupRow=0;
	/*  set condition in tab1 */
	var t1s1CondParam="";
	var t1s1NotAvailCmd=-999999;
	var gQueryStrChange=true;
	var gButtonStatus=true;
	var gKeyCode=-999;
	var gSetRowHeight=10;
	var gGetColWidthMdmCustNm=125;
	var gGetColWidthMdmCustAddr=125;
	var gGetColWidthBkgCustNm=125;
	var gGetColWidthBkgCustAddr=125;
	var gGetColWidthValCustNm=125;
	var gT2GetColWidthValMdmCustNm=155;
	var gT2GetColWidthValMdmCustAddr=155;
	var gT2GetColWidthValBkgCustNm=155;
	var gT2GetColWidthValBkgCustAddr=155;
	var gSearchSchTp="";
	var gSearchVvd="";
	var gSearchVpsEtaDtStart="";
	var gSearchVpsEtaDtEnd="";
	var gSearchPodCd="";
	var gSearchTsFlg="";
	var gSearchDelCd="";
	var gSearchPolCd="";
	var gSearchBlNo="";
	var gColorReadOnly=15986927; // RgbColor (239,240,243)
	var gColorMdmCust=13697005; // RgbColor (237,255,208)
	var gColorEditable=0       ; // RgbColor (0,0,0)
	var gColorBkgCust=13697023; // RgbColor (255,255,208)
	var gColorValCust=13692159; // RgbColor (255,236,208)
	var gColorDisabled=13816530; // RgbColor (210,210,210)
	var gFontColorBlack=0       ; // RgbColor (0,0,0)
	var gFontColorBlue=16711680; // RgbColor (0,0,255)
	var gEvaluationRowHeight = 10;

	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
/**
 * Event handler processing by button name<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function processButtonClick(){
    /** *** using extra sheet valuable if there are more 2 sheets **** */
    var shtCnt=0;
    /** **************************************************** */
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) {return;}
        switch(srcName) {
            case "btn_vps_eta_dt":
            	formObject.sch_tp[1].checked=true;
            	fnToggleSchTp(formObject.sch_tp[1].value, formObject);
                var cal=new ComCalendarFromTo();
                cal.select(formObject.vps_eta_dt_start, formObject.vps_eta_dt_end, 'yyyy-MM-dd');
                break;
            case "btn_retrieve":
                setInqueryDataToForm(false);
                var maxdate=new Date(9999, 12, 31);
                ComSetCookie("esm_bkg_1054_pod_cd" + "_" + strUsr_id , form.pod_cd.value, maxdate);
                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH,"","");
                break;
            case "btn_excel":
                   setInqueryDataToForm(true);
                   doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL,"","");
                break;
            case "btn_save":
                   doActionIBSheet(sheetObjects[beforetab],formObject,IBSAVE,"","");
                break;
            case "btn_ANSend":
                var schTp="";
                for (var idx=0; idx< formObject.sch_tp.length; idx++) {
                	if (formObject.sch_tp[idx].checked == true) {
                		schTp=formObject.sch_tp[idx].value;
                	}
                }
                var goUrl="";
				var param="";
				var queryStr=FormQueryString(document.form);
				goUrl="/opuscntr/ESM_BKG_0381_POP.do?";
				param += "1=1";
				param += "&pgmNo=ESM_BKG_0381-01";
				param += "&autoSearchFlg=Y";
				param += "&" + queryStr.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=");
				ComOpenWindowCenter(goUrl + param, "ESM_BKG_0381", 1024, 640, false);
                break;
            case "btn_ANSetup":
                var schTp="";
                for (var idx=0; idx< formObject.sch_tp.length; idx++) {
                	if (formObject.sch_tp[idx].checked == true) {
                		schTp=formObject.sch_tp[idx].value;
                	}
                }
                var goUrl="";
				var param="";
				var queryStr=FormQueryString(document.form);
				goUrl="/opuscntr/ESM_BKG_0672_POP.do?";
				param += "1=1";
				param += "&pgmNo=ESM_BKG_0672-01";
				param += "&autoSearchFlg=Y";
				param +="&mainPage=false";
				//param += "&" + FormQueryString(document.form);
				param += "&" + queryStr.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=");
				ComOpenWindowCenter(goUrl + param, "ESM_BKG_0672", 1024, 680, false);
                break;
            case "btn_close":
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
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source<br>
 */
	function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet<br>
 * implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function loadPage() {
    var formObj=document.form;
    for(i=0;i<sheetNames.length;i++){
    	if(sheetNames[i] == "t1sheet1" ) {
    		sheetInit(i);
    	}
    }
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
    initControl();
    initMail();
    
    //@ Test Code Start ----------	
//    	formObj.bl_no.value = "MEX400013700";
	//@ Test Code End   ----------
    
    if (parAutoSearchFlg == "Y" ) {
        if (!validateForm(sheetObjects[0],formObj,IBSEARCH)) {return; }
//        document.getElementById("btn_retrieve").fireEvent("onclick");
        doActionIBSheet(sheetObjects[0],formObj,IBSEARCH,"","");
    }
    
//    formObj.vps_eta_dt_start.value="2014-10-07";
//	formObj.vps_eta_dt_end.value="2014-10-13";
	
} 
/**
 * Sheet Initialization Function <br>
 */
function sheetInit(idx) {
	if (sheetInits[idx] == false) {
        ComConfigSheet (sheetObjects[idx] );
        initSheet(sheetObjects[idx],idx+1);
        ComEndConfigSheet(sheetObjects[idx]);
        sheetInits[idx]=true;
    }
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
    ComResizeSheet(sheetObjects[1]);
}
/**
 * setting sheet initial values and header<br>
 * param : sheetObj, sheetNo<br>
 * adding case as numbers of counting sheets<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 * @param {int}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function initSheet(sheetObj,sheetNo) {
    var sheetID=sheetObj.id;
    var cnt=0;
    switch(sheetID) {
        case "t1sheet1":
		            with(sheetObj){
		            
		          (20, 0, 0, true);
		          var HeadTitle1="| |#||||Name & Address from Code Input|Name & Address from Code Input|Customer Information on B/L|Customer Information on B/L|Suggesting Code|Suggesting Code|Suggesting Code|Code for\n A/N|Evaluation|Type|B/L No|TP|BKG_NO|val_cd_backup";
		          var HeadTitle2="| |#|||Code|Code Name|Code Address|B/L Name|B/L Address|Code|Code Name|Code Address|Code for\n A/N|Evaluation|Type|B/L No|TP|BKG_NO|val_cd_backup";
		
		          SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag",               Wrap:1 },
		                 {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"grp_img_idx",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"grp_seq_view",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"grp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"lvl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:68,   Align:"Center",  ColMerge:1,   SaveName:"mdm_cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:gGetColWidthMdmCustNm,Align:"Left",    ColMerge:1,   SaveName:"mdm_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:gGetColWidthMdmCustAddr,Align:"Left",    ColMerge:1,   SaveName:"mdm_cust_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,    Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:gGetColWidthBkgCustNm,Align:"Left",    ColMerge:1,   SaveName:"bkg_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:gGetColWidthBkgCustAddr,Align:"Left",    ColMerge:1,   SaveName:"bkg_cust_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,    Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:68,   Align:"Center",  ColMerge:1,   SaveName:"val_cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:gGetColWidthValCustNm,Align:"Left",    ColMerge:1,   SaveName:"val_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:gGetColWidthMdmCustAddr,Align:"Left",    ColMerge:1,   SaveName:"val_cust_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"cor_cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8,     Wrap:1 },
		                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"val_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cust_tp_cd_view",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,    Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,    Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_cust_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,    Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"val_cd_backup",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
		           
		          InitColumns(cols);
		          //SetSheetHeight(422);
		          SetEditable(1);
		          SetColProperty("val_cd", {ComboText:evtValue, ComboCode:evtCode} );
		          SetImageList(0,"img/btng_plus.gif");
		          SetImageList(1,"img/btng_minus.gif");
		          SetImageList(2,"img/btng_mail.gif");
		          SetWaitImageVisible(0);
		          SetColProperty("cor_cust_cd", {Format:"LL######"} );
		          SetShowButtonImage(1);
		          SetCountFormat("[ TOTALROWS Groups ]");
		          SetRowHeight(0,10);
		          SetRowHeight(1,10);
		          SetEnterBehavior("down");
		          FrozenCols=6;
		          resizeSheet();
          }


            break;
        case "t2sheet1":
            with(sheetObj){
		          var HeadTitle1="|#|bkg_no|Customer Code|Cust. Code Name|Cust. Code Address|B/L Name|B/L Address|val_cd|Evaluation|Back to the Unmatch|Type|B/L No.|bkg_cust_tp_cd|Evaluator||org_cust_cd|";
		
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"}                  
		          				//{ Text:HeadTitle2, Align:"Center"},
		                          ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",               Wrap:1 },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"mdm_cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:gT2GetColWidthValMdmCustNm,Align:"Left",    ColMerge:1,   SaveName:"mdm_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:gT2GetColWidthValMdmCustAddr,Align:"Left",    ColMerge:1,   SaveName:"mdm_cust_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:gT2GetColWidthValBkgCustNm,Align:"Left",    ColMerge:1,   SaveName:"bkg_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:gT2GetColWidthValBkgCustAddr,Align:"Left",    ColMerge:1,   SaveName:"bkg_cust_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"val_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"val_cd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Image",     Hidden:0, Width:125,  Align:"Center",  ColMerge:1,   SaveName:"val_cd_img_idx",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cust_tp_cd_view",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,    Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_cust_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"val_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"val_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dummy",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 } ];
		           
		          InitColumns(cols);
//		          SetSheetHeight(420);
		          SetEditable(1);
		          SetImageList(0,"img/btng_delete.gif");
		          SetWaitImageVisible(0);
		          SetShowButtonImage(1);
		          //SetCountFormat("[ SELECTDATAROW / TOTALROWS ]");
		          SetRowHeight(0,10);
		          SetEditEnterBehavior("down");
		          SetEnterBehavior("down");
		          resizeSheet();
          }


            break;
        case "t1excel":
            with(sheetObj){
           
          (10, 0, 0, true);
          var HeadTitle1="Seq|MDM code in B/L & the Code Details in MDM|MDM code in B/L & the Code Details in MDM|MDM code in B/L & the Code Details in MDM|Text in B/L Customer Info column|Text in B/L Customer Info column|Validation result|Validation result|Correct Code|B/L No";
          var HeadTitle2="|Code|MDM Name|MDM Address|B/L Name|B/L Addressderss|Code|Name|Correct Code|B/L No";

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle1, Align:"Center"},
                      { Text:HeadTitle2, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"grp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mdm_cust_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"mdm_cust_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"mdm_cust_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"bkg_cust_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"bkg_cust_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"val_cust_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"val_cust_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cor_cust_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
           
          InitColumns(cols);
          sheetObj.SetVisible(false);
          SetEditable(0);
          SetShowButtonImage(1);
          }


            break;
        case "t2excel":
            with(sheetObj){
            
          (8, 0, 0, true);
          var HeadTitle1="Customer Code|MDA Name|MDA Address|B/L Name|B/L Address|Evaluation|B/L No|Evaluator";

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle1, Align:"Center"}                  
          				 //{ Text:HeadTitle2, Align:"Center"},
                          ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mdm_cust_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:gGetColWidthMdmCustNm,Align:"Left",    ColMerge:1,   SaveName:"mdm_cust_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:gGetColWidthMdmCustAddr,Align:"Left",    ColMerge:1,   SaveName:"mdm_cust_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
                 {Type:"Text",      Hidden:0, Width:gGetColWidthBkgCustNm,Align:"Left",    ColMerge:1,   SaveName:"bkg_cust_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:gGetColWidthBkgCustAddr,Align:"Left",    ColMerge:1,   SaveName:"bkg_cust_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"val_cd_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"val_usr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
           
          InitColumns(cols);
          sheetObj.SetVisible(false);
          SetEditable(0);
         
                }


	        break;
    }
}
/**
 * Search Creteria Cheang Check
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {boolean}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function setInqueryDataToForm(isExcel) {
	var formObj=document.form;
	var beChanged=false;
	var vSchTp=""
	for(var i=0; i < formObj.sch_tp.length; i ++) {
		if (formObj.sch_tp[i].checked) {
			vSchTp=formObj.sch_tp[i].value;
			break;
		}
	}
	if(gSearchSchTp            != vSchTp
	   || gSearchVvd           != formObj.vvd.value
	   || gSearchVpsEtaDtStart != formObj.vps_eta_dt_start.value
	   || gSearchVpsEtaDtEnd   != formObj.vps_eta_dt_end.value
	   || gSearchPodCd         != formObj.pod_cd.value
	   || gSearchTsFlg         != (formObj.ts_flg.checked?"Y":"N")
	   || gSearchDelCd         != formObj.del_cd.value
	   || gSearchPolCd         != formObj.pol_cd.value
	   || gSearchBlNo          != formObj.bl_no.value
			  )
	{
		beChanged=true;
	}
	if (!isExcel) {
		gSearchSchTp=vSchTp;
		gSearchVvd=formObj.vvd.value;
		gSearchVpsEtaDtStart=formObj.vps_eta_dt_start.value;
		gSearchVpsEtaDtEnd=formObj.vps_eta_dt_end.value;
		gSearchPodCd=formObj.pod_cd.value;
		gSearchTsFlg=formObj.ts_flg.checked?"Y":"N";
		gSearchDelCd=formObj.del_cd.value;
		gSearchPolCd=formObj.pol_cd.value;
		gSearchBlNo=formObj.bl_no.value;
	}
	gQueryStrChange=beChanged;
}
/**
 * handling sheet process<br>
 */
function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {
    // sheetObj.ShowDebugMsg = false;
    switch(sAction) {
        case IBSEARCH:      // Retrieve
            if(validateForm(sheetObj,formObj,sAction)){
            	ComOpenWait(true);
            	if (gQueryStrChange) { 
                    fnBtnEnable(false);
                    formObj.f_cmd.value=t1s1NotAvailCmd;
                    t1s1CondParam=FormQueryString(formObj);
                    //parameter changed[check again]CLT                     
                    var sXml=sheetObjects[0].GetSearchData("ESM_BKG_1054GS.do" , t1s1CondParam.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + SEARCH01)  );
                    if (sXml == "") {
                    	ComOpenWait(false); 
                    	return;
                    }
                    var sKey=ComGetEtcData(sXml, "background_job_key");
                    var interval=5000;
                    if (formObj.sch_tp.value == "B") { 
                        interval=1000;
                    }
                    intervalId=setInterval("doActionValidationResult (sheetObjects[0], '"
                                  + t1s1CondParam
                                  + "&background_job_key=" + sKey
                                  + "');"
                                , interval);
                } else { 
                	if (beforetab == 0) { // UnMatch
                		//parameter changed[check again]CLT                     	
                	sheetObjects[0].DoSearch("ESM_BKG_1054GS.do" 
                							 ,t1s1CondParam.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + SEARCH05)+ "&mtch_chk_flg=N&page_no=1"
                                             , false) ;
                    } else { // Match
                    	pageResetM=true;
                    	//parameter changed[check again]CLT                         
                    	sheetObjects[1].DoSearch("ESM_BKG_1054GS.do"
	                                             ,t1s1CondParam.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + SEARCH06)+ "&mtch_chk_flg=Y&page_no=1"
	                                             , {Append:false, Sync:1});
                    iPageNo = 1;
                    }
                }
            }
            break;
        case IBSAVE:        // save
            if ( sheetObj.id == "t1sheet1") {
                   saveT1Sheet1(sheetObj,formObj,sAction,CondParam,PageNo);
            }
            break;
        case IBSEARCHAPPEND:
        	if ( sheetObj.id == "t1sheet1"){
            			//parameter changed[check again]CLT                 
            			sheetObj.DoSearch("ESM_BKG_1054GS.do" 
                                           ,CondParam + "&mtch_chk_flg=N"
                                           ,"page_no=" + PageNo
                                           , true
                                           );
                
            }
            else if ( sheetObj.id == "t2sheet1"){
            			//parameter changed[check again]CLT                
//            		 sheetObj.DoSearch("ESM_BKG_1054GS.do"
//                                        ,CondParam + "&mtch_chk_flg=Y"
//                                        ,"page_no=" + PageNo
//                                        ,true
//                                       );
            		 if (PageNo >= 1) {
         				formObj.f_cmd.value = SEARCH06;
         				 sheetObj.DoSearch("ESM_BKG_1054GS.do", FormQueryString(formObj)+"&mtch_chk_flg=Y"+ "&page_no=" + PageNo, {Append:true, Sync:1} );
         			
         			} else {
         				sheetObj.DoSearch("ESM_BKG_1054GS.do", FormQueryString(formObj)+"&mtch_chk_flg=Y"+ "&page_no=1" , {Append:false, Sync:1} );
         			}
            }
            break;
        case IBDOWNEXCEL:   // EXCEL down
            if (gQueryStrChange) {
                ComShowCodeMessage("BKG03053");
                return;
            }
        	var locSheetObj=null;
            ComOpenWait(true);
            fnBtnEnable(false);
            if (beforetab == 0) {
            	sheetInit(2);
    			//parameter changed[check again]CLT             	
    			sheetObjects[2].DoSearch("ESM_BKG_1054GS.do"
                                          ,t1s1CondParam.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + SEARCH05)
                                          +"&mtch_chk_flg=N"
                                          +"&excel_flg=Y"
                                          );
            }else {
            	sheetInit(3);
    			//parameter changed[check again]CLT                 
    			sheetObjects[3].DoSearch("ESM_BKG_1054GS.do"
                                          ,t1s1CondParam.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + SEARCH06)
                                          + "&mtch_chk_flg=Y"
                                          + "&excel_flg=Y"
                                         );
            }
            break;
    }
}
/**
 * DoActionIBSheet Sub Function.<br>
 */
function doActionValidationResult(sheetObj, sQueryString, sSheetType) {
    var queryString=sQueryString.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + SEARCH05);
    //parameter changed[check again]CLT     
    var sXml=sheetObjects[2].GetSearchData("ESM_BKG_1054GS.do" , queryString);
    var sJbStsFlg="";
    if (sXml == "") {
        clearInterval(intervalId);
        ComShowCodeMessage("BKG01075");
    	ComOpenWait(false);
        fnBtnEnable(true);
        return;
    }
    var txState=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
    if (txState == "F") {
    // if(!ComBkgErrMessage(sheetObjects[2], sXml)) {
        clearInterval(intervalId);
        ComShowCodeMessage("BKG01075");
        ComOpenWait(false);
        fnBtnEnable(true);
        return;
    }
    sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
    if (sJbStsFlg == "3" || sJbStsFlg == "4") {
        clearInterval(intervalId);
        sheetObjects[1].RemoveAll();
        sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
        fnBtnEnable(true);
        delCntM=0;
        currPageM=1;
        pageResetM=true;
        if (sJbStsFlg == "4") {
            ComShowCodeMessage("BKG01075");
            return;
        }
    }
    tabObjects[0].SetSelectedIndex(0);
}
/**
 * IBTab Object regist array<br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source<br>
 */
function setTabObject(tabObj){
    tabObjects[tabCnt++]=tabObj;
}
/**
 * initializing Tab<br>
 * Setting Tab items.<br>
 */
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            with (tabObj) {
                var cnt=0 ;
                InsertItem( "Unmatched" , "");
                InsertItem( "Matched" , "");
            }
            tabObj.SetSelectedIndex(0);
            break;
    }
}
/**
 * Event when clicking Tab<br>
 * activating selected tab items.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 * @param {int}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function tab1_OnChange(tabObj , nItem)
{
    var objs=document.all.item("tabLayer");
    objs[nItem].style.display="Inline";
    objs[beforetab].style.display="none";
    /*
	 * if(nItem==0 &&tabLoad[0]!=1) frameLayer0.document.location =
	 * 'tab1.jsp?frame=Tab1'; else if(nItem==1 &&tabLoad[1]!=1)
	 * frameLayer1.document.location = 'tab3.jsp?frame=Tab2';
	 */
    // --------------- important --------------------------//
    objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    // ------------------------------------------------------//
    beforetab=nItem;
    // ----------------------------------------------------
    // TAB2 Select
    // ----------------------------------------------------
    if (beforetab == 1) {
    	// Initialization를 늦춰서 tab이 변경될 때에 Initialization 한다.
    	sheetInit(1);
    }
    
    //@ 탭 변경 시 자동 리사이즈에 오류가 있어 한번 더 리사이즈를 해준다. 
    resizeSheet();
    fnBtnEnable(gButtonStatus);
}
/**
 * handling process for input validation<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 * @param {Object}
 * @param {int}
 * @return {boolean} Validation 결과값
 * @author
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction){
    var formObj=document.form;
    switch (sAction){
        case IBSEARCH:
        	if (formObj.sch_tp[0].checked == true) {
	            if (formObj.vvd.value.trim() == ""
	           	    || formObj.pod_cd.value.trim() == "") {
	           	    ComShowCodeMessage("BKG40115");
	           	    ComSetFocus(formObj.vvd);
	           	    return false;
	            }
        	}else if (formObj.sch_tp[1].checked == true) {
	            if (formObj.vps_eta_dt_start.value.trim() == ""
	            	|| formObj.vps_eta_dt_end.value.trim() == ""
	           	    || formObj.pod_cd.value.trim() == "") {
	           	    ComShowCodeMessage("BKG40116");
	           	    ComSetFocus(formObj.vps_eta_dt_start);
	           	    return false;
	            }
        	}
        	if(!ComChkValid(formObj)) return false;
            // VVD, Duration check
            if (formObj.sch_tp[2].checked == false) {
            	// maximum 7 day
                if(ComGetDaysBetween(formObj.vps_eta_dt_start.value,formObj.vps_eta_dt_end.value) > 6){
                    ComShowCodeMessage("BKG40008", "7");
                    ComSetFocus(formObj.vps_eta_dt_end);
                    return false;
                }
                if(formObj.del_cd.value.length > 2 && formObj.del_cd.value.length <5) {
                    ComShowCodeMessage("BKG40009");
                    ComSetFocus(formObj.del_cd);
                    return false;
                }
            }
            break;
        case IBSAVE:
            if (sheetObj.id == "t1sheet1") {
                if(!ComChkValid(formObj)) return false;
            } else if (sheetObj.id == "t2sheet1") {
            }
            break;
        case IBDELETE:
            if(!ComChkValid(formObj)) return false;
            break;
    }
    return true;
}
/**
 * Initialization Control.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function initControl() {
    axon_event.addListenerForm('click', 'objClick', form );     
    axon_event.addListenerForm('keyup', 'objKeyUp', form );
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm('keypress', 'objKeyPress', form);
    var formObj=document.form;
    if (parSchTp != null && parSchTp != "") {
        for ( var idx=0; idx < formObj.sch_tp.length; idx ++ ) {
            if (formObj.sch_tp[idx].value == parSchTp ){
                formObj.sch_tp[idx].checked=true;
                fnToggleSchTp(formObj.sch_tp[idx].value, formObj);
                break;
            }
        }
    }
    if (parPodCd != null && parPodCd != "") {
        formObj.pod_cd.value=parPodCd;
    } else {
        var sPodCd=ComGetCookie("esm_bkg_1054_pod_cd" + "_" + strUsr_id);
        formObj.pod_cd.value=sPodCd;
    }
    if (parPolCd != null && parPolCd != "") {
        formObj.pol_cd.value=parPolCd;
    }
    if (parVvd != null && parVvd != "") {
        formObj.vvd.value=parVvd;
        formObj.sch_tp[0].checked=true;
        fnToggleSchTp("V", formObj);  // Search type change
    }
    if (parDelCd != null && parDelCd != "") {
        formObj.del_cd.value=parDelCd;
    }
    if (parTsFlg != null && parTsFlg == "Y") { 
    	formObj.ts_flg.checked=true;
    } else {
    	formObj.ts_flg.checked=false;
    }
    if (parBlNo != null && parBlNo != "") {
        formObj.bl_no.value=parBlNo;
    }
    // calendar handling
    if (parVpsEtaDtStart != null && parVpsEtaDtEnd != null
    		&& parVpsEtaDtStart != "" && parVpsEtaDtEnd != "") {
	    formObj.vps_eta_dt_start.value=parVpsEtaDtStart;
	    formObj.vps_eta_dt_end.value=parVpsEtaDtEnd;
    } else {
	    formObj.vps_eta_dt_start.value=ComGetNowInfo('ymd','-');
	    formObj.vps_eta_dt_end.value=ComGetNowInfo('ymd','-');
    }
}
/**
 * Click Event Handling<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function objClick() {
    var objName=ComGetEvent("name");
    var formObj=document.form;
    switch(objName) {
        case "sch_tp":
            var vSchTp="";
            for (var i=0; i<formObj.sch_tp.length; i++) {
                if (formObj.sch_tp[i].checked) {
                    vSchTp=formObj.sch_tp[i].value;
                }
            }
            formObj.sch_tp.value=vSchTp;
            fnToggleSchTp(vSchTp, formObj);
            break;
        case "vvd":
        	formObj.sch_tp[0].checked=true;
        	fnToggleSchTp(formObj.sch_tp[0].value, formObj);
        	break;
        case "vps_eta_dt_start":
        	formObj.sch_tp[1].checked=true;
        	fnToggleSchTp(formObj.sch_tp[1].value, formObj);
        	break;
        case "vps_eta_dt_end":
        	formObj.sch_tp[1].checked=true;
        	fnToggleSchTp(formObj.sch_tp[1].value, formObj);
        	break;
        case "bl_no":
        	formObj.sch_tp[2].checked=true;
        	fnToggleSchTp(formObj.sch_tp[2].value, formObj);
        	break;
        case "ts_flg":
        	gQueryStrChange=true;
        	break;
    }
}
/**
 * Object Key press Event Handling<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
//function objKeyPress() {
//    var objName=event.srcElement.name;
//    var formObj=document.form;
//    switch(objName) {
//	    case "vvd":
//		    ComKeyOnlyAlphabet('uppernum');
//		    break;
//	    case "pol_cd":
//	    	ComKeyOnlyAlphabet('upper');
//		    break;
//	    case "pod_cd":
//	    	ComKeyOnlyAlphabet('upper');
//		    break;
//	    case "del_cd":
//	    	ComKeyOnlyAlphabet('upper');
//		    break;
//	    case "bl_no":
//	    	ComKeyOnlyAlphabet('uppernum');
//		    break;
//	    case "ofc_cd":
//	    	ComKeyOnlyAlphabet('upper');
//		    break;
//	    case "vps_eta_dt_start":
//	    	obj_KeyPress(event.srcElement);
//		    break;
//	    case "vps_eta_dt_end":
//	    	obj_KeyPress(event.srcElement);
//		    break;
//    }
//}
/**
 * Value setting Function.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {String}
 * @param {String}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function fnToggleSchTp (vSchTp, formObj) {
    if (vSchTp=="B") {  // BL
    	document.getElementsByName("bl_no")[0].setAttribute("required", true);
        document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
        document.getElementsByName("pod_cd")[0].removeAttribute("required");
        document.getElementsByName("vvd")[0].removeAttribute("required");
        document.getElementsByName("vvd")[0].removeAttribute("fullfill");
        document.getElementsByName("vps_eta_dt_start")[0].removeAttribute("required");
    } else if (vSchTp=="V") {
        document.getElementsByName("bl_no")[0].removeAttribute("required");
        document.getElementsByName("pod_cd")[0].setAttribute("fullfill", true);
        document.getElementsByName("pod_cd")[0].setAttribute("required", true);
        document.getElementsByName("vvd")[0].setAttribute("required", true);
        document.getElementsByName("vvd")[0].setAttribute("fullfill", true);
        document.getElementsByName("vps_eta_dt_start")[0].removeAttribute("required");
        document.getElementsByName("vps_eta_dt_end")[0].removeAttribute("required");
    }else if (vSchTp=="D") {
        document.getElementsByName("bl_no")[0].removeAttribute("required");
        document.getElementsByName("pod_cd")[0].setAttribute("fullfill", true);
        document.getElementsByName("pod_cd")[0].setAttribute("required", true);
        document.getElementsByName("vvd")[0].removeAttribute("required");
        document.getElementsByName("vvd")[0].removeAttribute("fullfill");
        document.getElementsByName("vps_eta_dt_start")[0].setAttribute("required", true);
        document.getElementsByName("vps_eta_dt_end")[0].setAttribute("required", true);
    }
}
/**
 * Mail info Initialization.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function initMail() {
    var formObj=document.form;
    formObj.strUsr_nm.value=strUsr_nm;
    formObj.strUsr_email.value=strUsr_email;
    formObj.strOfc_cd.value=strOfc_cd;
}
/** ******************************************************************************************************************************** */
/**
 * ******************************************** Tab 1 Event Handling
 * ***********************************************************
 */
/** ******************************************************************************************************************************** */
/**
 * Scroll Next Event Handling<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 * @param {String}
 * @param {String}
 * @param {String}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
//function t2sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
//	currPageM += 1;
//	alert('scroll');
//	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, t1s1CondParam.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + SEARCH06) + "&sheet_del_cnt=" + delCntM , currPageM);
//}

///**
// * event handling when horizon scrollbar touch the bottom<br>
// * @param sheetObj
// * @param CondParam
// * @param PageNo
// * @param OnePageRows
// * @return void
// */
var iPageNo = 1;
function t2sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
	if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, "", ++iPageNo);
}
/**
 * Search End Event Handling<br>
 */
function t1excel_OnSearchEnd(sheetObj, errXml) {
	sheetObj.Down2Excel();
    ComOpenWait(false);
    fnBtnEnable(true);
}
/**
 * t2excel Search End  Event Handling<br>
 */
function t2excel_OnSearchEnd(sheetObj, errXml) {
     sheetObj.Down2Excel();
     ComOpenWait(false);
     fnBtnEnable(true);
}
/**
 * Groupmail Send.<br>
 */
function fnSendGroupWareMail(sheetObj, row) {
    var formObj=document.form;
    var blNo="";
    var bkgNo="";
    var custTp="";
if (sheetObj.GetCellValue(row, "bl_no") == "" ) {
	blNo=sheetObj.GetCellValue(row + 1, "bl_no");
    	var maxRow=sheetObj.LastRow();
    	var grpNo=sheetObj.GetCellValue(row, "grp_seq");
    	for (var idx=row +1; idx <= maxRow; idx ++ ) {
if (grpNo != sheetObj.GetCellValue(idx, "grp_seq")) {
        		break;
        	}
if (sheetObj.GetCellValue(idx, "bkg_cust_tp_cd") == "C") {
	bkgNo=bkgNo + "- BKG No.: " + sheetObj.GetCellValue(idx, "bkg_no") + " [Consignee]<br/>";
        	} else {
        		bkgNo=bkgNo + "- BKG No.: " + sheetObj.GetCellValue(idx, "bkg_no") + " [Notify]<br/>";
        	}
        }
    } else {
    	blNo=sheetObj.GetCellValue(row, "bl_no");
if (sheetObj.GetCellValue(row, "bkg_cust_tp_cd") == "C") {
	bkgNo="- BKG No.: " + sheetObj.GetCellValue(row, "bkg_no") + " [Consignee]<br/>";;
    	} else {
    		bkgNo="- BKG No.: " + sheetObj.GetCellValue(row, "bkg_no") + " [Notify]<br/>";;
    	}
    }
    /* Customer Name */
	var custNm=sheetObj.GetCellValue(row, "bkg_cust_nm");
    var custNmSubj="";
    if (custNm != null && custNm != "") {
    	custNmSubj=custNm.split("\n")[0];
    }
    var custNmBody=custNm.split("\n").join("<br/>");
    /* Customer Address */
    var custAddr=sheetObj.GetCellValue(row, "bkg_cust_addr");
    var custAddrBody=custAddr.split("\n").join("<br/>");
    formObj.gw_subject.value="Customer Code Request / " + custNmSubj + " / " + blNo;;
    formObj.gw_contents.value="";
    formObj.gw_args[0].value="ofccd;" + strOfc_cd;
    formObj.gw_args[1].value="bkgno;" + bkgNo ;
	formObj.gw_args[3].value="custnm;" + custNmBody;
	formObj.gw_args[4].value="custaddr;" + custAddrBody;
    formObj.gw_args[5].value="usrnm;" + strUsr_nm ;
    return true;
}
/**
 * Customer Validation Sheet change Event Handling<br>
 */
function t1sheet1_OnChange(sheetObj, row, col) {
    var colName=sheetObj.ColSaveName(row,col);
    var val_cd=sheetObj.GetCellValue(row, "val_cd");
    var val_cor_cust_cd=sheetObj.GetCellValue(row, "cor_cust_cd");
    var eventValue=sheetObj.GetCellValue(row, col);
    switch (colName) {
        case "cor_cust_cd":
        	var tmpVal=sheetObj.GetCellValue(row, col).toUpperCase();
            var tmpRslt="";
            if (tmpVal.length > 2) {
            	tmpRslt=tmpVal.substring(0,2) + ComLpad(tmpVal.substring(2,8).trim(), 6, "0");
            }
        	sheetObj.SetCellValue(row,col,tmpRslt,0);
            sheetObj.SetDataRowHeight(row,gEvaluationRowHeight);
        	var rtnVal=fnValCdOperation(sheetObj, row, col);
            break;
    }
}
 /**
	 * ValidationCode change Event Handling<br>
	 */
 function fnValCdOperation(sheetObj, row, col) {
	 var eventValue=sheetObj.GetCellValue(row, "val_cd");
     if (eventValue == "O") {
    	 if (sheetObj.GetCellValue(row, "mdm_cust_cd").trim() == "") {
             ComShowCodeMessage("BKG40011");
             sheetObj.SetCellValue(row, "val_cd",sheetObj.GetCellValue(row, "val_cd_backup"),0);
             sheetObj.SetDataRowHeight(row,gEvaluationRowHeight);
             fnSetCopyEvaluatation(sheetObj, row);
             sheetObj.SelectCell(row, col, false);
             return false;
         }
     }
     if (eventValue == "N") {
         sheetObj.SetDataRowHeight(row,gEvaluationRowHeight);
     } else if(eventValue == "S") {
    	 sheetObj.SetCellValue(row, "val_cust_cd","",0);
    	 sheetObj.SetDataRowHeight(row,gEvaluationRowHeight);
  	 } else if(eventValue == "-" || eventValue == "") {  
    	 sheetObj.SetCellValue(row, "val_cd","",0);
    	 sheetObj.SetRowStatus(row,"R");
    	 sheetObj.SetDataRowHeight(row,gEvaluationRowHeight);
     } else {
         sheetObj.SetDataRowHeight(row,gEvaluationRowHeight);
     }
     fnSetCopyEvaluatation(sheetObj, row);
     return true;
 }
/**
 * ComboBox Chane Event Handling<br>
 */
function t1sheet1_OnComboChange(sheetObj, row, Col, Code, Text) {
	var rtnVal=fnValCdOperation(sheetObj, row, Col);
    if (rtnVal) {
    	sheetObj.SetCellValue(row, "val_cd_backup",sheetObj.GetCellValue(row, "val_cd"),0);
    }
}
/**
 * Customer Validation Sheet Click  Event Handling<br>
 */
function t1sheet1_OnClick(sheetObj, row, col) {
    var colName=sheetObj.ColSaveName(col);
    var dtValue=sheetObj.GetCellValue(row,col);
    switch(colName) {
        case "grp_img_idx":
        	//conversion of function[check again]CLT         	
        	var cellImage =sheetObj.GetCellImage(row, col);
        	if ( !ComIsNull(cellImage)) {
        		var maxrow=sheetObj.LastRow();
        		for (var i=row + 1; i < maxrow; i ++) {
        			if (sheetObj.GetCellValue(row, "grp_seq").parseInt() == sheetObj.GetCellValue(i, "grp_seq").parseInt()) {
        				if (cellImage.indexOf("plus") >= 0) {
        					sheetObj.SetRowHidden(i,0);
        				} else {
        					sheetObj.SetRowHidden(i,1);
        				}
        			} else {
        				break;
        			}
        		}
        		if (cellImage.indexOf("plus") >= 0) {
        			//conversion of function[check again]CLT         			
        			sheetObj.SetCellImage(row, col,1);
        		} else {
        			//conversion of function[check again]CLT         			
        			sheetObj.SetCellImage(row, col,0);
        		} 
        	}
        	break;
        case "val_cust_nm":
        	gEvaluationRowHeight=sheetObj.GetRowHeight(row);
            break;
        case "val_cd":
        	gEvaluationRowHeight=sheetObj.GetRowHeight(row);
            break;
        case "val_cust_nm":
        	gEvaluationRowHeight=sheetObj.GetRowHeight(row);        	
            break;
        case "cor_cust_cd":
        	gEvaluationRowHeight=sheetObj.GetRowHeight(row);
            break;
        default:
        	gEvaluationRowHeight=sheetObj.GetRowHeight(row);
            break;
    }
}
/**
 * Popup Click  Event Handling.<br>
 */
function t1sheet1_OnPopupClick(sheetObj, row, col){
    var colName=sheetObj.ColSaveName(col);
    switch(colName) {
        case "cor_cust_cd":
        	gEvaluationRowHeight=sheetObj.GetRowHeight(row);
        	var cCustCd=sheetObj.GetCellValue(row, "cor_cust_cd").trim();
        	var cCustNm=sheetObj.GetCellValue(row, "bkg_cust_nm").substring(0,7);
            popupRow=row;
            ComOpenPopup("/opuscntr/COM_ENS_041.do?cust_cd="+strCntCd + "&cust_nm=" + cCustNm, 770, 440, "callBackComEns041", '1,0,1,1,1,1,1', true);
            break;
    }
}
/**
 * Popup Ok Event Handling.<br>
 */
function callBackComEns041(rArray){
    var sheetObj=sheetObjects[0];
    if(rArray != null){
        var colArray=rArray[0];
        sheetObj.SetCellValue(popupRow, "cor_cust_cd",colArray[3].substring(0,2) + ComLpad(colArray[3].substring(2),6,"0"));
    }
 }
/**
 * t1sheet1 Dbl Click  Event Handling
 */
function  t1sheet1_OnDblClick(sheetObj, row, col) {
    var colName=sheetObj.ColSaveName(col);
    var dtValue=sheetObj.GetCellValue(row,col);
    // gLastEventIsValCdEnter = true;
    switch(colName) {
        case "mdm_cust_cd":
        	if (sheetObj.GetCellValue(row, "lvl_cd").parseInt() == 1
                 && dtValue != "") {
        		if (sheetObj.GetCellValue(row, "val_cd") != "N"
        			&& sheetObj.GetCellValue(row, "val_cd") != "O"
        				&& sheetObj.GetCellValue(row, "val_cd") != "S" ) {
                	var rowHeight=sheetObj.GetRowHeight(row);
                	sheetObj.SetCellValue(row, "cor_cust_cd",dtValue,0);
                	sheetObj.SetDataRowHeight(row,rowHeight);
                	var rtnVal=fnValCdOperation(sheetObj, row, col);
                    if (rtnVal) {
                    	sheetObj.SetCellValue(row, "val_cd_backup",sheetObj.GetCellValue(row, "val_cd"),0);
                    }
                }
            }
            break;
        case "val_cust_cd":
        	if (sheetObj.GetCellValue(row, "lvl_cd").parseInt() == 1
                    && dtValue != "") {
        		if (sheetObj.GetCellValue(row, "val_cd") != "N"
        			&& sheetObj.GetCellValue(row, "val_cd") != "O"
        				&& sheetObj.GetCellValue(row, "val_cd") != "S") {
                	var rowHeight=sheetObj.GetRowHeight(row);
                	sheetObj.SetCellValue(row, "cor_cust_cd",dtValue,0);
                	var rtnVal=fnValCdOperation(sheetObj, row, col);
                	sheetObj.SetDataRowHeight(row,rowHeight);
                    if (rtnVal) {
                    	sheetObj.SetCellValue(row, "val_cd_backup",sheetObj.GetCellValue(row, "val_cd"),0);
                    }
                }
            }
            break;
        case "mdm_cust_nm":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gGetRowHeight,  gGetColWidthMdmCustNm);
            }
            break;
        case "mdm_cust_addr":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gGetRowHeight,  gGetColWidthMdmCustAddr);
            }
            break;
        case "bkg_cust_nm":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gGetRowHeight,  gGetColWidthBkgCustNm);
            }
            break;
        case "bkg_cust_addr":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gGetRowHeight,  gGetColWidthBkgCustAddr);
            }
            break;
        case "val_cust_nm":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gGetRowHeight,  gGetColWidthValCustNm);
            }
            break;
        case "val_cust_addr":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gGetRowHeight,  gGetColWidthValCustNm);
            }
            break;
        case "bl_no":
        	if (sheetObj.GetCellValue(row, "bkg_no").trim() == "") { return; }
        	var bkgNo=sheetObj.GetCellValue(row, "bkg_no");
        	var sUrl="";
        	sUrl += "?parentPgmNo=ESM_BKG_M001";
        	sUrl += "&pgmUrl=^opuscntr^ESM_BKG_0079.do";
        	sUrl += "&pgmNo=ESM_BKG_0079";
        	sUrl += "&bkg_no="+bkgNo;
        	sUrl += "&openTab=B5";
        	
        	ComOpenWindowCenter("ESM_BKG_0079_POP.do" + sUrl, "BKGMain", 1250, 850,false,'yes');
        	
        	break; 
    }
} 
/**
 * t2sheet1 Dbl Click  Event Handling
 */
function  t2sheet1_OnDblClick(sheetObj, row, col) {
    var colName=sheetObj.ColSaveName(col);
    var dtValue=sheetObj.GetCellValue(row,col);
    switch(colName) {
        case "mdm_cust_nm":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gGetRowHeight,  gT2GetColWidthValMdmCustNm);
            }
            break;
        case "mdm_cust_addr":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gGetRowHeight,  gT2GetColWidthValMdmCustAddr);
            }
            break;
        case "bkg_cust_nm":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gGetRowHeight,  gT2GetColWidthValBkgCustNm);
            }
            break;
        case "bkg_cust_addr":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gGetRowHeight,  gT2GetColWidthValBkgCustAddr);
            }
            break;
        case "bl_no":
        	var bkgNo=sheetObj.GetCellValue(row, "bkg_no");
        	var sUrl = "/opuscntr/ESM_BKG_0079_Q_POP.do?";
        	sUrl += "&bkg_no="+bkgNo;
        	sUrl += "&openTab=B5"; 
			//var winObj=window.open(sUrl,"bl no");
			ComOpenWindowCenter(sUrl, 'bl_no', 1100, 670, false);
        	break;
    }
}
/**
 * Unmatch Case Sheet Click Event Handling<br>
 */
function fnToggleCellSize(sheetObj, row, col, defGetRowHeight, defGetColWidth) {
    var colName=sheetObj.ColSaveName(col);
    if (sheetObj.GetRowHeight(row) == defGetRowHeight&& sheetObj.GetColWidth(col) == defGetColWidth) {
        sheetObj.SetDataRowHeight(row,0);
        sheetObj.SetColWidth(col,defGetColWidth);
    } else {
        sheetObj.SetDataRowHeight(row,defGetRowHeight);
        sheetObj.SetColWidth(col,defGetColWidth);
    }
}
/**
 * Match Case Sheet Click Event Handling<br>
 */
function t2sheet1_OnClick(sheetObj, row, col) {
    var colName=sheetObj.ColSaveName(col);
    var dtValue=sheetObj.GetCellValue(row ,col);
    switch(colName) {
        case "val_usr_nm":
        	var valUsrNm=sheetObj.GetCellValue(row, "val_usr_nm");
        	if (valUsrNm.trim() != "") {
        		ComUserPopup(sheetObj.GetCellValue(row, "val_usr_id"));
        	}
        	break;
        case "val_cd_img_idx":
            if (dtValue != "") {
            	if (!ComShowCodeConfirm("COM12165" , sheetObj.GetCellValue(row, "mdm_cust_cd"))) {return ;}
                sheetObj.SetCellValue(row, "val_cd","");
                sheetObj.SetRowStatus(row,"D");
                var saveString=sheetObj.GetSaveString(false);
                if (saveString == "") return;
                var queryString=t1s1CondParam.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + MODIFY02);              
                sXml=sheetObj.GetSaveData("ESM_BKG_1054GS.do", queryString + "&" + saveString);
                var txState=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
                if (txState == "F") {
                	ComBkgErrMessage(sheetObj, sXml);
                	return;
                } else {                   
                	sheetObj.LoadSaveData(sXml);
                    delCntM += 1;
                    ComShowCodeMessage("BKG00102");
                }
            }
            break;
    }
}
/**
 * Unmatch case sheet Search End Event Handling<br>
 */
function saveT1Sheet1(sheetObj,formObj,sAction,CondParam,PageNo) {
//	var sheetObj = sheetObjects[0];
    var saveString=sheetObj.GetSaveString(false);
    if (saveString == "") {
        ComShowCodeMessage("COM12189");
        return;
    }
    var isSaveConfirm=false;
    var queryString=t1s1CondParam.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + MODIFY01);
    var statusRow=sheetObj.FindStatusRow("U");
    var statusArray=statusRow.split(";");
    var valCd="";
    for (var idx=0; idx < statusArray.length; idx ++) {
    	valCd=sheetObj.GetCellValue(statusArray[idx], "val_cd").trim();
        if (valCd == "" || valCd == "-") {
            ComShowCodeMessage("BKG03052");
            sheetObj.SelectCell(statusArray[idx], "val_cd", false);
            return;
        } else if (valCd != "S" && valCd != "N") {
        	if(sheetObj.GetCellValue(statusArray[idx], "cor_cust_cd").trim() == "") {
                ComShowCodeMessage("BKG03052");
                sheetObj.SelectCell(statusArray[idx], "cor_cust_cd", false);
                return;
            }
        }
    }
    var delGrpCnt=0;
    for (var idx=0; idx < statusArray.length; idx ++) {
    	sheetObj.SetRowStatus(statusArray[idx],"D");
    	if (sheetObj.GetCellValue(statusArray[idx], "grp_seq_view").trim() != "") {
    		delGrpCnt=delGrpCnt + 1; 
    	}
    }    
    var sXml=sheetObj.GetSaveData("ESM_BKG_1054GS.do", queryString + "&" + saveString);
    var txState=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
   
    if (txState == "F") {
    	ComBkgErrMessage(sheetObj, sXml);
    	return;
    } else {
    	//parameter changed[check again]CLT 	    
    	sheetObj.LoadSaveData(sXml, {Sync:1});
	    unMatchGrpCntU=unMatchGrpCntU - delGrpCnt;
	    sheetObj.SetTotalRows(unMatchGrpCntU);
		ComShowCodeMessage("BKG00102");
    }
}
/**
 * t1sheet1 Search End Event Handling
 */
function t1sheet1_OnSearchEnd(sheetObj, errStr) {
    var startRow=2;
    var maxRow=sheetObj.LastRow();
    sheetObj.SetDataRowHeight(1,10);
    if (sheetObj.RowCount()== 0) {
    	unMatchGrpCntU=0;
    	sheetObj.SetTotalRows(unMatchGrpCntU);
    	ComOpenWait(false);
    	;return;
    }
    for (var idx=2; idx<= maxRow; idx ++ ) {
      sheetObj.SetDataRowHeight(idx,10);
if (sheetObj.GetCellValue(idx, "lvl_cd").parseInt() == 2) {
    	  sheetObj.SetRowEditable(idx,0);
    	  sheetObj.SetRowHidden(idx,1);
      } else {
          fnt1sheet1GetCellBackColor(sheetObj, idx, false);
          //parameter changed[check again]CLT          
          fnt1sheet1GetCellFont(sheetObj, idx);
          with (sheetObj) {
        	  //parameter changed[check again]CLT               
        	  SetCellFont("FontBold", idx,"val_cust_cd",1);
        	  //parameter changed[check again]CLT               
        	  SetCellFont("FontBold", idx,"mdm_cust_cd",1);
        	  //parameter changed[check again]CLT               
        	  SetCellFont("FontBold", idx,"cor_cust_cd",1);
          }
      }
	//parameter changed[check again]CLT       
		sheetObj.SetCellFontUnderline(idx,"bl_no",1);
    }
    unMatchGrpCntU=sheetObj.GetCellValue(maxRow, "grp_seq").parseInt();
    sheetObj.SetTotalRows(unMatchGrpCntU);
    ComOpenWait(false);
}
/**
 * t2sheet1 Search End Event Handling<br>
 */
function t2sheet1_OnSearchEnd(sheetObj, errStr) {
    var startRow=1;
    var maxRow=sheetObj.LastRow();
    if (pageResetM) {
		delCntM=0;
	    currPageM=1;
	    pageResetM=false;
    }
    sheetObj.SetDataRowHeight(0,10);
//    if (maxRow < 100) {
//        startRow=1;
//    } else if ((maxRow%100.0) == 0 ) {
//        startRow=maxRow - 100 ;
//        if (startRow < 1) {
//            startRow=1;
//        }
//    } else {
//        startRow=maxRow - ((maxRow - 1.0)%100.0);
//    }
    for (var i=1; i< startRow; i ++ ) {
        sheetObj.SetDataRowHeight(i,10);
    }
    if (startRow - delCntM >= 1) {
    	startRow -= delCntM;
    }
    for (var idx=startRow; idx <= maxRow; idx ++) {
    	if (sheetObj.GetCellValue(idx, "val_cd") != "A" && sheetObj.GetCellValue(idx, "val_cd") != "C") {
    		//parameter changed[check again]CLT             
		sheetObj.SetCellFont("FontBold", idx,"bkg_no", idx, "bl_no",1);
        }
    	
    	if (sheetObj.GetCellValue(idx, "val_cd_img_idx") == -1) {
            fnT2sheet1GetCellBackColor(sheetObj, idx, false);
            sheetObj.SetCellEditable(idx, "val_cd_img_idx",0);
        } else {
            fnT2sheet1GetCellBackColor(sheetObj, idx, true);
            sheetObj.SetCellEditable(idx, "val_cd_img_idx",1);
        }
    	
    	//parameter changed[check again]CLT        
    	sheetObj.SetCellFontUnderline(idx,"bl_no",1);
        sheetObj.SetDataRowHeight(idx,10);
    }
    ComOpenWait(false);
}
/**
 * t1sheet1 OnKeyUp Event Handling
 */
	function t1sheet1_OnKeyUp (sheetObj, row, col, keyCode, shift) {
     var colName=sheetObj.ColSaveName(col);
    gKeyCode=keyCode;
    switch(colName) {
    case "val_cd":
        if (keyCode == 9) {
        	gEvaluationRowHeight=sheetObj.GetRowHeight(row);
        } else if (keyCode == 27 || keyCode == 87 || keyCode == 77 || keyCode == 79 || keyCode == 78 || keyCode == 83) { // '
																															// '(space):27
																															// W:87
																															// M:77
																															// O:79
																															// N:78
																															// S:83
            sheetObj.SelectCell(row, col, false);
            var currValCd=sheetObj.GetCellValue(row, "val_cd_backup");
            var rtnVal=fnValCdOperation(sheetObj, row , col);
            sheetObj.SetCellValue(row, "val_cd_backup",sheetObj.GetCellValue(row, "val_cd"),0);
            sheetObj.SetDataRowHeight(row,gEvaluationRowHeight);
        }
        else if (keyCode >= 37 && keyCode <= 40) {
        	gEvaluationRowHeight=sheetObj.GetRowHeight(row);
        } else {
            sheetObj.SelectCell(row, col, false);
            sheetObj.SetDataRowHeight(row,gEvaluationRowHeight);
        }
        break;
    }
}
 /**
	 * Cell according to the user's operation to process the value of the change and propagate, Cell Font, and set.<br>
	 */
function fnSetCopyEvaluatation(sheetObj, row) {
    var vMax=sheetObj.LastRow();
    var vCorCustCd=sheetObj.GetCellValue(row, "cor_cust_cd");
	var vGrpSeq=sheetObj.GetCellValue(row, "grp_seq");
	var vValCd=sheetObj.GetCellValue(row, "val_cd");
	var vRowHeight=0;
    for(var idx=row; idx <= vMax; idx ++) {
    	if (vGrpSeq != sheetObj.GetCellValue(idx, "grp_seq")) {
    		break;
    	}
    	vRowHeight=sheetObj.GetRowHeight(idx);
        sheetObj.SetCellValue(idx, "val_cd",vValCd,0);
        if (idx == row) {
        	/* Background Color Handling */
        	if (vValCd == "" || vValCd == "-") {
        		fnt1sheet1GetCellBackColor(sheetObj, idx, false);
        	} else {
        		fnt1sheet1GetCellBackColor(sheetObj, idx, true);
        	}
        	/* GetEditable()Handling */
        	if (vValCd == "N") {
        	    sheetObj.SetCellEditable(idx,"cor_cust_cd",0);
        	} else if(vValCd == "O" || vValCd == "S") {
        	    sheetObj.SetCellEditable(idx,"cor_cust_cd",0);
        	} else {
        		sheetObj.SetCellEditable(idx,"cor_cust_cd",1);
        	}
        	/* Font Handling */
        	//parameter changed[check again]CLT             
        	fnt1sheet1GetCellFont(sheetObj, idx);
        }
        if (vValCd == "O" || vValCd == "S") { // OK, SKIP
        	var newCval = sheetObj.GetCellValue(idx, "mdm_cust_cd");
        	sheetObj.SetCellValue(idx, "cor_cust_cd",newCval,0);
    	} else if (vValCd == "N") { // Not-Existence
    		sheetObj.SetCellValue(idx, "cor_cust_cd","",0);// Initialization
        } else {
        	sheetObj.SetCellValue(idx, "cor_cust_cd",vCorCustCd,0);// Evaluation한
																	// 값
        }
        if ((vValCd == "-" || vValCd == "" ) && vCorCustCd.trim() == "") {
        	sheetObj.SetRowStatus(idx,"R");
        }
        sheetObj.SetDataRowHeight(idx,vRowHeight);
    }
}
/**
 * Button Handling <br>
 */
function fnBtnEnable( flag) {
    if (flag == true) {
        ComBtnEnable("btn_retrieve");
        ComBtnEnable("btn_excel");
        if (beforetab == 0) {
            ComBtnEnable("btn_save");
        } else {
            ComBtnDisable("btn_save");
        }
        ComBtnEnable("btn_ANSend");
        ComBtnEnable("btn_ANSetup");
    } else {
        ComBtnDisable("btn_retrieve");
        ComBtnDisable("btn_excel");
        ComBtnDisable("btn_save");
        ComBtnDisable("btn_ANSend");
        ComBtnDisable("btn_ANSetup");
    }
    gButtonStatus=flag;
}
/**
 * set background color of row in t1sheet .<br>
 */
function fnt1sheet1GetCellBackColor(sheetObj, row, bSelect) {
    with(sheetObj) {
        if (bSelect == false) {
        	SetCellBackColor(row, "grp_img_idx",gColorReadOnly);
        	SetCellBackColor(row, "grp_seq_view",gColorReadOnly);
        	SetCellBackColor(row, "mdm_cust_cd",gColorMdmCust);
            SetCellBackColor(row, "mdm_cust_nm",gColorMdmCust);
            SetCellBackColor(row, "mdm_cust_addr",gColorMdmCust);
            SetCellBackColor(row, "bkg_cust_nm",gColorBkgCust);
            SetCellBackColor(row, "bkg_cust_addr",gColorBkgCust);
            SetCellBackColor(row, "val_cust_cd",gColorValCust);
            SetCellBackColor(row, "val_cust_nm",gColorValCust);
            SetCellBackColor(row, "val_cust_addr",gColorValCust);
            SetCellBackColor(row, "cor_cust_cd",gColorEditable);
            SetCellBackColor(row, "val_cd",gColorEditable);
//            CellBackColor(row, "mail_img_idx") = gColorReadOnly;
            SetCellBackColor(row, "bkg_cust_tp_cd_view",gColorReadOnly);
            SetCellBackColor(row, "bl_no",gColorReadOnly);
        } else {
            SetRowBackColor(row,gColorDisabled);
        }
    }
}
/**
 * set background color of row in t2sheet.<br>
 */
function fnT2sheet1GetCellBackColor(sheetObj, row, bSelect) {
    with(sheetObj) {
        // CellBackColor(row, "mdm_cust_cd") = gColorDisabled;
        SetCellBackColor(row, "mdm_cust_nm",gColorBkgCust);
        SetCellBackColor(row, "mdm_cust_addr",gColorBkgCust);
        SetCellBackColor(row, "bkg_cust_nm",gColorValCust);
        SetCellBackColor(row, "bkg_cust_addr",gColorValCust);
        SetCellBackColor(row, "val_cd_nm",gColorBkgCust);
        if (bSelect == false) {
            SetCellBackColor(row, "val_cd_img_idx",gColorReadOnly);
        } else {
            SetCellBackColor(row, "val_cd_img_idx",gColorEditable);
        }
    }
}
/**
 * Font / Under barHandling.<br>
 */
	//parameter changed[check again]CLT 
function fnt1sheet1GetCellFont(sheetObj, row) {
    with (sheetObj) {
    	var vValCustCd=GetCellValue(row,"val_cust_cd");
    	var vCorCustCd=GetCellValue(row,"cor_cust_cd");
    	var vMdmCustCd=GetCellValue(row,"mdm_cust_cd");
    	var vValCd=GetCellValue(row, "val_cd");
        if (vValCustCd != "" && vValCustCd != vCorCustCd) {
        	//parameter changed[check again]CLT             
        	SetCellFont("FontColor", row,"val_cust_cd",gFontColorBlack);
        	//parameter changed[check again]CLT             
        	SetCellFontUnderline(row,"val_cust_cd",1);
        } else {
        	//parameter changed[check again]CLT             
        	SetCellFont("FontColor", row,"val_cust_cd",gFontColorBlue);
        	//parameter changed[check again]CLT             
        	SetCellFontUnderline(row,"val_cust_cd",0);
        }
        if (vMdmCustCd != "" && vMdmCustCd != vCorCustCd) {
        	//parameter changed[check again]CLT             
        	SetCellFont("FontColor", row,"mdm_cust_cd",gFontColorBlack);
        	//parameter changed[check again]CLT             
        	SetCellFontUnderline(row,"mdm_cust_cd",1);
        } else {
        	//parameter changed[check again]CLT             
        	SetCellFont("FontColor", row,"mdm_cust_cd",gFontColorBlue);
        	//parameter changed[check again]CLT             
        	SetCellFontUnderline(row,"mdm_cust_cd",0);
        }
        if (vCorCustCd != vValCustCd && vCorCustCd != vMdmCustCd) {
        	//parameter changed[check again]CLT             
        	SetCellFont("FontColor", row,"cor_cust_cd",gFontColorBlue);
        } else {
        	//parameter changed[check again]CLT             
        	SetCellFont("FontColor", row,"cor_cust_cd",gFontColorBlack);
        }
        if (vValCd == "N" || vValCd == "O" || vValCd == "S") {
        	//parameter changed[check again]CLT             
        	SetCellFontUnderline(row,"mdm_cust_cd",0);
        	//parameter changed[check again]CLT             
        	SetCellFontUnderline(row,"val_cust_cd",0);
        }
    }
}
    /* Developer Work End */
