/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrPlanGuidelineEmailDBDAOModifyGuidelineEmailListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineEmailDBDAOModifyGuidelineEmailListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_GLINE_EML_RCPT 테이블에 guideline email 수신자 정보 입력 혹은 수정 한다.
	  * </pre>
	  */
	public CntrPlanGuidelineEmailDBDAOModifyGuidelineEmailListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_rcpt_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_rcpt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration ").append("\n"); 
		query.append("FileName : CntrPlanGuidelineEmailDBDAOModifyGuidelineEmailListUSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_CTRL_GLINE_EML_RCPT V" ).append("\n"); 
		query.append("USING  DUAL" ).append("\n"); 
		query.append("ON (        " ).append("\n"); 
		query.append("      V.GLINE_RCPT_USR_ID     = @[gline_rcpt_usr_id]" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE SET GLINE_RCPT_EML = @[gline_rcpt_eml]" ).append("\n"); 
		query.append("               ,UPD_USR_ID     = @[usr_id] " ).append("\n"); 
		query.append("               ,UPD_DT         = SYSDATE " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        GLINE_RCPT_USR_ID" ).append("\n"); 
		query.append("       ,GLINE_RCPT_EML" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT " ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("	VALUES " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("        @[gline_rcpt_usr_id]," ).append("\n"); 
		query.append("        @[gline_rcpt_eml]," ).append("\n"); 
		query.append("        @[usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[usr_id]," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}