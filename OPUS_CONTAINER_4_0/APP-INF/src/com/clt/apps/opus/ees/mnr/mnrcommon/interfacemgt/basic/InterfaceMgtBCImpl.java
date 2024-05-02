/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfaceMgtBCImpl.java
*@FileTitle : Interface
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import weblogic.wsee.util.StringUtil;

import com.clt.apps.opus.bcm.fin.fincommon.fincommon.vo.CheckInvoiceNoVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtForGateNewDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTListbyDMGEvntDateVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.basic.ExpenseMgtBC;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.basic.ExpenseMgtBCImpl;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.CustomMnrPayInvWrkVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.CustomPayableInvoiceDetailINVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtRtVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.BkgTrdCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EQGeneralInfoINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration.DocSendEAIDAO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration.FASendEAIDAO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration.InterfaceMgtDBDAO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.DocResultVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.FaErpListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.FlatFileDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.FlatFileHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration.RepairMgtDBDAO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.basic.TPBInterfaceBC;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * COM-OperationManage Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see EES_MNR_0139EventResponse,EQFlagMgtBC DAO class reference
 * @since J2EE 1.4
 */
public class InterfaceMgtBCImpl extends BasicCommandSupport implements InterfaceMgtBC {

	// Database Access Object
	private transient InterfaceMgtDBDAO dbDao = null;
	private transient RepairMgtDBDAO dbDao2 = null;
	private transient DocSendEAIDAO eaiDao = null;
	private transient FASendEAIDAO eaiFaDao = null;
	private transient ContainerMovementMgtDBDAO ctmDao1 = null;
	private transient ContainerMovementMgtForGateNewDBDAO ctmDao2 = null;

	/**
	 * creating InterfaceMgtBCImpl object<br>
	 * creating GeneralCodeCheckMgtDBDAODAO <br>
	 */
	public InterfaceMgtBCImpl() {
		dbDao = new InterfaceMgtDBDAO();
		dbDao2 = new RepairMgtDBDAO();
		eaiDao = new DocSendEAIDAO();
		eaiFaDao = new FASendEAIDAO();
		ctmDao1 = new ContainerMovementMgtDBDAO();
		ctmDao2 = new ContainerMovementMgtForGateNewDBDAO();
	}

	/**
	 * checking estimate from EDI possibility to save . <br>
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO interfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO checkEDIEstimateBasic(InterfaceGRPVO interfaceGRPVO) throws EventException {
		try {
			CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVO();
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = new CustomMnrRprRqstHdrVO();

			//retrieving EQ using RQST_REF_NO
			customMnrRprRqstHdrVO = dbDao.searchEstimateSeqByRefNoData(customMnrRprRqstTmpHdrVO);
			interfaceGRPVO.setCheckCustomMnrRprRqstHdrVO(customMnrRprRqstHdrVO);

			//EDI ERROR [Eq ERROR]
			if(!interfaceGRPVO.getEqChk().equals("SS")){
				dbDao.modifyESTTempFlagData(customMnrRprRqstTmpHdrVO,"UE");
				interfaceGRPVO.setValidOk(false);
				return interfaceGRPVO;
			}

			//EDI ERROR [Rqst_Ref_No ERROR]
			if(!interfaceGRPVO.getRqstRefNoChk().equals("SS")){
				dbDao.modifyESTTempFlagData(customMnrRprRqstTmpHdrVO,"RE");
				interfaceGRPVO.setValidOk(false);
				return interfaceGRPVO;
			}

			//EDI ERROR [Date Format error] [ACT_TRANS_DT OR EST_DT]
			if(!interfaceGRPVO.getDateFormChk().equals("SS")){
				dbDao.modifyESTTempFlagData(customMnrRprRqstTmpHdrVO,"DE");
				interfaceGRPVO.setValidOk(false);
				return interfaceGRPVO;
			}

			//EDI ERROR [Vender Seq error]
			if(!interfaceGRPVO.getVenderChk().equals("SS")){
				dbDao.modifyESTTempFlagData(customMnrRprRqstTmpHdrVO,"VE");
				interfaceGRPVO.setValidOk(false);
				return interfaceGRPVO;
			}

			//EDI ERROR [Already Processed error] 
			if(customMnrRprRqstHdrVO != null && customMnrRprRqstHdrVO.getRprStsCd().equals("HA")){
				dbDao.modifyESTTempFlagData(customMnrRprRqstTmpHdrVO,"AP");
				interfaceGRPVO.setValidOk(false);
				return interfaceGRPVO;
			}

			interfaceGRPVO.setValidOk(true);
			return interfaceGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Group Auditing] createTPBIFBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Group Auditing] createTPBIFBasic"}).getMessage(),ex);
		}
	}
	


	/**
	 * [EES_MNR_0023]handling Repair Group Auditing. <br>
	 * only TPB Interface Method
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTPBIFBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException {
		try {
			TPBInterfaceBC command = new TPBInterfaceBCImpl();

			List<TPBInterfaceVO> tPBInterfaceVOS = dbDao.searchTPBInterfaceListData(interfaceGRPVO.getTpbRqstEqNo());

			//calling tpb interface 
			if ( tPBInterfaceVOS.size() > 0 ) {
				TPBInterfaceVO[] arrTPBInterfaceVOS = new TPBInterfaceVO[tPBInterfaceVOS.size()];
				for ( int i = 0; i < tPBInterfaceVOS.size(); i++ ) {
					arrTPBInterfaceVOS[i] = tPBInterfaceVOS.get(i);
				}
				command.createMNRTPB(arrTPBInterfaceVOS, account);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Group Auditing] createTPBIFBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Group Auditing] createTPBIFBasic"}).getMessage(),ex);
		}
	}

	/**
	 * only Flagging external Interface Method <br>
	 * modifying MST CGM .
	 * @param InterfaceGRPVO   interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIFFlagBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException {
		try {
			List<IFMnrFlagVO> iFMnrFlagVOS = interfaceGRPVO.getIFMnrFlagVOS();
			List<IFMnrFlagVO> cntrIFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			List<IFMnrFlagVO> otherIFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			
			ContainerOnOffhireBC command1 =  new ContainerOnOffhireBCImpl();
			ChassisMgsetOnOffhireBC command2 =  new ChassisMgsetOnOffhireBCImpl();
			
			for ( int i = 0; i < iFMnrFlagVOS.size(); i++ ) {
				if(iFMnrFlagVOS.get(i).getEqKindCd().equalsIgnoreCase("U")){
					
					if(iFMnrFlagVOS.get(i).getFlagType().equals("TLL") ||
					   iFMnrFlagVOS.get(i).getFlagType().equals("SLD") ||
					   iFMnrFlagVOS.get(i).getFlagType().equals("SCR") ||
					   iFMnrFlagVOS.get(i).getFlagType().equals("DON")){

						int retVal = dbDao.checkCNTRActualDTData(iFMnrFlagVOS.get(i));
						if(retVal < 0){
							throw new EventException(new ErrorHandler("MNR00326", new String[]{"EQ No:"+iFMnrFlagVOS.get(i).getEqNo()}).getMessage());
						}
					}
					cntrIFMnrFlagVOS.add(iFMnrFlagVOS.get(i));
					
				} else {
					otherIFMnrFlagVOS.add(iFMnrFlagVOS.get(i));
				}
			}

			if ( cntrIFMnrFlagVOS.size() > 0 ) {
				IFMnrFlagVO[] arrIFMnrFlagVOS = new IFMnrFlagVO[cntrIFMnrFlagVOS.size()];
				for ( int i = 0; i < cntrIFMnrFlagVOS.size(); i++ ) {
					arrIFMnrFlagVOS[i] = cntrIFMnrFlagVOS.get(i);
				}
				command1.createMNRStatusBasic(arrIFMnrFlagVOS,account);
			}

			if ( otherIFMnrFlagVOS.size() > 0 ) {
				command2.createMNRStatusBasic(otherIFMnrFlagVOS);
			}
		} catch (EventException e){
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageIFFlagBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageIFFlagBasic"}).getMessage(),de);
		}
	}

	/**
	 * [Interface ] <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createFileUploadBasic(InterfaceGRPVO interfaceGRPVO ,SignOnUserAccount account) throws EventException {
		String seqValue  = "";
		try {
			List<CustomMnrFileAtchVO> insertVoList   = new ArrayList<CustomMnrFileAtchVO>();
			List<CustomMnrFileAtchVO> updateVoList   = new ArrayList<CustomMnrFileAtchVO>();

			if ( interfaceGRPVO.getCustomMnrFileAtchVOs()[0].getFileSeq().equals("")){
				seqValue = dbDao.createMnrFileAtchSeqData();
			} else {
				seqValue = interfaceGRPVO.getCustomMnrFileAtchVOs()[0].getFileSeq().toString();
			}
			for ( int i=0; i < interfaceGRPVO.getCustomMnrFileAtchVOs().length; i++ ) {
				if(interfaceGRPVO.getCustomMnrFileAtchVOs()[i] == null)break;
				interfaceGRPVO.getCustomMnrFileAtchVOs()[i].setFileSeq(seqValue);
				interfaceGRPVO.getCustomMnrFileAtchVOs()[i].setCreUsrId(account.getUsr_id());
				interfaceGRPVO.getCustomMnrFileAtchVOs()[i].setUpdUsrId(account.getUsr_id());

				if ( interfaceGRPVO.getCustomMnrFileAtchVOs()[i].getIbflag().equals("I")){
					insertVoList.add(interfaceGRPVO.getCustomMnrFileAtchVOs()[i]);
				} else if ( interfaceGRPVO.getCustomMnrFileAtchVOs()[i].getIbflag().equals("U")){
					updateVoList.add(interfaceGRPVO.getCustomMnrFileAtchVOs()[i]);
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addFileUploadData(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyFileUploadData(updateVoList);
			}
		} catch (EventException e){
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[FQA Result Creation] removeFileUploadAllBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[FQA Result Creation] removeFileUploadAllBasic"}).getMessage(),de);
		}
		return seqValue;
	}

	/**
	 * [EES_MNR_0216]deleting Total Loss Request. <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeFileUploadBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException{
		try {
			List<CustomMnrFileAtchVO> deleteVoList   = new ArrayList<CustomMnrFileAtchVO>();

			for ( int i = 0; i < interfaceGRPVO.getCustomMnrFileAtchVOs().length; i++ ) {
				interfaceGRPVO.getCustomMnrFileAtchVOs()[i].setCreUsrId(account.getUsr_id());
				interfaceGRPVO.getCustomMnrFileAtchVOs()[i].setUpdUsrId(account.getUsr_id());
				deleteVoList.add(interfaceGRPVO.getCustomMnrFileAtchVOs()[i]);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeFileUploadData(deleteVoList);
			}
		} catch (EventException e){
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] removeFileUploadBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] removeFileUploadBasic"}).getMessage(),de);
		}
	}


	/**
	 * [EES_MNR_0029]deleting FQA Result Creation. <br>
	 *
	 * @param String fileSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeFileUploadAllBasic(String fileSeq, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeFileUploadAllData(fileSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[FQA Result Creation] removeFileUploadAllBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[FQA Result Creation] removeFileUploadAllBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0223]retrieving Total Loss Request. <br>
	 *
	 * @param String fileSeq
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO searchFileUploadBasic(String fileSeq, SignOnUserAccount account) throws EventException{
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();

		try {
			List<CustomMnrFileAtchVO> customMnrFileAtchVOs = dbDao.searchFileUploadData(fileSeq);
			interfaceGRPVO.setListCustomMnrFileAtchVOs(customMnrFileAtchVOs);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchFileUploadBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchFileUploadBasic"}).getMessage(),de);
		}
		return interfaceGRPVO;
	}

	/**
	 * [EES_MNR_0036]handling M&R Document Transmission. <br>
	 *
	 * @param DocResultVO docResultVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String docSendBasic(DocResultVO docResultVO, SignOnUserAccount account) throws EventException{

		String trsmModCd=docResultVO.getTrsmModCd();
		String mnrRefNo="";
		String ifTrcSeq="";
		StringBuffer flatFile = new StringBuffer("");
		int k=1;
		try {

			if(trsmModCd.equals("E")){

				FlatFileHdrVO flatFileHdrVO = dbDao.searchIFEstimateHRDData(docResultVO);

				flatFile.append("$$$MSGSTART:"+flatFileHdrVO.getMsgId()+"\n");
				flatFile.append("ORD_NO:"+flatFileHdrVO.getOrdNo()+"\n");
				flatFile.append("MSG_RVS_NO:"+flatFileHdrVO.getMsgRvsNo()+"\n");
				flatFile.append("REF_NO:"+flatFileHdrVO.getRefNo()+"\n");
				flatFile.append("EQ_TYPE:"+flatFileHdrVO.getEqType()+"\n");
				flatFile.append("EQ_PREFIX:"+flatFileHdrVO.getEqPrefix()+"\n");
				flatFile.append("EQ_NO:"+flatFileHdrVO.getEqNo() +"\n");
				flatFile.append("COM_OFC_CD:"+flatFileHdrVO.getcomOfcCd()+"\n");	
				flatFile.append("AUTH_SENDER:"+flatFileHdrVO.getAuthSendor()+"\n");
				flatFile.append("VENDOR_EDI_ADDR:"+flatFileHdrVO.getVendorEdiAddr()+"\n");
				flatFile.append("SPCF_RECPT:"+flatFileHdrVO.getSpcfRecpt()+"\n");
				flatFile.append("ACT_TRANS_DT:"+flatFileHdrVO.getActTransDt()+"\n");
				flatFile.append("ORD_DT:"+flatFileHdrVO.getOrdDt()+"\n");
				flatFile.append("EQ_TPSZ:"+flatFileHdrVO.getEqTpsz()+"\n");
				flatFile.append("CUR_CD:"+flatFileHdrVO.getCurCd()+"\n");
				flatFile.append("LAB_TOT:"+flatFileHdrVO.getLabTot()+"\n");
				flatFile.append("MAT_TOT:"+flatFileHdrVO.getMatTot()+"\n");
				flatFile.append("HAN_TOT:"+flatFileHdrVO.getHanTot()+"\n");
				flatFile.append("TAX:"+flatFileHdrVO.getTax()+"\n");
				flatFile.append("TOT_INV_AMT:"+flatFileHdrVO.getTotInvAmt()+"\n");
				flatFile.append("EDI_ID:"+flatFileHdrVO.getEdiId()+"\n");
				flatFile.append("REMARK:"+flatFileHdrVO.getRemark()+"\n");
				flatFile.append("ORD_GRND_TOT:"+flatFileHdrVO.getOrdGrndTot()+"\n");
				flatFile.append("DPP_CUR:"+flatFileHdrVO.getDppCur()+"\n");
				flatFile.append("DPP:"+flatFileHdrVO.getDpp()+"\n");

				List<FlatFileDtlVO> flatFileDtlVOS = dbDao.searchIFEstimateDTLData(docResultVO);
				if(flatFileDtlVOS != null){
					for(int i = 0;i < flatFileDtlVOS.size();i++){
						flatFile.append("{DETAIL\n");
						flatFile.append("LINE_NO:"+k+"\n");
						flatFile.append("DAM_LOC_CD:"+flatFileDtlVOS.get(i).getDamLocCd()+"\n");
						flatFile.append("COMPNT_CD:"+flatFileDtlVOS.get(i).getCompntCd()+"\n");
						flatFile.append("DAM_TP_CD:"+flatFileDtlVOS.get(i).getDamTpCd()+"\n");
						flatFile.append("COMPNT_MAT_CD:"+flatFileDtlVOS.get(i).getCompntMatCd()+"\n");
						flatFile.append("REPR_METH_CD:"+flatFileDtlVOS.get(i).getReprMethCd()+"\n");
						flatFile.append("QUANTITY:"+flatFileDtlVOS.get(i).getQuantity()+"\n");
						flatFile.append("MEA_UNIT_SPEC:"+flatFileDtlVOS.get(i).getMeaUnitSpec()+"\n");
						flatFile.append("DIM_LEN:"+flatFileDtlVOS.get(i).getDimLen()+"\n");
						flatFile.append("DIM_WID:"+flatFileDtlVOS.get(i).getDimWid()+"\n");
						flatFile.append("MAN_HOUR:"+flatFileDtlVOS.get(i).getManHour()+"\n");
						if(flatFileDtlVOS.get(i).getLabRate().equals("")){
							flatFile.append("LAB_RATE:" + "0" +"\n");
						} else {
							flatFile.append("LAB_RATE:" + flatFileDtlVOS.get(i).getLabRate() + "\n");
						}
						flatFile.append("MATRL_COST:"+flatFileDtlVOS.get(i).getMatrlCost()+"\n");
						flatFile.append("RESPON:"+flatFileDtlVOS.get(i).getRespon()+"\n");
						flatFile.append("}DETAIL\n");
						k++;
					}
				}
				//log.error("########flatFile= " + flatFile.toString());

				docResultVO.setFlatFile(flatFile.toString());
				mnrRefNo = eaiDao.sendEDIData(docResultVO);
			}else if(trsmModCd.equals("F")){
				mnrRefNo = eaiDao.sendFaxData(docResultVO);
			}else if(trsmModCd.equals("M")){
				mnrRefNo = eaiDao.sendMailData(docResultVO);
			}

			ifTrcSeq = dbDao.searchMnrIfTrcSeqData();

			docResultVO.setMnrRefNo(mnrRefNo);
			docResultVO.setIfTrcSeq(ifTrcSeq);
			dbDao.addInterfaceTraceData(docResultVO);

		} catch (MailerAppException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Document Transmission] docSendBasic"}).getMessage(),de);
		} catch (EAIException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Document Transmission] docSendBasic"}).getMessage(),de);
		}  catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Document Transmission] docSendBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Document Transmission] docSendBasic"}).getMessage(),de);
		}
		return  ifTrcSeq;
	}
	
	/**
	 * [EES_MNR_0159]sending Text mail. <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO sendGeneralMailBasic(InterfaceGRPVO interfaceGRPVO) throws EventException {
		try {
			eaiDao.sendGeneralMailData(interfaceGRPVO.getGeneralMailFormVOS());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Confirm] sendGeneralMailBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Confirm] sendGeneralMailBasic"}).getMessage(),de);
		}
		return interfaceGRPVO;
	}

	/**
	 * [EES_MNR_0157]sending Html Template mail. <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO sendHtmlMailBasic(InterfaceGRPVO interfaceGRPVO) throws EventException {
		try {
			eaiDao.sendHtmlMailData(interfaceGRPVO.getEmailSendInfoVOS());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Approval] sendHtmlMailBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Approval] sendHtmlMailBasic"}).getMessage(),de);
		}
		return interfaceGRPVO;
	}
	
	/**
	 * Checking The Invoice No.
	 * @param CheckInvoiceNoVO checkInvoiceNoVO
	 * @return List<CheckInvoiceNoVO>
	 * @exception EventException
	 */
	public List<CheckInvoiceNoVO> checkInvoiceNo(CheckInvoiceNoVO checkInvoiceNoVO) throws EventException {
		
		List<CheckInvoiceNoVO> list = null;
		
		try {
			 list = dbDao.checkInvoiceNo(checkInvoiceNoVO);
		} catch (DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(de.getMessage());
			//throw new EventException(new ErrorHandler("CSR10005",new String[]{}).getMessage(), de);
		}
		
		return list;
	}
	
	
	
	/**
	 * handling New Port Receive MQ <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO manageMQNewPortRepairInvoiceBasic(InterfaceGRPVO interfaceGRPVO) throws EventException {
		String eaiRecMsg = interfaceGRPVO.getEaiRecMsg();
		try {
			List<String> dtlVec = new ArrayList<String>();

			int headerStart = eaiRecMsg.indexOf("CUR_CD",0);
			//************ setting header and detail. ********************//
//			int headerStart = eaiRecMsg.indexOf("CUR_CD",0); // HEAD의 DATA 시작
			log.debug("----------------------------------");
			log.debug(eaiRecMsg);
			log.debug("----------------------------------");
			String[] allHeadArray = eaiRecMsg.substring(headerStart).toUpperCase().trim().split("\\{HEAD"); // HEAD의 총 갯수
			
			// Temp Table VO
			CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = new CustomMnrOrdTmpHdrVO[allHeadArray.length];
			CustomMnrOrdTmpDtlVO[][] customMnrOrdTmpDtlVOs = new CustomMnrOrdTmpDtlVO[allHeadArray.length][];
			
			// Real Table VO
//			CustomMnrOrdHdrVO[][] customMnrOrdHdrVOs = new CustomMnrOrdHdrVO[allHeadArray.length][];
//			CustomMnrOrdDtlVO[][] customMnrOrdDtlVOs = new CustomMnrOrdDtlVO[allHeadArray.length][];
			String batParam = "";
			StringBuffer batTmp = new StringBuffer();
			
