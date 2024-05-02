/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0099.js
*@FileTitle : Booking Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.18 최영희
* 1.0 Creation
* -------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
* 2010.11.17 전성진 [CHM-201005932] PRD FlexHeight 및 TRO Split 처리관련 BKG 수정
* 2011.05.25 김기종 [CHM-201109394-01] DPCS고도화일환으로 Split 처리시 BKG NO 수정과 DPCS SI전송 (ESM_BKG_0455 화면에서 CALL)
* 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
* 2012.02.27 정선용 [CHM-201215886-01] Split 기능 보완_FileZilla
* 2012.05.29 조정민 [CHM-201217777] GOH Booking Split 시 경고 팝업 메세지 추가
* 2012.10.22 조정민 [CHM-201220706] Special Appliatoin Split시 호출방식 변경
* 2013.05.09 최문환 [CHM-201324474] BKG/DOC Module에서의 MT BKG Split 제한 요청
* 2014.07.25 문동선 [CHM-201430707] FumigationHide liner 버튼 및 팝업창 구현, BST 조회 로직
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
     * @class esm_bkg_0099 : esm_bkg_0099 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0099() {
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

var popWinObj;
var rdObjects = new Array();
var rdCnt = 0;

var sheetObjects = new Array();
var sheetCnt = 0;
var prefix1="sheet1_";
var prefix2="sheet2_";
var prefix3="sheet3_";
var prefix4="sheet4_";
var prefix5="sheet5_";
var prefix7="sheet7_";
var prefix8="sheet8_";

var strSheetTitle1=" |BKG|B/L No.|T/VVD||Weight|Weight|Package|Package|Measure|Measure|AS|";
var strSheetTitle2=" ||BKG|B/L No.|T/VVD||Weight|Weight|Package|Package|Measure|Measure|AS||P/C|Read|xter_sndr_id|xter_rqst_no|xter_rqst_seq|doc_tp_cd|rd_cgo_flg";
var strSheetTitle3="|TS|Q'ty |eq tp|eq qtr";
var strSheetTitle4="|CNTR|TS|ST|AS";
var strSheetTitle5="|CODE|CNTR_NO|DCGO_SEQ";
var asCodeList = "";
var asTextList = "";
var orgSplit = ""; 

var dgSelectFlg="N";
var rfSelectFlg="N";
var akSelectFlg="N";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){			 
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];
        var sheetObject7 = sheetObjects[6];
        var sheetObject8 = sheetObjects[7];
        /*******************************************************/
		 
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			 if(srcName != "btn_split_pop"){
        		if(layList.style.display == ""){
        			layList.style.display="none";
        		}    	    			
    		}	
            switch(srcName) {
				case "btn_retrieve":
					initData();
					if(ComIsEmpty(formObject.bkg_no)){
						ComShowCodeMessage("BKG00273");
						return;
					}
					 
					/*if(ComIsEmpty(formObject.bkg_bl)){
						ComShowCodeMessage("BKG00273");
						return;
					}
					if (ComChkLen(formObject.bkg_bl,12) !=2){
						ComShowCodeMessage("BKG00273");
						return;
					}*/
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll();
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					ComBtnEnable("btn_save");					
					ComSetObjValue(formObject.txtProgress, "");		
				break;
				
				case "btn_split_pop":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
				break;
				
				case "btn_save":
					if (validateForm(sheetObjects[0],formObject,IBSAVE)){
					    if (ComGetObjValue(formObject.bdr_flag)=="Y"){
							 comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObject.bkg_no), "C"); 
							 if(!ComIsNull(formObject.caRsnCd.value) && formObject.caRsnCd.value!=null 
									 && formObject.caRsnCd.value!="" && formObject.caRsnCd.value!='null'){
								 doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
							 }
					    } else {
					    	// close된 bkg이면 vvd 변경시 확인 처리
					    	if(formObject.bkg_close_flg.value == "Y"){
					    		var firstVvd = sheetObjects[0].CellValue(1, prefix1+"first_vvd");
					    		formObject.vvd_change_flg.value = "N";
					    		if(firstVvd == sheetObjects[0].CellValue(1, prefix1+"tvvd")){
						    		for(var i=1;i<sheetObjects[1].RowCount + 1;i++){
						    			if(firstVvd != sheetObjects[1].CellValue(i, prefix2+"tvvd")){
						    				formObject.vvd_change_flg.value = "Y";
						    				break;
						    			}
						    		}
					    		}
					    		if(formObject.vvd_change_flg.value == "Y"){
					    			// 취소면 중지
									if(!ComShowCodeConfirm("BKG00312",firstVvd)){
										return false;
									}
					    		}					    		
					    	}
					    	
					    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
					    	if(formObject.bkg_cbf_flg.value == "Y"){
								if(!ComShowCodeConfirm("BKG02069")){
									formObject.bkg_cbf_flg.value = "N";
									break;
								}							
					    	}					    
						}	
			    		doActionIBSheet(sheetObjects[0],document.form,IBSAVE);					
					}					
					break;

				case "btn_save2":
					ComSetObjValue(formObject.txtProgress, "");					
					if (validateForm(sheetObjects[0],formObject,IBSAVE)){
					    if (ComGetObjValue(formObject.bdr_flag)=="Y"){
							 comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObject.bkg_no), "C");
							 if(!ComIsNull(formObject.caRsnCd.value) && formObject.caRsnCd.value!=null 
									 && formObject.caRsnCd.value!="" && formObject.caRsnCd.value!='null'){
								 doActionIBSheet(sheetObjects[0],formObject,COMMAND05);
							 }
					    } else {
					    	// close된 bkg이면 vvd 변경시 확인 처리
					    	if(formObject.bkg_close_flg.value == "Y"){
					    		var firstVvd = sheetObjects[0].CellValue(1, prefix1+"first_vvd");
					    		formObject.vvd_change_flg.value = "N";
					    		if(firstVvd == sheetObjects[0].CellValue(1, prefix1+"tvvd")){
						    		for(var i=1;i<sheetObjects[1].RowCount + 1;i++){
						    			if(firstVvd != sheetObjects[1].CellValue(i, prefix2+"tvvd")){
						    				formObject.vvd_change_flg.value = "Y";
						    				break;
						    			}
						    		}
					    		}
					    		if(formObject.vvd_change_flg.value == "Y"){
					    			// 취소면 중지
									if(!ComShowCodeConfirm("BKG00312",firstVvd)){
										return false;
									}
					    		}					    		
					    	}
					    	
					    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
					    	if(formObject.bkg_cbf_flg.value == "Y"){
								if(!ComShowCodeConfirm("BKG02069")){
									formObject.bkg_cbf_flg.value = "N";
									break;
								}							
					    	}					    
					    	
				    		doActionIBSheet(sheetObjects[0],document.form,COMMAND05);		
						}				
					}					
				break;
				
				case "btn_dg":
					if (!CheckPopValidate(sheetObjects[3],"btn_dg",formObject)) return;
					if(ComGetObjValue(formObject.dg).toUpperCase() != "N"){
						//if (formObject.dgCntrSplitNo.value.length<1){
							ComSetObjValue(formObject.validateSplitNo,CntrCheck(sheetObjects[3],prefix4+"cntr_no"));  
						//}
						setQtyCntrVar(formObject);
						formObject.orgSplit.value = orgSplit;
//						var param = "?bkg_no="+ComGetObjValue(formObject.bkg_no)+"&splitReason="+ComGetObjValue(formObject.splitreason);
//							param +="&splitCntrSplitNo="+ComGetObjValue(formObject.dgCntrSplitNo)+"&lastSplitNo="+ComGetObjValue(formObject.lastSplitNo);
//							param +="&validateSplitNo="+ComGetObjValue(formObject.validateSplitNo);
//							param +="&cntrExists="+ComGetObjValue(formObject.cntrExists);
//							param +="&cntrPopExists="+ComGetObjValue(formObject.cntrPopExists);
//							param +="&splitCnt="+(ComParseInt(formObject.splitcount)-1)+"&orgSplit="+orgSplit+"&bkgsplitno="+ComGetObjValue(formObject.bkgsplitno);
//							param+="&pgmNo=ESM_BKG_0709";
//						ComOpenPopup("/hanjin/ESM_BKG_0709.do"+param, 600, 510, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
						ComOpenWindowCenter("ESM_BKG_0709.do", "ESM_BKG_0709", 600, 510, true);
					}
				break;
				
				case "btn_rf": 
					if (!CheckPopValidate(sheetObjects[3],"btn_rf",formObject)) return;
					if(ComGetObjValue(formObject.rf).toUpperCase() != "N"){
						//if (formObject.rfCntrSplitNo.value.length<1){
							ComSetObjValue(formObject.validateSplitNo,CntrCheck(sheetObjects[3],prefix4+"cntr_no"));  
						//}
						setQtyCntrVar(formObject);
						formObject.orgSplit.value = orgSplit;

//						var param = "?bkg_no="+ComGetObjValue(formObject.bkg_no)+"&splitReason="+ComGetObjValue(formObject.splitreason);
//						param +="&splitCntrSplitNo="+ComGetObjValue(formObject.rfCntrSplitNo)+"&lastSplitNo="+ComGetObjValue(formObject.lastSplitNo);
//						param +="&validateSplitNo="+ComGetObjValue(formObject.validateSplitNo);
//						param +="&cntrExists="+ComGetObjValue(formObject.cntrExists);
//						param +="&cntrPopExists="+ComGetObjValue(formObject.cntrPopExists);
//						param +="&splitCnt="+(ComParseInt(formObject.splitcount)-1)+"&orgSplit="+orgSplit+"&bkgsplitno="+ComGetObjValue(formObject.bkgsplitno);
//						param+="&pgmNo=ESM_BKG_0710";
//						ComOpenPopup("/hanjin/ESM_BKG_0710.do"+param, 600, 510, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
						ComOpenWindowCenter("ESM_BKG_0710.do", "ESM_BKG_0710", 600, 510, true);
					}
				break;
				
				case "btn_ak":
					if (!CheckPopValidate(sheetObjects[3],"btn_ak",formObject)) return;
					if(ComGetObjValue(formObject.ak).toUpperCase() != "N"){
						//if (formObject.akCntrSplitNo.value.length<1){
							ComSetObjValue(formObject.validateSplitNo,CntrCheck(sheetObjects[3],prefix4+"cntr_no"));  
						//}
						setQtyCntrVar(formObject);
						formObject.orgSplit.value = orgSplit;
//						var param = "?bkg_no="+ComGetObjValue(formObject.bkg_no)+"&splitReason="+ComGetObjValue(formObject.splitreason);
//						param +="&splitCntrSplitNo="+ComGetObjValue(formObject.akCntrSplitNo)+"&lastSplitNo="+ComGetObjValue(formObject.lastSplitNo);
//						param +="&validateSplitNo="+ComGetObjValue(formObject.validateSplitNo);
//						param +="&cntrExists="+ComGetObjValue(formObject.cntrExists);
//						param +="&cntrPopExists="+ComGetObjValue(formObject.cntrPopExists);
//						param +="&splitCnt="+(ComParseInt(formObject.splitcount)-1)+"&orgSplit="+orgSplit+"&bkgsplitno="+ComGetObjValue(formObject.bkgsplitno);
//						param+="&pgmNo=ESM_BKG_0715";
//						ComOpenPopup("/hanjin/ESM_BKG_0715.do"+param, 800, 510, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
						ComOpenWindowCenter("ESM_BKG_0715.do", "ESM_BKG_0715", 800, 510, true);
					}
				break;
				
				case "btn_bb":
					if (!CheckPopValidate(sheetObjects[3],"btn_bb",formObject)) return;
					if(ComGetObjValue(formObject.bb).toUpperCase() != "N"){
						//if (formObject.bbCntrSplitNo.value.length<1){
							ComSetObjValue(formObject.validateSplitNo,CntrCheck(sheetObjects[3],prefix4+"cntr_no"));  
						//}
						formObject.orgSplit.value = orgSplit;
//						var param = "?bkg_no="+ComGetObjValue(formObject.bkg_no)+"&splitReason="+ComGetObjValue(formObject.splitreason);
//						param +="&splitCntrSplitNo="+ComGetObjValue(formObject.bbCntrSplitNo)+"&lastSplitNo="+ComGetObjValue(formObject.lastSplitNo);
//						param +="&validateSplitNo="+ComGetObjValue(formObject.validateSplitNo);
//						param +="&cntrExists="+ComGetObjValue(formObject.cntrExists);
//						param +="&cntrPopExists="+ComGetObjValue(formObject.cntrPopExists);
//						param +="&splitCnt="+(ComParseInt(formObject.splitcount)-1)+"&orgSplit="+orgSplit+"&bkgsplitno="+ComGetObjValue(formObject.bkgsplitno);
//						param+="&pgmNo=ESM_BKG_0716";
//						ComOpenPopup("/hanjin/ESM_BKG_0716.do"+param, 800, 510, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
						ComOpenWindowCenter("ESM_BKG_0716.do", "ESM_BKG_0716", 800, 510, true);
					}
				break;
				
				case "btn_auto":
					if (ComIsEmpty(formObject.splitcount)) return;
				    if (ComIsEmpty(sheetObject1.CellValue(1,prefix1+"bkg_no"))) return;
				    if (ComGetObjValue(formObject.splitreason)=="C" &&ComParseInt(formObject.splitcount)==1) return; 
					if(validateForm(sheetObject1,formObject,COMMAND01)){ 
						var splitCnt=0;
						splitCnt=ComParseInt(formObject.splitcount)-1;
						
						sheet_splitSet(ComGetObjValue(formObject.splitreason),ComParseInt(formObject.lastSplitNo),splitCnt);
						autoVolume(ComParseInt(formObject.splitcount),ComGetObjValue(formObject.splitreason),ComParseInt(formObject.lastSplitNo),splitCnt);
						btnSpecialCargo(formObject);
					}
				break;

				case "btn_manual":
					if (ComIsEmpty(formObject.splitcount)) return;
					if (ComGetObjValue(formObject.splitreason)=="C" &&ComParseInt(formObject.splitcount)==1) return; 
					if(validateForm(sheetObject1,formObject,COMMAND01)){
						var splitCnt=0;
						splitCnt=ComParseInt(formObject.splitcount)-1;
						sheet_splitSet(ComGetObjValue(formObject.splitreason),ComParseInt(formObject.lastSplitNo),splitCnt);
						manualVolume(ComParseInt(formObject.splitcount),ComGetObjValue(formObject.splitreason),ComParseInt(formObject.lastSplitNo),splitCnt);
						btnSpecialCargo(formObject);
					}
				break;

				case "btn_upload":
					sheetObject7.LoadExcel(-1,-1,"",-1,-1,"Split",false,false,"1=>1|2=>2|3=>3|4=>4");
					
					if(sheetObject2.RowCount>0){
						for(var i=1;i<sheetObject7.RowCount+2;i++){
							var excelBkgNo = ComTrim(sheetObject7.CellValue(i,prefix7+"bkg_no"));
							var rowNo = sheetObject2.FindText(prefix2+"bkg_no",excelBkgNo,1,-1,true);// 완전 같은 row
							if(rowNo != -1){
								sheetObject2.CellValue2(rowNo,prefix2+"act_wgt")  = sheetObject7.CellValue(i,prefix7+"act_wgt");
								sheetObject2.CellValue2(rowNo,prefix2+"pck_qty")  = sheetObject7.CellValue(i,prefix7+"pck_qty");
								sheetObject2.CellValue2(rowNo,prefix2+"meas_qty") = sheetObject7.CellValue(i,prefix7+"meas_qty");
							}
						}
					}
					
					sheetObject8.LoadExcel(-1,-1,"",-1,-1,"Container",false,false,"1=>1|2=>2");
					
					if(sheetObject4.RowCount>0){
						for(var i=1;i<sheetObject8.RowCount+1;i++){
							var excelCntrNo = ComTrim(sheetObject8.CellValue(i,prefix8+"cntr_no"));
							var rowNo = sheetObject4.FindText(prefix4+"cntr_no",excelCntrNo,1,-1,true);// 완전 같은 row
							if(rowNo != -1){
								var excelBkgNo = ComTrim(sheetObject8.CellValue(i,prefix8+"bkg_no"));
								var excelBkgNoEnd = excelBkgNo.substr(excelBkgNo.length-2,2);
								var colNo = sheetObject4.SaveNameCol(prefix4+excelBkgNoEnd);
								if(colNo != -1){
									sheetObject4.CellValue(rowNo,colNo) = "1";
								}
							}
						}
					}
					
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
    function loadPage(asCode,asText) {
		asCodeList = " |"+asCode;
		asTextList = " |"+asText;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1,asCodeList,asTextList,true);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//iframe 생성 
		CofigIframe();

		sheetObjects[2].ExtendLastCol = false;
		sheetObjects[3].ExtendLastCol = false;
		ComBtnDisable("btn_dg");
		ComBtnDisable("btn_rf");
		ComBtnDisable("btn_ak");
		ComBtnDisable("btn_bb");
		
		ComSetDisplay("btn_save", false);  
		/*if (!ComIsEmpty(document.form.bkg_no)){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}*/
       
		//axon_event.addListenerForm('keyup', 'bkg0099_keyup', document.form);
		axon_event.addListenerFormat('keypress','bkg0099_keypress',document.form);
		axon_event.addListenerForm('click', 'bkg0099_click', document.form); 

