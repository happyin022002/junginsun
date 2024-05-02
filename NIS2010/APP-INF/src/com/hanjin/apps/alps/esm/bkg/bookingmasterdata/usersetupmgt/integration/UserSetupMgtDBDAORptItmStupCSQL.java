/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UserSetupMgtDBDAORptItmStupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.07
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.12.07 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAORptItmStupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public UserSetupMgtDBDAORptItmStupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_cfm_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ntc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_coff_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rtn_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crn_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rail_rcv_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_coff_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_coff_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAORptItmStupCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_RPT_ITM_STUP (" ).append("\n"); 
		query.append("	ITM_SEQ" ).append("\n"); 
		query.append(",	BKG_OFC_CD" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	MTY_PKUP_YD_FLG" ).append("\n"); 
		query.append(",	FULL_RTN_YD_FLG" ).append("\n"); 
		query.append(",	PORT_COFF_FLG" ).append("\n"); 
		query.append(",	RAIL_RCV_FLG" ).append("\n"); 
		query.append(",	DOC_COFF_FLG" ).append("\n"); 
		query.append(",	CUST_COFF_FLG" ).append("\n"); 
		query.append(",	CALL_SGN_FLG" ).append("\n"); 
		query.append(",	MRN_FLG" ).append("\n"); 
		query.append(",	CRN_FLG" ).append("\n"); 
		query.append(",	XCH_RT_FLG" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",   RCT_NTC_RMK" ).append("\n"); 
		query.append(",   LODG_CFM_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	EML_CTNT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	NVL((select max(ITM_SEQ) from BKG_RPT_ITM_STUP),0)+1" ).append("\n"); 
		query.append(",	@[bkg_ofc_cd]" ).append("\n"); 
		query.append(",	@[cust_cnt_cd]" ).append("\n"); 
		query.append(",	@[cust_seq]" ).append("\n"); 
		query.append(",	DECODE(@[mty_pkup_yd_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	DECODE(@[full_rtn_yd_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	DECODE(@[port_coff_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	DECODE(@[rail_rcv_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	DECODE(@[doc_coff_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	DECODE(@[cust_coff_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	DECODE(@[call_sgn_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	DECODE(@[mrn_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	DECODE(@[crn_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	DECODE(@[xch_rt_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",   @[rct_ntc_rmk]" ).append("\n"); 
		query.append(",   @[lodg_cfm_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[eml_ctnt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}