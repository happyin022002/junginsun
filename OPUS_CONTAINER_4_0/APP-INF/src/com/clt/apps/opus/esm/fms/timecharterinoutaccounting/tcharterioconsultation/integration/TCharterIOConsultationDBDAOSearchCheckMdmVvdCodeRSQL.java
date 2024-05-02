/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchCheckMdmVvdCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchCheckMdmVvdCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 재무 항차 검사한다 RLANE_CD, SLAN_CD 조회.
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchCheckMdmVvdCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchCheckMdmVvdCodeRSQL").append("\n"); 
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
		query.append("SELECT MAX(SLAN_CD) AS SLAN_CD" ).append("\n"); 
		query.append("      ,MAX(RLANE_CD) AS RLANE_CD" ).append("\n"); 
		query.append("  FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append(" WHERE VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("   AND RLANE_DIR_CD = SUBSTR(@[vvd_cd],10,1)" ).append("\n"); 

	}
}