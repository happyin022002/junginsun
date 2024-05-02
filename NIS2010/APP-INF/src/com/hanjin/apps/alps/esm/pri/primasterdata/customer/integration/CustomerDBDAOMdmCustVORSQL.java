/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerDBDAOMdmCustVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.01
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.04.01 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.customer.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerDBDAOMdmCustVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History---------------------------------------
	  * 2011.03.30 이행지 [CHM-201109659-01]  Loading Agent POA Attach(L/Agent section) 기능 개발요청
	  *                          - Customer 조회시 OTI Bond No, OTI License No. 가져와서 보여주기 위해 쿼리 수정
	  * </pre>
	  */
	public CustomerDBDAOMdmCustVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.customer.integration").append("\n"); 
		query.append("FileName : CustomerDBDAOMdmCustVORSQL").append("\n"); 
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
		query.append("SELECT /*+ rule */ A.CUST_CNT_CD||LPAD(A.CUST_SEQ, 6, '0') AS CUST_CD" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD" ).append("\n"); 
		query.append("     , LPAD(A.CUST_SEQ, 6, '0') AS CUST_SEQ" ).append("\n"); 
		query.append("     , A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , A.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD00697'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = A.RVIS_CNTR_CUST_TP_CD) AS RVIS_CNTR_CUST_TP_NM" ).append("\n"); 
		query.append("     , A.OFC_CD" ).append("\n"); 
		query.append("     , A.SREP_CD" ).append("\n"); 
		query.append("     , CASE WHEN A.VBS_CLSS_CD <> '99' " ).append("\n"); 
		query.append("            THEN (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("                    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                   WHERE INTG_CD_ID = 'CD00698'" ).append("\n"); 
		query.append("                     AND INTG_CD_VAL_CTNT = A.VBS_CLSS_CD)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("       END VBS_CLSS_NM" ).append("\n"); 
		query.append("     , A.LOC_CD" ).append("\n"); 
		query.append("     , B.BZET_ADDR ||' '||B.CTY_NM||DECODE(B.STE_CD||B.ZIP_CD,'','',', '||B.STE_CD||' '||B.ZIP_CD) BZET_ADDR" ).append("\n"); 
		query.append("	 , A.NVOCC_BD_NO" ).append("\n"); 
		query.append("	 , A.NVOCC_LIC_NO" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER A" ).append("\n"); 
		query.append("     , MDM_CUST_ADDR B" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND (A.SLS_DELT_EFF_DT IS NULL OR A.SLS_DELT_EFF_DT > TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("   AND A.CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '') " ).append("\n"); 
		query.append("   AND A.CUST_SEQ = LPAD(@[cust_seq], 6, '0')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("   AND A.CUST_LGL_ENG_NM LIKE '%' || UPPER(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${nmd_cust_flg} == 'N')" ).append("\n"); 
		query.append("   AND (A.NMD_CUST_FLG IS NULL OR A.NMD_CUST_FLG <> 'Y')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.CUST_CNT_CD(+) = A.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND B.CUST_SEQ(+) = A.CUST_SEQ" ).append("\n"); 
		query.append("   AND B.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 

	}
}