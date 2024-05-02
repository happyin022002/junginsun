/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAOPriSqRtCmdtGrpListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.18 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateQuotationDBDAOPriSqRtCmdtGrpListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CMDT_HDR_SEQ 별 Cmdt Grp 한줄로 합해서 조회
	  * </pre>
	  */
	public SCRateQuotationDBDAOPriSqRtCmdtGrpListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAOPriSqRtCmdtGrpListRSQL").append("\n"); 
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
		query.append("SELECT  A1.QTTN_NO" ).append("\n"); 
		query.append(",       A1.QTTN_VER_NO" ).append("\n"); 
		query.append(",       A1.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",       A1.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",       A1.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  QTTN_NO" ).append("\n"); 
		query.append(",       QTTN_VER_NO" ).append("\n"); 
		query.append(",       GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",       CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",       SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD, ' / ')),4) AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT   A.QTTN_NO" ).append("\n"); 
		query.append(",        A.QTTN_VER_NO" ).append("\n"); 
		query.append(",        A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",        A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",		 A.PRC_CMDT_DEF_CD AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",        ROW_NUMBER() OVER(PARTITION BY A.QTTN_NO, A.QTTN_VER_NO, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(A.PRC_CMDT_TP_CD, 'G','1','R','2','C','3'),  A.PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("A.QTTN_NO, A.QTTN_VER_NO, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ, A.CMDT_SEQ) AS RN" ).append("\n"); 
		query.append("FROM    PRI_SQ_RT_CMDT A" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND   A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND   A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND   A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY QTTN_NO" ).append("\n"); 
		query.append(",        QTTN_VER_NO" ).append("\n"); 
		query.append(",        GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",        CMDT_HDR_SEQ" ).append("\n"); 
		query.append(") A1" ).append("\n"); 
		query.append("ORDER BY A1.CMDT_HDR_SEQ" ).append("\n"); 

	}
}