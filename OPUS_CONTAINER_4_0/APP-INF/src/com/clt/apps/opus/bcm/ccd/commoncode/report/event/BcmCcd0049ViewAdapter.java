/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BcmCcd0049ViewAdapter.java
*@FileTitle : BcmCcd0097ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.25
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2014.09.25 유제량
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.report.event;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.VesselReportVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.GeneralEventResponse;
/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class BcmCcd0049ViewAdapter extends ViewAdapter {
    public BcmCcd0049ViewAdapter(){
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
 		List<VesselReportVO> list = null;
 		VesselReportVO vo = null;
    	String savedName = "BCM_CCD_0049DL.csv";  
 		
    	list = ((List<VesselReportVO>)eventResponse.getRsVoList());
		
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
     		
    		PrintWriter pout = response.getWriter();
    		
    		strBuilder.append("Vessel Code,Ownership,Vessel Name(ENG),Vessel Name(Local),Carrier,New Built,Builder,Company,Build Area Name,Call Sign,");
    		strBuilder.append("Flag,Port Of Registry,Class,Class No,IMO No(LLOYD No),Hull No,Crew Count,P&I CLUB,EDI Vessel Name,Tel No,");
    		strBuilder.append("Fax,TLX,E-Mail,Registered No,Feeder Division,Common Vessel,Keel Laid Date,Launched Date,Delivered Date,Registered Date,");
    		strBuilder.append("Close Date,Vessel Remark,CNTR Capacity-Design,CNTR Capacity-Operation,CNTR Capacity-Panama,CNTR Capacity-OPER(R/F),CNTR Capacity-Max(R/F),CNTR Capacity-Vessel Class(TEU),CNTR Capacity-Total TEU,CNTR Capacity-Hatch CNT,");
    		strBuilder.append("CNTR Capacity-Hold CNT,Dimension(M)-L.O.A,Dimension(M)-L.B.P,Dimension(M)-Breadth,Dimension(M)-Depth,Dimension(M)-Height,Dimension(M)-Summer Draft,Dimension(M)-Freeboard,Speed(Knots)-Economy,Speed(Knots)-Service,");
    		strBuilder.append("Speed(Knots)-Max,Others(MT)-Displacement,Others(MT)-Dead Weight,Others(MT)-Light Ship,International-Gross Ton,Panama-Gross Ton,Suez-Gross Ton,ITC,International - Net Ton,Panama - Net Ton,");
    		strBuilder.append("Suez - Net Ton,Suez - Net Ton (Maiden Voyage),Capacity(CBM)-F.O,Capacity(CBM)-D.O,Capacity(CBM)-F.W,Capacity(CBM)-Ballast,Consumption(MT)-F.O,Consumption(MT)-D.O,Consumption(MT)-F.W,Main Engine-Maker,");
    		strBuilder.append("Main Engine-Type,Main Engine-B.H.P,Main Engine-R.P.M,Bow Thruster-Maker,Bow Thruster-Type,Bow Thruster-B.H.P,BOW Thruster-R.P.M,Generator Engine-Maker,Generator Engine-Type,Generator Engine-B.H.P,");
    		strBuilder.append("Generator Engine-R.P.M,Delete Flag, Create User, Create Date/Time, Last Update User, Last Update Date/Time, VIP Code");
    		strBuilder.append("\n");
    		String rgx = "[,\\r\\n]";
    		for(int i = 0 ; i < list.size() ; i++){
    			vo = list.get(i); 

    			strBuilder.append(JSPUtil.getNull(vo.getVslCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslOwnIndCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslEngNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslLoclNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCrrCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslBldCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslBldrNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCoCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslBldAreaNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCallSgnNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslRgstCntCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRgstPortCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getClssNoRgstAreaNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslClssNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLloydNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslHlNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCrwKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getPiclbDesc()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslEdiNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getPhnNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFaxNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getTlxNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslEml()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRgstNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFdrDivCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslClssFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslKelLyDt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslLnchDt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslDeDt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRgstDt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslClzDt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslRmk()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCntrDznCapa()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCntrOpCapa()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCntrPnmCapa()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRfRcptKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRfRcptMaxKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCntrVslClssCapa()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getTtlTeuKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslHtchKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslHldKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLoaLen()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLbpLen()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslWdt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslDpth()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslHgt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSmrDrftHgt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFbdCapa()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getEcnSpd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVslSvcSpd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getMaxSpd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDplCapa()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDwtWgt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLgtShpTongWgt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getGrsRgstTongWgt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getPnmGtWgt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSuzGtWgt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getIntlTongCertiFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getNetRgstTongWgt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getPnmNetTongWgt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSuzNetTongWgt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getMadnVoySuzNetTongWgt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFoilCapa()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDoilCapa()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFrshWtrCapa()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getBlstTnkCapa()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFoilCsm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDoilCsm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFrshWtrCsm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getMnEngMkrNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getMnEngTpDesc()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getMnEngBhpPwr()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getMnEngRpmPwr()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getBwthstMkrNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getBwthstTpDesc()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getBwthstBhpPwr()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getBwthstRpmPwr()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getGnrMkrNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getGnrTpDesc()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getGnrBhpPwr()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getGnrRpmPwr()).trim().replaceAll(rgx, " "));
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
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getModiVslCd()).trim().replaceAll(rgx, " "));
				strBuilder.append("\n");
			}
			//pout.print(strBuilder.toString());
			pout.append((CharSequence)strBuilder);
			pout.flush();
			pout.close();
    				    
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
