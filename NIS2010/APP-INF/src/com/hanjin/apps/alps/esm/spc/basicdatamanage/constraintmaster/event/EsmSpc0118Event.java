/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmSpc0118Event.java
*@FileTitle :   Set Customized RPT Form 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : Seung-Man KIM
*@LastVersion : 1.0
* 2015.01.23 
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;


import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.ReportFormVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchConditionVO;
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
public class EsmSpc0118Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
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
	
	/** 단건처리 */
	private ReportFormVO mReportFormVO = null;
	/** Multi Data 처리 - Create/Update/Delete */
	private ReportFormVO[] mReportFormVOs = null;
	
	public ReportFormVO getmReportFormVO() {
		return mReportFormVO;
	}

	public void setmReportFormVO(ReportFormVO mReportFormVO) {
		this.mReportFormVO = mReportFormVO;
	}

	public ReportFormVO[] getmReportFormVOs() {
		ReportFormVO[] rtnVOs = null;
		if (this.mReportFormVOs != null) {
			rtnVOs = new ReportFormVO[mReportFormVOs.length];
			System.arraycopy(mReportFormVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setmReportFormVOs(ReportFormVO[] mReportFormVOs) {
		if (mReportFormVOs != null) {
			ReportFormVO[] tmpVOs = new ReportFormVO[mReportFormVOs.length];
			System.arraycopy(mReportFormVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mReportFormVOs = tmpVOs;
		}
	}

	/** Constructor */
	public EsmSpc0118Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmSpc0118Event";
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
	public void setBsaJntOpCrrCapaVO(BsaJntOpCrrCapaVO bsaJntOpCrrCapaVO){
		this.mBsaJntOpCrrCapaVO = bsaJntOpCrrCapaVO;
	}
	/** ValueObject Getter */
	public BsaJntOpCrrCapaVO getBsaJntOpCrrCapaVO(){
		return mBsaJntOpCrrCapaVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setBsaJntOpCrrCapaVOs(BsaJntOpCrrCapaVO[] bsaJntOpCrrCapaVOs){
		if (mBsaJntOpCrrCapaVOs != null) {
			BsaJntOpCrrCapaVO[] tmpVOs = new BsaJntOpCrrCapaVO[mBsaJntOpCrrCapaVOs.length];
			System.arraycopy(mBsaJntOpCrrCapaVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mBsaJntOpCrrCapaVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public BsaJntOpCrrCapaVO[] getBsaJntOpCrrCapaVOs(){
		BsaJntOpCrrCapaVO[] rtnVOs = null;
		if (this.mBsaJntOpCrrCapaVOs != null) {
			rtnVOs = new BsaJntOpCrrCapaVO[mBsaJntOpCrrCapaVOs.length];
			System.arraycopy(mBsaJntOpCrrCapaVOs, 0, rtnVOs, 0, rtnVOs.length);
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
