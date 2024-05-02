/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationDBDAOPriTrfBzcPublishUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffGeneralInformationDBDAOPriTrfBzcPublishUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff General Information 정보를 Publish하여 현재-1 seq의 Expiration Date를 현재 seq의 Effective Data -1로 Update 한다.
	  * </pre>
	  */
	public TariffGeneralInformationDBDAOPriTrfBzcPublishUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.integration").append("\n"); 
		query.append("FileName : TariffGeneralInformationDBDAOPriTrfBzcPublishUSQL").append("\n"); 
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
		query.append("UPDATE  PRI_TRF_BZC" ).append("\n"); 
		query.append("   SET  EXP_DT         = TO_DATE(@[eff_dt], 'YYYYMMDD') - 1" ).append("\n"); 
		query.append("       ,UPD_USR_ID     = @[upd_usr_id]       " ).append("\n"); 
		query.append("       ,UPD_DT         = SYSDATE" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND  TRF_NO     = @[trf_no]" ).append("\n"); 
		query.append("   AND  AMDT_SEQ   = @[amdt_seq] - 1" ).append("\n"); 
		query.append("   AND  (EXP_DT     > TO_DATE(@[eff_dt], 'YYYYMMDD') - 1" ).append("\n"); 
		query.append("    OR   EXP_DT     IS NULL)" ).append("\n"); 

	}
}