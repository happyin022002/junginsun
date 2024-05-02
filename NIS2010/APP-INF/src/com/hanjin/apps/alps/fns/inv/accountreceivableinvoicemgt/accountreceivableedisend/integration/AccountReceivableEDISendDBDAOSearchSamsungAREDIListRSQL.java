/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchSamsungAREDIListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchSamsungAREDIListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD와 Customer로 기 생성된 EDI 문서번호(message no) list를 조회한다.
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchSamsungAREDIListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchSamsungAREDIListRSQL").append("\n"); 
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
		query.append("SELECT B.BL_SRC_NO," ).append("\n"); 
		query.append("  B.SR_INV_NO," ).append("\n"); 
		query.append("  B.POR_CD," ).append("\n"); 
		query.append("  B.POL_CD," ).append("\n"); 
		query.append("  B.POD_CD," ).append("\n"); 
		query.append("  B.DEL_CD," ).append("\n"); 
		query.append("  B.INV_EDI_D2_QTY," ).append("\n"); 
		query.append("  B.INV_EDI_D4_QTY," ).append("\n"); 
		query.append("  B.INV_EDI_D5_QTY," ).append("\n"); 
		query.append("  B.INV_EDI_D7_QTY," ).append("\n"); 
		query.append("  B.INV_EDI_ETC_QTY," ).append("\n"); 
		query.append("  B.GRS_CNTR_WGT," ).append("\n"); 
		query.append("  B.GRS_CBM_CAPA," ).append("\n"); 
		query.append("  SUM(DECODE(C.CHG_CD, 'OFT', C.CHG_AMT, 0)) OFT_AMT," ).append("\n"); 
		query.append("  SUM(DECODE(C.CHG_CD, 'CMS', C.CHG_AMT, 0)) CMS_AMT," ).append("\n"); 
		query.append("  SUM(DECODE(C.CHG_CD, 'THC', C.CHG_AMT, 'OTH', C.CHG_AMT, 'DTH', C.CHG_AMT, 0)) THC_AMT,  " ).append("\n"); 
		query.append("  --SUM(DECODE(C.CHG_CD, 'OTH', C.CHG_AMT, 0)) THC_AMT, --2010.04.16 OTH로 변경 이상희과장요청-->다시 THC로 변경" ).append("\n"); 
		query.append("  SUM(DECODE(C.CHG_CD, 'DHF', C.CHG_AMT, 0)) DHF_AMT," ).append("\n"); 
		query.append("  SUM(DECODE(C.CHG_CD, 'WHF', C.CHG_AMT, 0)) WHF_AMT," ).append("\n"); 
		query.append("  SUM(DECODE(C.CHG_CD, 'O/F', C.CHG_AMT, 0)) OTR_AMT," ).append("\n"); 
		query.append("  --SUM(DECODE(C.CHG_CD, 'CFR', C.CHG_AMT, 0)) CFR_AMT, -- 항목삭제" ).append("\n"); 
		query.append("  --SUM(DECODE(C.CHG_CD, 'BAF', C.CHG_AMT, 0)) BAF_AMT, -- 항목삭제" ).append("\n"); 
		query.append("  SUM(DECODE(C.CHG_CD, 'SLF', C.CHG_AMT, 0)) SLF_AMT,     -- 2011.05.23 추가" ).append("\n"); 
		query.append("  SUM(DECODE(C.CHG_CD, 'XXX', C.CHG_AMT, 0)) OTH_AMT," ).append("\n"); 
		query.append("  B.SND_FLG," ).append("\n"); 
		query.append("  B.BL_CNTR_GRP_CTNT" ).append("\n"); 
		query.append("FROM INV_AR_EDI_GERP_HDR A," ).append("\n"); 
		query.append("  INV_AR_EDI_GERP_BL B," ).append("\n"); 
		query.append("  INV_AR_EDI_GERP_CHG C" ).append("\n"); 
		query.append("WHERE A.MSG_ID = B.MSG_ID" ).append("\n"); 
		query.append("  AND A.MSG_NO = B.MSG_NO" ).append("\n"); 
		query.append("  AND B.MSG_ID = C.MSG_ID" ).append("\n"); 
		query.append("  AND B.MSG_NO = C.MSG_NO" ).append("\n"); 
		query.append("  AND B.BL_LINE_NO = C.BL_LINE_NO" ).append("\n"); 
		query.append("  AND B.BL_SRC_NO = C.BL_SRC_NO" ).append("\n"); 
		query.append("  AND A.MSG_ID = @[msg_id]" ).append("\n"); 
		query.append("  AND A.MSG_NO = @[msg_no]" ).append("\n"); 
		query.append("GROUP BY B.BL_SRC_NO, B.SR_INV_NO, B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD, B.INV_EDI_D2_QTY, B.INV_EDI_D4_QTY, B.INV_EDI_D5_QTY, B.INV_EDI_D7_QTY, B.INV_EDI_ETC_QTY, B.GRS_CNTR_WGT, B.GRS_CBM_CAPA, B.SND_FLG, B.BL_CNTR_GRP_CTNT" ).append("\n"); 
		query.append("ORDER BY B.BL_CNTR_GRP_CTNT, B.POR_CD, B.BL_SRC_NO" ).append("\n"); 

	}
}