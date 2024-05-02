/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0649Event.java
*@FileTitle : Cancel Issue Release
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.20 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0649 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0649HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0649HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0059Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkg0059Event(){}
	
	private String bkgNo = null;
	private String blNo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocRqstVO docRqstVO = null;
	/** Table Value Object Multi Data 처리 */
	private DocRqstVO[] docRqstVOs = null;


	
	
	/**
	 * @return the bkg_no
	 */
	public String getBkg_no() {
		return bkgNo;
	}
	/**
	 * @param bkg_no the bkg_no to set
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}
	/**
	 * @return the bl_no
	 */
	public String getBl_no() {
		return blNo;
	}
	/**
	 * @param bl_no the bl_no to set
	 */
	public void setBl_no(String bl_no) {
		this.blNo = bl_no;
	}
	/**
	 * @return the docRqstVO
	 */
	public DocRqstVO getDocRqstVO() {
		return docRqstVO;
	}
	/**
	 * @param docRqstVO the docRqstVO to set
	 */
	public void setDocRqstVO(DocRqstVO docRqstVO) {
		this.docRqstVO = docRqstVO;
	}
	/**
	 * @return the docRqstVOs
	 */
	public DocRqstVO[] getDocRqstVOs() {
		return docRqstVOs;
	}
	/**
	 * @param docRqstVOs the docRqstVOs to set
	 */
	public void setDocRqstVOs(DocRqstVO[] docRqstVOs) {
		this.docRqstVOs = docRqstVOs;
	}


	
	
	
	
	
	
	
	
	
	
	

}