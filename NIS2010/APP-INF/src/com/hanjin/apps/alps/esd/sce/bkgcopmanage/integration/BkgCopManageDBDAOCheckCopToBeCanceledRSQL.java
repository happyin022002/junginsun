/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgCopManageDBDAOCheckCopToBeCanceledRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.10
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.01.10 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOCheckCopToBeCanceledRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container detach 될 때 호출하여 COP 가 bkg qty 보다 더 초과되어 존재할 경우에는 container detach 된 COP 를 cancel 시킨다.
	  * </pre>
	  */
	public BkgCopManageDBDAOCheckCopToBeCanceledRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOCheckCopToBeCanceledRSQL").append("\n"); 
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
		query.append("WITH RMN_COP AS (" ).append("\n"); 
		query.append("    SELECT A.BKG_NO," ).append("\n"); 
		query.append("      B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("      COUNT(*) AS CNTR_QTY" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT BKG_NO," ).append("\n"); 
		query.append("          COP_NO," ).append("\n"); 
		query.append("          CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        FROM SCE_COP_HDR" ).append("\n"); 
		query.append("        WHERE COP_NO = @[cop_no]) A," ).append("\n"); 
		query.append("      SCE_COP_HDR B," ).append("\n"); 
		query.append("      BKG_BOOKING C," ).append("\n"); 
		query.append("      SCE_COP_CNTR_REPO_RULE D" ).append("\n"); 
		query.append("    WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("      AND A.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD (+)" ).append("\n"); 
		query.append("      AND B.COP_NO != @[cop_no]" ).append("\n"); 
		query.append("      AND B.COP_STS_CD != 'X'" ).append("\n"); 
		query.append("      AND (CASE WHEN C.FLEX_HGT_FLG = 'Y'" ).append("\n"); 
		query.append("          AND B.CNTR_TPSZ_CD = D.PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          AND A.CNTR_TPSZ_CD != B.CNTR_TPSZ_CD THEN 'TRUE' WHEN A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD THEN 'TRUE' ELSE 'FALSE' END) = 'TRUE'" ).append("\n"); 
		query.append("    GROUP BY A.BKG_NO, B.CNTR_TPSZ_CD ) " ).append("\n"); 
		query.append("SELECT CASE WHEN SUM(CEIL(B.OP_CNTR_QTY)) <= MAX(D.SUM_CNTR_QTY) THEN 'CANCEL' ELSE 'REMAIN' END AS CHK_RSLT" ).append("\n"); 
		query.append("FROM BKG_QUANTITY B," ).append("\n"); 
		query.append("  RMN_COP C," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT SUM(CNTR_QTY) AS SUM_CNTR_QTY" ).append("\n"); 
		query.append("    FROM RMN_COP) D" ).append("\n"); 
		query.append("WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("  AND B.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 

	}
}