			for(int x= 0 ; x < allHeadArray.length ; x++){
				customMnrOrdTmpHdrVOs[x] = new CustomMnrOrdTmpHdrVO(); // 초기화
				StringBuffer tmp = new StringBuffer("{HEAD \n");
				tmp.append(allHeadArray[x]);
				allHeadArray[x] = tmp.toString();
			    int headFirst = allHeadArray[x].indexOf("{HEAD");
				int headerLast = allHeadArray[x].indexOf("}HEAD",headFirst);
				String header = allHeadArray[x].substring(headFirst, headerLast);
				
				
				int findIndex = headerLast;
				int detailFirst = 0;
				
				while((detailFirst = allHeadArray[x].indexOf("SEQ:",findIndex)) != -1){ // 각 HEAD 에 속한 DETAIL의 갯수를 구함.
					findIndex = allHeadArray[x].indexOf("}DETAIL",detailFirst);
					dtlVec.add(allHeadArray[x].substring(detailFirst,findIndex));
				}
				//************ setting header and detail. END ********************//
	
				String[] headerEntity = header.split("\n");
				if(dtlVec != null)
					customMnrOrdTmpDtlVOs[x] = new CustomMnrOrdTmpDtlVO[dtlVec.size()];
				// Real Sucess Data VO
//				customMnrOrdHdrVOs[x] = new CustomMnrOrdHdrVO[dtlVec.size()];
//				customMnrOrdDtlVOs[x] = new CustomMnrOrdDtlVO[dtlVec.size()];
	
				CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO = new CustomMnrOrdTmpHdrVO();
				
				String sMnrRcvOrdInvTmpSeq = dbDao.searchMnrOrdTmpHdrSeqData(); // NextVal 로 SEQ 생성.
	
				for(int i = 0;i < headerEntity.length ;i++){
	
					String tempText = headerEntity[i].replaceAll("\r","");
					tempText = tempText.replaceAll("\n","");
					String[] tempEntity = tempText.split(":");
	
					String entityValue = "";
					if(tempEntity.length == 2){
						entityValue = tempEntity[1].trim();
					}
	
					//creating VO of heater data 
					if(tempEntity[0].startsWith("CUR_CD")){
						customMnrOrdTmpHdrVO.setMnrRcvOrdInvTmpSeq(sMnrRcvOrdInvTmpSeq);
						customMnrOrdTmpHdrVO.setCurrCd(entityValue);
						customMnrOrdTmpHdrVOs[x].setCurrCd(entityValue);
						customMnrOrdTmpHdrVOs[x].setMnrRcvOrdInvTmpSeq(sMnrRcvOrdInvTmpSeq);
					} else if(tempEntity[0].startsWith("VND_CD")){
						customMnrOrdTmpHdrVO.setVndrSeq(entityValue);
						customMnrOrdTmpHdrVOs[x].setVndrSeq(entityValue);
					} else if(tempEntity[0].startsWith("INV_TOT")){
						if(entityValue.equals("")){
							customMnrOrdTmpHdrVO.setInvAmt("0");
						} else {
							char chars[] = entityValue.toCharArray();
							boolean checkIsNumber = true;
							for(int k = 0; k < chars.length;k ++){
								if((chars[k] < '0' || chars[k] > '9') && chars[k] != '.') {
									checkIsNumber = false;
								}
							}
	
							if(!checkIsNumber){
								customMnrOrdTmpHdrVO.setInvAmt("0");
								customMnrOrdTmpHdrVOs[x].setInvAmt("0");
							} else {
								//showing to 2 decimal places
								String checkVal = entityValue;
								int findIdx = checkVal.indexOf(".");
								if(findIdx != -1){
									String temp = checkVal.substring(findIdx, checkVal.length()).replaceAll("\\.", "");
									int len = temp.length();
									if(len > 2){
										entityValue = checkVal.substring(0, checkVal.length() - (len - 2));
									}
								}
								customMnrOrdTmpHdrVO.setInvAmt(entityValue);
								customMnrOrdTmpHdrVOs[x].setInvAmt(entityValue);
							}
						}
	
					} else if(tempEntity[0].startsWith("INV_VAT")){
						if(entityValue.equals("")){
							customMnrOrdTmpHdrVO.setVatAmt("0");
							customMnrOrdTmpHdrVOs[x].setVatAmt("0");
						} else {
							char chars[] = entityValue.toCharArray();
							boolean checkIsNumber = true;
							for(int k = 0; k < chars.length;k ++){
								if((chars[k] < '0' || chars[k] > '9') && chars[k] != '.') {
									checkIsNumber = false;
								}
							}
	
							if(!checkIsNumber){
								customMnrOrdTmpHdrVO.setVatAmt("0");
								customMnrOrdTmpHdrVOs[x].setVatAmt("0");
							} else {
								//showing to 2 decimal places
								String checkVal = entityValue;
								int findIdx = checkVal.indexOf(".");
								if(findIdx != -1){
									String temp = checkVal.substring(findIdx, checkVal.length()).replaceAll("\\.", "");
									int len = temp.length();
									if(len > 2){
										entityValue = checkVal.substring(0, checkVal.length() - (len - 2));
									}
								}
								customMnrOrdTmpHdrVO.setVatAmt(entityValue);
								customMnrOrdTmpHdrVOs[x].setVatAmt(entityValue);
							}
						}
					} else if(tempEntity[0].startsWith("WITHHOLD")){
						if(entityValue.equals("")){
							customMnrOrdTmpHdrVO.setInvWhldTaxAmt("0");
							customMnrOrdTmpHdrVOs[x].setInvWhldTaxAmt("0");
						} else {
							char chars[] = entityValue.toCharArray();
							boolean checkIsNumber = true;
							for(int k = 0; k < chars.length;k ++){
								if((chars[k] < '0' || chars[k] > '9') && chars[k] != '.') {
									checkIsNumber = false;
								}
							}
	
							if(!checkIsNumber){
								customMnrOrdTmpHdrVO.setInvWhldTaxAmt("0");
								customMnrOrdTmpHdrVOs[x].setInvWhldTaxAmt("0");
							} else {
								//showing to 2 decimal places
								String checkVal = entityValue;
								int findIdx = checkVal.indexOf(".");
								if(findIdx != -1){
									String temp = checkVal.substring(findIdx, checkVal.length()).replaceAll("\\.", "");
									int len = temp.length();
									if(len > 2){
										entityValue = checkVal.substring(0, checkVal.length() - (len - 2));
									}
								}
								customMnrOrdTmpHdrVO.setInvWhldTaxAmt(entityValue);
								customMnrOrdTmpHdrVOs[x].setInvWhldTaxAmt(entityValue);
							}
						}
					} else if(tempEntity[0].startsWith("INV_NBR")){
						customMnrOrdTmpHdrVO.setInvNo(entityValue);
						customMnrOrdTmpHdrVOs[x].setInvNo(entityValue);
						if(x == 0){
							batTmp.append(entityValue);
						}else{
							batTmp.append(",").append(entityValue);
						}
					} else if(tempEntity[0].startsWith("RCV_DT")){
						customMnrOrdTmpHdrVO.setCreDt("");
						customMnrOrdTmpHdrVO.setRcvDt(entityValue);
						customMnrOrdTmpHdrVOs[x].setRcvDt(entityValue);
					} else if(tempEntity[0].startsWith("INV_DT")){
						customMnrOrdTmpHdrVO.setInvCfmDt(entityValue);
						customMnrOrdTmpHdrVOs[x].setInvCfmDt(entityValue);
					} else if(tempEntity[0].startsWith("OFC_CD")){
						customMnrOrdTmpHdrVO.setCostOfcCd(entityValue);
						customMnrOrdTmpHdrVOs[x].setCostOfcCd(entityValue);
					}  
					
				}
	
				//*************** checking date format *******************//
	
				String tempToday  = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
	
				if(!"".equals(customMnrOrdTmpHdrVO.getCreDt())){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
					ParsePosition pos = new ParsePosition(0);
					Date date = sdf.parse(customMnrOrdTmpHdrVO.getCreDt(),pos);
					if(date == null){
						customMnrOrdTmpHdrVO.setCreDt(tempToday);
						customMnrOrdTmpHdrVO.setUpdDt(tempToday);
						customMnrOrdTmpHdrVO.setCreUsrId("NEWPORT");
						customMnrOrdTmpHdrVO.setUpdUsrId("NEWPORT");
						customMnrOrdTmpHdrVOs[x].setCreUsrId("NEWPORT"); 
						customMnrOrdTmpHdrVOs[x].setUpdUsrId("NEWPORT"); 
					}
				} else {
					customMnrOrdTmpHdrVO.setCreDt(tempToday);
					customMnrOrdTmpHdrVO.setUpdDt(tempToday);
					customMnrOrdTmpHdrVO.setCreUsrId("NEWPORT");
					customMnrOrdTmpHdrVO.setUpdUsrId("NEWPORT");
					customMnrOrdTmpHdrVOs[x].setCreUsrId("NEWPORT"); 
					customMnrOrdTmpHdrVOs[x].setUpdUsrId("NEWPORT"); 
				}
				
				if(!"".equals(customMnrOrdTmpHdrVO.getRcvDt()) ){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
					ParsePosition pos = new ParsePosition(0);
					Date date = sdf.parse(customMnrOrdTmpHdrVO.getRcvDt(),pos);
					if(date == null){
						customMnrOrdTmpHdrVO.setRcvDt(tempToday);
						customMnrOrdTmpHdrVOs[x].setRcvDt(tempToday); 
					}
				} else {
					customMnrOrdTmpHdrVO.setRcvDt(tempToday);
					customMnrOrdTmpHdrVOs[x].setRcvDt(tempToday); 
				}
				
				if(!"".equals(customMnrOrdTmpHdrVO.getInvCfmDt()) ){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
					ParsePosition pos = new ParsePosition(0);
					Date date = sdf.parse(customMnrOrdTmpHdrVO.getInvCfmDt(),pos);
					if(date == null){
						customMnrOrdTmpHdrVO.setInvCfmDt(tempToday);
						customMnrOrdTmpHdrVOs[x].setInvCfmDt(tempToday); 
					}
				} else {
					customMnrOrdTmpHdrVO.setInvCfmDt(tempToday);
					customMnrOrdTmpHdrVOs[x].setInvCfmDt(tempToday);
				}
				
				customMnrOrdTmpHdrVOs[x].setVrfyRsltDesc(""); 
				customMnrOrdTmpHdrVO.setVrfyRsltDesc("");
				
				//HDR DATA INSERT
				dbDao.addTempNewPortHDRData(customMnrOrdTmpHdrVO);
				
				
				CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO = null;
				if(dtlVec != null){
					//handling DTL data
					for(int i = 0;i < dtlVec.size();i++){
						customMnrOrdTmpDtlVOs[x][i] = new CustomMnrOrdTmpDtlVO();
	
						String[] dtlEntity = dtlVec.get(i).split("\n");
						
						customMnrOrdTmpDtlVO = new CustomMnrOrdTmpDtlVO();
						
						String qty = "";
		
						for(int j = 0;j < dtlEntity.length ;j++){
							String tempText = dtlEntity[j].replaceAll("\r","");
							tempText = tempText.replaceAll("\n","");
							String[] tempEntity = tempText.split(":");
		
							String entityValue = "";
							if(tempEntity.length == 2){
								entityValue = tempEntity[1].trim();
							}
		
							// creating detail data VO
							if(tempEntity[0].startsWith("SEQ")){
								customMnrOrdTmpDtlVO.setMnrOrdSeq(entityValue);
								customMnrOrdTmpDtlVO.setOrdDtlSeq("1");
								customMnrOrdTmpDtlVO.setMnrRcvOrdInvTmpSeq(sMnrRcvOrdInvTmpSeq);
								customMnrOrdTmpDtlVO.setMnrRcvOrdInvTmpDtlSeq(entityValue);
							} else if(tempEntity[0].startsWith("EQ_TYPE")){
								
								customMnrOrdTmpDtlVO.setEqTpszCd(entityValue);
								
							} else if(tempEntity[0].startsWith("EQ_NBR")){
								customMnrOrdTmpDtlVO.setEqNo(entityValue);
								customMnrOrdTmpDtlVO.setEqKndCd(customMnrOrdTmpDtlVO.getEqNo().substring(3,4));
							} else if(tempEntity[0].startsWith("EQ_FM")){
								customMnrOrdTmpDtlVO.setEqStsCd(entityValue);
							} else if(tempEntity[0].startsWith("EQ_CNT")){
								if(entityValue.equals("")){
									qty = "0";
								} else {
									char chars[] = entityValue.toCharArray();
									boolean checkIsNumber = true;
									for(int k = 0; k < chars.length;k ++){
										if((chars[k] < '0' || chars[k] > '9') && chars[k] != '.') {
											checkIsNumber = false;
											break;
										
										} else if(chars[k] == '.') {
											
											if(k == 0){
												checkIsNumber = false;
												break;
											} else {
												checkIsNumber = true;
												entityValue = entityValue.substring(0, k);
												break;
											}
										}
									}
		
									if(!checkIsNumber){
										qty = "0";
									} else {
										qty = entityValue;
									}
								}						
								customMnrOrdTmpDtlVO.setRprQty(qty);
								
							} else if(tempEntity[0].startsWith("CUR_CD")){
								customMnrOrdTmpDtlVO.setCurrCd(entityValue);
							} else if(tempEntity[0].startsWith("COST")){
								if(entityValue.equals("")){
									customMnrOrdTmpDtlVO.setInvAmt("0");
								} else {
									char chars[] = entityValue.toCharArray();
									boolean checkIsNumber = true;
									for(int k = 0; k < chars.length;k ++){
										if((chars[k] < '0' || chars[k] > '9') && chars[k] != '.') {
											checkIsNumber = false;
										}
									}
		
									if(!checkIsNumber){
										customMnrOrdTmpDtlVO.setInvAmt("0");
									} else {
										//showing to 2 decimal places
										String checkVal = entityValue;
										int findIdx = checkVal.indexOf(".");
										if(findIdx != -1){
											String temp = checkVal.substring(findIdx, checkVal.length()).replaceAll("\\.", "");
											int len = temp.length();
											if(len > 2){
												entityValue = checkVal.substring(0, checkVal.length() - (len - 2));
											}
										}
										customMnrOrdTmpDtlVO.setInvAmt(entityValue);
									}
								}	
								
							//	customMnrOrdTmpDtlVO.setInvAmt(String.format("%.2f", customMnrOrdTmpDtlVO.getInvAmt()));
								customMnrOrdTmpDtlVO.setInvAmt(customMnrOrdTmpDtlVO.getInvAmt());
							} else if(tempEntity[0].startsWith("EVENT_DT")){
								customMnrOrdTmpDtlVO.setCreDt("");
								customMnrOrdTmpDtlVO.setRprRsltDt(entityValue);
							} else if(tempEntity[0].startsWith("EVENT_YD")){
								customMnrOrdTmpDtlVO.setYdCd(entityValue);
							} else if(tempEntity[0].startsWith("TARIFF_CD")){
								if(entityValue.length() > 8){
									customMnrOrdTmpDtlVO.setCostCd(entityValue.substring(0, 6));
								}else if(entityValue.length() == 8){
									customMnrOrdTmpDtlVO.setCostCd(entityValue.substring(0, 6));
									customMnrOrdTmpDtlVO.setCostDtlCd(entityValue.substring(6, 8));
								}else if(entityValue.length() == 7){
									customMnrOrdTmpDtlVO.setCostCd(entityValue.substring(0, 6));
								}else{
									customMnrOrdTmpDtlVO.setCostCd(entityValue);
								}
							} else if(tempEntity[0].startsWith("VND_CD")){
								customMnrOrdTmpDtlVO.setVndrSeq(entityValue);
							} else if(tempEntity[0].startsWith("WORDER_NBR")){
								customMnrOrdTmpDtlVO.setRqstRefNo(entityValue);
							} else if(tempEntity[0].startsWith("VSL_CD")){
								customMnrOrdTmpDtlVO.setVslCd(entityValue);
							} else if(tempEntity[0].startsWith("VOY_NBR")){
								if(entityValue.length() > 4)
									customMnrOrdTmpDtlVO.setSkdVoyNo(entityValue.substring(0,4));
							} else if(tempEntity[0].startsWith("EVENT_LOC")){
								customMnrOrdTmpDtlVO.setPortCd(entityValue);
							} else if(tempEntity[0].startsWith("SVC_CD")){
								customMnrOrdTmpDtlVO.setSlanCd(entityValue);
							}
							
						}
						
						String sMnrRcvOrdInvTmpDtlSeq = dbDao.searchMnrOrdTmpDtlSeqData(customMnrOrdTmpDtlVO); // DTL_SEQ 구함.
						
						customMnrOrdTmpDtlVO.setMnrRcvOrdInvTmpDtlSeq(sMnrRcvOrdInvTmpDtlSeq);
	
						//*************** checking date format *******************//
		
						if(!"".equals(customMnrOrdTmpDtlVO.getCreDt())){
							SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
							ParsePosition pos = new ParsePosition(0);
							Date date = sdf.parse(customMnrOrdTmpDtlVO.getCreDt(),pos);
							if(date == null){
								customMnrOrdTmpDtlVO.setCreDt(tempToday);
								customMnrOrdTmpDtlVO.setUpdDt(tempToday);
								customMnrOrdTmpDtlVO.setCreUsrId("NEWPORT");
								customMnrOrdTmpDtlVO.setUpdUsrId("NEWPORT");
							}
						} else {
							customMnrOrdTmpDtlVO.setCreDt(tempToday);
							customMnrOrdTmpDtlVO.setUpdDt(tempToday);
							customMnrOrdTmpDtlVO.setCreUsrId("NEWPORT");
							customMnrOrdTmpDtlVO.setUpdUsrId("NEWPORT");
						}
						
						if(!"".equals(customMnrOrdTmpDtlVO.getRprRsltDt()) ){
							SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
							ParsePosition pos = new ParsePosition(0);
							Date date = sdf.parse(customMnrOrdTmpDtlVO.getRprRsltDt(),pos);
							if(date == null){
								customMnrOrdTmpDtlVO.setRprRsltDt(tempToday);
							}
						} else {
							customMnrOrdTmpDtlVO.setRprRsltDt(tempToday);
						}
						
						customMnrOrdTmpDtlVO.setVrfyRsltDesc("");
						customMnrOrdTmpDtlVOs[x][i].setVrfyRsltDesc(""); 
						
						//===== Check Logic End ===================//
	
						//DTL DATA INSERT
						dbDao.addTempNewPortDTLData(customMnrOrdTmpDtlVO);
						customMnrOrdTmpDtlVOs[x][i] = customMnrOrdTmpDtlVO;
					}
					if(dtlVec != null) dtlVec.clear();
				}
				interfaceGRPVO.setCustomMnrOrdTmpHdrVO(customMnrOrdTmpHdrVO);
			}
			batParam = batTmp.toString();
			
