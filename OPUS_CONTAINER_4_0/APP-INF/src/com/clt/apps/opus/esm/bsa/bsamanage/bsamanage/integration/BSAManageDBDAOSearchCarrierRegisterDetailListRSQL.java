/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOSearchCarrierRegisterDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.02 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchCarrierRegisterDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCarrierRegisterDetailList SELECT
	  * </pre>
	  */
	public BSAManageDBDAOSearchCarrierRegisterDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchCarrierRegisterDetailListRSQL").append("\n"); 
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
		query.append("BSA_OP_CD ||'|'|| BSA_OP_JB_CD AS KEY" ).append("\n"); 
		query.append(",CRR_CD" ).append("\n"); 
		query.append(",APLY_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BSA_CRR_RGST A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BSA_OP_CD = @[bsa_op_cd]" ).append("\n"); 
		query.append("AND    BSA_OP_JB_CD IN ('001','002','003','004','005')" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("BSA_OP_JB_CD" ).append("\n"); 
		query.append(",CRR_CD" ).append("\n"); 

	}
}