/**
 * @class ESD_TRS_0034
 */
function ESD_TRS_0034() {
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

var sheetObjects = new Array();
var sheetCnt = 0;
var Radiocount = 0;

var comboObjects = new Array();
var comboCnt = 0 ;
var tax_no2_onchageFlg = ""; 

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

            case "btng_ok_k":			
               
               /** Validation Check Order 
                * 1. 세금계산서 번호
                * 2. 사업자등록번호
                * 3. 품명
                * 4. 공급가액
                * */
            	
            	if(formObject.electronic.checked == false && formObject.paper.checked == false){
                    errMsg = ComGetMsg("TRS90401" );
                    ComShowMessage(errMsg);
                    formObject.electronic.focus();
                    return false;
                }
                
                if(formObject.tax_no1.value == "" || formObject.tax_no1.value.length != 6){
                    errMsg = ComGetMsg("TRS90013" );
                    errMsg = "세금계산서 번호를 입력하시오.";
                    ComShowMessage(errMsg);
                    formObject.tax_no1.focus();
                    return false;
                }
                
                formObject.tax_no2.value = comboObjects[0].Code;
                
                if(formObject.tax_no2.value == "" || formObject.tax_no2.value == null){
                    errMsg = "Office를 선택하시오.";
                    ComShowMessage(errMsg);
                    return false;
                }
                
                if(formObject.inv_dt.value == ""){
                    errMsg = "발행일자를 입력하시오.";
                    ComShowMessage(errMsg);
                    return false;
                }
                
                var saupjano   = formObject.comp_no1+formObject.comp_no2 + formObject.comp_no3;
                var saupjano1  = formObject.comp_no1.value+formObject.comp_no2.value + formObject.comp_no3.value;						
                
                if(formObject.comp_no1.value == "" || formObject.comp_no2.value == "" || formObject.comp_no3.value == ""){
                    errMsg = "사업자등록번호를 입력하시오.";
                    if(formObject.comp_no1.value == "")        formObject.comp_no1.focus();
                    else if(formObject.comp_no2.value == "")   formObject.comp_no2.focus(); 
                    else if(formObject.comp_no3.value == "")   formObject.comp_no3.focus(); 
                    
                    ComShowMessage(errMsg);
                    return false;
                }
                
                if(!check_busino(saupjano1)){
                        errMsg = ComGetMsg("TRS90018" );
                        ComShowMessage(errMsg);	
                        return false;			
                }
                
                                    
                
                if(formObject.vat_amt_hdr.value != formObject.vat_amt.value){
                    errMsg = ComGetMsg("TRS90013" );
                    ComShowMessage(errMsg);
                    return false;
                } 
                
                if(formObject.total_amt_hdr.value != formObject.total_amt.value){
                    errMsg = ComGetMsg("TRS90014" );
                    ComShowMessage(errMsg);
                    return false;
                }
                
                if(ComIsNull(ComGetObjValue(formObject.finance_flg))){
                        errMsg = ComGetMsg("TRS90016" );
                        ComShowMessage(errMsg);
                        return false;			
                }
                
                if(ComIsNull(ComGetObjValue(formObject.tax_type))){
                        errMsg = ComGetMsg("TRS90017" );
                        ComShowMessage(errMsg);	
                        return false;			
                }										
                
                if(sheetObjects[0].RowCount<1){
                        errMsg = ComGetMsg("TRS90019" );
                        ComShowMessage(errMsg);
                        return false;
                }
                
                if(sheetObjects[0].RowCount>0){
                        for(var i=0;i<sheetObjects[0].RowCount;i++){
                                if(sheetObjects[0].CellValue(i+1,3)==""){
                                    errMsg = ComGetMsg("TRS90020" );
                                    ComShowMessage(errMsg);
                                    return false;
                                }
                        }							
                }

                /* TAX CODE 생성 */
                document.form.f_cmd.value = MULTI02; 
                doActionIBSheet1(sheetObjects[1], document.form, IBSEARCH);
                if(document.form.tax_code.value == "" || document.form.tax_code.value == "undefined")
                {
                    errMsg = ComGetMsg("TRS90047" );
                    ComShowMessage(errMsg);
                    return false;
                }

                //세금계산서 일련번호 생성.
                if(formObject.tax_no3.value == null || formObject.tax_no3.value == "")    searchTaxNo3(comboObjects[0]);

                setOpenerInsertData();

                errMsg = ComGetMsg("TRS90021" );
                ComShowMessage(errMsg);
            
                window.close();
                
                break;

            case "btng_cancel_k":					
                window.close();
                break;

            case "btng_new_k":					
                comboObjects[0].Code                = "";
                formObject.tax_no3.value            = "";
                formObject.finance_flg[0].checked   = false;
                formObject.finance_flg[1].checked   = false;
                formObject.tax_type[0].checked      = false; 
                formObject.tax_type[1].checked      = false;
                formObject.comp_no1.value           = "";
                formObject.comp_no2.value           = "";
                formObject.comp_no3.value           = "";
                formObject.inv_dt.value             = "";			
                sheetObjects[0].RemoveAll();					
                break;

            case "btng_add_k":
                doActionIBSheet(sheetObject, formObject, IBINSERT);
                break;

            case "btng_delete_k":
                doActionIBSheet(sheetObject, formObject, IBDELETE);
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

    //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
    //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
     
    for(p=0;p< comboObjects.length;p++){
        initCombo (comboObjects[p], p+1, '');
    }   			
    
    ComEnableObject(document.form.vndr_seq_hdr, false);
    ComEnableObject(document.form.vat_amt_hdr, false); 
    ComEnableObject(document.form.total_amt_hdr, false);
    ComEnableObject(document.form.page, false);
    ////jsk ComEnableObject(document.form.tax_no1, false); 
    ComEnableObject(document.form.tax_no3, false);
    ComEnableObject(document.form.volume, false);
    ComEnableObject(document.form.ho, false); 
    ComEnableObject(document.form.vndr_nm, false);
    ComEnableObject(document.form.bzct_nm, false);	
    ComEnableObject(document.form.vndr_addr, false);
    ComEnableObject(document.form.bzct_nm, false);	
    ComEnableObject(document.form.bztp_nm, false);	
    ComEnableObject(document.form.ceo_nm, false);
    ComEnableObject(document.form.vndr_seq, false);
    ComEnableObject(document.form.net_amt, false);
    ComEnableObject(document.form.vat_amt, false); 
    ComEnableObject(document.form.total_amt, false);	
    
    insertValue();					
            
    //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			         

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
                // 높이 설정
                style.height = GetSheetHeight(8);
                //전체 너비 설정
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
                 InitColumnInfo(7, 1, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, false, false, true, false,false)

                var HeadTitle1 = " |STS|순번|품명|공급가액|세액|합계" ;

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtCheckBox,   30,    	daCenter,  		false,  	"sel",     	false,          "",     dfNone,   		0,     	true,       true);
                InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    	daCenter,  		false,    "",     	false,          "",     dfNone,   		0,     	false,      true);
                InitDataProperty(0, cnt++ , dtDataSeq,		30,			daCenter,			true,    	"",				false,					"",			dfNone,				0,			true,				true);
                InitDataProperty(0, cnt++ , dtData,				200,		daLeft,		    true,    	"",				false,					"",			dfNone,				0,			true,				true);
                InitDataProperty(0, cnt++ , dtData,				150,		daRight,			true,    	"",				false,					"",			dfInteger,			0,			true,				true);
                InitDataProperty(0, cnt++ , dtData,				150,		daRight,			true,    	"",				false,					"",			dfInteger,			0,			true,				true);
                InitDataProperty(0, cnt++ , dtData,				100,		daRight,			true,    	"",				false,	 "|4|+|5|",			dfInteger,			0,			false,			false);																							
                
           }
            break;
             
        case 2:      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = GetSheetHeight(8);
                //전체 너비 설정
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
                                    InitColumnInfo(1, 1, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle1 = "순번" ;

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]										
                                    InitDataProperty(0, cnt++ , dtData,				150,		daRight,			true,    	"",				false,					"",			dfNone,			0,			false,				false);
                                    

           }
            break;                 
    }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH:      //조회
            formObj.f_cmd.value = SEARCHLIST;                  
            sheetObj.DoRowSearch("ESD_TRS_0034GS.do", TrsFrmQryString(formObj));
