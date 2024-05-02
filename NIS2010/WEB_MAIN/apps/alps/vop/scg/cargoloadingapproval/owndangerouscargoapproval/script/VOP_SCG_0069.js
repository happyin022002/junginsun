/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0069.js
*@FileTitle : Pre Checking Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.23 김현욱
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
     * @class VOP_SCG_0069 : VOP_SCG_0069 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_SCG_0069() {
    	this.processButtonClick  = processButtonClick;
    	this.setSheetObject      = setSheetObject;
    	this.loadPage            = loadPage;
    	this.initControl         = initControl;
    	this.t3sheet1_OnLoadFinish = t3sheet1_OnLoadFinish;
    	this.t4sheet2_OnLoadFinish = t4sheet2_OnLoadFinish;
    	this.t4sheet1_OnLoadFinish = t4sheet1_OnLoadFinish;
    	this.t1sheet1_OnLoadFinish = t1sheet1_OnLoadFinish;
    	this.setDisplaySpList    = setDisplaySpList;
    	this.t3sheet1_OnSearchEnd  = t3sheet1_OnSearchEnd;
    	this.t4sheet2_OnSearchEnd  = t4sheet2_OnSearchEnd;
    	this.t4sheet1_OnSearchEnd  = t4sheet1_OnSearchEnd;
    	this.t3sheet1_OnMouseMove  = t3sheet1_OnMouseMove;
    	this.t1sheet1_OnSelectCell = t1sheet1_OnSelectCell;
    	this.t1sheet1_OnKeyUp      = t1sheet1_OnKeyUp;
    	this.initSheet           = initSheet;
    	this.chkClick            = chkClick;
    	this.filterUnNo          = filterUnNo;
    	this.checkUnNo           = checkUnNo;
    	this.setResultChecking   = setResultChecking;
    	this.doActionIBSheet     = doActionIBSheet;
    	this.validateForm        = validateForm;
    }
    
   	/* 개발자 작업	*/
