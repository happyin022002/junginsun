/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0101Event.java
 *@FileTitle : Authorized Expense Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.AuthExpnInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM_0101] Authorized Expense Code
 * @author choijungmi
 * @see CPS_GEM_0101HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0101Event extends EventSupport {

	private static final long serialVersionUID = 1L;

    private AuthExpnInfoVO authExpnInfoVO ;

	public AuthExpnInfoVO getAuthExpnInfoVO() {
		return authExpnInfoVO;
	}

	public void setAuthExpnInfoVO(AuthExpnInfoVO authExpnInfoVO) {
		this.authExpnInfoVO = authExpnInfoVO;
	} 
	
	
	



}