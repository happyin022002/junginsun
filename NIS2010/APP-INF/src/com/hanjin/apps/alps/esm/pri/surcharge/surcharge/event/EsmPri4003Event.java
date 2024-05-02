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
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgAuthVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgPrfVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgRtVO;


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
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScgPrfVO priScgPrfVO = null;
	private PriScgRtVO priScgRtVO = null;
	private PriScgAuthVO priScgAuthVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScgPrfVO[] priScgPrfVOs = null;
	private PriScgRtVO[] priScgRtVOs = null;
	private PriScgAuthVO[] priScgAuthVOs = null;
	
	public EsmPri4003Event(){}
	

	public void setPriScgPrfVO(PriScgPrfVO priScgPrfVO){
		this. priScgPrfVO = priScgPrfVO;
	}

	public void setPriScgPrfVOS(PriScgPrfVO[] priScgPrfVOs){
		if(priScgPrfVOs != null){
			PriScgPrfVO[] tmpVOs = new PriScgPrfVO[priScgPrfVOs.length];
			System.arraycopy(priScgPrfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgPrfVOs = tmpVOs;
		}
	}

	public PriScgPrfVO getPriScgPrfVO(){
		return priScgPrfVO;
	}

	public PriScgPrfVO[] getPriScgPrfVOS(){
		PriScgPrfVO[] rtnVOs = null;
		if (this.priScgPrfVOs != null) {
			rtnVOs = new PriScgPrfVO[priScgPrfVOs.length];
			System.arraycopy(priScgPrfVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setPriScgRtVO(PriScgRtVO priScgRtVO){
		this. priScgRtVO = priScgRtVO;
	}

	public void setPriScgRtVOS(PriScgRtVO[] priScgRtVOs){
		if(priScgRtVOs != null){
			PriScgRtVO[] tmpVOs = new PriScgRtVO[priScgRtVOs.length];
			System.arraycopy(priScgRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgRtVOs = tmpVOs;
		}
	}

	public PriScgRtVO getPriScgRtVO(){
		return priScgRtVO;
	}

	public PriScgRtVO[] getPriScgRtVOS(){
		PriScgRtVO[] rtnVOs = null;
		if (this.priScgRtVOs != null) {
			rtnVOs = new PriScgRtVO[priScgRtVOs.length];
			System.arraycopy(priScgRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public PriScgAuthVO getPriScgAuthVO() {
		return priScgAuthVO;
	}


	public void setPriScgAuthVO(PriScgAuthVO priScgAuthVO) {
		this.priScgAuthVO = priScgAuthVO;
	}


	public PriScgAuthVO[] getPriScgAuthVOS() {
		PriScgAuthVO[] rtnVOs = null;
		if (this.priScgAuthVOs != null) {
			rtnVOs = new PriScgAuthVO[priScgAuthVOs.length];
			System.arraycopy(priScgAuthVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setPriScgAuthVOS(PriScgAuthVO[] priScgAuthVOs) {
		if(priScgAuthVOs != null){
			PriScgAuthVO[] tmpVOs = new PriScgAuthVO[priScgAuthVOs.length];
			System.arraycopy(priScgAuthVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgAuthVOs = tmpVOs;
		}
	}
	

}