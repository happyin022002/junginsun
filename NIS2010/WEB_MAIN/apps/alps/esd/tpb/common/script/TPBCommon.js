/*================================================================================
'주  시 스 템 : ENIS/TPB
'서브  시스템 : 자바스크립트
'프로그램 ID  : TPBCommon.js
'프로그램 명  : TPB 업무공통 관련 스크립트
'프로그램개요 : TPB 업무공통 관련 스크립트
'작   성   자 : Kim Youngchang, Kim Jin-seung
'작   성   일 : 2006-10-13
==================================================================================
'수정자/수정일 : Kim Jin-seung / 2007-03-11
'수정사유/내역 : getVendor* vndr_cnt_cd(vendor country code) problem, is soluted!
'              index 7 (of return value array) is country code : ex) cArray[7]
==================================================================================
'수정자/수정일 : Kim Jin-seung / 2008-05-02
'수정사유/내역 : Fileupload시 모달팝업사용할 수 있도록 처리; function openFileUploadModalPopup 생성; 
==================================================================================
'수정자/수정일 : Kim Jin-seung / 2008-05-19
'수정사유/내역 : Staff 팝업조회시 COM_ENS_091에서 TPB_ESD_916으로 변경; 
==================================================================================
'수정자/수정일 : Kim Jin-seung / 2008-08-18
'수정사유/내역 : sheet에서 3rd Party 팝업으로 변경시 유효성 체크 보완; getCustomer_sheet, getVendor_sheet;
==================================================================================
'수정자/수정일 : O Wan-Ki / 2009-03-16
'수정사유/내역 : N200903090210 - tpb_vatAmountReCalculate 의 VAT Amount 는 KRW,JPY,VND 경우 Integer 로 한다. 
==================================================================================
'수정자/수정일 : O Wan-Ki / 2009-04-20
'수정사유/내역 : N200904160080 - VVD Validation Check 
==================================================================================
'수정자/수정일 : O Wan-Ki / 2009-07-24
'수정사유/내역 : New FrameWork 에의한 보완(getCustomer_sheet, getVendor_sheet)
==============================================================================--*/
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBCommon.js
*@FileTitle : TPB Common Java Script
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-09-07 O Wan-Ki	1.0 ITM-200900076, Billing Case 제공방식 추가에 의한 보완
* 2009.12.02 Sun, Choi 	1.1 ALPS Migration
* 2011.02.21 손은주 [CHM-201108686-01][TPB] 실적 조회 화면 보완 - Activity기간별 TPB 조회 기능 검색 조건 수정 check function 추가
* 2011.03.31 변종건 [CHM-201109756-01] [TPB] Billing Type 특정case 조회 이상 현상 수정
=========================================================*/


/// 전역변수
var FileUploadPopupWin = null; // File Upload PopupWindow Object
var TPBFilePath = ""; // file download시 사용, file path
var TPBFileCount = 0; // file download시 사용, current file count
var TPBMaxFileCount = 3; // file download시 사용, available maximum file count

///==============================================================================
/**
 * 공통코드 이외 코드 콤보 가져오기
 *
 * @param : id - HTML 폼객체의 element명, Sheet의 saveName
 * @param : method - 호출할 메소드명
 * @param : mode - F:HTML, S:Sheet (default:F)
 * @param : obj  - F일경우 "", S일경우 Sheet명 (default:"")
 * @param : all  - 전체선택 구분 1:ALL/"", 2:<Select>/"", 3:""/"", 4:<select>와 ALL 추가 (default:1)
 * @param : paramName - 폼 element명을 담고 있는 Array객체
 *
 *	getTPBGenCombo(id, method, [mode], [obj], [all], [paramName])
 *  예) HTML 폼 일 경우
 *			getTPBGenCombo('billing_case_cd','searchBillingCaseCode', 'F','','2', new Array("bil_tp_cd"));
 *      Sheeet 일 경우
 *			getTPBGenCombo('act_flg','searchBillingCaseCode','S','sheet1','2');
 *		간략 사용(HTML 폼)
 *			getTPBGenCombo('billing_case_cd','searchBillingCaseCode');
 */
function getTPBGenCombo(id,method,mode,obj,all,paramName, otherObjs) {
	if(mode == undefined) {mode="F";}
	if(obj == undefined) {obj="";}
	if(all == undefined) {all="1";}
	if(paramName == undefined) {
		paramName=new Array();
	} else { 
		try{ eval("document.all."+id).disabled = true; 
		} catch(e) {
			
		} 
	}
	if(otherObjs == undefined) {otherObjs=""}

	var f = document.frames;
	var ifr = "frame_"+f.length;
	var o = document.createElement("DIV");
	
	o.style.display = "none";
	o.innerHTML = '<iframe name="'+ifr+'" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
	document.body.appendChild(o);
	
	var param = '';
	for(var i =0; i < paramName.length; i++) {
		if(paramName[i] != "") {
				param += "&" + paramName[i] + "=" + eval("document.all."+paramName[i]).value;
		}
	}
	eval("document."+ifr).location.href = "TPBCommonCode.do?id="+id+"&method="+method+"&mode="+mode+"&obj="+obj+"&all="+all+"&"+param+"&otherObjs="+otherObjs;
}

/**
 * 콤보 만드는 함수 , TPBCommonCode.jsp 에서 호출
 *
 * @param : IdObj - HTML 폼객체의 element명, Sheet의 saveName
 * @param : mode - F:HTML select-list box, S:Sheet, T:input type=text, V:직접처리 (default:F)
 * @param : obj  - F일경우 "", S일경우 Sheet명 (default:""), T일경우 콤보가 아닌 input box
 * @param : all  - 전체선택 구분 
 *
 */
