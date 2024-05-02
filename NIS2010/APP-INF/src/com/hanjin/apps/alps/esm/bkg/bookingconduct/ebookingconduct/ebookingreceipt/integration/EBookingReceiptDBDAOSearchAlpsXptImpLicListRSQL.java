/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchAlpsXptImpLicListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.03.13 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchAlpsXptImpLicListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * alps의 export/import licens no를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchAlpsXptImpLicListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchAlpsXptImpLicListRSQL").append("\n"); 
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
		query.append("SELECT  BKG_NO" ).append("\n"); 
		query.append("       , IO_BND_CD" ).append("\n"); 
		query.append("       , XPT_IMP_SEQ" ).append("\n"); 
		query.append("--       , CNT_CD" ).append("\n"); 
		query.append("       , DECODE(CNT_CD,'PE','MX','CO','MX','EC','MX',CNT_CD) CNT_CD" ).append("\n"); 
		query.append("       , XPT_LIC_NO" ).append("\n"); 
		query.append("       , TS_REF_NO" ).append("\n"); 
		query.append("       , PCK_QTY" ).append("\n"); 
		query.append("       , PCK_TP_CD" ).append("\n"); 
		query.append("       , MF_WGT" ).append("\n"); 
		query.append("       , WGT_UT_CD" ).append("\n"); 
		query.append("       , DIVD_FLG" ).append("\n"); 
		query.append("       , DIVD_SEQ" ).append("\n"); 
		query.append("       , DIVD_PCK_QTY" ).append("\n"); 
		query.append("       , DIVD_PCK_TP_CD" ).append("\n"); 
		query.append("       , DIVD_WGT" ).append("\n"); 
		query.append("       , DIVD_WGT_UT_CD" ).append("\n"); 
		query.append("       , SAM_PCK_ID" ).append("\n"); 
		query.append("       , SAM_PCK_QTY" ).append("\n"); 
		query.append("       , SAM_PCK_TP_CD" ).append("\n"); 
		query.append("       , AES_TP_CD" ).append("\n"); 
		query.append("       , AES_INLND_TRNS_PFX_CTNT" ).append("\n"); 
		query.append("       , AES_INLND_TRNS_NO" ).append("\n"); 
		query.append("       , AES_PTA_PFX_CTNT" ).append("\n"); 
		query.append("       , AES_PTA_NO1" ).append("\n"); 
		query.append("       , AES_PTA_NO2" ).append("\n"); 
		query.append("       , TO_CHAR(AES_PTA_DT,'MM-DD-YYYY') AES_PTA_DT" ).append("\n"); 
		query.append("       , AES_PTU_PFX_CTNT" ).append("\n"); 
		query.append("       , AES_PTU_NO" ).append("\n"); 
		query.append("       , TO_CHAR(AES_PTU_DT,'MM-DD-YYYY') AES_PTU_DT" ).append("\n"); 
		query.append("       , AES_DWN_PFX_CTNT" ).append("\n"); 
		query.append("       , AES_DWN_NO" ).append("\n"); 
		query.append("       , TO_CHAR(AES_DWN_DT,'MM-DD-YYYY') AES_DWN_DT" ).append("\n"); 
		query.append("       , AES_EXPT_ID" ).append("\n"); 
		query.append("       , AES_EXPT_CTNT" ).append("\n"); 
		query.append("       , CAED_TP_CD" ).append("\n"); 
		query.append("       , CAED_PFX_CTNT" ).append("\n"); 
		query.append("       , CAED_NO1" ).append("\n"); 
		query.append("			||decode(nvl(CAED_NO2, 'x'), 'x', '', '-'||CAED_NO2)" ).append("\n"); 
		query.append("			||decode(nvl(CAED_NO3, 'x'), 'x', '', '-'||CAED_NO3) CAED_CTNT" ).append("\n"); 
		query.append("--	   , CAED_NO1" ).append("\n"); 
		query.append("--       , CAED_NO2" ).append("\n"); 
		query.append("--       , CAED_NO3" ).append("\n"); 
		query.append("       , G7_EDI_PFX_CTNT" ).append("\n"); 
		query.append("       , G7_EDI_NO1" ).append("\n"); 
		query.append("			||decode(nvl(G7_EDI_NO2, 'x'), 'x', '', '-'||G7_EDI_NO2) G7_EDI_CTNT" ).append("\n"); 
		query.append("--       , G7_EDI_NO1" ).append("\n"); 
		query.append("--       , G7_EDI_NO2" ).append("\n"); 
		query.append("       , B13A_XPT_PFX_CTNT" ).append("\n"); 
		query.append("       , TO_CHAR(B13A_XPT_DT, 'YYYY/MM/DD hh24:mi')" ).append("\n"); 
		query.append("			||decode(nvl(B13A_XPT_NO1, 'x'), 'x', '', ' '||B13A_XPT_NO1)" ).append("\n"); 
		query.append("			||decode(nvl(B13A_XPT_NO2, 'x'), 'x', '', '-'||B13A_XPT_NO2) B13A_XPT_CTNT" ).append("\n"); 
		query.append("--	   , TO_CHAR(B13A_XPT_DT, 'YYYY-MM-DD') B13A_XPT_DT" ).append("\n"); 
		query.append("--       , B13A_XPT_NO1" ).append("\n"); 
		query.append("--       , B13A_XPT_NO2" ).append("\n"); 
		query.append("       , MF_SMRY_RPT_PFX_CTNT" ).append("\n"); 
		query.append("       , MF_SMRY_RPT_NO" ).append("\n"); 
		query.append("       , CGO_CTRL_PFX_CTNT" ).append("\n"); 
		query.append("       , CGO_CTRL_NO" ).append("\n"); 
		query.append("       , NDR_REF_PFX_CTNT" ).append("\n"); 
		query.append("       , NDR_REF_ID" ).append("\n"); 
		query.append("       , NDR_REF_CTNT" ).append("\n"); 
		query.append("	   , MX_SHPR_TAX_ID" ).append("\n"); 
		query.append("	   , MX_CNEE_TAX_ID" ).append("\n"); 
		query.append("	   , MX_NTFY_TAX_ID" ).append("\n"); 
		query.append("	   , TR_SHPR_TAX_ID" ).append("\n"); 
		query.append("       , TR_CNEE_TAX_ID" ).append("\n"); 
		query.append("       , TR_NTFY_TAX_ID" ).append("\n"); 
		query.append("	   , IL_SHPR_TAX_ID" ).append("\n"); 
		query.append("       , IL_CNEE_TAX_ID" ).append("\n"); 
		query.append("       , IL_NTFY_TAX_ID" ).append("\n"); 
		query.append("	   , LB_SHPR_TAX_ID" ).append("\n"); 
		query.append("       , LB_CNEE_TAX_ID" ).append("\n"); 
		query.append("       , LB_NTFY_TAX_ID" ).append("\n"); 
		query.append("       , SHPR_TAX_NO AS BR_SHPR_TAX_ID    -- Brazil 추가 " ).append("\n"); 
		query.append("       , CNEE_TAX_NO AS BR_CNEE_TAX_ID    -- Brazil 추가 " ).append("\n"); 
		query.append("       , NTFY_TAX_NO AS BR_NTFY_TAX_ID    -- Brazil 추가 " ).append("\n"); 
		query.append("       , BRZ_DECL_NO    -- Brazil 추가 " ).append("\n"); 
		query.append("       , SHPR_TAX_CPY_DESC_FLG , CNEE_TAX_CPY_DESC_FLG, NTFY_TAX_CPY_DESC_FLG, BRZ_DECL_CPY_DESC_FLG " ).append("\n"); 
		query.append("	   , VIN_CTNT" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   --AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("   AND IO_BND_CD = DECODE(CNT_CD,'MX',IO_BND_CD," ).append("\n"); 
		query.append("                                 'PE',IO_BND_CD," ).append("\n"); 
		query.append("                                 'CO',IO_BND_CD," ).append("\n"); 
		query.append("                                 'EC',IO_BND_CD," ).append("\n"); 
		query.append("                                 'IL',IO_BND_CD," ).append("\n"); 
		query.append("                                 'LB',IO_BND_CD," ).append("\n"); 
		query.append("                                 'BR',IO_BND_CD,'O')" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("   AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}