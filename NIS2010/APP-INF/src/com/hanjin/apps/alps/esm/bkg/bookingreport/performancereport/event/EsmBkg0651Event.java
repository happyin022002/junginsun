/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0651Event.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.24 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BlCaDetailListVO;


/**
 * ESM_BKG_0651 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0651HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0651HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0651Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BlCaDetailListVO blCaDetailListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BlCaDetailListVO[] blCaDetailListVOs = null;
	
	private String blNo  		= null;
	
	private String bkgNo 		= null;
	
	private String caNo  		= null;
	
	private String usrEml 		= null;
	
	private String title		= null;
	
	private String content		= null;
	
	private String rdParam		= null;

	public EsmBkg0651Event(){}
	
	public void setBlCaDetailListVO(BlCaDetailListVO blCaDetailListVO){
		this. blCaDetailListVO = blCaDetailListVO;
	}

	public void setBlCaDetailListVOS(BlCaDetailListVO[] blCaDetailListVOs){
		this. blCaDetailListVOs = blCaDetailListVOs;
	}
	
	public void setBlNo(String blNo){
		this.blNo = blNo;
	}
	
	public void setBkgNo(String bkgNo){
		this.bkgNo = bkgNo;
	}
	
	public void setCaNo(String caNo){
		this.caNo = caNo;
	}
	
	public void setUsrEml(String usrEml){
		this.usrEml = usrEml;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public void setRdParam(String rdParam){
		this.rdParam = rdParam;
	}

	public BlCaDetailListVO getBlCaDetailListVO(){
		return blCaDetailListVO;
	}

	public BlCaDetailListVO[] getBlCaDetailListVOS(){
		return blCaDetailListVOs;
	}
	
	public String getBlNo(){
		return blNo;
	}
	
	public String getBkgNo(){
		return bkgNo;
	}
	
	public String getCaNo(){
		return caNo;
	}
	
	public String getUsrEml(){
		return usrEml;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getContent(){
		return content;
	}
	
	public String getRdParam(){
		return rdParam;
	}

}