/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOcheckFinalConfirmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.02.24 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOcheckFinalConfirmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOcheckFinalConfirmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOcheckFinalConfirmRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT DECODE (NVL (A1.CORR_NO, 'N'), 'N', 'N', 'Y') AS CA_FLG," ).append("\n"); 
		query.append("       DECODE (NVL (A2.BKG_DOC_PROC_TP_CD, ''), 'CNTCFM', 'Y', 'N') AS CFM_FLG -- Y일 경우 삭제 불가" ).append("\n"); 
		query.append("  FROM BKG_BL_DOC A1," ).append("\n"); 
		query.append("       (SELECT BKG_NO," ).append("\n"); 
		query.append("               BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("          FROM (SELECT BKG_NO," ).append("\n"); 
		query.append("                       BKG_DOC_PROC_TP_CD," ).append("\n"); 
		query.append("                       DOC_PROC_SEQ," ).append("\n"); 
		query.append("                       EVNT_USR_ID," ).append("\n"); 
		query.append("                       EVNT_DT," ).append("\n"); 
		query.append("                       UPD_DT," ).append("\n"); 
		query.append("                       ROW_NUMBER() OVER (PARTITION BY BKG_NO ORDER BY UPD_DT DESC, ROWNUM DESC, ROWID DESC) AS ROW_NO" ).append("\n"); 
		query.append("                  FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BKG_DOC_PROC_TP_CD IN ('CNTCFM', 'CNTRLS')" ).append("\n"); 
		query.append("                   AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("         WHERE ROW_NO = 1) A2" ).append("\n"); 
		query.append(" WHERE A1.BKG_NO = A2.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A1.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}