/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiGae0006Event.java
 *@FileTitle : Closing Confirmation & Interface Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event;


import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemXchRtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM-0009] Foreign Exchange Rate Maintenance
 * CPS_GEM_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0009HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/**
	 *  Currency
	 */
	private String inCurrCd = "";
	
	
	/**
	 * 엑셀업로드후 존재하지않은 Currency를 오피스테이블에서 취득
	 * @return Currency USD|JPY.........
	 */
	public String getInCurrCd() {
		return inCurrCd;
	}

	/**
	 * Currency 코드 설정
	 * USD|JPY|XXX|.........
	 * @param inCurrCd
	 */
	public void setInCurrCd(String inCurrCd) {
		this.inCurrCd = inCurrCd;
	}

	/** Table Value Object 조회 조건 및 단건 처리 */
	private GemXchRtVO gemXchRtVO = null;

	/** Table Value Object Multi Data 처리 */
	private GemXchRtVO[] gemXchRtVOs = null;

	public CpsGem0009Event() {
	}

	public GemXchRtVO getGemXchRtVO() {
		return gemXchRtVO;
	}

	public void setGemXchRtVO(GemXchRtVO gemXchRtVO) {
		this.gemXchRtVO = gemXchRtVO;
	}

	public GemXchRtVO[] getGemXchRtVOs() {
		return gemXchRtVOs;
	}

	public void setGemXchRtVOs(GemXchRtVO[] gemXchRtVOs) {
		this.gemXchRtVOs = gemXchRtVOs;
	}



}