/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupDBDAORemoveEGCreUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.10 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupDBDAORemoveEGCreUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EG 데이터를 삭제 한다.
	  * </pre>
	  */
	public EvaluationGroupDBDAORemoveEGCreUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.integration ").append("\n"); 
		query.append("FileName : EvaluationGroupDBDAORemoveEGCreUSQL").append("\n"); 
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
		query.append("UPDATE SPE_EV_GRP" ).append("\n"); 
		query.append("   SET DELT_FLG        = 'Y'" ).append("\n"); 
		query.append("     , UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT          = SYSDATE" ).append("\n"); 
		query.append(" WHERE EG_ID           = @[eg_id]" ).append("\n"); 

	}
}