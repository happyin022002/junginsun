/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeMgtDBDAOSearchOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.12.07 양정란
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeMgtDBDAOSearchOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Code검증
	  * </pre>
	  */
	public CodeMgtDBDAOSearchOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_to_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration ").append("\n"); 
		query.append("FileName : CodeMgtDBDAOSearchOfcCdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_ORGANIZATION A" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.OFC_KND_CD     = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND B.INTG_CD_ID = 'CD00675'" ).append("\n"); 
		query.append("AND A.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("AND A.OFC_CD     = @[trns_to_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", '') EXIST_OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 

	}
}