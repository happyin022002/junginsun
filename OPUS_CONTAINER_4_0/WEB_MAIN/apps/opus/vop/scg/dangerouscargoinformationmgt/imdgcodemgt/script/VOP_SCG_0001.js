/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0001.js
*@FileTitle  : UN Number (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview commonly used javascript file, calendar related functions are defined.
 */
/**
 * @extends 
 * @class VOP_SCG_0001 : business script for VOP_SCG_0001
 */


// common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var comboObjNm=new Array();
var tabIndex=0;
var tabLoad=new Array();
tabLoad[0]=0;
tabLoad[1]=0;
tabLoad[2]=0;
tabLoad[3]=0;
var objNmSeq=new Array();
objNmSeq[0]="n1st";
objNmSeq[1]="n2nd";
objNmSeq[2]="n3rd";
objNmSeq[3]="n4th";
objNmSeq[4]="n5th";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/          
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var formObject=document.form;
	/*******************************************************/
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break; 
			case "btn_New":
				clearAll(); 
				break;
			case "btn_Copy":
     			ComShowCodeMessage('SCG50028');
				copy();
				break;
			case "btn_Delete":
				doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;
			case "btn_SeqPrev":
				unNoSeqPrev();
				break;
			case "btn_SeqNext":
				unNoSeqNext();
				break;
			case "btn_AutoCreation":
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC07);	//AutoCreation
				doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC07);	//AutoCreation
				//sheetObjects[1].Copy2SheetCol(sheetObjects[2]);
				break;
			case "btn_imdg_spcl_provi_no1": 
			case "btn_imdg_spcl_provi_no2": 
			case "btn_imdg_spcl_provi_no3": 
			case "btn_imdg_spcl_provi_no4": 
			case "btn_imdg_spcl_provi_no5": 
			case "btn_imdg_spcl_provi_no6": 
			case "btn_imdg_spcl_provi_no7": 
			case "btn_imdg_spcl_provi_no8":
 				onPopupClick(srcName);
				break;
			case "frm_segr_as_for_imdg_clss_flg":
				segrClssFlg();
				break;
			case "frm_away_fm_imdg_clss_flg":
				awayClssFlg();
				break;
			case "frm_sprt_fm_imdg_clss_flg":
				sprtClssFlg();
				break;
			case "frm_sprt_hld_fm_imdg_clss_flg":
				sprtHldClssFlg();
				break;
			case "frm_sprt_lon_fm_imdg_clss_flg":
				sprtLonClssFlg();
				break;
			case "frm_away_fm_imdg_segr_grp_flg":
				awaySegrGrpFlg();
				break;
			case "frm_sprt_fm_imdg_segr_grp_flg":
				sprtSegrGrpFlg();
				break;
			case "btns_n1st_imdg_pck_instr_cd": case "btns_n2nd_imdg_pck_instr_cd": case "btns_n3rd_imdg_pck_instr_cd":
				openFile(srcName);
				break;
			case "btns_n1st_imdg_pck_provi_cd": case "btns_n2nd_imdg_pck_provi_cd": case "btns_n3rd_imdg_pck_provi_cd":  case "btns_n4th_imdg_pck_provi_cd": case "btns_n5th_imdg_pck_provi_cd":
				openFile(srcName);
				break;
			case "btns_n1st_imdg_ibc_instr_cd": case "btns_n2nd_imdg_ibc_instr_cd": case "btns_n3rd_imdg_ibc_instr_cd":  case "btns_n4th_imdg_ibc_instr_cd": case "btns_n5th_imdg_ibc_instr_cd":
				openFile(srcName);
				break;
			case "btns_n1st_imdg_ibc_provi_cd": case "btns_n2nd_imdg_ibc_provi_cd": case "btns_n3rd_imdg_ibc_provi_cd":  case "btns_n4th_imdg_ibc_provi_cd": case "btns_n5th_imdg_ibc_provi_cd":
				openFile(srcName);
				break;
			case "btns_n1st_imdg_un_tnk_instr_cd": case "btns_n2nd_imdg_un_tnk_instr_cd":
				openFile(srcName);
				break;
			case "btns_n1st_imdg_tnk_instr_provi_cd": case "btns_n2nd_imdg_tnk_instr_provi_cd": case "btns_n3rd_imdg_tnk_instr_provi_cd":  case "btns_n4th_imdg_tnk_instr_provi_cd": case "btns_n5th_imdg_tnk_instr_provi_cd":
				openFile(srcName);
				break;
			case "btn_Close":
				ComClosePopup(); 
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
  * register IBCombo Object created in page as comboObjects list
  * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
  **/
 function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
 }
 /**
  * initializing sheet
  * implementing onLoad event handler in body tag
  * adding first-served functions after loading screen.
  */
 function loadPage() {
	 // combo
	 combo1=comboObjects[1];
	 comboCnt=comboObjects.length;
     for(i=0;i<sheetObjects.length;i++){
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
     for(k=0;k<tabObjects.length;k++){
         initTab(tabObjects[k],k+1);
         tabObjects[k].SetSelectedIndex(0);
     }
     // Initializing IBMultiCombo
     for(var k=0; k<comboObjects.length; k++){
    	 initCombo(comboObjects[k], k + 1);
     }

     //Initializing html control event
     initControl();
     
     sheet1_OnLoadFinish(sheet1);
 }
 // TODO should set cfr_flg?
function sheet1_OnLoadFinish(sheetObj) {
     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);	//UN Class
     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);	//Excepted Q'ty, Away from SG/Separated from SG 
     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC08);	//Marine pollutant
     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC09);	//Packing group
     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC10);	//Amdt No
     sheetObjects[1].DataInsert(-1);
     if(preConds.pop_yn == 'Y') {
    	 sheetObjects[0].SetColHidden(1,0);
         if(preConds.imdg_un_no != '' || preConds.imdg_un_no_seq != '') {	         	
         	if(preConds.imdg_un_no != '') ComSetObjValue(document.form.imdg_un_no, preConds.imdg_un_no);
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
         	if(preConds.imdg_un_no_seq != '') ComSetObjValue(document.form.imdg_un_no_seq, preConds.imdg_un_no_seq);	            
         	
         	ComBtnDisable('btn_Retrieve');
         	ComBtnDisable('btn_New');
         	ComBtnDisable('btn_Copy');
            ComBtnDisable('btn_Delete');
            ComBtnDisable('btn_Save');
            
            ComBtnDisable('btn_SeqPrev');
            ComBtnDisable('btn_SeqNext');
            ComBtnDisable('btn_AutoCreation');
            for(var i=1; i<=8; i++){
            	$("#btn_imdg_spcl_provi_no"+ i).attr("disabled","disabled");
            }
            $(":text").attr("disabled","disabled");
            $(":text").removeClass("input1");
            $(":text").addClass("input2");
            
            $(":checkbox").attr("disabled","disabled");
            $("img").attr("name","");
            $("select").attr("disabled","disabled");
            $("textarea").attr("disabled","disabled");
            for(var k=0; k<comboObjects.length; k++){
            	comboObjects[k].SetEnable(0);
            }

         	//Retrieve
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            
            //CFR_FLG
            if(preConds.cfr_flg == 'T'){
            	document.form.cfr_flg.checked = true;
            }else{ //'F' or ''
            	document.form.cfr_flg.checked = false;
            }
         }
     }
 }
 /**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo) {
	 var cnt=0;
	 var sheetID=sheetObj.id;
     switch(sheetID) {
     case "sheet1":
         with(sheetObj){
			 var HeadTitle1="|Sel|UN No.|Seq.|Own\nRes.|PSN|Var Rmk|Class or Division|Class or Division|Subsidiary risk(s)|Subsidiary risk(s)|"
			 HeadTitle1 += "Subsidiary risk(s)|Subsidiary risk(s)|Mrn P|SRL R|PakGrp|Special Provisions|Special Provisions|Special Provisions|Special Provisions|Special Provisions|"
			 HeadTitle1 += "Special Provisions|Special Provisions|Special Provisions|Limited Q'ty|Limited Q'ty|Limited Q'ty Desc|Exc Q'ty|Exc Q'ty Desc|EmS No.|Stwg Cd|"
			 HeadTitle1 += "F Point|ERG|ERG|PSA No.|BPT|BPT|BPT|BPT|LPK|SLPA|"
			 HeadTitle1 += "PPT Desc|RQ|PIZ Cd|TOXIC|Dangerous when wet|Port Rest.|OPR Rest.|Extend Class.|HCDG|Depends on Q'ty |"
			 HeadTitle1 += "HCDG\nRemarks|Packing Instructions|Packing Instructions|Packing Instructions|Packing provisions|Packing provisions|Packing provisions|Packing provisions|Packing provisions|IBC Instructions|"
			 HeadTitle1 += "IBC Instructions|IBC Instructions|IBC Instructions|IBC Instructions|IBC provisions|IBC provisions|IBC provisions|IBC provisions|IBC provisions|UN Tank Instructions|"
			 HeadTitle1 += "UN Tank Instructions|Tank Special Provisions|Tank Special Provisions|Tank Special Provisions|Tank Special Provisions|Tank Special Provisions|Packaging|Intermediate Bulk|Tank|Stowage and Segregation|Stowage Instruction Remark1|Stowage Instruction Remark2|"
			 HeadTitle1 += "Clear of Living Q'tr|Foodstuffs|Source of Heat|Segregation as for|Segregation as for|Away from Class|Away from Class|Separated from Class|Separated from Class|Separated by compartment or hold fm Class|"
			 HeadTitle1 += "Separated by compartment or hold fm Class|Separated longitudinally fm Class|Separated longitudinally fm Class|Segregation Groups|Segregation Groups|Segregation Groups|Segregation Groups|Away from SG|Away from SG|Separated from SG|"
			 HeadTitle1 += "Separated from SG|Classification|Technical Name|Concentration (%)|Packing Method|Control Temp (℃)|Emergency Temp (℃)|CFR flg|Amdt No|Tec Desc";
			 var HeadTitle2="|Sel|UN No.|Seq.|Own\nRes.|PSN|Var Rmk|Class|CompGrp|Class1|Class2|"
			 HeadTitle2 += "Class3|Class4|Mrn P|SRL R|PakGrp|ProviNo1|ProviNo2|ProviNo3|ProviNo4|ProviNo5|"
			 HeadTitle2 += "ProviNo6|ProviNo7|ProviNo8|Q'ty|UtCd|Limited Q'ty Desc|Exc Q'ty|Exc Q'ty Desc|EmS No.|Stwg Cd|"
			 HeadTitle2 += "F Point|ERG1|ERG2|PSA No.|BPT1|BPT2|BPT3|BPT4|LPK|SLPA|"
			 HeadTitle2 += "PPT Desc|RQ|PIZ Cd|TOXIC|Dangerous when wet|Port Rest.|OPR Rest.|Extend Class.|HCDG|Depends on Q'ty |"
			 HeadTitle2 += "HCDG\nRemarks|Packing Instructions1|Packing Instructions2|Packing Instructions3|Packing provisions1|Packing provisions2|Packing provisions3|Packing provisions4|Packing provisions5|IBC Instructions1|"
			 HeadTitle2 += "IBC Instructions2|IBC Instructions3|IBC Instructions4|IBC Instructions5|IBC provisions1|IBC provisions2|IBC provisions3|IBC provisions4|IBC provisions5|UN Tank Instructions1|"
			 HeadTitle2 += "UN Tank Instructions2|Tank Special Provisions1|Tank Special Provisions2|Tank Special Provisions3|Tank Special Provisions4|Tank Special Provisions5|Packaging|Intermediate Bulk|Tank|Stowage and Segregation|"
			 HeadTitle2 += "Clear of Living Q'tr|Foodstuffs|Source of Heat|flg|Class|flg|Class|flg|Class|flg|"
			 HeadTitle2 += "Class|flg|Class|Groups1|Groups2|Groups3|Groups4|flg|Class|flg|"
			 HeadTitle2 += "Class|Classification|Technical Name|Concentration (%)|Packing Method|Control Temp (℃)|Emergency Temp (℃)|CFR flg|Amdt No|Tec Desc";
			 var prefix="sheet1_";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},
			{ Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
             {Type:"DelCheck",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_crr_rstr_expt_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm",                      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm_var_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",                    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_comp_grp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_mrn_polut_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no1",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no3",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no4",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no5",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no6",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no7",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no8",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_meas_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_desc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_emer_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_stwg_cate_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_temp_ctnt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_chr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_no",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_bom_port_trst_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_bom_port_trst_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_bom_port_trst_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_bom_port_trst_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pkg_auth_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lk_port_auth_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_sbst_ppt_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_rpt_qty",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_psn_inh_zn_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_toxc_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_dg_wet_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_rstr_port_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_rstr_opr_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_xtd_clss_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_flg",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_dpnd_qty_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_rmk",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_pck_instr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_pck_instr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_pck_instr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_pck_provi_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_pck_provi_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_pck_provi_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_imdg_pck_provi_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n5th_imdg_pck_provi_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_ibc_instr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_ibc_instr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_ibc_instr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_imdg_ibc_instr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n5th_imdg_ibc_instr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_ibc_provi_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_ibc_provi_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_ibc_provi_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_imdg_ibc_provi_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n5th_imdg_ibc_provi_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_un_tnk_instr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_un_tnk_instr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_tnk_instr_provi_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_tnk_instr_provi_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_tnk_instr_provi_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_imdg_tnk_instr_provi_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n5th_imdg_tnk_instr_provi_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_pck_rstr_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_intmd_bc_rstr_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"segr_desc",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             //2016-05-27
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_add_segr_desc",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_add_segr_desc",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             //2016-05-27
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clr_liv_qtr_stwg_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_fd_stuf_stwg_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_ht_src_stwg_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"segr_as_for_imdg_clss_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"segr_as_for_imdg_clss_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"away_fm_imdg_clss_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"away_fm_imdg_clss_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sprt_fm_imdg_clss_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sprt_fm_imdg_clss_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sprt_hld_fm_imdg_clss_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sprt_hld_fm_imdg_clss_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sprt_lon_fm_imdg_clss_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sprt_lon_fm_imdg_clss_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc1",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc3",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc4",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"away_fm_imdg_segr_grp_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"away_dp_seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sprt_fm_imdg_segr_grp_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sprt_dp_seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_org_ract_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_tec_nm",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_conc_rt_ctnt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_mzd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_ctrl_temp",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_emer_temp",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_subs_rsk_lbl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_subs_rsk_lbl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_subs_rsk_lbl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_imdg_subs_rsk_lbl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_hld_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"upd",                             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_pck_instr_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_pck_instr_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_pck_instr_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_pck_provi_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_pck_provi_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_pck_provi_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_imdg_pck_provi_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n5th_imdg_pck_provi_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_ibc_instr_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_ibc_instr_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_ibc_instr_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_imdg_ibc_instr_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n5th_imdg_ibc_instr_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_ibc_provi_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_ibc_provi_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_ibc_provi_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_imdg_ibc_provi_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n5th_imdg_ibc_provi_file",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_un_tnk_instr_file",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_un_tnk_instr_file",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_tnk_instr_provi_file",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_tnk_instr_provi_file",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_tnk_instr_provi_file",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_imdg_tnk_instr_provi_file",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n5th_imdg_tnk_instr_provi_file",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_flg",						  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_amdt_no",					  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_tec_nm_desc",			      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
             InitColumns(cols);
             SetEditable(1);
             //SetSheetHeight(200);
             SetVisible(false);
           }
         
     break;                 
     case "sheet2":      //sheet2 init
         with(sheetObj){
		      var HeadTitle="|1.1|1.2|1.5|1.3|1.6|1.4|2.1|2.2|2.3|3|4.1|4.2|4.3|5.1|5.2|6.1|6.2|7|8|9|upd";
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_11",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_12",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_15",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_13",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_16",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_14",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_21",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_22",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_23",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_3",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_41",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_42",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_43",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_51",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_52",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_61",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_62",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_7",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_8",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_9",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		          {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"upd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(100);
		      SetColProperty(0 ,1 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,2 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,3 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,4 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,5 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,6 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,7 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,8 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,9 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,10 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,11 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,12 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,13 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,14 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,15 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,16 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,17 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,18 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,19 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,20 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});

      }


    	 break;
     case "sheet3":      //sheet3 init
         with(sheetObj){
    	 	var HeadTitle="|1.1|1.2|1.5|1.3|1.6|1.4|2.1|2.2|2.3|3|4.1|4.2|4.3|5.1|5.2|6.1|6.2|7|8|9|upd";
    	 	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
    	 	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    	 	var headers = [ { Text:HeadTitle, Align:"Center"} ];
    	 	InitHeaders(headers, info);
    	 	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_11",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_12",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_15",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_13",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_16",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_14",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_21",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_22",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_23",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_3",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_41",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_42",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_43",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_51",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_52",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_61",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_62",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_7",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_8",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:0,  Width:48.5, Align:"Center",  ColMerge:0,   SaveName:"clss_cd_9",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	          {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"upd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
    	 	InitColumns(cols);
    	 	SetEditable(1);
    	 	SetVisible(false);
		      SetColProperty(0 ,1 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,2 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,3 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,4 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,5 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,6 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,7 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,8 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,9 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,10 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,11 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,12 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,13 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,14 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,15 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,16 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,17 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,18 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,19 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
		      SetColProperty(0 ,20 , {AcceptKeys:"N|[X*]" , InputCaseSensitive:1});
      	}
        break;        	 
     }
 }
 
 // Sheet related process handling
 function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
	 
     sheetObj.ShowDebugMsg(false);
     
     switch(sAction) {
     
        case IBSEARCH:      //Retrieve
        	
     		if(validateForm(sheetObj,formObj,sAction)) {
        		formObj.f_cmd.value=SEARCH;
    			var sXml=sheetObj.GetSearchData("VOP_SCG_0001GS.do", FormQueryString(formObj));
    			var arrXml=sXml.split("|$$|");
    			
    			for(var inx=0; inx<arrXml.length; inx++){
    				sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:1} );
    			}
    			//Initialize if there's no data in Segregation Sheet.
				if(arrXml[1].indexOf("TOTAL='0'") > 0){
      				sheetObjects[1].DataInsert(-1);
    			}
				if(sheetObj.RowCount() ==0 ) return;
				
    			//Setting Subsidiary risk(s) 
    			var subRskLblList=ComGetEtcData(arrXml[0], "subRskLblList").split("|");
    			for(var i=1 ; i < subRskLblList.length+1 ; i++ ) {
    				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"imdg_subs_rsk_lbl_cd"+i,subRskLblList[i-1]);
    				if (i == 1) {
	    				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"n1st_imdg_subs_rsk_lbl_cd",subRskLblList[i-1]);
    				}else if (i == 2) {
	    				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"n2nd_imdg_subs_rsk_lbl_cd",subRskLblList[i-1]);
    				}else if (i == 3) {
	    				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"n3rd_imdg_subs_rsk_lbl_cd",subRskLblList[i-1]);
    				}else if (i == 4) {
	    				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"n4th_imdg_subs_rsk_lbl_cd",subRskLblList[i-1]);
    				}
    			}
    			
    			//Setting Special Provisions 
    			var spclProviList=ComGetEtcData(arrXml[0], "spclProviList").split("|");
    			var spclProviDpSeq=null;
    			for(var i=1 ; i < spclProviList.length+1 ; i++ ) {
    				spclProviDpSeq=spclProviList[i-1].split("^");
    				if (i==spclProviDpSeq[1]){
    					sheetObjects[0].SetCellValue(sheetObj.LastRow(),"imdg_spcl_provi_no"+i,spclProviDpSeq[0]);
    				}
    			}
    			
    			//Setting Segregation Groups 
    			var segrGrpDtlList=ComGetEtcData(arrXml[0], "segrGrpDtlList").split("|");
    			for(var i=1 ; i < segrGrpDtlList.length+1 ; i++ ) {
    				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"hcdg_tnk_rstr_desc"+i,segrGrpDtlList[i-1]);
    			}
    			
    			//Setting Away from Class/Separated from Class 
    			var clssCdList=ComGetEtcData(arrXml[0], "clssCdList").split("|");
    			var clssCode=null;
    			var j=1;
    			var k=1;
    			var l=1;
    			var m=1;
    			var strAwayClssCode="";
    			var strSprtClssCode="";
    			var strSprtHldClssCode="";
    			var strSprtLonClssCode="";
    			for(var i=0 ; i < clssCdList.length ; i++ ) {
    				clssCode=clssCdList[i].split("^");
    				if (1==clssCode[1]) {
	    				if (j==clssCode[2]){
	    					if (j != 1) {
	    						strAwayClssCode += "/";
	    					}
	    					strAwayClssCode += clssCode[0];
	    				}
	    				j++;
    				}else if (2==clssCode[1]){
	    				if (k==clssCode[2]){
	    					if (k != 1) {
	    						strSprtClssCode += "/";
	    					}
	    					strSprtClssCode += clssCode[0];
	    				}
	    				k++;
    				}else if (3==clssCode[1]){
	    				if (l==clssCode[2]){
	    					if (l != 1) {
	    						strSprtHldClssCode += "/";
	    					}
	    					strSprtHldClssCode += clssCode[0];
	    				}
	    				l++;
    				}else if (4==clssCode[1]){
	    				if (m==clssCode[2]){
	    					if (m != 1) {
	    						strSprtLonClssCode += "/";
	    					}
	    					strSprtLonClssCode += clssCode[0];
	    				}
	    				m++;
    				}
    			}
				sheetObjects[0].SetCellValue(sheetObj.LastRow(),"away_fm_imdg_clss_cd",strAwayClssCode);
				sheetObjects[0].SetCellValue(sheetObj.LastRow(),"sprt_fm_imdg_clss_cd",strSprtClssCode);
				sheetObjects[0].SetCellValue(sheetObj.LastRow(),"sprt_hld_fm_imdg_clss_cd",strSprtHldClssCode);
				sheetObjects[0].SetCellValue(sheetObj.LastRow(),"sprt_lon_fm_imdg_clss_cd",strSprtLonClssCode);
						
    			//Setting Away from SG/Separated from SG 
    			var segrGrpList=ComGetEtcData(arrXml[0], "segrGrpList").split("|");
    			var segrGrpCode=null;
    			var j=1;
    			var k=1;
    			var strAwaySegrGrpCode="";
    			var strSprtSegrGrpCode="";
    			
    			for(var i=0 ; i < segrGrpList.length ; i++ ) {
    				segrGrpCode=segrGrpList[i].split("^");
    				if (1==segrGrpCode[1]) {
	    				if (j==segrGrpCode[2]){
	    					if (j != 1) {
	    						strAwaySegrGrpCode += "/";
	    					}
	    					strAwaySegrGrpCode += segrGrpCode[0];
	    				}
	    				j++;
    				}else if (2==segrGrpCode[1]){
	    				if (k==segrGrpCode[2]){
	    					if (k != 1) {
	    						strSprtSegrGrpCode += "/";
	    					}
	    					strSprtSegrGrpCode += segrGrpCode[0];
	    				}
	    				k++;
    				}
    			}
    			
				sheetObjects[0].SetCellValue(sheetObj.LastRow(),"away_dp_seq",strAwaySegrGrpCode);
				sheetObjects[0].SetCellValue(sheetObj.LastRow(),"sprt_dp_seq",strSprtSegrGrpCode);
    			ComScgCopyRowToForm(sheetObj, formObj, sheetObj.LastRow(), "frm_");
    			if (sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),"imdg_mrn_polut_cd") == "") comboObjects[7].SetSelectText("Blank");
    			if (sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),"imdg_pck_grp_cd") == "") comboObjects[8].SetSelectText("Blank");
    			formObj.frm_imdg_tec_nm_desc.value=formObj.frm_imdg_tec_nm.value;
    			if (formObj.frm_segr_as_for_imdg_clss_flg.checked == true) {
    	  			comboObjects[11].SetEnable(1);
    			}else{
    	  			comboObjects[11].SetEnable(0);
    			}
    			if (formObj.frm_away_fm_imdg_clss_flg.checked == true) {
    	  			comboObjects[12].SetEnable(1);
    			}else{
    	  			comboObjects[12].SetEnable(0);
    			}
    			if (formObj.frm_sprt_fm_imdg_clss_flg.checked == true) {
    	  			comboObjects[13].SetEnable(1);
    			}else{
    	  			comboObjects[13].SetEnable(0);
    			}
    			if (formObj.frm_sprt_hld_fm_imdg_clss_flg.checked == true) {
    	  			comboObjects[14].SetEnable(1);
    			}else{
    	  			comboObjects[14].SetEnable(0);
    			}
    			if (formObj.frm_sprt_lon_fm_imdg_clss_flg.checked == true) {
    	  			comboObjects[15].SetEnable(1);
    			}else{
    	  			comboObjects[15].SetEnable(0);
    			}
    			if (formObj.frm_away_fm_imdg_segr_grp_flg.checked == true) {
    	  			comboObjects[16].SetEnable(1);
    			}else{
    	  			comboObjects[16].SetEnable(0);
    			}
    			if (formObj.frm_sprt_fm_imdg_segr_grp_flg.checked == true) {
    	  			comboObjects[17].SetEnable(1);
    			}else{
    	  			comboObjects[17].SetEnable(0);
    			}
    			if(arrXml[1].indexOf("TOTAL='0'") < 0){
	         		doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC07);	//AutoCreation
         		}
     		}
    	   	break;
    	   	
        case IBDELETE:	//delete
        	if (sheetObjects[0].LastRow()> 1 && sheetObjects[0].GetCellValue(sheetObj.LastRow(),"imdg_un_no") != "") {
            	if(ComShowCodeConfirm('SCG50002', 'data')){
            		sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"del_chk",1);
            		if (sheetObj.LastRow()< 2 || sheetObjects[0].GetCellValue(sheetObj.LastRow(),"imdg_un_no") == "") {
          				sheetObjects[0].DataInsert(-1);
          			}
          			ComScgCopyFormToRow(formObj, sheetObj, sheetObj.LastRow(), "frm_");
					sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"imdg_un_no",formObj.imdg_un_no.value);
					sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"imdg_un_no_seq",formObj.imdg_un_no_seq.value);
					sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"upd","U");
					sheetObjects[1].SetCellValue(sheetObjects[1].LastRow(),"upd","U");
          			formObj.f_cmd.value=MULTI;
 	          		var sParam=ComGetSaveString(sheetObjects);
  	                if (sParam == "") return;
  	                sParam += "&" + FormQueryString(formObj);
 	          		sParam += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_");
 	          	    sParam += "&" + ComSetPrifix(sheetObjects[1].GetSaveString(), "sheet2_");
 	          		var sXml=sheetObj.GetSaveData("VOP_SCG_0001GS.do", sParam);
	                sheetObj.LoadSaveData(sXml);
	                clearAll();
            	}
        	}else{
        		if(ComShowCodeConfirm('SCG50002', 'data')){
        			clearBody();
        			unNoSeqPrev();	
        		}
        	}
        	break;
        	
        case IBSAVE:	//save
        	if(validateForm(sheetObj,formObj,sAction)) {
 				if(!ComShowCodeConfirm('SCG50001', 'data')) return;
 				if (sheetObj.LastRow()< 2 || sheetObjects[0].GetCellValue(sheetObj.LastRow(),"imdg_un_no") == "") {
      				sheetObjects[0].DataInsert(-1);
      			}
      			ComScgCopyFormToRow(formObj, sheetObj, sheetObj.LastRow(), "frm_");
      			sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"imdg_amdt_no",formObj.imdg_amdt_no.value);
				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"imdg_un_no",formObj.imdg_un_no.value);
				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"imdg_un_no_seq",formObj.imdg_un_no_seq.value);
				if(formObj.cfr_flg.checked==true) {
					sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"cfr_flg","T");
				} else {
					sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"cfr_flg","");
				}
				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"upd","U");
				sheetObjects[1].SetCellValue(sheetObjects[1].LastRow(),"upd","U");
      			formObj.f_cmd.value=MULTI;
          		var sParam=ComGetSaveString(sheetObjects);
                if (sParam == "") return;
                sParam += "&" + FormQueryString(formObj);
          		sParam += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_");
          	    sParam += "&" + ComSetPrifix(sheetObjects[1].GetSaveString(), "sheet2_");
          	    ComOpenWait(true);
          		var sXml=sheetObj.GetSaveData("VOP_SCG_0001GS.do", sParam);
          		ComOpenWait(false);
                sheetObj.LoadSaveData(sXml);
                //ComOpenWait(false);
                var befNo=formObj.imdg_un_no.value;
                var befSeq=formObj.imdg_un_no_seq.value;
				clearBody();
	         	//retrieve
	            formObj.imdg_un_no.value=befNo;
	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
	            formObj.imdg_un_no_seq.value=befSeq;
	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        	}
        	break;
        	
		case IBSEARCH_ASYNC01:   //UN Class. retrieve	
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
			//Class
			ComXml2ComboItem(sXml,frm_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd|imdg_clss_cd_desc");
			//Subsidiary Risk(s)
			ComXml2ComboItem(sXml,frm_imdg_subs_rsk_lbl_cd1, "imdg_clss_cd", "imdg_clss_cd");
			ComXml2ComboItem(sXml,frm_imdg_subs_rsk_lbl_cd2, "imdg_clss_cd", "imdg_clss_cd");
			ComXml2ComboItem(sXml,frm_imdg_subs_rsk_lbl_cd3, "imdg_clss_cd", "imdg_clss_cd");
			ComXml2ComboItem(sXml,frm_imdg_subs_rsk_lbl_cd4, "imdg_clss_cd", "imdg_clss_cd");
			//Extend Class.
			ComXml2ComboItem(sXml,frm_cfr_xtd_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
			//Segregation as for
			ComXml2ComboItem(sXml,frm_segr_as_for_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
			//Away from Class
			ComXml2ComboItem(sXml,frm_away_fm_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
			//Separated from Class
			ComXml2ComboItem(sXml,frm_sprt_fm_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
			//Separated by compartment or hold fm Class
			ComXml2ComboItem(sXml,frm_sprt_hld_fm_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
			//Separated longitudinally fm Class
			ComXml2ComboItem(sXml,frm_sprt_lon_fm_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
    		break;
    		
		case IBSEARCH_ASYNC02:   //Excepted Q'ty retrieve
			formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObj.GetSearchData("VOP_SCG_0001GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			//Excepted Q'ty
			ComXml2ComboItem(arrXml[0],frm_imdg_expt_qty_cd, "imdg_expt_qty_cd", "imdg_expt_qty_cd", "Y");
			//Away from SG
			ComXml2ComboItem(arrXml[1],frm_away_dp_seq, "imdg_segr_grp_no", "imdg_segr_grp_no");
			//Separated from SG
			ComXml2ComboItem(arrXml[1],frm_sprt_dp_seq, "imdg_segr_grp_no", "imdg_segr_grp_no");
			break;
			
		case IBSEARCH_ASYNC03:   //Division of Class retrieve
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("VOP_SCG_0047GS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml,frm_imdg_comp_grp_cd, "imdg_comp_grp_cd", "imdg_comp_grp_cd");
			break;
			
		case IBSEARCH_ASYNC04:   //UN No. retrieve
     		if(validateForm(sheetObj,formObj,sAction)) {
                formObj.f_cmd.value=SEARCH01;
    		    var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
    		    var arrData=ComScgXml2Array(sXml, "imdg_un_no_seq|imdg_un_no_seq_max|imdg_un_no_seq_min|imdg_un_no_seq_cnt");
    		    
    		    if (arrData != undefined) {
    		    	formObj.imdg_un_no_seq.value=arrData[0][0];	    		    		
   					formObj.imdg_un_no_seq_max.value=arrData[0][1];
   					formObj.imdg_un_no_seq_min.value=arrData[0][2];
   					formObj.imdg_un_no_seq_cnt.value=arrData[0][3];
				}else{
					
					if (formObj.cfr_flg.checked){
						
						if(preConds.pop_yn != 'Y') {
				 			//if (ComShowCodeConfirm("SCG50040", formObj.imdg_un_no.value)) {
							if (ComShowCodeConfirm("SCG50025")) {
				 				
				 				formObj.imdg_un_no_seq.value="490";
				 				
			   					formObj.imdg_un_no_seq_max.value="";
			   					formObj.imdg_un_no_seq_min.value="";
			   					formObj.imdg_un_no_seq_cnt.value="";
			   					formObj.frm_prp_shp_nm.focus();
				 			}else{
				 				formObj.cfr_flg.checked=false;
			   					formObj.imdg_un_no.value="";
			   					formObj.imdg_un_no_seq.value="";
			   					formObj.imdg_un_no_seq_max.value="";
			   					formObj.imdg_un_no_seq_min.value="";
			   					formObj.imdg_un_no_seq_cnt.value="";
			   					formObj.imdg_un_no.focus();
				 			}
						}

					}else{
						if(preConds.pop_yn != 'Y') {
				 			//if (ComShowCodeConfirm("SCG50027", formObj.imdg_un_no.value)) {
				 			if (ComShowCodeConfirm("SCG50025")) {
				 				formObj.imdg_un_no_seq.value= formObj.imdg_amdt_no.value.substring(0,2) + "01";
				 				
			   					formObj.imdg_un_no_seq_max.value="";
			   					formObj.imdg_un_no_seq_min.value="";
			   					formObj.imdg_un_no_seq_cnt.value="";
			   					formObj.frm_prp_shp_nm.focus();
				 			}else{
			   					formObj.imdg_un_no.value="";
			   					formObj.imdg_un_no_seq.value="";
			   					formObj.imdg_un_no_seq_max.value="";
			   					formObj.imdg_un_no_seq_min.value="";
			   					formObj.imdg_un_no_seq_cnt.value="";
			   					formObj.imdg_un_no.focus();
				 			}							
						}

					}
					
				}
     		}
    		break;
    		
		case IBSEARCH_ASYNC05:   //Special Provisions check
			formObj.f_cmd.value=SEARCH03;
 		    var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj)+"&imdg_spcl_provi_no="+event.srcElement.value);
		    var arrData=ComScgXml2Array(sXml, "imdg_spcl_provi_no");
		    if (arrData != null && arrData.length > 0) {
			}else{
				ComShowCodeMessage("SCG50008", 'Special Provisions Creation');
				event.srcElement.value="";
	 			ComSetFocus(ComGetEvent());
			}
			break;
			
		case IBSEARCH_ASYNC06:   //Packing / IBC / Tank Instructions & Provisions check
			formObj.f_cmd.value=SEARCH;
 		    var sXml=sheetObj.GetSearchData("VOP_SCG_0042GS.do", FormQueryString(formObj)+"&imdg_pck_instr_cd="+event.srcElement.value);
		    var arrData=ComScgXml2Array(sXml, "file_sav_id");
		    if (arrData != null && arrData.length > 0) { 
				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),event.srcElement.name.replace("frm_","").replace('_cd','_file'),arrData);
			}else{
				ComShowCodeMessage('SCG50008', 'Packing Instruction/Provision Creation');
				event.srcElement.value="";
	 			ComSetFocus(ComGetEvent());
			}
			break;
			
		case IBSEARCH_ASYNC07:   //Segregation Auto Creation
 			if(!validateForm(sheetObj,formObj,sAction))return;
    		formObj.f_cmd.value=SEARCH02;
    		var param="&msg_flg=Y";
    		// Retrive doubleclick  => Cannot read property 'Page' of null  
    		if (sheetObj.id == "sheet3") param="&msg_flg=N";
    		sheetObj.DoSearch("VOP_SCG_0001GS.do", FormQueryString(formObj)+param );
    	    sheetObjects[1].SetCellValue(sheetObjects[1].LastRow(),"upd","U");
    	   	break;
    	   	
		case IBSEARCH_ASYNC08:   //Marine pollutant retrieve
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("VOP_SCG_0039GS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml,frm_imdg_mrn_polut_cd, "imdg_mrn_polut_cd", "imdg_mrn_polut_cd");
			comboObjects[7].InsertItem(0, 'Blank','  '); 
			comboObjects[7].SetSelectText("Blank");
			break;
			
		case IBSEARCH_ASYNC09:   //Marine pollutant 조회
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("VOP_SCG_0040GS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml,frm_imdg_pck_grp_cd, "imdg_pck_grp_cd", "imdg_pck_grp_cd");
			comboObjects[8].SetText(0, 0, 'I'); 
			comboObjects[8].SetText(1, 0, 'II'); 
			comboObjects[8].SetText(2, 0, 'III'); 
			comboObjects[8].InsertItem(0, 'Blank','  '); 
			comboObjects[8].SetSelectText("Blank");
			break;
			
		case IBSEARCH_ASYNC10:   //Amdt No 조회
			
			if(preConds.pop_yn == 'Y') {
				formObj.f_cmd.value=SEARCH09;
				if(preConds.imdg_un_no != '') ComSetObjValue(document.form.imdg_un_no, preConds.imdg_un_no);
	            if(preConds.imdg_un_no_seq != '') ComSetObjValue(document.form.imdg_un_no_seq, preConds.imdg_un_no_seq);
	         	
			}else{
				formObj.f_cmd.value=SEARCH07;
			}
      		var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do" , FormQueryString(formObj));
     		var arrData=ComScgXml2Array(sXml, "imdg_amdt_no");
     		formObj.crte_imdg_un_no.value = arrData[0][0];
     		
     		formObj.f_cmd.value=SEARCH08;
			var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml,imdg_amdt_no, "imdg_amdt_no", "imdg_amdt_no");
			comboObjects[0].SetSelectText(formObj.crte_imdg_un_no.value, false);
			//comboObjects[0].SetSelectText("36-12", false);
     		
			break;
			
		case IBROWSEARCH:   //Packing / IBC / Tank Instructions & Provisions check
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("VOP_SCG_0046GS.do" , FormQueryString(formObj)+"&imdg_segr_tp_cd=C"+"&imdg_segr_cd="+sheetObj.GetCellValue(Row,Col));
		    var arrData=ComScgXml2Array(sXml, "imdg_segr_cd");
		    if (arrData != null && arrData.length > 0) {
			}else{
				ComShowCodeMessage("SCG50010", 'Data');
			    sheetObj.SelectCell(1, Col, true, "");
				return false;
			}
			break;
     }
 }
 
 function sheet1_OnSearchEnd(sheetObj){
	//sheetObjects[1].SetCellValue(sheetObjects[1].LastRow(),"upd","U");
	//copySheetToSheet(sheetObj, sheetObjects[2]);
	//copySheetToSheet(sheetObjects[1], sheetObjects[2]);
 }
 /**
  * register IBTab Object as list
  * adding process for list in case of needing batch processing with other items
  * defining list on the top of source
  */
 function setTabObject(tab_obj){
     tabObjects[tabCnt++]=tab_obj;
 }
 
 //business javascript OnKeyPress event Catch
 function initControl() {
	 axon_event.addListener('keydown',	'ComKeyEnter', 			'form');
	 axon_event.addListener('change',	'clss_OnChange', 		'frm_imdg_clss_cd');
	 axon_event.addListener('change',	'cfr_flg_OnChange', 	'cfr_flg');
//	 axon_event.addListener('change', 	'subsRskLbl1_OnChange', 'frm_imdg_subs_rsk_lbl_cd1');
//	 axon_event.addListener('change', 	'subsRskLbl2_OnChange', 'frm_imdg_subs_rsk_lbl_cd2');
//	 axon_event.addListener('change', 	'subsRskLbl3_OnChange', 'frm_imdg_subs_rsk_lbl_cd3');
//	 axon_event.addListener('change', 	'subsRskLbl4_OnChange', 'frm_imdg_subs_rsk_lbl_cd4');
//	 axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
//	 axon_event.addListenerForm('keyup',	'obj_keyup', 	document.form);
	 axon_event.addListenerForm('blur', 	'obj_blur', 	document.form); 
 }
 /**
  * Initializing Combo
  * setting Combo items
  */
 function initCombo(comboObj, comboNo) {
    switch(comboObj.options.id) {
	    case "imdg_amdt_no":
	        with(comboObj) {
	        	SetColWidth(0, "100");
	        	SetDropHeight(190);
	        	SetMultiSelect(0);
	        	SetMaxSelect(1);
	        	SetUseAutoComplete(1);
	        }
	        break;
        case "frm_imdg_clss_cd":
            with(comboObj) {
            	SetTitle("Class|Definition");
            	SetColWidth(0, "50");
            	SetColWidth(1, "700");
            	SetDropHeight(190);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(1);
            }
            break;	        
        case "frm_imdg_comp_grp_cd":
            with(comboObj) {
            	SetTitle("Compatibility Group");
            	SetColWidth(0, "150");
            	SetDropHeight(190);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(0);
        		SetEnable(0);
            }
            break;
        case "frm_imdg_subs_rsk_lbl_cd1":
            with(comboObj) {
        		SetColWidth(0, "50");
            	SetDropHeight(190);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(0);
            }
            break;
        case "frm_imdg_subs_rsk_lbl_cd2":
            with(comboObj) {
        		SetColWidth(0, "50");
            	SetDropHeight(190);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(0);
            }
            break;
        case "frm_imdg_subs_rsk_lbl_cd3":
            with(comboObj) {
        		SetColWidth(0, "50");
            	SetDropHeight(190);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(0);
            }
            break;
        case "frm_imdg_subs_rsk_lbl_cd4":
            with(comboObj) {
    		SetColWidth(0, "50");
        	SetDropHeight(190);
        	SetMultiSelect(0);
        	SetMaxSelect(1);
        	SetUseAutoComplete(0);
            }
            break;
        case "frm_imdg_mrn_polut_cd":
            with(comboObj) {
            	SetDropHeight(190);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(0);
            }
            break;
        case "frm_imdg_pck_grp_cd":
            with(comboObj) {
            	SetDropHeight(190);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(0);
            }
            break;
        case "frm_imdg_expt_qty_cd":
            with(comboObj) {
            	SetDropHeight(190);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(0);
            }
            break;
        case "frm_cfr_xtd_clss_cd":
            with(comboObj) {
        		SetColWidth(0, "50");
            	SetDropHeight(190);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(0);
            }
            break;
        case "frm_segr_as_for_imdg_clss_cd":
            with(comboObj) {
        		SetColWidth(0, "50");
            	SetDropHeight(190);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(0);
        		SetEnable(0);
            }
            break;
        case "frm_away_fm_imdg_clss_cd":
            with(comboObj) {
    	    	SetMultiSeparator("/");
            	SetDropHeight(150);
            	SetMultiSelect(1);
            	SetUseAutoComplete(0);
        		SetEnable(0);
            }
            break;
        case "frm_sprt_fm_imdg_clss_cd":
            with(comboObj) {
    	    	SetMultiSeparator("/");
            	SetDropHeight(150);
            	SetMultiSelect(1);
            	SetUseAutoComplete(0);
        		SetEnable(0);
            }
            break;
        case "frm_sprt_hld_fm_imdg_clss_cd":
            with(comboObj) {
    	    	SetMultiSeparator("/");
            	SetDropHeight(150);
            	SetMultiSelect(1);
            	SetUseAutoComplete(0);
        		SetEnable(0);
            }
            break;
        case "frm_sprt_lon_fm_imdg_clss_cd":
            with(comboObj) {
    	    	SetMultiSeparator("/");
            	SetDropHeight(150);
            	SetMultiSelect(1);
            	SetUseAutoComplete(0);
        		SetEnable(0);
            }
            break;
        case "frm_away_dp_seq":
            with(comboObj) {
    	    	SetMultiSeparator("/");
            	SetDropHeight(150);
            	SetMultiSelect(1);
            	SetUseAutoComplete(0);
        		SetEnable(0);
            }
            break;
        case "frm_sprt_dp_seq":
            with(comboObj) {
    	    	SetMultiSeparator("/");
                SetMultiSelect(1);
            	SetDropHeight(150);
            	SetUseAutoComplete(0);
        		SetEnable(0);
            }
            break;
    }
}
/**
  * initializing Tab
  * setting Tab items
  */
 function initTab(tabObj , tabNo) {
	 switch(tabNo) {
	 	case 1:
	 		with (tabObj) {
	 			var cnt=0 ;
				InsertItem( "Substance Details" , "");
				InsertItem( "CFR/Others" , "");
				InsertItem( "Packing/IBC/Tank Instruction & Provision & Restrictions" , "");
				InsertItem( "Stowage and Segregation" , "");
				InsertItem( "Organic Peroxides & Self-Reactive Substances" , "");
	 		}
	 	break;
	 }
 }
 /**
  * Related event when clicking Tab
  * selected tab element activates.
  */
 function tab1_OnChange(tabObj , nItem) {
	 var objs=document.all.item("tabLayer");
	 objs[nItem].style.display="Inline";
	 //--------------- important point--------------------------//
	 for(var i = 0; i<objs.length; i++){
		 if(i != nItem){
			 objs[i].style.display="none";
			 objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		 }
	 }
	 //------------------------------------------------------//
	 beforetab=nItem;
	 tabIndex=nItem;
	 
 }
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
	 switch (sAction) {
	 	case IBSEARCH: // retrieve
	 		if (formObj.imdg_amdt_no.value == "") {
	 			ComShowCodeMessage('SCG50007', 'Amdt No.');
	 			return;
	 		}
	 		if (formObj.imdg_un_no.value == "") {
	 			ComShowCodeMessage('SCG50007', 'UN No.');
	 			ComSetFocus(formObj.imdg_un_no);
	 			return;
	 		}
	 		if (formObj.imdg_un_no_seq.value == "") {
	 			ComShowCodeMessage('SCG50007', 'substance details');
	 			ComSetFocus(formObj.imdg_un_no_seq);
	 			return;
	 		}
	 		break;
	 	case IBSAVE: // save
	 		if (formObj.imdg_amdt_no.value == "") {
	 			ComShowCodeMessage('SCG50007', 'Amdt No.');
	 			return;
	 		}	 		
	 		if (formObj.imdg_un_no.value == "") {
	 			ComShowCodeMessage('SCG50007', 'UN No.');
	 			ComSetFocus(formObj.imdg_un_no);
	 			return;
	 		}
	 		if (formObj.imdg_un_no_seq.value == "") {
	 			ComShowCodeMessage('SCG50007', 'substance details');
	 			ComSetFocus(formObj.imdg_un_no_seq);
	 			return;
	 		}
	 		if (formObj.frm_prp_shp_nm.value == "") {
	 			ComShowCodeMessage('SCG50007', 'proper shipping name');
	 			ComSetFocus(formObj.frm_prp_shp_nm);
	 			return;
	 		}
	 		if (comboObjects[1].GetSelectCode()== "") {
	 			ComShowCodeMessage('SCG50007', 'Class');
	 			ComSetFocus(formObj.frm_imdg_clss_cd);
	 			return;
	 		}
	 		break;    	  
	 	case IBSEARCH_ASYNC07: // Auto Creation retrieve
	 		if (comboObjects[1].GetSelectCode()== "" && sheetObj.id =="sheet2") {
	 			ComShowCodeMessage('SCG50007', 'Class');
	 			tabObjects[0].SetSelectedIndex(0);
	 			ComSetFocus(comboObjects[1]);
	 			return;
	 		}
	 		break;    	  			
	 }
	 return true;     
 }
 /**
  * when input value changed in IBSheet Object
  */
 function sheet2_OnChange(sheetObj,Row, Col, Value){
	 if (Col !=21) {
		 doActionIBSheet(sheetObj, document.form, IBROWSEARCH, Col, Row);
     	 obj_GetCellFontColor();
	 }
 }
 /**
  * when input value changed in IBSheet Object
  */
 function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
 	 obj_GetCellFontColor();
 }
 /**
  * when input value changed in IBSheet Object
  */
