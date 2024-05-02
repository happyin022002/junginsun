/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BcmCcd2001Event.java
*@FileTitle : BCM_CCD_2001
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmUsrAuthVO;


/**
 * BCM_CCD_2001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_2001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_2001HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd2001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmUsrAuthVO mdmUsrAuthVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmUsrAuthVO[] mdmUsrAuthVOs = null;

	public BcmCcd2001Event(){}
	
	public void setMdmUsrAuthVO(MdmUsrAuthVO mdmUsrAuthVO){
		this. mdmUsrAuthVO = mdmUsrAuthVO;
	}

	public void setMdmUsrAuthVOS(MdmUsrAuthVO[] mdmUsrAuthVOs){
		if(mdmUsrAuthVOs != null){
			MdmUsrAuthVO[] tmpVOs = java.util.Arrays.copyOf(mdmUsrAuthVOs, mdmUsrAuthVOs.length);
			this.mdmUsrAuthVOs = tmpVOs;
		}
	}

	public MdmUsrAuthVO getMdmUsrAuthVO(){
		return mdmUsrAuthVO;
	}

	public MdmUsrAuthVO[] getMdmUsrAuthVOS(){
		MdmUsrAuthVO[] rtnVOs = null;
		if (this.mdmUsrAuthVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mdmUsrAuthVOs, mdmUsrAuthVOs.length);
		}
		return rtnVOs;
	}

}