/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3303Event.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3303 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3303HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3303HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3303Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String inCntCd = "";
	private String inCostTrfNo = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UsaInlandCostDetailVO usaInlandCostDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UsaInlandCostDetailVO[] usaInlandCostDetailVOs = null;
	private UsaInlandCostConditionVO usaInlandCostConditionVO = null;
	
	public EsdAoc3303Event(){}
	
	/* UsaInlandCostDetailVO - start */
	public void setInlandCostDetailVO(UsaInlandCostDetailVO usaInlandCostDetailVO){
		this. usaInlandCostDetailVO = usaInlandCostDetailVO;
	}

	public void setInlandCostDetailVOS(UsaInlandCostDetailVO[] inlandCostDetailVOs){
		if(inlandCostDetailVOs != null){
			UsaInlandCostDetailVO[] tmpVOs = new UsaInlandCostDetailVO[inlandCostDetailVOs.length];
			System.arraycopy(inlandCostDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.usaInlandCostDetailVOs = tmpVOs;
		}
	}

	public UsaInlandCostDetailVO getInlandCostDetailVO(){
		return usaInlandCostDetailVO;
	}

	public UsaInlandCostDetailVO[] getInlandCostDetailVOS(){
		UsaInlandCostDetailVO[] rtnVOs = null;
		if (this.usaInlandCostDetailVOs != null) {
			rtnVOs = new UsaInlandCostDetailVO[usaInlandCostDetailVOs.length];
			System.arraycopy(usaInlandCostDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* UsaInlandCostDetailVO - end */
	
	public void setInlandCostConditionVO(UsaInlandCostConditionVO usaInlandCostConditionVO) {
		this.usaInlandCostConditionVO = usaInlandCostConditionVO;
	}
	
	public UsaInlandCostConditionVO getInlandCostConditionVO() {
		return usaInlandCostConditionVO;
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
