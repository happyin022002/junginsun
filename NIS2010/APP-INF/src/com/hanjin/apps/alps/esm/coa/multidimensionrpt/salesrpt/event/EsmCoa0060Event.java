/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0060Event.java
*@FileTitle : EsmCoa0060Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event;

import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.syscommon.common.table.BsaJntOpCrrCapaVO;

/**
 * ESM_COA_0060 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0060HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0060HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0060Event extends EventSupport {

	/** 단건처리 */
	private SalesRPTCommonVO mSalesRPTCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SalesRPTCommonVO[] mSalesRPTCommonVOs = null;

	
	/** 단건처리 */
	private BsaJntOpCrrCapaVO mBsaJntOpCrrCapaVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private BsaJntOpCrrCapaVO[] mBsaJntOpCrrCapaVOs = null;	

	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;

	/** Constructor */
	public EsmCoa0060Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0060Event";
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
		mSalesRPTCommonVOs = salesRPTCommonVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public SalesRPTCommonVO[] getSalesRPTCommonVOs(){
		return mSalesRPTCommonVOs;
	}	
	
	
	
	/** ValueObject Setter */
	public void setBsaJntOpCrrCapaVO(BsaJntOpCrrCapaVO bsaJntOpCrrCapaVO){
		this.mBsaJntOpCrrCapaVO = bsaJntOpCrrCapaVO;
	}
	/** ValueObject Getter */
	public BsaJntOpCrrCapaVO getBsaJntOpCrrCapaVO(){
		return mBsaJntOpCrrCapaVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setBsaJntOpCrrCapaVOs(BsaJntOpCrrCapaVO[] bsaJntOpCrrCapaVOs){
		mBsaJntOpCrrCapaVOs = bsaJntOpCrrCapaVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public BsaJntOpCrrCapaVO[] getBsaJntOpCrrCapaVOs(){
		return mBsaJntOpCrrCapaVOs;
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
