/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOsearchPriScqAwkRqstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.26
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.26 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOsearchPriScqAwkRqstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_AWK_MN
	  * </pre>
	  */
	public ScqAwkwardDBDAOsearchPriScqAwkRqstNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration ").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOsearchPriScqAwkRqstNoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT MN.SCQ_RQST_NO " ).append("\n"); 
		query.append("  FROM PRI_SCQ_AWK_MN MN" ).append("\n"); 
		query.append("     , PRI_SCQ_PROG PG" ).append("\n"); 
		query.append(" WHERE MN.SCQ_RQST_NO = PG.SCQ_RQST_NO" ).append("\n"); 
		query.append("   AND MN.SCQ_VER_NO  = PG.SCQ_VER_NO" ).append("\n"); 
		query.append("   AND PG.SPCL_CGO_TP_CD = 'AK'" ).append("\n"); 
		query.append("#if(${rqst_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND MN.RQST_OFC_CD  = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rqst_srep_cd} != '')" ).append("\n"); 
		query.append("   AND MN.RQST_SREP_CD = @[rqst_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${apro_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND MN.APRO_OFC_CD  = @[apro_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY MN.SCQ_RQST_NO" ).append("\n"); 

	}
}