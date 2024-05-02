// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sRow = 0;

/*
 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        //시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);

        initSheet(sheetObjects[i],i+1);

        //마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }

    // Subj.Month 날짜 세팅
    var formObj = document.form;
    formObj.comm_yrmon.value = ComGetNowInfo("ym" ) 
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;

    switch(sheetNo) {
        case 1:      //sheet1 init
            with (sheetObj) {
                //높이 설정
                style.height = GetSheetHeight(15);

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 9, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(23, 5, 0, true);

                //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                InitHeadMode(true, true, true, true, false, false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
                var HeadTitle = "STS|CHK|No.|Acct.|Description|Vendor|Name|Office|City|Center|Apply\nDate|VVD|Cur|PYMT AMT|Ex. Rate|USD AMT|Approval\nDate|||||Status|Remark";
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtStatus,    30,    daCenter,  false,    "ibflag",  false,    "",         dfNone,     0,          false,      true);
                InitDataProperty(0, cnt++, dtCheckBox,  40,    daCenter,  true,     "chk",    false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtSeq,       30,    daCenter,  true,     "seq",    false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtData,      60,    daCenter,  true,     "comm_stnd_cost_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      150,   daLeft,    true,     "otr_comm_acct_ctnt",   true,     "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,     "vndr_seq",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      150,   daLeft,    true,     "ofc_eng_nm",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      60,    daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "comm_occr_info_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "ap_ctr_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,     "aply_dt", true,     "",         dfDateYmd,  0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      80,    daCenter,  true,     "vvd",    false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      40,    daCenter,  true,     "curr_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,    daRight,   true,     "act_if_locl_comm_amt", true,     "",         dfFloat,    2,          true,       true);
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "mon_xch_rt",  false,    "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,    daRight,   true,     "act_if_comm_amt", true,     "",         dfFloat,    2,          false,       false);
                InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,     "ac_apro_dt", false,    "",         dfDateYmd,  0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "bkg_no",  false,    "",         dfNone,     0,          false,      false);
//                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "bkgNoS", false,    "",         dfNone,     0,          false,      false);
//                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "io_bnd_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "ac_tp_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "ac_seq",  false,    "",         dfNone,     0,          false,      false);
//                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "vndr_seq",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "comm_proc_sts_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,      200,   daLeft,    true,     "comm_proc_sts_rsn", false,    "",         dfNone,     0,          false,      false);
				
				//컬럼 속성 설정
				InitDataValid(0, "otr_comm_acct_ctnt",  vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?");	//Description 컬럼은 영문자 + 숫자 + 특수키만 입력되도록 설정
                //InitDataValid(0, "ofcCd", vtEngUpOther, "");			//Office 컬럼은 영대문자만 입력되도록 설정

                //콤보 항목 설정하기
                //InitDataCombo(0, "acct", "512611|512621|512631|512641|512661|512691", "512611|512621|512631|512641|512661|512691","512691");
                //InitDataCombo(0, "curr", "USD", "USD", "USD");
                
                //전체선택시 이벤트 발생안함
                AllowEvent4CheckAll = false; 
                
                CountPosition  = 0 ;
            }
            break;
    }
}

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    var sheetObject = sheetObjects[0];
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;

            case "btn_save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;

            case "btn_reject":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
				break;

			case "btn_audit":
                doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC02);
                break;

            case "btn_cancel":
				doActionIBSheet(sheetObject,formObject,IBCLEAR);
				break;

            case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
        } // end switch

    }catch(e) {
        if( e == "[object Error]") {
        	ComShowMessage(ComGetMsg("COM12111", "", ""));
        } else {
        	ComShowMessage(e);
        }
    }
}

/*
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      //retrieve
            if(!validateForm(sheetObj,formObj,sAction)) return false;

            formObj.f_cmd.value = SEARCH;
//            alert(agtQryStr(formObj));
            sheetObj.DoSearch4Post("ESM_AGT_0016GS.do", agtQryStr(formObj));
            sheetObj.SumText(0,0) = "";
            sheetObj.SumText(0,3) = "TOTAL";
            break;

        case IBSAVE:        //save
            if(!validateForm(sheetObj,formObj,sAction)) return false;

            formObj.f_cmd.value = MULTI;
            sheetObj.DoSave("ESM_AGT_0016GS.do", agtQryStr(formObj));
            
            //저장후 재조회
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch4Post("ESM_AGT_0016GS.do", agtQryStr(formObj));
            sheetObj.SumText(0,0) = "";
            sheetObj.SumText(0,3) = "TOTAL";
            break;

        case IBSEARCH_ASYNC01:	//reject
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MODIFY;
			sheetObj.DoSave("ESM_AGT_0016GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			break;
		
		case IBSEARCH_ASYNC02:  //Approval
            if(!validateForm(sheetObj,formObj,sAction)) return false;

			//sbOfc를 구한다.
			var chkRow = sheetObj.FindCheckedRow("chk");
			var arrRow = chkRow.split("|");
			sbOfc = sheetObj.CellValue(arrRow[0],"agn_cd");
			var expType = formObj.exp_type.value;
            scnId = "OTHER";
            arOfc = formObj.ar_ofc_cd.value;
            sbOfc = formObj.s_agn_cd.value;
            var comm_yrmon = formObj.comm_yrmon.value;
            saDate = comm_yrmon.replace('-','')+ "31";
            var rArray = getCheckedRows(sheetObj, "chk");
            
            var args = new Array();
  			args["scnId"] = scnId;
			args["arOfc"] = arOfc;
			args["sbOfc"] = sbOfc;
			args["saDate"] = saDate;
			args["expType"] = expType;
			args["bkg_no"] = sheetObj.CellValue(arrRow[0],"bkg_no");
			args["io_bnd_cd"] = sheetObj.CellValue(arrRow[0],"io_bnd_cd");
			args["ac_tp_cd"] = sheetObj.CellValue(arrRow[0],"ac_tp_cd");
			args["acSeq"] = sheetObj.CellValue(arrRow[0],"ac_seq");
			args["sheet"] = rArray.toString();
			
			window.showModalDialog("ESM_AGT_0036.do", args, "scroll:no");
//			window.open("ESM_AGT_0036.do");
            //승인후 재조회
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch4Post("ESM_AGT_0016GS.do", agtQryStr(formObj));
            sheetObj.SumText(0,0) = "";
            sheetObj.SumText(0,3) = "TOTAL";
            break;

        case IBCLEAR:	//cancel
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = REMOVE;
			sheetObj.DoSave("ESM_AGT_0016GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
            sheetObj.SumText(0,3) = "TOTAL";
			break;
		
		case IBDOWNEXCEL:	//excel down
			sheetObj.SpeedDown2Excel(-1);
			break;
    }
}

/*
 * APPROVAL을 위해 선택한 행(들)의 키값 구하기
 */
