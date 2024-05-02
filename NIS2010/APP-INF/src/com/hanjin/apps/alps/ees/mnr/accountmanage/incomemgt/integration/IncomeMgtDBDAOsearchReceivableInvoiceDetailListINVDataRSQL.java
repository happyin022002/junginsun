/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IncomeMgtDBDAOsearchReceivableInvoiceDetailListINVDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.01.21 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncomeMgtDBDAOsearchReceivableInvoiceDetailListINVDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncomeMgtDBDAOsearchReceivableInvoiceDetailListINVDataRSQL
	  * </pre>
	  */
	public IncomeMgtDBDAOsearchReceivableInvoiceDetailListINVDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOsearchReceivableInvoiceDetailListINVDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT C.MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MNR_PARTNER C" ).append("\n"); 
		query.append("WHERE B.MNR_PRNR_CNT_CD = C.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("AND B.MNR_PRNR_SEQ = C.MNR_PRNR_SEQ" ).append("\n"); 
		query.append(") MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append(",A.DISP_NO" ).append("\n"); 
		query.append(",A.DISP_TP_CD" ).append("\n"); 
		query.append(",E.MNR_CD_DESC  DISP_TP_NM" ).append("\n"); 
		query.append(",B.DISP_DTL_SEQ" ).append("\n"); 
		query.append(",B.DISP_RLSE_NO" ).append("\n"); 
		query.append(",B.EQ_NO" ).append("\n"); 
		query.append(",B.DISP_QTY" ).append("\n"); 
		query.append(",B.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",B.INV_AMT" ).append("\n"); 
		query.append(",B.DISP_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(B.DISP_SOLD_DT , 'yyyy-mm-dd') DISP_SOLD_DT" ).append("\n"); 
		query.append(",B.MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append(",B.RCV_INV_SEQ" ).append("\n"); 
		query.append(",'SS' MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR A, MNR_DISP_DTL B, MNR_RCV_INV_WRK D, MNR_GEN_CD E" ).append("\n"); 
		query.append("WHERE A.DISP_NO= B.DISP_NO" ).append("\n"); 
		query.append("#if (${invNos} != '')" ).append("\n"); 
		query.append("	AND	D.INV_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_invNos IN ${invNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("				'$user_invNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_invNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND D.RCV_INV_SEQ = B.RCV_INV_SEQ" ).append("\n"); 
		query.append("	AND E.PRNT_CD_ID(+)='CD00035'" ).append("\n"); 
		query.append("	AND A.DISP_TP_CD = E.MNR_CD_ID(+)" ).append("\n"); 

	}
}