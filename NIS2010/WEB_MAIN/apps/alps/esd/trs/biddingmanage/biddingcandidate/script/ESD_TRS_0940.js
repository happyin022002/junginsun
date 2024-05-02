//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

  
    
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObjectT = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;  

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_retrieve":
            		doActionIBSheet(sheetObject,formObject,IBSEARCH);
            	break;
        	
                case "btn_rowadd":
                	var row = sheetObject.DataInsert(-1);
                break;
                
                case "btn_rowdel":
                	checkedRowDelete(sheetObject);
                break;

                case "btn_close":
        			errMsg = ComGetMsg("TRS90703");
        			ComShowMessage(errMsg);
    	            self.close();
        	    break;

        	    case "btn_ok":
                    comPopupOK();
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
        var sheetObject = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var formObject = document.form;
        
        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
      	initControl();
      	
      
      	
        if(!opener){
            opener = window.dialogArguments;
    	}
        
        checkedRowCopy(sheetObject2); 
        
        doActionIBSheet(sheetObject,formObject,IBSEARCH);
    }
    
    /**
     * Main Grid의 Check된 복수개의 Row Copy
     * @param {Object} sheetObj
     */
    function checkedRowCopy(sheetObj){
    	var soFromRow = 0;
    	var soSheetObj = opener.sheetObjects[3]
     	var checkList = soSheetObj.FindCheckedRow("chk");
    	var arrRow = checkList.split("|");

    	if (checkList != "") {
	    	for( var i=0; i<arrRow.length-1; i++ ) { //Case One으로 넘길 경우
	    		if(soSheetObj.CellValue(arrRow[i],"spot_bid_flg") == 'Y'){
		    		sheetObj.DataInsert(-1);
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_chk") 				= soSheetObj.CellValue(arrRow[i],"chk");
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_trsp_so_ofc_cty_cd") 	= soSheetObj.CellValue(arrRow[i],"trsp_so_ofc_cty_cd");
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_trsp_so_seq") 		= soSheetObj.CellValue(arrRow[i],"trsp_so_seq");
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_spot_bid_flg") 		= soSheetObj.CellValue(arrRow[i],"spot_bid_flg");
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_spot_bid_due_dt") 	= soSheetObj.CellValue(arrRow[i],"spot_bid_due_dt");
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_spot_bid_due_dt_hms") = soSheetObj.CellValue(arrRow[i],"spot_bid_due_dt_hms");
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_trsp_crr_mod_cd" ) 	= soSheetObj.CellValue(arrRow[i],"trsp_crr_mod_cd");
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_fm_nod_cd") 			= soSheetObj.CellValue(arrRow[i],"fm_nod_cd");
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_via_nod_cd") 			= soSheetObj.CellValue(arrRow[i],"via_nod_cd");
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_fm_nod_cd") 			= soSheetObj.CellValue(arrRow[i],"fm_nod_cd");
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_dor_nod_cd") 			= soSheetObj.CellValue(arrRow[i],"dor_nod_cd");
			    	sheetObj.CellValue(sheetObj.SelectRow,"so_to_nod_cd") 			= soSheetObj.CellValue(arrRow[i],"to_nod_cd");
			    	soSheetObj.CellValue(arrRow[i],"spot_bid_flg")= 'N';//같은 Bid건 대상으로 잡히지 않도록 함. 
	    		}
    		}
    	}
    }
    
    /**
     * 
     */
     function initControl() {
      	var formObject = document.form;
          axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
      }

      //업무 자바스크립트 OnKeyPress 이벤트 처리
      function keypressFormat() {
      	obj = event.srcElement;
    	    if(obj.dataformat == null) return;
    	    window.defaultStatus = obj.dataformat;
    	    switch(obj.dataformat) {
    	        case "engup":
    	        	ComKeyOnlyAlphabet('upper');
    	        break;
    	            
    	        case "number":
    	        	ComKeyOnlyNumber(obj);
    	        break;
    	    }
      }
    
   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(10) ;
                    //전체 너비 설정
                    SheetWidth = 100;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 5000);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true); // 맨 앞에 번호 row

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle0 = "Sel|Bid Candidate|Bid Candidate|Bid Candidate|Bid Candidate|Bid Candidate|Bid Candidate||Route|Route|Route|Route" ;
                    var HeadTitle1 = "Sel|Seq|S/P Code|S/P Name|Trans\nMode|E-Mail|SPP||From|Via|Door|To" ;
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    InitDataProperty(0, cnt++ , dtCheckBox, 	    40,   	daCenter,  true,   	"chk");
    				InitDataProperty(0, cnt++ , dtDataSeq,    		40,   	daCenter,  true,   	"seq");
    				InitDataProperty(0, cnt++ , dtPopupEdit,   	    70,    	daCenter,  false,   "vndr_seq",     			false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     	    80,    	daLeft,    false,   "vndr_nm",      			false,          "",       dfNone,       0,     false,       true);
    				InitDataProperty(0, cnt++ , dtCombo,     	    60,    	daCenter,  false,   "trsp_crr_mod_cd",  		false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,     	160,  	daLeft,    false,   "vndr_eml_addr",			false,          "",       dfNone,       0,      true,       true);
                    InitDataProperty(0, cnt++ , dtData,     	    30,  	daCenter,  false,   "spp_flg",      			false,          "",       dfNone,       0,     false,       true);
    				InitDataProperty(0, cnt++ , dtHidden,     	    50,    	daLeft,    false,   "cnddt_seq",     			false,          "",       dfNone,       0,     false,       true);
    				InitDataProperty(0, cnt++ , dtHidden,     	    50,    	daCenter,  false,   "fm_nod_cd",     			false,          "",       dfNone,       0,     false,       true);
    				InitDataProperty(0, cnt++ , dtHidden,     	    50,    	daCenter,  false,   "via_nod_cd",     			false,          "",       dfNone,       0,     false,       true);
    				InitDataProperty(0, cnt++ , dtHidden,     	    50,    	daCenter,  false,   "dor_nod_cd",     			false,          "",       dfNone,       0,     false,       true);
    				InitDataProperty(0, cnt++ , dtHidden,     	    50,    	daCenter,  false,   "to_nod_cd",     			false,          "",       dfNone,       0,     false,       true);
    				InitDataProperty(0, cnt++ , dtHidden,     	    50,    	daCenter,  false,   "spot_bid_cnddt_term_seq",  false,          "",       dfNone,       0,     false,       true);
    				InitDataProperty(0, cnt++ , dtHiddenStatus, 	30,   	daCenter,  true,    "ibflag");
    				
    				InitDataCombo(0, 'trsp_crr_mod_cd', trsp_crr_mod_cdText, trsp_crr_mod_cdCode);
    				InitDataValid(0, "vndr_seq", 		vtNumericOnly);
    				ShowButtonImage = 1;
    				ImageList(0) = "img/button/btns_multisearch.gif";
    				PopupButtonImage(0, "vndr_eml_addr") = 0;
                    
               }
               break;
               
    		case 2: //sheet2
    			with (sheetObj) {
    				style.height = 0; // 높이 설정
    				SheetWidth = 0; //전체 너비 설정
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
    				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
    				Editable = false; //전체Edit 허용 여부 [선택, Default false]
    				InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitColumnInfo(12, 5, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, true, true, false,false)

    				var HeadTitle0 = "chk|S/O Office|Seqence|Bid Flag|Due Date|Due Time|crr_mod_cd|fm node|via node|dor node|to node";

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle0, true);

    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++, dtCheckBox,  50, 	daCenter, 	true, "so_chk");
    				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "so_trsp_so_ofc_cty_cd"	,false, 	"",			dfNone, 	0, false, false);
    				InitDataProperty(0, cnt++, dtData,  	80, 	daCenter, 	true, "so_trsp_so_seq"       	,false, 	"", 		dfNone, 	1, false, false);
    				InitDataProperty(0, cnt++, dtData,  	50, 	daCenter, 	true, "so_spot_bid_flg"       	,false, 	"", 		dfNone, 	1, false, false);
    				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "so_spot_bid_due_dt"      ,false, 	"", 		dfDateYmd, 	1, false, false);
    				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "so_spot_bid_due_dt_hms"  ,false, 	"", 		dfTimeHms, 	1, false, false);
    				InitDataProperty(0, cnt++, dtData,  	50, 	daCenter, 	true, "so_trsp_crr_mod_cd"      ,false, 	"", 		dfNone, 	1, false, false);
    				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "so_fm_nod_cd"       		,false, 	"", 		dfNone, 	1, false, false);
    				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "so_via_nod_cd"       	,false, 	"", 		dfNone, 	1, false, false);
    				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "so_dor_nod_cd"       	,false, 	"", 		dfNone, 	1, false, false);
    				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "so_to_nod_cd"       		,false, 	"", 		dfNone, 	1, false, false);
    				InitDataProperty(0, cnt++, dtHiddenStatus, 30,	daCenter,   true, "so_ibflag");
    			}
    		break;
        }
    }
    
  
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
           case IBSEARCH:         // 조회
        	   formObj.f_cmd.value = SEARCH01;   
        	   var queryStr = sheetObjects[1].GetSaveString(false, true, "so_chk");
	           sheetObj.DoSearch4Post("ESD_TRS_0940GS.do",queryStr+"&"+TrsFrmQryString(formObj));
           break;
        }
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validSave(sheetObj){
    	var rtn_flg =  true;
        var fromRow = 0;
    	var sRow = sheetObj.FindCheckedRow("chk");
    	var arrRow = sRow.split("|");

    	var soFromRow = 0;
    	var soSheetObj = sheetObjects[1];
     	var soRow = soSheetObj.FindCheckedRow("so_chk");
    	var soArrRow = soRow.split("|");
    	
    	if(sRow ==""){
			errMsg = ComGetMsg("COM12113","S/P");
			ComShowMessage(errMsg);
	    	rtn_flg =  false;	 
    	}

    	for( var i=0; i<arrRow.length-1; i++ ) { //Case One으로 넘길 경우
			if(!rtn_flg){
	   			break;   				
			}
			fromRow = arrRow[i];
	    	var vndr_seq 		= sheetObj.CellValue(fromRow,"vndr_seq");
	    	var vndr_eml_addr 	= sheetObj.CellValue(fromRow,"vndr_eml_addr");
	    	var trsp_crr_mod_cd = sheetObj.CellValue(fromRow,"trsp_crr_mod_cd");
	    	var spp_flg  = sheetObj.CellValue(fromRow,"spp_flg");

	    	if(vndr_seq == ""){
				//S/P is not corresponded.
				errMsg = ComGetMsg("TRS90702","S/P");
				ComShowMessage(errMsg);
		    	rtn_flg =  false;
		    }else if(trsp_crr_mod_cd == ""){
				//Transmode is not corresponded.
				errMsg = ComGetMsg("TRS90702","Trans mode");
				ComShowMessage(errMsg);
		    	rtn_flg =  false;
		    }else if(vndr_eml_addr == ""){
				//eMail is not corresponded.
				errMsg = ComGetMsg("TRS90702","eMail");
				ComShowMessage(errMsg);
		    	rtn_flg =  false;
		    }/*else if(spp_flg != "Y"){
				//S/P is invalid.
				errMsg = ComGetMsg("TRS90388","S/P");
				ComShowMessage(errMsg);
		    	rtn_flg =  false;	 	
		    }*/

			for(var j=0;j < soArrRow.length-1; j++ ){
				soFromRow = soArrRow[j];
				var so_trsp_crr_mod_cd 	= soSheetObj.CellValue(soFromRow,"so_trsp_crr_mod_cd");
    		    if(rtn_flg){
    		    	if(trsp_crr_mod_cd == so_trsp_crr_mod_cd){
	    		    	rtn_flg =  true;
	    		    }else{
	    				errMsg = ComGetMsg("TRS90702","Trans mode");
	    				ComShowMessage(errMsg);
	    				rtn_flg =  false;
	    		    }
    		    }
			}//end for(var j=0;soArrRow.length-1; j++ )
    	}
        return rtn_flg;
    }
    
    /**
     * OK Button Event
     */
    function comPopupOK(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        if(validSave(sheetObj)){
        	if(!confirm(ComGetMsg('TRS90700')) ) return false;
            formObj.f_cmd.value = MULTI;   
            var queryStr = sheetObjects[1].GetSaveString(false, true, "so_chk");
            sheetObj.DoSave("ESD_TRS_0940GS.do",queryStr+"&"+TrsFrmQryString(formObj),"chk",false); 
        }
        removeMainGrid();
    }
    /**
     * Grid OnChange Event
     */
     function sheet1_OnChange(sheetObj, row , col , value) {
     	var formObj = document.form;
     	if( sheetObj.ColSaveName(col) == "vndr_seq" ) {
    		var vndr_seq = sheetObj.CellValue(row, "vndr_seq");
    		var vndr_nm = "";
    		
    		formObj.f_cmd.value = SEARCH02;
    		var queryString = "vndr_seq="+vndr_seq;

    		sheetObj.DoRowSearch("ESD_TRS_0940GS.do",TrsFrmQryString(formObj)+"&"+ queryString);

    		vndr_nm = sheetObj.EtcData('vndr_nm');
    		if(vndr_nm !="" && vndr_nm !=null && vndr_nm != undefined){
    			sheetObj.CellValue2(row, "vndr_seq")  = sheetObj.EtcData('vndr_seq');
    			sheetObj.CellValue2(row, "vndr_nm")  = sheetObj.EtcData('vndr_nm');
    			sheetObj.CellValue2(row, "vndr_eml_addr")  = sheetObj.EtcData('vndr_eml');
    			sheetObj.CellValue2(row, "spp_flg")  = sheetObj.EtcData('spp_flg');   
    			
    		}else{
    			sheetObj.CellValue2(row, "vndr_seq") = "";
    			sheetObj.CellValue2(row, "vndr_nm")  = "";
    			sheetObj.CellValue2(row, "vndr_eml_addr")  = "";
    			sheetObj.CellValue2(row, "spp_flg")  = "";   
    		}
    		
    		sheetObj.RemoveEtcData();
     	}
     }
    
    
    /**
    * 저장결과가 오류가 발생했을 때 공통처리하는 함수
    * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
    */
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	var formObj = document.form;
    	if( errMsg != null && errMsg != '' ) {
    		ComShowMessage(errMsg);
    	} else {
			ComShowCodeMessage('COM130102', 'Spot Bidding');
			window.close();
    	}
    }
    
    /**
     * S/O Creation 부모창의 그리드 삭제 
     *
     */
    function removeMainGrid(){
		var checkList = opener.sheetObjects[3].FindCheckedRow('chk');
		var checkArray = checkList.split('|');
		var sheetObj = sheetObjects[1];
		var bidSoCheckList = sheetObj.FindCheckedRow('so_chk');
		var bidSoCheckArray = bidSoCheckList.split('|');

		for(var k=checkArray.length-opener.sheetObjects[3].HeaderRows; k>=0; k--){
			for(var j= 0;j<bidSoCheckArray.length-1;j++){
				if(sheetObj.CellValue(bidSoCheckArray[j],"so_trsp_so_ofc_cty_cd") == opener.sheetObjects[3].CellValue(checkArray[k-1],"trsp_so_ofc_cty_cd")
				   && sheetObj.CellValue(bidSoCheckArray[j],"so_trsp_so_seq") == opener.sheetObjects[3].CellValue(checkArray[k-1],"trsp_so_seq")
				 ){
					opener.sheetObjects[3].RowDelete(checkArray[k-1], false);
				}
			}

		}
    }
    
    /**
     * Grid Vendor Seq PopUp
     * @param sheetObj
     * @param Row
     * @param Col
     * @param value
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col, value) {
    	if (sheetObj.ColSaveName(Col) == "vndr_seq") {
    		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackVendor", "1,0,1,1,1,1,1", true, false, Row);
    	}else if (sheetObj.ColSaveName(Col) == "vndr_eml_addr") {
    		openMultipleinquiry('vndr_eml_addr', 'E-Mail', Row);	
    	}
    }
    
    /**
    * 콜백 함수. <br>
    * @param  {Array} aryPopupData	필수	 Array Object
    * @param  {Int} row				필수 선택한 Row
    * @param  {Int} col				필수 선택한 Column
    * @param  {Int} sheetIdx			필수 Sheet Index
    * @return 없음
    * @author 
    * @version 2013.03.21
    */   
    function callBackVendor(aryPopupData, row, col, sheetIdx){
       var sheetObj = sheetObjects[0];
       var vndrSeq = "";
       var vndrNm = "";
       var i = 0;

       for(i = 0; i < aryPopupData.length; i++){
    	   vndrSeq = vndrSeq + aryPopupData[i][2];
    	   vndrNm = vndrNm + aryPopupData[i][4];
       }
       sheetObj.CellValue(row, "vndr_seq") = vndrSeq;
       sheetObj.CellValue(row, "vndr_nm") = vndrNm;
    }
    
    

    /**
    * 공통 Trunk VVD popup
    */
    function openMultipleinquiry(obj, obj2, Row) {
    	var formObject = document.form;
    	var openver_val = sheetObjects[0].CellValue(Row, "vndr_eml_addr");
    	var x10 = Row;
    	var x11 = openver_val;	// openerval
    	var x12 = ";";	// token
    	var classId = "getTRS_ENS_906";
    	var param ="?returnval="+obj+"&returntitle="+obj2+"&returnrow="+x10+"&openerval="+x11+"&token="+x12;
    	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1', false, false, Row);
    }

    /**
    * Location : 팝업에서 단일 선택을 한경우..
    */
    function getTRS_ENS_906(rowArray, obj, row) {
    	var reObj = "";
    	var formObject = document.form;
    	for(var i=0; i<rowArray.length; i++) {
    		var colArray = rowArray[i];
    		if( i == rowArray.length-1 ) {
    			reObj = reObj + colArray;
    		} else {
    			reObj = reObj + colArray + ";";
    		}
    	}
    	if( obj == "vndr_eml_addr" ) {
    		//formObject.trunk_vvd.value = reObj;
    		sheetObjects[0].CellValue(row, "vndr_eml_addr") = reObj;
    	} else {
    		errMsg = ComGetMsg("TRS90132");
    		ComShowMessage(errMsg);
    	}
    }
    
  /**
   * Row Add한 Row만 삭제.
   * 기존 조회된 Row는 삭제하지 않는다.
   */
 function checkedRowDelete(sheetObj){
	var sRow = sheetObj.FindCheckedRow("chk");
	var rowCnt = sheetObj.RowCount;
  	var arrRow = sRow.split("|");
  	if(rowCnt=="0"){
		errMsg = ComGetMsg("TRS90390");
		ComShowMessage(errMsg);
	   	return;
  	}
    if(sRow ==""){
		errMsg = ComGetMsg("COM12113","S/P");
		ComShowMessage(errMsg);
	   	return;
    }

   	for( var i=arrRow.length-1; i>=0; i-- ) { //Case One으로 넘길 경우)
   		var fmRow = arrRow[i-1];
   		if(sheetObj.RowStatus(fmRow) == "I"){
   			sheetObj.RowDelete(fmRow,false);
   		}else{
   			errMsg = ComGetMsg("COM130302","searched S/P");
   			return;
   		}
    }
}