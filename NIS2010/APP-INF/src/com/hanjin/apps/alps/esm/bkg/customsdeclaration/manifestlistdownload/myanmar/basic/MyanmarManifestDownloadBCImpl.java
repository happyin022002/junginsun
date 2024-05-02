/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MalaysiaManifestDownloadBCImpl.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
 * 2012.11.19 윤태승
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.integration.MyanmarManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * NIS2010-Myanmar Customs Manifest Business Logic Basic Command implementation<br>
 * - NIS2010-Myanmar Customs Manifest에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Tae Seung Yun
 * @see EventResponse,MalaysiaCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class MyanmarManifestDownloadBCImpl extends ManifestListDownloadBCImpl {
	// Database Access Object
	private transient MyanmarManifestListDownloadDBDAO dbDao = null;

	/**
	 * MalaysiaManifestDownloadBCImpl 객체 생성<br>
	 * MalaysiaManifestDownloadBCImpl 생성한다.<br>
	 */
	public MyanmarManifestDownloadBCImpl() {
		dbDao = new MyanmarManifestListDownloadDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Myanmar Customs Manifest 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		MyanmarManifestListCondVO myanmarManifestListCondVO = (MyanmarManifestListCondVO) manifestListCondVO;

		List<MyanmarManifestListBlInfoVO> myanmarManifestListBlInfoVOs = null;
		

		MyanmarManifestListVO myanmarManifestListVO = new MyanmarManifestListVO();
		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();

		try {
			myanmarManifestListBlInfoVOs = dbDao.searchCustomsBlInfo(myanmarManifestListCondVO);
			myanmarManifestListVO.setMyanmarManifestListBlInfoVOs(myanmarManifestListBlInfoVOs);
			
			manifestListDetailVO.add((ManifestListDetailVO) myanmarManifestListVO);

			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
}
