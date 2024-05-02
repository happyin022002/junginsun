/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1046.js
*@FileTitle : +/- Others Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.10 김종준
* 1.0 Creation
=========================================================*/
// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var IBSEARCH01  = 29;

var lease_term_cd = "";
var lease_term_nm = "";
var yd_cd = "";
var yd_nm = "";
var date_list_by_week = "";
var headCount = 0;
var save_flag = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         	var shtCnt = 0;
         	var sheetObject = sheetObjects[shtCnt++];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_RowAdd":
						sheetObject.DataInsert(-1);
						sheetObject.CellValue2(sheetObject.SelectRow,"loc_grp_cd") =formObject.loc_grp_cd.value ;
						sheetObject.CellValue2(sheetObject.SelectRow,"loc_cd") =formObject.loc_cd.value ;
						sheetObject.CellValue2(sheetObject.SelectRow,"fcast_yrwk") =ComTrimAll(formObject.fcast_yrwk.value, "-", "");
						sheetObject.CellValue2(sheetObject.SelectRow,"inp_yrwk") =ComTrimAll(formObject.inp_yrwk.value, "-", "");
						sheetObject.CellValue2(sheetObject.SelectRow,"mty_bal_otr_tp_cd") =formObject.tp_cd.value ;
						setGtotalCaluValue();
						break;
					
					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;
					case "btn_Delete":
						if(sheetObject.FindCheckedRow("del_chk")=="") {
							ComShowCodeMessage("CIM00010");
						} else { 
							doActionIBSheet(sheetObject,formObject,IBDELETE);
						}
						break;
	                case "btn_downExcel":
	                    if(sheetObject.RowCount > 0){
		                	doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
	                    }
	                    break;
					
					case "btn_Close":
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
    function loadPage(repoFlag) {

        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1,repoFlag);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        
        //부모창 DRY,SPCL,ALL 연동
        if ( document.form.search_flag.value == '0' ) {
            document.form.viewFlag[0].checked = true;
            sheetObjects[0].FrozenCols = 4;
            setCellHidden(sheetObjects[0],false,true);
        } else if ( document.form.search_flag.value == '1' ) {
            document.form.viewFlag[1].checked = true;
            sheetObjects[0].FrozenCols = 9;
            //sheetObjects[0].FrozenCols = 11;
            setCellHidden(sheetObjects[0],true,false);
        } else {  // REEFER
            document.form.viewFlag[2].checked = true;
            sheetObjects[0].FrozenCols = 3;
            setCellHidden(sheetObjects[0],false,false);
        }
		
        if(document.form.save_option.value == "0"){
 		   ComBtnEnable("btn_Save");
 		   ComBtnEnable("btn_RowAdd");
 		   ComBtnEnable("btn_Delete");
 		   sheetObjects[0].Editable = true;
 	   }else{
 		   ComBtnDisable("btn_Save");
 		   ComBtnDisable("btn_RowAdd");
 		   ComBtnDisable("btn_Delete");
 		   sheetObjects[0].Editable = false;
 	   }
    }

    /**
     * EES_CIM_0032 화면의 값 세팅및 계산식 적용 FUNCTION 호출 
     */
    function callParentFnc() {
		window.close();    	
    }
    
    /**
     * 초기 이벤트 등록 
     */
    function initControl() {
     	axon_event.addListenerForm('click', 'viewFlag_click', form);
     	
    }  

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,repoFlag) {

        var cnt = 0;
        var shtID = sheetObj.id;

        switch(shtID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 262;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    var HeadTitle1 = "Sel.|"+repoFlag+" Others|G.TTL|D.TTL|D2|D4|D5|D7|S.TTL|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|Remark(s)|||||||";
										
                    headCount = ComCountHeadTitle(HeadTitle1);                    

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    FrozenCols = 4;
                    CountPosition = 0;  //페이지카운트 없애기
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDummyCheck,		30,		daCenter,	true,	"del_chk",			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,	"fctr_ctnt",		true,	"",	dfNone,         0,     true,       true,   50);
                    InitDataProperty(0, cnt++ , dtAutoSum,      	65,   	daRight,	true,	"g_total",			false,  "", dfInteger,		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtAutoSum,      	65,   	daRight,	true,	"d_total",			false,  "", dfInteger,		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"d2_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"d4_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"d5_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"d7_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,      	65,   	daRight,	true,	"s_total",			false,  "", dfInteger,		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"r2_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"r5_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"r9_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"o2_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"s2_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"o4_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"s4_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"o5_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"f2_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"a2_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"f4_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"a4_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"f5_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtAutoSum,			50,   	daRight,  	true,	"a5_fcast_qty",		false,  "", dfInteger,		0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,				100,	daLeft,		true,	"diff_rmk",  		false,	"",	dfNone,			0,     true,       true, 100);
                    InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,	"loc_grp_cd",		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,	"loc_cd",  			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,	"fcast_yrwk",  		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,	"inp_yrwk",  		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,	"cre_seq",  		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,	"mty_bal_otr_tp_cd",false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 	30,  	daCenter, 	false,  "ibflag");
                    
                    InitDataValid(0, "fctr_ctnt", vtEngOther, "0123456789-~[]{}_|*&^%$#@! "); //영문과 숫자
                    InitDataValid(0, "diff_rmk", vtEngOther, "0123456789-~[]{}_|*&^%$#@! "); //영문과 숫자
                    viewFlag_chk(sheetObj)
                }
                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리
     */	
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;  
        switch(sAction) {

			case IBSEARCH:      //조회
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true); 
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.Redraw = false;
    			sheetObj.DoSearch("EES_EQR_1046GS.do",FormQueryString(formObj));
    			ComOpenWait(false); 
    			break;
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction))
					
				formObj.f_cmd.value = MULTI;
				if (!ComShowCodeConfirm("COM130101")) return;
				sheetObj.DoSave("EES_EQR_1046GS.do",FormQueryString(formObj),"ibflag",false);
				break;
			case IBDELETE:		// 삭제
				if(sheetObj.FindCheckedRow("del_chk") != ""){
					ComRowHideDelete(sheetObj,"del_chk"); 
				}
				if(sheetObj.RowCount > 0){ 
	                for ( var j=0; j<headCount; j++ ) {
	                	//if ( j !=0 && j !=1  && j !=2  && j !=8  && j !=21 && j !=22 && j !=23 && j !=24 && j !=25  && j !=26 ) {
	                	//if ( j !=0 && j !=1  && j !=2  && j !=8  && j !=22 && j !=23 && j !=24 && j !=25 && j !=26  && j !=27 ) {	
	                	if ( j !=0 && j !=1  && j !=2  && j !=8  && j !=23 && j !=24 && j !=25 && j !=26 && j !=27  && j !=28 ) {	
	        				setCaluValue(sheetObj.ColSaveName(j).substring(0,2),sheetObj);
	                	}
	                }
	                setGtotalCaluValue();	                
				}
                break;
            case IBDOWNEXCEL:      // 입력
            	sheetObj.Down2Excel(0,false,true,true,'','',false,false,'',false,'del_chk|loc_cd|fcast_yrwk|inp_yrwk|cre_seq|mty_bal_otr_tp_cd|ibflag','');
               break;                
			case IBINSERT:      // 입력
				break;
        }
    }
    
    /**
     * g_total 계산식
     */	
	function setGtotalCaluValue() {
        var sumGtotal = 0;
        if ( document.form.viewFlag[2].checked ) {
        	for ( var i=1; i<=sheetObjects[0].rowCount; i++ ) {
        		if ( sheetObjects[0].RowStatus(i) != "D" ) {
        			sumGtotal = sumGtotal + eval(ComReplaceStr(sheetObjects[0].CellValue(i, "g_total"),",",""));
        		}
        	}
        	sheetObjects[0].CellValue2(sheetObjects[0].LastRow,"g_total") =  ComAddComma(sumGtotal);
        }
	}    
    
    /**
     * total 계산식
     */	
	function setCaluValue(tpsz,sheetObj) {
		var sumTpsz = 0;
		var sumGtotal = 0;
		var sumDtotal = 0;
		var sumStotal = 0;
		for ( var i=1; i<=sheetObj.rowCount; i++ ) {
			if ( sheetObj.RowStatus(i) != "D" ) {
				if ( sheetObj.CellValue(i, tpsz+"_fcast_qty") !="" ) {
					sumTpsz = sumTpsz + eval(ComReplaceStr(sheetObj.CellValue(i, tpsz+"_fcast_qty"),",",""));
				}
				if (tpsz =="g_" ) {
					sumGtotal = sumGtotal + eval(ComReplaceStr(sheetObj.CellValue(i, "g_total"),",",""));
				}
				if (tpsz =="d_" ) {
					sumDtotal = sumDtotal + eval(ComReplaceStr(sheetObj.CellValue(i, "d_total"),",",""));
				}
				if (tpsz =="s_" ) {
					sumStotal = sumStotal + eval(ComReplaceStr(sheetObj.CellValue(i, "s_total"),",",""));
				}
			}
		}

		var colGtotal = 0;
		var colDtotal = 0;
		var colStotal = 0;
				
        for ( var j=0; j<headCount; j++ ) {
        	//if ( j !=0 && j !=1  && j !=2  && j !=3 && j !=8 && j !=21 && j !=22 && j !=23 && j !=24 && j !=25  && j !=26 && j != 27 && j !=28) {
        	//if ( j !=0 && j !=1  && j !=2  && j !=3 && j !=8 && j !=22 && j !=23 && j !=24 && j !=25 && j !=26  && j !=27 && j != 28 && j !=29) {
        	if ( j !=0 && j !=1  && j !=2  && j !=3 && j !=8 && j !=23 && j !=24 && j !=25 && j !=26 && j !=27  && j !=28 && j != 29 && j !=30) {        		
    			if ( sheetObj.CellValue(sheetObj.SelectRow, sheetObj.ColSaveName(j)) !="" ) {
	        		if ( sheetObj.ColSaveName(j).substring(0,1) == 'd' ) {
        				colDtotal = colDtotal + eval(ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, sheetObj.ColSaveName(j)),",",""));
	        		} 
	        		if ( sheetObj.ColSaveName(j).substring(0,1) != 'd' ) {
	        			colStotal = colStotal + eval(ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, sheetObj.ColSaveName(j)),",",""));
	        		}
    			}
        	}
        }
        
		if (tpsz =="g_" ) {
			sheetObj.CellValue2(sheetObj.LastRow,"g_total") =  ComAddComma(sumGtotal);
		} else if (tpsz =="d_" ) {
			sheetObj.CellValue2(sheetObj.LastRow,"d_total") =  ComAddComma(sumDtotal);
		} else if (tpsz =="s_" ) {
			sheetObj.CellValue2(sheetObj.LastRow,"s_total") =  ComAddComma(sumStotal);
		} else {
			sheetObj.CellValue2(sheetObj.LastRow,tpsz+"_fcast_qty") =  ComAddComma(sumTpsz);
		}
        colGtotal = colDtotal+colStotal;
		sheetObj.CellValue2(sheetObj.SelectRow,"g_total") =  ComAddComma(colGtotal);
		sheetObj.CellValue2(sheetObj.SelectRow,"d_total") =  ComAddComma(colDtotal);
		sheetObj.CellValue2(sheetObj.SelectRow,"s_total") =  ComAddComma(colStotal);

	}

    /**
     * 셀에 키입력 했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
    function sheet1_OnAfterEdit(sheetObj, Row, Col, KeyCode, Shift) {	
    	switch (sheetObj.ColSaveName(Col)) {
    		case "d2_fcast_qty":
    			setCaluValue("d2",sheetObj);	   //MTY Balance계산식
       			break;
    		case "d4_fcast_qty":
    			setCaluValue("d4",sheetObj);	   //MTY Balance계산식
       			break;
    		case "d5_fcast_qty":
    			setCaluValue("d5",sheetObj);	   //MTY Balance계산식
       			break;
    		case "d7_fcast_qty":
    			setCaluValue("d7",sheetObj);	   //MTY Balance계산식
       			break;
    		case "r2_fcast_qty":
    			setCaluValue("r2",sheetObj);	   //MTY Balance계산식
       			break;
    		case "r5_fcast_qty":
    			setCaluValue("r5",sheetObj);	   //MTY Balance계산식
       			break;
    		case "r9_fcast_qty":
    			setCaluValue("r9",sheetObj);	   //MTY Balance계산식
       			break;
    		case "o2_fcast_qty":
    			setCaluValue("o2",sheetObj);	   //MTY Balance계산식
       			break;
    		case "s2_fcast_qty":
    			setCaluValue("s2",sheetObj);	   //MTY Balance계산식
       			break;
    		case "o4_fcast_qty":
    			setCaluValue("o4",sheetObj);	   //MTY Balance계산식
       			break;
    		case "s4_fcast_qty":
    			setCaluValue("s4",sheetObj);	   //MTY Balance계산식
       			break;
    		case "o5_fcast_qty":
    			setCaluValue("o5",sheetObj);	   //MTY Balance계산식
       			break;
    		case "f2_fcast_qty":
    			setCaluValue("f2",sheetObj);	   //MTY Balance계산식
       			break;
    		case "a2_fcast_qty":
    			setCaluValue("a2",sheetObj);	   //MTY Balance계산식
       			break;
    		case "f4_fcast_qty":
    			setCaluValue("f4",sheetObj);	   //MTY Balance계산식
       			break;
    		case "a4_fcast_qty":
    			setCaluValue("a4",sheetObj);	   //MTY Balance계산식
       			break;
    		case "f5_fcast_qty":
    			setCaluValue("f5",sheetObj);	   //MTY Balance계산식
       			break;
    		case "a5_fcast_qty":
    			setCaluValue("a5",sheetObj);	   //MTY Balance계산식
       			break;
    	} 
    	setGtotalCaluValue();
    }	
    
    /**
     * DRY,SPLC(RF, OT, FR), ALL 체크시 이벤트 정의     
     */
    function viewFlag_click(sheetObj) {
		switch (event.srcElement.name) {
		case "viewFlag":
			if ( document.form.viewFlag[0].checked ) {
				sheetObjects[0].SelectCell(0, "d2_fcast_qty", true);
				sheetObjects[0].FrozenCols = 4;
				setCellHidden(sheetObjects[0],false,true);
			} else if ( document.form.viewFlag[1].checked ) {  // SPCL
				sheetObjects[0].SelectCell(0, "r2_fcast_qty", true); 
				//sheetObjects[0].FrozenCols = 9;
				sheetObjects[0].FrozenCols = 11;
				setCellHidden(sheetObjects[0],true,false);
			} else if ( document.form.viewFlag[2].checked ) {
				sheetObjects[0].SelectCell(0, "d2_fcast_qty", true);
				sheetObjects[0].FrozenCols = 3;
				setCellHidden(sheetObjects[0],false,false);
			}
			break;
		}
    }
    /**
     * DRY,SPLC(RF, OT, FR), ALL 체크시 이벤트 정의     
     */
    function viewFlag_chk(sheetObj) {
		if ( document.form.viewFlag[0].checked ) {
			setCellHidden(sheetObj,false,true);
		} else if ( document.form.viewFlag[1].checked ) {
			setCellHidden(sheetObj,true,false);
		} else if ( document.form.viewFlag[2].checked ) {
			setCellHidden(sheetObj,false,false);
		}
    }

    /**
     * 관리대상 EQ TP/SZ를 결정
     */
    function setCellHidden(sheetObj,showFlag1,showFlag2) {
    	if ( showFlag1==false && showFlag2==false ) {
    		sheetObj.ColHidden("g_total") = false;
    	} else {
    		sheetObj.ColHidden("g_total") = true; 
    	}
		if ( showFlag1==false && showFlag2==false ) {
			sheetObj.ColHidden("d_total") = true;
		} else {
			sheetObj.ColHidden("d_total") = showFlag1;
		}
			
		sheetObj.ColHidden("d2_fcast_qty") = showFlag1;
		sheetObj.ColHidden("d4_fcast_qty") = showFlag1;
		sheetObj.ColHidden("d5_fcast_qty") = showFlag1;
		sheetObj.ColHidden("d7_fcast_qty") = showFlag1;
 
		if ( showFlag1==false && showFlag2==false ) {
			sheetObj.ColHidden("s_total") = true;
		} else {
			sheetObj.ColHidden("s_total") = showFlag2;
		}
		sheetObj.ColHidden("r2_fcast_qty") = showFlag2;
		sheetObj.ColHidden("r5_fcast_qty") = showFlag2;
		sheetObj.ColHidden("r9_fcast_qty") = showFlag2;
		sheetObj.ColHidden("o2_fcast_qty") = showFlag2;
		sheetObj.ColHidden("s2_fcast_qty") = showFlag2;
		sheetObj.ColHidden("o4_fcast_qty") = showFlag2;
		sheetObj.ColHidden("s4_fcast_qty") = showFlag2;
		sheetObj.ColHidden("o5_fcast_qty") = showFlag2;
		sheetObj.ColHidden("f2_fcast_qty") = showFlag2;
		sheetObj.ColHidden("a2_fcast_qty") = showFlag2;
		sheetObj.ColHidden("f4_fcast_qty") = showFlag2;
		sheetObj.ColHidden("a4_fcast_qty") = showFlag2;
		sheetObj.ColHidden("a5_fcast_qty") = showFlag2;
		sheetObj.ColHidden("f5_fcast_qty") = showFlag2;
    }
    
    /**
     * sheet1 조회종료
     * sheet1 조회종료후 이벤트 호출
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		sheetObj.EditableColor =   sheetObj.RgbColor(0,0,0);
		sheetObj.UnEditableColor  =   sheetObj.RgbColor(0,0,0);
		for ( var i=0; i<=sheetObj.rowCount; i++ ) {
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(0,0,0); ;
		}
		sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.WebColor2SysColor("#D3EBED");
		sheetObj.CellValue2(sheetObj.LastRow,"del_chk") =  "";
		sheetObj.CellValue2(sheetObj.LastRow,"fctr_ctnt") =  "G.Total";
		sheetObj.SetMergeCell (sheetObj.LastRow, 1, 0, 1);
		sheetObj.SumFontBold = true;
		sheetObj.CellAlign(sheetObj.LastRow,"lstm_cd") = daCenter;		
		sheetObj.SelectHighLight = false;
		sheetObj.Redraw = true;
	}
	
    /**
     * 저장 완료시 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		save_flag = true;
		if ( ErrMsg == "" ) {
			if ( save_flag ) { 
		    	var opener_obj = window.dialogArguments;
				//opener_obj.popupEditFlg = "Y";
		    	
				//for ( var j=4; j<=20; j++ ) { // D2 ~F5
				//for ( var j=4; j<=21; j++ ) { // D2 ~F5	
				for ( var j=4; j<=22; j++ ) { // D2 ~A5	
					if(j==8)
					   j++; // "s_total" 건너뛰기
					
	    			if ( sheetObjects[0].rowCount > 0 ) {
	    				opener_obj.setOwOnHireValue(sheetObjects[0].ColSaveName(j), sheetObjects[0].CellValue(sheetObjects[0].LastRow,sheetObjects[0].ColSaveName(j)));
	    			} else {
	    				opener_obj.setOwOnHireValue(sheetObjects[0].ColSaveName(j), 0);
	    			}
	            }
                opener_obj.calcBalance(); //EES_EQR_1001 재계산
                opener_obj.calcAllTotal();
			}
			ComShowCodeMessage("EQR01001");
		}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
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