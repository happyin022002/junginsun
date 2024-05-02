/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOBasicRegisterDBDAOSearchRevenueVvdInquiryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDBDAOSearchRevenueVvdInquiryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue Vvd Inquiry
	  * </pre>
	  */
	public TCharterIOBasicRegisterDBDAOSearchRevenueVvdInquiryListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDBDAOSearchRevenueVvdInquiryListVORSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , REV_DIR_CD" ).append("\n"); 
		query.append("     , REV_YRMON" ).append("\n"); 
		query.append("     , SLAN_CD" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , VST_DT" ).append("\n"); 
		query.append("     , VED_DT" ).append("\n"); 
		query.append("     , VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("  FROM FMS_VVD" ).append("\n"); 
		query.append(" WHERE REV_YRMON BETWEEN @[rev_yrmon_from] AND @[rev_yrmon_to]" ).append("\n"); 
		query.append("   AND SLAN_CD like @[slan_cd]||'%'" ).append("\n"); 
		query.append("   AND RLANE_CD like @[rlane_cd]||'%'" ).append("\n"); 
		query.append(" ORDER BY VSL_CD||SKD_VOY_NO" ).append("\n"); 
		query.append("     , REV_YRMON" ).append("\n"); 
		query.append("     , VST_DT" ).append("\n"); 

	}
}