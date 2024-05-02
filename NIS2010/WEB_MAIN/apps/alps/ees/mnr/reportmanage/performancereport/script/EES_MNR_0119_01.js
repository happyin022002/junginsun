/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0119_01.js
*@FileTitle : Verification Result
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.14
*@LastModifier : 이덕환
*@LastVersion : 1.0 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 
     * @author 한진해운
     */

    /**
     * @extends 
     * @class EES_MNR_0119_01 : EES_MNR_0119 FOOD QUALITY 조회을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */


var sheetObjects = new Array();
var sheetCnt = 0;
var firstLoad = true;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

      try {
      var srcName = window.event.srcElement.getAttribute("name");

      switch(srcName) {

        case "btn_close":
            window.close();
            break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			break;
      } // end switch
      }catch(e) {
        if( e == "[object Error]") {
          ComShowMessage(ComGetMsg('COM12111'));
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
    var iOpRowCnt=0;
    var iOpChkRowCnt=0;
    var iLp=0;
    var crntLp=0;
    var chkedRow="";
    var chkedRowV="";
	var tmp = '';
	var oParent=null;
	
	var sh2Lp=1;
    function loadPage() {
    	for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
    	if(opener != null) {
			// 일반 팝업인 경우
			oParent=opener;
		} else {
			// Modal 팝업인 경우
			oParent=window.dialogArguments;
		}
    	
        initSet();
        iOpRowCnt=oParent.sheetObjects[0].RowCount;
        iOpChkRowCnt=oParent.checkRows;
        
        for(var i=1;i<=iOpRowCnt;i++){
        	if(oParent.sheetObjects[0].CellValue(i, "chk")==1){
        		chkedRow=chkedRow+i+";";
        	}
        }
        chkedRowV=chkedRow.split(";");
        
        afLoadPg();
        
    }

    function afLoadPg(){
   	     doActionIBSheet(sheetObjects[0], document.form, MULTI);
    }
   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {

        case 1:      //sheet1 init

            with (sheetObj) {
        	//전체 너비 설정
//          style.height = GetSheetHeight(12) ;
        	style.height = 390 ;
        	SheetWidth = mainTable.clientWidth;

        	//Host정보 설정[필수][HostIp, Port, PagePath]
        	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

        	//전체Merge 종류 [선택, Default msNone]
        	MergeSheet = msHeaderOnly;

        	//전체Edit 허용 여부 [선택, Default false]
        	Editable = true;

        	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        	InitRowInfo(2, 1, 26, 100);

        	var HeadTitle0 = "|Sel|Seq.|W/O No|Service Provider Name|Container No|TP-SZ|Term|RCC|LCC|SCC|Yard|Mandatory Code|Mandatory Code|Mandatory Code|Mandatory Code|Option  |Volume|Volume|Volume|Labor|Labor|Labor|Material|Amount|Verify Result";
        	var HeadTitle1 = "|Sel|Seq.|W/O No|Service Provider Name|Container No|TP-SZ|Term|RCC|LCC|SCC|Yard|Location|Component|Damage|Repair|Division|Type  |QTY   |Size/Square|Hour |Rate |Cost |Material|Amount|Verify Result";
        	

        	var headCount = ComCountHeadTitle(HeadTitle1);

        	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        	InitColumnInfo(headCount, 4, 0, true);

        	// 해더에서 처리할 수 있는 각종 기능을 설정한다
        	InitHeadMode(true, true, true, true, false,false);

        	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        	InitHeadRow(0, HeadTitle0, true);
        	InitHeadRow(1, HeadTitle1, true);

        	//데이터속성    [  ROW, COL,    DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE,	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        	InitDataProperty(0, cnt++ , dtHidden, 	    20,    	daCenter,  	true,    	"status",     			 false,          "",       dfNone,   	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtSeq, 	    	20,    	daCenter,  	true,    	"sq",     				 false,          "",       dfNone,   	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,        30,   	daCenter,  	true,    	"seq",   			  	 false,          "",       dfNone,   	0,     false,     false);
        	InitDataProperty(0, cnt++ , dtData,        	100,   	daCenter,  	true,    	"wo_no",     		     false,          "",       dfNone,   	0,     false,     false);
        	InitDataProperty(0, cnt++ , dtData,   		190,    daCenter,  true,    	"service_provider_name", false,          "",       dfNone,	    0,     false,     false);
        	InitDataProperty(0, cnt++ , dtData,		    100,  	daCenter,  	true,    	"container_no",  		 false,          "",       dfNone,	    0,     false,     false);
        	InitDataProperty(0, cnt++ , dtData,       	60,     daCenter,  	true,   	"tp_sz",  				 false,          "",	   dfNone,   	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,       	60,    	daCenter,  	true,    	"term",    				 false,          "",       dfNone,  	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,       	60,    	daCenter,  	true,    	"rcc",  				 false,          "",       dfNone,  	0,     false,     false);
        	InitDataProperty(0, cnt++ , dtData,       	60,    	daCenter,  	true,    	"lcc",  				 false,          "",       dfNone,  	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,      	60,    	daCenter,  	true,     	"scc",  				 false,          "",       dfNone,  	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,       	60,    	daCenter,  	true,    	"yard",  				 false,          "",       dfNone,  	0,     false,     false);
        	InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"location",  			 false,          "",       dfNone,  	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,      	70,    	daCenter,  	true,     	"component",  			 false,          "",       dfNone,  	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"damage",  				 false,          "",       dfNone,  	0,     false,     false);
        	InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"repair",  				 false,          "",       dfNone,  	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,      	70,    	daCenter,  	true,     	"division",  			 false,          "",       dfNone,  	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,      	70,    	daCenter,  	true,     	"mrd_type",  			 false,          "",       dfNone,  	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,       	40,    	daCenter,  	true,    	"mrd_qty", 	 			 false,          "",       dfNone,    	0,     false,	  false);
        	InitDataProperty(0, cnt++ , dtData,     	75,    	daRight,  	true,    	"mrd_size_square",  	 false,          "",       dfNone,     	0,     false,	  false);
        	InitDataProperty(0, cnt++ , dtData,      	60,    	daRight,  	true,    	"mrd_hour",  			 false,          "",       dfNone,  	0,     false,     false);
        	InitDataProperty(0, cnt++ , dtData,      	60,    	daRight,  	true,    	"rate",    				 false,          "",       dfNone,  	0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,       	60,    	daRight,  	true,    	"mrd_cost",    		 	 false,          "",       dfNone, 		0,     false,      true);
			InitDataProperty(0, cnt++ , dtData,       	70,    daRight,  	true,    	"material",    		     false,          "",       dfNone, 		0,     false,      true);
        	InitDataProperty(0, cnt++ , dtData,     	75,    	daRight,  	true,    	"mrd_amount",  			 false,          "",       dfNone,      0,     false,     false);
        	InitDataProperty(0,	cnt++,	dtCombo,	 	140,	daLeft,    	true,		"mnr_vrfy_tp_cd",		 false,			 "",	   dfNone,	    0,	   false,	  false);
            HeadRowHeight = 20 ;
            
            WaitImageVisible=true;
        }
                      
        break;
        }
    }

    var sXml ="";

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
   
           case IBSEARCH:      조회
           		if(!validateForm(sheetObj,formObj,sAction)) return;
           		formObj.f_cmd.value = SEARCH;
           	    
           		if(iLp==(chkedRowV.length-1)){
           			break;
           		}else{
           			var ifm_dt		   = oParent.vFmt_dt;
           			var ito_dt		   = oParent.vTo_dt;
           			var irhq           = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "rhq");
           			var iofc_cd        = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "cost_ofc_cd");
           			var ivndr_seq      = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "vndr_seq");
           			var ilocation_cd   = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "eq_loc_cd");
           			var icomponent 	   = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "eq_cmpo_cd");
           			var irepair 	   = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "eq_rpr_cd");
           			var idivision 	   = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "trf_div_cd");
           			var idamage 	   = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "eq_dmg_cd");
           			var queryStr	   ="fm_dt="+ifm_dt+"&to_dt="+ito_dt+"&rhq="+irhq+"&ofc_cd="+iofc_cd+"&vndr_seq="+ivndr_seq+"&location_cd="+ilocation_cd+"&component="+icomponent+"&repair="+irepair+"&division="+idivision+"&damage="+idamage;
           			sXml = sheetObj.GetSearchXml("EES_MNR_0119_01GS.do", queryStr +"&"+FormQueryString(formObj));
           			
           			sheetObj.LoadSearchXml(sXml, true, -1);
           		}
	       		
           		break; 

            case MULTI:
            	formObj.f_cmd.value = MULTI;
            	
            	var ifm_dt		   = "";
       			var ito_dt		   = "";
       			var irhq           = "";
       			var iofc_cd        = "";
       			var ivndr_seq      = "";
       			var ilocation_cd   = "";
       			var icomponent 	   = "";
       			var irepair 	   = "";
       			var idivision 	   = "";
       			var idamage 	   = "";
       			var queryStr	   = "";
       			var ibflag         = "";
       			for(iLp; iLp<(chkedRowV.length-1);iLp++ ){
	       			ifm_dt		   = oParent.vFmt_dt;                                                                                                                                                                                            
	       			ito_dt		   = oParent.vTo_dt;                                                                                                                                                                                             
	       			irhq           = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "rhq");                                                                                                                                                   
	       			iofc_cd        = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "cost_ofc_cd");                                                                                                                                           
	       			ivndr_seq      = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "vndr_seq");                                                                                                                                              
	       			ilocation_cd   = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "eq_loc_cd");                                                                                                                                             
	       			icomponent 	   = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "eq_cmpo_cd");                                                                                                                                            
	       			irepair 	   = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "eq_rpr_cd");                                                                                                                                             
	       			idivision 	   = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "trf_div_cd");                                                                                                                                            
	       			idamage 	   = oParent.sheetObjects[0].CellValue(chkedRowV[iLp], "eq_dmg_cd");                                                                                                                                             
	       			queryStr	   = queryStr+"ibflag="+ibflag+"&fm_dt="+ifm_dt+"&to_dt="+ito_dt+"&rhq="+irhq+"&ofc_cd="+iofc_cd+"&vndr_seq="+ivndr_seq+"&location_cd="+ilocation_cd+"&component="+icomponent+"&repair="+irepair+"&division="+idivision+"&damage="+idamage;
	       			if(iLp<(chkedRowV.length-2)){
	       				queryStr=queryStr+"&";
	       			}
       			}
       			
       			sXml = sheetObj.GetSearchXml("EES_MNR_0119_01GS.do", queryStr +"&"+FormQueryString(formObj));
       			
       			sheetObj.LoadSearchXml(sXml);
       			break;
       			
	   		case IBDOWNEXCEL:
	   			sheetObj.SpeedDown2Excel(-1);   
				break;		
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction) {
	        case IBSEARCH:
	        	break;
	        	
	        case SEARCH01:
	        	break;
        }

        return true;
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function initSet(){
    	//콤보데이타에 값을 세팅함	
		var sCondition = new Array (		  
			new Array("MnrGenCd","CD00004", "COMMON")	//Error code	
		)	 		  	           	
																					
		comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
					
		var sheetComboText = "";   
		var sheetComboCode = ""; 	 
		var sheetComboDefault = new Array();  
			
		var comboSaveNames = new Array();	
		comboSaveNames[0] = "mnr_vrfy_tp_cd";  	 
		
		for(var i = 0; i < comboList.length;i++){ 
		 	if(comboList[i] != null){
				sheetComboText = ""; 
				sheetComboCode = "";		
						   
		 		for(var j = 0; j < comboList[i].length;j++){ 
					var tempText = comboList[i][j].split("|");    
					 
					sheetComboText +=  tempText[1] + "|";  
					sheetComboCode +=  tempText[0] + "|";  
					if(j == 0){
						sheetComboDefault[i] = tempText[0];           	
					} 		   
				}		
		 		
				sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
		     	sheetComboText = 	MnrDelLastDelim(sheetComboText);  	
				sheetObjects[0].InitDataCombo(0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault[i]); 
			}			      
		}
    }
     
    /**
     * 조회 후 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	iLp++;
    	if(document.form.f_cmd.value != MULTI){
	    	if(iLp<chkedRowV.length-1){
	    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	    	}else{
	    		iLp=0;
	    	}
    	}else{
    		iLp=0;
    	}
    }


    