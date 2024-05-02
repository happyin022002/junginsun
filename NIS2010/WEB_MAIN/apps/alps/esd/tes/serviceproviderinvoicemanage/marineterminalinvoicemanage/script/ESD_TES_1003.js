
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var opener_obj;
	var opener_sheet_obj;
	var sheet_curr_row;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;


	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObj = sheetObjects[0];
         var formObject = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
        	    case "btn_confirm":
    	            doActionIBSheet(sheetObj,formObject,IBSAVE);
        	        break;

                case "btn_close":
					window.close();
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param {ibsheet} sheet_obj		IBSheet Object
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		
		var formObj = document.form;
		
		opener_obj = window.dialogArguments;
		opener_sheet_obj = eval('opener_obj.document.t3sheet1');
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
       
	}

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param {ibsheet} sheetObj		IBSheet Object 
     * @param {int}	sheetNo				IBSheet number
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		
		switch(sheetNo) {
		 case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 240;
									
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(24, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false, false);

				var HeadTitle0 = "Seq|Cost Code|Input\nAmount|Select|VVD|VVD|Bound|Allocated\nVolume|Allocated\nVolume(%)|Allocated\nAmount";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData ,      30,    daCenter,  true,   "seq" ,false,           "",       dfNone,    0,     false,       false  );
				InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,    "lgs_cost_cd",   false,           "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ ,dtData,      80,    daRight,  true,    "inv_amt",    false,          "",       dfNone,         0,     false,      false);
				InitDataProperty(0, cnt++, dtCheckBox,  60,    daCenter,  true,    "choice");
				InitDataProperty(0, cnt++, dtData,      60,    daLeft,  false,    "vvd_type",              false,          "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++, dtData,      80,    daCenter,  false,    "vvd",              false,          "",       dfNone,    0,     true,       true);
				
				InitDataProperty(0, cnt++, dtData,      50,  daCenter,   false,    "io_bnd_cd",             false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtData,      80,  daRight,   false,    "cntr_qty_sum", false,          "",    dfInteger,0);
				InitDataProperty(0, cnt++, dtData,      80,  daRight,   false,    "allocated_volumn", false,          "",    dfInteger,0);
				InitDataProperty(0, cnt++, dtData,      120,  daRight,   false,    "calc_amt", false,          "",    dfNone,0);
				
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "tml_so_ofc_cty_cd", false,          "",    dfNone);
				
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "tml_so_seq", false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "tml_so_dtl_seq", false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "vsl_cd", false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "skd_voy_no", false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "skd_dir_cd", false,          "",    dfNone);
				
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "atb_dt", false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "cntr_tpsz_cd", false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "fm_tr_vol_val", false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "to_tr_vol_val", false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "dcgo_ind_cd", false,          "",    dfNone);
				
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "vol_tr_ut_cd", false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,      120,  daRight,   false,    "inv_xch_rt", false,          "",    dfNone);
				
				InitDataProperty(0, cnt++, dtHiddenStatus,     30,    daCenter,  true,    "ibflag");
 
		   }
			break;
		}
	}
    
     /**
      * 	검색, 저장시 	
      * 
      * @param {ibsheet} 	sheetObj		IBSheet Object 
      * @param {form}		formObj			form object
      * @param {String}		sAction			form action value
      * @return
      */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		   case IBSEARCH:
                formObj.f_cmd.value = SEARCH;
                
				sheetObj.DoSearch4Post("ESD_TES_1003GS.do", tesFrmQryStr(formObj));
			    break;

            case IBSAVE: 
                var inv_amt = 0;
                var calc_amt = 0;
                for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
                    sheetObj.RowStatus(i) = 'R';
                    if(sheetObj.CellValue(i,"choice") == "1" ){
                        if(sheetObj.CellValue(i,"vvd_type") == "Input"){
                            sheetObj.RowStatus(i) = 'U';
                            inv_amt = inv_amt+Number(sheetObj.CellValue(i,"inv_amt"));
                        }else{
                            sheetObj.RowStatus(i) = 'I';
                            document.form.io_bnd_cd2.value = sheetObj.CellValue(i,"io_bnd_cd");
                        }
                        
                        
                        calc_amt = calc_amt+Number(sheetObj.CellValue(i,"calc_amt"));
                        
                    }
                }
                
                if(inv_amt != calc_amt){
                    ComShowMessage('Sum of allocated amount is different from input amount!');
                    return false;
                }
                
                if (sheetObj.RowCount > 0 && sheetObj.IsDataModified){
						    formObj.f_cmd.value = MULTI;
						    var param = sheetObj.GetSaveString(false,false);
				            var savexml = sheetObj.GetSaveXml("ESD_TES_1003GS.do", param+'&'+tesFrmQryStr(formObj));
				            sheetObj.LoadSaveXml(savexml,true);
						
				}
				sheetObj.MergeSheet = msPrevColumnMerge;
                break;

            

		}
    }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      * @param {ibsheet} 	sheetObj		IBSheet Object 
      * @param {form}		formObj			form object
      * @param {String}		sAction			form action value
      * 
      */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }
        
    /** sheet1의 search후 순서값 너어줌
     * 
     * @param {ibsheet}	sheetObj
     * @param {String}	ErrMsg
     * @return
     */    
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		var cnt = 0;
		if (sheetObj.RowCount > 0){
		    for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
		        if(i%2){
		            sheetObj.CellValue(i,'seq') = ++cnt;
		            
		        }else{
		            sheetObj.CellValue(i,'seq') = cnt;
		            sheetObj.RangeBackColor(i,3,i,10) = sheetObj.RgbColor(255,210,255);
		        }
		        
		        if(sheetObj.CellValue(i,'vvd_type') == "Input"){
		              sheetObj.CellValue(i,'calc_amt') = sheetObj.CellValue(i,'inv_amt');
		        }
		        
		        sheetObj.CellValue(i,"choice") = "1";
		    }
		}

	}
	
	/** 팝업창 닫고 다시 화면 불러옴
	 * 
	 * @param {ibsheet}	sheet	IBsheet object
	 * @param {String}	Row		cell의 row index
	 * @param {String}	Col		celldml col index
	 * @param {String}	Value	
	 * @return
	 */
	function sheet1_OnSaveEnd(sheet, Row, Col, Value) {
	    window.close();
	    window.dialogArguments.retrieveAll();
				
	}
	
	/**
	 * sheet에서 팝업클릭시 3rdparty 로 이동
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		tes_get3rdParty_sheet(sheetObj.CellValue(Row,"vndr_cust_div_cd"), Row, Col );
	}
	
	/** 
	 * sheet colum 값 설정
	 *  
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 */
	function sheet1_OnClick(sheetObj, row, col, value){
	     if(sheetObj.ColSaveName(col) == "choice"){
	         var str = sheetObj.CellValue(row,"tml_so_dtl_seq") ;
	         
	         for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
	             
	             if(str == sheetObj.CellValue(i,"tml_so_dtl_seq") && row != i){
	                 if(sheetObj.CellValue(row,"choice") == '0'){
	                     sheetObj.CellValue(i,"choice") = "1"; 
	                 }else{
	                     sheetObj.CellValue(i,"choice") = "0"; 
	                 }
	             }
	         }
	         
	     }
	        
	}
	
	/**
	 * onChange 시 칼럼 allocated_volumn, cntr_qty_sum 변경
	 * 
	 * @param {ibsheet}	sheetObj	IBsheet object
	 * @param {String}	row			셀의 row index
	 * @param {String}	col			셀의 Column index	
	 * @param {String}	value		셀의 변경된 값
	 * @return
	 */
	function sheet1_OnChange(sheetObj, row, col, value){
	    var dtl_seq = sheetObj.CellValue(row,"tml_so_dtl_seq");
	    var vvd_type = sheetObj.CellValue(row,"vvd_type");
	    var cnt = 0;
	    var cnt2 = 0;
	    
	    var cal_vol = 0;
	    var cal_vol2 = 0;
	    
	    var cal_vol3 = 0;
	    var cal_vol4 = 0;
	    
	    var colName = sheetObj.ColSaveName(col) ;
	    
	    if(colName == "allocated_volumn" && Number(sheetObj.CellValue(row,"allocated_volumn")) > 0){
	         if(Number(sheetObj.CellValue(row,"allocated_volumn")) > 100){
	             sheetObj.CellValue(row,"allocated_volumn") = 0;
	             return false;
	         }else{
	             for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
	                 if(sheetObj.CellValue(i,"tml_so_dtl_seq") == dtl_seq && sheetObj.CellValue(i,"vvd_type") != vvd_type){
	                     cnt = i;
	                 }
	                     
	             }
	             sheetObj.CellValue(cnt,"allocated_volumn") = 100 - Number(sheetObj.CellValue(row,"allocated_volumn"));
	         }
	         
	         cal_vol = Number(sheetObj.CellValue(row,"allocated_volumn"));
	         cal_vol2 = Number(sheetObj.CellValue(cnt,"allocated_volumn"));
	         
	         
	         sheetObj.CellValue(row,"calc_amt") = Number(sheetObj.CellValue(row,"inv_amt"))*cal_vol/100 ;
	         sheetObj.CellValue(cnt,"calc_amt") = Number(sheetObj.CellValue(cnt,"inv_amt"))*cal_vol2/100 ;
	         
	         if(Number(sheetObj.CellValue(row,"inv_amt")) < Number(sheetObj.CellValue(row,"calc_amt"))+Number(sheetObj.CellValue(cnt,"calc_amt"))){
	             cnt2 = Number(sheetObj.CellValue(row,"calc_amt"))+Number(sheetObj.CellValue(cnt,"calc_amt")) - Number(sheetObj.CellValue(row,"inv_amt"));
	             sheetObj.CellValue(cnt,"calc_amt") = Number(sheetObj.CellValue(cnt,"calc_amt")) - cnt2;
	         }
	         
	         sheetObj.CellValue(row,"cntr_qty_sum") = 0;
	         sheetObj.CellValue(cnt,"cntr_qty_sum") = 0;
	     }
	     
	     if(colName == "cntr_qty_sum"){
	         
	          for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
	                 if(sheetObj.CellValue(i,"tml_so_dtl_seq") == dtl_seq && sheetObj.CellValue(i,"vvd_type") != vvd_type){
	                     cnt = i;
	                 }
	                     
	          }
	          
	          cal_vol = Number(sheetObj.CellValue(row,"cntr_qty_sum"));
	          cal_vol2 = Number(sheetObj.CellValue(cnt,"cntr_qty_sum"));
	          
	          if(cal_vol > 0 && cal_vol2 > 0){
	               
	               cal_vol3 = cal_vol/(cal_vol+cal_vol2)*100;
	               cal_vol4 = cal_vol2/(cal_vol+cal_vol2)*100;
	               
	               sheetObj.CellValue(row,"calc_amt") = Number(sheetObj.CellValue(row,"inv_amt"))*cal_vol3/100 ;
	               sheetObj.CellValue(cnt,"calc_amt") = Number(sheetObj.CellValue(cnt,"inv_amt"))*cal_vol4/100 ;
	               
	               if(Number(sheetObj.CellValue(row,"inv_amt")) < Number(sheetObj.CellValue(row,"calc_amt"))+Number(sheetObj.CellValue(cnt,"calc_amt"))){
	                    cnt2 = Number(sheetObj.CellValue(row,"calc_amt"))+Number(sheetObj.CellValue(cnt,"calc_amt")) - Number(sheetObj.CellValue(row,"inv_amt"));
	                    sheetObj.CellValue(cnt,"calc_amt") = Number(sheetObj.CellValue(cnt,"calc_amt")) - cnt2;
	               }
	               
	               sheetObj.CellValue(row,"allocated_volumn") = 0;
	               sheetObj.CellValue(cnt,"allocated_volumn") = 0;
	          }
	         
	     }
	        
	}

	


