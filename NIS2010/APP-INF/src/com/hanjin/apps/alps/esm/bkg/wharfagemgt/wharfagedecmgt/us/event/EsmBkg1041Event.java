/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1041Event.java
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

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfBlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfBlVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_1041HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1041Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	// 조회조건
	private UsWhfBlListCondVO usWhfBlListCondVO = null;
	// 조회결과
	private UsWhfBlVO[] usWhfBlVOs = null;
	// BackEndJob을 위한 키
	private String key = "";

	/**
	 * 조회조건
	 * @param usWhfBlListCondVO
	 */
	public void setUsWhfBlListCondVO(UsWhfBlListCondVO usWhfBlListCondVO) {
		this.usWhfBlListCondVO = usWhfBlListCondVO;
	}
	
	/**
	 * 조회결과
	 * @param usWhfExceptCmdtVOs
	 */
	public void setUsWhfBlVOs(UsWhfBlVO[] usWhfBlVOs) {
		this.usWhfBlVOs = usWhfBlVOs;
	}
	
	/**
	 * 조회조건
	 * @return
	 */
	public UsWhfBlListCondVO getUsWhfBlListCondVO() {
		return usWhfBlListCondVO;
	}
	
	/**
	 * 조회결과
	 * @return
	 */
	public UsWhfBlVO[] getUsWhfBlVOs() {
		return usWhfBlVOs;
	}

	/**
	 * BackEndJob Key
	 * @return
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * BackEndJob Key
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
}
