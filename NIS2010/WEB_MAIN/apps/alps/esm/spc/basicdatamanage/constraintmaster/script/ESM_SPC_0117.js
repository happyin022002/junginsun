/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESM_SPC_0117.js
*@FileTitle : Import Mastertable
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05 
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
* 1.0 Creation
* Trunk Type은 NYCRA에서만 사용하도록 변경
* 2015.07.06 [CHM-201536749]Mastertable Import기능 오류 수정 CR에 반영(Revenue Management System 추가 보완 개발 요청 선반영)   
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
     * @class ESM_SPC_0117 : ESM_SPC_0117 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0117() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.chgInitSheet = chgInitSheet;//reprot upload
    	this.initHeader = initHeader;//reprot upload	
    	this.chgHeader = chgHeader;//reprot upload	
    	this.chgGroup = chgGroup;	//reprot upload	
    }
    
   	/* 개발자 작업	*/
 // 공통전역변수
    var sheetObjects = new Array();
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var loadingMode = false; //report upload
    //BgColor 지정
    var dupDataColor = null;
    var errDataColor = null;
    var disableColor = null;
    var enableColor = null;
    
    var reportFormPopupCallCnt = 0;
    
    //전체 col갯수
    var delHeadCount = 0;
    var headCount = 0;
    //시트에 default row insert시 sheet1_OnSelectCell 타지 않도록 하기 위해 설정 
    var initCell4Type = false;
    
//	//T.LANE VALIDATION시 대상을 폼으로 볼지 시트로 볼지 결정하는 변수
//	var sheetFlag ="";
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
//    	var sheetObject2 = sheetObjects[1];
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
    		
    		
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;
    				
    			case "btn_save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;
    				
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    				break;
    					
    			case "btn_new":
    				//초기화
    				ComOpenWait(true);
    				formObject.f_selgroup.code = "";
    				formObject.f_add_cnt.value = "1";
    				sheetObject.removeAll();
    				addDefaultRow();
    				
    				doActionIBSheet(sheetObject,formObject,IBCLEAR);
    				sheetObject.SelectCell(2, "bkg_no", false);
    				ComOpenWait(false);
    				break;
    				
    			case "btng_rowadd":
    				ComOpenWait(true);
    				var icnt = 0;
    				var fvalue = ComTrim(formObject.f_add_cnt.value);
    				if(fvalue == '') icnt = 1;
    				else icnt = parseInt(fvalue);
    				//msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
    				if(icnt + parseInt(sheetObject.RowCount) > 1000) {
    					ComShowMessage(getMsg("SPC10994", "1000"));
    				} else {
        				for(var k=0; k < icnt; k++) {
            				var irow = sheetObject.DataInsert(-1);
            				sheetObject.CellValue2(irow, "ibflag") = 'R';
        				}
    				}
    				ComOpenWait(false);
    				break;  	
    				
    			case "btn_close":
    				window.close();
    				break;

    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    		      ComShowCodeMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
