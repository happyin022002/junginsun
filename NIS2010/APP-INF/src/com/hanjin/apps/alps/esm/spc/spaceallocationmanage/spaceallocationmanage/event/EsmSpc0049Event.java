/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSpc0049Event.java
*@FileTitle : Customized Condition
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.25
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2011.08.25 김종준
* 1.0 Creation
=========================================================
* History
* 2011.08.25 김종준 [CHM-201113071-01] control by HO/RHQ 화면과 COA 링크 팝업 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================
*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESM_SPC_0049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SPC_0049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong-jun kim
 * @see ESM_SPC_0049HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0049Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	/** 단건처리 */
	private SalesRPTCommonVO mSalesRPTCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SalesRPTCommonVO[] mSalesRPTCommonVOs = null;

	

	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;

	/** Constructor */
	public EsmSpc0049Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmSpc0049Event";
	}

	/** ValueObject Setter */
	public void setSalesRPTCommonVO(SalesRPTCommonVO salesRPTCommonVO){
		this.mSalesRPTCommonVO = salesRPTCommonVO;
	}
	/** ValueObject Getter */
	public SalesRPTCommonVO getSalesRPTCommonVO(){
		return mSalesRPTCommonVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setSalesRPTCommonVOs(SalesRPTCommonVO[] salesRPTCommonVOs){
		if (salesRPTCommonVOs != null) {
			SalesRPTCommonVO[] tmpVOs = new SalesRPTCommonVO[salesRPTCommonVOs.length];
			System.arraycopy(salesRPTCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mSalesRPTCommonVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public SalesRPTCommonVO[] getSalesRPTCommonVOs(){
		SalesRPTCommonVO[] rtnVOs = null;
		if (this.mSalesRPTCommonVOs != null) {
			rtnVOs = new SalesRPTCommonVO[mSalesRPTCommonVOs.length];
			System.arraycopy(mSalesRPTCommonVOs, 0, rtnVOs, 0, rtnVOs.length);
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