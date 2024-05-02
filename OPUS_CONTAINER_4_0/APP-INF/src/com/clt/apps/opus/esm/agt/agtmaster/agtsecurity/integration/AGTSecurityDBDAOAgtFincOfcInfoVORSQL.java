/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTSecurityDBDAOAgtFincOfcInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.03.15 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtsecurity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTSecurityDBDAOAgtFincOfcInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Security & AR Office Inquiry   
	  * </pre>
	  */
	public AGTSecurityDBDAOAgtFincOfcInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hqofccd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtmaster.agtsecurity.integration").append("\n"); 
		query.append("FileName : AGTSecurityDBDAOAgtFincOfcInfoVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("B.AGN_CD," ).append("\n"); 
		query.append("B.AR_OFC_CD," ).append("\n"); 
		query.append("B.CURR_CD," ).append("\n"); 
		query.append("NVL(B.OFC_DELT_RSN, ' ') AS OFC_DELT_RSN," ).append("\n"); 
		query.append("NVL(B.DELT_FLG, 'N')     AS DELT_FLG" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("AGT_FINC_OFC_INFO B" ).append("\n"); 
		query.append("WHERE A.AR_HD_QTR_OFC_CD = NVL(@[hqofccd], A.AR_HD_QTR_OFC_CD)" ).append("\n"); 
		query.append("AND A.OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}