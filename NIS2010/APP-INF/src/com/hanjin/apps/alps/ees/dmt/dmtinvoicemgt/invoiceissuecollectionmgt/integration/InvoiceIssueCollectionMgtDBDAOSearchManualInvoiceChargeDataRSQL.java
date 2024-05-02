/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceChargeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceChargeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge 정보를 조회하는 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceChargeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BKG_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DMDT_TRF_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceChargeDataRSQL").append("\n"); 
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
		query.append("SELECT	T1.BKG_NO" ).append("\n"); 
		query.append("        , T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        , T1.CNTR_NO" ).append("\n"); 
		query.append("        , T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("        , T1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , T1.SC_NO" ).append("\n"); 
		query.append("        , TO_CHAR(T2.FM_MVMT_DT, 'YYYY-MM-DD') AS FM_MVMT_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T2.TO_MVMT_DT, 'YYYY-MM-DD') AS TO_MVMT_DT" ).append("\n"); 
		query.append("        , TO_CHAR(DECODE(NVL(T2.FT_CMNC_DT, ''), '', T2.FM_MVMT_DT, T2.FT_CMNC_DT), 'YYYY-MM-DD') AS FT_CMNC_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T2.FT_END_DT, 'YYYY-MM-DD') AS FT_END_DT" ).append("\n"); 
		query.append("        , T2.FT_DYS" ).append("\n"); 
		query.append("        , T2.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("        , T2.VNDR_SEQ" ).append("\n"); 
		query.append("        , T3.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("        , T2.ACT_CNT_CD || LPAD(T2.ACT_CUST_SEQ, 6, '0') AS ACT_PAYR_CUST_CD" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  B.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM    DMT_CHG_CALC    A, " ).append("\n"); 
		query.append("                MDM_CUSTOMER    B" ).append("\n"); 
		query.append("        WHERE   SYS_AREA_GRP_ID         = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND     A.CNTR_NO               = T2.CNTR_NO" ).append("\n"); 
		query.append("        AND     A.CNTR_CYC_NO           = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("        AND     A.DMDT_TRF_CD           = T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("        AND     A.DMDT_CHG_LOC_DIV_CD   = T2.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        AND     A.CHG_SEQ               = T2.CHG_SEQ" ).append("\n"); 
		query.append("        AND     A.ACT_CNT_CD            = B.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND     A.ACT_CUST_SEQ          = B.CUST_SEQ" ).append("\n"); 
		query.append("        ) AS ACT_PAYR_CUST_NM" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM   DMT_CHG_CALC A, MDM_VENDOR B" ).append("\n"); 
		query.append("        WHERE  SYS_AREA_GRP_ID         = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND    A.CNTR_NO               = T2.CNTR_NO" ).append("\n"); 
		query.append("        AND    A.CNTR_CYC_NO           = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("        AND    A.DMDT_TRF_CD           = T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("        AND    A.DMDT_CHG_LOC_DIV_CD   = T2.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        AND    A.CHG_SEQ               = T2.CHG_SEQ" ).append("\n"); 
		query.append("        AND    A.ACT_CUST_SEQ          = B.VNDR_SEQ" ).append("\n"); 
		query.append("        AND    A.ACT_CNT_CD            = B.VNDR_CNT_CD" ).append("\n"); 
		query.append("        )                                       AS ACT_PAYR_VNDR_NM" ).append("\n"); 
		query.append("        , T2.DMDT_TRF_APLY_TP_CD " ).append("\n"); 
		query.append("        , T2.OFC_TRNS_FLG" ).append("\n"); 
		query.append("        , T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("        , T2.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        , T2.CHG_SEQ" ).append("\n"); 
		query.append("        , T2.BZC_TRF_SEQ" ).append("\n"); 
		query.append("        , NVL(T2.BZC_DMDT_DE_TERM_CD, 'N')        AS BZC_DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("        , T2.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("        , T2.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("        , T2.ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("        , T2.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("        , T2.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("        , T2.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , T2.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("        , T2.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , T2.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("        , T2.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("        , TO_CHAR(T2.BZC_TRF_APLY_DT    , 'YYYY-MM-DD')    AS BZC_TRF_APLY_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T2.SC_RFA_EXPT_APLY_DT, 'YYYY-MM-DD')    AS SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR T1," ).append("\n"); 
		query.append("	    DMT_CHG_CALC     T2," ).append("\n"); 
		query.append("	    MDM_VENDOR       T3" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T1.BKG_NO          = @[BKG_NO]" ).append("\n"); 
		query.append("AND     T1.SYS_AREA_GRP_ID =" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("	    SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	    FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	    WHERE   CNT_CD = " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN SUBSTR(@[DMDT_TRF_CD], 2, 1) = 'M' AND SUBSTR(@[DMDT_TRF_CD], 3, 1) = 'I' THEN" ).append("\n"); 
		query.append("                 SUBSTR(T1.POD_CD, 0, 2)" ).append("\n"); 
		query.append("			WHEN SUBSTR(@[DMDT_TRF_CD], 2, 1) = 'M' AND SUBSTR(@[DMDT_TRF_CD], 3, 1) = 'O' THEN" ).append("\n"); 
		query.append("                 SUBSTR(T1.POL_CD, 0, 2)" ).append("\n"); 
		query.append("			WHEN SUBSTR(@[DMDT_TRF_CD], 2, 1) = 'T' AND SUBSTR(@[DMDT_TRF_CD], 3, 1) = 'I' THEN" ).append("\n"); 
		query.append("                 SUBSTR(T1.DEL_CD, 0, 2)" ).append("\n"); 
		query.append("			WHEN SUBSTR(@[DMDT_TRF_CD], 2, 1) = 'T' AND SUBSTR(@[DMDT_TRF_CD], 3, 1) = 'O' THEN" ).append("\n"); 
		query.append("            SUBSTR(T1.POR_CD, 0, 2)" ).append("\n"); 
		query.append("			END    " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("        AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("AND     T1.SYS_AREA_GRP_ID  = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     T1.CNTR_NO          = T2.CNTR_NO" ).append("\n"); 
		query.append("AND     T1.CNTR_CYC_NO      = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND     T2.DMDT_TRF_CD      = @[DMDT_TRF_CD]" ).append("\n"); 
		query.append("AND     T2.DMDT_CHG_LOC_DIV_CD <> 'TSP'" ).append("\n"); 
		query.append("AND     T2.DMDT_CHG_STS_CD IN ('D', 'E')" ).append("\n"); 
		query.append("AND     T2.VNDR_SEQ         = T3.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND     T2.VNDR_CNT_CD      = T3.VNDR_CNT_CD(+)" ).append("\n"); 
		query.append("ORDER BY T2.CNTR_NO" ).append("\n"); 

	}
}