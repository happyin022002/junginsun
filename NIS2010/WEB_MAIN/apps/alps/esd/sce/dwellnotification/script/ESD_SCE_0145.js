/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESD_SCE_0145.js
 *@FileTitle : Dwell E-mailing History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.07.26
 *@LastModifier : 손은주
 *@LastVersion : 1.0
 * 2011.07.26 손은주
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    var sheetObj = sheetObjects[0];
    var formObj = document.form;

	try {
	    var srcName = window.event.srcElement.getAttribute("name");
        
	    switch(srcName) {
	        case "btn_retrieve":
	           doActionIBSheet(sheetObj,formObj,IBSEARCH);
	           break;
	        case "btn_close":
	        	self.close();
		        break;
		      
	    }
	    
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
		} else {
			ComShowMessage(e) ;
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
    var formObj = document.form;
	var sheetObj = sheetObjects[0];
		doActionIBSheet(sheetObj,formObj,COMMAND01);
	if( validateForm(formObj) ) {
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
}
 
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/

function initSheet(sheetObj,sheetNo) {
    var cnt = 0;

	switch(sheetNo) {
	    case 1:	  
	       with (sheetObj) {
              style.height = GetSheetHeight(10);
              SheetWidth = mainTable.clientWidth;       
              
              if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

              MergeSheet = msHeaderOnly;
              Editable = true;
              InitRowInfo( 1, 1, 20, 20);
              
              InitColumnInfo(5, 0, 0, true);
              InitHeadMode(true, true, false, true, false,false);              
              
              var HeadTitle0 = "SEQ|E-Mail|E-Mail Source|Send Date|Status|" ;
			  
              InitHeadRow(0, HeadTitle0, true);
              
              InitDataProperty(0, cnt++ , dtDataSeq,  	70,		daCenter,	true,	"seq",			false,		  "",	   dfNone,   	0,	 		false ,	   false );
              InitDataProperty(0, cnt++ , dtData,		200,	daCenter,	true,	"subsc_eml",	false,		  "",	   dfNone,   	0,	 		false,	   false );
              InitDataProperty(0, cnt++ , dtData,		200,	daCenter,	true,	"eml_fm_src_nm",	false,		  "",	   dfNone,   	0,	 		false,	   false );
			  InitDataProperty(0, cnt++ , dtData,	   	150,	daCenter,	true,	"eml_snd_dt",	false,		  "",	   dfNone,	 	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,	   	100,	daCenter,	true,	"eml_sts",		false,		  "",	   dfNone,   	0,	 		false,	   false);
			  
			 
	       }
	       break;
	}
}
 
function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     isSearch = true;
     
     switch(sAction) {
         case IBSEARCH:     
            if(validateForm(formObj)){
                formObj.f_cmd.value = SEARCH03;
                sheetObj.DoSearch4Post("ESD_SCE_0145GS.do", SceFrmQryString(formObj));
            } else {
                isSearch = false;
            }
         break;
         
         case COMMAND01:     
                 formObj.f_cmd.value = SEARCH04;
                 var sXml = sheetObj.GetSaveXml("ESD_SCE_0145GS.do", FormQueryString(formObj));
                 document.form.frm_rvis_cntr_cust_tp_cd.value = ComGetEtcData(sXml, "rvis_cntr_cust_tp_cd");
          break;
     }
}
 
function validateForm(formObj){
    var result = true ;
    return result;
}
 

 
function onEnterKey(textname) {
	if (event.keyCode == 13) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if( validateForm(formObj) ) {
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
	}
}

