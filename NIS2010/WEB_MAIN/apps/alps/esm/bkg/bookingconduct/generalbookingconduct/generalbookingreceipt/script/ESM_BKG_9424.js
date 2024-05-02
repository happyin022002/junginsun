/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_9424.js
*@FileTitle : Empty Repo BKG Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.18 김병규
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
     * @class ESM_BKG_9424 : ESM_BKG_9424 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_9424() {
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
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var oldPodCd = "";
	var oldInterRmk = "";
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var sheetObject3 = sheetObjects[2];
        var sheetObject6 = sheetObjects[5];

        /*******************************************************/
        var formObject = document.form;
  		var bkgNo = ComGetObjValue(formObject.bkg_no);
		var blNo = ComGetObjValue(formObject.bl_no);
		var bkgMvmtCd = ComGetObjValue(formObject.bkg_mvmt_cd);
		
     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

    		if(srcName != "btn_splitPop"){
        		if(layList.style.display == ""){
        			layList.style.display="none";
        		}    	    			
    		}	     		
     		
            switch(srcName) {
	         	case "btns_EventDt":
		            var cal = new ComCalendar();
		            cal.select(formObject.cnmv_evnt_dt, 'yyyy-MM-dd hh:mm');           
					break;    
					
                case "btn_Ts":
  		        	if(ComGetObjValue(formObject.bkg_trunk_vvd) == ""){
 		        		ComShowCodeMessage("BKG00448");
  		        	}else{
  		        		ComOpenPopup("ESM_BKG_9454.do?pgmNo=ESM_BKG_9454&bkg_no="+bkgNo, 600, 480, "","1,0,1,1,1", true);
  		        	}                	 
                    break;

                case "btn_BtmRetrive":
              		if(bkgNo != null && bkgNo.length > 0){
            			ComResetAll();
            			ComSetObjValue(formObject.bkg_no,bkgNo);
            			ComSetObjValue(formObject.bkg_mvmt_cd, bkgMvmtCd);
            			doActionIBSheet(sheetObject, formObject, IBSEARCH);            			
            		}else if(blNo != null && blNo.length > 0){
            			ComResetAll();
            			ComSetObjValue(formObject.bl_no,blNo);
            			ComSetObjValue(formObject.bkg_mvmt_cd, bkgMvmtCd);
            			doActionIBSheet(sheetObject, formObject, IBSEARCH);               			
            		}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObject.bkg_no);            			
            		}
                     break;

                case "btn_BtmNew":
                	ComResetAll();
     				ComBtnEnable("btn_Add");
    				ComBtnEnable("btn_Delete");
    				ComBtnEnable("btn_Move");
    				ComBtnEnable("btn_BtmSave");                	 
                    break;

 		        case "btn_BtmSave":
 		        	if(validateForm(sheetObject,formObject,IBSAVE)){
            			if(ComShowCodeConfirm("BKG00824")){
            				doActionIBSheet(sheetObject, formObject, IBSAVE);
            			} 		 		        		 		        		
 		        	}
                    break;

 		        case "btn_BtmCancel":
 		        	if(ComGetObjValue(formObject.bkg_trunk_vvd) == ""){
 		        		ComShowCodeMessage("BKG00448");
 		        	}else if(sheetObjects[0].RowCount > 0){
 		        		ComShowCodeMessage("BKG00825");
 		        	}else{
            			if(ComShowCodeConfirm("BKG00575")){
            				doActionIBSheet(sheetObject, formObject, MULTI02);
            			} 		        		 		        		
 		        	}
                    break;
                    
 		        /** Left Group **/
 		        case "btn_ExcelFormat":
 		        	sheetObject6.RemoveAll();
 		        	sheetObject6.DataInsert(-1);
 		        	sheetObject6.Down2Excel(-1);
 		            break;
 		            
                case "btn_LoadExcel":
//                	//load hidden sheet
//                	sheetObject6.RemoveAll();
//                	sheetObject6.LoadExcel();
                	
                	//copy hidden sheet to cntr sheet 
//                	copyHiddenSheetToCntrSheet();
                	
                	sheetObject.LoadExcel();
                    break;

 		        case "btn_DownExcel":
// 		        	//copy cntr sheet to hidden sheet
// 		        	sheetObject6.RemoveAll();
// 		        	copyCntrSheetToHiddenSheet();
// 		        	
// 		        	//download hidden sheet 
// 		        	sheetObject6.Down2Excel(-1);
 		        	
 		        	sheetObject.Down2Excel(-1);
                    break;

 		        case "btn_Add":
 		        	sheetObject.DataInsert(-1);
 		        	break;

                case "btn_Delete":
                	// STS코드가 'VL' 인 경우는 삭제할 수 없다.
                	// BkG NO가 없는 VL은 삭제가능(20091117 추가)
                	var isDelete = true;                	 
                	for(var i = sheetObject.HeaderRows ; i < sheetObject.Rows ; i++){
                		if(sheetObject.CellValue(i, "chk") == 1 && sheetObject.CellValue(i, "sts_cd") == "VL" && sheetObject.CellValue(i, "pre_sts_cd") == "N"){                			 
                			ComShowCodeMessage("BKG08041", sheetObject.CellValue(i, "cntr_no"));                			 
                			isDelete = false;
                			break;
                		}
                	}
                	 
                	if(isDelete){
                    	ComRowHideDelete(sheetObject,"chk");
                    	setEmptyContainerQty("B");                		 
                	}
/*                	if(sheetObject.CellValue(sheetObject.SelectRow, "ibflag") != "D"){
                 		var selTpSz = sheetObjects[1].FindText("tpsz_cd", sheetObject.CellValue(sheetObject.SelectRow, "tpsz_cd"));
                		
                		if(selTpSz >= 0){
                			sheetObjects[1].CellValue(selTpSz, "r_qty") =  BkgParseInt(sheetObjects[1].CellValue(selTpSz, "r_qty")) - 1;
                		}                	 
                		sheetObject.RowHidden(sheetObject.SelectRow) = true;
                    	sheetObject.RowStatus(sheetObject.SelectRow)= "D";
                    	
                    	setEmptyContainerQty("B");
                    	setEmptyContainerColor();          
                	}*/
                    break;

 		        case "btn_Mty":
 		        	if(ComGetObjValue(formObject.bkg_trunk_vvd) != ""){
 		        		var vvd = ComGetObjValue(formObject.bkg_trunk_vvd);
 		        		var ydCd = ComGetObjValue(formObject.org_yd_cd);
 		        		ComOpenPopup("ESM_BKG_9455.do?pgmNo=ESM_BKG_9455&vvd="+vvd+"&yd_cd="+ydCd, 300, 510, "callBack9455","0,1,1,1,1", true);	
		        	}else{ 		        		
		        		ComShowCodeMessage("BKG00448");
		        	}
                     break;

 		        case "btn_auto":
