/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0417.js
*@FileTitle : Port Closing Report (for Branch Office)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.11 김기종
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
     * @class esm_bkg_0417 : esm_bkg_0417 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0417() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var combo1 = null;
    var comboCnt = 0;
    
    var rowsPerPage = 999999; 
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		         var sheetObject1 = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");
        		var bkg_no ="";
                switch(srcName) {
    					
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					
					case "btn_new":
						ComResetAll();	
						sheetObject1.RemoveAll();
					break; 
					
					case "btn_detail":
						if (CheckGrid(sheetObject1,"Chk")){ 
	 						bkg_no = sheetObject1.CellValue(getCheckedRow(sheetObject1,"Chk"), "bkg_no");
	 						comBkgCallPopBkgDetail(bkg_no);
	 						break;
						}
						break;							
					case "btn_charge":
						if (CheckGrid(sheetObject1,"Chk")){ 
	 						bkg_no = sheetObject1.CellValue(getCheckedRow(sheetObject1,"Chk"), "bkg_no");
	 						comBkgCallPopBkgCharge(bkg_no);
	 						break;
						}
					     
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
			initControl();
			doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    	}
         
//        function sheet1_OnLoadFinish(sheetObj) {
//        	setTimeout(function () { doActionIBSheet(sheetObjects[0], document.form, IBCLEAR); },1000);
//        }
         
        
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
        	//axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
     	    //axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
     	   
//        	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
//        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        	
        	axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
            axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때     
            axon_event.addListenerFormat('beforeactivate', 'obj_activate',    formObject); //- 포커스 들어갈때
            axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        	
        	
        	/*ComSetObjValue(formObject.atd,ComGetNowInfo());
        	ComSetObjValue(formObject.etd,ComGetNowInfo());*/
        	
        	combo1 = comboObjects[0];
     		comboCnt = comboObjects.length;

     		// IBMultiCombo초기화
     	    for(var k=0; k<comboObjects.length; k++){
     	        initCombo(comboObjects[k]);
     	    }
