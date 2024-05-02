/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BasicDataDBDAOCreatePfSkdGrpForSectorYrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.01 
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

public class BasicDataDBDAOCreatePfSkdGrpForSectorYrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P/F SKD Group Mgmt for IAS Sector  Year 정보를 생성한다.
	  * 
	  * *History
	  * 2014.08.25 이혜민 펜들럼 노선일때 같은 PF SKD VER을 가진 노선이 2개 이상이 되어 CONNECT BY를 제대로 해주지 못해 쿼리 수정. 
	  * </pre>
	  */
	public BasicDataDBDAOCreatePfSkdGrpForSectorYrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOCreatePfSkdGrpForSectorYrCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SCTR_PF_GRP" ).append("\n"); 
		query.append("(BSE_TP_CD," ).append("\n"); 
		query.append("BSE_YR," ).append("\n"); 
		query.append("BSE_QTR_CD," ).append("\n"); 
		query.append("RLANE_CD," ).append("\n"); 
		query.append("PF_GRP_CD," ).append("\n"); 
		query.append("PF_SVC_TP_CD," ).append("\n"); 
		query.append("TRD_CD," ).append("\n"); 
		query.append("SUB_TRD_CD," ).append("\n"); 
		query.append("PF_ROUT_DESC," ).append("\n"); 
		query.append("SQM_ACT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       @[f_bse_tp_cd] BSE_TP_CD" ).append("\n"); 
		query.append("      ,@[f_bse_yr] BSE_YR" ).append("\n"); 
		query.append("      ,'00' BSE_QTR_CD" ).append("\n"); 
		query.append("      ,C2.RLANE_CD" ).append("\n"); 
		query.append("      ,LPAD(DENSE_RANK() OVER (PARTITION BY C1.VSL_SLAN_CD  ORDER BY C1.PF_ROUT_DESC),3,0) PF_GRP_CD" ).append("\n"); 
		query.append("      ,C1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("      ,C2.TRD_CD" ).append("\n"); 
		query.append("      ,C2.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(C1.PF_ROUT_DESC,4) PF_ROUT_DESC" ).append("\n"); 
		query.append("      ,'N' SQM_ACT_FLG" ).append("\n"); 
		query.append("      ,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("           SELECT B3.VSL_SLAN_CD" ).append("\n"); 
		query.append("--                 ,B1.RLANE_CD" ).append("\n"); 
		query.append("--                 ,B1.TRD_CD" ).append("\n"); 
		query.append("--                 ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("                 ,B3.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                 ,B3.SKD_DIR_CD" ).append("\n"); 
		query.append("                 ,B3.PORT_CD" ).append("\n"); 
		query.append("                 ,B3.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("                 ,SYS_CONNECT_BY_PATH(B3.PORT_CD||'/'||B3.SKD_DIR_CD,' - ') PF_ROUT_DESC -- (계층형 질의) 최상위 부터 PATH를 보여준다." ).append("\n"); 
		query.append("                 ,CONNECT_BY_ISLEAF AS IS_LEAF                  -- (계층형 질의) 최하위 레벨 여부 (최하위 : 1, 아니면 0)" ).append("\n"); 
		query.append("                 ,B2.SLAN_STND_FLG" ).append("\n"); 
		query.append("                 ,B2.CRE_DT" ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("                   SELECT DISTINCT " ).append("\n"); 
		query.append("                          A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("--                         ,A2.TRD_CD" ).append("\n"); 
		query.append("                         ,A3.PF_SKD_TP_CD" ).append("\n"); 
		query.append("--                         ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("--                         ,A2.RLANE_CD" ).append("\n"); 
		query.append("                     FROM SQM_QTA_LANE_MGMT A1" ).append("\n"); 
		query.append("                         ,SQM_QTA_TGT_VVD_IF A2" ).append("\n"); 
		query.append("                         ,VSK_BUD_VSL_SKD A3" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                      AND A2.TRD_CD       = A1.TRD_CD" ).append("\n"); 
		query.append("                      AND A2.RLANE_CD     = A1.RLANE_CD" ).append("\n"); 
		query.append("                      AND A2.SUB_TRD_CD   = A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                      AND A2.DIR_CD       = NVL(A1.LANE_DIR_CD, A2.DIR_CD)" ).append("\n"); 
		query.append("                      AND A1.SQM_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("                      AND SUBSTR(A2.RLANE_CD,0,3) = A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("                      AND A2.VSL_CD       = A3.VSL_CD" ).append("\n"); 
		query.append("                      AND A2.SKD_VOY_NO   = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND A2.DIR_CD       = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND A2.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("                      AND A2.BSE_QTR_CD   = '00'" ).append("\n"); 
		query.append("                      AND A2.DELT_FLG     = 'N'    " ).append("\n"); 
		query.append("                      AND A1.IAS_SCTR_FLG IS NOT NULL" ).append("\n"); 
		query.append("                  ORDER BY A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("                          ,A3.PF_SKD_TP_CD" ).append("\n"); 
		query.append("                  ) B1" ).append("\n"); 
		query.append("                 ,VSK_BUD_PF_SKD B2 " ).append("\n"); 
		query.append("                 ,VSK_BUD_PF_SKD_DTL B3" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND B1.VSL_SLAN_CD  = B2.VSL_SLAN_CD" ).append("\n"); 
		query.append("              AND B1.PF_SKD_TP_CD = B2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("              AND B2.VSL_SLAN_CD  = B3.VSL_SLAN_CD" ).append("\n"); 
		query.append("              AND B2.PF_SVC_TP_CD = B3.PF_SVC_TP_CD" ).append("\n"); 
		query.append("              AND B2.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("       START WITH B3.PORT_ROTN_SEQ = 1" ).append("\n"); 
		query.append(" CONNECT BY PRIOR B3.PORT_ROTN_SEQ = B3.PORT_ROTN_SEQ-1" ).append("\n"); 
		query.append("        AND PRIOR B3.VSL_SLAN_CD   = B3.VSL_SLAN_CD" ).append("\n"); 
		query.append("        AND PRIOR B3.PF_SVC_TP_CD  = B3.PF_SVC_TP_CD" ).append("\n"); 
		query.append(") C1, SQM_QTA_LANE_MGMT C2 " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND C1.IS_LEAF = 1" ).append("\n"); 
		query.append(" AND C1.VSL_SLAN_CD  = SUBSTR(C2.RLANE_CD,0,3)" ).append("\n"); 
		query.append(" AND C2.IAS_SCTR_FLG IS NOT NULL" ).append("\n"); 
		query.append(" AND C2.SQM_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("ORDER BY VSL_SLAN_CD" ).append("\n"); 

	}
}