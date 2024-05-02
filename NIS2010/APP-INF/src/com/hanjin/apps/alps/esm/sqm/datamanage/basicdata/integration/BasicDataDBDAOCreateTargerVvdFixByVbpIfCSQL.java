/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BasicDataDBDAOCreateTargerVvdFixByVbpIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.15 
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

public class BasicDataDBDAOCreateTargerVvdFixByVbpIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VBP 시스템에서 대상항차를 I/F 한 것을 기반으로 Target vvd data 생성
	  * - IP 구간에 대한 BSA를 실적기반의 LOAD로 세팅
	  * - IAS Sector sales 를 하면서 IP 구간에 대한 BSA를 0으로 원복 추가적으로 PF SVC TP를 가져오도록 변경
	  * </pre>
	  */
	public BasicDataDBDAOCreateTargerVvdFixByVbpIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOCreateTargerVvdFixByVbpIfCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_QTA_TGT_VVD (" ).append("\n"); 
		query.append("     BSE_TP_CD" ).append("\n"); 
		query.append("    ,BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,VSL_CD" ).append("\n"); 
		query.append("    ,SKD_VOY_NO" ).append("\n"); 
		query.append("    ,SKD_DIR_CD" ).append("\n"); 
		query.append("    ,BSE_MON" ).append("\n"); 
		query.append("    ,BSE_WK" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,IOC_CD" ).append("\n"); 
		query.append("    ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("    ,DELT_FLG" ).append("\n"); 
		query.append("    ,PF_SVC_TP_CD" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT   " ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("SELECT VBP.BSE_TP_CD" ).append("\n"); 
		query.append("      ,VBP.BSE_YR" ).append("\n"); 
		query.append("      ,DECODE(VBP.BSE_TP_CD,'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("      ,VBP.TRD_CD" ).append("\n"); 
		query.append("      ,VBP.RLANE_CD" ).append("\n"); 
		query.append("      ,VBP.DIR_CD" ).append("\n"); 
		query.append("      ,VBP.VSL_CD" ).append("\n"); 
		query.append("      ,VBP.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,VBP.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,VBP.BSE_MON" ).append("\n"); 
		query.append("      ,VBP.BSE_WK" ).append("\n"); 
		query.append("      ,VBP.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,VBP.IOC_CD" ).append("\n"); 
		query.append("--      ,NVL(VBP.FNL_BSA_CAPA,0) FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      ,CASE WHEN LANE.IAS_SCTR_FLG IS NULL THEN DECODE(VBP.SUB_TRD_CD,'IP',NVL(PFMC.LOD_QTY,0),NVL(VBP.FNL_BSA_CAPA,0)) ELSE NVL(VBP.FNL_BSA_CAPA,0) END FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,VSK.PF_SKD_TP_CD" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("  FROM SQM_QTA_TGT_VVD_IF VBP" ).append("\n"); 
		query.append("      ,SQM_QTA_LANE_MGMT LANE" ).append("\n"); 
		query.append("      ,VSK_BUD_VSL_SKD VSK" ).append("\n"); 
		query.append("      ,( SELECT TRD_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,SUB_TRD_CD" ).append("\n"); 
		query.append("              ,ROUND(SUM(LOD_QTY)/53,0) LOD_QTY" ).append("\n"); 
		query.append("          FROM SQM_PERF_IF" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BSE_TP_CD   = @[f_bse_tp_cd] " ).append("\n"); 
		query.append("           AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("           AND BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("           AND SUB_TRD_CD  = 'IP'" ).append("\n"); 
		query.append("           AND OFC_VW_CD   = 'C'" ).append("\n"); 
		query.append("           AND SQM_LVL_CD  = '2'" ).append("\n"); 
		query.append("           AND QTA_TGT_CD  = 'D'" ).append("\n"); 
		query.append("         GROUP BY TRD_CD, RLANE_CD, DIR_CD,SUB_TRD_CD" ).append("\n"); 
		query.append("        )PFMC" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VBP.TRD_CD      = LANE.TRD_CD" ).append("\n"); 
		query.append("   AND VBP.RLANE_CD    = LANE.RLANE_CD" ).append("\n"); 
		query.append("   AND VBP.SUB_TRD_CD  = LANE.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND VBP.DIR_CD      = NVL(LANE.LANE_DIR_CD,VBP.DIR_CD)" ).append("\n"); 
		query.append("   AND VBP.TRD_CD      = PFMC.TRD_CD(+)" ).append("\n"); 
		query.append("   AND VBP.RLANE_CD    = PFMC.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND VBP.SUB_TRD_CD  = PFMC.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("   AND VBP.DIR_CD      = PFMC.DIR_CD (+)" ).append("\n"); 
		query.append("   AND VBP.VSL_CD      = VSK.VSL_CD" ).append("\n"); 
		query.append("   AND VBP.SKD_VOY_NO  = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VBP.DIR_CD      = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND SUBSTR(VBP.RLANE_CD,1,3) = VSK.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND VBP.DIR_CD      = PFMC.DIR_CD(+)" ).append("\n"); 
		query.append("   AND VBP.TRD_CD      = PFMC.TRD_CD(+)" ).append("\n"); 
		query.append("   AND VBP.RLANE_CD    = PFMC.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND VBP.SUB_TRD_CD  = PFMC.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("   AND VBP.BSE_TP_CD   = @[f_bse_tp_cd] " ).append("\n"); 
		query.append("   AND VBP.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND VBP.BSE_MON     BETWEEN '01' AND '12'" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("   AND VBP.BSE_QTR_CD  = '00'" ).append("\n"); 
		query.append("   AND VBP.BSE_WK      BETWEEN '00' AND '53'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND VBP.BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("   AND VBP.BSE_WK      BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND VBP.DELT_FLG    =  'N'" ).append("\n"); 
		query.append("   AND LANE.SQM_ACT_FLG=  'Y'" ).append("\n"); 

	}
}