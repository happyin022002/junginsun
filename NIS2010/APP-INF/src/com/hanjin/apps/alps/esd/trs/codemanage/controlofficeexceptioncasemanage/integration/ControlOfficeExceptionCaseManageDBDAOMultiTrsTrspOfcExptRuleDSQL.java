/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.12.16 김진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiTrsTrspOfcExptRule
	  * </pre>
	  */
	public ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ctrl_ofc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration ").append("\n"); 
		query.append("FileName : ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleDSQL").append("\n"); 
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
		query.append("DELETE FROM TRS_TRSP_OFC_EXPT_RULE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CNTR_TP_CD         = NVL(@[cntr_tp_cd],'  ')" ).append("\n"); 
		query.append("AND CNTR_SZ_CD         = NVL(@[cntr_sz_cd],'  ')" ).append("\n"); 
		query.append("AND TRSP_CRR_MOD_CD    = NVL(@[trsp_crr_mod_cd],'  ')" ).append("\n"); 
		query.append("AND TRSP_COST_DTL_MOD_CD = NVL(@[trsp_cost_dtl_mod_cd],'  ')" ).append("\n"); 
		query.append("AND CGO_TP_CD          = NVL(@[cgo_tp_cd],'  ')" ).append("\n"); 
		query.append("AND CTRL_OFC_DIV_CD    = NVL(@[ctrl_ofc_div_cd],' ')" ).append("\n"); 
		query.append("AND DOR_NOD_CD         = NVL(@[dor_nod_cd],'     ')" ).append("\n"); 
		query.append("AND VIA_NOD_CD         = NVL(@[via_nod_cd],'     ')" ).append("\n"); 
		query.append("AND TO_NOD_CD          = NVL(@[to_nod_cd],'     ')" ).append("\n"); 
		query.append("AND FM_NOD_CD          = NVL(@[fm_nod_cd],'     ')" ).append("\n"); 

	}
}