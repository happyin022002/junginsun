/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0059Event.java
*@FileTitle : EsmCoa0059Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaRptItmInfoDtlVO;
import com.hanjin.syscommon.common.table.CoaRptItmInfoMstVO;

/**
 * ESM_COA_0059 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0059HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0059HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0059Event extends EventSupport {

	/** 단건처리 */
	private SalesRPTCommonVO mSalesRPTCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SalesRPTCommonVO[] mSalesRPTCommonVOs = null;

	
	/** 단건처리 */
	private CoaRptItmInfoMstVO mCoaRptItmInfoMstVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaRptItmInfoMstVO[] mCoaRptItmInfoMstVOs = null;	
	
	/** 단건처리 */
	private CoaRptItmInfoDtlVO mCoaRptItmInfoDtlVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaRptItmInfoDtlVO[] mCoaRptItmInfoDtlVOs = null;	
	

	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	



	/** Constructor */
	public EsmCoa0059Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0059Event";
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
	public void setCoaRptItmInfoMstVO(CoaRptItmInfoMstVO coaRptItmInfoMstVO){
		this.mCoaRptItmInfoMstVO = coaRptItmInfoMstVO;
	}
	/** ValueObject Getter */
	public CoaRptItmInfoMstVO getCoaRptItmInfoMstVO(){
		return mCoaRptItmInfoMstVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCoaRptItmInfoMstVOs(CoaRptItmInfoMstVO[] coaRptItmInfoMstVOs){
		mCoaRptItmInfoMstVOs = coaRptItmInfoMstVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CoaRptItmInfoMstVO[] getCoaRptItmInfoMstVOs(){
		return mCoaRptItmInfoMstVOs;
	}	
	
	
	/** ValueObject Setter */
	public void setCoaRptItmInfoDtlVO(CoaRptItmInfoDtlVO coaRptItmInfoDtlVO){
		this.mCoaRptItmInfoDtlVO = coaRptItmInfoDtlVO;
	}
	/** ValueObject Getter */
	public CoaRptItmInfoDtlVO getCoaRptItmInfoDtlVO(){
		return mCoaRptItmInfoDtlVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCoaRptItmInfoDtlVOs(CoaRptItmInfoDtlVO[] coaRptItmInfoDtlVOs){
		mCoaRptItmInfoDtlVOs = coaRptItmInfoDtlVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CoaRptItmInfoDtlVO[] getCoaRptItmInfoDtlVOs(){
		return mCoaRptItmInfoDtlVOs;
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
