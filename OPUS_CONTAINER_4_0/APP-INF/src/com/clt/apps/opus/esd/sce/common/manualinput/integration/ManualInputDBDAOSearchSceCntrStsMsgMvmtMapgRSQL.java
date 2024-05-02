/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ManualInputDBDAOSearchSceCntrStsMsgMvmtMapgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualInputDBDAOSearchSceCntrStsMsgMvmtMapgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSceCntrStsMsgMvmtMapg
	  * </pre>
	  */
	public ManualInputDBDAOSearchSceCntrStsMsgMvmtMapgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csm_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.manualinput.integration").append("\n"); 
		query.append("FileName : ManualInputDBDAOSearchSceCntrStsMsgMvmtMapgRSQL").append("\n"); 
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
		query.append("SELECT ACT_STS_MAPG_CD" ).append("\n"); 
		query.append("      ,STND_EDI_STS_CD" ).append("\n"); 
		query.append("      ,CSM_CNT_CD" ).append("\n"); 
		query.append("      ,CSM_DESC" ).append("\n"); 
		query.append("      ,EFF_FM_DT" ).append("\n"); 
		query.append("      ,EFF_TO_DT" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("  FROM SCE_CNTR_STS_MSG_MVMT_MAPG" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("#if (${csm_cnt_cd} != '') " ).append("\n"); 
		query.append("  AND CSM_CNT_CD = @[csm_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}