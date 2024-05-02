/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BIS_0174.js
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.31 강동윤
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
     * @class ESM_BIS_0174 : ESM_BIS_0174 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BIS_0174() {
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
    
    var searchXml = "";
    
    var beforeIdx  = 0;
    
    var newItemIdx = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    

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

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );
            	
                sheetObjects[i].isible = false;
                
                initSheet(sheetObjects[i],i+1);
             
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            for(k=0;k<tabObjects.length;k++){
				initTab(tabObjects[k],k+1);
			}
    			
    		initControl();
    		
    		setDisplayOP();
    		
//    		document.form.vvd.value = "HNMD0032E";
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
      	var formObject = document.form;
      	
      	 /* KeyPress Event 받아서 format 변환 */      	 
      	  DATE_SEPARATOR ="-";
      	  
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
   

      }
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
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
                        style.height = 0;
                        //전체 너비 설정
                        SheetWidth = 0;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 3, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(7, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle = "";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);


                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	 	 	40,    daCenter,  true,    "ibflag");
                        InitDataProperty(0, cnt++ , dtHidden,  		 		25,    daCenter,  false,   "rpt_id",     	 	 	false,          "",      dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      		 	80,    daCenter,  false,   "rpt_nm", 				false,          "",      dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      		 	80,    daCenter,  false,   "bkg_rpt_knd_cd", 		false,          "",      dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      		 	80,    daCenter,  false,   "bzc_cond_sql_ctnt", 	false,          "",      dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      		 	80,    daCenter,  false,   "bzc_ord_ctnt", 		 	false,          "",      dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      		 	80,    daCenter,  false,   "temp_seq", 		 		false,          "",      dfNone,      0,     true,       true);

                   }
                    break;
                   
    				case "sheet2":
    	            	
    	                with (sheetObj) {
    	                    // 높이 설정
    	                    style.height = 470;
    	                    //전체 너비 설정
    	                    SheetWidth = mainTable.clientWidth;

    	                    //Host정보 설정[필수][HostIp, Port, PagePath]
    	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    	                    //전체Merge 종류 [선택, Default msNone]
    	                    MergeSheet = msHeaderOnly;

    	                   //전체Edit 허용 여부 [선택, Default false]
    	                    Editable = true;

    	                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	                    InitRowInfo(2, 2, 32, 100);

    						var HeadTitle1 = "|RHQ of C/A OFC|BKG OFC|C/A OFC|Contract OFC|Route|Route|Route|Route|B/L Q'ty|C/A Q'ty|" + 
    						                 "C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|Exempt|Class|Class|Class|" + 
    						                 "Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind";
    						var HeadTitle2 = "|RHQ of C/A OFC|BKG OFC|C/A OFC|Contract OFC|POR|POL|POD|DEL|B/L Q'ty|C/A Q'ty|" + 
    						                 "M|C|G|A|O|C.Haul|M.Haul|Exempt|R|N|E|A|B|C|D|E|F|G|H|I|J|K";
    	                    var headCount = ComCountHeadTitle(HeadTitle1);

    	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	                    InitColumnInfo(headCount, 0, 0, true);

    	                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
    	                    InitHeadMode(true, true, false, true, false,false)

    	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	                    InitHeadRow(0, HeadTitle1, true);
    						InitHeadRow(1, HeadTitle2, true);

    	                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    						
    						InitDataProperty(0, cnt++ , dtHiddenStatus,	40,    daCenter,  true,    "ibflag");
    						InitDataProperty(0, cnt++ , dtData,92,	daCenter,true,	"sls_rhq_cd"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,60,	daCenter,true,	"bkg_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,60,	daCenter,true,	"corr_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,80,	daCenter,true,	"ctrt_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"por_cd"			,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"pol_cd"			,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"pod_cd"			,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"del_cd"			,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,52,	daCenter,true,	"cnt_bl_ttl"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,54,	daCenter,true,	"cnt_ca_ttl"		,false,	"",	dfNone,	0,	false,	true);
    						
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_rsn_m"			,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_rsn_c"			,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_rsn_g"			,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_rsn_o"			,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_rsn_a"			,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"cnt_hlg_c"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"cnt_hlg_m"		,false,	"",	dfNone,	0,	false,	true);
    						
    						InitDataProperty(0, cnt++ , dtData,60,	daCenter,true,	"cnt_exempt"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_class_r"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_class_n"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_class_e"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_a"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_b"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_c"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_d"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_e"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_f"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_g"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_h"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_i"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_j"		,false,	"",	dfNone,	0,	false,	true);
    						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_k"		,false,	"",	dfNone,	0,	false,	true);
    						
    						CountPosition = 0;
    						
    						//MessageText("Sum") = "1st WEEK";
    		                //SetSortDialog(false);
    	               }
    	                break;
    	               
    				case "sheet3":      //sheet3 init
                    	with (sheetObj) {
                        // 높이 설정
                        style.height = 0;
                        //전체 너비 설정
                        SheetWidth = 0;
	                    //Host정보 설정[필수][HostIp, Port, PagePath]
	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                    //전체Merge 종류 [선택, Default msNone]
	                    MergeSheet = msHeaderOnly;

	                   //전체Edit 허용 여부 [선택, Default false]
	                    Editable = true;

	                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                    InitRowInfo(1, 1, 32, 100);

						var HeadTitle1 = "|B/L No|Bkg No|VVD|B/L OBRD Date|BKG OFC|RHQ of C/A OFC|Contract OFC|POR CD|POL CD|POD CD|DEL CD|C/A No|C/A Date|" + 
						                 "C/A OFC|C/A Staff|C/A Reason|Kind_A|Kind_B|Kind_C|Kind_D|Kind_E|Kind_F|Kind_G|Kind_H|Kind_I|Kind_J|Kind_K|" + 
						                 "SPLIT|CANCEL|CREATE|MODIFY|RATE USER|Customer Name|Remark";
						var headCount = ComCountHeadTitle(HeadTitle1);

	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                    InitColumnInfo(headCount, 0, 0, true);

	                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                    InitHeadMode(true, true, false, true, false,false)

	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                    InitHeadRow(0, HeadTitle1, true)

	                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						
						InitDataProperty(0, cnt++ , dtHiddenStatus,	40,    daCenter,  true,    "ibflag");
						InitDataProperty(0, cnt++ , dtData,92,	daCenter,true,	"bl_no"				,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,60,	daCenter,true,	"bkg_no"			,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,80,	daCenter,true,	"vvd"				,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,80,	daCenter,true,	"bl_obrd_dt"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,60,	daCenter,true,	"bkg_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,80,	daCenter,true,	"sls_rhq_cd"		,false,	"",	dfNone,	0,	false,	true);						
						InitDataProperty(0, cnt++ , dtData,80,	daCenter,true,	"ctrt_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"por_cd"			,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"pol_cd"			,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"pod_cd"			,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"del_cd"			,false,	"",	dfNone,	0,	false,	true);
						
						InitDataProperty(0, cnt++ , dtData,52,	daCenter,true,	"corr_no"			,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,54,	daCenter,true,	"corr_dt"			,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,80,	daCenter,true,	"corr_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,80,	daCenter,true,	"corr_usr_id"		,false,	"",	dfNone,	0,	false,	true);						
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"ca_rsn_cd"			,false,	"",	dfNone,	0,	false,	true);												
						
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_a"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_b"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_c"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_d"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_e"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_f"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_g"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_h"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_i"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_j"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cnt_kind_k"		,false,	"",	dfNone,	0,	false,	true);
						
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"bkg_split_modi_flg",false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cxl_modi_flg"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"cre_dt"			,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,30,	daCenter,true,	"upd_dt"			,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"upd_usr_id"		,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"cust_nm"			,false,	"",	dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"diff_rmk"			,false,	"",	dfNone,	0,	false,	true);
						
						CountPosition = 0;

                   }
                    break;
                   

            }
        }

         function setDisplayOP(){
        	 
        	 var formObj = document.form;
        	 
        	 var cnt = 0;
        	 
        	 with (sheetObjects[1]) {
	        	 
        		 Reset();
        		 // 높이 설정
	             style.height = 450;
	             //전체 너비 설정
	             SheetWidth = mainTable.clientWidth;
	
	             //Host정보 설정[필수][HostIp, Port, PagePath]
	             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	             //전체Merge 종류 [선택, Default msNone]
	             MergeSheet = msHeaderOnly;
	
	            //전체Edit 허용 여부 [선택, Default false]
	             Editable = true;
	
	             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	             InitRowInfo(2, 1, 32, 100);
	
				 var HeadTitle1 = "|RHQ of C/A OFC|BKG OFC|C/A OFC|Contract OFC|B/L Q'ty|C/A Q'ty|" + 
					              "C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|Exempt|Class|Class|Class|" + 
					              "Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind";
				 var HeadTitle2 = "|RHQ of C/A OFC|BKG OFC|C/A OFC|Contract OFC|B/L Q'ty|C/A Q'ty|" + 
					              "M|C|G|A|R|C.Haul|M.Haul|Exempt|R|N|E|A|B|C|D|E|F|G|H|I|J|K";
	             var headCount = ComCountHeadTitle(HeadTitle1);
	
	             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	             InitColumnInfo(headCount, 0, 0, true);
	
	             // 해더에서 처리할 수 있는 각종 기능을 설정한다
	             InitHeadMode(true, true, false, true, false,false)
	
	             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	             InitHeadRow(0, HeadTitle1, true);
				 InitHeadRow(1, HeadTitle2, true);
	
	             //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
				 InitDataProperty(0, cnt++ , dtHiddenStatus,	40,    daCenter,  true,    "ibflag");
				 
				 if (formObj.off_dis_op_1.checked == true){
					 InitDataProperty(0, cnt++ , dtData,92,	daCenter,true,	"sls_rhq_cd"		,false,	"",	dfNone,	0,	false,	true);
				 }else{
					 InitDataProperty(0, cnt++ , dtHidden,92,	daCenter,true,	"sls_rhq_cd"		,false,	"",	dfNone,	0,	false,	true);
				 }
				 
				 if (formObj.off_dis_op_2.checked == true){					 				
					 InitDataProperty(0, cnt++ , dtData,60,	daCenter,true,	"bkg_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
				 }else{
					 InitDataProperty(0, cnt++ , dtHidden,60,	daCenter,true,	"bkg_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
				 }
				 
				 if (formObj.off_dis_op_3.checked == true){
					 InitDataProperty(0, cnt++ , dtData,60,	daCenter,true,	"corr_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
				 }else{
					 InitDataProperty(0, cnt++ , dtHidden,60,	daCenter,true,	"corr_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
				 }
				 
				 if (formObj.off_dis_op_4.checked == true){
					 InitDataProperty(0, cnt++ , dtData,80,	daCenter,true,	"ctrt_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
				 }else{
					 InitDataProperty(0, cnt++ , dtHidden,80,	daCenter,true,	"ctrt_ofc_cd"		,false,	"",	dfNone,	0,	false,	true);
				 }
	 
//				 InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"por_cd"			,false,	"",	dfNone,	0,	false,	true);
//				 InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"pol_cd"			,false,	"",	dfNone,	0,	false,	true);
//				 InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"pod_cd"			,false,	"",	dfNone,	0,	false,	true);
//				 InitDataProperty(0, cnt++ , dtData,50,	daCenter,true,	"del_cd"			,false,	"",	dfNone,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,60,	daCenter,true,	"cnt_bl_ttl"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,60,	daCenter,true,	"cnt_ca_ttl"		,false,	"",	dfInteger,	0,	false,	true);
				
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_rsn_m"			,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_rsn_c"			,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_rsn_g"			,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_rsn_a"			,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_rsn_r"			,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,50,	daCenter,true,	"cnt_hlg_c"			,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,50,	daCenter,true,	"cnt_hlg_m"			,false,	"",	dfInteger,	0,	false,	true);
				
				 InitDataProperty(0, cnt++ , dtAutoSum,60,	daCenter,true,	"cnt_exempt"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_class_r"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_class_n"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_class_e"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_kind_a"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_kind_b"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_kind_c"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_kind_d"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_kind_e"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_kind_f"		,false,	"",	dfInteger,	0,	false,	true);
			 	 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_kind_g"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_kind_h"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_kind_i"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_kind_j"		,false,	"",	dfInteger,	0,	false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,40,	daCenter,true,	"cnt_kind_k"		,false,	"",	dfInteger,	0,	false,	true);
				
				 CountPosition = 0;
        	 }
         }
      
      // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
         function processButtonClick(){
              /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     	       var sheetObject1 = sheetObjects[0];
     	       var sheetObject2 = sheetObjects[1];
     	       var sheetObject3 = sheetObjects[2];
              /*******************************************************/
              var formObject = document.form;

         	try {
         		var srcName = window.event.srcElement.getAttribute("name");

                 switch(srcName) {
                   
	                 case "btn_addTemp":	                	 
	                	 addTemplate();
	                 break;
	                 
	                 case "btn_new":	                	 
	                	 ComResetAll();
	                	 setSqlCondition();
	                 break;
                 
	                 case "btn_Retrieve":	 
	                	 doActionIBSheet(sheetObjects[1],document.form,SEARCH);
	                 break;
                   
	                 case "btn_sum_excel":
	                	 sheetObject2.SpeedDown2Excel(-1);
     		    	 break;
     		    	 
	                 case "btn_bl_excel":
	                	 doActionIBSheet(sheetObjects[2],document.form,COMMAND01);
	                	 sheetObject3.SpeedDown2Excel(-1);
     		    	 break;
     		    	 
	                 case "btn_Print":
	                	 if(!validateForm(sheetObjects[1],document.form,SEARCH)) return;
	                	 setSqlCondition();
	                	 goPrint();
     		    	 break;
     		    	 
	                 case "btn_corr_sdate":
	                	 var cal = new ComCalendar();
	     				 cal.select(formObject.corr_from_dt, 'yyyy-MM-dd');
	     			 break;
	     				
	     			 case "btn_corr_edate":
	     				 var cal = new ComCalendar();
	     				 cal.select(formObject.corr_to_dt, 'yyyy-MM-dd');
	     			 break;
	     			 
	     			 case "btn_cre_sdate":
	                	 var cal = new ComCalendar();
	     				 cal.select(formObject.cre_from_dt, 'yyyy-MM-dd');
	     			 break;
	     				
	     			 case "btn_cre_edate":
	     				 var cal = new ComCalendar();
	     				 cal.select(formObject.cre_to_dt, 'yyyy-MM-dd');
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
         
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {

    						case INIT:      //INIT		
    						
    							ComClearCombo(formObj.rpt_nm);
    						
    							formObj.f_cmd.value = INIT;   
    							
	    						searchXml = sheetObj.GetSearchXml("ESM_BKG_0174GS.do" , FormQueryString(formObj));
								
								var listSize = ComGetEtcData(searchXml,"listSize");
								
								if (listSize > 0){																	
									
									/*
									for (var i = 0 ; i < listSize ; i++){
										
										formObj.rpt_nm.options[i] = new Option(ComGetEtcData(searchXml,"rptNm_" + i), "C:" + ComGetEtcData(searchXml,"rptId_" + i));
										
									}
									
									if (sheetObj.CellValue(1,6) != '' && sheetObj.CellValue(1,6) != undefined){
										
										formObj.rpt_nm[sheetObj.CellValue(1,6)].selected = true;
										setCondition(ComGetEtcData(searchXml,"seq_" + sheetObj.CellValue(1,6)), ComGetEtcData(searchXml,"ord_" + sheetObj.CellValue(1,6)),formObj);
									}else{
										
										setCondition(ComGetEtcData(searchXml,"seq_0"), ComGetEtcData(searchXml,"ord_0"),formObj);
									}
									*/
									
									for (var i = 0 ; i <= listSize  ; i++){
										
										if (i == 0){
										
											formObj.rpt_nm.options[i] = new Option("", "new");
										}else{
											
											formObj.rpt_nm.options[i] = new Option(ComGetEtcData(searchXml,"rptNm_" + i), "C:" + ComGetEtcData(searchXml,"rptId_" + i));
										}
										
									}
									
									formObj.reset();									
				 		        }
								
								setDisplayOP();
								
    						break;
    						
    						case SEARCH:      //조회		
    							
    							if(!validateForm(sheetObj,formObj,sAction)) return;
    						
    							setSqlCondition();
    						
    							tabObjects[0].SelectedIndex = "1";
    						
								formObj.f_cmd.value = SEARCH;   
								
    							sheetObj.DoSearch("ESM_BIS_0174GS.do",FormQueryString(formObj))    							    						
					
							break;
    							
	    						case COMMAND01:      //조회		
								
								if(!validateForm(sheetObj,formObj,sAction)) return;
	    						
	    						ComOpenWait(true);
								
	    						setSqlCondition();
							
								//tabObjects[0].SelectedIndex = "1";
							
								formObj.f_cmd.value = COMMAND01;   
								
								sheetObj.DoSearch("ESM_BIS_0174GS.do",FormQueryString(formObj))  
								
								ComOpenWait(false);
					
							break;
	
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
                        InsertTab( cnt++ , "Search" , -1 );
                        InsertTab( cnt++ , "Result" , -1 );
                    }
                 break;

             }
        }

        /**
         * Tab 클릭시 이벤트 관련
         * 선택한 탭의 요소가 활성화 된다.
         */
        function tab1_OnChange(tabObj , nItem)
        {
            var objs = document.all.item("tabLayer");

    	    	objs[nItem].style.display = "Inline";
    	    	objs[beforetab].style.display = "none";
    	    	/*
    	    	if (nItem == '0'){
    	    		
    	    		ComBtnDisable("btn_Print");
    	    	}else{
    	    		
    	    		ComBtnEnable("btn_Print");
    	    	}
    	    	*/
    
    	    	//--------------- 요기가 중요 --------------------------//
    	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	    	//------------------------------------------------------//
    	    	beforetab= nItem;
        }
      
       /**
        * change template name
        */
        /*
        function changeNm(){
        	
        	var formObj = document.form;
        	
        	var sheetObj = sheetObjects[0];
  
        	var before_rpt_id 		= formObj.rpt_nm.options[beforeIdx].value;
        	
        	var idx 				= formObj.rpt_nm.selectedIndex;
        	var now_rpt_id 			= formObj.rpt_nm.options[idx].value;
        	
        	if(!validateForm(sheetObj,formObj,0)){

        		formObj.rpt_nm.selectedIndex = beforeIdx;
        		
        		return;
        	}
        	
        	for (var i = 1 ; i < sheetObj.LastRow+1 ; i++){
        		
        		if (sheetObj.CellValue(i,1) == before_rpt_id){
        			
        			sheetObj.CellValue2(i, 4) = makeOption(formObj);
        			
        			if (sheetObj.CellValue(i, 0) != "I"){
        				
        				sheetObj.CellValue2(i, 0) = "U";
        			}else{
        				
        				sheetObj.CellValue2(i, 0) = "I";
        			}        					        		
	        		
	        		break;
        		}
        	}
        	        	
        	for (var i = 1 ; i < sheetObj.LastRow+1 ; i++){
        		
	        	if (sheetObj.CellValue(i,1) == now_rpt_id){	        			        	        		
	        		
	        		setCondition(sheetObj.CellValue(i, 4), "", formObj);
	        		
	        		break;
	        	}
	        }
        	
        	beforeIdx = idx;
        	
        	/*
        	if (rpt_id != "new"){
        		        	
        		setCondition(ComGetEtcData(searchXml,"seq_" + formObj.rpt_nm.selectedIndex), ComGetEtcData(searchXml,"ord_" + formObj.rpt_nm.selectedIndex),formObj);        		
        	}else{
        		
        		formObj.reset();
        		
        		formObj.rpt_nm[idx].selected = true;	
        	}
        	
        }
        */
        
        function changeNm(){
        	
        	formObj = document.form;
        	
        	var idx 				= formObj.rpt_nm.selectedIndex;
        	var rpt_id 				= formObj.rpt_nm.options[idx].value;
        	var rpt_nm 				= formObj.rpt_nm.options[idx].text;
        	
        	if (rpt_id != "new"){
        		        	
        		setCondition(ComGetEtcData(searchXml,"seq_" + formObj.rpt_nm.selectedIndex), ComGetEtcData(searchXml,"ord_" + formObj.rpt_nm.selectedIndex),formObj);        	
        	}else{
        		
        		formObj.reset();
        		
        		formObj.rpt_nm[idx].selected = true;	
        	}
        	
        	setDisplayOP();
        }
        /**
         * Make Option
         */
        function makeOption(formObj){
        	
        	var seq_ctnt = new Array();
        	
        	for (var i = 0 ; i < formObj.length ; i++){
         		
         		if (formObj[i].type == "checkbox"){
         			
         			if (formObj[i].checked == true){
         				
         				seq_ctnt[i] = formObj[i].name + "=" + "Y";
         			}else{
         				
         				seq_ctnt[i] = formObj[i].name + "=" + "N";
         			}        			
         		}else{
         			
         			if (formObj[i].name == "add_value"){
         				
         				seq_ctnt[i] = formObj[i].name + "=";
         			}else{
         			
         				seq_ctnt[i] = formObj[i].name + "=" + formObj[i].value;
         			}
         		}
         	}

        	return seq_ctnt.join("|");
        }
         
       
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */  
       function validateForm(sheetObject1,formObject,sAction){
        	
        	if (formObject.corr_from_dt.value == '' && 
        	    formObject.corr_to_dt.value == ''   &&
        	    formObject.cre_from_dt.value == ''  &&
        	    formObject.cre_to_dt.value == ''	&&
        	    formObject.vvd.value == ''){
        		
        		ComShowCodeMessage("BKG08029");//Please Input Period
        		formObject.corr_from_dt.focus();
				return false;
        	}
        	/*
        	if (formObject.corr_from_dt.value == ''){
        		
        		ComShowCodeMessage("BKG08029");//Please Input Period
        		formObject.corr_from_dt.focus();
				return false;
        	}
        	
        	if (formObject.corr_to_dt.value == ''){
        		
        		ComShowCodeMessage("BKG08029");//Please Input Period
        		formObject.corr_to_dt.focus();
				return false;
        	}
        	*/
        	
        	if (formObject.off_dis_op_5.checked == true && formObject.ca_issue_off.value == ''){
        		
        		ComShowCodeMessage("BKG00922");//Please, input Office Code!
    			formObject.ca_issue_off.focus();
				return false;
        	}
        	
        	if (formObject.off_dis_op_6.checked == true && formObject.del.value == ''){
        		
        		ComShowCodeMessage("BKG00290");//DEL is not available
    			formObject.del_off.focus();
				return false;
        	}
        	
        	if (formObject.vvd.value != ''){
        		
        		if (formObject.vvd.value.length < 9){
        			
        			ComShowCodeMessage("BKG00780");//T.VVD is 9 Digits
        			formObject.vvd.focus();
					return false;
        		}
        	}
        	
        	if (formObject.ca_issue_off.value != ''){
        		
        		if (formObject.ca_issue_off.value.length < 5){
        			
        			ComShowCodeMessage("BKG08031");//C/A Issue Office is 5 Digits
        			formObject.ca_issue_off.focus();
					return false;
        		}
        	}
        	
        	
        	return true;
        }                      
         
         /**
          * 화면 폼명,입력값 설정
          */  
        function checkFormType(sheetObj,formObj,seq_ctnt,ord_ctnt){
        	
        	ord_ctnt = "";
        	
         	for (var i = 0 ; i < formObj.length ; i++){
         		
         		if (formObj[i].type == "checkbox"){
         			
         			if (formObj[i].checked == true){
         				
         				seq_ctnt[i] = formObj[i].name + "=" + "Y";
         			}else{
         				
         				seq_ctnt[i] = formObj[i].name + "=" + "N";
         			}        			
         		}else{
         			
         			seq_ctnt[i] = formObj[i].name + "=" + formObj[i].value;
         		}
         	}
         }
          
          /**
           * condition setting
           */ 
        function setCondition(seqValue, ordValue, formObj){
        	 
        	var seq_ctnt = new Array();
         	var ord_ctnt = new Array(); 
         	
         	seq_ctnt = seqValue.split("|");
         	//ord_ctnt = ordValue.split("|");
         	
         	for (var i = 0 ; i < formObj.length ; i++){
         		
         		for (var j = 0 ; j < seq_ctnt.length ; j++){
	         		
         			var tempSeq = seq_ctnt[j].split("=");
	         		
         			if (formObj[i].name == tempSeq[0]){
         			
		         		if (formObj[i].type == "checkbox"){
		         			
		         			if (tempSeq[1] == "Y"){
		         				
		         				formObj[i].checked = true;
		         			}else{
		         				
		         				formObj[i].checked = false;
		         			}        			
		         		}else{
		         			
		         			if (formObj[i].name != "rpt_nm"){
		         				
		         				if (tempSeq[1] != undefined){
		         					
		         					formObj[i].value = tempSeq[1];
		         				}else{
		         					
		         					formObj[i].value = "";
		         				}		         				
		         			}
		         		}
		         		
		         		break;
         			}
         		}
         	}
         	
        }
        
       /**
        * open Add Template
        */    
       function addTemplate(){
    	   
    	   var param = ""
     	   var pWin = ComOpenWindow("/hanjin/ESM_BKG_0767.do" + param,"open0767", "statebar=no,width=700,height=570,left=200,top=0");
    	   //ComOpenPopup("/hanjin/ESM_BKG_0767.do" + param, 700, 570, 'reSearch', "1,0,1,1,1,1,1");
       }
        
       /**
        * open Add Template End Save Event
        */
       function reSearch(){
           	
    	   doActionIBSheet(sheetObjects[0],document.form,INIT);
    	   
    	   if (document.form.rpt_nm.length == 0){
    		   
    		   ComResetAll();
    	   }
       }
      
      /**
       * setting condition
       */   
      function setSqlCondition(){
    	  
    	  var formObj = document.form;
    	  
    	  var tempStr = "";
    	  var tempVal = "";
    	  var tempSql = "";
    	  var tempDis = "";
    	  var tempCnt = "";
    	  
    	  //CA REASON SETTING >>>>> START
    	  if (formObj.ca_reason_m.checked == true){
    		  
    		  tempStr = " COR.CA_RSN_CD = 'M' ";
    		  tempVal = "M";
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_reason_c.checked == true){
    			  
    			  tempStr += " OR COR.CA_RSN_CD = 'C' ";
    			  tempVal += ",C";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_reason_c.checked == true){
    			  
    			  tempStr = " COR.CA_RSN_CD = 'C' ";
    			  tempVal = "C"
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_reason_g.checked == true){
    			  
    			  tempStr += " OR COR.CA_RSN_CD = 'G' ";
    			  tempVal += ",G";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_reason_g.checked == true){
    			  
    			  tempStr = " COR.CA_RSN_CD = 'G' ";
    			  tempVal = "G";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_reason_a.checked == true){
    			  
    			  tempStr += " OR COR.CA_RSN_CD = 'A' ";
    			  tempVal += ",A";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_reason_a.checked == true){
    			  
    			  tempStr = " COR.CA_RSN_CD = 'A' ";
    			  tempVal = "A";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_reason_o.checked == true){
    			  
    			  tempStr += " OR COR.CA_RSN_CD = 'R' ";
    			  tempVal += ",R";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_reason_o.checked == true){
    			  
    			  tempStr = " COR.CA_RSN_CD = 'R' ";
    			  tempVal = "R";
    		  }
    	  }
    	  
    	  formObj.ca_reason.value 		= tempStr;
    	  formObj.ca_reason_val.value 	= tempVal;
    	  //CA REASON SETTING >>>>> END
    	  
    	  //CA CLASS SETTING >>>>> START
    	  tempStr = "";
    	  tempVal = "";
    	  
    	  if (formObj.ca_class_1.checked == true){
    		  
    		  tempStr = " COR.RAT_FLG = 'Y' ";
    		  tempVal = "R";
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_class_2.checked == true){
    			  
    			  tempStr += " OR COR.RAT_FLG = 'N' ";
    			  tempVal += ",N";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_class_2.checked == true){
    			  
    			  tempStr = " COR.RAT_FLG = 'N' ";
    			  tempVal = "N";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_class_3.checked == true){
    			  
    			  tempStr += " OR COR.EXPN_FLG = 'Y' ";
    			  tempVal += ",E";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_class_3.checked == true){
    			  
    			  tempStr = " COR.EXPN_FLG = 'Y' ";
    			  tempVal = "E";
    		  }
    	  }
    	  
    	  formObj.ca_class.value 		= tempStr; 
    	  formObj.ca_class_val.value 	= tempVal;
    	  //CA CLASS SETTING >>>>> END
    	  
    	  //CA KIND SETTING >>>>> START
    	  tempStr = "";
    	  tempVal = "";    	  
    	  
    	  if (formObj.ca_kind_a.checked == true){
    		  
    		  tempStr = " COR.RT_CORR_FLG = 'Y' ";
    		  tempVal = "A";
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_kind_b.checked == true){
    			  
    			  tempStr += " OR COR.CHG_TERM_CORR_FLG = 'Y' ";
    			  tempVal += ",B";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_kind_b.checked == true){
    			  
    			  tempStr = " COR.CHG_TERM_CORR_FLG = 'Y' ";
    			  tempVal = "B";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_kind_c.checked == true){
    			  
    			  tempStr += " OR COR.RCVDE_TERM_CORR_FLG = 'Y' ";
    			  tempVal += ",C";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_kind_c.checked == true){
    			  
    			  tempStr = " COR.RCVDE_TERM_CORR_FLG = 'Y' ";
    			  tempVal = "C";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_kind_d.checked == true){
    			  
    			  tempStr += " OR COR.ROUT_CORR_FLG = 'Y' ";
    			  tempVal += ",D";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_kind_d.checked == true){
    			  
    			  tempStr = " COR.ROUT_CORR_FLG = 'Y' ";
    			  tempVal = "D";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_kind_e.checked == true){
    			  
    			  tempStr += " OR COR.CUST_CORR_FLG = 'Y' ";
    			  tempVal += ",E";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_kind_e.checked == true){
    			  
    			  tempStr = " COR.CUST_CORR_FLG = 'Y' ";
    			  tempVal = "E";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_kind_f.checked == true){
    			  
    			  tempStr += " OR COR.QTY_CORR_FLG = 'Y' ";
    			  tempVal += ",F";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_kind_f.checked == true){
    			  
    			  tempStr = " COR.QTY_CORR_FLG = 'Y' ";
    			  tempVal = "F";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_kind_g.checked == true){
    			  
    			  tempStr += " OR COR.MEAS_QTY_CORR_FLG = 'Y' ";
    			  tempVal += ",G";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_kind_g.checked == true){
    			  
    			  tempStr = " COR.MEAS_QTY_CORR_FLG = 'Y' ";
    			  tempVal = "G";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_kind_h.checked == true){
    			  
    			  tempStr += " OR COR.CMDT_CORR_FLG = 'Y' ";
    			  tempVal += ",H";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_kind_h.checked == true){
    			  
    			  tempStr = " COR.CMDT_CORR_FLG = 'Y' ";
    			  tempVal = "H";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_kind_i.checked == true){
    			  
    			  tempStr += " OR COR.TRNK_VSL_CORR_FLG = 'Y' ";
    			  tempVal += ",I";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_kind_i.checked == true){
    			  
    			  tempStr = " COR.TRNK_VSL_CORR_FLG = 'Y' ";
    			  tempVal = "I";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_kind_j.checked == true){
    			  
    			  tempStr += " OR COR.PRPST_VSL_CORR_FLG = 'Y' ";
    			  tempVal += ",J";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_kind_j.checked == true){
    			  
    			  tempStr = " COR.PRPST_VSL_CORR_FLG = 'Y' ";
    			  tempVal = "J";
    		  }
    	  }
    	  
    	  if (tempStr != ""){
    		  
    		  if (formObj.ca_kind_k.checked == true){
    			  
    			  tempStr += " OR COR.CA_OTR_RSN_CORR_FLG = 'Y' ";
    			  tempVal += ",K";
    		  }
    	  }else{
    		  
    		  if (formObj.ca_kind_k.checked == true){
    			  
    			  tempStr = " COR.CA_OTR_RSN_CORR_FLG = 'Y' ";
    			  tempVal = "K";
    		  }
    	  }
    	  
    	  formObj.ca_kind.value 	= tempStr;
    	  formObj.ca_kind_val.value = tempVal;
    	  //CA KIND SETTING >>>>> END
    	  
    	  //CA OFFICE DISPLAY OPTION SETTING >>>>> START
    	  tempStr = "";
    	  tempVal = "";
    	  tempSql = "";
    	  tempCnt = "";
    	  
    	  if (formObj.off_dis_op_1.checked == true){
    		      		  
    	      tempStr += ",SLS_RHQ_CD ";
    	      tempCnt += ",CNT.SLS_RHQ_CD ";
    	      tempVal  = "RHQ OF C/A OFC";
    	      tempSql  = ",'RHQ of C/A OFC:' || SLS_RHQ_CD ";
    	  }
    	  
    	  if (tempStr != ""){
    	  
	    	  if (formObj.off_dis_op_2.checked == true){
	    		  
	    		  tempStr += ",BKG_OFC_CD ";
	    		  tempCnt += ",CNT.BKG_OFC_CD ";
	    		  tempVal += ",BKG OFC";
	    		  tempSql += " || 'BKG OFC:' || BKG_OFC_CD ";
	    	  }
    	  }else{
    	  
    		  if (formObj.off_dis_op_2.checked == true){
	    		  
	    		  tempStr += ",BKG_OFC_CD ";
	    		  tempCnt += ",CNT.BKG_OFC_CD ";
	    		  tempVal  = "BKG OFC";
	    		  tempSql  = ",'BKG OFC:' || BKG_OFC_CD ";
	    	  }
    	  }
	      
    	  if (tempStr != ""){
	    	  
    		  if (formObj.off_dis_op_3.checked == true){
	    		  
	    		  tempStr += ",CORR_OFC_CD ";
	    		  tempCnt += ",CNT.CORR_OFC_CD ";
	    		  tempVal += ",C/A OFC";
	    		  tempSql += " || 'C/A OFC:' || CORR_OFC_CD ";
	    	  }
    	  }else{
    		  
    		  if (formObj.off_dis_op_3.checked == true){
	    		  
	    		  tempStr += ",CORR_OFC_CD ";
	    		  tempCnt += ",CNT.CORR_OFC_CD ";
	    		  tempVal  = "C/A OFC";
	    		  tempSql  = ",'C/A OFC:' || CORR_OFC_CD ";
	    	  }
    	  }
    	  
    	  if (tempStr != ""){
	    	  
    		  if (formObj.off_dis_op_4.checked == true){
	    		      		  
	    		  tempStr += ",CTRT_OFC_CD ";
	    		  tempCnt += ",CNT.CTRT_OFC_CD ";
	    		  tempVal += ",Contract";
	    		  tempSql += " || 'Contract OFC:' || CTRT_OFC_CD ";
	    	  }
    	  }else{
    		  
    		  if (formObj.off_dis_op_4.checked == true){
	      		  
	    		  tempStr += ",CTRT_OFC_CD ";
	    		  tempCnt += ",CNT.CTRT_OFC_CD ";
	    		  tempVal  = "Contract";
	    		  tempSql += ",'Contract OFC:' || CTRT_OFC_CD ";
	    	  }
    		  
    	  }  
    	  
    	  if (tempVal != ''){
    		  
    		  if (formObj.off_dis_op_5.checked == true){
	      		  
	    		  tempVal += ",SUB OFC OF C/A ";
	    	  }
    	  }else{
    		  
    		  if (formObj.off_dis_op_5.checked == true){
	      		  
	    		  tempVal += "SUB OFC OF C/A ";
	    	  }
    	  }
    	  
    	  if (tempVal != ''){
    		  
    		  if (formObj.off_dis_op_6.checked == true){
	      		  
	    		  tempVal += ",SUB OFC OF DEL ";
	    	  }
    	  }else{
    		  
    		  if (formObj.off_dis_op_6.checked == true){
	      		  
	    		  tempVal += "SUB OFC OF DEL ";
	    	  }
    	  }
    	  
    	  if (tempSql == ""){
    		  
    		  tempSql = ",' '";
    	  }
    	  
    	  formObj.off_dis_op.value 		= tempStr;   	
    	  formObj.off_dis_op_val.value 	= tempVal;
    	  formObj.off_dis_op_sql.value 	= tempSql;
    	  formObj.off_dis_op_cnt.value	= tempCnt;
    	  //CA OFFICE DISPLAY OPTION SETTING >>>>> END
    	  
    	  //CA OTHER OPTION SETTING >>>>> START
    	  tempStr = "";
    	  tempVal = "";
    	  tempSql = "";
    	  
    	  if (formObj.other_op_1.checked == true){
    		  
    		  tempStr = " AND CNT.CNT_HLG_C <> 0 ";
    		  tempVal = "Include Carrier Haulage"; 
    	  }
    	  
    	  if (tempVal != ''){
    		  
    		  if (formObj.other_op_2.checked == true){
    			  
    			  tempStr += " AND CNT.CNT_HLG_M <> 0 ";
    			  tempVal += ",Include Merchant Haulage"; 
    		  }
    	  }else{
    		  
    		  if (formObj.other_op_2.checked == true){
    			  
    			  tempStr  = " AND CNT.CNT_HLG_M <> 0 ";
    			  tempVal  = "Include Merchant Haulage";
    		  }
    	  }
    	  
    	  if (tempVal != ''){
    		  
    		  if (formObj.other_op_3.checked == true){
    			  
    			  tempStr += " AND CNT.CNT_EXEMPT <> 0 ";
    			  tempVal += ",Exempt"; 
    		  }
    	  }else{
    		  
    		  if (formObj.other_op_3.checked == true){
    			  
    			  tempStr  = " AND CNT.CNT_EXEMPT <> 0 ";
    			  tempVal  = "Exempt";
    		  }
    	  }
    	  
    	  formObj.other_op.value	 = tempStr;
    	  formObj.other_op_val.value = tempVal;
    	  //CA OTHER OPTION SETTING >>>>> END
    	  
    	  //CA ROUTE SETTING >>>>> START
    	  tempStr = "";
    	  
    	  if (formObj.por.value != ''){
    	  
    		  tempStr += "POR:" + formObj.por.value;
    	  }else{
    		  
    		  tempStr += "POR:     ";
    	  }
    	  
    	  if (formObj.pol.value != ''){
        	  
    		  tempStr += ",POL:" + formObj.pol.value;
    	  }else{
    		  
    		  tempStr += ",POL:     ";
    	  } 
    	  
    	  if (formObj.pod.value != ''){
        	  
    		  tempStr += ",POD:" + formObj.pod.value;
    	  }else{
    		  
    		  tempStr += ",POD:     ";
    	  } 
    	  
    	  if (formObj.del.value != ''){
        	  
    		  tempStr += ",DEL:" + formObj.del.value;
    	  }else{
    		  
    		  tempStr += ",DEL:     ";
    	  } 
    	  
    	  formObj.route.value = tempStr;
    	  //CA ROUTE SETTING >>>>> END
      }
       /**
        * RD(Report Designer) Print
        */
        function goPrint(){		    			
        	
        	var sheetObj= sheetObjects[1];
   	 		
   	 	   	var formObj = document.form;
   	 		
   	 	   	var rdPath  = "apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0822.mrd";
   	 	   
   	 	    var corr_from_dt 	= " CORR_FROM_DT[" + formObj.corr_from_dt.value + "] ";
   	 	    
   	 	    var corr_to_dt		= " CORR_TO_DT[" + formObj.corr_to_dt.value + "] ";
   	 	    
   	 	    var bkg_from_dt		= " BKG_FROM_DT[" + formObj.cre_from_dt.value + "] ";
   	 	    
   	 	    var bkg_to_dt		= " BKG_TO_DT[" + formObj.cre_to_dt.value + "] ";
   	 	   
   	 	    var vvd				= " VVD[" + formObj.vvd.value + "] ";
   	 	    
   	 	    var ca_reason		= " CA_REASON[" + formObj.ca_reason_val.value + "] ";
   	 	 	    
   	 	    var ca_class		= " CA_CLASS[" + formObj.ca_class_val.value + "] ";   	 	    
   	 	    
   	 	    var ca_kind			= " CA_KIND[" + formObj.ca_kind_val.value + "] ";
   	 	    
   	 	    var ca_ofc			= " CA_OFC[" + formObj.ca_issue_off.value + "] ";
   	 	    
   	 	    var bkg_ofc			= " BKG_OFC[" + formObj.bkg_off.value + "] ";
   	 	    
   	 	    var del_ofc			= " DEL_OFC[" + formObj.del_off.value + "] ";
   	 	    
   	 	    var part			= " PART[" + formObj.part.value + "] ";
   	 	    
   	 	    var ctrt_ofc		= " CTRT_OFC[" + formObj.contract_off.value + "] ";
   	 	    
   	 	    var ca_staff		= " CA_STAFF[" + formObj.ca_issue_staff.value + "] ";
   	 	    
   	 	    var dis_op			= " DIS_OP[" + formObj.off_dis_op_val.value + "] ";
   	 	    
   	 	    var route			= " ROUTE[" + formObj.route.value + "] ";
   	 	    
   	 	    var other_op		= " OTHER_OP[" + formObj.other_op_val.value + "] ";
   	 	    
   	 	    var dis_op_sql		= " DIS_OP_SQL[" + formObj.off_dis_op_sql.value + "] ";
   	 	    
   	 	    var dis_col			= " DIS_COL[" + formObj.off_dis_op.value + "] ";
   	 	    
   	 	    var cnt_col			= " CNT_COL[" + formObj.off_dis_op_cnt.value + "] ";
   	 	    
   	 	    var cnt_where		= " CNT_WHERE[" + formObj.other_op.value + "] ";   	 	       	 	 
   	 	       	 	       	 	       	 	   
   	 	    var dis_where		= " DIS_WHERE[";
   	 	
   	 	    if (formObj.corr_from_dt.value != ''){
   	 	    	
   	 	    	dis_where += " AND COR.CORR_DT BETWEEN TO_DATE('" + formObj.corr_from_dt.value + "' || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE('" + formObj.corr_to_dt.value + "' || '23:59:59','YYYY-MM-DD HH24:MI:SS') ";    	 	    
   	 	    }
   	 	    
   	 	    if (formObj.cre_from_dt.value != ''){
	 	    	
	 	    	dis_where += " AND BKG.BKG_CRE_DT BETWEEN TO_DATE('" + formObj.cre_from_dt.value + "' || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE('" + formObj.cre_to_dt.value + "' || '23:59:59','YYYY-MM-DD HH24:MI:SS') "; 	 	    	
	 	    }
   	 	    
   	 	    if (formObj.vvd.value != ''){
   	 	    	
   	 	    	dis_where += " AND BKG.VSL_CD = '" + formObj.vvd.value.substring(0,4) + "' ";
   	 	    	dis_where += " AND BKG.SKD_VOY_NO = '" + formObj.vvd.value.substring(4,8) + "' ";
   	 	    	dis_where += " AND BKG.SKD_DIR_CD = '" + formObj.vvd.value.substring(8) + "' ";
   	 	    }
   	 	    
   	 	    //CA REASON
   	 	    if (formObj.ca_reason.value != ''){
   	 	    	
   	 	    	dis_where += " AND (" + formObj.ca_reason.value + ") \n";
   	 	    }
   	 	    
   	 	    //CA CLASS
   	 	    if (formObj.ca_class.value != ''){
   	 	    	
   	 	    	dis_where += " AND (" + formObj.ca_class.value + ")  ";
   	 	    }
   	 	    
   	 	    //CA KIND
   	 	    if (formObj.ca_kind.value != ''){
   	 	    	
   	 	    	dis_where += " AND (" + formObj.ca_kind.value + ")  ";
   	 	    }
   	 	    
   	 	    if (formObj.ca_issue_off.value != ''){
   	 	    	
   	 	    	dis_where += " AND COR.CORR_OFC_CD = '" + formObj.ca_issue_off.value + "'  ";
   	 	    }
   	 	    
   	 	    if (formObj.bkg_off.value != ''){
   	 	    	
   	 	    	dis_where += " AND BKG.BKG_OFC_CD = '" + formObj.bkg_off.value + "'  ";
   	 	    }
   	 	    
   	 	    if (formObj.del_off.value != ''){
   	 	    	
   	 	    	dis_where += " AND BKG.IB_SLS_OFC_CD = '" + formObj.del_off.value + "'  ";
   	 	    }
   	 	    
   	 	    if (formObj.part.value != ''){
   	 	    	
   	 	    	dis_where += " ";
   	 	    }
   	 	    
   	 	    if (formObj.contract_off.value != ''){
   	 	    	
   	 	    	dis_where += " AND BKG.CTRT_OFC_CD = '" + formObj.contract_off.value + "'  ";
   	 	    }
   	 	    
   	 	    if (formObj.ca_issue_staff.value != ''){
   	 	    	
   	 	    	dis_where += " AND COR.CRE_USR_ID = '" + formObj.ca_issue_staff.value + "'  ";
   	 	    }
   	 	    
   	 	    if (formObj.off_dis_op_5.checked == true){
   	 	    
   	 	    	dis_where += "  AND COR.CORR_OFC_CD IN (SELECT OFC_N8TH_LVL_CD  ";
   	 	        dis_where += "                            FROM DMT_OFC_LVL_V    ";
   	 	        dis_where += "                           WHERE '" + formObj.ca_issue_off.value + "' IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD,  ";
   	 	        dis_where += "                                                                          OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD)  ";
   	 	    }

   	 	    if (formObj.off_dis_op_6.checked == true){
   	 	   
   	 	    	dis_where += " AND BKG.DEL_CD IN (SELECT LOC_CD FROM MDM_LOCATION WHERE SLS_OFC_CD = '" + formObj.del_off.value + "')  ";
   	 	    }
   	 	    
   	 	    if (formObj.por.value != ''){
   	 	    	
   	 	    	dis_where += " AND BKG.POR_CD = '" + formObj.por.value + "'  ";
   	 	    }
   	 	    
   	 	    if (formObj.pol.value != ''){
	 	    	
	 	    	dis_where += " AND BKG.POL_CD = '" + formObj.pol.value + "'  ";
	 	    }
   	 	    
   	 	    if (formObj.pod.value != ''){
	 	    	
	 	    	dis_where += " AND BKG.POD_CD = '" + formObj.pod.value + "'  ";
	 	    }
   	 	    
   	 	    if (formObj.del.value != ''){
	 	    	
	 	    	dis_where += " AND BKG.DEL_CD = '" + formObj.del.value + "'  ";
	 	    }
   	 	    
   	 	    dis_where += "] ";   	 	       	 	    
   	 	    
   	 	    var cnt_where 		= " CNT_WHERE[" + formObj.other_op.value + "]  ";
   	 	    
   	 	    var where_tp 		= " WHERE_TP[";
   	 	    
   	 	    if (formObj.corr_from_dt.value != ''){
   	 	    	
   	 	    	where_tp += " WHERE BKG.BKG_NO = COR.BKG_NO ";
	   	 	    where_tp += "   AND COR.CORR_NO <> '0000000001' ";
	   	 	    where_tp += "   AND COR.CORR_CXL_FLG = 'N' ";
	   	 	    where_tp += "   AND COR.CA_RSN_CD NOT IN ('F','E') ";
   	 	    }else{
   	 	    	
   	 	    	where_tp += " WHERE BKG.BKG_NO = COR.BKG_NO(+) ";
   	 	    	where_tp += "   AND COR.CORR_NO(+) <> '0000000001' ";
   	 	    	where_tp += "   AND COR.CORR_CXL_FLG(+) = 'N' ";
   	 	    	where_tp += "   AND COR.CA_RSN_CD(+) NOT IN ('F','E') ";
   	 	    	where_tp += "   AND BKG.BKG_STS_CD IN ('F','W','A') ";
   	 	    }
   	 	    
   	 	    formObj.com_mrdTitle.value 		= "C/A Summary";
   	 	    formObj.com_mrdBodyTitle.value 	= "C/A Summary";
   	 	   	formObj.com_mrdPath.value 		= rdPath;
   	 	   	formObj.com_mrdArguments.value 	= "/rv " + corr_from_dt + corr_to_dt + bkg_from_dt + bkg_to_dt + vvd + ca_reason + ca_class + ca_kind + ca_ofc + bkg_ofc + del_ofc + part + ctrt_ofc + ca_staff + dis_op + route + other_op + dis_op_sql + dis_col + cnt_col + dis_where + cnt_where + where_tp;
   	 	   	//ComDebug(formObj.com_mrdArguments.value);
   	 	   	//alert(formObj.com_mrdArguments.value);
   	 	   	ComOpenRDPopup();
        }
    
	/* 개발자 작업  끝 */
        