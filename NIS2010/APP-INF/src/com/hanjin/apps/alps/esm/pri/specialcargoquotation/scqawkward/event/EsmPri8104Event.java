/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmPri8104Event.java
*@FileTitle : Office Hierarchy Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.04.10 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkHdrVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;


/**
 * ESM_PRI_8104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_8104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SongHoJin
 * @see ESM_PRI_8104HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri8104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqAwkHdrVO priScqAwkHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqAwkHdrVO[] priScqAwkHdrVOs = null;

	/** Custom Value Object 조회 조건 및 단건 처리  */
	private OrganizationVO organizationVO = null;
	
	public EsmPri8104Event(){}
	
	public void setPriScqAwkHdrVO(PriScqAwkHdrVO priScqAwkHdrVO){
		this. priScqAwkHdrVO = priScqAwkHdrVO;
	}

	public void setPriScqAwkHdrVOS(PriScqAwkHdrVO[] priScqAwkHdrVOs){
		this. priScqAwkHdrVOs = priScqAwkHdrVOs;
	}

	public void setOrganizationVO(OrganizationVO organizationVO){
		this.organizationVO = organizationVO;
	}

	public PriScqAwkHdrVO getPriScqAwkHdrVO(){
		return priScqAwkHdrVO;
	}

	public PriScqAwkHdrVO[] getPriScqAwkHdrVOS(){
		return priScqAwkHdrVOs;
	}

	public OrganizationVO getOrganizationVO(){
		return organizationVO;
	}

}