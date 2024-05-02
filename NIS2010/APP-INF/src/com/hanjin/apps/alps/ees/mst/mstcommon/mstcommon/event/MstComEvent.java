/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MstComEvent.java
*@FileTitle : MST COMMON PAGE
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.18 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.vo.AgmtInfoVO;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.vo.CommonListVO;


/**
 * MST_COM 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  MST_COMHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see MST_COMHTMLAction 참조
 * @since J2EE 1.6
 */

public class MstComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CommonListVO commonListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public CommonListVO[] commonListVOs = null;
	
	/**
	 * @return the commonListVOs
	 */
	public CommonListVO[] getCommonListVOs() {
		return commonListVOs;
	}

	/** INTG CD ID 조회 조건 **/
	private String intgCdId="";
	
	/** INTG CD VAL 조회 조건 **/
	private String intgCdVal="";
	
	/**
	 * @param commonListVOs the commonListVOs to set
	 */
	public void setCommonListVOs(CommonListVO[] commonListVOs) {
		this.commonListVOs = commonListVOs;
	}

	/**
	 * @return the agmtInfoVO
	 */
	public AgmtInfoVO getAgmtInfoVO() {
		return agmtInfoVO;
	}

	/**
	 * @param agmtInfoVO the agmtInfoVO to set
	 */
	public void setAgmtInfoVO(AgmtInfoVO agmtInfoVO) {
		this.agmtInfoVO = agmtInfoVO;
	}

	/**
	 * @return the agmtInfoVOs
	 */
	public AgmtInfoVO[] getAgmtInfoVOs() {
		return agmtInfoVOs;
	}

	/**
	 * @param agmtInfoVOs the agmtInfoVOs to set
	 */
	public void setAgmtInfoVOs(AgmtInfoVO[] agmtInfoVOs) {
		this.agmtInfoVOs = agmtInfoVOs;
	}

	private AgmtInfoVO agmtInfoVO = null;
	
	public AgmtInfoVO[] agmtInfoVOs = null;

	public MstComEvent(){}
	
	public void setCommonListVO(CommonListVO commonListVO){
		this. commonListVO = commonListVO;
	}

	public void setCommonListVOS(CommonListVO[] commonListVOs){
		this. commonListVOs = commonListVOs;
	}

	public CommonListVO getCommonListVO(){
		return commonListVO;
	}

	public CommonListVO[] getCommonListVOS(){
		return commonListVOs;
	}

	public String getIntgCdId() {
		return intgCdId;
	}

	public void setIntgCdVal(String intgCdVal) {
		this.intgCdVal = intgCdVal;
	}
	
	public String getIntgCdVal() {
		return intgCdVal;
	}

	public void setIntgCdId(String intgCdId) {
		this.intgCdId = intgCdId;
	}
}