/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0056Event.java
*@FileTitle : Invoice File import
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.22 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.event;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.OscarBookingSearchEdiVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 *  PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cim_2001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Young Jin
 * @see ees_cim_2001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim2002Event extends EventSupport {

	private static final long serialVersionUID = 1L; 
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OscarBookingSearchEdiVO oscarBookingSearchEdiVO = null;
	
	/** 검색결과 **/
	private OscarBookingSearchEdiVO[] oscarBookingSearchEdiVOs = null;
		
	public EesCim2002Event(){}
	
	/**
	 * @return the getOscarBookingSearchVOs
	 */
	public OscarBookingSearchEdiVO[] getOscarBookingSearchEdiVOs() {
		OscarBookingSearchEdiVO[] tmpVOs = null;
		if (this.oscarBookingSearchEdiVOs != null) {
			tmpVOs = new OscarBookingSearchEdiVO[oscarBookingSearchEdiVOs.length];
			System.arraycopy(oscarBookingSearchEdiVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

	/**
	 * @param oscarBookingSearchVOs
	 *            the oscarBookingSearchVOs to set
	 */
	public void setOscarBookingSearchEdiVOs(OscarBookingSearchEdiVO[] oscarBookingSearchEdiVOs) {
		if (oscarBookingSearchEdiVOs != null) {
			OscarBookingSearchEdiVO[] tmpVOs = new OscarBookingSearchEdiVO[oscarBookingSearchEdiVOs.length];
			System.arraycopy(oscarBookingSearchEdiVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.oscarBookingSearchEdiVOs = tmpVOs;
		}

	}
	
	public void setOscarBookingSearchEdiVO(OscarBookingSearchEdiVO oscarBookingSearchEdiVO){
		this.oscarBookingSearchEdiVO = oscarBookingSearchEdiVO;
	}
	
	public OscarBookingSearchEdiVO getOscarBookingSearchEdiVO(){
		return oscarBookingSearchEdiVO;
	}
	
	
	
}