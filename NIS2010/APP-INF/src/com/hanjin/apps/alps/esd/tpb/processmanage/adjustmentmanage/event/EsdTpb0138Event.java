/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0138Event.java
*@FileTitle : AdjustmentManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.10.01 최 선 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.event;

import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffApproveVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffRequestVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.DeleteWriteOffRequestVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchAdjustmentManageListVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffInquiryReviewVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffReviewVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0138 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0138HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, CHOI
 * @see ESD_TPB_0138HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0138Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAdjustmentManageListVO searchAdjustmentManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAdjustmentManageListVO[] searchAdjustmentManageListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchWriteOffReviewVO searchWriteOffVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchWriteOffReviewVO[] searchWriteOffVOS = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchWriteOffInquiryReviewVO searchWriteOffInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchWriteOffInquiryReviewVO[] searchWriteOffInquiryVOS = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CreateWriteOffRequestVO createWriteOffRequestVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CreateWriteOffRequestVO[] createWriteOffRequestVOS = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CreateWriteOffApproveVO createWriteOffApproveVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CreateWriteOffApproveVO[] createWriteOffApproveVOS = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DeleteWriteOffRequestVO deleteWriteOffRequestVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DeleteWriteOffRequestVO[] deleteWriteOffRequestVOS = null;
	
	public EsdTpb0138Event(){}
	
	public void setSearchAdjustmentManageListVO(SearchAdjustmentManageListVO searchAdjustmentManageListVO){
		this. searchAdjustmentManageListVO = searchAdjustmentManageListVO;
	}

	public void setSearchAdjustmentManageListVOS(SearchAdjustmentManageListVO[] searchAdjustmentManageListVOs){
		this. searchAdjustmentManageListVOs = searchAdjustmentManageListVOs;
	}

	public SearchAdjustmentManageListVO getSearchAdjustmentManageListVO(){
		return searchAdjustmentManageListVO;
	}

	public SearchAdjustmentManageListVO[] getSearchAdjustmentManageListVOS(){
		return searchAdjustmentManageListVOs;
	}

	public SearchWriteOffReviewVO getSearchWriteOffReviewVO(){
		return searchWriteOffVO;
	}

	public SearchWriteOffReviewVO[] getSearchWriteOffReviewVOS(){
		return searchWriteOffVOS;
	}
	
	public void setSearchWriteOffReviewVO(SearchWriteOffReviewVO searchWriteOffVO){
		this. searchWriteOffVO = searchWriteOffVO;
	}

	public void setSearchWriteOffReviewVOS(SearchWriteOffReviewVO[] searchWriteOffVOs){
		this. searchWriteOffVOS = searchWriteOffVOs;
	}

	public SearchWriteOffInquiryReviewVO getSearchWriteOffInquiryReviewVO(){
		return searchWriteOffInquiryVO;
	}

	public SearchWriteOffInquiryReviewVO[] getSearchWriteOffInquiryReviewVOS(){
		return searchWriteOffInquiryVOS;
	}
	
	public void setSearchWriteOffInquiryReviewVO(SearchWriteOffInquiryReviewVO searchWriteOffInquiryVO){
		this. searchWriteOffInquiryVO = searchWriteOffInquiryVO;
	}

	public void setSearchWriteOffInquiryReviewVOS(SearchWriteOffInquiryReviewVO[] searchWriteOffInquiryVOs){
		this. searchWriteOffInquiryVOS = searchWriteOffInquiryVOs;
	}
	
	public void setCreateWriteOffRequestVO(CreateWriteOffRequestVO createWriteOffRequestVO){
		this. createWriteOffRequestVO = createWriteOffRequestVO;
	}

	public void setCreateWriteOffRequestVOS(CreateWriteOffRequestVO[] createWriteOffRequestVOs){
		this. createWriteOffRequestVOS = createWriteOffRequestVOs;
	}

	public CreateWriteOffRequestVO getCreateWriteOffRequestVO(){
		return createWriteOffRequestVO;
	}

	public CreateWriteOffRequestVO[] getCreateWriteOffRequestVOS(){
		return createWriteOffRequestVOS;
	}
	
	public void setCreateWriteOffApproveVO(CreateWriteOffApproveVO createWriteOffApproveVO){
		this. createWriteOffApproveVO = createWriteOffApproveVO;
	}

	public void setCreateWriteOffApproveVOS(CreateWriteOffApproveVO[] createWriteOffApproveVOs){
		this. createWriteOffApproveVOS = createWriteOffApproveVOs;
	}

	public CreateWriteOffApproveVO getCreateWriteOffApproveVO(){
		return createWriteOffApproveVO;
	}

	public CreateWriteOffApproveVO[] getCreateWriteOffApproveVOS(){
		return createWriteOffApproveVOS;
	}
	
	public void setDeleteWriteOffRequestVO(DeleteWriteOffRequestVO deleteWriteOffRequestVO){
		this. deleteWriteOffRequestVO = deleteWriteOffRequestVO;
	}

	public void setDeleteWriteOffRequestVOS(DeleteWriteOffRequestVO[] deleteWriteOffRequestVOs){
		this. deleteWriteOffRequestVOS = deleteWriteOffRequestVOs;
	}

	public DeleteWriteOffRequestVO getDeleteWriteOffRequestVO(){
		return deleteWriteOffRequestVO;
	}

	public DeleteWriteOffRequestVO[] getDeleteWriteOffRequestVOS(){
		return deleteWriteOffRequestVOS;
	}
}