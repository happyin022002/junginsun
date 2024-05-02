/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TariffConditionManageDBDAOSearchTariffCondHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffConditionManageDBDAOSearchTariffCondHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * condition hdr 정보 조회
	  * </pre>
	  */
	public TariffConditionManageDBDAOSearchTariffCondHdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration").append("\n"); 
		query.append("FileName : TariffConditionManageDBDAOSearchTariffCondHdrRSQL").append("\n"); 
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
		query.append("C.*" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN COUNT(COND_NO) > 0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CHK_COND_NO_REF" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT COND_NO, TML_AWK_CGO_TRF_TP_CD TP" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_DTL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COND_NO, TML_AWK_CGO_TRF_TP_CD TP" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_TP_SZ" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COND_NO, 'A' TP" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COND_NO, 'A' TP" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_TP_SZ" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COND_NO, TRSP_AWK_CGO_TRF_TP_CD TP" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_HDR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COND_NO, TRSP_AWK_CGO_TRF_TP_CD TP" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_TP_SZ" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") CHK_COND_NO_REF" ).append("\n"); 
		query.append("FROM TES_TRF_COND C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND C.COND_NO = @[cond_no]" ).append("\n"); 
		query.append("#if (${cond_tp_cd} != '')" ).append("\n"); 
		query.append("AND C.TML_AWK_CGO_COND_TP_CD = @[cond_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}