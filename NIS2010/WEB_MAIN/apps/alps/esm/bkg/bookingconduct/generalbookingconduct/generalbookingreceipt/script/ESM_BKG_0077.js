/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0077.js
*@FileTitle : Booking Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.09 김병규
* 1.0 Creation
* ------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
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
     * @class ESM_BKG_0077 : ESM_BKG_0077 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0077() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		         var sheetObject = sheetObjects[0];
          /*******************************************************/
        var formObj = document.form;
        
		var bkgNo 		= ComGetObjValue(formObj.bkg_no);
		var bkgStsCd 	= ComGetObjValue(formObj.bkg_sts_cd);
		var bdrFlg 		= ComGetObjValue(formObj.bdr_flg);
		var bkgTrunkVvd = ComGetObjValue(formObj.bkg_trunk_vvd);
		var porCd 		= ComGetObjValue(formObj.por_cd);
		var polCd 		= ComGetObjValue(formObj.pol_cd);
		var podCd 		= ComGetObjValue(formObj.pod_cd);
		var delCd 		= ComGetObjValue(formObj.del_cd);
		var sCustCntCd 	= ComGetObjValue(formObj.s_cust_cnt_cd);
		var sCustSeq 	= ComGetObjValue(formObj.s_cust_seq);
		var fCustCntCd 	= ComGetObjValue(formObj.f_cust_cnt_cd);
		var fCustSeq 	= ComGetObjValue(formObj.f_cust_seq);		
		var cCustCntCd 	= ComGetObjValue(formObj.c_cust_cnt_cd);
		var cCustSeq 	= ComGetObjValue(formObj.c_cust_seq);		

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
         		case "btn_RfaNo":
         			comBkgCallPop0654('callBack0654',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq);
         			break;    	
         		case "btn_ScNo":
         			comBkgCallPop0655('callBack0655',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq);
         			break;    	  
         		case "btn_TtaNo":
            		comBkgCallPop1062('callBack1062',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq);
            		break;
 				case "btn_New": 					
					ComResetAll();
					ComSetObjValue(formObj.bkg_no, bkgNo);
					ComSetObjValue(formObj.bkg_sts_cd, bkgStsCd);
					ComSetObjValue(formObj.bdr_flg, bdrFlg);
 					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
 					break; 							
 				case "btn_Copy":
 					doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
 					break;  
				case "btn_Print":
					sheetObjects[1].ExcelPrint = "PrintOnly";
					sheetObjects[1].Down2Excel();				

					break;
				case "btn_Close":
					window.close();
					break; 							
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111"); 
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
        
        var formObj = document.form;
