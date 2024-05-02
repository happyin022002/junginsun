/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0750Event.java
 *@FileTitle : UsWharfageDecMgt
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.31
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.05.20 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfPortRtListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfPortRtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0750 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0750HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0750HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0750Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	// 조회조건
	private UsWhfPortRtListCondVO usWhfPortRtListCondVO = null;
	// 조회결과
	private UsWhfPortRtVO[] usWhfPortRtVOs = null;

	/**
	 * 조회조건
	 * @param WhfPortRtListCondVO
	 */
	public void setUsWhfPortRtListCondVO(UsWhfPortRtListCondVO usWhfPortRtListCondVO) {
		this.usWhfPortRtListCondVO = usWhfPortRtListCondVO;
	}
	
	/**
	 * 조회결과
	 * @param WhfPortRtVOs
	 */
	public void setUsWhfPortRtVOs(UsWhfPortRtVO[] usWhfPortRtVOs) {
		this.usWhfPortRtVOs = usWhfPortRtVOs;
	}
	
	/**
	 * 조회조건
	 * @return
	 */
	public UsWhfPortRtListCondVO getUsWhfPortRtListCondVO() {
		return usWhfPortRtListCondVO;
	}
	
	/**
	 * 조회결과
	 * @return
	 */
	public UsWhfPortRtVO[] getUsWhfPortRtVOs() {
		return usWhfPortRtVOs;
	}
}