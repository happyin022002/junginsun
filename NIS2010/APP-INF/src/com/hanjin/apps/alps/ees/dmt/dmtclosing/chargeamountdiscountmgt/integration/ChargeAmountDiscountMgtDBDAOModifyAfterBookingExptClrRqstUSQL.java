/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingExptClrRqstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOModifyAfterBookingExptClrRqstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOModifyAfterBookingExptClrRqst
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOModifyAfterBookingExptClrRqstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mcntr_rtn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgor_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_chg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration ").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingExptClrRqstUSQL").append("\n"); 
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
		query.append("MERGE INTO DMT_AFT_BKG_EXPT_CLR_RQST" ).append("\n"); 
		query.append("  USING DUAL" ).append("\n"); 
		query.append("  ON (      AFT_EXPT_DAR_NO          =   @[aft_expt_dar_no]" ).append("\n"); 
		query.append("     AND    BKG_NO =   @[bkg_no]" ).append("\n"); 
		query.append("     AND    CNTR_NO =   @[cntr_no]" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("      SET CGOR_DT      =   TO_DATE(@[cgor_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("        , MCNTR_RTN_DT      =   TO_DATE(@[mcntr_rtn_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("        , UPD_USR_ID    =   @[upd_usr_id]" ).append("\n"); 
		query.append("        , UPD_DT        =   sysdate" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("          , BKG_NO" ).append("\n"); 
		query.append("          , CNTR_NO" ).append("\n"); 
		query.append("          , DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("          , CGOR_DT" ).append("\n"); 
		query.append("          , MCNTR_RTN_DT" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("    		@[aft_expt_dar_no]" ).append("\n"); 
		query.append("    	   ,@[bkg_no]" ).append("\n"); 
		query.append("    	   ,@[cntr_no]" ).append("\n"); 
		query.append("    	   ,@[dmdt_chg_sts_cd]" ).append("\n"); 
		query.append("    	   ,TO_DATE(@[cgor_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("    	   ,TO_DATE(@[mcntr_rtn_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("    	   ,@[upd_usr_id]" ).append("\n"); 
		query.append("    	   ,sysdate" ).append("\n"); 
		query.append("    	   ,@[upd_usr_id]" ).append("\n"); 
		query.append("    	   ,sysdate" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}