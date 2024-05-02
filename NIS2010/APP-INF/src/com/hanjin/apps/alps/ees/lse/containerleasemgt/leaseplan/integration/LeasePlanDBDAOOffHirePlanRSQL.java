/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeasePlanDBDAOOffHirePlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.12.28 노정용
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

public class LeasePlanDBDAOOffHirePlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Plan Off-Hire Plan by H/Q   
	  * </pre>
	  */
	public LeasePlanDBDAOOffHirePlanRSQL(){
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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : LeasePlanDBDAOOffHirePlanRSQL").append("\n"); 
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
		query.append("SELECT XX.PLN_YR" ).append("\n"); 
		query.append(", XX.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", XX.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", XX.LSTM_CD" ).append("\n"); 
		query.append(", XX.OFFH_VER_SEQ" ).append("\n"); 
		query.append(", XX.OFFH_PLN_TP_CD" ).append("\n"); 
		query.append(", XX.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", XX.MNTH_01" ).append("\n"); 
		query.append(", XX.MNTH_02" ).append("\n"); 
		query.append(", XX.MNTH_03" ).append("\n"); 
		query.append(", XX.MNTH_04" ).append("\n"); 
		query.append(", XX.MNTH_05" ).append("\n"); 
		query.append(", XX.MNTH_06" ).append("\n"); 
		query.append(", XX.MNTH_07" ).append("\n"); 
		query.append(", XX.MNTH_08" ).append("\n"); 
		query.append(", XX.MNTH_09" ).append("\n"); 
		query.append(", XX.MNTH_10" ).append("\n"); 
		query.append(", XX.MNTH_11" ).append("\n"); 
		query.append(", XX.MNTH_12" ).append("\n"); 
		query.append(", XX.YR_TOT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT 1 AS TYPE" ).append("\n"); 
		query.append(", X.PLN_YR" ).append("\n"); 
		query.append(", X.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", X.LSTM_CD" ).append("\n"); 
		query.append(", X.OFFH_VER_SEQ" ).append("\n"); 
		query.append(", X.OFFH_PLN_TP_CD" ).append("\n"); 
		query.append(", X.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", Y.RPT_DP_SEQ" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) AS MNTH_01" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) AS MNTH_02" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'03',DE_QTY,0)) AS MNTH_03" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) AS MNTH_04" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) AS MNTH_05" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'06',DE_QTY,0)) AS MNTH_06" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) AS MNTH_07" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) AS MNTH_08" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'09',DE_QTY,0)) AS MNTH_09" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) AS MNTH_10" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) AS MNTH_11" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'12',DE_QTY,0)) AS MNTH_12" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'03',DE_QTY,0))" ).append("\n"); 
		query.append("+ SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'06',DE_QTY,0))" ).append("\n"); 
		query.append("+ SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'09',DE_QTY,0))" ).append("\n"); 
		query.append("+ SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'12',DE_QTY,0)) AS YR_TOT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT A.PLN_YR" ).append("\n"); 
		query.append(", SUBSTR(A.OFFH_YRMON, 5, 2) AS DE_MON" ).append("\n"); 
		query.append(", NVL(A.OFFH_QTY,0) AS DE_QTY" ).append("\n"); 
		query.append(", A.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.LSTM_CD" ).append("\n"); 
		query.append(", A.OFFH_VER_SEQ" ).append("\n"); 
		query.append(", A.OFFH_PLN_TP_CD" ).append("\n"); 
		query.append(", A.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append("FROM   LSE_OFFH_PLN A" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${offh_loc_tp_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_LOC_TP_CD = @[offh_loc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pln_yr} != \"\")" ).append("\n"); 
		query.append("AND    A.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${offh_pln_tp_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_PLN_TP_CD = @[offh_pln_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${offh_ver_seq} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_VER_SEQ = @[offh_ver_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    A.OFFH_VER_SEQ = ( SELECT MAX(A.OFFH_VER_SEQ)" ).append("\n"); 
		query.append("FROM   LSE_OFFH_PLN A" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${pln_yr} != \"\")" ).append("\n"); 
		query.append("AND    A.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${offh_pln_tp_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_PLN_TP_CD = @[offh_pln_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${offh_loc_tp_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_LOC_TP_CD = @[offh_loc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${offh_rgn_loc_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_LOC_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${offh_rgn_loc_cd_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $offh_rgn_loc_cd_seq.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(", MDM_CNTR_TP_SZ Y" ).append("\n"); 
		query.append("WHERE  X.CNTR_TPSZ_CD = Y.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("GROUP  BY X.PLN_YR" ).append("\n"); 
		query.append(", X.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", X.LSTM_CD" ).append("\n"); 
		query.append(", X.OFFH_VER_SEQ" ).append("\n"); 
		query.append(", X.OFFH_PLN_TP_CD" ).append("\n"); 
		query.append(", X.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", Y.RPT_DP_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 2 AS TYPE" ).append("\n"); 
		query.append(", X.PLN_YR" ).append("\n"); 
		query.append(", 'G.TTL' AS OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", X.LSTM_CD" ).append("\n"); 
		query.append(", X.OFFH_VER_SEQ" ).append("\n"); 
		query.append(", X.OFFH_PLN_TP_CD" ).append("\n"); 
		query.append(", X.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", Y.RPT_DP_SEQ" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) AS MNTH_01" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) AS MNTH_02" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'03',DE_QTY,0)) AS MNTH_03" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) AS MNTH_04" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) AS MNTH_05" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'06',DE_QTY,0)) AS MNTH_06" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) AS MNTH_07" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) AS MNTH_08" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'09',DE_QTY,0)) AS MNTH_09" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) AS MNTH_10" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) AS MNTH_11" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'12',DE_QTY,0)) AS MNTH_12" ).append("\n"); 
		query.append(", SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'03',DE_QTY,0))" ).append("\n"); 
		query.append("+ SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'06',DE_QTY,0))" ).append("\n"); 
		query.append("+ SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'09',DE_QTY,0))" ).append("\n"); 
		query.append("+ SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'12',DE_QTY,0)) AS YR_TOT" ).append("\n"); 
		query.append("FROM   ( SELECT A.PLN_YR" ).append("\n"); 
		query.append(", SUBSTR(A.OFFH_YRMON, 5, 2) AS DE_MON" ).append("\n"); 
		query.append(", NVL(A.OFFH_QTY,0) AS DE_QTY" ).append("\n"); 
		query.append(", A.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.LSTM_CD" ).append("\n"); 
		query.append(", A.OFFH_VER_SEQ" ).append("\n"); 
		query.append(", A.OFFH_PLN_TP_CD" ).append("\n"); 
		query.append(", A.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append("FROM   LSE_OFFH_PLN A" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${offh_loc_tp_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_LOC_TP_CD = @[offh_loc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pln_yr} != \"\")" ).append("\n"); 
		query.append("AND    A.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${offh_pln_tp_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_PLN_TP_CD = @[offh_pln_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${offh_ver_seq} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_VER_SEQ = @[offh_ver_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    A.OFFH_VER_SEQ = ( SELECT MAX(A.OFFH_VER_SEQ)" ).append("\n"); 
		query.append("FROM   LSE_OFFH_PLN A" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${pln_yr} != \"\")" ).append("\n"); 
		query.append("AND    A.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${offh_pln_tp_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_PLN_TP_CD = @[offh_pln_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${offh_loc_tp_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_LOC_TP_CD = @[offh_loc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${offh_rgn_loc_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.OFFH_LOC_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${offh_rgn_loc_cd_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $offh_rgn_loc_cd_seq.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != \"\")" ).append("\n"); 
		query.append("AND    A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(", MDM_CNTR_TP_SZ Y" ).append("\n"); 
		query.append("WHERE  X.CNTR_TPSZ_CD = Y.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("GROUP  BY X.PLN_YR" ).append("\n"); 
		query.append(", X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", X.LSTM_CD" ).append("\n"); 
		query.append(", X.OFFH_VER_SEQ" ).append("\n"); 
		query.append(", X.OFFH_PLN_TP_CD" ).append("\n"); 
		query.append(", X.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", Y.RPT_DP_SEQ" ).append("\n"); 
		query.append(") XX" ).append("\n"); 
		query.append("ORDER  BY XX.TYPE" ).append("\n"); 
		query.append(", XX.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", XX.LSTM_CD" ).append("\n"); 
		query.append(", XX.RPT_DP_SEQ" ).append("\n"); 

	}
}