//    function loadPage() {
    function loadPage(title, col_nm) {//reprot upload

    	for(var i=0;i<sheetObjects.length;i++){
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet(sheetObjects[i]);
//    		initSheet(sheetObjects[i],i+1);
    		initSheet(sheetObjects[i], i+1, title, col_nm);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}

		//
        dupDataColor = sheetObjects[0].RgbColor(204, 255, 253);//blue
        errDataColor = sheetObjects[0].RgbColor(255, 255, 128);//yellow
        disableColor = sheetObjects[0].RgbColor(239, 240, 243);//grey
        enableColor = sheetObjects[0].RgbColor(255, 255, 255);//white
        
        sheetObjects[0].ReDraw=false;        
        addDefaultRow();
        sheetObjects[0].ReDraw=true;

        //report upload
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);        
    }
    
	/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
		comObjects[comboCnt++] = combo_obj;
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
//    function initSheet(sheetObj,sheetNo) {
    function initSheet(sheetObj, sheetNo, title, col_nm) {//reprot upload
    	var cnt = 0;
        var colCnt = 0;
        
//        var varCnt = 0;
        var colTotNum = 0;
        var aryTitle = new Array();
        var t1 = "";
        var colWidth = 0;
        var colWidth1 = 0;
        var formObj = document.form;
//        var colTmp = 0;
        
        if(title != ""){
            var tNM = title.split("|");
            var tCnt = tNM.length;
            for(var j=0; j<tCnt ; j++) {
                t1 = t1+ tNM[j];
                if(j != tCnt-1) t1 = t1 + "|";
            }
        }
        aryTitle = col_nm.split("|");        
		switch(sheetNo) {
		
			 case 1:      //sheet1 init
 				with (sheetObj) {
			        // 높이 설정
			        style.height = 420;
			        //전체 너비 설정
			        SheetWidth = mainTable.clientWidth;
			        		
			        //Host정보 설정[필수][HostIp, Port, PagePath]
			        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			        //전체Merge 종류 [선택, Default msNone]
			        MergeSheet = msHeaderOnly;
			
			       //전체Edit 허용 여부 [선택, Default false]
			        Editable = true;
			
			        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			        InitRowInfo(2, 1, 2, 100);
			
//			        InitHeadMode(true, true, false, true, false,false); //Master
 					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
 					InitHeadMode(true, false, true, true, false, false);
 								
			        var HeadTitle1 = "Del.|Sts|Seq|BKG#|BL#|RHQ|TYPE||Sub\nTrade||T.LANE||BD|Trunk|Trunk|Trunk|Trunk|POR/NODE|POR/NODE|POR/NODE|POR/NODE|POR/NODE|POR/NODE|POR/NODE|POR/NODE|POL/NODE|POL/NODE|POL/NODE|POL/NODE|POL/NODE|POL/NODE|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|POD/NODE|POD/NODE|POD/NODE|POD/NODE|POD/NODE|POD/NODE|DEL/NODE|DEL/NODE|DEL/NODE|DEL/NODE|DEL/NODE|DEL/NODE|DEL/NODE|DEL/NODE||US Mode||VVD||CNTR\nTYPE||DG/RD|DG/RD||L.OFC|L.OFC||S/C No.||RFA No.||Contract Customer|Contract Customer|Contract Customer|Contract Customer||Actual Customer|Actual Customer|Actual Customer|Actual Customer||BKG Shipper|BKG Shipper|BKG Shipper|BKG Shipper||Charge\nOFT||CMPB||ALLOCATION||%\nTHRESHOLD||Group COMMODITY|Group COMMODITY||COMMODITY|COMMODITY|SVC|Control\nType|REMARK|Apply WK|Apply WK|UseYN|Update User|Update Date|ALLOC_SEQ";
					var HeadTitle2 = "Del.|Sts|Seq|(BKG# or BL#)|BL#|RHQ|TYPE||Sub\nTrade||T.LANE||BD||POL||POD||Country||LOC||NODE||SCC||Country||LOC||NODE||T/S port||LANE||BD||POL\nCountry||POL||POL NODE\n(LOC+00)||POD\nCountry||POD||POD NODE\n(LOC+00)||Country||LOC||NODE||Country||LOC||NODE||SCC||US Mode||VVD||CNTR\nTYPE||DG|RD||Code|Name||S/C No.||RFA No.||Code|Code|Code|Name||Code|Code|Code|Name||Code|Code|Code|Name||Charge\nOFT||Amount\n(USD)||ALLOCATION||%\nTHRESHOLD||CODE|NAME||CODE|NAME|SVC|Control\nType|REMARK|From|To|UseYN|Update User|Update Date|ALLOC_SEQ";
					
					if(t1 != "") {
						colCnt = aryTitle.length;
						HeadTitle1 = HeadTitle1 +"|"+t1;
						HeadTitle2 = HeadTitle2 +"|"+t1;	
					}
					headCount = ComCountHeadTitle(HeadTitle2);
	                
					colWidth1 = 0;
 					formObj.f_savename.value = HeadTitle2;//report upload
					delHeadCount = headCount;
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
			
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			        InitHeadRow(0, HeadTitle1, true);
			        InitHeadRow(1, HeadTitle2, true);
			        FrozenCols = 7;
			                            
			        //데이터속성    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++, dtDelCheck,	40,	daCenter,	true,	"delt_flg");
 					InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	true,	"ibflag",     		false,	"",  dfNone,    	0,	false,	false);
			        InitDataProperty(0,	cnt++, dtSeq,		30,	daCenter,	true,	"seq",                  false, 	"",  dfNone,        0,	false,	true);
		
 					InitDataProperty(0, cnt++, dtData,		90,	daCenter,	true,	"bkg_no",  				false,	"",  dfNone,   		0,	true,	true);	//	
 					InitDataProperty(0, cnt++, dtData,		80,	daCenter,	true,	"bl_no",  				false,	"",  dfNone,   		0,	false,	false);	//	
		
			        InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"sls_rhq_cd",    	 	false,	"",  dfNone,		0,	false,	false,     5);	//추가
			        InitDataProperty(0, cnt++, dtCombo,		80,	daCenter,	true,	"bkg_aloc_tp_cd",    	false,	"",  dfNone,		0,	true,	false,     1);
		
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"sub_trd_yn",  			false,	"",  dfNone,   		0,	true,	false);	//	 					
			        InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"sub_trd_cd",    		false,	"",  dfNone,		0,	true,	false,     2);	//추가
							
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"trnk_slan_yn",  		false,	"",  dfNone,   		0,	true,	false);	//	 					
			        InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"trnk_slan_cd",    		false,	"",  dfNone,		0,	false,	false,     3);
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"trnk_dir_yn",  		false,	"",  dfNone,   		0,	true,	false);	//	 					
			        InitDataProperty(0, cnt++, dtData,		30,	daCenter,	true,	"trnk_dir_cd",      	false,	"",  dfNone,		0,	false,	false,     1);
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"trnk_pol_yn",  		false,	"",  dfNone,   		0,	true,	false);	//	 					
			        InitDataProperty(0, cnt++, dtPopup,		60,daCenter,	true,	"trunk_pol_cd",     	false,	"",  dfNone,		0,	false,	false,     100);
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"trnk_pod_yn",  		false,	"",  dfNone,   		0,	true,	false);	//	 					
			        InitDataProperty(0, cnt++, dtPopup,		60,daCenter,	true,	"trunk_pod_cd",     	false,	"",  dfNone,		0,	false,	false,     100);
							
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"bkg_por_cnt_yn",  		false,	"",  dfNone,   		0,	true,	false);	//	 					
			        InitDataProperty(0, cnt++, dtPopup,		55,	daCenter,	true,	"bkg_por_cnt_cd",    	false,	"",  dfNone,		0,	false,	false,     5);
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"por_yn",  				false,	"",  dfNone,   		0,	true,	false);	//	 					
			        InitDataProperty(0, cnt++, dtPopup,		55,	daCenter,	true,	"por_cd",      			false,	"",  dfNone,		0,	false,	false,     5);
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"por_nod_yn",  			false,	"",  dfNone,   		0,	true,	false);	//	
			        InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"por_nod_cd",      		false,	"",  dfNone,		0,	false,	false,     7);
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"bkg_por_scc_yn",  		false,	"",  dfNone,   		0,	true,	false);	//	
			        InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"bkg_por_scc_cd",   	false,	"",  dfNone,		0,	false,	false,     5);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"bkg_pol_cnt_yn",  		false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		55,	daCenter,	true,	"bkg_pol_cnt_cd",    	false,	"",  dfNone,		0,	false,	false,     5);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"pol_yn",  				false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		60,	daCenter,	true,	"pol_cd",      			false,	"",  dfNone,		0,	false,	false,     5);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"pol_nod_yn",  			false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"pol_nod_cd",      		false,	"",  dfNone,		0,	false,	false,     7);

			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"ts_nod_yn",  			false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		70,	daCenter,	true,	"ts_nod_cd",   			false,	"",  dfNone,		0,	false,	false,     7);
			        
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"n1st_ts_slan_yn",  	false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtData,		55,	daCenter,	true,	"n1st_ts_slan_cd",   	false,	"",  dfNone,		0,	false,	false,     3);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"n1st_ts_dir_yn",  		false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtData,		30,	daCenter,	true,	"n1st_ts_dir_cd",    	false,	"",  dfNone,		0,	false,	false,     1);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"n1st_ts_pol_cnt_yn",  	false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		60,	daCenter,	true,	"n1st_ts_pol_cnt_cd",	false,	"",  dfNone,		0,	false,	false,     2);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"n1st_ts_pol_yn",  		false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		60,daCenter,	true,	"n1st_ts_pol_cd",    	false,	"",  dfNone,		0,	false,	false,     5);

			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"ts_pol_nod_yn",  		false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		70,daCenter,	true,	"ts_pol_nod_cd",    	false,	"",  dfNone,		0,	false,	false,     7);
			        
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"n1st_ts_pod_cnt_yn",  	false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		60,	daCenter,	true,	"n1st_ts_pod_cnt_cd",	false,	"",  dfNone,		0,	false,	false,     2);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"n1st_ts_pod_yn",  		false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		60,daCenter,	true,	"n1st_ts_pod_cd",    	false,	"",  dfNone,		0,	false,	false,     5);
			        
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"ts_pod_nod_yn",  		false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		70,daCenter,	true,	"ts_pod_nod_cd",    	false,	"",  dfNone,		0,	false,	false,     7);
								
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"bkg_pod_cnt_yn",  		false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		55,	daCenter,	true,	"bkg_pod_cnt_cd",    	false,	"",  dfNone,		0,	false,	false,     5);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"pod_cd_yn",  			false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		60,	daCenter,	true,	"pod_cd",      			false,	"",  dfNone,		0,	false,	false,     5);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"pod_nod_yn",  			false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"pod_nod_cd",      		false,	"",  dfNone,		0,	false,	false,     7);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"bkg_del_cnt_yn",  		false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		55,	daCenter,	true,	"bkg_del_cnt_cd",    	false,	"",  dfNone,		0,	false,	false,     5);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"del_yn",  				false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtPopup,		60,	daCenter,	true,	"del_cd",      			false,	"",  dfNone,		0,	false,	false,     5);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"del_nod_yn",  			false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"del_nod_cd",      		false,	"",  dfNone,		0,	false,	false,     7);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"bkg_del_scc_yn",  		false,	"",  dfNone,   		0,	true,	false);	//			        
			        InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"bkg_del_scc_cd",    	false,	"",  dfNone,		0,	false,	false,     5);
			       
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"us_yn",  				false,	"",  dfNone,   		0,	true,	false);	//			        
                    InitDataProperty(0, cnt++, dtCombo,     90, daCenter,  	true,   "usa_bkg_mod_cd",    	false, "",  dfNone,     	0,  false, false);
							
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"vvd_yn",  				false,	"",  dfNone,   		0,	true,	false);	//			        
			        InitDataProperty(0, cnt++, dtData,		80,	daCenter,	true,	"vvd",      		    false,	"",  dfNone,		0,	false,	false,     9);

			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"cntr_tpsz_yn",  		false,	"",  dfNone,   		0,	true,	false);	//			        
			        InitDataProperty(0, cnt++, dtPopup,		60,	daCenter,	true,	"cntr_tpsz_cd",      	false,	"",  dfNone,		0,	false,	false,     3);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"dg_rd_yn",  			false,	"",  dfNone,   		0,	true,	false);	//			        
			        InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"dg_flg",      			false,	"",  dfNone,		0,	false,	false,     3);	//추가
			        InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"rd_flg",      			false,	"",  dfNone,		0,	false,	false,     3);	//추가
								
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"ob_sls_ofc_yn",  		false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtData,		55,	daCenter,	true,	"ob_sls_ofc_cd",     	false,	"",  dfNone,		0,	false,	false,     6);
 					InitDataProperty(0, cnt++, dtData,		90,	daLeft,		true,	"ob_sls_ofc_nm",  		false,	"",  dfNone,   		0,	false,	false);	//
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"sc_yn",  				false,	"",  dfNone,		0,	true,	false);	//	
			        InitDataProperty(0, cnt++, dtData,		80,	daCenter,	true,	"sc_no",      			false,	"",  dfNone,		0,	false,	false,     20);
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"rfa_yn",  				false,	"",  dfNone,		0,	false,	false);	//
			        InitDataProperty(0, cnt++, dtData,		80,	daCenter,	true,	"rfa_no",      			false,	"",  dfNone,		0,	false,	false,     20);
								
			        //ctrt_cust_cnt_cd, ctrt_cust_seq, ctrt_cust_lgl_eng_nm		
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"ctrt_yn",  			false,	"",  dfNone,   		0,	true,	false);	//	
			        InitDataProperty(0, cnt++, dtHidden,	60,	daCenter,	true,	"ctrt_cust_cnt_cd",  	false,	"",  dfNone,		0,	false,	false,     8);
 					InitDataProperty(0, cnt++, dtHidden,	60,	daCenter,	true,	"ctrt_cust_seq",  		false,	"",  dfNone,   		0,	false,	false);	//	
 					InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"ctrt_cust_code",  		false,	"",  dfNone,   		0,	false,	false);	//	
 					InitDataProperty(0, cnt++, dtData,		90,	daLeft,		true,	"ctrt_cust_lgl_eng_nm", false,	"",  dfNone,   		0,	false,	false);	//
								
 					//agmt_act_cnt_cd, agmt_act_cust_seq, agmt_cust_lgl_eng_nm		
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"agmt_yn",  			false,	"",  dfNone,   		0,	true,	false);	//	 					
 					InitDataProperty(0, cnt++, dtHidden,	60,	daCenter,	true,	"agmt_act_cnt_cd",  	false,	"",  dfNone,   		0,	false,	false);	//	
 					InitDataProperty(0, cnt++, dtHidden,	60,	daCenter,	true,	"agmt_act_cust_seq",  	false,	"",  dfNone,   		0,	false,	false);	//	
 					InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"agmt_act_cust_code",  	false,	"",  dfNone,   		0,	false,	false);	//
 					InitDataProperty(0, cnt++, dtData,		90,	daLeft,		true,	"agmt_cust_lgl_eng_nm",	false,	"",  dfNone,   		0,	false,	false);	//	
			
								
 					//shpr_cust_cnt_cd, shpr_cust_seq, shpr_cust_lgl_eng_nm		
 					InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"shpr_yn",  			false,	"",  dfNone,   		0,	true,	false);	//	 					
 					InitDataProperty(0, cnt++, dtHidden,	60,	daCenter,	true,	"shpr_cust_cnt_cd",  	false,	"",  dfNone,   		0,	false,	false);	//	
 					InitDataProperty(0, cnt++, dtHidden,	60,	daCenter,	true,	"shpr_cust_seq",  		false,	"",  dfNone,   		0,	false,	false);	//
 					InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"shpr_cust_code",		false,	"",  dfNone,   		0,	false,	false);	//
 					InitDataProperty(0, cnt++, dtData,		90,	daLeft,		true,	"shpr_cust_lgl_eng_nm", false,	"",  dfNone,   		0,	false,	false);	//	
