/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOaddPsoConditionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.10.13 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOaddPsoConditionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pso_condition 입력
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOaddPsoConditionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_sys_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_mnu_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOaddPsoConditionCSQL").append("\n"); 
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
		query.append("INSERT INTO PSO_CONDITION (" ).append("\n"); 
		query.append("COND_NO" ).append("\n"); 
		query.append(",	COND_NM" ).append("\n"); 
		query.append(",	COND_DESC" ).append("\n"); 
		query.append(",	COND_SYS_DESC" ).append("\n"); 
		query.append(",	UPD_MNU_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("#if(${cond_no}!='')" ).append("\n"); 
		query.append("@[cond_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(SELECT /*+INDEX_DESC(T XPKPSO_CONDITION)*/" ).append("\n"); 
		query.append("NVL (MAX (COND_NO), 0) + 1" ).append("\n"); 
		query.append("FROM   pso_condition T" ).append("\n"); 
		query.append("WHERE   T.COND_NO > 0 AND ROWNUM <= 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	@[cond_nm]" ).append("\n"); 
		query.append(",	ltrim(@[cond_desc])" ).append("\n"); 
		query.append(",	ltrim(@[cond_sys_desc])" ).append("\n"); 
		query.append(",	@[upd_mnu_no]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}