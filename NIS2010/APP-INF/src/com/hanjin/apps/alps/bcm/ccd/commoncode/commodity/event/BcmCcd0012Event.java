/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0012Event.java
*@FileTitle : CustPackageType
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.03.04 조인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.event;
 
import java.util.Arrays;

import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.vo.CustPackageTypeVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Package Type Code */
	private String pckCd = "";
	
	/** Customs Country Code */
	private String cstmsCntCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustPackageTypeVO custPackTypeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustPackageTypeVO[] custPackTypeVOs = null;

	public BcmCcd0012Event(){}

	public void setCustPackageTypeVO(CustPackageTypeVO custPackTypeVO){
		this. custPackTypeVO = custPackTypeVO;
	}
	
	public void setCustPackageTypeVOS(CustPackageTypeVO[] custPackTypeVOs){
		if(custPackTypeVOs != null){
			CustPackageTypeVO[] tmpVOs = java.util.Arrays.copyOf(custPackTypeVOs, custPackTypeVOs.length);
			this.custPackTypeVOs = tmpVOs;
		}
	}

	public CustPackageTypeVO getCustPackageTypeVO(){
		return custPackTypeVO;
	}

	public CustPackageTypeVO[] getCustPackageTypeVOS(){
		CustPackageTypeVO[] rtnVOs = null;
		if (this.custPackTypeVOs != null) {
			rtnVOs = Arrays.copyOf(custPackTypeVOs, custPackTypeVOs.length);
		}
		return rtnVOs;
	}

	public void setPckCd(String pckCd) {
		this.pckCd = pckCd;
	}
	
	public String getPckCd() {
		return pckCd;
	}

	public void setCstmsCntCd(String cstmsCntCd) {
		this.cstmsCntCd = cstmsCntCd;
	}
	
	public String getCstmsCntCd() {
		return cstmsCntCd;
	}
}