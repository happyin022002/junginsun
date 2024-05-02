/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0008.js
*@FileTitle  : Container Vessel 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
function BCM_CCD_0008(){
	this.processButtonClick        = processButtonClick;
	this.getVsl_cd        		   = getVsl_cd;
	this.getCrr_cd                 = getCrr_cd;
	this.getVsl_rgst_cnt_cd        = getVsl_rgst_cnt_cd;
	this.getRgst_port_cd           = getRgst_port_cd;
	this.setSheetObject            = setSheetObject;
	this.setComboObject            = setComboObject;
	this.loadPage                  = loadPage;
	this.initPage                  = initPage;
	this.doActionIBCombo           = doActionIBCombo;
	this.doActionIBSheet           = doActionIBSheet;
	this.validateForm              = validateForm;
	this.initControl               = initControl;
	this.com_change_sheet          = com_change_sheet;
	this.obj_change                = obj_change;
	this.fdr_div_cd_OnChange       = fdr_div_cd_OnChange;
	this.sheet1_OnSearchEnd        = sheet1_OnSearchEnd;
	this.sheet1_OnSaveEnd          = sheet1_OnSaveEnd;
	this.formObj_OnChange          = formObj_OnChange;
}
/** Common global variable */
var sheetObjects=new Array();
var sheetCnt=0;
var saveRows=new Array();

var comboObjects=new Array();
var comboCnt=0;


/** Event handler processing by button click event */
document.onclick=processButtonClick;
/** Event handler processing by button name */

function processButtonClick() {
    /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
    var sheetObj=sheetObjects[0];
    /** **************************************************** */
    var formObj=document.form;
    try {
	     var srcName=ComGetEvent("name");
	        //if(ComGetBtnDisable(srcName)) return false;
	        switch (srcName) {
				case "btn_History":
					var tblNo = 'MDM_VSL_CNTR';
					var vslCd = formObj.vsl_cd.value;
					var mstKey = nullToBlank(vslCd);
					if (mstKey == "") {
						ComShowCodeMessage("CCD00038", "Vessel Code");
					return false;
					}
					comMdmCallPop(tblNo, mstKey); 
					//comMdmCallPop('MDM_CUST_PERF_GRP', 'G-10003175'); 
            	break;
	        
		        case "btn_Retrieve":
		            doActionIBSheet(sheetObj, formObj, IBSEARCH);
		            break;
		        case "btn_Save":
		            doActionIBSheet(sheetObj, formObj, IBSAVE);
		            break;
				case "btn_Create":
					doActionIBSheet(sheetObj,	formObj, IBCREATE);
					break;    
		        case "btn_New":
		            doActionIBSheet(sheetObj, formObj, IBCLEAR);
		            break;
		        case "btn_Close":
		            ComClosePopup(); 
		            break;
		        case "btn_Request":
		            doActionIBSheet(sheetObjects[0], document.form, MULTI03); 
		            break;
		        case "btns_search1": // Vessel Code pop-up
		            if(window.event.srcElement.style.cursor == "default") return;
		            ComOpenPopup('/hanjin/COM_ENS_0A1.do?mdm_yn='+formObj.mdm_yn.value, 680, 420, 'getVsl_cd', "1,0,1,1,1", true, false, 0, 0, 0, "COM_ENS_0A1");
		//            ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0022");
		            break;
		        case "btns_search2": // Carrier pop-up
		            ComOpenPopup('/hanjin/COM_ENS_0N1.do', 600, 420, 'getCrr_cd', "1,0,1", true);
		            break;
		        case "btns_search3": // Flag pop-up
		            ComOpenPopup('/hanjin/COM_ENS_0M1.do', 600, 420, 'getVsl_rgst_cnt_cd', "1,0,1", true);
		            break;
		        case "btns_search4": // Port Of Registry pop-up
		            //ComOpenPopup('/hanjin/COM_ENS_051.do', 1050, 530, 'getRgst_port_cd', "1,0,1", true);
		        	ComOpenPopup('/hanjin/COM_ENS_051.do', 730, 420, 'getRgst_port_cd', "1,0,1", true);
		            break;
	            //-----------------[Calendar button Start]------------------//      
	            case "btns_vsl_kel_ly_dt":
	            case "btns_vsl_lnch_dt":
	            case "btns_vsl_de_dt":
	            case "btns_rgst_dt":
	            case "btns_vsl_clz_dt":
	                var result=srcName.replace("btns_", "");
	                var vCalObj=eval("formObj." + result );
	                var vCal=new ComCalendar();
	                vCal.setDisplayType('date');
	                vCal.select(vCalObj, 'yyyy-MM-dd');
	                break;
	            //-----------------[Calendar button End]------------------//    
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}


function getVsl_cd(rowArray) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var colArray=rowArray[0];
    formObj.vsl_cd.value=colArray[3];
    doActionIBSheet(sheetObj, formObj, IBSEARCH);
}
function getCrr_cd(rowArray) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var colArray=rowArray[0];
    formObj.crr_cd.value=colArray[3];
    document.form.onchange_flag.value = "Y";
    
/* modi_vsl_opr_tp_cd 而щ� 議댁���� ���    
 * if(formObj.crr_cd.value == "NYK"){
    	formObj.modi_vsl_opr_tp_cd.SetSelectCode("07");
    }else{
    	modi_vsl_opr_tp_cd.SetSelectCode("08");
    }*/
}
function getVsl_rgst_cnt_cd(rowArray) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var colArray=rowArray[0];
    formObj.vsl_rgst_cnt_cd.value=colArray[3];
    document.form.onchange_flag.value = "Y";
}
function getRgst_port_cd(rowArray) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var colArray=rowArray[0];
    formObj.rgst_port_cd.value=colArray[3];
    document.form.onchange_flag.value = "Y";
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
 function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
 }
 /**
  * initializing sheet
  * implementing onLoad event handler in body tag
  * adding first-served functions after loading screen.
  */
