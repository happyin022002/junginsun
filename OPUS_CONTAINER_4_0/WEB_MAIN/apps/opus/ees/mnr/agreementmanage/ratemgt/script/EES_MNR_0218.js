/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0218.js
*@FileTitle  : M&R AGREEMENT DETAIL Pop_Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/

// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var tempSheetObjects=new Array();
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// whether retrieving
var nowRetriveSt=false;
var retPossible=false;
//list containing tab menu
var uTab=new Array();
var gTab=new Array();
var zTab=new Array();
var lbHeader=new Array();
var uTpSz=new Array();
var gTpSz=new Array();
var zTpSz=new Array();
// version default
var defVerCode="1";
//trsm_mod_cd default
var defTrsmCode="";
//whether initializing
var loadIbclear=false;
var tempEqKndCd="U";
//for previous trf_no
var priTrfNo="";
var formObj=document.form;
// Event handler processing by button click event */
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
		/*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_retrieve":
					if(retPossible){
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					}
					break;
				case "btn_new":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		var formObj=document.form;
		MnrWaitControl(true);
		initControl();
		setPageInit();
		//formal initSheet
		initSheet(sheetObjects[0],"sheet1",'','');
//		ComConfigSheet(sheetObjects[1]);
		initSheet(sheetObjects[1],"sheet2",'','');
//		ComEndConfigSheet(sheetObjects[1]);
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k + 1);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		formObj.agmt_no.value=formObj.strAgmt_no.value;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
		tabObjects[0].SetSelectedIndex(0);
    }
	/**
	 * setting combo basic info
	 * @param	{IBMultiCombo}	combo_obj	ComboObject.
	 * @param	{Number}	comboNo		ComboObject tag serial number
	 * adding case as numbers of counting combos
	 */
	function initCombo (comboObj, comboNo) {
	    //var cnt  = 0 ;
	    var formObject=document.form
	    switch(comboNo) {
			   case 1:
		           with (comboObj) {
				   	   SetTitle("Ver|Creation Date");
				   	   SetColAlign(0, "left");
				   	   SetColAlign(1, "left");
				   	   SetColWidth(0, "50");
				   	   SetColWidth(1, "170");
					   SetDropHeight(160);
			       }
	           break;
			   case 2:
		           with (comboObj) {
				   	   SetTitle("Code|Desc");
				   	   SetColAlign(0, "left");
				   	   SetColAlign(1, "left");
				   	   SetColWidth(0, "50");
				   	   SetColWidth(1, "170");
					   SetDropHeight(160);
			       }
	           break;
			   case 4:
		           with (comboObj) {
				   	      	SetTitle("Tariff No|Tariff Type|Service Provider|EQ Type|Status|Eff.From|Unit|Currency");
				   	      	SetColAlign(0, "left");
							SetColAlign(1, "left");
							SetColAlign(2, "left");
							SetColAlign(3, "left");
							SetColAlign(4, "left");
							SetColAlign(5, "center");
							SetColAlign(6, "left");
							SetColAlign(7, "left");
							SetColWidth(0, "140");
							SetColWidth(1, "80");
							SetColWidth(2, "180");
							SetColWidth(3, "80");
							SetColWidth(4, "100");
							SetColWidth(5, "80");
							SetColWidth(6, "80");
							SetColWidth(7, "80");
			   			  SetDropHeight(160);
			       }
	           break;
			   default :
		           with (comboObj) {
				       //SetColAlign("left");
					   //DropHeight = 160;
			       }
	           break;
	     }
	}
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetType,eq_type,display_type) {
        var cnt=0;
        switch(sheetType) {
			case "sheet1":
                with (sheetObj) {
                    SetVisible(false);
				}
            case "sheet2":      //t1sheet1 init
                with(sheetObj){
		             var HeadTitle1="|Sel|Cost CTRL\nOffice|Transmission\nMode|EDI ID|Web ID|Tel No|Fax No|E-mail|Remark";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_check",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"aply_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"trsm_mod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"edi_id",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"sp_ptal_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"phn_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"fax_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mnr_prnr_eml",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ctrl_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_grp_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_knd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pay_term_dys",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mnr_prnr_locl_lang_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"mnr_prnr_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             InitColumns(cols);
		             SetEditable(0);
		             SetWaitImageVisible(0);
		             SetColProperty(0 ,"aply_ofc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		             SetColProperty(0 ,"edi_id" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		             SetColProperty(0 ,"sp_ptal_id" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		             SetColProperty(0 ,"phn_no", {AcceptKeys:"E|N|[.-/,() &]"});
		             SetColProperty(0 ,"fax_no", {AcceptKeys:"E|N|[.-/,() &]"});
		             SetColProperty(0 ,"mnr_prnr_eml", {AcceptKeys:"E|N|[.-/,() &]"});
		             SetShowButtonImage(2);
		             //no support[check again]CLT 					MultiSelection=false;
		             SetSelectionMode(smSelectionRow);
		             SetSheetHeight(226);
             		}
                break;
                
            case "LB":      //lb
                with(sheetObj){
	            	var HeadTitle="|Sel|Seq.|Detail Type|Rate Type|Yard Code|UDU|Amount";
	            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	InitHeaders(headers, info);
	            	var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	            	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	            	             {Type:"Combo",     Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"cost_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Combo",     Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"cost_dtl_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:"yd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:7 },
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"usr_def_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:500 },
	            	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"agmt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	     			var sCondition=new Array (new Array("MnrGenCd",eq_type + "G" + display_type+ "_AGMT", "CUSTOM5"),
		            		  new Array("MnrGenCd","MRDRRC"+ "_AGMT", "COMMON"))
	     			var comboList=MnrComSearchCombo(sheetObj,sCondition);
	     			var sheetComboText="";
	     			var sheetComboCode="";
	     			var sheetComboDefault="";
	     			var comboSaveNames=new Array();
	     			comboSaveNames[0]="cost_cd";
	     			comboSaveNames[1]="cost_dtl_cd";
	     			for(var i=0; i < comboList.length;i++){
	     				if(comboList[i] != null){
	     					sheetComboText="";
	     					sheetComboCode="";
	     					sheetComboCodeText="";
	     					sheetComboDefault="";
	     					for(var j=0; j < comboList[i].length;j++){
	     						var tempText=comboList[i][j].split("|");
	     						sheetComboText +=  tempText[1] + "|";
	     						sheetComboCode +=  tempText[0] + "|";
	     						sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
	     						if(j ==0){
	     							sheetComboDefault=tempText[0];
	     						}
	     					}
	     					sheetComboText=MnrDelLastDelim(sheetComboText);
	     					sheetComboCode=MnrDelLastDelim(sheetComboCode);
	     					InitColumns(cols);
	     					SetColProperty(0,comboSaveNames[i], {ComboText:sheetComboText, ComboCode:sheetComboCode} );
	     				}
	     			}
					SetSelectionMode(smSelectionFree);
					SetSheetHeight(240);
					SetEditable(0);
					}
                break;
			case "TS":      //ts
			    with(sheetObj){
					var disPlayTpSz=new Array();
					var HeadTitleTemp="";
					if(eq_type == 'U'){
						disPlayTpSz=uTpSz;
					} else if(eq_type == 'G'){
			    	  disPlayTpSz=gTpSz;
					} else if(eq_type == 'Z'){
						disPlayTpSz=zTpSz;
					}
					var HeadTitle="|Sel|Seq.|Detail Type|TP/SZ|Yard Code|UDU|Amount";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cost_dtl_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Popup",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mnr_rt_tp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:"yd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:7 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"usr_def_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:500 },
			             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"agmt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		      		var sCondition=new Array (new Array("MnrGenCd",eq_type + "G" + display_type+ "_AGMT", "CUSTOM4"))
		      		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		      		var lbComboText="";
		      		var lbComboCode="";
		      		var lbComboDefault="";
		      		if(comboList[0] != null){
		      			for(var j=0; j < comboList[0].length;j++){
		      				var tempText=comboList[0][j].split("|");
		      				lbComboText +=  tempText[1] + "|";
		      				lbComboCode +=  tempText[0] + "|";
		      				if(j == 0){
		      					lbComboDefault=tempText[0];
		      				}
		      			}
    	         	}
		      		InitColumns(cols);
		      		SetColProperty(0,"cost_dtl_cd", {ComboText:lbComboText, ComboCode:lbComboCode} );
					SetShowButtonImage(2);
					SetSelectionMode(smSelectionFree);
					SetSheetHeight(240);
					SetEditable(0);
					}
                break;
			case "QT":      //qt
			    with(sheetObj){
				var HeadTitle1="|Sel|Seq.|Detail Type|Q'ty|Yard Code|UDU|Amount";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cost_dtl_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rpr_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:"yd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:7 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"usr_def_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:500 },
		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"agmt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
              	var sCondition=new Array (new Array("MnrGenCd",eq_type + "G" + display_type+ "_AGMT", "CUSTOM4"))
              	var comboList=MnrComSearchCombo(sheetObj,sCondition);
              	var lbComboText="";
              	var lbComboCode="";
              	var lbComboDefault="";
              	if(comboList[0] != null){
              		for(var j=0; j < comboList[0].length;j++){
              			var tempText=comboList[0][j].split("|");
              			lbComboText +=  tempText[1] + "|";
              			lbComboCode +=  tempText[0] + "|";
              			if(j == 0){
              				lbComboDefault=tempText[0];
              			}
              		}
              	}
              	InitColumns(cols);
              	SetColProperty(0,"cost_dtl_cd", {ComboText:lbComboText, ComboCode:lbComboCode} );
				SetSelectionMode(smSelectionFree);
				SetSheetHeight(240);
				SetEditable(0);
				}
            break;
        }
    }
    /**
     * initializing Tab
     * setting Tab items.
     */
    function initTab(tabObj ,disPlayArray ) {
		 with(tabObj){
		 	 RemoveAll();
			 var cnt=0 ;
			 for(var j=0; j < disPlayArray.length;j++){
				 InsertItem( disPlayArray[j][6] , "");
		   	 }
		 }
    }
	function initControl() {
	    //Axon handling event1. event catch
		var formObject=document.form;
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject,	'agmt_no');             
	    // axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); 
	}
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       tempSheetObjects[sheetCnt++]=sheet_obj;
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
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject.
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
	function setPageInit(){
		//change sheet order
		for(var i=0;i < tempSheetObjects.length ;i++){
			if(tempSheetObjects[i].id == "sheet1"){
				sheetObjects[0]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "sheet2"){
				sheetObjects[1]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t1sheet1"){
				sheetObjects[2]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t2sheet1"){
				sheetObjects[3]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t3sheet1"){
				sheetObjects[4]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t4sheet1"){
				sheetObjects[5]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t5sheet1"){
				sheetObjects[6]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t6sheet1"){
				sheetObjects[7]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t7sheet1"){
				sheetObjects[8]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t8sheet1"){
				sheetObjects[9]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t9sheet1"){
				sheetObjects[10]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t10sheet1"){
				sheetObjects[11]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t11sheet1"){
				sheetObjects[12]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t12sheet1"){
				sheetObjects[13]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t13sheet1"){
				sheetObjects[14]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t14sheet1"){
				sheetObjects[15]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t15sheet1"){
				sheetObjects[16]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t16sheet1"){
				sheetObjects[17]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t17sheet1"){
				sheetObjects[18]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t18sheet1"){
				sheetObjects[19]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t19sheet1"){
				sheetObjects[20]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t20sheet1"){
				sheetObjects[21]=tempSheetObjects[i];
			}
		}
		//getting menu. 
		doActionIBSheet(sheetObjects[0],document.form,IBRESET);
	}
	//Axon handling event2. handling event
	function obj_deactivate(){
	    ComChkObjValid(ComGetEvent());
	}
	function obj_activate(){
		var obj=ComGetEvent();
		if(obj.name != "agmt_no"){
			ComClearSeparator(ComGetEvent());
		} else {
			obj.style.imeMode="disabled" ;
		}
	}
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC03);
					trf_no.SetEnable(1);
				   	break;
	    		case "agmt_no":
					formObj.agmt_no.value=formObj.agmt_no.value.substring(0,3) + ComLpad(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length), 6, "0");
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
				   	break;
				case "pay_term_dys":
					//modifying Ctrl Office.
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"pay_term_dys",ComGetObjValue(formObj.pay_term_dys),0);
					}
					break;
				case "eff_dt":
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"eff_dt",ComGetObjValue(formObj.eff_dt),0);
					}
					break;
				case "exp_dt":
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"exp_dt",ComGetObjValue(formObj.exp_dt),0);
					}
					break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	        		formObj.vndr_nm.value="";
					trf_no.RemoveAll();
					trf_no.SetSelectCode("");
					trf_no.SetEnable(0);
					//modifying Ctrl Office.
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"mnr_prnr_seq","",0);
						sheetObjects[1].SetCellValue(i,"mnr_prnr_lgl_eng_nm","",0);
						sheetObjects[1].SetCellValue(i,"mnr_prnr_locl_lang_nm","",0);
						sheetObjects[1].SetCellValue(i,"pay_term_dys","",0);
					}
				   	break;
	    		case "agmt_no":
	        		//setting agmt_ver_no
					agmt_ver_no.RemoveAll();
					agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
					defVerCode='1';
					agmt_ver_no.SetSelectCode(defVerCode);
				   	break;
				case "pay_term_dys" :
					//modifying Ctrl Office.
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"pay_term_dys","",0);
					}
					break;
				case "eff_dt":
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"eff_dt","",0);
					}
					break;
				case "exp_dt":
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"exp_dt","",0);
					}
					break;
			}
		}
	}
