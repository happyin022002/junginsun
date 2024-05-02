/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOsearchDwellNofifySendStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOsearchDwellNofifySendStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDwellNofifySendSts
	  * </pre>
	  */
	public DwellNotificationDBDAOsearchDwellNofifySendStsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOsearchDwellNofifySendStsRSQL").append("\n"); 
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
		query.append("SELECT R.DWLL_CUST_CNT_CD||LPAD(R.DWLL_CUST_SEQ,6,0) AS CUST_CD" ).append("\n"); 
		query.append(", SUM(DECODE(R.DWLL_TM_TP_CD, 'T96', 1)) T96_CNT" ).append("\n"); 
		query.append(", SUM(DECODE(R.DWLL_TM_TP_CD, 'E48', 1)) E48_CNT" ).append("\n"); 
		query.append(", SUM(DECODE(R.DWLL_TM_TP_CD, 'D72', 1)) D72_CNT" ).append("\n"); 
		query.append(", SUM(DECODE(R.DWLL_TM_TP_CD, 'V24', 1)) V24_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT EML_SND_DT, DWLL_TM_TP_CD, CNTR_NO, BKG_NO, DWLL_CUST_CNT_CD, DWLL_CUST_SEQ" ).append("\n"); 
		query.append("FROM SCE_DWLL_NTFC_EML_SND_RSLT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND EML_SND_DT BETWEEN TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC', TO_DATE(@[start_dt] ||'0300', 'YYYYMMDDHH24MI'), 'KRPUS'), 'YYYYMMDD') " ).append("\n"); 
		query.append("						AND TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC', TO_DATE(@[end_dt]   ||'0300', 'YYYYMMDDHH24MI'), 'KRPUS'), 'YYYYMMDD')" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("AND DWLL_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("AND DWLL_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY EML_SND_DT, DWLL_TM_TP_CD, CNTR_NO, BKG_NO, DWLL_CUST_CNT_CD, DWLL_CUST_SEQ) R" ).append("\n"); 
		query.append("GROUP BY DWLL_CUST_CNT_CD, DWLL_CUST_SEQ" ).append("\n"); 
		query.append("ORDER BY DWLL_CUST_CNT_CD, DWLL_CUST_SEQ" ).append("\n"); 

	}
}