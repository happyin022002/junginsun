/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeMgtDBDAOAddHandlerHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.11.12 정행룡
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeMgtDBDAOAddHandlerHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Handler History 등록
	  * </pre>
	  */
	public CodeMgtDBDAOAddHandlerHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hdlr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_clm_his_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : CodeMgtDBDAOAddHandlerHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_CGO_CLM_HDLR_HIS (" ).append("\n"); 
		query.append("CGO_CLM_NO" ).append("\n"); 
		query.append(",	CGO_CLM_HDLR_HIS_SEQ" ).append("\n"); 
		query.append(",	CGO_CLM_HIS_TP_CD" ).append("\n"); 
		query.append(",	HDLR_USR_ID" ).append("\n"); 
		query.append(",   HDLR_OFC_CD" ).append("\n"); 
		query.append(",   MGR_HDLR_DIV_CD" ).append("\n"); 
		query.append(",   CGO_CLM_STS_CD" ).append("\n"); 
		query.append(",   EFF_DT" ).append("\n"); 
		query.append(",   CRNT_HDLR_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[cgo_clm_no]" ).append("\n"); 
		query.append(",	CNI_CGO_CLM_HDLR_HIS_SEQ.NEXTVAL" ).append("\n"); 
		query.append(",	@[cgo_clm_his_tp_cd]" ).append("\n"); 
		query.append(",	@[hdlr_usr_id]" ).append("\n"); 
		query.append(",   @[hdlr_ofc_cd]" ).append("\n"); 
		query.append(",   'H'" ).append("\n"); 
		query.append(",   @[cgo_clm_sts_cd]" ).append("\n"); 
		query.append(",   TO_CHAR(CNI_GET_GMT_FNC(@[cre_usr_id]), 'YYYYMMDD')" ).append("\n"); 
		query.append(",   'Y'" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}