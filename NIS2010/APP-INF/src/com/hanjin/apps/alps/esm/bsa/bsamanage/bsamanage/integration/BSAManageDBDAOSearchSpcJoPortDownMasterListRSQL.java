/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAManageDBDAOSearchSpcJoPortDownMasterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchSpcJoPortDownMasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpcJoPortDownMasterList SELECT
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public BSAManageDBDAOSearchSpcJoPortDownMasterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdoopcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobCarrier",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdotype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchSpcJoPortDownMasterListRSQL").append("\n"); 
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
		query.append("      A.BSA_SEQ" ).append("\n"); 
		query.append("     ,A.TRD_CD" ).append("\n"); 
		query.append("     ,A.RLANE_CD" ).append("\n"); 
		query.append("     ,A.DIR_CD" ).append("\n"); 
		query.append("     ,A.VOP_CD" ).append("\n"); 
		query.append("     ,A.VVD_CD" ).append("\n"); 
		query.append("     ,A.VSL_CAPA" ).append("\n"); 
		query.append("     ,A.BSA_FM_DT" ).append("\n"); 
		query.append("     ,A.BSA_TO_DT" ).append("\n"); 
		query.append("     ,SUM(A.BSA_CAPA) AS BSA_CAPA" ).append("\n"); 
		query.append("     ,SUM(A.FNL_HJS_BSA_CAPA) AS FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("     ,B.BSA_OP_CD" ).append("\n"); 
		query.append("     ,B.BSA_OP_JB_CD" ).append("\n"); 
		query.append("     ,B.CRR_CD, C.STUP_FLG" ).append("\n"); 
		query.append("     ,SUM(B.SPC_CTRL_SLT_CAPA) AS CRR_BSA_CAPA" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("      BSA_JNT_OP_BZC      A" ).append("\n"); 
		query.append("     ,BSA_JNT_OP_CRR_CAPA B" ).append("\n"); 
		query.append("     ,MAS_LANE_RGST       C" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("       A.BSA_SEQ   = B.BSA_SEQ" ).append("\n"); 
		query.append("AND    A.TRD_CD    = B.TRD_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD  = B.RLANE_CD" ).append("\n"); 
		query.append("AND    A.DIR_CD    = B.DIR_CD" ).append("\n"); 
		query.append("AND    A.VOP_CD    = B.VOP_CD" ).append("\n"); 
		query.append("AND    A.VSL_CAPA  = B.VSL_CAPA" ).append("\n"); 
		query.append("AND    A.TRD_CD    = C.TRD_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD  = C.RLANE_CD" ).append("\n"); 
		query.append("AND    A.DIR_CD    = C.DIR_CD" ).append("\n"); 
		query.append("AND    NVL(C.STUP_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND    NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND    A.BSA_TO_DT >= @[txtsdate]" ).append("\n"); 
		query.append("#if (${cobtrade} != '')" ).append("\n"); 
		query.append("   AND A.TRD_CD = @[cobtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${coblane} != '')" ).append("\n"); 
		query.append("   AND A.RLANE_CD = @[coblane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cobdir} != '')" ).append("\n"); 
		query.append("   AND A.DIR_CD = @[cobdir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    B.BSA_OP_CD = @[rdoopcd]" ).append("\n"); 
		query.append("AND    B.BSA_OP_JB_CD = @[rdotype]" ).append("\n"); 
		query.append("AND    B.CRR_CD = @[cobCarrier]" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("        A.BSA_SEQ, " ).append("\n"); 
		query.append("        A.TRD_CD, " ).append("\n"); 
		query.append("        A.RLANE_CD, " ).append("\n"); 
		query.append("        A.DIR_CD, " ).append("\n"); 
		query.append("        A.VOP_CD, " ).append("\n"); 
		query.append("        A.VVD_CD, " ).append("\n"); 
		query.append("        A.VSL_CAPA," ).append("\n"); 
		query.append("        A.BSA_FM_DT," ).append("\n"); 
		query.append("        A.BSA_TO_DT, " ).append("\n"); 
		query.append("        B.BSA_OP_CD, " ).append("\n"); 
		query.append("        B.BSA_OP_JB_CD," ).append("\n"); 
		query.append("        B.CRR_CD, " ).append("\n"); 
		query.append("        C.STUP_FLG" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("        A.TRD_CD, " ).append("\n"); 
		query.append("        A.RLANE_CD, " ).append("\n"); 
		query.append("        A.DIR_CD, " ).append("\n"); 
		query.append("        A.VOP_CD, " ).append("\n"); 
		query.append("        A.VSL_CAPA, " ).append("\n"); 
		query.append("        A.BSA_SEQ" ).append("\n"); 

	}
}