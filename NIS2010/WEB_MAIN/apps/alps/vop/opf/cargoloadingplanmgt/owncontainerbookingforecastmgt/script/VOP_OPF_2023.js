/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_OPF_0021.js
 *@FileTitle : Own Container Booking Forecast Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.07
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.07.07 우지석
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2011.11.24 [CHM-201114488-01] 이준범
 * 제목 : CBF내 Block Stowage 칼럼추가 요청 건
 * 내용 : 1. CBF화면 내 MLB->Block Stowage로 명 변경
 *       2. Block Stowage 데이터가 Booking Main내 Service 
 *          Mode & Route data 에서 I/F 되는지 확인
 *       3. 첨부 UI설계와 같이 Block Stowage 칼럼 추가
 * 2011.11.29 [CHM-201114860-01] 김민아 [OPF] CBF Inquiry Excel Download 기능개선요청
 * 2011.12.12 [CHM-201114818-01] Split 03-특수화물(DG) 시스템 개선 요청(Segregation Group name 변경 외 3건)
 * 2013.06.20 CHM-201324915 SKY  CBF – POD TMNL code로 구분
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    function vop_opf_2023() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
		this.sheet1_OnChange        = sheet1_OnChange;    	
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 
 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;

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

             switch(srcName) {
				case "btn_retrieve":
	
				   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
					
			 	   break;
			 	 
				case "btn_Close":
					self.close();
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

		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    }
    

  	//Axon 이벤트 처리2. 이벤트처리함수
  	function obj_deactivate(){
  	    ComChkObjValid(event.srcElement);
  	}
  	
  	function obj_activate(){
  	    ComClearSeparator(event.srcElement);
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
        	//높이 설정
				style.height = 400;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 2, 100);
                
				var HeadTitle  = "|SEQ|KOREA CLL > CBF|KOREA CLL > CBF|KOREA CLL > CBF|KOREA CLL > CBF|KOREA CLL > CBF|KOREA CLL > CBF|KOREA CLL > CBF|KOREA CLL > CBF|KOREA CLL > CBF|" +
						"CBF > KOREA CLL|CBF > KOREA CLL|CBF > KOREA CLL|CBF > KOREA CLL|CBF > KOREA CLL|CBF > KOREA CLL|CBF > KOREA CLL|CBF > KOREA CLL|CBF > KOREA CLL|";
				var HeadTitle1 = "|SEQ|CNTR|BKG NO|POD|TS|MTY|DG|AWK|BB|BN|CNTR|BKG NO|POD|TS|MTY|DG|AWK|BB|BN";

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			    InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	 "ibflag");
				InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	 "seq"			     	,false	,""		,dfNone	,0	,false	,false	,5);
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, 	true, 	 "cntr_no"				,false	,""		,dfNone	,0	,false	,false	,5);
				InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	true, 	 "bkg_no"		        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	 "pod_cd"		        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "cntr_tpsz_cd"	     	,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "mty_flg"		        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "dg_flg"		        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "awk_flg"		        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "bb_flg"		        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "bn_flg"		        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, 	true, 	 "cntr_no2"				,false	,""		,dfNone	,0	,false	,false	,5);
				InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	true, 	 "bkg_no2"		        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	 "pod_cd2"	 	        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "cntr_tpsz_cd2"		,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "mty_flg2"		        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "dg_flg2"		        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "awk_flg2"		        ,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "bb_flg2"	        	,false	,""		,dfNone	,0	,false	,false	,2);
				InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "bn_flg2"		        ,false	,""		,dfNone	,0	,false	,false	,2);
       
         }
         break;
             
        
      }
   }

   function makeComma(srcValue){
		if(srcValue.length > 9){
	  		srcValue = srcValue.substring(0,9);
	  	}
			l=srcValue.length-3;
			while(l > 0) {
				srcValue=srcValue.substr(0,l)+","+srcValue.substr(l);
				l-=3;
			}    		
	  	return srcValue;
	  }
   
   // Sheet관련 프로세스 처리
   function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var sheetObject1 = sheetObjects[0];


		
     switch(sAction) {
       case IBSEARCH:        //조회

          //if(validateForm(sheetObj,formObj,sAction)){
			  sheetObj.WaitImageVisible=false;
			  ComOpenWait(true);        			  
			  formObj.f_cmd.value = SEARCH01;

			  sheetObj.DoSearch("VOP_OPF_2023GS.do", FormQueryString(formObj));

			  ComOpenWait(false);
      //    }
       break;
       
     
     }
   }

  
	/* 개발자 작업  끝 */