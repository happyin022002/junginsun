/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupManageDBDAOConfirmLevelsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.27 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupManageDBDAOConfirmLevelsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ConfirmLevels
	  * </pre>
	  */
	public EvaluationGroupManageDBDAOConfirmLevelsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.integration ").append("\n"); 
		query.append("FileName : EvaluationGroupManageDBDAOConfirmLevelsRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM  SPE_EV_GRP" ).append("\n"); 
		query.append("WHERE EG_RHQ_CD =@[eg_rhq_cd]" ).append("\n"); 
		query.append("AND EG_CTY_CD = @[eg_cty_cd]" ).append("\n"); 
		query.append("AND SVC_CATE_CD = DECODE(@[svc_cate_cd],'Truck','TR', 'Rail','RL',	 'ODCY','CY',		 'Terminal','TM',	 'Water','WT', 'EQ M&R','EQ')" ).append("\n"); 

	}
}