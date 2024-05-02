/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BcmCcd2002Event.java
*@FileTitle : BCM_CCD_2002
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.event;
 
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;


/**
 * BCM_CCD_2002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_2002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_2002HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd2002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmDatProcVO mdmDatProcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmDatProcVO[] mdmDatProcVOs = null;

	public BcmCcd2002Event(){}
	
	public void setMdmDatProcVO(MdmDatProcVO mdmDatProcVO){
		this. mdmDatProcVO = mdmDatProcVO;
	}

	public void setMdmDatProcVOS(MdmDatProcVO[] mdmDatProcVOs){
		if(mdmDatProcVOs != null){
			MdmDatProcVO[] tmpVOs = java.util.Arrays.copyOf(mdmDatProcVOs, mdmDatProcVOs.length);
			this.mdmDatProcVOs = tmpVOs;
		}
	}

	public MdmDatProcVO getMdmDatProcVO(){
		return mdmDatProcVO;
	}

	public MdmDatProcVO[] getMdmDatProcVOS(){
		MdmDatProcVO[] rtnVOs = null;
		if (this.mdmDatProcVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mdmDatProcVOs, mdmDatProcVOs.length);
		}
		return rtnVOs;
	}

}