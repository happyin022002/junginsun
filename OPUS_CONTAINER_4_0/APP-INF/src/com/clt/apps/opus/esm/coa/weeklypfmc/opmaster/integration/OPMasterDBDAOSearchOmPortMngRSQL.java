/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OPMasterDBDAOSearchOmPortMngRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOSearchOmPortMngRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public OPMasterDBDAOSearchOmPortMngRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOSearchOmPortMngRSQL").append("\n"); 
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
		query.append("SELECT EFF_FM_DT" ).append("\n"); 
		query.append("  	  ,EFF_TO_DT" ).append("\n"); 
		query.append("  	  ,LOC_CD" ).append("\n"); 
		query.append("      ,DECODE(RLANE_CD,'XXXXX','',RLANE_CD) RLANE_CD			--20150612.MOD	" ).append("\n"); 
		query.append("      ,DECODE(DIR_CD,'X','',DIR_CD) DIR_CD" ).append("\n"); 
		query.append("--,CRE_USR_ID		VO용 나중 지우기.." ).append("\n"); 
		query.append("--,UPD_USR_ID" ).append("\n"); 
		query.append("   FROM COA_MON_VVD_PORT_EXPT" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("#if (${eff_fm_dt} != '')" ).append("\n"); 
		query.append("    AND @[eff_fm_dt] BETWEEN EFF_FM_DT AND EFF_TO_DT" ).append("\n"); 
		query.append("     OR EFF_FM_DT >= @[eff_fm_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ORDER BY RLANE_CD, DIR_CD, LOC_CD, EFF_FM_DT, EFF_TO_DT" ).append("\n"); 

	}
}