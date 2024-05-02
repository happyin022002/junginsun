/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EdiClmReceiveBCImpl.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-01
*@LastModifier : 
*@LastVersion : 1.0
* 2009-11-01
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.clmreceiveeai.basic;

import java.util.ArrayList;
import java.util.HashMap;

import com.clt.apps.opus.esd.sce.receiveeai.clmreceiveeai.integration.CLMReceiveEAIDBDAO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * SCEM EDI Clm Message
 * - SCEM EDI Clm Message에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author 
 * @see 
 * @since J2EE 1.4
 */
public class CLMReceiveEAIBCImpl   extends BasicCommandSupport implements CLMReceiveEAIBC {
	 
	// Database Access Object
	private transient CLMReceiveEAIDBDAO dbDao=null;
	/**
	 * Edi214ReceiveBCImpl 생성자
	 */	
    public CLMReceiveEAIBCImpl(){
        dbDao = new CLMReceiveEAIDBDAO();
    }
    
    /**
	 * Clm MSG를 FF에서 분리
	 * 
	 * @param String str
	 * @exception EventException
	 */
	public void getEDIClmDataFormat(String str) throws EventException {
		java.io.BufferedReader br = null;
		ArrayList<HashMap<String, String>> paramArrLst = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hm = null;

		try {
			br = new java.io.BufferedReader(new java.io.StringReader(str));
			String buffer = null;
			String sndrId = "";
			// 문자열 파싱
			while ((buffer = br.readLine()) != null) {
				hm = new HashMap<String, String>();
				if (buffer != null && !buffer.trim().equals("")) {
					if (buffer.trim().startsWith("$$$MSGSTART:")) {
						// MSGSTART =
						// buffer!=null&&!buffer.trim().equals("")&&buffer.length()>=("$$$MSGSTART:".length()+20)?buffer.substring(12,32).trim():"";
						sndrId = buffer.substring(12, 32); // Sender TP ID
					} else {
						hm.put("MSG_PREFIX", buffer.substring(0, 22));
						hm.put("TR_DATE", buffer.substring(22, 37));
						hm.put("CLM_CRR_NM", buffer.substring(37, 66));
						hm.put("FULL_MTY_CD", buffer.substring(66, 68));
						hm.put("CNTR_NO", buffer.substring(68, 78));
						hm.put("DEP_DT", buffer.substring(82, 96));
						hm.put("TRSP_MOD_TP_CD", buffer.substring(176, 177));
						hm.put("FCAR_NO", buffer.substring(177, 187));
						hm.put("ARR_DT", buffer.substring(215, 229));
						hm.put("CLM_SGHT_CD", buffer.substring(234, 235));
						hm.put("TRN_NO", buffer.substring(235, 247));
						hm.put("ARR_LOC_NM", buffer.substring(247, 256));
						hm.put("DEP_LOC_NM", buffer.substring(259, 268));
						hm.put("ARR_STE_CD", buffer.substring(271, 273));
						hm.put("DEP_STE_CD", buffer.substring(273, 275));
						hm.put("ARR_SPLC_CD", buffer.substring(275, 281));
						// 마지막 변수인 DEP_SPLC_CD 가 가변적인 경우 처리로직
						if (buffer.length() < 287) {
							if (buffer.length() < 282) {
								log.debug(" buffer.length() < 282 ");
							} else {
								hm.put("DEP_SPLC_CD", buffer.substring(281));
							}
						} else {
							hm.put("DEP_SPLC_CD", buffer.substring(281, 287));
						}
						hm.put("SNDR_ID", sndrId);

						if(log.isInfoEnabled()) {
							StringBuilder sb = new StringBuilder();
							sb.append("\n==========Impl CLM  START=================================\n")
							  .append(" MSG_PREFIX: "    ).append(hm.get("MSG_PREFIX")    ).append("\n")
							  .append(" TR_DATE: "       ).append(hm.get("TR_DATE")       ).append("\n")
							  .append(" CLM_CRR_NM: "    ).append(hm.get("CLM_CRR_NM")    ).append("\n")
							  .append(" FULL_MTY_CD: "   ).append(hm.get("FULL_MTY_CD")   ).append("\n")
							  .append(" CNTR_NO: "       ).append(hm.get("CNTR_NO")       ).append("\n")
							  .append(" DEP_DT: "        ).append(hm.get("DEP_DT")        ).append("\n")
							  .append(" TRSP_MOD_TP_CD: ").append(hm.get("TRSP_MOD_TP_CD")).append("\n")
							  .append(" FCAR_NO: "       ).append(hm.get("FCAR_NO")       ).append("\n")
							  .append(" ARR_DT: "        ).append(hm.get("ARR_DT")        ).append("\n")
							  .append(" CLM_SGHT_CD: "   ).append(hm.get("CLM_SGHT_CD")   ).append("\n")
							  .append(" TRN_NO: "        ).append(hm.get("TRN_NO")        ).append("\n")
							  .append(" ARR_LOC_NM: "    ).append(hm.get("ARR_LOC_NM")    ).append("\n")
							  .append(" DEP_LOC_NM: "    ).append(hm.get("DEP_LOC_NM")    ).append("\n")
							  .append(" ARR_STE_CD: "    ).append(hm.get("ARR_STE_CD")    ).append("\n")
							  .append(" DEP_STE_CD: "    ).append(hm.get("DEP_STE_CD")    ).append("\n")
							  .append(" ARR_SPLC_CD: "   ).append(hm.get("ARR_SPLC_CD")   ).append("\n")
							  .append(" DEP_SPLC_CD: "   ).append(hm.get("DEP_SPLC_CD")   ).append("\n")
							  .append(" SNDR_ID: "       ).append(hm.get("SNDR_ID")       ).append("\n")
							  .append("==========Impl CLM  END  =================================\n\n");
							
							log.info(sb.toString());
						}
						paramArrLst.add(hm);
					}
				}

			}

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (java.io.IOException ie) {
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
		}
		createEDIClmTmpData(paramArrLst);
	}
 
	/**
	 * create EDI CLM Temp Data
	 * 
	 * @param totalParamArrLst ArrayList 
	 */
	@SuppressWarnings( "rawtypes" )
	public void createEDIClmTmpData(ArrayList totalParamArrLst) { 
		try {
			dbDao.createEDIClmTmpData(totalParamArrLst);	
		} catch(DAOException e){
			log.error(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
		}
	}	

	
}
