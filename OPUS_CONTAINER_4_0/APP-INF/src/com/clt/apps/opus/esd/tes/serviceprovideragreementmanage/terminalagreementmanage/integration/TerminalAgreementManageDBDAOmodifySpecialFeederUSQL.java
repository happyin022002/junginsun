/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOmodifySpecialFeederUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.18
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.04.18 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOmodifySpecialFeederUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update China Special Feeder
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOmodifySpecialFeederUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOmodifySpecialFeederUSQL").append("\n"); 
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
		query.append("UPDATE TES_TML_SPCL_FDR" ).append("\n"); 
		query.append("SET FDR_POL_CD = @[fdr_pol_cd]," ).append("\n"); 
		query.append("    FDR_POD_CD = @[fdr_pod_cd]," ).append("\n"); 
		query.append("    UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE FDR_POL_CD = @[fdr_pol_cd]" ).append("\n"); 
		query.append("AND FDR_POD_CD = @[fdr_pod_cd]" ).append("\n"); 

	}
}