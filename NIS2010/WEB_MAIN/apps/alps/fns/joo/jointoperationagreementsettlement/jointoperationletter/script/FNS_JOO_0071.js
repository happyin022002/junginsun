/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0060.js
*@FileTitle : MCS Letter Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.07 장강철
* 1.0 Creation
=========================================================*/
var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";

document.onclick = processButtonClick;

function processButtonClick(){
    var formObject = document.form; 
    var rdObject = rdObjects[0];
}

function loadPage() {
    //RD
    initRdConfig(rdObjects[0]);
    rdOpen(rdObjects[0], document.form);
}

function initRdConfig(rdObject){
    var Rdviewer = rdObject ;
    
    Rdviewer.AutoAdjust = true;
    Rdviewer.ViewShowMode(0);

    Rdviewer.setbackgroundcolor(128,128,128);
    Rdviewer.SetPageLineColor(128,128,128);
}

function rdOpen(rdObject,formObject){
    var Rdviewer = rdObject ;

    var rdParam = '/rp ['+queryStr+']';

    // 열고자 하는 RD 파일을 지정한다.
    Rdviewer.FileOpen(RD_path+'alps/fns/joo/jointoperationagreementsettlement/jointoperationletter/report/FNS_JOO_0071.mrd', RDServer + rdParam);
    
}
