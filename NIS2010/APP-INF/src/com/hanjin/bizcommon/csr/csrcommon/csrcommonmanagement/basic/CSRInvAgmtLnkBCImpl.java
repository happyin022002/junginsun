/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRInvAgmtLnkBCImpl.java
*@FileTitle : CSR Invoice Agreement Link
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.10
*@LastModifier : 9014787
*@LastVersion : 1.0
* 2014.07.10 9014787
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic.ChsMgsSendGWAgreementInfoBC;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic.ChsMgsSendGWAgreementInfoBCImpl;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic.PayableRentalCostBC;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic.PayableRentalCostBCImpl;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic.MnrSendGWAgreementInfoBC;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic.MnrSendGWAgreementInfoBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBC;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBCImpl;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.event.ComCsr0023Event;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration.CSRInvAgmtLnkDBDAO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRComApFileUpldVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRInvAgmtLnkInVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.SelComApFileVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-CSRCommonManagement Business Logic Basic Command implementation<br>
 * - ALPS-CSRCommonManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 9014787
 * @see UI_CSR_0023EventResponse, CSRInvAgmtLnkBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class CSRInvAgmtLnkBCImpl extends BasicCommandSupport implements CSRInvAgmtLnkBC {

	// Database Access Object
	private transient CSRInvAgmtLnkDBDAO dbDao = null;

	/**
	 * CSRInvAgmtLnkBCImpl 객체 생성<br>
	 */
	public CSRInvAgmtLnkBCImpl() {
		dbDao = new CSRInvAgmtLnkDBDAO();
	}

	/**
	 * COM_CSR_0023 조회 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 화면에 대한 조회 이벤트 처리<br>
	 * @author 9014787
	 * @param ComCsrRequestAgmtVO comCsrRequestAgmtVO
	 * @return List<ComCsrRequestAgmtVO>
	 * @exception EventException
	 */
	public List<ComCsrRequestAgmtVO> searchInvoice(ComCsrRequestAgmtVO comCsrRequestAgmtVO) throws EventException {
		log.debug("[START:: CSRInvAgmtLnkBCImpl == searchInvoice SEARCH ]==========");

		ApprovalUtil aproUtil = new ApprovalUtil();
		
		CARIssueTransferSlipManageBC tesCommand = new CARIssueTransferSlipManageBCImpl();
		CSRIssueTransferSlipManageBC trsCommand = new CSRIssueTransferSlipManageBCImpl();
		AGNCommAgreementBC acmCommand = new AGNCommAgreementBCImpl();
		PayableRentalCostBC lseCommand = new PayableRentalCostBCImpl();
		ChsMgsSendGWAgreementInfoBC cgmCommand = new ChsMgsSendGWAgreementInfoBCImpl();
	    MnrSendGWAgreementInfoBC mnrCommand = new MnrSendGWAgreementInfoBCImpl();

		List<ComCsrRequestAgmtVO> list = null;
		try {

			String csrNo = comCsrRequestAgmtVO.getCsrNo();
			String invSubSysCd = aproUtil.searchSubSysCd(csrNo);

			if(invSubSysCd.equals("TES")) {
				list = tesCommand.printComCsrAgmtInfo2(csrNo);
			}else if(invSubSysCd.equals("TRS")) {
				list = trsCommand.printComCsrAgmtInfo2(csrNo);				
			}else if(invSubSysCd.equals("ACM")){
				list = acmCommand.printComCsrAgmtInfo2(csrNo);
			}else if(invSubSysCd.equals("LSE")){
				list = lseCommand.printComCsrAgmtInfo2(csrNo);
			}else if(invSubSysCd.equals("MNR")) {
				list = mnrCommand.printComCsrAgmtInfo2(csrNo);
			}else if(invSubSysCd.equals("CHS") || invSubSysCd.equals("MGS") || invSubSysCd.equals("CGM")){ 
				list = cgmCommand.printComCsrAgmtInfo2(csrNo);
			}
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END::]==========");
		return list;		
	}
	
	/**
	 * COM_CSR_0023 조회 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 Contract & Files 화면에 대한 조회 이벤트 처리<br>
	 * @author 9014787
	 * @param CSRInvAgmtLnkInVO csrInvAgmtLnkInVO
	 * @return List<SelComApFileVO>
	 * @exception EventException
	 */
	public List<SelComApFileVO> search02ComApFileUpld(CSRInvAgmtLnkInVO csrInvAgmtLnkInVO) throws EventException {
		log.debug("[START:: CSRInvAgmtLnkBCImpl == search02ComApFileUpld SEARCH ]==========");

		List<SelComApFileVO> list = null;
		try {
			list = dbDao.search02ComApFileUpld(csrInvAgmtLnkInVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END:: CSRInvAgmtLnkBCImpl == search02ComApFileUpld SEARCH ]==========");
		return list;
	}

	/**
	 * COM_CSR_0023 멀티 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 Contract & Files 화면에 대한 멀티 이벤트 처리<br>
	 * @author 9014787
	 * @param Event e
	 * @exception EventException
	 */
	public void multiComApFileUpld(Event e) throws EventException {
		log.debug("[START:: CSRInvAgmtLnkBCImpl == multiComApFileUpld  ]==========");
		ComCsr0023Event event = (ComCsr0023Event)e;
		CSRInvAgmtLnkInVO csrInvAgmtLnkInVO = event.getCsrInvAgmtLnkInVO();

		CSRComApFileUpldVO[] csrComApFileUpldVOs = csrInvAgmtLnkInVO.getCsrComApFileUpldVOs();

		String csrNo = csrInvAgmtLnkInVO.getCsrNo();
		String use_id = event.getSignOnUserAccount().getUsr_id();
		String[] fileSavId = csrInvAgmtLnkInVO.getKeys();

		try {
			
			// RQST_APRO_STEP_FLG 'Y' 일경우만 I,U,D 가능
			String rqstAproStepFlg = dbDao.getRqstAproStepFlg(csrNo);
			log.debug("[ rqstAproStepFlg ]=========="+rqstAproStepFlg);
			
			if(!rqstAproStepFlg.equals("Y")){
				throw new EventException("RQST_APRO_STEP_FLG IS NOT Y");
			}
			
			List<CSRComApFileUpldVO> insertVoList = new ArrayList<CSRComApFileUpldVO>();
			List<CSRComApFileUpldVO> deleteVoList = new ArrayList<CSRComApFileUpldVO>();
			List<CSRComApFileUpldVO> updateVoList = new ArrayList<CSRComApFileUpldVO>();
			int save_id_cnt = 0;
			for (int i = 0; i < csrComApFileUpldVOs.length; i++) {

				if (csrComApFileUpldVOs[i].getIbflag().equals("U")) {
					log.debug("[START:: SpecialCargoRiderBCImpl] updateVoList=====" + csrComApFileUpldVOs[i].getFileSavId());
					csrComApFileUpldVOs[i].setCsrNo(csrNo);

					csrComApFileUpldVOs[i].setCreUsrId(use_id);
					csrComApFileUpldVOs[i].setUpdUsrId(use_id);
					
					updateVoList.add(csrComApFileUpldVOs[i]);
				} else if (csrComApFileUpldVOs[i].getIbflag().equals("D")) {
					log.debug("[START:: SpecialCargoRiderBCImpl] deleteVoList =====" + csrComApFileUpldVOs[i].getFileSavId());
					csrComApFileUpldVOs[i].setCsrNo(csrNo);
					
					csrComApFileUpldVOs[i].setCreUsrId(use_id);
					csrComApFileUpldVOs[i].setDeltUsrId(use_id);

					deleteVoList.add(csrComApFileUpldVOs[i]);
					UpdateFileMetaInfo.delete(csrComApFileUpldVOs[i].getFileSavId());

				} else if (csrComApFileUpldVOs[i].getIbflag().equals("I")) {
					log.debug("[START:: SpecialCargoRiderBCImpl] insertVoList =====" + csrComApFileUpldVOs[i].getFileSavId());
					csrComApFileUpldVOs[i].setCsrNo(csrNo);

					if (csrComApFileUpldVOs[i].getFileSavId() == null || csrComApFileUpldVOs[i].getFileSavId().length() == 0) {
						csrComApFileUpldVOs[i].setFileSavId(fileSavId[save_id_cnt++]);
					}

					csrComApFileUpldVOs[i].setCreUsrId(use_id);
					csrComApFileUpldVOs[i].setUpdUsrId(use_id);
					//csrComApFileUpldVOs[i].setCsrFileUpldTpCd("FU");

					insertVoList.add(csrComApFileUpldVOs[i]);
				}
			}

			if (deleteVoList.size() > 0) {

				dbDao.delComApFile(deleteVoList);
			}

			if (insertVoList.size() > 0) {
				int atchFileCnt = dbDao.getComApFileUpldCnt(csrInvAgmtLnkInVO);
				log.debug("[ atchFileCnt ]=========="+atchFileCnt);

				if(atchFileCnt < 15){
					// add
					dbDao.insComApFile(insertVoList);
				}
				else{
					// file delete
					throw new EventException(new ErrorHandler("CSR10013").getMessage());
				}
			}
			
			// Comments
			if (updateVoList.size() > 0) {
				dbDao.updComApFile(updateVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		log.debug("[END:: CSRInvAgmtLnkBCImpl == multiComApFileUpld  ]==========");
	}

}