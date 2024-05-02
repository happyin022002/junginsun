/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOCtmCCLMVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.24 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOCtmCCLMVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOCtmCCLMVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOCtmCCLMVORSQL").append("\n"); 
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
		query.append("SELECT FULL_MTY_CD, CLM_SGHT_ABBR_NM, ARR_LOC_NM, ARR_STE_CD, TO_CHAR(ARR_DT, 'YYYY-MM-DD HH24:MI') ARR_DT," ).append("\n"); 
		query.append("CLM_CRR_NM, TRSP_MOD_TP_CD, DEP_LOC_NM, DEP_STE_CD, TO_CHAR(DEP_DT, 'YYYY-MM-DD HH24:MI') DEP_DT, TRN_NO," ).append("\n"); 
		query.append("FCAR_NO" ).append("\n"); 
		query.append("FROM SCE_CLM CLM, SCE_CLM_SGHT SGT" ).append("\n"); 
		query.append("WHERE CLM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND CLM.CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("AND CLM.CNMV_ID_NO = @[cnmv_id_no]" ).append("\n"); 
		query.append("AND CLM.CLM_SGHT_CD = SGT.CLM_SGHT_CD" ).append("\n"); 

	}
}