//		if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		// Cancel Booking Copy 시
//			ComShowCodeMessage("BKG00090");
//			window.close();
//		}else if(ComGetObjValue(formObj.bdr_flg) == "Y"){		// BDR 시
//			ComShowCodeMessage("BKG00091");
//			window.close();
//		}else{        	
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
//		}
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
	 	var formObj = document.form;
	
	     axon_event.addListenerFormat('keypress', 'obj_KeyPress',    formObj); //- 키보드 입력할때
		 axon_event.addListenerForm('beforedeactivate', 'bkg0077_deactivate',  formObj); //- 포커스 나갈때
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
         	case "sheet1":      //sheet1 init
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(21, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "||POL|POL|POL|POD|POD|POD|VVD|POL ETD|POL ETD|POL ETA|POL ETA";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		"ibflag");					 
  					InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,   false,    	"seq",     			false,          "",      dfNone,      	0,     false,     false);
  					InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,   false,     	"pol_cd",     		false,          "",      dfNone,      	0,     false,     false);
  					InitDataProperty(0, cnt++ , dtData,      		30,    	daCenter,   false,     	"pol_yd_cd",     	false,          "",      dfNone,      	0,     false,     false);  					
  					InitDataProperty(0, cnt++ , dtCombo,   			30,    	daCenter,  	false,     	"pol_clpt_ind_seq", false,          "",      dfNone,      	0,     true,      true);
  					InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,   false,     	"pod_cd",    		false,          "",      dfNone,      	0,     false,     false);
  					InitDataProperty(0, cnt++ , dtData,      		30,    	daCenter,   false,     	"pod_yd_cd",     	false,          "",      dfNone,      	0,     false,     false);
  					InitDataProperty(0, cnt++ , dtCombo,   			30,    	daCenter,  	false,     	"pod_clpt_ind_seq", false,          "",      dfNone,      	0,     true,      true);
  					InitDataProperty(0, cnt++ , dtPopupEdit,    	120,    daCenter,   false,     	"bkg_vvd_cd",    	false,          "",      dfNone,      	0,     true,      true,	9);
  					InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,   false,     	"etd_day",     		false,          "",      dfDateYmd,   	0,     false,     false);
  					InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,   false,     	"etd_time",     	false,          "",      dfTimeHm,     	0,     false,     false);
  					InitDataProperty(0, cnt++ , dtData,     		80,    	daCenter,   false,     	"eta_day",     		false,          "",      dfDateYmd,   	0,     false,     false);
  					InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,   false,     	"eta_time",     	false,          "",      dfTimeHm,     	0,     false,     false);
   					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"pol_clpt_ind_seq_list");
   					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"pod_clpt_ind_seq_list");
  					InitDataProperty(0, cnt++ , dtHidden,     		60,    	daCenter,   false,     	"slan_cd");			
  					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"vsl_pre_pst_cd");
  					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"voyage_time");
  					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"vsl_seq");
  					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"etd");
  					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"eta");
  					 
  					InitDataValid(0,  "bkg_vvd_cd",				vtEngUpOther,	"1234567890");		// 영문대문자+숫자 입력
  					
 					ShowButtonImage = 2; 
 					CountPosition = 0; 																				
                }
         		break;
         	case "sheet2":      //sheet2
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
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(3, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false);
	
	                var HeadTitle = "New Booking Number|New Booking Number|New Booking Number";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,      		220,    	daCenter,  false,    	"new0",     		false,          "",      dfNone,      	0,     false,     false);
					InitDataProperty(0, cnt++ , dtData,      		220,    	daCenter,  false,     	"new1",     		false,          "",      dfNone,      	0,     false,     false);
					InitDataProperty(0, cnt++ , dtData,      		220,    	daCenter,  false,     	"new2",     		false,          "",      dfNone,      	0,     false,     false);
	
					CountPosition = 0; 																				
	            }
             	break;
			case "sheet3":
				with (sheetObj) {
					// 높이 설정
					style.height = 82;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false)
					
					var HeadTitle = "TP/SZ|Vol.";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,		"c_tpsz",				false,		"",	dfNone,			0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,	false,		"c_qty",				false,		"",	dfNullFloat,	2,		true,		true, 5);
					
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
   				formObj.f_cmd.value = SEARCH;
         		var sXml = sheetObj.GetSearchXml("ESM_BKG_0077GS.do", FormQueryString(formObj));
         		BkgEtcDataXmlToForm(sXml, formObj);
         		sheetObj.LoadSearchXml(sXml);
				for (var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++ ){
					sheetObj.CellComboItem(i, "pol_clpt_ind_seq", sheetObj.CellValue(i,"pol_clpt_ind_seq_list"), sheetObj.CellValue(i,"pol_clpt_ind_seq_list"));
					sheetObj.CellComboItem(i, "pod_clpt_ind_seq", sheetObj.CellValue(i,"pod_clpt_ind_seq_list"), sheetObj.CellValue(i,"pod_clpt_ind_seq_list"));
				}
		   		ComSetObjValue(formObj.trunkSeq, ComGetEtcData(sXml,"trunk_seq"));
         		setVslPrePostCd();
         		defaultBackColor(formObj);
       			ComSetObjValue(formObj.vvd_modify_flg, "Y");     
       			ComSetFocus(formObj.copy_cnt);
                break;
 			case IBSAVE:        //저장
           		if(validateForm(sheetObj,formObj,sAction)){
           			sheetObjects[1].RemoveAll();
           			
            		if(ComGetObjValue(formObj.vvd_modify_flg) == "N"){
            			ComSetObjValue(formObj.f_cmd, MULTI02);	// Copy No Route      copyBkgWithRoute(e);
            		}else{
        				ComSetObjValue(formObj.f_cmd, MULTI01);	// Copy With Route    copyBkgWithoutRoute(e);
            		}
            		var params = FormQueryString(formObj);	
    				params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true),"sheet1_");	
    				
            		sheetObj.WaitImageVisible=false;
            		ComOpenWait(true);                				
    				var sXml = sheetObj.GetSaveXml("ESM_BKG_0077GS.do", params);
    				ComOpenWait(false);
    				
    				if(ComGetEtcData(sXml, "closeBkgFlag") =="Y"){
    					if(ComShowCodeConfirm("BKG00312",ComGetEtcData(sXml, "first_vvd"))){
    						ComSetObjValue(formObj.close_bkg_flag, "Y");
    						ComSetObjValue(formObj.mail_open_flag, "Y");
            				doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
    					} else {
    						ComSetObjValue(formObj.close_bkg_flag, "N");
    						ComSetObjValue(formObj.mail_open_flag, "N");
    						break;
    					}    
    				}else if(ComGetEtcData(sXml, "cbfBkgFlag") =="Y"){
    					if(ComShowCodeConfirm("BKG02069")){
    						ComSetObjValue(formObj.cbf_bkg_flag, "Y");
    						ComSetObjValue(formObj.mail_open_flag, "Y");
            				doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
    					} else {
    						ComSetObjValue(formObj.cbf_bkg_flag, "N");
    						ComSetObjValue(formObj.mail_open_flag, "N");
    						break;
    					} 
    				}else if(ComGetEtcData(sXml, "IsPctlNoPop") == "YC"){
    					sheetObjects[2].LoadSearchXml(sXml);
    					// ESD_PRD_018 화면 호출
    					var url = "ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=B"
    					url = url + "&por="   +	ComGetEtcData(sXml, "por");
    					url = url + "&por_n="   +	ComGetEtcData(sXml, "por_n");
    					url = url + "&pol="   + ComGetEtcData(sXml, "pol");
    					url = url + "&pol_n=" + ComGetEtcData(sXml, "pol_n");
    					url = url + "&pod="   + ComGetEtcData(sXml, "pod");
    					url = url + "&pod_n=" + ComGetEtcData(sXml, "pod_n");
    					url = url + "&del="   + ComGetEtcData(sXml, "del");
    					url = url + "&del_n=" + ComGetEtcData(sXml, "del_n");
    					for(i = 1 ; i < sheetObjects[0].Rows; i++){
    						url = url + "&pol" + i + "="   + sheetObjects[0].CellValue(i, "pol_cd");
    						url = url + "&pol" + i + "_n=" + sheetObjects[0].CellValue(i, "pol_cd") + sheetObjects[0].CellValue(i, "pol_yd_cd");
    						url = url + "&pol" + i + "_c=" + sheetObjects[0].CellValue(i, "pol_clpt_ind_seq");
    						url = url + "&pod" + i + "="   + sheetObjects[0].CellValue(i, "pod_cd");
    						url = url + "&pod" + i + "_n=" + sheetObjects[0].CellValue(i, "pod_cd") + sheetObjects[0].CellValue(i, "pod_yd_cd");
    						url = url + "&pol" + i + "_c=" + sheetObjects[0].CellValue(i, "pod_clpt_ind_seq");
    						url = url + "&vvd" + i + "="   + sheetObjects[0].CellValue(i, "bkg_vvd_cd");
    						if(sheetObjects[0].CellValue(i, "vsl_pre_pst_cd") == "T"){
    	    					url = url + "&t_vvd=" + ComGetEtcData(sXml, "t_vvd");    							
    						}
    					}
    					url = url + "&rcv_t=" + ComGetEtcData(sXml, "rcv_t");
    					url = url + "&del_t=" + ComGetEtcData(sXml, "del_t");
    					url = url + "&shpr="  + ComGetEtcData(sXml, "shpr");
    					url = url + "&cngn="  + ComGetEtcData(sXml, "cngn");
    					
    					url = url + "&com="     + ComGetEtcData(sXml, "com");
    					url = url + "&rep_com=" + ComGetEtcData(sXml, "rep_com");
    					url = url + "&wgt="     + ComGetEtcData(sXml, "wgt");
    					url = url + "&wgt_un="  + ComGetEtcData(sXml, "wgt_un");
    					url = url + "&bkg_ofc=" + ComGetEtcData(sXml, "bkg_ofc");
    					url = url + "&org_sal_ofc=" + ComGetEtcData(sXml, "org_sal_ofc"); 
    					
    					url = url + "&m_pu=" + ComGetEtcData(sXml, "m_pu");
    					url = url + "&f_rt=" + ComGetEtcData(sXml, "f_rt");
    					
    					url = url + "&sc="  + ComGetObjValue(formObj.sc_no);
    					url = url + "&rfa=" + ComGetObjValue(formObj.rfa_no);
    					
    					url = url + "&cgo_tp=" + ComGetEtcData(sXml, "cgo_tp");
    					if(formObj.dcgo_flg == "Y"){
    						url = url + "&dg_f=Y";
    					} else {
    						url = url + "&dg_f=N";    						
    					}
    					if(formObj.rc_flg == "Y"){
    						url = url + "&rf_f=Y";
    					} else {
    						url = url + "&rf_f=N";    						
    					}
    					if(formObj.awk_cgo_flg == "Y"){
    						url = url + "&ak_f=Y";
    					} else {
    						url = url + "&ak_f=N";    						
    					}
    					if(formObj.bb_cgo_flg == "Y"){
    						url = url + "&bb_f=Y";
    					} else {
    						url = url + "&bb_f=N";    						
    					}
    					url = url + "&rd_f=" + ComGetEtcData(sXml, "rd_f");
    					if(formObj.hngr_flg == "Y"){
    						url = url + "&hg_f=Y";
    					} else {
    						url = url + "&hg_f=N";    						
    					}
    					url = url + "&soc_f=" + ComGetEtcData(sXml, "soc_f");   
    					url = url + "&pm_f=N";  
    					
		    			for(i = 1 ; i < sheetObjects[2].Rows ; i++){
		    				url = url + "&c_tpsz="+sheetObjects[2].CellValue(i, "c_tpsz");
		    				url = url + "&c_qty="+sheetObjects[2].CellValue(i, "c_qty");  
		    			}		    			
		    			ComOpenPopup(url, 1024, 730, "callBackEsdPrd018","1,0,1,1,1", true);
						
		    			if(ComIsNull(formObj.pctl_no.value)){
							ComShowCodeMessage("BKG00309");	
						} else {
							doActionIBSheet(sheetObjects[2], formObj, IBSAVE);
						}		    			
    				}else{
	    				sheetObj.LoadSearchXml(sXml);
	    				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	        				var newBookingNum = ComGetEtcData(sXml,"new_booking_num");
	    					var newBookingArr = newBookingNum.split("||");
	    					for(var i = 0 ; i < newBookingArr.length ; i++){
	    						if(i%3 == 0){
	    							addRow = sheetObjects[1].DataInsert(-1);		
	    						}
	    						sheetObjects[1].CellValue(addRow, "new"+i%3) = newBookingArr[i];
	    						sheetObjects[1].CellFontUnderline(addRow, "new"+i%3) = true;
	    					}    	
	    					if(ComGetEtcData(sXml, "closeBkgResult") == "Y"){
	    						//copy시 mail open 제외함(20100311 임종한 과장 요청)
//	           					var subject = "BKG Creation Notice";            		
//	                       		ComBkgGroupMailset(sheetObjects[2], formObj, subject, ComGetEtcData(sXml, "closeBkgMsg"));  	    						
	    					}
	    					ComSetObjValue(formObj.close_bkg_flag, "N");
	    					ComSetObjValue(formObj.cbf_bkg_flag, "N");
    						ComSetObjValue(formObj.mail_open_flag, "N");
	    				}			
    				}
           		}
                break;
         }
     }

     /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
			case IBSAVE:   
				// Reefer 체크시 메시지 출력
				if(ComGetObjValue(formObj.rc_flg) == "Y"){
					ComShowCodeMessage("BKG00326");
				}
				// Number Of Copy 부적합 입력시 에러메시지 출력
				if(BkgParseInt(ComGetObjValue(formObj.copy_cnt)) < 1 || BkgParseInt(ComGetObjValue(formObj.copy_cnt)) > 50){
					ComShowCodeMessage("BKG00327");
					return false;
				}	
				// VVD가 9자리가 아닌 경우 에러메시지 출력
				var isVvdModify = false;
				for(var i = sheetObjects[0].HeaderRows ; i < sheetObjects[0].Rows ; i++){
					if(ComChkLen(sheetObjects[0].CellValue(i, "bkg_vvd_cd"), 9) != "2"
						&& sheetObjects[0].CellValue(i, "vsl_pre_pst_cd") == "T"){
						ComShowCodeMessage("BKG00007");
						return false;
					}
					if(!isVvdModify && sheetObjects[0].CellValue(i, "bkg_vvd_cd") != sheetObjects[0].CellSearchValue(i, "bkg_vvd_cd")){
						isVvdModify = true;
					}
					if(sheetObjects[0].CellValue(i, "vsl_pre_pst_cd") == "T"){
						ComSetObjValue(formObj.bkg_trunk_vvd, sheetObjects[0].CellValue(i, "bkg_vvd_cd"));
					}
				}
				// VVD가 변경된 경우 vvd_modify_flg ='Y' 로 변경