//			     	InitDataProperty(0, cnt++, dtData,		90,	daCenter,	true,	"cust_cnt_cd",			false,	"",  dfNone,		0,	true,	true,     8);//추가 
								
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"oft_chg_yn",  			false,	"",  dfNone,   		0,	true,	false);	//			        
			        InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"oft_chg_amt",      	false,	"",  dfNone,		0,	true,	false,     8);
								
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"cmpb_yn",  			false,	"",  dfNone,		0,	true,	false);	//			        
//			        InitDataProperty(0, cnt++, dtCombo,		50,	daCenter,	true,	"cmpb_rule_cd",      	false,	"",  dfNone,     	0,	true,	false,     8);
			        InitDataProperty(0, cnt++, dtData,		60,	daRight, 	true,	"cmpb_amt",  			false,	"",  dfNullFloat,	2,	true,	false,     6);//추가
								
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"aloc_lod_yn",  		false,	"",  dfNone,   		0,	true,	false);	//			        
			        InitDataProperty(0, cnt++, dtData,		80,	daRight, 	true,	"aloc_lod_qty",      	false,	"",  dfNullInteger, 0,	true,	false,     6);
								
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"aloc_rto_yn",  		false,	"",  dfNone,   		0,	true,	false);	//			        			        
			        InitDataProperty(0, cnt++, dtData,		80,	daRight, 	true,	"aloc_lod_qty_rto",  	false,	"",  dfNullFloat,	2,	true,	false,     6);
			        //추가 cmpb			
								
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"scg_grp_cmdt_yn",  	false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"scg_grp_cmdt_seq",  	false,	"",  dfNone,     	0,	false,	false,     2);//숨김 dtCombo
			        InitDataProperty(0, cnt++, dtData,		100,daLeft,  	true,	"scg_grp_cmdt_desc",	false,	"",  dfNone,     	0,	false,	false,    300);//숨김
			        InitDataProperty(0, cnt++, dtCheckBox,	15,	daCenter,	true,	"cmdt_yn",  			false,	"",  dfNone,   		0,	true,	false);	//
			        InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"cmdt_cd",      		false,	"",  dfNone,     	0,	false,	false,     6);
			        InitDataProperty(0, cnt++, dtData,		100,daLeft,  	true,	"cmdt_nm",      		false,	"",  dfNone,     	0,	false,	false,    300);
			        InitDataProperty(0, cnt++, dtCombo,		60,	daCenter,	true,	"aloc_svc_cd",      	false,	"",  dfNone,     	0,	true,	false,     1);//숨김
			        //추가 			
			        InitDataProperty(0, cnt++, dtCombo,		60,	daCenter,	true,	"bkg_ctrl_tp_cd",      	false,	"",  dfNone,     	0,	true,	false,     1);
			        InitDataProperty(0, cnt++, dtData,		120,daLeft,  	true,	"bkg_aloc_rmk",      	false,	"",  dfNone,     	0,	true,	false,     4000);
//                  InitDataProperty(0, cnt++ , dtPopupEdit,			80,		daCenter,	true,		"aloc_aply_fm_dt",			false,      "",				dfDateYmd,		0,			true,		true);
//                  InitDataProperty(0, cnt++ , dtPopupEdit,			80,		daCenter,	true,		"aloc_aply_to_dt",			false,      "",				dfDateYmd,		0,			true,		true);

			        InitDataProperty(0, cnt++, dtData,	80,	daCenter,	true,	"aply_fm_yrwk",     	false,	"",  dfUserFormat,  0,	true,	false,     7);
			        InitDataProperty(0, cnt++, dtData,	80,	daCenter,	true,	"aply_to_yrwk",			false,	"",  dfUserFormat,  0,	true,	false,     7);
			        InitDataProperty(0, cnt++, dtCombo,		45,	daCenter,	true,	"aloc_use_flg",      	false,	"",  dfNone,     	0,	true,	false,     1);
								
					InitDataProperty(0,	cnt++, dtHidden,	120,daCenter,	true,	"upd_usr_id",			false,	"",  dfNone,		0,	false,	false);	//숨김
					InitDataProperty(0,	cnt++, dtHidden,	120,daCenter,	true,	"upd_dt",				false,	"",  dfNone,		0,	false,	false);	//숨김
			        InitDataProperty(0, cnt++, dtHidden,	30,	daCenter,	true,	"bkg_aloc_seq",			false,	"",  dfNone,		0,	false,	false);
							
 					//동적 레이아웃 시작
                    for(var j=0; j<colCnt ; j++) {
                    	InitDataProperty(0, cnt++ , dtData,  colWidth1,    daCenter,   true, aryTitle[j],  false,  "",  dfNone,  0, false, false);
                    }
			        
			        InitDataCombo(0, "aloc_svc_cd", "|Auto|Manual", "|A|M");
			        InitDataValid(0, "bkg_no", vtEngUpOther, "0123456789");
			        InitDataValid(0, "sub_trd_cd", vtEngUpOnly);
			        InitDataValid(0, "cmdt_cd", vtNumericOnly);
			        InitDataValid(0, "scg_grp_cmdt_seq", vtNumericOnly);
			        
			        InitDataCombo(0, "bkg_ctrl_tp_cd", "Standby", "S"); //Reject 추후 사용
			        InitDataCombo(0, "aloc_use_flg", "YES|NO", "Y|N");
//			        InitDataCombo(0, "dg_rd", " |DG|RD", " |dg|rd");
//			        InitDataCombo(0, "cmpb_rule_cd", " |>=|<=", " |>=|<=");
			        InitDataCombo(0, "bkg_aloc_tp_cd", " |Free|Trunk|T/S|Customer|EQ|Commodity", " |F|T|S|C|E|M");
