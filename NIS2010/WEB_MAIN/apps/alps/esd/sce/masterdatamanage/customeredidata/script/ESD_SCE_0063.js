// 공통전역변수
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;
         var opener = window.dialogArguments;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
        	        break;

              case "btns_calendar1":

        	        
                         var cal = new ComCalendar();
            		 cal.select(formObject.sdate, 'yyyy-MM-dd');
        	        break;

        	    case "btns_calendar2":
        	         var cal = new ComCalendar();
            		 cal.select(formObject.edate, 'yyyy-MM-dd');
        	        break;


              	case "btn_close":
    	            self.close();
        	        break;

        	    case "btn_ok":
                    var chkcnt = sheetObject.CheckedRows(0);
        	    	if(chkcnt < 1){
        	    		ComShowMessage('Select check item');
        	    		return false;
        	    	}
        	    	var chkrow = 0;
        	    	var vvds = '';
        	    	for(var a = 0 ; a < chkcnt ; a++){
        	    		chkrow = sheetObject.FindCheckedRow(0).split('|')[a];
        	    		if(a == 0){
        	    			vvds = sheetObject.CellValue(chkrow, "vvd");
        	    		}else{
        	    			vvds = vvds + ',' + sheetObject.CellValue(chkrow, "vvd");
        	    		}
        	    	}
        	    	opener.addVVDNo(vvds, formObject.etdeta.value,formObject.loc_cd.value );
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
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        // 초기화면에서 조회내용을 보기 위한 소스 추후 삭제
         //var sheetObject = sheetObjects[0];
         //var formObject = document.form;
      	 //doActionIBSheet(sheetObject,formObject,IBSEARCH);

    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,etdeta) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(10) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 50);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
					
                    var HeadTitle = "|VVD|Lane|POL|ETD" ;
                    if(etdeta == 'A'){
                    	HeadTitle = "|VVD|Lane|POD|ETA" ;
                    }
                    

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,     daCenter,    false,    "check",        false,         "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       170,    daCenter,    false,    "vvd",          false,         "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       170,    daCenter,    false,    "slan_cd",      false,         "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       170,    daCenter  ,  false,    "pold",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       170,    daCenter  ,  false,    "etda",        false,          "",       dfDateYmd,    0,     false,       true);

               }
                break;

        } 
    }


    function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
       // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
       doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    } 


  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,a,PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) {
                  return false;
                }
               
                formObj.f_cmd.value = SEARCH;                
                selectVal = SceFrmQryString(formObj);
                initSheet(sheetObjects[0],1,formObj.etdeta.value);  
                sheetObj.RemoveAll();
                sheetObj.DoSearch4Post("ESD_SCE_0063GS.do", selectVal); 
                           

           break;
           case IBSEARCHAPPEND:  // 페이징 조회
                
                formObj.f_cmd.value = SEARCH;              
                sheetObj.DoSearch4Post("ESD_SCE_0063GS.do", selectVal, "iPage=" + PageNo, true);  
           break;

        }
    }


   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	
        with(formObj){
            // 필수입력 체크는 임시로 풀어 놓는다.
     	    if(formObj.sdate.value=="" || formObj.edate.value=="") {
      	        ComShowMessage("You must input period");
      	        
      	        if(formObj.sdate.value=="") {
      	          ComSetFocus(formObj.sdate);
      	          return false;
      	        }
      	        
      	        if(formObj.edate.value=="") {
      	          ComSetFocus(formObj.edate);
      	          return false;
      	        }  
      	         	        
      	    }
      	    // 조회 기간을 2주로 제한한다.
      	    var dateinfo = formObj.sdate.value.split("-");	
			var src = new Date(dateinfo[0], dateinfo[1]-1, dateinfo[2]);
			src.setDate(src.getDate() + 14);
			
			var dateinfo2 = formObj.edate.value.split("-");			
			var src2 = new Date(dateinfo2[0], dateinfo2[1]-1, dateinfo2[2]);
			if(src < src2){
				ComShowMessage("Inquiry period is 2 weeks");
  	    		ComSetFocus(formObj.edate);
  	        	return false;
			}
			// 조회기간 제한 END
      	    if(formObj.etdeta.value == 'D'){
      	    	if(formObj.pol_cd.value == ''){
      	    		ComShowMessage("You must input POL");
      	    		ComSetFocus(formObj.pol_cd);
      	        	return false;
      	    	}
      	    	formObj.loc_cd.value = formObj.pol_cd.value;
      	    }else{
      	    	if(formObj.pod_cd.value == ''){
      	    		ComShowMessage("You must input POD");
      	    		ComSetFocus(formObj.pod_cd);
      	        	return false;
      	    	}
      	    	formObj.loc_cd.value = formObj.pod_cd.value;
      	    }
        }
        
                         	        	    
   	    if(!ComIsEmpty(formObj.sdate) && !ComIsEmpty(formObj.edate)){
   	     formObj.sdate_hidden.value =  dateConverting(formObj.sdate.value);
   	     formObj.edate_hidden.value  = dateConverting(formObj.edate.value);   
   	    }else{
      	     formObj.sdate_hidden.value =  "";
       	     formObj.edate_hidden.value  = "" 
   	    }
        return true;
    }
    
    
    /* Function added by Jun Byoung Suk on Data 2009-09-14
     * Purpose      :Converting Date format 
     * Parameters   :String type of date
     * Return Result:Date format without dashed Lines(-)
     * */
    function dateConverting(date){
    	if(date != ''){
    		return ComTrimAll(date, "-");  
    	}//if
    	return '';
    }
    
    
