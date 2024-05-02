/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3034Event.java
*@FileTitle : Default Currency Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* History
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.defaultcurr.event;

import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntDefaultCurrVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntInfoVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.InlandCostConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3034HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String cntCd = "";
	private String currCd = "";
	private String rhqCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntInfoVO cntInfoVO = null;
	private CntDefaultCurrVO cntDefaultCurrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntDefaultCurrVO[] cntDefaultCurrVOs = null;
	private InlandCostConditionVO inlandCostConditionVO = null;
	
	public EsdAoc3034Event(){}
	
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
		if(cntDefaultCurrVOs != null){
			CntDefaultCurrVO[] tmpVOs = new CntDefaultCurrVO[cntDefaultCurrVOs.length];
			System.arraycopy(cntDefaultCurrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntDefaultCurrVOs = tmpVOs;
		}
	}

	public CntDefaultCurrVO getCntDefaultCurrVO(){
		return cntDefaultCurrVO;
	}

	public CntDefaultCurrVO[] getCntDefaultCurrVOS(){
		CntDefaultCurrVO[] rtnVOs = null;
		if (this.cntDefaultCurrVOs != null) {
			rtnVOs = new CntDefaultCurrVO[cntDefaultCurrVOs.length];
			System.arraycopy(cntDefaultCurrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
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
    
    /**
     * @return the rhqCd
     */
    public String getRhqCd() {
        return rhqCd;
    }

    /**
     * @param selcurrCd the currCd to set
     */
    public void setRhqCd(String selRhqCd) {
    	rhqCd = selRhqCd;
    }


}
