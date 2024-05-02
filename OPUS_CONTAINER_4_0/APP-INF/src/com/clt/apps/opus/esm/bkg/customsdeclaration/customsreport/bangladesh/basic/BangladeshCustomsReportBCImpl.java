/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BangadeshCustomsReportBCImpl.java
*@FileTitle : BangadeshCustomsReportBCImpl
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.integration.BangladeshCustomsReportDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.BangladeshCustCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.BkgCstmsBdFrtFwrdLicDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsReport Business Logic Basic Command implementation<br>
 * - OPUS-CustomsReport에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author charves
 * @see UI_BKG-0215EventResponse,CustomsReportBC 각 DAO클래스 참조
 * @since J2EE 1.6
 */
public class BangladeshCustomsReportBCImpl extends BasicCommandSupport implements BangladeshCustomsReportBC {
	// Database Access Object
	private transient BangladeshCustomsReportDBDAO dbDao = null;

	/**
	 * AustraliaManifestListDownloadBCImpl 객체 생성
	 * AustraliaManifestListDownloadDBDAO를 생성한다.<br>
	 */
	public BangladeshCustomsReportBCImpl(){
		dbDao = new BangladeshCustomsReportDBDAO();
	}


	/**
	 * Bangladesh Customs License정보를 조회 한다.
	 * @param LicenseInfoCondVO licenseInfoCondVO
	 * @return List<LicenseInfoListVO>
	 * @throws EventException
	 */
	public List<LicenseInfoListVO> searchLicenseInfo(LicenseInfoCondVO licenseInfoCondVO) throws EventException {

		try {
			// 조회 처리
			return dbDao.searchLicenseInfo(licenseInfoCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}

	}

	/**
	 * Customs Code가 추가되었을때 해당 Customs Name을 조회한다.
	 *
	 * @param BangladeshCustCondVO custCondVO
	 * @return String
	 * @throws EventException
	 */
	public String searchCustomerNm(BangladeshCustCondVO custCondVO) throws EventException {
		try{
			return dbDao.searchCustomerNm((BangladeshCustCondVO)custCondVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		}
	}


	/**
	 * Bangladesh License정보를 입력/수정/삭제한다.
	 *
	 * @param BkgCstmsBdFrtFwrdLicDetailVO[] bkgCstmsBdFrtFwrdLicDetailVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageLicenseInfo(BkgCstmsBdFrtFwrdLicDetailVO[] bkgCstmsBdFrtFwrdLicDetailVO, SignOnUserAccount account) throws EventException {
		try {
			List<BkgCstmsBdFrtFwrdLicDetailVO> insertVoList = new ArrayList<BkgCstmsBdFrtFwrdLicDetailVO>();
			List<BkgCstmsBdFrtFwrdLicDetailVO> updateVoList = new ArrayList<BkgCstmsBdFrtFwrdLicDetailVO>();
			List<BkgCstmsBdFrtFwrdLicDetailVO> deleteVoList = new ArrayList<BkgCstmsBdFrtFwrdLicDetailVO>();

			for ( int i=0; i<bkgCstmsBdFrtFwrdLicDetailVO .length; i++ ) {
				if ( bkgCstmsBdFrtFwrdLicDetailVO[i].getIbflag().equals("I")){
					bkgCstmsBdFrtFwrdLicDetailVO[i].setCreUsrId(account.getUsr_id());
					bkgCstmsBdFrtFwrdLicDetailVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(bkgCstmsBdFrtFwrdLicDetailVO[i]);
				} else if ( bkgCstmsBdFrtFwrdLicDetailVO[i].getIbflag().equals("U")){
					bkgCstmsBdFrtFwrdLicDetailVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(bkgCstmsBdFrtFwrdLicDetailVO[i]);
				} else if ( bkgCstmsBdFrtFwrdLicDetailVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgCstmsBdFrtFwrdLicDetailVO[i]);
				}
			}

			if ( insertVoList != null && insertVoList.size() > 0 ) {
				dbDao.addLicenseInfo(insertVoList);
			}

			if ( updateVoList != null && updateVoList.size() > 0 ) {
				dbDao.modifyLicenseInfo(updateVoList);
			}

			if ( deleteVoList != null &&  deleteVoList.size() > 0 ) {
				dbDao.removeLicenseInfo(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

	}

}