/*--------------------------------------------------------------------------------------------
 * PopUp 모드 구분                                                                                                      popType     opener name
 * ***************                                     *******     ***********
 * 1. 기본형(자사) : Pre-Checking + Special Request      N/A            N/A
 * 2. 기본형(타사) : Pre-Checking                        "R"        "partnerDG"
 * 3. 조회형(공통) : Pre-Checking                        "R"            N/A 
 * 4. 백그라운드형1: Pre-Checking + 팝업창 자동닫힘                    "B"            N/A
 * 5. 백그라운드형2: Pre-Checking + 팝업레이어 자동닫힘          "B2"           N/A
 --------------------------------------------------------------------------------------------*/   	

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt     = 0;
    
    var chkRslt      = 0;
    var chkFinish    = 0;
    
    var opener       = window.dialogArguments;
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
	var tabIndex = 0;
	
	var comboObjects  = new Array();
	var comboCnt      = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var sheetObj1 = sheetObjects[1];
    	//var sheetObj3 = sheetObjects[7];
		var sheetObj4 = sheetObjects[4];
	//	var sheetObj5 = sheetObjects[9];

        /*******************************************************/
		var formObj   = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				
				case "btn_Close":
					window.close();
					break;	
				case "btn_add":
					sheetObj4.DataInsert(-1,0);
					sheetObj4.SelectCell(sheetObj4.SelectRow, "spcl_cntr_seq");
					
					//Control Button of Special Request
					if(sheetObj4.RowCount == 0) ctlBtnSpRqt(false);	
					else ctlBtnSpRqt(true);	
					
					break;
				case "btn_insert":
					sheetObj4.DataInsert();			
					sheetObj4.SelectCell(sheetObj4.SelectRow, "spcl_cntr_seq");
					
					//Control Button of Special Request
					if(sheetObj4.RowCount == 0) ctlBtnSpRqt(false);	
					else ctlBtnSpRqt(true);
					
					break;
				case "btn_copy":
					sheetObj4.DataCopy();	
					
					//Control Button of Special Request
					if(sheetObj4.RowCount == 0) ctlBtnSpRqt(false);	
					else ctlBtnSpRqt(true);
					
					break;
				case "btn_delete":
					ComRowHideDelete(sheetObj4, "del_chk");
					
					//Control Button of Special Request
					if(sheetObj4.RowCount == 0) ctlBtnSpRqt(false);	
					else ctlBtnSpRqt(true);
					
					break;
				case "btn_sp_request":
					doActionIBSheet(sheetObj4,formObj,IBSAVE);
					break;

            } 
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
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(popType) {
    	
    	//페이지가 Frame 형태일 경우 호출창속성 변경 
    	if(popType == 'B2') opener = parent;
    	
    	 
        for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);		
        }
        
        initControl();

        //타사일 경우 Special Request 또는 단순 첵일 경우  비활성화 
        if(opener.name == 'partnerDG' || popType == 'R') {
        	document.all.spLayer.style.display = "none";
        	document.all.spBtnLayer1.style.display = "none";
        	document.all.spBtnLayer2.style.display = "";
//        	sheetObjects[6].style.height = 180;
//        	sheetObjects[8].style.height = 180;
//        	sheetObjects[7].style.height = 310;
        } else if(popType == 'SR') {
        	document.getElementById("spReq").disabled = true;
        }
        if(popType == 'B') {
        	ComOpenWait(true, true);
        }
        
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    	doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
    	doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
    	
    	if(popType != 'SR') {
//   		 doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
//    		 doActionIBSheet(sheetObjects[4],document.form,IBSEARCH);
//    		 doActionIBSheet(sheetObjects[7],document.form,IBSEARCH);
//    		 doActionIBSheet(sheetObjects[9],document.form,IBSEARCH);
    		 
    		 doActionIBSheet(sheetObjects[4],document.form,IBSEARCH);
    		 doActionIBSheet(sheetObjects[7],document.form,IBSEARCH);
    		 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    		 doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
    	}
    
    	for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
    	
    	//IBMultiCombo초기화
        for(k = 0; k < comboObjects.length; k++) {
       	 initCombo(comboObjects[k], k + 1);
        }
        
        //화면 깜박임으로 LoadFinish에서 여기로 이동
        //sheetObjects[2].Enable = true;
        sheetObjects[4].Enable = true;
       
    }
     
    // 이벤트 Catch Listener
    function initControl() {
    	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListener('click', 'chkClick', 'spReq');
    }
    
    /**
     * t3sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function t3sheet1_OnLoadFinish(sheetObj) {	    	
    	 //if(popType != 'B2') doActionIBSheet(sheetObj,document.form,IBSEARCH);	//ComOpenWait 함수 충돌 이유로 LoadPage로 이동
    }
    
    /**
     * t4sheet2 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function t4sheet2_OnLoadFinish(sheetObj) {	    	
    	 //if(popType != 'B2') doActionIBSheet(sheetObj,document.form,IBSEARCH);	//ComOpenWait 함수 충돌 이유로 LoadPage로 이동
    }
     
    /**
     * t4sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function t4sheet1_OnLoadFinish(sheetObj) {	    	
    	 //if(popType != 'B2') doActionIBSheet(sheetObj,document.form,IBSEARCH);	//ComOpenWait 함수 충돌 이유로 LoadPage로 이동
    }
     
    /**
     * t1sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function t1sheet1_OnLoadFinish(sheetObj) {	
    	 //Special Request 목록 Display
    	 setDisplaySpList(sheetObj);
    	 
    	 sheetObj.Enable = false;
      	 ComBtnDisable("btn_add");
      	 ComBtnDisable("btn_insert");
      	 ComBtnDisable("btn_copy");
      	 ComBtnDisable("btn_delete");
      	 ComBtnDisable("btn_sp_request");
    }
    
    //Special Request 목록 Display
    function setDisplaySpList(sheetObj) {
    	//자사의 경우 Special Request 목록 Display
   	 	if(popType == '' || popType == 'SR') {
   	 		if (opener.ComFuncCheck("getCgoSheet")) {
   	 			var cgoSheetObj = opener.getCgoSheet();
   	 			var spYn, cancelYn, reasonStr;
   	 			for(var cgoCt=cgoSheetObj.HeaderRows, spCt=sheetObj.HeaderRows; cgoCt<=cgoSheetObj.LastRow; cgoCt++) {
   	 				spYn      = cgoSheetObj.CellValue(cgoCt, "spcl_rqst_flg");
   	 				cancelYn  = cgoSheetObj.CellValue(cgoCt, "spcl_cgo_apro_cd");
   	 				reasonStr = cgoSheetObj.CellValue(cgoCt, "spcl_rqst_desc");
   	 				if(spYn == "Y" && cancelYn != 'C' && reasonStr != '') {
   	 					sheetObj.DataInsert(-1,0);
   	 					sheetObj.CellValue2(spCt, "spcl_cntr_seq")  = cgoSheetObj.CellValue(cgoCt, "dg_cntr_seq");
   	 					sheetObj.CellValue2(spCt, "spcl_cgo_seq")   = cgoSheetObj.CellValue(cgoCt, "cntr_cgo_seq");
   	 					sheetObj.CellValue2(spCt, "imdg_un_no")     = cgoSheetObj.CellValue(cgoCt, "imdg_un_no");
   	 					sheetObj.CellValue2(spCt, "imdg_un_no_seq") = cgoSheetObj.CellValue(cgoCt, "imdg_un_no_seq");
   	 					sheetObj.CellValue2(spCt, "reason")         = cgoSheetObj.CellValue(cgoCt, "spcl_rqst_desc");
   	 					
   	 					spCt++;
   	 				}
   	 			}
   	 			
   	 			sheetObj.SelectCell(0,0);
   	 		}
   	 	}
    }
     
    /**
     * t3sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) { 
    
      	with(sheetObj) {
      		var rsltStr = "";
      		if(RowCount != 0) {
      			rsltStr = 'Load does not comply. Segregation is required between pairs of substances listed below.';
      			
      			chkRslt++;
      		} 
      		document.getElementById("rsltStr").innerText = rsltStr;
      	}
      	
      	chkFinish++;
      	
      	//체크결과
    	setResultChecking();
    }
     
    /**
     * t4sheet2 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function t4sheet2_OnSearchEnd(sheetObj, ErrMsg) { 
    	var sortCols = new Array();
 		sortCols[0]  = "spcl_cntr_seq";
 		sortCols[1]  = "spcl_cgo_seq";
 		
 		var sortDirs = new Array();
 		sortDirs[0]  = "ASC";
 		sortDirs[1]  = "ASC";
 		
 		sheetObj.ColumnSort(sortCols.join("|"),"ASC",sortDirs.join("|"),true);
 		
 		with(sheetObj) {
      		if(RowCount != 0) {
      			chkRslt++;
      			
      			for(var i=HeaderRows; i<=LastRow; i++){
      				CellFontColor(i, "prohibition_desc") = RgbColor(255, 0, 0);
    	        }
      		}
      	}
 		
 		chkFinish++;
 		
 		//체크결과
    	setResultChecking();
    }
     
    /**
     * t4sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) { 
    	var rslt  = 0;
    	var rslt1 = 0;
    	var hRow = '';
    	with(sheetObj) {
	    	for(var i=HeaderRows; i<=LastRow; i++){
	            if (CellValue( i, "imdg_cmptn_auth_desc") == "Prohibition" ||
	            		CellValue( i, "restriction_req") == "Permit") {
	            	if(CellValue( i, "imdg_cmptn_auth_desc") == "Prohibition"){
	            		CellFontColor(i, "imdg_cmptn_auth_desc") = RgbColor(255, 0, 0);
	            	}else{
	            		CellFontColor(i, "restriction_req") = RgbColor(255, 0, 0);
	            	}
	                 rslt++;
	            }
	            if (CellValue( i, "port_type") == "T/S") {
	            	 hRow = i;
	                 rslt1++;
	            }	            
	        }
    	}
    	if(rslt > 0) chkRslt++;
    	//T/S구간에서 Port로 걸린 구간이 없으나 Vessel로 걸린 구간이 있을경우 Port의 빈 Row를 삭제한다.
    	if(rslt1 > 1 && sheetObj.CellValue( hRow, "imdg_cmptn_auth_desc") == "") sheetObj.RowHidden(hRow) = true;
    	
    	chkFinish++;
    	
    	//체크결과
    	setResultChecking();
    }
     
    /**
     * t3sheet1 OnMouseMove Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function t3sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
     	if (sheetObj.MouseCol == 4 || sheetObj.MouseCol == 10) {
     		sheetObj.MouseToolTipText = "Segregation Group";
     	} else {
     		sheetObj.MouseToolTipText = "";
     	}
    }
    
    /**
     * t1sheet1 OnSelectCell Event 처리
     * param : sheetObj ==> 시트오브젝트, NewRow ==> 변경한 Row, NewCol ==> 변경한 Col
     * 
     */
    var lockKey = false;
    function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {    	
    	with(sheetObj) {
    		
    		if(OldRow >= HeaderRows) {
	    		Value = CellValue(OldRow, OldCol);
				if(ColSaveName(OldCol) == "spcl_cntr_seq") {
					if(Value == '') {
		     			CellValue2(OldRow, "spcl_cgo_seq")   = ""; 
		     			CellValue2(OldRow, "imdg_un_no")     = ""; 
		     			CellValue2(OldRow, "imdg_un_no_seq") = ""; 
		     		} else if(Value != '' && !filterUnNo(Value, CellValue(OldRow, "spcl_cgo_seq"), CellValue(OldRow, "imdg_un_no"), CellValue(OldRow, "imdg_un_no_seq"), "self", OldRow)) {
		     			lockKey = true;
		     			
		     			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
		     			
						CellValue2(OldRow, "spcl_cntr_seq")  = "";
						CellValue2(OldRow, "spcl_cgo_seq")   = ""; 
		     			CellValue2(OldRow, "imdg_un_no")     = ""; 
		     			CellValue2(OldRow, "imdg_un_no_seq") = "";
		     			
						SelectCell(OldRow, "spcl_cntr_seq");
		     		}
				} else if(ColSaveName(OldCol) == "spcl_cgo_seq") {
					if(Value == '') {
		     			CellValue2(OldRow, "imdg_un_no")     = ""; 
		     			CellValue2(OldRow, "imdg_un_no_seq") = ""; 
		     		} else if(Value != '') {
		     			if(CellValue(OldRow, "spcl_cntr_seq") != '') {
			     			if(!filterUnNo(CellValue(OldRow, "spcl_cntr_seq"), Value, CellValue(OldRow, "imdg_un_no"), CellValue(OldRow, "imdg_un_no_seq"), "self", OldRow)) {	     		
				     			lockKey = true;
				     			
				     			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
				     			
								CellValue2(OldRow, "spcl_cgo_seq")   = ""; 
				     			CellValue2(OldRow, "imdg_un_no")     = ""; 
				     			CellValue2(OldRow, "imdg_un_no_seq") = "";
				     			
								SelectCell(OldRow, "spcl_cgo_seq");
			     			}
		     			} else {
		     				ComShowCodeMessage('SCG50007', 'CNTR');	//'Please input {?msg1}.'
		     				
		     				CellValue2(OldRow, "spcl_cgo_seq") = ""; 
		     				SelectCell(OldRow, "spcl_cntr_seq");
		     			}
		     		}
				} else if(ColSaveName(OldCol) == "imdg_un_no") {
					if(Value == '') {
		     			CellValue2(OldRow, "imdg_un_no_seq") = ""; 
		     		} else if(Value != '') {
		     			if(CellValue(OldRow, "spcl_cgo_seq") != '') {
			     			if(!filterUnNo(CellValue(OldRow, "spcl_cntr_seq"), CellValue(OldRow, "spcl_cgo_seq"), Value, CellValue(OldRow, "imdg_un_no_seq"), "self", OldRow)) {	     		
				     			lockKey = true;
				     			
				     			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
				     			
								CellValue2(OldRow, "imdg_un_no")     = ""; 
				     			CellValue2(OldRow, "imdg_un_no_seq") = "";
				     			
								SelectCell(OldRow, "imdg_un_no");
			     			}
		     			} else {
		     				var chkCell = "spcl_cgo_seq", chkMsg = "CGO";
		     				if(CellValue(OldRow, "spcl_cntr_seq") == '') {
		     					chkCell = "spcl_cntr_seq";
		     					chkMsg  = "CNTR";
		     				}
		     				ComShowCodeMessage('SCG50007', chkMsg);	//'Please input {?msg1}.'
		     				
		     				CellValue2(OldRow, "imdg_un_no") = ""; 
		     				SelectCell(OldRow, chkCell);
		     			}
		     		}
		     	} else if(ColSaveName(OldCol) == "imdg_un_no_seq") {
		     		if(Value != '') {
		     			if(CellValue(OldRow, "imdg_un_no") != '') {
			     			if(!filterUnNo(CellValue(OldRow, "spcl_cntr_seq"), CellValue(OldRow, "spcl_cgo_seq"), CellValue(OldRow, "imdg_un_no"), Value, "self", OldRow)) {	     		
				     			lockKey = true;
				     			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
				     			
								CellValue2(OldRow, "imdg_un_no_seq") = "";
				     			
								SelectCell(OldRow, "imdg_un_no_seq");
			     			}
		     			} else {
		     				var chkCell = "imdg_un_no", chkMsg = "UN No.";
		     				if(CellValue(OldRow, "spcl_cgo_seq") == '') {
		     					chkCell = "spcl_cgo_seq";
		     					chkMsg  = "CGO";
		     					if(CellValue(OldRow, "spcl_cntr_seq") == '') {
			     					chkCell = "spcl_cntr_seq";
			     					chkMsg  = "CNTR";
			     				}
		     				}
		     				ComShowCodeMessage('SCG50007', chkMsg);	//'Please input {?msg1}'
		     				
		     				CellValue2(OldRow, "imdg_un_no_seq") = ""; 
		     				SelectCell(OldRow, chkCell);
		     			}
		     		}
		     	}
    		}
		}
    }
     
    /**
     * t1sheet1 OnKeyUp Event 처리
     * param : sheetObj ==> 시트오브젝트, 선택한 Row ==> Row, 선택한 Col ==> Col
     * 
     */
    function t1sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	with(sheetObj) { 
			var len = EditValue.length;
			if(!lockKey) {
				if(ColSaveName(Col) == "imdg_un_no") { 
					if(len == 4) {
						//SelectCell(Row, "imdg_un_no_seq");
					}
				} else if(ColSaveName(Col) == "imdg_un_no_seq") { 				
					if(len == 4) {
						//SelectCell(Row, "reason");
					}
				}
			} else {
				lockKey = false;
			}
 		}
    }

	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
        
        case "sheet1":      //sheet1 init
	        with (sheetObj) {
	
	            //높이 설정
	            style.height = 140;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(2, 1, 15, 100);
	
				var HeadTitle1 = "|Sequence|Sequence||||||||||||||||||||||||||||||||UN No./Seq.|UN No./Seq.||||||||||||||||||||||||||||||||||IMDG|IMDG|IMDG|IMDG|IMDG|Operation|Operation";
				var HeadTitle2 = "|CNTR|CGO|Container No.|TPSZ" +
                 "|out_n1st_imdg_pck_qty|out_n1st_imdg_pck_cd|out_n1st_imdg_pck_desc|out_n2nd_imdg_pck_qty|out_n2nd_imdg_pck_cd|out_n2nd_imdg_pck_desc" +
                 "|in_n1st_imdg_pck_qty|in_n1st_imdg_pck_cd|in_n1st_imdg_pck_desc|in_n2nd_imdg_pck_qty|in_n2nd_imdg_pck_cd|in_n2nd_imdg_pck_desc" +
                 "|intmd_n1st_imdg_pck_qty|intmd_n1st_imdg_pck_cd|intmd_n1st_imdg_pck_desc|intmd_n2nd_imdg_pck_qty|intmd_n2nd_imdg_pck_cd|intmd_n2nd_imdg_pck_desc" +
                 "|max_in_pck_qty|max_in_pck_tp_cd|hcdg_pck_rstr_desc|hcdg_intmd_bc_rstr_desc|hcdg_tnk_rstr_desc|imdg_lmt_qty|imdg_lmt_qty_meas_ut_cd|imdg_expt_qty_cd|imdg_spcl_provi_no" +
                 "|imdg_clss_cd|imdg_comp_grp_cd|IMDG UN No.|Seq|grs_wgt|wgt_ut_cd|net_wgt|ttl_capa" +
                 "|prp_shp_nm|hzd_desc|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|hcdg_flg|imdg_subs_rsk_lbl_rmk" +
        		 "|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3|imdg_subs_rsk_lbl_cd4|dcgo_sts_cd|mrn_polut_flg|imdg_expt_qty_flg" +
        		 "|emer_cntc_phn_no|emer_cntc_pson_nm|certi_no" +
        		 "|ems_no|ctrl_temp_ctnt|emer_rspn_gid_no|emer_rspn_gid_chr_no|emer_temp_ctnt" +
        		 "|diff_rmk|auth_dt|auth_sts_cd|org_auth_sts_cd|apro_ref_no|cgo_rqst_dt" +
        		 "|Mandatory|Pack.Inst|LTD QTY|Excepted QTY|Stow & Seg|Port|Carrier";

				var headCount = ComCountHeadTitle(HeadTitle1);
				sheet1HeadTitleCnt = headCount;
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++,  dtHiddenStatus,  		20,     daCenter,    	false,   	"ibflag");  
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		"spcl_cntr_seq");
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		"spcl_cgo_seq");
				InitDataProperty(0, cnt++ , dtHidden,				100,	daCenter,		true,		"cntr_ref_no",				false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"cntr_tpsz_cd",				false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"out_n1st_imdg_pck_qty",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"out_n1st_imdg_pck_cd",		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"out_n1st_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"out_n2nd_imdg_pck_qty",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"out_n2nd_imdg_pck_cd",		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"out_n2nd_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"in_n1st_imdg_pck_qty",	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"in_n1st_imdg_pck_cd",		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"in_n1st_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"in_n2nd_imdg_pck_qty",	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"in_n2nd_imdg_pck_cd",		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"in_n2nd_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"intmd_n1st_imdg_pck_qty",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"intmd_n1st_imdg_pck_cd",   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"intmd_n1st_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"intmd_n2nd_imdg_pck_qty",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"intmd_n2nd_imdg_pck_cd",   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"intmd_n2nd_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"max_in_pck_qty",	        false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"max_in_pck_tp_cd",		    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"hcdg_pck_rstr_desc",	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"hcdg_intmd_bc_rstr_desc",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"hcdg_tnk_rstr_desc",	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"imdg_lmt_qty",	            false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"imdg_lmt_qty_meas_ut_cd",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"imdg_expt_qty_cd",	        false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,		false,		"imdg_spcl_provi_no",	    false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"imdg_clss_cd",				false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"imdg_comp_grp_cd",			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,		"imdg_un_no",				false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"imdg_un_no_seq",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daRight,		true,		"grs_wgt",					false,			"",      dfNullFloat,		3,		true,		true, 18);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"wgt_ut_cd",				false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daRight,		true,		"net_wgt",					false,			"",      dfNullFloat,		3,		true,		true, 18);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daRight,		true,		"ttl_capa",					false,			"",      dfNullFloat,		3,		true,		true, 18);
				
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"prp_shp_nm",				false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"hzd_desc",					false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"flsh_pnt_cdo_temp",		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"imdg_pck_grp_cd",			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"psa_no",					false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"imdg_lmt_qty_flg",			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"hcdg_flg",				    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"imdg_subs_rsk_lbl_rmk",	false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"n1st_imdg_subs_rsk_lbl_cd",false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"n2nd_imdg_subs_rsk_lbl_cd",false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"n3rd_imdg_subs_rsk_lbl_cd",false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"n4th_imdg_subs_rsk_lbl_cd",false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"dcgo_sts_cd",				false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"mrn_polut_flg",			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"imdg_expt_qty_flg",		false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"emer_cntc_phn_no",			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"emer_cntc_pson_nm",		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"certi_no",					false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"ems_no",					false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"ctrl_temp_ctnt",			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"emer_rspn_gid_no",			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"emer_rspn_gid_chr_no",		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"emer_temp_ctnt",			false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"diff_rmk",					false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"auth_dt",					false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"auth_sts_cd",				false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"org_auth_sts_cd",			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"apro_ref_no",				false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,		true,		"cgo_rqst_dt",				false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					95,		daCenter,		true,		"mdt_flg",					false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					95,		daCenter,		true,		"pi_flg",					false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					95,		daCenter,		true,		"ltd_qty_flg",				false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					95,		daCenter,		true,		"expt_qty_flg",				false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					95,		daCenter,		true,		"seg_flg",					false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					95,		daCenter,		true,		"port_flg",					false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					95,		daCenter,		true,		"crr_flg",					false,			"",      dfNone,			0,		false,		false);
									
				CountPosition = 0;	
			}
	        break;
            
			case "t3sheet1":      //t3sheet1 init
                with (sheetObj) {

                    //높이 설정
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
                    InitRowInfo(2, 1, 15, 100);

					var HeadTitle1 = "Sequence|Sequence|UN No./Seq.|UN No./Seq.|SG|Conflicts with|Sequence|Sequence|UN No./Seq.|UN No./Seq.|SG";
					var HeadTitle2 = "CNTR|CGO| | |SG|Conflicts with|CNTR|CGO| | |SG";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);


                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,   		40,		daCenter,		true,    "spcl_cntr_seq1", 		false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,	   		40,		daCenter,		true,    "spcl_cgo_seq1",		false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,   	true,    "imdg_un_no1",			false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,			30,		daCenter,   	true,    "imdg_un_no_seq1",		false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,   	true,    "imdg_segr_grp_no1", 	false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,   		445,	daCenter,		true,    "conflict_desc", 		false,     "",      dfNone,      0,     true,    true); 
                    InitDataProperty(0, cnt++ , dtData,   		40,		daCenter,		true,    "spcl_cntr_seq2", 		false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,   		40,		daCenter,		true,    "spcl_cgo_seq2", 		false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,		true,    "imdg_un_no2", 		false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,   		30,		daCenter,		true,    "imdg_un_no_seq2", 	false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,   		45,		daCenter,		true,    "imdg_segr_grp_no2", 	false,     "",      dfNone,      0,     true,    true);
                    
                    //선택된 행의 하이라이트를 안준다.
                    SelectHighLight = false;

                    EditableColorDiff = false;
                    HeadRowHeight = 20;
                    
                    ToolTipText(4, "imdg_segr_grp_no1") = "Segregation Group";
                    
                    SetMergeCell(0, 2, 2, 2);
                    SetMergeCell(0, 8, 2, 2);
                    
                    WordWrap = true;
				}
                break;

			case "t4sheet2":      //t4sheet2 init
                with (sheetObj) {

                    //높이 설정
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
                    InitRowInfo(2, 1, 15, 100);

					
                    var HeadTitle1 = "Sequence|Sequence|UN No./Seq.| |VVD CD|Vessel\nOperator|Prohibition on|Detailed Information|";
					var HeadTitle2 = "CNTR|CGO| | |VVD CD|Vessel\nOperator|Prohibition on|Detailed Information|";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);


                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,   			40,    daCenter,		true,    "spcl_cntr_seq", 		false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,	   			40,    daCenter,		true,    "spcl_cgo_seq",		false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,				60,    daCenter,   		true,    "imdg_un_no",			false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,				30,    daCenter,   		true,    "imdg_un_no_seq",		false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,		 		100,   daCenter,     	true,    "vvd_cd", 	  			false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,   			80,    daCenter,		true,    "crr_cd", 		        false,     "",      dfNone,      0,     true,    true); 
                    InitDataProperty(0, cnt++ , dtData,   			140,   daCenter,		true,    "prohibition_desc", 	false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,   			200,   daLeft,			true,    "crr_regu_desc", 		false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,   		0,     daCenter,		true,    "chk_type", 	        false,     "",      dfNone,      0,     true,    true);
                    
                    //선택된 행의 하이라이트를 안준다.
                    SelectHighLight = false;

                    EditableColorDiff = false;
                    HeadRowHeight = 20;
                    
                    SetMergeCell(0, 2, 2, 2);
				}
                break;

			case "t4sheet1":      //t4sheet1 init
                with (sheetObj) {

                    //높이 설정
                    style.height = 150;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 15, 100);

                    var HeadTitle1 = "Type|Port Code|Seq|Prohibition/Restriction|Restriction Required|Explanation|Sequence|Sequence|UN No./Seq.| ";
                    var HeadTitle2 = "Type|Port Code|Seq|Prohibition/Restriction|Restriction Required|Explanation|CNTR|CGO| | ";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,	   	50,    daCenter,	true,    "port_type",				false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,		70,    daCenter,  	true,    "port_cd",					false,     "",      dfNone,      0,     true,    true);
                    
                    InitDataProperty(0, cnt++ , dtHidden,	30,	    daCenter,   false,	 "seq",                     false,     "|spcl_cntr_seq|+|spcl_cgo_seq|");
                    InitDataProperty(0, cnt++ , dtData,		100,    daCenter,   true,    "imdg_cmptn_auth_desc", 	false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,		140,    daCenter,   true,    "restriction_req", 		false,     "",      dfNone,      0,     true,    true); 
                    InitDataProperty(0, cnt++ , dtData,   	500,    daLeft,	    true,    "txt_desc", 				false,     "",      dfNone,      0,     true,    true); 
                    InitDataProperty(0, cnt++ , dtData,   	40,    	daCenter,	true,    "spcl_cntr_seq", 			false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,   	40,    	daCenter,	true,    "spcl_cgo_seq", 			false,     "",      dfNone,      0,     true,    true);
                    
                    InitDataProperty(0, cnt++ , dtData,   	60,    	daCenter,	true,    "imdg_un_no", 				false,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,   	30,    	daCenter,	true,    "imdg_un_no_seq", 			false,     "",      dfNone,      0,     true,    true);
                    
                    //선택된 행의 하이라이트를 안준다.
                    SelectHighLight = false;

                    SetMergeCell(0, 8, 2, 2);
				}
                break;
                
			case "t1sheet0":      //t1sheet0 init
	            with (sheetObj) {	
	
	                //높이 설정
	                style.height = 140;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(2, 1, 15, 100);
	
	                var HeadTitle1 = "Sequence|Sequence|UN No./Seq.|UN No./Seq.|Description";
					var HeadTitle2 = "CNTR|CGO|UN No.|Seq|Description";
					var headCount = ComCountHeadTitle(HeadTitle1);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                //해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
	
	
	                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtData,   			40,    daCenter,		true,    "spcl_cntr_seq", 		false,     "",      dfNone,      0,     false,    false);
	                InitDataProperty(0, cnt++ , dtData,	   			40,    daCenter,		true,    "spcl_cgo_seq",		false,     "",      dfNone,      0,     false,    false);
	                InitDataProperty(0, cnt++ , dtData,				60,    daCenter,   		true,    "imdg_un_no",			false,     "",      dfNone,      0,     false,    false);
	                InitDataProperty(0, cnt++ , dtData,				30,    daCenter,   		true,    "imdg_un_no_seq",		false,     "",      dfNone,      0,     false,    false);
	                InitDataProperty(0, cnt++ , dtData,		 		100,   daLeft,     		true,    "mtd_desc", 	  		false,     "",      dfNone,      0,     false,    false);
	                
	                //선택된 행의 하이라이트를 안준다.
	                SelectHighLight = false;
	
	                EditableColorDiff = false;
	                HeadRowHeight = 20;
	                
	                WordWrap = true;
	                
				}
            break;

			case "t1sheet1": case "t1sheet2":     //t1sheet1, t1sheet2 init
                with (sheetObj) {
					
					var keyFieldYn = false;
                    //높이 설정
                    if(id == 't1sheet1') {
                    	style.height = 120;
                    	keyFieldYn   = true;
                    } else {
                    	style.height = 0;
                    }
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 15, 100);

                    var HeadTitle1 = "|Sel.|Sequence|Sequence|UN No./Seq.|UN No./Seq.|Reason";
                    var HeadTitle2 = "|Sel.|CNTR|CGO|UN No./Seq.|UN No./Seq.|Reason";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		0,    daCenter,		true,    "ibflag");
                    
					InitDataProperty(0, cnt++ , dtCheckBox,   		40,    daCenter,	true,    "del_chk", 			false,          "",      dfNone,      0,     true,    true);
					InitDataProperty(0, cnt++ , dtData,   	        50,    daCenter,	true,    "spcl_cntr_seq", 		keyFieldYn,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,   	        50,    daCenter,	true,    "spcl_cgo_seq", 		keyFieldYn,     "",      dfNone,      0,     true,    true);
					InitDataProperty(0, cnt++ , dtData,	   			80,    daCenter,	true,    "imdg_un_no",			keyFieldYn,     "",      dfNone,      0,     true,    true, 4);
                    InitDataProperty(0, cnt++ , dtData,				40,    daCenter,   	true,    "imdg_un_no_seq",		keyFieldYn,     "",      dfNone,      0,     true,    true, 4);
                    InitDataProperty(0, cnt++ , dtData,		 		0,     daLeft,   	true,    "reason", 	  			keyFieldYn,     "",      dfNone,      0,     true,    true);
                    
                    KeyFieldImage = "/hanjin/img/blank.gif";
                    
                    InitDataValid(0, "spcl_cntr_seq",  vtNumericOther, "");
                    InitDataValid(0, "spcl_cgo_seq",   vtNumericOther, "");
                    InitDataValid(0, "imdg_un_no",     vtNumericOther, "");
					InitDataValid(0, "imdg_un_no_seq", vtNumericOther, "");    
					
					SetMergeCell(0, 4, 2, 2);
				}
                break;
                
			case "t2sheet1":      //t2sheet1 init
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
	 			InitRowInfo( 1, 1, 3, 100);
	
	 			
	
	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 			InitHeadMode(true, true, false, true, false,false)
	
	 			var HeadTitle = "|Restriction Regulatory|Restriction Regulatory|Validation Result|Validation Result|Validation Result|Validation Result";
	 			var headCnt  = HeadTitle.split("|").length;
                HeadTitleCnt = headCnt;
                
              //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 			InitColumnInfo(headCnt, 0, 0, true);
	 			
	 			Rows = 5;
	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 			InitHeadRow(0, HeadTitle, true);
	
	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
	 			InitDataProperty(0, cnt++ , dtData,      	140,	daLeft,  	true,   "div_nm",  			false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	190,	daRight,  	true,   "regu_val",			false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	140,	daCenter,  	true,   "max_wgt_nm",		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	140,	daCenter,  	true,   "max_wgt_rslt",		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	140,	daCenter,  	true,   "pkg_tp_nm",		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	140,	daCenter,  	true,   "pkg_tp_rslt",		false,  "",      dfNone,    0,     true,    	true);
	 			
	 			InitHeadColumn(1, "Limite Q'ty|Execpted Q'ty|Packing Instruction|Special Pack.Inst.|Others",daCenterTop);
                InitHeadColumn(3, "Max Weight|Max Weight|Max Weight|Max Weight",daCenterTop);
                InitHeadColumn(5, "PKG Type|PKG Type|PKG Type|PKG Type|PKG Type",daCenterTop);
                
                SelectHighLight = false;
                CountPosition = 0;
                //initSheet1(sheetObjects[4]);	  //초기 sheet1 디지인 세팅
                initSheet1(sheetObjects[7]);	  //초기 sheet1 디지인 세팅
 			}
	 		break;
    	 		
    	 	case "t2sheet2":		//t2sheet2
