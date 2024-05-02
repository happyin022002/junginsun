/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0127.js
*@FileTitle : ESM_BKG_0127
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.18 경종윤
* 1.0 Creation
* -------------------------------------------------------
* HISTORY
* 2011.08.25 김봉균 [CHM-201113001-01] Brazil : Manifest Transmit 화면에 DUV와 Manifest ID 조회 옵션 추가 요청 드립니다.
* 2011.10.25 김봉균 [CHM-201114068-01] Brazil Manifest 화면 그리드 CNPJ No. 칼럼 값을 기존 data download DB가 아닌 BKG M&D > Import Information에서 끌고 오도록 로직 변경 요청드립니다.
* 2012.09.11 변종건 [CHM-201217819-01] Brazil Customs에 대한 Multi NCM Code 전송 Test를 위한 Flat File 생성 요청
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
     * @class ESM_BKG_0127 : ESM_BKG_0127 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0127() {
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
    
    //전역변수
    var intervalId = "";

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

					case "btn_retrieve":
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;
					
					case "btn_save": // update
						doActionIBSheet(sheetObject,formObject,MODIFY01);
						break;

					case "btn_datadl": // insert
						doActionIBSheet(sheetObject,formObject,MODIFY);
						break;						
					
					case "btn_transmit":
						doActionIBSheet(sheetObject, formObject, IBSAVE);
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

 		//화면에서 필요한 이벤트
     	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
     	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');  
    	
    	axon_event.addListenerForm("click", "obj_click", document.form);
		
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
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false)

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle = "|hidden_bl_no|Seq|Sel.|OB|IB|B/L No|hidden_key_bl_no|BKG No.|DEL CD|I/F|DUV|Manifest\nID" +
                    "|Shipper|Shipper CNPJ&CPF In\nBKG>Import info.|Shipper  CNPJ&CPF In\nBr Manifest|Consignee|Consignee CNPJ&CPF In\nBKG>Import info.|Consignee CNPJ&CPF In\nBr Manifest|Notify|Notify CNPJ&CPF In\nBKG>Import info.|Notify CNPJ&CPF In\nBr Manifest" +
            		"|hidden ob DDE/SD|DDE/SD|Hide|Container|Package|Package|WPM|Weight|Weight|Measure|Measure|NCM Code|NCM Code|NCM Multi Flag|NCM Multi Code" +
            		"|Description for Customs|Booking Commodity|hidden|hidden|hidden|hidden|search_bkg_cgo_tp_cd|OFT|OTH|diff_shpr_tax_no_flag|diff_cnee_tax_no_flag|diff_ntfy_tax_no_flag|CUST_TO_ORD_FLG";
//                    var HeadTitle = "|hidden_bl_no|Seq|Sel.|B/L No|hidden_key_bl_no|BKG No.|DEL CD|I/F|Shipper|Consignee|CNPJ/CPF" +
//            		"|DDE/SD|Hide|Container|Package|Package|Weight|Weight|Measure|Measure|NCM Code" +
//            		"|Description for Customs|Booking Commodity|hidden|hidden|hidden|hidden|search_bkg_cgo_tp_cd|OFT|CAP";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [	ROW,COL,  	DATATYPE,   	WIDTH, 	DATAALIGN, 		COLMERGE, 		SAVENAME,  				KEYFIELD, 		CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,			"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,			true,			"merge_bl_no",			false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			0,    	daCenterTop,   	true,   		"bl_group");
					InitDataProperty(0, cnt++ , dtDummyCheck, 	40,   	daCenterTop,	true,			"check",				false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	    20,		daLeft,			false,			"ob_ts_yn",		false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	    20,		daLeft,			false,			"ib_ts_yn",		false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeftTop,		true,			"bl_no",				false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daLeftTop,		true,			"key_bl_no",			false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeftTop,		true,			"bkg_no",				false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,	    daLeftTop,		true,			"del_cd",				false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenterTop,	true,			"if_flag",	    		false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenterTop,	true,			"br_duv",	    		false,			"",      	dfNone,		0,			true,		true,		10);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenterTop,	true,			"br_mid",	    		false,			"",      	dfNone,		0,			true,		true,		13);
					InitDataProperty(0, cnt++ , dtData,			160,	daLeftTop,		true,			"shipper_cust_nm",		false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,     	140,  	daCenterTop,	true,			"ob_shpr_tax_no",		false,			"",      	dfNone,		0,			false,		true, 		14);
					InitDataProperty(0, cnt++ , dtData,     	140,  	daCenterTop,	true,			"shpr_tax_no",			false,			"",      	dfNone,		0,			true,		true, 		14);
					
					InitDataProperty(0, cnt++ , dtData,			160,	daLeftTop,		true,			"consignee_cust_nm",	false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,     	140,  	daCenterTop,	true,			"ob_cnee_tax_no",		false,			"",      	dfNone,		0,			false,		true, 		14);
					InitDataProperty(0, cnt++ , dtData,     	140,  	daCenterTop,	true,			"cnee_tax_no",			false,			"",      	dfNone,		0,			true,		true, 		14);

					InitDataProperty(0, cnt++ , dtData,			160,	daLeftTop,		true,			"notify_cust_nm",	    false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,     	140,  	daCenterTop,	true,			"ob_ntfy_tax_no",		false,			"",      	dfNone,		0,			false,		true, 		14);
					InitDataProperty(0, cnt++ , dtData,     	140,  	daCenterTop,	true,			"ntfy_tax_no",			false,			"",      	dfNone,		0,			true,		true, 		14);
					
					InitDataProperty(0, cnt++ , dtHidden,		80,	  	daCenterTop,	true,			"ob_brz_decl_no",			false,			"",      	dfNone,		0,			true,		true, 		11);
					InitDataProperty(0, cnt++ , dtData,			80,	  	daCenterTop,	true,			"brz_decl_no",			false,			"",      	dfNone,		0,			true,		true, 		11);
					InitDataProperty(0, cnt++ , dtCheckBox, 	50,		daCenter,		false,			"hide_check",			false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,			false,			"cntr_no",				false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,     	60,   	daRight,		false,			"pck_qty",				false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,	  	daCenter,		false,			"pck_tp_cd",			false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		false,			"wpm",					false,			"",      	dfNone,		0,			false,		false);					
					InitDataProperty(0, cnt++ , dtData,			90,		daRight,		false,			"weight",				false,			"",      	dfFloat,	3,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,	  	daCenter,		false,			"wgt_ut_cd",			false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,		daRight,		false,			"measure",				false,			"",      	dfFloat,	3,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,	  	daCenter,		false,			"meas_ut_cd",			false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daLeft,			false,			"ncm_no",				false,			"",      	dfNone,		0,			true,		true,		4);
					InitDataProperty(0, cnt++, 	dtImage,     	20,    	daCenter,  		true,    		"ncm_multi_pop",        false,          "",       	dfNone,    	0,     		false,      false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,			false,			"ncm_multi_flg",		false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,			false,			"ncm_multi_no",			false,			"",      	dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,			160,	daLeft,			false,			"cstms_desc",			false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			200,	daLeft,			false,			"booking_cmdt_nm",		false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		20,		daLeft,			false,			"cntr_mf_seq",			false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		20,		daLeft,			false,			"vvd_cd",				false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		20,		daLeft,			false,			"pol_cd",				false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		20,		daLeft,			false,			"pod_cd",				false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		20,		daLeft,			false,			"search_bkg_cgo_tp_cd",	false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		false,			"oft",					false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		false,			"cap",					false,			"",      	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		20,		daLeft,			false,			"diff_shpr_tax_no_flag",		false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		20,		daLeft,			false,			"diff_cnee_tax_no_flag",		false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		20,		daLeft,			false,			"diff_ntfy_tax_no_flag",		false,			"",      	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,		    50,		daLeft,			false,			"cust_to_ord_flg",		false,			"",      	dfNone,		0,			true,		true);
					
					ShowButtonImage = 1;
					CountPosition = 0;
					InitDataValid(0, "ncm_no",  vtNumericOnly);
					
					ImageList(0) = "/hanjin/img/button/btns_multisearch.gif";
 					ImageList(1) = "/hanjin/img/button/btns_multisearch.gif";
					DataLinkMouse("ncm_multi_pop") = true;
					
					// 틀고정 설정 (cntr_no)
					FrozenCols = 8;

					WaitImageVisible=false;
										
				}
                break;
                 
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,Row,Col) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

			case IBSEARCH:      //조회
				
				if(!validateForm(sheetObj,formObj,sAction,Row,Col))return;
		    	
				var polCntCd = formObj.pol_cd.value.substring(0, 2);
				var podCntCd = formObj.pod_cd.value.substring(0, 2);
				// IO TYPE 설정
				ioTypeCheck(formObj,polCntCd, podCntCd);
				
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0127GS.do" , FormQueryString(formObj) );
				
				if (ComBkgErrMessage(sheetObj, sXml)) {
					sheetObj.LoadSearchXml(sXml);
				}
				ComOpenWait(false);

				// IO TYPE 설정(조회 후 한번더 설정함)
				//ioTypeCheck(formObj,polCntCd, podCntCd);
				
				// 조회시 io_type값을 셋팅한다.
				if(formObj.io_type[0].checked) {
					formObj.search_io_type.value = "O";
				} else {
					formObj.search_io_type.value = "I";
				}
				
 				break;
 				
			case SEARCH02: // 그리드에서 NCM Code 직접입력시 조회
				
				if(!validateForm(sheetObj,formObj,sAction,Row,Col))return;
				
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0127GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				
	    		var brz_cmdt_cd = ComGetEtcData(sXml, "brz_cmdt_cd");
	    		var cstms_desc = ComGetEtcData(sXml, "cmdt_desc");

