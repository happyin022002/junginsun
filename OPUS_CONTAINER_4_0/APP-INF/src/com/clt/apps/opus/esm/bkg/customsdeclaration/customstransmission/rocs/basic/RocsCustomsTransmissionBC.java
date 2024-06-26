/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsTransmissionBC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.21 김승민
 * 1.0 Creation
 * -----------------------------------------------------
 * History
 * 2011.11.15 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
 * 2012.04.26 김보배 [CHM-201217062] [BKG] Ghana Customs Manifest 전송 기능 개발 요청
 * 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
 * 2013.06.10 김보배 [CHM-201324023] ACI - Vessel Arrival Transmit (A6) 화면 및 로직 보완
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
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
public interface RocsCustomsTransmissionBC {

	 /**
	 * 조회 이벤트 처리<br>
	 * Rocs를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return ManifestTransmitDetailVO
	 * @exception EventException
	 */
	public ManifestTransmitDetailVO transmitManifestList(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * 전송 이벤트 처리<br>
	 * CustomsTransmission화면에 대한 전송 이벤트 처리<br>
	 * 
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @return RocsManifestTransmitVO
	 * @exception EventException
	 */
	public RocsManifestTransmitVO receiveOpusbkgUdevcom(String flatFile, SignOnUserAccount account) throws EventException;

	 /**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO[] detailVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] detailVOs, String pgmNo) throws EventException;
	
}