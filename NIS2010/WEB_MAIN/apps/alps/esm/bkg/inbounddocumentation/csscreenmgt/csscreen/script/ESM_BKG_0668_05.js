/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0668_05.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.16 안진응
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
     * @class esm_bkg_0668_05 : esm_bkg_0668_05 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0668_05() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.setTabObject           = setTabObject;
    }

    /* 개발자 작업  */

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var t4sheet1 = 0;
    
    var comboFlg = null;
    var cntrQtySum = 0;
    
    var chgFlag = null;
    var frt_term_cd = null;

    var t6previewSheet = 1;

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

//            document.form.bkg_no.value = "TAOYTS93P05";
			
			if (document.form.bkg_no.value != "") {
				fnSearch();
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
//	            case "sheet2":
//	            	
//	                with (sheetObj) {
//	                    // 높이 설정
//	                    style.height = 0;
//	                    //전체 너비 설정
//	                    SheetWidth = mainTable.clientWidth;
//	
//	                    //Host정보 설정[필수][HostIp, Port, PagePath]
//	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//	
//	                    //전체Merge 종류 [선택, Default msNone]
//	                    MergeSheet = msHeaderOnly;
//	
//	                   //전체Edit 허용 여부 [선택, Default false]
//	                    Editable = true;
//	
//	                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//	                    InitRowInfo( 1, 1, 3, 100);
//	
//	                    var HeadTitle = "ibflag|partial|bl_no|bkg_no|split_no|bl_tp_cd";
//	                    var headCount = ComCountHeadTitle(HeadTitle);
//	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//	                    InitColumnInfo(headCount, 0, 0, true);
//	
//	                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//	                    InitHeadMode(true, false, true, true, false,false)
//	
//	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//	                    InitHeadRow(0, HeadTitle, true);
//	
//	                    prefix = "sheet2_";
//	                    
//	                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//						InitDataProperty(0, cnt++ , dtHiddenStatus,     30,	daCenter,  true,	 prefix + "ibflag");
//						InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "partial",    		false,          "",      dfNone,      0,     false);
//						InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "bl_no",            	false,          "",      dfNone,      0,     false);
//						InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "bkg_no",   		    false,          "",      dfNone,      0,     false);
//						InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "split_flg", 		    false,          "",      dfNone,      0,     false);
//						InitDataProperty(0, cnt++ , dtData,			    30,	daCenter,	false,	 prefix + "bl_tp_cd",		    false,		    "",		dfNone,			0,		false,		true);
//						
//						CountPosition = 0;
//	
//	               }
//	            	break;
			
                      
   				case "t4sheet1":      //t4sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 390;
                        
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

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(10, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, false, true, true, false,false)

                        var HeadTitle = "Seq.|C|Code|Q'ty|Type|ENTRY NUMBER|RECEIVE DATE/TIME|SCAC|CUS|Remark(s)";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtSeq,  35,	daCenter,  false, "seq");
						InitDataProperty(0, cnt++ , dtData, 20,	daCenter,  false, "cstms_clr_cd",false,  "",  dfNone,      	0, false,true);
						InitDataProperty(0, cnt++ , dtData, 40,	daCenter,  false, "dspo_cd",  	false,  "",  dfNone,      	0, false,true);
						InitDataProperty(0, cnt++ , dtData,	50, daRight,   false, "cntr_qty",   false,  "",  dfNone,      	0, false,true);
						InitDataProperty(0, cnt++ , dtData,	40,	daCenter,  false, "entr_tp_no", false,  "",  dfNone,      	0, false,true);
						InitDataProperty(0, cnt++ , dtData, 150,daLeft,    false, "entr_no",    false,  "",  dfNone,      	0, false,true);
						InitDataProperty(0, cnt++ , dtData, 150,daCenter,  false, "arr_dt", 	false,  "",  dfUserFormat2, 0, false,true);
						InitDataProperty(0, cnt++ , dtData, 50,	daCenter,  false, "scac_cd",    false,  "",  dfNone,      	0, false,true);
						InitDataProperty(0, cnt++ , dtData, 60,	daCenter,  false, "rcv_loc_cd", false,  "",  dfNone,      	0, false,true);
						InitDataProperty(0, cnt++ , dtData, 180,daLeft,    false, "cstms_rmk1", false,  "",  dfNone,      	0, false,true);

						InitUserFormat2(0, "arr_dt", "####-##-## ##:##", "-|:" );
    					CountPosition = 0;
    					WordWrap = true;

                   	}
                    break;
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            //sheetObj.ShowDebugMsg = false;
            switch(sAction) {

               case IBSEARCH:      //조회
                    
                	ComOpenWait(true);
		                
	           		sheetObjects[t4sheet1].WaitImageVisible = false;
           			
   	                formObj.f_cmd.value = SEARCH;
		            sheetObj.DoSearch("ESM_BKG_0668_05GS.do", FormQueryString(formObj));
		            
		    		for(var i=1;i<sheetObj.RowCount + 1;i++){
						if(sheetObj.Cellvalue(i, "scac_cd") != 'SMLM'){
							sheetObj.CellFontColor(i,"scac_cd") = sheetObj.RgbColor(0,0,255);
						}
		    			
		    		}
		            sheetObjects[t4sheet1].WaitImageVisible = true;
	         		ComOpenWait(false);

                    break;
            }
        }
	        
    //화면의 조회 처리 모듈을 통합적으로 관리한다.
    function fnSearch() {
   		doActionIBSheet(sheetObjects[t4sheet1],document.form,IBSEARCH);        						
    }

    function fnQueryExec(bkg_no) {
    	if (bkg_no != "") {
        	
    		document.form.bkg_no.value = bkg_no;
    		fnSearch();
        }     	
    }    
/* 개발자 작업  끝 */