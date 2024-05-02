/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0906.js
*@FileTitle  : Multiple Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/* 공통전역변수 */
var curTab=1;
var beforetab=0;
var sheetObjects=new Array();
var sheetCnt=0;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName = ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;
			case "btng_rowadd":
    			doActionIBSheet(sheetObject,formObject,IBINSERT);
			break;
			case "btng_apply":
				comPopupOK1(sheetObject,formObject);
			break;
			case "btn_close":
				ComClosePopup();
			break;
			case "btn_new":
				ComNew();
				break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e);
		}
	}
}

function ComNew(){
	sheetObjects[0].RemoveAll();
	for(i=0; i < 6; i++) {
		sheetObjects[0].DataInsert(-1);
	}
	sheetObjects[0].SelectCell(1,"multiplekey");
	form.row_count.value = "1";
	var returnVal = form.returnval.value;
	returnVal = returnVal.replace("btn_", "");	
	var returnUrl = form.pgmNo.value;
	var strCntrList = ""
		if(returnUrl == "ESD_TRS_0016" || returnUrl == "ESD_TRS_0054") {
			if(returnVal == "VVD") {
				returnVal = "vvdnumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "BKG") {
				returnVal = "bkgnumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "BL") {
				returnVal = "blnumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "EQ") {
				returnVal = "eqnumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "SO") {
				returnVal = "sonumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "WO") {
				returnVal = "wonumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "INV") {
				returnVal = "invnumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}
		}else if(returnUrl == "ESD_TRS_0055") {
			 if(returnVal == "eq_no") {
				returnVal = "eq_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}
		}else if(returnUrl == "ESD_TRS_0083") {
			 if(returnVal == "BKG") {
				returnVal = "booking_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "BLN") {
				returnVal = "bill_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}
		}else if(returnUrl == "ESD_TRS_0082") {
			 if(returnVal == "OFC") {
				returnVal = "input_cre_ofc_cd";
				strCntrList = eval("opener.form."+returnVal+"");
			}
		} else if(returnUrl == "ESD_TRS_0047") {
			 if(returnVal == "") {
				returnVal = "mult_csr_no";
				strCntrList = eval("opener.form."+returnVal+"");
			}
		} else if(returnUrl == "ESD_TRS_0046" || returnUrl == "ESD_TRS_0030" || returnUrl == "ESD_TRS_0033") {
			 if(returnVal == "btns_no_cd") {
				returnVal = "no_cd";
				strCntrList = eval("opener.form."+returnVal+"");
			}else if(returnVal == "Office Code") {
				returnVal = "inv_cre_ofc";
				strCntrList = eval("opener.form."+returnVal+"");
			}else if(returnVal == "btns_wo_no") {
				returnVal = "wo_no";
				strCntrList = eval("opener.form."+returnVal+"");
			}else if(returnVal == "btns_booking_no") {
				returnVal = "booking_no";
				strCntrList = eval("opener.form."+returnVal+"");
			}else if(returnVal == "btns_eq_no") {
				returnVal = "eq_no_text";
				strCntrList = eval("opener.form."+returnVal+"");
			}else if(returnVal == "btns_bl_no") {
				returnVal = "bl_no";
				strCntrList = eval("opener.form."+returnVal+"");
			}else if(returnVal == "btns_so_no") {
				returnVal = "so_no";
				strCntrList = eval("opener.form."+returnVal+"");
			}
		}else if(returnUrl == "ESD_TRS_0028" || returnUrl == "ESD_TRS_0204" || returnUrl == "ESD_TRS_0201" || returnUrl == "ESD_TRS_0202" || returnUrl == "ESD_TRS_0203") {
			 if(returnVal == "VVD") {
				returnVal = "trunk_vvd";
				strCntrList = eval("opener.form."+returnVal+"");
			}else if(returnVal == "BKG") {
				returnVal = "bkg_no";
				strCntrList = eval("opener.form."+returnVal+"");
			}else if(returnVal == "BLN") {
				returnVal = "bill_no";
				strCntrList = eval("opener.form."+returnVal+"");
			}else if(returnVal == "CNT") {
				returnVal = "cntr_no";
				strCntrList = eval("opener.form."+returnVal+"");
			}else if(returnVal == "SC") {
				returnVal = "sc_no";
				strCntrList = eval("opener.form."+returnVal+"");
			}else if(returnVal == "REF") {
				returnVal = "refer_no";
				strCntrList = eval("opener.form."+returnVal+"");
			}
		}else if(returnUrl == "ESD_TRS_0019") {
			if(returnVal == "T.VVD") {
				returnVal = "trunk_vvd";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "Booking No.") {
				returnVal = "bkgnumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "B/L No.") {
				returnVal = "blnumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "COP No.") {
				returnVal = "copnumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "ZIP Code") {
				returnVal = "zip_code";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "EQ No.") {
				returnVal = "eqnumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "SO No.") {
				returnVal = "sonumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "WO No.") {
				returnVal = "wonumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "Invoice No.") {
				returnVal = "invoicenumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "MTY REF No.") {
				returnVal = "mtyrefnumber";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "FM_NODE") {
				returnVal = "search_fm_node";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "TO_NODE") {
				returnVal = "search_to_node";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "Slot Ref No.") {
				returnVal = "cntr_slt_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}
		}else{
			if(returnVal == "VVD") {
				returnVal = "trunk_vvd";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "BKG") {
				returnVal = "bkg_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "BLN") {
				returnVal = "bill_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "CNT") {
				returnVal = "cntr_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "FVD") {
				returnVal = "txt_feeder_vvd";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "ZIP") {
				returnVal = "zip_code";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "REF") {
				returnVal = "reference_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_multicntrno") {
				returnVal = "cntr_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "SON") {
				returnVal = "so_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "WON") {
				returnVal = "wo_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "RFN") {
				returnVal = "reference_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_multicntr") {
				returnVal = "cntr_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "eq_no") {
				returnVal = "form_eq_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_wo_no") {
				returnVal = "wo_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_dor_pst_cd") {
				returnVal = "dor_pst_cd";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_fm_lcc_cd") {
				returnVal = "fm_lcc_cd";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_to_lcc_cd") {
				returnVal = "to_lcc_cd";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_ecc_cd") {
				returnVal = "ecc_cd";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_tvvd_no") {
				returnVal = "tvvd_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_fvvd_no") {
				returnVal = "fvvd_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_cop_no") {
				returnVal = "cop_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_bkg_no") {
				returnVal = "bkg_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_bl_no") {
				returnVal = "bl_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_eq_no") {
				returnVal = "eq_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_so_no") {
				returnVal = "so_no";
				strCntrList = eval("parent.form."+returnVal+"");		
			}else if(returnVal == "btns_mty_rfrn_no") {
				returnVal = "mty_rfrn_no";
				strCntrList = eval("parent.form."+returnVal+"");
			}else if(returnVal == "btns_cntr_slt_no") {
				returnVal = "cntr_slt_no";
				strCntrList = eval("parent.form."+returnVal+"");
			} else{
				try {
					strCntrList = eval("opener.form."+returnVal+"");
				}catch(e) {
					
				}
			}
		}
	strCntrList.value = "";
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

    for(i=0; i < 6; i++) {
		sheetObjects[0].DataInsert(-1);
	}

    sheetObjects[0].SelectCell(1,"multiplekey");
	var returnVal = form.returnval.value;
	var returnUrl = form.pgmNo.value;
	returnVal = returnVal.replace("btn_", "");
	var strCntrList = "";
	if(returnUrl == "ESD_TRS_0016" || returnUrl == "ESD_TRS_0054") {
		if(returnVal == "VVD") {
			returnVal = "vvdnumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "BKG") {
			returnVal = "bkgnumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "BL") {
			returnVal = "blnumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "EQ") {
			returnVal = "eqnumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "SO") {
			returnVal = "sonumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "WO") {
			returnVal = "wonumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "INV") {
			returnVal = "invnumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}
	}else if(returnUrl == "ESD_TRS_0055") {
		 if(returnVal == "eq_no") {
			returnVal = "eq_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}
	}else if(returnUrl == "ESD_TRS_0083") {
		 if(returnVal == "BKG") {
			returnVal = "booking_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "BLN") {
			returnVal = "bill_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}
	}else if(returnUrl == "ESD_TRS_0082") {
		 if(returnVal == "OFC") {
			returnVal = "input_cre_ofc_cd";
			strCntrList = eval("opener.form."+returnVal+".value");
		}
	} else if(returnUrl == "ESD_TRS_0047") {
		 if(returnVal == "") {
			returnVal = "mult_csr_no";
			strCntrList = eval("opener.form."+returnVal+".value");
		}
	} else if(returnUrl == "ESD_TRS_0046" || returnUrl == "ESD_TRS_0030" || returnUrl == "ESD_TRS_0033") {
		 if(returnVal == "btns_no_cd") {
			returnVal = "no_cd";
			strCntrList = eval("opener.form."+returnVal+".value");
		}else if(returnVal == "Office Code") {
			returnVal = "inv_cre_ofc";
			strCntrList = eval("opener.form."+returnVal+".value");
		}else if(returnVal == "btns_wo_no") {
			returnVal = "wo_no";
			strCntrList = eval("opener.form."+returnVal+".value");
		}else if(returnVal == "btns_booking_no") {
			returnVal = "booking_no";
			strCntrList = eval("opener.form."+returnVal+".value");
		}else if(returnVal == "btns_eq_no") {
			returnVal = "eq_no_text";
			strCntrList = eval("opener.form."+returnVal+".value");
		}else if(returnVal == "btns_bl_no") {
			returnVal = "bl_no";
			strCntrList = eval("opener.form."+returnVal+".value");
		}else if(returnVal == "btns_so_no") {
			returnVal = "so_no";
			strCntrList = eval("opener.form."+returnVal+".value");
		}
	}else if(returnUrl == "ESD_TRS_0028" || returnUrl == "ESD_TRS_0204" || returnUrl == "ESD_TRS_0201" || returnUrl == "ESD_TRS_0202" || returnUrl == "ESD_TRS_0203") {
		 if(returnVal == "VVD") {
			returnVal = "trunk_vvd";
			strCntrList = eval("opener.form."+returnVal+".value");
		}else if(returnVal == "BKG") {
			returnVal = "bkg_no";
			strCntrList = eval("opener.form."+returnVal+".value");
		}else if(returnVal == "BLN") {
			returnVal = "bill_no";
			strCntrList = eval("opener.form."+returnVal+".value");
		}else if(returnVal == "CNT") {
			returnVal = "cntr_no";
			strCntrList = eval("opener.form."+returnVal+".value");
		}else if(returnVal == "SC") {
			returnVal = "sc_no";
			strCntrList = eval("opener.form."+returnVal+".value");
		}else if(returnVal == "REF") {
			returnVal = "refer_no";
			strCntrList = eval("opener.form."+returnVal+".value");
		}
	}else if(returnUrl == "ESD_TRS_0019") {
		if(returnVal == "T.VVD") {
			returnVal = "trunk_vvd";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "Booking No.") {
			returnVal = "bkgnumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "B/L No.") {
			returnVal = "blnumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "COP No.") {
			returnVal = "copnumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "ZIP Code") {
			returnVal = "zip_code";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "EQ No.") {
			returnVal = "eqnumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "SO No.") {
			returnVal = "sonumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "WO No.") {
			returnVal = "wonumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "Invoice No.") {
			returnVal = "invoicenumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "MTY REF No.") {
			returnVal = "mtyrefnumber";
			strCntrList = eval("parent.form."+returnVal+".value");
		} else if(returnVal == "FM_NODE") {
			returnVal = "search_fm_node";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "TO_NODE") {
			returnVal = "search_to_node";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "Slot Ref No.") {
			returnVal = "cntr_slt_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}
	}else{
		if(returnVal == "VVD") {
			returnVal = "trunk_vvd";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "BKG") {
			returnVal = "bkg_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "BLN") {
			returnVal = "bill_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "CNT") {
			returnVal = "cntr_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "FVD") {
			returnVal = "txt_feeder_vvd";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "ZIP") {
			returnVal = "zip_code";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "REF") {
			returnVal = "reference_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_multicntrno") {
			returnVal = "cntr_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "SON") {
			returnVal = "so_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "WON") {
			returnVal = "wo_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "RFN") {
			returnVal = "reference_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_multicntr") {
			returnVal = "cntr_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "eq_no") {
			returnVal = "form_eq_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_wo_no") {
			returnVal = "wo_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_dor_pst_cd") {
			returnVal = "dor_pst_cd";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_fm_lcc_cd") {
			returnVal = "fm_lcc_cd";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_to_lcc_cd") {
			returnVal = "to_lcc_cd";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_ecc_cd") {
			returnVal = "ecc_cd";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_tvvd_no") {
			returnVal = "tvvd_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_fvvd_no") {
			returnVal = "fvvd_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_cop_no") {
			returnVal = "cop_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_bkg_no") {
			returnVal = "bkg_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_bl_no") {
			returnVal = "bl_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_eq_no") {
			returnVal = "eq_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_so_no") {
			returnVal = "so_no";
			strCntrList = eval("parent.form."+returnVal+".value");		
		}else if(returnVal == "btns_mty_rfrn_no") {
			returnVal = "mty_rfrn_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else if(returnVal == "btns_cntr_slt_no") {
			returnVal = "cntr_slt_no";
			strCntrList = eval("parent.form."+returnVal+".value");
		}else{
			strCntrList = eval("opener.form."+returnVal+".value");
		}
	}
	
	
	if(strCntrList.length > 0) {
		var sheetCnt = sheetObjects[0].RowCount();
		var strCntr = strCntrList.split(",");
		var intCntrlength = strCntr.length;
		if(parseInt(sheetCnt) < parseInt(intCntrlength)) {
			
			for(var j=sheetCnt;j<intCntrlength;j++) {
				sheetObjects[0].DataInsert(-1);
			}
			sheetCnt = sheetObjects[0].RowCount();				
		}
		
		for(var i=1;i<=sheetCnt;i++) {
			sheetObjects[0].SetCellValue(i,"multiplekey",strCntr[i-1]);
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:
            with(sheetObj){
				var HeadTitle="Seq.|Chk|Item";
				
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"multiplekey",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 , AcceptKeys:"E|N"}  
						   ];
				InitColumns(cols);
				SetSheetHeight(ComGetSheetHeight(sheetObj, 7) + 30);
				var rtnTtl = document.form.returntitle.value.toUpperCase();
                if(rtnTtl == "(ZIP CODE)") {
                    SetColProperty("multiplekey" , {AcceptKeys:"E|N|[ ]" , InputCaseSensitive:1});
                } else if(rtnTtl == "(INVOICE NO.)") {
                    SetColProperty("multiplekey" , {AcceptKeys:"E|N|[~!@#$%^&*()?/<,>.-_=+|\{[}];:]" , InputCaseSensitive:1});
                } else {
                    SetColProperty("multiplekey" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                }
                SetEditable(1);
            }
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBINSERT: 
			ComOpenWait(true);				
			setTimeout( function () {
				var lvcnt=0;
				var lvrow=sheetObj.RowCount();
				lvcnt=eval(formObj.row_count.value);
				if( isNaN(formObj.row_count.value) || donumberheck(formObj.row_count.value)){
					formObj.row_count.value="1";				
				} 
				lvcnt=eval(formObj.row_count.value);
				for(i=0; i < lvcnt; i++){
					sheetObj.DataInsert(-1);
				}
				sheetObj.FitColWidth();
				ComOpenWait(false);
			} , 100);
		break;
	}
}
/**
 * Location 이나 Contry Code 입력시 이벤트처리 
 *
 */
function sheet1_OnChange(sheetObj, row, col, value){
	var formObject=document.form;
	var colName=sheetObj.ColSaveName(col);
	var inputStr=delSpace(value);
	switch(colName){
		case 'multiplekey':
			for (var i=0; i < inputStr.length; i++) {
				var oneChar=inputStr.charAt(i);
				if (oneChar != "") {
					if ( hanCheck(oneChar) ) {
						var errMessage=ComGetMsg('COM12127','Multiple Inquiry data!','','');  
						ComShowMessage(errMessage);
						sheetObj.SetCellValue(row,col,"");
						sheetObj.SelectCell(row, col);
						loopval="N";
						break;
					}else{
						continue;
					}
				} else {
					break;
				}
			}
			
			var chkval=ComTrim(sheetObj.GetCellValue(row, 'multiplekey'));
			if(chkval=="") {
				sheetObj.SetCellValue(row,'check',"0");
				sheetObj.SetCellValue(row,col,"");
			} else {
				sheetObj.SetCellValue(row,'check',"1");
			}
		break;
	}
}
// 한글 여부 체크.
// 입력 문자열이 한글이면 true, 한글이 아니면 false.
function hanCheck(str) {
	var str1=getByteLenval(str);
	if(str.length*2 == str1) // 한글이면
		return true;
	else    // 한글이 아니면
		return false;
}
// 입력받은 String의 Byte Size를 구한다.
function getByteLenval(str) {
	var len=0;
	if( str == null ) return 0;
	for( var i=0 ; i < str.length ; i++ ) {
		var c=escape(str.charAt(i));
		if ( c.length == 1 ) len ++;
		else if( c.indexOf("%u") != -1 ) len += 2;
		else if( c.indexOf("%") != -1 ) len += c.length/3;
	}
	return len;
} 
// 문자열 사이의 공백을 제거
function delSpace(str) {
	var trimstr=str;
	for (var i=0; i< str.length;i++) {
		trimstr=trimstr.replace(' ' ,'');
	}
	return trimstr;
}
function comPopupOK1(sheetObj,formObject) {
	
	var iCnt=0
	var return_val=formObject.returnval.value;

	var sCheckRows = sheetObj.FindCheckedRow("check");

	var arrRow = sCheckRows.split("|");

	if(sCheckRows == "") return ComShowCodeMessage("TRS90036");

	var rArray=new Array(arrRow.length);	
	
	var chkval="";
	var row=0;
	var dupVal="";
	for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
		sheetObj.SetRowBackColor(i,"#FFFFFF");
	}
	
	for(var idx=0; idx<arrRow.length; idx++){
		row = arrRow[idx];
		
		chkval=sheetObj.GetCellValue(row, "multiplekey");
		if(chkval=="") {
			var errMessage=ComGetMsg("COM12114","Multiple Inquiry data!","","");  
			ComShowMessage(errMessage);
			sheetObj.SelectCell(row, "multiplekey");
			return;
		}
		for(var j=idx+1; j<arrRow.length; j++){
			var row2 = arrRow[j];
			if (chkval == sheetObj.GetCellValue(row2, "multiplekey")){
				sheetObj.SetRowBackColor(row2,"#FFFF00");
				if (dupVal=="") dupVal=row2;
			}
		}
		rArray[idx]= chkval;
		
	}

	if( dupVal!="" ) {
		var errMessage=ComGetMsg("COM12115","Multiple Inquiry data!","","");  
		ComShowMessage(errMessage);
		sheetObj.SelectCell(dupVal, "multiplekey");
	} else {
		var opener = opener=window.opener; 
		if (!opener) {
			opener=parent; 
		}
		opener.getTRS_ENS_906(rArray,return_val);
		ComClosePopup();
	}	
}
/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray,return_val) {
	var formObject=document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[i];
	}
}

function sheet1_OnKey(sheetObj, row, col, keycode, Shift) {
	if( keycode == 9 || keycode == 13 ){
		sheetObj.SelectCell(row, 'multiplekey');
	}
}
/**
 * 숫자에 대한 유효성을 체크.
 */
function donumberheck(obj) {
	var lveng=/[0-9]/;
	if( lveng.test(obj) ) {
		return false;
	}
	return true;
}
