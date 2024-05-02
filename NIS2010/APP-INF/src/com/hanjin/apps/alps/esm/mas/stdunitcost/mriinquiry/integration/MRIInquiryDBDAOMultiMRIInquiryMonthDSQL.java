/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MRIInquiryDBDAOMultiMRIInquiryMonthDSQL.java
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

public class MRIInquiryDBDAOMultiMRIInquiryMonthDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2017.05.15 송민석 ERP MAS의 Phase out에 따라 영향 받는 화면에 대한 수정 프로젝트 1차
	  * </pre>
	  */
	public MRIInquiryDBDAOMultiMRIInquiryMonthDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.integration").append("\n"); 
		query.append("FileName : MRIInquiryDBDAOMultiMRIInquiryMonthDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM  MAS_MON_MISC_REV_PRE_TEU  " ).append("\n"); 
		query.append("WHERE REV_YRMON= @[f_tar_mon]" ).append("\n"); 

	}
}