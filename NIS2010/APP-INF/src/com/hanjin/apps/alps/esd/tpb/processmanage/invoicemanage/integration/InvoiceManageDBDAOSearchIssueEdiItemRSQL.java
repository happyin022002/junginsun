/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchIssueEdiItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchIssueEdiItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchIssueEdiItem
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchIssueEdiItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchIssueEdiItemRSQL").append("\n"); 
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
		query.append("SELECT  D.N3PTY_BIL_TP_CD                                           TYPE_CODE" ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(TPB_GET_N3PTY_BIL_TP_NM_FNC(D.N3PTY_BIL_TP_CD)) ,CHR(13)||CHR(10),' '),CHR(9),' ')) N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("       ,D.N3PTY_INV_RVIS_DTL_SEQ                                    SEQNO" ).append("\n"); 
		query.append("       ,D.EQ_KND_CD                                                 EQKIND" ).append("\n"); 
		query.append("       ,D.EQ_NO                                                     EQ_NO" ).append("\n"); 
		query.append("       ,D.EQ_TPSZ_CD                                                EQTYPE" ).append("\n"); 
		query.append("       ,D.BKG_NO	                                                BKGNO" ).append("\n"); 
		query.append("       ,D.BL_NO	                                                    BLNO" ).append("\n"); 
		query.append("       ,D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD	                    VVD" ).append("\n"); 
		query.append("       ,D.YD_CD                                                 	YARD" ).append("\n"); 
		query.append("       ,D.FM_NOD_CD||D.VIA_NOD_CD||D.TO_NOD_CD||D.DOR_NOD_CD	    ROUTE" ).append("\n"); 
		query.append("       ,( SELECT NVL(D.LOD_ID, NVL(MAX(CUST_REF_NO_CTNT),'')) " ).append("\n"); 
		query.append("          FROM BKG_REFERENCE R " ).append("\n"); 
		query.append("          WHERE R.BKG_NO(+)  = D.BKG_NO " ).append("\n"); 
		query.append("          AND   R.CNTR_NO(+) = D.EQ_NO " ).append("\n"); 
		query.append("          AND   R.BKG_REF_TP_CD = 'MSLD' )  LOAD_ID   " ).append("\n"); 
		query.append("       ,D.NEW_EQ_NO	                                                NEW_EQNO" ).append("\n"); 
		query.append("       ,D.NEW_CNTR_SEAL_NO	                                        NEW_SEAL" ).append("\n"); 
		query.append("       ,D.LST_FREE_DT	                                            LASTFREE_DATE" ).append("\n"); 
		query.append("       ,D.INV_DTL_AMT                                               AMT_ITEM" ).append("\n"); 
		query.append("       ,D.VAT_DTL_AMT                                               AMT_ITEM_VAT" ).append("\n"); 
		query.append("       ,D.PKUP_DT                                                   PICKUP_DATE" ).append("\n"); 
		query.append("       ,D.FT_OVR_DYS                                                FREETIME_OVER" ).append("\n"); 
		query.append("       ,D.CITA_NO                                                   CITATION" ).append("\n"); 
		query.append("       ,D.CNTR_WGT                                                  CNTR_WGT" ).append("\n"); 
		query.append("       ,D.N3PTY_CNTR_WGT_UT_CD                                      CNTR_WUNIT" ).append("\n"); 
		query.append("       ,D.WT_HRS	                                                WAIT_HRS" ).append("\n"); 
		query.append("       ,D.OCCR_DT	                                                OCCUR_DATE" ).append("\n"); 
		query.append("       ,D.NEW_VSL_CD||D.NEW_SKD_VOY_NO||D.NEW_BKG_NO	            NEW_VVD" ).append("\n"); 
		query.append("       ,D.NEW_BKG_NO	                                            NEW_BKGNO" ).append("\n"); 
		query.append("       ,D.ACCT_CD	                                                ACCT" ).append("\n"); 
		query.append("       ,D.LGS_COST_CD	                                            LOG_COST" ).append("\n"); 
		query.append("       ,D.SO_NO                                                     SONO" ).append("\n"); 
		query.append("       ,D.CSR_NO                                                    CSRNO" ).append("\n"); 
		query.append("       ,D.GL_DT                                                     GL_DATE" ).append("\n"); 
		query.append("       ,D.VVD_CD                                                    VVD_CD" ).append("\n"); 
		query.append("       ,D.ACT_ATD_INP_DT                                            ATD_INPUT_DATE" ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(D.TML_NM) ,CHR(13)||CHR(10),' '),CHR(9),' '))  TERMINAL" ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(D.ACCT_NM) ,CHR(13)||CHR(10),' '),CHR(9),' ')) ACCOUNT_CD       " ).append("\n"); 
		query.append("FROM TPB_INV_RVIS R, TPB_INVOICE V, TPB_INV_RVIS_DTL D" ).append("\n"); 
		query.append("WHERE R.N3PTY_INV_NO = V.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND R.N3PTY_INV_RVIS_SEQ = V.LST_N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND R.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND D.N3PTY_INV_NO = R.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND D.N3PTY_INV_RVIS_SEQ = R.N3PTY_INV_RVIS_SEQ" ).append("\n"); 

	}
}