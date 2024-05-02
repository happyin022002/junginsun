/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyInvoiceExrateMainUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifyInvoiceExrateMainUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [] BookingARCreationDBDAO::checkAccountRateExist ( effDt ) return int
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyInvoiceExrateMainUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("xch_rt_usd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_n3rd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_term_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obrd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyInvoiceExrateMainUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_MN MN" ).append("\n"); 
		query.append("   SET USD_XCH_RT = NVL(@[usd_xch_rt],0)," ).append("\n"); 
		query.append("       XCH_RT_DT = DECODE(@[xch_rt_dt],'',DECODE(BL_INV_CFM_DT, NULL, @[xch_rt_dt],XCH_RT_DT ),@[xch_rt_dt])," ).append("\n"); 
		query.append("	   XCH_RT_USD_TP_CD = @[xch_rt_usd_tp_cd]," ).append("\n"); 
		query.append("	   XCH_RT_N3RD_TP_CD = @[xch_rt_n3rd_tp_cd]," ).append("\n"); 
		query.append("	   OBRD_DT = @[obrd_dt]," ).append("\n"); 
		query.append("       INV_TTL_LOCL_AMT = (SELECT NVL(SUM(CURR_LOCL_AMT),0)" ).append("\n"); 
		query.append("                              FROM (SELECT A.CURR_CD, ROUND(SUM(CHG_AMT)*INV_XCH_RT , C.DP_PRCS_KNT ) CURR_LOCL_AMT" ).append("\n"); 
		query.append("                                      FROM INV_AR_CHG A," ).append("\n"); 
		query.append("                                           INV_AR_MN B," ).append("\n"); 
		query.append("                                           MDM_CURRENCY C" ).append("\n"); 
		query.append("                                     WHERE A.AR_IF_NO =@[ar_if_no]" ).append("\n"); 
		query.append("                                       AND A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                                       AND C.CURR_CD = B.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                     GROUP BY A.CURR_CD,A.INV_XCH_RT,C.DP_PRCS_KNT)),	" ).append("\n"); 
		query.append("	   GL_EFF_DT = NVL(GL_EFF_DT,REPLACE(@[gl_eff_dt],'-',''))," ).append("\n"); 
		query.append("	   SAIL_DT = NVL(SAIL_DT,REPLACE(@[sail_dt],'-',''))," ).append("\n"); 
		query.append("	   SAIL_ARR_DT = NVL(SAIL_ARR_DT,REPLACE(@[sail_arr_dt],'-',''))," ).append("\n"); 
		query.append("       DUE_DT = REPLACE(DECODE(@[due_dt],'',DECODE(BL_INV_CFM_DT,NULL,@[due_dt],DUE_DT ),@[due_dt]),'-','')," ).append("\n"); 
		query.append("	   CUST_CR_FLG = nvl(@[cust_cr_flg],'N')," ).append("\n"); 
		query.append("	   CR_TERM_DYS = nvl(@[cr_term_dys],0)," ).append("\n"); 
		query.append("       ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[gl_eff_dt],'-',''),1,6)," ).append("\n"); 
		query.append("#if (${rev_vvd} != '')" ).append("\n"); 
		query.append("	   REV_VSL_CD = NVL(REV_VSL_CD, SUBSTR(@[rev_vvd],1,4))," ).append("\n"); 
		query.append("	   REV_SKD_VOY_NO =  NVL(REV_SKD_VOY_NO, SUBSTR(@[rev_vvd],5,4))," ).append("\n"); 
		query.append("	   REV_SKD_DIR_CD =  NVL(REV_SKD_DIR_CD, SUBSTR(@[rev_vvd],9,1))," ).append("\n"); 
		query.append("       REV_DIR_CD =  NVL(REV_DIR_CD, SUBSTR(@[rev_vvd],10,1))," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("	   RLANE_CD = NVL(RLANE_CD, @[rlane_cd])," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("	   UPD_DT = sysdate" ).append("\n"); 
		query.append(" WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 

	}
}