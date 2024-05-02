/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOverifyAwkCgoAddOnTrfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOverifyAwkCgoAddOnTrfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Awkward Cargo Add on Tariff verify
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOverifyAwkCgoAddOnTrfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOverifyAwkCgoAddOnTrfRSQL").append("\n"); 
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
		query.append("SELECT  CASE  WHEN FM_TMNL.FT||TO_TMNL.TT||TRF_COND.TC = 'YYY' THEN 'SUCCESS'" ).append("\n"); 
		query.append("WHEN FM_TMNL.FT||TO_TMNL.TT||TRF_COND.TC = 'YYN' THEN 'Plz,check Tariff Condition'" ).append("\n"); 
		query.append("WHEN FM_TMNL.FT||TO_TMNL.TT||TRF_COND.TC = 'YNY' THEN 'Plz,check To Port/TML'" ).append("\n"); 
		query.append("WHEN FM_TMNL.FT||TO_TMNL.TT||TRF_COND.TC = 'NYY' THEN 'Plz,check From Port/TML'" ).append("\n"); 
		query.append("WHEN FM_TMNL.FT||TO_TMNL.TT||TRF_COND.TC = 'NNY' THEN 'Plz,check From & To Port/TML'" ).append("\n"); 
		query.append("WHEN FM_TMNL.FT||TO_TMNL.TT||TRF_COND.TC = 'YNN' THEN 'Plz,check To Port/TML & Tariff Condition'" ).append("\n"); 
		query.append("WHEN FM_TMNL.FT||TO_TMNL.TT||TRF_COND.TC = 'NYN' THEN 'Plz,check From Port/TML & Tariff Condition'" ).append("\n"); 
		query.append("WHEN FM_TMNL.FT||TO_TMNL.TT||TRF_COND.TC = 'NNN' THEN 'Plz,check From & To Port/TML & Tariff Condition'" ).append("\n"); 
		query.append("END AS VRFY_RSLT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("#if(${fm_nod_yd_no} != '')" ).append("\n"); 
		query.append("(SELECT NVL((SELECT 'Y'" ).append("\n"); 
		query.append("FROM   MDM_YARD" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND	   (NVL(YD_FCTY_TP_MRN_TML_FLG,' ') = 'Y' OR NVL(YD_FCTY_TP_BRG_RMP_FLG,' ') = 'Y' )" ).append("\n"); 
		query.append("AND    LOC_CD = @[fm_loc_cd] --5자리 Port Code" ).append("\n"); 
		query.append("AND    SUBSTR (YD_CD,6) = @[fm_nod_yd_no]" ).append("\n"); 
		query.append("),'N') AS FT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") FM_TMNL," ).append("\n"); 
		query.append("#elseif(${fm_nod_yd_no} == '')" ).append("\n"); 
		query.append("(SELECT NVL((SELECT 'Y'" ).append("\n"); 
		query.append("FROM   MDM_LOCATION" ).append("\n"); 
		query.append("WHERE  CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    LOC_CD = @[fm_loc_cd]" ).append("\n"); 
		query.append("),'N') AS FT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") FM_TMNL," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${to_nod_yd_no} != '')" ).append("\n"); 
		query.append("(SELECT NVL((SELECT 'Y'" ).append("\n"); 
		query.append("FROM   MDM_YARD" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND	   (NVL(YD_FCTY_TP_MRN_TML_FLG,' ') = 'Y' OR NVL(YD_FCTY_TP_BRG_RMP_FLG,' ') = 'Y' )" ).append("\n"); 
		query.append("AND    LOC_CD = @[to_loc_cd] --5자리 Port Code" ).append("\n"); 
		query.append("AND    SUBSTR (YD_CD,6) = @[to_nod_yd_no]" ).append("\n"); 
		query.append("),'N') AS TT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") TO_TMNL," ).append("\n"); 
		query.append("#elseif(${to_nod_yd_no} == '')" ).append("\n"); 
		query.append("(SELECT NVL((SELECT 'Y'" ).append("\n"); 
		query.append("FROM   MDM_LOCATION" ).append("\n"); 
		query.append("WHERE  CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    LOC_CD = @[to_loc_cd]" ).append("\n"); 
		query.append("),'N') AS TT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") TO_TMNL," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("(SELECT NVL((SELECT 'Y'" ).append("\n"); 
		query.append("FROM TES_TRF_COND C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.COND_NO = @[cond_no]" ).append("\n"); 
		query.append("--AND C.COND_DESC = 'OW <= 0 cm AND OL <= 0 cm AND OH <= 0 cm'" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND C.COND_CRE_STS_CD = 'C'" ).append("\n"); 
		query.append("AND TML_AWK_CGO_COND_TP_CD IN ( 'A', 'C')" ).append("\n"); 
		query.append("),'N') AS TC" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") TRF_COND" ).append("\n"); 

	}
}