/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0036.js
*@FileTitle : TRS invoice CSR Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.26
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2009.02.23 최 선
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2011.12.26 최 선        1.1 [CHM-201115241] [TRS] Hold invoice 관련 메세지 추가요청
* 2014.11.26 최종혁 김현화[CHM-201432901]Split 01-비용지급 전표 결재건
=========================================================*/

/**
 * @class ESD_TRS_0036
 */
function ESD_TRS_0036() {
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
         var sheetObject2 = sheetObjects[2];

         /*******************************************************/
         var formObject = document.form; 
          
         var rdObject = rdObjects[0];

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");


			switch(srcName) {
				
				case "btn_close":
					window.close();
	        break;

				case "btng_print":					
					rdObject.PrintDialog();
					break;

//				case "btng_approvalrequest":		
//				    if ( opener.document.form.csr_no.value != "")
//				    {
//                        errMsg = ComGetMsg("TRS90046" );
//                        ComShowMessage(errMsg);
//				        return false;
//				    }
				    
//					if(!confirm('Are you sure to proceed for Approval Request?')) return false;

					opener.approvalrequest();
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
       	rdOpen();	
    }

// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

               	formObj.f_cmd.value = SEARCHLIST;                  
                sheetObj.DoSearch4Post("ESD_TRS_0032GS.do", TrsFrmQryString(formObj));
                break; 
                
            case IBSAVE:        //저장

                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESD_TRS_0032GS.do", TrsFrmQryString(formObj));               
                break;
                
           case IBCOPYROW:        //행 복사
              sheetObj.DataCopy();
              break

        }
    }
  
	function rdOpen(){		
		
		var sXml = "";		
		var i=0;
		var j=0;

		var opener_obj = opener;	
		var opener_sheet_obj1 =  opener_obj.document.sheet2;
		var opener_sheet_obj2 =  opener_obj.document.sheet3; 
		
		var fromObj = new Array();
		var rdObj = new Array();
					
          fromObj[0] = document.form;                            // RD 로 보내기 위해 배열로담는다
          rdObj[0] = opener_sheet_obj1;     
          rdObj[1] = opener_sheet_obj2;
         
		sXml = "<?xml version='1.0' ?><SHEET>";
		
		sheetCnt = 1;
		for(i=0;i<2;i++){
				sheetCnt = i+1;
				if(rdObj[i].RowCount ==0){
						sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
 
							for(j=0;j<=rdObj[i].LastCol;j++){
									sXml +="<TD></TD>";
						}
						sXml +="</TR></DATA></SHEET"+sheetCnt+">";
				}else{
						sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt); 					
				}			
		}
		sXml +="</SHEET>"; 

  if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
  {
      errMsg = ComGetMsg("TRS90001");
      ComShowMessage(errMsg);
      return;
  }
		rdObjects[0].AutoAdjust = true;
		rdObjects[0].HideToolbar();
		rdObjects[0].HideStatusbar();
		rdObjects[0].ViewShowMode(2);
				
		rdObjects[0].setbackgroundcolor(255,255,255);
		rdObjects[0].SetPageLineColor(255,255,255);			
					
		rdObjects[0].SetRData(sXml);
		rdObjects[0].FileOpen(RD_path+'apps/alps/esd/trs/invoicemanage/csrissuetranferslip/report/ESD_TRS_0036.mrd', RDServer);
	}