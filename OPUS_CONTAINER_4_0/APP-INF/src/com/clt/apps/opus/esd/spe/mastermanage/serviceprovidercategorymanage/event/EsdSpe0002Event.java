/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSpe002Event.java
*@FileTitle : S/P Category 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.27 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.event;

import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchSPCategoryManageConditionVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchSPCategoryManageVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchVndrSeqVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SpeSvcProvSvcCateMtchVO;


/**
 * ESD_SPE_002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESD_SPE_002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpeSvcProvSvcCateMtchVO speSvcProvSvcCateMtchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpeSvcProvSvcCateMtchVO[] speSvcProvSvcCateMtchVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSPCategoryManageVO searchSPCategoryManageVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSPCategoryManageVO[] searchSPCategoryManageVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSPCategoryManageConditionVO searchSPCategoryManageConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSPCategoryManageConditionVO[] searchSPCategoryManageConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVndrSeqVO searchVndrSeqVO = null;
	
	
	public EsdSpe0002Event(){}
	
	public void setSpeSvcProvSvcCateMtchVO(SpeSvcProvSvcCateMtchVO speSvcProvSvcCateMtchVO){
		this. speSvcProvSvcCateMtchVO = speSvcProvSvcCateMtchVO;
	}

	public void setSpeSvcProvSvcCateMtchVOS(SpeSvcProvSvcCateMtchVO[] speSvcProvSvcCateMtchVOs){
		this. speSvcProvSvcCateMtchVOs = speSvcProvSvcCateMtchVOs;
	}

	public void setSearchSPCategoryManageVO(SearchSPCategoryManageVO searchSPCategoryManageVO){
		this. searchSPCategoryManageVO = searchSPCategoryManageVO;
	}

	public void setSearchSPCategoryManageVOS(SearchSPCategoryManageVO[] searchSPCategoryManageVOs){
		this. searchSPCategoryManageVOs = searchSPCategoryManageVOs;
	}
	
	public void setSearchSPCategoryManageConditionVO(
			SearchSPCategoryManageConditionVO searchSPCategoryManageConditionVO) {
		this.searchSPCategoryManageConditionVO = searchSPCategoryManageConditionVO;
	}
	
	public void setSearchSPCategoryManageConditionVOs(
			SearchSPCategoryManageConditionVO[] searchSPCategoryManageConditionVOs) {
		this.searchSPCategoryManageConditionVOs = searchSPCategoryManageConditionVOs;
	}

	public void setSearchVndrSeqVO(SearchVndrSeqVO searchVndrSeqVO) {
		this.searchVndrSeqVO = searchVndrSeqVO;
	}

	public SpeSvcProvSvcCateMtchVO getSpeSvcProvSvcCateMtchVO(){
		return speSvcProvSvcCateMtchVO;
	}

	public SpeSvcProvSvcCateMtchVO[] getSpeSvcProvSvcCateMtchVOS(){
		return speSvcProvSvcCateMtchVOs;
	}

	public SearchSPCategoryManageVO getSearchSPCategoryManageVO(){
		return searchSPCategoryManageVO;
	}

	public SearchSPCategoryManageVO[] getSearchSPCategoryManageVOS(){
		return searchSPCategoryManageVOs;
	}
	
	public SearchSPCategoryManageConditionVO getSearchSPCategoryManageConditionVO() {
		return searchSPCategoryManageConditionVO;
	}
	
	public SearchSPCategoryManageConditionVO[] getSearchSPCategoryManageConditionVOs() {
		return searchSPCategoryManageConditionVOs;
	}

	
	public SearchVndrSeqVO getSearchVndrSeqVO() {
		return searchVndrSeqVO;
	}


}