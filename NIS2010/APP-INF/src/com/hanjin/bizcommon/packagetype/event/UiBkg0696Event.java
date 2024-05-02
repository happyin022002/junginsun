/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0696Event.java
*@FileTitle : Package Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.04.16 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.packagetype.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.bizcommon.packagetype.vo.PackageTypeVO;


/**
 * UI_BKG_0696 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG_0696HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ji Seok Woo
 * @see UI_BKG_0696HTMLAction 참조
 * @since J2EE 1.4
 */

public class UiBkg0696Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PackageTypeVO packagetypevo = null;
	
	/** Table Value Object Multi Data 처리 */
	private PackageTypeVO[] packagetypevos = null;

	public UiBkg0696Event(){}
	
	public void setPackageTypeVO(PackageTypeVO packagetypevo){
		this. packagetypevo = packagetypevo;
	}

	public void setPackageTypeVOS(PackageTypeVO[] packagetypevos){
		this. packagetypevos = packagetypevos;
	}

	public PackageTypeVO getPackageTypeVO(){
		return packagetypevo;
	}

	public PackageTypeVO[] getPackageTypeVOS(){
		return packagetypevos;
	}

}