/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0042Event.java
*@FileTitle : EsmMas0042Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchOtherVesselDailyHireListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasBnkTrfVO;

/**
 * ESM_MAS_0042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0042HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0042Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkCostCommonVO mNetworkCostCommonVO = null;
	private SearchOtherVesselDailyHireListVO mSearchOtherVesselDailyHireListVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkCostCommonVO[] mNetworkCostCommonVOs = null;
	private SearchOtherVesselDailyHireListVO[] mSearchOtherVesselDailyHireListVOs = null;
	
	/** 단건처리 */
	private MasBnkTrfVO mMasBnkTrfVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasBnkTrfVO[] mMasBnkTrfVOs = null;	


	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;
	

	/** Constructor */
	public EsmMas0042Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0042Event";
	}

	/** ValueObject Setter */
	public void setNetworkCostCommonVO(NetworkCostCommonVO networkCostCommonVO){
		this.mNetworkCostCommonVO = networkCostCommonVO;
	}
	/** ValueObject Getter */
	public NetworkCostCommonVO getNetworkCostCommonVO(){
		return mNetworkCostCommonVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setNetworkCostCommonVOs(NetworkCostCommonVO[] networkCostCommonVOs){
		mNetworkCostCommonVOs = networkCostCommonVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public NetworkCostCommonVO[] getNetworkCostCommonVOs(){
		return mNetworkCostCommonVOs;
	}	
	
	
	
	/** ValueObject Setter */
	public void setMasBnkTrfVO(MasBnkTrfVO masBnkTrfVO){
		this.mMasBnkTrfVO = masBnkTrfVO;
	}
	/** ValueObject Getter */
	public MasBnkTrfVO getMasBnkTrfVO(){
		return mMasBnkTrfVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasBnkTrfVOs(MasBnkTrfVO[] masBnkTrfVOs){
		mMasBnkTrfVOs = masBnkTrfVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasBnkTrfVO[] getMasBnkTrfVOs(){
		return mMasBnkTrfVOs;
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
	public void setSearchOtherVesselDailyHireListVO(SearchOtherVesselDailyHireListVO searchOtherVesselDailyHireListVO){
		this.mSearchOtherVesselDailyHireListVO = searchOtherVesselDailyHireListVO;
	}
	/** ValueObject Getter */
	public SearchOtherVesselDailyHireListVO getSearchOtherVesselDailyHireListVO(){
		return mSearchOtherVesselDailyHireListVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setSearchOtherVesselDailyHireListVOs(SearchOtherVesselDailyHireListVO[] searchOtherVesselDailyHireListVOs){
		mSearchOtherVesselDailyHireListVOs = searchOtherVesselDailyHireListVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public SearchOtherVesselDailyHireListVO[] getSearchOtherVesselDailyHireListVOs(){
		return mSearchOtherVesselDailyHireListVOs;
	}
	
}
