/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IHCGuideLineDBDAOCheckAddRFIHCGuidelineDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.23
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.23 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOCheckAddRFIHCGuidelineDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check Add RF IHC Guideline Detail
	  * </pre>
	  */
	public IHCGuideLineDBDAOCheckAddRFIHCGuidelineDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_port_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration ").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOCheckAddRFIHCGuidelineDetailRSQL").append("\n"); 
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
		query.append("SELECT PNT_LOC_CD" ).append("\n"); 
		query.append("     , BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("     , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("  FROM PRI_TRF_IHC_RT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("  AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("  AND IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("  AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("  AND IHC_CGO_TP_CD = 'DR'" ).append("\n"); 
		query.append("  AND PNT_LOC_CD = @[pnt_loc_cd]" ).append("\n"); 
		query.append("  AND RCV_DE_TERM_CD = @[rcv_de_term_cd]" ).append("\n"); 
		query.append("  AND BSE_PORT_LOC_CD = @[bse_port_loc_cd]" ).append("\n"); 
		query.append("  AND OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("  AND SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}