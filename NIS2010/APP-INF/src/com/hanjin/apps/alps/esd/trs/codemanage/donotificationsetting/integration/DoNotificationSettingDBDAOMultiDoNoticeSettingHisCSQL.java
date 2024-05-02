/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DoNotificationSettingDBDAOMultiDoNoticeSettingHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
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

public class DoNotificationSettingDBDAOMultiDoNoticeSettingHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/O Notification Setting History 저장
	  * </pre>
	  */
	public DoNotificationSettingDBDAOMultiDoNoticeSettingHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_ntfc_set_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.integration").append("\n"); 
		query.append("FileName : DoNotificationSettingDBDAOMultiDoNoticeSettingHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_DO_NTFC_SET_HIS(" ).append("\n"); 
		query.append("			BKG_CTRT_DIV_CD" ).append("\n"); 
		query.append("           ,DO_NTFC_SET_SEQ " ).append("\n"); 
		query.append("           ,DO_NTFC_SET_HIS_SEQ " ).append("\n"); 
		query.append("           ,SC_NO            " ).append("\n"); 
		query.append("           ,CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("           ,CTRT_CUST_SEQ    " ).append("\n"); 
		query.append("           ,DEST_NOD_CD      " ).append("\n"); 
		query.append("           ,NTFC_ACT_FLG     " ).append("\n"); 
		query.append("           ,CTRT_EFF_DT      " ).append("\n"); 
		query.append("           ,CTRT_EXP_DT      " ).append("\n"); 
		query.append("           ,LOCL_CRE_DT      " ).append("\n"); 
		query.append("           ,LOCL_UPD_DT      " ).append("\n"); 
		query.append("           ,CRE_OFC_CD       " ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("	       ,DELT_FLG" ).append("\n"); 
		query.append("           ,CRE_DT           " ).append("\n"); 
		query.append("           ,UPD_USR_ID       " ).append("\n"); 
		query.append("           ,UPD_DT " ).append("\n"); 
		query.append("   	)VALUES(" ).append("\n"); 
		query.append("			@[ctrt_tp_cd]" ).append("\n"); 
		query.append("           ,@[do_ntfc_set_seq]" ).append("\n"); 
		query.append("		   ,(SELECT CASE WHEN COUNT(*) = 0 THEN '001'" ).append("\n"); 
		query.append("            			 ELSE LPAD(MAX(DO_NTFC_SET_HIS_SEQ) +1,3,'0')" ).append("\n"); 
		query.append("				     END" ).append("\n"); 
		query.append("		   	  FROM TRS_DO_NTFC_SET_HIS" ).append("\n"); 
		query.append("			  WHERE DO_NTFC_SET_SEQ = @[do_ntfc_set_seq])" ).append("\n"); 
		query.append("		   ,@[sc_no]" ).append("\n"); 
		query.append("    	   ,SUBSTR(@[ctrt_cust_cd],1,2)" ).append("\n"); 
		query.append("	       ,SUBSTR(@[ctrt_cust_cd],3)" ).append("\n"); 
		query.append("		   ,@[dest_nod_cd]||@[dest_nod_yd]" ).append("\n"); 
		query.append(" 	       ,@[act_flg]" ).append("\n"); 
		query.append("	       ,TO_DATE(@[ctrt_eff_dt], 'YYYYMMDD')            " ).append("\n"); 
		query.append("		   ,TO_DATE(@[ctrt_exp_dt], 'YYYYMMDD')            " ).append("\n"); 
		query.append("	       ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("	       ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) " ).append("\n"); 
		query.append("	       ,@[ofc_cd]      " ).append("\n"); 
		query.append("		   ,@[usr_id]       " ).append("\n"); 
		query.append("           ,NVL(@[delt_flg],'N')" ).append("\n"); 
		query.append("		   ,SYSDATE" ).append("\n"); 
		query.append("	       ,@[usr_id]       " ).append("\n"); 
		query.append("	       ,SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}