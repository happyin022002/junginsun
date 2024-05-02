/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : HongKongManifestLIstDownloadBCImpl.java
 *@FileTitle : UI_BKG-0282
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.integration.HongKongManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongSearchManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongSearchVesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongVesselCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author LIM JAE TAEK
 * @see EventResponse,RocsManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class HongKongManifestLIstDownloadBCImpl extends ManifestListDownloadBCImpl {
	// Database Access Object
	private transient HongKongManifestListDownloadDBDAO dbDao = null;

	/**
	 * HongKongManifestLIstDownloadBCImpl 객체 생성<br>
	 * HongKongManifestLIstDownloadBCImpl 생성한다.<br>
	 */
	public HongKongManifestLIstDownloadBCImpl() {
		dbDao = new HongKongManifestListDownloadDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CustomsDeclaration화면에 대한 조회 이벤트 처리<br>
	 * 
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
