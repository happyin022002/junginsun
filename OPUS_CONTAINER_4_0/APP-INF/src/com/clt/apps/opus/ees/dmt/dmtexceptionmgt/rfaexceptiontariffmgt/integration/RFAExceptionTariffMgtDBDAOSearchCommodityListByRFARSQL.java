/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchCommodityListByRFARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchCommodityListByRFARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commodity Search
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchCommodityListByRFARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_rqst_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchCommodityListByRFARSQL").append("\n"); 
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
		query.append("SELECT A.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("     , A.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("     , A.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("     , A.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("     , A.CVRG_CMB_SEQ" ).append("\n"); 
		query.append("     , A.CMDT_CD" ).append("\n"); 
		query.append("     , B.CMDT_NM" ).append("\n"); 
		query.append("  FROM DMT_RFA_EXPT_CMDT A" ).append("\n"); 
		query.append("     , MDM_COMMODITY B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.RFA_EXPT_DAR_NO   = @[rfa_expt_dar_no] " ).append("\n"); 
		query.append("   AND A.RFA_EXPT_MAPG_SEQ = @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("   AND A.RFA_EXPT_VER_SEQ  = @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("   AND A.RFA_RQST_DTL_SEQ  = @[rfa_rqst_dtl_seq]" ).append("\n"); 
		query.append("   AND A.CVRG_CMB_SEQ      = @[cvrg_cmb_seq]" ).append("\n"); 
		query.append("   AND A.CMDT_CD           = B.CMDT_CD" ).append("\n"); 
		query.append(" ORDER BY A.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("        , A.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("        , A.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , A.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("        , A.CVRG_CMB_SEQ" ).append("\n"); 
		query.append("        , A.CMDT_CD" ).append("\n"); 

	}
}