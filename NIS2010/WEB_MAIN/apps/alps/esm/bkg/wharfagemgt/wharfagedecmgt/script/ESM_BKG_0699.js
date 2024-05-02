﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_.0699js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.16 정재엽
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0555() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_save":
						doActionIBSheet(sheetObject,document.form,IBSAVE);
					break;
					
					case "btn_new":
						sheetObject.CellValue2(1, "sheet1_registno") = "";
						for (var i = 1; i <= sheetObject.RowCount; i++) {
							sheetObject.CellValue2(i, "sheet1_kr_whf_expt_appl_flg") = "N";
							sheetObject.CellValue2(i, "sheet1_radio") = 0;
						}
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

            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        sheetObjects[0].SelectHighLight = false; 
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        initControl();
        
        
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
    	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	
    }
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
   
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
				var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = " | | | | |사업자등록번호";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix = 'sheet1_';
    				InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,			prefix+"ibflag");
    				InitDataProperty(0, cnt++ , dtHidden,			30,		daLeft,		false,			prefix+"kr_whf_expt_cd",			false,			"",      dfNone,	0,		true,		true);
    				InitDataProperty(0, cnt++ , dtData,				100,	daLeft,		false,			prefix+"kr_whf_expt_desc",			false,			"",      dfNone,	0,		true,		true);
    				InitDataProperty(0, cnt++ , dtHidden,			30,		daLeft,		false,			prefix+"kr_whf_expt_appl_flg",		false,			"",      dfNone,	0,		true,		true);
    				InitDataProperty(0, cnt++ , dtCheckBox,			20,		daCenter,	false,			prefix+"radio",						false,			"",      dfNone,	0,		true,		true);
    				
    				InitDataProperty(0, cnt++ , dtPopupEdit,		50,		daLeft,		true,			prefix+"registno",					false,			"",      dfNone,	0,		true,		true, 20);
    				InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		false,			prefix+"bkg_no",					false,			"",      dfNone,	0,		true,		true);
    				
					CountPosition = 0;

			}
			break;
								
            case "sheet2":
            	with (sheetObj) {
            		
            		// 높이 설정
            		style.height = 220;
            		//전체 너비 설정
            		SheetWidth = mainTable.clientWidth;
            		
            		//Host정보 설정[필수][HostIp, Port, PagePath]
            		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            		
            		//전체Merge 종류 [선택, Default msNone]
            		MergeSheet = msHeaderOnly;
            		
            		//전체Edit 허용 여부 [선택, Default false]
            		Editable = true;
            		
            		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            		InitRowInfo(1, 1, 15, 100);
            		
            		var HeadTitle = " | |Container Number|Container Number|SOC|";
            		var headCount = ComCountHeadTitle(HeadTitle);
            		
            		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            		InitColumnInfo(headCount, 0, 0, true);
            		
            		// 해더에서 처리할 수 있는 각종 기능을 설정한다
            		InitHeadMode(true, true, false, true, false,false)
            		
            		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            		InitHeadRow(0, HeadTitle, true);
            		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix2 = 'sheet2_';
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,		daCenter,	false,		    prefix2+"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,			prefix2+"cntr_wfg_expt_flg",	false,			"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	true,			prefix2+"cntr_no",				false,			"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,			prefix2+"cntr_tpsz_cd",			false,			"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,			prefix2+"soc",					false,			"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,			prefix2+"bkg_no",				false,			"",      dfNone,	0,		true,		true);
					
            		CountPosition = 0;
            	}
            	break;
            
            
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

          case IBSEARCH:      //조회
              
        	  if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value = SEARCH;   
					var aryPrefix = new Array("sheet1_", "sheet2_" ); //prefix 문자열 배열
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0699GS.do", FormQueryString(formObj)  + "&" + ComGetPrefixParam(aryPrefix));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
					if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[1]);
					
					if (ComGetEtcData(arrXml[0],"shipper_name")) {
						formObj.shipper_name.value = ComGetEtcData(arrXml[0],"shipper_name");
						formObj.export_ref.value = ComGetEtcData(arrXml[0],"export_ref");
						formObj.cstms_desc.value = ComGetEtcData(arrXml[0],"cstms_desc");
						formObj.bkg_cgo_tp_cd.value = ComGetEtcData(arrXml[0],"bkg_cgo_tp_cd");
						sheetObjects[0].CellValue2(1,5) = ComGetEtcData(arrXml[0],"whf_shpr_rgst_no");
						var temp = '';
						for( var i=0; i< sheetObjects[0].RowCount; i++ ){
							sheetObjects[0].CellValue2(i+2, 5) = "     ";
							sheetObjects[0].CellValue2(i+1, 6) = formObj.bkg_no.value ;
							sheetObjects[0].CellValue2(i+1, 0) = "";
							
							temp = sheetObjects[0].CellValue( i+1, 'sheet1_kr_whf_expt_appl_flg' );
							if( 'Y' == temp ) {
								sheetObjects[0].CellValue2( i+1, 'sheet1_radio' )  = 1 ;
								sheetObjects[0].CellValue2( i+1, 'sheet1_ibflag' ) = "" ;
							}
						}
						// Exempt Shipper 면제 사유 외에는 사업자 등록 번호 칼럼을 강제 merge 하여
						// 입력 불가능하게 만듬
						sheetObjects[0].SetMergeCell(2, 5, 7, 1);  
					}
					if( ComGetEtcData(arrXml[0],"bdr") == 'Y' && ComGetEtcData(arrXml[0],"ca") == 'Y')
					{
						ComBtnDisable("btn_save");
					
					}
      		  }
              break;
          case IBSAVE:        //저장
        	  if(validateForm(sheetObj,formObj,sAction)){
	              formObj.f_cmd.value = MULTI;
	              
	              var aryPrefix = new Array("sheet1_", "sheet2_");
	    	      var sParam = "";
	    	      
	    	      if (sheetObjects[0].IsDataModified == true ) {	    	    	  
	    	    	  sParam = "sheet1_ibflag=U&sheet1_bkg_no=" + formObj.bkg_no.value;
	    	    	  var row = sheetObjects[0].FindText("sheet1_kr_whf_expt_appl_flg", "Y");
	    	    	  if ( row > 0) {
	    	    		  sParam = sParam + "&sheet1_kr_whf_expt_cd=" + sheetObjects[0].CellValue(row, "sheet1_kr_whf_expt_cd");
	    	    		  if (sheetObjects[0].CellValue(row, "sheet1_kr_whf_expt_cd") == "S") {
	    	    			  sParam = sParam + "&sheet1_registno=" + sheetObjects[0].CellValue(row, "sheet1_registno");
	    	    		  }
	    	    	  }
	    	    	  else {
	    	    		  sParam = sParam + "&sheet1_kr_whf_expt_cd=";
	    	    	  }
	    	      }
	    	      sParam += "&" + FormQueryString(formObj);
                  var sheet1 = sheetObjects[0].GetSaveString();
                  var sheet2 = sheetObjects[1].GetSaveString();
                  
                  if(sheet1 != "") {
                      sParam += "&" +  sheet1 + "&" + sheet2
                  } else {
                      sParam += "&" + sheet2
                  }
	    	      var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0699GS.do", sParam);
	    	      sheetObj.LoadSaveXml(SaveXml);
        	  }
   			  break;
          case IBINSERT:      // 입력
        	  break;
        }
	}



    /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			return true;
			break;
		case IBSAVE: // 저장
			if (sheetObjects[0].IsDataModified == false
					&& sheetObjects[1].IsDataModified == false) {
				ComShowCodeMessage('BKG00233');
				return false;
			}
			return true;
			break;
		}
	}
    
    
    function sheet1_OnChange(SheetObj, Row, Col, Value){
    	var exceptCdChanged = false;
    	if (SheetObj.ColSaveName(Col) == "sheet1_radio") {
    		exceptCdChanged = true;
    	}
        for (var i = 0 + sheetObjects[0].HeaderRows; i < sheetObjects[0].RowCount + sheetObjects[0].HeaderRows; i++){
//        	sheetObjects[0].CellValue2(i, "sheet1_ibflag") = "";
        	if (exceptCdChanged) {
        		if (Row == i)
        		{
        			if( sheetObjects[0].CellValue(i, "sheet1_kr_whf_expt_appl_flg") == "Y" )
        			{
        				sheetObjects[0].CellValue2(i, "sheet1_radio") = "0";
                		sheetObjects[0].CellValue2(i, "sheet1_kr_whf_expt_appl_flg") = "N";
        			}
        			else
        			{
        				sheetObjects[0].CellValue2(i, "sheet1_radio") = "1";
                		sheetObjects[0].CellValue2(i, "sheet1_kr_whf_expt_appl_flg") = "Y";   
                		
                		if (sheetObjects[0].CellValue(i, "sheet1_kr_whf_expt_cd") == "S") {
                    		if (sheetObjects[0].CellValue(i, "sheet1_registno") == "") {
                    			sheet1_OnPopupClick(SheetObj, i, sheetObjects[0].SaveNameCol("sheet1_registno"));
                    		}
                    	}
                    	else {
                    		sheetObjects[0].CellValue2(1, "sheet1_registno") = "";
                    	}
        			}
        			
        		}
        		else
        		{
	        		sheetObjects[0].CellValue2(i, "sheet1_radio") = "0";
	        		sheetObjects[0].CellValue2(i, "sheet1_kr_whf_expt_appl_flg") = "N";
        		}
        	}
        }
        
 //       if (exceptCdChanged) {
 //       	
 //       	sheetObjects[0].CellValue2(Row, "sheet1_radio") = "1";
 //       	sheetObjects[0].CellValue2(Row, "sheet1_kr_whf_expt_appl_flg") = "Y";
        	
 //       	if (sheetObjects[0].CellValue(Row, "sheet1_kr_whf_expt_cd") == "S") {
 //       		if (sheetObjects[0].CellValue(Row, "sheet1_registno") == "") {
 //       			sheet1_OnPopupClick(SheetObj, Row, sheetObjects[0].SaveNameCol("sheet1_registno"));
 //       		}
 //       	}
 //       	else {
 //       		sheetObjects[0].CellValue2(1, "sheet1_registno") = "";
 //       	}
 //       }
//        sheetObjects[0].CellValue2(Row, 0) = 'U';
    }
    
    function sheet1_OnPopupClick(SheetObj, Row, Col){
    	if (Row == 1 && SheetObj.ColSaveName(Col) == "sheet1_registno") {
    		ComOpenWindowCenter("ESM_BKG_0738.do?pgmNo=ESM_BKG_0738&country=KR&popup=y&frow=1&fcol="+ sheetObjects[0].SaveNameCol("sheet1_registno"), "ESM_BKG_0738", 600, 400, true);
//    		ComOpenPopup("/hanjin/ESM_BKG_0738.do?pgmNo=ESM_BKG_0738&cnt_cd=KR&mode=INQ", 600, 400, "", "0,1,1,1,1");
    	}
    }
/* 2010.02.17 버전Up 김태경 */
