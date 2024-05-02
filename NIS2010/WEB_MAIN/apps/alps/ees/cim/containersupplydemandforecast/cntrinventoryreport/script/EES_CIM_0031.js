/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0031.js
*@FileTitle : Stock Report (Detail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.14 김종준
* 1.0 Creation
=========================================================*/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var headCnt  = 0;
var tot_cntr_tpsz_cd ="";
var obj_cntr_tpsz_cd ="";
var comboObjects = new Array();
var comboCnt = 0 ;
var save_flag = false;

var IBSEARCH01  = 29;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var shtCnt = 0;
         var sheet1 = sheetObjects[shtCnt++];


         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_Close":
					window.close();
					break;
                case "btn_downexcel":
                	sheet1.SpeedDown2Excel(true);
                    break;
        		case "btn_save":
        			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
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
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1); 
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id ; 

        switch(sheetID) {
            
             case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 265;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);


                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false)
                   
                    var HeadTitle1 = "Yard|TP/SZ|Available|Sound|Damage|Total|Due Out|Due In|Optimum|Variance||";
                     
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    headCnt  = HeadTitle1.split("|").length;
                    InitColumnInfo(headCnt, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtAutoSum, 	  	65,    	daCenterTop, 	true,     "loc_cd",    		false,          "",      dfNone     );
                    InitDataProperty(0, cnt++ , dtData, 	  	90,   	daCenterTop, 	true,     "cntr_tpsz_cd",  	false,          "",      dfNone     );

                    InitDataProperty(0, cnt++ , dtData, 		90,  	daRight,  		true,     "aval_qty",  		false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtData, 		90,    	daRight,  		true,     "snd_qty",      	false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtData, 	 	90,    	daRight,  		true,     "dmg_qty",     	false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtData,     	90,    	daRight,  		true,     "tot_qty", 		false,          "",      dfNullInteger,       0     );
                                                                                                                               
                    InitDataProperty(0, cnt++ , dtData,    		90,    	daRight,  		true,     "due_out_qty",  	false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtData,     	90,    	daRight,  		true,     "due_in_qty",     false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtData,   		90,    	daRight,  		true,     "cntr_qty",    	false,          "",      dfNone,       		  0, true, true,6     );
                    InitDataProperty(0, cnt++ , dtData,  		90,    	daRight,  		true,     "vari_qty",		false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtHidden,  		0,    	daRight,  		true,     "lvl",			false,          "",      dfNone,      		  0     );
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 0,  	daCenter, 		false, 	  "ibflag");

                    InitDataValid(0, "cntr_qty", vtNumericOnly);
                    
                    EditableColorDiff = false; 

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
	    	   formObj.f_cmd.value = SEARCH;
	    	   sheetObj.DoSearch("EES_CIM_0031GS.do",FormQueryString(formObj));
	    	   ComOpenWait(false); 	    	   
	    	   break;
           case IBSAVE:        //저장
	    	   if(validateForm(sheetObj,formObj,sAction))

	    	   formObj.f_cmd.value = MULTI;
	    	   sheetObj.DoSave("EES_CIM_0031GS.do",FormQueryString(formObj),"ibflag",true);
		       break;
        }
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
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
     	   	if (!ComChkValid(formObj)) return false;
        }
        return true;
    }

    /**
     * sheet1 조회종료
     * sheet1 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
       	var formObject = document.form;

		sheetObj.EditableColor =   sheetObj.RgbColor(0,0,0);
		sheetObj.UnEditableColor  =   sheetObj.RgbColor(0,0,0);

      	if ( sheetObj.rowCount != 0 ) {
		   	for ( var j=0; j<headCnt; j++ ) {
				sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
				if ( eval(ComReplaceStr(sheetObj.CellValue(sheetObj.LastRow,"cntr_qty"),",","")) >= 0 ) {
					sheetObj.CellFontColor(sheetObj.LastRow,"cntr_qty") = sheetObj.RgbColor(0,0,255);
				} else {
					sheetObj.CellFontColor(sheetObj.LastRow,"cntr_qty") = sheetObj.RgbColor(255,0,0);
				}
				if ( eval(ComReplaceStr(sheetObj.CellValue(sheetObj.LastRow,"vari_qty"),",","")) >= 0 ) {
					sheetObj.CellFontColor(sheetObj.LastRow,"vari_qty") = sheetObj.RgbColor(0,0,255);
				} else {
					sheetObj.CellFontColor(sheetObj.LastRow,"vari_qty") = sheetObj.RgbColor(255,0,0);
				}
			}
		   	sheetObj.RowDelete(sheetObj.LastRow-1, false);
	    	sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
	    	sheetObj.CellValue(sheetObj.LastRow,"loc_cd") = 'G.Total';
	    	sheetObj.SetMergeCell (sheetObj.LastRow, 0, 1, 2);
	    	
      	}
      	sheetObj.SelectHighLight = false;
    }

    /**
     * Location by loc_cd 팝업에서 선택한 값 Setting.
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
       var sheetObject = sheetObjects[0];
       var formObject = document.form;
       formObject.loc_cd.value = aryPopupData[0][3] 
    }

    /**
     * 셀에 키입력 했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
    function sheet1_OnAfterEdit(sheetObj, Row, Col) {
    	switch (sheetObj.ColSaveName(Col)) {
    		case "cntr_qty":
    			setCaluValue(sheetObj, Row, Col);
    			break;
    	}
    }

    /**
     * Variance = Available - Optimum 계산식 적용
    */    
	function setCaluValue(sheetObj, Row, Col) {
		sheetObj.CellValue2(sheetObj.SelectRow, "vari_qty") = sheetObj.CellValue(sheetObj.SelectRow, "aval_qty") - sheetObj.CellValue(sheetObj.SelectRow, "cntr_qty");

		var tot_pos_cntr_qty = 0;	//Yard 별 합산  Total 로우
		var tot_row_cntr_qty = 0;	
		var tot_cntr_qty = 0;

		var tot_pos_vari_qty = 0;	//Yard 별 합산  Total 로우

		var tot_fos_tpsz_row = 0;
		var tot_row_vari_row = 0;

		var tot_fos_tpsz_row = 0;
		var tot_vari_qty = 0;
		for ( var i=1; i<=sheetObj.rowCount; i++ ) {
			if ( sheetObj.CellValue(i, "loc_cd") == sheetObj.CellValue(sheetObj.SelectRow, "loc_cd") && sheetObj.CellValue(i, "lvl") != "01"  ) {
				tot_pos_cntr_qty = tot_pos_cntr_qty + ComReplaceStr(eval(sheetObj.CellValue(i, "cntr_qty"),",",""));
				tot_pos_vari_qty = tot_pos_vari_qty + ComReplaceStr(eval(sheetObj.CellValue(i, "vari_qty"),",",""));
			}
			if ( sheetObj.CellValue(i, "loc_cd") == sheetObj.CellValue(sheetObj.SelectRow, "loc_cd") && sheetObj.CellValue(i, "lvl") == "01"  ) {
				tot_row_cntr_qty = i;
			}
			
			if ( sheetObj.CellValue(i, "cntr_tpsz_cd") == sheetObj.CellValue(sheetObj.SelectRow, "cntr_tpsz_cd") && sheetObj.CellValue(i, "lvl") == "00" ) {
				tot_fos_tpsz_row = tot_fos_tpsz_row + eval(ComReplaceStr(sheetObj.CellValue(i, "cntr_qty"),",",""));
				tot_row_vari_row = tot_row_vari_row + eval(ComReplaceStr(sheetObj.CellValue(i, "vari_qty"),",",""));
			}
			if ( sheetObj.CellValue(i, "cntr_tpsz_cd") == sheetObj.CellValue(sheetObj.SelectRow, "cntr_tpsz_cd") && sheetObj.CellValue(i, "lvl") == "10" ) {
				tot_row_tpsz_row = i;
			}
				
		}
		sheetObj.CellValue2(tot_row_cntr_qty, "cntr_qty") = tot_pos_cntr_qty;
		sheetObj.CellValue2(tot_row_tpsz_row, "cntr_qty") = tot_fos_tpsz_row;

		sheetObj.CellValue2(tot_row_cntr_qty, "vari_qty") = tot_pos_vari_qty;
		sheetObj.CellValue2(tot_row_tpsz_row, "vari_qty") = tot_row_vari_row;
		sheetObj.RowStatus(tot_row_cntr_qty) = "R";
		sheetObj.RowStatus(tot_row_tpsz_row) = "R";

		for ( var i=1; i<=sheetObj.rowCount; i++ ) {
			if ( sheetObj.CellValue(i, "lvl") == "10"  ) {
				tot_cntr_qty = tot_cntr_qty + eval(ComReplaceStr(sheetObj.CellValue(i, "cntr_qty"),",",""));
				tot_vari_qty = tot_vari_qty + eval(ComReplaceStr(sheetObj.CellValue(i, "vari_qty"),",",""));
			}
		}
		sheetObj.CellValue2(sheetObj.LastRow, "cntr_qty") = tot_cntr_qty;
		sheetObj.CellValue2(sheetObj.LastRow, "vari_qty") = tot_vari_qty;

		if ( eval(ComReplaceStr(sheetObj.CellValue(sheetObj.LastRow,"cntr_qty"),",","")) >= 0 ) {
			sheetObj.CellFontColor(sheetObj.LastRow,"cntr_qty") = sheetObj.RgbColor(0,0,255);
		} else {
			sheetObj.CellFontColor(sheetObj.LastRow,"cntr_qty") = sheetObj.RgbColor(255,0,0);
		}
		if ( eval(ComReplaceStr(sheetObj.CellValue(sheetObj.LastRow,"vari_qty"),",","")) >= 0 ) {
			sheetObj.CellFontColor(sheetObj.LastRow,"vari_qty") = sheetObj.RgbColor(0,0,255);
		} else {
			sheetObj.CellFontColor(sheetObj.LastRow,"vari_qty") = sheetObj.RgbColor(255,0,0);
		}
		
		sheetObj.CellValue2(sheetObj.LastRow, "loc_cd") = "G.Total";
		sheetObj.SetMergeCell (sheetObj.LastRow, 0, 1, 2);
		
		if ( eval(sheetObj.CellValue(Row, "vari_qty")) >= 0 ) {
			sheetObj.CellFontColor(Row,"vari_qty") = sheetObj.RgbColor(0,0,255);
		} else {
			sheetObj.CellFontColor(Row,"vari_qty") = sheetObj.RgbColor(255,0,0);
		}		
	}
    /**
     * 저장 완료시 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	save_flag = true;
    	if ( ErrMsg == "" ) {
        	callParentFnc();
    		ComShowCodeMessage("CIM30019");
    	}
      	sheetObj.CellValue2(sheetObj.LastRow, "loc_cd") = "G.Total";
      	sheetObj.CellValue2(sheetObj.LastRow, "cntr_tpsz_cd") = "G.Total";
      	sheetObj.SetMergeCell (sheetObj.LastRow, 0, 1, 2);
      	
      	sheetObj.Redraw = true;
    }

    /**
     * EES_CIM_0032 화면의 값 세팅및 계산식 적용 FUNCTION 호출 
     */
    function callParentFnc() {
		if ( save_flag ) { 
	    	var opener_obj = window.dialogArguments;
	    	opener_obj.popupCloseEnd();	  //EES_CIM_0028화면 조회
		} 
    }
	/**
	 * 화면 폼입력시 널입력시 0으로 변환
	 */	
    function sheet1_OnKeyUp(sheetObject, Row, Col, Value) {
    	if (Col ==8) {	//image_button 아닐때
	    	if ( sheetObject.CellValue(Row,Col) == '' ) {	//data format int형 널 방지
	    		sheetObject.CellValue2(Row,Col) = 0;
	    	}
    	}
    }  
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }	    