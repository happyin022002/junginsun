/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTOthCommBCImpl.java
*@FileTitle : Commission Unit Cost Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.13 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.integration.AGTOthCommDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.AgtOtrUtCostVO;

/**
 * ALPS-AGTAgreement Business Logic Basic Command implementation<br>
 * - ALPS-AGTAgreement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kyung-won Chu
 * @see ESM_AGT_0009EventResponse,AGTOthCommBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AGTOthCommBCImpl extends BasicCommandSupport implements AGTOthCommBC {

	// Database Access Object
	private transient AGTOthCommDBDAO dbDao = null;

	/**
	 * AGTOthCommBCImpl 객체 생성<br>
	 * AGTOthCommDBDAO를 생성한다.<br>
	 */
	public AGTOthCommBCImpl() {
		dbDao = new AGTOthCommDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param AgtOtrUtCostVO agtOtrUtCostVO
	 * @return List<AgtOtrUtCostVO>
	 * @exception EventException
	 */
	public List<AgtOtrUtCostVO> searchOtherUnitCostInfoList(AgtOtrUtCostVO agtOtrUtCostVO) throws EventException {
		try {
			return dbDao.searchOtherUnitCostInfoList(agtOtrUtCostVO);
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
		 * @param AgtOtrUtCostVO agtOtrUtCostVO
		 * @return List<AgtOtrUtCostVO>
		 * @exception EventException
		 */
		public List<AgtOtrUtCostVO> searchUpdateDate(AgtOtrUtCostVO agtOtrUtCostVO) throws EventException {
			try {
				return dbDao.searchUpdateDate(agtOtrUtCostVO);
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			}

		
	}
	
}