//                  alert("btn_auto");
                    break;

 		        case "btn_Bundle":
 		        	setBundle();
                    break;

 		        case "btn_Rmk":
 		        	if(ComGetObjValue(formObject.bkg_trunk_vvd) != ""){
 		        		ComOpenPopup("ESM_BKG_0913.do?pgmNo=ESM_BKG_0913&screen_id=9424", 500, 345, "callBack0913","0,1,1,1,1", true);	
		        	}else{ 		        		
 		        		ComShowCodeMessage("BKG00448");
 		        	} 		        	
                    break;

                /** Right Group **/
                case "btn_Move":
                	if(sheetObject3.CheckedRows("chk") < 1){
                		ComShowCodeMessage("BKG00155");
                	}else{                		 
                		ComOpenWait(true);
                		for(var i = sheetObject3.HeaderRows ; i < sheetObject3.Rows ; i++){
                			if(sheetObject3.CellValue(i, "chk") == 1){
                				// Repo Container가 없는 경우에만 새로 추가한다.
                				var findRow = sheetObject.FindText("full_cntr_no",sheetObject3.CellValue(i, "full_cntr_no"));
                				if(findRow < 0){
                					var addRow = sheetObject.DataInsert(-1);
                					sheetObject.CellValue2(addRow, "cntr_no")	  = sheetObject3.CellValue(i, "cntr_no");
                					sheetObject.CellValue2(addRow, "cntr_no_pst") = sheetObject3.CellValue(i, "cntr_no_pst");
                					sheetObject.CellValue2(addRow, "tpsz_cd") 	  = sheetObject3.CellValue(i, "tpsz_cd");
                					sheetObject.CellValue2(addRow, "sts_cd") 	  = sheetObject3.CellValue(i, "sts_cd");
                					sheetObject.CellValue2(addRow, "full_cntr_no")= sheetObject3.CellValue(i, "full_cntr_no");
                					if("S"==ComGetObjValue(formObject.mvmt_option)){
                						sheetObject.CellValue2(addRow, "pre_sts_flg") = "Y";
                					} else {
                						sheetObject.CellValue2(addRow, "pre_sts_flg") = sheetObject3.CellValue(i, "pre_sts_flg");
                					}
            				 	}else{
            				 		if(sheetObject.RowStatus(findRow) == "D"){
            				 			sheetObject.RowHidden(findRow) = false;
                	                    sheetObject.RowStatus(findRow) = "R";                						 
                					}
                				}
                			}
                		}                		
                		setEmptyContainerQty("B"); 
                		ComOpenWait(false);
                	}
                    break;

 		        case "btn_CheckAll":
 		        	sheetObjects[2].CheckAll("chk") = 2; 
                    break;

 		        case "btn_Retrive":
 		        	if(ComGetObjValue(formObject.bkg_trunk_vvd) != ""){
 		        		doActionIBSheet(sheetObjects[2], formObject, SEARCHLIST12);  
 		        	}else{
 		        		ComShowCodeMessage("BKG00448");
 		        	}
                    break;
                    
				case "btn_splitPop":			
					doActionIBSheet(sheetObjects[4],formObject,COMMAND03);					
					break;                     
     		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111"); 
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
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
        }      
        ComSetFocus(document.form.bkg_no);	
        
        if(!ComIsNull(document.form.bkg_no)){
        	if(ComGetObjValue(document.form.bkg_div) == "1"){
        		ComSetObjValue(document.form.bkg_mvmt_cd, "VL");
        	} else {
        		ComSetObjValue(document.form.bkg_mvmt_cd, "VD");        		
        	}
//    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);       			
    	}        
    }

	function initControl() {
	   	var formObject = document.form;
		
	   	axon_event.addListenerFormat('keypress','bkg9424_keypress',formObject); //- 키보드 입력할때
	   	axon_event.addListenerForm('click', 'bkg9424_click',    formObject); //- 클릭시
	}              
   
    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
        	case 1:      //t1sheet1 init
        		with (sheetObj) {
        			// 높이 설정
                    style.height = 382;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Chk|Seq.|Container No.|TP/SZ|STS|BD & B||HRT|HBT|HBQ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,    	0,   daLeft,  	false,     "ibflag" );
                    InitDataProperty(0, cnt++ , dtCheckBox,    		45,  daCenter,  false,     "chk");
                    InitDataProperty(0, cnt++ , dtDataSeq,      	40,  daCenter,  false,     "seq");
                    InitDataProperty(0, cnt++ , dtData,    			110, daCenter,  false,     "full_cntr_no",     		false,	"",      dfNone,  			0,        false,    true,      11,     true);  
                    InitDataProperty(0, cnt++ , dtData,      		50,  daCenter,  false,     "tpsz_cd",     			false,	"",      dfNone,  			0,        false,   	false);
                    InitDataProperty(0, cnt++ , dtData,      		40,  daCenter,  false,     "sts_cd",     			false,	"",      dfNone,  			0,        false,	false);
                    // 20091111 Bundle 수정못하도록 수정(현업요청)
                    InitDataProperty(0, cnt++ , dtData,      		50,  daCenter,  false,     "bdl_no",     			false,	"",      dfNullInteger,  	0,        false,    false);
                    InitDataProperty(0, cnt++ , dtCheckBox,      	13,  daCenter,  false,     "bdl_btm_flg");
                    InitDataProperty(0, cnt++ , dtData,      		40,  daCenter,  false,     "cntr_hngr_rck_cd",  	false,	"",      dfNone,  			0,        false,    false);
                    InitDataProperty(0, cnt++ , dtData,      		40,  daCenter,  false,     "mnr_hngr_bar_tp_cd",  	false,  "",      dfNone, 			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      		40,  daCenter,  false,     "cntr_hngr_bar_atch_knt",false,  "",      dfNone, 			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,    		0,   daLeft,  	false,     "pre_sts_flg" );
                    InitDataProperty(0, cnt++ , dtHidden,      		0,   daCenter,  false,     "cntr_no");
                    InitDataProperty(0, cnt++ , dtHidden,      		0,   daCenter,  false,     "cntr_no_pst");                  
                     
                    InitDataValid(0,  "full_cntr_no",				vtEngUpOther,	"1234567890");		// 영문대문자+숫자 입력                     
                    ScrollBars = 2;

                    CountPosition = 0;
                     
                    sheetObjects[0].ToolTipOption="balloon:true;width:250;backcolor:#FFFFFF;forecolor:#000000;icon:1";
            		sheetObjects[0].ToolTipText(0,6) = "Bundle & Bottom";
            	    sheetObjects[0].ToolTipText(0,7) = "Bundle & Bottom";
                }
                break;

            case 2:      //t1sheet1 init
            	with (sheetObj) {
            		// 높이 설정
            		style.height = 382;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|TP/SZ|B.QTY|R.QTY|R.QTY|hngr_r_qty";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,     0,     daLeft,    false,     	"ibflag" );
                    InitDataProperty(0, cnt++ , dtData,      		40,    daCenter,  false,    	"tpsz_cd",     	false,          "",      dfNone,  		0,        false,    false);
                    InitDataProperty(0, cnt++ , dtData,      		47,    daCenter,  false,     	"b_qty",     	false,          "",      dfNullInteger, 0,        false,    false);
                    InitDataProperty(0, cnt++ , dtHidden,      		67,    daCenter,  false,     	"r_qty",     	false,          "",      dfNullInteger, 0,        false,    false);
                    InitDataProperty(0, cnt++ , dtData,      		52,    daCenter,  false,     	"show_r_qty",   false,          "",      dfNone,		0,        false,    false);
                    InitDataProperty(0, cnt++ , dtHidden,      		67,    daCenter,  false,     	"hngr_r_qty",   false,          "",      dfNullInteger, 0,        false,    false);

                    ScrollBars = 2;
                          
 					CountPosition = 0;                    
               	}
               	break;

            case 3:      //sheet3 init
            	with (sheetObj) {
            		// 높이 설정
                    style.height = 382;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Seq.|Chk|Container No.|Container No.|TP/SZ|STS|EDI POD";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,    	0,    	daLeft,  	false,     "ibflag" );
                    InitDataProperty(0, cnt++ , dtDataSeq,      	30,    	daCenter,  	false,     "seq");
                    InitDataProperty(0, cnt++ , dtCheckBox,    		25,    	daCenter,  	false,     "chk");
                    InitDataProperty(0, cnt++ , dtData,      		75,  	daCenter,  	false,     "cntr_no",     	false,          "",      dfNone,  		0,        false,    false,      10,     true);
                    InitDataProperty(0, cnt++ , dtData,      		20,  	daCenter,  	false,     "cntr_no_pst",  	false,          "",      dfNone,  		0,        false,    false);                     
                    InitDataProperty(0, cnt++ , dtData,      		40,    	daCenter,  	false,     "tpsz_cd",     	false,          "",      dfNone,  		0,        false,   	false);
                    InitDataProperty(0, cnt++ , dtData,      		35,    	daCenter,  	false,     "sts_cd",     	false,          "",      dfNone,  		0,        false,	false);
                    InitDataProperty(0, cnt++ , dtData,      		40,    	daCenter,  	false,     "pod_cd",    	false,          "",      dfNone,  		0,        false,    false);
                    InitDataProperty(0, cnt++ , dtHidden,    		0,    	daLeft,  	false,     "full_cntr_no" );
                    InitDataProperty(0, cnt++ , dtHidden,    		0,    	daLeft,  	false,     "pre_sts_flg" );
                     
                    ScrollBars = 2;
                          
 					CountPosition = 0;                
                }
                break;

            case 4:      //sheet4 init
            	with (sheetObj) {
            		// 높이 설정
                    style.height = 382;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|TP/SZ|QTY";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,     0,     daLeft,    false,     	"ibflag" );
                    InitDataProperty(0, cnt++ , dtData,      		40,    daCenter,  false,    	"tpsz_cd",     	false,          "",      dfNone,  		0,        false,    false);
                    InitDataProperty(0, cnt++ , dtAutoSum,      	47,    daCenter,  false,     	"qty",     		false,          "",      dfNullInteger, 0,        false,    false);

                    ScrollBars = 2;
                          
 					CountPosition = 0;
                }
                break;
                
	        case 5:
	        	with (sheetObj) {
	        		// 높이 설정
	        		style.height = 0;
	        		// 전체 너비 설정
	        		SheetWidth = mainTable.clientWidth;

	        		//Host정보 설정[필수][HostIp, Port, PagePath]
	        		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	        		//전체Merge 종류 [선택, Default msNone]
	        		MergeSheet = msHeaderOnly;
	        		
	        		//전체Edit 허용 여부 [선택, Default false]
	        		Editable = true;

	        		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	        		InitRowInfo(1, 1, 7, 100);

	        		var HeadTitle1 = "|TP/SZ|VOL";
	        		var headCount = ComCountHeadTitle(HeadTitle1);
	 										
	        		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	        		InitColumnInfo(16, 0, 0, true);

	        		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	        		InitHeadMode(true, true, false, true, false,false);

	        		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	        		InitHeadRow(0, HeadTitle1, true);
	        		
	        		//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	        		InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,		false,			"ibflag");
	        		InitDataProperty(0, cnt++ , dtData,				50,     daCenter,    	false,			"cntr_tpsz_cd",	false,    	"",   dfNone, 			0,     	true,		true);
	        		InitDataProperty(0, cnt++ , dtData,      		55,     daRight,     	false,     		"op_cntr_qty",  false,    	"",   dfNullFloat,		2,     	true,		true);
	        		
	        		CountPosition = 0;		// Total 없음.    	 										
	 			}
	        	break;  	   
	    case 6:      //sheet for excel load/down
	        with (sheetObj) {
    			// 높이 설정
                style.height = 382;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(13, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                var HeadTitle = "|Chk|Seq.|Container No.|TP/SZ|STS|BD & B||HRT|HBT|HBQ";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    	0,   daLeft,  	false,     "ibflag" );
                InitDataProperty(0, cnt++ , dtCheckBox,    		45,  daCenter,  false,     "chk");
                InitDataProperty(0, cnt++ , dtDataSeq,      	40,  daCenter,  false,     "seq");
                InitDataProperty(0, cnt++ , dtData,      		90,  daCenter,  false,     "full_cntr_no",     		false,	"",      dfNone,  			0,        false,    true,      10,     true);   
                InitDataProperty(0, cnt++ , dtData,      		50,  daCenter,  false,     "tpsz_cd",     			false,	"",      dfNone,  			0,        false,   	false);
                InitDataProperty(0, cnt++ , dtData,      		40,  daCenter,  false,     "sts_cd",     			false,	"",      dfNone,  			0,        false,	false);
                // 20091111 Bundle 수정못하도록 수정(현업요청)
                InitDataProperty(0, cnt++ , dtData,      		50,  daCenter,  false,     "bdl_no",     			false,	"",      dfNullInteger,  	0,        false,    false);
                InitDataProperty(0, cnt++ , dtCheckBox,      	13,  daCenter,  false,     "bdl_btm_flg");
                InitDataProperty(0, cnt++ , dtData,      		40,  daCenter,  false,     "cntr_hngr_rck_cd",  	false,	"",      dfNone,  			0,        false,    false);
                InitDataProperty(0, cnt++ , dtData,      		40,  daCenter,  false,     "mnr_hngr_bar_tp_cd",  	false,  "",      dfNone, 			0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,      		40,  daCenter,  false,     "cntr_hngr_bar_atch_knt",false,  "",      dfNone, 			0,		false,		false);
                InitDataProperty(0, cnt++ , dtHidden,    		0,   daLeft,  	false,     "cntr_no" );
                InitDataProperty(0, cnt++ , dtHidden,    		0,   daLeft,  	false,     "pre_sts_flg" );
                 
                InitDataValid(0,  "cntr_no",				vtEngUpOther,	"1234567890");		// 영문대문자+숫자 입력                     
                ScrollBars = 2;

                CountPosition = 0;
            }
            break;
        }
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction){
            case IBSEARCH:      //조회
            	ComSetObjValue(formObj.f_cmd, SEARCH);
//            	ComOpenWait(true);
        		sheetObj.WaitImageVisible=false;
    			var sXml = sheetObj.GetSearchXml("ESM_BKG_9424GS.do", FormQueryString(formObj));
        		sheetObj.WaitImageVisible=true;
    			var arrXml = sXml.split("|$$|");  
    			
				if (arrXml.length > 0){    				
					sheetObjects[0].WaitImageVisible=false;
					sheetObjects[0].LoadSearchXml(arrXml[0]);
					sheetObjects[0].WaitImageVisible=true;
				}        
				if (arrXml.length > 1){    				
					sheetObjects[2].WaitImageVisible=false;
					sheetObjects[2].LoadSearchXml(arrXml[1]);
					sheetObjects[2].WaitImageVisible=true;
				}       				
				if (arrXml.length > 2){    				
					sheetObjects[1].WaitImageVisible=false;
					sheetObjects[1].LoadSearchXml(arrXml[2]);
    				sheetObjects[1].WaitImageVisible=true;  	
    				
					sheetObjects[3].WaitImageVisible=false;
    				sheetObjects[3].LoadSearchXml(arrXml[2]);  
    				sheetObjects[3].WaitImageVisible=true;  				
				}    
				if (arrXml.length > 3){    				
					sheetObjects[4].WaitImageVisible=false;
					sheetObjects[4].LoadSearchXml(arrXml[3]);
					sheetObjects[4].WaitImageVisible=true;
				}    				
    			BkgEtcDataXmlToForm(arrXml[0], formObj);		
				var splitFlg = ComGetEtcData(arrXml[0], "split_flg");

				if(splitFlg == "Y"){
					ComSetObjValue(formObj.split,"Split");
//	    			document.getElementById("bkg_pod_cd").className  = "noinput2";
				}else{
					ComSetObjValue(formObj.split,"");
//					if(ComGetObjValue(formObj.bkg_mvmt_cd) == "VL"){
//		    			document.getElementById("bkg_pod_cd").className  = "input";
//					} else {
//		    			document.getElementById("bkg_pod_cd").className  = "noinput2";
//					}
				}
				oldPodCd = formObj.bkg_pod_cd.value;
				oldInterRmk = formObj.inter_rmk.value;
				
    			if(sheetObjects[0].RowCount > 0){
    				setEmptyContainerQty("A");	
    			}else{
    				setEmptyQty();
    			}
    			
    			setVlContainerQty();
//            	ComOpenWait(false);
    			var saveDisable = false;

    			if(ComGetEtcData(arrXml[0], "SuccessYn") == "Y"){
        			// 1. VL 일때 Split Booking 인 경우 입력불가    			
        			// 2. VD 일때 원본 Booking 인 경우 입력불가
        			if(ComGetObjValue(formObj.bkg_mvmt_cd) == "VL"){
        				if(ComGetObjValue(formObj.bkg_no).length ==13 || (ComGetObjValue(formObj.bkg_no).length ==12 && ComGetObjValue(formObj.bkg_no).substring(ComGetObjValue(formObj.bkg_no).length-2,ComGetObjValue(formObj.bkg_no).length) != "00")){
        					saveDisable = true;
        				}
        			}else if(ComGetObjValue(formObj.bkg_mvmt_cd) == "VD"){
        				if (ComGetObjValue(formObj.bkg_no).length == 11 || (ComGetObjValue(formObj.bkg_no).length ==12 && ComGetObjValue(formObj.bkg_no).substring(ComGetObjValue(formObj.bkg_no).length-2,ComGetObjValue(formObj.bkg_no).length) == "00")){
        					saveDisable = true;
        				}
        			}
        			if(saveDisable){
        				disableSaveButton();
        			}else{
        				enableSaveButton();
        			}        			
    			}else{
    				disableSaveButton();   				
    			}
    			// Cancel된 경우 Save,Cancel버튼 Disable    			
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){
    				disableSaveButton();  			
    			}
    			
    			// Container가 존재하면 Cancel 할 수 없다.
    			if(sheetObj.RowCount > 0){
    				ComBtnDisable("btn_BtmCancel");
    			}
    			if(ComIsNull(formObj.inter_rmk)){
    				ComBtnColor("btn_Rmk","#737373");
    			}else{
    				ComBtnColor("btn_Rmk","blue");			
    			}   	    			
    			sheetObjects[0].CheckAll("chk") = 0;
                break;
                
            case SEARCHLIST12:        // Stowage Plan 조회
            	// vd일 때 mty cntr, stwg cntr 조회 없음
            	if(ComGetObjValue(formObj.bkg_mvmt_cd) == "VD"){
            		break;
            	}
				ComSetObjValue(formObj.f_cmd, SEARCHLIST12);
				sheetObj.DoSearch("ESM_BKG_9424GS.do?mvmt_option="+ComGetObjValue(formObj.mvmt_option), FormQueryString(formObj));   
				setVlContainerQty();				
				break;
				
            case MULTI02:        // Cancel
              	ComSetObjValue(formObj.f_cmd, MULTI02);              
              	var sXml = sheetObj.GetSaveXml("ESM_BKG_9424GS.do", FormQueryString(formObj));  
              	sheetObj.LoadSearchXml(sXml);
              	if(ComGetEtcData(sXml, "SuccessYn") == "Y"){              		
              		ComShowCodeMessage("BKG00590");
              		doActionIBSheet(sheetObj, formObj, IBSEARCH);
              	}				
				break;
				
            case IBSAVE:        //저장
            	ComSetObjValue(formObj.f_cmd, MULTI01);
        		ComOpenWait(true);
            
            	// 기존 one transaction 방식
