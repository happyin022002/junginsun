/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAManageDBDAOSearchOverlappedContractInquiryJOListRSQL.java
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

public class BSAManageDBDAOSearchOverlappedContractInquiryJOListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 중복 계약 조회 (JOINT OPERATING)
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public BSAManageDBDAOSearchOverlappedContractInquiryJOListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : BSAManageDBDAOSearchOverlappedContractInquiryJOListRSQL").append("\n"); 
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
		query.append("WITH TARGET_AGREE AS" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("   SELECT DENSE_RANK() OVER(ORDER BY TRD_CD,RLANE_CD,DIR_CD,VOP_CD,VSL_CAPA) AS BSA_GROUP" ).append("\n"); 
		query.append("          , BSA_SEQ" ).append("\n"); 
		query.append("          , TRD_CD" ).append("\n"); 
		query.append("          , RLANE_CD" ).append("\n"); 
		query.append("          , DIR_CD" ).append("\n"); 
		query.append("          , VOP_CD" ).append("\n"); 
		query.append("          , VSL_CAPA" ).append("\n"); 
		query.append("          , VVD_CD" ).append("\n"); 
		query.append("          , BSA_CAPA" ).append("\n"); 
		query.append("          , BSA_FM_DT" ).append("\n"); 
		query.append("          , BSA_TO_DT" ).append("\n"); 
		query.append("          , FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("          , HJS_BSA_BFR_SUB_CAPA" ).append("\n"); 
		query.append("          , JO_DESC" ).append("\n"); 
		query.append("          , SPC_OTR_SWAP_FLG" ).append("\n"); 
		query.append("          , OWNR_VSL_WGT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("       FROM BSA_JNT_OP_BZC" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("        --AND TRD_CD            = 'IAS'" ).append("\n"); 
		query.append("        --AND RLANE_CD          = 'AUSIA'" ).append("\n"); 
		query.append("        AND (TRD_CD ,RLANE_CD ,DIR_CD ,VOP_CD, VSL_CAPA ) " ).append("\n"); 
		query.append("         IN (   -- 선택된 기간 이후 유효한 계약만 확인 시 체크" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                       A.TRD_CD," ).append("\n"); 
		query.append("                       A.RLANE_CD," ).append("\n"); 
		query.append("                       A.DIR_CD," ).append("\n"); 
		query.append("                       B.VOP_CD," ).append("\n"); 
		query.append("                       DECODE(NVL(B.SUB_TRD_CAPA,0),0,NVL(B.STND_LDB_CAPA,0),NVL(B.SUB_TRD_CAPA,0)) AS VSL_CAPA" ).append("\n"); 
		query.append("                  FROM MAS_MON_VVD A," ).append("\n"); 
		query.append("                       (" ).append("\n"); 
		query.append("                        SELECT DISTINCT  A.VSL_CD ," ).append("\n"); 
		query.append("                            A.SUB_TRD_CD ," ).append("\n"); 
		query.append("                            A.SUB_TRD_CAPA ," ).append("\n"); 
		query.append("                            A.STND_LDB_CAPA ," ).append("\n"); 
		query.append("                            A.VOP_CD ," ).append("\n"); 
		query.append("                           TO_CHAR( A.VSL_APLY_FM_DT ,'YYYYMMDD') VSL_APLY_FOM_DT," ).append("\n"); 
		query.append("                           TO_CHAR( A.VSL_APLY_TO_DT ,'YYYYMMDD')  VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                            SELECT X.VSL_CD, Y.SUB_TRD_CD, Y.SUB_TRD_CAPA, X.STND_LDB_CAPA," ).append("\n"); 
		query.append("                                   X.VOP_CD, X.VSL_APLY_FM_DT VSL_APLY_FM_DT, X.VSL_APLY_TO_DT VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                              FROM MAS_VSL_RGST X," ).append("\n"); 
		query.append("                                   (" ).append("\n"); 
		query.append("                                    SELECT B.VSL_CD, B.VSL_SEQ, B.SUB_TRD_CD, B.SUB_TRD_CAPA" ).append("\n"); 
		query.append("                                      FROM MDM_SUB_TRD A, MAS_VSL_SUB_TRD_CAPA B" ).append("\n"); 
		query.append("                                     WHERE A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                                       AND A.SUB_TRD_CD      = B.SUB_TRD_CD" ).append("\n"); 
		query.append("                                   ) Y" ).append("\n"); 
		query.append("                             WHERE X.VSL_CD             = Y.VSL_CD(+)" ).append("\n"); 
		query.append("                               AND X.VSL_SEQ            = Y.VSL_SEQ(+)" ).append("\n"); 
		query.append("                               AND NVL(X.DELT_FLG,'N')  = 'N'" ).append("\n"); 
		query.append("                               AND X.VSL_TP_CD          = 'C'" ).append("\n"); 
		query.append("                            ) A" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD            = B.VSL_CD(+)" ).append("\n"); 
		query.append("                   AND A.SUB_TRD_CD        = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("                   AND NVL(A.DELT_FLG,'N') <> 'Y' " ).append("\n"); 
		query.append("                   AND A.TRD_CD            = NVL( NULLIF(@[cobtrade], 'All') , A.TRD_CD)" ).append("\n"); 
		query.append("				   AND A.RLANE_CD 		   = NVL( NULLIF(@[coblane], 'All') , A.RLANE_CD)" ).append("\n"); 
		query.append("                   AND A.DIR_CD            = NVL( NULLIF(@[cobdir], 'All') ,A.DIR_CD)" ).append("\n"); 
		query.append("                   AND TO_CHAR(A.N1ST_LODG_PORT_ETD_DT,'YYYYMMDD') BETWEEN NVL(B.VSL_APLY_FOM_DT ,'19000101') AND NVL(B.VSL_APLY_TO_DT , '99991231')" ).append("\n"); 
		query.append("                   AND TO_CHAR(A.N1ST_LODG_PORT_ETD_DT,'YYYYMMDD') >= NVL( REPLACE(@[txtsdate],'-','') ,'19000101')" ).append("\n"); 
		query.append("                   AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                                 FROM BSA_JNT_OP_BZC D" ).append("\n"); 
		query.append("                                WHERE D.TRD_CD   = A.TRD_CD" ).append("\n"); 
		query.append("                                  AND D.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("                                  AND D.DIR_CD   = A.DIR_CD" ).append("\n"); 
		query.append("                                  AND D.VOP_CD   = B.VOP_CD" ).append("\n"); 
		query.append("                                  AND D.VSL_CAPA = DECODE(NVL(B.SUB_TRD_CAPA,0),0,NVL(B.STND_LDB_CAPA,0),NVL(B.SUB_TRD_CAPA,0))" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                     GROUP BY" ).append("\n"); 
		query.append("                           A.TRD_CD," ).append("\n"); 
		query.append("                           A.RLANE_CD," ).append("\n"); 
		query.append("                           A.DIR_CD," ).append("\n"); 
		query.append("                           B.VOP_CD," ).append("\n"); 
		query.append("                           DECODE(NVL(B.SUB_TRD_CAPA,0),0,NVL(B.STND_LDB_CAPA,0),NVL(B.SUB_TRD_CAPA,0))" ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       A2.BSA_GROUP  ," ).append("\n"); 
		query.append("       A2.BSA_SEQ    ,       " ).append("\n"); 
		query.append("       A2.VVD_CD     ," ).append("\n"); 
		query.append("       A2.BSA_FM_DT  ," ).append("\n"); 
		query.append("       A2.BSA_TO_DT  ,       " ).append("\n"); 
		query.append("       A2.TRD_CD     ," ).append("\n"); 
		query.append("       A2.RLANE_CD   ," ).append("\n"); 
		query.append("       A2.DIR_CD     ," ).append("\n"); 
		query.append("       A2.VOP_CD     ," ).append("\n"); 
		query.append("       A2.VSL_CAPA   ," ).append("\n"); 
		query.append("       --A2.BSA_CAPA   ,       " ).append("\n"); 
		query.append("       --A2.FNL_HJS_BSA_CAPA    ," ).append("\n"); 
		query.append("       --A2.HJS_BSA_BFR_SUB_CAPA," ).append("\n"); 
		query.append("       --A2.JO_DESC    ," ).append("\n"); 
		query.append("       --A2.SPC_OTR_SWAP_FLG    ," ).append("\n"); 
		query.append("       --A2.OWNR_VSL_WGT        ," ).append("\n"); 
		query.append("       DECODE(A2.BSA_FM_DT,A2.BSA_TO_DT,'N',DECODE(LEAST(A2.BSA_FM_DT,A2.BSA_TO_DT),A2.BSA_TO_DT,'Y','N')) AS REVERSE_FLG" ).append("\n"); 
		query.append("  FROM TARGET_AGREE A1," ).append("\n"); 
		query.append("       TARGET_AGREE A2" ).append("\n"); 
		query.append(" WHERE A1.BSA_GROUP = A2.BSA_GROUP" ).append("\n"); 
		query.append("   AND A1.TRD_CD    = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD  = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD    = A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.VOP_CD    = A2.VOP_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CAPA  = A2.VSL_CAPA" ).append("\n"); 
		query.append("   AND (A2.BSA_TO_DT BETWEEN A1.BSA_FM_DT AND A1.BSA_TO_DT  " ).append("\n"); 
		query.append("        OR A2.BSA_FM_DT BETWEEN A1.BSA_FM_DT AND A1.BSA_TO_DT)" ).append("\n"); 
		query.append("   AND A1.BSA_SEQ   < A2.BSA_SEQ    " ).append("\n"); 
		query.append(" ORDER BY A2.BSA_GROUP," ).append("\n"); 
		query.append("       A2.BSA_SEQ ," ).append("\n"); 
		query.append("       A2.TRD_CD  ," ).append("\n"); 
		query.append("       A2.RLANE_CD," ).append("\n"); 
		query.append("       A2.DIR_CD  ," ).append("\n"); 
		query.append("       A2.VOP_CD  ," ).append("\n"); 
		query.append("       A2.VSL_CAPA" ).append("\n"); 

	}
}