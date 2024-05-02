/**
 * @fileoverview 에서 사용하는 업무 스크립트를 정의한다.
 * @author SM LINE
 */

/**
 * @extends Tes
 * @class ESD_TES_0028 : 에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TES_0028() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

// 공통전역변수
var comboObjects = new Array();
var comboCnt = 0 ;

var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 * @return
 */
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



        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(getMsg('TES21025'));
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param {sheet}	sheet_obj	ibsheet
 * @return
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj; 
}

 /**
  * combo object 를 배열로 등록
  * @param {combo}	combo_obj	combo
  * @return
  */
 function setComboObject(combo_obj){
     comboObjects[comboCnt++] = combo_obj;
 }  
 
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @return
 */
function loadPage() {

    for(i=0;i<sheetObjects.length;i++){

    //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);

        initSheet(sheetObjects[i],i+1);
    //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);;
    }
		 
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
    doActionIBSheet1(sheetObjects[1],document.form,IBSEARCH);     
			
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj
 * @param sheetNo
 * @return
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;

    switch(sheetNo) {
        case 1:      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = GetSheetHeight(10);
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(6, 1, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle = "Seq.|Cost Code|Full Name|Update Date" ;

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [	ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, 	COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
				InitDataProperty(0, cnt++ , dtData,		30,		daRight,		false,    "lgs_cost_opt_no",		false,			"",			dfNone,			0,			false,		  	false	);
				InitDataProperty(0, cnt++ , dtData,	 	150,	daLeft,			false,    "lgs_cost_cd",			false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 	400,	daLeft,			false,    "lgs_cost_full_nm",		false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 	80,		daLeft,			false,    "upd_dt",					false,			"",			dfDateYmd,		0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,	 1,		daLeft,			false,    "lgs_cost_rmk",			false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,	 1,		daLeft,			false,    "delt_flg",				false,			"",			dfNone,			0,			false,			false	);

           }
            break;                 
  
        case 2:      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = GetSheetHeight(10);
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(1, 1, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle = "Seq.|Cost Code|Full Name|Update Date" ;

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]															
									InitDataProperty(0, cnt++ , dtData,	 	150,	daLeft,			false,    "",				false,			"",			dfNone,			0,			false,			false	);			

           }
            break;                 
    }
}

 /**
  * Sheet 관련 프로세스 처리
  * @param {sheet}	sheetObj	ibsheet
  * @param {form}	formObj		form object
  * @param {int}	sAction		실행할 액션 구분 값
  * @return
  */
function doActionIBSheet(sheetObj, formObj, sAction) {	
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH:      //조회
            //formObj.f_cmd.value = COMMAND01;
         	  //sheetObj.DoSearch4Post("ESD_TES_028Combo.do", tesFrmQryStr(formObj), "",isAppend);  
             //if(validateForm(sheetObj,formObj,sAction))
            formObj.f_cmd.value = SEARCH; 
            sheetObj.DoSearch4Post("ESD_TES_0028GS.do", tesFrmQryStr(formObj));              
            break;

      case COMMAND01:
            formObj.f_cmd.value = SEARCH01;               
            sheetObj.DoSearch4Post("ESD_TES_0028Combo.do", tesFrmQryStr(formObj), "");    
            break;
    }
}
 
/**
 * Sheet 관련 프로세스 처리
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}	sAction		실행할 액션 구분 값
 * @return
 */    
function doActionIBSheet1(sheetObj,formObj,sAction) {	
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH:      //조회
            formObj.f_cmd.value = SEARCH01;
         	  sheetObj.DoSearch4Post("ESD_TES_0028Combo.do", tesFrmQryStr(formObj), "");  
         	               
            break;

      case COMMAND01:
            formObj.f_cmd.value = SEARCH01;               
            sheetObj.DoSearch4Post("ESD_TES_0028Combo.do", tesFrmQryStr(formObj), "");    
            break;
    }
}     

/**
 * sheet 클릭 시 발생
 * @param {sheet}	t3sheet1	Cost Calc.(TMNL) sheet
 * @param {int}		Row			해당 셀의 Row Index
 * @param {int}		Col			해당 셀의 Column Index
 * @param {string}	Value		변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @return
 */
