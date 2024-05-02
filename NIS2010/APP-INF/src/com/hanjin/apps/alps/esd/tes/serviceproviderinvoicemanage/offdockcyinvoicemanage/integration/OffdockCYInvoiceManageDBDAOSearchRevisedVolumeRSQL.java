/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOSearchRevisedVolumeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.08.17 이정혜
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchRevisedVolumeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRevisedVolume
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchRevisedVolumeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("param_rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_dcgo_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOSearchRevisedVolumeRSQL").append("\n"); 
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
		query.append("DECODE(NVL(L.TML_RVIS_IND_FLG,'N'),'Y','1','0') TML_RVIS_IND_FLG," ).append("\n"); 
		query.append("L.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("L.TML_SO_SEQ," ).append("\n"); 
		query.append("L.TML_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("L.CNTR_NO," ).append("\n"); 
		query.append("L.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("L.CNTR_STY_CD," ).append("\n"); 
		query.append("L.IO_BND_CD," ).append("\n"); 
		query.append("DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') LGS_COST_CD," ).append("\n"); 
		query.append("L.BL_NO," ).append("\n"); 
		query.append("L.AWK_CGO_FLG," ).append("\n"); 
		query.append("L.RC_FLG," ).append("\n"); 
		query.append("L.DCGO_CLSS_CD," ).append("\n"); 
		query.append("L.CNTR_RMK" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ        = L.TML_SO_SEQ" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND L.VRFY_RSLT_IND_CD = 'CO'" ).append("\n"); 
		query.append("AND L.CNTR_TPSZ_CD = @[param_cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND L.DCGO_CLSS_CD = @[param_dcgo_clss_cd]" ).append("\n"); 
		query.append("AND DECODE(L.RC_FLG,'Y','Y','N') = DECODE(@[param_rc_flg],'Y','Y','N')" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.LGS_COST_CD = @[param_lgs_cost_cd]" ).append("\n"); 

	}
}