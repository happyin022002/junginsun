/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchCopToRcvTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.12
*@LastModifier : Yoo
*@LastVersion : 1.0
* 2014.03.12 Yoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchCopToRcvTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container 가 detach 되거나 cancel 될 COP 의 tro 정보를 대신 관리할 cop 를 선정한다.
	  * 선정 기준 :
	  * 1. cancel 되지 않음
	  * 2. container 가 존재하는 것이 1순위, 없는 것이 후순위
	  * 3. ob tro 와 무관할것
	  * 4. flex height 를 감안하여 호환 가능한 tpsz 를 가진 cop
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchCopToRcvTroRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchCopToRcvTroRSQL").append("\n"); 
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
		query.append("SELECT COP_NO," ).append("\n"); 
		query.append("  BKG_NO," ).append("\n"); 
		query.append("  COP_STS_CD," ).append("\n"); 
		query.append("  OB_TRO_FLG," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  CFM_OB_DOR_ARR_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT A.COP_NO," ).append("\n"); 
		query.append("      A.BKG_NO," ).append("\n"); 
		query.append("      A.COP_STS_CD," ).append("\n"); 
		query.append("      A.OB_TRO_FLG," ).append("\n"); 
		query.append("      A.CNTR_NO," ).append("\n"); 
		query.append("	  TO_CHAR(M.CFM_OB_DOR_ARR_DT, 'YYYYMMDDHH24MISS') AS CFM_OB_DOR_ARR_DT" ).append("\n"); 
		query.append("    FROM SCE_COP_HDR A," ).append("\n"); 
		query.append("      BKG_BOOKING B," ).append("\n"); 
		query.append("      SCE_COP_HDR M" ).append("\n"); 
		query.append("    WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND A.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("      AND M.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("      AND A.COP_STS_CD != 'X'" ).append("\n"); 
		query.append("      AND A.OB_TRO_FLG = 'N'" ).append("\n"); 
		query.append("	  AND M.OB_TRO_FLG = 'Y'" ).append("\n"); 
		query.append("      AND (CASE WHEN NVL(B.FLEX_HGT_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("          AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("            SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            FROM SCE_COP_CNTR_REPO_RULE" ).append("\n"); 
		query.append("            WHERE (CNTR_TPSZ_CD = M.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  OR PROV_CNTR_TPSZ_CD = M.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("              AND NVL(ACT_FLG, 'N') = 'Y') THEN 'TRUE' WHEN NVL(B.FLEX_HGT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("          AND A.CNTR_TPSZ_CD = M.CNTR_TPSZ_CD THEN 'TRUE' ELSE 'FALSE' END) = 'TRUE'" ).append("\n"); 
		query.append("    ORDER BY DECODE(A.CNTR_NO, 'COMU0000000', 2, 1) )" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("COP_STS_CD != 'X'" ).append("\n"); 
		query.append("AND CNTR_NO != 'COMU0000000'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}