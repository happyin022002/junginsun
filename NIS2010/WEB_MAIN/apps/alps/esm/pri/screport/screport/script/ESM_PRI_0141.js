/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_PRI_0141.js
*@FileTitle : MOT/SSE Tariff 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.04.25 송호진
* 1.0 Creation
=========================================================                                                                                                                                                                                                                                                                                                                                                                                                               
* History                                                                                                                                                                                                                                                                                                                                                                                                                                                               
* 2013.11.20 송호진 [CHM-201432653] MOT/SSE Filing (2014/12/01 부) 9개 신규 Surcharge 열 추가
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
     * @class ESM_PRI_0141 : ESM_PRI_0141 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0141() {
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

    //  ===================================================================================
    //  전역변수
    //  ===================================================================================
    //  공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;

    var sheet1;
    var sheet2;
    
    var motTrfSeqList;
    
    var isAproUsr = false;
    var selectedMotTrfSeq;
    var selectedIdx;

	var motDstBsePortCdValue = "";
	var motDstBsePortCdText  = "";
	

    //  업무전역변수
    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
    }

    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function loadPage() {
        var form = document.form;
        
        sheet1 = sheetObjects[0];

        sheetCnt = sheetObjects.length ;
        //IBSheet 초기화
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
        }
        
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
		
		doActionIBSheet(sheet1, document.form, IBSEARCH_ASYNC10);
		
		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerForm('change', 'obj_change', document.form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
		axon_event.addListenerFormat('keydown', 'obj_keydown', document.form);
		 
		// 당일 날짜로 default setting
		gCurrDate = ComGetDateAdd(null, "D", 0)
		
		ComPriTextCode2ComboItem ( motOrgBsePortCdValue, motOrgBsePortCdText, document.form.f_org_cd );
		ComPriTextCode2ComboItem ( motCntrTpCdValue, motCntrTpCdText, document.form.f_cntr_tp_cd );
		ComPriTextCode2ComboItem ( motCmdtTpCdValue, motCmdtTpCdText, document.form.f_cmdt_tp_cd );
		ComPriTextCode2ComboItem ( motCntrSzCdValue, motCntrSzCdText, document.form.f_cntr_sz_cd );
		 	
        sheet1.WaitImageVisible = false;    

    }

     /**
      * OnKeyDown event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param 없음
      * @return 없음
      * @author 강효진
      * @version 2010.04.26
      */       
     function obj_keydown(){
        //enter key조회
        var eleName = event.srcElement.name;
        if (eleName == "exec_dt" ){
            var keyValue = null;
            if(event == undefined || event == null) {
         	   keyValue = 13;
            }else{
         	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            }
            if (keyValue == 13){
         	   doActionIBSheet( sheet1, document.form, IBSEARCH );
            }
        }
     }

 	/**
 	 * OnBeforeActivate   event를 처리한다. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *     obj_activate()
 	 * </pre>
 	 * @param 없음
 	 * @return 없음
 	 * @author 박성수
 	 * @version 2009.04.17
 	 */
 	function obj_activate() {
 		var formObject = document.form;
 	    var srcName = event.srcElement.getAttribute("name");
 	    
 	    if (srcName == "eff_dt_hidden" && formObject.eff_dt_hidden.value != "") {
 	    	var effDt = formObject.eff_dt_hidden.value;
 	    	
 	    	formObject.eff_dt.value = formObject.eff_dt_hidden.value;
     		comboObjects[1].SetText(selectedMotTrfSeq, 0, effDt); 
 			comboObjects[1].SetText(selectedMotTrfSeq, 4, effDt);
 			
 			formObject.eff_dt_hidden.value = "";
 			
 	    	//ComClearSeparator (event.srcElement);
 	    } else if (srcName == "scope_year") {
 	    	//ComClearSeparator (event.srcElement);
 	    } else if ( srcName == "file_dt") {
			var fileDt = formObject.file_dt.value; 
			fileDt = fileDt.replace(/-/gi, "");
			formObject.file_dt.value = fileDt;
	    }
 	}
 	
     
     /** 
      * Object 의 Onbeforedeactivate 이벤트핸들러 <br>
      * 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음  
      * @return 없음
      * @see #
      * @author 강효진
      * @version 2010.04.23
      */ 
     function obj_deactivate() {

        ComChkObjValid(event.srcElement);
  		var formObject = document.form;
 	    var srcName = event.srcElement.getAttribute("name");
 	    if ( srcName = "file_dt" ) {
 	    	var fileDt = formObject.file_dt.value;
 			if (ComIsDate(fileDt) || fileDt == "" ) {
 				if ( fileDt != "" ) {
	 				fileDt = fileDt.replace(/-/gi, "");
	 				fileDt = fileDt.substring(0, 4) + "-" + fileDt.substring(4, 6) + "-" + fileDt.substring(6, 8); 
	 				
	 				document.form.file_dt.value = fileDt;
 				}

 			} else {
 				ComShowCodeMessage("COM12134", "File Date");
 				document.form.file_dt.value = "";
 				return false;
 			}
	    	
 	    }
     }
      
     /**
      * OnChange 이벤트 발생시 호출되는 function <br>
      * Office Code 를 변경하면 조직도, 사원 Combo item, 사용자권한 List 를 조회한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_change ();
      * </pre>
      * @return 없음
      * @author 문동규
      * @version 2009.06.02
      */
     /*
     function obj_change () {
         try {
             var formObj = document.form;
             var srcName = event.srcElement.getAttribute("name");

             if (srcName == "eff_dt_hidden") {
            	 
          	    if (srcName == "file_dt" && formObject.eff_dt_hidden.value != "") {
         	    	var effDt = formObject.eff_dt_hidden.value;
         	    	
         	    	formObject.eff_dt.value = formObject.eff_dt_hidden.value;
             		comboObjects[1].SetText(selectedMotTrfSeq, 0, effDt); 
         			comboObjects[1].SetText(selectedMotTrfSeq, 4, effDt);
         			
         			//formObject.eff_dt_hidden.value = "";
         			
         	    	//ComClearSeparator (event.srcElement);
         	    } 
             }
         } catch(e) {
             if( e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e);
             }
         } finally {
             ComOpenWait(false);
         }
     }
     */
     
    /** 
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : 시트오브젝트
     * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
        /*
        	case "sheet0":      //hidden 
	            with (sheetObj) {
	            	// 높이 설정
	            	style.height = 0;
	            	//전체 너비 설정
	            	SheetWidth = mainTable.clientWidth;
	
	            	//Host정보 설정[필수][HostIp, Port, PagePath]
	            	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            	//전체Merge 종류 [선택, Default msNone]
	            	//MergeSheet = msAll;
	
	            	//전체Edit 허용 여부 [선택, Default false]
	            	//Editable = true;
	
	            	//Row의 자동 줄바꿈 하지 않음
	            	//AutoRowHeight = false;
	
	            	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            	InitRowInfo( 1, 1, 3, 100);
	            	var HeadTitle = "|Sel.|Del Check|svc_scp_cd|mot_trf_seq|eff_dt|file_dt|cfm_dt|cfm_flg";
	            	var headCount = ComCountHeadTitle(HeadTitle);
	
	            	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            	InitColumnInfo(headCount, 0, 0, true);
	
	            	// 해더에서 처리할 수 있는 각종 기능을 설정한다
	            	InitHeadMode(true, true, false, true, false, false)
	
	            	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            	InitHeadRow(0, HeadTitle, true);
	
	            	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  "ibflag");
                    InitDataProperty(0, cnt++,  dtDummyCheck, 	40, 	daCenter,   false,  "chk");
                    InitDataProperty(0, cnt++,  dtDelCheck, 	30, 	daCenter,   false,  "del_chk");
	            	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"svc_scp_cd",			false,"",dfNone,	0,false,false);
	            	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"mot_trf_seq",			false,"",dfNone,	0,false,false);
	            	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"eff_dt",				false,"",dfDateYmd,	0,false,false);
	            	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"file_dt",				false,"",dfDateYmd,	0,false,false);
	            	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"cfm_dt",				false,"",dfDateYmd,	0,false,false);
	            	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"cfm_flg",				false,"",dfNone,	0,false,false);
					
	            }
	            break; 
    */
            case "sheet1":
                with (sheetObj) {
                	// 높이 설정
                	style.height = 450;
                	//전체 너비 설정
                	SheetWidth = mainTable.clientWidth;

                	//Host정보 설정[필수][HostIp, Port, PagePath]
                	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                	//전체Merge 종류 [선택, Default msNone]
                	//MergeSheet = msAll;

                	//전체Edit 허용 여부 [선택, Default false]
                	Editable = true;

                	//Row의 자동 줄바꿈 하지 않음
                	AutoRowHeight = false;

                	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                	InitRowInfo( 1, 1, 3, 100);
/*
                	var HeadTitle = "|Sel.|Del Check|Seq.|svc_scp_cd|mot_trf_seq|rt_seq|Carrier|Lane|Origin\n(POR)|Dest\n(DEL)|CNTR\nType" +
									"|CMDT\nType|Size|Rate|Commission||BAF|CAF|O.THC|D.THC|*APS|*CSR|*PSC|*PCC|*PCS|*STF|D.ACT|D.DDC|D.DDF" +
									"|D.NFC|O.ENS|O/D|T.DIS|T.GOH|T.WSC|*BUC|*EIC|O.SLF|O.OBS|O.DHF|D.DCS|D.DTS|O.CMS|D.OCP|Remark(s)";
*/
                	var HeadTitle = "|Sel.|Del Check|Seq.|svc_scp_cd|mot_trf_seq|rt_seq|Carrier|Lane|Origin\n(POR)|Dest\n(DEL)|CNTR\nType" +
									"|CMDT\nType|Size|Rate|Commission||BAF|CAF|O.THC|D.THC|*APS|*CSR|*PSC|D.ACT|D.DDC|D.NFC|O/D|T.GOH|*BUC" + 
									"|*PCC|*PCS|*STF|*EIC|O.SLF|O.OBS|O.DHF|O.CMS|O.ENS|D.DCS|D.DTS|D.OCP|D.DDF|T.DIS|T.WSC|Remark(s)";
                	var headCount = ComCountHeadTitle(HeadTitle);

                	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                	InitColumnInfo(headCount, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false, false)

                	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                	InitHeadRow(0, HeadTitle, true);

                	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  "ibflag");
                    InitDataProperty(0, cnt++,  dtDummyCheck, 	40, 	daCenter,   false,  "chk");
                    InitDataProperty(0, cnt++,  dtDelCheck, 	30, 	daCenter,   false,  "del_chk");
                	InitDataProperty(0, cnt++ , dtData,  		30,		daRight,	false,	"seq", 					false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"svc_scp_cd",			false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"mot_trf_seq",			false,"",dfNone,	0,false,false);
