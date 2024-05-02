/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeExceptionMgtBCImpl.java
*@FileTitle : Dual Type Exception Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration.DualTypeExceptionMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-DMTExceptionMgt Business Logic Basic Command implementation<br>

 * @author 
 * @see reference DAO classes of EES_DMT_2014EventResponse,DualTypeExceptionMgtBC
 * @since J2EE 1.6
 */
public class DualTypeExceptionMgtBCImpl extends BasicCommandSupport implements DualTypeExceptionMgtBC {

	// Database Access Object
	private transient DualTypeExceptionMgtDBDAO dbDao = null;

	/**
	 * DualTypeExceptionMgtBCImpl Create object<br>
	 * Create DualTypeExceptionMgtDBDAO.<br>
	 */
	public DualTypeExceptionMgtBCImpl() {
		dbDao = new DualTypeExceptionMgtDBDAO();
	}
	
	
	/**
	 * Search Customer information in Dual Type Exception. <br>
	 * 
	 * @return List<DualTypeCustomerVO>
	 * @exception EventException
	 */
	public List<DualTypeCustomerVO> searchDualTypeCustomerList() throws EventException {
		try {
			return dbDao.searchDualTypeCustomerList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		}
	}
	
	
	/**
	 * Search Dual Type Exception. <br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return List<DualTypeCustomerVO>
	 * @exception EventException
	 */
	public List<DualTypeCustomerVO> searchDualTypeCustomer(DualTypeCustomerVO dualTypeCustomerVO) throws EventException {
		try {
			return dbDao.searchDualTypeCustomer(dualTypeCustomerVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		} catch (Exception ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		}
	}	
	
	
	/**
	 * Create, Modify and Delete Dual Type Exception. <br>
	 * 
	 * @param DualTypeCustomerVO[] dualTypeCustomerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDualTypeCustomer(DualTypeCustomerVO[] dualTypeCustomerVOs, SignOnUserAccount account) throws EventException{
		
		try {
			int nextSeq = 0;
			Map<String, Integer> custSeqMap = new HashMap<String, Integer>();
			
			List<DualTypeCustomerVO> insertVoList = new ArrayList<DualTypeCustomerVO>();
			List<DualTypeCustomerVO> updateVoList = new ArrayList<DualTypeCustomerVO>();
			List<DualTypeCustomerVO> deleteVoList = new ArrayList<DualTypeCustomerVO>();
			
			if (dualTypeCustomerVOs != null) {
				for ( int i = 0 ; i < dualTypeCustomerVOs.length ; i++ ) {
					if (dualTypeCustomerVOs[i].getIbflag().equals("I")){
						dualTypeCustomerVOs[i].setCreUsrId(account.getUsr_id());
						dualTypeCustomerVOs[i].setCreOfcCd(account.getOfc_cd());
						
						// get CUST_EXPT_SEQ 
						if (custSeqMap.containsKey(dualTypeCustomerVOs[i].getCustCd())) {
							nextSeq = ((Integer)custSeqMap.get(dualTypeCustomerVOs[i].getCustCd())).intValue() + 1;
						}
						else {
							nextSeq = Integer.parseInt(dbDao.searchNextCustExptSeq(dualTypeCustomerVOs[i]));
						}
						dualTypeCustomerVOs[i].setCustExptSeq(nextSeq + "");
						custSeqMap.put(dualTypeCustomerVOs[i].getCustCd(), new Integer(nextSeq));
						insertVoList.add(dualTypeCustomerVOs[i]);
					} else if (dualTypeCustomerVOs[i].getIbflag().equals("U")){
						if ("Y".equals(dualTypeCustomerVOs[i].getExpFlg()) 
								&& JSPUtil.getNull(dualTypeCustomerVOs[i].getDulExptExpDt()).length() > 0) {
							dualTypeCustomerVOs[i].setExpUsrId(account.getUsr_id());
							dualTypeCustomerVOs[i].setExpOfcCd(account.getOfc_cd());
						}
						dualTypeCustomerVOs[i].setUpdUsrId(account.getUsr_id());
						dualTypeCustomerVOs[i].setUpdOfcCd(account.getOfc_cd());
						updateVoList.add(dualTypeCustomerVOs[i]);
					} else if (dualTypeCustomerVOs[i].getIbflag().equals("D")){
						dualTypeCustomerVOs[i].setUpdUsrId(account.getUsr_id());
						dualTypeCustomerVOs[i].setUpdOfcCd(account.getOfc_cd());					
						deleteVoList.add(dualTypeCustomerVOs[i]);
					}
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addDualTypeCustomer(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDualTypeCustomer(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeDualTypeCustomer(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getMessage());
		}
	}
	
	
	/**
	 * Check Dual Type of Dual Type Exception Coverage.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkDualCoverage(CoverageVO coverageVO) throws EventException {
		try {
			return dbDao.checkDualCoverage(coverageVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		}
	}
	
	
	/**
	 * Check it is Deletable Dual Type Exception.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception EventException
	 */
	public String checkDelDualTypeCustomer(DualTypeCustomerVO dualTypeCustomerVO) throws EventException {
		String result = null;
		try {
			if ("S".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) {
				result = dbDao.checkDelDualTypeCustomerBySC(dualTypeCustomerVO);
			}
			else if ("B".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) { 
				result = dbDao.checkDelDualTypeCustomerByRFA(dualTypeCustomerVO);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		}
		return result;
	}
	
	
	/**
	 * Check Validation Dual Type Exception Expire Date.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception EventException
	 */
	public String checkDualTypeExpireDate(DualTypeCustomerVO dualTypeCustomerVO) throws EventException {
		String result = null;
		try {
			if ("S".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) {
				result = dbDao.checkDelDualTypeExpireDateBySC(dualTypeCustomerVO);
			}
			else if ("B".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) { 
				result = dbDao.checkDelDualTypeExpireDateByRFA(dualTypeCustomerVO);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		}
		return result;
	}
	
	
	/**
	 * Check Duplication Dual Type Exception.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return DualTypeCustomerVO
	 * @exception EventException
	 */
	public DualTypeCustomerVO checkDuplicateDualTypeException(DualTypeCustomerVO dualTypeCustomerVO) throws EventException {
		try {
			return dbDao.checkDuplicateDualTypeException(dualTypeCustomerVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		}
	}
	
	
	/**
	 * Search Applied Dual Type Exception<br>
	 * 
	 * @param SCOrDARListInputVO sCOrDARListInputVO
	 * @return List<SCOrDARListVO>
	 * @exception EventException
	 */
	public List<SCOrDARListVO> searchSCorDARListByCustomer(SCOrDARListInputVO sCOrDARListInputVO) throws EventException {
		List<SCOrDARListVO> list = null;
		try {
			list = dbDao.searchSCorDARListByCustomer(sCOrDARListInputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		}
		return list;
	}	
}