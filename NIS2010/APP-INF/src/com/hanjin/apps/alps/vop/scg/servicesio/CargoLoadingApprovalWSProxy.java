/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SynchWebServicesProviderProxy.java
 *@FileTitle : Synch WebServices Provider Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-05-25
 *@LastModifier : Hyunsu, Ryu
 *@LastVersion : 1.0
 * 2009-05-25 Hyunsu, Ryu
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.vop.scg.servicesio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.CargoLoadingApprovalSC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.IMDG070001Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.alpsws.IMDG0060001Document;
import com.hanjin.irep.alpsws.IMDG0060001Document.IMDG0060001;
import com.hanjin.irep.alpsws.IMDG0060001Document.IMDG0060001.DataArea;
import com.hanjin.irep.alpsws.IMDG0060001Document.IMDG0060001.DataArea.PreRestrictionCollection;

/**
 * CargoLoadingApprovalWSProxy.java
 * 
 * @author
 * @see
 * @since J2EE 1.6 2014-05-29 
 */
@WebService(name = "CargoLoadingApprovalWSProxyPortType", serviceName = "CargoLoadingApprovalWSProxy", targetNamespace = "http://www.hanjin.com/integration/alps")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@WLHttpTransport(contextPath = "/hanjin/webservices", serviceUri = "/CargoLoadingApprovalWSProxy", portName = "CargoLoadingApprovalWSProxyPort")
public class CargoLoadingApprovalWSProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * IMDG PRE-CHECKING
	 * 
	 * @param IMDG0060001Document doc
	 * @return IMDG0060001Document
	 */
	@WebMethod()
	public IMDG0060001Document preCheck(IMDG0060001Document doc) {
		CargoLoadingApprovalSC sc = new CargoLoadingApprovalSC();
		PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
		boolean segChk = false;
		boolean vslChk = false;
		boolean prtChk = false;
		boolean pckChk = false;
		try {
			// ========= Validation Parameters for WebServices =========
			if (doc == null || "".equals(doc)) {
				throw new EventException("Parameter is not valided !");
			}
			// ========= Validation Parameters for WebServices =========
			// ========= Command Add ===============
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			// ========= Command Add ===============

			IMDG0060001 imdg0060001 = doc.getIMDG0060001();

			DataArea dataArea = imdg0060001.getDataArea();
			PreRestrictionCollection infoCollection = dataArea.getPreRestrictionCollection();
			com.hanjin.irep.alpsws.IMDG0060001Document.IMDG0060001.DataArea.PreRestrictionCollection.PreRestrictionInputVO[] imdg0060001Requests = infoCollection
					.getPreRestrictionInputVOArray();
			log.debug("\n" + doc.toString() + "\n");

			log.debug("\n<<<<<<<<<< IMDG0060001Document 2 [" + imdg0060001Requests.length + "]");

			if (imdg0060001Requests[0] == null) {
				throw new EventException("There is no requested data!");
			}

			log.debug("\n<<<<<<<<<< IMDG0060001Document 3\n");

			segChk = Boolean.parseBoolean(infoCollection.getSEGCHK());
			vslChk = Boolean.parseBoolean(infoCollection.getVSLCHK());
			prtChk = Boolean.parseBoolean(infoCollection.getPRTCHK());
			pckChk = Boolean.parseBoolean(imdg0060001Requests[0].getPCKCHK());

			PreRestrictionInputVO innerVo = new PreRestrictionInputVO();
			innerVo.setPckChk(String.valueOf(pckChk));
			innerVo.setBkgNo(imdg0060001Requests[0].getBKGNO());
			innerVo.setCrrCd(imdg0060001Requests[0].getCRRCD());
			innerVo.setDcgoStsCd(imdg0060001Requests[0].getDCGOSTSCD());
			innerVo.setEndNum(imdg0060001Requests[0].getENDNUM());
			innerVo.setGrsCapaQty(imdg0060001Requests[0].getGRSCAPAQTY());
			innerVo.setGrsWgt(imdg0060001Requests[0].getGRSWGT());
			innerVo.setImdgClssCd(imdg0060001Requests[0].getIMDGCLSSCD());
			innerVo.setImdgExptQtyFlg(imdg0060001Requests[0].getIMDGEXPTQTYFLG());
			innerVo.setImdgLmtQtyFlg(imdg0060001Requests[0].getIMDGLMTQTYFLG());
			innerVo.setImdgPckGrpCd(imdg0060001Requests[0].getIMDGPCKGRPCD());
			innerVo.setImdgUnNo(imdg0060001Requests[0].getIMDGUNNO());
			innerVo.setImdgUnNoSeq(imdg0060001Requests[0].getIMDGUNNOSEQ());
			innerVo.setInGrsPerUt(imdg0060001Requests[0].getINGRSPERUT());
			innerVo.setInImdgPckCd1(imdg0060001Requests[0].getINIMDGPCKCD1());
			innerVo.setInImdgPckQty1(imdg0060001Requests[0].getINIMDGPCKQTY1());
			innerVo.setInNetPerUt(imdg0060001Requests[0].getINNETPERUT());
			innerVo.setIntmdImdgPckCd1(imdg0060001Requests[0].getINTMDIMDGPCKCD1());
			innerVo.setIntmdImdgPckQty1(imdg0060001Requests[0].getINTMDIMDGPCKQTY1());
			innerVo.setInTtlCapaPerUt(imdg0060001Requests[0].getINTTLCAPAPERUT());
			innerVo.setNetWgt(imdg0060001Requests[0].getNETWGT());
			innerVo.setOptClss(imdg0060001Requests[0].getOPTCLSS());
			innerVo.setOutGrsPerUt(imdg0060001Requests[0].getOUTGRSPERUT());
			innerVo.setOutImdgPckCd1(imdg0060001Requests[0].getOUTIMDGPCKCD1());
			innerVo.setOutImdgPckQty1(imdg0060001Requests[0].getOUTIMDGPCKQTY1());
			innerVo.setOutNetPerUt(imdg0060001Requests[0].getOUTNETPERUT());
			innerVo.setOutTtlCapaPerUt(imdg0060001Requests[0].getOUTTTLCAPAPERUT());
			innerVo.setPckDivCd(imdg0060001Requests[0].getPCKDIVCD());
			innerVo.setPckStyCd(imdg0060001Requests[0].getPCKSTYCD());
			innerVo.setPodCd(imdg0060001Requests[0].getPODCD());
			innerVo.setPodPortCd(imdg0060001Requests[0].getPODPORTCD());
			innerVo.setPolCd(imdg0060001Requests[0].getPOLCD());
			innerVo.setPolPortCd(imdg0060001Requests[0].getPOLPORTCD());
			innerVo.setSkdDirCd(imdg0060001Requests[0].getSKDDIRCD());
			innerVo.setSkdVoyNo(imdg0060001Requests[0].getSKDVOYNO());
			innerVo.setSlanCd(imdg0060001Requests[0].getSLANCD());
			innerVo.setSpclCgoSeq(imdg0060001Requests[0].getSPCLCGOSEQ());
			innerVo.setSpclCntrSeq(imdg0060001Requests[0].getSPCLCNTRSEQ());
			innerVo.setStartNum(imdg0060001Requests[0].getSTARTNUM());
			innerVo.setVslCd(imdg0060001Requests[0].getVSLCD());
			preRestrictionInputVO.setInnerPreRestrictionInputVO(innerVo);
			IMDG070001Event event = new IMDG070001Event(preRestrictionInputVO, segChk, vslChk, prtChk);
			event.setFormCommand(f);
			PreRestrictionOutputVO vo = new PreRestrictionOutputVO();

			EventResponse eventResponse = sc.perform(event);
			List<Object> list = eventResponse.getRsVoList();
			vo = (PreRestrictionOutputVO) list.get(0);

			log.debug("\n<<<<<<<<<< BKG No : "+imdg0060001Requests[0].getBKGNO());
			log.debug("\n<<<<<<<<<< SEGCHKRSLT : "+String.valueOf(vo.getSegChkRslt())
			                  +" "+"VSLCHKRSLT : "+String.valueOf(vo.getVslChkRslt())
			                  +" "+"PRTCHKRSLT : "+String.valueOf(vo.getPrtChkRslt()) 
            				  +" "+"PCKCHKRSLT : "+String.valueOf(vo.getPckChkRslt())); 
			
			infoCollection.getPreRestrictionOutputVO().setSEGCHKRSLT(String.valueOf(vo.getSegChkRslt()));
			infoCollection.getPreRestrictionOutputVO().setVSLCHKRSLT(String.valueOf(vo.getVslChkRslt()));
			infoCollection.getPreRestrictionOutputVO().setPRTCHKRSLT(String.valueOf(vo.getPrtChkRslt()));
			infoCollection.getPreRestrictionOutputVO().setPCKCHKRSLT(String.valueOf(vo.getPckChkRslt()));

		} catch (Exception e) {
			log.error("CargoLoadingApprovalWSProxy Error : " + e.toString(), e);
		}
		return doc;
	}
}
