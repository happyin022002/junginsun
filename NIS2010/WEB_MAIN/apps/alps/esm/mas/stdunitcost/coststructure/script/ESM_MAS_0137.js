/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0137.js
*@FileTitle : Node/Link U/C Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.07.31 임옥영
* 1.0 Creation
* 2008-06-02 CSR No.N200805280011
*			 Save 권한을 CDA, COL, CDO로 한정함. test를 위해 system계정 포함.
* 2008-04-28 전성진 CSR No.N200804210008
*                   - cost fixed 설정 
* 2009-03-24 전윤주 CSR No.N200903190080 
*                   - node 단가 조회 화면에 Trade 컬럼 추가 
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리           
* 2010.05.27 전윤주 CSR No.CHM-201003904 평균단가 추정 로직 변경_A/G code 구분(CGFRTX)
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
*                  CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2010.09.29 박은주 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정 
*                         기존에 콤보에 세징하던 정보를 가지고 있던 srcStndCd 변수를 전역변수로 선언하여
*                         콤보에 세팅하는 코드 정보를 변수에 바인딩함 
*                         [sheet3_OnChange 여기서 해당 정보를 사용하고 있어 스크립트 오류가 발생]
* 2011.06.21 이행지 [CHM-201111781-01] [MAS] 평균단가 입력화면 R/Lane 조건추가 검토요청
* 2011.06.24 이행지 [CHM-201111807-01] MAS NODE 단가 화면 저장시 발생될 수 있는 문제 해결-컬럼명 변경 (USD AMT-> Curr. AMT), Link Cost 변경시 alert창 문제 해결
* 2011.07.04 이행지 [CHM-201111961-01] [MAS] Node/Link U/C Adjustment 화면 칼럼명 변경 (Link Cost 컬럼명 변경:USD AMT-> Curr. AMT)
* 2011.10.12 전윤주 [CHM-201113735-01] node, link QTY 컬럼 형식 숫자로 변경, 컬럼 이름 S.LANE 으로 변경
* 2013.08.22 성미영 [CHM-201325654] [ALPS 데이터품질 - MAS validation 로직보완] 7월 대상 건에 대한 진행 요청 건
* 2014.08.27 박은주 [CHM-201431751] [MAS] Link U/C Adjustment 조회/입력조건의 Vendor 추가요청(S/P NO)
*                  Volume incentive cost 단가의 경우 Vendor 별로 관리한다.
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
     * @class ESM_MAS_0137 : ESM_MAS_0137 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0137() {
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
    var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	var srcStndCd = "";

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /*
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    	function processButtonClick(){
    		var sheetObject = sheetObjects[2];
    		var formObject = document.form;

    		try {
    			var srcName = window.event.srcElement.getAttribute("name");
    			switch(srcName) {
    				case "btng_rowadd":
    					doActionIBSheet(sheetObject,formObject,IBINSERT);
    					break;	
    				case "btng_rowdel":
    					doActionIBSheet(sheetObject,formObject,IBDELETE);
    					break;							
    				case "btn_reset":
    					doActionIBSheet(sheetObject,formObject,IBRESET);
                        loadPage();			
    					break;						    
    				case "btn_retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
    				case "btn_save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;					
        			case "btn_downexcel":
        				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        				break;		
        			case "btn_loadexcel":
        				doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
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
    	function loadPage() {
    		for(i=0;i<sheetObjects.length;i++){
    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);
    			sheetObjects[i].RemoveAll();
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		loadingMode = true;
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
            loadingMode = false;
    		tableColumnLoad();	

    	}

    	/**
    	 * 시트 초기설정값, 헤더 정의
    	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	 */
    	function initSheet(sheetObj,sheetNo) {
    		var cnt = 0;
    		var f_table_name = document.form.f_table_name.value;		
    		switch(sheetNo) {
    		case 1:		//sheet1 init
    			with (sheetObj) {
    				SheetWidth = mainTable.clientWidth;//전체 너비 설정
    				if (location.hostname != "") 
    				   InitHostInfo(location.hostname, location.port, page_path);    //Host정보 설정[필수][HostIp, Port, PagePath]
    				MergeSheet = msHeaderOnly;                                       //전체Merge 종류 [선택, Default msNone]
    				Editable = true;                                                 //전체Edit 허용 여부 [선택, Default false]
    				InitRowInfo( 2, 1, 9, 100);                                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitColumnInfo(4, 0, 0, true);                                   //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitHeadMode(false, false, false, true, false,false);            // 해더에서 처리할 수 있는 각종 기능을 설정한다
    				var HeadTitle = "Condition|Condition|Condition|Condition" ;
    				var HeadTitle2 = "|Column Name|Inequality|Value" ;				
    				InitHeadRow(0, HeadTitle, true);                                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(1, HeadTitle2, false);                               //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]				

    				//데이터속성	    [ROW, COL  , DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME               , KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0  , cnt++, dtHiddenStatus , 30   , daCenter , false   , "ibflag"        , false   , ""        ,	dfNone   ,	0        , false     ,	false );												
    				InitDataProperty(0  , cnt++, dtData         , 150  , daLeft   , false   , "colname"       , false   , ""        ,	dfNone   ,	0        , false     ,	false );
                    InitDataProperty(0  , cnt++, dtCombo        , 60   , daCenter , false   , "inequality"    , false   , ""        ,	dfNone   ,	0        , true      ,	false );
                    InitDataProperty(0  , cnt++, dtData         , 100  , daLeft   , false   , "value"         , false   , ""        ,	dfNone   ,	0        , true      ,	 true );
    				InitDataCombo (0, "inequality", combo01Text, combo01Code);							
            		CountPosition  = 0 ;
            		style.height = GetSheetHeight(10) ;
            		// 조건값에 대문자와 숫자 및 기타 기호들만을 허용하도록 적용 2010.06.07 (HJSONG)
            		InitDataValid(0,3,vtEngUpOther,"0123456789~!@#$%^&*()_+{}|:\"<>?`-=[]\\;',./");
            	}
    			break;
    		case 2:		//sheet2 init
    			with (sheetObj) {
    				SheetWidth = mainTable.clientWidth;//전체 너비 설정
    				if (location.hostname != "") 
    				   InitHostInfo(location.hostname, location.port, page_path);    //Host정보 설정[필수][HostIp, Port, PagePath]
    				MergeSheet = msHeaderOnly;                                       //전체Merge 종류 [선택, Default msNone]
    				Editable = false;                                                //전체Edit 허용 여부 [선택, Default false]
    				InitRowInfo( 2, 1, 9, 100);                                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitColumnInfo(5, 0, 0, true);                                   //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitHeadMode(false, false, false, true, false,false);            // 해더에서 처리할 수 있는 각종 기능을 설정한다
    				var HeadTitle = "Usage Help|Usage Help|Usage Help|Usage Help|Usage Help" ;				
    				var HeadTitle2 = "Desciption|Desciption|Example|Example|Example" ;
    				InitHeadRow(0, HeadTitle, true);                                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(1, HeadTitle2, true);                                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]				

    				//데이터속성	    [ROW, COL  , DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME        , KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0  , cnt++, dtData  , 120  , daLeft   , false   , "kind"          , false   , ""        ,	dfNone   ,	0        , false     ,	false );
                    InitDataProperty(0  , cnt++, dtData  , 200  , daLeft   , false   , "desciption"    , false   , ""        ,	dfNone   ,	0        , false     ,	false );
                    InitDataProperty(0  , cnt++, dtData  , 120  , daLeft   , false   , "colName"       , false   , ""        ,	dfNone   ,	0        , false     ,	false );
                    InitDataProperty(0  , cnt++, dtData  , 70   , daCenter , false   , "inEquality"    , false   , ""        ,	dfNone   ,	0        , false     ,	false );                
                    InitDataProperty(0  , cnt++, dtData  , 100  , daLeft   , false   , "value"         , false   , ""        ,	dfNone   ,	0        , false     ,	false );                                
    				
            		CountPosition  = 0 ;
                    RangeBackColor(0, 0, 1, 4) = RgbColor(220, 235, 252);
                    sheetObj.RangeFontColor(0, 0, 1, 4) = RgbColor(0, 100, 255);      		
            		style.height = GetSheetHeight(10) ;	
            		
       				sheetObj.DataInsert(-1);
       				sheetObj.CellValue(sheetObj.lastRow, "kind") = "=, >, >=, <, <=, <>";
       				sheetObj.CellValue(sheetObj.lastRow, "desciption") = "조건과 비교하여 데이터 검색";
       				sheetObj.CellValue(sheetObj.lastRow, "colName") = "COST_YRMON";
       				sheetObj.CellValue(sheetObj.lastRow, "inEquality") = "=";   				
       				sheetObj.CellValue(sheetObj.lastRow, "value") = "'200701'";   	
                    sheetObj.RangeFontColor(sheetObj.lastRow, 4, sheetObj.lastRow, 4) = RgbColor(255, 0  , 0  );      		                   							   				
       				sheetObj.DataInsert(-1);
       				sheetObj.CellValue(sheetObj.lastRow, "kind") = "LIKE";
       				sheetObj.CellValue(sheetObj.lastRow, "desciption") = "포함문자 데이터 검색";
       				sheetObj.CellValue(sheetObj.lastRow, "colName") = "COST_YRMON";
       				sheetObj.CellValue(sheetObj.lastRow, "inEquality") = "LIKE";   				
       				sheetObj.CellValue(sheetObj.lastRow, "value") = "'2007%'";     	
                    sheetObj.RangeFontColor(sheetObj.lastRow, 4, sheetObj.lastRow, 4) = RgbColor(255, 0  , 0  );     							
       				sheetObj.DataInsert(-1);
       				sheetObj.CellValue(sheetObj.lastRow, "kind") = "NOT LIKE";
       				sheetObj.CellValue(sheetObj.lastRow, "desciption") = "포함문자 제외한 데이터 검색";
       				sheetObj.CellValue(sheetObj.lastRow, "colName") = "COST_YRMON";
       				sheetObj.CellValue(sheetObj.lastRow, "inEquality") = "NOT LIKE";   				
       				sheetObj.CellValue(sheetObj.lastRow, "value") = "'2007%'";    
                    sheetObj.RangeFontColor(sheetObj.lastRow, 4, sheetObj.lastRow, 4) = RgbColor(255, 0  , 0  );     				 							
       				sheetObj.DataInsert(-1);
       				sheetObj.CellValue(sheetObj.lastRow, "kind") = "IN";
       				sheetObj.CellValue(sheetObj.lastRow, "desciption") = "문자지정 데이터 검색";
       				sheetObj.CellValue(sheetObj.lastRow, "colName") = "COST_YRMON";
       				sheetObj.CellValue(sheetObj.lastRow, "inEquality") = "IN";   				
       				sheetObj.CellValue(sheetObj.lastRow, "value") = "('200701', '200702')";     
                    sheetObj.RangeFontColor(sheetObj.lastRow, 4, sheetObj.lastRow, 4) = RgbColor(255, 0  , 0  );     								 				
       				sheetObj.DataInsert(-1);
       				sheetObj.CellValue(sheetObj.lastRow, "kind") = "FULL_MTY_CD";
       				sheetObj.CellValue(sheetObj.lastRow, "desciption") = "F : Full, M : Empty";
       				sheetObj.CellValue(sheetObj.lastRow, "colName") = "FULL_MTY_CD";
       				sheetObj.CellValue(sheetObj.lastRow, "inEquality") = "=";   				
       				sheetObj.CellValue(sheetObj.lastRow, "value") = "'M'";     		
                    sheetObj.RangeFontColor(sheetObj.lastRow, 4, sheetObj.lastRow, 4) = RgbColor(255, 0  , 0  );     						   		
       				sheetObj.DataInsert(-1);
       				sheetObj.CellValue(sheetObj.lastRow, "kind") = "CNTR_TPSZ_CD";
       				sheetObj.CellValue(sheetObj.lastRow, "desciption") = "Container Type Size";
       				sheetObj.CellValue(sheetObj.lastRow, "colName") = "CNTR_TPSZ_CD";
       				sheetObj.CellValue(sheetObj.lastRow, "inEquality") = "=";   				
       				sheetObj.CellValue(sheetObj.lastRow, "value") = "'D2'";      
                    sheetObj.RangeFontColor(sheetObj.lastRow, 4, sheetObj.lastRow, 4) = RgbColor(255, 0  , 0  );     								
       				sheetObj.DataInsert(-1);
       				sheetObj.CellValue(sheetObj.lastRow, "kind") = "COST_LOC_GRP_CD";
       				sheetObj.CellValue(sheetObj.lastRow, "desciption") = "N : Node, C : Location, E : ECC, R : RCC";
       				sheetObj.CellValue(sheetObj.lastRow, "colName") = "COST_LOC_GRP_CD";
       				sheetObj.CellValue(sheetObj.lastRow, "inEquality") = "=";   				
       				sheetObj.CellValue(sheetObj.lastRow, "value") = "'R'";    		
                    sheetObj.RangeFontColor(sheetObj.lastRow, 4, sheetObj.lastRow, 4) = RgbColor(255, 0  , 0  );     						 				 						
       				sheetObj.DataInsert(-1);
       				sheetObj.CellValue(sheetObj.lastRow, "kind") = "NOD_CD";
       				sheetObj.CellValue(sheetObj.lastRow, "desciption") = "Yard Code";
       				sheetObj.CellValue(sheetObj.lastRow, "colName") = "NOD_CD";
       				sheetObj.CellValue(sheetObj.lastRow, "inEquality") = "=";   				
       				sheetObj.CellValue(sheetObj.lastRow, "value") = "'USRGB'";    	
                    sheetObj.RangeFontColor(sheetObj.lastRow, 4, sheetObj.lastRow, 4) = RgbColor(255, 0  , 0  );     						   				
       				sheetObj.DataInsert(-1);
       				sheetObj.CellValue(sheetObj.lastRow, "kind") = "MAS_COST_SRC_CD";
       				sheetObj.CellValue(sheetObj.lastRow, "desciption") = "비용계정";
       				sheetObj.CellValue(sheetObj.lastRow, "colName") = "MAS_COST_SRC_CD";
       				sheetObj.CellValue(sheetObj.lastRow, "inEquality") = "=";   				
       				sheetObj.CellValue(sheetObj.lastRow, "value") = "'TMNDMT'"; 
                    sheetObj.RangeFontColor(sheetObj.lastRow, 4, sheetObj.lastRow, 4) = RgbColor(255, 0  , 0  );     				   				   				 				
    			}
    			break;								
    		case 3:		//sheet3 init
    			with (sheetObj) {
    			    reset();
    			    if(f_table_name=="MAS_NOD_AVG_STND_COST"){
        				SheetWidth = mainTable.clientWidth;//전체 너비 설정
        				if (location.hostname != "") 
        				   InitHostInfo(location.hostname, location.port, page_path);    //Host정보 설정[필수][HostIp, Port, PagePath]
        				MergeSheet = msNone;                                             //전체Merge 종류 [선택, Default msNone]
        				Editable = true;                                                 //전체Edit 허용 여부 [선택, Default false]
        				var HeadTitle = "DEL||Year/Month|F/M|Type Size|Loc. Group|Node|Trade|Act. Group|H_Cost|S.Lane|STND Cost|Cost Source|Curr.|Curr. AMT|Fixed|QTY|AMT|Cost Volume Code" ;
        				InitRowInfo( 1, 1, 9, 100);                                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        				InitColumnInfo(ComCountHeadTitle(HeadTitle), 1, 0, true);                                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        				InitHeadMode(true, true, true, true, true,true);                 //해더에서 처리할 수 있는 각종 기능을 설정한다
        				InitHeadRow(0, HeadTitle, true);                                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]				
        
        				//데이터속성	    [ROW, COL  , DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME               , KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        				InitDataProperty(0  , cnt++, dtDelCheck, 50   , daCenter , false   , "dtDelCheck"         , false   , ""        ,	dfNone   ,	0        , true      ,	true    );
        				InitDataProperty(0  , cnt++, dtStatus  , 30   , daCenter , true    , "ibflag"  );
        				InitDataProperty(0  , cnt++, dtData    , 100  , daCenter , false   , "cost_yrmon"         , true    , ""        ,	dfDateYm   ,	0        , false     ,	true    );
                        InitDataProperty(0  , cnt++, dtCombo   , 50   , daCenter , false   , "full_mty_cd"        , true    , ""        ,	dfEngUpKey   ,	0        , false     ,	true    );
                        InitDataProperty(0  , cnt++, dtCombo   , 100  , daCenter , false   , "cntr_tpsz_cd"       , true    , ""        ,	dfNone   ,	0        , false     ,	true    );
                        InitDataProperty(0  , cnt++, dtCombo   , 100  , daCenter , false   , "cost_loc_grp_cd"    , true    , ""        ,	dfEngUpKey   ,	0        , false     ,	true    );
                        InitDataProperty(0  , cnt++, dtData    , 70   , daCenter , false   , "nod_cd"             , true    , ""        ,	dfEngUpKey   ,	0        , false     ,	true ,7   );
                        InitDataProperty(0  , cnt++, dtData    , 70   , daCenter , false   , "trd_cd"             , true    , ""        ,	dfEngUpKey   ,	0        , false     ,	true ,3   );
                        InitDataProperty(0  , cnt++, dtData    , 80   , daCenter , false   , "cost_act_grp_cd"    , true    , ""        ,	dfNone   ,	0        , false     ,	true ,4  );
                        InitDataProperty(0  , cnt++, dtHidden  , 70   , daCenter , false   , "stnd_cost_cd"       , false   , ""        ,	dfNone   ,	0        , false     ,	false   );
                        InitDataProperty(0  , cnt++, dtCombo   , 70   , daCenter , false   , "slan_cd"            , false   , ""        ,	dfNone   ,	0        , false     ,	true    );
                        InitDataProperty(0  , cnt++, dtCombo   , 70   , daCenter , false   , "mas_cost_src_cd_v"  , false   , ""        ,	dfNone   ,	0        , false     ,	true   );
                        InitDataProperty(0  , cnt++, dtData    , 100  , daCenter , false   , "mas_cost_src_cd"    , true    , ""        ,	dfEngUpKey   ,	0        , false     ,	true , 6    );
                        InitDataProperty(0  , cnt++, dtCombo   , 70   , daCenter , false   , "locl_curr_cd"       , false   , ""        ,	dfNone   ,	0        , true      ,	true    );
                        InitDataProperty(0  , cnt++, dtData    , 70   , daRight  , false   , "stnd_cost_usd_amt"  , false   , ""        ,	dfFloat  ,	2        , true      ,	true    );
                        InitDataProperty(0  , cnt++, dtCheckBox, 50   , daCenter , false   , "cost_fx_flg"        , false   , ""        ,	dfNone   ,	0        , true      ,	true    , -1     , false    , true      , ""     , false);
                        InitDataProperty(0  , cnt++, dtData    , 70   , daRight  , false   , "nod_ttl_qty"        , false   , ""        ,	dfFloat   ,	0        , true      ,	true    );
                        InitDataProperty(0  , cnt++, dtData    , 70   , daRight  , false   , "nod_ttl_amt"        , false   , ""        ,	dfFloat  ,	2        , true      ,	true    );
                        InitDataProperty(0  , cnt++, dtData    , 80   , daCenter , false   , "cost_vol_cd"        , false   , ""        ,	dfNone   ,	0        , true      ,	true    );
                        
                        InitDataCombo (0, "full_mty_cd", "F|M", "F|M");                        
    			    } else{
        				SheetWidth = mainTable.clientWidth;//전체 너비 설정
        				if (location.hostname != "") 
        				   InitHostInfo(location.hostname, location.port, page_path);     //Host정보 설정[필수][HostIp, Port, PagePath]
        				MergeSheet = msNone;                                              //전체Merge 종류 [선택, Default msNone]
        				Editable = true;                                                 //전체Edit 허용 여부 [선택, Default false]
        				InitRowInfo( 1, 1, 9, 100);                                       //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        				var HeadTitle = "DEL|STS|Year/Month|From Node|To Node|Type Size|F/M|Cost|STND Cost|Act. Group|Cost Source|S/P No|Loc. Group|Curr.|Curr. AMT|Fixed|QTY|AMT|Cost Volume Code|MTY U/C AMT" ;
        				InitColumnInfo(ComCountHeadTitle(HeadTitle) + 1, 1, 0, true);    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        				InitHeadMode(true, true, true, true, true,true);              //해더에서 처리할 수 있는 각종 기능을 설정한다
        				InitHeadRow(0, HeadTitle, true);                                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]				
        
        				//데이터속성	    [ROW, COL  , DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME               , KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0  , cnt++, dtDelCheck , 50   , daCenter , false   , "dtDelCheck"         , false   , ""        ,   dfNone       ,  0        , true      ,  true      );
                        InitDataProperty(0  , cnt++, dtStatus   , 30   , daCenter , true    , "ibflag" );                                                 
                        InitDataProperty(0  , cnt++, dtData     , 100  , daCenter , false   , "cost_yrmon"         , true    , ""        ,   dfDateYm     ,  0        , false     ,  true      );
                        InitDataProperty(0  , cnt++, dtData     , 80   , daCenter , false   , "lnk_fm_nod_cd"      , true    , ""        ,   dfEngUpKey   ,  0        , false     ,  true , 7  );
                        InitDataProperty(0  , cnt++, dtData     , 80   , daCenter , false   , "lnk_to_nod_cd"      , true    , ""        ,   dfEngUpKey   ,  0        , false     ,  true , 7  );
//                        InitDataProperty(0  , cnt++, dtData     , 50   , daCenter , false   , "co_cd"              , true    , ""        ,   dfNone       ,  0        , false     ,  true , 1  );
                        InitDataProperty(0  , cnt++, dtCombo    , 100  , daCenter , false   , "cntr_tpsz_cd"       , true    , ""        ,  dfNone        ,  0        , false     ,  true      );
                        InitDataProperty(0  , cnt++, dtCombo    , 50   , daCenter , false   , "full_mty_cd"        , true    , ""        ,   dfEngUpKey   ,  0        , false     ,  true      );
                        InitDataProperty(0  , cnt++, dtHidden   , 70   , daCenter , false   , "stnd_cost_cd"       , false   , ""        ,   dfNone       ,  0        , false     ,  false     );
                        InitDataProperty(0  , cnt++, dtCombo    , 70   , daCenter , false   , "mas_cost_src_cd_v"  , false   , ""        ,   dfNone       ,  0        , false     ,  true      );
                        InitDataProperty(0  , cnt++, dtData     , 80   , daCenter , false   , "cost_act_grp_cd"    , true   , ""        ,   dfNone       ,  0        , false     ,  true , 4     );
                        InitDataProperty(0  , cnt++, dtData     , 100  , daCenter , false   , "mas_cost_src_cd"    , true    , ""        ,   dfEngUpKey   ,  0        , false     ,  true , 6  );
                        InitDataProperty(0  , cnt++, dtData     , 100  , daCenter , false   , "vndr_seq"           , true    , ""        ,  dfNone        ,  0        , false     ,  true , 6 , true );
                        InitDataProperty(0  , cnt++, dtCombo    , 100  , daCenter , false   , "cost_loc_grp_cd"    , true    , ""        ,  dfEngUpKey    ,  0        , false     ,  true      );
                        InitDataProperty(0  , cnt++, dtCombo    , 70   , daCenter , false   , "locl_curr_cd"       , false   , ""        ,  dfNone        ,  0        , true      ,  true      );
                        InitDataProperty(0  , cnt++, dtData     , 70   , daRight  , false   , "stnd_cost_usd_amt"  , false   , ""        ,   dfFloat      ,  2        , true      ,  true      );
                        InitDataProperty(0  , cnt++, dtCheckBox , 50   , daCenter , false   , "cost_fx_flg"        , false   , ""        ,   dfNone       ,  0        , true      ,  true ,-1 , false    , true      , ""     , false);
                        InitDataProperty(0  , cnt++, dtData     , 70   , daRight  , false   , "lnk_ttl_qty"        , false   , ""        ,   dfFloat      ,  0        , true      ,  true      );
                        InitDataProperty(0  , cnt++, dtData     , 70   , daRight  , false   , "lnk_ttl_amt"        , false   , ""        ,   dfFloat      ,  2        , true      ,  true      );
                        InitDataProperty(0  , cnt++, dtData     , 150  , daCenter , false   , "cost_vol_cd"        , false   , ""        ,   dfNone       ,  0        , true      ,  true      );
                        InitDataProperty(0  , cnt++, dtData     , 70   , daCenter , false   , "mty_uc_amt"         , false   , ""        ,   dfNone       ,  0        , false     ,  false     );

                        InitDataCombo (0, "full_mty_cd", "F|M", "F|M");
                        InitDataValid(0,  "vndr_seq", vtNumericOnly);

    			    }
    			    
            		CountPosition  = 2 ;
            		style.height = GetSheetHeight(15) ;	            				     		
            		
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


      function sheet3_OnChange(sheetObj, row, col, value){
          if(sheetObj.ColSaveName(col) == "nod_ttl_qty" || sheetObj.ColSaveName(col) == "nod_ttl_amt" ){
              sheetObj.CellValue2(row,"stnd_cost_usd_amt") = 
                  sheetObj.CellValue(row, "nod_ttl_amt")/sheetObj.CellValue(row, "nod_ttl_qty") ;
          }
          if(sheetObj.ColSaveName(col) == "lnk_ttl_qty" || sheetObj.ColSaveName(col) == "lnk_ttl_amt" ){
              sheetObj.CellValue2(row,"stnd_cost_usd_amt") = 
                sheetObj.CellValue(row, "lnk_ttl_amt")/sheetObj.CellValue(row, "lnk_ttl_qty") ;          
          } 
          if(sheetObj.ColSaveName(col) == "mas_cost_src_cd"){
              if(srcStndCd.indexOf(sheetObj.CellValue(row, "mas_cost_src_cd"))>0) {
                  sheetObj.CellValue(row,"mas_cost_src_cd_v") = sheetObj.CellValue(row, "mas_cost_src_cd");       
                  sheetObj.CellValue(row,"stnd_cost_cd") = sheetObj.CellText(row, "mas_cost_src_cd_v");   
              }
              else {
                  sheetObj.CellValue(row,"mas_cost_src_cd_v") = "";       
                  sheetObj.CellValue(row,"stnd_cost_cd") = "";   
              }        
          }     
      }
      
    	// Table 변경 ddlb Change Event
      function tableColumnLoad(){
    		var sheetObject = sheetObjects[0];
    		var formObject = document.form;

    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
      }	
        
      function keyEnter_rslt(){
      	var sheetObject = sheetObjects[2];
      	var formObject = document.form;
      	if (event.keyCode == 13) {
     			doActionIBSheet(sheetObject,formObject,IBSEARCH);
      	}
      } 
      
    	// Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    			case IBCLEAR:          //조회
			        sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = INIT;
					var sXml = sheetObj.GetSearchXml("ESM_MAS_0137GS.do", masFormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0){
						srcStndCd = arrXml[0];
						ComMasSetIBCombo(sheetObjects[2], arrXml[0], "mas_cost_src_cd_v", true, 0);
					}
					if (arrXml.length > 1){
						var f_table_name = document.form.f_table_name.value;
						if(f_table_name != "MAS_LNK_AVG_STND_COST"){
							srcStndCd = arrXml[1];
							ComMasSetIBCombo(sheetObjects[2], arrXml[1], "slan_cd", true, 0);
							var comboText = " |NNN"+sheetObjects[2].GetComboInfo(0,"slan_cd", "Text");
							var comboCode = " |NNN"+sheetObjects[2].GetComboInfo(0,"slan_cd", "Code");
							sheetObjects[2].InitDataCombo(0, "slan_cd", comboText, comboCode);
							//setIBCombo(sheetObjects[2], arrXml[1], "slan_cd", true, 0);
						}
					}					

					if (arrXml.length > 2){
						ComMasSetIBCombo(sheetObjects[2], arrXml[2], "locl_curr_cd", true, 0);
					}
					
					if (arrXml.length > 3){
						ComMasSetIBCombo(sheetObjects[2], arrXml[3], "cost_loc_grp_cd", true, 0);
					}
					
					if (arrXml.length > 4){
						setIBCombo(sheetObjects[2], arrXml[4], "cntr_tpsz_cd", true, 0);
					}
					ComOpenWait(false);
					break	
					
    			case IBINSERT:                  // 입력
   				    var sRow = sheetObj.DataInsert(-1);  
	   				if(formObj.f_table_name.selectedIndex == 0) {
	       				sheetObj.CellValue2(sRow, "trd_cd") = "NNN";
	       				sheetObj.CellValue2(sRow, "cost_act_grp_cd") = "NNNN";
	       				sheetObj.CellValue2(sRow, "slan_cd") = "NNN";	       				
	   				} else if(formObj.f_table_name.selectedIndex == 1) {
	       				sheetObj.CellValue2(sRow, "co_cd") = "H";	   					
	       				sheetObj.CellValue2(sRow, "vndr_seq") = "000000";
	   				}
       				break;	
    			case IBDELETE:                  // 입력
       				sheetObj.RowDelete(sheetObj.SelectRow, false);
       				break;	   								
    			case IBRESET:                  // RESET
                    sheetObj.reset();
    				break;		    
    			case IBSEARCH:		           //조회
    			    if(sheetObj==sheetObjects[0]){              // 조건창 
    			    	if(formObj.f_table_name.selectedIndex == 0) {
    			    		formObj.f_cmd.value = SEARCH01;	
    			    	} else {
    			    		formObj.f_cmd.value = SEARCH02;	
    			    	}
        				sheetObj.DoSearch4Post("ESM_MAS_0137GS.do", masFormQueryString(formObj));  				                   
    			    }
    			    else if(sheetObj==sheetObjects[2]){        // 검색결과창 
                        if(!validateForm(sheetObjects[0], formObj, sAction)) {
        					return false;
        				}
    			    	// 업무처리중 버튼사용 금지 처리
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    			    	if(formObj.f_table_name.selectedIndex == 0) {
    			    		formObj.f_cmd.value = SEARCH03;	
    			    	} else {
    			    		formObj.f_cmd.value = SEARCH04;	
    			    	}
                        var params = sheetObjects[0].GetSaveString(false ,false);                       
                        sheetObj.DoSearch4Post("ESM_MAS_0137GS.do", params+"&"+masFormQueryString(formObj));
                        ComOpenWait(false);
    			    }
    				break;	
    			case IBSAVE:                  // 저장
    				if(!validateForm(sheetObj, formObj, sAction)) {
    					return false;
    				}    				
    				// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
        			formObj.f_cmd.value = MULTI;
        			sheetObj.DoSave("ESM_MAS_0137GS.do", masFormQueryString(formObj), -1, true);			
        			ComOpenWait(false);
    				break;					
               case IBDOWNEXCEL:            //엑셀 다운로드
    				//sheetObj.SpeedDown2Excel(-1, true, true);
    				var excelType = selectDownExcelMethod(sheetObj);
    				switch (excelType) {
    					case "AY":
    						sheetObj.Down2Excel(0, false, false, true, "", "", true);
    						break;
    					case "DY":
    						sheetObj.Down2Excel(-1, false, false, true, "", "", true);
    						break;
    					case "AN":
    						sheetObj.SpeedDown2Excel(0, false, false, "", "", true);
    						break;
    					case "DN":
    						sheetObj.SpeedDown2Excel(-1, false, false, "", "", true);
    						break;
    				}
    				break;	
    			case IBLOADEXCEL:                  // 엑셀로드
                    sheetObj.LoadExcel(-1, 1, "", -1, -1, ""); 
    				break;											
    		}
    	}

      /**
       * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
       * <br><b>Example :</b>
       * <pre>
       *     if (validateForm(sheetObj, document.form, IBSAVE)) {
       *         로직처리;
       *     }
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {form} formObj 필수 html form object
       * @param {int} sAction 필수 프로세스 플래그 상수
       * @returns bool <br>
       *          true  : 폼입력값이 유효할 경우<br>
       *          false : 폼입력값이 유효하지 않을 경우
     	 * @author 최성민
     	 * @version 2011.10.13
       */
  	function validateForm(sheetObj, formObj, sAction){
  		switch (sAction) {
  	 		case IBSEARCH: // 조회
  	 			if( sheetObj.FindText("value", "\'", 1, 2) == -1){
  	      			ComShowCodeMessage('MAS10002','condition');
  	      			return false;
  	      		}
  	 			break;

  	 		case IBSAVE: //Save
  	 			var sTableName = formObj.f_table_name.value;  	 			
  	 			if(sTableName == "MAS_NOD_AVG_STND_COST") {
  	 				var dupRow = sheetObj.ColValueDup("cost_yrmon|full_mty_cd|cntr_tpsz_cd|cost_loc_grp_cd|nod_cd" +
  	 						"|trd_cd|cost_act_grp_cd|slan_cd|mas_cost_src_cd_v|mas_cost_src_cd", false);
  	 				if (dupRow >= 0) {
  	  	            	sheetObj.SelectRow = dupRow;
  	  	              	ComShowCodeMessage("COM12115", "Unit Cost");
  	  	             	return false;
  	  	            }
  	 			} else if(sTableName == "MAS_LNK_AVG_STND_COST") {
  	 				var dupRow = sheetObj.ColValueDup("cost_yrmon|lnk_fm_nod_cd|lnk_to_nod_cd|co_cd|cntr_tpsz_cd" +
  	 						"|full_mty_cd|mas_cost_src_cd_v|mas_cost_src_cd|cost_loc_grp_cd|vndr_seq", false);
  	 				if (dupRow >= 0) {
  	  	            	sheetObj.SelectRow = dupRow;
  	  	              	ComShowCodeMessage("COM12115", "Unit Cost");
  	  	             	return false;
  	  	            }
  	 			}  	 		
	  	 		break;
  		}
  		return true;
  	}

   /*
    * TypeSize, Currency 등 sheet 내의 콤보박스 세팅하는 메소드
    */      
   function setIBCombo(sheetObj, sXml, title, iBlank, sCol,iRow, dCode, dText, bFlag){
       var showCol = 0;
       if (ComGetTotalRows(sXml) == "0") return;
       if (bFlag == undefined || bFlag == ""){
           bFlag = false;
       }
       if (sCol != undefined && sCol !=""){
           showCol = sCol;
       }
       if (iBlank == undefined || iBlank == ""){
           iBlank = false;
       }
       if (iRow == undefined || iBlank == ""){
       	iRow = 0;
       }
       var arrData = ComXml2ComboString(sXml, "code", "name");
       if (bFlag == true && arrData != null){
           var arrCode = arrData[0].split("|");
           var arrName = arrData[1].split("|");
           var conData = "";
           for(i=0; i < arrName.length;i++){
               if(i==0){
                   arrName[i] = arrCode[i]+"\t"+arrName[i];
               }else{
                   arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
               }
               conData = conData.concat(arrName[i]);
           }
           arrData[1] = conData;
       }
       if(iBlank){
           arrData[0] = " |20|40|BOX|" + arrData[0];
           arrData[1] = " |20|40|BOX|" + arrData[1];
       }
       if (arrData != null){
       	  if (iRow == 0){
       	    sheetObj.InitDataCombo(iRow,title, arrData[1], arrData[0],dText, dCode, showCol);
          }else{
       		sheetObj.CellComboItem(iRow,title, arrData[1],arrData[0]);
       	  }
       }
   }
   
