/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0296.js
*@FileTitle : ESM_BKG_0296
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.20 경종윤
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
     * @class ESM_BKG_0296 : ESM_BKG_0296 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0296() {
    	this.processButtonClick		= processButtonClick;
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
	
    var comboObjects = new Array();
    var comboCnt = 0;

	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		         var sheetObject1 = sheetObjects[0];
 		         var sheetObject2 = sheetObjects[1];
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		
			var vvdCd = formObject.vvd_cd.value;
			var polCd = formObject.pol_cd.value;
			var podCd = formObject.pod_cd.value;
			var vslNm = formObject.vsl_nm.value;
			var emptyCheck = "";
			
			if(formObject.empty_check.checked == true) {
				emptyCheck = "on"
			} else {
				emptyCheck = ""
			}

			//ComShowMessage("vvdCd : " + vvdCd + "\n polCd : " + polCd + "\n podCd : " + podCd);
     		
			switch(srcName) {

 							case "btn_retrieve":
 								doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 								break;
 							
 							case "btn_save":
 								doActionIBSheet(sheetObject1,formObject,MULTI);
 								break; 
 							
 							case "btn_downexcel":
 			                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 								break;
 							
 							case "btn_formset":
 								var sParam = "vvd_cd="+vvdCd+"&pol_cd="+polCd+"&pod_cd="+podCd;
 								ComOpenWindowCenter("/hanjin/ESM_BKG_0300.do?"+sParam, "ESM_BKG_0300", 600, 400, true);
 								//ComOpenWindowCenter("/hanjin/ESM_BKG_0300.do?"+sParam, "ESM_BKG_0300", 600, 350, true);
 								break; 
 							
 							case "btn_formprint":
 								var sParam = "vvd_cd="+vvdCd+"&pol_cd="+polCd+"&pod_cd="+podCd+"&vsl_nm="+vslNm;
 								ComOpenWindowCenter("/hanjin/ESM_BKG_0299.do?"+sParam, "ESM_BKG_0299", 300, 240, true);
 								//ComOpenWindowCenter("/hanjin/ESM_BKG_0299.do?"+sParam, "ESM_BKG_0299", 300, 190, true);
 								break; 
 							
 							case "btn_igmedi":
 								//ComShowMessage("btn_igmedi ["+emptyCheck+"]"); 								
 								var sParam = "vvd_cd="+vvdCd+"&pol_cd="+polCd+"&pod_cd="+podCd+"&empty_check="+emptyCheck;
 								ComOpenWindowCenter("/hanjin/ESM_BKG_0302.do?"+sParam, "ESM_BKG_0302", 500, 220, true);
 								break;
 							case "btn_request":
 								//ComShowMessage("btn_request ["+emptyCheck+"]"); 								
 								var sParam = "vvd_cd="+vvdCd+"&pol_cd="+polCd+"&pod_cd="+podCd+"&empty_check="+emptyCheck;
 								//ComOpenWindowCenter("/hanjin/ESM_BKG_0303.do?"+sParam, "ESM_BKG_0303", 500, 400, true);
 								ComOpenWindowCenter("/hanjin/ESM_BKG_0303.do?"+sParam, "ESM_BKG_0303", 500, 240, true);
 								break;
 							
 							case "btn_cntrlist":
 								
 								var sParam = "vvd_cd="+vvdCd+"&pol_cd="+polCd+"&pod_cd="+podCd;
 								ComOpenWindowCenter("/hanjin/ESM_BKG_0298.do?"+sParam, "ESM_BKG_0298", 500, 220, true);
 								//ComOpenWindowCenter("/hanjin/ESM_BKG_0298.do?"+sParam, "ESM_BKG_0298", 500, 170, true);
 								break;			

 							case "btns_assign":
 								doActionIBSheet(sheetObject1,formObject,COMMAND01);
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
      * 콤보 Object를 comboObjects 배열에 등록
      * @param combo_obj
      * @return
      */
     function setComboObject(combo_obj) {
     	comboObjects[comboCnt++] = combo_obj; 
     }
     



     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

         //시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
        
 		var comboObjMaxLen = comboObjects.length; 
		for(i = 0; i < comboObjMaxLen; i++ ) {
			// IBCombo 초기화
			initCombo(comboObjects[i], i+1);
		}
         
		ComSetFocus(document.form.vvd_cd); 
		
		//화면에서 필요한 이벤트
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		
    	ComBtnDisable("btn_formprint");
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
             case "t1sheet1":      //t1sheet1 init
                 with (sheetObj) {
                  	
					// 높이 설정
					style.height = 285;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|hidden_bl_no||Seq.|M.B/L No.|Line|File No.|TP|H/BL|POL|POD|POD|DEL|DEL|Type|Dest Code|CFS Code|IAL|Mode|Bond Code|Trans Operator|Consignee Name|Customer Description|Item|h_down_check|h_vvd_cd";
					var HeadTitle2 = "|hidden_bl_no||Seq.|M.B/L No.|Line|File No.|TP|H/BL|POL|POD_CD|YARD|DEL_CD|YARD|Type|Dest Code|CFS Code|IAL|Mode|Bond Code|Trans Operator|Consignee Name|Customer Description|Item|h_down_check|h_vvd_cd";

					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    var prefix = "";
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		100,	daLeftTop,	true,		prefix + "merge_bl_no",		false,		"", dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenterTop,true,		prefix + "check",       	false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenterTop,true,		prefix + "group_seq",      	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenterTop,true,		prefix + "bl_no",    		false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenterTop,false,		prefix + "ida_line_no", 	false,		"",	dfNone,		0,		true,		true,	4);
                                                                                 
					InitDataProperty(0, cnt++ , dtData,			110,	daLeft,		false,		prefix + "hbl_no",     		false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,		prefix + "bl_cust_tp",  	false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,		prefix + "hbl_ind",     	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		prefix + "pol_cd",      	false,		"",	dfNone,		0,		false,		false);

					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix + "pod_cd",      	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		prefix + "pod_nod_cd",      	false,		"",	dfNone,		0,		false,		false);
                                                                                 
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix + "del_cd",      	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		prefix + "del_nod_cd",      	false,		"",	dfNone,		0,		false,		false);

					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,		prefix + "entry_tp",    	false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopup,		90,		daCenter,	false,		prefix + "dest_cd", 		false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopup,		90,		daCenter,	false,		prefix + "cfs_cd",  		false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		prefix + "ial",      		false,		"",	dfNone,		0,		true,		true);
                                                                                                                           	
					InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	false,		prefix + "mode_trans",  	false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		prefix + "bd_area_cd",		false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			210,	daLeft,		false,		prefix + "trns_opr_id",		false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			210,	daLeft,		false,		prefix + "customer_name",	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		false,		prefix + "bcd_desc",		false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	false,		prefix + "item_tp",     	false,		"",	dfNone,		0,		true,		true);

					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,		prefix + "down_check",     	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,		prefix + "vvd_cd",     	false,		"",	dfNone,		0,		false,		false);

					InitDataCombo(0, prefix + "entry_tp", "LC|TI|TC", "LC|TI|TC");
					InitDataCombo(0, prefix + "mode_trans", "T : Train|R : Road|S : Ship", "T|R|S");
					InitDataCombo(0, prefix + "item_tp", "OT|GC|UB", "O|G|U");
																									
					ShowButtonImage = 4;
					WaitImageVisible = false;
                	}
                 break;        
                 
                
             case "t2sheet1":      //t2sheet1 init
                 with (sheetObj) {
                  	
					// 높이 설정
					style.height = 259;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Seq.|Container No.|TP|Stowage|WGT(ton)|B/L No.|POL|POD|DEL|TS|CGO|DG|RF|AK|BB|Special Cargo Data|h_down_check|h_vvd_cd";

					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    var prefix = "";
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	false,		prefix + "Seq");
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,		prefix + "cntr_no",			false,		"",	dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,		prefix + "cntr_tpsz_cd",	false,		"",	dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,		prefix + "ida_stwg_no",		false,		"",	dfNone,			0,		true,		true);

					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,		prefix + "cntr_wgt",		false,		"",	dfNullFloat,2,			false,		false); 
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,		prefix + "bl_no",			false,		"",	dfNone,			0,		false,		false);										
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,		prefix + "pol_cd",     		false,		"",	dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,		prefix + "pod_cd",       	false,		"",	dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,		prefix + "del_cd",      	false,		"",	dfNone,			0,		false,		false);
                                                                                                               	
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,		prefix + "ts_cntr_flg",     false,		"",	dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,		prefix + "bkg_cgo_tp_cd",   false,		"",	dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,		prefix + "dcgo_flg",     	false,		"",	dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,		prefix + "rc_flg",       	false,		"",	dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,		prefix + "awk_cgo_flg",     false,		"",	dfNone,			0,		false,		false);
                                                                                                              	
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,		prefix + "bb_cgo_flg",      false,		"",	dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		prefix + "spcl_cgo_desc",   false,		"",	dfNone,			0,		false,		false);

					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,		prefix + "down_check",     	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,		prefix + "vvd_cd",     		false,		"",	dfNone,		0,		false,		false);
					WaitImageVisible = false;

                 }
                 break;      

         }
     }
     
     /**
      * Combo Object 초기화
      * @param comboObj
      * @param comNo
      * @return
      */
     function initCombo(comboObj, comNo) {
     	
     	//ComShowMessage("comboObj ID : " + comboObj.id);

         var i=0;

         switch(comboObj.id) {
	            case "entry_type": {
	            	i = 0;
	            	
	                with(comboObj) {
	                    InsertItem(i++, "All",          	"0");
	                    InsertItem(i++, "LC : Local",       "1");
	                    InsertItem(i++, "TI : SMTP",        "2");
	                    InsertItem(i++, "TC : T/S", 		"3");
	                    Code = "0";
	                }
	                break;
	            }
         } // end switch
         
     }
     

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
		 var rowCnt = sheetObjects[0].RowCount;
		 var rowCnt1 = sheetObjects[1].RowCount;

         switch(sAction) {

 					case IBSEARCH:      //조회
 						if(!validateForm(sheetObj,formObj,sAction)) return false;
 					ComOpenWait(true);
 						formObj.f_cmd.value = SEARCH;
 		 				var sXml = sheetObj.GetSearchXml("ESM_BKG_0296GS.do" , FormQueryString(formObj) );
 		 				
 		 				var arrXml = sXml.split("|$$|");
 		 				
 		 				//ComShowMessage("arrXml.length => " + arrXml.length);
 		 				// 상당 VESSEL 정보 셋팅
 		 				var masterResult		= ComGetEtcData(arrXml[0], "masterResult"); // 조회정보 유무 리턴값 ('success', 'fail')
 		 				
 		 				if(masterResult == "success") {
 		 				
 		 					formObj.igm_no.value 	= ComGetEtcData(arrXml[0],"igmNo");
	 		 				formObj.igm_date.value 	= ComGetEtcData(arrXml[0],"igmDate");
	 		 				formObj.vsl_nm.value 	= ComGetEtcData(arrXml[0],"vslNm");
	 		 				formObj.eta_dt.value 	= ComGetEtcData(arrXml[0],"etaDt");

	 		 				// sheet1 셋팅
 		 					sheetObjects[0].LoadSearchXml(arrXml[0]);
	 		 				
	 		 				// sheet2 셋팅
 		 					sheetObjects[1].LoadSearchXml(arrXml[1]);

	 		 				//ComShowMessage("[" + formObj.img_date.value + "]");
	 		 				//formObj.img_date.value	= ComGetMaskedValue(formObj.img_date.value, "ymd");
	 		 				formObj.tot_bl_num.value = sheetObjects[0].RowCount;
 		 				} else {
 		 					formObj.igm_no.value 		= "";
	 		 				formObj.igm_date.value 		= "";
	 		 				formObj.vsl_nm.value 		= "";
	 		 				formObj.eta_dt.value 		= "";
	 		 				formObj.tot_bl_num.value 	= "";
	 		 				
	 		 				sheetObjects[0].LoadSearchXml(arrXml[0]);
	 		 				sheetObjects[1].LoadSearchXml(arrXml[1]);
 		 				}

 		 				ComOpenWait(false);
 						break;
 					
 					case MULTI:        //저장
 						
 						if(!validateForm(sheetObj,formObj,sAction)) return false;
 						
 						for(var i=1; i<=rowCnt; i++) {
 							
 							if(sheetObjects[0].CellValue(i, "down_check") == 'N') {
 								//sheetObjects[0].CellValue2(i,"ibflag") = "I";
 								sheetObjects[0].RowStatus(i) = "I";
 							} 
 						}
 						
 						for(var i=1; i<=rowCnt1; i++) {
 							
 							if(sheetObjects[1].CellValue(i, "down_check") == 'N') {
 								//sheetObjects[1].CellValue2(i,"ibflag") = "I";
 								sheetObjects[1].RowStatus(i) = "I";
 							}
 						}
 						
 						formObj.f_cmd.value = MULTI;

 						var sParam = "";
 						
 						var sParamSheet1 = sheetObjects[0].GetSaveString();
 						if (sParamSheet1 != "") {
 							sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
 						}
 						
 						var sParamSheet2 = sheetObjects[1].GetSaveString();
 						if (sParamSheet2 != "") {
 							sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
 						}

 	  	                if (sParam == "") {
 	  	                	ComShowCodeMessage('BKG00743');
 	  	                	return;
 	  	                }

 						sParam += "&" + FormQueryString(formObj);

 						
 						
 						var sXml = sheetObj.GetSaveXml("ESM_BKG_0296GS.do", sParam);
 						
 						
 						var selTab = document.tab1.SelectedIndex;
 						
 						sheetObjects[selTab].LoadSaveXml(sXml);
 						
						if(ComBkgErrMessage(sheetObj, sXml)) {
							doActionIBSheet(sheetObj,formObj,IBSEARCH); // 재조회
						} 

						break;
						
 					
 					case COMMAND01:  // Line No. Assign 
 						
 						if(!validateForm(sheetObj,formObj,sAction)) return false;
 						
 						goAssign(sheetObj,formObj);
 						
 						break;
 						
 					case IBDOWNEXCEL:      // 엑셀
 						
 				        var objs = document.all.item("tabLayer");
 				         
 			 	    	if(objs[0].style.display == "inline") {
 			 	    		sheetObjects[0].SpeedDown2Excel(-1);
 			 	    	} else {
 			 	    		sheetObjects[1].SpeedDown2Excel(-1);
 			 	    	}

 						break;
 						
 					
         }

         // 
         for(var i=1; i <= sheetObjects[0].RowCount; i++) {
        	 
 			if (sheetObjects[0].CellValue(i,"hbl_ind") != "00") {
 				sheetObjects[0].CellFontColor(i, "hbl_no") = sheetObj.RgbColor(0,0,255); //H B/L 색상 표시
 			} 
 			
 			if (sheetObjects[0].CellValue(i,"ida_line_no") == "") {
 				sheetObjects[0].CellValue2(i, "ida_line_no") = "0";
 			}
 			

 			if (sheetObjects[0].CellValue(i,"pod_cd") == "INMAA") {
 				
 	 			if(sheetObjects[0].CellValue(i,"entry_tp") == "LC") {
 	 				sheetObj.CellEditable(i, "cfs_cd") = true;
 	 				sheetObj.CellEditable(i, "mode") = false;
 	 				sheetObj.CellEditable(i, "trns_opr_id") = false;
 					sheetObj.CellEditable(i, "bd_area_cd") = true;
 	 			} else if(sheetObjects[0].CellValue(i,"entry_tp") == "TI") {
 	 				sheetObjects[0].CellValue2(i, "cfs_cd") = sheetObjects[0].CellValue(i,"pod_cd");
 	 				sheetObj.CellEditable(i, "cfs_cd") = false;
 	 				sheetObj.CellEditable(i, "mode") = true;
 	 				sheetObj.CellEditable(i, "trns_opr_id") = false;
 					sheetObj.CellEditable(i, "bd_area_cd") = true;
 	 			} else if(sheetObjects[0].CellValue(i,"entry_tp") == "TC") {
 	 				sheetObj.CellEditable(i, "mode") = true;
 	 				sheetObj.CellEditable(i, "trns_opr_id") = false;
 					sheetObj.CellEditable(i, "bd_area_cd") = true;
 	 			}
 			} else if (sheetObjects[0].CellValue(i,"pod_cd") == "INNAH") {

 				if(sheetObjects[0].CellValue(i,"entry_tp") == "LC") {
 	 				sheetObj.CellEditable(i, "cfs_cd") = true;
 					sheetObj.CellEditable(i, "bd_area_cd") = false;
 	 				sheetObj.CellEditable(i, "mode") = false;
 	 				sheetObj.CellEditable(i, "trns_opr_id") = false;
 	 			} else if(sheetObjects[0].CellValue(i,"entry_tp") == "TI") {
 	 				sheetObjects[0].CellValue2(i, "cfs_cd") = "";
 	 				sheetObj.CellEditable(i, "cfs_cd") = false;
 					sheetObj.CellEditable(i, "bd_area_cd") = true;
 	 				sheetObj.CellEditable(i, "mode") = true;
 	 				sheetObj.CellEditable(i, "trns_opr_id") = true;
 	 			} else if(sheetObjects[0].CellValue(i,"entry_tp") == "TC") {
 					sheetObj.CellEditable(i, "bd_area_cd") = false;
 	 				sheetObj.CellEditable(i, "mode") = true;
 	 				sheetObj.CellEditable(i, "trns_opr_id") = true;
 	 			}
 				
 			}
 			
 			
 		} // end for(i)
        
         
        var fCnt = 0;
        var tCnt = 0;
        for(var i=1; i <= sheetObjects[1].RowCount; i++) {
        	var tp = sheetObjects[1].CellValue(i,"cntr_tpsz_cd");
        	
        	if(tp != "" && tp.length == 2) {
        		tp = tp.substr(1.1);
        		
        		if(tp == "2") {
        			tCnt++;
        		} else {
        			fCnt++;
        		}
        	}
        	
        } // end for(i)
        
        document.getElementById("f_cnt").value = fCnt;
        document.getElementById("t_cnt").value = tCnt;
         
         
     }

     /**
      * 다중 저장시 PREFIX 붙여주기
      * @param sStr
      * @param sPrefix
      * @return
      */
     function ComSetPrifix(sStr, sPrefix) {
         if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
             return sStr;
         }

         var regexp = RegExp(/&/g);
         sStr = sPrefix + sStr.replace(regexp, "&" + sPrefix);
         return sStr;
     }
     

     
     /**
      * Assign버튼 클릭시 B/L그리드에 Line No. 할당
      * 
      * @param sheetObj
      * @param formObj
      * @return
      */
     function goAssign(sheetObj,formObj) {
    	 var rowCnt = sheetObj.RowCount;
    	 var fromLineNo = formObj.from_line_no.value - 1;
    	 var toLineNo   = formObj.to_line_no.value;
    	 
    	 //ComShowMessage("toLineNo : [" + toLineNo + "]");
    	 
    	 var check;
    	 
    	 for(i=0; i<=rowCnt; i++) {
    		 check = sheetObjects[0].CellValue(i, "check");
    		 
    		 if(check == 1) {
    			 sheetObjects[0].CellValue2(i, "ida_line_no") = ++fromLineNo;
    			 
    			 if(fromLineNo == toLineNo) break;
    		 }
    		 
    	 } // end for(i)
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
                     InsertTab( cnt++ , "B/L" , -1 );
                     InsertTab( cnt++ , "CNTR" , -1 );
                
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

 	    	//--------------- 요기가 중요 --------------------------//
 	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
 	    	//------------------------------------------------------//
 	    	beforetab= nItem;
 		

     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction) {
    	 
     	switch(sAction) {
     		case IBSEARCH :
				//기본포멧체크
				if (!ComChkValid(formObj)) return false;
     			
     			break;
     	
     		case MULTI:
     			
     			var shee1RowCnt = sheetObjects[0].RowCount;
     			var cfsCd = "";
     			
				for(var i=1; i<=shee1RowCnt; i++) {
					
					var cfsCd = sheetObjects[0].CellValue(i,"cfs_cd");
					
					if(sheetObjects[0].CellValue(i, "entry_tp") == 'LC') {
						if(sheetObjects[0].CellValue(i,"cfs_cd") == "") {
							//ComShowMessage("seq " + sheetObjects[0].CellValue(i,"seq") + "번의 [CFS Code] 항목은 필수 입력입니다.");
							ComShowCodeMessage("BKG01102", sheetObjects[0].CellValue(i,"seq"), "CFS Code");
							return false;
						}
						
//						if(ComChkLen(cfsCd, "6") != "2" && ComChkLen(cfsCd, "8") != "2") {
//							//ComShowMessage("seq " + sheetObjects[0].CellValue(i,"seq") + "번의 [CFS Code] 항목 길이는 숫자 6 또는 8자리 입니다.");
//							ComShowCodeMessage("BKG01103", sheetObjects[0].CellValue(i,"seq"), "CFS Code");
//							return false;
//						}
						
					} else {
						
					}
					
				} // end for(i)

     			
     			break;
     	
     		case COMMAND01: // Assign버튼 
     			
     			var rowCnt = sheetObj.RowCount;
     			var checkCnt = 0;
     			var firstCnt = 0;
     			
     			if(rowCnt == 0) {
     				//ComShowMessage("조회된 데이타가 없습니다.");
     				ComShowCodeMessage('BKG00889');
     				return false;
     			}

     			var fromLineNo = formObj.from_line_no.value;
     			var toLineNo = formObj.to_line_no.value;
     			
     			if(fromLineNo == "") {
     				//ComShowMessage("Line No. 시작 숫자를 입력 후 사용해주세요.");
     				ComShowCodeMessage('BKG01104');
     				ComSetFocus(formObj.from_line_no);
     				return false;
     			}
     			
     			for(i=0; i < rowCnt; i++) {
     				if(sheetObj.CellValue(i, "check") ==  "1") {
     					checkCnt++;
     				} else {
     					
     					var lineNo = sheetObj.CellValue(i, "ida_line_no");
     					if(lineNo != "" || lineNo != "0") {
     						firstCnt++;
     					}
     				}
     			}
     			
     			if(checkCnt == 0) {
     				//ComShowMessage("Assign할  row를 먼저 check해 주세요 ");
     				ComShowCodeMessage('BKG01105');
     				return false;
     			}

     			if(firstCnt == 0) {
     				//ComShowMessage("Assign할 데이타가 없습니다.");
     				ComShowCodeMessage('BKG01106');
     				return false;
     			}
     			
     			
     			break;
     	}

         return true;
     }
      
     /**
      * IBSheet에 셀 클릭시 팝업 처리
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
 	function t1sheet1_OnPopupClick(sheetObj, Row,Col)	{

 		var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		
       	switch(colName) {
	    	case "dest_cd":
 	  	  		var sUrl = "/hanjin/ESM_BKG_0334_Q.do";
	  	  		var params = "?country="+formObj.cnt_cd.value;
 	  	  		
 	  			var rtnVal = ComOpenWindowCenter(sUrl + params, "ESM_BKG_0334", 1007, 520, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, 'dest_cd') = rtnVal.cd;
 	  				//sheetObj.CellValue2(Row, 'cstms_desc') = rtnVal.nm;
 	  			}
   	    		break;
   	    	case "cfs_cd":
 	  	  		var sUrl = "/hanjin/ESM_BKG_0305_P.do";
 	  			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0305_P", 1007, 520, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, 'cfs_cd') = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, 'bd_area_cd') = rtnVal.nm;
 	  			}
   	    		break;
       	} // end switch()
 		
 	}
     
     
     /**
      * 조회조건 입력할 때 처리
      */
     function obj_KeyUp() {
     	var formObject = document.form;
     	var srcName = window.event.srcElement.getAttribute("name");
     	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
     	var srcValue = window.event.srcElement.getAttribute("value");
     	/*
     	if (srcName == "vvd_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
     		ComSetNextFocus();
     	}
     	*/
     	
     }
     

     
     /**
      * 시트를 클릭했을 때 처리
      */
     function t1sheet1_OnClick(sheetObj, row, col) {
     	var rowCnt = sheetObj.RowCount;
        var check = sheetObj.CellValue(row,"check");
        var groupSeq = sheetObj.CellValue(row,"group_seq");
        var colSaveName = sheetObj.ColSaveName(col);

    	for(var i=1; i<=rowCnt; i++) {
    		
    		if(colSaveName == "check") {
    		
	    		if(check == 1) {
	    			
	    			if(i == row) continue;
	    			
	    			if(groupSeq == sheetObj.CellValue(i, "group_seq")) {
	    				sheetObj.CellValue2(i, "check") = 0;
	    			}
	    			
	    		} else if(check == 0) {
	    			
	    			if(i == row) continue;
	    			
	    			if(groupSeq == sheetObj.CellValue(i, "group_seq")) {
	    				sheetObj.CellValue2(i, "check") = 1;
	    			}
	    			
	    		} 
    		}
    	} // end for(i)
        
     }
     

     /**
      * 시트 Change 이벤트
      * 
      * @param sheetObj
      * @param Row
      * @param Col
      * @param Value
      * @return
      */
     function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
    	 
     	var colname = sheetObj.ColSaveName(Col);  
    	var formObj = document.form
    	
    	switch(colname)	{
	    	case "entry_tp":
	    		
	    		if(Value == "LC") {
	    			if (sheetObj.CellValue(Row,"pod_cd") == "INMAA") {
	 	 				sheetObj.CellEditable(Row, "cfs_cd") = true;
	 	 				sheetObj.CellEditable(Row, "mode") = false;
	 	 				sheetObj.CellEditable(Row, "trns_opr_id") = false;
	 					sheetObj.CellEditable(Row, "bd_area_cd") = true;
	    				
	    			} else if (sheetObj.CellValue(Row,"pod_cd") == "INNAH") {
	 	 				sheetObj.CellEditable(Row, "cfs_cd") = true;
	 					sheetObj.CellEditable(Row, "bd_area_cd") = false;
	 	 				sheetObj.CellEditable(Row, "mode") = false;
	 	 				sheetObj.CellEditable(Row, "trns_opr_id") = false;
	    				
	    			}
	    			
	    		} else if(Value == "TI") {
	    			if (sheetObj.CellValue(Row,"pod_cd") == "INMAA") {
	 	 				sheetObjects[0].CellValue2(Row, "cfs_cd") = sheetObjects[0].CellValue(Row,"pod_cd");
	 	 				sheetObj.CellEditable(Row, "cfs_cd") = false;
	 	 				sheetObj.CellEditable(Row, "mode") = true;
	 	 				sheetObj.CellEditable(Row, "trns_opr_id") = false;
	 					sheetObj.CellEditable(Row, "bd_area_cd") = true;

	    			} else if (sheetObj.CellValue(Row,"pod_cd") == "INNAH") {
	    				
	 	 				sheetObjects[0].CellValue2(Row, "cfs_cd") = "";
	 	 				sheetObj.CellEditable(Row, "cfs_cd") = false;
	 					sheetObj.CellEditable(Row, "bd_area_cd") = true;
	 	 				sheetObj.CellEditable(Row, "mode") = true;
	 	 				sheetObj.CellEditable(Row, "trns_opr_id") = true;
	    				
	    			}

	    		} else if(Value == "TC") {
	    			if (sheetObj.CellValue(Row,"pod_cd") == "INMAA") {
	 	 				sheetObj.CellEditable(Row, "mode") = true;
	 	 				sheetObj.CellEditable(Row, "trns_opr_id") = false;
	 					sheetObj.CellEditable(Row, "bd_area_cd") = true;

	    				
	    			} else if (sheetObj.CellValue(Row,"pod_cd") == "INNAH") {
	 					sheetObj.CellEditable(Row, "bd_area_cd") = false;
	 	 				sheetObj.CellEditable(Row, "mode") = true;
	 	 				sheetObj.CellEditable(Row, "trns_opr_id") = true;

	    			}
	    			
	    		}
	    			
	    		
	    		break;
    	} // end switch()
    	
     }
     
     /**
      * 조회 후 이벤트
      * @param sheetObj
      * @param ErrMsg
      * @return
      */
 	function t1sheet1_OnSearchEnd(sheetObj,ErrMsg){

 		var rowCnt = sheetObj.RowCount;
 		
 		if(rowCnt == 0 ) {
 			ComBtnDisable("btn_formprint");
 		} else {
 			ComBtnEnable("btn_formprint");
 		}
 		
 		var exitOrg = sheetObj.EtcData("retExitOrg");
         
         if(exitOrg == "0") {
         	//ComShowMessage("사용가능한 Office Code가 아닙니다.");
			ComShowCodeMessage("BKG01107");
         	return false;
         } else if(exitOrg == "") {
 			if (ErrMsg == "") {
 				if(sheetObj.RowCount == 0) {
 					ComShowCodeMessage("BKG00889");
 					return false;
 				}
 			}
         	
         } else {
 		
         }
 	}
     

	/* 개발자 작업  끝 */