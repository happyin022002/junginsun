/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOInsertCfmQtaSyncForFreezingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOInsertCfmQtaSyncForFreezingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Freezing]  후 [CSQ_CFM_QTA] 테이블에 데이터를 [입력]한다.
	  * 
	  * * 2014.07.25 이혜민  QTA Set up by HO for IAS Sector_Add Freezing 시 Bound 삽입 DIR_CD = [@dir_cd] 조건 추가
	  * * 2015.01.13 이혜민 RPB, PA CM, RA CM에 ROUND(반올림) 삭제
	  * </pre>
	  */
	public PlanningDBDAOInsertCfmQtaSyncForFreezingCSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOInsertCfmQtaSyncForFreezingCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_CFM_QTA(QTA_RLSE_VER_NO, BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, QTA_TGT_CD, TRD_CD, RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, RGN_OFC_CD, RHQ_CD, AQ_CD, CONV_DIR_CD, LOD_QTY, GRS_RPB_REV, PA_CM_UC_AMT, RA_CM_UC_AMT, CSQ_CNG_TP_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,'D' AS QTA_TGT_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.AQ_CD" ).append("\n"); 
		query.append("      ,NVL(A2.CONV_DIR_CD, A1.DIR_CD)" ).append("\n"); 
		query.append("      ,SUM(A1.LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY), 0, 0, SUM(A1.LOD_QTY*A1.GRS_RPB_REV)/SUM(A1.LOD_QTY)) AS GRS_RPB_REV" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY), 0, 0, SUM(A1.LOD_QTY*A1.PA_CM_UC_AMT)/SUM(A1.LOD_QTY)) AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY), 0, 0, SUM(A1.LOD_QTY*A1.RA_CM_UC_AMT)/SUM(A1.LOD_QTY)) AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,'M' AS CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS  UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("   FROM CSQ_SCTR_CFM_QTA A1" ).append("\n"); 
		query.append("       ,CSQ_DIR_CONV A2" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD       = A2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("    AND A1.BSE_YR          = A2.BSE_YR(+)" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD      = A2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("    AND A1.TRD_CD          = A2.TRD_CD(+)" ).append("\n"); 
		query.append("    AND A1.RLANE_CD        = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND A1.DIR_CD          = A2.DIR_CD(+)" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("    AND A1.BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD      = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_add_flg} == 'Y')" ).append("\n"); 
		query.append("    AND A1.QTA_RLSE_VER_NO = SUBSTR(@[bse_yr],-2) ||@[bse_qtr_cd]||'02'" ).append("\n"); 
		query.append("    AND A1.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("    AND A1.TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("    AND A1.PF_GRP_CD       = @[pf_grp_cd]" ).append("\n"); 
		query.append("    AND A1.DIR_CD          = NVL(@[dir_cd], A1.DIR_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  GROUP BY A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("          ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("          ,A1.BSE_YR" ).append("\n"); 
		query.append("          ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("          ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("          ,A1.TRD_CD" ).append("\n"); 
		query.append("          ,A1.RLANE_CD" ).append("\n"); 
		query.append("          ,A1.DIR_CD" ).append("\n"); 
		query.append("          ,A1.VSL_CD" ).append("\n"); 
		query.append("          ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("          ,A1.RHQ_CD" ).append("\n"); 
		query.append("          ,A1.AQ_CD" ).append("\n"); 
		query.append("          ,A2.CONV_DIR_CD" ).append("\n"); 

	}
}