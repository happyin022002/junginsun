/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetCntrInfoFromMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * MST에서 넘겨준  XX, MT를 처리하기 위한 컨테이너 이동정보를 얻어온다
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
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
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
		query.append("SELECT @[cntr_no]    CNTR_NO,       @[org_yd_cd] ORG_YD_CD, @[mvmt_sts_cd] MVMT_STS_CD," ).append("\n"); 
		query.append("       'N' FCNTR_FLG,'N' OB_CNTR_FLG, @[cnmv_rmk] CNMV_RMK, @[usr_nm] USR_NM," ).append("\n"); 
		query.append("       @[upd_usr_id] UPD_USR_ID, @[cre_usr_id] CRE_USR_ID, 'MAN' MVMT_INP_TP_CD," ).append("\n"); 
		query.append("       'SML' CNMV_CO_CD, @[ofc_cd] OFC_CD, DECODE(@[mvmt_sts_cd], 'XX', 'I', 'A') CNTR_ACT_CD, (@[cnmv_evnt_dt]) CNMV_EVNT_DT," ).append("\n"); 
		query.append("       TO_CHAR(SYSDATE, 'YYYY')  CNMV_YR," ).append("\n"); 
		query.append("       NVL(CTM.CNMV_ID_NO, 0) + 1 CNMV_ID_NO," ).append("\n"); 
		query.append("       NVL(CTM.CNMV_SEQ, 0) + 1  CNMV_SEQ," ).append("\n"); 
		query.append("       NVL(CTM.CNTR_TPSZ_CD, MST.CNTR_TPSZ_CD) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       NVL(MST.CNMV_CYC_NO, 1) CNMV_CYC_NO," ).append("\n"); 
		query.append("       MST.AGMT_SEQ CTRT_SEQ," ).append("\n"); 
		query.append("      (SELECT SYS_AREA_GRP_ID FROM COM_SYS_AREA_GRP_ID WHERE CO_IND_CD = 'H' AND CNT_CD = SUBSTR(@[org_yd_cd], 0, 2)) AS CNTR_SVR_ID," ).append("\n"); 
		query.append("       'N' CNTR_XCH_CD, 'HHO' CTRT_OFC_CTY_CD" ).append("\n"); 
		query.append("FROM   MST_CONTAINER MST," ).append("\n"); 
		query.append("       (SELECT CNTR_NO, CNMV_YR, CNMV_ID_NO, CNMV_SEQ, CNTR_TPSZ_CD, CNMV_CYC_NO, CTRT_SEQ" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("         WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND CNMV_YR = TO_CHAR(SYSDATE, 'YYYY')" ).append("\n"); 
		query.append("           AND CNMV_ID_NO = (SELECT MAX(CNMV_ID_NO) FROM CTM_MOVEMENT WHERE CNTR_NO = @[cntr_no] AND CNMV_YR = TO_CHAR(SYSDATE, 'YYYY'))" ).append("\n"); 
		query.append("        ) CTM" ).append("\n"); 
		query.append("WHERE  MST.CNTR_NO = CTM.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND  MST.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}