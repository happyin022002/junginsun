/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DryWetClaimDBDAOAddTransferCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.04.20 정행룡
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOAddTransferCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Transfer
	  * </pre>
	  */
	public DryWetClaimDBDAOAddTransferCSQL(){
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
		params.put("trns_to_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_fm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trns_fm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_to_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration ").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOAddTransferCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_DW_TRNS (" ).append("\n"); 
		query.append("   DW_CLM_NO" ).append("\n"); 
		query.append(",  TRNS_SEQ" ).append("\n"); 
		query.append(",  TRNS_OFC_CD" ).append("\n"); 
		query.append(",  TRNS_USR_ID" ).append("\n"); 
		query.append(",  TRNS_FM_OFC_CD" ).append("\n"); 
		query.append(",  TRNS_FM_USR_ID" ).append("\n"); 
		query.append(",  TRNS_FM_DT" ).append("\n"); 
		query.append(",  CLM_TRNS_AUTH_CD" ).append("\n"); 
		query.append(",  TRNS_TO_OFC_CD" ).append("\n"); 
		query.append(",  TRNS_TO_USR_ID" ).append("\n"); 
		query.append(",  TRNS_TO_DT" ).append("\n"); 
		query.append(",  TRNS_RMK" ).append("\n"); 
		query.append(",  TRNS_KNT" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append("  ) VALUES (" ).append("\n"); 
		query.append("   @[dw_clm_no]" ).append("\n"); 
		query.append(" , CNI_DWC_TRNS_SEQ.NEXTVAL" ).append("\n"); 
		query.append(" , @[trns_ofc_cd]" ).append("\n"); 
		query.append(" , @[cre_usr_id]" ).append("\n"); 
		query.append(" , @[trns_fm_ofc_cd]" ).append("\n"); 
		query.append(" , @[trns_fm_usr_id]" ).append("\n"); 
		query.append(" , TO_CHAR(CNI_GET_GMT_FNC(@[cre_usr_id]),'YYYYMMDD')" ).append("\n"); 
		query.append(" , 'W'" ).append("\n"); 
		query.append(" , @[trns_to_ofc_cd]" ).append("\n"); 
		query.append(" , @[trns_to_usr_id]" ).append("\n"); 
		query.append("#if (${trns_to_dt} != '')" ).append("\n"); 
		query.append(" , @[trns_to_dt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" , NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , @[trns_rmk]" ).append("\n"); 
		query.append(" , (SELECT COUNT(DW_CLM_NO) FROM CNI_DW_TRNS WHERE DW_CLM_NO = @[dw_clm_no])" ).append("\n"); 
		query.append(" , @[cre_usr_id]" ).append("\n"); 
		query.append(" , CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(" , @[upd_usr_id]" ).append("\n"); 
		query.append(" , CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}