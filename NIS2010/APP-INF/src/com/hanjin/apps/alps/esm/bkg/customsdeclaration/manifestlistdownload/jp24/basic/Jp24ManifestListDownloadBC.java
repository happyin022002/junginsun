/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : Jp24ManifestListDownloadBC.java
*@FileTitle : Jp24ManifestListDownloadBC
*Open Issues :
*Change history :
*	2017.09.07 하대성 2017 Renewal Version Transmit 반영
*@LastModifyDate : 2017.09.07
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2013.06.28 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.DepartureTimeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.ErrorReportVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.FlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.GetMdmCustomerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.JmsReportVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Jp24ManifestListDownload Business Logic Command Interface<br>
 * - ALPS-Jp24ManifestListDownload 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Jp24ManifestListDownloadBCImpl 참조
 * @since J2EE 1.6
 */
public interface Jp24ManifestListDownloadBC {

	/**
	 * [ESM_BKG_1501]
	 * Advance Cargo Information Download & Transmit - Header 목록 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @return List<CargoInfoHeaderVO>
	 * @exception EventException
	 */
	public List<CargoInfoHeaderVO> searchCargoInfoHeader(CargoInfoHeaderVO cargoInfoHeaderVO) throws EventException;

	/**
	 * BackEndJob공통 - Back End Job Status 조회
	 *  (동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용)<br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & Transmit - Detail 목록 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobSearchCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, SignOnUserAccount account);

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 결과
	 * Advance Cargo Information Download & Transmit - Detail 목록 조회<br>
	 *
	 * @param String backEndJobKey
	 * @return List<CargoInfoDetailVO>
	 * @exception EventException
	 */
	public List<CargoInfoDetailVO> resultBackEndJobSearchCargoInfoDetail(String backEndJobKey) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1501]
	 * VSL_CD로 Call Sing No.를 조회<br>
	 *
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String getCallSignByVsl(String vslCd) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & Transmit - Detail 목록 저장<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param CargoInfoDetailVO[] cargoInfoDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobManageCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, CargoInfoDetailVO[] cargoInfoDetailVOs, SignOnUserAccount account);

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 결과
	 * Advance Cargo Information Download & Transmit - Detail 목록 저장<br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobManageCargoInfoDetail(String backEndJobKey) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & Transmit - Detail 목록 EDI 전송<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param CargoInfoDetailVO[] cargoInfoDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobTransmitCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, CargoInfoDetailVO[] cargoInfoDetailVOs, SignOnUserAccount account);

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & Transmit - Detail 목록 EDI 전송<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param CargoInfoDetailVO[] cargoInfoDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobTransmitCargoInfoDetailRenewal2017(CargoInfoHeaderVO cargoInfoHeaderVO, CargoInfoDetailVO[] cargoInfoDetailVOs, SignOnUserAccount account);
	
	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 결과
	 * Advance Cargo Information Download & Transmit - Detail 목록 EDI 전송<br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobTransmitCargoInfoDetail(String backEndJobKey) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1501] Mail Send
	 * E-Mail전송과 ADV_JP_BL테이블의 USR_EML컬럼정보 수정<br>
	 *
	 * @param CargoInfoHeaderVO headerVO
	 * @param CargoInfoDetailVO[] detailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSendEmailCargoInfoDetail(CargoInfoHeaderVO headerVO, CargoInfoDetailVO[] detailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpBlVO>
	 * @exception EventException
	 */
	public List<AdvJpBlVO> searchBLInquiry(AdvJpBlVO advJpBlVO) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR)의 Tab2에 해당하는 Container목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpContainerVO>
	 * @exception EventException
	 */
	public List<AdvJpContainerVO> searchBLInquiryContainer(AdvJpBlVO advJpBlVO) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR)의 Tab3에 해당하는 Mark & Desc목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpMarkDescVO>
	 * @exception EventException
	 */
	public List<AdvJpMarkDescVO> searchBLInquiryMarkDesc(AdvJpBlVO advJpBlVO) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1502]
	 * Customer입력창에서 버튼클릭 시 MDM_CUSTOMER 정보 조회<br>
	 *
	 * @param GetMdmCustomerVO getMdmCustomerVO
	 * @return List<GetMdmCustomerVO>
	 * @exception EventException
	 */
	public List<GetMdmCustomerVO> getMdmCustomer(GetMdmCustomerVO getMdmCustomerVO) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 저장<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @param AdvJpContainerVO[] advJpContainerVOs
	 * @param AdvJpMarkDescVO[] advJpMarkDescVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBLInquiry(AdvJpBlVO advJpBlVO, AdvJpContainerVO[] advJpContainerVOs, AdvJpMarkDescVO[] advJpMarkDescVOs, SignOnUserAccount account) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1502] Back End Job 시작
	 * B/L Inquiry(Japan 24HR) EDI 전송<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobTransmitBLInquiry(AdvJpBlVO advJpBlVO, SignOnUserAccount account);

	/**
	 * JP24 : [ESM_BKG_1502] Back End Job 시작
	 * B/L Inquiry(Japan 24HR) New_EDI 전송<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobTransmitBLInquiryRenewal2017(AdvJpBlVO advJpBlVO, SignOnUserAccount account);

	
	/**
	 * JP24 : [ESM_BKG_1502] Back End Job 결과
	 * B/L Inquiry(Japan 24HR) EDI 전송<br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobTransmitBLInquiry(String backEndJobKey) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1503]
	 * Departure Time Registration 조회<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @return List<DepartureTimeVO>
	 * @exception EventException
	 */
	public List<DepartureTimeVO> searchDepartureTime(DepartureTimeVO departureTimeVO) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1503], [BATCH]
	 * Departure Time Registration EDI 전송<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @exception EventException
	 */
	public void transmitDepartureTime(DepartureTimeVO departureTimeVO) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1504]
	 * JMS Report 목록 조회<br>
	 *
	 * @param JmsReportVO jmsReportVO
	 * @return List<JmsReportVO>
	 * @exception EventException
	 */
	public List<JmsReportVO> searchJmsReport(JmsReportVO jmsReportVO) throws EventException;

	/**
	 * JP24 : [UDEV_ALPSBKG_T_JPN24]
	 * 일본세관에서 송신한 EDI메세지를 수신 처리<br>
	 *
	 * @param String flatFile
	 * @exception EventException
	 */
	public void receiveEDIForJapan24HR(String flatFile) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1505]
	 * Transmit Result Error Report 목록 조회<br>
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<ErrorReportVO>
	 * @exception EventException
	 */
	public List<ErrorReportVO> searchErrorReport(ErrorReportVO errorReportVO) throws EventException;

	/**
	 * JP24 : [ESM_BKG_1506]
	 * Send FlatFile 조회<br>
	 *
	 * @param FlatFileVO flatFileVO
	 * @return List<FlatFileVO>
	 * @exception EventException
	 */
	public List<FlatFileVO> searchSendFlatFile(FlatFileVO flatFileVO) throws EventException;

}
