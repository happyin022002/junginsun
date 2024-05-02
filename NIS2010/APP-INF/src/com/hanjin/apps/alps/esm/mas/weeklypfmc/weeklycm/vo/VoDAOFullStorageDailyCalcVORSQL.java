/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VoDAOFullStorageDailyCalcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.04.21 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoDAOFullStorageDailyCalcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Cost Report by BKG의 VO 객체를 생성한다.
	  * </pre>
	  */
	public VoDAOFullStorageDailyCalcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo").append("\n"); 
		query.append("FileName : VoDAOFullStorageDailyCalcVORSQL").append("\n"); 
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
		query.append("SELECT      " ).append("\n"); 
		query.append("		'' AS CNEE_CD,                    " ).append("\n"); 
		query.append("		'' AS POR_CD,                     " ).append("\n"); 
		query.append("		'' AS BKG_BND,                    " ).append("\n"); 
		query.append("		'' AS STO_TO_DT,                  " ).append("\n"); 
		query.append("		'' AS CURR_CD,                    " ).append("\n"); 
		query.append("		'' AS STO_CALC_STS,               " ).append("\n"); 
		query.append("		'' AS SC_CUST_SEQ,                " ).append("\n"); 
		query.append("		'' AS LOCL_TS,                    " ).append("\n"); 
		query.append("		'' AS F_STO_STS,                 " ).append("\n"); 
		query.append("		'' AS COND_TYPE,                  " ).append("\n"); 
		query.append("		'' AS RFA_NO,                     " ).append("\n"); 
		query.append("		'' AS POL_CD,                     " ).append("\n"); 
		query.append("		'' AS F_STO_TYPE,                 " ).append("\n"); 
		query.append("		'' AS STAY_DYS,                   " ).append("\n"); 
		query.append("		'' AS YD_CHR,                     " ).append("\n"); 
		query.append("		'' AS COST_CD,                    " ).append("\n"); 
		query.append("		'' AS SC_NO,                      " ).append("\n"); 
		query.append("		'' AS CNTR_TPSZ_CD,               " ).append("\n"); 
		query.append("		'' AS FREE_XCLD_DYS,              " ).append("\n"); 
		query.append("		'' AS RCV_TERM_CD,                " ).append("\n"); 
		query.append("		'' AS SHPR_CD,                    " ).append("\n"); 
		query.append("		'' AS STO_TO_NOD,                 " ).append("\n"); 
		query.append("		'' AS DFLT_VNDR_SEQ,              " ).append("\n"); 
		query.append("		'' AS STO_FM_MVMT,                " ).append("\n"); 
		query.append("		'' AS DEL_CD,                     " ).append("\n"); 
		query.append("		'' AS STO_TTL_AMT,                " ).append("\n"); 
		query.append("		'' AS CAL_SRC,                    " ).append("\n"); 
		query.append("		'' AS STO_FM_DT,                  " ).append("\n"); 
		query.append("		'' AS NTFY_CD,                    " ).append("\n"); 
		query.append("		'' AS RFA_CUST_SEQ,               " ).append("\n"); 
		query.append("		'' AS POD_CD,                     " ).append("\n"); 
		query.append("		'' AS DE_TERM_CD,                 " ).append("\n"); 
		query.append("		'' AS OFC_CD,                     " ).append("\n"); 
		query.append("		'' AS USD_AMT,                    " ).append("\n"); 
		query.append("		'' AS BKG_NO,                     " ).append("\n"); 
		query.append("		'' AS FREE_DYS,                   " ).append("\n"); 
		query.append("		'' AS CNTR_NO,                    " ).append("\n"); 
		query.append("		'' AS STO_TO_MVMT,                " ).append("\n"); 
		query.append("		'' AS REV_MON,                    " ).append("\n"); 
		query.append("		'' AS STO_FM_NOD,                 " ).append("\n"); 
		query.append("		'' AS OVR_DYS,                    " ).append("\n"); 
		query.append("		'' AS NOD_TP,    " ).append("\n"); 
		query.append("		'' AS NOD_BND," ).append("\n"); 
		query.append("		'' AS DG_CLSS," ).append("\n"); 
		query.append("		'' AS TES_CALC" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}