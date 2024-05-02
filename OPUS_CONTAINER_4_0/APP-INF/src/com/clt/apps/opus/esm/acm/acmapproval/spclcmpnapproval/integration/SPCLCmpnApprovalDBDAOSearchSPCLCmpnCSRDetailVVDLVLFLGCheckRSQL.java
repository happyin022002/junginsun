/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRDetailVVDLVLFLGCheckRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.02
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.02 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRDetailVVDLVLFLGCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchSPCLCmpnCSRDetailVVDLVLFLGCheck
	  * </pre>
	  */
	public SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRDetailVVDLVLFLGCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration ").append("\n");
		query.append("FileName : SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRDetailVVDLVLFLGCheckRSQL").append("\n");
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
		query.append("/* GET VVD_LVL_FLG */" ).append("\n");
		query.append("SELECT NVL(DECODE(@[vvd_lvl],'1',VVD_LVL_FLG1, " ).append("\n");
		query.append("                    '2',VVD_LVL_FLG2,  " ).append("\n");
		query.append("                    '3',VVD_LVL_FLG3, " ).append("\n");
		query.append("                    '4',VVD_LVL_FLG4, " ).append("\n");
		query.append("                    '5',VVD_LVL_FLG5,VVD_LVL_FLG6),'N') AS VVD_LVL_FLG" ).append("\n");
		query.append("  FROM MDM_ACCOUNT " ).append("\n");
		query.append(" WHERE ACCT_CD = @[acct_cd]" ).append("\n");

	}
}