function loadPage() {
    var formObj = document.form;
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
    doActionIBCombo(sheetObjects[0], formObj, SEARCH01);
    //formObj.fdr_div_cd.Code = "T";
    // auth_tp_cd retrieve
   // doActionIBSheet(sheetObjects[0], formObj, SEARCH10);  no table
    //var authTpCd=G_AHTU_TP_CD;
    var rqstNo=formObj.rqst_no.value;
/*    if(G_MDAA_CHK == 'Y')
        ComEnableObject(formObj.delt_flg, true); 
    else
        ComEnableObject(formObj.delt_flg, false); */
    
    // If the Process Status screen call, in the Detail PopUp
    if(rqstNo != '') {
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        //ComSetDisplay('btn_Close', true);
        var procTpCd=formObj.proc_tp_cd.value;
        var rqstUsrChk=formObj.rqst_usr_chk.value;
        ComEnableObject(formObj.btns_search1, false);
        // Process Type is 'Reject' and AuthType is not 'Approval'(possible modifications and ReOpen)
        if(procTpCd == 'R' &&  ( ((authTpCd == 'R' || authTpCd == 'S') && rqstUsrChk == 'Y') || G_MDAA_CHK == 'Y') ) {
            ComSetDisplay('btn_Request', true);
            ComGetObject("btn_Request").style.setProperty("color", "#FF0000", "important");
            ComSetDisplay('btn_Retrieve', true);
            ComSetDisplay('btn_Save', true);
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        } else if(procTpCd == 'A') {    
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            ComEnableObject(formObj.btns_search1, false);
        } else {
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }
    } else {
        ComSetDisplay('btn_Retrieve', true);
        ComBtnDisable('btn_Save');
        // MDM Authority is not Approval('A') or MDDA
        if( authTpCd == 'R' || authTpCd == 'S' || G_MDAA_CHK == 'Y') {
            ComSetDisplay('btn_New', true);
            ComSetDisplay('btn_Save', true);
        } else {
            //General User if you do not have MDM Authority
            ComSetDisplay('btn_New', true);
        }
    }
}
function initPage() {
    var formObj=document.form;
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
}
/**
* All the combo box query
*/
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
    switch (sAction) {
        case SEARCH01: // load page
        	var sXml=sheetObj.GetSearchXml("BCM_CCD_0008GS.do", "f_cmd=" + SEARCH01);
        	var arrXml=sXml.split("|$$|");
        	var comboXml=ComXml2ComboString(arrXml[4], "cd_desc", "cd");
        	var textCol ="cd|cd_desc";
        	var codeCol="cd";
        	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(arrXml[4]);
			var xmlRoot = xmlDoc.documentElement;
			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var dataChildNodes = dataNode.childNodes;
			var colListIdx = Array();
			var arrText = textCol.split("|");
			for (var i = 0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0] = i;
				}
				for (var j = 0; j < arrText.length; j++) {
					if (colArr[i] == arrText[j]) {
						colListIdx[j+1] = i;

					}
				}
			}

			for (var i = 0; i < dataChildNodes.length-1; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				
				var arrData = dataChildNodes[i+1].firstChild.nodeValue.split(sep);
				var item = "";
				for (var j = 1; j < colListIdx.length; j++) {
					//item += arrData[colListIdx[j]];
					item += arrData[colListIdx[j]];
					if (j < colListIdx.length - 1) {
						item += "|";
					}
				}
				formObj.fdr_div_cd.InsertItem(i, item, arrData[colListIdx[0]]);
			}
        	
        	
        	if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0], formObj.vsl_own_ind_cd, "cd", "cd|cd_desc");
			if (arrXml.length > 1) 
			ComXml2ComboItem(arrXml[1], formObj.clss_no_rgst_area_nm, "cd", "cd|cd_desc");
			if (arrXml.length > 2) 
				ComXml2ComboItem(arrXml[2], formObj.vsl_bld_cd, "cd", "cd|cd_desc");
/*			if (arrXml.length > 4) 
				ComXml2ComboItem(arrXml[4], formObj.fdr_div_cd, "cd", "cd|cd_desc");*/