//            	var params = FormQueryString(formObj);
//            	params = params + "&" + ComSetPrifix(sheetObj.GetSaveString(true),"sheet1_");	
//            	var sXml = sheetObj.GetSaveXml("ESM_BKG_9424GS.do", params);
//            	sheetObj.LoadSearchXml(sXml);
//
//            	if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
//            		var extraMsg = false;
//            		for(var i = sheetObjects[0].HeaderRows ; i < sheetObjects[0].Rows ; i++){
//            			if(sheetObjects[0].CellValue(i, "ibflag") == "I" || sheetObjects[0].CellValue(i, "ibflag") == "U"){
//            				if(sheetObjects[0].CellValue(i, "sts_cd") != "VL"){
//            					extraMsg = true;
//            					break;
//            				}
//            			}
//            		}
//	
//            		if(extraMsg){
//            			ComShowCodeMessage("BKG02026");
//            		}else{
//            			ComBkgSaveCompleted();
//            		}
//            		doActionIBSheet(sheetObj, formObj, IBSEARCH);
//            	}

	        	var params = "";	
	    		sheetObj.WaitImageVisible=false
	    		
	    		var isSave = false;
            	//단건 호출  방식
	        	for(var i = sheetObj.HeaderRows + 1; i < sheetObj.Rows ; i++){
	        		//모든 row의 색 초기화
	        		sheetObj.CellFontColor(i, "full_cntr_no") = sheetObj.RgbColor(0, 0, 0); 
	        	}       		
        		
            	for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
            		sheetObj.SelectCell(i,"full_cntr_no");
            		params = FormQueryString(formObj);

               		// 첫번째 호출시 pod가 바뀌어있으면 호출
            		if("R"==sheetObj.RowStatus(i)){
	            		//수정된 것이 없으면 skip
	            		sheetObj.CellFontColor(i, "cntr_no") = sheetObj.RgbColor(0, 0, 255);
            		} else {
	            		params = params  + "&sheet1_" + "ibflag=" 		+ sheetObj.RowStatus(i)
	            						 + "&sheet1_" + "chk=" 			+ sheetObj.CellValue(i, "chk")
	            						 + "&sheet1_" + "seq="			+ sheetObj.CellValue(i, "seq")
	            						 + "&sheet1_" + "cntr_no="		+ sheetObj.CellValue(i, "cntr_no")
	            						 + "&sheet1_" + "cntr_no_pst="	+ sheetObj.CellValue(i, "cntr_no_pst")
	            						 + "&sheet1_" + "tpsz_cd="		+ sheetObj.CellValue(i, "tpsz_cd")
	            						 + "&sheet1_" + "sts_cd="		+ sheetObj.CellValue(i, "sts_cd")
	            						 + "&sheet1_" + "bdl_no="		+ sheetObj.CellValue(i, "bdl_no")
	            						 + "&sheet1_" + "bdl_btm_flg="	+ sheetObj.CellValue(i, "bdl_btm_flg")
	            						 + "&sheet1_" + "full_cntr_no="	+ sheetObj.CellValue(i, "full_cntr_no")
	            						 + "&sheet1_" + "pre_sts_flg=" 	+ sheetObj.CellValue(i, "pre_sts_flg");
	//	            	params = params + "&" + ComSetPrifix(sheetObj.GetSaveString(true),"sheet1_");	
		            	var sXml = sheetObj.GetSaveXml("ESM_BKG_9424GS.do", params);
		
		            	if(ComGetEtcData(sXml, "SuccessYn") != "Y"){
	            			//error이면 바로 중지
	            			ComOpenWait(false);
			            	sheetObj.LoadSearchXml(sXml);
	            			return false;
		            	} else {
		            		//저장 성공된 cntr는 파란색 표시, STATUS "R"로 변경(재 저장 하지 않음)
		            		sheetObj.CellFontColor(i, "full_cntr_no") = sheetObj.RgbColor(0, 0, 255); 
		            		sheetObj.RowStatus(i) = "R";
		            		isSave = true;
		            	}
            		}
            	}            	

            	//cntr는 없고 pod만 바뀐 경우
            	if(isSave == false 
            			&& (oldPodCd != formObj.bkg_pod_cd.value || oldInterRmk != formObj.inter_rmk.value)){
            		params = FormQueryString(formObj);
	            	var sXml = sheetObj.GetSaveXml("ESM_BKG_9424GS.do", params);
	        		
	            	if(ComGetEtcData(sXml, "SuccessYn") != "Y"){
            			//error이면 바로 중지
            			ComOpenWait(false);
		            	sheetObj.LoadSearchXml(sXml);
            			return false;
	            	} else {
	            		//저장 성공된 cntr는 파란색 표시, STATUS "R"로 변경(재 저장 하지 않음)
	            		sheetObj.CellFontColor(i, "full_cntr_no") = sheetObj.RgbColor(0, 0, 255); 
	            		sheetObj.RowStatus(i) = "R";
	            	}
            	}
            	
            	//전부 성공시에만 재조회
            	ComOpenWait(false);
        		var extraMsg = false;
        		for(var i = sheetObjects[0].HeaderRows ; i < sheetObjects[0].Rows ; i++){
        			if(sheetObjects[0].CellValue(i, "ibflag") == "I" || sheetObjects[0].CellValue(i, "ibflag") == "U"){
        				if(sheetObjects[0].CellValue(i, "sts_cd") != "VL"){
        					extraMsg = true;
        					break;
        				}
        			}
        		}
        		if(extraMsg){
	    			ComShowCodeMessage("BKG02026");
	    		}else{
	    			ComBkgSaveCompleted();
	    		}
        		doActionIBSheet(sheetObj, formObj, IBSEARCH);
               	break;
			case COMMAND03:      //booking split no조회 
				if(!ComIsNull(formObj.bkg_no)){
					ComSetObjValue(formObj.f_cmd, COMMAND03);
				 	var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
				 	var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
				 	bkgSplitNoListPop(formObj.bkg_no,bkg_split_no_list,15,145);         						
				}
				break;               	
        }        
    }

	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSAVE:      // Save    		
				if(ComGetObjValue(formObj.bkg_trunk_vvd) == ""){		// 조회없이 저장시
					ComShowCodeMessage("BKG00448");
					return false;
				}
		  		//pod 변경시
		  		if(ComIsNull(formObj.bkg_pod_cd) || formObj.bkg_pod_cd.value.length != 5){
					ComShowCodeMessage("BKG02061");
		  			return false;		  			
		  		}		  		
		  		if(oldPodCd != formObj.bkg_pod_cd.value && formObj.bkg_pod_cd.value != "XXXXX"){
					ComShowCodeMessage("BKG02061");
			  		return false;
		  		}
		  		
		  		// Save할 대상이 없는 경우
		  		if(sheetObj.RowCount < 1 
		  				&& (oldPodCd == formObj.bkg_pod_cd.value|| oldInterRmk == formObj.inter_rmk.value)){
					ComShowCodeMessage("BKG00155");
					return false;    	  			
		  		}		  		
		  		
		  		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
		  			if(sheetObj.RowStatus(i) != "D"){
		  				var stsCd = sheetObj.CellValue(i, "sts_cd"); 
		    	  		// Cntr Sts가 'MT','VL','ID'가 아니면 에러.
		  				// 20091111 현업요청으로 Validation 제거
//		  				if(stsCd != "MT" && stsCd != "VL" && stsCd != "ID"){
//		  					ComShowCodeMessage("BKG00951", sheetObj.CellValue(i, "cntr_no"), stsCd);
//		  					return false;    	  					
//		  				}
		    	  		// Bundle 필수 TP/SZ 여부 확인.
		  				var cntrTpsz = sheetObj.CellValue(i, "tpsz_cd");
		  				if(sheetObj.CellValue(i, "bdl_no") != ""){
		  					if(cntrTpsz != "F2" && cntrTpsz != "F4" && cntrTpsz != "F5" && cntrTpsz != "A2" && cntrTpsz != "A4" && cntrTpsz != "A5"){
		  						ComShowCodeMessage("BKG00822");
			  					return false;
			  				}
			  			}
			  		}
			  	}
		  		// 20091217 추가 - Bundle에 Bottom Indicator가 없으면 에러.
		  		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
		  			var btmFlg = true;
		  			var bdlNo = sheetObj.CellValue(i, "bdl_no");		  			
		  			if(bdlNo != "" && sheetObj.CellValue(i, "bdl_btm_flg") == 0){
		  				for(var k = sheetObj.HeaderRows ; k < sheetObj.Rows ; k++){
		  					if(sheetObj.CellValue(k, "bdl_no") == bdlNo && sheetObj.CellValue(k, "bdl_btm_flg") == 1){
		  						btmFlg = false;
		  						break;
		  					}
		  				}
			  			if(btmFlg){
	  						ComShowCodeMessage("BKG00822");
	  						return false;		  				
			  			}		  				
		  			}
		  		}
				return true;        		
				break;	 		
		}      
    }

    function bkg9424_keypress(){
    	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	var srcName = event.srcElement.getAttribute("name");
    	var srcValue = event.srcElement.getAttribute("value");
    	if(srcName == "bkg_no" || srcName == "bl_no"){
    		if(event.keyCode == 13){
    			ComKeyEnter();
    		}
    	}
    	switch(event.srcElement.dataformat) {
    		case "ymdhm":
    			ComKeyOnlyNumber(event.srcElement);
	            if (srcValue.length == 8) {
	              document.form.elements[srcName].value = srcValue.substring(0,10) + " "
	            }
	            if (srcValue.length == 11) {
	            	document.form.elements[srcName].value = srcValue.substring(0,13) + ":"
	            }
	            break;
    		default:     //영문 + 숫자
    			ComKeyOnlyAlphabet('uppernum'); break;
    	}
	}      
	  
  	function bkg9424_click(){
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcValue = event.srcElement.getAttribute("value");
    	if(srcName == "bkg_mvmt_cd"){
    		var bkgMvmtCd = ComGetObjValue(formObject.bkg_mvmt_cd);
    		ComResetAll();
    		ComSetObjValue(formObject.bkg_mvmt_cd, bkgMvmtCd);

    		disableSaveButton();     		
//    		if(srcValue == "VL"){
//    			if(formObject.split_flg.value == "Y"){
//    				document.getElementById("bkg_pod_cd").className  = "input";
//    			} else {
//        			document.getElementById("bkg_pod_cd").className  = "noinput2";
//    			}
//    		} else {
//    			document.getElementById("bkg_pod_cd").className  = "noinput2";
//    		}
    	}else if(srcName == "mvmt_option"){
        	if(srcValue == "V"){
        		sheetObjects[2].CellValue(0,"pod_cd") = "EDI POD";
        	}else{
        		sheetObjects[2].CellValue(0,"pod_cd") = "POD";
        	}    		
        	if(ComGetObjValue(formObject.bkg_trunk_vvd) != ""){
	        	doActionIBSheet(sheetObjects[2], formObject, SEARCHLIST12);  
	        }else{
	        	ComShowCodeMessage("BKG00448");
	        }    		
    	}
	}      
  	
  	// Save관련버튼 Disable
  	function disableSaveButton(){
		ComBtnDisable("btn_Add");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Move");
		ComBtnDisable("btn_Rmk");
		ComBtnDisable("btn_BtmSave");    
		ComBtnDisable("btn_BtmCancel");		
  	}
   
  	// Save관련버튼 Enable
  	function enableSaveButton(){
		ComBtnEnable("btn_Add");
		ComBtnEnable("btn_Delete");
		ComBtnEnable("btn_Move");
		ComBtnEnable("btn_Rmk");
		ComBtnEnable("btn_BtmSave");
		ComBtnEnable("btn_BtmCancel");
  	}

	// Container번호로 Repo 정보 조회
	function searchRepoByCntr(sheetObj, formObject, Row, cntrNo){
		ComSetObjValue(formObject.f_cmd, SEARCHLIST11);
		var sXml = sheetObj.GetSearchXml("ESM_BKG_9424GS.do?cntr_no="+cntrNo, FormQueryString(formObject));   			
		
		sheetObj.CellValue2(Row, "cntr_no_pst")  = ComGetEtcData(sXml,"chk_digit");
		sheetObj.CellValue2(Row, "tpsz_cd")      = ComGetEtcData(sXml,"cntr_tpsz_cd");
		sheetObj.CellValue2(Row, "sts_cd")       = ComGetEtcData(sXml,"cnmv_sts_cd");
		sheetObj.CellValue2(Row, "pre_sts_flg")  = ComGetEtcData(sXml,"pre_sts_flg");
		sheetObj.CellValue2(Row, "cntr_no") 	 = cntrNo.substring(0, 10);
		
		var idxTpsz = sheetObjects[1].FindText("tpsz_cd", ComGetEtcData(sXml,"cntr_tpsz_cd"));
		if(idxTpsz >= 0){
			sheetObjects[1].CellValue(idxTpsz, "r_qty") =  BkgParseInt(sheetObjects[1].CellValue(idxTpsz, "r_qty")) + 1;
		}		
		setEmptyContainerQty("B");
	}
	
	// 조회완료 후 Empty Container Qty 계산
	function setEmptyContainerQty(type){
		var arrCntrTpSz = new Array();
		var arrCntrVol = new Array();
		var arrHngrCntrVol = new Array();
		var cntrTpSzCnt = sheetObjects[1].Rows - 1;
		for(var i = 1 ; i < cntrTpSzCnt; i++){			
			arrCntrTpSz[i] = sheetObjects[1].CellValue(i, "tpsz_cd")
			arrCntrVol[i] = 0;
			arrHngrCntrVol[i] = 0;
		}				   

		var cntrTpSz = "";
		var cntrHngrRckCd = "";
		for(var i = 1 ; i < sheetObjects[0].Rows ; i++){
			if(sheetObjects[0].RowStatus(i) != "D"){
				cntrTpSz = sheetObjects[0].CellValue(i, "tpsz_cd");
				cntrHngrRckCd = sheetObjects[0].CellValue(i, "cntr_hngr_rck_cd");
				if(cntrTpSz == ""){
					break;
				}
				for(var j = 1 ; j < cntrTpSzCnt - 1; j++){	
					if(cntrTpSz==arrCntrTpSz[j]){
						arrCntrVol[j]++;
						if(cntrHngrRckCd != ''){
							arrHngrCntrVol[j]++;
						}
					}
				}
			}
		}	 

		for(var i = 1 ; i < cntrTpSzCnt  - 1; i++){
			if(type == "A"){
				sheetObjects[1].CellValue(i, "b_qty") = arrCntrVol[i];
			}
			sheetObjects[1].CellValue(i, "r_qty") = arrCntrVol[i];
			sheetObjects[1].CellValue(i, "hngr_r_qty") = arrHngrCntrVol[i];
			if(arrHngrCntrVol[i] > 0){
				sheetObjects[1].CellValue(i, "show_r_qty") = arrCntrVol[i] + "(" + arrHngrCntrVol[i] + ")";
			} else {
				sheetObjects[1].CellValue(i, "show_r_qty") = arrCntrVol[i];
			}			
		}
		
//		for(var i = sheetObjects[1].HeaderRows ; i < sheetObjects[1].Rows ; i++){			
//			if(type == "A"){
//				sheetObjects[1].CellValue(i, "b_qty") = "";
//			}			
//			sheetObjects[1].CellValue(i, "r_qty") = "";
//		}
//	
//		for(var i = sheetObjects[0].HeaderRows ; i < sheetObjects[0].Rows ; i++){			
//			var cntrTpsz = sheetObjects[0].CellValue(i, "tpsz_cd");
//			if(cntrTpsz == ""){
//				break;
//			}			
//			var idxTpsz = sheetObjects[1].FindText("tpsz_cd", cntrTpsz);
//			
//			if(idxTpsz >= 0){
//				if(type == "A"){
//					sheetObjects[1].CellValue(idxTpsz, "b_qty") =  BkgParseInt(sheetObjects[1].CellValue(idxTpsz, "b_qty")) + 1;	
//				}				
//				if(sheetObjects[0].RowStatus(i) != "D"){
//					sheetObjects[1].CellValue(idxTpsz, "r_qty") =  BkgParseInt(sheetObjects[1].CellValue(idxTpsz, "r_qty")) + 1;	
//				}				
//			}
//
//		}	   
		setEmptyContainerColor();
   	}

	// 조회완료 후 Empty Container정보가 없을시 Booking Qty를 B.QTY에 보여준다.(20091016 추가)
   	function setEmptyQty(){
		for(var i = sheetObjects[1].HeaderRows ; i < sheetObjects[1].Rows ; i++){			
			sheetObjects[1].CellValue(i, "b_qty") = "";
		}	
	   
		for(var i = sheetObjects[4].HeaderRows ; i < sheetObjects[4].Rows ; i++){			
			var cntrTpsz = sheetObjects[4].CellValue(i, "cntr_tpsz_cd");
			var bQty = sheetObjects[4].CellValue(i, "op_cntr_qty");			
			var idxTpsz = sheetObjects[1].FindText("tpsz_cd", cntrTpsz);
			
			if(idxTpsz >= 0){
				sheetObjects[1].CellValue(idxTpsz, "b_qty") =  bQty;	
			}
		}	   
		setEmptyContainerColor();
	}   
   
   	// Empty Container Qty 계산 후 Color 재조정.
   	function setEmptyContainerColor(){	   
		for(var i = sheetObjects[1].HeaderRows ; i < sheetObjects[1].Rows ; i++){		
			if(sheetObjects[1].CellValue(i, "b_qty") != sheetObjects[1].CellValue(i, "r_qty")){
				sheetObjects[1].CellBackColor(i,"show_r_qty") = sheetObjects[1].RgbColor(0, 255, 0)
			}else{
				sheetObjects[1].CellBackColor(i,"show_r_qty") = -1;
			}
		}	   
	}   
   
	// 조회완료 후 VL Container Qty 계산   
	function setVlContainerQty(){
		var arrCntrTpSz = new Array();
		var arrCntrVol = new Array();
		var cntrTpSzCnt = sheetObjects[3].Rows - 1;

		for(var i = 1 ; i < cntrTpSzCnt ; i++){
			arrCntrTpSz[i] = sheetObjects[3].CellValue(i, "tpsz_cd");
			arrCntrVol[i] = 0;
		}			
		var cntrTpSz = "";
		for(var i = 1 ; i < sheetObjects[2].Rows ; i++){			
			cntrTpSz = sheetObjects[2].CellValue(i, "tpsz_cd");
			if(cntrTpSz == ""){
				break;
			}
			for(var j = 1 ; j < cntrTpSzCnt ; j++){				
				if(cntrTpSz==arrCntrTpSz[j]){
					arrCntrVol[j]++;
				}
			}
		}	 
		   
		for(var i = 1 ; i < cntrTpSzCnt ; i++){	
			sheetObjects[3].CellValue(i, "qty") = arrCntrVol[i];
		}

//		for(var i = sheetObjects[3].HeaderRows ; i < sheetObjects[3].Rows ; i++){			
//			sheetObjects[3].CellValue(i, "qty") = "";
//		}				   
//				
//		for(var i = sheetObjects[2].HeaderRows ; i < sheetObjects[2].Rows ; i++){	
//			
//			var cntrTpsz = sheetObjects[2].CellValue(i, "tpsz_cd");
//
//			if(cntrTpsz == ""){
//				break;
//			}
//			var idxTpsz = sheetObjects[3].FindText("tpsz_cd", cntrTpsz);
//
//			if(idxTpsz >= 0){
//				sheetObjects[3].CellValue(idxTpsz, "qty") =  BkgParseInt(sheetObjects[3].CellValue(idxTpsz, "qty")) + 1;
//			}
//		}	  	  
	}

	// Bundle Click시 처리
    function setBundle(){
		var sheetObj = sheetObjects[0];
		// 1개이상 선택해야함.
		if(sheetObj.CheckedRows("chk") < 1){
			ComShowCodeMessage("BKG00624");
			return;		   
		}
		var f2a2Cnt = 0;
		var f4f5a4a5Cnt = 0;
		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
			if(sheetObj.CellValue(i, "chk") == 1){
				if(sheetObj.CellValue(i, "tpsz_cd") == "F2" || sheetObj.CellValue(i, "tpsz_cd") == "A2"){
					f2a2Cnt++;
				}
				if(sheetObj.CellValue(i, "tpsz_cd") == "F4" || sheetObj.CellValue(i, "tpsz_cd") == "F5" || sheetObj.CellValue(i, "tpsz_cd") == "A4" || sheetObj.CellValue(i, "tpsz_cd") == "A5"){
					f4f5a4a5Cnt++;
				}
			}
		}
		// type size 별로 선택갯수가 4, 7개를 넘으면 에러.
		if(f2a2Cnt > 7 || f4f5a4a5Cnt > 4){
			ComShowCodeMessage("BKG00821");
			return;
		}
		// F2+A2, F4+F5+A4+A5 Bundle 가능.
		var bundle2 = false;
		var bundle4 = false;
		var isExist = false;
		var isNotBundle = false;
		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
			if(sheetObj.CellValue(i, "chk") == 1){
				if(sheetObj.CellValue(i, "tpsz_cd") != "F2" && sheetObj.CellValue(i, "tpsz_cd") != "A2" && sheetObj.CellValue(i, "tpsz_cd") != "F4" && sheetObj.CellValue(i, "tpsz_cd") != "F5" && sheetObj.CellValue(i, "tpsz_cd") != "A4" && sheetObj.CellValue(i, "tpsz_cd") != "A5"){
					isNotBundle = true;
				}
			   
				if(sheetObj.CellValue(i, "tpsz_cd") == "F2" || sheetObj.CellValue(i, "tpsz_cd") == "A2"){
					bundle2 = true;
				}
			   
				if(sheetObj.CellValue(i, "tpsz_cd") == "F4" || sheetObj.CellValue(i, "tpsz_cd") == "F5" || sheetObj.CellValue(i, "tpsz_cd") == "A4" || sheetObj.CellValue(i, "tpsz_cd") == "A5"){
					bundle4 = true;				   
				}			   
			   
				if(sheetObj.CellValue(i, "bdl_no") != ""){
					isExist = true;
					break;
				}
			}
		}
	   
		if(isExist){
			for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
				if(sheetObj.CellValue(i, "chk") == 1){
					sheetObj.CellValue2(i, "bdl_no") = "";
				}
			}
		}else{
			if(isNotBundle){
				ComShowCodeMessage("BKG00822");
				sheetObj.CheckAll("chk") = 0;
				return;
			}
		   
			if(bundle2 && bundle4){
				ComShowCodeMessage("BKG02023");
				sheetObj.CheckAll("chk") = 0;
			   	return;			   
			}
		   
			var maxBuldle = calculateMaxBundle();
			for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
				if(sheetObj.CellValue(i, "chk") == 1){
					sheetObj.CellValue2(i, "bdl_no") = BkgParseInt(maxBuldle)+1;;
				}
			}		   
		}
		sheetObj.CheckAll("chk") = 0;
    }
    
    // Max Bundle 계산
    function calculateMaxBundle(){
    	var maxBundle = 0;
    	var sheetObj = sheetObjects[0];
    	for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
    		if(sheetObj.CellValue(i, "bdl_no") != ""){
    			if(maxBundle < BkgParseInt(sheetObj.CellValue(i, "bdl_no"))){
    				maxBundle = sheetObj.CellValue(i, "bdl_no");
    			}
    		}
    	}	   
    	return maxBundle;
    }

