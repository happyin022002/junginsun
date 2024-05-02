/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : GEMPlanningPerformanceFns0510001WSProxy.java
 *@FileTitle : FNS051-0001
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.25
 *@LastModifier : choijungmi
 *@LastVersion : 1.0
 * 2009.06.25 choijungmi
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.cps.gem.servicesio;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.clt.apps.opus.cps.gem.gemplanningperformance.GEMPlanningPerformanceSC;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.basic.GEMPlanningPerformanceBCImpl;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGemFns0510001Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpPerfVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.irep.erp.EAIHeaderType;
import com.clt.irep.erp.FNS0510001Document;
import com.clt.irep.erp.EAIHeaderType.Parameters;
import com.clt.irep.erp.EAIHeaderType.Parameters.Parameter;
import com.clt.irep.erp.FNS0510001Document.FNS0510001;
import com.clt.irep.erp.FNS0510001Document.FNS0510001.DataArea;
import com.clt.irep.erp.FNS0510001Document.FNS0510001.DataArea.ROWSET;
import com.clt.irep.erp.FNS0510001Document.FNS0510001.DataArea.ROWSETResponse;

/**
 * FNS051-0001에 대한 EAI 처리를 담당<br>
 * FNS051-0001 Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author choijungmi
 * @see GEMPlanningPerformanceBCImpl 참조
 * @since J2EE 1.4
 */
@WebService(name="GEMPlanningPerformanceFns0510001WSProxyPortType", serviceName="GEMPlanningPerformanceFns0510001WSProxy",
        targetNamespace="http://www.clt.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/opuscntr/webservices", serviceUri="/GEMPlanningPerformanceFns0510001WSProxy",
             portName="GEMPlanningPerformanceFns0510001WSProxyPort")
public class GEMPlanningPerformanceFns0510001WSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * ERP(A/P) 로부터 기 I/F 된 전표번호를 받아, 조직별 비용예산 및 실적집계 , 예산대비실적 집행률 을 전송한다<br>
	 * 
	 * @author choijungmi
	 * @category FNS051-0001
	 * @category receivePerformanceRatio
	 * 
	 * @param String strXml
	 *            연동 데이타 FNS0510001Document
	 * @return String
	 * @throws DAOException
	 */
	@WebMethod()
	@SuppressWarnings("unchecked")
	public String fNS0510001ReceiveWS(String strXml) throws Exception {
		//String strXml = "";
		List<GemSlpPerfVO> list = new ArrayList<GemSlpPerfVO>();
		GEMPlanningPerformanceSC planningPerformanceSC = new GEMPlanningPerformanceSC();
				
		// ========= Validation Parameters for WebServices ========= 
		if( strXml == null || strXml.equals("") )
		{
			throw new EventException("Parameter is not valided !");
		}
		// ========= Validation Parameters for WebServices ========= 

		// ========= Command Add ===============
		FormCommand f = new FormCommand();
		f.setCommand(FormCommand.SEARCH01);
		// ========= Command Add ===============
		
		CpsGemFns0510001Event event = new CpsGemFns0510001Event();
        event.setFormCommand(f);
        
        /**
         * SC를 호출한다. 
         */        
        FNS0510001Document doc = FNS0510001Document.Factory.parse(strXml);
        FNS0510001 sync = doc.getFNS0510001();
		DataArea data = sync.getDataArea();
		ROWSET rowset = data.getROWSET();
		String strCsrNo = rowset.getCSRNO();
		//event.setXmlObject(doc);
		
		event.setCsrNo(strCsrNo);
        EventResponse eventResponse = planningPerformanceSC.perform(event);
                
        /**
         * SC에서 값을 받는다.
         */
        list = (List) eventResponse.getRsVoList();
        log.info(":::::>>> list.size() : "+list.size());
        
        // ======== setting VO from RowSet Start ========== 		
		// 1. EAI에서 제공된 XSD파일을 Reading
		FNS0510001Document doc2 = FNS0510001Document.Factory.newInstance();
		FNS0510001 fnsdoc = doc2.addNewFNS0510001();

		// 2. Head Setting
		EAIHeaderType header = fnsdoc.addNewEAIHeader();
		Parameters ps = header.addNewParameters();
		Parameter p = ps.addNewParameter();
		p.setStringValue("FNS0510001HeaderTest");

		DataArea data2 = fnsdoc.addNewDataArea();
		ROWSETResponse rs = data2.addNewROWSETResponse();
		
		String gemResult = "";
		for (int i = 0; i < list.size(); i++) {
			GemSlpPerfVO gemSlpPerfVO = list.get(i);
			if(i==0) gemResult = gemResult + gemSlpPerfVO.getSlpTjNo();
			else gemResult = gemResult + "|"+ gemSlpPerfVO.getSlpTjNo();
		}
		rs.setGEMRESULT(gemResult);
		log.info(":::::>>> doc2 : "+doc2);
		// ======== setting VO from RowSet End ========== 
		
        return doc2.toString();
    }
}