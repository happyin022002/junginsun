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
package com.clt.apps.opus.cps.cni.codemgt.codemgt.event;


import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniClassCodeVO;
import com.clt.framework.support.layer.event.EventSupport;

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
		CniClassCodeVO[] rtnVOs = null;
		if (this.cniClassCodeVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cniClassCodeVOs, cniClassCodeVOs.length);
		}
		return rtnVOs;
	}
	

	/**                                                                
     * CniClassCodeVO 설정
     * @param CniClassCodeVO[]
     */   
	public void setCniClassCodeVOs(CniClassCodeVO[] cniClassCodeVOs){
		if(cniClassCodeVOs != null){
			CniClassCodeVO[] tmpVOs = java.util.Arrays.copyOf(cniClassCodeVOs, cniClassCodeVOs.length);
			this.cniClassCodeVOs = tmpVOs;
		}
	}

}