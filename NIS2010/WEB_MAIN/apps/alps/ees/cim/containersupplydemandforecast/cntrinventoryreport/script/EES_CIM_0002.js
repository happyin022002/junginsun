/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0002.js
*@FileTitle : Total Inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.14 김종준
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cim_0002 : ees_cim_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cim_0002() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
   
    var head_cntr_tpsz_cd ="";
    var tot_cnmv_sts_cd ="";
    var tot_lstm_cd ="";
    var comboObjects = new Array();
    var comboCnt = 0 ;
   
    var IBSEARCH01  = 29;
    var IBSEARCH02  = 30;

   	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
   	document.onclick = processButtonClick;

   	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
   	function processButtonClick(){
	    var formObject = document.form;
		try {
	   		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
			case "btn_New":		//조회조건 초기화
				comboObjects[0].Code = "";
				comboObjects[1].Code = "";
				comboObjects[2].Code = "";
				formObject.reset();
				sheetObjects[0].Redraw = false;
				sheetObjects[0].RemoveAll();
				sheetObjects[0].Redraw = true;
				document.form.head_cntr_tpsz_cd.value =head_cntr_tpsz_cd;
				break;
			case "btn_DownExcel":	//DOWN EXCEL
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
			case "btn_Retrieve":	//조회
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_Print":		//Print
				if( sheetObjects[0].rowcount==0 ) {
					errMsg = 'No data found.';
					ComShowMessage(msgs["CGM10012"]);
					return;
				}
				formObject.f_cmd.value = IBSEARCH02;
				ComOpenPopupWithTarget('/hanjin/EES_CIM_0902.do', 775, 740, "", "0,1,1,1,1,1,1", true);
				break;
           } // end switch
   		} catch(e) {
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
     * 초기 이벤트 등록
     */
    function initControl() {
   		axon_event.addListener('keyup', 'cntr_no_onkeyUp', 'cntr_no', '');						//cntr_no keyup 이벤트 처리
   		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    
    /**
    * cntr_no keyup 이벤트 처리
    * cntr_no keyup시 대분자로 처리
    */
    function cntr_no_onkeyUp() {
	   var formObject = document.form;
	   formObject.cntr_no.value = formObject.cntr_no.value.toUpperCase();
    }
    
    /**
     * TP/SZ  클릭 이벤트 등록
     */
    function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    }
    
    /**
     * MVMT Status  클릭 이벤트 등록
     */
    function cnmv_sts_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    }    

    /**
     * Lease Term  클릭 이벤트 등록
     */
    function lstm_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    }       

    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage( cnmv_sts_cd, cnmv_sts_nm) {
	   
       for(i=0;i<sheetObjects.length;i++){

    	   //khlee-시작 환경 설정 함수 이름 변경
           ComConfigSheet (sheetObjects[i] );

           initSheet(sheetObjects[i],i+1);
           //khlee-마지막 환경 설정 함수 추가
           ComEndConfigSheet(sheetObjects[i]);
       }

       for(k=0;k<tabObjects.length;k++){
           initTab(tabObjects[k],k+1);
       }
       for(p=0;p< comboObjects.length;p++){
           initCombo (comboObjects[p],p+1);
       }

       makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
	   initControl();
	   
    }
    
    /**
     * Lease Term  콤보코드 가져오기
     */
    function makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm) {
	    //MVMT Status
    	var arr_cnmv_sts_cd = cnmv_sts_cd.split("|");
	    var arr_cnmv_sts_nm = cnmv_sts_nm.split("|");
	    tot_cnmv_sts_cd = arr_cnmv_sts_cd;
	    with (form.cnmv_sts_cd) {
	    	MultiSelect = true;
	        MultiSeparator = ",";
	   	 	DropHeight = 320;
	   	 	InsertItem(0 , 'ALL','');
	   	 	for ( var i=1; i<=arr_cnmv_sts_cd.length; i++) {
	   	 		InsertItem(i, arr_cnmv_sts_cd[i-1], arr_cnmv_sts_nm[i-1]);
	   	 	}
	    } 
    }
    
    /**
     * sheet1 로딩 완료시 이벤트 후출
     * TP/SZ,MVMT Status,Lease Term 데이타 가져오기
    */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); 	//TP/SZ,MVMT Status,Lease Term 데이타 가져오기
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	//조회
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
    * Tab 기본 설정
    * 탭의 항목을 설정한다.
    */
    function initCombo (comboObj, comboNo) {
	   
    }
   
    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo,headTitle) {

       var cnt = 0;

       switch(sheetNo) {
           case 1:      //t1sheet1 init
               with (sheetObj) {
                   // 높이 설정
                   style.height = 410;
                   //전체 너비 설정
                   //SheetWidth = mainTable.clientWidth;

                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                   Editable = false;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo(1, 1, 20, 100);
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(false, true, true, true, false,false)

                   if (headTitle==null || headTitle =="") {
                	   headTitle = "Division|Lease Term|Total|D2|D4|D5|D7|R2|R4|R5|R7|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4|T2|T4";
                	   InitColumnInfo(24, 0, 0, true);
                   }
                   var headCnt  = headTitle.split("|").length;
                   SheetWidth = (headCnt)*40+55;
                   if ( SheetWidth>975 ) {
                	   SheetWidth = 975;
                   }
                   InitColumnInfo(headCnt, 0, 0, true);
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, headTitle, true);
                   sheetObj.FrozenCols = 3;

                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtAutoSum,    75,    daCenterTop,	true,		"division",		false,  "",      dfNone,			0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,      100,    daCenterTop,	true,		"lease_term",	false,  "",      dfNone,			0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,    	 60,    daRight,		true,		"total_cnt",	false,  "",      dfNullInteger,		0,     true,       true);
                   for(var i=1 ; i <= headCnt - 3 ; i++){
                	   InitDataProperty(0, cnt++ , dtData,   60,    daRight,		true,		"qty"+i,		false,  "",      dfNullInteger,		0,     true,       true);
                   }
                   CountPosition = 0;	//페이지카운트 없애기
              }
              break;

       }
    }
   
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg = false;
       switch(sAction) {
         case IBSEARCH:      //조회
        	if(!validateForm(sheetObj,formObj,sAction)) return;
        	sheetObj.WaitImageVisible=false;

        	ComOpenWait(true);         	
  	        sheetObj.Redraw = false;
  	        formObj.f_cmd.value = SEARCH;
	        sheetObj.DoSearch("EES_CIM_0002GS.do",FormQueryString(formObj));
	        ComOpenWait(false); 
            break;
         case IBSEARCH01:      //공통조회
        	 sheetObjects[0].WaitImageVisible = false;
             form.f_cmd.value = SEARCH01;
             var sXml = sheetObj.GetSearchXml("EES_CIM_0002GS.do" , FormQueryString(form));
             
             //TP/SZ 조회
             var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");	   
             
             head_cntr_tpsz_cd = cntr_tpsz_cd;
             document.form.head_cntr_tpsz_cd.value =head_cntr_tpsz_cd; 
             var strCntrTpszCd  = cntr_tpsz_cd.split("|");
             
	         with (form.cntr_tpsz_cd) {
	        	 MultiSelect = true;
	             MultiSeparator = ",";
	             DropHeight = 330;
	        	 InsertItem(0 , 'ALL','');
	        	 for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
  		        	 InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
	        	 }
	         }                     
             var HeadTitle = "Division|Lease Term|Total|"+head_cntr_tpsz_cd;
             
             sheetObj.Redraw = false;
             sheetObj.RemoveAll();
             sheetObj.Reset();
             initSheet(sheetObj,1,HeadTitle);
             sheetObj.Redraw = true;                    
             
             //Lease Term
             var sLeaseTermNm = ComGetEtcData(sXml,"lease_term_nm");
             var sLeaseTermCd = ComGetEtcData(sXml,"lease_term_cd");
	            
             var arrLeaseTermNm = sLeaseTermNm.split("|");
             var arrLeaseTermCd = sLeaseTermCd.split("|");
             tot_lstm_cd = arrLeaseTermCd;
	            
	         with (form.lstm_cd) {
	        	 MultiSelect = true;
	             MultiSeparator = ",";
	             DropHeight = 320;
	        	 InsertItem(0 , 'ALL','');
	        	 for ( var i=1; i<=arrLeaseTermCd.length; i++) {
  		        	 InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
	        	 }
	         }                     
        	 break;
	      case IBDOWNEXCEL:      // 입력
	    	  sheetObj.Down2Excel(-1, false, false, true);
 	         break;
       }
    }

   	/**
    * sheet1 조회종료
    * sheet1 조회종료후 이벤트 호출
    */
   	function sheet1_OnSearchEnd(sheetObj, msg){
	   	for(var i=1; i<=sheetObj.LastRow; i++){
		   	if(sheetObj.CellValue(i,1) == ''){
			   	if(sheetObj.CellValue(i,0) == 'Total'){
				   	sheetObj.CellValue(i,1) = 'G.Total';
				   	sheetObj.CellValue(i,0) = 'Total';
			   	} else {
				   	sheetObj.CellValue(i,1) = 'Total';
				   	sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
			   	}
		   	}
	   	}  
	   	if ( sheetObj.rowCount != 0 ) {
		   	HeadTitleCnt = head_cntr_tpsz_cd.split("|").length+3
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
				sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
			}
	    	sheetObj.CellAlign(sheetObj.LastRow,"division") = daCenter;
	    	sheetObj.CellAlign(sheetObj.LastRow,"lease_term") = daCenter;
	    	sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
		   	sheetObj.RowHidden(sheetObj.LastRow-1) = true;
		   	sheetObj.CellValue(sheetObj.LastRow-1,0) = 'G.Total';
		   	sheetObj.CellValue(sheetObj.LastRow-1,1) = 'G.Total';
		   	sheetObj.CellValue(sheetObj.LastRow,0) = 'G.Total';
		   	sheetObj.CellValue(sheetObj.LastRow,1) = 'G.Total';
		   	sheetObj.SetMergeCell (sheetObj.LastRow, 0, 0, 2);
	   	}
	   	
	   	document.form.prt_cntr_tpsz_cd.value = comboObjects[0].Code; 
	   	document.form.prt_full_flg.value = document.form.full_flg.value;

	   	if ( document.form.cntr_hngr_rck_cd.checked ) {
		   	document.form.prt_cntr_hngr_rck_cd.value = "Y"; 
	   	} else {
		   	document.form.prt_cntr_hngr_rck_cd.value = ""; 
	   	}

	   	
	   	if ( document.form.disp_flg.checked ) {
		   	document.form.prt_disp_flg.value = "Y"; 
	   	} else {
		   	document.form.prt_disp_flg.value = ""; 
	   	}
	   	if ( document.form.d2_payld_flg.checked ) {
		   	document.form.prt_d2_payld_flg.value = "Y"; 
	   	} else {
		   	document.form.prt_d2_payld_flg.value = ""; 
	   	}
	   	document.form.prt_cnmv_sts_cd.value = comboObjects[1].Code; 
	   	document.form.prt_dmg_flg.value = document.form.dmg_flg.value; 
	   	document.form.prt_cntr_no.value = document.form.cntr_no.value; 
	   	document.form.prt_cntr_use_co_cd.value = document.form.tem_cntr_use_co_cd.value; 
	   	document.form.prt_lstm_cd.value = comboObjects[2].Code; 
	   	document.form.prt_soc_cd.value = document.form.soc_cd.value; 
	   	sheetObj.SelectHighLight = false;
	   	sheetObj.Redraw = true;
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
    * Tab 기본 설정
    * 탭의 항목을 설정한다.
    */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
               with (tabObj) {
                   var cnt  = 0 ;
                   InsertTab( cnt++ , "Inventory" , -1 );
                   InsertTab( cnt++ , "Long Staying" , -1 );
                   InsertTab( cnt++ , "Match Back" , -1 );
                   InsertTab( cnt++ , "Turn Time" , -1 );
               }
            break;
        }
    }

    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
       with(formObj){
    	   if (!ComChkValid(formObj)) return false;
       }
       return true;
    }
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }	