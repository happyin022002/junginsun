/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0703.js
*@FileTitle : TRO-Cancel/Frustrate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.06.30 이남경
* 1.0 Creation 
===============================================================================
* History
* 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
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
     * @class esm_bkg_0703 : esm_bkg_0703 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0703() {
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

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_CancelAll":
					setCancelAll();
	                break; 
	            
				case "btn_FrustrateAll":
					setFrustrateAll();
	                break; 			
			
            	case "btn_ok":
            		doActionIBSheet(sheetObject1, formObject, IBSAVE);
                	break;

				case "btn_close":
					self.close();
					break;

            } // end switch
    	}catch(e) {
    		ComShowMessage(e);
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
        
        axon_event.addListenerFormat('keypress', 'obj_KeyPress',   form);

        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        initControl();
    }
     
    function initControl() {
    	var formObj = document.form;
    	formObj.bkg_no.focus(); 
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		switch(sheetObj.id) {
			case "sheet1":      //hidden sheet1
	            with (sheetObj) {	
	                // 높이 설정
	                style.height = 120;
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
	
	                var HeadTitle = " ||Seq.|Container No.|TP/SZ|S/O|W/O|Cancel|Cancel|Frustrate|Frustrate|Revenue|Revenue|||||||";
					var headCount = ComCountHeadTitle(HeadTitle);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false); 
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
					//InitDataProperty(0, cnt++ , dtSeq,			20,		daCenter,	false,		"no");
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0,	cnt++,	dtRadioCheck,	30 , 	daCenter,	false,	    "radio",            false,  "", dfNone,	    0,      true, true);					
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"tro_seq",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		"cntr_no",		    false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			48,		daCenter,	true,		"cntr_tpsz_cd",		false,			"",      dfNone,			0,		false,		false);
						
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"so_flg",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"wo_flg",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"cxl_flg",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,		45,		daCenter,	false,		"cxl_flg_chk",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"frustrate",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,		45,		daCenter,	false,		"frustrate_chk",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"curr_cd",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			48,		daRight,	false,		"non_trns_rev_amt", false,			"",      dfFloat,			2,		false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,		48,		daLeft,	    false,		"bkg_no",		    false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		48,		daLeft,	    false,		"io_bnd_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		48,		daLeft,	    false,		"act_cnt_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		48,		daLeft,	    false,		"act_cust_seq",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		48,		daLeft,  	false,		"cfm_upd_dt",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		48,		daLeft,	    false,		"hlg_tp_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		48,		daLeft,	    false,		"tro_sub_seq",		false,			"",      dfNone,			0,		false,		false);
			    }
				break;
		}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {    	
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

          	case IBSEARCH:      //조회	              		
	          	//if(!validateForm(sheetObj,formObj,sAction)) return;
      	
	          	formObj.f_cmd.value = SEARCH;
          	    sheetObj.DoSearch("ESM_BKG_0703GS.do", FormQueryString(formObj));
                break;
                
          	case IBSAVE: 
 	          	if(!validateForm(sheetObj, formObj, sAction)){
 	          		return false;
 	          	}
 	          	formObj.f_cmd.value = MULTI; 
	            sheetObj.DoSave("ESM_BKG_0703GS.do", FormQueryString(formObj), -1, false);
          		break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	        	
        with(formObj)
        {
        	switch (sAction) {
         	    case IBSEARCH:
 					if (bkg_no.value == "" && bl_no.value == "") {
 					    ComShowCodeMessage("BKG00255");
 					    ComSetFocus(bkg_no);
 					    return false;
 					}
         	    	break;
         	    	
         	    case IBSAVE:
 					if (sheetObj.IsDataModified == false) {
 						ComShowCodeMessage("BKG00567");
 						return false;
 					}
         	    	if (!ComShowCodeConfirm("COM12147", "")) {
         	    		return false;
         	    	}  					
         	    	break; 
            }
        }

        return true;
    }
     
     
    //#################(Event)############################
    // Sheet saveEnd
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)
    {
    	var formObj = document.form;
    	
		if (ErrMsg.trim() == msgs['BKG00166'].trim()) {			
			if (formObj.f_cmd.value == MULTI) {	
				pre_comPopupOK();
			} else {
				this.close();
			}
		}
    }
    
 	// Sheet SearchEnd
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow; i++)
 			{
 				if ("Yes" == CellValue(i, "so_flg")) {
 					CellEditable (i, "cxl_flg_chk") = false;
 				    CellFontColor(i, "so_flg") = RgbColor(255, 0, 0);
 				} else { 					
 					if ("Yes" == CellValue(i, "cxl_flg")) {
 						CellEditable (i, "cxl_flg_chk") = false;
 					} else {
 						CellEditable (i, "cxl_flg_chk") = true;
 					}
 				    CellFontColor(i, "so_flg") = RgbColor(0, 0, 0);
 				}

				if ("Yes" == CellValue(i, "wo_flg")) {
 				    CellFontColor(i, "wo_flg") = RgbColor(255, 0, 0);
					CellEditable (i, "frustrate_chk") = false;					
				} else if ("Fr" == CellValue(i, "wo_flg")) {
 				    CellFontColor(i, "wo_flg") = RgbColor(0, 0, 255);
					if("Yes" == CellValue(i, "frustrate")){
						CellEditable (i, "frustrate_chk") = false;
					} else {
						CellEditable (i, "frustrate_chk") = true;						
					}
				} else {
					CellEditable (i, "frustrate_chk") = false;
				}
 			}
 		}
 	}   
    
    // Sheet Click
    function sheet1_OnClick(sheetObj, Row, Col, Value)
    {
		with(sheetObj) {
			switch(ColSaveName(Col)){
	            case "cxl_flg_chk":
	            case "frustrate_chk":
	            	setCfmCheck(sheetObj, Row, ColSaveName(Col), Value);
	            	break;
			}
		}
    }
    
    
    //#################(Etc/Logic)############################
 	//setCancelAll
 	function setCancelAll() {
 		var sheetObj = sheetObjects[0]; 		
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow; i++)
 			{
 				if (CellEditable(i, "cxl_flg_chk")) {
 					setCfmCheck(sheetObj, i, "cxl_flg_chk", 0);
 					CellValue2(i, "cxl_flg_chk") = 1;
 				}
 			}
 		}
 	}
 	
 	//setFrustrateAll
 	function setFrustrateAll() {
 		var sheetObj = sheetObjects[0]; 		
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow; i++)
 			{
 				if (CellEditable(i, "frustrate_chk")) {
 					setCfmCheck(sheetObj, i, "frustrate_chk", 0);
 					CellValue2(i, "frustrate_chk") = 1;
 				} 
 			}
 		}
 	} 	
 	
	/**     
	  * setCfmCheck -> cfm_upd_dt set
	  */
	function setCfmCheck(sheetObj, nRow, colId, preVal) {
  	    var toDay = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm");  //checked -> Confirm Date setting		
		
		with(sheetObj) {
			if (CellEditable(nRow, colId)) {
		    	if (preVal == 1) {
		    		CellValue2(nRow, "cfm_upd_dt") = "";
		    	} else {
		    		CellValue2(nRow, "cfm_upd_dt") = toDay;
		    	}
			}
		}
	} 	
	  
	/**
	 * parent : default Recall 
	 */
    function pre_comPopupOK() {
	   	sheetObjects[0].CellValue2(1, "radio") = "Y";
   	    comPopupOK();
    } 

	/* 개발자 작업  끝 */