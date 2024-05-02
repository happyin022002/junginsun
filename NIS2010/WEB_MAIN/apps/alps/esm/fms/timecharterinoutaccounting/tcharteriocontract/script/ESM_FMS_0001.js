/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0001.js
*@FileTitle : Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.12
*@LastModifier : 전상화
*@LastVersion : 1.3
* 2009.04.22 정윤태
* 1.0 최초 생성 
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
* History
* 2011.04.26 표준희 [CHM-201110435-01] 탭 (CP File up, Certi File up) Updae 날자 조회되게 처리
* 2012.06.12 전상화 [CHM-201218110-01] CP Period 단위 1)수정 GMT -> UTC, 2) LMT 삭제, 3)UTC로 고정
* 2013.06.10 이영두 [CHM-201324825] Customer Code Logic 변경 및 Agreement Pop up 변경
* 2014.09.25 민정호 [] [FMS] 10만불 비용지급 결재건 관련 3차 - G/W 계약문서 연계 개발
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview Agreement Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     * @author 한진해운
     */

    /** 
     * @extends FMS
     * @class AgreementCreation : Agreement Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0001() {
    	this.initControl        	= initControl;
        this.declaration_click		= declaration_click;
        this.validateForm       	= validateForm;
        this.eng_keypress			= eng_keypress;
        this.cust_seq_change		= cust_seq_change;
        this.obj_deactivate			= obj_deactivate;
        this.obj_activate			= obj_activate;
        this.obj_keypress			= obj_keypress;
        this.setOwnerCode			= setOwnerCode;
        this.clearAll				= clearAll;
        this.t1sheet1_OnChange		= t1sheet1_OnChange;
        this.processButtonClick 	= processButtonClick;
        this.loadPage				= loadPage;
        this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
        this.vsl_cd_change			= vsl_cd_change;
        this.bod_port_cd_change		= bod_port_cd_change;
        this.bor_port_cd_change		= bor_port_cd_change;
        this.oa_rsv_curr_cd_change 	= oa_rsv_curr_cd_change;
        this.t1sheet1_OnChange		= t1sheet1_OnChange;
        this.t2sheet1_OnChange		= t2sheet1_OnChange;
        this.t3sheet1_OnChange		= t3sheet1_OnChange;
        this.t5sheet1_OnChange		= t5sheet1_OnChange;
        this.t6sheet1_OnChange		= t6sheet1_OnChange;
        this.t7sheet1_OnChange		= t7sheet1_OnChange;
        this.dateTimeOnChange		= dateTimeOnChange;
        this.setNextOtrEffDt		= setNextOtrEffDt;
        this.t1sheet1_OnValidation  = t1sheet1_OnValidation;
        this.t2sheet1_OnValidation  = t2sheet1_OnValidation;
        this.t3sheet1_OnValidation  = t3sheet1_OnValidation;
        this.sheet_chekPeriod		= sheet_chekPeriod;
        this.sheet_DataInsert		= sheet_DataInsert;
        this.setOtrEffDt			= setOtrEffDt;
        this.setOtrEffDtCellEditable= setOtrEffDtCellEditable;
        this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
        this.t1sheet1_OnSearchEnd	= t1sheet1_OnSearchEnd;
        this.t2sheet1_OnSearchEnd	= t2sheet1_OnSearchEnd; 
        this.t3sheet1_OnSearchEnd	= t3sheet1_OnSearchEnd;
        this.t7sheet1_OnSearchEnd	= t7sheet1_OnSearchEnd;
        this.t1sheet1_OnSaveEnd		= t1sheet1_OnSaveEnd;
        this.t2sheet1_OnSaveEnd		= t2sheet1_OnSaveEnd;
        this.t3sheet1_OnSaveEnd		= t3sheet1_OnSaveEnd;
        this.t7sheet1_OnSaveEnd		= t7sheet1_OnSaveEnd;
        this.setFromDateEdit		= setFromDateEdit;
        this.setOriData				= setOriData;
        this.t2sheet1_OnPopupClick	= t2sheet1_OnPopupClick;
        this.t5sheet1_OnPopupClick	= t5sheet1_OnPopupClick;
        this.t6sheet1_OnPopupClick	= t6sheet1_OnPopupClick;
        this.t7sheet1_OnPopupClick	= t7sheet1_OnPopupClick;
        this.t5sheet1_OnClick		= t5sheet1_OnClick;
        this.t6sheet1_OnClick		= t6sheet1_OnClick;
        this.t2sheet1_OnMouseMove	= t2sheet1_OnMouseMove;
        this.t5sheet1_OnMouseMove	= t5sheet1_OnMouseMove;
        this.t6sheet1_OnMouseMove	= t6sheet1_OnMouseMove;
        this.changeMousePointer		= changeMousePointer;
        this.setProgramNo			= setProgramNo;
        this.setVslCd				= setVslCd;
        this.setGridVslCd			= setGridVslCd;
        this.rowRemove				= rowRemove;
        this.getFirstRow			= getFirstRow;
        this.getLastRow				= getLastRow;
        this.getLeastValue			= getLeastValue;
        this.getGreatestValue		= getGreatestValue;
        this.getOtrGreatestValue	= getOtrGreatestValue;
        this.setFileUpload			= setFileUpload;
        this.delConfirm				= delConfirm;
        this.currencyOnChange		= currencyOnChange;
        this.currency2OnChange		= currency2OnChange;
        this.currency_code_check	= currency_code_check;
        this.setCustomrCode			= setCustomrCode;
        this.setVendorCode			= setVendorCode;
        this.setPayTermMakeCombo	= setPayTermMakeCombo;
        this.setDataCombo			= setDataCombo;
        this.checkAttachFile		= checkAttachFile;
        this.flet_ctrt_tp_cd_OnChange	  = flet_ctrt_tp_cd_OnChange;
        this.setFirstOtrEffDtCellEditable = setFirstOtrEffDtCellEditable;
        this.t7sheet1_OnClick		= t7sheet1_OnClick;
        this.setOwnerCodeReadOnly	= setOwnerCodeReadOnly;
        this.setInitCellProperty	= setInitCellProperty;
        this.setBodPortCd			= setBodPortCd;
        this.setBorPortCd			= setBorPortCd;
    }

    // 공통전역변수  
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var uploadObjects = new Array();
	var uploadCnt = 0;
	
	var ownr_seq = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
    	 var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var sheetObject4 = sheetObjects[3];
         var sheetObject5 = sheetObjects[4];
         var sheetObject6 = sheetObjects[5];
         var sheetObject7 = sheetObjects[6];
		 var sheetObject8 = sheetObjects[7];
         
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	
            	case "btn_creation":
            		sheetObject5.RowStatus(1)= "I";
            		doActionIBSheet(sheetObject2,formObject,IBINSERT);
                    break;

				case "btn_retrive":
					if(!initConfirm()) return;
					
					doActionIBSheet(sheetObject2,formObject,IBSEARCH);
					break;

				case "btn_new":
					if(!initConfirm()) return;
					
					formObject.flet_olay_comm_rt_amt.value = "2.5";
					clearAll();
					break;

				case "btn_save":
					sheetObject5.RowStatus(1)= "U";
					doActionIBSheet(sheetObject5,formObject,IBSAVE);
					break;

				case "btn_delete":
					doActionIBSheet(sheetObject5,formObject,IBDELETE);
					break;

					
                case "btn_add":

                    sheet_DataInsert(sheetObject2,'hir_');
                    break;

				case "btn_del":
					
					if(checkBoxCheckYn(sheetObject2, "hir_DelChk")) {
						rowRemove(sheetObject2, "hir_");
					}
                    break;

				case "btn_t2Add":
					sheet_DataInsert(sheetObject3,'otr_');
					
                    break;

				case "btn_t2Ins":
					alert("btn_t2Ins");
                    sheetObject3.DataInsert();
                    break;

				case "btn_t2Del":
					if(checkBoxCheckYn(sheetObject3, "otr_DelChk")) {
						rowRemove(sheetObject3, "otr_");
					}
                    break;

				case "btn_t3Add":
					sheet_DataInsert(sheetObject4,'pay_');

                    break;

				case "btn_t3Ins":
					alert("btn_t3Ins");
                    sheetObject4.DataInsert();
                    break;

				case "btn_t3Del":
					if(checkBoxCheckYn(sheetObject4, "pay_DelChk")) {
						rowRemove(sheetObject4, "pay_");
					}
                    break;
                    
				case "btn_t5Add":
					sheet_DataInsert(sheetObject6,'cpf_');

                    break;
                    
				case "btn_t5Ins":
					sheet_DataInsert(sheetObject6,'cpf_','Ins');

                    break;

				case "btn_t5E-mail":
					
					var fileKey = checkAttachFile(sheetObject6, 'cpf_');
					
					if(fileKey == "") return;
					
					var vsl_eng_nm = formObject.vsl_eng_nm.value;
					var subject = "Charter Party ("+vsl_eng_nm+")";
					
					ComOpenPopup("ESM_FMS_0079.do?mailFlg=CON&subject="+subject+"&fileKey="+fileKey, 400, 456, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0079");
					
					//ComOpenPopup("ESM_FMS_0079.do?mailFlg=CON&subject="+subject+"&fileKey="+fileKey, 400, 166, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0079");
					break;

				case "btn_t5Download":
					alert("btn_t5Download");
					break;
					
				case "btn_t5FiletoEmail":
					alert(srcName);
					break;

				case "btn_t5Open":
					alert("btn_t5Open");
					break;

				case "btn_t5Delete":
					if(checkBoxCheckYn(sheetObject6, "cpf_DelChk")) {
						rowRemove(sheetObject6, "cpf_");
					}
					break;
					
				case "btn_t6Add":
					sheet_DataInsert(sheetObject7,'cef_');
 
                    break;
                    
				case "btn_t6Ins":
					sheet_DataInsert(sheetObject7,'cef_','Ins');
 
                    break;

				case "btn_t6E-mail":
					var fileKey = checkAttachFile(sheetObject7, 'cef_');
					
					if(fileKey == "") return;
					
					var vsl_eng_nm = formObject.vsl_eng_nm.value;
					var subject = "Certificate ("+vsl_eng_nm+")";
					
					ComOpenPopup("ESM_FMS_0079.do?mailFlg=CON&subject="+subject+"&fileKey="+fileKey, 400, 456, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0079");
					break;

				case "btn_t6Download":
					alert("btn_t6Download");
					break;

				case "btn_t6Open":
					alert("btn_t6Open");
					break;

				case "btn_t6Delete":
					if(checkBoxCheckYn(sheetObject7, "cef_DelChk")) {
						rowRemove(sheetObject7, "cef_");
					}
					break;

				case "btn_t7Add":
					
					if(formObject.vsl_cd.value == "") {
						 ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01138'));
						 return;
					}
					
					sheet_DataInsert(sheetObject8,'vsl_');

                    break;

				case "btn_t7Ins":
                    sheetObject8.DataInsert();
                    break;
                   
				case "btn_t7Del":
					if(checkBoxCheckYn(sheetObject8, "vsl_DelChk")) {
						rowRemove(sheetObject8, "vsl_");
					}
                    break;		
                    	
				      
				case "cp_da":
	                    var cal = new ComCalendar();
	                    cal.select(form.cp_dt, 'yyyy-MM-dd');
	                    break;
				
				case "ef_dt":
					var cal = new ComCalendar();
					cal.select(form.ori_eff_dt, 'yyyy-MM-dd');
				 break;
				 
				case "vsl_bld_da": 
					var cal = new ComCalendar();
					cal.select(form.vsl_bld_dt, 'yyyy-MM-dd');
				 break;

				case "btn_vslpop" :

					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0022");
				break;
					 
				case "contract_no":
					 if(formObject.vsl_cd.value == "") {
						 ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01138'));
						 return;
					 }
					 
					 ComOpenPopupWithTarget("ESM_FMS_0023.do?ctrtFlag=Y&vsl_cd=" + formObject.vsl_cd.value, 520, 405, "flet_ctrt_no:flet_ctrt_no", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0023");
					 break;
				 
				case "ex_dt":
					var cal = new ComCalendar();
					cal.select(form.ori_exp_dt, 'yyyy-MM-dd');	
					break;
					 
				case "owner_code":
					if(comboObjects[0].Code == "TO") {  //520, 433
						ComOpenPopup("ESM_FMS_0070.do?condFlag=CP&agmtFlag=C", 520, 430, "setCustomrCode", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0070");						
					} else {						
						ComOpenPopup("ESM_FMS_0070.do?condFlag=VP&agmtFlag=C", 520, 430, "setVendorCode", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0070");
					}
					break;
					
				case "btn_ownr_nm":
					ComOpenPopup("ESM_FMS_0083.do?condFlag=CP&agmtFlag=C", 500, 370, "setOwnrNm", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0083");
					break;
					
				case "flag_code": 
					ComOpenPopup("COM_ENS_0M1.do", 565, 445, "setFlagCode", "1,0,1,1,1,1", false, false, 0, 0, 0, "COM_ENS_0M1");
					break;
					
				case "img_bod_port_cd": 
					ComOpenPopup("COM_ENS_051.do", 720, 480, "setBodPortCd", "1,0,1,1,1,1", true, false, 0, 0, 0, "COM_ENS_051");
					break;
					
				case "img_bor_port_cd": 
					ComOpenPopup("COM_ENS_051.do", 720, 480, "setBorPortCd", "1,0,1,1,1,1", true, false, 0, 0, 0, "COM_ENS_051");
					break;
					
				case "btn_gw":
					fnDocOpen("item");
					break;			
					
				case "btng_del":	
					sheetObjects[8].RemoveAll();					
	                sheetObjects[8].DataInsert();		
	                						                
					sheetObjects[8].RowStatus(1)= "U";					
					doActionIBSheet(sheetObjects[8],formObject,IBCLEAR);					
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
     * 페이지에 생성된 IBMultiCombo Object를 comboObjects 배열에 등록한다. <br>
     * comboObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComComboObject} 함수에 의해서 IBMultiCombo Object가 생성되면서 자동 호출된다. <br>
     * @param {ibmulticombo} combo_obj    IBMultiCombo Object
     **/
    function setComboObject(combo_obj){          
       comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	
        for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);

            initSheet(sheetObjects[i],i);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
            
            //마지막 컬럼을 전체 너비에 맞춘다.
            sheetObjects[i].ExtendLastCol = false;
        }
		
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        //UPLOAD 환경 설정
        for(var i=0;i<uploadObjects.length;i++){
		    //1. 기본 환경 설정
		    ComConfigUpload(uploadObjects[i], "/hanjin/ESM_FMS_0001GS.do");
		
		    //2. Upload 초기화
		    //initUpload(uploadObjects[i],i+1);
		}
        
        //html컨트롤 이벤트초기화
        initControl();
    }
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function t1sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObjects[3], document.form, IBROWSEARCH, "ComCd");
    	
    	
		sheetObj.WaitImageVisible = true;   
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetObj.id) {
        	case "sheet1":      //sheet1 init
        		with (sheetObj) {
                	var prefix = "oli_";
                	
                	//AutoSizeMode=false;
                	
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    //SheetWidth = mainTable.clientWidth;
                	SheetWidth = 665;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, false, false, false)

                    var HeadTitle = "Item Name|From Date|To Date|Cur|Amount";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    	[ROW, COL,  DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  	   			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    InitDataProperty(0, cnt++ , dtData,      	134,   daLeft,    false,    prefix + "acct_itm_nm",		false,          "",      	dfNone,      0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,    prefix + "eff_dt",    		false,          "",      	dfDateYmd,   0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,    prefix + "exp_dt",     		false,          "",      	dfDateYmd,   0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,    prefix + "curr_cd",     	false,          "",      	dfEngUpKey,  0,     true,       true,	3);
					InitDataProperty(0, cnt++ , dtData,      	240,   daRight,   false,    prefix + "otr_expn_amt",	false,          "",      	dfNullFloat, 2,     true,       true,	13);
					
					CountPosition = 0;
					FitColWidth("32|13|13|8|34");
					//날짜구분자를 설정한다.
					//DateFormatChar = "/";

                }
                break;
                
            case "t1sheet1":      //t1sheet1 init
                with (sheetObj) {
                	var prefix = "hir_";
                	
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                    InitHeadMode(false, true, true, true, false, false)

                    //var HeadTitle = "|Seq|Sel|From Date|To Date|Cur 1|Daily Hire|Cur 2|Daily Hire|Cur 2 Apply|Ori From Date|Ori To Date ";
                    var HeadTitle = "|Sel|Seq|From Date|To Date|Cur 1|Daily Hire|Cur 2|Daily Hire|Ori From Date|Ori To Date ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  true,    prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,   40,    daCenter,  false,   prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,    		40,    daCenter,  true,    prefix + "Seq");
					InitDataProperty(0, cnt++ , dtData,      	187,   daCenter,  false,   prefix + "eff_dt",   		true,           "",      dfUserFormat2,     0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	187,   daCenter,  false,   prefix + "exp_dt",     		true,           "",      dfUserFormat2,     0,     true,       true);

					InitDataProperty(0, cnt++ , dtData,      	62,    daCenter,  false,   prefix + "hir_curr_n1st_cd", true,           "",      dfEngUpKey,      	0,     true,       true,	3);
					InitDataProperty(0, cnt++ , dtData,      	134,   daRight,   false,   prefix + "hir_rt_n1st_amt",  true,           "",      dfNullFloat,      	2,     true,       true,	13);
					InitDataProperty(0, cnt++ , dtData,      	62,    daCenter,  false,   prefix + "hir_curr_n2nd_cd", false,          "",      dfEngUpKey,      	0,     true,       true,	3);
					InitDataProperty(0, cnt++ , dtData,      	134,   daRight,   false,   prefix + "hir_rt_n2nd_amt",  false,          "",      dfNullFloat,      	2,     true,       true,	13);
					//InitDataProperty(0, cnt++ , dtCheckBox,     134,   daCenter,  false,   prefix + "Cur2Apply",     	false,          "",      dfNone,      		0,     true,       true, 	-1, 	false, 	false, "", 	false);
					
					//hidden으로 보관 Start
					InitDataProperty(0, cnt++ , dtHidden,      	187,   daCenter,  false,   prefix + "ori_eff_dt",   	false,          "",      dfUserFormat2,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      	187,   daCenter,  false,   prefix + "ori_exp_dt",     	false,          "",      dfUserFormat2,     0,     true,       true);
					//hidden으로 보관 End
					
					InitUserFormat2(0, prefix + "eff_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "exp_dt", "####-##-## ##:##", "-|:" );
					
					InitUserFormat2(0, prefix + "ori_eff_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "ori_exp_dt", "####-##-## ##:##", "-|:" );
					
					InitDataValid(0, prefix + "hir_curr_n1st_cd", vtEngUpOnly); 
					InitDataValid(0, prefix + "hir_curr_n2nd_cd", vtEngUpOnly);
					
					//날짜구분자를 설정한다.
					//DateFormatChar = "/";

                }
                break;

			case "t2sheet1":      //t2sheet1 init
                with (sheetObj) {
                	var prefix = "otr_";
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false, false)

                    var HeadTitle = "|Sel|Seq|Item Name|Account Code|From Date|To Date|Cur|Amount|Acct Itm Seq|Ori Account Code|Ori From Date|Ori To Date|Ori Acct Itm Seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    										  //134
                    //데이터속성    	[ROW, COL,  DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  	   			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  true,    	prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   40,    daCenter,  false,	prefix + "DelChk");
                    InitDataProperty(0, cnt++ , dtSeq,    		40,    daCenter,  true,    	prefix + "Seq");
                    InitDataProperty(0, cnt++ , dtPopup,      	252,   daLeft,    false,    prefix + "acct_itm_nm",		true,           "",      	dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,  false,    prefix + "acct_cd",			true,           "",      	dfNone,      0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	161,   daCenter,  false,    prefix + "eff_dt",    		true,           "",      	dfDateYmd,   0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	161,   daCenter,  false,    prefix + "exp_dt",     		true,           "",      	dfDateYmd,   0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	62,    daCenter,  false,    prefix + "curr_cd",     	true,           "",      	dfEngUpKey,  0,     true,       true,	3);
					InitDataProperty(0, cnt++ , dtData,      	99,    daRight,   false,    prefix + "otr_expn_amt",	true,           "",      	dfNullFloat, 2,     true,       true,	13);
					InitDataProperty(0, cnt++ , dtHidden,      	134,   daCenter,  false,    prefix + "acct_itm_seq",	false,          "",      	dfNone,      0,     true,       false);
					
					InitDataProperty(0, cnt++ , dtHidden,      	134,   daCenter,  false,    prefix + "ori_acct_cd",		false,          "",      	dfNone,      0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	161,   daCenter,  false,    prefix + "ori_eff_dt",  	false,          "",      	dfDateYmd,   0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      	161,   daCenter,  false,    prefix + "ori_exp_dt",  	false,          "",      	dfDateYmd,   0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      	134,   daCenter,  false,    prefix + "ori_acct_itm_seq",false,          "",      	dfNone,      0,     true,       false);
					
					DataLinkMouse(prefix + "acct_itm_nm") = true;
					InitDataValid(0, prefix + "curr_cd", vtEngUpOnly); 
					
					//날짜구분자를 설정한다.
					//DateFormatChar = "/";
					
					ShowButtonImage = 1;
                }
                break;

			case "t3sheet1":      //t3sheet1 init
                with (sheetObj) {
                	
                	var prefix = "pay_";
                	
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false, false)

                    var HeadTitle = "|Sel|Seq|Payment Term|From Date|To Date|Ori_From Date|Ori_To Date ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  true,    prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   40,    	daCenter,  false,   prefix + "DelChk");
                    InitDataProperty(0, cnt++ , dtSeq,    		40,    	daCenter,  true,    prefix + "Seq");
                    InitDataProperty(0, cnt++ , dtCombo,      	419,    daCenter,  false,   prefix + "ctrt_pay_term_cd",    false,          "",      dfNone,      		0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      	223,    daCenter,  false,   prefix + "eff_dt",     			true,           "",      dfUserFormat2,     0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	223,    daCenter,  false,   prefix + "exp_dt",     			true,           "",      dfUserFormat2,     0,     true,       true);	
					
					//hidden으로 보관 Start
					InitDataProperty(0, cnt++ , dtHidden,      	187,   daCenter,  false,   prefix + "ori_eff_dt",   		false,          "",      dfUserFormat2,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      	187,   daCenter,  false,   prefix + "ori_exp_dt",     		false,          "",      dfUserFormat2,     0,     true,       true);
					//hidden으로 보관 End
					
					//InitDataCombo(0, prefix + "ctrt_pay_term_cd", "Semi Month|15 days|Month", "A|B|C", "Semi Month", "A");
					
					InitUserFormat2(0, prefix + "eff_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "exp_dt", "####-##-## ##:##", "-|:" );
					
					InitUserFormat2(0, prefix + "ori_eff_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "ori_exp_dt", "####-##-## ##:##", "-|:" );
					
					//날짜구분자를 설정한다.
					//DateFormatChar = "/";

                }
                break;

			case "t4sheet1":      //t4sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 120;	//60
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Period ( + - Option)|Redelivery Range|Redelivery Notice ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [	ROW, COL,  DATATYPE,   WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,  	KEYFIELD, CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  	"ibflag");
                    InitDataProperty(0, cnt++ , dtData,      	317,    daLeft,  	false,     	"chtr_prd_opt_ctnt",    false,          "",      dfNone,      0,     	true,       true,	100);
                    InitDataProperty(0, cnt++ , dtData,      	367,    daLeft,  	false,     	"rde_rng_ctnt",      	false,          "",      dfNone,      0,     	true,       true, 	100);
					InitDataProperty(0, cnt++ , dtData,      	277,    daLeft,  	false,     	"rde_ntc_ctnt",     	false,          "",      dfNone,      0,     	true,       true,	100);

					ShowButtonImage = 1;
                }
                break;

			case "t5sheet1":      //t5sheet1 init
                with (sheetObj) {
                	var prefix = "cpf_";
                	
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel|CP File Upload|From|To|Contents|File Path|File Chtr Tp Cd|File Seq|File Download|File Sav Id|Update ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  true,	prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,   40,		daCenter,  false,   prefix + "DelChk");
                    InitDataProperty(0, cnt++ , dtPopup,      	320,    daLeft,    false,   prefix + "file_nm",     	true,           "",      dfNone,      0,     false,		true,	50);
                    InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,  false,   prefix + "eff_dt",    		false,          "",      dfDateYmd,   0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,  false,   prefix + "exp_dt",     		false,          "",      dfDateYmd,   0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,      	320,    daLeft,    false,   prefix + "file_desc",   	false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_path",   	false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,     	108,    daCenter,  false,   prefix + "flet_file_tp_cd", false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_seq",   		false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtImage,      	100,   	daCenter,  false,   prefix + "file_download",   false,          "",      dfNone,      0,     false,		true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_sav_id",   	false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,     	108,    daCenter,  false,   prefix + "upd_dt",   	    false,          "",      dfNone,      0,     false,     false);
                    
                    
                    //InitDataProperty(0, cnt++ , dtCheckBox,     108,    daCenter,  false,   prefix + "Check",     	false,          "",      dfNone,      0,     true,      true);
                    //InitUserFormat2(0, prefix + "upd_dt", "####-##-## ##:##", "-|:" );
                    ColHidden(prefix + "flet_file_tp_cd") = true;
                    InitDataCombo(0,prefix + "flet_file_tp_cd","CP","CP","CP");
                    
                    //mouse 손가락 모양으로 만들기
                    //DataLinkMouse(prefix + "file_nm") = true;
                    //DataLinkMouse(prefix + "file_download") = true;
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
					ShowButtonImage = 1;
                }
                break;

			case "t6sheet1":      //t6sheet1 init
                with (sheetObj) {
                	var prefix = "cef_";
                	
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel|Certi File Upload|From|To|Contents|File Path|File Chtr Tp Cd|File Seq|File Download|File Sav Id|Update ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,  true,	prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,   40,    	daCenter,  false,   prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtPopup,      	320,    daLeft,    false,   prefix + "file_nm",     	true,           "",      dfNone,      0,     false,		true,	50);
					InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,  false,   prefix + "eff_dt",    		false,          "",      dfDateYmd,   0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,  false,   prefix + "exp_dt",     		false,          "",      dfDateYmd,   0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,      	320,    daLeft,    false,   prefix + "file_desc",   	false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_path",   	false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,     	108,    daCenter,  false,   prefix + "flet_file_tp_cd", false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_seq",   		false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtImage,      	100,    daCenter,  false,   prefix + "file_download",   false,          "",      dfNone,      0,     false,		true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_sav_id",   	false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,     	108,    daCenter,  false,   prefix + "upd_dt",   	    false,          "",      dfNone,      0,     false,     false);
                    
                    //InitDataProperty(0, cnt++ , dtCheckBox,     108,    daCenter,  false,   prefix + "Check",     	false,          "",      dfNone,      0,     true,       true);
                    
                    ColHidden(prefix + "flet_file_tp_cd") = true;
                    InitDataCombo(0,prefix + "flet_file_tp_cd","CF","CF","CF");
                    //DataLinkMouse(prefix + "file_nm") = true;
                    //DataLinkMouse(prefix + "file_download") = true;
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";

                     
					ShowButtonImage = 1;
                }
                break;   
                 
			case "t7sheet1":      //t7sheet1 init
                with (sheetObj) {
                	
                	var prefix = "vsl_";
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel|Vessel Code|Vessel Name|Accounting|Report|Ori Vessel Code|Ori Vessel Name";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  true,    	 prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,   40,    daCenter,  false,     prefix + "DelChk");
                    InitDataProperty(0, cnt++ , dtPopup,        320,   daCenter,  false,     prefix + "vsl_cd",    	 	true,           "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         400,   daLeft,    false,     prefix + "vsl_eng_nm",     false,          "",      dfNone,      0,     false,      false);
					InitDataProperty(0, cnt++ , dtCheckBox,  	80,    daCenter,  false,     prefix + "use_flg", 		false,          "",      dfNone,      0,     true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,  	80,    daCenter,  false,     prefix + "flet_rpt_flg", 	false,          "",      dfNone,      0,     true,       true);
					
					InitDataProperty(0, cnt++ , dtHidden,       400,   daCenter,  false,     prefix + "ori_vsl_cd",    	false,          "",      dfNone,      0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,       400,   daCenter,  false,     prefix + "ori_vsl_eng_nm", false,          "",      dfNone,      0,     false,      false);
					
					DataLinkMouse(prefix + "vsl_cd") = true;
					
					ShowButtonImage = 1;

                }
                break; 
                
        	case "sheet2":      //sheet1 init
        		with (sheetObj) {
                	var prefix = "";
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                	SheetWidth = 665;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, false, false, false)

                    var HeadTitle = "|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  true,    	 prefix + "ibflag");
                }
                break;                                
        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function doActionIBSheet(sheetObj,formObj,sAction,gubun,row) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        
	        case IBSEARCH:      //조회  
	        	
	        	var arrSheet = new Array();
	        	
	        	if(formObj.vsl_cd.value == "") {
	        		ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01138'));
		    		return;
	        	} else if(formObj.flet_ctrt_no.value == "") {
	        		ComAlertFocus(formObj.flet_ctrt_no, ComGetMsg('FMS01052'));
		    		return;
	        	}
	        	
	        	formObj.contract_no.style.cursor = "default";
   				document.images["contract_no"].name = "no_contract_no";
   				form.flet_ctrt_tp_cd.Enable = false; 
	        	
	        	formObj.f_cmd.value = SEARCH;
	        	
	        	var aryPrefix = new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");
	
	        	//var arrSheets = new Array(sheetObjects[1], sheetObjects[2], sheetObjects[3], sheetObjects[4]);   			
	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0001GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));

				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);
				if (arrXml.length > 1) sheetObjects[2].LoadSearchXml(arrXml[1]);	
				if (arrXml.length > 2) sheetObjects[3].LoadSearchXml(arrXml[2]);	
				if (arrXml.length > 3) sheetObjects[4].LoadSearchXml(arrXml[3]);
				if (arrXml.length > 4) sheetObjects[5].LoadSearchXml(arrXml[4]);
				if (arrXml.length > 5) sheetObjects[6].LoadSearchXml(arrXml[5]);
				if (arrXml.length > 6) sheetObjects[7].LoadSearchXml(arrXml[6]);
				if (arrXml.length > 7) sheetObjects[0].LoadSearchXml(arrXml[7]);
				
				//*********** CONTRACT 테이블의 정보 가져오기(START) ***************//
				if(typeof sheetObjects[1].EtcData("fletCtrtNo") != "undefined") {
					tabObjects[0].SelectedIndex = 0;
					
					document.all.btn_creation.style.display = "none";					
		        	document.all.btn_save.style.display = "";
		        	document.all.btn_delete.style.display = "";
		        			        	
		        	document.all.btn_creation2.style.display = "none";							        	
		        	document.all.btn_save2.style.display = "";
		        	document.all.btn_delete2.style.display = "";
				}
				
				//ComEtcDataToForm2(form,sheetObj,sPrefix,bValueClear)
				ComEtcDataToForm2(formObj,sheetObjects[1],"",true);
				//alert("one=" + ComEtcDataToForm2(formObj,sheetObjects[1],"",true));
				
				if(typeof sheetObjects[1].EtcData("declFlg") != "undefined") {
					if(sheetObjects[1].EtcData("declFlg") == "Y") {
						formObj.decl_flg.checked = true;
					} else {
						formObj.decl_flg.checked = false;
					}
				}
				
				if(sheetObjects[1].EtcData("fletCtrtTpCd") == "TO") {
					if(typeof sheetObjects[1].EtcData("custSeq") != "undefined") {
						formObj.cust_seq.value = sheetObjects[1].EtcData("custSeq");
						formObj.cust_cnt_cd.readOnly = false;
					}
				} else {
					if(typeof sheetObjects[1].EtcData("vndrSeq") != "undefined") {
						formObj.cust_seq.value = sheetObjects[1].EtcData("vndrSeq");
						formObj.cust_cnt_cd.readOnly = true;
						formObj.cust_cnt_cd.value = "";
					}
				}
				
				if(comboObjects[1].Code == "ACT") {
					form.flet_ctrt_fact_cd.Enable = false; 
					
					setOwnerCodeReadOnly();
				}
				
				//*********** Hire 테이블의 정보 가져오기(START) ******************//
				
				//ComEtcDataToForm2(form,sheetObj,sPrefix,bValueClear)
				ComEtcDataToForm2(formObj,sheetObjects[1],"hir_",true);
				
				//*********** Hire 테이블의 정보 가져오기(END) ******************//
								
				
				if( form.flet_gmt_lmt_cd.value == "G") {
					form.flet_gmt_lmt_view.value = "UTC";
				} else {
					form.flet_gmt_lmt_view.value = "LMT";
				}
				
				if(typeof sheetObjects[1].EtcData("fletCtrtNo") != "undefined") {
					formObj.agmt_doc_no.value = sheetObjects[1].EtcData("agmtDocNo");			// GW문서
					formObj.agmt_doc_desc.value = sheetObjects[1].EtcData("agmtDocDesc");		// GW문서명			
				}
	        	
	           break;

		   case IBINSERT:        //저장    // IBsheet 그리드에 없을시 칼럼명과 동일하게 입력 폼
				 
			   if(!validateForm(sheetObj,formObj,sAction))  return true;
		       
		       formObj.contract_no.style.cursor = "default";
		       document.images["contract_no"].name = "no_contract_no";
		       form.flet_ctrt_tp_cd.Enable = false;
		       
			   formObj.f_cmd.value = MODIFY;
			   formObj.ibflag.value = "I";
			   
			   //1.IBUpload에 파일 추가하기
			   var upObj = uploadObjects[0];
	
			   upObj.Files="";	//-먼저기존파일을 모두 지운후 추가함

			   var paramFile1 = setFileUpload(sheetObjects[5], "cpf_");
			   var paramFile2 = setFileUpload(sheetObjects[6], "cef_"); 

			   if (upObj.LocalFiles == "") {
			   
				   var arrSheets = new Array(sheetObjects[1], sheetObjects[2], sheetObjects[3], sheetObjects[4], sheetObjects[5], sheetObjects[6], sheetObjects[7]);
				   var sParam = ComGetSaveString(arrSheets);
					
				   //if (sParam == "") return;
					
				   var aryPrefix = new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");
	
				   sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix) + "&ownr_seq=" + ownr_seq;
					 					 
				   var sXml = sheetObj.GetSaveXml("ESM_FMS_0001GS.do", sParam);
				   
			   } else {
				    //2.IBSheet 데이터 QueryString으로 묶기
					var arrSheets = new Array(sheetObjects[1], sheetObjects[2], sheetObjects[3], sheetObjects[4], sheetObjects[5], sheetObjects[6], sheetObjects[7]);
					var sParam = ComGetSaveString(arrSheets, true);
					if (sParam == "") return;
	
					//3.Form 데이터 QueryString으로 묶기				
					var aryPrefix = new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");				
					//sParam += "&" + FormQueryStringOrg(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix) + "&ownr_seq=" + ownr_seq;
					sParam += "&" + paramFile1 + "&" + paramFile2;
										
					//4. 서버에 request전달하고, reponse 받기
					upObj.ExtendParam = sParam;
					
					upObj.ParamDecoding = true;

					var sXml = upObj.DoUpload(true);
			   }
			   
			   var arrXml = sXml.split("|$$|");
			   
			   if (arrXml.length > 0) sheetObjects[1].LoadSaveXml(arrXml[0]);
			   if (arrXml.length > 1) sheetObjects[2].LoadSaveXml(arrXml[1]);	
			   if (arrXml.length > 2) sheetObjects[3].LoadSaveXml(arrXml[2]);	
			   if (arrXml.length > 3) sheetObjects[4].LoadSaveXml(arrXml[3]);
			   if (arrXml.length > 4) sheetObjects[5].LoadSaveXml(arrXml[4]);
			   if (arrXml.length > 5) sheetObjects[6].LoadSaveXml(arrXml[5]);
			   if (arrXml.length > 6) sheetObjects[7].LoadSaveXml(arrXml[6]);
			   if (arrXml.length > 7) sheetObjects[0].LoadSearchXml(arrXml[7]);
			   
			   if(comboObjects[1].Code == "ACT") {
					form.flet_ctrt_fact_cd.Enable = false; 
					
					setOwnerCodeReadOnly();
				}

			   ComEtcDataToForm2(formObj,sheetObjects[1],"hir_",true);
	 
			   if(typeof sheetObj.EtcData("fletCtrtNo") != "undefined") {
				   //저장완료 후 처리(XML을 통해서 조회된 기타 정보를 TextBox에 설정한다.)
				   formObj.flet_ctrt_no.value = sheetObj.EtcData("fletCtrtNo");	            	
				   document.all.btn_creation.style.display = "none";				   
				   document.all.btn_save.style.display = "";
				   document.all.btn_delete.style.display = "";
				   
				   document.all.btn_creation2.style.display = "none";				   
				   document.all.btn_save2.style.display = "";
				   document.all.btn_delete2.style.display = "";
               }

			   if(typeof sheetObj.EtcData("fletCtrtNo") != "undefined") {
				   formObj.agmt_doc_no.value = sheetObj.EtcData("agmtDocNo");						// GW문서
				   formObj.agmt_doc_desc.value = sheetObj.EtcData("agmtDocDesc");				// GW문서명   
			   }
			   
				break;

			case IBSAVE:      // 저장
				
				if(!validateForm(sheetObj,formObj,sAction))  return true;

				if(!ComShowConfirm(ComGetMsg("FMS00017"))){
					return;
				}				
				
				formObj.f_cmd.value = MULTI;
				formObj.ibflag.value = "U";
				
				//1.IBUpload에 파일 추가하기
				var upObj = uploadObjects[0];
	
				upObj.Files="";	//-먼저기존파일을 모두 지운후 추가함

				var paramFile1 = setFileUpload(sheetObjects[5], "cpf_");
				var paramFile2 = setFileUpload(sheetObjects[6], "cef_"); 

							
				if (upObj.LocalFiles == "") {
					//alert("if");
					/*******파일이 없는 경우 IBSheet 이용하기********/
					
					//2.IBSheet 데이터 QueryString으로 묶기
					var arrSheets = new Array(sheetObjects[1], sheetObjects[2], sheetObjects[3], sheetObjects[4], sheetObjects[5], sheetObjects[6], sheetObjects[7]);
					var sParam = ComGetSaveString(arrSheets);
					
					if (sParam == "") return;
					
					//3.Form 데이터 QueryString으로 묶기
					var aryPrefix = new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");
					
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix) + "&ownr_seq=" + ownr_seq;

					ComOpenWait(true);
					
					//4. 서버에 request전달하고, reponse 받기
					var sXml = sheetObj.GetSaveXml("ESM_FMS_0001GS.do", sParam);
				
				} else {
					//alert("else");
					/*******파일이 있는 경우 IBUpload 이용하기********/
					//alert(upObj.LocalFiles);
					//2.IBSheet 데이터 QueryString으로 묶기
					var arrSheets = new Array(sheetObjects[1], sheetObjects[2], sheetObjects[3], sheetObjects[4], sheetObjects[5], sheetObjects[6], sheetObjects[7]);
					var sParam = ComGetSaveString(arrSheets, true);
					if (sParam == "") return;
	
					//3.Form 데이터 QueryString으로 묶기				
					var aryPrefix = new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");				
					//sParam += "&" + FormQueryStringOrg(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix) + "&ownr_seq=" + ownr_seq;
					sParam += "&" + paramFile1 + "&" + paramFile2;
					//ComDebug(sParam);
					ComOpenWait(true);
					
					//4. 서버에 request전달하고, reponse 받기
					upObj.ExtendParam = sParam;
					
					upObj.ParamDecoding = true;

					var sXml = upObj.DoUpload(true);
				}
				
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 0) sheetObjects[1].LoadSaveXml(arrXml[0]);
				if (arrXml.length > 1) sheetObjects[2].LoadSaveXml(arrXml[1]);	
				if (arrXml.length > 2) sheetObjects[3].LoadSaveXml(arrXml[2]);	
				if (arrXml.length > 3) sheetObjects[4].LoadSaveXml(arrXml[3]);
				if (arrXml.length > 4) sheetObjects[5].LoadSaveXml(arrXml[4]);
				if (arrXml.length > 5) sheetObjects[6].LoadSaveXml(arrXml[5]);
				if (arrXml.length > 6) sheetObjects[7].LoadSaveXml(arrXml[6]);
				if (arrXml.length > 7) sheetObjects[0].LoadSearchXml(arrXml[7]);
				
				if(comboObjects[1].Code == "ACT") {
					form.flet_ctrt_fact_cd.Enable = false; 
					
					setOwnerCodeReadOnly();
				}
				
				ComEtcDataToForm2(formObj,sheetObjects[1],"hir_",true);
				
				ComOpenWait(false);
				 
                break;
                
			case IBDELETE:      // 삭제
				if(!delConfirm()) return;
				
				if(!validateForm(sheetObj,formObj,sAction))  return true;
				 
				 formObj.f_cmd.value = REMOVE;
				 formObj.ibflag.value = "D";
				 
				 var sFormParam = FormQueryString(formObj);
				 var sParam = sFormParam;
				 
				 ComOpenWait(true,true);
				 
				 var sXml = sheetObj.GetSaveXml("ESM_FMS_0001GS.do", sParam);
				 
				 ComOpenWait(false);
				 
				 sheetObj.LoadSaveXml(sXml);
				 
				 //화면 초기화
				 clearAll();
				 
                break;
			case IBROWSEARCH:      //조회
	        	
				if(gubun == "ComCd") {
					
					sheetObj.WaitImageVisible = false;
					
					formObj.f_cmd.value = SEARCH04;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0001GS.do" , FormQueryString(formObj));
		   			
		   			var fletCtrtTpCd   = ComGetEtcData(sXml, "fletCtrtTpCd");
		   			var fletCtrtTpNm   = ComGetEtcData(sXml, "fletCtrtTpNm");
		   			
		   			var fletCtrtFactCd = ComGetEtcData(sXml, "fletCtrtFactCd");
		   			var fletCtrtFactNm = ComGetEtcData(sXml, "fletCtrtFactNm");
		   			
		   			var ctrtPayTermCd  = ComGetEtcData(sXml, "ctrtPayTermCd");
		   			var ctrtPayTermNm  = ComGetEtcData(sXml, "ctrtPayTermNm");
	
		   			if(typeof ctrtPayTermCd != "undefined" && ctrtPayTermCd != "") {
		   				
	    				var comboCode = ctrtPayTermCd;
	    				var comboText = ctrtPayTermNm;
	
	    				setPayTermMakeCombo(sheetObj, comboText, comboCode);
	    				
	    			}
		   			
		   			if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != "") {
	    				var comboCode = fletCtrtTpCd;
	    				var comboText = fletCtrtTpNm;

	    				setDataCombo(comboObjects[0], comboText, comboCode);
	    			}
		   			
		   			if(typeof fletCtrtFactCd != "undefined" && fletCtrtFactCd != "") {
	    				var comboCode = fletCtrtFactCd;
	    				var comboText = fletCtrtFactNm;

	    				setDataCombo(comboObjects[1], comboText, comboCode);
	    			}
		   			
		   			sheetObj.WaitImageVisible = true;
		   			
				} else if(gubun == "Owner") {
					
					sheetObj.WaitImageVisible = false;
					
					if(comboObjects[0].Code == "TO") {
			            if(formObj.cust_cnt_cd.value == "") {
			            	ComAlertFocus(formObj.cust_cnt_cd, ComGetMsg('FMS01053'));
				    		return;
			            }
					} else if(comboObjects[0].Code == "OW") {
						formObj.cust_seq.value = "6251";
						formObj.vndr_seq.value = formObj.cust_seq.value;
			        } else {
			        	formObj.vndr_seq.value = formObj.cust_seq.value;
			        }
					
					if(formObj.cust_seq.value == "") {
						formObj.vndr_seq.value = "";
						formObj.vndr_lgl_eng_nm.value = "";
						formObj.ownr_nm.value = "";
		            	//ComAlertFocus(formObj.cust_seq, ComGetMsg('FMS01054'));
			    		return;
		        	}
		        	
		        	formObj.f_cmd.value = SEARCH03;
				
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0001GS.do" , FormQueryString(formObj));
		   			
		   			var ownrNm = ComGetEtcData(sXml, "ownrNm");
		   			var lglEngNm = ComGetEtcData(sXml, "lglEngNm");

					if(typeof ownrNm != "undefined" && ownrNm != "" ) {
						formObj.ownr_nm.value = ownrNm;
						
					} else {
						formObj.cust_seq.value = "";
						formObj.ownr_nm.value = "";
						formObj.vndr_lgl_eng_nm.value = "";
						ComAlertFocus(formObj.cust_seq, ComGetMsg('FMS01055'));
						return;
					}
	
					if(typeof lglEngNm != "undefined" && lglEngNm != "") {
						formObj.vndr_lgl_eng_nm.value = lglEngNm;
					}
					
					sheetObj.WaitImageVisible = true;
					
				} else if(gubun == "Vessel") {
					
					sheetObj.WaitImageVisible = false;
					
			    	if(formObj.vsl_cd.value == "") {
			    		formObj.vsl_eng_nm.value = "";
			    		return;
			    	}
			    	
			    	formObj.f_cmd.value = SEARCH01;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		
		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
		   			
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value = vslEngNm;
		   				formObj.vsl_cd.readOnly = true;
		   				formObj.btn_vslpop.style.cursor = "default";
		   				document.images["btn_vslpop"].name = "no_btn_vslpop";
		   				
					} else {
						formObj.vsl_cd.value = "";
						formObj.vsl_eng_nm.value = "";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
						return;
					}
		   			
		   			sheetObj.WaitImageVisible = true;
		   			
				} else if(gubun == "Flag") {
					
					sheetObj.WaitImageVisible = false;
					
					if(row == "0") {
						if(formObj.cust_cnt_cd.value == "") {
							formObj.cust_seq.value = "";
							formObj.vndr_lgl_eng_nm.value = "";
							formObj.ownr_nm.value = "";
							return;
						}
						
						formObj.cnt_cd.value = formObj.cust_cnt_cd.value;
						
					} else {
						if(formObj.vsl_cnt_cd.value == "") {
							formObj.cnt_nm.value = "";
							return;
						}
						
						formObj.cnt_cd.value = formObj.vsl_cnt_cd.value;
					}
					
					formObj.f_cmd.value = SEARCH02;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		
		   			var vslCntNm = ComGetEtcData(sXml, "vslCntNm");
		   			
		   			if(row == "0") {
		   				if(typeof vslCntNm == "undefined" || vslCntNm == "" ) {
		   					formObj.cust_cnt_cd.value = "";
		   					formObj.cust_seq.readOnly = true;
							ComAlertFocus(formObj.cust_cnt_cd, ComGetMsg('FMS01057'));
							return;
							
		   				} else {
		   					formObj.cust_seq.readOnly = false;
		   					ComSetFocus(formObj.cust_seq);
		   				}
		   			} else {
			   			if(typeof vslCntNm != "undefined" && vslCntNm != "" ) {
			   				formObj.cnt_nm.value = vslCntNm;
			   				
						} else {
							formObj.vsl_cnt_cd.value = "";
							formObj.cnt_nm.value = "";
							ComAlertFocus(formObj.vsl_cnt_cd, ComGetMsg('FMS01057'));
							return;
						}
		   			}
		   			
		   			sheetObj.WaitImageVisible = true;
		   			
				} else if(gubun == "Bod" || gubun == "Bor") {
					
					if(gubun == "Bod") {
						if(formObj.bod_port_cd.value == "") return;
						
						formObj.curr_port_cd.value = formObj.bod_port_cd.value;
					} else {
						if(formObj.bor_port_cd.value == "") return;
						
						formObj.curr_port_cd.value = formObj.bor_port_cd.value;
					}
					
					formObj.f_cmd.value = SEARCH03;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		
		   			var locCd = ComGetEtcData(sXml, "locCd");

		   			if(typeof locCd == "undefined" || locCd == "") {
		   				
		   				if(gubun == "Bod") {
			   				formObj.bod_port_cd.value = "";
			   				ComAlertFocus(formObj.bod_port_cd, ComGetMsg('FMS01233'));
		   				} else {
		   					formObj.bor_port_cd.value = "";
			   				ComAlertFocus(formObj.bor_port_cd, ComGetMsg('FMS01233'));
		   				}
	    			}
		   			
				} else {
			    	
					sheetObj.WaitImageVisible = false;
					
					formObj.f_cmd.value = SEARCH01;
					
					if(gubun == "OaRsvCurrCd") {
						if(formObj.oa_rsv_curr_cd.value == "") return;
						
						formObj.curr_cd.value = formObj.oa_rsv_curr_cd.value;
					}
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0076GS.do" , FormQueryString(formObj));
		
		   			var currCd = ComGetEtcData(sXml, "currCd");

		   			if(typeof currCd == "undefined" || currCd == "") {
		   				if(gubun == "OaRsvCurrCd") {
		   					formObj.oa_rsv_curr_cd.value = "";
		   					ComAlertFocus(formObj.oa_rsv_curr_cd, ComGetMsg('FMS01058'));
		   					
		   				} else {
		   					ComShowMessage(ComGetMsg('FMS01058'));
		   					
			   				if(gubun == "hirCurrN1stCd") {
			   					var prefix = "hir_";
			   					var hirCurrN1stCdCol = sheetObj.SaveNameCol(prefix + "hir_curr_n1st_cd");
			   					
			   					sheetObj.CellValue2(row,hirCurrN1stCdCol) = "";
			   					sheetObj.SelectCell(row,hirCurrN1stCdCol);
			   					
			   				} else if(gubun == "hirCurrN2ndCd") {
			   					var prefix = "hir_";
			   					var hirCurrN2ndCdCol = sheetObj.SaveNameCol(prefix + "hir_curr_n2nd_cd");
			   					
			   					sheetObj.CellValue2(row,hirCurrN2ndCdCol) = "";
			   					sheetObj.SelectCell(row,hirCurrN2ndCdCol);
			   					
			   				} else {
			   					var prefix = "otr_";
			   					var currCdCol = sheetObj.SaveNameCol(prefix + "curr_cd");
			   					
			   					sheetObj.CellValue2(row,currCdCol) = "";
			   					sheetObj.SelectCell(row,currCdCol);
			   				}
		   				}
	    			} else {
	    				if(gubun == "OaRsvCurrCd") {
	    					/*
	    					if(ComFmsCheckCurrencyYn(formObj.oa_rsv_curr_cd.value)) {
	    						form.oa_rsv_amt.dataformat = "int";
	    					} else {
	    						form.oa_rsv_amt.dataformat = "float";
	    					}
	    					*/
	    				} else {
		    				if(gubun == "hirCurrN1stCd") {
			   					var prefix = "hir_";
			   					var currCd = sheetObj.CellValue(row, prefix + "hir_curr_n1st_cd");
			   					
			   					ComFmsSetInitCellProperty(sheetObj, row, 6, "hir_rt_n1st_amt", currCd, prefix, 2);
			   					
			   				} else if(gubun == "hirCurrN2ndCd") {
			   					var prefix = "hir_";
			   					var currCd = sheetObj.CellValue(row, prefix + "hir_curr_n2nd_cd");
			   					
			   					ComFmsSetInitCellProperty(sheetObj, row, 8, "hir_rt_n2nd_amt", currCd, prefix, 2);
			   					
			   				} else {
			   					var prefix = "otr_";
			   					var currCd = sheetObj.CellValue(row, prefix + "curr_cd");
			   					
			   					ComFmsSetInitCellProperty(sheetObj, row, 8, "otr_expn_amt", currCd, prefix, 2);
			   				}
	    				}
	    			}
		   			
		   			sheetObj.WaitImageVisible = true;
				}
				
	   			break;
	   			
			case IBCLEAR:      // G/W 초기화				
				if(formObj.agmt_doc_no.value == ''){
					return;
				}
				
				if(!ComShowConfirm(ComGetMsg("FMS01076"))){
					return;
				}
								
				formObj.f_cmd.value = MULTI01;				
				formObj.ibflag.value = "U";
				var sParam = FormQueryString(formObj);
				
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_FMS_0001GS.do", sParam);			
				ComOpenWait(false);
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) sheetObjects[8].LoadSaveXml(arrXml[0]);
				
                break;	   			
	   			
        }
    }

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj) {
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
                    InsertTab( cnt++ , "Hire" , -1 );
                    InsertTab( cnt++ , "Other Exp" , -1 );
                    InsertTab( cnt++ , "Payment Term" , -1 );
                    InsertTab( cnt++ , "Redelivery" , -1 );
                    InsertTab( cnt++ , "CP File up" , -1 );
                    InsertTab( cnt++ , "Certi File up" , -1 );
                    InsertTab( cnt++ , "Duplication" , -1 );

                }
                sheetObjects[4].DataInsert();
             break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {

        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction) {
  
        if(comboObjects[1].Code != "PSE") {
        	//필수 입력 등 Validation 체크
            if (!ComChkValid(formObj)) return false;
            
	        if(comboObjects[0].Code == "TO") {
	            if(formObj.cust_cnt_cd.value == "") {
	            	ComAlertFocus(formObj.cust_cnt_cd, ComGetMsg('FMS01053'));
		    		return;
	            }
	        } else {
	        	formObj.vndr_seq.value = formObj.cust_seq.value;
	        }
        } else {
        	if(formObj.vsl_cd.value == "") {
        		ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01138'));
	    		return;
        	} 
        	/*
        	else if(formObj.vsl_cnt_cd.value == "") {
        		ComAlertFocus(formObj.vsl_cnt_cd, ComGetMsg('FMS01089'));
	    		return;
        	}
        	*/
        }
        
        if(   formObj.ori_eff_dt.value != "" 
           && formObj.from_time.value != "") {
        	formObj.eff_dt.value = formObj.ori_eff_dt.value.trimAll("-") + formObj.from_time.value.trimAll(":");
        }
        
        if(   formObj.ori_exp_dt.value != "" 
            && formObj.to_time.value != "") {
         	formObj.exp_dt.value = formObj.ori_exp_dt.value.trimAll("-") + formObj.to_time.value.trimAll(":");
        }  
        
        if(formObj.oa_rsv_curr_cd.value != "") {
        	if(formObj.oa_rsv_amt.value == "") {
        		ComAlertFocus(formObj.oa_rsv_amt, ComGetMsg('FMS01083'));
        		return;
        	} else {
        		if(parseInt(formObj.oa_rsv_amt.value) < 1) {
        			ComAlertFocus(formObj.oa_rsv_amt, ComGetMsg('FMS01163'));
        			return;
        		}
        	}
        } else if(formObj.oa_rsv_amt.value != "") {
        	if(formObj.oa_rsv_curr_cd.value == "") {
        		ComAlertFocus(formObj.oa_rsv_curr_cd, ComGetMsg('FMS01084'));
        		return;
        	} 
        }

    	//시간체크
    	if (formObj.eff_dt.value > formObj.exp_dt.value) {
    		ComAlertFocus(formObj.exp_dt, ComGetMsg('FMS01059'));
    		return;
    	}
    	
    	//금액체크(Address Comm./Outlay Comm./Brokerage)
    	if(formObj.acmm_rt_amt.value != "") {
    		if(formObj.acmm_rt_amt.value == "0") {
    			formObj.acmm_rt_amt.value = "";
    			ComAlertFocus(formObj.acmm_rt_amt, ComGetMsg('FMS00013', 'Address Comm.'));
        		return;
    		}
    	}
    	
    	if(formObj.flet_olay_comm_rt_amt.value != "") {
    		if(formObj.flet_olay_comm_rt_amt.value == "0") {
    			formObj.flet_olay_comm_rt_amt.value = "";
    			ComAlertFocus(formObj.flet_olay_comm_rt_amt, ComGetMsg('FMS00013', 'Outlay Comm.'));
        		return;
    		}
    	}
    	
    	if(formObj.flet_brog_rt_amt.value != "") {
    		if(formObj.flet_brog_rt_amt.value == "0") {
    			formObj.flet_brog_rt_amt.value = "";
    			ComAlertFocus(formObj.flet_brog_rt_amt, ComGetMsg('FMS00013', 'Brokerage'));
        		return;
    		}
    	}
    	
    	//Hire 탭과 PayTerm탭간의 FromDate와 ToDate 유효성체크(기간)
    	var sheetObj1 = sheetObjects[1];
    	var sheetObj2 = sheetObjects[2];
    	var sheetObj3 = sheetObjects[3];
    	var firstRow1 = getFirstRow(sheetObj1);
    	var firstRow3 = getFirstRow(sheetObj3);
    	var lastRow1  = getLastRow(sheetObj1);
    	var lastRow3  = getLastRow(sheetObj3);
    	
    	//Hire 탭의 Row 갯수
    	var rowCount1 = 0;
    	
    	//Other Exp 탭의 Row 갯수
    	var rowCount2 = 0;
    	
    	//Payment Term 탭의 Row 갯수
    	var rowCount3 = 0;
    	
    	//Hire 탭의 Row 갯수
    	for(var ir=1; ir<=sheetObj1.LastRow; ir++) {
			if(sheetObj1.RowHidden(ir)==false) {
				rowCount1 = 1;
				break;
			}
		}
    	
    	//Other Exp 탭의 Row 갯수
    	for(var ir=1; ir<=sheetObj2.LastRow; ir++) {
			if(sheetObj2.RowHidden(ir)==false) {
				rowCount2 = 1;
				break;
			}
		}
    	
    	//Payment Term 탭의 Row 갯수
    	for(var ir=1; ir<=sheetObj3.LastRow; ir++) {
			if(sheetObj3.RowHidden(ir)==false) {
				rowCount3 = 1;
				break;
			}
		}

    	//if(sheetObj3.RowCount >0 && rowCount3 == 1) {
    	if(rowCount3 > 0) {
	    	//HIRE탭과 PAYMENT TERM태과의 기간 체크
	    	if(rowCount1 >0 && sheetObj1.CellValue(firstRow1, "hir_eff_dt")!="" && sheetObj1.CellValue(lastRow1, "hir_exp_dt")!=""){
	    		if (sheetObj3.CellValue(firstRow3, "pay_eff_dt") > sheetObj1.CellValue(firstRow1, "hir_eff_dt")) {
	    			ComShowMessage(ComGetMsg('FMS01060'));
	    			tabObjects[0].SelectedIndex = 2;
	    			sheetObj3.SelectCell(firstRow3, "pay_eff_dt");
	    			return;
	    		} else if (sheetObj3.CellValue(lastRow3, "pay_exp_dt") < sheetObj1.CellValue(lastRow1, "hir_exp_dt")) {
	    			ComShowMessage(ComGetMsg('FMS01061'));
	    			tabObjects[0].SelectedIndex = 2;
	    			sheetObj3.SelectCell(lastRow3, "pay_exp_dt");
	    			return;
	    		}
	    	}

	    	//OTHER EXP 탭과 PayTerm탭간의 FromDate와 ToDate 유효성체크(기간)
	    	if(rowCount2 > 0 && rowCount3 > 0) {
		    	var sheetObj2 = sheetObjects[2];
		    	var firstRow2 = getFirstRow(sheetObj2);
		    	var lastRow2  = getLastRow(sheetObj2);
		    	
		    	var leastValue2     = getLeastValue(sheetObj2);
		    	var greatestValue2  = getGreatestValue(sheetObj2);
	
		    	//OTHER EXP탭과 PayTerm탭간의 기간 체크
		    	if(rowCount2 >0 && sheetObj2.CellValue(firstRow2, "otr_eff_dt")!="" && sheetObj2.CellValue(lastRow2, "otr_exp_dt")!=""){
		    		if (sheetObj3.CellValue(firstRow3, "pay_eff_dt").substr(0,8) > leastValue2) {
		    			//ComShowMessage("Payment Term탭의 FromDate는 Other Exp탭  첫행의 FromDate보다 작거나 같아야 한다.");
		    			ComShowMessage(ComGetMsg('FMS01062'));
		    			tabObjects[0].SelectedIndex = 2;
		    			sheetObj3.SelectCell(firstRow3, "pay_eff_dt");
		    			return;
		    			
		    		} else if (sheetObj3.CellValue(lastRow3, "pay_exp_dt").substr(0,8) < greatestValue2) {
		    			//ComShowMessage("Payment Term탭의 ToDate는  Other Exp탭  마지막행의 ToDate보다 크거나 같아야 한다.");
		    			ComShowMessage(ComGetMsg('FMS01063'));
		    			tabObjects[0].SelectedIndex = 2;
		    			sheetObj3.SelectCell(lastRow3, "pay_exp_dt");
		    			return;
		    		}
		    	}
	    	}
	    	
	    	//Payment 탭의 Payment Term 에 따른 날짜 체크
	    	for(var ir=1,idx=0; ir<=sheetObj3.LastRow; ir++) {
	    		var ctrtPayTermCd = sheetObj3.CellValue(ir, "pay_ctrt_pay_term_cd");
	    		var effDt = sheetObj3.CellValue(ir, "pay_eff_dt");
	    		var expDt = sheetObj3.CellValue(ir, "pay_exp_dt");

	    		if(ctrtPayTermCd == "A") {
	    			if((effDt.substring(6,8) != "01" && effDt.substring(6,8) != "16") || effDt.substring(8,12) != "0000") {
	    				ComShowMessage(ComGetMsg('FMS01086'));
	    				sheetObj3.SelectCell(ir, "pay_eff_dt");
	    				
	    				return false;
    					break;
	    			} else if((expDt.substring(6,8) != "01" && expDt.substring(6,8) != "16") || expDt.substring(8,12) != "0000") {
	    				ComShowMessage(ComGetMsg('FMS01087'));
	    				sheetObj3.SelectCell(ir, "pay_exp_dt");
	    				
	    				return false;
    					break;
	    			}
	    		} else if(ctrtPayTermCd == "C") {
	    			if(effDt.substring(6,12) != expDt.substring(6,12)) {
	    				ComShowMessage(ComGetMsg('FMS01088'));
	    				sheetObj3.SelectCell(ir, "pay_exp_dt");
	    				
	    				return false;
    					break;
	    			} else if(parseInt(effDt.substring(6,8)) > 28) {
	    				ComShowMessage(ComGetMsg('FMS01096'));
	    				sheetObj3.SelectCell(ir, "pay_eff_dt");
	    				
	    				return false;
    					break;
	    			}
	    		}
	    	}
    	}
    	
    	/*
    	var rowCount1 = 0;
    	
    	for(var ir=1; ir<=sheetObj1.LastRow; ir++) {
			if(sheetObj1.RowHidden(ir)==false) {
				rowCount1 = 1;
				break;
			}
		}
		*/
    	
    	//HIRE탭의 CURR2체크하기
        if(rowCount1 >0) {
    		var prefix = "hir_";

    		for(var ir=1,idx=0; ir<=sheetObj1.LastRow; ir++) {
    			if(sheetObj1.CellValue(ir,prefix + "hir_curr_n2nd_cd") != "" || sheetObj1.CellValue(ir,prefix + "hir_rt_n2nd_amt") != "") {
	    			if(sheetObj1.CellValue(ir,prefix + "hir_curr_n2nd_cd") != "") {
	    				if(sheetObj1.CellValue(ir,prefix + "hir_rt_n2nd_amt") == "" || sheetObj1.CellValue(ir,prefix + "hir_rt_n2nd_amt") < 1) {
	    					ComShowMessage(ComGetMsg('FMS01163'));
	    					sheetObj1.SelectCell(ir, prefix + "hir_rt_n2nd_amt");
	    					
	    					return false;
	    					break;
	    				}
	    			} else if(sheetObj1.CellValue(ir,prefix + "hir_rt_n2nd_amt") != "" && sheetObj1.CellValue(ir,prefix + "hir_rt_n2nd_amt") > 0) {
	    				if(sheetObj1.CellValue(ir,prefix + "hir_curr_n2nd_cd") == "") {
	    					ComShowMessage(ComGetMsg('FMS01077'));
	    					sheetObj1.SelectCell(ir, prefix + "hir_curr_n2nd_cd");
	    					
	    					return false;
	    					break;
	    				}
	    			} else if(sheetObj1.CellValue(ir,prefix + "hir_curr_n2nd_cd") == "" && sheetObj1.CellValue(ir,prefix + "hir_rt_n2nd_amt") == 0) {
	    				ComShowMessage(ComGetMsg('FMS01163'));
						sheetObj1.SelectCell(ir, prefix + "hir_rt_n2nd_amt");
						
						return false;
						break;
	    			}
    			}
    		}
    	}

        return true;
    }
	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "-";
    	
        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListener  ('click', 'declaration_click', 'decl_flg');    			//declaration 체크여부
        //2010.11.24 이상민 [CHM-201007233-01] vsl_cd 는 engnum_keypress로 변경
        axon_event.addListener  ('keypress', 'eng_keypress', 'cust_cnt_cd', 'vsl_cnt_cd', 'oa_rsv_curr_cd', 'bod_port_cd', 'bor_port_cd');
        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'); //- Vessel Code 입력 시 영문 대문자/숫자만 입력하기
        
        axon_event.addListener  ('change', 'cust_seq_change', 'cust_seq');				//Owner Code 입력 후 Name정보 가져오기
        axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');					//Vessel Code 입력 후 Name정보 가져오기
        axon_event.addListener  ('change', 'cust_cnt_cd_change', 'cust_cnt_cd');		//Owner Code(Flag Code) 입력 후 Name정보 가져오기
        axon_event.addListener  ('change', 'vsl_cnt_cd_change', 'vsl_cnt_cd');			//Flag Code 입력 후 Name정보 가져오기
        axon_event.addListener  ('change', 'bod_port_cd_change', 'bod_port_cd');		//Del / Redel 입력 후 코드 체크하기
        axon_event.addListener  ('change', 'bor_port_cd_change', 'bor_port_cd');		//Del / Redel 입력 후 코드 체크하기
        axon_event.addListener  ('change', 'oa_rsv_curr_cd_change', 'oa_rsv_curr_cd');	//Reservation of O/A 입력 후 Currency 체크
        axon_event.addListener  ('change', 'flet_ctrt_no_change', 'flet_ctrt_no');		//Reservation of O/A 입력 후 Currency 체크

        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        
        axon_event.addListener  ('click', 'doc_click' , 'agmt_doc_desc');		// GW문서 클릭        
        
        //doActionIBSheet(sheetObjects[3], document.form, IBROWSEARCH, "ComCd");
    }
    //Axon 이벤트 처리2. 이벤트처리함수 --- start
    
    /**
     * Condition 클릭시 날짜 필드를 제어한다. <br>
     **/
    function doc_click() {
    	fnDocOpen("detail");
    }    

    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
     
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
         //영대문자 자동변환
         ComKeyOnlyAlphabet('uppernum');
     }     
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
	    	case "shp_spd_qty": 
	    	case "vsl_dznd_capa": 
	    	case "bse_14ton_vsl_capa": 
	    	case "rf_cntr_plg_qty": 
	    	case "ddwt_cgo_capa_qty": 
	    	case "grs_wgt": 
	    	case "nrt_wgt":
	    	case "cust_seq":
	    		//숫자이면서 천단위 구분을 하지 않는다.
	    		//ComChkObjValid(obj, bMsg, bTrim, bMasked)
    			ComChkObjValid(event.srcElement, true, false, false);
    			break;

    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
    }

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        //마스크구분자 없애기
        ComClearSeparator(event.srcElement);
    }
    
    /**
     * CustSeq변경 시 해당 Name 을 가져온다. <br>
     **/
    function cust_seq_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Owner');
    }
    
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Vessel');
    }
    
    
    /**
     * CustCntCd변경 시 코드에 해당하는 정보가 존재하는지 체크한다 <br>
     **/
    function cust_cnt_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Flag','0');
    }
    
    /**
     * VslCntCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cnt_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Flag');
    }
     
    /**
     * Del / Redel 변경 시 해당 Code를 가져온다. <br>
     **/
    function bod_port_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Bod');
    }

    /**
     * Del / Redel 변경 시 해당 Code를 가져온다. <br>
     **/
    function bor_port_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Bor');
    }
    
    /**
     * Currency Code 입력 시 코드값을 체크한다. <br>
     **/
    function oa_rsv_curr_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'OaRsvCurrCd');
    }
    
    /**
     * Contract No 입력 시 버튼 비활성화. <br>
     **/
    function flet_ctrt_no_change() {
    	document.all.btn_creation.style.display = "none";
    	document.all.btn_creation2.style.display = "none";
    }
    //Axon 이벤트 처리2. 이벤트처리함수 --- end
    
    /**
     * CheckBox선택시 값 설정. <br>
     **/
    function declaration_click() {
    	if(form.decl_flg.checked) {
    		form.decl_flg.value = 'Y';
    	} else {
    		form.decl_flg.value = 'N';
    	}
    }
	
    /**
     * Owner Code 변경 시 값 설정. <br>
     **/
	function setOwnerCode(val) {
		if(val == "TO") {
			form.cust_cnt_cd.readOnly = false;
		} else {
			form.cust_cnt_cd.readOnly = true;
			form.cust_cnt_cd.value = "";
		}
		
		form.cust_seq.value = "";
		form.vndr_lgl_eng_nm.value = "";
		form.ownr_nm.value = "";
		
	}
	
	/**
     * 선택된 Item이 변경되었을 때 이벤트가 발생한다.<br>
     * 기존에 선택된 item을 다시 선택했을때는 이벤트가 발생하지 않는다.
     * @param {ibsheet} idx_cd    	Index_Code
     * @param {ibsheet} text     	Text
     **/
	function flet_ctrt_tp_cd_OnChange(idx_cd, text) {
		if(text == "TO") {
			form.cust_cnt_cd.readOnly = false;
			form.cust_seq.readOnly = true;
			
			form.owner_code.style.cursor = "hand";
			document.images["owner_code"].name = "owner_code";
			
			form.flet_olay_comm_rt_amt.value = "";
			
		} else if(text == "OW") {
			form.cust_cnt_cd.readOnly = true;
			form.cust_seq.readOnly = true;
			
			form.cust_cnt_cd.value = "";
			
			form.owner_code.style.cursor = "default";
			document.images["owner_code"].name = "no_owner_code";
			
			form.flet_olay_comm_rt_amt.value = "";
			
			doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Owner');
			
			return;
			
		} else {
			form.cust_cnt_cd.readOnly = true;
			form.cust_seq.readOnly = false;
			
			form.cust_cnt_cd.value = "";
			
			form.owner_code.style.cursor = "hand";
			document.images["owner_code"].name = "owner_code";
			
			form.flet_olay_comm_rt_amt.value = "2.5";
		}
		
		form.cust_seq.value = "";
		form.vndr_lgl_eng_nm.value = "";
		form.ownr_nm.value = "";
	}
	
	/**
     * 선택된 Item이 변경되었을 때 이벤트가 발생한다.<br>
     * 기존에 선택된 item을 다시 선택했을때는 이벤트가 발생하지 않는다.
     * @param {ibsheet} idx_cd    	Index_Code
     * @param {ibsheet} text     	Text
     **/
	function flet_ctrt_fact_cd_OnChange(idx_cd, text) {
		if(text == "ACT") {
			form.cust_cnt_cd.className = "input1";
	    	form.cust_seq.className = "input1";
	    	
			form.decl_flg.disabled = false;
		} else {
			form.cust_cnt_cd.className = "input";
	    	form.cust_seq.className = "input";
	    	
			form.decl_flg.checked = false;
			form.decl_flg.disabled = true;
			
			form.decl_flg.value = 'N';
		}
	}
     
    
    /**
	 * Del/Re Port 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setBodPortCd(aryPopupData){
		form.bod_port_cd.value = aryPopupData[0][3];
	}
	
	/**
	 * Del/Re Port 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setBorPortCd(aryPopupData){
		form.bor_port_cd.value = aryPopupData[0][3];
	}
	

	/**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
	function t1sheet1_OnChange(sheetObj,row,col,value) {
		dateTimeOnChange(sheetObj,row,col,value,"hir_");
		
		currencyOnChange(sheetObj,row,col,value,"hir_");
		
		currency2OnChange(sheetObj,row,col,value,"hir_");
	}
	
	/**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
	function t2sheet1_OnChange(sheetObj,row,col,value) {
		dateTimeOnChange(sheetObj,row,col,value,"otr_");
		
		currencyOnChange(sheetObj,row,col,value,"otr_");
	}
	
	/**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
	function t3sheet1_OnChange(sheetObj,row,col,value) {
		dateTimeOnChange(sheetObj,row,col,value,"pay_");
	}
    
    /**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
	function t5sheet1_OnChange(sheetObj,row,col,value) {
		dateTimeOnChange(sheetObj,row,col,value,"cpf_");
	}
	
	/**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
	function t6sheet1_OnChange(sheetObj,row,col,value) {
		dateTimeOnChange(sheetObj,row,col,value,"cef_");
	}
	
	/**
     * VslCd중복 체크하기. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
	function t7sheet1_OnChange(sheetObj,row,col,value) {

		var prefix = "vsl_";
        var colAlias = sheetObj.ColSaveName(col);
        
        //Vessel Code 변경된 경우 OR 삭제체크된 경우
        if (colAlias==(prefix + "vsl_cd")) {
            var vslCdCol = sheetObj.SaveNameCol(prefix + "vsl_cd");
            var oriVslCdCol = sheetObj.SaveNameCol(prefix + "ori_vsl_cd");
            //var vslEngNmCol = sheetObj.SaveNameCol(prefix + "vsl_eng_nm");
            
            //Duplication탭의 Vessel Code 중복 체크하기
            for(var ir=1,idx=0; ir<=sheetObj.LastRow; ir++) {
            	var vslCdValue = sheetObj.CellText(ir,vslCdCol);

                //Vessel Code 관련 체크 스크립트(Duplication)
                if (ir == row) {
                	//Vessel Code가 중복되면 안됨
                    if (sheetObj.FindText(vslCdCol, vslCdValue) != ir || sheetObj.FindText(vslCdCol, vslCdValue, ir+1) > ir) {
                    	ComShowMessage(ComGetMsg('FMS01064', vslCdValue));
                        
                        if(sheetObj.RowStatus(row) == "I") {
                        	sheetObj.CellValue2(row,vslCdCol) = "";
	                        sheetObj.CellValue2(row,prefix + "vsl_eng_nm") = "";
	                        
                        } else {
	                        sheetObj.CellValue2(row,vslCdCol) = sheetObj.CellValue(row,oriVslCdCol);
	                        sheetObj.CellValue2(row,prefix + "vsl_eng_nm") = sheetObj.CellValue(row,prefix + "ori_vsl_eng_nm");
                        }
                        //sheetObj.CellValue2(row,vslEngNmCol) = "";
                        sheetObj.SelectCell(row,vslCdCol);
                        
                        //popup창 막기
                        //sheetObj.SelectCell(row,vslCdCol,false);
                        return;
                    }
                }
            }
        }
	}
	
	/**
     * IBSheet 입력값에 대한 날짜 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     * @param {String}  prefix   	변수 구분값
     * @see #sheet_chekPeriod
     **/
	function dateTimeOnChange(sheetObj,row,col,value,prefix) {
		if (sheetObj.ReadDataProperty(row,col,dpDataFormat) != dfDateYmd && sheetObj.ReadDataProperty(row,col,dpDataFormat) != dfUserFormat2) return;

		if (value=="") return;
		
		//년월일시분 validation check
		var sText = sheetObj.CellText(row,col);
		
		if(prefix == "otr_" || prefix == "cpf_" || prefix == "cef_") {
			if (!ComIsDate(sText)) {
				ComShowMessage(ComGetMsg('FMS01065', sheetObj.CellText(0,col)));
				//ComShowMessage(sheetObj.CellText(0,col) + " is not valid date-time. Please enter a correct date-time. \n\n Format : YYYY-MM-DD");
				sheetObj.SelectCell(row,col,true,sText);
				return;
			}
		} else {
			if (!ComIsDateTime(sText, "", "hm")) {
				ComShowMessage(ComGetMsg('FMS01066', sheetObj.CellText(0,col)));
				//ComShowMessage(sheetObj.CellText(0,col) + " is not valid date-time. Please enter a correct date-time. \n\n Format : YYYY-MM-DD HH:MM");
				sheetObj.SelectCell(row,col,true,sText);
				return;
			}
		}

		// 기간체크
		if (sheetObj.CellText(row,prefix + "eff_dt")!="" && sheetObj.CellText(row,prefix + "exp_dt")!="" && !sheet_chekPeriod(sheetObj,row,col,prefix)){
			
			if(sheetObj.ColSaveName(col)==prefix + "eff_dt") {
				sText = sheetObj.CellText(row,col+1);
				sheetObj.SelectCell(row,col+1,true,sText);
			} else {
				sheetObj.SelectCell(row,col,true,sText);
			}

			return;
		}
		
		
		//현재행의 ToDate를 다음행의FromDate로 설정하기
		if(row < sheetObj.LastRow){
			if(prefix == "otr_") {
				setNextOtrEffDt(sheetObj, row, prefix);
			} else {
				sheetObj.CellValue(row+1,prefix + "eff_dt") = sheetObj.CellValue(row,prefix + "exp_dt");
			}
		}
		
		//"입력" 상태인 행의 FromDate와  ToDate의 Original 값 설정하기
		if (sheetObj.RowStatus(row)=="I"){
			sheetObj.CellValue(row,prefix + "ori_exp_dt") = sheetObj.CellValue(row,prefix + "exp_dt");
			sheetObj.CellValue(row,prefix + "ori_eff_dt") = sheetObj.CellValue(row,prefix + "eff_dt");
		}
		
	}
	
	/**
     * IBSheet의 현재 입력값(TO Data)을 다음행의 From Date값으로 자동 입력한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {String}  prefix   	변수 구분값
     **/
	function setNextOtrEffDt(sheetObj, row, prefix) {
		var currAcctItmNm;
		var currExpDt;
		
		//값 복사하기
		if (sheetObj.RowCount > 1) {
			currAcctItmNm = sheetObj.CellValue(row,prefix + "acct_itm_nm");
			currExpDt = sheetObj.CellValue(row,prefix + "exp_dt");

			for(var ir=row+1; ir<=sheetObj.LastRow; ir++) {
				if(sheetObj.RowHidden(ir)==false) {
					if(currAcctItmNm == sheetObj.CellValue(ir,prefix + "acct_itm_nm")) {
						var nextEffDt = ComGetDateAdd(sheetObj.CellValue(row,prefix + "exp_dt"), "D", 1, "");

						sheetObj.CellValue(ir,prefix + "eff_dt") = nextEffDt;
						break;
					}
				}
			}
		}
	}

	/**
     * 저장함수에서 저장직전에 Vlidation을 체크하기 위해 호출되는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
	function t1sheet1_OnValidation(sheetObj,row,col,value) {
		var prefix = "hir_";
		if ((sheetObj.ColSaveName(col)==prefix + "exp_dt") && !sheet_chekPeriod(sheetObj,row,col,prefix)){
			sheetObj.ValidateFail = true;
		} else if((sheetObj.ColSaveName(col)==prefix + "hir_rt_n1st_amt") && sheetObj.CellValue(row,prefix + "hir_rt_n1st_amt") < 1) {
			ComShowMessage(ComGetMsg('FMS01163'));
			sheetObj.ValidateFail = true;
		}
	}
	
	/**
     * 저장함수에서 저장직전에 Vlidation 을 체크하기 위해 호출되는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
	function t2sheet1_OnValidation(sheetObj,row,col,value) {
		var prefix = "otr_";
		if ((sheetObj.ColSaveName(col)==prefix + "exp_dt") && !sheet_chekPeriod(sheetObj,row,col,prefix)){
			sheetObj.ValidateFail = true;
		} else if((sheetObj.ColSaveName(col)==prefix + "otr_expn_amt") && sheetObj.CellValue(row,prefix + "otr_expn_amt") < 1) {
			ComShowMessage(ComGetMsg('FMS01163'));
			sheetObj.ValidateFail = true;
		}
	}
	
	/**
     * 저장함수에서 저장직전에 Vlidation 을 체크하기 위해 호출되는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
	function t3sheet1_OnValidation(sheetObj,row,col,value) {
		var prefix = "pay_";
		if ((sheetObj.ColSaveName(col)==prefix + "exp_dt") && !sheet_chekPeriod(sheetObj,row,col,prefix)){
			sheetObj.ValidateFail = true;
		}
	}
    
    /**
     * 저장함수에서 저장직전에 Vlidation 을 체크하기 위해 호출되는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
    /*
	function t5sheet1_OnValidation(sheetObj,row,col,value) {
		var prefix = "cpf_";
		if ((sheetObj.ColSaveName(col)==prefix + "exp_dt") && !sheet_chekPeriod(sheetObj,row,col,prefix)){
			sheetObj.ValidateFail = true;
		}
	}
	*/
	
	/**
     * 저장함수에서 저장직전에 Vlidation 을 체크하기 위해 호출되는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
    /*
	function t6sheet1_OnValidation(sheetObj,row,col,value) {
		var prefix = "cef_";
		if ((sheetObj.ColSaveName(col)==prefix + "exp_dt") && !sheet_chekPeriod(sheetObj,row,col,prefix)){
			sheetObj.ValidateFail = true;
		}
	}
	*/
	
	/**
     * IBSheet의 현재 Grid Row에 대한 입력값(TO Data ~ From Date)을 비교한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  prefix   	변수 구분값
     * @return {boolean} 정상 여부
     **/
	function sheet_chekPeriod(sheetObj,row,col,prefix){
		//var prefix = "hir_";
		var fromDate = sheetObj.CellValue(row,prefix + "eff_dt");
		var toDate = sheetObj.CellValue(row,prefix + "exp_dt");
		
		if (fromDate=="" && toDate=="") return;
		
		if (fromDate > toDate){
			ComShowMessage(ComGetMsg('FMS01067'));
			//ComShowMessage("'To Date' must be greater than or equal to 'From Date'.");
			//sheetObj.SelectCell(row,col);
			return false;
		}
		return true;
		
	}
	
	/**
     * IBSheet의 각 탭에 대한 Row를 추가한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @param {String} 	flag   		Row Add/Row Ins의 구분값
     * @return {없음}
     **/
	function sheet_DataInsert(sheetObj,prefix,flag){
		//var prefix = "hir_";
		var row = sheetObj.SelectRow;
		var col = sheetObj.SelectCol;
		
		if (sheetObj.RowCount > 0){
			if(prefix == "vsl_") {
				//이전행의 입력 여부 확인
				if (sheetObj.CellValue(row,prefix + "vsl_cd")==""){
					ComShowMessage(ComGetMsg('FMS01068'));
					//ComShowMessage("Please must enter 'Vessel Code'");
					sheetObj.SelectCell(row,prefix + "vsl_cd");
					return;
				}
				
			} else if(prefix == "cpf_" || prefix == "cef_") {
				//이전행의 입력 여부 확인
				if (sheetObj.CellValue(row,prefix + "file_nm")==""){
					if(prefix == "cpf_") {
						ComShowMessage(ComGetMsg('FMS01069'));
						//ComShowMessage("Please must enter 'CP File Upload'");
					} else {
						ComShowMessage(ComGetMsg('FMS01070'));
						//ComShowMessage("Please must enter 'Certi File Upload'");
					}
					sheetObj.SelectCell(row,prefix + "file_nm");
					return;
				}
			} else {
				//이전행의 입력 여부 확인
				if (sheetObj.CellValue(row,prefix + "eff_dt")==""){
					ComShowMessage(ComGetMsg('FMS01071'));
					//ComShowMessage("Please must enter 'From Date'");
					sheetObj.SelectCell(row,prefix + "eff_dt");
					return;
					
				}else if (sheetObj.CellValue(row,prefix + "exp_dt")==""){
					ComShowMessage(ComGetMsg('FMS01072'));
					//ComShowMessage("Please must enter 'To Date'");
					sheetObj.SelectCell(row,prefix + "exp_dt");
					return;
					
				}else if (!sheet_chekPeriod(sheetObj,row,col,prefix)){
					return;
				}
				
				//Other Exp탭 체크(Account Code)
				if (sheetObj.CellValue(row,prefix + "acct_cd")==""){
					ComShowMessage(ComGetMsg('FMS01073'));
					//ComShowMessage("Please must enter 'Account Code'");
					sheetObj.SelectCell(row,prefix + "acct_cd");
					return;
				}
			}
		}
		
		//Row Ins버튼 체크
		if(typeof flag != "undefined" && flag != "") {
			if(prefix == "cpf_" || prefix == "cef_") {
				row = sheetObj.DataInsert();
			} 
		} else {
			// 행 추가하기
	    	row = sheetObj.DataInsert(-1);
	    	/*
			if(prefix == "cpf_" || prefix == "cef_") {
				sheetObj.CellImage(row,prefix + "file_download")=0;
			}*/
			if (row<=sheetObj.HeaderRows) return;
		}
		
		if(!(prefix == "otr_" || prefix == "cpf_" || prefix == "cef_")) {
			//값 복사하기
			sheetObj.CellValue(row,prefix + "eff_dt") = sheetObj.CellValue(row-1,prefix + "exp_dt");
			sheetObj.CellEditable(row,prefix + "eff_dt")= false;
		}
	}
	
	/**
     * IBSheet의 각 Grid의 From Date 값을 자동 입력한다. <br>
     * @param {ibsheet} row     sheetObj의 선택된 Row
     * @param {String} 	prefix  변수 구분값
     * @return {boolean} 정상 여부
     **/
	function setOtrEffDt(row, prefix) {
		var sheetObj = sheetObjects[2];
		var currAcctItmNm;
		var exist = false;
		
		//값 복사하기
		if(sheetObj.RowCount > 1) {
			currAcctItmNm = sheetObj.CellValue(row,prefix + "acct_itm_nm");

			for(var ir=1; ir<=sheetObj.LastRow; ir++) {
				if(sheetObj.RowHidden(ir)==false && row != ir) {
					if(currAcctItmNm == sheetObj.CellValue(ir,prefix + "acct_itm_nm")) {
						exist = true;
					}
				}
			}
			
			if(exist) {
				var maxExpDt = getOtrGreatestValue(sheetObj, row, currAcctItmNm);
				maxExpDt = ComGetDateAdd(maxExpDt, "D", 1, "");

				sheetObj.CellValue(row,prefix + "eff_dt") = maxExpDt;
				sheetObj.CellEditable(row,prefix + "eff_dt")= false;
			}
		}
	}
	
	/**
     * IBSheet의 각 Grid의 From Date의 입력 여부를 결정한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @return {없음}
     * @see #setFirstOtrEffDtCellEditable
     **/
	function setOtrEffDtCellEditable(sheetObj, prefix) {
		
		if (sheetObj.RowCount > 1) {
			setFirstOtrEffDtCellEditable(sheetObj, prefix);
		}
		
	}
	
	/**
     * 화면을 초기화한다. <br>
     * @return 없음
     * @see #ComResetAll
     **/
	function clearAll() {
		ComResetAll();
		
		tabObjects[0].SelectedIndex = 0;
		document.all.btn_creation.style.display = "";		
    	document.all.btn_save.style.display = "none";
    	document.all.btn_delete.style.display = "none";
    	
    	document.all.btn_creation2.style.display = "";    	
    	document.all.btn_save2.style.display = "none";
    	document.all.btn_delete2.style.display = "none";

    	comboObjects[0].Code = "TI";
		comboObjects[1].Code = "ACT";
		
		form.cust_seq.readOnly = false;
		
		form.vsl_cd.readOnly = false;
		form.btn_vslpop.style.cursor = "hand";
		document.images["btn_vslpop"].name = "btn_vslpop";
		
		form.contract_no.style.cursor = "hand";
	    document.images["contract_no"].name = "contract_no";
	    
	    form.flet_ctrt_tp_cd.Enable = true; 
	    form.flet_ctrt_fact_cd.Enable = true; 
	    
	    sheetObjects[1].CheckAll("hir_DelChk") = 0;
	    sheetObjects[2].CheckAll("otr_DelChk") = 0;
	    sheetObjects[3].CheckAll("pay_DelChk") = 0;
	    sheetObjects[5].CheckAll("cpf_DelChk") = 0;
		sheetObjects[6].CheckAll("cef_DelChk") = 0;
		//sheetObjects[7].CheckAll("vsl_DelChk") = 0;
		
		//form.oa_rsv_amt.dataformat = "float";
	}

	/**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix = "oli_";
    	
		//width 비율로 조정
		sheetObj.FitColWidth("32|13|13|8|34");
		
		//2컬럼 글자색을 1컬럼 글자색으로 설정한다.
		sheetObj.ColFontColor(0) = sheetObj.WebColor("#532FC3");
		
		setInitCellProperty(sheetObj, prefix, "curr_cd", "otr_expn_amt", 4);
	}
	
	/**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix = "hir_";
    	
		setFromDateEdit(sheetObj, prefix);
		
		setInitCellProperty(sheetObj, prefix);
		
		/*
		for(var ir=1; ir<=sheetObj.LastRow; ir++) {
			if(   sheetObj.CellValue(ir, prefix + "hir_curr_n1st_cd") == "KRW"
			   || sheetObj.CellValue(ir, prefix + "hir_curr_n1st_cd") == "JPY") {
				
				sheetObj.InitCellProperty(ir, 6, dtNull, daRight, prefix+"hir_rt_n1st_amt", "", dfNullInteger);
			}
			
			if(   sheetObj.CellValue(ir, prefix + "hir_curr_n2nd_cd") == "KRW"
			   || sheetObj.CellValue(ir, prefix + "hir_curr_n2nd_cd") == "JPY") {
				
				sheetObj.InitCellProperty(ir, 8, dtNull, daRight, prefix+"hir_rt_n2nd_amt", "", dfNullInteger);
			}
		}
		*/
	}
	
	/**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix = "otr_";
    	
		setFromDateEdit(sheetObj, prefix);
		
		setInitCellProperty(sheetObj, prefix, "curr_cd", "otr_expn_amt");
	}
	
	/**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setFromDateEdit(sheetObj,"pay_");
	}
     
    /**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
 	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		ComColFontName(sheetObj, "2"); 
 	}
	
	/**
     * DoSave로 저장 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	
    	var prefix = "hir_";
    	
		setFromDateEdit(sheetObj, prefix);
		//setOriData(sheetObj,ErrMsg,"hir_");
		
		setInitCellProperty(sheetObj, prefix);
		
		/*
		for(var ir=1; ir<=sheetObj.LastRow; ir++) {
			if(   sheetObj.CellValue(ir, prefix + "hir_curr_n1st_cd") == "KRW"
			   || sheetObj.CellValue(ir, prefix + "hir_curr_n1st_cd") == "JPY") {
				
				sheetObj.InitCellProperty(ir, 6, dtNull, daRight, prefix+"hir_rt_n1st_amt", "", dfNullInteger);
			}
			
			if(   sheetObj.CellValue(ir, prefix + "hir_curr_n2nd_cd") == "KRW"
			   || sheetObj.CellValue(ir, prefix + "hir_curr_n2nd_cd") == "JPY") {
				
				sheetObj.InitCellProperty(ir, 8, dtNull, daRight, prefix+"hir_rt_n2nd_amt", "", dfNullInteger);
			}
		}
		*/
	}
	
	/**
     * DoSave로 저장 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function t2sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	var prefix = "otr_";
    	
		setFromDateEdit(sheetObj, prefix);
		//setOriData(sheetObj,ErrMsg,"otr_");
		
		setInitCellProperty(sheetObj, prefix, "curr_cd", "otr_expn_amt");
	}
	
	/**
     * DoSave로 저장 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function t3sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		setFromDateEdit(sheetObj,"pay_");
		//setOriData(sheetObj,ErrMsg,"pay_");
	}
	
	/**
     * DoSave로 저장 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function t7sheet1_OnSaveEnd(sheetObj,ErrMsg) {
		//setOriData(sheetObj,ErrMsg,"vsl_");
	}
	
	/**
     * Cell값이 변경 되었을때 발생하는 이벤트(From Date입력 여부 설정) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	변수 구분값
     * @see #setOtrEffDtCellEditable
     **/
	function setFromDateEdit(sheetObj, prefix) {
		if (sheetObj.SearchRows <=0) return;
		
		if(prefix == "otr_") {
			setOtrEffDtCellEditable(sheetObj, prefix);
			//sheetObj.CellEditable(sheetObj.HeaderRows,prefix+"eff_dt")=true;
		} else {
			sheetObj.CellEditable(sheetObj.HeaderRows,prefix+"eff_dt")=true;
		}
	}


	/**
     * 저장완료 후 Status="R"인 경우 Original값 설정 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     * @param {String} 	prefix    	변수 구분값
     * @see #setOtrEffDtCellEditable
     **/
	function setOriData(sheetObj, ErrMsg, prefix){
		if (ErrMsg!="") return;

		switch(prefix){
			case "hir_":
			case "pay_":
				for (var ir=1; ir<=sheetObj.LastRow; ir++){
					if (sheetObj.RowStatus(ir)!= "R") continue;
					//값 복사하기
					sheetObj.CellValue2(ir,prefix + "ori_eff_dt") = sheetObj.CellValue(ir,prefix + "eff_dt");
					sheetObj.CellValue2(ir,prefix + "ori_exp_dt") = sheetObj.CellValue(ir,prefix + "exp_dt");
					sheetObj.RowStatus(ir)= "R";
				}
				break;
				
			case "otr_":
				for (var ir=1; ir<=sheetObj.LastRow; ir++){
					if (sheetObj.RowStatus(ir)!= "R") continue;
					//값 복사하기
					sheetObj.CellValue2(ir,prefix + "ori_acct_cd") = sheetObj.CellValue(ir,prefix + "acct_cd");
					sheetObj.CellValue2(ir,prefix + "ori_eff_dt") = sheetObj.CellValue(ir,prefix + "eff_dt");
					sheetObj.CellValue2(ir,prefix + "ori_exp_dt") = sheetObj.CellValue(ir,prefix + "exp_dt");
					sheetObj.CellValue2(ir,prefix + "ori_acct_itm_seq") = sheetObj.CellValue(ir,prefix + "acct_itm_seq");
					sheetObj.RowStatus(ir)= "R";
				}
				break;
				
			case "vsl_":
				for (var ir=1; ir<=sheetObj.LastRow; ir++){
					if (sheetObj.RowStatus(ir)!= "R") continue;
					//값 복사하기
					sheetObj.CellValue2(ir,prefix + "ori_vsl_cd") = sheetObj.CellValue(ir,prefix + "vsl_cd");
					sheetObj.CellValue2(ir,prefix + "ori_vsl_eng_nm") = sheetObj.CellValue(ir,prefix + "vsl_eng_nm");
					sheetObj.RowStatus(ir)= "R";
				}
				break
		}
	
	}
	
    /**
     * Popup호출하기(Item Name) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @see #setProgramNo
     **/
	function t2sheet1_OnPopupClick(sheetObj,Row,Col){
		if(sheetObj.RowStatus(Row) == "I") {
			ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=OT", 550, 455, "setProgramNo", "1,0,1,1,1,1", false, false, Row, Col, 0, "ESM_FMS_0076");
		} else {
			//ComShowMessage("Item Name은 변경할 수 없습니다");
			return;
		}
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function t5sheet1_OnPopupClick(sheetObj,Row,Col){
		var fileName = sheetObj.OpenFileDialog(ComGetMsg('FMS01074'));
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, "cpf_file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
		//var file = sheetObj.OpenFileDialog("파일선택", "파일명", "C:\\","엑셀파일(*.xls)|*.xls|모든파일(*.*)|*.*" );
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function t6sheet1_OnPopupClick(sheetObj,Row,Col){
		var fileName = sheetObj.OpenFileDialog(ComGetMsg('FMS01074'));
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, "cef_file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
		//var file = sheetObj.OpenFileDialog("파일선택", "파일명", "C:\\","엑셀파일(*.xls)|*.xls|모든파일(*.*)|*.*" );
	}
	
	/**
     * Popup 호출하기(Vessel Code) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function t7sheet1_OnPopupClick(sheetObj,Row,Col){
		ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setGridVslCd", "1,0,1,1,1", false, false, Row, Col, 0, "ESM_FMS_0022");
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function t5sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix = "cpf_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I")return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function t6sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix = "cef_";
		
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I")return;

		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 마우스 포인터 이동시 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	sheetObj의 선택된 Button
     * @param {ibsheet} Shift     	sheetObj의 선택된 Shift
     * @param {int} 	X     		X좌표값
     * @param {int} 	Y     		Y좌표값
     **/
	function t5sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		changeMousePointer(sheetObj,"cpf_");
	}
	
	/**
     * 마우스 포인터 이동시 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	sheetObj의 선택된 Button
     * @param {ibsheet} Shift     	sheetObj의 선택된 Shift
     * @param {int} 	X     		X좌표값
     * @param {int} 	Y     		Y좌표값
     **/
	function t6sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		changeMousePointer(sheetObj,"cef_");
	}
	
	/**
     * 마우스 포인터 이동시 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	sheetObj의 선택된 Button
     * @param {ibsheet} Shift     	sheetObj의 선택된 Shift
     * @param {int} 	X     		X좌표값
     * @param {int} 	Y     		Y좌표값
     **/
	function t2sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		changeMousePointer(sheetObj,"otr_");
	}
	

	/**
     * 마우스 포인터 모양 변경하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	변수 구분값
     **/
	function changeMousePointer(sheetObj, prefix){
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		if (Row<sheetObj.HeaderRows || Col<0) return;
		
		var saveName=sheetObj.ColSaveName(Col);
		
		if(prefix == "otr_") {
			if (saveName!=prefix+"acct_itm_nm") return;
			
			var status = sheetObj.RowStatus(Row);
			
			if (saveName==prefix+"acct_itm_nm") {
				sheetObj.MousePointer = (status=="I")?"Hand":"Default";
			}
		} else {
			if (saveName!=prefix+"file_nm" && saveName!=prefix+"file_download") return;
			
			var status = sheetObj.RowStatus(Row);
			
			if (saveName==prefix+"file_nm") {
				sheetObj.MousePointer = (status=="I")?"Hand":"Default";
			} else if (saveName==prefix+"file_download") {
				sheetObj.MousePointer = (status=="I")?"Default":"Hand";
			}
		}
		
	}
	
	/**
	 * programNo 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setProgramNo(aryPopupData, row, col, sheetIdx){
		sheetObjects[2].CellValue2(row,col) = aryPopupData[0][2];
	    sheetObjects[2].Cellvalue2(row,"otr_acct_cd") = aryPopupData[0][3];
	    sheetObjects[2].Cellvalue2(row,"otr_acct_itm_seq") = aryPopupData[0][4];
	    
	    setOtrEffDt(row,"otr_");
	}
	
	/**
	 * Vessel Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData){
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기
		
		form.vsl_cd.readOnly = true;
		form.btn_vslpop.style.cursor = "default";
		document.images["btn_vslpop"].name = "no_btn_vslpop";
	}
	
	/**
	 * Vessel Code 입력부분(Grid에 세팅).<br>
	 * @param {arry} aryPopupData
	 */
	function setGridVslCd(aryPopupData, row, col, sheetIdx){
	    sheetObjects[7].Cellvalue2(row,"vsl_vsl_eng_nm") = aryPopupData[0][3];
	    sheetObjects[7].Cellvalue(row,"vsl_vsl_cd") = aryPopupData[0][2];

	    if(aryPopupData[0][2] == form.vsl_cd.value) {
	    	ComShowMessage(ComGetMsg('FMS01064', aryPopupData[0][2]));
	    	sheetObjects[7].SelectCell(row,"vsl_vsl_cd");
	    	
	    	sheetObjects[7].CellValue2(row,"vsl_vsl_cd") = "";
	    	sheetObjects[7].CellValue2(row,"vsl_vsl_eng_nm") = "";
	    } else {
		    if(sheetObjects[7].RowStatus(row)== "I") {
		    	sheetObjects[7].Cellvalue2(row,"vsl_ori_vsl_cd") = aryPopupData[0][2];
		    	sheetObjects[7].Cellvalue2(row,"vsl_ori_vsl_eng_nm") = aryPopupData[0][3];
		    }
	    }
	}
	
	/**
     * 이메일로 발송될 첨부파일 FileSaveId를 가져온다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @return {String} fileKey     첨부파일 FileSaveId 값
     **/
	function checkAttachFile(sheetObj, prefix) {
		var fileKey = "";
		
		var sRow = sheetObj.FindCheckedRow(prefix + "DelChk");

		if (sRow == "") {
			ComShowMessage(ComGetMsg('COM12189'));
			//ComShowMessage(ComGetMsg('FMS01153'));
			return fileKey;
		} else {
			var arrRow = sRow.split("|");
			
			for (var idx=arrRow.length-2; idx>=0; idx--) {
				var row = arrRow[idx];
				
				if(sheetObj.CellValue(row,prefix + "file_sav_id") == "") {
					ComShowMessage(ComGetMsg('FMS01148', row));
					//ComShowMessage("파일이 저장되지 않았습니다\n\n[저장되지않은 ROW : "+row+"]");
					return "";
					break;
				}
				
				fileKey += sheetObj.CellValue(row,prefix + "file_sav_id")+";";
			}
		}

		fileKey = fileKey.substring(0,fileKey.length-1);

		return fileKey;
	}
	
	/**
     * IBSheet 입력값에 대한 날짜 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String} 	value    	sheetObj의 입력값
     * @param {String} 	prefix   	변수 구분값
     * @see #ComRowHideDelete
     **/
	function rowRemove(sheetObj, prefix) {
		ComRowHideDelete(sheetObj, prefix + "DelChk");
		
		/*
    	var sRow = sheetObj.FindCheckedRow(prefix + "DelChk");
		if (sRow == "") return;
		
		//가져온 행을 배열로 반든다.
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		for (var idx=arrRow.length-2; idx>=0; idx--){
			var row = arrRow[idx];

			sheetObj.RowHidden(row)= true;
			sheetObj.RowStatus(row)= "D";
		}
		*/
	}

	
    /**
     * IBSheet Grid의 입력값 중 숨겨지지 않은 처음 행을 찾는다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {row} 	row			row 번호
     * @see #sheet_chekPeriod
     **/
	function getFirstRow(sheetObj){
		for (var ir=sheetObj.HeaderRows; ir<sheetObj.LastRow; ir++){
			if (sheetObj.RowHidden(ir)==false){
				return ir;
			}
		}
		return -1;
	}

    /**
     * IBSheet Grid의 입력값 중 숨겨지지 않은 마지막 행을 찾는다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {row} 	row 		row 번호
     **/
	function getLastRow(sheetObj){
		for (var ir=sheetObj.LastRow; ir>=sheetObj.HeaderRows; ir--){
			if (sheetObj.RowHidden(ir)==false){
				return ir;
			}
		}
		return -1;
	}
	
	/**
     * IBSheet Grid의 입력값 중 숨겨지지 않은 가장 작은 값을 찾는다. <br>
     * @param {ibsheet} 	sheetObj    IBSheet Object
     * @return {arrEffDt} 	arrEffDt	가장 작은 From Date
     **/
	function getLeastValue(sheetObj){
		
		var arrEffDt = new Array();
		var i = 0;
		
		for (var ir=sheetObj.HeaderRows; ir<=sheetObj.LastRow; ir++){
			if (sheetObj.RowHidden(ir)==false){
				arrEffDt[i++] = sheetObj.CellText(ir,"otr_eff_dt");
			}
		}

		for(var j=0; j<arrEffDt.length; j++) {
			for(var k=j; k<arrEffDt.length; k++) {
				if(arrEffDt[j]>arrEffDt[k]) {
					var tmp = arrEffDt[j];
					arrEffDt[j] = arrEffDt[k];
					arrEffDt[k] = tmp;
				}
			}
		}

		return arrEffDt[0].trimAll("-");
	}
	
	/**
     * IBSheet Grid의 입력값 중 숨겨지지 않은 가장 큰 값을 찾는다. <br>
     * @param {ibsheet} 	sheetObj    IBSheet Object
     * @return {arrExpDt} 	arrExpDt	가장 큰 To Date
     **/
	function getGreatestValue(sheetObj){
		var arrExpDt = new Array();
		var i = 0;
		
		for (var ir=sheetObj.HeaderRows; ir<=sheetObj.LastRow; ir++){
			if (sheetObj.RowHidden(ir)==false){
				arrExpDt[i++] = sheetObj.CellText(ir,"otr_exp_dt");
			}
		}

		for(var j=0; j<arrExpDt.length; j++) {
			for(var k=j; k<arrExpDt.length; k++) {
				if(arrExpDt[j]<arrExpDt[k]) {
					var tmp = arrExpDt[j];
					arrExpDt[j] = arrExpDt[k];
					arrExpDt[k] = tmp;
				}
			}
		}

		return arrExpDt[0].trimAll("-");
	}
	
	/**
     * 현재 Item Name 에 해당하는 가장 큰 날짜를 구한다.(숨겨지지 않은 가장 큰 값  찾기(Other Exp탭)) <br>
     * @param {ibsheet} 	sheetObj    	IBSheet Object
     * @param {ibsheet} 	row     		sheetObj의 선택된 Row
     * @param {String} 		currAcctItmNm   현재 Item Name
     * @return {arrExpDt} 	arrExpDt		해당 Item Name에서 가장 큰 값
     **/
	function getOtrGreatestValue(sheetObj, row, currAcctItmNm){
		var arrExpDt = new Array();
		var i = 0;

		for (var ir=sheetObj.HeaderRows; ir<=sheetObj.LastRow; ir++){
			if (   sheetObj.RowHidden(ir)==false 
				&& row != ir
				&& currAcctItmNm == sheetObj.CellValue(ir,"otr_acct_itm_nm")){

				arrExpDt[i++] = sheetObj.CellText(ir,"otr_exp_dt");
			}
		}

		for(var j=0; j<arrExpDt.length; j++) {
			for(var k=j; k<arrExpDt.length; k++) {
				if(arrExpDt[j]<arrExpDt[k]) {
					var tmp = arrExpDt[j];
					arrExpDt[j] = arrExpDt[k];
					arrExpDt[k] = tmp;
				}
			}
		}

		return arrExpDt[0].trimAll("-");
	}
	
	/**
     * 현재 Item Name 에 해당하는 가장 작은 날짜를 구한다.(숨겨지지 않은 가장 작은 값  찾기(Other Exp탭)) <br>
     * @param {sheetObj}    sheetObj 			Object
     * @param {String} 		prefix   			변수 구분값
     * @returns String,  	preOtrAcctItmNm 	Item Name 에 해당하는 가장 작은 row<br>
     **/
	function setFirstOtrEffDtCellEditable(sheetObj, prefix){
		var preOtrAcctItmNm;
		var currOtrAcctItmNm;

		for(var ir=sheetObj.HeaderRows; ir<=sheetObj.LastRow; ir++){
			currOtrAcctItmNm = sheetObj.CellValue(ir,"otr_acct_itm_nm");
			
			if(preOtrAcctItmNm != currOtrAcctItmNm) {
				sheetObj.CellEditable(ir,prefix + "eff_dt")= true;
			}
			
			preOtrAcctItmNm = sheetObj.CellValue(ir,"otr_acct_itm_nm");
		}
	}
	

	/**
     * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	변수 구분값
     **/
	function setFileUpload(sheetObj, prefix) {
		//트랜잭션 상태가 "입력"인 행을 찾아 온다.
		var sRow = sheetObj.FindStatusRow("I");
		var upObj = uploadObjects[0];
		var arrRow = sRow.split(";");
		
		for (idx=0; idx<arrRow.length-1; idx++){ 
			var row = arrRow[idx];
			
			//파일 경로 가져오기
			var sFile = sheetObj.CellValue(row,prefix + "file_path");		
			if (sFile=="") ComShowMessage(ComGetMsg('FMS01075'));
			
			//IBUpload에 파일 추가하기
			var ret = upObj.AddFile(sFile);
		}
		
		var param = prefix + "file_cnt=" + (arrRow.length-1); 

		return param; 
	}
	
	/**
     * Date삭제 여부 결정 <br>
     * @return {boolean} okYn 삭제 여부
     **/
	function delConfirm() {
		if(comboObjects[1].Code == "ACT") {
			ComShowMessage(ComGetMsg('FMS01082'));
			return;
		}
		
		var okYn = ComShowConfirm(ComGetMsg('FMS00012',ComGetMsg('FMS01090')));
		
		return okYn;
	}
	
	/**
     * IBSheet 입력값 중 Currency Code값의 존재 여부를 판단하다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String} 	value    	sheetObj의 입력값
     * @param {String} 	prefix   	변수 구분값
     * @return {없음}
     * @see #setCurrCd
     **/
    function currencyOnChange(sheetObj,row,col,value,prefix) {
    	
    	if(sheetObj.ColSaveName(col)==(prefix + "hir_curr_n1st_cd")) {
    		var hirCurrN1stCdCol = sheetObj.SaveNameCol(prefix + "hir_curr_n1st_cd");
    		var hirCurrN1stCdValue = sheetObj.CellValue(row,hirCurrN1stCdCol);

    		if(hirCurrN1stCdValue == "") return;
    		
    		if(hirCurrN1stCdValue.length < 3) {
    			ComShowMessage(ComGetMsg('FMS01077'));
	    		sheetObj.CellValue2(row,hirCurrN1stCdCol) = "";
				sheetObj.SelectCell(row,hirCurrN1stCdCol);
				return;
    		}
    		
    		form.curr_cd.value = hirCurrN1stCdValue;

			setCurrCd(row, "hirCurrN1stCd");
			
    	} else if (sheetObj.ColSaveName(col)==(prefix + "hir_curr_n2nd_cd")) {
            var hirCurrN2ndCdCol = sheetObj.SaveNameCol(prefix + "hir_curr_n2nd_cd");
            var hirCurrN2ndCdValue = sheetObj.CellValue(row,hirCurrN2ndCdCol);
            
            if(hirCurrN2ndCdValue == "") return;
            
            if(hirCurrN2ndCdValue.length < 3) {
    			ComShowMessage(ComGetMsg('FMS01077'));
	    		sheetObj.CellValue2(row,hirCurrN2ndCdCol) = "";
				sheetObj.SelectCell(row,hirCurrN2ndCdCol);
				return;
    		}
    		
    		form.curr_cd.value = hirCurrN2ndCdValue;
    		
			setCurrCd(row, "hirCurrN2ndCd");
			
    	} else if (sheetObj.ColSaveName(col)==(prefix + "curr_cd")) {
            var currCdCol = sheetObj.SaveNameCol(prefix + "curr_cd");
            var currCdValue = sheetObj.CellValue(row,currCdCol);
            
            if(currCdValue == "") return;
            
            if(currCdValue.length < 3) {
    			ComShowMessage(ComGetMsg('FMS01077'));
	    		sheetObj.CellValue2(row,currCdCol) = "";
				sheetObj.SelectCell(row,currCdCol);
				return;
    		}
    		
    		form.curr_cd.value = currCdValue;
    		
			setCurrCd(row, "currCd");
    	}
	}
    
    /**
     * IBSheet 입력값 중 Currency2 값과 Daily Hire 값이 정확히 입력되었는지 체크한다  <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String} 	value    	sheetObj의 입력값
     * @param {String} 	prefix   	변수 구분값
     * @return {없음}
     * @see #setCurrCd
     **/
    function currency2OnChange(sheetObj,row,col,value,prefix) {
		
    	if (sheetObj.ColSaveName(col)==(prefix + "hir_rt_n2nd_amt")) {
    		var hirCurrN2ndCdCol = sheetObj.SaveNameCol(prefix + "hir_curr_n2nd_cd");
            var hirCurrN2ndCdValue = sheetObj.CellValue(row,hirCurrN2ndCdCol);
            
            var hirRtN2ndAmtCol = sheetObj.SaveNameCol(prefix + "hir_rt_n2nd_amt");
            var hirRtN2ndAmtValue = sheetObj.CellValue(row,hirRtN2ndAmtCol);
            
            if(hirRtN2ndAmtValue == "") {
            	return;
            } else {
            	if(sheetObj.CellValue(row,prefix + "hir_rt_n2nd_amt") < 1) {
            		ComShowMessage(ComGetMsg('FMS01163'));
        			sheetObj.ValidateFail = true;
            	} else {
            		if(hirCurrN2ndCdValue == "") {
            			sheetObj.ValidateFail = true;
            		}
            	}
            }
    	}
	}
    
    /**
     * Currency Code 정보를 가져온다 <br>
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     **/
    function setCurrCd(row, gubun) {
    	if(gubun == "currCd") {
    		doActionIBSheet(sheetObjects[2], document.form, IBROWSEARCH, gubun, row);
    		
    	} else {
    		doActionIBSheet(sheetObjects[1], document.form, IBROWSEARCH, gubun, row);
    	}
    }
    
    /**
     * Currency Code 입력시 DB에 존재하는 코드값인지 체크한다. <br>
     * @param {string}	currencyValue    currencyValue 셀의 변경된 값
     * @returns {bool} 코드 존재 여부 <br>
     *          true  : 코드가 존재하는 경우<br>
     *          false : 코드가 존재하지 않는 경우<br>
     **/
    function currency_code_check(currencyValue) {

    	var existCnt = 0;
    	
    	for(var i=0; i<form.currency_cd.length; i++) {
    		if(form.currency_cd[i].value == currencyValue) {
    			existCnt++;
    			break;
    		}
        }

    	if(existCnt == 0)
    		return false;
    	else
    		return true;	
    }
    
    /**
     * 이벤트 발생시 실행여부 확인 <br>
     * @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
     **/
    function initConfirm() {
    	var okYn = true;

    	//if(sheetObjects[0].RowCount > 0 && rowChangeYn()) {
    	if(   sheetObjects[1].isDataModified
    	   || sheetObjects[2].isDataModified
    	   || sheetObjects[3].isDataModified
    	   || (sheetObjects[4].isDataModified && sheetObjects[4].RowCount > 1)
    	   || sheetObjects[5].isDataModified
    	   || sheetObjects[6].isDataModified
    	   || sheetObjects[7].isDataModified) {
    		
    		var okYn = confirm(ComGetMsg('FMS00002'));
    	}
    	
    	return okYn;
    }
    
    /**
	 * Customr Code 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setCustomrCode(aryPopupData, Row, Col, sheetIdx){
		form.vndr_lgl_eng_nm.value = aryPopupData[0][3];
		form.cust_cnt_cd.value = aryPopupData[0][4];
		form.cust_seq.value = aryPopupData[0][5];
		
		form.ownr_nm.value = aryPopupData[0][6];
		//ownr_seq = aryPopupData[0][7];
		
		//alert("ddddd ->" +  ownr_seq)
		cust_seq_change();
	}

    
    /**
	 * Owner Name 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setVendorCode(aryPopupData, Row, Col, sheetIdx){
		 form.vndr_lgl_eng_nm.value = aryPopupData[0][3];
		 form.cust_seq.value = aryPopupData[0][5];
		
		 form.ownr_nm.value = aryPopupData[0][6];
		 //ownr_seq = aryPopupData[0][7];

		cust_seq_change();
	}
	
	 /**
	 * Owner Name 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setOwnrNm(aryPopupData, Row, Col, sheetIdx){
		form.ownr_nm.value = aryPopupData[0][4];
		ownr_seq = aryPopupData[0][3];
		
		//alert("ddddd ->" +  ownr_seq)
	}
		
	/**
	 * Flag Name 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setFlagCode(aryPopupData, Row, Col, sheetIdx) {
		form.vsl_cnt_cd.value = aryPopupData[0][3];
		form.cnt_nm.value = aryPopupData[0][4];
	}
	
    /**
     * Uom Combo 박스를 만든다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Type 의 코드에 해당하는 Name
     * @param {String}  comboCode   Type 의 코드값
     **/
    function setPayTermMakeCombo(sheetObj, comboText, comboCode) {
    	if(comboText != "" ) {
    		var typeText = comboText.substring(0,comboText.length-1);
    		var typeCode = comboCode.substring(0,comboCode.length-1);
        	
        	sheetObj.InitDataCombo(0, "pay_ctrt_pay_term_cd", typeText, typeCode);
    	}
    }
    
    /**
     * Contract Type/Contract Fact 콤보를 세팅한다 <br>
     * @param {ibsheet} comboObj    IBSheet Object
     * @param {String} 	comboText   combo Name 값
     * @param {String} 	comboCode   combo Value 값
     * @return {없음}
     **/
	function setDataCombo(comboObj, comboText, comboCode) {
		
        switch(comboObj.id) {
            case "flet_ctrt_tp_cd":
            	
            	if(comboText != "" ) {
	            	var comboTextList = comboText.split("|");
	            	var comboCodeList = comboCode.split("|");
	            	
	            	for(var i=0; i < comboTextList.length-1; i++) {
	            		comboObj.InsertItem(i, comboTextList[i], comboCodeList[i]);
	            	}
	            	
	            	comboObj.Code = comboCodeList[0];
	            	
	            	comboObj.BackColor = "#CCFFFD";
            	}
                break;
                
            case "flet_ctrt_fact_cd":
            	
            	if(comboText != "" ) {
	            	var comboTextList = comboText.split("|");
	            	var comboCodeList = comboCode.split("|");
	            	
	            	for(var i=0; i < comboTextList.length-1; i++) {
	            		comboObj.InsertItem(i, comboTextList[i], comboCodeList[i]);
	            	}
	            	
	            	comboObj.Code = comboCodeList[0];
	            	
	            	comboObj.BackColor = "#CCFFFD";
            	}
                break;
        } 
    }
	
	/**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
    /*
    function t7sheet1_OnClick(sheetObj, row, col) {
    	if(sheetObj.ColSaveName(col)=="vsl_use_flg") {
    		var useFlgCol = sheetObj.SaveNameCol("vsl_use_flg");
    		var useFlgValue = sheetObj.CellValue(row,useFlgCol);
    		
    		if(useFlgValue == "0") {
    			var iCheckRow2 = sheetObj.CheckedRows("vsl_use_flg");

    			if(iCheckRow2 == 1) {
    				sheetObj.CellValue(row,"vsl_use_flg") = 1;
    				ComShowMessage(ComGetMsg('FMS01085'));
    			}
    		}
    	}
    }
    */
    
    /**
     * Contract Fact 값이 PSE 인 경우 수정 불가능하게 한다 <br>
     * @return {없음}
     **/
    function setOwnerCodeReadOnly() {
    	form.cust_cnt_cd.readOnly = true;
    	form.cust_seq.readOnly = true;
    	form.owner_code.style.cursor = "default";
    	document.images["owner_code"].name = "no_owner_code";
    	
    	form.cust_cnt_cd.className = "input2";
    	form.cust_seq.className = "input2";
    }
     
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string}  prefix     	변수 구분자
     * @param {string}  curSaveName currency saveName
     * @param {string}  amtSaveName amt saveName
     **/
    function setInitCellProperty(sheetObj, prefix, curSaveName, amtSaveName, col) {
    	if(curSaveName == null || curSaveName == "") {
	    	for(var ir=1; ir<=sheetObj.LastRow; ir++) {
				if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, prefix + "hir_curr_n1st_cd"))) {
					
					sheetObj.InitCellProperty(ir, 6, dtNull, daRight, prefix+"hir_rt_n1st_amt", "", dfNullInteger);
				}
				
				if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, prefix + "hir_curr_n2nd_cd"))) {
					
					sheetObj.InitCellProperty(ir, 8, dtNull, daRight, prefix+"hir_rt_n2nd_amt", "", dfNullInteger);
				}
			}
	    	
    	} else {
    		for(var ir=1; ir<=sheetObj.LastRow; ir++) {
				if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, prefix + curSaveName))) {
					if(col == null || col == "") {
						sheetObj.InitCellProperty(ir, 8, dtNull, daRight, prefix+ amtSaveName, "", dfNullInteger);
					} else {
						sheetObj.InitCellProperty(ir, col, dtNull, daRight, prefix+ amtSaveName, "", dfNullInteger);
					}
				}
			}
    	}
    }

	/**
     * t2sheet1 에 대한 에러처리 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg   	Error Message 값
     * @return {없음}
     **/
	function imsi_t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.ShowSubSum("a", "a", 0 , true, false, 3, "0=;1=;2=;");

		var sRow = sheetObj.FindSubSumRow("a");
		var arrRow = sRow.split("|");

		for(idx =0; idx < arrRow.length-1 ; idx++) {
			if(sheetObj.CellValue(parseInt(arrRow[idx])+1, "a") =="AA" ) {
				sheetObj.CellValue2(arrRow[idx],"d") = "▶ Discrepancy by Detail Date";
			} else if(sheetObj.CellValue(parseInt(arrRow[idx])+1, "a") =="BB" ) {
				sheetObj.CellValue2(arrRow[idx],"d") = "▶ Duplicate";
			} else if(sheetObj.CellValue(parseInt(arrRow[idx])+1, "a") =="CC" ) {
				sheetObj.CellValue2(arrRow[idx],"d") = "▶ SML List Only";
			} else if(sheetObj.CellValue(parseInt(arrRow[idx])+1, "a") =="DD" ) {
				sheetObj.CellValue2(arrRow[idx],"d") = "▶ Invoice Only";
			} else if(sheetObj.CellValue(parseInt(arrRow[idx])+1, "a") =="EE" ) {
				sheetObj.CellValue2(arrRow[idx],"d") = "▶ Double Bill";
			}
		}
	}
	
	/**
     * t3sheet1 에 대한 에러처리 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg   	Error Message 값
     * @return {없음}
     **/
	function imsi_t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.ShowSubSum("a", "a", 0 , true, false, 3, "0=;1=;2=;");

		var sRow = sheetObj.FindSubSumRow("a");
		var arrRow = sRow.split("|");

		for(idx =0; idx < arrRow.length-1 ; idx++) {
			if(sheetObj.CellValue(parseInt(arrRow[idx])+1, "a") =="A" ) {
				sheetObj.CellValue2(arrRow[idx],"d") = "▶ Auto Calculated Cost";
			} else if(sheetObj.CellValue(parseInt(arrRow[idx])+1, "a") =="M" ) {
				sheetObj.CellValue2(arrRow[idx],"d") = "▶ Manual Input Cost";
			}
		}
	}
	
	/**
     * GW return 함수 <br>
     * @param {String}	msg
     * @return {없음}
     **/	
	var returnGwLink = function(msg){				
		msg = msg.split(",");
        /* IBTab 초기화 */
        var formObj = document.form;
        var gw_no = msg[0];
        var gw_desc = msg[1];

        ComSetObjValue(formObj.agmt_doc_no, gw_no);
        ComSetObjValue(formObj.agmt_doc_desc, gw_desc);
	}
	
	/**
     * DoSave로 저장 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function sheet2_OnSaveEnd(sheetObj, ErrMsg) { 		
		var formObject = document.form;
		  
	      if (ErrMsg == "Save is Successful") {
			formObject.agmt_doc_no.value = '';
			formObject.agmt_doc_desc.value = '';		    	 
	      }
	}	
	
	/**
     * GW문서 오픈 <br>
     **/
	function fnDocOpen(sw){				
		if(document.all.btn_save.style.display == 'none'){
			return;
		}

        var iframeObj = document.getElementsByTagName("IFRAME");

        for (var i = 0; i < iframeObj.length; i++) {
               if(iframeObj[i].id == "gwrequest")
                   iframeObj[i].parentNode.removeChild(iframeObj[i]);
        }
        
		ifrm = document.createElement("IFRAME");
		ifrm.setAttribute("id", "gwrequest");
		ifrm.style.width = 0+"px";
		ifrm.style.height = 0+"px";		
		
		var csrGwUrl = document.form.csr_gw_url.value;
		var url = "";
				
		if(sw == 'item'){			
			url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACT&parameter=ALPS|FMS");
			ifrm.setAttribute("src", url);
			document.body.appendChild(ifrm);			
		}else{
			var assetcd = document.form.agmt_doc_no.value;
			if(assetcd != ''){
				url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACTVIEW&parameter="+assetcd);
				ifrm.setAttribute("src", url);
				document.body.appendChild(ifrm);				
			}			
		}
	}
	
	
	// return 처리를 위한 함수 (필수)
    function receiveMessage(event) {
           // 리턴 처리 방법
          returnGwLink(event.data)
    }

    if(window.addEventListener) {
          window.addEventListener("message", receiveMessage, false);
    }

    if(window.attachEvent) {
        window.attachEvent("onmessage", receiveMessage);
    }
    
    if(document.attachEvent) {
        document.attachEvent("onmessage", receiveMessage);
    }