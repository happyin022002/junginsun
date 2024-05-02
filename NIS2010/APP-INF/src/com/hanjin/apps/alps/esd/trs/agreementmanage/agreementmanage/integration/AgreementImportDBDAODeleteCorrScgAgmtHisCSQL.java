/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementImportDBDAODeleteCorrScgAgmtHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.07
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.07.07 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAODeleteCorrScgAgmtHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Rate Delete History 입력
	  * </pre>
	  */
	public AgreementImportDBDAODeleteCorrScgAgmtHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_account_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_scg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_tp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAODeleteCorrScgAgmtHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_AGMT_SCG_RT_HIS (" ).append("\n"); 
		query.append("TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",TRSP_AGMT_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append(",TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_HIS_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",TO_WGT" ).append("\n"); 
		query.append(",WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(",EFF_FM_DT" ).append("\n"); 
		query.append(",EFF_TO_DT" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",TRSP_ONE_WY_RT" ).append("\n"); 
		query.append(",TRSP_RND_RT" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",TRSP_AGMT_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append(",TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append(",TRS_AGMT_SCG_RT_HIS_SEQ1.NEXTVAL" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",TO_WGT" ).append("\n"); 
		query.append(",WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(",EFF_FM_DT" ).append("\n"); 
		query.append(",EFF_TO_DT" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",TRSP_ONE_WY_RT" ).append("\n"); 
		query.append(",TRSP_RND_RT" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",@[fm_account_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[fm_account_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM TRS_AGMT_SCG_RT" ).append("\n"); 
		query.append("WHERE TRSP_AGMT_OFC_CTY_CD   = @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND TRSP_AGMT_SEQ          = @[trsp_agmt_seq]" ).append("\n"); 
		query.append("AND TRSP_AGMT_RT_TP_SER_NO = @[trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append("AND TRSP_AGMT_SCG_NOD_SEQ  = @[trsp_agmt_scg_seq]" ).append("\n"); 
		query.append("AND TRSP_AGMT_SCG_RT_SEQ   = @[trsp_agmt_rt_seq]" ).append("\n"); 

	}
}