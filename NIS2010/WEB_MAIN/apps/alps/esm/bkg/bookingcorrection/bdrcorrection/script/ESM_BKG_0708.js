/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0708.js
*@FileTitle : C/A Issue Reason Selection
*Open Issues : ESM_BKG_0708 화면
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.31 이남경
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
     * @class esm_bkg_0708 : esm_bkg_0708 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0708() {
    	this.processButtonClick		 = tprocessButtonClick;
    	this.setSheetObject 		 = setSheetObject;
    	this.loadPage 				 = loadPage;
    	this.initSheet 				 = initSheet;
    	this.setComboObject          = setComboObject;
    	this.doActionIBSheet 		 = doActionIBSheet;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;    
    
    var comboObjects = new Array();
    var comboCnt = 0;
       
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        sheetObject1 = sheetObjects[0];
        sheetObject2 = sheetObjects[1];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_select":				
					if (!validateForm(sheetObjects[0], document.form, IBSAVE)) return;
					
					var modeCd = formObject.mode_cd.value;
					if (modeCd == "S") {
						if (!ComBkgProcessYn("start C/A")) {
	        	    		return false;
	        	    	}	
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE); 
					} else if (modeCd == "R") {
						if (!ComBkgProcessYn("modify C/A Reason")) {
	        	    		return false;
	        	    	}
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE); 
					} else if (modeCd == "C") {
						if (!ComBkgProcessYn("Confirm C/A")) {
	        	    		return false;
	        	    	}
						pre_comPopupOK(sheetObjects[0], sheetObject1.SelectRow); 
					}
			    	break;
			    	
				case "btn_close":
					self.close();
					break;
					
				case "btn2_CA_Desc":
					ComOpenPopup('apps/alps/esm/bkg/bookingcorrection/bdrcorrection/jsp/ESM_BKG_07081.jsp', 650, 600 ,"", "1,0,1,1,1,1", true);
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
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     */
    function setComboObject(combo_obj){
       comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }
        
        //---------------
        //IBMultiCombo 초기화
        for(var k=0; k<comboObjects.length; k++){
            initCombo(comboObjects[k],k+1);
        } 

        initControl(); 
        
        //initParam();  //form 객체에 한번만
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
    }
     
    function initControl() {
  	    var formObj = document.form;
  	    axon_event.addListenerFormat('keypress', 'bkg0708_keypress', formObj);  //- 키보드 입력할때
  	    //axon_event.addListenerForm  ('keyup',    'bkg0708_keyup',    formObj);  //- obj_keyup
  	}
    
    function bkg0708_keypress() {
    	var srcName = window.event.srcElement.getAttribute("name");
    	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	    switch(event.srcElement.dataformat){           
	        case "etc": //모든 문자 가능하지만 영문은 대문자로
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	                event.keyCode = keyValue + 65 - 97;
	            }
	        	break;	
        	
		    default:
		    	break;
	    }
    }

    function initCombo(comboObj, comboNo) {
    	with (comboObj) {
    		MultiSeparator = "|";
    		
	    	switch(comboObj.id) {
	    	    case "rdn_acpt_flg" : 	    	    	
	    	    	comboObj.InsertItem(-1, "Accept",     "Y");     
	    	    	comboObj.InsertItem(-1, "Not Accept", "N"); 
	    	    	comboObj.Index2 = 1;
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
		switch(sheetObj.id) {
			case "sheet1":      //t4sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 160;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msNone;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = " Chk||Type|Description";
		            var headCount = ComCountHeadTitle(HeadTitle);
		            		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            //dtRadioCheck
		            InitDataProperty(0,	cnt++,	dtRadioCheck,	30 ,  daCenter,	     false,	  "radio",     false,    "",      dfNone,	      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtHiddenStatus,	50,   daCenter,  	 false,   "ibflag",    false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    60,   daCenter,  	 false,   "val",       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,     	120,  daLeft,  	     false,   "name",      false,    "",      dfNone,         0,     false,      false);
		        }
		        break;
		        
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
					
					var HeadTitle = "|bkg_no|ca_rsn_cd|ca_remark|rdn_sts_cd";
					var headCount = ComCountHeadTitle(HeadTitle);
			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtRadioCheck,	30 , 	daCenter,	false,	"radio",        false,  "", dfNone,	    0,      true, true);
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	"bkg_no",       false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	"ca_rsn_cd",    false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			300, 	daCenter,	false,	"ca_remark",    false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	"rdn_sts_cd",    false,	"",	dfNone,		0,		true, true);
				}
		        break; 
		}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
      	    case IBSEARCH: 
      	    	if (sheetObj.id=="sheet1") {
	      	    	formObj.f_cmd.value = SEARCH;
 	          		sheetObj.DoSearch("ESM_BKG_0708GS.do", FormQueryString(formObj)); 	          		
      	    	}
                break;
                
     		case IBSAVE:
                if (formObj.mode_cd.value == "S") {         //startCA
                	formObj.f_cmd.value = MULTI;
		    	} else if (formObj.mode_cd.value == "R") {  //modifyCaReason
		    		formObj.f_cmd.value = MULTI01;
		    	}

                var nChkRow = sheetObj.FindCheckedRow("radio");
                var arrRow = nChkRow.split("|");
                if (arrRow.length > 0) {
                	formObj.ca_rsn_cd.value = sheetObj.CellValue(arrRow[0], "val");
                }

          	    var sParam1 = ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_"); 
          	    var sParam = FormQueryString(formObj);
          		sParam += "&" + sParam1; 

          		var sXml = sheetObj.GetSaveXml("ESM_BKG_0708GS.do", sParam); 

				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
	            if(State != "S"){	            	
	            	sheetObjects[0].LoadSaveXml(sXml);
	            } else {
	    			if (formObj.f_cmd.value == MULTI01) {
	    				this.close();
	    			} else {
	    				pre_comPopupOK(sheetObjects[0], sheetObjects[0].SelectRow); 
	    			}
	            }
	            break;
        }
    }

    
    //######################[1. Event]############################################################
    /**
    * 저장완료시, 
    */    
