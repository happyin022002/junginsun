/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationTypeMgtDBDAOCalculationTypeParmVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationTypeMgtDBDAOCalculationTypeParmVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CalculationTypeParmVO Insert
	  * </pre>
	  */
	public DMTCalculationTypeMgtDBDAOCalculationTypeParmVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration").append("\n"); 
		query.append("FileName : DMTCalculationTypeMgtDBDAOCalculationTypeParmVOCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_CALC_TP(" ).append("\n"); 
		query.append("		CNT_CD," ).append("\n"); 
		query.append("        RGN_CD," ).append("\n"); 
		query.append("        STE_CD," ).append("\n"); 
		query.append("        LOC_CD," ).append("\n"); 
		query.append("        IO_BND_CD," ).append("\n"); 
		query.append("        CALC_TP_SEQ," ).append("\n"); 
		query.append("        DMDT_CALC_TP_CD," ).append("\n"); 
		query.append("        EFF_DT," ).append("\n"); 
		query.append("        EXP_DT," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        CRE_OFC_CD," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT," ).append("\n"); 
		query.append("        UPD_OFC_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("		NVL(@[cnt_cd],' ')" ).append("\n"); 
		query.append("	,	NVL(@[rgn_cd],' ')" ).append("\n"); 
		query.append("	,   NVL(@[ste_cd],' ')" ).append("\n"); 
		query.append("	,   NVL(@[loc_cd],' ')" ).append("\n"); 
		query.append("	,   NVL(@[io_bnd_cd],' ')" ).append("\n"); 
		query.append("	,   (" ).append("\n"); 
		query.append("            SELECT NVL(CALC_TP_SEQ, 1) CALC_TP_SEQ" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    SELECT MAX(CALC_TP_SEQ) + 1 AS CALC_TP_SEQ" ).append("\n"); 
		query.append("                      FROM  DMT_CALC_TP" ).append("\n"); 
		query.append("                     WHERE CNT_CD	 =	NVL(@[cnt_cd], ' ')" ).append("\n"); 
		query.append("                       AND RGN_CD	 =	NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("                       AND STE_CD	 =	NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("                       AND LOC_CD	 =	NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("                       AND IO_BND_CD =	NVL(@[io_bnd_cd], ' ')" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ,   NVL(@[dmdt_calc_tp_cd],' ')" ).append("\n"); 
		query.append("    ,   TO_DATE(@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("	,	TO_DATE(@[exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	SYSDATE" ).append("\n"); 
		query.append("	,	@[cre_ofc_cd]" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	SYSDATE" ).append("\n"); 
		query.append("	,	@[cre_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}