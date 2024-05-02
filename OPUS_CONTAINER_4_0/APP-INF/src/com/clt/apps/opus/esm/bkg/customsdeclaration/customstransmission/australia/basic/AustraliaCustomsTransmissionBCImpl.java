/*=========================================================
*Copyright(c) CyberLogitec
*@FileName : AustraliaCustomsTransmissionBCImpl.java
*@FileTitle : AustraliaCustomsTransmissionBCImpl
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.basic;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration.AusCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AustraliaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSearchCuscarVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsAusSndLogVO;


/**
 * OPUS-AustraliaCustomsTransmission Business Logic Command implementation<br>
 * - OPUS-AustraliaCustomsTransmission handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class AustraliaCustomsTransmissionBCImpl extends BasicCommandSupport implements AustraliaCustomsTransmissionBC {
	// Database Access Object
	private transient AusCustomsTransmissionDBDAO dbDao = null;

	/**
	 * AusCustomsTransmissionDBDAO 객체 생성<br>
	 */
	public AustraliaCustomsTransmissionBCImpl() {
		dbDao = new AusCustomsTransmissionDBDAO();
	}

	/**
	 * Back End Job 공통 - Back End Job Status 조회
	 * (동일 Package에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException {
		String result = "";
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(backEndJobKey).getDbRowset();
			while (rowSet.next()) result = rowSet.getObject("jb_sts_flg").toString();
			return result;
		} catch(BackEndJobException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(SQLException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0053 - BackEndJob 시작
	 *
	 * @param SignOnUserAccount account
	 * @param AustraliaManifestTransmitVO[] australiaManifestTransmitVOs
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobManifestTransmit(SignOnUserAccount account, AustraliaManifestTransmitVO[] australiaManifestTransmitVOs) throws EventException {
		AustraliaCustomsTransmissionBackEndJobManifestTransmit backEndJob = new AustraliaCustomsTransmissionBackEndJobManifestTransmit();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			backEndJob.setAustraliaManifestTransmitVOs(australiaManifestTransmitVOs);
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_BKG_0053 - Transmit");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1514] : CARLST
	 *  Transmit - Back End Job 시작<br>
	 * Australia Cargo List Report - CARLST EDI 전송
	 *
	 * @param AusSearchCuscarVO searchCuscar
	 * @param AusResultCuscarVO[] ausResultCuscarVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 */
	public String startBackEndJobTransmitCarlst(AusSearchCuscarVO searchCuscar, AusResultCuscarVO[] ausResultCuscarVOs, SignOnUserAccount signOnUserAccount) throws EventException {
		AustraliaCustomsTransmissionBackEndJobCarlstTransmit backEndJob = new AustraliaCustomsTransmissionBackEndJobCarlstTransmit();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			backEndJob.setAusSearchCuscarVO(searchCuscar);
			backEndJob.setAusResultCuscarVOs(ausResultCuscarVOs);
			backEndJob.setAccount(signOnUserAccount);
			return backEndJobManager.execute(backEndJob, signOnUserAccount.getUsr_id(), "ESM_BKG_1514 : CARLST - Transmit");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1517] : UBMREQ
	 *  Transmit - Back End Job 시작<br>
	 * Australia Underbond Movement Request - UBMREQ EDI 전송
	 *
	 * @param AusSearchCuscarVO searchCuscar
	 * @param AusResultCuscarVO[] ausResultCuscarVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 */
	public String startBackEndJobTransmitUbmreq(AusSearchCuscarVO searchCuscar, AusResultCuscarVO[] ausResultCuscarVOs, SignOnUserAccount signOnUserAccount) throws EventException {
		AustraliaCustomsTransmissionBackEndJobUbmreqTransmit backEndJob = new AustraliaCustomsTransmissionBackEndJobUbmreqTransmit();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			backEndJob.setAusSearchCuscarVO(searchCuscar);
			backEndJob.setAusResultCuscarVOs(ausResultCuscarVOs);
			backEndJob.setAccount(signOnUserAccount);
			return backEndJobManager.execute(backEndJob, signOnUserAccount.getUsr_id(), "ESM_BKG_1517 : UBMREQ - Transmit");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1516] : SEACR
	 *  Transmit - Back End Job 시작<br>
	 * Australia Sea Cargo Report - SEACR EDI 전송
	 *
	 * @param AusSearchCuscarVO searchCuscar
	 * @param AusResultCuscarVO[] ausResultCuscarVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 */
	public String startBackEndJobTransmitSeacr(AusSearchCuscarVO searchCuscar, AusResultCuscarVO[] ausResultCuscarVOs, SignOnUserAccount signOnUserAccount) throws EventException {
		AustraliaCustomsTransmissionBackEndJobSeacrTransmit backEndJob = new AustraliaCustomsTransmissionBackEndJobSeacrTransmit();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			backEndJob.setAusSearchCuscarVO(searchCuscar);
			backEndJob.setAusResultCuscarVOs(ausResultCuscarVOs);
			backEndJob.setAccount(signOnUserAccount);
			return backEndJobManager.execute(backEndJob, signOnUserAccount.getUsr_id(), "ESM_BKG_1516 : SEACR - Transmit");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1514] : CARLST
	 * [ESM_BKG_1517] : UBMREQ
	 * [ESM_BKG_1516] : SEACR
	 *  Transmit - Back End Job 결과<br>
	 * Australia Customs Cargo List - EDI 전송
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobTransmitCuscar(String backEndJobKey) throws EventException {
		try {
			return (String)BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EDI_T_BKG_T_AUCUS_ACK]
	 * Australia ACK EDI메세지를 수신 처리
	 *
	 * @param String flatFile
	 * @exception EventException
	 */
	public void receiveEDIForAusAck(String flatFile) throws EventException {
		try {
			flatFile = flatFile.replaceAll("\r\n", "\n");
			String[] flatfileRowArray = flatFile.trim().split("\n");
			String ediRefId = "";
			for (int i=1; i<6; i++) {
				if (flatfileRowArray[i].startsWith("ORG_MSG_KEY")) {
					String[] tmpStrArr = flatfileRowArray[i].split(":");
					if (tmpStrArr.length > 1) ediRefId = tmpStrArr[1].trim();
					break;
				}
			}
			if (ediRefId != null && !"".equals(ediRefId)) {
				String[] errStringArray = flatFile.trim().split("\\{ERRORS");
				BkgCstmsAusSndLogVO bkgCstmsAusSndLogVO = new BkgCstmsAusSndLogVO();
				bkgCstmsAusSndLogVO.setEdiRcvMsgCtnt(flatFile);
				if (errStringArray.length > 1) {
					bkgCstmsAusSndLogVO.setCstmsRqstFlg("Y");
				} else {
					bkgCstmsAusSndLogVO.setCstmsRqstFlg("N");
				}
				bkgCstmsAusSndLogVO.setUpdUsrId("EDI RCV");
				bkgCstmsAusSndLogVO.setEdiRefId(ediRefId);
				dbDao.modifyCstmsAusSndLog(bkgCstmsAusSndLogVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1520 : Transmit - Back End Job 시작<br>
	 * Australia Import Status EDI 전송
	 *
	 * @param AusDgEdiVO[] ausDgEdiVOs
	 * @param SignOnUserAccount account
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobTransmitDgManifest(AusDgEdiVO[] ausDgEdiVOs, SignOnUserAccount account, String pgmNo) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		AustraliaCustomsTransmissionBackEndJobDgManifest backEndJob = new AustraliaCustomsTransmissionBackEndJobDgManifest();
		try {
			backEndJob.setAusDgEdiVOs(ausDgEdiVOs);
			backEndJob.setSignOnUserAccount(account);
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), pgmNo);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1520 : Transmit - Back End Job 결과<br>
	 * Australia Import Status EDI 전송
	 *
	 * @param String backEndJobKey
	 * @return List<String>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<String> resultBackEndJobTransmitDgManifest(String backEndJobKey) throws EventException {
		try {
			return (List<String>) BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

}
