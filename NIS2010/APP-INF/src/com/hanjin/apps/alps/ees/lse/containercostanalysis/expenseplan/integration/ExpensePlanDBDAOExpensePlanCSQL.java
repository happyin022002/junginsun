/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpensePlanDBDAOExpensePlanCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.29 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpensePlanDBDAOExpensePlanCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR/CHSS에 대한 년간 사업계획 자료를 저장한다.
	  * </pre>
	  */
	public ExpensePlanDBDAOExpensePlanCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_mon_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_term_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("MERGE INTO LSE_EQ_EXPN_PLN A" ).append("\n"); 
		query.append("USING   (SELECT  @[pln_yr]        AS PLN_YR," ).append("\n"); 
		query.append("@[pln_seq]       AS PLN_SEQ," ).append("\n"); 
		query.append("@[ver_seq]       AS VER_SEQ," ).append("\n"); 
		query.append("@[eq_knd_cd]     AS EQ_KND_CD," ).append("\n"); 
		query.append("@[eq_term_nm]    AS EQ_TERM_NM," ).append("\n"); 
		query.append("@[expn_mon_cd]   AS EXPN_MON_CD," ).append("\n"); 
		query.append("@[expn_amt]      AS EXPN_AMT," ).append("\n"); 
		query.append("@[cre_usr_id]    AS CRE_USR_ID," ).append("\n"); 
		query.append("@[upd_usr_id]    AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM    DUAL) B" ).append("\n"); 
		query.append("ON      (A.PLN_YR = B.PLN_YR" ).append("\n"); 
		query.append("AND      A.PLN_SEQ = B.PLN_SEQ" ).append("\n"); 
		query.append("AND      A.VER_SEQ = B.VER_SEQ)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE 	SET" ).append("\n"); 
		query.append("A.EQ_KND_CD   = B.EQ_KND_CD," ).append("\n"); 
		query.append("A.EQ_TERM_NM  = B.EQ_TERM_NM," ).append("\n"); 
		query.append("A.EXPN_MON_CD = B.EXPN_MON_CD," ).append("\n"); 
		query.append("A.EXPN_AMT    = B.EXPN_AMT," ).append("\n"); 
		query.append("A.UPD_USR_ID  = B.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHERE 	A.PLN_YR  = B.PLN_YR" ).append("\n"); 
		query.append("AND     A.PLN_SEQ = B.PLN_SEQ" ).append("\n"); 
		query.append("AND     A.VER_SEQ = B.VER_SEQ" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT 	(A.PLN_YR, A.PLN_SEQ, A.VER_SEQ, A.EQ_KND_CD," ).append("\n"); 
		query.append("A.EQ_TERM_NM, A.EXPN_MON_CD, A.EXPN_AMT," ).append("\n"); 
		query.append("A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT)" ).append("\n"); 
		query.append("VALUES 	(B.PLN_YR, B.PLN_SEQ, B.VER_SEQ, B.EQ_KND_CD," ).append("\n"); 
		query.append("B.EQ_TERM_NM, B.EXPN_MON_CD, B.EXPN_AMT," ).append("\n"); 
		query.append("B.CRE_USR_ID, SYSDATE, B.UPD_USR_ID, SYSDATE)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.integration").append("\n"); 
		query.append("FileName : ExpensePlanDBDAOExpensePlanCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}