
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0022.js
*@FileTitle  : SPCL CGO APVL for Partner Lines (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
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
     * @class vop_scg_0022 : business script for vop_scg_0022
     */
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Define global variables
    //////////////////////////////////////////////////////////////////////////////////////////  
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1; 
    var comboObjects=new Array();
	var comboCnt=0;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var prefixs=new Array("t1sheet1_","t2sheet1_");  
    var dupChkList=null; 
    var dgChk = 0;
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Define global variables
    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Received event from form of UI
    //////////////////////////////////////////////////////////////////////////////////////////    
    // Event handler processing by button click event */
    document.onclick=processButtonClick; 
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObjT1=sheetObjects[0];
        var sheetObjT2=sheetObjects[1];
        var comboObj=comboObjects[0]; 
        var tabObj=tabObjects[0];
        /*******************************************************/
        var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObjT1,formObj,IBSEARCH);
                    break;
                case "btn_new":
                	if(!validateForm(sheetObjects[ComGetObjValue(formObj.tabSelectedIdx)],formObj,IBCLEAR)) return;
                	ComResetAll();
                	//var initSelTxt = comboObj.FindIndex("ASR", 0);
            		//comboObj.Text = initSelTxt;
            	//	ComSetFocus(rgn_shp_opr_cd);
                	resetTab1(sheetObjT1);                	
                	resetTab2(sheetObjT2);
                    break;
                case "btn_save":
                	var sheetIdx=tabObj.GetSelectedIndex();
                	doActionIBSheet(sheetObjects[sheetIdx],formObj,IBSAVE);
                    break;
                case "btn_VVDpop":
					//VVD selecting popup open					
					var vsl_cd=ComGetObjValue(formObj.vsl_cd);
                	var sUrl="";
                	if(vsl_cd == ""){
                		sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
                		ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
                	}else{
                		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
                	}
					break;
                case "btn_Carrier":
                	ComOpenPopupWithTarget('/opuscntr/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.cgo_opr_cd), 600, 470, "crr_cd:cgo_opr_cd", "0,0,1,1,1", true);
                	break;
                /*** Tab DG (S) **/   
                case "btn_details":
                	doPopDetails(sheetObjT1, sheetObjT1.GetSelectRow());
                	break;
                case "btn_t1add":
                	var lastSeqNo=sheetObjT1.GetCellValue(sheetObjT1.LastRow(), prefixs[0]+"seqNo");
                	sheetObjT1.DataInsert(-1,0);							//create at last row[Sheet1]
                	//initializing items
                	//@@selectRow -> GetSelectRow() 일괄 수정
		        	var row=sheetObjT1.GetSelectRow();
		        	//alert("ComGetObjValue(document.form.vsl_cd)>>>"+ComGetObjValue(document.form.vsl_cd));
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"vsl_cd",ComGetObjValue(document.form.vsl_cd));	//,0
		        	//alert(sheetObjT1.GetCellValue(row, prefixs[0]+"vsl_cd"));
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"skd_voy_no",ComGetObjValue(document.form.skd_voy_no),0);
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"skd_dir_cd",ComGetObjValue(document.form.skd_dir_cd),0);
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"crr_cd",ComGetObjValue(document.form.crr_cd),0);
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"slan_cd",ComGetObjValue(document.form.slan_cd),0);
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"cgo_rqst_dt","",0);
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"auth_dt","",0);
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"bkg_ref_no","",0);
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"auth_sts_cd","",0);
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"apro_ref_no","",0);
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"spcl_cgo_rqst_seq","",0);
		        	if(isNaN(lastSeqNo)) {
		        		lastSeqNo=1;
		        	} else {
		        		lastSeqNo=parseInt(lastSeqNo) + 1;
		        	}
		        	sheetObjT1.SetCellValue(row, prefixs[0]+"seqNo",lastSeqNo,0);
		        	setAuthStat(sheetObjT1, row);
                	break;
		        case "btn_t1copy":	
		        	if(sheetObjT1.RowCount()!= 0) {
			        	sheetObjT1.DataCopy();	//copy below selected row[Sheet1]
			        	//initializing items
			        	var row=sheetObjT1.GetSelectRow();
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"cgo_rqst_dt","",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"auth_dt","",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"bkg_ref_no","",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"dcgo_ref_no","",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"auth_sts_cd","",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"apro_ref_no","",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"spcl_cgo_rqst_seq","",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"apro_ref_no","",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"spcl_cntr_seq","1",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"spcl_cgo_seq","1",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"seqNo","",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"del_chk","0",0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"slan_cd",ComGetObjValue(formObj.slan_cd),0);
			        	sheetObjT1.SetCellValue(row, prefixs[0]+"prnr_cgo_rqst_seq","");
			        	
			        	setAuthStat(sheetObjT1, row);		        	
			        	//move below selected Booking
			        	var curRowNo=sheetObjT1.GetCellValue(row-1, prefixs[0]+"seqNo");
			        	var moveRowIdx=sheetObjT1.LastRow();
			        	if(row != moveRowIdx) {
			        		moveRowIdx=sheetObjT1.FindText(sheetObjT1.SaveNameCol(prefixs[0]+"seqNo"), parseInt(curRowNo)+1);
				        	if(moveRowIdx == -1) {
				        		moveRowIdx=sheetObjT1.LastRow()+1;
				        	}
				        	if(row != parseInt(moveRowIdx)-1) sheetObjT1.DataMove(moveRowIdx);
			        	}
			        	var startSeqNo=parseInt(sheetObjT1.GetCellValue(sheetObjT1.GetSelectRow()-1,prefixs[0]+"seqNo"));
			        	var currSeqNo="0";
			        	var befoSeqNo="0";
			        	for(var rowIdx=sheetObjT1.GetSelectRow(); rowIdx<=sheetObjT1.LastRow(); rowIdx++) {
			        		currSeqNo=sheetObjT1.GetCellValue(rowIdx,prefixs[0]+"seqNo");
			        		if(currSeqNo != befoSeqNo) sheetObjT1.SetCellValue(rowIdx,prefixs[0]+"seqNo",++startSeqNo,0);
			        		else sheetObjT1.SetCellValue(rowIdx,prefixs[0]+"seqNo",startSeqNo,0);
			        		befoSeqNo=currSeqNo;
			        	}
		        	}
                    break;
                case "btn_t1delete":
                	with(sheetObjT1) {
	                	// checkbox의 bkg의 del_chk를 전부 checking한다.
	                	var sRow = FindCheckedRow(prefixs[0]+"del_chk_t");
	                	if (sRow == "") {
	                		ComShowCodeMessage("COM12189");
	                		return 0;
	                	}
	                	// 가져온 행을 배열로 만들기
	                	var arrRow = sRow.split("|"); // 결과 : "1|3|5|"
	                	for ( var idx = arrRow.length-1; idx >= 0; idx--) {
	            			var row = arrRow[idx];
	            			var key = GetCellValue(row,prefixs[0]+"bkg_ref_no") + ":"
			            			+ GetCellValue(row,prefixs[0]+"cgo_opr_cd") + ":"
			            			+ GetCellValue(row,prefixs[0]+"pol_cd") + ":"
			            			+ GetCellValue(row,prefixs[0]+"pod_cd");
	            			for(var i=HeaderRows(); i<=LastRow(); i++) {
	            				var target = GetCellValue(i,prefixs[0]+"bkg_ref_no") + ":"
					            		   + GetCellValue(i,prefixs[0]+"cgo_opr_cd") + ":"
					            		   + GetCellValue(i,prefixs[0]+"pol_cd") + ":"
					            		   + GetCellValue(i,prefixs[0]+"pod_cd");
	            				if(key == target) {
	            					SetCellValue(i,prefixs[0]+"del_chk",1,false);
	            				}
	            			}
	            		}
                	}
                	// 기존 삭제처리를 수행
                	ComRowHideDelete(sheetObjT1, prefixs[0]+"del_chk");
                	var selRow=sheetObjT1.GetSelectRow();
                	if(selRow != -1) {
                		var rowHidden=sheetObjT1.GetRowHidden(selRow);
                		if(rowHidden) ComBtnDisable("btn_details");
                	} else {
                		ComBtnDisable("btn_details");
                	}
                    break;
                case "btn_t1downExcel":
                    var paramObj=new Object();
                    paramObj.title="SPCL CGO APVL for Partner Lines - DG";
                    paramObj.orientation="Portrait";
//                    paramObj.columnwidth="1:4.0200000000000005|5:13.4|6:5.36|7:5.628|8:2.68|9:9.38|10:5.628|11:2.68|14:5.36|16:5.36|17:4.0200000000000005|18:5.36|19:6.7|20:4.0200000000000005|21:5.36|22:10.05|23:4.0200000000000005|24:4.0200000000000005|25:4.0200000000000005|26:4.0200000000000005|27:6.03|28:9.38|29:9.38|30:4.0200000000000005|31:9.38|32:98.35600000000001";
                    paramObj.columnwidth=ComScgGetExcelDown(sheetObjT1);
                    paramObj.cols=ComScgGetExcelDownCols(sheetObjT1);
                    var url=ComScgGetPgmTitle(sheetObjT1, paramObj);
                    if(sheetObjT1.RowCount() < 1){//no data
                    	ComShowCodeMessage("COM132501");
                	}else{
                		var str = sheetObjT1.GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetObjT1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjT1), SheetDesign:1,Merge:1,ReportXML:str});
                	}

