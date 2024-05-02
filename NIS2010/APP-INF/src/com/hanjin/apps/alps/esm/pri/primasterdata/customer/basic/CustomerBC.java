/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomerBC.java
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.04.29 김재연
* 1.0 Creation
* =========================================================
* History
* 2013.05.28 이혜민 [CHM-201324516-01] Surcharge 종합체계 구축 T/F - Surcharge Summary Report 화면 신규개발
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.customer.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.customer.vo.MdmCustVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-Primasterdata Business Logic Command Interface<br>
 * - NIS2010-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4014EventResponse 참조
 * @since J2EE 1.4
 */

public interface CustomerBC {
	/**
	 * Customer List를 조회합니다. <br>
	 * 
	 * @param MdmCustVO mdmCustVO
	 * @return List<MdmCustVO>
	 * @exception EventException
	 */
	public List<MdmCustVO> searchCustomerList(MdmCustVO mdmCustVO) throws EventException;
	
	/**
	 * Group Customer List를 조회합니다. <br>
	 * 
	 * @param MdmCustVO mdmCustVO
	 * @return List<MdmCustVO>
	 * @exception EventException
	 */
	public List<MdmCustVO> searchGroupCustomerList(MdmCustVO mdmCustVO) throws EventException;
}