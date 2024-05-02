/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfaceMgtBCImpl.java
*@FileTitle : Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19checkEDIEstimateBasic
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.12.12 김상수 [CHM-201115107-01] MNR Repair SPP Upload 기능 Verify Result 기능 강화
*                                      - Excel Upload 직후 MST에서 EQ No 존재유무 확인 로직 추가
*                                      - Error 발생시 사용자 메세지 팝업창 수정
*                                      - Confirm시 Fail일때, 원인내용 표기
* 2012.01.30 김상수 [CHM-201215889-01] Repair SPP Upload 화면 로직 변경 요청
*                                      - 엑셀로 업로드 받은 Hour와 Material은 Qty가 1이상일 경우 Hour*Qty, Material*Qty로 계산해서 업로드
* 2012.02.03 신혜정 [선처리] Material*Qty 항목 삭제, Amount = Cost + Material
* 2012.02.10 김상수 [CSR선처리] Repair SPP Upload 화면 수정
*                                      - 엑셀로 업로드시 Hour의 Validation 로직 제거 (Hour가 0이더라도 Process진행 가능)
* 2012.06.15 신혜정 [CHM-201218436] [Calculation] 버튼 기능 추가   
* 2012.07.31  신혜정 [CHM-201219139]	FA Interface 로그 보완 작업	     
* 2013.02.15 조경완 [CHM-201322897-01] ALPS-CNTR MNR-Repair -Estimate Creation 화면 상에서 TPB Interface 에러 건 수정 요청  
* 2014-03-14 JongHee HAN ERP FA I/F시 NOSEND(FA NO가 없는 경우 제외) Total Count Error Fix                            
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration.DocSendEAIDAO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration.FASendEAIDAO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration.InterfaceMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpDtlVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.DocResultVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.FaErpListVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.FlatFileDtlVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.FlatFileHdrVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic.TPBInterfaceBC;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;