//	    		alert("111111cstms_desc : [" +  cstms_desc + "]");
	    		if( cstms_desc == "" ){
	    			sheetObj.CellValue2(Row, "cstms_desc") 		= cstms_desc;
	    			sheetObj.CellBackColor(Row,"ncm_no") 		= sheetObj.RgbColor(255, 255, 255);
	    			sheetObj.SelectCell(Row, "ncm_no"); // 셀 포커스 주기
	    		} else {
	    		
		    		sheetObj.CellValue2(Row, "ncm_multi_pop") 		= "1";
		    		sheetObj.CellBackColor(Row,"ncm_no") 			= sheetObj.RgbColor(255, 255, 255);
		    		sheetObj.CellValue2(Row,"cstms_desc") 		= cstms_desc;
	    		
	    		}
	    		
	    		setNcmMulti(Row, sheetObj.CellValue(Row, "ncm_no"));
				break;
			
			case MODIFY:      // Data DownLoad (BOOKING OB 데이타를 세로쪽으로 INSERT한다.
				
				var retValidateForm = validateForm(sheetObj,formObj,sAction);
				
				if(!retValidateForm) return false;
				
				for(var i=1; i<=sheetObj.RowCount; i++) {
					
					if(sheetObj.CellValue(i, "check") == 1) {
						if(sheetObj.CellValue(i, "if_flag") == "N") {
							//sheetObj.CellValue2(i,"ibflag") = "I";
							sheetObj.RowStatus(i) = "I";
						} else {
							//sheetObj.CellValue2(i,"ibflag") = "U";
							sheetObj.RowStatus(i) = "U";
						}
					} else {
						//sheetObj.CellValue2(i,"ibflag") = "";
						sheetObj.RowStatus(i) = "";
					}
				}

				formObj.f_cmd.value = MODIFY;
				var sParam = ComGetSaveString(sheetObj);
                if (sParam == "") {
                	ComShowCodeMessage('BKG00743');
                	return;
                }
                sParam += "&" +  FormQueryString(formObj);	
                
                var confirmFlag = false;
                
                if(retValidateForm != "yes") {
                	//confirmFlag = ComShowConfirm("선택한 B/L을 다운로드 하시겠습니까?");
                	confirmFlag = ComShowCodeConfirm("BKG01087");
                } else {
                	confirmFlag = true;
                }
                
                if(confirmFlag) {
                	
                	ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0127GS.do", sParam);
					
			        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			        xmlDoc.async="false";
			        xmlDoc.loadXML(sXml);

			        ComOpenWait(false);
			        
			        var dataNode = xmlDoc.documentElement.getElementsByTagName("TR-ALL").item(0);

			        if(dataNode != null) {
				        if(dataNode.text == "OK") {
				        	ComShowCodeMessage('BKG01088');
				        } else {
				        	ComShowCodeMessage('BKG01089');
				        }
				        
				        ComOpenWait(true);
		 				formObj.f_cmd.value = SEARCH;
		 				sheetObj.DoSearch("ESM_BKG_0127GS.do", FormQueryString(formObj));
		 				ComOpenWait(false);
			        } else {
			        	ComShowCodeMessage('BKG01089');
			        }
					
                }
				
				break;

			case MODIFY01:    // SAVE (BOOKING OB 데이타를 세로쪽으로 UPDATE한다.
				if(!validateForm(sheetObj,formObj,sAction)) return false;

				//sheetObj.checkAll2("check") = 0;
				
				formObj.f_cmd.value = MODIFY01;
				var sParam = sheetObjects[0].GetSaveString();
				
				if (sParam == "") {
					ComShowCodeMessage('BKG00260');
					return;
				}

				sParam += "&" + FormQueryString(formObj);
				
				if(!ComShowConfirm(ComGetMsg("BKG00254"))) {
	            	return false;
	            }	
				
				ComOpenWait(true);
				var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0127GS.do", sParam);
				sheetObjects[0].LoadSaveXml(sXml);
 				formObj.f_cmd.value = SEARCH;
 				sheetObj.DoSearch("ESM_BKG_0127GS.do", FormQueryString(formObj)); 
 				ComOpenWait(false);
 				
				break;
				
			case IBSAVE:	// EDI FLAT FILE 생성 및 전송
				
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
				if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
	            	return false;
	            }
				
				for(var i=1; i<=sheetObj.RowCount; i++) {
					
					if(sheetObj.CellValue(i, "check") == 1) {
						//sheetObj.CellValue2(i,"ibflag") = "I";
						sheetObj.RowStatus(i) = "I";
					} else {
						//sheetObj.CellValue2(i,"ibflag") = "";
						sheetObj.RowStatus(i) = "";
					}
					
				}

				formObj.f_cmd.value = MULTI;
				
				var sParam = "";
				
				var sParamSheet = sheetObj.GetSaveString();

				if (sParamSheet != "") {
					sParam += "&" + sParamSheet;
				}
				
				sParam += "&" + FormQueryString(formObj);
				
				ComOpenWait(true,true);
 				var sXml = sheetObj.GetSaveXml("ESM_BKG_0127GS.do", sParam)
				var key = ComGetEtcData(sXml, "KEY");
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);

 				formObj.f_cmd.value = SEARCH;
 				sheetObj.DoSearch("ESM_BKG_0127GS.do", FormQueryString(formObj)); 
				
				break;

        }
        
        
    }

    /**
     * 화면 IO TYPE을 체크한다.
     * @param formObj
     * @param polCntCd
     * @param podCntCd
     * @return
     */
    function ioTypeCheck(formObj, polCntCd, podCntCd) {
		if(polCntCd == "BR" && podCntCd == "BR") {
			formObj.io_type[0].checked = true;
			sheetObjects[0].ColHidden("brz_decl_no") = false;
		} else if(polCntCd == "BR" && podCntCd != "BR") {
			formObj.io_type[0].checked = true;
			sheetObjects[0].ColHidden("brz_decl_no") = false;
		} else if(polCntCd != "BR" && podCntCd == "BR") {
			formObj.io_type[1].checked = true;
			sheetObjects[0].ColHidden("brz_decl_no") = true;
		}
		
		changeSheetTitle();
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction, Row, Col){
    	
    	var sheet1RowCnt = sheetObj.RowCount;
    	
	    switch(sAction) {
			case IBSEARCH: { // 조회
			    
				//기본포멧체크
				if (!ComChkValid(formObj)) return false;
				
				// 라디오버튼 클릭시 체크
				//if(!ioCheck(formObj)) return false;
				
				var vvdCd = formObj.vvd_cd.value;
				var blNo = formObj.bl_no.value;
				if(vvdCd == "" && blNo == "") {
					//ComShowMessage("VVD또는 B/L No 중 반드시 1개 이상 입력해야합니다.");
					ComShowCodeMessage("BKG01090", "VVD", "B/L No");
					ComSetFocus(formObj.vvd_cd);
					return false;
				}				
				
				if(vvdCd != "" && blNo == "") {
					var polVal = formObj.pol_cd.value;
					var podVal = formObj.pod_cd.value;
					
					if(polVal == "" && podVal == "") {
						//ComShowMessage("POL또는 POD 중 반드시 1개 이상 입력해야합니다.");
						ComShowCodeMessage("BKG01090", "POL", "POD");
						ComSetFocus(formObj.pol_cd);
						return false;
					}
				}

				/*
				var pol = polVal.substr(0,2);
				var pod = podVal.substr(0,2);
				if(pol == 'BR' && pod == 'BR') {
					//ComShowMessage("POL, POD 둘다 브라질 입니다.");
					ComShowCodeMessage("BKG01091");
					ComSetFocus(formObj.pod_cd);
					return false;
				}
				*/
				
				
				
				
				
				break;
			}
			
			case SEARCH02 : {
				
				var cmdtCd = formObj.brz_cmdt_cd.value;
				
				break;
			}
		
			case MODIFY : { // data download
				var iFFlagCnt = 0;
				var checkCnt = 0;
				var excludeTargetRow = 0;
				
				if(sheet1RowCnt == 0) {
	        		//ComShowMessage("데이타가 없습니다.");
	        		ComShowCodeMessage('BKG00889');
	        		return false;
				}
				
		        for(var i=1; i <= sheet1RowCnt; i++) {
		        	if(sheetObj.CellValue(i, "check") == 1) {
		        		checkCnt++;

		        		if(sheetObj.CellValue(i, "if_flag") == "Y") {
			        		iFFlagCnt++;
			        	}
		        		
		        		if(excludeTargetRow == 0 && sheetObj.CellValue(i, "cntr_no") == "") {
		        			excludeTargetRow = i;
		        		}
		        	}

		        	
		        }
		        

		        if(checkCnt == 0) {
		        	//ComShowMessage("DownLoad 대상 row를 먼저 체크해 주세요");
		        	ComShowCodeMessage('BKG01097');
		        	return false;
		        }

		        if(excludeTargetRow > 0) {
        			ComShowCodeMessage("BKG00443");
        			sheetObj.SelectCell(excludeTargetRow, "cntr_no");
        			return false;
		        }

		        if(iFFlagCnt > 0) {
		        	//if(ComShowConfirm("체크한 데이타 중 이미 다운로드한 B/L이 있습니다. 계속하시겠습니까?")) {
		        	if(ComShowCodeConfirm("BKG01094")) {
		        		return "yes";
		        	} else {
		        		return false;
		        	}
		        }		   
				
				break;
			}

			case MODIFY01 : { // save
				
				if(sheet1RowCnt == 0) {
	        		//ComShowMessage(" 데이타가 없습니다.");
	        		ComShowCodeMessage('BKG00889');
	        		
	        		return false;
				}

				var cnt = 0;
				
		        for(var i=1; i <= sheet1RowCnt; i++) {
		        	if(sheetObj.CellValue(i, "if_flag") == "Y") {
		        		cnt++;
		        	}
		        	
		        }
		        
		        if(cnt == 0) {
		        	//ComShowMessage("I/F 값이 Y인 데이타가 없습니다.");
		        	ComShowCodeMessage('BKG01095');
		        	return false;
		        }
		        
		        for( var idx = 0+parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow; idx++ ){
		        	if( sheetObj.CellValue(idx, "cntr_mf_seq") == "" ){
		        		return false;
		        	}
		        }
				
				break;
			}
			
			case IBSAVE : { // Transmit Validation
				var ioType = "";
				var searchIoType = formObj.search_io_type.value;
				
				
				if(sheet1RowCnt == 0) {
	        		//ComShowMessage("전송할 데이타가 없습니다.");
	        		ComShowCodeMessage("BKG01096");
	        		return false;
				}

				if(formObj.io_type[0].checked) {
					ioType = "O";
				} else {
					ioType = "I";
				}
				
				/*
				 * 조회시 condition변경 check - vvd
				 */
				if(formObj.vvd_cd.value != sheetObj.CellValue(1, "vvd_cd") && formObj.bl_no.value == "") {
					ComShowCodeMessage("BKG06118", sheetObj.CellValue(1, "vvd_cd"), formObj.vvd_cd.value);
					ComSetFocus(formObj.vvd_cd);
					return false;
				}
				/*
				 * 조회시 condition변경 check - pol
				 */
				if(formObj.pol_cd.value != sheetObj.CellValue(1, "pol_cd") && formObj.bl_no.value == "") {
					ComShowCodeMessage("BKG06118", sheetObj.CellValue(1, "pol_cd"), formObj.pol_cd.value);
					ComSetFocus(formObj.pol_cd);
					return false;
				}
				/*
				 * 조회시 condition변경 check - pod
				 */
				if(formObj.pod_cd.value != sheetObj.CellValue(1, "pod_cd") && formObj.bl_no.value == "") {
					ComShowCodeMessage("BKG06118", sheetObj.CellValue(1, "pod_cd"), formObj.pod_cd.value);
					ComSetFocus(formObj.pod_cd);
					return false;
				}
				/*
				 * 조회시 condition변경 check - io_type
				 */
				if(searchIoType != ioType) {
					ComShowCodeMessage("BKG06118", searchIoType + "/B", ioType + "/B");
					ComSetFocus(formObj.io_type);
					return false;
				}

				var polCd = formObj.pol_cd.value;
				var podCd = formObj.pod_cd.value;
				var polCountry = polCd.substr(0,2);
				var podCountry = podCd.substr(0,2);		
				
				var ifFlagYCnt = 0;
				var ifFlagNCnt = 0;
				var checkCnt = 0;
				var updateCnt = 0;
				var excludeTargetRow = 0;
				
		        for(var i=1; i <= sheet1RowCnt; i++) {
		        	
		        	if(sheetObj.CellValue(i, "check") == "1") {
		        		checkCnt++;
			        	if(sheetObj.CellValue(i, "if_flag") == "Y") {
			        		ifFlagYCnt++;
			        	}
			        	
		        		if(excludeTargetRow == 0 && sheetObj.CellValue(i, "if_flag") == "N") {
		        			excludeTargetRow = i;
		        		}
		        	}
		        }
		        
		        if(checkCnt == 0) {
		        	//ComShowMessage("전송할 row를 먼저 체크해 주세요");
		        	ComShowCodeMessage('BKG01097');
		        	return false;
		        }

		        if(ifFlagYCnt == 0) {
		        	//ComShowMessage("I/F 값이 Y인 데이타가 없습니다.");
		        	ComShowCodeMessage("BKG01095");
		        	return false;
		        }

		        if(excludeTargetRow > 0) {
        			//ComShowMessage("You can't transmit without download!");
        			ComShowCodeMessage("BKG01095");
        			sheetObj.SelectCell(excludeTargetRow, "if_flag");
        			return false;
		        }
		        
	        	/*
	        	 * 20100511 경종윤
	        	 * O/B 이고 POL country가  "BR"이 아닌경우
	             *  I/B 이고 POD country가  "BR"이 아닌경우
	             *  CNPJ/CPF, DDE/SD, NCM 입력 validation 을 하지 않음
				 */
				var validationFlag = true;
	        	if( (searchIoType == "O" && polCountry != "BR") || (searchIoType == "I" && podCountry != "BR") ) {
	        		validationFlag = false;
	        	}
		        
	        	var shprBrzNotNvlArr = new Array(); //CNPJ No 항목이, O/B 데이터(BKG_XPT_IMP_LIC)가  null 이고 세관(BKG_CSTMS_BRZ_BL ) null 이 아닐 경우
	        	var shprObBrzNotNvlArr = new Array(); //CNPJ No 항목이, O/B 데이터(BKG_XPT_IMP_LIC) 와 세관(BKG_CSTMS_BRZ_BL ) 둘 다 null 이 아닐 경우
	        	var shprObBrzNvlArr = new Array(); //CNPJ No 항목이, O/B 데이터(BKG_XPT_IMP_LIC) 와 세관(BKG_CSTMS_BRZ_BL ) 둘 다 null 일 경우
	        	var shprBrzNvlArr = new Array(); //CNPJ No 항목이, 세관(BKG_CSTMS_BRZ_BL ) 만 null 일 경우
	        	
	        	var cneeBrzNotNvlArr = new Array(); //CNPJ No 항목이, I/B 데이터(BKG_XPT_IMP_LIC)가  null 이고 세관(BKG_CSTMS_BRZ_BL ) null 이 아닐 경우
	        	var cneeObBrzNotNvlArr = new Array(); //CNPJ No 항목이, I/B 데이터(BKG_XPT_IMP_LIC) 와 세관(BKG_CSTMS_BRZ_BL ) 둘 다 null 이 아닐 경우
	        	var cneeObBrzNvlArr = new Array(); //CNPJ No 항목이, I/B 데이터(BKG_XPT_IMP_LIC) 와 세관(BKG_CSTMS_BRZ_BL ) 둘 다 null 일 경우
	        	var cneeBrzNvlArr = new Array(); //CNPJ No 항목이, 세관(BKG_CSTMS_BRZ_BL ) 만 null 일 경우

	        	var ntfyBrzNotNvlArr = new Array(); //CNPJ No 항목이, I/B 데이터(BKG_XPT_IMP_LIC)가  null 이고 세관(BKG_CSTMS_BRZ_BL ) null 이 아닐 경우
	        	var ntfyObBrzNotNvlArr = new Array(); //CNPJ No 항목이, I/B 데이터(BKG_XPT_IMP_LIC) 와 세관(BKG_CSTMS_BRZ_BL ) 둘 다 null 이 아닐 경우
	        	var ntfyObBrzNvlArr = new Array(); //CNPJ No 항목이, I/B 데이터(BKG_XPT_IMP_LIC) 와 세관(BKG_CSTMS_BRZ_BL ) 둘 다 null 일 경우
	        	var ntfyBrzNvlArr = new Array(); //CNPJ No 항목이, 세관(BKG_CSTMS_BRZ_BL ) 만 null 일 경우

	        	var targetColGubunName = "";
	        	var targetColName = "";
	        	var targetColOrgName = "";
	        	var setColGubun = "";
	        	
		        for(var i=1; i <= sheet1RowCnt; i++) {
		        	
		        	if(sheetObj.CellValue(i, "check") == 1) {
		        		
			        	//var ibflag = sheetObj.CellValue(i, "ibflag");
			        	var ibflag = sheetObj.RowStatus(i);

			        	var bl_no = sheetObj.CellValue(i, "bl_no");
			        	
			        	var shprCnpjCpf = sheetObj.CellValue(i, "shpr_tax_no");
			        	var cneeCnpjCpf = sheetObj.CellValue(i, "cnee_tax_no");
			        	var ntfyCnpjCpf = sheetObj.CellValue(i, "ntfy_tax_no");
			        	
			        	var dde_sd = sheetObj.CellValue(i, "brz_decl_no");
			        	var br_duv = sheetObj.CellValue(i,"br_duv");
			        	var br_mid = sheetObj.CellValue(i,"br_mid");
			        	
			        	
			        	var cntr_no = sheetObj.CellValue(i, "cntr_no");
			        	var pck_qty = sheetObj.CellValue(i, "pck_qty");
			        	var weight = sheetObj.CellValue(i, "weight");
			        	var measure = sheetObj.CellValue(i, "measure");
			        	
			        	var ncm_no = sheetObj.CellValue(i, "ncm_no");
			        	var ncm_desc = sheetObj.CellValue(i, "cstms_desc");

			        	var custToOrdFlg = sheetObj.CellValue(i, "cust_to_ord_flg");
			        	
			        	var shprCnpjCpfOrgValue = sheetObj.CellSearchValue(i,"shpr_tax_no");
			        	var cneeCnpjCpfOrgValue = sheetObj.CellSearchValue(i,"cnee_tax_no");
			        	var ntfyCnpjCpfOrgValue = sheetObj.CellSearchValue(i,"ntfy_tax_no");

			        	var ddeSdOrgValue = sheetObj.CellSearchValue(i,"brz_decl_no");
			        	var ncmNoOrgValue = sheetObj.CellSearchValue(i,"ncm_no");
			        	
			        	var searchBkgCgoTpCd = sheetObj.CellSearchValue(i,"search_bkg_cgo_tp_cd");

			        	var brDuvOrgValue = sheetObj.CellSearchValue(i,"br_duv");
			        	var brMidOrgValue = sheetObj.CellSearchValue(i,"br_mid");

			        	//window.status = "수정중= " + cnpj_cpf + "실제글자 =" + cnpjCpfOrgValue;
			        	
			        	if(shprCnpjCpfOrgValue != shprCnpjCpf) {
			        		ComShowCodeMessage("BKG01099", bl_no);
			        		sheetObj.SelectCell(i, "shpr_tax_no", false);
			        		return false;
			        	}
			        	if(cneeCnpjCpfOrgValue != cneeCnpjCpf) {
			        		//ComShowMessage("수정중인 데이타가 있습니다.  You can’t transmit[B/L No : " +  bl_no + "]");
			        		ComShowCodeMessage("BKG01099", bl_no);
			        		sheetObj.SelectCell(i, "cnee_tax_no", false);
			        		return false;
			        	}
			        	if(ntfyCnpjCpfOrgValue != ntfyCnpjCpf) {
			        		ComShowCodeMessage("BKG01099", bl_no);
			        		sheetObj.SelectCell(i, "ntfy_tax_no", false);
			        		return false;
			        	}
			        	if(ddeSdOrgValue != dde_sd) {
			        		//ComShowMessage("수정중인 데이타가 있습니다.  You can’t transmit[B/L No : " +  bl_no + "]");
			        		ComShowCodeMessage("BKG01099", bl_no);
			        		sheetObj.SelectCell(i, "brz_decl_no", false);
			        		return false;
			        	}
			        	if(ncmNoOrgValue != ncm_no) {
			        		//ComShowMessage("수정중인 데이타가 있습니다.  You can’t transmit[B/L No : " +  bl_no + "]");
			        		ComShowCodeMessage("BKG01099", bl_no);
			        		sheetObj.SelectCell(i, "ncm_no", false);
			        		return false;
			        	}
			        	if(brDuvOrgValue != br_duv) {
			        		//ComShowMessage("수정중인 데이타가 있습니다.  You can’t transmit[B/L No : " +  bl_no + "]");
			        		ComShowCodeMessage("BKG01099", bl_no);
			        		sheetObj.SelectCell(i, "br_duv", false);
			        		return false;
			        	}
			        	if(brMidOrgValue != br_mid) {
			        		//ComShowMessage("수정중인 데이타가 있습니다.  You can’t transmit[B/L No : " +  bl_no + "]");
			        		ComShowCodeMessage("BKG01099", bl_no);
			        		sheetObj.SelectCell(i, "br_mid", false);
			        		return false;
			        	}
			        	
			        	var ibTsYn = sheetObj.CellSearchValue(i,"ib_ts_yn"); //I/B T/S 경우 : VVD.POD 와 BKG.POD 다를 경우 = 'Y' CNPJ/CPF Skip
			        	var obTsYn = sheetObj.CellSearchValue(i,"ob_ts_yn"); //O/B T/S 경우 : VVD.POL 와 BKG.POL 다를 경우 ='Y' CNPJ/CPF Skip
			        	
			        	if(searchBkgCgoTpCd != "P") { // Cargo Type != Empty
			        		
			        		if(validationFlag) {
			        		
				        		if(formObj.io_type[0].checked) {
					        		// Outbound

					        		//VVD.POL 와 BKG.POL 다를 경우 ='Y' CNPJ/CPF Skip
						        	if ( obTsYn == "Y" ) {
						        		validationFlag = false;
				        			
						        	} else if(shprCnpjCpf == "") {
						        		//ComShowMessage("Missing [CNPJ/CPF].  You can’t transmit[B/L No : " +  bl_no + "]");
						        		ComShowCodeMessage("BKG01100", "Shipper CNPJ/CPF", bl_no);
						        		sheetObj.SelectCell(i, "shpr_tax_no");
						        		return false;
						        	}
						        	if(dde_sd == "") {		  // O/B
						        		//ComShowMessage("Missing [DDE/SD].  You can’t transmit[B/L No : " +  bl_no + "]");
						        		ComShowCodeMessage("BKG01100", "DDE/SD", bl_no);
						        		sheetObj.SelectCell(i, "brz_decl_no");
						        		return false;
						        	}
				        		} else {
					        		// Inbound
				        			// VVD.POD 와 BKG.POD 다를 경우 = 'Y' CNPJ/CPF Skip
						        	if (ibTsYn == "Y") {
						        		validationFlag = false;
						        		
						        	} else if(custToOrdFlg == "Y" && ntfyCnpjCpf == "") {
				        				// Order B/L
						        		ComShowCodeMessage("BKG01100", "Notify CNPJ/CPF", bl_no);
						        		sheetObj.SelectCell(i, "ntfy_tax_no");
						        		return false;
				        				
				        			} else if(custToOrdFlg == "N" && cneeCnpjCpf == "") {
				        				// Straight B/L
						        		ComShowCodeMessage("BKG01100", "Consignee CNPJ/CPF", bl_no);
						        		sheetObj.SelectCell(i, "cnee_tax_no");
						        		return false;
				        			}
				        			
				        		}
				        		
			        		}
			        		
				        	if(cntr_no == "") {
				        		//ComShowMessage("Missing [Package].  You can’t transmit[B/L No : " +  bl_no + "]");
				        		ComShowCodeMessage("BKG01100", "Container", bl_no);
				        		sheetObj.SelectCell(i, "cntr_no");
				        		return false;
				        	}
				        	if(pck_qty == "") {
				        		//ComShowMessage("Missing [Package].  You can’t transmit[B/L No : " +  bl_no + "]");
				        		ComShowCodeMessage("BKG01100", "Package", bl_no);
				        		sheetObj.SelectCell(i, "pck_qty");
				        		return false;
				        	}
				        	if(weight == "") {
				        		//ComShowMessage("Missing [Weight].  You can’t transmit[B/L No : " +  bl_no + "]");
				        		ComShowCodeMessage("BKG01100", "Weight", bl_no);
				        		sheetObj.SelectCell(i, "weight");
				        		return false;
				        	}
				        	if(measure == "") {
				        		//ComShowMessage("Missing [Measure].  You can’t transmit[B/L No : " +  bl_no + "]");
				        		ComShowCodeMessage("BKG01100", "Measure", bl_no);
				        		sheetObj.SelectCell(i, "measure");
				        		return false;
				        	}
				        	
				        	if(formObj.io_type[0].checked) {
				        		// OB
				        		targetColGubunName  = "diff_shpr_tax_no_flag";
				        		targetColName = "shpr_tax_no";
				        		targetColOrgName = "ob_shpr_tax_no";
				        		setColGubun = "shpr";
				        		
				        	} else {
				        		// IB
				        		
				        		if(custToOrdFlg == "Y") {
					        		targetColGubunName  = "diff_ntfy_tax_no_flag";
					        		targetColName = "ntfy_tax_no";
					        		targetColOrgName = "ob_ntfy_tax_no";
					        		setColGubun = "ntfy";
				        		} else {
					        		targetColGubunName  = "diff_cnee_tax_no_flag";
					        		targetColName = "cnee_tax_no";
					        		targetColOrgName = "ob_cnee_tax_no";
					        		setColGubun = "cnee";
				        		}
				        	}	

//				        	alert("targetColGubunName : " + targetColGubunName);
//				        	alert("sheetObj.CellValue(i,targetColGubunName.toString()) : " + sheetObj.CellValue(i,targetColGubunName.toString()));
//							alert("sheetObj.CellValue(i,targetColOrgName.toString() : "+ sheetObj.CellValue(i,targetColOrgName.toString()));
//							alert("sheetObj.CellValue(i,targetColName.toString()) : " +  sheetObj.CellValue(i,targetColName.toString()));
				        	
					        //CNPJ,세관 CNPJ 둘 중 하나 이상 NULL이거나 두 데이터가 다를 때
							if( "Y" == sheetObj.CellValue(i,targetColGubunName.toString()) ) {
									
//								alert(targetColGubunName.toString() + " : " + sheetObj.CellValue(i,targetColGubunName.toString()));
					        	
								//BRZ_BL Data 있을 경우 전송 가능, OB Data에 없어도 되는지 간단히 체크만 한 후 전송
								if(sheetObj.CellValue(i,targetColOrgName.toString()) == "" && sheetObj.CellValue(i,targetColName.toString()) != "") {
									// OB테이블이 null 세관쪽 데이터가 not null 일 때 >> OB Data 에 없어도 되는지 컨펌 한 후 전송
									if((eval(setColGubun + "BrzNotNvlArr").length > 0) && (sheetObj.CellValue(i,"bl_no") == eval(setColGubun + "BrzNotNvlArr")[eval(setColGubun + "BrzNotNvlArr").length -1])) {
										continue;
									}
//									brzNotNvlArr.push(sheetObj.CellValue(i,"bl_no"));
									eval(setColGubun + "BrzNotNvlArr").push(sheetObj.CellValue(i,"bl_no"));
								} else if(sheetObj.CellValue(i,targetColOrgName.toString()) != "" && sheetObj.CellValue(i,targetColName.toString()) != "") {
									// //둘 다 NULL이 아니고 값이 상이할 때
									if((eval(setColGubun + "ObBrzNotNvlArr").length > 0) && (sheetObj.CellValue(i,"bl_no") == eval(setColGubun + "ObBrzNotNvlArr")[eval(setColGubun + "ObBrzNotNvlArr").length -1])) {
										continue;
									}	
//									obBrzNotNvlArr.push(sheetObj.CellValue(i,"bl_no"));
									eval(setColGubun + "ObBrzNotNvlArr").push(sheetObj.CellValue(i,"bl_no"));
								} else if(sheetObj.CellValue(i,targetColOrgName.toString()) == "" && sheetObj.CellValue(i,targetColName.toString()) == "") {
									// 둘 다 NULL일때
									if((eval(setColGubun + "ObBrzNvlArr").length > 0) && (sheetObj.CellValue(i,"bl_no") == eval(setColGubun + "ObBrzNvlArr")[eval(setColGubun + "ObBrzNvlArr").length -1])) {
										continue;
									}
//									obBrzNvlArr.push(sheetObj.CellValue(i,"bl_no"));
									eval(setColGubun + "ObBrzNvlArr").push(sheetObj.CellValue(i,"bl_no"));
								} else if(sheetObj.CellValue(i,targetColOrgName.toString()) != "" && sheetObj.CellValue(i,targetColName.toString()) == "") {
									//세관쪽 데이터가 NULL일 때
									
									if((eval(setColGubun + "BrzNvlArr").length > 0) && (sheetObj.CellValue(i,"bl_no") == eval(setColGubun + "BrzNvlArr")[eval(setColGubun + "BrzNvlArr").length -1])) {
										continue;
									}
//									brzNvlArr.push(sheetObj.CellValue(i,"bl_no"));
									eval(setColGubun + "BrzNvlArr").push(sheetObj.CellValue(i,"bl_no"));
								}
							}	
							
			        	} // end if(searchBkgCgoTpCd != "P") {
			        	
						
		        	}
		        	
		        } // end for(i)
		        
		        

//		        // 요기 코딩 중
//		        
//		        if(formObj.io_type[0].checked) {
//		        	// O/B
//		        	
//		        	// 둘 다 NULL이 아니고 값이 상이할 때
//			        var obBrzNotNvlArr = "";
//		        	
//			        if(shprObBrzNotNvlArr.length > 0) {
//			        	if(obBrzNotNvlArr != "") {
//			        		obBrzNotNvlArr += " ,";
//			        	}
//			        	obBrzNotNvlArr += " (Shipper) : " + shprObBrzNotNvlArr.toString();
//			        }
//			        
//		        } else {
//		        	// I/B
//			        // 둘 다 NULL이 아니고 값이 상이할 때
//			        var obBrzNotNvlArr = "";
//			        if(cneeObBrzNotNvlArr.length > 0) {
//			        	obBrzNotNvlArr += "(Consignee) : " + cneeObBrzNotNvlArr.toString();
//			        } else if(ntfyObBrzNotNvlArr.length > 0) {
//			        	obBrzNotNvlArr += " (Notfy) : " + ntfyObBrzNotNvlArr.toString();
//			        }
//			        
//		        }
//		        
//				if(obBrzNotNvlArr.length > 0) { //둘 다 NULL이 아니고 값이 상이할 때
//
//					ComShowCodeMessage("BKG01171", obBrzNotNvlArr.toString());
//		            return false;
//				} 
		        
		        if(validationFlag) {
		        	
			        // 둘 다 NULL이 아니고 값이 상이할 때
			        var obBrzNotNvlArr = "";
			        if(cneeObBrzNotNvlArr.length > 0) {
			        	obBrzNotNvlArr += "(Consignee) : " + cneeObBrzNotNvlArr.toString();
			        } else if(shprObBrzNotNvlArr.length > 0) {
			        	obBrzNotNvlArr += " (Shipper) : " + shprObBrzNotNvlArr.toString();
			        } else if(ntfyObBrzNotNvlArr.length > 0) {
			        	obBrzNotNvlArr += " (Notfy) : " + ntfyObBrzNotNvlArr.toString();
			        }
			        
					if(obBrzNotNvlArr.length > 0) { //둘 다 NULL이 아니고 값이 상이할 때
						ComShowCodeMessage("BKG01171", obBrzNotNvlArr.toString());
			            return false;
					} 
					
					
			        // 둘 다 NULL일때
			        var obBrzNvlArr = "";
			        if(cneeObBrzNvlArr.length > 0) {
			        	obBrzNvlArr += "(Consignee) : " + cneeObBrzNvlArr.toString();
			        } else if(shprObBrzNvlArr.length > 0) {
			        	obBrzNvlArr += " (Shipper) : " + shprObBrzNvlArr.toString();
			        } else  if(ntfyObBrzNvlArr.length > 0) {
			        	obBrzNvlArr += " (Notfy) : " + ntfyObBrzNvlArr.toString();
			        }
					
					if(obBrzNvlArr.length > 0) { //둘 다 NULL일때
						ComShowCodeMessage("BKG01173", obBrzNvlArr);
			            return false;
					} 
					
					
					
			        // 세관쪽 데이터가 NULL일 때
			        var brzNvlArr = "";
			        if(cneeBrzNvlArr.length > 0) {
			        	brzNvlArr += "(Consignee) : " + cneeBrzNvlArr.toString();
			        } else if(shprBrzNvlArr.length > 0) {
			        	brzNvlArr += " (Shipper) : " + shprBrzNvlArr.toString();
			        } else  if(ntfyBrzNvlArr.length > 0) {
			        	brzNvlArr += " (Notfy) : " + ntfyBrzNvlArr.toString();
			        }
					if(brzNvlArr.length > 0) { //세관쪽 데이터가 NULL일 때
						ComShowCodeMessage("BKG01174", brzNvlArr);
			            return false;
					}
					
			        // OB테이블이 null 세관쪽 데이터가 not null 일 때 >> OB Data 에 없어도 되는지 컨펌 한 후 전송
			        var brzNotNvlArr = "";
			        if(cneeBrzNotNvlArr.length > 0) {
			        	brzNotNvlArr += "(Consignee) : " + cneeBrzNotNvlArr.toString();
			        } else if(shprBrzNotNvlArr.length > 0) {
			        	brzNotNvlArr += " (Shipper) : " + shprBrzNotNvlArr.toString();
			        } else if(ntfyBrzNotNvlArr.length > 0) {
			        	brzNotNvlArr += " (Notfy) : " + ntfyBrzNotNvlArr.toString();
			        }
	
					if(brzNotNvlArr.length > 0) { 
	
			            if(!ComShowConfirm(ComGetMsg("BKG01172", brzNotNvlArr))) {
			            	return false;
			            }
					}
				    
		        }
				
		        
				break;
			}
			
	    } // end switch
    
    return true;
    	
    	
    }
    
    /**
     * BackEndJob 실행결과조회<br>
     * 
     * @param sheetObj
     * @param sKey
     */
    function doActionValidationResult(sheetObj, sKey) {
    	//ComShowMessage("1");
    	var sXml = sheetObj.GetSearchXml("ESM_BKG_0127GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
    	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

    	//ComShowMessage("doActionValidationResult "+sJbStsFlg);
    	
    	// 에러가 발생했을 경우 대기사항을 종료한다.
    	if (!ComBkgErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 성공메시지 보여주고
    		ComShowCodeMessage('BKG00101');	
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		//에러
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 에러메시지 보여주고
    		ComShowMessage(ComResultMessage(sXml));
    	}
    }
    

    /**
     * IBSheet에 셀 클릭시 팝업 처리
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
	function sheet1_OnPopupClick(sheetObj, Row,Col)	{

		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
      	switch(colName)
      	{
  	    	case "ncm_no":
	  	  		var sUrl = "/hanjin/ESM_BKG_0745_P.do?page_gubun=popup&ncm_no="+sheetObj.CellValue(Row, 'ncm_no');
	  			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0745_P", 1024, 520, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, 'ncm_no') = rtnVal.cd;
	  				sheetObj.CellValue2(Row, 'cstms_desc') = rtnVal.nm;
	  				
	  				if( rtnVal.cd != "" ){
	  					sheetObj.CellValue2(Row, 'ncm_multi_pop') = "1";
	  					setNcmMulti(Row, sheetObj.CellValue(Row, "ncm_no"));
	  				}
	  			}
  	    		break;
      	}
	}
	
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if ((srcName == "vvd_cd" || srcName == "pol_cd" )&& ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    	
    }
    
    /**
     * 라디오 버튼 체크시 필수 체크
     * @param formObject
     * @return
     */
    function ioCheck(formObj) {
    	
    	if(formObj.io_type[0].checked) {

    		if(formObj.pol_cd.value == "") {
    			//ComComShowMessageFocus(formObj.pol_cd, "POL은 필수 값입니다.");
    			ComShowCodeMessage("BKG01100", "POL");
    			ComSetFocus(formObj.pol_cd);
    			return false;
    		}
    		
    		
    	} else if(formObj.io_type[1].checked) {

    		if(formObj.pod_cd.value == "") {
    			//ComComShowMessageFocus(formObj.pod_cd, "POD는 필수 값입니다.");
    			ComShowCodeMessage("BKG01100", "POD");
    			ComSetFocus(formObj.pod_cd);
    			return false;
    		}
    		
    	}
    	
    	return true;
    	
    }
    
    /**
     * 시트를 클릭했을 때 처리
     */
    function sheet1_OnClick(sheetObj, row, col) {
    	
    	var rowCnt = sheetObj.RowCount;
        var ifFlag = sheetObj.CellValue(row,"if_flag");
        var check = sheetObj.CellValue(row,"check");
        var keyBlNo = sheetObj.CellValue(row,"key_bl_no");
        var hideCheck = sheetObj.CellValue(row,"hide_check");
        var colSaveName = sheetObj.ColSaveName(col);
        
        switch(colSaveName) {
	    	case "shipper_cust_nm" :
	    	case "consignee_cust_nm" :
	    	case "notify_cust_nm" :
	    	case "cstms_desc" :
	    	case "booking_cmdt_nm" :
	    		/* 긴 문자열 MemoPad 처리*/
	    		if(sheetObj.CellValue(row,col) != "") {
	    			ComShowMemoPad(sheetObj, null, null, true, 250, 80);
	    		}
	    		break;
	    		
	    	case "cnee_tax_no" :
	    	case "brz_decl_no" :
	    	case "ncm_no" :
	            if(ifFlag == "N") {
            		ComShowMessage("You can’t save data. Please download B(s)/L first.");
            		return false;
	            }
	            break;
	        
	    	case "check" :
	    		for(i=1; i<=rowCnt; i++) {
		    		if(check == 1) {
		    			if(i == row) continue;
		    			if(keyBlNo == sheetObj.CellValue(i, "key_bl_no")) {
		    				sheetObj.CellValue2(i, "check") = 0;
		    			}
		    		} else if(check == 0) {
		    			if(i == row) continue;
		    			if(keyBlNo == sheetObj.CellValue(i, "key_bl_no")) {
		    				sheetObj.CellValue2(i, "check") = 1;
		    			}
		    		}
	    		}
	    		break;
	    		
	    	case "hide_check" :
	    		for(i=1; i<=rowCnt; i++) {
	        		if(hideCheck == 1) {
	        			if(i == row) continue;
	        			if(keyBlNo == sheetObj.CellValue(i, "key_bl_no")) {
	        				sheetObj.CellValue2(i, "hide_check") = 0;
	        			}
	        		} else if(hideCheck == 0) {
	        			if(i == row) continue;
	        			if(keyBlNo == sheetObj.CellValue(i, "key_bl_no")) {
	        				sheetObj.CellValue2(i, "hide_check") = 1;
	        			}
	        		}
	    		}
        		break;
        		
	    	case "ncm_multi_pop":
	    		if(ifFlag == "N") {
            		ComShowMessage("You can’t save data. Please download B(s)/L first.");
            		return false;
	            } else if( sheetObj.CellValue(row,"ncm_multi_pop") == "1" ){
  	    			var param = "";
					param = param + '?bl_no=' + sheetObj.CellValue(row,"bl_no");
					param = param + '&cntr_no=' + sheetObj.CellValue(row,"cntr_no");
					param = param + '&cntr_mf_seq=' + sheetObj.CellValue(row,"cntr_mf_seq");
					param = param + '&ncm_multi_no=' + sheetObj.CellValue(row,"ncm_multi_no");
					param = param + '&openner_sheet_ncm_no=' + sheetObj.CellValue(row,"ncm_no");
					param = param + '&org_sheet=' + "0";
					param = param + '&org_row=' + row;
					ComOpenPopup('/hanjin/ESM_BKG_1154.do' + param, 340,500,'', '1,0,1,1,1,1,1,1', true);
//					ComOpenPopup('/hanjin/ESM_BKG_1154.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
  	    		}
        		break;
        } // end switch
        
    }
    
    /**
     * Booking Creation 화면 이동
     * @param sheetObj Sheet
     * @param Row Row Index
     * @param Col Col Index
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
    	var srcCol = sheetObj.ColSaveName(Col);
    	if (srcCol != "bl_no" && srcCol != "bkg_no") return;
    	
    	ComBkgCall0079(sheetObj.CellValue(Row, "bl_no"));

    }    
    
    /**
     * 조회 후 이벤트
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		
		sheetObj.checkAll2("check") = 0;
		sheetObj.checkAll2("hide_check") = 1;
		
		var formObj = document.form;
		var polCntCd = formObj.pol_cd.value.substring(0,2);
		var podCntCd = formObj.pod_cd.value.substring(0,2);
		var custToOrdFlg = "";
		
		if (ErrMsg == "") {
			
			// IO TYPE 설정(조회 후 한번더 설정함)
			ioTypeCheck(formObj,polCntCd, podCntCd);

			var olbBlNo = "";
	        var currBlNo = ""
	        var sheetMaxCnt = sheetObj.RowCount;
	        
	        for(var i=1; i <= sheetMaxCnt; i++) {
	        	
	        	if(formObj.io_type[0].checked) {
	        		// O/B 일 경우
		        	//shiper CNPJ No 항목이, O/B 데이터(BKG_XPT_IMP_LIC) 와 BKG_CSTMS_BRZ_BL 테이블 상의 CNEE_TAX_NO 와 다를 경우 빨간색으로 표기함
		        	if( (sheetObj.CellValue(i,"ob_shpr_tax_no") == "" && sheetObj.CellValue(i,"shpr_tax_no") == "")
		        		||(sheetObj.CellValue(i,"ob_shpr_tax_no") == "" && sheetObj.CellValue(i,"shpr_tax_no") != "") ) {
		        		sheetObj.CellValue2(i,"diff_shpr_tax_no_flag") = "Y";
		        	} else if( sheetObj.CellValue(i,"ob_shpr_tax_no") != "" && (sheetObj.CellValue(i,"ob_shpr_tax_no") != sheetObj.CellValue(i,"shpr_tax_no")) ) {
		        		sheetObj.CellFontColor(i,"ob_shpr_tax_no") = sheetObj.RgbColor(255,0,0);
		        		sheetObj.CellFontColor(i,"shpr_tax_no") = sheetObj.RgbColor(255,0,0);
		        		sheetObj.CellValue2(i,"diff_shpr_tax_no_flag") = "Y";
		        	}

	        	} else {
	        		
	        		// I/B 일 경우 
	        		
	        		custToOrdFlg = sheetObj.CellValue(i, "cust_to_ord_flg");
	        		
	        		if(custToOrdFlg == "N") { // B/L Type : Straight
		        		 
			        	//consignee CNPJ No 항목이, O/B 데이터(BKG_XPT_IMP_LIC) 와 BKG_CSTMS_BRZ_BL 테이블 상의 CNEE_TAX_NO 와 다를 경우 빨간색으로 표기함
			        	if( (sheetObj.CellValue(i,"ob_cnee_tax_no") == "" && sheetObj.CellValue(i,"cnee_tax_no") == "")
			        		||(sheetObj.CellValue(i,"ob_cnee_tax_no") == "" && sheetObj.CellValue(i,"cnee_tax_no") != "") ) {
			        		sheetObj.CellValue2(i,"diff_cnee_tax_no_flag") = "Y";
			        	} else if( sheetObj.CellValue(i,"ob_cnee_tax_no") != "" && (sheetObj.CellValue(i,"ob_cnee_tax_no") != sheetObj.CellValue(i,"cnee_tax_no")) ) {
			        		if(sheetObj.CellValue(i,"cust_to_ord_flg") == "N") {
				        		sheetObj.CellFontColor(i,"ob_cnee_tax_no") = sheetObj.RgbColor(255,0,0);
				        		sheetObj.CellFontColor(i,"cnee_tax_no") = sheetObj.RgbColor(255,0,0);
				        	}
			        		sheetObj.CellValue2(i,"diff_cnee_tax_no_flag") = "Y";
			        	}
		        	
	        		} else { // B/L Type : Order
	
			        	//notyfy CNPJ No 항목이, O/B 데이터(BKG_XPT_IMP_LIC) 와 BKG_CSTMS_BRZ_BL 테이블 상의 CNEE_TAX_NO 와 다를 경우 빨간색으로 표기함
			        	if( (sheetObj.CellValue(i,"ob_ntfy_tax_no") == "" && sheetObj.CellValue(i,"ntfy_tax_no") == "")
			        		||(sheetObj.CellValue(i,"ob_ntfy_tax_no") == "" && sheetObj.CellValue(i,"ntfy_tax_no") != "") ) {
			        		sheetObj.CellValue2(i,"diff_ntfy_tax_no_flag") = "Y";
			        	} else if( sheetObj.CellValue(i,"ob_ntfy_tax_no") != "" && (sheetObj.CellValue(i,"ob_ntfy_tax_no") != sheetObj.CellValue(i,"ntfy_tax_no")) ) {
			        		if(sheetObj.CellValue(i,"cust_to_ord_flg") == "Y") {
				        		sheetObj.CellFontColor(i,"ob_ntfy_tax_no") = sheetObj.RgbColor(255,0,0);
				        		sheetObj.CellFontColor(i,"ntfy_tax_no") = sheetObj.RgbColor(255,0,0);
			        		}
			        		sheetObj.CellValue2(i,"diff_ntfy_tax_no_flag") = "Y";
			        	}
			        	
	        		}
		        	
	        	}
	        	
	        	if(sheetObj.CellValue(i,"oft") == "Y") {
	        		sheetObj.CellFontColor(i,"oft") = sheetObj.RgbColor(0,0,255);
	        	} else {
	        		sheetObj.CellFontColor(i,"oft") = sheetObj.RgbColor(255,0,0);
	        	}
	        	if(sheetObj.CellValue(i,"cap") == "Y") {
	        		sheetObj.CellFontColor(i,"cap") = sheetObj.RgbColor(0,0,255);
	        	} else {
	        		sheetObj.CellFontColor(i,"cap") = sheetObj.RgbColor(255,0,0);
	        	}
	        	
	        	//sheetObj.CellValue2(i,"ibfalg") = "R";
	        	sheetObj.RowStatus(i) = "R";
				
				if (sheetObj.CellValue(i,"if_flag") == "N" ) {
					sheetObj.CellEditable(i, "shpr_tax_no") = false;
					sheetObj.CellEditable(i, "cnee_tax_no") = false;
					sheetObj.CellEditable(i, "ntfy_tax_no") = false;
					sheetObj.CellEditable(i, "brz_decl_no") = false;
					sheetObj.CellEditable(i, "ncm_no") = false;
					sheetObj.CellEditable(i, "br_duv") = false;
					sheetObj.CellEditable(i, "br_mid") = false;
				}
			
				currBlNo = sheetObj.CellValue(i,"bl_no");
//				if(olbBlNo == currBlNo) {
//					sheetObj.CellEditable(i, "cnee_tax_no") = false;
//					sheetObj.CellEditable(i, "brz_decl_no") = false;
//				}
				olbBlNo = currBlNo;
				
				if( sheetObj.CellValue(i,"ncm_multi_flg") == "Y" ){
					sheetObj.CellBackColor(i,"ncm_no") = sheetObj.RgbColor(252, 196, 245);
				}
				
			} // end for(i)
			
			
		}
		
	}

	/**
	 * 마이스 이동시 이벤트
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function sheet1_OnMouseMove(Button, Shift, X, Y) {
		//window.status = "OnMouseMove Row=" + Row + ", Col=" + Col + ", Text=" + sText;

		Row = sheetObjects[0].MouseRow;
		Col = sheetObjects[0].MouseCol;
		
        var colSaveName = sheetObjects[0].ColSaveName(Col);
        
        var sText = "";

        switch(colSaveName) {
        	case "shipper_cust_nm" :
        	case "consignee_cust_nm" :
        	case "notify_cust_nm" : 
        	case "cstms_desc" : 
        	case "booking_cmdt_nm" :
        		//풍선도움말 만들기
        		sText = sheetObjects[0].CellText(Row,Col);
        		break;
        }
        
        sheetObjects[0].MouseToolTipText = sText;
		
		  
	}
	
	/**
	 * 시트 Change 이벤트
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
    function sheet1_OnChange(sheetObj, row, col, value){
    	
    	var formObject = document.form;
    	
    	var rowCnt = sheetObj.RowCount;
        var ifFlag = sheetObj.CellValue(row,"if_flag");
        var check = sheetObj.CellValue(row,"check");
        var keyBlNo = sheetObj.CellValue(row,"key_bl_no");
        var hideCheck = sheetObj.CellValue(row,"hide_check");
        var colSaveName = sheetObj.ColSaveName(col);
        
        switch(colSaveName) {
	    	case "ncm_no" :
	    		formObject.brz_cmdt_cd.value = value;
	    		doActionIBSheet(sheetObj,formObject,SEARCH02,row,col);
	    		
	    		break;
	    		
	    	case "shpr_tax_no" :
	    		for(i=1; i<=rowCnt; i++) {
	    			if(i == row) continue;
	    			if(keyBlNo == sheetObj.CellValue(i, "key_bl_no")) {
	    				sheetObj.CellValue2(i, "shpr_tax_no") = value;
	    			}
	    		}
	    		break;
	    	case "cnee_tax_no" :
	    		for(i=1; i<=rowCnt; i++) {
	    			if(i == row) continue;
	    			if(keyBlNo == sheetObj.CellValue(i, "key_bl_no")) {
	    				sheetObj.CellValue2(i, "cnee_tax_no") = value;
	    			}
	    		}
	    		break;
	    	case "ntfy_tax_no" :
	    		for(i=1; i<=rowCnt; i++) {
	    			if(i == row) continue;
	    			if(keyBlNo == sheetObj.CellValue(i, "key_bl_no")) {
	    				sheetObj.CellValue2(i, "ntfy_tax_no") = value;
	    			}
	    		}
	    		break;
	    	case "brz_decl_no" :
	    		for(i=1; i<=rowCnt; i++) {
	    			if(i == row) continue;
	    			if(keyBlNo == sheetObj.CellValue(i, "key_bl_no")) {
	    				sheetObj.CellValue2(i, "brz_decl_no") = value;
	    			}
	    		}
	            break;
	    	case "br_duv" :
	    		for(i=1; i<=rowCnt; i++) {
	    			if(i == row) continue;
	    			if(keyBlNo == sheetObj.CellValue(i, "key_bl_no")) {
	    				sheetObj.CellValue2(i, "br_duv") = value;
	    			}
	    		}
	            break;
	    	case "br_mid" :
	    		for(i=1; i<=rowCnt; i++) {
	    			if(i == row) continue;
	    			if(keyBlNo == sheetObj.CellValue(i, "key_bl_no")) {
	    				sheetObj.CellValue2(i, "br_mid") = value;
	    			}
	    		}
	            break;
	            
	        
        } // end switch    	

    }
    
	function setNcmMulti(row, val) {
		var sheetObj = sheetObjects[0];
		var fNcmMultiStr = sheetObj.CellValue(row, "ncm_multi_no");
		var arrLeng = fNcmMultiStr.split(",").length;
		
		var chkFlg = "";
		//ncm값 중복체크	
		for(var i=0;i<arrLeng;i++){
			if(fNcmMultiStr.split(",")[i] == val){
				chkFlg = "Y";
				break;
			}
		}
		if(chkFlg == "Y"){
			ComShowCodeMessage("BKG00764","NCM code");
			sheetObj.ReturnCellData(row, "ncm_no");		
			return false;
		}
		
//		alert("arrLeng : " + arrLeng + "\nval["+val+"]");
		if(ComIsEmpty(val)){			
			if(arrLeng == 1){
				sheetObj.CellValue2(row, "ncm_multi_no") = "";
			}else if(arrLeng > 1){
				sheetObj.CellValue2(row,"ncm_no") = fNcmMultiStr.split(",")[1];
				sheetObj.CellValue2(row, "ncm_multi_no") = fNcmMultiStr.split(",").slice(1,arrLeng);
			}
		}else{
			if(fNcmMultiStr == ""){
				sheetObj.CellValue2(row, "ncm_multi_no") = val;
			}else{	
				if(arrLeng == 1){
					sheetObj.CellValue2(row, "ncm_multi_no") = val;
				}else if(arrLeng > 1){
					sheetObj.CellValue2(row, "ncm_multi_no") = val + "," +fNcmMultiStr.split(",").slice(1,arrLeng);
				}
			}
			
		}
	}
	
	/**
	 * Click 이벤트 Catch
	 */
	function obj_click() {
		var formObj = document.form;
		var srcObj = window.event.srcElement;
		var srcName = srcObj.getAttribute("name");
		var srcVal = srcObj.checked;
		if (srcName == "io_type") {
			changeSheetTitle();
		}
	}
	
	/**
	 * sheet header(Carriage Date) 타이틀 변경
	 * @param dType
	 */
	function changeSheetTitle() {
		var formObj = document.form;
		
		if(formObj.io_type[0].checked) {
			sheetObjects[0].CellValue2(0, "cap") = "OTH";
		} else {
			sheetObjects[0].CellValue2(0, "cap") = "DTH";
		}
	}
	
    
	/* 개발자 작업  끝 */