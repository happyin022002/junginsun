/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4016Event.java
*@FileTitle : Upload Excel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.20 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surcharge.event;

import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgPrfVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgRtVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgRtValidVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScgPrfVO priScgPrfVO = null;
	private PriScgRtVO priScgRtVO = null;
	//---------
	private PriScgRtValidVO priScgRtValidVO = null;
	private String xmlSurchageInfo = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScgPrfVO[] priScgPrfVOs = null;
	private PriScgRtVO[] priScgRtVOs = null;
	//---------
	private PriScgRtValidVO[] priScgRtValidVOS = null;

	public EsmPri4016Event(){}
	
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

	//---------
	public String getXmlSurchageInfo() {
		return xmlSurchageInfo;
	}

	public void setXmlSurchageInfo(String xmlSurchageInfo) {
		this.xmlSurchageInfo = xmlSurchageInfo;
	}

	public PriScgRtValidVO getPriScgRtValidVO() {
		return priScgRtValidVO;
	}

	public void setPriScgRtValidVO(PriScgRtValidVO priScgRtValidVO) {
		this.priScgRtValidVO = priScgRtValidVO;
	}

	public PriScgRtValidVO[] getPriScgRtValidVOS() {
		PriScgRtValidVO[] tmpVOs = null;
		if (this.priScgRtValidVOS != null) {
			tmpVOs = new PriScgRtValidVO[priScgRtValidVOS.length];
			System.arraycopy(priScgRtValidVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriScgRtValidVOS(PriScgRtValidVO[] priScgRtValidVOS) {
		if (priScgRtValidVOS != null) {
			PriScgRtValidVO[] tmpVOs = new PriScgRtValidVO[priScgRtValidVOS.length];
			System.arraycopy(priScgRtValidVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgRtValidVOS = tmpVOs;
		}
	}

}