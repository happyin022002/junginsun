/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1175.js
*@FileTitle : B/L Detail 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.05
*@LastModifier : 임재관
*@LastVersion : 1.0
* 2010.02.17 임재관
* 1.0 Creation
* -----------------------------------------------------------------
* History

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
     * @class ESM_BKG_1175 : ESM_BKG_1175 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1175() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetObjectsMap = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_excel":
                	sheetObject.SpeedDown2Excel(-1);
				break;  

                case "btn_close":
					window.close();
                break;



            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("지금은 사용하실 수가 없습니다 ");
    		} else {
    			alert(e);
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
       sheetObjectsMap[sheet_obj.id] = sheet_obj;
			
    }



    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    	
    	// Charge Code 에 따른 Title 변경
    	if (document.form.charge_cd.value == '1'){
    		document.title = "Charge Summary Report BL Inquiry (BCC,MCF)";
    		lbTitle.innerHTML="&nbsp;Charge Summary Report BL Inquiry (BCC,MCF)";
    	} else if (document.form.charge_cd.value == '2'){
    		document.title = "Charge Summary Report BL Inquiry (OBS)";
    		lbTitle.innerHTML="&nbsp;Charge Summary Report BL Inquiry (OBS)";
    	} else if (document.form.charge_cd.value == '3'){
    		document.title = "Charge Summary Report BL Inquiry (BLR)";
    		lbTitle.innerHTML="&nbsp;Charge Summary Report BL Inquiry (BLR)";
    	} 

    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 450;
                    //전체 너비 설정
                    style.height = 382;
        			// 전체 너비 설정
        			SheetWidth = mainTable.clientWidth;

        			// Host정보 설정[필수][HostIp, Port, PagePath]
        			if (location.hostname != "")
        				InitHostInfo(location.hostname, location.port, page_path);

        			// 전체Merge 종류 [선택, Default msNone]
        			MergeSheet = msPrevColumnMerge+msHeaderOnly;

        			// 전체Edit 허용 여부 [선택, Default false]
        			Editable = false;

        			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        			InitRowInfo(1, 1, 3, 100);

        			var HeadTitle1 = "Booking No.|Trade|Sub\n Trade|Scope|Dir\n (Bound)|LANE|Trunk VVD|B.RHQ|BKG\n R.OFC|B.OFC|Appl. Date|Contract No.|Customer\n Code|";
        			HeadTitle1 += "Customer\n Description|C.RHQ|C.OFC|TEU|POR|POL\n Country|POL|POD\n Country|POD|DEL|R/D\n Term|Charge\n Y/N|Payment|Surcharge\n Code|Cur.|Amount";
        			
        			if (document.form.charge_cd.value == '2' ){
        				HeadTitle1 += "|Surrender\n OFC|Surrehder\n Date";
        			} else if (document.form.charge_cd.value == '3'){
        				HeadTitle1 += "|Reissue\n OFC|Reissue\n Date";
        			}
        			
        			var headCount = ComCountHeadTitle(HeadTitle1);
        			
        			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        			InitColumnInfo(headCount, 0, 0, true);
        	
        			// 해더에서 처리할 수 있는 각종 기능을 설정한다
        			InitHeadMode(true, true, true, true, false, false);
        	
        			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        			InitHeadRow(0, HeadTitle1, true);

        			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
        			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        			// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");
        			
        			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "bkg_no", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "trd_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "sub_trd_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "svc_scp_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "skd_dir_cd", false, "", dfNone, 0, false, true);

        			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "slan_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vvd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "rhq_bkg_ofc_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "gso_bkg_ofc_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "bkg_ofc_cd", false, "", dfNone, 0, false, true);
        			
        			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "aply_dt", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "contract_no", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "customer_code", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "customer_name", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "rhq_ctrt_ofc_cd", false, "", dfNone, 0, false, true);    
        			
        			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "ctrt_ofc_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "teu", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "por_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pol_cnt_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pol_cd", false, "", dfNone, 0, false, true);    
        			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pod_cnt_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pod_cd", false, "", dfNone, 0, false, true);    
        			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "del_cd", false, "", dfNone, 0, false, true);    
        			
        			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "term_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "charge", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "payment_term_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "chg_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "curr_cd", false, "", dfNone, 0, false, true);
        			InitDataProperty(0, cnt++, dtData, 100, daRight, true, "rating_ttl", false, "", dfNone, 0, false, true);
        			
        			if (document.form.charge_cd.value == '2'){
	        			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "surrender_ofc_cd", false, "", dfNone, 0, false, true);
	        			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "surrender_dt", false, "", dfNone, 0, false, true);
        			} else if (document.form.charge_cd.value == '3' ){
	        			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "reissue_ofc_cd", false, "", dfNone, 0, false, true);
	        			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "reissue_dt", false, "", dfNone, 0, false, true);
        			}
        			
        			CountPosition = 1;															
               }
                break;
                
        	case "LBPsheet": //LBPsheet
        		with (sheetObj) {
        		// 높이 설정
        		style.height = 382;
        		// 전체 너비 설정
        		SheetWidth = mainTable.clientWidth;
        		
        		// Host정보 설정[필수][HostIp, Port, PagePath]
        		if (location.hostname != "")
        			InitHostInfo(location.hostname, location.port, page_path);
        		
        		// 전체Merge 종류 [선택, Default msNone]
        		MergeSheet = msPrevColumnMerge;
        		
        		// 전체Edit 허용 여부 [선택, Default false]
        		Editable = false;
        		
        		var HeadTitle1 = "BL_NO|BKG_NO|VVD|BL_OBRD_DT|BKG_OFC_CD|BKG_GSO_OFC_CD|BKG_RHQ_CD|UPD_USR_ID|CTRT_OFC_CD|POR_CD|POL_CD|POD_CD|DEL_CD|Charge_Code|LBP_CURR|LBP_AMT|CUST_NM|SCOPE|OC_LOCAL_DATE|OBL_ISS_DT|ETD";
        		
        		
        		
        		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        		InitRowInfo(1, 1, 3, 100);
        		
        		
        		var headCount = ComCountHeadTitle(HeadTitle1);
        		//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        		InitColumnInfo(headCount, 0, 0, true);
        		
        		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        		InitHeadRow(0, HeadTitle1, true);
        		
        		// 해더에서 처리할 수 있는 각종 기능을 설정한다
        		InitHeadMode(true, true, false, true, false, false)
        		
        		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
        		// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        		// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");
        		
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_no",            false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no",           false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "vvd",              false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_obrd_dt",       false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_ofc_cd",       false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "gso_bkg_ofc_cd",   false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rhq_bkg_ofc_cd",   false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "upd_usr_id",       false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ctrt_ofc_cd",      false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "por_cd",           false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "pol_cd",           false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "pod_cd",           false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "del_cd",           false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "chg_cd",           false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "curr_cd",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "chg_amt",          false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 170, daCenter, true, "customer_name",    false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "svc_scp_cd",       false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "oc_local_date",    false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "obl_iss_dt",       false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "etd",              false, "", dfNone, 0, false, true);

        		CountPosition = 1;
        		}
        		break;
        	case "TPFsheet": //TPFsheet
        		with (sheetObj) {
        		// 높이 설정
        		style.height = 382;
        		// 전체 너비 설정
        		SheetWidth = mainTable.clientWidth;
        		
        		// Host정보 설정[필수][HostIp, Port, PagePath]
        		if (location.hostname != "")
        			InitHostInfo(location.hostname, location.port, page_path);
        		
        		// 전체Merge 종류 [선택, Default msNone]
        		MergeSheet = msPrevColumnMerge;
        		
        		// 전체Edit 허용 여부 [선택, Default false]
        		Editable = false;
        		
        		var HeadTitle1 = "BKG_NO|POR_CD|POL_CD|POD_CD|DEL_CD|SCOPE|VVD|BL_OBRD_DT|BKG_OFC_CD|BKG_GSO_OFC_CD|RHQ_BKG_OFC_CD|CTRT_OFC_CD|PPD_RCV_OFC_CD|CLT_OFC_CD|PPD_3RD|CCT_3RD|RFA_NO|SC_NO|FLAG|CURR_CD|CHG_AMT";
        		
        		
        		
        		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        		InitRowInfo(1, 1, 3, 100);
        		
        		
        		var headCount = ComCountHeadTitle(HeadTitle1);
        		//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        		InitColumnInfo(headCount, 0, 0, true);
        		
        		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        		InitHeadRow(0, HeadTitle1, true);
        		
        		// 해더에서 처리할 수 있는 각종 기능을 설정한다
        		InitHeadMode(true, true, false, true, false, false)
        		
        		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
        		// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        		// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");
        		
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "por_cd",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "pol_cd",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "pod_cd",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "del_cd",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "svc_scp_cd",     false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "vvd",            false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_obrd_dt",     false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_ofc_cd",     false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "gso_bkg_ofc_cd", false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rhq_bkg_ofc_cd", false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ctrt_ofc_cd",    false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ppd_rcv_ofc_cd", false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "clt_ofc_cd",     false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ppd_3rd",        false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cct_3rd",        false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rfa_no",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "sc_no",          false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "charge",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "curr_cd",        false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "chg_amt",        false, "", dfNone, 0, false, true);

        		CountPosition = 1;
        		}
        		break;
        	case "CTC_LSIsheet": //CTC_LSIsheet
        		with (sheetObj) {
        		// 높이 설정
        		style.height = 382;
        		// 전체 너비 설정
        		SheetWidth = mainTable.clientWidth;
        		
        		// Host정보 설정[필수][HostIp, Port, PagePath]
        		if (location.hostname != "")
        			InitHostInfo(location.hostname, location.port, page_path);
        		
        		// 전체Merge 종류 [선택, Default msNone]
        		MergeSheet = msPrevColumnMerge;
        		
        		// 전체Edit 허용 여부 [선택, Default false]
        		Editable = false;
        		
        		var HeadTitle1 = "BL_NO|BKG_NO|VVD|BL_OBRD_DT|BKG_OFC_CD|BKG_GSO_OFC_CD|RHQ_BKG_OFC_CD|User ID|CTRT_OFC_CD|POR_CD|POL_CD|POD_CD|DEL_CD|CHG_CD|CURR_CD|CHG_AMT|SVC_SCP_CD|SC_NO";
        		
        		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        		InitRowInfo(1, 1, 3, 100);
        		
        		
        		var headCount = ComCountHeadTitle(HeadTitle1);
        		//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        		InitColumnInfo(headCount, 0, 0, true);
        		
        		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        		InitHeadRow(0, HeadTitle1, true);
        		
        		// 해더에서 처리할 수 있는 각종 기능을 설정한다
        		InitHeadMode(true, true, false, true, false, false)
        		
        		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
        		// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        		// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");
        		
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_no",          false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "vvd",            false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_obrd_dt",     false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_ofc_cd",     false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "gso_bkg_ofc_cd", false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rhq_bkg_ofc_cd", false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "upd_usr_id",     false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ctrt_ofc_cd",    false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "por_cd",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "pol_cd",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "pod_cd",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "del_cd",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "chg_cd",         false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "curr_cd",        false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "chg_amt",        false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "svc_scp_cd",     false, "", dfNone, 0, false, true);
        		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "sc_no",          false, "", dfNone, 0, false, true);

        		CountPosition = 1;
        		}
        		break;                

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

          case IBSEARCH:      //조회
					
			sheetObj.WaitImageVisible = false;
    		ComOpenWait(true);
    										
	    	formObj.f_cmd.value = SEARCH;   
	    	sheetObj.DoSearch("ESM_BKG_1175GS.do",FormQueryString(formObj));
	    	
	    	ComOpenWait(false);	    	
          break;
        }
    }
    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
/*  	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
  		var formObj = document.form;
  		
  		with(sheetObj){
  			if (RowCount > 0){
			    SumText(0, "seq") = "";
				SumText(0, "cust_nm") = "TOTAL";
				if(SumValue(0,"load") > 0){
					SumValue(0,"cmpb") = CutDecimalPoint(SumValue(0,"cm") /SumValue(0,"load"),0) ;
				}
  			}
  		}
  	}*/	


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
    	
    	if(ComGetObjValue(formObj.charge_cd) == ""){
    		ComShowCodeMessage("BKG00104","Charge");
    		return false;
    	}

    	if(ComGetObjValue(formObj.fr_dt) == ""){
    		ComShowCodeMessage("BKG00499");
    		return false;
    	}
    	if(ComGetObjValue(formObj.to_dt) == ""){
    		ComShowCodeMessage("BKG00499");
    		return false;
    	}
     	
    	if (!ComIsNull(formObj.fr_dt) 
      			&& !ComIsNull(formObj.to_dt) 
      			&& ComGetDaysBetween(formObj.fr_dt.value, formObj.to_dt.value) > 31){
       		 
    			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
    			return false;
    		}

    	return true;
    }
    
    
	/* 개발자 작업  끝 */
    
    
    