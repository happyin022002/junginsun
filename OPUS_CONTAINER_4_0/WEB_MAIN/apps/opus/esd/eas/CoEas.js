/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CoGem.js
 *@FileTitle : Trs Common javascript
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/

// --------------------------------------------------------
// define message
// ex)  msgs["GEM01001"] = "{?msg1} {?msg2}.";
// -------------------------------------------------------

	// message of EAS system
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
    
    /****** common start *********/
    /** sheet  **/
    var sheetObject = null ;
    var sheetRow    = 0 ;

    /** mult check variable **/ 
    var multiChkYN = false ;

    /** Location variable **/
    var contiCdFld    = "" ;
    var scontiCdFld   = "" ;
    var cntCdFld      = "" ;
    var locStateFld   = "" ;
    var locEqOfcFld   = "" ;
    var locCdFld      = "" ;
    var locDescFld    = "" ;
    var locPortIndFld = "" ;
    var sysCodeFld    = "" ;

    /** Office variable **/
    var ofcLevFld   = "" ;
    var ofcPtsCdFld = "" ;
    var ofcCdFld    = "" ;
    var ofcNmFld    = "" ;
    var callTypeFld = "" ;


    /** Customer variable **/
    var custCdFld   = "" ;
    var custNmFld   = "" ;
    var custSgmtFld = "" ;

    /** VVD variable **/
    var etdetaFld = "" ;
    var sDateFld  = "" ;
    var eDateFld  = "" ;
    var vvdCdFld  = "" ;
    var laneCdFld = "" ;
    var operFld   = "" ;

    /** Node variable **/
    var nodeCdFld   = "" ;
    var nodeNmFld   = "" ;
    var modeFld     = "" ;
    var modeOnlyFld = "" ;

    /** Service Provider variable **/
    var ptsVndrCdFld = "" ;
    var vndrNmEngFld = "" ;

    /** Staff variable **/
    var userCdFld = "" ;
    var userNmFld = "" ;



    /**
     *  Location Open Common Pop-up Screen
     * 
     * @param multi check 
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

    	comPopup('/opuscntr/COM_ENS_051.do' + param, 770, 470, 'setValFromLocPop', display) ;
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
     *  Location Open Common Pop-up Screen(sheet)
     * 
     * @param sheetObj IBSheet Object
     * @param row Row
     * @param multi check 
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

    	comPopup('/opuscntr/COM_ENS_051.do' + param, 770, 470, 'setValFromLocPop', display) ;
    }

    /**
     * Location Open Common Pop-up Screen
     * 
     * @param rowArray result
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
     * Setting field from Location screen 
     * 
     * @param colArray  column array of one row
     * @param gubun  division multi selected
     * @param idx index of row
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
     *  Office Open Common Pop-up Screen
     * 
     * @param multi multi check 
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
    	
    	comPopup('/opuscntr/COM_ENS_071.do' + param, 770, 450, 'setValFromOfcPop', display) ;
    	ofcLevFld   = ofcLev ;
    	ofcPtsCdFld = ofcPtsCd ;
    	ofcCdFld    = ofcCd ;
    	ofcNmFld    = ofcNm ;
    	callTypeFld = callType ;
    	multiChkYN  = multi ;
    }

    /**
     *  Office Open Common Pop-up Screen(sheet)
     * 
     * @param sheetObj IBSheet Object
     * @param row Row
     * @param multi multi check 
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
    	
    	comPopup('/opuscntr/COM_ENS_071.do' + param, 770, 450, 'setValFromOfcPop', display) ;
    }


    /**
     * Office Open Common Pop-up Screen
     * 
     * @param rowArray result
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
     * setting field from Office screen
     * 
     * @param colArray  column array of one row
     * @param gubun  division multi selected
     * @param idx index of row
     */
     function setValFromOfcArray(colArray, gubun, idx){
    	setValToFld(colArray, ofcCdFld, idx, 3, gubun) ;
    	setValToFld(colArray, ofcNmFld, idx, 4, gubun) ;
     }
      
    /**
     *  Customer Open Common Pop-up Screen
     * 
     * @param multi multi check 
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
    	
    	comPopup('/opuscntr/COM_ENS_041.do' + param, 770, 450, 'setValFromCustPop', display) ;
    	custCdFld   = custCd ;
    	custNmFld   = custNm ;
    	ofcCdFld    = ofcCd ;
    	custSgmtFld = custSgmt ;
    	multiChkYN  = multi ;
    }


    /**
     * Customer Open Common Pop-up Screen
     * 
     * @param rowArray result
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
     * setting field from Customer screen
     * 
     * @param colArray  column array of one row
     * @param gubun  division multi selected
     * @param idx index of row
     */
    function setValFromCustArray(colArray, gubun, idx){
    	setValToFld(colArray, custCdFld,   idx, 3, gubun) ;
    	setValToFld(colArray, custNmFld,   idx, 4, gubun) ;
    	setValToFld(colArray, custSgmtFld, idx, 5, gubun) ;
    	setValToFld(colArray, ofcCdFld,    idx, 9, gubun) ;
    }
     
     

    /**
     *  vvd Open Common Pop-up Screen
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
    	
    	comPopup('/opuscntr/COM_ENS_0B2.do' + param, 770, 470, 'setValFromVVDPop', display) ;
    	
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
     * vvd Common Pop-up
     * 
     * @param rowArray result
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
     * setting field from vvd 
     * 
     * @param colArray  column array of one row
     * @param gubun  division multi selected
     * @param idx index of row
     */
    function setValFromVVDArray(colArray, gubun, idx){
    	setValToFld(colArray, vvdCdFld,   idx, 7, gubun) ;
    	setValToFld(colArray, sDateFld,   idx, 5, gubun) ;
    	setValToFld(colArray, eDateFld,   idx, 6, gubun) ;
    	setValToFld(colArray, locCdFld,   idx, 4, gubun) ;
    	setValToFld(colArray, laneCdFld,  idx, 3, gubun) ;
    }
     
    /**
     *  node Open Common Pop-up Screen
     * 
     * @param multi multi check 
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
    	
    	comPopup('/opuscntr/COM_ENS_061.do' + param, 770, 451, 'setValFromNodePop', display) ;
    	
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
     *  node Open Common Pop-up Screen(sheet)
     * 
     * @param sheetObj Sheet Object
     * @param row Row
     * @param multi multi check
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
    	
    	comPopup('/opuscntr/COM_ENS_061.do' + param, 770, 451, 'setValFromNodePop', display) ;
    }
     
    /**
     * node Common Pop-up Screen
     * 
     * @param rowArray result
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
     * setting field from node 
     * 
     * @param colArray  column array of one row
     * @param gubun  division multi selected
     * @param idx index of row
     */
    function setValFromNodeArray(colArray, gubun, idx){
    	setValToFld(colArray, cntCdFld,   idx, 12, gubun) ;
    	setValToFld(colArray, locCdFld,   idx, 13, gubun) ;
    	setValToFld(colArray, ofcCdFld,   idx,  5, gubun) ;
    	setValToFld(colArray, nodeCdFld,  idx,  3, gubun) ;
    	setValToFld(colArray, nodeNmFld,  idx,  4, gubun) ;
    }



    /**
     *  Service Provider Open Common Pop-up Screen
     * 
     * @param multi multi check
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
    	
    	comPopup('/opuscntr/COM_ENS_0C1.do' + param, 620, 451, 'setValFromServiceProviderPop', display) ;
    	
    	ptsVndrCdFld = ptsVndrCd ;
    	vndrNmEngFld = vndrNmEng ;
    	cntCdFld     = cntCd ;
    	ofcCdFld     = ofcCd ;
    	multiChkYN   = multi
    }
     
    /**
     * Service Provider  Common Pop-up Screen
     * 
     * @param rowArray result
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
     * setting field from Service Provider
     * 
     * @param colArray  column array of one row
     * @param gubun  division multi selected
     * @param idx index of row
     */
    function setValFromServiceProviderArray(colArray, gubun, idx){
    	setValToFld(colArray, cntCdFld,      idx,  5, gubun) ;
    	setValToFld(colArray, ofcCdFld,      idx,  3, gubun) ;
    	setValToFld(colArray, ptsVndrCdFld,  idx,  7, gubun) ;
    	setValToFld(colArray, vndrNmEngFld,  idx,  4, gubun) ;
    } 


    /**
     *  Staaf Open Common Pop-up Screen
     * 
     * @param multi multi check
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
    	
    	comPopupWith2ndSheet('/opuscntr/COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display) ;
    	
    	userCdFld  = userCd ;
    	userNmFld  = userNm ;
    	ofcCdFld   = ofcCd ;
    	multiChkYN = multi
    }


    /**
     *  Staaf Open Common Pop-up Screen(sheet)
     * 
     * @param sheetObj IBSheet Object
     * @param row Row
     * @param multi multi check
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
    	
    	comPopupWith2ndSheet('/opuscntr/COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display) ;

    }


     
    /**
     * SStaaf  Common Pop-up Screen
     * 
     * @param rowArray result
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
     * setting field from Service Provider
     * 
     * @param colArray  column array of one row
     * @param gubun  division multi selected
     * @param idx index of row
     */
    function setValFromStaffArray(colArray, gubun, idx){
    	setValToFld(colArray, ofcCdFld,   idx,  3, gubun) ;
    	setValToFld(colArray, userCdFld,  idx,  4, gubun) ;
    	setValToFld(colArray, userNmFld,  idx,  5, gubun) ;
    } 

     
    /**
     * Get classId
     */
    function getCommPopClassId(){
    	var url = document.location.href ;
    	var classId = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf(".do")) ;
    	return classId ;
    }
      
     
    /**
     * Get display
     * 
     * @param multi select option
     *              true : multi select, false : Single select
     */
    function getCommPopDisplay(multi){
     	var display = multi?'0,1,1,1,1,1,1,1,1,1,1,1':'1,0,1,1,1,1,1,1,1,1,1,1' ;
     	return display ;
    }
     
    /**
     * setting field
     * 
     * @param fldNam name
     * @param colIdx row index 
     * @param colIdx column index
     * @param gubun    
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
     * get param to Common Pop-up Screen URL
     *
     * @param multi mult check 
     * @param paramNm parameter
     * @param fldNm  field name
     * @param defaultVal  default value
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


    function IBS_Sheet2SheetCheck2(fromSheet, toSheet, chkCol, headerCnt)  { // send Sheet,  receive Sheet, column point, header count
    	// check validation
    	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT") { 
    	    showErrMessage(getMsg('COM12111'));
    		return false; 
    	}
    	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT") { 
    	    showErrMessage(getMsg('COM12111'));
    	    return false;
    	}
    	else if (chkCol < 0 || chkCol > fromSheet.LastCol) 
    	{
    	    showErrMessage(getMsg('COM12111'));
    	    return false;
    	}
    	
    	// check row count 
    	var toRow = toSheet.RowCount;
    	fromSheet.Redraw = false;
    	toSheet.Redraw = false;

    	// move Checked data order by desc
    	for (ir = fromSheet.RowCount+(headerCnt-1); ir>= headerCnt; ir--) {
    		// Skip no Check 
    		if (fromSheet.CellValue(ir, fromSheet.ColSaveName(chkCol)) == '0') continue;
    		// add row 
    		toRow = toSheet.DataInsert(-1); // after last row -1, first row 0, else toRow
    		
    		// move data
    		for (ic = 0; ic<=fromSheet.LastCol; ic++) { // Skip Checked item 
    			if (ic == chkCol) {
    				if (fromSheet.CellValue(ir, fromSheet.ColSaveName(chkCol)) == '1') {
    					fromSheet.RowStatus(ir) = "R";
    				}
    			} else {
    				toSheet.CellValue(toRow, fromSheet.ColSaveName(ic)) = fromSheet.CellValue(ir, fromSheet.ColSaveName(ic));
    			}
    		}
    		// clear origin 
    		fromSheet.RowDelete(ir, false);
    		toRow--;
    	}
    	toSheet.Redraw = true;
    	fromSheet.Redraw = true;
    }

    /*
     * comparing Node function
     * HashTable
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



    /**
     * remove char abount sep 
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
     * check validation date type
     */
    function doDatecheck(obj) {
    	if( obj.length == 8 ) {
    		objy = obj.substring(0, 4);
    		objm = obj.substring(4, 6);
    		objd = obj.substring(6);
    	} else {
    		return false;
    	}
    	var lverr = 0; // error code
    	var lvmonday = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    	if( objy%1000 != 0 && objy%4 == 0 )
    		lvmonday[1] = 29; // check leap year
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
     * check character
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
     * check alphabet and number
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
     * check validation date calculation 
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
     * claer '-' in date type
     *
     */
    function delHypen(obj) { //claer hypen
    	var lvobj = doSepRemove(obj.value, "-");
    	obj.value = lvobj;
    }
    function getHypen(obj) { //hypen input
    	if( obj.value.length == 8 ) {
    		obj.value = obj.value.substring(0, 4)+"-"+obj.value.substring(4,6)+"-"+obj.value.substring(6);
    	}
    }


    /**
     * return to 2 decimal places
     *
     */
    function myRound(num, pos) { 
    	var posV = Math.pow(10, (pos ? pos : 2))
    	return Math.round(num*posV)/posV
    }


    /**
     * number disply (,)
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
     * change upper
     */
    function setgetUpper(obj) {
    	return obj.value = obj.value.toUpperCase()
    }

    /**
     * Check Digit Cntr no
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
     * Check Digit Cntr no - include product Value 
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
     * check filed
     * 
     * @param obj Field Object
     * @param type Check type
     * @param upper  big letter
     * @param maxLen max length 
     * @param pchar permission charater
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
    	
    	// check month
    	if(mm>12) {
    		return false ;
    	}
    	
    	// check leap year
    	if(mm==2){
    		daysInMonth[1] = yyyy%400==0 || ((yyyy%4==0) && (yyyy%100!=0)) ? 29 : 28 ; 
    	}

    	// check day
    	if(dd!="" && mm!="" && dd>daysInMonth[mm-1]){
    		return false ;
    	}
    	
    	return true ;
    }

    function chkMonthValue(value){
    	var yyyy = value.substring(0,4) ;
    	var mm   = value.substring(4,6) ;
    	
    	// check month
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
      * change date type to Char type 
      * ex)  getDateStrAdd(null, "D", -6, "-") : "2006-09-17" 
      * @param date    date data ;  case in null ,currenct date
      * @param unit   Char; unit Y:year, M:month, D:day 
      * @param val    value    
      * @param delm   result saparator 
      * @return date data
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

    /**
     * Open Remark pop up screen
     *
     * @param : pBkg_No - bkg_no
     * @param : pBl_No - bl_no
     * @param : pExpn_Tp_Cd - eas_expn_tp_cd
     */
    function openRemarkPopup(pBkg_No, pBl_No, pExpn_Tp_Cd){
    	var theURL = "ESD_EAS_0902.do?bkg_no="+pBkg_No+"&bl_no="+pBl_No+"&eas_expn_tp_cd="+pExpn_Tp_Cd;
    	
    	var winName = "ESD_EAS_0902";
    	var features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=700,height=370";
    	ComOpenWindow(theURL,winName,features);
    }    
    /****** common end *********/
    
    /****** comboUtil start ********/
    var comboObjects = new Array();
    var comboCnt = 0 ;

    /**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * define combo in sheet
     * @param sheetObj - sheet object 
     * @param formObject - condition form object
     * @param row - setting row of combo
     * @param colName - setting colum alias of combo
     * @param value - condition location value
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
     * define combo in sheet
     * @param sheetObj - sheet object
     * @param formObject - condition form object
     * @param row - setting row of combo
     * @param colName - setting colum alias of combo
     * @param value - condition location value
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
     * location get yard LIST by location (ex: a1|a2|a3|a4)
     * @param sheetObj - sheet object
     * @param formObject - condition form object
     * @param value - condition location value
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
     * set combo yard list.
     * @param comboObj - setting  combo object
     * @param sheetObj - sheet object
     * @param formObject - condition form object
     * @param value - condition location value
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
     * define combo in  sheet (per cell)
     * @param sheetObj - sheet object
     * @param formObject - condition form object
     * @param row - setting row of combo
     * @param colName - setting colum alias of combo 
     * @param value - condition location value
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
     * define combo in  sheet (per cell)
     * @param sheetObj - sheet object
     * @param formObject - condition form object
     * @param row - setting row of combo
     * @param colName - setting colum alias of combo
     * @param value - condition location value
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
     * get yard LIST by location (ex: a1|a2|a3|a4)
     * @param sheetObj - sheet object
     * @param formObject - condition form object
     * @param value - condition location value
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
     * setting yard list at combo
     * @param comboObj - setting combo object
     * @param sheetObj - sheet object
     * @param formObject - condition form object
     * @param value - condition location value
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
     * Get yard+ZONE LIST  by location(ex: a1|a2|a3|a4)
     * @param sheetObj - sheet object
     * @param formObject - condition form object
     * @param value - condition location value
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
     * define combo in  sheet (per cell)
     * @param sheetObj - sheet object
     * @param formObject - condition form object
     * @param row - setting row of combo
     * @param colName - setting colum alias of combo
     * @param value - condition location value
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
     * external Combobox datalist Rail Road
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
     * Setting vendor list at combo
     * @param comboObj - setting combo object
     * @param sheetObj - sheet object
     * @param formObject - condition form object
     * @param value - condition location value
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
    	var startIndex = url.indexOf('/opuscntr/');
    	var endIndex = url.indexOf('.do');
    	url = url.substring(startIndex+8, endIndex);

    	return url;
    }
    
    /**
     *  make QueryString at Form objec <br>
     * <br><b>Example :</b>
     * <pre>
     *     var sCondParam=FormQueryString(document.frmSearch); 
     * </pre>
     * @param {form} form Form object
     * @return string
     * @version 1.0.0.0
     * @see #FormQueryStringEnc
     */
    function EasFrmQryString(form) {

        if (typeof form != "object") {
            alert("Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag.");
            return "";
        }

        var name = new Array(form.elements.length);
        var value = new Array(form.elements.length);
        var j = 0;
        var plain_text="";

        // create array avalable control
        len = form.elements.length;
        for (i = 0; i < len; i++) {
        
          if(form.elements[i].classid==undefined){
        	 
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

//          ComAddSeparator(form.elements[i]);
      
        }else{
          switch(form.elements[i].classid){
            case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":  //case in IBMaskEdit
              name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
                    value[j] = form.elements[i].Value;
                    j++;
              break;
            case CLSID_IBMCOMBO: // IBMultiCombo 
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

        // QueryString combination
        //   1) above Explorer 5.5 , use encodeURIComponent() at URL Encode
        //   2) other version use IB Sheet ar URL Encode
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
                //  hidden IBSheet for incoding
                var sTag = ComGetSheetObjectTag("formquerystring");
                form.insertAdjacentHTML('afterEnd', sTag);
            }

            for (i = 0; i < j; i++) {
                // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
                if (name[i] != '') plain_text += name[i]+ "=" + formquerystring.UrlEncoding(value[i]) + "&";
            }
        }


      // claer &
      if (plain_text != "")
        plain_text = plain_text.substr(0, plain_text.length -1);
        return plain_text;
    }
    /******** stringUtil end ***********/
    