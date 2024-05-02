/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_085.jsp
*@FileTitle : POD Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-24
*@LastModifier : Noh Seung Bae
*@LastVersion : 1.0 
* 2009-08-24 Noh Seung Bae
* 1.0 최초 생성
* 1.1 kim kwijin수정(alps로 변경)
* 2011.07.20 변종건 [] Inland Route POD Management 기능변경 및 보완 요청
* 2011.11.02 이수진 [CHM-201113877-01] Constraint 기능상에 Update 이력 관리 기능 추가  - Creation/Update Office Code 추가
=========================================================*/
// 공통전역변수

var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

//var oldData_remarks;
//var oldData_service;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var popupArray = null;
var ImdgClass ='';
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	
    	/* 조회방식에 따른 속성변경 이벤트처리 */
//		if(window.event.srcElement.getAttribute("name") == "pctl_io"){
//			obj_change();
//		}
		
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
            /****************************
             enterKey 처리
            *****************************/
            var srcObj=window.event.srcElement.nodeName;
            var keyObj=window.event.keyCode;
          //  if(srcObj =='INPUT' && keyObj ==13) {
          //      srcName ='btn_retrieve';
          //  }
            switch(srcName) {

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
        	        break;

                case "btn_save":
					doActionIBSheet(sheetObject, formObject, IBSAVE);
                    break;

                case "btn_downexcel":
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                    break;
                    
                case "btn_uploadexcel":
					doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
                    break;

       	        case "btng_rowadd":
					sheetObject.DataInsert();					
					sheetObject.CellValue2(sheetObject.SelectRow, "cre_ofc_cd") = OFC_CD;
//					alert(sheetObject.ofc_cd);
        	        break; 
                                
                case "btng_rowcopy":
					sheetObject.DataCopy();
					sheetObject.CellValue2(sheetObject.SelectRow, "pod_code") = "";
					sheetObject.SelectCell(sheetObject.SelectRow, "pod_code");
        	        break; 

                case "p_lane_code":
                	ComOpenPopup('/hanjin/COM_ENS_081.do?lane_cd=' + formObject.lane_code.value, 770, 470, 'setPopupArray', "1,0,1,1,1,1,1,1,1,1,1,1", true);
					if(popupArray != null){
						formObject.lane_code.value = popupArray[0][3];
					}
					popupArray = null;

					break;
                case "p_pod_code":
                	ComOpenPopup('/hanjin/COM_ENS_051.do?loc_cd=' + formObject.pod_code.value, 770, 510, 'setPopupArray', "1,0,1,1,1,1,1,1,1,1,1,1", true);
					if(popupArray != null){
						formObject.pod_code.value = popupArray[0][3];
					}
					popupArray = null;
					break;
                case "p_del_code":
                	ComOpenPopup('/hanjin/COM_ENS_051.do?loc_cd=' + formObject.del_code.value, 770, 510, 'setPopupArray', "1,0,1,1,1,1,1,1,1,1,1,1", true);
					if(popupArray != null){
						formObject.del_code.value = popupArray[0][3];
					}
					popupArray = null;
					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			showErrMessage(ComGetMsg('PRD90054'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    function setPopupArray(popupArray) {
		this.popupArray = popupArray
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
//        alert("crud=========>"+ CRUD);
//        alert("ofc_cd=========>"+ OFC_CD);
    	if(CRUD == "R") {
//    		alert("crud=========>"+ CRUD);
    		ComBtnDisable("btn_save");
    		ComBtnDisable("btn_uploadexcel");
    		ComBtnDisable("btng_rowadd");
    		ComBtnDisable("btng_rowcopy");
    		

    	}
        
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'lane_code', 'pod_code', 'del_code');
		
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    style.height = 380 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(19, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle1 = "No.|Status|Del|Bound|First/Last Lane|POR/DEL|POR/DEL|POL/POD|R/D Term|Trans Mode|IMDG Class|Service|Remarks|C OFC|C ID|C Date|U OFC|U ID|U Date" ;
                    var HeadTitle2 = "No.|Status|Del|Bound|First/Last Lane|City|State|POL/POD|R/D Term|Trans Mode|IMDG Class|Service|Remarks|C OFC|C ID|C Date|U OFC|U ID|U Date" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성       [ROW,    COL, DATATYPE, WIDTH,  DATAALIGN, COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,       30,   daCenter,  true,    "",             	false,     "",       dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtStatus,    50,   daCenter,  true,    "ibflag",       	false,     "",       dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,  30,   daCenter,  true,    "del_flag",     	false,     "",       dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtComboEdit, 60,   daCenter,  true,    "pctl_io_bnd_cd", true,     "",       dfNone,      0,     false,      true);
                    InitDataProperty(0, cnt++ , dtPopupEdit, 110,  daCenter,  true,    "lane_code",   	 true,     "",       dfNone,      0,     false,      true, 3);
                    InitDataProperty(0, cnt++ , dtPopupEdit, 50,   daCenter,  true,    "del_code",    	 true,     "",       dfNone,      0,     false,      true, 5);
                    InitDataProperty(0, cnt++ , dtData,      40,   daCenter,  true,    "del_state",    	false,     "",       dfNone,      0,     false,      false, 3);
                    InitDataProperty(0, cnt++ , dtPopupEdit, 80,   daCenter,  true,    "pod_code",    	 true,     "",       dfNone,      0,     false,      true, 5);
                    InitDataProperty(0, cnt++ , dtComboEdit, 70,   daCenter,  true,    "del_term",     	false,     "",       dfNone,      0,     false,      true);
                    InitDataProperty(0, cnt++ , dtComboEdit, 70,   daCenter,  true,    "trans_mode",   	false,     "",       dfNone,      0,     false,      true);
                    
                    InitDataProperty(0, cnt++ , dtPopup, 80,   daCenter,  true,    "pctl_imdg_clss_ctnt",    	 false,     "",       dfNone,      0,     false,      true, 50);
                     
                    InitDataProperty(0, cnt++ , dtComboEdit, 50,   daCenter,  true,    "service",      	false,     "",       dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      400,  daCenter,  true,    "remarks",     	 true,     "",       dfNone,      0,     true,       true, 1000);
                    InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,    "cre_ofc_cd",   	false,     "",       dfNone,      0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,    "cre_usr_id",   	false,     "",       dfNone,      0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      65,   daCenter,  true,    "cre_dt",       	false,     "",       dfDateYmd,   0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,    "upd_ofc_cd",   	false,     "",       dfNone,      0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,    "upd_usr_id",   	false,     "",       dfNone,      0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      65,   daCenter,  true,    "upd_dt",       	false,     "",       dfDateYmd,   0,     false,      false);                    
                    
                    InitDataCombo(0, "pctl_io_bnd_cd", "I/B|O/B", "I|O");
                    InitDataCombo(0, "del_term", "ALL|CY|Door", "A|Y|D");
                    InitDataCombo(0, "trans_mode", "ALL|TD|RD|RT|WD|WT|WR", "AL|TD|RD|RT|WD|WT|WR");
                    InitDataCombo(0, "service", "Y|N", "Y|N");

					InitDataValid(0, "lane_code", vtEngUpOther, "1234567890");
					InitDataValid(0, "pod_code",  vtEngUpOther, "1234567890");
					InitDataValid(0, "del_code",  vtEngUpOther, "1234567890");
					InitDataValid(0, "del_state", vtEngUpOther, "1234567890");

                }
                break;
                
            case 2:      //IBSheet2 init
                with (sheetObj) {

                }
                break;
        }

    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var uid ;
    	var sXml ;
	    sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

           case IBSEARCH:      //조회

            	if( ComTrim(formObj.lane_code.value) == ""  || ComTrim(formObj.pod_code.value) == ""  
					|| ComTrim(formObj.del_code.value) == ""  ){
		
            	}

            	if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
				}
            	
                sheetObj.DoSearch4Post("ESD_PRD_0085GS.do", PrdFQString(formObj));
                break;

            case IBSAVE:        //저장
                if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;					
					sheetObj.DoSave("ESD_PRD_0085GS.do", PrdFQString(formObj));					
				}
                break;

           case IBINSERT:      // 입력
				if(validateForm(sheetObj,formObj,sAction))
                sheetObj.DataInsert();
                break;

           case IBCOPYROW:        //행 복사
              sheetObj.DataCopy();
              break;

           case IBDOWNEXCEL:        //엑셀 다운로드
              sheetObj.Down2Excel(-1, false, false, true);
              break;

           case IBLOADEXCEL:        //엑셀 업로드
              sheetObj.LoadExcel();
           
           	  var cnt = sheetObj.RowCount + 1;
           	  
           	  if( sheetObj.CellValue(cnt,"pctl_io_bnd_cd") == "" && sheetObj.CellValue(cnt,"lane_code") == ""  && sheetObj.CellValue(cnt,"del_code") == ""  && sheetObj.CellValue(cnt,"pod_code") == ""  && sheetObj.CellValue(cnt,"remarks") == "" )
           	  {
           		  sheetObj.RowDelete(cnt, false);
           	  }
              break;
           
           case SEARCH01:
              formObj.f_cmd.value = SEARCH01;
              uid= "ESD_PRD_0085";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              break;   
           
        }
    }
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {

                }
             break;

        }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){


        return true;
    }
        
        
    function sheet1_OnSaveEnd(sheetObj,errMsg){
    	var formObject = document.form;
    	if( errMsg == "Saved data successfully.") doActionIBSheet(sheetObj,formObject,IBSEARCH);
    }

	function sheet1_OnPopupClick(sheetObj, row, col) {
		if (sheetObj.ColSaveName(col) == "lane_code") {
			ComOpenPopup('/hanjin/COM_ENS_081.do?lane_cd=' + sheetObj.CellValue(row, col), 770, 470, 'setPopupArray', "1,0,1,1,1,1,1,1,1,1,1,1", true);
			if(this.popupArray != null){
				sheetObj.CellValue2(row, col) = popupArray[0][3];
			}
		}else if (sheetObj.ColSaveName(col) == "pod_code") {
			ComOpenPopup('/hanjin/COM_ENS_051.do?loc_cd=' + sheetObj.CellValue(row, col), 770, 510, 'setPopupArray', "1,0,1,1,1,1,1,1,1,1,1,1", true);
			if(this.popupArray != null){
				sheetObj.CellValue2(row, col) = popupArray[0][3];
			}
		}else if (sheetObj.ColSaveName(col) == "del_code") {
			ComOpenPopup('/hanjin/COM_ENS_051.do?loc_cd=' + sheetObj.CellValue(row, col), 770, 510, 'setPopupArray', "1,0,1,1,1,1,1,1,1,1,1,1", true);
			if(this.popupArray != null){
				sheetObj.CellValue2(row, col) = popupArray[0][3];
			}
		}else if (sheetObj.ColSaveName(col) == "pctl_imdg_clss_ctnt") {
			ComOpenPopup('/hanjin/ESD_PRD_0087.do'  , 300, 200, 'getImdg_Multi', "1,0,1,1,1,1,1,1,1,1,1,1",true,true, row, col);
//			if(this.popupArray != null){
//				sheetObj.CellValue2(row, col) = popupArray[0][3];
//			}
			sheetObj.CellValue2(row, col) = ImdgClass;
			ImdgClass ='';
		}
		this.popupArray = null;
	}

	function getImdg_Multi(ret_val) {
		ImdgClass = ret_val;
		
	}
    function sheet1_OnChange(sheetObj, row, col, value) {
    	var colName = sheetObj.ColSaveName(col);
        // Create Office가 아닐 경우 Old Data로 복구하고 종료한다.
    	if (!fnCreOfcCheck(sheetObj, row)) {
    		if (colName == "del_flag") {
    			ComShowMessage(ComGetMsg('PRD90130'));
    			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col)==0?1:0;
    		} else {
    			sheetObj.ReturnCellData(row,col);
    		}
    		return;
    	}
    	
    	// del_code와 pod_code 가 같으면 안됨
		var messageFlag = false;
		var sXml ;
		var param ;