//	function sheet1_OnAfterEdit(sheetObj, Row, Col){
//		var formObject = document.form;
//		
//		var selTpSz = sheetObjects[1].FindText("tpsz_cd", sheetObj.CellValue(Row, "tpsz_cd"));
//		
//		if(selTpSz >= 0){
//			sheetObjects[1].CellValue(selTpSz, "r_qty") =  BkgParseInt(sheetObjects[1].CellValue(selTpSz, "r_qty")) - 1;
//		}
//		var cntrNo = sheetObj.CellValue(Row, "cntr_no");
//		if(cntrNo.length == 10){
//			searchRepoByCntr(sheetObj, formObject, Row, cntrNo);
//		}else{
//			sheetObj.CellValue2(Row, "cntr_no_pst") = "";
//			sheetObj.CellValue2(Row, "tpsz_cd") = "";
//			sheetObj.CellValue2(Row, "sts_cd") = "";
//			sheetObj.CellValue2(Row, "full_cntr_no") = "";
//		}
//		setEmptyContainerColor();	
//	}		   
    
	function sheet1_OnChange(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(sheetObj.SelectCol) == "full_cntr_no"){
			var formObject = document.form;
			
			var selTpSz = sheetObjects[1].FindText("tpsz_cd", sheetObj.CellValue(Row, "tpsz_cd"));
			
			if(selTpSz >= 0){
				sheetObjects[1].CellValue(selTpSz, "r_qty") =  BkgParseInt(sheetObjects[1].CellValue(selTpSz, "r_qty")) - 1;
			}
			var cntrNo = sheetObj.CellValue(Row, "full_cntr_no");
			if(cntrNo.length == 11){
				searchRepoByCntr(sheetObj, formObject, Row, cntrNo);
			}else{
				sheetObj.CellValue2(Row, "cntr_no_pst") = "";
				sheetObj.CellValue2(Row, "tpsz_cd") = "";
				sheetObj.CellValue2(Row, "sts_cd") = "";
				sheetObj.CellValue2(Row, "cntr_no") = "";
			}
			setEmptyContainerQty("B");
			setEmptyContainerColor();					
		}
		var colName = sheetObj.ColSaveName(Col);
		// 같은 Buldle 중에 하나만 체크되도록 한다.
		if(colName == "bdl_btm_flg"){
			if(sheetObj.CellValue(Row, Col) == 1){
				var bdlNo = sheetObj.CellValue(Row, "bdl_no");
				if(bdlNo==null||bdlNo.length<1){
					sheetObj.CellValue2(Row, "bdl_btm_flg") = 0;
					return;
				}
				var bdlFlg = false;
				for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
					if(i != Row){
						if(sheetObj.CellValue(i, "bdl_no") == bdlNo && sheetObj.CellValue(i, "bdl_btm_flg") == 1){
							bdlFlg = true;
							break;
						}
					}
				}
				if(bdlFlg){
					sheetObj.CellValue2(Row, "bdl_btm_flg") = 0;
					ComShowCodeMessage("BKG02036");
				}
			}
		}				
    }
	
	function sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.WaitImageVisible = false;   
		initControl();

		disableSaveButton();  
		
		if(ComGetObjValue(document.form.bkg_no) != ""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} 
         
 		//iframe 생성 
		CofigIframe();   
	 	sheetObj.WaitImageVisible = true;   
	}              
      	
  /**
   * LoadExcel 이벤트 발생시 호출되는 function <br>
   * 엑셀파일 로드 후 정상이면 SHEET COLUMN 을 제어한다. <br>
   * <br><b>Example :</b>
   * <pre>
   * 
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @return 없음
   * @author 김병규
   * @version 2009.09.29
   */ 
   function sheet1_OnLoadExcel(sheetObj){
	   var formObj = document.form;

	   // 역순으로 검색해서 기존값과 중복되어 있으면 지우고 T/S,STS등을 조회한다.  		
	   for(var i = sheetObj.Rows-1 ; i >= sheetObj.HeaderRows ; i--){
		   totCntrNo = sheetObj.CellValue(i, "full_cntr_no");
		   if(totCntrNo.length < 11){
			   sheetObj.RowDelete(i, false);
		   }else{
			   cntrNo = totCntrNo;
			   idx = sheetObj.FindText("full_cntr_no", cntrNo);

			   // 검색한 결과가 자신이 아니라면 중복데이터 존재이므로 삭제.
			   if(idx > 0 && idx != i){
				   sheetObj.RowDelete(i, false);
			   }else{
				   if(sheetObj.CellValue(i ,"cntr_no") == ""){
					   sheetObj.CellValue(i, "full_cntr_no") = cntrNo;
					   searchRepoByCntr(sheetObj, formObj, i, cntrNo);  						
				   }
			   }
		   }
	   }
	   setEmptyContainerQty("B");
   }
   
   /*
	* Sheet onMouseUP 호출
	*/
    function sheet1_OnMouseUp(sheetObj,Button, Shift, X, Y){ 
    	var sRowStr = sheetObj.GetSelectionRows("/");
    	var arr = sRowStr.split("/");
    	if (Shift==1){
    		for (var i=0; i<arr.length; i++) {
    			if (sheetObj.ColSaveName(sheetObj.SelectCol) !="chk" && sheetObj.CellValue(arr[i],"chk")=="0"){
    				sheetObj.CellValue2(arr[i],"chk")="1";
    			}else if (sheetObj.ColSaveName(sheetObj.SelectCol) !="chk" && sheetObj.CellValue(arr[i],"chk")=="1"){
    				sheetObj.CellValue2(arr[i],"chk")="0";
    			}
    		}
    	}else{
/*		    if (sheetObj.ColSaveName(sheetObj.SelectCol) !="chk" && sheetObj.CellValue(sheetObj.SelectRow,"chk")=="0"){
			sheetObj.CellValue2(sheetObj.SelectRow,"chk")="1";
		}else if (sheetObj.ColSaveName(sheetObj.SelectCol) !="chk" && sheetObj.CellValue(sheetObj.SelectRow,"chk")=="1"){
			sheetObj.CellValue2(sheetObj.SelectRow,"chk")="0";
		}
*/		
    	}	  
    }

	/*
	* Sheet onMouseUP 호출
	*/
	function sheet3_OnMouseUp(sheetObj,Button, Shift, X, Y){ 
		var sRowStr = sheetObj.GetSelectionRows("/");
		var arr = sRowStr.split("/");
		if (Shift==1){
			for (var i=0; i<arr.length; i++) {
				if (sheetObj.ColSaveName(sheetObj.SelectCol) !="chk" && sheetObj.CellValue(arr[i],"chk")=="0"){
					sheetObj.CellValue2(arr[i],"chk")="1";
				}else if (sheetObj.ColSaveName(sheetObj.SelectCol) !="chk" && sheetObj.CellValue(arr[i],"chk")=="1"){
					sheetObj.CellValue2(arr[i],"chk")="0";
				}
			}
		}else{
/*		    if (sheetObj.ColSaveName(sheetObj.SelectCol) !="chk" && sheetObj.CellValue(sheetObj.SelectRow,"chk")=="0"){
				sheetObj.CellValue2(sheetObj.SelectRow,"chk")="1";
			}else if (sheetObj.ColSaveName(sheetObj.SelectCol) !="chk" && sheetObj.CellValue(sheetObj.SelectRow,"chk")=="1"){
				sheetObj.CellValue2(sheetObj.SelectRow,"chk")="0";
			}
*/		
		}
	}      
   
   	/* 개발자 작업	*/
    /**
     * Container No Inquiry 에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack9455(rArray);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 김병규
     * @version 2009.09.29
     */
	function callBack9455(rArray){    	
		var formObj = document.form;
    	
    	if(rArray != null){
    		var sheetObject = sheetObjects[0];
    		for(var i = 0 ; i < rArray.length ; i++){
    			// Repo Container가 없는 경우에만 새로 추가한다.
    			var findRow = sheetObject.FindText("full_cntr_no",rArray[i][3]);
    			if(findRow < 0){
    				var addRow = sheetObject.DataInsert(-1);
    				sheetObject.CellValue(addRow, "cntr_no") = rArray[i][5];
    				sheetObject.CellValue(addRow, "cntr_no_pst") = rArray[i][6];
    				sheetObject.CellValue(addRow, "tpsz_cd") = rArray[i][4];
    				sheetObject.CellValue(addRow, "sts_cd") = rArray[i][7];
    				sheetObject.CellValue(addRow, "full_cntr_no") = rArray[i][3];
    			}else{
    				if(sheetObject.RowStatus(findRow) == "D"){
    					sheetObject.RowHidden(findRow) = false;
	                    sheetObject.RowStatus(findRow)= "R";                						 
    				}
				}    			
			}
    		setEmptyContainerQty("B");
    	}
	}     

    /**
    * Remark 에서 전달받은 값 저장 <br>
    * <br><b>Example :</b>
    * <pre>
    *     callBack0913(rArray);
    * </pre>
    * @param Popup에서 전달받은 값
    * @return 없음
    * @author 김병규
    * @version 2009.09.29
    */
	function callBack0913(rReturn){    	
	   	var formObj = document.form;
	   	ComSetObjValue(formObj.inter_rmk, rReturn);
		if(ComIsNull(formObj.inter_rmk)){
			ComBtnColor("btn_Rmk","#737373");
		}else{
			ComBtnColor("btn_Rmk","blue");			
		}   	
    }         
    
