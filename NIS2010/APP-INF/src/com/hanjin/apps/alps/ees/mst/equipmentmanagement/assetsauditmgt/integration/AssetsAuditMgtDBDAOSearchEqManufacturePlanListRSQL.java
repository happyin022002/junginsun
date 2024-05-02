/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AssetsAuditMgtDBDAOSearchEqManufacturePlanListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.04.04 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetsAuditMgtDBDAOSearchEqManufacturePlanListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HJS 신조 장비 제작  Serial Range를 조회한다.
	  * </pre>
	  */
	public AssetsAuditMgtDBDAOSearchEqManufacturePlanListRSQL(){
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
		params.put("cntr_hngr_rck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_flr_mtrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration").append("\n"); 
		query.append("FileName : AssetsAuditMgtDBDAOSearchEqManufacturePlanListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	   PLN_YR," ).append("\n"); 
		query.append("       EQ_TP_CD," ).append("\n"); 
		query.append("       EQ_TPSZ_CD," ).append("\n"); 
		query.append("	   PLN_SEQ," ).append("\n"); 
		query.append("       DECODE(EQ_TP_CD,'U',DECODE(CNTR_HNGR_RCK_CD,'O',1,0)) AS CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("       CNTR_FLR_MTRL_CD," ).append("\n"); 
		query.append("       RF_TP_CD," ).append("\n"); 
		query.append("       LOT_CNTR_PFX_CD," ).append("\n"); 
		query.append("       FM_SER_NO," ).append("\n"); 
		query.append("       '-' AS SER_TMP," ).append("\n"); 
		query.append("       TO_SER_NO," ).append("\n"); 
		query.append("       CNTR_QTY," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("FROM   MST_EQ_MFT_PLN" ).append("\n"); 
		query.append("#if (${pln_yr2} == '') " ).append("\n"); 
		query.append("WHERE PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#elseif (${pln_yr2} != '') " ).append("\n"); 
		query.append("WHERE PLN_YR BETWEEN @[pln_yr] AND @[pln_yr2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND EQ_TP_CD = @[eq_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '') " ).append("\n"); 
		query.append("AND EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_hngr_rck_cd} != '') " ).append("\n"); 
		query.append("AND NVL(CNTR_HNGR_RCK_CD,'N') = DECODE(@[cntr_hngr_rck_cd],'Y','O','N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_flr_mtrl_cd} != '' && ${cntr_flr_mtrl_cd} != 'All') " ).append("\n"); 
		query.append("AND CNTR_FLR_MTRL_CD = @[cntr_flr_mtrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rf_tp_cd} != '' && ${rf_tp_cd} != 'All') " ).append("\n"); 
		query.append("AND RF_TP_CD = @[rf_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY PLN_YR," ).append("\n"); 
		query.append("       EQ_TP_CD," ).append("\n"); 
		query.append("       EQ_TPSZ_CD," ).append("\n"); 
		query.append("	   PLN_SEQ" ).append("\n"); 

	}
}