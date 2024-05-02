/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0619.js
*@FileTitle : Outbound Container Movement Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.01 김기종
* 1.0 Creation
* 2011.11.22 변종건 [CHM-201113464-01] 동일 CNTR가 다른 VVD로 Double Booking시-IRR조기 감지 Report시스템 구축
* 2012.04.12 변종건 [CHM-201217103-01] O/B CNTR MVMT Status > Summary by yard/ type /size 탭에도 trade/ sub trade/ lane 옵션 추가
* 2013.02.01 김진주[CHM-201322839] 리포트 보완 -O/B Container Movement Stauts 화면
* 2013.02.25 김진주 [CHM-201322909] [O/B Container movement status] multiple office 기능 추가 요청
* 2014.08.05 이한나[CHM-201431231] O/B CNTR MOVEMENT STATUS REPORT 보완
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
     * @class esm_bkg_0619 : esm_bkg_0619 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0619() {
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

    var comboObjects = new Array();
    var combo1 = null;
    var comboCnt = 0;
    
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[1];
             var sheetObject1 = sheetObjects[2];

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
    						var typeSize = sheetObject.CellValue(srow, "cntr_tpsz_cd_mv");
    						
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
    						
    					case "btn_CLM" :
    						
    						var srow =sheetObject.SelectRow;
    						var tmp = sheetObject.CellValue(srow, "cntr_no");
    						
    						if (tmp == "" || tmp.length != 11 ){
    							ComShowCodeMessage('BKG40055');
    							return;
    						}
    						
    						var cntrNo = sheetObject.CellValue(srow, "cntr_no");
    						var typeSize = sheetObject.CellValue(srow, "cntr_tpsz_cd_mv");
    						var clmTo = sheetObject.CellValue(srow,"clm_dt").substring(0,10);
    						var clmFm = ComGetDateAdd(clmTo.toString(),"D",-180, "-", false);
    						var param = "pgmNo=ESD_SCE_0043&f_cmd=0&row_size=50&"+
    									"cntr_no=" + cntrNo +
    									"&tpsz_cd=" + typeSize +
    									"&arr_dt1=" + clmFm +
    									"&arr_dt2=" + clmTo ;
    						var url = "ESD_SCE_0043.do?" + param;
    						ComOpenPopup(url, 1010, 530, 'ESD_SCE_0043', '0,0', true, true, 0, "", 1);

    						break;    						
    					case "btn_Retrieve":
    						doActionIBSheet(sheetObjects[tabObjects[0].SelectedIndex+1],formObject,IBSEARCH);
    						break;
    						
    					case "btn_New":
    						sheetObjects[1].RemoveAll();
    						sheetObjects[2].RemoveAll();
    						sheetObjects[3].RemoveAll();
    						clearVvds();
    	 					ComResetAll();
    	 					ComBtnDisable("btn_EQHistory");
    	 					ComBtnDisable("btn_COP");
    	 					ComBtnDisable("btn_CLM");
    						break;
    					case "btn_DownExcel":
    	 					doActionIBSheet(sheetObjects[tabObjects[0].SelectedIndex+1],formObject,IBDOWNEXCEL);
    	 					break;	
    					case "btn_Preview":
    						doActionIBSheet(sheetObjects[eval(tabObjects[0].SelectedIndex+1)],formObject,RDPRINT);
    	 					break;	
    					case "btn_multi_ofc":
    						bkgOfcListPopUp();
    						break;
    					case "ofc_list_add":
    						sheetObjects[0].DataInsert(-1);
    						break;
    					case "ofc_list_del":
    						if (sheetObjects[0].CheckedRows("slct_flg") != 0) {
    							var checkList = sheetObjects[0].FindCheckedRow("slct_flg");
    							var arrRow = checkList.split("|");
    							for (idx=arrRow.length-2; idx>=0; idx--){ 	
    								sheetObjects[0].RowDelete(arrRow[idx], false);
    							}
    						}
    						break;
    					case "ofc_list_ok":
    		          	  	var bkgOfcList = "";
    		      			var sRow = sheetObjects[0].FindCheckedRow("slct_flg");	
    		      			var arrRow = sRow.split("|");	
    		      			
    		      			for( var i = 0; i < arrRow.length-1; i++ ) {	
    		      				bkgOfcList = bkgOfcList + doSepRemove(sheetObjects[0].CellValue(arrRow[i], "ofc_cd"), " ")+",";
    		      			}
    		      			bkgOfcList = bkgOfcList.substring(0, bkgOfcList.length-1);
    		      			formObject.bkg_ofc_cd.value = bkgOfcList;

    		      			document.all.bkgOfcList.style.display = "none";
    		      			document.all.bkgOfcList.style.visibility = 'hidden';
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
    		
    		
    		for(k=0;k<tabObjects.length;k++){
    			initTab(tabObjects[k],k+1);
    		}
    		
    		//Outbound Container Movement Status Table Visible 처리
    		setSheetVisble(0);
    		
    		initControl();
    		
    		doActionIBSheet(sheetObjects[1],document.form,IBCLEAR);
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
        	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
     	    axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
     	   
        	axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); //- 키보드 입력할때
        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

            axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
            
        	//ComSetObjValue(formObject.bkg_dt_fr,ComGetNowInfo());	// 맨 처음  로드시 SYSDATE 날짜 입력 필요하지 않음
        	//ComSetObjValue(formObject.bkg_dt_to,ComGetNowInfo()); // 맨 처음  로드시 SYSDATE 날짜 입력 필요하지 않음
        	ComBtnDisable("btn_EQHistory");
        	ComBtnDisable("btn_COP");
        	ComBtnDisable("btn_CLM");
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
	        //숫자+"영문대문자"입력하기
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
    		case 1:
    			with (sheetObj) {
    				// 높이 설정
    				style.height = 94;
    				// 전체 너비 설정
    				SheetWidth = mainTable.clientWidth;

    				// Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "")
    					InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				// 전체Edit 허용 여부 [선택, Default false]
    				Editable = true;

    				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 2, 100);

    				var HeadTitle1 = " | |Office";
    				var headCount = ComCountHeadTitle(HeadTitle1);

    				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, true, true, false, false);

    				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);

    				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
    				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
    				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
    				// SAVESTATUS, FORMATFIX]

    				InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, "ibflag", false, "", dfNone, 0, true, true);
    				InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, true,"slct_flg");
    				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "ofc_cd", false, "", dfEngUpKey, 0, true, true);

    				CountPosition = 0;

    			}
    			break;
                case 2:      //sheet1 init
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 320;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msAll;//msPrevColumnMerge + msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;
                        EditableColorDiff = true;
		
                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 2, 100);

                        

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, false, true, false,false);
                        var HeadTitle1 = "|Sel.|Seq.|VVD|Trade|Sub\nTrade|Lane|Booking No.|Booking No.|POR|T/POD|POD|DEL|R/D|R/D|BKG Q'ty|BKG Q'ty|RD Q'ty|Container No.|Container No.|Duplicate|CNTR R/D|CNTR R/D|ST|Yard|Current Event Time|CLM(US Rail)|CLM(US Rail)|CLM(US Rail)|CLM(US Rail)|CLM(US Rail)|Shipper|D/G|D/G|R/F|R/F|Genset|AK\n(F/R/H/L/R)|AK\n(F/R/H/L/R)|VVD Type|Partial|subgroup_title|";
