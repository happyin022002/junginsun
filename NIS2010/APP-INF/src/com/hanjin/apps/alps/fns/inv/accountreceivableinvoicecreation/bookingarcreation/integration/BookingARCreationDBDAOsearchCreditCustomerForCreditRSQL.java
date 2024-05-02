/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchCreditCustomerForCreditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
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

public class BookingARCreationDBDAOsearchCreditCustomerForCreditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOsearchCreditCustomerForCreditRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchCreditCustomerForCreditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchCreditCustomerForCreditRSQL").append("\n"); 
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
		query.append("#if (${due_dt} != '') " ).append("\n"); 
		query.append("-- 화면에서 넘겨준 DUE DT 가 있을때" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'Y' CR_FLG," ).append("\n"); 
		query.append("       DECODE(@[io_bnd_cd], 'I'," ).append("\n"); 
		query.append("                         TO_CHAR(TO_DATE(REPLACE(@[sail_arr_dt], '-', ''), 'YYYYMMDD') + NVL(A.IB_CR_TERM_DYS, 0)," ).append("\n"); 
		query.append("                                 'YYYYMMDD')," ).append("\n"); 
		query.append("                         TO_CHAR(TO_DATE(REPLACE(@[sail_arr_dt], '-', ''), 'YYYYMMDD') + NVL(A.OB_CR_TERM_DYS, 0)," ).append("\n"); 
		query.append("                                 'YYYYMMDD')) DUE_DT," ).append("\n"); 
		query.append("       DECODE(@[io_bnd_cd], 'I', NVL(A.IB_CR_TERM_DYS, 0), NVL(A.OB_CR_TERM_DYS, 0)) CR_TERM" ).append("\n"); 
		query.append("  FROM MDM_CR_CUST A" ).append("\n"); 
		query.append(" WHERE A.CUST_CNT_CD = NVL(@[cust_cnt_cd], '')" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = CASE WHEN REGEXP_INSTR(@[cust_seq], '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("                                   TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("                              ELSE" ).append("\n"); 
		query.append("                                   -999999" ).append("\n"); 
		query.append("                              END " ).append("\n"); 
		query.append("   AND REPLACE(@[sail_arr_dt], '-', '') BETWEEN A.CR_ST_DT AND A.CR_END_DT" ).append("\n"); 
		query.append("   AND DECODE(@[io_bnd_cd], 'I', NVL(A.IB_CR_TERM_DYS, 0), NVL(A.OB_CR_TERM_DYS, 0)) > 0" ).append("\n"); 
		query.append("   AND NVL(A.DELT_FLG,'N') <>'Y'" ).append("\n"); 
		query.append("   AND NVL(A.SUB_SYS_NM,'MDM') <> 'ERP'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'Y' CR_FLG," ).append("\n"); 
		query.append("	   DECODE(@[io_bnd_cd], 'I'," ).append("\n"); 
		query.append("                         TO_CHAR(SYSDATE + NVL(A.IB_CR_TERM_DYS, 0)," ).append("\n"); 
		query.append("                                 'YYYYMMDD')," ).append("\n"); 
		query.append("                         TO_CHAR(SYSDATE + NVL(A.OB_CR_TERM_DYS, 0)," ).append("\n"); 
		query.append("                                 'YYYYMMDD')) DUE_DT," ).append("\n"); 
		query.append("       DECODE(@[io_bnd_cd], 'I'," ).append("\n"); 
		query.append("                          NVL(A.IB_CR_TERM_DYS, 0)," ).append("\n"); 
		query.append("                         NVL(A.OB_CR_TERM_DYS, 0)) CR_TERM" ).append("\n"); 
		query.append("  FROM MDM_CR_CUST A" ).append("\n"); 
		query.append(" WHERE A.CUST_CNT_CD = NVL(@[cust_cnt_cd], '')" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = CASE WHEN REGEXP_INSTR(@[cust_seq], '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("                          TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                          -999999" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("   AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN A.CR_ST_DT AND A.CR_END_DT" ).append("\n"); 
		query.append("   AND DECODE(@[io_bnd_cd], 'I', NVL(A.IB_CR_TERM_DYS, 0), NVL(A.OB_CR_TERM_DYS, 0)) > 0" ).append("\n"); 
		query.append("   AND NVL(A.DELT_FLG,'N') <>'Y'" ).append("\n"); 
		query.append("   AND NVL(A.SUB_SYS_NM,'MDM') <> 'ERP'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}