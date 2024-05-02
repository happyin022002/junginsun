/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0748Event.java
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

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfExceptCmdtListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfExceptCmdtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0748 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0748HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0748HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0748Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	// 조회조건
	private UsWhfExceptCmdtListCondVO usWhfExceptCmdtListCondVO = null;
	// 조회결과
	private UsWhfExceptCmdtVO[] usWhfExceptCmdtVOs = null;

	/**
	 * 조회조건
	 * @param usWhfExceptCmdtListCondVO
	 */
	public void setUsWhfExceptCmdtListCondVO(UsWhfExceptCmdtListCondVO usWhfExceptCmdtListCondVO) {
		this.usWhfExceptCmdtListCondVO = usWhfExceptCmdtListCondVO;
	}
	
	/**
	 * 조회결과
	 * @param usWhfExceptCmdtVOs
	 */
	public void setUsWhfExceptCmdtVOs(UsWhfExceptCmdtVO[] usWhfExceptCmdtVOs) {
		this.usWhfExceptCmdtVOs = usWhfExceptCmdtVOs;
	}
	
	/**
	 * 조회조건
	 * @return
	 */
	public UsWhfExceptCmdtListCondVO getUsWhfExceptCmdtListCondVO() {
		return usWhfExceptCmdtListCondVO;
	}
	
	/**
	 * 조회결과
	 * @return
	 */
	public UsWhfExceptCmdtVO[] getUsWhfExceptCmdtVOs() {
		return usWhfExceptCmdtVOs;
	}
}