//         	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        }
     

       /*********************** KEY EVENT START ********************/ 	 
		function bkg_keypress(){
		    switch(event.srcElement.dataformat){
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
		      case "engnum"://숫자+"영문대소"입력하기
	  	  	  	ComKeyOnlyAlphabet('num'); 
		      	break;	    
		      case "custname":
		        //숫자 입력하기
		        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
		        break;	   
		      default:
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
                case "sheet1":      //sheet1 init
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 310;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msNone;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        var HeadTitle1 = "| |No.|Booking No.|B/L No.|BKG STS|No Rate STS|Rating STS|Rates by ID|VVD|Lane|REV|Contract No.|Contract Party Code|Contract Party Name|" +
                        		"CNTR Confirm|CNTR Confirm by ID|PCT|ATD|ETB|ETD|BKG DATE|CN/NF Code|CNEE/NTFY|SH Code.|Shipper|POR|POL|POD|DEL|SI|GSO|Booking Office|Booking Staff|C.OFC|C.REP|L.OFC|L.REP|CMDT Cd|CMDT Name|Rate Check|Rating STS|DUMMY FLAG|OFT change after PCT";

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 2, 10);

                        var headCount = ComCountHeadTitle(HeadTitle1);
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);
                        

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                                            
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,		false,			"Status");
						InitDataProperty(0, cnt++ , dtRadioCheck,			30,		daCenter,		true,			"Chk");
						InitDataProperty(0, cnt++ , dtSeq,					40,		daCenter,		true,			"No",				false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					95,		daCenter,		true,			"bkg_no",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,			"bl_no",			false,			"",      dfNone,			0,		false,		false);
	                                                                                    		                                        
						InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		true,			"bkg_sts_cd",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,			"no_rt_sts",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,		true,			"brh_cfm_ind_nm",	false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,			"rt_by_id",		    false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,			"vvd_cd",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					45,		daCenter,		true,			"bkg_lane",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					40,		daCenter,		true,			"lane_ind",			false,			"",      dfNone,			0,		false,		false);
						
						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,		true,			"ctrt_no",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,                 125,    daCenter,       true,           "ctrt_cust_cd",     false,          "",      dfNone,            0,      false,      false);
		                InitDataProperty(0, cnt++ , dtData,                 125,    daLeft,         true,           "ctrt_cust_nm",     false,          "",      dfNone,            0,      false,      false);
						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,		true,			"cntr_cfm_flg",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					115,	daCenter,		true,			"cntr_cfm_by_id",	false,			"",      dfNone,			0,		false,		false);
	
						InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,			"pct",				false,			"",      dfDateYmd,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,			"atd",				false,			"",      dfDateYmd,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,			"etb",				false,			"",      dfDateYmd,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,			"etd",				false,			"",      dfDateYmd,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,			"bkg_date",			false,			"",      dfDateYmd,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					75,		daCenter,		true,			"cnee_cd",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					180,	daLeft,			true,			"cnee_nm",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					65,		daCenter,		true,			"shpr_cd",			false,			"",      dfNone,			0,		false,		false);
						
						InitDataProperty(0, cnt++ , dtData,					180,	daLeft,			true,			"shpr_nm",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,			"por_cd",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,			"pol_cd",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,			"pod_cd",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,			"del_cd",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,			"si_flg",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,			"gso",				false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,			"bkg_ofc_cd",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,			"bkg_stf",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,			"ctrt_ofc_cd",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,			"ctrt_srep_cd",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,			"ob_sls_ofc_cd",	false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,			"ob_srep_cd",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,			"cmdt_cd",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					150,	daCenter,		true,			"cmdt_nm",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,			"rate_check",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,				90,		daCenter,		true,			"brh_cfm_ind",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,				90,		daCenter,		true,			"dummy_flag",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtCombo,	   		    110,	daCenter,		true,			"rtro_knd_cd",		false,			"",      dfNone,			0,		false,		false);
						
						//InitDataCombo(0, "rtro_knd_cd", "Contract Change|Retroactive RFA|OFT change", "C|R|O"); // Text,Value 형태
						FrozenCols = 5;
                   }
                    break;


            }
        }
        
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            var param ;
            switch(sAction) {
	            case IBCLEAR: // 화면 로딩시 코드 조회
					formObj.f_cmd.value = COMMAND01;
					
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0417GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 4)
						ComXml2ComboItem(arrXml[4], formObj.elements["slan_cd"], "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
						formObj.slan_cd.InsertItem(0,"All","All");
		                formObj.slan_cd.Index =0 ;
					if (arrXml.length > 3) 
						ComXml2ComboItem(arrXml[3], formObj.del_conti, "val", "name");
					if (arrXml.length > 2) 
						ComXml2ComboItem(arrXml[2], formObj.rhq_cd, "val", "desc");
					if (arrXml.length > 1) 
						ComXml2ComboItem(arrXml[1], formObj.brh_cfm_ind, "val", "name");
					if (arrXml.length > 0) 
						ComXml2ComboItem(arrXml[0], formObj.bkg_sts_cd, "val", "name");
					
					if (arrXml.length > 5){
						ComXml2ComboItem(arrXml[5], formObj.rtro_knd_cd, "val", "name");
//						formObj.rtro_knd_cd.InsertItem(0,"","");
						var arrData = ComXml2ComboString(arrXml[5], "val", "name");
						sheetObj.InitDataCombo(0, "rtro_knd_cd",arrData[1], arrData[0]); // Text,Value 형태
					}
					
					//@ 2015.05.12 추가
					if (arrXml.length > 6){
						ComXml2ComboItem(arrXml[6], formObj.ofc_tp_cd, "val", "name");
					}
					
						ComSetObjValue(formObj.bkg_sts_cd," ");
						ComSetObjValue(formObj.brh_cfm_ind,"A");
						//ComSetObjValue(formObj.rhq_cd," ");
						ComSetObjValue(formObj.del_conti," ");
						formObj.rhq_cd.index = 0;
						//@ 2015.05.12 추가
						formObj.ofc_tp_cd.index = 0;
					break;
				case IBSEARCH:      //조회
					if(validateForm(sheetObj,formObj,sAction)){

			        	  formObj.f_cmd.value = SEARCH;
			        	  sheetObj.WaitImageVisible = false;
			        	  formObj.curr_page.value = 1;//PageNo를 초기화 하기 위함
			        	  form.rows_per_page.value = rowsPerPage;
			        	  ComOpenWait(true); //대기이미지 표시
			        	  //sheetObj.RemoveEtcData(); 
			        	  sheetObj.RemoveAll();
			        	  
			        	try {  
			        	  var sXml = sheetObj.GetSearchXml("ESM_BKG_0417GS.do", FormQueryString(formObj));
			        	  
			        	  if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") != 'S') {
			        		  sheetObj.LoadSearchXml(sXml);	
			        		  ComOpenWait(false); //대기이미지 숨김
			        		  return;
			        	  }	  
			        	  formObj.f_cmd.value = SEARCH02;
			        	  var sXml2 = sheetObj.GetSearchXml("ESM_BKG_0417GS.do", FormQueryString(formObj));
			        	  
			        	  sheetObj.LoadSearchXml(sXml);
			        	  f_setTotalVal(sheetObj,sXml2);
			        	  
						} catch (e) {
							if (e == "[object Error]") {
								ComShowMessage(OBJECT_ERROR);
							} else {
								ComShowMessage(e);
							}
							ComOpenWait(false); //대기이미지 숨김
							return false;
						}
			        	  
			        	  ComOpenWait(false); //대기이미지 숨김
					}	  
			        break;
				case IBSEARCHAPPEND:  // 페이징 조회
					formObj.f_cmd.value = SEARCH01;
					var curr_page = Number(sheetObj.RowCount) / Number(ComGetObjValue(formObj.rows_per_page)) + 1;
					
					formObj.curr_page.value = curr_page;
					
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true); //대기이미지 표시
					
					sheetObj.RemoveEtcData(); 
					sheetObj.DoSearch("ESM_BKG_0417GS.do", FormQueryString(formObj)
							+ "&" + ComGetPrefixParam(""),"iPage=" + curr_page, true);
					ComOpenWait(false); //대기이미지 숨김
					break;	      
				case IBDOWNEXCEL:      // 입력
				
					sheetObj.SpeedDown2Excel(-1);
					/*if(validateForm(sheetObj,formObj,IBSEARCH)){
			        	  formObj.f_cmd.value = SEARCH;
			        	  sheetObj.WaitImageVisible = false;
			        	  formObj.curr_page.value = 1;//PageNo를 초기화 하기 위함
			        	  formObj.rows_per_page.value = "9999999";
			        	  
			        	  ComOpenWait(true); //대기이미지 표시
			        	  //sheetObj.DirectDown2Excel("ESM_BKG_0417_EXL_GS.do", FormQueryString(formObj), 0);
			        	  //sheetObj.DirectDown2Excel("ESM_BKG_0417_EXL_GS.do", FormQueryString(formObj), -1);
			        	  
			        	  //sheetObj.Redraw = true;
			        	  //formObj.target = "_top";
			        	  formObj.action = "ESM_BKG_0417_EXL_GS.do";
			        	  formObj.submit();
			        	  
			        	  hiddenFrame.location.href = "ESM_BKG_0417_EXL_GS.do?"+FormQueryString(formObj);
			        	  ComOpenWait(false); //대기이미지 숨김
					}	*/  
			        break;	
			        
				case SEARCH03:      // 입력
					formObj.f_cmd.value = SEARCH03;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0417GS.do", FormQueryString(formObj));
	                var arrXml = sXml.split("|$$|");
	                
	                ComXml2ComboItem(arrXml[5], formObj.elements["slan_cd"], "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
	                formObj.slan_cd.InsertItem(0,"All","All");
	                formObj.slan_cd.Index =0 ;
			        break;	
            }
        }
      
        /**
         * 스크롤을 움직여 리스트의 최 하단에 도착했을 때 조회할 내역이 남은 경우 발생하는 Event <br>
         */
        function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND);
        }
        
        function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        	var formObj = document.form;
        	
        	for( var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount ; i++){
        		if(sheetObj.Cellvalue(i,  "rate_check") == "Y"){
        			sheetObj.CellFontColor(i, "rate_check") = sheetObj.RgbColor(255, 0, 0);
	   			}
        	}
		   		        	
        	comBkgIndicateLink(sheetObj,"bkg_no");
        	
        	return;
        	var bk_tot_cnt = bk_charge_cnt = bk_non_charge_cnt = bk_percent =  0;
        	var rt_tot_cnt = rt_charge_cnt = rt_firm_cnt = rt_estimated_cnt = rt_non_charge_cnt = rt_percent = 0;
        	var cntr_tot_cnt = cntr_firm_cnt = cntr_balance_cnt = cntr_percent = 0;
        	var cn_tot_cnt = cn_code_cnt = cn_balance_cnt  = cn_percent = 0;
        	var cont_tot_cnt = cont_act_cnt = cont_dummy_cnt = cont_balance_cnt = cont_percent = 0;
	   		with (sheetObj) {
		   		 for (var i=1;i<Rows ;i++){
		   			if (CellValue(i, "bkg_sts_cd") != "W") {
		   				bk_charge_cnt++;
		   			}
		   			if (CellValue(i, "brh_cfm_ind") == "F") {
		   				rt_firm_cnt++;
		   			}
		   			/*if (CellValue(i, "brh_cfm_ind") == "E") {
		   				rt_estimated_cnt++;
		   			}*/
		   			
		   			/*CNTR Confirm*/
		   			if (CellValue(i, "cntr_cfm_flg") == "Y") {
		   				cntr_firm_cnt++;
		   			}
		   			/*CN/NF Code*/
		   			if (CellValue(i, "cnee_cd") != "") {
		   				cn_code_cnt++;
		   			}
		   			/*Contract No*/
		   			if (CellValue(i, "ctrt_no") != "" && CellValue(i, "dummy_flag") != "Y") {
		   				cont_act_cnt++;
		   			}
		   			if (CellValue(i, "dummy_flag") == "Y") {
		   				cont_dummy_cnt++;
		   			}
		   			
		   			
		   	     }
		   		/*----------------------------------------------------------------*/ 
		   		 
		   		
		   		rt_charge_cnt = rt_firm_cnt+rt_estimated_cnt;
		   		
		   		bk_tot_cnt = RowCount ;
		   		rt_tot_cnt = RowCount ;
		   		bk_non_charge_cnt = bk_tot_cnt -bk_charge_cnt;
		   		rt_non_charge_cnt = rt_tot_cnt -rt_charge_cnt;
		   		                                
		   		if (bk_non_charge_cnt != 0){
			   		bk_percent =  ComRound(bk_non_charge_cnt/bk_tot_cnt*100)+"%";
		   		}else{
		   			bk_percent =  bk_non_charge_cnt+"%";
		   		}
		   		if (rt_non_charge_cnt != 0){
			   		rt_percent =  ComRound(rt_non_charge_cnt/rt_tot_cnt*100)+"%";
		   		}else{
			   		rt_percent =  rt_non_charge_cnt+"%";
		   		}

		   		/*----------------------------------------------------------------*/
		   		cntr_tot_cnt = cn_tot_cnt = cont_tot_cnt = RowCount;
		   		
		   		cntr_balance_cnt = cntr_tot_cnt - cntr_firm_cnt;
		   		cn_balance_cnt	= cn_tot_cnt - cn_code_cnt;
		   		cont_balance_cnt  =  cont_tot_cnt - cont_act_cnt - cont_dummy_cnt;
		   		
		   		if (cntr_balance_cnt != 0){
		   			cntr_percent =  ComRound(cntr_balance_cnt/cntr_tot_cnt*100)+"%";	
		   		}else{
		   			cntr_percent =	cntr_percent+"%";
		   		}
		   		if (cn_balance_cnt != 0){
		   			cn_percent =  ComRound(cn_balance_cnt/cn_tot_cnt*100)+"%";	
		   		}else{
		   			cn_percent =  cn_percent+"%";
		   		}
		   		if (cont_balance_cnt != 0){
		   			cont_percent =  ComRound(cont_balance_cnt/cont_tot_cnt*100)+"%";	
		   		}else{
		   			cont_percent =  cont_percent+"%";
		   		}
	   		}
	   		/*Booking Status*/
	   		ComSetObjValue(formObj.bk_tot_cnt,bk_tot_cnt);
	   		ComSetObjValue(formObj.bk_charge_cnt,bk_charge_cnt);
	   		ComSetObjValue(formObj.bk_non_charge_cnt,bk_non_charge_cnt);
	   		ComSetObjValue(formObj.bk_percent,bk_percent);
	   		
	   		/*Rating Status*/
	   		ComSetObjValue(formObj.rt_tot_cnt,rt_tot_cnt);
	   		ComSetObjValue(formObj.rt_firm_cnt,rt_firm_cnt);
	   		ComSetObjValue(formObj.rt_non_charge_cnt,rt_non_charge_cnt);
	   		ComSetObjValue(formObj.rt_percent,rt_percent);
	   		
	   		/*CNTR Confirm*/
	   		ComSetObjValue(formObj.cntr_tot_cnt,cntr_tot_cnt);
	   		ComSetObjValue(formObj.cntr_firm_cnt,cntr_firm_cnt);
	   		ComSetObjValue(formObj.cntr_balance_cnt,cntr_balance_cnt);
	   		ComSetObjValue(formObj.cntr_percent,cntr_percent);
	   		
	   		/*CN/NF Code*/
	   		ComSetObjValue(formObj.cn_tot_cnt,cn_tot_cnt);
	   		ComSetObjValue(formObj.cn_code_cnt,cn_code_cnt);
	   		ComSetObjValue(formObj.cn_balance_cnt,cn_balance_cnt);
	   		ComSetObjValue(formObj.cn_percent,cn_percent);
	   		
	   		/*Contract No*/
	   		ComSetObjValue(formObj.cont_tot_cnt,cont_tot_cnt);
	   		ComSetObjValue(formObj.cont_act_cnt,cont_act_cnt);
	   		ComSetObjValue(formObj.cont_dummy_cnt,cont_dummy_cnt);
	   		ComSetObjValue(formObj.cont_balance_cnt,cont_balance_cnt);
	   		ComSetObjValue(formObj.cont_percent,cont_percent);
	   		
        	
   		}
        function f_setTotalVal(sheetObj,xmlStr){
        	var formObj = document.form;
        	with(sheetObj){
	        	if (ComGetEtcData(xmlStr,"TRANS_RESULT_KEY") == 'S') {
		        	ComSetObjValue(formObj.bk_tot_cnt,ComGetEtcData(xmlStr,"bk_tot_cnt"));
		        	ComSetObjValue(formObj.bk_charge_cnt,ComGetEtcData(xmlStr,"bk_charge_cnt"));
			   		ComSetObjValue(formObj.bk_non_charge_cnt,ComGetEtcData(xmlStr,"bk_non_charge_cnt"));
			   		ComSetObjValue(formObj.bk_percent,ComGetEtcData(xmlStr,"bk_percent"));
			   		
			   		/*Rating Status*/
			   		ComSetObjValue(formObj.rt_tot_cnt,ComGetEtcData(xmlStr,"rt_tot_cnt"));
			   		ComSetObjValue(formObj.rt_firm_cnt,ComGetEtcData(xmlStr,"rt_firm_cnt"));
			   		ComSetObjValue(formObj.rt_non_charge_cnt,ComGetEtcData(xmlStr,"rt_non_charge_cnt"));
			   		ComSetObjValue(formObj.rt_percent,ComGetEtcData(xmlStr,"rt_percent"));
			   		
			   		/*CNTR Confirm*/
			   		ComSetObjValue(formObj.cntr_tot_cnt,ComGetEtcData(xmlStr,"cntr_tot_cnt"));
			   		ComSetObjValue(formObj.cntr_firm_cnt,ComGetEtcData(xmlStr,"cntr_firm_cnt"));
			   		ComSetObjValue(formObj.cntr_balance_cnt,ComGetEtcData(xmlStr,"cntr_balance_cnt"));
			   		ComSetObjValue(formObj.cntr_percent,ComGetEtcData(xmlStr,"cntr_percent"));
			   		
			   		/*CN/NF Code*/
			   		ComSetObjValue(formObj.cn_tot_cnt,ComGetEtcData(xmlStr,"cn_tot_cnt"));
			   		ComSetObjValue(formObj.cn_code_cnt,ComGetEtcData(xmlStr,"cn_code_cnt"));
			   		ComSetObjValue(formObj.cn_balance_cnt,ComGetEtcData(xmlStr,"cn_balance_cnt"));
			   		ComSetObjValue(formObj.cn_percent,ComGetEtcData(xmlStr,"cn_percent"));
			   		
			   		/*Contract No*/
			   		ComSetObjValue(formObj.cont_tot_cnt,ComGetEtcData(xmlStr,"cont_tot_cnt"));
			   		ComSetObjValue(formObj.cont_act_cnt,ComGetEtcData(xmlStr,"cont_act_cnt"));
			   		ComSetObjValue(formObj.cont_dummy_cnt,ComGetEtcData(xmlStr,"cont_dummy_cnt"));
			   		ComSetObjValue(formObj.cont_balance_cnt,ComGetEtcData(xmlStr,"cont_balance_cnt"));
			   		ComSetObjValue(formObj.cont_percent,ComGetEtcData(xmlStr,"cont_percent"));
			   		
			   		/* No Rate Status */
			   		ComSetObjValue(formObj.no_rt_tot_cnt,ComGetEtcData(xmlStr,"no_rt_tot_cnt"));
			   		ComSetObjValue(formObj.no_rt_frm_cnt,ComGetEtcData(xmlStr,"no_rt_frm_cnt"));
			   		ComSetObjValue(formObj.no_rt_cnt,ComGetEtcData(xmlStr,"no_rt_cnt"));
			   		ComSetObjValue(formObj.no_rt_percent,ComGetEtcData(xmlStr,"no_rt_percent"));
			   		
			   		/*
				   	if (ComGetEtcData(xmlStr,"total_cnt") > "0"){	
				   		CountFormat = "[" + "1 / "+ ComAddComma(ComGetEtcData(xmlStr,"total_cnt")) +"]";
	        		}else{
	        			CountFormat = "[" + "0 / "+ ComAddComma(ComGetEtcData(xmlStr,"total_cnt")) +"]";
	        		}*/
	    		}	
        	}	
        }
        function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
    		var colName = sheetObj.ColSaveName(colIdx);
    		if (colName == "bkg_no"){
    			comBkgCallBkgDetail(sheetObj.CellValue(rowIdx, colName));
     		}
    		
    	    if(colName == "ctrt_cust_nm"){
    	    	ComShowMemoPad(sheetObj, rowIdx, colName, true, 200, 100, 200 );
//    	        if(sheetObj.RowHeight(rowIdx) == 20){
//    	            sheetObj.RowHeight(rowIdx) = 0;
//    	        }else{
//    	            sheetObj.RowHeight(rowIdx) = 20;
//    	        }
    	    }    		
    		
      	}
        
        function sheet1_OnClick(sheetObj, Row, Col, Value) {
        	//sheetObj.CountFormat = "[" +ComAddComma(Row) +" / "+ ComAddComma(sheetObj.EtcData("total_cnt")) +"]";
    	}
        
        /**
         * 콤보 초기설정값
         * @param {IBMultiCombo} comboObj  comboObj
         */
         function initCombo(comboObj) {
         	comboObj.DropHeight = 150;
         	
         	with (comboObj) {
         		if(id == "rtro_knd_cd"){
         			MultiSelect = true;
         		}
         	}
         }  

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	with(formObj){
            	switch(sAction) {

					case IBSEARCH: // 조회시 확인

		         		if (!ComChkValid(formObj)) return false;
		         		/*
		         		1.vvd,pol 입력시
		         		2.etd입력..
		         		*/
		         		if (ComGetObjValue(formObj.vvd_cd) == "" &&  ComGetObjValue(formObj.atd) == ""){
		         			ComAlertFocus(vvd_cd,ComGetMsg('BKG00829'));
		         			return;
		         		}
		         		
		         		if (!ComIsNull(formObj.atd) && !ComIsNull(formObj.etd) && ComGetDaysBetween(formObj.atd.value, formObj.etd.value) > 31){
			           		 
		         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
		         			formObj.atd.focus();
		         			return false;
		         		}
		         		
		         		break;
            	}	
            }
            return true;
        }
        
        /**
         * ETD,ETB 기간 선택 달력 띄우기
         */
      	function callDatePop(val){
      		var cal = new ComCalendarFromTo();
      		if (val == 'ETD'){
      			cal.select(form.atd,  form.etd,  'yyyy-MM-dd');
      		}
      	}
      	
        /**
	     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	     **/
	    function obj_activate(){
	    	//입력Validation 확인하기
	    	switch(event.srcElement.name){
	    	
		    	case "atd":
		    		ComClearSeparator(event.srcElement);
	    			break;
		    	case "etd":
		    		ComClearSeparator(event.srcElement);
	    			break;
		    	
	    		default:
	    			break;
	    	}
	    }
	    
		/**
	     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	     **/
	    function obj_deactivate(){
	    	//if (event.srcElement.getAttribute("required") != null) return;
	    	
	        //입력Validation 확인하기
	    	switch(event.srcElement.name){
	    	
		    	case "atd":
		    		ComAddSeparator(event.srcElement);
	    			break;
		    	case "etd":
		    		ComAddSeparator(event.srcElement);
	    			break;
		    	
	    		default:
	    			break;
	    	}
	    }
	    function CheckGrid(sheetObject,colName){
			var iCheckRow = sheetObject.FindCheckedRow(colName); 
			if (iCheckRow== "") {
				ComShowCodeMessage('BKG00249');
				return false;
			}
			return true;
		}	
	    function getCheckedRow(sheetObj,colName) {
			var checkRow;
			for(var iRow = 0; iRow < sheetObj.Rows; iRow++) {
				if(sheetObj.CellValue(iRow, colName) == 1) {					
		  			return iRow;
	     		}
	  		}
	    }
	/* 개발자 작업  끝 */
	    
	    