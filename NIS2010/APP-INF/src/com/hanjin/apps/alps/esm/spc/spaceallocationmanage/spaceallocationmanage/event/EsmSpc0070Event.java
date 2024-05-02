/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0070Event.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.01 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowDownloadDateListVO;
import com.hanjin.syscommon.common.table.SpcNshwRsltVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowAdjustmentListVO;
import com.hanjin.syscommon.common.table.SpcFcastDwnLodSkdVO;


/**
 * ESM_SPC_0070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0070HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0070Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchNoShowDownloadDateListVO searchNoShowDownloadDateListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchNoShowDownloadDateListVO[] searchNoShowDownloadDateListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcNshwRsltVO spcNshwRsltVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcNshwRsltVO[] spcNshwRsltVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchNoShowAdjustmentListVO searchNoShowAdjustmentListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchNoShowAdjustmentListVO[] searchNoShowAdjustmentListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcFcastDwnLodSkdVO spcFcastDwnLodSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcFcastDwnLodSkdVO[] spcFcastDwnLodSkdVOs = null;
	
	private ConditionVO conditionVO = null;

	public EsmSpc0070Event(){}
	
	public void setSearchNoShowDownloadDateListVO(SearchNoShowDownloadDateListVO searchNoShowDownloadDateListVO){
		this. searchNoShowDownloadDateListVO = searchNoShowDownloadDateListVO;
	}

	public void setSearchNoShowDownloadDateListVOS(SearchNoShowDownloadDateListVO[] searchNoShowDownloadDateListVOs){
		if (searchNoShowDownloadDateListVOs != null) {
			SearchNoShowDownloadDateListVO[] tmpVOs = new SearchNoShowDownloadDateListVO[searchNoShowDownloadDateListVOs.length];
			System.arraycopy(searchNoShowDownloadDateListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchNoShowDownloadDateListVOs = tmpVOs;
		}
	}

	public void setSpcNshwRsltVO(SpcNshwRsltVO spcNshwRsltVO){
		this. spcNshwRsltVO = spcNshwRsltVO;
	}

	public void setSpcNshwRsltVOS(SpcNshwRsltVO[] spcNshwRsltVOs){
		if (spcNshwRsltVOs != null) {
			SpcNshwRsltVO[] tmpVOs = new SpcNshwRsltVO[spcNshwRsltVOs.length];
			System.arraycopy(spcNshwRsltVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcNshwRsltVOs = tmpVOs;
		}
	}

	public void setSearchNoShowAdjustmentListVO(SearchNoShowAdjustmentListVO searchNoShowAdjustmentListVO){
		this. searchNoShowAdjustmentListVO = searchNoShowAdjustmentListVO;
	}

	public void setSearchNoShowAdjustmentListVOS(SearchNoShowAdjustmentListVO[] searchNoShowAdjustmentListVOs){
		if (searchNoShowAdjustmentListVOs != null) {
			SearchNoShowAdjustmentListVO[] tmpVOs = new SearchNoShowAdjustmentListVO[searchNoShowAdjustmentListVOs.length];
			System.arraycopy(searchNoShowAdjustmentListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchNoShowAdjustmentListVOs = tmpVOs;
		}
	}

	public void setSpcFcastDwnLodSkdVO(SpcFcastDwnLodSkdVO spcFcastDwnLodSkdVO){
		this. spcFcastDwnLodSkdVO = spcFcastDwnLodSkdVO;
	}

	public void setSpcFcastDwnLodSkdVOS(SpcFcastDwnLodSkdVO[] spcFcastDwnLodSkdVOs){
		if (spcFcastDwnLodSkdVOs != null) {
			SpcFcastDwnLodSkdVO[] tmpVOs = new SpcFcastDwnLodSkdVO[spcFcastDwnLodSkdVOs.length];
			System.arraycopy(spcFcastDwnLodSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcFcastDwnLodSkdVOs = tmpVOs;
		}
	}

	public SearchNoShowDownloadDateListVO getSearchNoShowDownloadDateListVO(){
		return searchNoShowDownloadDateListVO;
	}

	public SearchNoShowDownloadDateListVO[] getSearchNoShowDownloadDateListVOS(){
		SearchNoShowDownloadDateListVO[] rtnVOs = null;
		if (this.searchNoShowDownloadDateListVOs != null) {
			rtnVOs = new SearchNoShowDownloadDateListVO[searchNoShowDownloadDateListVOs.length];
			System.arraycopy(searchNoShowDownloadDateListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SpcNshwRsltVO getSpcNshwRsltVO(){
		return spcNshwRsltVO;
	}

	public SpcNshwRsltVO[] getSpcNshwRsltVOS(){
		SpcNshwRsltVO[] rtnVOs = null;
		if (this.spcNshwRsltVOs != null) {
			rtnVOs = new SpcNshwRsltVO[spcNshwRsltVOs.length];
			System.arraycopy(spcNshwRsltVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchNoShowAdjustmentListVO getSearchNoShowAdjustmentListVO(){
		return searchNoShowAdjustmentListVO;
	}

	public SearchNoShowAdjustmentListVO[] getSearchNoShowAdjustmentListVOS(){
		SearchNoShowAdjustmentListVO[] rtnVOs = null;
		if (this.searchNoShowAdjustmentListVOs != null) {
			rtnVOs = new SearchNoShowAdjustmentListVO[searchNoShowAdjustmentListVOs.length];
			System.arraycopy(searchNoShowAdjustmentListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SpcFcastDwnLodSkdVO getSpcFcastDwnLodSkdVO(){
		return spcFcastDwnLodSkdVO;
	}

	public SpcFcastDwnLodSkdVO[] getSpcFcastDwnLodSkdVOS(){
		SpcFcastDwnLodSkdVO[] rtnVOs = null;
		if (this.spcFcastDwnLodSkdVOs != null) {
			rtnVOs = new SpcFcastDwnLodSkdVO[spcFcastDwnLodSkdVOs.length];
			System.arraycopy(spcFcastDwnLodSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

}