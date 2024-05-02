/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementCorrectionDBDAOCfmAgmtHisUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.24
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.07.24 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementCorrectionDBDAOCfmAgmtHisUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement History Confirm (Confirm에는 영향이 없으나 결재 history 관리를 위하여 기록..속도에 영향이 있을 경우 제외시켜도 무방)
	  * </pre>
	  */
	public AgreementCorrectionDBDAOCfmAgmtHisUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAOCfmAgmtHisUSQL").append("\n"); 
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
		query.append("UPDATE TRS_AGMT_EQ_RT_HIS A" ).append("\n"); 
		query.append("   SET A.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("      ,A.CFM_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,A.CFM_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,A.UPD_DT            = SYSDATE" ).append("\n"); 
		query.append(" WHERE A.TRSP_AGMT_OFC_CTY_CD = @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_SEQ        = @[trsp_agmt_seq]" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_RT_TP_SER_NO = @[trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append("   AND (A.TRSP_AGMT_RT_SEQ, A.TRSP_AGMT_RT_HIS_SEQ) IN (" ).append("\n"); 
		query.append("                            SELECT X.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("                                  ,(SELECT MAX(Y.TRSP_AGMT_RT_HIS_SEQ)" ).append("\n"); 
		query.append("                                      FROM TRS_AGMT_EQ_RT_HIS Y" ).append("\n"); 
		query.append("                                     WHERE Y.TRSP_AGMT_OFC_CTY_CD = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                                       AND Y.TRSP_AGMT_SEQ        = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                                       AND Y.TRSP_AGMT_RT_TP_SER_NO = X.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                                       AND Y.TRSP_AGMT_RT_SEQ     = X.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                              FROM TRS_AGMT_EQ_RT X" ).append("\n"); 
		query.append("                             WHERE 1=1" ).append("\n"); 
		query.append("                               AND X.TRSP_AGMT_OFC_CTY_CD = @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("                               AND X.TRSP_AGMT_SEQ        = @[trsp_agmt_seq]" ).append("\n"); 
		query.append("                               AND X.TRSP_AGMT_RT_TP_SER_NO = @[trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append("                               AND X.CFM_FLG = 'N'" ).append("\n"); 
		query.append("                            )" ).append("\n"); 

	}
}