/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PakistanManifestLIstDownloadBCImpl.java
 *@FileTitle : Pakistan Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.18
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.07.18 김보배
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2012.08.31 김보배 [CHM-201219908] [BKG] Pakistan Manifest 기능 보완 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration.PakistanManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanCNTRInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanVesselVO;
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
 * @see EventResponse,PakistanManifestLIstDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PakistanManifestLIstDownloadBCImpl extends ManifestListDownloadBCImpl {

	/**
	 *  Database Access Object
	 */
	private transient PakistanManifestListDownloadDBDAO dbDao = null;

	public PakistanManifestLIstDownloadBCImpl(){
		dbDao = new PakistanManifestListDownloadDBDAO();		
	}

	
	/**
	 * 파키스탄 세관 - VVD, B/L, CNTR 정보 조회
	 * 
	 * @param manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {

		PakistanManifestListCondVO pakistanManifestListCondVO = (PakistanManifestListCondVO) manifestListCondVO;

		List<PakistanVesselVO> pakistanVesselVOs = null;
		List<PakistanCNTRInfoVO> pakistanCNTRInfoVOs = null;
		List<PakistanBlInfoVO> pakistanBlInfoVOs = null;
		List<PakistanBlInfoVO> pakistanChargeInfoVOs = null;

		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();
		PakistanManifestListVO pakistanManifestListVO = new PakistanManifestListVO();
		PakistanVesselVO pakistanVesselVO = new PakistanVesselVO();
		try {

			pakistanVesselVO.setVvdCd(pakistanManifestListCondVO.getVvdCd());
			pakistanVesselVO.setPolCd(pakistanManifestListCondVO.getPolCd());
			pakistanVesselVO.setPodCd(pakistanManifestListCondVO.getPodCd());

			pakistanVesselVOs = dbDao.searchVessel(pakistanVesselVO);
			pakistanBlInfoVOs = dbDao.searchBlInfo(pakistanManifestListCondVO);
			pakistanCNTRInfoVOs = dbDao.searchCNTRInfo(pakistanManifestListCondVO);
			pakistanChargeInfoVOs = dbDao.searchChargeInfo(pakistanManifestListCondVO);

			pakistanManifestListVO.setPakistanBlInfoVOs(pakistanBlInfoVOs);
			pakistanManifestListVO.setPakistanCNTRInfoVOs(pakistanCNTRInfoVOs);
			pakistanManifestListVO.setPakistanVesselVOs(pakistanVesselVOs);
			pakistanManifestListVO.setPakistanChargeInfoVOs(pakistanChargeInfoVOs);
			manifestListDetailVO.add((ManifestListDetailVO) pakistanManifestListVO);

			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

	}
	
	
}