//		if( sheetObj.ColSaveName(col) == "pod_code" && value != "" && value == sheetObj.CellValue(row, "del_code")) {
//				messageFlag = true;
//		}else if( sheetObj.ColSaveName(col) == "del_code" && value != "" && value == sheetObj.CellValue(row, "pod_code")) {
//				messageFlag = true;
//		}
		if(messageFlag){
			ComShowMessage(ComGetMsg('PRD90071'));
			sheetObj.SelectCell(row, col);
			sheetObj.CellValue2(row, col) = "";
			return;
		}

		messageFlag = false;
		var validationCommand = "";
        if( sheetObj.ColSaveName(col) == "lane_code") {
			if(value.length < 3){
				messageFlag = true;
			}else{
				validationCommand = SEARCH07;
			}
		}else if( sheetObj.ColSaveName(col) == "pod_code") {
			if(value.length < 5){
				messageFlag = true;
			}else{
				validationCommand = SEARCH02;
			}
        }else if( sheetObj.ColSaveName(col) == "del_code") {
			if(value.length != 2 && value.length != 5){ // 2자리도 입력 가능해야 하는 요청때문에
				messageFlag = true;
			}else if(value.length == 5){// 5자리만 존재하는 코드 validation 실행, 5자리 아니면 messageFlag = true로 인해 validation
				validationCommand = SEARCH02;
			}
        }else if( sheetObj.ColSaveName(col) == "remarks" ) {
			if(value.length < 1){
				messageFlag = true;
			}
		}

		if(messageFlag){
			ComShowMessage("Please select a type of "+sheetObj.ColSaveName(col)+".");
            sheetObj.SelectCell(row, col);
			sheetObj.CellValue2(row, col) = "";
		// if조건이 만족하면 prd_pod_mgmt 테이블에 lane_code, pod_code, del_cod 앞 2자리, del_term, trans_mode 같은 값을 찾아서
		// 같은 값이 있으면 가이드, 없으면 정상
		}else if((sheetObj.ColSaveName(col) ==  "lane_code" || sheetObj.ColSaveName(col) == "pod_code"
					|| sheetObj.ColSaveName(col) == "del_code" || sheetObj.ColSaveName(col) == "del_term" || sheetObj.ColSaveName(col) == "trans_mode")
				&& sheetObj.CellValue(row, "lane_code").length + sheetObj.CellValue(row, "pod_code").length + sheetObj.CellValue(row, "del_code").length >= 10
				){
				param = "&lane_code="+ sheetObj.CellValue(row, "lane_code")
							+ "&pod_code=" + sheetObj.CellValue(row, "pod_code")
							+ "&del_code=" + sheetObj.CellValue(row, "del_code")
							+ "&del_term=" + sheetObj.CellValue(row, "del_term")
							+ "&trans_mode=" + sheetObj.CellValue(row, "trans_mode")
							+ "&pctl_io_bnd_cd=" + sheetObj.CellValue(row, "pctl_io_bnd_cd")
							;
				
				document.form.f_cmd.value = SEARCH12;
				sXml = sheetObj.GetSaveXml("ESD_PRD_0085GS.do","uid=ESD_PRD_0085"+param+"&"+PrdFQString(document.form));
				sheetObj.LoadSearchXml(sXml,true, -1, true);
				if(parseInt(sheetObj.EtcData("counter")) == 1){
					ComShowMessage(ComGetMsg('PRD90072'));
					sheetObj.CellValue2(row, col) = "";
					sheetObj.SelectCell(row, col);
					if(sheetObj.ColSaveName(col) == "del_term"){
						sheetObj.CellValue2(row, col) = "A";
					}else if(sheetObj.ColSaveName(col) == "trans_mode"){
						sheetObj.CellValue2(row, col) = "AL"
					}
				}else if(parseInt(sheetObj.EtcData("counter")) == 2){
					ComShowMessage(ComGetMsg('PRD90073'));
					sheetObj.CellValue2(row, col) = "";
					sheetObj.SelectCell(row, col);
				}
		// 해당 컬럼에 맞는 값이 존재하는 validation
		}else if(validationCommand != ""){
			
			document.form.f_cmd.value = validationCommand;
			sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","check_data="+value+"&"+PrdFQString(document.form));
			sheetObj.LoadSearchXml(sXml,true, -1, true);
			if(sheetObj.EtcData("rowCount") == '' || parseInt(sheetObj.EtcData("rowCount")) < 1){
				sheetObj.CellValue2(row, col) = "";
				sheetObj.SelectCell(row, col);
				validationCommand = "";
			}
			//sheetObj.CellValue2(row, col) = parseInt(sheetObj.EtcData("rowCount")) > 0 ? sheetObj.CellValue(row, col) : "";
		}

		// del_code가 5자리 입력되면 del_state 값 찾아서 자동입력, 5자리가 안되면 입력안됨
		if(sheetObj.ColSaveName(col) == "del_code" && value.length == 5){
				document.form.f_cmd.value = SEARCH11;
				sXml = sheetObj.GetSaveXml("ESD_PRD_0085GS.do","uid=ESD_PRD_0085"+"&del_code="+value+"&"+PrdFQString(document.form));
				sheetObj.LoadSearchXml(sXml,true, -1, true);
				sheetObj.CellValue2(row, "del_state") = sheetObj.EtcData("location_state");
		}
		
		// Creaion Office와 Update Office가 서로 틀리면 Updaate 할 수 없도록 한다.단 Office가 같더라도 "R"권한이면 Update 할 수 없도록한다.
		
		if(sheetObj.ColSaveName(col) == "del_flag"){			
			if (sheetObj.CellValue(row, "ibflag")!="I") {			
				if (CRUD == "R"){
					ComShowMessage(ComGetMsg('PRD90130'));
					if(sheetObj.CellValue(row, "del_flag") == 0){
						sheetObj.cellValue2(row, col) = 1;
					}else{
						sheetObj.cellValue2(row, col) = 0;
					}
					return;
				}else if(CRUD =="C"){
					if(OFC_CD != (sheetObj.CellValue(row, "cre_ofc_cd"))){
						ComShowMessage(ComGetMsg('PRD90130'));						
						if(sheetObj.CellValue(row, "del_flag") == 0){
							sheetObj.cellValue2(row, col) = 1;
						}else{
							sheetObj.cellValue2(row, col) = 0;
						}
						return;					
					}
				}					
			}else{
				var dd = ComShowConfirm(ComGetMsg('COM12165'));
				if(dd==true){				
					var msg_result = sheetObj.RowDelete(row, false);
				}else{
					if(sheetObj.CellValue(row, "del_flag") == 0){
						sheetObj.cellValue2(row, col) = 1;
					}else{
						sheetObj.cellValue2(row, col) = 0;
					}
				}
			}
		} // END del_check
			
	} // END sheet1_OnChange

    function sheet1_OnDblClick(sheetObj, row, col, value) {
		return;
    }

	function sheet1_OnMouseMove(Button, Shift, X, Y){
      //풍선도움말 만들기
      if (sheetObjects[0].MouseRow > 0 && sheetObjects[0].MouseCol == 14 ){
          sheetObjects[0].MouseToolTipText = sheetObjects[0].CellText(sheetObjects[0].MouseRow, sheetObjects[0].MouseCol);
	  } else{
          //MouseToolTipText = "";
	  }
	} 
	
	function sheet1_OnBeforeEdit(sheetObj, Row, Col, value){	
		if (sheetObj.CellValue(Row, "ibflag")=="I") { return; }

		var colName = sheetObj.ColSaveName(Col);
	    switch(colName) {
        case "remarks":
        	if(!fnCreOfcCheck(sheetObj, Row)) { ComShowMessage(ComGetMsg('PRD90130')) };
        	break;
        case "service":
        	if(!fnCreOfcCheck(sheetObj, Row)) { ComShowMessage(ComGetMsg('PRD90130')) };
        	break;
	    }
	    
	} // END sheet1_OnBeforeEdit
	
	/**
	 * 화면 데이터를 수정하기 전에 발생하는 이벤트를 처리<br>
	 * <br>
	 * <b>Example : </b>
	 *
	 * <pre>
	 * </pre>
	 *
	 * @param {object}
	 *            sheetObj 필수, IBSheet개체
	 * @param {int}
	 *            Row 필수, Row값
	 * @param {int}
	 *            Col 필수, Col값
	 * @param {String}
	 *            Val 필수, Sheet Row,Col의 값
	 * @return {void}
	 * @author Park Mangeon
	 * @version 2009.10.01
	 */	
	function fnCreOfcCheck(sheetObj, row) {
		if (CRUD == "S") {
			return true;
		} else if (CRUD =="C" && OFC_CD == sheetObj.CellValue(row, "cre_ofc_cd")) {
			return true;
		}
		return false;
	}
	
	 	
