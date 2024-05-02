/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0042Event.java
*@FileTitle : EsmCoa0042Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaBnkTrfVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0042HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0042Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkCostCommonVO mNetworkCostCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkCostCommonVO[] mNetworkCostCommonVOs = null;

	
	/** 단건처리 */
	private CoaBnkTrfVO mCoaBnkTrfVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaBnkTrfVO[] mCoaBnkTrfVOs = null;	


	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;
	

	/** Constructor */
	public EsmCoa0042Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0042Event";
	}

	/** ValueObject Setter */
	public void setNetworkCostCommonVO(NetworkCostCommonVO networkCostCommonVO){
		this.mNetworkCostCommonVO = networkCostCommonVO;
	}
	/** ValueObject Getter */
	public NetworkCostCommonVO getNetworkCostCommonVO(){
		return mNetworkCostCommonVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */			//SJH.20150508.소스품질
	public void setNetworkCostCommonVOs(NetworkCostCommonVO[] networkCostCommonVOs){
		if(networkCostCommonVOs != null){
			NetworkCostCommonVO[] tmpVOs = Arrays.copyOf(networkCostCommonVOs, networkCostCommonVOs.length);
			this.mNetworkCostCommonVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete */			//SJH.20150508.소스품질
	public NetworkCostCommonVO[] getNetworkCostCommonVOs(){
		NetworkCostCommonVO[] rtnVOs = null;
		if (this.mNetworkCostCommonVOs != null) {
			rtnVOs = Arrays.copyOf(mNetworkCostCommonVOs, mNetworkCostCommonVOs.length);
		}
		return rtnVOs;
	}	
	
	
	
	/** ValueObject Setter */
	public void setCoaBnkTrfVO(CoaBnkTrfVO coaBnkTrfVO){
		this.mCoaBnkTrfVO = coaBnkTrfVO;
	}
	/** ValueObject Getter */
	public CoaBnkTrfVO getCoaBnkTrfVO(){
		return mCoaBnkTrfVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */			//SJH.20150508.소스품질
	public void setCoaBnkTrfVOs(CoaBnkTrfVO[] coaBnkTrfVOs){
		if(coaBnkTrfVOs != null){
			CoaBnkTrfVO[] tmpVOs = Arrays.copyOf(coaBnkTrfVOs, coaBnkTrfVOs.length);
			this.mCoaBnkTrfVOs = tmpVOs;
		}		
	}
	/** ValueObject Array Getter - Create/Update/Delete */			//SJH.20150508.소스품질
	public CoaBnkTrfVO[] getCoaBnkTrfVOs(){
		CoaBnkTrfVO[] rtnVOs = null;
		if (this.mCoaBnkTrfVOs != null) {
			rtnVOs = Arrays.copyOf(mCoaBnkTrfVOs, mCoaBnkTrfVOs.length);
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
