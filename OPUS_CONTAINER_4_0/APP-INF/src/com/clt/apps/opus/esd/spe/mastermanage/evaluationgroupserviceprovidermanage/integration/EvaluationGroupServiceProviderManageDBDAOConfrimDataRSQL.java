/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupServiceProviderManageDBDAOConfrimDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupServiceProviderManageDBDAOConfrimDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ConfrimDataRSQL
	  * </pre>
	  */
	public EvaluationGroupServiceProviderManageDBDAOConfrimDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("Path : com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.integration").append("\n"); 
		query.append("FileName : EvaluationGroupServiceProviderManageDBDAOConfrimDataRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM SPE_SVC_PROV_SVC_CATE_MTCH A," ).append("\n"); 
		query.append("SPE_EV_GRP B" ).append("\n"); 
		query.append("WHERE (DECODE(B.SVC_CATE_CD,'TR','Y','Y','N') =  DECODE(SVC_CATE_TRSP_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(B.SVC_CATE_CD,'RL','Y','Y','N') =  DECODE(SVC_CATE_RAIL_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(B.SVC_CATE_CD,'CY','Y','Y','N') =  DECODE(SVC_CATE_CY_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(B.SVC_CATE_CD,'TM','Y','Y','N') =  DECODE(SVC_CATE_TML_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(B.SVC_CATE_CD,'WT','Y','Y','N') =  DECODE(SVC_CATE_WTR_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(B.SVC_CATE_CD,'EQ','Y','Y','N') =  DECODE(SVC_CATE_EQ_FLG,'Y','Y','X'))" ).append("\n"); 
		query.append("AND A.VNDR_SEQ   = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("AND B.EG_ID      = @[eg_id]" ).append("\n"); 
		query.append("AND B.EG_ID_SEQ  = TO_NUMBER(@[eg_id_seq])" ).append("\n"); 

	}
}