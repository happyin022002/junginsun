// 공통전역변수 

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var validateData ="";
var retValidate = 0;
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
        	        break;

        	    case "btn_ok":

                  var openerSheet = window.opener.document.sheet1 ;
                  if(sheetObject.CheckedRows("chk")>0) {
                      for ( i = 0 ; i < sheetObject.Rows ; i++ ){
                          if ( sheetObject.CellValue( i, "chk" ) == 1 ) {
                              var iRow = openerSheet.DataInsert(-1);
                                openerSheet.CellValue2( iRow, "org_loc"             ) = sheetObject.CellValue( i, "org_loc") ;
                                openerSheet.CellValue2( iRow, "org_loc_type"        ) = sheetObject.CellValue( i, "org_loc_type") ;
                                openerSheet.CellValue2( iRow, "dest_loc"            ) = sheetObject.CellValue( i, "dest_loc") ;
                                openerSheet.CellValue2( iRow, "dest_loc_type"       ) = sheetObject.CellValue( i, "dest_loc_type") ;
                                openerSheet.CellValue2( iRow, "route"               ) = sheetObject.CellValue( i, "route") ;
                                openerSheet.CellValue2( iRow, "rout_org_nod_cd"     ) = sheetObject.CellValue( i, "rout_org_nod_cd") ;
                                openerSheet.CellValue2( iRow, "rout_dest_nod_cd"    ) = sheetObject.CellValue( i, "rout_dest_nod_cd") ;
                                openerSheet.CellValue2( iRow, "rout_seq"            ) = sheetObject.CellValue( i, "rout_seq") ;
                                openerSheet.CellValue2( iRow, "hub_search_gb"       ) = sheetObject.CellValue( i, "hub_search_gb") ;
                                openerSheet.CellValue2( iRow, "front_gb"            ) = sheetObject.CellValue( i, "front_gb") ;
                                openerSheet.CellValue2( iRow, "undefine_nod"        ) = sheetObject.CellValue( i, "undefine_nod") ;
                                openerSheet.CellValue2( iRow, "group_gubun"         ) = sheetObject.CellValue( i, "group_gubun") ;
                          }
                      }
                      
                  }
                  window.close();
         	      break;

        	    case "btn_close":
    	              window.close();
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
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'i_org_cd', 'i_dest_cd');
		
        
    	  doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	 
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
                    //전체 너비 설정
                    style.height = GetSheetHeight(11) ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(16, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "No.|CHK|Route List|Mode|Remark" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  false,    "",         false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,    "chk",      false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      400,    daLeft,    false,    "route",    false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "trsp_mod",   false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "inlnd_rout_rmk",   false,          "",       dfNone,   	0,     false,       true);

                    InitDataProperty(0, cnt++ , dtHidden,       80,    daCenter,  false,    "org_loc",     false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  false,    "org_loc_type",     false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       80,    daCenter,  false,    "dest_loc",     false,          "",       dfNone, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  false,    "dest_loc_type",     false,          "",       dfNone, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  false,    "rout_org_nod_cd",     false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  false,    "rout_dest_nod_cd",     false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  false,    "rout_seq",     false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  false,    "hub_search_gb",     false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  false,    "front_gb",     false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  false,    "undefine_nod",     false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  false,    "group_gubun",     false,          "",       dfNone,   	0,     true,       true);
      
               }
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var uid ;
    	var sXml ; 
	    sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction))

                formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESD_PRD_0006GS.do", PrdFQString(formObj));
                break;
            case IBSAVE:        //저장

              if(validateForm(sheetObj,formObj,sAction))

                break;

           case IBINSERT:      // 입력
               // if(!comCheckRequiredField(formObj)) return;
               if(validateForm(sheetObj,formObj,sAction))
               // formObj.f_cmd.value = SEARCH;
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
           case SEARCH02:
              formObj.f_cmd.value = SEARCH02;

              uid= "ESD_PRD_0007";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&chkData="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              break;   
        }
    }

    
    /*
     * Mandatory 체크 
     */
    function checkMandatory() {
        var formObj = document.form;
        var retValue = true;
        var orgCd = formObj.i_org_cd.value;
        var destCd = formObj.i_dest_cd.value;
         
        if( orgCd.length != 5 ) {
             ComShowMessage(ComGetMsg('PRD90007'));
             formObj.i_org_cd.focus();;
             retValue = false;
        } else if (destCd.length != 5 ) {
             ComShowMessage(ComgetMsg('PRD90007'));
             formObj.i_dest_cd.focus();;
             retValue = false;
        }
         return retValue;
    }
    
    // dtPopupEdit 로 처리 할 경우 팝업오픈 처리
    
    function sheet2_OnPopupClick(sheetObj, row, col)
    {
        if ( sheetObj.ColSaveName(col) == "spname" )
        {
           ComShowMessage(ComGetMsg('PRD90077',row) );
        }
    }



    // Location code 에 대한 validation
    function validateLocation(loc, num) {
    	if (num ==1) {
        	document.form.i_org_cd.value = loc.toUpperCase();
    	}
    	if (num ==2) {
        	document.form.i_dest_cd.value = loc.toUpperCase();
    	}        
        validateData = loc.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form, SEARCH02);
    	
    	if(retValidate < 1) { //rowcount 가 1보다 작으면 
        	if (num ==1) {
            	//document.form.i_org_cd.value = "";
            	document.form.i_org_cd.focus();
        	}else {
        	    document.form.i_dest_cd.focus();
        	}
        	if (num ==2) {
          
        	}
    	}else {
        	if (num ==1) {
            	//document.form.i_org_cd.value = "";
            	document.form.i_dest_cd.focus();
        	}
    	}
    	return false;

    }    
    

    
    function sheet1_OnClick(sheetObj, Row, Col, Value)  {

        
        
        
    }    
     
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){


        return true;
    }