//                        var HeadTitle2 = "|Sel.|Seq.|Booking No.|Booking No.|POR|POD|DEL|R/D|R/D|BKG Q'ty|BKG Q'ty|Container No.|Container No.|CNTR R/D|CNTR R/D|ST|Origin Yard|Event Time|Sight|Location|ST|Event Date|ETA|Shipper|D/G|D/G|R/F|R/F|AK\n(F/R/H/L/R)|AK\n(F/R/H/L/R)|VVD Type|Partial|subgroup_title|";
//                        var HeadTitle2 = "|Sel.|Seq.|Booking No.|Booking No.|POR|POD|||||||||ST|Origin Yard|Event Time|Sight|Loacation|ST|Event Date|ETA|Shipper|D/G|R/F|AK\n(F/R/H/L/R)|VVD Type|Partial|subgroup_title|";

                        var headCount = ComCountHeadTitle(HeadTitle1);
                        
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(46, 10, 0, true); //(45, 10, 0, true); // 2014.08.06 CHM-201431231
                        
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
//                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		"ibflag");
						InitDataProperty(0, cnt++ , dtHidden  ,				40,		daCenter,	true,		"Check",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData ,				40,		daCenter,	true,		"Seq");
						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	true,		"vvd_cd",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		"trd_cd",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		"sub_trd_cd",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		"rlane_cd",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	true,		"bkg_no",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"bkg_sts_cd",		false,			"",      dfNone,			0,		true,		true);
						
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"por_cd",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"trunk_pod_cd",		false,			"",      dfNone,			0,		true,		true);  // 2014.08.06 CHM-201431231
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"pod_cd",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"del_cd",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		"rcv_term_cd_mv",	false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		"de_term_cd_mv",	false,			"",      dfNone,			0,		true,		true);
						
						InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		"cntr_tpsz_cd",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"op_cntr_qty",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"rd_cntr_qty",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	true,		"cntr_no",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		"cntr_tpsz_cd_mv",	false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	true,		"cntr_check",		false,			"",      dfNone,			0,		true,		true);
						
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		"rcv_term_cd",	false,			"",      dfNone,			0,		true,		true);
						
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		"de_term_cd",	false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		"cnmv_sts_cd",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,		"org_yd_cd",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					130,	daCenter,	true,		"cnmv_evnt_dt",		false,			"",      dfNone,			0,		true,		true);
						
						
						InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	true,		"clm_sght_cd",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		"arr_loc_nm",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		"arr_ste_cd",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		"arr_dt",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		"dep_dt",			false,			"",      dfNone,			0,		true,		true);
						
						InitDataProperty(0, cnt++ , dtData,					150,	daLeft,		true,		"cust_nm",			false,			"",      dfNone,			0,		true,		true);
						
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		"dg_sts",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		"dg",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		"rf_sts",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		"rf",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtCheckBox,				65,		daCenter,	false,		"pwr_spl_cbl_flg",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		"ak_sts",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		"ak",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	true,		"vsl_pre_pst_cd",	false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"cntr_prt_flg",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"cop_no");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"cbkg_no");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"clm_dt");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"subgroup_title");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"MDST");
						
						
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
						
						CountPosition = 0;
                   }
                    break;
                case 3:      //sheet2 init
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 320;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 2, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(27, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        var HeadTitle1 = "|sub_str|VVD|Trade|Sub\nTrade|Lane|Origin Yard|OP|OP|OP|OP|OC|OC|OC|OC|EN+TN|EN+TN|EN+TN|EN+TN|MT|MT|MT|MT|Others|Others|Others|Others";
                        var HeadTitle2 = "|sub_str|VVD|Trade|Sub\nTrade|Lane|Origin Yard|DR2|DR4|RF2|RF4|DR2|DR4|RF2|RF4|DR2|DR4|RF2|RF4|DR2|DR4|RF2|RF4|DR2|DR4|RF2|RF4";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,			"Status");
						InitDataProperty(0, cnt++ , dtHidden,		    40,		daCenter,	true,			"sub_str",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		        90,		daCenter,	true,			"vvd_cd",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		        40,		daCenter,	true,			"trd_cd",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		        40,		daCenter,	true,			"sub_trd_cd",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		        40,		daCenter,	true,			"rlane_cd",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		        80,		daCenter,	true,			"org_yd_cd",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"op_dr2",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"op_dr4",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"op_rf2",			false,			"",      dfFloat,			2,		true,		true);
						
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"op_rf4",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"oc_dr2",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"oc_dr4",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"oc_rf2",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"oc_rf4",			false,			"",      dfFloat,			2,		true,		true);
						
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"etn_dr2",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"etn_dr4",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"etn_rf2",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"etn_rf4",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"mt_dr2",			false,			"",      dfFloat,			2,		true,		true);
						
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"mt_dr4",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"mt_rf2",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"mt_rf4",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"ot_dr2",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"ot_dr4",			false,			"",      dfFloat,			2,		true,		true);
						
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"ot_rf2",			false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			55,		daRight,	true,			"ot_rf4",			false,			"",      dfFloat,			2,		true,		true);
						
                   }
                    break;   
                case 4:      //sheet1 init
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 320;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 2, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(17, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        var HeadTitle1 = "|sub_str|VVD|Trade|Sub\nTrade|Lane|Type/Size|BKG Qty|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Difference\n(BKG-CNTR) ";
                        var HeadTitle2 = "|sub_str|VVD|Trade|Sub\nTrade|Lane|Type/Size|BKG Qty|OP|OC|EN+TN|Port CY|VL|MT|Others|TTL|Difference\n(BKG-CNTR) ";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [	ROW, COL,  	DATATYPE,   		WIDTH, DATAALIGN, 		COLMERGE, 		SAVENAME,  				KEYFIELD, 		CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,			"Status");
						InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,		true,			"sub_str",				false,			"",      dfNone,			0,		true,		true);
