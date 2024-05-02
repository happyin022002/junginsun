/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0066Event.java
*@FileTitle : JO Member Information Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.18 함대성
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.11.08 이준범 [CHM-201006731-01]
* 1. 대상 기능
*   - JO Member Information Creation(JOO_0066)
*   - Inquiry of JO Member Information(JOO_0067)
* 2. 보완 대상
*   - Revenue Lane 정보 반영 
*   - MS Office( Excel, Worl, Power Point등) 첨부
*   - Carrier Name등 컬럼 반영
* 2010.12.02 이준범 [CHM-201007349-01]
* 1. 보완 기능 
*   - JO Member Information Creation
*   - Inquiry of JO Member Information
* 2. 보완 요청 사항
*   - 컬럼 추가 : PIC of HJS(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CarrierSeqVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustCdInfoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustCdNmVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustMemberVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.PicOfUserInfoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.MstComInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.JooCntcMbrVO;


/**
 * FNS_JOO_0066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0066HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0066Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CustCdNmVO custCdNmVO = null;
	
	private CustCdInfoVO custCdInfoVO  = null;
	
	private CarrierSeqVO carrierSeqVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooCntcMbrVO jooCntcMbrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooCntcMbrVO[] jooCntcMbrVOs = null;
	
	private CustMemberVO custMemberVO = null;
	
	private CustMemberVO[] custMemberVOs = null;
	
	private PicOfUserInfoVO picOfUserInfoVO = null;
	
	private String joCntcPicId = "";

	public FnsJoo0066Event(){}
	
	public void setJooCntcMbrVO(JooCntcMbrVO jooCntcMbrVO){
		this. jooCntcMbrVO = jooCntcMbrVO;
	}

	public void setJooCntcMbrVOS(JooCntcMbrVO[] jooCntcMbrVOs){
		if (jooCntcMbrVOs != null) {
			JooCntcMbrVO[] tmpVOs = new JooCntcMbrVO[jooCntcMbrVOs.length];
			System.arraycopy(jooCntcMbrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooCntcMbrVOs = tmpVOs;
		}		
	}

	public JooCntcMbrVO getJooCntcMbrVO(){
		return jooCntcMbrVO;
	}

	public JooCntcMbrVO[] getJooCntcMbrVOS(){
		JooCntcMbrVO[] rtnVOs = null;
		if (this.jooCntcMbrVOs != null) {
			rtnVOs = new JooCntcMbrVO[jooCntcMbrVOs.length];
			System.arraycopy(jooCntcMbrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;				
	}

	/**
	 * @return the custCdNmVO
	 */
	public CustCdNmVO getCustCdNmVO() {
		return custCdNmVO;
	}

	/**
	 * @param custCdNmVO the custCdNmVO to set
	 */
	public void setCustCdNmVO(CustCdNmVO custCdNmVO) {
		this.custCdNmVO = custCdNmVO;
	}

	/**
	 * @return the carrierSeqVO
	 */
	public CarrierSeqVO getCarrierSeqVO() {
		return carrierSeqVO;
	}

	/**
	 * @param carrierSeqVO the carrierSeqVO to set
	 */
	public void setCarrierSeqVO(CarrierSeqVO carrierSeqVO) {
		this.carrierSeqVO = carrierSeqVO;
	}

	/**
	 * @return the custCdInfoVO
	 */
	public CustCdInfoVO getCustCdInfoVO() {
		return custCdInfoVO;
	}

	/**
	 * @param custCdInfoVO the custCdInfoVO to set
	 */
	public void setCustCdInfoVO(CustCdInfoVO custCdInfoVO) {
		this.custCdInfoVO = custCdInfoVO;
	}
 
	public CustMemberVO getCustMemberVO() {
		return custMemberVO;
	}

	public void setCustMemberVO(CustMemberVO custMemberVO) {
		this.custMemberVO = custMemberVO;
	}
	
	public CustMemberVO[] getCustMemberVOs() {
		CustMemberVO[] rtnVOs = null;
		if (this.custMemberVOs != null) {
			rtnVOs = new CustMemberVO[custMemberVOs.length];
			System.arraycopy(custMemberVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setCustMemberVOS(CustMemberVO[] custMemberVOs) {
		if (custMemberVOs != null) {
			CustMemberVO[] tmpVOs = new CustMemberVO[custMemberVOs.length];
			System.arraycopy(custMemberVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.custMemberVOs = tmpVOs;
		}		
	}
	
	public PicOfUserInfoVO getPicOfUserInfoVO() {
		return picOfUserInfoVO;
	}

	public void setPicOfUserInfoVO(PicOfUserInfoVO picOfUserInfoVO) {
		this.picOfUserInfoVO = picOfUserInfoVO;
	}
	
	public String getJoCntcPicId() {
		return joCntcPicId;
	}

	public void setJoCntcPicId(String joCntcPicId) {
		this.joCntcPicId = joCntcPicId;
	}
}