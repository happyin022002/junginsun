/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0111Event.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.05 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SurchageSummaryInVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1170 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1170HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0170HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg1170Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SurchageSummaryInVO surchageSummaryInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SurchageSummaryInVO[] surchageSummaryInVOs = null;

	public EsmBkg1170Event(){}
	
	public void setSurchageSummaryInVO(SurchageSummaryInVO surchageSummaryInVO){
		this. surchageSummaryInVO = surchageSummaryInVO;
	}

	public void setSurchageSummaryInVOS(SurchageSummaryInVO[] surchageSummaryInVOs){
		if(surchageSummaryInVOs != null){
			SurchageSummaryInVO[] tmpVOs = new SurchageSummaryInVO[surchageSummaryInVOs.length];
			System.arraycopy(surchageSummaryInVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.surchageSummaryInVOs = tmpVOs;
		}
	}

	public SurchageSummaryInVO getSurchageSummaryInVO(){
		return surchageSummaryInVO;
	}

	public SurchageSummaryInVO[] getSurchageSummaryInVOS(){
		SurchageSummaryInVO[] rtnVOs = null;
		if (this.surchageSummaryInVOs != null) {
			rtnVOs = new SurchageSummaryInVO[surchageSummaryInVOs.length];
			System.arraycopy(surchageSummaryInVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	
}