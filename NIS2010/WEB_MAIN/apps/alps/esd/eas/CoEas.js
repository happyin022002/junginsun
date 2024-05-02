/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CoEas.js
 *@FileTitle : EAS Common javascript
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.20
 *@LastModifier : 조풍연
 *@LastVersion : 1.0
 * 2009.08.20 조풍연
 * 1.0 Creation
=========================================================*/

// --------------------------------------------------------
// 메세지 관련
// 샘플 msgs["GEM01001"] = "{?msg1} {?msg2}하십시오.";
// -------------------------------------------------------

	// EAS 관련 메세지 
    msgs['EAS90001'] = 'Please enter S/O date.\n\n Format : YYYYMM';
    msgs['EAS90002'] = 'Please enter S/O Office Code.\n\n '; 
    msgs['EAS90004'] = 'Please enter {?msg1}.'; 
    msgs['EAS90005'] = '{?msg1} : Please Check Length.'; 
    msgs['EAS90006'] = 'Do not Display! Cntr qty = 1'; 
    msgs['EAS90007'] = 'Month is mandatory!.';
    msgs['EAS90008'] = 'VVD is mandatory!.';
    msgs['EAS90009'] = 'SO Month is mandatory!.';
    msgs['EAS90010'] = 'SO Date is mandatory!.';
    msgs['EAS90011'] = 'Create by Only Europe Office';
    msgs['EAS90012'] = 'Update only Create Office.';
    msgs['EAS90013'] = 'Delete only Create Office.';
    msgs['EAS90014'] = 'Check for Duplicated Location, Customer, Origin, T/S.';
    msgs['EAS90015'] = 'Inserted Location Code does not Exist.';
    msgs['EAS90016'] = 'Inserted Customer Code does not Exist.';
    msgs['EAS90017'] = 'Inserted Type/Size Code does not Exist.';
    msgs['EAS90018'] = 'Inserted Currency Code does not Exist.';
    msgs['EAS90019'] = 'Effective Date is mandatory!.';
    msgs['EAS90020'] = 'Please enter Region/Country or Customer.';
    msgs['EAS90021'] = 'Booking does not require other options';
    msgs['EAS90022'] = 'The service is not available now';
    msgs['EAS90023'] = 'Please enter Country or RFA.';
    msgs['EAS90024'] = 'User office is different.';
    msgs['EAS90025'] = 'Wrong SCC code is found.[1]';
    msgs['EAS90026'] = 'There is errors in data form.';
	msgs['EAS90027'] = 'From date must be earlier than To date';
	msgs['EAS90028'] = 'Please input Effective From date.';
	msgs['EAS90029'] = 'Please input detailed information of the 1st version.';
	msgs['EAS90030'] = 'No rate inputted. Please input.';
	msgs['EAS90031'] = 'Wrong SCC code is found.[2]';
	msgs['EAS90032'] = 'Wrong SCC code is found.[3]';
	msgs['EAS90033'] = 'Wrong SCC code is found.[4]';
	msgs['EAS90034'] = 'Wrong SCC code is found.[5]';
	msgs['EAS90035'] = "When All Exempted is 'Y', all of the rates should be 'E'.";
	msgs['EAS90036'] = "When All Exempted is 'N', one of the rate should not be 'E'."; 
	msgs['EAS90037'] = "SCC '{?msg1}' is wrong.";
	msgs['EAS90038'] = 'Country code is missing.';
	msgs['EAS90039'] = 'RFA number is missing.';
	msgs['EAS90040'] = 'RFA does not exist.';
	
	msgs['EAS90041'] = 'It was transmitted successfully.';
	msgs['EAS90042'] = 'Failed to save data.';
	msgs['EAS90043'] = 'Please check E-mail address or Fax no.'	;
	msgs['EAS90044'] = 'Fax sending is fail.'	;
	
	msgs['EAS00144'] = 'Duplicated {?msg1}!';
	msgs['EAS00009'] = "At least one row needs to be selected";
	msgs['EAS05014'] = 'Pls input {?msg1}!';

	msgs['EAS29018'] = '[LCC] code is invalid.';
	msgs['EAS29019'] = '[ECC] code is invalid.';
	msgs['EAS29020'] = '[SCC] code is invalid.';
	msgs['EAS29021'] = '[Yard] code is invalid.';
	msgs['EAS29008'] = '[RCC] code is invalid.';
	msgs['EAS29009'] = 'Office code is invalid.';
	
	//DOD INV 기능 사용 메세지
	msgs['EAS80001'] = 'Pls select {?msg1}';
	msgs['EAS80002'] = 'Limited up to 100 invoices at a time';
	msgs['EAS80003'] = 'Do you want to interface the selected invoices?';
	msgs['EAS80004'] = 'Do you want to cancel the selected invoices?';
	msgs['EAS80005'] = 'Please recheck Seq. {?msg1}. Attention/Tel./Fax/E-mail duplicated!';
	msgs['EAS80006'] = 'Attention Info for Invoice sheet cannot be deleted!';
	msgs['EAS80007'] = 'Pls input Payer code first!';
	msgs['EAS80008'] = 'Pls check and update in Payer Info!(New DOD Payer information or Fax/Email must be saved in Payer Info first)';
	msgs['EAS80009'] = 'Can not be Issued in this case.(Booking Delivery Term : Door)'
	msgs['EAS80010'] = "Please check period. The maximum period is {?msg1}.";
	msgs['EAS80011'] = "Please check Tariff. There is no tariff information.({?msg1})";
	msgs['EAS80012'] = "Same Effective already exist. \nAfter checking Effective, please retrieve again";
	
	//DOD EDI
	msgs['EAS00079'] = "EDI was transmitted successfully."
	msgs['EAS00080'] = "Transmit Failed."
		
	msgs['EAS90045'] = 'Mandatory field is missing.  Please enter [{?msg1}].';		
	msgs['EAS90046'] = 'Do you want to {?msg1} the selected item? ';		
	
	//EAC 개발
	msgs['EAS90047'] = '{?msg1} code is invalid.';
	msgs['EAS90048'] = 'Selected Row cannot be EAC_Transfer. because EAC No. already exist.';
	msgs['EAS90049'] = 'You must Confirm for selected row before EAC Transfer.';

	msgs['EAS90050'] = '[setFileUpload] The file path is not correct.';
	msgs['EAS90051'] = 'Please select at least one row.' ;
	msgs['EAS90052'] = "Attached File is deleted due to storage server capacity";
	msgs['EAS90053'] = "EAC Transfer success.";	
	msgs['EAS90054'] = 'Please select Issue Type.';
	msgs['EAS90055'] = 'Rejection notice Send - Success!';
	msgs['EAS90056'] = 'Rejection notice Send - Fail!';
	msgs['EAS90057'] = 'Please file attach after EAC Registration!';
	msgs['EAS90058'] = 'Please file attach after EAC Transfer!';

	msgs['EAS90059'] = 'Missing TPB Office.\nPlease proceed after registration TPB office.';
	msgs['EAS90060'] = 'This Expense Audit case has been interfaced already to TPB case.';
	msgs['EAS90061'] = 'Do you want to delete?';
	msgs['EAS90062'] = 'Deleted Fail';
	msgs['EAS90063'] = 'EAC has been deleted';
	msgs['EAS90064'] = 'Do you want to issue?';
	msgs['EAS90065'] = 'issued Fail';
	msgs['EAS90066'] = 'EAC has been issued.';
	msgs['EAS90067'] = 'If expense type code is PSO,  vessel code(VVD) should be chosen by you';
	msgs['EAS90068'] = "If expense type code is not PSO, you can't choose vessel code (VVD)";
	msgs['EAS90069'] = "Please interface after input 3RD Party Item.";
	msgs['EAS90070'] = "Same S/P Code and Invoice number \nalready exist on 3rd Party Billing. \n[{?msg1}]";
	msgs['EAS90071'] = "Do you want to progress TPB I/F?";
	msgs['EAS90072'] = "[{?msg1}]\nis the duplicate data. Do you want to save?";
	msgs['EAS90073'] = "You did'nt check any Rows!";
	msgs['EAS90074'] = "E-mail address check";
	msgs['EAS90075'] = "Possible inquiry period is limited to 12 month";
	msgs['EAS90076'] = "Do you want to confirm?";
	msgs['EAS90077'] = "confirm Fail";
	msgs['EAS90078'] = "EAC has been confirmed.";
	msgs['EAS90079'] = "Possible inquiry period is limited to 12 month.";
	msgs['EAS90080'] = "fax number check";
	msgs['EAS90081'] = "reject Fail";
	msgs['EAS90082'] = "EAC has been rejected.";
	msgs['EAS90083'] = "Do you send the rejection notice to S/P?";
	msgs['EAS90084'] = "Carbon Copy address check";
	msgs['EAS90085'] = "There is no user information in Personnel Config";
	msgs['EAS90086'] = "There is no user information in Office Config";
	msgs['EAS90087'] = "The period cannot exceed 3 months"
	msgs['EAS90088'] = "Possible inquiry period is limited to 6 month.";
	
	msgs['EAS90098'] = '\'Button\' function is not working at this moment. \n\n Please contact the system administrator.';
	msgs['EAS90099'] = "Do you want to {?msg1}?";
	msgs['EAS90100'] = "Audit Result Audit can only be EAC transferred available.";
	
	msgs['EAS90101'] = "EAC Interface is failed. Please, Check BKG NO., W/O Surcharge CUR and W/O S/P of selected data"; 
	msgs['EAS90102'] = "EAC Interface is failed. Please, Check BKG NO., Work Order Amount Currency, W/O Iss OFC and Invoice S/P of selected data";
	msgs['EAS90103'] = 'EAC I/F has been already completed.';
	msgs['EAS90104'] = "The period cannot exceed {?msg1} days."
	msgs['EAS90105'] = "EAC Interface is failed. Please, Check BKG NO., W/O Surcharge CUR, S/O Office and W/O S/P of selected data";
	msgs['EAS90106'] = "US Rail will not be able to retrieve the average price.";
	msgs['EAS90107'] = "Please, select same BKG No.";
	msgs['EAS90108'] = "Only 'Candidate EAC' or 'Potential EAC' EAC I/F is possible.";
	msgs['EAS90109'] = "There is no Agreement header information.\n\n Please check again.";
	
	// EAS MNR
	msgs['EAS90201'] = "Office Code has been duplicated.";
	msgs['EAS90202'] = "You can\'t delete RHQ Office Code.";
	msgs['EAS90203'] = "Do you want to delete it?";
	msgs['EAS90204'] = "Office Code does not exist.";
	msgs['EAS90205'] = "Do you want to add it?";
	msgs['EAS90207'] = 'BackEndJob Request Fail!';
	msgs['EAS90208'] = 'It was already created. Please check it again.';
	msgs['EAS90209'] = 'Office code has been duplicated.';
	msgs['EAS90210'] = 'Please add the office code ({?msg1}) first!';
	msgs['EAS90211'] = 'Please input a text more than 10 byte at least.';
	
	msgs['EAS90212'] = 'It is included in the re-batch target.';
	msgs['EAS90213'] = 'Re-batch Target is unable to register the change detail.';
	msgs['EAS90214'] = 'Already invoice included in re-batch target.';
	msgs['EAS90215'] = "Possible inquiry period is limited to 3 month.";
	
    msgs['EAS99999'] = '{?msg1}.'; 
	

    /****** common start *********/
    /** sheet 관련여부 **/
    var sheetObject = null ;
    var sheetRow    = 0 ;

    /** mult check 관련 변수 **/ 
    var multiChkYN = false ;

    /** Location 관련 변수 **/
    var contiCdFld    = "" ;
    var scontiCdFld   = "" ;
    var cntCdFld      = "" ;
    var locStateFld   = "" ;
    var locEqOfcFld   = "" ;
    var locCdFld      = "" ;
    var locDescFld    = "" ;
    var locPortIndFld = "" ;
    var sysCodeFld    = "" ;

    /** Office 관련 변수 **/
    var ofcLevFld   = "" ;
    var ofcPtsCdFld = "" ;
    var ofcCdFld    = "" ;
    var ofcNmFld    = "" ;
    var callTypeFld = "" ;


    /** Customer 관련 변수 **/
    var custCdFld   = "" ;
    var custNmFld   = "" ;
    var custSgmtFld = "" ;

    /** VVD 관련 변수 **/
    var etdetaFld = "" ;
    var sDateFld  = "" ;
    var eDateFld  = "" ;
    var vvdCdFld  = "" ;
    var laneCdFld = "" ;
    var operFld   = "" ;

    /** Node 관련 변수 **/
    var nodeCdFld   = "" ;
    var nodeNmFld   = "" ;
    var modeFld     = "" ;
    var modeOnlyFld = "" ;

    /** Service Provider 관련 변수 **/
    var ptsVndrCdFld = "" ;
    var vndrNmEngFld = "" ;

    /** Staff 관련 변수 **/
    var userCdFld = "" ;
    var userNmFld = "" ;



    /**
     *  Location 공통 팝업 오픈
     * 
     * @param multi check 여부
     * @param locCd Loc Code
     * @param locDesc Loc Name
     * @param contiCd Conti
     * @param ScontiCd Sub Conti
     * @param cntCd Country
     * @param locState State
     * @param locEqOfc Control Office
     * @param locPortInd Port Only
     * @param sysCode System
     */
    function openLocPop(multi, locCd, locDesc, contiCd, scontiCd, cntCd,
                        locState, locEqOfc, locPortInd, sysCode){
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;
    	
    	param  = "?classId=" + getCommPopClassId() ; 
    	param += getURLParam(multi, "conti_cd",     contiCd) ;
    	param += getURLParam(multi, "sconti_cd",    scontiCd) ;
    	param += getURLParam(multi, "cnt_cd",       cntCd) ;
    	param += getURLParam(multi, "loc_state",    locState) ;
    	param += getURLParam(multi, "loc_eq_ofc",   locEqOfc) ;
    	param += getURLParam(multi, "loc_cd",       locCd) ;
    	param += getURLParam(multi, "loc_desc",     locDesc) ;
    	param += getURLParam(multi, "loc_port_ind", locPortInd) ;
    	param += getURLParam(multi, "sysCode",      sysCode, "ENIS") ;

    	comPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'setValFromLocPop', display) ;
    	contiCdFld    = contiCd ;
    	scontiCdFld   = scontiCd ;
    	cntCdFld      = cntCd ;
    	locStateFld   = locState ;
    	locEqOfcFld   = locEqOfc ;
    	locCdFld      = locCd ;
    	locDescFld    = locDesc ;
    	locPortIndFld = locPortInd ;
    	sysCodeFld    = sysCode ;
    	multiChkYN    = multi
    }

    /**
     *  Location 공통 팝업 오픈(sheet)
     * 
     * @param sheetObj IBSheet Object
     * @param row Row
     * @param multi check 여부
     * @param locCd Loc Code
     * @param locDesc Loc Name
     * @param contiCd Conti
     * @param ScontiCd Sub Conti
     * @param cntCd Country
     * @param locState State
     * @param locEqOfc Control Office
     * @param locPortInd Port Only
     * @param sysCode System
     */
    function openLocPopSheet(sheetObj, row, multi, locCd, locDesc, contiCd, scontiCd, cntCd,
                        locState, locEqOfc, locPortInd, sysCode){
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;
    	
    	contiCdFld    = contiCd ;
    	scontiCdFld   = scontiCd ;
    	cntCdFld      = cntCd ;
    	locStateFld   = locState ;
    	locEqOfcFld   = locEqOfc ;
    	locCdFld      = locCd ;
    	locDescFld    = locDesc ;
    	locPortIndFld = locPortInd ;
    	sysCodeFld    = sysCode ;
    	multiChkYN    = multi
    	sheetRow      = row ;	
    	sheetObject   = sheetObj ;
    	
    	param  = "?classId=" + getCommPopClassId() ; 
    	param += getURLParam(multi, "conti_cd",     contiCd) ;
    	param += getURLParam(multi, "sconti_cd",    scontiCd) ;
    	param += getURLParam(multi, "cnt_cd",       cntCd) ;
    	param += getURLParam(multi, "loc_state",    locState) ;
    	param += getURLParam(multi, "loc_eq_ofc",   locEqOfc) ;
    	param += getURLParam(multi, "loc_cd",       locCd) ;
    	param += getURLParam(multi, "loc_desc",     locDesc) ;
    	param += getURLParam(multi, "loc_port_ind", locPortInd) ;
    	param += getURLParam(multi, "sysCode",      sysCode, "ENIS") ;

    	comPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'setValFromLocPop', display) ;
    }

    /**
     * Location 공통 팝업에서 호출하는 함수
     * 
     * @param rowArray 결과값
     */
    function setValFromLocPop(rowArray){
    	var colArray = null ;
    	var gubun    = '';
    	
    	if(multiChkYN){
    		
    		for(i=0; i<rowArray.length; i++){
    			if(i<rowArray.length-1) gubun = ',';
    			else gubun = "" ;
    			colArray = rowArray[i];
    			setValFromLocArray(colArray, gubun, i)
    		}
    	}
    	else{
    		colArray = rowArray[0] ;
    		setValFromLocArray(colArray,gubun, 0) ;
    	}
    	
    	sheetObject = null ;
    	sheetRow    = 0 ;
    	
     }
     
     /**
     * Location 에서 넘어온 값을 field에 세팅
     * 
     * @param colArray 한 row의 column 배열
     * @param gubun 다중선택시 값의 구분
     * @param idx row의 index
     */
    function setValFromLocArray(colArray, gubun, idx){
    	setValToFld(colArray, contiCdFld,  idx,  5, gubun) ;
    	setValToFld(colArray, scontiCdFld, idx,  6, gubun) ;
    	setValToFld(colArray, cntCdFld,    idx,  8, gubun) ;
    	setValToFld(colArray, locStateFld, idx,  9, gubun) ;
    	setValToFld(colArray, locEqOfcFld, idx, 10, gubun) ;
    	setValToFld(colArray, locCdFld,    idx,  3, gubun) ;
    	setValToFld(colArray, locDescFld,  idx,  4, gubun) ;
    }

     /**
     *  Office 공통 팝업 오픈
     * 
     * @param multi multi check 여부
     * @param ofcCd Office Code
     * @param ofcNm Office Name
     * @param callType Call TYpe
     * @param ofcLev Office Level
     * @param ofcPtsCd Parent Office
     */
    function openOfcPop(multi, ofcCd, ofcNm, callType, ofcLev, ofcPtsCd){
    	var formObj = document.form ;
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;
    	
    	param  = "?classId=" + getCommPopClassId() ;
    	param += getURLParam(multi, "ofc_lev",    ofcLev) ;
    	param += getURLParam(multi, "ofc_pts_cd", ofcPtsCd) ;
    	param += getURLParam(multi, "ofc_cd",     ofcCd) ;
    	param += getURLParam(multi, "ofc_nm",     ofcNm) ;
    	param += getURLParam(multi, "CallType",   callType, "2") ;
    	
    	comPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'setValFromOfcPop', display) ;
    	ofcLevFld   = ofcLev ;
    	ofcPtsCdFld = ofcPtsCd ;
    	ofcCdFld    = ofcCd ;
    	ofcNmFld    = ofcNm ;
    	callTypeFld = callType ;
    	multiChkYN  = multi ;
    }

    /**
     *  Office 공통 팝업 오픈(sheet)
     * 
     * @param sheetObj IBSheet Object
     * @param row Row
     * @param multi multi check 여부
     * @param ofcCd Office Code
     * @param ofcNm Office Name
     * @param callType Call TYpe
     * @param ofcLev Office Level
     * @param ofcPtsCd Parent Office
     */
    function openOfcPopSheet(sheetObj, row, multi, ofcCd, ofcNm, callType, ofcLev, ofcPtsCd){
    	var formObj = document.form ;
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;
    	
    	ofcLevFld   = ofcLev ;
    	ofcPtsCdFld = ofcPtsCd ;
    	ofcCdFld    = ofcCd ;
    	ofcNmFld    = ofcNm ;
    	callTypeFld = callType ;
    	multiChkYN  = multi ;
    	sheetRow    = row ;	
    	sheetObject = sheetObj ;	
    	
    	param  = "?classId=" + getCommPopClassId() ;
    	param += getURLParam(multi, "ofc_lev",    ofcLev) ;
    	param += getURLParam(multi, "ofc_pts_cd", ofcPtsCd) ;
    	param += getURLParam(multi, "ofc_cd",     ofcCd) ;
    	param += getURLParam(multi, "ofc_nm",     ofcNm) ;
    	param += getURLParam(multi, "CallType",   callType, "2") ;
    	
    	comPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'setValFromOfcPop', display) ;
    }


    /**
     * Office 공통 팝업에서 호출하는 함수
     * 
     * @param rowArray 결과값
     */
    function setValFromOfcPop(rowArray){
    	var colArray = null ;
    	var gubun    = '';
    	
    	if(multiChkYN){
    		
    		for(i=0; i<rowArray.length; i++){
    			if(i<rowArray.length-1) gubun = ',';
    			else gubun = "" ;
    			colArray = rowArray[i];
    			setValFromOfcArray(colArray, gubun, i)
    		}
    	}
    	else{
    		colArray = rowArray[0] ;
    		setValFromOfcArray(colArray,gubun, 0) ;
    	}
    	
    	sheetObject = null ;
    	sheetRow    = 0 ;
     }

    /**
     * Office 에서 넘어온 값을 field에 세팅
     * 
     * @param colArray 한 row의 column 배열
     * @param gubun 다중선택시 값의 구분
     * @param idx row의 index
     */
     function setValFromOfcArray(colArray, gubun, idx){
    	setValToFld(colArray, ofcCdFld, idx, 3, gubun) ;
    	setValToFld(colArray, ofcNmFld, idx, 4, gubun) ;
     }
      
    /**
     *  Customer 공통 팝업 오픈
     * 
     * @param multi multi check 여부
     * @param custCd Customer Code
     * @param custNm Customer Name
     * @param ofcCd Sales Office
     * @param custSgmt Segmentation
     */
    function openCustPop(multi, custCd, custNm, ofcCd, custSgmt){
    	var formObj = document.form ;
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;
    	
    	param  = "?classId=" + getCommPopClassId() ;
    	param += getURLParam(multi, "cust_cd", custCd) ;
    	param += getURLParam(multi, "cust_nm", custNm) ;
    	param += getURLParam(multi, "ofc_cd",  ofcCd) ;
    	
    	comPopup('/hanjin/COM_ENS_041.do' + param, 770, 450, 'setValFromCustPop', display) ;
    	custCdFld   = custCd ;
    	custNmFld   = custNm ;
    	ofcCdFld    = ofcCd ;
    	custSgmtFld = custSgmt ;
    	multiChkYN  = multi ;
    }


    /**
     * Customer 공통 팝업에서 호출하는 함수
     * 
     * @param rowArray 결과값
     */
    function setValFromCustPop(rowArray){
    	var colArray = null ;
    	var gubun    = '';
    	
    	if(multiChkYN){
    		
    		for(i=0; i<rowArray.length; i++){
    			if(i<rowArray.length-1) gubun = ',';
    			else gubun = "" ;
    			colArray = rowArray[i];
    			setValFromCustArray(colArray, gubun, i)
    		}
    	}
    	else{
    		colArray = rowArray[0] ;
    		setValFromCustArray(colArray,gubun, 0) ;
    	}
    	
    	sheetObject = null ;
    	sheetRow    = 0 ;
    }

     /**
     * Customer 에서 넘어온 값을 field에 세팅
     * 
     * @param colArray 한 row의 column 배열
     * @param gubun 다중선택시 값의 구분
     * @param idx row의 index
     */
    function setValFromCustArray(colArray, gubun, idx){
    	setValToFld(colArray, custCdFld,   idx, 3, gubun) ;
    	setValToFld(colArray, custNmFld,   idx, 4, gubun) ;
    	setValToFld(colArray, custSgmtFld, idx, 5, gubun) ;
    	setValToFld(colArray, ofcCdFld,    idx, 9, gubun) ;
    }
     
     

    /**
     *  vvd 공통 팝업 오픈
     * 
     * @param multi multi check 여부
     * @param custCd Customer Code
     * @param custNm Customer Name
     * @param ofcCd Sales Office
     * @param custSgmt Segmentation
     */
    function openVVDPop(multi, vvdCd, sDate, eDate, etdeta, locCd, laneCd, oper){
    	var formObj = document.form ;
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;
    	
    	param  = "?classId=" + getCommPopClassId() ;
    	param += getURLParam(multi, "vvd_cd", vvdCd) ;
    	param += getURLParam(multi, "sdate", sDate) ;
    	param += getURLParam(multi, "edate", eDate) ;
    	param += getURLParam(multi, "etdeta", etdeta) ;
    	param += getURLParam(multi, "loc_cd", locCd) ;
    	param += getURLParam(multi, "lane_cd", laneCd) ;
    	param += getURLParam(multi, "oper", oper) ;
    	
    	comPopup('/hanjin/COM_ENS_0B2.do' + param, 770, 470, 'setValFromVVDPop', display) ;
    	
    	vvdCdFld   = vvdCd ;
    	sDateFld   = sDate ;
    	eDateFld   = eDate ;
    	etdetaFld  = etdeta ;
    	locCdFld   = locCd ;
    	laneCdFld  = laneCd ;
    	operFld    = oper ;
    	multiChkYN = multi ;
    }

    /**
     * vvd 공통 팝업에서 호출하는 함수
     * 
     * @param rowArray 결과값
     */
    function setValFromVVDPop(rowArray){
    	var colArray = null ;
    	var gubun    = '';
    	
    	if(multiChkYN){
    		
    		for(i=0; i<rowArray.length; i++){
    			if(i<rowArray.length-1) gubun = ',';
    			else gubun = "" ;
    			colArray = rowArray[i];
    			setValFromVVDArray(colArray, gubun, i)
    		}
    	}
    	else{
    		colArray = rowArray[0] ;
    		setValFromVVDArray(colArray,gubun, 0) ;
    	}
    	
    	sheetObject = null ;
    	sheetRow    = 0 ;
    }

    /**
     * vvd 에서 넘어온 값을 field에 세팅
     * 
     * @param colArray 한 row의 column 배열
     * @param gubun 다중선택시 값의 구분
     * @param idx row의 index
     */
    function setValFromVVDArray(colArray, gubun, idx){
    	setValToFld(colArray, vvdCdFld,   idx, 7, gubun) ;
    	setValToFld(colArray, sDateFld,   idx, 5, gubun) ;
    	setValToFld(colArray, eDateFld,   idx, 6, gubun) ;
    	setValToFld(colArray, locCdFld,   idx, 4, gubun) ;
    	setValToFld(colArray, laneCdFld,  idx, 3, gubun) ;
    }
     
    /**
     *  node 공통 팝업 오픈
     * 
     * @param multi multi check 여부
     * @param nodeCd Node
     * @param nodeNm Node Name
     * @param cntCd Country
     * @param locCd Location
     * @param ofcCd Control Office
     * @param mode Yard/Zone
     * @param modeOnly Search Yard/Zone Only
     */
    function openNodePop(multi, nodeCd, nodeNm, cntCd, locCd, ofcCd, mode, modeOnly){
    	var formObj = document.form ;
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;
    	
    	param  = "?classId=" + getCommPopClassId() ;
    	param += getURLParam(multi, "node_cd"  , nodeCd) ;
    	param += getURLParam(multi, "node_nm"  , nodeNm) ;
    	param += getURLParam(multi, "cnt_cd"   , cntCd) ;
    	param += getURLParam(multi, "loc_cd"   , locCd) ;
    	param += getURLParam(multi, "ofc_cd"   , ofcCd) ;
    	param += getURLParam(multi, "mode"     , mode) ;
    	param += getURLParam(multi, "mode_only", modeOnly) ;
    	
    	comPopup('/hanjin/COM_ENS_061.do' + param, 770, 451, 'setValFromNodePop', display) ;
    	
    	nodeCdFld   = nodeCd ;
    	nodeNmFld   = nodeNm ;
    	cntCdFld    = cntCd ;
    	locCdFld    = locCd ;
    	ofcCdFld    = ofcCd ;
    	modeFld     = mode ;
    	modeOnlyFld = modeOnly ;
    	multiChkYN  = multi ;
    }


    /**
     *  node 공통 팝업 오픈(sheet)
     * 
     * @param sheetObj Sheet Object
     * @param row Row
     * @param multi multi check 여부
     * @param nodeCd Node
     * @param nodeNm Node Name
     * @param cntCd Country
     * @param locCd Location
     * @param ofcCd Control Office
     * @param mode Yard/Zone
     * @param modeOnly Search Yard/Zone Only
     */
    function openNodePopSheet(sheetObj, row, multi, nodeCd, nodeNm, cntCd, locCd, ofcCd, mode, modeOnly){
    	var formObj = document.form ;
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;
    	
    	nodeCdFld   = nodeCd ;
    	nodeNmFld   = nodeNm ;
    	cntCdFld    = cntCd ;
    	locCdFld    = locCd ;
    	ofcCdFld    = ofcCd ;
    	modeFld     = mode ;
    	modeOnlyFld = modeOnly ;
    	multiChkYN  = multi ;
    	sheetObject = sheetObj ;
    	sheetRow    = row ;
    	
    	param  = "?classId=" + getCommPopClassId() ;
    	param += getURLParam(multi, "node_cd"  , nodeCd) ;
    	param += getURLParam(multi, "node_nm"  , nodeNm) ;
    	param += getURLParam(multi, "cnt_cd"   , cntCd) ;
    	param += getURLParam(multi, "loc_cd"   , locCd) ;
    	param += getURLParam(multi, "ofc_cd"   , ofcCd) ;
    	param += getURLParam(multi, "mode"     , mode) ;
    	param += getURLParam(multi, "mode_only", modeOnly) ;
    	
    	comPopup('/hanjin/COM_ENS_061.do' + param, 770, 451, 'setValFromNodePop', display) ;
    }
     
    /**
     * node 공통 팝업에서 호출하는 함수
     * 
     * @param rowArray 결과값
     */
    function setValFromNodePop(rowArray){
    	var colArray = null ;
    	var gubun    = '';
    	
    	if(multiChkYN){
    		
    		for(i=0; i<rowArray.length; i++){
    			if(i<rowArray.length-1) gubun = ',';
    			else gubun = "" ;
    			colArray = rowArray[i];
    			setValFromNodeArray(colArray, gubun, i)
    		}
    	}
    	else{
    		colArray = rowArray[0] ;
    		setValFromNodeArray(colArray,gubun, 0) ;
    	}
    	
    	sheetObject = null ;
    	sheetRow    = 0 ;
    }

    /**
     * node 에서 넘어온 값을 field에 세팅
     * 
     * @param colArray 한 row의 column 배열
     * @param gubun 다중선택시 값의 구분
     * @param idx row의 index
     */
    function setValFromNodeArray(colArray, gubun, idx){
    	setValToFld(colArray, cntCdFld,   idx, 12, gubun) ;
    	setValToFld(colArray, locCdFld,   idx, 13, gubun) ;
    	setValToFld(colArray, ofcCdFld,   idx,  5, gubun) ;
    	setValToFld(colArray, nodeCdFld,  idx,  3, gubun) ;
    	setValToFld(colArray, nodeNmFld,  idx,  4, gubun) ;
    }



    /**
     *  Service Provider 공통 팝업 오픈
     * 
     * @param multi multi check 여부
     * @param ptsVndrCd Parent Service Provider Code
     * @param vndrNmEng Service Provider Name
     * @param cntCd Country
     * @param ofcCd Control Office
     */
    function openServiceProviderPop(multi, ptsVndrCd, vndrNmEng, cntCd, ofcCd){
    	var formObj = document.form ;
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;
    	
    	param  = "?classId=" + getCommPopClassId() ;
    	param += getURLParam(multi, "pts_vndr_cd", ptsVndrCd) ;
    	param += getURLParam(multi, "vndr_nm_eng", vndrNmEng) ;
    	param += getURLParam(multi, "cnt_cd"     , cntCd) ;
    	param += getURLParam(multi, "ofc_cd"     , ofcCd) ;
    	
    	comPopup('/hanjin/COM_ENS_0C1.do' + param, 620, 451, 'setValFromServiceProviderPop', display) ;
    	
    	ptsVndrCdFld = ptsVndrCd ;
    	vndrNmEngFld = vndrNmEng ;
    	cntCdFld     = cntCd ;
    	ofcCdFld     = ofcCd ;
    	multiChkYN   = multi
    }
     
    /**
     * Service Provider 공통 팝업에서 호출하는 함수
     * 
     * @param rowArray 결과값
     */
    function setValFromServiceProviderPop(rowArray){
    	var colArray = null ;
    	var gubun    = '';
    	
    	if(multiChkYN){
    		
    		for(i=0; i<rowArray.length; i++){
    			if(i<rowArray.length-1) gubun = ',';
    			else gubun = "" ;
    			colArray = rowArray[i];
    			setValFromServiceProviderArray(colArray, gubun, i)
    		}
    	}
    	else{
    		colArray = rowArray[0] ;
    		setValFromServiceProviderArray(colArray,gubun, 0) ;
    	}
    	
    	sheetObject = null ;
    	sheetRow    = 0 ;
    }

    /**
     * Service Provider 에서 넘어온 값을 field에 세팅
     * 
     * @param colArray 한 row의 column 배열
     * @param gubun 다중선택시 값의 구분
     * @param idx row의 index
     */
    function setValFromServiceProviderArray(colArray, gubun, idx){
    	setValToFld(colArray, cntCdFld,      idx,  5, gubun) ;
    	setValToFld(colArray, ofcCdFld,      idx,  3, gubun) ;
    	setValToFld(colArray, ptsVndrCdFld,  idx,  7, gubun) ;
    	setValToFld(colArray, vndrNmEngFld,  idx,  4, gubun) ;
    } 


    /**
     *  Staaf 공통 팝업 오픈
     * 
     * @param multi multi check 여부
     * @param userCd User Code
     * @param userNm User Name
     * @param ofcCd Office Code
     */
    function openStaffPop(multi, userCd, userNm, ofcCd){
    	var formObj = document.form ;
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;
    	
    	param  = "?classId=" + getCommPopClassId() ;
    	param += getURLParam(multi, "user_cd", userCd) ;
    	param += getURLParam(multi, "user_nm", userNm) ;
    	param += getURLParam(multi, "ofc_cd" , ofcCd) ;
    	param += "&f_cmd=2" ;
    	
    	comPopupWith2ndSheet('/hanjin/COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display) ;
    	
    	userCdFld  = userCd ;
    	userNmFld  = userNm ;
    	ofcCdFld   = ofcCd ;
    	multiChkYN = multi
    }


    /**
     *  Staaf 공통 팝업 오픈(sheet)
     * 
     * @param sheetObj IBSheet Object
     * @param row Row
     * @param multi multi check 여부
     * @param userCd User Code
     * @param userNm User Name
     * @param ofcCd Office Code
     */
    function openStaffPopSheet(sheetObj, row, multi, userCd, userNm, ofcCd){
    	var formObj = document.form ;
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;
    	
    	userCdFld   = userCd ;
    	userNmFld   = userNm ;
    	ofcCdFld    = ofcCd ;
    	sheetObject = sheetObj ;
    	sheetRow    = row ;	
    	multiChkYN  = multi
    	
    	param  = "?classId=" + getCommPopClassId() ;
    	param += getURLParam(multi, "user_cd", userCd) ;
    	param += getURLParam(multi, "user_nm", userNm) ;
    	param += getURLParam(multi, "ofc_cd" , ofcCd) ;
    	param += "&f_cmd=2" ;
    	
    	comPopupWith2ndSheet('/hanjin/COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display) ;

    }


     
    /**
     * SStaaf 공통 팝업에서 호출하는 함수
     * 
     * @param rowArray 결과값
     */
    function setValFromStaffPop(rowArray){
    	var colArray = null ;
    	var gubun    = '';
    	
    	if(multiChkYN){
    		for(i=0; i<rowArray.length; i++){
    			if(i<rowArray.length-1) gubun = ',';
    			else gubun = "" ;
    			
    			colArray = rowArray[i];
    			setValFromStaffArray(colArray, gubun, i)
    		}
    	}
    	else{
    		colArray = rowArray[0] ;
    		setValFromStaffArray(colArray,gubun, 0) ;
    	}
    	
    	sheetObject = null ;
    	sheetRow    = 0 ;
    }

    /**
     * Service Provider 에서 넘어온 값을 field에 세팅
     * 
     * @param colArray 한 row의 column 배열
     * @param gubun 다중선택시 값의 구분
     * @param idx row의 index
     */
    function setValFromStaffArray(colArray, gubun, idx){
    	setValToFld(colArray, ofcCdFld,   idx,  3, gubun) ;
    	setValToFld(colArray, userCdFld,  idx,  4, gubun) ;
    	setValToFld(colArray, userNmFld,  idx,  5, gubun) ;
    } 

     
    /**
     * classId 얻기
     */
    function getCommPopClassId(){
    	var url = document.location.href ;
    	var classId = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf(".do")) ;
    	return classId ;
    }
      
     
    /**
     * display 얻기
     * 
     * @param multi 다중선택 가능 여부
     *              true : 다중선택 가능, false : 불가능
     */
    function getCommPopDisplay(multi){
     	var display = multi?'0,1,1,1,1,1,1,1,1,1,1,1':'1,0,1,1,1,1,1,1,1,1,1,1' ;
     	return display ;
    }
     
    /**
     * field 값 세팅
     * 
     * @param fldNam 명
     * @param colIdx row의 index 
     * @param colIdx column의 index
     * @param gubun 구분   
     */
    function setValToFld(colArray, fldNm, rowIdx, colIdx, gubun){
     	var formObj  = document.form ;
     	
     	if(sheetObject==null){
    	 	if(formObj[fldNm]!=null){
    			if(rowIdx==0){
    		    	formObj[fldNm].value = colArray[colIdx] + gubun ;
    			}
    			else{
    				formObj[fldNm].value += colArray[colIdx] + gubun ;
    			}
    	    	formObj[fldNm].focus() ;
    		}
     	}
     	else{
     		if(fldNm!=null){
    	 		if(rowIdx==0){
    		    	sheetObject.CellValue2(sheetRow,fldNm) = colArray[colIdx] + gubun ;
    			}
    			else{
    				sheetObject.CellValue2(sheetRow,fldNm) = sheetObject.CellValue(sheetRow,fldNm) + 
    														 colArray[colIdx] + gubun ;
    			}
     		}
     	}
    }

     
    /**
     * 공통 팝업 URL에 넘길 파마라메터 얻기
     *
     * @param multi mult check 가능 여부
     * @param paramNm 파라메터명
     * @param fldNm 필드명
     * @param defaultVal 값이 없을 경우 default 값
     */
    function getURLParam(multi, paramNm, fldNm, defaultVal){
    	var formObj  = document.form ;
    	var param    = "" ;
    	
    	if(!multi){
    		defaultVal = defaultVal==null?"":defaultVal ;
    		
    		if(sheetObject==null){
    			param = "&" + paramNm + "=" + (fldNm!=null&&formObj[fldNm]!=null?
    	                formObj[fldNm].value:defaultVal) ;
    		}
    		else{
    			param = "&" + paramNm + "=" + (fldNm==null || sheetObject.CellValue(sheetRow, fldNm)==null?defaultVal:
    										   sheetObject.CellValue(sheetRow, fldNm)) ;
    			
    		}
    	}
    	
    	return param ;
    }


    function IBS_Sheet2SheetCheck2(fromSheet, toSheet, chkCol, headerCnt)  { //보내는Sheet, 받는Sheet, column위치, header수
    	//함수 인자 유효성 확인
    	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT") { //"Sheet2SheetCheck 함수의 fromSheet 인자는 IBSheet가 아닙니다."
    	    showErrMessage(getMsg('COM12111'));
    		return false; 
    	}
    	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT") { //"Sheet2SheetCheck 함수의 toSheet 인자는 IBSheet가 아닙니다."
    	    showErrMessage(getMsg('COM12111'));
    	    return false;
    	}
    	else if (chkCol < 0 || chkCol > fromSheet.LastCol) //"Sheet2SheetCheck 함수의 chkCol 인자는 컬럼 영역 이내가 아닙니다."
    	{
    	    showErrMessage(getMsg('COM12111'));
    	    return false;
    	}
    	
    	//데이터 행의 개수 확인
    	var toRow = toSheet.RowCount;
    	fromSheet.Redraw = false;
    	toSheet.Redraw = false;

    	//원본에서 역순으로 Check 된 데이터를 확인하여 이동
    	for (ir = fromSheet.RowCount+(headerCnt-1); ir>= headerCnt; ir--) {
    		//Check 되지 않은 경우 건너뜀
    		if (fromSheet.CellValue(ir, fromSheet.ColSaveName(chkCol)) == '0') continue;
    		//데이터 행 추가
    		toRow = toSheet.DataInsert(-1); //마지막 row밑에 붙이는 경우는 -1, 상단은 0, 아니면 toRow
    		
    		//데이터 옮기기
    		for (ic = 0; ic<=fromSheet.LastCol; ic++) { //체크 컬럼은 빼고 옮김
    			if (ic == chkCol) {
    				if (fromSheet.CellValue(ir, fromSheet.ColSaveName(chkCol)) == '1') {
    					fromSheet.RowStatus(ir) = "R";
    				}
    			} else {
    				toSheet.CellValue(toRow, fromSheet.ColSaveName(ic)) = fromSheet.CellValue(ir, fromSheet.ColSaveName(ic));
    			}
    		}
    		//원본에서 지움
    		fromSheet.RowDelete(ir, false);
    		toRow--;
    	}
    	toSheet.Redraw = true;
    	fromSheet.Redraw = true;
    }

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

    /*
     combo 관련 펑션 및 변수 처리는 모두 comboUtil.js에서..
    */


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
    	    showErrMessage(getMsg('COM12123','This field'));
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
    		showErrMessage(getMsg('COM12127','This field'));
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
    function myRound(num, pos) { 
    	var posV = Math.pow(10, (pos ? pos : 2))
    	return Math.round(num*posV)/posV
    }


    /**
     * 숫자 콤마..
     *
     */
    function commaNum(num) { 

    	if (num < 0) { num *= -1; var minus = true}
    	else var minus = false

    	var dotPos = (num+"").split(".")
    	var dotU = dotPos[0]
    	var dotD = dotPos[1]
    	var commaFlag = dotU.length%3

    	if(commaFlag) {
    	 var out = dotU.substring(0, commaFlag) 
    	 if (dotU.length > 3) out += ","
    	}
    	else var out = ""

    	for (var i=commaFlag; i < dotU.length; i+=3) {
    	 out += dotU.substring(i, i+3) 
    	 if( i < dotU.length-3) out += ","
    	}

    	if(minus) out = "-" + out
    	if(dotD) return out + "." + dotD
    	else return out 
    }

    /**
     * 대문자로 바꾼는 함수.
     */
    function setgetUpper(obj) {
    	return obj.value = obj.value.toUpperCase()
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


    jsLEng  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
    jsSEng  = "abcdefghijklmnopqrstuvwxyz" ;
    jsEng   = jsLEng + jsSEng ;
    jsNum   = "0123456789";
    jsSChar = "!@#$%^&*()_+=-,./<>?;':\"{}[]" ;

    /**
     * 필드 유혀성 체크
     * 
     * @param obj Field Object
     * @param type Check type
     * @param upper 대문자 변환여부
     * @param maxLen 최대길이 
     * @param pchar 허용 문자
     * @param format Format
     */
     
    function chkField(obj, type, upper, maxLen, pchar, format){
    	switch (type) {
    		case "eng_num" :
    			chkEngNumObj(obj, upper, maxLen) ;
    			break;
    		case "eng" :
    			chkEngObj(obj, upper, maxLen) ;
    			break ;
    		case "leng" :
    			chkLEngObj(obj, upper, maxLen) ;
    			break ;
    		case "seng" :
    			chkSEngObj(obj, upper, maxLen) ;
    			break ;
    		case "num" :
    			chkNumObj(obj, maxLen, format) ;
    			break ;
    		case "custmoer" :
    			chkCharObj(obj, pchar, upper, maxLen) ;
    			break ;
    		case "date" :
    			dateFormatObj(obj, format) ;
    		default:
    			break;
    	}
    }

    function chkEngObj(obj, upper, maxLen){
    	chkCharObj(obj, jsEng, upper, maxLen) ;
    }

    function chkLEngObj(obj, upper, maxLen){
    	chkCharObj(obj, jsLEng, upper, maxLen) ;
    }

    function chkSEngObj(obj, upper, maxLen){
    	chkCharObj(obj, jsSEng, upper, maxLen) ;
    }

    function chkEngNumObj(obj, upper, maxLen){
    	chkCharObj(obj, jsEng+jsNum, upper, maxLen) ;
    }

    function chkNumObj(obj, upper, maxLen){
    	chkCharObj(obj, jsNum, upper, maxLen) ;
    }

    function chkCharObj(obj, pchar, upper, maxLen){
    	obj.value = chkCharValue(obj.value, pchar, upper, maxLen) ;
    }

    function chkCharValue(value, pchar, upper, maxLen){
    	var newValue = "" ;
    	var oneChar  = null ;
    	
    	for(i=0;i<value.length; i++){
    		oneChar = value.charAt(i) ;
    		if(pchar.indexOf(oneChar)!=-1 && (maxLen==null || newValue.length<maxLen)){
    			newValue += oneChar ;
    		}
    	}
    	
    	newValue = upper ? newValue.toUpperCase() : newValue ;
    	
    	return newValue ;
    }

    function dateFormatObj(obj, format){
    	var value = obj.value ;
    	obj.value = dateFormatValue(value, format)
    }

    function dateFormatValue(value, format) {
    	var oldValue = chkCharValue(value, jsNum, false) ;
    	var newValue = "" ;
    	var chkValue = "" ;
    	var oneChar  = null ;
    	var maxLen   = 8 + (format.length*2)
    	
    	for(i=0; i<oldValue.length; i++){
    		oneChar = oldValue.charAt(i) ;
    		
    		if(newValue.length<maxLen){
    			if(i==4){
    				if(oneChar>1){
    					newValue = newValue + format + "0" + oneChar ;
    				}
    				else{
    					newValue = newValue + format + oneChar ;
    				}
    			}
    			else if(i==6){
    				if(oneChar>3){
    					newValue = newValue + format + "0" + oneChar ;
    				}
    				else{
    					newValue = newValue + format + oneChar ;
    				}
    			}
    			else {
    				newValue += oneChar ;
    			}
    		}
    	}
    	
    	chkValue = oldValue.substring(0,8) ;
    	if(!chkDateValue(chkValue)){
    		newValue = newValue.substring(0, newValue.length-1) ;
    	}
    		
    	return newValue ;
    }


    function chkDateValue(value){
    	var yyyy = value.substring(0,4) ;
    	var mm   = value.substring(4,6) ;
    	var dd   = value.substring(6) ;
    	
    	var daysInMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) ;
    	
    	// 월체크
    	if(mm>12) {
    		return false ;
    	}
    	
    	// 윤달
    	if(mm==2){
    		daysInMonth[1] = yyyy%400==0 || ((yyyy%4==0) && (yyyy%100!=0)) ? 29 : 28 ; 
    	}

    	// 일체크
    	if(dd!="" && mm!="" && dd>daysInMonth[mm-1]){
    		return false ;
    	}
    	
    	return true ;
    }

    function chkMonthValue(value){
    	var yyyy = value.substring(0,4) ;
    	var mm   = value.substring(4,6) ;
    	
    	// 월체크
    	if(mm>12) {
    		return false ;
    	}
    	
    	return true ;
    }


    function chkLenth(obj, len, msg) {
    	var result = true ;
    	
    	if( getLenByByte(obj.value)!==len ) {
    		showErrMessage(getMsg('EAS90002', msg, len));
    		obj.focus();
    		result = false;
    	}
    	return result ;
    }


    function chkLenthOver(obj, len, msg) {
    	var result = true;
    	if( getLenByByte(obj.value)<len ) {
    		showErrMessage(getMsg('COM12143', msg, len));
    		obj.focus();
    		result = false;
    	}
    	return result;
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
    	if ( date==null || date==undefined ) {
    		date = new Date();
    	}
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

    	return y + delm + fullZero(m,2) + delm + fullZero(d,2);
    }


