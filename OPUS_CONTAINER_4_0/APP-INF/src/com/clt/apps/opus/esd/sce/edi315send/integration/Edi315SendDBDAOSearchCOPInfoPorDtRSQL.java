/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCOPInfoPorDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.18 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCOPInfoPorDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOPInfoPorDt
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCOPInfoPorDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCOPInfoPorDtRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT TO_CHAR(E_T, 'YYYYMMDDHH24MI') POR_ETD," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(E_T, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, E_T, 'GMT'), 'YYYYMMDDHH24MI'))) POR_ETD_GMT ," ).append("\n"); 
		query.append("TO_CHAR(A_T, 'YYYYMMDDHH24MI') POR_ATD," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(A_T, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, A_T, 'GMT'), 'YYYYMMDDHH24MI'))) POR_ATD_GMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.E_T," ).append("\n"); 
		query.append("A.A_T," ).append("\n"); 
		query.append("A.NOD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROWNUM F_ROW," ).append("\n"); 
		query.append("DECODE(B.RCV_TERM_CD, 'D', ESTM_DT + 4/24, ESTM_DT) E_T," ).append("\n"); 
		query.append("CASE WHEN DECODE(B.RCV_TERM_CD, 'D', ACT_DT + 4/24, ACT_DT) IS NULL" ).append("\n"); 
		query.append("AND D.ACT_STS_CD = 'F' THEN DECODE(B.RCV_TERM_CD, 'D', ESTM_DT + 4/24, ESTM_DT) ELSE DECODE(B.RCV_TERM_CD, 'D', ACT_DT + 4/24, ACT_DT) END A_T ," ).append("\n"); 
		query.append("SUBSTR(H.POR_NOD_CD, 0, 5) NOD," ).append("\n"); 
		query.append("D.ACT_CD," ).append("\n"); 
		query.append("D.COP_DTL_SEQ" ).append("\n"); 
		query.append("FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("SCE_COP_DTL D," ).append("\n"); 
		query.append("BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.COP_NO = @[e_cop_no]" ).append("\n"); 
		query.append("AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("AND H.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND ( (B.RCV_TERM_CD = 'D'" ).append("\n"); 
		query.append("AND D.ACT_CD = 'MOTZAD')" ).append("\n"); 
		query.append("OR (B.RCV_TERM_CD <> 'D'" ).append("\n"); 
		query.append("AND SUBSTR(D.ACT_CD, 5, 1) = 'D') )" ).append("\n"); 
		query.append("ORDER BY D.COP_DTL_SEQ ASC ) A" ).append("\n"); 
		query.append("WHERE F_ROW = 1 )" ).append("\n"); 

	}
}