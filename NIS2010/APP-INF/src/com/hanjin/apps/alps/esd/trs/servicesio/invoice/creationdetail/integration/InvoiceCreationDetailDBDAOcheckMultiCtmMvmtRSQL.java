/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOcheckMultiCtmMvmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDetailDBDAOcheckMultiCtmMvmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 cntr의 MVM를 체크한다
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOcheckMultiCtmMvmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WoVndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TrspWoOfcCtyCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BndCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EqNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TrspWoSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOcheckMultiCtmMvmtRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN @[BndCd] = 'O' AND " ).append("\n"); 
		query.append("                (SELECT COUNT(CNTR_NO) " ).append("\n"); 
		query.append("                 FROM CTM_MOVEMENT " ).append("\n"); 
		query.append("                 WHERE CNTR_NO = BCN.CNTR_NO " ).append("\n"); 
		query.append("                 AND CNMV_CYC_NO = BCN.CNMV_CYC_NO " ).append("\n"); 
		query.append("                 AND MVMT_STS_CD IN ('OC','VL','VD','TS')) < 1 THEN 'Y'" ).append("\n"); 
		query.append("            WHEN @[BndCd] = 'I' AND " ).append("\n"); 
		query.append("                (SELECT COUNT(CNTR_NO) " ).append("\n"); 
		query.append("                 FROM CTM_MOVEMENT " ).append("\n"); 
		query.append("                 WHERE CNTR_NO = BCN.CNTR_NO " ).append("\n"); 
		query.append("                 AND CNMV_CYC_NO = BCN.CNMV_CYC_NO " ).append("\n"); 
		query.append("                 AND MVMT_STS_CD = 'MT') < 1 THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END  CnmvStsFlg" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SVC" ).append("\n"); 
		query.append("    ,BKG_CONTAINER BCN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SVC.BKG_NO = BCN.BKG_NO" ).append("\n"); 
		query.append("AND SVC.EQ_NO = BCN.CNTR_NO" ).append("\n"); 
		query.append("AND SVC.TRSP_WO_OFC_CTY_CD = @[TrspWoOfcCtyCd]" ).append("\n"); 
		query.append("AND SVC.TRSP_WO_SEQ = @[TrspWoSeq]" ).append("\n"); 
		query.append("AND SVC.VNDR_SEQ = @[WoVndrSeq]" ).append("\n"); 
		query.append("AND BCN.BKG_NO = @[BkgNo]" ).append("\n"); 
		query.append("AND BCN.CNTR_NO = @[EqNo]" ).append("\n"); 
		query.append("AND SVC.DELT_FLG = 'N'" ).append("\n"); 

	}
}