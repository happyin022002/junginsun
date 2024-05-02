/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SI Analysis Result 테이블에 Delete
	  * </pre>
	  */
	public EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltDSQL(){
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
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.integration ").append("\n"); 
		query.append("FileName : EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltDSQL").append("\n"); 
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
		query.append("DELETE FROM SPE_EV_GRP_STRG_IMPT_RSLT" ).append("\n"); 
		query.append("WHERE EV_YR			= @[ev_yr]" ).append("\n"); 
		query.append("AND   EG_ID 		= @[eg_id]" ).append("\n"); 
		query.append("AND   EG_ID_SEQ = @[eg_id_seq]" ).append("\n"); 

	}
}