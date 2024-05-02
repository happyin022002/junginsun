/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DryWetClaimDBDAOModifyTransferClaimMainUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.04.28 양정란
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOModifyTransferClaimMainUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Transfer 저장에 따른 Claim Main 수정
	  * </pre>
	  */
	public DryWetClaimDBDAOModifyTransferClaimMainUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOModifyTransferClaimMainUSQL").append("\n"); 
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
		query.append("UPDATE CNI_DW_CLM SET" ).append("\n"); 
		query.append("       HDLR_USR_ID = @[hdlr_usr_id]" ).append("\n"); 
		query.append("     , HDLR_OFC_CD = @[hdlr_ofc_cd]" ).append("\n"); 
		query.append("     , UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT      = CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("WHERE DW_CLM_NO = @[dw_clm_no]" ).append("\n"); 

	}
}