/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_040Event.java
*@FileTitle : TerminalAgreement 조회화면 -Detail(Terminal Rate)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-07
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-11-07 kimjinjoo
* 1.0 최초 생성
* 
*@LastModifyDate : 2009.08.14
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.14 yOng hO lEE
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.TesAgreementManageCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlAgmtHdrVO;


/**
 * ESD_TES_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjinjoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 * 
 * @author yOng hO lEE
 * @see ESD_TES_0040HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTes0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesCommonVO 					tesCommonVO							= null;
	private TesAgreementManageCommonVO 		tesAgreementManageCommonVO			= null;
	private TesTmlAgmtHdrVO 				tesTmlAgmtHdrVO						= null;
	
	/** Table Value Object Multi Data 처리 */
	private TesCommonVO[]					tesCommonVOs						= null;
	private TesAgreementManageCommonVO[]	tesAgreementManageCommonVOs			= null;
	private TesTmlAgmtHdrVO[] 				tesTmlAgmtHdrVOs					= null;

	public EsdTes0040Event(){}

	public TesCommonVO getTesCommonVO() {
		return tesCommonVO;
	}

	public void setTesCommonVO(TesCommonVO tesCommonVO) {
		this.tesCommonVO = tesCommonVO;
	}

	public TesAgreementManageCommonVO getTesAgreementManageCommonVO() {
		return tesAgreementManageCommonVO;
	}

	public void setTesAgreementManageCommonVO(
			TesAgreementManageCommonVO tesAgreementManageCommonVO) {
		this.tesAgreementManageCommonVO = tesAgreementManageCommonVO;
	}

	public TesTmlAgmtHdrVO getTesTmlAgmtHdrVO() {
		return tesTmlAgmtHdrVO;
	}

	public void setTesTmlAgmtHdrVO(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) {
		this.tesTmlAgmtHdrVO = tesTmlAgmtHdrVO;
	}

	public TesCommonVO[] getTesCommonVOs() {
		TesCommonVO[] rtnVOs = null;
		if (this.tesCommonVOs != null) {
			rtnVOs = Arrays.copyOf(tesCommonVOs, tesCommonVOs.length);
		}
		return rtnVOs;
	}

	public void setTesCommonVOs(TesCommonVO[] tesCommonVOs){
		if(tesCommonVOs != null){
			TesCommonVO[] tmpVOs = Arrays.copyOf(tesCommonVOs, tesCommonVOs.length);
			this.tesCommonVOs = tmpVOs;
		}
	}

	public TesAgreementManageCommonVO[] getTesAgreementManageCommonVOs() {
		TesAgreementManageCommonVO[] rtnVOs = null;
		if (this.tesAgreementManageCommonVOs != null) {
			rtnVOs = Arrays.copyOf(tesAgreementManageCommonVOs, tesAgreementManageCommonVOs.length);
		}
		return rtnVOs;
	}

	public void setTesAgreementManageCommonVOs(TesAgreementManageCommonVO[] tesAgreementManageCommonVOs){
		if(tesAgreementManageCommonVOs != null){
			TesAgreementManageCommonVO[] tmpVOs = Arrays.copyOf(tesAgreementManageCommonVOs, tesAgreementManageCommonVOs.length);
			this.tesAgreementManageCommonVOs = tmpVOs;
		}
	}

	public TesTmlAgmtHdrVO[] getTesTmlAgmtHdrVOs() {
		TesTmlAgmtHdrVO[] rtnVOs = null;
		if (this.tesTmlAgmtHdrVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlAgmtHdrVOs, tesTmlAgmtHdrVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlAgmtHdrVOs(TesTmlAgmtHdrVO[] tesTmlAgmtHdrVOs){
		if(tesTmlAgmtHdrVOs != null){
			TesTmlAgmtHdrVO[] tmpVOs = Arrays.copyOf(tesTmlAgmtHdrVOs, tesTmlAgmtHdrVOs.length);
			this.tesTmlAgmtHdrVOs = tmpVOs;
		}
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}
