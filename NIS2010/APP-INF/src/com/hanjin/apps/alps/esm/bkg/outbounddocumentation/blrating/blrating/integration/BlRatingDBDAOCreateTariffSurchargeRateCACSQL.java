/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BlRatingDBDAOCreateTariffSurchargeRateCACSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOCreateTariffSurchargeRateCACSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CA시 Tariff Surcharge Rate Insert
	  * </pre>
	  */
	public BlRatingDBDAOCreateTariffSurchargeRateCACSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ").append("\n"); 
		query.append("FileName : BlRatingDBDAOCreateTariffSurchargeRateCACSQL").append("\n"); 
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
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("INSERT INTO BKG_TRF_SCG_RT (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_TRF_SCG_RT_HIS (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("    , CORR_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , RT_SEQ " ).append("\n"); 
		query.append("    , FRT_TERM_CD" ).append("\n"); 
		query.append("    , CGO_CATE_CD " ).append("\n"); 
		query.append("    , CHG_CD " ).append("\n"); 
		query.append("    , CURR_CD " ).append("\n"); 
		query.append("    , RAT_UT_CD " ).append("\n"); 
		query.append("    , RAT_AS_QTY " ).append("\n"); 
		query.append("    , CHG_UT_AMT " ).append("\n"); 
		query.append("    , CHG_AMT " ).append("\n"); 
		query.append("    , RCV_TERM_CD " ).append("\n"); 
		query.append("    , DE_TERM_CD " ).append("\n"); 
		query.append("    , FRT_INCL_XCLD_DIV_CD   " ).append("\n"); 
		query.append("    , CRE_USR_ID " ).append("\n"); 
		query.append("    , CRE_DT " ).append("\n"); 
		query.append("    , UPD_USR_ID " ).append("\n"); 
		query.append("    , UPD_DT " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("#elseif (${copy_type_cd} == 'TEMP')" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("        , 'TMP0000001' CORR_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("        , @[ca_no] CORR_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , RT_SEQ " ).append("\n"); 
		query.append("        , FRT_TERM_CD " ).append("\n"); 
		query.append("        , CGO_CATE_CD  " ).append("\n"); 
		query.append("        , CHG_CD " ).append("\n"); 
		query.append("        , CURR_CD " ).append("\n"); 
		query.append("        , RAT_UT_CD " ).append("\n"); 
		query.append("        , RAT_AS_QTY " ).append("\n"); 
		query.append("        , CHG_UT_AMT " ).append("\n"); 
		query.append("        , CHG_AMT " ).append("\n"); 
		query.append("        , RCV_TERM_CD " ).append("\n"); 
		query.append("        , DE_TERM_CD " ).append("\n"); 
		query.append("        , FRT_INCL_XCLD_DIV_CD   " ).append("\n"); 
		query.append("        , CRE_USR_ID " ).append("\n"); 
		query.append("        , CRE_DT " ).append("\n"); 
		query.append("        , UPD_USR_ID " ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("  FROM BKG_TRF_SCG_RT_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_TRF_SCG_RT" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}