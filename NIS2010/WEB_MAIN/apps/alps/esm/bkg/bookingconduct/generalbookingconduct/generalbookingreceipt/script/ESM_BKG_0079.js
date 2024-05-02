/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079.js
*@FileTitle : BKG Creation Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
* 2009.09.09 LeeNamKyung : CA관련 적용 
* 2009.11.09 LeeNamKyung : TroTab관련 적용
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.09.29 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 버그수정
 2011.10.14 정선용 [CHM-201113680-01] 남미 5개 국가(브라질, 에콰도르, 도미니카 공화국, 콜롬비아, 우루과이)  BDR이후 C/A issue 직전
 2012.09.18 조정민 [CHM-201219815] C/A Confirm 전 alert msg 삽입 요청
 2013.03.26 류대영 [CHM-201323500] BCC Auto-Interface 기능 구현 요청
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
     * @class esm_bkg_0079 : esm_bkg_0079 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0079() {
    	this.processButtonClick		= processButtonClick;
    	this.setTabObject 			= setTabObject;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initTab                = initTab;
    	this.initTroTab             = initTroTab;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet; 
    	this.validateForm 			= validateForm;
    	this.tab1_OnChange          = tab1_OnChange;
    	this.h1sheet1_OnSearchEnd   = h1sheet1_OnSearchEnd;
    	this.h1sheet1_OnSaveEnd     = h1sheet1_OnSaveEnd;
    	this.initCAControl          = initCAControl;
    	this.initControl            = initControl;
    	this.setCARefresh           = setCARefresh;
    	this.setCAIssueCallBack     = setCAIssueCallBack;
    	this.setCAReasonCallBack    = setCAReasonCallBack; 
    	this.setEnabledTroTab       = setEnabledTroTab;
    }
    
   	/* 개발자 작업	*/
    // 공통전역변수
    var tabObjects = new Array();
    var tabName = new Array();
    var tabCnt         = 0 ;
    var beforetab      = 10;
    var beforetab_sub  = 1;
    var beforetab_trob = 1;

    var sheetObjects = new Array();
    var sheetCnt     = 0;
    
    var caIssSuccess = false;
    var caCancel = false;
    var openDgPopUp = "N";
    
	//자동 Cargo Release 처리
	//POD가 변경되었을 경우, 기존POD로 CA가 전송가능한 지 체크하는 변수
	var do_hld_flg = null; 
	var cr_chk_flg = null;
	var old_pod_cd = null; 
	var new_pod_cd = null;    	
	var old_pod_yd_cd = null;
	var new_pod_yd_cd = null;    	

	var chgExpRqst = 'N';  // BCC Exemption Request
	
	/* initTab 에서 탭콘트롤 용도 사용 */
	var tabDeleteFlg = 'Y';
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName  = window.event.srcElement.getAttribute("name");
    		var strBkgNo = formObject.bkg_no.value; 
    		//var strBkgNo = outerFrame.document.form.bkg_no.value; //CA 적용이전 테스트용  

            switch(srcName) {
				case "btn_History":
					var bkgNo = nullToBlank(strBkgNo); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					comBkgCallPop0566(bkgNo); 
                	break;
                	
				case "btn_BLPreview":
					var bkgNo = nullToBlank(strBkgNo); 
					var blNo  = nullToBlank(formObject.bl_no.value); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					if (blNo == "") {
						ComShowCodeMessage("BKG00400");
						return false;
					}					
					comBkgCallPop0927(bkgNo, blNo);					
                	break;

            	case "btn_CAIssue":
            		var bkgNo = nullToBlank(strBkgNo); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					if(checkIbByCaIssue()== 'Y') {
//						ComShowCodeMessage("BKG02094");
						if(!ComShowConfirm(ComGetMsg("BKG02094")) ) {							
							return false;
						}
					} 

					caIssSuccess = false;
					comBkgCallPop0708('setCAIssueCallBack', bkgNo, "S");
					if(caIssSuccess){
						setCARefresh();
					}
                	break;

            	case "btn_CAReason":    
            		var bkgNo = nullToBlank(strBkgNo); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					comBkgCallPop0708('setCAReasonCallBack', bkgNo, "R"); 
                	break;

            	case "btn_CACancel": 
            		var bkgNo = nullToBlank(strBkgNo); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					if (!ComBkgProcessYn("Cancel C/A")) {
        	    		return false;
        	    	}
					formObject.bkg_no.value = bkgNo;
            		formObject.f_cmd.value = MULTI01;  //cancelCA
            		doActionIBSheet(sheetObjects[0], document.form, IBSAVE); 
            		caCancel = true;
            		// cod에서 pop-up시
            		if(ComGetObjValue(formObject.isPop)=="Y"){
            			window.close();
	            		var calllFunc = "callBackCaCancel"
            			eval('window.dialogArguments.'+calllFunc)();            			
            		}
            		break;
            	
            	case "btn_CAConfirm": 

	                //자동 Cargo Release 처리            		
        		    //Hold B/L 인가 , CR 전송한 적이 있는가  
			    	chagnePodCondition();
			    	new_pod_cd = t1frame.form.bkg_pod_cd.value;
			    	new_pod_yd_cd = t1frame.form.bkg_pod_yd_cd.value;
			    	
            		var bkgNo = nullToBlank(strBkgNo); 
            		
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					if (!ComBkgProcessYn("confirm C/A")) {
        	    		return false;
        	    	}
	        		ComShowCodeMessage("BKG02203");
					formObject.bkg_no.value = bkgNo;					
            		formObject.f_cmd.value = MULTI;    //completeCA
            		var success = doActionIBSheet(sheetObjects[0], document.form, IBSAVE); 
            		if(success==true){
	            		// cod에서 pop-up시
	            		if(ComGetObjValue(formObject.isPop)=="Y"){
	            			window.close();
		            		var calllFunc = "callBackCaConfirm"
	            			eval('window.dialogArguments.'+calllFunc)();            			
	            		}
	            		
					    //POD=US 인 경우에만 처리					
	            		if ( !ComIsNull(old_pod_cd) && !ComIsNull(new_pod_cd) ) {
						    if ( ( old_pod_cd != new_pod_cd || ( old_pod_cd == new_pod_cd && new_pod_yd_cd != old_pod_yd_cd)) && ( old_pod_cd.substring(0,2) == "US" && new_pod_cd.substring(0,2) == "US")  ) {
						    	if ( do_hld_flg == "N"  && cr_chk_flg == "Y" ) {
						    		podChange(old_pod_cd,new_pod_cd,old_pod_yd_cd,new_pod_yd_cd);
						    	}
						    }
	            		}

            		}
			    	
            		break;

            	case "btn_CAInquiry":
            		var bkgNo = nullToBlank(strBkgNo); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					comBkgCallPop0567_POP(bkgNo);
                	break;
                	
            	case "btn_BkgAttach":
            		var bkgNo = nullToBlank(strBkgNo); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					var url = "ESM_BKG_1182.do?bkg_no="+bkgNo;
					ComOpenWindowCenter(url, "ESM_BKG_1182", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
                	break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111"); 
    		} else {
    			ComShowCodeMessage(e);
    		}
    	}
    }

    /**
     * Tab 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//sheet 초기화 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1); 
            ComEndConfigSheet(sheetObjects[i]);
        }

        //tab 초기화 
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        initControl();

        //대륙코드 체크하여, tro tab 초기화 
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01); 
      	ComBtnDisable("btn_CAIssue");
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }

    /**
     * 0079 버튼 Control 초기화
     */ 
    function initControl() {
      	var formObj = document.form;
      	var strBkgNo   = formObj.bkg_no.value;      
      	var strCaFlg   = formObj.ca_flg.value; 
      	var strBdrFlg  = formObj.bdr_flg.value;
      	var strCaExist = formObj.ca_exist_flg.value;  //CA 데이타가 존재 여부 

      	//01. 버튼  상태 초기화
      	ComSetDisplay("btn_History",   true); 
		if(ComGetObjValue(formObj.isInquiry) == "Y"){
	      	if (strBkgNo == "") {
	          	ComSetDisplay("btn_CAInquiry", false); 
	          	setEnabledTroTab(true);  //troTab 제어 
	      	} else if (strCaFlg == "Y") {
	          	if (strCaExist == "Y") {
	          		ComSetDisplay("btn_CAInquiry", true);  
	          	} else {
	          		ComSetDisplay("btn_CAInquiry", false); 
	          	}
	          	setEnabledTroTab(false);  //troTab 제어 
	      	} else {
	          	if (strCaExist == "Y") {
	          		ComSetDisplay("btn_CAInquiry", true);  
	          	} else {
	          		ComSetDisplay("btn_CAInquiry", false); 
	          	}
	          	setEnabledTroTab(true);  //troTab 제어 
	      	}			
//          	ComSetDisplay("btn_CAIssue",   false);
	      	ComBtnDisable("btn_CAIssue");
          	ComSetDisplay("btn_CAReason",  false); 
          	ComSetDisplay("btn_CACancel",  false); 
          	ComSetDisplay("btn_CAConfirm", false); 	      	
		}else{
	      	if (strBkgNo == "") {
//	          	ComSetDisplay("btn_CAIssue",   false);
	      		ComBtnDisable("btn_CAIssue");
	          	ComSetDisplay("btn_CAReason",  false); 
	          	ComSetDisplay("btn_CACancel",  false); 
	          	ComSetDisplay("btn_CAConfirm", false); 
	          	ComSetDisplay("btn_CAInquiry", false); 
	          	setEnabledTroTab(true);  //troTab 제어 
	      	} else if (strCaFlg == "Y") {
//	          	ComSetDisplay("btn_CAIssue",   false); 
	      		ComBtnDisable("btn_CAIssue");
	          	ComSetDisplay("btn_CAReason",  true); 
	          	ComSetDisplay("btn_CACancel",  true); 
	          	ComSetDisplay("btn_CAConfirm", true); 
	          	if (strCaExist == "Y") {
	          		ComSetDisplay("btn_CAInquiry", true);  
	          	} else {
	          		ComSetDisplay("btn_CAInquiry", false); 
	          	}
	          	setEnabledTroTab(false);  //troTab 제어 
	      	} else {
	      		if (strBdrFlg == "Y") {
//	      			ComSetDisplay("btn_CAIssue",   true);
	      			ComBtnEnable("btn_CAIssue");
	      		} else {
//	      			ComSetDisplay("btn_CAIssue",   false);
	      			ComBtnDisable("btn_CAIssue"); 
	      		}         	
	          	ComSetDisplay("btn_CAReason",  false); 
	          	ComSetDisplay("btn_CACancel",  false); 
	          	ComSetDisplay("btn_CAConfirm", false); 
	          	if (strCaExist == "Y") {
	          		ComSetDisplay("btn_CAInquiry", true);  
	          	} else {
	          		ComSetDisplay("btn_CAInquiry", false); 
	          	}
	          	setEnabledTroTab(true);  //troTab 제어 
	      	}
		}
      	applyShortcut();
     }  
    
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    
    
    function initTab(tabObj, tabNo) {
    	var formObj = document.form;
    	
     	with (tabObj) {
     		 var cnt = 0 ;
             // 2017.11.08 iylee User Office가 CANSO이고 Outbound Doc > B/L Creation > B/L Issue [Alt+9]에서 인입된 경우 
             // 해당 Tab 외엔 Disable시킴.			
             if(document.form.usr_ofc.value == "CANSO" && document.form.fromBLIssue.value == "Y"){
             	InsertTab( cnt++ , bkgTabName[8], -1 );  //10 : 7, 8  : B9	9.B/L Issue
             	tabDeleteFlg = 'N';
             }
             
             else if(document.form.isInquiry.value == "Y" && 
     	   			(document.form.usr_id.value == 'SINOAGENT'
     		   			 || document.form.usr_id.value == 'UNISCO1'
     		   			)
     		   	){
             	InsertTab( cnt++ , bkgTabName[0], -1 );  // 0 : 0	    1.BKG Creation
             	InsertTab( cnt++ , bkgTabName[3], -1 );  // 5 : 2, 3	4.CNTR
             	tabDeleteFlg = 'N';
             }
             else{
             	InsertTab( cnt++ , bkgTabName[0], -1 );  // 0 : 0	    1.BKG Creation
                InsertTab( cnt++ , bkgTabName[1], -1 );  // 1 : 1	    2.General TRO/O
                InsertTab( cnt++ , bkgTabName[1], -1 );  // 2 : 1	    2.Korea TRO/O
                InsertTab( cnt++ , bkgTabName[1], -1 );  // 3 :  , 1	2.Europe TRO/O
                InsertTab( cnt++ , bkgTabName[2],       -1 );  // 4 :  , 2	3.Europe TRO/I
                InsertTab( cnt++ , bkgTabName[3], -1 );  // 5 : 2, 3	4.CNTR
                InsertTab( cnt++ , bkgTabName[4], -1 );  // 6 : 3, 4	5.Customer
                InsertTab( cnt++ , bkgTabName[5], -1 );  // 7 : 4, 5	6.M&D
                InsertTab( cnt++ , bkgTabName[6], -1 );  // 8 : 5, 6	7.C/M
                InsertTab( cnt++ , bkgTabName[7], -1 );  // 9 : 6, 7	8.Charge
                InsertTab( cnt++ , bkgTabName[8], -1 );  //10 : 7, 8  : B9	9.B/L Issue
                InsertTab( cnt++ , bkgTabName[9], -1 );  //11 : 7, 8  : B9	0.House B/L
             }
             //formObj.openTab.value = 0;                  
        }
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0; 
                
		switch(sheetObj.id) {
			case "h1sheet1":      //hidden h1sheet1
				with (sheetObj) {
					// 높이 설정
					//style.height = 100;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 20, 100);
					
					//var HeadTitle = "|bkg_no|ca_rsn_cd|ca_remark";
					var HeadTitle = "|";
					var headCount = ComCountHeadTitle(HeadTitle);
			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	50,     daCenter,  	false,  "ibflag",       false,  "", dfNone,     0,      false, false);					
				}
		        break; 
 		}
 	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
         
        switch(sAction) {	            
	  	    case COMMAND01: 
	  	    	//server call 1회 감소
				formObj.troTab.value = ComGetEtcData(formObj.sXml.value,"tro_tab");
	  	    	formObj.sXml.value = "";
		    	initTroTab();
	          	break;
        
 	 		case IBSAVE:  
 	          	if(!validateForm(sheetObj, formObj, sAction)) {
 	          		return false;
 	          	}
        		
 	          	if (formObj.f_cmd.value == MULTI) {         //completeCA
 	          		// BCC Auto-Interface 기능 구현 요청
 	          		var sXml = sheetObj.GetSearchXml("ESM_BKG_0079GS.do", 
 	          					"f_cmd="+SEARCHLIST01+"&bkg_no="+formObj.bkg_no.value); 
 	          		var currCd = ComGetEtcData(sXml,"curr_cd");
 	          		var scgAmt = ComGetEtcData(sXml,"scg_amt");
                    if(currCd != null && scgAmt != null){
            			if(confirm(ComGetMsg("BKG02217", currCd, scgAmt))){
            				formObj.bcc_exist_flg.value = "Y";
                    	} else {
                    		// No 를 선택하더라도 우선 I/F하고, Exemption Request 화면을 통해 면제요청을 하도록 한다.
    						// 저장 이후  BCC(OBS, LBP) Exemption Request 팝업을 열어줌.
                    		// 단, -	POR/POL country가 US 이거나, POD/DEL Country가 US인 경우 제외
                    		var input_text = ComGetObjValue(formObj.bkg_no);
            			 	var param = param + "&f_cmd=" + COMMAND17 + "&input_text=" + input_text;
            			 	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
            			 	var por_cnt_cd = ComGetEtcData(sXml, "por_cnt_cd");
            			 	var pol_cnt_cd = ComGetEtcData(sXml, "pol_cnt_cd");
            			 	var pod_cnt_cd = ComGetEtcData(sXml, "pod_cnt_cd");
            			 	var del_cnt_cd = ComGetEtcData(sXml, "del_cnt_cd");
            				
            				if(por_cnt_cd != 'US' && pol_cnt_cd != 'US' && pod_cnt_cd != 'US' && del_cnt_cd != 'US' ){
            					formObj.bcc_exist_flg.value = "Y";
        						chgExpRqst = 'Y';
            				}else {
            					formObj.bcc_exist_flg.value = "N";
            				}
                    			
                    	}
                    } else {
                    	formObj.bcc_exist_flg.value = "N";
                    }
                    
 	          	    var sParam1 = ComSetPrifix(sheetObj.GetSaveString(), "t1sheet1_");
 	          	    var sParam = FormQueryString(formObj);
 	          		sParam += "&" + sParam1; 

 	 	          	ComOpenWait(true);
 	          		sXml = sheetObj.GetSaveXml("ESM_BKG_0079GS.do", sParam);
 	 	          	ComOpenWait(false);

 					var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
 		            if(State != "S"){
 	 	          		var success = sheetObj.LoadSaveXml(sXml);
 		            	return false;
 		            } else {
 		            	setCARefresh();
 	            		// cod에서 pop-up시에는 mail을 보내지 않는다.
 	            		if(ComGetObjValue(formObj.isPop)!="Y"){ 	            	
//							var bkgNo = ComGetObjValue(formObj.bkg_no);
//	 		            	var caNo = ComGetEtcData(sXml,"ca_no");
//							var param = "?bkg_no="+bkgNo+"&ca_no="+caNo+"&popFlg=Y&pgmNo=ESM_BKG_0567";
//							var sUrl  = "http://"+location.host+"/hanjin/ESM_BKG_0567_POP.do"+param;
//							var subject  = "C/A Notice (BKG#:"+bkgNo+")";
//							var contents = "<table>" + 
//										"<tr><td>User ID : "+ComGetObjValue(formObj.usr_id)+"</td></tr>" +
//										"<tr><td>User Name : "+ComGetObjValue(formObj.usr_nm)+"</td></tr>" +
//										"<tr><td>BKG No : "+bkgNo+"</td></tr>" +
//										"<tr><td>C/A No : <a href="+sUrl+">"+caNo+"</a></td></tr>" +
//										"<tr><td>Above C/A has been issued. Please check C/A detail.</td></tr>"
//										"</table>";
//			          		ComBkgGroupMailset(sheetObj, formObj, subject, contents);    
 	            		}
 	            		if("Y" == ComGetEtcData(sXml, "pre_checking")){
 	            			openDgPopUp = "Y";
 	            		} else {
 	            			openDgPopUp = "N";
 	            		}
 	            		if(ComGetEtcData(sXml, "codFlg") == "Y"){ 	            		 	
 	            			var param="?mainPage=false&bkg_no="+ComGetObjValue(formObj.bkg_no);
 	            			param+="&popFlg=C";
 	            			param+="&pgmNo=ESM_BKG_0156";
 	            	 		ComOpenWindowCenter("/hanjin/ESM_BKG_0156.do"+param, "ESM_BKG_0156", 1024, 730, true, "yes");
 	            		}
 	            		
 	            		
 	            		// BCC Charge 면제요청을 위한 팝업 오픈
 	            		if(chgExpRqst == 'Y'){
 	            			var formObj = document.form;
 	            			var _Width = '449';
 	            			var _Height = '460';
 	            			var pgmNo = "&pgmNo=ESM_BKG_1600";
 	            			var param = "bkg_no="+ComGetObjValue(formObj.bkg_no)+"&chg_cd=BCC" ;
 	            			var url = "ESM_BKG_1600.do?" + param + pgmNo;
 	            			ComOpenWindowCenter(url, "BKG_Win", _Width , _Height, true,true);
 	            			chgExpRqst = 'N'
 	            		}
 	            		
 	            		return true;
 	          		}
 	          	}
 	          	else if (formObj.f_cmd.value == MULTI01) {  //cancelCA
 	          	    var sParam1 = ComSetPrifix(sheetObj.GetSaveString(), "t1sheet1_");
 	          	    var sParam = FormQueryString(formObj);
 	          		sParam += "&" + sParam1; 
 	          	    
 	          		var sXml = sheetObj.GetSaveXml("ESM_BKG_0079GS.do", sParam); 

 					var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
 		            if(State != "S"){
 		            	var success = sheetObj.LoadSaveXml(sXml);
 		            } else {
 		            	setCARefresh();
 		            }
 	          	}
 	          	ComOpenWait(false);
                break;
                
    	  	case COMMAND02: 
	  	    	formObj.f_cmd.value = COMMAND02;
//	          	sheetObj.DoSearch("ESM_BKG_0079GS.do", FormQueryString(formObj));
	          	var sXml = sheetObj.GetSearchXml("ESM_BKG_0079GS.do", FormQueryString(formObj));
	          	var inbound_noti = ComGetEtcData(sXml, "INBOUNTNOTI");
	          	return inbound_noti;
            break;                
        }
    }
    
	//######################[2. Etc]##############################################################	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
        with(formObj) {
        }
        return true;
    }    
    
    /**
     * 조회완료시, 후속처리 
     * 사용않함 -> BookingUtilDBDAOSearchBkgBlNoVORSQL
     * 사용     -> searchBkgCreTabByUser 
     */ 
    function h1sheet1_OnSearchEnd(sheetObj, ErrMsg) { 
    	var formObj = document.form;
    	
/* : 사용않함 -> BookingUtilDBDAOSearchBkgBlNoVORSQL--->
    	//01. BkgBlNoVO 초기화 
    	formObj.bkg_no.value       = sheetObjects[0].EtcData("bkg_no"); 
    	formObj.ca_flg.value       = sheetObjects[0].EtcData("ca_flg"); 
    	formObj.bdr_flg.value      = sheetObjects[0].EtcData("bdr_flg"); 
    	formObj.ca_exist_flg.value = sheetObjects[0].EtcData("ca_exist_flg"); 
    	
    	//02. Booking 상태별 : CA 관련 버튼 초기화 
    	initControl(); 
<-----------------------------------------------------*/ 
    	formObj.troTab.value = sheetObj.EtcData("tro_tab"); 
    	initTroTab();
    }

     /**
     * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     tab1_OnChange(tabObj, tabIndex)
     * </pre>
     * @param {tabObj} tabObj 필수 IBTab Object
     * @param {int} tabIndex 필수 프로세스 플래그 상수
     * @return 없음
     * @author 김병규
     * @version 2009.04.17
     */     
	function tab1_OnChange(tabObj, tabIndex) {
		for (var i = 0; i < bkgTabName.length; i++) {
			if(tabObjects[0].TabText(tabIndex) == bkgTabName[i]){
				tabIndex = i;
				break;
			}
		}

    	var nTabCnt = tabObjects[0].GetCount();
    	var formObj = document.form;
 		var bkgNo   = formObj.bkg_no.value;
 	    var beforeTabObj = document.frames("t" + (beforetab + 1) + "frame");
 	    var newTabObj    = document.frames("t" + (tabIndex  + 1) + "frame");
 	    // 중간 Tab으로 바로 들어오는 경우에 생략
 	    try{
	 	    if(!beforeTabObj){
	 	    	return false;
	 	    } else {
		 	    if(formObj.isInquiry.value == "Y" || caCancel == true){
	 	   			switch(beforetab) { 	 	    	
						case 8: // B/L Issue
							beforeTabObj.form.modify_flag.value = "N";
						break;
						case 9: // H.B/L-> dirty_flg
	  						beforeTabObj.form.dirty_flag.value = "N";
						break;
		 	    	}
		 	      	if(caCancel==true){
		 	      		caCancel==false;
		 	      	}
		 	    } else {
			 	    if(ComIsNull(ComGetObjValue(formObj.openTab))) {
			 	 	    // 각 tab의 변경 여부 확인, 저장
			 	    	if (beforetab<10) {// && beforeTabObj && "complete"==beforeTabObj.document.readyState) {
			 	    		beforeTabObj.checkModify();
			 	    	} 	
			 	    }
		 	    }
		    }
	        var befBkgNo = "";
	        var curBkgNo = "";    	       
	        var befObjTabWindow = document.getElementById("t" + (beforetab + 1) + "frame").contentWindow;       
	        var curObjTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
		    
	        if(befObjTabWindow.location.href != "" && befObjTabWindow.location.href != "about:blank" ){
	        	befBkgNo = eval("t" + (beforetab + 1) + "frame").form.bkg_no.value;
	        }    	 
	
	        if (beforetab != tabIndex) {
	        	var objs = document.all.item("tabLayer");
	        	objs[tabIndex].style.display = "inline";
	        	objs[beforetab].style.display = "none";            
	        }
	       
	        var isLoading = false;
	        if(curObjTabWindow.location.href != "" && curObjTabWindow.location.href != "about:blank"){
	        	curBkgNo = eval("t" + (tabIndex + 1) + "frame").form.bkg_no.value;		   
	        }            
	       
	        // Booking번호로 바로 조회하는 경우
	        if(ComIsNull(befBkgNo) && !ComIsNull(ComGetObjValue(document.form.bkg_no))){
	        	befBkgNo = ComGetObjValue(document.form.bkg_no);
	        }
		   
	        // load되어있지 않으면 load
	        if(curObjTabWindow.location.href == "" || curObjTabWindow.location.href == "about:blank"){
	        	isLoading = true;
	        }
	        
	        //각 tab의 load or 재조회
	        if(isLoading){	
	        	loadTabPage(tabIndex, isLoading, befBkgNo);
	        } else {
	    	   	newTabObj.searchData(befBkgNo);
	        }
	        	
	        podChangeTabColor("N");
	        
		    beforetab = tabIndex;
			setForceFocus();
	    } catch(e) {
			if( e == "[object Error]") {
				return false;
			} else {
				ComShowMessage(e);
			}	    	
	    }
   }     

   /**
   * Tab변경시 화면을 Frame에 로드한다.  <br>
   * <br><b>Example :</b>
   * <pre>
   *     loadTabPage(tabIndex)
   * </pre>
   * @param {tabIndex} tabIndex 필수 tab의 일련번호
   * @param {selRow} 선택된  Row
   * @return 없음
   * @author 공백진
   * @version 2009.04.17
   */          
	function loadTabPage(tabIndex, changeBkgNo, bkgNo) {
	    var formObj  = document.form;	   
	    if (tabIndex == null || tabIndex == "") {
	    	tabIndex = tabObjects[0].SelectedIndex;
	    }
	    var nTabCnt = tabObjects[0].GetCount();
	  
	    if (beforetab != tabIndex) {
	    	var objs = document.all.item("tabLayer");
	    	objs[tabIndex].style.display = "inline";
	    	objs[beforetab].style.display = "none";           
        }  
	  
	    var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
	    var isReLoading = false;
	    if(objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank"){
	    	isReLoading = true;
	    }
	    if(!isReLoading){
	    	if(changeBkgNo){
	    		isReLoading = true;
	    	}
	    }

	    if(!ComIsNull(formObj.openTab) && tabIndex == 0){
	    	isReLoading = false;
	    }
        
	    if (isReLoading) {
	    	var ctxName  = "/hanjin";

	    	// 20091223 Inquiry 용으로 호출했는지 여부 확인 
	    	var isInquiry = ComGetObjValue(formObj.isInquiry);
 		
	    	var sUrl = "";
	    	if (nTabCnt == 10) {  //eurTro : tro tab 2개
	    		switch(tabIndex) {
 					case 0:
 						if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_01_Q.do?bkg_no="+bkgNo;		
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_01.do?bkg_no="+bkgNo;		
	 					}
	 				    break;
 	
 					case 1:
 						var ioBoundCd = "O";
 						if(isInquiry == "Y"){
 							sUrl = ctxName + "/ESM_BKG_0079_02C_Q.do?bkg_no="+bkgNo+"&io_bnd_cd="+ioBoundCd;
 						}else{
 							sUrl = ctxName + "/ESM_BKG_0079_02C.do?bkg_no="+bkgNo+"&io_bnd_cd="+ioBoundCd;
 						}
 						break;
 	
	 				case 2:
	 					var ioBoundCd = "I";
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_02C_Q.do?bkg_no="+bkgNo+"&io_bnd_cd="+ioBoundCd;
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_02C.do?bkg_no="+bkgNo+"&io_bnd_cd="+ioBoundCd;
	 					}
	 	                break;
	 	
	 				case 3:
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_04_Q.do?bkg_no="+bkgNo;  //Container
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_04.do?bkg_no="+bkgNo;  //Container
	 					}
	 	                break;
	 	
	 				case 4:
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_05_Q.do?bkg_no="+bkgNo;  //Customer
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_05.do?bkg_no="+bkgNo;  //Customer
	 					}
	 	                break;
	 	
	 				case 5:  
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_06_Q.do?bkg_no="+bkgNo;  //M&D	
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_06.do?bkg_no="+bkgNo;  //M&D	
	 					}
	 			        break;
	 	
	 				case 6:
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_07_Q.do?bkg_no="+bkgNo;  //C/M
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_07.do?bkg_no="+bkgNo;  //C/M
	 					}
	 				    break;
	 	
	 				case 7:  		
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_08_Q.do?bkg_no="+bkgNo;  //
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_08.do?bkg_no="+bkgNo;  //
	 					}
	 			        break;
	 	
	 				case 8:  
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_09_Q.do?bkg_no="+bkgNo;  //BL Issue
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_09.do?bkg_no="+bkgNo;  //BL Issue
	 					} 
	 					break;
	 	
	 				case 9:  
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0366_Q.do?bkg_no="+bkgNo;  //BL Issue
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0366.do?bkg_no="+bkgNo;  //BL Issue
	 					} 
	 					break;
	    		}
	    	} else {             //Tro : tro tab 1개
	    		switch(tabIndex) {
	 				case 0:
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_01_Q.do?bkg_no="+bkgNo;	
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_01.do?bkg_no="+bkgNo;	
	 					}
	 				    break;
	 	
	 				case 1:
	 					var troTab = formObj.troTab.value;
	 					if(isInquiry == "Y"){
	 	 					if (troTab == "KOR") {
	 	 						sUrl = ctxName + "/ESM_BKG_0079_02B_Q.do?bkg_no="+bkgNo;						
	 	 					} else {
	 	 						sUrl = ctxName + "/ESM_BKG_0079_02A_Q.do?bkg_no="+bkgNo;
	 	 					} 						
	 					}else{
	 	 					if (troTab == "KOR") {
	 	 						sUrl = ctxName + "/ESM_BKG_0079_02B.do?bkg_no="+bkgNo;						
	 	 					} else {
	 	 						sUrl = ctxName + "/ESM_BKG_0079_02A.do?bkg_no="+bkgNo;
	 	 					} 						
	 					}
	 	                break;
	 	
	 				case 3:
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_04_Q.do?bkg_no="+bkgNo;  //Container
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_04.do?bkg_no="+bkgNo;  //Container
	 					}
	 	                break;
	 	
	 				case 4:
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_05_Q.do?bkg_no="+bkgNo;  //Customer
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_05.do?bkg_no="+bkgNo;  //Customer
	 					}
	 	                break;
	 	
	 				case 5:  
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_06_Q.do?bkg_no="+bkgNo;  //M&D	
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_06.do?bkg_no="+bkgNo;  //M&D	
	 					}
	 			        break;
	 	
	 				case 6:	 					
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_07_Q.do?bkg_no="+bkgNo;  //C/M
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_07.do?bkg_no="+bkgNo;  //C/M
	 					}
	 				    break;
	 	
	 				case 7:  	
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_08_Q.do?bkg_no="+bkgNo;  //
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_08.do?bkg_no="+bkgNo;  //
	 					}
	 			        break;
	 	
	 				case 8:  
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0079_09_Q.do?bkg_no="+bkgNo;  //BL Issue
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0079_09.do?bkg_no="+bkgNo;  //BL Issue
	 					}
	 			        break;
	
	 				case 9:  
	 					if(isInquiry == "Y"){
	 						sUrl = ctxName + "/ESM_BKG_0366_Q.do?bkg_no="+bkgNo;  //BL Issue
	 					}else{
	 						sUrl = ctxName + "/ESM_BKG_0366.do?bkg_no="+bkgNo;  //BL Issue
	 					} 
	 					break;
	 			}
	     	}
	     	objTabWindow.location.href = sUrl;
	     	beforetab = tabIndex;
	        return true;
	    } 
    }   
   
    /**
     * Control 초기화 : iframe tab 에서, Retrive 후 call 
     * : 파라미터 전달받아 사용함 
     */ 
    function initCAControl(bkgNo, caFlg, bdrFlg, caExistFlg, blNo) {
    	var formObj = document.form;
    	//01. BkgBlNoVO 초기화 
    	formObj.bkg_no.value       = nullToBlank(bkgNo); 
    	formObj.ca_flg.value       = nullToBlank(caFlg); 
    	formObj.bdr_flg.value      = nullToBlank(bdrFlg); 
    	formObj.ca_exist_flg.value = nullToBlank(caExistFlg); 
    	formObj.bl_no.value        = nullToBlank(blNo);
    	
    	//02. Booking 상태별 : CA 관련 버튼 초기화  
    	initControl(); 

 		if("Y"==openDgPopUp){
 			var bkgTabObj = document.frames("t1frame");
 	 	    bkgTabObj.comBkgCallPop0200(formObj.bkg_no.value, "N");
 		}
    }

    /**
     * parent화면에서 넘겨받은 parameter로, tab초기화면 설정 
     */
	function setCARefresh() {
		if (tabObjects[0].selectedIndex != 0) {
			//01. BKG_Creation tab : 활성화  -> bkg_no 파라미터 넘김(자동재조회)
			tabObjects[0].selectedIndex = 0; 
			t1frame.location.href = "ESM_BKG_0079_01.do?bkg_no="+ComGetObjValue(document.form.bkg_no);	
		} else {
			//02. 재조회 call
			t1frame.CARefresh();	
			t1frame.location.href = "ESM_BKG_0079_01.do?bkg_no="+ComGetObjValue(document.form.bkg_no);	
		}
		if(document.getElementById("t2frame").contentWindow.location.href != "" && document.getElementById("t2frame").contentWindow.location.href != "about:blank" ){
			t2frame.form.bkg_no.value = "";
        }
		if(document.getElementById("t3frame").contentWindow.location.href != "" && document.getElementById("t3frame").contentWindow.location.href != "about:blank" ){
			t3frame.form.bkg_no.value = "";
		}
		if(document.getElementById("t4frame").contentWindow.location.href != "" && document.getElementById("t4frame").contentWindow.location.href != "about:blank" ){
			t4frame.form.bkg_no.value = "";
		}
		if(document.getElementById("t5frame").contentWindow.location.href != "" && document.getElementById("t5frame").contentWindow.location.href != "about:blank" ){
			t5frame.form.bkg_no.value = "";
		}
		if(document.getElementById("t6frame").contentWindow.location.href != "" && document.getElementById("t6frame").contentWindow.location.href != "about:blank" ){
			t6frame.form.bkg_no.value = "";
		}
		if(document.getElementById("t7frame").contentWindow.location.href != "" && document.getElementById("t7frame").contentWindow.location.href != "about:blank" ){
			t7frame.form.bkg_no.value = "";
		}
		if(document.getElementById("t8frame").contentWindow.location.href != "" && document.getElementById("t8frame").contentWindow.location.href != "about:blank" ){
			t8frame.form.bkg_no.value = "";
		}
		if(document.getElementById("t9frame").contentWindow.location.href != "" && document.getElementById("t9frame").contentWindow.location.href != "about:blank" ){
			t9frame.form.bkg_no.value = "";
		}
		if(document.getElementById("t10frame").contentWindow.location.href != "" && document.getElementById("t10frame").contentWindow.location.href != "about:blank" ){
			t10frame.form.bkg_no.value = "";
		}
		if(document.getElementById("t11frame").contentWindow.location.href != "" && document.getElementById("t11frame").contentWindow.location.href != "about:blank" ){
			t11frame.form.bkg_no.value = "";
		}
		if(document.getElementById("t12frame").contentWindow.location.href != "" && document.getElementById("t12frame").contentWindow.location.href != "about:blank" ){
			t12frame.form.bkg_no.value = "";
		}
	}
    
    /**
    * Tro관련 4개Tab을 기본 설정한다.
    */
    function initTroTab() {    	
	   	var formObj = document.form;
	   	var strTroTab = formObj.troTab.value; 
	   	var cnt = 0;
	   	var openNam = "";
        tabName[cnt++] = "Booking Creation";
        
	   	if (strTroTab == "KOR" && tabDeleteFlg == 'Y') {
            cnt = 0;
            tabName[cnt++] = "TRO/A O/B";
	   		tabObjects[0].DeleteTab(4);
	   		tabObjects[0].DeleteTab(3);
	   		tabObjects[0].DeleteTab(1);    		
	   	} else if (strTroTab == "EUR" && tabDeleteFlg == 'Y') {
            tabName[cnt++] = "TRO/C O/B";
            tabName[cnt++] = "TRO/C I/B";
	   		tabObjects[0].DeleteTab(2);
	   		tabObjects[0].DeleteTab(1); 
	   	} else if(tabDeleteFlg == 'Y') {
            tabName[cnt++] = "TRO/B O/B";
	   		tabObjects[0].DeleteTab(4);
	   		tabObjects[0].DeleteTab(3);
	   		tabObjects[0].DeleteTab(2);
	   	}
        tabName[cnt++] = "Container";
        tabName[cnt++] = "Customer";
        tabName[cnt++] = "M&D";
        tabName[cnt++] = "C/M";
        tabName[cnt++] = "Charge";
        tabName[cnt++] = "B/L Issue";
        tabName[cnt++] = "House B/L";
   	
        // Tab Open 임의 지정        
        var nTabCnt = tabObjects[0].GetCount();
        var formObj = document.form;
        if(nTabCnt == 10 && (ComGetObjValue(formObj.openTab) == "B2" || ComGetObjValue(formObj.openTab) == "B3")){
       		ComSetObjValue(formObj.openTab , "");
       		tabObjects[0].selectedIndex = 0; 
       		loadTabPage(0, false, "");
        } 
        
        if(!ComIsNull(formObj.openTab)){
//        	if(ComGetObjValue(formObj.openTab) == "B2"){
//        		// TRO / O // EUR TRO는 바로 연결하지 않음
//        		if (nTabCnt != 10) {
//        	       	tabIndex = 1;
//        		}
//        	}else if(ComGetObjValue(formObj.openTab) == "B3"){
//        		// TRO / I // EUR TRO는 바로 연결하지 않음
//    	       	if (nTabCnt != 10) {
//    	       		tabIndex = 1;
//    	       	}
//        	}else 
        	if(ComGetObjValue(formObj.openTab) == "B4"){
        		// Container
//    	       	if (nTabCnt == 10) {  
//    	       		tabIndex = 3;	       		
//    	       	} else {             
//    	       		tabIndex = 2;
//    	       	}        	
        		tabIndex = 3;	    
        	}else if(ComGetObjValue(formObj.openTab) == "B5"){
        		// Customer
//    	       	if (nTabCnt == 10) {  
//    	       		tabIndex = 4;	       		
//    	       	} else {             
//    	       		tabIndex = 3;
//    	       	}        
        		tabIndex = 4;	
        	}else if(ComGetObjValue(formObj.openTab) == "B6"){
        		// M&D
//    	       	if (nTabCnt == 10) {  
//    	       		tabIndex = 5;	       		
//    	       	} else {             
//    	       		tabIndex = 4;
//    	       	}        	      
        		tabIndex = 5;	 
        	}else if(ComGetObjValue(formObj.openTab) == "B7"){
        		// M&D
//    	       	if (nTabCnt == 10) {  
//    	       		tabIndex = 6;	       		
//    	       	} else {             
//    	       		tabIndex = 5;
//    	       	}        	       	
        		tabIndex = 6;	 
        	}else if(ComGetObjValue(formObj.openTab) == "B8"){
        		// CM
//    	       	if (nTabCnt == 10) {  
//    	       		tabIndex = 7;	       		
//    	       	} else {             
//    	       		tabIndex = 6;
//    	       	}        	   
        		tabIndex = 7;	 
        	}else if(ComGetObjValue(formObj.openTab) == "B9"){
        		// ChargeTab
//    	       	if (nTabCnt == 10) {  
//    	       		tabIndex = 8;	       		
//    	       	} else {             
//    	       		tabIndex = 7;
//    	       	}        		
        		tabIndex = 8;	 
        	}else if(ComGetObjValue(formObj.openTab) == "B10"){
//    	       	if (nTabCnt == 10) {  
//    	       		tabIndex = 9;	       		
//    	       	} else {             
//    	       		tabIndex = 8;
//    	       	}        	    	         
        		tabIndex = 9;	 
        	}else if(ComGetObjValue(formObj.openTab) == "B11"){
        		// HOUSE BL
//    	       	if (nTabCnt == 10) {  
//    	       		tabIndex = 10;	       		
//    	       	} else {             
//    	       		tabIndex = 9;
//    	       	}              	
        		tabIndex = 10;	 
        	}
        	for (var i = 0; i < tabObjects[0].GetCount(); i++) {
        		if(tabObjects[0].TabText(i) == bkgTabName[tabIndex]){
        			tabObjects[0].selectedIndex = i;
        			break;
        		}
			}
        	
        	if (ComIsNull(formObj.bkg_no)) {
        		loadTabPage(tabIndex, false, "");
        	} else {
        		loadTabPage(tabIndex, true, ComGetObjValue(formObj.bkg_no));
        	}
       		ComSetObjValue(formObj.openTab , "");
        }
    }		
	
     
    /**
    * parent화면에서 넘겨받은 parameter로, tro-tab Enabled 설정 
    */
	function setEnabledTroTab(bFlag){
		var formObj = document.form;		
		var nTabCnt = tabObjects[0].GetCount();
    	if (nTabCnt == 10) {  //eurTro : tro tab 2개
	    	if (!bFlag) {
	    		if (tabObjects[0].selectedIndex == 1 || tabObjects[0].selectedIndex == 2) {	 
	    			tabObjects[0].selectedIndex = 0;  //01. BKG_Creation tab : 활성화  -> bkg_no 파라미터 넘김(자동재조회)
	    		}
	    	}	
    	    if (tabObjects[0].TabEnable(1) != bFlag) {  
    			tabObjects[0].TabEnable(1) = bFlag; 
    			tabObjects[0].TabEnable(2) = bFlag; 
    			tabObjects[0].TabEnable(8) = bFlag; // b/l issue tab도 c/a에서 제외
    	    }
    	} else {             //Tro : tro tab 1개
	    	if (!bFlag) {
	    		if (tabObjects[0].selectedIndex == 1) {	
	    			tabObjects[0].selectedIndex = 0;  //01. BKG_Creation tab : 활성화  -> bkg_no 파라미터 넘김(자동재조회)
	    		}
	    	}
    	    if (tabObjects[0].TabEnable(1) != bFlag) {
			    tabObjects[0].TabEnable(1) = bFlag; 
    			tabObjects[0].TabEnable(7) = bFlag; // b/l issue tab도 c/a에서 제외
    	    }
    	}
	}    

    /**
     * CA Issue 후속 처리 : CaStart
     */
    function setCAIssueCallBack(arrPopupData) {
    	caIssSuccess = true;
    }
    
    function checkIbByCaIssue() {
        var formObject = document.form;

		formObject.f_cmd.value = COMMAND02;  //
		var success_yn = doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
	    return success_yn ;
    }
    
    /*
	    * 자동 Cargo Release 처리
	   	* POD가 변경되었을 경우, 기존POD로 CA가 전송가능한 지 체크
	   	*/
	   	function chagnePodCondition(){
	   	   	
		    var formObj = document.form;
		    var sheetObjCgoRlse = sheetObjects[0];
		    
		    formObj.f_cmd.value = SEARCH05;
		    var params = FormQueryString(formObj);
		    var sXml = sheetObjCgoRlse.GetSearchXml("ESM_BKG_0909GS.do", params);
		    
		    //Hold B/L 인가    
		    do_hld_flg = ComGetEtcData(sXml, "do_hld_flg");
		    
		    //CR 전송한 적이 있는가  
		    cr_chk_flg = ComGetEtcData(sXml, "cr_chk_flg");
		    
		    //BKG_BOOKING POD_CD
		    old_pod_cd = ComGetEtcData(sXml, "bkg_pod_cd");
		    old_pod_yd_cd = ComGetEtcData(sXml, "bkg_pod_yd_cd");
	    
		}
		 
	    /*
	    * 자동 Cargo Release 처리
	   	* POD가 변경되었을 경우, 기존POD로 CA가 전송가능한 지 체크
	   	*/
	   	function podChange(old_pod_cd,new_pod_cd,old_pod_yd_cd,new_pod_yd_cd){
	   	
		    var formObj = document.form;
		    var sheetObjCgoRlse = sheetObjects[0];
		    var bl_no = formObj.bl_no.value;
		       		
		    //HOLD되지 않고, CR발송된 적이 있음. CR처리 가능한 조건
			if ( do_hld_flg == "N"  && cr_chk_flg == "Y" ) {
				
				formObj.f_cmd.value = MULTI02;
				var params = "?bl_no="+bl_no+"&new_pod_cd="+new_pod_cd+"&old_pod_cd="+old_pod_cd+"&new_pod_yd_cd="+new_pod_yd_cd+"&old_pod_yd_cd="+old_pod_yd_cd+"&event_id=K&"+FormQueryString(formObj);
				ComOpenWait(true);
				var sXml = sheetObjCgoRlse.GetSaveXml("ESM_BKG_0909GS.do", params) ;
				ComOpenWait(false);
					
				if ("ERROR"==sXml.substring(1,6)){
					ComShowMessage(ComResultMessage(sXml).split('<||>').join('\n'));
				} else {
					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
						ComShowCodeMessage("BKG00166");
						return;
					}
				}
			}	
						    
	   	}
	   	
	   	
	   	function podChangeTabColor(flg){
	   		if(flg == "Y"){
		        if(tabObjects[0].GetCount()==10){
		        	tabObjects[0].TabBackColor(3)= "#fff270";
		        }else{
		        	tabObjects[0].TabBackColor(2)= "#fff270";
		        }
	   		}else{
		        if(tabObjects[0].GetCount()==10){
		        	tabObjects[0].TabBackColor(3)= "206,220,246";
		        }else{
		        	tabObjects[0].TabBackColor(2)= "206,220,246";
		        }
	   		}
	   	}
   
	/* 개발자 작업  끝 */    