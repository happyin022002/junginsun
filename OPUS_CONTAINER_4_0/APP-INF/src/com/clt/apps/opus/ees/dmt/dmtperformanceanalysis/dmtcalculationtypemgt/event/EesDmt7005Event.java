/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7005Event.java
*@FileTitle : Tariff Type Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtOfcUsrTrfOptVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_7005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_DMT_7005HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt7005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DmtOfcUsrTrfOptVO[] dmtOfcUsrTrfOptVOs = null;

	public EesDmt7005Event(){}
	
	public void setDmtOfcUsrTrfOptVO(DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO){
		this. dmtOfcUsrTrfOptVO = dmtOfcUsrTrfOptVO;
	}

	public void setDmtOfcUsrTrfOptVOS(DmtOfcUsrTrfOptVO[] dmtOfcUsrTrfOptVOs){
		if (dmtOfcUsrTrfOptVOs != null) {
			DmtOfcUsrTrfOptVO[] tmpVOs = new DmtOfcUsrTrfOptVO[dmtOfcUsrTrfOptVOs.length];
			System.arraycopy(dmtOfcUsrTrfOptVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtOfcUsrTrfOptVOs = tmpVOs;
		}
	}

	public DmtOfcUsrTrfOptVO getDmtOfcUsrTrfOptVO(){
		return dmtOfcUsrTrfOptVO;
	}

	public DmtOfcUsrTrfOptVO[] getDmtOfcUsrTrfOptVOS(){
		DmtOfcUsrTrfOptVO[] tmpVOs = null;
		if (this.dmtOfcUsrTrfOptVOs != null) {
			tmpVOs = new DmtOfcUsrTrfOptVO[dmtOfcUsrTrfOptVOs.length];
			System.arraycopy(dmtOfcUsrTrfOptVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}