function getCheckedRows(sheetObj, colName) {
    var checkRows;
    var colsCnt = sheetObj.LastCol + 1;
    var rows = sheetObj.Rows;
    var rArray = null; //행데이터를 담고 있는 배열
    var bkg_no;
    var bkg_no_tmp;
    var bkg_no_len = 0;

    checkRows = sheetObj.CheckedRows(colName);

    if(checkRows == 0){
        return null;
    }else{
        var idx = 0;
        rArray = new Array(checkRows);

        for(var i=0; i<rows; i++) {
            if(sheetObj.CellValue(i,colName) == 1) {
                //rArray[idx++] = sheetObj.CellValue(i,"bkgNo") + sheetObj.CellValue(i,"agnCd") + sheetObj.CellValue(i,"bndCd") + sheetObj.CellValue(i,"acSeq");
                // 20080529-sunganj : Oracle Tunning 권고안에 따른 수정
                bkg_no = "";
			    bkg_no_split = "  ";
			    bkg_no_tmp = "";
                bkg_no_len = 0;
                bkg_no_tmp = sheetObj.CellValue(i,"bkg_no");
                bkg_no_len = bkg_no_tmp.length;
                
                if(bkg_no_len > 11){
                    bkg_no = bkg_no_tmp.substring(0,11);
                	bkg_no = bkg_no_tmp;
//                    bkg_no_split = bkg_no_tmp.substring(11,13);
                }else{
                    bkg_no = bkg_no_tmp;
//                    bkg_no_split = "  ";
                }
                
//                rArray[idx++] = bkg_no + "_" + bkg_no_split + "_"+ sheetObj.CellValue(i,"agn_cd") + "_"  + sheetObj.CellValue(i,"io_bnd_cd") + "_"  + sheetObj.CellValue(i,"ac_seq");
                rArray[idx++] = bkg_no + sheetObj.CellValue(i,"agn_cd") + sheetObj.CellValue(i,"io_bnd_cd") +  sheetObj.CellValue(i,"ac_seq");
            }
        }

        return rArray;
    }
}