//			sheetObj.GetSearchXml("ESD_TRS_0031GS.do", TrsFrmQryString(formObj));	//ALPS ETCDATA 사용
            break; 
      
       case IBINSERT:      // 입력 
                if(sheetObj.RowCount == 4){
                    return;
                }else{
                    sheetObj.DataInsert();
            }
            
            ////JSK controlSheetColumnTax();
            
            break;

       case IBCOPYROW:        //행 복사
          sheetObj.DataCopy();
          break;
          
       case IBDELETE:
          var chkRows = sheetObj.FindCheckedRow("sel") ;
          var arrRow = chkRows.split("|");
          for (idx=arrRow.length-2; idx >= 0; idx--){ 
            sheetObj.RowDelete (arrRow[idx] , false); 
          }

        var net_amt  = 0;
        var vat_amt  = 0;
        var total_amt= 0;
        
        for(var i = 0;i<sheetObjects[0].RowCount;i++){
            net_amt = parseFloat(sheetObjects[0].CellValue(i+1,4)*100)+parseFloat(net_amt);
            vat_amt = parseFloat(sheetObjects[0].CellValue(i+1,5)*100)+parseFloat(vat_amt);
            total_amt = parseFloat(sheetObjects[0].CellValue(i+1,6)*100)+parseFloat(total_amt);     					
        }
                    
        document.form.net_amt.value 			= net_amt/100;
        document.form.vat_amt.value 			= vat_amt/100;
        document.form.total_amt.value 		= total_amt/100;                
    
       break;
    }
}
 
