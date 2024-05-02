/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmMas0253Event.java
*@FileTitle : Chassis Cost
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-19
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2014-11-18 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchChassisCostVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchChassisUnitCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;
//import com.hanjin.syscommon.common.table.CoaBnkTrfVO;

/**
 * ESM_MAS_0251 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0251HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0251HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0253Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchChassisCostVO searchChassisCostVO = null;
	private SearchChassisUnitCostVO searchChassisUnitCostVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SearchChassisCostVO[] searchChassisCostVOs = null;
	private SearchChassisUnitCostVO[] searchChassisUnitCostVOs = null;

	private String key=null;
	
//	/** 단건처리 */
//	private CoaBnkTrfVO mCoaBnkTrfVO = null;
//	
//	/** Multi Data 처리 - Create/Update/Delete */
//	private CoaBnkTrfVO[] mCoaBnkTrfVOs = null;	

	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	


	/** Constructor */
	public EsmMas0253Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0253Event";
	}

	public SearchChassisCostVO getSearchChassisCostVO() {
		return searchChassisCostVO;
	}

	public void setSearchChassisCostVO(SearchChassisCostVO searchChassisCostVO) {
		this.searchChassisCostVO = searchChassisCostVO;
	}

	public SearchChassisUnitCostVO getSearchChassisUnitCostVO() {
		return searchChassisUnitCostVO;
	}

	public void setSearchChassisUnitCostVO(
			SearchChassisUnitCostVO searchChassisUnitCostVO) {
		this.searchChassisUnitCostVO = searchChassisUnitCostVO;
	}

	public SearchChassisCostVO[] getSearchChassisCostVOs() {
		return searchChassisCostVOs;
	}

	public void setSearchChassisCostVOs(SearchChassisCostVO[] searchChassisCostVOs) {
		this.searchChassisCostVOs = searchChassisCostVOs;
	}

	public SearchChassisUnitCostVO[] getSearchChassisUnitCostVOs() {
		return searchChassisUnitCostVOs;
	}

	public void setSearchChassisUnitCostVOs(
			SearchChassisUnitCostVO[] searchChassisUnitCostVOs) {
		this.searchChassisUnitCostVOs = searchChassisUnitCostVOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
 
	
			
}
