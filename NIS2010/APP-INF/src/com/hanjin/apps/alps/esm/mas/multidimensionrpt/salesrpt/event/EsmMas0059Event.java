/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0059Event.java
*@FileTitle : EsmMas0059Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasRptItmInfoDtlVO;
import com.hanjin.syscommon.common.table.MasRptItmInfoMstVO;

/**
 * ESM_MAS_0059 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0059HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0059HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0059Event extends EventSupport {

	/** 단건처리 */
	private SalesRPTCommonVO mSalesRPTCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SalesRPTCommonVO[] mSalesRPTCommonVOs = null;

	
	/** 단건처리 */
	private MasRptItmInfoMstVO mMasRptItmInfoMstVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasRptItmInfoMstVO[] mMasRptItmInfoMstVOs = null;	
	
	/** 단건처리 */
	private MasRptItmInfoDtlVO mMasRptItmInfoDtlVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasRptItmInfoDtlVO[] mMasRptItmInfoDtlVOs = null;	
	

	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	



	/** Constructor */
	public EsmMas0059Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0059Event";
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
	public void setMasRptItmInfoMstVO(MasRptItmInfoMstVO masRptItmInfoMstVO){
		this.mMasRptItmInfoMstVO = masRptItmInfoMstVO;
	}
	/** ValueObject Getter */
	public MasRptItmInfoMstVO getMasRptItmInfoMstVO(){
		return mMasRptItmInfoMstVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasRptItmInfoMstVOs(MasRptItmInfoMstVO[] masRptItmInfoMstVOs){
		mMasRptItmInfoMstVOs = masRptItmInfoMstVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasRptItmInfoMstVO[] getMasRptItmInfoMstVOs(){
		return mMasRptItmInfoMstVOs;
	}	
	
	
	/** ValueObject Setter */
	public void setMasRptItmInfoDtlVO(MasRptItmInfoDtlVO masRptItmInfoDtlVO){
		this.mMasRptItmInfoDtlVO = masRptItmInfoDtlVO;
	}
	/** ValueObject Getter */
	public MasRptItmInfoDtlVO getMasRptItmInfoDtlVO(){
		return mMasRptItmInfoDtlVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasRptItmInfoDtlVOs(MasRptItmInfoDtlVO[] masRptItmInfoDtlVOs){
		mMasRptItmInfoDtlVOs = masRptItmInfoDtlVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasRptItmInfoDtlVO[] getMasRptItmInfoDtlVOs(){
		return mMasRptItmInfoDtlVOs;
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
