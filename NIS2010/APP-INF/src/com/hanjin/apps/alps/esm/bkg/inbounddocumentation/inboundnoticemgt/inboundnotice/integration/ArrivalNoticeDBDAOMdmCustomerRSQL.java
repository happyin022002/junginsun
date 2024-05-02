/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArrivalNoticeDBDAOMdmCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOMdmCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ArrivalNoticeDBDAOMdmCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd_ext",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOMdmCustomerRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_NL(A B C D) */  " ).append("\n"); 
		query.append("       A.CUST_CNT_CD || LPAD(A.CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("      ,CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,C.CTY_NM" ).append("\n"); 
		query.append("      ,C.BZET_ADDR" ).append("\n"); 
		query.append("      ,B.PHN_NO" ).append("\n"); 
		query.append("      ,B.FAX_NO" ).append("\n"); 
		query.append("      ,B.CUST_EML" ).append("\n"); 
		query.append("      ,CUST_STS_CD" ).append("\n"); 
		query.append("      ,DECODE(D.CUST_RLSE_CTRL_FLG,'N','No','Y','Yes',NULL,'No',D.CUST_RLSE_CTRL_FLG) BOOKING_ALERT_TO_DATE" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,SREP_CD" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,A.CUST_SEQ" ).append("\n"); 
		query.append("      ,CASE WHEN A.DELT_FLG = 'Y' OR A.SLS_DELT_EFF_DT IS NOT NULL THEN A.MODI_CUST_CNT_CD||LPAD(MODI_CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END AS MRG_CD" ).append("\n"); 
		query.append("      ,A.FRT_FWRD_FMC_NO                  AS FF_FMC_NO" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("          WHEN A.DELT_FLG = 'Y' THEN 'Yes'" ).append("\n"); 
		query.append("          WHEN A.SLS_DELT_EFF_DT IS NOT NULL THEN 'Yes'" ).append("\n"); 
		query.append("        ELSE 'No'" ).append("\n"); 
		query.append("        END " ).append("\n"); 
		query.append("        ) AS NO_USE               " ).append("\n"); 
		query.append("       ,   DECODE(A.RVIS_CNTR_CUST_TP_CD, 'B', 'BCO', 'NON BCO') CUST_DIV_FLAG" ).append("\n"); 
		query.append("       , C.ZIP_CD" ).append("\n"); 
		query.append("       , C.STE_CD" ).append("\n"); 
		query.append("       ,F.LOC_CD || '-' || F.LOC_NM as LOCATION_CODE           " ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER      A" ).append("\n"); 
		query.append("      ,MDM_CUST_CNTC_PNT B" ).append("\n"); 
		query.append("      ,MDM_CUST_ADDR     C" ).append("\n"); 
		query.append("      ,MDM_CR_CUST       D" ).append("\n"); 
		query.append("      ,MDM_LOCATION      F" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND NVL(A.NMD_CUST_FLG,'N')  <> 'Y'" ).append("\n"); 
		query.append("   AND B.CUST_CNT_CD    = A.CUST_CNT_CD " ).append("\n"); 
		query.append("   AND B.CUST_SEQ       = A.CUST_SEQ " ).append("\n"); 
		query.append("   AND C.CUST_CNT_CD    = A.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND C.CUST_SEQ       = A.CUST_SEQ " ).append("\n"); 
		query.append("   AND C.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("   AND D.CUST_CNT_CD(+) = A.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND D.CUST_SEQ(+)    = A.CUST_SEQ    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   /* 2014.12.19 ������������������������������������������ ������������������������������ ������������������������������������������ SUB_SYS_NM������������ ERP������������ ������������������������������ ������������������������������������������ ������������������������������ ������������ */" ).append("\n"); 
		query.append("   AND NVL(D.SUB_SYS_NM(+),'MDM') != 'ERP'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append(" AND A.LOC_CD = F.LOC_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' ) " ).append("\n"); 
		query.append("  AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_seq} != '')   " ).append("\n"); 
		query.append("  AND A.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append(" #if(${include} != '')" ).append("\n"); 
		query.append("  AND (REGEXP_REPLACE(UPPER(A.CUST_LGL_ENG_NM),'[^a-zA-Z0-9]','')  LIKE '%'||REGEXP_REPLACE(UPPER(@[cust_lgl_eng_nm]),'[^a-zA-Z0-9]','')||'%')" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("  AND UPPER(A.CUST_LGL_ENG_NM) LIKE UPPER(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_cnt_cd_ext} != '') " ).append("\n"); 
		query.append("  AND A.CUST_CNT_CD = @[cust_cnt_cd_ext]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')  " ).append("\n"); 
		query.append(" AND A.OFC_CD= UPPER(@[ofc_cd])" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_sts_cd} != '')  " ).append("\n"); 
		query.append(" AND A.CUST_STS_CD = @[cust_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ste_cd} != '')  " ).append("\n"); 
		query.append(" AND UPPER(C.STE_CD) = UPPER(@[ste_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cty_nm} != '')" ).append("\n"); 
		query.append(" AND UPPER(C.CTY_NM) = UPPER(@[cty_nm])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${zip_cd} != '')" ).append("\n"); 
		query.append(" AND C.ZIP_CD = @[zip_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${no_use} != '') " ).append("\n"); 
		query.append(" AND (A.SLS_DELT_EFF_DT IS NULL OR A.SLS_DELT_EFF_DT IS NOT NULL )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" AND (A.SLS_DELT_EFF_DT IS NULL AND A.DELT_FLG ='N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bklst} != '') " ).append("\n"); 
		query.append(" AND NVL(D.CUST_RLSE_CTRL_FLG, 'N') IN ('N','Y')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" AND NVL(D.CUST_RLSE_CTRL_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cre_limit} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NVL(A.SLS_DELT_EFF_RSN_CD ,'XX') <>'07'" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}