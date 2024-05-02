/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Esmagt0001Event.java
*@FileTitle : Agent Vendor List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.19 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.AgtAgnAgmtVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;


/**
 * EsmAgt0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EsmAgt0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Jin
 * @see EsmAgt0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnAgmtVO agtAgnAgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtAgnAgmtVO[] agtAgnAgmtVOs = null;
	
	private MdmOrganizationVO mdmOrganizationVO = null;
	
	private MdmOrganizationVO[] mdmOrganizationVOs = null;

	public EsmAgt0001Event(){}
	
	public void setAgtAgnAgmtVO(AgtAgnAgmtVO agtAgnAgmtVO){
		this. agtAgnAgmtVO = agtAgnAgmtVO;
	}

	public void setAgtAgnAgmtVOS(AgtAgnAgmtVO[] agtAgnAgmtVOs){
		this. agtAgnAgmtVOs = agtAgnAgmtVOs;
	}
	
	public void setMdmOrganizationVO(MdmOrganizationVO mdmOrganizationVO) {
    	this.mdmOrganizationVO = mdmOrganizationVO;
    }	

	public void setMdmOrganizationVOs(MdmOrganizationVO[] mdmOrganizationVOs) {
    	this.mdmOrganizationVOs = mdmOrganizationVOs;
    }
	
	public AgtAgnAgmtVO getAgtAgnAgmtVO(){
		return agtAgnAgmtVO;
	}

	public AgtAgnAgmtVO[] getAgtAgnAgmtVOS(){
		return agtAgnAgmtVOs;
	}
	
	public MdmOrganizationVO getMdmOrganizationVO() {
    	return mdmOrganizationVO;
    }
	
	public MdmOrganizationVO[] getMdmOrganizationVOs() {
    	return mdmOrganizationVOs;
    }
}