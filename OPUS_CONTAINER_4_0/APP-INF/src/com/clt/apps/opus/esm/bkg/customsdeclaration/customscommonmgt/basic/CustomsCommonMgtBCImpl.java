/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : CustomsCommonMgtBCImpl.java
 *@FileTitle : Customs Error Code
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration.CustomsCommonMgtDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.BkgCstmsCommonInputVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.BkgCstmsCommonReturnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvSeqVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsEmlNtfcVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsErrCdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsPckTpConvVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.log4j.StringUtils;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsCommonMgt Business Logic Command implementation<br>
 * - OPUS-CustomsCommonMgt handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CustomsCommonMgtBCImpl extends BasicCommandSupport implements CustomsCommonMgtBC {

	// Database Access Object
	private transient CustomsCommonMgtDBDAO dbDao = null;

	/**
	 * CustomsCommonMgtBCImpl object creation<br>
	 * CustomsCommonMgtDBDAO creation<br>
	 */
	public CustomsCommonMgtBCImpl() {
		dbDao = new CustomsCommonMgtDBDAO();
	}

	/**
	 * [공통] 쿼리 조합 조회<br>
	 *
	 * @param BkgCstmsCommonInputVO bkgCstmsCommonInputVO
	 * @return List<BkgCstmsCommonReturnVO>
	 * @exception EventException
	 */
	public List<BkgCstmsCommonReturnVO> getCodeValue(BkgCstmsCommonInputVO bkgCstmsCommonInputVO) throws EventException {
		try {
			return dbDao.getCodeValue(bkgCstmsCommonInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * searching Country Code, Customs Division ID, Customs Code Description information<br>
	 *
	 * @param CstmsCdConvVO cstmsCdConvVO
	 * @return List<CstmsCdConvVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvVO> searchCstmsCdConvDescList(CstmsCdConvVO cstmsCdConvVO) throws EventException {
		try {
			return dbDao.searchCstmsCdConvDescList(cstmsCdConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * searching Attribute Content information at sheet2 about Country Code, Customs Division ID of sheet1<br>
	 *
	 * @param CstmsCdConvVO cstmsCdConvVO
	 * @return List<CstmsCdConvVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvVO> searchCstmsCdConvCtntList(CstmsCdConvVO cstmsCdConvVO) throws EventException {
		try {
			return dbDao.searchCstmsCdConvCtntList(cstmsCdConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * managing information of Country Code, Customs Division ID, Customs Code Description<br>
	 *
	 * @param CstmsCdConvVO[] cstmsCdConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsCdConvDesc(CstmsCdConvVO[] cstmsCdConvVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CstmsCdConvVO> insertVoList = new ArrayList<CstmsCdConvVO>();
			List<CstmsCdConvVO> updateVoList = new ArrayList<CstmsCdConvVO>();
			List<CstmsCdConvVO> deleteVoList = new ArrayList<CstmsCdConvVO>();

			for (int i = 0; i < cstmsCdConvVOs.length; i++) {
				if (cstmsCdConvVOs[i].getIbflag().equals("I")) {
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					insertVoList.add(cstmsCdConvVOs[i]);
				} else if (cstmsCdConvVOs[i].getIbflag().equals("U")) {
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(cstmsCdConvVOs[i]);
				} else if (cstmsCdConvVOs[i].getIbflag().equals("D")) {
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(cstmsCdConvVOs[i]);
				}
			}
			if (insertVoList.size() > 0) {
				dbDao.addCstmsCdConvDesc(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyCstmsCdConvDesc(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCstmsCdConvDescCtnt(deleteVoList);
				dbDao.removeCstmsCdConvDesc(deleteVoList);

			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * managing Attribute Content information at sheet2 about Country Code, Customs Division ID of sheet1<br>
	 *
	 * @param CstmsCdConvVO[] cstmsCdConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsCdConvCtnt(CstmsCdConvVO[] cstmsCdConvVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CstmsCdConvVO> insertVoList = new ArrayList<CstmsCdConvVO>();
			List<CstmsCdConvVO> updateVoList = new ArrayList<CstmsCdConvVO>();
			List<CstmsCdConvVO> deleteVoList = new ArrayList<CstmsCdConvVO>();

			for (int i = 0; i < cstmsCdConvVOs.length; i++) {
				if (cstmsCdConvVOs[i].getIbflag().equals("I")) {
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					insertVoList.add(cstmsCdConvVOs[i]);
				} else if (cstmsCdConvVOs[i].getIbflag().equals("U")) {
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(cstmsCdConvVOs[i]);
				} else if (cstmsCdConvVOs[i].getIbflag().equals("D")) {
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(cstmsCdConvVOs[i]);
				}
			}
			if (insertVoList.size() > 0) dbDao.addCstmsCdConvCtnt(insertVoList);
			if (updateVoList.size() > 0) dbDao.modifyCstmsCdConvCtnt(updateVoList);
			if (deleteVoList.size() > 0) dbDao.removeCstmsCdConvCtnt(deleteVoList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * checking duplication of Country Code, Customs Division ID<br>
	 *
	 * @param String cntCd
	 * @param String cstmsDivId
	 * @return String
	 * @throws EventException
	 */
	public String checkCstmsCdConvDesc(String cntCd, String cstmsDivId) throws EventException {
		DBRowSet rowSet = null; // DB ResultSet for data transmission
		String retVal = "";

		try {
			rowSet = dbDao.checkCstmsCdConvDesc(cntCd, cstmsDivId);
			if (rowSet != null) {
				while (rowSet.next()) retVal = rowSet.getString(1);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}

		return retVal;

	}

	/**
	 * searching Country Code, Customs Division ID, Customs Code Description information<br>
	 *
	 * @param CstmsCdConvSeqVO cstmsCdConvSeqVO
	 * @return List<CstmsCdConvSeqVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvSeqVO> searchCstmsCdConvSeqDescList(CstmsCdConvSeqVO cstmsCdConvSeqVO) throws EventException {
		try {
			return dbDao.searchCstmsCdConvSeqDescList(cstmsCdConvSeqVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * searching Attribute Content information at sheet2 about Country Code, Customs Division ID of sheet1<br>
	 *
	 * @param CstmsCdConvSeqVO cstmsCdConvSeqVO
	 * @return List<CstmsCdConvSeqVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvSeqVO> searchCstmsCdConvSeqCtntList(CstmsCdConvSeqVO cstmsCdConvSeqVO) throws EventException {
		try {
			return dbDao.searchCstmsCdConvSeqCtntList(cstmsCdConvSeqVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * managing Attribute Content information at sheet2 about Country Code, Customs Division ID of sheet1<br>
	 *
	 * @param CstmsCdConvSeqVO[] cstmsCdConvSeqVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsCdConvSeqCtnt(CstmsCdConvSeqVO[] cstmsCdConvSeqVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CstmsCdConvSeqVO> insertVoList = new ArrayList<CstmsCdConvSeqVO>();
			List<CstmsCdConvSeqVO> updateVoList = new ArrayList<CstmsCdConvSeqVO>();
			List<CstmsCdConvSeqVO> deleteVoList = new ArrayList<CstmsCdConvSeqVO>();

			for (int i = 0; i < cstmsCdConvSeqVOs.length; i++) {
				if (cstmsCdConvSeqVOs[i].getIbflag().equals("I")) {
					cstmsCdConvSeqVOs[i].setUserId(account.getUsr_id());
					insertVoList.add(cstmsCdConvSeqVOs[i]);
				} else if (cstmsCdConvSeqVOs[i].getIbflag().equals("U")) {
					cstmsCdConvSeqVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(cstmsCdConvSeqVOs[i]);
				} else if (cstmsCdConvSeqVOs[i].getIbflag().equals("D")) {
					cstmsCdConvSeqVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(cstmsCdConvSeqVOs[i]);
				}
			}
			if (insertVoList.size() > 0) {
				dbDao.addCstmsCdConvSeqCtnt(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyCstmsCdConvSeqCtnt(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCstmsCdConvSeqCtnt(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * searching Country Code, Package Type Code, Customs Package Type Code information<br>
	 *
	 * @param CstmsPckTpConvVO cstmsPckTpConvVO
	 * @return List<CstmsPckTpConvVO>
	 * @throws EventException
	 */
	public List<CstmsPckTpConvVO> searchCstmsPckTpConvList(CstmsPckTpConvVO cstmsPckTpConvVO) throws EventException {
		try {
			return dbDao.searchCstmsPckTpConvList(cstmsPckTpConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * managing information of Country Code, Package Type Code, Customs Package Type Code<br>
	 *
	 * @param CstmsPckTpConvVO[] cstmsPckTpConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsPckTpConv(CstmsPckTpConvVO[] cstmsPckTpConvVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CstmsPckTpConvVO> insertVoList = new ArrayList<CstmsPckTpConvVO>();
			List<CstmsPckTpConvVO> updateVoList = new ArrayList<CstmsPckTpConvVO>();
			List<CstmsPckTpConvVO> deleteVoList = new ArrayList<CstmsPckTpConvVO>();

			for (int i = 0; i < cstmsPckTpConvVOs.length; i++) {
				if (cstmsPckTpConvVOs[i].getIbflag().equals("I")) {
					if (!"0".equals(checkCstmsPckTpConv(cstmsPckTpConvVOs[i].getCntCd(), cstmsPckTpConvVOs[i].getPckTpCd(), cstmsPckTpConvVOs[i].getCstmsPckTpCd()))) {
						throw new EventException(new ErrorHandler("BKG03056", new String[] { "Country and Package Type" }) .getMessage());
					}
					cstmsPckTpConvVOs[i].setUserId(account.getUsr_id());
					insertVoList.add(cstmsPckTpConvVOs[i]);
				} else if (cstmsPckTpConvVOs[i].getIbflag().equals("U")) {
					cstmsPckTpConvVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(cstmsPckTpConvVOs[i]);
				} else if (cstmsPckTpConvVOs[i].getIbflag().equals("D")) {
					cstmsPckTpConvVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(cstmsPckTpConvVOs[i]);
				}
			}
			if (insertVoList.size() > 0) {
				dbDao.addCstmsPckTpConv(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyCstmsPckTpConv(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCstmsPckTpConv(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * checking duplication of Country Code, Package Type Code, Customs Package Type Code<br>
	 *
	 * @param String cntCd
	 * @param String pckTpCd
	 * @param String rcvrId
	 * @return String
	 * @throws EventException
	 */
	public String checkCstmsPckTpConv(String cntCd, String pckTpCd, String rcvrId) throws EventException {
		DBRowSet rowSet = null; // DB ResultSet for data transmission
		String retVal = "";

		try {
			rowSet = dbDao.checkCstmsPckTpConv(cntCd, pckTpCd, rcvrId);
			if (rowSet != null) {
				while (rowSet.next()) {
					retVal = rowSet.getString(1);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}

		return retVal;

	}

	/**
	 * checking Package Type Code
	 *
	 * @param pckTpCd
	 * @return
	 * @throws EventException
	 */
	public String checkPckTpCd(String pckTpCd) throws EventException {
		DBRowSet rowSet = null; // DB ResultSet for data transmission
		String retVal = "";

		try {
			rowSet = dbDao.checkPckTpCd(pckTpCd);
			if (rowSet != null) {
				while (rowSet.next()) {
					retVal = rowSet.getString(1);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
		return retVal;
	}

	/**
	 * searching Country Code, Customs Error Code information<br>
	 *
	 * @param CstmsErrCdVO cstmsErrCdVO
	 * @return List<CstmsErrCdVO>
	 * @throws EventException
	 */
	public List<CstmsErrCdVO> searchCstmsAdvErrList(CstmsErrCdVO cstmsErrCdVO) throws EventException {
		try {
			return dbDao.searchCstmsAdvErrList(cstmsErrCdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * managing information of Country Code, Customs Error Code
	 *
	 * @param CstmsErrCdVO[] customsErrCdVOs
	 * @param SignOnUserAccount account
	 * @return List<CstmsErrCdVO>
	 * @throws EventException
	 */
	public List<CstmsErrCdVO> manageCstmsAdvErr(CstmsErrCdVO[] customsErrCdVOs, SignOnUserAccount account) throws EventException {
		
		List<CstmsErrCdVO> insertVoList = new ArrayList<CstmsErrCdVO>();
		List<CstmsErrCdVO> updateVoList = new ArrayList<CstmsErrCdVO>();
		List<CstmsErrCdVO> deleteVoList = new ArrayList<CstmsErrCdVO>();
		List<CstmsErrCdVO> dupRstVOList = new ArrayList<CstmsErrCdVO>();
		
		try {
			boolean errChk = false;
			
			for (CstmsErrCdVO cstmsErrCdVO : customsErrCdVOs){
				if (cstmsErrCdVO.getIbflag().equals("I")) {
					if (cstmsErrCdVO.getCstmsErrCd().length() > 3) {
						cstmsErrCdVO.setChkCstmsErrCd("Y");
						errChk = true;
					}
					if ("Y".equals(dbDao.checkCstmsAdvErr(cstmsErrCdVO))) {
						cstmsErrCdVO.setDupChkRst("Y");
						errChk = true;
					}
				}
				dupRstVOList.add(cstmsErrCdVO);
			}
			
			if(!errChk){	
				for (CstmsErrCdVO cstmsErrCdVO : customsErrCdVOs){ 
					if (cstmsErrCdVO.getIbflag().equals("I")) {
						cstmsErrCdVO.setUserId(account.getUsr_id());
						insertVoList.add(cstmsErrCdVO);
					} else if (cstmsErrCdVO.getIbflag().equals("U")) {
						cstmsErrCdVO.setUserId(account.getUsr_id());
						updateVoList.add(cstmsErrCdVO);
					} else if (cstmsErrCdVO.getIbflag().equals("D")) {
						cstmsErrCdVO.setUserId(account.getUsr_id());
						deleteVoList.add(cstmsErrCdVO);
					}
				}
				if (deleteVoList.size() > 0) {
					dbDao.removeCstmsAdvErr(deleteVoList);
				}
				if (insertVoList.size() > 0) {
					dbDao.addCstmsAdvErr(insertVoList);
				}
				if (updateVoList.size() > 0) {
					dbDao.modifyCstmsAdvErr(updateVoList);
				}
				dupRstVOList = new ArrayList<CstmsErrCdVO>(); // 에러가 없을 때 리턴값 초기화
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dupRstVOList; 
	} 

	/**
	 * [ESM_BKG_1513] Manifest e-Maiil Notification 목록 조회<br>
	 *
	 * @param CstmsEmlNtfcVO cstmsEmlNtfcVO
	 * @return List<CstmsEmlNtfcVO>
	 * @exception EventException
	 */
	public List<CstmsEmlNtfcVO> searchCstmsEmlNtfc(CstmsEmlNtfcVO cstmsEmlNtfcVO) throws EventException {
		try {
			return dbDao.searchCstmsEmlNtfc(cstmsEmlNtfcVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1513] Manifest e-Maiil Notification 목록 저장<br>
	 *
	 * @param CstmsEmlNtfcVO[] cstmsEmlNtfcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsEmlNtfc(CstmsEmlNtfcVO[] cstmsEmlNtfcVOs, SignOnUserAccount account) throws EventException {
		List<CstmsEmlNtfcVO> insertCstmsEmlNtfcVOList = new ArrayList<CstmsEmlNtfcVO>();
		List<CstmsEmlNtfcVO> updateCstmsEmlNtfcVOList = new ArrayList<CstmsEmlNtfcVO>();
		List<CstmsEmlNtfcVO> deleteCstmsEmlNtfcVOList = new ArrayList<CstmsEmlNtfcVO>();

		try {
			if (cstmsEmlNtfcVOs != null) {
				for (CstmsEmlNtfcVO cstmsEmlNtfcVO : cstmsEmlNtfcVOs) {
					if ("I".equals(cstmsEmlNtfcVO.getIbflag())) {
						cstmsEmlNtfcVO.setUsrId(account.getUsr_id());
						insertCstmsEmlNtfcVOList.add(cstmsEmlNtfcVO);
					} else if ("U".equals(cstmsEmlNtfcVO.getIbflag())) {
						cstmsEmlNtfcVO.setUsrId(account.getUsr_id());
						updateCstmsEmlNtfcVOList.add(cstmsEmlNtfcVO);
					} else if ("D".equals(cstmsEmlNtfcVO.getIbflag())) {
						deleteCstmsEmlNtfcVOList.add(cstmsEmlNtfcVO);
					}
				}
				if (insertCstmsEmlNtfcVOList.size() > 0) dbDao.addCstmsEmlNtfc(insertCstmsEmlNtfcVOList);
				if (updateCstmsEmlNtfcVOList.size() > 0) dbDao.modifyCstmsEmlNtfc(updateCstmsEmlNtfcVOList);
				if (deleteCstmsEmlNtfcVOList.size() > 0) dbDao.removeCstmsEmlNtfc(deleteCstmsEmlNtfcVOList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI수신오류 시 메일전송할 수신처 조회<br>
	 *
	 * @param CstmsEmlNtfcVO cstmsEmlNtfcVO
	 * @return CstmsEmlNtfcVO
	 * @exception EventException
	 */
	public CstmsEmlNtfcVO searchCstmsEmlNtfcInfo(CstmsEmlNtfcVO cstmsEmlNtfcVO) throws EventException {
		try {
			List<CstmsEmlNtfcVO> listEml = dbDao
					.searchCstmsEmlNtfcList(cstmsEmlNtfcVO);

			StringBuffer sbToEml = new StringBuffer();
			StringBuffer sbCcEml = new StringBuffer();

			String strToEml = "";
			String strCcEml = "";
			for (int i = 0; i < listEml.size(); i++) {
				CstmsEmlNtfcVO eml = (CstmsEmlNtfcVO) listEml.get(i);
				sbToEml.append(";");
				sbToEml.append(eml.getToEmlCtnt());
				sbCcEml.append(";");
				sbCcEml.append(eml.getCcEmlCtnt());
			}
			// 수신처 중복제거
			String[] toEmlAddrArray = StringUtils
					.removeDuplicateStrings(sbToEml.toString().split(";"));
			strToEml = StringUtils.arrayToDelimitedString(toEmlAddrArray, ";");
			String[] ccEmlAddrArray = StringUtils
					.removeDuplicateStrings(sbCcEml.toString().split(";"));
			strCcEml = StringUtils.arrayToDelimitedString(ccEmlAddrArray, ";");

			CstmsEmlNtfcVO emlNtfcInfo = new CstmsEmlNtfcVO();
			emlNtfcInfo.setToEmlCtnt(strToEml);
			emlNtfcInfo.setCcEmlCtnt(strCcEml);

			return emlNtfcInfo;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Consortium VVD 조회<br>
	 *
	 * @param vvd
	 * @param portCd
	 * @param ioType
	 * @return
	 * @throws EventException
	 */
	public String searchConVvd(String vvd, String portCd, String ioType) throws EventException {
		try {
			String strConVvd = dbDao.searchConVvd(vvd, portCd, ioType);

			return strConVvd;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MDM_VSL_SVC_LANE 존재여부
	 *
	 * @param vslSlanCd
	 * @return
	 * @throws EventException
	 */
	public boolean checkMdmVslSvcLane(String vslSlanCd) throws EventException {
		try {
			return dbDao.checkMdmVslSvcLane(vslSlanCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}