//		if("2006505" == ComGetObjValue(document.form.usr_id)
//				||"TES_SELBB" == ComGetObjValue(document.form.usr_id)){
//			ComSetDisplay("btn_save2", true); 
//		} else {
//			ComSetDisplay("btn_save2", false); 
//		}
		
	    ComSetFocus(document.form.bkg_no);
		if (!ComIsEmpty(document.form.bkg_no)){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
			if (ComGetObjValue(document.form.openerPgmNo) == "ESM_BKG_0445"){
				ComBtnDisable("btn_auto");
				ComBtnDisable("btn_retrieve");
				
				btn_manual.fireEvent("onclick");
				setSplitValFromOpener0445();
				
				sheet_imageSetEDI(sheetObjects[1],prefix2, 2);
			}
		}
		/*
	     4.1. POL in ('USLGB','USOAK','USSEA')     
	     4.2. 첫배의 ETD가 SYSDATE보다 빠르면 Default 체크가 되게 해주세요.
		 */
		//document.form.edi_hld_flg.checked = "Y"==sheetObjects[0].EtcData("edi_hld_flg");
    }

	/*
	* Sheet 화면 깜박거리 없애는 처리
	*/
//	function sheet4_OnLoadFinish(sheetObj) {   
//		if (!ComIsEmpty(document.form.bkg_no)){
//			sheetObjects[0].WaitImageVisible = false;  
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);   
//			sheetObjects[0].WaitImageVisible = true;   
//		}
//	}   

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,asCodeList,asTextList,flag) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:      //sheet1 init // org booking info
				with (sheetObj) {
					// 높이 설정
					style.height = 102;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = strSheetTitle1;
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			 30,		daCenter,		false,		prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtData,					 110,		daCenter,		true,		prefix1+"bkg_no",			false,			"",      dfEngUpKey,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					 110,		daCenter,		true,		prefix1+"bl_no",			false,			"",      dfEngUpKey,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					 110,		daCenter,		true,		prefix1+"tvvd",				false,			"",      dfEngUpKey,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,				 110,		daCenter,		true,		prefix1+"first_vvd",		false,			"",      dfEngUpKey,		0,		false,		true);
																								
					InitDataProperty(0, cnt++ , dtData,					 110,		daRight,		true,		prefix1+"act_wgt",			false,			"",      dfFloatOrg,		3,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					 50,		daCenter,		true,		prefix1+"wgt_ut_cd",		false,			"",      dfEngUpKey,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					 110,		daRight,		true,		prefix1+"pck_qty",			false,			"",      dfInteger,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					 50,		daCenter,		true,		prefix1+"pck_tp_cd",		false,			"",      dfEngUpKey,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					 110,		daRight,		true,		prefix1+"meas_qty",			false,			"",      dfFloatOrg,		3,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					 50,		daCenter,		true,		prefix1+"meas_ut_cd",		false,			"",      dfEngUpKey,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtCombo,				 90,		daCenter,		true,		prefix1+"adv_shtg_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtImage,				 0,		    daCenter,	    true,		prefix1+"pc",				false,			"",		dfNone,				0,		false,		true);
					
					ColHidden(prefix1+"pc")=true;	
					InitDataCombo(0, prefix1+"adv_shtg_cd", asTextList,asCodeList);
					 
					if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
						ColHidden(prefix1+"adv_shtg_cd")=true;	
					}
					CountPosition = 0;

					ImageList(0) = "/hanjin/img/btng_pc.gif";	
					ImageList(1) = "/hanjin/img/btns_note.gif";
				}
				break;

			case 2:      //sheet2 init //split 정보
				with (sheetObj) {
					// 높이 설정
					style.height = 82;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false);

					var HeadTitle1 = strSheetTitle2;
					var headCount = ComCountHeadTitle(HeadTitle1);
					 
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix2+"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,		true,		prefix2+"pctl_no",			false,			"",      dfEngUpKey,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,		true,		prefix2+"bkg_no",			false,			"",      dfEngUpKey,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,		true,		prefix2+"bl_no",			false,			"",      dfEngUpKey,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,		true,		prefix2+"tvvd",				false,			"",      dfEngUpKey,		0,		true,		true,		9);
					InitDataProperty(0, cnt++ , dtHidden,		110,	daCenter,		true,		prefix2+"first_vvd",		false,			"",      dfEngUpKey,		0,		false,		true);                                                                   	
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,		true,		prefix2+"act_wgt",			false,			"",      dfFloatOrg,		3,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		prefix2+"wgt_ut_cd",		false,			"",      dfEngUpKey,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,		true,		prefix2+"pck_qty",			false,			"",      dfInteger,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		prefix2+"pck_tp_cd",		false,			"",      dfEngUpKey,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,		true,		prefix2+"meas_qty",			false,			"",      dfFloatOrg,		3,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		prefix2+"meas_ut_cd",		false,			"",      dfEngUpKey,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,		true,		prefix2+"adv_shtg_cd",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,		true,		prefix2+"rtn_route",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtImage,		0,		daCenter,	    false,		prefix2+"pc",				false,			"",	 	 dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtImage,    	35,  	daCenter, 		false, 		prefix2+"read",              false, 			"", 	 dfNone,        0, 		false, 		false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	    true,		prefix2+"xter_sndr_id",				false,			"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	    true,		prefix2+"xter_rqst_no",				false,			"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	    true,		prefix2+"xter_rqst_seq",				false,			"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	    true,		prefix2+"doc_tp_cd",				false,			"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	    true,		prefix2+"rd_cgo_flg",				false,			"",		dfNone,				0,		false,		true);
							
					ImageList(0) = "/hanjin/img/btng_pc.gif";	
					ImageList(1) = "/hanjin/img/blank.gif";
					ImageList(2) = "/hanjin/img/btns_note.gif";
					//ColHidden(prefix2+"pc")=true; 
					InitDataCombo(0, prefix2+"adv_shtg_cd", asTextList,asCodeList);
					InitDataValid(0, prefix2+"tvvd", vtEngUpOther, "0123456789");
					if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
						ColHidden(prefix2+"adv_shtg_cd")=true;	
					}
					
					CountPosition = 0;
					
				}
				break;

			case 3:      //sheet3 init// qty 배분
				with (sheetObj) {
					// 높이 설정
					style.height = 162;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);

					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, false, false,false);
					 
					var HeadTitle1 = strSheetTitle3;
					var headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);


					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	false,		prefix3+"ibflag");
					InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		prefix3+"cntr_tpsz_cd",			false,			"",      dfNone,		0,		false,		false); 
					InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,		prefix3+"op_cntr_qty",			false,			"",      dfFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	true,		prefix3+"eq_subst_cntr_tpsz_cd",			false,			"",      dfNone,		0,		false,		false); 
					InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix3+"eq_subst_cgo_qty",			false,			"",      dfFloat,		2,		false,		false);
					  
					if(orgSplit.length>1){
						InitDataProperty(0, cnt++ , dtData,				60,		daRight,	true,		prefix3+orgSplit,				false,			"",      dfFloat,		2,		true,		true); 
					}
					 
					 
					CountPosition = 0; 
				}
				break;
					
			case 4:      //sheet4 init// cntr 배분
				with (sheetObj) {
					// 높이 설정
					style.height = 162;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, false, false,false);

					var HeadTitle1 = strSheetTitle4; 
					var headCount = ComCountHeadTitle(HeadTitle1);
				    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		prefix4+"ibflag");
					InitDataProperty(0, cnt++ , dtData,				120,	daCenter,	true,		prefix4+"cntr_no",			false,			"",      dfNone,			0,		false,		false); 
					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	true,		prefix4+"cntr_tpsz_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	true,		prefix4+"cnmv_sts_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			80,		daCenter,	true,		prefix4+"adv_shtg_cd",		false,			"",      dfNone,			0,		false,		false); 
					if(flag &&  orgSplit.length>1){
						InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	true,		prefix4+orgSplit,			false,			"",      dfNone,			0,		true,		true);
					}
					InitDataCombo(0, prefix4+"adv_shtg_cd", asTextList,asCodeList);
					if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
						ColHidden(prefix4+"adv_shtg_cd")=true;	
					}
					CountPosition = 0;
				}
				break;	
			
			case 5:      //sheet5 init//spcl 배분
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, false, false,false);

					var HeadTitle1 = strSheetTitle5; 
					var headCount = ComCountHeadTitle(HeadTitle1);
				    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		prefix5+"ibflag");
					InitDataProperty(0, cnt++ , dtData,				120,	daCenter,	true,		prefix5+"code",			false,			"",      dfNone,			0,		false,		false); 
					InitDataProperty(0, cnt++ , dtData,				120,	daCenter,	true,		prefix5+"cntr_no",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	true,		prefix5+"dcgo_seq",		false,			"",      dfNone,			0,		false,		false);
					 
					CountPosition = 0;
				}
				break;				
			case 6:      //sheet6 init for PRD QTY
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);

					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, false, false,false);
					 
					var HeadTitle1 = "|TS|Q'ty";
					var headCount = 3;
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 3, 0, true);


					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		"c_tpsz",			false,			"",      dfNone,		0,		false,		false); 
					InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,		"c_qty",			false,			"",      dfFloat,		2,		false,		false);
					CountPosition = 0; 
				}
				break;
				
			case 7:      //Split 시트 LoadExcel 용
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false);

					var HeadTitle1 = "ibflag|Booking no.|Weight|Package|Measure";
					var headCount = ComCountHeadTitle(HeadTitle1);
					 
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix7+"ibflag");
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,		true,		prefix7+"bkg_no",			false,			"",      dfEngUpKey,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,		true,		prefix7+"act_wgt",			false,			"",      dfNone,		3,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,		true,		prefix7+"pck_qty",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,		true,		prefix7+"meas_qty",			false,			"",      dfNone,		3,		true,		true);
							
					CountPosition = 0;
				}
				break;	
			case 8:      //CNTR 배분 시트 LoadExcel 용
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false);
	
					var HeadTitle1 = "ibflag|Container no.|Booking no."; 
					var headCount = ComCountHeadTitle(HeadTitle1);
					 
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		prefix8+"ibflag");
					InitDataProperty(0, cnt++ , dtData,				120,	daCenter,	true,		prefix8+"cntr_no", false,			"",      dfNone,			0,		false,		false); 
					InitDataProperty(0, cnt++ , dtData,				120,	daCenter,	true,		prefix8+"bkg_no",  false,			"",      dfNone,			0,		false,		false);
					CountPosition = 0;
				}
				break;		
					
	    }
	}

    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		var arrPreFix = new Array("sheet1_","sheet3_","sheet4_","sheet5_","sheet2_");
        switch(sAction) {

			case IBSEARCH:      //조회 
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_save2");
			    formObj.f_cmd.value = SEARCH;
				sheetObj.WaitImageVisible = false;	
				ComOpenWait(true);
			    var sXml = sheetObj.GetSearchXml("ESM_BKG_0099GS.do", "f_cmd="+SEARCH+"&bkg_no="+formObj.bkg_no.value + "&bl_no"+formObj.bl_no.value + "&"+ComGetPrefixParam(arrPreFix));
				ComOpenWait(false);
				
				var arrXml = sXml.split("|$$|");
				if (ComGetTotalRows(arrXml[0]) == 0) ComShowCodeMessage("BKG00889");
				iniFormSheet(); 

				/*
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="C"){  
					strSheetTitle3="|TS|Q'ty|"+orgSplit;
					strSheetTitle4="|CNTR|TS|ST|AS|"+orgSplit;
				}else{
					strSheetTitle3="|TS|Q'ty|";
					strSheetTitle4="|CNTR|TS|ST|AS|";

				}*/
				
				//loadInitSheet(orgSplit);
			    if(ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY") != "S"){
			    	sheetObjects[0].LoadSearchXml(arrXml[0]); 
			    	return false;
			    } 
			    
				for(var i = 0; i < arrXml.length; i++){ 
					if(i==0){
						sheetObjects[i].Redraw = false;    
						if(i > 0) {
							sheetObjects[i].WaitImageVisible = false;	
						}  
						sheetObjects[i].LoadSearchXml(arrXml[i]); 
						sheetObjects[i].Redraw = true;
					}else{
						sheetObjects[i+1].Redraw = false;    
						if(i > 0) {
							sheetObjects[i+1].WaitImageVisible = false;	
						}  
						sheetObjects[i+1].LoadSearchXml(arrXml[i]); 
						sheetObjects[i+1].Redraw = true;
					}
				}

				if(ComGetObjValue(formObj.bkg_no).length==11 || ComGetObjValue(formObj.bkg_no).length==13){ //old bkg_no
					if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
						orgSplit="91";
					}else{
						orgSplit="00";
					}
				}else if(ComGetObjValue(formObj.bkg_no).length==12){  //new bkg_no
					//orgSplit = ComGetObjValue(formObj.bkg_no).substring(10,12);
					if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
						orgSplit=sheetObj.EtcData("memoSplitNo");
					}else{
						
						orgSplit=sheetObj.EtcData("custSplitNo");
					}
				}
				setFormData(formObj,sheetObj);
				ComSetObjValue(formObj.troTp, sheetObj.EtcData("troTp"));

				//Check_Cntr(sheetObjects[3],prefix4+orgSplit);
				/*if(ComGetObjValue(formObj.bdr_flag)=="Y"){
					ComSetDisplay("btn_reason",true);
					ComSetDisplay("btn_left",true);
					ComSetDisplay("btn_right",true);
				}else{
					ComSetDisplay("btn_reason",false);
					ComSetDisplay("btn_left",false);
					ComSetDisplay("btn_right",false);
				}*/
