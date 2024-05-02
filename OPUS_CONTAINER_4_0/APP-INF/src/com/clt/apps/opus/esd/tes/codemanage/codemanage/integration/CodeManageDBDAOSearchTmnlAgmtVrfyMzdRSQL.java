/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CodeManageDBDAOSearchTmnlAgmtVrfyMzdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeManageDBDAOSearchTmnlAgmtVrfyMzdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal Agreement Verify Method 조회
	  * </pre>
	  */
	public CodeManageDBDAOSearchTmnlAgmtVrfyMzdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.codemanage.codemanage.integration ").append("\n"); 
		query.append("FileName : CodeManageDBDAOSearchTmnlAgmtVrfyMzdRSQL").append("\n"); 
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
		query.append("SELECT LGS_COST_CD," ).append("\n"); 
		query.append("COM_AUTO_CALC_FLG," ).append("\n"); 
		query.append("TML_THRP_COST_CD_FLG," ).append("\n"); 
		query.append("TML_IO_BND_FLG," ).append("\n"); 
		query.append("TML_IOC_FLG," ).append("\n"); 
		query.append("TML_APLY_DT_FLG," ).append("\n"); 
		query.append("TML_LANE_FLG," ).append("\n"); 
		query.append("TML_DCGO_APLY_FLG," ).append("\n"); 
		query.append("TML_TR_VOL_FLG," ).append("\n"); 
		query.append("TML_OVT_SHFT_FLG," ).append("\n"); 
		query.append("TML_THC_FLG," ).append("\n"); 
		query.append("STO_COM_AGMT_TP_FLG," ).append("\n"); 
		query.append("STO_COM_CMNC_TM_FLG," ).append("\n"); 
		query.append("STO_FREE_DY_IO_BND_FLG," ).append("\n"); 
		query.append("STO_FREE_DY_FLG," ).append("\n"); 
		query.append("STO_FREE_DY_DCGO_TM_FLG," ).append("\n"); 
		query.append("STO_FREE_DY_XCLD_DT_FLG," ).append("\n"); 
		query.append("STO_FREE_DY_DCGO_RT_FLG," ).append("\n"); 
		query.append("STO_FREE_DY_TR_DY_FLG," ).append("\n"); 
		query.append("STO_FP_CALC_PRD_FLG," ).append("\n"); 
		query.append("STO_FP_TEU_FLG," ).append("\n"); 
		query.append("RT_CNTR_TPSZ_FLG," ).append("\n"); 
		query.append("RT_TEU_FLG," ).append("\n"); 
		query.append("RT_BX_FLG," ).append("\n"); 
		query.append("RT_MV_FLG," ).append("\n"); 
		query.append("FREE_DY_CNTR_TPSZ_FLG," ).append("\n"); 
		query.append("TML_TRNS_MOD_FLG," ).append("\n"); 
		query.append("TML_AGMT_DIV_FLG" ).append("\n"); 
		query.append("FROM TES_TML_AGMT_VRFY_MZD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lgs_cost_cd} != '')" ).append("\n"); 
		query.append("WHERE LGS_COST_CD LIKE @[lgs_cost_cd]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE LGS_COST_CD LIKE ''||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY LGS_COST_CD" ).append("\n"); 

	}
}