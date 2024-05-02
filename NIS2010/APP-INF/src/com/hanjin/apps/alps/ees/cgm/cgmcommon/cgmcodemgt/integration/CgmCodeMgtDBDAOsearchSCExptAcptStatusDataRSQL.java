/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmCodeMgtDBDAOsearchSCExptAcptStatusDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.06.22 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOsearchSCExptAcptStatusDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CgmCodeMgtDBDAOsearchSCExptAcptStatusDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOsearchSCExptAcptStatusDataRSQL").append("\n"); 
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
		query.append("	A.SC_EXPT_VER_SEQ," ).append("\n"); 
		query.append("	A.PROP_NO," ).append("\n"); 
		query.append("	TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("	TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("    A.FT_FLG" ).append("\n"); 
		query.append("FROM CGM_SC_EXPT_VER A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("  AND A.SC_EXPT_VER_SEQ = " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	/*+ INDEX_DESC(CGM_SC_EXPT_VER XPKCGM_SC_EXPT_VER) */ SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("			FROM	CGM_SC_EXPT_VER" ).append("\n"); 
		query.append("			WHERE	PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("			AND	ROWNUM = 1" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("  AND A.CHSS_EXPT_VER_STS_CD IN ( 'A', 'L' )" ).append("\n"); 

	}
}