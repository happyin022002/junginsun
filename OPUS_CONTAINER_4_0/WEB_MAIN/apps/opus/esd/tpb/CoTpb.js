/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoTpb.js
*@FileTitle  : TPB common logic script and TPB common message
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	if(msgs == undefined){
		msgs=new Array();
	}
	// TPB message
	msgs['TPB90001'] = '{?msg1}th row  [{?msg2}] differs, so can not make single Invoice.' ;
	msgs['TPB90002'] = 'Maximum number of 3rd Party Billing Case is {?msg1}.' ;	
	msgs['TPB90003'] = 'Non-Adjustmment Request target is included.' ;
	msgs['TPB90004'] = 'Do you want to cancel Adjustment Request of TPB No. {?msg1}?' ;
	msgs['TPB90005'] = 'Selected TPB No. {?msg1} is not Adjustment Requested status.' ;
	msgs['TPB90006'] = 'Selected TPB No. {?msg1} is not Adjustment Requested Office.' ;
	msgs['TPB90007'] = 'Non-Adjustment Request target' ;	
	msgs['TPB90008'] = 'It would be interfaced to ERP that is managing the formal OTS case.\n\n Do you want to process?' ;
	msgs['TPB90009'] = 'Be processed Collection Agency.' ;
	msgs['TPB90010'] = 'Could not {?msg1}anymore.' ;
	msgs['TPB90011'] = 'Non-Invoice Creation target is included.'  ;
	msgs['TPB90012'] = 'Normally processed.' ;
	msgs['TPB90013'] = 'Selected TPB No. {?msg1} items could not be {?msg2}ed.' ;
	msgs['TPB90014'] = 'The service is not available now.';
	msgs['TPB90015'] = 'Please select a kind of 3rd Party.'; 
	msgs['TPB90016'] = 'This code is being used.';
	msgs['TPB90017'] = 'This code is being modified because it had not been used but registered already.';
	msgs['TPB90018'] = 'Could not be interfaced to ERP, because Invoice Version is not Final.';
	msgs['TPB90019'] = 'Selected TPB No. {?msg1} rows could not be processed.\n\n Because there is no regional server information.' ;
	msgs['TPB90020'] = 'Do you want to cancel the selected Invoice No.?' ;
	msgs['TPB90021'] = 'It is impossible to delete Correction Invoice.' ;
	msgs['TPB90022'] = 'Selected TPB No. {?msg1} rows are not target of Adjustment Request.' ;
	msgs['TPB90023'] = 'Entered Office {?msg1} is not TPB Office.' ;
	msgs['TPB90024'] = 'Total Amount is not an integer.' ;
	msgs['TPB90025'] = 'Entered  \'R.O.C To\'  {?msg1} is not TPB Office.' ;
	msgs['TPB90027'] = 'Fax No. is invalid. ' ;
	msgs['TPB90028'] = 'E-mail address is invalid. ' ;
	msgs['TPB90029'] = 'Could not attach file anymore. ' ;
	msgs['TPB90030'] = '(Null)' ; // fileupload
	msgs['TPB90031'] = 'Entered EQ No. is invalid. ' ;
	msgs['TPB90032'] = '{?msg1} must be equal or lesser than {?msg2}.'; 
	msgs['TPB90033'] = '{?msg1} must be equal or greater than {?msg2}.'; 
	msgs['TPB90034'] = '{?msg1} must be smaller than {?msg2}.'; 
	msgs['TPB90035'] = '{?msg1} must be lesser than {?msg2}.';
	msgs['TPB90036'] = 'Do you want to go to Revison screen for Final invoice without Proforma invoice?';
	msgs['TPB90037'] = 'No changes can be made in Final Version!';
	msgs['TPB90038'] = '{?msg2} of {?msg1} is invalid. '; 
	msgs['TPB90039'] = 'B/L manifestation enables to close this TPB case. '; // TES, TRS ... not used
	msgs['TPB90040'] = 'The creation of Total Loss or Disposal Invoice enables to close this TPB case.'; // MNR ... not used
	msgs['TPB90041'] = 'It\'s impossible not in case of TES/TRS/MNR Source.'; // else Source or 3rd party
	msgs['TPB90042'] = 'Please input BKG nbr, C/A nbr or Charge Code in Recovery Activity.'; // TES, TRS & Customer
	msgs['TPB90043'] = 'Please input Credit note nbr & CSR nbr in Recovery Activity.'; // TES, TRS & Service Provider
	msgs['TPB90044'] = 'Please input TTL or Disposal invoice nbr in Recovery Activity.'; // MNR & Customer / Service Provider
	msgs['TPB90045'] = 'There is no valid Message data! '; // Process Close Message 1
	msgs['TPB90046'] = 'Are you sure? \nIt will be finished for Process Close with this Message data!'; // Process Close Message 2
	msgs['TPB90047'] = 'It\'s impossible for Joint Operation(JO) Case!'; // JO Case
	msgs['TPB90048'] = 'It\'s impossible in case of Staff(3rd party).'; // else Source or 3rd party
	msgs['TPB90049'] = 'Please use Process Close function After Deleting the relevant Invoice.'; // process close at Invoice step 
	msgs['TPB90050'] = 'Please use Process Close function After Cancelling request for Adjustment .'; // process close at Adjustment Request step
	msgs['TPB90051'] = 'Please don\'t input your office code as ROC-To Office.'; // process close at Adjustment Request step
	msgs['TPB90052'] = 'It\'s possible for {?msg1} or below TPB counts! '; // Invoice Maximum Detail Count Check
	msgs['TPB90053'] = 'Do you want to cancel this invoice?'; // Invoice 2008; Cancel
	msgs['TPB90054'] = 'Do you want to update this invoice? \n(A new invoice version will be revised.) '; // Invoice 2008; Save-Revise
	msgs['TPB90055'] = 'Do you want to create a invoice? \n(A new invoice of ORG(Original) will be created.) '; // Invoice 2008; Confirm-Create
	msgs['TPB90056'] = 'It is impossible to do Adjustment Request' ; // Adjustment
	msgs['TPB90057'] = 'ERP I/F will be also cancelled. (In fact Credit Note data will be interfaced.)' ; // Adjustment
	msgs['TPB90058'] = 'Do you want to correct this invoice? \nThe last revision will be cancelled. \n\nIf this revision was did ERP I/F, it will be also cancelled. \nIn fact Credit Note data will be interfaced. '; // Invoice 2008; Correction Inv.
	msgs['TPB90059'] = 'Invoice has been cancelled.'; // Invoice 2008; Cancellation Inv
    msgs['TPB90060'] = 'Reason must be input.'; // Adjustment Request
    msgs['TPB90061'] = 'In Write-Off case Preventive Measures must be input.'; // Adjustment Request
    msgs['TPB90062'] = 'Review Result must be input.'; // Adjustment Approval
    msgs['TPB90063'] = 'All Adjustment Types selected must be same.'; // Adjustment Approval
	msgs['TPB90064'] = 'Input TPB No. or Invoice No.'; // At ESD_TPB_111
    msgs['TPB90065'] = 'It could not be remaked due to {?msg1}.' ; // At ESD_TPB_0107
    msgs['TPB90066'] = 'Do you want to remove TPB/Candidate to Non-TPB?' ; // Non-TPB. At ESD_TPB_133
    msgs['TPB90067'] = 'Do you want to eliminate this cancellation notice?' ; // Eliminate. At ESD_TPB_133
    msgs['TPB90068'] = 'It can be only group remaking due to {?msg1}.' ; // At ESD_TPB_0107
    msgs['TPB90069'] = 'Billing Type Code has been duplicated.' ; // At ESD_TPB_0101
    msgs['TPB90070'] = 'Invalid VVD.' ; // TPB Manual Registration. At ESD_TPB_0103
    msgs['TPB90071'] = 'Invalid S/P No.' ; // TPB Manual Registration. At ESD_TPB_0103
    msgs['TPB90072'] = 'VVD Checking - Try again.' ; // EAC Registration. At ESD_TPB_0104
    msgs['TPB90073'] = 'Invalid Office Code or Office Code has been duplicated.' ; // TPB Office Management. At ESD_TPB_0103
    msgs['TPB90074'] = 'We do not have Information about this Equip Number.' ; // TPB Manual Registration. At ESD_TPB_0103
	msgs['TPB90075'] = 'Registering {?msg1} has been completed.';
	msgs['TPB90076'] = 'Please select one at least.';
	msgs['TPB90077'] = 'Please select {?msg1}.';
	msgs['TPB90078'] = 'Please check {?msg1}.';
	msgs['TPB90079'] = 'Invalid Group Selection (max:50)'; // TPB Candidate Confirmation. At ESD_TPB_0105
	msgs['TPB90080'] = 'There is no contents to save.'; // TPB Candidate Confirmation. At ESD_TPB_0105
	msgs['TPB90081'] = 'Check 3rd Party Code.'; // TPB Candidate Confirmation. At ESD_TPB_0105
	msgs['TPB90082'] = 'Invalid - Finance Direction Code.'; // TPB Candidate Confirmation. At ESD_TPB_0105
	msgs['TPB90083'] = 'Invalid Selection - row:{?msg1}'; // S/O Cancelation Notice. At ESD_TPB_0133
	msgs['TPB90084'] = 'Cancel Flag Not Exsit.'; // S/O Cancelation Notice. At ESD_TPB_0133
	msgs['TPB90085'] = "'S/P Invoice No' {?msg1}"; // TPB Manual Registration. At ESD_TPB_0103
	msgs['TPB90086'] = "'S/P' {?msg1}"; // TPB Manual Registration. At ESD_TPB_0103
	msgs['TPB90087'] = "'BKG No' {?msg1}"; // TPB Manual Registration. At ESD_TPB_0103
	msgs['TPB90088'] = "'3rd Party' {?msg1}"; // TPB Manual Registration. At ESD_TPB_0103
	msgs['TPB90089'] = "'3rd Party Value' {?msg1}"; // TPB Manual Registration. At ESD_TPB_0103
	msgs['TPB90090'] = "'3rd Party Name' {?msg1}"; // TPB Manual Registration. At ESD_TPB_0103
	msgs['TPB90091'] = "Can't Save - Nothing changed"; // JO TPB Invoice Revise/Cancel. At ESD_TPB_0127
	msgs['TPB90092'] = "Input valid TPB No."; // JO TPB Invoice Revise/Cancel. At ESD_TPB_0127
	msgs['TPB90093'] = "Administration Charge is not an integer"; // JO TPB Invoice Revise/Cancel. At ESD_TPB_0127
	msgs['TPB90094'] = "Deducted Amount is not an integer"; // JO TPB Invoice Revise/Cancel. At ESD_TPB_0127
	msgs['TPB90095'] = "No result to be revised or cancelled"; // JO TPB Invoice Revise/Cancel. At ESD_TPB_0127
	msgs['TPB90096'] = "Res.Office not assigned : {?msg1}"; // TPB Responsible Office Change. At ESD_TPB_0113
	msgs['TPB90097'] = "Can not control Taxation exclusive of India Office"; // Invoice Creation. At ESD_TPB_0110
	msgs['TPB90098'] = "Period' {?msg1}"; // TPB Group Remaking. At ESD_TPB_0107
	msgs['TPB90099'] = "Already Exist"; //Taxation Control. At ESD_TPB_0812
	msgs['TPB90100'] = "BKG No. is not available"; //TPB Modification. At ESD_TPB_0108
	msgs['TPB90101'] = "B/L No. is not available"; //TPB Modification. At ESD_TPB_0108
	msgs['TPB90102'] = 'Input TPB No.'; // ROC 2nd Review. ESD_TPB_0113
	msgs['TPB90103'] = 'Please don\'t input your office code as Res. Office.';//rocess close at Adjustment Request step AT ESD_TPB_0113

	msgs['TPB90104'] = 'Invalid Office Code.' ; // TPB Office Management. At ESD_TPB_0103
	msgs['TPB90105'] = 'Office Code has been duplicated.' ; // TPB Office Management. At ESD_TPB_0103
	msgs['TPB90106'] = 'Please do not input Head Office or Regional Head Office in TPB Office column or Office column.'; // TPB Office Management. At ESD_TPB_0103

	msgs['TPB90107'] = 'Please input File Upload.';
	msgs['TPB90108'] = 'Please input Remark.'; // ROC 2nd Review. ESD_TPB_0113
	msgs['TPB90109'] = 'Please choose cancel item only when you make cancel request.';
	msgs['TPB90110'] = 'Do you want to cancel?';


	/// Global variables
	var FileUploadPopupWin = null; // File Upload PopupWindow Object
	var TPBFilePath = ""; // file download, file path
	var TPBFileCount = 0; // file download, current file count
	var TPBMaxFileCount = 3; // file download, available maximum file count
	
	/**
	 *  1. Down2Excel 옵션 사용 방법
	 *  sheetObj.Down2Excel(TPBDown2ExcelOptions);
	 *  
	 *  2. Down2Excel 옵션 추가 방법
	 *  TPBDown2ExcelOptions['optionName'] = 'blah blah';
	 *  sheetObj.Down2Excel(TPBDown2ExcelOptions);
	 */
	var TPBDown2ExcelOptions = { HiddenColumn:true, AutoSizeColumn : 1, ExcelFontSize : 10, ExcelRowHeight : "18", Merge: 1, SheetDesign: 1};
	

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
	function getTPBGenCombo(id,method,mode,obj,all,paramName, otherObjs, row) {
		if(mode == undefined) {mode="F";}
		if(obj == undefined) {obj="";}
		if(all == undefined) {all="1";}
		if(paramName == undefined) {
			paramName=new Array();
		} else { 
			try{ eval("document.all."+id).disabled=true; 
			} catch(e) {
			} 
		}
		if(otherObjs == undefined) {otherObjs=""}
		if(row == undefined) {row=""}
		var f= document.getElementsByClassName("frame");
		var ifr="frame_"+f.length;
		var o=document.createElement("DIV");
		o.style.display="none";
		o.innerHTML='<iframe name="'+ifr+'" class="frame" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
		document.body.appendChild(o);
		var param='';
		for(var i=0; i < paramName.length; i++) {
			if(paramName[i] != "") {
				var obj = eval("document.all."+paramName[i]);
				if (obj) {
					param += "&" + paramName[i] + "=" + obj.value;
				}
			}
		}
		if (eval("document."+ifr) == undefined) {
			eval("window."+ifr).location.href="TPBCommonCode.do?id="+id+"&method="+method+"&mode="+mode+"&obj="+obj+"&all="+all+"&"+param+"&otherObjs="+otherObjs+"&row="+row;
		} else {
			eval("document."+ifr).location.href="TPBCommonCode.do?id="+id+"&method="+method+"&mode="+mode+"&obj="+obj+"&all="+all+"&"+param+"&otherObjs="+otherObjs+"&row="+row;
		}
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
	   						parent.sheetObjects[0].SetCellValue(otherObjs,2, codeArr[0][0], 0);
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
						parent.sheetObjects[0].SetCellValue(-1, "eq_no", "", 0);
					}
				} else if ( IdObj=="CheckTPBCode") {
					if(codeArr.length > 0) {
						ComShowCodeMessage('TPB90069');
						parent.sheetObjects[0].SetCellValue(-1, "n3pty_bil_tp_cd", "", 0);
					}
				} else if ( IdObj=="CheckVendorCode") {
					if(codeArr.length <= 0) {
						ComShowCodeMessage('TPB90071');
		    			parent.document.all.s_src_vndr_no.value = "";
		    			parent.document.all.s_src_vndr_no.focus();
					}
				} else if ( IdObj=="CheckEqNo") {
					if(codeArr.length > 0) {
						parent.sheetObjects[0].SetCellValue(-1, "eq_tpsz_cd", codeArr[0][0], 0);
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
						parent.sheetObjects[0].SetCellValue(-1, "ofc_cd", "", 0);
					}
	            } else if ( IdObj=="CheckRegOffice2") {
					if(codeArr.length <= 0) {
						ComShowCodeMessage('TPB90106');
//						parent.sheetObjects[0].SetCellValue(-1, "ofc_cd", "", 0);
					}
	            } else if ( IdObj=="CheckRegOffice3") {
					if(codeArr.length <= 0) {
						ComShowCodeMessage('TPB90104');
//						parent.sheetObjects[0].SetCellValue(-1, "ofc_cd", "", 0);
					}
	            }  else if ( IdObj=="Void_ThirdParty") { // 3rd Party Input directly 
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
			if(prefix == undefined || prefix == null) prefix='';
			//eval('frm.'+prefix+'bkg_no').value       = obj.value.substring(0,11);
			eval('frm.'+prefix+'bkg_no').value=obj.value;
			//eval('frm.'+prefix+'bkg_no_split').value = obj.value.substring(11);
			eval('frm.'+prefix+'bl_no_all').value='';
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
	 * Invoice Sheet Set 팝업을 띄우는 함수
	 *
	 * @param : pN3pty_no - n3pty_no
	 * @param : pN3pty_inv_no - n3pty_inv_no
	 */
	function openInvoiceSheetSetPopup(formObject, pReadOnlyYn, pOfcCd) {
		var theURL="ESD_TPB_0912.do?f_cmd="+SEARCH;
		if ( pReadOnlyYn!=null && pReadOnlyYn!=undefined && pReadOnlyYn=="N" ) {
			theURL += '&ReadOnlyYn='+pReadOnlyYn;
		}
		if ( pOfcCd!=null && pOfcCd!=undefined && pOfcCd!="" ) {
			theURL += '&s_sheet_set_ofc_cd='+pOfcCd;
		}
	    // ComShowMessage( theURL );
		var features="scroll:no;status:no;help:no;dialogWidth:610px;dialogHeight:555px";
		var rtnValue =  ComOpenWindow(theURL,  window,  features , true);
		if(rtnValue != undefined && rtnValue != null && rtnValue.length > 0) {
			if(formObject.s_sheet_set_count != undefined) {
				formObject.s_sheet_set_count.value=1;
			}
			formObject.s_bil_loc.value=rtnValue[0];
			formObject.s_vat_xch_rt.value=rtnValue[1];
		}
	}
	/**
	 * vndr_cust_div_cd 값에 따라 3rd Party를 조회하는 함수
	 *
	 * @param : val - vndr_cust_div_cd
	 */
	function get3rdParty(val, isLayer) {
		if(isLayer == undefined){
			isLayer = true;
		}
		
		var strTrd_party=val;
		if(strTrd_party=='C') {
			ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 470, 'getCustomer', '1,0,1,1,1,1,1,1', isLayer, true);
		} else if(strTrd_party=='S') {
			open3rdPartyPopup(val, isLayer);
		} else if(strTrd_party=='V') {
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 770, 520, 'getVendor', '1,0,1,1,1,1,1,1', isLayer, true);
		} else if(strTrd_party=='SP') {
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 770, 520, 'getVendor_SP', '1,0,1,1,1,1,1,1', isLayer, true);
		} else {
		    //ComShowCodeMessage('TPB90015');
		    //ComShowCodeMessage('TPB90015')
		    ComShowCodeMessage("COM12113" , "a kind of 3rd Party.");
		    //try { document.getElementById("s_vndr_cust_div_cd").focus(); } catch(e) { ComShowMessage(e); } /// set focus
		    try { document.getElementById("s_vndr_cust_div_cd").focus(); } catch(e) { ComShowMessage(e.message); } /// set focus
		}
	}
	/**
	 * 3rd Party Staff 팝업창을 여는 함수
	 */
	function open3rdPartyPopup(val, isLayer) {
		if(isLayer == undefined){
			isLayer = true;
		}
		//var theURL="ESD_TPB_0813.do?title=Select Staff";
	    //ComShowMessage( theURL );
		//var features="scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:440px";
		//var rtnValue =  ComOpenWindow(theURL,  window,  features , isLayer);
		ComOpenPopup('/opuscntr/ESD_TPB_0813.do', 530, 430, 'callback0813', '0,1,1,1,1,1,1,1', isLayer, true);
		
	}
	
	function callback0813(rtnValue){
		if(rtnValue != undefined && rtnValue != null ) {
	    	document.all.s_trd_party_val.value=rtnValue;
	    	if(document.all.s_trd_party_nm != null) {
	    		document.all.s_trd_party_nm.value=rtnValue;
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
		var strTrd_party=val;
		if(strTrd_party=='C') {
			ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 470, 'getCustomer_sheet', '1,0,1,1,1,1,1,1',Row,Col);
		} else if(strTrd_party=='S') {
			// ComOpenPopup('/opuscntr/COM_ENS_091.do', 770, 600, 'getStaff_sheet', '1,0,1,1,1,1,1,1',Row,Col, false, true);
			open3rdPartyPopup_sheet(val, Row, Col, sheetObj);
		} else if(strTrd_party=='V') {
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 770, 450, 'getVendor_sheet', '1,0,1,1,1,1,1,1',Row,Col);
		} else {
			ComShowCodeMessage('TPB90015'); 
		    try { sheetObj.SelectCell(Row, "vndr_cust_div_cd"); } catch(e) { ComShowMessage(e.message); } /// set focus
		}
	}
	/**
	 * 3rd Party Staff 팝업창을 여는 함수
	 * sheet에서 호출시 사용
	 */
	function open3rdPartyPopup_sheet(val, row, col, sheetObj) {
		var theURL="ESD_TPB_0813.do?title=Select Staff";
	    // ComShowMessage( theURL );
		var features="scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:510px";
		var rtnValue =  ComOpenWindow(theURL,  window,  features , true);
		if(rtnValue != undefined && rtnValue != null ) {
			// document.form.stl_to_clt_cng_ofc_cd.value = rtnValue;
	    	sheetObj.SetCellValue(row, col,rtnValue,0);
	    	sheetObj.SetCellValue(row, 'n3pty_ofc_cd',rtnValue,0);
	    	sheetObj.SetCellValue(row, 'cust_cnt_cd','',0);
	    	sheetObj.SetCellValue(row, 'cust_seq','',0);
	    	sheetObj.SetCellValue(row, 'vndr_cnt_cd','',0);
	    	sheetObj.SetCellValue(row, 'vndr_seq','',0);
	        document.all.s_trd_party_val.value=rtnValue;
	        document.all.s_vndr_cust_div_cd.value="S";
	    	getThirdParySheetAfter(sheetObj, row);
		}
	}
	/**
	 * 검색으로 쓰이는 vndr_cust_div_cd 값에 따라 3rd Party를 조회하는 함수 
	 *
	 * @param : val - vndr_cust_div_cd
	 */
	function get3rdPartyToSearch(val) {
		var strTrd_party=val;
		if(strTrd_party=='C') {
			ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 470, 'getCustomerToSearch', '1,0,1,1,1,1,1,1', true);
		} else if(strTrd_party=='S') {
			// comPopupWith2ndSheet('/opuscntr/COM_ENS_091.do', 770, 550, 'getStaffToSearch', '1,0,1,1,1,1,1,1');
			open3rdPartyPopupToSearch(val);
		} else if(strTrd_party=='V') {
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 770, 500, 'getVendorToSearch', '1,0,1,1,1,1,1,1', true);
//		} else if(strTrd_party=='SP') {
//			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 690, 450, 'getVendor_SP', '1,0,1,1,1,1,1,1');
		} else {
			ComShowCodeMessage('TPB90015'); 
		    try { document.getElementById("s_vndr_cust_div_cd").focus(); } catch(e) { ComShowMessage(e.message); } /// set focus
		}
	}
	/**
	 * 검색용 3rd Party Staff 팝업창을 여는 함수
	 */
	function open3rdPartyPopupToSearch(val) {
		var theURL="ESD_TPB_0813.do?title=Select Staff";
		ComOpenPopup(theURL, 470, 450, "findCommodity", "0,1,1", true);
	}

    function findCommodity(val) {
         form.s_trd_party_val.value = val;
    }
	  
	///**
	// * vndr_cust_div_cd 값에 따라 3rd Party를 조회하는 함수
	// * Adjustment UI에서 사용
	// *
	// * @param : val - vndr_cust_div_cd
	// */
	//function get3rdPartyStl(val) {