//2011.07.13 이정수 R4J소스품질 위배 및 미사용으로 인해 주석처리함       
    /**
     * Remark 팝업을 띄우는 함수
     *
     * @param : pBkg_No - bkg_no
     * @param : pBl_No - bl_no
     * @param : pExpn_Tp_Cd - eas_expn_tp_cd
     */
/*    function openRemarkPopup(pBkg_No, pBl_No, pExpn_Tp_Cd){
    	var theURL = "ESD_EAS_0902.do?bkg_no="+pBkg_No+"&bl_no="+pBl_No+"&eas_expn_tp_cd="+pExpn_Tp_Cd;
    	
    	var winName = "ESD_EAS_0902";
    	var features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=700,height=370";
    	ComOpenWindow(theURL,winName,features);
    }    
*/    /****** common end *********/
    
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
    	var queryString = "srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+FormQueryString(formObject);

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
    	var queryString = "srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+FormQueryString(formObject);
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
    	var queryString = "searchStr="+value+"&"+FormQueryString(formObject);
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
    	var queryString = "isZone=Y&srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+FormQueryString(formObject);
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

    	var queryString = "isZone=Y&srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+FormQueryString(formObject);
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
    	var queryString = "isZone=Y&searchStr="+value+"&"+FormQueryString(formObject);
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
    	var queryString = "isZone=A&searchStr="+value+"&"+FormQueryString(formObject);
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
    	var queryString = "isZone=A&srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+FormQueryString(formObject);
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
     	var queryString = "searchStr="+value+"&"+FormQueryString(formObject);

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

     function getTextVendorSeq(sheetObj, formObj, vndr_seq){

     	formObj.f_cmd.value = SEARCH11;
     	formObj.combo_svc_provider.value = get_only_num(vndr_seq);
     	sheetObj.RemoveEtcData();
     	sheetObj.DoRowSearch("ESD_TRS_0014GS.do", FormQueryString(formObj));

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
    
    /**
     * Booking Detail 팝업 호출<br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPopBkgDetail(bkgNo);
     * </pre>
     * @param  bkg_no
     * @return 없음
     * @author 김기종
     * @version 2009.09.30
     */
    function comBkgCallPopBkgDetail(bkgNo){
    	var sUrl  = "ESM_BKG_0079_Q.do?bkg_no="+bkgNo;
    	ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1024, 700, true, "yes");
    }
    
    
    /**
     * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     var sCondParam=FormQueryString(document.frmSearch); //결과:"txtname=이경희&rdoYn=1&sltMoney=원화";
     * </pre>
     * @param {form} form Form 오브젝트
     * @return string
     * @version 1.0.0.0
     * @see #FormQueryStringEnc
     */
    function EasFrmQryString(form) {

        if (typeof form != "object" || form.tagName != "FORM") {
            alert("Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag.");
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
//        	  ComClearSeparator(form.elements[i]);
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
//          ComAddSeparator(form.elements[i]);
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
            var tmpUrlEncodeSheet    = document.getElementById("formquerystring");

            if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '')
            {
                //인코딩을 위해 숨겨진IBSheet를 만든다.
                var sTag = ComGetSheetObjectTag("formquerystring");
                form.insertAdjacentHTML('afterEnd', sTag);
            }

            for (i = 0; i < j; i++) {
                // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
                if (name[i] != '') plain_text += name[i]+ "=" + formquerystring.UrlEncoding(value[i]) + "&";
            }
        }


      //마지막에 &를 없애기 위함
      if (plain_text != "")
        plain_text = plain_text.substr(0, plain_text.length -1);
        return plain_text;
    }
    
    /**
     * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param E-MAIL 값
     * @return string
     * @version 1.0.0.0
     * @see #FormQueryStringEnc
     */    
	function EasIsEmailAddr(obj) {
 		try {
 			if (obj == "") return true; //e-Mail 주소가 없을 경우엔 체크하지 않는다.

            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var retArr = obj.split(";");

            for ( var i = 0; i < retArr.length; i++) {

            	if(retArr[i].trim() != ""){ 
	            	var sVal = getArgValue(retArr[i]);
	            	var format =  /^\s*[\w\~\-\.]+\@[\w\~\-]+(\.[\w\~\-]+)+\s*$/g;
	            	
	            	if(sVal.search(format) == -1&& sVal != ""){
	            		break;
		            }
            	}else{
            		if(sVal == "" || sVal == null||sVal == undefined){
            			return;
            		}
            		
            		break;
            	}
            }

            return (sVal.search(format) != -1);
            
        } catch(err) { ComFuncErrMsg(err.message); }
    }    
	
	/**
	 * 조회한 값을 String 형태로 변경한다.. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param IBSheet 의 sXml 값
	 * @return string
	 * @version 1.0.0.0
	 */    
	function EasXmlString(xmlStr, codeCol) {
		var rtnArr = new Array();
		if (xmlStr == null || xmlStr == "") {
			return;
		}
		if (codeCol == null || codeCol == "" ) {
			return;
		}
	
		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
				xmlDoc.loadXML(xmlStr);
			
			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return;
			}
			
			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null){
				return;
			
			}
			
			if(dataNode.getAttribute("TOTAL")==0){
				return 0;
			}
			
			if( dataNode.attributes.length < 3) {
				return;
			}
			
			
			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var total = dataNode.getAttribute("TOTAL");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			    
			
			var dataChildNodes = dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}
			
			var colListIdx = Array();
			for ( var i = 0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0] = i;
				}
			}
			
			var sCode = "";
			
			for ( var i = 0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
				
				sCode += arrData[colListIdx[0]];
				
				if (i != dataChildNodes.length - 1) {
						sCode += "|";
				}
			}
	
		} catch (err) {
			ComFuncErrMsg(err.message);
		}

		return sCode;
	}    
	
	/**
	 * 외부 콤보박스의 리스트 가져오기
	 **/
	function getEasIbComboList( combo , code , text , option) {
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
	
	/**
	 * 외부 콤보박스의 리스트 가져오기(code, name)
	 **/
	function getEasIbComboList2( combo , code , text , option) {
		var cdList = code;
		var NmList = text;

		var cdArray = new Array();
		var nmArray = new Array();

		cdArray = cdList.split("|");
		nmArray = NmList.split("|");

		combo.RemoveAll();

		for(var i=0; i<cdArray.length; i++)
		{
			combo.InsertItem(i, cdArray[i] + '|' + nmArray[i],  cdArray[i]);
		}
		if (option == 'ALL') {
			combo.InsertItem(0, '' ,  '');
		}
	}
	
//  string을 읽어들여 db 저장을 위해 하이픈('-')을 제거
	function removeBar(str) {
		var value = "";
		for ( var i = 0; i < str.length; i++ ) {
			var ch = str.charAt(i);
			if ( ch != '-' ) value = value + ch;
		}
		return value;
	}
	
	  /**
	   * Sheet의 아래 5개 EAS 화면에서 기본 디자인을 설정한다. IBSheet에서 선택된 부분의 글자를 진하게 설정한다. 
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
	   *			 ComConfigSheetEas(sheetObjects[i]);
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
	   * @see #ComConfigSheetEas
	   */
	  function ComConfigSheetEas(sheet_obj)
	  {
	      try {

	          with (sheet_obj)
	          {
					SelectHighLight = false;
					SelectFontBold = true;
	          }
	      } catch(err) { ComFuncErrMsg(err.message); }

	  }  	
	  
    /******** stringUtil end ***********/
	  
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
			v_str = arr_value.toString();
			return v_str
	    }
	    
	    
		/**
		 * IBSheet의 특정 컬럼을 기준으로 체크된 행을 모두 숨기거나 보여준다. <br>
		 */
		function easRowHide(sheetObj, col, isFlag) {


			//가져온 행을 배열로 만들기 
			if(isFlag){
				//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
				for (var idx=sheetObj.SearchRows; idx>=0; idx--){
					if(sheetObj.CellValue(idx,col)==0){
						sheetObj.RowHidden(idx)= true;		//행 숨기기
					}
				}
			}else{
				for (var idx=sheetObj.SearchRows; idx>=0; idx--){
					if(sheetObj.RowHidden(idx)){
						sheetObj.RowHidden(idx)= false;		//2.행 보이기
					}
				}
			}

			
			return arrRow.length-1;
		}		    

	    /**
		 * 시작일과 종료일 사이에  일수 또는 개월수를 구하여 리턴한다.<br>
	     * @param pStartDate - 시작일   
	     * @param pEndDate  - 마지막일
	     * @param pType       - 'D':일수, 'M':개월수  
	     * @return string
	     */
		   function EasGetBetweenDayMon(pStartDate, pEndDate, pType) {
		       var strSDT = new Date(pStartDate.substring(0,4),pStartDate.substring(4,6)-1,pStartDate.substring(6,8));   
		       var strEDT = new Date(pEndDate.substring(0,4),pEndDate.substring(4,6)-1,pEndDate.substring(6,8));   
		       var strTermCnt = 0;
		       if(pType == 'D') {  //일수 차이  
		            strTermCnt = (strEDT.getTime()-strSDT.getTime())/(1000*60*60*24);  
		        } else {            //개월수 차이  
		            //년도가 같으면 단순히 월을 마이너스 한다.  
		            // => 20090301-20090201 의 경우 아래 else의 로직으로는 정상적인 1이 리턴되지 않는다.  
		            if(pEndDate.substring(0,4) == pStartDate.substring(0,4)) {  
		                strTermCnt = pEndDate.substring(4,6) * 1 - pStartDate.substring(4,6) * 1;  
		            } else {  
		                strTermCnt = Math.round((strEDT.getTime()-strSDT.getTime())/(1000*60*60*24*365/12));  
		            }
		            strTermCnt = strTermCnt + 1;
		        }
		        return strTermCnt;  
		   }
		
		  	// Comparison 금액 체크 색상 변경
		  	function setAmtHighLight(sheetObj, formObj, invAmt, txtRto, row, tp) {
		  		var fColor1 = sheetObj.RgbColor(180, 0, 255); //보라색
		  		var fColor2 = sheetObj.RgbColor(0, 0, 255);   //파란색
		  		var fColor = sheetObj.RgbColor(255, 0, 0);     //빨간색
		  		var tesRto1 = 0;
		  		var tesRto2 = 0;
		  		if (tp == "A" || tp == "M") {
		  			tesRto1 = ((sheetObj.CellValue(row, invAmt) - sheetObj.CellValue(row+1, invAmt)) / sheetObj.CellValue(row+1, invAmt)) * 100;
		  		}
		  		
		  		if (tp == "A" || tp == "Y") {
		  	  		tesRto2 = ((sheetObj.CellValue(row, invAmt) - sheetObj.CellValue(row+2, invAmt)) / sheetObj.CellValue(row+2, invAmt)) * 100;
		  		}
		  		
		  		if (!ComIsNumber(String(tesRto1), "."))  tesRto1 = 0;
		  		if (!ComIsNumber(String(tesRto2), "."))  tesRto2 = 0;
		  		var tesMaxRto = Math.max(tesRto1, tesRto2);
		  		if (tesMaxRto > txtRto) {
		  			if (tesRto1 > txtRto && tesRto2 <= txtRto ) {
		  				sheetObj.CellFont("FontColor", row, invAmt) = fColor1;
		  			}else if (tesRto2 > txtRto && tesRto1 <= txtRto ) {
		  				sheetObj.CellFont("FontColor", row, invAmt) = fColor2;
		  			}else{
		  				sheetObj.CellFont("FontColor", row, invAmt) = fColor;
		  			}
		  		}
		  	}
		  	
			/** 
			 * 멀티입력 팝업 메서드
			 * @param	{String }	input_obj 값을 리턴받을 form element명
			 */
			function rep_Multiful_inquiry(input_obj, title)
			{
					var formObject = document.form;
					var cmdt_cd_val ="";   //향후 사용가능 예정변수
					var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
					var cmdt_desc_val ="";   //향후 사용가능 예정변수
					var classId ="EAS_MULTI";
					var xx1=input_obj;  //CONTI
					var xx2="";  //SUB CONTI
					var xx3="";  //COUNTRY
					var xx4="";  //STATE
					var xx5="";  //CONTROL OFFIC
					var xx6="";  //LOC CODE
					var xx7="";  //LOC NAME
					var xx8="";
					var xx9="";
					var xx10="";
					
					if (title == undefined) {
						xx10 = "";
					}else{
						xx10 = title;
					}

					var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+xx10;
					ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 412, 330, '', '1,0,1,1,1,1,1,1,1,1,1,1');
			}
			
			/** 
			 * rep_Multiful_inquiry의 리턴처리 메서드
			 * @param	{Array}		rowArray	반환되는 Array
			 * @param	{String}	return_val	반환되는 form element명
			 */
			function getTRS_ENS_906(rowArray,return_val) {
		 		var formObj = document.form; 	 
		 		var tempText = "";       
		 		//초기화     
				eval("document.form." + return_val + ".value = '';"); 
		 
		 		for(var i=0; i < rowArray.length; i++) {     
		 			tempText +=  rowArray[i] + ',';      
		 		}     
		 		//마지막에 ,를 없애기 위함      
				tempText = EasDelLastDelim(tempText);		
		 			     
		 		eval("document.form." + return_val + ".value = '" + tempText + "';"); 
		 	} 
			
			/**
			 * 반복문으로  생성된 라스트 Delim을 제거
			 * ex)
			 * '1,2,3,4,5,' => '1,2,3,4,5'
			 * @param {String} str 		제거 대상 String
			 * @return {String} str 	제거된 String
			 * @author 박명신
			 * @version 2009.06.04
			 */
			function EasDelLastDelim(str){
				//마지막에 &를 없애기 위함
				if (str != ""){
					 str = str.substr(0, str.length - 1);
				}
				return str;
			}
			
			/**
			 * Auto Audit / Audit Resutl 코드 매핑
			 * select에 선택한 코드를 auto audit 코드로 변환
			 **/
			function getEasAudCdMapg(str){
				var rtn = "";
				if (str == "A") { //Candidate EAC
					rtn = "XX"; // Candidate EAC의 경우 'C'로 맵핑해야 되나 코드 일치에 관계없이 항상 Remark를 입력하도록 존재하지 않는 코드를 맵핑
				}else if (str == "E") { //Potential EAC
					rtn = "F";
				}else if (str == "P") { //Coincidence
					rtn = "S";
				}
				return rtn
			}

		    /**
		     * IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 Message 값을 리턴한다.
		     * @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
		     * @return  string, Java에서 넘겨준 Message
		     * @version 3.4.0.50
		     */
		    function EacGetMsgData(xmlStr){
		        if(xmlStr == null  || xmlStr == "" ) return;
		        try {
		            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
		            var msgAllTxt = "";
		            var msgTxt = "";
		            xmlDoc.loadXML(xmlStr);
		            var xmlRoot = xmlDoc.documentElement;
		            if(xmlRoot == null) return;
		            var msgList = xmlRoot.getElementsByTagName("MESSAGE");
		            if (msgList.length > 0) {
			            var msgAllTxt = msgList.item(0).text;
			            if (msgAllTxt.indexOf("TRS00099") > 0) {
			            	msgTxt = "Already been confirmed/rejected.\nPlease proceed after retrieve again";
			            }
		            }
		            return msgTxt;
		        } catch(err) { ComFuncErrMsg(err.message); }
		    }
		    
		    /**
		     * 월에 월을 더하거나 뺀다.
		     * @param  YM : 년월
		     * @param  더하거나 뺄 월
		     * @return  계산된 월
		     */
		    function EasGetMonthCalc(ym, calc) {
		    	var ymCalc = calc * 30;
		    	var rtn = "";
		    	if(ym.length >= 6) {
		    		rtn = ComGetDateAdd(ym+"15","D", ymCalc, "-").substring(0,7);
		    	}else{
		    		rtn = "";
		    	}
		    	return rtn;
		    }
		    
		    

			/**
			 * 쉬트의 Mouse Pointer ToolTip 생성.
			 * 
			 * @param sheetObj
			 * @param colName 적용할 Column 이름
			 * @param colText 보여줄 텍스트 Column 이름
			 */
			function sheetToolTip( sheetObj, colName, colText)
			{
				if ( sheetObj.MouseCol == sheetObj.SaveNameCol(colName) ) {
					//마우스 모양 설정하기
					sheetObj.MousePointer = "Hand";     //손가락 모양
					
					//풍선도움말 만들기
					sheetObj.MouseToolTipText = sheetObj.CellValue(sheetObj.MouseRow, sheetObj.SaveNameCol(colText) );
				} else {
					sheetObj.MouseToolTipText = "";
				}
			}
