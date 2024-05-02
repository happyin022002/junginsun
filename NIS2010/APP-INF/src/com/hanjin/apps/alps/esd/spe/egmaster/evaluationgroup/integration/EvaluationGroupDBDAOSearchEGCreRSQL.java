/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupDBDAOSearchEGCreRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.26 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupDBDAOSearchEGCreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EG 데이터를 조회한다
	  * </pre>
	  */
	public EvaluationGroupDBDAOSearchEGCreRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.integration").append("\n"); 
		query.append("FileName : EvaluationGroupDBDAOSearchEGCreRSQL").append("\n"); 
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
		query.append("SELECT EG_ID" ).append("\n"); 
		query.append(",  EG_RHQ_CD " ).append("\n"); 
		query.append(",  EG_OFC_CD " ).append("\n"); 
		query.append(",  EV_SVC_CATE_CD " ).append("\n"); 
		query.append(",  EV_SVC_CATE_CD AS EV_SVC_CATE_CODE" ).append("\n"); 
		query.append(",  EG_NM " ).append("\n"); 
		query.append(",  DELT_FLG " ).append("\n"); 
		query.append(",  CRE_USR_ID " ).append("\n"); 
		query.append(",  CRE_DT " ).append("\n"); 
		query.append(",  UPD_USR_ID " ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append("  FROM SPE_EV_GRP" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${s_eg_rhq_cd}!='')" ).append("\n"); 
		query.append("   AND EG_RHQ_CD = @[s_eg_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_eg_ofc_cd}!='')" ).append("\n"); 
		query.append("   AND EG_OFC_CD = @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_ev_svc_cate_cd}!='')" ).append("\n"); 
		query.append("   AND EV_SVC_CATE_CD = @[s_ev_svc_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("order by EG_RHQ_CD,EG_ID desc,EG_OFC_CD,EV_SVC_CATE_CD" ).append("\n"); 

	}
}