// Sheet관련 프로세스 처리
function doActionIBSheet1(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH:      //조회               	                 
            sheetObj.DoSearch4Post("ESD_TRS_0034_037GS.do", TrsFrmQryString(formObj));
            break;
    }
}     

function insertValue(){
    var opener_obj = window.dialogArguments;	
    //var opener_obj = opener;	
    var opener_sheet_obj =  opener_obj.document.sheet1;			
    
    document.form.vndr_seq.value= opener_obj.document.form.wo_vndr_seq.value;
    document.form.wo_vndr_seq.value= opener_obj.document.form.wo_vndr_seq.value;
    document.form.vndr_seq_hdr.value= opener_obj.document.form.vndr_seq.value;

    if( opener_obj.document.form.type.value == "ELECTRONIC" ){
    	document.form.electronic.checked = true;
    	
    }else if (opener_obj.document.form.type.value == "PAPER" ){
    	document.form.paper.checked = true;
    	
    }
    
    var k = 0;
    var vat_amt = 0; 
    var total_amt = 0;
    var checkRow = opener_sheet_obj.FindCheckedRow(1);
    var checkRowArray = checkRow.split("|");
    
    for(k=0;k<checkRowArray.length-1;k++){ 					  
            vat_amt		=	vat_amt+parseFloat(opener_sheet_obj.CellValue(checkRowArray[k], "inv_vat_amt"));						
            total_amt	=	total_amt+parseFloat(opener_sheet_obj.CellValue(checkRowArray[k], "inv_ttl_amt"));						
    }
    document.form.vat_amt_hdr.value= vat_amt;
    document.form.total_amt_hdr.value= total_amt;			

    if(total_amt-vat_amt>0){
            document.form.finance_flg[0].checked = true;						
            document.form.finance_flg[1].disabled = true;						
    }else if(total_amt -vat_amt <=0){
            document.form.finance_flg[0].disabled = true;		
            document.form.finance_flg[1].checked = true;					
    }
    
    if(vat_amt==0){
            document.form.tax_type[0].checked = true;						
            document.form.tax_type[1].disabled = true;	
    }else if(total_amt>0){											
            document.form.tax_type[1].checked = true;					
            document.form.tax_type[0].disabled = true;						
    }
}

