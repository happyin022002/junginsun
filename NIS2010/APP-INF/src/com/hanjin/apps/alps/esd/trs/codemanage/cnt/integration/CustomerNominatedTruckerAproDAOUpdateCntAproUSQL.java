/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CustomerNominatedTruckerAproDAOUpdateCntAproUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerAproDAOUpdateCntAproUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNT(Customer Nominated Trucker) Approval - Approval
	  * </pre>
	  */
	public CustomerNominatedTruckerAproDAOUpdateCntAproUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_trkr_fuel_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_trkr_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_his_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_cust_nomi_trkr_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_trkr_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerAproDAOUpdateCntAproUSQL").append("\n"); 
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
		query.append("-- 상태코드 UPDATE (Approval)" ).append("\n"); 
		query.append("UPDATE TRS_CUST_NOMI_TRKR A" ).append("\n"); 
		query.append("   SET DISP_STS_CD = '03'" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_APRO_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]) -- Session Office Code" ).append("\n"); 
		query.append("--      ,ORG_NOD_CD               = [org_nod_cd]" ).append("\n"); 
		query.append("      ,MTY_PKUP_RTN_YD_CD       = DECODE(A.IO_BND_CD, 'I', @[mty_pkup_rtn_yd_cd], 'O', @[org_nod_cd])" ).append("\n"); 
		query.append("      ,HJS_TRKR_AGMT_NO         = @[hjs_trkr_agmt_no]" ).append("\n"); 
		query.append("      ,HJS_TRKR_BZC_AMT         = @[hjs_trkr_bzc_amt]" ).append("\n"); 
		query.append("      ,HJS_TRKR_FUEL_AMT        = @[hjs_trkr_fuel_amt]" ).append("\n"); 
		query.append("      ,HJS_CUST_NOMI_TRKR_AGMT_NO = @[hjs_cust_nomi_trkr_agmt_no]" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_IND_CD    = @[cust_nomi_trkr_ind_cd]" ).append("\n"); 
		query.append("      ,APRO_HIS_DESC = @[apro_his_desc]      " ).append("\n"); 
		query.append("	  ,APRO_OFC_CD = @[apro_ofc_cd]" ).append("\n"); 
		query.append("	  ,APRO_USR_ID = @[apro_usr_id]" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[cre_usr_id] -- Session User Id" ).append("\n"); 
		query.append("      ,UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(" WHERE APRO_NO = @[apro_no]" ).append("\n"); 

	}
}