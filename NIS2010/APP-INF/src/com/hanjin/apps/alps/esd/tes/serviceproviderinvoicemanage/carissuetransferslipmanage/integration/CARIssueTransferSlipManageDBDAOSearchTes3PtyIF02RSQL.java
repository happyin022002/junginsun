/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchTes3PtyIF02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.04.21 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOSearchTes3PtyIF02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTes3PtyIF02
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchTes3PtyIF02RSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchTes3PtyIF02RSQL").append("\n"); 
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
		query.append("SELECT tml_if_ofc_cd, tml_if_seq FROM tes_n3rd_pty_if" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("inv_no			= @[inv_no]" ).append("\n"); 
		query.append("AND vndr_seq	= @[vndr_seq]" ).append("\n"); 
		query.append("AND	tml_so_ofc_cty_cd	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND tml_so_seq			= @[tml_so_seq]" ).append("\n"); 
		query.append("--TPB로 넘길 데이타를 조회할때.. tml_n3pty_if_sts_cd 'N' 인 값만 조회해서 넘기는것 추가할것 (2009-09-30)" ).append("\n"); 
		query.append("AND tml_n3pty_if_sts_cd = 'N'" ).append("\n"); 

	}
}