/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : FreeTimeDBDAOSearchPortMvmtIbDemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FreeTimeDBDAOSearchPortMvmtIbDemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FreeTimeDBDAOSearchPortMvmtIbDemRSQL
	  * </pre>
	  */
	public FreeTimeDBDAOSearchPortMvmtIbDemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.integration").append("\n"); 
		query.append("FileName : FreeTimeDBDAOSearchPortMvmtIbDemRSQL").append("\n"); 
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
		query.append("SELECT  @[bkg_no]    							AS BKG_NO" ).append("\n"); 
		query.append("	   ,@[cntr_no]   							AS CNTR_NO" ).append("\n"); 
		query.append("	   ,MVMT_STS_CD								AS FM_MVMT_STS_CD" ).append("\n"); 
		query.append("	   ,TO_CHAR(CNMV_EVNT_DT, 'YYYYMMDDHH24MI')	AS FM_MVMT_DT" ).append("\n"); 
		query.append("	   ,ORG_YD_CD								AS FM_MVMT_YD_CD" ).append("\n"); 
		query.append("       ,'POD'									AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM  CTM_MOVEMENT T1" ).append("\n"); 
		query.append(" WHERE  T1.CNTR_NO     = @[cntr_no]" ).append("\n"); 
		query.append("   AND  T1.CNMV_CYC_NO = " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT  MAX(CNMV_CYC_NO)" ).append("\n"); 
		query.append("			  FROM  CTM_MOVEMENT" ).append("\n"); 
		query.append("			 WHERE  CNTR_NO = T1.CNTR_NO" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   AND  T1.MVMT_STS_CD = 'VD'	   " ).append("\n"); 
		query.append("   AND  T1.ORG_YD_CD   = " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT  POD_NOD_CD" ).append("\n"); 
		query.append("			  FROM  BKG_BOOKING" ).append("\n"); 
		query.append("			 WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}