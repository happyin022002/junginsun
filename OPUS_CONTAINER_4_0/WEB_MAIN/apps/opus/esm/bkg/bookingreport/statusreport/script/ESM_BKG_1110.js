/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1110.js
*@FileTitle : EIR Exchange & Customs Release Check Report
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.01
*@LastModifier : 이재위
*@LastVersion : 1.0
* 2010.09.01 이재위
* 1.0 Creation 
* --------------------------------------------------------
* History
* 2010.10.29 이일민 [xxxxxxxxxx] Sort시 일련번호, no data 시트 표시
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author CLT
     */

    /**
     * @extends 
     * @class esm_bkg_1110 : esm_bkg_1110 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1110() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
 // 공통전역변수

//    var tabObjects = new Array();
//    var tabCnt = 0 ;
//    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var rowsPerPage = 999999;

    var comboObjects = new Array();
    var combo1 = null;
    var comboCnt = 0;
    
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
//             var sheetObject1 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");
        		
                switch(srcName) {
    						
    					case "btn_EQHistory":
    						var srow =sheetObject.SelectRow;
    						var tmp = sheetObject.CellValue(srow, "cntr_no");
    						
    						if (tmp == "" || tmp.length != 11 ){
    							ComShowCodeMessage('BKG40055');
    							return;
    						}
    						
    						var cntrNo = (tmp != null && tmp.length>10) ? tmp.substring(0,10) : tmp;;
    	                    var checkDigit = (tmp != null && tmp.length>10) ? tmp.substring(10) : '';
    						var typeSize = sheetObject.CellValue(srow, "cntr_tpsz_cd");
    						
    						var url = "EES_CTM_0411.do?func=&cntrNo="+cntrNo+"&checkDigit="+checkDigit+"&typeSize="+typeSize;
    						ComOpenWindowCenter(url, "EES_CTM_0411", 1010, 650, false);
    						break;
    					case "btn_COP" :

							var srow =sheetObject.SelectRow;
							var tmp = sheetObject.CellValue(srow, "cntr_no");
							
							if (tmp == "" || tmp.length != 11 ){
								ComShowCodeMessage('BKG40055');
								return;
							}
							
							var cntr_no = sheetObject.CellValue(srow, "cntr_no");
							var cbkg_no = sheetObject.CellValue(srow,"cbkg_no");
							var cop_no = sheetObject.CellValue(srow,"cop_no");
							var tmp = sheetObject.CellValue(srow, "cntr_no");
    						if (tmp == "" || tmp.length != 11 ){
    							ComShowCodeMessage('BKG40055');
    							return;
    						}
    						var cntrNo = (tmp != null && tmp.length>10) ? tmp.substring(0,10) : tmp;;
							var url = "ESD_SCE_0006.do?f_cmd=" +
									  "&cop_no=" + cop_no + 
									  "&bkg_no=" + cbkg_no + 
									  "&cntr_no=" + cntr_no + 
									  "&pgmNo=ESD_SCE_0006" + 
									  "&dist1=" + "COP_VALUE" + 
									  "&dist2=" + "COP_VALUE" ;
							ComOpenWindowCenter(url, "EES_CTM_0411", 1010, 650, false);	

    						break;
    						
    					case "btn_Retrieve":
    						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    						break;
    						
    					case "btn_New":
    						sheetObjects[0].RemoveAll();
//    						sheetObjects[1].RemoveAll();
//    						sheetObjects[2].RemoveAll();
    	 					ComResetAll();
    	 					ComBtnDisable("btn_EQHistory");
    	 					ComBtnDisable("btn_COP");
//    	 					ComBtnDisable("btn_CLM");
    						break;
    					case "btn_DownExcel":
    	 					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
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

        function setComboObject(combo_obj){
          	comboObjects[comboCnt++] = combo_obj;
         }


        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {

    		for(i=0;i<sheetObjects.length;i++){

    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);
                 
    		}
    		
    		
//    		for(k=0;k<tabObjects.length;k++){
//    			initTab(tabObjects[k],k+1);
//    		}
    		
    		//Outbound Container Movement Status Table Visible 처리
//    		setSheetVisble(0);
    		
    		initControl();
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    		
    		//IBMultiCombo초기화
    		for(var j=0; j<comboObjects.length; j++){
    		    initCombo(comboObjects[j]);
    		}
    	}
        
        
        /**
         * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
         * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
         * 
         * @param {ibsheet}
         *            sheetObj IBSheet Object
         * @param {int}
         *            sheetNo sheetObjects 배열에서 순번
         */
        function initControl() {
        	//** Date 구분자 **/
        	DATE_SEPARATOR = "-";
        	
        	var formObject = document.form;
        	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
        	axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); //- 키보드 입력할때
        	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
     	    axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
     	   
        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        	//ComSetObjValue(formObject.bkg_dt_fr,ComGetNowInfo());	// 맨 처음  로드시 SYSDATE 날짜 입력 필요하지 않음
        	//ComSetObjValue(formObject.bkg_dt_to,ComGetNowInfo()); // 맨 처음  로드시 SYSDATE 날짜 입력 필요하지 않음
        	ComBtnDisable("btn_EQHistory");
        	ComBtnDisable("btn_COP");
