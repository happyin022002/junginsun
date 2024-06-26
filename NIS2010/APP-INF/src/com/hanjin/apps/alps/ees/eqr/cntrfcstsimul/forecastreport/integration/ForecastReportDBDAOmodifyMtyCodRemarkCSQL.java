/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDBDAOmodifyMtyCodRemarkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.07.11 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastReportDBDAOmodifyMtyCodRemarkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_MTY_COD_RMK 의 DIFF_RMK 를 수정 혹은 입력
	  * </pre>
	  */
	public ForecastReportDBDAOmodifyMtyCodRemarkCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofccd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOmodifyMtyCodRemarkCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_MTY_COD_RMK" ).append("\n"); 
		query.append("    USING DUAL" ).append("\n"); 
		query.append("    ON ( " ).append("\n"); 
		query.append("    	VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("    	AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("    	AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("    	AND COD_CFM_DIV_CD = @[div]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET DIFF_RMK = @[remark]," ).append("\n"); 
		query.append("               UPD_OFC_CD = @[ofc_cd]," ).append("\n"); 
		query.append("               UPD_USR_ID = @[cre_usr_id]," ).append("\n"); 
		query.append("               UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("     INSERT " ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("		 VSL_CD" ).append("\n"); 
		query.append("		,SKD_VOY_NO" ).append("\n"); 
		query.append("		,SKD_DIR_CD" ).append("\n"); 
		query.append("		,COD_CFM_DIV_CD" ).append("\n"); 
		query.append("		,DIFF_RMK" ).append("\n"); 
		query.append("		,CRE_OFC_CD" ).append("\n"); 
		query.append("		,CRE_USR_ID" ).append("\n"); 
		query.append("		,CRE_DT" ).append("\n"); 
		query.append("		,UPD_OFC_CD" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,UPD_DT" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("	VALUES" ).append("\n"); 
		query.append("	( " ).append("\n"); 
		query.append("		 SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("		,SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("		,SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("		,@[div]" ).append("\n"); 
		query.append("		,@[remark]" ).append("\n"); 
		query.append("		,@[ofc_cd]" ).append("\n"); 
		query.append("		,@[cre_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,@[ofccd]" ).append("\n"); 
		query.append("		,@[cre_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}