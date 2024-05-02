/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOModifyCorrectionSRWorkStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOModifyCorrectionSRWorkStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SR Amend Type이 'R' - Correction인 경우
	  * SR의 Work Status를 Y/Y/N/N으로 변경해 준다.
	  * </pre>
	  */
	public PerformanceReportDBDAOModifyCorrectionSRWorkStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifyCorrectionSRWorkStatusUSQL").append("\n"); 
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
		query.append("UPDATE BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("SET BL_DOC_INP_FLG = 'Y'," ).append("\n"); 
		query.append("    BL_RT_FLG = (SELECT NVL(BL_RT_FLG,'N') " ).append("\n"); 
		query.append("                 FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 AND SR_AMD_SEQ = (SELECT MAX(SR_AMD_SEQ) " ).append("\n"); 
		query.append("                                     FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                                    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                      AND BL_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("                                      AND BL_DRFT_FAX_OUT_FLG = 'Y')" ).append("\n"); 
		query.append("                 AND ROWNUM = 1)," ).append("\n"); 
		query.append("    BL_AUD_FLG = 'N'," ).append("\n"); 
		query.append("    BL_DRFT_FAX_OUT_FLG = 'N'" ).append("\n"); 
		query.append("WHERE SR_KND_CD = @[sr_knd_cd]" ).append("\n"); 
		query.append("AND SR_NO = @[sr_no]" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND SR_AMD_TP_CD = 'R'" ).append("\n"); 
		query.append("AND SR_AMD_SEQ = @[sr_amd_seq]" ).append("\n"); 

	}
}