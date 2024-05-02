/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0053Event.java
*@FileTitle : Invoice Interface Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.20 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInterfaceStatusListVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see ESM_FMS_0053HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomInterfaceStatusVO customInterfaceStatusVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomInterfaceStatusVO[] customInterfaceStatusVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchInterfaceStatusVO condSearchInterfaceStatusVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInterfaceStatusListVO[] searchInterfaceStatusListVOs = null;

	/** CSR No */
	private String csrNo = null; 
	
	/** Apro Step */
	private String aproStep = null; 

	/** Status Flag */
	private String statusFlag = null;

	public EsmFms0053Event(){}
	
	public void setCustomInterfaceStatusVO(CustomInterfaceStatusVO customInterfaceStatusVO){
		this. customInterfaceStatusVO = customInterfaceStatusVO;
	}

	public void setCustomInterfaceStatusVOS(CustomInterfaceStatusVO[] customInterfaceStatusVOs){
		if (customInterfaceStatusVOs != null) {
			CustomInterfaceStatusVO[] tmpVOs = new CustomInterfaceStatusVO[customInterfaceStatusVOs.length];
			System.arraycopy(customInterfaceStatusVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customInterfaceStatusVOs = tmpVOs;
		}
	}

	public void setCondSearchInterfaceStatusVO(CondSearchInterfaceStatusVO condSearchInterfaceStatusVO){
		this. condSearchInterfaceStatusVO = condSearchInterfaceStatusVO;
	}

	public void setSearchInterfaceStatusListVOS(SearchInterfaceStatusListVO[] searchInterfaceStatusListVOs){
		if (searchInterfaceStatusListVOs != null) {
			SearchInterfaceStatusListVO[] tmpVOs = new SearchInterfaceStatusListVO[searchInterfaceStatusListVOs.length];
			System.arraycopy(searchInterfaceStatusListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchInterfaceStatusListVOs = tmpVOs;
		}
	}

	public void setCsrNo(String csrNo){
		this. csrNo = csrNo;
	}
	
	public void setAproStep(String aproStep){
		this. aproStep = aproStep;
	}
	
	public void setStatusFlag(String statusFlag){
		this. statusFlag = statusFlag;
	}

	public CustomInterfaceStatusVO getCustomInterfaceStatusVO(){
		return customInterfaceStatusVO;
	}

	public CustomInterfaceStatusVO[] getCustomInterfaceStatusVOS(){
		CustomInterfaceStatusVO[] rtnVOs = null;
		if (this.customInterfaceStatusVOs != null) {
			rtnVOs = new CustomInterfaceStatusVO[customInterfaceStatusVOs.length];
			System.arraycopy(customInterfaceStatusVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public CondSearchInterfaceStatusVO getCondSearchInterfaceStatusVO(){
		return condSearchInterfaceStatusVO;
	}

	public SearchInterfaceStatusListVO[] getSearchInterfaceStatusListVOS(){
		SearchInterfaceStatusListVO[] rtnVOs = null;
		if (this.searchInterfaceStatusListVOs != null) {
			rtnVOs = new SearchInterfaceStatusListVO[searchInterfaceStatusListVOs.length];
			System.arraycopy(searchInterfaceStatusListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public String getCsrNo(){
		return csrNo;
	}

	public String getAproStep(){
		return aproStep;
	}
	
	public String getStatusFlag(){
		return statusFlag;
	}

}