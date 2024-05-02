/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AssetsAuditMgtDBDAOValidationEqManufacturePlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.04
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.04.04 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetsAuditMgtDBDAOValidationEqManufacturePlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ValidationEqManufacturePlan
	  * </pre>
	  */
	public AssetsAuditMgtDBDAOValidationEqManufacturePlanRSQL(){
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
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lot_cntr_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration").append("\n"); 
		query.append("FileName : AssetsAuditMgtDBDAOValidationEqManufacturePlanRSQL").append("\n"); 
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
		query.append("SELECT @[pln_yr] AS PLN_YR," ).append("\n"); 
		query.append("	   @[eq_tp_cd] AS EQ_TP_CD," ).append("\n"); 
		query.append("       @[eq_tpsz_cd] AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("       @[pln_seq] AS PLN_SEQ," ).append("\n"); 
		query.append("       A.PLN_YR||' / '||A.LOT_CNTR_PFX_CD||' '||A.FM_SER_NO||' ~ '||A.TO_SER_NO AS RMK" ).append("\n"); 
		query.append("FROM   MST_EQ_MFT_PLN A" ).append("\n"); 
		query.append("WHERE  A.EQ_TP_CD =@[eq_tp_cd]" ).append("\n"); 
		query.append("AND  A.LOT_CNTR_PFX_CD=@[lot_cntr_pfx_cd]" ).append("\n"); 
		query.append("AND  @[fm_ser_no] BETWEEN A.FM_SER_NO AND A.TO_SER_NO" ).append("\n"); 
		query.append("#if (${pln_seq} != '') " ).append("\n"); 
		query.append("AND (A.PLN_YR, A.EQ_TP_CD, A.EQ_TPSZ_CD, A.PLN_SEQ) NOT IN (SELECT PLN_YR," ).append("\n"); 
		query.append("                                       							EQ_TP_CD," ).append("\n"); 
		query.append("                                       							EQ_TPSZ_CD," ).append("\n"); 
		query.append("                                       							PLN_SEQ" ).append("\n"); 
		query.append("                                							FROM   MST_EQ_MFT_PLN " ).append("\n"); 
		query.append("                                							WHERE PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("                                							AND EQ_TP_CD = @[eq_tp_cd]" ).append("\n"); 
		query.append("      														AND EQ_TPSZ_CD = @[eq_tpsz_cd] " ).append("\n"); 
		query.append("      														AND PLN_SEQ = @[pln_seq] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT @[pln_yr] AS PLN_YR," ).append("\n"); 
		query.append("	   @[eq_tp_cd] AS EQ_TP_CD," ).append("\n"); 
		query.append("       @[eq_tpsz_cd] AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("       @[pln_seq] AS PLN_SEQ," ).append("\n"); 
		query.append("       A.PLN_YR||' / '||A.LOT_CNTR_PFX_CD||' '||A.FM_SER_NO||' ~ '||A.TO_SER_NO AS RMK" ).append("\n"); 
		query.append("FROM   MST_EQ_MFT_PLN A" ).append("\n"); 
		query.append("WHERE  A.EQ_TP_CD =@[eq_tp_cd]" ).append("\n"); 
		query.append("AND  A.LOT_CNTR_PFX_CD=@[lot_cntr_pfx_cd]" ).append("\n"); 
		query.append("AND  @[to_ser_no] BETWEEN A.FM_SER_NO AND A.TO_SER_NO" ).append("\n"); 
		query.append("#if (${pln_seq} != '') " ).append("\n"); 
		query.append("AND (A.PLN_YR, A.EQ_TP_CD, A.EQ_TPSZ_CD, A.PLN_SEQ) NOT IN (SELECT PLN_YR," ).append("\n"); 
		query.append("                                       							EQ_TP_CD," ).append("\n"); 
		query.append("                                       							EQ_TPSZ_CD," ).append("\n"); 
		query.append("                                       							PLN_SEQ" ).append("\n"); 
		query.append("                                							FROM   MST_EQ_MFT_PLN " ).append("\n"); 
		query.append("                                							WHERE PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("                                							AND EQ_TP_CD = @[eq_tp_cd]" ).append("\n"); 
		query.append("      														AND EQ_TPSZ_CD = @[eq_tpsz_cd] " ).append("\n"); 
		query.append("      														AND PLN_SEQ = @[pln_seq] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}