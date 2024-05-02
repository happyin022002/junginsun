/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AgencyCommissionBCImpl.java
*@FileTitle : Agency Commission 단가 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-21
*@LastModifier : 장영석
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.integration.AvgAgencyCommissionDBDAO;
import com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.vo.AvgAgencyCommissionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * opus-STDUnitCost Business Logic Command Interface<br>
 * - opus-STDUnitCost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Yeong-seok
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AvgAgencyCommissionBCImpl extends BasicCommandSupport implements AvgAgencyCommissionBC {

	// Database Access Object
	private transient AvgAgencyCommissionDBDAO dbDao = null;

	/**
	 * Average AgencyCommissionBCImpl 객체 생성<br>
	 * Average AgencyCommissionDBDAO를 생성한다.<br>
	 */
	public AvgAgencyCommissionBCImpl() {
		dbDao = new AvgAgencyCommissionDBDAO();
	}
	
	/**
	 * Office Average Agency Commission 정보를 조회 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<AvgAgencyCommissionVO>
	 * @exception EventException
	 */
	public List<AvgAgencyCommissionVO> searchAvgAgencyCommissionOfficeList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchAvgAgencyCommissionOfficeList(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Country Average Agency Commission 정보를 조회 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<AvgAgencyCommissionVO>
	 * @exception EventException
	 */
	public List<AvgAgencyCommissionVO> searchAvgAgencyCommissionCountryList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchAvgAgencyCommissionCountryList(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [Office Average Agency Commission 입력,수정,삭제<br>
	 * 
	 * @param AvgAgencyCommissionVO[] avgAgencyCommissionVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageAvgAgencyCommissionOffice(AvgAgencyCommissionVO[] avgAgencyCommissionVOs, SignOnUserAccount account) throws EventException{
		try {
			List<AvgAgencyCommissionVO> insertVoList = new ArrayList<AvgAgencyCommissionVO>();
			List<AvgAgencyCommissionVO> updateVoList = new ArrayList<AvgAgencyCommissionVO>();
			List<AvgAgencyCommissionVO> deleteVoList = new ArrayList<AvgAgencyCommissionVO>();
			
			for ( int i=0; i<avgAgencyCommissionVOs .length; i++ ) {
				avgAgencyCommissionVOs[i].setCreUsrId(account.getUsr_id());
				if ( avgAgencyCommissionVOs[i].getIbflag().equals("I")){
					insertVoList.add(avgAgencyCommissionVOs[i]);
				} else if ( avgAgencyCommissionVOs[i].getIbflag().equals("U")){
					updateVoList.add(avgAgencyCommissionVOs[i]);
				} else if ( avgAgencyCommissionVOs[i].getIbflag().equals("D")){
					deleteVoList.add(avgAgencyCommissionVOs[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				for(AvgAgencyCommissionVO vo : deleteVoList){
					dbDao.removeAvgAgencyCommissionOfficeList(vo);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				for(AvgAgencyCommissionVO vo : insertVoList){
					dbDao.mergeAvgAgencyCommissionOfficeList(vo);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				for(AvgAgencyCommissionVO vo : updateVoList){
					dbDao.mergeAvgAgencyCommissionOfficeList(vo);
				}
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
	 * [Country Average Agency Commission 입력,수정,삭제<br>
	 * 
	 * @param AvgAgencyCommissionVO[] avgAgencyCommissionVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageAvgAgencyCommissionCountry(AvgAgencyCommissionVO[] avgAgencyCommissionVOs, SignOnUserAccount account) throws EventException{
		try {
			List<AvgAgencyCommissionVO> insertVoList = new ArrayList<AvgAgencyCommissionVO>();
			List<AvgAgencyCommissionVO> updateVoList = new ArrayList<AvgAgencyCommissionVO>();
			List<AvgAgencyCommissionVO> deleteVoList = new ArrayList<AvgAgencyCommissionVO>();
			
			for ( int i=0; i<avgAgencyCommissionVOs .length; i++ ) {
				avgAgencyCommissionVOs[i].setCreUsrId(account.getUsr_id());
				if ( avgAgencyCommissionVOs[i].getIbflag().equals("I")){
					insertVoList.add(avgAgencyCommissionVOs[i]);
				} else if ( avgAgencyCommissionVOs[i].getIbflag().equals("U")){
					updateVoList.add(avgAgencyCommissionVOs[i]);
				} else if ( avgAgencyCommissionVOs[i].getIbflag().equals("D")){
					deleteVoList.add(avgAgencyCommissionVOs[i]);
				}
			}

			
			if ( deleteVoList.size() > 0 ) {
				for(AvgAgencyCommissionVO vo : deleteVoList){
					dbDao.removeAvgAgencyCommissionCountryList(vo);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				for(AvgAgencyCommissionVO vo : insertVoList){
					dbDao.mergeAvgAgencyCommissionCountryList(vo);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				for(AvgAgencyCommissionVO vo : updateVoList){
					dbDao.mergeAvgAgencyCommissionCountryList(vo);
				}
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}