/*                	
                	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"eff_dt",				false,"",dfDateYmd,	0,false,false);
                	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"file_dt",				false,"",dfDateYmd,	0,false,false);
                	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"cfm_dt",				false,"",dfDateYmd,	0,false,false);
                	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"cfm_flg",				false,"",dfNone,	0,false,false);
*/                	
                	InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,	"rt_seq",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  		50,		daCenter,	false,	"carrier",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  		40,		daCenter,	false,	"mot_file_lane_cd",		false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtComboEdit, 	70,		daCenter,	false,	"mot_trf_org_cd",		false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtComboEdit,  	70,		daCenter,	false,	"mot_trf_dest_cd",		false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtComboEdit,  	50,		daCenter,	false,	"mot_trf_cntr_tp_cd",	false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtComboEdit,  	50,		daCenter,	false,	"mot_trf_cmdt_tp_cd",	false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtComboEdit,  	50,		daCenter,	false,	"mot_trf_cntr_sz_cd",	false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"mot_trf_rt_amt",		false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		80,		daRight,	false,	"blnk1",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  		20,		daRight,	false,	"blnk2",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"baf_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"caf_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"othc_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"dthc_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"aps_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"csr_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"psc_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"dact_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"dddc_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"dnfc_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"od_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"tgoh_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"buc_amt",				false,"",dfNone,	0,true, true );
                	
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"pcc_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"pcs_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"stf_amt",				false,"",dfNone,	0,true, true );
                	
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"eic_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"oslf_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"oobs_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"odhf_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"ocms_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"oens_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"ddcs_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"ddts_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"docp_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"dddf_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"tdis_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	false,	"twsc_amt",				false,"",dfNone,	0,true, true );
                	InitDataProperty(0, cnt++ , dtData,  		120,	daLeft,		false,	"mot_trf_rmk",			false,"",dfNone,	0,true, true );
                	                	
                    InitDataCombo(0, "mot_trf_org_cd",     motOrgBsePortCdText, motOrgBsePortCdValue, "");
                    InitDataCombo(0, "mot_trf_dest_cd",    motDstBsePortCdText, motDstBsePortCdValue, "");
                    InitDataCombo(0, "mot_trf_cntr_tp_cd", motCntrTpCdText,     motCntrTpCdValue,     "");
                    InitDataCombo(0, "mot_trf_cmdt_tp_cd", motCmdtTpCdText,     motCmdtTpCdValue,     "");
                    InitDataCombo(0, "mot_trf_cntr_sz_cd", motCntrSzCdText,     motCntrSzCdValue,     "");
                    
                    InitDataValid(0, "mot_trf_rt_amt", vtNumericOnly);
                    InitDataValid(0, "baf_amt",  vtNumericOnly);
                    InitDataValid(0, "caf_amt",  vtNumericOnly);
                    InitDataValid(0, "othc_amt", vtNumericOnly);
                    InitDataValid(0, "dthc_amt", vtNumericOnly);
                    InitDataValid(0, "aps_amt",  vtNumericOnly);
                    InitDataValid(0, "csr_amt",  vtNumericOnly);
                    InitDataValid(0, "psc_amt",  vtNumericOnly);
                    InitDataValid(0, "pcc_amt",  vtNumericOnly);
                    InitDataValid(0, "pcs_amt",  vtNumericOnly);
                    InitDataValid(0, "stf_amt",  vtNumericOnly);
                    InitDataValid(0, "dact_amt", vtNumericOnly);
                    InitDataValid(0, "dddc_amt", vtNumericOnly);
                    InitDataValid(0, "dddf_amt", vtNumericOnly);
                    InitDataValid(0, "dnfc_amt", vtNumericOnly);
                    InitDataValid(0, "oens_amt", vtNumericOnly);
                    InitDataValid(0, "od_amt",   vtNumericOnly);
                    InitDataValid(0, "tdis_amt", vtNumericOnly);
                    InitDataValid(0, "tgoh_amt", vtNumericOnly);
                    InitDataValid(0, "twsc_amt", vtNumericOnly);
                    InitDataValid(0, "buc_amt",  vtNumericOnly);
                    InitDataValid(0, "eic_amt",  vtNumericOnly);
                    InitDataValid(0, "oslf_amt", vtNumericOnly);
                    InitDataValid(0, "oobs_amt", vtNumericOnly);
                    InitDataValid(0, "odhf_amt", vtNumericOnly);
                    InitDataValid(0, "ddcs_amt", vtNumericOnly);
                    InitDataValid(0, "ddts_amt", vtNumericOnly);
                    InitDataValid(0, "ocms_amt", vtNumericOnly);
                    InitDataValid(0, "docp_amt", vtNumericOnly);
                    
					ColHidden("del_chk") = true;
					
                    Ellipsis = true;
                    ShowButtonImage = 2;
                    CountPosition = 0;
                    
           }
                break;

        }
    }


    //  ===================================================================================
    //  버튼 이벤트 처리
    //  ===================================================================================
    document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function processButtonClick() {


		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
	
			switch (srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheet1,document.form,IBSEARCH);
				break;
			/*
			case "btn_new":
				doActionIBSheet(sheet1,document.form,IBCREATE);
				break;
			*/
            case "btn_new":
            	if (removeAll(document.form)) {
            		comboObjects[0].Code = "";
            		comboObjects[1].Code = "";
            		document.form.svc_scp_nm.value = "";
            		document.form.eff_dt.value = "";
            		document.form.eff_dt_hidden.value = "";
            		document.form.file_dt.value = "";
            		document.form.cfm_flg.value = "";
            	}
  				break;
                 
            case "btn_save":
            	if (validateForm(sheet1,document.form,IBSAVE)) {
   					doActionIBSheet(sheet1, formObject, IBSAVE);
   					
   				}	
   				break;                    
  
			case "btn_confirm":
				doActionIBSheet(sheet1,document.form,IBSEARCH_ASYNC01);
				break;
	
			case "btn_confirmcancel":
				doActionIBSheet(sheet1,document.form,IBSEARCH_ASYNC02);
				break;
				
			case "btn_delete":
				doActionIBSheet(sheet1,document.form,IBSEARCH_ASYNC03);
				break;
	
			case "btn_loadexcel":
				doActionIBSheet(sheet1,document.form,IBLOADEXCEL);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheet1,document.form,IBDOWNEXCEL);
				break;
				
            case "btns_calendar": //달력버튼
    			if (comboObjects[0].Code == "") {
    				ComShowCodeMessage('PRI08002');
    				return false;
    			}

                var cal = new ComCalendar();
                cal.select(formObject.eff_dt_hidden, 'yyyy-MM-dd');

                break;
	
            case "btn_add":
            	doActionIBSheet(sheet1, formObject, IBINSERT);
						
					break;

            case "btn_del":
            	doActionIBSheet(sheet1, formObject, IBDELETE);
						
					break;
                 
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	

    //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    //  ===================================================================================
    //  서버 조회/저장
    //  ===================================================================================
    /** 
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {

    	sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH: //조회

				if (validateForm(sheet1,document.form,IBSEARCH) == false ) return;
				
				ComOpenWait(true);

                formObj.f_cmd.value = SEARCH;
                //setParam(formObj);
                sheetObj.DoSearch("ESM_PRI_0141GS.do", FormQueryString(formObj));

                ComOpenWait(false);

                break;
                
			case IBSEARCH_ASYNC10: // 화면 로딩시 Service Scope 조회
				comboObjects[0].RemoveAll();
				
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_0141GS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");
				break;
				
			case IBSEARCH_ASYNC11: // Service Scope 선택시, Effective Date, Filing Date, Confirm Date, Confirm Flag 조회
				formObj.f_cmd.value = COMMAND15;
				var sParam = FormQueryString(formObj) + "&prc_ctrt_tp_cd=S&svc_scp_cd=" + comboObjects[0].Code + "&usr_id=" + formObj.usr_id.value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
				var arrAuth = ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");
				
				if (arrAuth != null && arrAuth.length > 0) {
					isAproUsr = true;
				} else {
					isAproUsr = false;
				}
				
				comboObjects[1].RemoveAll();
				comboObjects[1].InsertItem(0, "|||", "X");
				comboObjects[1].Code = "X";
				
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_0141GS.do", FormQueryString(formObj));
				var arrXml = sXml.split ( "|$$|" );
				if ( arrXml.length > 0 ) {
					ComPriXml2ComboItem(arrXml[0], formObj.mot_trf_seq, "mot_trf_seq", "eff_dt|file_dt|cfm_dt|cfm_flg|eff_dt", false);
				}
				
				
                formObj.f_dest_cd.RemoveAll();
				if ( arrXml.length > 1 ) {
					var arrMotDstBsePortCd = ComPriXml2ComboString ( arrXml[1], "cd", "cd");
					motDstBsePortCdText = " |"+arrMotDstBsePortCd[0];
					motDstBsePortCdValue = " |"+arrMotDstBsePortCd[0];
					
	                sheetObjects[0].InitDataCombo(0, "mot_trf_dest_cd",    motDstBsePortCdText, motDstBsePortCdValue, "");
	                
	                ComPriTextCode2ComboItem(motDstBsePortCdValue, motDstBsePortCdText, formObj.f_dest_cd );
				}

                formObj.f_lane_cd.RemoveAll();
                if ( arrXml.length > 2 ){
                	var arrMotFileLaneCd = ComPriXml2Array ( arrXml[2], "cd|nm");
                	var motFileLaneValue = " ";
                	var motFileLaneText = " \t "
                	for ( var i = 0; i < arrMotFileLaneCd.length; i++ ) {
                		motFileLaneValue += "|" + arrMotFileLaneCd[i][0];
                		motFileLaneText += "|" + arrMotFileLaneCd[i][0] + "\t" + arrMotFileLaneCd[i][1];
                	}
                	
	                ComPriTextCode2ComboItem( motFileLaneValue, motFileLaneText, formObj.f_lane_cd );
                }

                break;
			
            case IBLOADEXCEL:      //download excel
                
            	sheetObj.RemoveAll();
            	
				var strFilePath = sheetObj.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
				if (strFilePath != "<USER_CANCEL>") {
					var sFileNm = strFilePath.substring(0, strFilePath.lastIndexOf("."));
					if (sFileNm.substring(sFileNm.length - 1, sFileNm.length) == "H") {
						ComShowCodeMessage("PRI01117");
						return;
					}
					
					sheetObj.LoadExcel(-1, 1, strFilePath, -1, -1, "", false, false, "");
				}
				
				break;


            case IBDOWNEXCEL:      //download excel
            
            	if ( sheetObj.rowCount <= 0) return;

            	sheetObj.SpeedDown2Excel(-1);

	           	break;
                
            case IBSEARCH_ASYNC01:        //Confirm
            case IBSEARCH_ASYNC02:        //Confirm Cancel
            	
         	    formObj.f_cmd.value = MULTI;
    			formObj.cfm_flg.value = ( sAction == IBSEARCH_ASYNC01 ? "Yes" : "No" );
 				var sParam = FormQueryString(formObj);
 				 				
 				if (!ComPriConfirmSave()) {
 					return false;
 				}
 				
 				try {
 					ComOpenWait(true);

 					var sXml = sheet1.GetSaveXml("ESM_PRI_0141GS.do", sParam);
 					sheet1.LoadSaveXml(sXml);
 					
 					ComOpenWait(false);
 					
 				} catch (e) {
       	            if (e == "[object Error]") {
       	                ComShowMessage(OBJECT_ERROR);
       	            } else {
       	                ComShowMessage(e);
       	            }
       	       } finally {
       	    	   ComOpenWait(false);
       	       }	
 				
 			   doActionIBSheet(sheet1,document.form,IBSEARCH);
 			
        	   break;
        		 
            case IBSEARCH_ASYNC03:        // 삭제 
         	    formObj.f_cmd.value = MULTI01;
    			
 				var sParam = FormQueryString(formObj);
 				
 				if (!ComPriConfirmSave()) {
 					return false;
 				}
 				
 				try {
 					ComOpenWait(true);

 					var sXml = sheet1.GetSaveXml("ESM_PRI_0141GS.do", sParam);
 					sheet1.LoadSaveXml(sXml);
 					
 					ComOpenWait(false);
 					
 				} catch (e) {
       	            if (e == "[object Error]") {
       	                ComShowMessage(OBJECT_ERROR);
       	            } else {
       	                ComShowMessage(e);
       	            }
       	       } finally {
       	    	   ComOpenWait(false);
       	       }	
 				
       	       if ( formObj.mot_trf_seq.Code != "X" ) {
    	    	   doActionIBSheet ( sheet1, document.form, IBSEARCH_ASYNC11);
    	    	   if ( comboObjects[1].GetCount() > 1 ){
    	    		   comboObjects[1].Index = 1;
    	    	   }
    	       } 
        		 break;
        		 
            case IBSAVE:        //저장
         	    formObj.f_cmd.value = MULTI;
    			
 				var sParam = FormQueryString(formObj);
 				var sParamSheet1 = ComPriSetPrifix ( sheet1.GetSaveString(), "sheet1_");	
 				
 				if (sheet1.IsDataModified && sParamSheet1 == "") {
 					return;
 				}
 				
 				sParam += "&" + sParamSheet1;
 				
 				if (!ComPriConfirmSave()) {
 					return false;
 				}
 				
 				try {
 					ComOpenWait(true);

 					var sXml = sheet1.GetSaveXml("ESM_PRI_0141GS.do", sParam);
 					sheet1.LoadSaveXml(sXml);
 					
 					ComOpenWait(false);
 					
 				} catch (e) {
       	            if (e == "[object Error]") {
       	                ComShowMessage(OBJECT_ERROR);
       	            } else {
       	                ComShowMessage(e);
       	            }
       	       } finally {
       	    	   ComOpenWait(false);
       	       }	
 				
       	       if ( formObj.mot_trf_seq.Code == "X" ) {
       	    	   var effDt = formObj.eff_dt.value;
       	    	   doActionIBSheet ( sheet1, document.form, IBSEARCH_ASYNC11);
       	    	   var idx = comboObjects[1].FindIndex ( effDt, 0 );
       	    	   if ( idx != -1 ){
       	    		   comboObjects[1].Code = idx;
       	    	   }
       	       } else {
       	    	   doActionIBSheet(sheet1,document.form,IBSEARCH);
       	       }
 			
 			
        		 break;
        		 
            case IBINSERT: // Row Add
           		//sheetObj.DataAutoTrim = false;
            	var idx = sheetObj.DataInsert();
           		
           		break;
           		
           	 case IBDELETE: // Delete
           		//alert(sheetObj.id);
           		deleteRowCheck(sheetObj, "chk", true);
           		break;	 

        }
    }

     
 	/**
      * OnSearchEnd 시 발생한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *     searchConditionReset(formObj,gubun)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {String} ErrMsg    
      * @return 없음
      * @author 이승준
      * @version 2009.06.10
      */
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg)  {
  		var formObj = document.form;
  		if ( formObj.inq_tp_cd.value == "2") {
  			sheetObj.ColHidden ( "bkg_src_tp_cd" ) = false;
  			sheetObj.ColHidden ( "bkg_no" ) = false;
  		} else {
  			sheetObj.ColHidden ( "bkg_src_tp_cd" ) = true;
  			sheetObj.ColHidden ( "bkg_no" ) = true;  			
  		}
  	}
  	
	/**
	 * 콤보 초기설정값 정의 <br>
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initCombo(comboObj, comboNo);
	 * </pre>
	 * @param {ibcombo} sheetObj 필수 IBSheet Object
	 * @param {int} ComboNo 필수 IBCombo Object 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "svc_scp_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	
	            	IMEMode = 0;
	            	ValidChar(2, 0);
	            }
	            break;
	        
	        case "mot_trf_seq":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            	
	            	// 마지막 컬럼은 hidden(size = 0)으로 처리.
	            	SetColWidth("80|100|0|0|0");
	            	
	            	IMEMode = 0;
	            	ValidChar(2, 1);
	            }
	            break;
	    }
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	 *         로직처리;
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (comboObjects[0].Code == "" || comboObjects[1].Code == "" || comboObjects[1].Code == "X" ) {
				ComShowCodeMessage('PRI00316', 'Service Scope & Effective Date');
				return false;
			}
			return true;
			break;
			
		case IBCREATE: // New
			return true;
			break;
	
		case IBSAVE: // Save
			if (!ComChkValid(formObj)) {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() == "YES") {
				ComShowCodeMessage('PRI00105');
				return false;
			}
			if (comboObjects[0].Code == "") {
				ComShowCodeMessage('PRI00308', 'select', 'Service Scope');
				return false;
			}
			if (formObj.eff_dt.value == "") {
				ComShowCodeMessage('PRI00308', 'input', 'Effective Date');
				return false;
			}
			if (formObj.file_dt.value == "") {
				ComShowCodeMessage('PRI00308', 'input', 'File Date');
				return false;
			}
			if (formObj.eff_dt.value <= formObj.file_dt.value) {
				ComShowCodeMessage('PRI00354', 'File Date');
				return false;
			}
			return true;
			break;
	
		case IBSEARCH_ASYNC01: // Confirm
			if (comboObjects[0].Code == "" || comboObjects[1].Code == "") {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() == "YES") {
				return false;
			}
			if (subDataCnt <= 0) {
				ComShowCodeMessage("PRI08005");
				return false;
			}
			
			return true;
			break;
			
		case IBSEARCH_ASYNC02: // Cancel Confirm
			if (comboObjects[0].Code == "" || comboObjects[1].Code == "") {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() != "YES") {
				return false;
			}
			return true;
			break;
			
		case IBDELETE: // Delete
			if (comboObjects[0].Code == "" || comboObjects[1].Code == "") {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() == "YES") {
				return false;
			}
			return true;
			break;
			
		case IBCOPYROW: // Copy
			if (comboObjects[0].Code == "" || comboObjects[1].Code == "") {
				return false;
			}
			return true;
			break;
			
		}
	}
	
	/**
	 * OnSaveEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			if (document.form.f_cmd.value == MULTI01) {
				ComPriSaveCompleted();
			} else if (document.form.f_cmd.value == MULTI02) {
				ComPriConfirmCompleted();
			} else if (document.form.f_cmd.value == MULTI03) {
				ComPriCancelConfirmCompleted();
			} else if (document.form.f_cmd.value == MULTI04) {
				ComPriDeleteCompleted();
			}
		}
	}
	

	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function svc_scp_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		
		var arrText = text.split("|");
		// SVC_SCP 바뀌면 svc_scp_nm세팅하고 Duration 재조회.
		if (arrText != null && arrText.length > 1) {
			formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
			selectedMotTrfSeq = null;
			doActionIBSheet(sheet1, document.form, IBSEARCH_ASYNC11);
		}
	}
	
	function svc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
		var svcScpCdTxt = comboObj.Text;
		
		// 3자(Scope의 길이)이상 입력하면 focus out.
		if (svcScpCdTxt.length > 3) {
			document.form.svc_scp_nm.focus();
		}
	}
	
	function svc_scp_cd_OnClear(comboObj) {
		var formObject = document.form;
		formObject.svc_scp_nm.value = "";
		
		comboObj.Index = -1;
	}
	
	/**
	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    ssvc_scp_cd_OnBlur(comboObj);
	 * </pre>
	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function svc_scp_cd_OnBlur(comboObj) {
		var formObj = document.form;
		
		var code = comboObj.FindIndex(comboObj.Code, 0);
		
		// 키보드입력을 통해 SVC_SCP 바꾸고 focus out했을때 Duration 재조회
		if (code != null && code != "") {
			var text = comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
				formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
				doActionIBSheet(sheet1, document.form, IBSEARCH_ASYNC11);
			}
		}
	}
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function mot_trf_seq_OnChange(comboObj, code, text) {
		var formObj = document.form;

		selectedMotTrfSeq = code;
		
		if (code == "" || text == "" ) {
			return;
		}
		
		var effDt  = comboObj.GetText(code, 0);
		var fileDt = comboObj.GetText(code, 1);
		var cfmDt  = comboObj.GetText(code, 2);
		var cfmFlg = comboObj.GetText(code, 3);
		
		formObj.eff_dt.value = effDt;
		formObj.file_dt.value = fileDt;
		formObj.cfm_dt.value = cfmDt;
		formObj.cfm_flg.value = cfmFlg
		
		if (code == null || code == "" || code == "X") {
			return true;
		}
		
		doActionIBSheet(sheet1, document.form, IBSEARCH);
		
	}
	
	function mot_trf_seq_OnClear(comboObj) {
		var formObj = document.form;
		
		comboObj.Code = "X";
		formObj.eff_dt.value = "";
		formObj.file_dt.value = "";
		formObj.cfm_flg.value = "";
		formObj.cfm_dt.value = "";
		//formObj.cre_usr_nm.value = "";
		//formObj.cre_ofc_cd.value = "";
		
		//clearAllTabPages();
		removeAll(formObj);
	}
	
	
	function mot_trf_seq_OnKeyUp(comboObj, KeyCode, Shift) {
		
		var selEffDt = comboObj.Text;
		
		// 숫자 외의 것이 있다면(문자가 입력된것이 있다면), ""로 relace하고 다시 세팅.
		if (selEffDt.search(/[^0-9]/gi) >= 0) {
			selEffDt = selEffDt.replace(/[^0-9]/gi, "");
			comboObj.SetText(selectedMotTrfSeq, 4, selEffDt);
		}
		
		// 날짜 8자 입력하면 focus out.
		if (selEffDt.length == 8) {
			if ( ComIsDate(selEffDt)) {
				selEffDt = selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8);
				comboObj.SetText(selectedMotTrfSeq, 4, selEffDt);
			}
			document.form.file_dt.focus();
		}
		
	}
	

	function mot_trf_seq_OnFocus(comboObj) {
		var selEffDt = comboObj.Text;
		
		// 날짜부분의 하이픈 제거.
		if (selEffDt != null && selEffDt != "") {
			selEffDt = selEffDt.replace(/-/gi, "");
			comboObj.SetText(selectedMotTrfSeq, 4, selEffDt);
		}
	}
	
	
	/**
	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    ssvc_scp_cd_OnBlur(comboObj);
	 * </pre>
	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function mot_trf_seq_OnBlur(comboObj) {
		
		var selEffDt = comboObj.Text;
		var formObj = document.form;
		
		if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
			return false;
		}
		
		// 올바른 날짜가 맞다면, 하이픈 다시 넣어주기.
		if (ComIsDate(selEffDt)) {
			selEffDt = selEffDt.replace(/-/gi, "");
			selEffDt = selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
			
			document.form.eff_dt.value = selEffDt;

			comboObj.SetText(selectedMotTrfSeq, 4, selEffDt);
		} else {
			ComShowCodeMessage("COM12134", "Effective Date");
			document.form.mot_trf_seq.focus();
			return false;
		}
		
	}
	

    /**
     * 화면 전체를 리셋한다.<br>
     * 데이터가 변경된 경우 저장한다.
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj,gubun)
     * </pre>
     * @param {form} formObj 
     * @param {String} gubun    
     * @return boolean
     * @author 이승준
     * @version 2009.06.10
     */
	function removeAll(formObj) {
		if (sheet1.IsDataModified ) {
			
			if (ComShowCodeConfirm("PRI00006")) {
				doActionIBSheet(sheet1, formObj, IBSAVE);
				return false;
			} else {
		 		sheet1.RemoveAll();
		 		return true;
			}
		} else {	
	 		sheet1.RemoveAll();
	 		return true;
		}
		
	}
	
	/**
    * sheet를 클릭시 발생한다.<br>
    * 체크박스를 언체크 한다.
    * <br><b>Example :</b>
    * <pre>
    *     sheet1_OnClick(sheetObj, Row, Col, Value)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 
    * @param {int} Col   
    * @param {String} Value   
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
	function sheet1_OnClick(sheetObj, Row, Col, Value)  {
 	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
 	    var formObj = document.form;
 	    var colname = sheetObj.ColSaveName(Col);  	 
 	    //var amdtSeq = formObj.amdt_seq.value;
 	    //var propStsCd = formObj.prop_sts_cd.value;
 	    
      	switch(colname)
      	{
      		case "mot_trf_rmk":
	    		sheetObj.CellEditable(Row,"mot_trf_rmk") = false;
	    		ComShowMemoPad(sheetObj, Row, Col, false, 550);
	    		break; 
      		case "chk" :
    			if (Value == "0") {
    				sheetObj.CellValue(Row, "del_chk") = "0";
    			}
    			break;
      	}
      	
	}
	/**
    * OnSaveEnd 시 발생한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     searchConditionReset(formObj,gubun)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {String} ErrMsg    
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
		if (ErrMsg == "") {
			ComPriSaveCompleted();
			//doActionIBSheet(sheet1,document.form,IBSEARCH);
		}
	}
	


  	
	/* 개발자 작업  끝 */