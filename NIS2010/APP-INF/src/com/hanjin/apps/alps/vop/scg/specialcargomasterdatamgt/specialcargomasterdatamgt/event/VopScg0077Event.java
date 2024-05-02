/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0077Event.java
*@FileTitle : Setup mail contents for SPCL CGO application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.09.25 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgMailTampletVO;


/**
 * VOP_SCG_0077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Hyun Uk
 * @see VOP_SCG_0077HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0077Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgMailTampletVO scgMailTampletVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgMailTampletVO[] scgMailTampletVOs = null;

	public VopScg0077Event(){}
	
	public void setScgMailTampletVO(ScgMailTampletVO scgMailTampletVO){
		this. scgMailTampletVO = scgMailTampletVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgMailTampletVOS(ScgMailTampletVO[] scgMailTampletVOs){
		if (scgMailTampletVOs != null) {
			ScgMailTampletVO[] tmpVOs = new ScgMailTampletVO[scgMailTampletVOs.length];
			System.arraycopy(scgMailTampletVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgMailTampletVOs = tmpVOs;
		}
	}

	public ScgMailTampletVO getScgMailTampletVO(){
		return scgMailTampletVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgMailTampletVO[] getScgMailTampletVOS(){
		ScgMailTampletVO[] rtnVOs = null;
		if (this.scgMailTampletVOs != null) {
			rtnVOs = new ScgMailTampletVO[scgMailTampletVOs.length];
			System.arraycopy(scgMailTampletVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}