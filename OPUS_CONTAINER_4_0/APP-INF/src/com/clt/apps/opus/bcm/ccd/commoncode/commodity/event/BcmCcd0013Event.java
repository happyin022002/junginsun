/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0013Event.java
*@FileTitle : Package Type
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.03.04 조인영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.commodity.event;

import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.PackageTypeVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0013HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Package Type Code */
	private String pckCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PackageTypeVO packTypeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PackageTypeVO[] packTypeVOs = null;

	public BcmCcd0013Event(){}

	public void setPackageTypeVO(PackageTypeVO packTypeVO){
		this. packTypeVO = packTypeVO;
	}
	
	public void setPackageTypeVOS(PackageTypeVO[] packTypeVOs){
		if(packTypeVOs != null){
			PackageTypeVO[] tmpVOs = java.util.Arrays.copyOf(packTypeVOs, packTypeVOs.length);
			this.packTypeVOs = tmpVOs;
		}
	}

	public PackageTypeVO getPackageTypeVO(){
		return packTypeVO;
	}

	public PackageTypeVO[] getPackageTypeVOS(){
		PackageTypeVO[] rtnVOs = null;
		if (this.packTypeVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(packTypeVOs, packTypeVOs.length);
		}
		return rtnVOs;
	}

	public void setPckCd(String pckCd) {
		this.pckCd = pckCd;
	}
	
	public String getPckCd() {
		return pckCd;
	}
}