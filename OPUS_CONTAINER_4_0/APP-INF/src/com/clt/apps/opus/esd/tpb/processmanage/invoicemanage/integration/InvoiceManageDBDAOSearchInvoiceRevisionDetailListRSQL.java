/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchInvoiceRevisionDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchInvoiceRevisionDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceRevisionDetailList
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchInvoiceRevisionDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_from_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchInvoiceRevisionDetailListRSQL").append("\n"); 
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
		query.append("SELECT A.N3PTY_INV_NO" ).append("\n"); 
		query.append("    ,A.N3PTY_NO" ).append("\n"); 
		query.append("    ,A.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("    ,TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("    ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01132',A.EQ_KND_CD) AS EQ_KND_NM" ).append("\n"); 
		query.append("    ,A.EQ_NO" ).append("\n"); 
		query.append("    ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("    ,A.BKG_NO BKG_NO_ALL" ).append("\n"); 
		query.append("    ,A.BL_NO BL_NO_ALL" ).append("\n"); 
		query.append("    ,A.VSL_CD||A.SKD_VOY_NO||SUBSTR(A.FINC_DIR_CD,1,1) VVD" ).append("\n"); 
		query.append("    ,A.VVD_CD   /* Added By Kim Jin-seung In 2007-08-13 */" ).append("\n"); 
		query.append("    ,'' MGSET_NO" ).append("\n"); 
		query.append("    ,A.YD_CD" ).append("\n"); 
		query.append("    ,DECODE(A.FM_NOD_CD,NULL,'',A.FM_NOD_CD||'-'||A.VIA_NOD_CD||'-'||A.TO_NOD_CD||'-'||A.DOR_NOD_CD) ROUTE" ).append("\n"); 
		query.append("    ,A.NEW_EQ_NO" ).append("\n"); 
		query.append("    ,A.NEW_CNTR_SEAL_NO" ).append("\n"); 
		query.append("    ,A.CITA_NO" ).append("\n"); 
		query.append("    ,A.CNTR_WGT" ).append("\n"); 
		query.append("    ,A.N3PTY_CNTR_WGT_UT_CD" ).append("\n"); 
		query.append("    ,A.WT_HRS" ).append("\n"); 
		query.append("    ,TO_CHAR(A.OCCR_DT,'YYYY-MM-DD HH24:MI') OCCR_DT /* TPB LOCAL DATE */" ).append("\n"); 
		query.append("    ,A.NEW_VSL_CD||A.NEW_SKD_VOY_NO||SUBSTR(A.NEW_SKD_DIR_CD,1,1) NEW_VVD" ).append("\n"); 
		query.append("    ,A.NEW_BKG_NO" ).append("\n"); 
		query.append("    ,'' DAMAGE_DT" ).append("\n"); 
		query.append("    ,'' REPAIR_LOCATION" ).append("\n"); 
		query.append("    ,TO_CHAR(A.LST_FREE_DT,'YYYY-MM-DD HH24:MI') LST_FREE_DT  /* NOT TPB LOCAL DATE */" ).append("\n"); 
		query.append("    ,TO_CHAR(A.PKUP_DT,'YYYY-MM-DD HH24:MI') PKUP_DT /* TPB LOCAL DATE */" ).append("\n"); 
		query.append("    ,A.FT_OVR_DYS" ).append("\n"); 
		query.append("    ,A.CSR_NO /* Added By Kim Jin-seung In 2007-08-13 */" ).append("\n"); 
		query.append("    ,A.GL_DT  /* Added By Kim Jin-seung In 2007-08-13 */" ).append("\n"); 
		query.append("#if(${s_from_curr_cd} != '' && ${s_curr_cd} != '')" ).append("\n"); 
		query.append("    ,TPB_GET_INV_CURR_CHG_FNC(@[s_from_curr_cd],@[s_curr_cd],A.OTS_AMT, TPB_GET_LCL_DATE_FNC(SYSDATE,@[user_ofc_cd]) ) OTS_AMT /* TPB LOCAL DATE */" ).append("\n"); 
		query.append("    ,TPB_GET_INV_CURR_CHG_FNC(@[s_from_curr_cd],@[s_curr_cd],A.INV_DTL_AMT, TPB_GET_LCL_DATE_FNC(SYSDATE,@[user_ofc_cd]) ) INV_DTL_AMT /* TPB LOCAL DATE */" ).append("\n"); 
		query.append("	,TPB_GET_INV_CURR_CHG_FNC(@[s_from_curr_cd],@[s_curr_cd],B.ADD_AMT, TPB_GET_LCL_DATE_FNC(SYSDATE,@[user_ofc_cd]) ) ADD_AMT /* TPB LOCAL DATE */" ).append("\n"); 
		query.append("    ,TPB_GET_INV_CURR_CHG_FNC(@[s_from_curr_cd],@[s_curr_cd],B.DDCT_AMT, TPB_GET_LCL_DATE_FNC(SYSDATE,@[user_ofc_cd]) ) DDCT_AMT /* TPB LOCAL DATE */" ).append("\n"); 
		query.append("    ,TPB_GET_INV_CURR_CHG_FNC(@[s_from_curr_cd],@[s_curr_cd],NVL(A.VAT_DTL_AMT,0), TPB_GET_LCL_DATE_FNC(SYSDATE,@[user_ofc_cd]) ) VAT_DTL_AMT /* TPB LOCAL DATE */" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    ,A.OTS_AMT" ).append("\n"); 
		query.append("    ,A.INV_DTL_AMT" ).append("\n"); 
		query.append("	,B.ADD_AMT" ).append("\n"); 
		query.append("	,B.DDCT_AMT" ).append("\n"); 
		query.append("	,NVL(A.VAT_DTL_AMT,0) VAT_DTL_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,A.EQ_KND_CD" ).append("\n"); 
		query.append("    ,A.FM_NOD_CD" ).append("\n"); 
		query.append("    ,A.VIA_NOD_CD" ).append("\n"); 
		query.append("    ,A.TO_NOD_CD" ).append("\n"); 
		query.append("    ,A.DOR_NOD_CD" ).append("\n"); 
		query.append("    ,A.BKG_NO" ).append("\n"); 
		query.append("    ,A.BL_NO" ).append("\n"); 
		query.append("    ,A.VSL_CD" ).append("\n"); 
		query.append("    ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,SUBSTR(A.FINC_DIR_CD,1,1) FINC_DIR_CD" ).append("\n"); 
		query.append("    ,A.ESTM_SYS_AREA_GRP_ID ESTM_SVR_ID" ).append("\n"); 
		query.append("    ,A.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("    ,A.INV_DTL_AMT    ORIGINAL_INV_DTL_AMT" ).append("\n"); 
		query.append("    ,0 AS SO_IF_SEQ" ).append("\n"); 
		query.append("    ,A.OTS_DTL_SEQ" ).append("\n"); 
		query.append("    ,CASE WHEN NVL(A.VAT_DTL_AMT,0) <> 0 THEN 1 ELSE 0 END VAT_DTL_CHK" ).append("\n"); 
		query.append("FROM TPB_INV_RVIS_DTL A, TPB_INV_RVIS B" ).append("\n"); 
		query.append("WHERE A.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND A.N3PTY_INV_RVIS_SEQ = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("AND A.N3PTY_INV_NO = B.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND A.N3PTY_INV_RVIS_SEQ = B.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("ORDER BY A.N3PTY_BIL_TP_CD  " ).append("\n"); 

	}
}