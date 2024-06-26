/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeAgreementInfoDBDAOSearchDeductionInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeAgreementInfoDBDAOSearchDeductionInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (ESM_AGT_005) 공제 대상 Rep.Charge의 정보를 가져온다.
	  * </pre>
	  */
	public AGTOfficeAgreementInfoDBDAOSearchDeductionInfoListRSQL(){
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
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeAgreementInfoDBDAOSearchDeductionInfoListRSQL").append("\n"); 
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
		query.append("#if('' == ${agn_seq})" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'0'        AS CHECKBOX," ).append("\n"); 
		query.append("REP_CHG_CD AS REP_CHG_CD," ).append("\n"); 
		query.append("REP_CHG_NM AS REP_CHG_NM" ).append("\n"); 
		query.append("FROM MDM_REP_CHG" ).append("\n"); 
		query.append("WHERE NVL (DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("ORDER BY REP_CHG_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE B.REP_CHG_CD" ).append("\n"); 
		query.append("WHEN A.CHG_CD" ).append("\n"); 
		query.append("THEN '1'" ).append("\n"); 
		query.append("ELSE '0'" ).append("\n"); 
		query.append("END              AS CHECKBOX," ).append("\n"); 
		query.append("B.REP_CHG_CD AS REP_CHG_CD," ).append("\n"); 
		query.append("B.REP_CHG_NM AS REP_CHG_NM" ).append("\n"); 
		query.append("FROM MDM_REP_CHG B," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("DISTINCT CHG_CD CHG_CD" ).append("\n"); 
		query.append("FROM AGT_AGN_CHG_REF" ).append("\n"); 
		query.append("WHERE AGMT_OFC_CD      = @[agmt_ofc_cd]" ).append("\n"); 
		query.append("AND AGMT_OFC_CTY_CD  = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND AGN_AGMT_SEQ     = @[agn_agmt_seq]" ).append("\n"); 
		query.append("AND VNDR_CNT_CD      = @[vndr_cnt_cd]" ).append("\n"); 
		query.append("AND VNDR_SEQ         = @[vndr_seq]" ).append("\n"); 
		query.append("AND AGN_AGMT_VER_SEQ = @[agn_agmt_ver_seq]" ).append("\n"); 
		query.append("AND IO_BND_CD        = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD         = @[ac_tp_cd]" ).append("\n"); 
		query.append("AND AGN_SEQ          = @[agn_seq]" ).append("\n"); 
		query.append("AND DDCT_REF_DIV_CD = 'SCHG'" ).append("\n"); 
		query.append("AND DDCT_LVL_CD      = '1'" ).append("\n"); 
		query.append("AND CHG_GRP_TP_CD    = '1'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE B.REP_CHG_CD                  = A.CHG_CD(+)" ).append("\n"); 
		query.append("AND NVL (B.DELT_FLG, 'N')         = 'N'" ).append("\n"); 
		query.append("ORDER BY B.REP_CHG_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}