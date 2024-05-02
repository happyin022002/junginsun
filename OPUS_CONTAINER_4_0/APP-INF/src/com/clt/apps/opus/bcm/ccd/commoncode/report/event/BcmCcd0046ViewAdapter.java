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
package com.clt.apps.opus.bcm.ccd.commoncode.report.event;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.YardReportVO;
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
public class BcmCcd0046ViewAdapter extends ViewAdapter {
    public BcmCcd0046ViewAdapter(){
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
 		List<YardReportVO> list = null;
 		YardReportVO vo = null;
    	String savedName = "BCM_CCD_0046DL.csv";  
 		
    	list = ((List<YardReportVO>)eventResponse.getRsVoList());
		
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
    		
    		strBuilder.append("Yard Code,English Name,Yard Character,CY,Rail Ramp,Marine Terminal,CFS,Barge Ramp,Pseudo,Handling Vendor,Stevedoring Vendor,Security Vendor,Control Office,DEM/DET Office,DEM I/B Collect,DEM O/B Collect,Rep. Zone,Yard Ownership,Bonded,M&R Shop,E.I.R Service,Hub Yard,Arrival Notification,Dry average dwell hours,Dry min dwell hours,Reefer AVG dwell hours,Reefer min dwell hours,English Address,Customs No,C.E.O,P.I.C,E-Mail,Postal Code,International Tel No,Tel No,Fax No,Gate Open(Week),Gate Close(Week),Gate Open(Saturday),Gate Close(Saturday),Gate Open(Sunday),Gate Close(Sunday),Gate Open(Holiday),Gate Close(Holiday),Inner Rail,Cargo Closing Time,Qty,Length(m),Depth(m),Channel(m),TTL Space,Actual Space,Company Space,CFS Space,Reefer Receptacle 440(V),Reefer Receptacle 220(V),Reefer Receptacle Dual,Operation System,Post Panamax G/Crane,Panamax G/Crane,Transtrainer,Fork Lift,Straddle Carrier,Tractor,Top Lift,Terminal Chassis,Handling Year,H/D CAPA(/YR),G/C G. Product(/HR),H/D VOL TTL TEU,H/D VOL TTL BOX,H/D VOL TTL TEU(OWN),H/D VOL TTL BOX(OWN),Remarks,Legacy Code,Delete Flag, Create User, Create Date/Time, Last Update User, Last Update Date/Time");
    		strBuilder.append("\n");
    		String rgx = "[,\\r\\n]";
    		for(int i = 0 ; i < list.size() ; i++){
    			vo = list.get(i);
    			
    			strBuilder.append(JSPUtil.getNull(vo.getYdCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdChrCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdFctyTpCyFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdFctyTpRailRmpFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdFctyTpMrnTmlFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdFctyTpCfsFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdFctyTpBrgRmpFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdFctyTpPsdoYdFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getN1stVndrSeq()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getN2ndVndrSeq()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getN3rdVndrSeq()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getOfcCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDmdtOfcCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDemIbCltFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDemObCltFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRepZnCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdOshpCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getBdYdFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getMnrShopFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getEirSvcFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getHubYdFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRailArrNtfcFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDryAvgDwllHrs()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDryMinDwllHrs()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRfAvgDwllHrs()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRfMinDwllHrs()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdAddr()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdCstmsNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdCeoNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdPicNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdEml()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getZipCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getIntlPhnNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getPhnNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFaxNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getGateOpnHrmnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getGateClzHrmnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSatGateOpnHrmnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSatGateClzHrmnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSunGateOpnHrmnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSunGateClzHrmnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getHolGateOpnHrmnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getHolGateClzHrmnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdInrlFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdCgoClzHrmntMsg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getBrthNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdBrthLen()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdBrthAlngSdDesc()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdBrthDpthChnlKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdTtlSpc()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdActSpc()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdCoSpc()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdCfsSpc()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdRfRcpt440vKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdRfRcpt220vKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdRfRcptDulKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdOpSysCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdPstPgcKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdPgcKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getTrstrKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFrkKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdStrdlCrrKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdTrctKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdTopLftKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getTmlChssKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdHndlYr()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdHndlCapa()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getTmlProdKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdTtlVolTeuKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdTtlVolBxKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdCoVolTeuKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdCoVolBxKnt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getYdRmk()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getModiYdCd()).trim().replaceAll(rgx, " "));
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
				
				
				
				

//				strBuilder.append(JSPUtil.getNull(vo.getLocCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getN1stVndrCntCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				
//				strBuilder.append(JSPUtil.getNull(vo.getOnfHirYdFlg()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//
//
//				strBuilder.append(JSPUtil.getNull(vo.getBkgPodYdFlg()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getN2ndVndrCntCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getN3rdVndrCntCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getYdFctyTpBrgRmpFlg()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getBfrOfcCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//
//				
//				strBuilder.append(JSPUtil.getNull(vo.getRfAvgDwllHrs()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getBfrOfcCngDt()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getModiYdCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getRepYdTpCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getRfMinDwllHrs()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getRfYdFtHrs()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getDryAvgDwllHrs()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getDryMinDwllHrs()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getDryYdFtHrs()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getYdCtrlOfcAddr()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getYdCtrlOfcCtyNm()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getYdCtrlOfcSteCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getYdCtrlOfcZipCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getYdLocCtyNm()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getYdLocCtyNm()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getYdLocSteCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//
//				
//				strBuilder.append(JSPUtil.getNull(vo.getYdLoclLangNm()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getYdLoclLangAddr()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
 
			}
    		
			pout.print(strBuilder.toString());
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
