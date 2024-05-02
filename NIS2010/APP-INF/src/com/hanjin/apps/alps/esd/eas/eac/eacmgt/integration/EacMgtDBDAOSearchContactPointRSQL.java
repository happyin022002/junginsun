/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchContactPointRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchContactPointRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Contact point를 조회합니다.
	  * </pre>
	  */
	public EacMgtDBDAOSearchContactPointRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchContactPointRSQL").append("\n"); 
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
		query.append("SELECT VNDR_SEQ" ).append("\n"); 
		query.append("     , VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("     , VNDR_CNTC_PNT_NM" ).append("\n"); 
		query.append("     , PSN_NM" ).append("\n"); 
		query.append("     , PSN_DESC" ).append("\n"); 
		query.append("     , STE_NM" ).append("\n"); 
		query.append("     , CTY_NM" ).append("\n"); 
		query.append("     , PHN_NO" ).append("\n"); 
		query.append("     , FAX_NO" ).append("\n"); 
		query.append("     , VNDR_EML" ).append("\n"); 
		query.append("     , EAC_EML_USE_FLG" ).append("\n"); 
		query.append("     , EAC_FAX_USE_FLG" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) AS CRE_USR_NM" ).append("\n"); 
		query.append("     , UPD_DT AS CRE_DT" ).append("\n"); 
		query.append("FROM   EAS_EXPN_AUD_CS_CNTC_PNT A" ).append("\n"); 
		query.append("WHERE  VNDR_SEQ = @[g_vndr_seq]" ).append("\n"); 
		query.append("AND    DELT_FLG IS NULL" ).append("\n"); 
		query.append("ORDER BY VNDR_CNTC_PNT_SEQ ASC" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}