/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Kor24CustomsTransmissionBC.java
 *@FileTitle : Kor24CustomsTransmissionBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.21 김승민
 * 1.0 Creation
 * -----------------------------------------------------
 * History
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.basic;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.AmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CancelManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.EmpAmdManiTransVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-CustomsTransmission Business Logic Command Interface<br>
 * - ALPS-CustomsTransmission 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public interface Kor24CustomsTransmissionBC {

	/**
	 * Manifest Trans Discharge SEND
	 * @param DischManifestTransmitVO dischManifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitDischManifest(DischManifestTransmitVO dischManifestTransmitVO) throws EventException;

	/**
	 * BackEndJob을 실행.
	 *
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO manifestTransmitVO, String pgmNo) throws EventException;

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO) throws EventException;

	/**
	 * Trans Amendment To PA
	 * @param AmendManifestTransmitVO amendManifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transAmendManifest(AmendManifestTransmitVO amendManifestTransmitVO) throws EventException;

	/**
	 * InBound Empty Amend 전송
	 * @param EmpAmdManiTransVO[] empAmdManiTransVOs
	 * @throws EventException
	 */
	public void transmitEmpAmdManifest(EmpAmdManiTransVO[] empAmdManiTransVOs) throws EventException;

	/**
	 * 한국세관 Cancel per B/L EDI 전송
	 *
	 * @param CancelManifestTransmitVO cancelManifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transCancelManifest(CancelManifestTransmitVO cancelManifestTransmitVO) throws EventException;

}