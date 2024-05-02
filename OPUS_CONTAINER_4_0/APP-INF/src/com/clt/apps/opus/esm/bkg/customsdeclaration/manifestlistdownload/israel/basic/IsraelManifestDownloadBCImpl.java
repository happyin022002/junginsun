/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : IsraelManifestDownloadBCImpl.java
 *@FileTitle : UI_BKG-1168
 *Open Issues :
 *Change history :
*@LastModifyDate : 2013.08.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.11 김보배
* 1.0 Creation
* ------------------------------------------------------
* History
* 2013.09.06 김보배 [CHM-201325976] Israel FROB 신고 결과 조회 화면 생성 요청
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration.IsraelManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelRcvHisCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelSearchRcvHisVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author BOBAE KIM
 * @see EventResponse,IsraelCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class IsraelManifestDownloadBCImpl extends BasicCommandSupport implements IsraelManifestDownloadBC {
	// Database Access Object
	private transient IsraelManifestListDownloadDBDAO dbDao = null;

	/**
	 * IsraelManifestDownloadBCImpl 객체 생성<br>
	 * IsraelManifestDownloadBCImpl 생성한다.<br>
	 */
	public IsraelManifestDownloadBCImpl() {
		dbDao = new IsraelManifestListDownloadDBDAO();
	}
	
	
	/**
	 * 입력된 VVD 가 이스라엘을 거치는지 아닌지 VVD schedule 을 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return String skdFlg
	 * @throws EventException
	 */
	public String searchVesselSchedule(ManifestListCondVO manifestListCondVO) throws EventException {
		
		IsraelManifestListCondVO israelManifestListCondVO = (IsraelManifestListCondVO) manifestListCondVO;
		String skdFlg = "";
		
		try {
			skdFlg = dbDao.searchVesselSchedule(israelManifestListCondVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return skdFlg;

	}
	

	/**
	 * 조회 이벤트 처리<br>
	 * CustomsDeclaration화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		IsraelManifestListCondVO israelManifestListCondVO = (IsraelManifestListCondVO) manifestListCondVO;

		List<IsraelManifestListBlInfoVO> israelManifestListBlInfoVOs = null;

		IsraelManifestListVO israelManifestListVO = new IsraelManifestListVO();
		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();

		try {
			israelManifestListBlInfoVOs = dbDao.searchCustomsBlInfo(israelManifestListCondVO);

			israelManifestListVO.setIsraelManifestListBlInfoVOs(israelManifestListBlInfoVOs);
			manifestListDetailVO.add((ManifestListDetailVO) israelManifestListVO);

			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/////////////////////////////////////////// history 화면 //////////////////////////////////////////////////
	/////////////////////////////////////////// history 화면 //////////////////////////////////////////////////
	/**
	 * 이스라엘 수신 히스토리를 조회한다.
	 * 
	 * @param IsraelRcvHisCondVO israelRcvHisCondVO
	 * @return List<IsraelSearchRcvHisVO>
	 * @exception EventException
	 */
	public List<IsraelSearchRcvHisVO> searchRcvHis(IsraelRcvHisCondVO israelRcvHisCondVO) throws EventException {

		try {
			return dbDao.searchRcvHis(israelRcvHisCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	/////////////////////////////////////////// history 화면 //////////////////////////////////////////////////
	/////////////////////////////////////////// history 화면 //////////////////////////////////////////////////
	
}
