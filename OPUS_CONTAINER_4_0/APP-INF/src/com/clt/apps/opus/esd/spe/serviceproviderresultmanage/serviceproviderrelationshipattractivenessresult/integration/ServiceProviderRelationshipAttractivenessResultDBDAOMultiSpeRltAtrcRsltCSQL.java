/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ServiceProviderRelationshipAttractivenessResultDBDAOMultiSpeRltAtrcRsltCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceProviderRelationshipAttractivenessResultDBDAOMultiSpeRltAtrcRsltCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SR 결과 Insert
	  * </pre>
	  */
	public ServiceProviderRelationshipAttractivenessResultDBDAOMultiSpeRltAtrcRsltCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atrc_to_sp_scre",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atrc_to_hjs_scre",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration").append("\n"); 
		query.append("FileName : ServiceProviderRelationshipAttractivenessResultDBDAOMultiSpeRltAtrcRsltCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_RLT_ATRC_RSLT" ).append("\n"); 
		query.append("( VNDR_SEQ" ).append("\n"); 
		query.append(", EV_YR" ).append("\n"); 
		query.append(", ATRC_TO_HJS_SCRE" ).append("\n"); 
		query.append(", ATRC_TO_SP_SCRE" ).append("\n"); 
		query.append(", RA_SCRE" ).append("\n"); 
		query.append(", RA_GRP_CD" ).append("\n"); 
		query.append(", RA_GRP_NM" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (    TO_NUMBER(@[vndr_seq]) 				          -- VNDR_SEQ" ).append("\n"); 
		query.append(", @[ev_yr]							          -- EV_YR" ).append("\n"); 
		query.append(", TO_NUMBER(@[atrc_to_hjs_scre]) 			  -- ATRC_TO_HJS_SCRE" ).append("\n"); 
		query.append(", TO_NUMBER(@[atrc_to_sp_scre]) 				  -- ATRC_TO_SP_SCRE" ).append("\n"); 
		query.append(",ROUND(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'HM' THEN" ).append("\n"); 
		query.append("SQRT(((TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)) + ((TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'EX' THEN" ).append("\n"); 
		query.append("SQRT(((TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)) + ((TO_NUMBER(@[atrc_to_sp_scre]))  * (TO_NUMBER(@[atrc_to_sp_scre]))))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'DV' THEN" ).append("\n"); 
		query.append("SQRT((TO_NUMBER(@[atrc_to_hjs_scre])   * TO_NUMBER(@[atrc_to_hjs_scre]) ) + ((TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'LM' THEN" ).append("\n"); 
		query.append("SQRT(((TO_NUMBER(@[atrc_to_hjs_scre]) )  * (TO_NUMBER(@[atrc_to_hjs_scre]) )) + ((TO_NUMBER(@[atrc_to_sp_scre]) )  * (TO_NUMBER(@[atrc_to_sp_scre]) )))" ).append("\n"); 
		query.append("END , 2)                        --RA_SCRE" ).append("\n"); 
		query.append(",  @[ra_grp_cd] 				            -- RA_GRP_CD" ).append("\n"); 
		query.append(",  @[ra_grp_nm] 				            -- RA_GRP_NM" ).append("\n"); 
		query.append(",  @[cre_usr_id] 				        -- CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE 			                    -- CRE_DT" ).append("\n"); 
		query.append(",  @[upd_usr_id] 				        -- UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE 			                    -- UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}