//	function obj_keypress(){
//	    obj=ComGetEvent();
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "ymd":
//	        case "ym":
//	        case "hms":
//	        case "hm":
//	        case "jumin":
//	        case "saupja":
//	            ComKeyOnlyNumber(obj);
//	            break;
//	        case "int":
//				ComKeyOnlyNumber(obj);
//	            break;
//	        case "float":
//	            ComKeyOnlyNumber(obj, "-.");
//	            break;
//	        case "eng":
//	            ComKeyOnlyAlphabet(); break;
//	        case "engup":
//	            if(obj.name=="vndr_seq"){
//					ComKeyOnlyNumber(obj);
//				} else {
//					ComKeyOnlyAlphabet('uppernum');
//				}
//	            break;
//	        case "engdn":
//				if(obj.name == "phn_no" || obj.name == "fax_no"){
//					ComKeyOnlyNumber(obj, "-");
//				}   else {
//					ComKeyOnlyAlphabet('lower');
//				}
//	            break;
//	    }
//	}
    /**
     * Event when clicking Tab
     * activating selected tab items.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
	    	objs[nItem].style.display="Inline";
	    	//--------------- important --------------------------//
	    	for(var i = 0; i<objs.length; i++){
	    		  if(i != nItem){
	    		   objs[i].style.display="none";
	    		   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	    		  }
	    		}
	    	//------------------------------------------------------//
	    	beforetab=nItem;
    }
	function trf_no_OnChange(comboObj,Index_Code, Text){
		var formObj=document.form;
		if(Index_Code != ""){
			var formObj=document.form;
			var tempText=Text.split("|");
			if(tempText[7] != formObj.curr_cd.GetSelectCode()) {
				var usrOk=ComShowCodeConfirm("MNR00203",tempText[7]);
				if(usrOk){
					curr_cd.SetSelectCode(tempText[7],false);
					ComSetFocus(formObj.agmt_ref_no);
				} else {
					trf_no.SetSelectCode(priTrfNo,false);
					ComSetFocus(formObj.agmt_ref_no);
				}
			}
		}
		priTrfNo=trf_no.GetSelectCode();
	}
	function agmt_ver_no_OnChange(comboObj,Index_Code, Text){
		var formObj=document.form;
		if(comboObj.GetSelectCode()== defVerCode){
			if(!loadIbclear){
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_del");
				ComBtnEnable("btn_versionup");
				ComBtnEnable("btn_add");
				ComBtnEnable("btn_s1del");
				ComBtnEnable("btn_calendar");
				ComBtnEnable("btn_calendar1");
			}
			MnrFormSetReadOnly(formObj,true,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
			//Editable
			setComboEnable(false);
			for(var i=1; i < sheetObjects.length; i++){
				sheetObjects[i].SetEditable(0);
			}
		} else {
			if(!loadIbclear){
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_del");
				ComBtnDisable("btn_versionup");
				ComBtnDisable("btn_add");
				ComBtnDisable("btn_s1del");
				ComBtnDisable("btn_calendar");
				ComBtnDisable("btn_calendar1");
			}
			MnrFormSetReadOnly(formObj,true,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
			//Prevent Modify
			setComboEnable(false);
			for(var i=1; i < sheetObjects.length; i++){
				sheetObjects[i].SetEditable(0);
			}
		}
		//Prevent retrieve in case of initial setting
		if(formObj.agmt_no.value != "NEW" && formObj.agmt_no.value != ""){
			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	function eq_knd_cd_OnChange(comboObj,Index_Code, Text){
		var formObj=document.form;
		//check message
		if(formObj.agmt_no.value == "NEW"){
			var cnt=0;
			for (var i=2; i < sheetObjects.length; i++){
				cnt += sheetObjects[i].RowCount();
			}
			if(cnt > 0) {
				//checking whether modifying
				if(!ComShowCodeConfirm("MNR00192")) {
					eq_knd_cd.SetSelectCode(tempEqKndCd,false);
					return;
				}
			}
		}
        var objs=document.all.item("tabLayer");
		tempEqKndCd=comboObj.GetSelectCode();
		//mnr_ord_tp_cd|ibflag|eq_type|dp_seq|tab_type|cost_cd|tab_title|pagerows
		//QT~~I~~Z~~6~~OT~~MRZSOT~~Other
		objs[beforetab].style.display="none";
		ComOpenWait(true,true);
		if(comboObj.GetSelectCode()== 'U'){
			for(var i=0; i < uTab.length ; i++){
//				sheetObjects[i + 2]=sheetObjects[i + 2].Reset();
				sheetObjects[i + 2].RenderSheet(0);
//				ComConfigSheet (sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],uTab[i][0],comboObj.GetSelectCode(),uTab[i][4]);
				sheetObjects[i + 2].RenderSheet(1);
//				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],uTab);
			formObj.agmt_type_tpsz.value=ComGetAryJoin(uTpSz, "|");
		} else if (comboObj.GetSelectCode()== 'G'){
			for(var i=0; i < gTab.length ; i++){
				sheetObjects[i + 2]=sheetObjects[i + 2].Reset();
//				ComConfigSheet (sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],gTab[i][0],comboObj.GetSelectCode(),gTab[i][4]);
//				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],gTab);
			formObj.agmt_type_tpsz.value=ComGetAryJoin(gTpSz, "|");
		} else if (comboObj.GetSelectCode()== 'Z'){
			for(var i=0; i < zTab.length ; i++){
				sheetObjects[i + 2]=sheetObjects[i + 2].Reset();
//				ComConfigSheet (sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],zTab[i][0],comboObj.GetSelectCode(),zTab[i][4]);
//				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],zTab);
			formObj.agmt_type_tpsz.value=ComGetAryJoin(zTpSz, "|");
		}
		ComOpenWait(false,true);
		objs[beforetab].style.display="inline";
		if(eq_knd_cd.GetEnable()== true){
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
		}
	}
	//showing message in case of clicking delete button
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
          ComShowCodeMessage("MNR00020",ErrMsg);
      	} else {
          ComShowCodeMessage("MNR00048",ErrMsg);
		}
	}
	//showing message in case of clicking Save button
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
          ComShowCodeMessage("MNR00023",ErrMsg);
      	} else {
          ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
	function sheet2_OnPopupClick(sheetObj, row,col){
        if (sheetObj.ColSaveName(col) != "aply_ofc_cd") return;
		var param="?row=" + row + "&col=" + col;
		ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 450, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	//checking validation office code
	function sheet2_OnChange(sheetObj,Row, Col, Value)	{
		var retArray=null;
		if (sheetObj.ColSaveName(Col) == "aply_ofc_cd"){
			doCheckOffice(sheetObj,Row,Col);
		}
	}
	function t1sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t2sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t3sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t4sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t5sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t6sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t7sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t8sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
  // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
           case IBSEARCH:      //retrieving
              if(validateForm(sheetObj,formObj,sAction)){
			  		for(i=0;i<sheetObjects.length;i++){
			            	sheetObjects[i].RemoveAll();
		         	}
          			formObj.f_cmd.value=SEARCH;
 					var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					//setting header data
					if(arrXml[0] != null){
						//agmt_no 
						ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
						//vndr
						ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
						//version no
						agmt_ver_no.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ver_no"),false);
						//currency
						curr_cd.SetSelectCode(ComGetEtcData(arrXml[0], "curr_cd"));
						//agmt_ofc_cd
						agmt_ofc_cd.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ofc_cd"));
						//eff dt
						ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
						ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
						//pay_term_dys
						ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
						//agmt sign dt
						ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
						//agmt_ref_no
						ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
						//EQ_TYPE
						eq_knd_cd.SetEnable(0);
						eq_knd_cd.SetSelectCode(ComGetEtcData(arrXml[0], "eq_knd_cd"));
						//Tariff No
						setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
						
						ComSetObjValue(formObj.old_agmt_no, ComGetEtcData(arrXml[0], "old_agmt_no"));
						
						ComSetObjValue(formObj.cre_usr_id, ComGetEtcData(arrXml[0], "cre_usr_id"));
						ComSetObjValue(formObj.cre_dt, ComGetEtcData(arrXml[0], "cre_dt"));
						ComSetObjValue(formObj.upd_usr_id, ComGetEtcData(arrXml[0], "upd_usr_id"));
						ComSetObjValue(formObj.upd_dt, ComGetEtcData(arrXml[0], "upd_dt"));
					}
					//setting sheet data
					for(var i=1; i < arrXml.length + 1; i++){
						sheetObjects[i].LoadSearchData(arrXml[i-1],{Sync:1} );
					}
					//status retrieving
					nowRetriveSt=true;
					//setting  isVersionUp 
					formObj.isversionup.value="N";
					MnrFormSetReadOnly(formObj,true,"agmt_no");
			  }
              break;
			case IBRESET:      // getting menu
				formObj.f_cmd.value=SEARCH01;
 				var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do", FormQueryString(formObj));
				//0 mnr_ord_tp_cd|1 ibflag|2 eq_type|3 dp_seq|4 tab_title|5 pagerows
				var arrResult=MnrXmlToArray(sXml);
				var uCnt=0;
				var gCnt=0;
				var zCnt=0;
				if(arrResult != null){
					for(var i=0; i < arrResult.length;i++){
						if(arrResult[i][2] == "U"){
							uTab[uCnt++]=arrResult[i];
						}
						if(arrResult[i][2] == "Z"){
							zTab[zCnt++]=arrResult[i];
						}
						if(arrResult[i][2] == "G"){
							gTab[gCnt++]=arrResult[i];
						}
					}
				}
				//making data as list for retrieving type size per EQ_TYPE
				var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind");
				if(arrXml != null){
	 			    for(var i=0; i < arrXml.length; i++){
						if(i == 0){
							uTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
						} else if(i == 1){
							zTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
						} else if(i == 2){
							gTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
						}
				    }
				}
				break;
			case IBCLEAR:      //initializing
				MnrWaitControl(true);
				loadIbclear=true;
				//initializing sheet
				for(i=0;i < sheetObjects.length;i++){
					sheetObjects[i].RemoveAll();
					sheetObjects[i].SetEditable(0);
		        }
				retPossible=false;
				nowRetriveSt=false;
				//setting  isVersionUp 
				formObj.isversionup.value="N";
				//ReadOnly 
				MnrFormSetReadOnly(formObj,true,"agmt_no|vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
				//initializing combo
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].RemoveAll();
					comboObjects[i].SetEnable(1);
				}
				//Tariff combo
				trf_no.SetEnable(0);
				priTrfNo="";
				// initializing form
				formObj.vndr_seq.value="";
				formObj.vndr_nm.value="";
				formObj.pay_term_dys.value="";
				formObj.agmt_ref_no.value="";
				formObj.agmt_rmk.value="";
				//agreement no
				formObj.agmt_no.value="NEW"; //formObj.strAgmt_no.value;//
				//setting agmt_ver_no
				agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
				defVerCode='1';
				agmt_ver_no.SetSelectCode(defVerCode,false);
				//retrieving common combo.
				var sCondition=new Array (
				 	new Array("MdmCurrency","","COMMON"),       //CURRENCY
					new Array("MnrOfcGenInfo","","AGMT"),  //agmt_ofc_cd
					new Array("MnrGenCd","","CUSTOM9"),	//eq_knd_cd
					new Array("MnrGenCd","CD00016", "COMMON")	//trsm_mod_cd SHEET COMBO
				)
				var defCode="";
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				//setting combo
				for(var i=0; i < comboList.length;i++){
					if(comboList[i] != null){
						//initializing sheetCombo
						sheetComboText="";
						sheetComboCode="";
						for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							//CURRENCY
							if(i==0) {
								curr_cd.InsertItem(j, comboList[0][j] ,tempText[0]);
							//agmt_ofc_cd
							} else if(i==1){
								agmt_ofc_cd.InsertItem(j, tempText[0] ,tempText[0]);
								if(j == 0){
									defCode=tempText[0];
									agmt_ofc_cd.SetSelectCode(defCode);
								}
							//eq_knd_cd
							} else if(i==2){
									eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
								//setting return value.
								if(j == 0){
									defCode=tempText[0];
									eq_knd_cd.SetSelectCode(defCode);
								}
							}
						}
						//trsm_mod_cd
						if(i==3) {
							sheetObjects[1].InitDataCombo (0, "trsm_mod_cd", sheetComboText, sheetComboCode, sheetComboCode);
						}
					}
				}
				//setting Agreement Office default
				var Row=sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetCellValue(Row,"agmt_ofc_tp_cd","COST",0);
				sheetObjects[1].SetCellValue(Row,"aply_ofc_cd",formObj.agmt_ofc_cd2.value,0);
				sheetObjects[1].SetCellValue(Row,"ctrl_ofc_cd",formObj.agmt_ofc_cd2.value,0);
				sheetObjects[1].SetCellValue(Row,"mnr_grp_tp_cd","RPR",0);
				sheetObjects[1].SetCellValue(Row,"mnr_prnr_tp_cd","S",0);
				sheetObjects[1].SetCellValue(Row,"mnr_prnr_knd_cd","C",0);
				sheetObjects[1].SetCellValue(Row,"mnr_prnr_sts_cd","C",0);
				//setting AGMT Sign Date
				formObj.agmt_dt.value=ComGetNowInfo("ymd");
				loadIbclear=false;
				var sCode=sheetObjects[2].GetComboInfo(0,"cost_cd", "Code");
				var arrCode=sCode.split("|");
				for(var i=0;i < arrCode.length;i++){
					var Row=sheetObjects[2].DataInsert(-1);
					sheetObjects[2].SetCellEditable(Row,"cost_cd",0);
					sheetObjects[2].SetCellValue(Row,"cost_cd",arrCode[i],0);
				}
				MnrWaitControl(false);
                break;
			case IBSEARCH_ASYNC01:	//retrieving(in case of existing sevice provider No.)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					//Service Provider Detail Information
					var sXml=MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");
					if(ComGetEtcData(sXml, "vndr_seq") != null){
						//setting Vender nm
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
						//setting Curr
						curr_cd.SetSelectCode(ComGetEtcData(sXml, "pay_curr_cd"));
						//setting PAY TERM
						var tempPayTerm=ComGetEtcData(sXml, "gen_pay_term_cd");
						if(tempPayTerm != ""){
							if("O60" == tempPayTerm || "O45" == tempPayTerm){
								ComSetObjValue(formObj.pay_term_dys,"0");
							} else if ("IN" == tempPayTerm){
								ComSetObjValue(formObj.pay_term_dys,"5");
							} else if ("OUT" == tempPayTerm){
								ComSetObjValue(formObj.pay_term_dys,"60");
							} else {
								ComSetObjValue(formObj.pay_term_dys,tempPayTerm);
							}
						}
						//modifying Ctrl Office.
						for(var i=1; i <= sheetObjects[1].LastRow();i++){
							sheetObjects[1].SetCellValue(i,"mnr_prnr_seq",ComGetEtcData(sXml, "vndr_seq"),0);
							sheetObjects[1].SetCellValue(i,"mnr_prnr_lgl_eng_nm",ComGetObjValue(formObj.vndr_nm),0);
							sheetObjects[1].SetCellValue(i,"mnr_prnr_locl_lang_nm",ComGetObjValue(formObj.vndr_nm),0);
							sheetObjects[1].SetCellValue(i,"pay_term_dys",ComGetObjValue(formObj.pay_term_dys),0);
						}
					} else {
						ComShowCodeMessage("MNR00005", "Service Provider");
						ComSetObjValue(formObj.vndr_nm, "");
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
						ComSetObjValue(formObj.pay_term_dys,"0");
						curr_cd.SetSelectCode("");
						//modifying Ctrl Office.
						for(var i=1; i <= sheetObjects[1].LastRow();i++){
							sheetObjects[1].SetCellValue(i,"mnr_prnr_seq","",0);
							sheetObjects[1].SetCellValue(i,"mnr_prnr_lgl_eng_nm","",0);
							sheetObjects[1].SetCellValue(i,"mnr_prnr_locl_lang_nm","",0);
							sheetObjects[1].SetCellValue(i,"pay_term_dys","",0);
						}
					}
				}
				break;
				case IBSEARCH_ASYNC02:	//retrieving(in case of existing agreement no)
					//retrieving version no
					var sCondition=new Array (
						new Array("MnrAgmtHdr",formObj.agmt_no.value,formObj.agmt_ofc_cd2.value)
					)
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					agmt_ver_no.RemoveAll();
					if(comboList[0] != null){
				 		for(var j=0; j < comboList[0].length;j++){
							var tempText=comboList[0][j].split("|");
							agmt_ver_no.InsertItem(j, comboList[0][j] ,tempText[0]);
							//setting return value
							if(j == 0){
								defVerCode=tempText[0];
								formObj.agmt_ver_no2.value=tempText[0];
								formObj.agmt_ver_dt.value=tempText[1];
							}
						}
						agmt_ver_no.SetSelectCode(defVerCode,false);
						//********************** IBSEARCH START  **********************//
						if(validateForm(sheetObj,formObj,IBSEARCH)){
							for(i=0;i<sheetObjects.length;i++){
				            	sheetObjects[i].RemoveAll();
				         	}
		          			formObj.f_cmd.value=SEARCH;
 							var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do", FormQueryString(formObj));
							var arrXml=sXml.split("|$$|");
							//setting header data
							if(arrXml[0] != null){
								//ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
								//vndr
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
								//version no
								agmt_ver_no.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ver_no"),false);
								//currency
								curr_cd.SetSelectCode(ComGetEtcData(arrXml[0], "curr_cd"),false);
								ComSetObjValue(formObj.curr_cd2, ComGetEtcData(arrXml[0], "curr_cd"));
								//agmt_ofc_cd
								agmt_ofc_cd.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ofc_cd"),false);
								//eff dt
								ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
								ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
								//pay_term_dys
								ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
								//agmt sign dt
								ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
								//agmt_ref_no
								ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
								//EQ_TYPE
								eq_knd_cd.SetEnable(0);
								eq_knd_cd.SetSelectCode(ComGetEtcData(arrXml[0], "eq_knd_cd"));
								ComSetObjValue(formObj.eq_knd_cd2, eq_knd_cd.GetSelectText());
								formObj.agmt_rmk.value=ComGetEtcData(arrXml[0], "agmt_rmk");
								//Tariff No
								setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
								
								ComSetObjValue(formObj.old_agmt_no, ComGetEtcData(arrXml[0], "old_agmt_no"));
								
								ComSetObjValue(formObj.cre_usr_id, ComGetEtcData(arrXml[0], "cre_usr_id"));
								ComSetObjValue(formObj.cre_dt, ComGetEtcData(arrXml[0], "cre_dt"));
								ComSetObjValue(formObj.upd_usr_id, ComGetEtcData(arrXml[0], "upd_usr_id"));
								ComSetObjValue(formObj.upd_dt, ComGetEtcData(arrXml[0], "upd_dt"));
							}
							//setting sheet data
							for(var i=1; i < arrXml.length + 1; i++){
								sheetObjects[i].LoadSearchData(arrXml[i-1],{Sync:1} );
							}
							//status retrieving
							nowRetriveSt=true;
							//setting  isVersionUp 
							formObj.isversionup.value="N";
							MnrFormSetReadOnly(formObj,true,"agmt_no");
						}
						//********************** IBSEARCH END  **********************//
					} else {
						//setting agmt_ver_no
						agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
						agmt_ver_no.SetSelectText('1');
						defVerCode='1';
						ComShowCodeMessage("MNR00165","Data");
						ComSetObjValue(formObj.agmt_no, "");
						ComSetFocus(formObj.agmt_no);
					}
					retPossible=true;
				break;
			case IBSEARCH_ASYNC03:      //retrieving tariff popup 
				trf_no.RemoveAll();
				var ofcCd=formObj.local_ofc_cd.value;
				var mnrTrfKndCd="LCL";
				var creDtFr=ComGetDateAdd(ComGetNowInfo("ymd"), "y", -1);
				var creDtTo=ComGetNowInfo('ymd');
				var eqKndCd=eq_knd_cd.GetSelectCode();
				var mnrTrfStsCd="HA";
				var vndrSeq=formObj.vndr_seq.value;
				var f_query="";
				f_query += 'f_cmd' + '=' + SEARCH03	+ '&';
				f_query += 'ibflag=X&';
				f_query += 'ofc_cd' + '=' + ofcCd + "&";
				f_query += 'mnr_trf_knd_cd' + '=' + mnrTrfKndCd + "&";
				f_query += 'cre_dt_fr' + '=' + creDtFr + "&";
				f_query += 'cre_dt_to' + '=' + creDtTo + "&";
				f_query += 'eq_knd_cd' + '=' + eqKndCd + "&";
				f_query += 'mnr_trf_sts_cd' + '=' + mnrTrfStsCd + "&";
				f_query += 'vndr_seq' + '=' + vndrSeq;
 				var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do", f_query);
				//0 mnr_trf_sts_nm|1 vndr_seq|2 vndr_nm|3 agmt_no|4 rqst_ofc_cd|5 pagerows|6 eff_dt|7 curr_cd|8 ibflag|9 cre_dt|10 mnr_meas_ut_cd|11 mnr_trf_knd_nm|12 upd_usr_id|13 apro_ofc_cd|14 cre_usr_id|15 mnr_trf_sts_dt|16 mnr_trf_knd_cd|17 sts_ref_no|18 mnr_trf_rmk|19 trf_no|20 cre_usr_nm|21 eq_knd_nm|22 mnr_inp_tp_cd|23 mnr_trf_sts_cd|24 eq_knd_cd|25 mnr_meas_ut_nm|26 upd_dt|27 pre_trf_no
				var arrResult=MnrXmlToArray(sXml);
				trf_no.InsertItem(0,"","");
				if(arrResult != null){
					for(var i=0; i < arrResult.length;i ++){
						var tempComboText=arrResult[i][19] + "|" + arrResult[i][11] + "|" + arrResult[i][2] + "|" + arrResult[i][21] + "|" + arrResult[i][0] + "|" + arrResult[i][6] + "|" + arrResult[i][25] + "|" + arrResult[i][7];
						trf_no.InsertItem(i + 1, tempComboText ,arrResult[i][19]);
					}
				}
				break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
          with(formObj){
        	switch(sAction) {
				case IBSEARCH:
        			if( formObj.agmt_no.value == ""  || formObj.agmt_no.value == "NEW") {
        				ComShowCodeMessage("MNR00172","Agreement No For Search ");
        				ComSetFocus(formObj.agmt_no);
        				return false;
        			} else if ( agmt_ver_no_text.value == ""  ) {
        				ComShowCodeMessage("MNR00172","Version()No For Search ");
//        				formObj.agmt_ver_no.focus(); //TODO: Checking.
        				return false;
        			} else {
						formObj.agmt_ofc_cty_cd.value=formObj.agmt_no.value.substring(0,3);
						formObj.agmt_seq.value=parseInt(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length),10);
						return true;
					}
        			break;
				case IBSEARCH_ASYNC01:
        			if( ComGetObjText(formObj.vndr_seq) == "" ) {
        				ComShowCodeMessage("MNR00172","Service Provider Seq ");
        				ComSetFocus(formObj.vndr_seq);
        				return false;
        			}
        			break;
			}
		}
        return true;
    }
	function getMnr_psMulti(aryPopupData,sheet_id,temp_value1){
		//temp value  0 -> cost_dtl_cd,1 -> cost_cd
		var tempVals=temp_value1.split("|");
		var formObj=document.form;
		var targetSheet=sheetObjects[sheet_id];
		// deleting in case of not existing values
		var startpoint=targetSheet.RowCount();
		for(var i=startpoint; i >= 1 ; i--){
			if(targetSheet.GetCellValue(i,"mnr_rt_tp_cd")	== ""){
				targetSheet.RowDelete(i, false);  	//completely delete
			}
		}
		for(var j=0; j < aryPopupData.length ; j++){
			var isHaveTpSz=false;
			for(var i=1;i <= targetSheet.RowCount();i++){
				if(targetSheet.GetCellValue(i,"cost_dtl_cd") == tempVals[0] && targetSheet.GetCellValue(i,"mnr_rt_tp_cd") == aryPopupData[j]){
					isHaveTpSz=true;
				}
			}
			if(!isHaveTpSz){
				var Row=targetSheet.DataInsert(-1);
				targetSheet.SetCellValue(Row,"agmt_ofc_cty_cd",formObj.agmt_ofc_cty_cd.value,0);
				targetSheet.SetCellValue(Row,"agmt_seq",formObj.agmt_seq.value,0);
				targetSheet.SetCellValue(Row,"agmt_ver_no",agmt_ver_no.GetSelectCode(),0);
				targetSheet.SetCellValue(Row,"mnr_rt_tp_cd",aryPopupData[j],0);
				targetSheet.SetCellValue(Row,"cost_cd",tempVals[1],0);
				targetSheet.SetCellValue(Row,"cost_dtl_cd",tempVals[0],0);
			}
		}
		if(targetSheet.RowCount()> 1){
			targetSheet.SelectCell(1, "agmt_rt_amt", false);
		}
	}
 	/**
	 * COM_ENS_071 receiving function values ​​from Pop-up
	 */
	function getCOM_ENS_071(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
		  	sheetObjects[1].SetCellValue(row,col,aryPopupData[0][3]);
		 }
    }
	function setComboEnable(changeValue){
		var formObj=document.form;
    	for(var i=1; i < comboObjects.length;i++){
			comboObjects[i].SetEnable(changeValue);
		}
		if(changeValue == true){
			if(formObj.vndr_seq.value == ""){
				trf_no.SetEnable(0);
			} else {
				trf_no.SetEnable(1);
			}
		}
		if(nowRetriveSt == true){
			eq_knd_cd.SetEnable(0);
		} else {
			eq_knd_cd.SetEnable(1);
		}
	}
	function setTrfCombo(trfNo){
		var formObj=document.form;
		if(formObj.vndr_seq.value == ""){
			trf_no.SetEnable(0);
			trf_no.RemoveAll();
			trf_no.SetSelectCode("",false);
		} else {
			trf_no.SetEnable(1);
			if(agmt_ver_no.GetSelectCode()== defVerCode){
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
				trf_no.SetSelectCode(trfNo,false);
				formObj.trf_no2.value=trfNo;
			} else {
				trf_no.RemoveAll();
				trf_no.InsertItem(0,trfNo,trfNo);
				trf_no.SetSelectCode(trfNo,false);
				formObj.trf_no2.value=trfNo;
			}
		}
		if(agmt_ver_no.GetSelectCode()== defVerCode){
			trf_no.SetEnable(1);
		} else {
			trf_no.SetEnable(0);
		}
	}
	function doCheckOffice(sheetObj,Row,Col){
		var checkOffice=sheetObj.GetCellValue(Row ,Col);
	    retArray=MnrGeneralCodeCheck(sheetObj,"OFC",checkOffice);
		if(retArray == null){
			ComShowCodeMessage("MNR00165",checkOffice);
			sheetObj.SetCellValue(Row ,Col,"",0);
			sheetObj.SelectCell(Row ,Col);
		} else {
			sheetObj.SetCellValue(Row ,"ctrl_ofc_cd",sheetObj.GetCellValue(Row ,Col));
			return;
		}
	}
	/* developer job */
