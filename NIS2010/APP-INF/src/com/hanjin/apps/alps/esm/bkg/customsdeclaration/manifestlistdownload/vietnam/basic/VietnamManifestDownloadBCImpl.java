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

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.integration.VietnamManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListSecondBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListVO;
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
public class VietnamManifestDownloadBCImpl extends ManifestListDownloadBCImpl {
	// Database Access Object
	private transient VietnamManifestListDownloadDBDAO dbDao = null;

	/**
	 * VietnamManifestDownloadBCImpl 객체 생성<br>
	 * VietnamManifestDownloadBCImpl 생성한다.<br>
	 */
	public VietnamManifestDownloadBCImpl() {
		dbDao = new VietnamManifestListDownloadDBDAO();
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
		VietnamManifestListCondVO vietnamManifestListCondVO = (VietnamManifestListCondVO) manifestListCondVO;

		List<VietnamManifestListBlInfoVO> vietnamManifestListBlInfoVOs = null;
		

		VietnamManifestListVO vietnamManifestListVO = new VietnamManifestListVO();
		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();

		try {
			vietnamManifestListBlInfoVOs = dbDao.searchCustomsBlInfo(vietnamManifestListCondVO);
			vietnamManifestListVO.setVietnamManifestListBlInfoVOs(vietnamManifestListBlInfoVOs);
			
			manifestListDetailVO.add((ManifestListDetailVO) vietnamManifestListVO);

			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * 조회 및 엑셀다운2 이벤트 처리<br>
	 * CustomsDeclaration화면에 대한 조회 및 엑셀다운2 이벤트 처리<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<VietnamManifestListSecondBlInfoVO>
	 * @exception EventException
	 */
	public List<VietnamManifestListSecondBlInfoVO> searchManifestExcelList(ManifestListCondVO manifestListCondVO) throws EventException {
		VietnamManifestListCondVO vietnamManifestListCondVO = (VietnamManifestListCondVO) manifestListCondVO;

//		List<VietnamManifestListSecondBlInfoVO> vietnamManifestListSecondBlInfoVOs = null;
		

		VietnamManifestListVO vietnamManifestListVO = new VietnamManifestListVO();
		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();

		try {
			List<VietnamManifestListSecondBlInfoVO> vietnamManifestListSecondBlInfoVOs = dbDao.searchManifestExcelList(vietnamManifestListCondVO);
//			vietnamManifestListVO.setVietnamManifestListBlInfoVOs(vietnamManifestListBlInfoVOs);
//			
//			manifestListDetailVO.add((ManifestListDetailVO) vietnamManifestListVO);

			return vietnamManifestListSecondBlInfoVOs;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
}
