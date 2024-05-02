/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAOModifyHdrDescUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.05.22 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtDBDAOModifyHdrDescUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyHdrDesc
	  * 2010.10.18 김영철 [CHM-201006348-01] CSR 전표 Remark 보완 - INV_DESC 추가
	  * </pre>
	  */
	public ConsultationSlipRequestMgtDBDAOModifyHdrDescUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration").append("\n"); 
		query.append("FileName : ConsultationSlipRequestMgtDBDAOModifyHdrDescUSQL").append("\n"); 
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
		query.append("UPDATE AP_INV_HDR" ).append("\n"); 
		query.append("   SET INV_DESC = NVL(( SELECT DECODE(NVL(B.INV_DESC,''),'','','CANAL FEE/'||B.PORT_CD||'/'||B.INV_DESC) INV_DESC" ).append("\n"); 
		query.append("                          FROM AP_PAY_INV A, AP_PAY_INV_DTL B" ).append("\n"); 
		query.append("                         WHERE A.INV_RGST_NO = B.INV_RGST_NO" ).append("\n"); 
		query.append("                           AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                           AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                           AND B.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                           AND B.ACCT_CD = '110911'" ).append("\n"); 
		query.append("                           AND A.PSO_TRNS_SLP_CTNT = 'GO'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1  )" ).append("\n"); 
		query.append("                       ,INV_DESC" ).append("\n"); 
		query.append("				      )" ).append("\n"); 
		query.append(" WHERE CSR_NO = @[csr_no]" ).append("\n"); 

	}
}