//	    	 	
    	 	with (sheetObj) {
	 			// 높이 설정
	 			style.height = 90;
	 			//전체 너비 설정
	 			SheetWidth = mainTable.clientWidth;
	
	 			//Host정보 설정[필수][HostIp, Port, PagePath]
	 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	 			//전체Merge 종류 [선택, Default msNone]
	 			MergeSheet = msHeaderOnly;
	
	 			//전체Edit 허용 여부 [선택, Default false]
	 			Editable = false;
	
	 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	 			InitRowInfo( 1, 1, 3, 100);
	
	 			
	
	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 			InitHeadMode(true, true, false, true, false,false)
	
	 			var HeadTitle = "|SEQ|Reason of Invalid Details( Double click a data row for the packing instruction information )";
	 			var headCnt  = HeadTitle.split("|").length;
                
              //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 			InitColumnInfo(headCnt, 0, 0, true);
	 			
	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 			InitHeadRow(0, HeadTitle, true);
	
	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
	 			InitDataProperty(0, cnt++ , dtData,      	30,		daCenter,  	true,   "seq",  			false,  "",      dfNone,    0,     true,    	true);
	 			//InitDataProperty(0, cnt++ , dtData,      	200,	daLeft,  	true,   "invld_desc",  		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	200,	daLeft,  	true,   "invld_desc",  		false,  "",      dfNone,    0,     true,    	true,	-1,		false,		true,	"\"Double click a data row for the packing instruction information.\"");
                
                SelectHighLight = false;
                CountPosition = 0;
                
                WordWrap = true;
 			}
    	 	break;
    	 	
    	 	case "t2sheet3":		//t2sheet3
