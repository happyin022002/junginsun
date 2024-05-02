/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationDBDAOGetMinMovementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetMinMovementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getMinMovement
	  * </pre>
	  */
	public DMTCalculationDBDAOGetMinMovementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnms_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_split",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetMinMovementRSQL").append("\n"); 
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
		query.append("SELECT	 /*+ INDEX_DESC( M XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("			M.CNMV_YR		MIN_CNMV_YY," ).append("\n"); 
		query.append("			M.CNMV_SEQ		MIN_CNMV_SEQ," ).append("\n"); 
		query.append("			M.CNMV_SPLIT_NO	MIN_CNMV_SPLIT," ).append("\n"); 
		query.append("			M.MVMT_STS_CD	MIN_CNMS_CD," ).append("\n"); 
		query.append("			M.ORG_YD_CD		MIN_ORG_YD_CD," ).append("\n"); 
		query.append("			TO_CHAR(M.CNMV_EVNT_DT, 'YYYYMMDDHH24MI')	MIN_CNMV_DT_TM" ).append("\n"); 
		query.append("	FROM	CTM_MOVEMENT	M" ).append("\n"); 
		query.append("	WHERE	M.CNTR_NO					=	@[cntr_no]" ).append("\n"); 
		query.append("    AND     M.CNMV_YR||TO_CHAR(M.CNMV_SEQ,'0000')||M.CNMV_SPLIT_NO < @[cnmv_yy]||TO_CHAR(TO_NUMBER(@[cnmv_seq]),'0000')||@[cnmv_split]  " ).append("\n"); 
		query.append("	AND		M.CNMV_CYC_NO				=	@[cnmv_cyc_no]" ).append("\n"); 
		query.append("	AND		M.MVMT_STS_CD				=	@[cnms_cd]" ).append("\n"); 
		query.append("	AND		SUBSTR(M.ORG_YD_CD,1,5)		=	DECODE	(" ).append("\n"); 
		query.append("													SUBSTR( @[yd_cd], 1, 3 )," ).append("\n"); 
		query.append("													'ALL', SUBSTR( M.ORG_YD_CD, 1, 5 )," ).append("\n"); 
		query.append("													SUBSTR( @[yd_cd] ,1, 5)" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("	AND		M.BKG_NO					=	DECODE	(" ).append("\n"); 
		query.append("													SUBSTR( @[bkg_no], 1, 3 )," ).append("\n"); 
		query.append("													'ALL', M.BKG_NO," ).append("\n"); 
		query.append("													@[bkg_no]" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("	AND		ROWNUM						=	1" ).append("\n"); 

	}
}