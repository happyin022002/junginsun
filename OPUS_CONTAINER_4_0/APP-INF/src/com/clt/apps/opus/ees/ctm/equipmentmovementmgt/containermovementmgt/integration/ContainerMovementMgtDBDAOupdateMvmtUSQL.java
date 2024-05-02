/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOupdateMvmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOupdateMvmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOupdateMvmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_cntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_lvl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nos",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("osca_bkg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOupdateMvmtUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MOVEMENT" ).append("\n"); 
		query.append("   SET MVMT_STS_CD = @[mvmt_sts_cd]," ).append("\n"); 
		query.append("       ORG_YD_CD = @[org_yd_cd]," ).append("\n"); 
		query.append("       UPD_USR_ID = @[cre_usr_id]," ).append("\n"); 
		query.append("#if (${cm_up} == '')" ).append("\n"); 
		query.append("       MVMT_CRE_TP_CD = DECODE (MVMT_CRE_TP_CD, 'C', MVMT_CRE_TP_CD, 'U')," ).append("\n"); 
		query.append("#elseif (${cm_up} == '1')" ).append("\n"); 
		query.append("      /* 전전:MT/전:EN/입력:OC이고, 전:EN을 OP로 Update시 */" ).append("\n"); 
		query.append("       MVMT_CRE_TP_CD = 'U'," ).append("\n"); 
		query.append("       CNMV_LVL_NO = @[cnmv_lvl_no]," ).append("\n"); 
		query.append("       FCNTR_FLG = @[fcntr_flg]," ).append("\n"); 
		query.append("       BKG_NO = @[bkg_no]," ).append("\n"); 
		query.append("       BL_NO = @[bl_no]," ).append("\n"); 
		query.append("       CNMV_CYC_NO = @[cnmv_cyc_no]," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]," ).append("\n"); 
		query.append("       TRNK_VSL_CD = @[trnk_vsl_cd]," ).append("\n"); 
		query.append("       TRNK_SKD_VOY_NO = @[trnk_skd_voy_no]," ).append("\n"); 
		query.append("       TRNK_SKD_DIR_CD = @[trnk_skd_dir_cd]," ).append("\n"); 
		query.append("	#if (${ob_cntr_flg} != '')" ).append("\n"); 
		query.append("	   OB_CNTR_FLG = @[ob_cntr_flg]," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${cm_up} == '3')" ).append("\n"); 
		query.append("       MVMT_CRE_TP_CD = ''," ).append("\n"); 
		query.append("       CNMV_EVNT_DT = TO_DATE (@[cnmv_evnt_dt], 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("       CNMV_GDT = GLOBALDATE_PKG.TIME_CONV_FNC (SUBSTR (@[org_yd_cd], 0, 5 ), TO_DATE (@[cnmv_evnt_dt], 'YYYY-MM-DD HH24:MI'), 'GMT' )," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${osca_bkg_flg} != '')" ).append("\n"); 
		query.append("       OSCA_BKG_FLG = @[osca_bkg_flg]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       UPD_LOCL_DT = GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[org_yd_cd], 0, 5 ))," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("   AND CNMV_ID_NO = (SELECT CNMV_ID_NO" ).append("\n"); 
		query.append("                       FROM (SELECT /*+ INDEX_DESC (CTM_MOVEMENT XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                                    ROWNUM RM," ).append("\n"); 
		query.append("                                    CNMV_ID_NO" ).append("\n"); 
		query.append("                               FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                              WHERE CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("                      WHERE RM = @[nos])" ).append("\n"); 

	}
}