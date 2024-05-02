/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvcommonEvent.java
*@FileTitle : INVCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.24 김세일
* 1.0 Creation
 * 2010.11.22 이석준 CHM-201006884
 *            code description 가져오는 function 추가(codeInputVO) 추가
=========================================================*/
package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.event;

import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.CodeInputVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.CommonVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.SearchServiceScopeListVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;


/**
 * INVCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  INVCommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see INVCommonHTMLAction 참조
 * @since J2EE 1.4
 */
 
public class InvCommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CommonVO commonVO = null;
	
	private MdmSvcScpVO mdmSvcScpVO = null;
	
	private SearchServiceScopeListVO searchServiceScopeListVO = null;
	
	private CodeInputVO codeInputVO = null;
	
	private String svcScpCd = null;
	
	private String pageType = null;	
	
	private String cntryCd = null;	
	
	private String custCd = null;	
	
	private String fromCurrCd	= null;
	
	private String toCurrCd	= null;
	
	private String effDt	= null; 
	
	private String vvd	= null; 
	
	private String port = null;
	
	private String bnd	= null;
	
	private String bkgNo = null;
	
	private String sailDt = null;
	
	private String ofcCd = null;
	
	private String lane = null;
	
	private String arOfcCd = null;
	
	private String custRgstNo = null;	
	
	private String chgCd = null;
	
	private VVDCustomerVO vvdCustomerVo = null;
	
	/** Table Value Object Multi Data 처리 */
	private CommonVO[] commonVOs = null;
	
	private MdmSvcScpVO[] mdmSvcScpVOs = null;
	
	private SearchServiceScopeListVO[] searchServiceScopeListVOs = null;

	private String[] svcScpCds = null;
	
	public InvCommonEvent(){}
	
	public void setCommonVO(CommonVO commonVO){
		this. commonVO = commonVO;
	}

	public void setCommonVOS(CommonVO[] commonVOs){
		this. commonVOs = commonVOs;
	}

	public CommonVO getCommonVO(){
		return commonVO;
	}

	public CommonVO[] getCommonVOS(){
		return commonVOs;
	}	
	
	public MdmSvcScpVO getMdmSvcScpVO() {
		return mdmSvcScpVO;
	}

	public void setMdmSvcScpVO(MdmSvcScpVO mdmSvcScpVO) {
		this.mdmSvcScpVO = mdmSvcScpVO;
	}

	/**
	 * @return the mdmSvcScpVOs
	 */
	public MdmSvcScpVO[] getMdmSvcScpVOs() {
		return mdmSvcScpVOs;
	}

	/**
	 * @param mdmSvcScpVOs the mdmSvcScpVOs to set
	 */
	public void setMdmSvcScpVOs(MdmSvcScpVO[] mdmSvcScpVOs) {
		this.mdmSvcScpVOs = mdmSvcScpVOs;
	}

	/**
	 * @return the searchServiceScopeListVO
	 */
	public SearchServiceScopeListVO getSearchServiceScopeListVO() {
		return searchServiceScopeListVO;
	}

	/**
	 * @param searchServiceScopeListVO the searchServiceScopeListVO to set
	 */
	public void setSearchServiceScopeListVO(
			SearchServiceScopeListVO searchServiceScopeListVO) {
		this.searchServiceScopeListVO = searchServiceScopeListVO;
	}

	/**
	 * @return the searchServiceScopeListVOs
	 */
	public SearchServiceScopeListVO[] getSearchServiceScopeListVOs() {
		return searchServiceScopeListVOs;
	}

	/**
	 * @param searchServiceScopeListVOs the searchServiceScopeListVOs to set
	 */
	public void setSearchServiceScopeListVOs(
			SearchServiceScopeListVO[] searchServiceScopeListVOs) {
		this.searchServiceScopeListVOs = searchServiceScopeListVOs;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}
	
	/**
	 * @return the arOfcCd
	 */
	public String getArOfcCd() {
		return arOfcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * @param arOfcCd the arOfcCd to set
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * @return the sailDt
	 */
	public String getSailDt() {
		return sailDt;
	}

	/**
	 * @param sailDt the sailDt to set
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
	}

	public String getSvcScpCd() {
		return svcScpCd;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	public String[] getSvcScpCds() {
		return svcScpCds;
	}

	public void setSvcScpCds(String[] svcScpCds) {
		this.svcScpCds = svcScpCds;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}    

	public String getCntryCd() {
		return cntryCd;
	}

	public void setCntryCd(String cntryCd) {
		this.cntryCd = cntryCd;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	public String getEffDt() {
		return effDt;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}


	/**
	 * @return the fromCurrCd
	 */
	public String getFromCurrCd() {
		return fromCurrCd;
	}

	/**
	 * @param fromCurrCd the fromCurrCd to set
	 */
	public void setFromCurrCd(String fromCurrCd) {
		this.fromCurrCd = fromCurrCd;
	}

	/**
	 * @return the toCurrCd
	 */
	public String getToCurrCd() {
		return toCurrCd;
	}

	/**
	 * @param toCurrCd the toCurrCd to set
	 */
	public void setToCurrCd(String toCurrCd) {
		this.toCurrCd = toCurrCd;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public VVDCustomerVO getVvdCustomerVo() {
		return vvdCustomerVo;
	}

	public void setVvdCustomerVo(VVDCustomerVO vvdCustomerVo) {
		this.vvdCustomerVo = vvdCustomerVo;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the bnd
	 */
	public String getBnd() {
		return bnd;
	}

	/**
	 * @param bnd the bnd to set
	 */
	public void setBnd(String bnd) {
		this.bnd = bnd;
	}

	/**
	 * @return the lane
	 */
	public String getLane() {
		return lane;
	}

	/**
	 * @param lane the lane to set
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}

	/**
	 * @return the custRgstNo
	 */
	public String getCustRgstNo() {
		return custRgstNo;
	}

	/**
	 * @param custRgstNo the custRgstNo to set
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}

	public CodeInputVO getCodeInputVO() {
		return codeInputVO;
	}

	public void setCodeInputVO(CodeInputVO codeInputVO) {
		this.codeInputVO = codeInputVO;
	}
	
	/**
	 * @return the chgCd
	 */
	public String getChgCd() {
		return chgCd;
	}
	
	/**
	 * @param lane the lane to set
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	
		
}