//        	ComBtnDisable("btn_CLM");
        	/*ComBtnDisable("btn_SumbyYard");  
        	ComBtnDisable("btn_SumbyTPSZ");  */

        	
        }
       /*********************** KEY EVENT START ********************/ 	 
     function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":    	
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;
	      case "custname":
	        //영문,숫자,공백,기타문자(.,등)
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	      break;	            
	      default:
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

            switch(sheetNo) {
                case 1:      //sheet1 init
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 330;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly +	msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;
//                        EditableColorDiff = false;
		
                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 3, rowsPerPage);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                        // 2010.11.01 LSJ 추가 (P|Vol.)
                        InitHeadMode(true, true, true, true, false,false);
                        var HeadTitle1 = "|No.|No.|Booking No.|ST|Shipper|Consignee|POR|POD|SVC Term|SVC Term|BKG Q'ty|B/S|EIR||Container|Container|Container|Container|Customs|Customs|Movement|Movement|Movement|Movement|STOW|DG|DG|RF|RF|AK|AK|AK||||||||||||||||||||||||||";
                        var HeadTitle2 = "|No.|No.|Booking No.|ST|Shipper|Consignee|POR|POD|R|D|BKG Q'ty|B/S|EIR||No.|SZ|P|Vol.|Customs |Customs Release Time|OP Yard|OP Date|OC Yard|OC Date|STOW|CLASS|UN|TEMP|VENT|OL|OW|OH||||||||||||||||||||||||||";
//                        var HeadTitle2 = "|Sel.|Seq.|Booking No.|Booking No.|POR|POD|||||||||ST|Origin Yard|Event Time|Sight|Loacation|ST|Event Date|ETA|Shipper|D/G|R/F|AK\n(F/R/H/L/R)|VVD Type|Partial|subgroup_title|";

                        var headCount = ComCountHeadTitle(HeadTitle1);
                        
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 5, 0, true);
                        
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		"ibflag");
                        InitDataProperty(0, cnt++ , dtHidden ,				40,		daCenter,	true,		"dense_rank");
                        InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		"dense_rank2",	false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	true,			"bkg_no",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,			"st",		false,			"",      dfNone,			0,		false,		false);
						
						InitDataProperty(0, cnt++ , dtData,					150,	daLeft,		true,			"shpr_nm",					false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					130,	daLeft,		true,			"cnee_nm",					false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,			"por_cd",					false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,			"pod_cd",			  false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,			"rcv_term_cd",						false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,			"de_term_cd",						false,			"",      dfNone,			0,		false,		false);
						
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,			"bkg_qty",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,			"bs",	false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,			"eir_flg",	false,			"",      dfNone,			0,		false,		false);

						InitDataProperty(0, cnt++ , dtHidden  ,				30,		daCenter,	true,			"Check",	false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,			"cntr_no",				false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	false,			"cntr_tpsz_cd",				false,			"",      dfNone,			0,		false,		false);
						
						//2010. 11. 1 LSJ 추가
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	false,			"cntr_prt_flg",						false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					60,		daRight,	false,			"cntr_vol_qty",				false,			"",      dfFloat,			2,		false,		false);
						
						InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	true,			"curl_flg",				false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					140,	daCenter,	true,			"curl_dt",					  false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,			"op_org_yd_cd",		false,			"",      dfNone,			0,		false,		false);
						
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,			"op_cnmv_evnt_dt",			  false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,			"oc_org_yd_cd",						false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,			"oc_cnmv_evnt_dt",		false,			"",      dfNone,			0,		false,		false);
						
						InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,			"stow",			false,			"",      dfNone,			0,		false,		false);
						
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,			"imdg_un_no",					  false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,			"imdg_clss_cd",					  false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,			"cdo_temp",					  false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,			"cntr_vent_tp_cd",					  false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,			"ovr_fwrd_len",					  false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,			"ovr_bkwd_len",					  false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,			"ovr_hgt",			false,			"",      dfNone,			0,		false,		false);

						InitDataProperty(0, cnt++ , dtHidden,				80,		daCenter,	false,		"op_sts_cd",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,				100,	daCenter,	false,		"oc_sts_cd",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,				100,	daCenter,	false,		"move_sts",					false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,				80,		daCenter,	false,		"bkg_total",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"bkg_total_f");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"cntr_total");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"cntr_total_f");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"eir_total_y");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"eir_total_n");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"eir_tot_y");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"eir_tot_n");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"curl_total_y");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"curl_total_n");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"curl_tot_y");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"curl_tot_n");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"op");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"op_tot");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"oc");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"oc_tot");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"vl");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"vl_tot");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"ot");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"ot_tot");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"cop_no");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"cbkg_no");
						//checkbox머지 관련 컬럼 추가 (1개)
						InitDataProperty(0,	cnt++ , dtHidden,				0,		daLeft,		false,		"check2"      );						
						
						//InitUserFormat2(0, "EventDate", "####-##-## ##:##", "-|:" );
						//InitUserFormat2(0, "ETA", "####-##-## ##:##", "-|:" );
						
						//DataRowMerge(0) = true;
						//DataRowMerge(1) = true;
						//FrozenCols  = 4;
						