/*                var comboXml=ComXml2ComboString(arrXml[4], "cd_desc", "cd");
                var cdName=comboXml[0].split("|");
                var cdValue=comboXml[1].split("|");
                for (var j=0; j < cdName.length; j++) {
                		comboObjects[4].InsertItem(j, cdName[j], cdValue[j].substring(0,1));
                		//ComXml2ComboItem(arrXml[4], formObj.fdr_div_cd, cdName[j], cdValue[j]);
                	}*/
            
        break;
    }
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetObj.id) {
    case "sheet1":  // sheet1 init
        with(sheetObj){
    	      //Host��낫 �ㅼ�[���][HostIp, Port, PagePath]
	          if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	          //style.height = 120;
	          
	          InitRowInfo( 1, 1, 5, 100);
	         
	          InitColumnInfo(89, 0, 0, true);
	
              // �대���� 泥�━������� 媛�� 湲곕����ㅼ����
              InitHeadMode(false, true, true, false, false, false);

    	
              var HeadTitle="VSL_CD|VSL_CLSS_FLG|VSL_ENG_NM|VSL_LOCL_NM|FOIL_CAPA|DOIL_CAPA|FRSH_WTR_CAPA|CALL_SGN_NO|RGST_NO|PHN_NO|FAX_NO|TLX_NO|VSL_EML|PICLB_DESC|RGST_PORT_CD|CLSS_NO_RGST_AREA_NM|VSL_CLSS_NO|VSL_BLDR_NM|LOA_LEN|LBP_LEN|VSL_WDT|VSL_DPTH|SMR_DRFT_HGT|DWT_WGT|LGT_SHP_TONG_WGT|GRS_RGST_TONG_WGT|NET_RGST_TONG_WGT|PNM_GT_WGT|PNM_NET_TONG_WGT|SUZ_GT_WGT|SUZ_NET_TONG_WGT|MN_ENG_MKR_NM|MN_ENG_TP_DESC|MN_ENG_BHP_PWR|VSL_OWN_IND_CD|VSL_RGST_CNT_CD|VSL_BLD_CD|CRR_CD|FDR_DIV_CD|VSL_SVC_SPD|MAX_SPD|ECN_SPD|CRW_KNT|CNTR_DZN_CAPA|CNTR_OP_CAPA|CNTR_PNM_CAPA|CNTR_VSL_CLSS_CAPA|RF_RCPT_KNT|RF_RCPT_MAX_KNT|FBD_CAPA|DPL_CAPA|BLST_TNK_CAPA|FOIL_CSM|DOIL_CSM|FRSH_WTR_CSM|MN_ENG_RPM_PWR|GNR_RPM_PWR|VSL_HGT|RGST_DT|VSL_EDI_NM|CO_CD|VSL_CLZ_DT|VSL_BLD_AREA_NM|GNR_MKR_NM|GNR_TP_DESC|GNR_BHP_PWR|BWTHST_MKR_NM|BWTHST_TP_DESC|BWTHST_BHP_PWR|BWTHST_RPM_PWR|LLOYD_NO|VSL_LNCH_DT|VSL_DE_DT|VSL_KEL_LY_DT|VSL_HL_NO|TTL_TEU_KNT|VSL_HTCH_KNT|VSL_HLD_KNT|VSL_RMK|INTL_TONG_CERTI_FLG|MADN_VOY_SUZ_NET_TONG_WGT|VSL_SFT_CSTRU_CERTI_EXP_DT|VSL_SFT_RDO_CERTI_EXP_DT|VSL_SFT_EQ_CERTI_EXP_DT|VSL_LOD_LINE_CERTI_EXP_DT|VSL_DERAT_CERTI_EXP_DT|DELT_FLG|MODI_VSL_CD";
              //var prefix="sheet1_";
              
              //�대����蹂����][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
              InitHeadRow(0, HeadTitle, true);
             
              //InitHeaders(headers, info);
			 InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true, "ibflag" );
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_cd",                    false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_clss_flg",              false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_eng_nm",                false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_locl_nm",               false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "foil_capa",                 false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "doil_capa",                 false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "frsh_wtr_capa",             false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "call_sgn_no",               false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "rgst_no",                   false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "phn_no",                    false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "fax_no",                    false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "tlx_no",                    false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_eml",                   false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "piclb_desc",                false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "rgst_port_cd",              false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "clss_no_rgst_area_nm",      false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_clss_no",               false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_bldr_nm",               false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "loa_len",                   false,          "",      	dfNullFloat, 2,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "lbp_len",                   false,          "",      	dfNullFloat, 2,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_wdt",                   false,          "",      	dfNullFloat, 2,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_dpth",                  false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "smr_drft_hgt",              false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "dwt_wgt",                   false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "lgt_shp_tong_wgt",          false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "grs_rgst_tong_wgt",         false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "net_rgst_tong_wgt",         false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "pnm_gt_wgt",                false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "pnm_net_tong_wgt",          false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "suz_gt_wgt",                false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "suz_net_tong_wgt",          false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "mn_eng_mkr_nm",             false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "mn_eng_tp_desc",            false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "mn_eng_bhp_pwr",            false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_own_ind_cd",            false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_rgst_cnt_cd",           false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_bld_cd",                false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "crr_cd",                    false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "fdr_div_cd",                false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_svc_spd",               false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "max_spd",                   false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "ecn_spd",                   false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "crw_knt",                   false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "cntr_dzn_capa",             false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "cntr_op_capa",              false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "cntr_pnm_capa",             false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "cntr_vsl_clss_capa",        false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "rf_rcpt_knt",               false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "rf_rcpt_max_knt",           false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "fbd_capa",                  false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "dpl_capa",                  false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "blst_tnk_capa",             false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "foil_csm",                  false,          "",      	dfNullFloat, 4,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "doil_csm",                  false,          "",      	dfNullFloat, 4,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "frsh_wtr_csm",              false,          "",      	dfNullFloat, 0,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "mn_eng_rpm_pwr",            false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "gnr_rpm_pwr",               false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_hgt",                   false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "rgst_dt",                   false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_edi_nm",                false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "co_cd",                     false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_clz_dt",                false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_bld_area_nm",           false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "gnr_mkr_nm",                false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "gnr_tp_desc",               false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "gnr_bhp_pwr",               false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "bwthst_mkr_nm",             false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "bwthst_tp_desc",            false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "bwthst_bhp_pwr",            false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "bwthst_rpm_pwr",            false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "lloyd_no",                  false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_lnch_dt",               false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_de_dt",                 false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_kel_ly_dt",             false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_hl_no",                 false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "ttl_teu_knt",               false,          "",      	dfNullFloat, 5,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_htch_knt",              false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_hld_knt",               false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "vsl_rmk",                   false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "intl_tong_certi_flg",       false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "madn_voy_suz_net_tong_wgt", false,          "",      	dfNullFloat, 3,     true,       true,	13);
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "delt_flg",                  false,          "",      	dfNone, 2,     true,       true);	
  			 //InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "modi_vsl_cd",               false,          "",      	dfNone, 2,     true,       true);	
  			 InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "cre_usr_id",   false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "cre_dt",       false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "upd_usr_id",   false,          "",      	dfNone, 2,     true,       true);	
             InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "upd_dt",       false,          "",      	dfNone, 2,     true,       true);	
             //InitDataProperty(0, cnt++ , dtData, 30,    daCenter,  true, "modi_vsl_opr_tp_cd",       false,          "",      	dfNullFloat, 0,     true,       true,	13);

            }
        break;
    }
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    //sheetObj.ShowDebugMsg(false);
    switch (sAction) {
    case IBCREATE: // New retrieve
    	doActionIBSheet(sheetObj, formObj, IBCLEAR);
    	ComBtnDisable('btn_Create');
    	break;

    case IBSEARCH: // Retrieve
        if (validateForm(sheetObj, formObj, sAction)){
            if( formObj.rqst_no.value == ''){
                formObj.f_cmd.value=SEARCH;
            }else{
                formObj.f_cmd.value=SEARCH05;
            }
            ComOpenWait(true);
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0008GS.do", FormQueryString(formObj));
            var arrXml = sXml.split("|$$|");
            var rqstNo=ComGetEtcData(sXml, "RQST_NO");
            var vslCd=ComGetEtcData(sXml, "VSL_CD");
            ComOpenWait(false);
            if (vslCd != undefined) {
            	sheetObjects[0].LoadSearchXml(arrXml[0]);
            	formObj.creflag.value="N";
            	formObj.ibflag.value = "U";
            	
            }else{
                formObj.creflag.value="Y";
                formObj.ibflag.value="I";
                if(!ComShowConfirm(ComGetMsg("CCD00034", "Vessel Code"))){
                    doActionIBSheet(sheetObj, formObj, IBCLEAR);
                }else{
                	ComBtnDisable('btn_Create');
                }
                	
            }
        }
        break;
    case SEARCH02: // Carrier Code checking
        if (validateForm(sheetObj, formObj, sAction)){
            formObj.f_cmd.value=SEARCH02;
            ComOpenWait(true);
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0008GS.do", FormQueryString(formObj));
            
            var result=ComGetEtcData(sXml, "result");

            if(result == ""){
                ComShowCodeMessage("COM130402", "Carrier");
                formObj.crr_cd.value = "";
                formObj.crr_cd.focus();
            }
                ComOpenWait(false);
        }
        break;
    case SEARCH03: // Country Code checking
        if (validateForm(sheetObj, formObj, sAction)){
            formObj.f_cmd.value=SEARCH03;
            ComOpenWait(true);
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0008GS.do", FormQueryString(formObj));
            var result=ComGetEtcData(sXml, "result");
                if(result==""){
                    ComShowCodeMessage("COM130402", "Flag");
                    formObj.vsl_rgst_cnt_cd.value="";
                    formObj.vsl_rgst_cnt_cd.focus();
                }
                ComOpenWait(false);
        }
        break;
    case SEARCH04: // Port Code checking
        if (validateForm(sheetObj, formObj, sAction)){
            formObj.f_cmd.value=SEARCH04;
            ComOpenWait(true);
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0008GS.do", FormQueryString(formObj));
            var result=ComGetEtcData(sXml, "result");
                if(result==""){
                    ComShowCodeMessage("COM130402", "Port Of Registry");
                    formObj.rgst_port_cd.value="";
                    formObj.rgst_port_cd.focus();
                }
                ComOpenWait(false);
        }
        break;
    case SEARCH10: // MDM AUTH_TP_CD query
        var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=VESL';
        var sXml=sheetObj.GetSearchXml("BCM_CCD_2002GS.do", sParam);
        // global var sestting
        G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
        G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
        break;
    case IBSAVE: // Save
        if(validateForm(sheetObj, formObj, sAction)){
        	
        	 formObj.foil_capa.value = ComReplaceStr(formObj.foil_capa,",","");
             formObj.doil_capa.value = ComReplaceStr(formObj.doil_capa,",","");
             formObj.frsh_wtr_capa.value = ComReplaceStr(formObj.frsh_wtr_capa,",","");
             formObj.loa_len.value = ComReplaceStr(formObj.loa_len,",","");
             formObj.lbp_len.value = ComReplaceStr(formObj.lbp_len,",","");
             formObj.vsl_wdt.value = ComReplaceStr(formObj.vsl_wdt,",","");
             formObj.vsl_dpth.value = ComReplaceStr(formObj.vsl_dpth,",","");
             formObj.smr_drft_hgt.value = ComReplaceStr(formObj.smr_drft_hgt,",","");
             formObj.dwt_wgt.value = ComReplaceStr(formObj.dwt_wgt,",","");
             formObj.lgt_shp_tong_wgt.value = ComReplaceStr(formObj.lgt_shp_tong_wgt,",","");
             formObj.grs_rgst_tong_wgt.value = ComReplaceStr(formObj.grs_rgst_tong_wgt,",","");
             formObj.net_rgst_tong_wgt.value = ComReplaceStr(formObj.net_rgst_tong_wgt,",","");
             formObj.pnm_gt_wgt.value = ComReplaceStr(formObj.pnm_gt_wgt,",","");
             formObj.pnm_net_tong_wgt.value = ComReplaceStr(formObj.pnm_net_tong_wgt,",","");
             formObj.suz_gt_wgt.value = ComReplaceStr(formObj.suz_gt_wgt,",","");
             formObj.suz_net_tong_wgt.value = ComReplaceStr(formObj.suz_net_tong_wgt,",","");
             formObj.mn_eng_bhp_pwr.value = ComReplaceStr(formObj.mn_eng_bhp_pwr,",","");
             formObj.crw_knt.value = ComReplaceStr(formObj.crw_knt,",","");
             formObj.cntr_dzn_capa.value = ComReplaceStr(formObj.cntr_dzn_capa,",","");
             formObj.cntr_op_capa.value = ComReplaceStr(formObj.cntr_op_capa,",","");
             formObj.cntr_pnm_capa.value = ComReplaceStr(formObj.cntr_pnm_capa,",","");
             formObj.cntr_vsl_clss_capa.value = ComReplaceStr(formObj.cntr_vsl_clss_capa,",","");
             formObj.rf_rcpt_knt.value = ComReplaceStr(formObj.rf_rcpt_knt,",","");
             formObj.rf_rcpt_max_knt.value = ComReplaceStr(formObj.rf_rcpt_max_knt,",","");
             formObj.fbd_capa.value = ComReplaceStr(formObj.fbd_capa,",","");
             formObj.dpl_capa.value = ComReplaceStr(formObj.dpl_capa,",","");
             formObj.blst_tnk_capa.value = ComReplaceStr(formObj.blst_tnk_capa,",","");
             formObj.foil_csm.value = ComReplaceStr(formObj.foil_csm,",","");
             formObj.doil_csm.value = ComReplaceStr(formObj.doil_csm,",","");
             formObj.frsh_wtr_csm.value = ComReplaceStr(formObj.frsh_wtr_csm,",","");
             formObj.mn_eng_rpm_pwr.value = ComReplaceStr(formObj.mn_eng_rpm_pwr,",","");
             formObj.gnr_rpm_pwr.value = ComReplaceStr(formObj.gnr_rpm_pwr,",","");
             formObj.vsl_hgt.value = ComReplaceStr(formObj.vsl_hgt,",","");
             formObj.gnr_bhp_pwr.value = ComReplaceStr(formObj.gnr_bhp_pwr,",","");
             formObj.bwthst_bhp_pwr.value = ComReplaceStr(formObj.bwthst_bhp_pwr,",","");
             formObj.bwthst_rpm_pwr.value = ComReplaceStr(formObj.bwthst_rpm_pwr,",","");
             formObj.ttl_teu_knt.value = ComReplaceStr(formObj.ttl_teu_knt,",","");
             formObj.vsl_htch_knt.value = ComReplaceStr(formObj.vsl_htch_knt,",","");
             formObj.vsl_hld_knt.value = ComReplaceStr(formObj.vsl_hld_knt,",","");
             formObj.madn_voy_suz_net_tong_wgt.value = ComReplaceStr(formObj.madn_voy_suz_net_tong_wgt,",","");

             formObj.f_cmd.value = MULTI;

            var tmpMsg="";
            if(formObj.creflag.value != "N" && formObj.rqst_no.value == ''){
                tmpMsg="CCD00035";
            }else{
                tmpMsg="COM130101";
            }
            var sParam=FormQueryString(formObj);
            if(ComShowConfirm(ComGetMsg(tmpMsg, "data"))){
                ComOpenWait(true);
                var sXml=sheetObj.GetSaveXml("BCM_CCD_0008GS.do",  sParam);
                var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                if(result != "F"){
                        ComShowCodeMessage("COM130102", "Data");
                        doActionIBSheet(sheetObj, formObj, IBSEARCH);
                }else{
                    ComShowCodeMessage("COM130103", "data");
                }
                ComOpenWait(false);
                var rqstNo=ComGetEtcData(sXml, "RQST_NO");
                ComSetObjValue(formObj.rqst_no, rqstNo);
            }
        }
        break;
    case MULTI03:   // Request
    	return;
        if (!ComShowCodeConfirm("CCD00030")) {
            return;
        }
        var sParam='f_cmd=' + MULTI03 + '&rqst_no=' + ComGetObjValue(formObj.rqst_no) + '&rqst_ofc_cd=' + ComGetObjValue(formObj.rqst_ofc_cd) + '&proc_tp_cd=O';
        var sXml=sheetObj.GetSaveData("BCM_CCD_2002GS.do", sParam);
        var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
        if(sav == "S"  ){
            ComShowCodeMessage("CCD00031");
            ComPopUpReturnValue("Y");
            ComClosePopup(); 
        } else {
            ComShowCodeMessage("COM130103", "Data");
        }
        break;
    case IBCLEAR:
        sheetObj.RemoveAll();
        formObj.reset();
        formObj.vsl_cd.readOnly=false;
        formObj.vsl_own_ind_cd.text="";
        formObj.vsl_bld_cd.text="";
        //clss_no_rgst_area_nm.text="";
        formObj.fdr_div_cd.text="";
        formObj.clss_no_rgst_area_nm.text="";
        formObj.rqst_no.value="";
        formObj.ibflag.value="I";
        ComEnableObject(form.btns_search1, true);
        formObj.vsl_cd.className = "input1";
        document.form.onchange_flag.value = "N";
        ComBtnEnable('btn_Create');

        //formObj.modi_vsl_cd.className = "input1";
        //modi_vsl_opr_tp_cd.SetBackColor("#FFFFFF");
        break;
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
         switch ( sAction ) {
             case IBSEARCH:
                 if (formObj.vsl_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Vessel Code");
                     formObj.vsl_cd.focus();
                     return false;
                 }
                 if (formObj.vsl_cd.value.length != 4){
                     ComShowCodeMessage("CCD00044");
                     formObj.vsl_cd.focus();
                     return false;
                 }
                 break;
             case IBSAVE:  
                 if (formObj.vsl_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Vessel Code");
                     formObj.vsl_cd.focus();
                     return false;
                 } else if (formObj.vsl_eng_nm.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Vessel Name(ENG)");
                     formObj.vsl_eng_nm.focus();
                     return false;
                 }else if (formObj.crr_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Carrier");
                     formObj.crr_cd.focus();
                     return false;
                 }else if (formObj.call_sgn_no.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Call Sign");
                     formObj.call_sgn_no.focus();
                     return false;
                 }else if (formObj.vsl_rgst_cnt_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Flag");
                     formObj.vsl_rgst_cnt_cd.focus();
                     return false;
                 }else if (formObj.lloyd_no.value.length == 0){
                     ComShowCodeMessage("CCD00001", "IMO No(LLOYD No)");
                     formObj.lloyd_no.focus();
                     return false;
                 }else if (formObj.grs_rgst_tong_wgt.value.length == 0){
                     ComShowCodeMessage("CCD00001", "International Gross Ton");
                     formObj.grs_rgst_tong_wgt.focus();
                     return false;
                 }else if (formObj.net_rgst_tong_wgt.value.length == 0){
                     ComShowCodeMessage("CCD00001", "International Net Ton");
                     formObj.net_rgst_tong_wgt.focus();
                     return false;
                 }else if (formObj.fdr_div_cd.value == ""){
                	 ComShowCodeMessage("CCD00001", "Feeder Division");
                     return false;
                 }/*else if (modi_vsl_opr_tp_cd.GetSelectCode() == ""){
                	 if(fdr_div_cd.GetSelectCode() == "T"){
                		 ComShowCodeMessage("CCD00001", "VIP Ope. Kind");
                         return false;
                	 }
                 }else if (formObj.modi_vsl_cd.value.length == 0){
                     if(formObj.vsl_clss_flg.value != "Y"){
                    	 ComShowCodeMessage("CCD00001", "VIP Code");
                         formObj.modi_vsl_cd.focus();
                         return false;
                     }
                     if(formObj.modi_vsl_cd.value.length != 3){
                    	 ComShowCodeMessage("CCD00049");
                    	 formObj.modi_vsl_cd.focus();
                 	     return false;
                     }
                 }*/
                 if(formObj.onchange_flag.value != "Y") {
                     ComShowCodeMessage("COM130503");
                     return;
                  }
                 
                 if (formObj.vsl_cd.value.length != 4){
                     ComShowCodeMessage("CCD00044");
                     formObj.vsl_cd.focus();
                     return false;
                 }
                 
                 if (formObj.cntr_vsl_clss_capa.value.length == 0){
                	 ComShowCodeMessage("CCD00001", "Vessel Class(TEU)");
                     formObj.cntr_vsl_clss_capa.focus();
                     return false;
                 }
                 
                 if (formObj.vsl_svc_spd.value.length == 0){
                	 ComShowCodeMessage("CCD00001", "Service");
                     formObj.vsl_svc_spd.focus();
                     return false;
                 }
                 
                 break;
         }
//     }
     return true;    
 }
