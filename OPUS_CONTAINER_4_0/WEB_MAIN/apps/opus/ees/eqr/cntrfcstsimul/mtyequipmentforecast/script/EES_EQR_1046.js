/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1046.js
*@FileTitle  : +/- Others Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var IBSEARCH01=29;
var lease_term_cd="";
var lease_term_nm="";
var yd_cd="";
var yd_nm="";
var date_list_by_week="";
var headCount=0;
var save_flag=false;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     	var shtCnt=0;
     	var sheetObject=sheetObjects[shtCnt++];
         /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_RowAdd":
						sheetObject.DataInsert(-1);
						sheetObject.SetCellValue(sheetObject.GetSelectRow(),"loc_grp_cd",formObject.loc_grp_cd.value ,0);
						sheetObject.SetCellValue(sheetObject.GetSelectRow(),"loc_cd",formObject.loc_cd.value ,0);
						sheetObject.SetCellValue(sheetObject.GetSelectRow(),"fcast_yrwk",ComTrimAll(formObject.fcast_yrwk.value, "-", ""),0);
						sheetObject.SetCellValue(sheetObject.GetSelectRow(),"inp_yrwk",ComTrimAll(formObject.inp_yrwk.value, "-", ""),0);
						sheetObject.SetCellValue(sheetObject.GetSelectRow(),"mty_bal_otr_tp_cd",formObject.tp_cd.value ,0);
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
		                doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
	                    break;
					case "btn_Close":
						ComClosePopup(); 
	        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
        //부모창 DRY,SPCL,ALL 연동
        //var opener_obj = window.dialogArguments;
