/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0391Event.java
*@FileTitle : Multi Shipment Detail
*Open Issues : 
*Change history :
*@LastModifyDate : 2016.01.26
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2016.01.26 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCntrShpVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0391 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0391HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu 
 * @see ESM_BKG_0391HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0391Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String bkgNo = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCntrShpVO bkgCntrShpVO = null;
  
	/** Table Value Object Multi Data 처리 */
	private BkgCntrShpVO[] bkgCntrShpVOs = null;



	public EsmBkg0391Event(){}
	
	/**
	 * @return the bkgCntrShpVO
	 */
	public BkgCntrShpVO getBkgCntrShpVO() {
		return bkgCntrShpVO;
	}

	/**
	 * @param bkgCntrShpVO the bkgCntrShpVO to set
	 */
	public void setBkgCntrShpVO(BkgCntrShpVO bkgCntrShpVO) {
		this.bkgCntrShpVO = bkgCntrShpVO;
	}

	/**
	 * @return the bkgCntrShpVOs
	 */
	public BkgCntrShpVO[] getBkgCntrShpVOs() {
		BkgCntrShpVO[] rtnVOs = null;
		if (this.bkgCntrShpVOs != null) {
			rtnVOs = Arrays.copyOf(bkgCntrShpVOs, bkgCntrShpVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bkgCntrShpVOs the bkgCntrShpVOs to set
	 */
	public void setBkgCntrShpVOs(BkgCntrShpVO[] bkgCntrShpVOs) {
		if(bkgCntrShpVOs != null){
			BkgCntrShpVO[] tmpVOs = Arrays.copyOf(bkgCntrShpVOs, bkgCntrShpVOs.length);
			this.bkgCntrShpVOs = tmpVOs;
		}
	}

	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	

}