function initControl() {
    var formObj=document.form;
    axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj);
    axon_event.addListenerForm('change', 'obj_change', formObj);
    axon_event.addListener('blur', 'isEmailAddr', 'vsl_eml');
    //axon_event.addListenerForm('change', 'formObj_OnChange', formObj);
    //axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);
    //axon_event.addListenerForm('focus', 'obj_activate', formObj);
    //axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
    //axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd');
}
/**
 * When you change the value of the hidden Sheet Html Object to reflect the changed value.<br>
 */  
function com_change_sheet( sheetObj, colNm ){
    var formObj=document.form;
    var eleValue="";
    if(document.getElementById(colNm).type=="text"){
        switch(colNm){
            default:
                eleValue=document.getElementById(colNm).value;    
                break;                  
        }           
        sheetObj.SetCellValue(1,colNm,eleValue);
    }else{
        sheetObj.SetCellValue(1,colNm,document.getElementById(colNm).GetSelectCode());
    }
}   
/**
* If the data field to be the change event
*/
function obj_change(){

    var formObj=document.form;
    var sheetObj=sheetObjects[0];
	formObj.onchange_flag.value = "Y";
    //processButtonClick(); 
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
        case "vsl_cd":
           if(formObj.vsl_cd.value.length >0){
                doActionIBSheet(sheetObj, formObj, IBSEARCH);
            }
        break;
        case "crr_cd":
            if(formObj.crr_cd.value.length>0 && formObj.onchange_flag.value =="Y"){
                doActionIBSheet(sheetObj, formObj, SEARCH02);
                
            }
        break;
        case "vsl_rgst_cnt_cd":
            if(formObj.vsl_rgst_cnt_cd.value.length>0){
                doActionIBSheet(sheetObj, formObj, SEARCH03);
            }
        break;
        case "rgst_port_cd":
            if(formObj.rgst_port_cd.value.length>0){
                doActionIBSheet(sheetObj, formObj, SEARCH04);
            }
        break;
        case "delt_flg":
            if (formObj.delt_flg.value == 'Y'){
                var checkFirm=ComShowConfirm(ComGetMsg("CCD00012"));
                if (checkFirm == 1){
                    formObj.delt_flg.value='Y';
                    
                }else{
                    formObj.delt_flg.value='N';
                }
            }
        break;
        case "vsl_clss_flg":
        	if(formObj.vsl_clss_flg.value == "Y"){
        		formObj.modi_vsl_cd.className = "input";
        	}else{
        		formObj.modi_vsl_cd.className = "input1";
        	}
        break;
        case "modi_vsl_cd":
        	if(formObj.modi_vsl_cd.value != "" && formObj.modi_vsl_cd.value.length != 3){
        		ComShowCodeMessage("CCD00049");
        		formObj.modi_vsl_cd.focus();
        		return;
        	}else if(formObj.modi_vsl_cd.value == 3){
        	}
        	
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
   * Change the selected Item IBMulti Combo is an event that occurs when.<br>
   */   
/*function fdr_div_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    var arrText=newText.split("|");
    
  if (arrText != null && arrText.length > 1) {
      formObj.fdr_div_cd.value=comboObj.GetText(oldCode, 1);
  }
    com_change_sheet( sheetObj, "fdr_div_cd" );
    if(newCode == 'O'){
         formObj.vsl_clss_flg.value='Y';
         modi_vsl_opr_tp_cd.SetBackColor("#FFFFFF");
      }else {
         formObj.vsl_clss_flg.value='N';
         if(newCode == 'T'){
      	   modi_vsl_opr_tp_cd.SetBackColor("#d4f6ff");
         }else{
      	   modi_vsl_opr_tp_cd.SetBackColor("#FFFFFF");
         }
      }
 } */
 function sheet1_OnSearchEnd(sheet1, ErrMsg){
     ComOpenWait(false);
     var formObj = document.form;   
    if (sheet1.RowCount> 0){
        formObj.vsl_cd.value =sheet1.CellValue(1,'vsl_cd');
        formObj.vsl_clss_flg.Code=sheet1.CellValue(1,'vsl_clss_flg');      
        formObj.vsl_eng_nm.value = sheet1.CellValue(1,'vsl_eng_nm');
        formObj.vsl_locl_nm.value = sheet1.CellValue(1,'vsl_locl_nm');
        formObj.foil_capa.value = ComAddComma(sheet1.CellValue(1,'foil_capa'));
        formObj.doil_capa.value = ComAddComma(sheet1.CellValue(1,'doil_capa'));
        formObj.frsh_wtr_capa.value = ComAddComma(sheet1.CellValue(1,'frsh_wtr_capa'));
        formObj.call_sgn_no.value = sheet1.CellValue(1,'call_sgn_no');
        formObj.rgst_no.value = sheet1.CellValue(1,'rgst_no');
        formObj.phn_no.value = sheet1.CellValue(1,'phn_no');
        formObj.fax_no.value = sheet1.CellValue(1,'fax_no');
        formObj.tlx_no.value = sheet1.CellValue(1,'tlx_no');
        formObj.vsl_eml.value = sheet1.CellValue(1,'vsl_eml');
        formObj.piclb_desc.value = sheet1.CellValue(1,'piclb_desc');
        formObj.rgst_port_cd.value = sheet1.CellValue(1,'rgst_port_cd');
        formObj.clss_no_rgst_area_nm.Code = sheet1.CellValue(1,'clss_no_rgst_area_nm');
        //formObj.clss_no_rgst_area_nm.Code = sheet1.CellValue(1,'clss_no_rgst_area_nm');
        formObj.vsl_clss_no.value = sheet1.CellValue(1,'vsl_clss_no');
        formObj.vsl_bldr_nm.value = sheet1.CellValue(1,'vsl_bldr_nm');
        formObj.loa_len.value = ComAddComma(sheet1.CellValue(1,'loa_len'));
        formObj.lbp_len.value = ComAddComma(sheet1.CellValue(1,'lbp_len'));
        formObj.vsl_wdt.value = ComAddComma(sheet1.CellValue(1,'vsl_wdt'));
        formObj.vsl_dpth.value = ComAddComma(sheet1.CellValue(1,'vsl_dpth'));
        formObj.smr_drft_hgt.value = ComAddComma(sheet1.CellValue(1,'smr_drft_hgt'));
        formObj.dwt_wgt.value = ComAddComma(sheet1.CellValue(1,'dwt_wgt'));
        formObj.lgt_shp_tong_wgt.value = ComAddComma(sheet1.CellValue(1,'lgt_shp_tong_wgt'));
        formObj.grs_rgst_tong_wgt.value = ComAddComma(sheet1.CellValue(1,'grs_rgst_tong_wgt'));
        formObj.net_rgst_tong_wgt.value = ComAddComma(sheet1.CellValue(1,'net_rgst_tong_wgt'));
        formObj.pnm_gt_wgt.value = ComAddComma(sheet1.CellValue(1,'pnm_gt_wgt'));
        formObj.pnm_net_tong_wgt.value = ComAddComma(sheet1.CellValue(1,'pnm_net_tong_wgt'));
        formObj.suz_gt_wgt.value = ComAddComma(sheet1.CellValue(1,'suz_gt_wgt'));
        formObj.suz_net_tong_wgt.value = ComAddComma(sheet1.CellValue(1,'suz_net_tong_wgt'));
        formObj.mn_eng_mkr_nm.value = sheet1.CellValue(1,'mn_eng_mkr_nm');
        formObj.mn_eng_tp_desc.value = sheet1.CellValue(1,'mn_eng_tp_desc');
        formObj.mn_eng_bhp_pwr.value = ComAddComma(sheet1.CellValue(1,'mn_eng_bhp_pwr'));
        formObj.vsl_own_ind_cd.Code = sheet1.CellValue(1,'vsl_own_ind_cd');
        //formObj.clss_no_rgst_area_nm.Code = sheet1.CellValue(1,'vsl_own_ind_cd');
        formObj.vsl_rgst_cnt_cd.value  = sheet1.CellValue(1,'vsl_rgst_cnt_cd');
        formObj.vsl_bld_cd.Code = sheet1.CellValue(1,'vsl_bld_cd');
        formObj.crr_cd.value = sheet1.CellValue(1,'crr_cd');
        formObj.fdr_div_cd.Code = sheet1.CellValue(1,'fdr_div_cd');
        formObj.vsl_svc_spd.value = sheet1.CellValue(1,'vsl_svc_spd');
        formObj.max_spd.value = sheet1.CellValue(1,'max_spd');
        formObj.ecn_spd.value = sheet1.CellValue(1,'ecn_spd');
        formObj.crw_knt.value = ComAddComma(sheet1.CellValue(1,'crw_knt'));
        formObj.cntr_dzn_capa.value = ComAddComma(sheet1.CellValue(1,'cntr_dzn_capa'));
        formObj.cntr_op_capa.value = ComAddComma(sheet1.CellValue(1,'cntr_op_capa'));
        formObj.cntr_pnm_capa.value = ComAddComma(sheet1.CellValue(1,'cntr_pnm_capa'));
        formObj.cntr_vsl_clss_capa.value = ComAddComma(sheet1.CellValue(1,'cntr_vsl_clss_capa'));
        formObj.rf_rcpt_knt.value = ComAddComma(sheet1.CellValue(1,'rf_rcpt_knt'));
        formObj.rf_rcpt_max_knt.value = ComAddComma(sheet1.CellValue(1,'rf_rcpt_max_knt'));
        formObj.fbd_capa.value = ComAddComma(sheet1.CellValue(1,'fbd_capa'));
        formObj.dpl_capa.value = ComAddComma(sheet1.CellValue(1,'dpl_capa'));
        formObj.blst_tnk_capa.value = ComAddComma(sheet1.CellValue(1,'blst_tnk_capa'));
        formObj.foil_csm.value = ComAddComma(sheet1.CellValue(1,'foil_csm'));
        formObj.doil_csm.value = ComAddComma(sheet1.CellValue(1,'doil_csm'));
        formObj.frsh_wtr_csm.value = ComAddComma(sheet1.CellValue(1,'frsh_wtr_csm'));
        formObj.mn_eng_rpm_pwr.value = ComAddComma(sheet1.CellValue(1,'mn_eng_rpm_pwr'));
        formObj.gnr_rpm_pwr.value = ComAddComma(sheet1.CellValue(1,'gnr_rpm_pwr'));
        formObj.vsl_hgt.value = ComAddComma(sheet1.CellValue(1,'vsl_hgt'));
        formObj.rgst_dt.value = sheet1.CellValue(1,'rgst_dt');
        formObj.vsl_edi_nm.value = sheet1.CellValue(1,'vsl_edi_nm');
        formObj.co_cd.value  = sheet1.CellValue(1,'co_cd');
        formObj.vsl_clz_dt.value = sheet1.CellValue(1,'vsl_clz_dt');
        formObj.vsl_bld_area_nm.value = sheet1.CellValue(1,'vsl_bld_area_nm');
        formObj.gnr_mkr_nm.value = sheet1.CellValue(1,'gnr_mkr_nm');
        formObj.gnr_tp_desc.value = sheet1.CellValue(1,'gnr_tp_desc');
        formObj.gnr_bhp_pwr.value = ComAddComma(sheet1.CellValue(1,'gnr_bhp_pwr'));
        formObj.bwthst_mkr_nm.value = sheet1.CellValue(1,'bwthst_mkr_nm');
        formObj.bwthst_tp_desc.value = sheet1.CellValue(1,'bwthst_tp_desc');
        formObj.bwthst_bhp_pwr.value = ComAddComma(sheet1.CellValue(1,'bwthst_bhp_pwr'));
        formObj.bwthst_rpm_pwr.value = ComAddComma(sheet1.CellValue(1,'bwthst_rpm_pwr'));
        formObj.lloyd_no.value = sheet1.CellValue(1,'lloyd_no');
        formObj.vsl_lnch_dt.value = sheet1.CellValue(1,'vsl_lnch_dt');
        formObj.vsl_de_dt.value = sheet1.CellValue(1,'vsl_de_dt');
        formObj.vsl_kel_ly_dt.value = sheet1.CellValue(1,'vsl_kel_ly_dt');
        formObj.vsl_hl_no.value = sheet1.CellValue(1,'vsl_hl_no');
        formObj.ttl_teu_knt.value = ComAddComma(sheet1.CellValue(1,'ttl_teu_knt'));
        formObj.vsl_htch_knt.value = ComAddComma(sheet1.CellValue(1,'vsl_htch_knt'));
        formObj.vsl_hld_knt.value = ComAddComma(sheet1.CellValue(1,'vsl_hld_knt'));
        formObj.vsl_rmk.value = sheet1.CellValue(1,'vsl_rmk');
        formObj.intl_tong_certi_flg.value = sheet1.CellValue(1,'intl_tong_certi_flg');
        formObj.madn_voy_suz_net_tong_wgt.value = ComAddComma(sheet1.CellValue(1,'madn_voy_suz_net_tong_wgt'));
        formObj.delt_flg.value = sheet1.CellValue(1,'delt_flg');
        formObj.modi_vsl_cd.value = sheet1.CellValue(1,'modi_vsl_cd');
        formObj.cre_usr_id.value = sheet1.CellValue(1,'cre_usr_id');
        formObj.cre_dt.value = sheet1.CellValue(1,'cre_dt').substring(0, 19);
        formObj.upd_usr_id.value = sheet1.CellValue(1,'upd_usr_id');
        formObj.upd_dt.value = sheet1.CellValue(1,'upd_dt').substring(0, 19);
        
        formObj.vsl_cd.className = "input2";
        formObj.vsl_cd.readOnly = true;
        ComBtnEnable('btn_Create');
        formObj.onchange_flag.value = "N";
    }

}
 
 function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
 	document.form.onchange_flag.value = "N";
     ComOpenWait(false);
 }
 function vsl_own_ind_cd_OnChange() {
	 var formObj = document.form;
	 var vslOwnIndCd = formObj.vsl_own_ind_cd.Code;
	 if(vslOwnIndCd =='O'){
		 formObj.fdr_div_cd.Code = 'T';
		 formObj.fdr_div_cd.Enable = false;

	 }else{
		 formObj.fdr_div_cd.Code = '';
		 formObj.fdr_div_cd.Enable = true;
	 }
	    document.form.onchange_flag.value = "Y";
	}
 
 function vsl_bld_cd_OnChange() {
	    document.form.onchange_flag.value = "Y";
	}
 function clss_no_rgst_area_nm_OnChange() {
	 document.form.onchange_flag.value = "Y";
 }

 function fdr_div_cd_OnChange() {
	 var formObj = document.form;
	 var fdrDivCd = formObj.fdr_div_cd.Code;
	 if(fdrDivCd =='O'){
		 formObj.cntr_vsl_clss_capa.className = "input";
		 formObj.vsl_svc_spd.className = "input";
	 }else{		 
		 formObj.cntr_vsl_clss_capa.className = "input1";
		 formObj.vsl_svc_spd.className = "input1";
		 
	 }
	    document.form.onchange_flag.value = "Y";
	}

