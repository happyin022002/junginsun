/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupServiceProviderManageDBDAOGetEgChoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupServiceProviderManageDBDAOGetEgChoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetEgChoice
	  * </pre>
	  */
	public EvaluationGroupServiceProviderManageDBDAOGetEgChoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.integration ").append("\n"); 
		query.append("FileName : EvaluationGroupServiceProviderManageDBDAOGetEgChoiceRSQL").append("\n"); 
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
		query.append("SELECT EG_RHQ_CD" ).append("\n"); 
		query.append(", EG_CTY_CD" ).append("\n"); 
		query.append(", SVC_CATE_CD" ).append("\n"); 
		query.append("FROM  SPE_EV_GRP" ).append("\n"); 
		query.append("WHERE EG_ID||TO_CHAR(EG_ID_SEQ,'000') = @[eg_id]" ).append("\n"); 

	}
}