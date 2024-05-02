/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0041Event.java
*@FileTitle : Asset inquiry by Year
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.08.12 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event;

import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_MST_0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MST_0041HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AssetsOptionVO assetsOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
//	private AssetsOptionVO[] assetsOptionVOs = null;

	public EesMst0041Event(){}
	
	public void setAssetsOptionVO(AssetsOptionVO assetsOptionVO){
		this.assetsOptionVO = assetsOptionVO;
	}

//	public void setAssetsOptionVOS(AssetsOptionVO[] assetsOptionVO){
//		this.assetsOptionVOs = assetsOptionVOs;
//	}

	public AssetsOptionVO getAssetsOptionVO(){
		return assetsOptionVO;
	}

//	public AssetsOptionVO[] getAssetsOptionVOS(){
//		return assetsOptionVOs;
//	}

}