//						/* Booking Column Merge */
//						SetMergeCell(0,3,2,2);
//						/* R/D Column Merge */
//						SetMergeCell(0,8,2,2);				
//						/* BKG Q'ty Column Merge */
//						SetMergeCell(0,10,2,2);
//						/* Container No Column Merge */
//						SetMergeCell(0,12,2,2);
//						/* CNTR R/D Column Merge */
//						SetMergeCell(0,14,2,2);
//
//						SetMergeCell(0,19,2,2);
						
//						/* D/G Column Merge */
//						SetMergeCell(0,25,2,2);
//						/* R/F Column Merge */
//						SetMergeCell(0,27,2,2);
////						/* A/K Column Merge */
//						SetMergeCell(0,29,2,2);
						
//						CountPosition = 0;
						CountFormat = "[SELECTDATAROW/SEARCHROWS]";
                   }
                    break;

            }
        }
		/**
		  * 콤보 초기설정값
		  * @param {IBMultiCombo} comboObj  comboObj
		  */
		  function initCombo(comboObj) {
		  	comboObj.DropHeight = 250;
		  	comboObj.UseAutoComplete = true;
		  	comboObj.index =0;
		  } 
		  
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
	            case IBCLEAR: // 화면 로딩시 코드 조회
					formObj.f_cmd.value = COMMAND01;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_1110GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					
					
					if (arrXml.length > 5) 
						ComXml2ComboItem(arrXml[5], formObj.cust_tp_cd, "val", "name");
					if (arrXml.length > 4) 
						ComXml2ComboItem(arrXml[4], formObj.bkg_cgo_tp_cd, "val", "desc");
					if (arrXml.length > 3) 
						//ComBkgXml2ComboItem(arrXml[3], formObj.xter_bkg_rqst_cd, "val", "name");
						ComXml2ComboItem(arrXml[3], formObj.xter_bkg_rqst_cd, "val", "name");
					if (arrXml.length > 2) 
						ComXml2ComboItem(arrXml[2], formObj.bkg_sts_cd, "val", "name");
					if (arrXml.length > 1) 
						ComXml2ComboItem(arrXml[1], formObj.de_term_cd, "val", "name");
					if (arrXml.length > 0) 
						ComXml2ComboItem(arrXml[0], formObj.rcv_term_cd, "val", "name");
					
					break;
	           case IBSEARCH:      //조회
	 	          if(validateForm(sheetObj,formObj,sAction)){
	 	        	 formObj.f_cmd.value = SEARCH;
	 	        	pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화
	 	        	 
	 	        	sheetObj.WaitImageVisible=false;
	 	        	ComOpenWait(true);

	 	        	 
	 	        	//sheetObj.DoSearch4Post("ESM_BKG_1110_1GS.do", FormQueryString(formObj));
	 	        	var sXml = sheetObj.GetSearchXml("ESM_BKG_1110_1GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
//					if (arrXml.length > 2) 
//						sheetObjects[2].LoadSearchXml(arrXml[2]); 
//					if (arrXml.length > 1) 
//						sheetObjects[1].LoadSearchXml(arrXml[1]); 
//					if (arrXml.length > 0) 
						sheetObj.LoadSearchXml(arrXml[0]);
					
	 	          }	  
	              break;
             
	           case IBDOWNEXCEL:   
	   				sheetObj.SpeedDown2Excel(-1);
	   				break;	    
	   				
            }
            ComOpenWait(false);
        }
        
        function openWinCenter(url,winName,width,height , scrollYn) {
     	   var left = (screen.width - width)/2;    
     	   if(left < 0) {
     		   left = 0;
     	   }
            var top  = (screen.height- width)/2;   
            if( top < 0 ) {
         	   top = 0;
            }
            
            if (ComIsNull(scrollYn)) {
         	   scrollYn = "no";
            } else {
         	   if (scrollYn == "Y") {
         		   scrollYn = "yes";
         	   } else {
         		   scrollYn = "no";
         	   }
            }
            var feature = 
         	   "status=no, resizable=yes, scrollbars="+scrollYn+", width="+width+", height="+height+", left="+left+", top="+top;
            
            return window.open(url,winName,feature);
     }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	with(formObj){
             	switch(sAction) {

    					case IBSEARCH: // 조회시 확인
//    		         		if (!ComChkValid(formObj)) return false;

	    					if (!ComIsNull(formObj.bkg_dt_fr) && !ComIsNull(formObj.bkg_dt_to) && ComGetDaysBetween(formObj.bkg_dt_fr.value, formObj.bkg_dt_to.value) > 31){
			         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
			         			formObj.bkg_dt_fr.focus();
			         			return false;
			         		}
	    					
	    					if (ComIsNull(formObj.pol_cd)){
	    						ComShowCodeMessage("BKG00209"); //Please Input POL.
	    						return false
	    					}
    					
    		         		break;
             	}	
             }
             return true;
        }

        /**
         *  페이징 처리 후 해당 조회 개수만큼 처리 하기위한 변수
         * 초기값은 쉬트 헤더 개수
         */ 
       var pagedMaxCnt=2; 

        
        // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
        function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        	if (0 < sheetObj.TotalRows) {
	        	var formObj = document.form;
	        	formObj.bkg_total.value = sheetObj.CellValue(2, "bkg_total");
	        	formObj.bkg_total_f.value = sheetObj.CellValue(2, "bkg_total_f");
	        	formObj.cntr_total.value = sheetObj.CellValue(2, "cntr_total");
	        	formObj.cntr_total_f.value = sheetObj.CellValue(2, "cntr_total_f");
	        	formObj.eir_total_y.value = sheetObj.CellValue(2, "eir_total_y");
	        	formObj.eir_total_n.value = sheetObj.CellValue(2, "eir_total_n");
	        	formObj.eir_tot_y.value = sheetObj.CellValue(2, "eir_tot_y");
	        	formObj.eir_tot_n.value = sheetObj.CellValue(2, "eir_tot_n");
	        	formObj.curl_total_y.value = sheetObj.CellValue(2, "curl_total_y");
	        	formObj.curl_total_n.value = sheetObj.CellValue(2, "curl_total_n");
	        	formObj.curl_tot_y.value = sheetObj.CellValue(2, "curl_tot_y");
	        	formObj.curl_tot_n.value = sheetObj.CellValue(2, "curl_tot_n");
	        	formObj.op.value = sheetObj.CellValue(2, "op");
	        	formObj.op_tot.value = sheetObj.CellValue(2, "op_tot");
	        	formObj.oc.value = sheetObj.CellValue(2, "oc");
	        	formObj.oc_tot.value = sheetObj.CellValue(2, "oc_tot");
	        	formObj.vl.value = sheetObj.CellValue(2, "vl");
	        	formObj.vl_tot.value = sheetObj.CellValue(2, "vl_tot");
	        	formObj.ot.value = sheetObj.CellValue(2, "ot");
	        	formObj.ot_tot.value = sheetObj.CellValue(2, "ot_tot");
	    		
	        	ComBtnEnable("btn_EQHistory");
	        	ComBtnEnable("btn_COP");
	
	       		with (sheetObj) {
	       			var redColor = RgbColor(255, 0, 0);
	      			var blueColor = RgbColor(0, 0, 255);
	      			var rowSpan = 1, tmpCnt = rowCnt = 0;
	      			for (var i = pagedMaxCnt; i < TotalRows + HeaderRows ; i++) {
	      				CellFontColor(i, "bkg_no") = blueColor;
	      				CellFontUnderline(i, "bkg_no") = true;
	
	       	      	}
	          		//아래 두줄은 마지막로우의 셀이 SetMergeCell 로 병합되지 않아서 넣은 구문임
	       			DataInsert(-1);
	       			RowHidden(LastRow) = true;
	           	 }
	           	 pagedMaxCnt = sheetObj.LastRow;        	
	           	 sheetObj.SelectCell(2,1);
        	}        	
        }

        function setCelColor(flag, obj,idx,celName,color){
        	if(flag =="N")
        			obj.CellFontColor(idx,celName) = color;
        }        

        function sheet1_OnSort(sheetObj,Col,Arrow) {
			var rowNum = 1;
			with (sheetObj) {
				MergeSheet = msNone;
				for (var i=HeaderRows; i <= Rows; i++) {
					CellValue2(i,"dense_rank2") = rowNum;
					if (CellValue(i,"bkg_no") && CellValue(i+1,"bkg_no") &&
						CellValue(i,"bkg_no") != CellValue(i+1,"bkg_no")) {
						rowNum++;
					}
				}
				MergeSheet = msHeaderOnly + msPrevColumnMerge;
			}
        }

		 /**
		  *  Search Option or Item Option Modify
		  */
	   	 function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
			    
	  		if( colIdx == sheetObj.SaveNameCol("bkg_no")){
							var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(rowIdx, "bkg_no");
							ComOpenWindowCenter2("/opuscntr/ESM_BKG_0079.do"+param, "Booking Main", 1024,740,false,"scrollbars=yes,resizable=yes");
							
	  		}
	   	 }	    	 
   	 
