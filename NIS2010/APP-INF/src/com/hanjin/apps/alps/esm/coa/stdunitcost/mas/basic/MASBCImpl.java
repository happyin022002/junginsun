/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MASBCImpl.java
*@FileTitle : ABC (PA) / STP Cost (RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 전윤주
*@LastVersion : 1.0 
* 2009.08.04 전윤주
* 1.0 Creation
* 
* 2012.08.27 이석준[CHM-201219844-01]   ABC(PA)/STP Cost(RA)화면에 Month Copy 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mas.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mas.integration.MASDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mas.vo.SearchMAS0012ListVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.syscommon.common.table.CoaSvcTrnsPrcVO;

/**
 * ALPS-STDUnitCost Business Logic Basic Command implementation<br>
 * - ALPS-STDUnitCost에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jeon Yun Joo
 * @see ESM_COA_0012EventResponse,MASBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MASBCImpl extends BasicCommandSupport implements MASBC {

	// Database Access Object
	private transient MASDBDAO dbDao = null;

	/**
	 * MASBCImpl 객체 생성<br>
	 * MASDBDAO를 생성한다.<br>
	 */
	public MASBCImpl() {
		dbDao = new MASDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchMAS0012ListVO searchMAS0012ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMAS0012ListVO>
	 * @exception EventException
	 */
	public List<SearchMAS0012ListVO> searchMAS0012List(SearchMAS0012ListVO searchMAS0012ListVO
			                                          ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchMAS0012List(searchMAS0012ListVO, searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CoaSvcTrnsPrcVO[] coaSvcTrnsPrcVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiMAS0012(CoaSvcTrnsPrcVO[] coaSvcTrnsPrcVO, SignOnUserAccount account) throws EventException{
		try {			
			List<CoaSvcTrnsPrcVO> updateVoList = new ArrayList<CoaSvcTrnsPrcVO>();			
			for ( int i=0; i<coaSvcTrnsPrcVO.length; i++ ) {				
				 if ( coaSvcTrnsPrcVO[i].getIbflag().equals("U")){					
					coaSvcTrnsPrcVO[i].setUpdUsrId(account.getUsr_id());					
					updateVoList.add(coaSvcTrnsPrcVO[i]);					
				}
			}			
		
			if ( updateVoList.size() > 0 ) {				
				dbDao.modifyMAS0012(updateVoList);
			}			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 생성 이벤트 처리<br>
	 * ABC/STP 월단가를 복사해서 생성한다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createAbcStpCostMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());

            //1. ABC/STP 관련 TABLE들을 삭제 한다.
            dbDao.removeAbcStpCost(param);

            //2. Source월에서 Target 월로 데이터 인서트
              dbDao.createCopyAbcStpCost(param);
            //3. 복사 상태를 단가 관리 table에 insert 한다.
            dbDao.modifyAbcStpCopyCreationStatus(param);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}	
	
}