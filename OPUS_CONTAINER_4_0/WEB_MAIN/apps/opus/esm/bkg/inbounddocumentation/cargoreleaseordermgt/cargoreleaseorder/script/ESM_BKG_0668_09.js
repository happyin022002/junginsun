/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0668_09.js
*@FileTitle  : Inbound Cargo Release Order for POD Office(US)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

//global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetNames=new Array("master","container","bkg_do_ref","bkg_cgo_rlse","otsRcvInfo","sheet_bl_status");
var sheetCnt=0;
var btnMode="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject1=sheetObjects[sheetNames[0]];
         var sheetObject2=sheetObjects[sheetNames[1]];
         var sheetObject3=sheetObjects[sheetNames[2]];
		 var sheetObject4=sheetObjects[sheetNames[3]];
         /*******************************************************/
         var formObject=document.form;
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_start_date":
					var cal=new ComCalendar();
					cal.select(formObject.start_date, 'yyyy-MM-dd');
					break;
				case "btn_end_date":
					var cal=new ComCalendarFromTo();
		             cal.select(formObject.start_date, formObject.end_date, 'yyyy-MM-dd');
					break;
				case "btn_Transmit":
					btnMode="SAVE";
					fncBtnTransmit();
					break;
				case "btn_Save":
					btnMode="SAVE";
					fncBtnSave();
					break;
				case "btn_Hold":
					btnMode="HOLD";
					fncBtnHold();
					break;
				case "btn_History":
					fncBtnHistory();
					break;
				case "btn_DownExcel":
					if(sheetObject1.rowcount < 1){
             			ComShowCodeMessage("BKG00109");
             		}else{
             			sheetObject1.Down2Excel({ HiddenColumn:true,Merge:true,TreeLevel:false});
					}
					break;
				case "btn_Print":
					formObject.f_cmd.value=MULTI11;
					sheetObjects["master"].DoSearch("ESM_BKG_0946GS.do",FormQueryString(formObject ));

					break;
				case "btn_tpb":
                    var sheetObjMaster=sheetObjects["master"];
					var formObj=document.form;
					var selRow=sheetObjMaster.GetSelectRow();
					var bkgNo=sheetObjMaster.GetCellValue(selRow, "master_" + "bkg_no");
                    var frDate=ComGetDateAdd(null, "D", -60);
                    var toDate=ComGetNowInfo("ymd", "");
                    var otsStsCd="";
                    if (document.form.tpb_status.value == "1") {
                    	otsStsCd="P";
                    } else {
                    	otsStsCd="T";
                    }
					var condition="?";
                    condition += "s_state=BKG";
					condition += "&s_ots_sts_cd=" + otsStsCd;
                    condition += "&s_bkg_no_all="+bkgNo;
                    condition += "&s_bl_no_all="+sheetObjMaster.GetCellValue(selRow, "master_" + "bl_no");
                    condition += "&pgmNo=ESD_TPB_0134";
					ComOpenWindowCenter('/opuscntr/ESD_TPB_0134.do'+condition, 'win4', 1024, 650, false);
					break;
				case "btn_dmdt":
					var sheetObjMaster=sheetObjects["master"];
					var formObj=document.form;
					var selRow=sheetObjMaster.GetSelectRow();
					var bkgNo=sheetObjMaster.GetCellValue(selRow, "master_" + "bkg_no");
					var blNo=sheetObjMaster.GetCellValue(selRow, "master_" + "bl_no");
                    var trfCd=formObj.demur_type.value;
                    var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd;
                    //ComOpenWindowCenter('/opuscntr/EES_DMT_3002P.do' + paramVal, 'dmdt', 1010, 500, true);
                    
                    ComOpenWindow("/opuscntr/EES_DMT_3002P.do"+paramVal, "dmdt", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:720px;dialogLeft:0;dialogTop:0", false);
                    
					break;
				case "btn_srnd":
					var sheetObjMaster=sheetObjects["master"];
					var formObj=document.form;
					var selRow=sheetObjMaster.GetSelectRow();
					if( selRow == -1) return;
					var bkgNo=sheetObjMaster.GetCellValue(selRow, "master_" + "bkg_no");
					if(bkgNo == ""){
						return;
					}
					var condition="?";
                        condition += "bkg_no="+bkgNo;
                        condition += "&inquery_only=Y";
                        condition += "&pgmNo=ESM_BKG_0400";
                    ComOpenWindowCenter('/opuscntr/ESM_BKG_0400_POP.do'+condition, 'bl_surr_rmk', 900, 300, true);
					break;
            } // end switch
    }
    /**
     * IBTab Object regist array
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheet_obj.id]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		var formObj=document.form;
		for(i=0;i<sheetNames.length;i++){
			ComConfigSheet (sheetObjects[sheetNames[i]] );
			initSheet(sheetObjects[sheetNames[i]] ,i+1);
			ComEndConfigSheet(sheetObjects[sheetNames[i]] );
		}
	    initControl();
		//Initialization
		formObj.start_date.value=ComGetNowInfo('ymd','-');
		formObj.start_time.value="00:00";
		formObj.end_date.value=ComGetNowInfo('ymd','-');
		formObj.end_time.value="23:59";
		ComBtnDisable("btn_Transmit");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_tpb");
		ComBtnDisable("btn_Hold");
		ComBtnDisable("btn_History");
		//set blNo 
		formObj.bl_no.value=reqBlNo;
		if(reqBlNo == ""){
			return;
		}
		doActionIBSheet(sheetObjects["master"], formObj, IBSEARCH);
    }
	/**
	 * Set Initialization value and event of Control in screen
	 */
	function initControl() {
		//axon_event.addListenerForm ('blur', 'obj_deactivate', form);
		//axon_event.addListenerForm ('activate', 'obj_activate', form);
	}
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	 var cnt=0;
    	 var sheetID=sheetObj.id;
    	 switch(sheetObj.id) {
			case "master":      //master init
			    with(sheetObj){
			      var HeadTitle=" |No|B/L|PCS|VVD|POD|DEL|HUB|Last Update|Freight|Freight|O. B/L|O. B/L|Customs Clearance|Customs Clearance|Cargo Release|Cargo Release|Partial|Consignee Name|Remark(s)|do_hld_flg|obl_ttl_knt|bkg_no";
			      var prefix="master_";
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pcs_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hub_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"last_up_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"frt_clt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"f_last_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"o_last_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"c_last_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_snd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_last_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"prt_ind",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cust_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inter_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"do_hld_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_ttl_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetWaitImageVisible(0);
  	              //SetAutoRowHeight(0);
			      SetSheetHeight(100,1);
		      }



				break;
			case "container":      //sheet1 init
			    with(sheetObj){
			      var HeadTitle=" |Seq.|Container No.";
			      var prefix="container_";
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetCountPosition(0);
			      SetWaitImageVisible(0);
			      SetSheetHeight(85,1);
				}


				break;
		  case "bkg_do_ref":      //sheet1 init
			    with(sheetObj){
			      var HeadTitle=" |Seq.|bkg_no|inter_rmk|do_hld_flg|bl_no";
			      var prefix="bkg_do_ref_";
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inter_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_hld_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetCountPosition(0);
			    //  SetSheetHeight(65);
	            }


				break;
			case "bkg_cgo_rlse":      //sheet1 init
			    with(sheetObj){
			      var HeadTitle=" |Seq.|bl_no|frt_clt_flg|obl_rdem_flg|cstms_clr_cd|bl_rcv_knt";
			      var prefix="bkg_cgo_rlse_";
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"frt_clt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_rcv_knt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetCountPosition(0);
			     // SetSheetHeight(65);
	            }

				break;
			case "otsRcvInfo":
                /****************************************************************
                //Get whether the fare payment and Outstanding Amounts info 
                *****************************************************************/
			    with(sheetObj){
			      var HeadTitle=" |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5";
			      var prefix="otsRcvInfo_";
	
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetCountPosition(0);
			      SetVisible(0);
		        }

            break;
			case "sheet_bl_status":      //bl_status
			    with(sheetObj){
			      var HeadTitle=" |No|bl_status|bl_cpy_knt";
			      HeadTitle +="|bl_rlse|bl_rlse_ofc_cd|bl_rlse_usr_id|bl_rlse_dt";
			      HeadTitle +="|obl_rdem_knt|obl_rdem_ofc_cd|obl_rdem_usr_id|obl_rdem_dt";
			      HeadTitle +="|bl_ibd|bl_ibd_ofc_cd|bl_ibd_usr_id|bl_ibd_dt";
			      HeadTitle +="|bl_otr_doc_rcv_cd|otr_doc_rcv_ofc_cd|otr_doc_rcv_usr_id|otr_doc_rcv_dt";
			      HeadTitle +="|cnt_cd|del_cd|obl_iss_rmk";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      var prefix="sheet_bl_status_";
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_status",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_cpy_knt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_rlse",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_rlse_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_rlse_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_rlse_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_knt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_ibd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_ibd_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_ibd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_ibd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_otr_doc_rcv_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_ofc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"otr_doc_rcv_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
	              SetAutoRowHeight(0);
	              SetSheetHeight(260);
		      }
				break;
		}
	}
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
		var formObj=document.form;
        switch(sAction) {
          	case IBSEARCH:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return;
				ComBtnDisable("btn_Transmit");
				ComBtnDisable("btn_tpb");
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Hold");
				ComBtnDisable("btn_History");
				formObj.bkg_no.value="";
				formObj.req_pod_cd.value="";
				//Value clear
				formObj.inter_rmk.value="";
				sheetObjects["container"].RemoveAll();
          	    formObj.f_cmd.value=SEARCH;
	          	if (sheetObj.id=="master"){
					ComOpenWait(true);
 	          		sheetObj.DoSearch("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("master_") );
	          	}
                break;
        }
  }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
