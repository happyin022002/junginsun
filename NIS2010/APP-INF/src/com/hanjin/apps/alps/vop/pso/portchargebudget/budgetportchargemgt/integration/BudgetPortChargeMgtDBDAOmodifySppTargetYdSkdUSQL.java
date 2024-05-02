/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOmodifySppTargetYdSkdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOmodifySppTargetYdSkdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 운항스케쥴의 skd_cng_sts_cd 값을 변경한다.
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOmodifySppTargetYdSkdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bztp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOmodifySppTargetYdSkdUSQL").append("\n"); 
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
		query.append("UPDATE /*+BYPASS_UJVC*/" ).append("\n"); 
		query.append("     (SELECT T1.SKD_CNG_STS_CD, T2.SKD_CNG_STS_CD SKD_CNG_STS_CD2," ).append("\n"); 
		query.append("             T1.UPD_USR_ID, T1.UPD_DT" ).append("\n"); 
		query.append("        FROM PSO_TGT_YD_SKD T1, VSK_VSL_PORT_SKD T2 " ).append("\n"); 
		query.append("       WHERE T2.VPS_ETB_DT   >= TO_DATE(REPLACE(@[tgt_date], '-', '') || '01', 'YYYYMMDD')" ).append("\n"); 
		query.append("          AND T2.VPS_ETB_DT   <  ADD_MONTHS(TO_DATE(REPLACE(@[tgt_date], '-', '') || '01', 'YYYYMMDD'), DECODE(@[bztp_cd], '5', 1, '6', 12)) " ).append("\n"); 
		query.append("          AND T1.VSL_CD         = T2.VSL_CD" ).append("\n"); 
		query.append("          AND T1.SKD_VOY_NO  = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND T1.SKD_DIR_CD   = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND T1.YD_CD          = T2.YD_CD  " ).append("\n"); 
		query.append("          AND T2.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("          AND T1.PSO_BZTP_CD = @[bztp_cd]   )" ).append("\n"); 
		query.append("   SET SKD_CNG_STS_CD =  SKD_CNG_STS_CD2" ).append("\n"); 
		query.append("      ,UPD_USR_ID     =  @[cre_usr_id] " ).append("\n"); 
		query.append("      ,UPD_DT         =  SYSDATE" ).append("\n"); 

	}
}