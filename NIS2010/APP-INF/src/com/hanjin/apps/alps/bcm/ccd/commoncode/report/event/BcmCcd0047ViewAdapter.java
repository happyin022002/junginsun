/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BcmCcd0047ViewAdapter.java
*@FileTitle : BcmCcd0047ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2014.04.16 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.event;
 
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.ZoneReportVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class BcmCcd0047ViewAdapter extends ViewAdapter {
    public BcmCcd0047ViewAdapter(){
    	super();
    }

	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  <br>
	 * 
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return String
	 * @exception EventException
	 */	 
    
    @SuppressWarnings("unchecked")
	public String makeXML(HttpServletRequest request, HttpServletResponse response) {
    	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse"); 
 		
 		StringBuilder strBuilder = new StringBuilder();
 		List<ZoneReportVO> list = null;
 		ZoneReportVO vo = null;
    	String savedName = "BCM_CCD_0047DL.csv";  
 		
    	list = ((List<ZoneReportVO>)eventResponse.getRsVoList());
    	
		try{			
    		
 			response.setContentType("application/vnd.ms.excel");
 			String strClient = request.getHeader("user-agent");
 
 			if (strClient.indexOf("MSIE 5.5") != -1) {
 				response.setHeader("Content-Type",
 						"doesn/matter; charset=euc-kr");
 				response.setHeader("Content-Disposition", "filename="
 						+ savedName + "; charset=euc-kr");
 			} else {
 				response.setHeader("Content-Type",
 						"application/octet-stream; charset=euc-kr");
 				response.setHeader("Content-Disposition",
 						"attachment;filename=" + savedName + ";");
 			} 
 			

//			//엑셀 파일을 만듬
// 			ServletOutputStream writer = response.getOutputStream();
//
//			
//		//	PrintWriter fileOutput = new PrintWriter(new OutputStreamWriter(writer, "utf-8"));
//			
//			PrintStream fileOutput = new PrintStream(writer, true, "utf-8");

    		PrintWriter pout = response.getWriter();
    		
    		strBuilder.append("Zone Code,Name,Cargo Handling Time(Hours),Transit Time(Hours),Rep.CY,Distance(Zone to Rep CY),Unit,Delete Flag, Create User, Create Date/Time, Last Update User, Last Update Date/Time");
    		strBuilder.append("\n");
    		String rgx = "[,\\r\\n]";
    		for(int i = 0 ; i < list.size() ; i++){
    			vo = list.get(i);

    			strBuilder.append(JSPUtil.getNull(vo.getZnCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getZnNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCgoHndlTmHrs()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getTztmHrs()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRepYdCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLnkDist()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDistUtCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDeltFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCreUsrId()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCreDt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getUpdUsrId()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getUpdDt()).trim().replaceAll(rgx, " "));
				strBuilder.append("\n");
			}
    		
			pout.print(strBuilder.toString());
			pout.flush();
			pout.close();
			
//			//Excel Write
//			HSSFWorkbook workbook = new HSSFWorkbook();
//
//			HSSFSheet sheet = workbook.createSheet("Sheet1");
//
//			//Font 설정.
//			HSSFFont font = workbook.createFont();
//			font.setFontName(HSSFFont.FONT_ARIAL);
//
//			//제목의 스타일 지정
//			HSSFCellStyle titlestyle = workbook.createCellStyle();
//			titlestyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
//			titlestyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//			titlestyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//			titlestyle.setFont(font);
//			
//			//Row 생성
//			HSSFRow row = sheet.createRow((int)0);
//			//Cell 생성
//			HSSFCell cell1 = row.createCell((int)0);
//			cell1.setCellValue("Zone Code");
//			cell1.setCellStyle(titlestyle);
//
//			HSSFCell cell2 = row.createCell((int)1);
//			cell2.setCellValue("Name");
//			cell2.setCellStyle(titlestyle);
//
//			HSSFCell cell3 = row.createCell((int)2);
//			cell3.setCellValue("Cargo Handling Time(Hours)");
//			cell3.setCellStyle(titlestyle);
//
//			HSSFCell cell4 = row.createCell((int)3);
//			cell4.setCellValue("Transit Time(Hours)");
//			cell4.setCellStyle(titlestyle);
//
//			HSSFCell cell5 = row.createCell((int)4);
//			cell5.setCellValue("Rep.CY");
//			cell5.setCellStyle(titlestyle);
//
//			HSSFCell cell6 = row.createCell((int)5);
//			cell6.setCellValue("Distance(Zone to Rep CY)");
//			cell6.setCellStyle(titlestyle);
//
//			HSSFCell cell7 = row.createCell((int)6);
//			cell7.setCellValue("Unit");
//			cell7.setCellStyle(titlestyle);
//
//			HSSFCell cell8 = row.createCell((int)7);
//			cell8.setCellValue("Delete Flag");
//			cell8.setCellStyle(titlestyle);
//
//
//			//내용 스타일 지정
//			HSSFCellStyle style = workbook.createCellStyle();
//			style.setFont(font);
//
//			//내용중 가운데 정렬 추가
//			HSSFCellStyle styleCenter = workbook.createCellStyle();
//			styleCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//			styleCenter.setFont(font);
//
//			for (int i=0; i<list.size();i++){
//			    row = sheet.createRow((int)(i+1));
//			    
//    			vo = list.get(i);
//
//			    cell1 = row.createCell((int)0 );
//			    cell1.setCellValue(JSPUtil.getNull(vo.getZnCd()).trim().replaceAll(rgx, " "));
//			    cell1.setCellStyle(styleCenter);
//			    
//			    cell2 = row.createCell((int)1);
//			    cell2.setCellValue(JSPUtil.getNull(vo.getZnNm()).trim().replaceAll(rgx, " "));
//			    cell2.setCellStyle(style);
//			    
//			    cell3 = row.createCell((int)2);
//			    cell3.setCellValue(JSPUtil.getNull(vo.getCgoHndlTmHrs()).trim().replaceAll(rgx, " "));
//			    cell3.setCellStyle(style);
//
//			    cell4 = row.createCell((int)3);
//			    cell4.setCellValue(JSPUtil.getNull(vo.getTztmHrs()).trim().replaceAll(rgx, " "));
//			    cell4.setCellStyle(style);
//
//			    cell5 = row.createCell((int)4);
//			    cell5.setCellValue(JSPUtil.getNull(vo.getRepYdCd()).trim().replaceAll(rgx, " "));
//			    cell5.setCellStyle(style);
//
//			    cell6 = row.createCell((int)5);
//			    cell6.setCellValue(JSPUtil.getNull(vo.getLnkDist()).trim().replaceAll(rgx, " "));
//			    cell6.setCellStyle(style);
//
//			    cell7 = row.createCell((int)6);
//			    cell7.setCellValue(JSPUtil.getNull(vo.getDistUtCd()).trim().replaceAll(rgx, " "));
//			    cell7.setCellStyle(style);
//			    
//			    cell8 = row.createCell((int)7);
//			    cell8.setCellValue(JSPUtil.getNull(vo.getDeltFlg()).trim().replaceAll(rgx, " "));
//			    cell8.setCellStyle(style);
//			}
//
//			// 실제 저장될 파일 이름
//
//			// 실제로 저장될 파일 풀 경로
////			File file = new File("경로" +"/", savedName);
//
//			workbook.write(fileOutput);
//            if (fileOutput != null) {
//    			fileOutput.flush();
//    			fileOutput.close();
//    			fileOutput = null;
//            }
//            writer.flush();
//            writer.close();

      //      ServletResponse servlet = new ServletResponseImpl();

        }    	
    	catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
		return "";
    }
    
    /*
 	 * (non-Javadoc)
 	 * 
 	 * @see
 	 * com.hanjin.framework.core.controller.ViewAdapter#makeDataTag(java.util
 	 * .List, java.lang.String)
 	 */
 	protected String makeDataTag(List<AbstractValueObject> arg0, String arg1) {
 		return null;
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see
 	 * com.hanjin.framework.core.controller.ViewAdapter#makeDataTag(com.hanjin
 	 * .framework.component.rowset.DBRowSet, java.lang.String)
 	 */
 	protected String makeDataTag(DBRowSet arg0, String arg1) {
 		return null;
 	}
}
