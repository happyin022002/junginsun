/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOManualSurchargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOManualSurchargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManualSurcharge
	  * </pre>
	  */
	public BookingUtilDBDAOManualSurchargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("application_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOManualSurchargeRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	   DISTINCT BSE.CHG_CD, --적용해야될 charge" ).append("\n"); 
		query.append("	   PRF.CHG_CD PCHG_CD, -- 대상 charge" ).append("\n"); 
		query.append("       PRF.PCT_BSE_CD" ).append("\n"); 
		query.append("       FROM PRI_SCG_PRF PRF,PRI_SCG_RT RT,  PRI_SCG_PCT_BSE_CHG BSE" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND PRF.SVC_SCP_CD =  @[svc_scp_cd]						-- 부킹의 SVS SCOPE" ).append("\n"); 
		query.append("AND PRF.SVC_SCP_CD = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND PRF.CHG_CD = RT.CHG_CD" ).append("\n"); 
		query.append("AND PRF.PCT_BSE_CD = BSE.PCT_BSE_CD" ).append("\n"); 
		query.append("AND TO_DATE( REPLACE(@[application_date],'-','')  ,'YYYYMMDD') BETWEEN RT.EFF_DT AND RT.EXP_DT  -- Application DT 사용" ).append("\n"); 
		query.append("AND TO_DATE( REPLACE(@[application_date],'-','')  ,'YYYYMMDD') BETWEEN BSE.EFF_DT AND BSE.EXP_DT  -- Application DT 사용" ).append("\n"); 

	}
}