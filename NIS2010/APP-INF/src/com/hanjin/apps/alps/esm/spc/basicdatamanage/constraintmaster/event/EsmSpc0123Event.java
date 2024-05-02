/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0123HTMLAction.java
*@FileTitle : Standby BKG Report
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2009.07.24 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BkgListForCompFirmBySPCVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.event.ESM_SPC_0004HTMLAction;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.vo.SearchInitialSpaceAllocationRatioListVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcInitAlocRtoVO;
import com.hanjin.syscommon.common.table.SpcSbBkgVO;

/**
 * ESM_SPC_0123 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0123HTMLAction에서 작성.<br>
 * -  ServiceCommand Layer로 전달하는 PDTO로 사용.<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0004HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmSpc0123Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInitialSpaceAllocationRatioListVO searchInitialSpaceAllocationRatioListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInitialSpaceAllocationRatioListVO[] searchInitialSpaceAllocationRatioListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcInitAlocRtoVO spcInitAlocRtoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcInitAlocRtoVO[] spcInitAlocRtoVOs = null;

	/* GeneralBookingListSearch 에서 가져온것 2015.02.11 김성욱 시작*/

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgListForCompFirmInputVO bkgListForCompFirmInputVO = null;
	private BkgListForCompFirmVO bkgListForCompFirmVO = null;
	
	private BkgListForCompFirmBySPCVO bkgListForCompFirmBySPCVO = null;
	
	
	private String custCntCd = null;
	private String custSeq = null;

	/** Table Value Object Multi Data 처리 */
	private BkgListForCompFirmVO[] bkgListForCompFirmVOs = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;
	private BkgBlNoVO bkgBlNoVO = null;
	private AllocStsVO allocStsVO = null;

	private SpcSbBkgVO spcSbBkgVO = null;
	private SpcSbBkgVO[] spcSbBkgVOs = null;
	
	private SearchOfficeCondVO searchOfficeCondVO = null;
	private SearchConditionVO searchConditionVO = null;
	
	/* GeneralBookingListSearch 에서 가져온것 2015.02.11 김성욱 끝*/
	
	public EsmSpc0123Event(){}
	
	public void setSearchInitialSpaceAllocationRatioListVO(SearchInitialSpaceAllocationRatioListVO searchInitialSpaceAllocationRatioListVO){
		this. searchInitialSpaceAllocationRatioListVO = searchInitialSpaceAllocationRatioListVO;
	}

	public void setSearchInitialSpaceAllocationRatioListVOS(SearchInitialSpaceAllocationRatioListVO[] searchInitialSpaceAllocationRatioListVOs){
		if (searchInitialSpaceAllocationRatioListVOs != null) {
			SearchInitialSpaceAllocationRatioListVO[] tmpVOs = new SearchInitialSpaceAllocationRatioListVO[searchInitialSpaceAllocationRatioListVOs.length];
			System.arraycopy(searchInitialSpaceAllocationRatioListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchInitialSpaceAllocationRatioListVOs = tmpVOs;
		}
	}

	public void setSpcInitAlocRtoVO(SpcInitAlocRtoVO spcInitAlocRtoVO){
		this. spcInitAlocRtoVO = spcInitAlocRtoVO;
	}

	public void setSpcInitAlocRtoVOS(SpcInitAlocRtoVO[] spcInitAlocRtoVOs){
		if (spcInitAlocRtoVOs != null) {
			SpcInitAlocRtoVO[] tmpVOs = new SpcInitAlocRtoVO[spcInitAlocRtoVOs.length];
			System.arraycopy(spcInitAlocRtoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcInitAlocRtoVOs = tmpVOs;
		}
	}

	public SearchInitialSpaceAllocationRatioListVO getSearchInitialSpaceAllocationRatioListVO(){
		return searchInitialSpaceAllocationRatioListVO;
	}

	public SearchInitialSpaceAllocationRatioListVO[] getSearchInitialSpaceAllocationRatioListVOS(){
		SearchInitialSpaceAllocationRatioListVO[] rtnVOs = null;
		if( this.searchInitialSpaceAllocationRatioListVOs != null ){
			rtnVOs = new SearchInitialSpaceAllocationRatioListVO[searchInitialSpaceAllocationRatioListVOs.length];
			System.arraycopy(searchInitialSpaceAllocationRatioListVOs, 0, rtnVOs, 0, rtnVOs.length );
		}
		return rtnVOs;
	}

	public SpcInitAlocRtoVO getSpcInitAlocRtoVO(){
		return spcInitAlocRtoVO;
	}

	public SpcInitAlocRtoVO[] getSpcInitAlocRtoVOS(){
		SpcInitAlocRtoVO[] rtnVOs = null;
		if( this.spcInitAlocRtoVOs != null ){
			rtnVOs = new SpcInitAlocRtoVO[spcInitAlocRtoVOs.length];
			System.arraycopy(spcInitAlocRtoVOs, 0, rtnVOs, 0, rtnVOs.length );
		}
		return rtnVOs;
//		return spcInitAlocRtoVOs;
	}

	/* GeneralBookingListSearch 에서 가져온것 2015.02.11 김성욱 시작*/

	public void setBkgListForCompFirmInputVO(BkgListForCompFirmInputVO bkgListForCompFirmInputVO){
		this. bkgListForCompFirmInputVO = bkgListForCompFirmInputVO;
	}

	public BkgListForCompFirmInputVO getBkgListForCompFirmInputVO(){
		return bkgListForCompFirmInputVO;
	}

	public void setBkgListForCompFirmBySPCVO(BkgListForCompFirmBySPCVO bkgListForCompFirmBySPCVO){
		this. bkgListForCompFirmBySPCVO = bkgListForCompFirmBySPCVO;
	}
		
	public BkgListForCompFirmBySPCVO getBkgListForCompFirmBySPCVO(){
		return bkgListForCompFirmBySPCVO;
	}

	public void setBkgListForCompFirmVO(BkgListForCompFirmVO bkgListForCompFirmVO){
		this. bkgListForCompFirmVO = bkgListForCompFirmVO;
	}

	public void setBkgListForCompFirmVOs(BkgListForCompFirmVO[] bkgListForCompFirmVOs){
		if (bkgListForCompFirmVOs != null) {
			BkgListForCompFirmVO[] tmpVOs = new BkgListForCompFirmVO[bkgListForCompFirmVOs.length];
			System.arraycopy(bkgListForCompFirmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgListForCompFirmVOs = tmpVOs;
		}
	}

	public BkgListForCompFirmVO getBkgListForCompFirmVO(){
		return bkgListForCompFirmVO;
	}

	public BkgListForCompFirmVO[] getBkgListForCompFirmVOs(){
		BkgListForCompFirmVO[] rtnVOs = null;
		if( this.bkgListForCompFirmVOs != null ){
			rtnVOs = new BkgListForCompFirmVO[bkgListForCompFirmVOs.length];
			System.arraycopy(bkgListForCompFirmVOs, 0, rtnVOs, 0, rtnVOs.length );
		}
		return rtnVOs;
//		return bkgListForCompFirmVOs;
	}

	public void setCustCntCd(String custCntCd){
		this.custCntCd = custCntCd;
	}

	public String getCustCntCd(){
		return custCntCd;
	}

	public void setCustSeq(String custSeq){
		this.custSeq = custSeq;
	}

	public String getCustSeq(){
		return custSeq;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs){
		if (bkgBlNoVOs != null) {
			BkgBlNoVO[] tmpVOs = new BkgBlNoVO[bkgBlNoVOs.length];
			System.arraycopy(bkgBlNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgBlNoVOs = tmpVOs;
		}
	}

	public BkgBlNoVO[] getBkgBlNoVOs(){
		BkgBlNoVO[] rtnVOs = null;
		if( this.bkgBlNoVOs != null ){
			rtnVOs = new BkgBlNoVO[bkgBlNoVOs.length];
			System.arraycopy(bkgBlNoVOs, 0, rtnVOs, 0, rtnVOs.length );
		}
		return rtnVOs;
//		return bkgBlNoVOs;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public AllocStsVO getAllocStsVO() {
		return allocStsVO;
	}

	public void setAllocStsVO(AllocStsVO allocStsVO) {
		this.allocStsVO = allocStsVO;
	}
	
	//0116 Compulsory FIrm B.Check Save 용
	public void setCompFirmBySPCVO(SpcSbBkgVO spcSbBkgVO){
		this. spcSbBkgVO = spcSbBkgVO;
	}
	
	public SpcSbBkgVO getCompFirmBySPCVO() {
		return this. spcSbBkgVO;
	}

	public void setCompFirmBySPCVOs(SpcSbBkgVO[] spcSbBkgVOs){
		if (spcSbBkgVOs != null) {
			SpcSbBkgVO[] tmpVOs = new SpcSbBkgVO[spcSbBkgVOs.length];
			System.arraycopy(spcSbBkgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcSbBkgVOs = tmpVOs;
		}
	}
	
	public SpcSbBkgVO[] getCompFirmBySPCVOs() {
		SpcSbBkgVO[] rtnVOs = null;
		if (this.spcSbBkgVOs != null) {
			rtnVOs = new SpcSbBkgVO[spcSbBkgVOs.length];
			System.arraycopy(spcSbBkgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;	

	}
	
	public SearchOfficeCondVO getSearchOfficeCondVO(){
		return this.searchOfficeCondVO;
	}
	
	public void setSearchOfficeCondVO(SearchOfficeCondVO searchOfficeCondVO) {
		this.searchOfficeCondVO = searchOfficeCondVO;
	}

	
	
	/**
	 * 
	 * @return
	 */
	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	/**
	 * 
	 * @param searchConditionVO
	 */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}
	
	
	/* GeneralBookingListSearch 에서 가져온것 2015.02.11 김성욱 끝*/
}