function insertValueEvi(){
    var opener_obj = window.dialogArguments;	
    //var opener_obj = opener;	
    var opener_sheet_obj =  opener_obj.document.sheet1;
    var k=0;			
    
    if(opener_obj.document.form.eviInputFlg.value=="Y"){								
            
        tax_no2_onchageFlg  = "Y";
        
        /* OPENER에 저장된 세금계산서 번호 나누어 뿌려주기 */
        document.form.tax_no1.value      = opener_obj.document.form.evi_tax_no.value.substring(0 , 6 );
        comboObjects[0].Code             = opener_obj.document.form.evi_tax_no.value.substring(6 , 11);
        document.form.tax_no3.value      = opener_obj.document.form.evi_tax_no.value.substring(11, 15);
                    
        if(opener_obj.document.form.tax_naid_flg.value == "Y"){
            document.form.tax_naid_flg[0].checked=true;
            document.form.tax_naid_flg[1].checked=false;
        }else if(opener_obj.document.form.tax_naid_flg.value == "N"){
            document.form.tax_naid_flg[1].checked=true;
            document.form.tax_naid_flg[0].checked=false;
        }
        
        if(opener_obj.document.form.finance_flg.value == "Y"){
            document.form.finance_flg[0].checked=true;
            document.form.finance_flg[1].checked=false;
        }else if(opener_obj.document.form.finance_flg.value == "N"){
            document.form.finance_flg[1].checked=true;
            document.form.finance_flg[0].checked=false;
        }
        
        if(opener_obj.document.form.fa_flg.value == "Y"){
            document.form.fa_flg[0].checked=true;
            document.form.fa_flg[1].checked=false;
        }else if(opener_obj.document.form.fa_flg.value == "N"){
            document.form.fa_flg[1].checked=true;
            document.form.fa_flg[0].checked=false;
        }
        
        if(opener_obj.document.form.tax_type.value == "0"){
            document.form.tax_type[0].checked=true;
            document.form.tax_type[1].checked=false;
        }else if(opener_obj.document.form.tax_type.value == "10"){
            document.form.tax_type[1].checked=true;
            document.form.tax_type[0].checked=false;
        }
                                                                                
        if(opener_obj.document.form.tax_nsl_flg.value == "Y"){
            document.form.tax_nsl_flg[0].checked=true;
            document.form.tax_nsl_flg[1].checked=false;
        }else if(opener_obj.document.form.tax_nsl_flg.value == "N"){
            document.form.tax_nsl_flg[1].checked=true;
            document.form.tax_nsl_flg[0].checked=false;
        }
        
        
        document.form.comp_no1.value = opener_obj.document.form.evi_comp_no.value.substring(0,3);
        document.form.comp_no2.value = opener_obj.document.form.evi_comp_no.value.substring(3,5);
        document.form.comp_no3.value = opener_obj.document.form.evi_comp_no.value.substring(5,10);
        
        document.form.inv_dt.value = opener_obj.document.form.evi_inv_dt.value;						
        document.form.net_amt.value = opener_obj.document.form.evi_total_net_amt.value;						
        document.form.vat_amt.value = opener_obj.document.form.evi_total_tax_amt.value;	
        
        for(var i=0;i<4;i++){ 
            if(eval("opener_obj.document.form.evi_ctnt"+(k+1)).value != "" || eval("opener_obj.document.form.evi_ctnt"+(k+2)).value != "" || eval("opener_obj.document.form.evi_ctnt"+(k+3)).value != ""){
                sheetObjects[0].DataInsert(-1);
                k++;
                sheetObjects[0].CellValue(i+1,3) = eval("opener_obj.document.form.evi_ctnt"+k).value;
                k++;
                sheetObjects[0].CellValue(i+1,4) = eval("opener_obj.document.form.evi_ctnt"+k).value; 
                k++;
                sheetObjects[0].CellValue(i+1,5) = eval("opener_obj.document.form.evi_ctnt"+k).value;
            }
        }			
    }
}
    
