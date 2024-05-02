/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalDBDAOModifyFFCmpnCSRACMBkgInfoUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier :
*@LastVersion : 1.0
* 2012.05.22
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnApprovalDBDAOModifyFFCmpnCSRACMBkgInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ModifyFFCmpnDetail
	  * </pre>
	  */
	public FFCmpnApprovalDBDAOModifyFFCmpnCSRACMBkgInfoUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration").append("\n");
		query.append("FileName : FFCmpnApprovalDBDAOModifyFFCmpnCSRACMBkgInfoUSQL").append("\n");
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
		query.append("/* UPDATE AGT_COMM_BKG_INFO */" ).append("\n");
		query.append("UPDATE ACM_AGN_BKG_INFO " ).append("\n");
		query.append("   SET REV_VVD_CD = @[dtrb_coa_vvd_cd]" ).append("\n");
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n");

	}
}