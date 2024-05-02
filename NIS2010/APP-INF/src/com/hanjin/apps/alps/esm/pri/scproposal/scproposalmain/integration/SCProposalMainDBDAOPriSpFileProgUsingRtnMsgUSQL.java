/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : SCProposalMainDBDAOPriSpFileProgUsingRtnMsgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.18
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.06.18 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpFileProgUsingRtnMsgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FMC Return Message 를 사용하여 PRI_SP_FILE_PROG 를 UPDATE 한다.
	  * * 2015.08.23 최성환 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpFileProgUsingRtnMsgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("orz_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sz_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmc_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_prog_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmc_file_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fmc_file_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmc_file_sess_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmc_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmc_amdt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpFileProgUsingRtnMsgUSQL").append("\n"); 
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
		query.append("UPDATE  PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("SET     FMC_FILE_CFM_DT  = CASE WHEN @[cfm_no] = 'Error' THEN NULL ELSE GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('NYCSC') END" ).append("\n"); 
		query.append("    ,   FILE_PROG_DT     = CASE WHEN @[cfm_no] = 'Error' THEN NULL ELSE SYSDATE END" ).append("\n"); 
		query.append("    ,   FMC_FILE_NM      = @[fmc_file_nm]" ).append("\n"); 
		query.append("    ,   ORZ_NO           = @[orz_no]" ).append("\n"); 
		query.append("    ,   FMC_CTRT_NO      = @[fmc_ctrt_no]" ).append("\n"); 
		query.append("    ,   FMC_AMDT_NO      = @[fmc_amdt_no]" ).append("\n"); 
		query.append("    ,   FMC_FILE_USR_ID  = @[fmc_file_usr_id]" ).append("\n"); 
		query.append("    ,   FMC_FILE_SESS_ID = @[fmc_file_sess_id]" ).append("\n"); 
		query.append("    ,   FMC_NO           = @[fmc_no]" ).append("\n"); 
		query.append("    ,   FMC_EFF_DT       = TO_DATE ( @[fmc_eff_dt], 'YYYYMMDD' )" ).append("\n"); 
		query.append("    ,   CFM_NO           = DECODE ( @[cfm_no], 'Error', NULL, @[cfm_no] )" ).append("\n"); 
		query.append("    ,   FILE_SZ_CAPA     = @[file_sz_capa]" ).append("\n"); 
		query.append("    ,   UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append("    ,   UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHERE   PROP_NO          = @[prop_no]" ).append("\n"); 
		query.append("AND     AMDT_SEQ         = @[amdt_seq]" ).append("\n"); 
		query.append("AND     FILE_PROG_SEQ    = @[file_prog_seq]" ).append("\n"); 

	}
}