function sheet1_OnChange(sheetObj , Row, Col, Value){
    var net_amt       = 0;
    var vat_amt       = 0;
    var total_amt     = 0;
    var netArr        = new Array();
    var vatArr        = new Array();
    var minVatArr     = new Array();
    var maxVatArr     = new Array();
    
    var taxType       = document.form[0]
    
    if(Col == 4){
        /*** TAX TYPE : '과세' 일 경우만 10% 부가세 자동계산 처리 ***/
        if(!checkTaxRadioValue())    sheetObj.CellValue2(Row, 5) = Math.round((parseFloat(sheetObj.CellValue(Row,4)*100)/10)/100);
    }	

    if(Col == 5){
        for(var i=0;i<sheetObj.RowCount;i++){
            netArr[i] = sheetObj.CellValue(i+1, 4);
            vatArr[i] = Math.round((parseFloat(sheetObj.CellValue(i+1,4)*100)/10)/100);
            maxVatArr[i] = Math.round((parseFloat(sheetObj.CellValue(i+1,4)*100)/10)/100)+10;
            minVatArr[i] = Math.round((parseFloat(sheetObj.CellValue(i+1,4)*100)/10)/100)-10;							
        }								
    
        if(maxVatArr[Row-1]<sheetObj.CellValue(Row, 5) || minVatArr[Row-1]>sheetObj.CellValue(Row, 5)){
            errMsg = ComGetMsg("TRS90198" );
            ComShowMessage(errMsg); 			
            sheetObj.CellValue2(Row, 5) = Math.round((parseFloat(sheetObj.CellValue(Row,4)*100)/10)/100);
        }
    }				

    for(var i = 0;i<sheetObj.RowCount;i++){
        net_amt = parseFloat(sheetObj.CellValue(i+1,4)*100)+parseFloat(net_amt);
        vat_amt = parseFloat(sheetObj.CellValue(i+1,5)*100)+parseFloat(vat_amt);
        total_amt = parseFloat(sheetObj.CellValue(i+1,6)*100)+parseFloat(total_amt);     					
    }

    document.form.net_amt.value 			= net_amt/100;
    document.form.vat_amt.value 			= vat_amt/100;
    document.form.total_amt.value 		= total_amt/100; 
       
}		
    
function sheet1_OnSearchEnd(sheetObj,errMsg){
    if(errMsg!=null){
        ComShowMessage(errMsg);
    }
    
    var wkplc_nmstring= sheetObj.EtcData("wkplc_nmstring");
    var vndr_nm 			= sheetObj.EtcData("vndr_nm");
    var bzct_nm 			= sheetObj.EtcData("bzct_nm");
    var bztp_nm 			= sheetObj.EtcData("bztp_nm");
    var vndr_addr 		= sheetObj.EtcData("vndr_addr");
    var ceo_nm 				= sheetObj.EtcData("ceo_nm");  
    var rgst_no 			= sheetObj.EtcData("rgst_no");
            
                     
    document.form.vndr_nm.value 			= vndr_nm;
    document.form.bzct_nm.value 			= bzct_nm;
    document.form.bztp_nm.value 			= bztp_nm; 
    document.form.vndr_addr.value 		= vndr_addr; 
    document.form.ceo_nm.value 				= ceo_nm;    
    document.form.comp_no1.value 			= rgst_no.substring(0,3); 
    document.form.comp_no2.value			= rgst_no.substring(3,5); 
    document.form.comp_no3.value 			= rgst_no.substring(5,10); 
    
                        
    for(p=0;p< comboObjects.length;p++){
        initCombo (comboObjects[p],p+1, wkplc_nmstring);
    } 
    
    /*** SHEET1 ONSEARCH END 이후 'TAX' 컬럼 속성 설정 ***/
    controlSheetColumnTax();
    
}
 
