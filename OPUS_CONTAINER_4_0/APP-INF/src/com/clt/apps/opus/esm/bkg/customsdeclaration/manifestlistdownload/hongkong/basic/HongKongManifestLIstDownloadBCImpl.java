/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : HongKongManifestLIstDownloadBCImpl.java
 *@FileTitle : UI_BKG-0282
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.integration.HongKongManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongSearchManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongSearchVesselVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongVesselCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-HongKongManifestLIstDownloadBC Business Logic Command implementation<br>
 * - OPUS-HongKongManifestLIstDownloadBC handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class HongKongManifestLIstDownloadBCImpl extends BasicCommandSupport implements HongKongManifestLIstDownloadBC {
	// Database Access Object
	private transient HongKongManifestListDownloadDBDAO dbDao = null;

	/**
	 * HongKongManifestLIstDownloadBCImpl object creation<br>
	 * HongKongManifestLIstDownloadBCImpl creation<br>
	 */
	public HongKongManifestLIstDownloadBCImpl() {
		dbDao = new HongKongManifestListDownloadDBDAO();
	}

	/**
	 * retrieve event handling<br>
	 * retrieve event handling about CustomsDeclaration screen<br>
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		HongKongManifestListCondVO hongKongManifestListCondVO = (HongKongManifestListCondVO) manifestListCondVO;

		List<HongKongSearchVesselVO> hongKongSearchVesselVOs = null;
		List<HongKongSearchManifestListVO> hongKongSearchManifestListVOs = null;

		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();
		HongKongContainerVO hongKongContainerVO = new HongKongContainerVO();
		HongKongVesselCondVO hongKongVesselCondVO = new HongKongVesselCondVO();
		try {

			hongKongVesselCondVO.setVslCd(hongKongManifestListCondVO.getVslCd());
			hongKongVesselCondVO.setSkdDirCd(hongKongManifestListCondVO.getSkdDirCd());
			hongKongVesselCondVO.setSkdVoyNo(hongKongManifestListCondVO.getSkdVoyNo());
			hongKongVesselCondVO.setPolCd(hongKongManifestListCondVO.getPolCd());
			hongKongVesselCondVO.setPodCd(hongKongManifestListCondVO.getPodCd());
			hongKongVesselCondVO.setWhereQuery(hongKongManifestListCondVO.getWhereQuery());

			hongKongSearchVesselVOs = dbDao.searchVessel(hongKongVesselCondVO);
			hongKongSearchManifestListVOs = dbDao.searchManifestList(hongKongManifestListCondVO);

			hongKongContainerVO.setHongKongSearchManifestListVOs(hongKongSearchManifestListVOs);
			hongKongContainerVO.setHongKongSearchVesselVOs(hongKongSearchVesselVOs);
			manifestListDetailVO.add((ManifestListDetailVO) hongKongContainerVO);

			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

	}

}
