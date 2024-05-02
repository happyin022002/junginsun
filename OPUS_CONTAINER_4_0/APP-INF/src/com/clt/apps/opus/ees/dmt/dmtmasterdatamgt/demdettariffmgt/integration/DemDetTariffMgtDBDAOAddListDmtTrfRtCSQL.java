/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOAddListDmtTrfRtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.09.11 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOAddListDmtTrfRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Copy Basic Tariff
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOAddListDmtTrfRtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_trf_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOAddListDmtTrfRtCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_TRF_RT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(", DMDT_TRF_CD" ).append("\n"); 
		query.append(", TRF_SEQ" ).append("\n"); 
		query.append(", TRF_GRP_SEQ" ).append("\n"); 
		query.append(", TRF_RT_SEQ" ).append("\n"); 
		query.append(", FT_OVR_DYS" ).append("\n"); 
		query.append(", FT_UND_DYS" ).append("\n"); 
		query.append(", CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append(", CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append(", CNTR_HC_RT_AMT" ).append("\n"); 
		query.append(", CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", UPD_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(", DMDT_TRF_CD" ).append("\n"); 
		query.append(",@[trf_seq]" ).append("\n"); 
		query.append(",@[trf_grp_seq]" ).append("\n"); 
		query.append(", TRF_RT_SEQ" ).append("\n"); 
		query.append(", FT_OVR_DYS" ).append("\n"); 
		query.append(", FT_UND_DYS" ).append("\n"); 
		query.append(", CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append(", CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append(", CNTR_HC_RT_AMT" ).append("\n"); 
		query.append(", CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[ofc_cd]" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[ofc_cd]" ).append("\n"); 
		query.append("FROM DMT_TRF_RT" ).append("\n"); 
		query.append("WHERE SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("AND DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND TRF_SEQ = @[from_trf_seq]" ).append("\n"); 
		query.append("AND TRF_GRP_SEQ = @[from_trf_grp_seq]" ).append("\n"); 

	}
}