//				alert(formObject.bkg_close_flg.value);

				if("Y"==sheetObj.EtcData("multiSplitFlg")){
					ComSetDisplay("btn_save", false);
					ComSetDisplay("btn_save2", true);
				} else {
					ComSetDisplay("btn_save", true);
					ComSetDisplay("btn_save2", false);
				}
				if(ComGetObjValue(formObj.bkgStsCd).toUpperCase()=="S"){
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_save2");
				}
				
				if(formObj.bkg_no.value.length > 11 
						&& formObj.bkg_no.value.substring(10, 11) == "9"){
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_save2");
				}
			break;

			case COMMAND01:      //booking split no조회 
				 formObj.f_cmd.value = COMMAND01;
				 sheetObj.WaitImageVisible = false;
				 var sXml = sheetObj.GetSearchXml("ESM_BKG_0099GS.do", "f_cmd="+COMMAND01+"&bkg_no="+formObj.bkg_no.value);
				 
				 var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
				 bkgSplitNoListPop(document.form.bkg_no,bkg_split_no_list); 
				  
			break;
			
			case IBSAVE:        //저장			
				if(formObj.lt_flg.value == 'Y' && formObj.splitcount.value >= 10) {
		            formObj.f_cmd.value = COMMAND04;
		        } else {
		            formObj.f_cmd.value = MULTI;
		        }
 
			 	for(i = 1; i<sheetObjects[1].Rows;i++){
			 		if (ComGetObjValue(formObj.splitreason).toUpperCase()=="C"){
			 			if(sheetObjects[1].CellValue(i, prefix2+"bkg_no").substring(10)=="90"){
			 				ComShowCodeMessage("BKG00884");
			 				return;
			 			}
			 		} else {
			 			if(sheetObjects[1].CellValue(i, prefix2+"bkg_no").substring(10)=="100"){
			 				ComShowCodeMessage("BKG00884");
			 				return;		 	
			 			}
			 		}
			 	}
				setQtyCntrVar(formObj);
//				 return;// jsy 나중 삭제
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return;  
				sParam += "&" + FormQueryString(formObj);
				sheetObj.WaitImageVisible=false;
        		ComOpenWait(true);
				var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0099GS.do", sParam);
				ComOpenWait(false);
				
				sheetObjects[0].LoadSaveXml(sXml);
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				var splitFlg = ComGetEtcData(sXml,"split_flag");
				if(State == "S"){	     
					ComBtnDisable("btn_save");
			    	if(formObj.bkg_close_flg.value == "Y" && formObj.vvd_change_flg.value == "Y"){
						//bkg close mail open
						//=========================================================================================
						var subject = "BKG Change Notice";
						var closeBkgMsg = "BKG No : " + formObj.bkg_no.value + "<BR>" +						
										  "Current VVD : " + "<BR>" +						
										  "Current Route : " + "<BR>" +						
										  "Current CNTR No : " + "<BR>" +						
										  "Changes : " + "<BR>" +
										  "<BR>" + 
										  "Above booking has been changed. Please DO NOT FORGET TO UPDATE STOWAGE PLAN ACCORDINGLY.";						//=========================================================================================
	            		ComBkgGroupMailset(sheetObjects[0], formObj, subject, closeBkgMsg);
			    	} else {
			    		if(splitFlg=="N"){
			    			ComShowCodeMessage("BKG02052");
			    		}			
			    	}
			    	//0079, 0614, 0445에서 open시 split성공 후 창 닫음
					if(ComGetObjValue(formObj.popUpFlag)=="Y"){
						
						//SPLIET CANDIDATE 화면(0445)에서 저장후 FLAG 처리 
						if (ComGetObjValue(document.form.openerPgmNo) == "ESM_BKG_0445" ){
							var opener = window.dialogArguments;
							opener.setCallBackReslult0999(true);
						}	
						window.close();
					}
				}
			break;

			case COMMAND02:      //PC  
				formObj.f_cmd.value = COMMAND02;
				setQtyCntrVar(formObj); 
				var row = sheetObj.SelectRow;
				if(sheetObj.CellValue(row,prefix2+"pc")==-1){
					return;
        		}		
				
				var sParam = ComGetSaveString(sheetObj);
				sheetObj.CellValue(row, prefix2+"pctl_no")="";
				sheetObj.CellValue(row, prefix2+"rtn_route")="";
				if (sParam == "") return;  
				sParam += "&" + FormQueryString(formObj);

				sheetObj.WaitImageVisible = false;	
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0099GS.do", sParam);	
				ComOpenWait(false);
				
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				if(State!="S"){
					sheetObj.loadSaveXml(sXml);
					return;
				}
				var arrXml = sXml.split("|$$|");
				var isPctlNoPop = "N";

				isPctlNoPop = ComGetEtcData(arrXml[0], "IsPctlNoPop")
				
				if(isPctlNoPop == "Y"){            	
					sheetObjects[5].LoadSearchXml(arrXml[0]);
					// ESD_PRD_0080 화면 호출
					if(sheetObj.CellValue(row,prefix2+"bkg_no")==ComGetObjValue(formObj.bkg_no)){
						var url = "ESD_PRD_0080.do?f_cmd=3&pc_mode=R";	
					} else {
						var url = "ESD_PRD_0080.do?f_cmd=3&pc_mode=B";
					}
					url = url + "&bkg_no="+	sheetObj.CellValue(row,prefix2+"bkg_no");
					url = url + "&por="   +	ComGetEtcData(arrXml[0], "por");
					url = url + "&por_n=" +	ComGetEtcData(arrXml[0], "por_n");
					url = url + "&pol="   + ComGetEtcData(arrXml[0], "pol");
					url = url + "&pol_n=" + ComGetEtcData(arrXml[0], "pol_n");
					url = url + "&pod="   + ComGetEtcData(arrXml[0], "pod");
					url = url + "&pod_n=" + ComGetEtcData(arrXml[0], "pod_n");
					url = url + "&del="   + ComGetEtcData(arrXml[0], "del");
					url = url + "&del_n=" + ComGetEtcData(arrXml[0], "del_n");
					url = url + "&t_vvd=" + ComGetEtcData(arrXml[0], "t_vvd");
					for(i = 1 ; i <= 4; i++){
						if(ComGetEtcData(arrXml[0], "pol"+i).length == 5){
							url = url + "&pol" + i + "="   + ComGetEtcData(arrXml[0], "pol"+i);
							url = url + "&pol" + i + "_n=" + ComGetEtcData(arrXml[0], "pol"+i+"_n");
							url = url + "&pod" + i + "="   + ComGetEtcData(arrXml[0], "pod"+i);
							url = url + "&pod" + i + "_n=" + ComGetEtcData(arrXml[0], "pod"+i+"_n");
						}
					}
					url = url + "&rcv_t=" + ComGetEtcData(arrXml[0], "rcv_t");
					url = url + "&del_t=" + ComGetEtcData(arrXml[0], "del_t");
					url = url + "&shpr="  + ComGetEtcData(arrXml[0], "shpr");
					url = url + "&cngn="  + ComGetEtcData(arrXml[0], "cngn");
					url = url + "&com="     + ComGetEtcData(arrXml[0], "com");
					url = url + "&rep_com=" + ComGetEtcData(arrXml[0], "rep_com");
					url = url + "&wgt="     + ComGetEtcData(arrXml[0], "wgt");
					url = url + "&wgt_un="  + ComGetEtcData(arrXml[0], "wgt_un");
					url = url + "&bkg_ofc=" + ComGetEtcData(arrXml[0], "bkg_ofc");
					url = url + "&org_sal_ofc=" + ComGetEtcData(arrXml[0], "org_sal_ofc"); 
	
					url = url + "&m_pu=" + ComGetEtcData(arrXml[0], "m_pu");
					url = url + "&f_rt=" + ComGetEtcData(arrXml[0], "f_rt");
					
					url = url + "&sc="  + ComGetEtcData(arrXml[0], "sc");
					url = url + "&rfa=" + ComGetEtcData(arrXml[0], "rfa");
					
					url = url + "&cgo_tp=" + ComGetEtcData(arrXml[0], "cgo_tp");
					url = url + "&dg_f=" + ComGetEtcData(arrXml[0], "dg_f");
					url = url + "&rf_f=" + ComGetEtcData(arrXml[0], "rf_f");
					url = url + "&ak_f=" + ComGetEtcData(arrXml[0], "ak_f");
					url = url + "&bb_f=" + ComGetEtcData(arrXml[0], "bb_f");
					url = url + "&rd_f=" + ComGetEtcData(arrXml[0], "rd_f");
					url = url + "&hg_f=" + ComGetEtcData(arrXml[0], "hg_f");
					url = url + "&soc_f="+ ComGetEtcData(arrXml[0], "soc_f");
					url = url + "&pm_f=" + ComGetEtcData(arrXml[0], "pm_f");
					
					for(var iRow=1;iRow<sheetObjects[5].Rows;iRow++){
						url = url + "&c_tpsz="+sheetObjects[5].CellValue(iRow,"c_tpsz");
						url = url + "&c_qty=" +sheetObjects[5].CellValue(iRow,"c_qty");
					}
//					alert(url);
	    			ComOpenPopup(url, 1024, 730, "callBackEsdPrd0080","1,0,1,1,1", true);
	    			
	    			if(sheetObj.CellValue(row, prefix2+"pctl_no").length>=20){
	    				doActionIBSheet(sheetObjects[1],formObj,COMMAND03);
	    			}
	            } else {
					sheetObj.CellValue2(sheetObj.SelectRow,prefix2+"pc")=1;
					sheetObj.CellValue2(sheetObj.SelectRow,prefix2+"pctl_no")  =ComGetEtcData(arrXml[0],"pctl_no"); 
					sheetObj.CellValue2(sheetObj.SelectRow,prefix2+"rtn_route")=ComGetEtcData(arrXml[0],"rtn_route"); 
					ComShowCodeMessage("BKG02046");
	    		} 
	        	break;
			case COMMAND03:      //SPLIT NEW T/S ROUTE 조회 
				formObj.f_cmd.value = COMMAND03;
			 	sheetObj.WaitImageVisible = false;

				var sParam = ComGetSaveString(sheetObj);
				if (sParam == "") return;  
				sParam += "&" + FormQueryString(formObj);
						
