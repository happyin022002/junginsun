/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOSearchPolCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineManageDBDAOSearchPolCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Form ComboBox
	  * VVD별 POL LIST
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOSearchPolCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOSearchPolCdListRSQL").append("\n"); 
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
		query.append("SELECT A.VPS_PORT_CD   POL_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("WHERE A.VSL_CD     	= SUBSTR(@[s_vvd_cd], 0, 4)  -- VVD 변수" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO 	= SUBSTR(@[s_vvd_cd], 5, 4)  -- VVD 변수" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD 	= SUBSTR(@[s_vvd_cd], 9, 1)  -- VVD 변수" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${h_eta_dt} != '') " ).append("\n"); 
		query.append("AND   A.VPS_ETA_DT > TO_DATE(@[h_eta_dt],'YYYYMMDD HH24MISS')+0.99999 --GUIDELINE AMEND" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.VPS_ETA_DT" ).append("\n"); 

	}
}