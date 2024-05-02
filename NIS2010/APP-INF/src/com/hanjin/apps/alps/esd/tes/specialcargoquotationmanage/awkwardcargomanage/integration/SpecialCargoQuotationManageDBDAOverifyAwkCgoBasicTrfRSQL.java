/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOverifyAwkCgoBasicTrfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.29 
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

public class SpecialCargoQuotationManageDBDAOverifyAwkCgoBasicTrfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Awkward Cargo Basic Tariff verify
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOverifyAwkCgoBasicTrfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOverifyAwkCgoBasicTrfRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN PORT_TMNL.PT||TRF_COND.TC = 'YY' THEN 'SUCCESS'" ).append("\n"); 
		query.append("WHEN PORT_TMNL.PT||TRF_COND.TC = 'YN' THEN 'Plz,check Tariff Condition'" ).append("\n"); 
		query.append("WHEN PORT_TMNL.PT||TRF_COND.TC = 'NY' THEN 'Plz,check Port/TML'" ).append("\n"); 
		query.append("WHEN PORT_TMNL.PT||TRF_COND.TC = 'NN' THEN 'Plz,check Port/TML & Tariff Condition'" ).append("\n"); 
		query.append("END AS VRFY_RSLT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT NVL((SELECT 'Y'" ).append("\n"); 
		query.append("FROM   MDM_YARD" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND	   (NVL(YD_FCTY_TP_MRN_TML_FLG,' ') = 'Y' OR NVL(YD_FCTY_TP_BRG_RMP_FLG,' ') = 'Y' )" ).append("\n"); 
		query.append("AND    LOC_CD = @[port_cd] --5자리 Port Code" ).append("\n"); 
		query.append("#if(${tml_cd} != '')" ).append("\n"); 
		query.append("AND    SUBSTR (YD_CD,6) = @[tml_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("),'N') AS PT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") PORT_TMNL," ).append("\n"); 
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