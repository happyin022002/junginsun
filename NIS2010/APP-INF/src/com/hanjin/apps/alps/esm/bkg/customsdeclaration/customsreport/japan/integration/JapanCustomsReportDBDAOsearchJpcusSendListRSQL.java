/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JapanCustomsReportDBDAOsearchJpcusSendListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsReportDBDAOsearchJpcusSendListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchJpcusSendList
	  * </pre>
	  */
	public JapanCustomsReportDBDAOsearchJpcusSendListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_snd_log_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsReportDBDAOsearchJpcusSendListRSQL").append("\n"); 
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
		query.append("SELECT JP_SND_LOG_ID," ).append("\n"); 
		query.append("SND_DT," ).append("\n"); 
		query.append("SND_DT2," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("VVD_CD," ).append("\n"); 
		query.append("POD_CD," ).append("\n"); 
		query.append("LOG_FLG," ).append("\n"); 
		query.append("LOG_DT," ).append("\n"); 
		query.append("LOG_DT2," ).append("\n"); 
		query.append("LOG_SEQ," ).append("\n"); 
		query.append("BL_NO," ).append("\n"); 
		query.append("ROW_NUMBER() OVER(ORDER BY SND_DT) AS RN," ).append("\n"); 
		query.append("COUNT(*) OVER() AS TOTAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("JP_SND_LOG_ID," ).append("\n"); 
		query.append("TO_CHAR(SND_DT,'YYYY-MM-DD') SND_DT," ).append("\n"); 
		query.append("TO_CHAR(SND_DT,'HH24:MI:SS') SND_DT2," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("NVL(VSL_CD,' ')||NVL(SKD_VOY_NO,' ')||NVL(SKD_DIR_CD,' ') VVD_CD," ).append("\n"); 
		query.append("POD_CD," ).append("\n"); 
		query.append("DECODE(LOG_FLG,'Y','NACCS','') LOG_FLG," ).append("\n"); 
		query.append("TO_CHAR(LOG_DT,'YYYY-MM-DD') LOG_DT," ).append("\n"); 
		query.append("TO_CHAR(LOG_DT,'HH24:MI') LOG_DT2," ).append("\n"); 
		query.append("LOG_SEQ," ).append("\n"); 
		query.append("NVL(BL_NO,' ') BL_NO" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_JP_SND_LOG" ).append("\n"); 
		query.append("WHERE JP_SND_LOG_ID LIKE @[jp_snd_log_id]||'%'" ).append("\n"); 
		query.append("AND NVL(VSL_CD,'%') LIKE NVL(SUBSTR(@[vvd_cd],1,4),'%')" ).append("\n"); 
		query.append("AND NVL(SKD_VOY_NO,'%') LIKE NVL(SUBSTR(@[vvd_cd],5,4),'%')" ).append("\n"); 
		query.append("AND NVL(SKD_DIR_CD,'%') LIKE NVL(SUBSTR(@[vvd_cd],9,1),'%')" ).append("\n"); 
		query.append("AND NVL(OFC_CD,'%') LIKE @[ofc_cd]||'%'" ).append("\n"); 
		query.append("AND NVL(UPD_USR_ID,'%') LIKE @[usr_id]||'%'" ).append("\n"); 
		query.append("AND NVL(SND_FLG,' ') <> 'N'" ).append("\n"); 
		query.append("#if (${date_check}!= '')" ).append("\n"); 
		query.append("AND SND_DT BETWEEN TO_DATE(@[start_snd_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("AND TO_DATE(@[end_snd_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DOR.FLT_FILE_REF_NO," ).append("\n"); 
		query.append("TO_CHAR(DOR.EDI_EVNT_DT,'YYYY-MM-DD') SND_DT," ).append("\n"); 
		query.append("TO_CHAR(DOR.EDI_EVNT_DT,'HH24:MI:SS') SND_DT2," ).append("\n"); 
		query.append("DOR.EDI_EVNT_OFC_CD," ).append("\n"); 
		query.append("DOR.EDI_EVNT_USR_ID,		--DOR.UPD_USR_ID," ).append("\n"); 
		query.append("' ' VVD_CD," ).append("\n"); 
		query.append("' ' POD_CD," ).append("\n"); 
		query.append("' ' LOG_FLG," ).append("\n"); 
		query.append("' ' LOG_DT," ).append("\n"); 
		query.append("' ' LOG_DT2," ).append("\n"); 
		query.append("DOR.EDI_SND_SEQ LOG_SEQ," ).append("\n"); 
		query.append("NVL(BKG.BL_NO,' ') BL_NO" ).append("\n"); 
		query.append("FROM  BKG_IB_EDI_SND_LOG DOR, BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE  (@[jp_snd_log_id] is null OR @[jp_snd_log_id] = 'DOR')" ).append("\n"); 
		query.append("AND DOR.FLT_FILE_REF_NO LIKE 'DOR'" ).append("\n"); 
		query.append("AND NVL(DOR.EDI_EVNT_OFC_CD,'%') LIKE @[ofc_cd]||'%'" ).append("\n"); 
		query.append("AND NVL(DOR.EDI_EVNT_USR_ID,'%') LIKE @[usr_id]||'%'" ).append("\n"); 
		query.append("AND DOR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("#if (${date_check}!= '')" ).append("\n"); 
		query.append("AND DOR.EDI_EVNT_DT BETWEEN TO_DATE(@[start_snd_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("AND TO_DATE(@[end_snd_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND BKG.BKG_NO IN ( SELECT DISTINCT BKG_NO" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1) )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RN BETWEEN @[startno] AND @[endno]" ).append("\n"); 

	}
}