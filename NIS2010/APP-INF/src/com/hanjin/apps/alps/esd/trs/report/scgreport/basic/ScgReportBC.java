/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ScgReportBC.java
*@FileTitle : Surcharge Report
*Open Issues :
*Change history :
*@LastModifyDate : 2013-10-16
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.scgreport.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgCondVO;
import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgDtlVO;
import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgSmryVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ALPS-Surcharge Report Business Logic Command Interface<br>
 * - ALPS-Surcharge Report 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 조인영
 * @see ESD_TRS_3001EventResponse 참조
 * @since J2EE 1.6
 */
public interface ScgReportBC  {

	/**
	 * Surcharge Report - Summary<br>
	 * 
	 * @param ScgCondVO ScgCondVO
	 * @return List<ScgSmryVO>
	 * @exception EventException
	 */
	public List<ScgSmryVO> searchScgSmry(ScgCondVO ScgCondVO) throws EventException;
	
	/**
	 * Surcharge Report - Detail<br>
	 * 
	 * @param ScgCondVO ScgCondVO
	 * @return List<ScgDtlVO>
	 * @exception EventException
	 */
	public List<ScgDtlVO> searchScgDtl(ScgCondVO ScgCondVO) throws EventException;

}