//                	sheetObjT1.SpeedDown2Excel(-1,false,false,"","",false,false,"SPCL CGO APVL for Partner Lines",false,prefixs[0]+"del_chk");
                    break;
                /*** Tab DG (E) **/    
                /*** Tab Awkward (S) **/   
                case "btn_t2retrive":
                    doActionIBSheet(sheetObjT1,formObj,IBSEARCH);
                    break;
                case "btn_t2new":
                	sheetObjT2.RemoveAll();
                    break;
                case "btn_t2add":
                	sheetObjT2.DataInsert(-1,0);							//create at last row[Sheet1]
                	
                	var vslCd    = "";
                	var skdVoyNo = "";
                	var skdDirCd = "";
                	var slanCd   = "";
                	var crrCd    = "";
                	if (ComGetObjValue(formObj.vsl_cd).length > 0) {
                		vslCd    = ComGetObjValue(formObj.vsl_cd);
                		skdVoyNo = ComGetObjValue(formObj.skd_voy_no);
                		skdDirCd = ComGetObjValue(formObj.skd_dir_cd);
                		slanCd   = ComGetObjValue(formObj.slan_cd);
                		crrCd    = ComGetObjValue(formObj.crr_cd);
                	}
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"vsl_cd"    ,vslCd   ,0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"skd_voy_no",skdVoyNo,0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"skd_dir_cd",skdDirCd,0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"slan_cd"   ,slanCd  ,0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"crr_cd"    ,crrCd   ,0);
                	//POL Combo 생성
                	if (vslCd.length > 0 && skdVoyNo.length > 0 && skdDirCd.length > 0) {
                		searchPolCd(sheetObjT2, sheetObjT2.GetSelectRow(), vslCd, skdVoyNo, skdDirCd);
                	}
 	    			
                	sheetObjT2.SelectCell(sheetObjT2.GetSelectRow(), prefixs[1]+"bkg_ref_no");
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"cgo_rqst_dt","",0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"auth_dt","",0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"auth_sts_cd","",0);
                	
                	setAuthStat(sheetObjT2, sheetObjT2.GetSelectRow());
                    break;
                case "btn_t2insert":
                	sheetObjT2.DataInsert();								//create below selected row[Sheet1]
                	
                	var vslCd    = "";
                	var skdVoyNo = "";
                	var skdDirCd = "";
                	var slanCd   = "";
                	var crrCd    = "";
                	if (ComGetObjValue(formObj.vsl_cd).length > 0) {
                		vslCd    = ComGetObjValue(formObj.vsl_cd);
                		skdVoyNo = ComGetObjValue(formObj.skd_voy_no);
                		skdDirCd = ComGetObjValue(formObj.skd_dir_cd);
                		slanCd   = ComGetObjValue(formObj.slan_cd);
                		crrCd    = ComGetObjValue(formObj.crr_cd);
                	}
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"vsl_cd"    ,vslCd   ,0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"skd_voy_no",skdVoyNo,0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"skd_dir_cd",skdDirCd,0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"slan_cd"   ,slanCd  ,0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"crr_cd"    ,crrCd   ,0);
                	//POL Combo 생성
                	if (vslCd.length > 0 && skdVoyNo.length > 0 && skdDirCd.length > 0) {
                		searchPolCd(sheetObjT2, sheetObjT2.GetSelectRow(), vslCd, skdVoyNo, skdDirCd);
                	}
 	    			
                	sheetObjT2.SelectCell(sheetObjT2.GetSelectRow(), prefixs[1]+"bkg_ref_no");
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"cgo_rqst_dt","",0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"auth_dt","",0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"auth_sts_cd","",0);
                	
                	setAuthStat(sheetObjT2, sheetObjT2.GetSelectRow());
               	 	break;
		        case "btn_t2copy":
		        	sheetObjT2.DataCopy();									//copy below selected row[Sheet1]
		        	sheetObjT2.SelectCell(sheetObjT2.GetSelectRow(), prefixs[1]+"vsl_cd");
		        	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"cgo_rqst_dt","",0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"auth_dt","",0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"apro_ref_no","",0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"bkg_ref_no","",0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"spcl_cgo_rqst_seq","",0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"prnr_cgo_rqst_seq","",0);
                	sheetObjT2.SetCellValue(sheetObjT2.GetSelectRow(), prefixs[1]+"auth_sts_cd","",0);
                	//create POL Combo
 	    			searchPolCd(sheetObjT2, sheetObjT2.GetSelectRow(), ComGetObjValue(formObj.vsl_cd), ComGetObjValue(formObj.skd_voy_no), ComGetObjValue(formObj.skd_dir_cd));
 	    			sheetObjT2.SelectCell(sheetObjT2.GetSelectRow(), prefixs[1]+"bkg_ref_no");
                	for ( var checkCell=0; checkCell <= sheetObjT2.LastCol(); checkCell++) {
                		if(sheetObjT2.ColSaveName(checkCell) != prefixs[1]+"apro_ref_no"
                		   && sheetObjT2.ColSaveName(checkCell) != prefixs[1]+"slan_cd"
                		   && sheetObjT2.ColSaveName(checkCell) != prefixs[1]+"eta_dt"
                		   && sheetObjT2.ColSaveName(checkCell) != prefixs[1]+"auth_sts_cd")
                			sheetObjT2.SetCellEditable(sheetObjT2.GetSelectRow(), checkCell,1);
	    			}
                	setAuthStat(sheetObjT2, sheetObjT2.GetSelectRow());
                    break;
                case "btn_t2delete":
                	with(sheetObjT2) {
	                	// checkbox의 bkg의 del_chk를 전부 checking한다.
	                	var sRow = FindCheckedRow(prefixs[1]+"del_chk_t");
	                	if (sRow == "") {
	                		ComShowCodeMessage("COM12189");
	                		return 0;
	                	}
	
	                	// 가져온 행을 배열로 만들기
	                	var arrRow = sRow.split("|"); // 결과 : "1|3|5|"
	                	for ( var idx = arrRow.length-1; idx >= 0; idx--) {
	            			var row = arrRow[idx];
	            			var key = GetCellValue(row,prefixs[1]+"bkg_ref_no") + ":"
			            			+ GetCellValue(row,prefixs[1]+"cgo_opr_cd") + ":"
			            			+ GetCellValue(row,prefixs[1]+"pol_cd") + ":"
			            			+ GetCellValue(row,prefixs[1]+"pod_cd");
	            			for(var i=HeaderRows(); i<=LastRow(); i++) {
	            				var target = GetCellValue(i,prefixs[1]+"bkg_ref_no") + ":"
					            		   + GetCellValue(i,prefixs[1]+"cgo_opr_cd") + ":"
					            		   + GetCellValue(i,prefixs[1]+"pol_cd") + ":"
					            		   + GetCellValue(i,prefixs[1]+"pod_cd");
	            				if(key == target) {
	            					SetCellValue(i,prefixs[1]+"del_chk",1,false);
	            				}
	            			}
	            		}
            		}
                	ComRowHideDelete(sheetObjT2, prefixs[1]+"del_chk");
                    break;
                case "btn_mail":
                	sendReqMail(sheetObjT2, sheetObjT2.GetSelectRow(), formObj);
                    break;
                case "btn_t2downExcel":
                    var paramObj=new Object();
                    paramObj.title="SPCL CGO APVL for Partner Lines - Awkward";
                    paramObj.columnwidth=ComScgGetExcelDown(sheetObjT2);
                    paramObj.cols=ComScgGetExcelDownCols(sheetObjT2);
                    var url=ComScgGetPgmTitle(sheetObjT2, paramObj);  
                    if(sheetObjT2.RowCount() < 1){//no data
                    	ComShowCodeMessage("COM132501");
                    	}else{
//                    		 sheetObjT2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjT2), SheetDesign:1,Merge:1 });
                    		//공통엑셀다운로드 - 상단타이틀적용
                     		var str = sheetObjT2.GetSearchData(url);
                     		str = str.replace(/(^\s*)|(\s*$)/gi, "");
                     		sheetObjT2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjT2), SheetDesign:1,Merge:1,ReportXML:str});                    		
                    	}

                    
                    break;
                /*** Tab Awkward (E) **/  
				case "func_flg":
					changeSearchCondition(false);
					break;
				case "btn_Calendar":
	            	var cal = new ComCalendarFromTo();          	
	            	cal.select(formObj.from_req_dt, formObj.to_req_dt, 'yyyy-MM-dd');
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
    
    // Handling business javascript OnBlur event
    var beforeActiveObj=null;
    function obj_blur() {
		pastEventNum=0;
    	var formObj=document.form;
    	with(ComGetEvent()) {
	    	switch(name){ 
		    	case "skd_dir_cd":	     
		    		if(value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {
		    			searchVVDRelInfo(ComGetObjValue(formObj.vsl_cd), ComGetObjValue(formObj.skd_voy_no), ComGetObjValue(formObj.skd_dir_cd), "form", "");	//Vessell Name retrieve
		    		}
		    		break;
		    	case "cgo_opr_cd":	
		    		if(document.activeElement.id != 'cgo_opr_cd' && beforeActiveObj != document.activeElement.id) {	//When Object Tag's onFocus, to prevent Form Element's onBlur duplication
		        		beforeActiveObj=document.activeElement.id;
		    			searchCarrierCheck(ComGetEvent());	//Carrier Check
		    		}
		        	break;
	    	}
    	}
    	beforeActiveObj=null;
    }
    // Handling business javascript OnKeyUp event
    function obj_keypress() {
    	switch(ComGetEvent().dataformat){
    	    case "engup":
    	    	switch(ComGetEvent().name){
	    	    	case "vsl_cd":	
	    	        	//entering English upper case
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "skd_voy_no":	
	    	        	//entering number
	        	    	ComKeyOnlyNumber(ComGetEvent());
	    	        	break;
	    	        case "skd_dir_cd":	
	    	        	//entering English upper case
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "cgo_opr_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
    	    	}
    	    	break;
    	    default:
    	    	//common:Only English, number
    	    	ComKeyOnlyAlphabet("num");
    	    	break;     
    	}
    }  
    // Handling business javascript OnKeyUp event
    function obj_keyup() {
    	if(event.keyCode != 9) obj_nextfocus(ComGetEvent());
    }  
    // move focus - recieved parameter HTML tag(Object)'s next HTML tag(Object)
    function obj_nextfocus(obj) {
    	var formObj=document.form;
    	var objMaxLength=obj.getAttribute("maxlength");
    	var objValue=obj.getAttribute("value");
    	if (ComChkLen(objValue, objMaxLength) == 2) {
    		ComSetNextFocus(obj);
    		if(obj.name == 'vsl_cd') formObj.skd_voy_no.select();
    		else if(obj.name == 'skd_voy_no') formObj.skd_dir_cd.select();
    	}
    }
    // Handling business javascript OnChange event
    function obj_change() {
    	var formObj=document.form;
    	with(ComGetEvent()) {
	    	switch(name){
		    	case "vsl_cd":		
		    		ComSetObjValue(formObj.skd_voy_no, "");
	    			ComSetObjValue(formObj.skd_dir_cd, "");
	    			ComSetObjValue(formObj.vsl_eng_nm, "");
	    			ComSetObjValue(formObj.crr_cd, "");
	    			ComSetObjValue(formObj.slan_cd, "");
	    			ComSetObjValue(formObj.slan_nm, "");
	    			sheetObjects[0].RemoveAll();
	    			sheetObjects[1].RemoveAll();
	    			resetTab1(sheetObjects[0]);
	    			resetTab2(sheetObjects[1]);
		        	break;
		    	case "skd_voy_no":		
	    			ComSetObjValue(formObj.skd_dir_cd, "");
	    			ComSetObjValue(formObj.vsl_eng_nm, "");
	    			ComSetObjValue(formObj.crr_cd, "");
	    			ComSetObjValue(formObj.slan_cd, "");
	    			ComSetObjValue(formObj.slan_nm, "");
	    			sheetObjects[0].RemoveAll();
	    			sheetObjects[1].RemoveAll();
	    			resetTab1(sheetObjects[0]);
	    			resetTab2(sheetObjects[1]);
		        	break;
		    	case "skd_dir_cd":	    			
	    			ComSetObjValue(formObj.vsl_eng_nm, "");
	    			ComSetObjValue(formObj.crr_cd, "");
	    			ComSetObjValue(formObj.slan_cd, "");
	    			ComSetObjValue(formObj.slan_nm, "");
	    			sheetObjects[0].RemoveAll();
	    			sheetObjects[1].RemoveAll();
	    			resetTab1(sheetObjects[0]);
	    			resetTab2(sheetObjects[1]);
		        	break;
	    	}
    	}
    }       
    function t1sheet1_OnLoadFinish(sheetObj) {	    	
    	resetTab1(sheetObj);
//    	tabObjects[0].SetSelectedIndex(1);
//    	tabObjects[0].SetSelectedIndex(0);
    	doActionIBCombo(comboObjects[0],1);
    }
     function t2sheet1_OnLoadFinish(sheetObj) {
    	searchTPSZ(sheetObj);
    	resetTab2(sheetObj);
    }
    /**
     * When clicking Tab, related event
     * selected tab's elements activate.
     */
    function tab1_OnChange(tabObj , nItem) {
    	var formObj=document.form;
    	var tabSelectedIdx=ComGetObjValue(formObj.tabSelectedIdx);
    	var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- important point --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	resizeSheet();
    	beforetab=nItem;
    	ComSetObjValue(formObj.tabSelectedIdx, nItem);
    	// SRC_TP_CD 체크 비활성화
    	var radio = document.all.item("func_flg");
    	var isDisabled = false;
    	if(tabObjects[0].GetSelectedIndex()==1) { //Awkward
        	if(radio[0].checked) dgChk = 0;
        	if(radio[1].checked) dgChk = 1;
    		isDisabled = true;
    		radio[0].checked=true;
    	} else{
            radio[dgChk].checked=true;
    	}
    	radio[0].disabled=isDisabled;
        radio[1].disabled=isDisabled;
        changeSearchCondition(true);
    }
    /**
     * selecting Combo event
     * move focus
     */
    function rgn_shp_opr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        if(Text != '') ComSetFocus(document.form.vsl_cd);
        sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		resetTab1(sheetObjects[0]);
		resetTab2(sheetObjects[1]);
    }
    /**
     * Handling t2sheet1 Popup Click Event
     * param : sheetObj ==> sheet object, selected Row ==> Row, selected Col ==> Col
     * 
     */
    function t2sheet1_OnPopupClick(sheetObj, Row, Col) {
		with(sheetObj) { 
			switch (sheetObj.ColSaveName(Col)) {
				case prefixs[1]+"skd_dir_cd" :
					//VVD select popup open					
					var vsl_cd=GetCellValue(Row, prefixs[1]+"vsl_cd");
		        	var sUrl="";
		        	if(vsl_cd == ""){
		        		sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
		        		ComOpenPopup(sUrl, 463, 480, "setSheetCallBackVSL", "0,0", true, false, Row, Col, 1);
		        	}else{
		        		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
		        		ComOpenPopup(sUrl, 335, 385, "setSheetCallBackVVD", "0,0", true, false, Row, Col, 1);
		        	}
		        	break;
				case prefixs[1]+"cgo_opr_cd" :
					ComOpenPopup('/opuscntr/COM_ENS_0N1.do?crr_cd='+GetCellValue(Row, prefixs[1]+"cgo_opr_cd"), 600, 470, "setSheetCallBackOPR", '0,0,1,1,1', true, false, Row, Col, 1);
					break;
				case prefixs[1]+"cgo_rqst_dt" : case prefixs[1]+"auth_dt" :
					var cal=new ComCalendarGrid();
				    cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
				    break;			    
			}
 		}
 	}
    /**
     * Handling t2sheet1 OnKeyUp Event
     * param : sheetObj ==> sheet object, selected Row ==> Row, selected Col ==> Col
     * 
     */
    function t2sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
		with(sheetObj) { 
			var len=sheetObj.GetEditText().length;
			if(sheetObj.ColSaveName(Col) == prefixs[1]+"vsl_cd") {
				if(len == 4) sheetObj.SelectCell(Row, prefixs[1]+"skd_voy_no");
			} else if(sheetObj.ColSaveName(Col) == prefixs[1]+"skd_voy_no") {
				if(len == 4) sheetObj.SelectCell(Row, prefixs[1]+"skd_dir_cd");
			} else if(sheetObj.ColSaveName(Col) == prefixs[1]+"skd_dir_cd") {
				if(len == 1) {
					searchVVDRelInfo(sheetObj.GetCellValue(Row, prefixs[1]+"vsl_cd"), sheetObj.GetCellValue(Row, prefixs[1]+"skd_voy_no"), sheetObj.GetEditText().toUpperCase(), "t2Sheet1", Row);
				}
			}
 		}
 	} 
    /**
     * Handling t2sheet1 OnAfterEdit Event
     * param : sheetObj ==> sheet object, edited Row ==> Row, edited Col ==> Col
     * 
     */
    function t2sheet1_OnAfterEdit(sheetObj, Row, Col)  {
    	if(sheetObj.ColSaveName(Col) == prefixs[1]+"cgo_opr_cd") {
    	}
    }
    /**
     * Handling t2sheet1 OnChange Event
     * param : sheetObj ==> sheet object, edited Row ==> Row, edited Col ==> Col
     * 
     */
    function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
    	if(lockKey) {
	    	with(sheetObj) { 
	    		switch (ColSaveName(Col)) {
					case prefixs[1]+"pol_cd" :
						//In case of modify : Merge Cell Sync						
						setSyncValMerge(sheetObj, Row, Col, Value);
					    if(ComTrim(Value) != '') {
					    	searchETADt(sheetObj, Row, GetCellValue(Row, prefixs[1]+"vsl_cd"), GetCellValue(Row, prefixs[1]+"skd_voy_no"), GetCellValue(Row, prefixs[1]+"skd_dir_cd"), Value);
					    	searchPodCd(sheetObj, Row, GetCellValue(Row, prefixs[1]+"vsl_cd"), GetCellValue(Row, prefixs[1]+"skd_voy_no"), GetCellValue(Row, prefixs[1]+"skd_dir_cd"), Value);
							sheetObj.SetCellValue(Row, sheetObj.SaveNameCol(prefixs[1]+"pod_cd"),"",0);
							//In case of modify : Merge Cell Sync
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[1]+"eta_dt"), GetCellValue(Row, prefixs[1]+"eta_dt"));
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[1]+"pod_cd"), "");
						} else {
							SetCellValue(Row, prefixs[1]+"eta_dt","",0);
							sheetObj.CellComboItem(Row,sheetObj.SaveNameCol(prefixs[1]+"pod_cd"), {ComboText:"", ComboCode:""} );
				     		sheetObj.SetCellValue(Row, sheetObj.SaveNameCol(prefixs[1]+"pod_cd"),"",0);
							//In case of modify : Merge Cell Sync 
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[1]+"eta_dt"), "");
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[1]+"pod_cd"), "");
						}
						break;
					case prefixs[1]+"pod_cd" :
						//In case of modify : Merge Cell Sync
						setSyncValMerge(sheetObj, Row, Col, Value);
						break;
					case prefixs[1]+"spcl_cntr_seq" :
						sheetObj.SetCellValue(Row, prefixs[1]+"spcl_cgo_seq",Value,0);
						break;
					case prefixs[1]+"cgo_opr_cd" :
						if(ComTrim(Value) != '') searchCarrierInfo(sheetObj, Row, ComTrim(Value));
						break;
	    		}
	    		setAuthStat(sheetObj, Row);
	    	}
    	}
    }
    /**
     * Dangerous CGO Application Details for Partner Lines screen popup <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 selected Row
     * @param {ibsheet} Col     	sheetObj의 selected Col
     * @param {String} 	Value     	file name
     **/
 	function t1sheet1_OnDblClick(sheetObj,Row,Col,Value){
 		if(sheetObj.ColSaveName(Col) != prefixs[0]+"del_chk") doPopDetails(sheetObj, Row);
 		return;
 	}
 	
 	function t1sheet1_OnChange(sheetObj,Row,Col,Value){
 		
 		//alert(' value ['+Value+'] ');
 		//alert(' auth_sts_cd ['+sheetObj.GetCellValue(Row, prefixs[0]+"auth_sts_cd")+'] ');
 		//alert(' spcl_cgo_rqst_seq ['+sheetObj.GetCellValue(Row, prefixs[0]+"spcl_cgo_rqst_seq")+'] ');
 		
// 		if(sheetObj.ColSaveName(Col) == prefixs[0]+"del_chk_t" && Value == "1"){
// 			if(sheetObj.GetCellValue(Row, prefixs[0]+"auth_sts_cd") != "" || sheetObj.GetCellValue(Row, prefixs[0]+"spcl_cgo_rqst_seq") != "1"){
// 				ComShowCodeMessage("SCG50055");			//[Cannot be deleted because it has been approved or rejected]//
// 				sheetObj.SetCellValue(Row, Col, "0", 0);
// 				return;
// 			}
// 		}
 		
 		//2016-05-31 START 
 		//APVL Stauts 상관 없이 Booking 단위로의 물리적 데이터 삭제 허용
 		//삭제 시, SCG_PRNR_APRO_RQST , SCG_PRNR_APRO_RQST_CGO, SCG_PRNR_APRO_RQST_FILE 에서 모두 물리적으로 Data 삭제.
 		//Soft Warning Message 추가 //&&sheetObj.GetCellValue(Row, prefixs[0]+"bkg_ref_no")!=""
 		if(sheetObj.ColSaveName(Col) == prefixs[0]+"del_chk_t" && Value == "1"){
 			if(sheetObj.GetCellValue(Row, prefixs[0]+"auth_sts_cd") != "" || sheetObj.GetCellValue(Row, prefixs[0]+"spcl_cgo_rqst_seq") != ""){
 				ComShowCodeMessage("SCG50061"); //[This Booking may have been already requested before. Do you still want to delete?]//
 			    sheetObj.SetCellValue(Row, Col, "1", 0);
 			}else{
 				sheetObj.SetCellValue(Row, Col, "1", 0);
 				}
 			}
 		//2016-05-31 END

 		 		
 	} 	
 	
    /**.
     * Handling Sheet1 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	
    	sheetObj.SetEnable(1);
//    	ComBtnsEnable(true);
    	if(ComGetObjValue(document.form.func_flg) == "MNL") {
	     	ComBtnEnable("btn_t1add"		);
	     	ComBtnEnable("btn_t1copy"		);
	     	ComBtnEnable("btn_t1delete"		);
    	}
     	ComBtnEnable	("btn_t1downExcel"	);
     	
     	//perform in case retrieved data exists
     	if(sheetObj.RowCount()!= 0) {
 	    	with (sheetObj) {   
 	    		var seqNo		= 0;
 	    		var rqstSeq1	= "", rqstSeq2	= "";
 	    		var merge = 1;
 	    		for ( var checkRow = HeaderRows(); checkRow <= LastRow(); checkRow++) { 	    
 	    		//for (var checkRow=LastRow(); checkRow >= HeaderRows(); checkRow--) {
 	    			setAuthStat(sheetObj, checkRow);
 	    			rqstSeq1	= GetCellValue(checkRow, prefixs[0]+"crr_cd"	)
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"bkg_ref_no")
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"cgo_opr_cd")
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"vsl_cd"	)
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"skd_voy_no")
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"skd_dir_cd")
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"pol_cd"	)
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"pod_cd"	);
 	    			       
 	    			if(rqstSeq1 	!= rqstSeq2){
 	    				seqNo++;
		  				rqstSeq2=rqstSeq1;
		 				if(merge > 1) {
 	    					SetMergeCell(checkRow-merge, 0, merge, 1); // 같은 no.행머지
 	    					SetMergeCell(checkRow-merge, 1, merge, 1); 
 	    					SetMergeCell(checkRow-merge, 6, merge, 1); 
		 				}
		 				merge = 1;
 	    			}else{
		  				merge++;
		  			}
 	    			
 	    			SetCellValue	(checkRow, prefixs[0]+"seqNo",seqNo,0);
 	    			SetRowStatus(checkRow,"R");
 	    			if (GetCellValue(checkRow,prefixs[0]+"edi_unmap_dtl_cd") != "") {
 	    				SetCellBackColor(checkRow, prefixs[0]+"spcl_cgo_seq", "#FFD8D8");
	 	   			}
 	    		}
 	    		// 마지막 행 처리
 	    		if(merge > 1) {
 	    			SetMergeCell(checkRow-merge, 0, merge, 1); // 같은 no.행머지
 	    			SetMergeCell(checkRow-merge, 1, merge, 1); 
 	    			SetMergeCell(checkRow-merge, 6, merge, 1); 
 	    		}
 	    	}
 	    	
     	} else {
     		ComBtnDisable("btn_details");
     	}
     	//quitWaitImg(1);
     	ComOpenWait(false);
    }

    function t1sheet1_OnSearchEndBak(sheetObj, ErrMsg) {
    	
    	sheetObj.SetEnable(1);
//    	ComBtnsEnable(true);
    	if(ComGetObjValue(document.form.func_flg) == "MNL") {
	     	ComBtnEnable("btn_t1add"		);
	     	ComBtnEnable("btn_t1copy"		);
	     	ComBtnEnable("btn_t1delete"		);
    	}
     	ComBtnEnable	("btn_t1downExcel"	);
     	
     	//perform in case retrieved data exists
     	if(sheetObj.RowCount()!= 0) {
 	    	with (sheetObj) {   
 	    		var seqNo		= 0;
 	    		var rqstSeq1	= "", rqstSeq2	= "";
 	    		//for ( var checkRow = HeaderRows(); checkRow <= LastRow(); checkRow++) { 	    
 	    		for (var checkRow=LastRow(); checkRow >= HeaderRows(); checkRow--) {
 	    			setAuthStat(sheetObj, checkRow);
 	    			rqstSeq1	= GetCellValue(checkRow, prefixs[0]+"crr_cd"	)
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"bkg_ref_no")
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"cgo_opr_cd")
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"vsl_cd"	)
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"skd_voy_no")
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"skd_dir_cd")
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"pol_cd"	)
 	    			       		+ GetCellValue(checkRow, prefixs[0]+"pod_cd"	);
 	    			       
 	    			if(rqstSeq1 	!= rqstSeq2) seqNo++;
 	    			SetCellValue	(checkRow, prefixs[0]+"seqNo",seqNo,0);
 	    			rqstSeq2		= rqstSeq1;
 	    			//var auth_sts_cd=GetCellValue(checkRow, prefixs[0]+"auth_sts_cd");
// 	    			if(auth_sts_cd == 'Y' || auth_sts_cd == 'N') {
// 	    				RowDelete(checkRow, false);
// 	    			} else {
 	    				//SetRowStatus(checkRow,"R");
// 	    			}
 	    		}
 	    		seqNo		= 0;
 	    		rqstSeq1 	= "";
 	    		var merge 	= 1;
 	    		
 	    		for (var checkRow=HeaderRows(); checkRow <= LastRow(); checkRow++) {
 	    			var no = GetCellValue(checkRow, prefixs[0]+"seqNo");
 	    			if(no != rqstSeq1 || merge == 100) {
 	    				if(merge != 100) {
 	    					seqNo++;
 	    				}
 	    				rqstSeq1 = no;
 	    				if(merge > 1) {
 	    					SetMergeCell(checkRow-merge, 0, merge, 1); // 같은 no.행머지
 	    					SetMergeCell(checkRow-merge, 1, merge, 1); 
 	    					SetMergeCell(checkRow-merge, 6, merge, 1); 
 	    				}
 	    				merge = 1;
 	    			} else {
 	    				merge++;
 	    			}
 	    			
// 	    			SetCellValue(checkRow, prefixs[0]+"seqNo",parseInt(seqNo)+1-parseInt(GetCellValue(checkRow, prefixs[0]+"seqNo")));
 	    			SetCellValue(checkRow, prefixs[0]+"seqNo",seqNo,0);
 	    			SetRowStatus(checkRow,"R");
 	    			if (GetCellValue(checkRow,prefixs[0]+"imdg_un_no_seq") == "") {
 	    				SetCellBackColor(checkRow, prefixs[0]+"spcl_cgo_seq", "#FFD8D8");
	 	   			}
 	    		}
 	    		
 	    		// 마지막 행 처리
 	    		if(merge > 1) {
 	    			SetMergeCell(checkRow-merge, 0, merge, 1); // 같은 no.행머지
 	    			SetMergeCell(checkRow-merge, 1, merge, 1); 
 	    			SetMergeCell(checkRow-merge, 6, merge, 1); 
 	    		}
 	    	}
 	    	
     	} else {
     		ComBtnDisable("btn_details");
     	}
     	quitWaitImg(1);
     	ComOpenWait(false);
    }
    /**
     * Handling Sheet2 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    var lockKey=true;
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	sheetObj.SetEnable(1);
//    	ComBtnsEnable(true);
    	if(ComGetObjValue(document.form.func_flg) == "MNL") {
	    	ComBtnEnable("btn_t2add");
	    	ComBtnEnable("btn_t2insert");
	    	ComBtnEnable("btn_t2copy");
	    	ComBtnEnable("btn_t2delete");
    	}
    	ComBtnEnable("btn_mail");
    	ComBtnEnable("btn_t2downExcel");
     	//perform in case retrieved data exists
     	if(sheetObj.RowCount()!= 0) {
     		lockKey=false;
 	    	var pol_cd, pod_cd, vsl_cd, skd_voy_no, skd_dir_cd, sts_cd;
 	    	with (sheetObj) {  
 	    		var seqNo=0;
 	    		var rqstSeq1="", rqstSeq2="";
 	    		dupChkList=new Array();
 	    		var dupCt=0;
 	    		for ( var checkRow = HeaderRows(); checkRow <= LastRow(); checkRow++) {
					vsl_cd=GetCellValue(checkRow, prefixs[1]+"vsl_cd");
					skd_voy_no=GetCellValue(checkRow, prefixs[1]+"skd_voy_no");
					skd_dir_cd=GetCellValue(checkRow, prefixs[1]+"skd_dir_cd");
 	    			//create POL Combo
 	    			searchPolCd(sheetObj, checkRow, vsl_cd, skd_voy_no, skd_dir_cd);
 	    			pol_cd=GetCellText(checkRow, prefixs[1]+"pol_cd");
 	    			SetCellValue(checkRow, prefixs[1]+"pol_cd",pol_cd);
 	    			//create POD Combo
 	    			searchPodCd(sheetObj, checkRow, vsl_cd, skd_voy_no, skd_dir_cd, pol_cd);
 	    			pod_cd=GetCellText(checkRow, prefixs[1]+"pod_cd");
 	    			SetCellValue(checkRow, prefixs[1]+"pod_cd",pod_cd);
 	    			var sts_cd=parseFloat(GetCellValue(checkRow, prefixs[1]+"sts_ct"));
 	    			var auth_sts_cd=GetCellValue(checkRow, prefixs[1]+"auth_sts_cd");
 	    			SetCellValue(checkRow, prefixs[1]+"org_auth_sts_cd",auth_sts_cd);
 	    			SetCellEditable(checkRow, prefixs[1]+"cgo_rqst_dt", 0);
 	    			setAuthStat(sheetObj, checkRow);
// 	    			rqstSeq1=GetCellValue(checkRow, prefixs[1]+"crr_cd")
//		  			       + GetCellValue(checkRow, prefixs[1]+"bkg_ref_no")
//		  			       + GetCellValue(checkRow, prefixs[1]+"spcl_cgo_rqst_seq")
//		  			       + GetCellValue(checkRow, prefixs[1]+"prnr_cgo_rqst_seq");
 	    			rqstSeq1=GetCellValue(checkRow, prefixs[1]+"crr_cd")
		  			       + GetCellValue(checkRow, prefixs[1]+"bkg_ref_no")
		  			       + GetCellValue(checkRow, prefixs[1]+"vsl_cd")
		  			       + GetCellValue(checkRow, prefixs[1]+"skd_voy_no");
		  			       + GetCellValue(checkRow, prefixs[1]+"skd_dir_cd");
		  			       + GetCellValue(checkRow, prefixs[1]+"pol_cd");
		  			       + GetCellValue(checkRow, prefixs[1]+"pod_cd");
 	    			if(rqstSeq1 != rqstSeq2) seqNo++;
 	    			SetCellValue(checkRow, prefixs[1]+"seqNo", seqNo);
 	    			rqstSeq2=rqstSeq1;
 	    			SetRowStatus(checkRow,"R");
 	    			if(GetRowHidden(checkRow)) {
 	    				var dupChkItems=new Array();
 	    				dupChkItems[0]=GetCellValue(checkRow, prefixs[1]+"cgo_opr_cd");
 	    				dupChkItems[0]=dupChkItems[0]+GetCellValue(checkRow, prefixs[1]+"bkg_ref_no");
 	    				dupChkItems[0]=dupChkItems[0]+GetCellValue(checkRow, prefixs[1]+"vsl_cd");
 	    				dupChkItems[0]=dupChkItems[0]+GetCellValue(checkRow, prefixs[1]+"skd_voy_no");
 	    				dupChkItems[0]=dupChkItems[0]+GetCellValue(checkRow, prefixs[1]+"skd_dir_cd");
 	    				dupChkItems[0]=dupChkItems[0]+GetCellValue(checkRow, prefixs[1]+"pol_cd");
 	    				dupChkItems[0]=dupChkItems[0]+GetCellValue(checkRow, prefixs[1]+"pod_cd");
 	    				dupChkItems[1]=GetCellText(checkRow, prefixs[1]+"spcl_cntr_seq");
 	    				dupChkList[dupCt++]=dupChkItems;
 	    				RowDelete(checkRow, false);
 	    			}
 	    			if(GetCellValue(checkRow, prefixs[1]+"auth_sts_cd") != "R" 
 	    				&& GetCellValue(checkRow, prefixs[1]+"auth_sts_cd") != "" ) {
 	    				SetRowEditable(checkRow, false);
 	    				SetCellEditable(checkRow, prefixs[1]+"del_chk", true); // delete button
 	    			}
 	    		}
 	    		seqNo=0;
 	    		rqstSeq1 = "";
 	    		var merge = 1;
 	    		for (var checkRow=HeaderRows(); checkRow <= LastRow(); checkRow++) {
 	    			var no = GetCellValue(checkRow, prefixs[1]+"seqNo");
 	    			if(no != rqstSeq1) {
 	    				seqNo++;
 	    				rqstSeq1 = no;
 	    				if(merge > 1) {
 	    					SetMergeCell(checkRow-merge, 0, merge, 1); // 같은 no.행머지
 	    					SetMergeCell(checkRow-merge, 1, merge, 1); 
 	    					SetMergeCell(checkRow-merge, 8, merge, 1); 
 	    				}
 	    				merge = 1;
 	    			} else {
 	    				merge++;
 	    			}
 	    			SetCellValue(checkRow, prefixs[1]+"seqNo",seqNo,0);
 	    			SetRowStatus(checkRow,"R");
 	    		}
 	    		// 마지막 행 처리
 	    		if(merge > 1) {
 	    			SetMergeCell(checkRow-merge, 0, merge, 1); // 같은 no.행머지
 	    			SetMergeCell(checkRow-merge, 1, merge, 1); 
 	    			SetMergeCell(checkRow-merge, 8, merge, 1); 
 	    		}
 	    	}
 	    	lockKey=true;
 	    	ComBtnEnable("btn_mail");
     	} else {
     		dupChkList=null;
     		ComBtnDisable("btn_mail");
     	}
     	//quitWaitImg(1);
     	ComOpenWait(false);
    }
    /**
     * Handling t1sheet1 OnSelectMenu Event
     * param : sheetObj ==> sheet object, sAction
     * 
     */
    function t1sheet1_OnSelectMenu(sheetObj, sAction){
   	 	var sColStr=sheetObj.GetSelectionCols("|");
   	 	//create javascript list
   	 	var arr=sColStr.split("|");
   	 	with(sheetObj) {
	    	switch(sAction) {
	    		case "컬럼 삭제" :
	    			for (i=0; i<arr.length; i++) {
	    				SetColHidden(arr[i],1);
	    			}
	        		break;
	    		case "컬럼 삭제 취소" :
	    			for (i=0; i<arr.length; i++) {
	    				if (arr[i] != SaveNameCol(prefixs[0]+"seq")
    						&& arr[i] != SaveNameCol(prefixs[0]+"vsl_cd")
	        				&& arr[i] != SaveNameCol(prefixs[0]+"skd_voy_no")
	        				&& arr[i] != SaveNameCol(prefixs[0]+"skd_dir_cd")
	        				&& arr[i] != SaveNameCol(prefixs[0]+"slan_cd")
	        				&& arr[i] != SaveNameCol(prefixs[0]+"apro_ref_no"))
	    					SetColHidden(arr[i],0);
	    			}
	        		break;
	        	case "전체 삭제 취소" :
	        		for(var idx=0; idx<=LastCol(); idx++) {
	        			if (idx != SaveNameCol(prefixs[0]+"seq")
	        				&& idx != SaveNameCol(prefixs[0]+"vsl_cd")
	        				&& idx != SaveNameCol(prefixs[0]+"skd_voy_no")
	        				&& idx != SaveNameCol(prefixs[0]+"skd_dir_cd")
	        				&& idx != SaveNameCol(prefixs[0]+"slan_cd")
	        				&& idx != SaveNameCol(prefixs[0]+"apro_ref_no")
	        				&& idx <= SaveNameCol(prefixs[0]+"auth_dt")) {
	        				SetColHidden(idx,0);
	        			}
	        		}
	        		break;
	    	}
   	 	}    	 
    }
    /**
     * Handling t2sheet1 OnSelectMenu Event
     * param : sheetObj ==> sheet object, sAction
     * 
     */
    function t2sheet1_OnSelectMenu(sheetObj, sAction){
   	 	var sColStr=sheetObj.GetSelectionCols("|");
   	 	//create javascript list
   	 	var arr=sColStr.split("|");
   	 	with(sheetObj) {
	    	switch(sAction) {
	    		case "컬럼 삭제" :
	    			for (i=0; i<arr.length; i++) {
	    				SetColHidden(arr[i],1);
	    			}
	        		break;
	    		case "컬럼 삭제 취소" :
	    			for (i=0; i<arr.length; i++) {
	    				if (arr[i] != SaveNameCol(prefixs[1]+"spcl_cgo_rqst_seq")
	    					&& arr[i] != SaveNameCol(prefixs[1]+"vsl_cd")
	    					&& arr[i] != SaveNameCol(prefixs[1]+"skd_voy_no")
	    					&& arr[i] != SaveNameCol(prefixs[1]+"skd_dir_cd")
	    					&& arr[i] != SaveNameCol(prefixs[1]+"slan_cd")
	    					&& arr[i] != SaveNameCol(prefixs[1]+"crr_cd")
	    					&& arr[i] != SaveNameCol(prefixs[1]+"seq")
	    					&& arr[i] != SaveNameCol(prefixs[1]+"apro_ref_no"))
	    					SetColHidden(arr[i],0);
	    			}
	        		break;
	        	case "전체 삭제 취소" :
	        		for(var idx=0; idx<=LastCol(); idx++) {
	        			if (idx != SaveNameCol(prefixs[1]+"spcl_cgo_rqst_seq")
        					&& idx != SaveNameCol(prefixs[1]+"vsl_cd")
	    					&& idx != SaveNameCol(prefixs[1]+"skd_voy_no")
	    					&& idx != SaveNameCol(prefixs[1]+"skd_dir_cd")
	    					&& idx != SaveNameCol(prefixs[1]+"slan_cd")
	        				&& idx != SaveNameCol(prefixs[1]+"crr_cd")
	        				&& idx != SaveNameCol(prefixs[1]+"seq")
	        				&& idx != SaveNameCol(prefixs[1]+"apro_ref_no")
	        				&& idx <= SaveNameCol(prefixs[1]+"auth_dt")) {
	        				SetColHidden(idx,0);
	        			}
	        		}
	        		break;
	    	}
   	 	}    	 
    }
    /**
     * Handling t1sheet1 OnSelectCell Event
     * param : sheetObj ==> sheet object, OldRow ==> before selecting Row, OldCol ==> before selecting Col, selected NewRow ==> NewRow, selected NewCol ==> NewCol
     * 
     */
    function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	with(sheetObj) {
	    	for(var i=HeaderRows(); i<=LastRow(); i++) {
	    		if(SetRowStatus(i) != 'I') GetRowBackColor(i,"#FFFFFF");
//	    		else SetRowBackColor(i,"#C0C0C0");
	    	}
//	     	if(NewRow > 1) SetRowBackColor(NewRow,"#E7FAF6");
	     	if(RowCount()!= 0) ComBtnEnable("btn_details");
    	}
    }
    /**
     * Handling t2sheet1 OnSelectCell Event
     * param : sheetObj ==> sheet object, OldRow ==> before selecting Row, OldCol ==> before selecting Col, selected NewRow ==> NewRow, selected NewCol ==> NewCol
     * 
     */
    function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	 with(sheetObj) {    		
 	    	for(var i=HeaderRows(); i<=LastRow(); i++) {
 	    		SetRowBackColor(i,"#FFFFFF");
 	    	}
// 	     	if(NewRow > 1) SetRowBackColor(NewRow,"#E7FAF6");
 	     	if(GetRowStatus(NewRow) == 'I') {
 	     		ComBtnDisable("btn_mail");
 	     	} else {
 	     		ComBtnEnable("btn_mail");
 	     	}
     	}
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Received event from sheet of UI
    //////////////////////////////////////////////////////////////////////////////////////////         
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Initialize 
    //////////////////////////////////////////////////////////////////////////////////////////  
    // business javascript OnKeyPress event Catch
    function initControl() {
        // Axon event handling 1. event
        //axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
        axon_event.addListenerForm 	 ('blur',     'obj_blur',       form);
        //axon_event.addListenerForm   ('keyup',    'obj_keyup',      form);
        //axon_event.addListener       ('keydown',  'ComKeyEnter',   'form');
        axon_event.addListenerForm   ('change',   'obj_change', 	form);
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
        
        resizeSheet();
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
//            tabObjects[k].SetSelectedIndex(0);
        }
        ComSetObjValue(document.form.tabSelectedIdx, "0");
        //initalizing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
       	 	initCombo(comboObjects[k], k + 1);
        }
        initControl();
       t1sheet1_OnLoadFinish(sheetObjects[0]) ;
       t2sheet1_OnLoadFinish(sheetObjects[1]);
       
       $("#from_req_dt").attr("value", ComGetDateAdd(null, "d", -30));
       $("#to_req_dt").attr("value"  , ComGetDateAdd(null, "d", 0));
       
       tabObjects[0].SetSelectedIndex(0);
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
                with(sheetObj){
               
	              var HeadTitle1	= "No.|Del|Lane|VVD CD|VVD CD|VVD CD|BKG Ref No|DG Ref No|BKG\nCOMP|POL|POL";
	              HeadTitle1      	+= "|ETA|POD|POD||APVL|APVL\nRef. No.|Sequence|Sequence|TPSZ";
	              HeadTitle1      	+= "|UN No.\n/Seq.|UN No.\n/Seq.|Class|Sub\nrisks|MP|PG|LQ|EQ|R|FP(℃)|Weight (kg)|Weight (kg)|PSA|RQST Date(GMT)|APVL\nDT||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
	              var HeadTitle2	= "No.|Del|Lane|VVD CD|VVD CD|VVD CD|BKG Ref No|DG Ref No|BKG\nCOMP|POL|POL";
	              HeadTitle2      	+= "|ETA|POD|POD||APVL|APVL\nRef. No.|CNTR|CGO|TPSZ";
	              HeadTitle2      	+= "|UN No.\n/Seq.|UN No.\n/Seq.|Class|Sub\nrisks|MP|PG|LQ|EQ|R|FP(℃)|Gross|Net|PSA|RQST Date(GMT)|APVL\nDT||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	             // (headCount, 19, 0, true);
	
	              ////SetConfig( { SearchMode:2, MergeSheet:9, Page:20, DataRowMerge:1, PrevColumnMergeMode:0 } );
	              SetConfig( { SearchMode:2, MergeSheet:9, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	              
	
	              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                          { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	 
	              var cols = [ {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"seqNo", UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"del_chk_t" },
	                     {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"slan_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"vsl_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"skd_voy_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:17,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"skd_dir_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"bkg_ref_no",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"dcgo_ref_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"cgo_opr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"pol_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"pol_clpt_ind_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Date",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"eta_dt",                    KeyField:0,   CalcLogic:"",   Format:"YmdHm",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"pod_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"pod_clpt_ind_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"seq",                       KeyField:0,   CalcLogic:prefixs[0]+"spcl_cgo_seq" },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"auth_sts_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"apro_ref_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"spcl_cntr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"spcl_cgo_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"cntr_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_un_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_un_no_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_clss_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_subs_rsk_lbl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"mrn_polut_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_pck_grp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_lmt_qty_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_expt_qty_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"rsd_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefixs[0]+"flsh_pnt_cdo_temp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefixs[0]+"grs_wgt",                   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefixs[0]+"net_wgt",                   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"psa_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"cgo_rqst_dt",               KeyField:0,   CalcLogic:"",   Format:"YmdHm",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Date",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"auth_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"ibflag" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"spcl_cgo_rqst_seq" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"crr_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"cntr_ref_no" },
	//                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"slan_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"wgt_ut_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"wgt_ut_cd2" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"prp_shp_nm" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"hzd_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"n1st_imdg_subs_rsk_lbl_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"n2nd_imdg_subs_rsk_lbl_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"n3rd_imdg_subs_rsk_lbl_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"dcgo_sts_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"emer_cntc_phn_no" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"emer_cntc_pson_nm" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"certi_no" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"diff_rmk" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"out_n1st_imdg_pck_qty" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"out_n1st_imdg_pck_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"out_n1st_imdg_pck_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"out_n2nd_imdg_pck_qty" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"out_n2nd_imdg_pck_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"out_n2nd_imdg_pck_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"in_n1st_imdg_pck_qty" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"in_n1st_imdg_pck_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"in_n1st_imdg_pck_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"in_n2nd_imdg_pck_qty" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"in_n2nd_imdg_pck_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"in_n2nd_imdg_pck_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"intmd_n1st_imdg_pck_qty" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"intmd_n1st_imdg_pck_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"intmd_n1st_imdg_pck_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"intmd_n2nd_imdg_pck_qty" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"intmd_n2nd_imdg_pck_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"intmd_n2nd_imdg_pck_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"max_in_pck_qty" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"max_in_pck_tp_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"hcdg_pck_rstr_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"hcdg_intmd_bc_rstr_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"hcdg_tnk_rstr_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_lmt_qty" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_expt_qty_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"ems_no" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"ctrl_temp_ctnt" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"emer_rspn_gid_no" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"emer_rspn_gid_chr_no" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"emer_temp_ctnt" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"cnee_dtl_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"net_explo_wgt" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"rada_skd_no" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"rada_amt" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"rada_ut_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"rada_trsp_no" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"spcl_cgo_cate_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"auth_ofc_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"auth_usr_id" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_co_grp_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_segr_grp_no" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"meas_qty" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"meas_tp_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"pck_qty" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"pck_tp_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"clod_flg" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"spcl_stwg_rqst_desc" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"cgo_lcl_flg" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_lmt_qty_meas_ut_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_comp_grp_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"hcdg_flg" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_subs_rsk_lbl_rmk" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_spcl_provi_no" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"rgn_shp_opr_cd" },
	                     {Type:"CheckBox",  Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"del_chk" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"prnr_cgo_rqst_seq" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"src_tp_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"edi_unmap_dtl_cd" }
	                     ];
	              
	              InitColumns(cols);
	
	              SetEditable			(1);
	              SetEditableColorDiff	(0);
	              SetHeaderRowHeight	(20);

              //SetMergeCell(0, 1, 2, 3);
//              SetMergeCell(0, 7, 2, 2);		//POL
//              SetMergeCell(0, 10, 2, 2);	//POD
//              SetMergeCell(0, 20, 2, 2);
              //SetActionMenu("컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소");
              
              }

                  break;

            case 2:      //t2sheet1 init
                with(sheetObj){
               
              var HeadTitle1="No.|Del||Lane|VVD CD|VVD CD|VVD CD||BKG Ref No|BKG\nCOMP|POL";
              HeadTitle1      += "|ETA|POD||APVL|APVL\nRef. No.|Seq.|TPSZ|Commodity";
              HeadTitle1      += "|Over All(cm)|Over All(cm)|Over All(cm)|Over Dimension(cm)|Over Dimension(cm)|Over Dimension(cm)|Over Dimension(cm)|Over Dimension(cm)|Gross\nWeight(kg)|Void\n(FEU)|RQST Date(GMT)|APVL\nDT||||";
              var HeadTitle2="No.|Del||Lane|VVD CD|VVD CD|VVD CD||BKG Ref No|BKG\nCOMP|POL";
              HeadTitle2      += "|ETA|POD||APVL|APVL\nRef. No.|Seq.|TPSZ|Commodity";
              HeadTitle2     += "|L|W|H|FWD|AFT|Left|Right|Height|Gross\nWeight(kg)|Void\n(FEU)|RQST Date(GMT)|APVL\nDT||||";
              var headCount=ComCountHeadTitle(HeadTitle1);
            //  (headCount, 17, 0, true);
              cnt=0;

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, PrevColumnMergeMode:0 } );

              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"seqNo" ,UpdateEdit:0,   InsertEdit:0 },
                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"del_chk_t" },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"spcl_cgo_rqst_seq" },
                     {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"slan_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"vsl_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 , InputCaseSensitive:1 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"skd_voy_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
                     {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"skd_dir_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 , InputCaseSensitive:1 },
                     
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"crr_cd" },
                     {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"bkg_ref_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:12, InputCaseSensitive:1 },
                     {Type:"PopupEdit", Hidden:0, Width:55,   Align:"Center",    ColMerge:1,   SaveName:prefixs[1]+"cgo_opr_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, InputCaseSensitive:1 },
//                   {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Combo", 	Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"pol_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                     {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"eta_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo", 	Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"pod_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"seq",               KeyField:0,   CalcLogic:prefixs[1]+"spcl_cntr_seq" },
                     {Type:"Text",    	Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"auth_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:102,  Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"apro_ref_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"spcl_cntr_seq",     KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
                     {Type:"Combo", 	Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"cntr_tpsz_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefixs[1]+"cmdt_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefixs[1]+"ttl_dim_len",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefixs[1]+"ttl_dim_wdt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefixs[1]+"ttl_dim_hgt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefixs[1]+"fwrd_ovr_dim_len",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefixs[1]+"bkwd_ovr_dim_len",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefixs[1]+"lf_sd_ovr_dim_len", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefixs[1]+"rt_sd_ovr_dim_len", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefixs[1]+"hgt_ovr_dim_len",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Float",     Hidden:0,  Width:84,   Align:"Right",   ColMerge:1,   SaveName:prefixs[1]+"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
                     {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefixs[1]+"void_slt_qty",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                     {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"cgo_rqst_dt",       KeyField:0,   CalcLogic:"",   Format:"YmdHm", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"PopupEdit", Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"auth_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                     {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"ibflag" },
                     {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"spcl_cgo_seq" },
                     {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"sts_ct" },
                     {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"org_auth_sts_cd" },
                     {Type:"CheckBox",  Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"del_chk" },
                     {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"prnr_cgo_rqst_seq" }];
               
              InitColumns(cols);

              SetEditable(1);
              SetImageList(0,"img/btns_calendar.gif");
              SetEditableColorDiff(0);
              SetHeaderRowHeight(20);
              //SetMergeCell(0, 2, 2, 3);
              //SetColProperty(prefixs[1]+"auth_sts_cd", {ComboText:"R|Y|N", ComboCode:"R|Y|N"} );
//              SetColProperty("pol_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
              SetShowButtonImage(1);
              //SetActionMenu("컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소");
              
              }


                break;
            case 3:      // t0sheet1 init
                with(sheetObj){
              var HeadTitle="flg|vsl_opr_tp|bkg_ref_no|spcl_cgo_rqst_seq|vsl_cd|skd_voy_no|skd_dir_cd|slan_cd|rgn_shp_opr_cd|pol_cd|pod_cd|eta_dt|dg_flg|awk_flg";
              var headCount=ComCountHeadTitle(HeadTitle);

              SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:1, ColResize:1, HeaderCheck:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"ibflag" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"vsl_opr_tp" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"bkg_ref_no" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"spcl_cgo_rqst_seq" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"vsl_cd" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"skd_voy_no" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"skd_dir_cd" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"slan_cd" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"rgn_shp_opr_cd" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"pol_cd" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"pod_cd" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"eta_dt" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"dg_flg" },
                     {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[2]+"awk_flg" } ];
               
              InitColumns(cols);
              SetVisible(false);

                    }


			   break;
        }
    }
    /**
     * Initialzing Tab
     * Setting tab items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "DG" , "");
					InsertItem( "Awkward" , "");
                }
             break;
         }
    }
    /**
     * Initialzing Combo
     * param : sheetObj, sheetNo
     * adding case as numbers of counting combo
     */ 
    function initCombo(comboObj, comboNo) {
    	 switch(comboObj.id) {
   	  		case "rgn_shp_opr_cd":  
   	  			with(comboObj) {
					SetColAlign(0, "center");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "150");
   	  				SetTitle("Code|Description");
   	  				SetDropHeight(200);
  	         	}
   	  			break;  
   	  	}
    }
    /**
     * Initialzing Tab1
     */
    function resetTab1(sheetObj) {
    	//sheetObj.SetEnable(0);
     	ComBtnDisable("btn_details");
     	ComBtnDisable("btn_t1add");
     	ComBtnDisable("btn_t1copy");
     	ComBtnDisable("btn_t1delete");
     	ComBtnDisable("btn_t1downExcel");
    }
    /**
     * Initialzing Tab2
     */
    function resetTab2(sheetObj) {
    	//sheetObj.SetEnable(0);
    	ComBtnDisable("btn_t2add");
    	ComBtnDisable("btn_t2insert");
    	ComBtnDisable("btn_t2copy");
    	ComBtnDisable("btn_t2delete");
    	ComBtnDisable("btn_mail");
    	ComBtnDisable("btn_t2downExcel");
    } 
    /**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
     * register IBCombo Object created in page as comboObjects list
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * Setting Vessel Name
     */
    function setVslEngNm(formObj, sXml) {
    	var vsl_eng_nm=ComScgXml2Array(sXml, "vsl_eng_nm");
    	var vsl_slan_cd=ComScgXml2Array(sXml, "vsl_slan_cd");
    	var vsl_slan_nm=ComScgXml2Array(sXml, "vsl_slan_nm");
    	var crr_cd=ComScgXml2Array(sXml, "vsl_opr_tp_cd");
 	   	if(vsl_eng_nm == null) {
 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 		    ComSetObjValue(formObj.vsl_eng_nm, "");
 		    ComSetObjValue(formObj.skd_dir_cd, "");
 		    ComSetObjValue(formObj.skd_voy_no, "");
 		    ComSetObjValue(formObj.vsl_cd, "");
 		    ComSetObjValue(formObj.crr_cd, "");
 		    ComSetObjValue(formObj.slan_cd, "");
 		    ComSetObjValue(formObj.slan_nm, "");
 		    ComSetFocus(formObj.vsl_cd);
 	   	} else {
 	   		ComSetObjValue(formObj.vsl_eng_nm, vsl_eng_nm.toString());
 	   		ComSetObjValue(formObj.crr_cd, crr_cd.toString());
 	   		ComSetObjValue(formObj.slan_cd, vsl_slan_cd.toString());
 	   		ComSetObjValue(formObj.slan_nm, vsl_slan_nm.toString());
 	   		ComSetFocus(formObj.btn_retrive);
 	   	}
    }
    /**
     * Setting Vessel Lane
     */
    function setVslLane(sheetObj, sXml, Row) {
 	   	if(ComScgXml2Array(sXml, "vsl_slan_cd") == undefined) {
 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	   		sheetObj.SetCellValue(Row, prefixs[1]+"skd_dir_cd","",0);
 	   		sheetObj.SetCellValue(Row, prefixs[1]+"skd_voy_no","",0);
 	   		sheetObj.SetCellValue(Row, prefixs[1]+"vsl_cd","",0);
 	   		sheetObj.SetCellValue(Row, prefixs[1]+"slan_cd","",0);
 	   		sheetObj.SetCellValue(Row, prefixs[1]+"crr_cd","",0);
 	   		sheetObj.SelectCell(Row, prefixs[1]+"vsl_cd");
 	   	} else {
 	   		var vsl_slan_cd = ComScgXml2Array(sXml, "vsl_slan_cd").toString();
 	   		var crr_cd      = ComScgXml2Array(sXml, "vsl_opr_tp_cd").toString();
 	   		sheetObj.SetCellValue(Row, prefixs[1]+"slan_cd",vsl_slan_cd,0);
 	   		sheetObj.SetCellValue(Row, prefixs[1]+"crr_cd",crr_cd,0);
 	   	}
    }
    /**
  	 * Data setting from VSL Code Help (Pop-Up)<br>
  	 * @param {arry} rtnObjs
  	 */
  	function setCallBackVSL(rtnObjs) {
  		var formObj=document.form;
  		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					ComSetObjValue(formObj.vsl_cd, rtnDatas[1]);
					ComSetObjValue(formObj.vsl_eng_nm, rtnDatas[2]);
					ComSetFocus(formObj.skd_voy_no);
				}
			}
    	}
  	} 
    /**
  	 * Data setting from VVD Code Help (Pop-Up)<br>
  	 * @param {arry} obj
  	 */
  	function setCallBackVVD(obj) {
  		var formObj=document.form;
  		if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					ComSetObjValue(formObj.skd_voy_no, rtnDatas[2]);
					ComSetObjValue(formObj.skd_dir_cd, rtnDatas[3]);
					searchVVDRelInfo(ComGetObjValue(formObj.vsl_cd), ComGetObjValue(formObj.skd_voy_no), ComGetObjValue(formObj.skd_dir_cd), "form", "");	//Vessell Name retrieve
				}
			}
    	}
  	}
  	/**
  	 * Data setting from (Sheet)VSL Code Help (Pop-Up)<br>
  	 * @param {arry} rtnObjs
  	 */
  	function setSheetCallBackVSL(rtnObjs, Row, Col, sheetNo) {
  		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					sheetObjects[sheetNo].SetCellValue(Row, prefixs[1]+"vsl_cd",rtnDatas[1],0);
				}
			}
    	}
  	} 
    /**
  	 * Data setting from (Sheet)VVD Code Help (Pop-Up)<br>
  	 * @param {arry} obj
  	 */
  	function setSheetCallBackVVD(obj, Row, Col, sheetNo) {
  		if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					sheetObjects[sheetNo].SetCellValue(Row, prefixs[1]+"skd_voy_no",rtnDatas[2],0);
					sheetObjects[sheetNo].SetCellValue(Row, prefixs[1]+"skd_dir_cd",rtnDatas[3],0);
					searchVVDRelInfo(rtnDatas[1], rtnDatas[2], rtnDatas[3], "t2Sheet1", Row);	//Vessell Lane 조회
				}
			}
    	}
  	}
  	/**
  	 * Data setting from (Sheet)Carrier Code Help (Pop-Up)<br>
  	 * @param {arry} obj
  	 */
    function setSheetCallBackOPR(obj, Row, Col, sheetNo) {
 	   if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					sheetObjects[sheetNo].SetCellValue(Row, prefixs[1]+"cgo_opr_cd",rtnDatas[3],0);
					//In case of modify : Merge Cell Sync
					setSyncValMerge(sheetObjects[sheetNo], Row, Col, rtnDatas[3]);
				}
			}
 	   }
    }
    /**
  	 * (Sheet)POL Combo composition<br>
  	 * @param sXml
  	 */
    function setPolCombo(sheetObj, Row, sXml) {
    	var arrCombo=ComXml2ComboString(sXml, "loc_cd", "loc_nm");
    	if(arrCombo != null && arrCombo.length > 0) {
    		var loc_cds=ComScgXml2Array(sXml, "loc_cd");
    		var clptIndSeqs=ComScgXml2Array(sXml, "clpt_ind_seq");
    		var turnPortIndCds=ComScgXml2Array(sXml, "turn_port_ind_cd");
    		var skdCngStsCd=ComScgXml2Array(sXml, "skd_cng_sts_cd");
    		var vtAddCallFlg=ComScgXml2Array(sXml, "vt_add_call_flg"); 
    		var polCdCombo=new Array();
    		var polTxCombo=new Array();
    		var newPolIdx=0;
    		var newPodIdx=0;
    		for(var arrIdx=0; arrIdx<loc_cds.length; arrIdx++) {
    			if(loc_cds[arrIdx] != null && loc_cds[arrIdx] != '' && vtAddCallFlg[arrIdx] != 'Y') {
	    			if(turnPortIndCds[arrIdx] != 'D' && turnPortIndCds[arrIdx] != 'V' && turnPortIndCds[arrIdx] != 'F') {
	    				if(skdCngStsCd[arrIdx] != 'S') {
	    					polCdCombo[newPolIdx]=loc_cds[arrIdx]+""+clptIndSeqs[arrIdx];
	    					polTxCombo[newPolIdx++]=loc_cds[arrIdx];
	    				} else {
//	    					polCdCombo[newPolIdx]=" ";
//	    					polTxCombo[newPolIdx++]=" ";
	    				}
	    			}
    			}
    		}
    		sheetObj.CellComboItem(Row, sheetObj.SaveNameCol(prefixs[1]+"pol_cd"), {ComboText:polTxCombo.join("|"), ComboCode:polCdCombo.join("|")});
    	}
    	else {
    		sheetObj.CellComboItem(Row,sheetObj.SaveNameCol(prefixs[1]+"pol_cd"), {ComboText:"", ComboCode:""} );
    		sheetObj.CellComboItem(Row,sheetObj.SaveNameCol(prefixs[1]+"pod_cd"), {ComboText:"", ComboCode:""} );
    		sheetObj.SetCellValue(Row, sheetObj.SaveNameCol(prefixs[1]+"pol_cd"),"",0);
    		sheetObj.SetCellValue(Row, sheetObj.SaveNameCol(prefixs[1]+"pod_cd"),"",0);
    		sheetObj.SetCellValue(Row, sheetObj.SaveNameCol(prefixs[1]+"eta_dt"),"",0);
    	}
    	return true;
    }
  	/**
   	 * (Sheet)POD Combo composition<br>
   	 * @param sXml
   	 */
    function setPodCombo(sheetObj, Row, sXml, polCd) {
     	var arrCombo=ComXml2ComboString(sXml, "loc_cd", "loc_nm");
     	if(arrCombo != null && arrCombo.length > 0 && polCd != "") {
     		var loc_cds=ComScgXml2Array(sXml, "loc_cd");
     		var clptIndSeqs=ComScgXml2Array(sXml, "clpt_ind_seq");
     		var clptSeqs=ComScgXml2Array(sXml, "clpt_seq");
     		var skdCngStsCd=ComScgXml2Array(sXml, "skd_cng_sts_cd");
     		var podCdCombo=new Array();
     		var podTxCombo=new Array();
     		var polClptSeq="0";
     		var newPodIdx=0;
     		for(var arrIdx1=0; arrIdx1<loc_cds.length; arrIdx1++) {
     			if(loc_cds[arrIdx1]+""+clptIndSeqs[arrIdx1] == polCd) polClptSeq=clptSeqs[arrIdx1];
     		}
     		for(var arrIdx2=0; arrIdx2<loc_cds.length; arrIdx2++) {
     			if(loc_cds[arrIdx2] != null && loc_cds[arrIdx2] != '') {
     				if(parseInt(clptSeqs[arrIdx2]) > parseInt(polClptSeq)) {
     					if(skdCngStsCd[arrIdx2] != 'S') {
     						podCdCombo[newPodIdx]=loc_cds[arrIdx2]+""+clptIndSeqs[arrIdx2];
     						podTxCombo[newPodIdx++]=loc_cds[arrIdx2];
     					} else {
//     						podCdCombo[newPodIdx]=" ";
//     						podTxCombo[newPodIdx++]=" ";
	    				}
 	    			}
     			}
     		}
     		sheetObj.CellComboItem(Row, sheetObj.SaveNameCol(prefixs[1]+"pod_cd"),{ComboText:podTxCombo.join("|"), ComboCode:podCdCombo.join("|")});
     	} else {
     		sheetObj.CellComboItem(Row,sheetObj.SaveNameCol(prefixs[1]+"pod_cd"), {ComboText:"", ComboCode:""} );
     		sheetObj.SetCellValue(Row, sheetObj.SaveNameCol(prefixs[1]+"pod_cd"),"",0);
     	}
    }
    /**
  	 * (Sheet)ETA setting<br>
  	 * @param sXml
  	 */
    function setETADt(sheetObj, Row, sXml) {
    	
    	var etaDt  = ComScgXml2Array(sXml, "vps_eta_dt");
    	var etaVal = "";
    	var bFlag  = false;
    	for (var etaRow = 0; etaRow < etaDt.length; etaRow++) {
    		etaVal = etaDt[etaRow];
    		if (etaVal == undefined) continue;
    		
    		for (var valRow = 0; valRow < etaVal.length; valRow++) {
	    		if (ComIsDateTime(etaVal[valRow], "", "hm")) {
	    			etaVal = etaDt[etaRow][0];
	    			bFlag  = true;
	    			break;
	    		}
    		}
    		if (bFlag) break;
    	}
    	sheetObj.SetCellValue(Row, sheetObj.SaveNameCol(prefixs[1]+"eta_dt"),etaVal,0);
    	//In case of modify : Merge Cell Sync
		setSyncValMerge(sheetObj, Row, sheetObj.SaveNameCol(prefixs[1]+"eta_dt"), etaDt);
    }
    
  //변수를 선언하고
    

    

    /**
  	 * (Sheet)TPSZ Combo composition<br>
  	 * @param sXml
  	 */
    function setTPSZCombo(sheetObj, sXml) {
    	var arrCombo=ComXml2ComboString(sXml, "cntr_tpsz_cd", "cntr_tpsz_cd");
		if(arrCombo != null && arrCombo.length > 0) 
			sheetObj.SetColProperty(prefixs[1]+"cntr_tpsz_cd", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
    }
  	/**
   	 * Aproval Combo color setting
   	 */
  	function setAuthStat(sheetObj, Row) {
    	with(sheetObj) {    		    		
    		var sheetIdx=0;    		
    		if(id == 't2sheet1') sheetIdx=1;
    		var authStsCd=GetCellValue(Row, prefixs[sheetIdx]+"auth_sts_cd");
    		var authStsColor="#FF862B";
    		SetCellFont("FontBold", Row, prefixs[sheetIdx]+"auth_sts_cd",1);
			switch(authStsCd) {
				case "Y":
					authStsColor="#4D964B";
					break;					
				case "N":
					authStsColor="#FF0000";
					break;					
				case "P":
					authStsColor="#2663E0";
					break;
			}
			SetCellFontColor(Row, prefixs[sheetIdx]+"auth_sts_cd",authStsColor);
    	}    	
    }
  	/**
   	 * Application Details Setter
   	 */
  	var detailXml;
  	function setAppDetlObj(sheetObj, row) {
  		//In case there no selected row or just added row
  		if(sheetObj == null || sheetObj.GetCellValue(row, prefixs[0]+"cgo_opr_cd") == '') {
  			detailXml=null;
  		} else {
  			detailXml=makeSearchXml(sheetObj, row);
  		}
  	}
  	/**
   	 * Application Details Getter
   	 */
  	function getAppDetlObj() {
  		return detailXml;
  	}
   	/**
	 * Synchronize with close merge cell 
	 */
   	function setSyncValMerge(sheetObj, Row, Col, Value) {
		sheetObj.RenderSheet(0);
		with(sheetObj) {
			var status=GetRowStatus(Row);
    		var selFlg;
    		if(status == 'U') {
		    	for(var selIdx=Row+1; selIdx<=LastRow(); selIdx++) {
		    		selFlg=false;
		    		if(GetCellValue(Row, prefixs[1]+"bkg_ref_no") == GetCellValue(selIdx, prefixs[1]+"bkg_ref_no")
		    				&& GetCellValue(Row, prefixs[1]+"spcl_cgo_rqst_seq") == GetCellValue(selIdx, prefixs[1]+"spcl_cgo_rqst_seq")
		    				&& (GetRowStatus(selIdx) == 'U' || GetRowStatus(selIdx) == 'R')) {
	    				selFlg=true; 
		    		} else if(GetRowStatus(selIdx) != 'I' && GetRowStatus(selIdx) != 'D') {
	    				selIdx=LastRow();
	    			}
		    		if(selFlg) {
		    			SetCellValue(selIdx, Col,Value,0);
		    			if(Col == SaveNameCol(prefixs[1]+"pol_cd")) {
		    				searchPodCd(sheetObj, selIdx, GetCellValue(selIdx, prefixs[1]+"vsl_cd"), GetCellValue(selIdx, prefixs[1]+"skd_voy_no"), GetCellValue(selIdx, prefixs[1]+"skd_dir_cd"), Value);
		    			}		    			
		    		}
		    	}
		    	for(var selIdx=Row-1; selIdx>=HeaderRows(); selIdx--) {
		    		selFlg=false;
		    		if(GetCellValue(Row, prefixs[1]+"bkg_ref_no") == GetCellValue(selIdx, prefixs[1]+"bkg_ref_no")
		    				&& GetCellValue(Row, prefixs[1]+"spcl_cgo_rqst_seq") == GetCellValue(selIdx, prefixs[1]+"spcl_cgo_rqst_seq")
		    				&& (GetRowStatus(selIdx) == 'U' || GetRowStatus(selIdx) == 'R')) {
	    				selFlg=true; 
		    		} else if(GetRowStatus(selIdx) != 'I' && GetRowStatus(selIdx) != 'D') {
	    				selIdx=HeaderRows();
	    			}
		    		if(selFlg) {
		    			SetCellValue(selIdx, Col,Value,0);
		    			if(Col == SaveNameCol(prefixs[1]+"pol_cd")) {
		    				searchPodCd(sheetObj, selIdx, GetCellValue(selIdx, prefixs[1]+"vsl_cd"), GetCellValue(selIdx, prefixs[1]+"skd_voy_no"), GetCellValue(selIdx, prefixs[1]+"skd_dir_cd"), Value);
		    			}
		    		}
		    	}
    		}
    	}
		sheetObj.RenderSheet(1);
		return true;
   	}
	/**
   	 * Application Details Getter
   	 */
  	function setRqstSeq(sheetObj) {
  		var ibflag, aproNo, aproStatus, rqstSeq;
    	var sVal1;
    	var sVal2;
		for(var rowIdx1=sheetObj.HeaderRows(); rowIdx1<=sheetObj.LastRow(); rowIdx1++) {
			ibflag=sheetObj.GetRowStatus(rowIdx1);
			sVal1=sheetObj.GetCellValue(rowIdx1, prefixs[1]+"cgo_opr_cd");
			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[1]+"bkg_ref_no");
			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[1]+"vsl_cd");
			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[1]+"skd_voy_no");
			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[1]+"skd_dir_cd");
			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[1]+"pol_cd");
			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[1]+"pod_cd");
			if(ibflag != 'D' && ibflag == 'I'  && sVal1 != '') {				
	    		for(var rowIdx2=sheetObj.HeaderRows(); rowIdx2<=sheetObj.LastRow(); rowIdx2++) {
	    			if(rowIdx1 != rowIdx2) {
	    				ibflag=sheetObj.GetRowStatus(rowIdx2);
	    				aproNo=sheetObj.GetCellValue(rowIdx2, prefixs[1]+"apro_ref_no");
	    				aproStatus=sheetObj.GetCellValue(rowIdx2, prefixs[1]+"org_auth_sts_cd");
	    				rqstSeq=sheetObj.GetCellValue(rowIdx2, prefixs[1]+"spcl_cntr_seq");
	    				sVal2=sheetObj.GetCellValue(rowIdx2, prefixs[1]+"cgo_opr_cd");
	    				sVal2  += sheetObj.GetCellValue(rowIdx2, prefixs[1]+"bkg_ref_no");
	    				sVal2  += sheetObj.GetCellValue(rowIdx2, prefixs[1]+"vsl_cd");
	    				sVal2  += sheetObj.GetCellValue(rowIdx2, prefixs[1]+"skd_voy_no");
	    				sVal2  += sheetObj.GetCellValue(rowIdx2, prefixs[1]+"skd_dir_cd");
	    				sVal2  += sheetObj.GetCellValue(rowIdx2, prefixs[1]+"pol_cd");
	    				sVal2  += sheetObj.GetCellValue(rowIdx2, prefixs[1]+"pod_cd");
						if(ibflag != 'D' && ((ibflag == 'R' || ibflag == 'U') && aproStatus == 'R') && sVal2 != '') {
			    			if(sVal1 == sVal2) {
			    				sheetObj.SetCellText(rowIdx1, prefixs[1]+"spcl_cgo_rqst_seq" ,sheetObj.GetCellValue(rowIdx2, prefixs[1]+"spcl_cgo_rqst_seq"));
			    			}
			    		}
	    			}
				}
			}
    	}
		return true;
  	}
   	/**
	 * Http Param Getter
	 */
    function getSaveParam(sheetObj, formObj, tabIdx) {
     	var dgFlg="Y", awkFlg="Y";
 		if(tabIdx == '0') {
// 			var iRowStr=sheetObj.FindStatusRow("I");
// 			var iRows=iRowStr.split(";");
// 			for (idx=0; idx<iRows.length-1; idx++){
// 				sheetObj.RowDelete(iRows[idx], false);
// 			}
// 			var rowStatus;
// 			for (idx=sheetObj.HeaderRows(); idx<=sheetObj.LastRow(); idx++) {
// 				rowStatus=sheetObj.GetRowStatus(idx);
// 			    if(rowStatus == 'U') {
// 			    	sheetObj.SetCellValue(idx, prefixs[0]+"del_chk",0,0);
// 			    	sheetObj.SetRowStatus(idx,'R');
// 			    }
// 			}
 			awkFlg="N";
 		} else {
 			dgFlg="N"
 		}
 		var prefix=prefixs[parseInt(tabIdx)];
// 		var sortCols=new Array();
// 		sortCols[0]=prefix+"vsl_cd";
// 		sortCols[1]=prefix+"skd_voy_no";
// 		sortCols[2]=prefix+"skd_dir_cd";
// 		sortCols[3]=prefix+"cgo_opr_cd";
// 		sortCols[4]=prefix+"pol_cd";
// 		sortCols[5]=prefix+"pod_cd";
// 		sortCols[6]=prefix+"bkg_ref_no";
// 		sortCols[7]=prefix+"spcl_cgo_rqst_seq";
// 		sortCols[8]=prefix+"spcl_cntr_seq";
// 		sortCols[9]=prefix+"spcl_cgo_seq";
// 		var sortDirs=new Array();
// 		sortDirs[0]="ASC";
// 		sortDirs[1]="ASC";
// 		sortDirs[2]="ASC";
// 		sortDirs[3]="ASC";
// 		sortDirs[4]="ASC";
// 		sortDirs[5]="ASC";
// 		sortDirs[6]="ASC";
// 		sortDirs[7]="ASC";
// 		sortDirs[8]="ASC";
// 		sortDirs[9]="ASC";
// 		//sheetObj.ColumnSort(sortCols.join("|"),"ASC",sortDirs.join("|"),true);
// 		var sParam=ComGetSaveString(sheetObj, false, false, -1);
// 		if(sParam == "") return ''; 
// 		if(tabIdx == '1') {
 			var rslt=validateForm(sheetObj,formObj,IBSAVE);
 			if(!rslt) {
 				return '';
 			}
 			//sParam=ComGetSaveString(sheetObj, false, true, -1);
 			sParam		= ComGetSaveString(sheetObj, true, false, -1);
 			if(sParam == '') return '';
// 		}
 		var paramPrefix=new Array(prefix, prefix, "file_");
 		sParam += "&"+FormQueryString(formObj)+"&dg_flg="+ dgFlg +"&awk_flg="+awkFlg +"&auth_sts_cd=R&" + ComGetPrefixParam(paramPrefix);
 		
 		
 		return sParam;
    }
	/**
	 * Result of modified data Setter
	 */
    function setResultPop(formObj, sheetObj) {
		if(sheetObj != null && formObj[0] != "I") {
	    	var pSheetObj=sheetObjects[0];
	    	var selNo=pSheetObj.GetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"seqNo");
	    	var startRow=-1;    
	    	pSheetObj.RenderSheet(0);
	    	var delList1=new Array();
	    	var delCt=0;
	    	var addYn=true;
	    	for(var pRow=pSheetObj.LastRow(); pRow>=pSheetObj.HeaderRows(); pRow--) {
	    		var sameNo=pSheetObj.GetCellValue(pRow, prefixs[0]+"seqNo");
	    		if(selNo == sameNo) {
	    			var delList2=new Array();
	    			delList2[0]=pSheetObj.GetCellValue(pRow, prefixs[0]+"spcl_cntr_seq");
	    			delList2[1]=pSheetObj.GetCellValue(pRow, prefixs[0]+"spcl_cgo_seq");
	    			delList2[2]=pSheetObj.GetCellValue(pRow, prefixs[0]+"auth_sts_cd");
	    			delList1[delCt++]=delList2;
	    			pSheetObj.RowDelete(pRow, false);
	    			startRow=pRow-1;
	    		}
	    	}
	    	for(var cRow=sheetObj.HeaderRows(); cRow<=sheetObj.LastRow(); cRow++) {
    			addYn=true;
    			if(sheetObj.GetCellValue(cRow, "auth_sts_cd") == "Y" || sheetObj.GetCellValue(cRow, "auth_sts_cd") == "N") {
    				addYn=false;
	    			for(var i=0; i<delList1.length; i++) {
	    				//Display in case the cargo status changed from request to confirm.
	    				if(delList1[i][2]=='R' && delList1[i][0]==sheetObj.GetCellValue(cRow, "spcl_cntr_seq") && delList1[i][1]==sheetObj.GetCellValue(cRow, "spcl_cgo_seq"))
	    					addYn=true;
	    			}
    			}
	    		if(addYn) {
		    		if(cRow == sheetObj.HeaderRows()) pSheetObj.DataInsert(startRow);
		    		else pSheetObj.DataInsert();
		    		for(var cCol=0; cCol<=pSheetObj.LastCol(); cCol++) {
		    			var colName=pSheetObj.ColSaveName(cCol).replace(prefixs[0],'');
		    			if(colName == 'imdg_subs_rsk_lbl_cd') {
		    				var n1stSubs=sheetObj.GetCellValue(cRow, "n1st_imdg_subs_rsk_lbl_cd");
		    				var n2ndSubs=sheetObj.GetCellValue(cRow, "n2nd_imdg_subs_rsk_lbl_cd");
		    				var n3rdSubs=sheetObj.GetCellValue(cRow, "n3rd_imdg_subs_rsk_lbl_cd");
		    				var n4thSubs=sheetObj.GetCellValue(cRow, "n4th_imdg_subs_rsk_lbl_cd");
		    				if(n1stSubs != '' && n2ndSubs != '') n1stSubs=n1stSubs + "/" + n2ndSubs; 
		    				else n1stSubs=n1stSubs + n2ndSubs; 
		    				if(n1stSubs != '' && n3rdSubs != '') n1stSubs=n1stSubs + "/" + n3rdSubs; 
		    				else n1stSubs=n1stSubs + n3rdSubs; 
		    				if(n1stSubs != '' && n4thSubs != '') n1stSubs=n1stSubs + "/" + n4thSubs; 
		    				else n1stSubs=n1stSubs + n4thSubs; 
		    				pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), cCol,n1stSubs,0);
		    			} else {
		    				pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), cCol,sheetObj.GetCellValue(cRow, colName),0);
		    			}
		    		}
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"seqNo",selNo,0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"spcl_cgo_rqst_seq",formObj[1],0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"vsl_cd",formObj[2],0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"skd_voy_no",formObj[3],0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"skd_dir_cd",formObj[4],0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"slan_cd",formObj[5],0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"bkg_ref_no",formObj[6],0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"cgo_opr_cd",formObj[7],0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"pol_cd",formObj[8].substring(0,5),0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"pol_clpt_ind_seq",formObj[8].substring(5,6),0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"eta_dt",formObj[9],0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"pod_cd",formObj[10].substring(0,5),0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"pod_clpt_ind_seq",formObj[10].substring(5,6),0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"crr_cd",formObj[11],0);
		    		pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"seq",sheetObj.GetCellValue(cRow, "spcl_cgo_seq"),0);
		    		
		    		////pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), prefixs[0]+"prnr_cgo_rqst_seq",formObj[12],0);
		    		
		    		setAuthStat(pSheetObj, pSheetObj.GetSelectRow());
		    		pSheetObj.SetRowStatus(pSheetObj.GetSelectRow(),"R");
	    		}
	    	}
	    	pSheetObj.RenderSheet(1);
	    	var totRowCt = pSheetObj.RowCount("R") + pSheetObj.RowCount("I") + pSheetObj.RowCount("U");
	    	if(totRowCt == 0) ComBtnDisable("btn_details"); 
		}
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Set&Getter 
    //////////////////////////////////////////////////////////////////////////////////////////     
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Do action indoors
    ////////////////////////////////////////////////////////////////////////////////////////// 
  	/**
  	 * Dangerous CGO Application Details for Partner Lines (Pop-Up)<br>
  	 */
  	function doPopDetails(sheetObj, Row) {
  		if(Row == -1 || sheetObj.RowCount()== 0) {
  			ComShowCodeMessage("SCG50034");	//'Please use after Retrieve.'
  			return;
  		} else {
  			//initialize
  			setAppDetlObj(null, Row);
  			var rgn_shp_opr_cd = sheetObj.GetCellValue(Row, prefixs[0]+"rgn_shp_opr_cd");
		  	if(rgn_shp_opr_cd == '') rgn_shp_opr_cd = comboObjects[0].GetSelectText(); //comboObjects[0].GetSelectText();
		  	var sParam=Array();
		  	if(rgn_shp_opr_cd == "RST"){
		  		rgn_shp_opr_cd = "";
		  	}
		  	sParam[0]="rgn_shp_opr_cd="+rgn_shp_opr_cd;
		  	if(Row != -1 && sheetObj.GetTotalRows()!= 0) {
				var paramNm="";
				for(var col=1; col<=sheetObj.LastCol(); col++){
					paramNm=sheetObj.ColSaveName(col);
					paramNm=paramNm.substring(9, paramNm.length);
//					if(paramNm == "slan_cd"){
//						console.log("col>"+col+"&value>"+sheetObj.GetCellValue(Row, col));
//					}
					sParam[col]=paramNm+"="+encodeURIComponent(sheetObj.GetCellValue(Row, col)); 
				} 
				//In case of Copy, Row info save				
				if(sheetObj.GetCellValue(Row, prefixs[0]+"spcl_cgo_rqst_seq") == '') {
			  		setAppDetlObj(sheetObj, Row);
			  	}
		  	} else {
		  		sParam[1]="vsl_cd="    + ComGetObjValue(document.form.vsl_cd);
		  		sParam[2]="skd_voy_no="+ ComGetObjValue(document.form.skd_voy_no);
		  		sParam[3]="skd_dir_cd="+ ComGetObjValue(document.form.skd_dir_cd);
		  		sParam[4]="crr_cd="    + ComGetObjValue(document.form.crr_cd);
		  		sParam[5]="slan_cd="   + ComGetObjValue(document.form.slan_cd);
		  		sParam[6]="cfr_flg="   + ComGetObjValue(document.form.cfr_flg);
		  	}
		  	
		  	//@@@@VOP_SCG_1022 -> Attatch File 팝업창 없애고 호출하는 곳에서 구현해야될 것으로 보임 
		    //ComOpenWindowCenter(, "winEditDtl", "800", "600", true);
		  	//for(var i=0; i < sParam.length; i++){
		  	//	console.log(">>>>>>>>>>"+sParam[i]);	
		  	//}
		  	
		  	//alert(sParam);
		  	
		    ComOpenPopup("VOP_SCG_1022.do?mode=edit&PID=VOP_SCG_0022&mode2=N&"+sParam.join("&"), 1170, 700, "getPop1022", "1,0,1,1,1,1,1", true);
  		}
  	}
  	
  	function getPop1022(returnVal) {
//  		alert(returnVal);
  	}
  	/**
  	 * Extract only booking information from cago information<br>
  	 */
  	function doMakeBookInfo(sheetObj) {
  		for(var rowIdx1=sheetObj.HeaderRows(); rowIdx1<sheetObj.LastRow(); rowIdx1++) {
  		}
  	}
  	/**
     * Make Search XML of Application Details using copy
     */
    function makeSearchXml(sheetObj, row) {
    	var colOrder="";
    	var colValue="";
     	colValue += "<TR><![CDATA[";
        for (ic=0; ic<= sheetObj.LastCol(); ic++) {
        	var sName=sheetObj.ColSaveName(ic);
        	sName=sName.substring(9, sName.length);
        	var sValue=String(sheetObj.GetCellValue(row, ic));
        	colOrder += sName + "|";
        	colValue += sValue + "||";
        }
        colValue += "]]></TR>\n";
        var rowXml="<?xml version='1.0'?>\n<SHEET>\n<DATA COLORDER='"+colOrder+"' COLSEPARATOR='||' TOTAL='1'>\n";
     	rowXml += colValue + "</DATA>\n</SHEET>";
 	    return rowXml;
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Do action indoors
    ////////////////////////////////////////////////////////////////////////////////////////// 
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Do action outdoors
    ////////////////////////////////////////////////////////////////////////////////////////// 
    // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //retrieve
        		if(!validateForm(sheetObj,formObj,sAction)) return;
    			formObj.f_cmd.value=SEARCH;
    			// 검색조건
//    			var sParam=Array();
//    		  	sParam[0]="func_flg="+ComGetObjValue(formObj.func_flg);
    			sheetObj.SetWaitImageVisible(0);
    			ComOpenWait(true);
    			setTimeout( function () {
    				var sXml=sheetObj.GetSearchData("VOP_SCG_0022GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(prefixs));
         			var arrXml=sXml.split("|$$|");
         			tabIdx=tabObjects[0].GetSelectedIndex();
         			loadCt=0;
         			//ComOpenWait(true, true);
    				sheetObjects[0].RenderSheet(0);
    				sheetObjects[1].RenderSheet(0);
    				if(tabIdx == 0) {
    					for(var i=0; i<arrXml.length; i++) {
//    						tabObjects[0].SetSelectedIndex(i);
    						sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
    					}
//    					tabObjects[0].SetSelectedIndex(tabIdx);
    				} else {
    					for(var i=arrXml.length-1; i>=0; i--) {
//    						tabObjects[0].SetSelectedIndex(i);
    						sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
    					}
//    					tabObjects[0].SetSelectedIndex(tabIdx);
    				}
    				sheetObjects[0].RenderSheet(1);
    				sheetObjects[1].RenderSheet(1);
    				sheetObjects[0].SetMergeCell(0, 20, 2, 2);	
    			} , 100);	
     			
	     		break;
	     		
        	case SEARCH01:      //retrieve again	
        		
				formObj.f_cmd.value	= SEARCH;
				ComOpenWait(true);
    			setTimeout( function () {
    				var sXml			= sheetObj.GetSearchData("VOP_SCG_0022GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(prefixs));
    	 			var arrXml			= sXml.split("|$$|");
    	 			
    	 			sheetObj.RenderSheet(0);
    	 			sheetObj.LoadSearchData(arrXml[0],{Sync:0} );
    	 			sheetObj.RenderSheet(1);    				
    			} , 100);
	 			
	     		break;
	     		
			case IBSAVE:        //save				
				formObj.f_cmd.value=MULTI;
				var tabIdx=ComGetObjValue(formObj.tabSelectedIdx);
				var sParam1=getSaveParam(sheetObj, formObj, tabIdx);
				if(tabIdx == '0') {
					tabIdx='1';
				} else {
					tabIdx='0';
				}
				var sheetObj2=sheetObjects[parseInt(tabIdx)];
				var sParam2=getSaveParam(sheetObj2, formObj, tabIdx);
				if(sheetObj.IsDataModified()&& sParam1 == '') sParam2="";
				if(sheetObj2.IsDataModified()&& sParam2 == '') sParam1="";
				if((sParam1+sParam2).length > 0) {	
	        		if(!ComShowCodeConfirm('SCG50001', 'data')) return;	//'Do you want to save {?msg1}?'
				} else {
					return;
				}
				var sXml1="", sXml2="";
				var rslt1="", rslt2="";
				
				if(sParam1.length > 0) {
					sXml1=sheetObj.GetSaveData("VOP_SCG_0022GS.do", sParam1);
					rslt1=ComGetEtcData(sXml1, "rslt");
				}
				if(sParam2.length > 0) {
					sXml2=sheetObj2.GetSaveData("VOP_SCG_0022GS.do", sParam2);
					rslt2=ComGetEtcData(sXml2, "rslt");
				}
				if(sXml2.length > 0) {
					if(rslt2 == '0') ComShowMessage(ComScgGetMessageFromXml(sXml2));
					else sheetObj2.LoadSaveData(sXml2);
				} else if(sXml1.length > 0) {
					if(rslt1 == '0') ComShowMessage(ComScgGetMessageFromXml(sXml1));
					else sheetObj.LoadSaveData(sXml1);
				}
				if(rslt1 == '0' || rslt2 == '0') {
					doActionIBSheet(sheetObjects[0],formObj,SEARCH01);
					tabObjects[0].SetSelectedIndex(1);
				} else {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
				}
				break;
        }
    }
    // Combo related process handling
    function doActionIBCombo(comboObj, comboNo) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
        sheetObj.ShowDebugMsg(false);
        switch(comboNo) {
	  		case 1:    
	  			if(ComGetObjValue(document.form.func_flg) == "MNL") {
	  				formObj.f_cmd.value=SEARCH01;	
	  			}else{
	  				formObj.f_cmd.value=SEARCH11;
	  			}
	  			
	  			sheetObj.SetWaitImageVisible(0);
         		var sXml=sheetObj.GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
        		sheetObj.SetWaitImageVisible(1);
        		ComXml2ComboItem(sXml, rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
        		//var initSelTxt = comboObj.FindIndex("ASR", 0);
        		//comboObj.Text = initSelTxt;
        		//ComSetFocus(rgn_shp_opr_cd);
	  			break;  
        }
    }
    /**
     * Vessel Name retrieve
     */
    function searchVVDRelInfo(vsl_cd, skd_voy_no, skd_dir_cd, wFrom, Row) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[1];
    	var sParam=Array();
	  	sParam[0]="vsl_cd="+vsl_cd;
	  	sParam[1]="skd_voy_no="+skd_voy_no;
	  	sParam[2]="skd_dir_cd="+skd_dir_cd;
	  	sParam[3]="f_cmd="+SEARCH05;
	  	sheetObj.SetWaitImageVisible(0);
    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
    	sheetObj.SetWaitImageVisible(1);
    	if(wFrom == 'form') {
	 	   	//setting Vessel Name
	 	    setVslEngNm(formObj, sXml);
    	} else if(wFrom == 't2Sheet1') {
    		//setting Vessel Lane
    		setVslLane(sheetObj, sXml, Row);
    		//create POL Combo
    		portXml="";
    		searchPolCd(sheetObj, Row, vsl_cd, skd_voy_no, skd_dir_cd);
    	} 
    }
    /**
     * Cargo Operator retrieve
     */
    function searchCarrierInfo(sheetObj, Row, cgoOprCd) {  
    	var formObj=document.form;
    	formObj.f_cmd.value=SEARCH01;
    	sheetObj.SetWaitImageVisible(0);
 	   	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", "crr_cd="+cgoOprCd+"&"+FormQueryString(formObj));
 	    sheetObj.SetWaitImageVisible(1);
 	   	var crrData=ComScgXml2Array(sXml, "crr_cd");
	   	if(crrData == null) {
		    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
		    sheetObj.SelectCell(Row, prefixs[1]+"cgo_opr_cd", true, "");
	   	}
	   	setSyncValMerge(sheetObj, Row, sheetObj.SaveNameCol(prefixs[1]+"cgo_opr_cd"), sheetObj.GetCellValue(Row, prefixs[1]+"cgo_opr_cd"));
    }
    /**
     * POL list retrieve
     */
    var portXml="";
    function searchPolCd(sheetObj, Row, vsl_cd, skd_voy_no, skd_dir_cd) {  
    	var sParam=Array();
	  	sParam[0]="vsl_cd="+vsl_cd;
	  	sParam[1]="skd_voy_no="+skd_voy_no;
	  	sParam[2]="skd_dir_cd="+skd_dir_cd;
	  	sParam[3]="f_cmd="+SEARCH10;
	  	sheetObj.SetWaitImageVisible(0);
	  	if(portXml == '') portXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
	  	sheetObj.SetWaitImageVisible(1);
		return setPolCombo(sheetObj, Row, portXml);
    }
    /**
     * POD list retrieve
     */
    function searchPodCd(sheetObj, Row, vsl_cd, skd_voy_no, skd_dir_cd, pol_cd) {  
 	   	var sParam=Array();
 	  	sParam[0]="vsl_cd="+vsl_cd;
 	  	sParam[1]="skd_voy_no="+skd_voy_no;
 	  	sParam[2]="skd_dir_cd="+skd_dir_cd;
 	  	sParam[3]="f_cmd="+SEARCH10;
 	  	if(pol_cd != '') {
	 	  	sheetObj.SetWaitImageVisible(0);
	 	  	if(portXml == '') portXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
	 	  	sheetObj.SetWaitImageVisible(1);
 	  	}
 		setPodCombo(sheetObj, Row, portXml, pol_cd);
    }
    /**
     * ETA retrieve
     */
    function searchETADt(sheetObj, Row, vsl_cd, skd_voy_no, skd_dir_cd, loc_cd) {  
    	var sParam=Array();
    	sParam[0]="vsl_cd="+vsl_cd;
	  	sParam[1]="skd_voy_no="+skd_voy_no;
	  	sParam[2]="skd_dir_cd="+skd_dir_cd;
	  	sParam[3]="loc_cd="+loc_cd.substring(0,5);
	  	sParam[4]="f_cmd="+SEARCH10;
	  	sheetObj.SetWaitImageVisible(0);
		var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
		sheetObj.SetWaitImageVisible(1);
		setETADt(sheetObj, Row, sXml);
    }
    /**
     * TP/SZ list retrieve
     */
    function searchTPSZ(sheetObj) {  
    	var formObj=document.form;
    	formObj.f_cmd.value=SEARCH06;
    	sheetObj.SetWaitImageVisible(0);
		var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
		sheetObj.SetWaitImageVisible(1);
		setTPSZCombo(sheetObj, sXml);
    }
    /**
     * retrieve
     */
    function searchList() {  
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    }
    /**
     * sending request mail
     */
    function sendReqMail(sheetObj, Row, formObj) {
    	if(Row == -1) {
  			//ComShowCodeMessage("SCG50034");	//'Please use after Retrieve.'
  			return;
  		} else {
  			
  			var crr_cd=sheetObj.GetCellValue(Row, prefixs[1]+"cgo_opr_cd");
			var bkg_ref_no=sheetObj.GetCellValue(Row, prefixs[1]+"bkg_ref_no");
			var spcl_cgo_rqst_seq=sheetObj.GetCellValue(Row, prefixs[1]+"spcl_cgo_rqst_seq");
			//2016-01-22 Prnr_cgo_rqst_seq 추가 
			var prnr_cgo_rqst_seq=sheetObj.GetCellValue(Row, prefixs[1]+"prnr_cgo_rqst_seq");
		  	var var_rgn_shp_opr_cd=comboObjects[0].GetSelectText();
		  	var scg_flg="AK";
		  	var send_type="P0";
		  	var user_id=ComGetObjValue(formObj.user_id);
		  	
		  	
		  	var vsl_cd=sheetObj.GetCellValue(Row, prefixs[1]+"vsl_cd");
		  	var skd_voy_no=sheetObj.GetCellValue(Row, prefixs[1]+"skd_voy_no");
		   	var skd_dir_cd=sheetObj.GetCellValue(Row, prefixs[1]+"skd_dir_cd");
	  		var pol_cd=sheetObj.GetCellValue(Row, prefixs[1]+"pol_cd");
		  	var pod_cd=sheetObj.GetCellValue(Row, prefixs[1]+"pod_cd");
		  	//var pol_cd=sheetObj.GetCellValue(formObj.pol_cd.value);
		  	//var pod_cd=sheetObj.GetCellValue(formObj.pod_cd.value);
		  	formObj.pol_cd.value = pol_cd;
		  	formObj.pod_cd.value = pod_cd;
//		  	var pol_cd=ComGetObjValue(formObj.pol_cd);
//		  	var pod_cd=ComGetObjValue(formObj.pod_cd);
		   	
		  	alert(pol_cd);
		  	alert(pod_cd);
		  	
		  	mailObj.crr_cd=crr_cd;
		  	mailObj.bkg_ref_no=bkg_ref_no;
		  	mailObj.spcl_cgo_rqst_seq=spcl_cgo_rqst_seq;
		  	mailObj.prnr_cgo_rqst_seq=prnr_cgo_rqst_seq;
		  	mailObj.rgn_shp_opr_cd=var_rgn_shp_opr_cd;
		  	mailObj.scg_flg=scg_flg;
		  	mailObj.send_type=send_type;
		  	mailObj.user_id=user_id;
		  	
		  	mailObj.vsl_cd = vsl_cd;
		    mailObj.skd_voy_no = skd_voy_no;
		    mailObj.skd_dir_cd = skd_dir_cd;
		    mailObj.pol_cd = pol_cd;
		    alert(mailObj.pol_cd);
		    mailObj.pod_cd = pod_cd;
		    
		  	//ComScgSendMail(sheetObj, formObj, mailObj);

		  
			ComScgSendMail(sheetObj, formObj, mailObj, true, "VOP_SCG_0022GS.do", "authPending()");
			
  		}
    	formObj.pol_cd.value = "";
    	formObj.pod_cd.value = "";
    }
    /**
     * Carrier Validation
     */
    function searchCarrierCheck(obj) {
      	var formObj=document.form;
      	var sheetObj=sheetObjects[1];
      	var sParam=Array();
  	  	sParam[0]="crr_cd="+obj.value;
  	  	sParam[3]="f_cmd="+SEARCH01;
  	  	if(sParam.join("").length > 18) {  
  	  		sheetObj.SetWaitImageVisible(0);
  	    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
  	    	sheetObj.SetWaitImageVisible(1);
  	    	var crrData=ComScgXml2Array(sXml, "crr_cd");
  		   	if(crrData == null) {
  			    ComShowCodeMessage("SCG50010",'Data');	//'{?msg1} is invalid.'
  			    ComSetObjValue(obj, ""); 	
 	 		    ComSetFocus(obj);
  		   	} 
  	  	} else {  	  		
  	  		ComChkObjValid(obj, true);
  	  	}
    }
    /**
     * Carrier Validation
     */
    var loadCt=0;
    function quitWaitImg(val) {
    	loadCt += val;
    	if(loadCt == 2) {
    		//ComOpenWait(false);
    	} 
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Do action outdoors
    //////////////////////////////////////////////////////////////////////////////////////////     
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Validate
    //////////////////////////////////////////////////////////////////////////////////////////
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
    	switch(sAction) {
	    	case IBSEARCH:
	    		//Check requirement of Irregulars Type
	    		if (comboObjects[0].GetSelectCode()== "") {
	    			ComShowCodeMessage('SCG50011','RSO');
	    			//formObj.rgn_shp_opr_cd.focus();
	    			return;
	    		}
	    		//Check Validation in all controls inside form object
	    		if (ComGetObjValue(formObj.booking_no) == "") {
	    			if(!ComChkValid(formObj, true, false, false)) 
	    				return false;	
	    		}
	    		break;
	    	case IBSAVE:
	        	var idx = 0;
	        	if(sheetObj.id == "t2sheet1") idx = 1;
	    		
	    		var ibflag, aproNo, aproStatus;
	    		var cntrSeq1, cntrSeq2;
	    		var cgoSeq1, cgoSeq2;
		    	var sVal1;
		    	var sVal2;
		    	var sOverDimVal;
		    	var dupChk=0;
	    		for(var rowIdx1=sheetObj.HeaderRows(); rowIdx1<=sheetObj.LastRow(); rowIdx1++) {
	    			ibflag=sheetObj.GetRowStatus(rowIdx1);
	    			sVal1=sheetObj.GetCellValue(rowIdx1, prefixs[idx]+"cgo_opr_cd");
	    			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[idx]+"bkg_ref_no");
	    			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[idx]+"vsl_cd");
	    			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[idx]+"skd_voy_no");
	    			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[idx]+"skd_dir_cd");
	    			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[idx]+"pol_cd");
	    			sVal1 += sheetObj.GetCellValue(rowIdx1, prefixs[idx]+"pod_cd");
		    		cntrSeq1=sheetObj.GetCellText(rowIdx1, prefixs[idx]+"spcl_cntr_seq");
		    		cgoSeq1 =sheetObj.GetCellText(rowIdx1, prefixs[idx]+"spcl_cgo_seq");
		    		
		    		if(ibflag=='D'){
		    		ComShowCodeMessage('SCG50062');
		    		break;
		    		}
		    		
					if(ibflag != 'D' && ibflag == 'I'  && sVal1 != '') {
			    		for(var rowIdx2=sheetObj.HeaderRows(); rowIdx2<=sheetObj.LastRow(); rowIdx2++) {
			    			if(rowIdx2 != rowIdx1) {
			    				ibflag=sheetObj.GetRowStatus(rowIdx2);
			    				aproNo=sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"apro_ref_no");
			    				aproStatus=sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"org_auth_sts_cd");
			    				sVal2=sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"cgo_opr_cd");
			    				sVal2 += sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"bkg_ref_no");
			    				sVal2 += sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"vsl_cd");
			    				sVal2 += sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"skd_voy_no");
			    				sVal2 += sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"skd_dir_cd");
			    				sVal2 += sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"pol_cd");
			    				sVal2 += sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"pod_cd");
				    			cntrSeq2 = sheetObj.GetCellText(rowIdx2, prefixs[idx]+"spcl_cntr_seq");
				    			cgoSeq2  = sheetObj.GetCellText(rowIdx2, prefixs[idx]+"spcl_cgo_seq"); // CGO Seq 까지 같으면 중복으로 인식 되도록 추가  2011.04.21
				    			if(ibflag != 'D' && sVal2 != '') {
				    				if(sVal1 == sVal2) {
//				    					if(cntrSeq1 == cntrSeq2) {
				    					if(cntrSeq1 == cntrSeq2 && cgoSeq1 == cgoSeq2 ) {
					    					ComShowCodeMessage('SCG50005','Data');   //'{?msg1} is duplicated.'
					    					sheetObj.SelectCell(rowIdx2, prefixs[idx]+"spcl_cntr_seq");
						    				return false;
				    					} else {
				    						dupChk++;
				    					}
				    				}
				    			}
			    			}
			    			
		    				if(idx == 1){
		    					// BKG duplication check(Server)
		    					if(ibflag == 'I') {
		    						var sParam=Array();
		    				  	  	sParam[0]="crr_cd="+sheetObj.GetCellValue(rowIdx2, prefixs[1]+"crr_cd");
		    				  	    sParam[1]="bkg_ref_no="+sheetObj.GetCellValue(rowIdx2, prefixs[1]+"bkg_ref_no");
		    				  	    sParam[2]="cgo_opr_cd="+sheetObj.GetCellValue(rowIdx2, prefixs[1]+"cgo_opr_cd");
		    				  	    sParam[3]="pol_cd="+sheetObj.GetCellValue(rowIdx2, prefixs[1]+"pol_cd");
		    				  	    sParam[4]="pod_cd="+sheetObj.GetCellValue(rowIdx2, prefixs[1]+"pod_cd");
		    				  	  	sParam[5]="f_cmd="+SEARCH02;
		            				var sXml=sheetObj.GetSearchData("VOP_SCG_1022GS.do", sParam.join("&"));
		            				if(ComGetEtcData(sXml, "Bkg") != "0") {
		            					ComShowCodeMessage("COM12115", "BKG Ref No");
	    	        					return false;
		    	        			}
		    					}
		    					sOverDimVal  = sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"fwrd_ovr_dim_len");
			    				sOverDimVal += sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"bkwd_ovr_dim_len");
			    				sOverDimVal += sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"lf_sd_ovr_dim_len");
			    				sOverDimVal += sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"rt_sd_ovr_dim_len");
			    				sOverDimVal += sheetObj.GetCellValue(rowIdx2, prefixs[idx]+"hgt_ovr_dim_len");
			    				
			    				if(sOverDimVal == ''){
			    					ComShowCodeMessage('SCG50007','Over Dimension');
			    					return false;
			    				}
		    				}
						}
			    		//Check Confirm duplicated Seq in cargo list.
			    		for(var dupIdx=0; dupChkList != null && dupIdx<dupChkList.length; dupIdx++) {
			    			if(sVal1 == dupChkList[dupIdx][0]) {
		    					if(cntrSeq1 == dupChkList[dupIdx][1]) {
			    					ComShowCodeMessage('SCG50005','Data');   //'{?msg1} is duplicated as same {?msg2}'
			    					sheetObj.SelectCell(rowIdx1, prefixs[1]+"spcl_cntr_seq");
				    				return false;
		    					} else {
		    						dupChk++;
		    					}
		    				} 
			    		}
					}
		    	}
			    if(dupChk > 0) setRqstSeq(sheetObj);
		    	break;
	    	case IBCLEAR:
	    		if(sheetObj.IsDataModified()) {
	    			if(ComShowCodeConfirm('SCG50003')) {	//'Data was changed. Do you want to save it?'
	    				doActionIBSheet(sheetObj,formObj,IBSAVE);
	    				return false;
	    			}
	    		}
	    		break;
		}
	    return true;
    }
    
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }
    
    function changeSearchCondition(isTab) {
    	if(ComGetObjValue(document.form.func_flg) == "MNL") {
	    	sheetObjects[0].SetColHidden(prefixs[0]+"del_chk_t", 0);
	    	document.all.item("comment").style.display="none";
	    	document.querySelector("#vsl_cd").setAttribute('class', 'input1');
    		document.querySelector("#skd_voy_no").setAttribute('class', 'input1');
    		document.querySelector("#skd_dir_cd").setAttribute('class', 'input1');
	    	document.querySelector("#vsl_cd").setAttribute('required', 'true');
	    	document.querySelector("#skd_voy_no").setAttribute('required', 'true');
	    	document.querySelector("#skd_dir_cd").setAttribute('required', 'true');
    	} else {
	    	sheetObjects[0].SetColHidden(prefixs[0]+"del_chk_t", 1);
	    	document.all.item("comment").style.display="inline";
	    	document.querySelector("#vsl_cd").setAttribute('class', 'input');
    		document.querySelector("#skd_voy_no").setAttribute('class', 'input');
    		document.querySelector("#skd_dir_cd").setAttribute('class', 'input');
	    	document.querySelector("#vsl_cd").removeAttribute('required');
	    	document.querySelector("#skd_voy_no").removeAttribute('required');
	    	document.querySelector("#skd_dir_cd").removeAttribute('required');
    	}
    	doActionIBCombo(comboObjects[0],1);
    	if(!isTab) {
	    	sheetObjects[0].RemoveAll();
//	    	sheetObjects[1].RemoveAll();
	    	resetTab1(sheetObjects[0]);
//	    	resetTab2(sheetObjects[1]);
    	}
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Validate
    //////////////////////////////////////////////////////////////////////////////////////////


