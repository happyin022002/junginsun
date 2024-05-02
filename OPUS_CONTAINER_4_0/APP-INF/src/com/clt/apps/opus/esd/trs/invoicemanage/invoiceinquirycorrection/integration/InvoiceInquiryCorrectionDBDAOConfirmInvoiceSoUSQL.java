/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAOConfirmInvoiceSoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryCorrectionDBDAOConfirmInvoiceSoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O 테이블에 Invoice Confirm 정보를 반영
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAOConfirmInvoiceSoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryCorrectionDBDAOConfirmInvoiceSoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("   SET TRSP_INV_ACT_STS_CD = 'C'" ).append("\n"); 
		query.append("      ,LGS_COST_CD         = NVL((SELECT LGS_COST.LGS_COST_CD" ).append("\n"); 
		query.append("                                   FROM TRS_LGS_COST_CD_CONV_RULE B, TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append("                                  WHERE A.COST_ACT_GRP_CD = B.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                                    AND B.LGS_COST_CD_CHK_FLG = DECODE(SUBSTR(A.FM_NOD_CD, 1, 5), SUBSTR(A.TO_NOD_CD, 1, 5), 'Y', 'N')" ).append("\n"); 
		query.append("                                    AND LGS_COST.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("                                    AND A.CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                                    AND A.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT LGS_COST.LGS_COST_CD" ).append("\n"); 
		query.append("                                   FROM TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append("                                  WHERE LGS_COST.LGS_COST_CD =" ).append("\n"); 
		query.append("                                        'TR' || DECODE(A.TRSP_COST_DTL_MOD_CD, 'CF', 'OF', 'CN', 'ON', 'MT') || DECODE(A.TRSP_CRR_MOD_CD, 'TW', 'WT', 'RW', 'WR', 'TR', 'RT', A.TRSP_CRR_MOD_CD)" ).append("\n"); 
		query.append("                                    AND (A.CGO_TP_CD, A.TRSP_SO_TP_CD) in (('M', 'M'), ('M', 'Y')))" ).append("\n"); 
		query.append("                                ,A.LGS_COST_CD)" ).append("\n"); 
		query.append("      ,ACCT_CD             = NVL((SELECT LGS_COST.ACCT_CD" ).append("\n"); 
		query.append("                                   FROM TRS_LGS_COST_CD_CONV_RULE B, TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append("                                  WHERE A.COST_ACT_GRP_CD = B.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                                    AND B.LGS_COST_CD_CHK_FLG = DECODE(SUBSTR(A.FM_NOD_CD, 1, 5), SUBSTR(A.TO_NOD_CD, 1, 5), 'Y', 'N')" ).append("\n"); 
		query.append("                                    AND LGS_COST.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("                                    AND A.CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                                    AND A.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT LGS_COST.ACCT_CD" ).append("\n"); 
		query.append("                                   FROM TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append("                                  WHERE LGS_COST.LGS_COST_CD =" ).append("\n"); 
		query.append("                                        'TR' || DECODE(A.TRSP_COST_DTL_MOD_CD, 'CF', 'OF', 'CN', 'ON', 'MT') || DECODE(A.TRSP_CRR_MOD_CD, 'TW', 'WT', 'RW', 'WR', 'TR', 'RT', A.TRSP_CRR_MOD_CD)" ).append("\n"); 
		query.append("                                    AND (A.CGO_TP_CD, A.TRSP_SO_TP_CD) in (('M', 'M'), ('M', 'Y')))" ).append("\n"); 
		query.append("                                ,A.ACCT_CD)" ).append("\n"); 
		query.append("      ,FINC_VSL_CD         = A.VSL_CD" ).append("\n"); 
		query.append("      ,FINC_SKD_VOY_NO     = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,FINC_SKD_DIR_CD = DECODE(SIGN((SELECT count(X.VSL_CD) - 1" ).append("\n"); 
		query.append("                                       FROM AR_MST_REV_VVD X" ).append("\n"); 
		query.append("                                      WHERE X.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                        AND X.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND X.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        AND X.SLAN_CD = A.SLAN_CD" ).append("\n"); 
		query.append("                                        AND X.DELT_FLG = 'N'))" ).append("\n"); 
		query.append("                               ,-1" ).append("\n"); 
		query.append("                               ,(CASE" ).append("\n"); 
		query.append("                                  WHEN A.VSL_CD = 'CNTC' THEN 'M'" ).append("\n"); 
		query.append("                                  ELSE" ).append("\n"); 
		query.append("                                   (SELECT A.SKD_DIR_CD || NVL(COA_REV_DIR_CONV_FNC(VVD.SLAN_CD, VVD.POL_CD, VVD.SKD_DIR_CD), A.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                      FROM BKG_VVD VVD" ).append("\n"); 
		query.append("                                     WHERE VVD.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                       AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("                                       AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                END)" ).append("\n"); 
		query.append("                               ,0" ).append("\n"); 
		query.append("                               ,(SELECT A.SKD_DIR_CD || NVL(X.RLANE_DIR_CD, A.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                  FROM AR_MST_REV_VVD X" ).append("\n"); 
		query.append("                                 WHERE X.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                   AND X.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND X.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND X.SLAN_CD = A.SLAN_CD" ).append("\n"); 
		query.append("                                   AND X.DELT_FLG = 'N')" ).append("\n"); 
		query.append("                               ,1" ).append("\n"); 
		query.append("                               ,(SELECT A.SKD_DIR_CD || NVL(COA_REV_DIR_CONV_FNC(VVD.SLAN_CD, VVD.POL_CD, VVD.SKD_DIR_CD), A.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("                                 WHERE VVD.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                   AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1))" ).append("\n"); 
		query.append("      ,UPD_USR_ID          = @[FORM_CRE_USR_ID]" ).append("\n"); 
		query.append("      ,UPD_DT              = SYSDATE" ).append("\n"); 
		query.append(" WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}