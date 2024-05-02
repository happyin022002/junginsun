/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0014.js
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.04 이도형
* 1.0 Creation

* History
* 2012.07.06  [CHM-201218537-01] [VOP-SCG] SPCL CGO APVL for Own BKG lane code 입력 방식 변경
* 2012.07.31  [CHM-201219311-01] [SCG] SPCL CGO APVL for Own BKG( 소스 수정)
* 2016.05.09  AMR 일때도 APVL.REF NO는 필수로 변경
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
     * @class vop_scg_0014 : vop_scg_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

function vop_scg_0014() {
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
	var tabIndex = 0;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0; 

    var auth_cd = null;
    var scg_flg = null;
    
    var laneSheetDataRows = 2; // laneSheet의 모든 Row 갯수
	
	var laneSheetLaneCdDataRow1 = 0;
	var laneSheetLaneCdDataRow2 = 1;
	
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var shtCnt = 0;
    	var t1sheet1 = sheetObjects[1];
    	var t2sheet1 = sheetObjects[2];
    	var t3sheet1 = sheetObjects[3];
    	var t4sheet1 = sheetObjects[4];
    	var t5sheet1 = sheetObjects[5];
    	var t6sheet1 = sheetObjects[6];
    	var formObject = document.form;
    	/*******************************************************/

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {
	 			case "btn_SlanCd1": case "btn_SlanCd2": case "btn_SlanCd3": case "btn_SlanCd4": case "btn_SlanCd5": case "btn_SlanCd6": case "btn_SlanCd7": case "btn_SlanCd8": case "btn_SlanCd9":  case "btn_SlanCd10": case "btn_SlanCd11":
	 				onPopupClick(srcName, "Lane");
	 				break;

	 			case "btn_Vessel":
	 				onPopupClick(srcName, "Vessel");
	 				break;

     			case "btn_Retrieve":
     				formObject.retrieve_flg.value = "Y";
     				//Retrieve 버튼 클릭시 Tab 조회 초기화
     				formObject.t0retrieve_flg.value = "N";
     				formObject.t1retrieve_flg.value = "N";
     				formObject.t2retrieve_flg.value = "N";
     				formObject.t3retrieve_flg.value = "N";
     				formObject.t4retrieve_flg.value = "N";
     				formObject.t5retrieve_flg.value = "N";
     				
					doActionIBSheet(sheetObjects[tabIndex+1],document.form,IBSEARCH);

     				break;
     				
     			case "btn_New":
     				if (!validateForm(sheetObjects[tabIndex+1],document.form,IBCLEAR)) return;
     				comboObjects[0].Code = "";
 					clearAll();
     				break;

     			case "btn_Save":
					doActionIBSheet(sheetObjects[tabIndex+1],document.form,IBSAVE);
     				break;
     			
     			case "btn_t1ApplDetails": case "btn_t2ApplDetails": case "btn_t3ApplDetails": case "btn_t4ApplDetails": case "btn_t5ApplDetails": case "btn_t6ApplDetails":
	 				onPopupClick(srcName, srcName.substring(4));
     				break;

//				case "from_eta_flg": 
//					checkPostEta();
//   	                break;	
     				
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
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++] = combo_obj;
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
         for(i=0, k=1;i<sheetObjects.length;i++){
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet(sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
             ComBtnDisable("btn_t"+k+"ApplDetails");
        	 k++;
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }

         //IBMultiCombo초기화
         for(var k = 0; k < comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }
         
     }

     function t1sheet1_OnLoadFinish(sheetObj) {
         //html컨트롤 이벤트초기화
         initControl();
         
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);	//RSO Combo생성
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);	//RJT CD Combo 생성
     }
     
     /**
      * Combo 기본 설정 
      * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
      * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
      */ 
      function initCombo(comboObj, comboNo) {
    	  switch(comboObj.id) {
    	  	case "rgn_shp_opr_cd":    
    	  		var i=0;
    	  		with(comboObj) {
    	  			SetTitle("Code|Description");
    	  			SetColAlign("center|left");
    	  			SetColWidth("50|150");
    	  			DropHeight = 200;
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
         var sheetID = sheetObj.id ; 
         switch(sheetID) {
         	case "t1sheet1":
         		with (sheetObj) {

         			// 높이 설정
         			style.height = 320;
         			//전체 너비 설정
         			SheetWidth = mainTable.clientWidth;

         			//Host정보 설정[필수][HostIp, Port, PagePath]
         			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

         			//전체Merge 종류 [선택, Default msNone]
         			MergeSheet = msPrevColumnMerge + msHeaderOnly;

         			//전체Edit 허용 여부 [선택, Default false]
         			Editable = true;

         			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         			InitRowInfo( 2, 1, 3, 100);

        		    var HeadTitle  = "No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
        		    	HeadTitle += "Sequence|Sequence|TPSZ|TP|UN No.\n/Seq.|UN No.\n/Seq.|Class|Sub\nrisks|MP|PG|LQ|EQ|FP(℃)|Weight|Weight|Weight|PSA|Net Exp.\nWeight(KG)|HCDG|";
        		    	HeadTitle += " | | | | | | | | | | | | |";

                    var HeadTitle1  = "No.|Lane| | | |VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
                    	HeadTitle1 += "CNTR|CGO|TPSZ|TP|UN No.\n/Seq.|UN No.\n/Seq.|Class|Sub\nrisks|MP|PG|LQ|EQ|FP(℃)|Gross|Net|UOM|PSA|Net Exp.\nWeight(KG)|HCDG|";
                    	HeadTitle1 += " | | | | | | | | | | | | |";
                     
         			var headCount = ComCountHeadTitle(HeadTitle);

         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(headCount, 10, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(true, true, false, true, false, false)

         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);
         			InitHeadRow(1, HeadTitle1, true);

         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                     
         			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"num",					false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"slan_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	"vsl_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	30, daCenter,	true,	"skd_voy_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	20,	daCenter,	true,	"skd_dir_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	35,	daCenter,	true,	"crr_cd",				false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pol_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	95, daCenter,	true,	"vps_eta_dt",			false,	"",	dfNone,	0,	false	);      
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pod_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			90,	daLeft,		true,	"booking_no",			false,	"",	dfNone,	0,	false 	);
         			InitDataProperty(0, cnt++ , dtData,      	50,	daRight,	true,	"rqst_day",				false,	"",	dfFloat,1,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"eml_snd_no",			false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,	true,	"seqNo",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,    		40,	daCenter,	true,	"spcl_cgo_auth_cd",		false,	"",	dfNone,	0,	true	);
         			InitDataProperty(0, cnt++ , dtComboEdit,   	50,	daCenter,	true,	"spcl_cgo_auth_rjct_cd",false,	"",	dfNone,	0,	true, 	false, 3);  
         			InitDataProperty(0, cnt++ , dtData,			85,	daLeft,		true,	"apro_ref_no",			false,	"",	dfNone,	0,	false, 	false, 50);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"dg_cntr_seq",			false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"cntr_cgo_seq",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	40,	daCenter,	true,	"cntr_tpsz_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	25,	daCenter,	true,	"dg_tp",				false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtData,      	30,	daCenter,	true,	"imdg_un_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	20,	daCenter,	true,	"imdg_un_no_seq",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	35,	daCenter,	true,	"imdg_clss_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	80,	daCenter,	true,	"imdg_subs_rsk_lbl_cd",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	25,	daCenter,	true,	"mrn_polut_flg",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	25,	daCenter,	true,	"imdg_pck_grp_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	25,	daCenter,	true,	"imdg_lmt_qty_flg",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	25,	daCenter,	true,	"imdg_expt_qty_flg",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"flsh_pnt_cdo_temp",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	"grs_wgt",				false,	"",	dfFloat,3,	false	);
         			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	"net_wgt",				false,	"",	dfFloat,3,	false	);
         			InitDataProperty(0, cnt++ , dtData,			30,	daRight,	true,	"wgt_ut_cd",			false,	"",	dfNone ,0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	30,	daCenter,	true,	"psa_no",				false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtData,      	75,	daRight,	true,	"net_explo_wgt",		false,	"",	dfNone,	0,	false	); 
         			InitDataProperty(0, cnt++ , dtData,      	40,	daCenter,	true,	"hcdg_flg",				false,	"",	dfNone,	0,	false	);
     	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,  	true,	"ibflag");
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"bkg_no",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"cntr_no",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_apro_rqst_seq",false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_pre_pst_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_seq",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_auth_seq",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"dcgo_seq",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_cate_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daLeft,		true,	"spcl_cgo_auth_rmk",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"net_wgt_sum",			false,	"",	dfFloat,3,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pol_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pod_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,      	35,	daCenter,	true,	"crr_code",				false,	"",	dfNone,	0,	false	);         			
         			
         			ScrollTrack		= false;
         			MassOfSearch 	= 1;
                    HeadRowHeight 	= 20;
         			RequestTimeOut 	= 300;
    	 			SetMergeCell(0, 2, 2, 3);
    	 			SetMergeCell(0, 20, 2, 2);
    	 			ColHidden("seqNo")= true;
                    InitDataValid(0, "spcl_cgo_auth_rjct_cd", vtEngUpOnly);
    	 			
    	 			MultiSelection = true;
    	 			//2010.02.02 서동호부장님 요청으로 인한 주석처리
         			//ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";
					
         		}
         		break;
         		
         	case "t2sheet1":
         		with (sheetObj) {

         			// 높이 설정
         			style.height = 320;
         			//전체 너비 설정
         			SheetWidth = mainTable.clientWidth;

         			//Host정보 설정[필수][HostIp, Port, PagePath]
         			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
         			
         			//전체Merge 종류 [선택, Default msNone]
         			MergeSheet = msPrevColumnMerge + msHeaderOnly;
         			
         			//전체Edit 허용 여부 [선택, Default false]
         			Editable = true;
         			
         			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         			InitRowInfo( 2, 1, 3, 100);
         			
        		    var HeadTitle  = "No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
        		    	HeadTitle += "Sequence|Sequence|TPSZ|TP|UN No.\n/Seq.|UN No.\n/Seq.|Class|Sub\nrisks|MP|PG|LQ|EQ|FP(℃)|Weight|Weight|Weight|PSA|HCDG|";
        		    	HeadTitle += " | | | | | | | | | | | | |";

        		    var HeadTitle1  = "No.|Lane| | | |VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
                		HeadTitle1 += "CNTR|CGO|TPSZ|TP|UN No.\n/Seq.|UN No.\n/Seq.|Class|Sub\nrisks|MP|PG|LQ|EQ|FP(℃)|Gross|Net|UOM|PSA|HCDG|";
                		HeadTitle1 += " | | | | | | | | | | | | |";
                     
                	var headCount = ComCountHeadTitle(HeadTitle);

         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(headCount, 10, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(true, true, false, true, false,false)
         			
         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);
         			InitHeadRow(1, HeadTitle1, true);
         			
         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"num",					false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"slan_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	"vsl_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	30, daCenter,	true,	"skd_voy_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	20,	daCenter,	true,	"skd_dir_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	35,	daCenter,	true,	"crr_cd",				false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pol_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	95, daCenter,	true,	"vps_eta_dt",			false,	"",	dfNone,	0,	false	);      
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pod_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			90,	daLeft,		true,	"booking_no",			false,	"",	dfNone,	0,	false 	);
         			InitDataProperty(0, cnt++ , dtData,      	50,	daRight,	true,	"rqst_day",				false,	"",	dfFloat,1,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"eml_snd_no",			false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,	true,	"seqNo",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,    		40,	daCenter,	true,	"spcl_cgo_auth_cd",		false,	"",	dfNone,	0,	true	);
         			InitDataProperty(0, cnt++ , dtComboEdit,   	50,	daCenter,	true,	"spcl_cgo_auth_rjct_cd",false,	"",	dfNone,	0,	true, false, 3);  
         			InitDataProperty(0, cnt++ , dtData,			85,	daLeft,		true,	"apro_ref_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"dg_cntr_seq",			false,	"",	dfNone,	0,	false	); 
         			
         			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"cntr_cgo_seq",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	40,	daCenter,	true,	"cntr_tpsz_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	25,	daCenter,	true,	"dg_tp",				false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtData,      	30,	daCenter,	true,	"imdg_un_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	20,	daCenter,	true,	"imdg_un_no_seq",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	35,	daCenter,	true,	"imdg_clss_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	80,	daCenter,	true,	"imdg_subs_rsk_lbl_cd",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	25,	daCenter,	true,	"mrn_polut_flg",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	25,	daCenter,	true,	"imdg_pck_grp_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	25,	daCenter,	true,	"imdg_lmt_qty_flg",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	25,	daCenter,	true,	"imdg_expt_qty_flg",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"flsh_pnt_cdo_temp",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	"grs_wgt",				false,	"",	dfFloat,3,	false	);
         			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	"net_wgt",				false,	"",	dfFloat,3,	false	);
         			InitDataProperty(0, cnt++ , dtData,			30,	daRight,	true,	"wgt_ut_cd",			false,	"",	dfNone, 0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	30,	daCenter,	true,	"psa_no",				false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtData,      	40,	daCenter,	true,	"hcdg_flg",				false,	"",	dfNone,	0,	false	);

     	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,  	true,	"ibflag");
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"bkg_no",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"cntr_no",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_apro_rqst_seq",false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_pre_pst_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_seq",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_auth_seq",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"dcgo_seq",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_cate_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_auth_rmk",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"net_wgt_sum",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pol_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pod_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,      	35,	daCenter,	true,	"crr_code",				false,	"",	dfNone,	0,	false	);         			
         			
         			ScrollTrack		= false;
 					MassOfSearch 	= 1; 					
                    HeadRowHeight 	= 20;
         			RequestTimeOut 	= 300;
         			SetMergeCell(0, 2, 2, 3);
    	 			SetMergeCell(0, 20, 2, 2);
       	 			ColHidden("seqNo")= true;
                    InitDataValid(0, "spcl_cgo_auth_rjct_cd", vtEngUpOnly);

    	 			MultiSelection = true;
    	 			//2010.02.02 서동호부장님 요청으로 인한 주석처리
         			//ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";
                }
         		break;

         	case "t3sheet1":
         		with (sheetObj) {

         			// 높이 설정
         			style.height = 320;
         			//전체 너비 설정
         			SheetWidth = mainTable.clientWidth;

         			//Host정보 설정[필수][HostIp, Port, PagePath]
         			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
         			
         			//전체Merge 종류 [선택, Default msNone]
         			MergeSheet = msPrevColumnMerge + msHeaderOnly;
         			
         			//전체Edit 허용 여부 [선택, Default false]
         			Editable = true;
         			
         			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         			InitRowInfo( 2, 1, 3, 100);
         			
         			var HeadTitle  = "No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
         				HeadTitle += "CNTR\nSeq.|TPSZ|Commodity|Over All (cm)|Over All (cm)|Over All (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|";
         				HeadTitle += "Over Dimension (cm)|Post\nExtd|Weight|Weight|Weight|Void\n(FEU)|";
         				HeadTitle += " | | | | | | | | | | |";

         			var HeadTitle1  = "No.|Lane| | | |VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
         				HeadTitle1 += "CNTR\nSeq.|TPSZ|Commodity|L|W|H|FWD|AFT|Left|Right|Height|";
         				HeadTitle1 += "Post\nExtd|Gross|Net|UOM|Void\n(FEU)|";
         				HeadTitle1 += " | | | | | | | | | | |";

                	var headCount = ComCountHeadTitle(HeadTitle);

         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(headCount, 10, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(true, true, false, true, false,false)
         			
         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);
         			InitHeadRow(1, HeadTitle1, true);

         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"num",					false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"slan_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	"vsl_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	30, daCenter,	true,	"skd_voy_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	20,	daCenter,	true,	"skd_dir_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	35,	daCenter,	true,	"crr_cd",				false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pol_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	95, daCenter,	true,	"vps_eta_dt",			false,	"",	dfNone,	0,	false	);      
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pod_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			90,	daLeft,		true,	"booking_no",			false,	"",	dfNone,	0,	false 	);
         			InitDataProperty(0, cnt++ , dtData,      	50,	daRight,	true,	"rqst_day",				false,	"",	dfFloat,1,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"eml_snd_no",			false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,	true,	"seqNo",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,    		40,	daCenter,	true,	"spcl_cgo_auth_cd",		false,	"",	dfNone,	0,	true	);
         			InitDataProperty(0, cnt++ , dtComboEdit,   	50,	daCenter,	true,	"spcl_cgo_auth_rjct_cd",false,	"",	dfNone,	0,	true, false, 3);  
         			InitDataProperty(0, cnt++ , dtData,			85,	daLeft,		true,	"apro_ref_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"awk_cgo_seq",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	40,	daCenter,	true,	"cntr_tpsz_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	150,daLeft,		true,	"cmdt_nm",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight,  	true,   "ttl_dim_len",			false,  "", dfNumber,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight,  	true,   "ttl_dim_wdt",			false,  "", dfNumber,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight,  	true,   "ttl_dim_hgt",			false,  "", dfNumber,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight,  	true,   "ovr_fwrd_len",			false,  "", dfNullInteger,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight,  	true,   "ovr_bkwd_len",			false,  "", dfNullInteger,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight, 	true,   "ovr_lf_len",			false,  "", dfNullInteger,	0,	false	); 
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight,  	true,   "ovr_rt_len",			false,  "", dfNullInteger,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight,  	true,   "ovr_hgt",				false,  "", dfNullInteger,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight,  	true,   "xtd_ovr_qty",			false,  "", dfNullInteger,  1,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	80, daRight,  	true,   "grs_wgt",				false,  "", dfFloat,	3,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	80, daRight,  	true,   "net_wgt",				false,  "", dfFloat,	3,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	30, daRight,  	true,   "wgt_ut_cd",	    	false,  "", dfNone,	    0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daCenter,  	true,	"ovr_void_slt_qty",     false,	"",	dfFloat,	1,	false	);
      
     	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,  	true,	"ibflag");
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"bkg_no",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_apro_rqst_seq",false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_pre_pst_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_seq",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_auth_seq",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"cntr_no",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_cate_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_auth_rmk",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pol_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pod_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,      	35,	daCenter,	true,	"crr_code",				false,	"",	dfNone,	0,	false	);         			
         			
         			ScrollTrack		= false;
 					MassOfSearch 	= 1;
                    HeadRowHeight 	= 20;
         			RequestTimeOut 	= 300;
    	 			SetMergeCell (0, 2, 2, 3);
    	 			ColHidden("seqNo")= true;
                    InitDataValid(0, "spcl_cgo_auth_rjct_cd", vtEngUpOnly);

    	 			MultiSelection = true;
    	 			//2010.02.02 서동호부장님 요청으로 인한 주석처리
         			//ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";
                }
         		break;


         	case "t4sheet1":
         		with (sheetObj) {

          			// 높이 설정
          			style.height = 320;
          			//전체 너비 설정
          			SheetWidth = mainTable.clientWidth;

          			//Host정보 설정[필수][HostIp, Port, PagePath]
          			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
          			
          			//전체Merge 종류 [선택, Default msNone]
         			MergeSheet = msPrevColumnMerge + msHeaderOnly;
          			
          			//전체Edit 허용 여부 [선택, Default false]
          			Editable = true;
          			
          			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
          			InitRowInfo( 2, 1, 3, 100);
          			
          			var HeadTitle  = "No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
          				HeadTitle += "CGO\nSeq.|Commodity|Length\n(cm)|Width\n(cm)|Height\n(cm)|Gross\nWeight|Gross\nWeight|Void\n(FEU)|";
          				HeadTitle += " | | | | | | | | | |";

          			var HeadTitle1  = "No.|Lane| | | |VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
          				HeadTitle1 += "CGO\nSeq.|Commodity|Length\n(cm)|Width\n(cm)|Height\n(cm)|Weight|UOM|Void\n(FEU)|";
          				HeadTitle1 += " | | | | | | | | | |";

                	var headCount = ComCountHeadTitle(HeadTitle);

         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(headCount, 10, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(true, true, false, true, false,false)
         			
         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);
         			InitHeadRow(1, HeadTitle1, true);

         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"num",					false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"slan_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	"vsl_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	30, daCenter,	true,	"skd_voy_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	20,	daCenter,	true,	"skd_dir_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	35,	daCenter,	true,	"crr_cd",				false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pol_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	95, daCenter,	true,	"vps_eta_dt",			false,	"",	dfNone,	0,	false	);      
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pod_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			90,	daLeft,		true,	"booking_no",			false,	"",	dfNone,	0,	false 	);
         			InitDataProperty(0, cnt++ , dtData,      	50,	daRight,	true,	"rqst_day",				false,	"",	dfFloat,1,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"eml_snd_no",			false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,	true,	"seqNo",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,    		40,	daCenter,	true,	"spcl_cgo_auth_cd",		false,	"",	dfNone,	0,	true	);
         			InitDataProperty(0, cnt++ , dtComboEdit,   	50,	daCenter,	true,	"spcl_cgo_auth_rjct_cd",false,	"",	dfNone,	0,	true, false, 3);  
         			InitDataProperty(0, cnt++ , dtData,			85,	daLeft,		true,	"apro_ref_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"bb_cgo_seq",			false,	"",	dfNone,		0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	150,daLeft,		true,	"cmdt_nm",				false,	"",	dfNone,		0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight,  	true,   "dim_len",				false,  "", dfNumber,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight,  	true,   "dim_wdt",				false,  "", dfNumber,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daRight,  	true,   "dim_hgt",				false,  "", dfNumber,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	80, daRight,  	true,   "grs_wgt",				false,  "", dfFloat,	3,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	30, daCenter,  	true,   "wgt_ut_cd",			false,  "", dfNone,  	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	50, daCenter,  	true,	"ovr_void_slt_qty",     false,	"",	dfFloat,	1,	false	);

     	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,  	true,	"ibflag");
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"bkg_no",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_apro_rqst_seq",false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_pre_pst_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_seq",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_auth_seq",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_cate_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_auth_rmk",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pol_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pod_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,      	35,	daCenter,	true,	"crr_code",				false,	"",	dfNone,	0,	false	);         			
         			
         			ScrollTrack		= false;
 					MassOfSearch 	= 1; 					
                    HeadRowHeight 	= 20;
         			RequestTimeOut 	= 300;
    	 			SetMergeCell (0, 2, 2, 3);
    	 			ColHidden("seqNo")= true;
                    InitDataValid(0, "spcl_cgo_auth_rjct_cd", vtEngUpOnly);

    	 			MultiSelection = true;
    	 			//2010.02.02 서동호부장님 요청으로 인한 주석처리
         			//ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";
         		}
         		break;

         	case "t5sheet1":
         		with (sheetObj) {

         			// 높이 설정
         			style.height = 320;
         			//전체 너비 설정
         			SheetWidth = mainTable.clientWidth;

         			//Host정보 설정[필수][HostIp, Port, PagePath]
         			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
         			
         			//전체Merge 종류 [선택, Default msNone]
         			MergeSheet = msPrevColumnMerge + msHeaderOnly;
         			
         			//전체Edit 허용 여부 [선택, Default false]
         			Editable = true;
         			
         			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         			InitRowInfo( 2, 1, 3, 100);
         			
         			var HeadTitle  = "No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
         				HeadTitle += "CNTR\nSeq.|TPSZ|Commodity|Length\n(cm)|Width\n(cm)|Height\n(cm)|Gross\nWeight|Gross\nWeight|";
         				HeadTitle += " | | | | | | | | | |";

         			var HeadTitle1  = "No.|Lane| | | |VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
         				HeadTitle1 += "CNTR\nSeq.|TPSZ|Commodity|Length\n(cm)|Width\n(cm)|Height\n(cm)|Weight|UOM|";
         				HeadTitle1 += " | | | | | | | | | |";

                	var headCount = ComCountHeadTitle(HeadTitle);

         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(headCount, 10, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(true, true, false, true, false,false)
         			
         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);
         			InitHeadRow(1, HeadTitle1, true);

         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                     
         			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"num",					false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"slan_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	"vsl_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	30, daCenter,	true,	"skd_voy_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	20,	daCenter,	true,	"skd_dir_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	35,	daCenter,	true,	"crr_cd",				false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pol_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	95, daCenter,	true,	"vps_eta_dt",			false,	"",	dfNone,	0,	false	);      
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pod_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			90,	daLeft,		true,	"booking_no",			false,	"",	dfNone,	0,	false 	);
         			InitDataProperty(0, cnt++ , dtData,      	50,	daRight,	true,	"rqst_day",				false,	"",	dfFloat,1,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"eml_snd_no",			false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,	true,	"seqNo",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,    		40,	daCenter,	true,	"spcl_cgo_auth_cd",		false,	"",	dfNone,	0,	true	);
         			InitDataProperty(0, cnt++ , dtComboEdit,   	50,	daCenter,	true,	"spcl_cgo_auth_rjct_cd",false,	"",	dfNone,	0,	true, false, 3);  
         			InitDataProperty(0, cnt++ , dtData,			85,	daLeft,		true,	"apro_ref_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"awk_cgo_seq",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	40,	daCenter,	true,	"cntr_tpsz_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	150,daLeft,		true,	"cmdt_nm",				false,	"",	dfNone,	0,	false	);
                    InitDataProperty(0, cnt++ , dtData,			50,	daRight,	true,   "ttl_dim_len",			false,  "", dfNumber,0,	false	);
                    InitDataProperty(0, cnt++ , dtData,			50,	daRight,	true,   "ttl_dim_wdt",			false,  "", dfNumber,0,	false	);
                    InitDataProperty(0, cnt++ , dtData,			50,	daRight,	true,   "ttl_dim_hgt",			false,  "", dfNumber,0,	false	);
                    InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,   "grs_wgt",				false,  "", dfFloat,3,	false	);
                    InitDataProperty(0, cnt++ , dtData,			30,	daRight,	true,   "wgt_ut_cd",			false,  "", dfNone, 0,	false	);
     	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,  	true,	"ibflag");
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"bkg_no",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_apro_rqst_seq",false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_pre_pst_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_seq",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_auth_seq",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_cate_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_auth_rmk",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pol_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pod_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,      	35,	daCenter,	true,	"crr_code",				false,	"",	dfNone,	0,	false	);         			

         			ScrollTrack		= false;
 					MassOfSearch 	= 1; 					
                    HeadRowHeight 	= 20;
         			RequestTimeOut 	= 300;
         			SetMergeCell (0, 2, 2, 3);
    	 			ColHidden("seqNo")= true;
                    InitDataValid(0, "spcl_cgo_auth_rjct_cd", vtEngUpOnly);

    	 			MultiSelection = true;
    	 			//2010.02.02 서동호부장님 요청으로 인한 주석처리
         			//ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";
                }
         		break;

         	case "t6sheet1":
         		with (sheetObj) {

         			// 높이 설정
         			style.height = 320;
         			//전체 너비 설정
         			SheetWidth = mainTable.clientWidth;

         			//Host정보 설정[필수][HostIp, Port, PagePath]
         			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
         			
         			//전체Merge 종류 [선택, Default msNone]
         			MergeSheet = msPrevColumnMerge + msHeaderOnly;
         			
         			//전체Edit 허용 여부 [선택, Default false]
         			Editable = true;
         			
         			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         			InitRowInfo( 2, 1, 3, 100);
         			
         			var HeadTitle  = "No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
         				HeadTitle += "CNTR\nSeq.|TPSZ|Commodity|Voltage|Temperature|Temperature|Vent\n(% Open)|CMH|Gross\nWeight|Gross\nWeight|";
         				HeadTitle += " | | | | | | | | | | |";

         			var HeadTitle1  = "No.|Lane| | | |VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|APVL\nRef. No.|";
         				HeadTitle1 += "CNTR\nSeq.|TPSZ|Commodity|Voltage|°C|°F|Vent\n(% Open)|CMH|Weight|UOM|";
         				HeadTitle1 += " | | | | | | | | | | |";

                	var headCount = ComCountHeadTitle(HeadTitle);

         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(headCount, 10, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(true, true, false, true, false,false)
         			
         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);
         			InitHeadRow(1, HeadTitle1, true);

         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"num",					false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"slan_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	"vsl_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	30, daCenter,	true,	"skd_voy_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	20,	daCenter,	true,	"skd_dir_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	35,	daCenter,	true,	"crr_cd",				false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pol_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	95, daCenter,	true,	"vps_eta_dt",			false,	"",	dfNone,	0,	false	);      
         			InitDataProperty(0, cnt++ , dtData,      	45,	daCenter,	true,	"pod_cd",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			90,	daLeft,		true,	"booking_no",			false,	"",	dfNone,	0,	false 	);
         			InitDataProperty(0, cnt++ , dtData,      	50,	daRight,	true,	"rqst_day",				false,	"",	dfFloat,1,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"eml_snd_no",			false,	"",	dfNone,	0,	false	);         			
         			InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,	true,	"seqNo",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,    		40,	daCenter,	true,	"spcl_cgo_auth_cd",		false,	"",	dfNone,	0,	true	);
         			InitDataProperty(0, cnt++ , dtComboEdit,   	50,	daCenter,	true,	"spcl_cgo_auth_rjct_cd",false,	"",	dfNone,	0,	true, false, 3);  
         			InitDataProperty(0, cnt++ , dtData,			85,	daLeft,		true,	"apro_ref_no",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	"rc_seq",				false,	"",	dfNone,		0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	40,	daCenter,	true,	"cntr_tpsz_cd",			false,	"",	dfNone,		0,	false	);
         			InitDataProperty(0, cnt++ , dtData,      	150,daLeft,		true,	"cmdt_nm",				false,	"",	dfNone,		0,	false	);
                    InitDataProperty(0, cnt++ , dtData,      	60,	daRight,	true,	"vltg_no",				false,	"",	dfNullInteger,	0,	false	);
                    InitDataProperty(0, cnt++ , dtData,      	40,	daRight,	true,	"cdo_temp",				false,	"",	dfFloat,	1,	false	);
                    InitDataProperty(0, cnt++ , dtData,      	40,	daRight,	true,	"fdo_temp",				false,	"",	dfFloat,	1,	false	);
                    InitDataProperty(0, cnt++ , dtData,      	60,	daCenter,	true,	"vent_rto",				false,	"",	dfNullInteger,	0,	false	);
                    InitDataProperty(0, cnt++ , dtData,      	40,	daRight,	true,	"cbm_per_hr_qty",		false,	"",	dfNullInteger,	0,	false	);
                    InitDataProperty(0, cnt++ , dtData,      	80,	daRight,	true,	"grs_wgt",				false,	"",	dfFloat,	3,	false	);                    
                    InitDataProperty(0, cnt++ , dtData,      	30,	daCenter,	true,	"wgt_ut_cd",			false,	"",	dfNone,  	0,	false	);                    

     	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,  	true,	"ibflag");
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"bkg_no",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_apro_rqst_seq",false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_pre_pst_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"vsl_seq",				false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_auth_seq",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"spcl_cgo_cate_cd",		false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daLeft,		true,	"spcl_cgo_auth_rmk",	false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pol_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"pod_yd_cd",			false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,		85,	daCenter,	true,	"org_spcl_cgo_auth_cd", false,	"",	dfNone,	0,	false	);
         			InitDataProperty(0, cnt++ , dtHidden,      	35,	daCenter,	true,	"crr_code",				false,	"",	dfNone,	0,	false	);         			

         			ScrollTrack		= false;
 					MassOfSearch 	= 1;
                    HeadRowHeight 	= 20;
         			RequestTimeOut 	= 300;
         			SetMergeCell (0, 2, 2, 3);
    	 			ColHidden("seqNo")= true;
                    InitDataValid(0, "spcl_cgo_auth_rjct_cd", vtEngUpOnly);

    	 			MultiSelection = true;
    	 			//2010.02.02 서동호부장님 요청으로 인한 주석처리
         			//ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";
                }
         		break;
         		
         	case 'laneSheet':      // Vessel 정보 그리드
				with (sheetObj) {
					
//					tabIndex = -1;
					
					// 영문입력모드
					style.imeMode = "inactive";
					
//					var headCount = 15;
					// 높이 설정
					//style.height = 90;
					
					// 전체 너비 설정
					SheetWidth = 700;
//					SheetWidth = 800;
					
					ScrollBar = 0;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, laneSheetDataRows, laneSheetDataRows, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(15, 0, 1, false);
//					InitColumnInfo(17, 0, 1, false);
					
					// 해더기능([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
					InitHeadMode(false, false, false, false, false, false);
					
					var HeadTitle1 = "||||||||||||||";
//					var HeadTitle1 = "||||||||||||||||";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, false, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
//					ImageList(0) = "/hanjin/img/btns_calendar.gif";
//					ImageList(1) = "/hanjin/img/btns_search.gif";
					
					for(var i = 0 ; i <laneSheetDataRows ; i++){
						InitDataProperty(i, 0 , dtData,      50, daCenter,  true,   "left",	false,	"",		dfNone,				0,			false,		false);
						
						for ( var j = 1; j < 14; j++) {
//							for ( var j = 1; j < 16; j++) {
							if (i == laneSheetLaneCdDataRow1) {
								InitDataProperty(i, j, dtData, 50, daCenter, false, "slan_cd" + j, false, "", dfNone, 0, true, true, 3); // Start Date
								InitDataValid(i, j, vtEngUpOther, "0123456789");
							} else if (i == laneSheetLaneCdDataRow2) {
								InitDataProperty(i, j, dtData, 50, daCenter, false, "slan_cd" + (j+13), false, "", dfNone, 0, true, true, 3); // Vessel Code
//								InitDataProperty(i, j, dtData, 50, daCenter, false, "slan_cd" + (j+15), false, "", dfNone, 0, true, true, 3); // Vessel Code
								InitDataValid(i, j, vtEngUpOther, "0123456789");
							}
						}
//						InitDataProperty(i, 16 , dtHidden,      50, daCenter,  true,   "dummy",	false,	"",		dfNone,				0,			false,		false);
						
						InitDataProperty(i, j , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
					
					}
					
		            ShowButtonImage = 2;

					//dfDateYmd
					
					CountPosition = 0;
					//해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
					InitHeadColumn("left", "Lane|Lane", daCenter);
					
					WaitImageVisible = false;
					
				}            
				
	            break;
         }
     }

     //업무 자바스크립트 OnKeyPress 이벤트 Catch
     function initControl() {
    	 axon_event.addListener ('keydown', 	'ComKeyEnter', 	'form');
    	 axon_event.addListenerForm('click', 	'obj_click', 	document.form); 
    	 axon_event.addListenerForm('keypress', 'obj_keypress',	document.form);
    	 axon_event.addListenerForm('keyup',	'obj_keyup', 	document.form);
    	 axon_event.addListenerForm('blur', 	'obj_blur', 	document.form); 
     }
     
     var arrRjctCdDG = "";
     var arrRjctCdAK = "";
     var arrRjctCdBB = "";
     var arrRjctCdRF = "";
     var arrRjctNmDG = "";
     var arrRjctNmAK = "";
     var arrRjctNmBB = "";
     var arrRjctNmRF = "";
     
     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         sheetObj.IsBufferedScroll = true;
         switch(sAction) {
         	case IBSEARCH_ASYNC01: //RSO 조회
         		sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0034GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
				break;

         	case IBSEARCH_ASYNC02: //checkLane 조회
//         		sheetObj.WaitImageVisible = false;
//         		formObj.f_cmd.value = SEARCH02;
//         		var sName = event.srcElement.name;
//         		var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do" , FormQueryString(formObj)+"&vsl_slan_cd="+event.srcElement.value);
//         		var arrData = ComScgXml2Array(sXml, "vsl_slan_cd");
//         		if (arrData != null && arrData.length > 0) {
//         			ComSetNextFocus(event.srcElement);
//         		}else{
//         			ComShowCodeMessage('SCG50010',"Data" );
//         			event.srcElement.value= "";
//         			event.srcElement.focus();
//					return false;
//         		}
         		
         		formObj.f_cmd.value = SEARCH02;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.getSearchXml("VOP_SCG_0014GS.do", sParam);
				var laneInfo = new Object();
				laneInfo.vslSlanCd = ComGetEtcData(sXml, "vsl_slan_cd");
				return laneInfo;
				
				break;
				
         	case IBSEARCH_ASYNC03: //RJT CD 조회
         		sheetObj.WaitImageVisible = false;
         		formObj.f_cmd.value = SEARCH;
         		
         		//파라미터 명시적인 생성
	 			var formParams = "";
	     		formParams += "f_cmd="+ComGetObjValue(formObj.f_cmd);
         		
         		var sXml = sheetObj.GetSearchXml("VOP_SCG_0031GS.do", formParams);
         		var arrData = ComScgXml2Array(sXml, "spcl_cgo_cate_cd|spcl_cgo_lod_rjct_rsn_cd|rjct_rsn_cd_desc");
         		for (var i=0; i < arrData.length; i++) {
         			if (arrData[i][0] == "DG") {
         				arrRjctCdDG += "|"+arrData[i][1];
         				arrRjctNmDG += "|"+arrData[i][1]+"\t"+arrData[i][2];
         			}else if (arrData[i][0] == "AK"){
         				arrRjctCdAK += "|"+arrData[i][1];
         				arrRjctNmAK += "|"+arrData[i][1]+"\t"+arrData[i][2];
         			}else if (arrData[i][0] == "BB"){
         				arrRjctCdBB += "|"+arrData[i][1];
         				arrRjctNmBB += "|"+arrData[i][1]+"\t"+arrData[i][2];
         			}else if (arrData[i][0] == "RF"){
         				arrRjctCdRF += "|"+arrData[i][1];
         				arrRjctNmRF += "|"+arrData[i][1]+"\t"+arrData[i][2];
         			}
         		}
//         		sheetObjects[0].InitDataCombo(0, "spcl_cgo_auth_rjct_cd", " " + arrRjctNmDG,  " " + arrRjctCdDG);
         		sheetObjects[1].InitDataCombo(0, "spcl_cgo_auth_rjct_cd", " " + arrRjctNmDG,  " " + arrRjctCdDG);
         		sheetObjects[2].InitDataCombo(0, "spcl_cgo_auth_rjct_cd", " " + arrRjctNmDG,  " " + arrRjctCdDG);
         		sheetObjects[3].InitDataCombo(0, "spcl_cgo_auth_rjct_cd", " " + arrRjctNmAK,  " " + arrRjctCdAK);
         		sheetObjects[4].InitDataCombo(0, "spcl_cgo_auth_rjct_cd", " " + arrRjctNmBB,  " " + arrRjctCdBB);
         		sheetObjects[5].InitDataCombo(0, "spcl_cgo_auth_rjct_cd", " " + arrRjctNmAK,  " " + arrRjctCdAK);
         		sheetObjects[6].InitDataCombo(0, "spcl_cgo_auth_rjct_cd", " " + arrRjctNmRF,  " " + arrRjctCdRF);
         
         		break;

         	case IBSEARCH_ASYNC04: // Vessel조회
         		sheetObj.WaitImageVisible = false;
         		formObj.f_cmd.value = COMMAND16;
         		var sXml = sheetObj.GetSearchXml("VOP_VSK_0219GS.do" , FormQueryString(formObj)+"&vsl_cd="+event.srcElement.value+"&op=0219");
         		var arrData = ComScgXml2Array(sXml, "vsl_cd");
         		if (arrData != null && arrData.length > 0) {
         		}else{
         			ComShowCodeMessage('SCG50010',"Data" );
         			event.srcElement.value= "";
         			event.srcElement.focus();
					return false;
         		}
         		break;

         	case IBSEARCH:      //조회
//         		alert(ComGetSaveString(sheetObjects[0]));
	 			if(!validateForm(sheetObj,formObj,sAction))return;
         		formObj.f_cmd.value = SEARCH;
         		
         		sheetObj.removeAll();
         		if (tabIndex == 0) {
         			scg_flg = "DG1";
             		formObj.t0retrieve_flg.value = "Y";
         		}else if (tabIndex == 1) {
         			scg_flg = "DG2";
             		formObj.t1retrieve_flg.value = "Y";
         		}else if (tabIndex == 2) {
         			scg_flg = "AWK";
             		formObj.t2retrieve_flg.value = "Y";
         		}else if (tabIndex == 3) {
         			scg_flg = "BB";
             		formObj.t3retrieve_flg.value = "Y";
         		}else if (tabIndex == 4) {
         			scg_flg = "45";
             		formObj.t4retrieve_flg.value = "Y";
         		}else if (tabIndex == 5) {
         			scg_flg = "RF";
             		formObj.t5retrieve_flg.value = "Y";
         		}
         		
         		//파라미터 명시적인 생성
         		var formParams = "";
         		
         		formParams += "auth_flg="        +ComGetObjValue(formObj.auth_flg);
         		formParams += "&f_cmd="          +ComGetObjValue(formObj.f_cmd);
         		formParams += "&pagerows="       +ComGetObjValue(formObj.pagerows);
         		formParams += "&rgn_shp_opr_cd=" +comboObjects[0].Code;
         		
//         		formParams += "&slan_cd1="       +ComGetObjValue(formObj.slan_cd1);
//         		formParams += "&slan_cd2="       +ComGetObjValue(formObj.slan_cd2);
//         		formParams += "&slan_cd3="       +ComGetObjValue(formObj.slan_cd3);
//         		formParams += "&slan_cd4="       +ComGetObjValue(formObj.slan_cd4);
//         		formParams += "&slan_cd5="       +ComGetObjValue(formObj.slan_cd5);
//         		formParams += "&slan_cd6="       +ComGetObjValue(formObj.slan_cd6);
//         		formParams += "&slan_cd7="       +ComGetObjValue(formObj.slan_cd7);
//         		formParams += "&slan_cd8="       +ComGetObjValue(formObj.slan_cd8);
//         		formParams += "&slan_cd9="       +ComGetObjValue(formObj.slan_cd9);
//         		formParams += "&slan_cd10="      +ComGetObjValue(formObj.slan_cd10);
//         		formParams += "&slan_cd11="      +ComGetObjValue(formObj.slan_cd11);
         		formParams += "&val_opr_tp_cd="  +ComGetObjValue(formObj.val_opr_tp_cd);
         		formParams += "&vsl_cd="         +ComGetObjValue(formObj.vsl_cd);
//         		if (formObj.from_eta_flg.checked == true && ComGetObjValue(formObj.from_eta_dt) != "") {
//         			formParams += "&from_eta_dt="     +ComGetObjValue(formObj.from_eta_dt);
//         		}
         		formParams += "&rqst_dt_range="     +ComGetObjValue(formObj.rqst_dt_range);
         		formParams += "&vps_eta_dt="     +ComGetObjValue(formObj.vps_eta_dt);
         		
         		var sParam = ComGetSaveString(sheetObjects[0]);
         		
         		var sXml = sheetObj.GetSearchXml("VOP_SCG_0014GS.do", formParams+"&scg_flg="+scg_flg+"&"+sParam);
    			
    			sheetObj.LoadSearchXml(sXml);
                break;

         	case IBSAVE:        //저장
         		if(validateForm(sheetObj,formObj,sAction)) {
         			formObj.f_cmd.value = MULTI;
             		if (tabIndex == 0) {
             			scg_flg = "DG1";
             		}else if (tabIndex == 1) {
             			scg_flg = "DG2";
             		}else if (tabIndex == 2) {
             			scg_flg = "AWK";
             		}else if (tabIndex == 3) {
             			scg_flg = "BB";
             		}else if (tabIndex == 4) {
             			scg_flg = "45";
             		}else if (tabIndex == 5) {
             			scg_flg = "RF";
             		}

         			var sParam = ComGetSaveString(sheetObj);
         			if (sParam == "") return;
         			
         			//파라미터 명시적인 생성
         			var formParams = "";
	         		formParams += "auth_flg="        +ComGetObjValue(formObj.auth_flg);
	         		formParams += "&f_cmd="          +ComGetObjValue(formObj.f_cmd);
	         		formParams += "&pagerows="       +ComGetObjValue(formObj.pagerows);
	         		formParams += "&rgn_shp_opr_cd=" +comboObjects[0].Code;
//	         		formParams += "&slan_cd1="       +ComGetObjValue(formObj.slan_cd1);
//	         		formParams += "&slan_cd2="       +ComGetObjValue(formObj.slan_cd2);
//	         		formParams += "&slan_cd3="       +ComGetObjValue(formObj.slan_cd3);
//	         		formParams += "&slan_cd4="       +ComGetObjValue(formObj.slan_cd4);
//	         		formParams += "&slan_cd5="       +ComGetObjValue(formObj.slan_cd5);
//	         		formParams += "&slan_cd6="       +ComGetObjValue(formObj.slan_cd6);
//	         		formParams += "&slan_cd7="       +ComGetObjValue(formObj.slan_cd7);
//	         		formParams += "&slan_cd8="       +ComGetObjValue(formObj.slan_cd8);
//	         		formParams += "&slan_cd9="       +ComGetObjValue(formObj.slan_cd9);
//	         		formParams += "&slan_cd10="      +ComGetObjValue(formObj.slan_cd10);
//	         		formParams += "&slan_cd11="      +ComGetObjValue(formObj.slan_cd11);
	         		formParams += "&val_opr_tp_cd="  +ComGetObjValue(formObj.val_opr_tp_cd);
	         		formParams += "&vsl_cd="         +ComGetObjValue(formObj.vsl_cd);
         			
         			sParam += "&" + formParams;

         			var sXml = sheetObj.GetSaveXml("VOP_SCG_0014GS.do", sParam+"&scg_flg="+scg_flg);
         			var svcResult = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
         			sheetObj.LoadSaveXml(sXml);

    				if ( svcResult == "S" ) {
    					// 저장 성공시에만 재조회 실행.
    					doActionIBSheet(sheetObj,document.form,IBSEARCH);
    				}

         		}
         		break;
         }
  		sheetObj.WaitImageVisible = true;
         
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
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt  = 0 ;
                     InsertTab( cnt++ , "DG - Part I" , -1 );
                     InsertTab( cnt++ , "DG - Part II" , -1 );
                     InsertTab( cnt++ , "Awkward" , -1 );
                     InsertTab( cnt++ , "Break-Bulk" , -1 );
                     InsertTab( cnt++ , "45'" , -1 );
                     InsertTab( cnt++ , "Reefer" , -1 );
                 }
              break;
          }
     }

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem){
    	 var formObj = document.form;
    	 var objs = document.all.item("tabLayer");
    	 var tabSelectedIdx = ComGetObjValue(formObj.tabSelectedIdx);

    	 objs[nItem].style.display = "Inline";
    	 objs[beforetab].style.display = "none";
		 
    	 //--------------- 요기가 중요 --------------------------//
    	 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	 //------------------------------------------------------//
    	 // [변경된 내용]
    	 // 1. 0번째 Tab Page에 대한 변경 시에도 Save 될 수 있도록 함.
    	 //		(As-Is) 0번째 Tab Page 변경 후  Tab Change 시 저장되지 않음.
    	 //	2. validateForm () 함수 첫번째 인수 파라메터 전달 시 문제 확인
    	 //		(As-is) tabSelectedIdx 변수는 Tab Page 순서를 의미함.
    	 //				tabSelectedIdx + 1 로 변경하여 Sheet 순서와 일치 시킴.
    	 //		(참고) 변수 ( tabSelectedIdx )가 String 으로 인식하여 숫자 연산이 되지  않음. 
    	 //            Ex) "0" (첫번째 탭) + 1 일 경우 문자("01")로 인식함
    	 
    	 //if (tabSelectedIdx!=0&&!validateForm(sheetObjects[tabSelectedIdx],formObj,IBCLEAR)) return;
    	 if (!validateForm(sheetObjects[parseInt(tabSelectedIdx,10) + 1],formObj,IBCLEAR)) return;
    	 
    	 beforetab= nItem;
    	 tabIndex = nItem;
		 
    	 if (tabIndex == 0 && document.form.retrieve_flg.value == "Y" && document.form.t0retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    	 }else if (tabIndex == 1 && document.form.retrieve_flg.value == "Y" && document.form.t1retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
    	 }else if (tabIndex == 2 && document.form.retrieve_flg.value == "Y" && document.form.t2retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
    	 }else if (tabIndex == 3 && document.form.retrieve_flg.value == "Y" && document.form.t3retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[4],document.form,IBSEARCH);
    	 }else if (tabIndex == 4 && document.form.retrieve_flg.value == "Y" && document.form.t4retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[5],document.form,IBSEARCH);
    	 }else if (tabIndex == 5 && document.form.retrieve_flg.value == "Y" && document.form.t5retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[6],document.form,IBSEARCH);
    	 }
    	 ComSetObjValue(formObj.tabSelectedIdx, nItem);
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if (sAction == IBSAVE){
    		 for (var i=1; i<=sheetObj.LastRow; i++){

    			 if(sheetObj.id == "t1sheet1" || sheetObj.id == "t2sheet1" || sheetObj.id == "t3sheet1"){
	    			 if(comboObjects[0].Code == "ASR" && sheetObj.CellValue(i,"crr_cd") != "SML" && sheetObj.CellValue(i,"spcl_cgo_auth_cd") == "Y" &&
	    						 sheetObj.CellSearchValue(i,"spcl_cgo_auth_cd").substr(0,1) == "R"){
	    				 
		    			 if(sheetObj.CellValue(i,"apro_ref_no").replace(/^\s*/,'') == "") {		    				
		    			 	sheetObj.SelectCell(i,"apro_ref_no");	
		    			 	ComShowCodeMessage('SCG10014');	
		    			 	sheetObj.ReturnCellData(i, "spcl_cgo_auth_cd");
		    			 	//return;
		    			 }
	    			 }
	    		}
    			 
    			 if(sheetObj.id == "t1sheet1" || sheetObj.id == "t2sheet1"){
	    			 if(comboObjects[0].Code == "AMR" && sheetObj.CellValue(i,"crr_cd") != "SML" && sheetObj.CellValue(i,"spcl_cgo_auth_cd") == "Y" &&
	    						 sheetObj.CellSearchValue(i,"spcl_cgo_auth_cd").substr(0,1) == "R"){
	    				 
		    			 if(sheetObj.CellValue(i,"apro_ref_no").replace(/^\s*/,'') == "") {		    				
		    			 	sheetObj.SelectCell(i,"apro_ref_no");	
		    			 	ComShowCodeMessage('SCG10014');	
		    			 	sheetObj.ReturnCellData(i, "spcl_cgo_auth_cd");
		    			 	//return;
		    			 }
	    			 }
	    		}
    			 
    			 
    			 if(sheetObj.CellValue(i,"spcl_cgo_auth_cd") == "N" && sheetObj.CellValue(i,"spcl_cgo_auth_rjct_cd") == "") {
    				 ComShowCodeMessage('SCG50007', 'Rejection Code');
    				 sheetObj.SelectCell(i,"spcl_cgo_auth_rjct_cd");
    				 return;
    			 }
    			 if(sheetObj.CellValue(i,"spcl_cgo_auth_cd") == "N" && sheetObj.CellValue(i,"spcl_cgo_auth_rjct_cd") == "AAA"  && sheetObj.CellValue(i,"spcl_cgo_auth_rmk") == "") {
        			 ComShowCodeMessage('SCG50007', 'Reject Remark(s)');
    				 sheetObj.SelectCell(i,"spcl_cgo_auth_rjct_cd");
    		    	 onPopupClick(sheetObj, sheetObj.id);
    				 return;
    			 }
    			 if(sheetObj.CellValue(i,"spcl_cgo_auth_cd") == "P" && sheetObj.CellValue(i,"spcl_cgo_auth_rjct_cd") == "AAA"  && sheetObj.CellValue(i,"spcl_cgo_auth_rmk") == "") {
        			 ComShowCodeMessage('SCG50007', 'Reject Remark(s)');
    				 sheetObj.SelectCell(i,"spcl_cgo_auth_rjct_cd");
    		    	 onPopupClick(sheetObj, sheetObj.id);
    				 return;
    			 }
    		 }
    	 }else if (sAction == IBSEARCH) {
    		 if (comboObjects[0].Code == "") {
				 ComShowCodeMessage('SCG50011','RSO');
    			 formObj.rgn_shp_opr_cd.focus();
    			 return;
    		 }else if(formObj.rqst_dt_range.value != ""){
    			 if(1 > formObj.rqst_dt_range.value || 300 < formObj.rqst_dt_range.value){
    				 ComShowCodeMessage('SCG50044');
	    			 formObj.rqst_dt_range.focus();
	    			 return;
    			 }
    		 }else if(formObj.rqst_dt_range.value == ""){
				 ComShowCodeMessage('SCG50044');
    			 formObj.rqst_dt_range.focus();
    			 return;
    		 }
    		 
    		 if(formObj.vps_eta_dt.value != ""){
    			 if(1 > formObj.vps_eta_dt.value || 300 < formObj.vps_eta_dt.value){
    				 ComShowCodeMessage('SCG50045');
	    			 formObj.vps_eta_dt.focus();
	    			 return;
    			 }
    		 }else if(formObj.vps_eta_dt.value == ""){
				 ComShowCodeMessage('SCG50045');
    			 formObj.vps_eta_dt.focus();
    			 return;
    		 }
    	 }else if (sAction == IBCLEAR) {
			if(sheetObj.IsDataModified) {
				var msg1 = "";
				if (formObj.tabSelectedIdx.value == "0") {
					msg1 = "DG - Part I";
				}else if (formObj.tabSelectedIdx.value == "1") {
					msg1 = "DG - Part II";
				}else if (formObj.tabSelectedIdx.value == "2") {
					msg1 = "Awkward";
				}else if (formObj.tabSelectedIdx.value == "3") {
					msg1 = "Break-Bulk";
				}else if (formObj.tabSelectedIdx.value == "4") {
					msg1 = "45'";
				}else if (formObj.tabSelectedIdx.value == "5") {
					msg1 = "Reefer";
				}
				if(ComShowCodeConfirm('SCG50003', msg1)) {
					doActionIBSheet(sheetObj,formObj,IBSAVE);
					return true;
				}
			}
    	 }
         return true;
     }

     /**
      * 승인코드에 따른 색지정 및 REJECT 코드 콤보 활성여부 설정
      */
     function setAuthStat(sheetObj, row)
     {
     	with(sheetObj)
     	{
     		var auth = CellText(row, "spcl_cgo_auth_cd").substring(0,1);
     		CellFont("FontBold", row, "spcl_cgo_auth_cd") = true;
			switch(auth)
			{
				case "R": case "S":
					CellFontColor(row, "spcl_cgo_auth_cd") = RgbColor(255, 134, 43);
					CellEditable(row, "spcl_cgo_auth_rjct_cd") = false;
					CellText(row, "apro_ref_no") = "";
					//CellEditable(row, "apro_ref_no") = false;
					break;
					
				case "Y":
					CellFontColor(row, "spcl_cgo_auth_cd") = RgbColor(77, 150, 75);
					CellText(row, "spcl_cgo_auth_rjct_cd") = "";
					CellText(row, "spcl_cgo_auth_rmk") = "";
					CellEditable(row, "spcl_cgo_auth_rjct_cd") = false;
					//if (CellText(row, "crr_cd") != "SML") {
					//	CellEditable(row, "apro_ref_no") = true;
					//}
					break;
					
				case "N":
					CellFontColor(row, "spcl_cgo_auth_cd") = RgbColor(255, 0, 0);
					CellEditable(row, "spcl_cgo_auth_rjct_cd") = true;
					CellText(row, "apro_ref_no") = "";
					//CellEditable(row, "apro_ref_no") = false;
					break;
					
				case "P":
					CellFontColor(row, "spcl_cgo_auth_cd") = RgbColor(38, 99, 224);
					CellEditable(row, "spcl_cgo_auth_rjct_cd") = true;
					CellText(row, "apro_ref_no") = "";
					//CellEditable(row, "apro_ref_no") = false;
					break;
			}
			
     		var rjctCd = CellText(row, "spcl_cgo_auth_rjct_cd");
			switch(rjctCd)
			{
				default:
					CellFontColor(row, "spcl_cgo_auth_rjct_cd") = RgbColor(255, 0, 0);
					break;
			}
     	}
     }
     
     //Box for SML VSL Color 처리
     function setHjsBox(sheetObj) {
    	 var formObj = document.form;
    	 switch(sheetObj.id)
    	 {
    	 	case "t1sheet1":
    	 		formObj = formObj.t1HjsBox;
				break;
			case "t2sheet1":
				formObj = formObj.t2HjsBox;
				break;
			case "t3sheet1":
				formObj = formObj.t3HjsBox;
				break;
			case "t4sheet1":
				formObj = formObj.t4HjsBox;
				break;
			case "t5sheet1":
				formObj = formObj.t5HjsBox;
				break;
			case "t6sheet1":
				formObj = formObj.t6HjsBox;
				break;
    	 }

		 for (var i = 2; i <= sheetObj.LastRow; i ++) {
			 if (formObj.checked == true && "SML" == sheetObj.CellText(i, "crr_cd")) {
				 sheetObj.RowBackColor(i)  = sheetObj.RgbColor(255, 255, 200); //
			 }else{
				 sheetObj.RowBackColor(i)  = sheetObj.RgbColor(255, 255, 255); //				 
			 }
		 }
     }

     function t1sheet1_OnSelectMenu(sheetObj, sAction){
    	 var sColStr = sheetObj.GetSelectionCols("|");
    	 //자바 스크립트 배열로 만들기
    	 var arr = sColStr.split("|");

    	 with(sheetObj) {
    		 switch(sAction) {
    		 	case "컬럼 삭제" :
    		 		for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = true;
	    			}
	        		break;
	    		case "컬럼 삭제 취소" :
	    			for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = false;
	    			}
	        		break;
	        	case "전체 삭제 취소" :
	        		for(var idx=0; idx<=LastCol; idx++) {
 	        			if (idx!=2 && idx!=12 && idx < 33 ) {
 	        				ColHidden(idx) = false;
 	        			}
	        		}
	        		break;
	    	}
    	}    	 
     }

     function t2sheet1_OnSelectMenu(sheetObj, sAction){
    	 var sColStr = sheetObj.GetSelectionCols("|");
    	 //자바 스크립트 배열로 만들기
    	 var arr = sColStr.split("|");

    	 with(sheetObj) {
    		 switch(sAction) {
	    		case "컬럼 삭제" :
	    			for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = true;
	    			}
	        		break;
	    		case "컬럼 삭제 취소" :
	    			for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = false;
	    			}
	        		break;
	        	case "전체 삭제 취소" :
	        		for(var idx=0; idx<=LastCol; idx++) {
 	        			if (idx!=2 && idx!=12 && idx < 33 ) {
 	        				ColHidden(idx) = false;
 	        			}
	        		}
	        		break;
 	    	}
     	}    	 
      }

     function t3sheet1_OnSelectMenu(sheetObj, sAction){
    	 var sColStr = sheetObj.GetSelectionCols("|");
    	 //자바 스크립트 배열로 만들기
    	 var arr = sColStr.split("|");

      	with(sheetObj) {
 	    	switch(sAction) {
	    		case "컬럼 삭제" :
	    			for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = true;
	    			}
	        		break;
	    		case "컬럼 삭제 취소" :
	    			for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = false;
	    			}
	        		break;
 	        	case "전체 삭제 취소" :
 	        		for(var idx=0; idx<=LastCol; idx++) {
 	        			if (idx!=2 && idx!=12 && idx < 31) {
 	        				ColHidden(idx) = false;
 	        			}
 	        		}
 	        		break;
 	    	}
     	}    	 
      }

     function t4sheet1_OnSelectMenu(sheetObj, sAction){
    	 var sColStr = sheetObj.GetSelectionCols("|");
    	 //자바 스크립트 배열로 만들기
    	 var arr = sColStr.split("|");

      	with(sheetObj) {
 	    	switch(sAction) {
	    		case "컬럼 삭제" :
	    			for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = true;
	    			}
	        		break;
	    		case "컬럼 삭제 취소" :
	    			for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = false;
	    			}
	        		break;
 	        	case "전체 삭제 취소" :
 	        		for(var idx=0; idx<=LastCol; idx++) {
 	        			if (idx!=2 && idx!=12 && idx < 24) {
 	        				ColHidden(idx) = false;
 	        			}
 	        		}
 	        		break;
 	    	}
     	}
      }

     function t5sheet1_OnSelectMenu(sheetObj, sAction){
    	 var sColStr = sheetObj.GetSelectionCols("|");
    	 //자바 스크립트 배열로 만들기
    	 var arr = sColStr.split("|");

    	 with(sheetObj) {
    		 switch(sAction) {
    		 	case "컬럼 삭제" :
    		 		for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = true;
	    			}
	        		break;
	    		case "컬럼 삭제 취소" :
	    			for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = false;
	    			}
	        		break;
 	        	case "전체 삭제 취소" :
 	        		for(var idx=0; idx<=LastCol; idx++) {
 	        			if (idx!=2 && idx!=12 && idx < 23) {
 	        				ColHidden(idx) = false;
 	        			}
 	        		}
 	        		break;
    		 }
    	 }
     }

     function t6sheet1_OnSelectMenu(sheetObj, sAction){
    	 var sColStr = sheetObj.GetSelectionCols("|");
    	 //자바 스크립트 배열로 만들기
    	 var arr = sColStr.split("|");

    	 with(sheetObj) {
    		 switch(sAction) {
    		 	case "컬럼 삭제" :
    		 		for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = true;
	    			}
	        		break;
	    		case "컬럼 삭제 취소" :
	    			for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = false;
	    			}
	        		break;
 	        	case "전체 삭제 취소" :
 	        		for(var idx=0; idx<=LastCol; idx++) {
 	        			if (idx!=2 && idx!=12 && idx < 25) {
 	        				ColHidden(idx) = false;
 	        			}
 	        		}
 	        		break;
 	    	}
    	 }    	 
     }

     function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 var j = 0;
    		 var befBkgNo = "";
    		 var befVVD = "";
    		 for (var i=2; i <= LastRow; i++)
    		 {
    			 setAuthStat(sheetObj, i);
    			 if (befBkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    				 CellText(i, "num") = j;
    			 }else{
    				 j++;
    				 CellText(i, "num") = j;
    			 }
    			 befBkgNo = CellText(i, "bkg_no");
    			 befVVD	  = CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd");	
    		 }
    		 //Box for SML VSL 처리
			 setHjsBox(sheetObj);
			 if(RowCount != 0) ComBtnEnable("btn_t1ApplDetails");
    	 }
     }
     
     function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 var j = 0;
    		 var befBkgNo = "";
    		 var befVVD = "";
    		 for (var i = 2; i <= LastRow; i ++)
    		 {
    			 setAuthStat(sheetObj, i);
    			 if (befBkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    				 CellText(i, "num") = j;
    			 }else{
    				 j++;
    				 CellText(i, "num") = j;
    			 }
    			 befBkgNo = CellText(i, "bkg_no");
    			 befVVD	  = CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd");	
    		 }
    		 //Box for SML VSL 처리
			 setHjsBox(sheetObj);
			 if(RowCount != 0) ComBtnEnable("btn_t2ApplDetails");
    	 }
     }

     function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 var j = 0;
    		 var befBkgNo = "";
    		 var befVVD = "";
    		 for (var i = 2; i <= LastRow; i ++)
    		 {
    			 setAuthStat(sheetObj, i);
    			 if (befBkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    				 CellText(i, "num") = j;
    			 }else{
    				 j++;
    				 CellText(i, "num") = j;
    			 }
    			 befBkgNo = CellText(i, "bkg_no");
    			 befVVD	  = CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd");	
    		 }
    		 //Box for HJS VSL 처리
			 setHjsBox(sheetObj);
			 if(RowCount != 0) ComBtnEnable("btn_t3ApplDetails");
    	 }
     }

     function t4sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 var j = 0;
    		 var befBkgNo = "";
    		 var befVVD = "";
    		 for (var i = 2; i <= LastRow; i ++)
    		 {
    			 setAuthStat(sheetObj, i);
    			 if (befBkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    				 CellText(i, "num") = j;
    			 }else{
    				 j++;
    				 CellText(i, "num") = j;
    			 }
    			 befBkgNo = CellText(i, "bkg_no");
    			 befVVD	  = CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd");	
    		 }
    		 //Box for HJS VSL 처리
			 setHjsBox(sheetObj);
			 if(RowCount != 0) ComBtnEnable("btn_t4ApplDetails");
    	 }
     }

     function t5sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 var j = 0;
    		 var befBkgNo = "";
    		 var befVVD = "";
    		 for (var i = 2; i <= LastRow; i ++)
    		 {
    			 setAuthStat(sheetObj, i);
    			 if (befBkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    				 CellText(i, "num") = j;
    			 }else{
    				 j++;
    				 CellText(i, "num") = j;
    			 }
    			 befBkgNo = CellText(i, "bkg_no");
    			 befVVD	  = CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd");	
    		 }
    		 //Box for HJS VSL 처리
			 setHjsBox(sheetObj);
			 if(RowCount != 0) ComBtnEnable("btn_t5ApplDetails");
    	 }
     }

     function t6sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 var j = 0;
    		 var befBkgNo = "";
    		 var befVVD = "";
    		 for (var i = 2; i <= LastRow; i ++)
    		 {
    			 setAuthStat(sheetObj, i);
    			 if (befBkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    				 CellText(i, "num") = j;
    			 }else{
    				 j++;
    				 CellText(i, "num") = j;
    			 }
    			 befBkgNo = CellText(i, "bkg_no");
    			 befVVD	  = CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd");	
    			 
    			 //오리지날 상태값 유지 - 메일 구분해서 보내기 위해
    			 CellValue2(i, "org_spcl_cgo_auth_cd") = CellValue(i, "spcl_cgo_auth_cd");
    			 RowStatus(i) = "R";
    		 }
    		 //Box for HJS VSL 처리
			 setHjsBox(sheetObj);
			 if(RowCount != 0) ComBtnEnable("btn_t6ApplDetails");
    	 }
     }

     function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) 
     {
		 setHjsBox(sheetObj);
		 sheetObj.RowBackColor(NewRow)  = sheetObj.RgbColor(231, 250, 246); //
     }
     
     function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) 
     {
		 setHjsBox(sheetObj);
		 sheetObj.RowBackColor(NewRow)  = sheetObj.RgbColor(231, 250, 246); //
     }
     
     function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) 
     {
		 setHjsBox(sheetObj);
		 sheetObj.RowBackColor(NewRow)  = sheetObj.RgbColor(231, 250, 246); //
     }
     
     function t4sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) 
     {
		 setHjsBox(sheetObj);
		 sheetObj.RowBackColor(NewRow)  = sheetObj.RgbColor(231, 250, 246); //
     }
     
     function t5sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) 
     {
		 setHjsBox(sheetObj);
		 sheetObj.RowBackColor(NewRow)  = sheetObj.RgbColor(231, 250, 246); //
     }
     
     function t6sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) 
     {
		 setHjsBox(sheetObj);
		 sheetObj.RowBackColor(NewRow)  = sheetObj.RgbColor(231, 250, 246); //
     }
     
     function t1sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
    		 	case "spcl_cgo_auth_cd":
    		 		auth_cd = CellText(Row, "spcl_cgo_auth_cd");
    		 		sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "spcl_cgo_auth_cd", "");      			
    		 		sheetObj.InitDataCombo(0, "spcl_cgo_auth_cd", "Y|Y(all)|N|P", "Y|A|N|P");
    		 		break;
    		 	case "apro_ref_no":
    		 		if (CellText(Row, "spcl_cgo_auth_cd") == "Y" && CellText(Row, "crr_code") != "SML") {
    		 			ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
    		 		}
    		 		break;
    		 }
    	 }
     }

     function t2sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
	    		 case "spcl_cgo_auth_cd":
	    			 sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "spcl_cgo_auth_cd", "");      			
	    			 sheetObj.InitDataCombo(0, "spcl_cgo_auth_cd", "Y|Y(all)|N|P", "Y|A|N|P");
	    			 break;
	    		 case "apro_ref_no":
	    			 if (CellText(Row, "spcl_cgo_auth_cd") == "Y" && CellText(Row, "crr_code") != "SML") {
	    				 ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	    			 }
	    			 break;
    		 }
    	 }
     }

     function t3sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
	    		 case "spcl_cgo_auth_cd":
	      			sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "spcl_cgo_auth_cd", "");      			
	      			sheetObj.InitDataCombo(0, "spcl_cgo_auth_cd", "Y|Y(all)|N|P", "Y|A|N|P");
	      			break;
	    		 case "apro_ref_no":
	    			 if (CellText(Row, "spcl_cgo_auth_cd") == "Y" && CellText(Row, "crr_code") != "SML") {
	    				 ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	    			 }
	    			 break;
    		 }
    	 }
     }

     function t4sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
	    		 case "spcl_cgo_auth_cd":
	      			sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "spcl_cgo_auth_cd", "");      			
	      			sheetObj.InitDataCombo(0, "spcl_cgo_auth_cd", "Y|Y(all)|N|P", "Y|A|N|P");
	      			break;
	    		 case "apro_ref_no":
	    			 if (CellText(Row, "spcl_cgo_auth_cd") == "Y" && CellText(Row, "crr_code") != "SML") {
	    				 ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	    			 }
	    			 break;
    		 }
    	 }
     }

     function t5sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
	    		 case "spcl_cgo_auth_cd":
	      			sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "spcl_cgo_auth_cd", "");      			
	      			sheetObj.InitDataCombo(0, "spcl_cgo_auth_cd", "Y|Y(all)|N|P", "Y|A|N|P");
	      			break;
	    		 case "apro_ref_no":
	    			 if (CellText(Row, "spcl_cgo_auth_cd") == "Y") {
	    				 ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	    			 }
	    			 break;
    		 }
    	 }
     }

     function t6sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
	    		 case "spcl_cgo_auth_cd":
	      			sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "spcl_cgo_auth_cd", "");      			
	      			sheetObj.InitDataCombo(0, "spcl_cgo_auth_cd", "Y|Y(all)|N|P", "Y|A|N|P");
	      			break;
	    		 case "apro_ref_no":
	    			 if (CellText(Row, "spcl_cgo_auth_cd") == "Y") {
	    				 ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	    			 }
	    			 break;
    		 }
    	 }
     }

     function t1sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t1ApplDetails");
     }
     
     function t2sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t2ApplDetails");
     }
     
     function t3sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t3ApplDetails");
     }
     
     function t4sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t4ApplDetails");
     }
     
     function t5sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t5ApplDetails");
     }
     
     function t6sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t6ApplDetails");
     }
     
     function t1sheet1_OnChange(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
    			 if (CellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo  = CellText(Row, "bkg_no");
    				 var befVVD	= CellText(Row, "vsl_cd")+CellText(Row, "skd_voy_no")+CellText(Row, "skd_dir_cd");	
    				 var authNo = CellText(Row, "apro_ref_no");
    	    		 for (var i = 2; i <= LastRow; i ++)
    	    		 {
    	    			 if (bkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    	    				 CellValue(i, "spcl_cgo_auth_cd") = "Y";
    	    				 CellValue(i, "apro_ref_no") = authNo;
    	    				 setAuthStat(sheetObj, i);
    	    			 }
    	    		 }
    			 }else if (CellValue(Row, "spcl_cgo_auth_cd") == "Y") {
    				 //Net Weight 값 산출
    				 if (CellValue(Row, "net_wgt_sum") != '' && CellValue(Row, "net_wgt_sum") > 0 && (CellValue(Row, "psa_no") == "1" || CellValue(Row, "flsh_pnt_cdo_temp") < -25)) {
    					 if (ComShowCodeConfirm('SCG50022', 
    							 CellText(Row, "net_wgt_sum"),
    							 sheetObj.CellValue(Row, "imdg_clss_cd")+" of "+sheetObj.CellValue(Row, "vsl_cd")+sheetObj.CellValue(Row, "skd_voy_no")+sheetObj.CellValue(Row, "skd_dir_cd"),
    							 CellText(Row, "net_wgt") )) {    						 
    					 }else{
    						 sheetObj.CellValue2(sheetObj.SelectRow, "spcl_cgo_auth_cd") = auth_cd;
    					 }
    				 }
    				 setAuthStat(sheetObj, Row);
    				 return;
    			 }else{
    				 setAuthStat(sheetObj, Row);
    			 }
    			 break;
    			 
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode = GetComboInfo(Row, Col, "Code");
    			 var arrCode = sCode.split("|");
    			 var j = 0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 CellValue2(Row, "spcl_cgo_auth_rjct_cd") = "";
					 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm = "";
	    			 if (CellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 arrRjctCdNm = arrRjctNmDG.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == CellValue(Row, "spcl_cgo_auth_rjct_cd")) {
	    						 CellValue2(Row, "spcl_cgo_auth_rmk") = arrRjctCdNm[i].split("\t")[1];
	    					 }
	    				 }
	    			 }else if (CellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
						 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
	    			 }
				 }
    			 break;
    		 }
    	 }
     }

     function t2sheet1_OnChange(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
    			 if (CellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo  = CellText(Row, "bkg_no");
    				 var befVVD	= CellText(Row, "vsl_cd")+CellText(Row, "skd_voy_no")+CellText(Row, "skd_dir_cd");	
    				 var authNo = CellText(Row, "apro_ref_no");
    	    		 for (var i = 2; i <= LastRow; i ++)
    	    		 {
    	    			 if (bkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    	    				 CellValue(i, "spcl_cgo_auth_cd") = "Y";
    	    				 CellValue(i, "apro_ref_no") = authNo;
    	    				 setAuthStat(sheetObj, i);
    	    			 }
    	    		 }
    			 }else{
    				 setAuthStat(sheetObj, Row);
    			 }
    			 break;
    			 
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode = GetComboInfo(Row, Col, "Code");
    			 var arrCode = sCode.split("|");
    			 var j = 0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 CellValue2(Row, "spcl_cgo_auth_rjct_cd") = "";
					 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm = "";
	    			 if (CellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 arrRjctCdNm = arrRjctNmDG.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == CellValue(Row, "spcl_cgo_auth_rjct_cd")) {
	    						 CellValue2(Row, "spcl_cgo_auth_rmk") = arrRjctCdNm[i].split("\t")[1];
	    					 }
	    				 }
	    			 }else if (CellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
						 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
	    			 }
				 }
    			 break;
    		 }
    	 }
     }

     function t3sheet1_OnChange(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
    			 if (CellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo  = CellText(Row, "bkg_no");
    				 var befVVD	= CellText(Row, "vsl_cd")+CellText(Row, "skd_voy_no")+CellText(Row, "skd_dir_cd");	
    				 var authNo = CellText(Row, "apro_ref_no");
    	    		 for (var i = 2; i <= LastRow; i ++)
    	    		 {
       	    			 if (bkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    	    				 CellValue(i, "spcl_cgo_auth_cd") = "Y";
    	    				 CellValue(i, "apro_ref_no") = authNo;
    	    				 setAuthStat(sheetObj, i);
    	    			 }
    	    		 }
    			 }else{
    				 setAuthStat(sheetObj, Row);
    			 }
    			 break;
    			 
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode = GetComboInfo(Row, Col, "Code");
    			 var arrCode = sCode.split("|");
    			 var j = 0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 CellValue2(Row, "spcl_cgo_auth_rjct_cd") = "";
					 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm = "";
	    			 if (CellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 arrRjctCdNm = arrRjctNmAK.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == CellValue(Row, "spcl_cgo_auth_rjct_cd")) {
	    						 CellValue2(Row, "spcl_cgo_auth_rmk") = arrRjctCdNm[i].split("\t")[1];
	    					 }
	    				 }
	    			 }else if (CellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
						 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
	    			 }
				 }
    			 break;
    		 }
    	 }
     }

     function t4sheet1_OnChange(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
    			 if (CellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo 	= CellText(Row, "bkg_no");
    				 var befVVD = CellText(Row, "vsl_cd")+CellText(Row, "skd_voy_no")+CellText(Row, "skd_dir_cd");	
    				 var authNo = CellText(Row, "apro_ref_no");
    	    		 for (var i = 2; i <= LastRow; i ++)
    	    		 {
       	    			 if (bkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    	    				 CellValue(i, "spcl_cgo_auth_cd") = "Y";
    	    				 CellValue(i, "apro_ref_no") = authNo;
    	    				 setAuthStat(sheetObj, i);
    	    			 }
    	    		 }
    			 }else{
    				 setAuthStat(sheetObj, Row);
    			 }
    			 break;
    			 
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode = GetComboInfo(Row, Col, "Code");
    			 var arrCode = sCode.split("|");
    			 var j = 0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 CellValue2(Row, "spcl_cgo_auth_rjct_cd") = "";
					 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm = "";
	    			 if (CellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 arrRjctCdNm = arrRjctNmBB.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == CellValue(Row, "spcl_cgo_auth_rjct_cd")) {
	    						 CellValue2(Row, "spcl_cgo_auth_rmk") = arrRjctCdNm[i].split("\t")[1];
	    					 }
	    				 }
	    			 }else if (CellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
						 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
	    			 }
				 }
    			 break;
    		 }
    	 }
     }

     function t5sheet1_OnChange(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
    			 if (CellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo  = CellText(Row, "bkg_no");
    				 var befVVD = CellText(Row, "vsl_cd")+CellText(Row, "skd_voy_no")+CellText(Row, "skd_dir_cd");	
    				 var authNo = CellText(Row, "apro_ref_no");
    	    		 for (var i = 2; i <= LastRow; i ++)
    	    		 {
    	    			 if (bkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    	    				 CellValue(i, "spcl_cgo_auth_cd") = "Y";
    	    				 CellValue(i, "apro_ref_no") = authNo;
    	    				 setAuthStat(sheetObj, i);
    	    			 }
    	    		 }
    			 }else{
    				 setAuthStat(sheetObj, Row);
    			 }
    			 break;
    			 
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode = GetComboInfo(Row, Col, "Code");
    			 var arrCode = sCode.split("|");
    			 var j = 0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 CellValue2(Row, "spcl_cgo_auth_rjct_cd") = "";
					 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm = "";
	    			 if (CellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 arrRjctCdNm = arrRjctNmAK.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == CellValue(Row, "spcl_cgo_auth_rjct_cd")) {
	    						 CellValue2(Row, "spcl_cgo_auth_rmk") = arrRjctCdNm[i].split("\t")[1];
	    					 }
	    				 }
	    			 }else if (CellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
						 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
	    			 }
				 }
    			 break;
    		 }
    	 }
     }

     function t6sheet1_OnChange(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
    			 if (CellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo  = CellText(Row, "bkg_no");
    				 var befVVD = CellText(Row, "vsl_cd")+CellText(Row, "skd_voy_no")+CellText(Row, "skd_dir_cd");	
    				 var authNo = CellText(Row, "apro_ref_no");
    	    		 for (var i = 2; i <= LastRow; i ++)
    	    		 {
       	    			 if (bkgNo == CellText(i, "bkg_no") && befVVD == CellText(i, "vsl_cd")+CellText(i, "skd_voy_no")+CellText(i, "skd_dir_cd")) {
    	    				 CellValue(i, "spcl_cgo_auth_cd") = "Y";
    	    				 CellValue(i, "apro_ref_no") = authNo;
    	    				 setAuthStat(sheetObj, i);
    	    			 }
    	    		 }
    			 }else{
    				 setAuthStat(sheetObj, Row);
    			 }
    			 break;
    			 
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode = GetComboInfo(Row, Col, "Code");
    			 var arrCode = sCode.split("|");
    			 var j = 0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 CellValue2(Row, "spcl_cgo_auth_rjct_cd") = "";
					 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm = "";
	    			 if (CellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 arrRjctCdNm = arrRjctNmRF.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == CellValue(Row, "spcl_cgo_auth_rjct_cd")) {
	    						 CellValue2(Row, "spcl_cgo_auth_rmk") = arrRjctCdNm[i].split("\t")[1];
	    					 }
	    				 }
	    			 }else if (CellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
						 CellValue2(Row, "spcl_cgo_auth_rmk") = "";
	    			 }
				 }
    			 break;
    		 }
    	 }
     }
     
     function laneSheet_OnChange(sheetObj , Row, Col, Value){
     	
		if(!Value || Value==""){
			return false;
		}
//		alert(sheetObj.CellValue(Row, Col));
		var formObj = document.form;
		var datarow = Row - sheetObj.HeaderRows; // row는 DataRow 상의 위치
		if(sheetObj.CellValue(Row, Col).length == 3){
			formObj.vsl_slan_cd.value = Value;
			// 이미 입력한 lane code인지 확인
			for(var i=0; i<Col; i++){
				if(Value == sheetObj.CellValue(Row, i)){
					ComShowCodeMessage('SCG50005', Value);
					sheetObj.SelectCell(Row, Col);
		        	sheetObj.CellValue2(Row, Col) = "";
		        	return false;
				}
			}
				
			var laneInfo = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
			if(laneInfo.vslSlanCd && laneInfo.vslSlanCd!=""){
				sheetObj.ToolTipText(Row, Col) = laneInfo.vslSlanCd;
				if(Col == 14){
					sheetObj.SelectCell(Row, Col, false);
				}else if(Col == 15){
					
				}else{
					sheetObj.SelectCell(Row, Col+1);
				}
			}else{
				alert(Value + " is not target lane");
				if(Col < 15){
					sheetObj.SelectCell(Row, Col);
				}else{
					sheetObj.SelectCell(Row, Col-1, false);
				}
				sheetObj.CellValue2(Row, Col) = "";
			}
		}
		
	}

     /**
      * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
      **/
     function obj_keypress(){

    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
    		case "engup":
    			//영문 대문자 만입력하기
    			ComKeyOnlyAlphabet('upper');
    			break;
    		case "uppernum":
    			//영문 대문자 만입력하기
    			ComKeyOnlyAlphabet('uppernum');
    			break;
		}
     }

     function obj_keyup(){
    	 ComKeyEnter('LengthNextFocus');
    	 var formObj = document.form;
     }
     
     function obj_blur() {
    	 var formObj = document.form;
    	 switch(event.srcElement.name){
    	 	case "slan_cd1": case "slan_cd2": case "slan_cd3": case "slan_cd4": case "slan_cd5": case "slan_cd6": case "slan_cd7": case "slan_cd8": case "slan_cd9": case "slan_cd10": case "slan_cd11":
    	 		var sInt = event.srcElement.name.substring(event.srcElement.name.length-1, event.srcElement.name.length);
    	 		var sLen = eval("formObj.slan_cd"+sInt+".value.length");
    	 		if (sLen == 3) {
    	 			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
    	 		}else if (sLen != 0) {
         			ComShowCodeMessage('SCG50006',"Lane Code"+sInt, "3");
         			event.srcElement.focus();
         	     	event.srcElement.select();
    	    		return false;
    	 		}
    	 		break;
    	 		
    	 	case "vsl_cd":
    	 		var sLen = formObj.vsl_cd.value.length;
    	 		if (sLen == 4) {
    	 			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC04);
    	 		}else if (sLen != 0) {
         			ComShowCodeMessage('SCG50006',"Vessel Code", "4");
         			event.srcElement.focus();
         			event.srcElement.select();
    	    		return false;
    	 		}
    	 		break;
    	 }
     }
     
     function obj_click() {
    	 setHjsBox(sheetObjects[tabIndex+1]);
     }

     /**
      * IBSheet Object에서 팝업을 클릭시
      */
     function onPopupClick(srcName, srcType){
    	 if (srcType == "Lane") {
    		 var objName = "btn_SlanCd";
    		 var sInt;
    		 if (srcName.indexOf(objName) > -1) {
    			 sInt = srcName.substring(objName.length, srcName.length);
    		 }else{
    			 sInt = srcName.substring(srcName.length-1, srcName.length);
    		 }
    		 ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do', 426, 480, "sheet1_vsl_slan_cd:slan_cd"+sInt, "0,0", true);
    	 }else if (srcType == "Vessel") {
    		 ComOpenPopupWithTarget('/hanjin/VOP_VSK_0219.do?op=0219', 463, 500, "vsl_cd:vsl_cd", "0,0", true);
    	 }else if (srcType == "t1ApplDetails" || srcType == "t1sheet1") {
    		 if (sheetObjects[1].SelectRow < 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 auth_cd = sheetObjects[1].CellText(sheetObjects[1].SelectRow, "spcl_cgo_auth_cd");
    			 ComOpenPopup("VOP_SCG_0015.do?type=O&scg_flg=DG1&bkg_no="+sheetObjects[1].CellText(sheetObjects[1].SelectRow, "bkg_no")+"&vvd_cd="+sheetObjects[1].CellText(sheetObjects[1].SelectRow, "vsl_cd")+sheetObjects[1].CellText(sheetObjects[1].SelectRow, "skd_voy_no")+sheetObjects[1].CellText(sheetObjects[1].SelectRow, "skd_dir_cd")+"&dg_cntr_seq="+sheetObjects[1].CellText(sheetObjects[1].SelectRow, "dg_cntr_seq")+"&cntr_cgo_seq="+sheetObjects[1].CellText(sheetObjects[1].SelectRow, "cntr_cgo_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[1].CellText(sheetObjects[1].SelectRow, "spcl_cgo_apro_rqst_seq"), 1023, 660, "", '0,0', true, false, sheetObjects[1].SelectRow, 0, 0, "VOP_SCG_0015");
    			 }
    	 }else if (srcType == "t2ApplDetails" || srcType == "t2sheet1") {
    		 if (sheetObjects[2].SelectRow < 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    		 	 ComOpenPopup("VOP_SCG_0015.do?type=O&scg_flg=DG2&bkg_no="+sheetObjects[2].CellText(sheetObjects[2].SelectRow, "bkg_no")+"&vvd_cd="+sheetObjects[2].CellText(sheetObjects[2].SelectRow, "vsl_cd")+sheetObjects[2].CellText(sheetObjects[2].SelectRow, "skd_voy_no")+sheetObjects[2].CellText(sheetObjects[2].SelectRow, "skd_dir_cd")+"&dg_cntr_seq="+sheetObjects[2].CellText(sheetObjects[2].SelectRow, "dg_cntr_seq")+"&cntr_cgo_seq="+sheetObjects[2].CellText(sheetObjects[2].SelectRow, "cntr_cgo_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[2].CellText(sheetObjects[2].SelectRow, "spcl_cgo_apro_rqst_seq"), 1023, 660, "", '0,0', true, false, sheetObjects[2].SelectRow, 0, 1, "VOP_SCG_0015");
    		 }
    	 }else if (srcType == "t3ApplDetails" || srcType == "t3sheet1") {
    		 if (sheetObjects[3].SelectRow < 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 ComOpenPopup("VOP_SCG_0016.do?type=O&scg_flg=AWK&bkg_no="+sheetObjects[3].CellText(sheetObjects[3].SelectRow, "bkg_no")+"&vvd_cd="+sheetObjects[3].CellText(sheetObjects[3].SelectRow, "vsl_cd")+sheetObjects[3].CellText(sheetObjects[3].SelectRow, "skd_voy_no")+sheetObjects[3].CellText(sheetObjects[3].SelectRow, "skd_dir_cd")+"&awk_cgo_seq="+sheetObjects[3].CellText(sheetObjects[3].SelectRow, "awk_cgo_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[3].CellText(sheetObjects[3].SelectRow, "spcl_cgo_apro_rqst_seq"), 1023, 640, "", '0,0', true, false, sheetObjects[3].SelectRow, 0, 2, "VOP_SCG_0016");
    		 }
    	 }else if (srcType == "t4ApplDetails" || srcType == "t4sheet1") {
    		 if (sheetObjects[4].SelectRow < 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 ComOpenPopup("VOP_SCG_0017.do?type=O&scg_flg=BB&bkg_no="+sheetObjects[4].CellText(sheetObjects[4].SelectRow, "bkg_no")+"&vvd_cd="+sheetObjects[4].CellText(sheetObjects[4].SelectRow, "vsl_cd")+sheetObjects[4].CellText(sheetObjects[4].SelectRow, "skd_voy_no")+sheetObjects[4].CellText(sheetObjects[4].SelectRow, "skd_dir_cd")+"&bb_cgo_seq="+sheetObjects[4].CellText(sheetObjects[4].SelectRow, "bb_cgo_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[4].CellText(sheetObjects[4].SelectRow, "spcl_cgo_apro_rqst_seq"), 1023, 640, "", '0,0', true, false, sheetObjects[4].SelectRow, 0, 3, "VOP_SCG_0017");
    		 }
    	 }else if (srcType == "t5ApplDetails" || srcType == "t5sheet1") {
    		 if (sheetObjects[5].SelectRow < 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 ComOpenPopup("VOP_SCG_0016.do?type=O&scg_flg=45&bkg_no="+sheetObjects[5].CellText(sheetObjects[5].SelectRow, "bkg_no")+"&vvd_cd="+sheetObjects[5].CellText(sheetObjects[5].SelectRow, "vsl_cd")+sheetObjects[5].CellText(sheetObjects[5].SelectRow, "skd_voy_no")+sheetObjects[5].CellText(sheetObjects[5].SelectRow, "skd_dir_cd")+"&awk_cgo_seq="+sheetObjects[5].CellText(sheetObjects[5].SelectRow, "awk_cgo_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[5].CellText(sheetObjects[5].SelectRow, "spcl_cgo_apro_rqst_seq"), 1023, 627, "", '0,0', true, false, sheetObjects[5].SelectRow, 0, 4, "VOP_SCG_0016");
    		 }
    	 }else if (srcType == "t6ApplDetails" || srcType == "t6sheet1") {
    		 if (sheetObjects[6].SelectRow < 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 ComOpenPopup("VOP_SCG_0018.do?type=O&scg_flg=RF&bkg_no="+sheetObjects[6].CellText(sheetObjects[6].SelectRow, "bkg_no")+"&vvd_cd="+sheetObjects[6].CellText(sheetObjects[6].SelectRow, "vsl_cd")+sheetObjects[6].CellText(sheetObjects[6].SelectRow, "skd_voy_no")+sheetObjects[6].CellText(sheetObjects[6].SelectRow, "skd_dir_cd")+"&rc_seq="+sheetObjects[6].CellText(sheetObjects[6].SelectRow, "rc_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[6].CellText(sheetObjects[6].SelectRow, "spcl_cgo_apro_rqst_seq"), 1023, 600, "", '0,0', true, false, sheetObjects[6].SelectRow, 0, 5, "VOP_SCG_0018");
    		 }
    	 }
     }

     function clearAll() {
    	 var formObj = document.form;
    	 formObj.reset();
    	 sheetObjects[0].RemoveAll();
    	 sheetObjects[1].RemoveAll();
    	 sheetObjects[2].RemoveAll();
    	 sheetObjects[3].RemoveAll();
    	 sheetObjects[4].RemoveAll();
    	 sheetObjects[5].RemoveAll();
    	 sheetObjects[6].RemoveAll();
//    	 checkPostEta();
    	 formObj.rqst_dt_range.value = "15";
    	 formObj.vps_eta_dt.value = "30";
     }
 	 	
//  	function checkPostEta(){
// 		var formObj = document.form;
// 		if (formObj.from_eta_flg.checked == true) {
//    		document.getElementById("from_eta_dt").disabled = false;
// 			document.getElementById("from_eta_dt").className = "input1";
//    		document.getElementById("from_eta_dt").value = "10";
// 		}else{
//    		document.getElementById("from_eta_dt").disabled = true;
// 			document.getElementById("from_eta_dt").className = "input2";
//    		document.getElementById("from_eta_dt").value = "";
// 		}
// 	}
 	

 	function laneSheet_OnKeyUp(sheetObj, Row, Col, Value){
 		//2012.07.31 2011514 조경완 Max Length 되었을때 이벤트 수정
		if(sheetObj.EditText.length == 3){
			if(Col != 15){
				sheetObj.SelectCell(Row, Col, false);
			}else{
				sheetObj.SelectCell(Row, Col-1, false);
			}
		}
    }
    
     
     /* 개발자 작업  끝 */