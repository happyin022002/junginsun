/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOsearchPsoCanalInvAttachFileListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 2012.03.07 Park Yeon-Jin
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgentCanalTransitFeeBCDBDAOsearchPsoCanalInvAttachFileListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPsoCanalInvAttachFileList
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOsearchPsoCanalInvAttachFileListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOsearchPsoCanalInvAttachFileListRSQL").append("\n"); 
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
		query.append("SELECT 	A.FILE_SAV_ID FILE_SAV_ID," ).append("\n"); 
		query.append("B.FILE_UPLD_NM FILE_UPLD_NM," ).append("\n"); 
		query.append("B.FILE_PATH_URL FILE_PATH_URL," ).append("\n"); 
		query.append("B.FILE_SZ_CAPA FILE_SZ_CAPA" ).append("\n"); 
		query.append("FROM 	PSO_CNL_TZ_ATCH_FILE A," ).append("\n"); 
		query.append("COM_UPLD_FILE B" ).append("\n"); 
		query.append("WHERE 	A.FILE_SAV_ID 	= B.FILE_SAV_ID" ).append("\n"); 
		query.append("AND 	A.VSL_CD 		= regexp_substr(@[vvd], '[[:alpha:]]+', 1, 1)  --'HJMT'" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO 	= regexp_substr(@[vvd], '[(0-9)]+', 1, 1)  --'0142'" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD 	= regexp_substr(@[vvd], '[[:alpha:]]+', 1, 2)  --'E'" ).append("\n"); 
		query.append("AND     A.YD_CD 		= @[yd_cd]  --'EGSUZT1'" ).append("\n"); 
		query.append("AND     A.CALL_SEQ 		= @[call_seq]  --1" ).append("\n"); 
		query.append("AND     A.LGS_COST_CD is null" ).append("\n"); 
		query.append("AND 	nvl(b.DELT_FLG,'N') != 'Y'" ).append("\n"); 

	}
}