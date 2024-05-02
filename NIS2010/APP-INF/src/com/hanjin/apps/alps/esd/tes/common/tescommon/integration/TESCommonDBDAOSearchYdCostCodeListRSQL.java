/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESCommonDBDAOSearchYdCostCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.04 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchYdCostCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard, Cost Code List Inquiry
	  * </pre>
	  */
	public TESCommonDBDAOSearchYdCostCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chr_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_rail_rmp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_oshp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_cfs_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchYdCostCodeListRSQL").append("\n"); 
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
		query.append("SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|')" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	LGS_COST_CD" ).append("\n"); 
		query.append(", ROWNUM ROW_ID" ).append("\n"); 
		query.append("FROM	TES_TML_SO_COST" ).append("\n"); 
		query.append("WHERE	DECODE(@[yd_chr_inv_tp_cd],'MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG," ).append("\n"); 
		query.append("'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("AND		CFS_FLG      IN (DECODE(@[yd_fcty_tp_cfs_flg],'N','N','Y'),'N')" ).append("\n"); 
		query.append("AND		RAIL_RMP_FLG IN (DECODE(@[yd_fcty_tp_rail_rmp_flg],'N','N','Y'),'N')" ).append("\n"); 
		query.append("AND		XCLD_TML_FLG IN (DECODE(@[yd_oshp_cd],'O','Y','N'),'N')" ).append("\n"); 
		query.append("ORDER BY LGS_COST_CD ASC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START	WITH ROW_ID = 1" ).append("\n"); 
		query.append("CONNECT	BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 

	}
}