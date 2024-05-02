/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MstMgmtDBDAOAddMdmUsrAuthVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAOAddMdmUsrAuthVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MdmUsrAuthVO 정보를 추가한다.
	  * </pre>
	  */
	public MstMgmtDBDAOAddMdmUsrAuthVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_dat_subj_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration").append("\n"); 
		query.append("FileName : MstMgmtDBDAOAddMdmUsrAuthVOCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_USR_AUTH (" ).append("\n"); 
		query.append("USR_ID," ).append("\n"); 
		query.append("MST_DAT_SUBJ_CD," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("AUTH_TP_CD," ).append("\n"); 
		query.append("PGM_ID," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("@[mst_dat_subj_cd]," ).append("\n"); 
		query.append("@[ofc_cd]," ).append("\n"); 
		query.append("@[auth_tp_cd]," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID='CD20091'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = @[mst_dat_subj_cd])," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}