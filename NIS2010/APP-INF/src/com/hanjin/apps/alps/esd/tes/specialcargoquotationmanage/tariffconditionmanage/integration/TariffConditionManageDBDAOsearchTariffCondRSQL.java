/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TariffConditionManageDBDAOsearchTariffCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.23
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.23 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffConditionManageDBDAOsearchTariffCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTariffCond
	  * </pre>
	  */
	public TariffConditionManageDBDAOsearchTariffCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_awk_cgo_cond_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cond_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration").append("\n"); 
		query.append("FileName : TariffConditionManageDBDAOsearchTariffCondRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.TML_AWK_CGO_COND_TP_CD = 'B'" ).append("\n"); 
		query.append("THEN 'Basic'" ).append("\n"); 
		query.append("WHEN C.TML_AWK_CGO_COND_TP_CD = 'T'" ).append("\n"); 
		query.append("THEN 'T/S'" ).append("\n"); 
		query.append("WHEN C.TML_AWK_CGO_COND_TP_CD = 'A'" ).append("\n"); 
		query.append("THEN 'Add-On'" ).append("\n"); 
		query.append("WHEN C.TML_AWK_CGO_COND_TP_CD = 'S'" ).append("\n"); 
		query.append("THEN 'Shuttle'" ).append("\n"); 
		query.append("WHEN C.TML_AWK_CGO_COND_TP_CD = 'F'" ).append("\n"); 
		query.append("THEN 'Feeder'" ).append("\n"); 
		query.append("WHEN C.TML_AWK_CGO_COND_TP_CD = 'C'" ).append("\n"); 
		query.append("THEN 'Common'" ).append("\n"); 
		query.append("END TML_AWK_CGO_COND_TP_NM" ).append("\n"); 
		query.append(", C.TML_AWK_CGO_COND_TP_CD" ).append("\n"); 
		query.append(", C.COND_NO" ).append("\n"); 
		query.append(", C.COND_DESC" ).append("\n"); 
		query.append(", C.UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(C.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("FROM TES_TRF_COND C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.COND_NO > '0'" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if(${ui_id} != 'ESD_TES_0050')" ).append("\n"); 
		query.append("AND C.COND_CRE_STS_CD = 'C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${tml_awk_cgo_cond_tp_cd} != '')" ).append("\n"); 
		query.append("AND TML_AWK_CGO_COND_TP_CD IN ( @[tml_awk_cgo_cond_tp_cd], 'C') --// (입력값) cnd 유형" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cond_no} != '' )" ).append("\n"); 
		query.append("AND C.COND_NO = @[cond_no] --// (입력값) cnd 번호;" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cond_desc} != '' )" ).append("\n"); 
		query.append("AND UPPER(C.COND_DESC) LIKE '%'||UPPER(@[cond_desc])||'%' --// (입력값) cnd nm" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY C.COND_NO, C.TML_AWK_CGO_COND_TP_CD" ).append("\n"); 

	}
}