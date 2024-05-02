/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOCheckSearchConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOCheckSearchConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckSearchCondition
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOCheckSearchConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOCheckSearchConditionRSQL").append("\n"); 
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
		query.append("#if ((${mvmt_edi_msg_tp_id} == '' || ${mvmt_edi_msg_tp_id} == 'ALL')" ).append("\n"); 
		query.append("&& ${bkg_bl} == '' " ).append("\n"); 
		query.append("&& ${p_cntrno} == '' " ).append("\n"); 
		query.append("&& ${mvmt_edi_msg_area_cd} == '' " ).append("\n"); 
		query.append("&& ${cntr_tpsz_cd} == '' " ).append("\n"); 
		query.append("&& ${tml_nm} == '' " ).append("\n"); 
		query.append("&& ${lcc_cd} == '' " ).append("\n"); 
		query.append("&& ${rcc_cd} == '' " ).append("\n"); 
		query.append("&& ${vvd_value} == ''" ).append("\n"); 
		query.append("&& ${cntr_full_sts_cd} == ''" ).append("\n"); 
		query.append("&& ${flt_file_ref_no} == ''" ).append("\n"); 
		query.append("&& ${mty_pln_no} == ''" ).append("\n"); 
		query.append("&& ${mvmt_edi_rmk} == '')" ).append("\n"); 
		query.append("SELECT 1 AS RESULT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT 0 AS RESULT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}