//    //copy hidden sheet to cntr sheet    
//    function copyHiddenSheetToCntrSheet(){
//        var cntrSheetObj = sheetObjects[0];
//        var hiddenSheetObj = sheetObjects[5];
//        
//        cntrSheetObj.RemoveAll();
//        
//        for(var i = hiddenSheetObj.HeaderRows ; i < hiddenSheetObj.Rows; i++){
//        	var newRow = cntrSheetObj.DataInsert(-1);
//        	cntrSheetObj.RowStatus(newRow) = "I";
//        	cntrSheetObj.CellValue2(newRow, "seq") 						= cntrSheetObj.Rows;  
//        	cntrSheetObj.CellValue2(newRow, "cntr_no") 					= hiddenSheetObj.CellValue(i, "cntr_no").substring(0,10);
//        	cntrSheetObj.CellValue2(newRow, "cntr_no_pst") 				= hiddenSheetObj.CellValue(i, "cntr_no").substring(10,11);
//        	cntrSheetObj.CellValue2(newRow, "tpsz_cd") 					= hiddenSheetObj.CellValue(i, "tpsz_cd");
//        	cntrSheetObj.CellValue2(newRow, "sts_cd") 					= hiddenSheetObj.CellValue(i, "sts_cd");
//        	cntrSheetObj.CellValue2(newRow, "bdl_no") 					= hiddenSheetObj.CellValue(i, "bdl_no");
//        	cntrSheetObj.CellValue2(newRow, "btm_flg") 					= hiddenSheetObj.CellValue(i, "cnbtm_flgtr_no");
//        	cntrSheetObj.CellValue2(newRow, "cntr_hngr_rck_cd") 		= hiddenSheetObj.CellValue(i, "cntr_hngr_rck_cd");
//        	cntrSheetObj.CellValue2(newRow, "mnr_hngr_bar_tp_cd") 		= hiddenSheetObj.CellValue(i, "mnr_hngr_bar_tp_cd");
//        	cntrSheetObj.CellValue2(newRow, "cntr_hngr_bar_atch_knt") 	= hiddenSheetObj.CellValue(i, "cntr_hngr_bar_atch_knt");
//        	cntrSheetObj.CellValue2(newRow, "full_cntr_no") 			= hiddenSheetObj.CellValue(i, "full_cntr_no");
//        	cntrSheetObj.CellValue2(newRow, "pre_sts_flg") 				= hiddenSheetObj.CellValue(i, "pre_sts_flg");
//        }
//    }
    
