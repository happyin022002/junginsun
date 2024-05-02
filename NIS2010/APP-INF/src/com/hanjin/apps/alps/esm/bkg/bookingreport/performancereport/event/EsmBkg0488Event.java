/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0488Event.java
*@FileTitle : bookringreport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.10 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgSrFaxVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlAtchFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlReceivingListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSRReceivingListVO;


/**
 * ESM_BKG_0488 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0488HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0488HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0488Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSRReceivingListVO searchSRReceivingListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSRReceivingListVO[] searchSRReceivingListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSREmlReceivingListVO searchSREmlReceivingListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSREmlReceivingListVO[] searchSREmlReceivingListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSREmlCtntVO searchSREmlCtntVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSREmlCtntVO[] searchSREmlCtntVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSREmlAtchFileListVO searchSREmlAtchFileListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSREmlAtchFileListVO[] searchSREmlAtchFileListVOs = null;
	
	
	
	private BkgSrFaxVO[] bkgSrFaxVOs = null;
	
	private String srMtchStsCd 	= null;
	private String fromDt		= null;
	private String toDt			= null;
	private String srNo 		= null;	
	private String srKndCd 		= null;	
	private String rcvRmk		= null;
	private String rcvOfcCd		= null;

	public EsmBkg0488Event(){}
	
	public void setSearchSRReceivingListVO(SearchSRReceivingListVO searchSRReceivingListVO){
		this. searchSRReceivingListVO = searchSRReceivingListVO;
	}

	public void setSearchSRReceivingListVOS(SearchSRReceivingListVO[] searchSRReceivingListVOs){
		if(searchSRReceivingListVOs != null){
			SearchSRReceivingListVO[] tmpVOs = Arrays.copyOf(searchSRReceivingListVOs, searchSRReceivingListVOs.length);
			this.searchSRReceivingListVOs = tmpVOs;
		}
	}
	
	public void setSearchSRReceivingListVOS2(SearchSRReceivingListVO[] searchSRReceivingListVOs){
		if(searchSRReceivingListVOs != null){
			SearchSRReceivingListVO[] tmpVOs = Arrays.copyOf(searchSRReceivingListVOs, searchSRReceivingListVOs.length);
			this.searchSRReceivingListVOs = tmpVOs;
		}
	}
	
	public void setBkgSrFaxVOS(BkgSrFaxVO[] bkgSrFaxVOs){
		if(bkgSrFaxVOs != null){
			BkgSrFaxVO[] tmpVOs = Arrays.copyOf(bkgSrFaxVOs, bkgSrFaxVOs.length);
			this.bkgSrFaxVOs = tmpVOs;
		}
	}

	public void setSrMtchStsCd(String srMtchStsCd){
		this.srMtchStsCd = srMtchStsCd;
	}
	
	public void setFromDt(String fromDt){
		this.fromDt = fromDt;
	}
	
	public void setToDt(String toDt){
		this.toDt = toDt;
	}
	
	public void setSrNo(String srNo){
		this.srNo = srNo;
	}
	
	public void setSrKndCd(String srKndCd){
		this.srKndCd = srKndCd;
	}
	
	public void setRcvRmk(String rcvRmk){
		this.rcvRmk = rcvRmk;
	}
	
	public void setRcvOfcCd(String rcvOfcCd){
		this.rcvOfcCd = rcvOfcCd;
	}

	public SearchSRReceivingListVO getSearchSRReceivingListVO(){
		return searchSRReceivingListVO;
	}

	public SearchSRReceivingListVO[] getSearchSRReceivingListVOS(){
		SearchSRReceivingListVO[] rtnVOs = null;
		if (this.searchSRReceivingListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSRReceivingListVOs, searchSRReceivingListVOs.length);
		}
		return rtnVOs;
	}
	
	public BkgSrFaxVO[] getBkgSrFaxVOS(){
		BkgSrFaxVO[] rtnVOs = null;
		if (this.bkgSrFaxVOs != null) {
			rtnVOs = Arrays.copyOf(bkgSrFaxVOs, bkgSrFaxVOs.length);
		}
		return rtnVOs;
	}
	
	public String getSrMtchStsCd(){
		return srMtchStsCd;
	}
	
	public String getFromDt(){
		return fromDt;
	}
	
	public String getToDt(){
		return toDt;
	}
	
	public String getSrNo(){
		return srNo;
	}
	
	public String getSrKndCd(){
		return srKndCd;
	}
	
	public String getRcvRmk(){
		return rcvRmk;
	}
	
	public String getRcvOfcCd(){
		return rcvOfcCd;
	}

	public SearchSREmlReceivingListVO getSearchSREmlReceivingListVO() {
		return searchSREmlReceivingListVO;
	}

	public void setSearchSREmlReceivingListVO(
			SearchSREmlReceivingListVO searchSREmlReceivingListVO) {
		this.searchSREmlReceivingListVO = searchSREmlReceivingListVO;
	}

	public SearchSREmlReceivingListVO[] getSearchSREmlReceivingListVOs() {
		SearchSREmlReceivingListVO[] rtnVOs = null;
		if (this.searchSREmlReceivingListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSREmlReceivingListVOs, searchSREmlReceivingListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchSREmlReceivingListVOs(SearchSREmlReceivingListVO[] searchSREmlReceivingListVOs){
		if(searchSREmlReceivingListVOs != null){
			SearchSREmlReceivingListVO[] tmpVOs = Arrays.copyOf(searchSREmlReceivingListVOs, searchSREmlReceivingListVOs.length);
			this.searchSREmlReceivingListVOs = tmpVOs;
		}
	}

	public SearchSREmlCtntVO getSearchSREmlCtntVO() {
		return searchSREmlCtntVO;
	}

	public void setSearchSREmlCtntVO(SearchSREmlCtntVO searchSREmlCtntVO) {
		this.searchSREmlCtntVO = searchSREmlCtntVO;
	}

	public SearchSREmlCtntVO[] getSearchSREmlCtntVOs() {
		SearchSREmlCtntVO[] rtnVOs = null;
		if (this.searchSREmlCtntVOs != null) {
			rtnVOs = Arrays.copyOf(searchSREmlCtntVOs, searchSREmlCtntVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchSREmlCtntVOs(SearchSREmlCtntVO[] searchSREmlCtntVOs){
		if(searchSREmlCtntVOs != null){
			SearchSREmlCtntVO[] tmpVOs = Arrays.copyOf(searchSREmlCtntVOs, searchSREmlCtntVOs.length);
			this.searchSREmlCtntVOs = tmpVOs;
		}
	}

	public SearchSREmlAtchFileListVO getSearchSREmlAtchFileListVO() {
		return searchSREmlAtchFileListVO;
	}

	public void setSearchSREmlAtchFileListVO(
			SearchSREmlAtchFileListVO searchSREmlAtchFileListVO) {
		this.searchSREmlAtchFileListVO = searchSREmlAtchFileListVO;
	}

	public SearchSREmlAtchFileListVO[] getSearchSREmlAtchFileListVOs() {
		SearchSREmlAtchFileListVO[] rtnVOs = null;
		if (this.searchSREmlAtchFileListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSREmlAtchFileListVOs, searchSREmlAtchFileListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchSREmlAtchFileListVOs(SearchSREmlAtchFileListVO[] searchSREmlAtchFileListVOs){
		if(searchSREmlAtchFileListVOs != null){
			SearchSREmlAtchFileListVO[] tmpVOs = Arrays.copyOf(searchSREmlAtchFileListVOs, searchSREmlAtchFileListVOs.length);
			this.searchSREmlAtchFileListVOs = tmpVOs;
		}
	}
	
}