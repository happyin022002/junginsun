/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : IMDGJMSProxy.java
 *@FileTitle :  
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014-05-21
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014-05-21
 * 1.0 최초 생성 
 =========================================================*/
package com.hanjin.apps.alps.vop.scg.servicesio;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.CargoLoadingApprovalSC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg0022Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBC;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBCImpl;
import com.hanjin.bizcommon.erpcom.ReceiveQueueRSC;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.alps.IMDG0050001Document;
import com.hanjin.irep.alps.IMDG0050001Document.IMDG0050001;
import com.jf.transfer.TransferEAI;

/**
 * JMS 서버에서 String 메세지를 받아 IMDGJMSProxy 에 넘겨준다. Event 관리를 한다.
 * [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 * 
 * @author
 * @see ReceiveQueueRSC
 * @since J2EE 1.4
 */
public class DangerousCargoInformationMgtJMSProxy {
	protected transient Logger log = Logger
			.getLogger(this.getClass().getName());

	/**
	 * JMS Receive<br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
	public void imdg0050001ReceiveJMS(TransferEAI eai) throws EventException {

		log.debug("\n<<<<<<<<<< IMDG0050001 JMS Start >>>>>>>>>>>>>>>>\n");

		String str = eai.getMessage();
		log.debug("\n======================================\n");
		log.debug("xml : " + str);
		log.debug("\n======================================\n");

		Event event = null;
		EventResponse result = null;
		CargoLoadingApprovalSC sc = new CargoLoadingApprovalSC();
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		String rst = "";
		String ifId = "";
		ScgPrnrAproRqstVO pr = new ScgPrnrAproRqstVO();
		ScgPrnrAproRqstCgoVO[] cgo = null;
		try {
			event = new VopScg0022Event();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			IMDG0050001Document doc = IMDG0050001Document.Factory.parse(str);
			IMDG0050001 imdg0050001 = doc.getIMDG0050001();
			IMDG0050001.DataArea data = imdg0050001.getDataArea();
			IMDG0050001.DataArea.ApprovalREQCollection col = data
					.getApprovalREQCollection();

			PartnerApprovalRequestVO par = null;
			par = new PartnerApprovalRequestVO();

			IMDG0050001.DataArea.ApprovalREQCollection.ApprovREQ in = col
					.getApprovREQ();
			IMDG0050001.DataArea.ApprovalREQCollection.ApprovREQ.ApprovReqCgo[] cs = in
					.getApprovReqCgoArray();
			ScgPrnrAproRqstVO[] prs = new ScgPrnrAproRqstVO[1];
			cgo = new ScgPrnrAproRqstCgoVO[in
					.getApprovReqCgoArray().length];
			ifId = doc.getIMDG0050001().getEAIHeader().getInstanceId();	
			
			pr.setAwkFlg(in.getAWKFLG());
			pr.setBkgRefNo(in.getBKGREFNO());

			pr.setCreDt(in.getCREDT());
			pr.setCreUsrId(in.getCREUSRID());
			pr.setCrrCd(in.getCRRCD());

			pr.setDgFlg(in.getDGFLG());
			pr.setEtaDt(in.getETADT());
			pr.setPodCd(in.getPODCD());
			pr.setPodClptIndSeq(in.getPODCLPTINDSEQ());
			pr.setPolCd(in.getPOLCD());
			pr.setPolClptIndSeq(in.getPOLCLPTINDSEQ());
			pr.setRgnShpOprCd(in.getRGNSHPOPRCD());
			pr.setSkdDirCd(in.getSKDDIRCD());
			pr.setSkdVoyNo(in.getSKDVOYNO());
			pr.setSlanCd(in.getSLANCD());
			pr.setSpclCgoRqstSeq("");//in.getSPCLCGORQSTSEQ());
			pr.setUpdDt(in.getUPDDT());
			pr.setUpdUsrId(in.getUPDUSRID());
			pr.setVslCd(in.getVSLCD());
			pr.setIbflag(in.getIBFLAG());
			int i = 0;
			for (ScgPrnrAproRqstCgoVO c : cgo) {
				c = new ScgPrnrAproRqstCgoVO();
				c.setAproRefNo(cs[i].getAPROREFNO());
				c.setAuthDt(cs[i].getAUTHDT());
				c.setAuthOfcCd(cs[i].getAUTHOFCCD());
				c.setAuthStsCd(cs[i].getAUTHSTSCD());
				c.setAuthUsrId(cs[i].getAUTHUSRID());
				// c.setAwkFlg(cs[i].getaw)
				c.setBkgRefNo(cs[i].getBKGREFNO());
				c.setBkwdOvrDimLen(cs[i].getBKWDOVRDIMLEN());
				c.setCertiNo(cs[i].getCERTINO());
				c.setCgoLclFlg(cs[i].getCGOLCLFLG());
				c.setCgoOprCd(cs[i].getCGOOPRCD());
				c.setCgoRqstDt(cs[i].getCGORQSTDT());
				c.setClodFlg(cs[i].getCLODFLG());
				c.setCmdtDesc(cs[i].getCMDTDESC());
				c.setCneeDtlDesc(cs[i].getCNEEDTLDESC());
				c.setCntrRefNo(cs[i].getCNTRREFNO());
				c.setCntrTpszCd(cs[i].getCNTRTPSZCD());
				c.setCreDt(cs[i].getCREDT());
				c.setCreUsrId(cs[i].getCREUSRID());
				c.setCrrCd(cs[i].getCRRCD());
				c.setCtrlTempCtnt(cs[i].getCTRLTEMPCTNT());
				
				c.setDcgoStsCd(cs[i].getDCGOSTSCD());
				c.setDiffRmk(cs[i].getDIFFRMK());
				c.setEmerCntcPhnNo(cs[i].getEMERCNTCPHNNO());
				c.setEmerCntcPsonNm(cs[i].getEMERCNTCPSONNM());
				c.setEmerRspnGidChrNo(cs[i].getEMERRSPNGIDCHRNO());
				c.setEmerRspnGidNo(cs[i].getEMERRSPNGIDNO());
				c.setEmerTempCtnt(cs[i].getEMERTEMPCTNT());				
				c.setEmsNo(cs[i].getEMSNO());
				c.setFlshPntCdoTemp(cs[i].getFLSHPNTCDOTEMP());
				c.setFwrdOvrDimLen(cs[i].getFWRDOVRDIMLEN());
				c.setGrsCapaQty(cs[i].getGRSCAPAQTY());
				c.setGrsWgt(cs[i].getGRSWGT());
				c.setHzdDesc(cs[i].getHZDDESC());
				c.setHgtOvrDimLen(cs[i].getHGTOVRDIMLEN());
				c.setImdgClssCd(cs[i].getIMDGCLSSCD());
				c.setImdgCoGrpCd(cs[i].getIMDGCOGRPCD());
				c.setImdgExptQtyFlg(cs[i].getIMDGEXPTQTYFLG());
				c.setImdgLmtQtyFlg(cs[i].getIMDGLMTQTYFLG());
				c.setImdgPckGrpCd(cs[i].getIMDGPCKGRPCD());
				c.setImdgUnNo(cs[i].getIMDGUNNO());
				c.setImdgUnNoSeq(cs[i].getIMDGUNNOSEQ());
				c.setInN1stImdgPckCd(cs[i].getINN1STIMDGPCKCD());
				c.setInN1stImdgPckQty(cs[i].getINN1STIMDGPCKQTY());
				c.setInN2ndImdgPckCd(cs[i].getINN2NDIMDGPCKCD());
				c.setInN2ndImdgPckQty(cs[i].getINN2NDIMDGPCKQTY());
				c.setIntmdN1stImdgPckCd(cs[i].getINTMDN1STIMDGPCKCD());
				c.setIntmdN1stImdgPckQty(cs[i].getINTMDN1STIMDGPCKQTY());
				c.setIntmdN2ndImdgPckCd(cs[i].getINTMDN2NDIMDGPCKCD());
				c.setIntmdN2ndImdgPckQty(cs[i].getINTMDN2NDIMDGPCKQTY());
				c.setLfSdOvrDimLen(cs[i].getLFSDOVRDIMLEN());
				c.setMaxInPckQty(cs[i].getMAXINPCKQTY());
				c.setMeasQty(cs[i].getMEASQTY());
				c.setMeasTpCd(cs[i].getMEASTPCD());
				c.setMrnPolutFlg(cs[i].getMRNPOLUTFLG());
				c.setN1stImdgSubsRskLblCd(cs[i].getN1STIMDGSUBSRSKLBLCD());
				c.setN2ndImdgSubsRskLblCd(cs[i].getN2NDIMDGSUBSRSKLBLCD());
				c.setN3rdImdgSubsRskLblCd(cs[i].getN3RDIMDGSUBSRSKLBLCD());
				c.setN4thImdgSubsRskLblCd(cs[i].getN4THIMDGSUBSRSKLBLCD());
				c.setNetExploWgt(cs[i].getNETEXPLOWGT());
				c.setNetWgt(cs[i].getNETWGT());
				c.setOutN1stImdgPckCd(cs[i].getOUTN1STIMDGPCKCD());
				c.setOutN1stImdgPckQty(cs[i].getOUTN1STIMDGPCKQTY());
				c.setOutN2ndImdgPckCd(cs[i].getOUTN2NDIMDGPCKCD());
				c.setOutN2ndImdgPckQty(cs[i].getOUTN2NDIMDGPCKQTY());
				c.setPckQty(cs[i].getPCKQTY());
				c.setPckTpCd(cs[i].getPCKTPCD());
				c.setPrpShpNm(cs[i].getPRPSHPNM());
				c.setPsaNo(cs[i].getPSANO());
				c.setRadaAmt(cs[i].getRADAAMT());
				c.setRadaSkdNo(cs[i].getRADASKDNO());
				c.setRadaTrspNo(cs[i].getRADATRSPNO());
				c.setRadaUtCd(cs[i].getRADAUTCD());
				c.setRtSdOvrDimLen(cs[i].getRTSDOVRDIMLEN());
				c.setSpclCgoCateCd(cs[i].getSPCLCGOCATECD());
				c.setSpclCgoRqstSeq(""); //cs[i].getSPCLCGORQSTSEQ());
				c.setSpclCgoSeq(cs[i].getSPCLCGOSEQ());
				c.setSpclCntrSeq(cs[i].getSPCLCNTRSEQ());
				c.setSpclStwgRqstDesc(cs[i].getSPCLSTWGRQSTDESC());
				c.setTtlDimHgt(cs[i].getTTLDIMHGT());
				c.setTtlDimLen(cs[i].getTTLDIMLEN());
				c.setTtlDimWdt(cs[i].getTTLDIMWDT());
				c.setUpdDt(cs[i].getUPDDT());
				c.setUpdUsrId(cs[i].getUPDUSRID());
				c.setVoidSltQty(cs[i].getVOIDSLTQTY());
				c.setWgtUtCd(cs[i].getWGTUTCD());
				c.setEaiIfId(ifId);
				c.setEaiIfFlg("Y");
				c.setIbflag(cs[i].getIBFLAG());
				cgo[i] = c;
				i++;
			}
			pr.setEaiIfId(ifId);
			pr.setEaiIfFlg("Y");					
			prs[0] = pr;
			par.setScgPrnrAproRqstVOs(prs);
			par.setScgPrnrAproRqstCgoVOs(cgo);
			((VopScg0022Event) event).setPartnerApprovalRequestVO(par);
			((VopScg0022Event) event).setEventName("IMDG0050001");
			result = sc.perform(event);			
			rst = eai.commit(ifId);
			
			log.debug("\n<<<<<<<<<< IMDG0050001 JMS End >>>>>>>>>>>>>>>>\n");

		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (XmlException ex) {
			log.error("XmlException ex : " + ex.toString(), ex);
			eai.rollback(ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception e) {
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage());
		} finally {
			log.debug("\n<<<<<<<<<< ::: "+ rst +" ::: >>>>>>>>>>>\n");
			if("SUCCESS".equals(rst) && result != null && "1".equals(result.getETCData().get("rslt"))){
				rst = "Y";
			} else {
				rst = "N";
			}
			command.sendScgPrnrAproRqstResult(rst, ifId);
			eai.close();
		}
	}
}
