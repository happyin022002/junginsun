/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExchangeRateBC.java
*@FileTitle : Exchange Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.exchangerate.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.exchangerate.vo.CstGlMonXchRtVO;
import com.clt.apps.opus.esm.pri.primasterdata.exchangerate.vo.RsltGlMonXchRtVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic about Primasterdata<br>
 *
 * @author 
 * @see Esm_pri_4024EventResponse 
 * @since J2EE 1.6
 */

public interface ExchangeRateBC {

	/**
	 * Retrieving Exchange Rate.<br>
	 * 
	 * @param CstGlMonXchRtVO cstGlMonXchRtVO
	 * @return List<RsltGlMonXchRtVO>
	 * @exception EventException
	 */
	public List<RsltGlMonXchRtVO> searchExchangeRateList(CstGlMonXchRtVO cstGlMonXchRtVO) throws EventException;
}