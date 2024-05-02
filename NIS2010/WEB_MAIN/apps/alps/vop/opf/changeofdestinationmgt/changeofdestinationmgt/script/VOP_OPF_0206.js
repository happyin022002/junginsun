/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0206.js
*@FileTitle : COD Approval Detail at RSO Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.22 김종옥
* 1.0 Creation
=========================================================
* History
* 2010.07.29 WJK [Ticket-ID:CHM-201004937-01] COD application 외부 E-mail 기능 추가
* 2010.08.24 윤진영 [CHM-201005460] Freight 변경 가능및 Row 추가  
* 2012.04.05 김민아 [CHM-201217130-01] COD application 승인 화면내 Rehnadling Q"ty를 계산한 Bayplan 정보 칼럼 추가
* 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
*=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class VOP_OPF_0206 : VOP_OPF_0206 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0206() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var strDate = "";
	var mailToCarrier = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 이름으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1  = sheetObjects[0];   //sheet1
		var sheetObject2  = sheetObjects[1];   //sheet2	
		var sheetObject3  = sheetObjects[2];   //sheet3
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName =  window.event.srcElement.getAttribute("name");

			switch(srcName) {
			
				case "btn_update":
					doActionIBSheet(sheetObject2,formObject,IBSAVE);
					break;
			
				case "btn_add":
					var inx = sheetObject3.DataInsert(-1);
					row_add_sheet3(inx);
					break;

				case "btn_del":
					ComRowHideDelete(sheetObject3,"sheet3_del_chk");
					break;
					
				case "btn_close":
					window.close();
					break;
				
				case "btn_ok":
					doActionIBSheet(sheetObject3,formObject,IBSAVE);
					break;
					
				case "btn_Mail":
					// Get Receipt
					formObject.f_cmd.value = SEARCH09;
					var mailToXml = sheetObject1.GetSearchXml("VOP_OPF_0206GS.do" , FormQueryString(formObject));	
					var mailStr = ComGetEtcData(mailToXml, "picEml");
					if(mailStr != null){
						formObject.com_recipient.value = mailStr;
					}					
					formObject.com_subject.value = "["+ComGetObjValue(formObject.slan_cd)+"] COD Application ? " + sheetObjects[1].CellValue(sheetObjects[1].LastRow, "sheet2_vsl_eng_nm") +" "+ formObject.vvd.value.substring(4,9) + "(" + ComGetObjValue(formObject.bkg_no) + ")";
					formObject.com_content.value = getMailContents(formObject,mailToXml);
                    
					ComSendMailModal();
					break;
					
				case "old_ts_route":
					var vBkgNo = ComGetObjValue(formObject.bkg_no);
					var vCodRqstSeq = ComGetObjValue(formObject.cod_rqst_seq);
            		var sUrl = "/hanjin/ESM_BKG_0650.do?bkg_no="+vBkgNo+"&cod_rqst_seq="+vCodRqstSeq+"&op_cd=O";
            		ComOpenPopup(sUrl, 710, 310, "", "0,0", true, false, "", "", "","Transhipment Route and VVD");
					break;
					
				case "new_ts_route":
					var vBkgNo = ComGetObjValue(formObject.bkg_no);
					var vCodRqstSeq = ComGetObjValue(formObject.cod_rqst_seq);
            		var sUrl = "/hanjin/ESM_BKG_0650.do?bkg_no="+vBkgNo+"&cod_rqst_seq="+vCodRqstSeq+"&op_cd=N";
            		ComOpenPopup(sUrl, 710, 310, "", "0,0", true, false, "", "", "","Transhipment Route and VVD");
					break;
																																					
				/*case "new_detail":					
            		var sUrl = "/hanjin/ESM_BKG_0156.do";
            		ComOpenPopup(sUrl, 1024, 610, "", "0,0", false, false, "", "", "","COD History");
					break;*/

				case "btn_calculation":
					ComOpenWait(true);
					doActionIBSheet(sheetObject3, formObject, IBSEARCH);
					ComOpenWait(false);
					break;
					
				case "btn_reject":
					document.getElementById('rejectRmkView').style.left =400; 
					document.getElementById('rejectRmkView').style.top = 400 ; //AnchorPosition_getPageOffsetTop(document.getElementById('rejectRmkView'))+10;
					document.getElementById('rejectRmkView').style.visibility="visible";
					document.getElementById('rejectRmkView').style.overflow="visible";
					document.getElementById('rejectRmkView').width=400;
                    document.getElementById('rejectRmkView').height=260;
					document.frames("rejectRmkIfrm").document.forms[0].rejectRmk.value=ComGetObjValue(formObject.rejectRmk); 
					break;
					
				case "new_detail":
					document.getElementById('codRemarkView').style.left =490; 
					document.getElementById('codRemarkView').style.top = 200;
					document.getElementById('codRemarkView').style.visibility="visible";
					document.getElementById('codRemarkView').style.overflow="visible";
					document.getElementById('codRemarkView').width=400;
                    document.getElementById('codRemarkView').height=260;
					document.frames("codRemarkIfrm").document.forms[0].rejectRmk.value=ComGetObjValue(formObject.codRemark); 
					break;
					
             } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/*
	 */
	function getMailContents(formObj,mailToXml) { 		 
		var crrStr = "";
		var oldPodCdStr = "";
		var oldPodFullNmStr = "";
		var newPodCdStr = "";
		var newPodFullNmStr = ""; 
		
		if(ComGetEtcData(mailToXml, "carrierCd") != null){
			crrStr = ComGetEtcData(mailToXml, "carrierCd");
		}
		if(ComGetEtcData(mailToXml, "oldPodCd") != null){
			oldPodCdStr = ComGetEtcData(mailToXml, "oldPodCd");
		}
		if(ComGetEtcData(mailToXml, "oldPodFullNm") != null){
			oldPodFullNmStr = ComGetEtcData(mailToXml, "oldPodFullNm");
		}
		if(ComGetEtcData(mailToXml, "newPodCd") != null){
			newPodCdStr = ComGetEtcData(mailToXml, "newPodCd");
		}
		if(newPodFullNmStr = ComGetEtcData(mailToXml, "newPodFullNm") != null){
			newPodFullNmStr = ComGetEtcData(mailToXml, "newPodFullNm");
		}
 
		var contents = "";
		contents += "Date : "+ sheetObjects[1].CellValue(sheetObjects[1].LastRow, "sheet2_cre_dt");
		contents += "                                                                                                    <br>";
		contents += "To :  "+ crrStr +"                                                                         		 <br>";
		contents += "From : SML                                                                                          <br>";
		contents += "                                                                                                    <br>";
		contents += "Please kindly check this COD Application and offer Rehandling CNTR Q'ty each                        <br>";
		contents += "CNTR Type & Size if acceptable.                                                                     <br>";
		contents += "                                                                                                    <br>";
		contents += "1. Ref No : "+ ComGetObjValue(formObj.bkg_no) +"                                                    <br>";
		contents += "2. Vessel : "+ sheetObjects[1].CellValue(sheetObjects[1].LastRow, "sheet2_vsl_eng_nm") +"           <br>";
		contents += "3. Voyage number : "+ formObj.vvd.value.substring(4,9) +"                                           <br>";
		contents += "4. Container number & TPSZ & weight & special cargo IND & stowage position                          <br>";
		contents += "                                                                                                    <br>";
		contents += "<table width=100% border=2 style='border-collapse: collapse; background-color: white; color: #272727;'>      <br>";
		contents += "	<tr style='background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold;'>   <br>";
		contents += "		<td>Container Number</td>                                                                    <br>";
		contents += "		<td>TPSZ</td>                                                                                <br>";
		contents += "		<td>Weight</td>                                                                              <br>";
		contents += "		<td>Container Condition</td>                                                                 <br>";
		contents += "		<td>Stowage Position </td>                                                                   <br>";
		contents += "	</tr>                                                                                            <br>";
		
		for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].LastRow; i++) {
			contents += "	<tr align=center>                                                                            <br>";
			contents += "		<td>"+ sheetObjects[0].CellValue(i, "sheet1_cntr_no") +"</td>                            <br>";
			contents += "		<td>"+ sheetObjects[0].CellValue(i, "sheet1_cntr_tpsz_cd")+" ["+sheetObjects[0].CellValue(i, "sheet1_cntr_tpsz_desc") +"]</td>                       <br>";
			contents += "		<td>"+ sheetObjects[0].CellValue(i, "sheet1_cntr_wgt") +"</td>                           <br>";
			contents += "		<td>"+ sheetObjects[0].CellValue(i, "sheet1_condition") +"</td>                          <br>";
			contents += "		<td>"+ sheetObjects[0].CellValue(i, "sheet1_cntr_stwg_no") +"</td>                       <br>";
			contents += "	</tr>                                                                                        <br>";
		}	
		
		contents += "</table>                                                                                            <br>";
		contents += "5. Port of loading on VVD : "+ sheetObjects[1].CellValue(sheetObjects[1].LastRow, "sheet2_old_pol") +"("+ sheetObjects[1].CellValue(sheetObjects[1].LastRow, "sheet2_pol_full_nm") +")				             <br>";
		contents += "6. Old Port of discharging on VVD : "+ oldPodCdStr +"("+ oldPodFullNmStr +")				     <br>";
		contents += "7. New Port of discharging on VVD : "+ newPodCdStr +"("+ newPodFullNmStr +")				     <br>";
		
		return contents; 
	}	

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
	}

    /**
     * Combo Object를 배열로 등록
     */    
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
	function loadPage(strDate) {
    	strDate = strDate;
		ComOpenWait(true);
 	    var formObj = document.form;
 	    
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
		
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//Auth Result
		initCombo(comboObjects[0]);
		initCombo(comboObjects[1]);
		initCombo(comboObjects[2]);
		
		//COD Request Information 조회
	//	doActionIBSheet(sheetObjects[3],document.form,IBROWSEARCH);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		ComOpenWait(false);

		//vCodStsCd R일때 승인 가능
		var vCodStsCd = formObj.cod_sts_cd.value;
		if( !(vCodStsCd == "R" || vCodStsCd == "W" || vCodStsCd == "N" || vCodStsCd == "Y") ){
			formObj.rso.Enable = false;  //Approval RSO
			ComBtnDisable("btn_update"); //Approval RSO Update
			ComBtnDisable("btn_calculation");
			ComBtnDisable("btn_add");    //Row Add
			ComBtnDisable("btn_del");    //Delete
			formObj.authflag.Enable = false; 
			formObj.rejectcd.Enable = false;
		}

		ComBtnDisable("btn_reject");     //Reject Reason Remarks
		var vCodEmailSendYn = formObj.cod_email_send_yn.value;
		if(vCodEmailSendYn == "N")
			ComBtnDisable("btn_Mail");
		else ComBtnEnable("btn_Mail") ;     // Mail
		
		if( !(vCodStsCd == "R" || vCodStsCd == "W" || vCodStsCd == "N" || vCodStsCd == "Y") ){
			ComBtnDisable("btn_ok");         //OK
		}
	}

 	/**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj) {
 		var i=0;
    	    switch(comboObj.id) {
 			case "authflag":
 				with(comboObj) {
 					comboObj.DropHeight=100;
 					InsertItem(i++, "", ""); 					
 					InsertItem(i++, "Y", "Y");
 					InsertItem(i++, "N", "N");
 					InsertItem(i++, "W", "W");
 					comboObj.Code = "";
 	        	}
 				break;
 			case "rso":
 				setRso_Combo(comboObj);
 				break;

 			case "rejectcd":
 				setRjct_Combo(comboObj);
 				comboObj.DropHeight=200;
 				break;
 				
 		}
 	}
 	
//	ComBtnDisable("btn_reject");
//	ComBtnEnable("btn_reject");

 	
     
    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
 		 var sheetID = sheetObj.id;
 				
         switch(sheetID) {
             case "sheet1":      // sheet1 init
                 with (sheetObj) {
                	 
                	 WaitImageVisible = false;
                	 
                     // 높이 설정
                     style.height = 80;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle  = "|Seq.|Container No.|Container Type|Container Condition|Stowage Location|CNTR WGT|";
                   
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     var headCount = ComCountHeadTitle(HeadTitle);
                     InitColumnInfo(headCount, 0, 0, true);
                     
 					 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);            
   
                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,	WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,	55,		daCenter,	true,	prefix+"Seq"); 					
                    InitDataProperty(0, cnt++ , dtData,		170,	daCenter,	true,	prefix+"cntr_no",		false,	"",		dfNone,		0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,		190,	daCenter,	true,	prefix+"cntr_tpsz_cd",	false,	"",		dfNone,		0,	true,	true);
 					InitDataProperty(0, cnt++ , dtData,		250,	daCenter,	true,	prefix+"condition",		false,	"",		dfNone,		0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,		140,	daCenter,	true,	prefix+"cntr_stwg_no",	false,	"",		dfNone,		0,	true,	true);
 					InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	prefix+"cntr_wgt",	false,	"",		dfNone,		0,	true,	true);
 					InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	prefix+"cntr_tpsz_desc",	false,	"",		dfNone,		0,	true,	true); 				   
                 	}
                 break;

             case "sheet2":      // sheet1 init
                 with (sheetObj) {
                	 
                	 WaitImageVisible = false;
                	 
                     // 높이 설정
                     style.height = 60;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);
                     
                     var HeadTitle  = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|||||||||";
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     var headCount = ComCountHeadTitle(HeadTitle);
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)                     
                     
 					 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                    var prefix="sheet2_";
                    //데이터속성    [ROW, COL,  DATATYPE,	WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"rgn_cd",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"old_por",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"old_pol",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"old_pod",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"old_del",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"new_por",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"new_pol",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"new_pod",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"new_del",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"old_vsl_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"old_skd_voy_no",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"old_skd_dir_cd",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"old_vvd",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"new_vsl_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"new_skd_voy_no",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"new_skd_dir_cd",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"new_vvd",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"old_pol_yd_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"old_pod_yd_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"new_pol_yd_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"new_pod_yd_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"diff_rmk",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"cod_rqst_rsn_cd",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"cod_rqst_seq",		false,	"",		dfNone,		0,	true,	true); 
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"cod_rhnd_port_cd",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"cod_sts_cd",		false,	"",		dfNone,		0,	true,	true); 
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"cod_rjct_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"bkg_no",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"cre_usr_id",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"cre_usr_nm",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"pol_full_nm",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"old_pod_full_nm",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"new_pod_full_nm",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"cre_dt",		        false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"vsl_eng_nm",		    false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"trk_old_pod_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"trk_new_pod_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"trk_old_pod_full_nm",   false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"trk_new_pod_full_nm",   false,	"",		dfNone,		0,	true,	true);
				   }
                 break;                 
                 
             case "sheet3":      // sheet1 init
                 with (sheetObj) {
                	 
                	 WaitImageVisible = false;
                	 
                     // 높이 설정
                     style.height = 120;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     var HeadTitle  = "|Sel.|Seq.|CHR|CUR|Rate|CNTR Type/SIZE|E/F|Rehandling Q'ty|Amount|bkg_no|cod_rqst_seq|cgo_cate_cd";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);                     
                     
                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false, false)
                     
 					 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     
                     var prefix="sheet3_";
                     //데이터속성    [ROW, COL,  DATATYPE,	WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,40,		daCenter,	true,	prefix+"ibflag");
                     InitDataProperty(0, cnt++ , dtCheckBox,	30,		daCenter,	true,	prefix+"del_chk");
                     InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	true,	prefix+"cost_cd_rqst_seq"); 					
                     InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,	prefix+"chg_cd",		false,	"",		dfNone,		0,	true,	true);	
                     InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"curr_cd",		false,	"",		dfNone,		0,	true,	true);	
                     InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+"chg_ut_amt",	false,	"",		dfNone,	    0,	true,	true);	
                     InitDataProperty(0, cnt++ , dtData,		120,	daCenter,	true,	prefix+"rat_ut_cd",		false,	"",		dfNone,		0,	true,	true, 2);
                     InitDataProperty(0, cnt++ , dtCombo,		75,		daCenter,	true,	prefix+"cntr_cgo_tp_cd",false,	"",		dfNone,		0,	true,	true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,	120,	daCenter,	true,	prefix+"rat_as_qty",	false,	"",		dfInteger,	0,	true,	true);
                     InitDataProperty(0, cnt++ , dtHidden,		140,	daRight,	true,	prefix+"chg_amt",		false,	"",	    dfNone,	    0,	false,	false);
                     
                     InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"bkg_no",		false,	"",		dfNone,		0,	true,	true);
                     InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"cod_rqst_seq",	false,	"",		dfNone,		0,	true,	true);
                     InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"cgo_cate_cd",	false,	"",		dfNone,		0,	true,	true);
                     
					 InitDataCombo(0, prefix+"chg_cd", "RLO|DVC", "RLO|DVC");
					 InitDataValid(0, prefix+"rat_ut_cd", vtEngUpOther, "0123456789");
					 InitDataCombo(0, prefix+"cntr_cgo_tp_cd", "E|F", "E|F");
					 
					 ShowButtonImage = 2;
				   }
                 break;                 
                 
             case "sheet5":      // sheet1 init
                 with (sheetObj) {
                	 
                	 WaitImageVisible = false;
                	 
                     // 높이 설정
                     style.height = 60;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(2, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle  = "|Seq.";
                   
 					 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                    var prefix="sheet5_";
                    //데이터속성    [ROW, COL,  DATATYPE,	WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,	55,		daCenter,	true,	prefix+"Seq"); 					
 				   
			   }
                 break;
                 
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
			case IBSEARCH:      //조회
				if (sheetObj.id == "sheet1"){
					formObj.f_cmd.value = SEARCH;
					var arr = new Array("sheet1_", "sheet2_", "sheet3_");
					var sXml = sheetObj.GetSearchXml("VOP_OPF_0206GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
					var arrXml = sXml.split("|$$|");
					for(var i = 0; i<arrXml.length; i++){ 
						sheetObjects[i].LoadSearchXml(arrXml[i]); 
					}
					break;						
				}else if(sheetObj.id == "sheet3"){
					formObj.f_cmd.value = SEARCH07;
					formObj.skd_dir_cd.value = formObj.vvd.value.substring(8, 9);
		        	var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_");
					var sXml = sheetObj.GetSearchXml("VOP_OPF_0206GS.do", sParam);
					if(sXml.length>0){ 
						sheetObj.LoadSearchXml(sXml);
					}
					break;
				}

			case IBROWSEARCH:      //조회
				if ( sheetObj.id == "sheet4"){
			   		/*formObj.f_cmd.value = SEARCH01;
			   		var sXml = sheetObj.GetSearchXml("VOP_OPF_0206GS.do", FormQueryString(formObj));
			   		//var vBayPlanCnt = ComGetEtcData(sXml,"BayPlanCnt");
			   		ComOpfGetMessageFromXml(sXml);
			   		//Freight & Charges for COD 시작
			   		//if( !vBayPlanCnt == "0"){
						formObj.f_cmd.value = SEARCH02;
			        	var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_");
						var sXml = sheetObj.GetSearchXml("VOP_OPF_0206GS.do", sParam);
						var vBayPlanCnt = ComGetEtcData(sXml,"BayPlanCnt");
						
						if(sXml.length>0){ 
							sheetObjects[2].LoadSearchXml(sXml);
						}
			   		//}
					*/

			 	//	formObj.f_cmd.value = SEARCH04;
			 	//	var sXml = sheetObj.GetSearchXml("VOP_OPF_0206GS.do", FormQueryString(formObj)); 2016.02
				//	var arrCombo = ComXml2ComboString(sXml, "curr_cd", "curr_cd"); 2016.02
					//if(arrCombo != null){ 2016.02
					//	sheetObjects[2].InitDataCombo(0, "sheet3_curr_cd", arrCombo[0], arrCombo[0]); 2016.02
					//}  2016.02
			 		
					break;						
				}
				
			case IBSAVE:        //저장
				if ( sheetObj.id == "sheet2"){
					formObj.f_cmd.value = MODIFY;
					formObj.rgn_cd.value = comboObjects[0].Code;
					sheetObj.CellValue(sheetObj.SelectRow, "sheet2_rgn_cd") = comboObjects[0].Code; 
					sheetObj.DoSave("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"),-1,false,true);
				}else if(validateForm(sheetObj,formObj,sAction))
				{
	        		if(comboObjects[1].Code == "N"){
						sheetObjects[4].DataInsert(-1);
						formObj.codstscd.value = comboObjects[1].Code;
	        			formObj.f_cmd.value = MULTI;
	        			sheetObjects[4].DoSave("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"),-1,false,true);
	        		}else if(comboObjects[1].Code == "W"){
						formObj.codstscd.value = comboObjects[1].Code;
	        			formObj.f_cmd.value = MULTI;
	        			//sheetObj.DoSave("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"),-1,false,true);
	        			//mySheet.DoSave(PageUrl, [SubParam], [Col] , [Quest], [UrlEncode]))  
	        			//mySheet.DoAllSave(PageUrl, [SubParam], [UrlEncode]) 
	        			
	        			//sheetObj.DoAllSave("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"), true);
	        			
						var sParam =  ComGetSaveString(sheetObjects, true, true);
						if( sParam == ""){ return;}
						var sXml = sheetObj.GetSaveXml("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + sParam, true);	        			
						sheetObj.LoadSaveXml(sXml);
	        			
	        		}else{
	        			formObj.codstscd.value = comboObjects[1].Code;
	        			formObj.f_cmd.value = MULTI;
	        			//sheetObj.DoAllSave("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"), true);
	        			
						var sParam =  ComGetSaveString(sheetObjects, true, true);
						if( sParam == ""){ return;}
						var sXml = sheetObj.GetSaveXml("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + sParam, true);
						sheetObj.LoadSaveXml(sXml);

	        		}
				}
				break;
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         //alert(sheetObj.RowCount); 
         with(formObj){
             /*if(sheetObj.RowCount == 0 ){
                 alert("Freight & Charges for COD에 입력항목이 없습니다.");
             }
             else
             {*/
        		if(comboObjects[1].Code == "N"){
        			if(comboObjects[2].Code == ""){
        				//alert("Reject Reason 선택하여 주세요.");
						ComShowCodeMessage("OPF50009", "Reject Reason");
						ComAlertFocus(formObj.rejectcd, "");
        				return false;			
        			}
        		}
        	 /*}*/
         }
         //
         return true;
     }

     /* RSO 콤보 가져옴 */
 	function setRso_Combo(comboObj){
 	    var formObj = document.form;
 		formObj.f_cmd.value = SEARCH01;
 		var sXml = sheetObjects[3].GetSearchXml("VOP_OPF_0033GS.do", FormQueryString(formObj));
 		ComXml2ComboItem(sXml, comboObj, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
 		//comboObj.Code = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_rgn_cd");
 	}
 	
    /* Reject Reason 콤보 가져옴 */
 	function setRjct_Combo(comboObj){
 	    var formObj = document.form;
 		formObj.f_cmd.value = SEARCH02;
 		var sXml = sheetObjects[3].GetSearchXml("VOP_OPF_0206GS.do", FormQueryString(formObj));
 		ComXml2ComboItem(sXml, comboObj, "cod_rjct_cd", "cod_rjct_cd|cod_rjct_desc");
 		//comboObj.Code = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_cod_sts_cd");
 		//alert(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_cod_sts_cd"));
		
		formObj.rejectcd.Enable = false;
 	}  	
 	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if(sheetObj.RowCount > 0){
    		ComSetObjValue(formObj.cntr_no, sheetObj.CellValue(sheetObj.SelectRow, "sheet1_cntr_no"));
    		ComSetObjValue(formObj.cgo_cate_cd, sheetObj.CellValue(sheetObj.SelectRow, "sheet1_cntr_tpsz_cd"));	
		}
	}
	
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if(sheetObj.RowCount > 0){
    		ComSetObjValue(formObj.old_por, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_old_por"));
    		ComSetObjValue(formObj.old_pol, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_old_pol"));
    		ComSetObjValue(formObj.old_pod, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_old_pod"));
    		ComSetObjValue(formObj.old_del, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_old_del"));
    		ComSetObjValue(formObj.new_por, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_new_por"));
    		ComSetObjValue(formObj.new_pol, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_new_pol"));
    		ComSetObjValue(formObj.new_pod, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_new_pod"));
    		ComSetObjValue(formObj.new_del, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_new_del"));
    		ComSetObjValue(formObj.old_vvd, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_old_vvd"));
    		ComSetObjValue(formObj.new_vvd, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_new_vvd"));
    		ComSetObjValue(formObj.cod_rqst_rsn_cd, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_cod_rqst_rsn_cd"));
    		//ComSetObjValue(formObj.cod_rhnd_port_cd, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_cod_rhnd_port_cd"));   		
    		ComSetObjValue(formObj.codRemark, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_diff_rmk"));    		
    		
    		comboObjects[0].Code = sheetObjects[1].CellValue(sheetObj.SelectRow, "sheet2_rgn_cd");
    		comboObjects[1].Code = sheetObjects[1].CellValue(sheetObj.SelectRow, "sheet2_cod_sts_cd");
    		comboObjects[2].Code = sheetObjects[1].CellValue(sheetObj.SelectRow, "sheet2_cod_rjct_cd");

    		ComSetObjValue(formObj.rcvr_usr_id, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_cre_usr_id"));
    		ComSetObjValue(formObj.rcvr_usr_nm, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_cre_usr_nm"));
		}
	}
	
	function sheet3_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if( formObj.f_cmd.value == SEARCH07 ){
//			if(sheetObj.RowCount == 0){
//				var inx = sheetObj.DataInsert(-1);
//				row_add_sheet3(inx);
//			}else {
				formObj.applied_bayplan_vvd.value = sheetObj.EtcData("applied_bayplan_vvd");
				formObj.applied_bayplan_port.value = sheetObj.EtcData("applied_bayplan_port");
//			}
		}
	}
	
	//Freight & Charges for COD - Grid 변경시 실행
	function sheet3_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);

		if (sName == "sheet3_rat_ut_cd" || sName == "sheet3_cntr_cgo_tp_cd") {	
			//CNTR Type/SIZE 가 입력될때 실행.
			if(sheetObj.CellValue(Row, "sheet3_rat_ut_cd") != ""){
				ComSetObjValue(formObj.rat_ut_cd, sheetObj.CellValue(Row, "sheet3_rat_ut_cd"));
				ComSetObjValue(formObj.tpsz, ComGetObjValue(formObj.rat_ut_cd));

				//CNTR Type/SIZE시 유효성 체크를 합니다.
				formObj.f_cmd.value = SEARCH06;
   	 			var sXml2 = sheetObjects[3].GetSearchXml("VOP_OPF_0206GS.do", FormQueryString(formObj));
   	 			if(ComOpfGetMessageFromXml(sXml2) != ""){
	 				ComShowMessage(ComOpfGetMessageFromXml(sXml2));
	 				ComSetObjValue(formObj.tpsz, "");
	 				sheetObj.SelectCell(Row, Col, true, "");
   	 			}else{
   	 				
   	 				ComSetObjValue(formObj.cntr_cgo_tp_cd, sheetObj.CellValue(Row, "sheet3_cntr_cgo_tp_cd"));
   	 				
   	 				//CHR, CUR, Rate을 조회 합니다.
					formObj.f_cmd.value = SEARCH03;
	   	 			var sXml = sheetObjects[3].GetSearchXml("VOP_OPF_0206GS.do", FormQueryString(formObj));
	   	 			
	   	 			if(ComOpfGetMessageFromXml(sXml) != ""){
	   	 				ComShowMessage(ComOpfGetMessageFromXml(sXml));
	   	 			}else{
	   	 				/** 2009-12-23 시작 인정환 수석님 일단 스킵.
	   	 				sheetObj.CellValue(Row, "sheet3_chg_cd") = ComGetEtcData(sXml,"etcChgCd");
	   	 				sheetObj.CellValue(Row, "sheet3_curr_cd") = ComGetEtcData(sXml,"etcCurrCd");
	   	 				sheetObj.CellValue(Row, "sheet3_chg_ut_amt") = ComGetEtcData(sXml,"etcChgUtAmt");
	   	 				2009-12-23 끝 **/
	   	 				sheetObj.CellValue(Row, "sheet3_curr_cd") = ComGetEtcData(sXml,"etcCurrCd");
	   	 				sheetObj.CellValue(Row, "sheet3_chg_ut_amt") = ComGetEtcData(sXml,"etcChgUtAmt");
	   	 			}
	   	 			
	   	 			//F/M 초기화
	 				ComSetObjValue(formObj.cntr_cgo_tp_cd, "");
   	 			}
			}
		}

		//체크 못함.
		if(sheetObj.CellValue(Row, "sheet3_ibflag") == "R"){
			sheetObj.CellValue(Row, "sheet3_del_chk") = 0;
		}		
	}
	
	//기존에 입력 된 데이타 수정 불가
	function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var formObj = document.form;
		//if(sheetObj.CellValue(NewRow, "sheet3_ibflag") == "R"){
		if(formObj.cod_sts_cd.value == "R" || formObj.cod_sts_cd.value == "N" || formObj.cod_sts_cd.value == "Y" || formObj.cod_sts_cd.value == "W"){
			sheetObj.Editable = true;
		}else{
			sheetObj.Editable = false;
		}
	}
	
	// [t2sheet1] 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	function sheet3_OnPopupClick(sheetObj, Row, Col)
	{
		var formObj = document.form;
		
        //InitDataProperty(0, cnt++ , dtData,		120,	daCenter,	true,	prefix+"rat_ut_cd",		false,	"",		dfNone,		0,	true,	true, 2);
        //InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,	prefix+"cntr_cgo_tp_cd",false,	"",		dfNone,		0,	true,	true);
		
		var sName = sheetObj.ColSaveName(Col);
		
		if (sName == "sheet3_rat_as_qty"){
			if(sheetObj.CellValue(Row, "sheet3_rat_ut_cd") == ""){
				ComShowCodeMessage("OPF50009", "[CNTR Type/SIZE]");
				sheetObj.SelectCell(Row, "sheet3_rat_ut_cd", true, "");
				return false;
			}
		}
		
		with(sheetObj)
		{
			ComSetObjValue(formObj.tpsz, sheetObj.CellValue(Row, "sheet3_rat_ut_cd"));
			ComSetObjValue(formObj.cntr_cgo_tp_cd, sheetObj.CellValue(Row, "sheet3_cntr_cgo_tp_cd"));
			ComSetObjValue(formObj.cgo_cate_cd, sheetObj.CellValue(Row, "sheet3_cgo_cate_cd"));			
			
	 		formObj.f_cmd.value = SEARCH08;
	 		var sXml = sheetObjects[3].GetSearchXml("VOP_OPF_0206GS.do", FormQueryString(formObj));
	 		//alert(ComGetEtcData(sXml,"etcContainerList"));
	 		
			document.getElementById('qtyView').style.left =450; 
			document.getElementById('qtyView').style.top = 248;
			document.getElementById('qtyView').style.visibility="visible";
			document.getElementById('qtyView').style.overflow="visible";
			document.getElementById('qtyView').width=400;
            document.getElementById('qtyView').height=260;
			document.frames("qtyIfrm").document.forms[0].rejectRmk.value=ComGetEtcData(sXml,"etcContainerList"); 
		}
	}
	
	//Row Add - Freight & Charges for COD - Grid 변경시 실행
	function row_add_sheet3(row){
		var formObj = document.form;
		sheetObjects[2].CellValue(row, "sheet3_bkg_no") = ComGetObjValue(formObj.bkg_no);
		sheetObjects[2].CellValue(row, "sheet3_cod_rqst_seq") = ComGetObjValue(formObj.cod_rqst_seq);
		sheetObjects[2].CellValue(row, "sheet3_cgo_cate_cd") = "DR";
		
		/*var vRow = sheetObjects[2].SelectRow;
		formObj.f_cmd.value = SEARCH05;
		var sXml = sheetObjects[3].GetSearchXml("VOP_OPF_0206GS.do", FormQueryString(formObj));
		
		sheetObjects[2].CellValue(vRow, "sheet3_bkg_no") = ComGetObjValue(formObj.bkg_no);
		sheetObjects[2].CellValue(vRow, "sheet3_cod_rqst_seq") = ComGetObjValue(formObj.cod_rqst_seq);
		sheetObjects[2].CellValue(vRow, "sheet3_cgo_cate_cd") = ComGetEtcData(sXml,"etcCgoCateCd");
		
		if(ComGetEtcData(sXml,"etcChgCd") == undefined){
			ComShowMessage(ComOpfGetMessageFromXml(sXml));
		}else{
			sheetObjects[2].CellValue(vRow, "sheet3_chg_cd") = ComGetEtcData(sXml,"etcChgCd");
			sheetObjects[2].CellValue(vRow, "sheet3_curr_cd") = ComGetEtcData(sXml,"etcCurrCd");
			sheetObjects[2].CellValue(vRow, "sheet3_chg_ut_amt") = ComGetEtcData(sXml,"etcChgUtAmt");
			
			sheetObjects[2].CellValue(vRow, "sheet3_rat_ut_cd") = ComGetEtcData(sXml,"etcRatUtCd");
			sheetObjects[2].CellValue(vRow, "sheet3_rat_as_qty") = ComGetEtcData(sXml,"etcRatAsQty");
		}*/
	}	
	
	// Auth Result - Multi Combo 변경시 실행
    function authflag_OnChange(comObj,index,text)
    {
    	var formObj = document.form;
    	var vMsg_ctnt = "";
    	
    	if(text == ""){
    		ComBtnDisable("btn_reject");
    		ComBtnDisable("btn_ok");
    		formObj.rejectcd.Enable = false;
    		comboObjects[2].Code = "";
    	}else{	
    		if(text == "N"){
    			formObj.rejectcd.Enable = true;
    		}else if(text == "Y"){
    			formObj.rejectcd.Enable = false;
    			comboObjects[2].Code = "";
    			vMsg_ctnt += "<< COD Approval Notice (BKG No. :  "+ ComGetObjValue(formObj.bkg_no)  +") >>\n\n";
    			vMsg_ctnt += "Please be advised that your COD application has been approved.\n\n";
    			vMsg_ctnt += "Please check Rehandling Tariff with Rehandling Port SCO and \n\n";
    			vMsg_ctnt += "input DVC and Rehandling Cost into B/L properly. \n\n";
    			vMsg_ctnt += " - BKG No.: "+ ComGetObjValue(formObj.bkg_no) +"\n";
    			
    			for(var i=sheetObjects[0].HeaderRows ; i <= sheetObjects[0].RowCount ; i++){
    				if(i ==sheetObjects[0].HeaderRows){
    					vMsg_ctnt += " - Container No.: "+ sheetObjects[0].CellValue(i, "sheet1_cntr_no") +"\n";
    				}else{
    					vMsg_ctnt += "                         "+ sheetObjects[0].CellValue(i, "sheet1_cntr_no") +"\n";
    				}
    			}
    			//vMsg_ctnt += " - Container No.: "+ ComGetObjValue(formObj.cntr_no) +"\n";

    			vMsg_ctnt += "\n";
    			vMsg_ctnt += "Please reply your final confirmation ASAP.";

    			ComSetObjValue(formObj.msg_ctnt, vMsg_ctnt);    			
    		}else{
    			formObj.rejectcd.Enable = false;
    			comboObjects[2].Code = "";
    		}
    		ComBtnEnable("btn_ok");
    	}
    }
	
    // Reject Reason - Multi Combo 변경시 실행
    function rejectcd_OnChange(comObj,index,text)
    {
    	var formObj = document.form;    	
    	var vMsg_ctnt = "";
    	
    	if(text == ""){
    		ComBtnDisable("btn_reject");
    	}else{	
   			ComBtnEnable("btn_reject");
			vMsg_ctnt += "<< COD Rejection Notice (BKG No. : "+ ComGetObjValue(formObj.bkg_no)  +") >>\n\n";
			vMsg_ctnt += "Please be advised that your COD application has been rejected.\n";
			vMsg_ctnt += "For details please refer to followings.\n\n";
			vMsg_ctnt += " - BKG No.: "+ ComGetObjValue(formObj.bkg_no) +"\n";
			//vMsg_ctnt += " - Container No.: "+ ComGetObjValue(formObj.cntr_no) +"\n";
			for(var i=sheetObjects[0].HeaderRows ; i <= sheetObjects[0].RowCount ; i++){
				if(i ==sheetObjects[0].HeaderRows){
					vMsg_ctnt += " - Container No.: "+ sheetObjects[0].CellValue(i, "sheet1_cntr_no") +"\n";
				}else{
					vMsg_ctnt += "                         "+ sheetObjects[0].CellValue(i, "sheet1_cntr_no") +"\n";
				}
			}
			
			vMsg_ctnt += " - Reject Reason : "+ comObj.GetText(index,1) +"\n";
			vMsg_ctnt += "\n";
			vMsg_ctnt += "Please reply your final confirmation ASAP.";

			ComSetObjValue(formObj.msg_ctnt, vMsg_ctnt);
    	}
    }    
    
 	function sheet3_OnSaveEnd(ErrMsg){
 		window.close();
 		window.dialogArguments.call_0206();
 	}    

 	function sheet5_OnSaveEnd(ErrMsg){
 		window.close();
 		//opener
 		window.dialogArguments.call_0206();
 	}   	
	/* 개발자 작업  끝 */