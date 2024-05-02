/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchTAXDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.11.19 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOSearchTAXDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTAXDetail
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchTAXDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("compNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchTAXDetailRSQL").append("\n"); 
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
		query.append("SELECT DECODE(vndr_cnt_cd,'KR',vndr_locl_lang_nm, vndr_lgl_eng_nm) vndr_nm," ).append("\n"); 
		query.append("bzct_nm," ).append("\n"); 
		query.append("bztp_nm," ).append("\n"); 
		query.append("DECODE(vndr_cnt_cd,'KR',locl_lang_addr, eng_addr) vndr_addr," ).append("\n"); 
		query.append("vndr_seq," ).append("\n"); 
		query.append("ceo_nm" ).append("\n"); 
		query.append("FROM   mdm_vendor" ).append("\n"); 
		query.append("WHERE  rgst_no = @[compNo]" ).append("\n"); 

	}
}