//				if(isVvdModify){
//					ComSetObjValue(formObj.vvd_modify_flg, "Y");
//				}else{
//					ComSetObjValue(formObj.vvd_modify_flg, "N");
//				}
				return true;
				break;    
        }
    }   
     
	 /**
	 * 마우스 아웃일때 
	 */
    function bkg0077_deactivate() {
    	var formObj = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	// TrunkVvd 체크
	 	if(srcName == "rfa_no"){
			if(srcValue == "DUM"){
				ComSetObjValue(formObj.rfa_no,"DUM0000001");
			}else{
				if(srcValue.length>=10){
	    			if(srcValue != ComGetObjValue(formObj.rfa_no_old)){
	        			// validateRfaAvailable() 호출
	        			formObj.f_cmd.value = SEARCHLIST12;
	        			var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?rfa_no="+srcValue, FormQueryString(formObj));
	    				changeObjectColor(ComGetEtcData(sXml,"rfa_available"), "N", "rfa_no", "red", "input1");
	    			}   		
				}
			}
			ComSetObjValue(formObj.rfa_no_old,ComGetObjValue(formObj.rfa_no));   
    	}else if(srcName == "sc_no"){
    		if(srcValue == "DUM"){
    			ComSetObjValue(formObj.sc_no,"DUM000001");
    		}else{
    			if(srcValue.length>=8){
        			if(srcValue != ComGetObjValue(formObj.sc_no_old)){
            			// validateScAvailable() 호출
            			formObj.f_cmd.value = SEARCHLIST13;
            			var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?sc_no="+srcValue, FormQueryString(formObj));
        				changeObjectColor(ComGetEtcData(sXml,"sc_available"), "N", "sc_no", "red", "input");
        			}   		
    			}
    		}
    		ComSetObjValue(formObj.sc_no_old,ComGetObjValue(formObj.sc_no));    
    	}else if(srcName == "taa_no"){
    		if(srcValue == "DUM"){
    			ComSetObjValue(formObj.taa_no,"DUM0000001");
    		}else{
    			if(srcValue.length>=10){
        			if(srcValue != ComGetObjValue(formObj.taa_no_old)){
            			// validateScAvailable() 호출
         			formObj.f_cmd.value = SEARCH06;
         			var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?taa_no="+srcValue, FormQueryString(formObj));
        				changeObjectColor(ComGetEtcData(sXml,"taa_available"), "N", "taa_no", "red", "input");
        			}   		
    			}
    		}
    		ComSetObjValue(formObj.sc_no_old,ComGetObjValue(formObj.sc_no));    
    	}
    }	

	
 	function sheet1_OnChange(sheetObj, Row, Col){
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if(colName == "pol_cd" || colName == "pod_cd" || colName == "bkg_vvd_cd"){
	 		if(	sheetObj.CellValue(Row, "pol_cd").length > 0 && 
	 			sheetObj.CellValue(Row, "pod_cd").length > 0 &&
	 			sheetObj.CellValue(Row, "bkg_vvd_cd").length > 0){	 			
	 			
	 			searchLaneEtaEtd(sheetObj, formObj, Row);
	 		}
	 		
	 		if(	sheetObj.CellValue(Row, "pol_cd").length < 1 ||
	 			sheetObj.CellValue(Row, "pod_cd").length< 1 ||	
	 			sheetObj.CellValue(Row, "bkg_vvd_cd").length < 1){
	 			
	 			sheetObj.CellValue(Row, "slan_cd") = "";
	 			sheetObj.CellValue(Row, "etd_day") = "";
	 			sheetObj.CellValue(Row, "etd_time") = "";
	 			sheetObj.CellValue(Row, "eta_day") = "";
	 			sheetObj.CellValue(Row, "eta_time") = "";	 			
	 		}
		}
		
		if(colName == "bkg_vvd_cd"){
    		changeObjectColor("Y", "Y", "btn_copy", "red", "");			
    		ComSetObjValue(formObj.vvd_modify_flg, "Y");
		}
	} 	 	 	
	
    // VVD Popup 호출
	function sheet1_OnPopupClick( sheetObj, Row, Col ){
		comBkgCallPop0019("callBack0019",
										sheetObj.CellValue(Row, "bkg_vvd_cd"),
										sheetObj.CellValue(Row, "pol_cd").substring(0, 5),
										sheetObj.CellValue(Row, "pod_cd").substring(0, 5));
	}
	
	function sheet2_OnDblClick(sheetObj, Row,Col){
		if(sheetObj.CellValue(Row,Col) != ""){
			ComBkgCall0079(sheetObj.CellValue(Row,Col)); 	
		}
	} 