/**
 * Dbl Click handling
 */
	function master_OnDblClick(sheetObj,Row, Col){
		var formObj=document.form;
		var prefix="master_";
		formObj.bkg_no.value=sheetObj.GetCellValue(Row,prefix + "bkg_no");
		formObj.req_pod_cd.value=sheetObj.GetCellValue(Row,prefix + "pod_cd");
		formObj.curr_bl_no.value=sheetObj.GetCellValue(Row,prefix + "bl_no");
		fncSearchSheet2();
	}
	function fncSearchSheet2(){
		var formObj=document.form;
		var sheetObj=sheetObjects["container"];
		formObj.f_cmd.value=SEARCH02;
		sheetObj.DoSearch("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("container_") );
		return;
	}
/**
 * Dbl Click - End Event handling
 */
	function container_OnSearchEnd(sheetObj, Code , ErrMsg){
		ComOpenWait(false);
		var formObj=document.form;
		var Row=sheetObjects["master"].GetSelectRow();
		if(Row == -1) return;
		var prefix="master_";
		formObj.inter_rmk.value=sheetObjects["master"].GetCellValue(Row, prefix + "inter_rmk");
		formObj.obl_ttl_knt.value=sheetObjects["master"].GetCellValue(Row, prefix + "obl_ttl_knt");
		var doHldFlg=sheetObjects["master"].GetCellValue(Row, prefix + "do_hld_flg");
		if(doHldFlg == "Y"){
			formObj.do_hld_flg.value="HOLD";
			document.getElementById("btn_Hold").innerText="Hold Removal";
		}else{
			formObj.do_hld_flg.value="";
			document.getElementById("btn_Hold").innerText="Hold";
		}
		formObj.info_frt_clt_flg.value=sheetObjects["master"].GetCellValue(Row, prefix + "frt_clt_flg");
		formObj.info_obl_rdem_flg.value=sheetObjects["master"].GetCellValue(Row, prefix + "obl_rdem_flg");
		formObj.info_cstms_clr_cd.value=sheetObjects["master"].GetCellValue(Row, prefix + "cstms_clr_cd");
		//Get Erp info
		fncGetErpDem(sheetObj, formObj);
	}
	/**
	* Get ERP, DEM DET info
	*/
	function fncGetErpDem(sheetObj,formObj){
		formObj.f_cmd.value=SEARCH03;
 		var sXml=sheetObj.GetSearchData("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("container_"));
		var arrXml=sXml.split("|$$|");
		//ETC DATA Handling
		//demur Type
		if("undefined" != ComGetEtcData(arrXml[0], "demurType")){
			formObj.demur_type.value=ComGetEtcData(arrXml[0], "demurType");
		}
		//TPB
		if("undefined" != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != 'null'){
			formObj.tpb_status.value=ComGetEtcData(arrXml[0], "tpbStatus");
			tpbImgSet(formObj.tpb_status.value);
		}
		//ots Count
		for(var k=formObj.tot_ots_amt.options.length;k > -1; k--){
			formObj.tot_ots_amt.remove(k);
		}
		for(var x=0;x < ComGetEtcData(arrXml[0], "otsCnt");x++){
			var oOption=document.createElement("OPTION");
			formObj.tot_ots_amt.options.add(oOption);
			oOption.innerText=ComGetEtcData(arrXml[0], "ots"+x);
		}
		//input ERP data 
		for(var x=0;x < ComGetEtcData(arrXml[0], "otsCnt");x++){
			var oOption=document.createElement("OPTION");
			formObj.tot_ots_amt.options.add(oOption);
			oOption.innerText=ComGetEtcData(arrXml[0], "ots"+x);
			//if tot_ots_amt is 0, black, not 0 red
			var _otsValue=parseFloat(ComGetEtcData(arrXml[0], "ots"+x));
			if(_otsValue == 0 ){//black
				document.getElementById("tot_ots_amt").className="input2";
			}else{
				document.getElementById("tot_ots_amt").className="input2_1";
			}
		}
		//demAMT Clear
		for(var k=formObj.tot_bil_amt.options.length;k > -1; k--){
			formObj.tot_bil_amt.remove(k);
		}
		var oTotBilAmt=document.createElement("OPTION");
		formObj.tot_bil_amt.options.add(oTotBilAmt);
		if(undefined != ComGetEtcData(arrXml[0], "demAMT") && ComGetEtcData(arrXml[0], "demAMT") != 'null'){
			oTotBilAmt.innerText=ComGetEtcData(arrXml[0], "demAMT");
			//if demAMT is 0, black, not 0 red
			var _demAmtValue=ComGetEtcData(arrXml[0], "demAMT");
			if( _demAmtValue == "USD 0.0"){//black
				document.getElementById("tot_bil_amt").className="input2";
				document.getElementById("dem_status").style.color='blue';
				document.getElementById("dem_status").className="input2";
			}else{
				document.getElementById("tot_bil_amt").className="input2_1";
				document.getElementById("dem_status").style.color='red';
				document.getElementById("dem_status").className="input2_1";
			}
		}
		//dem status
		if("undefined" != ComGetEtcData(arrXml[0], "demStatus") && ComGetEtcData(arrXml[0], "demStatus") != 'null'){
			formObj.dem_status.value=ComGetEtcData(arrXml[0], "demStatus");
		}
		//get Original Bill of Lading Status info
		fncGetBLStatus();
	}
	/**
	* Get Original Bill of Lading Status info
	*/
	function fncGetBLStatus(){
		var formObj=document.form;
		var sheetObj=sheetObjects["sheet_bl_status"];
		formObj.f_cmd.value=SEARCH04;
  		sheetObj.DoSearch("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet_bl_status_") );
	}
	/**
	* Original Bill of Lading Status info Form set
	*/
	function sheet_bl_status_OnSearchEnd(sheetObj, Code, ErrMsg){
		var formObj=document.form;
		var sheetObj=sheetObjects["sheet_bl_status"];
		var colName=new Array("bl_cpy_knt"
			,"bl_status","bl_rlse_ofc_cd","bl_rlse_usr_id","bl_rlse_dt"
			,"obl_rdem_knt","obl_rdem_ofc_cd","obl_rdem_usr_id","obl_rdem_dt"
			,"bl_otr_doc_rcv_cd","otr_doc_rcv_ofc_cd","otr_doc_rcv_usr_id","otr_doc_rcv_dt"
			,"bl_ibd","bl_ibd_ofc_cd","bl_ibd_usr_id","bl_ibd_dt"
			,"obl_iss_rmk"
		);
		for(var i=0;i<colName.length;i++){
			
			if ( sheetObj.GetCellValue(1,"sheet_bl_status_" + colName[i]) != "-1") 
				document.getElementsByName(colName[i])[0].value=sheetObj.GetCellValue(1,"sheet_bl_status_" + colName[i]);
		}
		if (sheetObj.GetCellValue(1, "sheet_bl_status_" + "bl_status") == "S")
			{
				document.getElementById("btn_srnd").style.display="";
			}
		else{
				document.getElementById("btn_srnd").style.display="none";
			}
		ComOpenWait(false);
		//button handling
		ComBtnEnable("btn_Transmit");
		ComBtnEnable("btn_tpb");
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_Hold");
		ComBtnEnable("btn_History");
	}
/****************************************************
* save button click
* //test bl_no ; TAOA14018502
***************************************************/
	function fncBtnSave(){
		var formObj=document.form;
		var sheetObjMaster=sheetObjects["master"];
		var sheetObjRef=sheetObjects["bkg_do_ref"];
		var sheetObjCgoRlse=sheetObjects["bkg_cgo_rlse"];
		var sheetObjOblByCgo=sheetObjects["sheet_bl_status"];

		var Row;
		var selRow;
		var prefix;
		selRow=sheetObjMaster.GetSelectRow();
		/**************************
		* 1. Remark save
		***************************/
		sheetObjRef.RemoveAll();
		if(sheetObjMaster.GetCellValue(selRow,"master_" + "inter_rmk") != formObj.inter_rmk.value){
			Row=sheetObjRef.DataInsert();
			prefix="bkg_do_ref_";
			sheetObjRef.SetCellValue(Row,prefix + "bkg_no",formObj.bkg_no.value);
			sheetObjRef.SetCellValue(Row,prefix + "inter_rmk",formObj.inter_rmk.value);
			sheetObjRef.SetCellValue(Row,prefix + "bl_no",sheetObjMaster.GetCellValue(selRow,"master_" + "bl_no"));
		}
 		if(sheetObjRef.LastRow() < 1 ){
			alert("You didn't change any item.?Nothing to be saved.");
			return;
		}
		/**************************
		* 99. actual Handling
		***************************/
		//test bl_no ; TAOA14018502
		formObj.f_cmd.value=MULTI09;
		var aryPrefix=null;
		aryPrefix=new Array("bkg_do_ref_");    //prefix string array
		var sParam1=sheetObjects["bkg_do_ref"].GetSaveString(true);
		sParam=sParam1;
		sheetObjRef.DoSave("ESM_BKG_0909GS.do"	,FormQueryString(formObj) + "&" + sParam + "&" + ComGetPrefixParam(aryPrefix) ,-1,true);

	}
/****************************************************
* Transmit button click
* //test bl_no ; TAOA14018502
***************************************************/
	function fncBtnTransmit(){
		var formObj=document.form;
		var sheetObjMaster=sheetObjects["master"];
		var sheetObjRef=sheetObjects["bkg_do_ref"];
		var sheetObjCgoRlse=sheetObjects["bkg_cgo_rlse"];

		var Row;
		var selRow;
		var prefix;
		selRow=sheetObjMaster.GetSelectRow();
		//HOLD is Stop
		var holdValue=sheetObjMaster.GetCellValue(selRow,"master_" + "do_hld_flg");
		if(holdValue == "Y"){
			ComShowCodeMessage("BKG00649");
			return;
		}
		//No data Changed.
  		if(sheetObjRef.LastRow() < 2 && sheetObjCgoRlse.LastRow() < 2){
			alert("You didn't change any item.?Nothing to be saved.");
			return;
		}
		if(!ComShowCodeConfirm("BKG40084")){
			return;
		}
		//if Partial value is 'Y', if [F,O,C] value change, 'SAVE' don`t.
		var partialValue=sheetObjMaster.GetCellValue(selRow,"master_" + "prt_ind");
		if(partialValue == "Y"){
			ComShowCodeMessage("BKG40092");
		}
		/**************************
		* 1. Remark save
		***************************/
		sheetObjRef.RemoveAll();
		if(sheetObjMaster.GetCellValue(selRow,"master_" + "inter_rmk") != formObj.inter_rmk.value){
			Row=sheetObjRef.DataInsert();
			prefix="bkg_do_ref_";
			sheetObjRef.SetCellValue(Row,prefix + "bkg_no",formObj.bkg_no.value);
			sheetObjRef.SetCellValue(Row,prefix + "inter_rmk",formObj.inter_rmk.value);
			sheetObjRef.SetCellValue(Row,prefix + "bl_no",sheetObjMaster.GetCellValue(selRow,"master_" + "bl_no"));
		}
		/**************************
		* 2. BKG_CGO_RLSE UPDATE.
		***************************/
		sheetObjCgoRlse.RemoveAll();
		if(    (sheetObjMaster.GetCellValue(selRow,"master_" + "frt_clt_flg") != formObj.info_frt_clt_flg.value)
				|| (sheetObjMaster.GetCellValue(selRow,"master_" + "obl_rdem_flg") != formObj.info_obl_rdem_flg.value)
				|| (sheetObjMaster.GetCellValue(selRow,"master_" + "cstms_clr_cd") != formObj.info_cstms_clr_cd.value)
		  ){
			Row=sheetObjCgoRlse.DataInsert();
			prefix="bkg_cgo_rlse_";
			sheetObjCgoRlse.SetCellValue(Row,prefix + "bl_no",sheetObjMaster.GetCellValue(selRow,"master_" + "bl_no"));
			sheetObjCgoRlse.SetCellValue(Row,prefix + "frt_clt_flg",formObj.info_frt_clt_flg.value);
			sheetObjCgoRlse.SetCellValue(Row,prefix + "obl_rdem_flg",formObj.info_obl_rdem_flg.value);
			sheetObjCgoRlse.SetCellValue(Row,prefix + "cstms_clr_cd",formObj.info_cstms_clr_cd.value);
		}
  		if(sheetObjRef.LastRow() < 2 && sheetObjCgoRlse.LastRow() < 2){
			ComShowCodeMessage("BKG40083");
			return;
		}
		/**************************
		* 99. actual Handling
		***************************/
		//test bl_no ; TAOA14018502
		formObj.f_cmd.value=MULTI02;
		var aryPrefix=null;
		aryPrefix=new Array("bkg_do_ref_", "bkg_cgo_rlse_");    //prefix string array
		var sParam1=sheetObjects["bkg_do_ref"].GetSaveString(true);
        var sParam2=sheetObjects["bkg_cgo_rlse"].GetSaveString(true);
		sParam=sParam1 + "&" + sParam2 ;
		sheetObjCgoRlse.DoSave("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + sParam + "&" + ComGetPrefixParam(aryPrefix),-1,false);
	}
/**************************************************
* Hold
***************************************************/
	function fncBtnHold(){
		var formObj=document.form;
		var sheetObj=sheetObjects["bkg_do_ref"];
		var sheetObjMaster=sheetObjects["master"];
		selRow=sheetObjMaster.GetSelectRow();
		//if Partial value is 'Y', if [F,O,C] value change, 'SAVE' don`t.
		var partialValue=sheetObjMaster.GetCellValue(selRow,"master_" + "prt_ind");
		if(partialValue == "Y"){
			ComShowCodeMessage("BKG40092");
		}
		sheetObj.RemoveAll();
		var Row=sheetObj.DataInsert();
		var selRow=sheetObjects["master"].GetSelectRow();
		var prefix="bkg_do_ref_";
		sheetObj.SetCellValue(Row,prefix + "bkg_no",formObj.bkg_no.value);
		sheetObj.SetCellValue(Row,prefix + "bl_no",sheetObjMaster.GetCellValue(selRow,"master_" + "bl_no"));
		if(sheetObjMaster.GetCellValue(selRow,"master_" + "do_hld_flg") == "Y"){
			sheetObj.SetCellValue(Row,prefix + "do_hld_flg","N");
		}else if(sheetObjMaster.GetCellValue(selRow,"master_" + "do_hld_flg") == "N"){
			sheetObj.SetCellValue(Row,prefix + "do_hld_flg","Y");
		}else{
			sheetObj.SetCellValue(Row,prefix + "do_hld_flg","N");
		}
		formObj.f_cmd.value=MULTI03;
		var aryPrefix=null;
		aryPrefix=new Array("bkg_do_ref_");    //prefix string array
		var sParam1=sheetObjects["bkg_do_ref"].GetSaveString(true);
		sParam=sParam1;
		sheetObj.DoSave("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + sParam + "&" + ComGetPrefixParam(aryPrefix),-1,false	);
	}
 /**
  * Deactive Event Handling.
  * @return
  */
/*function obj_deactivate(){
    var objName=event.srcElement.name;
    var formObj=document.form;
    switch(objName) {
        case "start_date":
            ComChkObjValid(event.srcElement);
            break;
        case "end_date":
            ComChkObjValid(event.srcElement);
            break;
		case "start_time":
            ComChkObjValid(event.srcElement);
            break;
        case "end_time":
            ComChkObjValid(event.srcElement);
            break;
    }
}*/
/**
 * Form Object Active Event Handling.
 * @return
 */
/*function obj_activate(){
    var objName=event.srcElement.name;
    var formObj=document.form;
    switch(objName) {
        case "start_date":
            formObj.start_date.value=formObj.start_date.value.replace(eval("/-/gi"), "");
            break;
        case "end_date":
            formObj.end_date.value=formObj.end_date.value.replace(eval("/-/gi"), "");
            break;
		case "start_time":
			formObj.start_time.value=formObj.start_time.value.replace(eval("/:/gi"), "");
			break;
		case "end_time":
			formObj.end_time.value=formObj.end_time.value.replace(eval("/:/gi"), "");
			break;
    }
}*/
function fncBtnHistory(){
	var goUrl="";
	var param="";
	var formObj=document.form;
	var sheetObjMaster=sheetObjects["master"];
	selRow=sheetObjMaster.GetSelectRow();
	goUrl="/opuscntr/ESM_BKG_0923.do?";
	param += "1=1";
	param += "&bl_no="+sheetObjMaster.GetCellValue(selRow,"master_" + "bl_no");
		;
	param += "&pgmNo=ESM_BKG_0923";
	//If No selected, No Action
	ComOpenWindowCenter(goUrl + param,"ESM_BKG_0923",800,420,true);
}
/************************************************
* Get Demerage
*************************************************/
function fncGetDem(){
	return;
	var formObj=document.form;
	//multiple retrieve
	formObj.f_cmd.value=SEARCH03;
	var aryPrefix=new Array("otsRcvInfo_"); //prefix String Array
  	var sXml=sheetObjects["otsRcvInfo"].GetSearchData("ESM_BKG_0909GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
}
    //Set ERP info in Select Box 
    function addSel(sheetObj) {
        var sel=document.form.tot_ots_amt;
        var prefix="otsRcvInfo_";
        for (i=sel.length-1; i>=0; i--){
            sel.options[i]=null
        }
        if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")!='N'){
            document.form['tot_ots_amt'][0]=new Option('0');
            document.getElementById("tot_ots_amt").className="input2";
            document.getElementById("otsRcvInfo_tot_ots_sts_cd").value="Y";
            return;
        }
        var unit="";
        var amount="";
        for (j=0; j<5; j++){
        	unit=sheetObj.GetCellValue(1, "otsRcvInfo_"+"tot_ots_curr_cd"+parseInt(j+1));
        	amount=sheetObj.GetCellValue(1, "otsRcvInfo_"+"tot_ots_amt"+parseInt(j+1));
            if(! ComIsEmpty(unit) && amount > 0){
                document.form['tot_ots_amt'][j]=new Option(unit+' '+ComAddCommaRun(amount), j);
            }
        }
    }
    //Set image configuration, and code set values that received Info from TPB
    function tpbImgSet(tpbStatus) {
        if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;
        if(document.getElementById("tpb_status").value == "1"){
            document.getElementById("tpb_icon").src="img/btng_icon_green.gif";
            document.getElementById("tpb_cd").value='C';
            document.getElementById("btn_tpb").style.display="";
        }else if(document.getElementById("tpb_status").value == "0"){
            document.getElementById("tpb_icon").src="img/btng_icon_r.gif";
            document.getElementById("tpb_cd").value='P';
            document.getElementById("btn_tpb").style.display="";
        }else{
            document.getElementById("tpb_icon").src="img/btng_icon_g.gif";
            document.getElementById("tpb_cd").value='';
            document.getElementById("btn_tpb").style.display="none";
        }
    }
    /**
     * after Hidden IBSheet retrieve, handling
     * get Whether the fare payment and Outstanding Amounts info
     */
    function otsRcvInfo_OnSearchEnd(sheetObj, Code , ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, form, "");
                addSel(sheetObj);
            }
        }
    }
	function bkg_cgo_rlse_OnSaveEnd(sheetObj, Code,ErrMsg){
		var formObj=document.form;
		var sheetObjMaster=sheetObjects["master"];
		var selRow=sheetObjMaster.GetSelectRow();
		if (ErrMsg == "Data Saved Successfully!!") {
			//Master sheet change when saving data modified
			sheetObjMaster.SetCellValue(selRow,"master_" + "inter_rmk",formObj.inter_rmk.value);
			sheetObjMaster.SetCellValue(selRow,"master_" + "frt_clt_flg",formObj.info_frt_clt_flg.value);
			sheetObjMaster.SetCellValue(selRow,"master_" + "obl_rdem_flg",formObj.info_obl_rdem_flg.value);
			sheetObjMaster.SetCellValue(selRow,"master_" + "cstms_clr_cd",formObj.info_cstms_clr_cd.value);
			master_OnDblClick(sheetObjMaster,selRow, 1);//dblClick
		}
	}
	function bkg_do_ref_OnSaveEnd(sheetObj, Code, ErrMsg){
		var formObj=document.form;
		var sheetObjMaster=sheetObjects["master"];
		var selRow=sheetObjMaster.GetSelectRow();
		if (ErrMsg == "Data Saved Successfully!!") {
			self.location.reload();
		}
	}
	function sheet_bl_status_OnSaveEnd(sheetObj, Code, ErrMsg){
		var formObj=document.form;
		var sheetObjMaster=sheetObjects["master"];
		var selRow=sheetObjMaster.GetSelectRow();
		if (ErrMsg == "Data Saved Successfully!!") {
			master_OnDblClick(sheetObjMaster,selRow, 1);//dblClick
		}
	}
/*****************************************************************
* retrieved bl dbl click
******************************************************************/
	function master_OnSearchEnd(sheetObj, Code, ErrMsg){
		if(sheetObj.GetCellText(1,"master_"+"bl_no") != ""){
			master_OnDblClick(sheetObj,1, 5);
		}else{
			ComOpenWait(false);
		}
	}
function fnQueryExec(reqBlNo) {
	var formObj=document.form;
	if (reqBlNo != "") {
		formObj.bl_no.value=reqBlNo;
		doActionIBSheet(sheetObjects["master"], formObj, IBSEARCH);
    }
}
