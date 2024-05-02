/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOSearchFocByFreightListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.05.04 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchFocByFreightListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOSearchFocByFreightList
	  * </pre>
	  */
	public BlRatingDBDAOSearchFocByFreightListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchFocByFreightListRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("WITH  MAIN_TEMP  AS" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'c_' AS MM,'BKG1' AS BB ,NVL(CHG_AMT,0) AS CHG_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN(BKG_NO) BKG_NO," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (CURR_CD, '|')), 2)   AS CURR_CD," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (CHG_AMT, '|')), 2)   AS CHG_AMT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROWNUM AS RID, T.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MIN(BKG_NO) AS BKG_NO ,CURR_CD ,SUM(CHG_AMT) AS CHG_AMT,DECODE(CURR_CD,'USD',0,1) SORT" ).append("\n"); 
		query.append("FROM BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] AND FRT_TERM_CD = 'C' AND N3PTY_RCV_OFC_CD IS NULL" ).append("\n"); 
		query.append("AND FRT_INCL_XCLD_DIV_CD='N'" ).append("\n"); 
		query.append("AND CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("GROUP BY CURR_CD ORDER BY SORT" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH  RID =  1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RID + 1 = RID" ).append("\n"); 
		query.append(") MA," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO ,CLT_OFC_CD AS OFC_CD ,CLT_PAYR_CNT_CD AS CNT_CD ,CLT_PAYR_CUST_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_RT_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append(") SA" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("MA.BKG_NO(+) = SA.BKG_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'cct_' AS MM,'BKG1' AS BB, NVL(CHG_AMT,0) AS CHG_AMT " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN(BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (CURR_CD, '|')), 2)   AS CURR_CD," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (CHG_AMT, '|')), 2)   AS CHG_AMT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROWNUM AS RID, T.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MIN(BKG_NO) AS BKG_NO ,CURR_CD ,SUM(CHG_AMT) CHG_AMT ,DECODE(CURR_CD,'USD',0,1) SORT" ).append("\n"); 
		query.append("FROM BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO=@[bkg_no] AND FRT_TERM_CD = 'C' AND N3PTY_RCV_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND FRT_INCL_XCLD_DIV_CD='N'" ).append("\n"); 
		query.append("AND CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("GROUP BY CURR_CD ORDER BY SORT" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH  RID =  1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RID + 1 = RID" ).append("\n"); 
		query.append(") MA," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN(BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (N3PTY_RCV_OFC_CD, '|')), 2)   AS OFC_CD," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (N3PTY_CUST_CNT_CD, '|')), 2)   AS CNT_CD," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (N3PTY_CUST_SEQ, '|')), 2)   AS CUST_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  ROWNUM AS RID, T.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MIN(BKG_NO) AS BKG_NO, N3PTY_RCV_OFC_CD,N3PTY_CUST_CNT_CD,N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO=@[bkg_no] AND FRT_TERM_CD = 'C' AND N3PTY_RCV_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND FRT_INCL_XCLD_DIV_CD='N'" ).append("\n"); 
		query.append("AND CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("group by" ).append("\n"); 
		query.append("N3PTY_RCV_OFC_CD,N3PTY_CUST_CNT_CD,N3PTY_CUST_SEQ" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH  RID =  1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RID + 1 = RID" ).append("\n"); 
		query.append(") SA" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("MA.BKG_NO(+) = SA.BKG_NO" ).append("\n"); 
		query.append("  ) " ).append("\n"); 
		query.append("SELECT  b.*,C.*" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM    MAIN_TEMP  A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT  MM AS COL,CHG_AMT AS COL_AMT,BB from  MAIN_TEMP g where mm= 'c_'" ).append("\n"); 
		query.append("       )  B," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT  MM AS CCT ,CHG_AMT AS CCT_AMT ,BB  from  MAIN_TEMP g where mm= 'cct_'" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("       )  C" ).append("\n"); 
		query.append("where a.bb = b.bb(+)" ).append("\n"); 
		query.append("and   a.bb = c.bb(+)" ).append("\n"); 
		query.append("and rownum =1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WITH  MAIN_TEMP  AS" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'c_' AS MM,'BKG1' AS BB ,NVL(CHG_AMT,0) AS CHG_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN(BKG_NO) BKG_NO," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (CURR_CD, '|')), 2)   AS CURR_CD," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (CHG_AMT, '|')), 2)   AS CHG_AMT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROWNUM AS RID, T.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MIN(BKG_NO) AS BKG_NO ,CURR_CD ,SUM(CHG_AMT) AS CHG_AMT,DECODE(CURR_CD,'USD',0,1) SORT" ).append("\n"); 
		query.append("FROM BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] AND FRT_TERM_CD = 'C' AND N3PTY_RCV_OFC_CD IS NULL" ).append("\n"); 
		query.append("AND FRT_INCL_XCLD_DIV_CD='N'" ).append("\n"); 
		query.append("GROUP BY CURR_CD ORDER BY SORT" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH  RID =  1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RID + 1 = RID" ).append("\n"); 
		query.append(") MA," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO ,CLT_OFC_CD AS OFC_CD ,CLT_PAYR_CNT_CD AS CNT_CD ,CLT_PAYR_CUST_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_RATE" ).append("\n"); 
		query.append("WHERE BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append(") SA" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("MA.BKG_NO(+) = SA.BKG_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'cct_' AS MM,'BKG1' AS BB, NVL(CHG_AMT,0) AS CHG_AMT " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN(BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (CURR_CD, '|')), 2)   AS CURR_CD," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (CHG_AMT, '|')), 2)   AS CHG_AMT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROWNUM AS RID, T.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MIN(BKG_NO) AS BKG_NO ,CURR_CD ,SUM(CHG_AMT) CHG_AMT ,DECODE(CURR_CD,'USD',0,1) SORT" ).append("\n"); 
		query.append("FROM BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE BKG_NO=@[bkg_no] AND FRT_TERM_CD = 'C' AND N3PTY_RCV_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND FRT_INCL_XCLD_DIV_CD='N'" ).append("\n"); 
		query.append("GROUP BY CURR_CD ORDER BY SORT" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH  RID =  1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RID + 1 = RID" ).append("\n"); 
		query.append(") MA," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN(BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (N3PTY_RCV_OFC_CD, '|')), 2)   AS OFC_CD," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (N3PTY_CUST_CNT_CD, '|')), 2)   AS CNT_CD," ).append("\n"); 
		query.append("SUBSTR (MAX (SYS_CONNECT_BY_PATH (N3PTY_CUST_SEQ, '|')), 2)   AS CUST_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  ROWNUM AS RID, T.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MIN(BKG_NO) AS BKG_NO, N3PTY_RCV_OFC_CD,N3PTY_CUST_CNT_CD,N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE BKG_NO=@[bkg_no] AND FRT_TERM_CD = 'C' AND N3PTY_RCV_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND FRT_INCL_XCLD_DIV_CD='N'" ).append("\n"); 
		query.append("group by" ).append("\n"); 
		query.append("N3PTY_RCV_OFC_CD,N3PTY_CUST_CNT_CD,N3PTY_CUST_SEQ" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH  RID =  1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RID + 1 = RID" ).append("\n"); 
		query.append(") SA" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("MA.BKG_NO(+) = SA.BKG_NO" ).append("\n"); 
		query.append("  ) " ).append("\n"); 
		query.append("SELECT  b.*,C.*" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM    MAIN_TEMP  A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT  MM AS COL,CHG_AMT AS COL_AMT,BB from  MAIN_TEMP g where mm= 'c_'" ).append("\n"); 
		query.append("       )  B," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT  MM AS CCT ,CHG_AMT AS CCT_AMT ,BB  from  MAIN_TEMP g where mm= 'cct_'" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("       )  C" ).append("\n"); 
		query.append("where a.bb = b.bb(+)" ).append("\n"); 
		query.append("and   a.bb = c.bb(+)" ).append("\n"); 
		query.append("and rownum =1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}