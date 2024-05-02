/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TrnsModCompBCImpl.java
*@FileTitle : Inland Transmode Comparison
*Open Issues :
*Change history :
*@LastModifyDate : 2013-12-18
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.transmodecomp.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.report.transmodecomp.integration.TrnsModCompDBDAO;
import com.hanjin.apps.alps.esd.trs.report.transmodecomp.vo.TrnsModCompCondVO;
import com.hanjin.apps.alps.esd.trs.report.transmodecomp.vo.TrnsModCompVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
 
/**
 * ALPS-Inland Transmode Comparison Business Logic Basic Command implementation<br>
 * - ALPS-Inland Transmode Comparison에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 조인영
 * @see ESD_TRS_3001EventResponse,TrnsModCompBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TrnsModCompBCImpl extends BasicCommandSupport implements TrnsModCompBC {
	
	// Database Access Object
	private transient TrnsModCompDBDAO dbDao = null;

	/**
	 * TrnsModCompBCImpl 객체 생성<br>
	 * TrnsModCompDBDAO를 생성한다.<br>
	 */
	public TrnsModCompBCImpl() {
		dbDao = new TrnsModCompDBDAO();
	}

	/**
	 * Inland Transmode Comparison<br>
	 * 
	 * @param TrnsModCompCondVO TrnsModCompCondVO
	 * @return List<TrnsModCompVO>
	 * @exception EventException
	 */
	public List<TrnsModCompVO> searchTrnsModComp(TrnsModCompCondVO TrnsModCompCondVO) throws EventException {
		try {
			return dbDao.searchTrnsModComp(TrnsModCompCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		        
	}

}