function makeCombo(IdObj,mode,obj,all,otherObjs) {
	if(IdObj != null )
	{ 
		var parentObj = '';
		if(mode == 'F') {
			parentObj = parent.eval("document.all."+IdObj);
			if(parentObj !=undefined) {
				ComClearCombo(parentObj);
				if(codeArr.length > 1) {
					if(all == '1') {
						ComAddComboItem(parentObj, "ALL", "" );
					} else if(all == '2') {
						ComAddComboItem(parentObj, "<<Select>>", "" );
					} else if(all == '3') {
						ComAddComboItem(parentObj, "", "" );
					} else if(all == '4') {
						ComAddComboItem(parentObj, "<<Select>>", "" );
						ComAddComboItem(parentObj, "ALL", "" );
					} else if(all == '11') {
						ComAddComboItem(parentObj, "ALL", "-" );
					}
				}
				for(var i=0,n=codeArr.length;i<n;i++) {
					ComAddComboItem(parentObj, codeArr[i][1], codeArr[i][0]);
				}
			}
			if(otherObjs != null && otherObjs != "" ){
				ComSetObjValue(parentObj, otherObjs);
			}
			parentObj.disabled = false;
		} else if(mode == 'T') {
			parentObj = parent.eval("document.all."+IdObj);
			if(parentObj !=undefined) {
				if(IdObj == "s_if_ofc_cd" ) { // EAC Office Checking
   					if(codeArr.length > 0) {
   					    parentObj.value = codeArr[0][0];
   					} else {
   						//ComShowMessage("Entered "+parentObj.value+" is not TPB Office");
   						ComShowCodeMessage("TPB90023",parentObj.value,"","");
					   parentObj.value = "";
   					}
   					
				} else if(IdObj == "stl_to_clt_cng_ofc_cd") { // Adjustment 'ROC To' Checking
   					if(codeArr.length > 0) {
   					    parentObj.value = codeArr[0][0];
   					} else {
   						//ComShowMessage("Entered 'Res.Office' is not TPB Office");
   						ComShowCodeMessage("TPB90023","'Res.Office'");
   						parent.sheetObjects[0].CellValue(otherObjs, 'stl_to_clt_cng_ofc_cd') = '';
  					    parentObj.value = "";
   					}
				} else if (IdObj == "s_eq_tpsz_cd") { // EQ TPSZ CD 
   					if(codeArr.length > 0) {
   					    parentObj.value = codeArr[0][0];
   					} else {
   						ComShowCodeMessage("TPB90031");
						try{ 
							// parent.document.all.s_eq_no.value = "";
							parent.document.all.s_eq_no.focus(); 
							parent.document.all.s_eq_no.select(); 
						} catch(e) {
						}
					   parentObj.value = "";
   					}
   				} else if (IdObj == "s_vvd") { //2009-04-20, N200904160080, VVD Check
   					
   					if(codeArr.length > 0) {
   						if(codeArr[0][0] == "0") {
   							ComShowCodeMessage("TPB90070");
	   						parent.document.form.s_vvd.value = '';
	   						parent.document.all.s_vvd.focus();
	   					}
   					} else {
   						ComShowCodeMessage("TPB90031");
   					}
   					parent.document.all.isChecked.value = "1";
				} else if (IdObj == "s_tpb_seq") { // tpb_seq 가져오기
   					if(codeArr.length > 0) {
   						parent.sheetObjects[0].CellValue2(otherObjs,2) = codeArr[0][0];
   						//parent.sheetObjects[0].CellValue2(parent.sheetObjects[0].selectRow,2) = codeArr[0][0];
   					}
				} else { // 일반적인 경우 
   					if(codeArr.length > 0) {
   					    parentObj.value = codeArr[0][0];
   					} else {
  					    parentObj.value = "";
   					}
				}
			}
			parentObj.disabled = false;
		} else if(mode == 'S') {
			parentObj = parent.eval("document.all."+obj);
			if(parentObj !=undefined) {
				var comboText = new Array();
				var comboValue = new Array();

				if(all == '1') {
					comboText[comboText.length] = "ALL";
					comboValue[comboValue.length] = " ";
				} else if(all == '2') {
					comboText[comboText.length] = "<<Select>>";
					comboValue[comboValue.length] = " ";
				} else if(all == '3') {
					comboText[comboText.length] = " ";
					comboValue[comboValue.length] = " ";
				}

				for(var i=0,n=codeArr.length;i<n;i++) {
					comboText[comboText.length] = codeArr[i][0];
					comboValue[comboValue.length] = codeArr[i][1];
				}

				parentObj.InitDataCombo(0, IdObj, comboText.join('|') , comboValue.join('|'));
			}
		} else if(mode == 'V') {				
			if ( IdObj=="CheckEqDigit") {
				if(codeArr.length > 0) {
					if( otherObjs == codeArr[0][0] ) {
					}
				} else {			
					ComShowCodeMessage('TPB90074');
					parent.sheetObjects[0].CellValue2(-1, "eq_no") = "";
				}
			} else if ( IdObj=="CheckTPBCode") {
				if(codeArr.length > 0) {
					ComShowCodeMessage('TPB90069');
					parent.sheetObjects[0].CellValue2(-1, "n3pty_bil_tp_cd") = "";
				}
			} else if ( IdObj=="CheckVendorCode") {
				if(codeArr.length <= 0) {
					ComShowCodeMessage('TPB90071');
	    			parent.document.all.s_src_vndr_no.value = "";
	    			parent.document.all.s_src_vndr_no.focus();
				}
			} else if ( IdObj=="CheckEqNo") {
				if(codeArr.length > 0) {
					parent.sheetObjects[0].CellValue2(-1, "eq_tpsz_cd") = codeArr[0][0];
				} else {			
					ComShowCodeMessage('TPB90074');
					//parent.sheetObjects[0].CellValue2(-1, "eq_no") = "";
					//parent.sheetObjects[0].CellValue2(-1, "eq_tpsz_cd") = "";
				}
			} else if ( IdObj=="CheckRegOffice") {
				if(codeArr.length <= 0) {
					ComShowCodeMessage('TPB90073');
					parent.sheetObjects[0].CellValue2(-1, "ofc_cd") = "";
				}
            } else if ( IdObj=="Void_ThirdParty") { // 3rd Party Input directly 
				if(codeArr.length > 0) {
				    var tpvTmp = codeArr[0][0]; // ComShowMessage( tpvTmp );
				    tpvTmp = tpvTmp.split("|$|");  // ComShowMessage(tpvTmp.length);
				    
				    if ( tpvTmp.length == 5 && (tpvTmp[0]=="V" || tpvTmp[0]=="C" || tpvTmp[0]=="S") ) {
				        if ( tpvTmp[0]=="V" ) { // vendor
                            parent.document.all.s_vndr_cust_div_cd.value = tpvTmp[0]; 
                            parent.document.all.s_trd_party_val.value = tpvTmp[1]; 
                            parent.document.all.s_cust_cnt_cd.value = '';
                            parent.document.all.s_cust_seq.value = '';
                            parent.document.all.s_vndr_cnt_cd.value = tpvTmp[2];
                            parent.document.all.s_vndr_seq.value = tpvTmp[1];
                            parent.document.all.s_n3pty_ofc_cd.value = '';
                            try { 
                            	parent.document.all.s_trd_party_nm.value = tpvTmp[3]; 
                            } catch(e) {
                            }
				        } else if ( tpvTmp[0]=="C" ) { // customer 
                            parent.document.all.s_vndr_cust_div_cd.value = tpvTmp[0]; 
                            parent.document.all.s_trd_party_val.value = tpvTmp[2] + tpvTmp[1]; 
                            parent.document.all.s_cust_cnt_cd.value = tpvTmp[2];
                            parent.document.all.s_cust_seq.value = tpvTmp[1];
                            parent.document.all.s_vndr_cnt_cd.value = '';
                            parent.document.all.s_vndr_seq.value = '';
                            parent.document.all.s_n3pty_ofc_cd.value = '';
                            try { 
                            	parent.document.all.s_trd_party_nm.value = tpvTmp[3]; 
                            } catch(e) {
                            }
				        } else if ( tpvTmp[0]=="S" ) { // staff 
                            parent.document.all.s_vndr_cust_div_cd.value = tpvTmp[0]; 
                            parent.document.all.s_trd_party_val.value = tpvTmp[2]; 
                            parent.document.all.s_cust_cnt_cd.value = '';
                            parent.document.all.s_cust_seq.value = '';
                            parent.document.all.s_vndr_cnt_cd.value = '';
                            parent.document.all.s_vndr_seq.value = '';
                            parent.document.all.s_n3pty_ofc_cd.value = tpvTmp[2]; 
                            try { parent.document.all.s_trd_party_nm.value = tpvTmp[2]; 
                            } catch(e) {
                            } // tpvTmp[3];
                        }
				    } else {
                        parent.document.all.s_trd_party_val.value = ''; 
                        try { parent.document.all.s_trd_party_nm.value = ''; 
                        } catch(e) {
                        } 
                        
                        parent.document.all.s_cust_cnt_cd.value = '';
                        parent.document.all.s_cust_seq.value = '';
                        parent.document.all.s_vndr_cnt_cd.value = '';
                        parent.document.all.s_vndr_seq.value = '';
                        parent.document.all.s_n3pty_ofc_cd.value = '';
                        
                        if ( tpvTmp[0]=="V" ) { // vendor 
                        	ComShowCodeMessage('COM12114',"the S/P(Service Provider) Value! \nIt is a wrong value or doesn't have a Pseudo Customer Code \n(A pseudo customer will be registered using MDM System.)");
                        } else if ( tpvTmp[0]=="C" ) { // customer 
                        	ComShowCodeMessage('COM12114',"the Customer Value! \nIt is a wrong value or isn't a Container Customer Code.");
                        } else if ( tpvTmp[0]=="S" ) { // staff 
                        	ComShowCodeMessage( 'COM12114',"the Staff(Office) value!");
                        } else {
                        	ComShowCodeMessage( 'COM12114',"the 3rd Party value!!");// + "\n\n e.g. 1234" );
                        }
                        parent.document.all.s_trd_party_val.focus();
				    }
				} else {
                    parent.document.all.s_trd_party_val.value = ''; 
                    try { 
                    	parent.document.all.s_trd_party_nm.value = '';  
                    } catch(e) {
                    } 
                    
                    parent.document.all.s_cust_cnt_cd.value = '';
                    parent.document.all.s_cust_seq.value = '';
                    parent.document.all.s_vndr_cnt_cd.value = '';
                    parent.document.all.s_vndr_seq.value = '';
                    parent.document.all.s_n3pty_ofc_cd.value = '';

                    var s_vndr_cust_div_cd = parent.document.all.s_vndr_cust_div_cd.value;
                    if ( s_vndr_cust_div_cd==undefined || s_vndr_cust_div_cd==null ) {
                        s_vndr_cust_div_cd = "";
                    }
                    if ( s_vndr_cust_div_cd=="V" ) { // vendor 
                        ComShowCodeMessage('COM12114',"the S/P(Service Provider) Value! \nIt is a wrong value or doesn't have a Pseudo Customer Code \n(A pseudo customer will be registered using MDM System.)");
                    } else if ( s_vndr_cust_div_cd=="C" ) { // customer 
                        ComShowCodeMessage('COM12114',"the Customer Value! \nIt is a wrong value or isn't a Container Customer Code.");
                    } else if ( s_vndr_cust_div_cd=="S" ) { // staff 
                        ComShowCodeMessage('COM12114',"the Staff(Office) value!");
                    } else {
                    	ComShowCodeMessage('COM12114',"the 3rd Party value!!");// + "\n\n e.g. 1234" );
                    }
                    parent.document.all.s_trd_party_val.focus();
			    }
            } else if ( IdObj=="Void_ThirdParty_Sheet") { // 3rd Party Input directly in a Sheet 

		        var row = -1;
		        if ( otherObjs!=undefined && otherObjs!=null && otherObjs.length>0 ) {
		            row = otherObjs;
		        } 
				if(codeArr.length > 0) {
				    var tpvTmp = codeArr[0][0];  // ComShowMessage( tpvTmp );
				    tpvTmp = tpvTmp.split("|$|");  // ComShowMessage(tpvTmp.length);
				    if ( tpvTmp.length == 5 
				         && ( tpvTmp[0]=="V" || tpvTmp[0]=="C" || tpvTmp[0]=="S" ) 
				         && row > 0 ) {
				        
				        if ( tpvTmp[0]=="V" ) { // vendor
                        	parent.sheetObjects[0].CellValue2(row, 'vndr_cust_div_cd') = tpvTmp[0];
                        	parent.sheetObjects[0].CellValue2(row, 'trd_party_val') = tpvTmp[1];
                        	parent.sheetObjects[0].CellValue2(row, 'cust_cnt_cd') = '';
                        	parent.sheetObjects[0].CellValue2(row, 'cust_seq') = '';
                        	parent.sheetObjects[0].CellValue2(row, 'vndr_cnt_cd') = tpvTmp[2];
                        	parent.sheetObjects[0].CellValue2(row, 'vndr_seq') = tpvTmp[1];
                        	parent.sheetObjects[0].CellValue2(row, 'n3pty_ofc_cd') = '';
				        } else if ( tpvTmp[0]=="C" ) { // customer 
                        	parent.sheetObjects[0].CellValue2(row, 'vndr_cust_div_cd') = tpvTmp[0];
                        	parent.sheetObjects[0].CellValue2(row, 'trd_party_val') = tpvTmp[2] + tpvTmp[1]; 
                        	parent.sheetObjects[0].CellValue2(row, 'cust_cnt_cd') = tpvTmp[2];
                        	parent.sheetObjects[0].CellValue2(row, 'cust_seq') = tpvTmp[1];
                        	parent.sheetObjects[0].CellValue2(row, 'vndr_cnt_cd') = '';
                        	parent.sheetObjects[0].CellValue2(row, 'vndr_seq') = '';
                        	parent.sheetObjects[0].CellValue2(row, 'n3pty_ofc_cd') = '';
				        } else if ( tpvTmp[0]=="S" ) { // staff 
                        	parent.sheetObjects[0].CellValue2(row, 'vndr_cust_div_cd') = tpvTmp[0];
                        	parent.sheetObjects[0].CellValue2(row, 'trd_party_val') = tpvTmp[2]; 
                        	parent.sheetObjects[0].CellValue2(row, 'cust_cnt_cd') = '';
                        	parent.sheetObjects[0].CellValue2(row, 'cust_seq') = '';
                        	parent.sheetObjects[0].CellValue2(row, 'vndr_cnt_cd') = '';
                        	parent.sheetObjects[0].CellValue2(row, 'vndr_seq') = '';
                        	parent.sheetObjects[0].CellValue2(row, 'n3pty_ofc_cd') = tpvTmp[2];
				        }
                    	parent.sheetObjects[0].CellEditable(row, "cfm_flg_y") = true;
                    	parent.sheetObjects[0].CellValue2(row, "cfm_flg_y") = "0";
				    } else {
                    	parent.sheetObjects[0].CellValue2(row, 'trd_party_val') = ''; 
                    	parent.sheetObjects[0].CellValue2(row, 'cust_cnt_cd') = '';
                    	parent.sheetObjects[0].CellValue2(row, 'cust_seq') = '';
                    	parent.sheetObjects[0].CellValue2(row, 'vndr_cnt_cd') = '';
                    	parent.sheetObjects[0].CellValue2(row, 'vndr_seq') = '';
                    	parent.sheetObjects[0].CellValue2(row, 'n3pty_ofc_cd') = '';

                    	var s_vndr_cust_div_cd = tpvTmp[0];
                        if ( s_vndr_cust_div_cd==undefined || s_vndr_cust_div_cd==null ) {
                            s_vndr_cust_div_cd = "";
                        }
                        if ( s_vndr_cust_div_cd=="V" ) { // vendor 
                            ComShowCodeMessage('COM12114',"the S/P(Service Provider) Value! \nIt is a wrong value or doesn't have a Pseudo Customer Code \n(A pseudo customer will be registered using MDM System.)");
                        } else if ( s_vndr_cust_div_cd=="C" ) { // customer 
                            ComShowCodeMessage('COM12114',"the Customer Value! \nIt is a wrong value or isn't a Container Customer Code.");
                        } else if ( s_vndr_cust_div_cd=="S" ) { // staff 
                            ComShowCodeMessage('COM12114',"the Staff(Office) value!");
                        } else {
                        	ComShowCodeMessage('COM12114',"the 3rd Party value!!");// + "\n\n e.g. 1234" );
                        }
                    	parent.sheetObjects[0].CellEditable(row, "cfm_flg_y") = false;
                    	parent.sheetObjects[0].CellValue2(row, "cfm_flg_y") = "0";
				    }
				} else {
                	parent.sheetObjects[0].CellValue2(row, 'trd_party_val') = ''; 
                	parent.sheetObjects[0].CellValue2(row, 'cust_cnt_cd') = '';
                	parent.sheetObjects[0].CellValue2(row, 'cust_seq') = '';
                	parent.sheetObjects[0].CellValue2(row, 'vndr_cnt_cd') = '';
                	parent.sheetObjects[0].CellValue2(row, 'vndr_seq') = '';
                	parent.sheetObjects[0].CellValue2(row, 'n3pty_ofc_cd') = '';

                    var s_vndr_cust_div_cd = ComTrim(parent.sheetObjects[0].CellValue(row, 'vndr_cust_div_cd'));
                    if ( s_vndr_cust_div_cd==undefined || s_vndr_cust_div_cd==null ) {
                        s_vndr_cust_div_cd = "";
                    }
                    if ( s_vndr_cust_div_cd=="V" ) { // vendor 
                        ComShowCodeMessage('COM12114',"the S/P(Service Provider) Value! \nIt is a wrong value or doesn't have a Pseudo Customer Code \n(A pseudo customer will be registered using MDM System.)");
                    } else if ( s_vndr_cust_div_cd=="C" ) { // customer 
                        ComShowCodeMessage('COM12114',"the Customer Value! \nIt is a wrong value or isn't a Container Customer Code.");
                    } else if ( s_vndr_cust_div_cd=="S" ) { // staff 
                        ComShowCodeMessage('COM12114',"the Staff(Office) value!");
                    } else {
                    	ComShowCodeMessage('COM12114',"the 3rd Party value!!");// + "\n\n e.g. 1234" );
                    }
                	parent.sheetObjects[0].CellEditable(row, "cfm_flg_y") = false;
                	parent.sheetObjects[0].CellValue2(row, "cfm_flg_y") = "0";
			    }
            }
			
			try{
				if( ComTrim( parent.sheetObjects[0].CellValue(row, 'trd_party_val') ) != '') {
					if( ComTrim(parent.sheetObjects[0].CellValue(row, 'vndr_cust_div_cd') ) != "") {
						parent.sheetObjects[0].CellEditable(row, "cfm_flg_y") = true;
					}
					if(parent.sheetObjects[0].CellValue(row, 'curr_cd') == "" || parseFloat(parent.sheetObjects[0].CellValue(row, 'cfm_amt')) == 0) {
						parent.sheetObjects[0].CellEditable(row, "cfm_flg_y") = false;
						parent.sheetObjects[0].CellValue2(row, "cfm_flg_y") = "0";
					}
				} else {
					parent.sheetObjects[0].CellEditable(row, "cfm_flg_y") = false;
					parent.sheetObjects[0].CellValue2(row, "cfm_flg_y") = "0";
					parent.sheetObjects[0].CellValue2(row, "trd_party_val") = "";
				}
			}catch (e){
			}
		}
	}
}

