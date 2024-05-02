/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOCreateQtaEditPolPodPairAddIasSectorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOCreateQtaEditPolPodPairAddIasSectorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Edit POL-POD Pair Add for IAS Sector을 생성합니다.
	  * 
	  * *History
	  * 2014.06.26 이혜민 PAIR, Office는 같은데 POL_CALL_SEQ, POD_CALL_SEQ 가 달라 중복 데이터 insert 수정
	  * </pre>
	  */
	public QtaAdjustmentDBDAOCreateQtaEditPolPodPairAddIasSectorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOCreateQtaEditPolPodPairAddIasSectorCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_SCTR_CFM_QTA(QTA_RLSE_VER_NO, BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, RGN_OFC_CD, POL_CD, POD_CD, PF_GRP_CD, TRD_CD, SUB_TRD_CD, RHQ_CD, AQ_CD, FNL_BSA_CAPA, LOD_QTY, GRS_RPB_REV, PA_CM_UC_AMT, RA_CM_UC_AMT, POL_CALL_SEQ, POD_CALL_SEQ, CSQ_CNG_TP_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("            SELECT DISTINCT " ).append("\n"); 
		query.append("                   A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                  ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("                  ,A1.BSE_YR" ).append("\n"); 
		query.append("                  ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                  ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("                  ,A1.RLANE_CD" ).append("\n"); 
		query.append("                  ,A1.DIR_CD" ).append("\n"); 
		query.append("                  ,A2.VSL_CD" ).append("\n"); 
		query.append("                  ,A2.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,A2.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("                  ,A1.POL_CD" ).append("\n"); 
		query.append("                  ,A1.POD_CD" ).append("\n"); 
		query.append("--                  ,A1.PF_GRP_CD" ).append("\n"); 
		query.append("                  ,(" ).append("\n"); 
		query.append("                    SELECT MAX(PF_GRP_CD) FROM CSQ_SCTR_PAIR_MGMT A1" ).append("\n"); 
		query.append("                    WHERE A1.BSE_TP_CD   = @[bse_tp_cd]" ).append("\n"); 
		query.append("                    AND   A1.BSE_YR      = @[bse_yr]" ).append("\n"); 
		query.append("                    AND   A1.BSE_QTR_CD  = @[bse_qtr_cd]" ).append("\n"); 
		query.append("                    AND   A1.SUB_TRD_CD  = @[sub_trd_cd]" ).append("\n"); 
		query.append("                    AND   A1.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("                    AND   A1.DIR_CD      = @[dir_cd]" ).append("\n"); 
		query.append("                    AND   A1.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("                    AND   A1.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("                   ) PF_GRP_CD" ).append("\n"); 
		query.append("                  ,A1.TRD_CD" ).append("\n"); 
		query.append("                  ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                  ,A1.RHQ_CD" ).append("\n"); 
		query.append("--                  ,'' AS AQ_CD" ).append("\n"); 
		query.append("                  ,NVL((SELECT N3RD_PRNT_OFC_CD FROM CSQ_ORGANIZATION_V WHERE OFC_CD = A1.RGN_OFC_CD),'') AS AQ_CD" ).append("\n"); 
		query.append("                  ,A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                  ,A2.LOD_QTY" ).append("\n"); 
		query.append("                  ,A2.GRS_REV" ).append("\n"); 
		query.append("                  ,A3.PA_CM_UC_AMT" ).append("\n"); 
		query.append("                  ,A3.RA_CM_UC_AMT" ).append("\n"); 
		query.append("--                  ,A1.POL_CALL_SEQ" ).append("\n"); 
		query.append("--                  ,A1.POD_CALL_SEQ" ).append("\n"); 
		query.append("                  ,MIN(A1.POL_CALL_SEQ) OVER (PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.OFC_VW_CD, A1.RLANE_CD, A1.DIR_CD, A1.RGN_OFC_CD, A1.POL_CD, A1.POD_CD, A1.TRD_CD, A1.SUB_TRD_CD) POL_CALL_SEQ" ).append("\n"); 
		query.append("                  ,MAX(A1.POD_CALL_SEQ) OVER (PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.OFC_VW_CD, A1.RLANE_CD, A1.DIR_CD, A1.RGN_OFC_CD, A1.POL_CD, A1.POD_CD, A1.TRD_CD, A1.SUB_TRD_CD) POD_CALL_SEQ" ).append("\n"); 
		query.append("                  ,'I' AS CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("                  ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("                  ,SYSDATE" ).append("\n"); 
		query.append("                  ,@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("                  ,SYSDATE" ).append("\n"); 
		query.append("            FROM CSQ_SCTR_LANE_OFC A1, CSQ_CFM_TGT_VVD A2, CSQ_SCTR_PAIR_COST A3" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A1.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("            AND A1.BSE_TP_CD   = @[bse_tp_cd]" ).append("\n"); 
		query.append("            AND A1.BSE_YR      = @[bse_yr]" ).append("\n"); 
		query.append("            AND A1.BSE_QTR_CD  = @[bse_qtr_cd]" ).append("\n"); 
		query.append("            AND A1.OFC_VW_CD   = SUBSTR(@[ofc_vw_cd], 0 ,1)" ).append("\n"); 
		query.append("            AND A1.SUB_TRD_CD  = @[sub_trd_cd]" ).append("\n"); 
		query.append("            AND A1.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("            AND A1.DIR_CD      = @[dir_cd]" ).append("\n"); 
		query.append("            AND A1.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("            AND A1.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("            AND SUBSTR(A2.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("            AND A1.BSE_TP_CD  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("            AND A1.BSE_YR     = A2.BSE_YR" ).append("\n"); 
		query.append("            AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND A1.SUB_TRD_CD = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("            AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("            AND A1.DIR_CD     = A2.DIR_CD" ).append("\n"); 
		query.append("            AND A1.BSE_TP_CD  = A3.BSE_TP_CD" ).append("\n"); 
		query.append("            AND A1.BSE_YR     = A3.BSE_YR" ).append("\n"); 
		query.append("            AND A1.BSE_QTR_CD = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND A1.SUB_TRD_CD = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("            AND A1.RLANE_CD   = A3.RLANE_CD" ).append("\n"); 
		query.append("            AND A1.DIR_CD     = A3.DIR_CD" ).append("\n"); 
		query.append("            AND A1.POL_CD     = A3.POL_CD" ).append("\n"); 
		query.append("            AND A1.POD_CD     = A3.POD_CD" ).append("\n"); 

	}
}