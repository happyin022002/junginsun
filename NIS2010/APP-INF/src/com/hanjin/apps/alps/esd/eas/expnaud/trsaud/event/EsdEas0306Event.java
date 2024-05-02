/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0306Event.java
*@FileTitle : Tariff Comparison by TRS Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.12
*@LastModifier : KIM HYUN JOO
*@LastVersion : 1.0
* 2015.02.12 KIM HYUN JOO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.event;


import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.TrffCmprsnByTRSAgrmntVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0306 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0306HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0306HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0306Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	TrffCmprsnByTRSAgrmntVO trffCmprsnByTRSAgrmntVO = null;
	
	/** Table Value Object Multi Data 처리 */
	TrffCmprsnByTRSAgrmntVO[] trffCmprsnByTRSAgrmntVOs = null;

	public EsdEas0306Event(){}
	
	// SurchargeReportVO
	public TrffCmprsnByTRSAgrmntVO getTrffCmprsnByTRSAgrmntVO() {
		return trffCmprsnByTRSAgrmntVO;
	}

	public void setTrffCmprsnByTRSAgrmntVO(TrffCmprsnByTRSAgrmntVO trffCmprsnByTRSAgrmntVO) {
		this.trffCmprsnByTRSAgrmntVO = trffCmprsnByTRSAgrmntVO;
	}

	public TrffCmprsnByTRSAgrmntVO[] getTrffCmprsnByTRSAgrmntVOs() {
		TrffCmprsnByTRSAgrmntVO[] rtnVOs = null;
		if (this.trffCmprsnByTRSAgrmntVOs != null) {
			rtnVOs = new TrffCmprsnByTRSAgrmntVO[trffCmprsnByTRSAgrmntVOs.length];
			System.arraycopy(trffCmprsnByTRSAgrmntVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setTrffCmprsnByTRSAgrmntVOs(TrffCmprsnByTRSAgrmntVO[] trffCmprsnByTRSAgrmntVOs){
		if(trffCmprsnByTRSAgrmntVOs != null){
			TrffCmprsnByTRSAgrmntVO[] tmpVOs = new TrffCmprsnByTRSAgrmntVO[trffCmprsnByTRSAgrmntVOs.length];
			System.arraycopy(trffCmprsnByTRSAgrmntVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.trffCmprsnByTRSAgrmntVOs = tmpVOs;
		}
	}

}