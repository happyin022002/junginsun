/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchTpbDtlRSQL.java
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

public class EacMgtDBDAOSearchTpbDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC Tpb DTL Grid 를 조회한다.
	  * </pre>
	  */
	public EacMgtDBDAOSearchTpbDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchTpbDtlRSQL").append("\n"); 
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
		query.append("SELECT EAC_DTL_SEQ" ).append("\n"); 
		query.append("     , EQ_KND_CD" ).append("\n"); 
		query.append("     , EQ_NO" ).append("\n"); 
		query.append("     , EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , DIFF_INV_AMT" ).append("\n"); 
		query.append("     , EAC_NO" ).append("\n"); 
		query.append("FROM   EAS_EXPN_AUD_N3RD_PTY_DTL" ).append("\n"); 
		query.append("WHERE  EAC_NO =  @[eac_no]" ).append("\n"); 
		query.append("AND    NVL(DELT_FLG,'N') != 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}