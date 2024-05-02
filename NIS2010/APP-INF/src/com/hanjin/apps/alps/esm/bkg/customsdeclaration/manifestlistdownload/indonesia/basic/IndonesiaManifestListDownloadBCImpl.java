/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IndonesiaManifestListDownloadBCImpl.java
 *@FileTitle : UI_BKG-0311
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.29
 *@LastModifier : 장지영
 *@LastVersion : 1.0
 * 2009.09.29 장지영
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.integration.IndonesiaManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaSearchManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.indonesiaBkgDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - 인도네시아 세관 전송 대상 데이터를 조회 및 수정한다.<br>
 * 
 * @author JI-YOUNG JANG
 * @see EventResponse,IndonesiaManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class IndonesiaManifestListDownloadBCImpl extends ManifestListDownloadBCImpl {
	// Database Access Object
	private transient IndonesiaManifestListDownloadDBDAO dbDao = null;

	/**
	 * IndonesiaManifestListDownloadBCImpl 객체 생성<br>
	 * IndonesiaManifestListDownloadBCImpl 생성한다.<br>
	 */
	public IndonesiaManifestListDownloadBCImpl() {
		dbDao = new IndonesiaManifestListDownloadDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * 인도네시아 세관 전송 대상 데이터 조회<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		IndonesiaManifestListCondVO indonesiaManifestListCondVO = (IndonesiaManifestListCondVO) manifestListCondVO;

		List<IndonesiaSearchManifestListVO> indonesiaSearchManifestListVOs = null;

		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();
		IndonesiaContainerVO indonesiaContainerVO = new IndonesiaContainerVO();
		String mfTpCd = "";
		try {
			mfTpCd = indonesiaManifestListCondVO.getMfTpCd();
			if ( mfTpCd.equals("01I") || mfTpCd.equals("09E") || mfTpCd.equals("10E") )
				indonesiaSearchManifestListVOs = dbDao.searchManifestListByOpt01(indonesiaManifestListCondVO);
			else if ( mfTpCd.equals("02I") || mfTpCd.equals("04E") )
				indonesiaSearchManifestListVOs = dbDao.searchManifestListByOpt02(indonesiaManifestListCondVO);	
			else if ( mfTpCd.equals("03I") || mfTpCd.equals("05E") )
				indonesiaSearchManifestListVOs = dbDao.searchManifestListByOpt03(indonesiaManifestListCondVO);		
			else if ( mfTpCd.equals("04I") || mfTpCd.equals("08X") )
				indonesiaSearchManifestListVOs = dbDao.searchManifestListByOpt04(indonesiaManifestListCondVO);			

			indonesiaContainerVO.setIndonesiaSearchManifestListVOs(indonesiaSearchManifestListVOs);
			manifestListDetailVO.add((ManifestListDetailVO) indonesiaContainerVO);

			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Booking No 입력을 위한 조회
	 * 
	 * @param IndonesiaManifestListCondVO indonesiaManifestListCondVO
	 * @return List<indonesiaBkgDetailVO>
	 * @throws EventException
	 */
	public List<indonesiaBkgDetailVO> searchBkgInfo(IndonesiaManifestListCondVO indonesiaManifestListCondVO)
			throws EventException {

		try {

			return dbDao.searchBkgInfo((IndonesiaManifestListCondVO) indonesiaManifestListCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}


}
