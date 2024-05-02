/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0081Event.java
*@FileTitle : Loading Port Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.25 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrSettlementBackupReportVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrStandardFormatVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0084 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0084HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0084HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0084Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrSettlementBackupReportVO cntrSettlementBackupReportVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrSettlementBackupReportVO[] cntrSettlementBackupReportVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrConditionVO cntrConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrStandardFormatVO cntrStandardFormatVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrStandardFormatVO[] cntrStandardFormatVOs = null;
	
	private CntrStandardFormatVO[] cntrStandardFormatPreVOs = null;
	
	private CntrStandardFormatVO[] cntrStandardFormatSumVOs = null;

	public FnsJoo0084Event(){}
	
	private String key = "";

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public CntrSettlementBackupReportVO getCntrSettlementBackupReportVO() {
		return cntrSettlementBackupReportVO;
	}

	public void setCntrSettlementBackupReportVO(CntrSettlementBackupReportVO cntrSettlementBackupReportVO) {
		this.cntrSettlementBackupReportVO = cntrSettlementBackupReportVO;
	}

	public CntrSettlementBackupReportVO[] getCntrSettlementBackupReportVOs() {
		CntrSettlementBackupReportVO[] tmpVOs = null;
		if (this.cntrSettlementBackupReportVOs != null) {
			tmpVOs = new CntrSettlementBackupReportVO[cntrSettlementBackupReportVOs.length];
			System.arraycopy(cntrSettlementBackupReportVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCntrSettlementBackupReportVOs(CntrSettlementBackupReportVO[] cntrSettlementBackupReportVOs) {
		if (cntrSettlementBackupReportVOs != null) {
			CntrSettlementBackupReportVO[] tmpVOs = new CntrSettlementBackupReportVO[cntrSettlementBackupReportVOs.length];
			System.arraycopy(cntrSettlementBackupReportVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrSettlementBackupReportVOs = tmpVOs;
		}
	}

	public CntrConditionVO getCntrConditionVO() {
		return cntrConditionVO;
	}

	public void setCntrConditionVO(CntrConditionVO cntrConditionVO) {
		this.cntrConditionVO = cntrConditionVO;
	}

	public CntrStandardFormatVO getCntrStandardFormatVO() {
		return cntrStandardFormatVO;
	}

	public void setCntrStandardFormatVO(CntrStandardFormatVO cntrStandardFormatVO) {
		this.cntrStandardFormatVO = cntrStandardFormatVO;
	}

	public CntrStandardFormatVO[] getCntrStandardFormatVOs() {
		CntrStandardFormatVO[] tmpVOs = null;
		if (this.cntrStandardFormatVOs != null) {
			tmpVOs = new CntrStandardFormatVO[cntrStandardFormatVOs.length];
			System.arraycopy(cntrStandardFormatVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setCntrStandardFormatVOs(CntrStandardFormatVO[] cntrStandardFormatVOs) {
		if (cntrStandardFormatVOs != null) {
			CntrStandardFormatVO[] tmpVOs = new CntrStandardFormatVO[cntrStandardFormatVOs.length];
			System.arraycopy(cntrStandardFormatVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrStandardFormatVOs = tmpVOs;
		}
	}

	public void setCntrStandardFormatPreVOs(CntrStandardFormatVO[] cntrStandardFormatPreVOs) {
		if (cntrStandardFormatPreVOs != null) {
			CntrStandardFormatVO[] tmpVOs = new CntrStandardFormatVO[cntrStandardFormatPreVOs.length];
			System.arraycopy(cntrStandardFormatPreVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrStandardFormatPreVOs = tmpVOs;
		}
	}	

	public CntrStandardFormatVO[] getCntrStandardFormatPreVOs() {
		CntrStandardFormatVO[] tmpVOs = null;
		if (this.cntrStandardFormatPreVOs != null) {
			tmpVOs = new CntrStandardFormatVO[cntrStandardFormatPreVOs.length];
			System.arraycopy(cntrStandardFormatPreVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCntrStandardFormatSumVOs(CntrStandardFormatVO[] cntrStandardFormatSumVOs) {
		if (cntrStandardFormatSumVOs != null) {
			CntrStandardFormatVO[] tmpVOs = new CntrStandardFormatVO[cntrStandardFormatSumVOs.length];
			System.arraycopy(cntrStandardFormatSumVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrStandardFormatSumVOs = tmpVOs;
		}
	}	
	
	public CntrStandardFormatVO[] getCntrStandardFormatSumVOs() {
		CntrStandardFormatVO[] tmpVOs = null;
		if (this.cntrStandardFormatSumVOs != null) {
			tmpVOs = new CntrStandardFormatVO[cntrStandardFormatSumVOs.length];
			System.arraycopy(cntrStandardFormatSumVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	

}