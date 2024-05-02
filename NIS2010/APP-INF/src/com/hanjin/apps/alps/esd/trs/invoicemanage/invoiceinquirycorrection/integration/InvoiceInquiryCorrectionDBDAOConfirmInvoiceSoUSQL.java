/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAOConfirmInvoiceSoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.11.16 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
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
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration").append("\n"); 
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
		query.append("UPDATE  TRS_TRSP_SVC_ORD " ).append("\n"); 
		query.append("SET     TRSP_INV_ACT_STS_CD = 'C'" ).append("\n"); 
		query.append("      , LGS_COST_CD	        = (" ).append("\n"); 
		query.append("                                SELECT  NVL((" ).append("\n"); 
		query.append("                                              SELECT  A.LGS_COST_CD" ).append("\n"); 
		query.append("                                              FROM    TRS_LGS_COST_CD_CONV_RULE A" ).append("\n"); 
		query.append("                                                    , TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("                                                    , TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append("                                              WHERE   A.COST_ACT_GRP_CD = B.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                                              AND     A.LGS_COST_CD_CHK_FLG = DECODE(SUBSTR(FM_NOD_CD,1,5),SUBSTR(TO_NOD_CD,1,5) ,'Y','N')" ).append("\n"); 
		query.append("                                              AND     LGS_COST.LGS_COST_CD  =A.LGS_COST_CD" ).append("\n"); 
		query.append("                                              AND     CGO_TP_CD='F'" ).append("\n"); 
		query.append("                                              AND     TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("                                              AND	  B.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                                              AND	  B.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                                                      /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("                                              AND     B.HJL_NO IS NULL" ).append("\n"); 
		query.append("                                              UNION ALL" ).append("\n"); 
		query.append("                                              SELECT  LGS_COST.LGS_COST_CD" ).append("\n"); 
		query.append("                                              FROM    TRS_TRSP_SVC_ORD B,TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append("                                              WHERE   LGS_COST.LGS_COST_CD = 'TR'" ).append("\n"); 
		query.append("                                                                             || DECODE(B.TRSP_COST_DTL_MOD_CD, 'CF', 'OF', 'CN', 'ON', 'MT')" ).append("\n"); 
		query.append("                                                                             || DECODE(B.TRSP_CRR_MOD_CD, 'TW', 'WT', 'RW', 'WR', 'TR', 'RT', B.TRSP_CRR_MOD_CD)" ).append("\n"); 
		query.append("                                              AND     (B.CGO_TP_CD, B.TRSP_SO_TP_CD) in (('M','M'), ('M','Y'))" ).append("\n"); 
		query.append("                                              AND	  B.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                                              AND	  B.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                                            ),  C.LGS_COST_CD)" ).append("\n"); 
		query.append("                                FROM    TRS_TRSP_SVC_ORD C" ).append("\n"); 
		query.append("                                WHERE   C.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                                AND	    C.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                                        /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("                                AND     C.HJL_NO IS NULL" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("      , ACCT_CD             = (" ).append("\n"); 
		query.append("                                SELECT  NVL((" ).append("\n"); 
		query.append("                                              SELECT  LGS_COST.ACCT_CD" ).append("\n"); 
		query.append("                                              FROM    TRS_LGS_COST_CD_CONV_RULE A" ).append("\n"); 
		query.append("                                                    , TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("                                                    , TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append("                                              WHERE   A.COST_ACT_GRP_CD = B.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                                              AND     A.LGS_COST_CD_CHK_FLG = DECODE(SUBSTR(FM_NOD_CD,1,5),SUBSTR(TO_NOD_CD,1,5) ,'Y','N')" ).append("\n"); 
		query.append("                                              AND     LGS_COST.LGS_COST_CD  =A.LGS_COST_CD" ).append("\n"); 
		query.append("                                              AND     CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                                              AND     TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("                                              AND	  B.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                                              AND	  B.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                                                      /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("                                              AND     B.HJL_NO IS NULL" ).append("\n"); 
		query.append("                                              UNION ALL" ).append("\n"); 
		query.append("                                              SELECT  LGS_COST.ACCT_CD" ).append("\n"); 
		query.append("                                              FROM    TRS_TRSP_SVC_ORD B,TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append("                                              WHERE   LGS_COST.LGS_COST_CD = 'TR'" ).append("\n"); 
		query.append("                                                                             || DECODE(B.TRSP_COST_DTL_MOD_CD, 'CF', 'OF', 'CN', 'ON', 'MT')" ).append("\n"); 
		query.append("                                                                             || DECODE(B.TRSP_CRR_MOD_CD, 'TW', 'WT', 'RW', 'WR', 'TR', 'RT', B.TRSP_CRR_MOD_CD)" ).append("\n"); 
		query.append("                                              AND     (B.CGO_TP_CD, B.TRSP_SO_TP_CD) in (('M','M'), ('M','Y'))" ).append("\n"); 
		query.append("                                              AND	  B.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                                              AND	  B.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                                            ),  C.ACCT_CD)" ).append("\n"); 
		query.append("                                FROM    TRS_TRSP_SVC_ORD C" ).append("\n"); 
		query.append("                                WHERE   C.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                                AND	    C.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                                        /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("                                AND     C.HJL_NO IS NULL" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("      , FINC_VSL_CD         = (" ).append("\n"); 
		query.append("                                SELECT	B.VSL_CD FDR_VSL_CD" ).append("\n"); 
		query.append("                                FROM	TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("                                WHERE   B.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                                AND	    B.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                                        /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("                                AND     B.HJL_NO IS NULL" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("      ,	FINC_SKD_VOY_NO     = (" ).append("\n"); 
		query.append("                                SELECT	B.SKD_VOY_NO FDR_SKD_VOY_NO" ).append("\n"); 
		query.append("                                FROM	TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("                                WHERE   B.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                                AND	    B.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                                        /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("                                AND    B.HJL_NO IS NULL" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("      ,	FINC_SKD_DIR_CD     = (" ).append("\n"); 
		query.append("                                SELECT  DECODE (VSL_CD ,'CNTC','M',	NVL (MAS_REV_DIR_CONV_FNC (SLAN_CD,POL_CD,SKD_DIR_CD,POD_CD),SKD_DIR_CD))" ).append("\n"); 
		query.append("                                FROM	TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("                                WHERE   B.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                                AND	    B.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                                        /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("                                AND     B.HJL_NO IS NULL" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("      , UPD_USR_ID		    = @[FORM_CRE_USR_ID]" ).append("\n"); 
		query.append("      ,	UPD_DT			    = SYSDATE" ).append("\n"); 
		query.append("      , LOCL_UPD_DT         = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD])" ).append("\n"); 
		query.append("WHERE   TRSP_SO_OFC_CTY_CD  = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND     TRSP_SO_SEQ         = @[trsp_so_seq]" ).append("\n"); 
		query.append("		/* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("AND     HJL_NO IS NULL" ).append("\n"); 

	}
}