//						InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,			"sub_str",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		        90,		daCenter,		true,			"vvd_cd",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,				40,		daCenter,		true,			"trd_cd",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,				40,		daCenter,		true,			"sub_trd_cd",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,				40,		daCenter,		true,			"rlane_cd",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,				70,		daCenter,		true,			"cntr_tpsz_cd_mv",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			60,		daRight,		true,			"bkg_qty",				false,			"",      dfFloat,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			60,		daRight,		true,			"op",					false,			"",      dfInteger,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			60,		daRight,		true,			"oc",					false,			"",      dfInteger,			0,		true,		true);
						
						InitDataProperty(0, cnt++ , dtAutoSum,			60,		daRight,		true,			"etn",					false,			"",      dfInteger,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			60,		daRight,		true,			"cy",					false,			"",      dfInteger,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			60,		daRight,		true,			"vl",					false,			"",      dfInteger,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			60,		daRight,		true,			"mt",					false,			"",      dfInteger,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			60,		daRight,		true,			"ot",					false,			"",      dfInteger,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			60,		daRight,		true,			"ttl",					false,			"",      dfInteger,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSum,			70,		daRight,		true,			"diff_qty",				false,			"",      dfFloat,			2,		true,		true);
						
                   }
                    break;    

            }
        }
		/**
		 * 콤보 초기설정값
		 * @param {IBMultiCombo} comboObj  comboObj
		 */
		 function initCombo(comboObj) {
		  	 var formObj = document.form;
		  	 var strId = comboObj.id;

		  	 with(comboObj) {
		  		 switch(strId) {
		  		 	case "trd_cd":
			        	DropHeight = 260;
		            	SetTitle("Trade|Description");
		            	SetColWidth("50|200");
		            	InsertItem(0,"|All","");
		            	MaxLength = 3;
		            	ValidChar(2, 0);
			            Index2 = 0;
			            break;
			            
			        case "sub_trd_cd":
	            		DropHeight = 260;
		            	SetTitle("Trade|SubTrade|Description");
		            	SetColWidth("50|70|150");
		            	InsertItem(0,"||All","");
		            	MaxLength = 2;
		            	ValidChar(2, 0);
			            Index2 = 0;
			            break;
			            
			        case "rlane_cd":
	            		DropHeight = 260;
		            	SetTitle("Trade|SubTrade|Rev.Lane|Description");
		            	SetColWidth("50|70|70|250"); 
		            	MaxLength = 5;
		            	ValidChar(2, 1);	//영문대문자+숫자
		            	InsertItem(0,"|||ALL",'');
		            	Index2 = 0;
			            break;
			            
			        case "vvd":
			        	comboObj.MultiSelect = true;
			        	comboObj.UseEdit = true;
			        	comboObj.BackColor = "#CCFFFD";
			            break;
			            
			        default:
			        	comboObj.DropHeight = 250;
					 	comboObj.UseAutoComplete = true;
					 	comboObj.index =0;
			     }
		  	 }
		 }
		  
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
	            case IBCLEAR: // 화면 로딩시 코드 조회
					formObj.f_cmd.value = COMMAND01;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0619GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					if (arrXml.length > 8) 
						ComXml2ComboItem(arrXml[8], formObj.rlane_cd, "code", "name");
					if (arrXml.length > 7) 
						ComXml2ComboItem(arrXml[7], formObj.sub_trd_cd, "code", "name");
					if (arrXml.length > 6) 
						ComXml2ComboItem(arrXml[6], formObj.trd_cd, "code", "name");
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
	 	        	 
	 	        	sheetObj.WaitImageVisible=false;
	 	        	ComOpenWait(true);

	 	        	var vvdCd1 = formObj.vvd.text.split(",");
	 	        	var sParam = "";
	 	        	
	 	        	sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll();
	 	        	
	 	        	for(var i=0; i < vvdCd1.length; i++){
	 	        		
	 	        		sParam = FormQueryString(formObj)+"&vvd_cd="+vvdCd1[i];
	 	        		
//		 	        	var sXml = sheetObj.GetSearchXml("ESM_BKG_0619_1GS.do", FormQueryString(formObj));
		 	        	var sXml = sheetObj.GetSearchXml("ESM_BKG_0619_1GS.do", sParam);
						var arrXml = sXml.split("|$$|");
						
						if (arrXml.length > 2) 
							sheetObjects[3].LoadSearchXml(arrXml[2], true); 
						if (arrXml.length > 1) 
							sheetObjects[2].LoadSearchXml(arrXml[1], true); 
						if (arrXml.length > 0) 
							sheetObjects[1].LoadSearchXml(arrXml[0], true); 
	 	        	}
	 	        	
					ComOpenWait(false);
	 	          }	  
	              break;
             
	           case IBDOWNEXCEL:   
	   				sheetObj.SpeedDown2Excel(-1);
	   				break;	    
	   				
	           case RDPRINT:   		
					if (sheetObj.RowCount > 0) {
						
						/*formObj.com_mrdPath.value 		= "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0814.mrd";
						formObj.com_mrdArguments.value 	= "/rfn ["+RDServerIP +  "/ESM_BKG_0814_1.do?"+FormQueryString(formObj)+"&vvd_cd="+formObj.vvd.Text+"]";

				 		ComOpenRDPopup();*/
				 		sheetObj.WaitImageVisible=false;
				 		ComOpenWait(true);

						var url = "ESM_BKG_0814.do?"+FormQueryString(formObj)+"&vvd_cd="+formObj.vvd.Text;	    	
						var winName = "ESM_BKG_0814";
						
						repWin = openWinCenter("about:blank",winName,1010,700);
					    
						var frm2 = document.form2;
						if (tabObjects[0].SelectedIndex == 1){
							formObj.f_cmd.value = SEARCH02;
							frm2.rfn.value = "/ESM_BKG_0814_1.do?"+FormQueryString(formObj)+"&vvd_cd="+formObj.vvd.Text;
							frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0814.mrd";
							
							frm2.rv.value = "title[Outbound Container Movement Status by Yard]";		    
							frm2.title.value = "Outbound Container Movement Status by Yard";
						    
						}else if (tabObjects[0].SelectedIndex == 2){
							formObj.f_cmd.value = SEARCH03;
							frm2.rfn.value = "/ESM_BKG_0814_1.do?"+FormQueryString(formObj)+"&vvd_cd="+formObj.vvd.Text;
							frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0815.mrd";
							
							frm2.rv.value = "title[Outbound Container Movement Status by Type/Size]";		    
							frm2.title.value = "Outbound Container Movement Status by Type/Size";
						    
						}

						frm2.action = url;
						frm2.target = winName;
						frm2.submit();
						frm2.target = "";
					    repWin.focus();
					} else {
						ComShowCodeMessage("BKG00495");
					}
					break;
					