//	function sheet1_OnLoadFinish(sheetObj) {   
//		 sheetObj.WaitImageVisible = false;   
//         var formObj = document.form;
//		 if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		// Cancel Booking Copy 시
//			 ComShowCodeMessage("BKG00090");
//			 window.close();
//		 }else if(ComGetObjValue(formObj.bdr_flg) == "Y"){		// BDR 시
//			 ComShowCodeMessage("BKG00091");
//			 window.close();
//		 }else{        	
//			 doActionIBSheet(sheetObj,formObj,IBSEARCH);
//		 }
//		
//		 initControl();
//		 sheetObj.WaitImageVisible = true;   
//	}         
     
	function sheet1_OnComboChange(sheetObj, Row, Col, Text) {
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(Col);
		if(Text==""){
			return;
		}  	 			

 		if(colName == "pol_clpt_ind_seq"){
 			sheetObj.CellValue2(Row, "pol_yd_cd") = "";
 		} else if(colName == "pod_clpt_ind_seq"){
 			sheetObj.CellValue2(Row, "pod_yd_cd") = "";
 		}
 		searchLaneEtaEtd(sheetObj, formObj, Row);
	}
	
    function defaultBackColor(formObj){
    	if(ComGetObjValue(formObj.dcgo_flg) != "Y"){
    		document.getElementById("dcgoFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.dcgo_flg, false);
    	}
    	if(ComGetObjValue(formObj.stowage_flg) != "Y"){
    		document.getElementById("stowageFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.stowage_flg, false);
    	}    	
    	if(ComGetObjValue(formObj.rc_flg) != "Y"){
    		document.getElementById("rcFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.rc_flg, false);
    	}    
    	if(ComGetObjValue(formObj.hngr_flg) != "Y"){
    		document.getElementById("hngrFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.hngr_flg, false);
    	}   
    	if(ComGetObjValue(formObj.spcl_hide_flg) != "Y"){
    		document.getElementById("spclHideFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.spcl_hide_flg, false);
    	}    
    	if(ComGetObjValue(formObj.spcl_hide_lnr_flg) != "Y"){
    		document.getElementById("spclHideLnrFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.spcl_hide_lnr_flg, false);
    	}    
    	if(ComGetObjValue(formObj.awk_cgo_flg) != "Y"){
    		document.getElementById("awkCgoFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.awk_cgo_flg, false);
    	}   
    	if(ComGetObjValue(formObj.stop_off_flg) != "Y"){
    		document.getElementById("stopOffFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.stop_off_flg, false);
    	}  
    	if(ComGetObjValue(formObj.fumg_flg) != "Y"){
    		document.getElementById("fumgFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.fumg_flg, false);
    	}  
    	if(ComGetObjValue(formObj.fd_grd_flg) != "Y"){
    		document.getElementById("fdGrdFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.fd_grd_flg, false);
    	}       	
    	if(ComGetObjValue(formObj.bb_cgo_flg) != "Y"){
    		document.getElementById("bbCgoFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.bb_cgo_flg, false);
    	}   
    	if(ComGetObjValue(formObj.bulk_rail_flg) != "Y"){
    		document.getElementById("bulkRailFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.bulk_rail_flg, false);
    	}    
    	if(ComGetObjValue(formObj.prct_flg) != "Y"){
    		document.getElementById("prctFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.prct_flg, false);
    	}   
    	if(ComGetObjValue(formObj.veh_cmdt_flg) != "Y"){
    		document.getElementById("vehCmdtFlg").style.backgroundColor = "#DCDCDC";
    		BkgEnableObject(formObj.veh_cmdt_flg, false);
    	}
    	document.getElementById("tmp").style.backgroundColor = "#DCDCDC"; 
    }

	// POD/POL/VVD 편집시
	function searchLaneEtaEtd(sheetObj, formObj, Row){
		if(	sheetObj.CellValue(Row, "pol_cd").length > 0 && 
			sheetObj.CellValue(Row, "pod_cd").length > 0 &&
			sheetObj.CellValue(Row, "bkg_vvd_cd").length > 0){  
	   		formObj.f_cmd.value = SEARCH01;
	   		var params = "f_cmd=" + formObj.f_cmd.value;
       		params = params + "&edit_row=" + Row + "&" + sheetObj.GetSaveString(true);
	   		var sXml = sheetObj.GetSearchXml("ESM_BKG_0092GS.do", params);

	   		if(ComIsNull(ComGetEtcData(sXml,"pol_clpt_ind_seq_list"))||ComIsNull(ComGetEtcData(sXml,"pod_clpt_ind_seq_list"))){
		   		sheetObj.CellValue2(Row, "eta_day")  = "";
		   		sheetObj.CellValue2(Row, "eta_time") = "";
		   		sheetObj.CellValue2(Row, "etd_day")  = "";
		   		sheetObj.CellValue2(Row, "etd_time") = "";
		   		sheetObj.CellValue2(Row, "eta") 	 = "";
		   		sheetObj.CellValue2(Row, "etd") 	 = "";
	   		} else {
		   		ComSetObjValue(formObj.trunkSeq, ComGetEtcData(sXml,"trunk_seq"));
		   		//조회한 결과를 담는다.
		   		sheetObj.CellValue2(Row, "eta_day")  = ComGetEtcData(sXml,"eta_day");
		   		sheetObj.CellValue2(Row, "eta_time") = ComGetEtcData(sXml,"eta_time");
		   		sheetObj.CellValue2(Row, "etd_day")  = ComGetEtcData(sXml,"etd_day");
		   		sheetObj.CellValue2(Row, "etd_time") = ComGetEtcData(sXml,"etd_time");
		   		sheetObj.CellValue2(Row, "eta") 	 = ComGetEtcData(sXml,"eta");
		   		sheetObj.CellValue2(Row, "etd") 	 = ComGetEtcData(sXml,"etd");
		   		sheetObj.CellValue2(Row, "slan_cd")  = ComGetEtcData(sXml,"slan_cd");
		   		sheetObj.CellValue2(Row, "pol_yd_cd")= ComGetEtcData(sXml,"pol_yd_cd");
		   		sheetObj.CellValue2(Row, "pod_yd_cd")= ComGetEtcData(sXml,"pod_yd_cd");
				sheetObj.CellComboItem(Row, "pol_clpt_ind_seq", ComGetEtcData(sXml,"pol_clpt_ind_seq_list"), ComGetEtcData(sXml,"pol_clpt_ind_seq_list"));
				sheetObj.CellComboItem(Row, "pod_clpt_ind_seq", ComGetEtcData(sXml,"pod_clpt_ind_seq_list"), ComGetEtcData(sXml,"pod_clpt_ind_seq_list"));
				sheetObj.CellValue2(Row, "pol_clpt_ind_seq") = ComGetEtcData(sXml,"pol_clpt_ind_seq");
				sheetObj.CellValue2(Row, "pod_clpt_ind_seq") = ComGetEtcData(sXml,"pod_clpt_ind_seq");
		   		setVslPrePostCd();
	   		}
		}	 			
	}    
	
   	function setVslPrePostCd(){
   		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var rowCnt = sheetObj.Rows;
		var maxRow = 0;
		if(rowCnt > 1){
//			 for ( i = 1 ; i < rowCnt ; i++ ){
//				 if(sheetObj.CellValue(i, "bkg_vvd_cd") != ""){
//					 etd = sheetObj.CellValue(i, "etd");
//					 eta = sheetObj.CellValue(i, "eta");
//
//					 sheetObj.CellValue(i, "voyage_time") = getDateDiff(etd, eta);
//					 
//					 if(maxRow == 0){
//						 sheetObj.CellValue(i, "vsl_pre_pst_cd") = "T";
//						 maxRow = i;
//					 }else{
//						 // 현재 항해시간이 기존 최대값보다 큰 경우 Trunk 교체
//						 if(ComParseInt(sheetObj.CellValue(maxRow, "voyage_time")) < ComParseInt(sheetObj.CellValue(i, "voyage_time"))){
//							 sheetObj.CellValue(maxRow, "vsl_pre_pst_cd") = "";
//							 sheetObj.CellValue(i, "vsl_pre_pst_cd") = "T";		        			 
//							 maxRow = i;
//						 }else{
//							 sheetObj.CellValue(i, "vsl_pre_pst_cd") = "";		 
//				    	 }
//					 }
//				 }
//			}   	         
    		sheetObj.CellValue2(ComGetObjValue(formObj.trunkSeq), "vsl_pre_pst_cd") = "T";
    		for ( j = 1 ; j < sheetObj.Rows ; j++ ){
    			if(j < ComGetObjValue(formObj.trunkSeq)){
      				sheetObj.CellValue2(j, "vsl_pre_pst_cd") = "S";
    			} else if(j > ComGetObjValue(formObj.trunkSeq)){
      				sheetObj.CellValue2(j, "vsl_pre_pst_cd") = "U";
    			}
    		}
			setPrePstSeq(sheetObj);
		}

	}

	// Seq 정렬
	function setPrePstSeq(sheetObj){
       // Seq 셋팅
       var isPre = true;
       var prePostIdx = 1;
       for ( j = 1 ; j < sheetObj.Rows ; j++ ){
      		 if(sheetObj.CellValue(j, "vsl_pre_pst_cd") != "T"){
      			 if(isPre){
      				sheetObj.CellValue2(j, "seq") = "Pre" + prePostIdx;
      				sheetObj.CellValue2(j, "vsl_pre_pst_cd") = "S";
      				sheetObj.CellValue2(j, "vsl_seq") = prePostIdx;
      				 prePostIdx++;
      			 }else{
      				sheetObj.CellValue2(j, "seq") = "Post" + prePostIdx;
      				sheetObj.CellValue2(j, "vsl_pre_pst_cd") = "U";
      				sheetObj.CellValue2(j, "vsl_seq") = prePostIdx;
      				 prePostIdx++;	        				 
      			 }
      		 }else{
      			 sheetObj.CellValue2(j, "seq") = "Trunk";
      			sheetObj.CellValue2(j, "vsl_seq") = "0";
      			 isPre = false;
      			 prePostIdx = 1;
      		 }
	 	}	   		
	}
	
	// VVD PopUp 호출뒤 Return 받는 값.
	function callBack0019(arrVal){
		if(arrVal != null){			
			sheetObjects[0].CellValue( sheetObjects[0].SelectRow, "pol_cd") = arrVal[0][4] ;
			sheetObjects[0].CellValue( sheetObjects[0].SelectRow, "pod_cd") = arrVal[0][12] ;
			sheetObjects[0].CellValue( sheetObjects[0].SelectRow, "bkg_vvd_cd") = arrVal[0][3] ;			
		}		
		searchLaneEtaEtd(sheetObjects[0], document.form, sheetObjects[0].SelectRow);
	}    
    /**
     * RFA Search후 Return받는 함수. <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack0654(arrBal);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */    
	function callBack0654(arrVal){
		if(arrVal != null){
			var formObj = document.form;			
			ComSetObjValue(formObj.rfa_no, arrVal[0][5]);
//			ComSetObjValue(formObj.rfa_no1, arrVal[0][5].substring(0,3));
//			ComSetObjValue(formObj.rfa_no2, arrVal[0][5].substring(3));
		}
	}        
    
   /**
    * S/C Search후 Return받는 함수. <br>
    * <br><b>Example :</b>
    * <pre>
    *     callBack0655(arrBal);
    * </pre>
    * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
    * @return 없음
    * @author 김병규
    * @version 2009.05.14
    */    
	function callBack0655(arrVal){
		if(arrVal != null){
			var formObj = document.form;			
			ComSetObjValue(formObj.sc_no, arrVal[0][5]);
//			ComSetObjValue(formObj.sc_no1, arrVal[0][5].substring(0,3));
//			ComSetObjValue(formObj.sc_no2, arrVal[0][5].substring(3));
		}
	}       

    /**
     * TAA Search후 Return받는 함수. <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack1062(arrBal);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */    
	function callBack1062(arrVal){
	  	var formObj = document.form;   
	  	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){   
	  		if(arrVal != null){	  			
	  			ComSetObjValue(formObj.taa_no,     arrVal[0][5]);
	  			changeObjectColor("Y", "N", "taa_no", "red", "input");
	  		}
	  	}
	}            

	// ESD_PRD_018 호출후 Return 받는값.(PCTL_NO)
	function callBackEsdPrd018(pctlNo){
		var formObj = document.form;

		ComSetObjValue(formObj.pctl_no,pctlNo);
		//doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
	}    	
	