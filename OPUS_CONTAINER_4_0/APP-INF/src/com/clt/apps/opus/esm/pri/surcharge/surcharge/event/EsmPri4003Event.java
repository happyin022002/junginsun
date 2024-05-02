/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4003Event.java
*@FileTitle : Surcharge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.06.04 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surcharge.event;

import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgPrfVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgRtVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private int nPage = 1;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScgPrfVO priScgPrfVO = null;
	private PriScgRtVO priScgRtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScgPrfVO[] priScgPrfVOs = null;
	private PriScgRtVO[] priScgRtVOs = null;
	
	public EsmPri4003Event(){}
	

	public void setPriScgPrfVO(PriScgPrfVO priScgPrfVO){
		this. priScgPrfVO = priScgPrfVO;
	}

	public void setPriScgPrfVOS(PriScgPrfVO[] priScgPrfVOs){
		if (priScgPrfVOs != null) {
			PriScgPrfVO[] tmpVOs = new PriScgPrfVO[priScgPrfVOs.length];
			System.arraycopy(priScgPrfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgPrfVOs = tmpVOs;
		}
	}

	public PriScgPrfVO getPriScgPrfVO(){
		return priScgPrfVO;
	}

	public PriScgPrfVO[] getPriScgPrfVOS(){
		PriScgPrfVO[] tmpVOs = null;
		if (this.priScgPrfVOs != null) {
			tmpVOs = new PriScgPrfVO[priScgPrfVOs.length];
			System.arraycopy(priScgPrfVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setPriScgRtVO(PriScgRtVO priScgRtVO){
		this. priScgRtVO = priScgRtVO;
	}

	public void setPriScgRtVOS(PriScgRtVO[] priScgRtVOs){
		if (priScgRtVOs != null) {
			PriScgRtVO[] tmpVOs = new PriScgRtVO[priScgRtVOs.length];
			System.arraycopy(priScgRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgRtVOs = tmpVOs;
		}
	}

	public PriScgRtVO getPriScgRtVO(){
		return priScgRtVO;
	}

	public PriScgRtVO[] getPriScgRtVOS(){
		PriScgRtVO[] tmpVOs = null;
		if (this.priScgRtVOs != null) {
			tmpVOs = new PriScgRtVO[priScgRtVOs.length];
			System.arraycopy(priScgRtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public int getnPage() {
		return nPage;
	}


	public void setnPage(int nPage) {
		this.nPage = nPage;
	}

}