//				ComOpenWait(true);
			 	var sXml = sheetObj.GetSaveXml("ESM_BKG_0099GS.do", sParam);
//				ComOpenWait(false);
				
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
//				sheetObj.LoadSaveXml(sXml);
				if(State == "S"){
					sheetObj.CellValue2(sheetObj.SelectRow,prefix2+"pc")=1;
					sheetObj.CellValue2(sheetObj.SelectRow,prefix2+"pctl_no")  =ComGetEtcData(sXml,"pctl_no"); 
					sheetObj.CellValue2(sheetObj.SelectRow,prefix2+"rtn_route")=ComGetEtcData(sXml,"rtn_route"); 
				}			  
				break;			
				
			case SEARCH01:      
				formObj.f_cmd.value = SEARCH01; 
				setQtyCntrVar(formObj);
				 
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return;  
				sParam += "&" + FormQueryString(formObj);
				sheetObj.WaitImageVisible=false;
	    		ComOpenWait(true);
				var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0099GS.do", sParam);
				
				ComOpenWait(false);
				
				formObj.bkg_cbf_flg.value = ComGetEtcData(sXml,"cbf_flag");
				break;
				
			case COMMAND05:        //저장			
		        formObj.f_cmd.value = COMMAND05;
 
			 	for(i = 1; i<sheetObjects[1].Rows;i++){
			 		if (ComGetObjValue(formObj.splitreason).toUpperCase()=="C"){
			 			if(sheetObjects[1].CellValue(i, prefix2+"bkg_no").substring(10)=="90"){
			 				ComShowCodeMessage("BKG00884");
			 				return;
			 			}
			 		} else {
			 			if(sheetObjects[1].CellValue(i, prefix2+"bkg_no").substring(10)=="100"){
			 				ComShowCodeMessage("BKG00884");
			 				return;		 	
			 			}
			 		}
			 	}
				setQtyCntrVar(formObj);
//				 return;// jsy 나중 삭제
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return;  
				sParam += "&" + FormQueryString(formObj);
				sheetObj.WaitImageVisible=false;
				var currState = ""; 
				
				for(i = 2; i<sheetObjects[1].Rows;i++){
					ComSetObjValue(formObj.txtProgress, "" + i + "/" + (sheetObjects[1].Rows - 1));
					currSplitIdx = i;
					currSplitBkg = sheetObjects[1].CellValue(i, prefix2+"bkg_no");
	        		ComOpenWait(true);
	        		
//	        		alert("currSplitBkg:"+currSplitBkg);
	        		
					var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0099GS.do", sParam + "&currSplitBkg="+currSplitBkg);
					ComOpenWait(false);
					
					currState = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
					if(currState != "S"){
						ComShowCodeMessage("BKG00110", "SPLIT");
						break;
					}
				}
				
				sheetObjects[0].LoadSaveXml(sXml);
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				var splitFlg = ComGetEtcData(sXml,"split_flag");
				if(State == "S"){	     
					ComBtnDisable("btn_save");
			    	if(formObj.bkg_close_flg.value == "Y" && formObj.vvd_change_flg.value == "Y"){
						//bkg close mail open
						//=========================================================================================
						var subject = "BKG Change Notice";
						var closeBkgMsg = "BKG No : " + formObj.bkg_no.value + "<BR>" +						
										  "Current VVD : " + "<BR>" +						
										  "Current Route : " + "<BR>" +						
										  "Current CNTR No : " + "<BR>" +						
										  "Changes : " + "<BR>" +
										  "<BR>" + 
										  "Above booking has been changed. Please DO NOT FORGET TO UPDATE STOWAGE PLAN ACCORDINGLY.";						//=========================================================================================
	            		ComBkgGroupMailset(sheetObjects[0], formObj, subject, closeBkgMsg);
			    	} else {
			    		if(splitFlg=="N"){
			    			ComShowCodeMessage("BKG02052");
			    		}			
			    	}
			    	//0079, 0614, 0445에서 open시 split성공 후 창 닫음
					if(ComGetObjValue(formObj.popUpFlag)=="Y"){
						
						//SPLIET CANDIDATE 화면(0445)에서 저장후 FLAG 처리 
						if (ComGetObjValue(document.form.openerPgmNo) == "ESM_BKG_0445" ){
							var opener = window.dialogArguments;
							opener.setCallBackReslult0999(true);
						}	
						window.close();
					}
				}
			break;
        }
    }
	
	/*
	* Qty,Cntr SplitNo 변수 처리
	*/
	function setQtyCntrVar(formObj){
		var arr="";
		var strNo="";
		var ichk=0;
		var tmpbkgno="";
		var splitNo=ComParseInt(formObj.splitcount);
		
		//EQ subst tp,qty 처리
		var eq_sub_cntr_tp = "";
		var eq_sub_cntr_qty = 0;
		var arr_eq_sub_cntr_qty = 0;
		var rd_cgo_flg = "N";
		var sheet2Row = 1;
		for(var iRow=1;iRow<sheetObjects[2].Rows;iRow++){
			for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
				strNo = sheetObjects[2].ColSaveName(iCol).split("_");
//				arr+=sheetObjects[2].CellValue(iRow,prefix3+"cntr_tpsz_cd")+":"+sheetObjects[2].CellValue(iRow,iCol)+":"+strNo[1]+"~";
				
				//EQ subst tp,qty 처리
				eq_sub_cntr_tp = sheetObjects[2].CellValue(iRow,prefix3+"eq_subst_cntr_tpsz_cd");
				eq_sub_cntr_qty = sheetObjects[2].CellValue(iRow,prefix3+"eq_subst_cgo_qty");
				//split 된 qty 의 작은 qty를 선택 ( eq_qty < split_qty)
//				alert(eq_sub_cntr_qty +'<'+sheetObjects[2].CellValue(iRow,iCol));
				if(eq_sub_cntr_qty != null && eq_sub_cntr_qty > 0) {
					if( eq_sub_cntr_qty < sheetObjects[2].CellValue(iRow,iCol) ) {
						arr_eq_sub_cntr_qty = eq_sub_cntr_qty;
					} else {
						arr_eq_sub_cntr_qty = sheetObjects[2].CellValue(iRow,iCol);
					}
				} 
				//qty가 0이면 eq_sub_cntr_tp 처리 안함.
				if(arr_eq_sub_cntr_qty == 0|| arr_eq_sub_cntr_qty == '0') {
//					alert('111:'+arr_eq_sub_cntr_qty);
					eq_sub_cntr_tp="";
				} 
//				else {
//					alert('222:'+arr_eq_sub_cntr_qty);
//				}
//				if(eq_sub_cntr_tp!='') alert(1);
//				if(arr_eq_sub_cntr_qty > 0 ) alert(2);
//				if(eq_sub_cntr_tp.length >1 && eq_sub_cntr_tp.substring(0,1)=='D' ) alert(3);
//				if(sheetObjects[2].CellValue(iRow,prefix3+"cntr_tpsz_cd").substring(0,1)=='R' ) alert(4);
				
				if(eq_sub_cntr_tp!='' && arr_eq_sub_cntr_qty > 0 && eq_sub_cntr_tp.length >1 && eq_sub_cntr_tp.substring(0,1)=='D' && sheetObjects[2].CellValue(iRow,prefix3+"cntr_tpsz_cd").substring(0,1)=='R' ) {
					rd_cgo_flg = "Y";
				} else {
					rd_cgo_flg = "N";
					
				}
//				alert('rd_cgo_flg:'+rd_cgo_flg + 'row:'+sheet2Row);
				if( rd_cgo_flg == "Y") {
					sheetObjects[1].CellValue2(sheet2Row ,prefix2+"rd_cgo_flg" ) =  rd_cgo_flg;
				}
				sheet2Row++;
				arr+=sheetObjects[2].CellValue(iRow,prefix3+"cntr_tpsz_cd")+":"+sheetObjects[2].CellValue(iRow,iCol)+":"+strNo[1]
				     +":"+eq_sub_cntr_tp+":"+ arr_eq_sub_cntr_qty+":"+ rd_cgo_flg+"~";
			}
			sheet2Row = 1;
		}
