/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0088Event.java
*@FileTitle : Return CY Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmYardVO;


/**
 * esm_bkg_0088 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0088HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see esm_bkg_0088HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0088Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmYardVO mdmYardVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmYardVO[] mdmYardVOs = null;

	public EsmBkg0088Event(){}

	private String locCd = null;
	private String ydCd = null;
	private String n1stVndrCntCd = null;
	
	public String getN1stVndrCntCd() {
		return n1stVndrCntCd;
	}

	public void setN1stVndrCntCd(String n1stVndrCntCd) {
		this.n1stVndrCntCd = n1stVndrCntCd;
	}

	public String getYdCd() {
		return ydCd;
	}

	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}

	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	
	public void setMdmYardVO(MdmYardVO mdmYardVO){
		this. mdmYardVO = mdmYardVO;
	}

	public void setMdmYardVOS(MdmYardVO[] mdmYardVOs){
		this. mdmYardVOs = mdmYardVOs;
	}

	public MdmYardVO getMdmYardVO(){
		return mdmYardVO;
	}

	public MdmYardVO[] getMdmYardVOS(){
		return mdmYardVOs;
	}

}