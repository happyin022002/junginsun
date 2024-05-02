/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchOutstandingDetailListForInvoiceCreationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOSearchOutstandingDetailListForInvoiceCreationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOutstandingDetailListForInvoiceCreation
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchOutstandingDetailListForInvoiceCreationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchOutstandingDetailListForInvoiceCreationRSQL").append("\n"); 
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
		query.append("SELECT A.N3PTY_NO" ).append("\n"); 
		query.append("      ,A.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("      ,TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01132',A.EQ_KND_CD)  EQ_KND_NM" ).append("\n"); 
		query.append("      ,A.EQ_NO" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.BKG_NO	BKG_NO_ALL" ).append("\n"); 
		query.append("      ,A.BL_NO	BL_NO_ALL" ).append("\n"); 
		query.append("      ,A.VSL_CD||A.SKD_VOY_NO||SUBSTR(A.FINC_DIR_CD,1,1)	VVD" ).append("\n"); 
		query.append("      ,A.VVD_CD" ).append("\n"); 
		query.append("      ,'' MGSET_NO" ).append("\n"); 
		query.append("      ,A.YD_CD" ).append("\n"); 
		query.append("      ,DECODE(A.FM_NOD_CD,NULL,'',A.FM_NOD_CD||'-'||A.VIA_NOD_CD||'-'||A.TO_NOD_CD||'-'||A.DOR_NOD_CD) ROUTE" ).append("\n"); 
		query.append("      ,'' NEW_EQ_NO" ).append("\n"); 
		query.append("      ,'' NEW_CNTR_SEAL_NO" ).append("\n"); 
		query.append("      ,'' CITA_NO" ).append("\n"); 
		query.append("      ,'' CNTR_WGT" ).append("\n"); 
		query.append("      ,'' N3PTY_CNTR_WGT_UT_CD" ).append("\n"); 
		query.append("      ,'' WT_HRS" ).append("\n"); 
		query.append("      ,'' NEW_VSL_CD" ).append("\n"); 
		query.append("      ,'' NEW_VVD" ).append("\n"); 
		query.append("      ,'' NEW_BKG_NO" ).append("\n"); 
		query.append("      ,'' DAMAGE_DT" ).append("\n"); 
		query.append("      ,'' REPAIR_LOCATION" ).append("\n"); 
		query.append("      ,'' LAST_FREE_DT" ).append("\n"); 
		query.append("      ,'' PKUP_DT" ).append("\n"); 
		query.append("      ,'' FT_OVR_DYS" ).append("\n"); 
		query.append("      ,A.CSR_NO" ).append("\n"); 
		query.append("      ,A.GL_DT" ).append("\n"); 
		query.append("#if (${s_from_curr_cd} != '' && ${s_curr_cd} != '') " ).append("\n"); 
		query.append("	   , TPB_GET_INV_CURR_CHG_FNC(A.CFM_CURR_CD,@[s_curr_cd],A.OTS_AMT, SYSDATE) AS OTS_AMT" ).append("\n"); 
		query.append("	   , TPB_GET_INV_CURR_CHG_FNC(A.CFM_CURR_CD,@[s_curr_cd],A.OTS_AMT, SYSDATE) AS INV_DTL_AMT" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      ,A.OTS_AMT" ).append("\n"); 
		query.append("      ,A.OTS_AMT INV_DTL_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,A.EQ_KND_CD" ).append("\n"); 
		query.append("      ,A.FM_NOD_CD" ).append("\n"); 
		query.append("      ,A.VIA_NOD_CD" ).append("\n"); 
		query.append("      ,A.TO_NOD_CD" ).append("\n"); 
		query.append("      ,A.DOR_NOD_CD" ).append("\n"); 
		query.append("      ,A.BKG_NO" ).append("\n"); 
		query.append("      ,A.BL_NO" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SUBSTR(A.FINC_DIR_CD,1,1) SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.ESTM_SYS_AREA_GRP_ID ESTM_SVR_ID" ).append("\n"); 
		query.append("      ,A.OTS_AMT	ORIGINAL_INV_DTL_AMT" ).append("\n"); 
		query.append("      ,0 SO_IF_SEQ" ).append("\n"); 
		query.append("      ,A.LGS_COST_CD" ).append("\n"); 
		query.append("      ,A.ACCT_CD" ).append("\n"); 
		query.append("      ,A.SO_NO" ).append("\n"); 
		query.append("      ,A.FINC_DIR_CD" ).append("\n"); 
		query.append("      ,A.REV_AMT" ).append("\n"); 
		query.append("      ,A.OTS_DTL_SEQ" ).append("\n"); 
		query.append("      ,A.N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("      ,A.N3PTY_IF_TP_CD" ).append("\n"); 
		query.append("      ,A.ESTM_SEQ_NO" ).append("\n"); 
		query.append("      ,A.ESTM_RVIS_NO" ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL A, TPB_OTS_GRP B" ).append("\n"); 
		query.append(" WHERE A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("   AND A.N3PTY_NO IN ( NULL" ).append("\n"); 
		query.append("#if (${s_dao_n3pty_no} != '') /* --- n3pty_no 조건, '','' 구분자 처리 --- */" ).append("\n"); 
		query.append("	                  ,$s_dao_n3pty_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("   AND A.VNDR_CUST_DIV_CD IN ('V','C') /*ADDED BY KIM JIN-SEUNG IN 2007-05-10 */" ).append("\n"); 
		query.append("   AND A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("   AND EXISTS (" ).append("\n"); 
		query.append("                 SELECT N3PTY_NO" ).append("\n"); 
		query.append("                   FROM TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("                  WHERE C.N3PTY_NO = A.N3PTY_NO" ).append("\n"); 
		query.append("                    AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("                    AND C.OTS_STS_CD IN ('O','M','J') /* CHANGED BY KIM JIN-SEUNG IN 2007-08-03; ADDED J */" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("   AND ( B.N3PTY_INV_NO IS NULL" ).append("\n"); 
		query.append("    OR NOT EXISTS (" ).append("\n"); 
		query.append("                     SELECT N3PTY_INV_NO" ).append("\n"); 
		query.append("                       FROM TPB_INVOICE V" ).append("\n"); 
		query.append("                      WHERE V.N3PTY_INV_NO = B.N3PTY_INV_NO" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("       )/* ADDED BY KIM JIN-SEUNG IN 2007-05-10 */" ).append("\n"); 
		query.append(" ORDER BY A.N3PTY_BIL_TP_CD" ).append("\n"); 

	}
}