//		alert(arr); //jsy
		ComSetObjValue(formObj.qtySplitNo,arr);
		arr="";
        var dgArr="";
		var rfArr="";
		var akArr="";
		var ifindRow=-1;
		if (sheetObjects[3].Rows==1){
			ComSetObjValue(formObj.cntrExists,"N");
		}else{
			ComSetObjValue(formObj.cntrExists,"Y");
		}
		 
		for(var iRow=1;iRow<sheetObjects[3].Rows;iRow++){
			ichk=0;
			for(var iCol=ComCountHeadTitle(strSheetTitle4)-splitNo;iCol<ComCountHeadTitle(strSheetTitle4);iCol++){
				if (ichk==0){
					var strTmp = strSheetTitle4.split("|");
					strNo=["",strTmp[iCol]];
				}else{
					strNo = sheetObjects[3].ColSaveName(iCol).split("_");
				}
				ichk++;
				/*if(ichk==0){		
					tmpbkgno=ComGetObjValue(formObj.bkg_no);
					ichk++;
				 }else{
                    //tmpbkgno=ComGetObjValue(formObj.bkg_no).substring(0,10)+strNo[1];
                    
				}*/
				
				tmpbkgno=sheetObjects[1].CellValue(ichk,prefix2+"bkg_no");
				 
				 ifindRow=sheetObjects[4].FindText(prefix5+"cntr_no", sheetObjects[3].CellValue(iRow,prefix4+"cntr_no")); 
				 
				 if(sheetObjects[3].CellValue(iRow,iCol)==1){
					arr+=sheetObjects[3].CellValue(iRow,prefix4+"cntr_no")+":"+strNo[1]+":"+tmpbkgno+":"+sheetObjects[3].CellValue(iRow,prefix4+"adv_shtg_cd")+"~";
					if (ifindRow>-1){
						if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="DG"){
							dgArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
//							dgArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all:"+strNo[1]+":"+tmpbkgno+"~";
						}else if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="RF"){
							rfArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
//							rfArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all:"+strNo[1]+":"+tmpbkgno+"~";
						}else if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="AK"){
							akArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
//							akArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all:"+strNo[1]+":"+tmpbkgno+"~";
						}
					}
				 }else {
				     arr+=sheetObjects[3].CellValue(iRow,prefix4+"cntr_no")+"::"+tmpbkgno+":"+sheetObjects[3].CellValue(iRow,prefix4+"adv_shtg_cd")+"~";
					 if (ifindRow>-1){
						if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="DG"){
							dgArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+"::"+tmpbkgno+"~";
//							dgArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all::"+tmpbkgno+"~";
						}else if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="RF"){
							rfArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+"::"+tmpbkgno+"~";
//							rfArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all::"+tmpbkgno+"~";
						}else if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="AK"){
							akArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+"::"+tmpbkgno+"~";
//							akArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all::"+tmpbkgno+"~";
						}
					}
				 }
			}
		}
		
		 
		//if (formObj.dgCntrSplitNo.value.length<1){
		if(dgSelectFlg=="N"){ // dg를 pop-up을 이용하여 assign한적이 없는 경우
			ComSetObjValue(document.form.dgCntrSplitNo,dgArr);
		}else{
			ComSetObjValue(document.form.cntrPopExists,"Y");
		}
		//}
	
		//if (formObj.rfCntrSplitNo.value.length<1){
		if(rfSelectFlg=="N"){ // rf를 pop-up을 이용하여 assign한적이 없는 경우
			ComSetObjValue(document.form.rfCntrSplitNo,rfArr);
    	}else{
			ComSetObjValue(document.form.cntrPopExists,"Y");
		}
		//}
	
		//if (formObj.akCntrSplitNo.value.length<1){
		if(akSelectFlg=="N"){ // ak를 pop-up을 이용하여 assign한적이 없는 경우
			ComSetObjValue(document.form.akCntrSplitNo,akArr);
		}else{
			ComSetObjValue(document.form.cntrPopExists,"Y");
		}
		//}
		 
		//ComDebug("dg="+document.form.dgCntrSplitNo.value); 
		ComSetObjValue(formObj.cntrSplitNo,arr);
	}
	
	/*
	* 변수 초기화
	*/
	function initData(){
		var formObj = document.form;
		ComSetObjValue(formObj.splitcount,"");
		ComSetObjValue(formObj.cntrSplitNo,"");
		ComSetObjValue(formObj.dgCntrSplitNo,"");
		ComSetObjValue(formObj.rfCntrSplitNo,"");
		ComSetObjValue(formObj.akCntrSplitNo,"");
		ComSetObjValue(formObj.bbCntrSplitNo,"");
		ComSetObjValue(formObj.tro_flg,"");
		ComSetObjValue(formObj.pctl_no,"");
		ComSetObjValue(formObj.splitdel,"");
		ComSetObjValue(formObj.bdr_flag,"");
		ComSetObjValue(formObj.dg,"");
		ComSetObjValue(formObj.rf,"");
		ComSetObjValue(formObj.ak,"");
		ComSetObjValue(formObj.bb,"");
        ComSetObjValue(formObj.pcIdx,"0");
		btnSpecialCargo(formObj);

		formObj.stwg_cd.checked=false;
		formObj.rail_blk_cd.checked=false;
		formObj.fd_grd_flg.checked=false;
		formObj.hngr_flg.checked=false;
		formObj.prct_flg.checked=false;
		formObj.stop_off_loc_cd.checked=false;
		formObj.spcl_hide_flg.checked=false;
		formObj.fumg_loc_cd.checked=false;
		formObj.spcl_hide_lnr_flg.checked=false;
		formObj.remark.checked=false;
		formObj.veh_cmdt_flg.checked=false;

		formObj.stwg_cd.disabled=false;
		formObj.rail_blk_cd.disabled=false;
		formObj.fd_grd_flg.disabled=false;
		formObj.hngr_flg.disabled=false;
		formObj.prct_flg.disabled=false;
		formObj.stop_off_loc_cd.disabled=false;
		formObj.spcl_hide_flg.disabled=false;
		formObj.fumg_loc_cd.disabled=false;
		formObj.spcl_hide_lnr_flg.disabled=false;
		formObj.remark.disabled=false;   
		formObj.veh_cmdt_flg.disabled=false;   
	}
	
	/*
	* CheckBox 값 처리
	*/
	function setCheckValue(obj,chk){
		if (chk.toUpperCase()=="Y"){
			obj.checked=chk;
		}else{ 
			obj.disabled=true;
		}
	}
	
	/*
	* Data를 Form에 대입
	*/
	function setFormData(formObj,sheetObj){
		ComSetObjValue(formObj.old_bkg_no,	sheetObj.EtcData("bkg_no"));
		ComSetObjValue(formObj.bl_no, 		sheetObj.EtcData("bl_no"));
		ComSetObjValue(formObj.tvvd,  		sheetObj.EtcData("tvvd"));
		ComSetObjValue(formObj.por_cd,		sheetObj.EtcData("por_cd"));
		ComSetObjValue(formObj.pol_cd,		sheetObj.EtcData("pol_cd"));
		ComSetObjValue(formObj.pod_cd,		sheetObj.EtcData("pod_cd"));
		ComSetObjValue(formObj.del_cd,		sheetObj.EtcData("del_cd"));
		ComSetObjValue(formObj.dg,			sheetObj.EtcData("dg"));
		ComSetObjValue(formObj.rf,			sheetObj.EtcData("rf"));
		ComSetObjValue(formObj.ak,			sheetObj.EtcData("ak"));
		ComSetObjValue(formObj.bb,			sheetObj.EtcData("bb"));
		ComSetObjValue(formObj.lt_flg,      sheetObj.EtcData("lt_flg"));
		
		setCheckValue(formObj.stwg_cd,			sheetObj.EtcData("stwg_cd"));
		setCheckValue(formObj.rail_blk_cd,		sheetObj.EtcData("rail_blk_cd"));
		setCheckValue(formObj.fd_grd_flg,		sheetObj.EtcData("fd_grd_flg"));
		setCheckValue(formObj.hngr_flg,			sheetObj.EtcData("hngr_flg"));
		setCheckValue(formObj.prct_flg,			sheetObj.EtcData("prct_flg"));
		setCheckValue(formObj.stop_off_loc_cd,	sheetObj.EtcData("stop_off_loc_cd"));
		setCheckValue(formObj.spcl_hide_flg,	sheetObj.EtcData("spcl_hide_flg")); 
		setCheckValue(formObj.fumg_loc_cd,		sheetObj.EtcData("fumg_loc_cd"));
		setCheckValue(formObj.spcl_hide_lnr_flg,sheetObj.EtcData("spcl_hide_lnr_flg")); 
		setCheckValue(formObj.remark,			sheetObj.EtcData("remark"));
		setCheckValue(formObj.veh_cmdt_flg,		sheetObj.EtcData("veh_cmdt_flg"));
		
		if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
			ComSetObjValue(formObj.lastSplitNo,sheetObj.EtcData("memoSplitNo"));
		}else{
			ComSetObjValue(formObj.lastSplitNo,sheetObj.EtcData("custSplitNo"));
		}
		 
		ComSetObjValue(formObj.custSplitNo,	sheetObj.EtcData("custSplitNo"));
		ComSetObjValue(formObj.memosplitno,	sheetObj.EtcData("memoSplitNo"));
		ComSetObjValue(formObj.bkgsplitno,	sheetObj.EtcData("bkgsplitno"));
		ComSetObjValue(formObj.bdr_flag,	sheetObj.EtcData("bdr_flag"));
		ComSetObjValue(formObj.pctl_no,		sheetObj.EtcData("pctl_no"));
		ComSetObjValue(formObj.tro_flg,		sheetObj.EtcData("tro_flg"));
		ComSetObjValue(formObj.bkgStsCd,	sheetObj.EtcData("bkgStsCd"));
		
		ComSetObjValue(formObj.bkg_close_flg,	sheetObj.EtcData("bkg_close_flg"));
		ComSetObjValue(formObj.obl_iss_flg,		sheetObj.EtcData("obl_iss_flg"));

		document.getElementById("splitFlag").style.display="none";
		document.getElementById("bdrFlag").style.display="none";

		if (ComGetObjValue(formObj.bkgStsCd).toUpperCase()=="X"){
			document.getElementById("splitFlag").innerHTML ="Cancel"; 
			document.getElementById("splitFlag").style.display="block";
			document.getElementById("splitFlag").style.color="red"
		}else{
			if (sheetObj.EtcData("splitFlg").toUpperCase()=="Y"){
				document.getElementById("splitFlag").innerHTML ="Split"; 
				document.getElementById("splitFlag").style.display="block";
				document.getElementById("splitFlag").style.color="blue"
			}
			if (sheetObj.EtcData("bdr_flag").toUpperCase()=="Y"){
				document.getElementById("bdrFlag").innerHTML ="BDRed"; 
				document.getElementById("bdrFlag").style.display="block";
				document.getElementById("bdrFlag").style.color="red"
			}
		}
	}
	
	/*
	* Special Cargo btn 활성여부
	*/
	function btnSpecialCargo(formObj){
		if (ComGetObjValue(formObj.dg).toUpperCase()=="Y"){
			ComBtnEnable("btn_dg");
		}else{
			ComBtnDisable("btn_dg");
		}

		if (ComGetObjValue(formObj.rf).toUpperCase()=="Y"){
			ComBtnEnable("btn_rf");
		}else{
			ComBtnDisable("btn_rf");
		}

		if (ComGetObjValue(formObj.ak).toUpperCase()=="Y"){
			ComBtnEnable("btn_ak");
		}else{
			ComBtnDisable("btn_ak");
		}

		if (ComGetObjValue(formObj.bb).toUpperCase()=="Y"){
			ComBtnEnable("btn_bb");
		}else{
			ComBtnDisable("btn_bb");
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

		 switch(sAction) {
			case COMMAND01:  //splitcount 체크
				if (sheetObj.Rows==1){
					//return false;
				}
				if (ComNullToZero(formObj.splitcount)==0){
					ComShowCodeMessage("BKG00647");
					return false;
				}
				if(ComGetObjValue(formObj.bkgStsCd).toUpperCase() == "X"){
					ComShowCodeMessage("BKG00005");
					return false;
				}
				if(ComGetObjValue(formObj.split_rsn_cd).toUpperCase() == "Y"){
					ComShowCodeMessage("BKG00646");
					return false;
				}
				if(ComGetObjValue(formObj.bkg_cgo_tp_cd).toUpperCase() == "Y"){
					ComShowCodeMessage("BKG00649");
					return false;
				}	
			break;

			case IBSAVE:	//저장시 체크
				if(ComIsNull(formObj.bkg_no)){
					ComShowCodeMessage("BKG00273");
					return false;
				}
				if (ComIsNull(formObj.bl_no)){
					ComShowCodeMessage("BKG00273");
					return false;
				}
				if (ComChkLen(formObj.tvvd,9) !=2){
					ComShowCodeMessage("BKG00273");
					return false;
				}				 

				if(formObj.obl_iss_flg.value == "Y"){
					if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
						ComShowCodeMessage("BKG02055");
						return false;
					}
				}
				
				if(ComGetObjValue(formObj.hngr_flg) == "on")
					ComShowCodeMessage("BKG02114");
				
				for(var iRow=1;iRow<sheetObjects[1].Rows;iRow++){
					if (sheetObjects[0].CellValue(1,prefix1+"tvvd") != sheetObjects[1].CellValue(iRow,prefix2+"tvvd") 
						&& ComIsEmpty(sheetObjects[1].CellValue(iRow,prefix2+"pctl_no"))){
						ComShowCodeMessage("BKG00658");
						return false;   
						break;
					}
				 
					if (ComChkLen(sheetObjects[1].CellValue(iRow,prefix2+"tvvd"),9) !=2){
						ComShowCodeMessage("BKG00658");
						return false;
						break;
					}
				}
				 
				var splitNo=ComParseInt(formObj.splitcount);
				var icnt=0;
				var icntrSplit=0;
				for(var iRow=1;iRow<sheetObjects[3].Rows;iRow++){
					var icnt=0;
					for(var iCol=ComCountHeadTitle(strSheetTitle4)-splitNo;iCol<ComCountHeadTitle(strSheetTitle4);iCol++){
						if (sheetObjects[3].CellValue(iRow,iCol)=="0"){
						//if (sheetObjects[3].CheckedRows(iCol)==(sheetObjects[3].Rows-1)){
							icnt++;
						//	break;
						}
						
						/* cntrSplit Check
                        if (sheetObjects[3].CellValue(iRow,iCol+1)=="0"){
							icntrSplit++;
						}
						*/
					}
					if (icnt==splitNo){
						ComShowCodeMessage("BKG00659");
						return false;
						break;
					}
				}
				/* cntrSplit Check
				if (icntrSplit==splitNo){
					ComShowCodeMessage("BKG00659");
					return false;
				}
				 */

				// 가로 합 validation
				var fQtySum=0;
				for(var iRow=1;iRow<sheetObjects[2].Rows;iRow++){
					fQtySum=0;
					for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
						fQtySum +=ComTrunc(sheetObjects[2].CellValue(iRow,iCol),2);
						fQtySum = parseFloat(fQtySum.toFixed(2));
					}
					if (ComTrunc(sheetObjects[2].CellValue(iRow,prefix3+"op_cntr_qty"),2)-ComTrunc(fQtySum,2)>=0.01){
						ComShowCodeMessage("BKG00662");
						return false;
						break;
					}
				}				
				
				//세로 합 validation
				for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
					fQtySum=0;
					for(var iRow=1;iRow<sheetObjects[2].Rows;iRow++){
						fQtySum +=ComTrunc(sheetObjects[2].CellValue(iRow,iCol),2);
						fQtySum = parseFloat(fQtySum.toFixed(2));
					}

					if(0.0 == fQtySum || 0 == fQtySum){
						ComShowCodeMessage("BKG00013");
						return false;
					}
				}
				var fWgtSum=0;
				var fPkgSum=0;
				var fMeaSum=0;
				for(var iRow=1;iRow<sheetObjects[1].Rows;iRow++){
					fWgtSum+= parseFloat(parseFloat(sheetObjects[1].CellValue(iRow,prefix2+"act_wgt")).toFixed(3));
					fWgtSum = parseFloat(fWgtSum.toFixed(3));
					fPkgSum+= ComParseInt(sheetObjects[1].CellValue(iRow,prefix2+"pck_qty"));
					fMeaSum+= parseFloat(parseFloat(sheetObjects[1].CellValue(iRow,prefix2+"meas_qty")).toFixed(3));
					fMeaSum = parseFloat(fMeaSum.toFixed(3));
				}

				if (ComTrunc(sheetObj.CellValue(1,prefix1+"act_wgt"),3)-ComTrunc(fWgtSum,3)!=0){
					ComShowCodeMessage("BKG00663");
					return false;
				}
				if (ComParseInt(sheetObj.CellValue(1,prefix1+"pck_qty")-fPkgSum)!=0){
					ComShowCodeMessage("BKG00664");
					return false;
				}
				if (ComTrunc(sheetObj.CellValue(1,prefix1+"meas_qty"),3)-ComTrunc(fMeaSum,3)!=0){
					ComShowCodeMessage("BKG00665");
					return false;
				}
				if (!sheetObj.ColHidden(prefix1+"adv_shtg_cd")){
					//if (ComIsNull(sheetObj.CellValue(1,prefix1+"adv_shtg_cd"))){
					//	ComShowCodeMessage("BKG00666");
					//	return false;
					//}

					for(var iRow=1;iRow<sheetObjects[1].Rows;iRow++){
						if (ComIsNull(sheetObjects[1].CellValue(iRow,prefix2+"adv_shtg_cd"))){
							ComShowCodeMessage("BKG00666");
							return false;
						}
					}
					
					for(var iRow=1;iRow<sheetObjects[3].Rows;iRow++){
						if (ComIsNull(sheetObjects[3].CellValue(iRow,prefix4+"adv_shtg_cd"))){
							ComShowCodeMessage("BKG00666");
							return false;
						}
					}						 
				}					
				
				if (ComGetObjValue(formObj.old_bkg_no)!=ComGetObjValue(formObj.bkg_no)){
					ComShowCodeMessage("BKG00048");
					return false;
				}
				/*
				if(ComIsEmpty(sheetObjects[3].CellValue(1,prefix4+"cntr_no"))
					&& ComGetObjValue(formObj.tro_flg).toUpperCase()=="Y"){
					var param = "?bkg_no="+ComGetObjValue(formObj.bkg_no)+"&splitReason="+ComGetObjValue(formObj.splitreason);
						param +="&splitCntrSplitNo="+ComGetObjValue(formObj.dgCntrSplitNo)+"&lastSplitNo="+ComGetObjValue(formObj.lastSplitNo);
						param +="&validateSplitNo="+ComGetObjValue(formObj.validateSplitNo);
						param +="&splitCnt="+(ComParseInt(formObj.splitcount)-1)+"&orgSplit="+orgSplit+"&bkgsplitno="+ComGetObjValue(formObj.bkgsplitno);
					param+="&pgmNo=ESM_BKG_1025";
					ComOpenPopup("/hanjin/ESM_BKG_1025.do"+param, 500, 470, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
				}
				*/
			break;

		}
        return true;
    }
	
	
	/*
	* Booking Split에 대한 체크
	*/
	function SheetSplitCheck(sheetObj,Row,Col,Value,sheetTitle){
		for (var i=0;i<ComCountHeadTitle(sheetTitle);i++ ){
			 if(typeof(sheetObj.CellValue(Row,i).length) =="undefined"){ 
				 if (sheetObj.ColSaveName(Col)==sheetObj.ColSaveName(i)){  
					  sheetObj.CellValue2(Row,sheetObj.ColSaveName(Col))=Value;
				 } 
			 }
		 }
	}
	

	/*
	* Cntr 체크 박스 반환
	*/
	function CntrCheck(sheetObj,prefix){
		var rtnArr="";
		for(var iRow=0;iRow<sheetObj.Rows;iRow++){
			for(var iCol=0;iCol<sheetObj.LastCol+1;iCol++){
				 if(typeof(sheetObj.CellValue(iRow,iCol).length) =="undefined"){ 
					 if(sheetObj.CellValue(iRow,iCol)==1){
						 var str = sheetObj.ColSaveName(iCol).split("_");
						rtnArr+=sheetObj.CellValue(iRow,prefix)+":"+iRow+":"+str[1]+"~";
					 }
				 }
			}
		}
		return rtnArr;
	}

	/*
	* Tro Split PopUp정보 처리
	*/
	function getSplitTro(rArray){
		var rtnArr="";
		var delflag="";
		var icnt=0;
		for(var i=0;i<rArray.length;i++){
			var arrKey = rArray[i].split(":");
			//ComDebug(arrKey[0]+"==="+arrKey[1]+"=="+arrKey[2]+"=="+arrKey[3]);
			if (!ComIsEmpty(arrKey[2]) && arrKey[3] == ComGetObjValue(document.form.bkg_no)){
				icnt++;
			} 
			 
			rtnArr+=arrKey[0]+":"+arrKey[1]+":"+arrKey[2]+":"+spcPopChk(arrKey[3])+"~";
		}
		//ComDebug(rtnArr);
		if(icnt==0) delflag="Y";
		ComSetObjValue(document.form.splitdel,delflag);
		ComSetObjValue(document.form.troSplitNo,rtnArr);
	}

	/*
	* POP Split 반환
	*/
    function getSplitCntr(arrData,flag) {
		var rtnArr="";
		for(var i=0;i<arrData.length;i++){
			var arrKey = arrData[i].split(":");
			//ComDebug(arrKey[0]+"==="+arrKey[1]+"=="+arrKey[2]+"=="+arrKey[3]);
			if (arrKey[3].length ==2 && ComGetObjValue(document.form.cntrPopExists)=="Y"){
				rtnArr+=arrKey[0]+":"+arrKey[1]+":"+arrKey[2]+":"+spcPopChk(arrKey[3])+"~";
			}else if (ComGetObjValue(document.form.cntrPopExists)=="Y"){ 
				rtnArr+=arrKey[0]+":"+arrKey[1]+":"+arrKey[2]+":"+arrKey[3]+"~";
			}else{
				rtnArr+=arrKey[0]+":"+arrKey[1]+":"+arrKey[2]+":"+spcPopChk(arrKey[3])+"~";
			}
		}
		 
		if (flag == "D"){
			dgSelectFlg="Y";
			ComSetObjValue(document.form.dgCntrSplitNo,rtnArr);
		}else if (flag == "R"){
			rfSelectFlg="Y";
			ComSetObjValue(document.form.rfCntrSplitNo,rtnArr);
		}else if (flag == "A"){
			akSelectFlg="Y";
			ComSetObjValue(document.form.akCntrSplitNo,rtnArr);
		}else if (flag == "B"){
			ComSetObjValue(document.form.bbCntrSplitNo,rtnArr);
		}
		//ComDebug(flag+"==getSplitCntr==>"+rtnArr);
    }
	
	/*
	* Pop Spc Cgo에 대한 split Bkgno 반환
	*/
	function spcPopChk(splitNo){
		var ret="";
		with(sheetObjects[1]){
			for(var iRow=1;iRow<Rows;iRow++){
				 
				if (CellValue(iRow,prefix2+"bkg_no")==CellValue(iRow,prefix2+"bkg_no").substring(0,10)+splitNo){
					ret= CellValue(iRow,prefix2+"bkg_no");
					break;
				}
				 
			}
		}
		return ret;
	}
	
	/*
	* Form, Grid 초기화
	*/
	function iniFormSheet(){
		orgSplit="";
		strSheetTitle3="|TS|Q'ty|eq tp|eq qty";
		strSheetTitle4="|CNTR|TS|ST|AS";
		strSheetTitle5="|CODE|CNTR_NO|DCGO_SEQ";
		for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1,asCodeList,asTextList,true);
            ComEndConfigSheet(sheetObjects[i]);
        }
		 
		sheetObjects[2].ExtendLastCol = false;
		sheetObjects[3].ExtendLastCol = false;
		ComBtnDisable("btn_dg");
		ComBtnDisable("btn_rf");
		ComBtnDisable("btn_ak");
		ComBtnDisable("btn_bb");		
	}


	/*
	*Booking split대한 그리드 Setting
	*/
	function loadInitSheet(orgSplit,flag){  
		for(var i=1;i<sheetObjects.length;i++){
			sheetObjects[i].Redraw = false;
			sheetObjects[i].RemoveAll();
			sheetObjects[i].Reset();
            
            ComConfigSheet(sheetObjects[i] );
			initSheet(sheetObjects[i],i+1,asCodeList,asTextList,flag);
            
			if (i==2){ //sheet3 head Col setting
				//if (ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
					SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)-1+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|TS|Q'ty|eq t|eq q|"+orgSplit),prefix3);
				//}else{
				//	SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|TS|Q'ty"),prefix3);
				//}
			}
			
			if (flag){
				if (i==3){ //sheet4 head Col setting
					//if (ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
						SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)-1+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|CNTR|TS|ST|AS|"+orgSplit),prefix4);
					//}else{
					//	SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|CNTR|TS|ST|AS"),prefix4);
					//}
				}
			} 
			
			ComEndConfigSheet(sheetObjects[i]);
			sheetObjects[i].Redraw = true;
			
        }
		
		sheetObjects[2].ExtendLastCol = false;
		sheetObjects[3].ExtendLastCol = false;

	}
	
	/*
	* Sheet 자료를 배열에 저장
	*/
	function SheetToArrary(sheetObj){
		var tmpSheet= new Array(sheetObj.Rows);
		for (var iRow=0;iRow<sheetObj.Rows;iRow++){
			tmpSheet[iRow] = new Array(sheetObj.LastCol+1);
		}
		 
		for(var iRow=0;iRow<sheetObj.Rows;iRow++){
			 for(var iCol=0;iCol<sheetObj.LastCol+1;iCol++){ 
				tmpSheet[iRow][iCol]= sheetObj.CellValue(iRow+1,iCol); 
			 }
		 }
		 return tmpSheet;
	}
	/*
	* 배열 자료를 Sheet에 저장
	*/
	function ArrayToSheet(sheetObj,arr){
		for(var iRow=0;iRow<arr.length-1;iRow++){
			sheetObj.DataInsert(-1); 
		}
		for(var iRow=0;iRow<arr.length-1;iRow++){
			 for(var iCol=0;iCol<arr[iRow].length;iCol++){
				sheetObj.CellValue2(iRow+1,iCol) =arr[iRow][iCol]
			 }
		 }
	}

    /*
	* sheet split 처리
	*/
	function sheet_splitSet(splitreason,lastno,splitcount){
		var formObj =document.form;
		if (orgSplit.length>1 && splitreason.toUpperCase()=="C"){
			if(ComGetObjValue(formObj.bkg_no).length==12){
				strSheetTitle3=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|TS|Q'ty|eq t|eq q|"+ComGetObjValue(formObj.bkg_no).substring(10,12));
			}else{
				strSheetTitle3=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|TS|Q'ty|eq t|eq q|"+orgSplit);
			}
			if (!ComIsEmpty(sheetObjects[3].CellValue(1,prefix4+"cntr_no"))){
				if(ComGetObjValue(formObj.bkg_no).length==12){
					strSheetTitle4=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|CNTR|TS|ST|AS|"+ComGetObjValue(formObj.bkg_no).substring(10,12));
				}else{
					strSheetTitle4=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|CNTR|TS|ST|AS|"+orgSplit);
				}
			}else{
				strSheetTitle4="|CNTR|TS|ST|AS";
			}
		}else{
			strSheetTitle3=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|TS|Q'ty|eq t|eq q|"+orgSplit);
			if (!ComIsEmpty(sheetObjects[3].CellValue(1,prefix4+"cntr_no"))){
				strSheetTitle4=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|CNTR|TS|ST|AS|"+orgSplit);
			}else{
				strSheetTitle4="|CNTR|TS|ST|AS";
			}
		}
         
		var tmpSheet3= SheetToArrary(sheetObjects[2]);
		var tmpSheet4= SheetToArrary(sheetObjects[3]); 
        var tmpSheet5= SheetToArrary(sheetObjects[4]); 
		if (!ComIsEmpty(sheetObjects[3].CellValue(1,prefix4+"cntr_no"))){
			loadInitSheet(orgSplit,true);
			ArrayToSheet(sheetObjects[3],tmpSheet4);
		}else{
			loadInitSheet(orgSplit,false);
		}
		 ArrayToSheet(sheetObjects[2],tmpSheet3);         
		 ArrayToSheet(sheetObjects[4],tmpSheet5);		 
	}
	
	/*
	* sheet image setting
	*/
	function sheet_imageSet(sheetObj,Col){
		sheetObj.ColHidden(prefix2+"pc")=false;
		for(var i=1;i<sheetObj.Rows;i++){
			sheetObj.CellValue(i,Col)=1;
		}
	}

	/*
	* Keypress 이벤트 처리
	*/
	function bkg0099_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat; 
	    switch(obj.dataformat){ 
	        case "num": 
	        	ComKeyOnlyNumber(event.srcElement);
	            break;	 
			 case "engup": 
				 ComKeyOnlyAlphabet('uppernum'); 
	            break; 
	    }
		var btnObj=null;
		switch(obj.name){  
			case "bkg_no": 
				if(ComIsEmpty(obj.value)) { return; }
				if(event.keyCode == 13 && obj.value.length > 10){

					btnObj = document.getElementById("btn_retrieve");
					if (btnObj) { btnObj.fireEvent("onclick"); }
				}
		}
	}

	/*
	* Click 이벤트 처리
	*/
	function bkg0099_click(){
		obj = event.srcElement;
		formObject= document.form;
	    if(obj.id == null) return; 
		if (obj.name!="btn_auto" && obj.name!="btn_manual" && obj.name !="splitreason") return;
		 switch(obj.id){ 
	        case "C": 
	        	 sheetObjects[0].ColHidden(prefix1+"adv_shtg_cd")=true;
			     sheetObjects[1].ColHidden(prefix2+"adv_shtg_cd")=true;
				 sheetObjects[3].ColHidden(prefix4+"adv_shtg_cd")=true;
				 ComSetObjValue(formObject.lastSplitNo,formObject.custSplitNo.value);
				 //sheetObjects[0].Enable = true;

				ComSetDisplay("btn_save", false);
				ComSetDisplay("btn_save2", true);
	            break;	 
			 case "M": 
				 sheetObjects[0].ColHidden(prefix1+"adv_shtg_cd")=false;
			     sheetObjects[1].ColHidden(prefix2+"adv_shtg_cd")=false;
				 sheetObjects[3].ColHidden(prefix4+"adv_shtg_cd")=false; 
				 ComSetObjValue(formObject.lastSplitNo,formObject.memosplitno.value);
				 //sheetObjects[0].Enable = false;

				ComSetDisplay("btn_save", true);
				ComSetDisplay("btn_save2", false);
				
	            break; 
	    } 
		
		//if (ComIsEmpty(formObject.splitcount) || sheetObjects[1].Rows==1) return;
		
		var lastSplit="";
		 
		if(ComGetObjValue(formObject.bkg_no).length==11 || ComGetObjValue(formObject.bkg_no).length==13){ //old bkg_no
			if(ComGetObjValue(formObject.splitreason).toUpperCase()=="M"){
				lastSplit="91";
				orgSplit="91";
			}else{
				lastSplit="00";
				orgSplit="00";
			}
		}else if(ComGetObjValue(formObject.bkg_no).length==12){  //new bkg_no
			if(ComGetObjValue(formObject.splitreason).toUpperCase()=="M"){
				lastSplit=ComGetObjValue(formObject.memosplitno);
				orgSplit=ComGetObjValue(formObject.memosplitno);
				 
			}else{
				lastSplit=ComGetObjValue(formObject.custSplitNo);
                orgSplit=ComGetObjValue(formObject.custSplitNo);
			}
		}
		if (ComIsEmpty(formObject.splitcount)) return; 
		sheet_splitSet(ComGetObjValue(formObject.splitreason),ComParseInt(lastSplit),ComParseInt(formObject.splitcount)-1);
		if(ComGetObjValue(formObject.splitreason).toUpperCase()=="M"){
			manualVolume(ComParseInt(formObject.splitcount),ComGetObjValue(formObject.splitreason),ComParseInt(lastSplit),ComParseInt(formObject.splitcount)-1);
		}else{
			autoVolume(ComParseInt(formObject.splitcount),ComGetObjValue(formObject.splitreason),ComParseInt(lastSplit),ComParseInt(formObject.splitcount)-1);
		}
		
		ComSetObjValue(formObject.cntrSplitNo,"");
		ComSetObjValue(formObject.dgCntrSplitNo,"");
		ComSetObjValue(formObject.rfCntrSplitNo,"");
		ComSetObjValue(formObject.akCntrSplitNo,"");
		ComSetObjValue(formObject.bbCntrSplitNo,"");
		 
        for(var iRow=1;iRow<sheetObjects[3].Rows;iRow++){
			for(var iCol=ComCountHeadTitle(strSheetTitle4)-ComParseInt(formObject.splitcount);iCol<ComCountHeadTitle(strSheetTitle4);iCol++){
				sheetObjects[3].CellValue2(iRow,iCol)="0"; 
			}
		}
         
		/*initData();
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		
		for(var iCol=3;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
			 sheetObjects[2].ColHidden(iCol)=true;
		}
		for(var iCol=5;iCol<ComCountHeadTitle(strSheetTitle4);iCol++){
			 sheetObjects[3].ColHidden(iCol)=true;
		}*/
		
		setSplitValFromOpener0445();
		sheet_imageSetEDI(sheetObjects[1],prefix2, 2);
			
	}
	 
	
	/*
	* 자동으로 Volume분할
	*/
	function autoVolume(splitNo,splitreason,lastno,splitcount){
		var colTile ="";
		var fWgt =ComTrunc(ComTrunc(sheetObjects[0].CellValue(1,prefix1+"act_wgt"),3)/splitNo,3);
		var fWgtLast=0;
		//var fPkg =ComTrunc(ComTrunc(sheetObjects[0].CellValue(1,prefix1+"pck_qty"),2)/splitNo,2);
		var fPkg =ComParseInt(sheetObjects[0].CellValue(1,prefix1+"pck_qty")/splitNo);
		var fPkgLast =0;
		var fMea =ComTrunc(ComTrunc(sheetObjects[0].CellValue(1,prefix1+"meas_qty"),3)/splitNo,3);
		var fMeaLast =0;
		var newBkgNo = ComGetObjValue(document.form.bkgsplitno);
		 
		if (newBkgNo.length<1){
			newBkgNo =sheetObjects[0].CellValue(1,prefix1+"bkg_no");
		}else{
			newBkgNo =ComGetObjValue(document.form.bkgsplitno);
		}
		 
		var newSplitBkgNo=getSplitBkgNo(splitreason,lastno,splitcount+lastno,sheetObjects[0].CellValue(1,prefix1+"bkg_no"),newBkgNo);
		 		 
		with(sheetObjects[1]){
			for(var i=0;i<splitNo;i++){
				DataInsert(-1);
				CellValue(i+1,prefix2+"bkg_no") = newSplitBkgNo[i];
				//colTile=ComLpad(i,2,"0");
				//CellValue(i+1,prefix2+"bkg_no_split") = colTile;
				CellValue(i+1,prefix2+"bl_no") = newSplitBkgNo[i];
				CellValue(i+1,prefix2+"tvvd") = sheetObjects[0].CellValue(1,prefix1+"tvvd");
				if ((splitNo-1)==i){
					CellValue2(i+1,prefix2+"act_wgt") =ComTrunc(sheetObjects[0].CellValue(1,prefix1+"act_wgt"),3)-ComTrunc(fWgtLast,3);
					CellValue2(i+1,prefix2+"pck_qty") =ComParseInt(sheetObjects[0].CellValue(1,prefix1+"pck_qty"))-fPkgLast;
					CellValue2(i+1,prefix2+"meas_qty") =ComTrunc(sheetObjects[0].CellValue(1,prefix1+"meas_qty"),3)-ComTrunc(fMeaLast,3);

				}else{
					CellValue2(i+1,prefix2+"act_wgt") =fWgt;
					CellValue2(i+1,prefix2+"pck_qty") =fPkg;
					CellValue2(i+1,prefix2+"meas_qty") =fMea;
					fWgtLast+=Number(fWgt); 
					fWgtLast = parseFloat(fWgtLast.toFixed(3));
					fPkgLast+=Number(fPkg);
					fMeaLast+=Number(fMea);
					fMeaLast = parseFloat(fMeaLast.toFixed(3));
				}
				
				CellValue2(i+1,prefix2+"wgt_ut_cd") = sheetObjects[0].CellValue(1,prefix1+"wgt_ut_cd");
				CellValue2(i+1,prefix2+"pck_tp_cd") = sheetObjects[0].CellValue(1,prefix1+"pck_tp_cd");
				CellValue2(i+1,prefix2+"meas_ut_cd") = sheetObjects[0].CellValue(1,prefix1+"meas_ut_cd");				
			}
		}
		sheetObjects[0].Copy2SheetCol(sheetObjects[1],prefix1+"adv_shtg_cd",prefix2+"adv_shtg_cd",-1,-1);

		//Qty split no
		for(var iRow=0;iRow<sheetObjects[2].Rows-1;iRow++){
			var fQty=ComTrunc(ComTrunc(sheetObjects[2].CellValue(iRow+1,prefix3+"op_cntr_qty"),2)/splitNo,2);
		    var fQtyLast=0;
			for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
				if (iCol==ComCountHeadTitle(strSheetTitle3)-1){
					var newQty = ComTrunc(sheetObjects[2].CellValue(iRow+1,prefix3+"op_cntr_qty"),2)-ComTrunc(fQtyLast,2);
					if(newQty==0 || newQty<0) newQty = 0.01;
					sheetObjects[2].CellValue2(iRow+1,iCol)=newQty;
				}else{
					sheetObjects[2].CellValue2(iRow+1,iCol)=fQty; 
					fQtyLast+=Number(fQty);
					fQtyLast = parseFloat(fQtyLast.toFixed(2));
				}
			}
		}		 
	}

	/*
	* 수동 Volume분할
	*/
	function manualVolume(splitNo,splitreason,lastno,splitcount){
		var colTile ="";
		var newBkgNo = ComGetObjValue(document.form.bkgsplitno);
		if (newBkgNo.length<1){
			newBkgNo =sheetObjects[0].CellValue(1,prefix1+"bkg_no");
		}else{
			newBkgNo =ComGetObjValue(document.form.bkgsplitno);
		}
		var newSplitBkgNo=getSplitBkgNo(splitreason,lastno,splitcount+lastno,sheetObjects[0].CellValue(1,prefix1+"bkg_no"),newBkgNo);
		with(sheetObjects[1]){
			for(var i=0;i<splitNo;i++){
				DataInsert(-1);
				CellValue(i+1,prefix2+"bkg_no") = newSplitBkgNo[i];
				//colTile=ComLpad(i,2,"9");
				//CellValue(i+1,prefix2+"bkg_no_split") = colTile;
				CellValue(i+1,prefix2+"bl_no") = newSplitBkgNo[i];
				CellValue(i+1,prefix2+"tvvd") = sheetObjects[0].CellValue(1,prefix1+"tvvd");
				CellValue(i+1,prefix2+"wgt_ut_cd") = sheetObjects[0].CellValue(1,prefix1+"wgt_ut_cd");
				CellValue(i+1,prefix2+"pck_tp_cd") = sheetObjects[0].CellValue(1,prefix1+"pck_tp_cd");
				CellValue(i+1,prefix2+"meas_ut_cd") = sheetObjects[0].CellValue(1,prefix1+"meas_ut_cd");
			}
		}
		sheetObjects[0].Copy2SheetCol(sheetObjects[1],prefix1+"adv_shtg_cd",prefix2+"adv_shtg_cd",-1,-1);
		//Qty split no
		for(var iRow=0;iRow<sheetObjects[2].Rows-1;iRow++){
			for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
					sheetObjects[2].CellValue2(iRow+1,iCol)=0; 
			}
		} 
	}	

	/*
	* PC 처리 함수
	*/
	function pcProcess(sheetObj,Row, Col, Value, prefix){
		var formObj = document.form;
		if(sheetObj.CellValue(Row, prefix+"tvvd").length==0){
			ComShowCodeMessage("BKG00833");
			return;
		}
		if (Row>0 && sheetObj.ColSaveName(Col) == prefix+"pc"){
			ComSetObjValue(formObj.pcIdx,Row-1);
			doActionIBSheet(sheetObj,document.form,COMMAND02);
		}
	}
	
	/*
	* Sheet2 OnClick 이벤트 처리
	*/
	function sheet2_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
		if (sheetObj.ColSaveName(Col)==prefix2+"pc"){   //T.VVD 
			pcProcess(sheetObj,Row, Col, Value,prefix2);
		}
		if (sheetObj.ColSaveName(Col) == prefix2+"read" && sheetObj.CellValue(Row, prefix2+"xter_sndr_id") != ""){
 			rdOpen(sheetObj,Row,prefix2);
 		}
	}
	
	/*
	* Sheet2 OnChange 이벤트 처리
	*/
	function sheet2_OnChange(sheetObj,Row, Col,Value){
		if (sheetObj.ColSaveName(Col)==prefix2+"tvvd"){   //T.VVD
			SheetOnAfterEditSet(sheetObj,document.form,Row,Col,prefix2);
		}		
	}
	
	/*
	* Sheet3 OnChange 이벤트 처리
	*/
	function sheet3_OnChange(sheetObj,Row, Col,Value){
		var formObj = document.form;
		if (ComIsNull(formObj.splitcount)) return;
		var splitNo=ComParseInt(formObj.splitcount); 
		var iflag = Value.split(".");
		if (iflag.length>1){
			 if (ComParseInt(iflag[1])>0){ //변경된 값이 정수가 아니면 partialFlag = 'Y'
				 ComSetObjValue(formObj.partialflag,"Y");
			 }else{
				ComSetObjValue(formObj.partialflag,"");
			 }
		}else{
			ComSetObjValue(formObj.partialflag,"");
		}
	 
	}
	
	/*
	* 그리드에서 라디오체크와 무조건 하나체크되게 처리
	*/
	function SheetColOneRadioCheck(sheetObj,Row,Col,Value,sheetTitle){
			var flag=false;
			for (var iCol=0;iCol<ComCountHeadTitle(sheetTitle);iCol++ ){
				 if(typeof(sheetObj.CellValue(Row,iCol).length) =="undefined"){
					 if (sheetObj.CellValue(Row,iCol)==1){
						 flag=true;
					 } 
				 }
			 }
			if(flag){
				for (var i=0;i<ComCountHeadTitle(sheetTitle);i++ ){
					 if(typeof(sheetObj.CellValue(Row,i).length) =="undefined"){
						 if (sheetObj.ColSaveName(Col)==sheetObj.ColSaveName(i)){
							  sheetObj.CellValue2(Row,sheetObj.ColSaveName(Col))=Value;
						 }else{
							 sheetObj.CellValue2(Row,sheetObj.ColSaveName(i))=0;
						 }
					 }
				 }
			}else{
				sheetObj.CellValue2(Row,Col)=1;
			}
		}
	
	/*
	* 그리드 라디오 체크 열컬럼 적용
	*/
	function sheet4_OnChange(sheetObj,Row,Col,Value){
		ComSetObjValue(document.form.cntrPopExists,"N");
		dgSelectFlg="N";
		rfSelectFlg="N";
		akSelectFlg="N";
		// 해당 validation skip함(20091029 임종한 대리님 요청)
//		if (ComGetObjValue(document.form.splitreason)=="M"){
//			SheetColOneRadioCheck(sheetObj,Row,Col,Value,strSheetTitle4);
//		}
		
	} 
	
	/*
	* Sheet onAfterEdit이벤트 일때 split관련 처리
	*/
	function SheetOnAfterEditSet(sheetObj,formObj,Row,Col,prefix){
		if (sheetObj.ColSaveName(Col)==prefix+"tvvd"){   //T.VVD 
			if(sheetObj.CellValue(Row,prefix+"tvvd")==null){
				sheetObj.ColHidden(prefix+"pc")=false;
				sheetObj.CellValue2(Row,prefix+"pc")=0;
			} else if (ComGetObjValue(formObj.tvvd).toUpperCase() != sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase()){ 
				sheetObj.ColHidden(prefix+"pc")=false;	
				sheetObj.CellValue2(Row,prefix+"pc")=0;
			}else{
				sheetObj.CellValue2(Row,prefix+"pc")=1;
			}
		}
		 
		if (ComIsContainsCharsOnly(sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase(),"HJXX")
			|| ComIsContainsCharsOnly(sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase(),"HJYY")
			|| ComIsContainsCharsOnly(sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase(),"HJZZ")){
			ComSetObjValue(formObj.pseudoVvdFlag,"Y");
		}else{
			ComSetObjValue(formObj.pseudoVvdFlag,"N");
		}


	}

	/*
	* Sheet1 onAfterEdit 이벤트 처리
	*/
	function sheet1_OnAfterEdit(sheetObj,Row,Col){
		var formObj = document.form;
		SheetOnAfterEditSet(sheetObj,formObj,Row,Col,prefix1);
	}
	
	/*
	* Sheet2 onAfterEdit 이벤트 처리
	*/
	function sheet2_OnAfterEdit(sheetObj,Row,Col){
		var formObj = document.form;
		var fActSum =0;
		var fPckSum =0;
		var fMeasSum =0; 
		 if (sheetObj.ColSaveName(Col)==prefix2+"act_wgt"
		    || sheetObj.ColSaveName(Col)==prefix2+"pck_qty"
			|| sheetObj.ColSaveName(Col)==prefix2+"meas_qty"){
			
			for(var idx=1;idx<sheetObj.Rows-1;idx++){
				fActSum+=ComTrunc(sheetObj.CellValue(idx,prefix2+"act_wgt"),3);
				fActSum = parseFloat(fActSum.toFixed(3));
				fPckSum+=ComParseInt(sheetObj.CellValue(idx,prefix2+"pck_qty"));
				fMeasSum+=ComTrunc(sheetObj.CellValue(idx,prefix2+"meas_qty"),3);
				fMeasSum = parseFloat(fMeasSum.toFixed(3));
			}
			
			if (ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"act_wgt"),3)-fActSum<0){
				ComShowCodeMessage("BKG00643");
				sheetObj.CellValue2(Row,Col)=0;
				return false;
			}
			 
			if (ComParseInt(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"pck_qty"))-fPckSum<0){
				ComShowCodeMessage("BKG00644");
				sheetObj.CellValue2(Row,Col)=0;
				return false;
			}

			if (ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"meas_qty"),3)-fMeasSum<0){
				ComShowCodeMessage("BKG00645");
				sheetObj.CellValue2(Row,Col)=0;
				return false;
			}
			 
			sheetObj.CellValue2(sheetObj.Rows-1,prefix2+"act_wgt")=ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"act_wgt"),3)-fActSum;
			sheetObj.CellValue2(sheetObj.Rows-1,prefix2+"pck_qty")=ComParseInt(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"pck_qty"))-fPckSum;
			sheetObj.CellValue2(sheetObj.Rows-1,prefix2+"meas_qty")=ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"meas_qty"),3)-fMeasSum;
		}
		
		SheetOnAfterEditSet(sheetObj,formObj,Row,Col,prefix2);
		
		var arr="";
		if (sheetObj.CellValue(Row,prefix2+"bkg_no").length==12){
			arr=sheetObj.CellValue(Row,prefix2+"bkg_no").substring(10,12);
		}else{
			arr="00";
		}
		for(var iRow=1;iRow<sheetObjects[3].Rows;iRow++){
			for(var iCol=5;iCol<ComCountHeadTitle(strSheetTitle4);iCol++){ 
                var arrCol=sheetObjects[3].ColSaveName(iCol).split("_");
				if(arrCol[1]==arr && sheetObjects[3].CellValue(iRow,iCol)==1){
					sheetObjects[3].CellValue2(iRow,prefix4+"adv_shtg_cd") =  sheetObj.CellValue(Row,prefix2+"adv_shtg_cd");
				}
			 }
		 } 
	}
	
	/*
	* Sheet3 onAfterEdit 이벤트 처리
	*/
	function sheet3_OnAfterEdit(sheetObj,Row,Col){
		var formObj = document.form;
		if (ComIsNull(formObj.splitcount)) return;
		var splitNo=ComParseInt(formObj.splitcount);
		var fQtySum=0.00;
		var fQtySub=0; 
		var fQtyDiv=0.00;
		
		fQtyDiv=ComCountHeadTitle(strSheetTitle3)-Col-1;
		for (var iCol=Col+1;iCol<ComCountHeadTitle(strSheetTitle3)-1;iCol++){
			sheetObj.CellValue2(Row,iCol)=(ComTrunc(sheetObj.CellValue(Row,prefix3+"op_cntr_qty"),2)-ComTrunc(sheetObj.CellValue(Row,Col),2))/fQtyDiv;
		}
		
		for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3)-1;iCol++){
			fQtySum +=ComTrunc(sheetObj.CellValue(Row,iCol),2);
			if (iCol<ComCountHeadTitle(strSheetTitle3)-1){
				fQtySub +=ComTrunc(sheetObj.CellValue(Row,iCol),2);
			}			
		} 

        if (Col != sheetObj.LastCol){ 
			sheetObj.CellValue2(Row,sheetObj.LastCol)=ComTrunc(sheetObj.CellValue(Row,prefix3+"op_cntr_qty"),2)-fQtySum;			
		}
        if (ComTrunc(sheetObj.CellValue(Row,prefix3+"op_cntr_qty"),2)-(ComTrunc(fQtySum,2)+ComTrunc(sheetObj.CellValue(Row,sheetObj.LastCol),2))>=0.05
        		|| ComTrunc(sheetObj.CellValue(Row,prefix3+"op_cntr_qty"),2)-(ComTrunc(fQtySum,2)+ComTrunc(sheetObj.CellValue(Row,sheetObj.LastCol),2))<=-0.05){
				ComShowCodeMessage("BKG00642");
				sheetObj.CellValue2(Row,Col)=0;
				return false;
		}		
	}	
	
	/*
	* Sheet4 onClick 이벤트 처리
	*/
	function sheet4_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
		var arr="";
		 arr=sheetObj.ColSaveName(Col).split("_");
		 
		 for(var i=1;i<sheetObjects[1].Rows;i++){
			if(sheetObjects[1].CellValue(i,prefix2+"bkg_no").substring(10,12)==arr[1]){
				sheetObj.CellValue2(Row,prefix4+"adv_shtg_cd") =  sheetObjects[1].CellValue(i,prefix2+"adv_shtg_cd");
			}
		 } 		  
	}

	/*
	* Special Cargo Split Check
	*/
	function CheckPopValidate(sheetObj,btnName,formObject){
		if(!ComIsBtnEnable(btnName)) return false; 		 
		return true;
	}
	
	/*
	* Cntr 초기화시 SplitNo 체크
	*/
	function Check_Cntr(sheetObj,prefix){
		for(var i=1;i<sheetObj.Rows;i++){
			sheetObj.CellValue2(i,prefix)=1;
		}
	}

	/**
    * CA Reason 후속 처리 : CaReasonModify
    */ 
    function setCAReasonCallBack(arrPopupData) {
        var formObj = document.form;
          
    	//01. CA ReasonCd, Remark 입력정보 받아서,
    	var strRsnCd  = nullToBlank(arrPopupData[0][2]);
    	var strRemark = nullToBlank(arrPopupData[0][3]);
        
    	//02. modifyCaReason(e) call
        formObj.caRsnCd.value = strRsnCd;
        formObj.caRemark.value = strRemark;        
    }

	// ESD_PRD_018 호출후 Return 받는값.(PCTL_NO)
	function callBackEsdPrd0080(pctlNo){
		var formObject = document.form;
		var row = sheetObjects[1].SelectRow;
		if(pctlNo.length<20){
			sheetObjects[1].CellValue(row, prefix2+"pctl_no")="";
		} else {
			var arrXml = pctlNo.split("|");			
			sheetObjects[1].CellValue(row, prefix2+"pctl_no")=arrXml[0];
		}
	}  
	/**
	* S/I SPLIT CANDIATE에서 호출되어져 로딩시 값 자동 세팅
	*/
	function setSplitValFromOpener0445(){
		if (ComGetObjValue(document.form.openerPgmNo) != "ESM_BKG_0445") return;
			
		var opener = window.dialogArguments;
		var oSheetObj = opener.sheetObjects[1];
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		var row = 0;
		var orignrow = 1 ;
		var arrRow = ComFindText(oSheetObj, "origin", 1);
		if (arrRow && 0<arrRow.length) {
			orignrow = arrRow[0];
		}
		
		/*original sheet*/
		/*
		sheetObj1.CellValue2(1, prefix1+"xter_sndr_id") = oSheetObj.CellValue(orignrow, "xter_sndr_id");
		sheetObj1.CellValue2(1, prefix1+"xter_rqst_no") = oSheetObj.CellValue(orignrow, "xter_rqst_no");
		sheetObj1.CellValue2(1, prefix1+"xter_rqst_seq") = oSheetObj.CellValue(orignrow, "xter_rqst_seq");
		sheetObj1.CellValue2(1, prefix1+"meas_qty") = oSheetObj.CellValue(orignrow, "meas_qty");
		sheetObj1.CellValue2(1, prefix1+"meas_ut_cd") = oSheetObj.CellValue(orignrow, "meas_ut_cd");
		sheetObj1.CellValue2(1, prefix1+"act_wgt") = oSheetObj.CellValue(orignrow, "net_wgt");
		sheetObj1.CellValue2(1, prefix1+"wgt_ut_cd") = oSheetObj.CellValue(orignrow, "wgt_ut_cd");
		sheetObj1.CellValue2(1, prefix1+"pck_qty") = oSheetObj.CellValue(orignrow, "pck_qty");
		sheetObj1.CellValue2(1, prefix1+"pck_tp_cd") = oSheetObj.CellValue(orignrow, "pck_tp_cd");
		sheetObj1.CellValue2(1, prefix1+"doc_tp_cd") = oSheetObj.CellValue(orignrow, "doc_tp_cd");
		*/
		
		/*split sheet*/
		for ( var i = oSheetObj.HeaderRows; i <= oSheetObj.LastRow; i++) {
			if (oSheetObj.CellValue(i, "sel") == '1'){
				row++;
				sheetObj2.CellValue2(row, prefix2+"xter_sndr_id") = oSheetObj.CellValue(i, "xter_sndr_id");
				sheetObj2.CellValue2(row, prefix2+"xter_rqst_no") = oSheetObj.CellValue(i, "xter_rqst_no");
				sheetObj2.CellValue2(row, prefix2+"xter_rqst_seq") = oSheetObj.CellValue(i, "xter_rqst_seq");
				sheetObj2.CellValue2(row, prefix2+"meas_qty") = oSheetObj.CellValue(i, "meas_qty");
				sheetObj2.CellValue2(row, prefix2+"meas_ut_cd") = oSheetObj.CellValue(i, "meas_ut_cd");
				sheetObj2.CellValue2(row, prefix2+"act_wgt") = oSheetObj.CellValue(i, "net_wgt");
				sheetObj2.CellValue2(row, prefix2+"wgt_ut_cd") = oSheetObj.CellValue(i, "wgt_ut_cd");
				sheetObj2.CellValue2(row, prefix2+"pck_qty") = oSheetObj.CellValue(i, "pck_qty");
				sheetObj2.CellValue2(row, prefix2+"pck_tp_cd") = oSheetObj.CellValue(i, "pck_tp_cd");
				sheetObj2.CellValue2(row, prefix2+"doc_tp_cd") = oSheetObj.CellValue(i, "doc_tp_cd");
			}
		}
	}
	
	/**
     * Sheet 조회완료 후 이벤트 발생
     */
    function sheet_imageSetEDI(sheetObj,prefix, val) {
   	  	with (sheetObj) {
             for (var i = HeaderRows ; i <= LastRow; i++) {
            	 CellImage(i,prefix+"read"      ) = val;
             }
         }
    }
    
	 function rdOpen(sheetObj,Row ,prefix){
	   		var Rdviewer = rdObjects[0];
	   		var formObj = document.form;
	   		
	   		var rdParam = "/rv " + "frm1_sender_id["+sheetObj.CellValue(Row, prefix+"xter_sndr_id")+"] frm1_rqst_no["+sheetObj.CellValue(Row, prefix+"xter_rqst_no")+"] frm1_rqst_seq["+sheetObj.CellValue(Row, prefix+"xter_rqst_seq")+"] frm1_bkg_no["+sheetObj.CellValue(Row, prefix+"bkg_no")+"]";
	   		var rdUrl = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/";
	   		var rdFile = null;
	   		
	   		if ( sheetObj.CellValue(Row, prefix+"doc_tp_cd") == "B" ) rdFile = "ESM_BKG_0230B.mrd";
	   		else rdFile = "ESM_BKG_0230S.mrd";
	   		
	   		formObj.com_mrdPath.value = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/"+rdFile;
	   		formObj.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";
	   		
	   		var iWidth = 1000;
	   		var	iHeight= 600;
	   		var leftpos = (screen.width - iWidth) / 2;
	   		if (leftpos < 0)
	   			leftpos = 0;
	   		var toppos = (screen.height - iHeight) / 2;
	   		if (toppos < 0)
	   			toppos = 0;
	   		ComOpenRDPopup('resizable=yes,width='+iWidth+',height='+iHeight+',left='+ leftpos + ',top=' + toppos);
	} 
	/* 개발자 작업  끝 */
	