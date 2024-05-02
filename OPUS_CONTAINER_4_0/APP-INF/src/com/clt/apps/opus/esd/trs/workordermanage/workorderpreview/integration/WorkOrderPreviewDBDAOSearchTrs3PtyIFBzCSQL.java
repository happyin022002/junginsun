/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchTrs3PtyIFBzCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.02.09 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchTrs3PtyIFBzCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTrs3PtyIFBz
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchTrs3PtyIFBzCSQL(){
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
		params.put("trsp_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchTrs3PtyIFBzCSQL").append("\n"); 
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
		query.append("INTO TRS_N3RD_PTY_IF" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("TRSP_IF_OFC_CD" ).append("\n"); 
		query.append(", TRSP_IF_SEQ" ).append("\n"); 
		query.append(", TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", TRSP_SO_SEQ" ).append("\n"); 
		query.append(", TRSP_N3PTY_IF_STS_CD" ).append("\n"); 
		query.append(", INV_NO" ).append("\n"); 
		query.append(", VNDR_SEQ" ).append("\n"); 
		query.append(", FM_NOD_CD" ).append("\n"); 
		query.append(", TO_NOD_CD" ).append("\n"); 
		query.append(", VIA_NOD_CD" ).append("\n"); 
		query.append(", DOR_NOD_CD" ).append("\n"); 
		query.append(", EQ_KND_CD" ).append("\n"); 
		query.append(", EQ_TPSZ_CD" ).append("\n"); 
		query.append(", EQ_NO" ).append("\n"); 
		query.append(", LGS_COST_CD" ).append("\n"); 
		query.append(", ACCT_CD" ).append("\n"); 
		query.append(", CSR_NO" ).append("\n"); 
		query.append(", N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append(", BL_NO" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append(", N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", N3PTY_OFC_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", IF_AMT" ).append("\n"); 
		query.append(", IF_RMK" ).append("\n"); 
		query.append(", FINC_SKD_DIR_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", IF_FLG" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(", LOCL_UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[trsp_if_ofc_cd]" ).append("\n"); 
		query.append(", TRS_N3RD_PTY_IF_SEQ1.NEXTVAL" ).append("\n"); 
		query.append(", SVC_ORD.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", SVC_ORD.TRSP_SO_SEQ" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", SVC_ORD.INV_NO" ).append("\n"); 
		query.append(", SVC_ORD.INV_VNDR_SEQ" ).append("\n"); 
		query.append(", SVC_ORD.FM_NOD_CD" ).append("\n"); 
		query.append(", SVC_ORD.TO_NOD_CD" ).append("\n"); 
		query.append(", SVC_ORD.VIA_NOD_CD" ).append("\n"); 
		query.append(", SVC_ORD.DOR_NOD_CD" ).append("\n"); 
		query.append(", SVC_ORD.EQ_KND_CD" ).append("\n"); 
		query.append(", SVC_ORD.EQ_TPSZ_CD" ).append("\n"); 
		query.append(", SVC_ORD.EQ_NO" ).append("\n"); 
		query.append(", SVC_ORD.LGS_COST_CD" ).append("\n"); 
		query.append(", SVC_ORD.ACCT_CD" ).append("\n"); 
		query.append(", ''" ).append("\n"); 
		query.append(", SVC_ORD.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(", SVC_ORD.ORG_BKG_NO" ).append("\n"); 
		query.append(", SVC_ORD.BL_NO" ).append("\n"); 
		query.append(", SVC_ORD.VSL_CD" ).append("\n"); 
		query.append(", SVC_ORD.SKD_VOY_NO" ).append("\n"); 
		query.append(", SVC_ORD.SKD_DIR_CD" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("WHEN SVC_ORD.N3PTY_CUST_CNT_CD IS NOT NULL THEN 'C'" ).append("\n"); 
		query.append("WHEN SVC_ORD.N3PTY_VNDR_SEQ IS NOT NULL THEN 'V'" ).append("\n"); 
		query.append("WHEN SVC_ORD.N3PTY_OFC_CD IS NOT NULL THEN 'S'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(", SVC_ORD.N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append(", SVC_ORD.N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append(", SVC_ORD.N3PTY_CUST_SEQ" ).append("\n"); 
		query.append(", SVC_ORD.N3PTY_OFC_CD" ).append("\n"); 
		query.append(", SVC_ORD.CURR_CD" ).append("\n"); 
		query.append(", SVC_ORD.N3PTY_BIL_BZC_AMT" ).append("\n"); 
		query.append(", SVC_ORD.N3PTY_DESC" ).append("\n"); 
		query.append(", SVC_ORD.FINC_SKD_DIR_CD" ).append("\n"); 
		query.append(", @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", PRV_TMP.UPD_USR_ID" ).append("\n"); 
		query.append(", PRV_TMP.UPD_DT" ).append("\n"); 
		query.append(", PRV_TMP.LOCL_CRE_DT" ).append("\n"); 
		query.append(", PRV_TMP.LOCL_UPD_DT" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SVC_ORD, TRS_TRSP_WRK_ORD_PRV_TMP PRV_TMP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PRV_TMP.WO_PRV_GRP_SEQ =  @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("AND PRV_TMP.WO_ISS_NO =  @[wo_iss_no]" ).append("\n"); 
		query.append("AND PRV_TMP.WO_CXL_FLG != 'Y'" ).append("\n"); 
		query.append("AND SVC_ORD.TRSP_SO_OFC_CTY_CD = PRV_TMP.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND SVC_ORD.TRSP_SO_SEQ = PRV_TMP.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND SVC_ORD.N3PTY_BIL_FLG = 'Y'" ).append("\n"); 
		query.append("AND SVC_ORD.N3PTY_BIL_BZC_AMT <> 0" ).append("\n"); 
		query.append("AND SVC_ORD.N3PTY_BIL_TP_CD  IS NOT NULL" ).append("\n"); 

	}
}