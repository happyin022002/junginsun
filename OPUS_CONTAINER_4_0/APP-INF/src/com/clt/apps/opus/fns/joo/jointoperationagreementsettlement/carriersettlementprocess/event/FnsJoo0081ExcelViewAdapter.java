/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_JOO_0081HTMLAction.java
*@FileTitle : Loading Port Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.25 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.joo.jointoperationagreementsettlement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JointOperationAgreementSettlementSC로 실행요청<br>
 * - JointOperationAgreementSettlementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author jang kang cheol
 * @see JointOperationAgreementSettlementEvent 참조
 * @since J2EE 1.6
 */

public class FnsJoo0081ExcelViewAdapter extends ViewAdapter {

    @Override
    protected String makeDataTag(List<AbstractValueObject> arg0, String arg1) {
        return null;
    }

    @Override
    protected String makeDataTag(DBRowSet dbrowset, String s) {
 
        return null;
    }
    /**
     * 
     * Main Method Excel자료 만들기 <br>
     *
     * @param  HttpServletRequest request
     * @param  HttpServletResponse response
     * @return String
     * @author jang kang cheol
     */
    public String makeXML(HttpServletRequest request, HttpServletResponse response)  
    {  
         
        response.reset() ;
        response.setHeader("Content-Type"       , "application/vnd.ms-xls;charset=euc-kr");
        response.setHeader("Content-Disposition", "attachment; filename=BookingData.xls");
        response.setHeader("Content-Description", "JSP Generated Data"); 
        
        String excelHtml = "";
 
         try {
            excelHtml = getExcelForm(request);
        } catch (EventException ex) {
            log.error(ex);
            excelHtml = "";
        } catch (Exception ex) {
            log.error(ex);
            excelHtml = "";
        }   
 
        return excelHtml;
    }
    /**
     * 
     * Main Method Excel자료 만들기 <br>
     *
     * @param  DBRowSet tDBRowSet
     * @throws EventException
     * @return String
     * @author jang kang cheol
     */
    private String getExcelForm(HttpServletRequest request) throws EventException{
        GeneralEventResponse eventResponse = null;
        eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
        List<DBRowSet> rsVoList = eventResponse.getRsVoList();        
        StringBuffer sbRs = new StringBuffer();
        try{
            String sVvd    = JSPUtil.getParameter( request, "vvd");
            String sRateHC = JSPUtil.getParameter( request, "ratehc");
            String sRate45 = JSPUtil.getParameter( request, "rate45");
     
            sbRs.append("<TABLE   border='0'   style='font-family: 굴림체; font-size: 24px' >\n");
            sbRs.append("<TR> \n");
            sbRs.append("   <TD colspan=3>VSL/VO  :</TD><TD  colspan=4>"+sVvd+"</TD><td></td><td></td>\n");
            sbRs.append("   <TD colspan=4>HC Rate :</TD><TD  >"+sRateHC+"</TD></td><td></td>\n");
            sbRs.append("   <TD colspan=4>45 Rate :</TD><TD  >"+sRate45+"</TD>\n");
            sbRs.append("</TR>\n");
            sbRs.append("</TABLE>\n");
    
            sbRs.append("<TABLE><TR><TD></TD></TR></TABLE>\n");
            sbRs.append("<TABLE   border='1'   style='font-family: 굴림체; font-size: 10px' >\n");
    
    
            DBRowSet tDBRowSet = (DBRowSet)rsVoList.get(0);//TITLE
            if( !tDBRowSet.next() ){
                 return "";
            }
            /****************************************************************************
             *    헤더 정리. 
             ****************************************************************************/
            sbRs.append( getExcelHeader(tDBRowSet) );
            
    
            /****************************************************************************
             *    디테일  정리. 
             ****************************************************************************/
            DBRowSet dDBRowSet = (DBRowSet)rsVoList.get(1);//내용. 
            if( !dDBRowSet.next() ){
                return "";
            }
            sbRs.append( getExcelDetail(dDBRowSet, tDBRowSet) );
            sbRs.append("</TABLE>\n");
        }catch(SQLException ex){
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Booking Inquiry"}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Booking Inquiry"}).getMessage(), ex);
        }   
        return sbRs.toString();
    }
    /**
     * 
     * Excel 헤더데이타 만들기 <br>
     *
     * @param  DBRowSet tDBRowSet
     * @throws SQLException
     * @return String
     * @author jang kang cheol
     */
    private String getExcelHeader(DBRowSet tDBRowSet) throws SQLException{
        StringBuffer sHeader = new StringBuffer();
        sHeader.append("<TR  bgcolor='#C1C4E8' valign='middle' height='20'>      \n");
        sHeader.append("     <TD  align='center' rowspan='3' width='155' colspan='2'><B>LDG&nbsp;PORT</B></TD>\n");
        sHeader.append("     <TD  align='center' colspan='"+tDBRowSet.getRowCount()*4+"'><B>DISCH.&nbsp;PORT</B></FONT></TD>  \n");
        sHeader.append("     <TD  align='center' colspan='5'><B>G&nbsp;TOTAL</B></TD>                         \n");
        sHeader.append("     <TD  align='center' rowspan='3'><B>EMPTY</B></TD>                                            \n");
        sHeader.append("</TR>  \n");
        sHeader.append("<TR    bgcolor='#C1C4E8' valign='middle' height='20'>               \n");
        for(int i=0;i<tDBRowSet.getRowCount(); i++ ){
            sHeader.append("     <TD  align='center' colspan='4' with='200'><B>"+tDBRowSet.getString("POL_CD")+"</B></TD>     \n");
            tDBRowSet.next();
        } 
        sHeader.append("     <TD  align='center' colspan='4'><B>TTL</B></TD>                \n");
        sHeader.append("     <TD  align='center' rowspan='2'><B>TEU</B></TD>                            \n");

        sHeader.append("</TR>                                                               \n");
        
        sHeader.append("<TR  ID='IBS-tr' bgcolor='#C1C4E8' valign='middle' height='20'>            \n");
        tDBRowSet.first();
        for(int i=0;i<=tDBRowSet.getRowCount(); i++ ){ //TTL 까지.+1 
        sHeader.append("     <TD  align='center'><FONT  color='#275F65'><B>20'</B></FONT></TD>     \n");
        sHeader.append("     <TD  align='center'><FONT  color='#275F65'><B>40'</B></FONT></TD>     \n");
        sHeader.append("     <TD  align='center'><FONT  color='#275F65'><B>HC</B></FONT></TD>      \n");
        sHeader.append("     <TD  align='center'><FONT  color='#275F65'><B>45</B></FONT></TD>      \n");
        sHeader.append("                                                                           \n");
        tDBRowSet.next();
        }
 
        sHeader.append("</TR>                                                                      \n");
        return sHeader.toString();
    }
    /**
     * 
     * Excel Detail 데이타 만들기 <br>
     *
     * @param DBRowSet dDBRowSet
     * @param DBRowSet tDBRowSet
     * @throws SQLException
     * @return String
     * @author jang kang cheol
     */
    private String getExcelDetail(DBRowSet dDBRowSet, DBRowSet tDBRowSet) throws SQLException{
        StringBuffer sDetail = new StringBuffer();
        dDBRowSet.first();
        String rowspan    =  "";
        int    rowspancnt =  3;
        String sPolCd     =  "";
        
        float iSumPod20Qty = 0f; //TTL 20 SUM
        float iSumPod40Qty = 0f; //TTL 40 SUM
        float iSumPodHCQty = 0f;
        float iSumPod45Qty = 0f;
 
        for(int i=0;i<dDBRowSet.getRowCount(); i++ ){
            iSumPod20Qty = 0f;
            iSumPod40Qty = 0f;
            iSumPodHCQty = 0f;
            iSumPod45Qty = 0f;

            if(rowspancnt == 3){
                rowspan = "rowspan = '3'";
                sPolCd = dDBRowSet.getString("POL_CD");
            }else{
                rowspan = "";
            }
            sDetail.append("<TR  ID='IBS-tr' bgcolor='#FFFFFF' valign='middle' height='20'>              \n");
            /*********************** POL_CD 셀 병합처리 , ROWSPAN ************************/
            if( !sPolCd.equals("") ){
                if(sPolCd.equals("TEU")){//TEU는 한줄..모두 3줄씩 Set이지만, 
                    rowspan = "";
                    //아래       >>>>>>   1) ROWSPAN 처리 로직 맞추기 위해  <<<<<<<<<<
                    rowspancnt = 1;
                } 
 
                sDetail.append("     <TD  align='center'  bgcolor='#FEFA91' "+rowspan+" width='76'>"+ sPolCd +"</TD> \n");
            }
 
            sDetail.append("     <TD  align='center' bgcolor='#FEFA91' width='40'>"+dDBRowSet.getString("TYPE")+"</TD> \n");
            tDBRowSet.first();
            /*************************POL_CD 가 TEU인 ROW는 POD셋(4건에 하나)당 COLSPAN=3 사용, CELL 병합처리  ***********************/

            if(sPolCd.equals("TEU")){
                for(int j=1;j<=tDBRowSet.getRowCount(); j++ ){// 헤더 데이타 한 row당  td 4개 
                    iSumPod20Qty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_20_QTY"), "0") ); 
                    iSumPod40Qty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_40_QTY"), "0") );  
                    iSumPodHCQty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_HC_QTY"), "0") );  
                    iSumPod45Qty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_45_QTY"), "0") );  
 
                    float iPodTeuSum = 0f;
    
                    iPodTeuSum += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_20_QTY"), "0") ); 
                    iPodTeuSum += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_40_QTY"), "0") );  
                    iPodTeuSum += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_HC_QTY"), "0") );  
                    iPodTeuSum += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_45_QTY"), "0") );  
                    
                    sDetail.append("     <TD  align='center' colspan='4' ><b>"+getNumFormat(iPodTeuSum) +"</b></TD> \n");
                    tDBRowSet.next();
                }
                /****** TEU -> TTL *****/
                sDetail.append("     <TD  align='center' colspan='4'>"+(getNumFormat(iSumPod20Qty+iSumPod40Qty+iSumPodHCQty+iSumPod45Qty) )+"</TD> \n");
 
            }else{//TEU가 아닌 일반 DATA ROW 건. 
                for(int j=1;j<=tDBRowSet.getRowCount(); j++ ){// 헤더 데이타 한 row당  td 4개 
                    iSumPod20Qty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_20_QTY"), "0") ); 
                    iSumPod40Qty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_40_QTY"), "0") );  
                    iSumPodHCQty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_HC_QTY"), "0") );  
                    iSumPod45Qty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_45_QTY"), "0") );  
                    
                    sDetail.append("     <TD  align='center' >"+dDBRowSet.getString("POD"+j+"_20_QTY")+"</TD> \n");
                    sDetail.append("     <TD  align='center' >"+dDBRowSet.getString("POD"+j+"_40_QTY")+"</TD> \n");
                    sDetail.append("     <TD  align='center' >"+dDBRowSet.getString("POD"+j+"_HC_QTY")+"</TD> \n");
                    sDetail.append("     <TD  align='center' >"+dDBRowSet.getString("POD"+j+"_45_QTY")+"</TD> \n");
                    tDBRowSet.next();
                }
                /*  TTL 20, 40, HC, 45 */
                sDetail.append("     <TD  align='center' >"+getNumFormat(iSumPod20Qty)+"</TD> \n");
                sDetail.append("     <TD  align='center' >"+getNumFormat(iSumPod40Qty)+"</TD> \n");
                sDetail.append("     <TD  align='center' >"+getNumFormat(iSumPodHCQty)+"</TD> \n");
                sDetail.append("     <TD  align='center' >"+getNumFormat(iSumPod45Qty)+"</TD> \n");
            }
            /************************한(Per One). POL_CD 셀 병합처리 , ROWSPAN END ************************/            
            float[] iTEU_iEMPTY = {0f,0f};
            if( !sPolCd.equals("") ){
                /******** Index 하위 3개까지 참조해서 미리 구한다. 한 Port당 Type이 세개 D,R/F,FL ******/

                iTEU_iEMPTY = getTeuAllTypePerPolCd(dDBRowSet, tDBRowSet);
                /* TEU Setting */
                if( !sPolCd.equals("TEU") &&  sPolCd.indexOf( "TOTAL" ) == -1 ) {
                sDetail.append("     <TD  align='center' bgcolor='#FEFA91' "+rowspan+"><b>"+getNumFormat(iTEU_iEMPTY[0])+"</b></TD> \n");
                }else{
                sDetail.append("     <TD  align='center' bgcolor='#FEFA91' colspan='2'> </TD> \n");    
                }
            }
            if( !sPolCd.equals("") ){
                /* EMPTY */
                if( !sPolCd.equals("TEU") &&  sPolCd.indexOf( "TOTAL" ) == -1 ) {
                    sDetail.append("     <TD  align='center' bgcolor='#FEFA91' "+rowspan+"><b>"+getNumFormat(iTEU_iEMPTY[1])+"</b></TD> \n");
                } 
            }

            sDetail.append("</TR> \n");
            dDBRowSet.next();
 
            /****   >>>>>>   1) ROWSPAN 처리 로직 맞추기 위해  <<<<<<<<<< *****/
            if(rowspancnt != 0){
                rowspancnt--;
                sPolCd = "";
                if(rowspancnt==0){
                     rowspancnt=3;
                }
            }
        }
         
        return sDetail.toString();
    }
    /**
     * 
     * 한 POL_CD당 모든 Type의 TEU와 EMPTY를 구한다.
     *  
     *
     * @param  DBRowSet dDBRowSet
     * @param  DBRowSet tDBRowSet
     * @throws SQLException
     * @return int[]  : [0,TEU], [1, EMPTY] 
     * @author jang kang cheol
     */
    private float[] getTeuAllTypePerPolCd(DBRowSet dDBRowSet, DBRowSet tDBRowSet) throws SQLException{
        float iSumPod20Qty = 0f; //TTL 20 SUM
        float iSumPod40Qty = 0f; //TTL 40 SUM
        float iSumPodHCQty = 0f;
        float iSumPod45Qty = 0f;
        float[] iTEU_iEMPTY = {0f,0f};  
        float iTEU   = 0f;
        float iEMPTY = 0f;
        String[] aTypes = "D,R/F,FL".split(",");
        int curIdx = dDBRowSet.getRow();
        for(int idx = 0; idx < aTypes.length; idx++ ){
            if( dDBRowSet.getString("TYPE").equals( aTypes[idx] ) )   { 
                iEMPTY += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("MT_20_CNT"), "0") );
                iEMPTY += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("MT_40_CNT"), "0") ) * 2;
                iEMPTY += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("MT_HC_CNT"), "0") ) * Float.parseFloat( dDBRowSet.getString("RATEHC") );
                iEMPTY += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("MT_45_CNT"), "0") ) * Float.parseFloat( dDBRowSet.getString("RATE45") );
                for(int j=1;j<=tDBRowSet.getRowCount(); j++ ){// 헤더 데이타 한 row당  td 4개 
                    iSumPod20Qty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_20_QTY"), "0") ); 
                    iSumPod40Qty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_40_QTY"), "0") );  
                    iSumPodHCQty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_HC_QTY"), "0") );  
                    iSumPod45Qty += Float.parseFloat( JSPUtil.getNull( dDBRowSet.getString("POD"+j+"_45_QTY"), "0") );  
                    
                    tDBRowSet.next();
                }
            }
            if( !dDBRowSet.next() ){
                break;
            }
        }         
        dDBRowSet.first();
        iTEU += iSumPod20Qty; 
        iTEU += iSumPod40Qty * 2;
        iTEU += iSumPodHCQty * Float.parseFloat( dDBRowSet.getString("RATEHC") );
        iTEU += iSumPod45Qty * Float.parseFloat( dDBRowSet.getString("RATE45") );
        
        dDBRowSet.absolute(curIdx); ///DBRowSet index 복구.
        
        iTEU_iEMPTY[0] = iTEU;
        iTEU_iEMPTY[1] = iEMPTY;
        return iTEU_iEMPTY;
    }
    /**************************************************************************
     *  숫자에 세자리마다 쉼표를 찍는다.
     **************************************************************************/
     private static String getNumFormat(double dNumber)
     {
         NumberFormat  numFormat = NumberFormat.getCurrencyInstance();
         DecimalFormat decFormat = (DecimalFormat) numFormat;

         String pattern = "";

         if ( ( dNumber % 1 ) == 0 ) {
             pattern = "###,###,###,##0";
         } else {
             pattern = "###,###,###,##0.##";
         }

         decFormat.applyPattern(pattern);
         return decFormat.format(dNumber);
     }


}
