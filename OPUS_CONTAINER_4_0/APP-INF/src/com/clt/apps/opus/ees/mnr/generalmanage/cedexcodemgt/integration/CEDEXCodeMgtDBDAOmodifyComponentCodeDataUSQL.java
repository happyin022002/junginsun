/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CEDEXCodeMgtDBDAOmodifyComponentCodeDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.29
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.07.29 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CEDEXCodeMgtDBDAOmodifyComponentCodeDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정
	  * </pre>
	  */
	public CEDEXCodeMgtDBDAOmodifyComponentCodeDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_num_iso_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_prnt_cmpo_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_prnt_cmpo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_cmpo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cmpo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_cmpo_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration").append("\n"); 
		query.append("FileName : CEDEXCodeMgtDBDAOmodifyComponentCodeDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_EQ_CMPO_CD SET" ).append("\n"); 
		query.append("EQ_PRNT_CMPO_GRP_TP_CD = @[eq_prnt_cmpo_grp_tp_cd]," ).append("\n"); 
		query.append("EQ_KND_CD = @[eq_knd_cd]," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE," ).append("\n"); 
		query.append("EQ_CMPO_NUM_ISO_CD = @[eq_cmpo_num_iso_cd]," ).append("\n"); 
		query.append("EQ_CMPO_CD = @[eq_cmpo_cd]," ).append("\n"); 
		query.append("EQ_CMPO_GRP_TP_CD = @[eq_cmpo_grp_tp_cd]," ).append("\n"); 
		query.append("EQ_CMPO_NM = @[eq_cmpo_nm]," ).append("\n"); 
		query.append("EQ_CMPO_DESC = @[eq_cmpo_desc]," ).append("\n"); 
		query.append("EQ_PRNT_CMPO_CD = @[eq_prnt_cmpo_cd]," ).append("\n"); 
		query.append("CNTR_CMPO_FLG = DECODE(@[cntr_cmpo_flg],'0','N','Y')," ).append("\n"); 
		query.append("CHSS_CMPO_FLG = DECODE(@[chss_cmpo_flg],'0','N','Y')," ).append("\n"); 
		query.append("MGST_CMPO_FLG = DECODE(@[mgst_cmpo_flg],'0','N','Y')" ).append("\n"); 
		query.append("WHERE	EQ_CMPO_NUM_ISO_CD = @[eq_cmpo_num_iso_cd]" ).append("\n"); 
		query.append("AND	EQ_CMPO_CD = @[eq_cmpo_cd]" ).append("\n"); 
		query.append("AND	EQ_CMPO_GRP_TP_CD = @[eq_cmpo_grp_tp_cd]" ).append("\n"); 

	}
}