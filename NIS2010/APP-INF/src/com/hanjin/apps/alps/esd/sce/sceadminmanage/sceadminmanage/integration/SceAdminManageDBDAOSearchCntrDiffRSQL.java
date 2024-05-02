/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SceAdminManageDBDAOSearchCntrDiffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.24 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOSearchCntrDiffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking 과 cop 의 container diff 를 조회한다.
	  * </pre>
	  */
	public SceAdminManageDBDAOSearchCntrDiffRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOSearchCntrDiffRSQL").append("\n"); 
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
		query.append("SELECT 'Container Attach' AS BKG_EVNT_RMK," ).append("\n"); 
		query.append("  'CA' AS BKG_EVNT_TP_CD," ).append("\n"); 
		query.append("  B.BKG_NO," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  B.cre_dt as bkg_cre_dt," ).append("\n"); 
		query.append("  A.CRE_DT," ).append("\n"); 
		query.append("  SI_FLG," ).append("\n"); 
		query.append("  XTER_SI_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING B," ).append("\n"); 
		query.append("  BKG_CONTAINER A" ).append("\n"); 
		query.append("WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("  AND A.CRE_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD') AND TO_DATE(@[to_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("  AND B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("  AND nvl(B.SPLIT_RSN_CD, 'N')  <> 'M'" ).append("\n"); 
		query.append("  AND B.BKG_STS_CD NOT IN ('X')" ).append("\n"); 
		query.append("  AND NOT EXISTS (" ).append("\n"); 
		query.append("    SELECT '1'" ).append("\n"); 
		query.append("    FROM SCE_COP_HDR" ).append("\n"); 
		query.append("    WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("--      AND CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      AND CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("      AND COP_STS_CD != 'X')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Container Detach' AS BKG_EVNT_RMK," ).append("\n"); 
		query.append("  'CD' AS BKG_EVNT_TP_CD," ).append("\n"); 
		query.append("  B.BKG_NO," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  B.cre_dt as bkg_cre_dt," ).append("\n"); 
		query.append("  A.CRE_DT," ).append("\n"); 
		query.append("  SI_FLG," ).append("\n"); 
		query.append("  XTER_SI_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING B," ).append("\n"); 
		query.append("  SCE_COP_HDR A" ).append("\n"); 
		query.append("WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("  AND B.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD') AND TO_DATE(@[to_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("  AND B.BKG_STS_CD NOT IN ('X')" ).append("\n"); 
		query.append("  AND A.COP_STS_CD != 'X'" ).append("\n"); 
		query.append("  AND A.CNTR_NO != 'SMCU0000000'" ).append("\n"); 
		query.append("  AND NOT EXISTS (" ).append("\n"); 
		query.append("    SELECT '1'" ).append("\n"); 
		query.append("    FROM BKG_CONTAINER" ).append("\n"); 
		query.append("    WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("      AND CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("      AND NVL(CNTR_DELT_FLG, 'N') = 'N')" ).append("\n"); 

	}
}