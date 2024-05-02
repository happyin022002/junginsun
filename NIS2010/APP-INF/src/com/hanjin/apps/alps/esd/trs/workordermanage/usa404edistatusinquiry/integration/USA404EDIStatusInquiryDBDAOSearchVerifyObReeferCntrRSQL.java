/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOSearchVerifyObReeferCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.08.05 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOSearchVerifyObReeferCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * O/B Reefer Container No가 다 있는지 조회 SQL
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOSearchVerifyObReeferCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspSoSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspSoOfcCtyCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOSearchVerifyObReeferCntrRSQL").append("\n"); 
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
		query.append("A.TRSP_SO_OFC_CTY_CD		TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ				TRSP_SO_SEQ," ).append("\n"); 
		query.append("A.EQ_NO						EQ_NO," ).append("\n"); 
		query.append("SUBSTR(A.EQ_TPSZ_CD,1,1) 	EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.TRSP_BND_CD 				TRSP_BND_CD," ).append("\n"); 
		query.append("A.CGO_TP_CD 				CGO_TP_CD," ).append("\n"); 
		query.append("RF.BKG_NO					BKG_NO," ).append("\n"); 
		query.append("NVL(COUNT(RF.CNTR_NO),0)	RF_COUNT," ).append("\n"); 
		query.append("NVL(COUNT(C.CNTR_NO),0)		C_COUNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD A," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_VNDR_SET B," ).append("\n"); 
		query.append("BKG_RF_CGO RF," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("RFN.BKG_NO," ).append("\n"); 
		query.append("RFN.CNTR_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_RF_CGO	RFN" ).append("\n"); 
		query.append("WHERE	(RFN.BKG_NO) =" ).append("\n"); 
		query.append("(SELECT SO.BKG_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("WHERE SO.TRSP_SO_OFC_CTY_CD = @[trspSoOfcCtyCd]" ).append("\n"); 
		query.append("AND SO.TRSP_SO_SEQ = @[trspSoSeq])" ).append("\n"); 
		query.append("AND		RFN.CNTR_NO IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("RFN.BKG_NO," ).append("\n"); 
		query.append("RFN.CNTR_NO" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE	A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND		A.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND		A.BKG_NO = RF.BKG_NO" ).append("\n"); 
		query.append("AND		A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND		A.TRSP_SO_OFC_CTY_CD = @[trspSoOfcCtyCd]" ).append("\n"); 
		query.append("AND		A.TRSP_SO_SEQ = @[trspSoSeq]" ).append("\n"); 
		query.append("AND		A.CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND		A.TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("AND		B.VNDR_SEQ = 105475" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ," ).append("\n"); 
		query.append("A.EQ_NO," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.TRSP_BND_CD," ).append("\n"); 
		query.append("A.CGO_TP_CD," ).append("\n"); 
		query.append("RF.BKG_NO," ).append("\n"); 
		query.append("B.VNDR_SEQ" ).append("\n"); 

	}
}