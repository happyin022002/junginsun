<%--
/*=========================================================
*Copyright(c) 2006~2008 CyberLogitec
*@FileName : TPBCommonCode.jsp
*@FileTitle :  Common HTML Combo list
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>
<% 
	response.setHeader("expires", "-1"); 
	response.setHeader("pragma", "no-cache"); 
	response.setHeader("cache-control", "no-cache"); 
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.combo.event.CommonCodeEvent"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.combo.event.CommonCodeEventResponse"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<% 
	CommonCodeEvent event = null;
	//CommonCodeEventResponse eventResponse = null;	  //RDTO(Data Transfer Object including DB ResultSet)
	GeneralEventResponse eventResponse = null;
	Exception serverException = null;					   
	DBRowSet rowSet = null;							  //DB ResultSet
	String strErrMsg = "";								  
	int rowCount	 = 0;							  //DB ResultSet  
	String id = "";
	String mode = "";
	String obj = "";
	String all = "";
	String otherObjs = "";
	//2009-09-07
	String hdiv = "";
	//2009-12-04
	String func = "";
	String row = "";
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (CommonCodeEvent)request.getAttribute("Event");
			id = (String)event.getAttribute("id");
			mode = (String)event.getAttribute("mode");
			obj = (String)event.getAttribute("obj");
			all = (String)event.getAttribute("all");
			otherObjs = (String)event.getAttribute("otherObjs");
			
			//2009-09-07
			hdiv = (String)event.getAttribute("hdiv");
			//2009-12-04
			func = (String)event.getAttribute("func");
			
			row = (String)event.getAttribute("row");
			
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<script language="JavaScript">
	function makeCombo(IdObj,mode,obj,all,otherObjs, row) {
		if(IdObj != null )
		{ 
			var parentObj = '';
			//alert("codeArr.length==>"+codeArr.length+"&all===>"+all);
			if(mode == 'F') {
				parentObj = parent.eval("document.all."+IdObj);
				
				if(parentObj !=undefined) {
					ComClearCombo(parentObj);
					//alert("codeArr.length==>"+codeArr.length+"&all===>"+all);
					if(codeArr.length >= 1) {
						if(all == '1') {
							ComAddComboItem(parentObj, "", "ALL" );
						} else if(all == '2') {
							ComAddComboItem(parentObj, "", "<<Select>>" );
						} else if(all == '3') {
							ComAddComboItem(parentObj, "", "" );
						} else if(all == '4') {
							ComAddComboItem(parentObj, "", "<<Select>>" );
							ComAddComboItem(parentObj, "", "ALL" );
						} else if(all == '11') {
							ComAddComboItem(parentObj, "-", "ALL" );
						}
					}
					for(var i=0,n=codeArr.length;i<n;i++) {
						ComAddComboItem(parentObj, codeArr[i][0], codeArr[i][1] );
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
	   						parent.sheetObjects[0].SetCellValue(otherObjs, 'stl_to_clt_cng_ofc_cd', '');
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
	   				} else if (IdObj == "s_vvd") { //VVD Check
	   					
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
					} else if (IdObj == "s_tpb_seq") { // Getting tpb_seq
	   					if(codeArr.length > 0) {
	   						parent.sheetObjects[0].SetCellValue(otherObjs,2, codeArr[0][0], 0);
	   						//parent.sheetObjects[0].CellValue2(parent.sheetObjects[0].selectRow,2) = codeArr[0][0];
	   					}
					} else { // In case of general
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
						parent.sheetObjects[0].SetCellValue(row, "eq_no", "", 0);
					}
				} else if ( IdObj=="CheckTPBCode") {
					if(codeArr.length > 0) {
						ComShowCodeMessage('TPB90069');
						parent.sheetObjects[0].SetCellValue(row, "n3pty_bil_tp_cd", "", 0);
					}
				} else if ( IdObj=="CheckVendorCode") {
					if(codeArr.length <= 0) {
						ComShowCodeMessage('TPB90071');
		    			parent.document.all.s_src_vndr_no.value = "";
		    			parent.document.all.s_src_vndr_no.focus();
					}
				} else if ( IdObj=="CheckCntrNo") {
					if(codeArr.length > 0) {
						parent.sheetObjects[0].SetCellValue(row, "cntr_tpsz_cd", codeArr[0][0], 0);
					} else {			
						ComShowCodeMessage('TPB90074');
						//parent.sheetObjects[0].CellValue2(-1, "eq_no") = "";
						//parent.sheetObjects[0].CellValue2(-1, "eq_tpsz_cd") = "";
					}
				} else if ( IdObj=="CheckEqNo") {
					if(codeArr.length > 0) {
						parent.sheetObjects[0].SetCellValue(row, "eq_tpsz_cd", codeArr[0][0], 0);
					} else {			
						ComShowCodeMessage('TPB90074');
						//parent.sheetObjects[0].CellValue2(-1, "eq_no") = "";
						//parent.sheetObjects[0].CellValue2(-1, "eq_tpsz_cd") = "";
					}
				} else if ( IdObj=="CheckBkgNo") {
					if(codeArr.length == 0) {			
						parent.bkgAutoInput(false,"");
					} else{
						parent.bkgAutoInput(true,codeArr[0][0]);
					}
				} else if ( IdObj=="CheckBlNo") {
					if(codeArr.length == 0) {
						parent.blAutoInput(false,"");
					} else{
						parent.blAutoInput(true,codeArr[0][0]);
					}
				} else if ( IdObj=="CheckVvdNo") {
					if(codeArr[0][0] == 0) {			
						parent.vvdAutoInput(false);
					} else{
						parent.vvdAutoInput(true);
					}
				} else if ( IdObj=="CheckRegOffice") {
					if(codeArr.length <= 0) {
						ComShowCodeMessage('TPB90104');
						parent.sheetObjects[0].SetCellValue(row, "ofc_cd", "", 0);
					}
	            } else if ( IdObj=="CheckRegOffice2") {
					if(codeArr.length <= 0) {
						ComShowCodeMessage('TPB90106');
						parent.sheetObjects[0].SetCellValue(row, "n3pty_ofc_cd", "", 0);
					}
	            } else if ( IdObj=="CheckRegOffice3") {
					if(codeArr.length <= 0) {
						ComShowCodeMessage('TPB90104');
						parent.sheetObjects[0].SetCellValue(row, "n3pty_ofc_cd", "", 0);
					}else{
						parent.rhqHoCheck();
					}
	            }else if ( IdObj=="Void_ThirdParty") { // 3rd Party Input directly 
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
	                        	ComShowCodeMessage('COM12114',"the Staff(Office) value!");
	                        } else {
	                        	ComShowCodeMessage('COM12114',"the 3rd Party value!!");// + "\n\n e.g. 1234" );
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
	                        	parent.sheetObjects[0].SetCellValue(row, 'vndr_cust_div_cd', tpvTmp[0], 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'trd_party_val' , tpvTmp[1], 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'cust_cnt_cd' , '', 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'cust_seq' , '', 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'vndr_cnt_cd' , tpvTmp[2], 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'vndr_seq' , tpvTmp[1], 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'n3pty_ofc_cd', '', 0);
					        } else if ( tpvTmp[0]=="C" ) { // customer 
	                        	parent.sheetObjects[0].SetCellValue(row, 'vndr_cust_div_cd', tpvTmp[0], 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'trd_party_val', tpvTmp[2] + tpvTmp[1], 0); 
	                        	parent.sheetObjects[0].SetCellValue(row, 'cust_cnt_cd', tpvTmp[2], 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'cust_seq', tpvTmp[1], 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'vndr_cnt_cd', '', 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'vndr_seq', '', 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'n3pty_ofc_cd', '', 0);
					        } else if ( tpvTmp[0]=="S" ) { // staff 
	                        	parent.sheetObjects[0].SetCellValue(row, 'vndr_cust_div_cd', tpvTmp[0], 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'trd_party_val', tpvTmp[2], 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'cust_cnt_cd', '', 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'cust_seq', '', 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'vndr_cnt_cd', '', 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'vndr_seq', '', 0);
	                        	parent.sheetObjects[0].SetCellValue(row, 'n3pty_ofc_cd', tpvTmp[2], 0);
					        }
	                    	parent.sheetObjects[0].SetCellEditable(row, "cfm_flg_y", true);
	                    	parent.sheetObjects[0].SetCellValue(row, "cfm_flg_y", "0", 0);
					    } else {
	                    	parent.sheetObjects[0].SetCellValue(row, 'trd_party_val', '', 0); 
	                    	parent.sheetObjects[0].SetCellValue(row, 'cust_cnt_cd', '', 0);
	                    	parent.sheetObjects[0].SetCellValue(row, 'cust_seq', '', 0);
	                    	parent.sheetObjects[0].SetCellValue(row, 'vndr_cnt_cd', '', 0);
	                    	parent.sheetObjects[0].SetCellValue(row, 'vndr_seq', '', 0);
	                    	parent.sheetObjects[0].SetCellValue(row, 'n3pty_ofc_cd', '', 0);

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
	                    	parent.sheetObjects[0].SetCellEditable(row, "cfm_flg_y", false);
	                    	parent.sheetObjects[0].SetCellValue(row, "cfm_flg_y", "0", 0);
					    }
					} else {
	                	parent.sheetObjects[0].SetCellValue(row, 'trd_party_val', '', 0); 
	                	parent.sheetObjects[0].SetCellValue(row, 'cust_cnt_cd', '', 0);
	                	parent.sheetObjects[0].SetCellValue(row, 'cust_seq', '', 0);
	                	parent.sheetObjects[0].SetCellValue(row, 'vndr_cnt_cd', '', 0);
	                	parent.sheetObjects[0].SetCellValue(row, 'vndr_seq', '', 0);
	                	parent.sheetObjects[0].SetCellValue(row, 'n3pty_ofc_cd', '', 0);

	                    var s_vndr_cust_div_cd = ComTrim(parent.sheetObjects[0].GetCellValue(row, 'vndr_cust_div_cd'));
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
	                	parent.sheetObjects[0].SetCellEditable(row, "cfm_flg_y", false);
	                	parent.sheetObjects[0].SetCellValue(row, "cfm_flg_y", "0", 0);
				    }
	            }
				
				try{
					if( ComTrim( parent.sheetObjects[0].GetCellValue(row, 'trd_party_val') ) != '') {
						if( ComTrim(parent.sheetObjects[0].GetCellValue(row, 'vndr_cust_div_cd') ) != "") {
							parent.sheetObjects[0].SetCellEditable(row, "cfm_flg_y", true);
						}
						if(parent.sheetObjects[0].GetCellValue(row, 'curr_cd') == "" || parseFloat(parent.sheetObjects[0].GetCellValue(row, 'cfm_amt')) == 0) {
							parent.sheetObjects[0].SetCellEditable(row, "cfm_flg_y", false);
							parent.sheetObjects[0].SetCellValue(row, "cfm_flg_y", "0", 0);
						}
					} else {
						parent.sheetObjects[0].SetCellEditable(row, "cfm_flg_y", false);
						parent.sheetObjects[0].SetCellValue(row, "cfm_flg_y", "0", 0);
						parent.sheetObjects[0].SetCellValue(row, "trd_party_val", "", 0);
					}
				}catch (e){
				}
			}
		}
	}

	/**
	 * Making combo option
	 *
	 * @param : obj - select object
	 * @param : pValue - value
	 * @param : pText  - text
	 *
	 */
	function ComAddComboItem(obj, pValue, pText )
	{
		//alert("obj===>"+obj+"&pValue===>"+pValue+"&pText===>"+pText);
		if(obj != null )
		{ 
			var optionItem   = document.createElement("option");
			//alert("optionItem===>"+optionItem);
			optionItem.text  = pText;
			optionItem.value = pValue;
			 
			obj.add(optionItem);
		}
	}
