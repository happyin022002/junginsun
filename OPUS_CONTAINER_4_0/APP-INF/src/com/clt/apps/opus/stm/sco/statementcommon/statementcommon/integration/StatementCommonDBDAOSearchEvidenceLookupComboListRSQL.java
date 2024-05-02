/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatementCommonDBDAOSearchEvidenceLookupComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchEvidenceLookupComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 각 소스별 Evidence Type을 선택하여 처리하기 위한 Lookup 내역 조회
	  * </pre>
	  */
	public StatementCommonDBDAOSearchEvidenceLookupComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_appl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration ").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchEvidenceLookupComboListRSQL").append("\n"); 
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
		query.append("SELECT D.LU_TP_CD" ).append("\n"); 
		query.append("     , D.LU_CD" ).append("\n"); 
		query.append("     , D.LU_DESC" ).append("\n"); 
		query.append("     , D.ENBL_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(D.LU_ST_DT, 'YYYY-MM-DD')  AS LU_ST_DT" ).append("\n"); 
		query.append("     , TO_CHAR(D.LU_END_DT, 'YYYY-MM-DD') AS LU_END_DT" ).append("\n"); 
		query.append("     , D.ATTR_CTNT1" ).append("\n"); 
		query.append("     , D.ATTR_CTNT2" ).append("\n"); 
		query.append("     , D.ATTR_CTNT3" ).append("\n"); 
		query.append("     , D.ATTR_CTNT4" ).append("\n"); 
		query.append("     , D.ATTR_CTNT5" ).append("\n"); 
		query.append("     , D.CRE_USR_ID" ).append("\n"); 
		query.append("     , D.CRE_DT" ).append("\n"); 
		query.append("     , D.UPD_USR_ID" ).append("\n"); 
		query.append("     , D.UPD_DT" ).append("\n"); 
		query.append("     , D.DP_SEQ" ).append("\n"); 
		query.append("FROM   SCO_LU_HDR H, SCO_LU_DTL D" ).append("\n"); 
		query.append("WHERE  H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("#if (${lu_appl_cd} != '') " ).append("\n"); 
		query.append("  AND  H.LU_APPL_CD = @[lu_appl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lu_tp_cd} != '') " ).append("\n"); 
		query.append("  AND  D.LU_TP_CD = @[lu_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lu_cd} != '') " ).append("\n"); 
		query.append("  AND  D.LU_CD = @[lu_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lu_desc} != '') " ).append("\n"); 
		query.append("  AND  D.LU_DESC = @[lu_desc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lu_end_dt} != '') " ).append("\n"); 
		query.append("  AND  D.LU_END_DT = @[lu_end_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lu_st_dt} != '') " ).append("\n"); 
		query.append("  AND  D.LU_ST_DT = @[lu_st_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt1} != '') " ).append("\n"); 
		query.append("  AND  D.ATTR_CTNT1 = @[attr_ctnt1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt2} != '') " ).append("\n"); 
		query.append("  AND  D.ATTR_CTNT2 = @[attr_ctnt2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt3} != '') " ).append("\n"); 
		query.append("  AND  D.ATTR_CTNT3 = @[attr_ctnt3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt4} != '') " ).append("\n"); 
		query.append("  AND  D.ATTR_CTNT4 = @[attr_ctnt4]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt5} == 'MI') " ).append("\n"); 
		query.append("  AND  D.LU_CD <> 'ARAPOFFSET' AND D.LU_CD <> 'REFUND'" ).append("\n"); 
		query.append("#elseif (${attr_ctnt5} == 'AO')" ).append("\n"); 
		query.append("  AND  D.LU_CD = 'ARAPOFFSET'" ).append("\n"); 
		query.append("#elseif (${attr_ctnt5} == 'AR')" ).append("\n"); 
		query.append("  AND  D.LU_CD = 'REFUND'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND  D.ATTR_CTNT5 = @[attr_ctnt5]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND  D.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER  BY DP_SEQ,LU_TP_CD, LU_CD, LU_DESC" ).append("\n"); 

	}
}