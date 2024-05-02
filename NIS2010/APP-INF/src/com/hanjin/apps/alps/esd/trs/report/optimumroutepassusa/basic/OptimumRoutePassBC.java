/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OptimumRoutePassBC.java
*@FileTitle : Optimum Route Pass
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-17
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassCondVO;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassDtlVO;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassBkgDtlVO;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassSmryVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ALPS-OptimumRoutePass Business Logic Command Interface<br>
 * - ALPS-OptimumRoutePass 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 조인영
 * @see ESD_TRS_3001EventResponse 참조
 * @since J2EE 1.6
 */
public interface OptimumRoutePassBC  {

	/**
	 * Optimum Route Pass - Summary<br>
	 * 
	 * @param OptmRoutPassCondVO optmRoutPassCondVO
	 * @return List<OptmRoutPassSmryVO>
	 * @exception EventException
	 */
	public List<OptmRoutPassSmryVO> searchOptmRoutPassSmry(OptmRoutPassCondVO optmRoutPassCondVO) throws EventException;
	
	/**
	 * Optimum Route Pass - Detail<br>
	 * 
	 * @param OptmRoutPassCondVO optmRoutPassCondVO
	 * @return List<OptmRoutPassDtlVO>
	 * @exception EventException
	 */
	public List<OptmRoutPassDtlVO> searchOptmRoutPassDtl(OptmRoutPassCondVO optmRoutPassCondVO) throws EventException;
	
	/**
	 * Optimum Route Pass - BKG Detail<br>
	 * 
	 * @param OptmRoutPassCondVO optmRoutPassCondVO
	 * @return List<OptmRoutPassDtlVO>
	 * @exception EventException
	 */
	public List<OptmRoutPassBkgDtlVO> searchOptmRoutPassBkgDtl(OptmRoutPassCondVO optmRoutPassCondVO) throws EventException;
}
