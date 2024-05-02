/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0001Event.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.15 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.event;

import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.RsltGlineMnVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * UI_PRI_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Sungsoo
 * @see ESM_PRI_0001HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RsltGlineMnVO rsltglinemnvo = null;

	/** Table Value Object Multi Data 처리 */
	private RsltGlineMnVO[] rsltglinemnvos = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriSgMnVO prisgmnvo = null;

	/** Table Value Object Multi Data 처리 */
	private PriSgMnVO[] prisgmnvos = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RsltGlineScpEffDtListVO rsltglinescpeffdtlistvo = null;

	/** Table Value Object Multi Data 처리 */
	private RsltGlineScpEffDtListVO[] rsltglinescpeffdtlistvos = null;

	public EsmPri0001Event() {
	}

	public void setRsltGlineMnVO(RsltGlineMnVO rsltglinemnvo) {
		this.rsltglinemnvo = rsltglinemnvo;
	}

	public void setRsltGlineMnVOS(RsltGlineMnVO[] rsltglinemnvos) {
		if (rsltglinemnvos != null) {
			RsltGlineMnVO[] tmpVOs = new RsltGlineMnVO[rsltglinemnvos.length];
			System.arraycopy(rsltglinemnvos, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltglinemnvos = tmpVOs;
		}

	}

	public void setPriSgMnVO(PriSgMnVO prisgmnvo) {
		this.prisgmnvo = prisgmnvo;
	}

	public void setPriSgMnVOS(PriSgMnVO[] prisgmnvos) {
		if (prisgmnvos != null) {
			PriSgMnVO[] tmpVOs = new PriSgMnVO[prisgmnvos.length];
			System.arraycopy(prisgmnvos, 0, tmpVOs, 0, tmpVOs.length);
			this.prisgmnvos = tmpVOs;
		}
	}

	public void setRsltGlineScpEffDtListVO(RsltGlineScpEffDtListVO rsltglinescpeffdtlistvo) {
		this.rsltglinescpeffdtlistvo = rsltglinescpeffdtlistvo;
	}

	public void setRsltGlineScpEffDtListVOS(RsltGlineScpEffDtListVO[] rsltglinescpeffdtlistvos) {
		if (rsltglinescpeffdtlistvos != null) {
			RsltGlineScpEffDtListVO[] tmpVOs = new RsltGlineScpEffDtListVO[rsltglinescpeffdtlistvos.length];
			System.arraycopy(rsltglinescpeffdtlistvos, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltglinescpeffdtlistvos = tmpVOs;
		}
	}

	public RsltGlineMnVO getRsltGlineMnVO() {
		return rsltglinemnvo;
	}

	public RsltGlineMnVO[] getRsltGlineMnVOS() {
		RsltGlineMnVO[] tmpVOs = null;
		if (this.rsltglinemnvos != null) {
			tmpVOs = new RsltGlineMnVO[rsltglinemnvos.length];
			System.arraycopy(rsltglinemnvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSgMnVO getPriSgMnVO() {
		return prisgmnvo;
	}

	public PriSgMnVO[] getPriSgMnVOS() {
		PriSgMnVO[] tmpVOs = null;
		if (this.prisgmnvos != null) {
			tmpVOs = new PriSgMnVO[prisgmnvos.length];
			System.arraycopy(prisgmnvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public RsltGlineScpEffDtListVO getRsltGlineScpEffDtListVO() {
		return rsltglinescpeffdtlistvo;
	}

	public RsltGlineScpEffDtListVO[] getRsltGlineScpEffDtListVOS() {
		RsltGlineScpEffDtListVO[] tmpVOs = null;
		if (this.rsltglinescpeffdtlistvos != null) {
			tmpVOs = new RsltGlineScpEffDtListVO[rsltglinescpeffdtlistvos.length];
			System.arraycopy(rsltglinescpeffdtlistvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}