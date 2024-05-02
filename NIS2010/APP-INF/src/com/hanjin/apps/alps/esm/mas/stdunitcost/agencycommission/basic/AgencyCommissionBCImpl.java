/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AgencyCommissionBCImpl.java
*@FileTitle : Agency Commission 단가 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-21
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2007-07-03 JEON SUNGJIN
* 1.0 최초 생성 CSR No.N200807030011
* 2009-09-21 장영석  New Framework 적용 [0157]
* 2010.02.05 임옥영 소스품질검토 결과 반영 (클래스주석)
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.integration.AgencyCommissionDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.hanjin.syscommon.common.table.MasOtrCommVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;


/**
 * ALPS-STDUnitCost Business Logic Command Interface<br>
 * - ALPS-STDUnitCost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Yeong-seok
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AgencyCommissionBCImpl extends BasicCommandSupport implements AgencyCommissionBC {

	// Database Access Object
	private transient AgencyCommissionDBDAO dbDao = null;

	/**
	 * AgencyCommissionBCImpl 객체 생성<br>
	 * AgencyCommissionDBDAO를 생성한다.<br>
	 */
	public AgencyCommissionBCImpl() {
		dbDao = new AgencyCommissionDBDAO();
	}
	/**
	 * Agent Commission 단가를 조회<br>
	 * 
	 * @param SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchAgnOtrCommCostListVO>
	 * @exception EventException
	 */
	public List<SearchAgnOtrCommCostListVO> searchAgnOtrCommCostList(SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO, SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchAgnOtrCommCostList(searchAgnOtrCommCostListVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [Agent Commission 단가를 입력,수정,삭제<br>
	 * 
	 * @param MasOtrCommVO[] masOtrCommVO
	 * @param SearchConditionVO searchConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiAgnOtrCommCost(MasOtrCommVO[] masOtrCommVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<MasOtrCommVO> insertVoList = new ArrayList<MasOtrCommVO>();
			List<MasOtrCommVO> updateVoList = new ArrayList<MasOtrCommVO>();
			List<MasOtrCommVO> deleteVoList = new ArrayList<MasOtrCommVO>();
			for ( int i=0; i<masOtrCommVO .length; i++ ) {
				if ( masOtrCommVO[i].getIbflag().equals("I")){
					masOtrCommVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(masOtrCommVO[i]);
				} else if ( masOtrCommVO[i].getIbflag().equals("U")){
					masOtrCommVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(masOtrCommVO[i]);
				} else if ( masOtrCommVO[i].getIbflag().equals("D")){
					deleteVoList.add(masOtrCommVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiAgnOtrCommCost(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiAgnOtrCommCost(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiAgnOtrCommCost(deleteVoList);
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
  * [비즈니스대상]을 [행위] 합니다.<br>
  * 
  * @param SearchConditionVO conditionVO
  * @return List<DemDet3rdVO>
  * @exception EventException
  */
 public Integer searchAgnOtrCommCostMonthCount(SearchConditionVO conditionVO) throws EventException{
     conditionVO.unDataFormat();

     try {
         return dbDao.searchAgnOtrCommCostMonthCount(conditionVO);
     } catch(DAOException ex) {
         log.error("err " + ex.toString(), ex);
         throw new EventException(new ErrorHandler(ex).getMessage());
     } catch (Exception ex) {
         log.error("err " + ex.toString(), ex);
         throw new EventException(new ErrorHandler(ex).getMessage());
     }
 }
 
 public void createAgnOtrCommCostMonthCopy(SearchConditionVO conditionVO, SignOnUserAccount account)throws EventException{
     HashMap<String, String> param = new HashMap<String, String>();

     try {
         //파라미터 세팅
         param.put("f_src_mon"       , conditionVO.getFSrcMon().replaceAll("-", ""));
         param.put("f_tar_mon"       , conditionVO.getFTarMon().replaceAll("-", ""));
         param.put("user_id"         , account.getUsr_id());

         //1. TARGET 해당월을 삭제한다.
         dbDao.removeAgnOtrCommCostMonth(param);
         //2. CSOURCE 해당월을 복사해서  TARGET 데이타를 생성한다. 
         dbDao.addAgnOtrCommCostMonthCopy(param);
         dbDao.addAgnOtrCommCostStatusMonthCopy(param);

      } catch (DAOException ex) {
         throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
     } catch (Exception ex) {
         throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
     }       
 }

 
	
}