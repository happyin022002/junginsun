/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri0006Event.java
 *@FileTitle : Guideline Copy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.16
 *@LastModifier : 김재연
 *@LastVersion : 1.0
 * 2009.06.16 김재연
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgMnVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineMnVO;

/**
 * ESM_PRI_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author JaeYeon Kim
 * @see ESM_PRI_0006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0006Event extends EventSupport {

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
	private GlineMnCpVO glineMnCpVO = null;

	/** Table Value Object Multi Data 처리 */
	private GlineMnCpVO[] glineMnCpVOs = null;

	public EsmPri0006Event() {
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

	public void setGlineMnCpVO(GlineMnCpVO glineMnCpVO) {
		this.glineMnCpVO = glineMnCpVO;
	}

	public void setGlineMnCpVOS(GlineMnCpVO[] glineMnCpVOs) {
		this.glineMnCpVOs = glineMnCpVOs;
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

	public GlineMnCpVO getGlineMnCpVO() {
		return glineMnCpVO;
	}

	public GlineMnCpVO[] getGlineMnCpVOS() {
		return glineMnCpVOs;
	}

}