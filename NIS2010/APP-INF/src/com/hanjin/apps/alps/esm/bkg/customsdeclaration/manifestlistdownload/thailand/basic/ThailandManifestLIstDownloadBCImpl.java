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

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.integration.ThailandManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
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
public class ThailandManifestLIstDownloadBCImpl extends ManifestListDownloadBCImpl {

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
