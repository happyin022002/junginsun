/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.11.11 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Exception History 입력
	  * </pre>
	  */
	public ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_dtl_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration").append("\n"); 
		query.append("FileName : ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_OFC_EXPT_RULE_HIS (" ).append("\n"); 
		query.append("FM_NOD_CD" ).append("\n"); 
		query.append(",	TO_NOD_CD" ).append("\n"); 
		query.append(",	VIA_NOD_CD" ).append("\n"); 
		query.append(",	DOR_NOD_CD" ).append("\n"); 
		query.append(",	CTRL_OFC_DIV_CD" ).append("\n"); 
		query.append(",	CTRL_OFC_CD" ).append("\n"); 
		query.append(",	CGO_TP_CD" ).append("\n"); 
		query.append(",	TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(",	TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(",	CNTR_TP_CD" ).append("\n"); 
		query.append(",	CNTR_SZ_CD" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	LOCL_CRE_DT" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(",   LOCL_UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("NVL(@[fm_nod_cd],'     ')" ).append("\n"); 
		query.append(",	NVL(@[to_nod_cd],'     ')" ).append("\n"); 
		query.append(",	NVL(@[via_nod_cd],'     ')" ).append("\n"); 
		query.append(",	NVL(@[dor_nod_cd],'     ')" ).append("\n"); 
		query.append(",	NVL(@[ctrl_ofc_div_cd],' ')" ).append("\n"); 
		query.append(",	@[ctrl_ofc_cd]" ).append("\n"); 
		query.append(",	NVL(@[cgo_tp_cd],'  ')" ).append("\n"); 
		query.append(",	NVL(@[trsp_cost_dtl_mod_cd],'  ')" ).append("\n"); 
		query.append(",	NVL(@[trsp_crr_mod_cd],'  ')" ).append("\n"); 
		query.append(",	NVL(@[cntr_tp_cd],'  ')" ).append("\n"); 
		query.append(",	NVL(@[cntr_sz_cd],'  ')" ).append("\n"); 
		query.append(",	NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append(",	@[OFC_CD]" ).append("\n"); 
		query.append(",	@[USR_ID]" ).append("\n"); 
		query.append(",  SYSDATE" ).append("\n"); 
		query.append(",	GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[OFC_CD])" ).append("\n"); 
		query.append(",	@[USR_ID]" ).append("\n"); 
		query.append(",  SYSDATE" ).append("\n"); 
		query.append(",	GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[OFC_CD])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}