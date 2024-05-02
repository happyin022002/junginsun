/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MRIInquiryDBDAOMultiMRIInquiryMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MRIInquiryDBDAOMultiMRIInquiryMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2017.05.15 송민석 ERP MAS의 Phase out에 따라 영향 받는 화면에 대한 수정 프로젝트 1차
	  * </pre>
	  */
	public MRIInquiryDBDAOMultiMRIInquiryMonthCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.integration").append("\n"); 
		query.append("FileName : MRIInquiryDBDAOMultiMRIInquiryMonthCopyCSQL").append("\n"); 
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
		query.append("INSERT  INTO MAS_MON_MISC_REV_PRE_TEU (" ).append("\n"); 
		query.append("REV_YRMON" ).append("\n"); 
		query.append(", TRD_CD" ).append("\n"); 
		query.append(", DIR_CD" ).append("\n"); 
		query.append(", RLANE_CD" ).append("\n"); 
		query.append(", TRD_TTL_AMT" ).append("\n"); 
		query.append(", TRD_TTL_QTY" ).append("\n"); 
		query.append(", ETC_UT_REV_AMT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[f_tar_mon] as COST_YRMON" ).append("\n"); 
		query.append("    , TRD_CD" ).append("\n"); 
		query.append("    , DIR_CD" ).append("\n"); 
		query.append("    , RLANE_CD" ).append("\n"); 
		query.append("    , TRD_TTL_AMT" ).append("\n"); 
		query.append("    , TRD_TTL_QTY" ).append("\n"); 
		query.append("    , ETC_UT_REV_AMT" ).append("\n"); 
		query.append("        , @[user_id] CRE_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE CRE_DT" ).append("\n"); 
		query.append("        , @[user_id] UPD_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM MAS_MON_MISC_REV_PRE_TEU" ).append("\n"); 
		query.append(" WHERE REV_YRMON = @[f_src_mon]" ).append("\n"); 

	}
}