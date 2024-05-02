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
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaRptItmInfoDtlVO;
import com.clt.syscommon.common.table.CoaRptItmInfoMstVO;
import java.util.Arrays;									//SJH.20150507.소스품질

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
	
	/** ValueObject Array Setter - Create/Update/Delete */	//SJH.20150507.소스품질
	public void setSalesRPTCommonVOs(SalesRPTCommonVO[] salesRPTCommonVOs){
		if(salesRPTCommonVOs != null){
			SalesRPTCommonVO[] tmpVOs = Arrays.copyOf(salesRPTCommonVOs, salesRPTCommonVOs.length);
			this.mSalesRPTCommonVOs = tmpVOs;
		}
		
	}
	/** ValueObject Array Getter - Create/Update/Delete */	//SJH.20150507.소스품질
	public SalesRPTCommonVO[] getSalesRPTCommonVOs(){
		SalesRPTCommonVO[] rtnVOs = null;
		if (this.mSalesRPTCommonVOs != null) {
			rtnVOs = Arrays.copyOf(mSalesRPTCommonVOs, mSalesRPTCommonVOs.length);
		}
		return rtnVOs;
	}	
	
	
	
	/** ValueObject Setter */
	public void setCoaRptItmInfoMstVO(CoaRptItmInfoMstVO coaRptItmInfoMstVO){
		this.mCoaRptItmInfoMstVO = coaRptItmInfoMstVO;
	}
	/** ValueObject Getter */
	public CoaRptItmInfoMstVO getCoaRptItmInfoMstVO(){
		return mCoaRptItmInfoMstVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */	//SJH.20150507.소스품질
	public void setCoaRptItmInfoMstVOs(CoaRptItmInfoMstVO[] coaRptItmInfoMstVOs){
		if(coaRptItmInfoMstVOs != null){
			CoaRptItmInfoMstVO[] tmpVOs = Arrays.copyOf(coaRptItmInfoMstVOs, coaRptItmInfoMstVOs.length);
			this.mCoaRptItmInfoMstVOs = tmpVOs;
		}		
	}
	/** ValueObject Array Getter - Create/Update/Delete */	//SJH.20150507.소스품질
	public CoaRptItmInfoMstVO[] getCoaRptItmInfoMstVOs(){
		CoaRptItmInfoMstVO[] rtnVOs = null;
		if (this.mCoaRptItmInfoMstVOs != null) {
			rtnVOs = Arrays.copyOf(mCoaRptItmInfoMstVOs, mCoaRptItmInfoMstVOs.length);
		}
		return rtnVOs;
	}	
	
	
	/** ValueObject Setter */
	public void setCoaRptItmInfoDtlVO(CoaRptItmInfoDtlVO coaRptItmInfoDtlVO){
		this.mCoaRptItmInfoDtlVO = coaRptItmInfoDtlVO;
	}
	/** ValueObject Getter */
	public CoaRptItmInfoDtlVO getCoaRptItmInfoDtlVO(){
		return mCoaRptItmInfoDtlVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */	//SJH.20150507.소스품질
	public void setCoaRptItmInfoDtlVOs(CoaRptItmInfoDtlVO[] coaRptItmInfoDtlVOs){
		if(coaRptItmInfoDtlVOs != null){
			CoaRptItmInfoDtlVO[] tmpVOs = Arrays.copyOf(coaRptItmInfoDtlVOs, coaRptItmInfoDtlVOs.length);
			this.mCoaRptItmInfoDtlVOs = tmpVOs;
		}		
	}
	/** ValueObject Array Getter - Create/Update/Delete */	//SJH.20150507.소스품질
	public CoaRptItmInfoDtlVO[] getCoaRptItmInfoDtlVOs(){
		CoaRptItmInfoDtlVO[] rtnVOs = null;
		if (this.mCoaRptItmInfoDtlVOs != null) {
			rtnVOs = Arrays.copyOf(mCoaRptItmInfoDtlVOs, mCoaRptItmInfoDtlVOs.length);
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