			interfaceGRPVO.setBatParam(batParam);
			interfaceGRPVO.setArrayCustomMnrOrdTmpHdrVOs(customMnrOrdTmpHdrVOs);
			interfaceGRPVO.setArrayCustomMnrOrdTmpDtlVOs(customMnrOrdTmpDtlVOs);
		} catch (StringIndexOutOfBoundsException de) {
			log.error("\nEDI Format Error SEND Msg :\n" + eaiRecMsg + "\n");
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling NewPort MQ] manageMQNewPortRepairInvoiceBasic"}).getMessage(),de);
		} catch (DAOException de) {
			log.error("\nEDI DAOException Error SEND Msg :\n" + eaiRecMsg + "\n");
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling NewPort MQ] manageMQNewPortRepairInvoiceBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("\nEDI Exception Error SEND Msg :\n" + eaiRecMsg + "\n");
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling NewPort MQ] manageMQNewPortRepairInvoiceBasic"}).getMessage(),de);
		}
		return interfaceGRPVO;
	}
	
	/**
	 * Verifying New Port Invoice
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO verifyNewPortTempDataBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException {
		try{
			CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = interfaceGRPVO.getArrayCustomMnrOrdTmpHdrVOs();
			CustomMnrOrdTmpDtlVO[][] customMnrOrdTmpDtlVOs =  new CustomMnrOrdTmpDtlVO[customMnrOrdTmpHdrVOs.length][];
			List<CustomMnrOrdTmpDtlVO> listMnrOrdTmpDtlVO = new ArrayList<CustomMnrOrdTmpDtlVO>();
			
			String sVndrSeq = "";

			CheckInvoiceNoVO checkInvoiceNoVO = new CheckInvoiceNoVO();
			CustomMnrEqStsVVO eqInfo = new CustomMnrEqStsVVO();
			
			GeneralCodeCheckMgtBC command2 = new GeneralCodeCheckMgtBCImpl();
			GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
			GeneralCodeINVO generalCodeINVO = new GeneralCodeINVO();
			
			for(int i = 0; i < customMnrOrdTmpHdrVOs.length; i++){
//				Double invTot = 0.00;
				BigDecimal invTotal = new BigDecimal("0.00");
				// Valid Service Provider Code.HEADER.VND_CD 와 DETAIL.VND_CD를 각각 MDM_VENDOR 등록되어 있어야 함 : US
				sVndrSeq = dbDao.searchMnrOrdTmpVndrSeqData(customMnrOrdTmpHdrVOs[i].getVndrSeq());
				customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("");
				if("".equals(sVndrSeq) || sVndrSeq == null){
					customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("US");
				}
				else if( !"SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
					customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("SS"); 
				}

				checkInvoiceNoVO.setInvNo(customMnrOrdTmpHdrVOs[i].getInvNo());
				if(sVndrSeq != null){
					checkInvoiceNoVO.setVndrSeq(sVndrSeq);
				}
				checkInvoiceNoVO.setRefPk("");

				List<CheckInvoiceNoVO> list = checkInvoiceNo(checkInvoiceNoVO);  // Invoice NO DUP. CHECK LOGIC
				if(list != null && list.size() > 0){
					if(!"".equals(list.get(0).getInvNo()) || list.get(0).getInvNo() != null){
						if(StringUtil.isEmpty(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
							customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("AI"); // Invoice NO DUP Error
						}
						else{
							customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()+";AI"); // Invoice NO DUP Error
						}
					}   
					list.clear();
				}
				
				String dpPrcsKnt = dbDao.searchCurrencyDecimalData(customMnrOrdTmpHdrVOs[i].getCurrCd());
				int dpCnt = Integer.parseInt(dpPrcsKnt);
				
				generalCodeINVO.setCheckType("OFC");
				generalCodeINVO.setCheckValue(customMnrOrdTmpHdrVOs[i].getCostOfcCd());
				generalCodeCheckMgtGRPVO.setGeneralCodeINVO(generalCodeINVO);
				
				generalCodeCheckMgtGRPVO = command2.checkGeneralCodeBasic(generalCodeCheckMgtGRPVO);
				
				if(generalCodeCheckMgtGRPVO.getCustomMnrGeneralCodeVOS() == null || generalCodeCheckMgtGRPVO.getCustomMnrGeneralCodeVOS().size() == 0){
					if(StringUtil.isEmpty(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("UO"); // Invoice NO DUP Error
					}
					else{
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()+";UO"); // Invoice NO DUP Error
					}
					generalCodeCheckMgtGRPVO.getCustomMnrGeneralCodeVOS().clear();
				}
				
				listMnrOrdTmpDtlVO = dbDao.searchMnrOrdTmpDtlData(customMnrOrdTmpHdrVOs[i]);
				customMnrOrdTmpDtlVOs[i] = new CustomMnrOrdTmpDtlVO[listMnrOrdTmpDtlVO.size()];
				for(int k=0; k < listMnrOrdTmpDtlVO.size(); k++){
					customMnrOrdTmpDtlVOs[i][k] = listMnrOrdTmpDtlVO.get(k);
				}
				
				for(int j = 0; j < customMnrOrdTmpDtlVOs[i].length; j++){

					EQGeneralInfoINVO eQGeneralInfoINVO = new EQGeneralInfoINVO();
					eQGeneralInfoINVO.setEqNo(customMnrOrdTmpDtlVOs[i][j].getEqNo());
					eQGeneralInfoINVO.setTotalLossDate(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());
					
					List<CustomMnrEqStsVVO> eqlist = dbDao.searchEqInfoData(eQGeneralInfoINVO);
					
					customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("");

					if(eqlist != null && eqlist.size() > 0){
						eqInfo = eqlist.get(0);
							if(!"U".equals(customMnrOrdTmpDtlVOs[i][j].getEqKndCd()) && !"Z".equals(customMnrOrdTmpDtlVOs[i][j].getEqKndCd()) && !"G".equals(customMnrOrdTmpDtlVOs[i][j].getEqKndCd())){
								customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("UE");
							}
							else if( "".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
								customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("SS");
							}
							
							customMnrOrdTmpDtlVOs[i][j].setEqTpszCd(eqInfo.getEqTpszCd());
							customMnrOrdTmpDtlVOs[i][j].setEqKndCd(eqInfo.getEqType());
							customMnrOrdTmpDtlVOs[i][j].setEqStsCd(eqInfo.getCntrStsCd());
							
							// Valid Cost Code. _ DETAIL.TARIFF_CD (SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_ID_CD = DEATIL.EQ_TYPE||'G' : CG
							String sCostCd = dbDao.searchMnrOrdTmpCostCdData(customMnrOrdTmpDtlVOs[i][j].getCostCd(),customMnrOrdTmpDtlVOs[i][j].getEqKndCd());
							String sCostDtlCd = dbDao.searchMnrOrdTmpCostDtlCdData(customMnrOrdTmpDtlVOs[i][j].getCostCd(), customMnrOrdTmpDtlVOs[i][j].getCostDtlCd());
							
							if(("".equals(sCostCd) || sCostCd == null)||("".equals(sCostDtlCd) || sCostDtlCd == null)){
								if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CG");
								}
								else{
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CG");
								}
//								bSusses = false;
							}
							else if( "".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
								customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("SS"); 
							}	
							
							// Valid Service Provider Code.HEADER.VND_CD 와 DETAIL.VND_CD를 각각 MDM_VENDOR 등록되어 있어야 함 : US
							sVndrSeq = dbDao.searchMnrOrdTmpVndrSeqData(customMnrOrdTmpDtlVOs[i][j].getVndrSeq());
							
							if("".equals(sVndrSeq) || sVndrSeq == null){
								if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("US");
								}
								else{
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";US");
								}
//								bSusses = false;
							}
							else if( "".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
								customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("SS"); 
							}
							
							//activity date & place check
							if("U".equals(customMnrOrdTmpDtlVOs[i][j].getEqKndCd())&&customMnrOrdTmpDtlVOs[i][j].getCostCd().endsWith("RC")){
								List<MVMTListbyDMGEvntDateVO> listVO = new ArrayList<MVMTListbyDMGEvntDateVO>();
								String eventTime = dbDao.searchMvmtTimeData(customMnrOrdTmpDtlVOs[i][j].getEqNo(), customMnrOrdTmpDtlVOs[i][j].getRprRsltDt(), customMnrOrdTmpDtlVOs[i][j].getYdCd(), "MT");
								if("".equals(eventTime)){
									eventTime = dbDao.searchMvmtTimeData(customMnrOrdTmpDtlVOs[i][j].getEqNo(), customMnrOrdTmpDtlVOs[i][j].getRprRsltDt(), customMnrOrdTmpDtlVOs[i][j].getYdCd(), "");
									if("".equals(eventTime)){
										eventTime = "2359";
									}
								}
								String damageFlg = ctmDao2.getCntrDamageFlg(customMnrOrdTmpDtlVOs[i][j].getEqNo(),customMnrOrdTmpDtlVOs[i][j].getRprRsltDt()+eventTime, customMnrOrdTmpDtlVOs[i][j].getYdCd());
								
								if (damageFlg == null || damageFlg.equals("")) {
									if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("IW");
									}
									else{
										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";IW");
									}
								} else {
									listVO = ctmDao1.checkMVMTListbyDMGEventDate(customMnrOrdTmpDtlVOs[i][j].getEqNo(), customMnrOrdTmpDtlVOs[i][j].getRprRsltDt()+eventTime, customMnrOrdTmpDtlVOs[i][j].getYdCd(), "N", "N");
									
									if (listVO == null || listVO.size() == 0) {
										listVO = ctmDao1.checkMVMTListbyDMGEventDate(customMnrOrdTmpDtlVOs[i][j].getEqNo(), customMnrOrdTmpDtlVOs[i][j].getRprRsltDt()+eventTime, customMnrOrdTmpDtlVOs[i][j].getYdCd(), "N", "NN");
									}
									
									if (listVO == null || listVO.size() == 0) {
										if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("IW");
										}
										else{
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";IW");
										}
									}else{
										if( "".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("SS");
										}
									}
								}
							}
					}else{
						if("".equals(customMnrOrdTmpDtlVOs[i][j].getEqNo())){
							if(!"".equals(customMnrOrdTmpDtlVOs[i][j].getCostCd())&&!"".equals(customMnrOrdTmpDtlVOs[i][j].getCostDtlCd())) {
								String costCdCheck = dbDao.checkQtyCostCodeData(customMnrOrdTmpDtlVOs[i][j]);
								customMnrOrdTmpDtlVOs[i][j].setEqKndCd(costCdCheck.substring(2,3));
								if("QT".equals(costCdCheck.substring(0,2))){
									String orgCostCd = customMnrOrdTmpDtlVOs[i][j].getCostCdAll();
									String sCostDtlCd = dbDao.searchMnrOrdTmpCostDtlCdData(orgCostCd.substring(0, 6), orgCostCd.substring(6, 8));
									
									if(("".equals(sCostDtlCd) || sCostDtlCd == null)){
										if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CG");
											customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("CG");
										}
										else{
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CG");
											customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("CG");
										}
									}
									else if( "".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("SS"); 
										customMnrOrdTmpDtlVOs[i][j].setCostCd(orgCostCd.substring(0, 6));
										customMnrOrdTmpDtlVOs[i][j].setCostDtlCd(sCostDtlCd);
										customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("SS");
										customMnrOrdTmpDtlVOs[i][j].setQtyFlg("Y");
									}	
								}else{
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("UE"); 
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("UE");
								}
							}else{
								if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CG");
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("CG");
								}
								else{
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CG");
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("CG");
								}
							}
						}else{
							customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("UE"); 
							customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("UE");
						}
					}
					
					if("Y".equals(dbDao.searchAgmtExistData(customMnrOrdTmpDtlVOs[i][j]))){
						String agmtCheck = dbDao.searchAgreementExistData(customMnrOrdTmpDtlVOs[i][j]);
						if(!"".equals(agmtCheck)){
							String costCheck = dbDao.searchCostCdAgmtData(customMnrOrdTmpDtlVOs[i][j]);
//							String costCheck = "";
							
							if(!"OK".equals(costCheck)){
								if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CW"); 
								}else{
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CW");
								}
							}else{
								String costTpSzCheck = dbDao.searchCostTypeSizeData(customMnrOrdTmpDtlVOs[i][j]);
								
								if(!"OK".equals(costTpSzCheck)){
									if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("TW"); 
									}else{
										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CW");
									}
								}else{
									List<CustomMnrAgmtRtVO> customMnrAgmtRtVOS = searchAgmtRateBasic(customMnrOrdTmpDtlVOs[i][j]);
									if(customMnrAgmtRtVOS != null){
										if(customMnrOrdTmpDtlVOs[i][j].getCostCd().endsWith("RC")){ // case of rate 0
											boolean result = false;
											for(int k=0; k < customMnrAgmtRtVOS.size(); k++){
												CustomMnrAgmtRtVO customMnrAgmtRtVO = customMnrAgmtRtVOS.get(k);
												if(!"0".equals(customMnrAgmtRtVO.getAgmtRtAmt())){
													result = true;
												}
											}
											
											if(!result){
												if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
													customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CW"); 
												}else{
													customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CW");
												}
											}
										}
									}else{
										if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("YW"); 
										}else{
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";YW");
										}
									}
								}
								
							}

						}else{
							if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
								customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("EW"); 
							}else{
								customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";EW");
							}
						}
					}
					
					if(!"NEWPORT".equals(customMnrOrdTmpDtlVOs[i][j].getUpdUsrId())){
						customMnrOrdTmpDtlVOs[i][j].setUpdUsrId(account.getUsr_id());
					}

					BigDecimal costAmt = new BigDecimal(customMnrOrdTmpDtlVOs[i][j].getInvAmt());
					BigDecimal roundAmt = costAmt.setScale(dpCnt, RoundingMode.HALF_UP);
					
					if(Double.compare(costAmt.doubleValue(), roundAmt.doubleValue()) != 0){
						if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
							customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("DW"); 
						}else{
							customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";DW"); 
						}
					}
					
					invTotal = invTotal.add(roundAmt);
					dbDao.modifyNewPortTmpDtlData(customMnrOrdTmpDtlVOs[i][j]);
				}
				
				
				log.debug(Double.parseDouble(customMnrOrdTmpHdrVOs[i].getInvAmt())+ "-----" + invTotal.doubleValue());
				BigDecimal invAmt = new BigDecimal(customMnrOrdTmpHdrVOs[i].getInvAmt());
				BigDecimal vatAmt = new BigDecimal(customMnrOrdTmpHdrVOs[i].getVatAmt());
				BigDecimal whldAmt = new BigDecimal(customMnrOrdTmpHdrVOs[i].getInvWhldTaxAmt());
				
				BigDecimal calAmt = invAmt.subtract(vatAmt).add(whldAmt);
				BigDecimal roundAmt = calAmt.setScale(dpCnt, RoundingMode.HALF_UP);
				
				if(Double.compare(calAmt.doubleValue(), roundAmt.doubleValue()) != 0){
					if(StringUtil.isEmpty(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("DW"); // Invoice Amount Error
					}
					else{
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()+";DW"); // Invoice Amount Error
					}
				}

				if(Double.compare(roundAmt.doubleValue(), invTotal.doubleValue()) != 0){
					if(StringUtil.isEmpty(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("UA"); // Invoice Amount Error
					}
					else{
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()+";UA"); // Invoice Amount Error
					}
				}
				
				if(!"NEWPORT".equals(customMnrOrdTmpHdrVOs[i].getUpdUsrId())){
					customMnrOrdTmpHdrVOs[i].setUpdUsrId(account.getUsr_id());
				}
				
				dbDao.modifyNewPortTmpHdrData(customMnrOrdTmpHdrVOs[i]);
			}

			interfaceGRPVO.setArrayCustomMnrOrdTmpHdrVOs(customMnrOrdTmpHdrVOs);
			interfaceGRPVO.setArrayCustomMnrOrdTmpDtlVOs(customMnrOrdTmpDtlVOs);
		} catch (StringIndexOutOfBoundsException de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling NewPort MQ] verifyNewPortTempDataBasic"}).getMessage(),de);
		} catch (DAOException de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling NewPort MQ] verifyNewPortTempDataBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling NewPort MQ] verifyNewPortTempDataBasic"}).getMessage(),de);
		}
		return interfaceGRPVO;
	}
	
	/**
	 * Handling New Port Invoice
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO manageNewPortWOInvoiceDataBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException {
		ExpenseMgtBC command = new ExpenseMgtBCImpl();
		EQFlagMgtBC command3 = new EQFlagMgtBCImpl(); 
		RepairMgtBC command4 = new RepairMgtBCImpl();
		GeneralCodeSearchMgtBC command1 = new GeneralCodeSearchMgtBCImpl();
		
		try{
			CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = interfaceGRPVO.getArrayCustomMnrOrdTmpHdrVOs();
//			CustomMnrOrdTmpDtlVO[][] customMnrOrdTmpDtlVOs = interfaceGRPVO.getArrayCustomMnrOrdTmpDtlVOs();
			CustomMnrOrdTmpDtlVO[][] customMnrOrdTmpDtlVOs =  new CustomMnrOrdTmpDtlVO[customMnrOrdTmpHdrVOs.length][];
			List<CustomMnrOrdTmpDtlVO> listMnrOrdTmpDtlVO = new ArrayList<CustomMnrOrdTmpDtlVO>();
			
			CustomMnrOrdHdrVO[][] customMnrOrdHdrVOs = new CustomMnrOrdHdrVO[customMnrOrdTmpHdrVOs.length][];
			CustomMnrOrdDtlVO[][] customMnrOrdDtlVOs = new CustomMnrOrdDtlVO[customMnrOrdTmpHdrVOs.length][];
			
			PayableInvoiceGRPVO payableInvoiceGRPVO = null;
			
			List<CustomMnrOrdTmpHdrVO> insertMnrOrdTmpHdrVOs = new ArrayList<CustomMnrOrdTmpHdrVO>();
			List<CustomMnrOrdTmpDtlVO> insertMnrOrdTmpDtlVOs = new ArrayList<CustomMnrOrdTmpDtlVO>();

			List<CustomMnrOrdHdrVO> insertMnrOrdHdrVOs = new ArrayList<CustomMnrOrdHdrVO>();
			List<CustomMnrOrdDtlVO> insertMnrOrdDtlVOs = new ArrayList<CustomMnrOrdDtlVO>();
			PayableInvoiceGRPVO payableInvoiceGRPVO2 = new PayableInvoiceGRPVO();
			GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
			
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO(); 
			eQFlagListGRPVO.setEQFlagListINVO(new EQFlagListINVO());
			
			boolean bSusses = true;
			String sVndrSeq = "";
			
			for(int i=0; i<customMnrOrdTmpHdrVOs.length; i++){
				String verifyResult = dbDao.searchTmpDtlVrfyRsltData(customMnrOrdTmpHdrVOs[i].getMnrRcvOrdInvTmpSeq());
				if("SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()) && !"0".equals(verifyResult)){
					customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("UN");
				}
				
				if("SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
					listMnrOrdTmpDtlVO = dbDao.searchMnrOrdTmpDtlData(customMnrOrdTmpHdrVOs[i]);
					customMnrOrdTmpDtlVOs[i] = new CustomMnrOrdTmpDtlVO[listMnrOrdTmpDtlVO.size()];
					for(int k=0; k < listMnrOrdTmpDtlVO.size(); k++){
						customMnrOrdTmpDtlVOs[i][k] = listMnrOrdTmpDtlVO.get(k);
					}
					
					customMnrOrdHdrVOs[i] = new CustomMnrOrdHdrVO[customMnrOrdTmpDtlVOs[i].length];
					customMnrOrdDtlVOs[i] = new CustomMnrOrdDtlVO[customMnrOrdTmpDtlVOs[i].length];
					for(int j=0; j<customMnrOrdTmpDtlVOs[i].length; j++){
						customMnrOrdHdrVOs[i][j] = new CustomMnrOrdHdrVO();
						customMnrOrdDtlVOs[i][j] = new CustomMnrOrdDtlVO();
						
//						log.debug(customMnrOrdTmpDtlVOs[i].length+"------"+customMnrOrdTmpHdrVOs[i].getCostOfcCd().substring(0, 3));
//						log.debug(customMnrOrdTmpHdrVOs[i].getInvNo());
						
						customMnrOrdHdrVOs[i][j].setMnrOrdOfcCtyCd(customMnrOrdTmpHdrVOs[i].getCostOfcCd().substring(0, 3)); // SUBSTR(HEADER.OFC_CD, 1, 3)
						
						String sMnrOrdSeq = dbDao.searchMnrOrdSeqData();
						
						customMnrOrdHdrVOs[i][j].setMnrOrdSeq(sMnrOrdSeq);
						// HEADER
						customMnrOrdHdrVOs[i][j].setEqKndCd(customMnrOrdTmpDtlVOs[i][j].getEqKndCd());			// DETAIL.EQ_NBR
						customMnrOrdHdrVOs[i][j].setCostCd(customMnrOrdTmpDtlVOs[i][j].getCostCd());			// DETAIL.TARIFF_CD (Need to convert code eg. "MRDRRC"
						customMnrOrdHdrVOs[i][j].setVndrSeq(customMnrOrdTmpHdrVOs[i].getVndrSeq()); 		// HEADER.VND_CD
						customMnrOrdHdrVOs[i][j].setCurrCd(customMnrOrdTmpHdrVOs[i].getCurrCd());			// HEADER.CUR_CD
						customMnrOrdHdrVOs[i][j].setCostOfcCd(customMnrOrdTmpHdrVOs[i].getCostOfcCd()); 	// HEADER.OFC_CD
						customMnrOrdHdrVOs[i][j].setMnrAgmtAmt(customMnrOrdTmpDtlVOs[i][j].getInvAmt());		// DETAIL.COST
						customMnrOrdHdrVOs[i][j].setMnrWrkAmt(customMnrOrdTmpDtlVOs[i][j].getInvAmt());		// DETAIL.COST
						customMnrOrdHdrVOs[i][j].setInvAmt(customMnrOrdTmpDtlVOs[i][j].getInvAmt());			// DETAIL.COST
						customMnrOrdHdrVOs[i][j].setOrdIssOfcCd(customMnrOrdTmpHdrVOs[i].getCostOfcCd()); 	// HEADER.OFC_CD
						customMnrOrdHdrVOs[i][j].setMnrOrdSndDt(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt()); 	// DETAIL.EVENT_DT
						customMnrOrdHdrVOs[i][j].setMnrInpDt(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());  	// DETAIL.EVENT_DT
						if("MRRUSP".equals(customMnrOrdHdrVOs[i][j].getCostCd())){
							customMnrOrdHdrVOs[i][j].setSprPrtSplDt(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());
						}else{
							customMnrOrdHdrVOs[i][j].setSprPrtSplDt("");
						}
						
						String agmtNo = dbDao.searchAgreementExistData(customMnrOrdTmpDtlVOs[i][j]);
						if(!"".equals(agmtNo)){
							customMnrOrdHdrVOs[i][j].setAgmtOfcCtyCd(agmtNo.substring(0, 3));
							customMnrOrdHdrVOs[i][j].setAgmtSeq(agmtNo.substring(3));
						}
						
						// DTL MODIFY
						customMnrOrdTmpDtlVOs[i][j].setRprRsltDt(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());
						customMnrOrdTmpDtlVOs[i][j].setMnrOrdOfcCtyCd(customMnrOrdHdrVOs[i][j].getMnrOrdOfcCtyCd());
						customMnrOrdTmpDtlVOs[i][j].setMnrRcvOrdInvTmpSeq(customMnrOrdTmpDtlVOs[i][j].getMnrRcvOrdInvTmpSeq());
						customMnrOrdTmpDtlVOs[i][j].setMnrRcvOrdInvTmpDtlSeq(customMnrOrdTmpDtlVOs[i][j].getMnrRcvOrdInvTmpDtlSeq());
						if(account == null || "".equals(account.getUsr_id())){
							customMnrOrdHdrVOs[i][j].setCreUsrId("NEWPORT");
							customMnrOrdHdrVOs[i][j].setUpdUsrId("NEWPORT");
							customMnrOrdDtlVOs[i][j].setCreUsrId("NEWPORT");
							customMnrOrdDtlVOs[i][j].setUpdUsrId("NEWPORT");
						}else{
							customMnrOrdHdrVOs[i][j].setCreUsrId(account.getUsr_id());
							customMnrOrdHdrVOs[i][j].setUpdUsrId(account.getUsr_id());
							customMnrOrdDtlVOs[i][j].setCreUsrId(account.getUsr_id());
							customMnrOrdDtlVOs[i][j].setUpdUsrId(account.getUsr_id());
							customMnrOrdTmpDtlVOs[i][j].setUpdUsrId(account.getUsr_id()) ;
						}
						
						customMnrOrdTmpDtlVOs[i][j].setMnrOrdSeq(sMnrOrdSeq);
						
						
						
						// REAL DETAIL DATA=====================
						customMnrOrdDtlVOs[i][j].setMnrOrdOfcCtyCd(customMnrOrdHdrVOs[i][j].getMnrOrdOfcCtyCd());
						customMnrOrdDtlVOs[i][j].setMnrOrdSeq(sMnrOrdSeq);

						customMnrOrdDtlVOs[i][j].setOrdDtlSeq(customMnrOrdTmpDtlVOs[i][j].getOrdDtlSeq());
						customMnrOrdTmpDtlVOs[i][j].setOrdDtlSeq(customMnrOrdTmpDtlVOs[i][j].getOrdDtlSeq());
						customMnrOrdTmpDtlVOs[i][j].setInvAmt(customMnrOrdTmpDtlVOs[i][j].getInvAmt());
						customMnrOrdDtlVOs[i][j].setCostCd(customMnrOrdTmpDtlVOs[i][j].getCostCd());			// DETAIL.TARIFF_CD (Need to convert code eg. "MRDRRC"
						customMnrOrdDtlVOs[i][j].setAcctCd("");

						customMnrOrdDtlVOs[i][j].setCostDtlCd(customMnrOrdTmpDtlVOs[i][j].getCostDtlCd());
						customMnrOrdDtlVOs[i][j].setRprOffhFlg("N");
						customMnrOrdDtlVOs[i][j].setMnrRtTpCd(customMnrOrdTmpDtlVOs[i][j].getCostDtlCd());
						
						customMnrOrdDtlVOs[i][j].setEqNo(customMnrOrdTmpDtlVOs[i][j].getEqNo());
						customMnrOrdDtlVOs[i][j].setEqTpszCd(customMnrOrdTmpDtlVOs[i][j].getEqTpszCd());
						customMnrOrdDtlVOs[i][j].setEqKndCd(customMnrOrdTmpDtlVOs[i][j].getEqKndCd());
						customMnrOrdDtlVOs[i][j].setRqstRefNo(customMnrOrdTmpDtlVOs[i][j].getRqstRefNo());
						customMnrOrdDtlVOs[i][j].setYdCd(customMnrOrdTmpDtlVOs[i][j].getYdCd());
						customMnrOrdDtlVOs[i][j].setRprRsltDt(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());
						customMnrOrdDtlVOs[i][j].setRprQty(customMnrOrdTmpDtlVOs[i][j].getRprQty());


						customMnrOrdDtlVOs[i][j].setSprPrtUcAmt("0");
						customMnrOrdDtlVOs[i][j].setBzcAmt("0");
						customMnrOrdDtlVOs[i][j].setCostAmt(customMnrOrdTmpDtlVOs[i][j].getInvAmt());
						customMnrOrdDtlVOs[i][j].setN3ptyFlg("N");
						customMnrOrdDtlVOs[i][j].setInvAmt(customMnrOrdTmpDtlVOs[i][j].getInvAmt());
						customMnrOrdDtlVOs[i][j].setInvNo(customMnrOrdTmpHdrVOs[i].getInvNo());
						customMnrOrdDtlVOs[i][j].setPayInvSeq(""); //MNR_PAY_INV_WRK.PAY_INV_SEQ
						
						customMnrOrdDtlVOs[i][j].setMnrInpTpCd("N"); //NEWPORT INPUT
						customMnrOrdDtlVOs[i][j].setMnrVrfyTpCd("SS");
						
						BkgTrdCodeVO bkgTrdCodeVO = new BkgTrdCodeVO();
						bkgTrdCodeVO.setEqType(customMnrOrdDtlVOs[i][j].getEqKndCd());
						bkgTrdCodeVO.setCostCd(customMnrOrdDtlVOs[i][j].getCostCd());
						bkgTrdCodeVO.setEqNo(customMnrOrdDtlVOs[i][j].getEqNo());
						bkgTrdCodeVO.setRprRsltDt(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());
						
						List<BkgTrdCodeVO> bkgTrdCd = command1.searchBkgTrdCdBasic(bkgTrdCodeVO);
						if(bkgTrdCd != null && bkgTrdCd.size() > 0){
							customMnrOrdDtlVOs[i][j].setBkgNo(bkgTrdCd.get(0).getBkgNo());
							customMnrOrdDtlVOs[i][j].setTrdCd(bkgTrdCd.get(0).getTrdCd());
							
							String revVVdCd = dbDao.searchRevenueVvdData(customMnrOrdDtlVOs[i][j].getBkgNo());
							
//							if(!"CFDR".equals(revVVdCd.substring(0, 4))){
								customMnrOrdDtlVOs[i][j].setVslCd(revVVdCd.substring(0, 4));
								customMnrOrdDtlVOs[i][j].setSkdVoyNo(revVVdCd.substring(4, 8));
								customMnrOrdDtlVOs[i][j].setSkdDirCd(revVVdCd.substring(8, 9));
								customMnrOrdDtlVOs[i][j].setRevDirCd(revVVdCd.substring(9, 10));
								customMnrOrdDtlVOs[i][j].setSlanCd(revVVdCd.substring(10));
//							}
						}

					}
				}
				
				
			}
			
			interfaceGRPVO.setListMnrOrdHdrVOs(insertMnrOrdHdrVOs);
			interfaceGRPVO.setListMnrOrdDtlVOs(insertMnrOrdDtlVOs);
			interfaceGRPVO.setListMnrOrdTmpDtlVOs(insertMnrOrdTmpDtlVOs);
//			interfaceGRPVO.setArrayCustomMnrOrdTmpHdrVOs(customMnrOrdTmpHdrVOs);
//			interfaceGRPVO.setArrayCustomMnrOrdTmpDtlVOs(customMnrOrdTmpDtlVOs);
//			
//			manageWOInvoiceDataBasic(interfaceGRPVO, account);
			
			
			//account reset	  	   
//			SignOnUserAccount account = null;

			if(customMnrOrdTmpHdrVOs != null){ 
				for(int i = 0 ; i < customMnrOrdTmpHdrVOs.length ; i++){
					
					if("SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
						insertMnrOrdTmpHdrVOs.add(customMnrOrdTmpHdrVOs[i]);
					
						for(int j = 0 ; j < customMnrOrdTmpDtlVOs[i].length ; j++){
							insertMnrOrdHdrVOs.add(customMnrOrdHdrVOs[i][j]);
							insertMnrOrdDtlVOs.add(customMnrOrdDtlVOs[i][j]);
							insertMnrOrdTmpDtlVOs.add(customMnrOrdTmpDtlVOs[i][j]);
						}
					}
				}
				
				if(insertMnrOrdHdrVOs != null && insertMnrOrdHdrVOs.size() > 0){
					dbDao.addNewPortWOCreationHeaderData(insertMnrOrdHdrVOs);  		// MNR_ORD_HDR
					dbDao.addNewPortWOCreationDetailData(insertMnrOrdDtlVOs);  		// MNR_ORD_DTL
					dbDao.modifyNewPortWOCreationDetailData(insertMnrOrdTmpDtlVOs); // MNR_ORD_TMP_DTL UPDATE
					
					payableInvoiceGRPVO = new PayableInvoiceGRPVO();
					CustomMnrPayInvWrkVO customMnrPayInvWrkVO = null;
	
					for(int i = 0 ; i < customMnrOrdTmpHdrVOs.length ; i++){
						if("SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
							sVndrSeq = dbDao.searchMnrOrdTmpVndrSeqData(customMnrOrdTmpHdrVOs[i].getVndrSeq());
							bSusses = true;
							customMnrPayInvWrkVO = new CustomMnrPayInvWrkVO();
							customMnrPayInvWrkVO.setInvNo(customMnrOrdTmpHdrVOs[i].getInvNo());
							customMnrPayInvWrkVO.setMnrGrpTpCd("RPR");
							customMnrPayInvWrkVO.setMnrInvStsCd("HC");
							customMnrPayInvWrkVO.setGenPayTermCd(dbDao.searchMnrOrdTmpGenPayTermCdData(sVndrSeq));
							customMnrPayInvWrkVO.setOrdVndrSeq(sVndrSeq);
							customMnrPayInvWrkVO.setMnrPrnrSeq(sVndrSeq);
							customMnrPayInvWrkVO.setCurrCd(customMnrOrdTmpHdrVOs[i].getCurrCd());
							customMnrPayInvWrkVO.setBzcAmt(String.format("%.2f", Double.parseDouble(customMnrOrdTmpHdrVOs[i].getInvAmt())-Double.parseDouble(customMnrOrdTmpHdrVOs[i].getVatAmt())+Double.parseDouble(customMnrOrdTmpHdrVOs[i].getInvWhldTaxAmt())));
							customMnrPayInvWrkVO.setVatAmt(customMnrOrdTmpHdrVOs[i].getVatAmt());
							customMnrPayInvWrkVO.setWhldTaxAmt(customMnrOrdTmpHdrVOs[i].getInvWhldTaxAmt());
							customMnrPayInvWrkVO.setTtlAmt(customMnrOrdTmpHdrVOs[i].getInvAmt());
							customMnrPayInvWrkVO.setMnrInvRjctFlg("N");
							customMnrPayInvWrkVO.setIssDt(customMnrOrdTmpHdrVOs[i].getInvCfmDt());
							customMnrPayInvWrkVO.setIssOfcCd(customMnrOrdTmpHdrVOs[i].getCostOfcCd());
							customMnrPayInvWrkVO.setRcvDt(customMnrOrdTmpHdrVOs[i].getRcvDt());
							customMnrPayInvWrkVO.setEffDt(customMnrOrdTmpHdrVOs[i].getRcvDt());
						
							customMnrPayInvWrkVO.setHldFlg("N");
							customMnrPayInvWrkVO.setPayInvSeq("");
							customMnrPayInvWrkVO.setMnrInpTpCd("N");
							
							if(account == null || "".equals(account.getUsr_id())){
								account = new SignOnUserAccount("NEWPORT",null,null,null,null,null,null,null, "NEWPORT", customMnrOrdTmpHdrVOs[i].getCreDt() , "NEWPORT", customMnrOrdTmpHdrVOs[i].getCreDt(), customMnrOrdTmpHdrVOs[i].getCostOfcCd(), null, null, null, null, null, null, null, null, null);
								account.setAccess_system("SPP");
							}else{
								account.setAccess_system("SPP");
							}
							
							payableInvoiceGRPVO.setCustomMnrPayInvWrkVO(customMnrPayInvWrkVO);
						
							CustomPayableInvoiceDetailINVO[] arrayCustomPayableInvoiceDetailINVOs = new CustomPayableInvoiceDetailINVO[customMnrOrdTmpDtlVOs[i].length];
							CustomPayableInvoiceDetailINVO customPayableInvoiceDetailINVO = null;
							List<CustomPayableInvoiceDetailINVO> sucessList = new ArrayList<CustomPayableInvoiceDetailINVO>();
							
								for(int j = 0 ; j < customMnrOrdTmpDtlVOs[i].length ; j++){
									String costType = dbDao.searchCostTypeData(customMnrOrdTmpDtlVOs[i][j]);
									arrayCustomPayableInvoiceDetailINVOs[j] = new CustomPayableInvoiceDetailINVO();
									customPayableInvoiceDetailINVO = new CustomPayableInvoiceDetailINVO();
									customPayableInvoiceDetailINVO.setMnrOrdOfcCtyCd(customMnrOrdTmpDtlVOs[i][j].getMnrOrdOfcCtyCd());
									customPayableInvoiceDetailINVO.setMnrOrdSeq(customMnrOrdTmpDtlVOs[i][j].getMnrOrdSeq());
									customPayableInvoiceDetailINVO.setOrdDtlSeq(customMnrOrdTmpDtlVOs[i][j].getOrdDtlSeq());
									customPayableInvoiceDetailINVO.setMnrWoTpCd(costType);
									customPayableInvoiceDetailINVO.setEqNo(customMnrOrdTmpDtlVOs[i][j].getEqNo());
									customPayableInvoiceDetailINVO.setEqKndCd(customMnrOrdTmpDtlVOs[i][j].getEqKndCd());
									customPayableInvoiceDetailINVO.setEqTpszCd(customMnrOrdTmpDtlVOs[i][j].getEqTpszCd());
									customPayableInvoiceDetailINVO.setRprRsltDt(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());
									customPayableInvoiceDetailINVO.setYdCd(customMnrOrdTmpDtlVOs[i][j].getYdCd());
									arrayCustomPayableInvoiceDetailINVOs[j] = customPayableInvoiceDetailINVO;
									sucessList.add(arrayCustomPayableInvoiceDetailINVOs[j]);
								} 			
							
								
								if(sucessList.size() > 0){
									
									payableInvoiceGRPVO.setArrayCustomPayableInvoiceDetailINVOs((CustomPayableInvoiceDetailINVO[]) sucessList.toArray(new CustomPayableInvoiceDetailINVO[sucessList.size()]));
								
									//MNR_PAY_INV_WRK add, modify
									payableInvoiceGRPVO2 = command.manageRepairPayableInvoiceBasic(payableInvoiceGRPVO, account);
									
								}else{
									bSusses = false;
								}
						}else{
							bSusses = false;
						}
						
						if(bSusses){
							//MNR_ORD_DTL invoice data modify
							CustomMnrOrdDtlVO[] arrCustomMnrOrdDtlVO = new CustomMnrOrdDtlVO[customMnrOrdTmpDtlVOs[i].length];
		
							CustomMnrOrdDtlVO tempCustomMnrOrdDtlVO = null;
							
							List<CustomMnrOrdDtlVO> sucessList2 = new ArrayList<CustomMnrOrdDtlVO>();
							
							for(int j = 0 ; j < customMnrOrdTmpDtlVOs[i].length ; j++){
								
								if("SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
									tempCustomMnrOrdDtlVO = new CustomMnrOrdDtlVO();
									arrCustomMnrOrdDtlVO[j]  = new CustomMnrOrdDtlVO();
		
									tempCustomMnrOrdDtlVO.setPayInvSeq(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq());
									tempCustomMnrOrdDtlVO.setInvNo(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getInvNo());
									tempCustomMnrOrdDtlVO.setInvAmt(customMnrOrdTmpDtlVOs[i][j].getInvAmt());
									
									tempCustomMnrOrdDtlVO.setRprRsltDt(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());
									tempCustomMnrOrdDtlVO.setMnrOrdOfcCtyCd(customMnrOrdTmpDtlVOs[i][j].getMnrOrdOfcCtyCd());
									tempCustomMnrOrdDtlVO.setMnrOrdSeq(customMnrOrdTmpDtlVOs[i][j].getMnrOrdSeq());
									tempCustomMnrOrdDtlVO.setOrdDtlSeq(customMnrOrdTmpDtlVOs[i][j].getOrdDtlSeq());
									tempCustomMnrOrdDtlVO.setSlsTaxAmt(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getSlsTaxAmt());  
									tempCustomMnrOrdDtlVO.setCreUsrId(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getCreUsrId());
									
						    		arrCustomMnrOrdDtlVO[j] = tempCustomMnrOrdDtlVO;    
						    		sucessList2.add(arrCustomMnrOrdDtlVO[j]);
									
								}
							} 		     
							generalWOGRPVO.setArrCustomMnrOrdDtlVOS((CustomMnrOrdDtlVO[]) sucessList2.toArray(new CustomMnrOrdDtlVO[sucessList2.size()]));
							//setting "Invoice Status" to deliver
							generalWOGRPVO.setMnrInvStsCd(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInvStsCd());
								
							command4.modifyWEBInvoiceLinkBasic(generalWOGRPVO,account);
								
							// PAY_INV_SEQ UPDATE=========================================================================
							List<CustomMnrOrdDtlVO> insertVoList = new ArrayList<CustomMnrOrdDtlVO>();
								
							if(generalWOGRPVO.getArrCustomMnrOrdDtlVOS() != null){
								CustomMnrOrdDtlVO[] arrCustomMnrOrdDtlVOs = generalWOGRPVO.getArrCustomMnrOrdDtlVOS();
		
								for ( int k = 0; k < arrCustomMnrOrdDtlVOs.length; k++ ) {
									arrCustomMnrOrdDtlVOs[k].setCreUsrId(account.getUsr_id());
									insertVoList.add(arrCustomMnrOrdDtlVOs[k]);
								}
								dbDao2.modifyWEBInvoiceLinkData(insertVoList);
							}
							//=============================================================================================
								
							String req_no = ""; 
							//handling CSR
							req_no = createCSRIFBasic(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getMnrGrpTpCd(), payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq(), account);
								
							//modify MNR_ORD_DTL req_no
							command.modifyTotalLossPayableInvoiceBasic(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq(),req_no, account);
							
							CustomPayableInvoiceDetailINVO[] arrCustomPayableInvoiceDetailINVO = payableInvoiceGRPVO.getArrayCustomPayableInvoiceDetailINVOs();
							
							for ( int k = 0; k< arrCustomPayableInvoiceDetailINVO.length; k++ ) {  
								if(arrCustomPayableInvoiceDetailINVO[k].getMnrWoTpCd().equals("EST")){
									List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
									List<CustomMnrEqStsVO> listCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
									List<CustomMnrFlgHisVO> listCustomMnrFlgHisVOS = new ArrayList<CustomMnrFlgHisVO>();
									
									boolean isDupEqNo = false;	
									for (int j = 0; j < listCustomMnrEqStsVOS.size(); j++) {
										if(listCustomMnrEqStsVOS.get(j).getEqNo().equalsIgnoreCase(arrCustomPayableInvoiceDetailINVO[k].getEqNo())){
											isDupEqNo = true;
										}
									}
									
									if(!isDupEqNo){	
										CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
										customMnrEqStsVO.setEqNo(arrCustomPayableInvoiceDetailINVO[k].getEqNo());
										customMnrEqStsVO.setMnrDmgFlg("0");
										customMnrEqStsVO.setMnrStsRmk("By Newport EDI Invoice");
										customMnrEqStsVO.setEqTpszCd(arrCustomPayableInvoiceDetailINVO[k].getEqTpszCd());
										customMnrEqStsVO.setEqKndCd(arrCustomPayableInvoiceDetailINVO[k].getEqKndCd());
										customMnrEqStsVO.setMnrDmgFlgYdCd(arrCustomPayableInvoiceDetailINVO[k].getYdCd());
										String eventTime = dbDao.searchMvmtTimeData(arrCustomPayableInvoiceDetailINVO[k].getEqNo(), arrCustomPayableInvoiceDetailINVO[k].getRprRsltDt(), arrCustomPayableInvoiceDetailINVO[k].getYdCd(), "MT");
										if("".equals(eventTime)){
											eventTime = dbDao.searchMvmtTimeData(arrCustomPayableInvoiceDetailINVO[k].getEqNo(), arrCustomPayableInvoiceDetailINVO[k].getRprRsltDt(), arrCustomPayableInvoiceDetailINVO[k].getYdCd(), "");
											if("".equals(eventTime)){
												eventTime = "2359";
											}
										}
										
										customMnrEqStsVO.setMnrDmgFlgDt(arrCustomPayableInvoiceDetailINVO[k].getRprRsltDt()+eventTime);
										listCustomMnrEqStsVOS.add(customMnrEqStsVO);
										
										IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
										iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
										iFMnrFlagVO.setFlagUserId(account.getUsr_id());
										iFMnrFlagVO.setFlagType("DMG");
										iFMnrFlagVO.setRetireFlag("N");
										iFMnrFlagVO.setEqKindCd(arrCustomPayableInvoiceDetailINVO[k].getEqKndCd());
										iFMnrFlagVO.setEqNo(arrCustomPayableInvoiceDetailINVO[k].getEqNo());
										iFMnrFlagVO.setStsFlag("N");
										iFMnrFlagVO.setFlagDt(arrCustomPayableInvoiceDetailINVO[k].getRprRsltDt()+eventTime);
										iFMnrFlagVO.setFlagYdCd(arrCustomPayableInvoiceDetailINVO[k].getYdCd());
										iFMnrFlagVOS.add(iFMnrFlagVO);

										CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
										customMnrFlgHisVO.setMnrFlgTpCd("DMG"); 
										customMnrFlgHisVO.setMnrStsFlg("0");
										customMnrFlgHisVO.setMnrFlgInpTpCd("I");   
										customMnrFlgHisVO.setEqNo(arrCustomPayableInvoiceDetailINVO[k].getEqNo());
										customMnrFlgHisVO.setEqTpszCd(arrCustomPayableInvoiceDetailINVO[k].getEqTpszCd());
										customMnrFlgHisVO.setMnrFlgYdCd(arrCustomPayableInvoiceDetailINVO[k].getYdCd());
										customMnrFlgHisVO.setEqKndCd(arrCustomPayableInvoiceDetailINVO[k].getEqKndCd());
										listCustomMnrFlgHisVOS.add(customMnrFlgHisVO);
									}
									
									if(iFMnrFlagVOS.size() > 0){	
										interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);	
										eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("DMG");
										
										CustomMnrEqStsVO[] customMnrEqStsVOS = new CustomMnrEqStsVO[listCustomMnrEqStsVOS.size()];		
										CustomMnrFlgHisVO[] customMnrFlgHisVOS = new CustomMnrFlgHisVO[listCustomMnrFlgHisVOS.size()];	
										
										for (int j = 0; j < listCustomMnrEqStsVOS.size(); j++) {
											customMnrEqStsVOS[j] = listCustomMnrEqStsVOS.get(j);	
										}
										for (int j = 0; j < listCustomMnrFlgHisVOS.size(); j++) {
											customMnrFlgHisVOS[j] = listCustomMnrFlgHisVOS.get(j);	
										}
										
										eQFlagListGRPVO.setArrCustomMnrEqStsVOS(customMnrEqStsVOS);
										eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(customMnrFlgHisVOS);
										
										if("U".equals(arrCustomPayableInvoiceDetailINVO[k].getEqKndCd())){
											command3.manageEQFlagListBasic(eQFlagListGRPVO,account);
											this.manageIFFlagBasic(interfaceGRPVO,account);
											String [] rtn = this.manageCtmIfFlagBasic(interfaceGRPVO, account);
											if(!"".equals(rtn[0])){
												customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(dbDao.searchVerifyResultData("IW"));
												customMnrOrdTmpDtlVOs[i][k].setVrfyRsltDesc(dbDao.searchVerifyResultData("IW"));
												arrCustomPayableInvoiceDetailINVO[k].setUpdUsrId(account.getUsr_id());
												dbDao.modifyMnrWOVrfyCdData(arrCustomPayableInvoiceDetailINVO[k]);
											}
										}else{
											command3.manageEQFlagListBasic(eQFlagListGRPVO,account);
											this.manageIFFlagBasic(interfaceGRPVO,account);
										}
									}
								}
							}
						}
						
					}
				}

			}
			if(account != null){
				if(!"NEWPORT".equals(account.getUsr_id())){
					account.setAccess_system("ALP");
				}
			}
		} catch (StringIndexOutOfBoundsException de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling NewPort MQ] manageNewPortWOInvoiceDataBasic"}).getMessage(),de);
		} catch (DAOException de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling NewPort MQ] manageNewPortWOInvoiceDataBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling NewPort MQ] manageNewPortWOInvoiceDataBasic"}).getMessage(),de);
		}
		return interfaceGRPVO;
	}
	
	/**
	 * handling Receive MQ <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO manageMQEstimateBasic(InterfaceGRPVO interfaceGRPVO) throws EventException {
		String eaiRecMsg = interfaceGRPVO.getEaiRecMsg();
		try {
			int lineDelimeterLen = 2;
			List<String> dtlVec = new ArrayList<String>();

			//************ setting header and detail. ********************//
			int headerEnd = eaiRecMsg.indexOf("{DETAIL",0);
			String header = eaiRecMsg.substring(0, headerEnd - lineDelimeterLen);

			int findIndex = headerEnd;
			int detailFirst = 0;

			while((detailFirst = eaiRecMsg.indexOf("LINE_NO:",findIndex)) != -1){
				findIndex = eaiRecMsg.indexOf("}DETAIL",detailFirst);
				dtlVec.add(eaiRecMsg.substring(detailFirst,findIndex - lineDelimeterLen));
			}
			//************ setting header and detail. END ********************//

			String[] headerEntity = header.split("\n");

			CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = new CustomMnrRprRqstTmpHdrVO();

			for(int i = 0;i < headerEntity.length ;i++){

				String tempText = headerEntity[i].replaceAll("\r","");
				tempText = tempText.replaceAll("\n","");
				String[] tempEntity = tempText.split(":");

				String entityValue = "";
				if(tempEntity.length == 2){
					entityValue = tempEntity[1].trim();
				}

				//creating VO of heater data 
				if(tempEntity[0].startsWith("EST_NO")){
					customMnrRprRqstTmpHdrVO.setRqstRefNo(entityValue);
				} else if(tempEntity[0].startsWith("EQ_TYPE")){
					customMnrRprRqstTmpHdrVO.setEqKndCd(entityValue);
				} else if(tempEntity[0].startsWith("EQ_PREFIX")){
					customMnrRprRqstTmpHdrVO.setEqPrefix(entityValue);
				} else if(tempEntity[0].startsWith("EQ_NO")){
					customMnrRprRqstTmpHdrVO.setRqstEqNo(entityValue);
				} else if(tempEntity[0].startsWith("AUTH_SENDER")){
					// setting 'NOTSEND' in case of not existing AUTH_SENDER
					if(entityValue == null || entityValue.equals("")){
						entityValue = "NOTSEND";
					}
					customMnrRprRqstTmpHdrVO.setCreUsrId(entityValue);
					customMnrRprRqstTmpHdrVO.setUpdUsrId(entityValue);
				} else if(tempEntity[0].startsWith("ACT_TRANS_DT")){
					customMnrRprRqstTmpHdrVO.setCreDt(entityValue);
					customMnrRprRqstTmpHdrVO.setUpdDt(entityValue);
					customMnrRprRqstTmpHdrVO.setEqDmgDt(entityValue);
				} else if(tempEntity[0].startsWith("EST_DT")){
					customMnrRprRqstTmpHdrVO.setRqstDt(entityValue);
				} else if(tempEntity[0].startsWith("EQ_TPSZ")){
					customMnrRprRqstTmpHdrVO.setEqTpszCd(entityValue);
				} else if(tempEntity[0].startsWith("CUR_CD")){
					customMnrRprRqstTmpHdrVO.setCurrCd(entityValue);
				} else if(tempEntity[0].startsWith("LAB_TOT")){
					customMnrRprRqstTmpHdrVO.setMnrLbrAmt(entityValue);
				} else if(tempEntity[0].startsWith("MAT_TOT")){
					customMnrRprRqstTmpHdrVO.setMnrMtrlAmt(entityValue);
				} else if(tempEntity[0].startsWith("TOT_INV_AMT")){
					customMnrRprRqstTmpHdrVO.setInvAmt(entityValue);
				} else if(tempEntity[0].startsWith("EDI_ID")){
					customMnrRprRqstTmpHdrVO.setEdiId(entityValue);
				} else if(tempEntity[0].startsWith("REMARK")){
					customMnrRprRqstTmpHdrVO.setMnrRprRmk(entityValue);
				} else if(tempEntity[0].startsWith("EST_GRND_TOT")){
					customMnrRprRqstTmpHdrVO.setMnrTtlAmt(entityValue);
				} else if(tempEntity[0].startsWith("PREV_ONHIRE_IND")){
					customMnrRprRqstTmpHdrVO.setRprOffhFlg(entityValue);
				}
			}

			//setting EQ_NO to PRFIX + NO
			customMnrRprRqstTmpHdrVO.setRqstEqNo(customMnrRprRqstTmpHdrVO.getEqPrefix() + customMnrRprRqstTmpHdrVO.getRqstEqNo());
			customMnrRprRqstTmpHdrVO.setRprRqstLstVerFlg("Y");

			//setting EQ_TYPE
			String eqType =  dbDao.searchEqTypeByEqNoData(customMnrRprRqstTmpHdrVO);
			customMnrRprRqstTmpHdrVO.setEqKndCd(eqType);

			//retrieving SEQ,VERSION NO
			CustomMnrRprRqstTmpHdrVO tempVO = dbDao.searchTempEstimateSeqData(customMnrRprRqstTmpHdrVO);

			if(tempVO != null){
				//version up in case of existing estimate number
				int asIsVerno = Integer.parseInt(tempVO.getRprRqstTmpVerNo());
				customMnrRprRqstTmpHdrVO.setRprRqstTmpSeq(tempVO.getRprRqstTmpSeq());
				customMnrRprRqstTmpHdrVO.setRprRqstTmpVerNo(asIsVerno + 1 + "");
			} else {
				//creating in case of not existing
				tempVO = dbDao.searchEstimateTempSeqNewEqData(customMnrRprRqstTmpHdrVO);
				customMnrRprRqstTmpHdrVO.setRprRqstTmpSeq(tempVO.getRprRqstTmpSeq());
				customMnrRprRqstTmpHdrVO.setRprRqstTmpVerNo(tempVO.getRprRqstTmpVerNo());
			}

			if(customMnrRprRqstTmpHdrVO.getRqstRefNo().equals("")){
				//Rqst_Ref_No ERROR
				interfaceGRPVO.setRqstRefNoChk("RE");
			} else {
				interfaceGRPVO.setRqstRefNoChk("SS");
			}

			//*************** checking date format *******************//

			String tempToday  = (new SimpleDateFormat("yyyyMMdd")).format(new Date());

			//1. ACT_TRANS_DT
			//DE -> SS
			if(!customMnrRprRqstTmpHdrVO.getCreDt().equals("")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
				ParsePosition pos = new ParsePosition(0);
				Date date = sdf.parse(customMnrRprRqstTmpHdrVO.getCreDt(),pos);
				if(date == null){
					customMnrRprRqstTmpHdrVO.setCreDt(tempToday);
					customMnrRprRqstTmpHdrVO.setUpdDt(tempToday);
					customMnrRprRqstTmpHdrVO.setEqDmgDt(tempToday);
					interfaceGRPVO.setDateFormChk("SS");
				} else {
					interfaceGRPVO.setDateFormChk("SS");
				}
			} else {
				customMnrRprRqstTmpHdrVO.setCreDt(tempToday);
				customMnrRprRqstTmpHdrVO.setUpdDt(tempToday);
				customMnrRprRqstTmpHdrVO.setEqDmgDt(tempToday);
				interfaceGRPVO.setDateFormChk("SS");
			}

			//2. EST_DT
			if(interfaceGRPVO.getDateFormChk().equals("SS")){
				if(!customMnrRprRqstTmpHdrVO.getRqstDt().equals("") ){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
					ParsePosition pos = new ParsePosition(0);
					Date date = sdf.parse(customMnrRprRqstTmpHdrVO.getRqstDt(),pos);
					if(date == null){
						customMnrRprRqstTmpHdrVO.setRqstDt(tempToday);
						interfaceGRPVO.setDateFormChk("SS");
					} else {
						interfaceGRPVO.setDateFormChk("SS");
					}
				} else {
					customMnrRprRqstTmpHdrVO.setRqstDt(tempToday);
					interfaceGRPVO.setDateFormChk("SS");
				}
			}
			//*************** checking date format *******************//

			//retrieving TPSZ. 
			String tpszCd = dbDao.searchTempEstimateTpszData(customMnrRprRqstTmpHdrVO);
			customMnrRprRqstTmpHdrVO.setEqTpszCd(tpszCd);

			//setting
			customMnrRprRqstTmpHdrVO.setRprStsCd("HR");
			customMnrRprRqstTmpHdrVO.setRprDtlStsCd("1");
			customMnrRprRqstTmpHdrVO.setMnrInpTpCd("E");
			customMnrRprRqstTmpHdrVO.setRqstUsrId(customMnrRprRqstTmpHdrVO.getCreUsrId());
			customMnrRprRqstTmpHdrVO.setRprWrkTpCd("W");

			//NOT NULL 
			customMnrRprRqstTmpHdrVO.setN3ptyFlg("N");
			customMnrRprRqstTmpHdrVO.setDispFlg("N");

			//retrieving VNDR_SEQ AGMT
			CustomMnrRprRqstTmpHdrVO tempVO2 = dbDao.searchTempEstimateAGMTData(customMnrRprRqstTmpHdrVO);

			if(tempVO2 != null){
				customMnrRprRqstTmpHdrVO.setVndrSeq(tempVO2.getVndrSeq());
				customMnrRprRqstTmpHdrVO.setAgmtOfcCtyCd(tempVO2.getAgmtOfcCtyCd());
				customMnrRprRqstTmpHdrVO.setAgmtSeq(tempVO2.getAgmtSeq());
				customMnrRprRqstTmpHdrVO.setAgmtVerNo(tempVO2.getAgmtVerNo());
				// setting Agreement Curr_cd in case of not existing CURR_CD
				if(customMnrRprRqstTmpHdrVO.getCurrCd().equals("") || customMnrRprRqstTmpHdrVO.getCurrCd() == null){
					customMnrRprRqstTmpHdrVO.setCurrCd(tempVO2.getCurrCd());
				}	
				
				interfaceGRPVO.setVenderChk("SS");
			} else {   
				customMnrRprRqstTmpHdrVO.setVndrSeq("");
				customMnrRprRqstTmpHdrVO.setAgmtOfcCtyCd("");
				customMnrRprRqstTmpHdrVO.setAgmtSeq("");
				customMnrRprRqstTmpHdrVO.setAgmtVerNo("");
				interfaceGRPVO.setVenderChk("VE");
			}

			//setting flag 'N'
			dbDao.modifyESTTmpHDRLastVersionUnFlagData(customMnrRprRqstTmpHdrVO);
			dbDao.modifyESTTmpDTLLastVersionUnFlagData(customMnrRprRqstTmpHdrVO);
			//adding header data
			dbDao.addTempEstimateHDRData(customMnrRprRqstTmpHdrVO);

			interfaceGRPVO.setCustomMnrRprRqstTmpHdrVO(customMnrRprRqstTmpHdrVO);


			//checking VALIDATION EQ_NO UE/SS
			String eqChk = dbDao.searchEQFlagFileListByEQData(customMnrRprRqstTmpHdrVO);
			interfaceGRPVO.setEqChk(eqChk);

			//handling DTL data
			for(int i = 0;i < dtlVec.size();i++){
				String[] dtlEntity = dtlVec.get(i).split("\n");

				CustomMnrRprRqstTmpDtlVO customMnrRprRqstTmpDtlVO = new CustomMnrRprRqstTmpDtlVO();
				String dim_len = "";
				String dim_wid = "";
				String qty = "";

				for(int j = 0;j < dtlEntity.length ;j++){
					String tempText = dtlEntity[j].replaceAll("\r","");
					tempText = tempText.replaceAll("\n","");
					String[] tempEntity = tempText.split(":");

					String entityValue = "";
					if(tempEntity.length == 2){
						entityValue = tempEntity[1].trim();
					}

					// creating detail data VO
					if(tempEntity[0].startsWith("DAM_LOC_CD")){
						customMnrRprRqstTmpDtlVO.setEqLocCd(entityValue);
					} else if(tempEntity[0].startsWith("COMPNT_CD")){
						customMnrRprRqstTmpDtlVO.setEqCmpoCd(entityValue);
					} else if(tempEntity[0].startsWith("DAM_TP_CD")){
						customMnrRprRqstTmpDtlVO.setEqDmgCd(entityValue);
					} else if(tempEntity[0].startsWith("REPR_METH_CD")){
						customMnrRprRqstTmpDtlVO.setEqRprCd(entityValue);
					} else if(tempEntity[0].startsWith("DIM_LEN")){
						if(entityValue.equals("")){
							dim_len = "0";
						} else {
							char chars[] = entityValue.toCharArray();
							boolean checkIsNumber = true;
							for(int k = 0; k < chars.length;k ++){
								if((chars[k] < '0' || chars[k] > '9') && chars[k] != '.') {
									checkIsNumber = false;
									break;
								
								} else if(chars[k] == '.') {
									
									if(k == 0){
										checkIsNumber = false;
										break;
									} else {
										checkIsNumber = true;
										entityValue = entityValue.substring(0, k);
										break;
									}
								}
							}

							if(!checkIsNumber){
								dim_len = "0";
							} else {
								dim_len = entityValue;
							}
						}
					} else if(tempEntity[0].startsWith("DIM_WID")){
						if(entityValue.equals("")){
							dim_wid = "0";
						} else {
							char chars[] = entityValue.toCharArray();
							boolean checkIsNumber = true;
							for(int k = 0; k < chars.length;k ++){
								if((chars[k] < '0' || chars[k] > '9') && chars[k] != '.') {
									checkIsNumber = false;
									break;
								
								} else if(chars[k] == '.') {
									
									if(k == 0){
										checkIsNumber = false;
										break;
									} else {
										checkIsNumber = true;
										entityValue = entityValue.substring(0, k);
										break;
									}
								}
							}

							if(!checkIsNumber){
								dim_wid = "0";
							} else {
								dim_wid = entityValue;
							}
						}
					} else if(tempEntity[0].startsWith("QUANTITY")){
						if(entityValue.equals("")){
							qty = "0";
						} else {
							char chars[] = entityValue.toCharArray();
							boolean checkIsNumber = true;
							for(int k = 0; k < chars.length;k ++){
								if((chars[k] < '0' || chars[k] > '9') && chars[k] != '.') {
									checkIsNumber = false;
									break;
								
								} else if(chars[k] == '.') {
									
									if(k == 0){
										checkIsNumber = false;
										break;
									} else {
										checkIsNumber = true;
										entityValue = entityValue.substring(0, k);
										break;
									}
								}
							}

							if(!checkIsNumber){
								qty = "0";
							} else {
								qty = entityValue;
							}
						}
					} else if(tempEntity[0].startsWith("MAN_HOUR")){
						if(entityValue.equals("")){
							customMnrRprRqstTmpDtlVO.setRprLbrHrs("0");
						} else {
							char chars[] = entityValue.toCharArray();
							boolean checkIsNumber = true;
							for(int k = 0; k < chars.length;k ++){
								if((chars[k] < '0' || chars[k] > '9') && chars[k] != '.') {
									checkIsNumber = false;
								}
							}

							if(!checkIsNumber){
								customMnrRprRqstTmpDtlVO.setRprLbrHrs("0");
							} else {
								//showing to 2 decimal places
								String checkVal = entityValue;
								int findIdx = checkVal.indexOf(".");
								if(findIdx != -1){
									String temp = checkVal.substring(findIdx, checkVal.length()).replaceAll("\\.", "");
									int len = temp.length();
									if(len > 2){
										entityValue = checkVal.substring(0, checkVal.length() - (len - 2));
									}
								}
								customMnrRprRqstTmpDtlVO.setRprLbrHrs(entityValue);
							}
						}
					} else if(tempEntity[0].startsWith("LAB_RATE")){
						if(entityValue.equals("")){
							customMnrRprRqstTmpDtlVO.setRprLbrRt("0");
						} else {
							char chars[] = entityValue.toCharArray();
							boolean checkIsNumber = true;
							for(int k = 0; k < chars.length;k ++){
								if((chars[k] < '0' || chars[k] > '9') && chars[k] != '.') {
									checkIsNumber = false;
								}
							}

							if(!checkIsNumber){
								customMnrRprRqstTmpDtlVO.setRprLbrRt("0");
							} else {
								//showing to 2 decimal places
								String checkVal = entityValue;
								int findIdx = checkVal.indexOf(".");
								if(findIdx != -1){
									String temp = checkVal.substring(findIdx, checkVal.length()).replaceAll("\\.", "");
									int len = temp.length();
									if(len > 2){
										entityValue = checkVal.substring(0, checkVal.length() - (len - 2));
									}
								}
								customMnrRprRqstTmpDtlVO.setRprLbrRt(entityValue);
							}
						}
					} else if(tempEntity[0].startsWith("MATRL_COST")){
						if(entityValue.equals("")){
							customMnrRprRqstTmpDtlVO.setMtrlCostAmt("0");
						} else {
							char chars[] = entityValue.toCharArray();
							boolean checkIsNumber = true;
							for(int k = 0; k < chars.length;k ++){
								if((chars[k] < '0' || chars[k] > '9') && chars[k] != '.') {
									checkIsNumber = false;
								}
							}

							if(!checkIsNumber){
								customMnrRprRqstTmpDtlVO.setMtrlCostAmt("0");
							} else {
								//showing to 2 decimal places
								String checkVal = entityValue;
								int findIdx = checkVal.indexOf(".");
								if(findIdx != -1){
									String temp = checkVal.substring(findIdx, checkVal.length()).replaceAll("\\.", "");
									int len = temp.length();
									if(len > 2){
										entityValue = checkVal.substring(0, checkVal.length() - (len - 2));
									}
								}
								customMnrRprRqstTmpDtlVO.setMtrlCostAmt(entityValue);
							}
						}
					}
				}

				//default value
				customMnrRprRqstTmpDtlVO.setRqstEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrRprRqstTmpDtlVO.setRprRqstTmpSeq(customMnrRprRqstTmpHdrVO.getRprRqstTmpSeq());
				customMnrRprRqstTmpDtlVO.setRprRqstTmpVerNo(customMnrRprRqstTmpHdrVO.getRprRqstTmpVerNo());
				customMnrRprRqstTmpDtlVO.setRprRqstTmpDtlSeq((i + 1) + "");
				customMnrRprRqstTmpDtlVO.setEqLocCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqCmpoCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqDmgCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqRprCdChkFlg("N");

				//setting
				customMnrRprRqstTmpDtlVO.setCreUsrId(customMnrRprRqstTmpHdrVO.getCreUsrId());
				customMnrRprRqstTmpDtlVO.setUpdUsrId(customMnrRprRqstTmpHdrVO.getCreUsrId());
				customMnrRprRqstTmpDtlVO.setCreDt(customMnrRprRqstTmpHdrVO.getCreDt());
				customMnrRprRqstTmpDtlVO.setUpdDt(customMnrRprRqstTmpHdrVO.getCreDt());

				customMnrRprRqstTmpDtlVO.setRprRqstLstVerFlg("Y");
				customMnrRprRqstTmpDtlVO.setMnrLrAcctFlg("N");
				customMnrRprRqstTmpDtlVO.setN3ptyFlg("N");
				customMnrRprRqstTmpDtlVO.setTrfDivCd(" ");

				//eqChk -> ""
				customMnrRprRqstTmpDtlVO.setMnrVrfyTpCd("");

				int length = Integer.parseInt(dim_len);
				int width  = Integer.parseInt(dim_wid);
				int quantity = Integer.parseInt(qty);

				//setting Square 
				if(length != 0 && width != 0){
					customMnrRprRqstTmpDtlVO.setVolTpCd("S");
					customMnrRprRqstTmpDtlVO.setRprSzNo((length * width)  + "");
				//setting Size
				} else if(length != 0 || width != 0){
					customMnrRprRqstTmpDtlVO.setVolTpCd("Z");
					customMnrRprRqstTmpDtlVO.setRprSzNo((length + width)  + "");
				//checking QTY
				} else {
					customMnrRprRqstTmpDtlVO.setVolTpCd("Q");
					customMnrRprRqstTmpDtlVO.setRprSzNo("");
					if(quantity != 0){
						customMnrRprRqstTmpDtlVO.setRprQty(quantity + "");
					//setting QTY = 1
					} else {
						customMnrRprRqstTmpDtlVO.setRprQty("1");
					}
				}

				//2) setting
				Double costAmt =  Double.parseDouble(customMnrRprRqstTmpDtlVO.getRprLbrHrs()) * Double.parseDouble(customMnrRprRqstTmpDtlVO.getRprLbrRt());
				//rounding off below 2 decimal point
				customMnrRprRqstTmpDtlVO.setLbrCostAmt(String.format("%.2f", costAmt));
				//rounding off below 2 decimal point
				Double wrkAmt = costAmt + Double.parseDouble(customMnrRprRqstTmpDtlVO.getMtrlCostAmt());
				customMnrRprRqstTmpDtlVO.setMnrWrkAmt(String.format("%.2f", wrkAmt));

				//setting BASIC EDI to '0' without validation
				customMnrRprRqstTmpDtlVO.setRprLbrBzcHrs("0");
				customMnrRprRqstTmpDtlVO.setRprLbrBzcRt("0");
				customMnrRprRqstTmpDtlVO.setMnrLbrBzcAmt("0");
				customMnrRprRqstTmpDtlVO.setLbrMtrlBzcAmt("0");

				//getting cost_cd 
				String cost_cd = dbDao.searchTempEstimateCostCdData(customMnrRprRqstTmpHdrVO.getEqKndCd(),customMnrRprRqstTmpHdrVO.getEqTpszCd(),customMnrRprRqstTmpDtlVO.getEqCmpoCd());
				customMnrRprRqstTmpDtlVO.setCostCd(cost_cd);
				
				//getting DIV_CD.
				String div_cd = dbDao.searchTempEstimateDivCdData(customMnrRprRqstTmpDtlVO);
				customMnrRprRqstTmpDtlVO.setTrfDivCd(div_cd);	   
					
				//DTL DATA INSERT
				dbDao.addTempEstimateDTLData(customMnrRprRqstTmpDtlVO);
			}
		} catch (StringIndexOutOfBoundsException de) {
			log.error("\nEDI Format Error SEND Msg :\n" + eaiRecMsg + "\n");
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling Receive MQ] manageMQEstimateBasic"}).getMessage(),de);
		} catch (DAOException de) {
			log.error("\nEDI DAOException Error SEND Msg :\n" + eaiRecMsg + "\n");
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling Receive MQ] manageMQEstimateBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("\nEDI Exception Error SEND Msg :\n" + eaiRecMsg + "\n");
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling Receive MQ] manageMQEstimateBasic"}).getMessage(),de);
		}
		return interfaceGRPVO;
	}

	/**
	 * [EES_MNR_0161]retrieving Scrapping/Donation Creation. <br>
	 *
	 * @param String eqNo
	 * @return String
	 * @exception EventException
	 */
	public String searchFAEqNoBasic(String eqNo) throws EventException {
		String faEqNo = "";
		try {
			faEqNo = dbDao.searchFAEqNoData(eqNo);
			if(faEqNo.equals("") || faEqNo==null) {

				throw new EventException(new ErrorHandler("MNR00262",new String[]{"EQ No:"+eqNo}).getMessage());
			}
		} catch (EventException e){
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchFAEqNoBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchFAEqNoBasic"}).getMessage(),de);
		}
		return faEqNo;
	}

	/**
	 * [EES_MNR_0041]handling M&R Invoice Creation & Correction. <br>
	 *
	 * @param String mnrGrpTpCd
	 * @param String refNum
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createCSRIFBasic(String mnrGrpTpCd, String refNum, SignOnUserAccount account) throws EventException {
		String reg_no = "";
		CSRExternalFinderBC command = new CSRExternalFinderBCImpl();

		try {

			ApPayInvVO apPayInvVO = new ApPayInvVO();
			apPayInvVO = dbDao.searchApPayInvData(refNum);

			//apPayInvDtlVO

			//List<ApPayInvDtlVO> apPayInvDtlVO = null;
			List<ApPayInvDtlVO> apPayInvDtlVO = new ArrayList<ApPayInvDtlVO>();

			if(mnrGrpTpCd.equals("TLL")) {
				apPayInvDtlVO = dbDao.searchTotalLossApPayInvDtlData(refNum);
			} else {
				apPayInvDtlVO = dbDao.searchApPayInvDtlData(refNum);  
			}

			ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[apPayInvDtlVO.size()];

			if(apPayInvDtlVO != null && apPayInvDtlVO.size() > 0){
				for(int i = 0;i < apPayInvDtlVO.size();i++){

					ApPayInvDtlVO apPayInvDtlVO2 = new ApPayInvDtlVO();

					apPayInvDtlVO2.setIbflag("I");
					apPayInvDtlVO2.setVslCd(apPayInvDtlVO.get(i).getVslCd());
					apPayInvDtlVO2.setDeltFlg(apPayInvDtlVO.get(i).getDeltFlg());
					apPayInvDtlVO2.setSoSeq(apPayInvDtlVO.get(i).getSoSeq());
					apPayInvDtlVO2.setInvRgstSeq(apPayInvDtlVO.get(i).getInvRgstSeq());
					apPayInvDtlVO2.setRevDirCd(apPayInvDtlVO.get(i).getRevDirCd());
					apPayInvDtlVO2.setSo20ftQty(apPayInvDtlVO.get(i).getSo20ftQty());
					apPayInvDtlVO2.setAcctCd(apPayInvDtlVO.get(i).getAcctCd());
					apPayInvDtlVO2.setCntrTpszCd(apPayInvDtlVO.get(i).getCntrTpszCd());
					apPayInvDtlVO2.setSo40ftQty(apPayInvDtlVO.get(i).getSo40ftQty());
					apPayInvDtlVO2.setInvAmt(apPayInvDtlVO.get(i).getInvAmt());
					apPayInvDtlVO2.setPortCd(apPayInvDtlVO.get(i).getPortCd());
					apPayInvDtlVO2.setInvRgstNo(apPayInvDtlVO.get(i).getInvRgstNo());
					apPayInvDtlVO2.setSoOfcCtyCd(apPayInvDtlVO.get(i).getSoOfcCtyCd());
					apPayInvDtlVO2.setSkdVoyNo(apPayInvDtlVO.get(i).getSkdVoyNo());
					apPayInvDtlVO2.setSkdDirCd(apPayInvDtlVO.get(i).getSkdDirCd());
					apPayInvDtlVO2.setSoTeuQty(apPayInvDtlVO.get(i).getSoTeuQty());
					apPayInvDtlVO2.setSoUtQty(apPayInvDtlVO.get(i).getSoUtQty());
					apPayInvDtlVO2.setSlanCd(apPayInvDtlVO.get(i).getSlanCd());
					apPayInvDtlVO2.setYdCd(apPayInvDtlVO.get(i).getYdCd());
					apPayInvDtlVO2.setLgsCostCd(apPayInvDtlVO.get(i).getLgsCostCd());
					apPayInvDtlVO2.setActVvdCd(apPayInvDtlVO.get(i).getActVvdCd());
					apPayInvDtlVO2.setActPlc(apPayInvDtlVO.get(i).getActPlc());
					apPayInvDtlVO2.setActDt(apPayInvDtlVO.get(i).getActDt());
					
					apPayInvDtlVOs[i] = apPayInvDtlVO2;
				}
			    reg_no = command.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
			}else{
				throw new Exception(new ErrorHandler("MNR00001",new String[]{"Cost Activity Info. related to the Account Code does not exist. Please Check AP Cost Activity Information in Statement Common."}).getMessage());
			}
			
			//reg_no = command.createApPayInvInfo(apPayInvVO, (ApPayInvDtlVO[])apPayInvDtlVO.toArray(), account);


		} catch (EventException e){
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] createCSRIFBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return reg_no;
	}


	/**
	 * [EES_MNR_0041]deleting M&R Invoice Creation & Correction. <br>
	 *
	 * @param String refNum
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeCSRIFBasic(String refNum, SignOnUserAccount account) throws EventException{
		CSRExternalFinderBC command = new CSRExternalFinderBCImpl();
		try {

		    ApPayInvVO apPayInvVO = new ApPayInvVO();
		    ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[0];

		    apPayInvVO.setUpdUsrId(account.getUsr_id());
		    apPayInvVO.setInvOfcCd(account.getOfc_cd());
		    apPayInvVO.setDeltFlg("Y");
		    apPayInvVO.setInvRgstNo(refNum);

		    command.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

		} catch (EventException e){
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] removeCSRIFBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0161]retrieving Invoice . <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */
	public ReceivableInvoiceGRPVO searchInvArIfListBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException {
		InvArIfMnVO invArIfMnVO = null;
		List<InvArIfChgVO> invArIfChgVOs = null;
		List<InvArIfCntrVO> invArIfCntrVOs = null;

		try {

			receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setUserOfcCd(account.getOfc_cd());
			receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setCreUsrId(account.getUsr_id());

			invArIfMnVO = dbDao.searchInvArIfMnData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());
			invArIfChgVOs = dbDao.searchInvArIfChgData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());
			invArIfCntrVOs = dbDao.searchInvArIfCntrData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());

			receivableInvoiceGRPVO.setInvArIfMnVO(invArIfMnVO);
			receivableInvoiceGRPVO.setInvArIfChgVOs(invArIfChgVOs);
			receivableInvoiceGRPVO.setInvArIfCntrVOs(invArIfCntrVOs);

			return receivableInvoiceGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Invoice List] searchInvArIfListBasic"}).getMessage(),ex);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Invoice List] searchInvArIfListBasic"}).getMessage(),e);
		}
	}

	/**
	 * [EES_MNR_QEXE] handling EDI FLAG SS error  <br>
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO interfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO reSendErrorEDIBasic(InterfaceGRPVO interfaceGRPVO) throws EventException {
		try {
			CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVO();
			dbDao.modifyESTTempFlagData(customMnrRprRqstTmpHdrVO,interfaceGRPVO.getEdiErrCd());
			return interfaceGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EDI RE-SEND] reSendErrorEDIBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EDI RE-SEND] reSendErrorEDIBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_QEXE] retrieving error EDI resending list <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO searchReSendErrorEDIListBasic(InterfaceGRPVO interfaceGRPVO) throws EventException {
		try {
			List<CustomMnrRprRqstTmpHdrVO> customMnrRprRqstTmpHdrVOS = dbDao.searchReSendEDIEstimateHRDData();
			interfaceGRPVO.setCustomMnrRprRqstTmpHdrVOS(customMnrRprRqstTmpHdrVOS);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EDI RE-SEND] searchReSendErrorEDIListBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EDI RE-SEND] searchReSendErrorEDIListBasic"}).getMessage(),de);
		}
		return interfaceGRPVO;
	}

	/**
	 * handling Estimate Upload. <br>
	 *
	 * @param EstimateUploadVO[] estimateUploadVOs
	 * @param SignOnUserAccount userAccount
	 * @param String reqUi
	 * @return EstimateUploadGRPVO
	 * @exception EventException
	 */
	public EstimateUploadGRPVO createEstimateUploadBasic(EstimateUploadVO[] estimateUploadVOs, SignOnUserAccount userAccount, String reqUi) throws EventException {
		EstimateUploadGRPVO estimateUploadGRPVO = new EstimateUploadGRPVO();
		List<InterfaceGRPVO> interfaceGRPVOList = new ArrayList<InterfaceGRPVO>();
		List<String> estimateUploadPK = new ArrayList<String>();

		try {
			Map<String, CustomMnrRprRqstTmpHdrVO> estimateTmpHeaderMap = new HashMap<String, CustomMnrRprRqstTmpHdrVO>();
			String estimateTmpHeaderPK = null;
				
			for(int i = 0; i < estimateUploadVOs.length; i++) {
				EstimateUploadVO estimateUploadVO = estimateUploadVOs[i];

				// resetting EstimateUploadVO header 
				estimateTmpHeaderPK = estimateUploadVO.getEstimateTmpHeaderPK();
				//checking Duplicates header
				if(!estimateTmpHeaderMap.containsKey(estimateTmpHeaderPK)) {
					//creating Interface VO 
					InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
					//creating header data VO
					CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = new CustomMnrRprRqstTmpHdrVO();

					customMnrRprRqstTmpHdrVO.setRqstRefNo(estimateUploadVO.getRqstRefNo());		//EST_NO
					customMnrRprRqstTmpHdrVO.setRqstEqNo(estimateUploadVO.getRqstEqNo());		//EQ_NO
					customMnrRprRqstTmpHdrVO.setCreUsrId(userAccount.getUsr_id());				//AUTH_SENDER
					customMnrRprRqstTmpHdrVO.setUpdUsrId(userAccount.getUsr_id());
					customMnrRprRqstTmpHdrVO.setCreDt(estimateUploadVO.getEqDmgDt());			//ACT_TRANS_DT
					customMnrRprRqstTmpHdrVO.setUpdDt(estimateUploadVO.getEqDmgDt());
					customMnrRprRqstTmpHdrVO.setEqDmgDt(estimateUploadVO.getEqDmgDt());
					customMnrRprRqstTmpHdrVO.setRqstDt("");
					customMnrRprRqstTmpHdrVO.setCurrCd(estimateUploadVO.getCurrCd());			//CUR_CD
					customMnrRprRqstTmpHdrVO.setEdiId(estimateUploadVO.getEdiId());				//EDI_ID
					customMnrRprRqstTmpHdrVO.setRprOffhFlg(estimateUploadVO.getRprOffhFlg());	//PREV_ONHIRE_IND

					customMnrRprRqstTmpHdrVO.setRprRqstLstVerFlg("Y");
					//resetting EQ_TYPE
					String eqType =  dbDao.searchEqTypeByEqNoData(customMnrRprRqstTmpHdrVO);
					customMnrRprRqstTmpHdrVO.setEqKndCd(eqType);

					//retrieving SEQ,VERSION NO
					CustomMnrRprRqstTmpHdrVO tempVO = dbDao.searchTempEstimateSeqData(customMnrRprRqstTmpHdrVO);

					if(tempVO != null){
						//version up in case of existing estimate number
						int asIsVerno = Integer.parseInt(tempVO.getRprRqstTmpVerNo());
						customMnrRprRqstTmpHdrVO.setRprRqstTmpSeq(tempVO.getRprRqstTmpSeq());
						customMnrRprRqstTmpHdrVO.setRprRqstTmpVerNo(asIsVerno + 1 + "");
					} else {
						//creating in case of not existing
						tempVO = dbDao.searchEstimateTempSeqNewEqData(customMnrRprRqstTmpHdrVO);
						customMnrRprRqstTmpHdrVO.setRprRqstTmpSeq(tempVO.getRprRqstTmpSeq());
						customMnrRprRqstTmpHdrVO.setRprRqstTmpVerNo(tempVO.getRprRqstTmpVerNo());
					}

					if(customMnrRprRqstTmpHdrVO.getRqstRefNo().equals("")){
						//Rqst_Ref_No ERROR
						interfaceGRPVO.setRqstRefNoChk("RE");
					} else {
						interfaceGRPVO.setRqstRefNoChk("SS");
					}

					//*************** checking date format *******************//
					String tempToday  = (new SimpleDateFormat("yyyyMMdd")).format(new Date());

					//1. ACT_TRANS_DT
					//DE -> SS
					if(!customMnrRprRqstTmpHdrVO.getCreDt().equals("")){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
						ParsePosition pos = new ParsePosition(0);
						Date date = sdf.parse(customMnrRprRqstTmpHdrVO.getCreDt(),pos);
						if(date == null){
							customMnrRprRqstTmpHdrVO.setCreDt(tempToday);
							customMnrRprRqstTmpHdrVO.setUpdDt(tempToday);
							customMnrRprRqstTmpHdrVO.setEqDmgDt(tempToday);
							interfaceGRPVO.setDateFormChk("SS");
						} else {
							interfaceGRPVO.setDateFormChk("SS");
						}
					} else {
						customMnrRprRqstTmpHdrVO.setCreDt(tempToday);
						customMnrRprRqstTmpHdrVO.setUpdDt(tempToday);
						customMnrRprRqstTmpHdrVO.setEqDmgDt(tempToday);
						interfaceGRPVO.setDateFormChk("SS");
					}

					//2. EST_DT
					if(interfaceGRPVO.getDateFormChk().equals("SS")){
						if(!customMnrRprRqstTmpHdrVO.getRqstDt().equals("") ){
							SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
							ParsePosition pos = new ParsePosition(0);
							Date date = sdf.parse(customMnrRprRqstTmpHdrVO.getRqstDt(),pos);
							if(date == null){
								customMnrRprRqstTmpHdrVO.setRqstDt(tempToday);
								interfaceGRPVO.setDateFormChk("SS");
							} else {
								interfaceGRPVO.setDateFormChk("SS");
							}
						} else {
							customMnrRprRqstTmpHdrVO.setRqstDt(tempToday);
							interfaceGRPVO.setDateFormChk("SS");
						}
					}
					//*************** checking date format *******************//

					//retrieving TPSZ
					String tpszCd = dbDao.searchTempEstimateTpszData(customMnrRprRqstTmpHdrVO);
					customMnrRprRqstTmpHdrVO.setEqTpszCd(tpszCd);

					// excel upload in case of input COM system(SPP) repair estimate  
					if(reqUi.equalsIgnoreCase("EES_MNR_S019")){
						customMnrRprRqstTmpHdrVO.setRprStsCd("SS");
						customMnrRprRqstTmpHdrVO.setMnrInpTpCd("M");
					} else {
						customMnrRprRqstTmpHdrVO.setRprStsCd("HR");
						customMnrRprRqstTmpHdrVO.setMnrInpTpCd("E");
					}			
						
					customMnrRprRqstTmpHdrVO.setRprDtlStsCd("1");
					
					customMnrRprRqstTmpHdrVO.setRqstUsrId(customMnrRprRqstTmpHdrVO.getCreUsrId());
					customMnrRprRqstTmpHdrVO.setRprWrkTpCd("W");

					//NOT NULL 
					customMnrRprRqstTmpHdrVO.setN3ptyFlg("N");
					customMnrRprRqstTmpHdrVO.setDispFlg("N");

					//VNDR_SEQ AGMT 
					CustomMnrRprRqstTmpHdrVO tempVO2 = dbDao.searchTempEstimateAGMTData(customMnrRprRqstTmpHdrVO);

					if(tempVO2 != null){
						customMnrRprRqstTmpHdrVO.setVndrSeq(tempVO2.getVndrSeq());
						customMnrRprRqstTmpHdrVO.setAgmtOfcCtyCd(tempVO2.getAgmtOfcCtyCd());
						customMnrRprRqstTmpHdrVO.setAgmtSeq(tempVO2.getAgmtSeq());
						customMnrRprRqstTmpHdrVO.setAgmtVerNo(tempVO2.getAgmtVerNo());
						interfaceGRPVO.setVenderChk("SS");
					} else {  
						customMnrRprRqstTmpHdrVO.setVndrSeq("");
						customMnrRprRqstTmpHdrVO.setAgmtOfcCtyCd("");
						customMnrRprRqstTmpHdrVO.setAgmtSeq("");
						customMnrRprRqstTmpHdrVO.setAgmtVerNo("");
						interfaceGRPVO.setVenderChk("VE");
					}

					//setting flag 'N'
					dbDao.modifyESTTmpHDRLastVersionUnFlagData(customMnrRprRqstTmpHdrVO);
					dbDao.modifyESTTmpDTLLastVersionUnFlagData(customMnrRprRqstTmpHdrVO);
					//adding header data
					dbDao.addTempEstimateHDRData(customMnrRprRqstTmpHdrVO);

					interfaceGRPVO.setCustomMnrRprRqstTmpHdrVO(customMnrRprRqstTmpHdrVO);


					//checking VALIDATION EQ_NO UE/SS
					String eqChk = dbDao.searchEQFlagFileListByEQData(customMnrRprRqstTmpHdrVO);
					interfaceGRPVO.setEqChk(eqChk);

					//setting header information
					estimateTmpHeaderMap.put(estimateTmpHeaderPK, customMnrRprRqstTmpHdrVO);
					// setting I/F 
					interfaceGRPVOList.add(interfaceGRPVO);
					// setting complex PK
					StringBuffer complexPkBuff = new StringBuffer();
					complexPkBuff.append(customMnrRprRqstTmpHdrVO.getRqstEqNo());
					complexPkBuff.append(customMnrRprRqstTmpHdrVO.getRprRqstTmpSeq());
					complexPkBuff.append(customMnrRprRqstTmpHdrVO.getRprRqstTmpVerNo());
					estimateUploadPK.add(complexPkBuff.toString());
				}
 
				// creating detail data VO
				CustomMnrRprRqstTmpDtlVO customMnrRprRqstTmpDtlVO = new CustomMnrRprRqstTmpDtlVO();
				// retrieving header data VO
				CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = estimateTmpHeaderMap.get(estimateTmpHeaderPK);

				customMnrRprRqstTmpDtlVO.setEqLocCd(estimateUploadVO.getEqLocCd());				//DAM_LOC_CD
				customMnrRprRqstTmpDtlVO.setEqCmpoCd(estimateUploadVO.getEqCmpoCd());			//COMPNT_CD
				customMnrRprRqstTmpDtlVO.setEqDmgCd(estimateUploadVO.getEqDmgCd());				//DAM_TP_CD
				customMnrRprRqstTmpDtlVO.setEqRprCd(estimateUploadVO.getEqRprCd());				//REPR_METH_CD

				customMnrRprRqstTmpDtlVO.setRprLbrHrs(estimateUploadVO.getRprLbrHrs());			//MAN_HOUR
				customMnrRprRqstTmpDtlVO.setRprLbrRt(estimateUploadVO.getRprLbrRt());			//LAB_RATE
				customMnrRprRqstTmpDtlVO.setMtrlCostAmt(estimateUploadVO.getMtrlCostAmt());		//MATRL_COST

				//default value
				customMnrRprRqstTmpDtlVO.setRqstEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrRprRqstTmpDtlVO.setRprRqstTmpSeq(customMnrRprRqstTmpHdrVO.getRprRqstTmpSeq());
				customMnrRprRqstTmpDtlVO.setRprRqstTmpVerNo(customMnrRprRqstTmpHdrVO.getRprRqstTmpVerNo());

				//getting DTL_SEQ.
				CustomMnrRprRqstTmpDtlVO tempDtlVO = dbDao.searchEstimateTempDtlSeqNewEqData(customMnrRprRqstTmpDtlVO);
				customMnrRprRqstTmpDtlVO.setRprRqstTmpDtlSeq(tempDtlVO.getRprRqstTmpDtlSeq());

				customMnrRprRqstTmpDtlVO.setEqLocCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqCmpoCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqDmgCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqRprCdChkFlg("N");

				//setting
				customMnrRprRqstTmpDtlVO.setCreUsrId(customMnrRprRqstTmpHdrVO.getCreUsrId());
				customMnrRprRqstTmpDtlVO.setUpdUsrId(customMnrRprRqstTmpHdrVO.getCreUsrId());
				customMnrRprRqstTmpDtlVO.setCreDt(customMnrRprRqstTmpHdrVO.getCreDt());
				customMnrRprRqstTmpDtlVO.setUpdDt(customMnrRprRqstTmpHdrVO.getCreDt());

				customMnrRprRqstTmpDtlVO.setRprRqstLstVerFlg("Y");
				customMnrRprRqstTmpDtlVO.setMnrLrAcctFlg("N");
				customMnrRprRqstTmpDtlVO.setN3ptyFlg("N");
				customMnrRprRqstTmpDtlVO.setTrfDivCd(" ");

				//eqChk -> ""
				customMnrRprRqstTmpDtlVO.setMnrVrfyTpCd("");

				//Qty/Size/Square
				String volTpCd = estimateUploadVO.getVolTpCd();
				customMnrRprRqstTmpDtlVO.setVolTpCd(volTpCd);

				if(volTpCd.equals("S")) {
					customMnrRprRqstTmpDtlVO.setRprSzNo(estimateUploadVO.getRprSzNo());
				} else if(volTpCd.equals("Z")) {
					customMnrRprRqstTmpDtlVO.setRprSzNo(estimateUploadVO.getRprSzNo());
				} else {// volTpCd is Q
					String rprQty = estimateUploadVO.getRprQty();
					customMnrRprRqstTmpDtlVO.setRprSzNo("");
					customMnrRprRqstTmpDtlVO.setRprQty(rprQty.equals("0") ? "1" : rprQty);
				}

				//2) setting
				Double costAmt =  Double.parseDouble(customMnrRprRqstTmpDtlVO.getRprLbrHrs()) * Double.parseDouble(customMnrRprRqstTmpDtlVO.getRprLbrRt());
				//rounding off below 2 decimal point
				customMnrRprRqstTmpDtlVO.setLbrCostAmt(String.format("%.2f", costAmt));
				//rounding off below 2 decimal point
				Double wrkAmt = costAmt + Double.parseDouble(customMnrRprRqstTmpDtlVO.getMtrlCostAmt());
				customMnrRprRqstTmpDtlVO.setMnrWrkAmt(String.format("%.2f", wrkAmt));

				//setting BASIC EDI to '0' without validation
				customMnrRprRqstTmpDtlVO.setRprLbrBzcHrs("0");
				customMnrRprRqstTmpDtlVO.setRprLbrBzcRt("0");
				customMnrRprRqstTmpDtlVO.setMnrLbrBzcAmt("0");
				customMnrRprRqstTmpDtlVO.setLbrMtrlBzcAmt("0");

				//getting cost_cd
				String cost_cd = dbDao.searchTempEstimateCostCdData(customMnrRprRqstTmpHdrVO.getEqKndCd(),customMnrRprRqstTmpHdrVO.getEqTpszCd(),customMnrRprRqstTmpDtlVO.getEqCmpoCd());
				customMnrRprRqstTmpDtlVO.setCostCd(cost_cd);
				
				//getting DIV_CD. 
				String div_cd = dbDao.searchTempEstimateDivCdData(customMnrRprRqstTmpDtlVO);
				customMnrRprRqstTmpDtlVO.setTrfDivCd(div_cd);		
					
				//DTL DATA INSERT
				dbDao.addTempEstimateDTLData(customMnrRprRqstTmpDtlVO);
			}

			estimateUploadGRPVO.setInterfaceGRPVOList(interfaceGRPVOList);
			estimateUploadGRPVO.setEstimateUploadPK(estimateUploadPK);
		} catch (DAOException de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"EstimateUploadBasic Create"}).getMessage(),de);
		} catch (Exception de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"EstimateUploadBasic Create"}).getMessage(),de);
		}

		return estimateUploadGRPVO;
	}

	/**
	 * retrieving Estimate Upload. <br>
	 *
	 * @param EstimateUploadGRPVO estimateUploadGRPVO
	 * @return List<EstimateUploadVO>
	 * @exception EventException
	 */
	public List<EstimateUploadVO> searchEstimateUploadResultBasic(EstimateUploadGRPVO estimateUploadGRPVO) throws EventException {
		List<EstimateUploadVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchEstimateUploadResultData(estimateUploadGRPVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"EstimateUploadResultBasic Search"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"EstimateUploadResultBasic Search"}).getMessage(),de);
		}
		return resultVOs;
	}
	
	/**
	 * [EES_MNR_0161]Scrapping/Donation Creation의 정보를 작업 합니다. <br>
	 *
	 * @param FaErpListVO[] arrayFaErpListVOs
	 * @param SignOnUserAccount account
	 * @param String sFlag
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public void faSendBasic(FaErpListVO[] arrayFaErpListVOs, SignOnUserAccount account, String sFlag) throws EventException{
		List<FaErpListVO> sendVoList = new ArrayList<FaErpListVO>();

		HashMap reHMap = null;
		String ifTrcSeq = "";
		DocResultVO docResultVO = null;
		try {
			for (int i=0; i<arrayFaErpListVOs.length; i++){
				String tagNumber = arrayFaErpListVOs[i].getTagNumber();
				if(!tagNumber.equals("NOSEND")) {
					sendVoList.add(arrayFaErpListVOs[i]);
				}
			}

			if(sendVoList.size() > 0) {
				reHMap = eaiFaDao.sendErpToFAData("FNS027-0001",sendVoList);
				docResultVO = new DocResultVO();
				docResultVO.setMnrGrpTpCd(sFlag); // Disposal Invoice Issue(DSP), Total Loss Request(TTL), Scrapping/Donation Creation(SCR) 
				docResultVO.setMnrRefNo((String)reHMap.get("integrationId")); // InstanceId
				docResultVO.setCreUsrId(account.getUsr_id());
				for(int i=0; i<sendVoList.size(); i++){
					ifTrcSeq = dbDao.searchMnrIfTrcSeqData(); // seq

					docResultVO.setIfTrcSeq(ifTrcSeq); // seq
					docResultVO.setMnrIfMsgCtnt(sendVoList.get(i).getTagNumber()); // tag_number
					docResultVO.setMnrIfDt(sendVoList.get(i).getLastUpdateDate()); // LAST_UPDATE_DATE
					
					dbDao.addFASendEAIData(docResultVO);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] faSendBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] faSendBasic"}).getMessage(),de);
		}
	}
	
	/**
	 * Verifying New Port Invoice
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO verifySOLBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException {
		try{
			CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = interfaceGRPVO.getArrayCustomMnrOrdTmpHdrVOs();
			CustomMnrOrdTmpDtlVO[][] customMnrOrdTmpDtlVOs = interfaceGRPVO.getArrayCustomMnrOrdTmpDtlVOs();
			
			List<CustomMnrOrdTmpHdrVO> listCustomMnrOrdTmpHdr = new ArrayList<CustomMnrOrdTmpHdrVO>();
			List<CustomMnrOrdTmpDtlVO> listCustomMnrOrdTmpDtl = new ArrayList<CustomMnrOrdTmpDtlVO>();
			
			String sVndrSeq = "";

			CheckInvoiceNoVO checkInvoiceNoVO = new CheckInvoiceNoVO();
//			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl();
			GeneralCodeCheckMgtBC command1 = new GeneralCodeCheckMgtBCImpl();
//			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			CustomMnrEqStsVVO eqInfo = new CustomMnrEqStsVVO();
			GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
			GeneralCodeINVO generalCodeINVO = new GeneralCodeINVO();
			
			for(int i = 0; i < customMnrOrdTmpHdrVOs.length; i++){
//				Double invTot = 0.00;
				BigDecimal invTotal = new BigDecimal("0.00");
				// Valid Service Provider Code.HEADER.VND_CD 와 DETAIL.VND_CD를 각각 MDM_VENDOR 등록되어 있어야 함 : US
				sVndrSeq = dbDao.searchMnrOrdTmpVndrSeqData(customMnrOrdTmpHdrVOs[i].getVndrSeq());
				customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("");
				if("".equals(sVndrSeq) || sVndrSeq == null){
					customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("US");
				}
				else if( !"SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
					customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("SS"); 
				}

				checkInvoiceNoVO.setInvNo(customMnrOrdTmpHdrVOs[i].getInvNo());
				if(sVndrSeq != null){
					checkInvoiceNoVO.setVndrSeq(sVndrSeq);
				}
				checkInvoiceNoVO.setRefPk("");

				List<CheckInvoiceNoVO> list = checkInvoiceNo(checkInvoiceNoVO);  // Invoice NO DUP. CHECK LOGIC
				if(list != null && list.size() > 0){
					if(!"".equals(list.get(0).getInvNo()) || list.get(0).getInvNo() != null){
						if(StringUtil.isEmpty(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
							customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("AI"); // Invoice NO DUP Error
						}
						else{
							customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()+";AI"); // Invoice NO DUP Error
						}
					}   
					list.clear();
				}
				
				String dpPrcsKnt = dbDao.searchCurrencyDecimalData(customMnrOrdTmpHdrVOs[i].getCurrCd());
				int dpCnt = Integer.parseInt(dpPrcsKnt);
				if(!customMnrOrdTmpHdrVOs[i].getCostOfcCd().equals(account.getOfc_cd())){
					if(StringUtil.isEmpty(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("OE"); // Invoice NO DUP Error
					}
					else{
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()+";OE"); // Invoice NO DUP Error
					}
				}
				
				generalCodeINVO.setCheckType("OFC");
				generalCodeINVO.setCheckValue(customMnrOrdTmpHdrVOs[i].getCostOfcCd());
				generalCodeCheckMgtGRPVO.setGeneralCodeINVO(generalCodeINVO);
				
				generalCodeCheckMgtGRPVO = command1.checkGeneralCodeBasic(generalCodeCheckMgtGRPVO);
				
				if(generalCodeCheckMgtGRPVO.getCustomMnrGeneralCodeVOS() == null || generalCodeCheckMgtGRPVO.getCustomMnrGeneralCodeVOS().size() == 0){
					if(StringUtil.isEmpty(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("UO"); // Invoice NO DUP Error
					}
					else{
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()+";UO"); // Invoice NO DUP Error
					}
					generalCodeCheckMgtGRPVO.getCustomMnrGeneralCodeVOS().clear();
				}
				
				for(int j = 0; j < customMnrOrdTmpDtlVOs[i].length; j++){
					// Equipment is Containers (U), Chassis(Z) and Gensets.(G) -> DEATIL.EQ_TYPE : UE
					EQGeneralInfoINVO eQGeneralInfoINVO = new EQGeneralInfoINVO();
					eQGeneralInfoINVO.setEqNo(customMnrOrdTmpDtlVOs[i][j].getEqNo());
					eQGeneralInfoINVO.setTotalLossDate(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());
					if("MRDRRCNR".equals(customMnrOrdTmpDtlVOs[i][j].getCostCdAll()) || "MRDROHER".equals(customMnrOrdTmpDtlVOs[i][j].getCostCdAll()) || "MRDROHCM".equals(customMnrOrdTmpDtlVOs[i][j].getCostCdAll())){
						eQGeneralInfoINVO.setKndCd("N");
					}else{
						eQGeneralInfoINVO.setKndCd("S");
					}
					List<CustomMnrEqStsVVO> eqlist = dbDao.searchEqInfoData(eQGeneralInfoINVO);

					customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("");
					customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("");
					if(eqlist != null && eqlist.size() > 0){
						eqInfo = eqlist.get(0);
//						if("A".equals(eqInfo.getActInd())){
//							customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("");
//							if(!"U".equals(customMnrOrdTmpDtlVOs[i][j].getEqKndCd()) && !"Z".equals(customMnrOrdTmpDtlVOs[i][j].getEqKndCd()) && !"G".equals(customMnrOrdTmpDtlVOs[i][j].getEqKndCd())){
//								customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("UE");
//								bSusses = false;
//							}
//							else if( "".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
//								customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("SS");
//							}
							
							customMnrOrdTmpDtlVOs[i][j].setEqTpszCd(eqInfo.getEqTpszCd());
							customMnrOrdTmpDtlVOs[i][j].setEqKndCd(eqInfo.getEqType());
							customMnrOrdTmpDtlVOs[i][j].setEqStsCd(eqInfo.getCntrStsCd());
							
							if(customMnrOrdTmpDtlVOs[i][j].getCostCdAll().length() == 8){
								String orgCostCd = customMnrOrdTmpDtlVOs[i][j].getCostCdAll();
						
								// Valid Cost Code. _ DETAIL.TARIFF_CD (SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_ID_CD = DEATIL.EQ_TYPE||'G' : CG
								String sCostCd = dbDao.searchMnrOrdTmpCostCdData(orgCostCd.substring(0, 6),customMnrOrdTmpDtlVOs[i][j].getEqKndCd());
								String sCostDtlCd = dbDao.searchMnrOrdTmpCostDtlCdData(orgCostCd.substring(0, 6), orgCostCd.substring(6, 8));
								
								if(("".equals(sCostCd) || sCostCd == null)||("".equals(sCostDtlCd) || sCostDtlCd == null)){
									if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CG");
										customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECG");
									}
									else{
										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CG");
										customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECG");
									}
								}
								else if( "".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("SS"); 
									customMnrOrdTmpDtlVOs[i][j].setCostCd(sCostCd);
									customMnrOrdTmpDtlVOs[i][j].setCostDtlCd(sCostDtlCd);
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("SSS");
								}	
							}else{
								if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CG");
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECG");
								}
								else{
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CG");
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECG");
								}
							}
							
							// Valid Service Provider Code.HEADER.VND_CD 와 DETAIL.VND_CD를 각각 MDM_VENDOR 등록되어 있어야 함 : US
							sVndrSeq = dbDao.searchMnrOrdTmpVndrSeqData(customMnrOrdTmpDtlVOs[i][j].getVndrSeq());
							
							if("".equals(sVndrSeq) || sVndrSeq == null){
								if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("US");
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EUS");
								}
								else{
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";US");
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EUS");
								}
							}
							else if( "".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
								customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("SS");
								customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("SSS");
							}
							
							if("U".equals(customMnrOrdTmpDtlVOs[i][j].getEqKndCd())&&customMnrOrdTmpDtlVOs[i][j].getCostCd().endsWith("RC")){
								if(customMnrOrdTmpDtlVOs[i][j].getCostAmt().indexOf("-") == -1){
									if(dbDao.searchMvmtCntSameDayData(customMnrOrdTmpDtlVOs[i][j].getEqNo(), customMnrOrdTmpDtlVOs[i][j].getRprRsltDt()) <= 1){
										List<MVMTListbyDMGEvntDateVO> listVO = new ArrayList<MVMTListbyDMGEvntDateVO>();
	//									String eventTime = dbDao.searchMvmtTimeData(customMnrOrdTmpDtlVOs[i][j].getEqNo(), customMnrOrdTmpDtlVOs[i][j].getRprRsltDt(), customMnrOrdTmpDtlVOs[i][j].getYdCd(), "MT");
	//									if("".equals(eventTime)){
	//										eventTime = dbDao.searchMvmtTimeData(customMnrOrdTmpDtlVOs[i][j].getEqNo(), customMnrOrdTmpDtlVOs[i][j].getRprRsltDt(), customMnrOrdTmpDtlVOs[i][j].getYdCd(), "");
	//										if("".equals(eventTime)){
	//											eventTime = "2359";
	//										}
	//									}
										String damageFlg = ctmDao2.getCntrDamageFlg(customMnrOrdTmpDtlVOs[i][j].getEqNo(),customMnrOrdTmpDtlVOs[i][j].getRprRsltDt()+"2359", customMnrOrdTmpDtlVOs[i][j].getYdCd());
										
										if (damageFlg == null || damageFlg.equals("")) {
											if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
												customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("IW");
												customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EIW");
											}
											else{
												customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";IW");
												customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EIW");
											}
										} else {
											listVO = ctmDao1.checkMVMTListbyDMGEventDate(customMnrOrdTmpDtlVOs[i][j].getEqNo(), customMnrOrdTmpDtlVOs[i][j].getRprRsltDt()+"2359", customMnrOrdTmpDtlVOs[i][j].getYdCd(), "N", "N");
											
											if (listVO == null || listVO.size() == 0) {
												listVO = ctmDao1.checkMVMTListbyDMGEventDate(customMnrOrdTmpDtlVOs[i][j].getEqNo(), customMnrOrdTmpDtlVOs[i][j].getRprRsltDt()+"2359", customMnrOrdTmpDtlVOs[i][j].getYdCd(), "N", "NN");
											}
											
											if (listVO == null || listVO.size() == 0) {
												if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
													customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("IW");
													customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EIW");
												}
												else{
													customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";IW");
													customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EIW");
												}
											}else{
												if( "".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
													customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("SS");
													customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("SSS");
												}
											}
										}
									}else{
										String damgeFlag = dbDao.searchDamageStatusData(customMnrOrdTmpDtlVOs[i][j].getEqNo(), customMnrOrdTmpDtlVOs[i][j].getRprRsltDt(), customMnrOrdTmpDtlVOs[i][j].getYdCd());
										if("Y".equals(damgeFlag)){
											if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
												customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("MW");
												customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("WMW");
											}
											else{
												customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";MW");
												customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("WMW");
											}
										}else{
											if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
												customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("MW");
												customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("SMW");
											}
											else{
												customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";MW");
												customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("SMW");
											}
										}
										
									}
								}
							}
//						}else{
//							customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("UE"); 
//							customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EUE");
//						}
					}else{
						if("".equals(customMnrOrdTmpDtlVOs[i][j].getEqNo())){
							if(customMnrOrdTmpDtlVOs[i][j].getCostCdAll().length() == 8){
								String costCdCheck = dbDao.checkQtyCostCodeData(customMnrOrdTmpDtlVOs[i][j]);
								customMnrOrdTmpDtlVOs[i][j].setEqKndCd(costCdCheck.substring(2,3));
								if("QT".equals(costCdCheck.substring(0,2))){
									String orgCostCd = customMnrOrdTmpDtlVOs[i][j].getCostCdAll();
									String sCostDtlCd = dbDao.searchMnrOrdTmpCostDtlCdData(orgCostCd.substring(0, 6), orgCostCd.substring(6, 8));
									
									if(("".equals(sCostDtlCd) || sCostDtlCd == null)){
										if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CG");
											customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECG");
										}
										else{
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CG");
											customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECG");
										}
									}
									else if( "".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("SS"); 
										customMnrOrdTmpDtlVOs[i][j].setCostCd(orgCostCd.substring(0, 6));
										customMnrOrdTmpDtlVOs[i][j].setCostDtlCd(sCostDtlCd);
										customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("SSS");
										customMnrOrdTmpDtlVOs[i][j].setQtyFlg("Y");
									}	
								}else{
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("UE"); 
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EUE");
								}
							}else{
								if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CG");
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECG");
								}
								else{
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CG");
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECG");
								}
							}
						}else{
							customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("UE"); 
							customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EUE");
						}
					}
					
					if("Y".equals(dbDao.searchAgmtExistData(customMnrOrdTmpDtlVOs[i][j]))){
						String agmtCheck = dbDao.searchAgreementExistData(customMnrOrdTmpDtlVOs[i][j]);
						if(!"".equals(agmtCheck)){
							String costCheck = dbDao.searchCostCdAgmtData(customMnrOrdTmpDtlVOs[i][j]);
//							String costCheck = "";
							
							if(!"OK".equals(costCheck)){
								if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CW"); 
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECW");
								}else{
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CW");
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECW");
								}
							}else{
								String costTpSzCheck = dbDao.searchCostTypeSizeData(customMnrOrdTmpDtlVOs[i][j]);
								
								if(!"OK".equals(costTpSzCheck)){
									if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("TW"); 
										customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ETW");
									}else{
										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CW");
										customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ETW");
									}
								}else{
									List<CustomMnrAgmtRtVO> customMnrAgmtRtVOS = this.searchAgmtRateBasic(customMnrOrdTmpDtlVOs[i][j]);
									if(customMnrAgmtRtVOS != null){
										if(customMnrOrdTmpDtlVOs[i][j].getCostCd().endsWith("RC")){ // case of rate 0
											boolean result = false;
											for(int k=0; k < customMnrAgmtRtVOS.size(); k++){
												CustomMnrAgmtRtVO customMnrAgmtRtVO = customMnrAgmtRtVOS.get(k);
												if(!"0".equals(customMnrAgmtRtVO.getAgmtRtAmt())){
													result = true;
												}
											}
											
											if(!result){
												if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
													customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CW"); 
													customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECW");
												}else{
													customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";CW");
													customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("ECW");
												}
											}
										}
									}else{
										if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("YW"); 
											customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EYW");
										}else{
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";YW");
											customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EYW");
										}
									}
								}
								
							}

						}else{
							if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
								customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("EW"); 
								customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EEW");
							}else{
								customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";EW");
								customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EEW");
							}
						}
					}
					if(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc().indexOf("EW") < 0 && customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc().indexOf("YW") < 0 && customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc().indexOf("TW") < 0 && customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc().indexOf("CW") < 0){
						if("Y".equals(dbDao.searchAgmtRateFlagData(customMnrOrdTmpDtlVOs[i][j]))){
							if(customMnrOrdTmpDtlVOs[i][j].getRprQty().indexOf(".") > 0){
								if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("DC"); 
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EDC");
								}else{
									customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";DC");
									customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EDC");
								}
							}else{
								if(customMnrOrdTmpDtlVOs[i][j].getCostAmt().indexOf("-") == -1){
									List<CustomMnrAgmtRtVO> customMnrAgmtRtVOS = this.searchAgmtRateBasic(customMnrOrdTmpDtlVOs[i][j]);
									if(customMnrAgmtRtVOS != null){
										boolean result = false;
										for(int k=0; k < customMnrAgmtRtVOS.size(); k++){
											CustomMnrAgmtRtVO customMnrAgmtRtVO = customMnrAgmtRtVOS.get(k);
											BigDecimal agmtQty = new BigDecimal("0".equals(customMnrAgmtRtVO.getRprQty())?"1":customMnrAgmtRtVO.getRprQty());
											BigDecimal agmtAmt = new BigDecimal(customMnrAgmtRtVO.getAgmtRtAmt());
											BigDecimal invQty = new BigDecimal(customMnrOrdTmpDtlVOs[i][j].getRprQty());
											BigDecimal invAmt = new BigDecimal(customMnrOrdTmpDtlVOs[i][j].getCostAmt());
											
											if(Double.compare(invQty.multiply(agmtAmt).divide(agmtQty, 2).doubleValue(), invAmt.doubleValue()) == 0){
												result = true;
											}

										}
										if(!result){
											if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
												customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("AW"); 
												customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EAW");
											}else{
												customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";AW"); 
												customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EAW");
											}
										}
									}else{
										if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("AW"); 
											customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EAW");
										}else{
											customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";AW"); 
											customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EAW");
										}
									}
								}
							}
							
						}
					}
					
//					if("SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
//						String costCheck = dbDao.searchCostCdAgmtData(customMnrOrdTmpDtlVOs[i][j]);
//						if(!"OK".equals(costCheck)){
//							customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("CW"); 
//							customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("WCW");
//						}else{
//							String costType = dbDao.searchCostTypeData(customMnrOrdTmpDtlVOs[i][j]);
//							if(!"EST".equals(costType)){
//								CustomMnrAgmtRtVO customMnrAgmtRtVO = dbDao.searchAgmtAmountData(customMnrOrdTmpDtlVOs[i][j]);
//								if("0".equals(customMnrAgmtRtVO.getRprQty())){
//									if(!customMnrOrdTmpDtlVOs[i][j].getCostAmt().equals(customMnrAgmtRtVO.getAgmtRtAmt())){
//										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("AW"); 
//										customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("WAW");
//									}
//								}else{
//									BigDecimal agmtQty = new BigDecimal(customMnrAgmtRtVO.getRprQty());
//									BigDecimal agmtAmt = new BigDecimal(customMnrAgmtRtVO.getAgmtRtAmt());
//									BigDecimal invQty = new BigDecimal(customMnrOrdTmpDtlVOs[i][j].getRprQty());
//									BigDecimal invAmt = new BigDecimal(customMnrOrdTmpDtlVOs[i][j].getCostAmt());
//									
//									if(!invQty.multiply(agmtAmt).divide(agmtQty, 2).equals(invAmt)){
//										customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("AW"); 
//										customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("WAW");
//									}
//								}
//							}
//						}
//					}
					
					if(customMnrOrdTmpDtlVOs[i][j].getVvd().length() == 9){
						customMnrOrdTmpDtlVOs[i][j].setVslCd(customMnrOrdTmpDtlVOs[i][j].getVvd().substring(0, 4));
						customMnrOrdTmpDtlVOs[i][j].setSkdVoyNo(customMnrOrdTmpDtlVOs[i][j].getVvd().substring(4, 8));
						customMnrOrdTmpDtlVOs[i][j].setSkdDirCd(customMnrOrdTmpDtlVOs[i][j].getVvd().substring(8, 9));
					}
					
					BigDecimal costAmt = new BigDecimal(customMnrOrdTmpDtlVOs[i][j].getCostAmt());
					BigDecimal roundAmt = costAmt.setScale(dpCnt, RoundingMode.HALF_UP);
					
					if(Double.compare(costAmt.doubleValue(), roundAmt.doubleValue()) != 0){
						if(StringUtil.isEmpty(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc())){
							customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc("DW"); 
							customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EDW");
						}else{
							customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc()+";DW"); 
							customMnrOrdTmpDtlVOs[i][j].setMnrVrfyTpCd("EDW");
						}
					}
					
					invTotal = invTotal.add(roundAmt);
					
					String[] errCode = customMnrOrdTmpDtlVOs[i][j].getVrfyRsltDesc().split(";");
					String vrfyDesc = "";
					StringBuffer tmp = new StringBuffer();
					for(int k = 0; k < errCode.length; k++){
						tmp.append(dbDao.searchVerifyResultData(errCode[k]));
						tmp.append(";");
					}
					vrfyDesc = tmp.toString();
					vrfyDesc = vrfyDesc.substring(0, vrfyDesc.length()-1);
					customMnrOrdTmpDtlVOs[i][j].setVrfyRsltDesc(vrfyDesc);
					
					
//					invTot = invTot + Double.parseDouble(customMnrOrdTmpDtlVOs[i][j].getCostAmt());
					
					listCustomMnrOrdTmpDtl.add(customMnrOrdTmpDtlVOs[i][j]);
				}
				
				BigDecimal invAmt = new BigDecimal(customMnrOrdTmpHdrVOs[i].getInvAmt());
				BigDecimal vatAmt = new BigDecimal(customMnrOrdTmpHdrVOs[i].getVatAmt());
				BigDecimal whldAmt = new BigDecimal(customMnrOrdTmpHdrVOs[i].getInvWhldTaxAmt());
				
				BigDecimal calAmt = invAmt.subtract(vatAmt).add(whldAmt);
				BigDecimal roundAmt = calAmt.setScale(dpCnt, RoundingMode.HALF_UP);
				
				if(Double.compare(calAmt.doubleValue(), roundAmt.doubleValue()) != 0){
					if(StringUtil.isEmpty(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("DW"); // Invoice Amount Error
					}
					else{
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()+";DW"); // Invoice Amount Error
					}
				}
				
				if(Double.compare(roundAmt.doubleValue(), invTotal.doubleValue()) != 0){
					if(StringUtil.isEmpty(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()) || "SS".equals(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc())){
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc("UA"); // Invoice Amount Error
					}
					else{
						customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc()+";UA"); // Invoice Amount Error
					}
				}
				
				String[] errCode = customMnrOrdTmpHdrVOs[i].getVrfyRsltDesc().split(";");
				String vrfyDesc = "";
				StringBuffer tmp = new StringBuffer();
				for(int k = 0; k < errCode.length; k++){
					tmp.append(dbDao.searchVerifyResultData(errCode[k]));
					tmp.append(";");
				}
				vrfyDesc = tmp.toString();
				vrfyDesc = vrfyDesc.substring(0, vrfyDesc.length()-1);
				customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(vrfyDesc);
				
				listCustomMnrOrdTmpHdr.add(customMnrOrdTmpHdrVOs[i]);
			}
			
			interfaceGRPVO.setCustomMnrOrdTmpHdrVOs(listCustomMnrOrdTmpHdr);
			interfaceGRPVO.setCustomMnrOrdTmpDtlVOs(listCustomMnrOrdTmpDtl);
		} catch (StringIndexOutOfBoundsException de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Verifying SOL Invoice] verifySOLBasic"}).getMessage(),de);
		} catch (DAOException de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Verifying SOL Invoice] verifySOLBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Verifying SOL Invoice] verifySOLBasic"}).getMessage(),de);
		}
		return interfaceGRPVO;
	}
	
	/**
	 * Handling New Port Invoice
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO manageSOLInvoiceDataBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException {
		GeneralCodeSearchMgtBC command1 = new GeneralCodeSearchMgtBCImpl();
		
		try{
			CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = interfaceGRPVO.getArrayCustomMnrOrdTmpHdrVOs();
			CustomMnrOrdTmpDtlVO[][] customMnrOrdTmpDtlVOs = interfaceGRPVO.getArrayCustomMnrOrdTmpDtlVOs();
			
			CustomMnrOrdHdrVO[][] customMnrOrdHdrVOs = new CustomMnrOrdHdrVO[customMnrOrdTmpHdrVOs.length][];
			CustomMnrOrdDtlVO[][] customMnrOrdDtlVOs = new CustomMnrOrdDtlVO[customMnrOrdTmpHdrVOs.length][];

			List<CustomMnrOrdHdrVO> insertMnrOrdHdrVOs = new ArrayList<CustomMnrOrdHdrVO>();
			List<CustomMnrOrdDtlVO> insertMnrOrdDtlVOs = new ArrayList<CustomMnrOrdDtlVO>();

//			SimpleDateFormat orgFormat = new SimpleDateFormat("MM/dd/yy");
//			SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
//			
//			Date orgDate = new Date();
			String newDate = "";
			
			for(int i=0; i<customMnrOrdTmpHdrVOs.length; i++){
				customMnrOrdHdrVOs[i] = new CustomMnrOrdHdrVO[customMnrOrdTmpDtlVOs[i].length];
				customMnrOrdDtlVOs[i] = new CustomMnrOrdDtlVO[customMnrOrdTmpDtlVOs[i].length];
				for(int j=0; j<customMnrOrdTmpDtlVOs[i].length; j++){
					customMnrOrdHdrVOs[i][j] = new CustomMnrOrdHdrVO();
					customMnrOrdDtlVOs[i][j] = new CustomMnrOrdDtlVO();

					 // SUBSTR(HEADER.OFC_CD, 1, 3)
						
					String sMnrOrdSeq = dbDao.searchMnrOrdSeqData();
//					String costOfcCd = dbDao.searchFinancialOfficeData(customMnrOrdTmpDtlVOs[i][j].getYdCd().substring(0, 5));
					customMnrOrdHdrVOs[i][j].setMnrOrdOfcCtyCd(customMnrOrdTmpHdrVOs[i].getCostOfcCd().substring(0, 3));
					customMnrOrdHdrVOs[i][j].setMnrOrdSeq(sMnrOrdSeq);
						
//					orgDate = orgFormat.parse(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());
//					newDate = newFormat.format(orgDate);
					newDate = customMnrOrdTmpDtlVOs[i][j].getRprRsltDt();
						
					// HEADER
					customMnrOrdHdrVOs[i][j].setEqKndCd(customMnrOrdTmpDtlVOs[i][j].getEqKndCd());			// DETAIL.EQ_NBR
					customMnrOrdHdrVOs[i][j].setCostCd(customMnrOrdTmpDtlVOs[i][j].getCostCd());			// DETAIL.TARIFF_CD (Need to convert code eg. "MRDRRC"
					customMnrOrdHdrVOs[i][j].setVndrSeq(customMnrOrdTmpHdrVOs[i].getVndrSeq()); 		// HEADER.VND_CD
					customMnrOrdHdrVOs[i][j].setCurrCd(customMnrOrdTmpHdrVOs[i].getCurrCd());			// HEADER.CUR_CD
					customMnrOrdHdrVOs[i][j].setCostOfcCd(customMnrOrdTmpHdrVOs[i].getCostOfcCd()); 	// HEADER.OFC_CD
					customMnrOrdHdrVOs[i][j].setMnrAgmtAmt(customMnrOrdTmpDtlVOs[i][j].getCostAmt());		// DETAIL.COST
					customMnrOrdHdrVOs[i][j].setMnrWrkAmt(customMnrOrdTmpDtlVOs[i][j].getCostAmt());		// DETAIL.COST
					customMnrOrdHdrVOs[i][j].setInvAmt(customMnrOrdTmpDtlVOs[i][j].getCostAmt());			// DETAIL.COST
					customMnrOrdHdrVOs[i][j].setOrdIssOfcCd(customMnrOrdTmpHdrVOs[i].getCostOfcCd()); 	// HEADER.OFC_CD
					customMnrOrdHdrVOs[i][j].setMnrOrdSndDt(newDate); 	// DETAIL.EVENT_DT
					customMnrOrdHdrVOs[i][j].setMnrInpDt(newDate);  	// DETAIL.EVENT_DT
					if("MRRUSP".equals(customMnrOrdHdrVOs[i][j].getCostCd())){
						customMnrOrdHdrVOs[i][j].setSprPrtSplDt(newDate);
					}else{
						customMnrOrdHdrVOs[i][j].setSprPrtSplDt("");
					}
					
					String agmtNo = dbDao.searchAgreementExistData(customMnrOrdTmpDtlVOs[i][j]);
					if(!"".equals(agmtNo)){
						customMnrOrdHdrVOs[i][j].setAgmtOfcCtyCd(agmtNo.substring(0, 3));
						customMnrOrdHdrVOs[i][j].setAgmtSeq(agmtNo.substring(3));
					}
					
					customMnrOrdHdrVOs[i][j].setCreUsrId(account.getUsr_id());
					customMnrOrdHdrVOs[i][j].setUpdUsrId(account.getUsr_id());
					customMnrOrdDtlVOs[i][j].setCreUsrId(account.getUsr_id());
					customMnrOrdDtlVOs[i][j].setUpdUsrId(account.getUsr_id());
						
					// REAL DETAIL DATA=====================
					customMnrOrdDtlVOs[i][j].setMnrOrdOfcCtyCd(customMnrOrdHdrVOs[i][j].getMnrOrdOfcCtyCd());
					customMnrOrdDtlVOs[i][j].setMnrOrdSeq(sMnrOrdSeq);
					customMnrOrdDtlVOs[i][j].setOrdDtlSeq("1");
					
					customMnrOrdTmpDtlVOs[i][j].setMnrOrdOfcCtyCd(customMnrOrdHdrVOs[i][j].getMnrOrdOfcCtyCd());
					customMnrOrdTmpDtlVOs[i][j].setMnrOrdSeq(sMnrOrdSeq);
					customMnrOrdTmpDtlVOs[i][j].setOrdDtlSeq("1");
					
					customMnrOrdDtlVOs[i][j].setCostCd(customMnrOrdTmpDtlVOs[i][j].getCostCd());			// DETAIL.TARIFF_CD (Need to convert code eg. "MRDRRC"
					customMnrOrdDtlVOs[i][j].setAcctCd("");

					customMnrOrdDtlVOs[i][j].setCostDtlCd(customMnrOrdTmpDtlVOs[i][j].getCostDtlCd());
					customMnrOrdDtlVOs[i][j].setRprOffhFlg("N");
					customMnrOrdDtlVOs[i][j].setMnrRtTpCd(customMnrOrdTmpDtlVOs[i][j].getCostDtlCd());
						
					customMnrOrdDtlVOs[i][j].setEqNo(customMnrOrdTmpDtlVOs[i][j].getEqNo());
					customMnrOrdDtlVOs[i][j].setEqTpszCd(customMnrOrdTmpDtlVOs[i][j].getEqTpszCd());
					customMnrOrdDtlVOs[i][j].setEqKndCd(customMnrOrdTmpDtlVOs[i][j].getEqKndCd());
					customMnrOrdDtlVOs[i][j].setRqstRefNo(customMnrOrdTmpDtlVOs[i][j].getRqstRefNo());
					customMnrOrdDtlVOs[i][j].setYdCd(customMnrOrdTmpDtlVOs[i][j].getYdCd());
					customMnrOrdDtlVOs[i][j].setRprRsltDt(newDate);
					customMnrOrdDtlVOs[i][j].setRprQty(customMnrOrdTmpDtlVOs[i][j].getRprQty());
					customMnrOrdDtlVOs[i][j].setMnrInpTpCd("S");
					customMnrOrdDtlVOs[i][j].setMnrVrfyTpCd(customMnrOrdTmpDtlVOs[i][j].getMnrVrfyTpCd().substring(1));

					customMnrOrdDtlVOs[i][j].setSprPrtUcAmt("0");
					customMnrOrdDtlVOs[i][j].setBzcAmt("0");
					customMnrOrdDtlVOs[i][j].setCostAmt(customMnrOrdTmpDtlVOs[i][j].getCostAmt());
					customMnrOrdDtlVOs[i][j].setN3ptyFlg("N");
					customMnrOrdDtlVOs[i][j].setInvAmt(customMnrOrdTmpDtlVOs[i][j].getCostAmt());
					customMnrOrdDtlVOs[i][j].setInvNo(customMnrOrdTmpHdrVOs[i].getInvNo());
					customMnrOrdDtlVOs[i][j].setPayInvSeq(""); //MNR_PAY_INV_WRK.PAY_INV_SEQ
					
					
					
					BkgTrdCodeVO bkgTrdCodeVO = new BkgTrdCodeVO();
					bkgTrdCodeVO.setEqType(customMnrOrdDtlVOs[i][j].getEqKndCd());
					bkgTrdCodeVO.setCostCd(customMnrOrdDtlVOs[i][j].getCostCd());
					bkgTrdCodeVO.setCostDtlCd(customMnrOrdDtlVOs[i][j].getCostDtlCd());
					bkgTrdCodeVO.setEqNo(customMnrOrdDtlVOs[i][j].getEqNo());
					bkgTrdCodeVO.setRprRsltDt(newDate);
						
					List<BkgTrdCodeVO> bkgTrdCd = command1.searchBkgTrdCdBasic(bkgTrdCodeVO);
					if(bkgTrdCd != null && bkgTrdCd.size() > 0){
						customMnrOrdDtlVOs[i][j].setBkgNo(bkgTrdCd.get(0).getBkgNo());
						customMnrOrdDtlVOs[i][j].setTrdCd(bkgTrdCd.get(0).getTrdCd());
						
						String revVVdCd = dbDao.searchRevenueVvdData(customMnrOrdDtlVOs[i][j].getBkgNo());
						
//						if(!"CFDR".equals(revVVdCd.substring(0, 4))){
							customMnrOrdDtlVOs[i][j].setVslCd(revVVdCd.substring(0, 4));
							customMnrOrdDtlVOs[i][j].setSkdVoyNo(revVVdCd.substring(4, 8));
							customMnrOrdDtlVOs[i][j].setSkdDirCd(revVVdCd.substring(8, 9));
							customMnrOrdDtlVOs[i][j].setRevDirCd(revVVdCd.substring(9, 10));
							customMnrOrdDtlVOs[i][j].setSlanCd(revVVdCd.substring(10));
//						}
					}
					
					customMnrOrdHdrVOs[i][j].setVslCd(customMnrOrdTmpDtlVOs[i][j].getVslCd());
					customMnrOrdHdrVOs[i][j].setSkdVoyNo(customMnrOrdTmpDtlVOs[i][j].getSkdVoyNo());
					customMnrOrdHdrVOs[i][j].setSkdDirCd(customMnrOrdTmpDtlVOs[i][j].getSkdDirCd());//SOL 화면에서 받는 VVD 저장(Reference data)
					
					customMnrOrdTmpDtlVOs[i][j].setRprRsltDt(newDate);
					customMnrOrdTmpDtlVOs[i][j].setInvAmt(customMnrOrdTmpDtlVOs[i][j].getCostAmt());
					
					
					
					insertMnrOrdHdrVOs.add(customMnrOrdHdrVOs[i][j]);
					insertMnrOrdDtlVOs.add(customMnrOrdDtlVOs[i][j]);
					
				}
//				Date orgRcvDt = new Date();
//				Date orgInvCfmDt = new Date();
				String newRcvDt = "";
				String newInvCfmDt = "";
				
//				orgRcvDt = orgFormat.parse(customMnrOrdTmpHdrVOs[i].getRcvDt());
//				orgInvCfmDt = orgFormat.parse(customMnrOrdTmpHdrVOs[i].getInvCfmDt());
//				newRcvDt = newFormat.format(orgRcvDt);
//				newInvCfmDt = newFormat.format(orgInvCfmDt);
				newRcvDt = customMnrOrdTmpHdrVOs[i].getRcvDt();
				newInvCfmDt = customMnrOrdTmpHdrVOs[i].getInvCfmDt();
				
				customMnrOrdTmpHdrVOs[i].setRcvDt(newRcvDt);
				customMnrOrdTmpHdrVOs[i].setInvCfmDt(newInvCfmDt);
				
			}
			
			interfaceGRPVO.setListMnrOrdHdrVOs(insertMnrOrdHdrVOs);
			interfaceGRPVO.setListMnrOrdDtlVOs(insertMnrOrdDtlVOs);
			interfaceGRPVO.setArrayCustomMnrOrdTmpHdrVOs(customMnrOrdTmpHdrVOs);
			interfaceGRPVO.setArrayCustomMnrOrdTmpDtlVOs(customMnrOrdTmpDtlVOs);
			
			manageWOInvoiceDataBasic(interfaceGRPVO, account);
			
		} catch (StringIndexOutOfBoundsException de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Manage Invoice Data] manageSOLInvoiceDataBasic"}).getMessage(),de);
		} catch (DAOException de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Manage Invoice Data] manageSOLInvoiceDataBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return interfaceGRPVO;
	}

	/**
	 * Handling Invoice
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	@Override
	public InterfaceGRPVO manageWOInvoiceDataBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException {
		ExpenseMgtBC command = new ExpenseMgtBCImpl();
		EQFlagMgtBC command3 = new EQFlagMgtBCImpl(); 
		RepairMgtBC command4 = new RepairMgtBCImpl();

		try{
			List<CustomMnrOrdHdrVO> insertMnrOrdHdrVOs = interfaceGRPVO.getListMnrOrdHdrVOs();
			List<CustomMnrOrdDtlVO> insertMnrOrdDtlVOs = interfaceGRPVO.getListMnrOrdDtlVOs();
			List<CustomMnrOrdTmpDtlVO> insertMnrOrdTmpDtlVOs = interfaceGRPVO.getListMnrOrdTmpDtlVOs();
			CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = interfaceGRPVO.getArrayCustomMnrOrdTmpHdrVOs();
			CustomMnrOrdTmpDtlVO[][] customMnrOrdTmpDtlVOs = interfaceGRPVO.getArrayCustomMnrOrdTmpDtlVOs();
			PayableInvoiceGRPVO payableInvoiceGRPVO2 = new PayableInvoiceGRPVO();
			GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO(); 
			eQFlagListGRPVO.setEQFlagListINVO(new EQFlagListINVO());
			
			List<CustomMnrOrdTmpHdrVO> listCustomMnrOrdTmpHdr = new ArrayList<CustomMnrOrdTmpHdrVO>();
			List<CustomMnrOrdTmpDtlVO> listCustomMnrOrdTmpDtl = new ArrayList<CustomMnrOrdTmpDtlVO>();
			
			String sVndrSeq = "";
			boolean bSusses = false;
			
			if(insertMnrOrdHdrVOs != null && insertMnrOrdHdrVOs.size() > 0){
				dbDao.addNewPortWOCreationHeaderData(insertMnrOrdHdrVOs);  		// MNR_ORD_HDR
				dbDao.addNewPortWOCreationDetailData(insertMnrOrdDtlVOs);  		// MNR_ORD_DTL
				if(insertMnrOrdTmpDtlVOs != null){
					dbDao.modifyNewPortWOCreationDetailData(insertMnrOrdTmpDtlVOs); // MNR_ORD_TMP_DTL UPDATE
				}
					
				PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
				CustomMnrPayInvWrkVO customMnrPayInvWrkVO = null;
	
				for(int i = 0 ; i < customMnrOrdTmpHdrVOs.length ; i++){
					sVndrSeq = dbDao.searchMnrOrdTmpVndrSeqData(customMnrOrdTmpHdrVOs[i].getVndrSeq());
					bSusses = true;
					customMnrPayInvWrkVO = new CustomMnrPayInvWrkVO();
					customMnrPayInvWrkVO.setInvNo(customMnrOrdTmpHdrVOs[i].getInvNo());
					customMnrPayInvWrkVO.setMnrGrpTpCd("RPR");
					customMnrPayInvWrkVO.setMnrInvStsCd("HC");
					customMnrPayInvWrkVO.setGenPayTermCd(dbDao.searchMnrOrdTmpGenPayTermCdData(sVndrSeq));
					customMnrPayInvWrkVO.setOrdVndrSeq(sVndrSeq);
					customMnrPayInvWrkVO.setMnrPrnrSeq(sVndrSeq);
					customMnrPayInvWrkVO.setCurrCd(customMnrOrdTmpHdrVOs[i].getCurrCd());
					customMnrPayInvWrkVO.setBzcAmt(String.format("%.2f", Double.parseDouble(customMnrOrdTmpHdrVOs[i].getInvAmt())-Double.parseDouble(customMnrOrdTmpHdrVOs[i].getVatAmt())+Double.parseDouble(customMnrOrdTmpHdrVOs[i].getInvWhldTaxAmt())));
					customMnrPayInvWrkVO.setVatAmt(customMnrOrdTmpHdrVOs[i].getVatAmt());
					customMnrPayInvWrkVO.setWhldTaxAmt(customMnrOrdTmpHdrVOs[i].getInvWhldTaxAmt());
					customMnrPayInvWrkVO.setTtlAmt(customMnrOrdTmpHdrVOs[i].getInvAmt());
					customMnrPayInvWrkVO.setMnrInvRjctFlg("N");
					customMnrPayInvWrkVO.setIssDt(customMnrOrdTmpHdrVOs[i].getInvCfmDt());
					customMnrPayInvWrkVO.setIssOfcCd(customMnrOrdTmpHdrVOs[i].getCostOfcCd());
					customMnrPayInvWrkVO.setRcvDt(customMnrOrdTmpHdrVOs[i].getRcvDt());
					customMnrPayInvWrkVO.setEffDt(customMnrOrdTmpHdrVOs[i].getRcvDt());
						
					customMnrPayInvWrkVO.setHldFlg("N");
					customMnrPayInvWrkVO.setPayInvSeq("");
					customMnrPayInvWrkVO.setMnrInpTpCd(insertMnrOrdDtlVOs.get(i).getMnrInpTpCd());
					payableInvoiceGRPVO.setCustomMnrPayInvWrkVO(customMnrPayInvWrkVO);
						
					if(account == null || "".equals(account.getUsr_id())){
						account = new SignOnUserAccount("NEWPORT",null,null,null,null,null,null,null, "NEWPORT", customMnrOrdTmpHdrVOs[i].getCreDt() , "NEWPORT", customMnrOrdTmpHdrVOs[i].getCreDt(), customMnrOrdTmpHdrVOs[i].getCostOfcCd(), null, null, null, null, null, null, null, null, null);
						account.setAccess_system("SPP");
					}else{
						account.setAccess_system("SPP");
					}
							
					CustomPayableInvoiceDetailINVO[] arrayCustomPayableInvoiceDetailINVOs = new CustomPayableInvoiceDetailINVO[customMnrOrdTmpDtlVOs[i].length];
					CustomPayableInvoiceDetailINVO customPayableInvoiceDetailINVO = null;
					List<CustomPayableInvoiceDetailINVO> sucessList = new ArrayList<CustomPayableInvoiceDetailINVO>();
							
					for(int j = 0 ; j < customMnrOrdTmpDtlVOs[i].length ; j++){
						String costType = dbDao.searchCostTypeData(customMnrOrdTmpDtlVOs[i][j]);
						arrayCustomPayableInvoiceDetailINVOs[j] = new CustomPayableInvoiceDetailINVO();
						customPayableInvoiceDetailINVO = new CustomPayableInvoiceDetailINVO();
						customPayableInvoiceDetailINVO.setMnrOrdOfcCtyCd(customMnrOrdTmpDtlVOs[i][j].getMnrOrdOfcCtyCd());
						customPayableInvoiceDetailINVO.setMnrOrdSeq(customMnrOrdTmpDtlVOs[i][j].getMnrOrdSeq());
						customPayableInvoiceDetailINVO.setOrdDtlSeq(customMnrOrdTmpDtlVOs[i][j].getOrdDtlSeq());
						customPayableInvoiceDetailINVO.setMnrWoTpCd(costType);
						customPayableInvoiceDetailINVO.setEqNo(customMnrOrdTmpDtlVOs[i][j].getEqNo());
						customPayableInvoiceDetailINVO.setEqKndCd(customMnrOrdTmpDtlVOs[i][j].getEqKndCd());
						customPayableInvoiceDetailINVO.setEqTpszCd(customMnrOrdTmpDtlVOs[i][j].getEqTpszCd());
						customPayableInvoiceDetailINVO.setRprRsltDt(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());
						customPayableInvoiceDetailINVO.setYdCd(customMnrOrdTmpDtlVOs[i][j].getYdCd());
						customPayableInvoiceDetailINVO.setCostAmt(customMnrOrdTmpDtlVOs[i][j].getCostAmt());
						arrayCustomPayableInvoiceDetailINVOs[j] = customPayableInvoiceDetailINVO;
						sucessList.add(arrayCustomPayableInvoiceDetailINVOs[j]);
					}
							
					if(sucessList.size() > 0){
						payableInvoiceGRPVO.setArrayCustomPayableInvoiceDetailINVOs((CustomPayableInvoiceDetailINVO[]) sucessList.toArray(new CustomPayableInvoiceDetailINVO[sucessList.size()]));
						//MNR_PAY_INV_WRK add, modify
						payableInvoiceGRPVO2 = command.manageRepairPayableInvoiceBasic(payableInvoiceGRPVO, account);
					}else{
						bSusses = false;
					}
				
					if(bSusses){
						//MNR_ORD_DTL invoice data modify
						CustomMnrOrdDtlVO[] arrCustomMnrOrdDtlVO = new CustomMnrOrdDtlVO[customMnrOrdTmpDtlVOs[i].length];
						CustomMnrOrdDtlVO tempCustomMnrOrdDtlVO = null;
						List<CustomMnrOrdDtlVO> sucessList2 = new ArrayList<CustomMnrOrdDtlVO>();
							
						for(int j = 0 ; j < customMnrOrdTmpDtlVOs[i].length ; j++){
							tempCustomMnrOrdDtlVO = new CustomMnrOrdDtlVO();
							arrCustomMnrOrdDtlVO[j]  = new CustomMnrOrdDtlVO();
		
							tempCustomMnrOrdDtlVO.setPayInvSeq(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq());
							tempCustomMnrOrdDtlVO.setInvNo(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getInvNo());
							tempCustomMnrOrdDtlVO.setInvAmt(customMnrOrdTmpDtlVOs[i][j].getInvAmt());
							tempCustomMnrOrdDtlVO.setRprRsltDt(customMnrOrdTmpDtlVOs[i][j].getRprRsltDt());
							tempCustomMnrOrdDtlVO.setMnrOrdOfcCtyCd(customMnrOrdTmpDtlVOs[i][j].getMnrOrdOfcCtyCd());
							tempCustomMnrOrdDtlVO.setMnrOrdSeq(customMnrOrdTmpDtlVOs[i][j].getMnrOrdSeq());
							tempCustomMnrOrdDtlVO.setOrdDtlSeq(customMnrOrdTmpDtlVOs[i][j].getOrdDtlSeq());
							tempCustomMnrOrdDtlVO.setSlsTaxAmt(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getSlsTaxAmt());  
							tempCustomMnrOrdDtlVO.setCreUsrId(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getCreUsrId());
									
						    arrCustomMnrOrdDtlVO[j] = tempCustomMnrOrdDtlVO;    
						    sucessList2.add(arrCustomMnrOrdDtlVO[j]);
									
						}	     
						generalWOGRPVO.setArrCustomMnrOrdDtlVOS((CustomMnrOrdDtlVO[]) sucessList2.toArray(new CustomMnrOrdDtlVO[sucessList2.size()]));
						//setting "Invoice Status" to deliver
						generalWOGRPVO.setMnrInvStsCd(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInvStsCd());
								
						command4.modifyWEBInvoiceLinkBasic(generalWOGRPVO,account);
								
						// PAY_INV_SEQ UPDATE=========================================================================
						List<CustomMnrOrdDtlVO> insertVoList = new ArrayList<CustomMnrOrdDtlVO>();
								
						if(generalWOGRPVO.getArrCustomMnrOrdDtlVOS() != null){
							CustomMnrOrdDtlVO[] arrCustomMnrOrdDtlVOs = generalWOGRPVO.getArrCustomMnrOrdDtlVOS();
							for ( int k = 0; k < arrCustomMnrOrdDtlVOs.length; k++ ) {
								arrCustomMnrOrdDtlVOs[k].setCreUsrId(account.getUsr_id());
								insertVoList.add(arrCustomMnrOrdDtlVOs[k]);
							}
							dbDao2.modifyWEBInvoiceLinkData(insertVoList);
						}
						//=============================================================================================
								
						String req_no = ""; 
						//handling CSR
						req_no = createCSRIFBasic(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getMnrGrpTpCd(), payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq(), account);
						//modify MNR_ORD_DTL req_no
						command.modifyTotalLossPayableInvoiceBasic(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq(),req_no, account);
						
						CustomPayableInvoiceDetailINVO[] arrCustomPayableInvoiceDetailINVO = payableInvoiceGRPVO.getArrayCustomPayableInvoiceDetailINVOs();
						
							
						for ( int k = 0; k< arrCustomPayableInvoiceDetailINVO.length; k++ ) {  
							if(arrCustomPayableInvoiceDetailINVO[k].getMnrWoTpCd().equals("EST")){
								if(arrCustomPayableInvoiceDetailINVO[k].getCostAmt().indexOf("-") == -1){
									if(dbDao.searchMvmtCntSameDayData(arrCustomPayableInvoiceDetailINVO[k].getEqNo(), arrCustomPayableInvoiceDetailINVO[k].getRprRsltDt()) <= 1){
										List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
										List<CustomMnrEqStsVO> listCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
										List<CustomMnrFlgHisVO> listCustomMnrFlgHisVOS = new ArrayList<CustomMnrFlgHisVO>();
										
										boolean isDupEqNo = false;	
										for (int j = 0; j < listCustomMnrEqStsVOS.size(); j++) {
											if(listCustomMnrEqStsVOS.get(j).getEqNo().equalsIgnoreCase(arrCustomPayableInvoiceDetailINVO[k].getEqNo())){
												isDupEqNo = true;
											}
										}
										
										if(!isDupEqNo){	
											CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
											customMnrEqStsVO.setEqNo(arrCustomPayableInvoiceDetailINVO[k].getEqNo());
											customMnrEqStsVO.setMnrDmgFlg("0");
											customMnrEqStsVO.setMnrStsRmk("By SOL Repair Invoice");
											customMnrEqStsVO.setEqTpszCd(arrCustomPayableInvoiceDetailINVO[k].getEqTpszCd());
											customMnrEqStsVO.setEqKndCd(arrCustomPayableInvoiceDetailINVO[k].getEqKndCd());
											customMnrEqStsVO.setMnrDmgFlgYdCd(arrCustomPayableInvoiceDetailINVO[k].getYdCd());
	//										String eventTime = dbDao.searchMvmtTimeData(arrCustomPayableInvoiceDetailINVO[k].getEqNo(), arrCustomPayableInvoiceDetailINVO[k].getRprRsltDt(), arrCustomPayableInvoiceDetailINVO[k].getYdCd(), "MT");
	//										if("".equals(eventTime)){
	//											eventTime = dbDao.searchMvmtTimeData(arrCustomPayableInvoiceDetailINVO[k].getEqNo(), arrCustomPayableInvoiceDetailINVO[k].getRprRsltDt(), arrCustomPayableInvoiceDetailINVO[k].getYdCd(), "");
	//											if("".equals(eventTime)){
	//												eventTime = "2359";
	//											}
	//										}
											
											customMnrEqStsVO.setMnrDmgFlgDt(arrCustomPayableInvoiceDetailINVO[k].getRprRsltDt()+"2359");
											listCustomMnrEqStsVOS.add(customMnrEqStsVO);
											
											IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
											iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
											iFMnrFlagVO.setFlagUserId(account.getUsr_id());
											iFMnrFlagVO.setFlagType("DMG");
											iFMnrFlagVO.setRetireFlag("N");
											iFMnrFlagVO.setEqKindCd(arrCustomPayableInvoiceDetailINVO[k].getEqKndCd());
											iFMnrFlagVO.setEqNo(arrCustomPayableInvoiceDetailINVO[k].getEqNo());
											iFMnrFlagVO.setStsFlag("N");
											iFMnrFlagVO.setFlagDt(arrCustomPayableInvoiceDetailINVO[k].getRprRsltDt()+"2359");
											iFMnrFlagVO.setFlagYdCd(arrCustomPayableInvoiceDetailINVO[k].getYdCd());
											iFMnrFlagVOS.add(iFMnrFlagVO);
	
											CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
											customMnrFlgHisVO.setMnrFlgTpCd("DMG"); 
											customMnrFlgHisVO.setMnrStsFlg("0");
											customMnrFlgHisVO.setMnrFlgInpTpCd("I");   
											customMnrFlgHisVO.setEqNo(arrCustomPayableInvoiceDetailINVO[k].getEqNo());
											customMnrFlgHisVO.setEqTpszCd(arrCustomPayableInvoiceDetailINVO[k].getEqTpszCd());
											customMnrFlgHisVO.setMnrFlgYdCd(arrCustomPayableInvoiceDetailINVO[k].getYdCd());
											customMnrFlgHisVO.setEqKndCd(arrCustomPayableInvoiceDetailINVO[k].getEqKndCd());
											listCustomMnrFlgHisVOS.add(customMnrFlgHisVO);
										}
										
										if(iFMnrFlagVOS.size() > 0){	
											interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);	
											eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("DMG");
											
											CustomMnrEqStsVO[] customMnrEqStsVOS = new CustomMnrEqStsVO[listCustomMnrEqStsVOS.size()];		
											CustomMnrFlgHisVO[] customMnrFlgHisVOS = new CustomMnrFlgHisVO[listCustomMnrFlgHisVOS.size()];	
											
											for (int j = 0; j < listCustomMnrEqStsVOS.size(); j++) {
												customMnrEqStsVOS[j] = listCustomMnrEqStsVOS.get(j);	
											}
											for (int j = 0; j < listCustomMnrFlgHisVOS.size(); j++) {
												customMnrFlgHisVOS[j] = listCustomMnrFlgHisVOS.get(j);	
											}
											
											eQFlagListGRPVO.setArrCustomMnrEqStsVOS(customMnrEqStsVOS);
											eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(customMnrFlgHisVOS);
											
											if("U".equals(arrCustomPayableInvoiceDetailINVO[k].getEqKndCd())){
												command3.manageEQFlagListBasic(eQFlagListGRPVO,account);
												this.manageIFFlagBasic(interfaceGRPVO,account);
												String [] rtn = this.manageCtmIfFlagBasic(interfaceGRPVO, account);
												if(!"".equals(rtn[0])){
													customMnrOrdTmpHdrVOs[i].setVrfyRsltDesc(dbDao.searchVerifyResultData("IW"));
													customMnrOrdTmpDtlVOs[i][k].setVrfyRsltDesc(dbDao.searchVerifyResultData("IW"));
													arrCustomPayableInvoiceDetailINVO[k].setUpdUsrId(account.getUsr_id());
													dbDao.modifyMnrWOVrfyCdData(arrCustomPayableInvoiceDetailINVO[k]);
												}
											}else{
												command3.manageEQFlagListBasic(eQFlagListGRPVO,account);
												this.manageIFFlagBasic(interfaceGRPVO,account);
											}
										}
									}
								}
							}
							listCustomMnrOrdTmpDtl.add(customMnrOrdTmpDtlVOs[i][k]);
						}  

					}
					listCustomMnrOrdTmpHdr.add(customMnrOrdTmpHdrVOs[i]);
				}
				
				
			}
			if(!"NEWPORT".equals(account.getUsr_id())){
				account.setAccess_system("ALP");
			}
			interfaceGRPVO.setCustomMnrOrdTmpHdrVOs(listCustomMnrOrdTmpHdr);
			interfaceGRPVO.setCustomMnrOrdTmpDtlVOs(listCustomMnrOrdTmpDtl);
		} catch (StringIndexOutOfBoundsException de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling MNR Invoice] manageWOInvoiceDataBasic"}).getMessage(),de);
		} catch (DAOException de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[handling MNR Invoice] manageWOInvoiceDataBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return interfaceGRPVO;
	}
	
	/**
	 *  New Port EDI BackEndJob<br>
	 *
	 * @param interfaceGRPVO InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String newPortEdiBackEndJobBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account){
		InterfaceMgtNewPortInvoiceEDIBackEndJob backEndResult = new InterfaceMgtNewPortInvoiceEDIBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setInterfaceGRPVO(interfaceGRPVO);
		backEndResult.setSignOnAccount(account);
		return backEndJobManager.execute(backEndResult,"NEWPORT", "New Port EDI Back End Job");
	}
	
	/**
	 * only Damage Flagging external Interface Method <br>
	 * modifying CTM
	 * @param InterfaceGRPVO   interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return String[]
	 * @exception EventException
	 */
	public String[] manageCtmIfFlagBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException{
		String[] rtn = new String[2];
		List<IFMnrFlagVO> iFMnrFlagVOS = interfaceGRPVO.getIFMnrFlagVOS();
		CusCtmMovementVO[] cusCtmMovementVOs = new CusCtmMovementVO[1];
		ContainerMovementMgtBC command3 = new ContainerMovementMgtBCImpl();
		StringBuffer tmp1 = new StringBuffer();
		StringBuffer tmp2 = new StringBuffer();
		String err1 = "";
		String err2 = "";
		String cntr1 = "";
		String cntr2 = "";
		
		try {
			for ( int i = 0; i < iFMnrFlagVOS.size(); i++ ) {
				if("U".equals(iFMnrFlagVOS.get(i).getEqKindCd())){
					CusCtmMovementVO cusCtmMovementVO = new CusCtmMovementVO();
					cusCtmMovementVO.setCntrNo(iFMnrFlagVOS.get(i).getEqNo());
					if("Y".equals(iFMnrFlagVOS.get(i).getStsFlag())){
						cusCtmMovementVO.setDmgFlgDt(iFMnrFlagVOS.get(i).getFlagDt());
					}else{
						cusCtmMovementVO.setDmgUnflgDt(iFMnrFlagVOS.get(i).getFlagDt());
					}
					cusCtmMovementVO.setOrgYdCd(iFMnrFlagVOS.get(i).getFlagYdCd());
					cusCtmMovementVO.setCnmvRmk(iFMnrFlagVOS.get(i).getRmk());
					cusCtmMovementVO.setCntrDmgFlg(iFMnrFlagVOS.get(i).getStsFlag());
							
					cusCtmMovementVOs[0] = cusCtmMovementVO;
					CrossItemVO crossItemVO = command3.modifyCNTRStatus(cusCtmMovementVOs, account);
					
					String[] rtnStrs = null;
					rtnStrs = crossItemVO.getRtnStr();
					CrossItemVO mnrItem = new CrossItemVO();

//					try {
						if (rtnStrs[0] != null && "X".equals(rtnStrs[0])) {
							mnrItem = command3.modifyDMGHistory(crossItemVO, account);
							rtnStrs = mnrItem.getRtnStr();
						}
//					} catch (Exception ex) {
//						rtnStrs[0] = "N";
//						rtnStrs[1] = ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
//						log.error(ex.getMessage(),ex);
//					}

					if("N".equals(crossItemVO.getRtnStr()[0])){
						if(crossItemVO.getRtnStr()[1].indexOf("Container") > -1){
							tmp1.append(iFMnrFlagVOS.get(i).getEqNo());
							tmp1.append(",");
//							err1 = crossItemVO.getRtnStr()[1];
						}else{
							tmp2.append(iFMnrFlagVOS.get(i).getEqNo());
							tmp2.append(",");
							err2 = crossItemVO.getRtnStr()[1];
						}
					}
				}
			}

			cntr1 = tmp1.toString();
			cntr1 = cntr1.length() > 0 ? cntr1.substring(0, cntr1.length()-1) : cntr1;
			cntr2 = tmp2.toString();
			cntr2 = cntr2.length() > 0 ? cntr2.substring(0, cntr2.length()-1) : cntr2;
			
			if(cntr1.length() > 0){
				err1 = "["+cntr1+"] Container does not exist in the yard on flag date.";
			}
			if(cntr2.length() > 0){
				err2 = "["+cntr2+"]"+ err2;
			}
			rtn[0] = err1;
			rtn[1] = err2;

		} catch (EventException e){
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR Damage Flagging] manageCtmIfFlagBasic"}).getMessage(),de);
		}
		return rtn;
	}
	
	/**
	 * Search Agreement Rate <br>
	 * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	 * @return List<CustomMnrAgmtRtVO>
	 * @exception EventException
	 */
	public List<CustomMnrAgmtRtVO> searchAgmtRateBasic(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws EventException{
		List<CustomMnrAgmtRtVO> result = null;
		String type = "";
		try{
			List<CustomMnrAgmtRtVO> list = dbDao.searchCostYardCodeData(customMnrOrdTmpDtlVO);
			if(list.size() > 0){
				for(int i = 0; i<list.size(); i++){
					if("ALL".equals(list.get(i).getYdCd())){
						type = "A";
					}
				}
				
				if("Y".equals(customMnrOrdTmpDtlVO.getQtyFlg()) && customMnrOrdTmpDtlVO.getYdCd().length() == 5){
					for(int i = 0; i<list.size(); i++){
						if(customMnrOrdTmpDtlVO.getYdCd().equals(list.get(i).getYdCd())){
							type = "L";
						}
					}
					if(!"L".equals(type)){
						for(int i = 0; i<list.size(); i++){
							if(customMnrOrdTmpDtlVO.getYdCd().equals(list.get(i).getYdCd().substring(0, 5))){
								type = "QY";
							}
						}
					}
				}else{
					for(int i = 0; i<list.size(); i++){
						if(customMnrOrdTmpDtlVO.getYdCd().substring(0, 5).equals(list.get(i).getYdCd())){
							type = "L";
						}
					}
						
					for(int i = 0; i<list.size(); i++){
						if(customMnrOrdTmpDtlVO.getYdCd().equals(list.get(i).getYdCd())){
							type = "Y";
						}
					}
				}
			}
			
			if(!"".equals(type)){
				customMnrOrdTmpDtlVO.setType(type);
				result = dbDao.searchAgmtAmountData(customMnrOrdTmpDtlVO);
			}
		}  catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Invoice] searchAgmtRateBasic"}).getMessage(),de);
		}

		return result;
	}
	
