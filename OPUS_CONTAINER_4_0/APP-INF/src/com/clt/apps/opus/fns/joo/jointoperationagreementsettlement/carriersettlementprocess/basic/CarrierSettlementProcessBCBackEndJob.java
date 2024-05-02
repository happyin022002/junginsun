/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : StatusReportBCBackEndJob.java
 *@FileTitle : StatusReportBCBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.02.20 김
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrSettlementBackupReportVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrStandardFormatVO;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration business logic handling.<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.4
 */
public class CarrierSettlementProcessBCBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = 1L;
	private String pgmNo;
    private CntrSettlementBackupReportVO cntrSettlementBackupReportVO = null;
    private CntrConditionVO cntrConditionVO = null;
	private CntrStandardFormatVO[] cntrStandardFormatPreVOs = null;
	private CntrStandardFormatVO[] cntrStandardFormatSumVOs = null;
	
	/**
	 * Setting the screen ID<br>
	 * 
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * BackEndCommand Start<br>
	 * 
	 * @return Object
	 */
	public Object doStart() throws Exception {
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		//List<CntrSettlementBackupReportVO> cntrSettlementBackupReportVOs = null;
		Object obj = null;
		if (pgmNo.equals(JooConstants.BACKEND_JOB_PGM_FNS_JOO_0084)) { //"FNS_JOO_0084"
			obj = command.searchCntrForSettlementBackupReportData(cntrSettlementBackupReportVO);
		}else if(pgmNo.equals(JooConstants.BACKEND_JOB_PGM_FNS_JOO_0084_01)) { //"Standard format"
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			List<CntrStandardFormatVO> preList = new ArrayList<CntrStandardFormatVO>();
			List<CntrStandardFormatVO> sumList = new ArrayList<CntrStandardFormatVO>();
			if(cntrStandardFormatPreVOs != null){
				for(int i=0; i< cntrStandardFormatPreVOs.length; i++){
					preList.add((CntrStandardFormatVO) cntrStandardFormatPreVOs[i]);
				}
			}
			
			if(cntrStandardFormatSumVOs != null){
				for(int i=0; i< cntrStandardFormatSumVOs.length; i++){
					sumList.add((CntrStandardFormatVO) cntrStandardFormatSumVOs[i]);
				}
			}
			
			map.put("condition", cntrConditionVO);
			map.put("preList", preList);
			map.put("sumList", sumList);
			
			obj = map;
		}else if(pgmNo.equals("FNS_JOO_0084_02")) { //"Standard format" PreviousVoyageReport
			obj = command.searchCntrStandardFormatPreviousVoyageReportData(cntrConditionVO);
		}else if(pgmNo.equals("FNS_JOO_0084_03")) { //"Standard format" Summary Report
			obj = command.searchCntrStandardFormatReportData(cntrConditionVO);
		}
		return obj;
	}


	public void setCntrSettlementBackupReportVO(CntrSettlementBackupReportVO cntrSettlementBackupReportVO) {
		this.cntrSettlementBackupReportVO = cntrSettlementBackupReportVO;
	}

	public void setCntrConditionVO(CntrConditionVO cntrConditionVO) {
		this.cntrConditionVO = cntrConditionVO;
	}
	
	public void setCntrStandardFormatPreVOs(CntrStandardFormatVO[] cntrStandardFormatPreVOs) {
		if (cntrStandardFormatPreVOs != null) {
			CntrStandardFormatVO[] tmpVOs = new CntrStandardFormatVO[cntrStandardFormatPreVOs.length];
			System.arraycopy(cntrStandardFormatPreVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrStandardFormatPreVOs = tmpVOs;
		}
	}
	
	public void setCntrStandardFormatSumVOs(CntrStandardFormatVO[] cntrStandardFormatSumVOs) {
		if (cntrStandardFormatSumVOs != null) {
			CntrStandardFormatVO[] tmpVOs = new CntrStandardFormatVO[cntrStandardFormatSumVOs.length];
			System.arraycopy(cntrStandardFormatSumVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrStandardFormatSumVOs = tmpVOs;
		}
	}

}
