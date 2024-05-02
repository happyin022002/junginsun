/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0435Event.java
*@FileTitle : bookringreport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.10 강동윤
* 1.0 Creation
* 2011.11.22 정선용 [CHM-201114286-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSRReceivingListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SiTurnTimeVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SiTurnTimeSummaryVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SiTurnTimeDetailVO;


/**
 * ESM_BKG_0435 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0435HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0435HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0435Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SiTurnTimeVO siTurnTimeVO = null;
		
	/** Table Value Object Multi Data 처리 */
	private SiTurnTimeSummaryVO[] siTurnTimeSummaryVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private SiTurnTimeDetailVO[] siTurnTimeDetailVOs = null;

	public EsmBkg0435Event(){}
	
	public void setSiTurnTimeVO(SiTurnTimeVO siTurnTimeVO){
		this. siTurnTimeVO = siTurnTimeVO;
	}

	public void setSiTurnTimeSummaryVOS(SiTurnTimeSummaryVO[] siTurnTimeSummaryVOs){
		if(siTurnTimeSummaryVOs != null){
			SiTurnTimeSummaryVO[] tmpVOs = Arrays.copyOf(siTurnTimeSummaryVOs, siTurnTimeSummaryVOs.length);
			this.siTurnTimeSummaryVOs = tmpVOs;
		}
	}

	public void setSiTurnTimeDetailVOS(SiTurnTimeDetailVO[] siTurnTimeDetailVOs){
		if(siTurnTimeDetailVOs != null){
			SiTurnTimeDetailVO[] tmpVOs = Arrays.copyOf(siTurnTimeDetailVOs, siTurnTimeDetailVOs.length);
			this.siTurnTimeDetailVOs = tmpVOs;
		}
	}
	

	public SiTurnTimeVO getSiTurnTimeVO() {
		return siTurnTimeVO;
	}
	
}