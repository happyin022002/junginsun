/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs3002Event.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event;

import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostConditionVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_3002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see ESD_TRS_3002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs3002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String inCntCd = "";
	private String inCostTrfNo = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InlandCostDetailVO inlandCostDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InlandCostDetailVO[] inlandCostDetailVOs = null;
	private InlandCostConditionVO inlandCostConditionVO = null;
	
	public EsdTrs3002Event(){}
	
	/* InlandCostDetailVO - start */
	public void setInlandCostDetailVO(InlandCostDetailVO inlandCostDetailVO){
		this. inlandCostDetailVO = inlandCostDetailVO;
	}

	public void setInlandCostDetailVOS(InlandCostDetailVO[] inlandCostDetailVOs){
		this. inlandCostDetailVOs = inlandCostDetailVOs;
	}

	public InlandCostDetailVO getInlandCostDetailVO(){
		return inlandCostDetailVO;
	}

	public InlandCostDetailVO[] getInlandCostDetailVOS(){
		return inlandCostDetailVOs;
	}
	/* InlandCostDetailVO - end */
	
	public void setInlandCostConditionVO(InlandCostConditionVO inlandCostConditionVO) {
		this.inlandCostConditionVO = inlandCostConditionVO;
	}
	
	public InlandCostConditionVO getInlandCostConditionVO() {
		return inlandCostConditionVO;
	}

    /**
     * @return the inCntCd
     */
    public String getInCntCd() {
        return inCntCd;
    }

    /**
     * @return the inCostTrfNo
     */
    public String getInCostTrfNo() {
        return inCostTrfNo;
    }

    /**
     * @param cntCd the inCntCd to set
     */
    public void setInCntCd(String cntCd) {
        inCntCd = cntCd;
    }

    /**
     * @param costTrfNo the inCostTrfNo to set
     */
    public void setInCostTrfNo(String costTrfNo) {
    	inCostTrfNo = costTrfNo;
    }
}
