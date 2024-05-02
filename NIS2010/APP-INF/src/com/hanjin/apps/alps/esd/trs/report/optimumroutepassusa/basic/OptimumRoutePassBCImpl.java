/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OptimumRoutePassBCImpl.java
*@FileTitle : Optimum Route Pass
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-17
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.integration.OptimumRoutePassDBDAO;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassCondVO;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassDtlVO;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassBkgDtlVO;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassSmryVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
 
/**
 * ALPS-OptimumRoutePass Business Logic Basic Command implementation<br>
 * - ALPS-OptimumRoutePass에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jong Ock
 * @see ESD_TRS_3001EventResponse,OptimumRoutePassBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OptimumRoutePassBCImpl extends BasicCommandSupport implements OptimumRoutePassBC {
	
	// Database Access Object
	private transient OptimumRoutePassDBDAO dbDao = null;

	/**
	 * OptimumRoutePassBCImpl 객체 생성<br>
	 * OptimumRoutePassDBDAO를 생성한다.<br>
	 */
	public OptimumRoutePassBCImpl() {
		dbDao = new OptimumRoutePassDBDAO();
	}

	/**
	 * Optimum Route Pass - Summary<br>
	 * 
	 * @param OptmRoutPassCondVO optmRoutPassCondVO
	 * @return List<OptmRoutPassSmryVO>
	 * @exception EventException
	 */
	public List<OptmRoutPassSmryVO> searchOptmRoutPassSmry(OptmRoutPassCondVO optmRoutPassCondVO) throws EventException {
		try {
			return dbDao.searchOptmRoutPassSmry(optmRoutPassCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		        
	}

	/**
	 * Optimum Route Pass - Detail<br>
	 * 
	 * @param OptmRoutPassCondVO optmRoutPassCondVO
	 * @return List<OptmRoutPassDtlVO>
	 * @exception EventException
	 */
	public List<OptmRoutPassDtlVO> searchOptmRoutPassDtl(OptmRoutPassCondVO optmRoutPassCondVO) throws EventException {
		try {
			return dbDao.searchOptmRoutPassDtl(optmRoutPassCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		        
	}
	
	/**
	 * Optimum Route Pass - BKG Detail<br>
	 * 
	 * @param OptmRoutPassCondVO optmRoutPassCondVO
	 * @return List<OptmRoutPassDtlVO>
	 * @exception EventException
	 */
	public List<OptmRoutPassBkgDtlVO> searchOptmRoutPassBkgDtl(OptmRoutPassCondVO optmRoutPassCondVO) throws EventException {
		try {
			return dbDao.searchOptmRoutPassBkgDtl(optmRoutPassCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		        
	}

}