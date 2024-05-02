/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0946Event.java
 *@FileTitle : Integrated Customer Data Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 박성호
 *@LastVersion : 1.0
 * 2009.05.20 박성호
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import java.util.Vector;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0946 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0946HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Chang June
 * @see ESM_BKG_0946HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0946Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ArrNtcGrpSendListVO[] listVOS = null;
	private ArrNtcGrpSendListVO searchVO = null;
	private ArrNtcGrpSendVO grpSendVO = null;
	private Vector<String> faxNo;

	public ArrNtcGrpSendVO getGrpSendVO() {
		return grpSendVO;
	}

	public void setGrpSendVO(ArrNtcGrpSendVO grpSendVO) {
		this.grpSendVO = grpSendVO;
	}

	
	public Vector<String> getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(Vector<String> faxNo) {
		this.faxNo = faxNo;
	}

	public Vector<String> getEmail() {
		return email;
	}

	public void setEmail(Vector<String> email) {
		this.email = email;
	}

	private Vector<String> email;
	

	public ArrNtcGrpSendListVO getSearchVO() {
		return searchVO;
	}

	public void setSearchVO(ArrNtcGrpSendListVO searchVO) {
		this.searchVO = searchVO;
	}

	public EsmBkg0946Event() {
	}

	public ArrNtcGrpSendListVO[] getListVOS() {
		return listVOS;
	}

	public void setListVOS(ArrNtcGrpSendListVO[] listVOS) {
		this.listVOS = listVOS;
	}

	


}