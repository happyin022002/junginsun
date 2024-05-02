/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustomerBC.java
*@FileTitle : Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-09
*@LastModifier : sangyool pak
*@LastVersion : 1.0
* 2006-08-09 sangyool pak
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.customer.basic;

import java.util.List;

import com.hanjin.bizcommon.customer.vo.SearchCustomerVO;
import com.hanjin.bizcommon.customer.vo.SearchSrepVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ENIS-BIZCOMMON Business Logic Command Interface<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 * @author sangyool pak
 * @see ComEns041EventResponse 참조
 * @since J2EE 1.4
 */
public interface CustomerBC  {

	/**
	 * Customer List 조회<br>
	 * @param String custCd 
	 * @param String custNm
	 * @param String ofcCd
	 * @param int iPage
	 * @param String include
	 * @param String cust
	 * @param String zipCd
	 * @return List<SearchCustomerVO>
	 * 
	 * @throws EventException
	 */
	public List<SearchCustomerVO> searchCustomerList(String custCd, String custNm, String ofcCd, int iPage, String include, String cust, String zipCd) throws EventException;

	public List<SearchSrepVO> searchSrepList(String srepCd, String srepNm, String ofcCd, String gloUsrId, int iPage) throws EventException;
}