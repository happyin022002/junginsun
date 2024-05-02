/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CoGem.js
 *@FileTitle : Trs Common javascript
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.01.04
 *@LastModifier : 최 선
 *@LastVersion : 1.2
 * 2009.08.20 조풍연
 * 1.0 Creation
 * ----------------------------------------------------------
 * History
 * 2010.11.22 민정호     1.1 [CHM-201007223] Invoice only 로 처리되는 건들에 대한 Currency check validation 추가 
 * 2011.01.04 최 선         1.2 [CHM-201108174] Report 화면 중 S/P code 선택 시 오류팝업 수정요청
=========================================================*/
// --------------------------------------------------------
// 메세지 관련
// 샘플 msgs["GEM01001"] = "{?msg1} {?msg2}하십시오.";
// -------------------------------------------------------
// TRS 관련 메세지 
msgs['TRS90001'] = 'There is no data to print.';
msgs['TRS90002'] = 'Confirm Completed.';
msgs['TRS90003'] = 'Confirmed or Saved Container could not be applied.';
msgs['TRS90004'] = 'There is Invoice No.';
msgs['TRS90005'] = '{?msg1} of {?msg2} must be greater than 0.';
msgs['TRS90006'] = 'Total amount differs from Invoice amount.';
msgs['TRS90007'] = 'Verify has not been completed.';
msgs['TRS90008'] = 'Already File Imported.';
msgs['TRS90009'] = 'There is {?msg1} on Coincidence.';
msgs['TRS90010'] = 'Non Rail Billing.';
msgs['TRS90011'] = 'S/O created by different offices cannot be saved in the same invoice.';
msgs['TRS90012'] = 'For Door move, only I/B could be applied to matchmaking case II';
msgs['TRS90013'] = 'Invoice No 합계 세액과 입력된 세액이 틀립니다.\n\n 다시 확인하세요.';
msgs['TRS90014'] = 'Invoice No 품의금액과 입력된 총합계이 틀립니다.\n\n 다시 확인하세요.';
msgs['TRS90015'] = '세금 계산서 번호를 다시 확인하세요.';
msgs['TRS90016'] = '흑/적자구분를 체크하세요.';
msgs['TRS90017'] = 'Tax Type를 체크하세요.';
msgs['TRS90018'] = '올바른 사업자 등록번호가 아닙니다.\n\n 다시 확인하세요.';
msgs['TRS90019'] = '세금계산서 관련 품명 및 금액 입력 사항이 없습니다.\n\n 다시 확인하세요.';
msgs['TRS90020'] = '품명 입력사항이 없습니다.\n\n 다시 확인하세요.';
msgs['TRS90021'] = '세금 계산서 입력항목이 저장이 되었습니다.';
msgs['TRS90022'] = 'Invoice No 품의금액과 입력된 총합계이 틀립니다.\n\n 다시 확인하세요.';
msgs['TRS90023'] = '세금 계산서 번호를 다시 확인하세요.';
msgs['TRS90024'] = '흑/적자구분를 체크하세요.';
msgs['TRS90025'] = '올바른 사업자 등록번호가 아닙니다.\n\n 다시 확인하세요.';
msgs['TRS90026'] = '세금계산서 관련 품명 및 금액 입력 사항이 없습니다.\n\n 다시 확인하세요.';
msgs['TRS90027'] = '품명 입력사항이 없습니다.\n\n 다시 확인하세요.';
msgs['TRS90028'] = '계산서 입력항목이 저장 되었습니다.';
msgs['TRS90029'] = '증빙구분을 선택하세요.';
msgs['TRS90030'] = '증빙관련 세금계산서 또는 계산서 팝업창을 띄워 입력항목을 입력해 주세요.';
msgs['TRS90031'] = 'Agreement Creation is not possible at this moment.\n\n Please contact the system administrator.';
msgs['TRS90032'] = 'Agreement {?msg1} exists for this service provider & contract office & Reference No.';
msgs['TRS90033'] = 'Agreement No exists for this service provider.';
msgs['TRS90034'] = 'Agreement No Generation - Success!!';
msgs['TRS90035'] = 'Amount mismatch! - The invoice total amount without tax should be the same as the total sum of selected one\'s invoice total amount.';
msgs['TRS90036'] = 'At least one row needs to be selected.';
msgs['TRS90037'] = 'At least two S/O candidates need to be selected to process the Matchmaking I case.';
msgs['TRS90038'] = 'Verify are done. Please click on the "Update" button to save.';
msgs['TRS90039'] = 'Verify needs to be  done first.';
msgs['TRS90040'] = 'Cancellation Request Reject - Success!!';
msgs['TRS90041'] = '"Confirm Cancel" function is for confirmed invoice only.';
msgs['TRS90042'] = '"Confirm" function is for invoices with "Received" or "Saved" status and for ones their invoice amount is same as W/O amount.';
msgs['TRS90043'] = 'Confirmation MSG Send - Success!!';
msgs['TRS90044'] = 'Confirmed invoice cannot be modified.\n\n If you are inquiring detailed information, please click on the "Detail Inquiry" button.';
msgs['TRS90045'] = '"Container Select" function is only for O/B Door S/O created without container number.';
msgs['TRS90046'] = 'CSR Creation - Success!!';
msgs['TRS90047'] = 'CSR Creation is not possible at this moment.\n\n Please contact the system administrator.';
msgs['TRS90048'] = 'The currency of the selected ones have to be the same.';
msgs['TRS90049'] = 'Door delivery is not allowed when the bound is T/S.';
msgs['TRS90050'] = 'Door node and To node cannot be the same.';
msgs['TRS90051'] = '"Fill in CNTR No" function is only for Empty S/O created without container number.';
msgs['TRS90052'] = 'From node and Door node cannot be the same.';
msgs['TRS90053'] = 'From node and To node cannot be the same.';
msgs['TRS90054'] = 'From node and Via node cannot be the same.';
msgs['TRS90055'] = 'Imported items need to be verified first.\n\n Please click on the "Verify" button.';
msgs['TRS90056'] = 'Invoice Confirm - Success!!';
msgs['TRS90057'] = 'Invoice Save - Success!!';
msgs['TRS90058'] = 'ONLY Invoices having "Received", "Saved" or "Confirmed" status could be deleted.';
msgs['TRS90059'] = 'ONLY Invoices having "Saved" status could be modified.';
msgs['TRS90060'] = 'Matchmaking is limited to ones with "Truck" transportation mode.';
msgs['TRS90061'] = 'Multiple Apply is not possible at this moment.\n\n Please contact the system administrator.';
msgs['TRS90062'] = 'Need to separate those combined cases first.';
msgs['TRS90063'] = 'Only 5000 rows or less could be imported at a time.';
msgs['TRS90064'] = 'Only Chassis can be bundled.';
msgs['TRS90065'] = 'Payment S/P code does not exist.\n\n Please check the S/P code information.';
msgs['TRS90066'] = 'Please check the Agreement No.';
msgs['TRS90067'] = 'Please check the inputted commodity group code.';
msgs['TRS90068'] = 'Please check the inputted contract office code.';
msgs['TRS90069'] = 'Please check the inputted customer code.';
msgs['TRS90070'] = 'Please check the inputted date.';
msgs['TRS90071'] = 'Please check the inputted door node.';
msgs['TRS90072'] = 'Please check the inputted inquiry from date.';
msgs['TRS90073'] = 'Please check the inputted inquiry to date.';
msgs['TRS90074'] = 'Please check the inputted location code.';
msgs['TRS90075'] = 'Please check the inputted service provider code and contract office code and Reference No.';
msgs['TRS90076'] = 'Please check the inputted service provider code.';
msgs['TRS90077'] = 'Please check the inputted via node.';
msgs['TRS90078'] = 'Please check the verify result.';
msgs['TRS90079'] = 'Please check the W/O currency.';
msgs['TRS90080'] = 'Please click on the "Apply" button to proceed.';
msgs['TRS90081'] = 'Please create or retrieve header information first.';
msgs['TRS90082'] = 'Please do the "Word Verify" first.';
msgs['TRS90083'] = 'There should not be any space after comma - {?msg1} .';
msgs['TRS90084'] = 'Please enter {?msg1} of ' + 'NODE' + '.';
msgs['TRS90085'] = 'Please erase "Door Node" information for CY move.';
msgs['TRS90086'] = 'Please input From Node.';
msgs['TRS90087'] = 'Please input the Agreement No.';
msgs['TRS90088'] = 'Please input the Contract Office code.';
msgs['TRS90089'] = 'Please input the "Effective As Of" date.';
msgs['TRS90090'] = 'Please input the EQ Type/Size.';
msgs['TRS90091'] = 'Please input the Office code.';
msgs['TRS90092'] = 'Please input the reason of rejecting the cancellation request.';
msgs['TRS90093'] = 'Please input the reason of transferring.';
msgs['TRS90094'] = 'Please input the Yard code.';
msgs['TRS90095'] = 'Please input the Zone code.';
msgs['TRS90096'] = 'Please input To node.';
msgs['TRS90097'] = 'Please input Via Node.';
msgs['TRS90098'] = 'Please select matchmaking object on the lower part of the screen.';
msgs['TRS90099'] = 'Please select one service provider.';
msgs['TRS90100'] = 'Please set the approval step.';
msgs['TRS90101'] = 'Possible inquiry period is limited to 16 days.';
msgs['TRS90102'] = 'Rail S/O Correction - Success!!';
msgs['TRS90103'] = 'Rail S/O Creation - Success!!';
msgs['TRS90104'] = 'Route has not been properly inputted.';
msgs['TRS90105'] = 'S/O Correction - Success!!';
msgs['TRS90106'] = 'S/O Correction is not possible at this moment.\n\n Please contact the system administrator.';
msgs['TRS90107'] = 'S/O Creation - Success!!';
msgs['TRS90108'] = 'S/O Creation is not possible at this moment.\n\n Please contact the system administrator.';
msgs['TRS90109'] = 'S/O Delete - Success!!';
msgs['TRS90110'] = 'S/O needs to be created first.';
msgs['TRS90111'] = 'Saved information cannot be deleted.';
msgs['TRS90112'] = 'Since the country code is missing in your office code information, you cannot use the CSR Creation function.\n\n Please check the office code information.';
msgs['TRS90113'] = 'The 1st and the 2nd nodes need to be inputted to retrieve distance type agreement for that route.';
msgs['TRS90114'] = 'The inputted booking no does not exist.';
msgs['TRS90115'] = 'The inputted country code does not exist.';
msgs['TRS90116'] = 'The inputted service provider code does not exist.\n\n Please check the S/P code information.';
msgs['TRS90117'] = 'The inputted work order no does not exist.';
msgs['TRS90118'] = 'The inquiry from date cannot be greater than to date.';
msgs['TRS90119'] = 'The inquiry from date is missing.';
msgs['TRS90120'] = 'The inquiry period is limited to two weeks.';
msgs['TRS90121'] = 'The inquiry to date is missing.';
msgs['TRS90122'] = 'The location code has been incorrectly inputted.';
msgs['TRS90123'] = 'The mandatory data is missing.\n\n Please contact the system administrator.';
msgs['TRS90124'] = 'The mandatory inquiry option is not inputted.';
msgs['TRS90125'] = 'The number of rows you selected is less than the number of unit that you would like to bundle.';
msgs['TRS90126'] = 'The same Invoice No exists.';
msgs['TRS90127'] = 'The selected S/O candidates\' cost mode are different.';
msgs['TRS90128'] = 'The service provider code has been deleted. Please check S/P Code information.';
msgs['TRS90129'] = 'There are {?msg1} "Word Verify Error". Please take a look the columns indicated in blue.';
msgs['TRS90130'] = 'There are remaining data on other tabs. Are you sure you want to proceed?';
msgs['TRS90131'] = 'There is no corresponding data to combine.';
msgs['TRS90132'] = 'There is no corresponding data.';
msgs['TRS90133'] = 'There is the same data in the grid.';
msgs['TRS90134'] = 'To Node cannot be inputted same as From Node.';
msgs['TRS90135'] = 'Via node and To node cannot be the same.';
msgs['TRS90136'] = 'W/O has been already issued.';
msgs['TRS90137'] = 'W/O Issue - Success!!';
msgs['TRS90138'] = 'W/O S/P code does not exist. Please check the S/P code information.';
msgs['TRS90139'] = 'Word Verify is done.\n\n Please click "Yes" if you would like to continue with Business Verify.';
msgs['TRS90140'] = 'Word Verify needs to be done first.';
msgs['TRS90141'] = 'You can inquire only one at a time.';
msgs['TRS90142'] = 'You need to define either "Country" or "Location".';
msgs['TRS90143'] = 'Location can not be differed with the one another';
msgs['TRS90144'] = 'Invoice status is not valid to process.';
msgs['TRS90145'] = 'Please input Door Node.';
msgs['TRS90146'] = 'Rail S/O Delete - Success!!';
msgs['TRS90147'] = 'The mandatory data is missing. Please check the IRG information.';
msgs['TRS90148'] = 'There is no alternatives.\n\n Please check the IRG.';
msgs['TRS90149'] = 'Via node and Door node cannot be the same.';
msgs['TRS90198'] = '세액 변경 금액 기준을 초과 하였습니다.\n\n 다시 확인하세요.';
msgs['TRS90199'] = '선택된 row에 CSR No.가 없습니다.';
msgs['TRS90200'] = 'TAX 항목이 존재하지 않습니다.';
msgs['TRS90201'] = 'Are you sure to delete \'Surcharge\' agreement for this AGMT No?';
msgs['TRS90202'] = 'Are you sure that the AGMT no will be inactive?';
msgs['TRS90203'] = 'Business Verify is being processed. Please wait.';
msgs['TRS90204'] = '\'CNTR No Import\' function is only for Empty S/O created without container number.';
msgs['TRS90205'] = 'Cost Mode needs to be selected.';
msgs['TRS90206'] = '\'CSR Cancel\' function is unavailable for CSRs having \'Approval Requested\', \'Approved\' and \'I/F Success\' as their status.';
msgs['TRS90207'] = 'Delete has been cancelled.';
msgs['TRS90208'] = 'EDI Resend - Success!!';
msgs['TRS90209'] = 'EQ No can be manually inputted for Empty CNTR, Chassis, or Genset S/O  created without equipment number.';
msgs['TRS90210'] = 'From and To location have to be the same.';
msgs['TRS90211'] = 'Please click on the \'Business Verify\' button.';
msgs['TRS90212'] = 'Please define the Trans Mode.';
msgs['TRS90213'] = 'Please input at least more than two among From/Via/Door/To node.';
msgs['TRS90214'] = 'Please input exchange rate.';
msgs['TRS90215'] = 'Please select at least one row.';
msgs['TRS90216'] = 'S/P Apply - Success!!';
msgs['TRS90217'] = '\'Save\' function is not working at this moment.\n\n Please contact the system administrator.';
msgs['TRS90218'] = 'There is \'Business Verify Error.\' \n\n Please take a look the columns indicated in blue.';
msgs['TRS90219'] = 'There is \'Word Verify Error.\' \n\n Please take a look the columns indicated in blue.';
msgs['TRS90220'] = 'There is no corresponding data due to following possible reasons.\nPlease check and reprocess.\n\n1. S/P does not match between W/O and Invoice.\n2. Corresponding W/O does not exist.\n3. Invoice has been created for same W/O.\n4. Missing Invoice Authority Office Setting.';
msgs['TRS90221'] = 'There is no selected one for cancellation.';
msgs['TRS90222'] = 'Total amount cannot be \'0\'';
msgs['TRS90223'] = 'USA Rail S/O candidates are included.\n\n Please use USA Rail S/O Creation function for them.';
msgs['TRS90224'] = 'Verification cannot be done since there are duplicated EQ No in the imported file.';
msgs['TRS90225'] = '\'Verify\' function is not working at this moment. \n\n Please contact the system administrator.';
msgs['TRS90226'] = 'Word Verify is being processed. \n\n Please wait.';
msgs['TRS90227'] = '{?msg1} S/O has been selected. \n\n Are you sure to proceed with W/O issue?';
msgs['TRS90228'] = 'Please input local currency.';
msgs['TRS90229'] = 'You are not authorised user.';
msgs['TRS90230'] = 'It will be delete all data in sheet \n\nDo you really want to select it?';
msgs['TRS90231'] = 'There are frustrated S/O among selected ones. Are you sure to proceed?';
msgs['TRS90232'] = 'Please specify the reason why you are cancelling the W/O in the \'Cancel Reason\' column.';
msgs['TRS90240'] = 'Invoice Reject - Success!!';
msgs['TRS90241'] = 'Reject function is only available for the invoices received from WIS.';
msgs['TRS90300'] = 'There are remaining S/O candidates in the \'Combined Case I\' tab.\n\n Are you sure you want to proceed? ';
msgs['TRS90301'] = 'There are remaining S/O candidates in the \'Combined Case II\' tab.\n\n Are you sure you want to proceed?';
msgs['TRS90302'] = 'Trans S/O cannot be created for ones that TRO have not been confirmed. ';
msgs['TRS90303'] = 'W/O currency and invoice currency do not match!!\n\n Are you sure to proceed?';
msgs['TRS50100'] = 'Submitted data are already processed by another user';
msgs['TRS90310'] = '\'Frustrate\' function could only be used for full booking cargoes';
msgs['TRS90311'] = '\'Frustrate\' function could only be used for W/O Issued or Draft Status.';
msgs['TRS90315'] = 'You can inquire one W/O at a time.';
msgs['TRS90317'] = 'Please select at least one combined S/O candidates to separate.';
msgs['TRS90320'] = 'The selected W/O was not issued through EDI.';
msgs['TRS90321'] = 'Selected W/O had been deleted.';
msgs['TRS90322'] = 'W/O Preview is only available for the latest W/O.';
msgs['TRS90323'] = 'You are not allowed to view the detail or modify the information of invoices created by another office.';
msgs['TRS90324'] = 'Please select more than one to bundle.';
msgs['TRS90325'] = 'S/O for full and empty cannot be selected together.';
msgs['TRS90326'] = 'The selected route is for \'Truck\' transportation.\n\n If you would like to change the transportation mode, please go to CY&Door S/O creation screen.';
msgs['TRS90330'] = 'Confirm Cancel Complete.';
msgs['TRS90331'] = 'Delete Complete.';
msgs['TRS90332'] = 'EDI Send - Success!';
msgs['TRS90333'] = 'Cancellation EDI Send - Success!';
msgs['TRS90334'] = 'Search Popup Open!! row={?msg1}';
msgs['TRS90335'] = 'This is not lastest Work Order Data!!';
msgs['TRS90336'] = 'Are you sure that the Rate type will be inactive?';
msgs['TRS90340'] = 'Please specify weight & package information.';
msgs['TRS90341'] = 'You\'ve selected an improper office code. Please check the office type.';
msgs['TRS90342'] = 'If you are deleting this S/O because it is \'Requested by BKG\', you won\'t be able to retrieve the same S/O candidate again. Are you sure to proceed?';
msgs['TRS90343'] = 'You\'ve selected a deleted S/P code. Please check!!';
msgs['TRS90345'] = 'CNTR TP/SZ Mismatch!';
msgs['TRS90346'] = 'There\'s verify result for the selected ones. Are you sure to proceed?';
msgs['TRS90347'] = 'Invoice confirm function is only available for invoice received through Web Invoice System.';
msgs['TRS90348'] = 'Invoice surcharge needs to be verified before confirmation. Invoice # :{?msg1}';
msgs['TRS90349'] = 'Please indicate whether you\'re deleting this S/O as per BKG staff\'s request or not in the \'Requested by BKG\' column.';
msgs['TRS90350'] = 'S/O needs to be corrected first.';
msgs['TRS90351'] = 'You have just selected the number of page beyond that of total pages.';
msgs['TRS90352'] = 'A maximum is 10,000 rows to make a downexcel.(Exp. 1-10,000, 10,001~20,000)';
msgs['TRS90353'] = 'Please check the total counts.';
msgs['TRS90354'] = 'Empty Release/Redelivery Order has already been issued. Please cancel it first';
msgs['TRS90355'] = 'Please indicated whether you\'re deleting the S/O because it is requested by BKG staff or not in the \'Requested by BKG\' column. \nIf you say Yes, you will NOT get the same S/O candidates again.'
msgs['TRS90356'] = 'You can only handle one row at a time.';
msgs['TRS90357'] = 'You can only handle one AGMT No at a time';
msgs['TRS90358'] = 'You could modify the information only after cancelling the W/O.';
msgs['TRS90359'] = 'The same Container No exists.';
msgs['TRS90360'] = 'Please Verify first before creating S/Os!!';
msgs['TRS90361'] = 'You do not have authority to update this agreement';
msgs['TRS90362'] = 'There are remaining data not being displayed. Please use Down Excel button on the top right side of this screen to get them all.';
msgs['TRS90363'] = 'Please do COP Change for Rail+Truck+Rail transportation instead of doing IRG Adjust.';
msgs['TRS90364'] = 'S/O candidate deletion is available for ‘Truck Direct’ mode only.\n(A/G Code ? IYTD / OYTD / TYTD)';
msgs['TRS90365'] = 'Selecting invoice from more than one S/P code is not allowed';
msgs['TRS90366'] = 'CNTR Select is not available for Frustrated S/O.';
msgs['TRS90367'] = 'You cannot modify the selected Invoice since it was created through ETS.';
msgs['TRS90368'] = 'This function is being modified.';
msgs['TRS90369'] = 'The selected S/O candidates is before BDR';
msgs['TRS90370'] = 'You should select EDI Re-Send candidate only!';
msgs['TRS90371'] = 'Please wait 30 minutes to rebill. Under processing to cancel the previous MT railbilling.';
msgs['TRS90372'] = 'Please input W/O issue date & Office or W/O number.';
msgs['TRS90373'] = 'W/O needs to be canceled first.';
msgs['TRS90374'] = 'Combined2 Success. Choose another one.';
msgs['TRS90375'] = 'Verify Complete!';
msgs['TRS90376'] = 'Please enter correct date.\n\n Format : YYYYMM';
msgs['TRS90377'] = 'W/O has not been issued yet.';
msgs['TRS90378'] = 'There is no basic data for retrieving.\n\n Please check your input data.';
msgs['TRS90379'] = 'You can not add more than three {?msg1}';
msgs['TRS90380'] = 'If there is no data retrieved, can not add row.';
msgs['TRS90381'] = 'There is no data to Save.\n\n Please check again.';
msgs['TRS90382'] = 'There is no selected data.';
msgs['TRS90383'] = 'There is no data to delete.';
msgs['TRS90384'] = 'The service is not available now';
msgs['TRS90385'] = '{?msg1} is not selected.';
msgs['TRS90386'] = '{?msg1}';
msgs['TRS90387'] = 'This is invalid {?msg1}.';
msgs['TRS90388'] = '{?msg1} is invalid.';
msgs['TRS90389'] = 'There is no container no.';
msgs['TRS90390'] = 'There is no data retrieved.';
msgs['TRS90391'] = 'The inquiry period is limited to {?msg1}.';
msgs['TRS90392'] = 'function processButtonClick Object Error';
msgs['TRS90393'] = 'No Data Found.';
msgs['TRS90394'] = '{?msg1} has been omitted.';
msgs['TRS90395'] = 'There is no updated data .';
msgs['TRS90396'] = 'W/O currency and invoice currency is the same currency. Can not change the same currency!';
msgs['TRS90397'] = 'Invoice confirm function is not available for invoice received through EDI Invoice System.';
msgs['TRS90398'] = 'Account code or Logistic cost code';
msgs['TRS90399'] = 'Please input the "Effective Date"';
msgs['TRS90400'] = ' Double-check the reason of W/O cancellation! \n The reason, \'RQST By BKG\', will cancel both W/O and S/O at once.\n At the same time, user won\'t be able to handle any info of transportation afterward under this COP. \n Are you sure to proceed?';
msgs['TRS90401'] = '전자계산서 혹은 종이 계산서인지 선택하십시요.';
msgs['TRS90402'] = '계산서 Type은 하나만 선택하십시요.';
msgs['TRS90403'] = 'Confirmation of this W/O is impossible. Related S/O is (or are) cancelled.\n (Double-check the status of it)';
msgs['TRS90404'] = '\'Button\' function is not working at this moment. \n\n Please contact the system administrator.';
msgs['TRS90405'] = 'Updated successfully!';
msgs['TRS90406'] = 'To frustrate US Rail S/O, please contact NYCNOI';
msgs['TRS90407'] = 'The currency between W/O and Invoice is different !\n' + 'Pls double-check it before proceeding with this invoice.\n' + '(Currency must be same on both W/O and Invoice.)';

