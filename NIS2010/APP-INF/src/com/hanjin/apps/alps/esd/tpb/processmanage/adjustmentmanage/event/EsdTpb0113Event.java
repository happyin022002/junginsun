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
package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.event;

import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchAdjustmentManageListVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeRequestVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeApproveVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.DeleteResponsibleOfficeChangeRequestVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
		this. searchAdjustmentManageListVOS = searchAdjustmentManageListVOs;
	}

	public SearchAdjustmentManageListVO getSearchAdjustmentManageListVO(){
		return searchAdjustmentManageListVO;
	}

	public SearchAdjustmentManageListVO[] getSearchAdjustmentManageListVOS(){
		return searchAdjustmentManageListVOS;
	}
	
	public void setSearchResponsibleOfficeChangeVO(SearchResponsibleOfficeChangeVO searchResponsibleOfficeChangeVO){
		this. searchResponsibleOfficeChangeVO = searchResponsibleOfficeChangeVO;
	}

	public void setSearchResponsibleOfficeChangeVOS(SearchResponsibleOfficeChangeVO[] searchResponsibleOfficeChangeVOs){
		this. searchResponsibleOfficeChangeVOS = searchResponsibleOfficeChangeVOs;
	}

	public SearchResponsibleOfficeChangeVO getSearchResponsibleOfficeChangeVO(){
		return searchResponsibleOfficeChangeVO;
	}

	public SearchResponsibleOfficeChangeVO[] getSearchResponsibleOfficeChangeVOS(){
		return searchResponsibleOfficeChangeVOS;
	}
	
	public void setSearchResponsibleOfficeChangeInquiryVO(SearchResponsibleOfficeChangeInquiryVO searchResponsibleOfficeChangeInquiryVO){
		this. searchResponsibleOfficeChangeInquiryVO = searchResponsibleOfficeChangeInquiryVO;
	}

	public void setSearchResponsibleOfficeChangeInquiryVOS(SearchResponsibleOfficeChangeInquiryVO[] searchResponsibleOfficeChangeInquiryVOs){
		this. searchResponsibleOfficeChangeInquiryVOS = searchResponsibleOfficeChangeInquiryVOs;
	}

	public SearchResponsibleOfficeChangeInquiryVO getSearchResponsibleOfficeChangeInquiryVO(){
		return searchResponsibleOfficeChangeInquiryVO;
	}

	public SearchResponsibleOfficeChangeInquiryVO[] getSearchResponsibleOfficeChangeInquiryVOS(){
		return searchResponsibleOfficeChangeInquiryVOS;
	}
	
	public void setCreateResponsibleOfficeChangeRequestVO(CreateResponsibleOfficeChangeRequestVO createResponsibleOfficeChangeRequestVO){
		this. createResponsibleOfficeChangeRequestVO = createResponsibleOfficeChangeRequestVO;
	}

	public void setCreateResponsibleOfficeChangeRequestVOS(CreateResponsibleOfficeChangeRequestVO[] createResponsibleOfficeChangeRequestVOs){
		this. createResponsibleOfficeChangeRequestVOS = createResponsibleOfficeChangeRequestVOs;
	}

	public CreateResponsibleOfficeChangeRequestVO getCreateResponsibleOfficeChangeRequestVO(){
		return createResponsibleOfficeChangeRequestVO;
	}

	public CreateResponsibleOfficeChangeRequestVO[] getCreateResponsibleOfficeChangeRequestVOS(){
		return createResponsibleOfficeChangeRequestVOS;
	}
	
	public void setCreateResponsibleOfficeChangeApproveVO(CreateResponsibleOfficeChangeApproveVO createResponsibleOfficeChangeApproveVO){
		this. createResponsibleOfficeChangeApproveVO = createResponsibleOfficeChangeApproveVO;
	}

	public void setCreateResponsibleOfficeChangeApproveVOS(CreateResponsibleOfficeChangeApproveVO[] createResponsibleOfficeChangeApproveVOs){
		this. createResponsibleOfficeChangeApproveVOS = createResponsibleOfficeChangeApproveVOs;
	}

	public CreateResponsibleOfficeChangeApproveVO getCreateResponsibleOfficeChangeApproveVO(){
		return createResponsibleOfficeChangeApproveVO;
	}

	public CreateResponsibleOfficeChangeApproveVO[] getCreateResponsibleOfficeChangeApproveVOS(){
		return createResponsibleOfficeChangeApproveVOS;
	}
	
	public void setDeleteResponsibleOfficeChangeRequestVO(DeleteResponsibleOfficeChangeRequestVO deleteResponsibleOfficeChangeRequestVO){
		this. deleteResponsibleOfficeChangeRequestVO = deleteResponsibleOfficeChangeRequestVO;
	}

	public void setDeleteResponsibleOfficeChangeRequestVOS(DeleteResponsibleOfficeChangeRequestVO[] deleteResponsibleOfficeChangeRequestVOs){
		this. deleteResponsibleOfficeChangeRequestVOS = deleteResponsibleOfficeChangeRequestVOs;
	}

	public DeleteResponsibleOfficeChangeRequestVO getDeleteResponsibleOfficeChangeRequestVO(){
		return deleteResponsibleOfficeChangeRequestVO;
	}

	public DeleteResponsibleOfficeChangeRequestVO[] getDeleteResponsibleOfficeChangeRequestVOS(){
		return deleteResponsibleOfficeChangeRequestVOS;
	}
}