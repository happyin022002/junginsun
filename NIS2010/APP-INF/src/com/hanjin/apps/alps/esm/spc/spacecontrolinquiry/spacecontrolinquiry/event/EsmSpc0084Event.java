/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSpc0084Event.java
*@FileTitle : ESM_SPC_0084
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2011.03.03 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryBSAVO;
import com.hanjin.syscommon.common.table.SpcBsaMgmtVO;


/**
 * ESM_SPC_0084 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0084HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jongkyu Weon
 * @see ESM_SPC_0084HTMLAction 참조
 * @since J2EE 1.6
 */


public class EsmSpc0084Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiryBSAVO searchSpaceControlInquiryBSAVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiryBSAVO[] searchSpaceControlInquiryBSAVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcBsaMgmtVO spcBsaMgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcBsaMgmtVO[] spcBsaMgmtVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ConditionVO[] conditionVOs = null;

	public EsmSpc0084Event(){}
	
	public void setSearchSpaceControlInquiryBSAVO(
			SearchSpaceControlInquiryBSAVO searchSpaceControlInquiryBSAVO){
		this. searchSpaceControlInquiryBSAVO = searchSpaceControlInquiryBSAVO;
	}
	
	public void setSearchSpaceControlInquiryBSAVOs(
			SearchSpaceControlInquiryBSAVO[] searchSpaceControlInquiryBSAVOs){
		if (searchSpaceControlInquiryBSAVOs != null) {
			SearchSpaceControlInquiryBSAVO[] tmpVOs = new SearchSpaceControlInquiryBSAVO[searchSpaceControlInquiryBSAVOs.length];
			System.arraycopy(searchSpaceControlInquiryBSAVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlInquiryBSAVOs = tmpVOs;
		}
	}

	public SearchSpaceControlInquiryBSAVO getSearchSpaceControlInquiryBSAVO(){
		return searchSpaceControlInquiryBSAVO;
	}
	
	public SearchSpaceControlInquiryBSAVO[] getSearchSpaceControlInquiryBSAVOS(){
		SearchSpaceControlInquiryBSAVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryBSAVOs != null) {
			rtnVOs = new SearchSpaceControlInquiryBSAVO[searchSpaceControlInquiryBSAVOs.length];
			System.arraycopy(searchSpaceControlInquiryBSAVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;	
	}
	
	public void setSpcBsaMgmtVO(
			SpcBsaMgmtVO spcBsaMgmtVO){
		this. spcBsaMgmtVO = spcBsaMgmtVO;
	}
	
	public void setSpcBsaMgmtVOS(
			SpcBsaMgmtVO[] spcBsaMgmtVOs){

		if (spcBsaMgmtVOs != null) {
			SpcBsaMgmtVO[] tmpVOs = new SpcBsaMgmtVO[spcBsaMgmtVOs.length];
			System.arraycopy(spcBsaMgmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcBsaMgmtVOs = tmpVOs;
		}
	}

	public SpcBsaMgmtVO getSpcBsaMgmtVO(){
		return spcBsaMgmtVO;
	}
	
	public SpcBsaMgmtVO[] getSpcBsaMgmtVOS(){
		SpcBsaMgmtVO[] rtnVOs = null;
		if (this.spcBsaMgmtVOs != null) {
			rtnVOs = new SpcBsaMgmtVO[spcBsaMgmtVOs.length];
			System.arraycopy(spcBsaMgmtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public void setConditionVOS(ConditionVO[] conditionVOs){
		if (conditionVOs != null) {
			ConditionVO[] tmpVOs = new ConditionVO[conditionVOs.length];
			System.arraycopy(conditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.conditionVOs = tmpVOs;
		}

	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	public ConditionVO[] getConditionVOS(){
		ConditionVO[] rtnVOs = null;
		if (this.conditionVOs != null) {
			rtnVOs = new ConditionVO[conditionVOs.length];
			System.arraycopy(conditionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}