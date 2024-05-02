/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_AGT_0040.js
*@FileTitle : Commission Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.20 추경원
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
     * @class ESM_AGT_0040 : ESM_AGT_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_AGT_0040() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		 var sheetObject = sheetObjects[0];

    		 /*******************************************************/
    		 var formObject = document.form;

//    		try {
    			var srcName = window.event.srcElement.getAttribute("name");

    			switch(srcName) {

    				case "btn_retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;

    				case "btns_calendar1":
        				var cal = new ComCalendar();
          				 cal.select(formObject.search_dt_fr, 'yyyy-MM-dd');
    					break;

    				case "btns_calendar2":
        				var cal = new ComCalendar();
         				 cal.select(formObject.search_dt_to, 'yyyy-MM-dd');
    					break;

    			} // end switch
//    		}catch(e) {
//    			if( e == "[object Error]") {
//    				ComShowMessage(ComGetMsg("COM12111", "", "", ""));
//    			} else {
//    				ComShowMessage(e);
//    			}
//    		}
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
    	function loadPage(header, col_nm) {
        	for(i=0;i<sheetObjects.length;i++){
        	    //khlee-시작 환경 설정 함수 이름 변경
        		ComConfigSheet(sheetObjects[i]);

        		initSheet(sheetObjects[i], i+1, header, col_nm);
        	    
        	    //khlee-마지막 환경 설정 함수 추가
        		ComEndConfigSheet(sheetObjects[i]);
        	}
    	}

       /**
    	 * 시트 초기설정값, 헤더 정의
    	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	 */
    	function initSheet(sheetObj, sheetNo, HeadTitle, col_nm) {

    		var cnt = 0;
    		var cols = 0;
            var aryColNm = new Array();

            if( col_nm.length > 0 ) {
                aryColNm = col_nm.split("|");
            }

            cols = aryColNm.length;

            if( cols > 0) {
        		switch(sheetNo) {
        			case 1:      //sheet1 init
        				with (sheetObj) {
        					// 높이 설정
        					style.height = 315;
        					//전체 너비 설정
        					SheetWidth = mainTable.clientWidth;
        
        					//Host정보 설정[필수][HostIp, Port, PagePath]
        					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        
        					//전체Merge 종류 [선택, Default msNone]
        					MergeSheet = msHeaderOnly;
        
        				   //전체Edit 허용 여부 [선택, Default false]
        					Editable = false;
        
        					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        					InitRowInfo( 1, 1, 9, 1000);
        
        					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        					//InitColumnInfo(35, 3 , 0, true);
        					InitColumnInfo(cols, 0 , 0, true);
        
        					// 해더에서 처리할 수 있는 각종 기능을 설정한다
        					InitHeadMode(true, true, true, true, false,false) ;
        
        					//var HeadTitle = "B/L No.|BKG No.|BND|VVD|S/A date|POR|POL|POD|DEL|TEU/FEU|FAC|CommⅠ|Comm Ⅱ|Brokerage|CHF|T/S|T/R|SOC|Cross|DOC|Deduction|USD AMT|Ex.Rate|Curr|LCL AMT|Calc Date|RQST Date|Approval Date|I/F Date|PRD OFT|CCT OFT|PPD Charge|CCT Charge|Net AMT|Gross AMT|F.Forwarder|F.F NAME|F.F ADDR";
        
        					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        					InitHeadRow(0, HeadTitle, true);
        
        					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        					for(var i=0; i<cols; i++) {
        					    InitDataProperty(0, cnt++ , dtData,       85,    daCenter,   false,    aryColNm[i],     false,          "",       dfNone,          0,     false,       false);
        					}
        					CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
        				}
        				break;
        		}
    		}
    	}

        /**
         * Sheet관련 프로세스 처리
         */
        function doActionIBSheet(sheetObj, formObj, sAction, a, PageNo) {
        
//            sheetObj.ShowDebugMsg = false;
        	 var TotalPageNo = 0;
            
            switch(sAction) {
                
                case IBSEARCH:		//조회      
        			if(!validateForm(sheetObj, formObj, sAction)) {
        			    return false;
        			}
	                if(formObj.bl.value.trim().length > 0){
			    		setBlNoRetrieve(formObj.bl);
			    	}
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch4Post("ESM_AGT_0040GS.do", agtQryStr(formObj), "iPage=" + "1"+"&pagerows=0&pagerowsper=1000");
                    sheetObj.TotalRows = sheetObj.EtcData("pagerowstot");
                    TotalPageNo = ComParseInt(sheetObj.EtcData("pagerowstot")/1000)+1;
                    for(var i=2 ;i <= TotalPageNo;i++){
                    	formObj.ingPage.value = ""+i+" / "+TotalPageNo;
                    	formObj.pagerows.value = i ;
                    	doActionIBSheet(sheetObj, formObj, IBSEARCHAPPEND, true, i);
                    	if(i==TotalPageNo)
                    		formObj.ingPage.value='';
                    		formObj.pagerows.value='1';
                    }
                    
                    break;
                case IBSEARCHAPPEND:
                   formObj.f_cmd.value = SEARCH;
                   sheetObj.DoSearch4Post("ESM_AGT_0040GS.do", agtQryStr(formObj), "iPage=" + PageNo+"&pagerows=" + PageNo+"&pagerowsper=1000", true);
                   sheetObj.TotalRows = sheetObj.EtcData("pagerowstot");
                   break;

                case IBRESET:        //Header 정보를 조회한다.
                	
                    formObj.f_cmd.value = SEARCH01;
                    //sheetObj.DoSearch4Post("ESM_AGT_0040GS.do", agtQryStr(formObj));
                    var x = sheetObj.GetSearchXml("ESM_AGT_0040GS.do", agtQryStr(formObj));    
    				//sheetObj.LoadSearchXml(x);
                    sheetObj.LoadSearchXml4Sax(x);
                    formObj.header.value = sheetObj.EtcData("header");
                    formObj.col_nm.value = sheetObj.EtcData("colNm");
                    
                    sheetObj.RemoveEtcData();

                    // Header 정보를 변경하기 위해 sheet를 초기화 한다.
                    //--------------------------------------------------
                    // Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
                    sheetObj.Redraw = false;
                    sheetObj.RemoveAll();
                    sheetObj.Reset();
                    
                    initSheet(sheetObj, 1, formObj.header.value, formObj.col_nm.value);
                    sheetObj.Redraw = true;
                    //--------------------------------------------------
                    break;
        
                case IBDOWNEXCEL:        //엑셀 다운로드
                    sheetObj.SpeedDown2Excel(-1);
                    break;

            }
        }

       /**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj, formObj, sAction){

    		with(formObj){
    		    
                bkg_ofc_cd.value = bkg_ofc_cd.value.trim().toUpperCase();            		    
                ob_sls_ofc_cd.value = ob_sls_ofc_cd.value.trim().toUpperCase();		    
                comm_vvd.value = comm_vvd.value.trim().toUpperCase();
                por_cd.value = por_cd.value.trim().toUpperCase();
                pol_cd.value = pol_cd.value.trim().toUpperCase();
                pod_cd.value = pod_cd.value.trim().toUpperCase();
                del_cd.value = del_cd.value.trim().toUpperCase();

                var arOfcCd = ar_ofc_cd.value;
                //var sbOfcCd = agn_cd.value;
                var fdate = search_dt_fr.value.replace(/\/|\-|\./g,"");
                var tdate = search_dt_to.value.replace(/\/|\-|\./g,"");

                if( arOfcCd == "" ) {
                    ComShowMessage(ComGetMsg("COM12113", "Office", "", ""));
                    ar_ofc_cd.focus();
                    return false;
                }
                /*
                if( sbOfcCd == "" ) {
                    ComShowMessage(ComGetMsg("COM12113", "Subject Office", "", ""));
                    agn_cd.focus();
                    return false;
                }
                */
                if(fdate == "") {
                    ComShowMessage(ComGetMsg('AGT10009'));
                    search_dt_fr.select();
                    return false;
                }
                if(tdate == "") {
                    ComShowMessage(ComGetMsg('AGT10009'));
                    search_dt_to.select();
                    return false;
                }
            }
    		return true;
    	}

       /**
    	 * Customized RPT Form을 Pop up으로 띄워준다.
    	 */
    	function openCustRPTForm(){
    		var url = "ESM_AGT_0041.do";
    		var width = 608;
    		var height = 470;
    		var func = "retrieve";
    		var display = "none";
    		ComOpenPopup(url, width, height, func, display, true, false);
    	}

    	/**
    	 * Office 조회 팝업 열기
    	 */	
    	function openWindowOffice(formObj, gubun) {
    		var url = "COM_ENS_071.do";
    		var width = 775;
    		var height = 460;
    		var func = "";
    		
    		var display = '1,0,1,1,1,1,1,1';
    		if(gubun == "BKG") {
    		    func = "setBKGOffice";
    		} else if(gubun == "SLS") {
    		    func = "setSLSOffice";
    		}
    				
    		ComOpenPopup(url, width, height, func, display, true, false);
    	}
    	
    	/**
    	 * POR 조회 팝업 열기
    	 */	
    	function openWindowLocation(formObj, gubun) {
    	    
    		var url = "COM_ENS_051.do";
    		var width = 775;
    		var height = 484;
    		var func = "";
    		var display = '1,0,1,1,1,1,1,1';
    		
    		if(gubun == "POR") {
    		    func = "setPOR";
    		} else if(gubun == "POL") {
    		    func = "setPOL";
    		} else if(gubun == "POD") {
    		    func = "setPOD";		    		    
    		} else if(gubun == "DEL") {
    		    func = "setDEL";
    		}

    		ComOpenPopup(url, width, height, func, display, true, false);
    	}
    	
    	/**
    	 * Booking Office 조회 후 값 Return 받아 셋팅한다.
    	 */
    	function setBKGOffice(rowArray, row, col) {
    		var colArray = rowArray[0];

    		document.form.bkg_ofc_cd.value = colArray[3].trim();
    	}

    	/**
    	 * Sales Office 조회 후 값 Return 받아 셋팅한다.
    	 */
    	function setSLSOffice(rowArray, row, col) {
    		var colArray = rowArray[0];

    		document.form.ob_sls_ofc_cd.value = colArray[3].trim();
    	}
    	
    	/**
    	 * POR 조회 후 값 Return 받아 셋팅한다.
    	 */
    	function setPOR(rowArray, row, col) {
    		var colArray = rowArray[0];
    		
    		document.form.por_cd.value = colArray[3]; 
    	}
    	
    	/**
    	 * POL 조회 후 값 Return 받아 셋팅한다.
    	 */
    	function setPOL(rowArray, row, col) {
    		var colArray = rowArray[0];
    		
    		document.form.pol_cd.value = colArray[3]; 
    	}
    	
    	/**
    	 * POD 조회 후 값 Return 받아 셋팅한다.
    	 */
    	function setPOD(rowArray, row, col) {
    		var colArray = rowArray[0];
    		
    		document.form.pod_cd.value = colArray[3];
    	}
    	
    	/**
    	 * DEL 조회 후 값 Return 받아 셋팅한다.
    	 */
    	function setDEL(rowArray, row, col) {
    		var colArray = rowArray[0];
    		
    		document.form.del_cd.value = colArray[3]; 
    	}
    	
        /**
         * Group combo 변경시 sheet의 Header정보를 변경시킨다.
         */
        function cboRptGroup_OnChange(){
            var sheetObj = sheetObjects[0];
            var formObj = document.form;

            formObj.slct_itm_fom_seq.value = formObj.cboRptGroup.value;
            doActionIBSheet(sheetObj,formObj,IBRESET);
            
        }
        
        /**
         * IBSheet 재 셋팅한다.
         */
        function reSetHeader(col_desc, col_nm){
        	 
            var formObj = document.form;
            
            formObj.header.value = col_desc;
            formObj.col_nm.value = col_nm.toLowerCase();

            initSheet(sheetObjects[0], 1, col_desc, col_nm.toLowerCase());
            
            formObj.cboRptGroup.selectedIndex = 0;
            
            return false; // OnChange  이벤트 발생하지 않도록 한다.
        }
        
        /**
         * Group combo 데이타를 재조회한다.
         */
        function reSetRptGroup(){
            var sheetObj = sheetObjects[0];
            var formObj = document.form;

            formObj.f_cmd.value = "";
            formObj.param1.value = "div_rptGroup"; // divId
            formObj.param2.value = "cboRptGroup";  // cboNm
            //formObj.param3.value = formObj.cboRptGroup.value;    // defaultValue
            formObj.param3.value = "";    // defaultValue
            formObj.param4.value = " onChange='cboRptGroup_OnChange();' style='width:120'";   // addProperties
            formObj.param5.value = "rptGroup";     // workName
            formObj.param6.value = formObj.cre_usr_id.value; // param(cre_usr_id)
            formObj.param7.value = " ";  // allYN
            formObj.param8.value = "";   // addOption

            formObj.target = "frmHidden";
            formObj.action = "ESM_AGT_0040FR.do";
            formObj.submit();
        }
        
        /**
         * Group Value를 셋팅한다.
         */
        function reSetRptGroup2(seq){
            document.form.cboRptGroup.value = seq;
            document.form.slct_itm_fom_seq.value = seq;
        }
        /**
         * A/R Office를 변경하면, 해당 Subject Office를 다시 조회한다.
         */
        function ar_ofc_cd_OnChange(obj){
            var formObj = document.form;
            
            formObj.param1.value = "sbOfcCd";
            formObj.param2.value = "&lt;&lt;select&gt;&gt;";
            formObj.param3.value = "agn_cd";
            formObj.param4.value = obj.value;
//            formObj.slct_itm_fom_seq.value = obj.value;
            formObj.target = "frmHidden";
            formObj.action = "ESM_AGT_0040FR2.do";
            formObj.submit();
        }
        
        /**
         * 사용자가 입력한 BL NO를 셋팅한다.
         */
        function setBlNo(obj) {
            var form = document.form;
            var bl_no = obj.value.trim().toUpperCase();
            var bl_no_list = form.bl_no.value.trim().toUpperCase();
            
            if (window.event.keyCode==13) {
                if(bl_no.length > 0) {
        
                    if(bl_no_list.length > 0) {
                        form.bl_no.value = bl_no_list + "," + bl_no;
                    } else {
                        form.bl_no.value = bl_no;
                    }
        
                    obj.value = "";
                }
            }
        }
         /*
         function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
        	 alert(PageNo);
             document.form.pagerows.value=PageNo;
             doActionIBSheet(sheet, document.form, IBSEARCHAPPEND, true, PageNo);
          }
          */
      // ifram을 이용하여 R.Lane 표시
     function cobTradeOnChange(obj) {
     	var formObj = document.form;
     	formObj.param1.value = "div_rLane"; // divId
     	formObj.param2.value = "s_rlane_cd";
     	formObj.param3.value = ""
     	formObj.param4.value = " style='width:80;'"
     	formObj.param5.value = "rLane";
     	formObj.param6.value = obj.value;
     	formObj.param7.value = "All";
     	formObj.param8.value = "";
     	formObj.target = "frmHidden";
     	formObj.action = "ESM_AGT_COMBO.do";
     	formObj.submit();
     }
      function setBlNos(obj) {
    	     var form = document.form;
    	     form.bl_no.value = obj.value.trim().toUpperCase();
    	}
	/**
	 * 사용자가 Retrieve 클릭시 BL NO를 셋팅 후 조회.
	 */
	function setBlNoRetrieve(obj) {
	    var form = document.form;
	    var bl_no = obj.value.trim().toUpperCase();
	    var bl_no_list = form.bl_no.value.trim().toUpperCase();

	        if(bl_no_list.length > 0) {
	            form.bl_no.value = bl_no_list + "," + bl_no;
	        } else {
	            form.bl_no.value = bl_no;
	        }

	        obj.value = "";
	}
	/* 개발자 작업  끝 */