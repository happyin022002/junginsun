/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeAgreementDBDAOAgentRateDetailInfoList06RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.03.29 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeAgreementDBDAOAgentRateDetailInfoList06RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * agt_agn_ctrt_ref  조회 결과를 sc_ofc_inp_cd 에 setting
	  * </pre>
	  */
	public AGTOfficeAgreementDBDAOAgentRateDetailInfoList06RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeAgreementDBDAOAgentRateDetailInfoList06RSQL").append("\n"); 
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
		query.append("CODES AS AGN_CTRT_OFC_CD" ).append("\n"); 
		query.append("FROM   (SELECT" ).append("\n"); 
		query.append("SUBSTR(SYS_CONNECT_BY_PATH(CD, ','), 2) AS CODES" ).append("\n"); 
		query.append("FROM   (SELECT" ).append("\n"); 
		query.append("ROWNUM AS NO," ).append("\n"); 
		query.append("CD" ).append("\n"); 
		query.append("FROM   (SELECT" ).append("\n"); 
		query.append("DISTINCT AGN_CTRT_OFC_CD AS CD" ).append("\n"); 
		query.append("FROM   AGT_AGN_CTRT_REF" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    AGMT_OFC_CD = @[agmt_ofc_cd] --:agmt_ofc_cd" ).append("\n"); 
		query.append("AND    AGN_AGMT_SEQ = @[agn_agmt_seq] --:agn_agmt_seq" ).append("\n"); 
		query.append("AND    VNDR_CNT_CD = @[vndr_cnt_cd] --:vndr_cnt_cd" ).append("\n"); 
		query.append("AND    VNDR_SEQ = @[vndr_seq] --:vndr_seq" ).append("\n"); 
		query.append("AND    AGN_AGMT_VER_SEQ = @[agn_agmt_ver_seq] --:agn_agmt_ver_seq" ).append("\n"); 
		query.append("AND    IO_BND_CD = @[io_bnd_cd] --:io_bnd_cd" ).append("\n"); 
		query.append("AND    AC_TP_CD = @[ac_tp_cd] --:ac_tp_cd" ).append("\n"); 
		query.append("AND    AGN_SEQ = @[agn_seq] --:agn_seq" ).append("\n"); 
		query.append("AND    SC_RFA_FLG = 'Y'" ).append("\n"); 
		query.append("AND    CTRT_REF_DIV_CD = 'SCOF'" ).append("\n"); 
		query.append("AND    CTRT_LVL_CD = '1' )) T START WITH NO = 1 CONNECT BY NOCYCLE PRIOR NO = NO - 1" ).append("\n"); 
		query.append("ORDER BY CODES DESC)" ).append("\n"); 
		query.append("WHERE  ROWNUM = 1" ).append("\n"); 

	}
}