msgs['TRS90408'] = 'Please check the created s/o date.';
msgs['TRS90409'] = 'Update has not been completed.';
msgs['TRS90410'] = 'Mandatory field is missing.  Please enter [{?msg1}].';
msgs['TRS90411'] = 'There is no data.';
msgs['TRS90412'] = 'Duplicate data exist in [{?msg1}], Please check it again.';
msgs['TRS90413'] = '[{?msg1}] should be later than [{?msg2}]';
msgs['TRS90414'] = 'Search Failed';
msgs['TRS90415'] = 'Please input Equipment Number.';

msgs["TRS90416"] = "Unexpected system error occurred during data processing";
msgs["TRS90417"] = "{?msg1} was saved successfully.";
msgs["TRS90418"] = "Maximum duration is {?msg1}";
msgs["TRS90419"] = "Please select data";
msgs["TRS90420"] = "Are you sure? ";
msgs['TRS90421'] = 'This rate is for Empty Cargo. Please check \'Cargo Nature\'.';
msgs['TRS90422'] = '"{?msg1}" is a restricted commodity on the rail';
msgs['TRS90423'] = 'Are you sure to proceed for Approval Request?';
msgs['TRS90424'] = 'Possible inquiry period is limited to 1 month';
msgs['TRS90425'] = 'Please enter a valid {?msg1} format';
msgs['TRS90426'] = 'There are overweight or restricted or stop off cargoes.\n\nDo you want to proceed?';
msgs['TRS90427'] = "You can't change STCC code for DG, RD, AD or RF cargo nature!";
msgs['TRS90428'] = "There is no internal remark(s)";
msgs['TRS90429'] = "You can inquire the 'Office Help' popup for one office code at a time.";
msgs['TRS90430'] = "Please input the 'S/O Office'!!";
msgs['TRS90431'] = "For USA Rail, the inquiry period is limited to 16days. \nWith From/To locations input, the limitation is extended to 1 month.";
msgs['TRS90432'] = "The email address is blank. First you should input email address.";
msgs['TRS90433'] = "The FAX No is blank. First you should input FAX No.";
msgs['TRS90434'] = "You can send only one at a time.";
msgs['TRS90435'] = "W/O must be issued to use Transp. Status Update.";
msgs['TRS90436'] = "Check the same W/O Issued.";
msgs['TRS90437'] = "Trans Status is not samed.";
msgs['TRS90438'] = "ZIP code should be a 5-figure number.";
msgs['TRS90439'] = "The Draft W/O is canceled by only Draft button.";
msgs["TRS90440"] = "{?msg1} was issued successfully.";
msgs["TRS90441"] = "{?msg1} Same data exist.";
msgs["TRS90442"] = "Are you sure? ";
msgs['TRS90443'] = "There exists Change Management. Please action CM first.";
msgs['TRS90444'] = "RELRED EDI is not set for {?msg1}.\nPlease check SUP Setup.";
msgs["TRS90445"] = 'Date format is wrong. Please enter a valid date format..';
msgs["TRS90446"] = "Please check Q'ty.";
msgs["TRS90447"] = "Please check Empty CY.";
msgs["TRS90448"] = "Please check P/D Date.";
msgs["TRS90449"] = "Empty CY is different.";
msgs["TRS90450"] = "They are not matched for using the more candidate.";
msgs["TRS90451"] = "They should be same S/O creation date for using More Candidate.";
msgs["TRS90452"] = "This is T/S shipments. So it doesn\'t apply Non T/S rates.";
msgs["TRS90453"] = "This is not T/S shipments. So it doesn\'t apply T/S rates.";
msgs["TRS90454"] = "Selected Invoice is in Hold Status.";
msgs['TRS90455'] = 'Please specify weight information.';
msgs['TRS90456'] = 'Do you frustrate this W/O?';
msgs['TRS90457'] = 'The CY Container can be updated in case of only attaching BKG container.';
msgs['TRS90458'] = 'S/P Select is not allowed for Supplement S/O';
msgs['TRS90459'] = 'Please select only one row by vendor and surcharge type.';
msgs['TRS90460'] = 'Please enter S/O creation date.';
msgs['TRS90461'] = 'Please, input the detail data.';
msgs['TRS90462'] = "Please correct dates they are not in chronological order.\nDates are the estimated times of From Departure, Door Arrival and To Arrival.";
msgs['TRS90463'] = 'Data Changed. Do you want to save it?';
msgs['TRS90464'] = 'Agreement No does not exist for retrieval.';
msgs['TRS90465'] = 'Attached File is deleted due to storage server capacity.';
msgs['TRS90466'] = 'Make FlatFile Failed!!';
msgs['TRS90467'] = 'Are you sure to delete?';
msgs['TRS90468'] = "There is the target data not to be 'I' or'R' as W/O Status.";
msgs['TRS90469'] = '\"CNTR No Import\" function is only for S/O created without container number';
msgs['TRS90470'] = "There are remaining Auditing Object.\nAre you sure to proceed?";
msgs['TRS90471'] = "There are remaining Confirm Data.\nAre you sure to proceed?";
msgs['TRS90472'] = "Work Order can not be issued as Booking is in Waiting status.";
msgs['TRS90473'] = "Once CSR is created, related invoice can’t be hold.\n Pls check the status of selected invoice again.";
msgs['TRS90474'] = "Possible inquiry period is limited to 2 months.";
msgs['TRS90475'] = "You could delete the S/O only after cancelling the W/O.";
msgs['TRS90476'] = "Please select at least one Pay check box.";
msgs['TRS90477'] = "Please input the 'Invoice Office'!!";
msgs['TRS90478'] = "Are you sure to proceed for Supplement S/O Creation ?";
msgs['TRS90479'] = "Are you sure to proceed for Supplement S/O Delete ?";
msgs['TRS90480'] = "Please fill up the DG Declarant of CNTR No [{?msg1}].";
msgs['TRS90481'] = "Please fill up the name, address, city, state, postal code and country fields of Haz Shipper about CNTR No [{?msg1}].";
msgs['TRS90482'] = "Please fill up the name, address, city, state, postal code and country fields of Haz Consignee about CNTR No [{?msg1}].";
msgs['TRS90483'] = "Please assign \"Default\" flag to another row.";
msgs['TRS90484'] = "Detail item is not exist!";
msgs['TRS90485'] = "W/O No. is different.";
msgs['TRS90486'] = "There is no attached DG container.\nPlease attach a container in Dangerous Cargo Application Pop-up.\n(Service Management > Booking/Documentation > Booking > Special Cargo > Dangerous Cargo Application).";
msgs['TRS90487'] = "There is no AP Office for {?msg1}.\nPlease check the Master Data.";
msgs['TRS90488'] = "W/O can't be issued.\nCSV have cargo 'ON HOLD' in EU Cargo Release screen.";
msgs['TRS90489'] = "Do you frustrate this S/O ?";
msgs['TRS90490'] = "Selected S/O had been already deleted";
msgs['TRS90491'] = "Selected S/O had been already frustrated";
msgs['TRS90492'] = "\'Frustrate\' function could only be used for planned case of full booking cargoes.";
msgs['TRS90493'] = "Please retrieve this {?msg1} again as another user has changed the data.";
msgs['TRS90494'] = "The Base Charge is zero about Container No [{?msg1}] for Rail [{?msg2}].";
msgs['TRS90495'] = "The Surcharge is already applied by manual. Please proceed after removing it.";
msgs['TRS90496'] = "Select Basic Rate first.";
msgs['TRS90497'] = "Please enter full 7 digit Door Zone code.";
msgs['TRS90498'] = "User can’t create the S/Os in Provision status";
msgs['TRS90499'] = "From Node and either of the following fields are mandatory:\n1. TVVD\n2. Booking No.\n3. B/L No.\n4. Container No. or\n5. Contract No.";
msgs['TRS90500'] = "There are remaining S/O creation candidates.\nAre you sure to proceed?";
msgs['TRS90501'] = 'It is not an e-mail address format. Please check it again.';
msgs['TRS90502'] = 'Possible inquiry period is limited to {?msg1} month';
msgs['TRS90503'] = "STCC Code can\'t be modified for EDI sent Rail S/O or Empty Rail S/O.";
msgs['TRS90504'] = 'Mail was transmitted to service provider successfully.'; // not use CoMessage.js
msgs['TRS90505'] = 'Please select one BKG Number.';
msgs['TRS90506'] = '"File in EQ No." function is only for S/O created without equipment number.';
msgs['TRS90507'] = 'There is nor EDI, E-mail or Fax setup for Service Provider {?msg1}. Do you still want to issue all W/Os?';

