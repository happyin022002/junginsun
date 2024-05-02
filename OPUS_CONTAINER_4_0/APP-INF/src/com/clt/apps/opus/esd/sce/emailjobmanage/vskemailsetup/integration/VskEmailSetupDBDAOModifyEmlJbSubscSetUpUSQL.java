/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSetupDBDAOModifyEmlJbSubscSetUpUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.23
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.23 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VskEmailSetupDBDAOModifyEmlJbSubscSetUpUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL E-MAIL 대상 변경 ( SCE_EML_JB_SUBSC )
	  * </pre>
	  */
	public VskEmailSetupDBDAOModifyEmlJbSubscSetUpUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emlGrpIdHis",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vslSlanCdHis",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subscEml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svcStDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emlJbId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toPortCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svcEndDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vslSlanCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toPortCdHis",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subscSeqHis",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.integration").append("\n"); 
		query.append("FileName : VskEmailSetupDBDAOModifyEmlJbSubscSetUpUSQL").append("\n"); 
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
		query.append("UPDATE SCE_EML_JB_SUBSC" ).append("\n"); 
		query.append("SET SUBSC_EML = @[subscEml]," ).append("\n"); 
		query.append("VSL_SLAN_CD = @[vslSlanCd]," ).append("\n"); 
		query.append("TO_PORT_CD = @[toPortCd]," ).append("\n"); 
		query.append("DELT_FLG = 'N'" ).append("\n"); 
		query.append("WHERE EML_JB_ID = @[emlJbId]" ).append("\n"); 
		query.append("AND SVC_ST_DT = @[svcStDt]" ).append("\n"); 
		query.append("AND SVC_END_DT = @[svcEndDt]" ).append("\n"); 
		query.append("AND EML_GRP_ID = @[emlGrpIdHis]" ).append("\n"); 
		query.append("AND VSL_SLAN_CD = @[vslSlanCdHis]" ).append("\n"); 
		query.append("AND TO_PORT_CD = @[toPortCdHis]" ).append("\n"); 
		query.append("AND SUBSC_SEQ = @[subscSeqHis]" ).append("\n"); 

	}
}