function sheet2_OnSearchEnd(sheetObj,errMsg){
    if(errMsg!=null){
        ComShowMessage(errMsg);
    }
    
    var gsFlg= sheetObj.EtcData("gsFlg");
    if(gsFlg=="MULTI01"){		
        var tax_no3= sheetObj.EtcData("tax_no3");	    
                     
        document.form.tax_no3.value 			= tax_no3;
    }else if(gsFlg=="MULTI02"){
        var tax_code= sheetObj.EtcData("tax_code");	  
                     
        document.form.tax_code.value 			= tax_code;	 	           	
    }
}     
    
function initCombo (comboObj, comboNo, wkplc_nmstring){
    var cnt  = 0 ;
    var wkplcNmArray = wkplc_nmstring.split("|");	

     switch(comboNo){
        case 1:             
            comboObj.RemoveAll();  
             
           with (comboObj){                	
                       SetColAlign("left");
                       SetColWidth("60");			    	       
                     
                       for(i=0 ;i<wkplcNmArray.length;i++){             
                       InsertItem(cnt++, wkplcNmArray[i], wkplcNmArray[i]);
                     } 	
                    }
           break;                                                  
        }
}
 
function searchTaxNo3(comObj)
{
   document.form.tax_no2.value = comObj.Code;
   if(comObj.Code != "" || tax_no2_onchageFlg != "Y"){
       document.form.f_cmd.value = MULTI01; 
       doActionIBSheet1(sheetObjects[1], document.form, IBSEARCH); 
   }
}          

function setComboObject(combo_obj){
    comboObjects[comboCnt++] = combo_obj;
}
 
function getElementValue(formObject, eleTp, eleNm) {

    var element;
    var numOfEle = formObject.elements.length;
    for (var i = 0; i < numOfEle; i++){
        if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm){
            if (formObject.elements[i].checked == true){ 
                var ele_value = formObject.elements[i].value;
                break;
            }			
        }
    }

    return ele_value;
}     

function isNum(obj){
    //숫자만..
    if (!ComIsNumber(obj)){
        obj.value = '';
    }
}

function isNum1(obj){
    //숫자만..
    if (!isNumDash(obj)){
        obj.value = '';
    }
}		

function isDate1(obj){
    //숫자만..
    if (!ComIsDate(obj)){
        obj.value = '';
    }
}		     	 

