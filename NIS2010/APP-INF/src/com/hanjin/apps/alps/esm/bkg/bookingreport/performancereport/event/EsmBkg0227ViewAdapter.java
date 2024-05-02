/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0227ViewAdapter.java
*@FileTitle : TRO Status List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.13 김기종
* 1.0 Creation
* -------------------------------------------------------
* History
* 오동현 [][BKG /REPORT] 조회된 GRID에서 하단 GRAND TOTAL 수정
* 2012.02.15 김보배 [CHM-201216103] [BKG] e-SI PFMC Report 수정 요청
* 2013.01.18 김진주 [CHM-201322383] [eSVC PFMC report] 평가 기준 변경 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.EBkgSiPfmcInVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Kim Ki Jong
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg0227ViewAdapter extends ViewAdapter {

	/**
	 * makeSum
	 * 
	 * @param String a
	 * @param String b
	 * @return String
	 */	
	public String makeSum(String a, String b){
		int sum =0;
		
		sum = Integer.parseInt(JSPUtil.getNull(a,"0")) + Integer.parseInt(JSPUtil.getNull(b,"0"));
		return String.valueOf(sum);
	}
	
	/**
	 * stringToDouble
	 * 
	 * @param String input
	 * @return double
	 */	
	public static double stringToDouble(String input){
        if(input == null)
            input = "0.0";
        if(input.equals(""))
            input = "0.0";
        if(input.indexOf(".") < 0)
            input = input + ".0";
        double dBmQty = Double.parseDouble(input);
        return dBmQty;
    }
	
	/**
	 * getRound
	 * 
	 * @param double dataDouble
	 * @param int seat
	 * @return BigDecimal
	 */	
	public static BigDecimal getRound(double dataDouble, int seat){

        BigDecimal bd = new BigDecimal(dataDouble);
        bd = bd.setScale(seat, BigDecimal.ROUND_HALF_UP);

        return bd;

    }
	
	/**
	 * getRound
	 * 
	 * @param String type
	 * @param EBkgSiPfmcInVO vo
	 * @return String
	 */	
	public String makeSvc(String type, EBkgSiPfmcInVO vo){
		Double sum = 0.0;
		
		if (type.equals("BKG")){
			/*= (EDI +  WEB + GTN + INT + CSM + DSK 비율) / TTL BKG * 100*/
			if (!vo.getBkgTtl().equals("0")){
				sum = (stringToDouble(vo.getBkgEdi()) + stringToDouble(vo.getBkgWeb()) 
					+ stringToDouble(vo.getBkgGtn()) + stringToDouble(vo.getBkgDesktop()) 
					+ stringToDouble(vo.getBkgInttra()) + stringToDouble(vo.getBkgCsm())
					+ stringToDouble(vo.getBkgSim())) 
					/ stringToDouble(vo.getBkgTtl()) * 100;
			}
		}else if (type.equals("SI")){
			if (!vo.getSiTtl().equals("0")){
				sum = (stringToDouble(vo.getSiEdi())
						+ stringToDouble(vo.getSiWeb()) + stringToDouble(vo.getSiGtn()) 
						+ stringToDouble(vo.getSiDesktop()) + stringToDouble(vo.getSiInttra()) 
						+ stringToDouble(vo.getSiCsm()) + stringToDouble(vo.getSiSim())
						+ stringToDouble(vo.getSiEml()) + stringToDouble(vo.getSiUld()))
						/ stringToDouble(vo.getSiTtl()) * 100;
			}
		}else if (type.equals("BL")){
			/*={EDI + WEB OBL + WEB Waybill + SWB Email / (TTL OBL + TTL SWB)} * 100*/
			if (!vo.getBlTtlObl().equals("0")){
//				sum = (stringToDouble(vo.getBlPending()) + stringToDouble(vo.getBlEdi()) + stringToDouble(vo.getBlWebObl()) 
//						+ stringToDouble(vo.getBlWebSwb()) + stringToDouble(vo.getBlSwbEmail()) ) 
//						/ stringToDouble(vo.getSiTtl()) * 100; --> stringToDouble(vo.getBlPending())제거 NIS 로직 참조 2010/09/09 오동현
				sum = (stringToDouble(vo.getBlEdi()) + stringToDouble(vo.getBlWebObl()) 
						+ stringToDouble(vo.getBlWebSwb()) + stringToDouble(vo.getBlSwbEmail()) ) 
						/ stringToDouble(vo.getSiTtl()) * 100;
			}
		}
		return String.valueOf(getRound(sum,1));
	}
	
	
	/**
	 * makeHjstools
	 * 
	 * @param String type
	 * @param EBkgSiPfmcInVO vo
	 * @return String
	 */
	public String makeHjstools(String type, EBkgSiPfmcInVO vo){
		Double sum = 0.0;
		
		if (type.equals("BKG")){
			/* =( EDI + WEB + DSK ) / Total S/I * 100		*/
			if (!vo.getBkgTtl().equals("0")){
				sum = (stringToDouble(vo.getBkgEdi()) + stringToDouble(vo.getBkgWeb()) 
					+ stringToDouble(vo.getBkgDesktop()) + stringToDouble(vo.getBkgSim()) ) 
					/ stringToDouble(vo.getBkgTtl()) * 100;
			}
		} else if (type.equals("SI")){
			/* =( EDI + WEB + SIM + DSK ) / Total S/I * 100		*/
			if (!vo.getSiTtl().equals("0")){
				sum = (stringToDouble(vo.getSiEdi())
					+ stringToDouble(vo.getSiWeb()) + stringToDouble(vo.getSiSim()) 
					+ stringToDouble(vo.getSiDesktop()) + stringToDouble(vo.getSiEml())
					+ stringToDouble(vo.getSiUld()) ) / stringToDouble(vo.getSiTtl()) * 100;
			}
		}
		return String.valueOf(getRound(sum,1));
	}
	
	
	/**
	 * makePortal
	 * 
	 * @param String type
	 * @param EBkgSiPfmcInVO vo
	 * @return String
	 */
	public String makePortal(String type, EBkgSiPfmcInVO vo){
		Double sum = 0.0;
		
		if (type.equals("BKG")){
			/* =( GTN + INT + CSM ) / Total S/I * 100		*/
			if (!vo.getBkgTtl().equals("0")){
				sum = (stringToDouble(vo.getBkgGtn()) + stringToDouble(vo.getBkgInttra()) 
					 + stringToDouble(vo.getBkgCsm())) 
					/ stringToDouble(vo.getBkgTtl()) * 100;
			}
		} else if (type.equals("SI")){
			/* =( GTN + INT + CSM ) / Total S/I * 100		*/
			if (!vo.getSiTtl().equals("0")){
				sum = (stringToDouble(vo.getSiGtn()) + stringToDouble(vo.getSiInttra()) 
					 + stringToDouble(vo.getSiCsm())) 
					/ stringToDouble(vo.getSiTtl()) * 100;
			}
		}
		return String.valueOf(getRound(sum,1));
	}
	
	
	/**
	 * makeVo
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @param colValues
	 * @return EBkgSiPfmcInVO
	 */	
	public EBkgSiPfmcInVO makeVo(EBkgSiPfmcInVO vo, Map<String, String> colValues){

		vo.setBkgTtl(makeSum(vo.getBkgTtl(),JSPUtil.getNull(colValues.get("bkg_ttl"))));
		vo.setBkgNis(makeSum(vo.getBkgNis(),JSPUtil.getNull(colValues.get("bkg_nis"))));
		vo.setBkgEdi(makeSum(vo.getBkgEdi(),JSPUtil.getNull(colValues.get("bkg_edi"))));
		vo.setBkgWeb(makeSum(vo.getBkgWeb(),JSPUtil.getNull(colValues.get("bkg_web"))));
		vo.setBkgSim(makeSum(vo.getBkgSim(),JSPUtil.getNull(colValues.get("bkg_sim"))));
		vo.setBkgDesktop(makeSum(vo.getBkgDesktop(),JSPUtil.getNull(colValues.get("bkg_desktop"))));
		vo.setBkgGtn(makeSum(vo.getBkgGtn(),JSPUtil.getNull(colValues.get("bkg_gtn"))));
		vo.setBkgInttra(makeSum(vo.getBkgInttra(),JSPUtil.getNull(colValues.get("bkg_inttra"))));
		vo.setBkgCsm(makeSum(vo.getBkgCsm(),JSPUtil.getNull(colValues.get("bkg_csm"))));
		vo.setBkgHjstools(makeHjstools("BKG", vo));
		vo.setBkgPortal(makePortal("BKG", vo));
		vo.setBkgSvc(makeSvc("BKG", vo));
		
		vo.setSiTtl(makeSum(vo.getSiTtl(),JSPUtil.getNull(colValues.get("si_ttl"))));
		vo.setSiNis(makeSum(vo.getSiNis(),JSPUtil.getNull(colValues.get("si_nis"))));
		vo.setSiEdi(makeSum(vo.getSiEdi(),JSPUtil.getNull(colValues.get("si_edi"))));
		vo.setSiWeb(makeSum(vo.getSiWeb(),JSPUtil.getNull(colValues.get("si_web"))));
		vo.setSiSim(makeSum(vo.getSiSim(),JSPUtil.getNull(colValues.get("si_sim"))));
		vo.setSiDesktop(makeSum(vo.getSiDesktop(),JSPUtil.getNull(colValues.get("si_desktop"))));
		vo.setSiGtn(makeSum(vo.getSiGtn(),JSPUtil.getNull(colValues.get("si_gtn"))));
		vo.setSiInttra(makeSum(vo.getSiInttra(),JSPUtil.getNull(colValues.get("si_inttra"))));
		vo.setSiCsm(makeSum(vo.getSiCsm(),JSPUtil.getNull(colValues.get("si_csm"))));
		vo.setSiEml(makeSum(vo.getSiEml(),JSPUtil.getNull(colValues.get("si_eml"))));
		vo.setSiUld(makeSum(vo.getSiUld(),JSPUtil.getNull(colValues.get("si_uld"))));
		vo.setSiHjstools(makeHjstools("SI", vo));
		vo.setSiPortal(makePortal("SI", vo));
		vo.setSiSvc(makeSvc("SI", vo));
		
		vo.setBlTtlObl(makeSum(vo.getBlTtlObl(),JSPUtil.getNull(colValues.get("bl_ttl_obl"))));
		vo.setBlTtlSwb(makeSum(vo.getBlTtlSwb(),JSPUtil.getNull(colValues.get("bl_ttl_swb"))));
		vo.setBlNis(makeSum(vo.getBlNis(),JSPUtil.getNull(colValues.get("bl_nis"))));
		vo.setBlPending(makeSum(vo.getBlPending(),JSPUtil.getNull(colValues.get("bl_pending"))));
		vo.setBlEdi(makeSum(vo.getBlEdi(),JSPUtil.getNull(colValues.get("bl_edi"))));
		vo.setBlWebObl(makeSum(vo.getBlWebObl(),JSPUtil.getNull(colValues.get("bl_web_obl"))));
		vo.setBlWebSwb(makeSum(vo.getBlWebSwb(),JSPUtil.getNull(colValues.get("bl_web_swb"))));
		vo.setBlSwbEmail(makeSum(vo.getBlSwbEmail(),JSPUtil.getNull(colValues.get("bl_swb_email"))));
		vo.setBlSvc(makeSvc("BL", vo));
		
		return vo;
	}
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param List<AbstractValueObject> vos
	 * @param String prefix
	 * @return String <Data>태그 부분의 XML문자열
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);

		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		} 
		
		Map<String, String> colValues = null;
		Map<String, String> colValues2 = null;
		String tempSubTotalRegion = "";
		String tempSubTotalGso = "";
		String reportType="";
		
		EBkgSiPfmcInVO regionVo = new EBkgSiPfmcInVO();
		EBkgSiPfmcInVO gsoVo = new EBkgSiPfmcInVO();
		EBkgSiPfmcInVO totVo = new EBkgSiPfmcInVO();
		
		sbufXML.append("<SHEET>\n");
		//토탈 개수 조정
		sbufXML.append("\n<DATA TOTAL='").append(totCnt).append("'>\n");
		for(int i=0;i<realCnt;i++){
			colValues = vos.get(i).getColumnValues();
			if ( i < realCnt-1){
				colValues2 = vos.get(i+1).getColumnValues();
				tempSubTotalRegion =colValues2.get("region_cd");
				tempSubTotalGso =colValues2.get("gso");
			}else{
				if (i ==0){
					tempSubTotalRegion = colValues.get("region_cd");
					tempSubTotalGso = colValues.get("gso");
				}else{
					tempSubTotalRegion = "";
					tempSubTotalGso = "";
				}
			}
			reportType =  JSPUtil.getNull(colValues.get("report_type"));
			regionVo = makeVo(regionVo,colValues);
			gsoVo = makeVo(gsoVo,colValues);
			totVo = makeVo(totVo,colValues);
			
			sbufXML.append("	<TR >\n");
			sbufXML.append("		<TD><![CDATA[").append("R").append("]]></TD>\n");
			if (reportType.equals("CR")){
				sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("sc_rfa_no"))).append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cust_nm"))).append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("prop_ofc_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("ob_sls_ofc_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("ob_srep_cd"))).append("]]></TD>\n");

			}
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("region_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("gso"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("ofc_cd"))).append("]]></TD>\n"); 
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("duration"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_ttl"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_nis"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_edi"))).append("]]></TD>\n");    
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_web"))).append("]]></TD>\n");    
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_sim"))).append("]]></TD>\n");     
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_desktop"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_gtn"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_inttra"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_csm"))).append("]]></TD>\n"); 
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_hjstools"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_portal"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_svc"))).append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_ttl"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_nis"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_edi"))).append("]]></TD>\n"); 
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_web"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_sim"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_desktop"))).append("]]></TD>\n");    
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_eml"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_uld"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_gtn"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_inttra"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_csm"))).append("]]></TD>\n"); 
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_hjstools"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_portal"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("si_svc"))).append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bl_ttl_obl"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bl_ttl_swb"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bl_nis"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bl_pending"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bl_edi"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bl_web_obl"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bl_web_swb"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bl_swb_email"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bl_svc"))).append("]]></TD>\n");
			
			
			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");
			
			/*sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
			sbufXML.append("	</TR>\n");*/
			
			if(!reportType.equals("CR") && !JSPUtil.getNull(colValues.get("gso")).equals(tempSubTotalGso)){
				/*sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");*/
				
				sbufXML.append(" <TR BOLD=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("D").append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("region_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("gso"))).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("SubTotal").append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("(GSO)").append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgTtl()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgNis()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgEdi()).append("]]></TD>\n");    
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgWeb()).append("]]></TD>\n");     
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgSim()).append("]]></TD>\n");    
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgDesktop()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgGtn()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgInttra()).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgCsm()).append("]]></TD>\n"); 
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgHjstools()).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgPortal()).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBkgSvc()).append("]]></TD>\n");
				
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiTtl()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiNis()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiEdi()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiWeb()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiSim()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiDesktop()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiEml()).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiUld()).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiGtn()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiInttra()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiCsm()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiHjstools()).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiPortal()).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSiSvc()).append("]]></TD>\n");
				
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBlTtlObl()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBlTtlSwb()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBlNis()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBlPending()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBlEdi()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBlWebObl()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBlWebSwb()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBlSwbEmail()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBlSvc()).append("]]></TD>\n");
				
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
				
				
				/*sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");*/
				
				gsoVo = new EBkgSiPfmcInVO(); 
			}
