/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0049Event.java
*@FileTitle : Settlement Status for Basic Allocation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.10 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0049HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0049Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private StlConditionVO   stlConditionVO = null;
	private StlConditionVO[] stlConditionVOs = null;
	
	 
	public FnsJoo0049Event(){}


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
    	StlConditionVO[] tmpVOs = null;
		if (this.stlConditionVOs != null) {
			tmpVOs = new StlConditionVO[stlConditionVOs.length];
			System.arraycopy(stlConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
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
 

}