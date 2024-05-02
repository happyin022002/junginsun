/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0206Event.java
*@FileTitle : COD Approval Detail at RSO Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.22 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ApprovalInformationVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODNoticeVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestInformationVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgCodCostVO;
import com.clt.syscommon.common.table.BkgCodVO;

/**
 * VOP_OPF_0206 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0206HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0206HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0206Event extends EventSupport {


//	event.setCodAuthVO((CodAuthVO)getVO(request, CodAuthVO .class));
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChangeOfDestinationVO changeOfDestinationVO = null;
	private CODRequestInformationVO cODRequestInformationVO = null;
	private ApprovalInformationVO approvalInformationVO = null;	
	private BkgCodCostVO bkgCodCostVO = null;
	
	private BkgCodCostListVO bkgCodCostListVO = null;
	
	private ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO = null;
	private CodAuthVO codAuthVO = null;
	private BkgCodVO bkgCodVO = null; 
	private CODNoticeVO cODNoticeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChangeOfDestinationVO[] changeOfDestinationVOs = null;
	private CODRequestInformationVO[] cODRequestInformationVOs = null;
	private ApprovalInformationVO[] approvalInformationVOs = null;
	private BkgCodCostVO[] bkgCodCostVOs = null;
	private BkgCodCostListVO[] bkgCodCostListVOs = null;
	
	//private BkgCodCostListVO bkgCodCostListVO = null;
	
	public VopOpf0206Event(){}
	
	public void setChangeOfDestinationVO(ChangeOfDestinationVO changeOfDestinationVO){
		this. changeOfDestinationVO = changeOfDestinationVO;
	}

	public void setChangeOfDestinationVOS(ChangeOfDestinationVO[] changeOfDestinationVOs){
		if (changeOfDestinationVOs != null) {
			ChangeOfDestinationVO[] tmpVOs = Arrays.copyOf(changeOfDestinationVOs, changeOfDestinationVOs.length);
			this.changeOfDestinationVOs = tmpVOs;
		} // end if
	}

	public ChangeOfDestinationVO getChangeOfDestinationVO(){
		return changeOfDestinationVO;
	}

	public ChangeOfDestinationVO[] getChangeOfDestinationVOS(){
		ChangeOfDestinationVO[] rtnVOs = null;
		if (this.changeOfDestinationVOs != null) {
			rtnVOs = Arrays.copyOf(this.changeOfDestinationVOs, this.changeOfDestinationVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public void setChangeOfDestinationMgtConditionVO(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) {
		this.changeOfDestinationMgtConditionVO = changeOfDestinationMgtConditionVO;
	}
	
	public ChangeOfDestinationMgtConditionVO getChangeOfDestinationMgtConditionVO() {
		return changeOfDestinationMgtConditionVO;
	}
	
	public void setCodAuthVO(CodAuthVO codAuthVO) {
		this.codAuthVO = codAuthVO;
	}
	
	public CodAuthVO getCodAuthVO() {
		return codAuthVO;
	}

	public void setCODNoticeVO(CODNoticeVO cODNoticeVO) {
		this.cODNoticeVO = cODNoticeVO;
	}
	
	public CODNoticeVO getCODNoticeVO() {
		return cODNoticeVO;
	}
	
	public void setBkgCodVO(BkgCodVO bkgCodVO) {
		this.bkgCodVO = bkgCodVO;
	}
	
	public BkgCodVO getBkgCodVO() {
		return bkgCodVO;
	}	
	
	public void setCODRequestInformationVO(CODRequestInformationVO cODRequestInformationVO){
		this. cODRequestInformationVO = cODRequestInformationVO;
	}

	public void setCODRequestInformationVOS(CODRequestInformationVO[] cODRequestInformationVOs){
		if (cODRequestInformationVOs != null) {
			CODRequestInformationVO[] tmpVOs = Arrays.copyOf(cODRequestInformationVOs,cODRequestInformationVOs.length);
			this.cODRequestInformationVOs = tmpVOs;
		} // end if
	}

	public CODRequestInformationVO getCODRequestInformationVO(){
		return cODRequestInformationVO;
	}

	public CODRequestInformationVO[] getCODRequestInformationVOS(){
		CODRequestInformationVO[] rtnVOs = null;
		if (this.cODRequestInformationVOs != null) {
			rtnVOs = Arrays.copyOf(this.cODRequestInformationVOs, this.cODRequestInformationVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setApprovalInformationVO(ApprovalInformationVO approvalInformationVO){
		this. approvalInformationVO = approvalInformationVO;
	}

	public void setApprovalInformationVOS(ApprovalInformationVO[] approvalInformationVOs){
		if (approvalInformationVOs != null) {
			ApprovalInformationVO[] tmpVOs = Arrays.copyOf(approvalInformationVOs, approvalInformationVOs.length);
			this.approvalInformationVOs = tmpVOs;
		} // end if
	}

	public ApprovalInformationVO getApprovalInformationVO(){
		return approvalInformationVO;
	}

	public ApprovalInformationVO[] getApprovalInformationVOS(){
		ApprovalInformationVO[] rtnVOs = null;
		if (this.approvalInformationVOs != null) {
			rtnVOs = Arrays.copyOf(this.approvalInformationVOs, this.approvalInformationVOs.length);
		} // end if
		return rtnVOs;
	}	
	
	public void setBkgCodCostVO(BkgCodCostVO bkgCodCostVO){
		this. bkgCodCostVO = bkgCodCostVO;
	}
	
	public void setBkgCodCostVOS(BkgCodCostVO[] bkgCodCostVOs){
		if (bkgCodCostVOs != null) {
			BkgCodCostVO[] tmpVOs = Arrays.copyOf(bkgCodCostVOs, bkgCodCostVOs.length);
			this.bkgCodCostVOs = tmpVOs;
		} // end if
	}

	public BkgCodCostVO getBkgCodCostVO(){
		return bkgCodCostVO;
	}

	public BkgCodCostVO[] getBkgCodCostVOS(){
		BkgCodCostVO[] rtnVOs = null;
		if (this.bkgCodCostVOs != null) {
			rtnVOs = Arrays.copyOf(this.bkgCodCostVOs, this.bkgCodCostVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setBkgCodCostListVO(BkgCodCostListVO bkgCodCostListVO){
		this. bkgCodCostListVO = bkgCodCostListVO;
	}
	
	public void setBkgCodCostListVOS(BkgCodCostListVO[] bkgCodCostListVOs){
		if (bkgCodCostListVOs != null) {
			BkgCodCostListVO[] tmpVOs = Arrays.copyOf(bkgCodCostListVOs, bkgCodCostListVOs.length);
			this.bkgCodCostListVOs = tmpVOs;
		} // end if
	}

	public BkgCodCostListVO getBkgCodCostListVO(){
		return bkgCodCostListVO;
	}

	public BkgCodCostListVO[] getBkgCodCostListVOS(){
		BkgCodCostListVO[] rtnVOs = null;
		if (this.bkgCodCostListVOs != null) {
			rtnVOs = Arrays.copyOf(this.bkgCodCostListVOs, this.bkgCodCostListVOs.length);
		} // end if
		return rtnVOs;
	}
}