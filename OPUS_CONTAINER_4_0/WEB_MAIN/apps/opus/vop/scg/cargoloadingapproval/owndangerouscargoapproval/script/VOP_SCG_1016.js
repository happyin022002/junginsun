/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_1016.js
*@FileTitle  : Application Request & Approval Status - Awkward
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
    	var sheetObject=sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	/*******************************************************/
    	var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
	 			case "btn_Retrieve":
	 				doActionIBSheet(sheetObject,document.form,IBSEARCH);
	 				break;
	 			case "btn_Save":
	 				doActionIBSheet(sheetObject,document.form,IBSAVE);
	 				break;
 				case "btn_DownExcel":
 					
                    var paramObj=new Object();
                    paramObj.title="Application Request"+ " § " +"Approval Status - Awkward";
                    paramObj.orientation="Portrait";
//                    paramObj.columnwidth="1:4.0200000000000005|5:13.4|6:5.36|7:5.628|8:2.68|9:9.38|10:5.628|11:2.68|14:5.36|16:5.36|17:4.0200000000000005|18:5.36|19:6.7|20:4.0200000000000005|21:5.36|22:10.05|23:4.0200000000000005|24:4.0200000000000005|25:4.0200000000000005|26:4.0200000000000005|27:6.03|28:9.38|29:9.38|30:4.0200000000000005|31:9.38|32:98.35600000000001";
                    paramObj.columnwidth=ComScgGetExcelDown(sheetObject);
                    paramObj.cols=ComScgGetExcelDownCols(sheetObject);
                    var url=ComScgGetPgmTitle(sheetObject, paramObj);
                    if(sheetObject.RowCount() < 1){//no data
                    	ComShowCodeMessage("COM132501");
                	}else{
                		var str = sheetObject.GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1,ReportXML:str});
                	} 					
 					
