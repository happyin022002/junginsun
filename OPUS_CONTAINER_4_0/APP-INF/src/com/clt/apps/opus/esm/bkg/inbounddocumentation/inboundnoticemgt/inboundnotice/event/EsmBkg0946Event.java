/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0946Event.java
 *@FileTitle : Integrated Customer Data Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.05.20 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import java.util.Vector;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0946 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0946HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
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

//	public ArrNtcGrpSendListVO[] getListVOS() {
//		return listVOS;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public ArrNtcGrpSendListVO[] getListVOS() {
		ArrNtcGrpSendListVO[] tmpVOs = null;
		if (this.listVOS != null) {
			tmpVOs = new ArrNtcGrpSendListVO[listVOS.length];
			System.arraycopy(listVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 		

//	public void setListVOS(ArrNtcGrpSendListVO[] listVOS) {
//		this.listVOS = listVOS;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setListVOS(ArrNtcGrpSendListVO[] listVOS) {
		if (listVOS != null) {
			ArrNtcGrpSendListVO[] tmpVOs = new ArrNtcGrpSendListVO[listVOS.length];
			System.arraycopy(listVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.listVOS = tmpVOs;
		}		
	} 


}