/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0039Event.java
 *@FileTitle : Class Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.10.05 박제성 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event;


import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniClassCodeVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0039] Class Code Creation
 * @author 박제성
 * @see CPS_CNI_0039HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    
	/** Table Value Object Multi Data 처리 */
	private CniClassCodeVO[] cniClassCodeVOs = null;
    


    
	/**                                                                
     * CniClassCodeVO 취득
     * @return CniClassCodeVO[]
     */   
	public CniClassCodeVO[] getCniClassCodeVOs() {
		return cniClassCodeVOs;
	}
	

	/**                                                                
     * CniClassCodeVO 설정
     * @param CniClassCodeVO[]
     */   
	public void setCniClassCodeVOs(CniClassCodeVO[] cniClassCodeVOs) {
		this.cniClassCodeVOs = cniClassCodeVOs;
	}

}