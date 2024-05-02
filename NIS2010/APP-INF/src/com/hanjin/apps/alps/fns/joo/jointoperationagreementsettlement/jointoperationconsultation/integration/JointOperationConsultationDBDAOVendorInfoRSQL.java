/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationDBDAOVendorInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.18 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOVendorInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor 정보조회
	  * </pre>
	  */
	public JointOperationConsultationDBDAOVendorInfoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select" ).append("\n"); 
		query.append("vndr_seq as code," ).append("\n"); 
		query.append("vndr_lgl_eng_nm as name," ).append("\n"); 
		query.append("rgst_no as spl_rgst_no," ).append("\n"); 
		query.append("vndr_seq," ).append("\n"); 
		query.append("vndr_locl_lang_nm as co_nm," ).append("\n"); 
		query.append("ceo_nm as ownr_nm," ).append("\n"); 
		query.append("bzct_nm," ).append("\n"); 
		query.append("bztp_nm," ).append("\n"); 
		query.append("locl_lang_addr" ).append("\n"); 
		query.append("from   mdm_vendor" ).append("\n"); 
		query.append("where  delt_flg = 'N'" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("and   vndr_seq = to_number(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOVendorInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}