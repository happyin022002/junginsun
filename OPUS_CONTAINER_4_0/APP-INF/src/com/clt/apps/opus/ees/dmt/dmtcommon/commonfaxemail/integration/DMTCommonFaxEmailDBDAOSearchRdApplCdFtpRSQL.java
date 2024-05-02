/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCommonFaxEmailDBDAOSearchRdApplCdFtpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonFaxEmailDBDAOSearchRdApplCdFtpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Issue에서 India Digital Invoice 처리를 위한 FTP로 전송시 해당 MRD의 정보를 가져와 처리
	  * </pre>
	  */
	public DMTCommonFaxEmailDBDAOSearchRdApplCdFtpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrd_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.integration ").append("\n"); 
		query.append("FileName : DMTCommonFaxEmailDBDAOSearchRdApplCdFtpRSQL").append("\n"); 
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
		query.append("SELECT RD_APPL_CD" ).append("\n"); 
		query.append("     , RD_SUB_SYS_CD" ).append("\n"); 
		query.append("  FROM COM_RPT_DSGN_SND_APPL" ).append("\n"); 
		query.append(" WHERE RD_TMPLT_NM      = @[mrd_nm]" ).append("\n"); 
		query.append("   AND FAX_EML_DIV_CD   = 'A'" ).append("\n"); 
		query.append("   AND ROWNUM           = 1" ).append("\n"); 

	}
}