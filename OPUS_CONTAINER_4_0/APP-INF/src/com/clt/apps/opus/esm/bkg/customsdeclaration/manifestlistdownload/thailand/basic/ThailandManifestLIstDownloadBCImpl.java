/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GhanaManifestLIstDownloadBCImpl.java
 *@FileTitle : Ghana Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.12
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.04.12 김보배
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.integration.ThailandManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-ThailandManifestLIstDownload Business Logic Command implementation<br>
 * - OPUS-ThailandManifestLIstDownload handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class ThailandManifestLIstDownloadBCImpl extends BasicCommandSupport implements ThailandManifestLIstDownloadBC {

	/**
	 *  Database Access Object
	 */
	private transient ThailandManifestListDownloadDBDAO dbDao = null;

	public ThailandManifestLIstDownloadBCImpl(){
		dbDao = new ThailandManifestListDownloadDBDAO();
	}

	/**
	 * Thailand 세관 신고용 VVD 정보 조회
	 *
	 * @param cstmsVvdInfoCondVO
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<CstmsVvdInfoVO> searchCstmsVvdInfo(CstmsVvdInfoCondVO cstmsVvdInfoCondVO) throws EventException {

		List<CstmsVvdInfoVO> thailandVvdInfoVOs = null;

		try {
			thailandVvdInfoVOs = dbDao.searchCstmsVvdInfo( (ThailandVvdInfoCondVO)cstmsVvdInfoCondVO );
			return thailandVvdInfoVOs;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Thailand 세관 신고용 B/L LIST, CNTR LIST 정보 조회
	 *
	 * @param manifestListCondVO
	 * @return
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();

		ThailandManifestListCondVO thailandManifestListCondVO = (ThailandManifestListCondVO) manifestListCondVO;

		List<ThailandManifestListBlInfoVO> thailandManifestListBlInfoVOs = null;
		List<ThailandManifestListCntrInfoVO> thailandManifestListCntrInfoVOs = null;

		ThailandManifestListVO thailandManifestListVO = new ThailandManifestListVO();

		try {
			thailandManifestListBlInfoVOs = dbDao.searchCustomsBlInfo(thailandManifestListCondVO);
			thailandManifestListCntrInfoVOs = dbDao.searchCustomsCNTRInfo(thailandManifestListCondVO);

			thailandManifestListVO.setThailandManifestListBlInfoVOs(thailandManifestListBlInfoVOs);
			thailandManifestListVO.setThailandManifestListCntrInfoVOs(thailandManifestListCntrInfoVOs);
			manifestListDetailVO.add((ManifestListDetailVO) thailandManifestListVO);

			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
}
