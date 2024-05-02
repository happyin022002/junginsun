/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0271Event.java
*@FileTitle : On-site Inspection Result Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.07.21 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSite2VO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSiteVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_MNR_0271 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0271HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE YULKYU
 * @see EES_MNR_0271HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0271Event extends EventSupport {

	private static final long serialVersionUID = 1L;	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MnrOnSiteVO mnrOnSiteVO = null;
	private MnrOnSite2VO mnrOnSite2VO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MnrOnSiteVO[] mnrOnSiteVOs = null;
	public MnrOnSite2VO[] mnrOnSite2VOs = null;
	
	public EesMnr0271Event(){}

	public MnrOnSiteVO getMnrOnSiteVO() {
		return mnrOnSiteVO;
	}

	public MnrOnSite2VO getMnrOnSite2VO() {
		return mnrOnSite2VO;
	}

	public void setMnrOnSite2VO(MnrOnSite2VO mnrOnSite2VO) {
		this.mnrOnSite2VO = mnrOnSite2VO;
	}

	public MnrOnSite2VO[] getMnrOnSite2VOs() {
		return mnrOnSite2VOs;
	}

	public void setMnrOnSite2VOs(MnrOnSite2VO[] mnrOnSite2VOs) {
		this.mnrOnSite2VOs = mnrOnSite2VOs;
	}

	public void setMnrOnSiteVO(MnrOnSiteVO mnrOnSiteVO) {
		this.mnrOnSiteVO = mnrOnSiteVO;
	}

	public MnrOnSiteVO[] getMnrOnSiteVOs() {
		return mnrOnSiteVOs;
	}

	public void setMnrOnSiteVOs(MnrOnSiteVO[] mnrOnSiteVOs) {
		this.mnrOnSiteVOs = mnrOnSiteVOs;
	}

}