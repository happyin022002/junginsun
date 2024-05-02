/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MalaysiaManifestDownloadBCImpl.java
 *@FileTitle : UI_BKG-1141
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.07
 *@LastModifier : 변종건
 *@LastVersion : 1.0
 * 2012.02.07 변종건
 * 1.0 Creation
 * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.integration.MalaysiaManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListVO;
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
 * @see EventResponse,MalaysiaCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class MalaysiaManifestDownloadBCImpl extends ManifestListDownloadBCImpl {
	// Database Access Object
	private transient MalaysiaManifestListDownloadDBDAO dbDao = null;

	/**
	 * MalaysiaManifestDownloadBCImpl 객체 생성<br>
	 * MalaysiaManifestDownloadBCImpl 생성한다.<br>
	 */
	public MalaysiaManifestDownloadBCImpl() {
		dbDao = new MalaysiaManifestListDownloadDBDAO();
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
		MalaysiaManifestListCondVO malaysiaManifestListCondVO = (MalaysiaManifestListCondVO) manifestListCondVO;

		List<MalaysiaManifestListBlInfoVO> malaysiaManifestListBlInfoVOs = null;
		List<MalaysiaManifestListCntrInfoVO> malaysiaManifestListCntrInfoVOs = null;

		MalaysiaManifestVslInfoVO malaysiaManifestVslInfoVO;
		MalaysiaManifestListVO malaysiaManifestListVO = new MalaysiaManifestListVO();
		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();

		try {
			malaysiaManifestVslInfoVO       = dbDao.searchShipCallNoVslId(malaysiaManifestListCondVO);
			malaysiaManifestListBlInfoVOs   = dbDao.searchCustomsBlInfo(malaysiaManifestListCondVO);
			malaysiaManifestListCntrInfoVOs = dbDao.searchCustomsCNTRInfo(malaysiaManifestListCondVO);

			malaysiaManifestListVO.setMalaysiaManifestVslInfoVO(malaysiaManifestVslInfoVO);
			malaysiaManifestListVO.setMalaysiaManifestListBlInfoVOs(malaysiaManifestListBlInfoVOs);
			malaysiaManifestListVO.setMalaysiaManifestListCntrInfoVOs(malaysiaManifestListCntrInfoVOs);
			manifestListDetailVO.add((ManifestListDetailVO) malaysiaManifestListVO);

			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
}