function obj_GetCellFontColor() {
	for (var i=1; i <21; i++ ) {
		if (sheetObjects[1].GetCellValue(1, i) != sheetObjects[2].GetCellValue(1, i)) {
			sheetObjects[1].SetCellFontColor(1, i,"#FF0000");
		}else{
			sheetObjects[1].SetCellFontColor(1, i,"#000000");
		}
	}
 }
 /**
  * Input only number in HTML Control's onkeypress event. <br>
  **/
 function obj_keypress(){
	 var formObj=document.form;
	 switch(event.srcElement.dataformat){
	 	case "int":
	        ComKeyOnlyNumber(event.srcElement);
			break;
		case "float":
	        ComKeyOnlyNumber(event.srcElement, ".");
			break;
        case "eng":
            ComKeyOnlyAlphabet(); 
            break;
        case "engup":
          	ComKeyOnlyAlphabet('uppernum');
            break;   
	}
	switch(ComGetEvent("name")){
		case "imdg_un_no":
	        ComKeyOnlyNumber(event.srcElement);
			break;
		case "frm_imdg_lmt_qty":
	        ComKeyOnlyNumber(event.srcElement);
			break;
		case "frm_flsh_pnt_temp_ctnt":
			ComKeyOnlyNumber(event.srcElement,"-~to ");
			break;
		case "frm_imdg_ctrl_temp":
			ComKeyOnlyNumber(event.srcElement,"-.");
			break;
		case "frm_imdg_emer_temp":
			ComKeyOnlyNumber(event.srcElement,"-.");
			break;
        case "frm_imdg_lmt_qty_desc":
          	ComKeyOnlyAlphabet('uppernum',"0123456789");
            break;
        case "frm_imdg_expt_qty_desc":
          	ComKeyOnlyAlphabet('uppernum',"0123456789");
            break;
	}
 }
 function obj_keyup(){
	 ComKeyEnter('LengthNextFocus');
	 var formObj=document.form;
	 switch(ComGetEvent("name")){
	 	case "frm_imdg_ctrl_temp":
			var point=event.srcElement.value.split(".");
			if (point[2] != undefined && point[2] == '') {
				event.srcElement.value=event.srcElement.value.substring(0,event.srcElement.value.length-1);					
			}
			break;			
		case "frm_imdg_emer_temp":
			var point=event.srcElement.value.split(".");
			if (point[2] != undefined && point[2] == '') {
				event.srcElement.value=event.srcElement.value.substring(0,event.srcElement.value.length-1);					
			}
			break;
		case "frm_cfr_rpt_qty":
			var point=event.srcElement.value.split(".");
			if (point[2] != undefined && point[2] == '') {
				event.srcElement.value=event.srcElement.value.substring(0,event.srcElement.value.length-1);					
			}
			break;
    }
 }
 function obj_blur() {
	 var formObj=document.form;
	 switch(ComGetEvent("name")){
	 	case "imdg_un_no":
	 		var length=formObj.imdg_un_no.value.length;
	 		if (length == 4) {
	 			clearBody();
	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);	 			
	 		}else if (length > 0){
     			ComShowCodeMessage('SCG50006',"UN No.", "4");
     			ComSetObjValue(this, "");
     			ComSetFocus(ComGetEvent());
     			//ComGetEvent("select");
//     			event.srcElement.focus();
//     			event.srcElement.select();
	 		}	
	 		break;
		case "frm_imdg_spcl_provi_no1": case "frm_imdg_spcl_provi_no2": case "frm_imdg_spcl_provi_no3": case "frm_imdg_spcl_provi_no4": case "frm_imdg_spcl_provi_no5": case "frm_imdg_spcl_provi_no6": case "frm_imdg_spcl_provi_no7": case "frm_imdg_spcl_provi_no8":
			if (ComGetEvent("value") != "") {
				for(i=1; i<9; i++){
					if (ComGetEvent("name") != eval("formObj.frm_imdg_spcl_provi_no"+i+".name")){
						if (event.srcElement.value == eval("formObj.frm_imdg_spcl_provi_no"+i+".value")) {
				    		ComShowCodeMessage('SCG50005', 'Data');
//							event.srcElement.value="";
				    		//ComGetEvent("value")="";
				    		ComSetObjValue(this, "");
		    	 			ComSetFocus(ComGetEvent());
							return;
						}
					}
				}
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
			}
			break;
		case "frm_n1st_imdg_pck_instr_cd": case "frm_n2nd_imdg_pck_instr_cd": case "frm_n3rd_imdg_pck_instr_cd":
			if (ComGetEvent("value") != "") {
				for(i=0; i<3; i++){
					if (ComGetEvent("name") != eval("formObj.frm_"+objNmSeq[i]+"_imdg_pck_instr_cd.name")){
						if (ComGetEvent("value") == eval("formObj.frm_"+objNmSeq[i]+"_imdg_pck_instr_cd.value")) {
				    		ComShowCodeMessage('SCG50005', 'Data');
//							event.srcElement.value="";
				    		//ComGetEvent("value")="";
				    		ComSetObjValue(this, "");
		    	 			ComSetFocus(ComGetEvent());
		    	 			return;
						}
					}
				}
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
			}
			break;
		case "frm_n1st_imdg_pck_provi_cd": case "frm_n2nd_imdg_pck_provi_cd": case "frm_n3rd_imdg_pck_provi_cd":  case "frm_n4th_imdg_pck_provi_cd": case "frm_n5th_imdg_pck_provi_cd":
			if (ComGetEvent("value") != "") {
				for(i=0; i<5; i++){
					if (ComGetEvent("name") != eval("formObj.frm_"+objNmSeq[i]+"_imdg_pck_provi_cd.name")){
						if (ComGetEvent("value") == eval("formObj.frm_"+objNmSeq[i]+"_imdg_pck_provi_cd.value")) {
				    		ComShowCodeMessage('SCG50005', 'Data');
//							event.srcElement.value="";
				    		//ComGetEvent("value")="";
				    		ComSetObjValue(this, "");
		    	 			ComSetFocus(ComGetEvent());
		    	 			return;
						}
					}
				}
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
			}
			break;
		case "frm_n1st_imdg_ibc_instr_cd": case "frm_n2nd_imdg_ibc_instr_cd": case "frm_n3rd_imdg_ibc_instr_cd": case "frm_n4th_imdg_ibc_instr_cd": case "frm_n5th_imdg_ibc_instr_cd":
			if (event.srcElement.value != "") {
				for(i=0; i<5; i++){
					if (ComGetEvent("name") != eval("formObj.frm_"+objNmSeq[i]+"_imdg_ibc_instr_cd.name")){
						if (ComGetEvent("value") == eval("formObj.frm_"+objNmSeq[i]+"_imdg_ibc_instr_cd.value")) {
				    		ComShowCodeMessage('SCG50005', 'Data');
//							event.srcElement.value="";
				    		//ComGetEvent("value")="";
				    		ComSetObjValue(this, "");
		    	 			ComSetFocus(ComGetEvent());
		    	 			return;
						}
					}
				}
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
			}
			break;
		case "frm_n1st_imdg_ibc_provi_cd": case "frm_n2nd_imdg_ibc_provi_cd": case "frm_n3rd_imdg_ibc_provi_cd": case "frm_n4th_imdg_ibc_provi_cd": case "frm_n5th_imdg_ibc_provi_cd":
			if (event.srcElement.value != "") {
				for(i=0; i<5; i++){
					if (ComGetEvent("name") != eval("formObj.frm_"+objNmSeq[i]+"_imdg_ibc_provi_cd.name")){
						if (ComGetEvent("value") == eval("formObj.frm_"+objNmSeq[i]+"_imdg_ibc_provi_cd.value")) {
				    		ComShowCodeMessage('SCG50005', 'Data');
//							event.srcElement.value="";
				    		//ComGetEvent("value")="";
				    		ComSetObjValue(this, "");
		    	 			ComSetFocus(ComGetEvent());
		    	 			return;
						}
					}
				}
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
			}
			break;
		case "frm_imdg_un_tnk_instr_cd":
			if (ComGetEvent("value") != "") {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
			}
			break;
		case "frm_n1st_imdg_tnk_instr_provi_cd": case "frm_n2nd_imdg_tnk_instr_provi_cd": case "frm_n3rd_imdg_tnk_instr_provi_cd":  case "frm_n4th_imdg_tnk_instr_provi_cd": case "frm_n5th_imdg_tnk_instr_provi_cd":
			if (ComGetEvent("value") != "") {
				for(i=0; i<5; i++){
					if (ComGetEvent("name")!= eval("formObj.frm_"+objNmSeq[i]+"_imdg_tnk_instr_provi_cd.name")){
						if (ComGetEvent("value") == eval("formObj.frm_"+objNmSeq[i]+"_imdg_tnk_instr_provi_cd.value")) {
				    		ComShowCodeMessage('SCG50005', 'Data');
//							event.srcElement.value="";
				    		//ComGetEvent("value")="";
				    		ComSetObjValue(this, "");
		    	 			ComSetFocus(ComGetEvent());
		    	 			return;
						}
					}
				}
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
			}
			break;
		case "frm_imdg_tec_nm":
			if (formObj.frm_imdg_tec_nm.value != ""){
				formObj.frm_imdg_tec_nm_desc.value=formObj.frm_imdg_tec_nm.value;
			}
			break;
    	}
	 ComChkObjValid(ComGetEvent());
}
 	
 	function clss_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	var formObj=document.form;
    	if (newCode == "1" || newCode == "1.1" || newCode == "1.2" || newCode == "1.3" || newCode == "1.4" || newCode == "1.5" || newCode == "1.6" ){
    		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
  			comboObjects[2].SetEnable(1);
    		comboObjects[2].SetSelectCode("A");
  		}else{
    		comboObjects[2].SetSelectCode("");
  			comboObjects[2].SetEnable(0);
  		}
    }
 	
 	
 	function imdg_amdt_no_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {

 		var formObj = document.form;
 		var cfrFlgObj = event.srcElement;
 		
		formObj.crte_imdg_un_no.value = NewCode;
		
		if (formObj.imdg_un_no_seq.value != "" && formObj.imdg_un_no.value != "") {
			
		//	formObj.crte_imdg_un_no.value = NewCode;
			
	 		var length=formObj.imdg_un_no.value.length;
	 		if (length == 4) {
	 			clearBody();
			    for(var k=0; k<comboObjects.length; k++){
			    	initCombo(comboObjects[k], k + 1);
			    }
			    comboObjects[0].SetSelectText(formObj.crte_imdg_un_no.value, false);
	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);	 			
	 		}else if (length > 0){
     			ComShowCodeMessage('SCG50006',"UN No.", "4");
     			ComGetEvent("focus");
     			ComGetEvent("select");
	 		}
	 		
		}
		

		
 	}
 	
 	// CFR flag onChange Event
 	function cfr_flg_OnChange(obj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
 		var formObj = document.form;
 		var cfrFlgObj = event.srcElement;
		
		if (formObj.imdg_un_no_seq.value != "" && formObj.imdg_un_no.value != "") {
			clearBody();
			//콤보초기화 
		    for(var k=0; k<comboObjects.length; k++){
		    	initCombo(comboObjects[k], k + 1);
		    }
		    comboObjects[0].SetSelectText(formObj.crte_imdg_un_no.value, false);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
		}
    }
 	