//			        InitDataCombo(0, "bkg_aloc_tp_cd", "ALL|Trunk|T/S|Customer|Commodity|EQ", "A|T|S|C|E|M");
			        //ColHidden("bkg_ctrl_tp_cd") = true;  //control Type hidden
                    InitDataCombo(0, "usa_bkg_mod_cd", " |IPI|Local|Others", " |IPI|LOCAL|OTH");
        			InitUserFormat(0, "aply_fm_yrwk", "####-##", "-" );
        			InitUserFormat(0, "aply_to_yrwk", "####-##", "-" );

			 }
 				break;
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
     * Sheet관련 프로세스 처리
     */ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {

    		case IBSEARCH:		//조회
    			if(validateForm(sheetObj,formObj,sAction)) { //validateForm(sheetObj,formObj,sAction)
    				// 업무처리중 버튼사용 금지 처리
	    			sheetObj.WaitImageVisible = false;
	    			ComOpenWait(true);
	    			formObj.f_cmd.value = SEARCHLIST;
	    			//Search시 입력된 BKGNO로 조회해야 하므로 GetSaveString()으로 sheet데이터를 가져간다.
	    			sheetObj.DoSearch4Post("ESM_SPC_0117GS.do", FormQueryString(formObj) +"&" + sheetObjects[0].GetSaveString());
    				var arrRow = sheetObj.FindStatusRow("R").split(";");
    				for (var idx=0; idx<arrRow.length-1; idx++){
    					sheetObj.CellValue2(arrRow[idx], "ibflag") = 'U';//조회 후 재조회시 'R'상태일 경우는 조회 할수 없으므로 상태를 바꾸어준다.
    				}	    			
	    			ComOpenWait(false);
    			}
    			break;

    		case IBSAVE:				//저장
    			if(validateForm(sheetObj,formObj, sAction)){
//   				if(validateUpload(sheetObj,formObj)){
	    			// 업무처리중 버튼사용 금지 처리
	    			sheetObj.WaitImageVisible = false;
	    			ComOpenWait(true);
	    			formObj.f_cmd.value = MULTI;
	    			sheetObj.DoSave("ESM_SPC_0117GS.do", FormQueryString(formObj));
	    			
	    			//Save후 기존 데이터를 지우고 시트를 초기화(50row추가)
//	    			if(rslt) {
//	    				ComShowCodeMessage("COM130102", "Data");
//	    				sheetObj.RemoveAll();
//	    				addDefaultRow();
//	    			}
	    			ComOpenWait(false);
    			}
    			break;
    			
			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;	
				
			case IBCLEAR:          //reprot 목록조회
				formObj.f_cmd.value = SEARCHLIST12;
				formObj.pgm.value = 'ESM_SPC_0117';//report upload
				var sXml = sheetObj.GetSearchXml("ESM_SPC_0118GS2.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				//				alert(arrXml);
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_selgroup, "code", "name");
				break;
			
			case IBRESET:          //Header 정보를 조회한다.
				 formObj.rpt_fom_nm.value = formObj.f_selgroup.text;
				 formObj.f_cmd.value = SEARCHLIST03;
				 sheetObj.DoSearch4Post("ESM_SPC_0118GS2.do", FormQueryString(formObj));
				 formObj.f_header.value   = sheetObj.EtcData("header");
				 formObj.f_headernm.value = sheetObj.EtcData("headerNM");				 
				 sheetObj.RemoveEtcData();
				 initHeader(sheetObj, formObj);
				 
				 break;
    	}
    }

    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
    	var rtValue = true;
    	with(sheetObj){
    		switch(sAction) {
    			case IBSEARCH:
    				var arrRow = FindStatusRow("U").split(";");
    				if(arrRow == '') {
    					ComShowMessage(getMsg("SPC10887","BKG#"));
    					SelectCell(2, "bkg_no", false);
    					rtValue = false;
    					break;
    				}
    				for (var idx=0; idx<arrRow.length-1; idx++){
    					if( ComTrim(CellValue(arrRow[idx], "bkg_no")) == '') {
    						ComShowMessage(getMsg("SPC10887","BKG#"));
	   						SelectCell(arrRow[idx], "bkg_no", false);
							rtValue = false;
							break;
    					}
    				}
    				break;
    				
    			case IBSAVE:
    				 var arrRow = FindStatusRow("U").split(";"); 
    				 if(arrRow == '') {
    					ComShowMessage(getMsg("SPC90142"));
    					SelectCell(2, "bkg_no", false);
    					rtValue = false;
    					break;
    				 }
    				 for (var idx=0; idx<arrRow.length-1; idx++){
    					 if( ComTrim(CellValue(arrRow[idx], "sls_rhq_cd")) == ''){
    						 ComShowMessage(getMsg("SPC10887","RHQ"));
    						 SelectCell(arrRow[idx], "sls_rhq_cd", false);
    						 rtValue = false;
    						 break;
    					 } else if( ComTrim(CellValue(arrRow[idx], "bkg_aloc_tp_cd")) == ''){
    						 ComShowMessage(getMsg("SPC10887","TYPE"));
    						 SelectCell(arrRow[idx], "bkg_aloc_tp_cd", false);
    						 rtValue = false;
    						 break;
    					 } else if(ComTrim(CellValue(arrRow[idx], "bkg_aloc_tp_cd")) == 'T' && CellValue(arrRow[idx], "sls_rhq_cd") != 'NYCRA'){ //Trunk Type은 NYCRA에만 입력가능
    						 ComShowMessage(getMsg("SPC10993","Trunk Type"));
    						 SelectCell(arrRow[idx], "bkg_aloc_tp_cd", false);
    						 rtValue = false;
    						 break;
    					 }
    					 else if(CellValue(arrRow[idx], "sub_trd_yn") == '1' && CellValue(arrRow[idx], "sub_trd_cd") == '') {//sub_trd_yn, sub_trd_cd
    						 ComShowMessage(getMsg("SPC10887","Sub Trade"));
    						 SelectCell(arrRow[idx], "sub_trd_cd", false);
    						 rtValue = false;
    						 break;

    					 } 
    					 else if(CellValue(arrRow[idx], "sc_yn") == '1' && CellValue(arrRow[idx], "sc_no") == ''){//sc_yn, sc_no ,rfa_yn,rfa_no
    						 ComShowMessage(getMsg("SPC10887","S/C No."));
    						 SelectCell(arrRow[idx], "sc_no", false);
    						 rtValue = false;
    						 break;
    						 
    					 } 
    					 else if(CellValue(arrRow[idx], "rfa_yn") == '1' && CellValue(arrRow[idx], "rfa_no") == ''){//sc_yn, sc_no ,rfa_yn,rfa_no
    						 ComShowMessage(getMsg("SPC10887","RFA No."));
    						 SelectCell(arrRow[idx], "rfa_no", false);
    						 rtValue = false;
    						 break;
    						 
    					 } 
    					 else if(CellValue(arrRow[idx], "agmt_yn") == '1' && CellValue(arrRow[idx], "agmt_act_cust_code") == ''){//agmt_yn,agmt_act_cnt_cd,agmt_act_cust_seq,agmt_act_cust_code,agmt_cust_lgl_eng_nm
    						 ComShowMessage(getMsg("SPC10887","Actual Customer"));
    						 SelectCell(arrRow[idx], "agmt_act_cust_code", false);
    						 rtValue = false;
    						 break;
    						 
    					 } 
    					 else if(CellValue(arrRow[idx], "oft_chg_yn") == '1' && CellValue(arrRow[idx], "oft_chg_amt") == ''){//oft_chg_yn,oft_chg_amt
    						 ComShowMessage(getMsg("SPC10887","Charge OFT"));
    						 SelectCell(arrRow[idx], "oft_chg_amt", false);
    						 rtValue = false;
    						 break;
    						 
    					 } 
    					 else if(CellValue(arrRow[idx], "cmpb_yn") == '1' && (CellValue(arrRow[idx], "cmpb_rule_cd") == ''||CellValue(arrRow[idx], "cmpb_amt") == '')){//cmpb_yn,cmpb_rule_cd,cmpb_amt 
    						 ComShowMessage(getMsg("SPC10887","CMPB"));
    						 SelectCell(arrRow[idx], "cmpb_rule_cd", false);
    						 rtValue = false;
    						 break;
    						 
    					 } 
    					 else if(CellValue(arrRow[idx], "aloc_lod_yn") == '1' && CellValue(arrRow[idx], "aloc_lod_qty") == ''){//aloc_lod_yn,aloc_lod_qty
    						 ComShowMessage(getMsg("SPC10887","ALLOCATION"));
    						 SelectCell(arrRow[idx], "aloc_lod_qty", false);
    						 rtValue = false;
    						 break;
    						 
    					 } 
    					 else if(CellValue(arrRow[idx], "aloc_rto_yn") == '1' && CellValue(arrRow[idx], "aloc_lod_qty_rto") == ''){//aloc_rto_yn,aloc_lod_qty_rto 
    						 ComShowMessage(getMsg("SPC10887","% THRESHOLD")); 
    						 SelectCell(arrRow[idx], "aloc_lod_qty_rto", false);
    						 rtValue = false;
    						 break;
    						 
    					 } 
    					 else if(CellValue(arrRow[idx], "sls_rhq_cd") == 'NYCRA' && CellValue(arrRow[idx], "aloc_svc_cd") == '' ){//NYCRA의 aloc_svc_cd
    						 ComShowMessage(getMsg("SPC10993","SVC(NYCRA)"));
    						 SelectCell(arrRow[idx], "aloc_svc_cd", false);
    						 rtValue = false;
    						 break;
    					 }
    				 }
    				break;
    		}
  
    	}
    	return rtValue;
    }
    
    
	/**
     * Up Load 값의 유효성 체크
     */
    function validateUpload(sheetObj, formObj) {
    	return true;
    }
    
  //화면 로르 후 row50개 자동으로 insert
    function addDefaultRow(){ 
    	sheetObj = sheetObjects[0];
        initCell4Type = false;
        var row = 0;
        for(var k=0; k<50; k++) {
        	row = sheetObj.DataInsert(-1);
        	sheetObj.CellValue2(row, "ibflag") = 'R';
        }
        initCell4Type = true;
    }
    
    
    function openRPTFormPopUp(){
    	var formObj = document.form;
    	var curPgmNo = "ESM_SPC_0117";
        var param = "?col_desc="+document.form.f_header.value+"&call_cnt="+reportFormPopupCallCnt+"&pgm="+curPgmNo; 
    	ComOpenWindow2('ESM_SPC_0118.do'+param, '', 'width=600, height=440, menubar=0, status=1, scrollbars=0, resizable=0');
    	reportFormPopupCallCnt = 1;
    }
    
    /**
     * 118번 화면이 닫희면서 sheet의 header목록을 변경위해서 sheet를 초기화한다..
     * //reprot upload
     */
    function chgInitSheet(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        initHeader(sheetObj, formObj);

    }
    /**
     * sheet를 초기화 시킨다.
     * //reprot upload
     */
    function initHeader(sheetObj, formObj){
      // Header 정보를 변경하기 위해 sheet를 초기화 한다.
      //--------------------------------------------------
      // Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
      sheetObj.Redraw = false;
      sheetObj.RemoveAll();
      sheetObj.Reset();
//      initSheet(sheetObj, 1, formObj.f_header.value, formObj.f_headernm.value);
      initSheet(sheetObj, 1, formObj.f_headernm.value, formObj.f_header.value);
      
      addDefaultRow();
      sheetObj.Redraw = true;
      //--------------------------------------------------

    }
    /**reprot upload 추가 
     * f_selgroup 변경시 sheet의 Header정보를 변경
     */
    function f_selgroup_OnChange(obj, code){
   	 if (loadingMode == true) return;
   	 chgHeader();
    }
    
    /**reprot upload 추가 
     * Group combo 변경시 sheet의 Header정보를 변경시킨다.
     */
    function chgHeader(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        doActionIBSheet(sheetObj,formObj,IBRESET);
    }
    /**reprot upload 추가 
     * Popup이 닫힌 후 group combo를 변경 시킨다.
     */
    function chgGroup(param){
    	var formObj = document.form;
        var sheetObj = sheetObjects[0];
     	formObj.f_cmd.value = SEARCHLIST12;
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0118GS2.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], formObj.f_selgroup, "code", "name");
		ComSetObjValue(formObj.f_selgroup,param);
     }
    
    /******************************************************************************************************************
     * ESM_SPC_0115번 화면과 동일한 function 0115번 바꾸면 여기도 바꾸어야함.
     */
    
	/**
     * 시트를 클릭했을 때 처리
     */
	function sheet1_OnClick(sheetObj, row, col) {
		var colSaveName = sheetObj.ColSaveName(col);
		switch(colSaveName) {
			case "bkg_aloc_rmk" :
				//document.form.dirty_flag.value = 'Y';
	    		/* 긴 문자열 MemoPad 처리*/
				if (ComTrim(sheetObj.CellValue(row,"bkg_aloc_tp_cd")) != 'T') {
	    			sheetObj.CellEditable(row, col) = false;
	    			ComShowMemoPad(sheetObj, row, col, false, 250, 100);
	    			sheetObj.CellEditable(row, col) = true;
				} 
    		break;
		}
	} 
	
