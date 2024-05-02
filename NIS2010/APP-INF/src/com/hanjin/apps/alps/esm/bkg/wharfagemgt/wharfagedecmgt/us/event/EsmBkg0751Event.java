/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0751Event.java
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

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfEmlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfEmlVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0751 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0751HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0751HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0751Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	// 조회조건
	private UsWhfEmlListCondVO usWhfEmlListCondVO = null;
	// 조회결과
	private UsWhfEmlVO[] usWhfEmlVOs = null;

	/**
	 * 조회조건
	 * @param WhfEmlListCondVO
	 */
	public void setUsWhfEmlListCondVO(UsWhfEmlListCondVO usWhfEmlListCondVO) {
		this.usWhfEmlListCondVO = usWhfEmlListCondVO;
	}
	
	/**
	 * 조회결과
	 * @param WhfEmlVOs
	 */
	public void setUsWhfEmlVOs(UsWhfEmlVO[] usWhfEmlVOs) {
		this.usWhfEmlVOs = usWhfEmlVOs;
	}
	
	/**
	 * 조회조건
	 * @return
	 */
	public UsWhfEmlListCondVO getUsWhfEmlListCondVO() {
		return usWhfEmlListCondVO;
	}
	
	/**
	 * 조회결과
	 * @return
	 */
	public UsWhfEmlVO[] getUsWhfEmlVOs() {
		return usWhfEmlVOs;
	}
}