/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsTransmissionBC.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.BaplieAlarmSetupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.SendingLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.StowageManifestCondVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CustomsTransmission Business Logic Command Interface<br>
 * - ALPS-CustomsTransmission 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public interface UsaCustomsTransmissionBC {

	/**
	 * US 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVO) throws EventException;

	 /**
	 * 0543, 0514 화면의 Arrival, Departure 전송을 위한 조회를 실행한다.
	 *
	 * @param ManifestListCondForEdiVO manifestListCondForEdiVO
	 * @return ManifestListForEdiVO
	 * @throws EventException
	 */
	public ManifestListForEdiVO searchManifestListForEdi(ManifestListCondForEdiVO manifestListCondForEdiVO)	throws EventException;

	 /**
	 * US 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transmitOfm(ManifestTransmitVO[] manifestTransmitVO) throws EventException;

	 /**
	 * 세관 적하 목록 정정 신고를 위한 적하 정정 목록 조회
	 *
	 * @param CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO
	 * @param String aiDiv
	 * @return List<CstmsManifestAmendmentVO>
	 * @throws EventException
	 */
	public List<CstmsManifestAmendmentVO> searchCstmsManifestAmendment(CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO, String aiDiv) throws EventException;

	 /**
	 * Vessel Stowage Plan Transmit 화면을 조회.
	 *
	 * @param StowageManifestCondVO stowageManifestCondVO
	 * @return List<ManifestTransmitVO>
	 * @throws EventException
	 */
	public List<ManifestTransmitVO> searchStowageManifestList(StowageManifestCondVO stowageManifestCondVO) throws EventException;

	 /**
	 * Vessel Stowage Plan Transmit을 실행.
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String
	 * @throws EventException
	 */
	public String transmitStowageManifest(ManifestTransmitVO[] manifestTransmitVOs) throws EventException;

	 /**
	 * BackEndJob을 실행.
	 *
	 * @param account SignOnUserAccount
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVO, String pgmNo)
			throws EventException;

	 /**
	 * EDI 수신으로 받은 문자열을 Parsing 하여 msg_tp값에 따라서 서로 다른 DAO 메소드를 호출한다.
	 *
	 * @param RcvMsgVO rcvMsgVO
	 * @return RcvMsgVO
	 * @throws EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(RcvMsgVO rcvMsgVO);

	 /**
	 * Log 정보를 생성한다.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @throws Exception
	 */
	public void addSendLog(SendingLogVO sendingLogVO) throws EventException;

	 /**
	 * Log Detail 정보를 생성한다.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @throws Exception
	 */
	public void addSendLogDetail(SendingLogVO sendingLogVO) throws EventException;

	 /**
	 * BKG_CSTMS_ADV_EDI_BL_RSPN 테이블에 CRR_BAT_NO 등을 삽입한다.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @throws Exception
	 */
	public void addCarrierBatchNo(SendingLogVO sendingLogVO) throws EventException;

	 /**
	 * ISF US 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param manifestTransmitVOs manifestTransmitVO
	 * @param account 세션정보
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifestIsf(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * Transmit 하기 위한 세관 테이블의 Customer, Container 등의 Terminal BL 정보를 조회한다
	 *
	 * @param BlInfoCondVO blInfoCondVO
	 * @return List<BlInfoVO>
	 * @exception EventException
	 */
	public List<BlInfoVO> searchTmlBlByVvd(BlInfoCondVO blInfoCondVO) throws EventException;

	 /**
	 * Baplie Alarm List를 조회한다.
	 *
	 * @param BaplieAlarmSetupVO baplieAlarmSetupVO
	 * @return List<BaplieAlarmSetupVO>
	 * @exception EventException
	 */
	public List<BaplieAlarmSetupVO> searchBaplieAlarmSetup(BaplieAlarmSetupVO baplieAlarmSetupVO) throws EventException;

	 /**
	 * Baplie Alarm List를 관리한다.
	 *
	 * @param baplieAlarmSetupVOs BaplieAlarmSetupVO[]
	 * @param user_id String
	 * @exception EventException
	 */
	public void manageBaplieAlarmSetup(BaplieAlarmSetupVO[] baplieAlarmSetupVOs, String user_id) throws EventException;

	/**
	 * EDI 전송 오류

	 * @param msg
	 * @throws Exception
	 */
	public void loadEdiErr(String msg) throws Exception;
}