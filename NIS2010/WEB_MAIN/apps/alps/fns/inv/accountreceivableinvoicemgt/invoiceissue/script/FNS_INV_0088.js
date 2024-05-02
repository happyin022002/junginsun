/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0088.js
*@FileTitle : (Vietnam)Multi B/L List
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.30 최우석
* 2010.02.16 최우석
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.01.24 최도순 [CHM-201108418] 베트남지역 ALPS INVOICE 변경 요청
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
     * @class fns_inv_0088 : fns_inv_0088 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0088() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.checkFlag				= checkFlag;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
	 * 
	 * @return 없음
	 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_ok":	
		        	// 사전 체크 로직 - [CHM-201111084] 베트남 지역 인보이스 로직 변경 요청
		        	// Combined 인 경우에만!! Single 경우는 0036에서 체크
		        	if(!doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC20)){
		        		break;
		        	} 
            		var cnt = checkFlag(sheetObject1);
            		if(cnt == 0) {
            			ComShowCodeMessage("INV00091");
            		} else {
            			var issType = formObject.iss_type.value;
            			if(issType == "SINGLE") {
            				var blNos = "";
	            			for (var i = 1; i <=sheetObject1.RowCount; i++) {
	    				    	if(sheetObject1.CellValue(i, "stl_flg") == "1") {
	    				    		blNos = blNos + sheetObject1.CellValue(i, "bl_no") + "|";
	    				    	}
	    				    }	    				    
	    				    rdOpenPreview("S",blNos);
            			}else{
	            			var blNos = "";
	            			for (var i = 1; i <=sheetObject1.RowCount; i++) {
	    				    	if(sheetObject1.CellValue(i, "stl_flg") == "1") {
	    				    		blNos = blNos + "'" + sheetObject1.CellValue(i, "bl_no") + "',";
	    				    	}
	    				    }
	    				    if (blNos != ""){
	    				    	blNos = blNos + "''";
	    				    }
	            			rdOpenPreview("M",blNos);
            			}	
	            		//doActionIBSheet(sheetObject1,formObject,IBSAVE);
	            		//window.close();
            		}
            		break; 
                                         
            	case "btn_close":
            		window.close();
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
     * preview 화면에서 issue 할때, 호출됨<br>
     *
     * @param {object} formObject
     * @param {object} sheetObject
     * @return 없음
     */
    function getPreviewIssue(){
    	var formObject = document.form;
    	var sheetObject1 = sheetObjects[0];
    	doActionIBSheet(sheetObject1,formObject,IBSAVE);
    	document.form.preview_yn.value = "Y";
    	self.close();
    }
    
    /**
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의<br>
     *
     * @param {object} sheet_obj
     * @return 없음
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화<br>
     * body 태그의 onLoad 이벤트핸들러 구현<br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
     *
     * @return 없음
     */
    function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);