</script>
<script language="JavaScript">
<!--
	var codeArr = new Array();
//-->
</script>
<script language="javascript">
	function setupPage(){
		makeCombo('<%=id%>','<%=mode%>','<%=obj%>','<%=all%>','<%=otherObjs%>','<%=row%>')
	}
</script>

<% if( hdiv != null && hdiv != "" && hdiv.length() > 0 ){//2009-09-07

	if (serverException == null) {
		if (rowSet != null) {
			String h_tpb_cd = "";
			StringBuffer h_tpb_cd_buf = new StringBuffer();
			while (rowSet.next()) {
				//h_tpb_cd = h_tpb_cd + hdiv + rowSet.getString(1);
				h_tpb_cd_buf.append(hdiv).append(rowSet.getString(1));
			}
			h_tpb_cd = h_tpb_cd_buf.toString();
			%>
			<script language="JavaScript">
			<!--
				eval("parent.document.all.<%=obj%>").value = "<%=h_tpb_cd%>";
			//-->
			</script>
			<%
		}
	}
%>
	<script language="JavaScript">
	<!--
		var func = "<%=func%>";
		if (func != null && func != '') {
			eval("parent.<%=func%>();");
		}
	//-->
	</script>
<%
}else{ //2009-09-07%>

<%
	if (serverException == null) {
		if (rowSet != null) {
			while (rowSet.next()) {
				%>
				<script language="JavaScript">
				<!--
					codeArr[codeArr.length] = new Array("<%=rowSet.getString(1)%>","<%=rowSet.getString(2)%>"); 
				//-->
				</script>
				<%
			}
		}
	} 
%>
<%}//2009-09-07 %>