//			if(!reportType.equals("CR") &&  !JSPUtil.getNull(colValues.get("region_cd")).equals(tempSubTotalRegion)){
//				/*sbufXML.append(" <TR >\n");
//				sbufXML.append("	</TR>\n");
//				sbufXML.append("	\n");*/
//				
//				sbufXML.append(" <TR BOLD=\"TRUE\" BGCOLOR=\"255,192,192\">\n");
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("D").append("]]></TD>\n");
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("region_cd"))).append("]]></TD>\n");
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("gso"))).append("]]></TD>\n");
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("SubTotal").append("]]></TD>\n"); 
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("(Region)").append("]]></TD>\n");   
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBkgTtl()).append("]]></TD>\n");   
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBkgNis()).append("]]></TD>\n");  
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBkgEdi()).append("]]></TD>\n");    
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBkgWeb()).append("]]></TD>\n");     
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBkgGtn()).append("]]></TD>\n");   
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBkgInttra()).append("]]></TD>\n");
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBkgCsm()).append("]]></TD>\n"); 
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBkgDesktop()).append("]]></TD>\n");  
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBkgSvc()).append("]]></TD>\n");
//				
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSiTtl()).append("]]></TD>\n");   
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSiNis()).append("]]></TD>\n");  
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSiEdi()).append("]]></TD>\n");   
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSiWeb()).append("]]></TD>\n");  
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSiGtn()).append("]]></TD>\n");   
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSiInttra()).append("]]></TD>\n");  
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSiCsm()).append("]]></TD>\n");   
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSiDesktop()).append("]]></TD>\n");  
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSiSvc()).append("]]></TD>\n");
//				
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBlTtlObl()).append("]]></TD>\n");  
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBlTtlSwb()).append("]]></TD>\n");   
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBlNis()).append("]]></TD>\n");  
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBlPending()).append("]]></TD>\n");   
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBlEdi()).append("]]></TD>\n");  
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBlWebObl()).append("]]></TD>\n");   
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBlWebSwb()).append("]]></TD>\n");  
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBlSwbEmail()).append("]]></TD>\n");
//				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBlSvc()).append("]]></TD>\n");
//				
//				sbufXML.append("	</TR>\n");
//				sbufXML.append("	\n");
//				
//				
//				sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
//				sbufXML.append("	</TR>\n");
//				sbufXML.append("	\n");
//				regionVo = new EBkgSiPfmcInVO(); 
//			}
			
		}
		
		/*String tempSubTotalRegion = "";
		String tempSubTotalGso = "";*/
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>");
		sbufXML.append("		<ETC KEY='bkg_ttl'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBkgTtl())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='bkg_nis'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBkgNis())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='bkg_edi'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBkgEdi())).append("]]></ETC>\n");    
		sbufXML.append("		<ETC KEY='bkg_web'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBkgWeb())).append("]]></ETC>\n");    
		sbufXML.append("		<ETC KEY='bkg_sim'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBkgSim())).append("]]></ETC>\n");     
		sbufXML.append("		<ETC KEY='bkg_desktop'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBkgDesktop())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='bkg_gtn'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBkgGtn())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='bkg_inttra'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBkgInttra())).append("]]></ETC>\n");
		sbufXML.append("		<ETC KEY='bkg_csm'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBkgCsm())).append("]]></ETC>\n"); 
		sbufXML.append("		<ETC KEY='bkg_hjstools'><![CDATA[").append(totVo.getBkgHjstools()).append("]]></ETC>\n");
		sbufXML.append("		<ETC KEY='bkg_portal'><![CDATA[").append(totVo.getBkgPortal()).append("]]></ETC>\n");
		sbufXML.append("		<ETC KEY='bkg_svc'><![CDATA[").append(totVo.getBkgSvc()).append("]]></ETC>\n");
		sbufXML.append("		<ETC KEY='si_ttl'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSiTtl())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='si_nis'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSiNis())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='si_edi'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSiEdi())).append("]]></ETC>\n"); 
		sbufXML.append("		<ETC KEY='si_web'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSiWeb())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='si_sim'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSiSim())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='si_desktop'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSiDesktop())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='si_eml'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSiEml())).append("]]></ETC>\n"); 
		sbufXML.append("		<ETC KEY='si_uld'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSiUld())).append("]]></ETC>\n");
		sbufXML.append("		<ETC KEY='si_gtn'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSiGtn())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='si_inttra'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSiInttra())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='si_csm'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSiCsm())).append("]]></ETC>\n"); 
		sbufXML.append("		<ETC KEY='si_hjstools'><![CDATA[").append(totVo.getSiHjstools()).append("]]></ETC>\n");
		sbufXML.append("		<ETC KEY='si_portal'><![CDATA[").append(totVo.getSiPortal()).append("]]></ETC>\n");
		sbufXML.append("		<ETC KEY='si_svc'><![CDATA[").append(totVo.getSiSvc()).append("]]></ETC>\n");
		sbufXML.append("		<ETC KEY='bl_ttl_obl'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBlTtlObl())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='bl_ttl_swb'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBlTtlSwb())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='bl_nis'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBlNis())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='bl_pending'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBlPending())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='bl_edi'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBlEdi())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='bl_web_obl'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBlWebObl())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='bl_web_swb'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBlWebSwb())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='bl_swb_email'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBlSwbEmail())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='bl_svc'><![CDATA[").append(totVo.getBlSvc()).append("]]></ETC>\n");
		 
		sbufXML.append("</ETC-DATA>");
		
		sbufXML.append("</SHEET>\n");
		/*sbufXML.append("|$$|<SHEET>\n");
		sbufXML.append(makeDataTagDefault(vos, prefix));
		sbufXML.append("</SHEET>\n");*/
		return sbufXML.toString();
	}

    private String getStartTag(boolean isFirstSheet, boolean isSave, GeneralEventResponse eventResponse)
    {
        StringBuilder sb = new StringBuilder();
        if(isFirstSheet)
        {
            if(isSave)
            {
                sb.append("<RESULT>\n");
                sb.append("<TR-ALL>OK</TR-ALL>\n");
            } else
            {
                sb.append("<SHEET>\n");
            }
            sb.append(getETCData(eventResponse));
            sb.append(getUserMessageXML(eventResponse));
        } else
        {
            sb.append("|$$|<SHEET>\n");
        }
        return sb.toString();
    }
    private String getEndTag(StringBuilder sb)
    {
        String endTag = "";
        String tmp = sb.toString();
        int sheetLoc = tmp.lastIndexOf("<SHEET>");
        int resultLoc = tmp.lastIndexOf("<RESULT>");
        if(sheetLoc > resultLoc)
            endTag = "</SHEET>\n";
        else
            endTag = "</RESULT>\n";
        return endTag;
    }	
    
    
	@SuppressWarnings("unchecked")
	   private String makeSuccessXML(boolean isUpload, HttpServletRequest request, GeneralEventResponse eventResponse)
	    {
	        Event event = (Event)request.getAttribute("Event");
	        boolean isSave = isSaveCommand(event);
	        StringBuilder sb = new StringBuilder();
	        List rsVoList = eventResponse.getRsVoList();
	        //int cnt = rsVoList.size();
	        //String preVOName = "";
	        boolean isFirstSheet = true;
	        //List voList = new ArrayList();
	        String prefixs[] = getPrefixFromHttp(request);
	        List dataCntList = eventResponse.getDataCntList();
	        if(isUpload)
	            sb.append("<pre>\n");
	        int setExeCnt = dataCntList.size();
	        Iterator it = rsVoList.iterator();
	        int curLoc = 0;
	        for(int i = 0; i < setExeCnt; i++)
	        {
	            int voCnt = ((Integer)dataCntList.get(i)).intValue();
	            if(voCnt == 0)
	            {
	                sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append("\t<DATA  TOTAL='0'>\n");
	                sb.append("\t</DATA>\n");
	                sb.append(getEndTag(sb));
	                isFirstSheet = false;
	            } else
	            if(rsVoList.get(curLoc) instanceof DBRowSet)
	            {
	                sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append(makeDataTag((DBRowSet)it.next(), prefixs[i]));
	                sb.append(getEndTag(sb));
	                curLoc++;
	                isFirstSheet = false;
	            } else
	            {
	                List tmpList = new ArrayList();
	                for(int j = 0; j < voCnt; j++)
	                {
	                    Object obj = it.next();
	                    tmpList.add(obj);
	                    curLoc++;
	                }

	               // sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append(makeDataTag(tmpList, prefixs[i]));
	                //sb.append(getEndTag(sb));
	                removeListAllElements(tmpList);
	                isFirstSheet = false;
	            }
	        }

	        if(isUpload)
	            sb.append("</pre>\n");
	        return sb.toString();
	    }
	   
	/**
	 * makeXML
	 * 
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return String
	 */	
	 public String makeXML(HttpServletRequest request, HttpServletResponse response)
	    {
	        Event event = null;
	        GeneralEventResponse eventResponse = null;
	        Exception serverException = null;
	        String strXML = "";
	        boolean isupload = isUploadFile(request);
	        try
	        {
	            serverException = (Exception)request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT");
	            if(serverException != null)
	            {
	                strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
	            } else
	            {
	                boolean isUpload = isUploadFile(request);
	                event = (Event)request.getAttribute("Event");
	                eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
	                //List rsVoList = null;
	                boolean isSave = isSaveCommand(event);
	                if(eventResponse != null)
	                {
	                    //rsVoList = eventResponse.getRsVoList();
	                    if(eventResponse.getDataCntList().size() == 0)
	                        strXML = getNoSearchResultXML(isUpload, isSave, eventResponse);
	                    else
	                        strXML = makeSuccessXML(isUpload, request, eventResponse);
	                }
	            }
	        }
	        catch(Exception ex)
	        {
	            log.error(ex.getMessage(), ex);
	            strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), isupload);
	        }
	        if(log.isDebugEnabled())
	            log.debug((new StringBuilder("\n")).append(strXML).toString());
	        return strXML;
	    }
	 
	 	private boolean isUploadFile(HttpServletRequest request)
	    {
	        boolean isUpload = false;
	        String contentType = request.getContentType();
	        if(contentType != null && contentType.startsWith("multipart/form-data"))
	            isUpload = true;
	        return isUpload;
	    }	 
	 	

		/**
		 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
		 * 
		 * @param vos List<AbstractValueObject> List 객체
		 * @param colOrder String[] Column명 문자열 
		 * @param prefix String IBSheet savename's prefix
		 * @return String <Data>태그 부분의 XML문자열
		 * @exception 
		 */	
		protected String makeDataTagDefault(List<AbstractValueObject> vos, String prefix) {
			StringBuilder sbufXML = new StringBuilder();
			
			int totCnt = vos.size();
			int realCnt = vos.size();

			AbstractValueObject vo = (AbstractValueObject)vos.get(0);
			String[] realColNms=getColHeader(vo);
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			if(vo.getMaxRows()>0){
				totCnt = vo.getMaxRows();
			}
			
			sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");

			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues();
				
				sbufXML.append("	<TR><![CDATA[");
				int colCnt = realColNms.length;
				
				for (int j = 0 ; j < colCnt-1 ; j++) {
					sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
		        }
				sbufXML.append(getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
			}
			sbufXML.append("</DATA>\n");
			
			return sbufXML.toString();
		}	

		/**
		 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
		 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
		 * 
		 * @param rs DBRowSet 		VO객체
		 * @param prefix String 		IBSheet savename's prefix string
		 * @return String IBSheet 		<DATA>태그
		 * @exception 
		 */
		protected String makeDataTag(DBRowSet rs,String prefix) {
			StringBuilder sb = new StringBuilder();
			
			//Pivot Table인 경우 makePivotDataTag 실행하여  return한
			if(rs.isPivot()){
				sb.append(makePivotDataTag(rs));
				return sb.toString();
			}

			String[] realColNms = getColHeader(rs);

			try{
				String[] changedColNms = getChangedColNms(realColNms, prefix);
				
				sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
				
				int colCount = realColNms.length;
				
				while (rs.next()) { 
					sb.append("	<TR><![CDATA[");
					for (int j = 1 ; j < colCount ; j++) {
						sb.append(getNull(rs.getObject(j)) + DELIMITER);
					}	
					sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
				}
				sb.append("</DATA>\n");
			}catch(Exception ex){
				throw new RuntimeException(ex.getMessage());
			}
			return sb.toString();
		}
		/**
		 * Pivot Table용 Data tag를 생성한다.<br>
		 * 
		 * @param rs			DBRowSet 		VO객체
		 * @return String 	IBSheet 			<DATA>태그
		 * @exception 
		 */
		protected String makePivotDataTag(DBRowSet rs) {
			StringBuilder sb = new StringBuilder();
			int colCnt = 0;
			int rowCnt = rs.getRowCount();
			
			String[][] arrRowSet = null;

			try{
				colCnt = rs.getMetaData().getColumnCount();
				arrRowSet = new String[rowCnt][colCnt];
				
				int rowIdx = 0;
				while (rs.next()) { 
					for (int j = 1 ; j <= colCnt ; j++) {
						arrRowSet[rowIdx][j-1] = getNull(rs.getObject(j)).toString();
					}
					rowIdx++;
				}
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new RuntimeException(ex.getMessage());
			}
			
			try{
				sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
				if(rowCnt>0){
					for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
						sb.append("	<TR><![CDATA[");
						for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
							sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
						}
						sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
					}//end for coIdx
				}//end for roIdx
				sb.append("</DATA>\n");
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new RuntimeException(ex.getMessage());
			}
			return sb.toString();
		}
		
		 protected String getETCData(EventResponse eventResponse)
	    {
	        if(eventResponse == null)
	            return "";
	        StringBuilder sb = new StringBuilder();
	        Map<String,String> etc_data = eventResponse.getETCData();
	        sb.append("<ETC-DATA>\n");
	        if(etc_data != null && etc_data.size() > 0)
	        {
	            String key;
	            String val;
	            for(Iterator<String> it = etc_data.keySet().iterator(); it.hasNext(); sb.append((new StringBuilder("<ETC KEY='")).append(key).append("'><![CDATA[").append(val).append("]]></ETC>\n").toString()))
	            {
	                key = (String)it.next();
	                val = (new StringBuilder()).append((String)etc_data.get(key)).toString();
	            }

	        }
	        sb.append(getPivotETCData(eventResponse));
	        sb.append("</ETC-DATA>\n");
	        return sb.toString();
	    }

}
