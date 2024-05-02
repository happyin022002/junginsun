/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3103Event.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3103HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String inCntCd = "";
	private String inCostTrfNo = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AsiaInlandCostDetailVO asiaInlandCostDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AsiaInlandCostDetailVO[] asiaInlandCostDetailVOs = null;
	private AsiaInlandCostConditionVO asiaInlandCostConditionVO = null;
	
	public EsdAoc3103Event(){}
	
	/* AsiaInlandCostDetailVO - start */
	public void setInlandCostDetailVO(AsiaInlandCostDetailVO asiaInlandCostDetailVO){
		this. asiaInlandCostDetailVO = asiaInlandCostDetailVO;
	}

	public void setInlandCostDetailVOS(AsiaInlandCostDetailVO[] inlandCostDetailVOs){
		if(inlandCostDetailVOs != null){
			AsiaInlandCostDetailVO[] tmpVOs = new AsiaInlandCostDetailVO[inlandCostDetailVOs.length];
			System.arraycopy(inlandCostDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaInlandCostDetailVOs = tmpVOs;
		}
	}

	public AsiaInlandCostDetailVO getInlandCostDetailVO(){
		return asiaInlandCostDetailVO;
	}

	public AsiaInlandCostDetailVO[] getInlandCostDetailVOS(){
		AsiaInlandCostDetailVO[] rtnVOs = null;
		if (this.asiaInlandCostDetailVOs != null) {
			rtnVOs = new AsiaInlandCostDetailVO[asiaInlandCostDetailVOs.length];
			System.arraycopy(asiaInlandCostDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* AsiaInlandCostDetailVO - end */
	
	public void setInlandCostConditionVO(AsiaInlandCostConditionVO asiaInlandCostConditionVO) {
		this.asiaInlandCostConditionVO = asiaInlandCostConditionVO;
	}
	
	public AsiaInlandCostConditionVO getInlandCostConditionVO() {
		return asiaInlandCostConditionVO;
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