//    //copy cntr sheet to hidden sheet
//    function copyCntrSheetToHiddenSheet(){
//        var cntrSheetObj = sheetObjects[0];
//        var hiddenSheetObj = sheetObjects[5];
//        
//        hiddenSheetObj.RemoveAll();
//        
//        for(var i = cntrSheetObj.HeaderRows ; i < cntrSheetObj.Rows; i++){
//        	var newRow = hiddenSheetObj.DataInsert(-1);
//        	hiddenSheetObj.RowStatus(newRow) = "I";
//        	hiddenSheetObj.CellValue2(newRow, "seq") 					= hiddenSheetObj.Rows;  
//        	hiddenSheetObj.CellValue2(newRow, "cntr_no") 				= cntrSheetObj.CellValue(i, "cntr_no") 
//        																+ cntrSheetObj.CellValue(i, "cntr_no_pst");
//        	hiddenSheetObj.CellValue2(newRow, "tpsz_cd") 				= cntrSheetObj.CellValue(i, "tpsz_cd");
//        	hiddenSheetObj.CellValue2(newRow, "sts_cd") 				= cntrSheetObj.CellValue(i, "sts_cd");
//        	hiddenSheetObj.CellValue2(newRow, "bdl_no") 				= cntrSheetObj.CellValue(i, "bdl_no");
//        	hiddenSheetObj.CellValue2(newRow, "btm_flg") 				= cntrSheetObj.CellValue(i, "cnbtm_flgtr_no");
//        	hiddenSheetObj.CellValue2(newRow, "cntr_hngr_rck_cd") 		= cntrSheetObj.CellValue(i, "cntr_hngr_rck_cd");
//        	hiddenSheetObj.CellValue2(newRow, "mnr_hngr_bar_tp_cd") 	= cntrSheetObj.CellValue(i, "mnr_hngr_bar_tp_cd");
//        	hiddenSheetObj.CellValue2(newRow, "cntr_hngr_bar_atch_knt") = cntrSheetObj.CellValue(i, "cntr_hngr_bar_atch_knt");
//        	hiddenSheetObj.CellValue2(newRow, "full_cntr_no") 			= cntrSheetObj.CellValue(i, "full_cntr_no");
//        	hiddenSheetObj.CellValue2(newRow, "pre_sts_flg") 			= cntrSheetObj.CellValue(i, "pre_sts_flg");
//        }
//    }
	/* 개발자 작업  끝 */