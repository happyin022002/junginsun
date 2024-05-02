/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOaddEdiEdoDmtFtimeHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOaddEdiEdoDmtFtimeHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KT-NET EDI 전송 시 DMIF_END_DT History 정보를 관리한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOaddEdiEdoDmtFtimeHisCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOaddEdiEdoDmtFtimeHisCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EDO_DEM_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  A.BKG_NO" ).append("\n"); 
		query.append("          , A.CNTR_NO" ).append("\n"); 
		query.append("          , ( SELECT NVL(MAX(EDO_HIS_SEQ)+ 1, 1) FROM BKG_EDO_DEM_HIS WHERE BKG_NO =A.BKG_NO AND CNTR_NO= A.CNTR_NO )" ).append("\n"); 
		query.append("          , B.PRE_DMIF_END_DT" ).append("\n"); 
		query.append("          , A.CURR_DMIF_END_DT" ).append("\n"); 
		query.append("          , NULL" ).append("\n"); 
		query.append("          , @[cre_usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          , @[upd_usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("            SELECT  @[bkg_no]                                          AS BKG_NO" ).append("\n"); 
		query.append("                   ,@[cntr_no]                                         AS CNTR_NO" ).append("\n"); 
		query.append("                   ,TO_DATE(@[ft_end_dt],'YYYY/MM/DD')                 AS CURR_DMIF_END_DT" ).append("\n"); 
		query.append("            FROM  DUAL" ).append("\n"); 
		query.append("      ) A, " ).append("\n"); 
		query.append("      (  " ).append("\n"); 
		query.append("         SELECT  BKG_NO                                                     " ).append("\n"); 
		query.append("               , CNTR_NO                                                    " ).append("\n"); 
		query.append("               , PRE_DMIF_END_DT" ).append("\n"); 
		query.append("         FROM (      " ).append("\n"); 
		query.append("               SELECT  BKG_NO                                          AS BKG_NO   " ).append("\n"); 
		query.append("                     , CNTR_NO                                         AS CNTR_NO  " ).append("\n"); 
		query.append("                     , CRNT_DEM_FT_END_DT                              AS PRE_DMIF_END_DT    " ).append("\n"); 
		query.append("                     , EDO_HIS_SEQ                                     AS EDO_HIS_SEQ" ).append("\n"); 
		query.append("                     , MAX(EDO_HIS_SEQ) OVER (PARTITION " ).append("\n"); 
		query.append("                                        BY CNTR.BKG_NO, CNTR.CNTR_NO ) AS MAX_EDO_HIS_SEQ      " ).append("\n"); 
		query.append("              FROM BKG_EDO_DEM_HIS CNTR      " ).append("\n"); 
		query.append("              WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND   CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         ) WHERE EDO_HIS_SEQ= MAX_EDO_HIS_SEQ" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("     WHERE B.BKG_NO(+) = A.BKG_NO " ).append("\n"); 
		query.append("	 AND   B.CNTR_NO(+) = A.CNTR_NO" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}