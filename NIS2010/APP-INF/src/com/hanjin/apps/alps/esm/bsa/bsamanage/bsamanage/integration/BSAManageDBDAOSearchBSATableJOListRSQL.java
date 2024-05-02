/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAManageDBDAOSearchBSATableJOListRSQL.java
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

public class BSAManageDBDAOSearchBSATableJOListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBSATableJOList
	  * 2014.05.12 JO 계약조회시 현재 유효한 계약만 조회도록 조회 조건 추가
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public BSAManageDBDAOSearchBSATableJOListRSQL(){
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
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchBSATableJOListRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED USE_NL(C A) */" ).append("\n"); 
		query.append("        A.BSA_GROUP " ).append("\n"); 
		query.append("      , A.BSA_SEQ " ).append("\n"); 
		query.append("      , A.TRD_CD" ).append("\n"); 
		query.append("      , C.SUB_TRD_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 
		query.append("      , A.VOP_CD" ).append("\n"); 
		query.append("      , A.VSL_CAPA" ).append("\n"); 
		query.append("      , A.VVD_CD" ).append("\n"); 
		query.append("      , A.BSA_FM_DT" ).append("\n"); 
		query.append("      , A.BSA_TO_DT" ).append("\n"); 
		query.append("      , A.BSA_CAPA" ).append("\n"); 
		query.append("      , A.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      , A.HJS_BSA_BFR_SUB_CAPA" ).append("\n"); 
		query.append("      , A.JO_DESC" ).append("\n"); 
		query.append("      , A.SPC_OTR_SWAP_FLG" ).append("\n"); 
		query.append("      , A.OWNR_VSL_WGT" ).append("\n"); 
		query.append("      , A.UPD_USR_ID " ).append("\n"); 
		query.append("#set($count = 0) " ).append("\n"); 
		query.append("     	#foreach(${keys} IN ${keyList})" ).append("\n"); 
		query.append("	  , BSA_GET_CRR_CAPA_FNC(A.TRD_CD,A.RLANE_CD,A.DIR_CD,A.VOP_CD,A.VSL_CAPA,A.BSA_SEQ,'${keys.bsaOpJbCd}', '${keys.crrCd}', @[rdoopcd]) AS CRR_BSA_CAPA$count" ).append("\n"); 
		query.append("#set($count = $count + 1)" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (SELECT DENSE_RANK() OVER(ORDER BY TRD_CD,RLANE_CD,DIR_CD,VOP_CD,VSL_CAPA) AS BSA_GROUP" ).append("\n"); 
		query.append("              , BSA_SEQ" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , VOP_CD" ).append("\n"); 
		query.append("              , VSL_CAPA" ).append("\n"); 
		query.append("              , VVD_CD" ).append("\n"); 
		query.append("              , BSA_FM_DT" ).append("\n"); 
		query.append("              , BSA_TO_DT" ).append("\n"); 
		query.append("              , BSA_CAPA" ).append("\n"); 
		query.append("              , FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("              , HJS_BSA_BFR_SUB_CAPA" ).append("\n"); 
		query.append("              , JO_DESC" ).append("\n"); 
		query.append("              , SPC_OTR_SWAP_FLG" ).append("\n"); 
		query.append("              , OWNR_VSL_WGT" ).append("\n"); 
		query.append("              , UPD_USR_ID" ).append("\n"); 
		query.append("           FROM BSA_JNT_OP_BZC" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("#if (${cobtrade} != '')" ).append("\n"); 
		query.append("            AND TRD_CD            = @[cobtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${coblane} != '')" ).append("\n"); 
		query.append("            AND RLANE_CD          = @[coblane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cobdir} != '')" ).append("\n"); 
		query.append("            AND DIR_CD            = @[cobdir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${excludVslCapa} == 'Y')" ).append("\n"); 
		query.append("AND (TRD_CD ,RLANE_CD ,DIR_CD ,VOP_CD, VSL_CAPA ) " ).append("\n"); 
		query.append("                IN (   " ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                           a.trd_cd," ).append("\n"); 
		query.append("                           a.rlane_cd," ).append("\n"); 
		query.append("                           a.dir_cd," ).append("\n"); 
		query.append("                           b.vop_cd," ).append("\n"); 
		query.append("                           DECODE(NVL(b.sub_trd_capa,0),0,NVL(b.stnd_ldb_capa,0),NVL(b.sub_trd_capa,0)) AS vsl_capa" ).append("\n"); 
		query.append("                      FROM mas_mon_vvd a," ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                            SELECT DISTINCT  a.vsl_cd ," ).append("\n"); 
		query.append("                                a.sub_trd_cd ," ).append("\n"); 
		query.append("                                a.sub_trd_capa ," ).append("\n"); 
		query.append("                                a.stnd_ldb_capa ," ).append("\n"); 
		query.append("                                a.vop_cd ," ).append("\n"); 
		query.append("                               TO_CHAR( a.vsl_aply_fm_dt ,'yyyymmdd') vsl_aply_fom_dt," ).append("\n"); 
		query.append("                               TO_CHAR( a.vsl_aply_to_dt ,'yyyymmdd')  vsl_aply_to_dt" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT x.vsl_cd, y.sub_trd_cd, y.sub_trd_capa, x.stnd_ldb_capa," ).append("\n"); 
		query.append("                                       x.vop_cd, x.vsl_aply_fm_dt vsl_aply_fm_dt, x.vsl_aply_to_dt vsl_aply_to_dt" ).append("\n"); 
		query.append("                                  FROM mas_vsl_rgst x," ).append("\n"); 
		query.append("                                       (" ).append("\n"); 
		query.append("                                        SELECT b.vsl_cd, b.vsl_seq, b.sub_trd_cd, b.sub_trd_capa" ).append("\n"); 
		query.append("                                          FROM mdm_sub_trd a, mas_vsl_sub_trd_capa b" ).append("\n"); 
		query.append("                                         WHERE a.delt_flg <> 'Y'" ).append("\n"); 
		query.append("                                           AND a.sub_trd_cd      = b.sub_trd_cd" ).append("\n"); 
		query.append("                                       ) y" ).append("\n"); 
		query.append("                                 WHERE x.vsl_cd             = y.vsl_cd(+)" ).append("\n"); 
		query.append("                                   AND x.vsl_seq            = y.vsl_seq(+)" ).append("\n"); 
		query.append("                                   AND NVL(x.delt_flg,'N')  = 'N'" ).append("\n"); 
		query.append("                                   AND x.vsl_tp_cd          = 'C'" ).append("\n"); 
		query.append("                                ) a" ).append("\n"); 
		query.append("                           ) b" ).append("\n"); 
		query.append("                     WHERE a.vsl_cd            = b.vsl_cd(+)" ).append("\n"); 
		query.append("                       AND a.sub_trd_cd        = b.sub_trd_cd(+)" ).append("\n"); 
		query.append("                       AND NVL(a.delt_flg,'N') <> 'Y' " ).append("\n"); 
		query.append("#if (${cobtrade} != '')" ).append("\n"); 
		query.append("                       AND a.trd_cd            = NVL(@[cobtrade] , a.trd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${coblane} != '')" ).append("\n"); 
		query.append("                       AND a.rlane_cd          = NVL(@[coblane], a.rlane_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cobdir} != '')" ).append("\n"); 
		query.append("                       AND a.dir_cd            = NVL(@[cobdir] , a.dir_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(b.vsl_aply_fom_dt ,'19000101') AND NVL(b.vsl_aply_to_dt , '99991231')" ).append("\n"); 
		query.append("                       AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') >= @[txtsdate]" ).append("\n"); 
		query.append("                       AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                                     FROM bsa_jnt_op_bzc d" ).append("\n"); 
		query.append("                                    WHERE d.trd_cd   = a.trd_cd" ).append("\n"); 
		query.append("                                      AND d.rlane_cd = a.rlane_cd" ).append("\n"); 
		query.append("                                      AND d.dir_cd   = a.dir_cd" ).append("\n"); 
		query.append("                                      AND d.vop_cd   = b.vop_cd" ).append("\n"); 
		query.append("                                      AND d.vsl_capa = decode(nvl(b.sub_trd_capa,0),0,nvl(b.stnd_ldb_capa,0),nvl(b.sub_trd_capa,0))" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                         GROUP BY" ).append("\n"); 
		query.append("                               a.trd_cd," ).append("\n"); 
		query.append("                               a.rlane_cd," ).append("\n"); 
		query.append("                               a.dir_cd," ).append("\n"); 
		query.append("                               b.vop_cd," ).append("\n"); 
		query.append("                               DECODE(NVL(b.sub_trd_capa,0),0,NVL(b.stnd_ldb_capa,0),NVL(b.sub_trd_capa,0))" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("      , (SELECT DISTINCT TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , IOC_CD" ).append("\n"); 
		query.append("              , A.SUB_TRD_CD" ).append("\n"); 
		query.append("              , A.SLAN_CD" ).append("\n"); 
		query.append("           FROM MAS_LANE_RGST A" ).append("\n"); 
		query.append("           FULL OUTER JOIN MAS_LANE_TP_HIS B USING (TRD_CD, RLANE_CD, DIR_CD, IOC_CD)" ).append("\n"); 
		query.append("          WHERE NVL(B.VSL_LANE_TP_CD, A.VSL_LANE_TP_CD) = 'JO'" ).append("\n"); 
		query.append("            AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#if (${cobtrade} != '')" ).append("\n"); 
		query.append("            AND TRD_CD            = @[cobtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("  WHERE A.TRD_CD            = C.TRD_CD" ).append("\n"); 
		query.append("    AND A.RLANE_CD          = C.RLANE_CD" ).append("\n"); 
		query.append("    AND A.DIR_CD            = C.DIR_CD" ).append("\n"); 
		query.append("    AND A.BSA_TO_DT        >= @[txtsdate]" ).append("\n"); 
		query.append("#if (${cobtrade} != '')" ).append("\n"); 
		query.append("    AND A.TRD_CD            = @[cobtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${coblane} != '')" ).append("\n"); 
		query.append("    AND A.RLANE_CD          = @[coblane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cobdir} != '')" ).append("\n"); 
		query.append("    AND A.DIR_CD            = @[cobdir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--  GROUP BY A.BSA_GROUP" ).append("\n"); 
		query.append("--      , A.BSA_SEQ" ).append("\n"); 
		query.append("--      , A.TRD_CD" ).append("\n"); 
		query.append("--      , C.SUB_TRD_CD" ).append("\n"); 
		query.append("--      , A.RLANE_CD" ).append("\n"); 
		query.append("--      , A.DIR_CD" ).append("\n"); 
		query.append("--      , A.VOP_CD" ).append("\n"); 
		query.append("--      , A.VSL_CAPA" ).append("\n"); 
		query.append("--      , A.VVD_CD" ).append("\n"); 
		query.append("--      , A.BSA_FM_DT" ).append("\n"); 
		query.append("--      , A.BSA_TO_DT" ).append("\n"); 
		query.append("--      , A.BSA_CAPA" ).append("\n"); 
		query.append("--      , A.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("--      , A.HJS_BSA_BFR_SUB_CAPA" ).append("\n"); 
		query.append("--      , A.JO_DESC" ).append("\n"); 
		query.append("--      , A.SPC_OTR_SWAP_FLG" ).append("\n"); 
		query.append("--      , A.OWNR_VSL_WGT" ).append("\n"); 
		query.append("--      , A.UPD_USR_ID" ).append("\n"); 
		query.append("  ORDER BY A.BSA_GROUP" ).append("\n"); 
		query.append("      , A.BSA_SEQ" ).append("\n"); 

	}
}