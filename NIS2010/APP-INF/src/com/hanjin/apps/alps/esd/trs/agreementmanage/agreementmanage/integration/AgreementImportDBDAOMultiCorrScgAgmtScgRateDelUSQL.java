/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrScgAgmtScgRateDelUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.08
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.09.08 최종혁
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

public class AgreementImportDBDAOMultiCorrScgAgmtScgRateDelUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Rate Delete Update
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrScgAgmtScgRateDelUSQL(){
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
		params.put("trsp_agmt_scg_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_scg_nod_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOMultiCorrScgAgmtScgRateDelUSQL").append("\n"); 
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
		query.append("UPDATE TRS_AGMT_SCG_RT" ).append("\n"); 
		query.append("SET DELT_FLG = 'Y'" ).append("\n"); 
		query.append(",UPD_USR_ID = @[fm_account_usr_id]" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",AGMT_EXP_DT = TO_DATE(@[agmt_exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("WHERE TRSP_AGMT_OFC_CTY_CD = @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND TRSP_AGMT_SEQ        = @[trsp_agmt_seq]" ).append("\n"); 
		query.append("AND TRSP_AGMT_RT_TP_SER_NO = @[trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append("AND TRSP_AGMT_SCG_NOD_SEQ  = @[trsp_agmt_scg_nod_seq]" ).append("\n"); 
		query.append("AND TRSP_AGMT_SCG_RT_SEQ   = @[trsp_agmt_scg_rt_seq]" ).append("\n"); 

	}
}