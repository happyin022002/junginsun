/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOSearchOffdockCYRvisCntrListCdMTRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.09.10 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchOffdockCYRvisCntrListCdMTRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOffdockCYRvisCntrListCdMT
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchOffdockCYRvisCntrListCdMTRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOSearchOffdockCYRvisCntrListCdMTRSQL").append("\n"); 
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
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(NVL(L.TML_RVIS_IND_FLG,'N'),'Y','1','0') DEL_CHK," ).append("\n"); 
		query.append("L.TML_RVIS_IND_FLG," ).append("\n"); 
		query.append("L.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("L.TML_SO_SEQ," ).append("\n"); 
		query.append("L.TML_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("L.CNTR_NO," ).append("\n"); 
		query.append("L.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("L.CNTR_STY_CD," ).append("\n"); 
		query.append("L.IO_BND_CD," ).append("\n"); 
		query.append("@[param_lgs_cost_cd] AS LGS_COST_CD," ).append("\n"); 
		query.append("L.BL_NO," ).append("\n"); 
		query.append("L.AWK_CGO_FLG," ).append("\n"); 
		query.append("L.RC_FLG," ).append("\n"); 
		query.append("L.CNTR_RMK" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ        = L.TML_SO_SEQ" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND L.VRFY_RSLT_IND_CD = 'CO'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.LGS_COST_CD = SUBSTR(@[param_lgs_cost_cd],1,4)||'MT'" ).append("\n"); 
		query.append("ORDER BY A.CNTR_NO ASC, A.CNTR_TPSZ_CD ASC, A.CNTR_STY_CD ASC, A.IO_BND_CD ASC" ).append("\n"); 

	}
}