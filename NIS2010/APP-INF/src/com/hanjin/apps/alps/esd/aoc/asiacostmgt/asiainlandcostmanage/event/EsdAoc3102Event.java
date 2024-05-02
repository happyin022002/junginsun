/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3002Event.java
*@FileTitle : Inland Cost Management(Asia)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3102HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3102Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String inCntCd = "";
	private String inCostTrfNo = "";
	private String inBtnSts = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AsiaInlandCostTariffInfoVO asiaInlandCostTariffInfoVO = null;
	private AsiaInlandCostVO asiaInlandCostVO = null;
	private AsiaInlandCostSpecialCargoVO asiaInlandCostSpecialCargoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AsiaInlandCostVO[] asiaInlandCostVOs = null;
	private AsiaInlandCostSpecialCargoVO[] asiaInlandCostSpecialCargoVOs = null;
	private AsiaInlandCostConditionVO asiaInlandCostConditionVO = null;
	
	public EsdAoc3102Event(){}
	
	/* AsiaInlandCostTariffInfoVO - start */
	public void setInlandCostTariffInfoVO(AsiaInlandCostTariffInfoVO asiaInlandCostTariffInfoVO){
		this. asiaInlandCostTariffInfoVO = asiaInlandCostTariffInfoVO;
	}
	
	public AsiaInlandCostTariffInfoVO getInlandCostTariffInfoVO(){
		return asiaInlandCostTariffInfoVO;
	}
	/* AsiaInlandCostTariffInfoVO - end */
	
	/* AsiaInlandCostVO - start */
	public void setInlandCostVO(AsiaInlandCostVO asiaInlandCostVO){
		this. asiaInlandCostVO = asiaInlandCostVO;
	}

	public void setInlandCostVOS(AsiaInlandCostVO[] inlandCostVOs){
		if(inlandCostVOs != null){
			AsiaInlandCostVO[] tmpVOs = new AsiaInlandCostVO[inlandCostVOs.length];
			System.arraycopy(inlandCostVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaInlandCostVOs = tmpVOs;
		}
	}

	public AsiaInlandCostVO getInlandCostVO(){
		return asiaInlandCostVO;
	}

	public AsiaInlandCostVO[] getInlandCostVOS(){
		AsiaInlandCostVO[] rtnVOs = null;
		if (this.asiaInlandCostVOs != null) {
			rtnVOs = new AsiaInlandCostVO[asiaInlandCostVOs.length];
			System.arraycopy(asiaInlandCostVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* AsiaInlandCostVO - end */
	
	/* AsiaInlandCostSpecialCargoVO - start */
	public void setInlandCostSpecialCargoVO(AsiaInlandCostSpecialCargoVO asiaInlandCostSpecialCargoVO){
		this. asiaInlandCostSpecialCargoVO = asiaInlandCostSpecialCargoVO;
	}

	public void setInlandCostSpecialCargoVOS(AsiaInlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs){
		if(inlandCostSpecialCargoVOs != null){
			AsiaInlandCostSpecialCargoVO[] tmpVOs = new AsiaInlandCostSpecialCargoVO[inlandCostSpecialCargoVOs.length];
			System.arraycopy(inlandCostSpecialCargoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaInlandCostSpecialCargoVOs = tmpVOs;
		}
	}

	public AsiaInlandCostSpecialCargoVO getInlandCostSpecialCargoVO(){
		return asiaInlandCostSpecialCargoVO;
	}

	public AsiaInlandCostSpecialCargoVO[] getInlandCostSpecialCargoVOS(){
		AsiaInlandCostSpecialCargoVO[] rtnVOs = null;
		if (this.asiaInlandCostSpecialCargoVOs != null) {
			rtnVOs = new AsiaInlandCostSpecialCargoVO[asiaInlandCostSpecialCargoVOs.length];
			System.arraycopy(asiaInlandCostSpecialCargoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* AsiaInlandCostSpecialCargoVO - end */
	
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
