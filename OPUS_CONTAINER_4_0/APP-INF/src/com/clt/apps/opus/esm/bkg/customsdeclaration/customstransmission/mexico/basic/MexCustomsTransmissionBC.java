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
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CargoManifestCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CargoManifestListResultForEdiVO;
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
public interface MexCustomsTransmissionBC {

	 /**
	 * 멕시코 세관 Manifest 전송을 위해 조회한다.
	 * 
	 * @param CargoManifestCondForEdiVO cond
	 * @return CargoManifestListResultForEdiVO
	 * @throws EventException
	 */
	public CargoManifestListResultForEdiVO searchCargoManifestForEdi(CargoManifestCondForEdiVO cond) throws EventException;

	 /**
	 * 멕시코 세관신고 위해 FlatFile을 전송한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 * 
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVO, String pgmNo)  throws EventException;

	 /**
    * pod를 drop down으로 조회한다.<br>
	 * 
    * @param  CargoManifestCondForEdiVO cond
    * @return List<BkgComboVO>
    * @exception EventException
    */
   public List<BkgComboVO> searchManifestPodList (CargoManifestCondForEdiVO cond) throws EventException;
	
}