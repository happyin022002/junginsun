/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CurrencyBC.java
*@FileTitle : Currency Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.currency.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmCurrencyVO;


/**
 * Primasterdata Business Logic Command Interface<br>
 * - interface about Primasterdata biz logic<br>
 *
 * @author 
 * @see Esm_pri_4020EventResponse 
 * @since J2EE 1.6
 */

public interface CurrencyBC {

	/**
	 * Retrieving Currency Inquiry<br>
	 * 
	 * @param MdmCurrencyVO mdmCurrencyVO
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrencyList(MdmCurrencyVO mdmCurrencyVO) throws EventException;
}