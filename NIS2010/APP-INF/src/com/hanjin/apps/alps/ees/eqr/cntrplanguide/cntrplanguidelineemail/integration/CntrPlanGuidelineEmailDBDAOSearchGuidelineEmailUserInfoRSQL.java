/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrPlanGuidelineEmailDBDAOSearchGuidelineEmailUserInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineEmailDBDAOSearchGuidelineEmailUserInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력대상 USR ID 의 유효성 확인 및 이름/OFC CD/EMAIL 정보 조회
	  * </pre>
	  */
	public CntrPlanGuidelineEmailDBDAOSearchGuidelineEmailUserInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineEmailDBDAOSearchGuidelineEmailUserInfoRSQL").append("\n"); 
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
		query.append("SELECT A.USR_ID GLINE_RCPT_USR_ID" ).append("\n"); 
		query.append("      ,A.USR_NM" ).append("\n"); 
		query.append("      ,B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("      ,B.OFC_CD" ).append("\n"); 
		query.append("      ,A.USR_EML GLINE_RCPT_EML" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("           SELECT CASE WHEN COUNT(1) > 0 THEN 'F' " ).append("\n"); 
		query.append("                                         ELSE 'T' " ).append("\n"); 
		query.append("                  END DUP_CHK  " ).append("\n"); 
		query.append("           FROM EQR_CTRL_GLINE_EML_RCPT " ).append("\n"); 
		query.append("           WHERE GLINE_RCPT_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("       ) USR_ID_VAL -- T:중복없음(사용가능), F:중복존재 입력불가" ).append("\n"); 
		query.append("FROM COM_USER A" ).append("\n"); 
		query.append("    ,MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = B.OFC_CD    " ).append("\n"); 
		query.append("AND   A.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND   A.USE_FLG = 'Y'  -- 사용중인 유저만 포함" ).append("\n"); 

	}
}