//	function sheet1_OnDblClick(sheetObj, row, col) {
//		alert("value=" + sheetObj.CellValue(row, col) + ", col=" + sheetObj.ColSaveName(col));
//	}   
    
	/**
	 * 화면 시트값의 변화에 따라 수행될 동작을 정의한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @returns 없음
	 * @author Seung-Man KIM
	 * @version 2015.01.23
	 */
	function sheet1_OnChange(sheetObj, row, col, val) {
		var formObj = document.form;
		var val_type = "";
		var val_value = "";
		var today   = ComGetNowInfo('ymd');
		
		// 데이터 변경 여부 체크
		formObj.dirty_flag.value = 'Y';
//		sheetFlag ="Y";
		
		/* ColSaveName */
		var col_save_name = sheetObj.ColSaveName(col);
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		/* 대문자 */
//		if(col_save_name == "aloc_aply_fm_dt"||col_save_name == "aloc_aply_to_dt"){
//			var submitDate=  (sheetObj.CellValue(row, col));
//			if(parseInt(submitDate) > parseInt(today)){
//				ComShowMessage(getMsg("COM12182"));
//				sheetObj.CellValue(row, col)="";
//				sheetObj.SelectCell(row, col);
//			}
//		}
		if(data_type == dtData) {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
		//bkg_aloc_tp_cd변경시 SVC값과 셀의 활성화여부를 결정한다
		if(col_save_name == "bkg_aloc_tp_cd"){
			sheetObj.SelectCell(row, col);
			sheet1_OnSelectCell(sheetObj,row,col);
			svcType(sheetObj);
		} else if (col_save_name == "trnk_slan_cd" || col_save_name == "n1st_ts_slan_cd") {
			//trnk_slan_cd, trnk_dir_cd, trnk_dir_cd 변경시 값의 적정성을 Validation한다.
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "LANE";
        		val_value = sheetObj.CellValue(row,col_save_name);
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}
        }else if (col_save_name == "sub_trd_cd") {//추가 테스트 
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "SUB_TRADE";
        		val_value = sheetObj.CellValue(row,col_save_name);
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}
        } else if(col_save_name == "trnk_dir_cd" || col_save_name == "n1st_ts_dir_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "BOUND";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "cmdt_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "COMMODITY";
        		val_value = sheetObj.CellValue(row,"cmdt_cd");  
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		} else {
        			doActionIBSheet(sheetObj,formObj,SEARCH03);
        		}
        	}else{
        		sheetObj.CellValue2(row,"cmdt_nm") = "";
        	}	
        } else if(col_save_name == "scg_grp_cmdt_seq"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "GRP_COMMODITY";
        		val_value = sheetObj.CellValue(row,"scg_grp_cmdt_seq");  
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		} else {
        			doActionIBSheet(sheetObj,formObj,SEARCH05);
        		}
        	}else{
        		sheetObj.CellValue2(row,"scg_grp_cmdt_desc") = "";
        	}
        		
        } else if(col_save_name == "ob_sls_ofc_cd" || col_save_name == "sls_rhq_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	        	formObj.ofc_cd.value = sheetObj.CellValue(row,col);
	        	formObj.ofc_ty.value = 1;
	        	formObj.f_cmd.value  = SEARCH01;
	        	var sParam = FormQueryString(formObj);
	        	var sXml = sheetObj.GetSaveXml("ESM_SPC_0115GS.do", sParam);
	   	     
		   	     if (ComGetEtcData(sXml,"check") == "N"){
		   	    	ComShowMessage(getMsg("SPC11107"));//사용가능한 Office Code가 아닙니다.
		   	    	 sheetObj.SelectCell(row, col, true, '');
		       	 }
        	}
        } else if(col_save_name == "vvd") {
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	        	if (sheetObj.CellValue(row,col).length != 9){
	        		ComShowMessage(getMsg("SPC10145"));//Please! Check your VVD.	
					 sheetObj.SelectCell(row, col, true, '');
	        	}
	        	formObj.f_cmd.value = SEARCH01;   
	        	formObj.vvd_sig.value = sheetObj.CellValue(row,col);
				 
				 var searchXml = sheetObj.GetSearchXml("ESM_SPC_0115GS.do" , FormQueryString(formObj));
				 if (ComGetEtcData(searchXml,"lane") == "none"){
					 ComShowMessage(getMsg("SPC10163"));//VVD is NOT Registered
					 sheetObj.SelectCell(row, col, true, '');
				 }
        	}
        } else if(col_save_name == "ctrt_cust_cnt_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "CUSTOMER";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        }else if(col_save_name == "agmt_act_cnt_cd"){//추가 테스트
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "Actual_Customer";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "cust_cnt_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "CUSTOMER";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "cntr_tpsz_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "CNTR TPSZ";
        		val_value = sheetObj.CellValue(row,col_save_name);
        		if (sheetObj.CellValue(row,col_save_name) == "ALL" && sheetObj.CellValue(row,"bkg_aloc_tp_cd") != "E"){
        			ComShowMessage(getMsg('SPC10993',val_type + " : " + val_value));
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        			
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "sc_no"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "SC NO";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "rfa_no"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "RFA NO";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}
        } else if(col_save_name == "por_cd" || col_save_name == "pol_cd" || col_save_name == "n1st_ts_pol_cd" ||
        		  col_save_name == "n1st_ts_pod_cd" || col_save_name == "pod_cd" ||
        		  col_save_name == "del_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "Location";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "n1st_ts_pol_cnt_cd" || col_save_name == "n1st_ts_pod_cnt_cd" 
        	      || col_save_name == "bkg_por_cnt_cd" || col_save_name == "bkg_pol_cnt_cd"
        	      || col_save_name == "bkg_pod_cnt_cd" || col_save_name == "bkg_del_cnt_cd"){
		    	if(sheetObj.CellValue(row,col_save_name)!="" ){
		    		val_type = "CNT";
		    		val_value = sheetObj.CellValue(row,col_save_name); 
		    		if(!searchValidationData(sheetObj, val_type, val_value)) {
		    			sheetObj.CellValue2(row,col_save_name) = "";
		    			sheetObj.SelectCell(row, col);
		    		}
		    	}
    	}else if(col_save_name == "bkg_por_scc_cd" || col_save_name == "bkg_del_scc_cd" ){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	    		val_type = "SCC";
	    		val_value = sheetObj.CellValue(row,col_save_name); 
	    		if(!searchValidationData(sheetObj, val_type, val_value)) {
	    			sheetObj.CellValue2(row,col_save_name) = "";
	    			sheetObj.SelectCell(row, col);
	    		}
	    	}	
	    } else if(col_save_name == "por_nod_cd" || col_save_name == "pol_nod_cd" ||
      		  col_save_name == "pod_nod_cd" || col_save_name == "del_nod_cd") {
	    	if(sheetObj.CellValue(row,col_save_name)!="" ){
	    		val_type = "NODE";
	    		val_value = sheetObj.CellValue(row,col_save_name); 
	    		if(!searchValidationData(sheetObj, val_type, val_value)) {
	    			sheetObj.CellValue2(row,col_save_name) = "";
//	    			sheetObj.SelectCell(row, col);
	    			
	    		}
	    	}	
	    }  else if(col_save_name == "ts_nod_cd" || col_save_name == "ts_pol_nod_cd" || col_save_name == "ts_pod_nod_cd" ){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		if (col_save_name.indexOf("ts_nod_cd") > -1) {
        			val_type = 'Location/Node';
        		} else {
        			val_type = 'NODE';
        		}
        		
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        }
 	}
	
	
	/**
	 * IBSheet 선택 Cell 변경 Event<br>
	 * @return 없음
	 * @author Seung-Man KIM
	 * @version 2015.01.23
	 */
    function sheet1_OnSelectCell(sheetObj,row,col){
    	if(initCell4Type && row > 1 && sheetObj.ColSaveName(col) == 'bkg_aloc_tp_cd') {
        	with(sheetObj){
//        		initCell(sheetObj,row);
        		
        		var tp = CellValue(row, "bkg_aloc_tp_cd");
        		var rhq = CellValue(row,"sls_rhq_cd");
        	
            		var isT = false;//Trunk
            		var isS = false;//T/S
            		var isE = false;//EQ
            		var isM = false;//Commodity
            		var isC = false;//Customer
            		var isF = false;//Free
            		
            		switch(tp) {
    	    			case "T": isT = true; break;
    	    			case "S": isS = true; break;
    	    			case "E": isE = true; break;
    	    			case "M": isM = true; break;
    	    			case "C": isC = true; break;
    	    			default: isF = true; break;

            		} // end switch          		
            		var isYN = false;
            		//row cell 초기화
            		for(var k=9; k<headCount; k++) { //가변헤더는 참조데이터이므로 Save와 상관없어서 처리 안함
            			isYN = strEndsWith(ColSaveName(k), "_yn");
            			CellEditable(row,k) = isF||isYN?true:false;
            			if(isYN) CellValue2(row,k) = 'N';//초기화
            		}	
            		if(!isF) {
//        	    		CellEditable(row,"trnk_slan_yn") = false;		
                		
            			//공통
        	    		CellValue2(row,"trnk_slan_yn")  = 'Y';
        	    		CellValue2(row,"trnk_dir_yn")   = 'Y';   		
        	    		CellValue2(row,"ob_sls_ofc_yn") = 'Y';
        	    		CellValue2(row,"us_yn")= 'Y';
        	    		
        	    		CellEditable(row,"bkg_ctrl_tp_cd") = true;
        	    		
        	    		CellEditable(row,"oft_chg_yn") = true;
        	    		CellEditable(row,"oft_chg_amt") = true;
        	    		
        	    		CellEditable(row,"bkg_aloc_rmk") = true;
        	    		CellEditable(row,"aloc_aply_fm_dt") = true;
        	    		CellEditable(row,"aloc_aply_to_dt") = true;
        	    		CellEditable(row,"aloc_use_flg") = true
        	    		
        	    		//사용자테스트중 변경--모든 TYPE에 대해 allcoation 입력가능하도록
        	    		CellValue2(row,"aloc_rto_yn")        = 'Y';
        	    		CellEditable(row,"aloc_lod_qty_rto") = true;
        	    		CellValue2(row,"aloc_lod_yn")        = 'Y';
        	    		CellEditable(row,"aloc_lod_qty")     = true;
        	    		//추가요구사항 CMPB는 모든 타입에 적용
        	    		CellValue2(row,"cmpb_yn")         = 'Y';
//        	    		CellEditable(row,"cmpb_rule_cd")  = true;
        	    		CellEditable(row,"cmpb_amt")      = true;
        	    		
        	    		
        	    		if(rhq == 'NYCRA') CellEditable(row,"aloc_svc_cd") = true;;
        	    		
                		//Trunk : T.lane / BD / Trunk POL/POD / VVD / L.OFC / % THRESHOLD / Control type									
        	    		CellValue2(row,"trnk_pol_yn") = isT?'Y':'N';
        	    		CellValue2(row,"trnk_pod_yn") = isT?'Y':'N';
        	    		CellValue2(row,"vvd_yn")      = isT?'Y':'N';
//        	    		CellValue2(row,"aloc_rto_yn") = isT||isS||isC?'Y':'N';
//        	    		CellEditable(row,"aloc_lod_qty_rto") = isT||isS||isC?true:false;
            	    		
//        	    		trnk_slan_yn trnk_slan_cd trnk_dir_yn trnk_dir_cd trnk_pol_yn trunk_pol_cd trnk_pod_yn trunk_pod_cd     
//        	    		vvd_yn vvd ob_sls_ofc_yn ob_sls_ofc_cd ob_sls_ofc_nm  
//        	    		aloc_rto_yn aloc_lod_qty_rto bkg_ctrl_tp_cd --
        	    		
        	    		//T/S : T.Lane / BD / POR / POL / POD / DEL (BKG Route 비교) / T/S Lane, BD, POL, POD / L.OFC / Allocation / % THRESHOLD / Control type
        	    		CellValue2(row,"bkg_por_cnt_yn")     = isS||isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"por_yn")             = isS||isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"por_nod_yn")         = isS||isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"bkg_por_scc_yn")     = isS||isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"bkg_pol_cnt_yn")     = isS||isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"pol_yn")             = isS||isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"pol_nod_yn")         = isS||isE||isM||isC?'Y':'N';
        	    		
        	    		CellValue2(row,"n1st_ts_slan_yn")    = isS?'Y':'N';
        	    		CellValue2(row,"n1st_ts_dir_yn")     = isS?'Y':'N';
        	    		CellValue2(row,"n1st_ts_pol_cnt_yn") = isS?'Y':'N';
        	    		CellValue2(row,"n1st_ts_pol_yn")     = isS?'Y':'N';
        	    		CellValue2(row,"n1st_ts_pod_cnt_yn") = isS?'Y':'N';
        	    		CellValue2(row,"n1st_ts_pod_yn")     = isS?'Y':'N';
        	    		CellValue2(row,"bkg_pod_cnt_yn")     = isS?'Y':'N';

        	    		CellValue2(row,"ts_nod_yn")     	= isS?'Y':'N';
        	    		CellValue2(row,"ts_pol_nod_yn")     = isS?'Y':'N';
        	    		CellValue2(row,"ts_pod_nod_yn")     = isS?'Y':'N';
        	    		
        	    		CellValue2(row,"pod_cd_yn")          = isS||isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"pod_nod_yn")         = isS||isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"bkg_del_cnt_yn")     = isS||isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"del_yn")             = isS||isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"del_nod_yn")         = isS||isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"bkg_del_scc_yn")     = isS||isE||isM||isC?'Y':'N';
