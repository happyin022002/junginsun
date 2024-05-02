/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchInlndEdiResultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.14 
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

public class CargoReleaseOrderDBDAOsearchInlndEdiResultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland에 나간 EDI 결과 찾기
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchInlndEdiResultRSQL(){
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
		query.append("FileName : CargoReleaseOrderDBDAOsearchInlndEdiResultRSQL").append("\n"); 
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
		query.append("SELECT MAX(INLND_YD_EDI_SND_CD) AS INLND_YD_EDI_SND_CD" ).append("\n"); 
		query.append("        FROM BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("      WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("        AND LPAD(HIS_SEQ,3,'000') =     (SELECT GREATEST(NVL(MAX(MAX_CR),'000000')," ).append("\n"); 
		query.append("                                                    NVL(MAX(MAX_CA),'000000'))" ).append("\n"); 
		query.append("                                              FROM (" ).append("\n"); 
		query.append("                                                    SELECT MAX(LPAD(HIS_SEQ,3,'000')) MAX_CR," ).append("\n"); 
		query.append("                                                           '' MAX_CA" ).append("\n"); 
		query.append("                                                      FROM BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("                                                     WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                       AND INLND_YD_EDI_SND_CD = 'R'" ).append("\n"); 
		query.append("                                                    UNION ALL" ).append("\n"); 
		query.append("                                                    SELECT '' MAX_CR," ).append("\n"); 
		query.append("                                                           MAX(LPAD(HIS_SEQ,3,'000')) MAX_CA" ).append("\n"); 
		query.append("                                                      FROM BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("                                                     WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                       AND INLND_YD_EDI_SND_CD = 'A'" ).append("\n"); 
		query.append("                                                   ))" ).append("\n"); 

	}
}