// 	var selComboIndex, selComboCode;
 	var newCode;
	function frm_imdg_subs_rsk_lbl_cd1_OnSelect(comboObj, index, text, code) {
//		selComboIndex = index;
//		selComboCode  = code;
		newCode = code;
	}
	function frm_imdg_subs_rsk_lbl_cd2_OnSelect(comboObj, index, text, code) {
		newCode = code;
	}
	function frm_imdg_subs_rsk_lbl_cd3_OnSelect(comboObj, index, text, code) {
		newCode = code;
	}
	function frm_imdg_subs_rsk_lbl_cd4_OnSelect(comboObj, index, text, code) {
		newCode = code;
	}
	function frm_imdg_subs_rsk_lbl_cd5_OnSelect(comboObj, index, text, code) {
		newCode = code;
	}
	
    function frm_imdg_subs_rsk_lbl_cd1_OnChange(comboObj) {
		var formObj = document.form;
		if (newCode != "" && (newCode == comboObjects[4].GetSelectCode() || newCode == comboObjects[5].GetSelectCode() || newCode == comboObjects[6].GetSelectCode())) {
			ComShowCodeMessage('SCG50005', 'Data');
//			comboObjects[3].SetSelectCode("");
			comboObjects[3].SetSelectText("");
		}else{
			formObj.frm_n1st_imdg_subs_rsk_lbl_cd.value = newCode;
		}
    }
    
    function frm_imdg_subs_rsk_lbl_cd2_OnChange(comboObj) {
		var formObj=document.form;
		//alert("newCode : "+newCode+", comboObjects[3].GetSelectCode() : "+comboObjects[3].GetSelectCode()+", comboObjects[5].GetSelectCode() : "+comboObjects[5].GetSelectCode());
		if (newCode != "" && (newCode == comboObjects[3].GetSelectCode() || newCode == comboObjects[5].GetSelectCode() || newCode == comboObjects[6].GetSelectCode())) {
			ComShowCodeMessage('SCG50005', 'Data');
//			comboObjects[4].SetSelectCode("");
			comboObjects[4].SetSelectText("");
		}else{
			formObj.frm_n2nd_imdg_subs_rsk_lbl_cd.value = newCode;
		}
    }
    
    function frm_imdg_subs_rsk_lbl_cd3_OnChange(comboObj) {
		var formObj=document.form;
		if (newCode != "" && (newCode == comboObjects[3].GetSelectCode() || newCode == comboObjects[4].GetSelectCode() || newCode == comboObjects[6].GetSelectCode())) {
			ComShowCodeMessage('SCG50005', 'Data');
//			comboObjects[5].SetSelectCode("");
			comboObjects[5].SetSelectText("");
		}else{
			formObj.frm_n3rd_imdg_subs_rsk_lbl_cd.value = newCode;
		}
    }
    
    function frm_imdg_subs_rsk_lbl_cd4_OnChange(comboObj) {
		var formObj=document.form;
		if (newCode != "" && (newCode == comboObjects[3].GetSelectCode() || newCode == comboObjects[4].GetSelectCode() || newCode == comboObjects[5].GetSelectCode())) {
			ComShowCodeMessage('SCG50005', 'Data');
//			comboObjects[6].SetSelectCode("");
			comboObjects[6].SetSelectText("");
		}else{
			formObj.frm_n4th_imdg_subs_rsk_lbl_cd.value = newCode;
		}
    }

    function frm_segr_as_for_imdg_clss_cd_OnBlur(comboObj) {
    	if(comboObj.GetSelectCode() == ""){
    		var formObj=document.form;
    		formObj.frm_segr_as_for_imdg_clss_flg.checked=false;
    		comboObj.SetEnable(0);
    	}
    }
    
    function frm_away_fm_imdg_clss_cd_OnBlur(comboObj) {
    	if(comboObj.GetSelectCode() == ""){
    		var formObj=document.form;
    		formObj.frm_away_fm_imdg_clss_flg.checked=false;
    		comboObj.SetEnable(0);
    	}
    }
    
    function frm_sprt_fm_imdg_clss_cd_OnBlur(comboObj) {
    	if(comboObj.GetSelectCode() == ""){
    		var formObj=document.form;
    		formObj.frm_sprt_fm_imdg_clss_flg.checked=false;
    		comboObj.SetEnable(0);
    	}
    }
  
    function frm_sprt_hld_fm_imdg_clss_cd_OnBlur(comboObj) {
    	if(comboObj.GetSelectCode() == ""){
    		var formObj=document.form;
    		formObj.frm_sprt_hld_fm_imdg_clss_flg.checked=false;
    		comboObj.SetEnable(0);
    	}
    }
    
    function frm_sprt_lon_fm_imdg_clss_cd_OnBlur(comboObj) {
    	if(comboObj.GetSelectCode() == ""){
    		var formObj=document.form;
    		formObj.frm_sprt_lon_fm_imdg_clss_flg.checked=false;
    		comboObj.SetEnable(0);
    	}
    }
    
    function frm_away_dp_seq_OnBlur(comboObj) {
    	if(comboObj.GetSelectCode() == ""){
    		var formObj=document.form;
    		formObj.frm_away_fm_imdg_segr_grp_flg.checked=false;
    		comboObj.SetEnable(0);
    	}
    }
    
    function frm_sprt_dp_seq_OnBlur(comboObj) {
    	if(comboObj.GetSelectCode() == ""){
    		var formObj=document.form;
    		formObj.frm_sprt_fm_imdg_segr_grp_flg.checked=false;
    		comboObj.SetEnable(0);
    	}
    }

 	/*
	function subsRskLbl1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, code, text) {
		var formObj = document.form;
		if (newCode != "" && (newCode == comboObjects[4].GetSelectCode() || newCode == comboObjects[5].GetSelectCode() || newCode == comboObjects[6].GetSelectCode())) {
			ComShowCodeMessage('SCG50005', 'Data');
//			comboObjects[3].SetSelectCode("");
			comboObjects[3].SetSelectText("");
		}else{
			formObj.frm_n1st_imdg_subs_rsk_lbl_cd.value = newCode;
		}
	}
	function subsRskLbl2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, code, text) {
		var formObj=document.form;
		//alert("newCode : "+newCode+", comboObjects[3].GetSelectCode() : "+comboObjects[3].GetSelectCode()+", comboObjects[5].GetSelectCode() : "+comboObjects[5].GetSelectCode());
		if (newCode != "" && (newCode == comboObjects[3].GetSelectCode() || newCode == comboObjects[5].GetSelectCode() || newCode == comboObjects[6].GetSelectCode())) {
			ComShowCodeMessage('SCG50005', 'Data');
//			comboObjects[4].SetSelectCode("");
			comboObjects[4].SetSelectText("");
		}else{
			formObj.frm_n2nd_imdg_subs_rsk_lbl_cd.value = newCode;
		}
	}
	function subsRskLbl3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, code, text) {
		var formObj=document.form;
		if (newCode != "" && (newCode == comboObjects[3].GetSelectCode() || newCode == comboObjects[4].GetSelectCode() || newCode == comboObjects[6].GetSelectCode())) {
			ComShowCodeMessage('SCG50005', 'Data');
//			comboObjects[5].SetSelectCode("");
			comboObjects[5].SetSelectText("");
		}else{
			formObj.frm_n3rd_imdg_subs_rsk_lbl_cd.value = newCode;
		}
	}
	function subsRskLbl4_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, code, text) {
		var formObj=document.form;
		if (newCode != "" && (newCode == comboObjects[3].GetSelectCode() || newCode == comboObjects[4].GetSelectCode() || newCode == comboObjects[5].GetSelectCode())) {
			ComShowCodeMessage('SCG50005', 'Data');
//			comboObjects[6].SetSelectCode("");
			comboObjects[6].SetSelectText("");
		}else{
			formObj.frm_n4th_imdg_subs_rsk_lbl_cd.value = newCode;
		}
	}*/
	// [06/25/2014] Fix bug: #35887 - Luc Duong (E)
    
