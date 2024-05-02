/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtcommonfinderEvent.java
*@FileTitle : DMTCommonFinder
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.event;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.AttentionVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.BookingNoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.ContainerCargoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CountryCdVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CurrencyVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CustomerVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.DayVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.LocationCdVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.PayerNameParamVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.PayerNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.RhqOfcCodeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.SheetOptionByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.SheetSetVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.TariffNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * DMTCommonFinder 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  DMTCommonFinderHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SungHoon, Lee
 * @see DMT_COM_HTMLAction 참조
 * @since J2EE 1.4
 */

public class DmtComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoverageVO 			coverageVO 			= null;
	
	/** Table Value Object Multi Data 처리 */
	private CoverageVO[] 		coverageVOS 		= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TariffNameVO 		tariffNameVO 		= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OfficeNameVO 		officeNameVO 		= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BookingNoVO 		bookingNoVO 		= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CurrencyVO 			currencyVO 			= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ContainerCargoVO 	containerCargoVO 	= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private CommonCodeVO 		commonCodeVO 		= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private LocationCdVO 		locationCdVO 		= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private CountryCdVO 		countryCdVO 		= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private CustomerVO 			customerVO 			= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private PayerNameVO 		payerNameVO 		= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private PayerNameParamVO 	payerNameParamVO 	= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private AttentionVO 		attentionVO 		= null;
		
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private VendorNameVO 		vendorNameVO 		= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UserRoleVO 			userRoleVO 			= null;
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SheetSetVO 			sheetSetVO 			= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DayVO 				dayVO 				= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RhqOfcCodeVO 		rhqOfcCodeVO		= null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SheetOptionByOfficeVO 			sheetOptionByOfficeVO 			= null;
	
	
	public DmtComEvent(){}
	
	public void setCoverageVO(CoverageVO coverageVO){
		this. coverageVO = coverageVO;
	}

	public void setCoverageVOS(CoverageVO[] coverageVOS){
		if (coverageVOS != null) {
			CoverageVO[] tmpVOs = new CoverageVO[coverageVOS.length];
			System.arraycopy(coverageVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.coverageVOS = tmpVOs;
		}
	}

	public void setTariffNameVOS(TariffNameVO tariffNameVO){
		this. tariffNameVO = tariffNameVO;
	}
	
	public void setOfficeNameVO(OfficeNameVO officeNameVO){
		this.officeNameVO = officeNameVO;
	}
	
	public void setBookingNoVO(BookingNoVO bookingNoVO){
		this. bookingNoVO = bookingNoVO;
	}
	
	public void setCurrencyVO(CurrencyVO currencyVO){
		this. currencyVO = currencyVO;
	}
	
	public void setContainerCargoVO(ContainerCargoVO containerCargoVO) {
		this.containerCargoVO = containerCargoVO;
	}
	
	public void setCommonCodeVO(CommonCodeVO commonCodeVO){
		this. commonCodeVO = commonCodeVO;
	}
	
	public void setLocationCdVO(LocationCdVO locationCdVO) {
		this. locationCdVO = locationCdVO;
	}

	public void setCustomerVO(CustomerVO customerVO) {
		this. customerVO = customerVO;
	}
	
	public void setPayerNameVO(PayerNameVO payerNameVO) {
		this. payerNameVO = payerNameVO;
	}
	
	public void setPayerNameParamVO(PayerNameParamVO payerNameParamVO) {
		this.payerNameParamVO = payerNameParamVO;
	}
	
	public void setAttentionVO(AttentionVO attentionVO) {
		this.attentionVO = attentionVO;
	}
	
	public void setVendorNameVO(VendorNameVO vendorNameVO) {
		this.vendorNameVO = vendorNameVO;
	}
	
	/**
	 * @param countryCdVO the countryCdVO to set
	 */
	public void setCountryCdVO(CountryCdVO countryCdVO) {
		this.countryCdVO = countryCdVO;
	}
	
	public void setUserRoleVO(UserRoleVO userRoleVO) {
		this.userRoleVO = userRoleVO;
	}
	
	public void setSheetSetVO(SheetSetVO sheetSetVO) {
		this.sheetSetVO = sheetSetVO;
	}
	
	public void setSheetOptionByOfficeVO(SheetOptionByOfficeVO sheetOptionByOfficeVO) {
		this.sheetOptionByOfficeVO = sheetOptionByOfficeVO;
	}
	
	public void setDayVO(DayVO dayVO) {
		this.dayVO = dayVO;
	}
	
	public void setRhqOfcCodeVO(RhqOfcCodeVO rhqOfcCodeVO) {
		this.rhqOfcCodeVO = rhqOfcCodeVO;
	}
	
	public CoverageVO getCoverageVO(){
		return coverageVO;
	}

	public CoverageVO[] getCoverageVOS(){
		CoverageVO[] tmpVOs = null;
		if (this.coverageVOS != null) {
			tmpVOs = new CoverageVO[coverageVOS.length];
			System.arraycopy(coverageVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public TariffNameVO getTariffNameVO(){
		return tariffNameVO;
	}
	
	public OfficeNameVO getOfficeNameVO(){
		return officeNameVO;
	}
	
	public BookingNoVO getBookingNoVO(){
		return bookingNoVO;
	}

	public CurrencyVO getCurrencyVO(){
		return currencyVO;
	}

	public ContainerCargoVO getContainerCargoVO() {
		return containerCargoVO;
	}

	public CommonCodeVO getCommonCodeVO(){
		return commonCodeVO;
	}

	public LocationCdVO getLocationCdVO() {
		return locationCdVO ;
	}
	
	public CustomerVO getCustomerVO() {
		return customerVO;
	}	
	
	public PayerNameVO getPayerNameVO() {
		return payerNameVO;
	}
	
	public PayerNameParamVO getPayerNameParamVO() {
		return payerNameParamVO;
	}
	
	public AttentionVO getAttentionVO() {
		return attentionVO;
	}
	
	public VendorNameVO getVendorNameVO() {
		return vendorNameVO;
	}

	/**
	 * @return the countryCdVO
	 */
	public CountryCdVO getCountryCdVO() {
		return countryCdVO;
	}
	
	public UserRoleVO getUserRoleVO() {
		return userRoleVO;
	}
	
	public SheetSetVO getSheetSetVO() {
		return sheetSetVO;
	}
	
	public SheetOptionByOfficeVO getSheetOptionByOfficeVO() {
		return sheetOptionByOfficeVO;
	}
	
	public DayVO getDayVO() {
		return dayVO;
	}
	
	public RhqOfcCodeVO getRhqOfcCodeVO() {
		return rhqOfcCodeVO;
	}
}