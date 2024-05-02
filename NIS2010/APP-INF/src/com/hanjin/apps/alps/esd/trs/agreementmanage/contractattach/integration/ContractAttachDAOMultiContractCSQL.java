/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContractAttachDAOMultiContractCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.06
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.10.06 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContractAttachDAOMultiContractCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Contract Attach 저장
	  * </pre>
	  */
	public ContractAttachDAOMultiContractCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_doc_eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_doc_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_doc_eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_mn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_doc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.integration").append("\n"); 
		query.append("FileName : ContractAttachDAOMultiContractCSQL").append("\n"); 
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
		query.append("MERGE INTO TRS_AGMT_CTRT_ATCH A" ).append("\n"); 
		query.append("USING DUAL B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("	    A.TRSP_AGMT_OFC_CTY_CD = @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND A.TRSP_AGMT_SEQ = @[trsp_agmt_seq]" ).append("\n"); 
		query.append("    AND A.CTRT_SEQ = @[ctrt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE SET A.AGMT_DOC_NO = @[agmt_doc_no]" ).append("\n"); 
		query.append("              ,A.AGMT_DOC_DESC = @[agmt_doc_desc]" ).append("\n"); 
		query.append("              ,A.AGMT_DOC_EFF_FM_DT = @[agmt_doc_eff_fm_dt]" ).append("\n"); 
		query.append("              ,A.AGMT_DOC_EFF_TO_DT = @[agmt_doc_eff_to_dt]" ).append("\n"); 
		query.append("              ,A.UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("              ,A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ, A.CTRT_SEQ, A.CTRT_MN_FLG" ).append("\n"); 
		query.append("           ,A.AGMT_DOC_NO, A.AGMT_DOC_DESC, A.AGMT_DOC_EFF_FM_DT, A.AGMT_DOC_EFF_TO_DT" ).append("\n"); 
		query.append("           ,A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT)" ).append("\n"); 
		query.append("	VALUES (@[trsp_agmt_ofc_cty_cd], @[trsp_agmt_seq]" ).append("\n"); 
		query.append("           ,CASE WHEN @[ctrt_mn_flg] = 'Y' THEN 0" ).append("\n"); 
		query.append("                 ELSE NVL((SELECT MAX(CTRT_SEQ)" ).append("\n"); 
		query.append("                             FROM TRS_AGMT_CTRT_ATCH X" ).append("\n"); 
		query.append("                            WHERE X.TRSP_AGMT_OFC_CTY_CD = @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("                              AND X.TRSP_AGMT_SEQ = @[trsp_agmt_seq]" ).append("\n"); 
		query.append("                         ),0)+1" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("           ,@[ctrt_mn_flg]" ).append("\n"); 
		query.append("           ,@[agmt_doc_no], @[agmt_doc_desc], @[agmt_doc_eff_fm_dt], @[agmt_doc_eff_to_dt]" ).append("\n"); 
		query.append("           ,@[cre_usr_id], SYSDATE, @[cre_usr_id], SYSDATE)" ).append("\n"); 

	}
}