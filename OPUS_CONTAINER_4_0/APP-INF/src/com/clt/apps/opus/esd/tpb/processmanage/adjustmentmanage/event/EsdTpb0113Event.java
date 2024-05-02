/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0113Event.java
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

import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeApproveVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.DeleteResponsibleOfficeChangeRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchAdjustmentManageListVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeInquiryVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0113 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0113HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, CHOI
 * @see ESD_TPB_0113HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0113Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAdjustmentManageListVO searchAdjustmentManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAdjustmentManageListVO[] searchAdjustmentManageListVOS = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchResponsibleOfficeChangeVO searchResponsibleOfficeChangeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchResponsibleOfficeChangeVO[] searchResponsibleOfficeChangeVOS = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchResponsibleOfficeChangeInquiryVO searchResponsibleOfficeChangeInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchResponsibleOfficeChangeInquiryVO[] searchResponsibleOfficeChangeInquiryVOS = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CreateResponsibleOfficeChangeRequestVO createResponsibleOfficeChangeRequestVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CreateResponsibleOfficeChangeRequestVO[] createResponsibleOfficeChangeRequestVOS = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CreateResponsibleOfficeChangeApproveVO createResponsibleOfficeChangeApproveVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CreateResponsibleOfficeChangeApproveVO[] createResponsibleOfficeChangeApproveVOS = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DeleteResponsibleOfficeChangeRequestVO deleteResponsibleOfficeChangeRequestVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DeleteResponsibleOfficeChangeRequestVO[] deleteResponsibleOfficeChangeRequestVOS = null;
	
	public EsdTpb0113Event(){}
	
	public void setSearchAdjustmentManageListVO(SearchAdjustmentManageListVO searchAdjustmentManageListVO){
		this. searchAdjustmentManageListVO = searchAdjustmentManageListVO;
	}

	public void setSearchAdjustmentManageListVOS(SearchAdjustmentManageListVO[] searchAdjustmentManageListVOs){
		if(searchAdjustmentManageListVOs != null){
			SearchAdjustmentManageListVO[] tmpVOs = Arrays.copyOf(searchAdjustmentManageListVOs, searchAdjustmentManageListVOs.length);
			this.searchAdjustmentManageListVOS = tmpVOs;
		}
	}

	public SearchAdjustmentManageListVO getSearchAdjustmentManageListVO(){
		return searchAdjustmentManageListVO;
	}

	public SearchAdjustmentManageListVO[] getSearchAdjustmentManageListVOS(){
		SearchAdjustmentManageListVO[] rtnVOs = null;
		if (this.searchAdjustmentManageListVOS != null) {
			rtnVOs = Arrays.copyOf(searchAdjustmentManageListVOS, searchAdjustmentManageListVOS.length);
		}
		return rtnVOs;
	}
	
	public void setSearchResponsibleOfficeChangeVO(SearchResponsibleOfficeChangeVO searchResponsibleOfficeChangeVO){
		this. searchResponsibleOfficeChangeVO = searchResponsibleOfficeChangeVO;
	}

	public void setSearchResponsibleOfficeChangeVOS(SearchResponsibleOfficeChangeVO[] searchResponsibleOfficeChangeVOs){
		if(searchResponsibleOfficeChangeVOs != null){
			SearchResponsibleOfficeChangeVO[] tmpVOs = Arrays.copyOf(searchResponsibleOfficeChangeVOs, searchResponsibleOfficeChangeVOs.length);
			this.searchResponsibleOfficeChangeVOS = tmpVOs;
		}
	}

	public SearchResponsibleOfficeChangeVO getSearchResponsibleOfficeChangeVO(){
		return searchResponsibleOfficeChangeVO;
	}

	public SearchResponsibleOfficeChangeVO[] getSearchResponsibleOfficeChangeVOS(){
		SearchResponsibleOfficeChangeVO[] rtnVOs = null;
		if (this.searchResponsibleOfficeChangeVOS != null) {
			rtnVOs = Arrays.copyOf(searchResponsibleOfficeChangeVOS, searchResponsibleOfficeChangeVOS.length);
		}
		return rtnVOs;
	}
	
	public void setSearchResponsibleOfficeChangeInquiryVO(SearchResponsibleOfficeChangeInquiryVO searchResponsibleOfficeChangeInquiryVO){
		this. searchResponsibleOfficeChangeInquiryVO = searchResponsibleOfficeChangeInquiryVO;
	}

	public void setSearchResponsibleOfficeChangeInquiryVOS(SearchResponsibleOfficeChangeInquiryVO[] searchResponsibleOfficeChangeInquiryVOs){
		if(searchResponsibleOfficeChangeInquiryVOs != null){
			SearchResponsibleOfficeChangeInquiryVO[] tmpVOs = Arrays.copyOf(searchResponsibleOfficeChangeInquiryVOs, searchResponsibleOfficeChangeInquiryVOs.length);
			this.searchResponsibleOfficeChangeInquiryVOS = tmpVOs;
		}
	}

	public SearchResponsibleOfficeChangeInquiryVO getSearchResponsibleOfficeChangeInquiryVO(){
		return searchResponsibleOfficeChangeInquiryVO;
	}

	public SearchResponsibleOfficeChangeInquiryVO[] getSearchResponsibleOfficeChangeInquiryVOS(){
		SearchResponsibleOfficeChangeInquiryVO[] rtnVOs = null;
		if (this.searchResponsibleOfficeChangeInquiryVOS != null) {
			rtnVOs = Arrays.copyOf(searchResponsibleOfficeChangeInquiryVOS, searchResponsibleOfficeChangeInquiryVOS.length);
		}
		return rtnVOs;
	}
	
	public void setCreateResponsibleOfficeChangeRequestVO(CreateResponsibleOfficeChangeRequestVO createResponsibleOfficeChangeRequestVO){
		this. createResponsibleOfficeChangeRequestVO = createResponsibleOfficeChangeRequestVO;
	}

	public void setCreateResponsibleOfficeChangeRequestVOS(CreateResponsibleOfficeChangeRequestVO[] createResponsibleOfficeChangeRequestVOs){
		if(createResponsibleOfficeChangeRequestVOs != null){
			CreateResponsibleOfficeChangeRequestVO[] tmpVOs = Arrays.copyOf(createResponsibleOfficeChangeRequestVOs, createResponsibleOfficeChangeRequestVOs.length);
			this.createResponsibleOfficeChangeRequestVOS = tmpVOs;
		}
	}

	public CreateResponsibleOfficeChangeRequestVO getCreateResponsibleOfficeChangeRequestVO(){
		return createResponsibleOfficeChangeRequestVO;
	}

	public CreateResponsibleOfficeChangeRequestVO[] getCreateResponsibleOfficeChangeRequestVOS(){
		CreateResponsibleOfficeChangeRequestVO[] rtnVOs = null;
		if (this.createResponsibleOfficeChangeRequestVOS != null) {
			rtnVOs = Arrays.copyOf(createResponsibleOfficeChangeRequestVOS, createResponsibleOfficeChangeRequestVOS.length);
		}
		return rtnVOs;
	}
	
	public void setCreateResponsibleOfficeChangeApproveVO(CreateResponsibleOfficeChangeApproveVO createResponsibleOfficeChangeApproveVO){
		this. createResponsibleOfficeChangeApproveVO = createResponsibleOfficeChangeApproveVO;
	}

	public void setCreateResponsibleOfficeChangeApproveVOS(CreateResponsibleOfficeChangeApproveVO[] createResponsibleOfficeChangeApproveVOs){
		if(createResponsibleOfficeChangeApproveVOs != null){
			CreateResponsibleOfficeChangeApproveVO[] tmpVOs = Arrays.copyOf(createResponsibleOfficeChangeApproveVOs, createResponsibleOfficeChangeApproveVOs.length);
			this.createResponsibleOfficeChangeApproveVOS = tmpVOs;
		}
	}

	public CreateResponsibleOfficeChangeApproveVO getCreateResponsibleOfficeChangeApproveVO(){
		return createResponsibleOfficeChangeApproveVO;
	}

	public CreateResponsibleOfficeChangeApproveVO[] getCreateResponsibleOfficeChangeApproveVOS(){
		CreateResponsibleOfficeChangeApproveVO[] rtnVOs = null;
		if (this.createResponsibleOfficeChangeApproveVOS != null) {
			rtnVOs = Arrays.copyOf(createResponsibleOfficeChangeApproveVOS, createResponsibleOfficeChangeApproveVOS.length);
		}
		return rtnVOs;
	}
	
	public void setDeleteResponsibleOfficeChangeRequestVO(DeleteResponsibleOfficeChangeRequestVO deleteResponsibleOfficeChangeRequestVO){
		this. deleteResponsibleOfficeChangeRequestVO = deleteResponsibleOfficeChangeRequestVO;
	}

	public void setDeleteResponsibleOfficeChangeRequestVOS(DeleteResponsibleOfficeChangeRequestVO[] deleteResponsibleOfficeChangeRequestVOs){
		if(deleteResponsibleOfficeChangeRequestVOs != null){
			DeleteResponsibleOfficeChangeRequestVO[] tmpVOs = Arrays.copyOf(deleteResponsibleOfficeChangeRequestVOs, deleteResponsibleOfficeChangeRequestVOs.length);
			this.deleteResponsibleOfficeChangeRequestVOS = tmpVOs;
		}
	}

	public DeleteResponsibleOfficeChangeRequestVO getDeleteResponsibleOfficeChangeRequestVO(){
		return deleteResponsibleOfficeChangeRequestVO;
	}

	public DeleteResponsibleOfficeChangeRequestVO[] getDeleteResponsibleOfficeChangeRequestVOS(){
		DeleteResponsibleOfficeChangeRequestVO[] rtnVOs = null;
		if (this.deleteResponsibleOfficeChangeRequestVOS != null) {
			rtnVOs = Arrays.copyOf(deleteResponsibleOfficeChangeRequestVOS, deleteResponsibleOfficeChangeRequestVOS.length);
		}
		return rtnVOs;
	}
}