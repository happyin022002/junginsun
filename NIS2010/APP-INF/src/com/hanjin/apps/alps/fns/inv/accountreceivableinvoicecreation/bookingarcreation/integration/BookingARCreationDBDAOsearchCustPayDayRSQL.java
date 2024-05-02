/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchCustPayDayRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
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

public class BookingARCreationDBDAOsearchCustPayDayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCustPayDay
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchCustPayDayRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchCustPayDayRSQL").append("\n"); 
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
		query.append("SELECT MAX(DECODE(ROW_NO, 1, PAY_DT_DY)) COL_PAY_1 " ).append("\n"); 
		query.append("       ,MAX(DECODE(ROW_NO, 2, PAY_DT_DY)) COL_PAY_2 " ).append("\n"); 
		query.append("       ,MAX(DECODE(ROW_NO, 3, PAY_DT_DY)) COL_PAY_3 " ).append("\n"); 
		query.append("       ,MAX(DECODE(ROW_NO, 4, PAY_DT_DY)) COL_PAY_4 " ).append("\n"); 
		query.append("       ,MAX(DECODE(ROW_NO, 5, PAY_DT_DY)) COL_PAY_5 " ).append("\n"); 
		query.append("	  -- ,MAX(DECODE(PAY_WK_DY_CD,'SUN','일','MON','월', 'TUE','화', 'WEN','수', 'THU','목', 'FRI','금', 'SAU','토' )) PAY_WK_DY_CD" ).append("\n"); 
		query.append("       ,MAX(DECODE(PAY_WK_DY_CD,'SUN','1','MON','2', 'TUE','3', 'WEN','4', 'THU','5', 'FRI','6', 'SAU','7' )) PAY_WK_DY_CD" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT ROWNUM ROW_NO,  TO_CHAR(A.TGT_DT,'DD') AS PAY_DT_DY, B.PAY_WK_DY_CD  " ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (SELECT    TRUNC(TO_DATE(@[due_dt],'YYYYMMDD'), 'MM') + LEVEL - 1  TGT_DT" ).append("\n"); 
		query.append("            , TO_CHAR(TRUNC(TO_DATE(@[due_dt],'YYYYMMDD'), 'MM') + LEVEL - 1, 'DY', 'NLS_DATE_LANGUAGE = AMERICAN') TGT_DY" ).append("\n"); 
		query.append("    FROM    DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    CONNECT BY" ).append("\n"); 
		query.append("            TRUNC(TO_DATE(@[due_dt],'YYYYMMDD'), 'MM') + LEVEL - 1 <= TRUNC(LAST_DAY(TO_DATE(@[due_dt],'YYYYMMDD'))) ) A, MDM_CR_CUST B" ).append("\n"); 
		query.append("            WHERE B.PAY_TP_CD = 'W'" ).append("\n"); 
		query.append("            AND   B.PAY_WK_DY_CD = A.TGT_DY" ).append("\n"); 
		query.append("            AND   B.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("            AND   B.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}