/** **** trs_common start ******** */
/*
 * Node를 비교하기 위해서 만든 function Java의 HashTable과 비슷한 기능을 한다.
 */
var nodeCount = 0;
function objInit() {
	this.nodeObject = new Object();
	this.HPut = HPut;
	this.HGet = HGet;
	this.HDel = HDel;
	nodeCount = 0;
}
function HPut(key, value) {
	obj = this.nodeObject;
	flag = 0;
	for ( var n in obj) {
		if (n == key) {
			obj[key] = value;
			flag = 1;
		}
	}
	if (flag == 0) {
		obj[key] = value;
	}
	nodeCount++;
}
function HGet(key) {
	obj = this.nodeObject;
	return obj[key];
}
function HDel(key) {
	this.HPut(key, null);
	nodeCount--;
}
// 공통으로 사용할 스크립트 소스
/**
 * sep에 해당하는 char를 제거하는 스크립트
 */
function doSepRemove(obj, sep) {
	var ch = "";
	var lvobj = "";
	for ( var i = 0; i < obj.length; i++) {
		if (obj.charAt(i) == sep) {
			ch = "";
		} else {
			ch = obj.charAt(i);
		}
		lvobj = lvobj + ch;
	}
	return lvobj;
}
/**
 * 날짜에 대한 유효성을 체크.
 */