/**
 * alps-OperationManage Business Logic Basic Command implementation<br>
 * - alps-OperationManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author LEE JU HYUN
 * @see EES_MNR_0139EventResponse,EQFlagMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class InterfaceMgtBCImpl extends BasicCommandSupport implements InterfaceMgtBC {

	// Database Access Object
	private transient InterfaceMgtDBDAO dbDao = null;
	private transient DocSendEAIDAO eaiDao = null;
	private transient FASendEAIDAO eaiFaDao = null;

	/**
	 * InterfaceMgtBCImpl 객체 생성<br>
	 * GeneralCodeCheckMgtDBDAODAO를 생성한다.<br>
	 */
	public InterfaceMgtBCImpl() {
		dbDao = new InterfaceMgtDBDAO();
		eaiDao = new DocSendEAIDAO();
		eaiFaDao = new FASendEAIDAO();
	}

	/**
	 * [UDEVHJS_ALPSMNR_T_WESTIM] EDI를 통해 들어온 견적서가 본테이블로 이동가능한지 검증. <br>
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO interfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO checkEDIEstimateBasic(InterfaceGRPVO interfaceGRPVO) throws EventException {
		try {
			CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVO();
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = new CustomMnrRprRqstHdrVO();

			//RQST_REF_NO 로 해당 EQ를 검색
			customMnrRprRqstHdrVO = dbDao.searchEstimateSeqByRefNoData(customMnrRprRqstTmpHdrVO);
			interfaceGRPVO.setCheckCustomMnrRprRqstHdrVO(customMnrRprRqstHdrVO);
			//EDI ERROR [Eq ERROR]
			if(!interfaceGRPVO.getEqChk().equals("SS")){
				dbDao.modifyESTTempFlagData(customMnrRprRqstTmpHdrVO, "UE");
				interfaceGRPVO.setValidOk(false);
				return interfaceGRPVO;
			}
			//EDI ERROR [Rqst_Ref_No ERROR]
			if(!interfaceGRPVO.getRqstRefNoChk().equals("SS")){
				dbDao.modifyESTTempFlagData(customMnrRprRqstTmpHdrVO, "RE");
				interfaceGRPVO.setValidOk(false);
				return interfaceGRPVO;
			}
			//EDI ERROR [Date Format 에러] [ACT_TRANS_DT OR EST_DT]
			if(!interfaceGRPVO.getDateFormChk().equals("SS")){
				dbDao.modifyESTTempFlagData(customMnrRprRqstTmpHdrVO, "DE");
				interfaceGRPVO.setValidOk(false);
				return interfaceGRPVO;
			}
			//EDI ERROR [Vender Seq 에러]
			if(!interfaceGRPVO.getVenderChk().equals("SS")){
				dbDao.modifyESTTempFlagData(customMnrRprRqstTmpHdrVO, "VE");
				interfaceGRPVO.setValidOk(false);
				return interfaceGRPVO;
			}
			//EDI ERROR [Already Processed 에러] RQST_REF_NO 로 해당 EQ 를 검색 이미 HA인 경우가 있을경우
			if(customMnrRprRqstHdrVO != null && customMnrRprRqstHdrVO.getRprStsCd().equals("HA")){
				dbDao.modifyESTTempFlagData(customMnrRprRqstTmpHdrVO, "AP");
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
	 * [EES_MNR_0023]Repair Group Auditing의 정보를 작업 합니다. <br>
	 * TPB 전용 Interface Method
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTPBIFBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException {
		try {
			TPBInterfaceBC command = new TPBInterfaceBCImpl();

			List<TPBInterfaceVO> tPBInterfaceVOS = dbDao.searchTPBInterfaceListData(interfaceGRPVO);

			//tpb interface 호출
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
	 * Flagging 전용 외부 Interface Method <br>
	 * MST CGM 에 정보를 업데이트 합니다.
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
							throw new EventException(new ErrorHandler("MNR00326").getMessage());
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
	 * [Interface ] 의 정보를 작업 합니다. <br>
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
	 * [EES_MNR_0216]Total Loss Request의 정보를 삭제 합니다. <br>
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
	 * [EES_MNR_0029]FQA Result Creation의 정보를 삭제 합니다. <br>
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
	 * [EES_MNR_0223]Total Loss Request의 정보를 조회 합니다. <br>
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
	 * [EES_MNR_0036]M&R Document Transmission의 정보를 작업 합니다. <br>
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
				flatFile.append("HJS_OFC_CD:"+flatFileHdrVO.getHjsOfcCd()+"\n");
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
	 * [EES_MNR_0161]Scrapping/Donation Creation의 정보를 작업 합니다. <br>
	 *
	 * @param FaErpListVO[] arrayFaErpListVOs
	 * @param SignOnUserAccount account
	 * @param String sFlag
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
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
			//2014-03-14 JongHee HAN ERP FA I/F시 NOSEND(FA NO가 없는 경우 제외) Total Count Error Fix
			for(int i=0; i<sendVoList.size(); i++){
				sendVoList.get(i).setTotalCount(String.valueOf(sendVoList.size()));
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
	 * [EES_MNR_0159]Text 메일 전송 작업 합니다. <br>
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
	 * [EES_MNR_0157]Html Template 메일 전송 작업 작업 합니다. <br>
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
	 * Receive MQ 연동 처리 <br>
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

			//************ 헤더와 디테일을 구분한다. ********************//
			int headerEnd = eaiRecMsg.indexOf("{DETAIL",0);
			String header = eaiRecMsg.substring(0, headerEnd - lineDelimeterLen);

			int findIndex = headerEnd;
			int detailFirst = 0;

			while((detailFirst = eaiRecMsg.indexOf("LINE_NO:",findIndex)) != -1){
				findIndex = eaiRecMsg.indexOf("}DETAIL",detailFirst);
				dtlVec.add(eaiRecMsg.substring(detailFirst,findIndex - lineDelimeterLen));
			}
			//************ 헤더와 디테일을 구분한다. END ********************//

			String[] headerEntity = header.split("\n");

			CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = new CustomMnrRprRqstTmpHdrVO();

			for(int i = 0;i < headerEntity.length ;i++){
				//줄바꿈 문자 케리지 리턴 제거
				String tempText = headerEntity[i].replaceAll("\r","");
				tempText = tempText.replaceAll("\n","");
				String[] tempEntity = tempText.split(":");

				String entityValue = "";
				if(tempEntity.length == 2){
					entityValue = tempEntity[1].trim();
				}

				//헤더 데이타 VO 생성
				if(tempEntity[0].startsWith("EST_NO")){
					customMnrRprRqstTmpHdrVO.setRqstRefNo(entityValue);
				} else if(tempEntity[0].startsWith("EQ_TYPE")){
					customMnrRprRqstTmpHdrVO.setEqKndCd(entityValue);
				} else if(tempEntity[0].startsWith("EQ_PREFIX")){
					customMnrRprRqstTmpHdrVO.setEqPrefix(entityValue);
				} else if(tempEntity[0].startsWith("EQ_NO")){
					customMnrRprRqstTmpHdrVO.setRqstEqNo(entityValue);
				} else if(tempEntity[0].startsWith("AUTH_SENDER")){
					//AUTH_SENDER가 없는건 임의로 넣어줌
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

			//EQ_NO는 다시 세팅 PRFIX + NO
			customMnrRprRqstTmpHdrVO.setRqstEqNo(customMnrRprRqstTmpHdrVO.getEqPrefix() + customMnrRprRqstTmpHdrVO.getRqstEqNo());
			customMnrRprRqstTmpHdrVO.setRprRqstLstVerFlg("Y");

			//추가 요청 EQ_TYPE은 조회해서 다시 세팅한다.
			String eqType =  dbDao.searchEqTypeByEqNoData(customMnrRprRqstTmpHdrVO);
			customMnrRprRqstTmpHdrVO.setEqKndCd(eqType);

			//SEQ,VERSION NO 는 구해와야 한다.
			CustomMnrRprRqstTmpHdrVO tempVO = dbDao.searchTempEstimateSeqData(customMnrRprRqstTmpHdrVO);

			if(tempVO != null){
				//견적서 번호가 존재하는 놈이 있다면 버젼만 업
				int asIsVerno = Integer.parseInt(tempVO.getRprRqstTmpVerNo());
				customMnrRprRqstTmpHdrVO.setRprRqstTmpSeq(tempVO.getRprRqstTmpSeq());
				customMnrRprRqstTmpHdrVO.setRprRqstTmpVerNo(asIsVerno + 1 + "");
			} else {
				//없다면 새로 생성한다.
				tempVO = dbDao.searchEstimateTempSeqNewEqData(customMnrRprRqstTmpHdrVO);
				customMnrRprRqstTmpHdrVO.setRprRqstTmpSeq(tempVO.getRprRqstTmpSeq());
				customMnrRprRqstTmpHdrVO.setRprRqstTmpVerNo(tempVO.getRprRqstTmpVerNo());
			}

			//*************** 추가 요청사항 Rqst_Ref_No 없는건은 팅겨낸다. 2009-12-1 *******************//
			if(customMnrRprRqstTmpHdrVO.getRqstRefNo().equals("")){
				//Rqst_Ref_No ERROR
				interfaceGRPVO.setRqstRefNoChk("RE");
			} else {
				interfaceGRPVO.setRqstRefNoChk("SS");
			}

			//*************** 날짜 포멧 체크 *******************//
			//문제 잇는 놈은 그냥 오늘 날짜 박아주고 에러처리
			String tempToday  = (new SimpleDateFormat("yyyyMMdd")).format(new Date());

			//1. ACT_TRANS_DT
			//DE -> SS로 처리
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
			//*************** 날짜 포멧 체크 *******************//

			//TPSZ도 조회해 온다. (ISO 코드로 들어오나 샤시 젠셋엔 없어서 무시하고 조회)
			String tpszCd = dbDao.searchTempEstimateTpszData(customMnrRprRqstTmpHdrVO);
			customMnrRprRqstTmpHdrVO.setEqTpszCd(tpszCd);

			//추가 세팅 항목
			customMnrRprRqstTmpHdrVO.setRprStsCd("HR");
			customMnrRprRqstTmpHdrVO.setRprDtlStsCd("1");
			customMnrRprRqstTmpHdrVO.setMnrInpTpCd("E");
			customMnrRprRqstTmpHdrVO.setRqstUsrId(customMnrRprRqstTmpHdrVO.getCreUsrId());
			customMnrRprRqstTmpHdrVO.setRprWrkTpCd("W");

			//NOT NULL 항목
			customMnrRprRqstTmpHdrVO.setN3ptyFlg("N");
			customMnrRprRqstTmpHdrVO.setDispFlg("N");

			//*************** 추가 요청사항 Vender_Seq 없는건은 팅겨낸다. 2009-11-6 *******************//
			//VNDR_SEQ AGMT 값은 조회해온다 .
			CustomMnrRprRqstTmpHdrVO tempVO2 = dbDao.searchTempEstimateAGMTData(customMnrRprRqstTmpHdrVO);

			if(tempVO2 != null){
				customMnrRprRqstTmpHdrVO.setVndrSeq(tempVO2.getVndrSeq());
				customMnrRprRqstTmpHdrVO.setAgmtOfcCtyCd(tempVO2.getAgmtOfcCtyCd());
				customMnrRprRqstTmpHdrVO.setAgmtSeq(tempVO2.getAgmtSeq());
				customMnrRprRqstTmpHdrVO.setAgmtVerNo(tempVO2.getAgmtVerNo());
				//CURR_CD가 없이 들어오는  EDI의 경우 Agreement Curr_cd로 넣어준다.
				if(customMnrRprRqstTmpHdrVO.getCurrCd().equals("") || customMnrRprRqstTmpHdrVO.getCurrCd() == null){
					customMnrRprRqstTmpHdrVO.setCurrCd(tempVO2.getCurrCd());
				}	
				
				interfaceGRPVO.setVenderChk("SS");
			} else {   //없는건 0으로 표시 차후에 삭제
				customMnrRprRqstTmpHdrVO.setVndrSeq("");
				customMnrRprRqstTmpHdrVO.setAgmtOfcCtyCd("");
				customMnrRprRqstTmpHdrVO.setAgmtSeq("");
				customMnrRprRqstTmpHdrVO.setAgmtVerNo("");
				interfaceGRPVO.setVenderChk("VE");
			}

			//플레그 N으로 바꿈
			dbDao.modifyESTTmpHDRLastVersionUnFlagData(customMnrRprRqstTmpHdrVO);
			dbDao.modifyESTTmpDTLLastVersionUnFlagData(customMnrRprRqstTmpHdrVO);
			//헤더 데이타 삽입
			dbDao.addTempEstimateHDRData(customMnrRprRqstTmpHdrVO);
			//리턴처리해서 견적서 테이블에 넣기위한
			interfaceGRPVO.setCustomMnrRprRqstTmpHdrVO(customMnrRprRqstTmpHdrVO);


			//VALIDATION EQ_NO 체크  UE/SS
			String eqChk = dbDao.searchEQFlagFileListByEQData(customMnrRprRqstTmpHdrVO);
			interfaceGRPVO.setEqChk(eqChk);

			//DTL 데이타 처리
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

					//디테일 데이타 VO 생성
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
								//.이 들어왔을때 절삭한다.
								} else if(chars[k] == '.') {
									//첫글자가 . 인경우는 제외
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
								//.이 들어왔을때 절삭한다.
								} else if(chars[k] == '.') {
									//첫글자가 . 인경우는 제외
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
								//.이 들어왔을때 절삭한다.
								} else if(chars[k] == '.') {
									//첫글자가 . 인경우는 제외
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
								//소수점 2자리 이상일 경우 2자리에서 자른다.
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
								//소수점 2자리 이상일 경우 2자리에서 자른다.
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
								//소수점 2자리 이상일 경우 2자리에서 자른다.
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

				//기본값
				customMnrRprRqstTmpDtlVO.setRqstEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrRprRqstTmpDtlVO.setRprRqstTmpSeq(customMnrRprRqstTmpHdrVO.getRprRqstTmpSeq());
				customMnrRprRqstTmpDtlVO.setRprRqstTmpVerNo(customMnrRprRqstTmpHdrVO.getRprRqstTmpVerNo());
				customMnrRprRqstTmpDtlVO.setRprRqstTmpDtlSeq((i + 1) + "");
				customMnrRprRqstTmpDtlVO.setEqLocCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqCmpoCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqDmgCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqRprCdChkFlg("N");

				//부수적 세팅
				customMnrRprRqstTmpDtlVO.setCreUsrId(customMnrRprRqstTmpHdrVO.getCreUsrId());
				customMnrRprRqstTmpDtlVO.setUpdUsrId(customMnrRprRqstTmpHdrVO.getCreUsrId());
				customMnrRprRqstTmpDtlVO.setCreDt(customMnrRprRqstTmpHdrVO.getCreDt());
				customMnrRprRqstTmpDtlVO.setUpdDt(customMnrRprRqstTmpHdrVO.getCreDt());

				customMnrRprRqstTmpDtlVO.setRprRqstLstVerFlg("Y");
				customMnrRprRqstTmpDtlVO.setMnrLrAcctFlg("N");
				customMnrRprRqstTmpDtlVO.setN3ptyFlg("N");
				customMnrRprRqstTmpDtlVO.setTrfDivCd(" ");

				//추가 요청사항 eqChk -> ""
				//INPUT TYPE이 EDI일 경우 AUDITING에서 SAVE시
				//무조건 CALCULATION 실행할수 있도록 구성하여 주시기 바랍니다.
				customMnrRprRqstTmpDtlVO.setMnrVrfyTpCd("");

				//로직변경  20100409 (0도 없는걸로 판정)
				//둘중 하나만 있으면  SIZE
				//둘다 있으면 SQUARE
				//둘다 없으면 QTY 체크 로직
				//QTY도 없으면 QTY = 1로 세팅
				int length = Integer.parseInt(dim_len);
				int width  = Integer.parseInt(dim_wid);
				int quantity = Integer.parseInt(qty);

				//둘다 있으면 Square
				if(length != 0 && width != 0){
					customMnrRprRqstTmpDtlVO.setVolTpCd("S");
					customMnrRprRqstTmpDtlVO.setRprSzNo((length * width)  + "");
				//둘중 하나만 있으면 Size
				} else if(length != 0 || width != 0){
					customMnrRprRqstTmpDtlVO.setVolTpCd("Z");
					customMnrRprRqstTmpDtlVO.setRprSzNo((length + width)  + "");
				//둘다 없음 QTY 있나 체크
				} else {
					customMnrRprRqstTmpDtlVO.setVolTpCd("Q");
					customMnrRprRqstTmpDtlVO.setRprSzNo("");
					//QTY 값이 있으면
					if(quantity != 0){
						customMnrRprRqstTmpDtlVO.setRprQty(quantity + "");
					//세가지 모두 없는경우  없다면 QTY = 1로 세팅
					} else {
						customMnrRprRqstTmpDtlVO.setRprQty("1");
					}
				}

				//2) 계산 값 세팅
				Double costAmt =  Double.parseDouble(customMnrRprRqstTmpDtlVO.getRprLbrHrs()) * Double.parseDouble(customMnrRprRqstTmpDtlVO.getRprLbrRt());
				//소수점 2째자리에서 반올림
				customMnrRprRqstTmpDtlVO.setLbrCostAmt(String.format("%.2f", costAmt));
				//소수점 2째자리에서 반올림
				Double wrkAmt = costAmt + Double.parseDouble(customMnrRprRqstTmpDtlVO.getMtrlCostAmt());
				customMnrRprRqstTmpDtlVO.setMnrWrkAmt(String.format("%.2f", wrkAmt));

				//BASIC 값은 EDI는 다 0으로 세팅 값벨리데이션을 하지 않는다.
				customMnrRprRqstTmpDtlVO.setRprLbrBzcHrs("0");
				customMnrRprRqstTmpDtlVO.setRprLbrBzcRt("0");
				customMnrRprRqstTmpDtlVO.setMnrLbrBzcAmt("0");
				customMnrRprRqstTmpDtlVO.setLbrMtrlBzcAmt("0");

				//COST_CD 구해온다. 
				String cost_cd = dbDao.searchTempEstimateCostCdData(customMnrRprRqstTmpHdrVO.getEqKndCd(),customMnrRprRqstTmpHdrVO.getEqTpszCd(),customMnrRprRqstTmpDtlVO.getEqCmpoCd());
				customMnrRprRqstTmpDtlVO.setCostCd(cost_cd);
				
				//2011.06.14 cost_cd.length() > 0 으로 수정
				//문자열 비교는 문자열 비교 메소드를 사용해야 한다.
				//if (cost_cd != "" || cost_cd != null) {
				
				if (!"".equals(cost_cd) && cost_cd != null ){
					customMnrRprRqstTmpDtlVO.setCostGrpCd(cost_cd.substring(0, 3));
				}
				
				//DIV_CD 를 구해온다. 2010-08-31 14:36:07	 화요일
				String div_cd = dbDao.searchTempEstimateDivCdData(customMnrRprRqstTmpDtlVO);
				
				
				customMnrRprRqstTmpDtlVO.setTrfDivCd(div_cd);	   
					
				//DTL DATA INSERT
				dbDao.addTempEstimateDTLData(customMnrRprRqstTmpDtlVO);
			}
		} catch (StringIndexOutOfBoundsException de) {
			log.error("\nEDI Format Error SEND Msg :\n" + eaiRecMsg + "\n");
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Receive MQ 연동 처리] manageMQEstimateBasic"}).getMessage(),de);
		} catch (DAOException de) {
			log.error("\nEDI DAOException Error SEND Msg :\n" + eaiRecMsg + "\n");
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Receive MQ 연동 처리] manageMQEstimateBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("\nEDI Exception Error SEND Msg :\n" + eaiRecMsg + "\n");
			log.error("Error msg :" + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Receive MQ 연동 처리] manageMQEstimateBasic"}).getMessage(),de);
		}
		return interfaceGRPVO;
	}

	/**
	 * [EES_MNR_0161]Scrapping/Donation Creation의 정보를 조회 합니다. <br>
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
				//EQ No:XXXXXX 에 해당하는 FA EQ No 가 존재하지  않아 전송하실 수 없습니다.
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
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 작업 합니다. <br>
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
				apPayInvDtlVOs[i] = apPayInvDtlVO2;
			}
		    reg_no = command.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
			//reg_no = command.createApPayInvInfo(apPayInvVO, (ApPayInvDtlVO[])apPayInvDtlVO.toArray(), account);


		} catch (EventException e){
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] createCSRIFBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] createCSRIFBasic"}).getMessage(),de);
		}
		return reg_no;
	}


	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 삭제 합니다. <br>
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
	 * [EES_MNR_0161]Invoice 목록을 조회합니다. <br>
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
	 * [EES_MNR_QEXE] 에러난 EDI FLAG 재처리  <br>
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
	 * [EES_MNR_QEXE] 에러난 EDI 재전송할 목록 조회 <br>
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
	 * [EES_MNR_0243] Estimate Upload 자료에서 EQ_NO를 검증 <br>
	 *
	 * @param EstimateUploadVO[] estimateUploadVOs
	 * @return List<EstimateUploadVO>
	 * @exception EventException
	 */
	public List<EstimateUploadVO> searchEqTypeByEqNoBasic(EstimateUploadVO[] estimateUploadVOs) throws EventException {
		List<EstimateUploadVO> estimateUploadVOList = new ArrayList<EstimateUploadVO>();
		CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = null;
		try {
			for (int i = 0; i < estimateUploadVOs.length; i++) {
				customMnrRprRqstTmpHdrVO = new CustomMnrRprRqstTmpHdrVO();
				customMnrRprRqstTmpHdrVO.setRqstEqNo(estimateUploadVOs[i].getRqstEqNo());    //EQ_NO
				// 조회된 EQ_NO가 없으면 error내용을 setting
				if ("".equals(dbDao.searchEqTypeByEqNoData(customMnrRprRqstTmpHdrVO))) {
					estimateUploadVOs[i].setEdiErrCd("UE");
					estimateUploadVOs[i].setEdiErrNm("EQ No not found");
				}
				estimateUploadVOList.add(estimateUploadVOs[i]);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate Upload] EQ No. Search"}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate Upload] EQ No. Search"}).getMessage(), de);
		}
		return estimateUploadVOList;
	}

	/**
	 * [EES_MNR_0243] Estimate Upload 자료를 가공합니다. <br>
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

				//EstimateUploadVO 객체정보에서 Header 정보 만을 재구성 한다.
				estimateTmpHeaderPK = estimateUploadVO.getEstimateTmpHeaderPK();
				//Header 정보의 중복여부를 확인한다.
				if(!estimateTmpHeaderMap.containsKey(estimateTmpHeaderPK)) {
					//Interface VO 생성
					InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
					//헤더 데이타  VO 생성
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
					//추가 요청 EQ_TYPE은 조회해서 다시 세팅한다.
					String eqType =  dbDao.searchEqTypeByEqNoData(customMnrRprRqstTmpHdrVO);
					customMnrRprRqstTmpHdrVO.setEqKndCd(eqType);

					//SEQ,VERSION NO 는 구해와야 한다.
					CustomMnrRprRqstTmpHdrVO tempVO = dbDao.searchTempEstimateSeqData(customMnrRprRqstTmpHdrVO);

					if(tempVO != null){
						//견적서 번호가 존재하는 놈이 있다면 버젼만 업
						int asIsVerno = Integer.parseInt(tempVO.getRprRqstTmpVerNo());
						customMnrRprRqstTmpHdrVO.setRprRqstTmpSeq(tempVO.getRprRqstTmpSeq());
						customMnrRprRqstTmpHdrVO.setRprRqstTmpVerNo(asIsVerno + 1 + "");
					} else {
						//없다면 새로 생성한다.
						tempVO = dbDao.searchEstimateTempSeqNewEqData(customMnrRprRqstTmpHdrVO);
						customMnrRprRqstTmpHdrVO.setRprRqstTmpSeq(tempVO.getRprRqstTmpSeq());
						customMnrRprRqstTmpHdrVO.setRprRqstTmpVerNo(tempVO.getRprRqstTmpVerNo());
					}

					//*************** 추가 요청사항 Rqst_Ref_No 없는건은 팅겨낸다. 2009-12-1 *******************//
					if(customMnrRprRqstTmpHdrVO.getRqstRefNo().equals("")){
						//Rqst_Ref_No ERROR
						interfaceGRPVO.setRqstRefNoChk("RE");
					} else {
						interfaceGRPVO.setRqstRefNoChk("SS");
					}

					//*************** 날짜 포멧 체크 *******************//
					//문제 잇는 놈은 그냥 오늘 날짜 박아주고 에러처리
					String tempToday  = (new SimpleDateFormat("yyyyMMdd")).format(new Date());

					//1. ACT_TRANS_DT
					//DE -> SS로 처리
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
					//*************** 날짜 포멧 체크 *******************//

					//TPSZ도 조회해 온다. (ISO 코드로 들어오나 샤시 젠셋엔 없어서 무시하고 조회)
					String tpszCd = dbDao.searchTempEstimateTpszData(customMnrRprRqstTmpHdrVO);
					customMnrRprRqstTmpHdrVO.setEqTpszCd(tpszCd);

					//추가 세팅 항목
					//2010.09.28 박명신 [CHM-201006064-01]
					// 1. alps system(SPP) 의 수리견적 입력 시  excel upload 가능하게 한다.
					// 2. 기존 EDI => HR ,SPP 에서 호출 => SS 	
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

					//NOT NULL 항목
					customMnrRprRqstTmpHdrVO.setN3ptyFlg("N");
					customMnrRprRqstTmpHdrVO.setDispFlg("N");

					//*************** 추가 요청사항 Vender_Seq 없는건은 팅겨낸다. 2009-11-6 *******************//
					//VNDR_SEQ AGMT 값은 조회해온다 .
					CustomMnrRprRqstTmpHdrVO tempVO2 = dbDao.searchTempEstimateAGMTData(customMnrRprRqstTmpHdrVO);

					if(tempVO2 != null){
						customMnrRprRqstTmpHdrVO.setVndrSeq(tempVO2.getVndrSeq());
						customMnrRprRqstTmpHdrVO.setAgmtOfcCtyCd(tempVO2.getAgmtOfcCtyCd());
						customMnrRprRqstTmpHdrVO.setAgmtSeq(tempVO2.getAgmtSeq());
						customMnrRprRqstTmpHdrVO.setAgmtVerNo(tempVO2.getAgmtVerNo());
						interfaceGRPVO.setVenderChk("SS");
					} else {   //없는건 0으로 표시 차후에 삭제
						customMnrRprRqstTmpHdrVO.setVndrSeq("");
						customMnrRprRqstTmpHdrVO.setAgmtOfcCtyCd("");
						customMnrRprRqstTmpHdrVO.setAgmtSeq("");
						customMnrRprRqstTmpHdrVO.setAgmtVerNo("");
						interfaceGRPVO.setVenderChk("VE");
					}

					//플레그 N으로 바꿈
					dbDao.modifyESTTmpHDRLastVersionUnFlagData(customMnrRprRqstTmpHdrVO);
					dbDao.modifyESTTmpDTLLastVersionUnFlagData(customMnrRprRqstTmpHdrVO);
					//헤더 데이타 삽입
					dbDao.addTempEstimateHDRData(customMnrRprRqstTmpHdrVO);
					//리턴처리해서 견적서 테이블에 넣기위한
					interfaceGRPVO.setCustomMnrRprRqstTmpHdrVO(customMnrRprRqstTmpHdrVO);


					//VALIDATION EQ_NO 체크  UE/SS
					String eqChk = dbDao.searchEQFlagFileListByEQData(customMnrRprRqstTmpHdrVO);
					interfaceGRPVO.setEqChk(eqChk);

					//추출된 헤더정보를 중복체크 대상에 저장한다.
					estimateTmpHeaderMap.put(estimateTmpHeaderPK, customMnrRprRqstTmpHdrVO);
					//견적서 테이블에 넣기위한 I/F 정보를 보관한다.
					interfaceGRPVOList.add(interfaceGRPVO);
					//처리내용을 조회하기 위한 복합 PK를 작성한다.
					StringBuffer complexPkBuff = new StringBuffer();
					complexPkBuff.append(customMnrRprRqstTmpHdrVO.getRqstEqNo());
					complexPkBuff.append(customMnrRprRqstTmpHdrVO.getRprRqstTmpSeq());
					complexPkBuff.append(customMnrRprRqstTmpHdrVO.getRprRqstTmpVerNo());
					estimateUploadPK.add(complexPkBuff.toString());
				}

				//디테일 데이타 VO 생성
				CustomMnrRprRqstTmpDtlVO customMnrRprRqstTmpDtlVO = new CustomMnrRprRqstTmpDtlVO();
				//헤더 데이타 VO 검색
				CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = estimateTmpHeaderMap.get(estimateTmpHeaderPK);

				customMnrRprRqstTmpDtlVO.setEqLocCd(estimateUploadVO.getEqLocCd());				//DAM_LOC_CD
				customMnrRprRqstTmpDtlVO.setEqCmpoCd(estimateUploadVO.getEqCmpoCd());			//COMPNT_CD
				customMnrRprRqstTmpDtlVO.setEqDmgCd(estimateUploadVO.getEqDmgCd());				//DAM_TP_CD
				customMnrRprRqstTmpDtlVO.setEqRprCd(estimateUploadVO.getEqRprCd());				//REPR_METH_CD

				customMnrRprRqstTmpDtlVO.setRprLbrHrs(estimateUploadVO.getRprLbrHrs());			//MAN_HOUR
				customMnrRprRqstTmpDtlVO.setRprLbrRt(estimateUploadVO.getRprLbrRt());			//LAB_RATE
				customMnrRprRqstTmpDtlVO.setMtrlCostAmt(estimateUploadVO.getMtrlCostAmt());		//MATRL_COST

				//기본값
				customMnrRprRqstTmpDtlVO.setRqstEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrRprRqstTmpDtlVO.setRprRqstTmpSeq(customMnrRprRqstTmpHdrVO.getRprRqstTmpSeq());
				customMnrRprRqstTmpDtlVO.setRprRqstTmpVerNo(customMnrRprRqstTmpHdrVO.getRprRqstTmpVerNo());

				//DTL_SEQ 는 구해와야 한다.
				CustomMnrRprRqstTmpDtlVO tempDtlVO = dbDao.searchEstimateTempDtlSeqNewEqData(customMnrRprRqstTmpDtlVO);
				customMnrRprRqstTmpDtlVO.setRprRqstTmpDtlSeq(tempDtlVO.getRprRqstTmpDtlSeq());

				customMnrRprRqstTmpDtlVO.setEqLocCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqCmpoCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqDmgCdChkFlg("N");
				customMnrRprRqstTmpDtlVO.setEqRprCdChkFlg("N");

				//부수적 세팅
				customMnrRprRqstTmpDtlVO.setCreUsrId(customMnrRprRqstTmpHdrVO.getCreUsrId());
				customMnrRprRqstTmpDtlVO.setUpdUsrId(customMnrRprRqstTmpHdrVO.getCreUsrId());
				customMnrRprRqstTmpDtlVO.setCreDt(customMnrRprRqstTmpHdrVO.getCreDt());
				customMnrRprRqstTmpDtlVO.setUpdDt(customMnrRprRqstTmpHdrVO.getCreDt());

				customMnrRprRqstTmpDtlVO.setRprRqstLstVerFlg("Y");
				customMnrRprRqstTmpDtlVO.setMnrLrAcctFlg("N");
				customMnrRprRqstTmpDtlVO.setN3ptyFlg("N");
				customMnrRprRqstTmpDtlVO.setTrfDivCd(" ");

				//추가 요청사항 eqChk -> ""
				//INPUT TYPE이 EDI일 경우 AUDITING에서 SAVE시
				//무조건 CALCULATION 실행할수 있도록 구성하여 주시기 바랍니다.
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

				//2) 계산 값 세팅
				Double costAmt =  Double.parseDouble(customMnrRprRqstTmpDtlVO.getRprLbrHrs()) * Double.parseDouble(customMnrRprRqstTmpDtlVO.getRprLbrRt());
				//소수점 2째자리에서 반올림
				customMnrRprRqstTmpDtlVO.setLbrCostAmt(String.format("%.2f", costAmt));
				//소수점 2째자리에서 반올림
				Double wrkAmt = costAmt + Double.parseDouble(customMnrRprRqstTmpDtlVO.getMtrlCostAmt());
				customMnrRprRqstTmpDtlVO.setMnrWrkAmt(String.format("%.2f", wrkAmt));

				//BASIC 값은 EDI는 다 0으로 세팅 값벨리데이션을 하지 않는다.
				customMnrRprRqstTmpDtlVO.setRprLbrBzcHrs("0");
				customMnrRprRqstTmpDtlVO.setRprLbrBzcRt("0");
				customMnrRprRqstTmpDtlVO.setMnrLbrBzcAmt("0");
				customMnrRprRqstTmpDtlVO.setLbrMtrlBzcAmt("0");

				//cost_cd 구해온다.
				String cost_cd = dbDao.searchTempEstimateCostCdData(customMnrRprRqstTmpHdrVO.getEqKndCd(),customMnrRprRqstTmpHdrVO.getEqTpszCd(),customMnrRprRqstTmpDtlVO.getEqCmpoCd());
				customMnrRprRqstTmpDtlVO.setCostCd(cost_cd);
				
				//DIV_CD 를 구해온다. 2010-08-31 14:36:07	 화요일
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
	 * Estimate Upload 처리된 결과를 조회합니다. <br>
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
	 * [EES_MNR_0243] Estimate Upload 자료에서 Calculation 처리를 위한 eq type, tpsz 조회 <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @return CustomMnrRprRqstHdrVO
	 * @exception EventException
	 */
	public CustomMnrRprRqstHdrVO searchEqTypeNTpSzByEqNoBasic(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws EventException {
		CustomMnrRprRqstHdrVO rtnCustomMnrRprRqstHdrVO = null; 
		try {		
			rtnCustomMnrRprRqstHdrVO = dbDao.searchEqTypeNTpSzByEqNoData(customMnrRprRqstHdrVO);
		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate Upload] eq type, tpsz. Search"}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate Upload] eq type, tpsz. Search"}).getMessage(), de);
		}
		return rtnCustomMnrRprRqstHdrVO;
	}
	
	/**
	 * [EES_MNR_0243] Estimate Upload 자료에서 Calculation 처리를 위한 AGMT 정보 조회 <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @return CustomMnrRprRqstHdrVO
	 * @exception EventException
	 */	
	public CustomMnrRprRqstHdrVO searchTempEstimateAGMTBasic(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws EventException {
		CustomMnrRprRqstHdrVO rtnCustomMnrRprRqstHdrVO = null; 
		try {		
			rtnCustomMnrRprRqstHdrVO = dbDao.searchEstimateAGMTData(customMnrRprRqstHdrVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate Upload] AGMT. Search"}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate Upload] AGMT. Search"}).getMessage(), de);
		}
		return rtnCustomMnrRprRqstHdrVO;
	}

	/**
	 * [EES_MNR_0019]zip 파일 및 개별 image 파일들의 Thumbnail 이미지 정보를 저장합니다. <br>
	 *
	 * @param String seqValue
	 * @param String[] filePathNm
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createFileUploadThumbnail(String seqValue, String[] filePathNm, InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException {
		String keyFileNm = filePathNm[0];
		String dtlSeqValue = new String();
		
		try {
			dtlSeqValue = dbDao.searchDetailFileSeqenceValue(seqValue, keyFileNm);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"Thumbnail Information Storing"}).getMessage(), de);
		}
		
		if((seqValue != null || !"".equals(seqValue)) && (dtlSeqValue != null || !"".equals(dtlSeqValue))){
			try {
				dbDao.insertThumbnailInformation(seqValue, dtlSeqValue, filePathNm, interfaceGRPVO, account);
			} catch (DAOException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(new ErrorHandler("MNR00001", new String[]{"Thumbnail Information Storing"}).getMessage(), de);
			}	
		}
	}
	
	
}