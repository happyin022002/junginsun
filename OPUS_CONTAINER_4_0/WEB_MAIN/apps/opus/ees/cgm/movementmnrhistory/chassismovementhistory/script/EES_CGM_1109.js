/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1109.js
*@FileTitle  : Chassis Movement Update by Container
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
   /**
     * @fileoverview
     * @author
     */
    /**
     * @extends
     * @class EES_CGM_1109 : EES_CGM_1109
     */

	 var tabObjects=new Array();
	 var tabCnt=0 ;
	 var beforetab=1;
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 var OrgValue="";
	 var maxIa=[['',''],['',''],['','']];
	 var rtnValue;
	 var popUp = "N";
	 document.onclick=processButtonClick;
     function processButtonClick(){
         var sheetObject1=sheetObjects[0];
	     var sheetObject2=sheetObjects[1];
        /*******************************************************/
	     var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
	     switch(srcName) {
			 case "btn_retrieve":
			 	 doActionIBSheet(sheetObject1,document.form,IBSEARCH);
			 break;
			 case "btn_new":
				 formObject.reset();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
			 break;
			 case "btn_save":
				 doActionIBSheet(sheetObject2,document.form,IBSAVE);
			 break;
	     } // end switch
	     tRoleApply();
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
     }
     /**
      * IBSheet Object
      *
      *
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * Sheet
      * body
      *
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         if(document.form.p_cntrno.value != ""){
        	 frmObj = document.form;
 	    	//alert("sss");
 	    	cntrno = frmObj.p_cntrno.value;
 	    	popUp = "Y";
// 	    	if (cntrno.length == 10 || cntrno.length == 11) {
	    	    var sheetObj = sheetObjects[0];
	    	    frmObj.f_cmd.value = SEARCH10;
	    	    xml = sheetObj.GetSearchData ("CTMCommonGS.do", FormQueryString(frmObj));
	    	    if(ComGetEtcData(xml, "TRANS_RESULT_KEY") == "S"){
	    	    	rtnValue = ComGetEtcData(xml, "rtnValue");
	        	    if (rtnValue == null) sheetObj.LoadSearchXml(xml);
	        	    parseCTNRNo(rtnValue, frmObj);
	    	    }else{
	    	    	ComShowCodeMessage("CGM20023", "Container No");
	    	    }
	    	    
// 	    	}
         }
     }
          /**
      *
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {
         var formObj=document.form;
         //axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
         //axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
         axon_event.addListener('focusout', 'obj_focusout', 'p_cntrno' );
         axon_event.addListenerFormat('beforeactivate',	  'obj_activate',	formObj);
         // reset
         initControl(sheetObjects[0]);
         tRoleApply();
    }
     
     /**
      * Object Keypress ?  <br>
      *  ??dataformat  .  <br>
      * @param
      * @return
      * @author
      * @version
      */
     function obj_keypress(){
    	 obj = event.srcElement;
    	 if(obj.dataformat == null) return;

    	 window.defaultStatus = obj.dataformat;
    	 switch(obj.dataformat) {

    	 case "eng":
    		if(event.keyCode == 13) {doActionIBSheet(IBSEARCH);}
  	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
  	        else ComKeyOnlyAlphabet('uppernum');
  	        break;
    	 }
     }

     /**
      *
      * @return
      */
     function obj_keyup(){
	    	 var formObj = document.form;
	    	 var sheetObj = sheetObjects[0];
	    	 obj = event.srcElement;
	    	 switch(ComGetEvent("name")){
	    	 	case "p_cntrno":

    	    	frmObj = document.form;
    	    	//alert("sss");
    	    	cntrno = frmObj.p_cntrno.value;
//    	    	if (cntrno.length == 10 || cntrno.length == 11) {
	    	    	var sheetObj = sheetObjects[0];
	    	    	frmObj.f_cmd.value = SEARCH10;
	    	    	xml = sheetObj.GetSearchData ("CTMCommonGS.do", FormQueryString(frmObj));
	    	    	if(ComGetEtcData(xml, "TRANS_RESULT_KEY") == "S"){
	    	    		rtnValue = ComGetEtcData(xml, "rtnValue");
	        	    	if (rtnValue == null) sheetObj.LoadSearchXml(xml);
	        	    	parseCTNRNo(rtnValue, frmObj);
	    	    	}else{
	    	    		ComShowCodeMessage("CGM20023", "Container No");
	    	    		formObj.p_cntrno.value = "";
	    	    		ComSetFocus(formObj.p_cntrno);
	    	    	}
//    	    	}
    	    	break;
	    	 }
	    }

     
     
      /**
       * init control of form <br>
       * @param  {object} sheetObj	
       * @return 
       * @author 
       * @version
       */
      function initControl(sheetObj){
      	// Form object
      	  formObj=document.form;
          // axon event regist
      	if(formObj.p_cntrno.value !=""){
     	    	cntrno=formObj.p_cntrno.value;
     	    	if (cntrno.length == 10 || cntrno.length == 11) {
	     	    	var sheetObj=sheetObjects[0];
	     	    	formObj.f_cmd.value=SEARCH10;
 	     	    	xml=sheetObj.GetSearchData("CTMCommonGS.do", FormQueryString(formObj));
	     	    	
	     	    	if(ComGetEtcData(xml, "TRANS_RESULT_KEY") == "S"){
	     	    		rtnValue=ComGetEtcData(xml, "rtnValue");
		     	    	if (rtnValue == null) sheetObj.LoadSearchData(xml,{Sync:1} );
		     	    	parseCTNRNo(rtnValue, formObj);
	     	    	}else{
	    	    		ComShowCodeMessage("CGM20023", "Container No");
	    	    	}
     	    	}
        	doActionIBSheet(sheetObj, formObj, IBSEARCH);
         } else {
        	 formObj.p_cntrno.focus();
         }
      }
	function resizeSheet(){
		ComResizeSheet( sheetObjects[1] );
	}
      /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {
                 var HeadTitle="CYC|T/VVD|POR|POL|Relay|POD|DEL|Booking No.|Booking No.|Booking No.|B/L No.|Commodity";
                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);
                 var cols = [ 
                {Type:"Text",      Hidden:0,  Width:29,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:72,   Align:"Center",  ColMerge:0,   SaveName:"vl",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Relay",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rep_cmdt_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 } ];
                  
                 InitColumns(cols);
                 SetSheetHeight(101);
                 SetEditable(0);
                }
                 break;
                 case 2:      //t1sheet1 init
                 with (sheetObj) {
                	 sheetObj.SetAutoTrim=false;
                	 var HeadTitle="|Sel.|CYC|C|STS|A/F|Origin YD|Return YD|Event Date|VVD Code";
                	 HeadTitle      +=  "|F/M|I/O|MSG|TP|DM|D|E|CNTR XCH CD|R|SP";
                	 HeadTitle      +=  "|Service Provider|Service Provider|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Update Date(L)|Creation Date(L)|Update Date(S)|Creation Date(S)";
                	 HeadTitle      +=  "|Office|User Name|Remark(s)|ID|SEQ|NO|CNTR_NO|BKG_NO|BKG_SPLIT|BKG_KNT|BL_NO|BL_NO_TYPE|BL_NO_CHK|YEAR|FLG|TPSZ|MAX SEQ|CNTR_SVR ID|SVR_ID|EDI1|EDI2|EDI3|EDI4|VVD|";
                	 var sTipAF="[ Auto Flag ]"
                	 + "\nA : Missing status automatically created by system"
                	 + "\nC : (International) “TS, IC, MT” Status automatically created after \"VD\""
                	 + "\n      (USA domestic) “CM” Status automatically created after \"CD\""
                	 + "\nN : Once automatically created status (\"A\") modified by manual,"
                	 + "\n      \"A\" changed to \"N\""
                	 + "\nM : Added status."
                	 + "\nU : Status updated due to next status."
                	 var sTipTP  = "[ Cargo type ] \nF: Full, P: Reposition, R: Revenue";
                	 var sTipDM  = "Damage, Y";
                	 var sTipHG  = "Hanger rack, Y";
                	 var sTipD   = " Disposal Candidate, Y";
                	 var sTipE   = "Immediate Exit, Y";
                     var sTipX   = "Exchange, Y";
                	 var sTipR   = "Re-furbishing, Y";
                	 var sTipSP  = "Special, Y";

                	 SetConfig( { SearchMode:2, FrozenCol:9, MergeSheet:5, Page:20, DataRowMerge:1 } );

                	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                	 InitHeaders(headers, info);

                	 var cols = [ 
    	              {Type:"Status",     Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    	              {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",               KeyField:0,   CalcLogic:"",   Format:"" },
    	              {Type:"Text",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_co_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
    	              {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cre_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
    	              {Type:"Text",       Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"fcntr_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	              {Type:"Text",       Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ob_cntr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	              {Type:"Text",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	              {Type:"Text",       Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
    	              {Type:"Text",       Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_dmg_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
    	              {Type:"Text",       Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_disp_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
    	              {Type:"Text",       Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"imdt_ext_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
    	              {Type:"Text",       Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_xch_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
    	              {Type:"Text",       Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_rfub_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
    	              {Type:"Text",       Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
    	              {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
    	              {Type:"Text",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
    	              {Type:"Text",       Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mgst_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
    	              {Type:"Text",       Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"wbl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_locl_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	              {Type:"Text",       Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
    	              {Type:"Text",       Hidden:0, Width:160,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_id_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_split_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"bkg_knt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"vr_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"cntr_svr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"svr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_area_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_yrmondy",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"lst_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
    	              {Type:"Text",       Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"crnt_skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
                	  
                	 InitColumns(cols);
//                	 SetSheetHeight(282);
                	 
                	 SetEditable(1);
                	 SetColProperty(0,"cnmv_evnt_dt", {Format:"####-##-## ##:##"} );
                	 SetColProperty(0,"upd_locl_dt", {Format:"####-##-## ##:##"} );
                	 SetColProperty(0,"cre_locl_dt", {Format:"####-##-## ##:##"} );
                	 SetColProperty(0,"upd_dt", {Format:"####-##-## ##:##"} );
                	 SetColProperty(0,"cre_dt", {Format:"####-##-## ##:##"} );
                	 //FrozenCols=9;


	                  SetColProperty(0 ,"cnmv_co_cd" , {AcceptKeys:"E"});
	                  SetColProperty(0 ,"mvmt_sts_cd" , {AcceptKeys:"E"});
	                  SetColProperty(0 ,"mvmt_cre_tp_cd" , {AcceptKeys:"E"});
	                  SetColProperty(0 ,"org_yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty(0 ,"dest_yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty(0 ,"cntr_id" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty(0 ,"vndr_seq" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty(0 ,"mvmt_trsp_mod_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty(0 ,"chss_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty(0 ,"mgst_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty(0 ,"cntr_seal_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty(0 ,"wbl_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty(0 ,"pkup_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty(0 ,"ofc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty(0 ,"cnmv_cyc_no" , {AcceptKeys:"E|N"});
	                  
	                  resizeSheet();
                }
                 break;
         }
     }
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH;
					sheetObjects[0].SetWaitImageVisible(0);
				    sheetObjects[1].SetWaitImageVisible(0);
	 			 	ComOpenWait(true);
	 				var sXml=sheetObj.GetSearchData("EES_CGM_1109GS.do" , FormQueryString(formObj));
	        		var arrXml=sXml.split("|$$|");
		          	sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		          	sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
		          	lastCnt=sheetObjects[1].LastRow();
                 //sheetObjects[0].SelectRow(lastCnt);
                 sheetObjects[1].SelectCell(lastCnt, 'del_chk', true);
                 sheetObjects[0].SelectCell(sheetObjects[0].LastRow(), 1);
                	if (sheetObjects[1].LastRow()> 1) {
                 		sheetObjects[1].SetCellValue(sheetObjects[1].LastRow(), "lst_flg","1",0);
                 		sheetObjects[1].SetRowStatus(sheetObjects[1].LastRow(),"");
                 	}
                	ComOpenWait(false);
                	sheetObjects[0].SetWaitImageVisible(1);
				    sheetObjects[1].SetWaitImageVisible(1);
				}
	          	break;
			case IBSAVE:
			   if(validateForm(sheetObj,formObj,sAction)){
				   formObj.f_cmd.value=MULTI;
				   queryString="f_cmd=" + MULTI ;
				   var params=sheetObj.GetSaveString(true);
				   if(sheetObj.DoSave("EES_CGM_1109GS.do",queryString + "&" + ComGetPrefixParam(""))){
				   }
			   }
			   break;
         }
     }
     /**
      *
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             switch(sAction) {
             	case IBSEARCH:      //retrieve
             	     if(formObj.p_cntrno.value==""  ){
             	    	 ComShowCodeMessage('CGM10009','Container No');
             	    	 return false;
             	     }
	             	 
             	     break;
             	case IBSAVE:       //saving
                    sheetObj.RenderSheet(0);
                    for (var i=1; i<=sheetObj.RowCount(); i++) {
                        sheetObj.SetRowStatus(i,"R");
                        if (sheetObj.GetCellValue(i, "del_chk") != "1") {
                            sheetObj.SetRowStatus(i,"R");
                        } else {
                        	if (sheetObj.GetCellValue(i, "del_chk") == "1" && (sheetObj.GetCellValue(i, "cnmv_rmk")=="" || sheetObj.GetCellValue(i, "cnmv_rmk") == sheetObj.GetCellValue(i, "crnt_skd_dir_cd"))) {
                                sheetObj.RenderSheet(1);
                                ComShowCodeMessage('CGM10080');
                                sheetObj.SelectCell(i, 33, true);
                                return false;
                            } else { 
                            	ComOpenWait(true);
                                sheetObj.SetRowStatus(i,"U");
                            }
                        }
                    }
                    sheetObj.RenderSheet(1);
                    ComOpenWait(false);
                    break;
             }
         }
         return true;
     }
 	 function parseCTNRNo(CTNRNO, formObj) {
 		if (!CTNRNO) return;
 		var CtnrVal=CTNRNO.split("|");
 		if (CtnrVal.length >= 3) {
 			if (formObj.ctnr_sts_cd) {
 				formObj.ctnr_sts_cd.value=CtnrVal[1];
 			}
 			if (formObj.ctnr_tpsz_cd) {
 				formObj.ctnr_tpsz_cd.value=CtnrVal[2];
 			}
 		} else {
 			if (formObj.ctnr_sts_cd) {
 				formObj.ctnr_sts_cd.value="";
 			}
 			if (formObj.ctnr_tpsz_cd) {
 				formObj.ctnr_tpsz_cd.value="";
 			}
 		}
 		if(popUp = "Y"){
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 			popUp = "N";
 		}
 	}

 	 
 	 function sheet2_OnBeforeEdit(sheetObj, Row, Col)
 	 {
  	 OrgValue=sheetObj.GetCellText(Row, Col);
 	 }
 	 
   	function sheet2_OnChange(sheetObj, Row, Col){
         var formObj=document.form;
         var chk=true;
    	 switch (sheetObj.ColSaveName(Col)) {
      	 case "chss_no" :
			   	var cellValue=sheetObj.GetCellValue(Row, Col);
			   	if(sheetObj.GetCellValue(Row, "chss_no")!="")
			   	{
			   		formObj.eq_no.value=sheetObj.GetCellValue(Row, "chss_no");
			   		formObj.chss_no.value=sheetObj.GetCellValue(Row, "chss_no");
				   	formObj.eq_knd_cd.value="Z";
				   	formObj.cntr_no.value=sheetObj.GetCellValue(Row, "cntr_no");
				   	formObj.from_dt.value=sheetObj.GetCellValue(Row, "cnmv_evnt_dt");
				   	formObj.eq_tpsz_cd.value=sheetObj.GetCellValue(Row, "cntr_tpsz_cd");
				   	formObj.cntr_tpsz.value=sheetObj.GetCellValue(Row, "cntr_tpsz_cd");
					sheetObj.SetCellValue(Row, "del_chk","1");
					if(Row == sheetObj.RowCount){
						formObj.to_dt.value="";
					} else {
						formObj.to_dt.value=sheetObj.GetCellValue(Row+1, "cnmv_evnt_dt");
					}
					formObj.f_cmd.value=SEARCH02;
 			    	var sXml2=sheetObj.GetSearchData("EES_CGM_1109GS.do" , FormQueryString(formObj));
				    var dataCount2=ComGetTotalRows(sXml2);
				    if(dataCount2 > 0){
				    	if(DomXml2String(sXml2,"aciac_div_cd")=="I"){
				    		if(ComShowCodeConfirm("CGM10076"),sheetObj.GetCellValue(Row, "chss_no")){
				    			changeColor(sheetObj, i);
							} else {
								sheetObj.SetCellValue(Row, "chss_no",OrgValue,0);
								sheetObj.SetCellValue(Row, "del_chk","0");
								return;
							}
				    	}
				    	if(DomXml2String(sXml2,"tpsz_check")!="OK"){
				    		ComShowCodeMessage("CGM20030");
				    		sheetObj.SetCellValue(Row, "del_chk","0");
				    		sheetObj.SetCellValue(Row, "chss_no",OrgValue,0);
				    		return;
				    	}
				    } else {
				    	if(ComShowCodeConfirm("CGM10076")){
				    		changeColor(sheetObj, i);
						} else {
							sheetObj.SetCellValue(Row, "del_chk","0");
							sheetObj.SetCellValue(Row, "chss_no",OrgValue,0);
							return;
						}
				    }
				    formObj.f_cmd.value=SEARCH01;
 			   		var sXml=sheetObj.GetSearchData("EES_CGM_1109GS.do" , FormQueryString(formObj));
				    var dataCount=ComGetTotalRows(sXml);
				    if(dataCount > 0){
				    	if(DomXml2String(sXml,"chk")!="OK"){
				    		ComShowCodeMessage("CGM10078");
				    		sheetObj.SetCellValue(Row, "del_chk","0");
				    		sheetObj.SetCellValue(Row, "chss_no",OrgValue,0);
				    		return;
				    	}
				    	return;
				   	}
			   	} else {
			   		if(sheetObj.GetCellValue(Row, "chss_no") != sheetObj.GetCellValue(Row, "chss_no_2")){
			   			changeColor(sheetObj, i);
			   			sheetObj.SetCellValue(Row, "del_chk","1");
			   		}
			   	}
			   	break;
          case "mgst_no" :
        	    formObj.f_cmd.value=SEARCH;
        	    formObj.eq_no.value=sheetObj.GetCellValue(Row, "mgst_no");
        	    formObj.chss_no.value=sheetObj.GetCellValue(Row, "mgst_no");
	  		   	formObj.eq_knd_cd.value="G";
	  		   	formObj.cntr_no.value=sheetObj.GetCellValue(Row, "cntr_no");
	  		   	formObj.from_dt.value=sheetObj.GetCellValue(Row, "cnmv_evnt_dt");
	  		   	formObj.eq_tpsz_cd.value=sheetObj.GetCellValue(Row, "cntr_tpsz_cd");
				if(Row == sheetObj.RowCount){
					formObj.to_dt.value="";
				} else {
					formObj.to_dt.value=sheetObj.GetCellValue(Row+1, "cnmv_evnt_dt");
				}
	  		   	var cellValue=sheetObj.GetCellValue(Row, Col);
	  		    sheetObj.SetCellValue(Row, "del_chk","1");
	  		    if(sheetObj.GetCellValue(Row, "mgst_no")!="")
	  		   	{
   			   		var sXml=sheetObj.GetSearchData("CGM_CHS_MASTERGS.do", FormQueryString(formObj));
  				    var dataCount=ComGetTotalRows(sXml);
  				    //
  				    if(dataCount > 0){
  				    	if(DomXml2String(sXml,"aciac_div_cd")=="I"){
  				    		if(ComShowCodeConfirm("CGM10077")){
  				    			changeColor(sheetObj, i);
							} else {
								sheetObj.SetCellValue(Row, "del_chk","0");
								sheetObj.SetCellValue(Row, "mgst_no",OrgValue,0);
								return;
							}
  				    	} else {
  				    		sheetObj.SetCellValue(Row, "eq_tpsz_cd",ComGetEtcData(sXml,"eq_tpsz_cd"));
  				    	}
  				   	} else {
  				   		ComShowCodeMessage('CGM10077');
						sheetObj.SetCellValue(Row, "del_chk","0");
						sheetObj.SetCellValue(Row, "mgst_no",OrgValue,0);
						return;
  				   }
  				   formObj.f_cmd.value=SEARCH01;
 			   		var sXml=sheetObj.GetSearchData("EES_CGM_1109GS.do" , FormQueryString(formObj));
				    var dataCount=ComGetTotalRows(sXml);
				    if(dataCount > 0){
				    	ComShowCodeMessage('CGM10078');
				    	sheetObj.SetCellValue(Row, "del_chk","0");
				    	sheetObj.SetCellValue(Row, "mgst_no",OrgValue,0);
				    	return;
				   	}
	  		   	}
	  		   	break;
      	}
     }
   	 function sheet2_OnSaveEnd(sheetObj, errMsg) {
   		 if(errMsg =='') {
   			 ComShowCodeMessage('CGM00003');
   	    	 var sheetObject1=sheetObjects[0];
   			 doActionIBSheet(sheetObject1,document.form,IBSEARCH);
   		 }
   	 }
   	function changeColor(sheetObj, Row) {
//   		sheetObj.RowBackColor(Row) = "#7CFC00";
   		sheetObj.SetRowBackColor(Row,"#000000");
   	//alert (Row + "::::" + sheetObj.RowStatus(Row))
   		Sts=sheetObj.GetCellValue(Row, 5);
   		nowStatus=sheetObj.GetRowStatus(Row);
   		if (Sts != 'C' && Sts != '' && Sts != 'M') sheetObj.SetCellValue(Row, 5,'N');
   		if (nowStatus == 'I' || nowStatus == 'D') return;
   		else sheetObj.SetRowStatus(Row,"U");
   	 }
    /**
     * function(ex:btn_save) role(trole) apply  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */
    function tRoleApply() {
//        var formObj=document.form;
//        if (formObj.trole.value == "Authenticated") {
//        } else {
////            ComBtnDisable("btn_save");
//        }
    }
