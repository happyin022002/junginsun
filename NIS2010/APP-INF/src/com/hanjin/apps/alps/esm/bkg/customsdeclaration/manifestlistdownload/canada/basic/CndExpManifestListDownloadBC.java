/*=========================================================
 *Copyright(c) SMLines. All Rights Reserved.
 *@FileName :  CndExpManifestListDownloadBC.java
 *@FileTitle : CndExpManifestListDownloadBC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ConatinerModificationtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * CndExpManifestListDownloadBC Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImplclass
 * @since J2EE 1.6
 */
public interface CndExpManifestListDownloadBC {

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회
	 *
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO, SignOnUserAccount account) throws EventException;

	/**
	 * Bkg_Cstms_Adv_Bl 의 mf_sts_cd = 'D'로 수정
	 *
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 해당 VVD에 존재하는 모든 B/L 정보 삭제
	 *
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @return String
	 * @throws EventException
	 */
	public String deleteManifest(ManifestListDetailVO[] manifestListDetailVOs) throws EventException;

	/**
	 * 해당 VVD에 존재하는 모든 B/L 정보 삭제
	 *
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @return String
	 * @throws EventException
	 */
	public String deleteManifestBl(ManifestListDetailVO[] manifestListDetailVOs) throws EventException;

	/**
	 * 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 생성, 수정, 삭제
	 *
	 * @param CstmsBlVO[] cstmsBlVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsBl(CstmsBlVO[] cstmsBlVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 수정 저장<br>
	 *
	 * @param CstmsManifestAmendmentVO[] CstmsManifestAmendmentVOs
	 * @param SignOnUserAccount account
	 * @param String CntCd
	 * @param String aiDiv
	 * @exception EventException
	 */
	public void manageCstmsAmendManifest(CstmsManifestAmendmentVO[] CstmsManifestAmendmentVOs, SignOnUserAccount account, String CntCd, String aiDiv) throws EventException;

	/**
	 * Hub정보취득
	 *
	 * @param podCd
	 * @param delCd
	 * @param podNodCd
	 * @return
	 * @throws EventException
	 */
	public String[] searchHubInfo(String podCd, String delCd, String podNodCd) throws EventException;

	/**
	 * B/L Inquiry화면에서 세관 신고를 위해 다운로드 받은 B/L을 B/L 단위로 조회<br>
	 *
	 * @param blCondVO 조회조건
	 * @return List<BlDetailVO>
	 * @throws EventException
	 */
	public List<BlDetailVO> inquiryBlData(BlCondVO blCondVO) throws EventException;

	/**
	 * Container 정보 조회
	 *
	 * @param ContainerListCondVO containerListCondVO
	 * @return List<ContainerListRsltVO>
	 * @exception EventException
	 */
	public List<ContainerListRsltVO> searchContainerList(ContainerListCondVO containerListCondVO) throws EventException;

	/**
	 * Container 정보 저장
	 *
	 * @param ContainerListRsltVO[] cntrListRsltVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageContainerList(ContainerListRsltVO[] cntrListRsltVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Container Manifest 정보를 조회
	 *
	 * @param ContainerManifestCondVO containerManifestCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchContainerManifest(ContainerManifestCondVO containerManifestCondVO) throws EventException;

	/**
	 * 전송대상 Container Manifest 데이터를 수정
	 *
	 * @param ConatinerModificationtVO[] containerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyContainerManifest(ConatinerModificationtVO[] containerVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 세관 신고용 VVD 정보 조회
	 *
	 * @param cstmsVvdInfoCondVO 조회조건
	 * @return List<CstmsVvdInfoVO>
	 * @throws EventException
	 */
	public List<CstmsVvdInfoVO> searchCstmsVvdInfo(CstmsVvdInfoCondVO cstmsVvdInfoCondVO) throws EventException;

	/**
	 * 세관 관련 VVD 정보 생성, 수정, 삭제
	 *
	 * @param cstmsVvdInfoVOs VVD 정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageCstmsVvdInfo(CstmsVvdInfoVO[] cstmsVvdInfoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 세관 신고용 VVD별 Max Reference No 조회
	 * Carrier Code와 상관없이 SML의 Carrier Code 918P로 조회한다. 
	 * @param cstmsVvdRefNoCondVO 조건
	 * @return CstmsVvdRefNoVO
	 * @throws EventException
	 */
	public CstmsVvdRefNoVO searchMaxCndCstmsVvdRefNo(CstmsVvdRefNoCondVO cstmsVvdRefNoCondVO) throws EventException;
	
	/**
	 * CRN 정보 조회
	 * @param CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO
	 * @return List<CndCstmsVslCrnNoVO>
	 * @throws EventException
	 */
	public List<CndCstmsVslCrnNoVO> searchBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws EventException;

	/**
	 * CRN 정보를 삭제한다..
	 * 
	 * @param cndCstmsVslCrnNoVO CRN정보
	 * @throws EventException
	 */
	public void removeBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws EventException;
	
	/**
	 * Customer, Container, Commodity(CM) 등의 BL 정보 조회/확인<br>
	 * 
	 * @param vesselArrivalCondVO 조회조건
	 * @return List<VesselArrivalDetailVO>
	 * @throws EventException
	 */
	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO)throws EventException;

	/**
	 * Customer, Container, Commodity(CM) 등의 BL 정보 조회/확인<br>
	 * 
	 * @param vesselArrivalCondVO 조회조건
	 * @return List<VesselArrivalDetailVO>
	 * @throws EventException
	 */
	public List<VesselArrivalDetailVO> searchVesselDeparture(VesselArrivalCondVO vesselArrivalCondVO) throws EventException;
	
	/**
	 * 세관 신고시 필요한 Vessel Arrival 정보를 수정한다.
	 * 
	 * @param vesselArrivalVO Vessel Arrival 정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException;	
}