//	function obj_change() {
////		var formObject = document.form;
//		var srcName = window.event.srcElement.getAttribute("name");
////		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
//		var srcValue = window.event.srcElement.getAttribute("value");
//		var sheetObj = sheetObjects[0];
//
//		if(srcName == "pctl_io") {
//			if(srcValue == "I")
//			{
//				lane.innerHTML = "Last Lane";
//				del.innerHTML = "DEL";
//				pod.innerHTML = "POD";
//								
//				sheetObj.CellValue2(0, "lane_code") = "Last Lane";
//				sheetObj.CellValue2(0, "del_code") = "DEL";
//				sheetObj.CellValue2(0, "del_state") = "DEL";
//				sheetObj.CellValue2(0, "pod_code") = "POD";
//				sheetObj.CellValue2(0, "del_term") = "D Term";
//				sheetObj.CellValue2(1, "lane_code") = "Last Lane";
//				sheetObj.CellValue2(1, "pod_code") = "POD";
//				sheetObj.CellValue2(1, "del_term") = "D Term";
//			} else {
//				lane.innerHTML = "First Lane";
//				del.innerHTML = "POR";
//				pod.innerHTML = "POL";
//				
//				sheetObj.CellValue2(0, "lane_code") = "First Lane";
//				sheetObj.CellValue2(0, "del_code") = "POR";
//				sheetObj.CellValue2(0, "del_state") = "POR";
//				sheetObj.CellValue2(0, "pod_code") = "POL";
//				sheetObj.CellValue2(0, "del_term") = "R Term";
//				sheetObj.CellValue2(1, "lane_code") = "First Lane";
//				sheetObj.CellValue2(1, "pod_code") = "POL";
//				sheetObj.CellValue2(1, "del_term") = "R Term";
//			}	
//			sheetObj.RemoveAll();
//		}
//	}

 