function unNoSeqPrev() {
	var formObj=document.form;
	
	if (formObj.imdg_un_no.value == "") {
		return;
	}
	
	var cfrFlg=formObj.cfr_flg.checked;
	var unNo=formObj.imdg_un_no.value;
	var unNoSeq=parseInt(formObj.imdg_un_no_seq.value);
	var unNoSeqChk;
	if(cfrFlg){
		unNoSeqChk=parseInt(formObj.imdg_un_no_seq.value);
	}else{
		if(formObj.imdg_un_no_seq.value.length == 4){
			unNoSeqChk=parseInt(formObj.imdg_un_no_seq.value.substring(2,4));	
		}else{
			unNoSeqChk=parseInt(formObj.imdg_un_no_seq.value);
		}
	}
	//var unNoSeq=parseInt(formObj.imdg_un_no_seq.value.substring(2,4));
	var maxSeq=parseInt(formObj.imdg_un_no_seq_max.value);
	var minSeq=parseInt(formObj.imdg_un_no_seq_min.value);
	var totCnt=formObj.imdg_un_no_seq_cnt.value;
	var exptNm=formObj.frm_imdg_crr_rstr_expt_nm.value;
	var updId=formObj.frm_upd_usr_id.value;
	var updDt=formObj.frm_upd_dt.value;
	var crteImdgUnNo=formObj.crte_imdg_un_no.value;
	
	if (formObj.imdg_un_no_seq.value == "" ) {
		ComShowCodeMessage('SCG50007', 'UN No.');
		ComSetFocus(formObj.imdg_un_no);
		return;
	}else if (unNoSeqChk > 1 && unNoSeqChk != 490 && (unNoSeq-1 >= minSeq)){
		if (sheetObjects[0].GetCellValue(2,"imdg_un_no") != undefined) {
			ComResetAll();
			formObj.imdg_un_no.value=unNo;
			formObj.imdg_un_no_seq_max.value=maxSeq;
			formObj.imdg_un_no_seq_min.value=minSeq;
			formObj.imdg_un_no_seq_cnt.value=totCnt;
			//formObj.frm_upd_usr_id.value = updId;
			//formObj.frm_upd_dt.value=updDt;
			formObj.frm_imdg_crr_rstr_expt_nm.value=exptNm;
			formObj.crte_imdg_un_no.value=crteImdgUnNo;
			comboObjects[0].SetSelectText(formObj.crte_imdg_un_no.value, false);
			formObj.cfr_flg.checked=cfrFlg;
			
    		if (sheetObjects[1].LastRow()< 1 ) {
  				sheetObjects[1].DataInsert(-1);
  			}
		}
 		formObj.imdg_un_no_seq.value=unNoSeq-1;
	}else{
	}
}

