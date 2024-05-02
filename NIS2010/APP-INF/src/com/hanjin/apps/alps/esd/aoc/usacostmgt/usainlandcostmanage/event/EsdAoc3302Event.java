/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3002Event.java
*@FileTitle : Inland Cost Management(Usa)
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
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3302 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3302HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3302HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3302Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String inCntCd = "";
	private String inCostTrfNo = "";
	private String inBtnSts = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private UsaInlandCostTariffInfoVO usaInlandCostTariffInfoVO = null;
	private UsaInlandCostVO usaInlandCostVO = null;
	private UsaInlandCostSpecialCargoVO usaInlandCostSpecialCargoVO = null;
	private UsaInlandCostConditionVO usaInlandCostConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UsaInlandCostVO[] usaInlandCostVOs = null;
	private UsaInlandCostSpecialCargoVO[] usaInlandCostSpecialCargoVOs = null;
	
	public EsdAoc3302Event(){}
	
	/* UsaInlandCostTariffInfoVO - start */
	public void setInlandCostTariffInfoVO(UsaInlandCostTariffInfoVO usaInlandCostTariffInfoVO){
		this. usaInlandCostTariffInfoVO = usaInlandCostTariffInfoVO;
	}
	
	public UsaInlandCostTariffInfoVO getInlandCostTariffInfoVO(){
		return usaInlandCostTariffInfoVO;
	}
	/* UsaInlandCostTariffInfoVO - end */
	
	/* UsaInlandCostVO - start */
	public void setInlandCostVO(UsaInlandCostVO usaInlandCostVO){
		this. usaInlandCostVO = usaInlandCostVO;
	}

	public void setInlandCostVOS(UsaInlandCostVO[] inlandCostVOs){
		if(inlandCostVOs != null){
			UsaInlandCostVO[] tmpVOs = new UsaInlandCostVO[inlandCostVOs.length];
			System.arraycopy(inlandCostVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.usaInlandCostVOs = tmpVOs;
		}
	}

	public UsaInlandCostVO getInlandCostVO(){
		return usaInlandCostVO;
	}

	public UsaInlandCostVO[] getInlandCostVOS(){
		UsaInlandCostVO[] rtnVOs = null;
		if (this.usaInlandCostVOs != null) {
			rtnVOs = new UsaInlandCostVO[usaInlandCostVOs.length];
			System.arraycopy(usaInlandCostVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* UsaInlandCostVO - end */
	
	/* UsaInlandCostSpecialCargoVO - start */
	public void setInlandCostSpecialCargoVO(UsaInlandCostSpecialCargoVO usaInlandCostSpecialCargoVO){
		this. usaInlandCostSpecialCargoVO = usaInlandCostSpecialCargoVO;
	}

	public void setInlandCostSpecialCargoVOS(UsaInlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs){
		if(inlandCostSpecialCargoVOs != null){
			UsaInlandCostSpecialCargoVO[] tmpVOs = new UsaInlandCostSpecialCargoVO[inlandCostSpecialCargoVOs.length];
			System.arraycopy(inlandCostSpecialCargoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.usaInlandCostSpecialCargoVOs = tmpVOs;
		}
	}

	public UsaInlandCostSpecialCargoVO getInlandCostSpecialCargoVO(){
		return usaInlandCostSpecialCargoVO;
	}

	public UsaInlandCostSpecialCargoVO[] getInlandCostSpecialCargoVOS(){
		UsaInlandCostSpecialCargoVO[] rtnVOs = null;
		if (this.usaInlandCostSpecialCargoVOs != null) {
			rtnVOs = new UsaInlandCostSpecialCargoVO[usaInlandCostSpecialCargoVOs.length];
			System.arraycopy(usaInlandCostSpecialCargoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* UsaInlandCostSpecialCargoVO - end */
	
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
