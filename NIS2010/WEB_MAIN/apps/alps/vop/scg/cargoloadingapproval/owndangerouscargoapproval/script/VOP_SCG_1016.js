/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_1016.js
*@FileTitle : Application Request & Approval Status - Awkward
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.07.01 이도형
* 1.0 Creation
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
     * @class vop_scg_1016 : vop_scg_1016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_1016() {
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
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];

    	/*******************************************************/
    	var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {

	 			case "btn_Retrieve":
	 				doActionIBSheet(sheetObject,document.form,IBSEARCH);
	 				break;
					
	 			case "btn_Save":
	 				doActionIBSheet(sheetObject,document.form,IBSAVE);
	 				break;
				
 				case "btn_DownExcel":
 					sheetObject.Down2Excel();
 					break;

		        case "btn_Close":
		        	window.close();
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

    	 for(i=0;i<sheetObjects.length;i++){
    		 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
    	 }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
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
    				style.height = 260;
          			//전체 너비 설정
          			SheetWidth = mainTable.clientWidth;

          			//Host정보 설정[필수][HostIp, Port, PagePath]
          			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

          			//전체Merge 종류 [선택, Default msNone]
          			MergeSheet = msPrevColumnMerge + msHeaderOnly;

          			//전체Edit 허용 여부 [선택, Default false]
          			Editable = false;

          			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
          			InitRowInfo( 2, 1, 3, 100);

          			var HeadTitle  = "Route\nSeq|APVL\nSeq.|Lane|VVD CD|VVD CD|VVD CD|POL|POD|BKG No.|Special\nType|CNTR\nSeq.|Requested|Requested|";
                     	HeadTitle += "Requested|Requested|Approval|Approval|Approval|Reject\nCode|Remark(s)|APVL\nRef. No.|";
                     	HeadTitle += "TPSZ|Commodity|Over All (cm)|Over All (cm)|Over All (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Post\nExtd|Gross\nWeight|Gross\nWeight|Void\n(FEU)|bkg status||||||";

                    var HeadTitle1  = "Route\nSeq|APVL\nSeq.|Lane| | | |POL|POD|BKG No.|Special\nType|CNTR\nSeq.| |B.OFC|";
                    	HeadTitle1 += "DT(GMT)|By| |DT(GMT)|By|Reject\nCode|Remark(s)|APVL\nRef. No.|";
                    	HeadTitle1 += "TPSZ|Commodity|L|W|H|FWD|AFT|Left|Right|Height|Post\nExtd|Weight|UOM|Void\n(FEU)|bkg status||||||";

           			var headCount = ComCountHeadTitle(HeadTitle);

         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(headCount, 8, 0, false);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(true, true, false, true, false, false)

         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);
         			InitHeadRow(1, HeadTitle1, true);

         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         			InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,	"vsl_pre_pst_nm",		false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		35,	daCenter,	true,	"spcl_cgo_rqst_seq",	false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		35,	daCenter,	true,	"slan_cd",				false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,	"vsl_cd",				false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,	"skd_voy_no",			false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		20,	daCenter,	true,	"skd_dir_cd",			false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		45,	daCenter,	true,	"pol_cd",				false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		45,	daCenter,	true,	"pod_cd",				false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,	"bkg_no",				false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"spcl_cgo_cate_cd",		false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,	"awk_cgo_seq",			false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,	"rqst_auth_cd",			false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		65,	daCenter,	true,	"rqst_ofc_cd",			false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		65,	daCenter,	true,	"rqst_gdt",				false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		65,	daCenter,	true,	"rqst_usr_id",			false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,	"spcl_cgo_auth_cd",		false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		65,	daCenter,	true,	"auth_gdt",				false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"auth_usr_id",			false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"spcl_cgo_auth_rjct_cd",false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		120,daLeft,		true,	"spcl_cgo_auth_rmk",	false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		100,daLeft,		true,	"apro_ref_no",			false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd",			false,	"",	dfNone,		0,	false	);
         			InitDataProperty(0, cnt++ , dtData,		150,daLeft,		true,	"cmdt_nm",				false,	"",	dfNone,		0,	false	);
         			InitDataProperty(0, cnt++ , dtData,     50, daRight,  	true,   "ttl_dim_len",			false,  "", dfNumber,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,     50, daRight,  	true,   "ttl_dim_wdt",			false,  "", dfNumber,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,     50, daRight,  	true,   "ttl_dim_hgt",			false,  "", dfNumber,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,     50, daRight,  	true,   "ovr_fwrd_len",			false,  "", dfNullInteger,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,     50, daRight,  	true,   "ovr_bkwd_len",			false,  "", dfNullInteger,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,     50, daRight, 	true,   "ovr_lf_len",			false,  "", dfNullInteger,	0,	false	); 
         			InitDataProperty(0, cnt++ , dtData,     50, daRight,  	true,   "ovr_rt_len",			false,  "", dfNullInteger,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,     50, daRight,  	true,   "ovr_hgt",				false,  "", dfNullInteger,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,     50, daRight,  	true,   "xtd_ovr_qty",			false,  "", dfNullInteger,  1,	false	);
         			InitDataProperty(0, cnt++ , dtData,     80, daRight,  	true,   "grs_wgt",				false,  "", dfFloat,	3,	false	);
         			InitDataProperty(0, cnt++ , dtData,		30, daCenter,	true,	"wgt_ut_cd",			false,	"",	dfNone,     0,	false	);
         			InitDataProperty(0, cnt++ , dtData,     50, daCenter,  true,    "ovr_void_slt_qty",     false,	"",	dfFloat,	1,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,	true,	"bkg_sts_cd",			false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,	true,	"lst_rqst_dat_flg",		false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,	true,	"spcl_cgo_apro_rqst_seq",		false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,	true,	"vsl_pre_pst_cd",		false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,	true,	"vsl_seq",				false,	"",	dfNone);
         			InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,	true,	"spcl_cgo_auth_seq",	false,	"",	dfNone);
     	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,true,	"ibflag");
 			
         			HeadRowHeight = 20;
          			SetMergeCell(0, 3, 2, 3);
    	 			SelectHighLight = false; 	// HighLight를 표시하지 않는다.

          			//WordWrap = true;
                }
         		break;
     	}
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {

         	case IBSEARCH:      //조회
         		if(validateForm(sheetObj,formObj,sAction))
         			formObj.f_cmd.value = SEARCH;
         			sheetObj.DoSearch("VOP_SCG_1016GS.do", FormQueryString(formObj));
    				setBkgStatus(sheetObj);
         			break; 			

         	case IBSAVE:        //저장
				 if(!validateForm(sheetObj,formObj,sAction))return;
				 var sParam = ComGetSaveString(sheetObj);
     			 if (sParam == "") return;
				 if(!ComShowCodeConfirm('SCG50001', 'data')) return;
				 formObj.f_cmd.value = MULTI;
				 sheetObj.DoSave("VOP_SCG_1015GS.do", FormQueryString(formObj), '-1', false);
				 break;
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }

     function setBkgStatus(sheetObj)
     {
     	with(sheetObj)
     	{
     		if (CellText(sheetObj.LastRow, "bkg_sts_cd") == "X") {
	     		document.getElementById("bkgStsDesc").style.color = "red";
	     		document.getElementById("bkgStsDesc").innerHTML = "Booking Cancelled";
     		}     		
     	}    	
     }

     function setAuthStat(sheetObj, row)
     {
     	with(sheetObj)
     	{
     		
     		var auth = CellText(row, "spcl_cgo_auth_cd").substring(0,1);
     		CellFont("FontBold", row, "spcl_cgo_auth_cd") = true;
			switch(auth)
			{
				case "R":
					CellFontColor(row, "spcl_cgo_auth_cd") = RgbColor(255, 134, 43);
					break;
					
				case "Y":
					CellFontColor(row, "spcl_cgo_auth_cd") = RgbColor(77, 150, 75);
					break;
					
				case "N":
					CellFontColor(row, "spcl_cgo_auth_cd") = RgbColor(255, 0, 0);
					break;
					
				case "P":
					CellFontColor(row, "spcl_cgo_auth_cd") = RgbColor(38, 99, 224);
					break;
			}
			
     		CellFont("FontBold", row, "rqst_auth_cd") = true;
			CellFontColor(row, "rqst_auth_cd") = RgbColor(255, 134, 43);
			
     		var auth = CellText(row, "spcl_cgo_auth_rjct_cd");
//			switch(auth)
//			{
//				case "AAA":
//					CellFontColor(row, "spcl_cgo_auth_rjct_cd") = RgbColor(255, 0, 0);
//					break;
//			}

     	}    	
     }

     function sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 var j = 0;
    		 var k = 0;
    		 var maxSeq = CellValue(LastRow, "spcl_cgo_rqst_seq");
    		 var findSeq = FindText("spcl_cgo_rqst_seq", maxSeq);
    		 var nextSeq = findSeq;
    		 var rowNumIdx = 22; // Row Number 를 저장해 두는 Array 상의 Index. 비교 대상 컬럼이 늘어나면 바뀌어야 한다. 2011.03.02
    		 var arrBefData = new Array();
    		 var arrAftData = new Array();
    		 
    		 for (var i = LastRow; i >= headerRows; i --)
