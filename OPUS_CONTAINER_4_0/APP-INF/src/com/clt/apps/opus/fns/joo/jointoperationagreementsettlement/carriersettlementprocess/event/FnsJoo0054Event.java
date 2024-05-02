/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0054Event.java
*@FileTitle :  TDR Creation Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : jang chang su
*@LastVersion : 1.0
* 2009.09.04 jang chang su
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrByLaneVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrByLaneVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang chang su
 * @see FNS_JOO_0054HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0054Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TdrByLaneVO tdrByLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TdrByLaneVO[] tdrByLaneVOs = null;
    private RdrByLaneVO rdrByLaneVO = null;
	public FnsJoo0054Event(){}
	
	public void setTdrByLaneVO(TdrByLaneVO tdrByLaneVO){
		this.tdrByLaneVO = tdrByLaneVO;
	}

	public void setTdrByLaneVOS(TdrByLaneVO[] tdrByLaneVOs){
		if (tdrByLaneVOs != null) {
			TdrByLaneVO[] tmpVOs = new TdrByLaneVO[tdrByLaneVOs.length];
			System.arraycopy(tdrByLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrByLaneVOs = tmpVOs;
		}
	}

	public TdrByLaneVO getTdrByLaneVO(){
		return tdrByLaneVO;
	}

	public TdrByLaneVO[] getTdrByLaneVOS(){
		TdrByLaneVO[] tmpVOs = null;
		if (this.tdrByLaneVOs != null) {
			tmpVOs = new TdrByLaneVO[tdrByLaneVOs.length];
			System.arraycopy(tdrByLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

    /**
     * @return the tdrByLaneVOs
     */
    public TdrByLaneVO[] getTdrByLaneVOs() {
    	TdrByLaneVO[] tmpVOs = null;
		if (this.tdrByLaneVOs != null) {
			tmpVOs = new TdrByLaneVO[tdrByLaneVOs.length];
			System.arraycopy(tdrByLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
     * @return the rdrByLaneVO
     */
    public RdrByLaneVO getRdrByLaneVO() {
        return rdrByLaneVO;
    }

    /**
     * @param tdrByLaneVOs the tdrByLaneVOs to set
     */
    public void setTdrByLaneVOs(TdrByLaneVO[] tdrByLaneVOs) {
		if (tdrByLaneVOs != null) {
			TdrByLaneVO[] tmpVOs = new TdrByLaneVO[tdrByLaneVOs.length];
			System.arraycopy(tdrByLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrByLaneVOs = tmpVOs;
		}
    }

    /**
     * @param rdrByLaneVO the rdrByLaneVO to set
     */
    public void setRdrByLaneVO(RdrByLaneVO rdrByLaneVO) {
        this.rdrByLaneVO = rdrByLaneVO;
    }

}