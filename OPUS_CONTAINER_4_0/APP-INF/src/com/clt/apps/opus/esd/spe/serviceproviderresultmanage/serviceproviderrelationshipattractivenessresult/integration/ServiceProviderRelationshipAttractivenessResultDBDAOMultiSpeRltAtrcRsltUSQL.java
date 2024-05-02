/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ServiceProviderRelationshipAttractivenessResultDBDAOMultiSpeRltAtrcRsltUSQL.java
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

public class ServiceProviderRelationshipAttractivenessResultDBDAOMultiSpeRltAtrcRsltUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RA 결과 Update
	  * </pre>
	  */
	public ServiceProviderRelationshipAttractivenessResultDBDAOMultiSpeRltAtrcRsltUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration").append("\n"); 
		query.append("FileName : ServiceProviderRelationshipAttractivenessResultDBDAOMultiSpeRltAtrcRsltUSQL").append("\n"); 
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
		query.append("UPDATE SPE_RLT_ATRC_RSLT" ).append("\n"); 
		query.append("SET   ATRC_TO_HJS_SCRE  = TO_NUMBER(@[atrc_to_hjs_scre])" ).append("\n"); 
		query.append(", ATRC_TO_SP_SCRE   = TO_NUMBER(@[atrc_to_sp_scre])" ).append("\n"); 
		query.append(", RA_SCRE           = ROUND(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'HM' THEN" ).append("\n"); 
		query.append("SQRT(((TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)) + ((TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'EX' THEN" ).append("\n"); 
		query.append("SQRT(((TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)) + ((TO_NUMBER(@[atrc_to_sp_scre]))  * (TO_NUMBER(@[atrc_to_sp_scre]))))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'DV' THEN" ).append("\n"); 
		query.append("SQRT((TO_NUMBER(@[atrc_to_hjs_scre])   * TO_NUMBER(@[atrc_to_hjs_scre]) ) + ((TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'LM' THEN" ).append("\n"); 
		query.append("SQRT(((TO_NUMBER(@[atrc_to_hjs_scre]) )  * (TO_NUMBER(@[atrc_to_hjs_scre]) )) + ((TO_NUMBER(@[atrc_to_sp_scre]) )  * (TO_NUMBER(@[atrc_to_sp_scre]) )))" ).append("\n"); 
		query.append("END , 2)" ).append("\n"); 
		query.append(", RA_GRP_CD         = @[ra_grp_cd]" ).append("\n"); 
		query.append(", RA_GRP_NM         = @[ra_grp_nm]" ).append("\n"); 
		query.append(", UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHERE VNDR_SEQ  = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("AND EV_YR     = @[ev_yr]" ).append("\n"); 

	}
}