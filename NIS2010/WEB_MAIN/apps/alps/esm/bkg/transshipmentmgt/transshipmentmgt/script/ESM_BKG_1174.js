/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1174.js
*@FileTitle : NMC (Non-Manipulation Certificate)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.03
*@LastModifier : 조인영
*@LastVersion : 1.1
* 2014.04.03 조인영
* 1.0 Creation
=========================================================*/

/**
 * @class ESM_BKG_1174
 */
function ESM_BKG_1174() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

var comboObjects = new Array();
var comboCnt = 0 ; 

var rdObjects = new Array();
var rdCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject 	= sheetObjects[0];
         var sheetObject1 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form; 
          
         var rdObject = rdObjects[0];

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");


			switch(srcName) {
				
				case "btn_retrieve":
					if(formObject.bkg_no.value =="" && formObject.bl_no.value ==""){
						ComShowCodeMessage('COM12138', 'Booking No', 'B/L No');
						return;
					}
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
				case "btn_new":
					formObject.reset();
					sheetObject.RemoveAll();
					sheetObject1.RemoveAll();
					rdOpen();
					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
                errMsg = ComGetMsg("TRS90392" );
                ComShowMessage(errMsg);
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

            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
    	initRdConfig(rdObjects[0]);
    	rdOpen();
    }
    
    
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init

                with (sheetObj) {
                    style.height = GetSheetHeight(13);
                    SheetWidth = mainTable.clientWidth;

                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    MergeSheet = msHeaderOnly;

                    Editable = true;

                    //[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 1, 0, true);

                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "item_desc|tp|qty|wgt|pol|inbound|a_date|kr_pol|outbound|d_date|del|bl_no|cntr_no|today" ;

                    //[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  								KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "item_desc",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "tp",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "qty",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "wgt",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "pol",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "inbound",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "a_date",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "kr_pol",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "outbound",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "d_date",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "del",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "bl_no",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "cntr_no",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "today",		false,			"",			dfNone,					0,			false,			false	);

               }
                break;      
                
            case 2:      //sheet2 init

                with (sheetObj) {
                    style.height = GetSheetHeight(13);
                    SheetWidth = mainTable.clientWidth;

                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    MergeSheet = msHeaderOnly;

                    Editable = true;

                    //[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(1, 1, 0, true);

                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "cntr_no1" ;

                    //[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  								KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "cntr_no1",		false,			"",			dfNone,					0,			false,			false	);

               }
                break;      
        }
    }

// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

               	formObj.f_cmd.value = SEARCH;                  
                sheetObj.DoSearch4Post("ESM_BKG_1174GS.do", FormQueryString(formObj));
                break; 

        }
    }

    
    function sheet2_OnSearchEnd(sheetObj,errMsg){

        if(errMsg!=null){
            ComShowMessage(errMsg);
        }
		var item_desc			= sheetObj.EtcData("item_desc");			
		var tp			= sheetObj.EtcData("tp");			
		var qty			= sheetObj.EtcData("qty");			
		var wgt			= sheetObj.EtcData("wgt");			
		var pol			= sheetObj.EtcData("pol");			
		var inbound			= sheetObj.EtcData("inbound");			
		var a_date			= sheetObj.EtcData("a_date");			
		var kr_pol			= sheetObj.EtcData("kr_pol");			
		var outbound			= sheetObj.EtcData("outbound");			
		var d_date			= sheetObj.EtcData("d_date");			
		var del			= sheetObj.EtcData("del");			
		var bl_no			= sheetObj.EtcData("bl_no");			
		var cntr_no			= sheetObj.EtcData("cntr_no");			
		var today			= sheetObj.EtcData("today");			
		sheetObjects[0].RemoveAll();   
		sheetObjects[0].DataInsert(-1);     
        sheetObjects[0].CellValue(1,"item_desc") 	= item_desc;
        sheetObjects[0].CellValue(1,"tp") 	= tp;
        sheetObjects[0].CellValue(1,"qty") 	= qty;
        sheetObjects[0].CellValue(1,"wgt") 	= wgt;
        sheetObjects[0].CellValue(1,"pol") 	= pol;
        sheetObjects[0].CellValue(1,"inbound") 	= inbound;
        sheetObjects[0].CellValue(1,"a_date") 	= a_date;
        sheetObjects[0].CellValue(1,"kr_pol") 	= kr_pol;
        sheetObjects[0].CellValue(1,"outbound") 	= outbound;
        sheetObjects[0].CellValue(1,"d_date") 	= d_date;
        sheetObjects[0].CellValue(1,"del") 	= del;
        sheetObjects[0].CellValue(1,"bl_no") 	= bl_no;
        sheetObjects[0].CellValue(1,"cntr_no") 	= cntr_no;
        sheetObjects[0].CellValue(1,"today") 	= today;
        rdOpen();
    }			
  
	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
	    
		Rdviewer.AutoAdjust = true;
		//Rdviewer.HideToolbar();
		Rdviewer.HideStatusbar();
		Rdviewer.ViewShowMode(2);

		Rdviewer.setbackgroundcolor(255,255,255);
		Rdviewer.SetPageLineColor(255,255,255);
	}

	function rdOpen(){		
		
		var sXml = "";		
		var i=0;
		var j=0; 
		var sheet_obj1 =  document.sheet1;
		var sheet_obj2 =  document.sheet2; 
		
		var fromObj = new Array();
		var rdObj = new Array();
					
        fromObj[0] = document.form;                            // RD 로 보내기 위해 배열로담는다
        rdObj[0] = sheet_obj1;
        rdObj[1] = sheet_obj2;
         
		sXml = "<?xml version='1.0' ?><SHEET>";
		
		sheetCnt = 1;
		for(i=0;i<2;i++){
				sheetCnt = i+1;
				if(rdObj[i].RowCount ==0){
						sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'>";

						sXml +="</DATA></SHEET"+sheetCnt+">";
				}else{
						sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt); 					
				}			
		}
		sXml +="</SHEET>"; 

		rdObjects[0].AutoAdjust = true;
		//rdObjects[0].HideToolbar();
		rdObjects[0].HideStatusbar();
		rdObjects[0].ViewShowMode(2);
				
		rdObjects[0].setbackgroundcolor(255,255,255);
		rdObjects[0].SetPageLineColor(255,255,255);			
					
		rdObjects[0].SetRData(sXml);
		
		rdObjects[0].FileOpen(RD_path+'apps/alps/esm/bkg/transshipmentmgt/transshipmentmgt/report/ESM_BKG_1174.mrd', RDServer);
	}