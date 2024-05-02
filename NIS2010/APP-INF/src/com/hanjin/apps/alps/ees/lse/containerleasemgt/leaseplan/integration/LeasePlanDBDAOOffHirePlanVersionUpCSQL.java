/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeasePlanDBDAOOffHirePlanVersionUpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2010.01.05 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeasePlanDBDAOOffHirePlanVersionUpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LeasePlanDBDAOOffHirePlanVersionUpCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_pln_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAOOffHirePlanVersionUpCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_OFFH_PLN (" ).append("\n"); 
		query.append("PLN_YR" ).append("\n"); 
		query.append(", PLN_SEQ" ).append("\n"); 
		query.append(", OFFH_VER_SEQ" ).append("\n"); 
		query.append(", OFFH_YRMON" ).append("\n"); 
		query.append(", OFFH_PLN_TP_CD" ).append("\n"); 
		query.append(", OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", OFFH_LOC_CD" ).append("\n"); 
		query.append(", OFFH_QTY" ).append("\n"); 
		query.append(", LSTM_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT )" ).append("\n"); 
		query.append("SELECT A.PLN_YR" ).append("\n"); 
		query.append(", D.MAX_PLN_SEQ + ROWNUM AS PLN_SEQ" ).append("\n"); 
		query.append(", D.OFFH_VER_NEW_SEQ" ).append("\n"); 
		query.append(", A.OFFH_YRMON" ).append("\n"); 
		query.append(", A.OFFH_PLN_TP_CD" ).append("\n"); 
		query.append(", A.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", A.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.OFFH_LOC_CD" ).append("\n"); 
		query.append(", A.OFFH_QTY" ).append("\n"); 
		query.append(", A.LSTM_CD" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM   LSE_OFFH_PLN A" ).append("\n"); 
		query.append(", ( SELECT P.PLN_YR" ).append("\n"); 
		query.append(", P.OFFH_VER_MAX_SEQ" ).append("\n"); 
		query.append(", P.OFFH_VER_NEW_SEQ" ).append("\n"); 
		query.append(", NVL(MAX(C.PLN_SEQ),0) AS MAX_PLN_SEQ" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT @[pln_yr] AS PLN_YR" ).append("\n"); 
		query.append(", MAX(B.OFFH_VER_SEQ)   AS OFFH_VER_MAX_SEQ" ).append("\n"); 
		query.append(", MAX(B.OFFH_VER_SEQ)+1 AS OFFH_VER_NEW_SEQ" ).append("\n"); 
		query.append("FROM   LSE_OFFH_PLN B" ).append("\n"); 
		query.append("WHERE  B.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("AND    B.OFFH_PLN_TP_CD = @[offh_pln_tp_cd]" ).append("\n"); 
		query.append("AND    B.OFFH_LOC_TP_CD = @[offh_loc_tp_cd]" ).append("\n"); 
		query.append(") P" ).append("\n"); 
		query.append(", LSE_OFFH_PLN C" ).append("\n"); 
		query.append("WHERE  C.PLN_YR(+) = P.PLN_YR" ).append("\n"); 
		query.append("AND    C.OFFH_VER_SEQ(+) = P.OFFH_VER_NEW_SEQ" ).append("\n"); 
		query.append("GROUP  BY P.PLN_YR, P.OFFH_VER_MAX_SEQ, P.OFFH_VER_NEW_SEQ" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE  A.PLN_YR = D.PLN_YR" ).append("\n"); 
		query.append("AND    A.OFFH_VER_SEQ = D.OFFH_VER_MAX_SEQ" ).append("\n"); 
		query.append("AND    A.OFFH_PLN_TP_CD = @[offh_pln_tp_cd]" ).append("\n"); 
		query.append("AND    A.OFFH_LOC_TP_CD = @[offh_loc_tp_cd]" ).append("\n"); 

	}
}