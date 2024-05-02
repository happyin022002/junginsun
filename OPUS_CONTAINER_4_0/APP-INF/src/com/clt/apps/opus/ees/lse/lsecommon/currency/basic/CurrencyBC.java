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
package com.clt.apps.opus.ees.lse.lsecommon.currency.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmCurrencyVO;

/**
 * Currency Business Logic Command Interface<br>
 * Currency에 대한 비지니스 로직에 대한 인터페이스<br>
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