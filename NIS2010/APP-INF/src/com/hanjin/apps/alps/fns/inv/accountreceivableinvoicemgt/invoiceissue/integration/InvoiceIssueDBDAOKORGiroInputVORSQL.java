/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOKORGiroInputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.03.15 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOKORGiroInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDB
	  * </pre>
	  */
	public InvoiceIssueDBDAOKORGiroInputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("giro_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOKORGiroInputVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("A.AR_OFC_CD AR_OFC_CD                      -- Office" ).append("\n"); 
		query.append(", C.CUST_CNT_CD||'-'||LPAD(C.CUST_SEQ, 6, '0') CUST_CD          -- Cust Code" ).append("\n"); 
		query.append(", A.ISS_DT ISS_DT                            -- Issue Date" ).append("\n"); 
		query.append(", A.BL_SRC_NO BL_SRC_NO                      -- B/L NO" ).append("\n"); 
		query.append(", A.SPL_GIRO_AMT SPL_GIRO_AMT                -- 공급가액" ).append("\n"); 
		query.append(", A.SPL_GIRO_AMT+A.TVA_GIRO_AMT TOT_GIRO_AMT -- 총액" ).append("\n"); 
		query.append(", A.DUE_DT DUE_DT                            -- Due Date" ).append("\n"); 
		query.append(", NVL(D.LOCL_NM, C.CUST_LGL_ENG_NM) CUST_LGL_ENG_NM          -- Cust Name" ).append("\n"); 
		query.append(", A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD   -- VVD" ).append("\n"); 
		query.append(", A.GIRO_NO GIRO_NO                          -- GIRO No" ).append("\n"); 
		query.append(", A.TVA_GIRO_AMT TVA_GIRO_AMT                -- 세액" ).append("\n"); 
		query.append(", A.DELT_FLG DELT_FLG                        -- DEL Mark" ).append("\n"); 
		query.append("FROM INV_AR_GIRO A" ).append("\n"); 
		query.append(", MDM_CUSTOMER C" ).append("\n"); 
		query.append(", MDM_CR_CUST D" ).append("\n"); 
		query.append("WHERE A.ACT_CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = D.CUST_SEQ(+)" ).append("\n"); 
		query.append("#if (${iss_dt1} != '')" ).append("\n"); 
		query.append("AND A.ISS_DT BETWEEN REPLACE(@[iss_dt1],'-','') AND REPLACE(@[iss_dt2],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_ofc_cd2} != '')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("AND C.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${giro_no} != '')" ).append("\n"); 
		query.append("AND A.GIRO_NO = @[giro_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}