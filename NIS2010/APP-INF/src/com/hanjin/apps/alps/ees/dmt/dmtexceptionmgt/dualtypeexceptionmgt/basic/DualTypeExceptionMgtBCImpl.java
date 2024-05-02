/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeExceptionMgtBCImpl.java
*@FileTitle : Dual Type Exception Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.07 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration.DualTypeExceptionMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-DMTExceptionMgt Business Logic Basic Command implementation<br>
 * - NIS2010-DMTExceptionMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2014EventResponse,DualTypeExceptionMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class DualTypeExceptionMgtBCImpl extends BasicCommandSupport implements DualTypeExceptionMgtBC {

	// Database Access Object
	private transient DualTypeExceptionMgtDBDAO dbDao = null;

	/**
	 * DualTypeExceptionMgtBCImpl 객체 생성<br>
	 * DualTypeExceptionMgtDBDAO를 생성한다.<br>
	 */
	public DualTypeExceptionMgtBCImpl() {
		dbDao = new DualTypeExceptionMgtDBDAO();
	}
	
	/**
	 * Dual Type Exception 에 기등록된 Customer 정보를 조회 합니다. <br>
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
	 * Dual Type Exception을 조회 합니다. <br>
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
	 * Dual Type Exception을 생성, 수정, 삭제 합니다. <br>
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
						
						//CUST_EXPT_SEQ 를 구한다.
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
	 * Dual Type Exception Coverage의 Dual Type 여부를 조회 합니다.<br>
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
	 * Dual Type Exception의 삭제가능 여부를 조회 합니다.<br>
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
	 * Dual Type Exception Expire Date 가 유효한지 조회 합니다.<br>
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
	 * 등록할 Dual Type Exception 이 기등록된 것인지 조회 합니다.<br>
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
	 * 기등록된 Dual Type Exception 를 조회하는 함수<br>
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