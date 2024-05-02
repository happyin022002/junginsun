/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7010.js
*@FileTitle : DEM/DET User Role Match
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.16
*@LastModifier : Lim Chang Bin
*@LastVersion : 1.0
* 2013.07.16 Lim Chang Bin
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
     * @class EES_DMT_7010 : EES_DMT_7010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_7010() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업   */

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;

    //  업무전역변수
    var tmp_usr_role_cd = "";
    var tmp_usr_role_nm = "";
    
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
                        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                        break;
                    case "btn_new":
                    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
                        break;
                    case "btn_save":
                    	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                        break;
                    case "btn_RowAdd": 
                    	doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
                        break;
                    case "btn_RowDelete":
                    	ComRowHideDelete(sheetObjects[0],"del_chk");
                        break;
                    case "btn_downExcel":
                        sheetObjects[0].speedDown2Excel(-1);
                        break;
                    case "btn_ofc_cd":
    					ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do?ofc_pts_cd=ALL', 700, 500, "ofc_cd:ofc_cd", '0,0,1,1,1,1,1,1', true);
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
    function loadPage(usr_role_cd, usr_role_nm) {
    	// IBMultiCombo초기화 
    	for(var k=0;k<comboObjects.length;k++){
    		initCombo(comboObjects[k],k+1, usr_role_cd, usr_role_nm);
    	}
    	
    	//html컨트롤 이벤트초기화
	    for(i=0;i<sheetObjects.length;i++){
	    	ComConfigSheet (sheetObjects[i] );
	    	initSheet(sheetObjects[i],i+1);
	    	ComEndConfigSheet(sheetObjects[i]);
	    }
    
	    initControl();
    }
    
    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
    function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}
   
    // 이벤트 처리 함수 선언
    function initControl() {
        axon_event.addListenerFormat('keypress','obj_keypress', document.form);         //- 키보드 입력할때
        axon_event.addListenerForm('change', 'obj_change', form);
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListener('click', 'incl_cntr_click', 'incl_cntr');    // 'Incl. CNTR Column' CheckBox 클릭시
    }
     
    //업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
         switch(event.srcElement.dataformat){
            case "engup":
                // 영문대
                ComKeyOnlyAlphabet('upper');
                break;
    	 	case "engnum":
		    	// 영대문자+숫자 
         		ComKeyOnlyAlphabet('uppernum');
		        break;
            case "int":
                //숫자 만입력하기
                ComKeyOnlyNumber(event.srcElement);
                break;
            default:
                // 숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
         }
     }
    
	//멀티콤보 클릭 이벤트
	function usr_role_cd_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
    	var cmpTxt = tmp_usr_role_cd.replace(/[\|,]/g ,  ",");

	    if(index==0) {
	    	var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
	    	}
	    } else if(comboObj.CheckIndex(0)) {
			comboObj.CheckIndex(0) = false;
	    } else if(comboObj.Code == cmpTxt) {
	    	// 모두 선택될 경우 All을 선택하도록 한다.
	    	comboObj.CheckIndex(0) = true;
	    }
	}
	
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo, usr_role_cd, usr_role_nm) {
		switch(comboObj.id) {
			case "usr_role_cd":
				with(comboObj) {
			    	MultiSelect = true;
			        MultiSeparator = ",";
			   	 	DropHeight = 320;
			   	 	
				    //DMT Role Code
			    	tmp_usr_role_cd = usr_role_cd;
			    	tmp_usr_role_nm = usr_role_nm;
			    	
			    	var arr_usr_role_cd = usr_role_cd.split("|");
			    	var arr_usr_role_nm = usr_role_nm.split("|");
	
				    with (form.usr_role_cd) {
				   	 	for ( var i=0; i<=arr_usr_role_cd.length; i++) {
				   	 		if(i==0) {
				   	 			InsertItem(0 , 'ALL','');
				   	 		}else{
				   	 			InsertItem(i, arr_usr_role_cd[i-1] +"|"+ arr_usr_role_nm[i-1], arr_usr_role_cd[i-1]);
				   	 		}
				   	 		
				   	 		CheckIndex(i) = true;
				   	 	}	   	 	
				    } 
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
                    style.height = 425;
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

                    var HeadTitle1 = "||Seq.|User|User|User|Role Code|Creation User ID|Creation Date|Updated User ID|Updated Date";
                    var HeadTitle2 = "||Seq.|ID|Name|Office|Role Code|Creation User ID|Creation Date|Updated User ID|Updated Date";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus	, 30	, daCenter	, false	, "ibflag");
                    InitDataProperty( 0	, cnt++ , dtCheckBox		, 30	, daCenter	, true 	, "del_chk");
                    InitDataProperty( 0 , cnt++ , dtSeq  			, 35  	, daRight 	, true 	, "seq"       		, false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData 			, 120  	, daLeft   	, true 	, "usr_id"    		, true 	, "" , dfNone,	0, false,	false	, 20	);
                    InitDataProperty( 0 , cnt++ , dtData 			, 180  	, daLeft   	, true 	, "usr_nm"    		, false , "" , dfNone,	0, false,	false );
                    InitDataProperty( 0 , cnt++ , dtData 			, 60  	, daCenter 	, true 	, "ofc_cd"    		, false , "" , dfNone,	0, false,	false );
                    InitDataProperty( 0 , cnt++ , dtCombo	 		, 80  	, daCenter 	, true 	, "usr_role_cd"    	, true 	, "" , dfNone,	0, false,	false );
                    InitDataProperty( 0 , cnt++ , dtData 			, 120  	, daLeft   	, true 	, "cre_usr_id"     	, false , "" , dfNone,	0, false,	false );
                    InitDataProperty( 0 , cnt++ , dtData 			, 100  	, daCenter 	, true 	, "cre_dt"    		, false , "" , dfNone,	0, false,	false );
                    InitDataProperty( 0 , cnt++ , dtData 			, 120 	, daLeft   	, true 	, "upd_usr_id"  	, false , "" , dfNone,	0, false,	false );
                    InitDataProperty( 0 , cnt++ , dtData 			, 100  	, daCenter 	, true 	, "upd_dt"      	, false , "" , dfNone,	0, false,	false );

                    InitDataCombo(0, "usr_role_cd", tmp_usr_role_cd, tmp_usr_role_cd);    // IBSheet내 Combo 초기화
                }
                
            break;
        }
    }

// Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
            case IBSEARCH:      //조회
//                if(!validateForm(sheetObj,formObj,sAction)) return;
                
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("EES_DMT_7010GS.do", FormQueryString(formObj));
                
                sheetObj.CheckAll("del_chk") = 0;
                break;
                
            case SEARCH22:      //조회
	            formObj.f_cmd.value = SEARCH22;
		          
			    ComOpenWait(true);
			    sheetObj.WaitImageVisible = false;
			    
		 	    var sXml = sheetObj.GetSearchXml("EES_DMT_7010GS.do", FormQueryString(formObj));
		 	    
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//조회 후 결과처리
				var svcResult = ComGetEtcData(sXml, "EXISTS_FLAG");
				
				if ( svcResult == "N" ){
					// 입력한 User ID가 등록되어 있지 않을 경우.
					ComShowCodeMessage("DMT00165", "User ID");
					return svcResult;
				}
				
				break;	
				
            case IBCLEAR:	// 화면 초기화 작업
            	
            	ComResetAll();		//sheet 초기화.
            	formObj.usr_id.value = "";
            	
            	var comboObj = comboObjects[0]
            	comboObj.Code = "";

            	for(var i = 0 ; i < comboObj.GetCount() ; i++) {
            		comboObj.CheckIndex(i) = true;
    	    	}

            	sheetObj.CheckAll("del_chk") = 0;
            	break;
            	
            case IBINSERT:
            	var row = sheetObj.DataInsert(-1);

				sheetObj.SelectCell(row, "usr_id", true);
            	sheetObj.CellEditable(row, "usr_id") = true;
            	sheetObj.CellEditable(row, "usr_role_cd") = true;
            	break;
            	
            case IBSAVE:
            	var sParam = ComGetSaveString(sheetObj);
            	if (sParam == "") return;
            	
        		var dataChangeFlag = false;
            	var ttlCnt = sheetObj.RowCount;	            	

            	for(var i=1; i<=ttlCnt + 1; i++){
				   //Insert & Delete 일 경우 서비스를 호출한다.
				   if(sheetObj.CellValue(i,"ibflag") == "I" || sheetObj.CellValue(i,"ibflag") == "D"){
					   dataChangeFlag = true;
					   break;
				   }
				}
            	
            	if (!dataChangeFlag) {
            		ComShowCodeMessage("DMT01113");
            		return; //바뀐 데이터가 없을 경우 리턴한다.
            	}
				
            	if (!ComShowCodeConfirm("COM130101")) return;
            		
            	formObj.f_cmd.value = MULTI;
            	
            	var sParam = ComGetSaveString(sheetObj, false);
			    sParam += "&" + FormQueryString(formObj);
			               	
            	var sXml = sheetObj.GetSaveXml("EES_DMT_7010GS.do", sParam);
            	
            	//조회 후 결과처리
				var svcResult = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				sheetObj.LoadSaveXml(sXml);
				
				if ( svcResult == "S" ) {
					// 저장 성공시에만 재조회 실행.
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
                
            	break;
         }
     }
 	
     /**
      * 체크박스 전체해제시에 알림 및 버튼 활성화 여부
      * @param sheetObj
      * @param Row
      * @param Col
      * @param Value
      * @return
      */
  	function sheet1_OnChange (sheetObj, Row, Col, Value) {
  		var formObj 		= document.form;
		var sName 			= sheetObj.ColSaveName(Col);
  		if(sName == "usr_id") {	//checkbox

  			formObj.chk_usr_id.value = sheetObj.CellValue(Row, Col);
  			
  			var svcReturn =  doActionIBSheet(sheetObj, formObj, SEARCH22);
  			
  			if (svcReturn == 'N') {
  				sheetObj.CellValue2(Row, Col) = "";
  				sheetObj.SelectCell(Row, Col);
  			}
  			
  			formObj.chk_usr_id.value =""; //변수 초기화
  		}
  	}
    
	// Html 내 User ID가 변경시.
	function obj_change(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
	        switch(srcName) {	
	            case "usr_id":
	            	var usrId = formObj.usr_id.value;
	            	
	            	sheetObj.RemoveAll();	//Grid 내용 초기화.
	            	
	            	if (usrId =="") return;
	            	
	            	formObj.chk_usr_id.value = usrId;
	      			
	      			var svcReturn =  doActionIBSheet(sheetObj, formObj, SEARCH22);
	      			
	      			if (svcReturn == 'N') {
	      				formObj.usr_id.value = "";
	      				formObj.usr_id.focus();
	      			}
	      			
	      			formObj.chk_usr_id.value =""; //변수 초기화
	      			
	            	break;
	        }
		}catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
		}
	}
	
    function keyPress() {
        var eventKey = window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    
    document.onkeypress = keyPress ; 

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
    

    /* 개발자 작업  끝 */ 