function unNoSeqNext() {
	var formObj=document.form;
	
	if (formObj.imdg_un_no.value == "") {
		return;
	}
	var unNo=formObj.imdg_un_no.value;
	var unNoSeq=formObj.imdg_un_no_seq.value;
	var maxSeq=parseInt(formObj.imdg_un_no_seq_max.value);
	var minSeq=parseInt(formObj.imdg_un_no_seq_min.value);
	var totCnt=formObj.imdg_un_no_seq_cnt.value;
	var exptNm=formObj.frm_imdg_crr_rstr_expt_nm.value;
	var cfrFlg=formObj.cfr_flg.checked;
	//var updId 	= formObj.frm_upd_usr_id.value;
	var updDt=formObj.frm_upd_dt.value;
	var crteImdgUnNo=formObj.crte_imdg_un_no.value;
	if (maxSeq > 0) {
 		if (formObj.imdg_un_no_seq.value == "" ) {
 			ComShowCodeMessage('SCG50007', 'substance details');
 			ComSetFocus(formObj.imdg_un_no);
 			return;
 		}else if (parseInt(formObj.imdg_un_no_seq.value)+1 > maxSeq ){
 			if (ComShowCodeConfirm("SCG50025")) {
 				if (sheetObjects[0].GetCellValue(2,"imdg_un_no") != undefined) {
	 				ComResetAll();
	 				formObj.imdg_un_no.value=unNo;
	 				formObj.imdg_un_no_seq_max.value=maxSeq;
	 				formObj.imdg_un_no_seq_min.value=minSeq;
	 				formObj.imdg_un_no_seq_cnt.value=totCnt;
	 				formObj.frm_imdg_crr_rstr_expt_nm.value=exptNm;
	 				formObj.crte_imdg_un_no.value=crteImdgUnNo;
	 				comboObjects[0].SetSelectText(formObj.crte_imdg_un_no.value, false);
	 				//formObj.frm_upd_usr_id.value = updId;
	 				//formObj.frm_upd_dt.value=updDt;
	 				formObj.cfr_flg.checked=cfrFlg;
            		if (sheetObjects[1].LastRow()< 1 ) {
          				sheetObjects[1].DataInsert(-1);
          			}
 				}
 				formObj.imdg_un_no_seq.value=maxSeq+1;
			}
 		}else{
 			if (sheetObjects[0].GetCellValue(2,"imdg_un_no") != undefined) {
				ComResetAll();
				formObj.imdg_un_no.value=unNo;
				formObj.imdg_un_no_seq_max.value=maxSeq;
				formObj.imdg_un_no_seq_min.value=minSeq;
				formObj.imdg_un_no_seq_cnt.value=totCnt;
				formObj.frm_imdg_crr_rstr_expt_nm.value=exptNm;
				formObj.crte_imdg_un_no.value=crteImdgUnNo;
 				comboObjects[0].SetSelectText(formObj.crte_imdg_un_no.value, false);
				//formObj.frm_upd_usr_id.value = updId;
				//formObj.frm_upd_dt.value=updDt;
				formObj.cfr_flg.checked=cfrFlg;
	    		if (sheetObjects[1].LastRow()< 1 ) {
	  				sheetObjects[1].DataInsert(-1);
	  			}
			}
	 		formObj.imdg_un_no_seq.value=parseInt(unNoSeq)+1; 			
		}
	}
}

