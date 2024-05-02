
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var selRow = 0;

var isFirst1 = 0;
var isFirst2 = 0;

var rowCnt = 0;



// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var formObject = document.form;
    	var sheetObject0 = sheetObjects[0];
    	var srcName = window.event.srcElement.getAttribute("name");
    	var opener = window.dialogArguments;
    	var dtcheckGub = formObject.mycust.value;
    	/*  2010-03-21 아래 주석처리. 화면 click할때마다 input box의 맨앞으로 포커스 이동하는 문제 발생*/
    	//document.getElementById('cs_cd').value = toUpperCase(document.getElementById('cs_cd').value);
    	//document.getElementById('sc_no').value = toUpperCase(document.getElementById('sc_no').value);
    	//document.getElementById('tp_id').value = toUpperCase(document.getElementById('tp_id').value);
    	//document.getElementById('cs_nm').value = toUpperCase(document.getElementById('cs_nm').value);
		//formObject.temp_cs_cd.value = document.getElementById('cs_cd').value;
		//formObject.temp_sc_no.value = document.getElementById('sc_no').value;
		//formObject.temp_tp_id.value = document.getElementById('tp_id').value;
		//formObject.temp_cs_nm.value = document.getElementById('cs_nm').value;

    	switch(srcName) {
        	    case "btn_retrieve":
        	    	doActionIBSheet0(sheetObject0,formObject,IBSEARCH);
        	    	break;
        	    case "btn_new":
//        	    	doActionIBSheet0(sheetObject0,formObject,COMMAND01);
                    sheetObject0.removeAll();
                    formObject.reset();
                    
        	    	break;
        	    case "btn_ok":
        	    	if (dtcheckGub != '4'){
        	    	var chkcnt = sheetObject0.CheckedRows(0);
        	    	if(chkcnt < 1){
        	    		ComShowMessage('Select check item');
        	    		return false;
        	    	}
        	    	var chkrow = sheetObject0.FindCheckedRow(0).split('|')[0];
        	    	var edi_grp = sheetObject0.CellValue(chkrow, "edi_grp_cd");
        	    	var tp_id = sheetObject0.CellValue(chkrow, "cust_trd_prnr_id");
        	    	var edi_nm = sheetObject0.CellValue(chkrow, "edi_grp_desc");
        	    	}else {
        	    		var chkcnt = sheetObject0.CheckedRows(0);
        	    		var edi_grp = "";
            	    	var tp_id = "";
            	    	var edi_nm = "";
                 		if(chkcnt < 1){
            	    		ComShowMessage('Select check item');
            	    		return false;
            	    	}
        	     				var chkrow = sheetObject0.FindCheckedRow(0);
        	    				var arrRow = chkrow.split("|");
        	    				for (idx= 0; idx < arrRow.length-1; idx++){ 
        	    					if (idx == 0){
        	    						edi_grp = sheetObject0.CellValue(arrRow[idx], "edi_grp_cd");
        	    						tp_id =  "("+sheetObject0.CellValue(arrRow[idx], "edi_grp_cd")+") "+sheetObject0.CellValue(arrRow[idx], "edi_grp_desc");
        	    						edi_nm =  sheetObject0.CellValue(arrRow[idx], "edi_grp_desc");
        	    					}else {
        	    						edi_grp =  edi_grp + ',' + sheetObject0.CellValue(arrRow[idx], "edi_grp_cd");
        	    						tp_id = tp_id + ',' + "("+sheetObject0.CellValue(arrRow[idx], "edi_grp_cd")+") "+sheetObject0.CellValue(arrRow[idx], "edi_grp_desc");
        	    						edi_nm = edi_nm + ','+  sheetObject0.CellValue(arrRow[idx], "edi_grp_desc");
        	    					}
        	    			}
           	    	}
        	    	opener.openESD009Screen(edi_grp, tp_id, edi_nm);
        	    	self.close();
        	    
        	    	break;
        	    
        	    case "btn_save":
    	            var chkrow = sheetObject0.FindCheckedRow(0).split('|')[0];  
                    if(chkrow != ""){
        	           doActionIBSheet0(sheetObject0,formObject,IBSAVE);
//        	           if(formObject.mycust.value != "1"){
//            	           window.opener.openfunction();      // page reloading        	               
//        	           }
                    } else {
                        ComShowMessage("Select check item");
                    }
//        	        self.close();
        	        break;
        	    case 'btn_close':
        	        if(formObject.mycust.value == "1" && formObject.sendClose.value == "reload"){
        	            opener.openfunction();   // page reloading
        	        }
        	    	self.close();
        	    	break;
    	}
    	
    }
    
    function openCustomer(){
    	var sheetObject0 = sheetObjects[0];
//    	alert(sheetObject0.CheckedRows(0));
    }

    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
        }  
        return str;      
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
//        doActionIBSheet0(sheetObjects[0],document.form,IBSEARCH);
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var formObject = document.form; 
        var dtcheckGub = formObject.mycust.value;

        switch(sheetNo) {
            case 1:     //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(12) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, false);
                    if (dtcheckGub == '4'){
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);
                    }else {
                    	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);	
                    }
                    var HeadTitle = "|GroupId|EDI ID|Customer Name";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    if (dtcheckGub == '4'){
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,    "chk",              false,          "",       dfNone,   	0,     true,        true);//check box
                    }else {
                    InitDataProperty(0, cnt++ , dtRadioCheck,   30,    daCenter,  false,    "chk",              false,          "",       dfNone,   	0,     true,        true);//check box
                    }
                    InitDataProperty(0, cnt++ , dtData,         110,    daCenter,  true,    "edi_grp_cd",     	false,          "",     dfNone ,      0,     false,       true,          30);       
                    InitDataProperty(0, cnt++ , dtData,         110,    daCenter,  true,    "cust_trd_prnr_id", false,          "",      dfNone,      0,     false,       true,          30); 
                    InitDataProperty(0, cnt++ , dtData,         120,    daLeft,  true,    "edi_grp_desc", false,          "",      dfNone,      0,     false,       true,          30); 
              }
                break;

        }
    }
    
// Sheet관련 프로세스 처리
    function doActionIBSheet0(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var opener = window.dialogArguments;
        switch(sAction) {
           case IBSEARCH:      //조회           
		        formObj.f_cmd.value = SEARCH01;
		        sheetObj.DoSearch4Post("ESD_SCE_0062GS.do", SceFrmQryString(formObj));		        
                break;
            case IBSAVE:

                var chkrow = sheetObj.FindCheckedRow(0).split('|')[0]; 
                formObj.temp_edi_grp.value = sheetObj.CellValue(chkrow, "edi_grp_cd");
                formObj.temp_edi_id.value = sheetObj.CellValue(chkrow, "cust_trd_prnr_id");
                formObj.temp_edi_nm.value = sheetObj.CellValue(chkrow, "edi_grp_desc");
                
                formObj.f_cmd.value = SEARCH02;
		        var sXml = sheetObj.GetSearchXml("ESD_SCE_0062GS.do", SceFrmQryString(formObj));
				var cust_cnt = ComGetEtcData(sXml, "cust_cnt");

				if(cust_cnt == '0'){
                    ComShowMessage("SAVED SUCCESSFULLY");
                    formObj.sendClose.value = "reload";
                    if(formObj.mycust.value != "1"){
        	            opener.openfunction();      // page reloading     
        	            self.close();
    	            }

                } else {
                    ComShowMessage("Already Exisiting in my Cust");
                }
        }
    }
    
