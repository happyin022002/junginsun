/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOStlDupChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.29 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOStlDupChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement시 순수settlement만 Dup Check
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOStlDupChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_slt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_slt_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOStlDupChkRSQL").append("\n"); 
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
		query.append("SELECT 'Y' AS STL_DUP_FLG" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("WHERE  EXISTS (" ).append("\n"); 
		query.append("        SELECT 1 FROM (" ).append("\n"); 
		query.append("         SELECT NVL(B.RVS_CMB_FLG,'N') AS RVS_CMB_FLG" ).append("\n"); 
		query.append("         FROM   JOO_SETTLEMENT A," ).append("\n"); 
		query.append("                --2010.03.29 REVERSE된 DATA는 DUP CHK에서 제외함" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                       B.ACCT_YRMON" ).append("\n"); 
		query.append("                      ,B.STL_VVD_SEQ" ).append("\n"); 
		query.append("                      ,B.STL_SEQ" ).append("\n"); 
		query.append("                      ,A.RVS_CMB_FLG" ).append("\n"); 
		query.append("                FROM   JOO_STL_CMB     A," ).append("\n"); 
		query.append("                       JOO_STL_CMB_DTL B" ).append("\n"); 
		query.append("                WHERE  A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("                AND    A.JO_CRR_CD   = B.JO_CRR_CD" ).append("\n"); 
		query.append("                AND    A.STL_CMB_SEQ = B.STL_CMB_SEQ" ).append("\n"); 
		query.append("                AND    A.RE_DIVR_CD  = B.RE_DIVR_CD" ).append("\n"); 
		query.append("                AND    A.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("                AND    A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("                AND    A.RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("                ) B" ).append("\n"); 
		query.append("         WHERE  A.ACCT_YRMON    = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("         AND    A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("         AND    A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("         AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("         AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("         AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("         AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("         AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("         AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("         AND    A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("         AND    A.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("         AND    A.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("         AND    A.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("         AND    A.REV_DIR_CD    = @[rev_dir_cd]" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} == 'R/F' && ${jo_mnu_nm} == 'R/F')" ).append("\n"); 
		query.append("         AND    A.IOC_CD          = @[ioc_cd]" ).append("\n"); 
		query.append("         AND    A.SCONTI_CD       = @[sconti_cd]" ).append("\n"); 
		query.append("         AND    A.FM_PORT_CD      = @[fm_port_cd]" ).append("\n"); 
		query.append("         AND    A.TO_PORT_CD      = @[to_port_cd]" ).append("\n"); 
		query.append("         AND    A.USD_SLT_BSA_QTY = TO_NUMBER(@[usd_slt_bsa_qty])" ).append("\n"); 
		query.append("         AND    A.STL_LOCL_AMT    = TO_NUMBER(@[stl_locl_amt])" ).append("\n"); 
		query.append("#elseif (${jo_stl_itm_cd} == 'S/H' && ${jo_mnu_nm} == 'S/H')" ).append("\n"); 
		query.append("         AND    A.JO_STL_JB_CD  = @[jo_stl_jb_cd]" ).append("\n"); 
		query.append("         AND    A.BSA_QTY       = TO_NUMBER(@[bsa_qty])" ).append("\n"); 
		query.append("         AND    A.STL_LOCL_AMT  = TO_NUMBER(@[stl_locl_amt])" ).append("\n"); 
		query.append("#elseif (${jo_stl_itm_cd} == 'OUS' && ${jo_mnu_nm} == 'RDR')" ).append("\n"); 
		query.append("         AND    A.IOC_CD          = @[ioc_cd]" ).append("\n"); 
		query.append("         AND    A.SCONTI_CD       = @[sconti_cd]" ).append("\n"); 
		query.append("         AND    A.USD_SLT_BSA_QTY = TO_NUMBER(@[usd_slt_bsa_qty])" ).append("\n"); 
		query.append("         AND    A.USD_SLT_WGT     = TO_NUMBER(@[usd_slt_wgt])" ).append("\n"); 
		query.append("         AND    A.STL_LOCL_AMT    = TO_NUMBER(@[stl_locl_amt])" ).append("\n"); 
		query.append("#elseif (${jo_stl_itm_cd} == 'OUS' && ${jo_mnu_nm} == 'TDR')" ).append("\n"); 
		query.append("         AND    A.FM_PORT_CD      = @[fm_port_cd]" ).append("\n"); 
		query.append("         AND    A.TO_PORT_CD      = @[to_port_cd]" ).append("\n"); 
		query.append("         AND    A.USD_SLT_BSA_QTY = TO_NUMBER(@[usd_slt_bsa_qty])" ).append("\n"); 
		query.append("         AND    A.USD_SLT_WGT     = TO_NUMBER(@[usd_slt_wgt])" ).append("\n"); 
		query.append("         AND    A.STL_LOCL_AMT    = TO_NUMBER(@[stl_locl_amt])" ).append("\n"); 
		query.append("#elseif (${jo_stl_itm_cd} == 'S/H' && ${jo_mnu_nm} == 'M/S')" ).append("\n"); 
		query.append("         AND    A.JO_STL_JB_CD  = @[jo_stl_jb_cd]" ).append("\n"); 
		query.append("         AND    A.BSA_QTY       = TO_NUMBER(@[bsa_qty])" ).append("\n"); 
		query.append("         AND    A.STL_LOCL_AMT  = TO_NUMBER(@[stl_locl_amt])" ).append("\n"); 
		query.append("#elseif ((${jo_stl_itm_cd} == 'OUS' ||${jo_stl_itm_cd} == 'R/F') && ${jo_mnu_nm} == 'M/S')" ).append("\n"); 
		query.append("         AND    A.BSA_QTY       = TO_NUMBER(@[bsa_qty])" ).append("\n"); 
		query.append("         AND    A.STL_LOCL_AMT  = TO_NUMBER(@[stl_locl_amt])" ).append("\n"); 
		query.append("#elseif (${jo_stl_itm_cd} == 'OTH' && ${jo_mnu_nm} == 'M/S')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         AND    A.STL_LOCL_AMT  = TO_NUMBER(@[stl_locl_amt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("   WHERE RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}