function clearAll() {
	var formObj=document.form;
	formObj.reset();
	sheet1.RemoveAll();
	sheet2.RemoveAll();
	sheet3.RemoveAll();
	sheet2.DataInsert(-1);
    for(var k=0; k<comboObjects.length; k++){
    	comboObjects[k].RemoveAll();
    	initCombo(comboObjects[k], k + 1);
    }
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);	//UN Class
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);	//Excepted Q'ty, Away from SG/Separated from SG 
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC08);	//Marine pollutant
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC09);	//Packing group
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC10);	//Amdt No
}
function clearBody() {
	var formObj=document.form;
	formObj.frm_hcdg_flg.checked=false;
	formObj.frm_hcdg_dpnd_qty_flg.checked=false;
	formObj.frm_imdg_un_no_hld_flg.checked=false;
	formObj.frm_segr_as_for_imdg_clss_flg.checked=false;		
	formObj.frm_away_fm_imdg_clss_flg.checked=false;
	formObj.frm_sprt_fm_imdg_clss_flg.checked=false;
	formObj.frm_sprt_hld_fm_imdg_clss_flg.checked=false;
	formObj.frm_sprt_lon_fm_imdg_clss_flg.checked=false;
	formObj.frm_away_fm_imdg_segr_grp_flg.checked=false;
	formObj.frm_sprt_fm_imdg_segr_grp_flg.checked=false;
	if (formObj.frm_segr_as_for_imdg_clss_flg.checked == true) {
		comboObjects[11].SetEnable(1);
	}else{
		comboObjects[11].SetEnable(0);
	}
	if (formObj.frm_away_fm_imdg_clss_flg.checked == true) {
		comboObjects[12].SetEnable(1);
	}else{
		comboObjects[12].SetEnable(0);
	}
	if (formObj.frm_sprt_fm_imdg_clss_flg.checked == true) {
		comboObjects[13].SetEnable(1);
	}else{
		comboObjects[13].SetEnable(0);
	}
	if (formObj.frm_sprt_hld_fm_imdg_clss_flg.checked == true) {
		comboObjects[14].SetEnable(1);
	}else{
		comboObjects[14].SetEnable(0);
	}
	if (formObj.frm_sprt_lon_fm_imdg_clss_flg.checked == true) {
		comboObjects[15].SetEnable(1);
	}else{
		comboObjects[15].SetEnable(0);
	}
	if (formObj.frm_away_fm_imdg_segr_grp_flg.checked == true) {
		comboObjects[16].SetEnable(1);
	}else{
		comboObjects[16].SetEnable(0);
	}
	if (formObj.frm_sprt_fm_imdg_segr_grp_flg.checked == true) {
		comboObjects[17].SetEnable(1);
	}else{
		comboObjects[17].SetEnable(0);
	}
	sheet1.RemoveAll();
	sheet2.RemoveAll();
	sheet3.RemoveAll();
	sheet1.DataInsert(-1);
	sheet2.DataInsert(-1);
	sheet1.SetCellValue(sheetObjects[0].LastRow(),"upd_usr_id",formObj.frm_upd_usr_id.value);
	sheet1.SetCellValue(sheetObjects[0].LastRow(),"upd_dt",formObj.frm_upd_dt.value);
	ComScgCopyRowToForm2(sheetObjects[0], formObj, sheetObjects[0].LastRow(), "frm_");
	sheet1.RemoveAll();
	comboObjects[7].SetSelectText("Blank");
	comboObjects[8].SetSelectText("Blank");
}
 
