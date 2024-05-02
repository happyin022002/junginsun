/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0903Event.java
*@FileTitle : Next VVD Assign T/S Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.15 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgTsRmkVO;


/**
 * ESM_BKG_0903 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0903HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0903HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0903Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgTsRmkVO bkgTsRmkVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgTsRmkVO[] bkgTsRmkVOs = null;
	private BkgBlNoVO bkgBlNoVO =null;
	private BkgBlNoVO[] bkgBlNoVOs =null;
	private String relayPort = null;
	
	public EsmBkg0903Event(){}

	public BkgTsRmkVO getBkgTsRmkVO() {
		return bkgTsRmkVO;
	}

	public void setBkgTsRmkVO(BkgTsRmkVO bkgTsRmkVO) {
		this.bkgTsRmkVO = bkgTsRmkVO;
	}

	public BkgTsRmkVO[] getBkgTsRmkVOs() {
		return bkgTsRmkVOs;
	}

	public void setBkgTsRmkVOs(BkgTsRmkVO[] bkgTsRmkVOs) {
		this.bkgTsRmkVOs = bkgTsRmkVOs;
	}
	 
	public String getRelayPort() {
		return relayPort;
	}

	public void setRelayPort(String relayPort) {
		this.relayPort = relayPort;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		return bkgBlNoVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
	}
	
	 

}