function doDatecheck(obj) {
	if (obj.length == 8) {
		objy = obj.substring(0, 4);
		objm = obj.substring(4, 6);
		objd = obj.substring(6);
	} else {
		return false;
	}
	var lverr = 0; // 에러 변수
	var lvmonday = [
			31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	];
	if (objy % 1000 != 0 && objy % 4 == 0)
		lvmonday[1] = 29; // 윤년
	if (objd > lvmonday[objm - 1] || objd < 1)
		lverr = 1; // year check
	if (objm < 1 || objm > 12)
		lverr = 1; // month check
	if (objm % 1 != 0 || objy % 1 != 0 || objd % 1 != 0)
		lverr = 1; // number check
	if (lverr == 1) {
		return false;
	} else {
		return true;
	}
}
/**
 * 한글 여부에 대한 유효성을 체크.
 */
function dohancheck(obj) {
	// var lveng=/[a-z|A-Z]/; Fixed by Luc Duong (Root cause: This code doesn't work on Chrome.
	var lveng = /[^a-z|A-Z]/;
	if (lveng.test(obj)) {
		errMsg = ComGetMsg('COM12123', 'This field');
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}
/**
 * 영문과 숫자에 대한 유효성을 체크.
 */
function doengnumcheck(obj, sName) {
	// var lveng=/[a-z|A-Z|,|0-9|]/;
	// if( lveng.test(obj) ) {
	// mig-위 코드가 맞지 않아서 아래와 같이 바꿈
	if (obj.match(/[^a-zA-Z0-9,]/) != null) {
		if (sName == undefined) {
			errMsg = ComGetMsg('COM12127', 'This field');
		} else {
			errMsg = ComGetMsg('COM12127', sName);
		}
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}
/**
 * 날짜에 빼기에 대한 유효성을 체크
 */
function dateCalcuration(objFrom, objTo) {
	var lvfrmDate = doSepRemove(doSepRemove(objFrom, " "), "-");
	var lvtoDate = doSepRemove(doSepRemove(objTo, " "), "-");
	var lvFrom = lvfrmDate.substring(4, 6) + "-" + lvfrmDate.substring(6) + "-" + lvfrmDate.substring(0, 4);
	var lvTo = lvtoDate.substring(4, 6) + "-" + lvtoDate.substring(6) + "-" + lvtoDate.substring(0, 4);
	var fromDay = new Date(lvFrom);
	var toDay = new Date(lvTo);
	var objFT = (toDay.getTime() - fromDay.getTime()) / (24 * 60 * 60 * 1000);
	return objFT;
}

/**
 * 일자에 '-'제거 및 입력하는 함수
 * 
 */
function delHypen(obj) { // hypen제거
	var lvobj = doSepRemove(obj.value, "-");
	obj.value = lvobj;
}

function getHypen(obj) { // hypen입력
	if (obj.value.length == 8) {
		obj.value = obj.value.substring(0, 4) + "-" + obj.value.substring(4, 6) + "-" + obj.value.substring(6);
	}
}

/**
 * 일시에 ':'제거 및 입력하는 함수
 * 
 */
function delColon(obj) { // colon제거
	var lvobj = doSepRemove(obj.value, ":");
	obj.value = lvobj;
}

function getColon(obj) { // colon입력
	if (obj.value.length == 4) {
		obj.value = obj.value.substring(0, 2) + "-" + obj.value.substring(2, 4);
	}
}

/**
 * 숫자 소수점 2자리...리턴
 * 
 */
function myRound(src, pos) {
	if (pos == null || pos == undefined) {
		pos = 2;
	}
	src = deleteComma(src);
	var posV = Math.pow(10, pos);
	var retNum = new String(Math.round(src * posV) / posV);
	var strArray = retNum.split('.');
	var dec = strArray[0];
	var dbl = strArray[1];
	if (isNaN(dec))
		dec = '0';
	if (isNaN(dbl)) {
		dbl = '';
		dbl = rpad(dbl, pos, '0');
	} else {
		dbl = rpad(dbl, pos, '0');
	}
	return dec + '.' + dbl;
}
/**
 * 대문자로 바꾼는 함수.
 */
function setgetUpper(obj) {
	return obj.value = obj.value.toUpperCase();
}
/**
 * 컨테이너 번호 Check Digit 계산 함수.
 */
function cntrCheckDigit(cntrNo) {
	if (cntrNo.length != 10) {
		return cntrNo;
	}
	var sum = 0;
	cntrNo = cntrNo.toUpperCase();
	for ( var i = 0; i < 10; i++) {
		sum = sum + productValue(cntrNo.charAt(i), i);
	}
	var mod = sum % 11;
	if (mod == 10)
		mod = 0;
	if (isNaN(mod))
		return cntrNo;
	return cntrNo + mod;
}
/**
 * 컨테이너 번호 Check Digit 계산 함수 -product Value 계산 하는 로직을 포함한 메소드
 */
function productValue(str, position) {
	var strMap = new Array("10", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "34", "35", "36", "37", "38");
	var num = new Number(str);
	if (isNaN(num)) {
		var index = new Number(str.charCodeAt(0) - 65);
		var strNum = strMap[index];
		return strNum * Math.pow(2, position);
	} else {
		return num * Math.pow(2, position);
	}
}
function multiCntrChkDgt(cntrList) {
	if (cntrList == undefined || cntrList == '')
		return cntrList;
	var cntrArray = cntrList.split(',');
	var newCntrList = '';
	for ( var i = 0; i < cntrArray.length; i++) {
		newCntrList += cntrCheckDigit(cntrArray[i]);
		if (i < cntrArray.length - 1)
			newCntrList += ',';
	}
	return newCntrList;
}
/** **** trs_common end ******** */
/** **** comboUtil start ******* */
var comboObjects = new Array();
var comboCnt = 0;
/**
 * IBCombo Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}
/**
 * sheet내의 combo를 가져와서 등록한다.(셀단위)
 * 
 * @param sheetObj -
 *            sheet객체
 * @param formObject -
 *            검색조건이 되는 form 객체
 * @param row -
 *            combo가 세팅될 row
 * @param colName -
 *            combo가 세팅될 컬럼alias
 * @param value -
 *            조회조건 location값
 */
function getYardSheetCombo(sheetObj, formObject, row, colName, value) {
	if (sheetObj.GetCellProperty(row, colName, "Type") != "Combo") {
		sheetObj.InitCellProperty(row, colName, { Type : "Combo" });
	}
	
	var srcValue = sheetObj.GetCellValue(row, colName);
	formObject.f_cmd.value = SEARCH01;
	var queryString = "srcValue=" + srcValue + "&col=" + colName + "&row=" + row + "&searchStr=" + value + "&" + TrsFrmQryString(formObject);
	var fm_yard_value = ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');
	if (fm_yard_value == '' || fm_yard_value == 'undefined') {
		ComShowCodeMessage('COM12161', value);
		sheetObj.SetCellValue(row, colName, "", 0);
		sheetObj.SelectCell(row, colName);
		sheetObj.CellComboItem(row, colName, { ComboText : "|", ComboCode : "|" });
	} else if (sheetObj.GetCellProperty(row, colName, "ComboCode") != ("|" + fm_yard_value)) {
		sheetObj.CellComboItem(row, colName, { ComboText : "|" + fm_yard_value, ComboCode : "|" + fm_yard_value });
	}
}
/**
 * sheet내의 combo를 가져와서 등록한다.(셀단위)
 * 
 * @param sheetObj -
 *            sheet객체
 * @param formObject -
 *            검색조건이 되는 form 객체
 * @param row -
 *            combo가 세팅될 row
 * @param colName -
 *            combo가 세팅될 컬럼alias
 * @param value -
 *            조회조건 location값
 */
function getYardSheetCombo1(sheetObj, formObject, row, col, colName, value) {
	var srcValue = sheetObj.GetCellValue(row, colName);
	if (sheetObj.GetCellProperty(row, colName, "Type") != "Combo")
		sheetObj.InitCellProperty(row, colName, { Type : "Combo" });
	formObject.f_cmd.value = SEARCH01;
	var queryString = "srcValue=" + srcValue + "&col=" + colName + "&row=" + row + "&searchStr=" + value + "&" + TrsFrmQryString(formObject);
	var fm_yard_value = ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'TEXT');

	if (fm_yard_value == '') {
		ComShowCodeMessage('COM12161', value);
		sheetObj.SetCellValue(row, col, "", 0);
		sheetObj.SelectCell(row, col);
		sheetObj.CellComboItem(row, colName, { ComboText : "|", ComboCode : "|" });
	} else if (sheetObj.GetCellProperty(row, colName, "ComboCode") != ("|" + fm_yard_value)) {
		sheetObj.CellComboItem(row, colName, { ComboText : "|" + fm_yard_value, ComboCode : "|" + fm_yard_value });
	}

}
/**
 * location 조회에 따른 yard LIST를 가져온다.(예: a1|a2|a3|a4)
 * 
 * @param sheetObj -
 *            sheet객체
 * @param formObject -
 *            검색조건이 되는 form 객체
 * @param value -
 *            조회조건 location값
 */
function getYardList(sheetObj, formObject, value) {
	formObject.f_cmd.value = SEARCH01;
	var queryString = "searchStr=" + value + "&" + TrsFrmQryString(formObject);
	return ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');
}


/**
 * Yard 및 Location Name 조회 
 * @param sheetObj
 * @param formObject
 * @param searchValue
 * @param isYard : Y -> Yard , N -> Location
 * @returns
 */
function GetYardName(sheetObj, formObject, searchValue, isYard) {
	if(isYard == undefined || isYard == null || isYard == '') {
		isYard = 'Y';
	}
	formObject.f_cmd.value = SEARCH07;
	var queryString = "searchStr=" + searchValue + "&" + TrsFrmQryString(formObject) + "&isZone=" + isYard;
	return ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, "yd_nm");
}

