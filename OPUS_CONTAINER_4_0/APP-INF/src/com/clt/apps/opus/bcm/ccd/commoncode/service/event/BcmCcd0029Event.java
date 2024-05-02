/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0029Event.java
*@FileTitle : vessel service scope
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.event;
 
import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.clt.apps.opus.bcm.ccd.commoncode.service.vo.ScopeGroupVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0029HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ScopeGroupVO scopeGroupVO = null;

	private ScopeGroupVO[] scopeGroupVOs = null;
	
	private String scpCd = null;
	
	private String slanCd = null; 
	
	private String rgnCd = null; 
	
	private String rqstNo = null;
	
	private MdmDatProcVO mdmDatProcVO = null;
	
	public void setScopeGroupVO(ScopeGroupVO scopeGroupVO){
		this. scopeGroupVO = scopeGroupVO;
	}
	
	public ScopeGroupVO getScopeGroupVO(){
		return scopeGroupVO;
	}
	
	public void setScopeGroupVOS(ScopeGroupVO[] scopeGroupVOs){
		if(scopeGroupVOs != null){
			ScopeGroupVO[] tmpVOs = java.util.Arrays.copyOf(scopeGroupVOs, scopeGroupVOs.length);
			this.scopeGroupVOs = tmpVOs;
		}
	}
	
	public ScopeGroupVO[] getScopeGroupVOS(){
		ScopeGroupVO[] rtnVOs = null;
		if (this.scopeGroupVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(scopeGroupVOs, scopeGroupVOs.length);
		}
		return rtnVOs;
	}
	
	public void setScpCd(String scpCd){
		this. scpCd = scpCd;
	}
	
	public String getScpCd(){
		return scpCd;
	}
	
	public void setSlanCd(String slanCd){
		this. slanCd = slanCd;
	}
	
	public String getSlanCd(){
		return slanCd;
	}
	
	public void setRgnCd(String rgnCd){
		this. rgnCd = rgnCd;
	}
	
	public String getRgnCd(){
		return rgnCd;
	}
	
	public String getRqstNo() {
		return rqstNo;
	}
	
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	public MdmDatProcVO getMdmDatProcVO() {
		return mdmDatProcVO;
	}

	public void setMdmDatProcVO(MdmDatProcVO mdmDatProcVO) {
		this.mdmDatProcVO = mdmDatProcVO;
	}

}