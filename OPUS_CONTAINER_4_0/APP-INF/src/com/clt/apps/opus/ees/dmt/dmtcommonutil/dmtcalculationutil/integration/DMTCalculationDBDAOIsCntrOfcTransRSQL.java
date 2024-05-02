/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationDBDAOIsCntrOfcTransRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOIsCntrOfcTransRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IsCntrOfcTrans
	  * </pre>
	  */
	public DMTCalculationDBDAOIsCntrOfcTransRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtt_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOIsCntrOfcTransRSQL").append("\n"); 
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
		query.append("SELECT D.FM_OFC_CD AS DOT_FM_OFC_CD" ).append("\n"); 
		query.append("      ,D.TO_OFC_CD AS DOT_TO_OFC_CD" ).append("\n"); 
		query.append("      ,O.OFC_N2ND_LVL_CD OFC_RHQ" ).append("\n"); 
		query.append("  FROM DMT_OFC_TRNS_HIS D" ).append("\n"); 
		query.append("      ,DMT_OFC_LVL_V O" ).append("\n"); 
		query.append(" WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND CNTR_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("   AND DMDT_TRF_CD = @[dtt_code]" ).append("\n"); 
		query.append("   AND DMDT_CHG_LOC_DIV_CD = @[loc_div]" ).append("\n"); 
		query.append("   AND CHG_SEQ = @[dcc_seq]" ).append("\n"); 
		query.append("   AND TO_OFC_CD = O.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("   AND OFC_TRNS_SEQ =" ).append("\n"); 
		query.append("          (SELECT /*+ INDEX_DESC( DMT_OFC_TRNS_HIS XPKDMT_OFC_TRNS_HIS ) */" ).append("\n"); 
		query.append("                  OFC_TRNS_SEQ" ).append("\n"); 
		query.append("             FROM DMT_OFC_TRNS_HIS" ).append("\n"); 
		query.append("            WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("              AND CNTR_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("              AND DMDT_TRF_CD = @[dtt_code]" ).append("\n"); 
		query.append("              AND DMDT_CHG_LOC_DIV_CD = @[loc_div]" ).append("\n"); 
		query.append("              AND CHG_SEQ = @[dcc_seq]" ).append("\n"); 
		query.append("              AND ROWNUM = 1)" ).append("\n"); 

	}
}