/**
 * yard list를 combo에 설정한다.
 * 
 * @param comboObj -
 *            설정될 combo객체
 * @param sheetObj -
 *            sheet객체
 * @param formObject -
 *            검색조건이 되는 form 객체
 * @param value -
 *            조회조건 location값
 */
function getYardCombo(comboObj, sheetObj, formObject, value) {
	var yardList = getYardList(sheetObj, formObject, value);
	var yardArray = new Array();
	yardArray = yardList.split("|");
	comboObj.RemoveAll();
	for ( var i = 0; i < yardArray.length; i++) {
		comboObj.InsertItem(i, yardArray[i], yardArray[i]);
	}
	if(ComFuncCheck("setYardFromTemplate")) {
		ComFunc(comboObj);
	}
	return yardList;
}
/**
 * sheet내의 combo를 가져와서 등록한다.(셀단위)
 * 
 * @param sheetObj -
 *            sheet객체
 * @param formObject -
 *            검색조건이 되는 form 객체
 * @param row -
 *            combo가 세팅될 row
 * @param colName -
 *            combo가 세팅될 컬럼alias
 * @param value -
 *            조회조건 location값
 */
function getZoneSheetCombo(sheetObj, formObject, row, colName, value) {
	var srcValue = sheetObj.GetCellValue(row, colName);
	if (sheetObj.GetCellProperty(row, colName, "Type") != "Combo") {
		sheetObj.InitCellProperty(row, colName, { Type : "Combo" });
	}
	formObject.f_cmd.value = SEARCH01;
	var queryString = "isZone=Y&srcValue=" + srcValue + "&col=" + colName + "&row=" + row + "&searchStr=" + value + "&" + TrsFrmQryString(formObject);
	fm_yard_value = ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');

	if (fm_yard_value == '') {
		ComShowCodeMessage('COM12161', value);
	} 
	if (sheetObj.GetCellProperty(row, colName, "ComboCode") != ("|" + fm_yard_value)) {
		sheetObj.CellComboItem(row, colName, { ComboText : "|" + fm_yard_value, ComboCode : "|" + fm_yard_value });
	}
}


/**
 * sheet내의 combo를 가져와서 등록한다.(셀단위)
 * 
 * @param sheetObj -
 *            sheet객체
 * @param formObject -
 *            검색조건이 되는 form 객체
 * @param row -
 *            combo가 세팅될 row
 * @param colName -
 *            combo가 세팅될 컬럼alias
 * @param value -
 *            조회조건 location값
 */
