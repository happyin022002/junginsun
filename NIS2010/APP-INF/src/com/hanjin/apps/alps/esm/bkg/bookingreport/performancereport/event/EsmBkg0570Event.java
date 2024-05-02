/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0570Event.java
*@FileTitle : C/A B/L Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.28 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaInquiryReportVO;


/**
 * ESM_BKG_0570 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0570HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0570HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0570Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CaInquiryReportVO caInquiryReportVo = null;
	
	/** Table Value Object Multi Data 처리 */
	private CaInquiryReportVO[] caInquiryReportVos = null;
	
	private String blNo = null;
	
	private String corrNo = null;

	public EsmBkg0570Event(){}
	
	public void setCaInquiryReportVo(CaInquiryReportVO caInquiryReportVo){
		this. caInquiryReportVo = caInquiryReportVo;
	}

	public void setCaInquiryReportVoS(CaInquiryReportVO[] caInquiryReportVos){
		this. caInquiryReportVos = caInquiryReportVos;
	}
	
	public void setBlNo(String blNo){
		this.blNo = blNo;
	}
	
	public void setCorrNo(String corrNo){
		
		this.corrNo = corrNo;
	}
	
	public CaInquiryReportVO getCaInquiryReportVo(){
		return caInquiryReportVo;
	}

	public CaInquiryReportVO[] getCaInquiryReportVoS(){
		return caInquiryReportVos;
	}
	
	public String getBlNo(){
		return blNo;
	}
	
	public String getCorrNo(){
		return corrNo;
	}

}