/**
 * 콤보 option 만드는 함수
 *
 * @param : obj - select object
 * @param : pText  - text
 * @param : pValue - value
 *
 */
function ComAddComboItem(obj, pText, pValue )
{
	if(obj != null )
	{ 
		var optionItem   = document.createElement("option");
		optionItem.text  = pText;
		optionItem.value = pValue;
		 
		obj.add(optionItem);
	}
}

/**
 * HTML Form 입력값의 길이 체크하는 함수
 *
 * @param : lenArr - 2차원 Array 객체 (form객체명, form element 이름, maxlength속성,[최소길이])
 * var lenArr = new Array();
 * lenArr[0] = new Array(bkg_no_all,'BKG No',bkg_no_all.getAttribute("maxlength"),11);
 */
function checkFormLength(lenArr) {
	 
	for(var i=0;i<lenArr.length;i++) {
		if(lenArr[i][0].value != '') {
			if(lenArr[i][3] != null) {
				if(ComGetLenByByte(lenArr[i][0].value) < lenArr[i][3]  ) {
					ComShowCodeMessage('COM12175',lenArr[i][1],lenArr[i][3],lenArr[i][2]);
					lenArr[i][0].focus();
					return false;
				}
			} else {
				if(ComGetLenByByte(lenArr[i][0].value) != lenArr[i][2]  ) {
					ComShowCodeMessage('COM12174',lenArr[i][1],lenArr[i][2],'');
					lenArr[i][0].focus();
					return false;
				}
			}
		}
	}
	return true;
}

/**
 * HTML Form 에서 BKG No.을 입력하면 BL No.를 구하는 함수
 *
 * @param : frm - HTML Form객체
 * @param : obj - 이벤트를 호출하는 객체
 * @param : prefix - Form element 명 앞에 추가할 문자
 */
function getBLNo(frm,obj,prefix) {
	if(obj.value != '') {
		if(prefix == undefined || prefix == null) prefix = '';

		//eval('frm.'+prefix+'bkg_no').value       = obj.value.substring(0,11);
		eval('frm.'+prefix+'bkg_no').value       = obj.value;
		//eval('frm.'+prefix+'bkg_no_split').value = obj.value.substring(11);
		eval('frm.'+prefix+'bl_no_all').value = '';
		//getTPBGenCombo(prefix+'bl_no_all','checkBLNo','T','','',new Array(prefix+"bkg_no",prefix+"bkg_no_split"));
		getTPBGenCombo(prefix+'bl_no_all','checkBLNo','T','','',new Array(prefix+"bkg_no"));
	}
}

/**
 * HTML Form 에서 Office를 입력하면 TPB Office를 구하는 함수
 *
 * @param : frm - HTML Form객체
 * @param : obj - 이벤트를 호출하는 객체
 * @param : prefix - Form element 명 앞에 추가할 문자
 */
function getTPBOffice(frm,obj) {
	if(obj.value != '') {
		getTPBGenCombo("s_if_ofc_cd",'checkTPBOffice','T','','',new Array("s_if_ofc_cd"));
	}
}

/**
 * HTML Form 에서 Office를 입력하면 TPB Office를 구하는 함수
 *
 * @param : frm - HTML Form객체
 * @param : obj - 이벤트를 호출하는 객체
 * @param : prefix - Form element 명 앞에 추가할 문자
 */
function checkROCToOffice(frm,obj) {
	if(obj.value != '') {
		getTPBGenCombo("stl_to_clt_cng_ofc_cd",'checkTPBOffice','T','','',new Array("stl_to_clt_cng_ofc_cd"));
	}
}

/**
 * Collection Activity 팝업을 띄우는 함수
 *
 * @param : pN3pty_no - n3pty_no
 * @param : pN3pty_inv_no - n3pty_inv_no
 * @param : pFrom_N3pty_no - From n3pty_no (in case from R.O.C.)
 */
function openCollectionActPopup(pN3pty_no, pN3pty_inv_no, pFrom_N3pty_no, pIsReadOnly) {
	var theURL = "ESD_TPB_0911.do?n3pty_no="+pN3pty_no+"&n3pty_inv_no="+pN3pty_inv_no+"&is_read_only="+pIsReadOnly;
	if ( pFrom_N3pty_no!=null && ComTrim(pFrom_N3pty_no).length>0 ) {
	    theURL += "&from_n3pty_no="+pFrom_N3pty_no; 
	}
	var winName = "ESD_TPB_0911";
	var features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=755,height=460";
	openWindow(theURL,winName,features);
}

/**
 * Invoice Sheet Set 팝업을 띄우는 함수
 *
 * @param : pN3pty_no - n3pty_no
 * @param : pN3pty_inv_no - n3pty_inv_no
 */
function openInvoiceSheetSetPopup(formObject, pReadOnlyYn, pOfcCd) {
	var theURL = "ESD_TPB_0912.do?f_cmd="+SEARCH;
	if ( pReadOnlyYn!=null && pReadOnlyYn!=undefined && pReadOnlyYn=="N" ) {
		theURL += '&ReadOnlyYn='+pReadOnlyYn;
	}
	if ( pOfcCd!=null && pOfcCd!=undefined && pOfcCd!="" ) {
		theURL += '&s_sheet_set_ofc_cd='+pOfcCd;
	}
    // ComShowMessage( theURL );
	var features = "scroll:no;status:no;help:no;dialogWidth:610px;dialogHeight:555px";

	var rtnValue = window.showModalDialog(theURL, window, features);

	if(rtnValue != undefined && rtnValue != null && rtnValue.length > 0) {
		if(formObject.s_sheet_set_count != undefined) {
			formObject.s_sheet_set_count.value = 1;
		}
		formObject.s_bil_loc.value = rtnValue[0];

		formObject.s_vat_xch_rt.value = rtnValue[1];
	}
}

/**
 * vndr_cust_div_cd 값에 따라 3rd Party를 조회하는 함수
 *
 * @param : val - vndr_cust_div_cd
 */
function get3rdParty(val) {
	var strTrd_party = val;

	if(strTrd_party=='C') {
		ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 420, 'getCustomer', '1,0,1,1,1,1,1,1');
	} else if(strTrd_party=='S') {
		open3rdPartyPopup(val);
	} else if(strTrd_party=='V') {
		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 410, 'getVendor', '1,0,1,1,1,1,1,1');
	} else if(strTrd_party=='SP') {
		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 410, 'getVendor_SP', '1,0,1,1,1,1,1,1');
	} else {
	    //ComShowCodeMessage('TPB90015');
	    //ComShowCodeMessage('TPB90015')
	    ComShowCodeMessage("COM12113" , "a kind of 3rd Party.");
	    //try { document.getElementById("s_vndr_cust_div_cd").focus(); } catch(e) { ComShowMessage(e); } /// set focus
	    try { document.getElementById("s_vndr_cust_div_cd").focus(); } catch(e) { ComShowMessage(e); } /// set focus
	}
}

/**
 * 3rd Party Staff 팝업창을 여는 함수
 */
function open3rdPartyPopup(val) {
	var theURL = "ESD_TPB_0813.do?title=Select Staff";
    //ComShowMessage( theURL );
	var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:510px";

	var rtnValue = window.showModalDialog(theURL, window, features);
	if(rtnValue != undefined && rtnValue != null ) {
    	document.all.s_trd_party_val.value = rtnValue;
    	if(document.all.s_trd_party_nm != null) {
    		document.all.s_trd_party_nm.value = rtnValue;
    	}	
    	s_trd_party_val_OnBlur('S', true);	
	}
	
}

/**
 * vndr_cust_div_cd 값에 따라 3rd Party를 조회하는 함수
 * sheet에서 호출시 사용
 *
 * @param : val - vndr_cust_div_cd
 */
function get3rdParty_sheet(val, Row, Col, sheetObj) {
	var strTrd_party = val;

	if(strTrd_party=='C') {
		ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, 'getCustomer_sheet', '1,0,1,1,1,1,1,1',Row,Col);
	} else if(strTrd_party=='S') {
		// ComOpenPopup('/hanjin/COM_ENS_091.do', 770, 600, 'getStaff_sheet', '1,0,1,1,1,1,1,1',Row,Col, false, true);
		open3rdPartyPopup_sheet(val, Row, Col, sheetObj);
	} else if(strTrd_party=='V') {
		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 620, 450, 'getVendor_sheet', '1,0,1,1,1,1,1,1',Row,Col);
	} else {
		ComShowCodeMessage('TPB90015'); 
	    try { sheetObj.SelectCell(Row, "vndr_cust_div_cd"); } catch(e) { ComShowMessage(e); } /// set focus		
	}
}

/**
 * 3rd Party Staff 팝업창을 여는 함수
 * sheet에서 호출시 사용
 */
function open3rdPartyPopup_sheet(val, row, col, sheetObj) {
	var theURL = "ESD_TPB_0813.do?title=Select Staff";
    // ComShowMessage( theURL );
	var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:510px";

	var rtnValue = window.showModalDialog(theURL, window, features);

	if(rtnValue != undefined && rtnValue != null ) {
		// document.form.stl_to_clt_cng_ofc_cd.value = rtnValue;
    	sheetObj.CellValue2(row, col) = rtnValue;
    	sheetObj.CellValue2(row, 'n3pty_ofc_cd') = rtnValue;
    	sheetObj.CellValue2(row, 'cust_cnt_cd') = '';
    	sheetObj.CellValue2(row, 'cust_seq') = '';
    	sheetObj.CellValue2(row, 'vndr_cnt_cd') = '';
    	sheetObj.CellValue2(row, 'vndr_seq') = '';
    
        document.all.s_trd_party_val.value = rtnValue;
        document.all.s_vndr_cust_div_cd.value = "S";
    	getThirdParySheetAfter(sheetObj, row);
		
	}
}

