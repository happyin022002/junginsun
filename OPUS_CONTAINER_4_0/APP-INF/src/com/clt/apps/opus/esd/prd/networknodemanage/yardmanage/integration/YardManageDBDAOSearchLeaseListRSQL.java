/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : YardManageDBDAOSearchLeaseListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.07.27 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class YardManageDBDAOSearchLeaseListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLeaseList
	  * </pre>
	  */
	public YardManageDBDAOSearchLeaseListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("node_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.integration").append("\n"); 
		query.append("FileName : YardManageDBDAOSearchLeaseListRSQL").append("\n"); 
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
		query.append("SELECT A.LSE_CO_YD_CD YARD_CODE, A.LSE_CO_YD_NM YARD_NAME, A.YD_ADDR ADDRESS, A.YD_PIC_NM PIC," ).append("\n"); 
		query.append("A.INTL_PHN_NO||'-'||A.PHN_NO TEL, A.INTL_PHN_NO||'-'||A.FAX_NO FAX, A.YD_EML EMAIL," ).append("\n"); 
		query.append("V1.VNDR_CNT_CD ||TO_CHAR(A.LSE_CO_VNDR_SEQ1, '000000')  COM_CODE1,   V1.VNDR_LGL_ENG_NM COM_NAME1," ).append("\n"); 
		query.append("V2.VNDR_CNT_CD ||TO_CHAR(A.LSE_CO_VNDR_SEQ2, '000000')  COM_CODE2,   V2.VNDR_LGL_ENG_NM COM_NAME2," ).append("\n"); 
		query.append("V3.VNDR_CNT_CD ||TO_CHAR(A.LSE_CO_VNDR_SEQ3, '000000')  COM_CODE3,   V3.VNDR_LGL_ENG_NM COM_NAME3," ).append("\n"); 
		query.append("V4.VNDR_CNT_CD ||TO_CHAR(A.LSE_CO_VNDR_SEQ4, '000000')  COM_CODE4,   V4.VNDR_LGL_ENG_NM COM_NAME4," ).append("\n"); 
		query.append("V5.VNDR_CNT_CD ||TO_CHAR(A.LSE_CO_VNDR_SEQ5, '000000')  COM_CODE5,   V5.VNDR_LGL_ENG_NM COM_NAME5," ).append("\n"); 
		query.append("V6.VNDR_CNT_CD ||TO_CHAR(A.LSE_CO_VNDR_SEQ6, '000000')  COM_CODE6,   V6.VNDR_LGL_ENG_NM COM_NAME6," ).append("\n"); 
		query.append("V7.VNDR_CNT_CD ||TO_CHAR(A.LSE_CO_VNDR_SEQ7, '000000')  COM_CODE7,   V7.VNDR_LGL_ENG_NM COM_NAME7," ).append("\n"); 
		query.append("V8.VNDR_CNT_CD ||TO_CHAR(A.LSE_CO_VNDR_SEQ8, '000000')  COM_CODE8,   V8.VNDR_LGL_ENG_NM COM_NAME8," ).append("\n"); 
		query.append("V9.VNDR_CNT_CD ||TO_CHAR(A.LSE_CO_VNDR_SEQ9, '000000')  COM_CODE9,   V9.VNDR_LGL_ENG_NM COM_NAME9," ).append("\n"); 
		query.append("V10.VNDR_CNT_CD||TO_CHAR(A.LSE_CO_VNDR_SEQ10, '000000') COM_CODE10, V10.VNDR_LGL_ENG_NM COM_NAME10" ).append("\n"); 
		query.append("FROM MDM_LSE_CO_YD A, MDM_VENDOR V1, MDM_VENDOR V2, MDM_VENDOR V3, MDM_VENDOR V4, MDM_VENDOR V5," ).append("\n"); 
		query.append("MDM_VENDOR V6, MDM_VENDOR V7, MDM_VENDOR V8, MDM_VENDOR V9, MDM_VENDOR V10" ).append("\n"); 
		query.append("WHERE A.LSE_CO_YD_CD LIKE @[country_code] ||'%' -- country_code" ).append("\n"); 
		query.append("AND   A.LSE_CO_YD_CD LIKE @[location_code] ||'%'-- location_code" ).append("\n"); 
		query.append("AND   A.LSE_CO_YD_CD LIKE @[node_code] ||'%' -- node_code" ).append("\n"); 
		query.append("AND   NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND   A.LSE_CO_VNDR_SEQ1  = V1.VNDR_SEQ  (+)" ).append("\n"); 
		query.append("AND   A.LSE_CO_VNDR_SEQ2  = V2.VNDR_SEQ  (+)" ).append("\n"); 
		query.append("AND   A.LSE_CO_VNDR_SEQ3  = V3.VNDR_SEQ  (+)" ).append("\n"); 
		query.append("AND   A.LSE_CO_VNDR_SEQ4  = V4.VNDR_SEQ  (+)" ).append("\n"); 
		query.append("AND   A.LSE_CO_VNDR_SEQ5  = V5.VNDR_SEQ  (+)" ).append("\n"); 
		query.append("AND   A.LSE_CO_VNDR_SEQ6  = V6.VNDR_SEQ  (+)" ).append("\n"); 
		query.append("AND   A.LSE_CO_VNDR_SEQ7  = V7.VNDR_SEQ  (+)" ).append("\n"); 
		query.append("AND   A.LSE_CO_VNDR_SEQ8  = V8.VNDR_SEQ  (+)" ).append("\n"); 
		query.append("AND   A.LSE_CO_VNDR_SEQ9  = V9.VNDR_SEQ  (+)" ).append("\n"); 
		query.append("AND   A.LSE_CO_VNDR_SEQ10 = V10.VNDR_SEQ (+)" ).append("\n"); 
		query.append("AND   NVL(V1.DELT_FLG(+),  'N') = 'N'" ).append("\n"); 
		query.append("AND   NVL(V2.DELT_FLG(+),  'N') = 'N'" ).append("\n"); 
		query.append("AND   NVL(V3.DELT_FLG(+),  'N') = 'N'" ).append("\n"); 
		query.append("AND   NVL(V4.DELT_FLG(+),  'N') = 'N'" ).append("\n"); 
		query.append("AND   NVL(V5.DELT_FLG(+),  'N') = 'N'" ).append("\n"); 
		query.append("AND   NVL(V6.DELT_FLG(+),  'N') = 'N'" ).append("\n"); 
		query.append("AND   NVL(V7.DELT_FLG(+),  'N') = 'N'" ).append("\n"); 
		query.append("AND   NVL(V8.DELT_FLG(+),  'N') = 'N'" ).append("\n"); 
		query.append("AND   NVL(V9.DELT_FLG(+),  'N') = 'N'" ).append("\n"); 
		query.append("AND   NVL(V10.DELT_FLG(+), 'N') = 'N'" ).append("\n"); 

	}
}