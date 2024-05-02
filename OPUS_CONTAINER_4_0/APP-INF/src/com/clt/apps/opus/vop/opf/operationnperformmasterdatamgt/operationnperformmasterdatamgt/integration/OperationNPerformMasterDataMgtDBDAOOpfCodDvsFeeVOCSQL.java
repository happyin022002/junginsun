/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfCodDvsFeeVO insert Query
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dvs_fee_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dvs_fee_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVOCSQL").append("\n"); 
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
		query.append("MERGE INTO OPF_COD_DVS_FEE " ).append("\n"); 
		query.append("USING DUAL " ).append("\n"); 
		query.append("      ON( CONTI_CD = @[conti_cd] AND DVS_FEE_TP_CD    = @[dvs_fee_tp_cd])" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("		   DVS_FEE_AMT = @[dvs_fee_amt]" ).append("\n"); 
		query.append("         , DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("         , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("         , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("     WHERE CONTI_CD = @[conti_cd]" ).append("\n"); 
		query.append("       AND DVS_FEE_TP_CD = @[dvs_fee_tp_cd]" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("           CONTI_CD " ).append("\n"); 
		query.append("         , DVS_FEE_TP_CD " ).append("\n"); 
		query.append("         , DVS_FEE_AMT " ).append("\n"); 
		query.append("         , DELT_FLG " ).append("\n"); 
		query.append("         , CRE_USR_ID " ).append("\n"); 
		query.append("         , CRE_DT " ).append("\n"); 
		query.append("         , UPD_USR_ID " ).append("\n"); 
		query.append("         , UPD_DT )" ).append("\n"); 
		query.append("    VALUES( @[conti_cd]" ).append("\n"); 
		query.append("         , @[dvs_fee_tp_cd]" ).append("\n"); 
		query.append("         , @[dvs_fee_amt]" ).append("\n"); 
		query.append("         , @[delt_flg]" ).append("\n"); 
		query.append("         , @[cre_usr_id]" ).append("\n"); 
		query.append("         , SYSDATE" ).append("\n"); 
		query.append("         , @[upd_usr_id]" ).append("\n"); 
		query.append("         , SYSDATE )" ).append("\n"); 

	}
}