function ComScgCopyRowToForm2(sheetobj, formobj, row, prefix){
    //함수의 인자 유효성 확인-시작
	if ((!sheetobj) || (!sheetobj.IBSheetVersion)){
		return; // alert("IBS_CopyRowToForm 함수의 sheetobj 인자는 IBSheet 태그가 아닙니다.");
	} else if (formobj==null || typeof formobj != "object") {
		return; // IBS_ShowErrMsg("IBS_Sheetformobj 함수의 formobj 인자는 FORM 태그가 아닙니다.");
	} else if (row!=null && (isNaN(row) || row < 0 || row > sheetobj.LastRow())) {
		return;
	}
	//함수의 인자 유효성 확인-종료
	//HTML컨트롤의 name 앞에 붙는 글자
	if (prefix == null || prefix=="") prefix="frm_";
	if (row == null) row=sheetobj.GetSelectRow();
	//Sheet의 컬럼개수만큼 찾아서 HTML의 Form 각 Control에 값을 설정한다.
	//컬럼개수만큼 루프 실행
	for(var col=0;col<=sheetobj.LastCol();col++){
		//컬럼의 별명을 문자열로 가져온다.
		var col_alias=sheetobj.ColSaveName(col)
		if (col_alias=="") continue;
		var sheetvalue=sheetobj.GetCellValue(row,col);
		//폼에 있는 해당 이름의 컨트롤을 가져온다.예)"frm_CardNo"
		var frmchild=formobj.elements[prefix +col_alias];
		//폼에 해당하는 이름의 컨트롤이 없는 경우는 계속 진행한다.
		if(frmchild==null || frmchild == undefined) continue;
		var sType=frmchild.type;
		//radio의 경우 frmchild가 배열형태가 되므로, frmchild.type으로는 타입을 알수 없다.
		if (sType==undefined && frmchild.length>0) sType=frmchild[0].type;
		//타입별로 값을 설정한다.
		switch(sType) {
			case "button":
			case "reset":
			case "submit":
				break;
			case "radio":
				for (idx=0; idx<frmchild.length; idx++) {
					if(frmchild[idx].value == sheetvalue) {
						frmchild[idx].checked=true;
						break;
					}
				}
				break;
			case "checkbox":
				if(sheetvalue =="Y" || sheetvalue == 1){
					frmchild.checked=true;
				}else {
					frmchild.checked=false;
				}
				
				break;
			case "select-one":			
				var eOpt = frmchild.options;
				var idx = 0;
				if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
					var opt_len = eOpt.length;
					for ( var k = 0; k < opt_len; k++) {
						if (eOpt[k].value == sheetvalue) {
							idx = k;
							break;
						}
					}
				}
				frmchild.selectedIndex = idx;
				break;
			default :
				frmchild.value=sheetvalue;
		}//end of switch\
	
	}//end of for(col)
}

