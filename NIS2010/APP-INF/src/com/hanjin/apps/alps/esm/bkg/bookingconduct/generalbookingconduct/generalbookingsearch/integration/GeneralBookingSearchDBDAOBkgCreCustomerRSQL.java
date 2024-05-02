/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOBkgCreCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOBkgCreCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgCreCustomerVO
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOBkgCreCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("area_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOBkgCreCustomerRSQL").append("\n"); 
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
		query.append("select  cust.cust_cnt_cd," ).append("\n"); 
		query.append("        cust.cust_seq,		" ).append("\n"); 
		query.append("		cust.cust_cnt_cd||LPAD(cust.cust_seq,6,'0') customer_code," ).append("\n"); 
		query.append("		CASE WHEN CUST.SLS_DELT_EFF_RSN_CD = '07' THEN 'Exceeding Credit Limit'" ).append("\n"); 
		query.append("             WHEN CUST.SLS_DELT_EFF_DT IS NOT NULL THEN 'No Use'" ).append("\n"); 
		query.append("             WHEN NVL(CR.CUST_RLSE_CTRL_FLG, 'N') = 'Y' THEN 'Financial Risk'	" ).append("\n"); 
		query.append("			 WHEN CUST.DELT_FLG = 'Y' THEN 'Delete'		" ).append("\n"); 
		query.append("            -- WHEN CUST.VBS_CLSS_CD = '01' THEN 'PREMIUM' Request by Woori hong" ).append("\n"); 
		query.append("              ELSE 'Use' END pb," ).append("\n"); 
		query.append("		UPPER(cust.cust_lgl_eng_nm) CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("        decode(CUST.RVIS_CNTR_CUST_TP_CD, 'B', 'BCO', 'Non BCO') cust_div_flag," ).append("\n"); 
		query.append("        cust.ofc_cd," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            select  UPPER(bzet_addr)                    " ).append("\n"); 
		query.append("            from    mdm_cust_addr" ).append("\n"); 
		query.append("            where   cust_cnt_cd = cust.cust_cnt_cd" ).append("\n"); 
		query.append("            and     cust_seq = cust.cust_seq" ).append("\n"); 
		query.append("            and     prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("			and     rownum = 1" ).append("\n"); 
		query.append("        ) bzet_addr," ).append("\n"); 
		query.append("		cust.frt_fwrd_fmc_no," ).append("\n"); 
		query.append("        cust.delt_flg," ).append("\n"); 
		query.append("        NVL(CR.CR_CLT_OFC_CD, CUST.OFC_CD) AR_OFC," ).append("\n"); 
		query.append("        REP.SREP_NM," ).append("\n"); 
		query.append("        CR.CUST_RLSE_CTRL_RMK," ).append("\n"); 
		query.append("        CD.INTG_CD_VAL_DP_DESC AS NO_USE_RSN," ).append("\n"); 
		query.append("        ADDR.CTY_NM,  " ).append("\n"); 
		query.append("        ADDR.STE_CD,  " ).append("\n"); 
		query.append("        ADDR.ZIP_CD," ).append("\n"); 
		query.append("        PNT.PHN_NO," ).append("\n"); 
		query.append("        DECODE(NVL(CR.CUST_RLSE_CTRL_FLG, 'N'),'Y','Yes','No')   R_BKLST," ).append("\n"); 
		query.append("		LOC.LOC_CD || '-' || LOC.LOC_NM as LOCATION_CODE " ).append("\n"); 
		query.append(" from mdm_customer cust" ).append("\n"); 
		query.append("     ,MDM_CR_CUST CR" ).append("\n"); 
		query.append("     ,MDM_SLS_REP REP" ).append("\n"); 
		query.append("     ,COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("     ,MDM_CUST_ADDR ADDR" ).append("\n"); 
		query.append("     ,MDM_CUST_CNTC_PNT PNT" ).append("\n"); 
		query.append("	 ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("where cust.cust_cnt_cd = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  and nvl(cust.nmd_cust_flg, 'N') = 'N'" ).append("\n"); 
		query.append("  AND CUST.CNTR_DIV_FLG = 'Y'   " ).append("\n"); 
		query.append("  AND CUST.DELT_FLG ='N'   " ).append("\n"); 
		query.append("#if (${cust_seq} != '') " ).append("\n"); 
		query.append("  and CUST.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '') " ).append("\n"); 
		query.append("  #if(${include} != '')" ).append("\n"); 
		query.append("	--include" ).append("\n"); 
		query.append("     AND (REGEXP_REPLACE(UPPER(CUST.CUST_LGL_ENG_NM),'[^a-zA-Z0-9]','')  LIKE '%'||REGEXP_REPLACE(UPPER(@[cust_nm]),'[^a-zA-Z0-9]','')||'%')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND UPPER(CUST.CUST_LGL_ENG_NM) LIKE UPPER(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("  and cust.ofc_cd = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cty_nm} != '') " ).append("\n"); 
		query.append("  and UPPER(ADDR.CTY_NM) = UPPER(@[cty_nm])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ste_cd} != '') " ).append("\n"); 
		query.append("  and UPPER(ADDR.STE_CD) = UPPER(@[ste_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${zip_cd} != '') " ).append("\n"); 
		query.append("  and UPPER(ADDR.ZIP_CD) = UPPER(@[zip_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${area_cd} != '') " ).append("\n"); 
		query.append("  AND SUBSTR(LTRIM(PHN_NO,'1-'),0,3)  = @[area_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${no_use} != '') " ).append("\n"); 
		query.append("  AND (CUST.SLS_DELT_EFF_DT IS NULL OR CUST.SLS_DELT_EFF_DT IS NOT NULL)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND ((CUST.SLS_DELT_EFF_DT IS NULL OR CUST.SLS_DELT_EFF_RSN_CD = '07') AND CUST.DELT_FLG ='N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bklst} != 'on') " ).append("\n"); 
		query.append(" AND NVL(CR.CUST_RLSE_CTRL_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" AND NVL(CR.CUST_RLSE_CTRL_FLG, 'N') IN ('N','Y')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND CUST.CUST_CNT_CD = CR.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND CUST.CUST_SEQ = CR.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND CUST.CUST_CNT_CD = ADDR.CUST_CNT_CD " ).append("\n"); 
		query.append("  AND CUST.CUST_SEQ = ADDR.CUST_SEQ " ).append("\n"); 
		query.append("  AND CUST.CUST_CNT_CD = PNT.CUST_CNT_CD " ).append("\n"); 
		query.append("  AND CUST.CUST_SEQ = PNT.CUST_SEQ " ).append("\n"); 
		query.append("  AND ADDR.PRMRY_CHK_FLG ='Y' " ).append("\n"); 
		query.append("  AND CUST.SREP_CD = REP.SREP_CD (+)" ).append("\n"); 
		query.append("  AND CUST.SLS_DELT_EFF_RSN_CD = CD.INTG_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("  AND CD.INTG_CD_ID(+) = 'CD03011'" ).append("\n"); 
		query.append("  AND CUST.LOC_CD = LOC.LOC_CD(+)" ).append("\n"); 
		query.append("order by cust.delt_flg , CUST.SLS_DELT_EFF_DT nulls first" ).append("\n"); 

	}
}