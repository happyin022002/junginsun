/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanCompareBCImpl.java
*@FileTitle : 이송계획 및 비용 상세 비교 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.12 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.basic;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.integration.CntrRepoPlanCompareDBDAO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo.EesEqr0135ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo.EesEqr0070ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-CntrRepoPlanCompare Business Logic Command Interface<br>
 * - ALPS-CntrRepoPlanCompare 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author ChungEunHo
 * @see	EventResponse 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanCompareBCImpl extends BasicCommandSupport implements CntrRepoPlanCompareBC {

	// Database Access Object
	private transient CntrRepoPlanCompareDBDAO dbDao = null;

	/**
	 * CntrRepoPlanCompareBCImpl 객체 생성<br>
	 * CntrRepoPlanCompareDBDAO를 생성한다.<br>
	 */
	public CntrRepoPlanCompareBCImpl() {
		dbDao = new CntrRepoPlanCompareDBDAO();
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EesEqr0070ConditionVO eesEqr0070ConditionVO
	 * @return List<searchRepoPlanAndCostFromToDetail>
	 * @exception EventException
	 */
	public CommonRsVO searchRepoPlanAndCostDetail(EesEqr0070ConditionVO eesEqr0070ConditionVO) throws EventException {
		try {
			return dbDao.searchRepoPlanAndCostDetail(eesEqr0070ConditionVO);
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
	 * CntrRepoPlanFromToCompare화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param eesEqr0135ConditionVO EesEqr0135ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchRepoPlanAndCostFromToDetail(EesEqr0135ConditionVO eesEqr0135ConditionVO) throws EventException {
		try {
			return dbDao.searchRepoPlanAndCostFromToDetail(eesEqr0135ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
}