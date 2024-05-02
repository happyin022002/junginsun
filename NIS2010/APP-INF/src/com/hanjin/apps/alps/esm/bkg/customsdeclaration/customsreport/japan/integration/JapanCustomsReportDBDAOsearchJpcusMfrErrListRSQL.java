/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanCustomsReportDBDAOsearchJpcusMfrErrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.08.20 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsReportDBDAOsearchJpcusMfrErrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchJpcusMfrErrList
	  * </pre>
	  */
	public JapanCustomsReportDBDAOsearchJpcusMfrErrListRSQL(){
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
		query.append("FileName : JapanCustomsReportDBDAOsearchJpcusMfrErrListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("JP_MSG_TP_ID JP_MSG_TP_CD," ).append("\n"); 
		query.append("TO_CHAR(RCV_DT,'YYYY-MM-DD') RCV_DT," ).append("\n"); 
		query.append("TO_CHAR(RCV_DT,'HH24:MI:SS') RCV_DT2," ).append("\n"); 
		query.append("TO_CHAR(RCV_SEQ,'FM999') RCV_SEQ," ).append("\n"); 
		query.append("NVL(JP_SVC_ID,' ') JP_SVC_CD," ).append("\n"); 
		query.append("NVL(RCV_KEY_DAT_CTNT,' ') RCV_KEY_DAT_CTNT," ).append("\n"); 
		query.append("NVL(TO_CHAR(JP_BAT_NO,'FM9999999999'),0) JP_BAT_NO," ).append("\n"); 
		query.append("NVL(UPD_USR_ID,' ') UPD_USR_ID," ).append("\n"); 
		query.append("NVL(VSL_CD,' ') VSL_CD," ).append("\n"); 
		query.append("NVL(SKD_VOY_NO,' ') SKD_VOY_NO," ).append("\n"); 
		query.append("NVL(SKD_DIR_CD,' ') SKD_DIR_CD," ).append("\n"); 
		query.append("NVL(POD_CD,' ') POD_CD," ).append("\n"); 
		query.append("ROWNUM RN," ).append("\n"); 
		query.append("COUNT(*) OVER() AS TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CSTMS_JP_RCV_LOG" ).append("\n"); 
		query.append("WHERE JP_MSG_TP_ID LIKE @[jp_msg_tp_cd]||'%'" ).append("\n"); 
		query.append("#if (${date_check}!= '')" ).append("\n"); 
		query.append("AND RCV_DT BETWEEN TO_DATE(@[start_rcv_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("AND TO_DATE(@[end_rcv_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(VSL_CD,'%') LIKE NVL(SUBSTR(@[in_vvd_cd],1,4),'%')" ).append("\n"); 
		query.append("AND NVL(SKD_VOY_NO,'%') LIKE NVL(SUBSTR(@[in_vvd_cd],5,4),'%')" ).append("\n"); 
		query.append("AND NVL(SKD_DIR_CD,'%') LIKE NVL(SUBSTR(@[in_vvd_cd],9,1),'%')" ).append("\n"); 
		query.append("AND NVL(POD_CD,'%') LIKE NVL(@[in_pod_cd],'%')" ).append("\n"); 
		query.append("AND NVL(UPD_USR_ID, '%') LIKE NVL(@[usr_id],'%')" ).append("\n"); 
		query.append("AND ( SUBSTR(RCV_KEY_DAT_CTNT,1,5) != '00000'" ).append("\n"); 
		query.append("OR SUBSTR(RCV_KEY_DAT_CTNT,7,4) != '0000'" ).append("\n"); 
		query.append("OR SUBSTR(RCV_KEY_DAT_CTNT,12,4) != '0000')" ).append("\n"); 
		query.append("ORDER BY JP_SVC_ID,RCV_DT,RCV_DT2" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RN BETWEEN @[startno] AND @[endno]" ).append("\n"); 

	}
}