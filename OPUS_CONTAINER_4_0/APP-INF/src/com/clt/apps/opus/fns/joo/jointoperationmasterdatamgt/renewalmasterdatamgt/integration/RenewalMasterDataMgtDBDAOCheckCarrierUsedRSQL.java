/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalMasterDataMgtDBDAOCheckCarrierUsedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalMasterDataMgtDBDAOCheckCarrierUsedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 하위 테이블 Carrier 체크 여부
	  * </pre>
	  */
	public RenewalMasterDataMgtDBDAOCheckCarrierUsedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration").append("\n"); 
		query.append("FileName : RenewalMasterDataMgtDBDAOCheckCarrierUsedRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN EXIST_CNT > 0 THEN 'Y' ELSE 'N' END AS EXIST_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT COUNT(*) AS EXIST_CNT" ).append("\n"); 
		query.append("          FROM JOO_STL_VVD SV" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND SV.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("           AND SV.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}