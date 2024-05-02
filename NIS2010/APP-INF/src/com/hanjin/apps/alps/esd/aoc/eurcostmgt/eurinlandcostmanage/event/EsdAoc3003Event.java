/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3003Event.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String inCntCd = "";
	private String inCostTrfNo = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EurInlandCostDetailVO eurInlandCostDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EurInlandCostDetailVO[] eurInlandCostDetailVOs = null;
	private EurInlandCostConditionVO eurInlandCostConditionVO = null;
	
	public EsdAoc3003Event(){}
	
	/* EurInlandCostDetailVO - start */
	public void setInlandCostDetailVO(EurInlandCostDetailVO eurInlandCostDetailVO){
		this. eurInlandCostDetailVO = eurInlandCostDetailVO;
	}

	public void setInlandCostDetailVOS(EurInlandCostDetailVO[] inlandCostDetailVOs){
		if(inlandCostDetailVOs != null){
			EurInlandCostDetailVO[] tmpVOs = new EurInlandCostDetailVO[inlandCostDetailVOs.length];
			System.arraycopy(inlandCostDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurInlandCostDetailVOs = tmpVOs;
		}
	}

	public EurInlandCostDetailVO getInlandCostDetailVO(){
		return eurInlandCostDetailVO;
	}

	public EurInlandCostDetailVO[] getInlandCostDetailVOS(){
		EurInlandCostDetailVO[] rtnVOs = null;
		if (this.eurInlandCostDetailVOs != null) {
			rtnVOs = new EurInlandCostDetailVO[eurInlandCostDetailVOs.length];
			System.arraycopy(eurInlandCostDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* EurInlandCostDetailVO - end */
	
	public void setInlandCostConditionVO(EurInlandCostConditionVO eurInlandCostConditionVO) {
		this.eurInlandCostConditionVO = eurInlandCostConditionVO;
	}
	
	public EurInlandCostConditionVO getInlandCostConditionVO() {
		return eurInlandCostConditionVO;
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
