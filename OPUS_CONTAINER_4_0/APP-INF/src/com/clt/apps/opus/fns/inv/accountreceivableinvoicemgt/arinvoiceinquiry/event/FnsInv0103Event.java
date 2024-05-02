/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0103Event.java
*@FileTitle : CPR Download History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;


import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTMainVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0103HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CPRTMainVO cPRTMainVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CPRTMainVO[] cPRTMainVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CPRTListVO[] cPRTListVOs = null;
	
	private CPRTListVO cPRTListVO = null;
	
	private String custRptId = null;

	public FnsInv0103Event(){}
	
	public void setCPRTMainVO(CPRTMainVO cPRTMainVO){
		this. cPRTMainVO = cPRTMainVO;
	}

	public void setCPRTMainVOS(CPRTMainVO[] cPRTMainVOs){
		if(cPRTMainVOs != null){
			CPRTMainVO[] tmpVOs = new CPRTMainVO[cPRTMainVOs.length];
			System.arraycopy(cPRTMainVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cPRTMainVOs = tmpVOs;
		}
	}

	public CPRTMainVO getCPRTMainVO(){
		return cPRTMainVO;
	}

	public CPRTMainVO[] getCPRTMainVOS(){
		CPRTMainVO[] rtnVOs = null;
		if (this.cPRTMainVOs != null) {
			rtnVOs = new CPRTMainVO[cPRTMainVOs.length];
			System.arraycopy(cPRTMainVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public CPRTListVO[] getCPRTListVOs() {
		CPRTListVO[] rtnVOs = null;
		if (this.cPRTListVOs != null) {
			rtnVOs = new CPRTListVO[cPRTListVOs.length];
			System.arraycopy(cPRTListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCPRTListVOs(CPRTListVO[] listVOs) {
		if(cPRTListVOs != null){
			CPRTListVO[] tmpVOs = new CPRTListVO[cPRTListVOs.length];
			System.arraycopy(cPRTListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cPRTListVOs = tmpVOs;
		}
	}

	public CPRTListVO getCPRTListVO() {
		return cPRTListVO;
	}

	public void setCPRTListVO(CPRTListVO listVO) {
		cPRTListVO = listVO;
	}

	public String getCustRptId() {
		return custRptId;
	}

	public void setCustRptId(String custRptId) {
		this.custRptId = custRptId;
	}
	
}