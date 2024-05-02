/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : fns_joo_0101.js
*@FileTitle : ROB Container List Inquiry POP UP화면
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.04
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.02.04 민정호
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @extends 
	 * @class fns_joo_0101 : fns_joo_0101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_joo_0101() {
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
	var comboCnt = 0;
	 
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
		        case "btn_Row_Add":
					var row = sheetObject.DataInsert();		
					sheetObject.SelectCell(row,"",true);		
					break;

		        case "btn_Row_Delete":		        	
		        	var row = sheetObject.FindCheckedRow("del_chk");
		        	if (row == "") {
		        		ComShowCodeMessage("COM12189");
		        		return;
		        	}		        	
		        	ComRowHideDelete(sheetObject, "del_chk"); 		        	
		            break; 

		        case "btn_Save":   
		        	doActionIBSheet(sheetObject, formObject, IBSAVE);
		            break;
		            
				case "btn_Close":
					self.close();
		            break; 				
		            
				case "btn_Retrieve":
					doActionIBSheet(sheetObject, formObject, IBSEARCH);
					break;
					
				case "btn_New":
        			document.form.reset();
        			sheetObject.RemoveAll();
        			formObject.skd_dir_cd.Index2 = 0;
		            break; 				
		            				
			}
		} catch(e) {
			if (e == "[object Error]") {
				ComShowCodeMessage('JOO00001');
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
     * IBCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
     function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
     }	
     
     function sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
         document.form.slane_cd.focus();
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
		
        for(var k=0; k<comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }		
				
        initControl();		
	}
	
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object

     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
        var formObject = document.form;
        axon_event.addListenerForm  ('keydown', 'ComKeyEnter',  formObject);
        axon_event.addListenerForm  ('keydown', "fnOnKeyDown",  formObject);

        axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObject );
        axon_event.addListenerForm  ('change'  , 'fnObjChange', formObject );
        axon_event.addListenerForm  ('keyup'   , "fnObjKeyUp",  formObject);

        axon_event.addListener      ('click',   'fnDocClick', "srch_rlane_cd");

        axon_event.addListenerFormat('deactivate',  'fnDeactivate',  formObject);
        axon_event.addListenerFormat('activate',  'fnActivate',  formObject);        
    }	
        
      /**
       * Period NAVI 처리 이벤트
       * @param void
       * @return void
       */
       function fnDocClick(){
           var obj = event.srcElement;
           var formObj = document.form;
           
           switch (obj.name){
               case "srch_rlane_cd"://Lane 팝업 조회
                    var slane_cd = formObj.slane_cd.value;
                    var param = "?mode=svc&lane_cd="+slane_cd;
                    ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 820, 460, 'getCOM_ENS_081_1', '1,0,1,1,1,1,1,1', true, false, 0, 0, 0, "COM_ENS_081");
                    break;

           }
       }
       
       function getCOM_ENS_081_1(aryPopupData){
           with(document.form){
        	   slane_cd.value  = aryPopupData[0][3];
           }
       }       
    
        /**
         * <pre>
         *    form Element의 KeyPress Event 발생시 처리.
         *
         * </pre>
         * @return
         */
        function fnObjKeyPress(){
            var obj = event.srcElement;
            var formObj = document.form;
            var attr    = obj.getAttribute("dataformat");

            switch (attr){
                case  'ymd':
                      ComKeyOnlyNumber( obj );
                      break;

                case  'engup':
                      ComKeyOnlyAlphabet( 'upper' );
                      break;
                case  'uppernum':
                       ComKeyOnlyAlphabet( 'uppernum' );
                       break;

            }
        }
        
     function fnObjKeyUp(){
         var formObj = document.form;
         var obj     = event.srcElement;

         switch (obj.name){
               case  'slane_cd':
	                 var maxlength = obj.getAttribute("maxlength");
	                 if( obj.value.length != maxlength   ){
	                     return;
	                 }else{
	                     doActionIBSheet( sheetObjects[0], formObj, SEARCH01);
	                 }
	                 break;
         }
     }        
       
     /**
      * Combo 기본 설정
      * Combo의 항목을 설정한다.
      * @param comboObj
      * @param comboIndex Number
      */
      function initCombo(comboObj, comboNo ) {
          switch(comboObj.id) {
              case "skd_dir_cd":
                  with (comboObj) {
      		          UseCode = true;            	  
                      MultiSelect = false;
                      UseAutoComplete = true;
                      SetColAlign("left");
                      SetColWidth("60");
                      DropHeight = 200;
                      ValidChar(2,0);
                      MaxLength = 1;
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
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 240;

					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle1 = "|Sel.|Seq.|Lane|Dir|20'HC|20'HC|40'HC|40'HC|45'|45'|45'|Allocation|Allocation|TEU/TON|Round Type|Lane2|Dir2";
					var HeadTitle2 = "|Sel.|Seq.|Lane|Dir|Sub-Alloc|Over Ratio\n(TEU)|Sub-Alloc|Over Ratio\n(TEU)|Sub-Alloc|Under Ratio\n(TEU)|Over Ratio\n(TEU)|TEU|Weight|TEU/TON|Round Type|Lane2|Dir2";

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,   0,		daCenter,	true,  "ibflag");
		            InitDataProperty(0, cnt++ , dtDummyCheck,  40,    daCenter, 	true,   "del_chk");
		            InitDataProperty(0, cnt++ , dtDataSeq,	    	40,	daCenter,	true,		"");			
					InitDataProperty(0, cnt++ , dtData,		70, 	daCenter,	true,  "rlane_cd", 						true, "",   dfEngUpKey, 0,  true,  true,3);
					InitDataProperty(0, cnt++ , dtCombo,	50, 	daCenter,	true,  "skd_dir_cd", 					true, "",   dfEngUpKey, 0,  true,  true);					
					InitDataProperty(0, cnt++ , dtData,		80,	daRight,		false,  "jo_20ft_sub_teu_qty",  	false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80,	daRight,		false,  "jo_20ft_n1st_rto",  			false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, 	daRight,		false,  "jo_40ft_sub_teu_qty",  	false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80,	daRight,		false,  "jo_40ft_n1st_rto",     		false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, 	daRight,		false,  "jo_45ft_sub_teu_qty", 	false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80, 	daRight,		false,  "jo_45ft_n1st_rto", 			false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, 	daRight,		false,  "jo_45ft_n2nd_rto", 			false, "", dfFloat, 2,  true, true, 5);						
					InitDataProperty(0, cnt++ , dtData,		80, 	daRight,		false,  "jo_bsa_teu_qty", 			false, "", dfInteger, 2,  true, true, 8);		//Allocation TEU			
					InitDataProperty(0, cnt++ , dtData,		80, 	daRight,		false,  "cgo_ton_wgt", 				false, "", dfFloat, 2,  true, true, 8);		//Allocation Weight
					InitDataProperty(0, cnt++ , dtData,		80, 	daRight,		true,   "jo_ton_teu_qty", 				false, "", dfFloat, 2,  true, true, 8);		// TEU/TON							
					InitDataProperty(0, cnt++ , dtCombo,	80, 	daCenter,	true,   "jo_rnd_rule_lvl", 				false, "", dfNone, 2,  true, true);
					InitDataProperty(0, cnt++ , dtHidden,	80, 	daCenter,	true,   "org_rlane_cd", 				false, "", dfNone, 2,  true, true);
					InitDataProperty(0, cnt++ , dtHidden,	80, 	daCenter,	true,   "org_skd_dir_cd", 			false, "", dfNone, 2,  true, true);					
					
					InitDataCombo(0, "jo_rnd_rule_lvl", " |Round|Round Up|Round Down|No", " |1|2|3|4");													
					InitDataValid(0, "rlane_cd", vtEngUpOther, "0123456789");
				}
			break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch("FNS_JOO_0090GS.do", FormQueryString(formObj));
			break;

			case IBSAVE:       //저장
				formObj.f_cmd.value = MULTI02;												
				sheetObj.DoSave("FNS_JOO_0090GS.do", FormQueryString(formObj));				
				
		    case IBCLEAR:      				
                var param = "";
                var sXml = "";

                var code   =  "CD00593";
                formObj.f_cmd.value = SEARCH01;
                param = FormQueryString(formObj)+"&super_cd1="+code;
                sXml  = sheetObj.GetSearchXml("FNS_JOO_0057GS.do", param);

                //ComXml2ComboItem 생성후 ALL 항목을 맨앞에 추가시 index가 재설정이 안되어 아래 방식으로 적용 
                var comboString = ComXml2ComboString(sXml, "code", "name");
                var comboCodeList = comboString[0].split('|');
                var comboTextList = comboString[1].split('|');
                formObj.skd_dir_cd.RemoveAll();
                formObj.skd_dir_cd.InsertItem(-1, "", "");
                for (var w=0; w<comboCodeList.length; w++) {
                    formObj.skd_dir_cd.InsertItem(-1, comboTextList[w], comboCodeList[w]);
                }
                formObj.skd_dir_cd.Index2 = 0;

                
    			sheetObjects[0].InitDataCombo(0, "skd_dir_cd", " |" + comboString[0],  " |" + comboString[1]);                
			break;						
		}
	}

	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     }
	
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
    }

/* 개발자 작업  끝 */