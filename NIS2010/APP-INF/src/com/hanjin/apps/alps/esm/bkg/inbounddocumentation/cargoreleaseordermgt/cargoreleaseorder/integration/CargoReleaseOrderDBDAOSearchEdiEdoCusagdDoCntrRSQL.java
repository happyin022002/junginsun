/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.27 
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

public class CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Container 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoCntrRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoCntrRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_INFO'                                     || CHR(10)" ).append("\n"); 
		query.append("      ||'CNTR_NO:'       || CNTR_NO                     || CHR(10)" ).append("\n"); 
		query.append("      ||'CNTRTS_CD:'     || CNTR_TPSZ_CD                || CHR(10)" ).append("\n"); 
		query.append("      ||'FT_END_DT:'     || NVL(CRNT_DEM_FT_END_DT,' ') || CHR(10) /* 기존 부정확한 일자인  VPS_ETA_DT +Reefer는 + 5일, 기타 +8일로 전송 하던 것을  제공하지 않음 2018. 2.27 */" ).append("\n"); 
		query.append("      ||'OLD_FT_END_DT:' || NVL(PRE_DEM_FT_END_DT ,' ') || CHR(10)" ).append("\n"); 
		query.append("      ||'}CNTR_INFO'     || CHR(10)      " ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("   ( " ).append("\n"); 
		query.append("         SELECT  BCNTR.CNTR_NO       " ).append("\n"); 
		query.append("                ,BCNTR.CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("                ,PRE_DEM_FT_END_DT" ).append("\n"); 
		query.append("                ,CRNT_DEM_FT_END_DT" ).append("\n"); 
		query.append("        FROM    BKG_CONTAINER    BCNTR," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                  SELECT BKG_NO                                                     " ).append("\n"); 
		query.append("                        ,CNTR_NO                                                    " ).append("\n"); 
		query.append("                        ,DECODE( PRE_DEM_FT_END_DT, CRNT_DEM_FT_END_DT, '', PRE_DEM_FT_END_DT) PRE_DEM_FT_END_DT" ).append("\n"); 
		query.append("                        ,CRNT_DEM_FT_END_DT" ).append("\n"); 
		query.append("                  FROM (      " ).append("\n"); 
		query.append("                         SELECT  BKG_NO                                            AS BKG_NO   " ).append("\n"); 
		query.append("                                ,CNTR_NO                                           AS CNTR_NO  " ).append("\n"); 
		query.append("                                ,TO_CHAR(PRE_DEM_FT_END_DT,'YYYYMMDD')           AS PRE_DEM_FT_END_DT    " ).append("\n"); 
		query.append("                                ,TO_CHAR(CRNT_DEM_FT_END_DT,'YYYYMMDD')          AS CRNT_DEM_FT_END_DT    " ).append("\n"); 
		query.append("                                ,EDO_HIS_SEQ                                       AS EDO_HIS_SEQ" ).append("\n"); 
		query.append("                                ,MAX(EDO_HIS_SEQ) OVER (PARTITION BY CNTR.BKG_NO,CNTR.CNTR_NO ) AS MAX_EDO_HIS_SEQ      " ).append("\n"); 
		query.append("                              FROM BKG_EDO_DEM_HIS CNTR      " ).append("\n"); 
		query.append("                              WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                  ) WHERE EDO_HIS_SEQ= MAX_EDO_HIS_SEQ" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                )  DMT_CALC" ).append("\n"); 
		query.append("        WHERE   BCNTR.bkg_NO        = @[bkg_no]" ).append("\n"); 
		query.append("        AND     DMT_CALC.BKG_NO(+)  = BCNTR.BKG_NO" ).append("\n"); 
		query.append("        AND     DMT_CALC.CNTR_NO(+) = BCNTR.CNTR_NO " ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}