/**
 * A/R Office를 변경하면, 해당 Vendor, Vendor Name, Office, City, Center 정보 조회하기
 */
function cbArOfcCd_OnChange(obj){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
    
//    var arOfcCd = formObj.cbArOfcCd.value;
    var arOfcCd = formObj.ar_ofc_cd.value;
    formObj.param1.value = arOfcCd;
//    formObj.param3.value = "cbSbOfcCd";
    formObj.param3.value = "s_agn_cd";
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0016FR.do";
    formObj.submit();
    
    //Grid를 초기화한다.
    sheetObj.RemoveAll();
}

/**
 * Subject Office를 변경하면, 그리드를 초기화한다.
 */
function cbSbOfcCd_OnChange(obj){
    var sheetObj = sheetObjects[0];
    
    //Grid Reset
	sheetObj.RemoveAll();
}

/*
 * Office정보를 체크
 */
function checkOfficeInfo(){
    var formObj = document.form;
	var vendor = formObj.param3.value;

    if(vendor == ""){
    	ComShowMessage(ComGetMsg("AGT10025", arOfcCd, "", ""));
    	formObj.cbArOfcCd.value = "";
    	formObj.param1.value = "";
    }
}

/*
 * 그리드에서 컬럼값 변경시 처리
 */
function sheet1_OnChange(sheetObj, row, col) {
	var formObj = document.form;
	
	var comm_proc_sts_cd = sheetObj.CellValue(row,"comm_proc_sts_cd");
	var colNm =	sheetObj.ColSaveName(col);
	
	//이미 Approval된 행은 수정,삭제 불가
	if(comm_proc_sts_cd == "AS" || comm_proc_sts_cd == "IF"){
		if(colNm != "chk"){
			showErrMessage(getMsg("AGT10011", "", "", ""));
			sheetObj.ReturnCellData(row, "comm_stnd_cost_cd");
			sheetObj.ReturnCellData(row, "otr_comm_acct_ctnt");
			sheetObj.ReturnCellData(row, "aply_dt");
			sheetObj.ReturnCellData(row, "vvd");
			sheetObj.ReturnCellData(row, "curr_cd");
			sheetObj.ReturnCellData(row, "act_if_locl_comm_amt");
			sheetObj.ReturnCellData(row, "act_if_comm_amt");
			return;
		}
	
	}else{
		//Apply Date 변경시, xchRt를 재설정한다.
		if(colNm == "aply_dt"){
			sRow = row;
			var aplyDt = sheetObj.CellValue(row, "aply_dt");
			
			formObj.param2.value = aplyDt;
		    formObj.target = "frmHidden";
		    formObj.action = "ESM_AGT_0016FR2.do";
		    formObj.submit();
		}
		
		//LCL AMT 변경시, USD AMT를 재계산한다.
		if(colNm == "act_if_locl_comm_amt"){
			sheetObj.CellValue2(row, "act_if_comm_amt") = sheetObj.CellValue(row, "act_if_locl_comm_amt") / sheetObj.CellValue(row, "mon_xch_rt");
		}
				
		//USD AMT 변경시, LCL AMT를 재계산한다.
		if(colNm == "act_if_comm_amt"){
			sheetObj.CellValue2(row, "act_if_locl_comm_amt") = sheetObj.CellValue(row, "act_if_comm_amt") * sheetObj.CellValue(row, "mon_xch_rt");
		}
	}
}

/*
 * 환율을 Grid에 세팅
 */
