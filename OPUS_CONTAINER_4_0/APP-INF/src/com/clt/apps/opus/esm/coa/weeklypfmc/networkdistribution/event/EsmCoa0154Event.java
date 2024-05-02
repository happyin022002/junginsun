/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0154Event.java
*@FileTitle : EsmCoa0154Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.event;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0154 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0154HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0154HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0154Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkDistributionCommonVO mNetworkDistributionCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkDistributionCommonVO[] mNetworkDistributionCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	


	/** Constructor */
	public EsmCoa0154Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0154Event";
	}

	/** ValueObject Setter */
	public void setNetworkDistributionCommonVO(NetworkDistributionCommonVO networkDistributionCommonVO){
		this.mNetworkDistributionCommonVO = networkDistributionCommonVO;
	}
	/** ValueObject Getter */
	public NetworkDistributionCommonVO getNetworkDistributionCommonVO(){
		return mNetworkDistributionCommonVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */			//SJH.20150508.소스품질
	public void setNetworkDistributionCommonVOs(NetworkDistributionCommonVO[] networkDistributionCommonVOs){
		if(networkDistributionCommonVOs != null){
			NetworkDistributionCommonVO[] tmpVOs = Arrays.copyOf(networkDistributionCommonVOs, networkDistributionCommonVOs.length);
			this.mNetworkDistributionCommonVOs = tmpVOs;
		}
	}		
	/** ValueObject Array Getter - Create/Update/Delete */			//SJH.20150508.소스품질
	public NetworkDistributionCommonVO[] getNetworkDistributionCommonVOs(){
		NetworkDistributionCommonVO[] rtnVOs = null;
		if (this.mNetworkDistributionCommonVOs != null) {
			rtnVOs = Arrays.copyOf(mNetworkDistributionCommonVOs, mNetworkDistributionCommonVOs.length);
		}
		return rtnVOs;
	}	
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}		
	
}
