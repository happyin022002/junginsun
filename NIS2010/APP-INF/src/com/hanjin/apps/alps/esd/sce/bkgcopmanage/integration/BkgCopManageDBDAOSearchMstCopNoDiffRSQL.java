/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchMstCopNoDiffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.18 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchMstCopNoDiffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MASTER COP NO 가 잘못 할당된 경우를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchMstCopNoDiffRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchMstCopNoDiffRSQL").append("\n"); 
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
		query.append("SELECT BKG_No," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  CNMV_YR," ).append("\n"); 
		query.append("  COP_NO," ).append("\n"); 
		query.append("  COP_STS_CD," ).append("\n"); 
		query.append("  PCTL_NO," ).append("\n"); 
		query.append("  MST_COP_NO," ).append("\n"); 
		query.append("  TRNK_VSL_CD," ).append("\n"); 
		query.append("  TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("  TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("  POR_NOD_CD," ).append("\n"); 
		query.append("  POL_NOD_CD," ).append("\n"); 
		query.append("  POD_NOD_CD," ).append("\n"); 
		query.append("  DEL_NOD_CD," ).append("\n"); 
		query.append("  IB_TRO_FLG," ).append("\n"); 
		query.append("  OB_TRO_FLG," ).append("\n"); 
		query.append("  COP_UPD_RMK" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE (CNTR_NO," ).append("\n"); 
		query.append("      TRNK_VSL_CD," ).append("\n"); 
		query.append("      TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("      TRNK_SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("    SELECT CNTR_NO," ).append("\n"); 
		query.append("      TRNK_VSL_CD," ).append("\n"); 
		query.append("      TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("      TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT MST_COP_NO," ).append("\n"); 
		query.append("          CNTR_NO," ).append("\n"); 
		query.append("          TRNK_VSL_CD," ).append("\n"); 
		query.append("          TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("          TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("        FROM BKG_BOOKING A," ).append("\n"); 
		query.append("          SCE_COP_HDR B" ).append("\n"); 
		query.append("        WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("          AND B.COP_STS_CD IN ('C'," ).append("\n"); 
		query.append("              'T'," ).append("\n"); 
		query.append("              'F')" ).append("\n"); 
		query.append("          AND A.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD') AND TO_DATE(@[to_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("          AND B.CNTR_NO != 'SMCU0000000' )" ).append("\n"); 
		query.append("    GROUP BY CNTR_NO, TRNK_VSL_CD, TRNK_SKD_VOY_NO, TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("    HAVING COUNT(*) >= 2 )" ).append("\n"); 
		query.append("  AND COP_STS_cD IN ('C'," ).append("\n"); 
		query.append("      'T'," ).append("\n"); 
		query.append("      'F')" ).append("\n"); 
		query.append("  AND CNTR_NO != 'SMCU0000000'" ).append("\n"); 
		query.append("ORDER BY BKG_NO, CNTR_NO, TRNK_VSL_CD, TRNK_SKD_VOY_NO, TRNK_SKD_DIR_CD" ).append("\n"); 

	}
}