function getZoneSheetCombo1(sheetObj, formObject, row, col, colName, value) {
	var srcValue = sheetObj.GetCellValue(row, colName);
	if (sheetObj.GetCellProperty(row, colName, "Type") != "Combo")
		sheetObj.InitCellProperty(row, colName, { Type : "Combo" });
	formObject.f_cmd.value = SEARCH01;
	var queryString = "isZone=Y&srcValue=" + srcValue + "&col=" + colName + "&row=" + row + "&searchStr=" + value + "&" + TrsFrmQryString(formObject);
	fm_yard_value = ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');

	if (fm_yard_value == '') {
		ComShowCodeMessage('COM12161', value);
		sheetObj.SetCellValue(row, col, "", 0);
		sheetObj.SelectCell(row, col);
	} else if (sheetObj.GetCellProperty(row, colName, "ComboCode") != ("|" + fm_yard_value)) {
		sheetObj.CellComboItem(row, colName, { ComboText : "|" + fm_yard_value, ComboCode : "|" + fm_yard_value });
	}
}

/**
 * 
 * @param sheetObj
 * @param formObject
 * @param row
 * @param col
 * @param colName
 * @param value
 */
function getZoneSheetCombo2(sheetObj, formObject, row, col, colName, value) {
	var srcValue = sheetObj.GetCellValue(row, colName);
	if (sheetObj.GetCellProperty(row, colName, "Type") != "Combo")
		sheetObj.InitCellProperty(row, colName, { Type : "Combo" });
	formObject.f_cmd.value = SEARCH01;
	var queryString = "isZone=Y&srcValue=" + srcValue + "&col=" + colName + "&row=" + row + "&searchStr=" + value + "&" + TrsFrmQryString(formObject);
	fm_yard_value = ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');

	if (fm_yard_value == '') {
		ComShowCodeMessage('COM12161', value);
		sheetObj.SelectCell(row, colName, 0, "", 1);
	} 
	if (sheetObj.GetCellProperty(row, colName, "ComboCode") != ("|" + fm_yard_value)) {
		sheetObj.CellComboItem(row, colName, { ComboText : "|" + fm_yard_value, ComboCode : "|" + fm_yard_value });
		sheetObj.SelectCell(row, colName, 0, "", 1);
	}
}

/**
 * location 조회에 따른 yard LIST를 가져온다.(예: a1|a2|a3|a4)
 * 
 * @param sheetObj -
 *            sheet객체
 * @param formObject -
 *            검색조건이 되는 form 객체
 * @param value -
 *            조회조건 location값
 */
function getZoneList(sheetObj, formObject, value) {
	sheetObj.SetWaitImageVisible(false);
	formObject.f_cmd.value = SEARCH01;
	var queryString = "isZone=Y&searchStr=" + value + "&" + TrsFrmQryString(formObject);
	return ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');
}
/**
 * yard list를 combo에 설정한다.
 * 
 * @param comboObj -
 *            설정될 combo객체
 * @param sheetObj -
 *            sheet객체
 * @param formObject -
 *            검색조건이 되는 form 객체
 * @param value -
 *            조회조건 location값
 */
function getZoneCombo(comboObj, sheetObj, formObject, value) {
	var zoneList = getZoneList(sheetObj, formObject, value);
	var zoneArray = new Array();
	zoneArray = zoneList.split("|");
	comboObj.RemoveAll();
	for ( var i = 0; i < zoneArray.length; i++) {
		comboObj.InsertItem(i, zoneArray[i], zoneArray[i]);
	}
	if(ComFuncCheck("setYardFromTemplate")) {
		ComFunc(comboObj);
	}
	return zoneList;
}
/**
 * location 조회에 따른 yard+ZONE LIST를 가져온다.(예: a1|a2|a3|a4)
 * 
 * @param sheetObj -
 *            sheet객체
 * @param formObject -
 *            검색조건이 되는 form 객체
 * @param value -
 *            조회조건 location값
 */
function getYardZoneList(sheetObj, formObject, value) {
	formObject.f_cmd.value = SEARCH01;
	var queryString = "isZone=A&searchStr=" + value + "&" + TrsFrmQryString(formObject);
	return ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');
}
function getYardZoneCombo(comboObj, sheetObj, formObject, value) {
	var yardList = getYardZoneList(sheetObj, formObject, value);
	var yardArray = new Array();
	yardArray = yardList.split("|");
	comboObj.RemoveAll();
	for ( var i = 0; i < yardArray.length; i++) {
		comboObj.InsertItem(i, yardArray[i], yardArray[i]);
	}
	return yardList;
}
/**
 * sheet내의 combo를 가져와서 등록한다.(셀단위)
 * 
 * @param sheetObj -
 *            sheet객체
 * @param formObject -
 *            검색조건이 되는 form 객체
 * @param row -
 *            combo가 세팅될 row
 * @param colName -
 *            combo가 세팅될 컬럼alias
 * @param value -
 *            조회조건 location값
 */
function getYardZoneSheetCombo1(sheetObj, formObject, row, col, colName, value) {
	var srcValue = sheetObj.GetCellValue(row, colName);
	if (sheetObj.GetCellProperty(row, colName, "Type") != "Combo")
		sheetObj.InitCellProperty(row, colName, { Type : "Combo" });
	formObject.f_cmd.value = SEARCH01;
	var queryString = "isZone=A&srcValue=" + srcValue + "&col=" + colName + "&row=" + row + "&searchStr=" + value + "&" + TrsFrmQryString(formObject);
	fm_yard_value = ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');

	if (fm_yard_value == '') {
		ComShowMessage(ComGetMsg('COM12161', value));
		sheetObj.SetCellValue(row, col, "", 0);
		sheetObj.SelectCell(row, col);
	} else if (sheetObj.GetCellProperty(row, colName, "ComboCode") != ("|" + fm_yard_value)) {
		sheetObj.CellComboItem(row, colName, { ComboText : "|" + fm_yard_value, ComboCode : "|" + fm_yard_value });
	}
}
/**
 * 외부 콤보박스의 리스트 가져오기 Rail Road
 */
function getRailVendorComboList(combo, code, text, option) {
	var vendorNoList = code;
	var vendorNmList = text;
	var vendorNoArray = new Array();
	var vendorNmArray = new Array();
	vendorNoArray = vendorNoList.split("|");
	vendorNmArray = vendorNmList.split("|");
	combo.RemoveAll();
	for ( var i = 0; i < vendorNoArray.length; i++) {
		combo.InsertItem(i, vendorNoArray[i] + '|' + vendorNmArray[i], vendorNoArray[i]);
	}
	combo.InsertItem(0, option, option);
}
/**
 * vendor list를 combo에 설정한다.
 * 
 * @param comboObj -
 *            설정될 combo객체
 * @param sheetObj -
 *            sheet객체
 * @param formObject -
 *            검색조건이 되는 form 객체
 * @param value -
 *            조회조건 location값
 */
