/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestListDownloadBCImpl.java
*@FileTitle : ChinaManifestListDownloadBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.25 이수빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TransKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaVslRgstVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ChinaManifestListDownload Business Logic Basic Command Interface<br>
 * - OPUS-ChinaManifestListDownload 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public interface ChinaManifestListDownloadBC {

	/**
	 * 세관에 신고할 대상 Manifest 정보(Download 받을 데이터) 를 조회한다.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * 세관에 적하목록을 신고하기 위해 B/L Manifest 정보를 세관 테이블로 다운받는 작업을 BackEndJob으로 등록한다.<br>
	 *
	 * @param manifestListDetailVOs ManifestListDetailVO[]
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 세관에 신고할 대상 Manifest 정보(CSV 저장용 데이터) 를 조회한 후<br>
	 * 서버에.CSV  파일생성해서 로컬로 다운로드<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return String
	 * @exception EventException
	 */
	public String downloadManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * 세관 테이블에 Customer, Container 등의 B/L 정보를 등록, 수정, 삭제한다
	 *
	 * @param ChinaBlInfoVO chinaBlInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBlInfo(ChinaBlInfoVO chinaBlInfoVO, SignOnUserAccount account) throws EventException;

	/**
	 * 세관 테이블의 Customer, Container 등의 BL 정보를 삭제한다
	 *
	 * @param ChinaBlInfoListVO[] chinaBlInfoListVOs
	 * @exception EventException
	 */
	public void manageBlByVvd(ChinaBlInfoListVO[] chinaBlInfoListVOs) throws EventException;

	/**
	 * B/L 정보를 수정한다.<br>
	 *
	 * @param List<TransKeyVO> transKeyVOs
	 * @exception EventException
	 */
	public void modifyBl(List<TransKeyVO> transKeyVOs) throws EventException;

	/**
	 * B/L 테이블에 전송 내역 데이터를 업데이트한다.<br>
	 *
	 * @param List<TransKeyVO> transKeyVOs
	 * @param String pol
	 * @exception EventException
	 */
	public void modifyBl2(List<TransKeyVO> transKeyVOs, String pol) throws EventException;

	/**
	 * VVD 테이블에 전송 내역 데이터를 업데이트한다.<br>
	 *
	 * @param TransKeyVO transKeyVO
	 * @param String pol
	 * @exception EventException
	 */
	public void modifyVvd(TransKeyVO transKeyVO, String pol) throws EventException;

	/**
	 * CHINA 24HR : [ESM_BKG_1508]
	 * Vessel Registration 목록 조회<br>
	 *
	 * @param ChinaVslRgstVO chinaVslRgstVO
	 * @return List<VslRgstVO>
	 * @exception EventException
	 */
	public List<ChinaVslRgstVO> searchChinaVslRgst(ChinaVslRgstVO chinaVslRgstVO) throws EventException;

	/**
	 * CHINA 24HR : [ESM_BKG_1508]
	 * Vessel Registration 목록 저장<br>
	 *
	 * @param ChinaVslRgstVO chinaVslRgstVO
	 * @param ChinaVslRgstVO[] chinaVslRgstVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageChinaVslRgst(ChinaVslRgstVO chinaVslRgstVO, ChinaVslRgstVO[] chinaVslRgstVOs, SignOnUserAccount account) throws EventException;

}

