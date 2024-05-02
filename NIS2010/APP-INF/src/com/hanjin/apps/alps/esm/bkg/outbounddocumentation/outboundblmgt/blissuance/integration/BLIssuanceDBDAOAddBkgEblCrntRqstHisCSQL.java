/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBkgEblCrntRqstHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.02
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.05.02 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOAddBkgEblCrntRqstHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBkgEblCrntRqstHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ebl_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddBkgEblCrntRqstHisCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EBL_CRNT_RQST_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",EBL_HIS_SEQ" ).append("\n"); 
		query.append(",SR_RQST_TP_CD" ).append("\n"); 
		query.append(",SR_STS_CD" ).append("\n"); 
		query.append(",SR_RQST_NO" ).append("\n"); 
		query.append(",EBL_RJCT_RSN" ).append("\n"); 
		query.append(",EBL_CFM_FLG" ).append("\n"); 
		query.append(",EBL_CFM_USR_ID" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",REF_NO)" ).append("\n"); 
		query.append("SELECT	BKG_NO" ).append("\n"); 
		query.append("	,@[ebl_his_seq]" ).append("\n"); 
		query.append("	,SR_RQST_TP_CD" ).append("\n"); 
		query.append("	,SR_STS_CD" ).append("\n"); 
		query.append("	,SR_RQST_NO" ).append("\n"); 
		query.append("	,EBL_RJCT_RSN" ).append("\n"); 
		query.append("	,EBL_CFM_FLG" ).append("\n"); 
		query.append("	,EBL_CFM_USR_ID" ).append("\n"); 
		query.append("	,@[usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,@[usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,''	" ).append("\n"); 
		query.append("  FROM 	BKG_EBL_CRNT_RQST" ).append("\n"); 
		query.append(" WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}