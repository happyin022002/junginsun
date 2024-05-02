/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0206 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0206() {
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

// ??????

var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

var comboObjects = new Array();
var comboCnt = 0 ; 

var rdObjects = new Array();
var rdCnt = 0;

/* ???????? ?? ???? ??????  ?? */
document.onclick = processButtonClick;

/* ?? ???? ???? ????? ?????? ?????? */
    function processButtonClick(){
         /***** ?? ??? 2? ??? ??? ?? ???? ???? ??? *****/
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
     * IBSheet Object? ??? ??
     * ?? ?? ???? ????? ??? ?? ? ??? ?? ????? ??? ? ??
     * ??? ?? ??? ??
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet ?? ?? ? ???
     * body ??? onLoad ?????? ??
     * ??? ?????? ??? ?? ????? ?? ??? ????
     */
    function loadPage() {
       	rdOpen();	
		rdObjects[0].PrintDialog();

		//html컨트롤 이벤트초기화
		initControl();
    }

	/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {
	    //Axon ??? ??1. ???catch
	    /*
	    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
	    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
	    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
	    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
	    */
	}

	//Axon ??? ??2. ??????? --- start
	/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
	function engnum_keypress() {
	    //???? ????
	//            ComKeyOnlyAlphabet('uppernum');
	}

	/**
	 * BKG Creation?? manual? ???? ??? ????. <br>
	 **/
	function manual_click() {
	    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
	//            form.boo_bkg_no.readOnly =!form.manual.checked;
	}

	/**
	 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
	 **/
	function bkgno_keyup() {
	    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
	    /*
	    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
		form.boo_bl_no.value = "";
	    else
		form.boo_bl_no.value = form.hdn_boo_bl_no.value;
		*/
	}

	/**
	 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_blur(){
	    //입력Validation 확인하기
	//            return ComChkObjValid(event.srcElement);
	}

	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
	 **/
	function obj_focus(){
	    //?????? ???
	//            ComClearSeparator(event.srcElement);
	}

	/**
	 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
	 **/
	function obj_keypress(){
	    //???????
	//            ComKeyOnlyNumber(event.srcElement);
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- end


  // Sheet?? ???? ??
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //??

               	formObj.f_cmd.value = SEARCHLIST;                  
                sheetObj.DoSearch4Post("ESD_TRS_0032GS.do", TrsFrmQryString(formObj));
                break; 
                
            case IBSAVE:        //??

                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESD_TRS_0032GS.do", TrsFrmQryString(formObj));               
                break;
                
           case IBCOPYROW:        //? ??
              sheetObj.DataCopy();
              break

        }
    }
  
	function rdOpen(){		
		
		var sXml = "";		
		var i=0;
		var j=0; 
		//var opener_obj = window.dialogArguments;	
		var opener_obj = opener;	
		var opener_sheet_obj1 =  opener_obj.document.sheet1;
//		var opener_sheet_obj2 =  opener_obj.document.sheet2; 
		
		var fromObj = new Array();
		var rdObj = new Array();
					
          fromObj[0] = document.form;                            // RD ? ??? ?? ??????
          rdObj[0] = opener_sheet_obj1;     
//          rdObj[1] = opener_sheet_obj2;
         
		sXml = "<?xml version='1.0' ?><SHEET>";
		
		sheetCnt = 1;
		//i = ?? ???,
		for(i=0;i<1;i++){
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

		var inq_option ="";

	
		if ( opener_obj.document.form.chk_cyterm.checked) inq_option = inq_option + " CY BKG Term /";
		if ( opener_obj.document.form.chk_fr.checked	) inq_option = inq_option + " TRO Frustrated /";
		if ( opener_obj.document.form.chk_mty.checked	) inq_option = inq_option + " Incl. MTY /";

		inq_option = inq_option.substring(0, inq_option.length-1);
			

		sXml +="<ETC><OFC>"+opener_obj.document.form.input_office.value+"</OFC>" + "<OPTION>"+inq_option+"</OPTION>" ;  
		if( opener_obj.document.form.so_fmdt.value.length ==6 ) sXml +="<WO_DATE>"+opener_obj.document.form.so_fmdt.value+"</WO_DATE>"; 
			else sXml +="<WO_DATE>"+opener_obj.document.form.so_fmdt.value+"~"+opener_obj.document.form.so_todt.value+"</WO_DATE>"; 
		sXml +="</ETC>"
		sXml +="</SHEET>"; 

/*
sXml = "<?xml version='1.0' ?><SHEET>"
	+"<SHEET1><DATA TOTAL='0'><TR><TD   ><![CDATA[HAMBB]]></TD>  <TD   ><![CDATA[I]]></TD>  <TD   ><![CDATA[D]]></TD>  <TD   ><![CDATA[Confirmed]]></TD></TR>"
	+"<TR><TD   ><![CDATA[GGGGG]]></TD>  <TD   ><![CDATA[IB]]></TD>  <TD   ><![CDATA[DD]]></TD>  <TD   ><![CDATA[Confirmed]]></TD></TR>"
	+"<TR><TD   ><![CDATA[CCCCC]]></TD>  <TD   ><![CDATA[IA]]></TD>  <TD   ><![CDATA[ED]]></TD>  <TD   ><![CDATA[Confirmed]]></TD></TR>"
	+"</DATA></SHEET1></SHEET>"
*/



  if ( rdObj[0].RowCount  == "0")                     // RD ? ?? sheet ? ???? ??? Error
  {
      errMsg = 'No data found.';
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
		rdObjects[0].FileOpen(RD_path+'apps/alps/esd/trs/report/chanalysis/report/esd_trs_0101.mrd', RDServer);
	}