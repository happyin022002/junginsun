/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0050Event.java
*@FileTitle : Target Voyage vs Unsettled Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.10 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlStatusVO;


/**
 * FNS_JOO_0050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0050HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0050Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    private StlConditionVO   stlConditionVO = null;
    private StlConditionVO[] stlConditionVOs = null;
    
	private StlStatusVO stlStatusVO = null;
    private StlStatusVO[] stlStatusVOs = null;
    
    /**
     * @return the stlConditionVO
     */
    public StlConditionVO getStlConditionVO() {
        return stlConditionVO;
    }
    
    /**
     * @return the stlConditionVOs
     */
    public StlConditionVO[] getStlConditionVOs() {
        StlConditionVO[] rtnVOs = null;
		if (this.stlConditionVOs != null) {
			rtnVOs = new StlConditionVO[stlConditionVOs.length];
			System.arraycopy(stlConditionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;        
    }
    
    /**
     * @param stlConditionVO the stlConditionVO to set
     */
    public void setStlConditionVO(StlConditionVO stlConditionVO) {
        this.stlConditionVO = stlConditionVO;
    }
    
    /**
     * @param stlConditionVOs the stlConditionVOs to set
     */
    public void setStlConditionVOs(StlConditionVO[] stlConditionVOs) {
		if (stlConditionVOs != null) {
			StlConditionVO[] tmpVOs = new StlConditionVO[stlConditionVOs.length];
			System.arraycopy(stlConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.stlConditionVOs = tmpVOs;
		}        
    }
    
    public StlStatusVO getStlStatusVO() {
		return stlStatusVO;
	}
    
	public void setStlStatusVO(StlStatusVO stlStatusVO) {
		this.stlStatusVO = stlStatusVO;
	}
	
	public StlStatusVO[] getStlStatusVOs() {
		StlStatusVO[] rtnVOs = null;
		if (this.stlStatusVOs != null) {
			rtnVOs = new StlStatusVO[stlStatusVOs.length];
			System.arraycopy(stlStatusVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
	
	public void setStlStatusVOs(StlStatusVO[] stlStatusVOs) {
		if (stlStatusVOs != null) {
			StlStatusVO[] tmpVOs = new StlStatusVO[stlStatusVOs.length];
			System.arraycopy(stlStatusVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.stlStatusVOs = tmpVOs;
		}				
	}
}