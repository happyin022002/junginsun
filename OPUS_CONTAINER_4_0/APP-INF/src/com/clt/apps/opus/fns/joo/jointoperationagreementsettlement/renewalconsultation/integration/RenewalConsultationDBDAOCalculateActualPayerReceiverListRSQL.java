/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOCalculateActualPayerReceiverListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalConsultationDBDAOCalculateActualPayerReceiverListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select actual payer/receiver for slip Auto Invoice, Invoice detail Search.
	  * </pre>
	  */
	public RenewalConsultationDBDAOCalculateActualPayerReceiverListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOCalculateActualPayerReceiverListRSQL").append("\n"); 
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
		query.append("SELECT STL.VSL_CD" ).append("\n"); 
		query.append("     , STL.SKD_VOY_NO" ).append("\n"); 
		query.append("     , STL.SKD_DIR_CD" ).append("\n"); 
		query.append("     , STL.REV_DIR_CD" ).append("\n"); 
		query.append("     , STL.REV_YRMON" ).append("\n"); 
		query.append("     , STL.STL_VVD_SEQ" ).append("\n"); 
		query.append("     , STL.JO_CRR_CD" ).append("\n"); 
		query.append("     , STL.RLANE_CD" ).append("\n"); 
		query.append("     , STL.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , STL.JO_STL_JB_CD" ).append("\n"); 
		query.append("     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , STL.RE_DIVR_CD" ).append("\n"); 
		query.append("     , STL.ACT_AMT" ).append("\n"); 
		query.append("     , STL.STL_RMK" ).append("\n"); 
		query.append("     , SUM(STL.ACT_AMT) OVER ( PARTITION BY STL.JO_CRR_CD, STL.LOCL_CURR_CD, STL.RE_DIVR_CD) AS ACT_INV_AMT" ).append("\n"); 
		query.append("  FROM JOO_STL_TGT STL" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND STL.STL_TGT_FLG      = 'Y'" ).append("\n"); 
		query.append("   AND NVL(STL.ACT_AMT, 0)  <> 0" ).append("\n"); 
		query.append("   /*Condition Start*/" ).append("\n"); 
		query.append("   AND STL.REV_YRMON    BETWEEN REPLACE(@[fr_rev_yrmon],'-','') AND REPLACE(@[to_rev_yrmon],'-','') /* Condition Target Revenue Month*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trd_cd}!='')" ).append("\n"); 
		query.append("   /* Condition Trade */" ).append("\n"); 
		query.append("   AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                      FROM JOO_CARRIER CRR" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND CRR.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                       AND CRR.JO_CRR_CD        = STL.JO_CRR_CD" ).append("\n"); 
		query.append("                       AND CRR.RLANE_CD         = STL.RLANE_CD" ).append("\n"); 
		query.append("                       AND CRR.TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("                 ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd}!='')" ).append("\n"); 
		query.append("   AND STL.RLANE_CD     = @[rlane_cd]   /* Condition Lane */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_vvd}!='')" ).append("\n"); 
		query.append("   AND STL.VSL_CD||STL.SKD_VOY_NO||STL.SKD_DIR_CD||STL.REV_DIR_CD LIKE @[rev_vvd]||'%'        /* Condition VVD */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cds} != '' && ${jo_stl_itm_cds} != 'ALL')" ).append("\n"); 
		query.append("   /* Condition Items */" ).append("\n"); 
		query.append("   AND STL.JO_STL_ITM_CD IN ( #foreach($key IN ${jo_stl_itm_cds})#if($velocityCount < $jo_stl_itm_cds.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   /*Codition E n d*/" ).append("\n"); 
		query.append("   /*Sheet Condition Start*/" ).append("\n"); 
		query.append("   AND STL.JO_CRR_CD        = @[jo_crr_cd] /*Sheet Carrier*/" ).append("\n"); 
		query.append("   AND STL.LOCL_CURR_CD     = @[locl_curr_cd] /*Sheet Currency*/" ).append("\n"); 
		query.append("   AND STL.RE_DIVR_CD       = @[re_divr_cd]   /*Sheet Rev, Exp */" ).append("\n"); 
		query.append("   /*Sheet Condition End */" ).append("\n"); 
		query.append(" ORDER BY STL.RE_DIVR_CD" ).append("\n"); 
		query.append("        , STL.VSL_CD  " ).append("\n"); 
		query.append("        , STL.SKD_VOY_NO" ).append("\n"); 
		query.append("        , STL.SKD_DIR_CD" ).append("\n"); 
		query.append("        , STL.REV_DIR_CD" ).append("\n"); 
		query.append("        , STL.REV_YRMON" ).append("\n"); 
		query.append("        , STL.STL_VVD_SEQ " ).append("\n"); 
		query.append("        , STL.JO_CRR_CD" ).append("\n"); 
		query.append("        , STL.JO_STL_ITM_CD" ).append("\n"); 
		query.append("        , STL.RLANE_CD" ).append("\n"); 

	}
}