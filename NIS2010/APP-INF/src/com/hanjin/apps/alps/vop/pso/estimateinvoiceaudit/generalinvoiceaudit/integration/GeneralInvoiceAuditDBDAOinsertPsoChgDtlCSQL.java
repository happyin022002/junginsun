/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOinsertPsoChgDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.14
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.07.14 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOinsertPsoChgDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insertPsoChgDtl
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOinsertPsoChgDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foml_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOinsertPsoChgDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO PSO_CHG_DTL (" ).append("\n"); 
		query.append("	ISS_CTY_CD" ).append("\n"); 
		query.append(",	SO_SEQ" ).append("\n"); 
		query.append(",	SO_DTL_SEQ" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	REV_DIR_CD" ).append("\n"); 
		query.append(",	RLANE_CD" ).append("\n"); 
		query.append(",	LGS_COST_CD" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	LOCL_AMT" ).append("\n"); 
		query.append(",	USD_AMT" ).append("\n"); 
		query.append(",	CALC_AMT" ).append("\n"); 
		query.append(",	ADJ_AMT" ).append("\n"); 
		query.append(",	XPR_DESC" ).append("\n"); 
		query.append(",	FOML_DESC" ).append("\n"); 
		query.append(",	YD_CHG_VER_SEQ" ).append("\n"); 
		query.append(",	YD_CHG_NO" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	AR_YRMON" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   ORG_SO_DTL_SEQ" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	(SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("	ISS_CTY_CD FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("	WHERE T1.ISS_CTY_CD = 'PUS'" ).append("\n"); 
		query.append("	AND T1.SO_SEQ >= 0 " ).append("\n"); 
		query.append("	AND ROWNUM<=1)" ).append("\n"); 
		query.append(",	(SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("	SO_SEQ FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("	WHERE T1.ISS_CTY_CD = 'PUS'" ).append("\n"); 
		query.append("	AND T1.SO_SEQ >= 0 " ).append("\n"); 
		query.append("	AND ROWNUM<=1)" ).append("\n"); 
		query.append(",	@[so_dtl_seq]" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	(SELECT L.RLANE_DIR_CD" ).append("\n"); 
		query.append("	   FROM VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("  			AR_MST_REV_VVD L" ).append("\n"); 
		query.append("	  WHERE V.VSL_CD               	 = L.VSL_CD" ).append("\n"); 
		query.append("		AND V.SKD_VOY_NO             = L.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND V.SKD_DIR_CD             = L.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND V.SLAN_CD                = L.SLAN_CD" ).append("\n"); 
		query.append("		AND V.VSL_CD                 = @[vsl_cd]" ).append("\n"); 
		query.append("		AND V.SKD_VOY_NO             = @[skd_voy_no]" ).append("\n"); 
		query.append("		AND V.SKD_DIR_CD             = @[skd_dir_cd]" ).append("\n"); 
		query.append("		AND V.VPS_PORT_CD            = (SELECT SUBSTR(X.YD_CD, 1, 5)" ).append("\n"); 
		query.append("   										  FROM PSO_CHARGE X" ).append("\n"); 
		query.append("    									 WHERE ISS_CTY_CD =" ).append("\n"); 
		query.append("      														(SELECT" ).append("\n"); 
		query.append("        														/*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("        															ISS_CTY_CD" ).append("\n"); 
		query.append("      														   FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("      														  WHERE T1.ISS_CTY_CD = 'PUS'" ).append("\n"); 
		query.append("    														    AND T1.SO_SEQ      >= 0" ).append("\n"); 
		query.append("      															AND ROWNUM         <=1" ).append("\n"); 
		query.append("     														)" ).append("\n"); 
		query.append("    									   AND SO_SEQ=" ).append("\n"); 
		query.append("      														(SELECT" ).append("\n"); 
		query.append("        														/*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("        															SO_SEQ" ).append("\n"); 
		query.append("      														  FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("      														 WHERE T1.ISS_CTY_CD = 'PUS'" ).append("\n"); 
		query.append("      														   AND T1.SO_SEQ      >= 0" ).append("\n"); 
		query.append("     														   AND ROWNUM         <=1" ).append("\n"); 
		query.append("      														 )" ).append("\n"); 
		query.append("    									)" ).append("\n"); 
		query.append("		AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("		AND L.RLANE_CD = NVL(PSO_GET_REV_LANE_FNC(@[vsl_cd], @[skd_voy_no], @[skd_dir_cd], V.VPS_PORT_CD), L.RLANE_CD)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(",	(SELECT L.RLANE_CD" ).append("\n"); 
		query.append("	   FROM VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("  			AR_MST_REV_VVD L" ).append("\n"); 
		query.append("	  WHERE V.VSL_CD               	 = L.VSL_CD" ).append("\n"); 
		query.append("		AND V.SKD_VOY_NO             = L.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND V.SKD_DIR_CD             = L.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND V.SLAN_CD                = L.SLAN_CD" ).append("\n"); 
		query.append("		AND V.VSL_CD                 = @[vsl_cd]" ).append("\n"); 
		query.append("		AND V.SKD_VOY_NO             = @[skd_voy_no]" ).append("\n"); 
		query.append("		AND V.SKD_DIR_CD             = @[skd_dir_cd]" ).append("\n"); 
		query.append("		AND V.VPS_PORT_CD            = (SELECT SUBSTR(X.YD_CD, 1, 5)" ).append("\n"); 
		query.append("   										  FROM PSO_CHARGE X" ).append("\n"); 
		query.append("    									 WHERE ISS_CTY_CD =" ).append("\n"); 
		query.append("      														(SELECT" ).append("\n"); 
		query.append("        														/*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("        															ISS_CTY_CD" ).append("\n"); 
		query.append("      														   FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("      														  WHERE T1.ISS_CTY_CD = 'PUS'" ).append("\n"); 
		query.append("    														    AND T1.SO_SEQ      >= 0" ).append("\n"); 
		query.append("      															AND ROWNUM         <=1" ).append("\n"); 
		query.append("     														)" ).append("\n"); 
		query.append("    									   AND SO_SEQ=" ).append("\n"); 
		query.append("      														(SELECT" ).append("\n"); 
		query.append("        														/*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("        															SO_SEQ" ).append("\n"); 
		query.append("      														  FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("      														 WHERE T1.ISS_CTY_CD = 'PUS'" ).append("\n"); 
		query.append("      														   AND T1.SO_SEQ      >= 0" ).append("\n"); 
		query.append("     														   AND ROWNUM         <=1" ).append("\n"); 
		query.append("      														 )" ).append("\n"); 
		query.append("    									)" ).append("\n"); 
		query.append("		AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("		AND L.RLANE_CD = NVL(PSO_GET_REV_LANE_FNC(@[vsl_cd], @[skd_voy_no], @[skd_dir_cd], V.VPS_PORT_CD), L.RLANE_CD)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(",	@[lgs_cost_cd]" ).append("\n"); 
		query.append(",	@[io_bnd_cd]" ).append("\n"); 
		query.append(",	@[locl_amt]" ).append("\n"); 
		query.append(",	@[usd_amt]" ).append("\n"); 
		query.append(",	@[calc_amt]" ).append("\n"); 
		query.append(",	DECODE(SUBSTR(@[lgs_cost_cd],1,2),'CN',@[locl_amt] - @[calc_amt], @[adj_amt])" ).append("\n"); 
		query.append(",	@[xpr_desc]" ).append("\n"); 
		query.append(",	@[foml_desc]" ).append("\n"); 
		query.append(",	@[yd_chg_ver_seq]" ).append("\n"); 
		query.append(",	@[yd_chg_no]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	(SELECT " ).append("\n"); 
		query.append("  			REV_YRMON" ).append("\n"); 
		query.append("	   FROM VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("  			AR_MST_REV_VVD L" ).append("\n"); 
		query.append("	  WHERE V.VSL_CD               	 = L.VSL_CD" ).append("\n"); 
		query.append("		AND V.SKD_VOY_NO             = L.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND V.SKD_DIR_CD             = L.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND V.SLAN_CD                = L.SLAN_CD" ).append("\n"); 
		query.append("		AND V.VSL_CD                 = @[vsl_cd]" ).append("\n"); 
		query.append("		AND V.SKD_VOY_NO             = @[skd_voy_no]" ).append("\n"); 
		query.append("		AND V.SKD_DIR_CD             = @[skd_dir_cd]" ).append("\n"); 
		query.append("		AND V.VPS_PORT_CD            = (SELECT SUBSTR(X.YD_CD, 1, 5)" ).append("\n"); 
		query.append("   										  FROM PSO_CHARGE X" ).append("\n"); 
		query.append("    									 WHERE ISS_CTY_CD =" ).append("\n"); 
		query.append("      														(SELECT" ).append("\n"); 
		query.append("        														/*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("        															ISS_CTY_CD" ).append("\n"); 
		query.append("      														   FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("      														  WHERE T1.ISS_CTY_CD = 'PUS'" ).append("\n"); 
		query.append("    														    AND T1.SO_SEQ      >= 0" ).append("\n"); 
		query.append("      															AND ROWNUM         <=1" ).append("\n"); 
		query.append("     														)" ).append("\n"); 
		query.append("    									   AND SO_SEQ=" ).append("\n"); 
		query.append("      														(SELECT" ).append("\n"); 
		query.append("        														/*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("        															SO_SEQ" ).append("\n"); 
		query.append("      														  FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("      														 WHERE T1.ISS_CTY_CD = 'PUS'" ).append("\n"); 
		query.append("      														   AND T1.SO_SEQ      >= 0" ).append("\n"); 
		query.append("     														   AND ROWNUM         <=1" ).append("\n"); 
		query.append("      														 )" ).append("\n"); 
		query.append("    									)" ).append("\n"); 
		query.append("		AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("		AND L.RLANE_CD = NVL(PSO_GET_REV_LANE_FNC(@[vsl_cd], @[skd_voy_no], @[skd_dir_cd], V.VPS_PORT_CD), L.RLANE_CD)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",@[so_dtl_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}