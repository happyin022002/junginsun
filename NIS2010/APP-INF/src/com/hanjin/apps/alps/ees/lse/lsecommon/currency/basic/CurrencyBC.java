/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CurrencyBC.java
*@FileTitle : Currency Code Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.currency.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;

/**
 * ALPS-Currency Business Logic Command Interface<br>
 * - ALPS-Currency에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Nho Jung Yong
 * @see 
 * @since J2EE 1.4
 */

public interface CurrencyBC {

	/**
	 * Currency 코드목록을 조회합니다.<br>
	 * 
	 * @param String currCd
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrencyListBasic(String currCd) throws EventException;
}