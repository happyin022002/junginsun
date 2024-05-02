/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0412Event.java
*@FileTitle : Queue Detail List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgDpcsDocWeightVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0412 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0412HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0412HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0412Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgDpcsDocWeightVO bkgDpcsDocWeightVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgDpcsDocWeightVO[] bkgDpcsDocWeightVOs = null;
	
	private String docGroup;
	private String srKind;  
	private String src;      
	private String border;   
	private String point;    


	public BkgDpcsDocWeightVO getBkgDpcsDocWeightVO() {
		return bkgDpcsDocWeightVO;
	}


	public void setBkgDpcsDocWeightVO(BkgDpcsDocWeightVO bkgDpcsDocWeightVO) {
		this.bkgDpcsDocWeightVO = bkgDpcsDocWeightVO;
	}


	public BkgDpcsDocWeightVO[] getBkgDpcsDocWeightVOs() {
		BkgDpcsDocWeightVO[] rtnVOs = null;
		if (this.bkgDpcsDocWeightVOs != null) {
			rtnVOs = Arrays.copyOf(bkgDpcsDocWeightVOs, bkgDpcsDocWeightVOs.length);
		}
		return rtnVOs;
	}


	public void setBkgDpcsDocWeightVOs(BkgDpcsDocWeightVO[] bkgDpcsDocWeightVOs){
		if(bkgDpcsDocWeightVOs != null){
			BkgDpcsDocWeightVO[] tmpVOs = Arrays.copyOf(bkgDpcsDocWeightVOs, bkgDpcsDocWeightVOs.length);
			this.bkgDpcsDocWeightVOs = tmpVOs;
		}
	}


	public String getDocGroup() {
		return docGroup;
	}


	public void setDocGroup(String docGroup) {
		this.docGroup = docGroup;
	}


	public String getSrKind() {
		return srKind;
	}


	public void setSrKind(String srKind) {
		this.srKind = srKind;
	}


	public String getSrc() {
		return src;
	}


	public void setSrc(String src) {
		this.src = src;
	}


	public String getBorder() {
		return border;
	}


	public void setBorder(String border) {
		this.border = border;
	}


	public String getPoint() {
		return point;
	}


	public void setPoint(String point) {
		this.point = point;
	}


	public EsmBkg0412Event(){}


 
	
}