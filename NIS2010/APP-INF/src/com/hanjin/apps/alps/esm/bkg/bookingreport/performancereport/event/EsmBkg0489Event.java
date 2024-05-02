/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0489Event.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.15 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueBkgHistListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsAmendReasonBkgListVO;

/**
 * ESM_BKG_0489 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0489HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0489HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0489Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DpcsAmendReasonBkgListVO dpcsAmendReasonBkgListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DpcsAmendReasonBkgListVO[] dpcsAmendReasonBkgListVOs = null;
	
	private DocQueueBkgHistListVO docQueueBkgHistListVO = null;
	
	private DocQueueBkgHistListVO[] docQueueBkgHistListVOs = null;
	
	private String bkgNo = null;
	
	private String faxLogRefNo  = null;
	
	private String srNo  = null;
	
	private String bkgSrKndCd = null;
	
	private String rcvDt = null;
	
	private String downloadLocation = null;

	public String getDownloadLocation() {
		return downloadLocation;
	}

	public void setDownloadLocation(String downloadLocation) {
		this.downloadLocation = downloadLocation;
	}

	public EsmBkg0489Event(){}
	
	public void setDpcsAmendReasonBkgListVO(DpcsAmendReasonBkgListVO dpcsAmendReasonBkgListVO){
		this. dpcsAmendReasonBkgListVO = dpcsAmendReasonBkgListVO;
	}

	public void setDpcsAmendReasonBkgListVOS(DpcsAmendReasonBkgListVO[] dpcsAmendReasonBkgListVOs){
		if(dpcsAmendReasonBkgListVOs != null){
			DpcsAmendReasonBkgListVO[] tmpVOs = Arrays.copyOf(dpcsAmendReasonBkgListVOs, dpcsAmendReasonBkgListVOs.length);
			this.dpcsAmendReasonBkgListVOs = tmpVOs;
		}
	}
	
	public void setDocQueueBkgHistListVO(DocQueueBkgHistListVO docQueueBkgHistListVO){
		this. docQueueBkgHistListVO = docQueueBkgHistListVO;
	}

	public void setDocQueueBkgHistListVOS(DocQueueBkgHistListVO[] docQueueBkgHistListVOs){
		if(docQueueBkgHistListVOs != null){
			DocQueueBkgHistListVO[] tmpVOs = Arrays.copyOf(docQueueBkgHistListVOs, docQueueBkgHistListVOs.length);
			this.docQueueBkgHistListVOs = tmpVOs;
		}
	}
	
	public void setBkgNo(String bkgNo){
		this.bkgNo = bkgNo;		
	}
	
	public void setSrNo(String srNo){
		this.srNo = srNo;
	}
	
	public void setBkgSrKndCd(String bkgSrKndCd){
		this.bkgSrKndCd = bkgSrKndCd;
	}
	
	public void setRcvDt(String rcvDt){
		this.rcvDt = rcvDt;
	}
	
	public DpcsAmendReasonBkgListVO getDpcsAmendReasonBkgListVO(){
		return dpcsAmendReasonBkgListVO;
	}

	public DpcsAmendReasonBkgListVO[] getDpcsAmendReasonBkgListVOS(){
		DpcsAmendReasonBkgListVO[] rtnVOs = null;
		if (this.dpcsAmendReasonBkgListVOs != null) {
			rtnVOs = Arrays.copyOf(dpcsAmendReasonBkgListVOs, dpcsAmendReasonBkgListVOs.length);
		}
		return rtnVOs;
	}
	
	public DocQueueBkgHistListVO getDocQueueBkgHistListVO(){
		return docQueueBkgHistListVO;
	}

	public DocQueueBkgHistListVO[] getDocQueueBkgHistListVOS(){
		DocQueueBkgHistListVO[] rtnVOs = null;
		if (this.docQueueBkgHistListVOs != null) {
			rtnVOs = Arrays.copyOf(docQueueBkgHistListVOs, docQueueBkgHistListVOs.length);
		}
		return rtnVOs;
	}
	
	public String getBkgNo(){
		return bkgNo;
	}
	
	public String getSrNo(){
		return srNo;
	}
	
	public String getBkgSrKndCd(){
		return bkgSrKndCd;
	}
	
	public String getRcvDt(){
		return rcvDt;
	}

	public String getFaxLogRefNo() {
		return faxLogRefNo;
	}

	public void setFaxLogRefNo(String faxLogRefNo) {
		this.faxLogRefNo = faxLogRefNo;
	}
	
}