//	           case SEARCH04:
//	        	    formObj.f_cmd.value = SEARCH04;
//					var sXml = sheetObj.GetSearchXml("ESM_BKG_0619GS.do", FormQueryString(formObj));
//					var arrXml = sXml.split("|$$|");
//
//					if (arrXml.length > 1) 
//						ComXml2ComboItem(arrXml[1], formObj.sub_trd_cd, "trd_cd|code", "name");
//					if (arrXml.length > 0) 
//						ComXml2ComboItem(arrXml[0], formObj.rlane_cd, "trd_cd|sub_trd_cd|code", "name");
//					if (arrXml.length > 8) 
//						ComXml2ComboItem(arrXml[8], formObj.rlane_cd, "code", "name");
//					break;
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
    		         		if (!ComChkValid(formObj)) return false;
    						
	    					if (ComIsNull(formObj.vvd.text)){
	    						ComShowCodeMessage('BKG00115');
	    						formObj.vvd_sig.focus();	    						
	    						return false
	    					}    			
	
	    					if (!ComIsNull(formObj.bkg_dt_fr) && !ComIsNull(formObj.bkg_dt_to) && ComGetDaysBetween(formObj.bkg_dt_fr.value, formObj.bkg_dt_to.value) > 31){
	   		           		 
			         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
			         			formObj.bkg_dt_fr.focus();
			         			return false;
			         		}
	    					
	    					if (ComIsNull(formObj.pol_cd)){
	    						ComShowCodeMessage("BKG00209"); //Please Input POL.
	    						formObj.pol_cd.focus();
	    						return false
	    					}
	    					if (formObj.pol_cd.value.length < 2){
	    						ComShowCodeMessage("BKG00209"); //Please Input POL.
	    						formObj.pol_cd.focus();
	    						return false
	    					}
    					
    		         		break;
             		}	
             }
             return true;
        }
        
        // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
        function sheet1_OnSearchEnd(sheetObj, ErrMsg)
        {
        	
        	/*Including CLM Information*/
    		
        	chkIncClm();
        	sheetObj.SelectCell(2,1);
        	ComBtnEnable("btn_EQHistory");
        	ComBtnEnable("btn_COP");
        	ComBtnEnable("btn_CLM");
        	
        	//2011.11.22 변종건[CHM-201113464-01] 동일 CNTR가 다른 VVD로 Double Booking시-IRR조기 감지 Report시스템 구축
			for(var idx=0; idx<= sheetObjects[1].LastRow; idx++){
				if(sheetObjects[1].CellValue(idx, "cntr_check") == "D"){
					if(sheetObjects[1].CellValue(idx, "cntr_no")!= ""){
						sheetObjects[1].CellFont("FontBold", idx, "cntr_no", idx, "cntr_no") = true;
						sheetObjects[1].CellFontColor(idx,"cntr_no") = sheetObjects[1].RgbColor(255,0,0);
					}
				}
				sheetObjects[1].CellFont("FontItalic", idx+1, "cntr_check") = true;
				sheetObjects[1].CellFontColor(idx+1, "cntr_check") = sheetObjects[1].RgbColor(255,0,0);
			}
        	
			//2012.06.11 오요한[CHM-201218315-01] O/B Container Movement Status Report 로직 보완요청 : 컨테이너 타입이 달라도 조회가능 -> 라인은 빨간색으로 표시
			
			// BKG Q'ty의 타입값 저장 
			var temBkgTp = '';
			
			// 헤더와 마지막의 써머리2줄은 제외한다.
			for(var idx=1; idx<= sheetObjects[1].LastRow-2; idx++){
				
				// BKG Q'ty의 타입값이 ""인 경우에는 이전값(temBkgTp)을 세팅한다.
				var bkgTp = sheetObjects[1].CellValue(idx, "cntr_tpsz_cd")==""?temBkgTp:sheetObjects[1].CellValue(idx, "cntr_tpsz_cd");
				temBkgTp = bkgTp;
				var cntrTp = sheetObjects[1].CellValue(idx, "cntr_tpsz_cd_mv");
				
				// 두 타입이 같지 않다면 해당 로우의 텍스트는 빨간색 
				if (cntrTp != '' && (bkgTp != cntrTp)) {
					sheetObjects[1].RowFontColor(idx) = sheetObjects[1].RgbColor(255,0,0);
				}
			}
        }
        
        function sheet1_OnClick(sheetObj, Row, Col, Value) {
    		var formObj = document.form;
    		// var sheetObject = sheetObjects[2];
    		
    		var colName = sheetObj.ColSaveName(Col);
    		if (colName == "Check"){
	    		for (i = 1; i<= sheetObj.LastRow; i++) {  //sheetObj.LastRow
	    			if (sheetObj.CellValue(i, Col) == true){
	    				sheetObj.CellValue2(i, Col) = 0;
	    			}
	    		}
        	}
    		
    	}
        
        
        /** 
        * sheet2 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
        */ 
        function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        	with(sheetObj) {
        		ShowSubSum("sub_str", "op_dr2|op_dr4|op_rf2|op_rf4|oc_dr2|oc_dr4|oc_rf2|oc_rf4|etn_dr2|etn_dr4|etn_rf2|etn_rf4|mt_dr2|mt_dr4|mt_rf2|mt_rf4|ot_dr2|ot_dr4|ot_rf2|ot_rf4", -1, false, false, 0);

        		var sRow = FindSubSumRow();
        		var arrRow = sRow.split("|");
        		for (idx=0; idx < arrRow.length-1; idx++){
        			CellValue2(arrRow[idx],"trd_cd") = "Sub Total";
        		    SetMergeCell(arrRow[idx], 2, 0, 4);
        		}
        	}
        }
        
        /** 
         * sheet3 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
         */ 
         function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
         	with(sheetObj) {
         		ShowSubSum("sub_str", "bkg_qty|op|oc|etn|cy|vl|mt|ot|ttl|diff_qty", -1, false, false, 0);

         		var sRow = FindSubSumRow();
         		var arrRow = sRow.split("|");
         		for (idx=0; idx < arrRow.length-1; idx++){
         			CellValue2(arrRow[idx],"trd_cd") = "Sub Total";
         		    SetMergeCell(arrRow[idx], 2, 0, 4);
         		}
         	}
         }
        
        
        /**
         * Check된 Sheet의 Row 값 리턴
         */
        
        function getCheckRowSheet(sheetObj){
    		for (i = 1; i<= sheetObj.LastRow; i++) {
    			if (sheetObj.CellValue(i, "Check") == true){
    				return i;
    			}
    		}
    		return 0;
    	}
        
        
        /**
         * Including CLM Information 체크여부에 따른 sheet 타이틀 조정.
         */
        function chkIncClm(){
        	var formObject = document.form;
        	
        	if (ComGetObjValue(formObject.chk_inc_clm) == "Y"){
        		sheetObjects[1].ColHidden("clm_sght_cd") = false;
        		sheetObjects[1].ColHidden("arr_loc_nm") = false;
        		sheetObjects[1].ColHidden("arr_ste_cd") = false;
        		sheetObjects[1].ColHidden("arr_dt") = false;
        		sheetObjects[1].ColHidden("dep_dt") = false;
        	}else{
        		sheetObjects[1].ColHidden("clm_sght_cd") = true;
        		sheetObjects[1].ColHidden("arr_loc_nm") = true;
        		sheetObjects[1].ColHidden("arr_ste_cd") = true;
        		sheetObjects[1].ColHidden("arr_dt") = true;
        		sheetObjects[1].ColHidden("dep_dt") = true;
        	}
        }
         
        /**
         * ETD,ETB 기간 선택 달력 띄우기
         */
      	function callDatePop(val){
      		var cal = new ComCalendarFromTo();
      		if (val == 'BKG_DATE'){
      			cal.select(form.bkg_dt_fr,  form.bkg_dt_to,  'yyyy-MM-dd');
      		}
      	}
      
        function setSheetVisble(inx){
    		for(var k=0; k< mainTable.length; k++){
    		    mainTable[k].style.display ="none";
    		}
    		mainTable[inx].style.display ="";
    		
    		if (inx == 0){
    			sButtonTable[0].style.display ="";
    			sButtonTable[1].style.display ="none";
    		}else{
    			sButtonTable[0].style.display ="none";
    			sButtonTable[1].style.display ="";
    		}
    		
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
                        InsertTab( cnt++ , "Result" , -1 );
                        InsertTab( cnt++ , "Summary by Yard" , -1 );
                        InsertTab( cnt++ , "Summary by Type/Size" , -1 ); 
                    }
                 break;
             }
        }

        function tab1_OnClick(tabObj, nItem){
       	 	setSheetVisble(nItem);
       	 
        }
        
        /**
         * Including CLM Information 체크여부에 따른 sheet 타이틀 조정.
         */
        function chkDupVVD(){
        	if( ComGetObjValue(document.form.chk_dup_vvd) == "Y"){
	        	for( var idx=1;idx<=sheetObjects[1].RowCount;idx++ ){
	        		if( sheetObjects[1].CellValue(idx,"cntr_check") != "Y" ){
	        			sheetObjects[1].RowHidden(idx) = true;
	        		}
	        	}
        	} else{
        		for( var idx=1;idx<=sheetObjects[1].RowCount;idx++ ){
        			if( sheetObjects[1].RowHidden(idx) ){
        				sheetObjects[1].RowHidden(idx) = false;
        			}
        		}
        	}
        }
         
         /**
          * 풍선도움말 만들기
          */
         function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
        	  sheetObj.ToolTipOption="balloon:true;width:100;icon:0;title:";
        	  var msgStr = "Note : D - Duplicate  VVD\n         A - Advanced Ship\n         S - Short Ship";
  
        	  if (sheetObj.MouseCol==sheetObj.SaveNameCol("cntr_check")){
        		  sheetObj.MousePointer = "Hand";
        		  sheetObj.MouseToolTipText = msgStr;
        	  }else{
        		  sheetObj.MousePointer = "Default";
        		  if (sheetObj.MouseToolTipText != ""){ 
        			  sheetObj.MouseToolTipText = "";
        		  } 
        	  }
          }
          
         /**
     	  * Trade Combo Change Event
          */
     	 function trd_cd_OnChange(comboObj,value,text){
			if (value != null && value != "") {  			
				comboObjects[7].Code2 = "";
				comboObjects[8].Code2 = "";
			}
			SpcSearchOptionSubTrade("sub_trd_cd",true,false,"","",value);
			SpcSearchOptionLane("rlane_cd",true,true,'',value,'',true);
     	 }
     	 
     	 /**
     	  * Sub Trade Combo Change Event
          */
     	 function sub_trd_cd_OnChange(comboObj,value,text){
 			SpcSearchOptionLane("rlane_cd",true,true,'',document.form.trd_cd.Code,value,true);	// 0207 SHKIM
 			if(value == "") return;
 	    	var arrTrade = text.split("|");
 	    	if(arrTrade.length > 1) {
 	    		comboObjects[6].Code2 = arrTrade[0];
 	    		comboObjects[8].Code2 = '';
 	    	} else {
 	    		comboObjects[6].Code2 = comboObj.GetText(value,0);  
 	    		comboObjects[8].Code2 = '';
 	    	}
     	 }
     	  
     	 /**
      	  * Lane Combo Change Event
          */
      	 function rlane_cd_OnChange(comboObj,value,text){
	        var arrLane = text.split("|");
 	    	if(arrLane.length > 1) {
 	    		comboObjects[6].Code2 = arrLane[0];
 	    		comboObjects[7].Code2 = arrLane[1];
 	    	} else {
 	    		comboObjects[6].Code2 = comboObj.GetText(value,0);  
 	    		comboObjects[7].Code2 = comboObj.GetText(value,1);  
 	    	}	
      	 }

      	/**
      	 * 조회 조건의 Sub Trade 설정. trdCd를 추가.
      	 * @param{elemName} str 필수, Object Name
      	 * @param{isAll} Boolean 선택, 모든 Sub Trade 조건 추가 여부, default = true.
      	 * @param{isRepTrade} Boolean 선택, Rep Trade 조건 추가 여부, default = false.
      	 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
      	 */  
      	function SpcSearchOptionSubTrade(elemName, isAll, isRepTrade, del, ipc ,trdCd) {
      		if(isAll == undefined || isAll == null){
      			isAll = true;
      		}
      		
      		if(isRepTrade == undefined || isRepTrade == null){
      			isRepTrade = false;
      		}
      		
      		if(del == undefined || del == null){
      			del = '';
      		}
      		var obj = document.getElementById(elemName);
      		if(trdCd == null || trdCd == ""){
      			var rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isAll=" + isAll+ "&ipc=" + ipc);
      		}else{
      			var rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isAll=" + isAll+ "&ipc=" + ipc+ "&trdCd=" + trdCd);
      		}
      		obj.setTitle("Trade|SubTrade|Description");
      		obj.SetColWidth("50|60|200");
      		obj.DropHeight = 190;
      		obj.ShowCol(1);
      		
      		ComXml2ComboItem(rtn, obj, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
      		if(isAll)
      			obj.InsertItem(0, "||ALL");
      	}    
      	 
      	/**
      	 * 조회 조건의 Lane 설정. locTrdCd,locSubTrdCd,reCdValue 추가.
      	 * @param{elemName} str 필수, Object Name
      	 * @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = true
      	 * @param{ipc} Boolean 선택, Rep Trade 조건 추가 여부, true 시 ipc 구간이므로 Rep Trade 조건
      	 *             제외. Default = false.
      	 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
      	 */  
      	function SpcSearchOptionLane(elemName, isAll, ipc, del,locTrdCd,locSubTrdCd,reCdValue) {
      		 if(isAll == undefined || isAll == null){
      			isAll = true;
      		}
      		
      		if(ipc == undefined || ipc == null){
      			ipc = false;
      		}
      		
      		if(del == undefined || del == null){
      			del = '';
      		}
      		
      		var obj = document.getElementById(elemName);
      		if(reCdValue == null || reCdValue == ''){
      			var rtn = getCodeXmlList("RLaneCombo", "del=" + del + "&ipc=" + ipc);
      		}else{
      			var rtn = getCodeXmlList("RLaneCombo", "del=" + del + "&ipc=" + ipc+ "&locTrdCd=" + locTrdCd+ "&locSubTrdCd=" + locSubTrdCd+ "&reCdValue="+reCdValue);
      		}
      		
      		obj.setTitle("Trade|SubTrade|Rev.Lane|Description");
      		obj.SetColWidth("50|60|60|250");
      		obj.DropHeight = 190;
      		obj.ShowCol(2);
      		
      		ComXml2ComboItem(rtn, obj, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
      		
      		if(isAll)
      			obj.InsertItem(0, "|||ALL");
      	}

      	function getCodeXmlList(cmd, param){
      		var rtn = new Array();
      	    rtn[0] = "";
      	    rtn[1] = "";
      	    
      	    createCodeSheetObject();
      	    
      	    with(codeSheet){
      	        ShowDebugMsg = false;
      	        var sXml = GetSearchXml("ESM_SPC_CODGS.do", "f_cmd="+SEARCHLIST02+"&mcode="+cmd+"&"+param);
      	        var xml  = sXml.substring(sXml.indexOf("<SHEET>"), sXml.indexOf("</SHEET>") + 8);
      	    }
      	    return xml;
      	}  
      	
      	var codeSheet = null;
      	/*
      	 * 
      	 */
      	function createCodeSheetObject(){
      	    if(codeSheet != null){
      	        return;
      	    }
      	    var objs = document.getElementsByTagName("OBJECT");
      	    var baseCode = "";
      	    for(var i = 0 ; i < objs.length ; i++){
//      	    	if(objs[i].classid == "CLSID:DAA95791-7150-47BD-BF09-E8EC04798D2D"){
      	    	  if(objs[i].classid == CLSID_IBSHEET){ //바뀐 사용자환경
//      	        if(objs[i].classid == "CLSID:341FBC5F-2AE4-41B8-BFE5-A03170569A27"){ //기존 사용자환경
//      	        if(objs[i].classid == "CLSID:C838E9DA-1625-4E14-8B37-C6706B43C423"){
      	            baseCode = "";
      	            break;
      	        }
      	    }
      	    var sTag = "";
      	    var id = "codeSheet";
      	    sTag = ComGetSheetObjectTag(id);
      	    var divElement = document.createElement("DIV");
      	    divElement.style.display = "none";
      	    divElement.innerHTML = sTag;
      	    document.body.appendChild(divElement);
//      	    document.write(sTag);
      	    codeSheet = divElement.children(0);
      	    ComConfigSheet(codeSheet);
      	    with(codeSheet){
      	        style.height = 150 ;
      	        //전체 너비 설정
      	        SheetWidth = 300;
      	    
      	        //Host정보 설정[필수][HostIp, Port, PagePath]
      	        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
      	    
      	        //전체Merge 종류 [선택, Default msNone]
      	        MergeSheet = msPrevColumnMerge;
      	    
      	       //전체Edit 허용 여부 [선택, Default false]
      	        Editable = true;
      	    
      	        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
      	        InitRowInfo( 1, 1, 9, 100);
      			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
      			InitColumnInfo(4, 0 , 0, true);
      	    
      	         var HeadTitle = "Status|Seq.|Code|Name";
      	    
      	        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
      	        InitHeadRow(0, HeadTitle);
      	        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
      	        InitColumnInfo(10, 1 , 0, false);
      	       var cnt = 0;
      	        InitDataProperty(0, cnt++ , dtStatus, 50, daCenter,   true,    "FLG",                 false,    "",         dfNone,   0,          false,       false);
      	        InitDataProperty(0, cnt++ , dtSeq,       50,    daCenter,   true,    "SEQ",                 false,    "",         dfNone,   0,          false,       false);
      	        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,   true,    "CODE",                 false,    "",         dfNone,   0,          true,       true);
      	        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,   true,    "TEXT",                 false,    "",         dfNone,   0,          true,       true);
      	    }
      	    ComEndConfigSheet(codeSheet);
      	    
      	}
      	
      	function bkgOfcListPopUp() {
    		var formObj = document.form;
    		
      	  	if (document.all.bkgOfcList.style.display == "none") {
      			document.all.bkgOfcList.style.display = "block";
      			document.all.bkgOfcList.style.visibility = 'visible';
      			if ( sheetObjects[0].RowCount < 1 ) {
      				sheetObjects[0].DataInsert(-1);
          			sheetObjects[0].CellValue2(1, "ofc_cd") = formObj.bkg_ofc_cd.value;
      			}
      	  	} else {
      			document.all.bkgOfcList.style.display = "none";
      			document.all.bkgOfcList.style.visibility = 'hidden';
      	  	}
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
      * VVD Selection Inquiry Popup Open
      */ 
     function getVvds(){
   	  
   	  var param = ""
   	  var pWin = ComOpenWindow("/hanjin/ESM_BKG_0753.do" + param,"open0753", "statebar=no,width=920,height=390,left=200,top=0");
     }

 	  /**
	   * VVD Selection Inquiry Popup Value Import
	   */
      function setVvds(vvds){
    	  
		  var formObj = document.form;
    	  var comboObj = comboObjects[0];
    	  
    	  ComClearCombo(formObj.rpt_nm);	    	  
    	  
    	  var arVvds = vvds.split(",");
    	  
    	  for (var i = 0 ; i < arVvds.length ; i++){
    		  
    		  comboObj.InsertItem(-1, arVvds[i], arVvds[i]);
    	  }
    	  
    	  comboObj.Text2 = vvds;
    	  
    	  formObj.vvd_sig.value = "";
		  formObj.slan_cd.value = "";
		  formObj.vvd_idx.value = arVvds.length;
		  
      }
	      
      function clearVvds(){
      	 document.form.vvd.RemoveAll();
      }
	      

	 /**
	  * VVD Combo Change Event
      */
	 function vvd_OnChange(comboObj,value,text){
		 
		 var formObj  = document.form;
		 
		 var comIdx = text.split(",");

		 if (comIdx.length >= 0){

			 formObj.vvd_sig.value = "";
			 formObj.slan_cd.value = "";
			 formObj.vvd_idx.value = comIdx.length;
		 }
	 }
	  

      /**
		 * VVD Name Upper Event
  	 */
  	 function searchLane(vvd) {
  		 
		 var formObj  = document.form;
		 var sheetObj = sheetObjects[0];
		 
		 if (vvd.value == ""){
			 
			 formObj.slan_cd.value = "";
			 formObj.vvd_idx.value = "";				 
			 return;
		 }else if (vvd.value.length != 9){
			 
			 ComShowCodeMessage("BKG00145");//Please! Check your VVD.	
			 vvd.focus();
			 return;
		 }			 			
		 
		 formObj.f_cmd.value = SEARCH01;    
		 
		 var searchXml = sheetObj.GetSearchXml("ESM_BKG_1082GS.do" , FormQueryString(formObj));
		 
		 if (ComGetEtcData(searchXml,"lane") == "none"){
			 
			 ComShowCodeMessage("BKG00163");//VVD is NOT Registered
			 vvd.focus();
			 return;
		 }
		 
		 formObj.slan_cd.value = ComGetEtcData(searchXml,"lane");
		 formObj.vvd_idx.value = "1";
		 
		 var comboObj = comboObjects[0];
		 
		 comboObj.InsertItem(-1, vvd.value, vvd.value); 
		 comboObj.Index2 = comboObj.GetCount()-1;

		 formObj.vvd.focus();			 
	 }
		 
     function obj_KeyUp() {
	     var formObject = document.form;
	     var srcName = window.event.srcElement.getAttribute("name");
	     var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	     var srcValue = window.event.srcElement.getAttribute("value");
	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
	     	ComSetNextFocus();
	     }
     }
	/* 개발자 작업  끝 */