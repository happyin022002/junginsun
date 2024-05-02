/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0221.js
*@FileTitle  : Edit Send Email/Fax
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // Common global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var IBSENDEMAILFAX="email_fax";
 var por_cd;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
        /*******************************************************/
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_ok":
            		var calllFunc;
            		var rArray=new Array(1);
//            		var rArray=new Array(2); // list of row data
//            		// single selection (Radio) or multiple selection (CheckBox)
//            		rArray.push(formObject.fax.value);
//            		rArray.push(formObject.email.value);
            		var obj=new Object();
					obj.fax=formObject.fax.value;
					obj.email=formObject.email.value;
            		if(formObject.fax.value == "" && formObject.email.value == "") {
            			ComShowCodeMessage("COM12114", "row");
            			return;
            		}
            		rArray[0]=obj;
            		ComPopUpReturnValue(rArray);
//            		calllFunc=formObject.calllFunc.value;
//            		if (ComFuncCheck("opener." + calllFunc)) ComFunc(rArray);
//            		else if (ComFuncCheck("parent." + calllFunc)) ComFunc(rArray);
//            		ComClosePopup(); 
                    break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
                case "btn_send":
                    doActionIBSheet(sheetObject,formObject,IBSENDEMAILFAX);
                    break;
            } // end switch
        } catch(e) {
            if ( e == "[object Error]") {
                ComShowCodeMessage("COM12111");
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
        for (var i=0; i<sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        if ("IBSENDFAX"==document.form2.fax_email.value) {
        	ComEnableObject(document.form.fax,true);
        	ComEnableObject(document.form.email,false);
        	ComClearObject(document.form.email);
        } else if ("IBSENDEMAIL"==document.form2.fax_email.value) {
        	ComEnableObject(document.form.fax,false);
        	ComEnableObject(document.form.email,true);
        	ComClearObject(document.form.fax);
        }
        initControl();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    function initControl() {
	   	if (document.getElementById("ui_id").value == "ESM_BKG_0079_02C") {
	   		document.form.email.value=parent.document.form.eml.value;
	   		ComBtnDisable("btn_ok");
		}
    }
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //sheet_search
                cnt=0;
                with(sheetObj){
	                 var HeadTitle1="ibflag|SysCd|TmplMrd|Title|TmplParam|RcvInfo|SndNm|SndEml|Filekey|RcvEml|Contents|Bkg_no|Bl_no|TmplMrdPdf|itr|NtcKndCd";
	                 var headCount=ComCountHeadTitle(HeadTitle1);
	
	                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                 InitHeaders(headers, info);
	
	                 var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"syscd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplmrd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"title",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplparam",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rcvinfo",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sndnm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sndeml",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"filekey",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rcveml",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"contents",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplmrdpdf",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"itr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ntc_knd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"frt_all_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"frt_clt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"frt_ppd_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"frt_chg_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"frt_arr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hidd_opt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 }];
	                  
	                 InitColumns(cols);
	                 SetSheetHeight(150);
	                 SetVisible(false);
	                 SetEditable(1);
	                 SetCountPosition(0);
                  }
                break;
        }
    }
    // Sheet handling process
    function doActionIBSheet(sheetObj,formObject,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        case IBSEARCH:      //Retrieve
            //formObject.f_cmd.value = SEARCH;
            var sXml=sheetObj.GetSearchData("ESM_BKG_0221GS.do", FormQueryString(formObject));
            por_cd=ComGetEtcData(sXml,"por_cd");
            break;
        case IBSENDEMAILFAX:        // Fax_Email
            var fax=document.getElementById("fax").value;
            var email=document.getElementById("email").value;
            
            if (email != "" && !ComIsEmailAddr(email)) {
                ComShowCodeMessage("BKG00245");
                break;
            }
            if (document.getElementById("ui_id").value == "ESM_BKG_0159" ||
 					document.getElementById("ui_id").value == "ESM_BKG_0079_02C" ||
 					document.getElementById("ui_id").value == "ESM_BKG_0168" ){
                if (""==document.getElementById("fax").value && ""==document.getElementById("email").value) {
                    ComShowCodeMessage("BKG04006");  //The Fax, E-Mail is invalid
                } else {
                	if(parent) opener = parent;
                    opener.sendFaxEmail(fax, email);
                    ComClosePopup(); 
                }
            } else if (document.getElementById("ui_id").value == "ESM_BKG_0927") {
                if (""==document.getElementById("fax").value && ""==document.getElementById("email").value) {
                    ComShowCodeMessage("BKG04006");  //The Fax, E-Mail is invalid
                } else {
                    ParamSet(sheetObj, formObject);
                    //opener.FaxEmailSend(null,null,document.form2.fax_email.value);
                    ComClosePopup(); 
                }
            } else {
                ParamSet(sheetObj, formObject);
            }
            break;
        }
    }
    function ParamSet(sheetObj, formObject) {
        var sheetObject=sheetObjects[0];
        var rdParam="";
        var strPath="";
        var strPdf="";
        var bkg_no=ComReplaceStr(document.getElementById("bkg_no").value, "|", "','");
        var form_type=document.getElementById("form_type").value;
        var form_dataOnly=document.getElementById("form_dataOnly").value;
        var form_manifest=document.getElementById("form_manifest").value;
        var form_hiddeData=document.getElementById("form_hiddeData").value;
        var form_mainOnly=document.getElementById("form_mainOnly").value;
        var form_level=document.getElementById("form_level").value;
        var form_remark=document.getElementById("form_remark").value;
        var form_Cntr=document.getElementById("form_Cntr").value;
        var form_CorrNo=document.getElementById("form_CorrNo").value;
        var form_his_cntr=document.getElementById("form_his_cntr").value;
        var form_his_bkg=document.getElementById("form_his_bkg").value;
        var form_his_mkd=document.getElementById("form_his_mkd").value;
        var form_his_xpt=document.getElementById("form_his_xpt").value;
        var form_his_bl=document.getElementById("form_his_bl").value;
        var form_his_bl_mkd=document.getElementById("form_his_bl_mkd").value;
        var rp=document.getElementById("rp").value;
        var ntc_knd_cd=document.getElementById("ntc_knd_cd").value;
		form_remark=ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(form_remark,"\'","'||CHR(39)||'"),"\"","'||CHR(34)||'"),"\n","'||CHR(10)||'"),"\r","'||CHR(13)||'");
        if ("BL"==ntc_knd_cd) {//DRAFT B/L
            strPath="ESM_BKG_0109_OBL_A4.mrd";
			rdParam="/rv form_bkgNo[( '"+bkg_no+"') ] form_type["+form_type+"] form_dataOnly["+form_dataOnly+"] form_manifest["+form_manifest+"] form_hiddeData["+form_hiddeData+"] form_mainOnly["+form_mainOnly+"] form_level[("+form_level+")] form_remark["+form_remark+"] form_Cntr["+form_Cntr+"] ";
			rdParam += "form_CorrNo[" + form_CorrNo + "] form_his_cntr[" + form_his_cntr + "] form_his_bkg[" + form_his_bkg + "] form_his_mkd[" + form_his_mkd + "] form_his_xpt[" + form_his_xpt + "] form_his_bl[" + form_his_bl + "] form_rqst_via_cd[] form_his_bl_mkd["+form_his_bl_mkd+"] form_path[" + getFileDownPath() + "] form_esig[] form_cpy_esig[] form_knt_flg[] form_count[] /rp [" + rp + "] /riprnmargin";
        } else {
        	strPath="X"==form_manifest || 0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd":"ESM_BKG_0109_OBL_A4.mrd";
            rdParam="/rv form_bkgNo[( '"+bkg_no+"') ] form_type["+form_type+"] form_dataOnly["+form_dataOnly+"] form_manifest["+form_manifest+"] form_hiddeData["+form_hiddeData+"] form_mainOnly["+form_mainOnly+"] form_level[("+form_level+")] form_remark["+form_remark+"] form_Cntr["+form_Cntr+"] ";
            rdParam += "form_CorrNo[" + form_CorrNo + "] form_his_cntr[" + form_his_cntr + "] form_his_bkg[" + form_his_bkg + "] form_his_mkd[" + form_his_mkd + "] form_his_xpt[" + form_his_xpt + "] form_his_bl[" + form_his_bl + "] form_rqst_via_cd[] form_his_bl_mkd["+form_his_bl_mkd+"] form_path[" + getFileDownPath() + "] form_esig[] form_cpy_esig[] form_knt_flg[] form_count[] /rp [" + rp + "] /riprnmargin";
        }
        strPdf="Original.pdf";
        var Row1=sheetObject.DataInsert();
        sheetObject.SetCellValue(Row1, "bkg_no",formObject.bkg_no.value,0);
        sheetObject.SetCellValue(Row1, "bl_no",formObject.bl_no.value,0);
        sheetObject.SetCellValue(Row1, "syscd","BKG",0);
        sheetObject.SetCellValue(Row1, "tmplmrd",strPath,0);
        sheetObject.SetCellValue(Row1, "batchflg","N",0);
        sheetObject.SetCellValue(Row1, "tmplparam",rdParam,0);
        sheetObject.SetCellValue(Row1, "rcvinfo",formObject.fax.value,0);
        sheetObject.SetCellValue(Row1, "tmplmrdpdf",strPdf,0);// change pdf name(RD file name ---> pdf name)
        sheetObject.SetCellValue(Row1, "itr","|$$|",0);
        sheetObject.SetCellValue(Row1, "ntc_knd_cd",ntc_knd_cd,0);
        var Row2=sheetObject.DataInsert();
        sheetObject.SetCellValue(Row2, "bkg_no",formObject.bkg_no.value,0);
        sheetObject.SetCellValue(Row2, "bl_no",formObject.bl_no.value,0);
        sheetObject.SetCellValue(Row2, "syscd","BKG",0);
        sheetObject.SetCellValue(Row2, "tmplmrd",strPath,0);
        sheetObject.SetCellValue(Row2, "batchflg","N",0);
        sheetObject.SetCellValue(Row2, "tmplparam",rdParam,0);
        sheetObject.SetCellValue(Row2, "contents","",0);// Templates for mail, delete the contents
        sheetObject.SetCellValue(Row2, "rcveml",formObject.email.value,0);// Receive e-mail address
        sheetObject.SetCellValue(Row2, "tmplmrdpdf",strPdf,0);// change pdf name(RD file name ---> pdf name)
        sheetObject.SetCellValue(Row2, "itr","|$$|",0);
        sheetObject.SetCellValue(Row2, "ntc_knd_cd",ntc_knd_cd,0);
        if(form_level != null){
        	sheetObject.SetCellValue(Row1, "frt_all_flg","N",0);
        	sheetObject.SetCellValue(Row1, "frt_clt_flg","N",0);
        	sheetObject.SetCellValue(Row1, "frt_ppd_flg","N",0);
        	sheetObject.SetCellValue(Row1, "frt_chg_flg","N",0);
        	sheetObject.SetCellValue(Row1, "frt_arr_flg","N",0);
        	sheetObject.SetCellValue(Row2, "frt_all_flg","N",0);
        	sheetObject.SetCellValue(Row2, "frt_clt_flg","N",0);
        	sheetObject.SetCellValue(Row2, "frt_ppd_flg","N",0);
        	sheetObject.SetCellValue(Row2, "frt_chg_flg","N",0);
        	sheetObject.SetCellValue(Row2, "frt_arr_flg","N",0);
        	if(form_level=="1"){
        		sheetObject.SetCellValue(Row1, "frt_all_flg","Y",0);
        		sheetObject.SetCellValue(Row2, "frt_all_flg","Y",0);
            }else if(form_level=="5"){
            	sheetObject.SetCellValue(Row1, "frt_clt_flg","Y",0);
            	sheetObject.SetCellValue(Row2, "frt_clt_flg","Y",0);
            }else if(form_level=="4"){
            	sheetObject.SetCellValue(Row1, "frt_ppd_flg","Y",0);
            	sheetObject.SetCellValue(Row2, "frt_ppd_flg","Y",0);
            }else if(form_level=="6"){
            	sheetObject.SetCellValue(Row1, "frt_chg_flg","Y",0);
            	sheetObject.SetCellValue(Row2, "frt_chg_flg","Y",0);
            }else if(form_level=="3"){
            	sheetObject.SetCellValue(Row1, "frt_arr_flg","Y",0);
            	sheetObject.SetCellValue(Row2, "frt_arr_flg","Y",0);
            }
        }
        if( form_hiddeData != null){
        	sheetObject.SetCellValue(Row1, "hidd_opt","N",0);
        	sheetObject.SetCellValue(Row2, "hidd_opt","N",0);
            if(form_hiddeData=="Y"){
            	sheetObject.SetCellValue(Row1, "hidd_opt","Y",0);
            	sheetObject.SetCellValue(Row2, "hidd_opt","Y",0);
            }
        }
        FaxEmailSend(sheetObj, formObject);
    }
    function FaxEmailSend(sheetObj, formObject) {
        if (document.getElementById("fax").value == "" && document.getElementById("email").value == "") {
            ComShowCodeMessage("BKG04006");  //The Fax, E-Mail is invalid
        } else {
            ComOpenWait(true);
            formObject.f_cmd.value=SEARCH01;
            var sXml=sheetObj.GetSaveData("ESM_BKG_0221GS.do", FormQueryString(formObject) + "&" + sheetObj.GetSaveString());
            ComOpenWait(false);
            if(sXml.substring(1, 6) == "ERROR"){
                ComShowMessage(ComResultMessage(sXml));
            } else {
                var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
                if ( State == "S" ) {
                    var msg="";
                    if (!ComIsEmpty(document.form2.fax_email)) {
                    	if ("IBSENDFAX"==ComGetObjValue(document.form2.fax_email)) { 
                    		msg += "Fax";
                    	} else if ("IBSENDEMAIL"==ComGetObjValue(document.form2.fax_email)) {
                    		msg += "E-mail";
                    	}
                    } else {
	                    msg += ""!=document.getElementById("fax").value ? "Fax":"";
	                    msg += ""!=msg ? ", ":"";
	                    msg += ""!=document.getElementById("email").value ? "E-mail":"";
                    }
                    ComShowCodeMessage("COM130601",msg);  //{?msg1} was transmitted successfully.
                    ComClosePopup(); 
                }
            }
            sheetObj.RemoveAll();
            return;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
    
    // Function call to the parent window
    function callPopupOK() {

	}
    
    function comPopupOK() {
        if (!opener) opener=parent; 
        var formObj2=document.form2;
        var func=formObj2.elements["func"    ].value;
        var pop_mode=formObj2.elements["pop_mode"].value;
        var sheetIdx=formObj2.elements["sheetIdx"].value;
        var row=formObj2.elements["row"     ].value;
        var col=formObj2.elements["col"     ].value;
        if (""==func) {
        	ComClosePopup(); 
            return;
        } else {
            func=eval("opener."+func);
            var item=document.form.getElementsByTagName("input");
            var rArray=new Array(1);
            rArray[0]=new Array(item.length);
            for (var i=0; i < item.length; i++) {
                if ("text"==item[i].type || "hidden"==item[i].type) {
                    rArray[0][i]=item[i].value;
                }
            }
            try {
                if (""!=row && ""!=col) {
                    if (""!=sheetIdx) {
                        func(rArray,row,col,sheetIdx);
                        ComClosePopup(); 
                    } else {
                        func(rArray,row,col);
                        ComClosePopup(); 
                    }
                } else {
                    func(rArray);
                    ComClosePopup(); 
                }
            } catch(e) {
                ComShowCodeMessage("COM12111");
            }
        }
    }
