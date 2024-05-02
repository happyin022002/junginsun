/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOSearchReapplyBKGListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.01
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.04.01 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOSearchReapplyBKGListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Standby 상태의 BKG  LIST
	  * </pre>
	  */
	public ConstraintMasterDBDAOSearchReapplyBKGListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSearchReapplyBKGListRSQL").append("\n"); 
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
		query.append("SELECT V.TRD_CD" ).append("\n"); 
		query.append("     , V.RLANE_CD" ).append("\n"); 
		query.append("     , V.IOC_CD" ).append("\n"); 
		query.append("     , V.VSL_CD" ).append("\n"); 
		query.append("     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("     , V.DIR_CD" ).append("\n"); 
		query.append("     , V.COST_YRMON" ).append("\n"); 
		query.append("     , V.COST_WK" ).append("\n"); 
		query.append("     , V.SLS_YRMON" ).append("\n"); 
		query.append("     , SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK SLS_WK" ).append("\n"); 
		query.append("     , B.BKG_NO" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD V, BKG_BOOKING B" ).append("\n"); 
		query.append(" WHERE SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK IN (" ).append("\n"); 
		query.append("                                              SELECT COST_YR||COST_WK" ).append("\n"); 
		query.append("                                              FROM MAS_WK_PRD PRD1" ).append("\n"); 
		query.append("                                              WHERE PRD1.COST_YR||PRD1.COST_WK >= " ).append("\n"); 
		query.append("                                               (SELECT PRD.COST_YR || TO_CHAR(CEIL((TO_CHAR(SYSDATE + ( 7 * 1 ), 'DDD') + 7 - TO_CHAR(TO_DATE(PRD.SLS_TO_DT, 'YYYYMMDD'), 'DDD')) / 7), 'FM00') AS COST_WK" ).append("\n"); 
		query.append("                                                 FROM MAS_WK_PRD PRD" ).append("\n"); 
		query.append("                                                WHERE PRD.COST_YR = TO_CHAR(SYSDATE + ( 7 * 1 ), 'YYYY')" ).append("\n"); 
		query.append("                                                AND PRD.COST_WK = '01' )" ).append("\n"); 
		query.append("                                              AND ROWNUM <= 8)" ).append("\n"); 
		query.append("   AND V.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND V.DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD IN ('W', 'F')" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("   AND B.ALOC_STS_CD = 'S'" ).append("\n"); 
		query.append("   order by SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK" ).append("\n"); 

	}
}
