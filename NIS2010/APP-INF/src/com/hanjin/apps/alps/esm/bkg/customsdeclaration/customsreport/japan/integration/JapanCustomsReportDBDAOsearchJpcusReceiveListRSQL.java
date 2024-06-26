/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JapanCustomsReportDBDAOsearchJpcusReceiveListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.13
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.03.13 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsReportDBDAOsearchJpcusReceiveListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchJpcusReceiveList
	  * </pre>
	  */
	public JapanCustomsReportDBDAOsearchJpcusReceiveListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsReportDBDAOsearchJpcusReceiveListRSQL").append("\n"); 
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
		query.append("SELECT JP_MSG_TP_CD," ).append("\n"); 
		query.append("       RCV_DT," ).append("\n"); 
		query.append("       RCV_DT2," ).append("\n"); 
		query.append("       RCV_SEQ," ).append("\n"); 
		query.append("       JP_SVC_CD," ).append("\n"); 
		query.append("       RCV_KEY_DAT_CTNT," ).append("\n"); 
		query.append("       JP_BAT_NO," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       RN," ).append("\n"); 
		query.append("       TOTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("       (SELECT JP_MSG_TP_ID AS JP_MSG_TP_CD," ).append("\n"); 
		query.append("               TO_CHAR(RCV_DT, 'YYYY-MM-DD') AS RCV_DT," ).append("\n"); 
		query.append("               TO_CHAR(RCV_DT, 'HH24:MI:SS') AS RCV_DT2," ).append("\n"); 
		query.append("               TO_CHAR(RCV_SEQ,'FM999') AS RCV_SEQ," ).append("\n"); 
		query.append("               NVL(JP_SVC_ID, ' ') AS JP_SVC_CD," ).append("\n"); 
		query.append("               NVL(RCV_KEY_DAT_CTNT, ' ') AS RCV_KEY_DAT_CTNT," ).append("\n"); 
		query.append("               NVL(TO_CHAR(JP_BAT_NO,'FM9999999999'), 0) AS JP_BAT_NO," ).append("\n"); 
		query.append("               NVL(UPD_USR_ID, ' ') AS UPD_USR_ID," ).append("\n"); 
		query.append("               NVL(VSL_CD, ' ') AS VSL_CD," ).append("\n"); 
		query.append("               NVL(SKD_VOY_NO, ' ') AS SKD_VOY_NO," ).append("\n"); 
		query.append("               NVL(SKD_DIR_CD, ' ') AS SKD_DIR_CD," ).append("\n"); 
		query.append("               NVL(POD_CD, ' ') AS POD_CD," ).append("\n"); 
		query.append("               ROWNUM AS RN," ).append("\n"); 
		query.append("               COUNT(*) OVER() AS TOTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_JP_RCV_LOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE JP_MSG_TP_ID LIKE @[jp_msg_tp_cd]||'%'" ).append("\n"); 
		query.append("#if (${jp_msg_tp_cd} == 'BKR' ||${jp_msg_tp_cd} == 'BKC')" ).append("\n"); 
		query.append("           AND JP_SVC_ID = 'BKGACK'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jp_msg_tp_cd} == 'BKC-REPLY')" ).append("\n"); 
		query.append("           AND JP_SVC_ID = 'SAT076'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_check}!= '')" ).append("\n"); 
		query.append("           AND RCV_DT BETWEEN TO_DATE(@[start_rcv_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                  AND TO_DATE(@[end_rcv_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NVL(VSL_CD,'%') LIKE NVL(SUBSTR(@[in_vvd_cd],1,4),'%')" ).append("\n"); 
		query.append("           AND NVL(SKD_VOY_NO,'%') LIKE NVL(SUBSTR(@[in_vvd_cd],5,4),'%')" ).append("\n"); 
		query.append("           AND NVL(SKD_DIR_CD,'%') LIKE NVL(SUBSTR(@[in_vvd_cd],9,1),'%')" ).append("\n"); 
		query.append("           AND NVL(POD_CD,'%') LIKE NVL(@[in_pod_cd],'%')" ).append("\n"); 
		query.append("           AND NVL(UPD_USR_ID, '%') LIKE NVL(@[usr_id],'%')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ORDER BY JP_SVC_ID," ).append("\n"); 
		query.append("                  RCV_DT," ).append("\n"); 
		query.append("                  RCV_DT2" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE RN BETWEEN @[startno] AND @[endno]" ).append("\n"); 

	}
}