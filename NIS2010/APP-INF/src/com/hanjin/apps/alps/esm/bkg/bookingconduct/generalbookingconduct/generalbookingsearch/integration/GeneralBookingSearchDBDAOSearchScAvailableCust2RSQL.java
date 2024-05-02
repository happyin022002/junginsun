/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchScAvailableCust2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.28 
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

public class GeneralBookingSearchDBDAOSearchScAvailableCust2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchScAvailableCust2RSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchScAvailableCust2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchScAvailableCust2RSQL").append("\n"); 
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
		query.append("SELECT 'Y' RSLT" ).append("\n"); 
		query.append("FROM (  SELECT SP.CUST_CNT_CD" ).append("\n"); 
		query.append("             , SP.CUST_SEQ" ).append("\n"); 
		query.append("        FROM  PRI_SP_HDR SH, PRI_SP_MN SM, PRI_SP_CTRT_PTY SP" ).append("\n"); 
		query.append("        WHERE SH.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("        AND SH.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("        AND SM.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("        --AND SM.EFF_DT <= NVL(TO_DATE(:lodg_due_dt, 'YYYY-MM-DD'), sysdate)" ).append("\n"); 
		query.append("        --AND SM.EXP_DT >= NVL(TO_DATE(:lodg_due_dt, 'YYYY-MM-DD'), sysdate)" ).append("\n"); 
		query.append("        AND SM.PROP_NO = SP.PROP_NO" ).append("\n"); 
		query.append("        AND SM.AMDT_SEQ = SP.AMDT_SEQ" ).append("\n"); 
		query.append("        AND SP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("        AND (    (    SP.CUST_CNT_CD = NVL(@[s_cust_cnt_cd],'xx')" ).append("\n"); 
		query.append("                  AND SP.CUST_SEQ    = NVL(LTRIM(@[s_cust_seq],'0'),0))" ).append("\n"); 
		query.append("              OR (    SP.CUST_CNT_CD = NVL(@[c_cust_cnt_cd],'xx')" ).append("\n"); 
		query.append("                  AND SP.CUST_SEQ    = NVL(LTRIM(@[c_cust_seq],'0'),0))" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT SA.CUST_CNT_CD " ).append("\n"); 
		query.append("             , SA.CUST_SEQ  " ).append("\n"); 
		query.append("        FROM  PRI_SP_HDR SH, PRI_SP_MN SM, PRI_SP_AFIL SA" ).append("\n"); 
		query.append("        WHERE SH.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("        AND SH.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("        AND SM.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("        --AND SM.EFF_DT <= NVL(TO_DATE(:lodg_due_dt, 'YYYY-MM-DD'), sysdate)" ).append("\n"); 
		query.append("        --AND SM.EXP_DT >= NVL(TO_DATE(:lodg_due_dt, 'YYYY-MM-DD'), sysdate)" ).append("\n"); 
		query.append("        AND SM.PROP_NO = SA.PROP_NO" ).append("\n"); 
		query.append("        AND SM.AMDT_SEQ = SA.AMDT_SEQ" ).append("\n"); 
		query.append("        AND (    (    SA.CUST_CNT_CD = NVL(@[s_cust_cnt_cd],'xx')" ).append("\n"); 
		query.append("                  AND SA.CUST_SEQ    = NVL(LTRIM(@[s_cust_seq],'0'),0))" ).append("\n"); 
		query.append("              OR (    SA.CUST_CNT_CD = NVL(@[c_cust_cnt_cd],'xx')" ).append("\n"); 
		query.append("                  AND SA.CUST_SEQ    = NVL(LTRIM(@[c_cust_seq],'0'),0))" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}