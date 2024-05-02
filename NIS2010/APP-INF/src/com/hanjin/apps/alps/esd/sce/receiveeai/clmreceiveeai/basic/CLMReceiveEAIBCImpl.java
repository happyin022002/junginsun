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
package com.hanjin.apps.alps.esd.sce.receiveeai.clmreceiveeai.basic;

import java.util.ArrayList;
import java.util.HashMap;

import com.hanjin.apps.alps.esd.sce.receiveeai.clmreceiveeai.integration.CLMReceiveEAIDBDAO;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.event.EsdSce0150Event;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
/**
 * ENIS-SCEM EDI Clm Message
 * - ENIS-SCEM EDI Clm Message에 대한 비지니스 로직에 대한 인터페이스
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

		//Event eventResponse = new EsdSce0150Event();
		java.io.BufferedReader br = null;
		ArrayList paramArrLst = new ArrayList();
		HashMap hm = null;

		try {
			br = new java.io.BufferedReader(new java.io.StringReader(str));
			String buffer = null;
			String sndrId = null;
			// 문자열 파싱
			while ((buffer = br.readLine()) != null) {
				hm = new HashMap();
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

						log
								.info("\n==========Impl CLM  START=================================\n"
										+ " MSG_PREFIX: "
										+ hm.get("MSG_PREFIX")
										+ "\n"
										+ " TR_DATE: "
										+ hm.get("TR_DATE")
										+ "\n"
										+ " CLM_CRR_NM: "
										+ hm.get("CLM_CRR_NM")
										+ "\n"
										+ " FULL_MTY_CD: "
										+ hm.get("FULL_MTY_CD")
										+ "\n"
										+ " CNTR_NO: "
										+ hm.get("CNTR_NO")
										+ "\n"
										+ " DEP_DT: "
										+ hm.get("DEP_DT")
										+ "\n"
										+ " TRSP_MOD_TP_CD: "
										+ hm.get("TRSP_MOD_TP_CD")
										+ "\n"
										+ " FCAR_NO: "
										+ hm.get("FCAR_NO")
										+ "\n"
										+ " ARR_DT: "
										+ hm.get("ARR_DT")
										+ "\n"
										+ " CLM_SGHT_CD: "
										+ hm.get("CLM_SGHT_CD")
										+ "\n"
										+ " TRN_NO: "
										+ hm.get("TRN_NO")
										+ "\n"
										+ " ARR_LOC_NM: "
										+ hm.get("ARR_LOC_NM")
										+ "\n"
										+ " DEP_LOC_NM: "
										+ hm.get("DEP_LOC_NM")
										+ "\n"
										+ " ARR_STE_CD: "
										+ hm.get("ARR_STE_CD")
										+ "\n"
										+ " DEP_STE_CD: "
										+ hm.get("DEP_STE_CD")
										+ "\n"
										+ " ARR_SPLC_CD: "
										+ hm.get("ARR_SPLC_CD")
										+ "\n"
										+ " DEP_SPLC_CD: "
										+ hm.get("DEP_SPLC_CD")
										+ "\n"
										+ " SNDR_ID: "
										+ hm.get("SNDR_ID")
										+ "\n"
										+ "==========CLM  END================================="
										+ "\n" + "\n" + "");
						paramArrLst.add(hm);
					}
				}

			}
			// br.close();

			/*
			 * ((EsdSce0085EventResponse)eventResponse).setHDR(HDR);
			 * ((EsdSce0085EventResponse)eventResponse).setCNTR(CNTR);
			 * ((EsdSce0085EventResponse)eventResponse).setLOC(LOC);
			 */

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
		// return eventResponse;
	}
 
	/**
	 * create EDI CLM Temp Data
	 * 
	 * @param totalParamArrLst ArrayList 
	 */
	public void createEDIClmTmpData(ArrayList totalParamArrLst) { 
		try {
			dbDao.createEDIClmTmpData(totalParamArrLst);	
		} catch(DAOException e){
			log.error(e.getMessage());
			// throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			// throw new EventException(e.getMessage());
		}
	}	

	
}
