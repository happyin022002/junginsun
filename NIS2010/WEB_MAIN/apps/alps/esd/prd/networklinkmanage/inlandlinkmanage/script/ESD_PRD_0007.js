/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0007.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.23 김귀진
* 1.0 Creation
* 1. 2011.01.18 이수진  [CHM-201108245-01] PRD내 Service Provide Inquiry 화면 변경 요청 
*    =>  List Link 버튼 클릭 시 및 하단 Grid의 S/P값 변경
*        (기존에는 Vendor Seq.를 선택하면 Parent Vendor Seq.를 보여줬었는데 자기 자신의 Vendor Seq.가 보이도록 수정) 
=========================================================*/

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var validateData ="";
var retValidate = 0;
var isDoor;
var comData1 ="";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var formObject = document.form;

         var dispaly ;
         var classId ;
         var func ;
         var param ;
         var chkStr ;
         
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            /****************************
             enterKey 처리
            *****************************/
            var srcObj=window.event.srcElement.nodeName;
            var keyObj=window.event.keyCode;
            //if(srcObj =='INPUT' && keyObj ==13) {
             //   srcName ='btn_retrieve';
            //}
           
            switch(srcName) {

        	    case "btn_retrieve":
            	    if(!ComChkRequired(formObject)) return;
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	        
        	    case "btn_save":
        	    	if(!ComChkRequired(formObject)) return;
        	    	doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

        	    case "btng_select":
    	            ComShowMessage("btng_select Click!!");
        	        break;

        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;

        	    case "btng_rowcopy":
    	            doActionIBSheet(sheetObject,formObject,IBCOPYROW);
        	        break;

        	    case "btn_ok":
        	          sendDataToGrid(sheetObject);

        	      break;

        	    case "btn_close":
    	              window.close();
        	      break;

                case "btn_org_loc":
                   dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId = "COM_ENS_051";

                   func = "getOrgLoc";
        		   param = '?classId='+classId+'&func=getOrgLoc&display='+dispaly;
        			  
        		   chkStr = dispaly.substring(0,3)
                      
                       // radio PopUp  
                   if(chkStr == "1,0") {
                      myWin = ComOpenWindowCenter('/hanjin/COM_ENS_051.do'+param, 'pop', 770, 470, true);
                   } else {
                       ComShowMessage(ComGetMsg('PRD90063'));
                       return;
                   }
                  break;
                  
                case "btn_dest_loc":
                   dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId = "COM_ENS_051";
        		   
                   func = "getDestLoc";
        		   param = '?classId='+classId+'&func=getDestLoc&display='+dispaly;
        			  
        		   chkStr = dispaly.substring(0,3)
                      
                       // radio PopUp  
                   if(chkStr == "1,0") {
                      myWin = ComOpenWindowCenter('/hanjin/COM_ENS_051.do'+param, 'pop', 770, 470, true);
		              //myWin.focus();
                   } else {
                       ComShowMessage(ComGetMsg('PRD90063'));
                       return;
                   }
                  break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('PRD90054'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    function getDestLoc(rowArray) {
    	
    	var colArray = rowArray[0];
    	document.all.i_dest_cd.value = colArray[3];
    }
        
    function getOrgLoc(rowArray) {

    	
    	var colArray = rowArray[0];
    	document.all.i_org_cd.value = colArray[3];
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
        
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'i_org_cd', 'i_dest_cd');

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

                   // MassOfSearch = 1;
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(22, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Del.|STS|Seq.|Chk|From Node|From Node|To Node|To Node|Mode|S/P Name|S/P Name|T/T\n(DD.HH)|Distance|UOM|fc " ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHidden,        30,    daCenter,  false,    "",               false,          "",       dfNone,	    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,    "ibflag",         false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,           30,    daCenter,  false,    "",               false,          "",       dfNone,   	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtRadioCheck ,   30,    daCenter,  false,    "chk",            false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,     60,    daCenter,  false,    "org_loc",        false,          "",       dfNone,        0,     false,      true,5);
                    InitDataProperty(0, cnt++ , dtData,          20,    daCenter,  false,    "org_type",       false,          "",       dfNone,        0,     false,      true,2);
                    InitDataProperty(0, cnt++ , dtPopupEdit,     60,    daCenter,  false,    "dest_loc",       false,          "",       dfNone,        0,     false,      true,5);
                    InitDataProperty(0, cnt++ , dtData,          20,    daCenter,  false,    "dest_type",      false,          "",       dfNone,        0,     false,      true,2);
                    InitDataProperty(0, cnt++ , dtCombo,         40,    daCenter,  false,    "trsp_mod_cd",    false,          "",       dfNone, 	    0,     false,      true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,     70,    daCenter,  false,    "vndr_seq",       true,           "",       dfNone,        0,     true,       true,6);
                    InitDataProperty(0, cnt++ , dtData,          70,    daLeft,    false,    "vndr_name",      false,          "",       dfNone, 	    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,          50,    daCenter,  false,    "fmt_tztm_hrs",   true,           "",       dfUserFormat2, 2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,          60,    daCenter,  false,    "lnk_dist",       false,          "",       dfNullInteger, 0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,         40,    daCenter,  false,    "dist_ut_cd",     false,          "",       dfNone, 	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "rail_crr_tp_cd", false,          "",       dfNone, 	    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        30,    daCenter,  false,    "lnk_org_nod_cd", false,          "",       dfNone,   	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,        30,    daCenter,  false,    "lnk_dest_nod_cd",false,          "",       dfNone, 	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,        30,    daCenter,  false,    "tztm_hrs",       false,          "",       dfNone, 	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,        30,    daCenter,  false,    "vndr_cnt_cd",    false,          "",       dfNone, 	    0,     true,       true);
                   
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "org_is_door",    false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "dest_is_door",   false, "",       dfNone,        0,     true,       true);
                              
                    InitDataProperty(0, cnt++ , dtHidden,        30,    daCenter,  false,    "fc",             false,          "",       dfNone,        0,     true,       true);
                    
		            InitDataCombo(0, "trsp_mod_cd", trsp_mod_cdText, trsp_mod_cdCode);
		            InitDataCombo (0, "dist_ut_cd", " |M|K", " |M|K");
		            InitDataCombo(0, "rail_crr_tp_cd", rail_crr_tp_cdText, rail_crr_tp_cdCode);
		            InitUserFormat2(0, "fmt_tztm_hrs", "##.##", "." );
		            sheetObj.InitDataValid(0, 4 , vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

					InitDataValid(0, "org_loc",     vtEngUpOther, "1234567890");
					InitDataValid(0, "org_type",    vtEngUpOther, "1234567890");
					InitDataValid(0, "dest_loc",    vtEngUpOther, "1234567890");
					InitDataValid(0, "dest_type",   vtEngUpOther, "1234567890");
					InitDataValid(0, "vndr_seq",    vtEngUpOther, "1234567890");
					
					WaitImageVisible=false;
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
                if(validateForm(sheetObj,formObj,sAction));
           		ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST;
                if(formObj.i_org_cd.value=="" && formObj.i_dest_cd.value=="" ) {
                    return false;  
                }
                sheetObj.DoSearch4Post("ESD_PRD_0007GS.do", PrdFQString(formObj));
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                if(validateForm(sheetObj,formObj,sAction));
                formObj.f_cmd.value = MULTI;
                setNodCd(sheetObj);
                calcuTztmHrs(sheetObj);
                if(sheetObj.DoSave("ESD_PRD_0007GS.do", PrdFQString(formObj),-1,false)) {
                	pseudoCdCheck(sheetObj);
                }
                break;
           case IBINSERT:      // 입력

               if(validateForm(sheetObj,formObj,sAction))
                 sheetObj.DataInsert();
                break;

           case IBCOPYROW:        //행 복사

              sheetObj.CheckAll("chk") = 0 ;
              var idx = sheetObj.DataCopy();
              sheetObj.CellValue2(idx,"chk")=1;
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
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              break;    
           //node check
           case SEARCH04:
        	   
              formObj.f_cmd.value = SEARCH04;

              uid= "ESD_PRD_0007";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              isDoor = sheetObjects[0].EtcData("isDoor"); //jsy
              break;                  
           //vender check
           case SEARCH08:
        	   
              formObj.f_cmd.value = SEARCH08;


              uid= "ESD_PRD_0007";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              comData1 = sheetObjects[0].EtcData("comData1");
              
              break;                
        }
    }
    
    function  pseudoCdCheck(sheetObj){
        var pseudoCd = sheetObj.EtcData("pseudoCd");
        var blankCd = sheetObj.EtcData("blankCd");
        var invalidVendorCd = sheetObj.EtcData("invalidVendorCd");
     
        var msg = "";
        if(pseudoCd.length>0){
          
        	msg = ComGetMsg('PRD90064',pseudoCd);
        }
        if(blankCd.length>0){
            msg = msg+ComGetMsg('PRD90065',blankCd);
        }
        if(invalidVendorCd.length>0){
            msg = msg+ComGetMsg('PRD90066',invalidVendorCd);
        }        
      
        if(pseudoCd.length>0 || blankCd.length>0 || invalidVendorCd.length>0){
            ComShowMessage(msg);
        }
    }
    /*
     * 신규시 히든으로 디비의 키값을  만든다. 
     */
    function setNodCd(sheetObj) {
        for( i=1; i<= sheetObj.RowCount; i++) {
            if(sheetObj.RowStatus(i)=="I") {
                sheetObj.CellValue2(i,"lnk_org_nod_cd")=sheetObj.CellValue(i,"org_loc")  + sheetObj.CellValue(i,"org_type");
                sheetObj.CellValue2(i,"lnk_dest_nod_cd")=sheetObj.CellValue(i,"dest_loc")  + sheetObj.CellValue(i,"dest_type");
            }
        }
    }
    /**
     * 시트에서 포맷으로 된 일수||시간을 시간으로 변경  
     * - comPopupInSheet() 호출 : row, col 정보를 Parameter로 전달  
     */
    function calcuTztmHrs(sheetObj) {
        
        var fmtTime =0;
        for( i=1; i<= sheetObj.RowCount; i++) {
           if(sheetObj.RowStatus(i)=="I" || sheetObj.RowStatus(i)=="U"){
               fmtTime = sheetObj.CellValue(i,"fmt_tztm_hrs");
               if (fmtTime == undefined || fmtTime == '') {
            	   sheetObj.CellValue2(i,"tztm_hrs") = "";
               } else {
            	   sheetObj.CellValue2(i,"tztm_hrs")=(eval(fmtTime.substring(0,2)*24)+eval(fmtTime.substring(2)));
               }
           }
        }
        
    }
// dtPopupEdit 로 처리 할 경우 팝업오픈 처리

function sheet2_OnPopupClick(sheetObj, row, col)
{
    if ( sheetObj.ColSaveName(col) == "spname" )
    {
       ComShowMessage("S/P Name Search Popup Open!! row=" + row );
    }
}


/**
 * 시트에서 Biz 공통 팝업 호출
 * - comPopupInSheet() 호출 : row, col 정보를 Parameter로 전달  
 */
    function sheet1_OnPopupClick(sheetObj, row, col){   
	 	var loc_cd_val ;
	 	var dispaly ;
	 	var classId ;
	 	var func ;
	 	var param ;
	 	var chkStr ;
	 	
        if ( sheetObj.ColSaveName(col) == "org_loc" || sheetObj.ColSaveName(col) == "dest_loc" )
        {
            loc_cd_val = sheetObj.CellValue(row, col);
            
            display = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
            
            classId = "COM_ENS_061";
            func = "getNode";
            param = '?classId='+classId+'&func=getNode&display='+display+'&loc_cd='+loc_cd_val+'&row='+row+'&col='+col;
    		  
    	    chkStr = display.substring(0,3);          
            // Radio PopUp  
            if(chkStr == "1,0") {
		
                  myWin = ComOpenWindowCenter('/hanjin/COM_ENS_061.do'+param, 'pop', 770, 470, true);
//	              myWin.focus();
           
            } else {
               ComShowMessage(ComGetMsg('PRD90063'));
               return;
            }
        }
        
        if ( sheetObj.ColSaveName(col) == "vndr_seq"  )
        {
            loc_cd_val = sheetObj.CellValue(row, col);
           
            display = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
            
            classId = "COM_ENS_0C1";
    	    param = '?pts_vndr_cd='+loc_cd_val+'&classId='+classId+'&func=getVender&display='+display+'&row='+row+'&col='+col;
    		  
    	    chkStr = display.substring(0,3);
            
            // Radio PopUp  
            if(chkStr == "1,0") {
              myWin = ComOpenWindowCenter('/hanjin/COM_ENS_0C1.do'+param, 'pop', 700, 450, true);
    
            } else {
               ComShowMessage(ComGetMsg('PRD90063'));
               return;
            }
        }    
     }    

    
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
        //시간 포맷 체크 
        if (sheetObj.ColSaveName(Col) == "fmt_tztm_hrs")
    	{
    	    var fmtTime = sheetObj.CellValue(Row,"fmt_tztm_hrs");
    	    if(fmtTime.substring(2)>23) {
    	        sheetObj.CellValue2(Row,"fmt_tztm_hrs")="";
    	        sheetObj.SelectCell(Row,"fmt_tztm_hrs");
    	    }
    	}   
    	//sp 코드 체크 
    	if (sheetObj.ColSaveName(Col) == "vndr_seq")
    	{
    		
            if( sheetObj.CellValue(Row,"vndr_seq").length == 6 ) {
                //validateData 는 체크할 nod cd 
                
                validateData = sheetObj.CellValue(Row,"vndr_seq");
                doActionIBSheet(sheetObjects[0],document.form, SEARCH08);
                //rowcount 가 1보다 작으면 
                if(retValidate < 1) {
                    sheetObj.CellValue2(Row,"vndr_seq")="";
                    sheetObj.SelectCell(Row,"vndr_seq");
                } else {
                    sheetObj.CellValue2(Row,"vndr_name") = comData1;
                }
            }   
    	} 
    	     
        if(sheetObj.RowStatus(Row)=="I") {
            if(sheetObj.ColSaveName(Col) != "org_loc" && sheetObj.ColSaveName(Col) != "org_type" 
               && sheetObj.ColSaveName(Col) != "dest_loc" && sheetObj.ColSaveName(Col) != "dest_type" 
               && sheetObj.ColSaveName(Col) != "trsp_mod_cd") return;
            sheetObj.CellValue2(Row,"lnk_org_nod_cd")=sheetObj.CellValue(Row,"org_loc")  + sheetObj.CellValue(Row,"org_type");
            sheetObj.CellValue2(Row,"lnk_dest_nod_cd")=sheetObj.CellValue(Row,"dest_loc")  + sheetObj.CellValue(Row,"dest_type");

            // 노드 코드 검사 
            if(sheetObj.ColSaveName(Col)=="org_loc" || sheetObj.ColSaveName(Col)=="org_type" ) {
                if( sheetObj.CellValue(Row,"lnk_org_nod_cd").length == 7 ) {
                    //validateData 는 체크할 nod cd 
                    validateData = sheetObj.CellValue(Row,"lnk_org_nod_cd");
                    doActionIBSheet(sheetObjects[0],document.form, SEARCH04);
                    //rowcount 가 1보다 작으면 
                    sheetObj.CellValue2(Row,"org_is_door")=isDoor; //jsy
                    if(retValidate < 1) {
                        sheetObj.CellValue2(Row,"org_loc")="";
                        sheetObj.CellValue2(Row,"org_type")="";
                        sheetObj.SelectCell(Row,"org_loc");
                    } 
                }                
            }

           if(sheetObj.ColSaveName(Col)=="dest_loc" || sheetObj.ColSaveName(Col)=="dest_type" ) {
                if( sheetObj.CellValue(Row,"lnk_dest_nod_cd").length == 7 ) {
                    //validateData 는 체크할 nod cd 
                    validateData = sheetObj.CellValue(Row,"lnk_dest_nod_cd");
                    doActionIBSheet(sheetObjects[0],document.form, SEARCH04);
                    sheetObj.CellValue2(Row,"dest_is_door")=isDoor;
                    //rowcount 가 1보다 작으면 
                    if(retValidate < 1) {
                        sheetObj.CellValue2(Row,"dest_loc")="";
                        sheetObj.CellValue2(Row,"dest_type")="";
                        sheetObj.SelectCell(Row,"dest_loc");
                    } 
                }                
           }
           if(sheetObj.CellValue(Row,"org_is_door")=='true' || sheetObj.CellValue(Row,"dest_is_door")=='true') {
               sheetObj.CellValue2(Row,"trsp_mod_cd")="TD";
               sheetObj.CellEditable(Row,"trsp_mod_cd") = false;
           } else {
               sheetObj.CellEditable(Row,"trsp_mod_cd") = true;
               
           }
           
            if(sheetObj.CellValue(Row,"lnk_org_nod_cd")==sheetObj.CellValue(Row,"lnk_dest_nod_cd") ){
               // FROM , TO NODE 가 같으면 안된다. Destination node must be different from orgin node.
                
	            ComShowMessage(ComGetMsg('PRD90067'));
                sheetObj.CellValue2(Row,"dest_type")="";
                sheetObj.SelectCell(Row,"dest_loc",true,"");      
                         
                return ;
           }            
           //미주 검사 
           if(sheetObj.CellValue(Row,"lnk_org_nod_cd").length == 7 && sheetObj.CellValue(Row,"lnk_dest_nod_cd").length == 7 ) {
               var org = sheetObj.CellValue(Row,"lnk_org_nod_cd").substring(0,2);
               var des = sheetObj.CellValue(Row,"lnk_dest_nod_cd").substring(0,2);
               var trsp = sheetObj.CellValue(Row,"trsp_mod_cd"); 
               if( (org == "US" || org == "CA"  ) && (des == "US" || des == "CA"  ) && trsp =="RD" ) {
                   sheetObj.CellEditable(Row,"rail_crr_tp_cd") = true;
               }
           }
           
            
            // SP 검사 
           if(sheetObj.ColSaveName(Col)=="vndr_seq" ) {
                if( sheetObj.CellValue(Row,"vndr_seq").length == 6 ) {
                    //validateData 는 체크할 nod cd 
                    
                    validateData = sheetObj.CellValue(Row,"vndr_seq");
                    doActionIBSheet(sheetObjects[0],document.form, SEARCH08);
                    //rowcount 가 1보다 작으면 
                    if(retValidate < 1) {
                        sheetObj.SelectCell(Row,"vndr_seq");
                    } else {
                        sheetObj.CellValue2(Row,"vndr_name") = comData1;
                        //sheetObj.CellValue2(Row,"vndr_seq") = validateData;
                    }
                }  
                                
           }
            
          
        } 

    }

     
     function getVender(rowArray, row, col) {
        var sheetObj = sheetObjects[0];
    	var colArray = rowArray[0];
    	sheetObj.CellValue2(row, "vndr_seq") = colArray[2];
    	sheetObj.CellValue2(row, "vndr_name") = colArray[4];
    	
    }
     