function setXchRt(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	var arOfcCd = formObj.ar_ofc_cd.value;
	var xchRt = formObj.param9.value;
	alert(xchRt);
	if(xchRt == "" || xchRt == "0"){
		ComShowMessage(ComGetMsg("AGT10026", arOfcCd, xchRt, ""));
    }else{
    	sheetObj.CellValue2(sRow, "mon_xch_rt") = xchRt;
    	
    	var act_locl_comm_amt = sheetObj.CellValue(sRow, "act_locl_comm_amt");
    	var act_comm_amt = sheetObj.CellValue(sRow, "act_comm_amt");
    	
    	if(usdAmt > 0){
    		sheetObj.CellValue2(sRow, "act_locl_comm_amt") = act_comm_amt * xchRt;
    	}else{
    		sheetObj.CellValue2(sRow, "act_comm_amt") = act_locl_comm_amt / xchRt;
    	}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
//        if (!ComIsNumber(iPage)) {
//            return false;
//        }
    	
        switch(sAction) {
            case IBSEARCH:	//Retrieve
                if(ar_ofc_cd.value == ""){
                	ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
//                    formObj.cbArOfcCd.focus();
                    formObj.ar_ofc_cd.focus();
                    return false;
                }

                if(comm_yrmon.value == ""){
                	ComShowMessage(ComGetMsg("COM12113", "Subj.Month", "", ""));
                    formObj.comm_yrmon.focus();
                    return false;
                }
       
                break;

            case IBSAVE:	//Save
                if(ar_ofc_cd.value == ""){
                	ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
//                    formObj.cbArOfcCd.focus();
                    formObj.ar_ofc_cd.focus();
                    return false;
                }

                if(comm_yrmon.value == ""){
                	ComShowMessage(ComGetMsg("COM12113", "Subj.Month", "", ""));
                    formObj.comm_yrmon.focus();
                    return false;
                }

                var cnt = sheetObj.RowCount("I") + sheetObj.RowCount("U") + sheetObj.RowCount("D");
                if(cnt < 1){
                	ComShowMessage(ComGetMsg("AGT10010", "", "", ""));
                    return false;
                }
                
                //승인여부 체크
				var rows = sheetObj.RowCount;
				
				for(var i=0; i<rows; i++) {
					var flag = sheetObj.CellValue(i+1,"ibflag");
				    if(flag == "U" || flag == "D" || flag == "I"){
				    	if(sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "AS" || sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "IF"){
				    		ComShowMessage(ComGetMsg("AGT10018", i+1, "SAVE", ""));
				    		
				    		formObj.f_cmd.value = SEARCH;
			                sheetObj.DoSearch4Post("ESM_AGT_0016GS.do", agtQryStr(formObj));
			                sheetObj.SumText(0,0) = "";
			                sheetObj.SumText(0,3) = "TOTAL";
			                
							return false;
						}
		     		}
		  		}
								
		  		break;

			case IBSEARCH_ASYNC01:	//Reject
				//선택건수 체크
				var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					ComShowMessage(ComGetMsg("COM12113", "row for reject", "", ""));
					return false;
				}	  
		     	
		     	//처리상태 체크
		     	var rows = sheetObj.RowCount;
			    for(var i=0; i<rows; i++) {
		            if(sheetObj.CellValue(i+1,"chk") == "1"){
		            	if(sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "AS" || sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "IF"){ //(kevin) Request에서만 Reject할 수 있음
		            		ComShowMessage(ComGetMsg("AGT10027", "Reject", "", ""));
			                return false;
			            }
		            }
		        }
		        break; 
				
			case IBSEARCH_ASYNC02:	//Audit
                if(ar_ofc_cd.value == ""){
                	ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
//                    formObj.cbArOfcCd.focus();
                    formObj.ar_ofc_cd.focus();
                    return false;
                }

                if(comm_yrmon.value == ""){
                	ComShowMessage(ComGetMsg("COM12113", "Subj.Month", "", ""));
                    formObj.comm_yrmon.focus();
                    return false;
                }

                var checkCnt = sheetObj.CheckedRows("chk");
                if(checkCnt < 1){
                	ComShowMessage(ComGetMsg("COM12113", "row for audit", "", ""));
                    return false;
                }
                
                var rows = sheetObj.RowCount;
			    for(var i=0; i<rows; i++) {
		            if(sheetObj.CellValue(i+1,"chk") == "1"){
		            	if(sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "AS" || sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "IF"){
		            		ComShowMessage(ComGetMsg("AGT10012", i+1, "", ""));    
			                return false;
			            }
		            }
		        }
                break;

            case IBCLEAR:	//cancel
				//선택건수 체크
				var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					ComShowMessage(ComGetMsg("COM12113", "row for cancel", "", ""));
					return false;
				}	  
		     	
		     	//승인여부 체크
				var rows = sheetObj.RowCount;
				
				for(var i=0; i<rows; i++) {
				    if(sheetObj.CellValue(i+1,"chk") == 1){
				    	if(sheetObj.CellValue(i+1,"comm_proc_sts_cd") != "AS"){ //(kevin) Audit에서만 Cancel할 수 있음
				    		ComShowMessage(ComGetMsg("AGT10013", i+1, "", "")); 
							return false;
						}
		     		}
		  		}
		     	break; 
        }
    }

    return true;
}

/**
 * Exp. Type를 변경하면, Grid를 초기화한다.
 */
function expType_OnChange(obj){
    var sheetObj1 = sheetObjects[0];
	sheetObj1.RemoveAll();
//	currentRow = 0;
}