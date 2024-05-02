/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchInactHisListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchInactHisListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchInactHisListRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchInactHisListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchInactHisListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(CHG_DELT_STS_CD,'A','Approval','J','Reject','R','Request','C','Cancel','') INACT_STS_DESC" ).append("\n"); 
		query.append("     , TO_CHAR(CRE_DT,'YYYY-MM-DD') INACT_DT" ).append("\n"); 
		query.append("     , CRE_OFC_CD INACT_OFC_CD" ).append("\n"); 
		query.append("     , ( SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID ) INACT_USR_NM" ).append("\n"); 
		query.append("     , INACT_RMK" ).append("\n"); 
		query.append("     , DELT_CNG_HIS_SEQ+1 AS SEQ" ).append("\n"); 
		query.append("  FROM DMT_CHG_DELT_CNG_HIS A" ).append("\n"); 
		query.append(" WHERE A.SYS_AREA_GRP_ID       = @[svr_id]" ).append("\n"); 
		query.append("   AND A.CNTR_NO               = @[cntr_no]" ).append("\n"); 
		query.append("   AND A.CNTR_CYC_NO           = to_number(@[cntr_cyc_no])" ).append("\n"); 
		query.append("   AND A.DMDT_TRF_CD           = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("   AND A.DMDT_CHG_LOC_DIV_CD   = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("   AND A.CHG_SEQ               = to_number(@[chg_seq])" ).append("\n"); 
		query.append("   AND A.CHG_OFC_CD            = NVL(@[chg_ofc_cd],A.CHG_OFC_CD)" ).append("\n"); 
		query.append("   AND A.DELT_SEQ              = NVL(to_number(@[delt_seq]),A.DELT_SEQ)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'Request' INACT_STS_DESC" ).append("\n"); 
		query.append(", TO_CHAR(RQST_DT,'YYYY-MM-DD') INACT_DT" ).append("\n"); 
		query.append(", RQST_OFC_CD INACT_OFC_CD" ).append("\n"); 
		query.append(", ( SELECT USR_NM FROM COM_USER WHERE USR_ID = A.RQST_USR_ID ) INACT_USR_NM" ).append("\n"); 
		query.append(", DELT_RMK INACT_RMK" ).append("\n"); 
		query.append(", 1 AS SEQ" ).append("\n"); 
		query.append("FROM DMT_CHG_DELT_RQST_APRO A" ).append("\n"); 
		query.append(" WHERE A.SYS_AREA_GRP_ID       = @[svr_id]" ).append("\n"); 
		query.append("   AND A.CNTR_NO               = @[cntr_no] " ).append("\n"); 
		query.append("   AND A.CNTR_CYC_NO           = to_number(@[cntr_cyc_no])" ).append("\n"); 
		query.append("   AND A.DMDT_TRF_CD           = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("   AND A.DMDT_CHG_LOC_DIV_CD   = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("   AND A.CHG_SEQ               = to_number(@[chg_seq])" ).append("\n"); 
		query.append("   AND A.CHG_OFC_CD            = NVL(@[chg_ofc_cd],A.CHG_OFC_CD)" ).append("\n"); 
		query.append("   AND A.DELT_SEQ              = NVL(to_number(@[delt_seq]),A.DELT_SEQ)" ).append("\n"); 
		query.append("   AND A.INACT_RQST_NO         IS NULL" ).append("\n"); 
		query.append("ORDER BY SEQ DESC" ).append("\n"); 

	}
}