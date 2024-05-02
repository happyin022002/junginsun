/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs3016Event.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event;

import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.CntDefaultCurrVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.CntInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_3016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see ESD_TRS_3016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs3016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String cntCd = "";
	private String currCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntInfoVO cntInfoVO = null;
	private CntDefaultCurrVO cntDefaultCurrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntDefaultCurrVO[] cntDefaultCurrVOs = null;
	private InlandCostConditionVO inlandCostConditionVO = null;
	
	public EsdTrs3016Event(){}
	
	/* CntInfoVO - start */
	public void setCntInfoVO(CntInfoVO cntInfoVO){
		this. cntInfoVO = cntInfoVO;
	}
	
	public CntInfoVO getCntInfoVO(){
		return cntInfoVO;
	}
	/* CntInfoVO - end */
	
	/* CntDefaultCurrVO - start */
	public void setCntDefaultCurrVO(CntDefaultCurrVO cntDefaultCurrVO){
		this. cntDefaultCurrVO = cntDefaultCurrVO;
	}

	public void setCntDefaultCurrVOS(CntDefaultCurrVO[] cntDefaultCurrVOs){
		this. cntDefaultCurrVOs = cntDefaultCurrVOs;
	}

	public CntDefaultCurrVO getCntDefaultCurrVO(){
		return cntDefaultCurrVO;
	}

	public CntDefaultCurrVO[] getCntDefaultCurrVOS(){
		return cntDefaultCurrVOs;
	}
	/* CntDefaultCurrVO - end */

	public void setInlandCostConditionVO(InlandCostConditionVO inlandCostConditionVO) {
		this.inlandCostConditionVO = inlandCostConditionVO;
	}
	
	public InlandCostConditionVO getInlandCostConditionVO() {
		return inlandCostConditionVO;
	}

    /**
     * @return the cntCd
     */
    public String getCntCd() {
        return cntCd;
    }

    /**
     * @return the currCd
     */
    public String getCurrCd() {
        return currCd;
    }
    
    /**
     * @param selcntCd the cntCd to set
     */
    public void setCntCd(String selCntCd) {
        cntCd = selCntCd;
    }

    /**
     * @param selcurrCd the currCd to set
     */
    public void setCurrCd(String selCurrCd) {
        currCd = selCurrCd;
    }


}
