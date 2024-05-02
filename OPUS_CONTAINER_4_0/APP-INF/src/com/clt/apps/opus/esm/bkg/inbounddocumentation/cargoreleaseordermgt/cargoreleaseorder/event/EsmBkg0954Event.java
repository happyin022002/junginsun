/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0954Event.java
*@FileTitle : Cargo Release Order Auto Pop-up Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgDoHisVO;


/**
 * esm_bkg_0954 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0954HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0954HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0954Event extends EventSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2261069293441189767L;

	/** 검색조건 */
	private String blNo = null;
	private BkgDoHisVO bkgDoHis = null;
	
	public EsmBkg0954Event(){}


	public String getBlNo() {
		return blNo;
	}


	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}


	public BkgDoHisVO getBkgDoHis() {
		return bkgDoHis;
	}


	public void setBkgDoHis(BkgDoHisVO bkgDoHis) {
		this.bkgDoHis = bkgDoHis;
	}
	
}