function setOpenerInsertData(){
    var opener_obj = window.dialogArguments;	
    //var opener_obj = opener;	
    var opener_sheet_obj =  opener_obj.document.sheet1;
    var k=0;				
    
    opener_obj.document.form.tax_naid_flg.value = getElementValue(document.form, 'radio', 'tax_naid_flg');
    opener_obj.document.form.finance_flg.value = getElementValue(document.form, 'radio', 'finance_flg');
    opener_obj.document.form.fa_flg.value = getElementValue(document.form, 'radio', 'fa_flg');
    opener_obj.document.form.tax_type.value = getElementValue(document.form, 'radio', 'tax_type');
    opener_obj.document.form.tax_nsl_flg.value = getElementValue(document.form, 'radio', 'tax_nsl_flg');
    
    if( document.form.electronic.checked == true )
    	opener_obj.document.form.type.value = 'ELECTRONIC';
    else if (document.form.paper.checked == true )
    	opener_obj.document.form.type.value = 'PAPER';
    
    opener_obj.document.form.evi_inv_dt.value = document.form.inv_dt.value;
    opener_obj.document.form.evi_comp_no.value = document.form.comp_no1.value+ document.form.comp_no2.value+ document.form.comp_no3.value;
    opener_obj.document.form.evi_total_net_amt.value = document.form.net_amt.value;
    
    //--jsk opener_obj.document.form.evi_tax_no2.value = document.form.tax_no2.value;

    opener_obj.document.form.evi_tax_no2.value = comboObjects[0].Code;
    opener_obj.document.form.evi_total_tax_amt.value = document.form.vat_amt.value;
    
    for(var i=0;i<sheetObjects[0].RowCount;i++){
        k++;
        eval("opener_obj.document.form.evi_ctnt"+ k).value  = sheetObjects[0].CellValue(i+1,3);
        k++;
        eval("opener_obj.document.form.evi_ctnt"+ k).value  = sheetObjects[0].CellValue(i+1,4);
        k++;
        eval("opener_obj.document.form.evi_ctnt"+ k).value  = sheetObjects[0].CellValue(i+1,5);
    }
    
    opener_obj.document.form.evi_tax_no.value = document.form.tax_no1.value+comboObjects[0].Code+document.form.tax_no3.value;
    opener_obj.document.form.evi_tax_code.value = document.form.tax_code.value;
    opener_obj.document.form.eviInputFlg.value = "Y";

    resetTaxFlag(opener_obj);
    var checkList  = opener_obj.sheetObjects[0].FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    for(var i=0; i<checkArray.length-1; i++){
        opener_obj.sheetObjects[0].CellValue2(checkArray[i], 'taxcheck') = 1;
    }

}

function resetTaxFlag(opener_obj){

    var checkList  = opener_obj.sheetObjects[0].FindCheckedRow('taxcheck');
    var checkArray = checkList.split('|');

    for(var i=0; i<checkArray.length-1; i++){
        opener_obj.sheetObjects[0].CellValue2(checkArray[i], 'taxcheck') = '0';
    }
}



function check_busino(vencod) {
    var sum = 0;
    var getlist =new Array(10);
    var chkvalue =new Array("1","3","7","1","3","7","1","3","5");
    for(var i=0; i<10; i++) { getlist[i] = vencod.substring(i, i+1); }
    for(var i=0; i<9; i++) { sum += getlist[i]*chkvalue[i]; }
    sum = sum + parseInt((getlist[8]*5)/10);
    sidliy = sum % 10;
    sidchk = 0;
    if(sidliy != 0) { sidchk = 10 - sidliy; }
    else { sidchk = 0; }
    if(sidchk != getlist[9]) { return false; }
    return true;
}		

function controlSheetColumnTax(){

    /*** TAX TYPE : '영세' --> sheetObject.세액 Column disabled 처리 ***/
    if( checkTaxRadioValue() ){
        //for(var i=0; i<sheetObjects[0].RowCount+1; i++){
            //sheetObjects[1].InitCellProperty(i, 5, dtInteger, daRight);
        sheetObjects[0].InitDataProperty(0, 5, dtData, 150, daRight,	true, "", false, "", dfInteger, 0, false, false);
        //}
    }
}
 
function checkTaxRadioValue(){
     var taxType    = "";
     if (document.form.tax_type[0].checked == true)
         taxType    = true;
     else
         taxType    = false;
         
     return  taxType;
}

function BlurDate(obj){
   if (obj.value == "")
   {
	   return;
   }
   if ( !ComIsDate(obj) ){
		errMsg = ComGetMsg("COM12179");
		ComShowMessage(errMsg);
		obj.focus();
		return ;
	}
}
/* 계산서 타입 설정 체크 */
function checkType(){
	if (document.form.electronic.checked == true && document.form.paper.checked == true){
		errMsg = ComGetMsg("TRS90402");
		ComShowMessage(errMsg);
		document.form.electronic.checked = false;
		document.form.paper.checked = false;
		
	}

	
}
