/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0080Event.java
*@FileTitle : Item Detail Management - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.20
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.20 윤세영
* 1.0 Creation
* 2010.08.16 윤진영 CHM-201005318 account_code와 account_name으로 조회가능하도록 수정
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event;

import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchMdmAccountCodeListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0080HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** acctCd Account Code */
	private String acctCd = "";
	private String acctGb = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMdmAccountCodeListVO searchmdmaccountcodelistvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchMdmAccountCodeListVO[] searchmdmaccountcodelistvos = null;

	public EsmFms0080Event(){}
	
	public void setSearchMdmAccountCodeListVO(SearchMdmAccountCodeListVO searchmdmaccountcodelistvo){
		this. searchmdmaccountcodelistvo = searchmdmaccountcodelistvo;
	}

	public void setSearchMdmAccountCodeListVOS(SearchMdmAccountCodeListVO[] searchmdmaccountcodelistvos){
		if (searchmdmaccountcodelistvos != null) {
			SearchMdmAccountCodeListVO[] tmpVOs = new SearchMdmAccountCodeListVO[searchmdmaccountcodelistvos.length];
			System.arraycopy(searchmdmaccountcodelistvos, 0, tmpVOs, 0, tmpVOs.length);
			this.searchmdmaccountcodelistvos = tmpVOs;
		}
	}

	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	public void setAcctGb(String acctGb) {
		this.acctGb = acctGb;
	}
	
	public SearchMdmAccountCodeListVO getSearchMdmAccountCodeListVO(){
		return searchmdmaccountcodelistvo;
	}

	public SearchMdmAccountCodeListVO[] getSearchMdmAccountCodeListVOS(){
		SearchMdmAccountCodeListVO[] tmpVOs = null;
		if (this.searchmdmaccountcodelistvos != null) {
			tmpVOs = new SearchMdmAccountCodeListVO[searchmdmaccountcodelistvos.length];
			System.arraycopy(searchmdmaccountcodelistvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public String getAcctCd() {
		return acctCd;
	}
	
	public String getAcctGb() {
		return acctGb;
	}

}