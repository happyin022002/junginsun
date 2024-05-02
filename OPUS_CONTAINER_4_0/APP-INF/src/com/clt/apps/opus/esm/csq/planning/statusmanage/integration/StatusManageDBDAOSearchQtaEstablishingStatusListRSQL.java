/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusManageDBDAOSearchQtaEstablishingStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.statusmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusManageDBDAOSearchQtaEstablishingStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CDA 쿼터 Super-user 전용으로 매년 또는 매분기에 단계별 기초 데이터를 Creation 해주는 기능 + 트래이드 팀 유저 및 RHQ 유저들이 현재 입력하고 있는 Status를 보여주는 화면
	  * </pre>
	  */
	public StatusManageDBDAOSearchQtaEstablishingStatusListRSQL(){
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
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_org_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_qta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ho_team_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOSearchQtaEstablishingStatusListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("         QTA_STEP_CD" ).append("\n"); 
		query.append("        ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE INTG_CD_ID       = 'CD03225'" ).append("\n"); 
		query.append("            AND INTG_CD_VAL_CTNT = QTA_STEP_CD" ).append("\n"); 
		query.append("         ) AS QTA_STEP_DESC" ).append("\n"); 
		query.append("        ,DECODE(QTA_STEP_CD, '01', '', OFC_VW_CD) AS OFC_VW_CD" ).append("\n"); 
		query.append("        ,CSQ_VER_STS_CD" ).append("\n"); 
		query.append("        ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE INTG_CD_ID       = 'CD03230'" ).append("\n"); 
		query.append("            AND INTG_CD_VAL_CTNT = CSQ_VER_STS_CD" ).append("\n"); 
		query.append("         ) AS CSQ_VER_STS_DESC" ).append("\n"); 
		query.append("        ,QTA_VER_NO        " ).append("\n"); 
		query.append("        ,'SEL' || SUBSTR(QTA_VER_NO, 1, 3) AS TEAM_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,CRE_OFC_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("    FROM CSQ_QTA_STEP_VER" ).append("\n"); 
		query.append("   WHERE BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("     AND CONV_DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ho_team_cd} != '' && ${f_ho_team_cd} != 'All')" ).append("\n"); 
		query.append("     AND 'SEL' || SUBSTR(QTA_VER_NO, 1, 3) = @[f_ho_team_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_qta_step_cd} != '' && ${f_qta_step_cd} != 'All')" ).append("\n"); 
		query.append("     AND QTA_STEP_CD = @[f_qta_step_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_org_cd} != '' && ${f_org_cd} != 'All')" ).append("\n"); 
		query.append("     AND CRE_OFC_CD  = @[f_org_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY QTA_STEP_CD" ).append("\n"); 
		query.append("        ,OFC_VW_CD" ).append("\n"); 
		query.append("        ,SUBSTR(QTA_VER_NO, 1, 3)" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,CRE_OFC_CD" ).append("\n"); 

	}
}