/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrsCommonDBDAOSearchMltMorOnyFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.05.16 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOSearchMltMorOnyFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 오피스가 Multi More Candidate 필수 대상 인지 확인 (미국, 캐나다)
	  * </pre>
	  */
	public TrsCommonDBDAOSearchMltMorOnyFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOSearchMltMorOnyFlgRSQL").append("\n"); 
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
		query.append("SELECT 'Y' MLT_MOR_ONY_FLG" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION A ," ).append("\n"); 
		query.append("       MDM_LOCATION B" ).append("\n"); 
		query.append(" WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.CNT_CD IN ('US', 'CA')" ).append("\n"); 
		query.append("   AND TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(A.OFC_CD) = 'NYCRA'" ).append("\n"); 
		query.append("   and A.OFC_CD = @[OFC_CD]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}