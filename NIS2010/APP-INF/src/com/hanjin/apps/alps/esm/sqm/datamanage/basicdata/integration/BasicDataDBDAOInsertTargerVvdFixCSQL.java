/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BasicDataDBDAOInsertTargerVvdFixCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOInsertTargerVvdFixCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0005화면에서 save시 입력쿼리
	  * 
	  * 2016.04.20 CHM-201640366 Target VVD Fix 월기준 항차 생성 등 개선 CSR
	  * </pre>
	  */
	public BasicDataDBDAOInsertTargerVvdFixCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOInsertTargerVvdFixCSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_QTA_TGT_VVD A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("     SELECT D.BSE_TP_CD, D.BSE_YR, D.BSE_QTR_CD, D.TRD_CD, D.RLANE_CD, D.DIR_CD, D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD" ).append("\n"); 
		query.append("	, D.BSE_MON, D.BSE_WK, D.SUB_TRD_CD, nvl(M.IOC_CD,'00') IOC_CD, D.FNL_BSA_CAPA, M.DELT_FLG, D.PF_SVC_TP_CD" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("        (SELECT" ).append("\n"); 
		query.append("		@[bse_mon] BSE_MON" ).append("\n"); 
		query.append("		, @[bse_wk]  BSE_WK" ).append("\n"); 
		query.append("		, @[fnl_bsa_capa] FNL_BSA_CAPA" ).append("\n"); 
		query.append("		, @[bse_tp_cd] BSE_TP_CD" ).append("\n"); 
		query.append("		, @[bse_yr] BSE_YR" ).append("\n"); 
		query.append("		, decode(@[bse_tp_cd],'Y','00',@[bse_qtr_cd]) BSE_QTR_CD" ).append("\n"); 
		query.append("		, @[trd_cd] TRD_CD" ).append("\n"); 
		query.append("		, @[dir_cd] DIR_CD" ).append("\n"); 
		query.append("		, @[sub_trd_cd] SUB_TRD_CD" ).append("\n"); 
		query.append("		, @[rlane_cd] RLANE_CD" ).append("\n"); 
		query.append("		, @[vsl_cd] VSL_CD" ).append("\n"); 
		query.append("		, @[skd_voy_no] SKD_VOY_NO" ).append("\n"); 
		query.append("		, @[skd_dir_cd] SKD_DIR_CD" ).append("\n"); 
		query.append("		, NVL( (SELECT PF_SKD_TP_CD " ).append("\n"); 
		query.append("                FROM VSK_VSL_SKD V, MAS_MON_VVD M" ).append("\n"); 
		query.append("                WHERE V.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("                    AND V.SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("                    AND V.SKD_DIR_CD = @[dir_cd] " ).append("\n"); 
		query.append("                    AND V.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("                    AND V.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND V.SKD_DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append("                    AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND M.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                    AND M.RLANE_CD = @[rlane_cd]),'11111') PF_SVC_TP_CD" ).append("\n"); 
		query.append("	FROM DUAL ) D , MAS_MON_VVD M" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("--      AND M.VSL_CD = 'AAAA'" ).append("\n"); 
		query.append("--      AND M.SKD_VOY_NO = '0000'" ).append("\n"); 
		query.append("--      AND M.DIR_CD = 'E'" ).append("\n"); 
		query.append("--      AND M.TRD_CD = 'AES'" ).append("\n"); 
		query.append("--      AND M.RLANE_CD = 'ADNAE'" ).append("\n"); 
		query.append("      AND M.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("      AND M.VSL_CD(+) = D.VSL_CD" ).append("\n"); 
		query.append("      AND M.SKD_VOY_NO(+) = D.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND M.DIR_CD(+) = D.DIR_CD" ).append("\n"); 
		query.append("      AND M.TRD_CD(+) = D.TRD_CD" ).append("\n"); 
		query.append("      AND M.RLANE_CD(+) = D.RLANE_CD" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON(" ).append("\n"); 
		query.append("	B.BSE_TP_CD    = A.BSE_TP_CD" ).append("\n"); 
		query.append("  AND B.BSE_YR       = A.BSE_YR" ).append("\n"); 
		query.append("  AND B.BSE_QTR_CD   = A.BSE_QTR_CD" ).append("\n"); 
		query.append("  AND B.TRD_CD       = A.TRD_CD" ).append("\n"); 
		query.append("  AND B.DIR_CD       = A.DIR_CD" ).append("\n"); 
		query.append("  AND B.SUB_TRD_CD   = A.SUB_TRD_CD" ).append("\n"); 
		query.append("  AND B.RLANE_CD     = A.RLANE_CD" ).append("\n"); 
		query.append("  AND B.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("  AND B.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND B.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN  " ).append("\n"); 
		query.append("INSERT(BSE_TP_CD, BSE_YR, BSE_QTR_CD, TRD_CD, RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("	, BSE_MON, BSE_WK, SUB_TRD_CD, IOC_CD, FNL_BSA_CAPA, DELT_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, PF_SVC_TP_CD" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append(" VALUES(B.BSE_TP_CD, B.BSE_YR, B.BSE_QTR_CD, B.TRD_CD, B.RLANE_CD, B.DIR_CD, B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD" ).append("\n"); 
		query.append("	, B.BSE_MON, B.BSE_WK, B.SUB_TRD_CD, B.IOC_CD, B.FNL_BSA_CAPA, 'N', @[cre_usr_id], sysdate, @[cre_usr_id], sysdate, B.PF_SVC_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}