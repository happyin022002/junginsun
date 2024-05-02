/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ServiceDBDAOSearchRlaneCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOSearchRlaneCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue Lane Code에 대한 상세 정보 조회 쿼리
	  * </pre>
	  */
	public ServiceDBDAOSearchRlaneCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOSearchRlaneCodeRSQL").append("\n"); 
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
		query.append("SELECT REV.RLANE_CD " ).append("\n"); 
		query.append("	  ,REV.RLANE_NM" ).append("\n"); 
		query.append("      ,REV.VSL_TP_CD" ).append("\n"); 
		query.append("      ,REV.REP_TRD_CD" ).append("\n"); 
		query.append("      ,REV.VSL_SLAN_CD" ).append("\n"); 
		query.append("      ,REV.MODI_RLANE_CD" ).append("\n"); 
		query.append("      ,DTL.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("      ,DTL.IOC_CD" ).append("\n"); 
		query.append("      ,DTL.TRD_CD" ).append("\n"); 
		query.append("      ,DTL.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,DTL.FM_CONTI_CD" ).append("\n"); 
		query.append("      ,DTL.TO_CONTI_CD" ).append("\n"); 
		query.append("      ,DTL.DELT_FLG DTL_DELT_FLG" ).append("\n"); 
		query.append("      ,REV.DELT_FLG" ).append("\n"); 
		query.append("      --,DTL.DMNT_LEG_FLG" ).append("\n"); 
		query.append("#if(${dtl_flg} == 'Y')" ).append("\n"); 
		query.append("      ,DTL.CRE_USR_ID" ).append("\n"); 
		query.append("      ,DTL.CRE_DT" ).append("\n"); 
		query.append("      ,DTL.UPD_USR_ID" ).append("\n"); 
		query.append("      ,DTL.UPD_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,REV.CRE_USR_ID" ).append("\n"); 
		query.append("      ,REV.CRE_DT" ).append("\n"); 
		query.append("      ,REV.UPD_USR_ID" ).append("\n"); 
		query.append("      ,REV.UPD_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM MDM_REV_LANE REV" ).append("\n"); 
		query.append("      ,MDM_DTL_REV_LANE DTL" ).append("\n"); 
		query.append(" WHERE REV.RLANE_CD = DTL.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND REV.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append(" ORDER BY DTL_DELT_FLG" ).append("\n"); 

	}
}