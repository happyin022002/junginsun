/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1061.js
*@FileTitle : Empty Repo Result
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.23
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.11.23 양봉준
* 1.0 Creation
* 2010.12.03 양봉준 [CHM-201007345-01] EES_EQR_1061 화면 신규 개발
* 2010.12.23 이병훈 [CHM-201007931-01] [EQR] - Empty Repo Result 기능 보완
* 2011.01.27 이병훈 [CHM-201108603-01] [EQR] Empty Repo.Result(T/R/W) 조회 조건 보완
* 2012.04.25 SHIN YONGCHAN [CSR 없음]  LINE 514, , 90 --> 93 으로 수정
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
     * @class EES_EQR_1061 : EES_EQR_1061 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1061() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0 ;

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

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
    	            comboObjects[0].Code = "ALL";
    	            document.form.transmode.value = "ALL";
    	            comboObjects[1].Code = consTpsz;
        	        break;
        	        
                case "btn_downexcel":
			        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			        break;        	        
        		       
      			case "fmloc_btn":
                     var display = "0,1,1,1,1,1";
                     var targetObjList = "loc_cd:fmloc|loc_dpth_cd:fmType";
                     var param = "?depth=3&classId=COM_ENS_0O1";
                     ComOpenPopupWithTarget('/hanjin/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
        		     break;
        		     
        		case "toloc_btn":
                     var display = "0,1,1,1,1,1";
                     var targetObjList = "loc_cd:toloc|loc_dpth_cd:toType";
                     var param = "?depth=3&classId=COM_ENS_0O1";
                     ComOpenPopupWithTarget('/hanjin/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
        		     break;
        		     
        		case "atloc_btn":
                     var display = "0,1,1,1,1,1";
                     var targetObjList = "loc_cd:atEccCd|loc_dpth_cd:atType";
                     var param = "?depth=3&classId=COM_ENS_0O1";
                     ComOpenPopupWithTarget('/hanjin/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
        		     break;        		       
        		       
  
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("EQR90004");
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
     * IBCombo Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        var tpsz = null;

        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1,tpsz);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        
        document.form.tpszall.value = consTpsz;
                
        // fmdate 항목의 Default MaxLength 셋팅
        document.form.fmdate.maxLength = "8";
    }
   
   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,tpsz) {

        var cnt = 0;
        var TotalCount = '';
        var TitleCount;
        var TitleKey = consTpsz;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                  
                  if ((tpsz =='' || tpsz == null)){
                    title = tpszallText+'|';
                		num = TitleKey.split(',');
                	  TotalCount = num.length + 9;
                  }else {
                		TitleCount = ""+ tpsz +"";
                		title = TitleMake(TitleCount);
                		num = TitleCount.split(',');
                		TotalCount = num.length + 9;
                  }	    
                  
                    // 높이 설정
                    style.height = GetSheetHeight(15) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                   //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 7, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(TotalCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    
                    var TotSum = "";
                    var HeadVol = "";
            				if ((tpsz !='' || tpsz != null)){ 
            				  for(var i=0; i<num.length ; i++) {
            				     TotSum += "|"+num[i]+"cntr_qty|+"
            				     HeadVol += "|Vol"
            				  }
            				}
          				  TotSum = TotSum.substring(0,TotSum.length-1);
          				  
          			var HeadTitle1 = "Del.|STS|Seq.|FM LOC|TO LOC|Period|Mode|Vol" + HeadVol ;	  
                    var HeadTitle = "Del.|STS|Seq.|FM LOC|TO LOC|Period|Mode|TTL|" + title ;
                    

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHidden,   		30,    daCenter, false,    "del");
                    InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    daCenter, false,    "ibflag");
                    InitDataProperty(0, cnt++ , dtData,       		50,    daCenter,  true,    "seq",       false,          "",       dfNone,	    0,     false,       true,    7);
                    InitDataProperty(0, cnt++ , dtData,       		70,    daCenter,  true,    "fm_loc",     false,          "",       dfNone,     0,     false,       true,    7);
                    InitDataProperty(0, cnt++ , dtData,       		70,    daCenter,  true,    "to_loc",     false,          "",       dfNone,     0,     false,       true,    7);
                    InitDataProperty(0, cnt++ , dtData,      		100,   daCenter,  true,    "period",      false,          "",       dfNone,   	0,     false,       true,    4);
                    InitDataProperty(0, cnt++ , dtData,      		70,    daCenter,  true,    "transmode",        false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       		60,    daRight,   false,   "total",      false,          "",       dfInteger,  	2,     false,       false,    11);
                    if ((tpsz =='' || tpsz == null)){ 
                    	//동적 레이아웃 시작 
                    	for(var i=0; i<num.length ; i++) {
                    	  InitDataProperty(0, cnt++ , dtData,      63,    daRight,   false,     num[i].toLowerCase()+"cntr_qty",        false,         "",        dfInteger,      2,     false,       false,    8);
                    	 }
                    } else {
                    	//동적 레이아웃 시작 
                      	for(var i=0; i<num.length ; i++) {
                      	  InitDataProperty(0, cnt++ , dtData,      63,    daRight,   false,     num[i].toLowerCase()+"cntr_qty",        false,         "",        dfInteger,      2,     false,       false,    8);
                      	}
                    }   
                    InitDataProperty(0, cnt++ , dtHidden,   		0,    daCenter, false,    "hidden");
               }
                
                document.form.tpcnt.value = num.length;
                break;

        }
    }
    
	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
	{
	  subSum(sheetObj);
	  if(document.form.weekMonth[1].checked == true){
	    sheetObj.CellValue(0,"week") = "Month";
	  }else{
	    sheetObj.CellValue(0,"week") = "Week";
	  }
	  
	  //data1 && data2 조회 또는 data1 = P 조회.
	   if(document.form.orgDst[0].checked == true){
	     sheetObj.ColHidden('fm_ecc_cd')  = false;
	     sheetObj.ColHidden('to_ecc_cd')  = true;
	   }
	   if(document.form.orgDst[1].checked == true){
	     sheetObj.ColHidden('fm_ecc_cd')  = true;
	     sheetObj.ColHidden('to_ecc_cd')  = false;
	   }
	   if(document.form.orgDst[2].checked == true){
	     sheetObj.ColHidden('fm_ecc_cd')  = false;
	     sheetObj.ColHidden('to_ecc_cd')  = false;
	   }
	  
	  //data1 만 조회시(P가 아닌 경우)
	  if(document.form.dataSelect1.value != 'P' && document.form.dataSelect2.value == '' ){
	      sheetObj.ColHidden('fm_ecc_cd')  = false;
	      sheetObj.ColHidden('to_ecc_cd')  = true;
	  }
	  
	}

   /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initCombo (comboObj, comboNo) {
        var cnt  = 0 ;

        switch(comboNo) {
        
		// Item
        case 1:
           	with (comboObj) {
           		DropHeight = 8 * 20;

					var menuname = itemText.split('|');
					var menucode = itemCode.split('|');

           		MultiSelect = true;
           		MaxSelect =  menuname.length+1;
           		MultiSeparator = ",";

           		InsertItem(cnt ++, "ALL", "ALL");
    			for(i=0; i<menuname.length; i++) {
    				if (menucode[i] == "R") {
    					InsertItem(cnt++, menuname[i], "RD");
    				}
    				if (menucode[i] == "T") {
    					InsertItem(cnt++, menuname[i], "TD");
    				}
    				if (menucode[i] == "W") {
    					InsertItem(cnt++, menuname[i], "WD");
    				}
  				}
    			
    			comboObj.Code = "ALL"; // Default 값 셋팅
	    	}
           break;
        
           // Type Size
            case 2:
               with (comboObj) {

               	DropHeight = 12 * 18;
                var menuname2= tpszallText.split('|');
                var menucode2= tpszallCode.split('|');
                
               	MultiSelect = true;
               	MaxSelect = menuname2.length ;
               	MultiSeparator = ",";
               
       	        for(i=0; i<menuname2.length; i++) {
                    InsertItem(cnt ++, menuname2[i], menucode2[i]);                      		
                } 
    	    }
               break;
         }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var perfix = new Array(comboObjects[1].Text);

        switch(sAction) {

           case IBSEARCH:      //조회
      			    //OrgDest : org 면 to값을 All 로 바꿈., dest먄 fm 입력값을 All 로 바꿈.
                //동적으로 보여주기 위해서 IBSHEET 레이아웃 초기화 하고 다시 보여준다. 
        	   
               if(!validateForm(sheetObj,formObj,sAction)){
   			      return false;
   			    }
        	   	 
                 sheetObj.Visible = false;
                 sheetObj.RemoveAll();
                 sheetObj.Reset();
                 initSheet(sheetObj, 1, perfix);
                 sheetObj.Visible = true;
                 sheetObj.ExtendLastCol = false;
                 //end
                 
   			     formObj.f_cmd.value = SEARCHLIST;
   			     sheetObj.DoSearch4Post("EES_EQR_1061GS.do", eqrFormQryStr(formObj));
			   			    
                break;
            case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction))
                formObj.f_cmd.value = MULTI;

                break;

           case IBINSERT:      // 입력
                sheetObj.DataInsert();
                break;

           case IBCOPYROW:        //행 복사
              sheetObj.DataCopy();
              break;

           case IBDOWNEXCEL:        //엑셀 다운로드
              sheetObj.Down2Excel(-1, false, false, true);
              break;

           case IBLOADEXCEL:        //엑셀 업로드
              sheetObj.LoadExcel();
             break;

        }
    }


   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
 
        	var pd = formObj.period.value;
        	var fm = formObj.fmdate.value;
        	var to = formObj.todate.value;
        	
        	if(pd == 'Day'){
        		if(!isValidDate(fm,pd)){
        			ComShowCodeMessage("EQR90113", "From date");//From date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        		if(!isValidDate(to,pd)){
        			ComShowCodeMessage("EQR90113", "To date");//To date is wrong.
        			eval("formObj.todate").focus();
        			return false;
        		}
        		if(ComGetDaysBetween(fm, to) >= 90){
        			ComShowCodeMessage("EQR70008");//To date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        	}else if(pd == 'Week'){
        		if(!isValidDate(fm,pd)){
        			ComShowCodeMessage("EQR90113", "From "+pd);//From date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        		if(!isValidDate(to,pd)){
        			ComShowCodeMessage("EQR90113", "To "+pd);//To date is wrong.
        			eval("formObj.todate").focus();
        			return false;
        		}
        		
        		var fromTo = 52;  // 52주간격을 의미함(01-53)
        		var fmyyyy = fm.substr(0,4);
        		var fmWeek = fm.substr(4,2);
        		var toyyyy = to.substr(0,4);
        		var toWeek = to.substr(4,2);
        		var yyyyDiff = fromTo * (parseInt(toyyyy)-parseInt(fmyyyy));
        		var fmToDiff = yyyyDiff + parseInt(toWeek) - parseInt(fmWeek); 

        		if(fmToDiff > 12){
        			ComShowCodeMessage("EQR70008");//To date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        	}else if(pd == 'Month'){
        		if(!isValidDate(fm,pd)){
        			ComShowCodeMessage("EQR90113", "From "+pd);//From date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        		if(!isValidDate(to,pd)){
        			ComShowCodeMessage("EQR90113", "To "+pd);//To date is wrong.
        			eval("formObj.todate").focus();
        			return false;
        		}
        		
        		var fmMonth = fm + "01";
        		var toyyyy = to.substr(0,4);
        		var tomm = to.substr(4,2);
        		var toMonth = to + ComGetLastDay(toyyyy, tomm);
        		
        		// 2012-04-25, SHIN YONGCHAN, 90 --> 93 으로 수정
        		if(ComGetDaysBetween(fmMonth, toMonth) > 93){
        			ComShowCodeMessage("EQR70008");//To date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        	}
        	
        	if(fm > to){
        		ComShowCodeMessage("EQR90215") // End date must be greater than start date.
        		eval("formObj.todate").focus();
        		return false;
        	}
        	
        	if (formObj.transmode.value == "") {
        		ComShowCodeMessage("EQR90016", "Mode");//Please select Mode.
        		return false;
        	}
        	
        	if (formObj.fmType.value != "ALL") {
				if(!checkLocItem(formObj, 'fmType', 'fmloc')) {
					return false;
				}
        	}
			
        	if (formObj.toType.value != "ALL") {
				if(!checkLocItem(formObj, 'toType', 'toloc')) {
					return false;
				}
        	}
        	
        }

        return true;
    }

   function tpszChange(key){
            switch (key)
            {
                case "ALL":
                    comboObjects[1].Code = consTpsz;                            
                	break;
                case "D":
                    comboObjects[1].Code = consTpszDry;                
                	break;
                case "R":
                    comboObjects[1].Code = consTpszRfr;
                	break;
                case "O":
                    comboObjects[1].Code = consTpszOt;
                	break;
                case "F":
                    comboObjects[1].Code = consTpszFr;
                	break;
            }
    }	   

    function subSum(sheetObj){
		//
		var TotalCount = '';
		var num = document.form.tpcnt.value;
		var TotSum = '7';
	  for(var i=0, j=8 ; i<num ; i++, j++) {
		     TotSum += "|"+j
		 }     
	  sheetObj.ShowSubSum("ibflag", TotSum, -1, true, false, -1, "2=TTL");
    }
    
    
    function TitleMake(TitleCount){
      
      var strCheckList ='';
          num = TitleCount.split(',');
      for(var i=0; i < num.length ; i++)  {
           strCheckList = strCheckList + num[i] + "|";
       }
      return strCheckList;
    } 

    // 유효 입력 date 조건
    function isValidDate(date, period){
    	if(period == 'Day'){
    		if(date.length != 8){
    			return false;
    		}
    		if(isValidYear(date) && isValidMonth(date)){
    			if(isValidDay(date)){
    				return true;	
    			}else{
        			return false;
    			}
    		} else {
    			return false;
    		}
    	} else if(period == 'Month'){
    		if(date.length != 6) return false
    		if(isValidYear(date) && isValidMonth(date)){
    			return true;
    		} else {
    			return false;
    		}
    	} else if(period == 'Week'){
    		if(date.length != 6) return false
    		if(isValidYear(date) && isValidWeek(date)){
    			return true;
    		} else {
    			return false;
    		}
    			
    	}
    	
    }
    
    
    // 유효 연차 체크
    function isValidYear(yyyyww) {
    	var year = yyyyww.substring(0,4);
    	if (parseInt( year ) >= 1900) {
    		return true;
    	} else {
    		return false;
    	}
    }    
    
    
    // 유효 월차 체크
    function isValidMonth(yyyymm) {
    	var month = yyyymm.substring(4,6);
       	var intmonth = parseInt( month , 10 )
       	if( intmonth >= 1  && intmonth <= 12 ) {
       		return true;
       	} else {
       		return false;
       	}
    }
    
    // 유효 주차 체크
    function isValidWeek(yyyyww) {
    	
    	var week = yyyyww.substring(4,6);
    	if (parseInt( week , 10) >= 1 &&  parseInt(week , 10) <= 53) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    // 유효 날짜 체크
    function isValidDay( date ) {
    	
    	var year = date.substring(0,4);
    	var month = date.substring(4,6);
    	var day = date.substring(6,8);
    	var monthDD = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
    	var im = parseInt(month) - 1;
    	if( ( (year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) ) {
    		monthDD[1] = 29;
    	}
    	if( parseInt( day , 10 ) <= 0 || parseInt( day , 10 ) > monthDD[im] ) {
    		return false;
    	} else {
    		return true;
    	}
    } 

    // 선택된 Period Type에 따라서 fmdate MaxLength 변경
    function changeFmDateMaxLength(arg) {
    	var checkType = arg.value;
    	
    	document.form.fmdate.value = "";
    	document.form.todate.value = "";
    	
    	if (checkType == "Day") {
    		document.form.fmdate.maxLength = "8";
    		document.form.todate.maxLength = "8";
    	} else if (checkType == "Week" || checkType == "Month") {
    		document.form.fmdate.maxLength = "6";
    		document.form.todate.maxLength = "6";
    	}
    }
   
    // Mode 값이 변경되었을때 처리
    function item_OnChange(idx ,txt){
    	var selectMode = "";
    	var preSelectMode = document.form.transmode.value;
    	
    	if (preSelectMode == "ALL" && txt.search("ALL") != -1) {
    		comboObjects[0].Code = txt.substring(4, txt.length);
    		selectMode = txt.substring(4, txt.length);
    	} else {
    		if (preSelectMode.search("ALL") == -1 && txt.search("ALL") != -1) {
    			comboObjects[0].Code = "ALL";
    			selectMode = "ALL";
    		} else {
    			selectMode = txt;
    		}
    	}
    	document.form.transmode.value = selectMode;
    }
