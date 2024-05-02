/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TrnsModCompBC.java
*@FileTitle : Inland Transmode Comparison
*Open Issues :
*Change history :
*@LastModifyDate : 2013-12-18
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.transmodecomp.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.report.transmodecomp.vo.TrnsModCompVO;
import com.hanjin.apps.alps.esd.trs.report.transmodecomp.vo.TrnsModCompCondVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ALPS-Inland Transmode Comparison Business Logic Command Interface<br>
 * - ALPS-Inland Transmode Comparison 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 조인영
 * @see ESD_TRS_3001EventResponse 참조
 * @since J2EE 1.6
 */
public interface TrnsModCompBC  {

	/**
	 * Inland Transmode Comparison<br>
	 * 
	 * @param TrnsModCompCondVO TrnsModCompCondVO
	 * @return List<ScgSmryVO>
	 * @exception EventException
	 */
	public List<TrnsModCompVO> searchTrnsModComp(TrnsModCompCondVO TrnsModCompCondVO) throws EventException;
	

}