function copy(){
	var formObj=document.form;
	var length=formObj.imdg_un_no.value.length;
	if (length == 4) {
 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);	 			
	}
	sheetObjects[0].RemoveAll();
}
function segrClssFlg(){
	var formObj=document.form;
	if (formObj.frm_segr_as_for_imdg_clss_flg.checked == true) {
		comboObjects[11].SetEnable(1);
		comboObjects[11].SetSelectCode(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),"segr_as_for_imdg_clss_cd"));
	}else{
		comboObjects[11].SetEnable(0);
		comboObjects[11].SetSelectCode("");
	}
}
function awayClssFlg(){
	var formObj=document.form;
	if (formObj.frm_away_fm_imdg_clss_flg.checked == true) {
		comboObjects[12].SetEnable(1);
		comboObjects[12].SetSelectCode(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),"away_fm_imdg_clss_cd"));
	}else{
		comboObjects[12].SetEnable(0);
		comboObjects[12].SetSelectCode("");
	}
}
function sprtClssFlg(){
	var formObj=document.form;
	if (formObj.frm_sprt_fm_imdg_clss_flg.checked == true) {
		comboObjects[13].SetEnable(1);
		comboObjects[13].SetSelectCode(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),"sprt_fm_imdg_clss_cd"));
	}else{
		comboObjects[13].SetEnable(0);
		comboObjects[13].SetSelectCode("");
	}
}
function sprtHldClssFlg(){
	var formObj=document.form;
	if (formObj.frm_sprt_hld_fm_imdg_clss_flg.checked == true) {
		comboObjects[14].SetEnable(1);
		comboObjects[14].SetSelectCode(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),"sprt_hld_fm_imdg_clss_cd"));
	}else{
		comboObjects[14].SetEnable(0);
		comboObjects[14].SetSelectCode("");
	}
}
function sprtLonClssFlg(){
	var formObj=document.form;
	if (formObj.frm_sprt_lon_fm_imdg_clss_flg.checked == true) {
		comboObjects[15].SetEnable(1);
		comboObjects[15].SetSelectCode(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),"sprt_lon_fm_imdg_clss_cd"));
	}else{
		comboObjects[15].SetEnable(0);
		comboObjects[15].SetSelectCode("");
	}
}
function awaySegrGrpFlg(){
	var formObj=document.form;
	if (formObj.frm_away_fm_imdg_segr_grp_flg.checked == true) {
		comboObjects[16].SetEnable(1);
		comboObjects[16].SetSelectCode(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),"away_dp_seq"));
	}else{
		comboObjects[16].SetEnable(0);
		comboObjects[16].SetSelectCode("");
	}
}
function sprtSegrGrpFlg(){
	var formObj=document.form;
	if (formObj.frm_sprt_fm_imdg_segr_grp_flg.checked == true) {
		comboObjects[17].SetEnable(1);
		comboObjects[17].SetSelectCode(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),"sprt_dp_seq"));
	}else{
		comboObjects[17].SetEnable(0);
		comboObjects[17].SetSelectCode("");
	}
}
/**
 * Clicking file open in Packing / IBC / Tank Instructions & Provisions
 */
function openFile(srcName) {
//	var formObj=document.form;
//	var objName=srcName.replace('btns_','').replace('_cd','_file');
//	if (sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),objName) != "" ) {
//		location.href="/opuscntr/FileDownload?key="+sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),objName);
//	}else{
//		ComShowCodeMessage('SCG50004', 'Data');
//	}
	
	var formObj = document.form;
	var objName = srcName.replace('btns_','frm_').replace('_file', '_cd');
	var objName2 = srcName.replace('btns_','frm_').replace('_cd', '_seq');
 
	//ComOpenPopupWithTarget('/opuscntr/VOP_SCG_0060Pop.do?imdg_pck_instr_cd='+eval("formObj."+objName+".value")+'&imdg_pck_instr_seq='+eval("formObj."+objName2+".value"), 1025, 643, objName, "1,0", true);
	ComOpenPopupWithTarget('/opuscntr/VOP_SCG_0060Pop.do?imdg_pck_instr_cdObj='+objName+'&imdg_pck_instr_cd='+eval("formObj."+objName+".value")+'&imdg_pck_instr_seqObj='+objName2+'&imdg_pck_instr_seq='+eval("formObj."+objName2+".value"), 1025, 643, objName, "1,0", true);
}
/**
 * Clicking popup in IBSheet Object
 */
function onPopupClick(srcName){
	var formObj=document.form;
	var objName=ComGetEvent("name").replace('btn_','frm_');
	ComOpenPopupWithTarget('/opuscntr/VOP_SCG_0059Pop.do?imdg_spcl_provi_no='+eval("formObj."+objName+".value")+'&objName='+objName, 1025, 693, objName, "1,0", true);
	//document.getElementsByName(objName)[0].fireEvent("onblur");
}



$(document).ready(function(){
	$("input[name*='imdg_pck_instr_cd']").dblclick(function(){
		var fileKey = sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));
		if(fileKey != ""){
			location.href="/opuscntr/FileDownload?key="+sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));	
		}
	});
	$("input[name*='imdg_pck_provi_cd']").dblclick(function(){
		var fileKey = sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));
		if(fileKey != ""){
			location.href="/opuscntr/FileDownload?key="+sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));	
		}
	});	

	$("input[name*='imdg_ibc_instr_cd']").dblclick(function(){
		var fileKey = sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));
		if(fileKey != ""){
			location.href="/opuscntr/FileDownload?key="+sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));	
		}
	});	
	
	$("input[name*='imdg_ibc_provi_cd']").dblclick(function(){
		var fileKey = sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));
		if(fileKey != ""){
			location.href="/opuscntr/FileDownload?key="+sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));	
		}
	});	
	
	$("input[name*='imdg_un_tnk_instr_cd']").dblclick(function(){
		var fileKey = sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));
		if(fileKey != ""){
			location.href="/opuscntr/FileDownload?key="+sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));	
		}
	});	
	
	$("input[name*='imdg_tnk_instr_provi_cd']").dblclick(function(){
		var fileKey = sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));
		if(fileKey != ""){
			location.href="/opuscntr/FileDownload?key="+sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), $(this).attr("name").replace("frm_","").replace("_cd","_file"));	
		}
	});	
});
