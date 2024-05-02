/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0097Event.java
*@FileTitle : Reference Number
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.21 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgReferenceVO;


/**
 * ESM_BKG_0097 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0097HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0097HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0097Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RefNoVO refNoVO = null;
	private BkgBlNoVO bkgBlNoVO = null;
	private BkgReferenceVO bkgReferenceVO = null;

	/** Table Value Object Multi Data 처리 */
	private RefNoVO[] refNoVOs = null;
	private BkgReferenceVO[] bkgReferenceVOs = null;

	public EsmBkg0097Event(){}

	public void setRefNoVO(RefNoVO refNoVO){
		this. refNoVO = refNoVO;
	}

	public void setRefNoVOs(RefNoVO[] refNoVOs){
		if (refNoVOs != null) {
			RefNoVO[] tmpVOs = Arrays.copyOf(refNoVOs, refNoVOs .length);
			this. refNoVOs = tmpVOs;
		}
	}

	public void setBkgReferenceVO(BkgReferenceVO bkgReferenceVO){
		this. bkgReferenceVO = bkgReferenceVO;
	}

	public void setBkgReferenceVOs(BkgReferenceVO[] bkgReferenceVOs){
		if (bkgReferenceVOs != null) {
			BkgReferenceVO[] tmpVOs = Arrays.copyOf(bkgReferenceVOs, bkgReferenceVOs .length);
			this. bkgReferenceVOs = tmpVOs;
		}
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this. bkgBlNoVO = bkgBlNoVO;
	}

	public RefNoVO getRefNoVO(){
		return refNoVO;
	}

	public RefNoVO[] getRefNoVOs(){
		RefNoVO[] tmpVOs = null;
		if (this. refNoVOs != null) {
			tmpVOs = Arrays.copyOf(refNoVOs, refNoVOs .length);
		}
		return tmpVOs;
	}

	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}

	public BkgReferenceVO getBkgReferenceVO(){
		return bkgReferenceVO;
	}

	public BkgReferenceVO[] getBkgReferenceVOs(){
		BkgReferenceVO[] tmpVOs = null;
		if (this. bkgReferenceVOs != null) {
			tmpVOs = Arrays.copyOf(bkgReferenceVOs, bkgReferenceVOs .length);
		}
		return tmpVOs;
	}
}