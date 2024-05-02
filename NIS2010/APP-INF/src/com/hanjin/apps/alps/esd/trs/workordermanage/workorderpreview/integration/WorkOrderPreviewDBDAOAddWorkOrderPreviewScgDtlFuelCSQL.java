/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewScgDtlFuelCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.01.05 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewScgDtlFuelCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trs_trsp_scg_dtl fule,vat 정보 insert
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewScgDtlFuelCSQL(){
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
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewScgDtlFuelCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO TRS_TRSP_SCG_DTL " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("    , TRSP_SO_SEQ " ).append("\n"); 
		query.append("	, LGS_COST_CD " ).append("\n"); 
		query.append("    , SCG_AMT " ).append("\n"); 
		query.append("    , TRSP_AGMT_BFR_EXTD_FLG" ).append("\n"); 
		query.append("    , CRE_OFC_CD " ).append("\n"); 
		query.append("    , CRE_USR_ID " ).append("\n"); 
		query.append("    , CRE_DT " ).append("\n"); 
		query.append("    , UPD_USR_ID " ).append("\n"); 
		query.append("    , UPD_DT " ).append("\n"); 
		query.append("    , LOCL_CRE_DT " ).append("\n"); 
		query.append("    , LOCL_UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    , TRSP_SO_SEQ" ).append("\n"); 
		query.append("    , 'S'|| DECODE(CGO_TP_CD, 'F', 'C', NULL, 'M', CGO_TP_CD)||'FU'|| DECODE(TRSP_CRR_MOD_CD, 'RW', 'WR', 'TW', 'WT', 'TR', 'RT', TRSP_CRR_MOD_CD) LGS_COST_CD" ).append("\n"); 
		query.append("    , FUEL_SCG_AMT" ).append("\n"); 
		query.append("    , 'Y'" ).append("\n"); 
		query.append("    , CRE_OFC_CD" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("	, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("	, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("  AND WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("  AND TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("  AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("  AND NVL(FUEL_SCG_AMT, 0) <> 0" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    , TRSP_SO_SEQ" ).append("\n"); 
		query.append("    , 'S'|| DECODE(CGO_TP_CD, 'F', 'C', NULL, 'M', CGO_TP_CD)||'OTAX' LGS_COST_CD" ).append("\n"); 
		query.append("    , SCG_VAT_AMT" ).append("\n"); 
		query.append("    , 'Y'" ).append("\n"); 
		query.append("    , CRE_OFC_CD" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("	, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("	, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("  AND WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("  AND TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("  AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("  AND NVL(SCG_VAT_AMT, 0) <> 0" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    , TRSP_SO_SEQ" ).append("\n"); 
		query.append("    , 'S'|| DECODE(CGO_TP_CD, 'F', 'C', NULL, 'M', CGO_TP_CD)||'TLAL' LGS_COST_CD" ).append("\n"); 
		query.append("    , TOLL_FEE_AMT" ).append("\n"); 
		query.append("    , 'Y'" ).append("\n"); 
		query.append("    , CRE_OFC_CD" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("	, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("	, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("  AND WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("  AND TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("  AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("  AND NVL(TOLL_FEE_AMT, 0) <> 0" ).append("\n"); 

	}
}