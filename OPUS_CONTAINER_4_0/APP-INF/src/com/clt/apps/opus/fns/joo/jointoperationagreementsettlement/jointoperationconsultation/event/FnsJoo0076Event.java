/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0076Event.java
*@FileTitle : Inquiry Disabled VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.12.04 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ArDisabledVVDVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0076 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0076HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0076HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0076Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ArDisabledVVDVO arDisabledVVDVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ArDisabledVVDVO[] arDisabledVVDVOs = null;

	public FnsJoo0076Event(){}
	
	public void setArDisabledVVDVO(ArDisabledVVDVO arDisabledVVDVO){
		this. arDisabledVVDVO = arDisabledVVDVO;
	}

	public void setArDisabledVVDVOS(ArDisabledVVDVO[] arDisabledVVDVOs){
		if (arDisabledVVDVOs != null) {
			ArDisabledVVDVO[] tmpVOs = new ArDisabledVVDVO[arDisabledVVDVOs.length];
			System.arraycopy(arDisabledVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.arDisabledVVDVOs = tmpVOs;
		}
	}

	public ArDisabledVVDVO getArDisabledVVDVO(){
		return arDisabledVVDVO;
	}

	public ArDisabledVVDVO[] getArDisabledVVDVOS(){
		ArDisabledVVDVO[] tmpVOs = null;
		if (this.arDisabledVVDVOs != null) {
			tmpVOs = new ArDisabledVVDVO[arDisabledVVDVOs.length];
			System.arraycopy(arDisabledVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}