//             sheetObjects[i].ExtendLastCol = false;
         }
    }

    /**
     * 시트 초기설정값, 헤더 정의<br>
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
     * 
     * @param {object} sheetObj
     * @param {int} sheetNo
     * @return 없음
     * @see #loadPage
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;

    	switch(sheetNo) {
    		case 1:      //sheet1 init
    			with (sheetObj) {
    				WaitImageVisible = false;
    			
    				// 높이 설정
                    style.height = 240;
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

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel|Seq|B/L No.|CHRG CODE|Cur.|Amount|sail_arr_dt|io_bnd_cd|inv_type|vie_chg_cd|vn_inv_pay_mzd_cd";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,	30,    	daCenter,  	true,	"ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox,		40,		daCenter,  	true,	"stl_flg");
                    InitDataProperty(0, cnt++, dtDataSeq, 		40,		daCenter,  	true,   "Seq");										
 					InitDataProperty(0, cnt++, dtData,  		130,  	daCenter,   false,  "bl_no",   			false,	"",		dfNone,   		0,	false,	false);
 					InitDataProperty(0, cnt++, dtData,    		140,   	daCenter,  	false,  "chg_cd",   		false,  "",     dfNone,      	0,  false,  false);
                    InitDataProperty(0, cnt++, dtData,    		90,   	daCenter,  	false,  "curr_cd",   		false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtData,  		90,   	daRight,  	false,  "chg_amt",    		false,  "",     dfNone,  		0,  false,  false);

 					//----------------------------------------------------------------------
 					InitDataProperty(0, cnt++, dtHidden,   		70,   	daCenter,  	false,  "sail_arr_dt",   	false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtHidden,   		70,   	daCenter,  	false,  "io_bnd_cd",   		false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtHidden,   		70,   	daCenter,  	false,  "inv_type",   		false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtHidden,   		70,   	daCenter,  	false,  "vie_chg_cd",   		false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtHidden,   		70,   	daCenter,  	false,  "vn_inv_pay_mzd_cd",   	false,  "",     dfNone,      	0,  false,  false);
 					//----------------------------------------------------------------------
 					
 					WordWrap = true;
    			}
                break;
    	}
    }

    /** Sheet관련 프로세스 처리<br>
     * 
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @return 없음
     * @see #processButtonClick
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("FNS_INV_0088GS.do", FormQueryString(formObj));
    			break;

    		case IBSAVE:        //저장
    			var issType = formObj.iss_type.value;
	    		for (var i = 1; i <=sheetObj.RowCount; i++) {
			    	if(sheetObj.CellValue(i, "stl_flg") == "1") {
			    		if(sheetObj.CellValue(i, "vie_chg_cd")==""){
			    			ComShowCodeMessage("INV00136",sheetObj.CellValue(i, "chg_cd"));
			    			return false;
			    		}
			    	}
			    }    			
    			if(issType == "SINGLE") {
    				var blNos = "";
				    for (var i = 1; i <=sheetObj.RowCount; i++) {
				    	if(sheetObj.CellValue(i, "stl_flg") == "1") {
				    		blNos = blNos + "'" + sheetObj.CellValue(i, "bl_no") + "',";
				    	}
				    }
				    if (blNos != ""){
				    	blNos = blNos + "''";
				    }
				    opener.form.bl_nos.value = blNos;
				    opener.saveCombine();
    			} else {
		    		formObj.f_cmd.value = MULTI;
					var param = FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(),"sheet1_");
					var sXml = sheetObj.GetSaveXml("FNS_INV_0088GS.do", param);
					var invNoCnt = ComGetEtcData(sXml, "invNoCnt");
	    			var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
	    			if(state == "S") {
	    				if(invNoCnt == "-1") {
	    					ComShowCodeMessage("INV00097");
	    				} else if(invNoCnt == "-2") {
	    					ComShowCodeMessage("INV00098");
	    				} else {
		    				opener.form.inv_no_cnt.value = invNoCnt;
		    				var invNoList = ComGetEtcData(sXml, "invNoList");
		    				opener.form.inv_no_list.value = invNoList;
//		    				ComShowCodeMessage("INV00051");
		    				opener.rdOpen("M");
	    				}
	    			} else{
	    				ComShowCodeMessage("INV00053");
	    			}
    			}
    			break;

    		case IBINSERT:      //입력
    			break;
    		
    		// 신규 추가 칼럼 대응 - [CHM-201111084] 베트남 지역 인보이스 로직 변경 요청
     		case IBSEARCH_ASYNC20: //체크
	     		if(validateForm(sheetObj,formObj,sAction)) {
	     		
	     			var formObjOpener = opener.document.form;
				    var arOfcCd = formObj.ar_ofc_cd.value;

				    var invType = "";
				    var invTypeMsg = "";
				    
				    if(formObjOpener.btn_invType[0].checked) {
				    	invType = "F";
				    	invTypeMsg = "VAT";
				    } else if(formObjOpener.btn_invType[1].checked) {
				    	invType = "T";
				    	invTypeMsg = "VTT";
				    } else if(formObjOpener.btn_invType[2].checked) {
				    	invType = "H";
				    	invTypeMsg = "VDT";
				    } else if(formObjOpener.btn_invType[3].checked) {
				    	invType = "D";
				    	invTypeMsg = "VAT";
				    } else if(formObjOpener.btn_invType[4].checked) {
				    	invType = "R";
				    	invTypeMsg = "VAT";
				    } else if(formObjOpener.btn_invType[5].checked) {
				    	invType = "M";
				    	invTypeMsg = "VAT";
				    } else if(formObjOpener.btn_invType[6].checked) {
				    	invType = "S";
				    	invTypeMsg = "VST";
				    } else if(formObjOpener.btn_invType[7].checked) {
				    	invType = "C";
				    	invTypeMsg = "VCT";
				    } else if(formObjOpener.btn_invType[8].checked) {
				    	invType = "E";
				    	invTypeMsg = "VRT";
				    } else if(formObjOpener.btn_invType[9].checked) {
				    	invType = "X";
				    	invTypeMsg = "VAT";
				    }
				    switch(invType) {
					    case "T":
					    case "H":
					    case "S":
					    case "C":
					    case "E":
					    case "X":
						
					    	formObjOpener.f_cmd.value = SEARCH02;		
					    	
					    	var blNos = "";
	            			for (var i = 1; i <=sheetObj.RowCount; i++) {
	    				    	if(sheetObj.CellValue(i, "stl_flg") == "1") {
	    				    		blNos = blNos + "[" + sheetObj.CellValue(i, "bl_no") + "]";
	    				    	}
	    				    }
					    	
					    	formObjOpener.inv_no_list.value = blNos;
					    	
						    var sXml = sheetObj.GetSaveXml("FNS_INV_0036GS.do", FormQueryString(formObjOpener));
							var invNoCnt = ComGetEtcData(sXml, "invNoCnt");
							var chgCd = ComGetEtcData(sXml, "chg_cd");
	
							if(invNoCnt == "-1") {
		    					ComShowCodeMessage("INV00097");
		    					return false;
		    				} else if(invNoCnt == "-2") {
		    					ComShowCodeMessage("INV00098");
		    					return false;
		    				} else {
		    					var vat_exist = ComGetEtcData(sXml, "vatExist");
							    // 해당vat가 존재하지 않을 경우
		    					if (vat_exist != "vat_exist") {
						    		
							    	// 입력된 BL의 갯수를 취득한다.
							    	var arrBlNos = blNos.split("]");
					    			var vatNoExistBlNo = ComGetEtcData(sXml, "vatNoExistBlNo");
					    			if(invType == "X" && chgCd == "VET"){
										invTypeMsg = "VET";
									}else if(invType == "X" && chgCd == "VETTVA"){
										invTypeMsg = invTypeMsg + ",VET";
									}
					    			if(!ComShowConfirm(ComGetMsg("INV00142",invTypeMsg,vatNoExistBlNo))){
					    				return false;
					    			} else { return true;}
						    	} else {
						    		return true;
			    				}
		    				}
							
					    	break;
					    	
					    case "F":
					    case "R":
					    case "M":
					    case "D":
					    	return true;
					    	break;
				    }
	     		}
	     		break;
    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
     *
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @return bool;
     */
    function validateForm(sheetObj,formObj,sAction){
    	return true;
    }
     
    /**
     * 업무 자바스크립트 OnLoadFinish 이벤트 처리한다.<br>
     * 
     * @param {object} sheetObj
     * @return 없음
     */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	if(sheetObj.RowCount == 0) {
    		ComBtnDisable("btn_ok");
    	} else {
    		ComBtnEnable("btn_ok");
    	}
    }

    /**
     * 저장할 대상을 체크한다.<br>
     * 
     * @param {object} sheetObj
     * @return 없음
     */
    function checkFlag(sheetObj) {
    	var cnt = 0;
    	for(var row=1; row<=sheetObj.LastRow; row++) {
    		if(sheetObj.CellValue(row, "stl_flg") == "1") {
    			cnt++;
    			//sheetObj.CellValue2(row, "ibflag") = "I";
    			sheetObj.RowStatus(row) = "I";
    		}
    	}
    	
    	return cnt;
    }
    
  	function rdOpenPreview(issType,blList){
  		var formObj = opener.document.form;
  		var arrBlNo = blList.split("|");
  		var ofcCd = formObj.ofc_cd.value;
  		var arOfcCd = formObj.ar_ofc_cd.value;
  		
  		// [CHM-201111084] 베트남 지역 인보이스 로직 변경 요청
  		var vnInvPayMzdCd = formObj.vn_inv_pay_mzd_cd.value;
  		
  		var invRt = ComReplaceStr(formObj.xch_rt.value,",","");
  		var invType = "";
  		var rdFiles = "";
  		var rdParam = "";
  		if(formObj.btn_invType[0].checked) {
  			invType = "F";
  		} else if(formObj.btn_invType[1].checked) {
  			invType = "T";
  		} else if(formObj.btn_invType[2].checked) {
  			invType = "H";
  		} else if(formObj.btn_invType[3].checked) {
  			invType = "D";
  		} else if(formObj.btn_invType[4].checked) {
  			invType = "R";
  		} else if(formObj.btn_invType[5].checked) {
  			invType = "M";
  		} else if(formObj.btn_invType[6].checked) {
  			invType = "S";
  		} else if(formObj.btn_invType[7].checked) {
  			invType = "C";
  			
  		//2010-07-19 TYPE REF 추가
  		} else if(formObj.btn_invType[8].checked) {
  			invType = "E";
  		//2010-11-08 TYPE ETC 추가
  		} else if(formObj.btn_invType[9].checked) {
  			invType = "X";
  		}
  		
  		for(var i=0; i<arrBlNo.length; i++){
  			if(arrBlNo[i] != ''){
  				if (issType == "S") {
  					rdFiles = rdFiles +"FNS_INV_0531_SINGLE_PREVIEW.mrd" +"|";					
				} else {
					rdFiles = rdFiles +"FNS_INV_0531_MULTI_PREVIEW.mrd" +"|";
				}
  				//[CHM-201111084] 베트남 지역 인보이스 로직 변경 요청
  				//rdParam = rdParam + "/rv " + "frm1_bl_src_no[" + arrBlNo[i] + "] frm1_ofc_cd [" + ofcCd + "] frm1_inv_gb[" + invType + "] frm1_ar_ofc_cd[" + arOfcCd + "]frm1_inv_rt[" + invRt + "]" + "|";
  				rdParam = rdParam + "/rv " + "frm1_bl_src_no[" + arrBlNo[i] + "] frm1_ofc_cd [" + ofcCd + "] frm1_inv_gb[" + invType + "] frm1_ar_ofc_cd[" + arOfcCd + "]frm1_inv_rt[" + invRt + "]frm1_mth_py[" + vnInvPayMzdCd + "]" + "|";
  			}
  		}

  		document.form.com_mrdPath.value = rdFiles ;
  		document.form.com_mrdArguments.value = rdParam;
		ComOpenWindowCenter("FNS_INV_0034_02_prev.do?view_flag=S", "pop3", 800, 700);
  	}
	/* 개발자 작업  끝 */