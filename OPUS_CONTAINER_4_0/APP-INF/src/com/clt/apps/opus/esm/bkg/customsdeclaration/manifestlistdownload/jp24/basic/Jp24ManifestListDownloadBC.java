/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Jp24ManifestListDownloadBC.java
*@FileTitle : Jp24ManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier :
*@LastVersion : 1.0
* 2013.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BllSprtCmbnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.GetMdmCustomerVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Jp24ManifestListDownload Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImplclass
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
	 *(동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용) <br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException;

	/**
	 * [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & Transmit - Detail 목록 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobSearchCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_BKG_1501] Back End Job 결과
	 * Advance Cargo Information Download & Transmit - Detail 목록 조회<br>
	 *
	 * @param String backEndJobKey
	 * @return List<CargoInfoDetailVO>
	 * @exception EventException
	 */
	public List<CargoInfoDetailVO> resultBackEndJobSearchCargoInfoDetail(String backEndJobKey) throws EventException;

	/**
	 * [ESM_BKG_1501]
	 * VSL_CD로 Call Sing No.를 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] getCallSignByVsl(CargoInfoHeaderVO cargoInfoHeaderVO) throws EventException;

	/**
	 * [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & Transmit - Detail 목록 저장<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param CargoInfoDetailVO[] cargoInfoDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobManageCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, CargoInfoDetailVO[] cargoInfoDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_BKG_1501] Back End Job 결과
	 * Advance Cargo Information Download & Transmit - Detail 목록 저장<br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobManageCargoInfoDetail(String backEndJobKey) throws EventException;

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpBlVO>
	 * @exception EventException
	 */
	public List<AdvJpBlVO> searchBLInquiry(AdvJpBlVO advJpBlVO) throws EventException;

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 의 Tab2에 해당하는 Container목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpContainerVO>
	 * @exception EventException
	 */
	public List<AdvJpContainerVO> searchBLInquiryContainer(AdvJpBlVO advJpBlVO) throws EventException;

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 의 Tab3에 해당하는 Mark & Desc목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpMarkDescVO>
	 * @exception EventException
	 */
	public List<AdvJpMarkDescVO> searchBLInquiryMarkDesc(AdvJpBlVO advJpBlVO) throws EventException;

	/**
	 * [ESM_BKG_1502]
	 * Customer입력창에서 버튼클릭 시 MDM_CUSTOMER 정보 조회<br>
	 *
	 * @param GetMdmCustomerVO getMdmCustomerVO
	 * @return List<GetMdmCustomerVO>
	 * @exception EventException
	 */
	public List<GetMdmCustomerVO> getMdmCustomer(GetMdmCustomerVO getMdmCustomerVO) throws EventException;

	/**
	 * [ESM_BKG_1502]
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
	 * [ESM_BKG_1526]
	 * Association B/L Separate - Original B/L 조회
	 *
	 * @param BllSprtCmbnVO bllSprtCmbnVO
	 * @return List<BllSprtCmbnVO>
	 * @exception EventException
	 */
	public List<BllSprtCmbnVO> searchOrgBlForBll(BllSprtCmbnVO bllSprtCmbnVO) throws EventException;

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - New B/L 목록 조회
	 *
	 * @param String bllSndStsCd
	 * @param BllSprtCmbnVO bllSprtCmbnVO
	 * @return List<BllSprtCmbnVO>
	 * @exception EventException
	 */
	public List<BllSprtCmbnVO> searchNewBlForBll(String bllSndStsCd, BllSprtCmbnVO bllSprtCmbnVO) throws EventException;

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - New B/L 단건 조회
	 *
	 * @param BllSprtCmbnVO bllSprtCmbnVO
	 * @return List<BllSprtCmbnVO>
	 * @exception EventException
	 */
	public List<BllSprtCmbnVO> searchNewBlForBllRowSearch(BllSprtCmbnVO bllSprtCmbnVO) throws EventException;

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - New B/L 목록 저장<br>
	 *
	 * @param BllSprtCmbnVO[] bllSprtCmbnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBllSeparate(BllSprtCmbnVO[] bllSprtCmbnVOs, SignOnUserAccount account) throws EventException;


}
