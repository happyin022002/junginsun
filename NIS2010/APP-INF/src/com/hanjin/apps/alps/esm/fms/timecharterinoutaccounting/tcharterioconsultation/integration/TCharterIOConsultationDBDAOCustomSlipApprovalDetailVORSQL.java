/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOCustomSlipApprovalDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.09.03 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOCustomSlipApprovalDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Detail 테이블에 저장시 필요한 VO
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOCustomSlipApprovalDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOCustomSlipApprovalDetailVORSQL").append("\n"); 
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
		query.append("'' CSR_NO" ).append("\n"); 
		query.append(", '' LINE_SEQ" ).append("\n"); 
		query.append(", '' LINE_NO" ).append("\n"); 
		query.append(", '' LINE_TP_LU_CD" ).append("\n"); 
		query.append(", '' INV_AMT" ).append("\n"); 
		query.append(", '' INV_DESC" ).append("\n"); 
		query.append(", '' INV_TAX_CD" ).append("\n"); 
		query.append(", '' DTRB_COA_CO_CD" ).append("\n"); 
		query.append(", '' DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(", '' DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(", '' DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(", '' DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(", '' DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(", '' DTRB_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(", '' DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(", '' ATTR_CATE_NM" ).append("\n"); 
		query.append(", '' ATTR_CTNT1" ).append("\n"); 
		query.append(", '' ATTR_CTNT2" ).append("\n"); 
		query.append(", '' ATTR_CTNT3" ).append("\n"); 
		query.append(", '' ATTR_CTNT4" ).append("\n"); 
		query.append(", '' ATTR_CTNT5" ).append("\n"); 
		query.append(", '' ATTR_CTNT6" ).append("\n"); 
		query.append(", '' ATTR_CTNT7" ).append("\n"); 
		query.append(", '' ATTR_CTNT8" ).append("\n"); 
		query.append(", '' ATTR_CTNT9" ).append("\n"); 
		query.append(", '' ATTR_CTNT10" ).append("\n"); 
		query.append(", '' ATTR_CTNT11" ).append("\n"); 
		query.append(", '' ATTR_CTNT12" ).append("\n"); 
		query.append(", '' ATTR_CTNT13" ).append("\n"); 
		query.append(", '' ATTR_CTNT14" ).append("\n"); 
		query.append(", '' ATTR_CTNT15" ).append("\n"); 
		query.append(", '' BKG_NO" ).append("\n"); 
		query.append(", '' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", '' ACT_VVD_CD" ).append("\n"); 
		query.append(", '' PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append(", '' SO_CRR_CD" ).append("\n"); 
		query.append(", '' YD_CD" ).append("\n"); 
		query.append(", '' FTU_USE_CTNT1" ).append("\n"); 
		query.append(", '' FTU_USE_CTNT2" ).append("\n"); 
		query.append(", '' FTU_USE_CTNT3" ).append("\n"); 
		query.append(", '' FTU_USE_CTNT4" ).append("\n"); 
		query.append(", '' FTU_USE_CTNT5" ).append("\n"); 
		query.append(", '' CRE_DT" ).append("\n"); 
		query.append(", '' CRE_USR_ID" ).append("\n"); 
		query.append(", '' EAI_EVNT_DT" ).append("\n"); 
		query.append(", '' TRSP_SO_TP_CD" ).append("\n"); 
		query.append(", '' SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", '' SO_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}