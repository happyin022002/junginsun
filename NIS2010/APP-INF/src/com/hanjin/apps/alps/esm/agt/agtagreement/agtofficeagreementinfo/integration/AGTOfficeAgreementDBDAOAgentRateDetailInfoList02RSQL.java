/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeAgreementDBDAOAgentRateDetailInfoList02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeAgreementDBDAOAgentRateDetailInfoList02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chg_ddct_inp_cd 셋팅하기위해 조회
	  * </pre>
	  */
	public AGTOfficeAgreementDBDAOAgentRateDetailInfoList02RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.DECIMAL + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",Y";
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

		tmp = java.sql.Types.DECIMAL + ",Y";
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

		tmp = java.sql.Types.DECIMAL + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeAgreementDBDAOAgentRateDetailInfoList02RSQL").append("\n"); 
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
		query.append("DISTINCT CHG_GRP_TP_CD ," ).append("\n"); 
		query.append("CHG_CD" ).append("\n"); 
		query.append("FROM   AGT_AGN_CHG_REF" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    AGMT_OFC_CD = @[agmt_ofc_cd] --:agmt_ofc_cd" ).append("\n"); 
		query.append("AND    AGN_AGMT_SEQ = @[agn_agmt_seq] --:agn_agmt_seq" ).append("\n"); 
		query.append("AND    VNDR_CNT_CD = @[vndr_cnt_cd] --:vndr_cnt_cd" ).append("\n"); 
		query.append("AND    VNDR_SEQ = @[vndr_seq] --:vndr_seq" ).append("\n"); 
		query.append("AND    AGN_AGMT_VER_SEQ = @[agn_agmt_ver_seq] --:agn_agmt_ver_seq" ).append("\n"); 
		query.append("AND    IO_BND_CD = @[io_bnd_cd] --:io_bnd_cd" ).append("\n"); 
		query.append("AND    AC_TP_CD = @[ac_tp_cd] --:ac_tp_cd" ).append("\n"); 
		query.append("AND    AGN_SEQ = @[agn_seq] --:agn_seq" ).append("\n"); 
		query.append("AND    DDCT_REF_DIV_CD = 'SCHG'" ).append("\n"); 
		query.append("AND    DDCT_LVL_CD = '1'" ).append("\n"); 
		query.append("AND    CHG_GRP_TP_CD IN ('1', '2')" ).append("\n"); 

	}
}