/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg9454Event.java
*@FileTitle : Transhipment Route Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.25 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_9454 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9454HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_9454HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9454Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgBlNoVO[] bkgBlNoVOs = null;

	public EsmBkg9454Event(){}
	
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this. bkgBlNoVO = bkgBlNoVO;
	}

	public void setBkgBlNoVOS(BkgBlNoVO[] bkgBlNoVOs){
		if (bkgBlNoVOs != null) {
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
			this. bkgBlNoVOs = tmpVOs;
		}
	}

	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOS(){
		BkgBlNoVO[] tmpVOs = null;
		if (this. bkgBlNoVOs != null) {
			tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
		}
		return tmpVOs;
	}

}