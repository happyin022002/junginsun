/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.13
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2017.01.13 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trs_trsp_svc_ord update
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_sub_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD T" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("      TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("    , TRSP_WO_SEQ        = @[trsp_wo_seq] " ).append("\n"); 
		query.append("    , TRSP_SO_STS_CD     = 'I'" ).append("\n"); 
		query.append("    , VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("    , WO_RJCT_FLG        = null " ).append("\n"); 
		query.append("    , UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append("    , UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("    , WO_EXE_DT          = NVL(DECODE(TRSP_COST_DTL_MOD_CD,'DR', NVL(DOR_NOD_PLN_DT, WO_EXE_DT), WO_EXE_DT), GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD))" ).append("\n"); 
		query.append("    , LOCL_UPD_DT        = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append("    , TRS_SUB_STS_CD     = CASE WHEN @[trs_sub_sts_cd] = 'DF' THEN 'DF'" ).append("\n"); 
		query.append("                                WHEN @[wo_iss_sts_cd] = 'I' AND NVL(T.TRS_SUB_STS_CD, 'XX') IN ('DF', 'XX') THEN 'OR'" ).append("\n"); 
		query.append("                                ELSE TRS_SUB_STS_CD" ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("    ,TRSP_AGMT_OFC_CTY_CD = (SELECT TRSP_AGMT_OFC_CTY_CD FROM TRS_TRSP_WRK_ORD_PRV_TMP X  WHERE X.TRSP_SO_OFC_CTY_CD = T.TRSP_SO_OFC_CTY_CD AND X.TRSP_SO_SEQ = T.TRSP_SO_SEQ AND X.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq])" ).append("\n"); 
		query.append("    ,TRSP_AGMT_SEQ 		= (SELECT TRSP_AGMT_SEQ FROM TRS_TRSP_WRK_ORD_PRV_TMP X  WHERE X.TRSP_SO_OFC_CTY_CD = T.TRSP_SO_OFC_CTY_CD AND X.TRSP_SO_SEQ = T.TRSP_SO_SEQ AND X.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq])" ).append("\n"); 
		query.append("#if (${conti_cd} == 'M' && ${wo_edi_use_flg} == 'Y') " ).append("\n"); 
		query.append("    , EDI_SND_MSG_TP_CD = '204'" ).append("\n"); 
		query.append("    , EDI_SND_DT = SYSDATE" ).append("\n"); 
		query.append("    , EDI_CTRL_SEQ = TRS_TRSP_SVC_ORD_SEQ3.NEXTVAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE (TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("        SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ" ).append("\n"); 
		query.append("          FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("         WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("           AND WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("           AND WO_CXL_FLG = 'N'" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}