/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0015Event.java
*@FileTitle : Monthly Clearance Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.11 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private StlConditionVO stlConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private StlConditionVO[] stlConditionVOs = null;

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

 
}