function getVendorCombo(comboObj, sheetObj, formObject, value, optionCode, optionText) {
	formObject.f_cmd.value = SEARCH10;
	var queryString = "searchStr=" + value + "&" + TrsFrmQryString(formObject);
	var sXml = sheetObj.GetSearchData("ESD_TRS_0014GS.do", queryString);
	var vendorNoList = ComGetEtcData(sXml, 'vndr_no');
	var vendorNmList = ComGetEtcData(sXml, 'vndr_nm_eng');
	var vendorNoArray = new Array();
	var vendorNmArray = new Array();
	vendorNoArray = vendorNoList.split("|");
	vendorNmArray = vendorNmList.split("|");
	comboObj.RemoveAll();
	for ( var i = 0; i < vendorNoArray.length; i++) {
		if (i == 0 && optionCode != '' && optionCode != undefined) {
			comboObj.InsertItem(i, optionCode, optionText);
		} else {
			comboObj.InsertItem(i, vendorNoArray[i] + '|' + vendorNmArray[i], vendorNoArray[i]);
		}
	}
	return vendorNoList;
}
function initVendorCombo(comboObj) {
	comboObj.SetDropHeight(200);
	comboObj.SetColAlign(0, "left");
	comboObj.SetColAlign(1, "left");
	comboObj.SetColWidth(0, "60");
	comboObj.SetColWidth(1, "300");
}
function getTextVendorSeq(sheetObj, formObj, vndr_seq) {
	formObj.f_cmd.value = SEARCH11;
	formObj.combo_svc_provider.value = get_only_num(vndr_seq);
	var sXml = sheetObj.GetSearchData("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));
	var vendorNoList = ComGetEtcData(sXml, 'vndr_no');
	var vendorNmList = ComGetEtcData(sXml, 'vndr_nm_eng');
	if (vendorNoList == undefined || vendorNoList == '') {
		formObj.combo_svc_provider.value = '';
		formObj.svc_provider.value = '';
		return false;
	}
	formObj.combo_svc_provider.value = lpad(ComTrim(vendorNoList), 6, '0');
	formObj.svc_provider.value = vendorNmList;
	return true;
}
function getTextVndrSeq(sheetObj, formObj, vndr_seq, div) {
	if (div == "chld") {
		formObj.f_cmd.value = SEARCH15;
		formObj.combo_svc_provider_chld.value = get_only_num(vndr_seq);
	} else if (div == "prnt") {
		formObj.f_cmd.value = SEARCH16;
		formObj.combo_svc_provider_prnt.value = get_only_num(vndr_seq);
	}
	var sXml = sheetObj.GetSearchData("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));
	var vendorNoList = ComGetEtcData(sXml, 'vndr_no');
	var vendorNmList = ComGetEtcData(sXml, 'vndr_nm_eng');
	if (vendorNoList == undefined || vendorNoList == '') {
		if (div == "chld") {
			formObj.combo_svc_provider_chld.value = '';
			formObj.svc_provider_chld.value = '';
		} else if (div == "prnt") {
			formObj.combo_svc_provider_prnt.value = '';
			formObj.svc_provider_prnt.value = '';
		}
		return false;
	}
	if (div == "chld") {
		formObj.combo_svc_provider_chld.value = lpad(ComTrim(vendorNoList), 6, '0');
		formObj.svc_provider_chld.value = vendorNmList;
	} else if (div == "prnt") {
		formObj.combo_svc_provider_prnt.value = lpad(ComTrim(vendorNoList), 6, '0');
		formObj.svc_provider_prnt.value = vendorNmList;
	}
	return true;
}
function getTextCmdtCd(sheetObj, formObj, cmdt_cd) {
	formObj.f_cmd.value = SEARCH04;
	formObj.commodity_cd.value = get_only_num(lpad(ComTrim(cmdt_cd), 6, '0'));
	sheetObj.RemoveEtcData();
	var sXml = sheetObj.GetSearchData("ESD_TRS_0999GS.do", TrsFrmQryString(formObj));
	var cmdtCdList = ComGetEtcData(sXml, 'cmdt_cd');
	var cmdtNmList = ComGetEtcData(sXml, 'cmdt_nm');
	if (cmdtCdList == undefined || cmdtCdList == '') {
		formObj.commodity_cd.value = '';
		formObj.commodity_nm.value = '';
		return false;
	} else if (cmdt_cd == '') {
		formObj.commodity_cd.value = '';
		formObj.commodity_nm.value = '';
		return false;
	}
	formObj.commodity_cd.value = lpad(ComTrim(cmdtCdList), 6, '0');
	formObj.commodity_nm.value = cmdtNmList;
	return true;
}
function getTextCustCd(sheetObj, formObj, cust_cd) {
	var temp;
	var custCdVal = cust_cd.toUpperCase();
	// country code
	if (custCdVal.length <= 2) {
		temp = custCdVal.substring(0);
	} else {
		temp = custCdVal.substring(0, 2);
	}
	if (temp.length != 2 || !ComIsAlphabet(temp)) {
		ComShowCodeMessage("TRS90069");
		formObj.input_cust_cd.focus();
		formObj.input_cust_cd.select();
		formObj.input_cust_nm.value = "";
		formObj.input_cust_cd.value = "";
		return false;
	}
	// customer sequence
	if (custCdVal.length > 2) {
		temp = custCdVal.substring(2);
		if (!ComIsNumber(temp)) {
			ComShowCodeMessage("TRS90069");
			formObj.input_cust_cd.focus();
			formObj.input_cust_cd.select();
			formObj.input_cust_nm.value = "";
			formObj.input_cust_cd.value = "";
			return false;
		}
	}
	formObj.f_cmd.value = SEARCH05;
	sheetObj.RemoveEtcData();
	var sXml = sheetObj.GetSearchData("ESD_TRS_0999GS.do", TrsFrmQryString(formObj));
	var custCdList = ComGetEtcData(sXml, 'input_cust_cd');
	var custNmList = ComGetEtcData(sXml, 'input_cust_nm');
	if (custCdList == undefined || custCdList == '') {
		formObj.input_cust_cd.value = '';
		formObj.input_cust_nm.value = '';
		return false;
	}
	formObj.input_cust_nm.value = custNmList;
	return true;
}
/** **** comboUtil end ******* */
/** **** stringUtil start ******** */
String.prototype.trim = function() {
	return this.replace(/(\s*)|(\s*$)/g, "");
}
function chkAmtPos_JPY(src) {
	src = deleteComma(src);
	if (isNaN(src))
		src = '0';
	src = Number(src);
	var retNum = new String(Math.round(src));
	return retNum;
}
function chkAmtPos(src, pos) {
	if (pos == null || pos == undefined) {
		pos = 2;
	}
	src = deleteComma(src);
	var posV = Math.pow(10, pos);
	var retNum = new String(Math.round(src * posV) / posV);
	var strArray = retNum.split('.');
	var dec = strArray[0];
	var dbl = strArray[1];
	if (isNaN(dec))
		dec = '0';
	if (isNaN(dbl)) {
		dbl = '';
		dbl = rpad(dbl, pos, '0');
	} else {
		dbl = rpad(dbl, pos, '0');
	}
	return dec + '.' + dbl;
}
function deleteComma(src) {
	var src = String(src);
	if (src == null || ComTrim(src) == '') {
		return '';
	}
	return src.replace(/,/gi, '');
}
function addComma(src) {
	var src = String(src);
	if (src == null || ComTrim(src) == '') {
		return '';
	}
	var re = /(-?\d+)(\d{3})/;
	while (re.test(src)) {
		src = src.replace(re, "$1,$2");
	}
	return src;
}
function rpad(src, len, padStr) {
	var retStr = "";
	var padCnt = Number(len) - String(src).length;
	for ( var i = 0; i < padCnt; i++)
		retStr += String(padStr);
	return src + retStr;
}
function lpad(src, len, padStr) {
	var retStr = "";
	var padCnt = Number(len) - String(src).length;
	for ( var i = 0; i < padCnt; i++)
		retStr += String(padStr);
	return retStr + src;
}
function get_only_num(obj) {
	var str = escape(obj);
	var returnNum = '';
	for (i = 0; i < str.length; i++) {
		if (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57)
			returnNum += str.charAt(i);
	}
	return returnNum;
}
/**
 * uppercase
 */
function value_upper(obj) {
	obj.value = obj.value.toUpperCase();
}
function checkDateFormat(dt) {
	var date_regexp = "(\\d{4}\\d{2}\\d{2})$";
	if (!checkFormat(dt, date_regexp)) {
		return false;
	}
	return true;
}
function checkFormat(value, regexp) {
	re = new RegExp(regexp, "gi");
	if (!re.test(value)) {
		return false;
	}
	return true;
}
function toHtml(str) {
	str = str.replace(/&/g, '@amp;');
	str = str.replace(/</g, '@lt;');
	str = str.replace(/>/g, '@gt;');
	str = str.replace(/,/g, '@#44;');
	str = str.replace(/\"/g, '@quot;');
	str = str.replace(/\'/g, '@acute;');
	str = str.replace(/\n/g, '@ffd;');
	str = str.replace(/\r/g, '@cgrtn;');
	return str;
}
function getPageURL() {
	var url = window.location + "";
	var startIndex = url.indexOf('/opuscntr/');
	var endIndex = url.indexOf('.do');
	url = url.substring(startIndex + 8, endIndex);
	return url;
}
/** ****** stringUtil end ********** */
/**
 * Focus 이동 사용예: onKeyup="javascript:moveFocus(this, this.form.to_prd_dt, 10);"
 * 
 * @param {Object} fromFormElement from Form Element
 * @param {Object} toFormElement 이동할 요소
 * @param {int,String}numleng number length
 */
function moveFocus(fromFormElement, toFormElement, numleng) {
	var eleLeng = fromFormElement.value.length;
	if (eleLeng >= numleng) {
		toFormElement.focus();
	}
}
/**
 * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * var sCondParam = TrsFrmQryString(document.frmSearch); //결과:&quot;txtname=이경희&amp;rdoYn=1&amp;sltMoney=원화&quot;;
 * </pre>
 * 
 * @param {form}
 *            form Form 오브젝트
 * @return string
 * @version 1.0.0.0
 * @see #TrsFrmQryStringEnc
 */
function TrsFrmQryString(form) {
	if (typeof form != "object") {
		alert("Error : Please contact the administrator\n" + "Detail : Parameter of TrsFrmQryString Function is not a FORM Tag.");
		return "";
	}
	var name = new Array(form.elements.length);
	var value = new Array(form.elements.length);
	var j = 0;
	var plain_text = "";
	// 사용가능한 컨트롤을 배열로 생성한다.
	len = form.elements.length;
	for (i = 0; i < len; i++) {
		// 클래스 아이디로 제품을 구분함-아래는 HTMl제품
		if (form.elements[i].classid == undefined) {
			// 전송전에 폼의 마스크를 제거한다.
			// ComClearSeparator(form.elements[i]);
			switch (form.elements[i].type) {
				case "button":
				case "reset":
				case "submit":
					break;
				case "radio":
				case "checkbox":
					if (form.elements[i].checked == true) {
						name[j] = form.elements[i].name;
						value[j] = form.elements[i].value;
						j++;
					}
					break;
				case "select-one":
					name[j] = form.elements[i].name;
					var ind = form.elements[i].selectedIndex;
					if (ind >= 0) {
						if (form.elements[i].options[ind].value != '')
							value[j] = form.elements[i].options[ind].value;
						else
							value[j] = '';
					} else {
						value[j] = "";
					}
					j++;
					break;
				case "select-multiple":
					name[j] = form.elements[i].name;
					var llen = form.elements[i].length;
					var increased = 0;
					for (k = 0; k < llen; k++) {
						if (form.elements[i].options[k].selected) {
							name[j] = form.elements[i].name;
							if (form.elements[i].options[k].value != '')
								value[j] = form.elements[i].options[k].value;
							else
								value[j] = '';
							j++;
							increased++;
						}
					}
					if (increased > 0) {
						j--;
					} else {
						value[j] = "";
					}
					j++;
					break;
				default:
					if (form.elements[i].type != "") {
						if (form.elements[i].value.length > 0) {
							name[j] = form.elements[i].name;
							value[j] = form.elements[i].value;
							j++;
						}
					}
			}
			// 전송후에 폼의 마스크를 다시 셋팅한다.
			// ComAddSeparator(form.elements[i]);
			// IB에서 제공하는 컨트롤의 값을 조합한다.
		} else {
			switch (form.elements[i].classid) {
				case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E": // IBMaskEdit 경우
					name[j] = form.elements[i].name == "" ? form.elements[i].id : form.elements[i].name;
					value[j] = form.elements[i].Value;
					j++;
					break;
				case CLSID_IBMCOMBO: // IBMultiCombo 경우
					name[j] = form.elements[i].name == "" ? form.elements[i].id : form.elements[i].name;
					if (form.elements[i].UseCode)
						value[j] = form.elements[i].GetSelectCode();
					else
						value[j] = form.elements[i].Text;
					j++;
					break;
			}
		}
	}

	// QueryString을 조합한다.
	for (i = 0; i < j; i++) {
		if (name[i] != '')
			plain_text += name[i] + "=" + encodeURIComponent(value[i]) + "&";
	}
	// 마지막에 &를 없애기 위함
	if (plain_text != "")
		plain_text = plain_text.substr(0, plain_text.length - 1);
	return plain_text;
}

/**
 * Excel Download Option 2015.01.16 Hyungwook Choi
 * 
 * @param sheet
 */
function makeHiddenSkipCol_TRS(sobj) {
	var lc = sobj.LastCol();
	var rtnStr = "";
	for ( var i = 0; i <= lc; i++) {
		if (!(1 == sobj.GetColHidden(i))) {
			rtnStr += "|" + i;
		}
	}
	return rtnStr.substring(1);
}

/**
 * Excel Download Option 2015.02.06 Hyungwook Choi
 * 
 * @param sheet
 */
function makeHiddenSkipCol_BFI(sobj) {
	var lc = sobj.LastCol();
	var rtnStr = "";
	for ( var i = 2; i <= lc; i++) {
		if (!(1 == sobj.GetColHidden(i))) {
			rtnStr += "|" + i;
		}
	}
	return rtnStr.substring(1);
}

/**
 * 
 * @param sobj
 * @param hiddflag
 * @param arrSkipCol
 * @returns
 */
function makeExcelDownSkipColumn(sobj, hiddflag, arrSkipCol, includeField) {
	var lc = sobj.LastCol();
	var rtnStr = "";
	var includeFlg = false;
	for ( var i = 0; i <= lc; i++) {
		if (hiddflag) {
			includeFlg = false;
			if (includeField != null && includeField != undefined) {
				for ( var j = 0; j < includeField.length; j++) {
					if (sobj.ColSaveName(0, i) == includeField[j]) {
						includeFlg = true;
						break;
					}
				}
			}
			if (!includeFlg && (1 == sobj.GetColHidden(i) || sobj.GetCellProperty(0, i, "Type") == "Status" || sobj.GetCellProperty(0, i, "Type") == "DelCheck")) {
				continue;
			}
		}
		var kk = false;
		if (arrSkipCol != null && arrSkipCol != undefined) {
			for ( var j = 0; j < arrSkipCol.length; j++) {
				if (sobj.ColSaveName(0, i) == arrSkipCol[j]) {
					kk = true;
					break;
				}
			}
		}
		if (!kk) {
			rtnStr += "|" + i;
		}
	}
	return rtnStr.substring(1);
}

/**
 * S/O , W/O Valide Check
 * 
 * @param inType
 * @param inValue
 */
function funcCheckValid(inType, inValue) {
	var valid = true;
	if (inType == 'SO' || inType == 'WO') {
		var sArray = inValue.split(",");
		if (sArray.length > 0) {
			for ( var i = 0; i < sArray.length; i++) {
				if (sArray[i].length > 3) {
					if (!ComIsAlphabet(sArray[i].substring(0, 3), 'u')) {
						valid = false;
						break;
					}
					if (!ComIsNumber(sArray[i].substring(3))) {
						valid = false;
						break;
					}
				} else {
					valid = false;
					break;
				}
			}
		}
	}
	return valid;
}

/**
 * 
 * @param sheetObj
 */
function resizeSheet(sheetObj) {
	ComResizeSheet(sheetObj);
}

/**
 * Compare DateTime
 * @param sFromDate
 * @param sToDate
 * @returns {Number}
 */
function TrsComGetTimeBetween(sFromDate, sToDate) {
    try {
        var sFromDate = getArgValue(sFromDate);
        var sToDate   = getArgValue(sToDate);
        var iFromTime = getDateObj(sFromDate);
        var iToTime   = getDateObj(sToDate);
        return iToTime - iFromTime;
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * Currency Format
 * @param num
 * @param pos
 * @returns
 */
function TrsComGetCurrFormat (num, pos) {
	if (pos === undefined || pos === null) {
		pos = 0;
	}
    return num.toFixed(pos).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")
}

/**
 * Form오브젝트 안에 있는 컨트롤을 구분자로 연결하여 구성한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     var sCondParam=JoinFormElements(document.frmSearch); //결과:"txtname=이경희|rdoYn=1|sltMoney=원화";
 * </pre>
 * @param {form} form Form 오브젝트
 * @param {bool} bRemoveSep dataformat이 설정된 값인 경우 구분자를 빼고 값을 가져와서 QueryString에서 사용한다.
 * @return string
 * @version 1.0.0.0
 */
function JoinFormElements(form, bRemoveSep) {

	if (typeof form != "object" ) {
        IBS_ShowErrMsg("Parameter of FormQueryString is not FORM tag.");
        return "";
    }
	if (bRemoveSep == undefined) bRemoveSep = false;

    var name = new Array(form.elements.length);
    var value = new Array(form.elements.length);
    var j = 0;
    var plain_text = "";

    len = form.elements.length;
    for (i = 0; i < len; i++) {
        var prev_j = j;
        switch (form.elements[i].type) {
            case undefined:
            case "button":
            case "reset":
            case "submit":
                break;
            case "radio":
            case "checkbox":
                if (form.elements[i].checked == true) {
                    name[j] = IBS_getName(form.elements[i]);
                    value[j] = form.elements[i].value;
                    j++;
                }
                break;
            case "select-one":
                name[j] = IBS_getName(form.elements[i]);
                var ind = form.elements[i].selectedIndex;
                if (ind >= 0) {

                    value[j] = form.elements[i].options[ind].value;

                } else {
                    value[j] = "";
                }
                j++;
                break;
            case "select-multiple":
                name[j] = IBS_getName(form.elements[i]);
                var llen = form.elements[i].length;
                var increased = 0;
                for (k = 0; k < llen; k++) {
                    if (form.elements[i].options[k].selected) {
                        name[j] = IBS_getName(form.elements[i]);
                        value[j] = form.elements[i].options[k].value;

                        j++;
                        increased++;
                    }
                }
                if (increased > 0) {
                    j--;
                } else {
                    value[j] = "";
                }
                j++;
                break;
            default:
                name[j] = IBS_getName(form.elements[i]);
                value[j] = form.elements[i].value;
                if (bRemoveSep && getDataFormat(form.elements[i])!="")value[j] = ComTrimAll(value[j]," ", "-", ":",  ","); 
                j++;
        }
    }
    
    for (i = 0; i < j; i++) {
        if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "|";
    }

  if (plain_text != "")
    plain_text = plain_text.substr(0, plain_text.length -1);
    return encodeURIComponent(plain_text);
}

/**
 * 
 * @param sInType
 * @param sInStr
 * @param bInShowMsgFlg
 * @param sInMsg
 * @returns {Boolean}
 */
function TrsComValidFormat(sInType, sInStr, bInShowMsgFlg, sInMsg) {
	var pattern;
	var bRtnFlag = true;
	var sOmsg;
	if(!ComIsNull(sInStr)) {
		if(bInShowMsgFlg == undefined || bInShowMsgFlg == null) {
			bInShowMsgFlg = false;
		}
		switch(sInType.toUpperCase()) {
			case "SO" : 
				pattern = /^[A-Z]{3}[\d]{1,15}$/;
				sOmsg = "Service Order No";
				break;
			case "WO": 
				pattern = /^[A-Z]{3}[\d]{1,15}$/;
				sOmsg = "Work Order No";
				break;
			default :
				bRtnFlag = false;
				sOmsg = "";
				break;
		}
		if(pattern != undefined) {
			var arrayStr= sInStr.split(",");
			for(var i=0; i < arrayStr.length; i++) {
				if(ComIsEmpty(arrayStr[i]))  {
					continue;
				}
				if(!pattern.test(arrayStr[i])) {
					bRtnFlag = false;
					break;
				}
			}
		}
		if(bInShowMsgFlg && !bRtnFlag) {
			ComShowCodeMessage('TRS90425', ComIsNull(sInMsg) ? sOmsg : sInMsg);
		}
	}
	return bRtnFlag;
}

/**
 * validate email address format when value was changed
 */
function checkEmailValue(obj) {
	if (obj.value.length > 0 & !ComIsEmailAddr(obj.value)) {
		ComShowCodeMessage("TRS90501");
 		obj.focus();
 		return false;
 	}
 	return true;
}

/**
 * validate email address format when sheet value was changed
 */
function checkSheetEmailValue(sheetObj, row, col, value) {
	if (!ComIsEmailAddr(value)) {
		ComShowCodeMessage("TRS90501");
		sheetObj.SelectCell(row, col);
		return false;
 	}
 	return true;
}