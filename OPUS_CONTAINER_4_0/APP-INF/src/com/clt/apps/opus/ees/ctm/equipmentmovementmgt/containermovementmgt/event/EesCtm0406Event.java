/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiCtm0406Event.java
*@FileTitle : International MVMT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.06.12 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchBkgCntrListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchCLMInfoVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CtmMovementVO;


/**
 * UI_CTM_0406 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_CTM_0406HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KMWoo
 * @see EES_CTM_0406HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0406Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCLMInfoVO searchCLMInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchCLMInfoVO[] searchCLMInfoVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmMovementVO ctmMovementVO = null;

	/** Table Value Object Multi Data 처리 */
	private CtmMovementVO[] ctmMovementVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBkgCntrListVO searchBkgCntrListVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchBkgCntrListVO[] searchBkgCntrListVOs = null;

	private CtmCntrMovInfoVO ctmCntrMovInfoVO = null;

	private CtmCntrMovInfoVO[] ctmCntrMovInfoVOS = null;
	
	private CusCtmMovementVO cusCtmMovementVO = null; 
	
	public EesCtm0406Event(){}

	public void setSearchCLMInfoVO(SearchCLMInfoVO searchCLMInfoVO){
		this. searchCLMInfoVO = searchCLMInfoVO;
	}

	public void setSearchCLMInfoVOS(SearchCLMInfoVO[] searchCLMInfoVOs){
		if (searchCLMInfoVOs != null) {
			SearchCLMInfoVO[] tmpVOs = new SearchCLMInfoVO[searchCLMInfoVOs.length];
			System.arraycopy(searchCLMInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchCLMInfoVOs = tmpVOs;
		}
	}

	public void setCtmMovementVO(CtmMovementVO ctmMovementVO){
		this. ctmMovementVO = ctmMovementVO;
	}

	public void setCtmMovementVOS(CtmMovementVO[] ctmMovementVOs){
		if (ctmMovementVOs != null) {
			CtmMovementVO[] tmpVOs = new CtmMovementVO[ctmMovementVOs.length];
			System.arraycopy(ctmMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmMovementVOs = tmpVOs;
		}
	}

	public void setCtmCntrMovInfoVOS(CtmCntrMovInfoVO[] ctmCntrMovInfoVOS){
		if (ctmCntrMovInfoVOS != null) {
			CtmCntrMovInfoVO[] tmpVOs = new CtmCntrMovInfoVO[ctmCntrMovInfoVOS.length];
			System.arraycopy(ctmCntrMovInfoVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmCntrMovInfoVOS = tmpVOs;
		}
	}

	public void setCtmCntrMovInfoVO(CtmCntrMovInfoVO ctmCntrMovInfoVO){

		this. ctmCntrMovInfoVO = ctmCntrMovInfoVO;

	}

	public void setSearchBkgCntrListVO(SearchBkgCntrListVO searchBkgCntrListVO){
		this. searchBkgCntrListVO = searchBkgCntrListVO;
	}

	public void setSearchBkgCntrListVOS(SearchBkgCntrListVO[] searchBkgCntrListVOs){
		if (searchBkgCntrListVOs != null) {
			SearchBkgCntrListVO[] tmpVOs = new SearchBkgCntrListVO[searchBkgCntrListVOs.length];
			System.arraycopy(searchBkgCntrListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchBkgCntrListVOs = tmpVOs;
		}
	}

	public CtmCntrMovInfoVO getCtmCntrMovInfoVO(){
		return ctmCntrMovInfoVO;
	}

	public CtmCntrMovInfoVO[] getCtmCntrMovInfoVOS(){
		CtmCntrMovInfoVO[] tmpVOs = null;
		if (this.ctmCntrMovInfoVOS != null) {
			tmpVOs = new CtmCntrMovInfoVO[ctmCntrMovInfoVOS.length];
			System.arraycopy(ctmCntrMovInfoVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public SearchCLMInfoVO getSearchCLMInfoVO(){
		return searchCLMInfoVO;
	}

	public SearchCLMInfoVO[] getSearchCLMInfoVOS(){
		SearchCLMInfoVO[] tmpVOs = null;
		if (this.searchCLMInfoVOs != null) {
			tmpVOs = new SearchCLMInfoVO[searchCLMInfoVOs.length];
			System.arraycopy(searchCLMInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public CtmMovementVO getCtmMovementVO(){
		return ctmMovementVO;
	}

	public CtmMovementVO[] getCtmMovementVOS(){
		CtmMovementVO[] tmpVOs = null;
		if (this.ctmMovementVOs != null) {
			tmpVOs = new CtmMovementVO[ctmMovementVOs.length];
			System.arraycopy(ctmMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public SearchBkgCntrListVO getSearchBkgCntrListVO(){
		return searchBkgCntrListVO;
	}

	public SearchBkgCntrListVO[] getSearchBkgCntrListVOS(){
		SearchBkgCntrListVO[] tmpVOs = null;
		if (this.searchBkgCntrListVOs != null) {
			tmpVOs = new SearchBkgCntrListVO[searchBkgCntrListVOs.length];
			System.arraycopy(searchBkgCntrListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public CusCtmMovementVO getCusCtmMovementVO() {
		return cusCtmMovementVO;
	}

	public void setCusCtmMovementVO(CusCtmMovementVO cusCtmMovementVO) {
		this.cusCtmMovementVO = cusCtmMovementVO;
	}
}