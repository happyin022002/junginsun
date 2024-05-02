/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IncomeMgtDBDAOsearchReceivableInvoiceDetailListByDisposalDataRSQL.java
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

public class IncomeMgtDBDAOsearchReceivableInvoiceDetailListByDisposalDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncomeMgtDBDAOsearchReceivableInvoiceDetailListByDisposalDataRSQL
	  * </pre>
	  */
	public IncomeMgtDBDAOsearchReceivableInvoiceDetailListByDisposalDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOsearchReceivableInvoiceDetailListByDisposalDataRSQL").append("\n"); 
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
		query.append("C.MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append(",A.DISP_NO" ).append("\n"); 
		query.append(",A.DISP_TP_CD" ).append("\n"); 
		query.append(",D.MNR_CD_DESC  DISP_TP_NM" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",B.DISP_DTL_SEQ" ).append("\n"); 
		query.append(",B.DISP_RLSE_NO" ).append("\n"); 
		query.append(",B.EQ_NO" ).append("\n"); 
		query.append(",B.DISP_QTY" ).append("\n"); 
		query.append(",B.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",B.PART_AMT INV_AMT" ).append("\n"); 
		query.append(",B.DISP_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(B.DISP_SOLD_DT , 'yyyy-mm-dd') DISP_SOLD_DT" ).append("\n"); 
		query.append(",B.MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append(",B.RCV_INV_SEQ" ).append("\n"); 
		query.append(",B.CRE_USR_ID" ).append("\n"); 
		query.append(",B.INV_NO" ).append("\n"); 
		query.append(",DECODE(B.RCV_INV_SEQ, '', 'SS','AI',B.EQ_NO,'','UE','AI') MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR A, MNR_DISP_DTL B, MNR_PARTNER C, MNR_GEN_CD D" ).append("\n"); 
		query.append("WHERE A.DISP_NO= B.DISP_NO" ).append("\n"); 
		query.append("AND B.MNR_PRNR_CNT_CD = C.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("AND B.MNR_PRNR_SEQ = C.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("AND B.MNR_PRNR_CNT_CD = @[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("AND B.MNR_PRNR_SEQ = TO_NUMBER(@[mnr_prnr_seq])" ).append("\n"); 
		query.append("#if (${dispNos} != '')" ).append("\n"); 
		query.append("	AND	A.DISP_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_dispNos IN ${dispNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $dispNos.size())" ).append("\n"); 
		query.append("				'$user_dispNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_dispNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND D.PRNT_CD_ID(+)='CD00035'" ).append("\n"); 
		query.append("	AND A.DISP_TP_CD = D.MNR_CD_ID(+)" ).append("\n"); 

	}
}