//	    	 	
    	 	with (sheetObj) {
	 			// 높이 설정
	 			style.height = 90;
	 			//전체 너비 설정
	 			SheetWidth = mainTable.clientWidth;
	
	 			//Host정보 설정[필수][HostIp, Port, PagePath]
	 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	 			//전체Merge 종류 [선택, Default msNone]
	 			MergeSheet = msHeaderOnly;
	
	 			//전체Edit 허용 여부 [선택, Default false]
	 			Editable = false;
	
	 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	 			InitRowInfo( 1, 1, 3, 100);
	
	 			
	
	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 			InitHeadMode(true, true, false, true, false,false)
	
	 			var HeadTitle = "|Special Packaging Instruction & Provisions to be reffered|Special Packaging Instruction & Provisions to be reffered";
	 			var headCnt  = HeadTitle.split("|").length;
                
              //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 			InitColumnInfo(headCnt, 0, 0, true);
	 			
	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 			InitHeadRow(0, HeadTitle, true);
	
	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
	 			InitDataProperty(0, cnt++ , dtData,      	50,		daLeft,  	true,   "spcl_pck_provi_cd",  		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	200,	daLeft,  	true,   "spcl_pck_provi_desc",  	false,  "",      dfNone,    0,     true,    	true);
                
                SelectHighLight = false;
                CountPosition = 0;
                
                WordWrap = true;
 			}
    	 	break;
        }
    }
     
    //Special Request Check Box Click
    function chkClick() {
     	if(event.srcElement.checked) {
     		//sheetObjects[2].RemoveAll();
     		//sheetObjects[2].KeyFieldImage = "/imdg/img/ico_star.gif";
     		sheetObjects[4].KeyFieldImage = "/imdg/img/ico_star.gif";
     		
     		document.getElementById("spReqStr").innerHTML = '* Please review checking  result again. If you still want to proceed booking, please check the <strong>"Checkbox"</strong> and enter a valid reason in the  <strong>"Reason for Special Request"</strong> then click <strong>"Special Request"</strong> button.';    		
     		//sheetObjects[2].Enable = true;
     		sheetObjects[4].Enable = true;
     		ComBtnEnable("btn_add");
     		ComBtnEnable("btn_insert");
     		ComBtnEnable("btn_copy");
     		ComBtnEnable("btn_delete");
     		
     		//Control Button of Special Request
			//if(sheetObjects[2].RowCount == 0) ctlBtnSpRqt(false);
			if(sheetObjects[4].RowCount == 0) ctlBtnSpRqt(false);
			else ctlBtnSpRqt(true);	
     	} else {
     		document.getElementById("spReqStr").innerHTML = "&nbsp;";
//     		sheetObjects[2].RemoveAll();
//     		sheetObjects[2].KeyFieldImage = "/imdg/img/blank.gif";
            sheetObjects[4].RemoveAll();
     		sheetObjects[4].KeyFieldImage = "/imdg/img/blank.gif";
     		
     		//Special Request 목록 Display
     		//setDisplaySpList(sheetObjects[2]);
     		setDisplaySpList(sheetObjects[4]);
     		
     		//sheetObjects[2].Enable = false;
     		sheetObjects[4].Enable = false;
     		ComBtnDisable("btn_add");
          	ComBtnDisable("btn_insert");
          	ComBtnDisable("btn_copy");
          	ComBtnDisable("btn_delete");
          	
          	ctlBtnSpRqt(false);	//Control Button of Special Request
     	}
    }
    
    //Control Button of Special Request
    function ctlBtnSpRqt(flg) {
    	if(flg) ComBtnEnable("btn_sp_request");
    	else ComBtnDisable("btn_sp_request");
    }
    
    //UN No. Validation
    function filterUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, type, row) {

//    	var sheetObj1 = sheetObjects[7];
//		var sheetObj2 = sheetObjects[9];
//		var sheetObj3 = sheetObjects[8];
//		var sheetObj4 = sheetObjects[2];
		var sheetObj1 = sheetObjects[1];
		var sheetObj2 = sheetObjects[3];
		var sheetObj3 = sheetObjects[2];
		var sheetObj4 = sheetObjects[4];
		
		
		var sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq;			
    	for(var idx1=sheetObj1.HeaderRows; idx1<=sheetObj1.LastRow; idx1++) {
    		sheetCntrSeq = sheetObj1.CellValue(idx1, "spcl_cntr_seq1");
    		sheetCgoSeq  = sheetObj1.CellValue(idx1, "spcl_cgo_seq1");
    		sheetUnNo    = sheetObj1.CellValue(idx1, "imdg_un_no1");
    		sheetUnNoSeq = sheetObj1.CellValue(idx1, "imdg_un_no_seq1");
    		
    		if(checkUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq, type)) {
    			if(type == 'self' && spcl_cntr_seq != '' && spcl_cgo_seq != '') {
    				sheetObj4.CellValue2(row, "imdg_un_no") = sheetObj1.CellValue(idx1, "imdg_un_no1");
    				sheetObj4.CellValue2(row, "imdg_un_no_seq") = sheetObj1.CellValue(idx1, "imdg_un_no_seq1");
    			}
    			return true;
    		}
    		
    		sheetCntrSeq = sheetObj1.CellValue(idx1, "spcl_cntr_seq2");
    		sheetCgoSeq  = sheetObj1.CellValue(idx1, "spcl_cgo_seq2");
    		sheetUnNo    = sheetObj1.CellValue(idx1, "imdg_un_no2");
    		sheetUnNoSeq = sheetObj1.CellValue(idx1, "imdg_un_no_seq2");
    		
    		if(checkUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq, type)) {
    			if(type == 'self' && spcl_cntr_seq != '' && spcl_cgo_seq != '') {
    				sheetObj4.CellValue2(row, "imdg_un_no") = sheetObj1.CellValue(idx1, "imdg_un_no2");
    				sheetObj4.CellValue2(row, "imdg_un_no_seq") = sheetObj1.CellValue(idx1, "imdg_un_no_seq2");
    			}
    			return true;
    		}
    	}
    	for(var idx2=sheetObj2.HeaderRows; idx2<=sheetObj2.LastRow; idx2++) {
    		sheetCntrSeq = sheetObj2.CellValue(idx2, "spcl_cntr_seq");
    		sheetCgoSeq  = sheetObj2.CellValue(idx2, "spcl_cgo_seq");
    		sheetUnNo    = sheetObj2.CellValue(idx2, "imdg_un_no");
    		sheetUnNoSeq = sheetObj2.CellValue(idx2, "imdg_un_no_seq");
    		
    		if(checkUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq, type)) {
    			if(type == 'self' && spcl_cntr_seq != '' && spcl_cgo_seq != '') {
    				sheetObj4.CellValue2(row, "imdg_un_no") = sheetObj2.CellValue(idx2, "imdg_un_no");
    				sheetObj4.CellValue2(row, "imdg_un_no_seq") = sheetObj2.CellValue(idx2, "imdg_un_no_seq");
    			}
    			return true;
    		}
    	}
    	for(var idx3=sheetObj3.HeaderRows; idx3<=sheetObj3.LastRow; idx3++) {
    		sheetCntrSeq = sheetObj3.CellValue(idx3, "spcl_cntr_seq");
    		sheetCgoSeq  = sheetObj3.CellValue(idx3, "spcl_cgo_seq");
    		sheetUnNo    = sheetObj3.CellValue(idx3, "imdg_un_no");
    		sheetUnNoSeq = sheetObj3.CellValue(idx3, "imdg_un_no_seq");
    		
    		if(checkUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq, type)) {
    			if(type == 'self' && spcl_cntr_seq != '' && spcl_cgo_seq != '') {
    				sheetObj4.CellValue2(row, "imdg_un_no") = sheetObj3.CellValue(idx3, "imdg_un_no");
    				sheetObj4.CellValue2(row, "imdg_un_no_seq") = sheetObj3.CellValue(idx3, "imdg_un_no_seq");
    			}
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    //UN No. Validation
    function checkUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq, type) {
    	if(spcl_cntr_seq == sheetCntrSeq) {
			if(spcl_cgo_seq != '' || type == 'all') {
				if(spcl_cgo_seq == sheetCgoSeq) {
					if(un_no != '' || type == 'all') {
			    		if(un_no == sheetUnNo) {
			    			if(un_no_seq != '' || type == 'all') {
			    				if(un_no_seq == sheetUnNoSeq) return true;
			    			} else {
			    				return true;
			    			}
			    		}
					} else {
						return true;
					}
				}
			} else {
				return true;
			}
		}
    	
    	return false;
    }
    
    //Result Setter
    function setResultChecking() {
    
    	//수행 결과
		if(chkFinish == 3) {
			//체크 결과
			var chkStr = "N";
			if(chkRslt == 0) {
				chkStr = "Y";
				
				//Special Request 체크박스 비활성화
				if(popType == '') document.getElementById("spReq").disabled = true;
			} else if(chkRslt > 0) {
				chkStr = "P";
				
//				setCheckingList();	//Set checking list
			}
			
			//호출창에 체크결과 리턴
			opener.setPreChkRslt(chkStr);
			
			//호출유형에 따라 체크후 창닫기 처리 분리
			if(popType == 'B') {
				ComOpenWait(false);
				window.returnValue = chkStr;
				window.close();
			} else if(popType == 'B2') {
				opener.closeProgressPop();
			}
		}
    }
    
    //Set checking list
    function setCheckingList() {
    	//var stgSheetObj = sheetObjects[2];
    	var stgSheetObj = sheetObjects[4];
    	var stgRowCt    = stgSheetObj.HeaderRows-1;
    	var dupRow      = -1;
    	var sheetPrefix = "";
    	
    	for(var sheetCt=7; sheetCt<10; sheetCt++) {
	    	with(sheetObjects[sheetCt]) {
	    		if(RowCount != 0) {
		    		if(sheetCt == 0) sheetPrefix = "1"; 
		    		else sheetPrefix = "";
		    		
			    	for(var rowCt=HeaderRows; rowCt<=LastRow; rowCt++) { 	
			    		if(CellValue(rowCt, "imdg_un_no"+sheetPrefix) != '') {
				    		stgSheetObj.DataInsert(-1,0);stgRowCt++;
				    		stgSheetObj.CellValue2(stgRowCt, "spcl_cntr_seq")  = CellValue(rowCt, "spcl_cntr_seq"+sheetPrefix);
				    		stgSheetObj.CellValue2(stgRowCt, "spcl_cgo_seq")   = CellValue(rowCt, "spcl_cgo_seq"+sheetPrefix);
				    		stgSheetObj.CellValue2(stgRowCt, "imdg_un_no")     = CellValue(rowCt, "imdg_un_no"+sheetPrefix);
				    		stgSheetObj.CellValue2(stgRowCt, "imdg_un_no_seq") = CellValue(rowCt, "imdg_un_no_seq"+sheetPrefix);
				    		
				    		dupRow = stgSheetObj.ColValueDup("spcl_cntr_seq|spcl_cgo_seq|imdg_un_no|imdg_un_no_seq");
				    		if(dupRow != -1) {
				    			stgSheetObj.RowDelete(stgRowCt, false);
				    			stgRowCt--;
				    		}
			    		}
			    		
			    		if(sheetCt == 0) {
			    			if(CellValue(rowCt, "imdg_un_no2") != '') {
					    		stgSheetObj.DataInsert(-1,0);stgRowCt++;
					    		stgSheetObj.CellValue2(stgRowCt, "spcl_cntr_seq")  = CellValue(rowCt, "spcl_cntr_seq2");
					    		stgSheetObj.CellValue2(stgRowCt, "spcl_cgo_seq")   = CellValue(rowCt, "spcl_cgo_seq2");
					    		stgSheetObj.CellValue2(stgRowCt, "imdg_un_no")     = CellValue(rowCt, "imdg_un_no2");
					    		stgSheetObj.CellValue2(stgRowCt, "imdg_un_no_seq") = CellValue(rowCt, "imdg_un_no_seq2");
					    		
					    		dupRow = stgSheetObj.ColValueDup("spcl_cntr_seq|spcl_cgo_seq|imdg_un_no|imdg_un_no_seq");
					    		if(dupRow != -1) {
					    			stgSheetObj.RowDelete(stgRowCt, false);
					    			stgRowCt--;
					    		}
			    			}
			    		}
			    	}
	    		}
	    	}
    	}
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
					
				/*------------------------------------------------------------------------------
				 * Parameter's naming (see makePreChkParam())
				 *******************************************************************************
				 * spcl_cntr_seq
				 * spcl_cgo_seq
				 * imdg_un_no
				 * imdg_un_no_seq
				 * imdg_clss_cd
				 * bkg_no
				 * pol_cd
				 * pod_cd
				 * vsl_cd
				 * skd_voy_no
				 * skd_dir_cd
				 * slan_cd
				 * imdg_lmt_qty_flg
				 * imdg_expt_qty_flg
				 * crr_cd
				 ------------------------------------------------------------------------------*/
				var sParam = opener.makePreChkParam();

			
				if ("sheet1" == sheetObj.id) {
					formObj.f_cmd.value = SEARCH04;
					var sXml = sheetObj.GetSearchXml("VOP_SCG_0069GS.do?f_cmd="+formObj.f_cmd.value, sParam);
					var arrXml = sXml.split("|$$|");
			        sheetObjects[0].LoadSearchXml(arrXml[0]);  // sheet1  Checking Result Summary
			       //sheetObjects[1].LoadSearchXml(arrXml[1]);  // t1sheet0 mandated items
			        sheetObjects[6].LoadSearchXml(arrXml[1]);  // t1sheet0 mandated items
				}
				if ("t3sheet1" == sheetObj.id) {   // Segregation Validation
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("VOP_SCG_0069GS.do?f_cmd="+formObj.f_cmd.value, sParam);
					formObj.t3retrieve_flg.value = "Y";
				}
				if ("t4sheet2" == sheetObj.id) {
					formObj.f_cmd.value = SEARCH02;
					var sXml = sheetObj.GetSearchXml("VOP_SCG_0069GS.do?f_cmd="+formObj.f_cmd.value, sParam);
					
					var arrXml = sXml.split("|$$|");
					//sheetObjects[8].LoadSearchXml(arrXml[0]);
					sheetObjects[2].LoadSearchXml(arrXml[0]);
					sheetObj.LoadSearchXml(arrXml[1]);
					formObj.t4retrieve_flg.value = "Y";
				}
				if ("t2sheet1" == sheetObj.id) {
					formObj.f_cmd.value = SEARCH03;
			        var sXml = sheetObj.GetSearchXml("VOP_SCG_0069GS.do", FormQueryString(formObj));
			        var arrXml = sXml.split("|$$|");

//			        sheetObjects[4].LoadSearchXml(arrXml[0]);  //  t2sheet1  Restriction Regulatory
//			        sheetObjects[5].LoadSearchXml(arrXml[1]);  //  t2sheet2  Reason of Invalid Details
//			        sheetObjects[6].LoadSearchXml(arrXml[2]);  // t2sheet3  Special Packaging Instruction & Provisions to be reffered
			        sheetObjects[7].LoadSearchXml(arrXml[0]);  //  t2sheet1  Restriction Regulatory
			        sheetObjects[8].LoadSearchXml(arrXml[1]);  //  t2sheet2  Reason of Invalid Details
			        sheetObjects[9].LoadSearchXml(arrXml[2]);  // t2sheet3  Special Packaging Instruction & Provisions to be reffered
			        
	        	   	break;
					formObj.t2retrieve_flg.value = "Y";
				}
				
            	break;

			case IBSAVE:        //저장(Special Request)
				if(validateForm(sheetObj,formObj,sAction)) {
					var returnSheetObj = makeSpReuqest(sheetObj);
					if(returnSheetObj != null) {
						opener.spRequest(returnSheetObj);
						window.close();
					}
				}
			 		
				break;
        }
    }
	
	//Request Special Cargo
    function makeSpReuqest(sheetObj) {
    	//var stgSheetObj = sheetObjects[2];  
    	var stgSheetObj = sheetObjects[4];  
    	
    	with(stgSheetObj) {
    		if(RowCount == 0) return null;
	    	for(var rowCt1=HeaderRows; rowCt1<=LastRow; rowCt1++) {
	    		for(var rowCt2=sheetObj.HeaderRows; rowCt2<=sheetObj.LastRow; rowCt2++) {
		    		if(CellValue(rowCt1, "spcl_cntr_seq") == sheetObj.CellValue(rowCt2, "spcl_cntr_seq")
		    		&& CellValue(rowCt1, "spcl_cgo_seq") == sheetObj.CellValue(rowCt2, "spcl_cgo_seq")
		    		&& CellValue(rowCt1, "imdg_un_no") == sheetObj.CellValue(rowCt2, "imdg_un_no")
		    		&& CellValue(rowCt1, "imdg_un_no_seq") == sheetObj.CellValue(rowCt2, "imdg_un_no_seq")
		    		  ) 
		    		{
		    			CellValue2(rowCt1, "reason") = sheetObj.CellValue(rowCt2, "reason");
		    		}
		    	}
	    	}
    	}
    	
    	return stgSheetObj;
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
    	//1. 필수체크
    	if(ComGetSaveString(sheetObj)=="") return false;
    	 
    	//2. 정합성 체크
    	var spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq;	
        with(sheetObj){
        	for(var rowIdx=HeaderRows; rowIdx<=LastRow; rowIdx++) {
        		spcl_cntr_seq = sheetObj.CellValue(rowIdx, "spcl_cntr_seq");
        		spcl_cgo_seq  = sheetObj.CellValue(rowIdx, "spcl_cgo_seq");
        		un_no         = sheetObj.CellValue(rowIdx, "imdg_un_no");
        		un_no_seq     = sheetObj.CellValue(rowIdx, "imdg_un_no_seq");
        		if(!filterUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, "all", rowIdx)) {
        			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
					SelectCell(rowIdx, "spcl_cntr_seq");
					
					return false;
        		}
        	}
        }
		return true;
	}
     
     /**
     * register IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
     
     /**
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      */
     function setComboObject(combo_obj) {
          comboObjects[comboCnt++] = combo_obj;
     }

    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Segregation & Port & Carrier" , -1 );
                    InsertTab( cnt++ , "Mandated Items" , -1 );
                    InsertTab( cnt++ , "Pack. Inst./LTD Q'TY" , -1 );
