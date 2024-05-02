/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0625Event.java
*@FileTitle : VIP Customer Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CustVipReportInVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0625 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0625HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭 
 * @see ESM_BKG_0625HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0625Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkg0625Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustVipReportInVO infoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustVipReportInVO[] infoVOs = null;
	
	
	
	public CustVipReportInVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(CustVipReportInVO infoVO) {
		this.infoVO = infoVO;
	}

	public CustVipReportInVO[] getInfoVOs() {
		CustVipReportInVO[] rtnVOs = null;
		if(this.infoVOs != null){
			rtnVOs= Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(CustVipReportInVO[] infoVOs) {
		if(infoVOs != null){
			CustVipReportInVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

}