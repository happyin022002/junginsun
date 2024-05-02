/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOsearchVndrTotToEaiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOsearchVndrTotToEaiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor Total (MDM019_0001) Interface를 위한 정보 조회
	  * </pre>
	  */
	public PartnerDBDAOsearchVndrTotToEaiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOsearchVndrTotToEaiRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ               " ).append("\n"); 
		query.append("     , A.VNDR_CNT_CD" ).append("\n"); 
		query.append("     , A.VNDR_LGL_ENG_NM          " ).append("\n"); 
		query.append("     , HJSEAI_PKG.H_ENCODE(A.VNDR_LOCL_LANG_NM,'UTF8' ,'UTF8') VNDR_LOCL_LANG_NM        " ).append("\n"); 
		query.append("     , A.VNDR_ABBR_NM            " ).append("\n"); 
		query.append("     , A.LOC_CD                 " ).append("\n"); 
		query.append("     , '' MST_OFC_ID              " ).append("\n"); 
		query.append("     , A.OFC_CD                 " ).append("\n"); 
		query.append("     , HJSEAI_PKG.H_ENCODE(A.CEO_NM, 'UTF8' ,'UTF8') CEO_NM                 " ).append("\n"); 
		query.append("     , A.RGST_NO                " ).append("\n"); 
		query.append("     , A.TAX_ID                     " ).append("\n"); 
		query.append("     , A.PRNT_CNT_CD            " ).append("\n"); 
		query.append("     , A.PRNT_VNDR_SEQ           " ).append("\n"); 
		query.append("     , A.DCGO_HNDL_FLG       " ).append("\n"); 
		query.append("     , A.SVC_SCP_CD_NM           " ).append("\n"); 
		query.append("     , A.SVC_PRD_TP_NM            " ).append("\n"); 
		query.append("     , A.SVC_PRD_RMK            " ).append("\n"); 
		query.append("     , HJSEAI_PKG.H_ENCODE(A.BZCT_NM, 'UTF8' ,'UTF8') BZCT_NM               " ).append("\n"); 
		query.append("     , HJSEAI_PKG.H_ENCODE(A.BZTP_NM, 'UTF8' ,'UTF8') BZTP_NM              " ).append("\n"); 
		query.append("     , A.GEN_PAY_TERM_CD   " ).append("\n"); 
		query.append("     , A.ENG_ADDR      " ).append("\n"); 
		query.append("     , HJSEAI_PKG.H_ENCODE(A.LOCL_LANG_ADDR,'UTF8' ,'UTF8') LOCL_LANG_ADDR " ).append("\n"); 
		query.append("     , A.ZIP_CD " ).append("\n"); 
		query.append("     , HJSEAI_PKG.H_ENCODE(A.CNTC_PSON_NM,'UTF8' ,'UTF8') CNTC_PSON_NM " ).append("\n"); 
		query.append("     , A.INV_CURR_CD              " ).append("\n"); 
		query.append("     , A.PAY_CURR_CD " ).append("\n"); 
		query.append("     , A.PAY_MZD_CD" ).append("\n"); 
		query.append("     , A.USA_EDI_CD" ).append("\n"); 
		query.append("     , A.WO_ATCH_FILE_FLG " ).append("\n"); 
		query.append("     , A.WO_EDI_USE_FLG " ).append("\n"); 
		query.append("     , A.INV_EDI_USE_FLG " ).append("\n"); 
		query.append("     , A.MTY_RRO_EDI_USE_FLG     " ).append("\n"); 
		query.append("     , A.MODI_VNDR_SEQ " ).append("\n"); 
		query.append("     , A.BLK_FLG " ).append("\n"); 
		query.append("     , A.FINC_FLG " ).append("\n"); 
		query.append("     , A.TEAM_FLG " ).append("\n"); 
		query.append("     , A.INTER_CO_FLG " ).append("\n"); 
		query.append("     , A.LGS_FLG" ).append("\n"); 
		query.append("     , A.PROCU_FLG                  " ).append("\n"); 
		query.append("     , A.OTR_FLG " ).append("\n"); 
		query.append("     , A.BLK_VNDR_SVC_CD " ).append("\n"); 
		query.append("     , A.SUBS_CO_CD                 " ).append("\n"); 
		query.append("     , A.VNDR_OFC_CD " ).append("\n"); 
		query.append("     --,Ap_Prmry_Vndr_Tp         " ).append("\n"); 
		query.append("     , A.CRE_USR_ID " ).append("\n"); 
		query.append("     , TO_CHAR(A.CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT " ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT " ).append("\n"); 
		query.append("     , 'Y' PRMRY_CHK_FLG " ).append("\n"); 
		query.append("     , B.INTL_PHN_NO  " ).append("\n"); 
		query.append("     , B.PHN_NO  " ).append("\n"); 
		query.append("     , C.INTL_FAX_NO  " ).append("\n"); 
		query.append("     , C.FAX_NO  " ).append("\n"); 
		query.append("     , CASE WHEN D.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("            THEN D.VNDR_EML " ).append("\n"); 
		query.append("            WHEN E.PRMRY_CHK_FLG = 'Y' " ).append("\n"); 
		query.append("            THEN E.VNDR_EML " ).append("\n"); 
		query.append("        END AS VNDR_EML " ).append("\n"); 
		query.append("     , A.RFND_PSDO_CUST_CD " ).append("\n"); 
		query.append("     , A.PAY_TERM_TP_CD " ).append("\n"); 
		query.append("     , HJSEAI_PKG.H_ENCODE(A.CHK_DE_ADDR1, 'UTF8', 'UTF8') CHK_DE_ADDR1    " ).append("\n"); 
		query.append("     , HJSEAI_PKG.H_ENCODE(A.CHK_DE_ADDR2, 'UTF8', 'UTF8') CHK_DE_ADDR2 " ).append("\n"); 
		query.append("     , HJSEAI_PKG.H_ENCODE(A.CHK_DE_ADDR3, 'UTF8', 'UTF8') CHK_DE_ADDR3" ).append("\n"); 
		query.append("     , A.CHK_DE_CTY_NM    " ).append("\n"); 
		query.append("     , A.CHK_DE_STE_CD   " ).append("\n"); 
		query.append("     , A.CHK_DE_ZIP_CD   " ).append("\n"); 
		query.append("     , A.CHK_DE_CNT_CD   " ).append("\n"); 
		query.append("     , A.DELT_FLG" ).append("\n"); 
		query.append("  FROM MDM_VENDOR A" ).append("\n"); 
		query.append("     , MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append("     , MDM_VNDR_CNTC_PNT C" ).append("\n"); 
		query.append("     , MDM_VNDR_CNTC_PNT D" ).append("\n"); 
		query.append("     , MDM_VNDR_CNTC_PNT E" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("  AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("  AND B.CNTC_DIV_CD(+) = 'PHN'" ).append("\n"); 
		query.append("  AND B.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("  AND B.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("  AND A.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("  AND C.CNTC_DIV_CD(+) = 'FAX'" ).append("\n"); 
		query.append("  AND C.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("  AND C.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("  AND A.VNDR_SEQ = D.VNDR_SEQ(+)" ).append("\n"); 
		query.append("  AND D.CNTC_DIV_CD(+) = 'EMAIL'" ).append("\n"); 
		query.append("  AND D.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("  AND D.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("  AND A.VNDR_SEQ = E.VNDR_SEQ(+)" ).append("\n"); 
		query.append("  AND E.CNTC_DIV_CD(+) = 'WEB'" ).append("\n"); 
		query.append("  AND E.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("  AND E.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}