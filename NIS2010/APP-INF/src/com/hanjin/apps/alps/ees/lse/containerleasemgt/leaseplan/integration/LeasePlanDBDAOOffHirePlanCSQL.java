/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeasePlanDBDAOOffHirePlanCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.06.25 노정용
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

public class LeasePlanDBDAOOffHirePlanCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LeasePlanDBDAOOffHirePlanCSQL(){
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
		params.put("offh_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_rgn_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT @[pln_yr]                AS PLN_YR" ).append("\n"); 
		query.append(", NVL(MAX(C.PLN_SEQ), 0)+1 AS PLN_SEQ" ).append("\n"); 
		query.append(", @[offh_ver_seq]          AS OFFH_VER_SEQ" ).append("\n"); 
		query.append(", @[offh_yrmon]            AS OFFH_YRMON" ).append("\n"); 
		query.append(", @[offh_pln_tp_cd]        AS OFFH_PLN_TP_CD" ).append("\n"); 
		query.append(", @[offh_loc_tp_cd]        AS OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", @[offh_rgn_loc_cd]       AS OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd]          AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", @[offh_loc_cd]           AS OFFH_LOC_CD" ).append("\n"); 
		query.append(", @[offh_qty]              AS OFFH_QTY" ).append("\n"); 
		query.append(", @[lstm_cd]               AS LSTM_CD" ).append("\n"); 
		query.append(", @[cre_usr_id]            AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE                  AS CRE_DT" ).append("\n"); 
		query.append(", @[cre_usr_id]            AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE                  AS UPD_DT" ).append("\n"); 
		query.append("FROM   LSE_OFFH_PLN C" ).append("\n"); 
		query.append("WHERE  C.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("AND    C.OFFH_VER_SEQ = @[offh_ver_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAOOffHirePlanCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}