/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESCommonDBDAOSearchAgreementCostCodeListRSQL.java
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

public class TESCommonDBDAOSearchAgreementCostCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Cost Code List Inquiry
	  * </pre>
	  */
	public TESCommonDBDAOSearchAgreementCostCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchAgreementCostCodeListRSQL").append("\n"); 
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
		query.append("SELECT	LGS_COST_CD" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_COST" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT	YD_CHR_CD" ).append("\n"); 
		query.append(", YD_FCTY_TP_MRN_TML_FLG" ).append("\n"); 
		query.append(", YD_FCTY_TP_CY_FLG" ).append("\n"); 
		query.append(", YD_FCTY_TP_CFS_FLG" ).append("\n"); 
		query.append(", YD_FCTY_TP_RAIL_RMP_FLG" ).append("\n"); 
		query.append("FROM	MDM_YARD" ).append("\n"); 
		query.append("WHERE	YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("AND		DELT_FLG	= 'N'" ).append("\n"); 
		query.append("AND		ROWNUM		= 1 ) Y" ).append("\n"); 
		query.append("WHERE	DECODE(Y.YD_CHR_CD||Y.YD_FCTY_TP_MRN_TML_FLG||Y.YD_FCTY_TP_CY_FLG, 'NYY',MRN_TML_FLG,'NYN',MRN_TML_FLG,'FYY',FDCK_CY_FLG,'FNY',FDCK_CY_FLG ) = 'Y'" ).append("\n"); 
		query.append("AND		CFS_FLG      IN (DECODE(Y.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("AND		RAIL_RMP_FLG IN (DECODE(Y.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 

	}
}