function sheet1_OnClick (sheetObj , row , col, Value )
{
	var sText 		= sheetObj.CellValue(row , "lgs_cost_rmk");
	var sDel_flag 	= sheetObj.CellValue(row , "delt_flg");
	
	document.form.txtEvent.value =  sText;
	
	if(sDel_flag=="Y"){
		document.form.del_flg_y.checked=false;         	
		document.form.del_flg_n.checked=true;	
	}
	else if(sDel_flag=="N"){            
		document.form.del_flg_y.checked=true;
		document.form.del_flg_n.checked=false;		
	}
}

/**
 * sheet 조회시 발생하는 이벤트
 * @param {sheet}	sheetObj	콤보에서 사용할 데이터 관련 sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function sheet2_OnSearchEnd(sheetObj,errMsg){     	
    if(errMsg!=null){
        ComShowMessage(errMsg);
    }
    var catevalue = sheetObj.EtcData("extp_cate_list");
    var tpvalue = sheetObj.EtcData("extp_tp_list");
    
    for(p=0;p< comboObjects.length;p++){   
     	if (document.form.command_h.value  == ""){
        initCombo (comboObjects[p],p+1, catevalue, tpvalue);
      }else if (document.form.command_h.value  == "S"){
        	initCombo (comboObjects[p],p+1, "", tpvalue);
      } 
    }        
    ComEtcDataToForm(document.form, sheetObj);
}
    
/**
 * combo 초기설정값 정의
 * @param {combo object}	comboObj	combo
 * @param {int}				comboNo		combo index
 * @param {string}			catevalue	Subject Code combo data
 * @param {string}			tpvalue		Detail Code combo data
 * @return
 */
function initCombo (comboObj, comboNo,catevalue, tpvalue) {
	var cnt  = 0 ;
	 
	var cateArray = catevalue.split("|");         
	var tpArray = tpvalue.split("|");
	var test1 = "FF";
	var valueArray;
	var time;
    switch(comboNo) {
    	case 1:
        if(cateArray.length >1){
        	comboObj.RemoveAll();
        	with (comboObj) {
        		InsertItem(cnt++, 'ALL' + '|' +'', ' ');
			    for(i=0 ;i<cateArray.length;i++){
			    	valueArray = cateArray[i].split("--");                
					if(valueArray[0] !=""){			                              
						InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]); 
					}			                            
			    } 
        	}
        }			    	  
        break;
					
        case 2:
        comboObj.RemoveAll();
        with (comboObj) {
			SetColAlign("left");
			SetColWidth("40");
			InsertItem(cnt++, 'ALL' + '|' +'', ' ');	            
			for(i=0 ;i<tpArray.length;i++){
				valueArray = tpArray[i].split("--");			               	
				if(valueArray[0] !=""){			               	             	                         
					InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]); 
				}
			}
			comboObjects[1].Code = document.form.lgs_cost_subj_cd1.value ;
		}
        break;
   	}
			
	comboObjects[1].Code = document.form.lgs_cost_dtl_cd1.value ;
}

var cnt = 0;

/**
 * Subject Code combo 값 변경 시 발생
 * 선택된 코드로 Detail Code 가져오기
 * @param {combo object}	comObj		Subject Code combo
 * @param {string}			text		선택된 값
 * @return
 */
function lgs_cost_subj_cd_OnChange(comObj,text)
{
	
   //document.form.cost_code_sc.value = comObj.Code;
   document.form.lgs_cost_subj_cd.value = comObj.Code;       
   document.form.command_h.value = "S"; 
       doActionIBSheet(sheetObjects[1], document.form, COMMAND01);	  
       
    } 
   
/**
 * Subject Code combo 에서 커서가 옮겨갈때 발생
 * 선택된 코드로 Detail Code 가져오기
 * @param {combo object}	comObj		Subject Code combo
 * @return
 */
function lgs_cost_subj_cd_OnBlur(comObj)
{
    var finded = comObj.FindIndex(comObj.Text() , 0);
    ///ComShowMessage(comObj.Text());
    comObj.Code = finded; 
    
   if(finded!=-1){
    	 doActionIBSheet(sheetObjects[1], document.form, COMMAND01);	 
   }else{        	
    	comObj.Code = "";         	
  }         
} 
 
 /**
  * Detail Code combo 값 변경 시 발생
  * @param {combo object}	comObj		Subject Code combo
  * @param {string}			text		선택된 값
  * @return
  */     
function lgs_cost_dtl_cd_OnChange(comObj,index,text)
{
    //document.form.cost_code_dc.value = comObj.Code; 
   document.form.lgs_cost_dtl_cd.value = comObj.Code;        
   //document.form.command_h.value = "S"; 
}  