//        	    		CellValue2(row,"aloc_lod_yn")        = isS||isC?'Y':'N';
//        	    		CellEditable(row,"aloc_lod_qty")    = isS||isC?true:false;
        	    		  
            	    		
            	    	//EQ : T.Lane / BD / POR / POL / POD / DEL / Cntr type/size / L.OFC / Control type / DGRD
        	    		CellValue2(row,"cntr_tpsz_yn") = isE||isM||isC?'Y':'N';
        	    		CellValue2(row,"dg_rd_yn")     = isE?'Y':'N';    		
//        	    		dg_rd_yn dg_flg rd_flg cntr_tpsz_yn cntr_tpsz_cd 
        	    		
                	    //Commodity : T.Lane / BD / POR/POL/POD/DEL (BKG Route 비교) / CNTR Type/size / L.OFC / Contract no. (SC, RFA) / Commodity code & name / Group commodity code & name / Control type 															
        	    		CellValue2(row,"sc_yn")             = (isM||isC) && (ComTrim(CellValue(row,"sc_no")) != '')?'Y':'N';
        	    		CellValue2(row,"rfa_yn")            = (isM||isC) && (ComTrim(CellValue(row,"rfa_no")) != '')?'Y':'N';
        	    		CellValue2(row,"scg_grp_cmdt_yn")   = isM?'Y':'N';
        	    		CellValue2(row,"cmdt_yn")           = isM?'Y':'N';
