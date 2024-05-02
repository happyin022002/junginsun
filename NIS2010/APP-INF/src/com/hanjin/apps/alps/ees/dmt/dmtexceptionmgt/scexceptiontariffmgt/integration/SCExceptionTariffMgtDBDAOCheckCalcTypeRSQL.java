/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOCheckCalcTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOCheckCalcTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택한 Tariff Type 과 Coverage 가 Calculation Type 인지를 조회하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOCheckCalcTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_calc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOCheckCalcTypeRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC( DMT_CALC_TP XPKDMT_CALC_TP) */ " ).append("\n"); 
		query.append("        DECODE(DMDT_CALC_TP_CD, @[dmdt_calc_tp_cd], 1, 0) AS CNT " ).append("\n"); 
		query.append("FROM    DMT_CALC_TP" ).append("\n"); 
		query.append("WHERE   ( CNT_CD  =  @[cnt_cd]    OR  CNT_CD = ' ' )" ).append("\n"); 
		query.append("AND ( RGN_CD  =  @[rgn_cd]    OR  RGN_CD = ' ' )" ).append("\n"); 
		query.append("AND ( STE_CD  =  @[ste_cd]    OR  STE_CD = ' ' )" ).append("\n"); 
		query.append("AND ( LOC_CD  =  @[loc_cd]    OR  LOC_CD = ' ' )" ).append("\n"); 
		query.append("AND IO_BND_CD =  @[io_bnd_cd]" ).append("\n"); 
		query.append("AND CALC_TP_SEQ =    " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("   SELECT  /*+ INDEX_DESC( D XPKDMT_CALC_TP) */ D.CALC_TP_SEQ" ).append("\n"); 
		query.append("   FROM DMT_CALC_TP D" ).append("\n"); 
		query.append("   WHERE   ( D.CNT_CD  =  @[cnt_cd]  OR D.CNT_CD = ' ' )" ).append("\n"); 
		query.append("    AND ( D.RGN_CD  =  @[rgn_cd]  OR D.RGN_CD = ' ' )" ).append("\n"); 
		query.append("    AND ( D.STE_CD  =  @[ste_cd]  OR D.STE_CD = ' ' )" ).append("\n"); 
		query.append("    AND ( D.LOC_CD  =  @[loc_cd]  OR D.LOC_CD = ' ' )" ).append("\n"); 
		query.append("    AND D.IO_BND_CD =  @[io_bnd_cd]" ).append("\n"); 
		query.append("    AND (" ).append("\n"); 
		query.append("                       ( NVL(@[eff_dt], 'N') = 'N' )" ).append("\n"); 
		query.append("                    OR ( NVL(@[eff_dt], 'N') <> 'N'" ).append("\n"); 
		query.append("                  AND EFF_DT <= TO_DATE (Replace(@[eff_dt], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("                AND (" ).append("\n"); 
		query.append("                       ( NVL(@[exp_dt], 'N') = 'N' )" ).append("\n"); 
		query.append("                    OR ( NVL(@[exp_dt], 'N') <> 'N'" ).append("\n"); 
		query.append("                  AND NVL(EXP_DT, TO_DATE (Replace(@[exp_dt], '-', ''), 'YYYYMMDD')) >= TO_DATE (Replace(@[exp_dt], '-', ''), 'YYYYMMDD') " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("                       ( NVL(@[eff_dt], 'N') = 'N' )" ).append("\n"); 
		query.append("                    OR ( NVL(@[eff_dt], 'N') <> 'N'" ).append("\n"); 
		query.append("                  AND EFF_DT <= TO_DATE (Replace(@[eff_dt], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("                       ( NVL(@[exp_dt], 'N') = 'N' )" ).append("\n"); 
		query.append("                    OR ( NVL(@[exp_dt], 'N') <> 'N'" ).append("\n"); 
		query.append("                  AND NVL(EXP_DT, TO_DATE (Replace(@[exp_dt], '-', ''), 'YYYYMMDD')) >= TO_DATE (Replace(@[exp_dt], '-', ''), 'YYYYMMDD') " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}