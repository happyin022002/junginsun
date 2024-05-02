/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0039Event.java
*@FileTitle : Monthly Clearance Status by Carrier & Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.29 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.JooSettlementVO;


/**
 * FNS_JOO_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0039HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    public FnsJoo0039Event(){}
    
	private StlConditionVO   stlConditionVO = null;
    private JooSettlementVO[] jooSettlementVOs = null;

    /**
     * @return the stlConditionVO
     */
    public StlConditionVO getStlConditionVO() {
        return stlConditionVO;
    }
    /**
     * @return the jooSettlementVOs
     */
    public JooSettlementVO[] getJooSettlementVOs() {
    	JooSettlementVO[] tmpVOs = null;
		if (this.jooSettlementVOs != null) {
			tmpVOs = new JooSettlementVO[jooSettlementVOs.length];
			System.arraycopy(jooSettlementVOs, 0, tmpVOs, 0, tmpVOs.length);
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
     * @param jooSettlementVOs the jooSettlementVOs to set
     */
    public void setJooSettlementVOs(JooSettlementVO[] jooSettlementVOs) {
		if (jooSettlementVOs != null) {
			JooSettlementVO[] tmpVOs = new JooSettlementVO[jooSettlementVOs.length];
			System.arraycopy(jooSettlementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooSettlementVOs = tmpVOs;
		}
    }
 

}