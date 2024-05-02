/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCustomerInfoBCImpl.java
*@FileTitle : ACMCustomerInfoBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.03 김상수
* 1.0 Creation
* 2013.06.04 박다은 [CHM-201324844] FF code중복 체크 로직 변경 요청
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.integration.ACMCustomerInfoDBDAO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.CustVendorMatchForSCompVO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.FACExSettingVO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.FFCmpnExSettingVO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.FFVendorMatchVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMMaster Business Logic Command Interface<br>
 * - ALPS-ACMMaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0019Event,ACMCustomerInfoBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ACMCustomerInfoBCImpl extends BasicCommandSupport implements ACMCustomerInfoBC {

	// Database Access Object
	private transient ACMCustomerInfoDBDAO dbDao = null;

	/**
	 * ACMCustomerInfoBCImpl 객체 생성<br>
	 * ACMCustomerInfoDBDAO를 생성한다.<br>
	 */
	public ACMCustomerInfoBCImpl() {
		dbDao = new ACMCustomerInfoDBDAO();
	}

	/**
	 * [ESM_ACM_0019]
	 * FF-Vendor Match for FF Compensation 목록을 조회<br>
	 *
	 * @param FFVendorMatchVO ffVendorMatchVO
	 * @return List<FFVendorMatchVO>
	 * @exception EventException
	 */
	public List<FFVendorMatchVO> searchFFVendorMatch(FFVendorMatchVO ffVendorMatchVO) throws EventException {
		try {
			return dbDao.searchFFVendorMatch(ffVendorMatchVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0019]
	 * ACM_FF_VNDR_MTCH 테이블에서 FF_CNT_CD와 FF_SEQ의 중복 체크<br>
	 *
	 * @param FFVendorMatchVO ffVendorMatchVO
	 * @exception EventException
	 */
	public void getCustomerFromFFVenderMatch(FFVendorMatchVO ffVendorMatchVO) throws EventException {
		try {
			if (dbDao.getCustomerFromFFVenderMatch(ffVendorMatchVO).size() > 0) {
				// [ACM00004] - $s is duplicated. Please check $s again!
				throw new EventException(new ErrorHandler("ACM00004", new String[]{"Customer Code [" + ffVendorMatchVO.getFfCntSeq() + "]", "Customer Code"}).getMessage());
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0019]
	 * FF-Vendor Match for FF Compensation 목록을 저장<br>
	 *
	 * @param FFVendorMatchVO[] ffVendorMatchVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFFVendorMatch(FFVendorMatchVO[] ffVendorMatchVOs, SignOnUserAccount account) throws EventException {
		List<FFVendorMatchVO> insertVoList = new ArrayList<FFVendorMatchVO>();
		List<FFVendorMatchVO> updateVoList = new ArrayList<FFVendorMatchVO>();
		List<FFVendorMatchVO> deleteVoList = new ArrayList<FFVendorMatchVO>();
		try {
			for (int i=0; i<ffVendorMatchVOs.length; i++) {
				if ("I".equals(ffVendorMatchVOs[i].getIbflag())) {
					ffVendorMatchVOs[i].setUsrId(account.getUsr_id());
					insertVoList.add(ffVendorMatchVOs[i]);
				} else if ("U".equals(ffVendorMatchVOs[i].getIbflag())) {
					ffVendorMatchVOs[i].setUsrId(account.getUsr_id());
					updateVoList.add(ffVendorMatchVOs[i]);
				} else if ("D".equals(ffVendorMatchVOs[i].getIbflag())) {
					deleteVoList.add(ffVendorMatchVOs[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addFFVendorMatch(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyFFVendorMatch(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeFFVendorMatch(deleteVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0020]
	 * FF Compensation Exclusion Setting 목록을 조회<br>
	 *
	 * @param FFCmpnExSettingVO ffCmpnExSettingVO
	 * @return List<FFCmpnExSettingVO>
	 * @exception EventException
	 */
	public List<FFCmpnExSettingVO> searchFFCmpnExSetting(FFCmpnExSettingVO ffCmpnExSettingVO) throws EventException {
		try {
			return dbDao.searchFFCmpnExSetting(ffCmpnExSettingVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0020]
	 * ACM_FF_EXCLU_SET 테이블에서 FF_CNT_CD와 FF_SEQ의 중복 체크<br>
	 *
	 * @param FFCmpnExSettingVO ffCmpnExSettingVO
	 * @exception EventException
	 */
	public void getCustomerFromFFExclusion(FFCmpnExSettingVO ffCmpnExSettingVO) throws EventException {
		try {
			if (dbDao.getCustomerFromFFExclusion(ffCmpnExSettingVO).size() > 0) {
				// [ACM00004] - $s is duplicated. Please check $s again!
				throw new EventException(new ErrorHandler("ACM00004", new String[]{"Customer Code [" + ffCmpnExSettingVO.getFfCntSeq() + "]", "Customer Code"}).getMessage());
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	// [CHM-201324844] FF code 중복 체크 로직 변경 요청
	/**
	 * [ESM_ACM_0020]
	 * FF Compensation Exclusion Setting 목록을 저장<br>
	 *
	 * @param FFCmpnExSettingVO[] ffCmpnExSettingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFFCmpnExSetting(FFCmpnExSettingVO[] ffCmpnExSettingVOs, SignOnUserAccount account) throws EventException {
		List<FFCmpnExSettingVO> insertVoList = new ArrayList<FFCmpnExSettingVO>();
		List<FFCmpnExSettingVO> updateVoList = new ArrayList<FFCmpnExSettingVO>();
		List<FFCmpnExSettingVO> deleteVoList = new ArrayList<FFCmpnExSettingVO>();
		try {
			for (int i=0; i<ffCmpnExSettingVOs.length; i++) {
				if ("D".equals(ffCmpnExSettingVOs[i].getIbflag())) {
					deleteVoList.add(ffCmpnExSettingVOs[i]);
				} else {
					// ACM_FAC_EXCLU_SET 테이블에서 PK로 중복 체크
					if (dbDao.getCustomerFromFFExclusion(ffCmpnExSettingVOs[i]).size() > 0) {
						// [ACM00004] - $s is duplicated. Please check $s again!
						throw new EventException(new ErrorHandler("ACM00004", new String[]{ "BKG FWDR[" + ffCmpnExSettingVOs[i].getFfCntSeq() + "], BKG SHPR[" + ffCmpnExSettingVOs[i].getShprCntSeq() + "]", "Customer Code"}).getMessage());
					}

					ffCmpnExSettingVOs[i].setUsrId(account.getUsr_id());
					if ("I".equals(ffCmpnExSettingVOs[i].getIbflag())) {
						insertVoList.add(ffCmpnExSettingVOs[i]);
					} else if ("U".equals(ffCmpnExSettingVOs[i].getIbflag())) {
						updateVoList.add(ffCmpnExSettingVOs[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addFFCmpnExSetting(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyFFCmpnExSetting(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeFFCmpnExSetting(deleteVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
//	public void manageFFCmpnExSetting(FFCmpnExSettingVO[] ffCmpnExSettingVOs, SignOnUserAccount account) throws EventException {
//		List<FFCmpnExSettingVO> insertVoList = new ArrayList<FFCmpnExSettingVO>();
//		List<FFCmpnExSettingVO> updateVoList = new ArrayList<FFCmpnExSettingVO>();
//		List<FFCmpnExSettingVO> deleteVoList = new ArrayList<FFCmpnExSettingVO>();
//		try {
//			for (int i=0; i<ffCmpnExSettingVOs.length; i++) {
//				if ("I".equals(ffCmpnExSettingVOs[i].getIbflag())) {
//					ffCmpnExSettingVOs[i].setUsrId(account.getUsr_id());
//					insertVoList.add(ffCmpnExSettingVOs[i]);
//				} else if ("U".equals(ffCmpnExSettingVOs[i].getIbflag())) {
//					ffCmpnExSettingVOs[i].setUsrId(account.getUsr_id());
//					updateVoList.add(ffCmpnExSettingVOs[i]);
//				} else if ("D".equals(ffCmpnExSettingVOs[i].getIbflag())) {
//					deleteVoList.add(ffCmpnExSettingVOs[i]);
//				}
//			}
//
//			if (insertVoList.size() > 0) {
//				dbDao.addFFCmpnExSetting(insertVoList);
//			}
//			if (updateVoList.size() > 0) {
//				dbDao.modifyFFCmpnExSetting(updateVoList);
//			}
//			if (deleteVoList.size() > 0) {
//				dbDao.removeFFCmpnExSetting(deleteVoList);
//			}
//
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}

	/**
	 * [ESM_ACM_0021]
	 * FAC Exclusion Setting 목록을 조회<br>
	 *
	 * @param FACExSettingVO facExSettingVO
	 * @return List<FACExSettingVO>
	 * @exception EventException
	 */
	public List<FACExSettingVO> searchFACExSetting(FACExSettingVO facExSettingVO) throws EventException {
		try {
			return dbDao.searchFACExSetting(facExSettingVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0021]
	 * FAC Exclusion Setting 목록을 저장<br>
	 *
	 * @param FACExSettingVO[] facExSettingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFACExSetting(FACExSettingVO[] facExSettingVOs, SignOnUserAccount account) throws EventException {
		List<FACExSettingVO> insertVoList = new ArrayList<FACExSettingVO>();
		List<FACExSettingVO> updateVoList = new ArrayList<FACExSettingVO>();
		List<FACExSettingVO> deleteVoList = new ArrayList<FACExSettingVO>();
		try {
			for (int i=0; i<facExSettingVOs.length; i++) {
				if ("D".equals(facExSettingVOs[i].getIbflag())) {
					deleteVoList.add(facExSettingVOs[i]);
				} else {
					// ACM_FAC_EXCLU_SET 테이블에서 PK로 중복 체크
					if (dbDao.getCustomerFromFACExSetting(facExSettingVOs[i]).size() > 0) {
						// [ACM00004] - $s is duplicated. Please check $s again!
						throw new EventException(new ErrorHandler("ACM00004", new String[]{"Row Data", "Row Data"}).getMessage());
					}

					facExSettingVOs[i].setUsrId(account.getUsr_id());
					if ("I".equals(facExSettingVOs[i].getIbflag())) {
						insertVoList.add(facExSettingVOs[i]);
					} else if ("U".equals(facExSettingVOs[i].getIbflag())) {
						updateVoList.add(facExSettingVOs[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addFACExSetting(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyFACExSetting(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeFACExSetting(deleteVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0022]
	 * Customer-Vendor Match for Special Compensation 목록을 조회<br>
	 *
	 * @param CustVendorMatchForSCompVO custVendorMatchForSCompVO
	 * @return List<CustVendorMatchForSCompVO>
	 * @exception EventException
	 */
	public List<CustVendorMatchForSCompVO> searchCustVendorMatchForSComp(CustVendorMatchForSCompVO custVendorMatchForSCompVO) throws EventException {
		try {
			return dbDao.searchCustVendorMatchForSComp(custVendorMatchForSCompVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0022]
	 * Customer-Vendor Match for Special Compensation 목록을 저장<br>
	 *
	 * @param CustVendorMatchForSCompVO[] custVendorMatchForSCompVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustVendorMatchForSComp(CustVendorMatchForSCompVO[] custVendorMatchForSCompVOs, SignOnUserAccount account) throws EventException {
		List<CustVendorMatchForSCompVO> insertVoList = new ArrayList<CustVendorMatchForSCompVO>();
		List<CustVendorMatchForSCompVO> updateVoList = new ArrayList<CustVendorMatchForSCompVO>();
		List<CustVendorMatchForSCompVO> deleteVoList = new ArrayList<CustVendorMatchForSCompVO>();
		try {
			for (int i=0; i<custVendorMatchForSCompVOs.length; i++) {
				if ("D".equals(custVendorMatchForSCompVOs[i].getIbflag())) {
					deleteVoList.add(custVendorMatchForSCompVOs[i]);
				} else {
					// ACM_FAC_EXCLU_SET 테이블에서 PK로 중복 체크
					if (dbDao.getCustomerFromCustVendorMatchForSComp(custVendorMatchForSCompVOs[i]).size() > 0) {
						// [ACM00004] - $s is duplicated. Please check $s again!
						throw new EventException(new ErrorHandler("ACM00004", new String[]{"Row Data", "Row Data"}).getMessage());
					}

					custVendorMatchForSCompVOs[i].setUsrId(account.getUsr_id());
					if ("I".equals(custVendorMatchForSCompVOs[i].getIbflag())) {
						insertVoList.add(custVendorMatchForSCompVOs[i]);
					} else if ("U".equals(custVendorMatchForSCompVOs[i].getIbflag())) {
						updateVoList.add(custVendorMatchForSCompVOs[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addCustVendorMatchForSComp(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyCustVendorMatchForSComp(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCustVendorMatchForSComp(deleteVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}