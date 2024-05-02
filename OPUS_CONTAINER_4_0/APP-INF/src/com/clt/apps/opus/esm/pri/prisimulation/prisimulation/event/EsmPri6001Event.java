/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri6001Event.java
*@FileTitle : Verify Rate
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event;

import com.clt.apps.opus.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-Sun Moon
 * @see ESM_PRI_6001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PrdMainInfoVO prdMainInfoVO = null;
	private AplyRtInVO aplyRtInVO = null;
	private String ctrtNo = null;
	
	private String key = null;
	
//	
//	/** Table Value Object Multi Data 처리 */
//	private PriRcvDeTermMapgVO[] priRcvDeTermMapgVOs = null;

	public EsmPri6001Event(){}

	public PrdMainInfoVO getPrdMainInfoVO() {
		return prdMainInfoVO;
	}
	
	public void setPrdMainInfoVO(PrdMainInfoVO prdMainInfoVO) {
		this.prdMainInfoVO = prdMainInfoVO;
	}

	public AplyRtInVO getAplyRtInVO() {
		return aplyRtInVO;
	}

	public void setAplyRtInVO(AplyRtInVO aplyRtInVO) {
		this.aplyRtInVO = aplyRtInVO;
	}

	public String getCtrtNo() {
		return ctrtNo;
	}

	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}