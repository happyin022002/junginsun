/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupServiceProviderManageDBDAOSpeEvGrpSvcProvMtchDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.04 남궁진호
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

public class EvaluationGroupServiceProviderManageDBDAOSpeEvGrpSvcProvMtchDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpeEvGrpSvcProvMtchDSQL
	  * </pre>
	  */
	public EvaluationGroupServiceProviderManageDBDAOSpeEvGrpSvcProvMtchDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.integration ").append("\n"); 
		query.append("FileName : EvaluationGroupServiceProviderManageDBDAOSpeEvGrpSvcProvMtchDSQL").append("\n"); 
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
		query.append("DELETE FROM SPE_EV_GRP_SVC_PROV_MTCH" ).append("\n"); 
		query.append("WHERE	EG_ID = @[eg_id]" ).append("\n"); 
		query.append("AND	EG_ID_SEQ = @[eg_id_seq]" ).append("\n"); 
		query.append("AND	VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}