/**
 * 검색으로 쓰이는 vndr_cust_div_cd 값에 따라 3rd Party를 조회하는 함수 
 *
 * @param : val - vndr_cust_div_cd
 */
function get3rdPartyToSearch(val) {
	var strTrd_party = val;

	if(strTrd_party=='C') {
		ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, 'getCustomerToSearch', '1,0,1,1,1,1,1,1');
	} else if(strTrd_party=='S') {
		// comPopupWith2ndSheet('/hanjin/COM_ENS_091.do', 770, 550, 'getStaffToSearch', '1,0,1,1,1,1,1,1');
		open3rdPartyPopupToSearch(val);
	} else if(strTrd_party=='V') {
		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 690, 450, 'getVendorToSearch', '1,0,1,1,1,1,1,1');
//	} else if(strTrd_party=='SP') {
//		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 690, 450, 'getVendor_SP', '1,0,1,1,1,1,1,1');
	} else {
		ComShowCodeMessage('TPB90015'); 
	    try { document.getElementById("s_vndr_cust_div_cd").focus(); } catch(e) { ComShowMessage(e); } /// set focus
	}
}

/**
 * 검색용 3rd Party Staff 팝업창을 여는 함수
 */
function open3rdPartyPopupToSearch(val) {
	var theURL = "ESD_TPB_0813.do?title=Select Staff";
    // ComShowMessage( theURL );
	var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:510px";

	var rtnValue = window.showModalDialog(theURL, window, features);

	if(rtnValue != undefined && rtnValue != null ) {
        document.all.s_trd_party_val.value = rtnValue;
	}
}

///**
// * vndr_cust_div_cd 값에 따라 3rd Party를 조회하는 함수
// * Adjustment UI에서 사용
// *
// * @param : val - vndr_cust_div_cd
// */
//function get3rdPartyStl(val) {
//	var strTrd_party = val;
//
//	if(strTrd_party=='C') {
//		comPopup('/hanjin/COM_ENS_041.do', 770, 470, 'getCustomerStl', '1,0,1,1,1,1,1,1');
//	} else if(strTrd_party=='S') {
//		comPopupWith2ndSheet('/hanjin/COM_ENS_091.do', 770, 550, 'getStaffStl', '1,0,1,1,1,1,1,1');
//	} else if(strTrd_party=='V') {
//		comPopup('/hanjin/COM_ENS_0C1.do', 620, 450, 'getVendorStl', '1,0,1,1,1,1,1,1');
//	} else {
//	    ComShowCodeMessage('TPB90015' ); 
//	    try { document.getElementById("s_vndr_cust_div_cd").focus(); } catch(e) { ComShowMessage(e); } /// set focus
//	}
//}

/**
 * VVD popup close시 호출되는 함수
 *
 */
function getVVD(rArray) {
	var cArray = rArray[0];
	document.all.s_vvd.value = cArray[7];
	document.all.s_vvd.focus();
}

/**
 * Location popup close시 호출되는 함수
 *
 */
function getLocation(rArray) {
	var cArray = rArray[0];
	document.all.s_yd_cd.value = cArray[3];
}

/**
 * 3rd Party Customer popup close시 호출되는 함수
 */
function getCustomer(rArray) {
	var cArray = rArray[0];
	document.all.s_trd_party_val.value = cArray[3];
	if(document.all.s_trd_party_nm != null) {
		document.all.s_trd_party_nm.value = cArray[4];
	}
	s_trd_party_val_OnBlur('C', true);
}

/**
 * 3rd Party Staff popup close시 호출되는 함수
 *
 */
function getStaff(rArray) {
    // var z="";  for(var i=0; rArray!=null && i<rArray.length; i++) { z+= i + " : " + rArray[i] + "\n";}  ComShowMessage(z);
	var cArray = rArray[0];
	document.all.s_trd_party_val.value = cArray[3];
	if(document.all.s_trd_party_nm != null) {
		document.all.s_trd_party_nm.value = cArray[3];
	}	
	s_trd_party_val_OnBlur('S', true);
}

/**
 * 3rd Party Vendor popup close시 호출되는 함수
 *
 */
function getVendor(rArray) {
	var cArray = rArray[0];
	document.all.s_trd_party_val.value = cArray[7]+cArray[2];
	if(document.all.s_trd_party_nm != null) {
		document.all.s_trd_party_nm.value = cArray[4];
	}
	s_trd_party_val_OnBlur('V', true);
}

/**
 * 3rd Party Customer popup close시 호출되는 함수
 */
function getCustomerToSearch(rArray) {
	var cArray = rArray[0];
	document.all.s_trd_party_val.value = cArray[3];
	// s_trd_party_val_OnBlur('C', true);
}

/**
 * 3rd Party Staff popup close시 호출되는 함수
 *
 */
function getStaffToSearch(rArray) {
	var cArray = rArray[0];
	document.all.s_trd_party_val.value = cArray[3];
	// s_trd_party_val_OnBlur('S', true);
}

/**
 * 3rd Party Vendor popup close시 호출되는 함수
 *
 */
function getVendorToSearch(rArray) {
	try{
        var cArray = rArray[0];
	    var temp = cArray[2];
	    var tmp1 = temp;
	    var tmp2 = "";
	    for(var k=0; k<temp.length; k++) {
	        tmp2 = tmp1.substring(0,1);
	        if ( tmp2=="0" ) {
	            tmp1 = tmp1.substring(1);
	        } else {
	            temp = tmp1;
	            break; 
	        }
	    }
		document.all.s_trd_party_val.value = temp;
	} catch(e) {
	    // ComShowMessage(e);
	}
	// s_trd_party_val_OnBlur('V', true);
}


/**
 * 3rd Party Vendor popup close시 호출되는 함수, Service Provider
 *
 */
function getVendor_SP(rArray) {
	var cArray = rArray[0];
	document.all.s_src_vndr_no.value = cArray[2];
	document.all.s_src_vndr_cnt_cd.value = cArray[7];
}

 
/**
* @param     : str => String
*		: icount => 전체 문자 갯수
* sample	: getZero("123",5);
* @return 	: String
* 설명		: 전체 문자 만큼 앞에 0을 채워준다
**/
function getZero(str,icount)
{
	var slength = (""+str).length;
	var s="";
	for (i=0 ; i < icount - slength ; i++)
	{
		s = s + "0";
	}
	return s + str;
}


 /**
  * 해당 날짜의 단위 덧셈연산하여 그 결과 날짜를 문자열로 반환
  * 예)  getDateStrAdd(null, "D", -6, "-") : "2006-09-17" 
  * @param date   대상 날짜 date개체; null이면 현재 일시 기준
  * @param unit   문자; 연산할 단위 Y:년도, M:월, D:일 
  * @param val    연산할 값    
  * @param delm   결과시 사용할 날짜구분자 
  * @return 날짜 문자열
 */
function getDateStrAdd(date, unit, val, delm){
	date = new Date();

	if ( delm==null || delm==undefined ) {
		delm = "";
	}

	var y = date.getYear();
	var m = date.getMonth();
	var d = date.getDate();

	if ( unit=="Y" ) { y+= val; }
	if ( unit=="M" ) { m+= val; }
	if ( unit=="D" ) { d+= val; }
	
	date = new Date(y,m,d);
	
	y = date.getYear();
	m = date.getMonth() + 1;
	d = date.getDate();

	return y + delm + getZero(m,2) + delm + getZero(d,2);
}
 
///**
// * 3rd Party Customer popup close시 호출되는 함수
// * Adjustment UI에서 사용
// */
//function getCustomerStl(rArray) {
//	var cArray = rArray[0];
//	document.all.s_trd_party_val.value = cArray[3];
//}
///**
// * 3rd Party Staff popup close시 호출되는 함수
// * Adjustment UI에서 사용
// */
//function getStaffStl(rArray) {
//	var cArray = rArray[0];
//	document.all.s_trd_party_val.value = cArray[3];
//}
///**
// * 3rd Party Vendor popup close시 호출되는 함수
// * Adjustment UI에서 사용
// */
//function getVendorStl(rArray) {
//	var cArray = rArray[0];
//	document.all.s_trd_party_val.value = cArray[7]+cArray[2];
//}


/**
 * 3rd Party input box 에서 OnFocus시 호출하는 함수
 */
function s_trd_party_val_OnFocus() {
	var divCd = document.all.s_vndr_cust_div_cd.value;

	if( divCd!='C' && divCd!="V" && divCd!="S") {
		ComShowCodeMessage('TPB90015') ; 
	    try { document.getElementById("s_vndr_cust_div_cd").focus(); } catch(e) {  } /// set focus
	}
}

/**
 * 3rd Party input box 에서 OnBlur 또는 해당하는 경우에 호출하는 함수
 *
 * @param divCd   s_vndr_cust_div_cd (Vendor/Customer/Staff) 
 * @param fromPopupYn   boolean 팝업호출하여 값을 얻는지 여부 
 */
