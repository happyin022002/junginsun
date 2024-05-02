/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RuLabelManagementDBDAOsearchRuLabelListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.01
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.11.01 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RuLabelManagementDBDAOsearchRuLabelListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RU Label Maintenace 조회
	  * </pre>
	  */
	public RuLabelManagementDBDAOsearchRuLabelListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ru_label_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ru_label_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOsearchRuLabelListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	RSTR_USG_CD_SEQ		rstr_usg_cd_seq" ).append("\n"); 
		query.append(",	RSTR_USG_TP_CD		rstr_usg_tp_cd" ).append("\n"); 
		query.append(",	RSTR_USG_LBL_NM		rstr_usg_lbl_nm" ).append("\n"); 
		query.append(",	RSTR_USG_LBL_DESC	rstr_usg_lbl_desc" ).append("\n"); 
		query.append(",	RSTR_USG_DP_SEQ		rstr_usg_dp_seq" ).append("\n"); 
		query.append(",	USR_DEF_RMK			usr_def_rmk" ).append("\n"); 
		query.append(",	DELT_FLG			delt_flg" ).append("\n"); 
		query.append(",	CRE_USR_ID			cre_usr_id" ).append("\n"); 
		query.append(",	CRE_DT				cre_dt" ).append("\n"); 
		query.append(",	UPD_USR_ID			upd_usr_id" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') upd_dt" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	MST_RSTR_USG_CD " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${ru_label_type} != '') " ).append("\n"); 
		query.append("	AND RSTR_USG_TP_CD = @[ru_label_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ru_label_value} != '')" ).append("\n"); 
		query.append("	AND UPPER(RSTR_USG_LBL_NM) Like '%'||UPPER(@[ru_label_value])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY RSTR_USG_TP_CD,RSTR_USG_DP_SEQ" ).append("\n"); 

	}
}