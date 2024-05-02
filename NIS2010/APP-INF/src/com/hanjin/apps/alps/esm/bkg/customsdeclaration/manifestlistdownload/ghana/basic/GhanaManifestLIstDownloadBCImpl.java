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

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.integration.GhanaManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.vo.GhanaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.vo.GhanaSearchManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.vo.GhanaSearchVesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author BOBAE KIM
 * @see EventResponse,GhanaManifestLIstDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class GhanaManifestLIstDownloadBCImpl extends ManifestListDownloadBCImpl {
	// Database Access Object
	private transient GhanaManifestListDownloadDBDAO dbDao = null;

	/**
	 * GhanaManifestLIstDownloadBCImpl 객체 생성<br>
	 * GhanaManifestLIstDownloadBCImpl 생성한다.<br>
	 */
	public GhanaManifestLIstDownloadBCImpl() {
		dbDao = new GhanaManifestListDownloadDBDAO();
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
		GhanaSearchManifestListVO ghanaSearchManifestListVO = (GhanaSearchManifestListVO) manifestListCondVO;

		List<GhanaSearchVesselVO> ghanaSearchVesselVOs = null;
		List<GhanaSearchManifestListVO> ghanaSearchManifestListVOs = null;

		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();
		GhanaContainerVO ghanaContainerVO = new GhanaContainerVO();
		GhanaSearchVesselVO ghanaSearchVesselVO = new GhanaSearchVesselVO();
		try {

			ghanaSearchVesselVO.setVvdCd(ghanaSearchManifestListVO.getVvdCd());
			ghanaSearchVesselVO.setPolCd(ghanaSearchManifestListVO.getPolCd());
			ghanaSearchVesselVO.setPodCd(ghanaSearchManifestListVO.getPodCd());

			ghanaSearchVesselVOs = dbDao.searchVessel(ghanaSearchVesselVO);
			ghanaSearchManifestListVOs = dbDao.searchManifestList(ghanaSearchManifestListVO);

			ghanaContainerVO.setGhanaSearchManifestListVOs(ghanaSearchManifestListVOs);
			ghanaContainerVO.setGhanaSearchVesselVOs(ghanaSearchVesselVOs);
			manifestListDetailVO.add((ManifestListDetailVO) ghanaContainerVO);

			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

	}

}
