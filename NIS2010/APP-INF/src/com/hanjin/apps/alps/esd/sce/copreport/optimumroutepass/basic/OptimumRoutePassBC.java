/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OptimumRoutePassBC.java
*@FileTitle : Optimum Route Pass
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo.OptmRoutPassCondVO;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo.OptmRoutPassDtlVO;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo.OptmRoutPassSmryVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ALPS-OptimumRoutePass Business Logic Command Interface<br>
 * - ALPS-OptimumRoutePass 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jong Ock
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
}
