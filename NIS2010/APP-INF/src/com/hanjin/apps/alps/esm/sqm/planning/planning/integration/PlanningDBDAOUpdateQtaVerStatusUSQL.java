/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PlanningDBDAOUpdateQtaVerStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOUpdateQtaVerStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [SQM_VER_STS_CD]을 [업데이트] 합니다.
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public PlanningDBDAOUpdateQtaVerStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sqm_ver_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOUpdateQtaVerStatusUSQL").append("\n"); 
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
		query.append("UPDATE SQM_QTA_STEP_VER" ).append("\n"); 
		query.append("   SET SQM_VER_STS_CD = @[sqm_ver_sts_cd]" ).append("\n"); 
		query.append("#if (${sqm_ver_sts_cd} == 'C')   " ).append("\n"); 
		query.append("      ,CFM_GDT        = GLOBALDATE_PKG.TIME_CONV_OFC_FNC( 'SELHO' ,SYSDATE, 'GMT' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,UPD_USR_ID     = @[usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT         = SYSDATE " ).append("\n"); 
		query.append("WHERE BSE_TP_CD       = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND BSE_YR          = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND BSE_QTR_CD      = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("  AND QTA_STEP_CD     = @[f_qta_step_cd]" ).append("\n"); 
		query.append("#if (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("  AND SUBSTR(QTA_VER_NO,4,5) = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN SUBSTR(QTA_VER_NO,4,5)" ).append("\n"); 
		query.append("                                       ELSE DECODE(@[ofc_cd], 'SELCMI', SUBSTR(QTA_VER_NO,4,5), @[ofc_cd])" ).append("\n"); 
		query.append("                                        END RHQ_CD" ).append("\n"); 
		query.append("                                 FROM DUAL)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND SUBSTR(QTA_VER_NO,4,6) = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN SUBSTR(QTA_VER_NO,4,6)" ).append("\n"); 
		query.append("                                       ELSE DECODE(@[ofc_cd], 'SELCMI', SUBSTR(QTA_VER_NO,4,6), @[ofc_cd])" ).append("\n"); 
		query.append("                                        END TEAM_CD" ).append("\n"); 
		query.append("                                 FROM DUAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("  AND TRD_CD          = @[f_trd_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND CONV_DIR_CD    = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '' && ${f_ofc_vw_cd} != 'All')" ).append("\n"); 
		query.append("   AND OFC_VW_CD      = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}