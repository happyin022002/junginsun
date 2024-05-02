/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0110Event.java
*@FileTitle : SlotHire Target
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.30 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event;

import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.SltHirTgtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoEstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoSettlementConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlTgtVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 

/**
 * FNS_JOO_0110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0110HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0110Event extends EventSupport {

	private static final long serialVersionUID = 1L;

    /**
     *  조회옵션처리 VO
	 */
	private JoSettlementConditionVO joSettlementConditionVO = null;
	
	private JoEstmConditionVO joEstmConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
    private  SltHirTgtVO sltHirTgtVO = null;
    
    /** Table Value Object Multi Data 처리 */
    private StlTgtVO[] stlTgtVOs = null;
 
	public FnsJoo0110Event(){}

	/**
     * @return the settlementConditionVO
     */
    public JoSettlementConditionVO getJoSettlementConditionVO() {
        return joSettlementConditionVO;
    }


    /**
     * @return the sltHirTgtVO
     */
    public SltHirTgtVO getSltHirTgtVO() {
        return sltHirTgtVO;
    }


    /**
     * @return the sltHirTgtVOs
     */
    public StlTgtVO[] getStlTgtVOs() {
    	StlTgtVO[] rtnVOs = null;
		if (this.stlTgtVOs != null) {
			rtnVOs = new StlTgtVO[stlTgtVOs.length];
			System.arraycopy(stlTgtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;        
    }


    /**
     * @param settlementConditionVO the settlementConditionVO to set
     */
    public void setJoSettlementConditionVO(JoSettlementConditionVO joSettlementConditionVO) {
        this.joSettlementConditionVO = joSettlementConditionVO;
    }


    /**
     * @param sltHirTgtVO the sltHirTgtVO to set
     */
    public void setSltHirTgtVO(SltHirTgtVO sltHirTgtVO) {
        this.sltHirTgtVO = sltHirTgtVO;
    }


    /**
     * @param stlTgtVOs the stlTgtVOs to set
     */
    public void setStlTgtVOs(StlTgtVO[] stlTgtVOs) {
		if (stlTgtVOs != null) {
			StlTgtVO[] tmpVOs = new StlTgtVO[stlTgtVOs.length];
			System.arraycopy(stlTgtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.stlTgtVOs = tmpVOs;
		}                
    }

    public JoEstmConditionVO getJoEstmConditionVO() {
		return joEstmConditionVO;
	}

	public void setJoEstmConditionVO(JoEstmConditionVO joEstmConditionVO) {
		this.joEstmConditionVO = joEstmConditionVO;
	}

}