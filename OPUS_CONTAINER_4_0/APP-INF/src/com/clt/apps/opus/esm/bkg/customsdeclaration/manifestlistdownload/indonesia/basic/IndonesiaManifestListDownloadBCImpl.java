/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IndonesiaManifestListDownloadBCImpl.java
 *@FileTitle : UI_BKG-0311
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.integration.IndonesiaManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaSearchManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.indonesiaBkgDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - Retrieving &  modifying Indonesian Customs transmitting data.<br>
 * 
 * @author JI-YOUNG JANG
 * @see referencing to the each DAO Class EventResponse,IndonesiaManifestListDownloadBC
 * 
 * @since J2EE 1.4
 */
public class IndonesiaManifestListDownloadBCImpl extends BasicCommandSupport implements IndonesiaManifestListDownloadBC {
	// Database Access Object
	private transient IndonesiaManifestListDownloadDBDAO dbDao = null;

	/**
	 * Creating object IndonesiaManifestListDownloadBCImpl<br>
	 * Creating IndonesiaManifestListDownloadBCImpl.<br>
	 */
	public IndonesiaManifestListDownloadBCImpl() {
		dbDao = new IndonesiaManifestListDownloadDBDAO();
	}

	/**
	 * Handling inquiry event<br>
	 * Retrieving Indonesian Customs transmitting data<br>
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
	 * Retrieving for Booking No input
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
