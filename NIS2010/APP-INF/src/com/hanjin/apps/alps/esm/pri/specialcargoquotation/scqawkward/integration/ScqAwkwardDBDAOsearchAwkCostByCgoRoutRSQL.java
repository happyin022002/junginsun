/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOsearchAwkCostByCgoRoutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.25
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.04.25 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOsearchAwkCostByCgoRoutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo - Route 별 비용 리스트
	  * </pre>
	  */
	public ScqAwkwardDBDAOsearchAwkCostByCgoRoutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOsearchAwkCostByCgoRoutRSQL").append("\n"); 
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
		query.append("SELECT  A.CGO_SEQ, B.ROUT_SEQ" ).append("\n"); 
		query.append("    ,   A.CNTR_QTY" ).append("\n"); 
		query.append("    ,   SUM ( DECODE ( C.COST_TP_CD, 'N', C.SUM_AMT ) ) AS N_COST" ).append("\n"); 
		query.append("    ,   SUM ( DECODE ( C.COST_TP_CD, 'W', C.SUM_AMT ) ) AS W_COST" ).append("\n"); 
		query.append("    ,   SUM ( DECODE ( C.COST_TP_CD, 'G', C.SUM_AMT ) ) AS G_COST" ).append("\n"); 
		query.append("    ,   DECODE(SUM ( DECODE ( C.COST_TP_CD, 'A', C.SUM_AMT ) ),'',SUM ( DECODE ( C.COST_TP_CD, 'T', C.SUM_AMT ) )) AS T_COST" ).append("\n"); 
		query.append("    ,   SUM ( DECODE ( C.COST_TP_CD, 'S', C.SUM_AMT ) ) AS S_COST" ).append("\n"); 
		query.append("    ,   SUM ( DECODE ( C.COST_TP_CD, 'A', C.SUM_AMT ) ) AS A_COST" ).append("\n"); 
		query.append("FROM    PRI_SCQ_AWK_CGO A" ).append("\n"); 
		query.append("    ,   PRI_SCQ_AWK_ROUT B" ).append("\n"); 
		query.append("    ," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT  CGO_SEQ, ROUT_SEQ, COST_TP_CD, SUM ( USD_AMT ) AS SUM_AMT" ).append("\n"); 
		query.append("        FROM    PRI_SCQ_AWK_YD_DTL" ).append("\n"); 
		query.append("        WHERE   SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("        AND     SCQ_VER_NO  = @[scq_ver_no]" ).append("\n"); 
		query.append("        GROUP   BY CGO_SEQ, ROUT_SEQ, COST_TP_CD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  CGO_SEQ, ROUT_SEQ, COST_TP_CD, SUM ( USD_AMT )" ).append("\n"); 
		query.append("        FROM    PRI_SCQ_AWK_ROUT_DTL" ).append("\n"); 
		query.append("        WHERE   SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("        AND     SCQ_VER_NO  = @[scq_ver_no]" ).append("\n"); 
		query.append("        GROUP   BY CGO_SEQ, ROUT_SEQ, COST_TP_CD ) C" ).append("\n"); 
		query.append("WHERE   A.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND     A.SCQ_VER_NO  = @[scq_ver_no]" ).append("\n"); 
		query.append("AND     A.SCQ_RQST_NO = B.SCQ_RQST_NO" ).append("\n"); 
		query.append("AND     A.SCQ_VER_NO  = B.SCQ_VER_NO" ).append("\n"); 
		query.append("AND     A.CGO_SEQ     = C.CGO_SEQ" ).append("\n"); 
		query.append("AND     B.ROUT_SEQ    = C.ROUT_SEQ" ).append("\n"); 
		query.append("GROUP   BY A.CGO_SEQ, B.ROUT_SEQ, A.CNTR_QTY" ).append("\n"); 
		query.append("ORDER   BY A.CGO_SEQ, B.ROUT_SEQ" ).append("\n"); 

	}
}