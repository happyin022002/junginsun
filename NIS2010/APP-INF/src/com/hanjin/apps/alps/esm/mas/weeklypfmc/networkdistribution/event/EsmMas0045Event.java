/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0045Event.java
*@FileTitle : EsmMas0045Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo.SearchHJSSalesAmountListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0045HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0045Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkDistributionCommonVO mNetworkDistributionCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkDistributionCommonVO[] mNetworkDistributionCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;
	
	/** Save 단건 처리 */
	private SearchHJSSalesAmountListVO mSearchHJSSalesAmountListVO = null;
	
	/** Save Multi Data 처리 */
    private SearchHJSSalesAmountListVO[] mSearchHJSSalesAmountListVOs = null;


	/** Constructor */
	public EsmMas0045Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0045Event";
	}

	/** ValueObject Setter */
	public void setNetworkDistributionCommonVO(NetworkDistributionCommonVO networkDistributionCommonVO){
		this.mNetworkDistributionCommonVO = networkDistributionCommonVO;
	}
	/** ValueObject Getter */
	public NetworkDistributionCommonVO getNetworkDistributionCommonVO(){
		return mNetworkDistributionCommonVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setNetworkDistributionCommonVOs(NetworkDistributionCommonVO[] networkDistributionCommonVOs){
		mNetworkDistributionCommonVOs = networkDistributionCommonVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public NetworkDistributionCommonVO[] getNetworkDistributionCommonVOs(){
		return mNetworkDistributionCommonVOs;
	}	
		
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}

	/** ValueObject Setter */
	public void setSearchHJSSalesAmountListVO(SearchHJSSalesAmountListVO mSearchHJSSalesAmountListVO) {
		this.mSearchHJSSalesAmountListVO = mSearchHJSSalesAmountListVO;
	}
	/** ValueObject Getter */
	public SearchHJSSalesAmountListVO getSearchHJSSalesAmountListVO() {
		return mSearchHJSSalesAmountListVO;
	}

	/** ValueObject Array Setter - Create/Update/Delete */
	public void setSearchHJSSalesAmountListVOs(SearchHJSSalesAmountListVO[] mSearchHJSSalesAmountListVOs) {
		this.mSearchHJSSalesAmountListVOs = mSearchHJSSalesAmountListVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public SearchHJSSalesAmountListVO[] getSearchHJSSalesAmountListVOs() {
		return mSearchHJSSalesAmountListVOs;
	}
	
}