//	public boolean isNumber(String s) {
//		return s.matches("^[0-9]*$");
//	}
	
	/**
	 * [EES_MNR_0248]SOL Invoice Uploading Back End Job<br>
	 *
	 * @param  InterfaceGRPVO interfaceGRPVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndManageSOLInvoiceBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount userAccount) throws EventException {
		InterfaceMgtSOLInvoiceBackEndJob backEndJob = new InterfaceMgtSOLInvoiceBackEndJob();
		backEndJob.setInterfaceGRPVO(interfaceGRPVO);
		backEndJob.setSignOnAccount(userAccount);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "backEndManageSOLInvoiceBasic BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"backEndManageSOLInvoiceBasic BackEndJob"}).getMessage(),ex);
		}
	}
	
	/**
	 * Newport EDI Process Batch<br>
	 *
	 * @param  String ediMsg
	 * @throws EventException
	 */
	public void excuteNewportBatchBasic(String ediMsg) throws EventException {
		try {
			ScheduleUtil su = new ScheduleUtil();
			log.debug("============================TEST ================================");
//			if(!su.isRunning("EES_MNR_B002")){
			su.directExecuteJob("EES_MNR_B002", ediMsg);
//			}else{
//				log.error("EES_MNR_B002 Batch:::Processing ");
//				throw new EventException(new ErrorHandler("SAR00045", new String[] {}).getUserMessage());
//			}
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213", new String[] { "Newport EDI Process Batch" }).getMessage(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213", new String[] { "Newport EDI Process Batch" }).getMessage(), e);
		}
	}
	
	/**
	 * Find VVD Information<br>
	 *
	 * @param  String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchRevVvdInfoBasic(String bkgNo) throws EventException{
		try{
			return dbDao.searchRevenueVvdData(bkgNo);
		}  catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchRevVvdInfoBasic"}).getMessage(),de);
		}
	}
}