//                    InsertTab( cnt++ , "Segregation" , -1 );
                   
                }
             break;
         }
    }
     
     /**
      * Related event when clicking Tab
      * selected tab element activates.
      */
     function tab1_OnChange(tabObj , nItem){
    	 var formObj = document.form;
    	 var objs = document.all.item("tabLayer");
    	 var tabSelectedIdx = ComGetObjValue(formObj.tabSelectedIdx);

    	 objs[nItem].style.display = "Inline";
    	 objs[beforetab].style.display = "none";

    	 //--------------- important point --------------------------//
    	 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	 //------------------------------------------------------//
    	 beforetab= nItem;
    	 tabIndex = nItem;

    	 if (tabIndex == 1 &&  document.form.t1retrieve_flg.value != "Y") {
    		// doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
    		 document.body.scroll = "auto";	
    	// }else if (tabIndex == 1) {
    	 }else if (tabIndex == 2) {
    		 ComSetObjValue(formObj.imdg_un_no, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_un_no"));
   			 ComSetObjValue(formObj.imdg_un_no_seq, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_un_no_seq"));
   			 ComSetObjValue(formObj.prp_shp_nm, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "prp_shp_nm"));
   			 ComSetObjValue(formObj.imdg_clss_cd, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_clss_cd"));
//   			ComSetObjValue(formObj.imdg_clss_cd_desc, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_clss_cd_desc"));
   			 ComSetObjValue(formObj.imdg_pck_grp_cd, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_pck_grp_cd"));
   			 ComSetObjValue(formObj.dcgo_sts_cd, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "dcgo_sts_cd"));
   			 ComSetObjValue(formObj.imdg_lmt_qty_flg, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_lmt_qty_flg"));
   			 ComSetObjValue(formObj.imdg_expt_qty_flg, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_expt_qty_flg"));
   			 ComSetObjValue(formObj.grs_wgt, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grs_wgt"));
   			 ComSetObjValue(formObj.net_wgt, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "net_wgt"));
   			 ComSetObjValue(formObj.ttl_capa, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ttl_capa"));
   			 ComSetObjValue(formObj.out_imdg_pck_qty1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "out_n1st_imdg_pck_qty"));
   			 ComSetObjValue(formObj.out_imdg_pck_cd1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "out_n1st_imdg_pck_cd"));
   			 ComSetObjValue(formObj.out_imdg_pck_desc1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "out_n1st_imdg_pck_desc"));
   			 ComSetObjValue(formObj.intmd_imdg_pck_qty1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "intmd_n1st_imdg_pck_qty"));
   			 ComSetObjValue(formObj.intmd_imdg_pck_cd1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "intmd_n1st_imdg_pck_cd"));
   			 ComSetObjValue(formObj.intmd_imdg_pck_desc1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "intmd_n1st_imdg_pck_desc"));
   			 ComSetObjValue(formObj.in_imdg_pck_qty1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "in_n1st_imdg_pck_qty"));
   			 ComSetObjValue(formObj.in_imdg_pck_cd1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "in_n1st_imdg_pck_cd"));
   			 ComSetObjValue(formObj.in_imdg_pck_desc1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "in_n1st_imdg_pck_desc"));
   			 calWgt();
    		 //doActionIBSheet(sheetObjects[4],document.form,IBSEARCH);
    		 doActionIBSheet(sheetObjects[7],document.form,IBSEARCH);
    		 document.body.scroll = "yes";	