//		var strTrd_party = val;
	//
//		if(strTrd_party=='C') {
//			comPopup('/opuscntr/COM_ENS_041.do', 770, 470, 'getCustomerStl', '1,0,1,1,1,1,1,1');
//		} else if(strTrd_party=='S') {
//			comPopupWith2ndSheet('/opuscntr/COM_ENS_091.do', 770, 550, 'getStaffStl', '1,0,1,1,1,1,1,1');
//		} else if(strTrd_party=='V') {
//			comPopup('/opuscntr/COM_ENS_0C1.do', 620, 450, 'getVendorStl', '1,0,1,1,1,1,1,1');
//		} else {
//		    ComShowCodeMessage('TPB90015' ); 
//		    try { document.getElementById("s_vndr_cust_div_cd").focus(); } catch(e) { ComShowMessage(e); } /// set focus
//		}
	//}
	/**
	 * VVD popup close시 호출되는 함수
	 *
	 */
	function getVVD(rArray) {
		var cArray=rArray[0];
		document.all.s_vvd.value=cArray[7];
		document.all.s_vvd.focus();
	}
	/**
	 * Location popup close시 호출되는 함수
	 *
	 */
	function getLocation(rArray) {
		var cArray=rArray[0];
		document.all.s_yd_cd.value=cArray[3];
	}
	/**
	 * 3rd Party Customer popup close시 호출되는 함수
	 */
	function getCustomer(rArray) {
		var cArray=rArray[0];
		document.all.s_trd_party_val.value=cArray[3];
		if(document.all.s_trd_party_nm != null) {
			document.all.s_trd_party_nm.value=cArray[4];
		}
		s_trd_party_val_OnBlur('C', true);
	}
	/**
	 * 3rd Party Staff popup close시 호출되는 함수
	 *
	 */
	function getStaff(rArray) {
	    // var z="";  for(var i=0; rArray!=null && i<rArray.length; i++) { z+= i + " : " + rArray[i] + "\n";}  ComShowMessage(z);
		var cArray=rArray[0];
		document.all.s_trd_party_val.value=cArray[3];
		if(document.all.s_trd_party_nm != null) {
			document.all.s_trd_party_nm.value=cArray[3];
		}	
		s_trd_party_val_OnBlur('S', true);
	}
	/**
	 * 3rd Party Vendor popup close시 호출되는 함수
	 *
	 */
	function getVendor(rArray) {
		var cArray=rArray[0];
		document.all.s_trd_party_val.value=cArray[2]; // +cArray[2]; 20140827 주석처리 => 왜 더하고 있을까?
		if(document.all.s_trd_party_nm != null) {
			document.all.s_trd_party_nm.value=cArray[4];
		}
		s_trd_party_val_OnBlur('V', true);
	}
	/**
	 * 3rd Party Customer popup close시 호출되는 함수
	 */
	function getCustomerToSearch(rArray) {
		var cArray=rArray[0];
		document.all.s_trd_party_val.value=cArray[3];
		
		if(document.all.s_trd_party_nm != undefined) document.all.s_trd_party_nm.value=cArray[4];
//		 s_trd_party_val_OnBlur('C', true);
	}
	/**
	 * 3rd Party Staff popup close시 호출되는 함수
	 *
	 */
	function getStaffToSearch(rArray) {
		var cArray=rArray[0];
		document.all.s_trd_party_val.value=cArray[3];
		if(document.all.s_trd_party_nm != undefined) document.all.s_trd_party_nm.value=cArray[4];
//		 s_trd_party_val_OnBlur('S', true);
	}
	/**
	 * 3rd Party Vendor popup close시 호출되는 함수
	 *
	 */
	function getVendorToSearch(rArray) {
		try{
	        var cArray=rArray[0];
		    var temp=cArray[2];
		    var tmp1=temp;
		    var tmp2="";
		    for(var k=0; k<temp.length; k++) {
		        tmp2=tmp1.substring(0,1);
		        if ( tmp2=="0" ) {
		            tmp1=tmp1.substring(1);
		        } else {
		            temp=tmp1;
		            break; 
		        }
		    }
			document.all.s_trd_party_val.value=temp;
			if(document.all.s_trd_party_nm != undefined) document.all.s_trd_party_nm.value=cArray[4];
		} catch(e) {
		    // ComShowMessage(e);
		}
//		 s_trd_party_val_OnBlur('V', true);
	}
	/**
	 * 3rd Party Vendor popup close시 호출되는 함수, Service Provider
	 *
	 */
	function getVendor_SP(rArray) {
		var cArray=rArray[0];
		document.all.s_src_vndr_no.value=cArray[2];
		document.all.s_src_vndr_cnt_cd.value=cArray[8];
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
		var slength=(""+str).length;
		var s="";
		for (i=0 ; i < icount - slength ; i++)
		{
			s=s + "0";
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
		date=new Date();
		if ( delm==null || delm==undefined ) {
			delm="";
		}
		var y=date.getFullYear();
		var m=date.getMonth();
		var d=date.getDate();
		if ( unit=="Y" ) { y+= val; }
		if ( unit=="M" ) { m+= val; }
		if ( unit=="D" ) { d+= val; }
		date=new Date(y,m,d);
		y=date.getFullYear();
		m=date.getMonth() + 1;
		d=date.getDate();
		return y + delm + getZero(m,2) + delm + getZero(d,2);
	}
	///**
	// * 3rd Party Customer popup close시 호출되는 함수
	// * Adjustment UI에서 사용
	// */
	//function getCustomerStl(rArray) {
//		var cArray = rArray[0];
//		document.all.s_trd_party_val.value = cArray[3];
	//}
	///**
	// * 3rd Party Staff popup close시 호출되는 함수
	// * Adjustment UI에서 사용
	// */
	//function getStaffStl(rArray) {
//		var cArray = rArray[0];
//		document.all.s_trd_party_val.value = cArray[3];
	//}
	///**
	// * 3rd Party Vendor popup close시 호출되는 함수
	// * Adjustment UI에서 사용
	// */
	//function getVendorStl(rArray) {
//		var cArray = rArray[0];
//		document.all.s_trd_party_val.value = cArray[7]+cArray[2];
	//}
	/**
	 * 3rd Party input box 에서 OnFocus시 호출하는 함수
	 */
	function s_trd_party_val_OnFocus() {
		var divCd=document.all.s_vndr_cust_div_cd.value;
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
			divCd=document.all.s_vndr_cust_div_cd.value;
		}
		if(fromPopupYn == undefined) {
			fromPopupYn=false;
		}
		if ( fromPopupYn ) { // from Popup
	    	if(divCd == 'V') {
	    		if(document.all.s_trd_party_val.value.length > 6) {
	    			document.all.s_vndr_cnt_cd.value=document.all.s_trd_party_val.value.substring(0,2);
	    			document.all.s_vndr_seq.value=document.all.s_trd_party_val.value.substring(2);
	    			try{
	    			    var temp=document.all.s_trd_party_val.value.substring(2);
	    			    var tmp1=temp;
	    			    var tmp2="";
	    			    for(var k=0; k<temp.length; k++) {
	    			        tmp2=tmp1.substring(0,1);
	    			        if ( tmp2=="0" ) {
	    			            tmp1=tmp1.substring(1);
	    			        } else {
	    			            temp=tmp1;
	    			            break; 
	    			        }
	    			    }
	          			document.all.s_vndr_seq.value=temp;
	          			document.all.s_trd_party_val.value=temp;
	    			} catch(e) {
	    			    // ComShowMessage(e);
	    			}
	    		} else {
	                document.all.s_vndr_seq.value=document.all.s_trd_party_val.value;
	    		}
	    		document.all.s_cust_cnt_cd.value='';
	    		document.all.s_cust_seq.value='';	
	    		document.all.s_n3pty_ofc_cd.value='';
	    	} else if(divCd == 'C') {
	    		document.all.s_cust_cnt_cd.value=document.all.s_trd_party_val.value.substring(0,2);
	    		document.all.s_cust_seq.value=document.all.s_trd_party_val.value.substring(2);					
	    		document.all.s_n3pty_ofc_cd.value='';
	    		document.all.s_vndr_cnt_cd.value='';
	    		document.all.s_vndr_seq.value='';
	    	} else if(divCd == 'S') {
	    		document.all.s_n3pty_ofc_cd.value=document.all.s_trd_party_val.value;
	    		document.all.s_cust_cnt_cd.value='';
	    		document.all.s_cust_seq.value='';
	    		document.all.s_vndr_cnt_cd.value='';
	    		document.all.s_vndr_seq.value='';
	    	}
	        document.all.s_vndr_cust_div_cd.value=divCd; 
	    	if(document.all.s_trd_party_nm != null && document.all.s_trd_party_val.value == "") {
	    		document.all.s_trd_party_nm.value="";
	    	}
	        if ( divCd=="V" || divCd=="C" || divCd=="S" ) { // Added in 2008-03-06 
	            if ( s_trd_party_val_OnBlur_ToSearch() ) {
	              // server side로부터 가져와서 getTPBGenCombo 함수이하에서 직접 처리함 
	              getTPBGenCombo('Void_ThirdParty','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd")); 
	            }
	        } 
		} else { // from Direct Input
		    var tpbVal=document.all.s_trd_party_val.value; 
		    tpbVal=ComTrim(tpbVal);
		    document.all.s_trd_party_val.value=tpbVal;
		    if ( tpbVal.length==0 ) { // 3rd party value가 없으면 
	    		document.all.s_trd_party_val.value='';
	    		try {
	    			document.all.s_trd_party_nm.value=''; 
	    		} catch(e) {
	    		}
	    		document.all.s_cust_cnt_cd.value='';
	    		document.all.s_cust_seq.value='';
	    		document.all.s_vndr_cnt_cd.value='';
	    		document.all.s_vndr_seq.value='';
	    		document.all.s_n3pty_ofc_cd.value='';
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
		var divCd=document.all.s_vndr_cust_div_cd.value;
	    var tpbVal=document.all.s_trd_party_val.value;  // ComShowMessage(tpbVal);
	    tpbVal=ComTrim(tpbVal); // ComShowMessage(tpbVal);
	    document.all.s_trd_party_val.value=tpbVal;
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
	                temp=tpbVal.substring(0);
	            } else {
	                temp=tpbVal.substring(0,2);
	            }
	            if ( temp.length!=2 || !ComIsAlphabet(temp) ) {
	            	ComShowCodeMessage('COM12114',"the 3rd Party format!!! \n\n e.g. KR1234"  );
	                document.all.s_trd_party_val.focus();
	                document.all.s_trd_party_val.select();
	                return false;
	            }
	            // customer sequence 
	            if ( tpbVal.length > 2) {
	                temp=tpbVal.substring(2);
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
		var formObj=document.form;
		formObj.s_trd_party_val.value="";
		formObj.s_cust_cnt_cd.value="";
		formObj.s_cust_seq.value="";
		formObj.s_vndr_cnt_cd.value="";
		formObj.s_vndr_seq.value="";
		formObj.s_n3pty_ofc_cd.value="";
		if(formObj.s_trd_party_nm != null) {
			formObj.s_trd_party_nm.value="";
		}
		var divCd=formObj.s_vndr_cust_div_cd.value;
		if( divCd=="C" || divCd=="V" || divCd=="S") {
	        try {
	        	formObj.s_trd_party_val.focus();
	        }
	        catch(e) { 
	        	ComShowMessage(e.message);
	        } 
		}
	}
	/**
	 * 검색용 3rd Party 선택 콤보리스트에서 호출하는 함수
	 *
	 */
	function s_vndr_cust_div_cd_OnChange_ToSearch() {
		var formObj=document.form;
		formObj.s_trd_party_val.value='';
		var divCd=document.all.s_vndr_cust_div_cd.value;
		if( divCd=="C" || divCd=="V" || divCd=="S") {
	        try { document.getElementById("s_trd_party_val").focus(); } catch(e) { ComShowMessage(e.message); } /// set focus
		}
	}
	/**
	 * 3rd Party Customer popup close시 호출되는 함수
	 * Sheet에서 popup 호출하였을 경우
	 */
	function getCustomer_sheet(rArray, row, col) {
		var sheetObj=sheetObjects[0];
		var colArray=rArray[0];
		sheetObj.SetCellValue(row, col,colArray[3],0);
		sheetObj.SetCellValue(row, 'cust_cnt_cd',colArray[3].substring(0,2),0);
		sheetObj.SetCellValue(row, 'cust_seq',colArray[3].substring(2),0);
		sheetObj.SetCellValue(row, 'n3pty_ofc_cd','',0);
		sheetObj.SetCellValue(row, 'vndr_cnt_cd','',0);
		sheetObj.SetCellValue(row, 'vndr_seq','',0);
		try {	
			document.all.s_trd_party_val.value=colArray[3];
			document.all.s_vndr_cust_div_cd.value="C";
		} catch(e) {
			e=null;
		}
		getThirdParySheetAfter(sheetObj, row);
	}
	/**
	 * 3rd Party Staff popup close시 호출되는 함수
	 * Sheet에서 popup 호출하였을 경우
	 */
	function getStaff_sheet(rArray, row, col) {
		var sheetObj=sheetObjects[0];
		var colArray=rArray[0];
		sheetObj.SetCellValue(row, col,colArray[3],0);
		sheetObj.SetCellValue(row, 'n3pty_ofc_cd',colArray[3],0);
		sheetObj.SetCellValue(row, 'cust_cnt_cd','',0);
		sheetObj.SetCellValue(row, 'cust_seq','',0);
		sheetObj.SetCellValue(row, 'vndr_cnt_cd','',0);
		sheetObj.SetCellValue(row, 'vndr_seq','',0);
		try {	
			document.all.s_trd_party_val.value=colArray[3];
			document.all.s_vndr_cust_div_cd.value="C";
		} catch(e) {
			e=null;
		}
		getThirdParySheetAfter(sheetObj, row);
	}
	/**
	 * 3rd Party Vendor popup close시 호출되는 함수
	 * Sheet에서 popup 호출하였을 경우
	 */
	function getVendor_sheet(rArray, row, col) {
		var sheetObj=sheetObjects[0];
		var colArray=rArray[0];
		var tempVal="";
		sheetObj.SetCellValue(row, col,colArray[2],0);
		//sheetObj.CellValue2(row, 'vndr_cnt_cd') = colArray[2].substring(0,2);
		sheetObj.SetCellValue(row, 'vndr_cnt_cd',colArray[7],0);// ComShowMessage(colArray[7]);
		sheetObj.SetCellValue(row, 'vndr_seq',colArray[2],0);
		try{
		    var temp=colArray[2];
		    var tmp1=temp;
		    var tmp2="";
		    for(var k=0; k<temp.length; k++) {
		        tmp2=tmp1.substring(0,1);
		        if ( tmp2=="0" ) {
		            tmp1=tmp1.substring(1);
		        } else {
		            temp=tmp1;
		            break; 
		        }
		    }
			sheetObj.SetCellValue(row, 'vndr_seq',temp,0);
			sheetObj.SetCellValue(row, col,temp,0);
			tempVal=temp;
		} catch(e) {
		    // ComShowMessage(e);
		}	
		sheetObj.SetCellValue(row, 'n3pty_ofc_cd','',0);
		sheetObj.SetCellValue(row, 'cust_cnt_cd','',0);
		sheetObj.SetCellValue(row, 'cust_seq','',0);
		try {	
			document.all.s_trd_party_val.value=tempVal;
			document.all.s_vndr_cust_div_cd.value="V";
		} catch(e) {
			e=null;
		}
		getThirdParySheetAfter(sheetObj, row);
	}
	/**
	 * 3rd Party popup 호출 후 처리 
	 */
	function getThirdParySheetAfter(sheetObj, Row) {
	    try { 
	    	if( ComTrim( sheetObj.GetCellValue(Row, 'trd_party_val') ) != '') {
	    		if( ComTrim(sheetObj.GetCellValue(Row, 'vndr_cust_div_cd') ) != "") {
	    			sheetObj.SetCellEditable(Row, "cfm_flg_y",1);
	                getTPBGenCombo('Void_ThirdParty_Sheet','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd"), Row); // Added In 2008-03-07
	    		}
	    		if(sheetObj.GetCellValue(Row, 'curr_cd') == "" || parseFloat(sheetObj.GetCellValue(Row, 'cfm_amt')) == 0) {
	    			sheetObj.SetCellEditable(Row, "cfm_flg_y",0);
	    			sheetObj.SetCellValue(Row, "cfm_flg_y","0",0);
	    		}
	    	} else {
	    		sheetObj.SetCellEditable(Row, "cfm_flg_y",0);
	    		sheetObj.SetCellValue(Row, "cfm_flg_y","0",0);
	    		sheetObj.SetCellValue(Row, "trd_party_val","",0);
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
		var sheetObj=sheetObjects[0];
		var colArray=rArray[0];
		sheetObj.SetCellValue(row, col,colArray[7],0);
	}
//2011.02.22 변종건 파일업로드 관련 제거
//	//===== TPB FileUpload 관련 호출 ===============================================
//	/**
//	 * FileUpload 팝업을 띄우는 함수
//	 * @param : fileNo - fileNo
//	 * @param : targetFnc -  opener에서 fileNo값을 받을 대상
//	 */
	
	function openFileUploadPopup(fileNo, targetFnc, downloadLink, authYn, tpbNo, invNo) {
		if ( FileUploadPopupWin!=null && FileUploadPopupWin!=undefined ) {
			try {
				FileUploadPopupWin.forcedClose = true; // 강제로 닫는다고 설정
				FileUploadPopupWin.close();
				FileUploadPopupWin = null;
			} catch(e) {
				
			}
		}
	    
		var theURL = "TPBFileUpload.do?fileNo="+fileNo+"&targetFnc="+targetFnc;
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
	    
		var winName = "TPBFileUpload";
//		var features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=314,height=400";
//		FileUploadPopupWin = ComOpenWindow(theURL,winName,features);
//		var features = "scroll:no;status:no;help:no;dialogWidth:320px;dialogHeight:430px";
//		var rtnValue = window.showModalDialog(theURL, window, features);
		
//		ComOpenWindow(theURL,  window,  "scroll:no;status:no;help:no;dialogWidth:320px;dialogHeight:430px" , true);
		var dispaly="0,1,1,1,1,1,1,1,1,1,1,1"; 
		ComOpenPopup(theURL, 720, 460, targetFnc, dispaly, true);
//		ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll, addHeight) {
		
	}
	
//2011.02.22 변종건 파일업로드 관련 제거
//	/**
//	 * FileUpload 모달팝업을 띄우는 함수
//	 * @param : fileNo - fileNo
//	 * @param : targetFnc -  opener에서 fileNo값을 받을 대상
//	 */
//	function openFileUploadModalPopup(fileNo, targetFnc, downloadLink, authYn, tpbNo, invNo) {
//	    
//		var theURL = "TPBFileUpload.do?fileNo="+fileNo+"&f_cmd="+SEARCH+"&targetFnc="+targetFnc;
//	    if ( downloadLink!=null && downloadLink!=undefined ) { 
//	       theURL += "&downloadLink="+downloadLink;
//	    }
//	    if ( authYn!=null && authYn!=undefined ) { 
//	       theURL += "&authYn="+authYn;
//	    }
//	    if ( tpbNo!=null && tpbNo!=undefined ) { 
//	       theURL += "&tpbNo="+tpbNo;
//	    }
//	    if ( invNo!=null && invNo!=undefined ) { 
//	       theURL += "&invNo="+invNo;
//	    }
//	    theURL += "&modalWindow=Y";
//	    
////		var winName = "TPBFileUpload";
//		// var features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=314,height=400";
//	   	var features = "scroll:no;status:no;help:no;dialogWidth:320px;dialogHeight:430px";
//		// FileUploadPopupWin = ComOpenWindow(theURL,winName,features);
//	   	//alert("theURL==>"+theURL);
//	   	//alert("window==>"+window);
//	   	//alert("features==>"+features);
//	   	var rtnValue = window.showModalDialog(theURL, window, features);
//	   	//alert("rtnValue===>"+rtnValue);
//	   	
//	   	return rtnValue;
//	}
//2011.02.22 변종건 파일업로드 관련 제거
//	/**
//	 * fileDownload 함수
//	 * @param : physicalFileNm - 물리 파일명(시스템)
//	 * @param : logicalFileNm - 논리 파일명(사용자)
//	 * @param : filePlace -  물리 파일저장 경로
//	 * @param : fileRepositoryId - // file-meta 정보  ID (설정파일의 file-id)
//	 */
//	function fileDownLoad(physicalFileNm, logicalFileNm, filePlace, fileRepositoryId, fileKey) {
//		if ( fileRepositoryId == null || fileRepositoryId == undefined || fileRepositoryId.length == 0 ) { 
//			fileRepositoryId = "TPB";
//		}
//		//ComShowMessage(" physicalFileNm : "+physicalFileNm+"\n logicalFileNm : "+logicalFileNm+"\n filePlace  : "+filePlace+"\n fileRepositoryId : "+fileRepositoryId+"\n fileKey : "+fileKey);
//
//		///----- iframe 생성 -----
//		var o1 = document.createElement("DIV");
//		var f = document.frames;
//		var ifr = "frame_"+f.length;
//		o1.style.display = "none";
//		o1.innerHTML = '<iframe name="'+ifr+'" scrolling="no" frameborder="10" width="0" height="0"></iframe>';
//		document.body.appendChild(o1);
//
//		///----- form 생성 -----
//		var o2 = document.createElement("DIV");
//		var formArr = document.forms;
//		var formObj = "downFrm_"+formArr.length;
//		o2.style.display = "none";
//		formStr = "";
//		formStr += "<form method='post' name='"+formObj+"' target='"+ifr+"' action='/opuscntr/FileDownload' >"; /// Action : FileDownload Servlet
//		formStr += "<input type='hidden' name='fileId'>"; //실제 물리 파일명( 저장되어있는 )
//		formStr += "<input type='hidden' name='fileDir'>"; // 파일이 저장되어있는 경로
//		formStr += "<input type='hidden' name='orgFilename'>"; // 논리 파일명 ( 사용자가 다운로드 받을 명칭 )
//		formStr += "<input type='hidden' name='repoId'>"; // file-meta 정보  ID 
//		formStr += "<input type='hidden' name='key'>"; // file key
//		formStr += "<input type='hidden' name='downloadLocation'>"; // downloadLocation
//		formStr += "<input type='hidden' name='stringFile'>"; // stringFile
//		formStr += "</form>";
//		o2.innerHTML = formStr;
//		document.body.appendChild(o2);
//
//		///----- submit, download servlet Call -----
//		document.forms[formObj].fileId.value = physicalFileNm;  //실제 물리 파일명( 저장되어있는 )
//		document.forms[formObj].orgFilename.value = logicalFileNm; // 논리 파일명 ( 사용자가 다운로드 받을 명칭)
//		document.forms[formObj].fileDir.value = filePlace;  // 파일이 저장되어있는 경로
//		document.forms[formObj].repoId.value = fileRepositoryId; // file-meta 정보  ID 
//		document.forms[formObj].key.value = physicalFileNm; // file key
//		document.forms[formObj].downloadLocation.value = filePlace; // downloadLocation
//		document.forms[formObj].stringFile.value = logicalFileNm; // stringFile
//		document.forms[formObj].submit();
//		document.forms[formObj].reset();
//	}
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
		var expTextNames=new Array("s_if_rmk","s_cfm_rmk","stl_rqst_rmk","p_stl_apro_rmk","s_inv_rmk1","s_inv_rmk2","s_inv_rmk1","s_inv_rmk2","s_clt_agn_rmk","s_n3pty_src_no","s_ofc_addr","s_usr_inp_ctnt1","s_usr_inp_ctnt2","s_vndr_cust_addr","s_cty_nm","s_ste_cd","s_zip_cd");
		var expSheetNames=new Array("cfm_rmk","if_rmk","act_rmk","n3pty_bil_tp_nm","n3pty_bil_tp_desc","cntc_pson_nm","upd_usr_id");
		var rtnVal=false;
		if ( type=="text" ) {
			for ( var i=0; i<expTextNames.length; i++ ) {
				if ( val == expTextNames[i] ) {
					rtnVal=true;
					break; 
				}
			}
		} else if ( type=="sheet" ) {
			for ( var i=0; i<expSheetNames.length; i++ ) {
				if ( val == expSheetNames[i] ) {
					rtnVal=true;
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
		var argv=_txt_onkeyup.arguments;
		var argc=argv.length;
		if ( argc > 0 && argv[0]!=undefined && argv[0]!=null && argv[0].length>0 ) {
			document.getElementById(argv[0]).value=document.getElementById(argv[0]).value.toUpperCase();
		}
		argv=null;
	}
	/**
	 * IBSheet 개체 Cell의 입력값을 onchange 이벤트 발생시에 대문자로 변환하는 함수
	 * @param : sheet object
	 * @param : Row
	 * @param : Col
	 */	
	function _sheet_onchange() { /// sheetObj, Row, Col
		var argv=_sheet_onchange.arguments;
		var argc=argv.length; 
		var sheetObj=argv[0];
		if ( argc > 0 && sheetObj!=undefined && sheetObj!=null ) {
			var Row=argv[1];
			var Col=argv[2];
			if ( Row!=undefined && Row!=null && Row >=0 && Col!=undefined && Col!=null && Col >=0 ) {
				if ( !_exceptCheck("sheet", sheetObj.ColSaveName(Col) ) ) {
		if ( sheetObj.GetCellProperty(0, sheetObj.ColSaveName(Col), dpDataType)  == dtData ) {
			sheetObj.SetCellValue(Row, Col, ( isNaN(sheetObj.GetCellValue(Row, Col)) ? sheetObj.GetCellValue(Row, Col).toUpperCase() : sheetObj.GetCellValue(Row, Col)) ,0);
					}
				}
			}
		}
		argv=null;
	}
	/**
	 * document내 input type=text 개체를 onkeyup 이벤트 발생시에 대문자로 변환되도록 이벤트와 함수를 연결하여 초기화 하는 함수
	 */	
	function _text_ChangeUpperCase() {
		var txtName="";
		for (var i=0; i<document.all.length; i++) {
			if ( document.all[i].type == "text" ) {
				txtName=document.all[i].name; 
				if ( !_exceptCheck("text", txtName) && txtName!=""  ) {
					eval( "document.getElementById('"+txtName+"').onkeyup=function() { _txt_onkeyup('"+txtName+"'); }" );
				}
			} else if ( document.all[i].classid == "CLSID:C838E9DA-1625-4E14-8B37-C6706B43C423") {
				var id=document.all[i].name; 
				if ( id == undefined || id == null || id == "" ) { id=document.all[i].id; }
				try{
					if ( ComFuncCheck( id+"_OnChange") && eval( id+"_OnChange").length > 0 ) {
					} else {
						eval( id+"_OnChange=function(sheetObj,Row,Col,Value) { _sheet_onchange( sheetObj,Row,Col,Value ); } " );
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
		var exec=true;
		if(row_idx == undefined || row_idx == "" || row_idx == null) row_idx=0;
		if(header_cnt == undefined) header_cnt=1;
		if(exec) {
			if(row_idx == 0) {
				for(var i=header_cnt;i<=sheetObj.RowCount()+(header_cnt-1);i++) {
if(sheetObj.GetCellValue(i, auto_update_cnt_idx) > 0) {
						sheetObj.SetCellBackColor(i, ots_amt_idx,"#FFFF00");
//parameter changed[check again]CLT 						sheetObj.SetCellFontColor(i, ots_amt_idx,"#FF0000");
//parameter changed[check again]CLT 						sheetObj.SetRangeFontBold(i, ots_amt_idx,1);
					}
				}
			} else {
if(sheetObj.GetCellValue(row_idx, auto_update_cnt_idx) > 0) {
					sheetObj.SetCellBackColor(row_idx, ots_amt_idx,"#FFFF00");
//parameter changed[check again]CLT 					sheetObj.SetCellFontColor(row_idx, ots_amt_idx,"#FF0000");
//parameter changed[check again]CLT 					sheetObj.SetRangeFontBold(row_idx, ots_amt_idx,1);
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
		if(sumInvAmt == undefined || sumInvAmt == null) sumInvAmt=parseFloat(ComGetUnMaskedValue(document.form.s_net_amt.value,"float"));
		if(isModify == undefined) isModify=false;
		var tvaChecked=document.form.s_vat_xch_rt_chk.checked;
		var s_vat_xch_rt=document.form.s_vat_xch_rt.value;
		var s_vat_amt=document.form.s_vat_amt.value;
//		if(!tvaChecked) {
//			document.form.s_vat_amt.readOnly = true;
//			document.all.s_vat_amt.className = "noinput";
//		} else {
//			document.form.s_vat_amt.readOnly = false;
//			document.all.s_vat_amt.className = "";
//		}
		var tvaAmt=0;
		if(isModify) {
			if(ComIsNumber(document.form.s_vat_amt)) {
				if(parseFloat(ComGetUnMaskedValue(s_vat_amt,"float")) > 0) {
					tvaAmt=ComRound(parseFloat(ComGetUnMaskedValue(s_vat_amt,"float")));
				}
			} else {
				tvaAmt=0;
			}
		} else {
			if(tvaChecked && s_vat_xch_rt != "") {
				tvaAmt=ComRound(parseFloat(sumInvAmt) * parseFloat(s_vat_xch_rt)/100);
			} else {
				tvaAmt=0;
				//if(document.form.s_vat_amt.value != "") {
				//	tvaAmt = parseFloat(ComClearSeparator(document.form.s_vat_amt.value,","));
				//}
			}
		}
		var totalAmt=ComRound(parseFloat(sumInvAmt) + parseFloat(tvaAmt));
		document.form.s_net_amt.value=ComAddComma2(sumInvAmt+"","#,###.00");
		document.form.s_vat_amt.value=ComAddComma2(tvaAmt+"","#,###.00");
		document.form.s_total_amt.value=ComAddComma2(totalAmt+"","#,###.00");
	}
	/*
	 * 3rd party 콤보 리스트에서 staff 은 삭제 (invoice관련 검색조건의 경우)
	 */
	function tpb_3rdPartyStaffClear(obj) {
		if(obj != null && obj !=undefined && obj.length > 0)
		{
			for(var i=obj.length ; i >= 0; i--)
			{
				if(obj.options[i-1].value == 'S') {
					obj.remove(i-1);
					break;
				}
			}
		}
	}
	var G_tmp_obj = "";
	function Tmp_3rdPartyTarget_obj(sheet, row, col, id1, id2){
		this.sheet = sheet;
		this.row = row;
		this.col = col;
		this.id1 = id1;
		this.id2 = id2;
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
	function get3rdPartyTarget_sheet(val, Row, Col, sheetObj, id1, id2, title) {
		var strTrd_party=val;
		if(strTrd_party=='C') {
			ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 470, 'getCustomer_sheet', '1,0,1,1,1,1,1,1', true, false, Row, Col);
		} else if(strTrd_party=='S') {
			// ComOpenPopup('/opuscntr/COM_ENS_091.do', 770, 600, 'getStaff_sheet', '1,0,1,1,1,1,1,1', Row, Col, false, true);
			G_tmp_obj = new Tmp_3rdPartyTarget_obj(sheetObj, Row, Col, id1, id2);
			open3rdPartyTargetPopup_sheet(val, Row, Col, sheetObj, id1, id2, title);
		} else if(strTrd_party=='V') {
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 770, 500, 'getVendor_sheet', '1,0,1,1,1,1,1,1', true, false, Row, Col);
		} else {
			ComShowCodeMessage('TPB90015'); 
		    try { sheetObj.SelectCell(Row, "vndr_cust_div_cd"); } catch(e) { ComShowMessage(e.message); } /// set focus
		}
	}
	/**
	 * 3rd Party Staff 팝업창을 여는 함수
	 * sheet에서 호출시 사용
	 */
	function open3rdPartyTargetPopup_sheet(val, row, col, sheetObj, id1, id2, title) {
		if(title == undefined){
			title = "Select Staff";
		}
		var theURL="ESD_TPB_0804.do?title=" + title;
	    // ComShowMessage( theURL );
		var features="scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:440px";
		var rtnValue =  ComOpenWindow(theURL,  window,  features , true);	
	}
	
	function callback0804(rtnValue){
		var sheetObj = G_tmp_obj.sheet;
		var row = G_tmp_obj.row;
		var col = G_tmp_obj.col;
		var id1 = G_tmp_obj.id1;
		var id2 = G_tmp_obj.id2;
			
		if(rtnValue != undefined && rtnValue != null && sheetObj != "") {
			// document.form.stl_to_clt_cng_ofc_cd.value = rtnValue;
	    	sheetObj.SetCellValue(row, col,rtnValue,0);
	    	sheetObj.SetCellValue(row, 'n3pty_ofc_cd',rtnValue,0);
	    	sheetObj.SetCellValue(row, 'cust_cnt_cd','',0);
	    	sheetObj.SetCellValue(row, 'cust_seq','',0);
	    	sheetObj.SetCellValue(row, 'vndr_cnt_cd','',0);
	    	sheetObj.SetCellValue(row, 'vndr_seq','',0);
	    	if( id1 != '' && id1 != undefined &&
				id2 != '' && id2 != undefined) {
	    	    eval("document.all."+id1).value="S";
	    		eval("document.all."+id2).value=rtnValue;
		    	getThirdParyTargetSheetAfter(sheetObj, row, id1, id2);
	    	} else {
	    	    document.all.s_vndr_cust_div_cd.value="S";
		        document.all.s_trd_party_val.value=rtnValue;
		    	getThirdParyTargetSheetAfter(sheetObj, row);
	       }
		}
	}
	
	/**
	 * 3rd Party popup 호출 후 처리 
	 */
	function getThirdParyTargetSheetAfter(sheetObj, Row, id1, id2) {
	    try { 
if( ComTrim( sheetObj.GetCellValue(Row, 'trd_party_val') ) != '') {
if( ComTrim(sheetObj.GetCellValue(Row, 'vndr_cust_div_cd') ) != "") {
//	    			sheetObj.CellEditable(Row, "cfm_flg_y") = true;
	    			sheetObj.SetCellEditable(Row, "cfm_i",1);
	    			sheetObj.SetCellEditable(Row, "cfm_g",1);
					if( id1 != '' && id1 != undefined &&
						id2 != '' && id2 != undefined) {
					    id1=eval("document.all."+id1).value;
						id2=eval("document.all."+id2).value;
		                getTPBGenCombo('Void_ThirdParty_Sheet','checkTrdParty','V','','',new Array(id2,id1), Row);
					} else {
		                getTPBGenCombo('Void_ThirdParty_Sheet','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd"), Row);
					}
	    		}
if(sheetObj.GetCellValue(Row, 'curr_cd') == "" || parseFloat(sheetObj.GetCellValue(Row, 'cfm_amt')) == 0) {
//	    			sheetObj.CellEditable(Row, "cfm_flg_y") = false;
//	    			sheetObj.CellValue2(Row, "cfm_flg_y") = "0";
					sheetObj.SetCellEditable(Row, "cfm_i",0);
					sheetObj.SetCellEditable(Row, "cfm_g",0);
					sheetObj.SetCellValue(Row, "cfm_i","0",0);
					sheetObj.SetCellValue(Row, "cfm_g","0",0);
	    		}
	    	} else {
//	    		sheetObj.CellEditable(Row, "cfm_flg_y") = false;
//	    		sheetObj.CellValue2(Row, "cfm_flg_y") = "0";
//	    		sheetObj.CellValue2(Row, "trd_party_val") = "";
				sheetObj.SetCellEditable(Row, "cfm_i",0);
				sheetObj.SetCellEditable(Row, "cfm_g",0);
				sheetObj.SetCellValue(Row, "cfm_i","0",0);
				sheetObj.SetCellValue(Row, "cfm_g","0",0);
				sheetObj.SetCellValue(Row, "trd_party_val","",0);
	    	}
	    } catch(e) {
	        ComShowMessage(e.toString());
	        
	    } finally {
	    	G_tmp_obj = "";
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
		var theURL="ESD_TPB_0807.do?n3pty_no="+pN3pty_no+"&n3pty_inv_no="+pN3pty_inv_no+"&is_read_only="+pIsReadOnly;
		if ( pFrom_N3pty_no!=null && ComTrim(pFrom_N3pty_no).length>0 ) {
		    theURL += "&from_n3pty_no="+pFrom_N3pty_no; 
		}
		var winName="ESD_TPB_0807";
		//var features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=yes,alwaysRaised,dependent,titlebar=no,width=1000,height=550";
		var features="scroll:yes; status:no; resizable:yes; help:no; dialogWidth:1000px; dialogHeight:550px;";
		ComOpenWindow(theURL,winName,features,true);
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
		    sumInvAmt=parseFloat(ComGetUnMaskedValue(document.form.s_net_amt.value,"float"));
		}
		var addAmt=parseFloat(ComGetUnMaskedValue(document.form.s_add_amt.value,"float")); 
		if( isNaN(addAmt) || addAmt == undefined || addAmt == null || addAmt < 0) {
		    addAmt=0.00;
		} 
		var ddtAmt=parseFloat(ComGetUnMaskedValue(document.form.s_ddct_amt.value,"float")); 
		if( isNaN(ddtAmt) || ddtAmt == undefined || ddtAmt == null || ddtAmt < 0) {
		    ddtAmt=0.00;
		} 
		if(isModify == undefined) {
		    isModify=false;
		}
		var tvaChecked=document.form.s_vat_xch_rt_chk.checked;
		var s_vat_xch_rt=document.form.s_vat_xch_rt.value;
		var s_vat_amt=document.form.s_vat_amt.value;
//		if(!tvaChecked) {
//			document.form.s_vat_amt.readOnly = true;
//			document.all.s_vat_amt.className = "noinput";
//		} else {
//			document.form.s_vat_amt.readOnly = false;
//			document.all.s_vat_amt.className = "";
//		}
		var tvaAmt=0;
		if(isModify) {
			if(ComIsNumber(document.form.s_vat_amt)) {
				if(parseFloat(ComGetUnMaskedValue(s_vat_amt,"float")) > 0) {
					tvaAmt=ComRound(parseFloat(ComGetUnMaskedValue(s_vat_amt,"float")));
				}
			} else {
				// tvaAmt = 0;
				//if (!isNaN(s_vat_amt) && parseFloat(s_vat_amt) > 0){
				if (parseFloat(s_vat_amt) > 0){
					tvaAmt=ComRound(parseFloat(ComGetUnMaskedValue(s_vat_amt,"float")));
				} else {
					tvaAmt=0;
				}
			}
		} else {
			if(tvaChecked && s_vat_xch_rt != "") {
				tvaAmt=ComRound( (parseFloat(sumInvAmt)+parseFloat(addAmt)-parseFloat(ddtAmt)) * parseFloat(s_vat_xch_rt) / 100.00);
			} else {
				tvaAmt=0;
				//if(document.form.s_vat_amt.value != "") {
				//	tvaAmt = parseFloat(ComClearSeparator(document.form.s_vat_amt.value,","));
				//}
			}
		}
		// 2009-03-16 N200903090210 - tpb_vatAmountReCalculate 의 VAT Amount 는 KRW,JPY,VND 경우 Integer 로 한다.
//		try{
//			if( (document.form.s_curr_cd.value == "KRW" || document.form.s_curr_cd.value == "JPY" || document.form.s_curr_cd.value == "VND") ) {
//				addAmt = parseInt( addAmt );
//				ddtAmt = parseInt( ddtAmt );
//				tvaAmt = parseInt( tvaAmt );
//			}
//		} catch(e) {
//		
//		}
		//Currency Code에 따른 소수점 자리수 반올림 구하기
		var prcsCnt=document.all.prcs_cnt.value;
		var amtPrcs=1;
		if( prcsCnt >= 3 ) prcsCnt=2;
		for(var j=0;j<prcsCnt;j++)
		{
			amtPrcs=amtPrcs * 10;
		}
		addAmt=Math.round(addAmt * amtPrcs) / amtPrcs;
		ddtAmt=Math.round(ddtAmt * amtPrcs) / amtPrcs;
		tvaAmt=Math.round(tvaAmt * amtPrcs) / amtPrcs;
		var totalAmt=ComRound(parseFloat(sumInvAmt) + parseFloat(tvaAmt) + parseFloat(addAmt) - parseFloat(ddtAmt));
		document.form.s_net_amt.value=ComAddComma2(sumInvAmt+"","#,###.00");
		document.form.s_add_amt.value=ComAddComma2(addAmt+"","#,###.00");
		document.form.s_ddct_amt.value=ComAddComma2(ddtAmt+"","#,###.00");
		document.form.s_vat_amt.value=ComAddComma2(tvaAmt+"","#,###.00");
		document.form.s_total_amt.value=ComAddComma2(totalAmt+"","#,###.00");
	}
	function tpb_otherAmountReCalculate(obj) {
		if(ComIsNumber(obj)) {
			if(parseFloat(ComGetUnMaskedValue(obj.value,"float")) > 0) {
				obj.value=ComRound(parseFloat(ComGetUnMaskedValue(obj.value,"float")));
			} else {
	      		obj.value="0.00"; 
			}
//		}else{
//			obj.value = "0.00"; 
		}
		tpb_vatAmountReCalculate(null, true);
	}
	/**
	 * Invoice Sheet Set 팝업을 띄우는 함수 - 2008.10
	 *
	 * @param : pN3pty_no - n3pty_no
	 * @param : pN3pty_inv_no - n3pty_inv_no
	 */
	var G_formObject;
	function openInvoiceSheetSetPopupWin(formObject, pReadOnlyYn, pOfcCd) {
		var theURL="ESD_TPB_0109_POP.do?pgmNo=ESD_TPB_0109&parentPgmNo=ESD_TPB_M001&s_state=Y";
		if ( pReadOnlyYn!=null && pReadOnlyYn!=undefined && pReadOnlyYn=="N" ) {
			theURL += '&ReadOnlyYn='+pReadOnlyYn;
		}
		if ( pOfcCd!=null && pOfcCd!=undefined && pOfcCd!="" ) {
			theURL += '&s_sheet_set_ofc_cd='+pOfcCd;
		}
	    // ComShowMessage( theURL );
		//var features="scroll:no;status:no;help:no;dialogWidth:605px;dialogHeight:565px";
		//var rtnValue =  ComOpenWindow(theURL,  window,  features , true);
		G_formObject = formObject;
		ComOpenPopup(theURL, "605", "565", "callback0109", "0,1", true);
	}
	function callback0109(rtnValue){
		var formObject = G_formObject;
		if(rtnValue != undefined && rtnValue != null && rtnValue.length > 0) {
			if(formObject.s_sheet_set_count != undefined) {
				formObject.s_sheet_set_count.value=1;
			}
			formObject.s_bil_loc.value=rtnValue[0];
			formObject.s_vat_xch_rt.value=rtnValue[1];
		}
	}
	
	function Set_Cookie( name, value, expires, path, domain, secure ) {
	    // set time, it's in milliseconds
	    var today=new Date();
	    today.setTime( today.getTime() );
	    /*
	    if the expires variable is set, make the correct 
	    expires time, the current script below will set 
	    it for x number of days, to make it for hours, 
	    delete * 24, for minutes, delete * 60 * 24
	    */
	    if ( expires ) {
	        expires=expires * 1000 * 60 * 60 * 24;
	    }
	    var expires_date=new Date( today.getTime() + (expires) );
	    document.cookie=name + "=" + escape( value ) +
	        ( ( expires ) ? ";expires=" + expires_date.toGMTString() : "" ) + 
	        ( ( path ) ? ";path=" + path : "" ) + 
	        ( ( domain ) ? ";domain=" + domain : "" ) +
	        ( ( secure ) ? ";secure" : "" );
	}
	function Get_Cookie( name ) {
	    var start=document.cookie.indexOf( name + "=" );
	    var len=start + name.length + 1;
	    if ( ( !start ) &&( name != document.cookie.substring( 0, name.length ) ) ) {
	       return null;
	    }
	    if ( start == -1 ) return null;
	    var end=document.cookie.indexOf( ";", len );
	    if ( end == -1 ) end=document.cookie.length;
	    return unescape( document.cookie.substring( len, end ) );
	}
	function Delete_Cookie( name, path, domain ) {
	    if ( Get_Cookie( name ) ) document.cookie=name + "=" +
	        ( ( path ) ? ";path=" + path : "") +
	        ( ( domain ) ? ";domain=" + domain : "" ) +
	        ";expires=Thu, 01-Jan-1970 00:00:01 GMT";
	}
	/**
	 * Pending TPB Popup Window 호출 함수 
	 */
	function openPendingTPBWin(isTPBofficeYN ) { // TPB Office(G)일 경우만... 
		if ( isTPBofficeYN == 'Y' ) {
	        var theURL="ESD_TPB_0808.do";
	        var winName="ESD_TPB_0808";
	        var features="toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=360,height=360";
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
		var f=document.frames;
		var ifr="frame_"+f.length;
		var o=document.createElement("DIV");
		o.style.display="none";
		o.innerHTML='<iframe name="'+ifr+'" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
		document.body.appendChild(o);
		eval("document."+ifr).location.href="TPBCommonCode.do?hdiv="+hdiv+"&ord="+ord+"&method="+method+"&obj="+obj+"&func="+func;
	}
	 /**
	  * input 값의 길이를 체크하고 메시지 보여주는 함수
	  */	
	 function tpb_chkLenByByte(obj, len, name){
	 	if(!ComChkLenByByte(obj, len)){
	 		ComShowCodeMessage("COM12142",name,len,"");
	 		obj.focus();
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
				if (!ComIsNumber(obj, "-")){obj.value='';
				}
			} else if (isChkFmt!=undefined && isChkFmt!=null && isChkFmt=='Y'){
				var int_char=(int_str!=undefined&&int_str!=null&int_str.trim()!=''?int_str.trim():'-');
				var src=obj.value;
				for (var i=0; src!=null && i<src.length; i++){
					if ((i!=4 && i!=7 && !ComIsNumber(src.charAt(i))) || ((i==4 || i==7) && !ComIsNumber(src.charAt(i), "-"))){
						src=src.substring(0,i) + src.substring(i+1,src.length);
					} else {
						if ((i==4 || i==7) && (src.charAt(i)!=int_char)){
							src=src.substring(0,i) + int_char + src.substring(i,src.length);
						}
					}
				}
				obj.value=src;
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
			obj.value=obj.value.trim();
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
		 * TPB Common regular expression을 통과해도 진짜 날짜 유형 객체에 적합한지 검사한다.<br>  
		 * 사용예: 2006-11-00은 정규식은 통과하지만, 사실상 유효하지 않는 날짜이다.<br>
		 * 
		 * @param {String}	str_date	Date
		 * @param {String}	del			delete 구분자
		 **/
		function tpb_isValidDateObject(str_date, del){
			if (del==undefined || del==null || del.trim()==''){del='-';}
			var arr_date=str_date.split(del);
			var obj_date=new Date(arr_date[0],arr_date[1]-1,arr_date[2]);
			var result=(1*arr_date[0]==obj_date.getFullYear() && 1*arr_date[1]==(obj_date.getMonth()+1) && 1*arr_date[2]==obj_date.getDate());
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
			var date_regexp=/(^\d{4}\-\d{2}\-\d{2}$)/;
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
			re=new RegExp(regexp,"gi");
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
			result=(regexp.test(src));
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
			var pos=0;
			pos=str.indexOf(find);
			while(pos != -1)
			{
			    pre_str=str.substring(0, pos);
			    post_str=str.substring(pos + find.length, str.length);
			    str=pre_str + replace + post_str;
			    pos=str.indexOf(find);
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
				source.value=replaceStr(source.value,char1,'');
			}
			else
			{
				ComShowMessage(ComGetMsg('TPB90014'));
			}
		}
	  	/**
	  	  * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
	  	  * @param{form} str  Form 객체  
	  	  * @param{exElmNms} str   exElmNms값들은 form elemente name으로 구성하지 않을 값들이다. 
	  	  */  
		 function tpbFrmQryStr(form, exElmNms) {
	  	      if (typeof form != "object" ) {
	  	          //Msg : Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag. <== 모듈별 Error Msg 등록하여 사용
	  	          showMsg("");
	  	          return "";
	  	      }
	  	      var name=new Array(form.elements.length);
	  	      var value=new Array(form.elements.length);
	  	      var j=0;
	  	      var plain_text="";
	  	      //사용가능한 컨트롤을 배열로 생성한다.
	  	      len=form.elements.length;
	  	      for (i=0; i < len; i++) {
		  	    	  switch (form.elements[i].type) {
		  	          	case "button":
		  	          	case "reset":
		  	          	case "submit":
		  	                 break;
		  	          	case "radio":
		  	          	case "checkbox":
		  	                 if (form.elements[i].checked == true) {
		  	                	 name[j]=form.elements[i].name;
		  	                     value[j]=form.elements[i].value;
		  	                     j++;
		  	                 }
		  	                 break;
		  	          	case "select-one":
		  	                 name[j]=form.elements[i].name;
		  	                 var ind=form.elements[i].selectedIndex;
		  	                 if(ind >= 0) {
		  	                	 if (form.elements[i].options[ind].value != '')
		  	                		 value[j]=form.elements[i].options[ind].value;
		  	                     else value[j]='';
		  	                 }
		  	                 else {
		  	                 	 value[j]="";
		  	                 }
		  	                 j++;
		  	                 break;
		  	          	case "select-multiple":
		  	                 name[j]=form.elements[i].name;
		  	                 var llen=form.elements[i].length;
		  	                 var increased=0;
		  	                 for( k=0; k < llen; k++) {
		  	                	 if (form.elements[i].options[k].selected) {
		  	                		 name[j]=form.elements[i].name;
		  	                		 if (form.elements[i].options[k].value != '') value[j]=form.elements[i].options[k].value;
		  	                         else value[j]='';
		  	                         j++;
		  	                         increased++;
		  	                     }
		  	                 }
		  	                 if(increased > 0) {
		  	                	 j--;
		  	                 }
		  	                 else {
		  	                	 value[j]="";
		  	                 }
		  	                 j++;
		  	                 break;
		  	          	default :
		  	                 if(form.elements[i].value!=undefined && form.elements[i].value.length >0 ) {
		  	                	 if(exElmNms!=null && exElmNms!='' && exElmNms!=undefined){
		  	                		 if(!checkExcludeElements(form.elements[i].name, exElmNms)){
		  	                			 name[j]=form.elements[i].name;
		  	                			 value[j]=form.elements[i].value;
		  	                			 j++;
		  	                         }
		  	                     }
		  	                	 else {
		  	                		 name[j]=form.elements[i].name;
		  	                         value[j]=form.elements[i].value;
		  	                         j++;
		  	                     }
		  	                 }
		  	          }
	  	      }
	  	    for (i=0; i < j; i++) {
	  	         if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
	  	     }
	  	   //마지막에 &를 없애기 위함
	  	   if (plain_text != "")
	  	     plain_text=plain_text.substr(0, plain_text.length -1);
	  	     return plain_text;
	  	  }
	  	  function checkExcludeElements(elmNm, exElmNms){
	  		  var arr_exElmNms='';
	  		  var rstTF=false;
	  		  try{
	  			  if(exElmNms != null && exElmNms != '' && exElmNms != undefined){
		  		      arr_exElmNms=exElmNms.split('|');
		  		      for(var i=0; i < arr_exElmNms.length; i++){
		  		    	  if(arr_exElmNms[i] != "") {
		  		    		  if(elmNm==null || elmNm=='' || elmNm==undefined){
		  		    			  rstTF=true;
		  		    			  break;
		  		    		  }else if(elmNm == arr_exElmNms[i]){
		  		    			  rstTF=true;
		  		    			  break;
		  		    		  }
		  		    	  }
		  		      }
		  		  }
	  		  }catch(e){
	  			  rstTF=true;
	  		  }
	  		  return rstTF;
	  	  }
	  	//VAT 적용된 금액 산출
	    function amtReCalculate()
	    {
	  		var addAmt=parseFloat(ComGetUnMaskedValue(document.form.s_add_amt.value,"float")); 
	  		if( isNaN(addAmt) || addAmt == undefined || addAmt == null || addAmt < 0) {
	  		    addAmt=0.00;
	  		} 
	  		var ddtAmt=parseFloat(ComGetUnMaskedValue(document.form.s_ddct_amt.value,"float")); 
	  		if( isNaN(ddtAmt) || ddtAmt == undefined || ddtAmt == null || ddtAmt < 0) {
	  		    ddtAmt=0.00;
	  		} 
	  		var invAmt=0;
	  		for(var idx=0;idx<sheetObjects.length-1;idx++)
	  		{
	  			invAmt=invAmt + sheetObjects[idx].ComputeSum("|inv_dtl_amt|");
	  		}
	    	var vatAmt=0;
	  		for(var idx=0;idx<sheetObjects.length-1;idx++)
	  		{
	  			vatAmt=vatAmt + sheetObjects[idx].ComputeSum("|vat_dtl_amt|");
	  		}
	    	var prcsCnt=document.all.prcs_cnt.value;
	  		var amtPrcs=1;
	  		if( prcsCnt >= 3 ) prcsCnt=2;
	  		for(var j=0;j<prcsCnt;j++)
	  		{
	  			amtPrcs=amtPrcs * 10;
	  		}
	  		invAmt=Math.round(invAmt * amtPrcs) / amtPrcs;
	  		addAmt=Math.round(addAmt * amtPrcs) / amtPrcs;
	  		ddtAmt=Math.round(ddtAmt * amtPrcs) / amtPrcs;
	  		vatAmt=Math.round(vatAmt * amtPrcs) / amtPrcs;
	  		//var invAmt = parseFloat(ComGetUnMaskedValue(document.form.s_net_amt.value,"float"));
	  		var totalAmt=ComRound(parseFloat(invAmt) + parseFloat(addAmt) - parseFloat(ddtAmt) + parseFloat(vatAmt));
	  		document.form.s_net_amt.value=ComAddComma2(invAmt+"","#,###.00");
	  		document.form.s_add_amt.value=ComAddComma2(addAmt+"","#,###.00");
	  		document.form.s_ddct_amt.value=ComAddComma2(ddtAmt+"","#,###.00");
	  		document.form.s_vat_amt.value=ComAddComma2(vatAmt+"","#,###.00");
	  		document.form.s_total_amt.value=ComAddComma2(totalAmt+"","#,###.00");
	    }
