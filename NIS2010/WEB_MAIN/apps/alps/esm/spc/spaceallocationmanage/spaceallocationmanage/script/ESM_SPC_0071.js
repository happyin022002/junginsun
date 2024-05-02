/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0071.js
*@FileTitle : SKD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.09.29 최윤성
* 1.0 Creation
* 2016.05.12 이혜민 CHM-201640880 T/S History 개발 요청
* 2016.07.14 이혜민 CHM-201642304 T/S Plan & Guide 기능 Logic 수정 
=========================================================*/
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
     * @class ESM_SPC_0071 : ESM_SPC_0071 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0071() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    
    // 공통전역변수
    var ipageNo =1 ;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var selectVal;
    var opener = window.dialogArguments;
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
        	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        	var sheetObject = sheetObjects[0];
        	/*******************************************************/
        	var formObject = document.form;
        	
        	try {
        		var srcName = window.event.srcElement.getAttribute("name");
        		
        		switch(srcName) {
        			
            	    case "btn_retrieve":
            	    	doActionIBSheet(sheetObject,formObject,IBSEARCH);
            	    	break;
            	    
            	    case "btn_new":
            	    	sheetObject.RemoveAll();
            	    	formObject.reset();
            	    	break;
            	    
            	    case "btn_apply":
            	    	doActionIBSheet(sheetObject,formObject,"Apply");
            	    	break;	
            	    	
            	    case "btn_close":
            	    	self.close();
            	    	break;
        		} // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COM12111");
        		} else {
        			ComShowMessage(e);
        		}
        	}
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
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	var sheetObject = sheetObjects[0];
        	var formObject = document.form;
        	
        	for(i=0;i<sheetObjects.length;i++){
        		//khlee-시작 환경 설정 함수 이름 변경
        		ComConfigSheet(sheetObjects[i]);
        		initSheet(sheetObjects[i],i+1);
        		//khlee-마지막 환경 설정 함수 추가
        		ComEndConfigSheet(sheetObjects[i]);
        	}

        	if(formObject.org_ui_id.value == "ESM_SPC_0087"){
        		sheetObject.ColHidden("chk") = false; 
        		sheetObject.ColHidden("vps_etb_dt") = false; 
        		sheetObject.ColHidden("turn_port_ind_cd") = true;
        		sheetObject.ColHidden("cng_sts_cd") = false;
        		sheetObject.ColHidden("vps_eta_dt") = true;
        		
        		retrieve_div.style.display = "none";
        		new_div.style.display = "none";
        		apply_div.style.display = "inline";
        		formObject.vvd.className = "input2";

        	}else{
        		sheetObject.ColHidden("chk") = true; 
        		sheetObject.ColHidden("vps_etb_dt") = true; 
        		sheetObject.ColHidden("turn_port_ind_cd") = false;
        		sheetObject.ColHidden("cng_sts_cd") = false;
        		sheetObject.ColHidden("vps_eta_dt") = false;

        		retrieve_div.style.display = "inline";
        		new_div.style.display = "inline";
        		apply_div.style.display = "none";
        		formObject.vvd.className = "input";
        	}
        	
        	// VVD가 입력된 경우, 자동 조회
        	var vvd = formObject.vvd.value;
        	if(vvd != null && vvd.length == 9) {
        		doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	}
        }
        
        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
        	var cnt = 0;
        	
        	switch(sheetNo) {
        	    case 1:      //IBSheet1 init
        	    	with (sheetObj) {
        	    		// 높이 설정
        	    		style.height = GetSheetHeight(10) ;
        	    		//전체 너비 설정
        	    		SheetWidth = mainTable.clientWidth;
        	    		//Host정보 설정[필수][HostIp, Port, PagePath]
        	    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        	    		//전체Merge 종류 [선택, Default msNone]
        	    		MergeSheet = msHeaderOnly;
        	    		//전체Edit 허용 여부 [선택, Default false]
        	    		Editable = true;
        	    		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        	    		InitRowInfo( 1, 1, 9, 50);
        	    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        	    		InitColumnInfo(14, 0, 0, true);
        	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
        	    		InitHeadMode(true, true, false, true, false,false)
        	    		
        	    		var HeadTitle = "CHK|SEQ|VESSEL|VOYAGE|DIR|CALLING IND|PORT|YARD|S.LANE|ETA DATE|ETB DATE|ETD DATE|T.IND|C.IND" ;
        	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        	    		InitHeadRow(0, HeadTitle, true);
        	    		
        	    		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        				InitDataProperty(0,	cnt++,	dtCheckBox,	 45,	daCenter,  false,	 "chk"			   ,		false,		    "",	      dfNone,			0,	true,	true);
        	    		InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  false,    "cltp_seq"        ,        false,          "",       dfNone,   	0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,    "vsl_cd"          ,        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      55,    daCenter,  false,    "skd_voy_no"      ,        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  false,    "skd_dir_cd"      ,        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,    "cltp_ind_seq"    ,        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      45,    daCenter,  false,    "vsl_port_cd"     ,        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "yd_cd"           ,        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      45,    daCenter,  false,    "slan_cd"         ,        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      85,    daCenter,  false,    "vps_eta_dt"      ,        false,          "",    	  dfDateYmd,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      85,    daCenter,  false,    "vps_etb_dt"      ,        false,          "",       dfDateYmd,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      85,    daCenter,  false,    "vps_etd_dt"      ,        false,          "",       dfDateYmd,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      35,    daCenter,  false,    "turn_port_ind_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      35,    daCenter,  false,    "cng_sts_cd"      ,        false,          "",       dfNone,       0,     false,       true);
        	    	}
        	    	break;
        	}
        }
        
        // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction,a,PageNo) {
        	sheetObj.ShowDebugMsg = false;
        	
        	switch(sAction) {
        	    case IBSEARCH:      //조회
        	    	if(!validateForm(sheetObj,formObj,sAction)) {
        	    		return false;
        	    	}
        	    	
        	    	formObj.f_cmd.value = SEARCHLIST;
        	    	var param = SpcFormString(formObj,'vvd');
        	    	sheetObj.DoSearch4Post("ESM_SPC_0071GS.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);

        	    	break;
        	    	
        	    case "Apply":
        	    	var org_sheet  = opener.sheetObjects[0];
        	    	var org_sheet1 = opener.sheetObjects[1];
        	    	var rtnTp = formObj.targetColume.value;
        	    	var rtnStr = new Array();
        	    	var rtnPortCd = "";
        	    	var rtnEtbDt  = "";
        	    	var rtnEtdDt  = "";
        	    	var rtnSlanCd = "";
        	    	var rtnYdCd   = "";
        	    	
        	    	if(rtnTp == "mlt_pol_list_ctnt"){
        	    		//mlt_pol_list_ctnt, n1st_rlane_cd
        				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            				if (sheetObj.CellValue(i, "chk") == "1") {
            					rtnPortCd = rtnPortCd + sheetObj.CellValue(i, "vsl_port_cd") + ",";
            					//선택한 port 중 마지막 etd_dt
            					rtnEtdDt  = sheetObj.CellValue(i, "vps_etd_dt");
            					rtnSlanCd = sheetObj.CellValue(i, "slan_cd");
            				}
            			}
        				//마지막 콤마(,) 삭제
        				rtnPortCd = rtnPortCd.substr(0, rtnPortCd.length - 1);
        				//시, 분 삭제
        				rtnEtdDt  = rtnEtdDt.substr(0, rtnEtdDt.length - 6);
        				
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "mlt_pol_list_ctnt") = rtnPortCd;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n1st_port_etd_dt")  = rtnEtdDt;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n1st_rlane_cd")     = rtnSlanCd;
        				
            	    	self.close();
            	    	
        	    	}else if(rtnTp == "mlt_pod_list_ctnt"){
        	    		//mlt_pod_list_ctnt
        				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            				if (sheetObj.CellValue(i, "chk") == "1") {
            					rtnPortCd = rtnPortCd + sheetObj.CellValue(i, "vsl_port_cd") + ",";
            				}
            			}
        				//선택한 port 중 첫번째 etb_dt
        				var chkRow = sheetObj.FindCheckedRow("chk");
        				var arrRow = chkRow.split("|");
        				rtnEtbDt = sheetObj.CellValue(arrRow[0], "vps_etb_dt");
        				
        				//마지막 콤마(,) 삭제
        				rtnPortCd = rtnPortCd.substr(0, rtnPortCd.length - 1);
        				//시, 분 삭제
        				rtnEtbDt  = rtnEtbDt.substr(0, rtnEtbDt.length - 6);
        				
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "mlt_pod_list_ctnt") 	  = rtnPortCd;
        				//가장 마지막 vvd를 찾아서 마지막 etb dt를 넣어줌
        			 	if(org_sheet1.cellValue(org_sheet1.SelectRow, "n5th_vvd_cd") != ""){
        			 		org_sheet1.CellValue2(org_sheet1.SelectRow, "n5th_port_etb_dt") = rtnEtbDt;
        			 	}else if(org_sheet1.cellValue(org_sheet1.SelectRow, "n4th_vvd_cd") != ""){
        			 		org_sheet1.CellValue2(org_sheet1.SelectRow, "n4th_port_etb_dt") = rtnEtbDt;
        			 	}else if(org_sheet1.cellValue(org_sheet1.SelectRow, "n3rd_vvd_cd") != ""){
        			 		org_sheet1.CellValue2(org_sheet1.SelectRow, "n3rd_port_etb_dt") = rtnEtbDt;
        			 	}else if(org_sheet1.cellValue(org_sheet1.SelectRow, "n2nd_vvd_cd") != ""){
        			 		org_sheet1.CellValue2(org_sheet1.SelectRow, "n2nd_port_etb_dt") = rtnEtbDt;
        			 	}else if(org_sheet1.cellValue(org_sheet1.SelectRow, "n1st_vvd_cd") != ""){
        			 		org_sheet1.CellValue2(org_sheet1.SelectRow, "n1st_port_etb_dt") = rtnEtbDt;
        			 	}
            	    	self.close();

        	    	}else if(rtnTp == "n1st_pod_cd"){
        	    		//Port, etb_dt, yd_cd
        				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            				if (sheetObj.CellValue(i, "chk") == "1") {
            					rtnPortCd = rtnPortCd + sheetObj.CellValue(i, "vsl_port_cd");
            					rtnEtbDt  = sheetObj.CellValue(i, "vps_etb_dt");
            					rtnYdCd   = sheetObj.CellValue(i, "yd_cd");
            				}
            			}
        				
        				//Port를 두개 이상 선택했을 경우 
        				if(rtnPortCd.length > 5){
        					ComShowMessage(getMsg("SPC90403")); //Please select one port.
        					return false;
        				}
        				
        				//시, 분 삭제
        				rtnEtbDt  = rtnEtbDt.substr(0, rtnEtbDt.length - 6);
        				//Yard 2자리만 남김
        				rtnYdCd   = rtnYdCd.substr(5,7);
        				
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n1st_pod_cd") 	    = rtnPortCd;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n1st_port_etb_dt") = rtnEtbDt;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n1st_pod_yd_cd")   = rtnYdCd; 
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n2nd_pol_cd") 	    = rtnPortCd;
            	    	self.close();

        	    	}else if(rtnTp == "n2nd_pod_cd"){
        	    		//Port, etb_dt, yd_cd
        				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            				if (sheetObj.CellValue(i, "chk") == "1") {
            					rtnPortCd = rtnPortCd + sheetObj.CellValue(i, "vsl_port_cd");
            					rtnEtbDt  = sheetObj.CellValue(i, "vps_etb_dt");
            					rtnYdCd   = sheetObj.CellValue(i, "yd_cd");
            				}
            			}
        				
        				//Port를 두개 이상 선택했을 경우 
        				if(rtnPortCd.length > 5){
        					ComShowMessage(getMsg("SPC90403")); //Please select one port.
        					return false;
        				}
        				
        				//시, 분 삭제
        				rtnEtbDt  = rtnEtbDt.substr(0, rtnEtbDt.length - 6);
        				//Yard 2자리만 남김
        				rtnYdCd   = rtnYdCd.substr(5,7);
        				
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n2nd_pod_cd") 	    = rtnPortCd;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n2nd_port_etb_dt") = rtnEtbDt;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n2nd_pod_yd_cd")   = rtnYdCd; 
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n3rd_pol_cd") 	    = rtnPortCd;
            	    	self.close();

        	    	}else if(rtnTp == "n3rd_pod_cd"){
        	    		//Port, etb_dt, yd_cd
        				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            				if (sheetObj.CellValue(i, "chk") == "1") {
            					rtnPortCd = rtnPortCd + sheetObj.CellValue(i, "vsl_port_cd");
            					rtnEtbDt  = sheetObj.CellValue(i, "vps_etb_dt");
            					rtnYdCd   = sheetObj.CellValue(i, "yd_cd");
            				}
            			}
        				
        				//Port를 두개 이상 선택했을 경우 
        				if(rtnPortCd.length > 5){
        					ComShowMessage(getMsg("SPC90403")); //Please select one port.
        					return false;
        				}
        				
        				//시, 분 삭제
        				rtnEtbDt  = rtnEtbDt.substr(0, rtnEtbDt.length - 6);
        				//Yard 2자리만 남김
        				rtnYdCd   = rtnYdCd.substr(5,7);
        				
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n3rd_pod_cd") 	    = rtnPortCd;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n3rd_port_etb_dt") = rtnEtbDt;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n3rd_pod_yd_cd")   = rtnYdCd; 
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n4th_pol_cd") 	    = rtnPortCd;
            	    	self.close();

        	    	}else if(rtnTp == "n4th_pod_cd"){
        	    		//Port, etb_dt, yd_cd
        				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            				if (sheetObj.CellValue(i, "chk") == "1") {
            					rtnPortCd = rtnPortCd + sheetObj.CellValue(i, "vsl_port_cd");
            					rtnEtbDt  = sheetObj.CellValue(i, "vps_etb_dt");
            					rtnYdCd   = sheetObj.CellValue(i, "yd_cd");
            				}
            			}
        				
        				//Port를 두개 이상 선택했을 경우 
        				if(rtnPortCd.length > 5){
        					ComShowMessage(getMsg("SPC90403")); //Please select one port.
        					return false;
        				}
        				
        				//시, 분 삭제
        				rtnEtbDt  = rtnEtbDt.substr(0, rtnEtbDt.length - 6);
        				//Yard 2자리만 남김
        				rtnYdCd   = rtnYdCd.substr(5,7);
        				
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n4th_pod_cd") 	    = rtnPortCd;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n4th_port_etb_dt") = rtnEtbDt;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n4th_pod_yd_cd")   = rtnYdCd; 
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n5th_pol_cd") 	    = rtnPortCd;
            	    	self.close();

        	    	}else if(rtnTp == "irr_port_cd"){
        	    		//Port, yd_cd
        				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            				if (sheetObj.CellValue(i, "chk") == "1") {
            					rtnPortCd = rtnPortCd + sheetObj.CellValue(i, "vsl_port_cd");
            					rtnYdCd   = sheetObj.CellValue(i, "yd_cd");
            				}
            			}
        				
        				//Port를 두개 이상 선택했을 경우 
        				if(rtnPortCd.length > 5){
        					ComShowMessage(getMsg("SPC90403")); //Please select one port.
        					return false;
        				}
        				
        				//Yard 2자리만 남김
        				rtnYdCd   = rtnYdCd.substr(5,7);
        				org_sheet.CellValue2(org_sheet.SelectRow, "irr_port_cd") = rtnPortCd;
        				org_sheet.CellValue2(org_sheet.SelectRow, "irr_yd_cd")   = rtnYdCd; 
            	    	self.close();

        	    	}else if(rtnTp == "n2nd_vvd_cd"){
        	    		//yd_cd, etd_dt, slan_cd
        				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            				if (sheetObj.CellValue(i, "chk") == "1") {
            					rtnYdCd   = rtnYdCd + sheetObj.CellValue(i, "yd_cd");
            					rtnEtdDt  = sheetObj.CellValue(i, "vps_etd_dt");
            					rtnSlanCd = sheetObj.CellValue(i, "slan_cd");
            				}
            			}
        				
        				//Port를 두개 이상 선택했을 경우 
        				if(rtnYdCd.length > 7){
        					ComShowMessage(getMsg("SPC90403")); //Please select one port.
        					return false;
        				}
        				
        				//시, 분 삭제
        				rtnEtdDt  = rtnEtdDt.substr(0, rtnEtdDt.length - 6);
        				//Yard 2자리만 남김
        				rtnYdCd   = rtnYdCd.substr(5,7);
        				
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n2nd_pol_yd_cd") 	= rtnYdCd;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n2nd_port_etd_dt") = rtnEtdDt;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n2nd_rlane_cd")    = rtnSlanCd; 
            	    	self.close();
        	    		
        	    	}else if(rtnTp == "n3rd_vvd_cd"){
        	    		//yd_cd, etd_dt, slan_cd
        				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            				if (sheetObj.CellValue(i, "chk") == "1") {
            					rtnYdCd   = rtnYdCd + sheetObj.CellValue(i, "yd_cd");
            					rtnEtdDt  = sheetObj.CellValue(i, "vps_etd_dt");
            					rtnSlanCd = sheetObj.CellValue(i, "slan_cd");
            				}
            			}
        				
        				//Port를 두개 이상 선택했을 경우 
        				if(rtnYdCd.length > 7){
        					ComShowMessage(getMsg("SPC90403")); //Please select one port.
        					return false;
        				}
        				
        				//시, 분 삭제
        				rtnEtdDt  = rtnEtdDt.substr(0, rtnEtdDt.length - 6);
        				//Yard 2자리만 남김
        				rtnYdCd   = rtnYdCd.substr(5,7);
        				
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n3rd_pol_yd_cd") 	= rtnYdCd;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n3rd_port_etd_dt") = rtnEtdDt;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n3rd_rlane_cd")    = rtnSlanCd; 
            	    	self.close();
        	    		
        	    	}else if(rtnTp == "n4th_vvd_cd"){
        	    		//yd_cd, etd_dt, slan_cd
        				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            				if (sheetObj.CellValue(i, "chk") == "1") {
            					rtnYdCd   = rtnYdCd + sheetObj.CellValue(i, "yd_cd");
            					rtnEtdDt  = sheetObj.CellValue(i, "vps_etd_dt");
            					rtnSlanCd = sheetObj.CellValue(i, "slan_cd");
            				}
            			}
        				
        				//Port를 두개 이상 선택했을 경우 
        				if(rtnYdCd.length > 7){
        					ComShowMessage(getMsg("SPC90403")); //Please select one port.
        					return false;
        				}
        				
        				//시, 분 삭제
        				rtnEtdDt  = rtnEtdDt.substr(0, rtnEtdDt.length - 6);
        				//Yard 2자리만 남김
        				rtnYdCd   = rtnYdCd.substr(5,7);
        				
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n4th_pol_yd_cd") 	= rtnYdCd;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n4th_port_etd_dt") = rtnEtdDt;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n4th_rlane_cd")    = rtnSlanCd; 
            	    	self.close();
        	    		
        	    	}else if(rtnTp == "n5th_vvd_cd"){
        	    		//yd_cd, etd_dt, slan_cd
        				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            				if (sheetObj.CellValue(i, "chk") == "1") {
            					rtnYdCd   = rtnYdCd + sheetObj.CellValue(i, "yd_cd");
            					rtnEtdDt  = sheetObj.CellValue(i, "vps_etd_dt");
            					rtnSlanCd = sheetObj.CellValue(i, "slan_cd");
            				}
            			}
        				
        				//Port를 두개 이상 선택했을 경우 
        				if(rtnYdCd.length > 7){
        					ComShowMessage(getMsg("SPC90403")); //Please select one port.
        					return false;
        				}
        				
        				//시, 분 삭제
        				rtnEtdDt  = rtnEtdDt.substr(0, rtnEtdDt.length - 6);
        				//Yard 2자리만 남김
        				rtnYdCd   = rtnYdCd.substr(5,7);
        				
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n5th_pol_yd_cd") 	= rtnYdCd;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n5th_port_etd_dt") = rtnEtdDt;
        				org_sheet1.CellValue2(org_sheet1.SelectRow, "n5th_rlane_cd")    = rtnSlanCd; 
            	    	self.close();
        	    		
        	    	}
        			break;
        	}
        }
        
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	with(formObj){
        		if(formObj.vvd.value=="") {
        			ComShowMessage("You must input VVD");
        			formObj.vvd.focus();
        			return false;
        		}
        		
        		if(formObj.vvd.value.length < 9) {
        			ComShowMessage("VVD must be 9 characters");
        			formObj.vvd.focus();
        			return false;
        		}
        	}
        	return true;
        }
        
        function sheet1_OnSearchEnd(sheetObj, errMsg){
        	var formObj   = document.form;
        	//Skip Port는 선택 못하도록 막음
        	if(formObj.org_ui_id.value == "ESM_SPC_0087"){
        		//위 시트에서는 모든 Port를 선택할 수 있도록 하고 아래 시트에서는 Skip된 Port는 선택할 수 없도록 함.
        		if( formObj.targetColume.value != "irr_port_cd"){
	        		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	        			if(sheetObj.CellValue(i, "cng_sts_cd") == "S"){
	        				sheetObj.CellEditable(i, "chk") = false;
	        			}
	        		}
        		}
        		
        		//부모창의 VVD, pol_cd 입력시 해당된 pol_cd만 선택할 수 있도록 함
            	if(formObj.pol_cd.value != ""){
    				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
    					if(sheetObj.CellValue(i, "vsl_port_cd") != formObj.pol_cd.value){
    						sheetObj.CellEditable(i, "chk") = false;
    					}
    				}
            	}
        	}
        }

	/* 개발자 작업  끝 */