//        	    		sc_yn sc_no rfa_yn rfa_no scg_grp_cmdt_yn scg_grp_cmdt_seq scg_grp_cmdt_desc cmdt_yn cmdt_cd cmdt_nm      

            	    	//Customer :  T.Lane / BD / POR / POL / POD / DEL (BKG Route 비교) / CNTR Type/size / L.OFC / Contract No (SC,RFA) / C. Cust code / BKG shpr code /CMPB / Allocation / % THRESHOLD /Control Type 																
        	    		CellValue2(row,"ctrt_yn")         = isC?'Y':'N';
        	    		CellValue2(row,"shpr_yn")         = isC?'Y':'N';
   	    		
//        	    		ctrt_yn ctrt_cust_cnt_cd ctrt_cust_seq ctrt_cust_code ctrt_cust_lgl_eng_nm 
//        	    		shpr_yn shpr_cust_cnt_cd shpr_cust_seq shpr_cust_code shpr_cust_lgl_eng_nm 
//        	    		cmpb_yn cmpb_rule_cd  cmpb_amt  
       	    		
            		}

        	}//with	
    	}//if

    }
    
    /**
     * Cell 초기화
     */
    function initCell(sheetObj,row){
 	   with(sheetObj){

 	   }
    }
    
	/**
     * bkg_aloc_tp_cd에 따라 SVC 열의 값을 자동으로 기입한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     svcType(sheetObject[0])
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author Seung-Man KIM
     * @version 2015.01.23
     */
	function svcType(sheetObj){
		//NYCRA에서만 수행되도록 변경
		if(sheetObj.CellValue(sheetObj.SelectRow, "sls_rhq_cd") == 'NYCRA') {
			if(sheetObj.CellValue(sheetObj.SelectRow, "bkg_aloc_tp_cd") == "T"){
				sheetObj.CellValue2(sheetObj.SelectRow, "aloc_svc_cd") = "A";
			} else{
				sheetObj.CellValue2(sheetObj.SelectRow, "aloc_svc_cd") = "M";
			}
		}

	}
	
	
	/**
	 * 저장시 시트의 값에 따른 Validation을 실시한다.<br>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} lane_cd  
	 * @param {String} dir_cd  
	 * @param {String} cmdt_cd 
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author Seung-Man KIM
	 * @version 2015.01.23
	 */
	function searchValidationData(sheetObj, val_type, val_value) {
		var formObj = document.form;
		var sParam  = "";
		
		//sheetFlag Y이면 시트에 입력된값을 기준으로 Validation하고 ""이면 FormObject를 기준으로 Validation한다.		
//    	if(sheetFlag == "Y"){
    		sParam = "f_cmd=102&" + "&val_type="+val_type+"&val_value="+val_value;
//    	} else{
//    		formObj.f_cmd.value = SEARCH02;
//    		sParam = FormQueryString(formObj);    		
//    	}
    	
    	sheetFlag = "";
    	var sXml = sheetObjects[0].GetSearchXml("ESM_SPC_0115GS.do", sParam);    	
    	var val_cnt  = ComGetEtcData(sXml, "val_cnt");

		if(val_cnt < 1 && val_cnt != ""){
			ComShowMessage(getMsg('SPC10993',val_type + " : " + val_value));			
			return false;
		}
		 
		return true;
	}
	
	/*
	 * 문자열이 suffix로 끝나는지
	 */
	function strEndsWith(str, suffix) {
	    return str.match(suffix+"$")==suffix;
	}
	
	
    /**
     * sheet1에서 이미지버튼을 클릭한 경우 를 처리한다.
     * gubun A인경우 C1T0W 가 아닌경우
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnPopupClick(sheetObj, row, col){
    	var colSaveName = sheetObj.ColSaveName(col);
    	var tabNo = 0;
    	if (colSaveName == 'agmt_act_cnt_cd') {
    		var sc = sheetObj.CellValue(row, "sc_no");
    		var rfa = sheetObj.CellValue(row, "rfa_no");
    		if (sc == '' && rfa == '') {
    			ComShowMessage(getMsg("SPC90301", " for Actual Customer."));
    			SelectCell(i, "sc_no");
    		} else {
    			var url = "ESM_SPC_0073.do?pgmNo=ESM_SPC_0073" + "&sc_no=" + sc + "&rfa_no=" + rfa + "&type=" + "B" + "&actAcctCmdt=" + sheetObj.CellValue(row, "agmt_act_cnt_cd");
    			ComOpenPopup(url, 800, 420, "callBackPopupActCust", "0,1,1,1,1,1", false, false, row, col, y);
    		}
    	} else if (colSaveName.indexOf("pol_cd") > -1 || colSaveName.indexOf("pod_cd") > -1 || colSaveName.indexOf("por_cd") > -1 || colSaveName.indexOf("del_cd") > -1 || colSaveName.indexOf("cnt_cd") > -1 || colSaveName.indexOf("cntr_tpsz_cd") > -1 ) {
    		var loCdTp = ''; 
    		var urlPopUp = '/hanjin/ESM_SPC_0121.do'; 
    		if (colSaveName.indexOf("trunk_") > -1) {
    			loCdTp = 'T';
    		} else //location search
    		if (colSaveName.indexOf("pol_cd") > -1 || colSaveName.indexOf("pod_cd") > -1 || colSaveName.indexOf("por_cd") > -1 || colSaveName.indexOf("del_cd") > -1) {
    			loCdTp = 'L';
    		} else //country search
    		if (colSaveName.indexOf("cnt_cd") > -1) {
    			loCdTp = 'C';
    		} else //cntr_tpsz_cd search
    			if (colSaveName.indexOf("cntr_tpsz_cd") > -1) {
    				loCdTp = 'S';
    				urlPopUp = '/hanjin/ESM_SPC_0124.do';
    		}
    		var param = "";
    		param = param + "?trnk_slan_cd=" + sheetObj.CellValue(row, "trnk_slan_cd");
    		param = param + "&trnk_dir_cd=" + sheetObj.CellValue(row, "trnk_dir_cd");
    		param = param + "&loc_cd_tp=" + loCdTp;
    		param = param + "&loc_multi_cd=" + sheetObj.CellValue(row, colSaveName);
    		param = param + "&org_sheet=" + "0";
    		param = param + "&org_row=" + row;
    		param = param + "&org_ui_id=" + "ESM_SPC_0115";
    		param = param + "&tabNo=" + tabNo;
    		param = param + "&targetColume=" + colSaveName;
    		ComOpenPopup(urlPopUp + param, 340, 420, '', '1,0,1,1,1,1,1,1', true);
    	} else if (colSaveName == 'aloc_aply_fm_dt') {
    		var cal = new ComCalendarGrid();
    		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
    	} else if (colSaveName == 'aloc_aply_to_dt') {
    		var cal = new ComCalendarGrid();
    		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
    	} else if (colSaveName == 'cmdt_cd') {
    		var sc = sheetObj.CellValue(row, "sc_no");
    		var rfa = sheetObj.CellValue(row, "rfa_no");
    		if (sc == '' && rfa == '') {
    			ComShowMessage(getMsg("SPC90301", " for Commodity."));
    			SelectCell(i, "sc_no");
    		} else {
    			var url = "ESM_SPC_0073.do?pgmNo=ESM_SPC_0073" + "&sc_no=" + sc + "&rfa_no=" + rfa + "&type=" + "C" + "&actAcctCmdt=" + sheetObj.CellValue(row, "cmdt_cd");
    			ComOpenPopup(url, 800, 420, "callBackPopupCmdt", "0,1,1,1,1,1", false, false, row, col, y);
    		}
    	}  else if (colSaveName.indexOf("ts_nod_cd") > -1 || colSaveName.indexOf("ts_pol_nod_cd") > -1 || colSaveName.indexOf("ts_pod_nod_cd") > -1 ) {
    		var loCdTp = ''; 
    		var urlPopUp = '/hanjin/ESM_SPC_0121.do'; 
    		if (colSaveName.indexOf("ts_nod_cd") > -1) {
    			loCdTp = 'LN';
    		} else {
    			loCdTp = 'N';
    		}

    		var param = "";
    		param = param + "?loc_cd_tp=" + loCdTp;
    		param = param + "&loc_multi_cd=" + sheetObj.CellValue(row, colSaveName);
    		param = param + "&org_sheet=" + "0";
    		param = param + "&org_row=" + row;
    		param = param + "&org_ui_id=" + "ESM_SPC_0115";
    		param = param + "&tabNo=" + tabNo;
    		param = param + "&targetColume=" + colSaveName;
    		ComOpenPopup(urlPopUp + param, 340, 420, '', '1,0,1,1,1,1,1,1', true);
    	}
    }
    
     function sheet1_OnPopupClick_B(sheetObj, row, col){
     	 var colSaveName = sheetObj.ColSaveName(col);
 	 	 switch(colSaveName) {
			 case "trunk_pol_cd":
	    			var param = "";
					param = param + "?trnk_slan_cd=" + sheetObj.CellValue(row,"trnk_slan_cd");
					param = param + "&trnk_dir_cd=" + sheetObj.CellValue(row,"trnk_dir_cd");
					param = param + "&loc_cd_tp=" + "TPOL";
					param = param + "&loc_multi_cd=" + sheetObj.CellValue(row,"trunk_pol_cd");
					param = param + "&org_sheet=" + "0";
					param = param + "&org_row=" + row;
					param = param + "&org_ui_id=" + "ESM_SPC_0117";
					ComOpenPopup('/hanjin/ESM_SPC_0121.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
	    		  break;
			 case "trunk_pod_cd":
	    			var param = "";
					param = param + "?trnk_slan_cd=" + sheetObj.CellValue(row,"trnk_slan_cd");
					param = param + "&trnk_dir_cd=" + sheetObj.CellValue(row,"trnk_dir_cd");
					param = param + "&loc_cd_tp=" + "TPOD";
					param = param + "&loc_multi_cd=" + sheetObj.CellValue(row,"trunk_pod_cd");
					param = param + "&org_sheet=" + "0";
					param = param + "&org_row=" + row;
					param = param + "&org_ui_id=" + "ESM_SPC_0117";
					ComOpenPopup('/hanjin/ESM_SPC_0121.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
	    		  break;	 
			 case "n1st_ts_pol_cd":
	    			var param = "";
					param = param + "?trnk_slan_cd=" + sheetObj.CellValue(row,"n1st_ts_slan_cd");
					param = param + "&trnk_dir_cd=" + sheetObj.CellValue(row,"n1st_ts_dir_cd");
					param = param + "&loc_cd_tp=" + "SPOL";
					param = param + "&loc_multi_cd=" + sheetObj.CellValue(row,"n1st_ts_pol_cd");
					param = param + "&org_sheet=" + "0";
					param = param + "&org_row=" + row;
					param = param + "&org_ui_id=" + "ESM_SPC_0117";
					ComOpenPopup('/hanjin/ESM_SPC_0121.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
	    		  break;
			 case "n1st_ts_pod_cd":
	    			var param = "";
					param = param + "?trnk_slan_cd=" + sheetObj.CellValue(row,"n1st_ts_slan_cd");
					param = param + "&trnk_dir_cd=" + sheetObj.CellValue(row,"n1st_ts_dir_cd");
					param = param + "&loc_cd_tp=" + "SPOD";
					param = param + "&loc_multi_cd=" + sheetObj.CellValue(row,"n1st_ts_pod_cd");
					param = param + "&org_sheet=" + "0";
					param = param + "&org_row=" + row;
					param = param + "&org_ui_id=" + "ESM_SPC_0117";
					ComOpenPopup('/hanjin/ESM_SPC_0121.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
	    		  break;	    		  
	    		  
			 case "aloc_aply_fm_dt" :
				    var cal = new ComCalendarGrid();
				    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
				    break;
				    
	       	 case "aloc_aply_to_dt" :
				    var cal = new ComCalendarGrid();
				    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
				    break;
				    
	 	 	 case "agmt_act_cnt_cd":
				 var cust_cd  = sheetObj.CellValue(row,"agmt_act_cnt_cd");
//			     spcPopup("Customer", "cust_cd="+cust_cd, 770, 470, "callbackPopupCustomer", "0,1,1,1,1,1,1,1");
	    		 var url = "ESM_SPC_0073.do?pgmNo=ESM_SPC_0073&bkg_no="+""+"&sc_no=&rfa_no="+""+"&svc_scp_cd="+""+"&app_dt="+""+"&type="+"B";
				 ComOpenPopup(url, 800, 420, "callBackPopup", "0,1,1,1,1,1", true, false, row, col , y);
	    		 break;
 		 }
     }
     
     function sheet1_OnSaveEnd(sheetObj, errMsg) {
     	if(errMsg == ""){
			ComShowCodeMessage("COM130102", "Data");
			sheetObj.RemoveAll();
			addDefaultRow();
			sheetObject.SelectCell(2, "bkg_no", false);
     	}
     }
      
	/* 개발자 작업  끝 */