function s_trd_party_val_OnBlur(divCd, fromPopupYn) {
	if(divCd == undefined) {
		divCd = document.all.s_vndr_cust_div_cd.value;
	}
	if(fromPopupYn == undefined) {
		fromPopupYn = false;
	}
	
	if ( fromPopupYn ) { // from Popup
        
    	if(divCd == 'V') {
    		if(document.all.s_trd_party_val.value.length > 6) {
    			document.all.s_vndr_cnt_cd.value  = document.all.s_trd_party_val.value.substring(0,2);
    			document.all.s_vndr_seq.value	  = document.all.s_trd_party_val.value.substring(2);
    			try{
    			    var temp = document.all.s_trd_party_val.value.substring(2);
    			    var tmp1 = temp;
    			    var tmp2 = "";
    			    for(var k=0; k<temp.length; k++) {
    			        tmp2 = tmp1.substring(0,1);
    			        if ( tmp2=="0" ) {
    			            tmp1 = tmp1.substring(1);
    			        } else {
    			            temp = tmp1;
    			            break; 
    			        }
    			    }
          			document.all.s_vndr_seq.value = temp;
          			document.all.s_trd_party_val.value = temp;
    			} catch(e) {
    			    // ComShowMessage(e);
    			}
    		} else {
                document.all.s_vndr_seq.value	   = document.all.s_trd_party_val.value;
    		}
    		document.all.s_cust_cnt_cd.value  = '';
    		document.all.s_cust_seq.value	   = '';	
    		document.all.s_n3pty_ofc_cd.value	   = '';
    	} else if(divCd == 'C') {
    		document.all.s_cust_cnt_cd.value  = document.all.s_trd_party_val.value.substring(0,2);
    		document.all.s_cust_seq.value	   = document.all.s_trd_party_val.value.substring(2);					
    		document.all.s_n3pty_ofc_cd.value	   = '';
    		document.all.s_vndr_cnt_cd.value  = '';
    		document.all.s_vndr_seq.value	   = '';
    	} else if(divCd == 'S') {
    		document.all.s_n3pty_ofc_cd.value	   = document.all.s_trd_party_val.value;
    		document.all.s_cust_cnt_cd.value  = '';
    		document.all.s_cust_seq.value	   = '';
    		document.all.s_vndr_cnt_cd.value  = '';
    		document.all.s_vndr_seq.value	   = '';
    	}

        document.all.s_vndr_cust_div_cd.value = divCd; 

    	if(document.all.s_trd_party_nm != null && document.all.s_trd_party_val.value == "") {
    		document.all.s_trd_party_nm.value = "";
    	}

        if ( divCd=="V" || divCd=="C" || divCd=="S" ) { // Added in 2008-03-06 
            if ( s_trd_party_val_OnBlur_ToSearch() ) {
              // server side로부터 가져와서 getTPBGenCombo 함수이하에서 직접 처리함 
              getTPBGenCombo('Void_ThirdParty','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd")); 
            }
        } 

	} else { // from Direct Input
		
	    var tpbVal = document.all.s_trd_party_val.value; 
	    tpbVal = ComTrim(tpbVal);
	    document.all.s_trd_party_val.value = tpbVal;
	    
	    if ( tpbVal.length==0 ) { // 3rd party value가 없으면 
	    
    		document.all.s_trd_party_val.value = '';
    		try {
    			document.all.s_trd_party_nm.value = ''; 
    		} catch(e) {
    			
    		}

    		document.all.s_cust_cnt_cd.value = '';
    		document.all.s_cust_seq.value = '';
    		document.all.s_vndr_cnt_cd.value = '';
    		document.all.s_vndr_seq.value = '';
    		document.all.s_n3pty_ofc_cd.value = '';
    		
	    } else { // 있을 경우 유효성 체크 
            if ( divCd=="V" || divCd=="C" || divCd=="S" ) {
              if ( s_trd_party_val_OnBlur_ToSearch() ) {
                  // server side로부터 가져와서 getTPBGenCombo 함수이하에서 직접 처리함 
                  getTPBGenCombo('Void_ThirdParty','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd")); 
              }
            } 

	    }

	}
	
}

/**
 * 검색용 3rd Party input box 에서 OnBlur 또는 해당하는 경우에 호출하는 함수
 *
 * @param divCd   s_vndr_cust_div_cd (Vendor/Customer/Staff) 
 */
function s_trd_party_val_OnBlur_ToSearch() {
	var divCd = document.all.s_vndr_cust_div_cd.value;
    var tpbVal = document.all.s_trd_party_val.value;  // ComShowMessage(tpbVal);
    tpbVal = ComTrim(tpbVal); // ComShowMessage(tpbVal);
    document.all.s_trd_party_val.value = tpbVal;
    
    if ( divCd=="V") {
        // vendor sequence 
        if ( !ComIsNumber(tpbVal) && tpbVal.length > 0 ) {
        	ComShowCodeMessage('COM12114',"the 3rd Party format!!! \n\n e.g. 1234" );
            document.all.s_trd_party_val.focus();
            document.all.s_trd_party_val.select();
            return false;
        }
        
    } else if ( divCd=="C") {
        
        if ( tpbVal.length > 0) {
            
           var temp; 

            // country code
            if ( tpbVal.length<=2) {
                temp = tpbVal.substring(0);
            } else {
                temp = tpbVal.substring(0,2);
            }
            if ( temp.length!=2 || !ComIsAlphabet(temp) ) {
            	ComShowCodeMessage('COM12114',"the 3rd Party format!!! \n\n e.g. KR1234"  );
                document.all.s_trd_party_val.focus();
                document.all.s_trd_party_val.select();
                return false;
            }
            
            // customer sequence 
            if ( tpbVal.length > 2) {
                temp = tpbVal.substring(2);
                if ( !ComIsNumber(temp) ) {
                	ComShowCodeMessage('COM12114',"the 3rd Party format!!! \n\n e.g. KR1234"  );
                    document.all.s_trd_party_val.focus();
                    document.all.s_trd_party_val.select();
                    return false;
                }
    
            } 
            
        } // tpbVal.length 
    } // divCd
    
    return true;
}

/**
 * 3rd Party 선택 콤보리스트에서 호출하는 함수
 * set focus
 */
function s_vndr_cust_div_cd_OnChange() {
	var formObj = document.form;
	formObj.s_trd_party_val.value = "";
	formObj.s_cust_cnt_cd.value  = "";
	formObj.s_cust_seq.value	   = "";
	formObj.s_vndr_cnt_cd.value  = "";
	formObj.s_vndr_seq.value	   = "";
	formObj.s_n3pty_ofc_cd.value = "";
	if(formObj.s_trd_party_nm != null) {
		formObj.s_trd_party_nm.value = "";
	}
	var divCd = formObj.s_vndr_cust_div_cd.value;

	if( divCd=="C" || divCd=="V" || divCd=="S") {
        try {
        	formObj.s_trd_party_val.focus();
        }
        catch(e) { 
        	ComShowMessage(e); 
        } 
	}
}

/**
 * 검색용 3rd Party 선택 콤보리스트에서 호출하는 함수
 *
 */
function s_vndr_cust_div_cd_OnChange_ToSearch() {
	var formObj = document.form;
	formObj.s_trd_party_val.value = '';
	
	var divCd = document.all.s_vndr_cust_div_cd.value;
	
	if( divCd=="C" || divCd=="V" || divCd=="S") {
        try { document.getElementById("s_trd_party_val").focus(); } catch(e) { ComShowMessage(e); } /// set focus
	}
}

/**
 * 3rd Party Customer popup close시 호출되는 함수
 * Sheet에서 popup 호출하였을 경우
 */
function getCustomer_sheet(rArray, row, col) {
	var sheetObj = sheetObjects[0];
	
	var colArray = rArray[0];
	sheetObj.CellValue2(row, col) = colArray[3];
	sheetObj.CellValue2(row, 'cust_cnt_cd') = colArray[3].substring(0,2);
	sheetObj.CellValue2(row, 'cust_seq') = colArray[3].substring(2);

	sheetObj.CellValue2(row, 'n3pty_ofc_cd') = '';
	sheetObj.CellValue2(row, 'vndr_cnt_cd') = '';
	sheetObj.CellValue2(row, 'vndr_seq') = '';

	try {	
		document.all.s_trd_party_val.value = colArray[3];
		document.all.s_vndr_cust_div_cd.value = "C";
	} catch(e) {
		e = null;
	}
	
	getThirdParySheetAfter(sheetObj, row);
}

/**
 * 3rd Party Staff popup close시 호출되는 함수
 * Sheet에서 popup 호출하였을 경우
 */
function getStaff_sheet(rArray, row, col) {
	var sheetObj = sheetObjects[0];
	
	var colArray = rArray[0];
	sheetObj.CellValue2(row, col) = colArray[3];
	sheetObj.CellValue2(row, 'n3pty_ofc_cd') = colArray[3];

	sheetObj.CellValue2(row, 'cust_cnt_cd') = '';
	sheetObj.CellValue2(row, 'cust_seq') = '';
	sheetObj.CellValue2(row, 'vndr_cnt_cd') = '';
	sheetObj.CellValue2(row, 'vndr_seq') = '';

	try {	
		document.all.s_trd_party_val.value = colArray[3];
		document.all.s_vndr_cust_div_cd.value = "C";
	} catch(e) {
		e = null;
	}
	
	getThirdParySheetAfter(sheetObj, row);
}

/**
 * 3rd Party Vendor popup close시 호출되는 함수
 * Sheet에서 popup 호출하였을 경우
 */
function getVendor_sheet(rArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rArray[0];
	var tempVal = "";
	sheetObj.CellValue2(row, col) = colArray[2];
	//sheetObj.CellValue2(row, 'vndr_cnt_cd') = colArray[2].substring(0,2);
	sheetObj.CellValue2(row, 'vndr_cnt_cd') = colArray[7]; // ComShowMessage(colArray[7]);
	sheetObj.CellValue2(row, 'vndr_seq') = colArray[2];
	try{
	    var temp = colArray[2];
	    var tmp1 = temp;
	    var tmp2 = "";
	    for(var k=0; k<temp.length; k++) {
	        tmp2 = tmp1.substring(0,1);
	        if ( tmp2=="0" ) {
	            tmp1 = tmp1.substring(1);
	        } else {
	            temp = tmp1;
	            break; 
	        }
	    }
		sheetObj.CellValue2(row, 'vndr_seq') = temp;
		sheetObj.CellValue2(row, col) = temp;
		tempVal = temp;
	} catch(e) {
	    // ComShowMessage(e);
	}	

	sheetObj.CellValue2(row, 'n3pty_ofc_cd') = '';
	sheetObj.CellValue2(row, 'cust_cnt_cd') = '';
	sheetObj.CellValue2(row, 'cust_seq') = '';

	try {	
		document.all.s_trd_party_val.value = tempVal;
		document.all.s_vndr_cust_div_cd.value = "V";
	} catch(e) {
		e = null;
	}
	
	getThirdParySheetAfter(sheetObj, row);
}

/**
 * 3rd Party popup 호출 후 처리 
 */
function getThirdParySheetAfter(sheetObj, Row) {
    try { 
    	if( ComTrim( sheetObj.CellValue(Row, 'trd_party_val') ) != '') {
    		if( ComTrim(sheetObj.CellValue(Row, 'vndr_cust_div_cd') ) != "") {
    			sheetObj.CellEditable(Row, "cfm_flg_y") = true;
                getTPBGenCombo('Void_ThirdParty_Sheet','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd"), Row); // Added In 2008-03-07
    		}
    		if(sheetObj.CellValue(Row, 'curr_cd') == "" || parseFloat(sheetObj.CellValue(Row, 'cfm_amt')) == 0) {
    			sheetObj.CellEditable(Row, "cfm_flg_y") = false;
    			sheetObj.CellValue2(Row, "cfm_flg_y") = "0";
    		}
    	} else {
    		sheetObj.CellEditable(Row, "cfm_flg_y") = false;
    		sheetObj.CellValue2(Row, "cfm_flg_y") = "0";
    		sheetObj.CellValue2(Row, "trd_party_val") = "";
    	}
    } catch(e) {
        // ComShowMessage(e.toString());
    }
}

/**
 * 3rd Party VVD popup close시 호출되는 함수
 * Sheet에서 popup 호출하였을 경우
 */
function getVVD_sheet(rArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rArray[0];
	sheetObj.CellValue2(row, col) = colArray[7];
}

//===== TPB FileUpload 관련 호출 ===============================================
/**
 * FileUpload 팝업을 띄우는 함수
 * @param : fileNo - fileNo
 * @param : targetFnc -  opener에서 fileNo값을 받을 대상
 */
function openFileUploadPopup(fileNo, targetFnc, downloadLink, authYn, tpbNo, invNo) {
	if ( FileUploadPopupWin!=null && FileUploadPopupWin!=undefined ) {
		try {
			FileUploadPopupWin.forcedClose = true; // 강제로 닫는다고 설정
			FileUploadPopupWin.close();
			FileUploadPopupWin = null;
		} catch(e) {
			
		}
	}
    
	var theURL = "TPBFileUpload.do?fileNo="+fileNo+"&f_cmd="+SEARCH+"&targetFnc="+targetFnc;
    if ( downloadLink!=null && downloadLink!=undefined ) { 
       theURL += "&downloadLink="+downloadLink;
    }
    if ( authYn!=null && authYn!=undefined ) { 
       theURL += "&authYn="+authYn;
    }
    if ( tpbNo!=null && tpbNo!=undefined ) { 
       theURL += "&tpbNo="+tpbNo;
    }
    if ( invNo!=null && invNo!=undefined ) { 
       theURL += "&invNo="+invNo;
    }
	var winName = "TPBFileUpload";
	var features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=314,height=400";
	FileUploadPopupWin = ComOpenWindow(theURL,winName,features);
	
}

/**
 * FileUpload 모달팝업을 띄우는 함수
 * @param : fileNo - fileNo
 * @param : targetFnc -  opener에서 fileNo값을 받을 대상
 */
function openFileUploadModalPopup(fileNo, targetFnc, downloadLink, authYn, tpbNo, invNo) {
    
	var theURL = "TPBFileUpload.do?fileNo="+fileNo+"&f_cmd="+SEARCH+"&targetFnc="+targetFnc;
    if ( downloadLink!=null && downloadLink!=undefined ) { 
       theURL += "&downloadLink="+downloadLink;
    }
    if ( authYn!=null && authYn!=undefined ) { 
       theURL += "&authYn="+authYn;
    }
    if ( tpbNo!=null && tpbNo!=undefined ) { 
       theURL += "&tpbNo="+tpbNo;
    }
    if ( invNo!=null && invNo!=undefined ) { 
       theURL += "&invNo="+invNo;
    }
    theURL += "&modalWindow=Y";
    
//	var winName = "TPBFileUpload";
	// var features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=314,height=400";
   	var features = "scroll:no;status:no;help:no;dialogWidth:320px;dialogHeight:430px";
	// FileUploadPopupWin = ComOpenWindow(theURL,winName,features);
   	//alert("theURL==>"+theURL);
   	//alert("window==>"+window);
   	//alert("features==>"+features);
   	var rtnValue = window.showModalDialog(theURL, window, features);
   	//alert("rtnValue===>"+rtnValue);
   	
   	return rtnValue;
}

/**
 * fileDownload 함수
 * @param : physicalFileNm - 물리 파일명(시스템)
 * @param : logicalFileNm - 논리 파일명(사용자)
 * @param : filePlace -  물리 파일저장 경로
 * @param : fileRepositoryId - // file-meta 정보  ID (설정파일의 file-id)
 */
function fileDownLoad(physicalFileNm, logicalFileNm, filePlace, fileRepositoryId, fileKey) {
	if ( fileRepositoryId == null || fileRepositoryId == undefined || fileRepositoryId.length == 0 ) { 
		fileRepositoryId = "TPB";
	}
	//ComShowMessage(" physicalFileNm : "+physicalFileNm+"\n logicalFileNm : "+logicalFileNm+"\n filePlace  : "+filePlace+"\n fileRepositoryId : "+fileRepositoryId+"\n fileKey : "+fileKey);

	///----- iframe 생성 -----
	var o1 = document.createElement("DIV");
	var f = document.frames;
	var ifr = "frame_"+f.length;
	o1.style.display = "none";
	o1.innerHTML = '<iframe name="'+ifr+'" scrolling="no" frameborder="10" width="0" height="0"></iframe>';
	document.body.appendChild(o1);

	///----- form 생성 -----
	var o2 = document.createElement("DIV");
	var formArr = document.forms;
	var formObj = "downFrm_"+formArr.length;
	o2.style.display = "none";
	formStr = "";
	formStr += "<form method='post' name='"+formObj+"' target='"+ifr+"' action='/hanjin/FileDownload' >"; /// Action : FileDownload Servlet
	formStr += "<input type='hidden' name='fileId'>"; //실제 물리 파일명( 저장되어있는 )
	formStr += "<input type='hidden' name='fileDir'>"; // 파일이 저장되어있는 경로
	formStr += "<input type='hidden' name='orgFilename'>"; // 논리 파일명 ( 사용자가 다운로드 받을 명칭 )
	formStr += "<input type='hidden' name='repoId'>"; // file-meta 정보  ID 
	formStr += "<input type='hidden' name='key'>"; // file key
	formStr += "<input type='hidden' name='downloadLocation'>"; // downloadLocation
	formStr += "<input type='hidden' name='stringFile'>"; // stringFile
	formStr += "</form>";
	o2.innerHTML = formStr;
	document.body.appendChild(o2);

	///----- submit, download servlet Call -----
	document.forms[formObj].fileId.value = physicalFileNm;  //실제 물리 파일명( 저장되어있는 )
	document.forms[formObj].orgFilename.value = logicalFileNm; // 논리 파일명 ( 사용자가 다운로드 받을 명칭)
	document.forms[formObj].fileDir.value = filePlace;  // 파일이 저장되어있는 경로
	document.forms[formObj].repoId.value = fileRepositoryId; // file-meta 정보  ID 
	document.forms[formObj].key.value = physicalFileNm; // file key
	document.forms[formObj].downloadLocation.value = filePlace; // downloadLocation
	document.forms[formObj].stringFile.value = logicalFileNm; // stringFile
	document.forms[formObj].submit();
	document.forms[formObj].reset();
}

//===== 기타 ===================================================================== 
//===== automatic change text to uppercase ===== 
/**
 * 예외 입력필드 또는 칼럼 체크
 * @param : type - text, sheet
 * @param : val - 체크하고자 하는 
 * @return : boolean - 예외이면  true
 */
function _exceptCheck(type, val) {
	if ( val==null || val=="" ) { return false; }
	// exceptit object id/name for automatic change text to uppercase
	var expTextNames = new Array("s_if_rmk","s_cfm_rmk","stl_rqst_rmk","p_stl_apro_rmk","s_inv_rmk1","s_inv_rmk2","s_inv_rmk1","s_inv_rmk2","s_clt_agn_rmk","s_n3pty_src_no","s_ofc_addr","s_usr_inp_ctnt1","s_usr_inp_ctnt2","s_vndr_cust_addr","s_cty_nm","s_ste_cd","s_zip_cd");
	var expSheetNames = new Array("cfm_rmk","if_rmk","act_rmk","n3pty_bil_tp_nm","n3pty_bil_tp_desc","cntc_pson_nm","upd_usr_id");

	var rtnVal = false;

	if ( type=="text" ) {
		for ( var i=0; i<expTextNames.length; i++ ) {
			if ( val == expTextNames[i] ) {
				rtnVal = true;
				break; 
			}
		}
	} else if ( type=="sheet" ) {
		for ( var i=0; i<expSheetNames.length; i++ ) {
			if ( val == expSheetNames[i] ) {
				rtnVal = true;
				break; 
			}
		}
	}
	return rtnVal; 
}

/**
 * input type=text 개체의 입력값을 onkeyup 이벤트 발생시에 대문자로 변환하는 함수
 * @param : object name - 개체명
 */	
function _txt_onkeyup() {
	var argv = _txt_onkeyup.arguments;
	var argc = argv.length;
	if ( argc > 0 && argv[0]!=undefined && argv[0]!=null && argv[0].length>0 ) {
		document.getElementById(argv[0]).value = document.getElementById(argv[0]).value.toUpperCase();
	}
	argv = null;
}

/**
 * IBSheet 개체 Cell의 입력값을 onchange 이벤트 발생시에 대문자로 변환하는 함수
 * @param : sheet object
 * @param : Row
 * @param : Col
 */	
function _sheet_onchange() { /// sheetObj, Row, Col
	var argv = _sheet_onchange.arguments;
	var argc = argv.length; 
	var sheetObj = argv[0];
	if ( argc > 0 && sheetObj!=undefined && sheetObj!=null ) {
		var Row = argv[1];
		var Col = argv[2];
		if ( Row!=undefined && Row!=null && Row >=0 && Col!=undefined && Col!=null && Col >=0 ) {
			if ( !_exceptCheck("sheet", sheetObj.ColSaveName(Col) ) ) {
				if ( sheetObj.ReadDataProperty(0, sheetObj.ColSaveName(Col), dpDataType)  == dtData ) {
					sheetObj.CellValue2(Row, Col) = sheetObj.CellValue(Row, Col).toUpperCase();
				}
			}
		}
	}
	argv = null;
}

/**
 * document내 input type=text 개체를 onkeyup 이벤트 발생시에 대문자로 변환되도록 이벤트와 함수를 연결하여 초기화 하는 함수
 */	
function _text_ChangeUpperCase() {
	var txtName = "";
	for (var i=0; i<document.all.length; i++) {
		if ( document.all[i].type == "text" ) {
			txtName = document.all[i].name; 
			if ( !_exceptCheck("text", txtName) ) {
				eval( "document.getElementById('"+txtName+"').onkeyup = function() { _txt_onkeyup('"+txtName+"'); }" );
			}
		} else if ( document.all[i].classid == "CLSID:C838E9DA-1625-4E14-8B37-C6706B43C423") {
			var id = document.all[i].name; 
			if ( id == undefined || id == null || id == "" ) { id = document.all[i].id; }

			try{

				if ( ComFuncCheck( id+"_OnChange") && eval( id+"_OnChange").length > 0 ) {
				} else {
					eval( id+"_OnChange = function(sheetObj,Row,Col,Value) { _sheet_onchange( sheetObj,Row,Col,Value ); } " );
				}
			} catch(e) {
				// eval( id+"_OnChange = function(sheetObj,Row,Col,Value) { _sheet_onchange( sheetObj,Row,Col,Value ); } " );
			}
		}
	}
}

/**
 * Oustanding Amount Cell color change
 *
 * Auto Update check
 * @param : sheetObj     :Sheet object
 * @param : Auto Update Count column index
 * @param : ots_amt_idx  :Sheet OTS_AMT column index
 * @param : row_idx      :Sheet Row index, 특정 row만 적용시
 * @param : header_cnt   :Sheet Header Row Count
 *
 * tpb_chgColor_ots_amt(sheetObj, auto_update_cnt_idx, ots_amt_idx, [row_idx], [header_cnt])
 */
function tpb_chgColor_ots_amt(sheetObj, auto_update_cnt_idx, ots_amt_idx, row_idx, header_cnt) {
	//사용안함
	return;
	var exec = true;
	if(row_idx == undefined || row_idx == "" || row_idx == null) row_idx = 0;
	if(header_cnt == undefined) header_cnt = 1;

	if(exec) {
		if(row_idx == 0) {
			for(var i=header_cnt;i<=sheetObj.RowCount+(header_cnt-1);i++) {
				if(sheetObj.CellValue(i, auto_update_cnt_idx) > 0) {
					sheetObj.CellBackColor(i, ots_amt_idx) = sheetObj.RgbColor(255,255,0);
					sheetObj.CellFontColor(i, ots_amt_idx) = sheetObj.RgbColor(255, 0, 0);
					sheetObj.RangeFontBold(i, ots_amt_idx) = true;
				}
			}
		} else {
			if(sheetObj.CellValue(row_idx, auto_update_cnt_idx) > 0) {
				sheetObj.CellBackColor(row_idx, ots_amt_idx) = sheetObj.RgbColor(255,255,0);
				sheetObj.CellFontColor(row_idx, ots_amt_idx) = sheetObj.RgbColor(255, 0, 0);
				sheetObj.RangeFontBold(row_idx, ots_amt_idx) = true;
			}
		}
	}
}


/**
 * VAT 적용된 금액 산출
 *
 * Auto Update check
 * @param : sumInvAmt   : invoice amount sum 또는 Net Amount
 * @param : isModify    : 직접 금액 수정했는지 여부
  * tpb_vatAmount([sumInvAmt] [,isModify])
 */
function tpb_vatAmount(sumInvAmt, isModify) {
	if(sumInvAmt == undefined || sumInvAmt == null) sumInvAmt = parseFloat(ComGetUnMaskedValue(document.form.s_net_amt.value,"float"));
	if(isModify == undefined) isModify = false;
	var tvaChecked = document.form.s_vat_xch_rt_chk.checked;
	var s_vat_xch_rt = document.form.s_vat_xch_rt.value;
	var s_vat_amt = document.form.s_vat_amt.value;

	if(!tvaChecked) {
		document.form.s_vat_amt.readOnly = true;
		document.all.s_vat_amt.className = "noinput";
	} else {
		document.form.s_vat_amt.readOnly = false;
		document.all.s_vat_amt.className = "";
	}

	var tvaAmt = 0;
	
	if(isModify) {
		if(ComIsNumber(document.form.s_vat_amt)) {
			if(parseFloat(ComGetUnMaskedValue(s_vat_amt,"float")) > 0) {
				tvaAmt = ComRound(parseFloat(ComGetUnMaskedValue(s_vat_amt,"float")));
			}
		} else {
			tvaAmt = 0;
		}
	} else {
		if(tvaChecked && s_vat_xch_rt != "") {
			tvaAmt = ComRound(parseFloat(sumInvAmt) * parseFloat(s_vat_xch_rt)/100);
		} else {
			tvaAmt = 0;
			//if(document.form.s_vat_amt.value != "") {
			//	tvaAmt = parseFloat(ComClearSeparator(document.form.s_vat_amt.value,","));
			//}
		}
	}
	var totalAmt = ComRound(parseFloat(sumInvAmt) + parseFloat(tvaAmt));

	document.form.s_net_amt.value = ComAddComma2(sumInvAmt+"","#,###.00");
	document.form.s_vat_amt.value = ComAddComma2(tvaAmt+"","#,###.00");
	document.form.s_total_amt.value = ComAddComma2(totalAmt+"","#,###.00");
}

/*
 * 3rd party 콤보 리스트에서 staff 은 삭제 (invoice관련 검색조건의 경우)
 */
function tpb_3rdPartyStaffClear(obj) {
	if(obj != null && obj !=undefined && obj.length > 0)
	{
		for(var i = obj.length ; i >= 0; i--)
		{
			if(obj.options[i-1].value == 'S') {
				obj.remove(i-1);
				break;
			}
		}
	}
}

/////////////////////////////////////////////////////////    
///// 2008.09.01 재정의 영역 //////
/////////////////////////////////////////////////////////

/**
 * vndr_cust_div_cd 값에 따라 3rd Party를 조회하는 함수
 * sheet에서 호출시 사용
 *
 * @param : val - vndr_cust_div_cd
 */
function get3rdPartyTarget_sheet(val, Row, Col, sheetObj, id1, id2) {
	var strTrd_party = val;

	if(strTrd_party=='C') {
		ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, 'getCustomer_sheet', '1,0,1,1,1,1,1,1', true, false, Row, Col);
	} else if(strTrd_party=='S') {
		// ComOpenPopup('/hanjin/COM_ENS_091.do', 770, 600, 'getStaff_sheet', '1,0,1,1,1,1,1,1', Row, Col, false, true);
		open3rdPartyTargetPopup_sheet(val, Row, Col, sheetObj, id1, id2);
	} else if(strTrd_party=='V') {
		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'getVendor_sheet', '1,0,1,1,1,1,1,1', true, false, Row, Col);
	} else {
		ComShowCodeMessage('TPB90015'); 
	    try { sheetObj.SelectCell(Row, "vndr_cust_div_cd"); } catch(e) { ComShowMessage(e); } /// set focus		
	}
}

/**
 * 3rd Party Staff 팝업창을 여는 함수
 * sheet에서 호출시 사용
 */
function open3rdPartyTargetPopup_sheet(val, row, col, sheetObj, id1, id2) {

	var theURL = "ESD_TPB_0804.do?title=Select Staff";
    // ComShowMessage( theURL );
	var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:500px";

	var rtnValue = window.showModalDialog(theURL, window, features);

	if(rtnValue != undefined && rtnValue != null ) {
		// document.form.stl_to_clt_cng_ofc_cd.value = rtnValue;
    	sheetObj.CellValue2(row, col) = rtnValue;
    	sheetObj.CellValue2(row, 'n3pty_ofc_cd') = rtnValue;
    	sheetObj.CellValue2(row, 'cust_cnt_cd') = '';
    	sheetObj.CellValue2(row, 'cust_seq') = '';
    	sheetObj.CellValue2(row, 'vndr_cnt_cd') = '';
    	sheetObj.CellValue2(row, 'vndr_seq') = '';
    	
    	if( id1 != '' && id1 != undefined &&
			id2 != '' && id2 != undefined) {
    	    eval("document.all."+id1).value = "S";
    		eval("document.all."+id2).value = rtnValue;
	    	getThirdParyTargetSheetAfter(sheetObj, row, id1, id2);
    	} else {
    	    document.all.s_vndr_cust_div_cd.value = "S";
	        document.all.s_trd_party_val.value = rtnValue;
	    	getThirdParyTargetSheetAfter(sheetObj, row);
       }
		
	}
}
/**
 * 3rd Party popup 호출 후 처리 
 */
function getThirdParyTargetSheetAfter(sheetObj, Row, id1, id2) {
    try { 

    	if( ComTrim( sheetObj.CellValue(Row, 'trd_party_val') ) != '') {
    		if( ComTrim(sheetObj.CellValue(Row, 'vndr_cust_div_cd') ) != "") {
//    			sheetObj.CellEditable(Row, "cfm_flg_y") = true;
    			sheetObj.CellEditable(Row, "cfm_i") = true;
    			sheetObj.CellEditable(Row, "cfm_g") = true;
				if( id1 != '' && id1 != undefined &&
					id2 != '' && id2 != undefined) {
				    id1 = eval("document.all."+id1).value;
					id2 = eval("document.all."+id2).value;
	                getTPBGenCombo('Void_ThirdParty_Sheet','checkTrdParty','V','','',new Array(id2,id1), Row);
				} else {
	                getTPBGenCombo('Void_ThirdParty_Sheet','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd"), Row);
				}
    		}
    		if(sheetObj.CellValue(Row, 'curr_cd') == "" || parseFloat(sheetObj.CellValue(Row, 'cfm_amt')) == 0) {
//    			sheetObj.CellEditable(Row, "cfm_flg_y") = false;
//    			sheetObj.CellValue2(Row, "cfm_flg_y") = "0";
				sheetObj.CellEditable(Row, "cfm_i") = false;
				sheetObj.CellEditable(Row, "cfm_g") = false;
				sheetObj.CellValue2(Row, "cfm_i") = "0";
				sheetObj.CellValue2(Row, "cfm_g") = "0";
    		}
    	} else {
//    		sheetObj.CellEditable(Row, "cfm_flg_y") = false;
//    		sheetObj.CellValue2(Row, "cfm_flg_y") = "0";
//    		sheetObj.CellValue2(Row, "trd_party_val") = "";
			sheetObj.CellEditable(Row, "cfm_i") = false;
			sheetObj.CellEditable(Row, "cfm_g") = false;
			sheetObj.CellValue2(Row, "cfm_i") = "0";
			sheetObj.CellValue2(Row, "cfm_g") = "0";
			sheetObj.CellValue2(Row, "trd_party_val") = "";
    	}
    } catch(e) {
        // ComShowMessage(e.toString());
    }
}

/**
 * Recovery Activity 팝업을 띄우는 함수
 *
 * @param : pN3pty_no - n3pty_no
 * @param : pN3pty_inv_no - n3pty_inv_no
 * @param : pFrom_N3pty_no - From n3pty_no (in case from R.O.C.)
 */
function openRecoveryActPopup(pN3pty_no, pN3pty_inv_no, pFrom_N3pty_no, pIsReadOnly) {
	var theURL = "ESD_TPB_0807.do?n3pty_no="+pN3pty_no+"&n3pty_inv_no="+pN3pty_inv_no+"&is_read_only="+pIsReadOnly;
	if ( pFrom_N3pty_no!=null && ComTrim(pFrom_N3pty_no).length>0 ) {
	    theURL += "&from_n3pty_no="+pFrom_N3pty_no; 
	}
	var winName = "ESD_TPB_0807";
	var features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=yes,alwaysRaised,dependent,titlebar=no,width=1000,height=550";
	ComOpenWindow(theURL,winName,features);
}

/**
 * VAT 적용된 금액 산출 - 2008.10
 *
 * Auto Update check
 * @param : sumInvAmt   : invoice amount sum 또는 Net Amount
 * @param : isModify    : 직접 금액 수정했는지 여부
  * tpb_vatAmount([sumInvAmt] [,isModify])
 */
function tpb_vatAmountReCalculate(sumInvAmt, isModify) {
	if(sumInvAmt == undefined || sumInvAmt == null) {
	    sumInvAmt = parseFloat(ComGetUnMaskedValue(document.form.s_net_amt.value,"float"));
	}
	var addAmt = parseFloat(ComGetUnMaskedValue(document.form.s_add_amt.value,"float")); 
	if( isNaN(addAmt) || addAmt == undefined || addAmt == null) {
	    addAmt = 0.00;
	} 
	var ddtAmt = parseFloat(ComGetUnMaskedValue(document.form.s_ddct_amt.value,"float")); 
	if( isNaN(ddtAmt) || ddtAmt == undefined || ddtAmt == null) {
	    ddtAmt = 0.00;
	} 
	
	if(isModify == undefined) {
	    isModify = false;
	}
	var tvaChecked = document.form.s_vat_xch_rt_chk.checked;
	var s_vat_xch_rt = document.form.s_vat_xch_rt.value;
	var s_vat_amt = document.form.s_vat_amt.value;

	if(!tvaChecked) {
		document.form.s_vat_amt.readOnly = true;
		document.all.s_vat_amt.className = "noinput";
	} else {
		document.form.s_vat_amt.readOnly = false;
		document.all.s_vat_amt.className = "";
	}

	var tvaAmt = 0;
	
	if(isModify) {
		if(ComIsNumber(document.form.s_vat_amt)) {
			if(parseFloat(ComGetUnMaskedValue(s_vat_amt,"float")) > 0) {
				tvaAmt = ComRound(parseFloat(ComGetUnMaskedValue(s_vat_amt,"float")));
			}
		} else {
			// tvaAmt = 0;
			//if (!isNaN(s_vat_amt) && parseFloat(s_vat_amt) > 0){
			if (parseFloat(s_vat_amt) > 0){
				tvaAmt = ComRound(parseFloat(ComGetUnMaskedValue(s_vat_amt,"float")));
			} else {
				tvaAmt = 0;
			}
		}
	} else {
		if(tvaChecked && s_vat_xch_rt != "") {
			tvaAmt = ComRound( (parseFloat(sumInvAmt)+parseFloat(addAmt)-parseFloat(ddtAmt)) * parseFloat(s_vat_xch_rt) / 100.00);
		} else {
			tvaAmt = 0;
			//if(document.form.s_vat_amt.value != "") {
			//	tvaAmt = parseFloat(ComClearSeparator(document.form.s_vat_amt.value,","));
			//}
		}
	}
	// 2009-03-16 N200903090210 - tpb_vatAmountReCalculate 의 VAT Amount 는 KRW,JPY,VND 경우 Integer 로 한다.
	try{
		if( (document.form.s_curr_cd.value == "KRW" || document.form.s_curr_cd.value == "JPY" || document.form.s_curr_cd.value == "VND") ) {
			addAmt = parseInt( addAmt );
			ddtAmt = parseInt( ddtAmt );
			tvaAmt = parseInt( tvaAmt );
		}
	} catch(e) {
	
	}
	
	var totalAmt = ComRound(parseFloat(sumInvAmt) + parseFloat(tvaAmt) + parseFloat(addAmt) - parseFloat(ddtAmt));

	document.form.s_net_amt.value = ComAddComma2(sumInvAmt+"","#,###.00");
	document.form.s_add_amt.value = ComAddComma2(addAmt+"","#,###.00");
	document.form.s_ddct_amt.value = ComAddComma2(ddtAmt+"","#,###.00");
	document.form.s_vat_amt.value = ComAddComma2(tvaAmt+"","#,###.00");
	document.form.s_total_amt.value = ComAddComma2(totalAmt+"","#,###.00");
}

function tpb_otherAmountReCalculate(obj) {
	if(ComIsNumber(obj)) {
		if(parseFloat(ComGetUnMaskedValue(obj.value,"float")) > 0) {
			obj.value = ComRound(parseFloat(ComGetUnMaskedValue(obj.value,"float")));
		} else {
      		obj.value = "0.00"; 
		}
	//} else {
	//	obj.value = "0.00"; 
	}
	tpb_vatAmountReCalculate(null, true);
}


function Set_Cookie( name, value, expires, path, domain, secure ) {
    // set time, it's in milliseconds
    var today = new Date();
    today.setTime( today.getTime() );
    
    /*
    if the expires variable is set, make the correct 
    expires time, the current script below will set 
    it for x number of days, to make it for hours, 
    delete * 24, for minutes, delete * 60 * 24
    */
    if ( expires ) {
        expires = expires * 1000 * 60 * 60 * 24;
    }
    var expires_date = new Date( today.getTime() + (expires) );
    
    document.cookie = name + "=" + escape( value ) +
        ( ( expires ) ? ";expires=" + expires_date.toGMTString() : "" ) + 
        ( ( path ) ? ";path=" + path : "" ) + 
        ( ( domain ) ? ";domain=" + domain : "" ) +
        ( ( secure ) ? ";secure" : "" );
}

function Get_Cookie( name ) {

    var start = document.cookie.indexOf( name + "=" );
    var len = start + name.length + 1;

    if ( ( !start ) &&( name != document.cookie.substring( 0, name.length ) ) ) {
       return null;
    }

    if ( start == -1 ) return null;
    
    var end = document.cookie.indexOf( ";", len );
    if ( end == -1 ) end = document.cookie.length;

    return unescape( document.cookie.substring( len, end ) );
}

function Delete_Cookie( name, path, domain ) {
    if ( Get_Cookie( name ) ) document.cookie = name + "=" +
        ( ( path ) ? ";path=" + path : "") +
        ( ( domain ) ? ";domain=" + domain : "" ) +
        ";expires=Thu, 01-Jan-1970 00:00:01 GMT";
}

function getValidOpenerOfPendigTPBWin() {
    var rtnVal = false;
    try{
        var strArr = (location.href).split("/");
        var str = strArr[strArr.length-1];
        var str1 = strArr[strArr.length-1];
        str = str.substring(0,10);
        str1 = str1.substring(0,12);
        
        if ( str1 == "ESD_TPB_0134")
        {
        	return false;
        } else if ( str1 == "ESD_TPB_0103" )
    	{
        	return false
    	}
        
        if ( str == "ESD_TPB_01" )
        { // ESD_TPB_01* 는 팝업실행 대상
            return true; 
        } 
    } catch (e) {
    }
    return rtnVal; 
}

/**
 * Pending TPB Popup Window Opener 이동 함수  
 */
function navigateOpenerPendingTPB() { // TPB Office(G)일 경우만... 
	 if ( getValidOpenerOfPendigTPBWin() == false ) {
        return;
    }
    
    var openWinYN = Get_Cookie("PendingTPBWin"); 
      
    if ( openWinYN == undefined || openWinYN == null || openWinYN == 'N' || openWinYN == "" ) {
    	var f = document.frames;
    	var ifr = "frame_"+f.length;
    	var o = document.createElement("DIV");
    	o.style.display = "none";
    	o.innerHTML = '<iframe name="'+ifr+'" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
    	document.body.appendChild(o);
    	eval("document."+ifr).location.href = "TPBPendigTpbOpener.do";
    }
    /*
	var f = document.frames;
	var ifr = "frame_"+f.length;
	var o = document.createElement("DIV");
	o.style.display = "none";
	o.innerHTML = '<iframe name="'+ifr+'" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
	document.body.appendChild(o);
	eval("document."+ifr).location.href = "TPBPendigTpbOpener.do";
	*/
}

/* 바로 실행 */
setTimeout("navigateOpenerPendingTPB();",1000);

/**
 * Pending TPB Popup Window 호출 함수 
 */
function openPendingTPBWin(isTPBofficeYN ) { // TPB Office(G)일 경우만... 
	if ( isTPBofficeYN == 'Y' ) {
        var theURL = "ESD_TPB_0808.do";
        var winName = "ESD_TPB_0808";
        var features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=360,height=360";

        Set_Cookie( "PendingTPBWin", "Y", 1, "", "", "" );
        ComOpenWindow(theURL,winName,features);
    } else {
        Set_Cookie( "PendingTPBWin", "None", 1, "", "", "" ); /// TPB Office가 아닌 경우 
    }
}

/**
 * 2009-09-07
 * TPB Billing Case 의 횡적제공을 위한 함수
 * param1 : div(string) - 구분문자
 * param2 : ord(Y/N) - 정렬제공여부
 * param3 : method(string) - getAllBillingCase : 모든 Billing Case 검색
 * param4 : rec_obj(string) - the object, will be received 
 */
function getThirdPartyBillingCaseHorizontally(hdiv,ord,method,obj,func){
	var f = document.frames;
	var ifr = "frame_"+f.length;
	var o = document.createElement("DIV");
	o.style.display = "none";
	o.innerHTML = '<iframe name="'+ifr+'" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
	document.body.appendChild(o);
	
	eval("document."+ifr).location.href = "TPBCommonCode.do?hdiv="+hdiv+"&ord="+ord+"&method="+method+"&obj="+obj+"&func="+func;
}
 
 /**
  * input 값의 길이를 체크하고 메시지 보여주는 함수
  */	
 function tpb_chkLenByByte(obj, len, name){
 	if(!ComChkLenByByte(obj, len)){
 		ComShowCodeMessage("COM12142",name,len,"");
 	}
 }	
  
	/**
	 * TPB Common 숫자만 사용
	 * 
	 * @param {Object}	obj			Object
	 * @param {String}	isChkFmt	Format Check 할지 여부(Y/N)
	 * @param {String}	int_str		integer String
	 **/
	function tpb_isNumD(obj, isChkFmt, int_str){
		if (isChkFmt==undefined || isChkFmt==null || isChkFmt.trim()==''){
			// 단순히 숫자와 '-'만 허용
			if (!ComIsNumber(obj, "-")){obj.value = '';
			}
		} else if (isChkFmt!=undefined && isChkFmt!=null && isChkFmt=='Y'){
			var int_char = (int_str!=undefined&&int_str!=null&int_str.trim()!=''?int_str.trim():'-');
			var src = obj.value;
			for (var i=0; src!=null && i<src.length; i++){
				if ((i!=4 && i!=7 && !ComIsNumber(src.charAt(i))) || ((i==4 || i==7) && !ComIsNumber(src.charAt(i), "-"))){
					src = src.substring(0,i) + src.substring(i+1,src.length);
				} else {
					if ((i==4 || i==7) && (src.charAt(i)!=int_char)){
						src = src.substring(0,i) + int_char + src.substring(i,src.length);
					}
				}
			}
			obj.value = src;
		}
		return true;
	}
	
	/**
	 * [Period] 유효성 체크
	 * @param {string]	obj		날짜
	 * @return
	 */
	function tpb_validateDateObj(obj) {
		if (obj.readOnly == true) {
			return false;
		}
		obj.value = obj.value.trim();
		if (obj.value == null || obj.value.trim() == '') {
			return false;
		}

		if (!tpb_checkPeriodFormat(obj.value) || !tpb_isValidDateObject(obj.value,'-')){
			ComShowCodeMessage("COM12132");
			obj.focus();
			return false;
		}

		return true;
	}
	 
	 /**
	 * [Period] 유효성 체크
	 * @param {string]	obj		날짜
	 * @return
	 */
	function tpb_validateMonthObj(obj) {
		if (obj.readOnly == true) {
			return false;
		}
		obj.value = obj.value.trim();
		if (obj.value == null || obj.value.trim() == '') {
			return false;
		}

		if (!tpb_checkMonthFormat(obj.value) || !tpb_isValidMonthObject(obj.value,'-')){
			ComShowCodeMessage("COM12180");
			obj.focus();
			return false;
		}

		return true;
	}


	/**
	 * TPB Common regular expression을 통과해도 진짜 날짜 유형 객체에 적합한지 검사한다.<br>  
	 * 사용예: 2006-11-00은 정규식은 통과하지만, 사실상 유효하지 않는 날짜이다.<br>
	 * 
	 * @param {String}	str_date	Date
	 * @param {String}	del			delete 구분자
	 **/
	function tpb_isValidDateObject(str_date, del){
		if (del==undefined || del==null || del.trim()==''){del = '-';}
		var arr_date = str_date.split(del);
		var obj_date = new Date(arr_date[0],arr_date[1]-1,arr_date[2]);
		var result = (1*arr_date[0]==obj_date.getFullYear() && 1*arr_date[1]==(obj_date.getMonth()+1) && 1*arr_date[2]==obj_date.getDate());
		if (result){return true;
		} else {return false; 
		}
	}
	 
	 /**
	  * 유효월 체크
	  * @param str_date
	  * @param del
	  * @return
	  */
	 function tpb_isValidMonthObject(str_date, del){
			if (del==undefined || del==null || del.trim()==''){del = '-';}
			var arr_date = str_date.split(del);
			var obj_date = new Date(arr_date[0],arr_date[1]-1);
			var result = (1*arr_date[0]==obj_date.getFullYear() && 1*arr_date[1]==(obj_date.getMonth()+1));
			if (result){return true;
			} else {return false; 
			}
		}
	 
	/**
	 * Period 형식 체크
	 * @param {string}	obj	날짜
	 * @return
	 */
	function tpb_checkPeriodFormat(obj) {
		var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
		if (!tpb_checkFormat2(obj, date_regexp)) {
			return false;
		} else {
			return true;
		}
	}
	 
	/**
	 * Period 형식 체크
	 * @param {string}	obj	날짜
	 * @return
	 */
	function tpb_checkMonthFormat(obj) {
		var date_regexp = /(^\d{4}\-\d{2}$)/;
		if (!tpb_checkFormat2(obj, date_regexp)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * TPB Common Check Format  .<br>
	 * 사용예:  regexp = "^(\\d{4}-\\d{2}-\\d{2})$";.<br>
	 * 
	 * @param {String}	src		Source String
	 * @param {String}	regexp	정규표현식
	 **/
	function tpb_checkFormat(src, regexp){
		if (src==null || src=='' || regexp==null || regexp==''){return false;}
		re = new RegExp(regexp,"gi");
		if (!re.test(src)){return false;
		} else {return true;
		}
	}

	/**
	 * TPB Common Check Format.<br>  
	 * 사용예:  regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;.<br.
	 * 
	 * @param {String}	src		Source String
	 * @param {String}	regexp	정규표현식
	 **/
	function tpb_checkFormat2(src, regexp){
		if (src==null || src=='' || regexp==null || regexp==''){return false;}
		result = (regexp.test(src));
		if (!result){return false;
		} else {return true;
		}
	}

	/**
	  * 문자열에 포함된 모든 변환대상 패턴을 변경하여 리턴
	  * @param str   문자열
	  * @return ret  변경된 문자열
	  */
	function replaceStr(str, find, replace)
	{
		var pos = 0;
		pos = str.indexOf(find);
		
		while(pos != -1)
		{
		    pre_str = str.substring(0, pos);
		    post_str = str.substring(pos + find.length, str.length);
		    str = pre_str + replace + post_str;
		    pos = str.indexOf(find);
		} // end while
		return str;
	}
	  
	/**
	* @param     : source => string 또는 obj 둘다 지원
	*		: char => 없애고 싶은 단어나 문장
	* sample	: delete_Char(this,',')   => this.value 가 3,3,3, 일때 이함수를 이용하면 333으로 나옴
	* @return 	:
	* 설명		: 문자를 없앨때 쓰는 함수
	**/
	function delete_Char(source,char1)
	{
		if (typeof(source) == "string")
		{
			return replaceStr(source,char1,'');
		}
		else if (typeof(source) == "object")
		{
			source.value = replaceStr(source.value,char1,'');
		}
		else
		{
			ComShowMessage(ComGetMsg('TPB90014'));
		}
	} 
	 