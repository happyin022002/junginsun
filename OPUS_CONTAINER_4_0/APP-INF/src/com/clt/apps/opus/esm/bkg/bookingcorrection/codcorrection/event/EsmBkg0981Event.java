/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0981Event.java
*@FileTitle : COD Application at BKG Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.29 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0981 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0981HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0981HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0981Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgBlNoVO[] bkgBlNoVOs = null;
	
	private String codRqstSeq = null;

	public EsmBkg0981Event(){}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		BkgBlNoVO[] rtnVOs = null;
		if (this.bkgBlNoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		if(bkgBlNoVOs != null){
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
			this.bkgBlNoVOs = tmpVOs;
		}
	}

	public String getCodRqstSeq() {
		return codRqstSeq;
	}

	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}
	
	 

}