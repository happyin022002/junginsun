/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOsearchPriScqAwkNewCgoSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.06
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.03.06 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOsearchPriScqAwkNewCgoSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_AWK_CGO 테이블의 최종 CGO SEQ 조회
	  * </pre>
	  */
	public ScqAwkwardDBDAOsearchPriScqAwkNewCgoSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOsearchPriScqAwkNewCgoSeqRSQL").append("\n"); 
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
		query.append("SELECT (NVL((SELECT /*+INDEX_DESC(A XPKPRI_SCQ_AWK_CGO )*/ CGO_SEQ" ).append("\n"); 
		query.append("               FROM PRI_SCQ_AWK_CGO A" ).append("\n"); 
		query.append("              WHERE A.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("                AND A.SCQ_VER_NO  = @[scq_ver_no]" ).append("\n"); 
		query.append("                AND ROWNUM <= 1), 0 ) + 1) AS CGO_SEQ " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}