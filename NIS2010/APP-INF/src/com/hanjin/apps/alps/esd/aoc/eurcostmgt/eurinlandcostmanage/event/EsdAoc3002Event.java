/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3002Event.java
*@FileTitle : Inland Cost Management(EUR)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3002Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String inCntCd = "";
	private String inCostTrfNo = "";
	private String inBtnSts = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EurInlandCostTariffInfoVO eurInlandCostTariffInfoVO = null;
	private EurInlandCostVO eurInlandCostVO = null;
	private EurInlandCostSpecialCargoVO eurInlandCostSpecialCargoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EurInlandCostVO[] eurInlandCostVOs = null;
	private EurInlandCostSpecialCargoVO[] eurInlandCostSpecialCargoVOs = null;
	private EurInlandCostConditionVO eurInlandCostConditionVO = null;
	
	public EsdAoc3002Event(){}
	
	/* EurInlandCostTariffInfoVO - start */
	public void setInlandCostTariffInfoVO(EurInlandCostTariffInfoVO eurInlandCostTariffInfoVO){
		this. eurInlandCostTariffInfoVO = eurInlandCostTariffInfoVO;
	}
	
	public EurInlandCostTariffInfoVO getInlandCostTariffInfoVO(){
		return eurInlandCostTariffInfoVO;
	}
	/* EurInlandCostTariffInfoVO - end */
	
	/* EurInlandCostVO - start */
	public void setInlandCostVO(EurInlandCostVO eurInlandCostVO){
		this. eurInlandCostVO = eurInlandCostVO;
	}

	public void setInlandCostVOS(EurInlandCostVO[] inlandCostVOs){
		if(inlandCostVOs != null){
			EurInlandCostVO[] tmpVOs = new EurInlandCostVO[inlandCostVOs.length];
			System.arraycopy(inlandCostVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurInlandCostVOs = tmpVOs;
		}
	}

	public EurInlandCostVO getInlandCostVO(){
		return eurInlandCostVO;
	}

	public EurInlandCostVO[] getInlandCostVOS(){
		EurInlandCostVO[] rtnVOs = null;
		if (this.eurInlandCostVOs != null) {
			rtnVOs = new EurInlandCostVO[eurInlandCostVOs.length];
			System.arraycopy(eurInlandCostVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* EurInlandCostVO - end */
	
	/* EurInlandCostSpecialCargoVO - start */
	public void setInlandCostSpecialCargoVO(EurInlandCostSpecialCargoVO eurInlandCostSpecialCargoVO){
		this. eurInlandCostSpecialCargoVO = eurInlandCostSpecialCargoVO;
	}

	public void setInlandCostSpecialCargoVOS(EurInlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs){
		if(inlandCostSpecialCargoVOs != null){
			EurInlandCostSpecialCargoVO[] tmpVOs = new EurInlandCostSpecialCargoVO[inlandCostSpecialCargoVOs.length];
			System.arraycopy(inlandCostSpecialCargoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurInlandCostSpecialCargoVOs = tmpVOs;
		}
	}

	public EurInlandCostSpecialCargoVO getInlandCostSpecialCargoVO(){
		return eurInlandCostSpecialCargoVO;
	}

	public EurInlandCostSpecialCargoVO[] getInlandCostSpecialCargoVOS(){
		EurInlandCostSpecialCargoVO[] rtnVOs = null;
		if (this.eurInlandCostSpecialCargoVOs != null) {
			rtnVOs = new EurInlandCostSpecialCargoVO[eurInlandCostSpecialCargoVOs.length];
			System.arraycopy(eurInlandCostSpecialCargoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* EurInlandCostSpecialCargoVO - end */
	
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
     * @return the inBtnSts
     */
    public String getInBtnSts() {
        return inBtnSts;
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

    /**
     * @param btnSts the inBtnSts to set
     */
    public void setInBtnSts(String btnSts) {
    	inBtnSts = btnSts;
    }
}
