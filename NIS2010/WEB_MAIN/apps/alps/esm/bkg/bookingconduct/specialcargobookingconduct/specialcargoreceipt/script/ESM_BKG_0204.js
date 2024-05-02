/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0204.js
*@FileTitle : Criteria for out guage calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.08 이병규
* 1.0 Creation
* 2011.12.20 변종건 [CHM-201114816-01] 위험물  입력 관련 로직 변경 추가 요청 검토(추가 요청 사항)
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
     * @class esm_bkg_0204 : esm_bkg_0204 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0204() {
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
    var opener = window.dialogArguments;

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
    			case "btn_Retrieve":
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    				break;
    					
    			case "btn_Select":    						
    				comPopupOK();     						
    				break;
    					
    			case "btn_Close":
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
		initControl();
    }
         
    function initControl() {    	  
   	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
   	    axon_event.addListenerForm('keypress','obj_keypress', form);
   	    axon_event.addListenerForm('keydown','obj_keydown', 	form);   
   		axon_event.addListenerFormat('beforedeactivate'	, 'obj_deactivate'	, form);
   	    if(document.getElementById("imdg_un_no").value != ""){
   	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   	    }
   	}  
     	
    function obj_deactivate() {
    	ComAddSeparator(event.srcElement);
	}
    
    function obj_keypress(){         	
		switch (event.srcElement.name) {		
			case "imdg_un_no":		    	
				ComKeyOnlyNumber(event.srcElement);   	
     			break;
     			
	    	case "imdg_clss_cd":		    	
	    		ComKeyOnlyNumber(event.srcElement, ".-");   	
     			break;
     	}	
    }
           
    function obj_keydown(){
    	if (event.keyCode == 13){ // Enter Key
    		switch (event.srcElement.name) {	
    			case "imdg_un_no":        					
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 	
    				break;        				
    			case "imdg_clss_cd":    					
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 	
    				break;        				
    			case "prp_shp_nm":    					
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 	
    				break;
        	}
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
                    style.height = 260;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(33, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Sel|Sel.|UN No.|UN No.|Class|Class|P.GRP|Proper Shipping Name|Technical Name|SRL1|SRL2|SRL3|SRL4" +
							"|Flash Point|PSA|Marine Pollutant|EMS No.|ERG|ERG|Limited Q’ty |Excepted Q‘ty|HCDG|Depends||||||||||Segregation Group";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					//InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"hdnStatus");
                    InitDataProperty(0, 	cnt++, 	dtRadioCheck,	40,		daCenter,		false,	"radio",					false, 		"", 	dfNone, 	0, 		true, 		true);
    				InitDataProperty(0, 	cnt++, 	dtCheckBox, 	40, 	daCenter,		false,	"check", 					false, 		"", 	dfNone, 	0, 		true, 		true);
					InitDataProperty(0,		cnt++ , dtData,			45,		daCenter,		true,	"imdg_un_no", 				false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			20,		daCenter,		true,	"imdg_un_no_seq", 			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			35,		daCenter,		true,	"imdg_clss_cd", 			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			20,		daCenter,		true,	"imdg_comp_grp_cd", 		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtCombo,		50,		daCenter,		true,	"imdg_pck_grp_cd", 			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			290,	daLeft,			true,	"prp_shp_nm", 				false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			100,	daLeft,			true,	"imdg_tec_nm", 				false,		"",		dfNone,		0,		false,		false);    					                                                                                
					InitDataProperty(0,		cnt++ , dtData,	   		40,		daCenter,		true,	"srl1", 					false,		"",		dfNone,		0,		false,		false);
					
					InitDataProperty(0,		cnt++ , dtData,			40,		daCenter,		true,	"srl2", 					false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			40,		daCenter,		true,	"srl3", 					false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			40,		daCenter,		true,	"srl4", 					false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			80,		daCenter,		true,	"flsh_pnt_temp_ctnt", 		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			50,		daCenter,		true,	"psa_no", 					false,		"",		dfNone,		0,		false,		false);    					 
					InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,	"imdg_mrn_polut_cd", 		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			60,		daCenter,		true,	"imdg_emer_no", 			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			30,		daCenter,		true,	"emer_rspn_gid_no", 		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			20,		daCenter,		true,	"emer_rspn_gid_chr_no", 	false,		"",		dfDateYmd,	0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,	"limited_qty", 				false,		"",		dfNone,		0,		false,		false);
					
					InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,	"imdg_expt_qty_cd", 		false,		"",		dfDateYmd,	0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			35,		daCenter,		true,	"hcdg_flg", 				false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,			50,		daCenter,		true,	"hcdg_dpnd_qty_flg", 		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtHidden,		40,		daCenter,		true,	"imdg_spcl_provi_no", 		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtHidden,		40,		daCenter,		true,	"imdg_crr_rstr_expt_cd",	false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtHidden,		40,		daCenter,		true,	"crr_cd", 					false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtHidden,		40,		daCenter,		true,	"hcdg_pck_rstr_desc", 		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtHidden,		40,		daCenter,		true,	"hcdg_intmd_bc_rstr_desc", 	false,		"",		dfNone,		0,		false,		false);    					
					InitDataProperty(0,		cnt++ , dtHidden,		40,		daCenter,		true,	"hcdg_tnk_rstr_desc", 		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtHidden,		40,		daCenter,		true,	"imdg_ctrl_temp", 			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtHidden,		40,		daCenter,		true,	"imdg_emer_temp", 			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtHidden,		40,		daCenter,		true,	"imdg_lmt_qty_meas_ut_cd", 	false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtHidden,		350,	daCenter,		true,	"imdg_segr_grp_nm", 		false,		"",		dfNone,		0,		false,		false);
					InitDataCombo(0, "imdg_pck_grp_cd", "I|II|III", "1|2|3");					    					
                }
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
          	case IBSEARCH:      //조회          
          		sheetObj.ColHidden("imdg_subs_rsk_lbl_rmk") = false;
          	
          		if(validateForm(sheetObj,formObj,sAction)) {
          			formObj.f_cmd.value = SEARCH;
          			sheetObj.DoSearch("ESM_BKG_0204GS.do", FormQueryString(formObj));				
								
          			for(var i=1; i <= sheetObj.RowCount; i++){						
          				if(sheetObj.CellValue(i, "crr_cd") != ""){
          					sheetObj.CellValue2(i, "imdg_crr_rstr_expt_cd") = "R";
          				}						 
          			}
				
          			/*
					var cnt = 0;
					for (var i=1; i <= sheetObj.RowCount; i++){					
						if(sheetObj.CellValue(i,"imdg_subs_rsk_lbl_rmk") == ""){
							cnt++;
						}
					}
				
					if(cnt == sheetObj.RowCount){					
						sheetObj.ColHidden("imdg_subs_rsk_lbl_rmk") = true;
					}
          			 */
          		}
          		break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
//          if (!isNumber(formObj.iPage)) {
//              return false;
//          }
        }
        return true;
	}

	/* 개발자 작업  끝 */