//    		 for (var i = 2; i <= LastRow; i ++)
    		 {
    			 setAuthStat(sheetObj, i);
    			 if (headerRows != nextSeq && CellValue(i, "spcl_cgo_rqst_seq") == maxSeq) {
    				 arrAftData[k] = new Array();
    				 arrAftData[k][0] = CellValue(i, "cntr_tpsz_cd");
    				 arrAftData[k][1] = CellValue(i, "cmdt_nm");
    				 arrAftData[k][2] = CellValue(i, "ttl_dim_len");
    				 arrAftData[k][3] = CellValue(i, "ttl_dim_wdt");
    				 arrAftData[k][4] = CellValue(i, "ttl_dim_hgt");
    				 arrAftData[k][5] = CellValue(i, "ovr_fwrd_len");
    				 arrAftData[k][6] = CellValue(i, "ovr_bkwd_len");
    				 arrAftData[k][7] = CellValue(i, "ovr_lf_len");
    				 arrAftData[k][8] = CellValue(i, "ovr_rt_len");
    				 arrAftData[k][9] = CellValue(i, "ovr_hgt");
    				 arrAftData[k][10] = CellValue(i, "xtd_ovr_qty");
    				 arrAftData[k][11] = CellValue(i, "grs_wgt");
    				 arrAftData[k][12] = CellValue(i, "ovr_void_slt_qty");
    				 arrAftData[k][13] = CellValue(i, "awk_cgo_seq");
    				 // Lane, VVD, POL, POD 추가 . 2011.03.07    				 
    				 arrAftData[k][14] = CellValue(i, "slan_cd");
    				 arrAftData[k][15] = CellValue(i, "vsl_cd");
    				 arrAftData[k][16] = CellValue(i, "skd_voy_no");
    				 arrAftData[k][17] = CellValue(i, "skd_dir_cd");
    				 arrAftData[k][18] = CellValue(i, "pol_cd");
    				 arrAftData[k][19] = CellValue(i, "pod_cd"); 
    				 // 비교 대상 컬럼 ( VSL_PRE_PST_CD, VSL_SEQ ) 추가.2011.03.08
    				 arrAftData[k][20] = CellValue(i, "vsl_pre_pst_cd");
    				 arrAftData[k][21] = CellValue(i, "vsl_seq");    				     				 
    				 
    				 arrAftData[k][rowNumIdx] = i;
    				 k++;
    			 }
    			 if (CellValue(findSeq-1, "awk_cgo_seq") == "") {
    				 findSeq--;
    			 }
    			 if (headerRows != nextSeq && CellValue(findSeq-1, "spcl_cgo_rqst_seq") == CellValue(i, "spcl_cgo_rqst_seq")) {
    				 arrBefData[j] = new Array();
    				 arrBefData[j][0] = CellValue(i, "cntr_tpsz_cd");
    				 arrBefData[j][1] = CellValue(i, "cmdt_nm");
    				 arrBefData[j][2] = CellValue(i, "ttl_dim_len");
    				 arrBefData[j][3] = CellValue(i, "ttl_dim_wdt");
    				 arrBefData[j][4] = CellValue(i, "ttl_dim_hgt");
    				 arrBefData[j][5] = CellValue(i, "ovr_fwrd_len");
    				 arrBefData[j][6] = CellValue(i, "ovr_bkwd_len");
    				 arrBefData[j][7] = CellValue(i, "ovr_lf_len");
    				 arrBefData[j][8] = CellValue(i, "ovr_rt_len");
    				 arrBefData[j][9] = CellValue(i, "ovr_hgt");
    				 arrBefData[j][10] = CellValue(i, "xtd_ovr_qty");
    				 arrBefData[j][11] = CellValue(i, "grs_wgt");
    				 arrBefData[j][12] = CellValue(i, "ovr_void_slt_qty");
    				 arrBefData[j][13] = CellValue(i, "awk_cgo_seq");
    				 arrBefData[j][14] = CellValue(i, "slan_cd");
    				 arrBefData[j][15] = CellValue(i, "vsl_cd");
    				 arrBefData[j][16] = CellValue(i, "skd_voy_no");
    				 arrBefData[j][17] = CellValue(i, "skd_dir_cd");
    				 arrBefData[j][18] = CellValue(i, "pol_cd");
    				 arrBefData[j][19] = CellValue(i, "pod_cd");
    				 arrBefData[j][20] = CellValue(i, "vsl_pre_pst_cd");
    				 arrBefData[j][21] = CellValue(i, "vsl_seq");
    				 
    				 j++;
    			 }
    		 }

    		 for (var x = 0; x <= j-1; x++)
    		 {
        		 for (var z = 0; z <= k-1; z++)
        		 {
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][0] != arrAftData[z][0]) CellFontColor(arrAftData[z][rowNumIdx], "cntr_tpsz_cd") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][1] != arrAftData[z][1]) CellFontColor(arrAftData[z][rowNumIdx], "cmdt_nm") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][2] != arrAftData[z][2]) CellFontColor(arrAftData[z][rowNumIdx], "ttl_dim_len") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][3] != arrAftData[z][3]) CellFontColor(arrAftData[z][rowNumIdx], "ttl_dim_wdt") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][4] != arrAftData[z][4]) CellFontColor(arrAftData[z][rowNumIdx], "ttl_dim_hgt") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][5] != arrAftData[z][5]) CellFontColor(arrAftData[z][rowNumIdx], "ovr_fwrd_len") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][6] != arrAftData[z][6]) CellFontColor(arrAftData[z][rowNumIdx], "ovr_bkwd_len") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][7] != arrAftData[z][7]) CellFontColor(arrAftData[z][rowNumIdx], "ovr_lf_len") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][8] != arrAftData[z][8]) CellFontColor(arrAftData[z][rowNumIdx], "ovr_rt_len") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][9] != arrAftData[z][9]) CellFontColor(arrAftData[z][rowNumIdx], "ovr_hgt") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][10] != arrAftData[z][10]) CellFontColor(arrAftData[z][rowNumIdx], "xtd_ovr_qty") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][11] != arrAftData[z][11]) CellFontColor(arrAftData[z][rowNumIdx], "grs_wgt") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][12] != arrAftData[z][12]) CellFontColor(arrAftData[z][rowNumIdx], "ovr_void_slt_qty") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][14] != arrAftData[z][14]) CellFontColor(arrAftData[z][rowNumIdx], "slan_cd") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][15] != arrAftData[z][15]) CellFontColor(arrAftData[z][rowNumIdx], "vsl_cd") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][16] != arrAftData[z][16]) CellFontColor(arrAftData[z][rowNumIdx], "skd_voy_no") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][17] != arrAftData[z][17]) CellFontColor(arrAftData[z][rowNumIdx], "skd_dir_cd") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][18] != arrAftData[z][18]) CellFontColor(arrAftData[z][rowNumIdx], "pol_cd") = RgbColor(255, 0, 0);
        			 if (arrBefData[x][13] == arrAftData[z][13] && arrBefData[x][20] == arrAftData[z][20] && arrBefData[x][21] == arrAftData[z][21] && arrBefData[x][19] != arrAftData[z][19]) CellFontColor(arrAftData[z][rowNumIdx], "pod_cd") = RgbColor(255, 0, 0);
        			 
        		 }
    		 }
    	 }
     }     

     function sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
    		 	case "spcl_cgo_auth_rmk":
    		 		if (CellText(Row, "spcl_cgo_auth_rmk") != "") {
    		 			ComShowMemoPad(sheetObj, Row, Col, true, 200, 100);
    		 		}
    		 		break;
    		 	case "apro_ref_no":
    		 		if (CellText(Row, "lst_rqst_dat_flg") != "Y" && CellText(Row, "apro_ref_no") != "") {
    		 			ComShowMemoPad(sheetObj, Row, Col, true, 200, 80, 50);
    		 		}else if (CellText(Row, "lst_rqst_dat_flg") == "Y" && CellText(Row, "spcl_cgo_auth_cd") == "Y") {
    		 			ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
    		 		}
    		 		break;
    		 }
    	 }
     }

	/* 개발자 작업  끝 */