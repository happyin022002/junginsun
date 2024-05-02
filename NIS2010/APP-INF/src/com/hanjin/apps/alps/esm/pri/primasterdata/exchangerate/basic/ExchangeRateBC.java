/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExchangeRateBC.java
*@FileTitle : Exchange Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.24 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.vo.CstGlMonXchRtVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.vo.RsltGlMonXchRtVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Primasterdata Business Logic Command Interface<br>
 * - ALPS-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4024EventResponse 참조
 * @since J2EE 1.6
 */

public interface ExchangeRateBC {

	/**
	 * Exchange Rate를 조회합니다.<br>
	 * 
	 * @param CstGlMonXchRtVO cstGlMonXchRtVO
	 * @return List<RsltGlMonXchRtVO>
	 * @exception EventException
	 */
	public List<RsltGlMonXchRtVO> searchExchangeRateList(CstGlMonXchRtVO cstGlMonXchRtVO) throws EventException;
}