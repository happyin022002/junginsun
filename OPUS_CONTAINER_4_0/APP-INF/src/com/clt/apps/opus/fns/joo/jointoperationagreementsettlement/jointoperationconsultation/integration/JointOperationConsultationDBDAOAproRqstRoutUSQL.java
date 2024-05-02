/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationConsultationDBDAOAproRqstRoutUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.29 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOAproRqstRoutUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_APRO_RQST_ROUT 수정
	  * </pre>
	  */
	public JointOperationConsultationDBDAOAproRqstRoutUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOAproRqstRoutUSQL").append("\n"); 
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
		query.append("UPDATE COM_APRO_RQST_ROUT" ).append("\n"); 
		query.append("SET    APSTS_CD = CASE WHEN @[apro_flg] = 'Y' " ).append("\n"); 
		query.append("                       THEN 'C'" ).append("\n"); 
		query.append("                       ELSE 'R'" ).append("\n"); 
		query.append("                  END," ).append("\n"); 
		query.append("       APRO_DT       = TO_DATE(@[apro_dt],'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("       APRO_RMK      = @[cxl_desc]," ).append("\n"); 
		query.append("       UPD_USR_ID    = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("WHERE  APRO_RQST_NO  = @[apro_rqst_no]" ).append("\n"); 
		query.append("AND    APRO_RQST_SEQ = TO_NUMBER(@[apro_rqst_seq])" ).append("\n"); 

	}
}