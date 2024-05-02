/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchOtsGrpInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOSearchOtsGrpInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOtsGrpInfo
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchOtsGrpInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_detail_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchOtsGrpInfoRSQL").append("\n"); 
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
		query.append("SELECT COUNT(DISTINCT N3PTY_EXPN_TP_CD) AS LENGTH_N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append(",MAX(N3PTY_EXPN_TP_CD) AS N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append(",COUNT(DISTINCT N3PTY_BIL_TP_CD) AS LENGTH_N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(",MAX(N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(",COUNT(DISTINCT NVL(VSL_CD||SKD_VOY_NO||FINC_DIR_CD,'-')) AS LENGTH_REV_VVD" ).append("\n"); 
		query.append(",MAX(VSL_CD||SKD_VOY_NO||FINC_DIR_CD) AS REV_VVD" ).append("\n"); 
		query.append(",COUNT(DISTINCT CFM_CURR_CD) AS LENGTH_CURR_CD" ).append("\n"); 
		query.append(",MAX(CFM_CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append(",COUNT(DISTINCT VNDR_SEQ||CUST_CNT_CD||CUST_SEQ) AS LENGTH_TRD_PARTY" ).append("\n"); 
		query.append(",MAX(VNDR_SEQ||CUST_CNT_CD||CUST_SEQ) AS TRD_PARTY" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL" ).append("\n"); 
		query.append("WHERE N3PTY_NO = @[s_detail_n3pty_no]" ).append("\n"); 

	}
}