//        function sheet1_OnClick(sheetObj, Row, Col, Value) {
//    		var formObj = document.form;
//    		
//    		var colName = sheetObj.ColSaveName(Col);
//    		if (colName == "Check"){
//	    		for (i = 1; i<= sheetObj.LastRow; i++) {  //sheetObj.LastRow
//	    			if (sheetObj.CellValue(i, Col) == true){
//	    				sheetObj.CellValue2(i, Col) = 0;
//	    			}
//	    		}
//        	}
//    		
//    	}
        
        
        /**
         * ETD,ETB 기간 선택 달력 띄우기
         */
      	function callDatePop(val){
      		var cal = new ComCalendarFromTo();
      		if (val == 'BKG_DATE'){
      			cal.select(form.bkg_dt_fr,  form.bkg_dt_to,  'yyyy-MM-dd');
      		}
      	}

    	/**
    	 * 머지된 체크박스 로우의 버그를 해결하기 위한 전역 변수와 이벤트 함수
    	 */
    	var startMergeRow = lastMergeRow = 0;
    	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {  //변경전이벤트
    		with (sheetObj) {
    	    	if (2==MouseCol) {
    		    	startMergeRow = Number(GetMergedStartCell(MouseRow ,MouseCol).split(",")[0]);
    		    	lastMergeRow = Number(GetMergedEndCell(MouseRow ,MouseCol).split(",")[0]);
    			}
    		}
    	}
    	function sheet1_OnChange(sheetObj, Row, Col, Value) {  //변경후이벤트
    		if (2==Col) {
        		sheetObj.CellValue2(startMergeRow, "check2") = 1==Value ? "1":"";
    	    	for (var i = startMergeRow; i <= lastMergeRow; i++) {
    	    		sheetObj.CellValue2(i, Col) = Value;
    	    	}
    		}
    	}      	
       
	/* 개발자 작업  끝 */