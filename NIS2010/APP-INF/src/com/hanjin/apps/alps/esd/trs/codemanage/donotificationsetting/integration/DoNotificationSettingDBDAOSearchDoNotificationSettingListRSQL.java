/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DoNotificationSettingDBDAOSearchDoNotificationSettingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DoNotificationSettingDBDAOSearchDoNotificationSettingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/o Notification Setting List 조회
	  * </pre>
	  */
	public DoNotificationSettingDBDAOSearchDoNotificationSettingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.integration").append("\n"); 
		query.append("FileName : DoNotificationSettingDBDAOSearchDoNotificationSettingListRSQL").append("\n"); 
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
		query.append("SELECT A.NTFC_ACT_FLG" ).append("\n"); 
		query.append("	  ,A.BKG_CTRT_DIV_CD CTRT_TP_CD" ).append("\n"); 
		query.append("	  ,A.SC_NO" ).append("\n"); 
		query.append("	  ,A.CTRT_CUST_CNT_CD || A.CTRT_CUST_SEQ CTRT_CUST_CD" ).append("\n"); 
		query.append("      ,(SELECT X.CUST_LGL_ENG_NM FROM MDM_CUSTOMER X WHERE X.CUST_CNT_CD = A.CTRT_CUST_CNT_CD AND X.CUST_SEQ = A.CTRT_CUST_SEQ) CTRT_CUST_NM" ).append("\n"); 
		query.append("	  ,TO_CHAR(A.CTRT_EFF_DT,'YYYYMMDD') CTRT_EFF_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(A.CTRT_EXP_DT,'YYYYMMDD') CTRT_EXP_DT" ).append("\n"); 
		query.append("	  ,SUBSTR(A.DEST_NOD_CD,1,5) DEST_NOD_CD" ).append("\n"); 
		query.append("	  ,SUBSTR(A.DEST_NOD_CD,6) DEST_NOD_YD" ).append("\n"); 
		query.append("	  ,( SELECT ZN_NM FROM MDM_ZONE WHERE ZN_CD  = A.DEST_NOD_CD AND DELT_FLG   = 'N' UNION SELECT YD_NM  FROM MDM_YARD WHERE YD_CD = A.DEST_NOD_CD AND DELT_FLG   = 'N' ) DEST_NOD_NM" ).append("\n"); 
		query.append("	  ,TO_CHAR(A.UPD_DT,'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("	  ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) UPD_USR_NM" ).append("\n"); 
		query.append("	  ,A.DO_NTFC_SET_SEQ" ).append("\n"); 
		query.append("	  ,A.CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("      ,A.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("	  ,A.UPD_USR_ID" ).append("\n"); 
		query.append("  FROM TRS_DO_NTFC_SET A" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${ctrt_tp_cd}!='')" ).append("\n"); 
		query.append("   AND A.BKG_CTRT_DIV_CD = @[ctrt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sc_no}!='')" ).append("\n"); 
		query.append("   AND A.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${eff_dt}!='')" ).append("\n"); 
		query.append("   AND TO_DATE(@[eff_dt],'YYYYMMDD') BETWEEN A.CTRT_EFF_DT AND A.CTRT_EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${dor_nod_cd}!='' && ${dor_nod_yd}=='')" ).append("\n"); 
		query.append("   AND A.DEST_NOD_CD LIKE @[dor_nod_cd]||'%'" ).append("\n"); 
		query.append("#elseif(${dor_nod_cd}!='' && ${dor_nod_yd} !='')" ).append("\n"); 
		query.append("   AND A.DEST_NOD_CD = @[dor_nod_cd]||@[dor_nod_yd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${act_flg}!='')" ).append("\n"); 
		query.append("   AND A.NTFC_ACT_FLG = @[act_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}