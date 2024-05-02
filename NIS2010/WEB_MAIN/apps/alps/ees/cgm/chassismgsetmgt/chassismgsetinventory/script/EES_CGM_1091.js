/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1091.js
*@FileTitle : Chassis Inventory List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.22 김창식
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.01.26 신혜정 [선조치] Inventory List Reference No 추가
* 2013.09.05 조경완 [CHM-201326311-01] ALPS CHSS-Inventory-General Inventory-Chassis Inventory List에 항목 추가 요청
* 2014.11.19 Chang Young Kim, CHM-201432568
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


    /**
     * @extends 
     * @class EES_CGM_1091 : EES_CGM_1091 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1091() {
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

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.09
     */ 
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_downexcel":
                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                    break;
                      
                case "btn_close":
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
     * IBSheet Object를 배열로 등록 <br>
     * @param  {object} sheetObj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.07.09
     */
    function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.09
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

 	/**
 	 * 시트 초기설정값, 헤더 정의 <br>
 	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 	 * @param  {object} sheetObj	필수	 Sheet Object
 	 * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
 	 * @return 없음
 	 * @author 김창식
 	 * @version 2009.07.09
 	 */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 402;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);
                     
                    var HeadTitle = "|Seq.|Chassis No.|TP/SZ|Term|AGMT No.|Reference No.|Lessor|MVMT|LCC|SCC|Yard|Manufacture Date|On-Hire Date|Original On-Hire Date|MVMT Date|L/S Days|CNTR No|MG.set No|Bare|Damage|Disposal";
                    var headCount = ComCountHeadTitle(HeadTitle);
                     
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false) 

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,	daCenter, false, "hdnStatus");
                    InitDataProperty(0, cnt++ , dtDataSeq,  	50, daCenter, false, "Seq");
                    InitDataProperty(0, cnt++ , dtData,  		90,	daCenter, false, "eq_no",			false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++ , dtData,   	 	50, daCenter, false, "eq_tpsz_cd",   	false, "", dfNone,     	  0, false, false);
 					InitDataProperty(0, cnt++ , dtData,  		50, daCenter, false, "agmt_lstm_cd",   	false, "", dfNone,     	  0, false, false);
 										
                    InitDataProperty(0, cnt++ , dtData,	 		75, daCenter, false, "agmt_no",    		false, "", dfNone,     	  0, false, false);
                    InitDataProperty(0, cnt++ , dtData,	 		110,daCenter, false, "agmt_ref_no",	    false, "", dfNone,     	  0, false, false);
                    InitDataProperty(0, cnt++ , dtData,	 		55, daCenter, false, "vndr_abbr_nm",   	false, "", dfNone,  	  0, false, false);
                    InitDataProperty(0, cnt++ , dtData,	 		55, daCenter, false, "chss_mvmt_sts_cd",false, "", dfNone,     	  0, false, false);
                    InitDataProperty(0, cnt++ , dtData,	 		55, daCenter, false, "lcc_cd",    		false, "", dfNone,     	  0, false, false);
                    InitDataProperty(0, cnt++ , dtData,	 		55, daCenter, false, "scc_cd",   		false, "", dfNone,  	  0, false, false);
                     
                    InitDataProperty(0, cnt++ , dtData,	 		65, daCenter, false, "crnt_yd_cd",   	false, "", dfNone,  	  0, false, false);
                    InitDataProperty(0, cnt++ , dtData,	 		120,daCenter, false, "mft_dt",			false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++ , dtData,	 		100,daCenter, false, "onh_dt",			false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++ , dtData,	 		130,daCenter, false, "act_onh_dt",			false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++ , dtData,	 		100,daCenter, false, "chss_mvmt_dt",  	false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++ , dtData,  		 50,daCenter, false, "lsdays",    		false, "", dfNone, 		  0, false, false);
                    
                    InitDataProperty(0, cnt++ , dtData,  		 90,daCenter, false, "cntr_no",    		false, "", dfNone, 		  0, false, false);
                    InitDataProperty(0, cnt++ , dtData,  		 90,daCenter, false, "mgst_no",    		false, "", dfNone, 		  0, false, false);
                    InitDataProperty(0, cnt++ , dtData,  		 50,daCenter, false, "bare_flg",    	false, "", dfNone, 		  0, false, false);
                    InitDataProperty(0, cnt++ , dtData,  		 50,daCenter, false, "dmg_flg",    		false, "", dfNone, 		  0, false, false);
                    InitDataProperty(0, cnt++ , dtData,  		 50,daCenter, false, "disp_flg",    	false, "", dfNone, 		  0, false, false);
 					InitUserFormat2(0, "chss_mvmt_dt", "####-##-## ##:##", "-|:" );
 					InitUserFormat2(0, "onh_dt", "####-##-## ##:##", "-|:" );
 					InitUserFormat2(0, "mft_dt", "####-##-## ##:##", "-|:" );
 					InitUserFormat2(0, "act_onh_dt", "####-##-## ##:##", "-|:" );
 					//CountPosition = 0;
 					
 					//MassOfSearch = 1;

                }
                break;

         }
     }

    /**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type
     * @return 없음
     * @author 김창식
     * @version 2009.07.09
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
	            // Form Object 값 설정
                formObj.f_cmd.value = SEARCH;
                formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
            
		 		//sheetObj.WaitImageVisible=false;
		 		//ComOpenWait(true);                
                ComOpenWait(true,false);

	     		// 조회실행
	     		var sXml = sheetObj.GetSearchXml("EES_CGM_1091GS.do" , FormQueryString(formObj));
	     		sheetObj.LoadSearchXml(sXml);
            
		 		ComOpenWait(false);	     		
                break;
                
            case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1);
				break;

        }
    }

 	/**
 	 * detail화면 double클릭시 해당 Equipment No에 대한 M.G.Set Master Inquiry 화면을 보여줌 <br>
 	 * 
 	 * @author 조재성
 	 * @version 2009.10.28
 	 */   
 	 function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH)
 	 {
 	 	var formObject = document.form;

     	if(Row >= 1)
      	{
  			if(sheetObj.cellValue(Row, "eq_no") == null || sheetObj.cellValue(Row, "eq_no") == "")
  			{
  				return;
  			}
  			var eqNo = sheetObj.cellValue(Row, "eq_no");
  			
  			var seq = sheetObj.cellValue(Row, "Seq");
  			if(seq != ''){
  				
  		  		var pgmNo = 'EES_CGM_1003';
  		  		var pgmUrl = '/hanjin/EES_CGM_1003.do';
  		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
  		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
  		    	
  		    	//var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
  		    	//var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
  		    	
  		    	ComOpenPopup("alpsMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);
  			}
      	}

 	 }          
	/* 개발자 작업  끝 */