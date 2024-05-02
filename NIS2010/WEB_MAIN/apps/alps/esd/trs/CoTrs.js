
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CoTrs.js
*@FileTitle : Trs Common javascript
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.20
*@LastModifier : 금병주
*@LastVersion : 1.17
* 2009.08.20 조풍연
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.11.22 민정호      1.1 [CHM-201007223] Invoice only 로 처리되는 건들에 대한 Currency check validation 추가 
* 2011.01.04 최 선        1.2 [CHM-201108174] Report 화면 중 S/P code 선택 시 오류팝업 수정요청
* 2011.02.18 손은주      1.3 [CHM-201108834-01][TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청
* 2011.06.20 최 선        1.4 [] Invoice No 중복 메시지 내용 수정 
* 2011.08.31 유선오      1.5 [CHM-201112874][TRS] OTHER/SO Creation 화면 상 오류 수정요청 
* 2011.09.07 민정호      1.6 [CHM-201113207] [TRS] overweight 정보를 가진 candidate 발행 block message 추가 요청 
* 2011.10.19 유선오      1.7 [CHM-201112874][TRS] OTHER/SO Creation 화면 상 오류 수정요청 
* 2011.10.25 유선오      1.8 [CHM-201112874][TRS] OTHER/SO Creation 화면 상 오류 수정요청 
* 2011.11.10 김종호      1.9 [CHM-201114435][TRS] US Rail invoice 화면 일부 기능 수정요청
* 2011.11.17 민정호      1.10[CHM-201114481] [TRS] W/O preview 상에 표현가능한 e-mail, fax 정보 room 확장요청
* 2011.11.17 변종건      1.11[CHM-201114528-01] TRS 시스템 담당자용 버튼 개발
* 2011.11.29 민정호      1.12[CHM-201114644] [TRS] S/O Correction 시 Delete flag 체크로직 추가요청
* 2011.12.14 민정호      1.13[CHM-201115019] [TRS] S/O creation 시 BKG cancel 여부 체크 로직 추가요청
* 2011.12.26 최 선        1.14[CHM-201115241] [TRS] Hold invoice 관련 메세지 추가요청
* 2011.12.29 유선오      1.15[CHM-201115242] [TRS] W/O preview 화면 관련 Validation 추가, BKG data 참조로직 변경요청
* 2012.01.09 김보배      1.16[CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
* 2012.01.20 금병주 	 1.17[CHM-201215842] [TRS] Other SO상 Cost month 입력 Validation 추가
* 2012.02.23 금병주      1.18[CHM-201216258] [TRS] Expense Summary Excel Down 버튼 추가
* 2012.03.20 금병주      1.19[CHM-201216895] [TRS] Invoice issue / receive date format Validation 추가요청
* 2012.12.11 이재위      1.20 [CHM-201221537] W/O issue 화면에 Currency / Negotiated 금액 save 버튼 생성 개발 요건
* 2014.05.28 최종혁      [CHM-201430241] AGMT Confirm 기능 추가
* 2014.06.17 전지예		 1.22[CHM-201430506] CNT(Customer Nominated Trucker) Registration 신규 추가
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
	msgs['TRS90005'] = '{?msg1} of {?msg2} must be greater than 0.' ;
	msgs['TRS90006'] = 'Total amount differs from Invoice amount.' ;
	msgs['TRS90007'] = 'Verify has not been completed.' ;
	msgs['TRS90008'] = 'Already File Imported.' ;
	msgs['TRS90009'] = 'There is {?msg1} on Coincidence.' ;
	msgs['TRS90010'] = 'Non Rail Billing.' ;
	msgs['TRS90011'] = 'S/O created by different offices cannot be saved in the same invoice.' ;
	msgs['TRS90012'] = 'For Door move, only I/B could be applied to matchmaking case II' ;
	msgs['TRS90013'] = 'Invoice No 합계 세액과 입력된 세액이 틀립니다.\n\n 다시 확인하세요.' ;
	msgs['TRS90014'] = 'Invoice No 품의금액과 입력된 총합계이 틀립니다.\n\n 다시 확인하세요.' ;
	msgs['TRS90015'] = '세금 계산서 번호를 다시 확인하세요.' ;
	msgs['TRS90016'] = '흑/적자구분를 체크하세요.' ;
	msgs['TRS90017'] = 'Tax Type를 체크하세요.' ;
	msgs['TRS90018'] = '올바른 사업자 등록번호가 아닙니다.\n\n 다시 확인하세요.' ;
	msgs['TRS90019'] = '세금계산서 관련 품명 및 금액 입력 사항이 없습니다.\n\n 다시 확인하세요.' ;
	msgs['TRS90020'] = '품명 입력사항이 없습니다.\n\n 다시 확인하세요.' ;
	msgs['TRS90021'] = '세금 계산서 입력항목이 저장이 되었습니다.' ;
	msgs['TRS90022'] = 'Invoice No 품의금액과 입력된 총합계이 틀립니다.\n\n 다시 확인하세요.' ;
	msgs['TRS90023'] = '세금 계산서 번호를 다시 확인하세요.' ;
	msgs['TRS90024'] = '흑/적자구분를 체크하세요.' ;
	msgs['TRS90025'] = '올바른 사업자 등록번호가 아닙니다.\n\n 다시 확인하세요.' ;
	msgs['TRS90026'] = '세금계산서 관련 품명 및 금액 입력 사항이 없습니다.\n\n 다시 확인하세요.' ;
	msgs['TRS90027'] = '품명 입력사항이 없습니다.\n\n 다시 확인하세요.' ;
	msgs['TRS90028'] = '계산서 입력항목이 저장 되었습니다.' ;
	msgs['TRS90029'] = '증빙구분을 선택하세요.' ;
	msgs['TRS90030'] = '증빙관련 세금계산서 또는 계산서 팝업창을 띄워 입력항목을 입력해 주세요.' ;
	msgs['TRS90031'] = 'Agreement Creation is not possible at this moment.\n\n Please contact the system administrator.' ;
	msgs['TRS90032'] = 'Agreement {?msg1} exists for this service provider & contract office & Reference No.' ; 
	msgs['TRS90033'] = 'Agreement No exists for this service provider.' ;
	msgs['TRS90034'] = 'Agreement No Generation - Success!!' ;
	msgs['TRS90035'] = 'Amount mismatch! - The invoice total amount without tax should be the same as the total sum of selected one\'s invoice total amount.' ;
	msgs['TRS90036'] = 'At least one row needs to be selected.' ;
	msgs['TRS90037']=  'At least two S/O candidates need to be selected to process the Matchmaking I case.';
	msgs['TRS90038'] = 'Verify are done. Please click on the "Update" button to save.' ;
	msgs['TRS90039'] = 'Verify needs to be  done first.' ;
	msgs['TRS90040'] = 'Cancellation Request Reject - Success!!' ;
	msgs['TRS90041'] = '"Confirm Cancel" function is for confirmed invoice only.' ;
	msgs['TRS90042'] = '"Confirm" function is for invoices with "Received" or "Saved" status and for ones their invoice amount is same as W/O amount.' ;
	msgs['TRS90043'] = 'Confirmation MSG Send - Success!!' ;
	msgs['TRS90044'] = 'Confirmed invoice cannot be modified.\n\n If you are inquiring detailed information, please click on the "Detail Inquiry" button.' ;
	msgs['TRS90045'] = '"Container Select" function is only for O/B Door S/O created without container number.' ;
	msgs['TRS90046'] = 'CSR Creation - Success!!' ;
	msgs['TRS90047'] = 'CSR Creation is not possible at this moment.\n\n Please contact the system administrator.' ;
	msgs['TRS90048'] = 'The currency of the selected ones have to be the same.';
	msgs['TRS90049'] = 'Door delivery is not allowed when the bound is T/S.' ;
	msgs['TRS90050'] = 'Door node and To node cannot be the same.' ;
	msgs['TRS90051'] = '"Fill in CNTR No" function is only for Empty S/O created without container number.' ;
	msgs['TRS90052'] = 'From node and Door node cannot be the same.' ;
	msgs['TRS90053'] = 'From node and To node cannot be the same.' ;
	msgs['TRS90054'] = 'From node and Via node cannot be the same.' ;
	msgs['TRS90055'] = 'Imported items need to be verified first.\n\n Please click on the "Verify" button.' ;
	msgs['TRS90056'] = 'Invoice Confirm - Success!!' ;
	msgs['TRS90057'] = 'Invoice Save - Success!!' ;
	msgs['TRS90058'] = 'Invoices having "Received", "Saved" or "Confirmed" status could be deleted.' ;
	msgs['TRS90059'] = 'Invoices having "Saved" status could be modified.' ;
	msgs['TRS90060'] = 'Matchmaking is limited to ones with "Truck" transportation mode.' ;
	msgs['TRS90061'] = 'Multiple Apply is not possible at this moment.\n\n Please contact the system administrator.' ;
	msgs['TRS90062'] = 'Need to separate those combined cases first.' ;
	msgs['TRS90063'] = 'Only 5000 rows or less could be imported at a time.' ;
	msgs['TRS90064'] = 'Only Chassis can be bundled.' ;
	msgs['TRS90065'] = 'Payment S/P code does not exist.\n\n Please check the S/P code information.' ;
	msgs['TRS90066'] = 'Please check the Agreement No.' ;
	msgs['TRS90067'] = 'Please check the inputted commodity group code.' ;
	msgs['TRS90068'] = 'Please check the inputted contract office code.' ;
	msgs['TRS90069'] = 'Please check the inputted customer code.' ;
	msgs['TRS90070'] = 'Please check the inputted date.' ;
	msgs['TRS90071'] = 'Please check the inputted door node.' ;
	msgs['TRS90072'] = 'Please check the inputted inquiry from date.' ;
	msgs['TRS90073'] = 'Please check the inputted inquiry to date.' ;
	msgs['TRS90074'] = 'Please check the inputted location code.' ;
	msgs['TRS90075'] = 'Please check the inputted service provider code and contract office code and Reference No.' ;
	msgs['TRS90076'] = 'Please check the inputted service provider code.' ;
	msgs['TRS90077'] = 'Please check the inputted via node.' ;
	msgs['TRS90078'] = 'Please check the verify result.' ;
	msgs['TRS90079'] = 'Please check the W/O currency.' ;
	msgs['TRS90080'] = 'Please click on the "Apply" button to proceed.' ;
	msgs['TRS90081'] = 'Please create or retrieve header information first.' ;
	msgs['TRS90082'] = 'Please do the "Word Verify" first.' ;
	msgs['TRS90083'] = 'There should not be any space after comma - {?msg1} .' ;
	msgs['TRS90084'] = 'Please enter {?msg1} of ' + 'NODE'  + '.' ; 
	msgs['TRS90085'] = 'Please erase "Door Node" information for CY move.' ;
	msgs['TRS90086'] = 'Please input From Node.' ;
	msgs['TRS90087'] = 'Please input the Agreement No.' ;
	msgs['TRS90088'] = 'Please input the Contract Office code.' ;
	msgs['TRS90089'] = 'Please input the "Effective As Of" date.' ;
	msgs['TRS90090'] = 'Please input the EQ Type/Size.' ;
	msgs['TRS90091'] = 'Please input the Office code.' ;
	msgs['TRS90092'] = 'Please input the reason of rejecting the cancellation request.' ;
	msgs['TRS90093'] = 'Please input the reason of transferring.' ;
	msgs['TRS90094'] = 'Please input the Yard code.' ;
	msgs['TRS90095'] = 'Please input the Zone code.' ;
	msgs['TRS90096'] = 'Please input To node.' ;
	msgs['TRS90097'] = 'Please input Via Node.' ;
	msgs['TRS90098'] = 'Please select matchmaking object on the lower part of the screen.' ;
	msgs['TRS90099'] = 'Please select one service provider.' ;
	msgs['TRS90100'] = 'Please set the approval step.' ;
	msgs['TRS90101'] = 'Possible inquiry period is limited to 16 days.' ;
	msgs['TRS90102'] = 'Rail S/O Correction - Success!!' ;
	msgs['TRS90103'] = 'Rail S/O Creation - Success!!' ;
	msgs['TRS90104'] = 'Route has not been properly inputted.' ;
	msgs['TRS90105'] = 'S/O Correction - Success!!' ;
	msgs['TRS90106'] = 'S/O Correction is not possible at this moment.\n\n Please contact the system administrator.' ;
	msgs['TRS90107'] = 'S/O Creation - Success!!' ;
	msgs['TRS90108'] = 'S/O Creation is not possible at this moment.\n\n Please contact the system administrator.' ;
	msgs['TRS90109'] = 'S/O Delete - Success!!' ;
	msgs['TRS90110'] = 'S/O needs to be created first.' ;
	msgs['TRS90111'] = 'Saved information cannot be deleted.' ;
	msgs['TRS90112'] = 'Since the country code is missing in your office code information, you cannot use the CSR Creation function.\n\n Please check the office code information.' ;
	msgs['TRS90113'] = 'The 1st and the 2nd nodes need to be inputted to retrieve distance type agreement for that route.' ;
	msgs['TRS90114'] = 'The inputted booking no does not exist.' ;
	msgs['TRS90115'] = 'The inputted country code does not exist.' ;
	msgs['TRS90116'] = 'The inputted service provider code does not exist.\n\n Please check the S/P code information.' ;
	msgs['TRS90117'] = 'The inputted work order no does not exist.' ;
	msgs['TRS90118'] = 'The inquiry from date cannot be greater than to date.' ;
	msgs['TRS90119'] = 'The inquiry from date is missing.' ;
	msgs['TRS90120'] = 'The inquiry period is limited to two weeks.' ;
	msgs['TRS90121'] = 'The inquiry to date is missing.' ;
	msgs['TRS90122'] = 'The location code has been incorrectly inputted.' ;
	msgs['TRS90123'] = 'The mandatory data is missing.\n\n Please contact the system administrator.' ;
	msgs['TRS90124'] = 'The mandatory inquiry option is not inputted.' ;
	msgs['TRS90125'] = 'The number of rows you selected is less than the number of unit that you would like to bundle.' ;
	msgs['TRS90126'] = 'The same Invoice No exists.' ;
	msgs['TRS90127'] = 'The selected S/O candidates\' cost mode are different.' ;
	msgs['TRS90128'] = 'The service provider code has been deleted. Please check S/P Code information.' ;
	msgs['TRS90129'] = 'There are {?msg1} "Word Verify Error". Please take a look the columns indicated in blue.' ;
	msgs['TRS90130'] = 'There are remaining data on other tabs. Are you sure you want to proceed?' ;
	msgs['TRS90131'] = 'There is no corresponding data to combine.' ;
	msgs['TRS90132'] = 'There is no corresponding data.' ;
	msgs['TRS90133'] = 'There is the same data in the grid.' ;
	msgs['TRS90134'] = 'To Node cannot be inputted same as From Node.' ;
	msgs['TRS90135'] = 'Via node and To node cannot be the same.' ;
	msgs['TRS90136'] = 'W/O has been already issued.' ;
	msgs['TRS90137'] = 'W/O Issue - Success!!' ;
	msgs['TRS90138'] = 'W/O S/P code does not exist. Please check the S/P code information.' ;
	msgs['TRS90139'] = 'Word Verify is done.\n\n Please click "Yes" if you would like to continue with Business Verify.' ;
	msgs['TRS90140'] = 'Word Verify needs to be done first.' ;
	msgs['TRS90141'] = 'You can inquire only one at a time.' ;
	msgs['TRS90142'] = 'You need to define either "Country" or "Location".' ;
	msgs['TRS90143'] = 'Location can not be differed with the one another' ;
	msgs['TRS90144'] = 'Invoice status is not valid to process.' ;
	msgs['TRS90145'] = 'Please input Door Node.' ;
	msgs['TRS90146'] = 'Rail S/O Delete - Success!!' ;
	msgs['TRS90147'] = 'The mandatory data is missing. Please check the IRG information.' ;
	msgs['TRS90148'] = 'There is no alternatives.\n\n Please check the IRG.' ;
	msgs['TRS90149'] = 'Via node and Door node cannot be the same.' ;
	msgs['TRS90198'] = '세액 변경 금액 기준을 초과 하였습니다.\n\n 다시 확인하세요.' ;
	msgs['TRS90199'] = '선택된 row에 CSR No.가 없습니다.' ;
	msgs['TRS90200'] = 'TAX 항목이 존재하지 않습니다.' ;
	msgs['TRS90201'] = 'Are you sure to delete \'Surcharge\' agreement for this AGMT No?' ;
	msgs['TRS90202'] = 'Are you sure that the AGMT no will be inactive?' ;
	msgs['TRS90203'] = 'Business Verify is being processed. Please wait.' ;
	msgs['TRS90204'] = '\'CNTR No Import\' function is only for Empty S/O created without container number.' ;
	msgs['TRS90205'] = 'Cost Mode needs to be selected.' ;
	msgs['TRS90206'] = '\'CSR Cancel\' function is ubavailable for CSRs having \'Approval Requested\', \'Approved\' and \'I/F Success\' as their status.' ;
	msgs['TRS90207'] = 'Delete has been cancelled.' ;
	msgs['TRS90208'] = 'EDI Resend - Success!!' ;
	msgs['TRS90209'] = 'EQ No can be manually inputted for Empty CNTR, Chassis, or Genset S/O  created without equipment number.' ;
	msgs['TRS90210'] = 'From and To location have to be the same.' ;
	msgs['TRS90211'] = 'Please click on the \'Business Verify\' button.' ;
	msgs['TRS90212'] = 'Please define the Trans Mode.' ;
	msgs['TRS90213'] = 'Please input at least more than two among From/Via/Door/To node.' ;
	msgs['TRS90214'] = 'Please input exchange rate.' ;
	msgs['TRS90215'] = 'Please select at least one row.' ;
	msgs['TRS90216'] = 'S/P Apply - Success!!' ;
	msgs['TRS90217'] = '\'Save\' function is not working at this moment.\n\n Please contact the system administrator.' ;
	msgs['TRS90218'] = 'There is \'Business Verify Error.\' \n\n Please take a look the columns indicated in blue.' ;
	msgs['TRS90219'] = 'There is \'Word Verify Error.\' \n\n Please take a look the columns indicated in blue.' ;
	msgs['TRS90220'] = 'There is no corresponding data.' ;
	msgs['TRS90221'] = 'There is no selected one for cancellation.' ;
	msgs['TRS90222'] = 'Total amount cannot be \'O\'' ;
	msgs['TRS90223'] = 'USA Rail S/O candidates are included.\n\n Please use USA Rail S/O Creation function for them.' ;
	msgs['TRS90224'] = 'Verification cannot be done since there are duplicated EQ No in the imported file.' ;
	msgs['TRS90225'] = '\'Verify\' function is not working at this moment. \n\n Please contact the system administrator.' ;
	msgs['TRS90226'] = 'Word Verify is being processed. \n\n Please wait.' ;
	msgs['TRS90227'] = '{?msg1} S/O has been selected. \n\n Are you sure to proceed with W/O issue?' ;
	msgs['TRS90228'] = 'Please input local currency.' ;
	msgs['TRS90229'] = 'You are not authorised user.' ;
	msgs['TRS90230'] = 'It will be delete all data in sheet \n\nDo you really want to select it?' ;
	msgs['TRS90231'] = 'There are frustrated S/O among selected ones. Are you sure to proceed?' ;
	msgs['TRS90232'] = 'Please specify the reason why you are cancelling the W/O in the \'Cancel Reason\' column.';
	msgs['TRS90240'] = 'Invoice Reject - Success!!' ;
	msgs['TRS90241'] = 'Reject function is only available for the invoices received from WIS.' ;
	msgs['TRS90300'] = 'There are remaining S/O candidates in the \'Combined Case I\' tab.\n\n Are you sure you want to proceed? ';
	msgs['TRS90301'] = 'There are remaining S/O candidates in the \'Combined Case II\' tab.\n\n Are you sure you want to proceed?';
	msgs['TRS90302'] = 'Trans S/O cannot be created for ones that TRO have not been confirmed. ';
	msgs['TRS90303'] = 'W/O currency and invoice currency do not match!!\n\n Are you sure to proceed?';
	msgs['TRS50100'] = 'Submitted data are already processed by another user' ;
	msgs['TRS90310'] = '\'Frustrate\' function could only be used for full booking cargoes';
	msgs['TRS90311'] = '\'Frustrate\' function could only be used for W/O Issued';
	msgs['TRS90315']=  'You can inquire one W/O at a time.' ;
	msgs['TRS90317']=  'Please select at least one combined S/O candidates to separate.' ;
	msgs['TRS90320'] = 'The selected W/O was not issued through EDI.' ;
	msgs['TRS90321'] = 'S/O had been deleted for the selected W/O.' ;
	msgs['TRS90322'] = 'W/O Preview is only available for the latest W/O.' ;
	msgs['TRS90323'] = 'You are not allowed to view the detail or modify the information of invoices created by another office.' ;
	msgs['TRS90324'] = 'Please select more than one to bundle.' ;
	msgs['TRS90325'] = 'S/O for full and empty cannot be selected together.' ;
	msgs['TRS90326'] = 'The selected route is for \'Truck\' transportation.\n\n If you would like to change the transportation mode, please go to CY&Door S/O creation screen.';
	msgs['TRS90330'] = 'Confirm Cancel Complete.' ;
	msgs['TRS90331'] = 'Delete Complete.' ;
	msgs['TRS90332'] = 'EDI Send - Success!' ;
	msgs['TRS90333'] = 'Cancellation EDI Send - Success!' ;
	msgs['TRS90334'] = 'Search Popup Open!! row={?msg1}';
	msgs['TRS90335'] = 'This is not lastest Work Order Data!!' ;
	msgs['TRS90336'] = 'Are you sure that the Rate type will be inactive?' ; 
	msgs['TRS90340'] = 'Please specify weight & package information.' ;
	msgs['TRS90341'] = 'You\'ve selected an improper office code. Please check the office type.' ;
	msgs['TRS90342'] = 'If you are deleting this S/O because it is \'Requested by BKG\', you won\'t be able to retrieve the same S/O candidate again. Are you sure to proceed?' ;
	msgs['TRS90343'] = 'You\'ve selected a deleted S/P code. Please check!!' ;
	msgs['TRS90345'] = 'CNTR TP/SZ Mismatch!' ;
	msgs['TRS90346'] = 'There\'s verify result for the selected ones. Are you sure to proceed?' ;
	msgs['TRS90347'] = 'Invoice confirm function is only available for invoice received through Web Invoice System.' ;
	msgs['TRS90348'] = 'Invoice surcharge needs to be verified before confirmation. Invoice # :{?msg1}' ;
	msgs['TRS90349'] = 'Please indicate whether you\'re deleting this S/O as per BKG staff\'s request or not in the \'Requested by BKG\' column.' ;
	msgs['TRS90350'] = 'S/O needs to be corrected first.' ;
	msgs['TRS90351'] = 'You have just selected the number of page beyond that of total pages.' ;
	msgs['TRS90352'] = 'A maximum is 10,000 rows to make a downexcel.(Exp. 1-10,000, 10,001~20,000)' ;
 	msgs['TRS90353'] = 'Please check the total counts.' ;
	msgs['TRS90354'] = 'Empty Release/Redelivery Order has already been issued. Please cancel it first' ;
	msgs['TRS90355'] = 'Please indicated whether you\'re deleting the S/O because it is requested by BKG staff or not in the \'Requested by BKG\' column. \nIf you say Yes, you will NOT get the same S/O candidates again.'
	msgs['TRS90356'] = 'You can only handle one row at a time for Rate Correction.' ;
	msgs['TRS90357'] = 'You can only handle one AGMT No at a time' ;
	msgs['TRS90358'] = 'You could modify the information only atfer cancelling the W/O.' ;
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
	msgs['TRS90379'] = 'You can not add any more.';
	msgs['TRS90380'] = 'If there is no data retrieved, can not add row.';
	msgs['TRS90381'] = 'There is no data to Save.\n\n Please check again.';
	msgs['TRS90382'] = 'There is no selected data.';
	msgs['TRS90383'] = 'There is no data to delete.';
	msgs['TRS90384'] = 'The service is not available now';
	msgs['TRS90385'] = '{?msg1} is not selected.';
	msgs['TRS90386'] = '{?msg1}';
	msgs['TRS90387'] = 'This is invalid {?msg1}.' ;
	msgs['TRS90388'] = '{?msg1} is invalid.' ;
	msgs['TRS90389'] = 'There is no container no.' ;
	msgs['TRS90390'] = 'There is no data retrieved.' ;
	msgs['TRS90391'] = 'The inquiry period is limited to {?msg1}.';
	msgs['TRS90392'] = 'function processButtonClick Object Error';
	msgs['TRS90393'] = 'No Data Found.';
	msgs['TRS90394'] = '{?msg1} has been omitted.' ;
	msgs['TRS90395'] = 'There is no updated data .';
	msgs['TRS90396'] = 'W/O currency and invoice currency is the same currency. Can not change the same currency!';
	msgs['TRS90397'] = 'Check whether currency or TTL amount is same each other on W/O and Invoice';
	msgs['TRS90398'] = 'Account code or Logistic cost code';
	msgs['TRS90399'] = 'Please input the "Effective Date"' ;
	msgs['TRS90400'] = ' Double-check the reason of W/O cancellation! \n The reason, \'RQST By BKG\', will cancel both W/O and S/O at once.\n At the same time, user won\'t be able to handle any info of transportation afterward under this COP. \n Are you sure to proceed?';
	msgs['TRS90401'] = '전자계산서 혹은 종이 계산서인지 선택하십시요.' ;
	msgs['TRS90402'] = '계산서 Type은 하나만 선택하십시요.' ;
	msgs['TRS90403'] = 'Confirmation of this W/O is impossible. Related S/O is (or are) cancelled.\n (Double-check the status of it)' ;
	msgs['TRS90404'] = '\'Button\' function is not working at this moment. \n\n Please contact the system administrator.' ;
	msgs['TRS90405'] = 'Updated successfully!' ;
	msgs['TRS90406'] = 'To frustrate US Rail S/O, please contact NYCNOI';		
	msgs['TRS90407'] = 'The currency between W/O and Invoice is different !\n'+
					   'Pls double-check it before proceeding with this invoice.\n'+
					   '(Currency must be same on both W/O and Invoice.)';
	msgs['TRS90408'] = 'Weight is over the limit. Check the BKG data again.';
	msgs['TRS90409'] = 'Are you sure to delete invoice selected?';
	msgs['TRS90410'] = 'Number of email allowed to insert is up to 6';
	msgs['TRS90411'] = 'Selected S/O cannot be modified.\n\nAlready S/O has been deleted. (S/O NO : {?msg1})';
	msgs['TRS90412'] = '[Warning] Cost month must be earlier than the current month.\nPls check the data inserted for cost month.\n(Future period input is allowed only up to next month)';
	msgs['TRS90413'] = 'There are remaining data not being displayed. Please use Down Excel button on the bottom side of this screen to get them all.';
	msgs['TRS00407'] = 'BKG is already cancelled. S/O could not be created.';
	msgs['TRS00408'] = 'TRO is not confirmed yet. Pls check the TRO status on relevant BKG.';
	msgs['TRS00409'] = 'R/D term on S/O is different from it on BKG. Pls retrieve S/O candidate again.';
	msgs['TRS00410'] = '"Hold" status invoice(s) is (are) included.\nRelease "hold" flag to process this CSR.\n( {?msg1} )';
	msgs['TRS00411'] = '"S/O No. ( {?msg1} )\nis (are) already included in another W/O. Pls check subj. S/O data."';
	msgs['TRS00412'] = 'CNTR No. is not valid !\nPls check if this No. is registered in CNTR Master.';
	msgs['TRS00413'] = 'Pls check the CNTR type/size. ( {?msg1} )';
	msgs['TRS00414'] = 'Candidate(s) colored in purple mean(s) existence of S/O under same condition on COP. Pls check whether it is duplicated case or not.';
	msgs['TRS90415'] = 'Please enter correct date.\n\n Format : YYYYMMDD';
	msgs['TRS90416'] = 'Batch creation in progress.';
	msgs['TRS90417'] = 'Unconfirmed/Error occurred cost tariffs were selected. Are you sure to overwrite those tariffs?';
	msgs['TRS90418'] = "Please select row(s) which you want to apply the cost adjustment to.";
	msgs['TRS90419'] = "Cost Tariff No has been already confirmed.";
	msgs['TRS90420'] = "Please input either flat rate or percentage for special commodity cost.";
	msgs['TRS90421'] = "Please specify the location group.";
	msgs['TRS90422'] = "This tariff cannot be modified hereafter.\n\nAre you sure you want to proceed?";
	msgs['TRS90423'] = "Tariffs with Error/Progressing/Cancelled status cannot be shown in detail.";
	msgs['TRS90424'] = "Newly inputted ‘Effective From’ date cannot be earlier than existing date.";
	msgs['TRS90425'] = "Smaller value than the previous row cannot be inputted.";
	msgs['TRS90426'] = "Excel Header Name Error!! Please check header names and make them same as the current screen.";
	msgs['TRS90427'] = "Without conversion rate, batch creation cannot be started.";
	msgs['TRS90428'] = "Please check after dry tab retrieved.";
	msgs['TRS90429'] = "Tariffs with other than 'Waiting' status cannot be cancelled.";
	msgs['TRS90430'] = "Are you sure you want to cancel the batch creation?";
	msgs['TRS90431'] = "More than 999 location group cannot be created. Please adjust the interval amount and try again.";
	msgs['TRS90432'] = "Loaded data has nothing changed. Pls check the file again.";
	msgs['TRS90433'] = "Please input the mandatory inquiry option.";
	msgs['TRS90434'] = "Please input either DATE or EFFECTIVE AS OF.";
	msgs['TRS90435'] = "There are remaining data that could not be displayed all together. Please use ‘Down Excel without Displaying’ button on the top right side of the screen.";
	msgs['TRS90436'] = "For tariffs with 0 route only.";
	msgs['TRS90437'] = "{?msg1}\nAre you sure you want to proceed?";
	msgs['TRS90438'] = "Only confirmed cost tariff(s) can be cancelled.";
	msgs['TRS90439'] = "Cannot be cancelled since guideline tariff has already been created.";
	msgs['TRS90440'] = "Are you sure you want to change the status to 'Updated'?";
	msgs['TRS90441'] = "Are you sure you want to confirm these tariffs?";
	msgs['TRS90442'] = "Cannot be cancelled since guideline tariff has already been created.";
	msgs['TRS90443'] = "404 for DG cargo could not be transmitted : only possible when from node is USDETR5 over S/P 105480 (CPRS) or S/P is CN, FEC";
	msgs['TRS90444'] = "Each Class code could not be selected in more than two drop down box at the same time.";
	msgs['TRS90445'] = "One value, at least, must be selected to use this function";
	msgs['TRS90446'] = "There are remaining data not being displayed, if all rows exceed 2,000.\nPlease use Down Excel button on the top right side of this screen to get them all.";
	msgs['TRS90447'] = "Are you sure to proceed? {?msg1}";
	msgs['TRS90448'] = "BKG Detail screen can't be displayed if number of selected booking exceeds 200";
	msgs['TRS90449'] = "There is no data having tariff No. inserted";
	msgs['TRS90500'] = "Please remark the reason of trans mode / node change.";
    msgs['TRS90501'] = 'Select just one cargo type to apply surcharge.';
	msgs['TRS90502'] = 'Pre-pull is only for CY mode S/O';
	msgs['TRS90503'] = 'Issue cancel checked.';
	msgs['TRS90504'] = 'There is no contents to save.';


	//2013.02.15 추가 조인영
    msgs['TRS90505'] = 'W/O rate(Basic Amount) is different from uploaded one.';
    msgs['TRS90506'] = 'W/O rate(Additional Amount) is different from uploaded one.';
    msgs['TRS90507'] = 'W/O rate(Negotiated Amount) is different from uploaded one.';
    msgs['TRS90508'] = 'W/O rate(Fuel Amount) is different from uploaded one.';
    msgs['TRS90509'] = 'W/O rate(VAT Amount) is different from uploaded one.';
    msgs['TRS90510'] = 'Invoice No ({?msg1}) was created for this S/O.';
    
 // AWK Cargo Basic Tariff Management - Shuttle 2013.04.22 이혜민 추가
	msgs['TRS90511'] = 'Data saved successfully!';
	msgs['TRS90512'] = 'No authority to Row copy.';
	msgs['TRS90513'] = 'No authority to Save.';
	msgs['TRS90514'] = 'Not Available to delete From [{?msg1}] and To [{?msg2}] is used as a source of Actual cost.';
	msgs['TRS90515'] = 'No authority to create data for From [{?msg1}] To [{?msg2}].';
	msgs['TRS90516'] = 'Please input [Currency] first.';
	msgs['TRS90517'] = 'Not available to select [Default] for new data.';
	msgs['TRS90518'] = 'Default Data cant be copied.';
	msgs['TRS90519'] = '{?msg1} is mandatory item.';
	msgs['TRS90520'] = '{?msg1} duplicated.' ;
	
	msgs['TRS90521'] = 'In view of the data processing time, inquiry period will be limited to three month.' ;
	msgs['TRS90522'] = "Please input the 'W/O Office'!!" ;
	msgs['TRS90523'] = "You can inquire the 'Office Help' popup for one office code at a time.";

	//2013.07.23 Multi More Candidate 추가
	msgs['TRS90524'] = "Selected S/Os have different Information.";
	msgs['TRS90525'] = "Please check the eMail.";
	msgs['TRS90526'] = "Please Save first!";
	
	msgs['TRS90527'] = 'To Node({?msg1}) and Off-Hire Yard({?msg2}) are different.';
	msgs['TRS90528'] = 'Cannot be deleted due to {?msg1}.';
	msgs['TRS90529'] = 'There is no content to copy.';
	msgs['TRS90530'] = "Please remark the reason of node change.";
	msgs['TRS90531'] = "Selected S/O candidates have different conditions.(Node, Trans Mode, Bound)"
	msgs['TRS90532'] = "Selected S/O can not be modified.\nAlready S/O status has been changed.(S/O No : {?msg1})";
	
	msgs['TRS90533'] = "Please Check Agreement No.";
	
	//2014.06.17 전지예 추가
	msgs['TRS90534'] = '"Save" or "Reject" status could be {?msg1}. ';
	msgs['TRS90535'] = 'Do you want to {?msg1} the selected item? ';
	msgs['TRS90536'] = 'Origin node and Dest node cannot be the same.' ;
	msgs['TRS90537'] = 'Should be under or same with Contract Office';
	
	// CNT Approval
	msgs['TRS90538'] = 'selected item have already been approved.';
	msgs['TRS90539'] = 'selected item are not approved.';
	
	//2014.06.25 [CHM-201430505] ASA/GL date 해당 월 Validation 추가
	msgs['TRS90550'] = "The month of GL date and ASA no. is not matched.\nMake it to be same.(Inv No : {?msg1})";
	
	msgs['TRS90600'] = 'There is no selected row.' ;
	msgs['TRS90601'] = 'There is no selected CSR No.' ;		
	
	//2015.02.13 CHM-201533906 Rate Re-Apply 기능 개발  해당  Validation 추가
	msgs['TRS90610'] = 'The rate is not confimed, pls contact confirmation manager.';
	msgs['TRS90611'] = 'Rate is applied successfully.';
	
	msgs['TRS90620'] = 'S/O cannot be created under \'R\' status of BKG.';
	
	//2014.11.04 10만불비용결재관련
	msgs['TRS90621'] = '{?msg1} has been omitted.' ;   
	msgs['TRS90622'] = 'There is no CSR No. on selected row.' ; 
	msgs['TRS90623'] = 'There is no {?msg1}' ;  
	msgs['TRS90624'] = 'Approval request has been completed.';
	
	//Spot Bidding 관련 Message Start.
	msgs['TRS90700'] = 'Invitation email will be sent, are you sure to proceed?';
	msgs['TRS90701'] = 'Please input Due Date.';
	msgs['TRS90702'] = '{?msg1} is not corresponded.';
	msgs['TRS90703'] = 'S/O is only created without bid invitation.';
	msgs['TRS90704'] = '"From" and "To" are mandatory items for route.';
	msgs['TRS90705'] = '"From/Via/Door/To" are all mandatory for intermodal.';
	msgs['TRS90706'] = 'Cannot register under your office.';
	msgs['TRS90707'] = 'Duplicated data exists.';
	msgs['TRS90708'] = 'Please select S/P for Bid.';
	//Spot Bidding 관련 Message End.
	
	msgs['TRS90710'] = 'Not the lowest price. Please enter a reason.';
	msgs['TRS90711'] = 'S/P Select is not applicable to Door S/O.';
	msgs['TRS90712'] = "You are not finished yet, are you sure?";
	
	msgs['TRS90720'] = "Please input Sent Date.";
	msgs['TRS90721'] = "Please input S/O Office.";
	
	msgs['TRS90722'] = "VGM information should be inputted for rail billing.";
	
	msgs['TRS90723'] = "This Sevice Accounting Code is not valid code. Please check it again.";
	msgs['TRS90724'] = "S/P's CGST AMT and calculated CGST AMT do not match."; 
	msgs['TRS90725'] = "S/P's SGST AMT and calculated SGST AMT do not match.";
	msgs['TRS90726'] = "S/P's IGST AMT and calculated IGST AMT do not match.";
	msgs['TRS90727'] = "S/P's UGST AMT and calculated UGST AMT do not match.";
	
	msgs['TRS99999'] = 'Do you want to {?msg1} ({?msg2})?';
	
/****** trs_common start *********/
/*
 * Node를 비교하기 위해서 만든 function
 * Java의 HashTable과 비슷한 기능을 한다.
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
	for(var n in obj) {
		if(n == key) {
			obj[key] = value;
			flag = 1;
		}
	}
	if(flag == 0) {
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
	for(var i=0; i<obj.length; i++) {
		if(obj.charAt(i) == sep) {
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
	if( obj.length == 8 ) {
		objy = obj.substring(0, 4);
		objm = obj.substring(4, 6);
		objd = obj.substring(6);
	} else {
		return false;
	}
	var lverr = 0; // 에러 변수
	var lvmonday = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	if( objy%1000 != 0 && objy%4 == 0 )
		lvmonday[1] = 29; //윤년
	if( objd > lvmonday[objm-1] || objd < 1 )
		lverr = 1; //year check
	if( objm < 1 || objm > 12 )
		lverr = 1; //month check
	if( objm%1!=0 || objy%1!=0 || objd%1!=0 ) 
		lverr = 1; //number check
	if( lverr == 1 ) {
		return false;
	} else {
		return true;
	}
}

/**
 * 한글 여부에 대한 유효성을 체크.
 */
function dohancheck(obj) {
	var lveng = /[^a-z|A-Z]/;
	if( lveng.test(obj) ) {
	    errMsg = ComGetMsg('COM12123','This field');
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}

/**
 * 영문과 숫자에 대한 유효성을 체크.
 */
function doengnumcheck(obj) {
	var lveng = /[^a-z|A-Z|,|0-9|]/;
	if( lveng.test(obj) ) {
		errMsg = ComGetMsg('COM12127','This field');
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}

/**
 * 숫자 여부에 대한 유효성을 체크. (메시지 없음)
 */
function doNumcheckNoMsg(obj) {
	var lveng = /[^0-9]/;
	if( lveng.test(obj) ) {
		return false;
	}
	return true;
}

/**
 * 영문과 숫자에 대한 유효성을 체크. (메시지 없음)
 */
function doengnumcheckNoMsg(obj) {
	var lveng = /[^a-z|A-Z|,|0-9|]/;
	if( lveng.test(obj) ) {
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
	var lvFrom = lvfrmDate.substring(4, 6)+"-"+lvfrmDate.substring(6)+"-"+lvfrmDate.substring(0, 4);
	var lvTo = lvtoDate.substring(4, 6)+"-"+lvtoDate.substring(6)+"-"+lvtoDate.substring(0, 4);
	var fromDay = new Date(lvFrom);
	var toDay = new Date(lvTo);
	var objFT = (toDay.getTime()-fromDay.getTime()) / (24*60*60*1000);
	return objFT;
}

/**
 * 일자에 '-'제거 및 입력하는 함수
 *
 */
function delHypen(obj) { //hypen제거
	var lvobj = doSepRemove(obj.value, "-");
	obj.value = lvobj;
}
function getHypen(obj) { //hypen입력
	if( obj.value.length == 8 ) {
		obj.value = obj.value.substring(0, 4)+"-"+obj.value.substring(4,6)+"-"+obj.value.substring(6);
	}
}

/**
 * 숫자 소수점 2자리...리턴
 *
 */
 function myRound(src, pos) { 
		if (pos == null || pos==undefined )
		{
			pos = 2;
		}
		src = deleteComma(src);
		var posV = Math.pow(10, pos);
		var retNum = new String(Math.round(src*posV)/posV);

		var strArray = retNum.split('.');

		var dec = strArray[0];
		var dbl = strArray[1];

		if(isNaN(dec)) dec = '0';
		if(isNaN(dbl)){
			dbl = '';
			dbl = rpad(dbl, pos, '0');
		}else{
			dbl = rpad(dbl, pos, '0');
		}
		return dec+'.'+dbl;
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

function cntrCheckDigit(cntrNo){

 if (cntrNo.length != 10){

  return cntrNo;

 } 

 var sum = 0;
 cntrNo = cntrNo.toUpperCase();

 for(var i=0;i<10;i++){

  sum = sum + productValue( cntrNo.charAt(i),i);

 }

 var mod = sum % 11;

 if (mod == 10) mod =0;
 
 if (isNaN(mod)) return cntrNo;

 return cntrNo+mod;

 

}

/**
 * 컨테이너 번호 Check Digit 계산 함수 -product Value 계산 하는 로직을 포함한 메소드
 */
 
function productValue(str,position){

 var strMap = new Array("10","12","13","14","15","16","17","18","19","20","21","23","24","25","26","27","28","29","30","31","32","34","35","36","37","38");

 

 var num = new Number(str);

 if (isNaN(num)){

  var index = new Number(str.charCodeAt(0)-65) ;

  var strNum = strMap[index];


  return strNum * Math.pow(2, position);

 } else {

  return num* Math.pow(2, position);

 }

}

function multiCntrChkDgt(cntrList){
	if(cntrList == undefined || cntrList == '') return cntrList;

	var cntrArray = cntrList.split(',');
	var newCntrList = '';

	for(var i=0; i<cntrArray.length; i++){
		newCntrList += cntrCheckDigit(cntrArray[i]);
		if(i < cntrArray.length-1) newCntrList += ',';
	}
	return newCntrList;
}

/****** trs_common end *********/

/****** comboUtil start ********/
var comboObjects = new Array();
var comboCnt = 0 ;

/**
 * IBCombo Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * sheet내의 combo를 가져와서 등록한다.(셀단위)
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param row - combo가 세팅될 row
 * @param colName - combo가 세팅될 컬럼alias
 * @param value - 조회조건 location값
 **/
function getYardSheetCombo(sheetObj, formObject, row, colName, value)
{
	var srcValue = sheetObj.CellValue(row, colName);
	sheetObj.InitCellProperty(row, colName, dtCombo);
	formObject.f_cmd.value = SEARCH01;
	var queryString = "srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);

	sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
	
	fm_yard_value = sheetObj.EtcData('nod');
	sheetObj.RemoveEtcData();
	sheetObj.CellComboItem(row, colName, " |"+fm_yard_value, " |"+fm_yard_value) ;

	if(fm_yard_value == '')
	{
		ComShowCodeMessage('COM12161', value);
		sheetObj.CellValue2(row, colName)="";
		sheetObj.SelectCell(row, colName);
	}
}

/**
 * sheet내의 combo를 가져와서 등록한다.(셀단위)
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param row - combo가 세팅될 row
 * @param colName - combo가 세팅될 컬럼alias
 * @param value - 조회조건 location값
 **/
function getYardSheetCombo1(sheetObj, formObject, row, col, colName, value)
{
	var srcValue = sheetObj.CellValue(row, colName);
	sheetObj.InitCellProperty(row, colName, dtCombo);
	formObject.f_cmd.value = SEARCH01;
	var queryString = "srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
	sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);

	fm_yard_value = sheetObj.EtcData('TEXT');
	sheetObj.RemoveEtcData();
	sheetObj.CellComboItem(row, colName, " |"+fm_yard_value, " |"+fm_yard_value) ;
	
	if(fm_yard_value == '')
	{
		ComShowCodeMessage('COM12161', value);
		sheetObj.CellValue2(row, col)="";
		sheetObj.SelectCell(row, col);
	}
}

/**
 * location 조회에 따른 yard LIST를 가져온다.(예: a1|a2|a3|a4)
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
function getYardList(sheetObj, formObject, value)
{
    sheetObj.WaitImageVisible  = false;
	formObject.f_cmd.value = SEARCH01;
	var queryString = "searchStr="+value+"&"+TrsFrmQryString(formObject);
	sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
    sheetObj.WaitImageVisible  = true;
	return sheetObj.EtcData('nod');
}

/**
 * yard list를 combo에 설정한다.
 * @param comboObj - 설정될 combo객체
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
function getYardCombo(comboObj, sheetObj, formObject, value)
{
	var yardList = getYardList(sheetObj, formObject, value);
	var yardArray = new Array();
	yardArray = yardList.split("|");
	comboObj.RemoveAll();
	for(var i=0; i<yardArray.length; i++)
	{
		comboObj.InsertItem(i, yardArray[i], yardArray[i]);
	}
	return yardList;
}


/**
 * sheet내의 combo를 가져와서 등록한다.(셀단위)
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param row - combo가 세팅될 row
 * @param colName - combo가 세팅될 컬럼alias 
 * @param value - 조회조건 location값
 **/
function getZoneSheetCombo(sheetObj, formObject, row, colName, value)
{
	var srcValue = sheetObj.CellValue(row, colName);
	sheetObj.InitCellProperty(row, colName, dtCombo);
	formObject.f_cmd.value = SEARCH01;
	var queryString = "isZone=Y&srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
	sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
	
	fm_yard_value = sheetObj.EtcData('nod');
	sheetObj.RemoveEtcData();
	sheetObj.CellComboItem(row, colName, " |"+fm_yard_value, " |"+fm_yard_value);
	if(fm_yard_value == '')
	{
		ComShowCodeMessage('COM12161', value);
	}
}

/**
 * sheet내의 combo를 가져와서 등록한다.(셀단위)
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param row - combo가 세팅될 row
 * @param colName - combo가 세팅될 컬럼alias
 * @param value - 조회조건 location값
 **/
function getZoneSheetCombo1(sheetObj, formObject, row, col, colName, value)
{
	var srcValue = sheetObj.CellValue(row, colName);
	sheetObj.InitCellProperty(row, colName, dtCombo);
	formObject.f_cmd.value = SEARCH01;

	var queryString = "isZone=Y&srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
	sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
	
	fm_yard_value = sheetObj.EtcData('nod');
	sheetObj.RemoveEtcData();
	sheetObj.CellComboItem(row, colName, " |"+fm_yard_value, " |"+fm_yard_value) 
	
	if(fm_yard_value == '')
	{
		ComShowCodeMessage('COM12161', value);
		sheetObj.CellValue2(row, col)="";
		sheetObj.SelectCell(row, col);
	}
}

/**
 * location 조회에 따른 yard LIST를 가져온다.(예: a1|a2|a3|a4)
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
function getZoneList(sheetObj, formObject, value)
{
    sheetObj.WaitImageVisible  = false;
	formObject.f_cmd.value = SEARCH01;
	var queryString = "isZone=Y&searchStr="+value+"&"+TrsFrmQryString(formObject);
	sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
    sheetObj.WaitImageVisible  = true;
	return sheetObj.EtcData('nod');
}

/**
 * yard list를 combo에 설정한다.
 * @param comboObj - 설정될 combo객체
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
function getZoneCombo(comboObj, sheetObj, formObject, value)
{
	var zoneList = getZoneList(sheetObj, formObject, value);
	var zoneArray = new Array();
	zoneArray = zoneList.split("|");
	comboObj.RemoveAll();
	for(var i=0; i<zoneArray.length; i++)
	{
		comboObj.InsertItem(i, zoneArray[i], zoneArray[i]);
	}
	return zoneList;
}

/**
 * location 조회에 따른 yard+ZONE LIST를 가져온다.(예: a1|a2|a3|a4)
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
function getYardZoneList(sheetObj, formObject, value)
{
    sheetObj.WaitImageVisible  = false;
	formObject.f_cmd.value = SEARCH01;
	var queryString = "isZone=A&searchStr="+value+"&"+TrsFrmQryString(formObject);
	sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
    sheetObj.WaitImageVisible  = true;
	return sheetObj.EtcData('nod');
}

function getYardZoneCombo(comboObj, sheetObj, formObject, value)
{
	var yardList = getYardZoneList(sheetObj, formObject, value);
	var yardArray = new Array();
	yardArray = yardList.split("|");
	comboObj.RemoveAll();
	for(var i=0; i<yardArray.length; i++)
	{
		comboObj.InsertItem(i, yardArray[i], yardArray[i]);
	}
	return yardList;
}

/**
 * sheet내의 combo를 가져와서 등록한다.(셀단위)
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param row - combo가 세팅될 row
 * @param colName - combo가 세팅될 컬럼alias
 * @param value - 조회조건 location값
 **/
function getYardZoneSheetCombo1(sheetObj, formObject, row, col, colName, value)
{
	var srcValue = sheetObj.CellValue(row, colName);
	sheetObj.InitCellProperty(row, colName, dtCombo);
	formObject.f_cmd.value = SEARCH01;
	var queryString = "isZone=A&srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
	sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
	
	fm_yard_value = sheetObj.EtcData('nod');
	sheetObj.RemoveEtcData();
	sheetObj.CellComboItem(row, colName, " |"+fm_yard_value, " |"+fm_yard_value) 

	if(fm_yard_value == '')
	{
		ComShowMessage(ComGetMsg('COM12161', value));
		sheetObj.CellValue2(row, col)="";
		sheetObj.SelectCell(row, col);
	}
}

/**
 * 외부 콤보박스의 리스트 가져오기 Rail Road
 **/
 function getRailVendorComboList( combo , code , text , option) {

 	var vendorNoList = code;
 	var vendorNmList = text;

 	var vendorNoArray = new Array();
 	var vendorNmArray = new Array();
 
 	vendorNoArray = vendorNoList.split("|");
 	vendorNmArray = vendorNmList.split("|");
 
 	combo.RemoveAll();

 	for(var i=0; i<vendorNoArray.length; i++)
 	{
			combo.InsertItem(i, vendorNoArray[i]+'|'+vendorNmArray[i],  vendorNoArray[i]);
 	}
 	
      combo.InsertItem(0, option ,  option);
 }

/**
 * vendor list를 combo에 설정한다.
 * @param comboObj - 설정될 combo객체
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
 function getVendorCombo(comboObj, sheetObj, formObject, value, optionCode, optionText)
 {
 	formObject.f_cmd.value = SEARCH10;
 	var queryString = "searchStr="+value+"&"+TrsFrmQryString(formObject);

 	sheetObj.DoRowSearch("ESD_TRS_0014GS.do", queryString);

 	var vendorNoList = sheetObj.EtcData('vndr_no');
 	var vendorNmList = sheetObj.EtcData('vndr_nm_eng');

 	var vendorNoArray = new Array();
 	var vendorNmArray = new Array();

 	vendorNoArray = vendorNoList.split("|");
 	vendorNmArray = vendorNmList.split("|");

 	comboObj.RemoveAll();

 	for(var i=0; i<vendorNoArray.length; i++)
 	{
 		if(i==0 && optionCode != '' && optionCode != undefined){
 			comboObj.InsertItem(i, optionCode,  optionText);
 		}else{
 			comboObj.InsertItem(i, vendorNoArray[i]+'|'+vendorNmArray[i],  vendorNoArray[i]);
 		}
 	}
 	return vendorNoList;
 }

 function initVendorCombo(comboObj)
 {
 	comboObj.DropHeight = 200; 
 	comboObj.SetColAlign("left|left");
     comboObj.SetColWidth("60|300");
 }


 /*
  * Actual Customer 코드 입력으로 회사명 자동불러오는 기능
  */
 function getActualCustomerName(){
 	
 		var sheetObj7 = sheetObjects[6]; //7번째 시트 사용
 		var formObject = document.form;
 		formObject.f_cmd.value = SEARCH09;
 		
 		ComConfigSheet(sheetObjects[6]); //사용할 시트 초기화
 		initSheet(sheetObjects[6],6+1);
 		ComEndConfigSheet(sheetObjects[6]);
 		
 		sheetObj7.DoSearch4Post("ESD_TRS_0914GS.do", FormQueryString(formObject)); //조회
 
 		//조회 페이지의 입력 항목에 세팅
 		formObject.search_act_cust.value = sheetObj7.CellValue(1, 'fctry_nm');
 		formObject.door_delv_addr.value = sheetObj7.CellValue(1, 'fctry_addr');
 	   
 	 }

 
 function getTextVendorSeq(sheetObj, formObj, vndr_seq){

   formObj.f_cmd.value = SEARCH11;
   formObj.combo_svc_provider.value = get_only_num(vndr_seq);
   sheetObj.RemoveEtcData();
   sheetObj.DoRowSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));
   var vendorNoList = sheetObj.EtcData('vndr_no');
   var vendorNmList = sheetObj.EtcData('vndr_nm_eng');
   if (vendorNoList == undefined || vendorNoList == ''){
	   formObj.combo_svc_provider.value = '';
	   formObj.svc_provider.value = '';
	   return false;
   }
   formObj.combo_svc_provider.value = lpad(ComTrim(vendorNoList), 6, '0') ;
   formObj.svc_provider.value = vendorNmList;
   return true;
 }
 
 function getTextVndrSeq(sheetObj, formObj, vndr_seq, div){
	if (div == "chld") {
		formObj.f_cmd.value = SEARCH15;
		formObj.combo_svc_provider_chld.value = get_only_num(vndr_seq);
	}else if (div == "prnt") {
		formObj.f_cmd.value = SEARCH16;
		formObj.combo_svc_provider_prnt.value = get_only_num(vndr_seq);
	}
 	sheetObj.RemoveEtcData();
 	sheetObj.DoRowSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));

 	var vendorNoList = sheetObj.EtcData('vndr_no');
 	var vendorNmList = sheetObj.EtcData('vndr_nm_eng');

 	if (vendorNoList == undefined || vendorNoList == ''){
 		if (div == "chld") {
 			formObj.combo_svc_provider_chld.value = '';
 			formObj.svc_provider_chld.value = '';
 		}else if (div == "prnt") {
 			formObj.combo_svc_provider_prnt.value = '';
 			formObj.svc_provider_prnt.value = '';
 		}
 		return false;
 	}

	if (div == "chld") {
		formObj.combo_svc_provider_chld.value = lpad(ComTrim(vendorNoList), 6, '0') ;
		formObj.svc_provider_chld.value = vendorNmList;
	}else if (div == "prnt") {
		formObj.combo_svc_provider_prnt.value = lpad(ComTrim(vendorNoList), 6, '0') ;
		formObj.svc_provider_prnt.value = vendorNmList;
	}
 	return true;
 }
 
 function getTextCmdtCd(sheetObj, formObj, cmdt_cd){
	   formObj.f_cmd.value = SEARCH04;
	   formObj.commodity_cd.value = get_only_num(lpad(ComTrim(cmdt_cd), 6, '0'));
	   sheetObj.RemoveEtcData();
	   sheetObj.DoRowSearch("ESD_TRS_0999GS.do", TrsFrmQryString(formObj));
	
	   var cmdtCdList = sheetObj.EtcData('cmdt_cd');
	   var cmdtNmList = sheetObj.EtcData('cmdt_nm');
	
	   if (cmdtCdList == undefined || cmdtCdList == ''){
		   formObj.commodity_cd.value = '';
		   formObj.commodity_nm.value = '';
		   return false;
	   } else if(cmdt_cd==''){
		   formObj.commodity_cd.value = '';
		   formObj.commodity_nm.value = '';
		   return false;
	   }
	   formObj.commodity_cd.value = lpad(ComTrim(cmdtCdList), 6, '0') ;
	   formObj.commodity_nm.value = cmdtNmList;
	   return true;
 }
 

 function getTextCustCd(sheetObj, formObj, cust_cd){
    var temp; 
     var custCdVal = cust_cd.toUpperCase();
     // country code
     if ( custCdVal.length <= 2) {
         temp = custCdVal.substring(0);
     } else {
         temp = custCdVal.substring(0,2);
     }
     if ( temp.length != 2 || !ComIsAlphabet(temp) ) {
         ComShowCodeMessage("TRS90069");
         formObj.input_cust_cd.focus();
         formObj.input_cust_cd.select();
         formObj.input_cust_nm.value = "";
         formObj.input_cust_cd.value = "";
         return false;
     }
     
     // customer sequence 
     if ( custCdVal.length > 2) {
         temp = custCdVal.substring(2);
         if ( !ComIsNumber(temp) ) {
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
	   sheetObj.DoRowSearch("ESD_TRS_0999GS.do", TrsFrmQryString(formObj));
	
	   var custCdList = sheetObj.EtcData('input_cust_cd');
	   var custNmList = sheetObj.EtcData('input_cust_nm');
	   if (custCdList == undefined || custCdList == ''){
		   formObj.input_cust_cd.value = '';
		   formObj.input_cust_nm.value = '';
		   return false;
	   }	
	  
	   formObj.input_cust_nm.value = custNmList;
	   return true;
 }
/****** comboUtil end ********/

/****** stringUtil start *********/
String.prototype.trim = function(){
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

function chkAmtPos_JPY(src){
	src = deleteComma(src);
	if(isNaN(src)) src = '0';
	src = Number(src);
	var retNum = new String(Math.round(src));
	return retNum;
}

function chkAmtPos(src, pos){
	
	if (pos == null || pos==undefined )
	{
		pos = 2;
	}
	src = deleteComma(src);
	var posV = Math.pow(10, pos);
	var retNum = new String(Math.round(src*posV)/posV);

	var strArray = retNum.split('.');

	var dec = strArray[0];
	var dbl = strArray[1];

	if(isNaN(dec)) dec = '0';
	if(isNaN(dbl)){
		dbl = '';
		dbl = rpad(dbl, pos, '0');
	}else{
		dbl = rpad(dbl, pos, '0');
	}
	return dec+'.'+dbl;
}

function deleteComma(src){
	
	var src = String(src);
	if (src==null || ComTrim(src)==''){
		return '';
	}
	return src.replace(/,/gi,'');
}

function addComma(src){
	
	var src = String(src);
	if (src==null || ComTrim(src)==''){
		return '';
	}
	var re = /(-?\d+)(\d{3})/;
	while (re.test(src)) {
		src = src.replace(re, "$1,$2");
	}
	return  src;
}

function rpad(src, len, padStr){
	var retStr = "";
	var padCnt = Number(len) - String(src).length;
	for(var i=0;i<padCnt;i++) retStr += String(padStr);
	return src+retStr;
}

function lpad(src, len, padStr){
	var retStr = "";
	var padCnt = Number(len) - String(src).length;
	for(var i=0;i<padCnt;i++) retStr += String(padStr);
	return retStr+src;
}

function get_only_num(obj) {
	var str = escape(obj);
	var returnNum = '';
	for (i=0; i<str.length; i++){
		if (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57 )
		returnNum += str.charAt(i);
	}
	
	return returnNum;
}

/**
 * uppercase
 **/
function value_upper(obj){
	obj.value = obj.value.toUpperCase();
}

function checkDateFormat(dt){
	
	var date_regexp = "^(\\d{4}\\d{2}\\d{2})$";
	
	if (!checkFormat(dt, date_regexp)){
		return false;
	}
	return true;
}

function checkFormat(value, regexp){
	
		re = new RegExp(regexp,"gi"); 
		
		if (!re.test(value)){
			return false;
		}
	return true;
}


function toHtml(str){
	str = str.replace(/&/g,'@amp;');
	str = str.replace(/</g,'@lt;');
	str = str.replace(/>/g,'@gt;');
	str = str.replace(/,/g,'@#44;');
	str = str.replace(/\"/g,'@quot;');
	str = str.replace(/\'/g,'@acute;');
	str = str.replace(/\n/g,'@ffd;');
	str = str.replace(/\r/g,'@cgrtn;');
	return str;
}

function getPageURL(){

	var url = window.location+"";
	var startIndex = url.indexOf('/hanjin/');
	var endIndex = url.indexOf('.do');
	url = url.substring(startIndex+8, endIndex);

	return url;
}

/******** stringUtil end ***********/

/**
 * Focus 이동
 * 사용예: onKeyup="javascript:moveFocus(this, this.form.to_prd_dt, 10);"
 * 
 * @param {Object}		fromFormElement		from Form Element
 * @param {Object}		toFormElement		이동할 요소
 * @param {int,String}	numleng				number length
 **/
function moveFocus(fromFormElement, toFormElement, numleng) {
    var eleLeng = fromFormElement.value.length;
    if (eleLeng>=numleng){toFormElement.focus();}
}

/**
 * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     var sCondParam=TrsFrmQryString(document.frmSearch); //결과:"txtname=이경희&rdoYn=1&sltMoney=원화";
 * </pre>
 * @param {form} form Form 오브젝트
 * @return string
 * @version 1.0.0.0
 * @see #TrsFrmQryStringEnc
 */
function TrsFrmQryString(form) {

    if (typeof form != "object" || form.tagName != "FORM") {
        alert("Error : Please contact the administrator\n" + "Detail : Parameter of TrsFrmQryString Function is not a FORM Tag.");
        return "";
    }

    var name = new Array(form.elements.length);
    var value = new Array(form.elements.length);
    var j = 0;
    var plain_text="";

    //사용가능한 컨트롤을 배열로 생성한다.
    len = form.elements.length;
    for (i = 0; i < len; i++) {
      //클래스 아이디로 제품을 구분함-아래는 HTMl제품
      if(form.elements[i].classid==undefined){
    	  //전송전에 폼의 마스크를 제거한다.
//    	  ComClearSeparator(form.elements[i]);
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
                    if(ind >= 0) {
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
                    for( k = 0; k < llen; k++) {
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
                    if(increased > 0) {
                        j--;
                    } else {
                        value[j] = "";
                    }
                    j++;
                    break;
                default :
                    if(form.elements[i].value.length >0 ) {
                    	name[j] = form.elements[i].name;
                    	value[j] = form.elements[i].value;
                    	
                    	j++;
                    }
        }
	  	//전송후에 폼의 마스크를 다시 셋팅한다.
//      ComAddSeparator(form.elements[i]);
    //IB에서 제공하는 컨트롤의 값을 조합한다.
    }else{
      switch(form.elements[i].classid){
        case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":  // IBMaskEdit 경우
          name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
                value[j] = form.elements[i].Value;
                j++;
          break;
        case CLSID_IBMCOMBO: // IBMultiCombo 경우
          name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
          		if(form.elements[i].UseCode)
          			value[j] = form.elements[i].Code;
          		else
          			value[j] = form.elements[i].Text;
                j++;
                break;
      }
    }
    }

    // QueryString을 조합한다.
    //   1) Explorer 5.5 이상일 경우, encodeURIComponent() 를 이용하여 URL Encode
    //   2) 기타 경우는 IB Sheet 를 이용하여 URL Encode
    var webBrowserName = navigator.appName;
    var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
                                                        navigator.appVersion.indexOf("MSIE") + 8)

    if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
        for (i = 0; i < j; i++) {
            // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
            if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
        }
    } else {
        var tmpUrlEncodeSheet    = document.getElementById("TrsFrmQryString");

        if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '')
        {
            //인코딩을 위해 숨겨진IBSheet를 만든다.
            var sTag = ComGetSheetObjectTag("TrsFrmQryString");
            form.insertAdjacentHTML('afterEnd', sTag);
        }

        for (i = 0; i < j; i++) {
            // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
            if (name[i] != '') plain_text += name[i]+ "=" + TrsFrmQryString.UrlEncoding(value[i]) + "&";
        }
    }


  //마지막에 &를 없애기 위함
  if (plain_text != "")
    plain_text = plain_text.substr(0, plain_text.length -1);
    return plain_text;
}
 
 /**
  * 입력된 문자열이 년 Format YYYY이 맞는지를 확인
  *
  * @param obj        object
  * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
  * @param isN        널스트링 허용여부
  * @return true, false
  */
 function isValidYear(obj, isSet, isN) {
 	var rtn = true;
 	var str = obj.value;

 	if(!(str.length == 4)) { rtn = false; }
 	if (!(ComParseInt(str) >= 1900 && ComParseInt(str) <= 9999)) {
 		rtn = false;
 	}

 	if(isN && str == "") { rtn = true; }

 	if(rtn == false) {
 		ComShowMessage(ComGetMsg('TRS90386','Please enter Year correctly.\n\n Format : YYYY')); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
 		if(isSet) { obj.value = ""; }
 		obj.focus();
 	}

 	return rtn;
 }

 /**
  * 입력된 문자열이 주 Format WW이 맞는지를 확인
  *
  * @param obj        object
  * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
  * @param isN        널스트링 허용여부
  * @return true, false
  */
 function isValidWeek(obj, isSet, isN) {
 	var rtn = true;
 	var str = obj.value;
 	//str = fillZero(str,2,'0','left');

 	//if (!isNumSlash(obj) && !isNumPeriod(obj) && !isNumDash(obj)) { rtn = false; }
 	if (!(ComParseInt(str) >= 0 && ComParseInt(str) <= 53)) {
 		rtn = false;
 	}

 	if(isN && str == "") { rtn = true; }

 	if(rtn == false) {
 		ComShowMessage(ComGetMsg('TRS90386','Please enter Week correctly.\n\n Format : WW')); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
 		if(isSet) { obj.value = ""; }
 		obj.focus();
 	}

 	return rtn;
 }


 /**
  * 입력된 문자열이 월 Format MM이 맞는지를 확인
  *
  * @param obj        object
  * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
  * @param isN        널스트링 허용여부
  * @return true, false
  */
 function isValidMonth(obj, isSet, isN) {
 	var rtn = true;
 	var str = obj.value;
 	//str = fillZero(str,2,'0','left');

 	//if (!isNumSlash(obj) && !isNumPeriod(obj) && !isNumDash(obj)) { rtn = false; }
 	if (!(ComParseInt(str) >= 1 && ComParseInt(str) <= 12)) {
 		rtn = false;
 	}
 	if (!ComIsMonth(str)) {
 		rtn = false;
 	}

 	if(isN && str == "") { rtn = true; }

 	if(rtn == false) {
 		ComShowMessage(ComGetMsg('TRS90386','Please enter Month correctly.\n\n Format : MM')); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
 		if(isSet) { obj.value = ""; }
 		obj.focus();
 	}

 	return rtn;
 }
  
  
  /**
   * Sheet의 아래 5개 TRS 화면에서 기본 디자인을 설정한다. IBSheet에서 선택된 부분의 글자를 진하게 설정한다. 
   * 이 함수는 
   * Service Order > Creation > CY & Door (EUR) 화면
   * Service Order > Creation > CY & Door (USA)  화면
   * Service Order > Creation > CY & Door (ASIA)  화면
   * Service Order > Correction > CY & Door  화면
   * Work Order > Issuse 화면
   * Sheet 초기화 전에 호출해야 한다. <br>
   * 
   * 즉 Object태그 생성 직후에 이 함수를 호출하고, Sheet 초기화 한 후 마지막에 {@link #ComEndConfigSheet} 함수를 호출해야 한다. <br>
   * <br><b>Example :</b>
   * <pre>
   *     function loadPage() {
   *         for(var i=0;i&lt;sheetObjects.length;i++){
   *             //1.시작-환경 설정 함수 이름 변경
   *             ComConfigSheet(sheetObjects[i]);
   *			 ComConfigSheetTrs(sheetObjects[i]);
   *             //2. Sheet 초기화
   *             initSheet(sheetObjects[i],i+1);
   *
   *             //3. 마지막-환경 설정 함수 추가
   *             ComEndConfigSheet(sheetObjects[i]);
   *         }
   *     }
   * </pre>
   * @param {ibsheet} sheet_obj   필수,IBSheet Object ID
   * @return 없음
   * @see #ComConfigSheetTrs
   */
  function ComConfigSheetTrs(sheet_obj)
  {
      try {

          with (sheet_obj)
          {
				SelectHighLight = false;
				SelectFontBold = true;
          }
      } catch(err) { ComFuncErrMsg(err.message); }

  }  
  
  function changeObjectColor(objId, color, className){
       document.getElementById(objId).style.color = color;
  }
  
///**
//* btn1_ 으로 시작하는 태그명(버튼)에 대하여 Invisible 속성 정의(화면의 버튼 숨김 기능)
//*/
//function trsBtnInvisible()
//{
//   var tds = document.getElementsByTagName("td");
//   for( var idx = 0; idx < tds.length; idx++ ){
//	   var td = tds[idx];
//	   if( td.className.indexOf('btn1_') > -1 ){
//		   td.style.display ="none";
//	   }
//   }
//}

/**
* btn1_ 으로 시작하는 태그명(버튼)에 대하여 Invisible 속성 정의(화면의 버튼 숨김 기능)
* 사용법 : *.jsp 의 form 화면 구성 이후 세팅 : <script language="javascript">trsBtnInvisible("btn_minimize", sheetObjects[0], document.form);</script>
* name : 버튼명
* sheetObj : sheet Object
* formObj : form Object
*/
function trsBtnInvisible(name, sheetObj, formObj)
{
   var authFlg = "";
   var tds = document.getElementsByTagName("td");
   
   for( var idx = 0; idx < tds.length; idx++ ){
	   
	   if( tds[idx].id.indexOf(name) > -1 ){
		   tds[idx-1].style.display ="none";
		   tds[idx].style.display ="none";
		   tds[idx+1].style.display ="none";
		   
		   if( idx-1 >= 0 && idx+1 < tds.length ){
			   if( tds[idx-1].id.indexOf("btn") > -1 ){
				   tds[idx-1].style.display ="none";
			   }
			   
			   if( tds[idx+1].id.indexOf("btn") > -1 ){
				   tds[idx+1].style.display ="none";
			   }
		   }
		   
	   }
   }
}

/**
* btn1_ 으로 시작하는 태그명(버튼)에 대하여 Visible 속성 정의(권한에 따른 화면의 버튼 Visible)
* 사용법 : *.js 의 Loadpage에 세팅 : trsAuthBtnVisible("btn_minimize", sheetObjects[0], document.form);
* name : 버튼명
* sheetObj : sheet Object
* formObj : form Object
*/
function trsAuthBtnVisible(name, sheetObj, formObj)
{
	var authFlg = "";
	var tds = document.getElementsByTagName("td");
	
	formObj.f_cmd.value = SEARCH06;
    sheetObj.RemoveEtcData();
    sheetObj.DoRowSearch("ESD_TRS_0999GS.do", TrsFrmQryString(formObj));
    authFlg = sheetObj.EtcData('authFlg');
   
    if( authFlg == '1' ){
	    tds = document.getElementsByTagName("td");
	    for( var idx = 0; idx < tds.length; idx++ ){
	    	if( tds[idx].id.indexOf(name) > -1 ){
	    		tds[idx-1].style.display ="";
	    		tds[idx].style.display ="";
	    		tds[idx+1].style.display ="";
			   
	    		if( idx-1 >= 0 && idx+1 < tds.length ){
	    			if( tds[idx-1].id.indexOf("btn") > -1 ){
	    				tds[idx-1].style.display ="";
	    			}
				   
	    			if( tds[idx+1].id.indexOf("btn") > -1 ){
	    				tds[idx+1].style.display ="";
	    			}
	    		}
	    	}
	    }
    }
}

//날자포맷의 하이픈('-') 제거 : yyyy-mm-dd ==> yyyymmdd
function removeBarDate(obj) {
	var value = "";
	for ( var i = 0; i < obj.value.length; i++ ) {
		var ch = obj.value.charAt(i);
		if ( ch != '-' ) value = value + ch;
	}
	obj.value = value;
	obj.select();
}


//날자포맷의 하이픈('-') 삽입 : yyyymmdd ==> yyyy-mm-dd
function addBarDate(obj) {
	if( obj.value.length == 8 ){
		obj.value = obj.value.substr(0,4) + '-' + obj.value.substr(4,2) + '-' + obj.value.substr(6,2);
	}
}


function trsBlurDate(obj){
    if( obj.value == "" ){
	    return;
    }
    if( !ComIsDate(obj) ){
		ComShowCodeMessage('COM12179');
		obj.focus();
		return ;
	} else{
	    addBarDate(obj);
	}
}

/**
 * 날짜 From To 에대한 개월수를 초과하는지 검사하여 From + months >= To일 경우 false를 반대의 경우 True를 return 한다.
 * @author 박만건
 * @param fromDate 시작일
 * @param toDate 종료일
 * @param months 검사할 최대개월수
 * @param formatStr 날짜 포멧 문자
 * @return boolean
 * @version 2009.07.02
 */
function trsMonthsBetweenCheck(fromDate, toDate, months, formatStr){
    var fmtStr = "";
    if (formatStr == null || formatStr == "") {
        fmtStr = "-";
    } else {
        fmtStr = formatStr;
    }
    var ufFromDate = fromDate.replace(eval("/" + fmtStr + "/gi"), "");
    var ufToDate = toDate.replace(eval("/" + fmtStr + "/gi"), "");

    var fYear  = parseInt(ufFromDate.substring(0,4));
    var fMonth = ufFromDate.substring(4,5)=="0"?parseInt(ufFromDate.substring(5,6))-1:parseInt(ufFromDate.substring(4,6))-1;
    var fDay   = ufFromDate.substring(6,7)=="0"?parseInt(ufFromDate.substring(7,8)):parseInt(ufFromDate.substring(6,8));

    var tYear  = parseInt(ufToDate.substring(0,4));
    var tMonth = ufToDate.substring(4,5)=="0"?parseInt(ufToDate.substring(5,6))-1:parseInt(ufToDate.substring(4,6))-1;
    var tDay   = ufToDate.substring(6,7)=="0"?parseInt(ufToDate.substring(7,8)):parseInt(ufToDate.substring(6,8));

    var bLastDay = false;
    var iLastDay = ComGetLastDay(fYear, fMonth +1);
    if (iLastDay == fDay) { bLastDay = true; }

    // 월처리
    for (var i = 0; i< months; i++ ) {
        fMonth = fMonth + 1;
        if (fMonth > 11) {
            fYear = fYear + 1;
            fMonth = 0;
        }
    }

    // 말일이면 변경된 월의 말일을 가져온다.
    if(bLastDay) {
        fDay = ComGetLastDay(tYear, tMonth +1);;
    }

    var dAddedDate =new Date("" + fYear, "" + fMonth, "" + fDay);
    var dToDate = new Date("" + tYear, "" + tMonth , "" + tDay);

    diffDay = ( dAddedDate - dToDate) /(1000*3600*24);
    if ( diffDay > 0) {
        return true;
    }
    return false;
}

//W/O No Validation 추가 2013.11.13 조인영
function woNoCheck(obj){
	var woOfcCd; 
	var woSeq;
	var aRray = new Array();
	var woOfcCdArray = new Array(); 
	var woSeqArray = new Array();
    if ( obj.length <= 4) {
    	ComShowCodeMessage("COM12114","W/O No");
    	return false;
    }
    if(obj.split(',').length > 1){
    	aRray = obj.split(',');
		for( var e = 0; e < aRray.length; e++ ) {
			woOfcCdArray[e] = aRray[e].substring(0,3);
		    if ( !ComIsAlphabet(woOfcCdArray[e]) ) {
		        ComShowCodeMessage("COM12114","W/O No");
		        return false;
			}
		    woSeqArray[e] = aRray[e].substring(3);
		    if ( !ComIsNumber(woSeqArray[e]) ) {
		 	    ComShowCodeMessage("COM12114","W/O No");
		         return false;
		    }
		}
    }else{
    	woOfcCd = obj.substring(0,3);
        if ( !ComIsAlphabet(woOfcCd) ) {
            ComShowCodeMessage("COM12114","W/O No");
            return false;
        }
        woSeq = obj.substring(3);
        if ( !ComIsNumber(woSeq) ) {
     	    ComShowCodeMessage("COM12114","W/O No");
             return false;
        }
    }
    return true;
}

//S/O No Validation 추가 2013.11.13 조인영
function soNoCheck(obj){
	var soOfcCd; 
	var soSeq;
	var aRray = new Array();
	var soOfcCdArray = new Array(); 
	var soSeqArray = new Array();
    if ( obj.length <= 4) {
    	ComShowCodeMessage("COM12114","S/O No");
    	return false;
    }
    if(obj.split(',').length > 1){
    	aRray = obj.split(',');
		for( var e = 0; e < aRray.length; e++ ) {
			soOfcCdArray[e] = aRray[e].substring(0,3);
		    if ( !ComIsAlphabet(soOfcCdArray[e]) ) {
		        ComShowCodeMessage("COM12114","S/O No");
		        return false;
			}
		    soSeqArray[e] = aRray[e].substring(3);
		    if ( !ComIsNumber(soSeqArray[e]) ) {
		 	    ComShowCodeMessage("COM12114","S/O No");
		         return false;
		    }
		}
    }else{
    	soOfcCd = obj.substring(0,3);
        if ( !ComIsAlphabet(soOfcCd) ) {
            ComShowCodeMessage("COM12114","S/O No");
            return false;
        }
        soSeq = obj.substring(3);
        if ( !ComIsNumber(soSeq) ) {
     	    ComShowCodeMessage("COM12114","S/O No");
             return false;
        }
    }
    return true;
}


/**
 * IBSheet의 GetSearchXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 TOTAL 값을 리턴한다.
 * <br><b>Example :</b>
 * <pre>
 *     xmlStr = mySheet.GetSearchXml("list.jsp");
 *     sTotal = ComGetTotalRows(xmlStr);
 * </pre>
 * @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
 * @return  string, 결과 xml의 조회 건수 리턴
 * @version 3.4.0.50
 */
function ComGetTotalRows(xmlStr){
    if(xmlStr == null  || xmlStr == "") return;

    try {
        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;

        var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
        if(dataNode == null) 
       	 return;
        else 
       	 return dataNode.getAttribute("TOTAL");

    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * @param {string}
 *            xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @return ListMap
 * @version 2009.06.01
 */
function TrsXmlToListMap(xmlStr) {
	
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return rtnArr;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return rtnArr;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return rtnArr;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		if (total == 0) {
			return rtnArr;
		}
		
		var dataChileNodes = dataNode.childNodes;
		if (dataChileNodes == null) {
			return rtnArr;
		}

		for ( var i = 0; i < dataChileNodes.length; i++) {
			if (dataChileNodes[i].nodeType != 1) {
				continue;
			}
			
			var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);
			var subDataArr = new Array();
			
			for ( var j = 0; j < arrData.length; j++) {
				subDataArr[colArr[j]] = arrData[j];
			}
			
			rtnArr[i] = (subDataArr);
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

/**
 * 버튼의 스타일을 blue색의 Enable 상태로 한다.  <br>
 * <br><b>Example : </b>
* <pre>
*    ComBtnEnable("btn_add") //btn_add 버튼을 blue색으로 Enable
* </pre>
* @param {string} name   필수, 버튼 name 문자열
* @returns 없슴
* @see #ComBtnDisable
*/
function ComBtnEnableRedFont(name) {

	var tds = document.getElementsByTagName("td"); 
	for ( var i = 0; i < tds.length; i++) { 
		var td = tds[i];
		if (td.className.length > 0 && td.name == "no_"+name) {
			if (td.className.indexOf('_1') > 0)
				td.className = td.className.replace(/_1/i, "_3");
			td.name=name; 
		}
	}

}


/**
* local time search
* 사용법 : *.js 의 Loadpage에 세팅 : getLocalTime(sheetObj, formObj, "ATLSC");
* getLocalTime(sheetObj,formObj,formObj.FORM_USR_OFC_CD.value);
* var locl_dt_tm = sheetObj.EtcData('locl_dt_tm');
* sheetObj.RemoveEtcData();
* name : 버튼명
* sheetObj : sheet Object
* formObj : form Object
*/
function getLocalTime(sheetObj,formObj,ofc_cd){
	formObj.f_cmd.value = SEARCH09;
    sheetObj.DoRowSearch("ESD_TRS_0999GS.do", TrsFrmQryString(formObj)+"&ofc_cd="+ofc_cd);
}

/**
 * 외부 콤보박스의 리스트 가져오기
 **/
function getTrsIbComboList( combo , code , text , option) {
	var cdList = code;
	var NmList = text;

	var cdArray = new Array();
	var nmArray = new Array();

	cdArray = cdList.split("|");
	nmArray = NmList.split("|");

	combo.RemoveAll();

	for(var i=0; i<cdArray.length; i++)
	{
		combo.InsertItem(i, nmArray[i]+'|'+cdArray[i],  cdArray[i]);
	}
	if (option == 'ALL') {
		combo.InsertItem(0, '' ,  '');
	}
}

//중복 데이터 제거 함수
function fn_DeDuplication(p_str) {
	//중복 제거를 위하여 값을 배열로 만든 후 정렬
	var arr_value	= p_str.split(",").sort();
  //Loop를 돌면서 중복되는 값이 있을 경우 ''로 처리
	for(i=0; i<arr_value.length-1; i++){
		if(arr_value[i]==arr_value[i+1]){
			arr_value[i]='';
		}
	}
	//빈 배열 제거를 위하여 다시 문자열로 변환
	var v_str = arr_value.toString();
	//빈 것이 아닐 경우 다시 배열에 입력
	arr_value = v_str.match(/\w+/g);
	//배열을 문자열로 변환하여 리턴
	
	if (arr_value != null) {
		v_str = arr_value.toString();
	}
	return v_str
}