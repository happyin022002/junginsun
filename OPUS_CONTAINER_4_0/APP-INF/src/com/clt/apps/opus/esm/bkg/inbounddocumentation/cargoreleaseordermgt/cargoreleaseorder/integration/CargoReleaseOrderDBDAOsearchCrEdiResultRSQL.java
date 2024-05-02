/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchCrEdiResultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchCrEdiResultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchCrEdiResultRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchCrEdiResultRSQL").append("\n"); 
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
		query.append("SELECT MAX(CGOR_EDI_SND_CD) AS CGOR_EDI_SND_CD, MAX(MAX_HIS_SEQ) AS HIS_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT CGOR_EDI_SND_CD, 0 MAX_HIS_SEQ" ).append("\n"); 
		query.append("        FROM BKG_CGO_RLSE_EDI_SND_LOG" ).append("\n"); 
		query.append("      WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("        AND LPAD(HIS_SEQ,3,'000')||" ).append("\n"); 
		query.append("            LPAD(HIS_DTL_SEQ,3,'000') = (" ).append("\n"); 
		query.append("                                            SELECT GREATEST(NVL(MAX(MAX_CR),'000000')," ).append("\n"); 
		query.append("                                                    NVL(MAX(MAX_CA),'000000'))" ).append("\n"); 
		query.append("                                              FROM (" ).append("\n"); 
		query.append("                                                    SELECT MAX(LPAD(HIS_SEQ,3,'000')||LPAD(HIS_DTL_SEQ,3,'000')) MAX_CR," ).append("\n"); 
		query.append("                                                           '' MAX_CA" ).append("\n"); 
		query.append("                                                      FROM BKG_CGO_RLSE_EDI_SND_LOG" ).append("\n"); 
		query.append("                                                     WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                       AND CGOR_EDI_MSG_ID = 'CR'" ).append("\n"); 
		query.append("                                                       AND CGOR_EDI_SCS_FLG = 'Y'" ).append("\n"); 
		query.append("                                                       AND CGOR_EDI_RCVR_TP_CD = 'L'" ).append("\n"); 
		query.append("                                                    UNION ALL" ).append("\n"); 
		query.append("                                                    SELECT ''," ).append("\n"); 
		query.append("                                                           MAX(LPAD(HIS_SEQ,3,'000')||LPAD(HIS_DTL_SEQ,3,'000'))" ).append("\n"); 
		query.append("                                                      FROM BKG_CGO_RLSE_EDI_SND_LOG" ).append("\n"); 
		query.append("                                                     WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                       AND CGOR_EDI_MSG_ID = 'CA'" ).append("\n"); 
		query.append("                                                       AND CGOR_EDI_SCS_FLG = 'Y'" ).append("\n"); 
		query.append("                                                       AND CGOR_EDI_RCVR_TP_CD = 'L'" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '', MAX(HIS_SEQ)" ).append("\n"); 
		query.append("    FROM BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("    WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}