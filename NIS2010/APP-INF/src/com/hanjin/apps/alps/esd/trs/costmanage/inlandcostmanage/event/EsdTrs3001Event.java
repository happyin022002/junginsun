/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs3001Event.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event;

import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostConditionVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_3001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see ESD_TRS_3001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs3001Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String inCntCd = "";
	private String inCostTrfNo = "";
	private String inBtnSts = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InlandCostTariffInfoVO inlandCostTariffInfoVO = null;
	private InlandCostVO inlandCostVO = null;
	private InlandCostSpecialCargoVO inlandCostSpecialCargoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InlandCostVO[] inlandCostVOs = null;
	private InlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs = null;
	private InlandCostConditionVO inlandCostConditionVO = null;
	
	public EsdTrs3001Event(){}
	
	/* InlandCostTariffInfoVO - start */
	public void setInlandCostTariffInfoVO(InlandCostTariffInfoVO inlandCostTariffInfoVO){
		this. inlandCostTariffInfoVO = inlandCostTariffInfoVO;
	}
	
	public InlandCostTariffInfoVO getInlandCostTariffInfoVO(){
		return inlandCostTariffInfoVO;
	}
	/* InlandCostTariffInfoVO - end */
	
	/* InlandCostVO - start */
	public void setInlandCostVO(InlandCostVO inlandCostVO){
		this. inlandCostVO = inlandCostVO;
	}

	public void setInlandCostVOS(InlandCostVO[] inlandCostVOs){
		this. inlandCostVOs = inlandCostVOs;
	}

	public InlandCostVO getInlandCostVO(){
		return inlandCostVO;
	}

	public InlandCostVO[] getInlandCostVOS(){
		return inlandCostVOs;
	}
	/* InlandCostVO - end */
	
	/* InlandCostSpecialCargoVO - start */
	public void setInlandCostSpecialCargoVO(InlandCostSpecialCargoVO inlandCostSpecialCargoVO){
		this. inlandCostSpecialCargoVO = inlandCostSpecialCargoVO;
	}

	public void setInlandCostSpecialCargoVOS(InlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs){
		this. inlandCostSpecialCargoVOs = inlandCostSpecialCargoVOs;
	}

	public InlandCostSpecialCargoVO getInlandCostSpecialCargoVO(){
		return inlandCostSpecialCargoVO;
	}

	public InlandCostSpecialCargoVO[] getInlandCostSpecialCargoVOS(){
		return inlandCostSpecialCargoVOs;
	}
	/* InlandCostSpecialCargoVO - end */
	
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