//    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
//    	var formObj = document.form;
//    	
//		if (ErrMsg.trim() == msgs['BKG00166'].trim()) {
//			if (formObj.f_cmd.value == MULTI01) {
//				this.close();
//			} else {
//				pre_comPopupOK(sheetObjects[0], sheetObjects[0].SelectRow); 
//			}
//		}
//    }
    
    /**
    * 조회완료시, 
    */ 
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) { 
	   	var formObj = document.form;
	   	if (ErrMsg.trim().length > 0) {
	   		self.close();
	   		return;
	   	}
	   	
	   	//01. BkgBlNoVO 초기화 
	   	formObj.ca_rsn_cd.value    = sheetObj.EtcData("ca_rsn_cd"); 
	   	formObj.bkg_corr_rmk.value = sheetObj.EtcData("bkg_corr_rmk"); 
	   	
	   	//02. RDN 초기화 
	   	var strRdnStsCd = sheetObj.EtcData("rdn_sts_cd");
	   	formObj.rdn_sts_cd.value          = strRdnStsCd;
	   	formObj.rdn_no.value              = sheetObj.EtcData("rdn_no");	   	
	   	formObj.rvis_seq.value            = sheetObj.EtcData("rvis_seq");
	   	formObj.intg_cd_val_dp_desc.value = sheetObj.EtcData("intg_cd_val_dp_desc");
	   	formObj.rdn_acpt_flg.Code2        = sheetObj.EtcData("rdn_acpt_flg");
	   	formObj.umch_tp_cd.value          = sheetObj.EtcData("umch_tp_cd");
	   	formObj.umch_sub_tp_cd_hid.value  = sheetObj.EtcData("umch_sub_tp_cd_hid");
	   	
	   	var modeCd = formObj.mode_cd.value;
	   	if ("C" == modeCd) {
	   		formObj.rdn_acpt_flg.Enable = false;
	   	} else {
	   		if ("IS" == strRdnStsCd || "RV" == strRdnStsCd) {
	   			formObj.rdn_acpt_flg.Enable = true;
	   		} else {
	   			formObj.rdn_acpt_flg.Enable = false;
	   		}
	   	}	   	
	   	
	   	var nSRow = sheetObj.FindText("val", sheetObj.EtcData("ca_rsn_cd"));	   	
	   	if (nSRow > -1) {
	   		sheetObj.CellValue2(nSRow, "radio") = 1;
	   	}
	   	
	   	//Unmatch Sub Type Code 초기화
	   	setUmchSubCd();
	   	
	   	//02. Booking 상태별 : CA 관련 버튼 초기화 
	   	initControl(); 
    }
	
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	if (sheetObj.ColSaveName(Col) == "radio"){
    		if(Value=="1" && sheetObj.CellValue(Row, "val")=="D"){
    			ComShowCodeMessage("BKG08347");
    		}
    	}
    }
    
    /**
     * 이벤트가 발생시 umch_sub_tp_cd 콤보를 조회하고 hidden 값으로 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 		setUmchSubCd();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function setUmchSubCd() {
    	var formObj = document.form;
    	var errorKind2 = formObj.umch_sub_tp_cd; 
		formObj.f_cmd.value = COMMAND05;
		formObj.etc1.value 	= formObj.umch_tp_cd.value;
		var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
		ComXml2ComboItem(sXml, errorKind2, "cd", "nm");
		
		if(formObj.umch_tp_cd.value == 'Non-Charged B/L'){
			errorKind2.InsertItem(0, "", "");
		}
		//조회한 히든 값으로 세팅
		errorKind2.Code = formObj.umch_sub_tp_cd_hid.value;
		if(errorKind2.Index == "-1" && errorKind2.GetCount() > 0) {
			errorKind2.Index = "0";
		}
		if(formObj.umch_tp_cd.value != 'Non-Charged B/L'){
			errorKind2.Enable = false;
		}
		
    }
    
	//######################[2. Etc]##############################################################	    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
	   	//1.기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크 
	   	if (!ComChkValid(formObj)) return false;
	   	 
	   	//2.업무체크-업무에서 필요한 Validation 체크 
	   	with(formObj) {
	         switch (sAction) {	                 
	             case IBSAVE: // 저장
	                 //01. Sheet 선택
	                 if (sheetObj.CheckedRows("radio") <= 0) {
	                	 ComShowCodeMessage("BKG00249");
	                	 return false;
	                 } 
	                 //02. Remark 입력
	                 if (formObj.bkg_corr_rmk.value == "") {
	                	 ComShowCodeMessage("BKG00104", "Remark");
	                	 formObj.bkg_corr_rmk.focus();
	                	 return false;
	                 }
	                 
	                 //03.Non Charged RDN Accept시 Error Reason 선택
	                 if(formObj.rdn_acpt_flg.Code == 'Y' && formObj.umch_tp_cd.value == 'Non-Charged B/L') {
	                	 if(formObj.umch_sub_tp_cd.Code == ''){
	                		 ComShowCodeMessage("BKG95031", "Non-Charged B/L Reason");
	    	                 return false;
	                	 }
	                 }
	                 
	            	 break;
	         }
        }

        return true;
    }
    
	/**
	 * CA Reason : Recall 
	 */
    function pre_comPopupOK(sheetObj_org, nSRow) {
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[1];
    	
        sheetObj.RemoveAll();                //grid 초기화  
        var nRow = sheetObj.DataInsert(-1);  //신규행 추가 
        
        sheetObj.CellValue2(nRow, "bkg_no")    = sheetObj_org.CellValue(nSRow, "bkg_no");
 		sheetObj.CellValue2(nRow, "ca_rsn_cd") = sheetObj_org.CellValue(nSRow, "val");
 		sheetObj.CellValue2(nRow, "ca_remark") = formObj.bkg_corr_rmk.value;
 		sheetObj.CellValue2(nRow, "rdn_sts_cd") = formObj.rdn_sts_cd.value;
 		
 		sheetObj.CellValue2(nRow, "radio") = "Y";

    	comPopupOK();
    }    
   
    //#############################(3. Util/Etc)##################################################

    
	/* 개발자 작업  끝 */