/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0114Event.java
*@FileTitle : AdjustmentManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.10.01 최 선 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffApproveVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.DeleteWriteOffRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchAdjustmentManageListVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffInquiryVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0114 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0114HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, CHOI
 * @see ESD_TPB_0114HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0114Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAdjustmentManageListVO searchAdjustmentManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAdjustmentManageListVO[] searchAdjustmentManageListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchWriteOffVO searchWriteOffVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchWriteOffVO[] searchWriteOffVOS = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchWriteOffInquiryVO searchWriteOffInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchWriteOffInquiryVO[] searchWriteOffInquiryVOS = null;

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
	
	public EsdTpb0114Event(){}
	
	public void setSearchAdjustmentManageListVO(SearchAdjustmentManageListVO searchAdjustmentManageListVO){
		this. searchAdjustmentManageListVO = searchAdjustmentManageListVO;
	}

	public void setSearchAdjustmentManageListVOS(SearchAdjustmentManageListVO[] searchAdjustmentManageListVOs){
		if(searchAdjustmentManageListVOs != null){
			SearchAdjustmentManageListVO[] tmpVOs = Arrays.copyOf(searchAdjustmentManageListVOs, searchAdjustmentManageListVOs.length);
			this.searchAdjustmentManageListVOs = tmpVOs;
		}
	}

	public SearchAdjustmentManageListVO getSearchAdjustmentManageListVO(){
		return searchAdjustmentManageListVO;
	}

	public SearchAdjustmentManageListVO[] getSearchAdjustmentManageListVOS(){
		SearchAdjustmentManageListVO[] rtnVOs = null;
		if (this.searchAdjustmentManageListVOs != null) {
			rtnVOs = Arrays.copyOf(searchAdjustmentManageListVOs, searchAdjustmentManageListVOs.length);
		}
		return rtnVOs;
	}

	public SearchWriteOffVO getSearchWriteOffVO(){
		return searchWriteOffVO;
	}

	public SearchWriteOffVO[] getSearchWriteOffVOS(){
		SearchWriteOffVO[] rtnVOs = null;
		if (this.searchWriteOffVOS != null) {
			rtnVOs = Arrays.copyOf(searchWriteOffVOS, searchWriteOffVOS.length);
		}
		return rtnVOs;
	}
	
	public void setSearchWriteOffVO(SearchWriteOffVO searchWriteOffVO){
		this. searchWriteOffVO = searchWriteOffVO;
	}

	public void setSearchWriteOffVOS(SearchWriteOffVO[] searchWriteOffVOs){
		if(searchWriteOffVOs != null){
			SearchWriteOffVO[] tmpVOs = Arrays.copyOf(searchWriteOffVOs, searchWriteOffVOs.length);
			this.searchWriteOffVOS = tmpVOs;
		}
	}

	public SearchWriteOffInquiryVO getSearchWriteOffInquiryVO(){
		return searchWriteOffInquiryVO;
	}

	public SearchWriteOffInquiryVO[] getSearchWriteOffInquiryVOS(){
		SearchWriteOffInquiryVO[] rtnVOs = null;
		if (this.searchWriteOffInquiryVOS != null) {
			rtnVOs = Arrays.copyOf(searchWriteOffInquiryVOS, searchWriteOffInquiryVOS.length);
		}
		return rtnVOs;
	}
	
	public void setSearchWriteOffInquiryVO(SearchWriteOffInquiryVO searchWriteOffInquiryVO){
		this. searchWriteOffInquiryVO = searchWriteOffInquiryVO;
	}

	public void setSearchWriteOffInquiryVOS(SearchWriteOffInquiryVO[] searchWriteOffInquiryVOs){
		if(searchWriteOffInquiryVOs != null){
			SearchWriteOffInquiryVO[] tmpVOs = Arrays.copyOf(searchWriteOffInquiryVOs, searchWriteOffInquiryVOs.length);
			this.searchWriteOffInquiryVOS = tmpVOs;
		}
	}
	
	public void setCreateWriteOffRequestVO(CreateWriteOffRequestVO createWriteOffRequestVO){
		this. createWriteOffRequestVO = createWriteOffRequestVO;
	}

	public void setCreateWriteOffRequestVOS(CreateWriteOffRequestVO[] createWriteOffRequestVOs){
		if(createWriteOffRequestVOs != null){
			CreateWriteOffRequestVO[] tmpVOs = Arrays.copyOf(createWriteOffRequestVOs, createWriteOffRequestVOs.length);
			this.createWriteOffRequestVOS = tmpVOs;
		}
	}

	public CreateWriteOffRequestVO getCreateWriteOffRequestVO(){
		return createWriteOffRequestVO;
	}

	public CreateWriteOffRequestVO[] getCreateWriteOffRequestVOS(){
		CreateWriteOffRequestVO[] rtnVOs = null;
		if (this.createWriteOffRequestVOS != null) {
			rtnVOs = Arrays.copyOf(createWriteOffRequestVOS, createWriteOffRequestVOS.length);
		}
		return rtnVOs;
	}
	
	public void setCreateWriteOffApproveVO(CreateWriteOffApproveVO createWriteOffApproveVO){
		this. createWriteOffApproveVO = createWriteOffApproveVO;
	}

	public void setCreateWriteOffApproveVOS(CreateWriteOffApproveVO[] createWriteOffApproveVOs){
		if(createWriteOffApproveVOs != null){
			CreateWriteOffApproveVO[] tmpVOs = Arrays.copyOf(createWriteOffApproveVOs, createWriteOffApproveVOs.length);
			this.createWriteOffApproveVOS = tmpVOs;
		}
	}

	public CreateWriteOffApproveVO getCreateWriteOffApproveVO(){
		return createWriteOffApproveVO;
	}

	public CreateWriteOffApproveVO[] getCreateWriteOffApproveVOS(){
		CreateWriteOffApproveVO[] rtnVOs = null;
		if (this.createWriteOffApproveVOS != null) {
			rtnVOs = Arrays.copyOf(createWriteOffApproveVOS, createWriteOffApproveVOS.length);
		}
		return rtnVOs;
	}
	
	public void setDeleteWriteOffRequestVO(DeleteWriteOffRequestVO deleteWriteOffRequestVO){
		this. deleteWriteOffRequestVO = deleteWriteOffRequestVO;
	}

	public void setDeleteWriteOffRequestVOS(DeleteWriteOffRequestVO[] deleteWriteOffRequestVOs){
		if(deleteWriteOffRequestVOs != null){
			DeleteWriteOffRequestVO[] tmpVOs = Arrays.copyOf(deleteWriteOffRequestVOs, deleteWriteOffRequestVOs.length);
			this.deleteWriteOffRequestVOS = tmpVOs;
		}
	}

	public DeleteWriteOffRequestVO getDeleteWriteOffRequestVO(){
		return deleteWriteOffRequestVO;
	}

	public DeleteWriteOffRequestVO[] getDeleteWriteOffRequestVOS(){
		DeleteWriteOffRequestVO[] rtnVOs = null;
		if (this.deleteWriteOffRequestVOS != null) {
			rtnVOs = Arrays.copyOf(deleteWriteOffRequestVOS, deleteWriteOffRequestVOS.length);
		}
		return rtnVOs;
	}
}