//    	 }else if (tabIndex == 2 && document.form.t3retrieve_flg.value != "Y") {
//    		 doActionIBSheet(sheetObjects[7],document.form,IBSEARCH);
//    		
//    		 document.body.scroll = "auto";	
    	 }else if (tabIndex == 0 && document.form.t4retrieve_flg.value != "Y") {
    		 //doActionIBSheet(sheetObjects[9],document.form,IBSEARCH);
    		 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    		 doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
    		 document.body.scroll = "auto";	
    	 }
    	 ComSetObjValue(formObj.tabSelectedIdx, nItem);
     }
        
        function calWgt(){
       	 if(document.form.out_imdg_pck_qty1.value !=''){
  	     	 if(document.form.grs_wgt.value !=''){
  	          	var outGrsPerUt = eval(document.form.grs_wgt.value.replaceStr(","))/eval(document.form.out_imdg_pck_qty1.value.replaceStr(","));        	              	
  	          	document.form.out_grs_per_ut.value = commitfy(roundXL(outGrsPerUt, 2));
  	         }else{
  	        	document.form.out_grs_per_ut.value = '';
  	         }
  	          	
  	     	 if(document.form.net_wgt.value !=''){
  	          	var outNetPerUt = eval(document.form.net_wgt.value.replaceStr(","))/eval(document.form.out_imdg_pck_qty1.value.replaceStr(","));
  	          	document.form.out_net_per_ut.value = commitfy(roundXL(outNetPerUt, 2));
  	     	 }else{
  	        	document.form.out_net_per_ut.value = '';
  	         }
  	          	
  	     	 if(document.form.ttl_capa.value !=''){
  	          	var outTtlCapaPerUt = eval(document.form.ttl_capa.value.replaceStr(","))/eval(document.form.out_imdg_pck_qty1.value.replaceStr(","));
  	          	document.form.out_ttl_capa_per_ut.value = commitfy(roundXL(outTtlCapaPerUt, 2));
  	     	 }else{
  	        	document.form.out_ttl_capa_per_ut.value = '';
  	         }
       	 }else{
       		document.form.out_grs_per_ut.value = '';
       		document.form.out_net_per_ut.value = '';
       		document.form.out_ttl_capa_per_ut.value = '';
       	 }
       	 if(document.form.in_imdg_pck_qty1.value !=''){
  	     	 if(document.form.grs_wgt.value !=''){
  		          	var inGrsPerUt = eval(document.form.grs_wgt.value.replaceStr(","))/eval(document.form.in_imdg_pck_qty1.value.replaceStr(","));
  	 	          	document.form.in_grs_per_ut.value = commitfy(roundXL(inGrsPerUt, 2));
  		         }else{
  		        	document.form.in_grs_per_ut.value = '';
  		         }
  		          	
  		     	 if(document.form.net_wgt.value !=''){
  		          	var inNetPerUt = eval(document.form.net_wgt.value.replaceStr(","))/eval(document.form.in_imdg_pck_qty1.value.replaceStr(","));
  	 	          	document.form.in_net_per_ut.value = commitfy(roundXL(inNetPerUt, 2));
  		     	 }else{
  		        	document.form.in_net_per_ut.value = '';
  		         }
  		          	
  		     	 if(document.form.ttl_capa.value !=''){
  		          	var inTtlCapaPerUt = eval(document.form.ttl_capa.value.replaceStr(","))/eval(document.form.in_imdg_pck_qty1.value.replaceStr(","));
  	 	          	document.form.in_ttl_capa_per_ut.value = commitfy(roundXL(inTtlCapaPerUt, 2));
  		     	 }else{
  		        	document.form.in_ttl_capa_per_ut.value = '';
  		         }
  	     	 }else{
  	     		document.form.in_grs_per_ut.value = '';
  	     		document.form.in_net_per_ut.value = '';
  	     		document.form.in_ttl_capa_per_ut.value = '';
  	     	 }
        }
        
        
        function roundXL(n, digits) {
       	 if(digits >= 0) return parseFloat(n.toFixed(digits));

       	 digits = Math.pow(10, digits);
       	 var t = Math.round(n * digits) / digits;

       	 return parseFloat(t.toFixed(0));
        }
        
        function commitfy(n) { 

       	 var reg = /(^[+-]?\d+)(\d{3})/;
       	 n += '';
       	 while(reg.test(n))
       	 n = n.replace(reg,'$1'+','+'$2');
       	 return n;
        }
        
        /**
         * Combo 기본 설정 
         * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
         * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
         */ 
        function initCombo(comboObj, comboNo) {
         	switch(comboObj.id) {
         		case "imdg_lmt_qty_flg":  	  			
     	  			with(comboObj) {
     	  				InsertItem(0, "Y", "Y"); 
     	 	  			InsertItem(1, "N", "N"); 
     	 	  			
     	  				Enable = false;
     	  				MultiSelect = false;
     	  				Code2 = "N";
     	  			} 	  			
     	  			break; 
     	  		case "imdg_expt_qty_flg":  	  			
     	  			with(comboObj) {
     	  				InsertItem(0, "Y", "Y"); 
     	 	  			InsertItem(1, "N", "N"); 
     	 	  			
     	  				Enable = false;
     	  				MultiSelect = false;
     	  				Code2 = "N";
     	  			} 	  			
     	  			break; 
     	  		case "dcgo_sts_cd":   	  			 
     	  			with(comboObj) {
     	  				SetColWidth(62);
     	  				DropHeight = 19*6;
     	  				
     	  				InsertItem(0, "", 		"");
     	 	  			InsertItem(1, "GAS", 	"G"); 
     	 	  			InsertItem(2, "PASTE",  "P"); 
     	 	  			InsertItem(3, "LIQUID", "L"); 
     	 	  			InsertItem(4, "SOLID",  "S");
     	 	  			
     	  				Enable = false;
     	  				MultiSelect = false;
     	  				Index = "";
     	  				Code2 = "";
     	  			} 	  			
     	  			break; 
     	  	}
        }
       
     /**
      * sheet1 초기 디자인 세팅
      */
     	function initSheet1(sheetObj) {
     		for ( var i=1; i<=sheetObj.rowCount; i++ ) {
     			if ( i==1 ) {
     				sheetObj.CellValue2(i,"div_nm") =  "Limited Q'TY";
     				sheetObj.CellValue2(i,"max_wgt_nm") =  "Max Weight";
     				sheetObj.CellValue2(i,"pkg_tp_nm") =  "PKG Type";
     			}
     			if ( i==2 ) {
     				sheetObj.CellValue2(i,"div_nm") =  "Execpted Q'TY";
     				sheetObj.CellValue2(i,"max_wgt_nm") =  "Max Weight";
     				sheetObj.CellValue2(i,"pkg_tp_nm") =  "PKG Type";
     			}
     			if ( i==3 ) {
     				sheetObj.CellValue2(i,"div_nm") =  "Packing Instruction";
     				sheetObj.CellValue2(i,"max_wgt_nm") =  "Max Weight";
     				sheetObj.CellValue2(i,"pkg_tp_nm") =  "PKG Type";
     			}
     			if ( i==4 ) {
     				sheetObj.CellValue2(i,"div_nm") =  "Special Pack. Inst.";
     				sheetObj.CellValue2(i,"max_wgt_nm") =  "Max Weight";
     				sheetObj.CellValue2(i,"pkg_tp_nm") =  "PKG Type";
     			}
     			if ( i==5 ) {
     				sheetObj.CellValue2(i,"div_nm") =  "Others";
     				sheetObj.CellValue2(i,"max_wgt_nm") =  "Max Weight";
     				sheetObj.CellValue2(i,"pkg_tp_nm") =  "PKG Type";
     				sheetObj.SetMergeCell (i, 2, 1, 5);
     			}
     	   		sheetObj.RowMerge(i) = true;
     	   		sheetObj.RowHeight(i) = 20;
     	   		
  	   	   	setLeftFontColor(sheetObj);
     	   	}
     	}
          
      /**
       * left폰트 변경
       */
  	function setLeftFontColor(sheetObj) {
  		for ( var i=1; i<=sheetObj.rowCount; i++ ) {
  		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
  		   		if ( j ==1 || j ==3  || j ==5) {
  		   			sheetObj.CellAlign(i,j) = daCenter;
  				   	sheetObj.CellFont("FontBold", i,j) = true;
  				   	sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#F6FAFB");
  		   		}
  		   		if(sheetObj.CellValue(i,j) == "Invalid"){
  		   			sheetObj.CellFontColor(i,j) = sheetObj.RgbColor(255, 0, 0);
  		   			sheetObj.CellFont("FontBold", i,j) = true;
  		   		}
  		   		sheetObj.CellEditable(i,j) = false;
  		   	}
  		}
  	}
       
       function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
       {
      	 setLeftFontColor(sheetObj);
       }
  	
      /**
       * sheet1 배경색 변경
       */
  	function chgBackColor(sheetObj) {
  	   	for ( var i=1; i<=sheetObj.rowCount; i++ ) {
  	   		sheetObj.RowStatus(i) = "R";
  	   		sheetObj.CellEditable(i,"g_total") = false;
  	   		sheetObj.CellEditable(i,"d_total") = false;
  	   		sheetObj.CellEditable(i,"s_total") = false;
  	   	
  		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
  		   		if ( i != 14  || i !=25 || i !=36 ) {
  			   		if ( j !=0 ) {
  				   		if ( i>=3 && i <=7 || i>=16 && i <=19 || i>=27 && i <=30 || i>=38 && i <=41 ) {
  				   			sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#F6FAFB");
  				   		} else if  ( i>=8 && i <=12 || i>=20 && i <=23 || i>=31 && i <=34 || i>=42 && i <=45 ) { 
  				   			sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#FFEAEA");
  				   		} else if  ( i==13 || i==24  || i==35  || i==46 ) { 
  				   			sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#D0EC7F");
  				   		} else {
  				   			sheetObj.CellBackColor(i,j) = sheetObj.RgbColor(255,255,255);
  				   		}
  			   		} else {
  			   			sheetObj.CellFontColor(i,"yyyy_ww") = sheetObj.RgbColor(0,0,1);
  			   			sheetObj.CellBackColor(i,"yyyy_ww") = sheetObj.RgbColor(255,255,255);
  			   		}
  		   		} else {
  		   			sheetObj.RowBackColor(i) = sheetObj.HeadBackColor;
  		   		}
  		   	}
  		   	
     			sheetObj.CellBackColor(14,"g_total") = sheetObj.HeadBackColor;
     			sheetObj.CellBackColor(14,"yyyy_ww") = sheetObj.HeadBackColor;
     			sheetObj.CellBackColor(14,"title") = sheetObj.HeadBackColor;
     			sheetObj.CellBackColor(14,"item") = sheetObj.HeadBackColor;
  		   	sheetObj.RowBackColor(14) = sheetObj.HeadBackColor;
  		   	
     			sheetObj.CellBackColor(25,"yyyy_ww") = sheetObj.HeadBackColor;
     			sheetObj.CellBackColor(25,"title") = sheetObj.HeadBackColor;
     			sheetObj.CellBackColor(25,"item") = sheetObj.HeadBackColor;
     			sheetObj.CellBackColor(25,"g_total") = sheetObj.HeadBackColor;
  		   	sheetObj.RowBackColor(25) = sheetObj.HeadBackColor;
  		   	
     			sheetObj.CellBackColor(36,"yyyy_ww") = sheetObj.HeadBackColor;
     			sheetObj.CellBackColor(36,"title") = sheetObj.HeadBackColor;
     			sheetObj.CellBackColor(36,"item") = sheetObj.HeadBackColor;
     			sheetObj.CellBackColor(36,"g_total") = sheetObj.HeadBackColor;
  		   	sheetObj.RowBackColor(36) = sheetObj.HeadBackColor;		   	
  	   	}
  	}
       
   function sheet1_OnDblClick(sheetObj, Row, Col, Val){
  	 with(sheetObj){
  		 var formObj = document.form;
  		 var saveNm = ColSaveName(Col);
  		 if(saveNm == "mdt_flg"){
  			if(ComGetObjValue(formObj.tabSelectedIdx) != 1){
  				tabObjects[0].selectedIndex = 1;
  			}
  		 }else if(saveNm == "seg_flg"){
  			if(ComGetObjValue(formObj.tabSelectedIdx) != 0){
  				tabObjects[0].selectedIndex = 0;
  			}
  		 }else if(saveNm == "port_flg" || saveNm == "crr_flg"){
  			if(ComGetObjValue(formObj.tabSelectedIdx) != 0){
  				tabObjects[0].selectedIndex = 0;
  			}
  		 }else{
  			if(ComGetObjValue(formObj.tabSelectedIdx) != 2){
  				tabObjects[0].selectedIndex = 2;
  			}else{
  				ComSetObjValue(formObj.imdg_un_no, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_un_no"));
  	   			ComSetObjValue(formObj.imdg_un_no_seq, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_un_no_seq"));
  	   			ComSetObjValue(formObj.prp_shp_nm, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "prp_shp_nm"));
  	   			ComSetObjValue(formObj.imdg_clss_cd, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_clss_cd"));
//  	   		ComSetObjValue(formObj.imdg_clss_cd_desc, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_clss_cd_desc"));
  	   			ComSetObjValue(formObj.imdg_pck_grp_cd, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_pck_grp_cd"));
  	   			ComSetObjValue(formObj.dcgo_sts_cd, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "dcgo_sts_cd"));
  	   			ComSetObjValue(formObj.imdg_lmt_qty_flg, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_lmt_qty_flg"));
  	   			ComSetObjValue(formObj.imdg_expt_qty_flg, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_expt_qty_flg"));
  	   			ComSetObjValue(formObj.grs_wgt, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grs_wgt"));
  	   			ComSetObjValue(formObj.net_wgt, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "net_wgt"));
  	   			ComSetObjValue(formObj.ttl_capa, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ttl_capa"));
  	   			ComSetObjValue(formObj.out_imdg_pck_qty1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "out_n1st_imdg_pck_qty"));
  	   			ComSetObjValue(formObj.out_imdg_pck_cd1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "out_n1st_imdg_pck_cd"));
  	   			ComSetObjValue(formObj.out_imdg_pck_desc1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "out_n1st_imdg_pck_desc"));
  	   			ComSetObjValue(formObj.intmd_imdg_pck_qty1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "intmd_n1st_imdg_pck_qty"));
  	   			ComSetObjValue(formObj.intmd_imdg_pck_cd1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "intmd_n1st_imdg_pck_cd"));
  	   			ComSetObjValue(formObj.intmd_imdg_pck_desc1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "intmd_n1st_imdg_pck_desc"));
  	   			ComSetObjValue(formObj.in_imdg_pck_qty1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "in_n1st_imdg_pck_qty"));
  	   			ComSetObjValue(formObj.in_imdg_pck_cd1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "in_n1st_imdg_pck_cd"));
  	   			ComSetObjValue(formObj.in_imdg_pck_desc1, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "in_n1st_imdg_pck_desc"));
  	   			calWgt();
  				doActionIBSheet(sheetObjects[4],document.form,IBSEARCH);
  			}
  		 }
  	 }
   }
   
   function sheet1_OnSearchEnd(sheetObj, ErrMsg)
   {
	   for ( var i=1; i<sheetObj.rowCount+2; i++ ) {
 		   	for ( var j=0; j<sheet1HeadTitleCnt; j++ ) {
 		   		if(sheetObj.CellValue(i,j) == "X"){
 		   			sheetObj.CellFontColor(i,j) = sheetObj.RgbColor(255, 0, 0);
 		   			sheetObj.CellFont("FontBold", i,j) = true;
 		   		}
 		   		
 		   		if(sheetObj.CellValue(i,j) == "R"){
// 	 		   		if(sheetObj.CellValue(i,j) == "△"){
 		   			sheetObj.CellValue2(i,j)  = "△";
 		   			sheetObj.CellFontColor(i,j) = sheetObj.RgbColor(0, 0, 255);
 		   			sheetObj.CellFont("FontBold", i,j) = true;
 		   		}
 		   		
 		   		sheetObj.CellEditable(i,j) = false;
 		   	}
 		}
   }

   function t2sheet2_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {  	 
  	 with(sheetObj){
				 if(ColSaveName(Col) == "invld_desc"){
					var sUrl    = '/hanjin/VOP_SCG_0001.do';
					var iWidth  = 1070;
					var iHeight = 530;
					var sTargetObjList = "";
					var sDisplay = "0,1";
				   	var param = "?imdg_un_no="+document.form.imdg_un_no.value
				   				+"&imdg_un_no_seq="+document.form.imdg_un_no_seq.value
				   				+"&popflag=1";
					ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);
				 }
  	 }
   }  
   
   
   

	/* 개발자 작업  끝 */