/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOsearchMNRGenCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.20
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.04.20 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOsearchMNRGenCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESD_EAS_0360 화면에서 MNR_GEN_CD를 사용하는 코드
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOsearchMNRGenCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOsearchMNRGenCodeRSQL").append("\n"); 
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
		query.append("SELECT MNR_CD_ID CODE_CD" ).append("\n"); 
		query.append("     , MNR_CD_DP_DESC CODE_NM" ).append("\n"); 
		query.append("     , MNR_CD_DP_SEQ" ).append("\n"); 
		query.append("     , DECODE(MNR_CD_ID, 'UT', -1, MNR_CD_DP_SEQ) MNR_CD_DP_SEQ2" ).append("\n"); 
		query.append("  FROM MNR_GEN_CD" ).append("\n"); 
		query.append(" WHERE PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND MNR_CD_ID != 'SS'" ).append("\n"); 
		query.append("   AND MNR_CD_ID != 'SL'" ).append("\n"); 
		query.append("   AND MNR_CD_ID != 'OF'" ).append("\n"); 
		query.append("#if(${s_mnr_code_type} == 'W')" ).append("\n"); 
		query.append(" ORDER BY MNR_CD_DP_SEQ2" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" ORDER BY MNR_CD_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}