/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VOP_VSK_9004.js
*@FileTitle : VMS Short Data
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 임예지
*@LastVersion : 1.0
* 2015.02.23 임예지
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
     * @class VOP_VSK_9004 : VOP_VSK_9004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_9004() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    }
    
    /* 개발자 작업	*/

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	     var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;
         

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
	    			
	    		case "btn_close":
	    			window.close();
	    			break;
	    			
	    		case "btn_DownExcel":
					var sReportPageUrl	= "apps/alps/vop/vsk/vesseloperationsupportmgt/optimizeddistancemgt/jsp/VOP_VSK_9004ExcelDown.jsp";
					
					var param = 		"?vsl_cd="		+formObject.vsl_cd.value;
						param = param + "&skd_voy_no="	+formObject.skd_voy_no.value;
						param = param + "&skd_dir_cd="	+formObject.skd_dir_cd.value;
						param = param + "&pasg_pln_dt="	+formObject.pasg_pln_dt.value;
						param = param + "&dep_port_cd="	+formObject.dep_port_cd.value;
						param = param + "&arr_port_cd="	+formObject.arr_port_cd.value;
						param = param + "&vps_eta_dt="	+formObject.vps_eta_dt.value;
				
//					sheetObject3.Down2Excel(-1, false, false, true, "", sReportPageUrl+param);
	    			sheetObjects[0].Down2Excel(-1, false, false, true, "", sReportPageUrl+param);
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
    	for (i = 0; i < sheetObjects.length; i++) {
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i], i + 1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	var formObj = document.form;
        var sheetObj = sheetObjects[0];
		doActionIBSheet(sheetObj, formObj, IBSEARCH);


	}


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
            	
                with (sheetObj) {

                    // 높이 설정
                    style.height = 400;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "|Seq.|Latitude|Longitude|Co|Dist|Sub TTL|DTG|Rt|Pos.Fix Method\n(primary)|Pos.Fix Method\n(secondary)|Position\nInterval(Min)|UKC\n(m)|Remark";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
                    //InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	true,	"del_chk");
        			InitDataProperty(0, cnt++ , dtDataSeq,		35,		daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtData,	75,	daCenter,	true,	"latitude",		false,	"",	dfNone,	20,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	75,	daCenter,	true,	"longitude",	false,	"",	dfNone,	20,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	55, daCenter,	true,	"co",			false,	"",	dfFloat,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	55,	daCenter,	true,	"dist",  		false,	"",	dfFloat,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	60, daCenter,	true,	"sub_ttl",  	false,	"",	dfFloat,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	55, daCenter,	true,	"dtg",  		false,	"",	dfFloat,	0,	false,	false);
                    
                    InitDataProperty(0, cnt++ , dtData,	45,	daCenter,	true,	"rt",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	true,	"pos_fix_p", 	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	true,	"pos_fix_s",  	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	true,	"position",  	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	60,	daCenter,	true,	"ukc",  		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	"remark",  		false,	"",	dfNone,	0,	false,	false);
                    

                    
                    CountPosition = 0;
				}
                break;
                
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	      case IBSEARCH:      //조회
			ComOpenWait(true);
	    	formObj.f_cmd.value = SEARCH;
	        var sXml = sheetObj.GetSearchXml("VOP_VSK_9004GS.do", FormQueryString(formObj));
	        var str = ComGetEtcData(sXml, "plt_stn_desc");
			ComOpenWait(false);
			
	        var splitStr = new Array();
	        
	        splitStr = str.split('|');
	        var arr = new Array(new Array(), new Array());
	        

	        
	        var colLeng = splitStr.length;
	        var rowLeng = (splitStr.length-1)/10;
	        
	        
	        for(i=0; i<=rowLeng; i++){
	        	arr[i] = new Array();
	        	for(j=0; j<colLeng; j++){
	        		arr[i][j] = 0;
	        	}
	        }
	        
	        var i = 0, k = 0;
   			sheetObj.DataInsert(-1);
	       	for(var j=0; j<colLeng; j++){
	       		if(j >= 10  && j<colLeng-1){
	       			if((j-((i+1)*10))==0){
	    				sheetObj.DataInsert(-1);
	       				i++; 
       				}
	       			k=j-i*10;
	       			if(k>3){
		       			arr[i][k] = splitStr[j];
			        	sheetObj.CellValue(i+1,k+4) = arr[i][k];
	       			}else{
		       			arr[i][k] = splitStr[j];
			        	sheetObj.CellValue(i+1,k+2) = arr[i][k];
	       			}

	       		}else if(j < 10){
	       			if(j>3){
		       			arr[i][j] = splitStr[j];
			        	sheetObj.CellValue(i+1,j+4) = arr[i][j];
	       			}else{
		       			arr[i][j] = splitStr[j];
			        	sheetObj.CellValue(i+1,j+2) = arr[i][j];
	       			}

	       		}       	
	        }
	       	
	       	var tmpSubTtl = 0;
	       	for(var i=0; i<rowLeng; i++){
       			tmpSubTtl += Number(sheetObj.CellValue(i+1, "dist"));
       			sheetObj.CellValue2(i+1, "sub_ttl") = tmpSubTtl;
	       	}
	       	
	       	var tmpDtg = tmpSubTtl;
	       	for(var i=0; i<=rowLeng; i++){
//	       		sheetObj.CellValue2(i+1, "dtg") = tmpSubTtl
	       		tmpDtg -= Number(sheetObj.CellValue(i+1, "dist"));
	       		sheetObj.CellValue2(i+1, "dtg") = tmpDtg;
	       	}
	       	
	       	//Latitude 표기법 도분초로 변환
	       	for(var i=0; i<rowLeng; i++){
		    	var tmpLat1 = 0;
		    	var tmpLat2 = "";
		    	var tmpLatArr1 = 0;
		    	var tmpLatArr2 = 0;
		    	var tmpLat3 = 0;
		    	var tmpStr = "";
		    	var str = "";
	   			tmpLat1 = sheetObj.CellValue(i+1, "latitude");
	   			if(tmpLat1 > 0){
	   				tmpStr = "N";
	   			}else{
	   				tmpStr = "S"
	   			}
	   			tmpLat1 = Math.abs(tmpLat1);
	   			tmpLat1 = "" + tmpLat1;
	   			tmpLatArr1 = tmpLat1.split(".");
	   			tmpLatArr1[1] = (tmpLat1 - tmpLatArr1[0])*60;
	   			tmpLat2 = tmpLat2 + tmpLatArr1[1];
	   			tmpLatArr2 = tmpLat2.split(".");
	   			tmpLat3 = parseInt((tmpLatArr1[1] - tmpLatArr2[0])*60);
	   			tmpLat3 = "" + tmpLat3;
	   			
	   			if(tmpLatArr1[0].length==1)		tmpLatArr1[0] = "0" + tmpLatArr1[0];
	   			if(tmpLatArr2[0].length==1)		tmpLatArr2[0] = "0" + tmpLatArr2[0];
	   			if(tmpLat3.length==1)			tmpLat3 = "0" + tmpLat3;
	   			
	   			str = tmpLatArr1[0] + "-" + tmpLatArr2[0] + "." + tmpLat3 +tmpStr;
	   			sheetObj.CellValue2(i+1, "latitude") = str;
	       	}
	       	
	       	//Longitude 표기법 도분초로 변환
	       	for(var i=0; i<rowLeng; i++){
		    	var tmpLon1 = 0;
		    	var tmpLon2 = "";
		    	var tmpLonArr1 = 0;
		    	var tmpLonArr2 = 0;
		    	var tmpLon3 = 0;
		    	var tmpStr = "";
		    	var str = "";
	   			tmpLon1 = sheetObj.CellValue(i+1, "longitude");
	   			if(tmpLon1 > 0){
	   				tmpStr = "E";
	   			}else{
	   				tmpStr = "W"
	   			}
	   			tmpLon1 = Math.abs(tmpLon1);
	   			tmpLon1 = "" + tmpLon1;
	   			tmpLonArr1 = tmpLon1.split(".");
	   			tmpLonArr1[1] = (tmpLon1 - tmpLonArr1[0])*60;
	   			tmpLon2 = tmpLon2 + tmpLonArr1[1];
	   			tmpLonArr2 = tmpLon2.split(".");
	   			tmpLon3 = parseInt((tmpLonArr1[1] - tmpLonArr2[0])*60);
	   			tmpLon3 = "" + tmpLon3;
	   			
	   			if(tmpLonArr1[0].length==1)		tmpLonArr1[0] = "0" + tmpLonArr1[0];
	   			if(tmpLonArr2[0].length==1)		tmpLonArr2[0] = "0" + tmpLonArr2[0];
	   			if(tmpLon3.length==1)			tmpLon3 = "0" + tmpLon3;
	   			
	   			str = tmpLonArr1[0] + "-" + tmpLonArr2[0] + "." + tmpLon3 +tmpStr;
	   			sheetObj.CellValue2(i+1, "longitude") = str;
	       	}
	       	
	        
	        

	        break;
	    }
	}
    

    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
//    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
//        }
//
//        return true;
//    }

	/* 개발자 작업  끝 */