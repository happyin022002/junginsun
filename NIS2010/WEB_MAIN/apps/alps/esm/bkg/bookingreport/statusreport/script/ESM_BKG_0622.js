/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0622.js
*@FileTitle : Outbound Container Movement Status
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.31
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.01.31 조정민
* 1.0 Creation
* 2013.04.08 김진주 [CHM-201323813] 미반입 관리 관련 sms 전송 기능 개발 요청
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
     * @class esm_bkg_0622 : esm_bkg_0622 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0622() {
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
 var rdObjects = new Array();
 var rdCnt = 0;
 var maxCtrl = 0;
 var comboObjects = new Array();
 var comboCnt = 0; 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }
     /**
      * 콤보 초기설정값
      * @param {IBMultiCombo} comboObj  comboObj
      */
      function initCombo(comboObj) {
      	comboObj.MultiSelect = false;
//      	comboObj.UseCode = true;
      	comboObj.LineColor = "#ffffff";
      	comboObj.SetColAlign("left|left");
      	comboObj.MultiSeparator = "|";	
      }
      /**
       * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
       * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
       **/
       function setComboObject(combo_obj){
         comboObjects[comboCnt++] = combo_obj;
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
         
    	    // IBMultiCombo초기화
    	    for(var j=0; j<comboObjects.length; j++){
    	        initCombo(comboObjects[j]);
    	    }

		 doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
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
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); //- 키보드 입력할때
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');          

      }
	   function bkg_keypress(){
		    switch(event.srcElement.dataformat){
		    	case "ymd":
		        //number
		        ComKeyOnlyNumber(event.srcElement, "-");
		        break;
		    	case "engup":
		        //영문대문자
	    			ComKeyOnlyAlphabet('upper');
		        break;
		      case "engupnum":
		        //숫자+"영문대문자"입력하기
		      	ComKeyOnlyAlphabet('uppernum');
		        break;
		      case "num":
		        //숫자 입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
		      case "custname":
		        //영문,숫자,공백,기타문자(.,등)
		        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
		      break;	            
		      default:
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
 								style.height = 310;
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
 								
 								var HeadTitle1 = "||Seq.|Trade|S/Trd|Lane|Booking No.|Container No.|POR|A.POD|DEL|TPSZ|R TERM|MVMT\nST|Current\nYard|Current\nEvent Time|VVD\nType|MODE|N/Exeption|DG|DG|RF|RF|AK|AK|STOW|Shipper|Shipper|Shipper|Shipper|SML BKG|SML BKG|SML BKG|SALES REP|SALES REP|SALES REP||CONTACT|CONTACT|EMAIL|SMS|emlSnd|mblSnd|shprNtc|bkgPicNtc|srepNtc|obPicNtc|||";
 								var HeadTitle2 = "||Seq.|Trade|S/Trd|Lane|Booking No.|Container No.|POR|A.POD|DEL|TPSZ|R TERM|MVMT\nST|Current\nYard|Current\nEvent Time|VVD\nType|MODE|N/Exeption|DG|DG|RF|RF|AK|AK|STOW|Name|PIC|H/P|EAMIL|PIC|H/P|EAMIL|PIC|H/P|EAMIL||H/P|EMAIL|EMAIL|SMS|flg|flg|flg|flg|flg|flg|||";
 								
 								var headCount = ComCountHeadTitle(HeadTitle1);

 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount, 0, 0, true);

 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(true, true, false, false, false,false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								InitHeadRow(1, HeadTitle2, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,			10,		daCenter,		true,		"ibflag");
 								InitDataProperty(0,		cnt++ , dtCheckBox,				20,		daCenter,		true,		"Sel",				false,		"",		dfNone,			0,		true,	true);
 								InitDataProperty(0,		cnt++ , dtSeq,					30,		daCenter,		true,		"Seq",				false,		"",		dfNone,			0,		true,	true); 								
 								InitDataProperty(0,		cnt++ , dtData,					40,	    daCenter,		true,		"trd_cd",			false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					40,	    daCenter,		true,		"sub_trd_cd",		false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"slan_cd",			false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					90,	    daCenter,		true,		"bkg_no",			false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					90,	    daCenter,		true,		"cntr_no",			false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"por_cd",			false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"pod_cd",			false,		"",		dfNone,			0,		false,	false);
 								
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"del_cd",			false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					45,		daCenter,		true,		"cntr_tpsz_cd",		false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"rcv_term_cd",		false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"cnmv_sts_cd",		false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		"org_yd_cd",		false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					130,	daCenter,		true,		"cnmv_evnt_dt",		false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"vsl_pre_pst_cd",	false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"trns_mode",		false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					110,	daCenter,		true,		"ntc_exp",		    false,		"",		dfNone,			0,		false,	true);
 								
 								InitDataProperty(0, 	cnt++ , dtHidden,				30,		daCenter,		true,		"dg_sts",			false,		"",     dfNone,			0,		false,	false);
 								InitDataProperty(0, 	cnt++ , dtData,					70,		daCenter,		true,		"dg_desc",			false,		"",     dfNone,			0,		false,	false);
 								InitDataProperty(0, 	cnt++ , dtHidden,				30,		daCenter,		true,		"rf_sts",			false,		"",     dfNone,			0,		false,	false);
 								InitDataProperty(0, 	cnt++ , dtData,					70,		daCenter,		true,		"rf_desc",			false,		"",     dfNone,			0,		false,	false);
 								InitDataProperty(0, 	cnt++ , dtHidden,				30,		daCenter,		true,		"ak_sts",			false,		"",     dfNone,			0,		false,	false);
 								InitDataProperty(0, 	cnt++ , dtData,					100,	daCenter,		true,		"ak_desc",			false,		"",     dfNone,			0,		false,	false); 								
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"stwg_cd",		    false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					180,	daLeft,		    true,		"shpr_nm",		    false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					85,		daLeft,			true,		"shpr_pic",		    false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		"shpr_mphn_no",		false,		"",		dfNone,			0,		true,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				100,	daLeft,			true,		"shpr_eml",		    false,		"",		dfNone,			0,		false,	true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"bkg_pic",		    false,		"",		dfNone,			0,		false,	true); 								
 								InitDataProperty(0,		cnt++ , dtData,					85,		daCenter,		true,		"bkg_mphn_no",		false,		"",		dfNone,			0,		true,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				80,		daLeft,			true,		"bkg_eml",			false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"srep_pic",			false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					85,		daCenter,		true,		"srep_mphn_no",		false,		"",		dfNone,			0,		true,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				100,	daLeft,			true,		"srep_eml",			false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				105,	daCenter,		true,		"ctrt_ofc_phn_no",	false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				105,	daCenter,		true,		"cntc_mphn_no",		false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				100,	daLeft,			true,		"cntc_eml",			false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		true,		"eml_snd_dt",		false,		"",		dfNone,			0,		false,	true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"sms_snd_dt",		false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				100,	daCenter,		true,		"eml_snd_flg",		false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				100,	daCenter,		true,		"mbl_snd_flg",		false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				100,	daCenter,		true,		"shpr_ntc_flg",		false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				100,	daCenter,		true,		"bkg_pic_ntc_flg",	false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				100,	daCenter,		true,		"srep_ntc_flg",		false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				100,	daCenter,		true,		"ob_pic_ntc_flg",	false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				50,		daCenter,		true,		"tml_gi_sts",		false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				50,		daCenter,		true,		"cntr_cnt",			false,		"",		dfNone,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,				50,		daCenter,		true,		"vvd",				false,		"",		dfNone,			0,		false,	true);
 								sheetObj.HeadCheck(0,1) = false;
 								sheetObj.HeadCheck(1,1) = false;
 								sheetObj.FrozenCols = 8;

 						}
 						break;
 						
 						
 	                case "sheet2":      //sheet2 init
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
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 2, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(16, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        var HeadTitle1 = "|CNTR|CNTR|MVMT|MVMT|MVMT|MVMT|MVMT|MVMT|Trans Mode|Trans Mode|Trans Mode|e-Mail|e-Mail|SMS|SMS";
                        var HeadTitle2 = "|TP/SZ|Count|OP|OC|EN + TN|VL|Other|MT|S/TRK|HJT|SHUTTLE|Sent|Un-Sent|Sent|Un-Sent";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,			"Status");
						InitDataProperty(0, cnt++ , dtData,		    65,		daCenter,	true,			"cntr_tpsz_cd",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		    65,		daCenter,	true,			"sum_cntr",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		    65,		daCenter,	true,			"sum_mvmt_op",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		    65,		daCenter,	true,	    	"sum_mvmt_oc",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		    65,		daCenter,	true,			"sum_mvmt_entn",	false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,			"sum_mvmt_vl",		false,			"",      dfNone,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,			"sum_mvmt_othr",	false,			"",      dfNone,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,			"sum_mvmt_mty",		false,			"",      dfNone,			2,		true,		true);
						
						InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,			"sum_trns_st",		false,			"",      dfNone,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,			"sum_trns_hjt",		false,			"",      dfNone,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,			"sum_trns_shut",	false,			"",      dfNone,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,			"sum_eml_snt",		false,			"",      dfNone,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			66,		daCenter,	true,			"sum_eml_unsnt",	false,			"",      dfNone,			2,		true,		true);
						
						InitDataProperty(0, cnt++ , dtData,			67,		daCenter,	true,			"sum_sns_snt",		false,			"",      dfNone,			2,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			67,		daCenter,	true,			"sum_sns_unsnt",	false,			"",      dfNone,			2,		true,		true);
						CountPosition = 0; 	
						
                   }
                    break;   
 			

 			}
 	}
      
      
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

  						case "btn_Retrieve":
    	    				if(!validateForm(sheetObject,document.form,"btn_Retrieve")) {
    	    					return false;
    	    				}
  							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  						break;
  						
  						case "btn_save":
  							doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
  						break;

    					case "btn_New":
    						sheetObjects[0].RemoveAll();
    						sheetObjects[1].RemoveAll();
    	 					ComResetAll();
    	 					formObject.bkg_cgo_tp_cd.index = 0;
    						break;
    						
    					case "btn_DownExcel":
    	    				if(!validateForm(sheetObject,document.form,"btn_DownExcel")) {
    	    					return false;
    	    				}
    	 					doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
    	 					break;	
    	 					
    					case "btn_EQHistory":
    						var srow =sheetObjects[0].SelectRow;
    						var tmp = sheetObjects[0].CellValue(srow, "cntr_no");
    						
    						if (tmp == "" || tmp.length != 11 ){
    							ComShowCodeMessage('BKG40055');
    							return;
    						}
    						
    						var cntrNo = (tmp != null && tmp.length>10) ? tmp.substring(0,10) : tmp;;
    	                    var checkDigit = (tmp != null && tmp.length>10) ? tmp.substring(10) : '';
    						var typeSize = sheetObjects[0].CellValue(srow, "cntr_tpsz_cd");
    						
    						var url = "EES_CTM_0411.do?func=&cntrNo="+cntrNo+"&checkDigit="+checkDigit+"&typeSize="+typeSize;
    						ComOpenWindowCenter(url, "EES_CTM_0411", 1010, 650, false);
    						break;
    						
    	                case "btn_Send":
    	    				if(!validateForm(sheetObject,document.form,"btn_Send")) {
    	    					return false;
    	    				}
    	                    doActionIBSheet(sheetObjects[0],document.form,MULTI);
    	                    break;
    					case "btn_print":
    						rdOpen(rdObjects[0], document.form);
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
      
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			
			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
	        	sheetObj.WaitImageVisible=false;
 	        	ComOpenWait(true);

 	        	 
 	        	var sXml = sheetObj.GetSearchXml("ESM_BKG_0622GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 1) 
					sheetObjects[1].LoadSearchXml(arrXml[1]); 
				if (arrXml.length > 0) 
					sheetObjects[0].LoadSearchXml(arrXml[0]); 

			break;
		
			case SEARCH01: 
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0622GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) 
					ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");			
				if (arrXml.length > 1) 
					ComBkgXml2ComboItem(arrXml[1], comboObjects[1], "val", "name");	
				if (arrXml.length > 2) 
					ComXml2ComboItem(arrXml[2], formObj.bkg_cgo_tp_cd, "val", "desc");
				formObj.bkg_cgo_tp_cd.InsertItem(0,"ALL","");
				formObj.bkg_cgo_tp_cd.index2 = 0;
            
			break;	
			
			
           case IBDOWNEXCEL:   
   				sheetObj.SpeedDown2Excel(-1);
   				break;	 
   				
   				
			case MULTI:   
				var params = sheetObj.GetSaveString(false, true, "ibflag");
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0622GS.do", "f_cmd=" + MULTI + "&" +params);
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComShowMessage(msgs['BKG00204']);

				} else {
//					sheetObj.loadSaveXml(sXml);
				}
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
         }
         
         ComOpenWait(false);
     }
   
	function rdOpen(rdObject, formObject){
		var sheetObj = sheetObjects[0];
		var Rdviewer = rdObject;

		var rdParam = " /rv " + "VVD["+formObject.vvd.value+"] POL_CD["+formObject.pol_cd.value+"] " 
			+"POL_YD_CD["+formObject.pol_yd_cd.value+"] BKG_CGO_TP_CD["+formObject.bkg_cgo_tp_cd.Code+"] " 
			+"RCV_TERM_CD["+formObject.rcv_term_cd.Code+"] DE_TERM_CD["+formObject.de_term_cd.Code+"] "
			+"TRNS_MODE["+formObject.trns_mode.value+"] NTC_EXP["+formObject.ntc_exp.value+"] TML_GI_STS["+formObject.tml_gi_sts.value+"]";
		formObject.com_mrdBodyTitle.value = "OB CONTAINER MOVEMENT STATUS";
		var rdUrl = "apps/alps/esm/bkg/bookingreport/statusreport/report/";
		var rdFile = "ESM_BKG_0622_01.mrd";
		formObject.com_mrdPath.value = rdUrl+rdFile;
		formObject.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";

		ComOpenRDPopupModal("dialogWidth:990px;dialogHeight:600px");
	}
	
	
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
			case "btn_Preview":
				if (sheetObj.RowCount == 0) {
					ComShowMessage(msgs['BKG00495']);
					return false;
				}
				if (sheetObj.CheckedRows("Sel") == 0) {
					ComShowMessage(msgs['BKG00567']);
					return false;
				}

	
				if (sheetObj.CheckedRows("Sel") > 1) {
					ComShowMessage(msgs['BKG04019']);
					return false;
				}

				break;

			case "btn_Retrieve":
				if(formObj.vvd.value == ""){
					ComShowMessage(ComGetMsg("BKG00104", "VVD"));
					return false;
				}
				if(formObj.pol_cd.value == ""){
					ComShowMessage(ComGetMsg("BKG00104", "POL"));
					return false;
				}
				break;

			case "btn_Send":
				if (sheetObj.CheckedRows("Sel") == 0) {
					ComShowMessage(msgs['BKG00567']);
					return false;
				}

				break;
				
				
			case "btn_DownExcel":
				if (sheetObj.RowCount == 0) {
					ComShowMessage(msgs['BKG00495']);
					return false;
				}

				break;

			}
	    }
		return true;
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.ColFontUnderline("bkg_no")   = true;
		for (idx=0; idx < sheetObj.Rows; idx++){
			if(idx != 0){
				sheetObj.CellFontColor(idx, "bkg_no") = sheetObj.RgbColor(0, 0, 255);
			}
			
//			if(sheetObj.CellValue(idx,"tml_gi_sts") == "Y" || sheetObj.CellValue(idx,"ntc_exp") != ""){
//				sheetObj.CellEditable(idx,"Sel") = false;
//			}
			
			if(sheetObj.CellValue(idx,"shpr_ntc_flg") == "N" || sheetObj.CellValue(idx,"shpr_ntc_flg") == ""){
				sheetObj.CellEditable(idx,"shpr_mphn_no") = false;
			} else {
				sheetObj.CellEditable(idx,"shpr_mphn_no") = true;
			}

			if(sheetObj.CellValue(idx,"bkg_pic_ntc_flg") == "N" || sheetObj.CellValue(idx,"bkg_pic_ntc_flg") == ""){
				sheetObj.CellEditable(idx,"bkg_mphn_no") = false;
			} else {
				sheetObj.CellEditable(idx,"bkg_mphn_no") = true;
			}

			if(sheetObj.CellValue(idx,"srep_ntc_flg") == "N" || sheetObj.CellValue(idx,"srep_ntc_flg") == ""){
				sheetObj.CellEditable(idx,"srep_mphn_no") = false;
			} else {
				sheetObj.CellEditable(idx,"srep_mphn_no") = true;
			}

			if(sheetObj.CellValue(idx,"ob_pic_ntc_flg") == "N" || sheetObj.CellValue(idx,"ob_pic_ntc_flg") == ""){
				sheetObj.CellEditable(idx,"cntc_mphn_no") = false;
			} else {
				sheetObj.CellEditable(idx,"cntc_mphn_no") = true;
			}
		}
	}
	
	function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
   		if( colIdx == sheetObj.SaveNameCol("bkg_no")){
   			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, "bkg_no")); 
   		}
	}

	/* 개발자 작업  끝 */