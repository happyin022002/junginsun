/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsReportBCImpl.java
*@FileTitle : UI_BKG-0152 - Delivery Mode
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.integration.ChinaCustomsReportDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsChnDeModCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsChnDeModDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.DelModeListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaManifestListTransmitHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaTransmitHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.SearchLocationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaManifestSendDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CustomsReport Business Logic Basic Command implementation<br>
 * - ALPS-CustomsReport에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author charves
 * @see UI_BKG-0215EventResponse, CustomsReportBC 각 DAO클래스 참조
 * @since J2EE 1.6
 */
public class ChinaCustomsReportBCImpl extends BasicCommandSupport implements ChinaCustomsReportBC {

	private transient ChinaCustomsReportDBDAO dbDao = null;

	public ChinaCustomsReportBCImpl() {
		dbDao = new ChinaCustomsReportDBDAO();
	}

	/**
	 * 중국 DEL 지역별 운송 Mode를 조회한다.
	 * @param bkgCstmsChnDeModCondVO
	 * @return List<DelModeListVO>
	 * @throws EventException
	 */
	public List<DelModeListVO> searchDelMode(BkgCstmsChnDeModCondVO bkgCstmsChnDeModCondVO) throws EventException {

		try {
			// 조회 처리
			return dbDao.searchDelMode(bkgCstmsChnDeModCondVO);

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 중국 DEL 지역별 운송 Mode를 입력/수정/삭제한다.
	 *
	 * @param BkgCstmsChnDeModDetailVO[] bkgCstmsChnDeModDetailVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDelMode(BkgCstmsChnDeModDetailVO[] bkgCstmsChnDeModDetailVO, SignOnUserAccount account) throws EventException {

		try {
			List<BkgCstmsChnDeModDetailVO> insertVoList = new ArrayList<BkgCstmsChnDeModDetailVO>();
			List<BkgCstmsChnDeModDetailVO> updateVoList = new ArrayList<BkgCstmsChnDeModDetailVO>();
			List<BkgCstmsChnDeModDetailVO> deleteVoList = new ArrayList<BkgCstmsChnDeModDetailVO>();

			for( int i=0; i<bkgCstmsChnDeModDetailVO.length; i++) {
				if ( bkgCstmsChnDeModDetailVO[i].getIbflag().equals("I")) {
					bkgCstmsChnDeModDetailVO[i].setCreUsrId(account.getUsr_id());
					bkgCstmsChnDeModDetailVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(bkgCstmsChnDeModDetailVO[i]);
				} else if ( bkgCstmsChnDeModDetailVO[i].getIbflag().equals("U")) {
					bkgCstmsChnDeModDetailVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(bkgCstmsChnDeModDetailVO[i]);
				} else if ( bkgCstmsChnDeModDetailVO[i].getIbflag().equals("D")) {
					deleteVoList.add(bkgCstmsChnDeModDetailVO[i]);
				}
			}

			if ( insertVoList.size() > 0) {
				dbDao.addDelMode(insertVoList);
			}

			if ( updateVoList.size() > 0) {
				dbDao.modifyDelMode(updateVoList);
			}

			if ( deleteVoList.size() > 0) {
				dbDao.removeDelMode(deleteVoList);
			}

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), ex);
		}
	}


	/**
	 * 중국세관에 EDI를 통해 전송한 메시지 내역을 조회한다.<br>
	 *
	 * @param transmitHistCondVO TransmitHistCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchTransmitHist(TransmitHistCondVO  transmitHistCondVO) throws EventException {
		ChinaTransmitHistCondVO chinaTransmitHistCondVO =(ChinaTransmitHistCondVO) transmitHistCondVO;
		List<ChinaManifestListTransmitHistDetailVO> chinaManifestListTransmitHistDetailVOs = null;
		List<ManifestListDetailVO> manifestListDetailVOs = null;

		try {
			chinaTransmitHistCondVO.setStartSndDt(chinaTransmitHistCondVO.getStartSndDt() +" "+chinaTransmitHistCondVO.getStartSndDt2());
			chinaTransmitHistCondVO.setEndSndDt(chinaTransmitHistCondVO.getEndSndDt() +" "+chinaTransmitHistCondVO.getEndSndDt2());
			chinaManifestListTransmitHistDetailVOs = dbDao.searchChinaManifestSendList(chinaTransmitHistCondVO);

			manifestListDetailVOs =(List<ManifestListDetailVO>) (Object) chinaManifestListTransmitHistDetailVOs;
			return  manifestListDetailVOs;

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 중국세관 POD, DEL Validation 을 체크한다.<br>
	 *
	 * @param searchLocationVO
	 * @return String searchLocation
	 * @throws EventException
	 */
	@Override
	public String searchLocation(SearchLocationVO searchLocationVO) throws EventException {

		try {
			// 조회 처리
			return dbDao.searchLocation(searchLocationVO);

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관에 EDI를 통해 전송한 메시지 내역을 조회한다.<br>
	 *
	 * @param String ediRefId
	 * @param String podCd
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchChinaSendDetailList(String ediRefId, String podCd) throws EventException {
		List<ChinaManifestSendDetailListVO> chinaManifestSendDetailListVOs = null;
		List<ManifestListDetailVO> manifestListDetailVOs = null;

		try {
			chinaManifestSendDetailListVOs = dbDao.searchChinaSendDetailList(ediRefId, podCd);

			manifestListDetailVOs =(List<ManifestListDetailVO>) (Object) chinaManifestSendDetailListVOs;
			return  manifestListDetailVOs;

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), ex);
		}
	}

}