//        var viewFlag = opener_obj.chkFlag_chk();
//        if ( viewFlag == 'DRY' ) {
//        	document.form.viewFlag[0].checked = true;
//        	sheetObjects[0].FrozenCols = 4;
//    		setCellHidden(sheetObjects[0],false,true);
//        } else if ( viewFlag == 'SPCL' ) {
//        	document.form.viewFlag[1].checked = true;
//        	sheetObjects[0].FrozenCols = 9;
//    		setCellHidden(sheetObjects[0],true,false);
//        } else if ( viewFlag == 'ALL' ) {
//        	document.form.viewFlag[2].checked = true;
//        	sheetObjects[0].FrozenCols = 3;
//    		setCellHidden(sheetObjects[0],false,false);
//        }
       // var viewFlag = opener_obj.chkFlag_chk();
        if ( document.form.search_flag.value == '0' ) {
            document.form.viewFlag[0].checked=true;
            //sheetObjects[0].FrozenCols=4;
            setCellHidden(sheetObjects[0],false,true);
        } else if ( document.form.search_flag.value == '1' ) {
            document.form.viewFlag[1].checked=true;
            //sheetObjects[0].FrozenCols=9;
            setCellHidden(sheetObjects[0],true,false);
        } else {
            document.form.viewFlag[2].checked=true;
            //sheetObjects[0].FrozenCols=3;
            setCellHidden(sheetObjects[0],false,false);
        }
        if(document.form.save_option.value == "0"){
 		   ComBtnEnable("btn_Save");
 		   ComBtnEnable("btn_RowAdd");
 		   ComBtnEnable("btn_Delete");
 		   sheetObjects[0].SetEditable(1);
 	   }else{
 		   ComBtnDisable("btn_Save");
 		   ComBtnDisable("btn_RowAdd");
 		   ComBtnDisable("btn_Delete");
 		   sheetObjects[0].SetEditable(0);
 	   }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * EES_CIM_0032 화면의 값 세팅및 계산식 적용 FUNCTION 호출 
     */
    function callParentFnc() {
    	ComClosePopup(); 
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
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
		              var HeadTitle1="Sel.|"+repoFlag+" Others|G.TTL|D.TTL|D2|D4|D5|D7|S.TTL|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|Remark(s)|||||||";
		              headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount, 0, 0, true);
		              FrozenCols=4;
		
		              SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",            KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fctr_ctnt",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		                     {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"g_total",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"d_total",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"d2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"d4_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"d5_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"d7_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"s_total",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"r2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"r5_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"r9_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"o2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"s2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"o4_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"s4_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"f2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"a2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"f4_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"a4_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"f5_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"diff_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"loc_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"loc_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"fcast_yrwk",         KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"inp_yrwk",           KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"cre_seq",            KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"mty_bal_otr_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
		               
		              InitColumns(cols);
		              SetCountPosition(0);//페이지카운트없애기
		              //InitDataValid(0, "fctr_ctnt", vtEngOther, "0123456789-~[]{}_|*&^%$#@! "); //영문과 숫자
		              //InitDataValid(0, "diff_rmk", vtEngOther, "0123456789-~[]{}_|*&^%$#@! "); //영문과 숫자
		              viewFlag_chk(sheetObj);
		              SetSheetHeight(262);
		              }
                break;
        }
    }
    /**
     * Sheet관련 프로세스 처리
     */	
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //조회
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true); 
    			formObj.f_cmd.value=SEARCH;
     			sheetObj.DoSearch("EES_EQR_1046GS.do",FormQueryString(formObj) );
    			break;
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction))
				formObj.f_cmd.value=MULTI;
				if (!ComShowCodeConfirm("COM130101")) return;
				sheetObj.DoSave("EES_EQR_1046GS.do",FormQueryString(formObj),"ibflag",false);
				break;
			case IBDELETE:		// 삭제
				if(sheetObj.FindCheckedRow("del_chk") != ""){
					ComRowHideDelete(sheetObj,"del_chk"); 
				}
				if(sheetObj.RowCount()> 0){
	                for ( var j=0; j<headCount; j++ ) {
	                	if ( j !=0 && j !=1  && j !=2  && j !=8  && j !=21 && j !=22 && j !=23 && j !=24 && j !=25  && j !=26 ) {
	        				setCaluValue(sheetObj.ColSaveName(j).substring(0,2),sheetObj);
	                	}
	                }
	                setGtotalCaluValue();	                
				}
                break;
            case IBDOWNEXCEL:      // 입력
            	if(sheetObj.RowCount() > 0){
            		sheetObj.Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
    			}else{
    				ComShowCodeMessage("EQR01104");
    			}
               break;                
			case IBINSERT:      // 입력
				break;
        }
    }
    /**
     * g_total 계산식
     */	
	function setGtotalCaluValue() {
        var sumGtotal=0;
        if ( document.form.viewFlag[2].checked ) {
        	for ( var i=1; i<=sheetObjects[0].rowCount; i++ ) {
        		if ( sheetObjects[0].GetRowStatus(i) != "D" ) {
        			sumGtotal=sumGtotal + eval(ComReplaceStr(sheetObjects[0].GetCellValue(i, "g_total"),",",""));
        		}
        	}
        	sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"g_total",ComAddComma(sumGtotal),0);
        }
	}    
    /**
     * total 계산식
     */	
	function setCaluValue(tpsz,sheetObj) {
		var sumTpsz=0;
		var sumGtotal=0;
		var sumDtotal=0;
		var sumStotal=0;
		for ( var i=1; i<=sheetObj.rowCount; i++ ) {
			if ( sheetObj.GetRowStatus(i) != "D" ) {
				if ( sheetObj.GetCellValue(i, tpsz+"_fcast_qty") !="" ) {
					sumTpsz=sumTpsz + eval(ComReplaceStr(sheetObj.GetCellValue(i, tpsz+"_fcast_qty"),",",""));
				}
				if (tpsz =="g_" ) {
					sumGtotal=sumGtotal + eval(ComReplaceStr(sheetObj.GetCellValue(i, "g_total"),",",""));
				}
				if (tpsz =="d_" ) {
					sumDtotal=sumDtotal + eval(ComReplaceStr(sheetObj.GetCellValue(i, "d_total"),",",""));
				}
				if (tpsz =="s_" ) {
					sumStotal=sumStotal + eval(ComReplaceStr(sheetObj.GetCellValue(i, "s_total"),",",""));
				}
			}
		}
		var colGtotal=0;
		var colDtotal=0;
		var colStotal=0;
        for ( var j=0; j<headCount; j++ ) {
        	if ( j !=0 && j !=1  && j !=2  && j !=3 && j !=8 && j !=21 && j !=22 && j !=23 && j !=24 && j !=25  && j !=26 && j != 27 && j !=28) {
        		if ( sheetObj.GetCellValue(sheetObj.GetSelectRow(), sheetObj.ColSaveName(j)) !="" ) {
	        		if ( sheetObj.ColSaveName(j).substring(0,1) == 'd' ) {
	        			colDtotal=colDtotal + eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sheetObj.ColSaveName(j)),",",""));
	        		} 
	        		if ( sheetObj.ColSaveName(j).substring(0,1) != 'd' ) {
	        			colStotal=colStotal + eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sheetObj.ColSaveName(j)),",",""));
	        		}
    			}
        	}
        }
		if (tpsz =="g_" ) {
			sheetObj.SetCellValue(sheetObj.LastRow(),"g_total",ComAddComma(sumGtotal),0);
		} else if (tpsz =="d_" ) {
			sheetObj.SetCellValue(sheetObj.LastRow(),"d_total",ComAddComma(sumDtotal),0);
		} else if (tpsz =="s_" ) {
			sheetObj.SetCellValue(sheetObj.LastRow(),"s_total",ComAddComma(sumStotal),0);
		} else {
			sheetObj.SetCellValue(sheetObj.LastRow(),tpsz+"_fcast_qty",ComAddComma(sumTpsz),0);
		}
        colGtotal=colDtotal+colStotal;
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"g_total",ComAddComma(colGtotal),0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"d_total",ComAddComma(colDtotal),0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"s_total",ComAddComma(colStotal),0);
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
    	} 
    	setGtotalCaluValue();
    }	
    /**
     * DRY,SPLC(RF, OT, FR), ALL 체크시 이벤트 정의     
     */
    function viewFlag_click(sheetObj) {
		switch (ComGetEvent("name")) {
		case "viewFlag":
			if ( document.form.viewFlag[0].checked ) {
				sheetObjects[0].SelectCell(0, "d2_fcast_qty", true);
				sheetObjects[0].FrozenCols=4;
				setCellHidden(sheetObjects[0],false,true);
			} else if ( document.form.viewFlag[1].checked ) {
				sheetObjects[0].SelectCell(0, "r2_fcast_qty", true);
				sheetObjects[0].FrozenCols=9;
				setCellHidden(sheetObjects[0],true,false);
			} else if ( document.form.viewFlag[2].checked ) {
				sheetObjects[0].SelectCell(0, "d2_fcast_qty", true);
				sheetObjects[0].FrozenCols=3;
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
    function setCellHidden(sheetObj, showFlag1, showFlag2) {
		if(sheetObj.GetColHidden("d2_fcast_qty") != showFlag1) 	sheetObj.SetColHidden("d2_fcast_qty",showFlag1);
		if(sheetObj.GetColHidden("d4_fcast_qty") != showFlag1)  sheetObj.SetColHidden("d4_fcast_qty",showFlag1);
		if(sheetObj.GetColHidden("d5_fcast_qty") != showFlag1)  sheetObj.SetColHidden("d5_fcast_qty",showFlag1);
		if(sheetObj.GetColHidden("d7_fcast_qty") != showFlag1)  sheetObj.SetColHidden("d7_fcast_qty",showFlag1);
		
		if(sheetObj.GetColHidden("r2_fcast_qty") != showFlag2)  sheetObj.SetColHidden("r2_fcast_qty",showFlag2);
		if(sheetObj.GetColHidden("r5_fcast_qty") != showFlag2)  sheetObj.SetColHidden("r5_fcast_qty",showFlag2);
		if(sheetObj.GetColHidden("r9_fcast_qty") != showFlag2)  sheetObj.SetColHidden("r9_fcast_qty",showFlag2);
		if(sheetObj.GetColHidden("o2_fcast_qty") != showFlag2)  sheetObj.SetColHidden("o2_fcast_qty",showFlag2);
		if(sheetObj.GetColHidden("s2_fcast_qty") != showFlag2)  sheetObj.SetColHidden("s2_fcast_qty",showFlag2);
		if(sheetObj.GetColHidden("o4_fcast_qty") != showFlag2)  sheetObj.SetColHidden("o4_fcast_qty",showFlag2);
		if(sheetObj.GetColHidden("s4_fcast_qty") != showFlag2)  sheetObj.SetColHidden("s4_fcast_qty",showFlag2);
		if(sheetObj.GetColHidden("f2_fcast_qty") != showFlag2)  sheetObj.SetColHidden("f2_fcast_qty",showFlag2);
		if(sheetObj.GetColHidden("a2_fcast_qty") != showFlag2)  sheetObj.SetColHidden("a2_fcast_qty",showFlag2);
		if(sheetObj.GetColHidden("f4_fcast_qty") != showFlag2)  sheetObj.SetColHidden("f4_fcast_qty",showFlag2);
		if(sheetObj.GetColHidden("a4_fcast_qty") != showFlag2)  sheetObj.SetColHidden("a4_fcast_qty",showFlag2);
		if(sheetObj.GetColHidden("f5_fcast_qty") != showFlag2)  sheetObj.SetColHidden("f5_fcast_qty",showFlag2);
		
    	if ( showFlag1==false && showFlag2==false ) {
    		if(sheetObj.GetColHidden("g_total") != 0)  sheetObj.SetColHidden("g_total",0);
    	} else {
    		if(sheetObj.GetColHidden("g_total") != 1)  sheetObj.SetColHidden("g_total",1);
    	}
		if ( showFlag1==false && showFlag2==false ) {
			if(sheetObj.GetColHidden("d_total") != 1)  sheetObj.SetColHidden("d_total",1);
		} else {
			if(sheetObj.GetColHidden("d_total") != showFlag1) sheetObj.SetColHidden("d_total",showFlag1);
		}
		if ( showFlag1==false && showFlag2==false ) {
			if(sheetObj.GetColHidden("s_total") != 1) sheetObj.SetColHidden("s_total",1);
		} else {
			if(sheetObj.GetColHidden("s_total") != showFlag2) sheetObj.SetColHidden("s_total",showFlag2);
		}
    }
    /**
     * sheet1 조회종료
     * sheet1 조회종료후 이벤트 호출
     */
	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg)
	{
		ComOpenWait(false);
		sheetObj.SetEditableColor("#000000");
		for ( var i=0; i<=sheetObj.rowCount; i++ ) {
			sheetObj.SetRowBackColor(i,"#000000");;
		}
 		sheetObj.SetRowBackColor(sheetObj.LastRow(), "#D3EBED");
		sheetObj.SetCellValue(sheetObj.LastRow(),"del_chk","",0);
		sheetObj.SetCellValue(sheetObj.LastRow(),"fctr_ctnt","G.Total",0);
		sheetObj.SetMergeCell(sheetObj.LastRow(), 1, 0, 1);
		sheetObj.SetSumFontBold(1);
		sheetObj.SetCellAlign(sheetObj.LastRow(),"lstm_cd","Center");
		//sheetObj.SelectHighLight=false;
	}
    /**
     * 저장 완료시 처리
     */
    function sheet1_OnSaveEnd(sheetObj, code, ErrMsg) {
		save_flag=true;
		if ( ErrMsg == "" ) {
			if ( save_flag ) { 
		    	var opener_obj=window.dialogArguments;
				//opener_obj.popupEditFlg = "Y";
				for ( var j=4; j<=20; j++ ) { // D2 ~F5
					if(j==8)
					   j++; // "s_total" 건너뛰기
	    			if ( sheetObjects[0].rowCount > 0 ) {
	    				opener_obj.setOwOnHireValue(sheetObjects[0].ColSaveName(j), sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),sheetObjects[0].ColSaveName(j)));
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
     //sheetObj.SelectHighLight=true;
    }	
