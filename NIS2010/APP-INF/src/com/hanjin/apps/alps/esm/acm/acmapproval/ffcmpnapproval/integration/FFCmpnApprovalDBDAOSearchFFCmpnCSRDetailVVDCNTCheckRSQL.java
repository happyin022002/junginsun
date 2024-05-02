/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailVVDCNTCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.03 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailVVDCNTCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFFCmpnCSRDetailVVDCNTCheck
	  * </pre>
	  */
	public FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailVVDCNTCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration").append("\n"); 
		query.append("FileName : FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailVVDCNTCheckRSQL").append("\n"); 
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
		query.append("/* GET VVD_COUNT */" ).append("\n"); 
		query.append("SELECT COUNT(*) AS VVD_COUNT" ).append("\n"); 
		query.append("  FROM ar_rout_rnk" ).append("\n"); 
		query.append(" WHERE rlane_cd = (SELECT rlane_cd" ).append("\n"); 
		query.append("                     FROM ACM_AGN_BKG_INFO" ).append("\n"); 
		query.append("                    WHERE bkg_no = @[bkg_no])" ).append("\n"); 

	}
}