// 					if(sheetObject.RowCount() < 1){
// 						ComShowCodeMessage("COM132501");
// 					}else{
// 						sheetObject.Down2Excel();
// 					}
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
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
    	 var cnt=0;
     	switch(sheetObj.id) {
     		case "sheet1":      //sheet1 init
                with(sheetObj){
					var HeadTitle="Route\nSeq|APVL\nSeq.|Lane|VVD CD|VVD CD|VVD CD|POL|POD|BKG No.|Special\nType|CNTR\nSeq.|Requested|Requested|";
					HeadTitle += "Requested|Requested|Approval|Approval|Approval|Reject\nCode|Remark(s)|APVL\nRef. No.|";
					HeadTitle += "TPSZ|Commodity|Over All (cm)|Over All (cm)|Over All (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Post\nExtd|Gross\nWeight(kg)|Void\n(FEU)|bkg status||||||";
					var HeadTitle1="Route\nSeq|APVL\nSeq.|Lane|VVD CD|VVD CD|VVD CD|POL|POD|BKG No.|Special\nType|CNTR\nSeq.| |B.OFC|";
					HeadTitle1 += "DT(GMT)|By| |DT(GMT)|By|Reject\nCode|Remark(s)|APVL\nRef. No.|";
					HeadTitle1 += "TPSZ|Commodity|L|W|H|FWD|AFT|Left|Right|Height|Post\nExtd|Gross\nWeight(kg)|Void\n(FEU)|bkg status||||||";
					var headCount=ComCountHeadTitle(HeadTitle);
					
					SetConfig( { SearchMode:2, MergeSheet:9, Page:20, DataRowMerge:0 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"},
					{ Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_nm",          KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_rqst_seq",       KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rqst_auth_cd",            KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"rqst_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:71,   Align:"Center",  ColMerge:0,   SaveName:"rqst_gdt",                KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:81,   Align:"Center",  ColMerge:0,   SaveName:"rqst_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:71,   Align:"Center",  ColMerge:0,   SaveName:"auth_gdt",                KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:81,   Align:"Center",  ColMerge:0,   SaveName:"auth_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   Wrap:1 },
						{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   Wrap:1 },
						{Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_len",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   Wrap:1 },
						{Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_wdt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   Wrap:1 },
						{Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_hgt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   Wrap:1 },
						{Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ovr_fwrd_len",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   Wrap:1 },
						{Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ovr_bkwd_len",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   Wrap:1 },
						{Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ovr_lf_len",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   Wrap:1 },
						{Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ovr_rt_len",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   Wrap:1 },
						{Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ovr_hgt",                 KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   Wrap:1 },
						{Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"xtd_ovr_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,   UpdateEdit:0,   Wrap:1 },
						{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   Wrap:1 },
						{Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ovr_void_slt_qty",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   Wrap:1 },
						{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lst_rqst_dat_flg",        KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq",  KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",          KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vsl_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq",       KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 },
						{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                  Wrap:1 } ];
					
					InitColumns(cols);
					SetEditable(0);
					SetHeaderRowHeight(20);
					SetMergeCell(0, 3, 2, 3);
					SetWaitImageVisible(0);
					SetSheetHeight(310);
     			}
     		break;
     	}
     }
     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
         	case IBSEARCH:      //retrieve
         		if(validateForm(sheetObj,formObj,sAction))
         			ComOpenWait(true);
         			formObj.f_cmd.value=SEARCH;
          			sheetObj.DoSearch("VOP_SCG_1016GS.do", FormQueryString(formObj) );
    				setBkgStatus(sheetObj);
         			break; 			
         	case IBSAVE:        //save
				 if(!validateForm(sheetObj,formObj,sAction))return;
				 var sParam=ComGetSaveString(sheetObj);
     			 if (sParam == "") return;
				 if(!ComShowCodeConfirm('SCG50001', 'data')) return;
				 formObj.f_cmd.value=MULTI;
				 sheetObj.DoSave("VOP_SCG_1015GS.do", FormQueryString(formObj), '-1', false);
				 break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }
     function setBkgStatus(sheetObj)
     {
     	with(sheetObj)
     	{
     		if (GetCellText(sheetObj.LastRow(), "bkg_sts_cd") == "X") {
	     		document.getElementById("bkgStsDesc").style.color="red";
	     		document.getElementById("bkgStsDesc").innerHTML="Booking Cancelled";
     		}     		
     	}    	
     }
     function setAuthStat(sheetObj, row)
     {
     	with(sheetObj)
     	{
     		var auth=GetCellText(row, "spcl_cgo_auth_cd").substring(0,1);
      		SetCellFont("FontBold", row, "spcl_cgo_auth_cd",1);
			switch(auth)
			{
				case "R":
 					SetCellFontColor(row, "spcl_cgo_auth_cd","#FF862B");
					break;
				case "Y":
 					SetCellFontColor(row, "spcl_cgo_auth_cd","#4D964B");
					break;
				case "N":
 					SetCellFontColor(row, "spcl_cgo_auth_cd","#FF0000");
					break;
				case "P":
 					SetCellFontColor(row, "spcl_cgo_auth_cd","#2663E0");
					break;
			}
      		SetCellFont("FontBold", row, "rqst_auth_cd",1);
 			SetCellFontColor(row, "rqst_auth_cd","#FF862B");
     		var auth=GetCellText(row, "spcl_cgo_auth_rjct_cd");
//			switch(auth)
//			{
//				case "AAA":
//					CellFontColor(row, "spcl_cgo_auth_rjct_cd") = "#FF0000";
//					break;
//			}
     	}    	
     }
     function sheet1_OnSearchEnd(sheetObj, code, ErrMsg)
     {
    	 ComOpenWait(false);
    	 with(sheetObj)
    	 {
    		 var j=0;
    		 var k=0;
    		 var maxSeq=GetCellValue(LastRow(), "spcl_cgo_rqst_seq");
    		 var findSeq=FindText("spcl_cgo_rqst_seq", maxSeq);
    		 var nextSeq=findSeq;
    		 var arrBefData=new Array();
    		 var arrAftData=new Array();
    		 for (var i=LastRow(); i >= HeaderRows(); i --)
//    		 for (var i = 2; i <= LastRow; i ++)
    		 {
    			 setAuthStat(sheetObj, i);
    			 if (HeaderRows() != nextSeq && GetCellValue(i, "spcl_cgo_rqst_seq") == maxSeq) {
    				 arrAftData[k]=new Array();
					arrAftData[k][0]=GetCellValue(i, "cntr_tpsz_cd");
					arrAftData[k][1]=GetCellValue(i, "cmdt_nm");
					arrAftData[k][2]=GetCellValue(i, "ttl_dim_len");
					arrAftData[k][3]=GetCellValue(i, "ttl_dim_wdt");
					arrAftData[k][4]=GetCellValue(i, "ttl_dim_hgt");
					arrAftData[k][5]=GetCellValue(i, "ovr_fwrd_len");
					arrAftData[k][6]=GetCellValue(i, "ovr_bkwd_len");
					arrAftData[k][7]=GetCellValue(i, "ovr_lf_len");
					arrAftData[k][8]=GetCellValue(i, "ovr_rt_len");
					arrAftData[k][9]=GetCellValue(i, "ovr_hgt");
					arrAftData[k][10]=GetCellValue(i, "xtd_ovr_qty");
					arrAftData[k][11]=GetCellValue(i, "grs_wgt");
					arrAftData[k][12]=GetCellValue(i, "ovr_void_slt_qty");
					arrAftData[k][13]=GetCellValue(i, "awk_cgo_seq");
    				 arrAftData[k][14]=i;
    				 k++;
    			 }
			 	if (GetCellValue(findSeq-1, "awk_cgo_seq") == "") {
    				 findSeq--;
    			 }
			 	if (HeaderRows() != nextSeq && GetCellValue(findSeq-1, "spcl_cgo_rqst_seq") == GetCellValue(i, "spcl_cgo_rqst_seq")) {
    				 arrBefData[j]=new Array();
					arrBefData[j][0]=GetCellValue(i, "cntr_tpsz_cd");
					arrBefData[j][1]=GetCellValue(i, "cmdt_nm");
					arrBefData[j][2]=GetCellValue(i, "ttl_dim_len");
					arrBefData[j][3]=GetCellValue(i, "ttl_dim_wdt");
					arrBefData[j][4]=GetCellValue(i, "ttl_dim_hgt");
					arrBefData[j][5]=GetCellValue(i, "ovr_fwrd_len");
					arrBefData[j][6]=GetCellValue(i, "ovr_bkwd_len");
					arrBefData[j][7]=GetCellValue(i, "ovr_lf_len");
					arrBefData[j][8]=GetCellValue(i, "ovr_rt_len");
					arrBefData[j][9]=GetCellValue(i, "ovr_hgt");
					arrBefData[j][10]=GetCellValue(i, "xtd_ovr_qty");
					arrBefData[j][11]=GetCellValue(i, "grs_wgt");
					arrBefData[j][12]=GetCellValue(i, "ovr_void_slt_qty");
					arrBefData[j][13]=GetCellValue(i, "awk_cgo_seq");
    				 j++;
    			 }
    		 }
    		 for (var x=0; x <= j-1; x++)
    		 {
        		 for (var z=0; z <= k-1; z++)
        		 {
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][0] != arrAftData[z][0]) SetCellFontColor(arrAftData[z][14], "cntr_tpsz_cd","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][1] != arrAftData[z][1]) SetCellFontColor(arrAftData[z][14], "cmdt_nm","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][2] != arrAftData[z][2]) SetCellFontColor(arrAftData[z][14], "ttl_dim_len","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][3] != arrAftData[z][3]) SetCellFontColor(arrAftData[z][14], "ttl_dim_wdt","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][4] != arrAftData[z][4]) SetCellFontColor(arrAftData[z][14], "ttl_dim_hgt","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][5] != arrAftData[z][5]) SetCellFontColor(arrAftData[z][14], "ovr_fwrd_len","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][6] != arrAftData[z][6]) SetCellFontColor(arrAftData[z][14], "ovr_bkwd_len","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][7] != arrAftData[z][7]) SetCellFontColor(arrAftData[z][14], "ovr_lf_len","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][8] != arrAftData[z][8]) SetCellFontColor(arrAftData[z][14], "ovr_rt_len","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][9] != arrAftData[z][9]) SetCellFontColor(arrAftData[z][14], "ovr_hgt","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][10] != arrAftData[z][10]) SetCellFontColor(arrAftData[z][14], "xtd_ovr_qty","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][11] != arrAftData[z][11]) SetCellFontColor(arrAftData[z][14], "grs_wgt","#FF0000");
         			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][12] != arrAftData[z][12]) SetCellFontColor(arrAftData[z][14], "ovr_void_slt_qty","#FF0000");
        		 }
    		 }
    	 }
     }
     
     function sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
    		 	case "spcl_cgo_auth_rmk":
    		 		if (GetCellText(Row, "spcl_cgo_auth_rmk") != "") {
    		 			ComShowMemoPad(sheetObj, Row, Col, true, 200, 100);
    		 		}
    		 		break;
    		 	case "apro_ref_no":
    		 		if (GetCellText(Row, "lst_rqst_dat_flg") != "Y" && GetCellText(Row, "apro_ref_no") != "") {
    		 			ComShowMemoPad(sheetObj, Row, Col, true, 200, 80, 50);
    		 		}else if (GetCellText(Row, "lst_rqst_dat_flg") == "Y" && GetCellText(Row, "spcl_cgo_auth_cd") == "Y") {
    		 			ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
    		 		}
    		 		break;
    		 }
    	 }
     }
     
     function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
     	ComOpenWait(false);
     }
