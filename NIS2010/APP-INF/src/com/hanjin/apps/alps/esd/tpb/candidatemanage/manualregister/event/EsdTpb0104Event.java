/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0104Event.java
*@FileTitle : EACRegistration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.08.17 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.CreateEACRegistrationVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchManualRegisterListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TPB_0104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, Choi
 * @see ESD_TPB_0104HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchManualRegisterListVO searchManualRegisterListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchManualRegisterListVO[] searchManualRegisterListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CreateEACRegistrationVO createEACRegistrationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CreateEACRegistrationVO[] createEACRegistrationVOs = null;
	
	private String eqNo = null;
	
	private String SN3ptyExpnTpCd = null;
	
	public EsdTpb0104Event(){}
	
	public void setSearchManualRegisterListVO(SearchManualRegisterListVO searchManualRegisterListVO){
		this. searchManualRegisterListVO = searchManualRegisterListVO;
	}

	public void setSearchManualRegisterListVOS(SearchManualRegisterListVO[] searchManualRegisterListVOs){
		this. searchManualRegisterListVOs = searchManualRegisterListVOs;
	}

	public SearchManualRegisterListVO getSearchManualRegisterListVO(){
		return searchManualRegisterListVO;
	}

	public SearchManualRegisterListVO[] getSearchManualRegisterListVOS(){
		return searchManualRegisterListVOs;
	}
	
	public CreateEACRegistrationVO getCreateEACRegistrationVO() {
		return createEACRegistrationVO;
	}

	public void setCreateEACRegistrationVO(CreateEACRegistrationVO createEACRegistrationVO) {
		this.createEACRegistrationVO = createEACRegistrationVO;
	}

	public CreateEACRegistrationVO[] getCreateEACRegistrationVOs() {
		return createEACRegistrationVOs;
	}

	public void setCreateEACRegistrationVOs(
			CreateEACRegistrationVO[] createEACRegistrationVOs) {
		this.createEACRegistrationVOs = createEACRegistrationVOs;
	}	
	
	public String getEqNo() {
		return eqNo;
	}

    public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
    
    public String getSN3ptyExpnTpCd() {
		return SN3ptyExpnTpCd;
	}

    public void setSN3ptyExpnTpCd(String SN3ptyExpnTpCd) {
		this.SN3ptyExpnTpCd = SN3ptyExpnTpCd;
	}

}