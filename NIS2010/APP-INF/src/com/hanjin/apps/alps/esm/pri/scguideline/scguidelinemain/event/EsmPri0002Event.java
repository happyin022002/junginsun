/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri0002Event.java
 *@FileTitle : Guideline Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.30 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.event;

import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineMnVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * UI_PRI_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Sungsoo
 * @see ESM_PRI_0001HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0002Event extends EventSupport {

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

	public EsmPri0002Event() {
	}

	public void setRsltGlineMnVO(RsltGlineMnVO rsltglinemnvo) {
		this.rsltglinemnvo = rsltglinemnvo;
	}

	public void setRsltGlineMnVOS(RsltGlineMnVO[] rsltglinemnvos) {
		this.rsltglinemnvos = rsltglinemnvos;
	}

	public void setPriSgMnVO(PriSgMnVO prisgmnvo) {
		this.prisgmnvo = prisgmnvo;
	}

	public void setPriSgMnVOS(PriSgMnVO[] prisgmnvos) {
		this.prisgmnvos = prisgmnvos;
	}

	public void setRsltGlineScpEffDtListVO(RsltGlineScpEffDtListVO rsltglinescpeffdtlistvo) {
		this.rsltglinescpeffdtlistvo = rsltglinescpeffdtlistvo;
	}

	public void setRsltGlineScpEffDtListVOS(RsltGlineScpEffDtListVO[] rsltglinescpeffdtlistvos) {
		this.rsltglinescpeffdtlistvos = rsltglinescpeffdtlistvos;
	}

	public RsltGlineMnVO getRsltGlineMnVO() {
		return rsltglinemnvo;
	}

	public RsltGlineMnVO[] getRsltGlineMnVOS() {
		return rsltglinemnvos;
	}

	public PriSgMnVO getPriSgMnVO() {
		return prisgmnvo;
	}

	public PriSgMnVO[] getPriSgMnVOS() {
		return prisgmnvos;
	}

	public RsltGlineScpEffDtListVO getRsltGlineScpEffDtListVO() {
		return rsltglinescpeffdtlistvo;
	}

	public RsltGlineScpEffDtListVO[] getRsltGlineScpEffDtListVOS() {
		return rsltglinescpeffdtlistvos;
	}

}