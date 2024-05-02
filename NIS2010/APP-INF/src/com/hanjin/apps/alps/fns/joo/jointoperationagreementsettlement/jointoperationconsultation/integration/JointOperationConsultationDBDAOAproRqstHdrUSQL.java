/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOAproRqstHdrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.10.29 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOAproRqstHdrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_APRO_RQST_HDR 에 UPDATE한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOAproRqstHdrUSQL(){
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
		params.put("apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOAproRqstHdrUSQL").append("\n"); 
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
		query.append("UPDATE COM_APRO_RQST_HDR" ).append("\n"); 
		query.append("SET    APSTS_CD = CASE WHEN @[apro_flg] = 'Y' " ).append("\n"); 
		query.append("                       THEN " ).append("\n"); 
		query.append("                            CASE WHEN @[lst_apro_flg] = 'Y' " ).append("\n"); 
		query.append("                                 THEN 'C'" ).append("\n"); 
		query.append("                                 ELSE 'P' " ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("                       ELSE 'R'" ).append("\n"); 
		query.append("                  END," ).append("\n"); 
		query.append("      CRNT_APRO_SEQ = NVL((" ).append("\n"); 
		query.append("            SELECT /*+INDEX(X XPKCOM_APRO_RQST_ROUT)*/" ).append("\n"); 
		query.append("                   X.APRO_RQST_SEQ" ).append("\n"); 
		query.append("            FROM   COM_APRO_RQST_ROUT X" ).append("\n"); 
		query.append("            WHERE  X.APRO_RQST_NO  = @[apro_rqst_no]" ).append("\n"); 
		query.append("            AND    X.APRO_RQST_SEQ > TO_NUMBER(@[apro_rqst_seq])" ).append("\n"); 
		query.append("            -- CANCEL 이면 +1 할 필요가 없다. DATA 안나오도록 일부러 다른 조건을 준다." ).append("\n"); 
		query.append("            AND    NVL(X.APSTS_CD,'P') = DECODE(@[apro_flg],'Y','P','X')" ).append("\n"); 
		query.append("            AND    ROWNUM          = 1" ).append("\n"); 
		query.append("           ), CRNT_APRO_SEQ)," ).append("\n"); 
		query.append("/* 후결기능 삭제" ).append("\n"); 
		query.append("#if(${urg_pay_flg}!= 'Y')" ).append("\n"); 
		query.append("      CRNT_APRO_SEQ = NVL((" ).append("\n"); 
		query.append("            SELECT /*+INDEX(X XPKCOM_APRO_RQST_ROUT)*/" ).append("\n"); 
		query.append("                   X.APRO_RQST_SEQ" ).append("\n"); 
		query.append("            FROM   COM_APRO_RQST_ROUT X" ).append("\n"); 
		query.append("            WHERE  X.APRO_RQST_NO  = @[apro_rqst_no]" ).append("\n"); 
		query.append("            AND    X.APRO_RQST_SEQ > TO_NUMBER(@[apro_rqst_seq])" ).append("\n"); 
		query.append("            -- CANCEL 이면 +1 할 필요가 없다. DATA 안나오도록 일부러 다른 조건을 준다." ).append("\n"); 
		query.append("            AND    NVL(X.APSTS_CD,'P') = DECODE(@[apro_flg],'Y','P','X')" ).append("\n"); 
		query.append("            AND    ROWNUM          = 1" ).append("\n"); 
		query.append("           ), CRNT_APRO_SEQ)," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("      UPD_USR_ID    = @[upd_usr_id]," ).append("\n"); 
		query.append("      UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("WHERE APRO_RQST_NO = @[apro_rqst_no]" ).append("\n"); 

	}
}