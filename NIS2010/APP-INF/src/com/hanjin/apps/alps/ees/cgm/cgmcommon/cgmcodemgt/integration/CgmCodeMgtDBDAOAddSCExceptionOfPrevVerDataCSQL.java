/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgmCodeMgtDBDAOAddSCExceptionOfPrevVerDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOAddSCExceptionOfPrevVerDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CgmCodeMgtDBDAOAddSCExceptionOfPrevVerDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_expt_prev_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration ").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOAddSCExceptionOfPrevVerDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_SC_EXPT_LIST (" ).append("\n"); 
		query.append("	PROP_NO" ).append("\n"); 
		query.append(",	SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EXP_DT" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",   CUST_CNT_CD" ).append("\n"); 
		query.append(",   CUST_SEQ" ).append("\n"); 
		query.append(",	CHSS_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",   USA_SC_EXPT_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT	PROP_NO" ).append("\n"); 
		query.append("	,	@[sc_expt_ver_seq]" ).append("\n"); 
		query.append("	,	SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("	,	EFF_DT" ).append("\n"); 
		query.append("	,	EXP_DT" ).append("\n"); 
		query.append("	,	LOC_CD" ).append("\n"); 
		query.append("    ,   CUST_CNT_CD" ).append("\n"); 
		query.append("    ,   CUST_SEQ" ).append("\n"); 
		query.append("	,	CHSS_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append("	,	CMDT_CD" ).append("\n"); 
		query.append("	,	USA_SC_EXPT_RMK" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("FROM	CGM_SC_EXPT_LIST" ).append("\n"); 
		query.append("WHERE	PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("	AND	SC_EXPT_VER_SEQ = @[sc_expt_prev_ver_seq]" ).append("\n"); 

	}
}