/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0104Event.java
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
import com.hanjin.framework.support.layer.event.EventSupport;
 

/**
 * FNS_JOO_0104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0104HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0104Event extends EventSupport {

	private static final long serialVersionUID = 1L;

    /**
     *  조회옵션처리 VO
	 */
	private JoSettlementConditionVO joSettlementConditionVO = null;
	
	private JoEstmConditionVO joEstmConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
    private  SltHirTgtVO sltHirTgtVO = null;
    
    /** Table Value Object Multi Data 처리 */
    private SltHirTgtVO[] sltHirTgtVOs = null;
 
	public FnsJoo0104Event(){}

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
    public SltHirTgtVO[] getSltHirTgtVOs() {
    	SltHirTgtVO[] rtnVOs = null;
		if (this.sltHirTgtVOs != null) {
			rtnVOs = new SltHirTgtVO[sltHirTgtVOs.length];
			System.arraycopy(sltHirTgtVOs, 0, rtnVOs, 0, rtnVOs.length);
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
     * @param sltHirTgtVOs the sltHirTgtVOs to set
     */
    public void setSltHirTgtVOs(SltHirTgtVO[] sltHirTgtVOs) {
		if (sltHirTgtVOs != null) {
			SltHirTgtVO[] tmpVOs = new SltHirTgtVO[sltHirTgtVOs.length];
			System.arraycopy(sltHirTgtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sltHirTgtVOs = tmpVOs;
		}                
    }

    public JoEstmConditionVO getJoEstmConditionVO() {
		return joEstmConditionVO;
	}

	public void setJoEstmConditionVO(JoEstmConditionVO joEstmConditionVO) {
		this.joEstmConditionVO = joEstmConditionVO;
	}

}