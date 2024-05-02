/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OPCostBC.java
*@FileTitle : OP Cost
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.15 
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.integration.OPCostDBDAO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUseQtyVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUtCostDtlVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUtCostVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchOtherVesselDailyHireListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-STDUnitCost Business Logic Basic Command implementation<br>
 * - ALPS-STDUnitCost에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jong-Ock KIM
 * @see ESM_MAS_0315EventResponse,MASBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OPCostBCImpl extends BasicCommandSupport implements OPCostBC {

	// Database Access Object
	private transient OPCostDBDAO dbDao = null;

	/**
	 * OPCostBCImpl 객체 생성<br>
	 * OPCOSTDBDAO를 생성한다.<br>
	 */
	public OPCostBCImpl() {
		dbDao = new OPCostDBDAO();
	}
	
	/**
	 * ESM_MAS_0315, ESM_MAS_0316 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<StndUtCostVO>
	 * @exception EventException
	 */
	public List<StndUtCostVO> searchStndUtCostList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchStndUtCostList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0315 - Save<br>
	 * @param StndUtCostVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiStndUtCost(StndUtCostVO[] listVos, SignOnUserAccount account) throws EventException {
		try {
			List<StndUtCostVO> updateVoList = new ArrayList<StndUtCostVO>();
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyStndUtCost(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0315 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String createStndUtCost(SearchConditionVO searchConditionVO) throws EventException {
		String pErrorCode = "";
    	try {
    		pErrorCode = dbDao.createStndUtCost(searchConditionVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
    	return pErrorCode;
    }
	
	/**
	 * ESM_MAS_0317 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<StndUtCostDtlVO>
	 * @exception EventException
	 */
	public List<StndUtCostDtlVO> searchStndUtCostDtlList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			if (searchConditionVO.getFYearweek().length() != 6) {	
				String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
				String cost_yrmon = arrSearch[0]+arrSearch[1];
				searchConditionVO.setFCostYrmon(cost_yrmon);  
			} else {
				searchConditionVO.setFCostYrmon(searchConditionVO.getFYearweek());
			}                                   

			return dbDao.searchStndUtCostDtlList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0317 - Save<br>
	 * @param StndUtCostDtlVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiStndUtCostDtl(StndUtCostDtlVO[] listVos, SignOnUserAccount account) throws EventException {
		try {
			List<StndUtCostDtlVO> updateVoList = new ArrayList<StndUtCostDtlVO>();
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyStndUtCostDtl(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_MAS_0317 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String createStndUtCostDtl(SearchConditionVO searchConditionVO) throws EventException {
		String pErrorCode = "";
    	try {
    		pErrorCode = dbDao.createStndUtCostDtl(searchConditionVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
    	return pErrorCode;
    }
	
	/**
	 * ESM_MAS_0318 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<StndUseQtyVO>
	 * @exception EventException
	 */
	public List<StndUseQtyVO> searchStndUseQtyList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			if (searchConditionVO.getFYearweek().length() != 6) {	
				String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
				String cost_yrmon = arrSearch[0]+arrSearch[1];
				searchConditionVO.setFCostYrmon(cost_yrmon);
			} else {
				searchConditionVO.setFCostYrmon(searchConditionVO.getFYearweek());
			}                                   
			return dbDao.searchStndUseQtyList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0318 - Save<br>
	 * @param StndUseQtyVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiStndUseQty(StndUseQtyVO[] listVos, SignOnUserAccount account) throws EventException {
		try {
			List<StndUseQtyVO> updateVoList = new ArrayList<StndUseQtyVO>();
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyStndUseQty(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_MAS_0318 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String createStndUseQty(SearchConditionVO searchConditionVO) throws EventException {
		String pErrorCode = "";
    	try {
    		pErrorCode = dbDao.createStndUseQty(searchConditionVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
    	return pErrorCode;
    }
	
	/**
	 * ESM_MAS_0319 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<StndUtCostDtlVO>
	 * @exception EventException
	 */
	public List<StndUtCostDtlVO> searchStndUtCostDtlPopList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String f_yearweek = arrSearch[0]+arrSearch[1];
			searchConditionVO.setFYearweek(f_yearweek);
			String f_cobcost = searchConditionVO.getFCobcost();
			return dbDao.searchStndUtCostDtlPopList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}