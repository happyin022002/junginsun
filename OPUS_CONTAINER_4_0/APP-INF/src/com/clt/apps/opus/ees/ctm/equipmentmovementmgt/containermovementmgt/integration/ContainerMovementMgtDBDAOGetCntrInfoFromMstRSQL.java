/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetCntrInfoFromMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.02.24 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetCntrInfoFromMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetCntrInfoFromMstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetCntrInfoFromMstRSQL").append("\n"); 
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
		query.append("SELECT @[cntr_no] AS CNTR_NO," ).append("\n"); 
		query.append("       @[org_yd_cd] AS ORG_YD_CD," ).append("\n"); 
		query.append("       @[mvmt_sts_cd] AS MVMT_STS_CD," ).append("\n"); 
		query.append("       'N' AS FCNTR_FLG," ).append("\n"); 
		query.append("       'N' AS OB_CNTR_FLG," ).append("\n"); 
		query.append("       @[cnmv_rmk] AS CNMV_RMK," ).append("\n"); 
		query.append("       @[usr_nm] AS USR_NM," ).append("\n"); 
		query.append("       @[upd_usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("       @[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("       'MAN' AS MVMT_INP_TP_CD," ).append("\n"); 
		query.append("       COM_CONSTANTMGR_PKG.COM_GETCOMPANYCODE_FNC() AS CNMV_CO_CD," ).append("\n"); 
		query.append("       @[ofc_cd] AS OFC_CD," ).append("\n"); 
		query.append("       DECODE (@[mvmt_sts_cd], 'XX', 'I', 'A') AS CNTR_ACT_CD," ).append("\n"); 
		query.append("       (@[cnmv_evnt_dt]) AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("       TO_CHAR (SYSDATE, 'YYYY') AS CNMV_YR," ).append("\n"); 
		query.append("       NVL (CTM.CNMV_ID_NO, 0) + 1 AS CNMV_ID_NO," ).append("\n"); 
		query.append("       NVL (CTM.CNMV_SEQ, 0) + 1 AS CNMV_SEQ," ).append("\n"); 
		query.append("       NVL (CTM.CNTR_TPSZ_CD, MST.CNTR_TPSZ_CD) AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       NVL (MST.CNMV_CYC_NO, 1) AS CNMV_CYC_NO," ).append("\n"); 
		query.append("       MST.AGMT_SEQ  AS CTRT_SEQ," ).append("\n"); 
		query.append("       (SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("          FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("         WHERE CO_IND_CD = 'H'" ).append("\n"); 
		query.append("           AND CNT_CD = SUBSTR (@[org_yd_cd], 0, 2)) AS CNTR_SVR_ID," ).append("\n"); 
		query.append("       'N' AS CNTR_XCH_CD," ).append("\n"); 
		query.append("       'HHO' AS CTRT_OFC_CTY_CD" ).append("\n"); 
		query.append("  FROM MST_CONTAINER MST," ).append("\n"); 
		query.append("       (SELECT CNTR_NO," ).append("\n"); 
		query.append("               CNMV_YR," ).append("\n"); 
		query.append("               CNMV_ID_NO," ).append("\n"); 
		query.append("               CNMV_SEQ," ).append("\n"); 
		query.append("               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               CNMV_CYC_NO," ).append("\n"); 
		query.append("               CTRT_SEQ" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("         WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND CNMV_YR = TO_CHAR (SYSDATE, 'YYYY')" ).append("\n"); 
		query.append("           AND CNMV_ID_NO = (SELECT MAX (CNMV_ID_NO)" ).append("\n"); 
		query.append("                               FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                              WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                                AND CNMV_YR = TO_CHAR (SYSDATE, 'YYYY'))" ).append("\n"); 
		query.append("       ) CTM" ).append("\n"); 
		query.append(" WHERE MST.CNTR_NO = CTM.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND MST.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}