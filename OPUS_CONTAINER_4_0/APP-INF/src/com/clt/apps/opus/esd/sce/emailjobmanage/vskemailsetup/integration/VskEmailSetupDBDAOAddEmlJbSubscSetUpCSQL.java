/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSetupDBDAOAddEmlJbSubscSetUpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.25
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.25 박준용
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

public class VskEmailSetupDBDAOAddEmlJbSubscSetUpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL E-MAIL 대상 추가 ( SCE_EML_JB_SUBSC )
	  * </pre>
	  */
	public VskEmailSetupDBDAOAddEmlJbSubscSetUpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emlGrpId",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("subscEml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emlSubSeq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svcEndDt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vslSlanCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.integration").append("\n"); 
		query.append("FileName : VskEmailSetupDBDAOAddEmlJbSubscSetUpCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_EML_JB_SUBSC(" ).append("\n"); 
		query.append("EML_JB_ID," ).append("\n"); 
		query.append("SVC_ST_DT," ).append("\n"); 
		query.append("SVC_END_DT," ).append("\n"); 
		query.append("EML_GRP_ID," ).append("\n"); 
		query.append("VSL_SLAN_CD," ).append("\n"); 
		query.append("TO_PORT_CD," ).append("\n"); 
		query.append("SUBSC_SEQ," ).append("\n"); 
		query.append("SUBSC_TP_CD," ).append("\n"); 
		query.append("SUBSC_EML," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[emlJbId]," ).append("\n"); 
		query.append("NVL(@[svcStDt], TO_CHAR(SYSDATE, 'YYYYMMDD'))," ).append("\n"); 
		query.append("NVL(@[svcEndDt], '99991231')," ).append("\n"); 
		query.append("@[emlGrpId]," ).append("\n"); 
		query.append("@[vslSlanCd]," ).append("\n"); 
		query.append("@[toPortCd]," ).append("\n"); 
		query.append("@[emlSubSeq]," ).append("\n"); 
		query.append("'TO'," ).append("\n"); 
		query.append("@[subscEml]," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'SYSTEM'," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("'SYSTEM'," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}