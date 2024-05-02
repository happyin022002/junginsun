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

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SrndVO;
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

public class EsmBkg0400Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg0400Event(){}
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SrndVO srndVO = null;
	/** Table Value Object Multi Data 처리 */
	private SrndVO[] srndVOs = null;
	private String bkgNo = null;
	private String blNo = null;
	private String existObsFlg = null;
	
	
	/**
	 * @return the srndVO
	 */
	public SrndVO getSrndVO() {
		return srndVO;
	}
	/**
	 * @param srndVO the srndVO to set
	 */
	public void setSrndVO(SrndVO srndVO) {
		this.srndVO = srndVO;
	}
	/**
	 * @return the srndVOs
	 */
	public SrndVO[] getSrndVOs() {
		return srndVOs;
	}
	/**
	 * @param srndVOs the srndVOs to set
	 */
	public void setSrndVOs(SrndVO[] srndVOs) {
		this.srndVOs = srndVOs;
	}
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
	 * @return existObsFlg
	 */
	public String getExistObsFlg() {
		return existObsFlg;
	}
	/**
	 * @param existObsFlg the existObsFlg to set
	 */
	public void setExistObsFlg(String existObsFlg) {
		this.existObsFlg = existObsFlg;
	}




	
	

}