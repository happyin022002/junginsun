/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementCondDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementCondDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPS Agreement 에 해당하는 Condition 정보를 CGM_AGMT_CPS_COND 에서 조회한다.
	  * 1. 2014-07-18 ST_STOP_YD_FLG  추가 (Start/Stop Flag), 신용찬
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementCondDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementCondDataRSQL").append("\n"); 
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
		query.append("SELECT A.YD_CD," ).append("\n"); 
		query.append("       B.YD_NM," ).append("\n"); 
		query.append("       A.CHSS_YD_TP_CD," ).append("\n"); 
		query.append("       A.LR_LOC_NM," ).append("\n"); 
		query.append("       A.ST_STOP_YD_FLG," ).append("\n"); 
		query.append("       A.DMST_ON_TML_CHG_FLG," ).append("\n"); 
		query.append("       A.DMST_PD_CHG_FLG," ).append("\n"); 
		query.append("       A.ON_TML_CHG_FLG," ).append("\n"); 
		query.append("       A.ON_TML_MTY_CHG_FLG," ).append("\n"); 
		query.append("       A.BILABL_SPCL_CNTR_TP_NM," ).append("\n"); 
		query.append("       A.AGMT_RMK," ).append("\n"); 
		query.append("       A.DDCT_TP_CD" ).append("\n"); 
		query.append("FROM CGM_AGMT_CPS_COND A" ).append("\n"); 
		query.append("    ,MDM_YARD B" ).append("\n"); 
		query.append("WHERE A.YD_CD           = B.YD_CD" ).append("\n"); 
		query.append("AND   A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ        = @[agmt_seq]" ).append("\n"); 
		query.append("#if (${agmt_ver_no} != '')" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO       = @[agmt_ver_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.AGMT_VER_NO" ).append("\n"); 

	}
}