/**
 * Location : 팝업에서 Radio로 단일 선택을 한경우..
 */
    function getNode(rowArray, row, col) {
        var sheetObj = sheetObjects[0];
        
    	var colArray = rowArray[0];
    	if (col == sheetObj.SaveNameCol("org_loc")) {
    		sheetObj.CellValue2(row, "org_type") = colArray[3].substring(5);
    	} else if (col == sheetObj.SaveNameCol("dest_loc")) {
    		sheetObj.CellValue2(row, "dest_type") = colArray[3].substring(5);
    	}
//    	sheetObj.CellValue2(row, col+1) = colArray[3].substring(5);
    	sheetObj.CellValue2(row, col) = colArray[3].substring(0,5);
    	
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
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
    	if(retValidate < 1) {
        	if (num ==1) {
            	document.form.i_org_cd.value = "";
            	document.form.i_org_cd.focus();
        	}
        	if (num ==2) {
            	document.form.i_dest_cd.value = "";
            	document.form.i_dest_cd.focus();
        	}
    	}

    }
    
    
    function sheet1_OnClick(sheetObj, Row, Col, Value)  {
 
        sheetObj.CheckAll("chk") = 0 ;
        sheetObj.CellValue2(Row,"chk")=1;    


    }    

    // sheet1 에서 클릭 이벤트 발생시 
    function sheet1_OnDblClick(sheetObj, row, col, value) {
            sendDataToGrid(sheetObj)
    }
    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	for(var i =1 ; i<=sheetObj.TotalRows;i++){
    		if(sheetObj.CellValue(i,"fc") == "T"){
    			sheetObj.CellEditable(i, "rail_crr_tp_cd") =  true;
    		}else{
    			sheetObj.CellEditable(i, "rail_crr_tp_cd") =  false;
    		}
    	}
    	
    }

    function sendDataToGrid(sheetObject) {
          var openerSheet = window.opener.document.sheet2 ;
         
          if(sheetObject.CheckedRows("chk")>0) {
                var iRow = document.form.row.value;
                var iCheckRow = sheetObject.FindCheckedRow("chk");
                var arrRow = iCheckRow.split("|");
                var insertRow = parseInt(arrRow[0]);
				
               if(sheetObject.RowStatus(insertRow) == 'I') {
                   ComShowMessage( ComGetMsg('PRD90035'));
                   return;
               }
               
                openerSheet.CellValue2( iRow, "lnk_org_loc"        ) = sheetObject.CellValue( insertRow , "org_loc") ;
            
                openerSheet.CellValue2( iRow, "lnk_org_type"        ) = sheetObject.CellValue( insertRow , "org_type") ;
                openerSheet.CellValue2( iRow, "lnk_dest_loc"        ) = sheetObject.CellValue( insertRow , "dest_loc") ;
                openerSheet.CellValue2( iRow, "lnk_dest_type"       ) = sheetObject.CellValue( insertRow , "dest_type") ;
                openerSheet.CellValue2( iRow, "trsp_mod_cd"         ) = sheetObject.CellValue( insertRow , "trsp_mod_cd") ;
                openerSheet.CellValue2( iRow, "vndr_seq"            ) = sheetObject.CellValue( insertRow , "vndr_seq") ;
                openerSheet.CellValue2( iRow, "vndr_name"           ) = sheetObject.CellValue( insertRow , "vndr_name") ;
                openerSheet.CellValue2( iRow, "tztm_hrs"            ) = sheetObject.CellValue( insertRow , "fmt_tztm_hrs") ; // openerSheet에는 보여주기만 함 
                
                openerSheet.CellValue2( iRow, "lnk_dist"            ) = sheetObject.CellValue( insertRow , "lnk_dist") ;
                openerSheet.CellValue2( iRow, "dist_ut_cd"          ) = sheetObject.CellValue( insertRow , "dist_ut_cd") ;
                openerSheet.CellValue2( iRow, "rail_crr_tp_cd"      ) = sheetObject.CellValue( insertRow , "rail_crr_tp_cd") ;
                openerSheet.CellValue2( iRow, "lnk_org_nod_cd"      ) = sheetObject.CellValue( insertRow , "lnk_org_nod_cd") ;
                openerSheet.CellValue2( iRow, "lnk_dest_nod_cd"     ) = sheetObject.CellValue( insertRow , "lnk_dest_nod_cd") ;
               
                var org = sheetObject.CellValue( insertRow , "org_loc").substring(0,2);
                var dest = sheetObject.CellValue( insertRow , "dest_loc").substring(0,2);
            	if( (org == "US" || org == "CA"  ) && (dest == "US" || dest == "CA" ) &&  sheetObject.CellValue( insertRow , "trsp_mod_cd") =="RD" ) {
            	    openerSheet.CellEditable(iRow,"agmt_no") = true;
            	    openerSheet.CellEditable(iRow,"rail_crr_tp_cd" ) = true;
            	}
            	
           }

          window.close();        
    }
    
     
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }