/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOBkgCreCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.06
*@LastModifier : Moon Hwan Choi
*@LastVersion : 1.0
* 2015.05.06 Moon Hwan Choi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Choi
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
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
		query.append("select  cust_cnt_cd," ).append("\n"); 
		query.append("        cust_seq,		" ).append("\n"); 
		query.append("		cust_cnt_cd||LPAD(cust_seq,6,'0') customer_code," ).append("\n"); 
		query.append("		CASE WHEN DELT_FLG = 'Y' THEN 'DELETE' " ).append("\n"); 
		query.append("			 WHEN SLS_DELT_EFF_DT IS NOT NULL THEN 'NO USE'" ).append("\n"); 
		query.append("             WHEN (SELECT NVL(CUST_RLSE_CTRL_FLG, 'N')" ).append("\n"); 
		query.append("					 FROM MDM_CR_CUST CR" ).append("\n"); 
		query.append("					WHERE CR.CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append(" 					  AND CR.CUST_SEQ    = CUST.CUST_SEQ) = 'Y' THEN 'BLACK'			" ).append("\n"); 
		query.append("             WHEN VBS_CLSS_CD = '01' THEN 'PREMIUM' END pb," ).append("\n"); 
		query.append("		UPPER(cust_lgl_eng_nm) CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("		loc_cd," ).append("\n"); 
		query.append("        decode(CNTR_CUST_TP_CD, 'B', 'BCO', 'Non BCO') cust_div_flag," ).append("\n"); 
		query.append("        ofc_cd," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            select  UPPER(bzet_addr)                    " ).append("\n"); 
		query.append("            from    mdm_cust_addr" ).append("\n"); 
		query.append("            where   cust_cnt_cd = cust.cust_cnt_cd" ).append("\n"); 
		query.append("            and     cust_seq = cust.cust_seq" ).append("\n"); 
		query.append("            and     prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("			and     rownum = 1" ).append("\n"); 
		query.append("        ) bzet_addr," ).append("\n"); 
		query.append("		frt_fwrd_fmc_no," ).append("\n"); 
		query.append("        delt_flg" ).append("\n"); 
		query.append(" from mdm_customer cust" ).append("\n"); 
		query.append("where cust_cnt_cd = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  and nvl(nmd_cust_flg, 'N') = 'N'" ).append("\n"); 
		query.append("  AND CUST.CNTR_DIV_FLG = 'Y'    " ).append("\n"); 
		query.append("#if (${cust_seq} != '') " ).append("\n"); 
		query.append("  and CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("  and upper(cust_lgl_eng_nm) like @[cust_lgl_eng_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("  and ofc_cd = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("  and loc_cd like '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by delt_flg, loc_cd" ).append("\n"); 

	}
}