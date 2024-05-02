/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOInsertCfmTgtVvdForAddFreezingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
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

public class PlanningDBDAOInsertCfmTgtVvdForAddFreezingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Freezing 시 CSQ_CFM_TGT_VVD에 insert
	  * 
	  * * 2014.07.25 이혜민  QTA Set up by HO for IAS Sector_Add Freezing 시 Bound 삽입 DIR_CD = [@dir_cd] 조건 추가
	  * </pre>
	  */
	public PlanningDBDAOInsertCfmTgtVvdForAddFreezingCSQL(){
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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOInsertCfmTgtVvdForAddFreezingCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_CFM_TGT_VVD(QTA_RLSE_VER_NO, BSE_TP_CD, BSE_YR, BSE_QTR_CD, QTA_TGT_CD, TRD_CD, RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BSE_MON, BSE_WK, CONV_DIR_CD, SUB_TRD_CD, IOC_CD, FNL_BSA_CAPA, LOD_QTY, GRS_REV, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT SUBSTR(@[bse_yr], 3, 2) || A1.BSE_QTR_CD || LPAD(A3.CPY_NO,2,'0') AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,'D' AS QTA_TGT_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.BSE_MON" ).append("\n"); 
		query.append("      ,A1.BSE_WK" ).append("\n"); 
		query.append("      ,NVL((SELECT S1.CONV_DIR_CD" ).append("\n"); 
		query.append("              FROM CSQ_DIR_CONV S1" ).append("\n"); 
		query.append("             WHERE S1.BSE_TP_CD  = A1.BSE_TP_CD" ).append("\n"); 
		query.append("               AND S1.BSE_YR     = A1.BSE_YR" ).append("\n"); 
		query.append("               AND S1.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND S1.TRD_CD     = A1.TRD_CD" ).append("\n"); 
		query.append("               AND S1.RLANE_CD   = A1.RLANE_CD" ).append("\n"); 
		query.append("               AND S1.DIR_CD     = A1.DIR_CD" ).append("\n"); 
		query.append("            ),DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.IOC_CD" ).append("\n"); 
		query.append("      ,A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,0 AS LOD_QTY" ).append("\n"); 
		query.append("      ,0 AS GRS_REV" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("#if (${f_add_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM CSQ_SCTR_ADD_TGT_VVD A1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM CSQ_QTA_TGT_VVD A1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,CSQ_QTA_LANE_MGMT A2" ).append("\n"); 
		query.append("      ,COM_CPY_NO A3" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = A2.BSE_YR " ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD     = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = NVL(A2.LANE_DIR_CD, A1.DIR_CD)" ).append("\n"); 
		query.append("   AND A2.IAS_SCTR_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_add_flg} == 'Y')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("   AND A1.PF_GRP_CD  = @[pf_grp_cd]" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = NVL(@[dir_cd], A1.DIR_CD)" ).append("\n"); 
		query.append("   AND A3.CPY_NO     BETWEEN 2 AND  2" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A3.CPY_NO     BETWEEN 1 AND  2" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}