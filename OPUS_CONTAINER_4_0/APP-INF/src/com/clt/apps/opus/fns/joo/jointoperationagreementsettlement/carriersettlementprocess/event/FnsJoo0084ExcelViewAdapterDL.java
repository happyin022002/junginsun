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

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConversionAndOptionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrStandardFormatVO;
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

public class FnsJoo0084ExcelViewAdapterDL extends ViewAdapter {

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
    public String makeXML(HttpServletRequest request, HttpServletResponse response) {  
         
         
        String excelFileName = "StandardFormatData.xls"; 
        String excelHtml = "";
 
         try {
            excelHtml = getExcelForm(request);
            
            response.reset();
 			response.setContentType("application/vnd.ms.excel");
 			String strClient = request.getHeader("user-agent");
 
 			if (strClient.indexOf("MSIE 5.5") != -1) {
 				response.setHeader("Content-Type","doesn/matter; charset=euc-kr");
 				response.setHeader("Content-Disposition", "filename="+ excelFileName + "; charset=euc-kr");
 			} else {
 				response.setHeader("Content-Type","application/octet-stream; charset=euc-kr");
 				response.setHeader("Content-Disposition","attachment;filename=" + excelFileName + ";");
 			} 			     		
     		
    		PrintWriter pout = response.getWriter();
			pout.print(excelHtml);
			pout.flush();
			pout.close();
        } catch (EventException ex) {
            log.error(ex);
        } catch (Exception ex) {
            log.error(ex);
        }   
 
        return "";
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
    @SuppressWarnings("unchecked")
	private String getExcelForm(HttpServletRequest request) throws EventException{
        GeneralEventResponse eventResponse = null;
        eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
        CntrConditionVO conditionVo = (CntrConditionVO)eventResponse.getCustomData("condition");
		List<CntrStandardFormatVO> preList = (ArrayList<CntrStandardFormatVO>) eventResponse.getCustomData("preList");
		List<CntrStandardFormatVO> sumList = (ArrayList<CntrStandardFormatVO>) eventResponse.getCustomData("sumList");
		
		List<CntrConversionAndOptionVO> ldnTeuList = (ArrayList<CntrConversionAndOptionVO>) eventResponse.getCustomData("ladenTeuList");
		List<CntrConversionAndOptionVO> etyTeuList = (ArrayList<CntrConversionAndOptionVO>) eventResponse.getCustomData("emptyTeuList");
		List<CntrConversionAndOptionVO> optionList = (ArrayList<CntrConversionAndOptionVO>) eventResponse.getCustomData("optionList");
       
		
        StringBuffer sbRs = new StringBuffer();
    	int iRowIdx = 1; //TR의 Count 로 보면 됨.preList.size() 를 최종적으로 더해 준다.
        try{
            String sService	= conditionVo.getVslSlanCd() ; 
            String sVessel 	= conditionVo.getVslCd() + conditionVo.getVoyNo() + conditionVo.getDirCd();//JSPUtil.getParameter( request, "vvd");
            String sLine   	= conditionVo.getSlanCd();
            sbRs.append("<style>");
            sbRs.append("br{mso-data-placement:same-cell;}");
            sbRs.append("</style>");
            //상단 타이틀
            sbRs.append("<TABLE   border='0'   style='font-family:arial,Gulim; font-size: 10pt' >\n");
            sbRs.append("<TR> \n");
            sbRs.append("   <TD colspan=2>Service  :</TD><TD  colspan='3' align='left'>"+sService+"</TD>\n");
            sbRs.append("</TR>\n");
            sbRs.append("<TR> \n");
            sbRs.append("   <TD colspan=2>Vessel  :</TD><TD  colspan='3' align='left'>"+sVessel+"</TD>\n");
            sbRs.append("</TR>\n");
            sbRs.append("<TR> \n");
            sbRs.append("   <TD colspan=2>Line  :</TD><TD  colspan='3' align='left'>"+sLine+"</TD>\n");
            sbRs.append("</TR>\n");
            sbRs.append("</TABLE>\n");
    
            sbRs.append("<TABLE border='0'><TR height='10px'><TD></TD></TR></TABLE>\n");
            

            String sLadenTpszDatas = conditionVo.getLadenTpszDatas();
            String sEmptyTpszDatas = conditionVo.getEmptyTpszDatas();
            
            String[] arrLadenTpsz = StringUtils.split(sLadenTpszDatas, "|");
            String[] arrEmptyTpsz = StringUtils.split(sEmptyTpszDatas, "|");
            
            List<String> ldnTpszList = new ArrayList<String>();
            List<String> etyTpszList = new ArrayList<String>();
            
            if(arrLadenTpsz != null){
            	for(int i=0; i < arrLadenTpsz.length; i++){
            		ldnTpszList.add(arrLadenTpsz[i]);
            	}
            }
            if(arrEmptyTpsz != null){
            	for(int i=0; i < arrEmptyTpsz.length; i++){
            		etyTpszList.add(arrEmptyTpsz[i]);
            	}
            }            
            
            //ROB from previous voyage Title
            sbRs.append("<TABLE border='0'><TR height='20px'><TD colspan='15'>ROB from previous voyage</TD></TR></TABLE>\n");
            sbRs.append(getPreviousExcel(ldnTpszList, etyTpszList, preList));
            
            sbRs.append("<TABLE border='0'><TR height='20px'><TD colspan='15'></TD></TR></TABLE>\n");
            
            //Operation Summary Report.
            sbRs.append("<TABLE border='0'><TR height='20px'><TD colspan='15'>Operation Summary Report</TD></TR></TABLE>\n");            
            sbRs.append(getSummaryExcel(ldnTpszList, etyTpszList, sumList));

            //Operation Summary Report.
            sbRs.append("<TABLE border='0'><TR height='20px'><TD colspan='15'>Operation Summary Report Formula Guide</TD></TR></TABLE>\n");
            // 7: 첫라인부터 Previous Title Row Count + Previous 레코드 Count + Previous Total Row + (Gap 1Row + 대타이틀 1Row)
            iRowIdx = 7 + preList.size() + 1 + 2; 
            sbRs.append(getFormula(iRowIdx, ldnTpszList, etyTpszList, ldnTeuList, etyTeuList, optionList, sumList));
    
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Summary by Carrier By Standard format"}).getMessage(), ex);
        }   
        return sbRs.toString();
    }
    
    private String getFormula(int iRowIdx, List<String> ldnTpszList, List<String> etyTpszList, List<CntrConversionAndOptionVO> ldnTeuList, List<CntrConversionAndOptionVO> etyTeuList, List<CntrConversionAndOptionVO> optionList, List<CntrStandardFormatVO> preList){
    	StringBuffer sb = new StringBuffer();
    	String sTableStyle 		= "font-family:arial,Gulim; font-size: 9pt;table-layout:fixed;";
    	String sTrStyle		 	= "text-valign:middle; height:20px;";
    	String sTitleStyle 		= "background:#C1C4E8;text-align:center; text-valign:middle; height:20px;";
    	String sTdStyle			= "text-align:left;height:20px;width:50px;";

    	String sTdTitleColSpan 	= "4";
    	String sTdFormulaColSpan= "22";
    	
    	String sFormula			= "";
    	StringBuffer formulaSb 	= new StringBuffer();
    	int iDftRowIdx			= iRowIdx + 4; //Operation Summary Report Head Title 3 Row Add 
    	
    	CntrConversionAndOptionVO optVo = new CntrConversionAndOptionVO();
    	if(optionList != null && optionList.size() > 0) optVo = (CntrConversionAndOptionVO)optionList.get(0);
    	
    	String sOptionA			= optVo.getOptionA();
    	String sOptionB			= optVo.getOptionB();
    	
    	int iOptRowIdx			= getOptionB(optVo.getOptionB(), iDftRowIdx); 
    	int iOptRfPlugRowIdx	= iOptRowIdx; //2016.02.04 동일 Row 로 수정. getOptionB("OPTION1", iDftRowIdx); //RF PLUG 는 Loding 에서 가져온다.
    	
    	log.debug("\n Option A["+sOptionA+"] B["+sOptionB+"] iRowIdx["+iRowIdx+"] iDftRowIdx["+iDftRowIdx+"] optRowIdx["+iOptRowIdx+"] iOptRfPlugRowIdx["+iOptRfPlugRowIdx+"]");
    	
    	sb.append("\n<table border='1' style='"+sTableStyle+"'>      ");
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='10' style='"+sTitleStyle+"'>Formula Title</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' align='center' style='"+sTitleStyle+"'>Formula Guide</td>                        ");
    	sb.append("\n	</tr>");
    	
    	//Summary by Port  START ===================================================================   
    	//Total TEU = Ldn TEU + Ety TEU
    	//=AH21+AI21
    	formulaSb.setLength(0);
    	formulaSb.append("'=");
    	formulaSb.append(getTextRow("AH", iDftRowIdx)).append(" + ").append(getTextRow("AI", iDftRowIdx));
    	
    	sFormula = formulaSb.toString();
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='6' rowspan='7' style='"+sTitleStyle+"'>Summary by Port</td>                        ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Total TEU</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	//=+H23*1+I23*1+J23*1+K23*2+L23*2+M23*2+N23*2+O23*2+P23*3+Q23*2+R23*1+S23*2+T23*4+U23
    	sFormula = getTeuText("F", ldnTeuList, etyTeuList, iOptRowIdx);
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Ldn TEU</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	//=+V23*1+W23*1+X23*2+Y23*2+Z23*2+AA23*3+AB23*2+AC23*1+AD23*2+AE23*4
    	sFormula = getTeuText("E", ldnTeuList, etyTeuList, iOptRowIdx);
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    	    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Ety TEU</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	//=AF23
    	sFormula = getTextRow("AF", iOptRowIdx);
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Wgt (Ton)</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	sFormula = "";
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Wgt (TEU)</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	//=ROUND(IF(AK21 > 0, AJ21/AK21,0),0)
    	formulaSb.setLength(0);
    	formulaSb.append("IF(");
    	formulaSb.append(getTextRow("AK", iDftRowIdx)).append(" > 0, ");
    	formulaSb.append(getTextRow("AJ", iDftRowIdx)).append(" / ").append(getTextRow("AK", iDftRowIdx));
    	formulaSb.append(",0)");
    	
    	sFormula = getOptionA(sOptionA, formulaSb.toString()); 
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    	 	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>TEU by Wgt</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	//=+J22+M22+N22
    	sFormula = getTeuText("R", ldnTeuList, etyTeuList, iOptRfPlugRowIdx);
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>RF Plug</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	//Summary by Port  E N D ===================================================================  
    	
    	//Allocation START ===================================================================
    	sFormula = "";
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='6' rowspan='2' style='"+sTitleStyle+"'>Allocation</td>                        ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Slot</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	sFormula = "";
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>RF</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	//Allocation E N D ===================================================================
    	
    	//Buy & Sell START ===================================================================
    	sFormula = "";
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='6' rowspan='2' style='"+sTitleStyle+"'>Buy & Sell</td>                        ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Slot</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");

    	sFormula = "";
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>RF</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	//Buy & Sell E N D ===================================================================
    	
    	//Excess START ===================================================================
    	//=ROUND(IF(AG21-AN21>0,AG21-AN21,0),0)
    	formulaSb.setLength(0);
    	formulaSb.append("IF(");
    	formulaSb.append(getTextRow("AG", iDftRowIdx)).append(" - ").append(getTextRow("AN", iDftRowIdx)).append(" > 0, ");
    	formulaSb.append(getTextRow("AG", iDftRowIdx)).append(" - ").append(getTextRow("AN", iDftRowIdx)).append(" , 0) ");
    	
    	sFormula = getOptionA(sOptionA, formulaSb.toString());
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    	  	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='3' rowspan='5' style='"+sTitleStyle+"'>Excess</td>                        ");
    	sb.append("\n		<td colspan='3' rowspan='3' style='"+sTitleStyle+"'>TEU</td>                        ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Total</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	//=AR21-AT21
    	formulaSb.setLength(0);
    	formulaSb.append(getTextRow("AR", iDftRowIdx)).append(" - ").append(getTextRow("AT", iDftRowIdx));
    	sFormula = formulaSb.toString();
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Laden</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	//=ROUND(IF(AI21<AR21,AI21,AR21),0)
    	formulaSb.setLength(0);
    	formulaSb.append("IF(");
    	formulaSb.append(getTextRow("AI", iDftRowIdx)).append(" < ").append(getTextRow("AR", iDftRowIdx)).append(", ");
    	formulaSb.append(getTextRow("AI", iDftRowIdx)).append(" , ").append(getTextRow("AR", iDftRowIdx));
    	formulaSb.append(")");
    	
    	sFormula = getOptionA(sOptionA, formulaSb.toString());
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Empth</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	//=IF(AL21-AN21>0,AL21-AN21,0)
    	formulaSb.setLength(0);
    	formulaSb.append("IF(");
    	formulaSb.append(getTextRow("AL", iDftRowIdx)).append(" - ").append(getTextRow("AN", iDftRowIdx)).append(" > 0, ");
    	formulaSb.append(getTextRow("AL", iDftRowIdx)).append(" - ").append(getTextRow("AN", iDftRowIdx));
    	formulaSb.append(", 0)");
    	
    	sFormula = getOptionA(sOptionA, formulaSb.toString()); 
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='3' rowspan='2' style='"+sTitleStyle+"'>DWT</td>                        ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>TEU</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	//=IF(AM21-AO21-AQ21>0,AM21-AO21-AQ21,0)
    	formulaSb.setLength(0);
    	formulaSb.append("IF(");
    	formulaSb.append(getTextRow("AM", iDftRowIdx)).append(" - ").append(getTextRow("AO", iDftRowIdx)).append(" > 0, ");
    	formulaSb.append(getTextRow("AM", iDftRowIdx)).append(" - ").append(getTextRow("AO", iDftRowIdx)).append(" - ").append(getTextRow("AQ", iDftRowIdx));
    	formulaSb.append(", 0)");
    	
    	sFormula = formulaSb.toString(); 
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>RF</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	//Excess E N D ===================================================================
    	
    	//Price START ===================================================================
    	sFormula = "";
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='6' rowspan='2' style='"+sTitleStyle+"'>Price</td>                        ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Slot</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	sFormula = "";

    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>RF</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	//Price E N D ===================================================================
    	
    	//Amount START ===================================================================
    	//=(IF(AR21>AU21,AS21*AW21+AT21*(AW21/2),AU21*AW21))+(AP21*AW21)
    	formulaSb.setLength(0);
    	formulaSb.append("IF(");
    	formulaSb.append(getTextRow("AR", iDftRowIdx)).append(" > ").append(getTextRow("AU", iDftRowIdx)).append(" , ");
    	formulaSb.append(getTextRow("AS", iDftRowIdx)).append(" * ").append(getTextRow("AW", iDftRowIdx)).append(" + ");
    	formulaSb.append(getTextRow("AT", iDftRowIdx)).append(" * ").append(" ( ").append(getTextRow("AW", iDftRowIdx)).append(" / 2 ), ");
    	formulaSb.append(getTextRow("AU", iDftRowIdx)).append(" * ").append(getTextRow("AW", iDftRowIdx)).append(" ) + ( ");
    	formulaSb.append(getTextRow("AP", iDftRowIdx)).append(" * ").append(getTextRow("AW", iDftRowIdx)).append(" ) ");
    	
    	sFormula = formulaSb.toString();
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='6' rowspan='2' style='"+sTitleStyle+"'>Amount</td>                        ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Buy+Excess Slots</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	
    	//=(AM21+AQ21+AV21)*AX21
    	formulaSb.setLength(0);
    	formulaSb.append("(");
    	formulaSb.append(getTextRow("AM", iDftRowIdx)).append(" + ").append(getTextRow("AQ", iDftRowIdx)).append(" + ").append(getTextRow("AV", iDftRowIdx));
    	formulaSb.append(") * ");
    	formulaSb.append(getTextRow("AX", iDftRowIdx));
    	
    	sFormula = formulaSb.toString();   
    	
    	formulaSb.setLength(0);
    	formulaSb.append("'=").append(sFormula);
    	sFormula = formulaSb.toString();
    		
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='"+sTdTitleColSpan+"' style='"+sTitleStyle+"'>Used Plugs</td>                        ");
    	sb.append("\n		<td colspan='"+sTdFormulaColSpan+"' style='"+sTdStyle+"'>"+sFormula+"</td>                        ");
    	sb.append("\n	</tr>");
    	//Amount E N D ===================================================================
    	
    	sb.append("\n</table>"); 
    	
    	log.debug("\n############################## getFormula Start###########################");
    	log.debug("\n"+sb.toString());
    	log.debug("\n############################## getFormula E n d###########################");
    	return sb.toString();
    }
	private HashMap<String, String> getMakeCellKeyMap(){
		String[] arrLdnTpsz = new String[]{"20|H","20FR|I","20RF|J","40|K","40FR|L","40RF|M","40RH|N","40HC|O","45|P","20OD|Q","20OT|R","40OT|S","40OD|T","VOID|U"}; //13건
		String[] arrEtyTpsz = new String[]{"20|V","20FR|W","40|X","40FR|Y","40HC|Z","45|AA","20OD|AB","20OT|AC","40OT|AD","40OD|AE"}; //10건
	    
		HashMap<String, String> cellKeyMap = new LinkedHashMap<String, String>();
    	for(int i=0; i < arrLdnTpsz.length ; i++){
    		String[] tmpVal = StringUtils.split(arrLdnTpsz[i], "|"); 
    		cellKeyMap.put("F"+tmpVal[0], tmpVal[1]);
    	}
    	
    	for(int i=0; i < arrEtyTpsz.length ; i++){
    		String[] tmpVal = StringUtils.split(arrEtyTpsz[i], "|"); 
    		cellKeyMap.put("E"+tmpVal[0], tmpVal[1]);
    	}
    	
    	return cellKeyMap;
    }
    
    private String getTeuText(String gubun, List<CntrConversionAndOptionVO> ldnTeuList, List<CntrConversionAndOptionVO> etyTeuList, int idx){
    	StringBuffer sb = new StringBuffer();
    	
    	//정의된 TP/SZ 별로 Key(L/E+Tpsz),Value(Excel 가로 A,B,C...) 를 만든다.
    	HashMap<String, String> cellKeyMap = getMakeCellKeyMap();
    	String sRowIdx = String.valueOf(idx);
    	
    	if(gubun.equals("F")){ //Laden
    		int iCnt = 0;
    		for(CntrConversionAndOptionVO vo : ldnTeuList){
    			String tmpKey = vo.getDftTpszGroup()+vo.getDftTpsz();
    			String tmpCellKey = cellKeyMap.get(tmpKey);
    			if(iCnt == 0){
    				sb.append(tmpCellKey).append(sRowIdx).append(" * ").append(vo.getDftTeuCnt());
    			}else{
    				sb.append(" + ").append(tmpCellKey).append(sRowIdx).append(" * ").append(vo.getDftTeuCnt());
    			}    			
    			iCnt++;
    		}
    		String tmpKey = gubun+"VOID";
    		sb.append(" + ").append(cellKeyMap.get(tmpKey)).append(sRowIdx);    		
    	}else if(gubun.equals("E")){ //Empty
    		int iCnt = 0;
    		for(CntrConversionAndOptionVO vo : etyTeuList){
    			String tmpKey = vo.getDftTpszGroup()+vo.getDftTpsz();
    			String tmpCellKey = cellKeyMap.get(tmpKey);
    			if(iCnt == 0){
    				sb.append(tmpCellKey).append(sRowIdx).append(" * ").append(vo.getDftTeuCnt());
    			}else{
    				sb.append(" + ").append(tmpCellKey).append(sRowIdx).append(" * ").append(vo.getDftTeuCnt());
    			}    			
    			iCnt++;
    		}
    		
    	}else if(gubun.equals("R")){ //RF
    		int iCnt = 0;
    		for(CntrConversionAndOptionVO vo : ldnTeuList){
    			if("Y".equals(vo.getDftRfPlugFlg())){
	    			String tmpKey = vo.getDftTpszGroup()+vo.getDftTpsz();
	    			String tmpCellKey = cellKeyMap.get(tmpKey);
	    			if(iCnt == 0){
	    				sb.append(tmpCellKey).append(sRowIdx);
	    			}else{
	    				sb.append(" + ").append(tmpCellKey).append(sRowIdx);
	    			}    			
	    			iCnt++;
    			}
    		}
    	}
    	
    	return sb.toString();
    }
    private String getTextRow(String prefix, int idx){
    	return prefix+idx+"";
    }
    
	/**
	 * Option B Case.
	 * @param opt
	 * @param idx
	 * @return
	 */
	private int getOptionB(String opt, int idx){
		
		if(opt.equals("OPTION1")){
			idx += 2;//on board(Balance Idx)
		}else{
			idx += 1;//Loading(Load Idx)
		}
		return idx;
	}
	
	/**
	 * Option A Case.
	 * @param opt
	 * @param value
	 * @return
	 */
	private String getOptionA(String opt, String value){
		String sRtn = "ROUNDUP("+value+",1)";
		
		if(opt.equals("OPTION2")){
			sRtn = "ROUND("+value+",1)";
		}else if(opt.equals("OPTION3")){
			sRtn = "ROUND("+value+",2)";
		}else if(opt.equals("OPTION4")){
			sRtn = "ROUNDDOWN("+value+",2)";
		}else{
			sRtn = "ROUNDUP("+value+",1)";
		}
		
		return sRtn;
	}
    
    private String getPreviousExcel(List<String> ldnTpszList, List<String> etyTpszList, List<CntrStandardFormatVO> preList) throws Exception{
    	StringBuffer sb = new StringBuffer();    	
    	//2Row
    	//sb.append(b);
    	int iLdnColSpan = ldnTpszList.size() + 1;//void col 추가.
    	int iEtyColSpan = etyTpszList.size();
    	
    	String sTableStyle = "font-family:arial,Gulim; font-size: 9pt ;";
    	String sTrStyle = "background:#C1C4E8;text-align:center; text-valign:middle; height:20px";
    	String sTdWidth = "50px";
    	
    	
    	sb.append("\n<table border='1' style='"+sTableStyle+"'>      ");
    	//=============================== ROB from previous voyage Header Start==========================================
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td rowspan='2'  				width='"+sTdWidth+"'>Seq.</td>                         ");
    	sb.append("\n		<td rowspan='2'  				width='"+sTdWidth+"'>Voy./Dir</td>                     ");
    	sb.append("\n		<td colspan='2'  				width='"+sTdWidth+"'>Consortium Voy.</td>              ");
    	sb.append("\n		<td rowspan='2'  				width='"+sTdWidth+"'>Port</td>                         ");
    	sb.append("\n		<td rowspan='2'  				width='"+sTdWidth+"'>Sq#</td>                          ");
    	sb.append("\n		<td rowspan='2'  				width='"+sTdWidth+"'>Type</td>                         ");
    	sb.append("\n		<td colspan='"+iLdnColSpan+"' 	width='"+sTdWidth+"'>Laden</td>                        ");
    	sb.append("\n		<td colspan='"+iEtyColSpan+"'  	width='"+sTdWidth+"'>Empty</td>                        ");
    	sb.append("\n		<td rowspan='2'  				width='"+sTdWidth+"'>Wgt</td>                          ");
    	sb.append("\n	</tr>                                                               ");
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td width='"+sTdWidth+"'>I/B</td>                                       ");
    	sb.append("\n		<td width='"+sTdWidth+"'>O/B</td>                                       ");
    	//laden loop
    	for(String ldn : ldnTpszList){
    		sb.append("\n		<td width='"+sTdWidth+"'>"+ldn+"</td>                                        ");
    	}
    	sb.append("\n		<td width='"+sTdWidth+"'>Void</td>                                      ");
    	//empty loop
    	for(String ety : etyTpszList){
    		sb.append("\n		<td width='"+sTdWidth+"'>"+ety+"</td>                                        ");
    	}
    	sb.append("\n	</tr>                                                               ");
    	//=============================== ROB from previous voyage Header E n d==========================================
    	//pre Data loop
    	int iSeq = 1;
    	int iTotalIdx = 0;
    	int iArraySize = ldnTpszList.size() + etyTpszList.size() + 2;
    	double[] dArrTotal = new double[iArraySize];
    	//=============================== ROB from previous voyage Data Start==========================================
    	for(CntrStandardFormatVO vo : preList){
    		iTotalIdx=0; 
    		sb.append("\n	<tr>");
    		
    		sb.append("\n		<td width='"+sTdWidth+"'>"+JSPUtil.getNull(iSeq++)+"</td> ");
    		sb.append("\n		<td width='"+sTdWidth+"' style='mso-number-format:\\@'>"+JSPUtil.getNull(vo.getSkdVoyNo())+"</td> ");
    		sb.append("\n		<td width='"+sTdWidth+"' style='mso-number-format:\\@'>"+JSPUtil.getNull(vo.getIbCssmVoyNo())+"</td> ");
    		sb.append("\n		<td width='"+sTdWidth+"' style='mso-number-format:\\@'>"+JSPUtil.getNull(vo.getObCssmVoyNo())+"</td> ");
    		sb.append("\n		<td width='"+sTdWidth+"'>"+JSPUtil.getNull(vo.getVpsPortCd())+"</td> ");
    		sb.append("\n		<td width='"+sTdWidth+"'>"+JSPUtil.getNull(vo.getClptIndSeq())+"</td> ");
    		sb.append("\n		<td width='"+sTdWidth+"'>"+JSPUtil.getNull(vo.getType())+"</td> ");
    		//Laden data Loop
    		for(int i=1 ; i <= iLdnColSpan -1 ; i++){
    			String tmpMethodName = "getFQty"+i;
    			String tmpValue = JSPUtil.getNull((String) callMethod(vo, tmpMethodName), "0");
    			sb.append("\n		<td width='"+sTdWidth+"'>"+getNumFormat(Double.parseDouble(tmpValue))+"</td> ");
    			
    			dArrTotal[iTotalIdx] += Double.parseDouble(tmpValue);
    			iTotalIdx++;
            }
    		
    		String tmpVoidQty = JSPUtil.getNull(vo.getVoidQty(), "0");
    		dArrTotal[iTotalIdx] += Double.parseDouble(tmpVoidQty);
    		iTotalIdx++;
    		
    		sb.append("\n		<td width='"+sTdWidth+"'>"+getNumFormat(Double.parseDouble(tmpVoidQty))+"</td> ");
    		
    		//Empty data Loop
    		for(int i=1 ; i <= iEtyColSpan ; i++){
    			String tmpMethodName = "getEQty"+i;
    			String tmpValue = JSPUtil.getNull((String) callMethod(vo, tmpMethodName), "0");
    			sb.append("\n		<td width='"+sTdWidth+"'>"+getNumFormat(Double.parseDouble(tmpValue))+"</td> ");
    			
    			dArrTotal[iTotalIdx] += Double.parseDouble(tmpValue);
    			iTotalIdx++;
            }
    		String tmpWeight = JSPUtil.getNull(vo.getWeight(), "0");
    		dArrTotal[iTotalIdx] += Double.parseDouble(tmpWeight);
			
    		sb.append("\n		<td width='"+sTdWidth+"'>"+getNumFormat(Double.parseDouble(tmpWeight))+"</td> ");
    		
    		sb.append("\n	</tr>                                                               ");
    	}
    	//Totla
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td colspan='7' width='"+sTdWidth+"'>Total</td> ");
    	for(int j=0; j < dArrTotal.length; j++){
    		sb.append("\n		<td colspan='1' width='"+sTdWidth+"' align='right'>"+getNumFormat(dArrTotal[j])+"</td> ");
    	}
    	sb.append("\n	</tr> ");
    	//=============================== ROB from previous voyage data E n d==========================================
    	sb.append("\n</table>                                                             ");
    	
    	
    	log.debug("\n############################## getPreviousExcel Start###########################");
    	log.debug("\n"+sb.toString());
    	log.debug("\n############################## getPreviousExcel E n d###########################");
    	return sb.toString();
    }
    
    private String getSummaryExcel(List<String> ldnTpszList, List<String> etyTpszList, List<CntrStandardFormatVO> sumList) throws Exception{
    	StringBuffer sb = new StringBuffer();    	
    	//2Row
    	//sb.append(b);
    	int iLdnColSpan = ldnTpszList.size() + 1;//void col 추가.
    	int iEtyColSpan = etyTpszList.size();
    	
    	String sTableStyle = "font-family:arial,Gulim; font-size: 9pt;";
    	String sTrStyle = "background:#C1C4E8;text-align:center; text-valign:middle; height:20px";
    	String sTdWidth = "50px";
    	String sTdDataSytle = "width:50px;text-align:right;";
    	
    	
    	sb.append("\n<table border='1' style='"+sTableStyle+"'>      ");
    	//=============================== Operation Summary Report Header Start==========================================
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td rowspan='3'  				width='"+sTdWidth+"'>Seq.</td>                         ");
    	sb.append("\n		<td rowspan='3'  				width='"+sTdWidth+"'>Voy./Dir</td>                     ");
    	sb.append("\n		<td colspan='2'  				width='"+sTdWidth+"'>Consortium Voy.</td>              ");
    	sb.append("\n		<td rowspan='3'  				width='"+sTdWidth+"'>Port</td>                         ");
    	sb.append("\n		<td rowspan='3'  				width='"+sTdWidth+"'>Sq#</td>                          ");
    	sb.append("\n		<td rowspan='3'  				width='"+sTdWidth+"'>Type</td>                         ");
    	sb.append("\n		<td colspan='"+iLdnColSpan+"' 	width='"+sTdWidth+"'>Laden</td>                        ");
    	sb.append("\n		<td colspan='"+iEtyColSpan+"'  	width='"+sTdWidth+"'>Empty</td>                        ");
    	sb.append("\n		<td rowspan='3'  				width='"+sTdWidth+"'>Wgt</td>                          ");
    	sb.append("\n		<td colspan='7'  				width='"+sTdWidth+"'>Summary by Port</td>              ");
    	sb.append("\n		<td colspan='2'  				width='"+sTdWidth+"'>Allocation</td>                   ");
    	sb.append("\n		<td colspan='2'  				width='"+sTdWidth+"'>Buy&Sell</td>                     ");
    	sb.append("\n		<td colspan='5'  				width='"+sTdWidth+"'>Excess</td>                       ");
    	sb.append("\n		<td colspan='2'  				width='"+sTdWidth+"'>Price</td>                        ");
    	sb.append("\n		<td colspan='2'  				width='"+sTdWidth+"'>Amount</td>                       ");
    	sb.append("\n	</tr>                                                               						");
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td rowspan='2'   	width='"+sTdWidth+"'>I/B</td>                                       ");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>O/B</td>                                       ");
    	//laden loop
    	for(String ldn : ldnTpszList){
    		sb.append("\n		<td rowspan='2'	width='"+sTdWidth+"'>"+ldn+"</td>                                        ");
    	}
    	sb.append("\n		<td rowspan='2' 	width='"+sTdWidth+"'>Void</td>                                      ");
    	//empty loop
    	for(String ety : etyTpszList){
    		sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>"+ety+"</td>                                        ");
    	}
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>Total<br>TEU</td> 		");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>Ldn<br>TEU</td> 			");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>Ety<br>TEU</td> 			");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>Wgt<br>(Ton)</td> 		");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>Wgt<br>(TEU)</td> 		");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>TEU by<br>Wgt</td>		");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>RF<br>Plug</td>        ");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>Slot</td>              ");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>RF</td>                ");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>Slot</td>              ");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>RF</td>                ");
    	sb.append("\n		<td colspan='3'		width='"+sTdWidth+"'>TEU</td>               ");
    	sb.append("\n		<td colspan='2'		width='"+sTdWidth+"'>DWT</td>               ");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>Slot</td>              ");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>Plug</td>              ");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>Buy+<br>Excess Slots</td>");
    	sb.append("\n		<td rowspan='2'		width='"+sTdWidth+"'>Used<br>Plugs</td>       ");
    	sb.append("\n	</tr>                                                               ");
    	
    	sb.append("\n	<tr style='"+sTrStyle+"'> ");
    	sb.append("\n		<td rowspan='1'		width='"+sTdWidth+"'>Total</td>             ");
    	sb.append("\n		<td rowspan='1'		width='"+sTdWidth+"'>Laden</td>             ");
    	sb.append("\n		<td rowspan='1'		width='"+sTdWidth+"'>Empty</td>             ");
    	sb.append("\n		<td rowspan='1'		width='"+sTdWidth+"'>TEU</td>               ");
    	sb.append("\n		<td rowspan='1'		width='"+sTdWidth+"'>RF</td>                ");
    	sb.append("\n	</tr>                                                               ");
    	//=============================== Operation Summary Report Header E n d==========================================
    	
    	//=============================== Operation Summary Report Data   Start ==========================================
    	//sum Data loop
    	boolean isRowSpan = false;
    	String tmpOrd = "";
    	double dTotalAmout = 0d;
    	for(CntrStandardFormatVO vo : sumList){
    		if(!tmpOrd.equals(vo.getOrd())){
    			isRowSpan = true;
    		}else{
    			isRowSpan = false;
    		}
    		
    		sb.append("\n	<tr>");
    		
    		if(isRowSpan){
    			sb.append("\n		<td rowspan='3'		width='"+sTdWidth+"'>"+JSPUtil.getNull(vo.getOrd())+"</td> ");
        		sb.append("\n		<td rowspan='3'		width='"+sTdWidth+"' style='mso-number-format:\\@'>"+JSPUtil.getNull(vo.getSkdVoyNo())+"</td> ");
        		sb.append("\n		<td rowspan='3'		width='"+sTdWidth+"' style='mso-number-format:\\@'>"+JSPUtil.getNull(vo.getIbCssmVoyNo())+"</td> ");
        		sb.append("\n		<td rowspan='3'		width='"+sTdWidth+"' style='mso-number-format:\\@'>"+JSPUtil.getNull(vo.getObCssmVoyNo())+"</td> ");
        		sb.append("\n		<td rowspan='3'		width='"+sTdWidth+"'>"+JSPUtil.getNull(vo.getVpsPortCd())+"</td> ");
        		sb.append("\n		<td rowspan='3'		width='"+sTdWidth+"'>"+JSPUtil.getNull(vo.getClptIndSeq())+"</td> ");
    		}
    		sb.append("\n		<td rowspan='1'		width='"+sTdWidth+"'>"+JSPUtil.getNull(vo.getType())+"</td> ");
    		//Laden data Loop
    		for(int i=1 ; i <= iLdnColSpan -1 ; i++){
    			String tmpMethodName = "getFQty"+i;
    			String tmpValue = (String) callMethod(vo, tmpMethodName);
    			sb.append("\n		<td rowspan='1'		 width='"+sTdWidth+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(tmpValue, "0")))+"</td> ");
            }
    		sb.append("\n		<td rowspan='1'		width='"+sTdWidth+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getVoidQty(), "0")))+"</td> ");
    		
    		//Empty data Loop
    		for(int i=1 ; i <= iEtyColSpan ; i++){
    			String tmpMethodName = "getEQty"+i;
    			String tmpValue = JSPUtil.getNull((String) callMethod(vo, tmpMethodName), "0");
    			sb.append("\n		<td rowspan='1'		width='"+sTdWidth+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(tmpValue, "0")))+"</td> ");
            }
    		sb.append("\n		<td width='"+sTdWidth+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getWeight())))+"</td> ");
    		if(isRowSpan){
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getSumTotalTeu() 	, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getSumLdnTeu() 	, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getSumEtyTeu()	, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getSumWgtTon()	, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getSumWgtTeu()	, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getSumTeuByWgt()	, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getSumRfPlug()	, "0")))+"</td> ");
    			                                                                                                                                              
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getAllocSlot()	, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getAllocRf()		, "0")))+"</td> ");
    			                                                                                                                                              
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getBsSlot()		, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getBsRf()			, "0")))+"</td> ");
    			                                                                                                                                              
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getExcTeuTotal()	, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getExcTeuLdn()	, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getExcTeuEty()	, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getExcDwtTeu()	, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getExcDwtRf()		, "0")))+"</td> ");
    			                                                                                                                                              
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getPriSlot()		, "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getPriPlug()		, "0")))+"</td> ");
    			
    			
    			dTotalAmout += Double.parseDouble(JSPUtil.getNull(vo.getAmtBuyExcSlots(), "0"));
    			dTotalAmout += Double.parseDouble(JSPUtil.getNull(vo.getAmtUsedPlugs()	, "0"));
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getAmtBuyExcSlots(), "0")))+"</td> ");
    			sb.append("\n		<td rowspan='3'		style='"+sTdDataSytle+"'>"+getNumFormat(Double.parseDouble(JSPUtil.getNull(vo.getAmtUsedPlugs()	 , "0")))+"</td> ");
    		}
    		sb.append("\n	</tr> ");
    		
    		//동일 그룹을 찾기 위한 Key 값.
    		tmpOrd = vo.getOrd();
    		
    	}
    	//=============================== Operation Summary Report Data   E n d ==========================================
    	sb.append("\n</table>                                                             ");
    	
    	int iTotalColSpan = 6 + iLdnColSpan + iEtyColSpan + 20;
    	String sTotalTableStyle = "font-family:arial,Gulim; font-size: 13pt;font-weight:bold; ";
    	sb.append("\n<table border='0' style='"+sTotalTableStyle+"'>");
    	sb.append("\n	<tr> ");
    	sb.append("\n		<td colspan='"+iTotalColSpan+"' width='"+sTdWidth+"' align='right'>TOTAL AMOUNT :</td>");
    	sb.append("\n		<td colspan='2' width='"+sTdWidth+"' align='center' style='text-decoration:underline;'>"+getNumFormat(dTotalAmout)+"</td>");
    	sb.append("\n	</tr> ");
    	sb.append("\n</table> ");
    	log.debug("\n############################## getSummaryExcel Start###########################");
    	log.debug("\n"+sb.toString());
    	log.debug("\n############################## getSummaryExcel E n d###########################");
    	return sb.toString();
    }
    
    /**
     * Object callMethod
     * @param obj
     * @param methodName
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object callMethod(Object obj, String methodName) {
    	Class c = obj.getClass();
    	try {
    		Method m = c.getMethod(methodName, new Class[] {});
    		return m.invoke(obj, new Object[] {});
    	} catch (Exception e) {
    		return null;
    	}
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
