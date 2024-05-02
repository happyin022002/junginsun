/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0234.js
 *@FileTitle : Total Loss Detail Pop Up
 *Open Issues :
 *Change history :
*@LastModifyDate : 2010.01.11 
*@LastModifier : 권영법	 
*@LastVersion : 1.0 
* 2010.01.11 권영법 
 * 1.0 Creation    
 * --------------------------------------------------------
 * 2012.05.02 신혜정 [CHM-201217379] Disposal 리스트내 buyer Code, buyer name 항목 추가        
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
 * @class EES_MNR_0234 : EES_MNR_0234 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MNR_0234() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm; 
}
 
/* ********* General Functions ************* */
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var comboObjects = new Array();
	var comboCnt = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	//파일업로드를 사용하기 위한 
	var uploadObjects = new Array();
	var uploadCnt = 0;
	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq = "";
	//History Seq 저장변수
	var historyMnrStsRefNo = ""; 
	var sSaveRtnXml = "";
	var nowLoad = 0;
	//현제 조회중인 정보
	var currTtlLssNo = ""; 
	var currTtlLssDtlSeq = "";     
	
	//본사코드
	var HOOfc = "";	
	
	//메세지 표시용   
	var actionType = "";
	//현재구동여부
	var nowLoad=0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];
		var sheetObject6 = sheetObjects[5];
		var sheetObject7 = sheetObjects[6];
		var sheetObject8 = sheetObjects[7];
		var sheetObject9 = sheetObjects[8];
		var sheetObject10 = sheetObjects[9];  
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
				switch(srcName) {
					case "btn_Close":
						window.close();
						break;


					/** (Tab) 3rd Party (S) **/
					case "btn_t2InvoicePreview":
						if(sheetObjects[3].RowCount>0)
						{
							var row=sheetObjects[3].SelectRow;
							var rdParam ='/rv ttl_lss_no[' + formObject.ttl_lss_no.value + '] ';
							    rdParam +=   'inv_no[' + sheetObjects[3].CellValue(row,"inv_no") + '] ';
							    //payer type: S=Service Provide,C=Customer,O=Res Office,N=None
								rdParam +=   'payer_code[' + sheetObjects[3].CellValue(row,"payer_code") + '] ';
								rdParam +=   'curr_cd[' + sheetObjects[3].CellValue(row,"curr_cd") + '] ';
								rdParam +=   'rqst_ofc_cd[' + formObject.rqst_ofc_cd.value + '] ';
								rdParam +=   'user_ofc_cd[' + formObject.self_ofc.value + '] ';
							formObject.com_mrdPath.value = "apps/alps/ees/mnr/operationmanage/totallossmgt/report/EES_MNR_0186.mrd";
							formObject.com_mrdArguments.value =	rdParam;
							formObject.com_mrdBodyTitle.value = "TotalLoss Invoice"; 
							ComOpenRDPopup();  
						}
						break;
					/** (Tab) 3rd Party (E) **/

            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
    			ComFuncErrMsg(e); 
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//버튼 설정
    	MnrWaitControl(true);
    	nowLoad=1;
		//Axon이벤트 초기화
		initControl();

		//IBMultiCombo 초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }

    	// IBSheet 초기화
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // IBTab 초기화
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }

		//파일업로드 초기화
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do"); 
		
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
    }

  	/**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
	    var cnt  = 0 ;
	    var formObject = document.form
	    switch(comboNo) {
	    	case 1: 
			case 2:
	    	case 3: 
	    	case 4: 
	            with (comboObj) { 
			       SetColAlign("left");         
				   DropHeight = 160;  
		        }
	            break;
	     } 
	}
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "sheet1":
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 0;
	                //전체 너비 설정	
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 6, 100);
	
					var HeadTitle1 = "||||||||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_no");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"rqst_ofc_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"rqst_dt");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_sts_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_rsn_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_dtl_rsn_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_dt");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"apro_ofc_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"file_seq");	                
	                InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"mnr_sts_ref_no");	                
	                InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"respb_ofc_cd");	                
	                InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"respb_ofc_nm");
	                InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"ttl_lss_cfm_dt");

	                CountPosition = 0;
				}
	            break;
			case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0; 
                    //전체 너비 설정 
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly; 

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false; 

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 6, 100);
						
					var HeadTitle1 = "|Seq.|TTL No.|REQ OFC|REQ User|REQ DT|Status|Main Reason|Sub Reason|TTL DT|APP OFC|Responsible\nOFC|D.V Exnpense|D.V Exnpense|D.V Exnpense|D.V Exnpense|3rd Party|3rd Party|Disposal|Disposal|Scrapping|Scrapping|Insurance|Insurance";
					var HeadTitle2 = "|Seq.|TTL No.|REQ OFC|REQ User|REQ DT|Status|Main Reason|Sub Reason|TTL DT|APP OFC|Responsible\nOFC|EQ Q'ty|Expense|Recovery|Balance|EQ Q'ty|Amount|EQ Q'ty|Amount|EQ Q'ty|Amount|EQ Q'ty|Amount";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 6, 0, 0, true);
						
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);  
                    InitHeadRow(1, HeadTitle2, true);  

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++,  dtHiddenStatus,		 	0,      daCenter,  	false,  	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,       			30,    	daCenter,  	true,  		"Seq",     			false,  "",    	dfNone     );      
                    InitDataProperty(0, cnt++ , dtData,					108,	daCenter,	true,		"ttl_lss_no",		false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					52,		daCenter,	true,		"rqst_ofc_cd",		false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					73,		daCenter,	true,		"cre_usr_id",		false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					64,		daCenter,	true,		"rqst_dt",			false,	"",		dfDateYmd,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,				100,	daCenter,	true,		"ttl_lss_sts_cd",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,				80,		daCenter,	true,		"ttl_lss_rsn_cd",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,		"ttl_lss_dtl_rsn_nm",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					64,		daCenter,	true,		"ttl_lss_dt",		false,	"",		dfDateYmd,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					52,		daCenter,	true,		"apro_ofc_cd",		false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,			75,		daCenter,	true,		"respb_ofc_cd",		false,	"",		dfNone,			0,	true,	true);
                    
					//반복부 
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		"dv_eq_qty",		false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"dv_exp",			false,	"",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"dv_recovery",		false,	"|tp_exp|+|ds_exp|+|sc_exp|+|ir_exp|",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"dv_balance",		false,	"|dv_exp|-|dv_recovery|",		dfFloat,		2,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		"tp_eq_qty",		false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"tp_exp",			false,	"",		dfFloat,		2,	false,	false);
					 
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		"ds_eq_qty",		false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"ds_exp",			false,	"",		dfFloat,		2,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		"sc_eq_qty",		false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"sc_exp",			false,	"",		dfFloat,		2,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		"ir_eq_qty",		false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"ir_exp",			false,	"",		dfFloat,		2,	false,	false);
						
					//히든 데이타 	
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"mnr_sts_ref_no",    false,      "",     	dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"ttl_lss_dtl_rsn_cd",    false,      "",     	dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"ttl_lss_rmk",    false,      "",     	dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"file_seq",    false,      "",     	dfNone,    		0,      true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"ttl_lss_cfm_dt",		false,	"",		dfDateYmd,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"ttl_lss_cfm_id",		false,	"",		dfNone,			0,	false,	false);
										
					InitDataValid(0,  "respb_ofc_cd", vtEngUpOther,"0123456789");  

					CountPosition = 0;

				}
                break;
					
            case "t1sheet1":
                with (sheetObj) { 
                    // 높이 설정
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]  
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);
 
					var HeadTitle1 = "|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Lessor|Payer Code|Payer Name|Invoice No.|CURR|Pay Amount|Confirm Flg|EQ Status|Close Type|Close Date|Remark";
					var headCount = ComCountHeadTitle(HeadTitle1);
						
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 18, 0, 0, true);
						
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",			true,	"",	dfNone,			0,	false,	false,	14);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"lstm_cd",				true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",		true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			95,		daRight,	true,	"dpc_val_amt",			true,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtData,			145,	daLeft,		true,	"lessor_nm",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		     85,	daCenter,	true,	"payer_code",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,	"payer_name",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			140,	daLeft,	    true,	"inv_no",				false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",				true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,	"ttl_lss_bil_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtCheckBox,		90,		daCenter,	true,	"ttl_lss_cfm_flg",		false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtCombo,		60,		daLeft,		true,	"ttl_lss_dtl_sts_cd",	false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtCombo,		80,		daLeft,		true,	"ttl_lss_cmpl_cd",		false,	"",	dfNone,			0,	true,	true);	
					InitDataProperty(0, cnt++ , dtData,			85, 	daCenter,  	true,   "ttl_lss_cmpl_dt",     	false,   "", dfDateYmd,		0,	false,	false);	
					InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",				false,	"",	dfNone,			0,	true,	true);
                    //Hidden	
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		true,	"ttl_lss_n3pty_tp_cd",	true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_cnt_cd");
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"n3pty_no",				false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_expn_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_incm_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",			false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtHidden,		65,		daLeft,		true,	"bank_nm",				false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		65,		daLeft,		true,	"bank_acct_no",			false,	"",	dfNone,			0,	true,	true);
                	InitDataProperty(0, cnt++ , dtHidden,		85,		daCenter,	true,	"respb_ofc_cd",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",		false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"inv_rgst_no");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"pay_inv_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"csr_no",				false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"mnr_swift_no",				false,	"",	dfNone,			0,	true,	true,	20);

                    //데이터 Validation
					InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");  
					
					MessageText("Sum") = "Total";
					CountPosition = 0;
				}
                break;

            case "t2sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Payer Type|Responsible\nOFC|Payer Code|Payer Name|CURR|3rd Amount|TPB No.|Bank Name|Bank Account|Swift Code|Remark";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",			true,	"",	dfNone,			0,	false,	false,	14);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"lstm_cd",				true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",		true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"dpc_val_amt",			true,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtCombo,		100,	daLeft,		true,	"ttl_lss_n3pty_tp_cd",	true,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0, cnt++ , dtPopupEdit,	85,		daCenter,	true,	"respb_ofc_cd",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtPopup,		85,		daCenter,	true,	"payer_code",			false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,	"payer_name",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",				true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,	true,	"ttl_lss_bil_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13); 
                    InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"n3pty_no",				false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,			75,		daLeft,		true,	"bank_nm",				false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			85,		daLeft,		true,	"bank_acct_no",			false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			85,		daLeft,		true,	"mnr_swift_no",			false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",				false,	"",	dfNone,			0,	true,	true);
    				//Hidden
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_cnt_cd");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"csr_no");
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_expn_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_incm_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"disp_no",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"inv_no",				true,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",		false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",		false,	"",	dfNone,			0,	true,	true,	20);

                    //데이터 Validation
    				InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");  
    				InitDataValid(0,  "respb_ofc_cd", vtEngUpOther,"0123456789"); 
					InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "mnr_swift_no", vtEngUpOther,"0123456789-");
					MessageText("Sum") = "Total";
					ColHidden("dpc_val_amt")=true;
    				ShowButtonImage = 0;
					CountPosition = 0;
				}
                break;
                
            case "t3sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|Buyer Code|Buyer Name|Disposal No.|CURR|Disposal AMT|Disposal Plan AMT|Remark";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			25,		daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",		true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",		true,	"",	dfNone,			0,	false,	false,	14);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",		true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"lstm_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",	true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtPopup,		85,		daCenter,	true,	"buyer_code",		false,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,	"buyer_name",		false,	"",	dfNone,			0,	false,	false);                    
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"disp_no",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",			false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,	true,	"ttl_lss_bil_amt",	false,	"",	dfNullFloat,	2,	false,	false,	13);
    				InitDataProperty(0, cnt++ , dtAutoSumEx,	120,	daRight,	true,	"ttl_lss_incm_amt",	false,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",			false,	"",	dfNone,			0,	true,	true);
    				//Hidden
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_expn_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_incm_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"inv_no",				true,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		75,		daRight,	true,	"dpc_val_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",		false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",		false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"csr_no");
					//데이터 Validation
					InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");  
					MessageText("Sum") = "Total";
					
					ShowButtonImage = 0;					
					
					CountPosition = 0;
				}
                break;

            case "t4sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122; 
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|CURR|CSR No|Scrapping Income AMT|Scrapping Cost AMT|Remark";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false] 
                    InitColumnInfo(headCount + 8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			25,		daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",		true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",		true,	"",	dfNone,			0,	false,	false,	14);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",		true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"lstm_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",	true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",			true,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"csr_no",			false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,			160,	daRight,	true,	"ttl_lss_incm_amt",	false,	"",	dfNullFloat,	2,	true,	true,	13);
					InitDataProperty(0, cnt++ , dtAutoSumEx,	150,	daRight,	true,	"ttl_lss_expn_amt",	false,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",			false,	"",	dfNone,			0,	true,	true);
    				//Hidden
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
    				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"inv_no",				true,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		75,		daRight,	true,	"dpc_val_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",		false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",		false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		75,		daRight,	true,	"ttl_lss_bil_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);

					//데이터 Validation
					InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");  
					MessageText("Sum") = "Total";
					CountPosition = 0;
				}
                break;
                
            case "t5sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Club Ref No|CURR|Insurance Co.|Request AMT|Remark";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
	
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			25,	daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtCombo,		70,	daLeft,		true,	"eq_knd_cd",		true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			95,	daCenter,	true,	"rqst_eq_no",		true,	"",	dfNone,			0,	false,	false,	14);
                    InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"eq_tpsz_cd",		true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"lstm_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"ttl_lss_yd_cd",	true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			75,	daRight,	true,	"dpc_val_amt",		false,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"inv_no",			true,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtCombo,		50,	daCenter,	true,	"curr_cd",			true,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0, cnt++ , dtCombo,		90,	daCenter,	true,	"ttl_lss_plc_nm",	false,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0, cnt++ , dtData,			95,	daRight,	true,	"ttl_lss_expn_amt",	true,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtData,			50,	daLeft,		true,	"dtl_rmk",			false,	"",	dfNone,			0,	true,	true);
                    //Hidden
                    InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"ttl_lss_no");
                    InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"ttl_lss_dtl_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"mnr_inv_tp_cd");
    				InitDataProperty(0, cnt++ , dtHidden,			90,	daCenter,	true,	"csr_no");
					//데이터 Validation
					InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "inv_no", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");  
					MessageText("Sum") = "Total";
					ColHidden("dpc_val_amt")=true;
					CountPosition = 0;
				}
                break;
            
			case "sheet3":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Seq.|Type|Date|Curr.|Amount|Pay Method|CSR No.|Check No.|Inv No.|EQ No|Evidence No|Remark(s)";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 6, 0, 0, true); 

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true); 
					
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,		0,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,				30,	daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtData,				50, daCenter,  	true,   "type",     			false,  "", dfNone     ,		0,			false,		false);   
					InitDataProperty(0, cnt++ , dtPopupEditFormat,	82, daCenter,  	true,   "clt_dt",     			false,  "", dfDateYmd     ,		0,			true,		true);   
                    InitDataProperty(0, cnt++ , dtCombo,			50,	daCenter,	true,	"curr_cd",				false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,				75,	daRight,	true,	"clt_amt",				false,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtCombo,			80,	daLeft,		true,	"inv_pay_mzd_cd",		false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	true,	"csr_no",				false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	true,	"ar_chk_no",			false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	true,	"inv_no",				false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	true,	"rqst_eq_no",			false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	true,	"evidence",			false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,				100,daLeft,		true,	"ttl_lss_clt_rmk",		false,	"",	dfNone,			0,	true,	true);
                    //Hidden
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"ttl_lss_no"); 
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"ttl_lss_dtl_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"ttl_lss_clt_seq ");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"clt_stl_flg");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"clt_ofc_cd");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"chk_trns_no"); 
					//데이터 Validation
					InitDataValid(0,  "ar_chk_no", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "csr_no", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "inv_no", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789"); 
						
					CountPosition = 0;
					
					PopupImage  =  "/hanjin/img/btns_calendar.gif";
            		ShowButtonImage = 2;
					
					//SELECT 로우 배경색	 	      
					SelectionMode = smSelectionRow;    
					SelectHighLight = false;             
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
					EditableColorDiff = true;
				}
                break;
				    
			case "sheet4":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 112;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

            		var HeadTitle1 = "|Seq|Date|Remark(s)|Creation Office|Creation User";
    				var headCount = ComCountHeadTitle(HeadTitle1);
    	
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount+3, 0, 0, true);
    	
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, true, true, false,false)
    	
    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);
    	
    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,	"seq");
    				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"mnr_sts_dt",	false,	"",	dfDateYmd,	0,	true,	true);
    				InitDataProperty(0, cnt++ , dtData,			300,	daLeft,		true,	"mnr_sts_rmk",	false,	"",	dfNone,		0,	true,	true);
    				InitDataProperty(0, cnt++ , dtData,     	100,	daCenter,	true,	"rqst_ofc_cd",	false,	"",	dfNone,  	0,	false,	false);
    				InitDataProperty(0, cnt++ , dtData,			80,	    daCenter,	true,	"cre_usr_id",	false,	"",	dfNone,		0,	false,	false);
    	
    				//Hidden
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_sts_ref_no");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_sts_dtl_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_grp_tp_cd");

                    PopupImage = "/hanjin/img/btns_calendar.gif";
					ShowButtonImage = 2;
					CountPosition = 0;
				}
                break;
                
			case "sheet5":
                with (sheetObj) {
					var prefix = "";   
					
					// 높이 설정
					style.height = 112; 
					// 전체 너비 설정
					//SheetWidth = mainTable.clientWidth;
					SheetWidth = 280;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
							
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;	
						
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 13, 100);
						
					var HeadTitle1 = "|Evidence Attached|Evidence Attached|Evidence Attached";
					var HeadTitle2 = "|Sel|File|Download";
								
					var headCount = ComCountHeadTitle(HeadTitle1);									
						
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true); 
					InitHeadRow(1, HeadTitle2, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	prefix + "del_chk")
					InitDataProperty(0, cnt++ , dtPopup,      	120,	daCenter,  	false,  prefix + "org_file_nm",     true,   "",	dfNone,	0,	false,	true,	50);
					InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,  prefix + "file_dw",   		false,  "", dfNone, 0,  false,	true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,     daCenter,  	false,  prefix + "file_path_nm",	false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,  prefix + "file_path",   	false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	prefix + "file_seq",   		false,  "", dfNone, 0,  true,   true);										
					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  	prefix + "file_dtl_seq",	false,	"",	dfNone,	0,	false,	false);
	 						
					CountPosition = 0;
					
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
					ShowButtonImage = 1;    
				}
                break;
        }
    }

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
    	switch(tabNo) {
    		case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "D.V Expense", -1 );
                    InsertTab( cnt++ , "3rd Party", -1 );
                    InsertTab( cnt++ , "Disposal", -1 );
                    InsertTab( cnt++ , "Scrapping", -1 );
                    InsertTab( cnt++ , "Insurance", -1 );
                }
                break;
         }
    }

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);		//- 변경될때
    }

	/**
	 * IBUpload Object 기본설정
	*/
	function initUpload(uploadObj, uploadNo) {
	   uploadObj.Files = "";
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
		
	/**
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	*/
	function setUploadObject(uploadObj){
	   uploadObjects[uploadCnt++] = uploadObj;
	}
    
	
	function setPopUpParam_Sheet2_COM_ENS_071(array) {
		
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(",");
	    var Row = sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
		sheetObjects[1].CellValue2(Row,"respb_ofc_cd")=arr[3];
		if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) != ""){
			formObj.respb_ofc_cd.value=arr[3];	
			formObj.respb_ofc_nm.value=arr[4];
		}
		
	}  

	function setPopUpParam_COM_ENS_071(array) {
		
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(",");
	
		formObj.respb_ofc_cd.value=arr[3];
		formObj.respb_ofc_nm.value=arr[4];
	    var Row = sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
		sheetObjects[1].CellValue2(Row,"respb_ofc_cd")=formObj.respb_ofc_cd.value;
	}   	
	
	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}	
	
	/**
     * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_focus(){
		ComClearSeparator(event.srcElement);
    }
	
	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
		switch(obj.dataformat) {
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;	
	        	
			case "engup":
	         	if(obj.name == "in_ttl_lss_no"){ 
					ComKeyOnlyAlphabet('uppernum','45|44'); 
				} else {				   
					ComKeyOnlyAlphabet('uppernum');	
				}          
	            break; 
	    } 
	}
	
	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change()
	{	     
		ComChkObjValid(event.srcElement);
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
	
		if ( ComTrim(obj.value) != "" ) 
		{
			switch(obj.name)
			{      
			case "respb_ofc_cd":   
				if(nowLoad != 0) return;
				respb_ofc_cd_Check();
				break;  
			case "ttl_lss_cfm_dt":   
				if(nowLoad != 0) return;
			    var Row = sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
			    sheetObjects[1].CellValue(Row,"ttl_lss_cfm_dt")=formObj.ttl_lss_cfm_dt.value;
				break;  
			}       
		} 
	} 
	 
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;   
		var sheetObj = sheetObjects[nItem + 2];
		if((sheetObj.RowCount - sheetObj.RowCount("D")) > 0){
			var Row = sheetObj.SelectRow; 
			var dtlSeq = sheetObj.CellValue(Row,"ttl_lss_dtl_seq");	
			currTtlLssNo = 		sheetObj.CellValue(Row,"ttl_lss_no");	
			currTtlLssDtlSeq =	sheetObj.CellValue(Row,"ttl_lss_dtl_seq");		
			var newSeq = 1;
			for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){  			
				with(sheetObjects[7]){ 
					if(CellValue(x,"ttl_lss_dtl_seq") == dtlSeq){  
						sheetObjects[7].CellValue2(x,"seq") = newSeq++;     	
						sheetObjects[7].RowHidden(x) = false;   
					} else {        
						sheetObjects[7].RowHidden(x) = true;   
					}	 		        	
				}    
			}   
		} else {
			for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){
				sheetObjects[7].RowHidden(x) = true;       
			}	
			currTtlLssNo = "";
			currTtlLssDtlSeq = "";
		}
		
		if(nItem==1)
		{
			ComBtnEnable("btn_t" + (nItem + 1) + "InvoicePreview");
		}else{
			ComBtnDisable("btn_t" + (nItem + 1) + "InvoicePreview");
		}
    	if(document.form.ttl_lss_sts_cd.value=="HE") //상태가 Complete면  
    	{
			ComBtnDisable("btn_Col_Add");
			ComBtnDisable("btn_Col_Delete");
    	}else{
    		if(nItem==0) //DV 탭이 선택될경우
    		{
    			ComBtnDisable("btn_Col_Add");
    			ComBtnDisable("btn_Col_Delete");
    		}else{
    			ComBtnEnable("btn_Col_Add");
    			ComBtnEnable("btn_Col_Delete");
    		}
    	}
    }

	/** 
	 * 조회후 Header 값 설정 및 형식 변경 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;  
		//Header 값 설정
	    var Row = sheetObj.FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);

	    if(Row >0)
	    {
	    	sheetObj.SelectRow=Row;
	    }else{
	    	return false;
	    }
		
		var ttlLssNo		= sheetObj.CellValue(Row, "ttl_lss_no");			//REQ OFC
		var rqstOfcCd		= sheetObj.CellValue(Row, "rqst_ofc_cd");			//REQ OFC
		var respbOfcNm		= sheetObj.CellValue(Row, "respb_ofc_nm");          //Responsible\nOFC NM		
		var rqstDt			= sheetObj.CellValue(Row, "rqst_dt"); 				//REQ DT
		var ttlLssStsCd		= sheetObj.CellValue(Row, "ttl_lss_sts_cd");		//Status
		var ttlLssRsnCd		= sheetObj.CellValue(Row, "ttl_lss_rsn_cd");		//Main Reason
		var ttlLssDtlRsnCd	= sheetObj.CellValue(Row, "ttl_lss_dtl_rsn_cd");	//Sub Reason
		var ttlLssDt		= sheetObj.CellValue(Row, "ttl_lss_dt");			//TLL DT
		var aproOfcCd		= sheetObj.CellValue(Row, "apro_ofc_cd");			//APP OFC
		var fileSeq 		= sheetObj.CellValue(Row, "file_seq");				//File Seq
		var mnrStsRefNo		= sheetObj.CellValue(Row, "mnr_sts_ref_no");		//mnr_sts_ref_no

		formObj.ttl_lss_no.value			= ttlLssNo;			//TTL NO 
		formObj.rqst_ofc_cd.value			= rqstOfcCd;		//REQ OFC
		formObj.respb_ofc_nm.value		    = respbOfcNm;		//Responsible\nOFC NM
		formObj.rqst_dt.value 				= rqstDt; 			//REQ DT
		formObj.ttl_lss_sts_cd.value		= ttlLssStsCd; 		//Status
		formObj.ttl_lss_rsn_cd.value		= ttlLssRsnCd; 		//Main Reason
		formObj.ttl_lss_dtl_rsn_cd.value	= ttlLssDtlRsnCd;	//Sub Reason
		formObj.ttl_lss_dt.value			= ttlLssDt;			//TLL DT
		formObj.apro_ofc_cd.value			= aproOfcCd;		//APP OFC
		formObj.mnr_sts_ref_no.value 		= mnrStsRefNo;   	//히스토리 키  	
		
		//파일 리스트 조회 
		if(fileSeq != "" && fileSeq != null){ 
		
			var fileXml = SearchFileUpload(sheetObjects[1],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[9].LoadSearchXml(fileXml);	
			}
		}
		//History 리스트 조회
		if(mnrStsRefNo != "" && mnrStsRefNo != null){
			historyMnrStsRefNo = mnrStsRefNo;
			var sXml = MnrStatusHistorySearch(sheetObjects[8], mnrStsRefNo);
			sheetObjects[8].LoadSearchXml(sXml);
		}
	}
	
	 
	 
	/** 
	 * 조회후 합계값 설정 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
			document.form.tCollectionTotal.value=sheetObj.ComputeSum('|clt_amt|');
			ComAddSeparator(document.form.tCollectionTotal, "float");
			setCalculateTotalSum()
	}
	
    /**
     * Sheet1관련 프로세스 처리
     * 
     * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
     * @param {Form}formObj 프로세스 처리될 폼오브젝트
     * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	    	// 초기화
	    	case IBCLEAR:
	    		// 버튼 , 프로그레스바 설정 시작
	    		sheetObj.WaitImageVisible = false;
	    		MnrWaitControl(true);
	    					
	    		// 모든 쉬트를 초기화
	    		for (i = 0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}

				
				//쉬트 콤보데이타 조회 및 설정 
				setSheetCombo(sheetObj);
				formObj.reset();
											
				//초기값 설정
				//TLL No
				formObj.ttl_lss_no.value		    = "";  					
				document.form.t1LossTotal.value ="";     //Loss Total 
				document.form.t1RecPlnTotal.value ="";   //Recovery Plan Total 
				document.form.t1BalanceTotal.value ="";  //Balance Total 
				var toDay = ComGetNowInfo("ymd");
				formObj.respb_ofc_cd.readOnly=true;
				formObj.respb_ofc_cd.className="input2";				
							  
				//초기값 설정 
						
				uploadFileSeq = "";
				historyMnrStsRefNo = "";
				
				//본사가 아니고 본부/지점일때
	        	if(HOOfc!=currOfcCd)
	        	{
	        		sheetObjects[1].Editable = false;
	        		
	        	}
	    		// 버튼 , 프로그레스바 설정 끝
	    		MnrWaitControl(false);
				ComBtnDisable("btn_t1InvoicePreview"); //D.V Expense 탭 Invoice Preview Btn disabled
				sheetObj.WaitImageVisible = true;
		    	doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH);	
	    		nowLoad=0;
	    		break;
	    		
        	//조회
            case IBROWSEARCH:      
                if(validateForm(sheetObj,formObj,sAction)) {
    	    		// 모든 쉬트를 초기화
    	    		for (var i = 2; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}

    				formObj.f_cmd.value = SEARCH;      
						
					//다중조회 
					var sXml = sheetObj.GetSearchXml("EES_MNR_0234GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					for(var i = 0; i < arrXml.length; i++){ 
						if(i == 6){   
							var tempStr = arrXml[i];   
							tempStr = tempStr.replace(/<TR>/g,'<TR HIDDEN="TRUE">');
							arrXml[i] = tempStr; 
						}			    
						if(i == 0){
							sheetObjects[0].LoadSearchXml(arrXml[i]);
						} else {	
							sheetObjects[i + 1].LoadSearchXml(arrXml[i]);
						}
					} 
					
					//첫번째 로우 선택 
					tabObjects[0].SelectedIndex = 0;
					if((sheetObj.RowCount - sheetObj.RowCount("D")) > 0){ 
						sheetObjects[2].SelectCell(1,2);
										 		  
						var dtlSeq 	 = sheetObjects[2].CellValue(1,"ttl_lss_dtl_seq");	
						currTtlLssNo = 		sheetObjects[2].CellValue(1,"ttl_lss_no");	
						currTtlLssDtlSeq =	sheetObjects[2].CellValue(1,"ttl_lss_dtl_seq");		
						var newSeq = 1;
						for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){  			
							with(sheetObjects[7]){ 
								if(CellValue(x,"ttl_lss_dtl_seq") == dtlSeq){  
									sheetObjects[7].CellValue2(x,"seq") = newSeq++;     	
									sheetObjects[7].RowHidden(x) = false;   
								} else {         
									sheetObjects[7].RowHidden(x) = true;   
								} 			        	
							} 
						} 
					} else {	 
						for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){
							sheetObjects[7].RowHidden(x) = true;  
						} 						
						currTtlLssNo = "";		
						currTtlLssDtlSeq = "";   
					}	
								
	            }
                break;
				
        }
    }
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        var formObj = document.form;   
		with(formObj){
    		// 조회시 체크
    		if (sAction == IBSEARCH) { 
    			// Dataformat      				
    			if (!ComChkValid(formObj)) {	
    				return false;			
    			}
    		}
        }   
        return true; 
    }

	/**
	 * Loss Total : DV의 Pay Amount의 합계
	 * Recovery Plan Total : 3rd Amount + Disposal Amount + Scrapping Income AMT
	 *                        + Scrapping Cost AMT + Request AMT
	 * Balance Total = Recovery Plan Total - Loss Tota
	 */
	function setCalculateTotalSum(){
	    var tabIndex=tabObjects[0].SelectedIndex + 1;
       var sheetIndex=2;
	    var calFlag=false;
		for(var i=sheetIndex;i<sheetIndex + 5;i++)
		{
			if(sheetObjects[i].RowCount >0)
			{
				calFlag=true;
				break;
			}
		}
		if(calFlag==true)
		{
		    var tLossTotal=0;
		    var thrdAmtTotal=0;
		    var disposalAmtTotal=0;
		    var disposalPlanAmtTotal=0;
		    var scrapIncomeAmtTotal=0;
            var scrapCostAmtTotal=0;
            var requestAmtTotal=0;
         
            for(var i=sheetIndex;i<sheetIndex + 5;i++)
            {
			    if(sheetObjects[i].RowCount >0)
			    {
					for(var j=sheetObjects[i].HeaderRows ;j<=sheetObjects[i].LastRow;j++)
					{
						//삭제 되거나  SEQ가 NULL(0)인 데이타 제외하고 계산
						if(sheetObjects[i].CellValue(j,"ibflag")!="D" && sheetObjects[i].CellValue(j,"seq")!="0")
						{
							if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="DV"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt")!="") 
								tLossTotal+=parseFloat(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
							}else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="TP"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt")!="") 
								thrdAmtTotal+=parseFloat(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
							}else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="DS"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt")!="")  
									disposalAmtTotal+=parseFloat(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
								if(sheetObjects[i].CellValue(j,"ttl_lss_incm_amt")!="")  
									disposalPlanAmtTotal+=parseFloat(sheetObjects[i].CellValue(j,"ttl_lss_incm_amt"));
							}else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="SC"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_incm_amt")!="")  
								scrapIncomeAmtTotal+=parseFloat(sheetObjects[i].CellValue(j,"ttl_lss_incm_amt"));
								if(sheetObjects[i].CellValue(j,"ttl_lss_expn_amt")!="") 
								scrapCostAmtTotal+=parseFloat(sheetObjects[i].CellValue(j,"ttl_lss_expn_amt"));
							}else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="IR"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_expn_amt")!="") 
								requestAmtTotal+=parseFloat(sheetObjects[i].CellValue(j,"ttl_lss_expn_amt"));
							}
						}
					}
			    }
            }
            if(String(tLossTotal).indexOf(".") != -1)
            {
            	var decimalLen=String(tLossTotal).length-String(tLossTotal).indexOf(".")+1;
            	if(decimalLen>2)
            	{
            		tLossTotal=String(tLossTotal).substring(0,String(tLossTotal).indexOf(".")+3);
            	}
            }
			document.form.t1LossTotal.value =tLossTotal;
			ComAddSeparator(document.form.t1LossTotal, "float");
			
		    var tRecPlnTotal=thrdAmtTotal+disposalAmtTotal+disposalPlanAmtTotal+scrapIncomeAmtTotal+scrapCostAmtTotal+requestAmtTotal;
            if(String(tRecPlnTotal).indexOf(".") != -1)
            {
            	var decimalLen=String(tRecPlnTotal).length-String(tRecPlnTotal).indexOf(".")+1;
            	if(decimalLen>2)
            	{
            		tRecPlnTotal=String(tRecPlnTotal).substring(0,String(tRecPlnTotal).indexOf(".")+3);
            	}
            }
		    document.form.t1RecPlnTotal.value =tRecPlnTotal;
			ComAddSeparator(document.form.t1RecPlnTotal, "float");
			
		    var tBalanceTotal=tRecPlnTotal-tLossTotal;
            if(String(tBalanceTotal).indexOf(".") != -1)
            {
            	var decimalLen=String(tBalanceTotal).length-String(tBalanceTotal).indexOf(".")+1;
            	if(decimalLen>2)
            	{
            		tBalanceTotal=String(tBalanceTotal).substring(0,String(tBalanceTotal).indexOf(".")+3);
            	}
            }
			document.form.t1BalanceTotal.value =tBalanceTotal;
			ComAddSeparator(document.form.t1BalanceTotal, "float");
		}
	}		
	
	/**
	 * 쉬트 콤보 데이티 조회 및 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function setSheetCombo(sheetObj) {
		var formObj=document.form;
		//쉬트 조회
		var sCondition = new Array (
			new Array("MdmCurrency","", "COMMON")		//Currency			
			,new Array("MnrGenCd","CD00071", "COMMON")  //Status 이전 CD00042
			,new Array("MnrGenCd","CD00043", "COMMON")  //Payer Type
			,new Array("MnrGenCd","CD00050", "COMMON")  //Total Collection Type
			,new Array("ComIntgCd","CD00809","COMMON")  //Payer Type
			,new Array("MnrGenCd","CD00039", "COMMON")  //Total Loss Status
			,new Array("MnrGenCd","TR", "COMMON")  //Main Reason
			,new Array("MnrGenCd","CD00069", "COMMON")  //Insurance Co
			,new Array("MnrGenCd","CD00072", "COMMON")  //Close Type
			,new Array("MnrGenCd","HOOFC", "COMMON")    //HOOfc Code
			,new Array("MnrGenCd","SELHO","CUSTOM9")	//Eq Kind
		)   
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		//쉬트 설정
		var sheetComboText = "";
		var sheetComboCode = "";
		var sheetComboCodeText = "";
		var sheetComboDefault = "";
		for(var i = 0; i < comboList.length; i++) {				
			//쉬트콤보별 초기화
			sheetComboText = ""; 
			sheetComboCode = ""; 
			sheetComboCodeText = ""; 
			sheetComboDefault = "";   
			for(var j = 0; j < comboList[i].length; j++){
				var tempText = comboList[i][j].split("|");    

				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
				sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";

				if(i==9)
				{
					HOOfc=tempText[0];
				}
								
				if(j == 0){   	
					sheetComboDefault = tempText[0];      	
				}    
			}	    
			//탭별 쉬트 콤보 설정
			for(var k = 1; k < 8; k++) 
			{  
				if(i == 0) {
					if(k != 1)
					{
						sheetObjects[k].InitDataCombo (0, "curr_cd", sheetComboCode, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 1) {
					if(k == 2) {
					    sheetObjects[k].InitDataCombo (0, "ttl_lss_dtl_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 2) { 
					if(k == 3) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_n3pty_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 3) { 
					if(k == 7) {     
						//sheetObjects[k].InitDataCombo (0, "ttl_lss_clt_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}	    	 
				} else if(i == 4) {	
					if(k == 7) {     	
						sheetObjects[k].InitDataCombo (0, "inv_pay_mzd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					} 
				} else if(i == 5) {	
					if(k == 1) {     	
						sheetObjects[k].InitDataCombo (0, "ttl_lss_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					} 	
				} else if(i == 6) {	
					if(k == 1) {     	
						sheetObjects[k].InitDataCombo (0, "ttl_lss_rsn_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					} 	
				} else if(i == 7) {			
					if(k == 6) {     	
						sheetObjects[k].InitDataCombo (0, "ttl_lss_plc_nm", sheetComboText, sheetComboCode ,sheetComboDefault);
					} 
				} else if(i == 8) {			
					if(k == 2) {								     	
						sheetObjects[k].InitDataCombo (0, "ttl_lss_cmpl_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					} 			
				} else if(i == 10){	 	    
					if(k != 1 && k != 7 ) {	
						sheetObjects[k].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}	
				}	
			}								
		}		
	}
 
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/  
	function sheet5_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";  
   		   
        if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
			
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}  


	
	