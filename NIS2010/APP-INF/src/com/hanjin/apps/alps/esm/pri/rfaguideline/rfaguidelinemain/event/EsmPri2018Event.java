/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2018Event.java
 *@FileTitle : RFA Guideline Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.30 박성수
 * 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.event;

import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineMnVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRgMnVO;

/**
 * UI_PRI_2001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_2001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Sungsoo
 * @see ESM_PRI_2001HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EsmPri2018Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RsltGlineMnVO rsltglinemnvo = null;

	/** Table Value Object Multi Data 처리 */
	private RsltGlineMnVO[] rsltglinemnvos = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRgMnVO prirgmnvo = null;

	/** Table Value Object Multi Data 처리 */
	private PriRgMnVO[] prirgmnvos = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RsltGlineScpEffDtListVO rsltglinescpeffdtlistvo = null;

	/** Table Value Object Multi Data 처리 */
	private RsltGlineScpEffDtListVO[] rsltglinescpeffdtlistvos = null;

	public EsmPri2018Event() {
	}

	public void setRsltGlineMnVO(RsltGlineMnVO rsltglinemnvo) {
		this.rsltglinemnvo = rsltglinemnvo;
	}

	public void setRsltGlineMnVOS(RsltGlineMnVO[] rsltglinemnvos){
		if(rsltglinemnvos != null){
			RsltGlineMnVO[] tmpVOs = new RsltGlineMnVO[rsltglinemnvos.length];
			System.arraycopy(rsltglinemnvos, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltglinemnvos = tmpVOs;
		}
	}

	public void setPriRgMnVO(PriRgMnVO prirgmnvo) {
		this.prirgmnvo = prirgmnvo;
	}

	public void setPriRgMnVOS(PriRgMnVO[] prirgmnvos){
		if(prirgmnvos != null){
			PriRgMnVO[] tmpVOs = new PriRgMnVO[prirgmnvos.length];
			System.arraycopy(prirgmnvos, 0, tmpVOs, 0, tmpVOs.length);
			this.prirgmnvos = tmpVOs;
		}
	}

	public void setRsltGlineScpEffDtListVO(RsltGlineScpEffDtListVO rsltglinescpeffdtlistvo) {
		this.rsltglinescpeffdtlistvo = rsltglinescpeffdtlistvo;
	}

	public void setRsltGlineScpEffDtListVOS(RsltGlineScpEffDtListVO[] rsltglinescpeffdtlistvos){
		if(rsltglinescpeffdtlistvos != null){
			RsltGlineScpEffDtListVO[] tmpVOs = new RsltGlineScpEffDtListVO[rsltglinescpeffdtlistvos.length];
			System.arraycopy(rsltglinescpeffdtlistvos, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltglinescpeffdtlistvos = tmpVOs;
		}
	}

	public RsltGlineMnVO getRsltGlineMnVO() {
		return rsltglinemnvo;
	}

	public RsltGlineMnVO[] getRsltGlineMnVOS(){
		RsltGlineMnVO[] rtnVOs = null;
		if (this.rsltglinemnvos != null) {
			rtnVOs = new RsltGlineMnVO[rsltglinemnvos.length];
			System.arraycopy(rsltglinemnvos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriRgMnVO getPriRgMnVO() {
		return prirgmnvo;
	}

	public PriRgMnVO[] getPriRgMnVOS(){
		PriRgMnVO[] rtnVOs = null;
		if (this.prirgmnvos != null) {
			rtnVOs = new PriRgMnVO[prirgmnvos.length];
			System.arraycopy(prirgmnvos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public RsltGlineScpEffDtListVO getRsltGlineScpEffDtListVO() {
		return rsltglinescpeffdtlistvo;
	}

	public RsltGlineScpEffDtListVO[] getRsltGlineScpEffDtListVOS(){
		RsltGlineScpEffDtListVO[] rtnVOs = null;
		if (this.rsltglinescpeffdtlistvos != null) {
			rtnVOs = new RsltGlineScpEffDtListVO[rsltglinescpeffdtlistvos.length];
			System.arraycopy(rsltglinescpeffdtlistvos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}