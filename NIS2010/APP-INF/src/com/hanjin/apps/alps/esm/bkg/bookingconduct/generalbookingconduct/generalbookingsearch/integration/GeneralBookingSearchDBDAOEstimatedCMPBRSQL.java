/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOEstimatedCMPBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.12 
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

public class GeneralBookingSearchDBDAOEstimatedCMPBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_1183 조회 
	  * BKG 별 BKG_REV_COST 를 조회 함
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOEstimatedCMPBRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOEstimatedCMPBRSQL").append("\n"); 
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
		query.append("WITH REV AS (" ).append("\n"); 
		query.append("     SELECT BKG_NO" ).append("\n"); 
		query.append("          , REV_COST_SEQ" ).append("\n"); 
		query.append("          , REV_AMT" ).append("\n"); 
		query.append("          , ESTM_COST_AMT" ).append("\n"); 
		query.append("          , BKG_TEU_QTY" ).append("\n"); 
		query.append("          , CMPB_AMT" ).append("\n"); 
		query.append("          , EQ_MGMT_UC_AMT" ).append("\n"); 
		query.append("          , OFT_AMT " ).append("\n"); 
		query.append("       FROM BKG_REV_COST REV" ).append("\n"); 
		query.append("      WHERE BKG_NO     = @[bkg_no] " ).append("\n"); 
		query.append("        AND REV_COST_SEQ = (SELECT MAX(REV_COST_SEQ) " ).append("\n"); 
		query.append("                              FROM BKG_REV_COST " ).append("\n"); 
		query.append("                             WHERE BKG_NO = REV.BKG_NO )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '1' SEQ" ).append("\n"); 
		query.append("     , 'Revenue Total' COST_NM" ).append("\n"); 
		query.append("     , REV_AMT  AMT" ).append("\n"); 
		query.append("     , '' RMK" ).append("\n"); 
		query.append("FROM REV" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '' SEQ" ).append("\n"); 
		query.append("     , '└ OFT' COST_NM" ).append("\n"); 
		query.append("     , OFT_AMT AMT" ).append("\n"); 
		query.append("     , '' RMK" ).append("\n"); 
		query.append("FROM REV " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2' SEQ" ).append("\n"); 
		query.append("     , 'Cost Total' COST_NM" ).append("\n"); 
		query.append("     , ESTM_COST_AMT  AMT" ).append("\n"); 
		query.append("     , '' RMK" ).append("\n"); 
		query.append("FROM REV" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT '' SEQ" ).append("\n"); 
		query.append("     , '└ EMU Cost' COST_NM" ).append("\n"); 
		query.append("     , NVL(EQ_MGMT_UC_AMT,NULL) AMT " ).append("\n"); 
		query.append("     , '' RMK" ).append("\n"); 
		query.append("FROM REV" ).append("\n"); 
		query.append("UNION ALL  " ).append("\n"); 
		query.append("SELECT '3' SEQ" ).append("\n"); 
		query.append("     , 'Contribution Margin' COST_NM" ).append("\n"); 
		query.append("     , (NVL(REV_AMT,0)-NVL(ESTM_COST_AMT,0)) AMT " ).append("\n"); 
		query.append("     , 'Per BL' RMK" ).append("\n"); 
		query.append("FROM REV" ).append("\n"); 
		query.append("UNION ALL  " ).append("\n"); 
		query.append("SELECT '4' SEQ" ).append("\n"); 
		query.append("     , 'CMPB (TEU)' COST_NM" ).append("\n"); 
		query.append("     , CMPB_AMT  AMT " ).append("\n"); 
		query.append("     , 'Per Box' RMK" ).append("\n"); 
		query.append("FROM REV" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT '5' SEQ" ).append("\n"); 
		query.append("     , 'Guide CMPB' COST_NM" ).append("\n"); 
		query.append("     , NULL  AMT -- 추후.. SPC 에서 조회해야 할 값" ).append("\n"); 
		query.append("     , 'Per Box' RMK" ).append("\n"); 
		query.append("FROM REV" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '6' SEQ" ).append("\n"); 
		query.append("     , 'Difference' COST_NM" ).append("\n"); 
		query.append("     , NULL  AMT -- 추후.. Guide CMPB - CMPB" ).append("\n"); 
		query.append("     , '' RMK" ).append("\n"); 
		query.append("FROM REV" ).append("\n"); 

	}
}